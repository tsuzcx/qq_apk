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
  public abstract b cj(Map<String, String> paramMap);
  
  public static final class a
  {
    public long RbL;
    public long availableBlocks;
    public long bGI;
    public long blockSize;
    public long totalBlocks;
  }
  
  public static abstract interface b
  {
    public abstract void a(CancellationSignal paramCancellationSignal);
    
    public abstract boolean a(String paramString1, b paramb, String paramString2);
    
    public abstract ReadableByteChannel boI(String paramString);
    
    public abstract ByteChannel boJ(String paramString);
    
    public abstract FileSystem.a boK(String paramString);
    
    public abstract boolean boL(String paramString);
    
    public abstract e boM(String paramString);
    
    public abstract boolean boN(String paramString);
    
    public abstract long c(String paramString1, b paramb, String paramString2);
    
    public abstract boolean ck(String paramString, long paramLong);
    
    public abstract WritableByteChannel dv(String paramString, boolean paramBoolean);
    
    public abstract OutputStream dw(String paramString, boolean paramBoolean);
    
    public abstract Iterable<e> dx(String paramString, boolean paramBoolean);
    
    public abstract boolean dy(String paramString, boolean paramBoolean);
    
    public abstract String dz(String paramString, boolean paramBoolean);
    
    public abstract boolean gC(String paramString);
    
    public abstract FileSystem hdQ();
    
    public abstract int hdR();
    
    public abstract ParcelFileDescriptor nr(String paramString1, String paramString2);
    
    public abstract InputStream openRead(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */