package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

class FlacSeekTable$SeektableHandler
  implements FlacSeekTable.BlockHandler
{
  FlacSeekTable$SeektableHandler(FlacSeekTable paramFlacSeekTable) {}
  
  public boolean handle(Parsable paramParsable, int paramInt)
  {
    int i = 0;
    if (paramInt != 3) {
      return false;
    }
    byte[] arrayOfByte = new byte[3];
    paramParsable.readBytes(arrayOfByte, 0, 3);
    int j = BytesUtil.from(arrayOfByte) / 18;
    FlacSeekTable.access$002(this.this$0, new long[j]);
    FlacSeekTable.access$102(this.this$0, new long[j]);
    paramInt = i;
    while (paramInt < j)
    {
      FlacSeekTable.access$000(this.this$0)[paramInt] = paramParsable.readLong();
      FlacSeekTable.access$100(this.this$0)[paramInt] = paramParsable.readLong();
      paramParsable.skip(2L);
      paramInt += 1;
    }
    if (!FlacSeekTable.access$200(paramParsable)) {
      throw new InvalidBoxException("can't find audio frame!");
    }
    FlacSeekTable.access$302(this.this$0, paramParsable.tell() - 2L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.SeektableHandler
 * JD-Core Version:    0.7.0.1
 */