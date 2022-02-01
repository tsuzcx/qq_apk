package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a
  implements f
{
  private long emw;
  private String mhx;
  private boolean ojM = false;
  private List<a> pcC = new ArrayList();
  private List<a> pcD = new ArrayList();
  private String pcE;
  private String pcF;
  private VideoTransPara pcG;
  private long pcH;
  private int pcI = -1;
  private int pcJ = -1;
  private c pcz;
  
  private void b(c paramc)
  {
    int j = paramc.lZm.getTrackCount();
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
        this.pcD.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.pcC.add(new a(localMediaFormat, i));
        }
      }
    }
    Log.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.pcD.size()), Integer.valueOf(this.pcC.size()) });
  }
  
  private int bOR()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.pcD != null)
    {
      i = j;
      if (this.pcD.size() != 0)
      {
        localIterator = this.pcD.iterator();
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
      if (this.pcC != null)
      {
        j = i;
        if (this.pcC.size() != 0)
        {
          localIterator = this.pcC.iterator();
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
  
  public abstract int QB(String paramString);
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  public int aS(long paramLong1, long paramLong2)
  {
    if (!this.ojM)
    {
      Log.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.emw = l;
    MediaFormat localMediaFormat = ((a)this.pcC.get(0)).mediaFormat;
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
    this.pcH = paramLong1;
    return a(this.pcz, this.pcD, this.pcC);
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    Log.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = Util.currentTicks();
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    u localu = new u(paramString1);
    new u(paramString2);
    if ((!localu.jKQ()) || (localu.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.pcE = paramString1;
    this.pcF = paramString2;
    this.pcG = paramVideoTransPara;
    this.pcz = new c();
    this.pcz.setDataSource(paramString1);
    b(this.pcz);
    if ((this.pcC == null) || (this.pcC.size() == 0)) {
      throw new p("Can not find video or audio track in this video file.");
    }
    this.pcI = bOR();
    this.pcJ = QB(paramString1);
    this.ojM = true;
    Log.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
  }
  
  protected final String bOS()
  {
    if (this.mhx == null) {
      this.mhx = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.mhx;
  }
  
  protected final VideoTransPara gcI()
  {
    return this.pcG;
  }
  
  public final String gcJ()
  {
    return this.pcF;
  }
  
  public final String gcK()
  {
    return this.pcE;
  }
  
  public final int gcL()
  {
    return this.pcI;
  }
  
  public final int gcM()
  {
    return this.pcJ;
  }
  
  public final long getEndTimeMs()
  {
    return this.pcH;
  }
  
  public final long getStartTimeMs()
  {
    return this.emw;
  }
  
  public final void release()
  {
    this.ojM = false;
    if (this.pcz != null) {
      this.pcz.lZm.release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */