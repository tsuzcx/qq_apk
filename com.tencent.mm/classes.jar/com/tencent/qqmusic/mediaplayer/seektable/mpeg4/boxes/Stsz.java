package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stsz
  extends FullBox
{
  int[] entrySize;
  int sampleCount;
  int sampleSize;
  
  public int[] getEntrySize()
  {
    return this.entrySize;
  }
  
  public int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public int getSampleSize()
  {
    return this.sampleSize;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    AppMethodBeat.i(114263);
    super.parse(paramParsable, paramBox);
    this.sampleSize = paramParsable.readInt();
    this.sampleCount = paramParsable.readInt();
    if (this.sampleSize == 0) {
      this.entrySize = paramParsable.readIntArray(this.sampleCount);
    }
    if ((this.sampleSize == 0) && (this.sampleCount == 0))
    {
      paramParsable = new InvalidBoxException("invalide stsz: both [sample_count] and [sample_size] is 0!");
      AppMethodBeat.o(114263);
      throw paramParsable;
    }
    AppMethodBeat.o(114263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz
 * JD-Core Version:    0.7.0.1
 */