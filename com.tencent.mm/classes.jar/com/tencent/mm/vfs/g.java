package com.tencent.mm.vfs;

import java.io.InputStreamReader;

public final class g
  extends InputStreamReader
{
  public g(b paramb)
  {
    super(e.b(paramb.mUri, paramb.cLo()));
  }
  
  public g(String paramString)
  {
    super(e.openRead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.g
 * JD-Core Version:    0.7.0.1
 */