package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  long cwj;
  private String gWS;
  private boolean iCs = false;
  private List<a> jtB = new ArrayList();
  private List<a> jtC = new ArrayList();
  String jtD;
  String jtE;
  VideoTransPara jtF;
  long jtG;
  int jtH = -1;
  int jtI = -1;
  private c jty;
  
  private void b(c paramc)
  {
    int j = paramc.gLF.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramc.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!Util.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        Log.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label108;
        }
        this.jtC.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.jtB.add(new a(localMediaFormat, i));
        }
      }
    }
    Log.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.jtC.size()), Integer.valueOf(this.jtB.size()) });
  }
  
  private int bhN()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.jtC != null)
    {
      i = j;
      if (this.jtC.size() != 0)
      {
        localIterator = this.jtC.iterator();
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
      if (this.jtB != null)
      {
        j = i;
        if (this.jtB.size() != 0)
        {
          localIterator = this.jtB.iterator();
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
  
  public abstract int QZ(String paramString);
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  public int ab(long paramLong1, long paramLong2)
  {
    if (!this.iCs)
    {
      Log.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.cwj = l;
    MediaFormat localMediaFormat = ((a)this.jtB.get(0)).mediaFormat;
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
    this.jtG = paramLong1;
    return a(this.jty, this.jtC, this.jtB);
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    Log.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = Util.currentTicks();
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(paramString1);
    new com.tencent.mm.vfs.o(paramString2);
    if ((!localo.canRead()) || (localo.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.jtD = paramString1;
    this.jtE = paramString2;
    this.jtF = paramVideoTransPara;
    this.jty = new c();
    this.jty.setDataSource(paramString1);
    b(this.jty);
    if ((this.jtB == null) || (this.jtB.size() == 0)) {
      throw new o("Can not find video or audio track in this video file.");
    }
    this.jtH = bhN();
    this.jtI = QZ(paramString1);
    this.iCs = true;
    Log.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
  }
  
  protected final String bhO()
  {
    if (this.gWS == null) {
      this.gWS = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.gWS;
  }
  
  public final void release()
  {
    this.iCs = false;
    if (this.jty != null) {
      this.jty.gLF.release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */