package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  private List<a.a> eJa = new ArrayList();
  private List<a.a> eJb = new ArrayList();
  String eJc;
  String eJd;
  private String eJe;
  VideoTransPara eJf;
  long eJg;
  long eJh;
  int eJi = -1;
  int eJj = -1;
  private boolean isInited = false;
  private MediaExtractor mMediaExtractor;
  
  private int SU()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a.a locala;
    if (this.eJb != null)
    {
      i = j;
      if (this.eJb.size() != 0)
      {
        localIterator = this.eJb.iterator();
        i = -1;
        if (localIterator.hasNext())
        {
          locala = (a.a)localIterator.next();
          if (!locala.eIG.containsKey("max-input-size")) {
            break label179;
          }
          i = Math.max(locala.eIG.getInteger("max-input-size"), i);
        }
      }
    }
    label176:
    label179:
    for (;;)
    {
      break;
      j = i;
      if (this.eJa != null)
      {
        j = i;
        if (this.eJa.size() != 0)
        {
          localIterator = this.eJa.iterator();
          if (localIterator.hasNext())
          {
            locala = (a.a)localIterator.next();
            if (!locala.eIG.containsKey("max-input-size")) {
              break label176;
            }
            i = Math.max(locala.eIG.getInteger("max-input-size"), i);
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
  
  private void a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bk.bl(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        y.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label105;
        }
        this.eJb.add(new a.a(this, localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label105:
        if (str.startsWith("video/")) {
          this.eJa.add(new a.a(this, localMediaFormat, i));
        }
      }
    }
    y.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.eJb.size()), Integer.valueOf(this.eJa.size()) });
  }
  
  public int E(long paramLong1, long paramLong2)
  {
    if (!this.isInited)
    {
      y.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.eJg = l;
    MediaFormat localMediaFormat = ((a.a)this.eJa.get(0)).eIG;
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
    this.eJh = paramLong1;
    return a(this.mMediaExtractor, this.eJb, this.eJa);
  }
  
  protected final String SV()
  {
    if (this.eJe == null) {
      this.eJe = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.eJe;
  }
  
  protected int a(MediaExtractor paramMediaExtractor, List<a.a> paramList1, List<a.a> paramList2)
  {
    return 0;
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    y.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bk.UZ();
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    b localb = new b(paramString1);
    new b(paramString2);
    if ((!localb.canRead()) || (localb.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.eJc = paramString1;
    this.eJd = paramString2;
    this.eJf = paramVideoTransPara;
    this.mMediaExtractor = new MediaExtractor();
    this.mMediaExtractor.setDataSource(paramString1);
    a(this.mMediaExtractor);
    if ((this.eJa == null) || (this.eJa.size() == 0)) {
      throw new p("Can not find video or audio track in this video file.");
    }
    this.eJi = SU();
    this.eJj = oq(paramString1);
    this.isInited = true;
    y.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bk.cp(l)) });
  }
  
  public abstract int oq(String paramString);
  
  public final void release()
  {
    this.isInited = false;
    if (this.mMediaExtractor != null) {
      this.mMediaExtractor.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */