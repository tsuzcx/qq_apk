package com.tencent.tav.core.compositing;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.ErrorMsg;
import java.util.ArrayList;
import java.util.List;

public class AsynchronousVideoCompositionRequest
{
  private final AssetExtension assetExtension;
  private final Object authorComposition;
  private volatile CMSampleBuffer composedVideoFrame;
  private CMTime compositionTime;
  private volatile ErrorMsg error;
  private VideoCompositionRenderContext renderContext;
  private SparseArray<CMSampleBuffer> sampleBuffers;
  private List<Integer> sourceTrackIDs;
  @AsynchronousVideoCompositionRequest.RequestStatus
  private volatile int status;
  private IVideoCompositionInstruction videoCompositionInstruction;
  
  public AsynchronousVideoCompositionRequest(Object paramObject, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(197673);
    this.sourceTrackIDs = new ArrayList();
    this.composedVideoFrame = null;
    this.status = -2147483648;
    this.sampleBuffers = new SparseArray();
    this.authorComposition = paramObject;
    this.assetExtension = paramAssetExtension;
    AppMethodBeat.o(197673);
  }
  
  private void notifyFinish()
  {
    AppMethodBeat.i(197678);
    if (this.authorComposition != null) {
      synchronized (this.authorComposition)
      {
        this.authorComposition.notifyAll();
        AppMethodBeat.o(197678);
        return;
      }
    }
    AppMethodBeat.o(197678);
  }
  
  public void appendCMSampleBuffer(CMSampleBuffer paramCMSampleBuffer, int paramInt)
  {
    AppMethodBeat.i(197679);
    this.sampleBuffers.put(paramInt, paramCMSampleBuffer);
    this.sourceTrackIDs.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(197679);
  }
  
  public void finishCancelledRequest()
  {
    AppMethodBeat.i(197677);
    try
    {
      this.status = 1;
      notifyFinish();
      AppMethodBeat.o(197677);
      return;
    }
    finally
    {
      AppMethodBeat.o(197677);
    }
  }
  
  public void finishWithComposedVideoFrame(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(197675);
    try
    {
      this.composedVideoFrame = paramCMSampleBuffer;
      this.status = 0;
      notifyFinish();
      AppMethodBeat.o(197675);
      return;
    }
    finally
    {
      AppMethodBeat.o(197675);
    }
  }
  
  public void finishWithError(ErrorMsg paramErrorMsg)
  {
    AppMethodBeat.i(197676);
    try
    {
      this.error = paramErrorMsg;
      this.status = -1;
      notifyFinish();
      AppMethodBeat.o(197676);
      return;
    }
    finally
    {
      AppMethodBeat.o(197676);
    }
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  public CMSampleBuffer getComposedSampleBuffer()
  {
    try
    {
      CMSampleBuffer localCMSampleBuffer = this.composedVideoFrame;
      return localCMSampleBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime getCompositionTime()
  {
    return this.compositionTime;
  }
  
  public VideoCompositionRenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public List<Integer> getSourceTrackIDs()
  {
    return this.sourceTrackIDs;
  }
  
  @AsynchronousVideoCompositionRequest.RequestStatus
  public int getStatus()
  {
    try
    {
      int i = this.status;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public IVideoCompositionInstruction getVideoCompositionInstruction()
  {
    return this.videoCompositionInstruction;
  }
  
  public void setCompositionTime(CMTime paramCMTime)
  {
    this.compositionTime = paramCMTime;
  }
  
  public void setRenderContext(VideoCompositionRenderContext paramVideoCompositionRenderContext)
  {
    this.renderContext = paramVideoCompositionRenderContext;
  }
  
  public void setVideoCompositionInstruction(IVideoCompositionInstruction paramIVideoCompositionInstruction)
  {
    this.videoCompositionInstruction = paramIVideoCompositionInstruction;
  }
  
  public CMSampleBuffer sourceFrameByTrackID(int paramInt)
  {
    AppMethodBeat.i(197674);
    if (this.sampleBuffers != null)
    {
      CMSampleBuffer localCMSampleBuffer = (CMSampleBuffer)this.sampleBuffers.get(paramInt);
      AppMethodBeat.o(197674);
      return localCMSampleBuffer;
    }
    AppMethodBeat.o(197674);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197680);
    String str = "AsynchronousVideoCompositionRequest{renderContext=" + this.renderContext + ", compositionTime=" + this.compositionTime + ", videoCompositionInstruction=" + this.videoCompositionInstruction + ", sampleBuffers=" + this.sampleBuffers + '}';
    AppMethodBeat.o(197680);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest
 * JD-Core Version:    0.7.0.1
 */