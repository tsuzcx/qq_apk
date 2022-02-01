package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  long ccV;
  private String fMx;
  int hBA = -1;
  int hBB = -1;
  private boolean hBC = false;
  private c hBr;
  private List<a> hBu = new ArrayList();
  private List<a> hBv = new ArrayList();
  String hBw;
  String hBx;
  VideoTransPara hBy;
  long hBz;
  
  private int aDk()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.hBv != null)
    {
      i = j;
      if (this.hBv.size() != 0)
      {
        localIterator = this.hBv.iterator();
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
      if (this.hBu != null)
      {
        j = i;
        if (this.hBu.size() != 0)
        {
          localIterator = this.hBu.iterator();
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
    int j = paramc.fGK.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramc.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bt.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        ad.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label108;
        }
        this.hBv.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.hBu.add(new a(localMediaFormat, i));
        }
      }
    }
    ad.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.hBv.size()), Integer.valueOf(this.hBu.size()) });
  }
  
  public abstract int Ar(String paramString);
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  protected final String aDl()
  {
    if (this.fMx == null) {
      this.fMx = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.fMx;
  }
  
  public int aa(long paramLong1, long paramLong2)
  {
    if (!this.hBC)
    {
      ad.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.ccV = l;
    MediaFormat localMediaFormat = ((a)this.hBu.get(0)).mediaFormat;
    if (!localMediaFormat.containsKey("durationUs")) {
      throw new p("Can not find duration.");
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
    this.hBz = paramLong1;
    return a(this.hBr, this.hBv, this.hBu);
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    ad.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bt.GC();
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    e locale = new e(paramString1);
    new e(paramString2);
    if ((!locale.canRead()) || (locale.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.hBw = paramString1;
    this.hBx = paramString2;
    this.hBy = paramVideoTransPara;
    this.hBr = new c();
    this.hBr.px(paramString1);
    b(this.hBr);
    if ((this.hBu == null) || (this.hBu.size() == 0)) {
      throw new p("Can not find video or audio track in this video file.");
    }
    this.hBA = aDk();
    this.hBB = Ar(paramString1);
    this.hBC = true;
    ad.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bt.aS(l)) });
  }
  
  public final void release()
  {
    this.hBC = false;
    if (this.hBr != null) {
      this.hBr.fGK.release();
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