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
  long ckk;
  private String gjJ;
  private c ivo;
  private List<a> ivr = new ArrayList();
  private List<a> ivs = new ArrayList();
  String ivt;
  String ivu;
  VideoTransPara ivv;
  long ivw;
  int ivx = -1;
  int ivy = -1;
  private boolean ivz = false;
  
  private int aNk()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.ivs != null)
    {
      i = j;
      if (this.ivs.size() != 0)
      {
        localIterator = this.ivs.iterator();
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
      if (this.ivr != null)
      {
        j = i;
        if (this.ivr.size() != 0)
        {
          localIterator = this.ivr.iterator();
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
    int j = paramc.gdS.getTrackCount();
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
        this.ivs.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if (str.startsWith("video/")) {
          this.ivr.add(new a(localMediaFormat, i));
        }
      }
    }
    ad.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.ivs.size()), Integer.valueOf(this.ivr.size()) });
  }
  
  public abstract int HL(String paramString);
  
  public int Y(long paramLong1, long paramLong2)
  {
    if (!this.ivz)
    {
      ad.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.ckk = l;
    MediaFormat localMediaFormat = ((a)this.ivr.get(0)).mediaFormat;
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
    this.ivw = paramLong1;
    return a(this.ivo, this.ivs, this.ivr);
  }
  
  protected int a(c paramc, List<a> paramList1, List<a> paramList2)
  {
    return 0;
  }
  
  protected final String aNl()
  {
    if (this.gjJ == null) {
      this.gjJ = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.gjJ;
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    ad.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bt.HI();
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    e locale = new e(paramString1);
    new e(paramString2);
    if ((!locale.canRead()) || (locale.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.ivt = paramString1;
    this.ivu = paramString2;
    this.ivv = paramVideoTransPara;
    this.ivo = new c();
    this.ivo.vx(paramString1);
    b(this.ivo);
    if ((this.ivr == null) || (this.ivr.size() == 0)) {
      throw new o("Can not find video or audio track in this video file.");
    }
    this.ivx = aNk();
    this.ivy = HL(paramString1);
    this.ivz = true;
    ad.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bt.aO(l)) });
  }
  
  public final void release()
  {
    this.ivz = false;
    if (this.ivo != null) {
      this.ivo.gdS.release();
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