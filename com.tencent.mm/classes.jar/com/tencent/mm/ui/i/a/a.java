package com.tencent.mm.ui.i.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a
{
  c XGF;
  
  public a(c paramc)
  {
    this.XGF = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void a(FileNotFoundException paramFileNotFoundException);
    
    public abstract void a(MalformedURLException paramMalformedURLException);
    
    public abstract void aaT(String paramString);
    
    public abstract void c(IOException paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.a
 * JD-Core Version:    0.7.0.1
 */