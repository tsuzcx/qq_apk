package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class AudioExportTask
  implements IAudioExportTask
{
  private static final String TAG = "AudioEncoderTask";
  private IAudioSource<? extends IDecoderTrack> mAsset;
  private ExportCallback mCallback;
  private List<AudioExportRunner> mEncoderList;
  private String mOutSavePath;
  private HashMap<Integer, SegmentStatus> mProgressMap;
  private int mSegmentCount;
  private String mSessionId;
  
  public AudioExportTask(IAudioSource<? extends IDecoderTrack> paramIAudioSource, String paramString)
  {
    AppMethodBeat.i(214651);
    this.mSegmentCount = 0;
    this.mSessionId = new Random().nextLong();
    this.mEncoderList = new ArrayList();
    this.mProgressMap = new HashMap();
    this.mAsset = paramIAudioSource;
    this.mOutSavePath = paramString;
    AppMethodBeat.o(214651);
  }
  
  public AudioExportTask(String paramString)
  {
    AppMethodBeat.i(214652);
    this.mSegmentCount = 0;
    this.mSessionId = new Random().nextLong();
    this.mEncoderList = new ArrayList();
    this.mProgressMap = new HashMap();
    this.mOutSavePath = paramString;
    AppMethodBeat.o(214652);
  }
  
  private SegmentStatus createOrUpdateSegmentStatus(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(214659);
    Logger.d("AudioEncoderTask", "createOrUpdateSegmentStatus index = " + paramInt1 + " mStatus = " + paramInt2 + " mProgress = " + paramFloat);
    SegmentStatus localSegmentStatus;
    if (this.mProgressMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localSegmentStatus = (SegmentStatus)this.mProgressMap.get(Integer.valueOf(paramInt1));
      SegmentStatus.access$302(localSegmentStatus, paramFloat);
      SegmentStatus.access$402(localSegmentStatus, paramInt2);
    }
    for (;;)
    {
      AppMethodBeat.o(214659);
      return localSegmentStatus;
      localSegmentStatus = new SegmentStatus(paramInt2, paramFloat);
      this.mProgressMap.put(Integer.valueOf(paramInt1), localSegmentStatus);
    }
  }
  
  private SegmentStatus createSegmentStatus(int paramInt, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214658);
    SegmentStatus localSegmentStatus = new SegmentStatus(0, 0.0F);
    SegmentStatus.access$002(localSegmentStatus, paramCMTimeRange);
    this.mProgressMap.put(Integer.valueOf(paramInt), localSegmentStatus);
    AppMethodBeat.o(214658);
    return localSegmentStatus;
  }
  
  private void exportAudio(CMTimeRange paramCMTimeRange, final int paramInt)
  {
    AppMethodBeat.i(214655);
    Logger.d("AudioEncoderTask", "exportAudio timeRange = " + paramCMTimeRange + " index = " + paramInt);
    paramCMTimeRange = new AudioExportRunner(this.mAsset, paramCMTimeRange);
    paramCMTimeRange.setSavePath(EncoderUtils.getAudioOutSaveFilePath(this.mOutSavePath, paramInt, this.mSessionId));
    paramCMTimeRange.setCallback(new ExportCallback()
    {
      public void onProgress(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(214650);
        synchronized (AudioExportTask.this)
        {
          AudioExportTask.access$100(AudioExportTask.this, paramInt, paramAnonymousInt, paramAnonymousFloat);
          AudioExportTask.access$200(AudioExportTask.this);
          AppMethodBeat.o(214650);
          return;
        }
      }
    });
    try
    {
      paramCMTimeRange.prepare();
      paramCMTimeRange.start();
      this.mEncoderList.add(paramCMTimeRange);
      AppMethodBeat.o(214655);
      return;
    }
    catch (IOException paramCMTimeRange)
    {
      AppMethodBeat.o(214655);
    }
  }
  
  private void notifyProgressAndStatusUpdate()
  {
    AppMethodBeat.i(214656);
    if (this.mProgressMap.size() == 0)
    {
      AppMethodBeat.o(214656);
      return;
    }
    float f2 = this.mSegmentCount;
    Iterator localIterator = this.mProgressMap.entrySet().iterator();
    int i = 0;
    float f3;
    for (float f1 = 0.0F; localIterator.hasNext(); f1 = f3 + f1)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      f3 = ((SegmentStatus)localEntry.getValue()).mProgress;
      i = ((SegmentStatus)localEntry.getValue()).mStatus | i;
    }
    f1 /= f2;
    Logger.i("AudioEncoderTask", " mStatus = " + i + " mProgress = " + f1);
    if (i == 255)
    {
      onProgress(255, f1);
      EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
      new File(this.mOutSavePath).delete();
      AppMethodBeat.o(214656);
      return;
    }
    if (i >= 4)
    {
      onProgress(4, f1);
      EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
      new File(this.mOutSavePath).delete();
      AppMethodBeat.o(214656);
      return;
    }
    if (i == 2)
    {
      if (EncoderUtils.mergeAllFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId)) {
        onProgress(2, 1.0F);
      }
      for (;;)
      {
        EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
        AppMethodBeat.o(214656);
        return;
        onProgress(255, 1.0F);
      }
    }
    if (i > 0)
    {
      onProgress(1, f1);
      AppMethodBeat.o(214656);
      return;
    }
    onProgress(0, f1);
    AppMethodBeat.o(214656);
  }
  
  private void onProgress(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(214657);
    if (this.mCallback != null) {
      this.mCallback.onProgress(paramInt, paramFloat);
    }
    AppMethodBeat.o(214657);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(214660);
    Iterator localIterator = this.mEncoderList.iterator();
    while (localIterator.hasNext()) {
      ((AudioExportRunner)localIterator.next()).cancel();
    }
    AppMethodBeat.o(214660);
  }
  
  protected CMTime getDuration()
  {
    AppMethodBeat.i(214653);
    if (this.mAsset != null)
    {
      localCMTime = this.mAsset.getDuration();
      AppMethodBeat.o(214653);
      return localCMTime;
    }
    CMTime localCMTime = CMTime.CMTimeZero;
    AppMethodBeat.o(214653);
    return localCMTime;
  }
  
  public void setExportCallback(ExportCallback paramExportCallback)
  {
    this.mCallback = paramExportCallback;
  }
  
  public void start()
  {
    int k = 1;
    AppMethodBeat.i(214654);
    this.mProgressMap.clear();
    this.mEncoderList.clear();
    long l4 = getDuration().getTimeUs();
    long l3 = AudioExportSession.SEGMENT_DURATION_US;
    long l1 = 0L;
    this.mSessionId = System.currentTimeMillis();
    this.mSegmentCount = ((int)((l4 + l3 - 1L) / l3));
    int i = 0;
    int j = 1;
    if (i < this.mSegmentCount)
    {
      if (l1 + l3 > l4) {}
      for (long l2 = l4 - l1;; l2 = l3)
      {
        createSegmentStatus(j, new CMTimeRange(CMTime.fromUs(l1), CMTime.fromUs(l2)));
        l1 += l3;
        j += 1;
        i += 1;
        break;
      }
    }
    Iterator localIterator = this.mProgressMap.entrySet().iterator();
    i = k;
    while (localIterator.hasNext())
    {
      exportAudio(((SegmentStatus)((Map.Entry)localIterator.next()).getValue()).mTimeRange, i);
      i += 1;
    }
    AppMethodBeat.o(214654);
  }
  
  static class SegmentStatus
  {
    private float mProgress;
    private int mStatus;
    private CMTimeRange mTimeRange;
    
    public SegmentStatus(int paramInt, float paramFloat)
    {
      this.mStatus = paramInt;
      this.mProgress = paramFloat;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.mTimeRange;
    }
    
    public void setTimeRange(CMTimeRange paramCMTimeRange)
    {
      this.mTimeRange = paramCMTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportTask
 * JD-Core Version:    0.7.0.1
 */