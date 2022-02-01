package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Asset<Track extends AssetTrack>
  implements AsynchronousKeyValueLoading
{
  public static final String TAG = "Asset";
  private boolean canContainFragments;
  private boolean composable;
  private boolean containsFragments;
  private CMTime duration = CMTime.CMTimeZero;
  private boolean exportable;
  protected AssetExtractor extractor;
  private int extractorRetryCount = 3;
  private boolean hasProtectedContent;
  private String lyrics;
  private MediaFormat mediaFormat;
  private int mirror = 0;
  protected CGSize naturalSize;
  private CMTime overallDurationHint;
  private boolean playable;
  protected int preferRotation = 0;
  private float preferredRate = 1.0F;
  private Matrix preferredTransform;
  protected float preferredVolume = 1.0F;
  private boolean providesPreciseDurationAndTiming;
  private boolean readable;
  protected int trackCount = 0;
  protected int trackIndex = 0;
  protected List<Track> tracks;
  
  protected Asset() {}
  
  protected Asset(String paramString)
  {
    this.extractor = new AssetExtractor();
    this.extractor.setDataSource(paramString);
    tryInitMembers();
    createTracks();
  }
  
  protected Asset(URL paramURL) {}
  
  private void initMembers()
  {
    this.trackCount = this.extractor.getTrackCount();
    this.duration = getDuration();
    this.naturalSize = ExtractorUtils.getVideoSize(this.extractor);
    this.preferRotation = ExtractorUtils.getPreferRotation(this.extractor);
    if (this.preferRotation != 0)
    {
      this.preferredTransform = new Matrix();
      while (this.preferRotation < 0) {
        this.preferRotation += 4;
      }
      this.preferRotation %= 4;
      DecoderUtils.getRotationMatrix(this.preferredTransform, this.preferRotation, this.naturalSize.width, this.naturalSize.height);
    }
  }
  
  private void tryInitMembers()
  {
    int i = this.extractorRetryCount;
    this.extractorRetryCount = (i - 1);
    if (i <= 0) {
      return;
    }
    try
    {
      initMembers();
      Logger.v("Asset", "tryInitMembers: try count = " + (3 - this.extractorRetryCount));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("Asset", "Asset: initMembers failed, path = " + getSourcePath(), localException);
        trySleep(100);
        tryInitMembers();
      }
    }
  }
  
  private void trySleep(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("Asset", "tryInitMembers: Thread.sleep(100) ", localException);
    }
  }
  
  public void cancelLoading() {}
  
  @TargetApi(16)
  protected void createTracks()
  {
    int j = this.extractor.getTrackCount();
    if (this.tracks == null) {
      this.tracks = new ArrayList();
    }
    int i = 0;
    if (i < j)
    {
      Object localObject = this.extractor.getTrackFormat(i).getString("mime");
      int k;
      if (((String)localObject).startsWith("video/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new AssetTrack(this, k, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
        ((AssetTrack)localObject).setPreferredTransform(this.preferredTransform);
        ((AssetTrack)localObject).setPreferredRotation(this.preferRotation);
        this.tracks.add(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject).startsWith("audio/"))
        {
          k = this.trackIndex;
          this.trackIndex = (k + 1);
          localObject = new AssetTrack(this, k, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
          ((AssetTrack)localObject).setPreferredVolume(this.preferredVolume);
          this.tracks.add(localObject);
        }
      }
    }
    Logger.d("Asset", "Asset createTracks finish, has track count: " + this.tracks);
  }
  
  protected CMTime getAudioDuration()
  {
    return TimeUtil.us2CMTime(this.extractor.getAudioDuration());
  }
  
  public CMTime getDuration()
  {
    try
    {
      if ((this.duration == null) || (this.duration.equalsTo(CMTime.CMTimeZero)))
      {
        CMTime localCMTime2 = getVideoDuration();
        localCMTime1 = localCMTime2;
        if (CMTime.CMTimeZero.equalsTo(localCMTime2)) {
          localCMTime1 = getAudioDuration();
        }
        this.duration = localCMTime1;
      }
      CMTime localCMTime1 = this.duration;
      return localCMTime1;
    }
    finally {}
  }
  
  public AssetExtractor getExtractor()
  {
    try
    {
      AssetExtractor localAssetExtractor = this.extractor;
      return localAssetExtractor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLyrics()
  {
    return this.lyrics;
  }
  
  public MediaFormat getMediaFormat()
  {
    return this.mediaFormat;
  }
  
  public CGSize getNaturalSize()
  {
    return this.naturalSize;
  }
  
  public CMTime getOverallDurationHint()
  {
    return this.overallDurationHint;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public float getPreferredRate()
  {
    return this.preferredRate;
  }
  
  public Matrix getPreferredTransform()
  {
    return this.preferredTransform;
  }
  
  public float getPreferredVolume()
  {
    return this.preferredVolume;
  }
  
  /* Error */
  public String getSourcePath()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/tav/asset/Asset:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 76	com/tencent/tav/asset/Asset:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   13: invokevirtual 280	com/tencent/tav/extractor/AssetExtractor:getSourcePath	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	Asset
    //   16	7	1	str	String
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int getTrackCount()
  {
    return this.trackCount;
  }
  
  /* Error */
  public MediaFormat getTrackFormat(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/tav/asset/Asset:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 76	com/tencent/tav/asset/Asset:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   13: iload_1
    //   14: invokevirtual 187	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: aconst_null
    //   23: astore_2
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	Asset
    //   0	32	1	paramInt	int
    //   17	7	2	localMediaFormat	MediaFormat
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	27	finally
  }
  
  public List<Track> getTracks()
  {
    new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
    return this.tracks;
  }
  
  protected CMTime getVideoDuration()
  {
    return TimeUtil.us2CMTime(this.extractor.getDuration());
  }
  
  public boolean isCanContainFragments()
  {
    return this.canContainFragments;
  }
  
  public boolean isComposable()
  {
    return this.composable;
  }
  
  public boolean isContainsFragments()
  {
    return this.containsFragments;
  }
  
  public boolean isExportable()
  {
    return this.exportable;
  }
  
  public boolean isHasProtectedContent()
  {
    return this.hasProtectedContent;
  }
  
  public boolean isPlayable()
  {
    return this.playable;
  }
  
  public boolean isProvidesPreciseDurationAndTiming()
  {
    return this.providesPreciseDurationAndTiming;
  }
  
  public boolean isReadable()
  {
    return this.readable;
  }
  
  public void selectTrack(int paramInt)
  {
    try
    {
      if (this.extractor != null) {
        this.extractor.selectTrack(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AssetTrack trackWithTrackID(int paramInt)
  {
    if (this.tracks != null)
    {
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if ((localAssetTrack != null) && (localAssetTrack.getTrackID() == paramInt)) {
          return localAssetTrack;
        }
      }
    }
    return null;
  }
  
  public List<AssetTrack> tracksWithMediaCharacteristic(String paramString)
  {
    return null;
  }
  
  public List<AssetTrack> tracksWithMediaType(int paramInt)
  {
    if (this.tracks != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if ((localAssetTrack != null) && (localAssetTrack.getMediaType() == paramInt)) {
          localArrayList.add(localAssetTrack);
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.asset.Asset
 * JD-Core Version:    0.7.0.1
 */