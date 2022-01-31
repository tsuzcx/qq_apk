package com.tencent.mm.vfs;

import java.io.FilterInputStream;

public final class d
  extends FilterInputStream
{
  public d(b paramb)
  {
    super(e.b(paramb.mUri, paramb.cLo()));
  }
  
  public d(String paramString)
  {
    super(e.openRead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.d
 * JD-Core Version:    0.7.0.1
 */