package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class m
  implements k.a
{
  public final boolean a(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(65220);
    if ((paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified()))
    {
      AppMethodBeat.o(65220);
      return true;
    }
    AppMethodBeat.o(65220);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */