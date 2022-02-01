package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  long ckm;
  private String gmc;
  private c iyh;
  private List<a> iyk = new ArrayList();
  private List<a> iyl = new ArrayList();
  String iym;
  String iyn;
  VideoTransPara iyo;
  long iyp;
  int iyq = -1;
  int iyr = -1;
  private boolean iys = false;
  
  private int aNI()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.iyl != null)
    {
      i = j;
      if (this.iyl.size() != 0)
      {
        localIterator = this.iyl.iterator();
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
      if (this.iyk != null)
      {
        j = i;
        if (this.iyk.size() != 0)
        {
          localIterator = this.iyk.iterator();
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
    int j = paramc.gga.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramc.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bu.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        ae.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label108;
        }
        this.iyl.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.iyk.add(new a(localMediaFormat, i));
        }
      }
    }
    ae.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.iyl.size()), Integer.valueOf(this.iyk.size()) });
  }
  
  public abstract int In(String paramString);
  
  public int X(long paramLong1, long paramLong2)
  {
    if (!this.iys)
    {
      ae.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.ckm = l;
    MediaFormat localMediaFormat = ((a)this.iyk.get(0)).mediaFormat;
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
    this.iyp = paramLong1;
    return a(this.iyh, this.iyl, this.iyk);
  }
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  protected final String aNJ()
  {
    if (this.gmc == null) {
      this.gmc = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.gmc;
  }
  
  public void c(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    ae.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bu.HQ();
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    k localk = new k(paramString1);
    new k(paramString2);
    if ((!localk.canRead()) || (localk.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.iym = paramString1;
    this.iyn = paramString2;
    this.iyo = paramVideoTransPara;
    this.iyh = new c();
    this.iyh.vT(paramString1);
    b(this.iyh);
    if ((this.iyk == null) || (this.iyk.size() == 0)) {
      throw new o("Can not find video or audio track in this video file.");
    }
    this.iyq = aNI();
    this.iyr = In(paramString1);
    this.iys = true;
    ae.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bu.aO(l)) });
  }
  
  public final void release()
  {
    this.iys = false;
    if (this.iyh != null) {
      this.iyh.gga.release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */