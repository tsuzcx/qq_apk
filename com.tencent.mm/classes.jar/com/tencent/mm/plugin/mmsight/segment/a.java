package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  long bZS;
  private String fQj;
  private c ibS;
  private List<a> ibV = new ArrayList();
  private List<a> ibW = new ArrayList();
  String ibX;
  String ibY;
  VideoTransPara ibZ;
  long ica;
  int icb = -1;
  int icc = -1;
  private boolean icd = false;
  
  private int aKb()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.ibW != null)
    {
      i = j;
      if (this.ibW.size() != 0)
      {
        localIterator = this.ibW.iterator();
        i = -1;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (!locala.mediaFormat.containsKey("max-input-size")) {
            break label179;
          }
          i = Math.max(locala.mediaFormat.getInteger("max-input-size"), i);
        }
      }
    }
    label176:
    label179:
    for (;;)
    {
      break;
      j = i;
      if (this.ibV != null)
      {
        j = i;
        if (this.ibV.size() != 0)
        {
          localIterator = this.ibV.iterator();
          if (localIterator.hasNext())
          {
            locala = (a)localIterator.next();
            if (!locala.mediaFormat.containsKey("max-input-size")) {
              break label176;
            }
            i = Math.max(locala.mediaFormat.getInteger("max-input-size"), i);
          }
        }
      }
      for (;;)
      {
        break;
        j = i;
        return j;
      }
    }
  }
  
  private void b(c paramc)
  {
    int j = paramc.fKr.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramc.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bs.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        ac.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label108;
        }
        this.ibW.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.ibV.add(new a(localMediaFormat, i));
        }
      }
    }
    ac.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.ibW.size()), Integer.valueOf(this.ibV.size()) });
  }
  
  public abstract int Ew(String paramString);
  
  public int X(long paramLong1, long paramLong2)
  {
    if (!this.icd)
    {
      ac.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.bZS = l;
    MediaFormat localMediaFormat = ((a)this.ibV.get(0)).mediaFormat;
    if (!localMediaFormat.containsKey("durationUs")) {
      throw new o("Can not find duration.");
    }
    if (paramLong2 > 0L)
    {
      paramLong1 = paramLong2;
      if (paramLong2 <= localMediaFormat.getLong("durationUs") / 1000L) {}
    }
    else
    {
      paramLong1 = localMediaFormat.getLong("durationUs") / 1000L;
    }
    this.ica = paramLong1;
    return a(this.ibS, this.ibW, this.ibV);
  }
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  protected final String aKc()
  {
    if (this.fQj == null) {
      this.fQj = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.fQj;
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    ac.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bs.Gn();
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    e locale = new e(paramString1);
    new e(paramString2);
    if ((!locale.canRead()) || (locale.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.ibX = paramString1;
    this.ibY = paramString2;
    this.ibZ = paramVideoTransPara;
    this.ibS = new c();
    this.ibS.sI(paramString1);
    b(this.ibS);
    if ((this.ibV == null) || (this.ibV.size() == 0)) {
      throw new o("Can not find video or audio track in this video file.");
    }
    this.icb = aKb();
    this.icc = Ew(paramString1);
    this.icd = true;
    ac.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bs.aO(l)) });
  }
  
  public final void release()
  {
    this.icd = false;
    if (this.ibS != null) {
      this.ibS.fKr.release();
    }
  }
  
  final class a
  {
    int index;
    MediaFormat mediaFormat;
    
    a(MediaFormat paramMediaFormat, int paramInt)
    {
      this.mediaFormat = paramMediaFormat;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */