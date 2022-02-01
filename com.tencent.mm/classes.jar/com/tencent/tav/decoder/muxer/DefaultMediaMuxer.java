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
    AppMethodBeat.i(215108);
    this.muxer = new MediaMuxer(paramString, paramInt);
    AppMethodBeat.o(215108);
  }
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(215110);
    int i = this.muxer.addTrack(paramMediaFormat);
    AppMethodBeat.o(215110);
    return i;
  }
  
  public boolean ignoreHeader()
  {
    return true;
  }
  
  public void release()
  {
    AppMethodBeat.i(215113);
    this.muxer.release();
    AppMethodBeat.o(215113);
  }
  
  public void setExportConfig(ExportConfig paramExportConfig) {}
  
  public void start()
  {
    AppMethodBeat.i(215109);
    this.muxer.start();
    AppMethodBeat.o(215109);
  }
  
  public void stop()
  {
    AppMethodBeat.i(215112);
    this.muxer.stop();
    AppMethodBeat.o(215112);
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(215111);
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
    AppMethodBeat.o(215111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.DefaultMediaMuxer
 * JD-Core Version:    0.7.0.1
 */