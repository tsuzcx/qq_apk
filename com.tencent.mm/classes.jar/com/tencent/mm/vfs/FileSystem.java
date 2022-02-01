package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract interface FileSystem
  extends Parcelable, d<b>
{
  public static final class a
  {
    public long agxj;
    public long availableBlocks;
    public long blockSize;
    public long djV;
    public long totalBlocks;
  }
  
  public static abstract interface b
  {
    public abstract InputStream Lh(String paramString);
    
    public abstract long a(String paramString1, b paramb, String paramString2, boolean paramBoolean);
    
    public abstract void a(CancellationSignal paramCancellationSignal);
    
    public abstract boolean a(String paramString1, b paramb, String paramString2);
    
    public abstract ReadableByteChannel bDS(String paramString);
    
    public abstract ByteChannel bDT(String paramString);
    
    public abstract boolean bDU(String paramString);
    
    public abstract j bDV(String paramString);
    
    public abstract Iterable<j> bDW(String paramString);
    
    public abstract boolean bDX(String paramString);
    
    public abstract FileSystem.a bDY(String paramString);
    
    public abstract boolean cF(String paramString, long paramLong);
    
    public abstract WritableByteChannel et(String paramString, boolean paramBoolean);
    
    public abstract OutputStream ev(String paramString, boolean paramBoolean);
    
    public abstract boolean ew(String paramString, boolean paramBoolean);
    
    public abstract String ex(String paramString, boolean paramBoolean);
    
    public abstract boolean iP(String paramString);
    
    public abstract FileSystem jKa();
    
    public abstract int jKc();
    
    public abstract ParcelFileDescriptor qf(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */