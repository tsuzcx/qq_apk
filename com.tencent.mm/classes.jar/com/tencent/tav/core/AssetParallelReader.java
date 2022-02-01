package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetParallelReader
  implements AssetReaderOutput.StatusListener
{
  private Asset asset;
  private CMTimeRange audioTimeRange;
  private IContextCreate contextCreate;
  private String errMsg;
  private HashMap<AssetReaderOutput, AVAssetReaderStatus> outputStatusHashMap;
  private List<AssetReaderOutput> outputs;
  private AVAssetReaderStatus status;
  private ArrayList<CMTimeRange> videoSegmentTimeRange;
  private CMTimeRange videoTimeRange;
  
  public AssetParallelReader(Asset paramAsset)
  {
    AppMethodBeat.i(215235);
    this.status = AVAssetReaderStatus.AssetReaderStatusUnknown;
    this.errMsg = "";
    this.videoSegmentTimeRange = new ArrayList();
    this.outputs = new ArrayList();
    this.outputStatusHashMap = new HashMap();
    this.asset = paramAsset;
    AppMethodBeat.o(215235);
  }
  
  private void updateAssetStatus()
  {
    AppMethodBeat.i(215248);
    Iterator localIterator = this.outputs.iterator();
    int i = 1;
    AssetReaderOutput localAssetReaderOutput;
    int j;
    if (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusCompleted) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AVAssetReaderStatus.AssetReaderStatusCompleted;
      AppMethodBeat.o(215248);
      return;
    }
    localIterator = this.outputs.iterator();
    i = 1;
    if (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if ((this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusReading) || (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusCompleted)) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AVAssetReaderStatus.AssetReaderStatusReading;
      AppMethodBeat.o(215248);
      return;
    }
    localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusFailed)
      {
        this.status = AVAssetReaderStatus.AssetReaderStatusFailed;
        AppMethodBeat.o(215248);
        return;
      }
    }
    localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusCancelled)
      {
        this.status = AVAssetReaderStatus.AssetReaderStatusCancelled;
        AppMethodBeat.o(215248);
        return;
      }
    }
    AppMethodBeat.o(215248);
  }
  
  public void addOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(215355);
    if (canAddOutput(paramAssetReaderOutput)) {
      this.outputs.add(paramAssetReaderOutput);
    }
    AppMethodBeat.o(215355);
  }
  
  public boolean canAddOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(215339);
    if ((paramAssetReaderOutput != null) && (!this.outputs.contains(paramAssetReaderOutput)))
    {
      AppMethodBeat.o(215339);
      return true;
    }
    AppMethodBeat.o(215339);
    return false;
  }
  
  public void cancelReading()
  {
    AppMethodBeat.i(215390);
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusCancelled);
      localAssetReaderOutput.release();
    }
    updateAssetStatus();
    AppMethodBeat.o(215390);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public CMTimeRange getAudioTimeRange()
  {
    return this.audioTimeRange;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public List<AssetReaderOutput> getOutputs()
  {
    return this.outputs;
  }
  
  public AVAssetReaderStatus getStatus()
  {
    return this.status;
  }
  
  public CMTimeRange getVideoTimeRange()
  {
    return this.videoTimeRange;
  }
  
  public void release()
  {
    AppMethodBeat.i(215420);
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext()) {
      ((AssetReaderOutput)localIterator.next()).release();
    }
    AppMethodBeat.o(215420);
  }
  
  public void setAudioTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.audioTimeRange = paramCMTimeRange;
  }
  
  public void setVideoTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.videoTimeRange = paramCMTimeRange;
  }
  
  public boolean startReading(IContextCreate paramIContextCreate)
  {
    AppMethodBeat.i(215376);
    this.contextCreate = paramIContextCreate;
    Iterator localIterator = this.outputs.iterator();
    if (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusReading);
      if (localAssetReaderOutput.mediaType == 1)
      {
        CMTimeRange localCMTimeRange = (CMTimeRange)this.videoSegmentTimeRange.get(0);
        this.videoSegmentTimeRange.remove(0);
        localAssetReaderOutput.start(paramIContextCreate, localCMTimeRange);
      }
      for (;;)
      {
        localAssetReaderOutput.addStatusListener(this);
        break;
        localAssetReaderOutput.start(null, getAudioTimeRange());
      }
    }
    updateAssetStatus();
    if (this.outputs.size() > 0)
    {
      AppMethodBeat.o(215376);
      return true;
    }
    AppMethodBeat.o(215376);
    return false;
  }
  
  public void statusChanged(AssetReaderOutput paramAssetReaderOutput, AVAssetReaderStatus paramAVAssetReaderStatus)
  {
    AppMethodBeat.i(215406);
    this.outputStatusHashMap.put(paramAssetReaderOutput, paramAVAssetReaderStatus);
    updateAssetStatus();
    AppMethodBeat.o(215406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetParallelReader
 * JD-Core Version:    0.7.0.1
 */