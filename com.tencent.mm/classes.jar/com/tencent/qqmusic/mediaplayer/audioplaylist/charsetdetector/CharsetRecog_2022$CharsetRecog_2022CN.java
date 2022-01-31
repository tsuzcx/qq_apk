package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_2022$CharsetRecog_2022CN
  extends CharsetRecog_2022
{
  private byte[][] escapeSequences;
  
  CharsetRecog_2022$CharsetRecog_2022CN()
  {
    AppMethodBeat.i(104733);
    byte[] arrayOfByte1 = { 27, 36, 41, 65 };
    byte[] arrayOfByte2 = { 27, 36, 42, 72 };
    byte[] arrayOfByte3 = { 27, 36, 43, 76 };
    byte[] arrayOfByte4 = { 27, 36, 43, 77 };
    byte[] arrayOfByte5 = { 27, 79 };
    this.escapeSequences = new byte[][] { arrayOfByte1, { 27, 36, 41, 71 }, arrayOfByte2, { 27, 36, 41, 69 }, { 27, 36, 43, 73 }, { 27, 36, 43, 74 }, { 27, 36, 43, 75 }, arrayOfByte3, arrayOfByte4, { 27, 78 }, arrayOfByte5 };
    AppMethodBeat.o(104733);
  }
  
  String getName()
  {
    return "ISO-2022-CN";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104734);
    int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
    if (i == 0)
    {
      AppMethodBeat.o(104734);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104734);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022.CharsetRecog_2022CN
 * JD-Core Version:    0.7.0.1
 */