package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Mdhd
  extends FullBox
{
  long creationTime;
  long duration;
  long modificationTime;
  byte[] remaining;
  int timeScale;
  
  public long getCreationTime()
  {
    return this.creationTime;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public long getModificationTime()
  {
    return this.modificationTime;
  }
  
  public int getTimeScale()
  {
    return this.timeScale;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    AppMethodBeat.i(128487);
    super.parse(paramParsable, paramBox);
    if (this.version == 1)
    {
      this.creationTime = paramParsable.readLong();
      this.modificationTime = paramParsable.readLong();
      this.timeScale = paramParsable.readInt();
    }
    for (this.duration = paramParsable.readLong();; this.duration = paramParsable.readInt())
    {
      this.remaining = new byte[4];
      paramParsable.readBytes(this.remaining, 0, this.remaining.length);
      AppMethodBeat.o(128487);
      return;
      this.creationTime = paramParsable.readInt();
      this.modificationTime = paramParsable.readInt();
      this.timeScale = paramParsable.readInt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd
 * JD-Core Version:    0.7.0.1
 */