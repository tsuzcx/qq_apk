package com.tencent.smtt.utils;

import java.io.File;

final class l
  implements j.a
{
  public final boolean a(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */