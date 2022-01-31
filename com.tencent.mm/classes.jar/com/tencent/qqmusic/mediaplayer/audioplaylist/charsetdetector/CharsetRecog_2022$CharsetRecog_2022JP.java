package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_2022$CharsetRecog_2022JP
  extends CharsetRecog_2022
{
  private byte[][] escapeSequences;
  
  CharsetRecog_2022$CharsetRecog_2022JP()
  {
    AppMethodBeat.i(104739);
    byte[] arrayOfByte1 = { 27, 36, 64 };
    byte[] arrayOfByte2 = { 27, 36, 65 };
    byte[] arrayOfByte3 = { 27, 38, 64 };
    byte[] arrayOfByte4 = { 27, 40, 66 };
    byte[] arrayOfByte5 = { 27, 40, 72 };
    byte[] arrayOfByte6 = { 27, 40, 74 };
    byte[] arrayOfByte7 = { 27, 46, 70 };
    this.escapeSequences = new byte[][] { { 27, 36, 40, 67 }, { 27, 36, 40, 68 }, arrayOfByte1, arrayOfByte2, { 27, 36, 66 }, arrayOfByte3, arrayOfByte4, arrayOfByte5, { 27, 40, 73 }, arrayOfByte6, { 27, 46, 65 }, arrayOfByte7 };
    AppMethodBeat.o(104739);
  }
  
  String getName()
  {
    return "ISO-2022-JP";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104740);
    int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
    if (i == 0)
    {
      AppMethodBeat.o(104740);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104740);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022.CharsetRecog_2022JP
 * JD-Core Version:    0.7.0.1
 */