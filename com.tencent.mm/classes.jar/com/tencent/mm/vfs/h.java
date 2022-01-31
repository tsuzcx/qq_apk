package com.tencent.mm.vfs;

import java.io.OutputStreamWriter;

public final class h
  extends OutputStreamWriter
{
  public h(b paramb)
  {
    super(e.a(paramb.mUri, paramb.cLo(), false));
  }
  
  public h(String paramString)
  {
    super(e.I(paramString, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */