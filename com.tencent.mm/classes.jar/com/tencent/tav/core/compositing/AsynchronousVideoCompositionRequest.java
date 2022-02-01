package com.tencent.tav.core.compositing;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.ErrorMsg;
import java.lang.annotation.Annotation;
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
  @RequestStatus
  private volatile int status;
  private IVideoCompositionInstruction videoCompositionInstruction;
  
  public AsynchronousVideoCompositionRequest(Object paramObject, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(201612);
    this.sourceTrackIDs = new ArrayList();
    this.composedVideoFrame = null;
    this.status = -2147483648;
    this.sampleBuffers = new SparseArray();
    this.authorComposition = paramObject;
    this.assetExtension = paramAssetExtension;
    AppMethodBeat.o(201612);
  }
  
  private void notifyFinish()
  {
    AppMethodBeat.i(201617);
    if (this.authorComposition != null) {
      synchronized (this.authorComposition)
      {
        this.authorComposition.notifyAll();
        AppMethodBeat.o(201617);
        return;
      }
    }
    AppMethodBeat.o(201617);
  }
  
  public void appendCMSampleBuffer(CMSampleBuffer paramCMSampleBuffer, int paramInt)
  {
    AppMethodBeat.i(201618);
    this.sampleBuffers.put(paramInt, paramCMSampleBuffer);
    this.sourceTrackIDs.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(201618);
  }
  
  public void finishCancelledRequest()
  {
    AppMethodBeat.i(201616);
    try
    {
      this.status = 1;
      notifyFinish();
      AppMethodBeat.o(201616);
      return;
    }
    finally
    {
      AppMethodBeat.o(201616);
    }
  }
  
  public void finishWithComposedVideoFrame(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(201614);
    try
    {
      this.composedVideoFrame = paramCMSampleBuffer;
      this.status = 0;
      notifyFinish();
      AppMethodBeat.o(201614);
      return;
    }
    finally
    {
      AppMethodBeat.o(201614);
    }
  }
  
  public void finishWithError(ErrorMsg paramErrorMsg)
  {
    AppMethodBeat.i(201615);
    try
    {
      this.error = paramErrorMsg;
      this.status = -1;
      notifyFinish();
      AppMethodBeat.o(201615);
      return;
    }
    finally
    {
      AppMethodBeat.o(201615);
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
  
  @RequestStatus
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
    AppMethodBeat.i(201613);
    if (this.sampleBuffers != null)
    {
      CMSampleBuffer localCMSampleBuffer = (CMSampleBuffer)this.sampleBuffers.get(paramInt);
      AppMethodBeat.o(201613);
      return localCMSampleBuffer;
    }
    AppMethodBeat.o(201613);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(201619);
    String str = "AsynchronousVideoCompositionRequest{renderContext=" + this.renderContext + ", compositionTime=" + this.compositionTime + ", videoCompositionInstruction=" + this.videoCompositionInstruction + ", sampleBuffers=" + this.sampleBuffers + '}';
    AppMethodBeat.o(201619);
    return str;
  }
  
  public static @interface RequestStatus
  {
    public static final int Cancel = 1;
    public static final int Error = -1;
    public static final int Success = 0;
    public static final int UnKnow = -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest
 * JD-Core Version:    0.7.0.1
 */