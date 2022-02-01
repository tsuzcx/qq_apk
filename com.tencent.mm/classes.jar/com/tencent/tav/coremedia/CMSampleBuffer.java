package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class CMSampleBuffer
{
  private ByteBuffer sampleByteBuffer;
  private CMSampleState state;
  private TextureInfo texture;
  
  public CMSampleBuffer(CMSampleState paramCMSampleState)
  {
    AppMethodBeat.i(215751);
    this.state = paramCMSampleState;
    this.state.setNewFrame(false);
    this.texture = null;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(215751);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    this.state = paramCMSampleState;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(215767);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(215767);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    this.state = paramCMSampleState;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(215780);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
    AppMethodBeat.o(215780);
  }
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this(new CMSampleState(paramCMTime));
    AppMethodBeat.i(215787);
    AppMethodBeat.o(215787);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo);
    AppMethodBeat.i(215793);
    AppMethodBeat.o(215793);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo, paramBoolean);
    AppMethodBeat.i(215800);
    AppMethodBeat.o(215800);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer);
    AppMethodBeat.i(215807);
    AppMethodBeat.o(215807);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer, paramBoolean);
    AppMethodBeat.i(215817);
    AppMethodBeat.o(215817);
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
    AppMethodBeat.i(215828);
    CMTime localCMTime = this.state.getTime();
    AppMethodBeat.o(215828);
    return localCMTime;
  }
  
  public boolean isNewFrame()
  {
    AppMethodBeat.i(215850);
    boolean bool = this.state.isNewFrame();
    AppMethodBeat.o(215850);
    return bool;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(215854);
    this.state.setNewFrame(paramBoolean);
    AppMethodBeat.o(215854);
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215858);
    String str = "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
    AppMethodBeat.o(215858);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */