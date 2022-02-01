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
    AppMethodBeat.i(215676);
    this.status = AVAssetReaderStatus.AssetReaderStatusUnknown;
    this.errMsg = "";
    this.outputs = new ArrayList();
    this.outputStatusHashMap = new HashMap();
    this.asset = paramAsset;
    AppMethodBeat.o(215676);
  }
  
  private void updateAssetStatus()
  {
    AppMethodBeat.i(215686);
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
      AppMethodBeat.o(215686);
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
      AppMethodBeat.o(215686);
      return;
    }
    localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusFailed)
      {
        this.status = AVAssetReaderStatus.AssetReaderStatusFailed;
        AppMethodBeat.o(215686);
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
        AppMethodBeat.o(215686);
        return;
      }
    }
    AppMethodBeat.o(215686);
  }
  
  public void addOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(215736);
    if (canAddOutput(paramAssetReaderOutput)) {
      this.outputs.add(paramAssetReaderOutput);
    }
    AppMethodBeat.o(215736);
  }
  
  public boolean canAddOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    AppMethodBeat.i(215726);
    if ((paramAssetReaderOutput != null) && (!this.outputs.contains(paramAssetReaderOutput)))
    {
      AppMethodBeat.o(215726);
      return true;
    }
    AppMethodBeat.o(215726);
    return false;
  }
  
  public void cancelReading()
  {
    AppMethodBeat.i(215748);
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusCancelled);
      localAssetReaderOutput.release();
    }
    updateAssetStatus();
    AppMethodBeat.o(215748);
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
    AppMethodBeat.i(215742);
    this.contextCreate = paramIContextCreate;
    Iterator localIterator = this.outputs.iterator();
    if (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AVAssetReaderStatus.AssetReaderStatusReading);
      if (localAssetReaderOutput.mediaType == 1) {
        localAssetReaderOutput.start(paramIContextCreate, getTimeRange());
      }
      for (;;)
      {
        localAssetReaderOutput.addStatusListener(this);
        break;
        localAssetReaderOutput.start(null, getTimeRange());
      }
    }
    updateAssetStatus();
    if (this.outputs.size() > 0)
    {
      AppMethodBeat.o(215742);
      return true;
    }
    AppMethodBeat.o(215742);
    return false;
  }
  
  public void statusChanged(AssetReaderOutput paramAssetReaderOutput, AVAssetReaderStatus paramAVAssetReaderStatus)
  {
    AppMethodBeat.i(215756);
    this.outputStatusHashMap.put(paramAssetReaderOutput, paramAVAssetReaderStatus);
    updateAssetStatus();
    AppMethodBeat.o(215756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetReader
 * JD-Core Version:    0.7.0.1
 */