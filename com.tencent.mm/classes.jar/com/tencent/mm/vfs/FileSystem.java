package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public abstract b cd(Map<String, String> paramMap);
  
  public static final class a
  {
    public long IAg;
    public long IAi;
    public long IAj;
    public long LGf;
    public long bGr;
  }
  
  public static abstract interface b
  {
    public abstract boolean Dc(String paramString);
    
    public abstract void a(CancellationSignal paramCancellationSignal);
    
    public abstract boolean a(String paramString1, b paramb, String paramString2);
    
    public abstract ReadableByteChannel aZD(String paramString);
    
    public abstract ByteChannel aZE(String paramString);
    
    public abstract FileSystem.a aZF(String paramString);
    
    public abstract boolean aZG(String paramString);
    
    public abstract c aZH(String paramString);
    
    public abstract boolean aZI(String paramString);
    
    public abstract long c(String paramString1, b paramb, String paramString2);
    
    public abstract boolean cp(String paramString, long paramLong);
    
    public abstract WritableByteChannel da(String paramString, boolean paramBoolean);
    
    public abstract OutputStream db(String paramString, boolean paramBoolean);
    
    public abstract Iterable<c> dc(String paramString, boolean paramBoolean);
    
    public abstract boolean dd(String paramString, boolean paramBoolean);
    
    public abstract String de(String paramString, boolean paramBoolean);
    
    public abstract FileSystem fSK();
    
    public abstract int fSL();
    
    public abstract ParcelFileDescriptor mA(String paramString1, String paramString2);
    
    public abstract InputStream openRead(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */