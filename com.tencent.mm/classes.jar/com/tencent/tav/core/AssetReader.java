package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetReader
  implements AssetReaderOutput.StatusListener
{
  private Asset asset;
  private IContextCreate contextCreate;
  private String errMsg;
  private HashMap<AssetReaderOutput, AVAssetReaderStatus> outputStatusHashMap;
  private List<AssetReaderOutput> outputs;
  private AVAssetReaderStatus status;
  private CMTimeRange timeRange;
  
  public AssetReader(Asset paramAsset)
  {
    AppMethodBeat.i(217770);
    this.status = AVAssetReaderStatus.AssetReaderStatusUnknown;
    this.errMsg = "";
    this.outputs = new ArrayList();
    this.outputStatusHashMap = new HashMap();
    this.asset = paramAsset;
    AppMethodBeat.o(217770);
  }
  
  private void updateAssetStatus()
  {
    AppMethodBeat.i(217774);
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
      AppMethodBeat.o(217774);
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
      AppMethodBeat.o(217774);
      return;
    }
    localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusFailed)
      {
        this.status = AVAssetReaderStatus.AssetReaderStatusFailed;
        AppMethodBeat.o(217774);
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
        AppMethodBeat.o(217774);
        return;
      }
    }
    AppMethodBeat.o(217774);
  }
  
  public void addOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(217772);
    if (canAddOutput(paramAssetReaderOutput)) {
      this.outputs.add(paramAssetReaderOutput);
    }
    AppMethodBeat.o(217772);
  }
  
  public boolean canAddOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(217771);
    if ((paramAssetReaderOutput != null) && (!this.outputs.contains(paramAssetReaderOutput)))
    {
      AppMethodBeat.o(217771);
      return true;
    }
    AppMethodBeat.o(217771);
    return false;
  }
  
  public void cancelReading()
  {
    AppMethodBeat.i(217775);
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusCancelled);
      localAssetReaderOutput.release();
    }
    updateAssetStatus();
    AppMethodBeat.o(217775);
  }
  
  public Asset getAsset()
  {
    return this.asset;
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
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public boolean startReading(IContextCreate paramIContextCreate)
  {
    AppMethodBeat.i(217773);
    this.contextCreate = paramIContextCreate;
    Iterator localIterator = this.outputs.iterator();
    if (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusReading);
      if (localAssetReaderOutput.mediaType == 1) {
        localAssetReaderOutput.start(paramIContextCreate, this);
      }
      for (;;)
      {
        localAssetReaderOutput.addStatusListener(this);
        break;
        localAssetReaderOutput.start(null, this);
      }
    }
    updateAssetStatus();
    if (this.outputs.size() > 0)
    {
      AppMethodBeat.o(217773);
      return true;
    }
    AppMethodBeat.o(217773);
    return false;
  }
  
  public void statusChanged(AssetReaderOutput paramAssetReaderOutput, AVAssetReaderStatus paramAVAssetReaderStatus)
  {
    AppMethodBeat.i(217776);
    this.outputStatusHashMap.put(paramAssetReaderOutput, paramAVAssetReaderStatus);
    updateAssetStatus();
    AppMethodBeat.o(217776);
  }
  
  public static enum AVAssetReaderStatus
  {
    static
    {
      AppMethodBeat.i(217769);
      AssetReaderStatusUnknown = new AVAssetReaderStatus("AssetReaderStatusUnknown", 0);
      AssetReaderStatusReading = new AVAssetReaderStatus("AssetReaderStatusReading", 1);
      AssetReaderStatusCompleted = new AVAssetReaderStatus("AssetReaderStatusCompleted", 2);
      AssetReaderStatusFailed = new AVAssetReaderStatus("AssetReaderStatusFailed", 3);
      AssetReaderStatusCancelled = new AVAssetReaderStatus("AssetReaderStatusCancelled", 4);
      $VALUES = new AVAssetReaderStatus[] { AssetReaderStatusUnknown, AssetReaderStatusReading, AssetReaderStatusCompleted, AssetReaderStatusFailed, AssetReaderStatusCancelled };
      AppMethodBeat.o(217769);
    }
    
    private AVAssetReaderStatus() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AssetReader
 * JD-Core Version:    0.7.0.1
 */