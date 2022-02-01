package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Ftyp
  extends Box
{
  int[] compatibleBrands;
  int majorBrand;
  int minorVersion;
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    AppMethodBeat.i(114265);
    super.parse(paramParsable, paramBox);
    this.majorBrand = paramParsable.readInt();
    this.minorVersion = paramParsable.readInt();
    int i = (int)paramParsable.available() / 4;
    if (i > 0) {
      this.compatibleBrands = paramParsable.readIntArray(i);
    }
    AppMethodBeat.o(114265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Ftyp
 * JD-Core Version:    0.7.0.1
 */