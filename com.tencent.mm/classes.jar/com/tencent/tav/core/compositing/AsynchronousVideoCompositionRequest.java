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
    AppMethodBeat.i(214680);
    this.sourceTrackIDs = new ArrayList();
    this.composedVideoFrame = null;
    this.status = -2147483648;
    this.sampleBuffers = new SparseArray();
    this.authorComposition = paramObject;
    this.assetExtension = paramAssetExtension;
    AppMethodBeat.o(214680);
  }
  
  private void notifyFinish()
  {
    AppMethodBeat.i(214685);
    if (this.authorComposition != null) {
      synchronized (this.authorComposition)
      {
        this.authorComposition.notifyAll();
        AppMethodBeat.o(214685);
        return;
      }
    }
    AppMethodBeat.o(214685);
  }
  
  public void appendCMSampleBuffer(CMSampleBuffer paramCMSampleBuffer, int paramInt)
  {
    AppMethodBeat.i(214686);
    this.sampleBuffers.put(paramInt, paramCMSampleBuffer);
    this.sourceTrackIDs.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(214686);
  }
  
  public void finishCancelledRequest()
  {
    AppMethodBeat.i(214684);
    try
    {
      this.status = 1;
      notifyFinish();
      AppMethodBeat.o(214684);
      return;
    }
    finally
    {
      AppMethodBeat.o(214684);
    }
  }
  
  public void finishWithComposedVideoFrame(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(214682);
    try
    {
      this.composedVideoFrame = paramCMSampleBuffer;
      this.status = 0;
      notifyFinish();
      AppMethodBeat.o(214682);
      return;
    }
    finally
    {
      AppMethodBeat.o(214682);
    }
  }
  
  public void finishWithError(ErrorMsg paramErrorMsg)
  {
    AppMethodBeat.i(214683);
    try
    {
      this.error = paramErrorMsg;
      this.status = -1;
      notifyFinish();
      AppMethodBeat.o(214683);
      return;
    }
    finally
    {
      AppMethodBeat.o(214683);
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
    AppMethodBeat.i(214681);
    if (this.sampleBuffers != null)
    {
      CMSampleBuffer localCMSampleBuffer = (CMSampleBuffer)this.sampleBuffers.get(paramInt);
      AppMethodBeat.o(214681);
      return localCMSampleBuffer;
    }
    AppMethodBeat.o(214681);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(214687);
    String str = "AsynchronousVideoCompositionRequest{renderContext=" + this.renderContext + ", compositionTime=" + this.compositionTime + ", videoCompositionInstruction=" + this.videoCompositionInstruction + ", sampleBuffers=" + this.sampleBuffers + '}';
    AppMethodBeat.o(214687);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest
 * JD-Core Version:    0.7.0.1
 */