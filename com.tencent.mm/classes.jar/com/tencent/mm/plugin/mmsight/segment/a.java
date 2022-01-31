package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a
  implements f
{
  private String ewk;
  private List<a.a> fYG = new ArrayList();
  private List<a.a> fYH = new ArrayList();
  String fYI;
  String fYJ;
  VideoTransPara fYK;
  long fYL;
  long fYM;
  int fYN = -1;
  private boolean isInited = false;
  private MediaExtractor mMediaExtractor;
  int mRotationDegree = -1;
  
  private void a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bo.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        ab.i("BaseMediaCodecClipper", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label105;
        }
        this.fYH.add(new a.a(this, localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label105:
        if (str.startsWith("video/")) {
          this.fYG.add(new a.a(this, localMediaFormat, i));
        }
      }
    }
    ab.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.fYH.size()), Integer.valueOf(this.fYG.size()) });
  }
  
  private int amf()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    a.a locala;
    if (this.fYH != null)
    {
      i = j;
      if (this.fYH.size() != 0)
      {
        localIterator = this.fYH.iterator();
        i = -1;
        if (localIterator.hasNext())
        {
          locala = (a.a)localIterator.next();
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
      if (this.fYG != null)
      {
        j = i;
        if (this.fYG.size() != 0)
        {
          localIterator = this.fYG.iterator();
          if (localIterator.hasNext())
          {
            locala = (a.a)localIterator.next();
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
  
  public int Q(long paramLong1, long paramLong2)
  {
    if (!this.isInited)
    {
      ab.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
      throw new IllegalStateException("Please init this component first.");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    this.fYL = l;
    MediaFormat localMediaFormat = ((a.a)this.fYG.get(0)).mediaFormat;
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
    this.fYM = paramLong1;
    return a(this.mMediaExtractor, this.fYH, this.fYG);
  }
  
  protected int a(MediaExtractor paramMediaExtractor, List<a.a> paramList1, List<a.a> paramList2)
  {
    return 0;
  }
  
  protected final String amg()
  {
    if (this.ewk == null) {
      this.ewk = (CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4");
    }
    return this.ewk;
  }
  
  public void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    ab.d("BaseMediaCodecClipper", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bo.yB();
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramVideoTransPara == null)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
    }
    b localb = new b(paramString1);
    new b(paramString2);
    if ((!localb.canRead()) || (localb.length() == 0L)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
    }
    this.fYI = paramString1;
    this.fYJ = paramString2;
    this.fYK = paramVideoTransPara;
    this.mMediaExtractor = new MediaExtractor();
    this.mMediaExtractor.setDataSource(paramString1);
    a(this.mMediaExtractor);
    if ((this.fYG == null) || (this.fYG.size() == 0)) {
      throw new p("Can not find video or audio track in this video file.");
    }
    this.fYN = amf();
    this.mRotationDegree = vE(paramString1);
    this.isInited = true;
    ab.e("BaseMediaCodecClipper", "init cost time %dms", new Object[] { Long.valueOf(bo.av(l)) });
  }
  
  public final void release()
  {
    this.isInited = false;
    if (this.mMediaExtractor != null) {
      this.mMediaExtractor.release();
    }
  }
  
  public abstract int vE(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a
 * JD-Core Version:    0.7.0.1
 */