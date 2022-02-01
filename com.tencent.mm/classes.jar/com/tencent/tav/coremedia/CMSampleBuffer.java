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
    AppMethodBeat.i(200188);
    this.state = paramCMSampleState;
    this.state.setNewFrame(false);
    this.texture = null;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(200188);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    this.state = paramCMSampleState;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(200189);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(200189);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    this.state = paramCMSampleState;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(200190);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
    AppMethodBeat.o(200190);
  }
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this(new CMSampleState(paramCMTime));
    AppMethodBeat.i(200191);
    AppMethodBeat.o(200191);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo);
    AppMethodBeat.i(200192);
    AppMethodBeat.o(200192);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo, paramBoolean);
    AppMethodBeat.i(200193);
    AppMethodBeat.o(200193);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer);
    AppMethodBeat.i(200194);
    AppMethodBeat.o(200194);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer, paramBoolean);
    AppMethodBeat.i(200195);
    AppMethodBeat.o(200195);
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
    AppMethodBeat.i(200196);
    CMTime localCMTime = this.state.getTime();
    AppMethodBeat.o(200196);
    return localCMTime;
  }
  
  public boolean isNewFrame()
  {
    AppMethodBeat.i(200197);
    boolean bool = this.state.isNewFrame();
    AppMethodBeat.o(200197);
    return bool;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(200198);
    this.state.setNewFrame(paramBoolean);
    AppMethodBeat.o(200198);
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    AppMethodBeat.i(200199);
    String str = "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
    AppMethodBeat.o(200199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */