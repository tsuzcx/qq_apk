package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class CMSampleBuffer
{
  private ByteBuffer sampleByteBuffer;
  private final CMSampleState state;
  private TextureInfo texture;
  
  public CMSampleBuffer(CMSampleState paramCMSampleState)
  {
    AppMethodBeat.i(219395);
    this.state = paramCMSampleState;
    this.state.setNewFrame(false);
    this.texture = null;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(219395);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    this.state = paramCMSampleState;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(219396);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(219396);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    this.state = paramCMSampleState;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(219397);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
    AppMethodBeat.o(219397);
  }
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this(new CMSampleState(paramCMTime));
    AppMethodBeat.i(219398);
    AppMethodBeat.o(219398);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo);
    AppMethodBeat.i(219399);
    AppMethodBeat.o(219399);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo, paramBoolean);
    AppMethodBeat.i(219400);
    AppMethodBeat.o(219400);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer);
    AppMethodBeat.i(219401);
    AppMethodBeat.o(219401);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer, paramBoolean);
    AppMethodBeat.i(219402);
    AppMethodBeat.o(219402);
  }
  
  public ByteBuffer getSampleByteBuffer()
  {
    return this.sampleByteBuffer;
  }
  
  public CMSampleState getState()
  {
    return this.state;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.texture;
  }
  
  public CMTime getTime()
  {
    AppMethodBeat.i(219403);
    CMTime localCMTime = this.state.getTime();
    AppMethodBeat.o(219403);
    return localCMTime;
  }
  
  public boolean isNewFrame()
  {
    AppMethodBeat.i(219404);
    boolean bool = this.state.isNewFrame();
    AppMethodBeat.o(219404);
    return bool;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(219405);
    this.state.setNewFrame(paramBoolean);
    AppMethodBeat.o(219405);
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219406);
    String str = "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
    AppMethodBeat.o(219406);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */