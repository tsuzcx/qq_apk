package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IDecoder$DecodeType
{
  static
  {
    AppMethodBeat.i(216021);
    Video = new DecodeType("Video", 0);
    Audio = new DecodeType("Audio", 1);
    $VALUES = new DecodeType[] { Video, Audio };
    AppMethodBeat.o(216021);
  }
  
  private IDecoder$DecodeType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder.DecodeType
 * JD-Core Version:    0.7.0.1
 */