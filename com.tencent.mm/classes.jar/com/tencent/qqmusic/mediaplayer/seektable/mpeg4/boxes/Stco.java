package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stco
  extends FullBox
{
  int[] chunkOffset;
  int entryCount;
  
  public int[] getChunkOffset()
  {
    return this.chunkOffset;
  }
  
  public int getEntryCount()
  {
    return this.entryCount;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    AppMethodBeat.i(128483);
    super.parse(paramParsable, paramBox);
    this.entryCount = paramParsable.readInt();
    this.chunkOffset = paramParsable.readIntArray(this.entryCount);
    AppMethodBeat.o(128483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco
 * JD-Core Version:    0.7.0.1
 */