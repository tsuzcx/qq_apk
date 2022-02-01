package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  private long cuE;
  private String jHQ;
  private boolean lsn = false;
  private c mjc;
  private List<a> mjf = new ArrayList();
  private List<a> mjg = new ArrayList();
  private String mjh;
  private String mji;
  private VideoTransPara mjj;
  private long mjk;
  private int mjl = -1;
  private int mjm = -1;
  
  private void b(c paramc)
  {
    int j = paramc.jvU.getTrackCount();
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
        this.mjg.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.mjf.add(new a(localMediaFormat, i));
        }
      }
    }
    Log.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.mjg.size()), Integer.valueOf(this.mjf.size()) });
  }
  
  private int brl()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.mjg != null)
    {
      i = j;
      if (this.mjg.size() != 0)
      {
        localIterator = this.mjg.iterator();
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
      if (this.mjf != null)
      {
        j = i;
        if (this.mjf.size() != 0)
        {
          localIterator = this.mjf.iterator();
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
  
  public abstract int Yw(String paramString);
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  public int aj(long paramLong1, long paramLong2)
  {
    if (!this.lsn)
    {
      Log.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.cuE = l;
    MediaFormat localMediaFormat = ((a)this.mjf.get(0)).mediaFormat;
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
    this.mjk = paramLong1;
    return a(this.mjc, this.mjg, this.mjf);
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    Log.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = Util.currentTicks();
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    q localq = new q(paramString1);
    new q(paramString2);
    if ((!localq.ifC()) || (localq.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.mjh = paramString1;
    this.mji = paramString2;
    this.mjj = paramVideoTransPara;
    this.mjc = new c();
    this.mjc.setDataSource(paramString1);
    b(this.mjc);
    if ((this.mjf == null) || (this.mjf.size() == 0)) {
      throw new p("Can not find video or audio track in this video file.");
    }
    this.mjl = brl();
    this.mjm = Yw(paramString1);
    this.lsn = true;
    Log.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
  }
  
  protected final String brm()
  {
    if (this.jHQ == null) {
      this.jHQ = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.jHQ;
  }
  
  protected final VideoTransPara eTQ()
  {
    return this.mjj;
  }
  
  public final String eTR()
  {
    return this.mji;
  }
  
  public final String eTS()
  {
    return this.mjh;
  }
  
  public final int eTT()
  {
    return this.mjl;
  }
  
  public final int eTU()
  {
    return this.mjm;
  }
  
  public final long getEndTimeMs()
  {
    return this.mjk;
  }
  
  public final long getStartTimeMs()
  {
    return this.cuE;
  }
  
  public final void release()
  {
    this.lsn = false;
    if (this.mjc != null) {
      this.mjc.jvU.release();
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