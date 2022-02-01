package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import java.nio.ByteBuffer;

public class DefaultMediaMuxer
  implements IMediaMuxer
{
  private MediaMuxer muxer;
  
  public DefaultMediaMuxer(String paramString, int paramInt)
  {
    AppMethodBeat.i(218468);
    this.muxer = new MediaMuxer(paramString, paramInt);
    AppMethodBeat.o(218468);
  }
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218470);
    int i = this.muxer.addTrack(paramMediaFormat);
    AppMethodBeat.o(218470);
    return i;
  }
  
  public boolean ignoreHeader()
  {
    return true;
  }
  
  public void release()
  {
    AppMethodBeat.i(218473);
    this.muxer.release();
    AppMethodBeat.o(218473);
  }
  
  public void setExportConfig(ExportConfig paramExportConfig) {}
  
  public void start()
  {
    AppMethodBeat.i(218469);
    this.muxer.start();
    AppMethodBeat.o(218469);
  }
  
  public void stop()
  {
    AppMethodBeat.i(218472);
    this.muxer.stop();
    AppMethodBeat.o(218472);
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(218471);
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
    AppMethodBeat.o(218471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.DefaultMediaMuxer
 * JD-Core Version:    0.7.0.1
 */