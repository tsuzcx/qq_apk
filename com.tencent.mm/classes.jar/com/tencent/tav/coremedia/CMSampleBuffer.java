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
    AppMethodBeat.i(199391);
    this.state = paramCMSampleState;
    this.state.setNewFrame(false);
    this.texture = null;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(199391);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    this.state = paramCMSampleState;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(199392);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
    AppMethodBeat.o(199392);
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    this.state = paramCMSampleState;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(199393);
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
    AppMethodBeat.o(199393);
  }
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this(new CMSampleState(paramCMTime));
    AppMethodBeat.i(199394);
    AppMethodBeat.o(199394);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo);
    AppMethodBeat.i(199395);
    AppMethodBeat.o(199395);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo, paramBoolean);
    AppMethodBeat.i(199396);
    AppMethodBeat.o(199396);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer);
    AppMethodBeat.i(199397);
    AppMethodBeat.o(199397);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer, paramBoolean);
    AppMethodBeat.i(199398);
    AppMethodBeat.o(199398);
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
    AppMethodBeat.i(199399);
    CMTime localCMTime = this.state.getTime();
    AppMethodBeat.o(199399);
    return localCMTime;
  }
  
  public boolean isNewFrame()
  {
    AppMethodBeat.i(199400);
    boolean bool = this.state.isNewFrame();
    AppMethodBeat.o(199400);
    return bool;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(199401);
    this.state.setNewFrame(paramBoolean);
    AppMethodBeat.o(199401);
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    AppMethodBeat.i(199402);
    String str = "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
    AppMethodBeat.o(199402);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */