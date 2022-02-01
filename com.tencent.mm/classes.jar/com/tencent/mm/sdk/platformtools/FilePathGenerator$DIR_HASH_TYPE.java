package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FilePathGenerator$DIR_HASH_TYPE
{
  static
  {
    AppMethodBeat.i(230290);
    HEAD_2_BYTE = new DIR_HASH_TYPE("HEAD_2_BYTE", 0);
    ALL_MD5 = new DIR_HASH_TYPE("ALL_MD5", 1);
    $VALUES = new DIR_HASH_TYPE[] { HEAD_2_BYTE, ALL_MD5 };
    AppMethodBeat.o(230290);
  }
  
  private FilePathGenerator$DIR_HASH_TYPE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilePathGenerator.DIR_HASH_TYPE
 * JD-Core Version:    0.7.0.1
 */