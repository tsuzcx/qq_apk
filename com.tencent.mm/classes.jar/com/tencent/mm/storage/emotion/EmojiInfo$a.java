package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EmojiInfo$a
{
  static
  {
    AppMethodBeat.i(62761);
    yPB = new a("STATUS_SUCCESS", 0);
    yPC = new a("STATUS_MIXING", 1);
    yPD = new a("STATUS_MIX_FAIL", 2);
    yPE = new a("STATUS_UPLOADING", 3);
    yPF = new a("STATUS_UPLOAD_FAIL", 4);
    yPG = new a[] { yPB, yPC, yPD, yPE, yPF };
    AppMethodBeat.o(62761);
  }
  
  private EmojiInfo$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiInfo.a
 * JD-Core Version:    0.7.0.1
 */