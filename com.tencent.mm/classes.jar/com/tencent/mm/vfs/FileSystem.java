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
  public abstract b cp(Map<String, String> paramMap);
  
  public static final class a
  {
    public long YCl;
    public long availableBlocks;
    public long blockSize;
    public long bqr;
    public long totalBlocks;
  }
  
  public static abstract interface b
  {
    public abstract InputStream Tf(String paramString);
    
    public abstract long a(String paramString1, b paramb, String paramString2, boolean paramBoolean);
    
    public abstract void a(CancellationSignal paramCancellationSignal);
    
    public abstract boolean a(String paramString1, b paramb, String paramString2);
    
    public abstract FileSystem.a bBA(String paramString);
    
    public abstract boolean bBB(String paramString);
    
    public abstract f bBC(String paramString);
    
    public abstract boolean bBD(String paramString);
    
    public abstract ReadableByteChannel bBy(String paramString);
    
    public abstract ByteChannel bBz(String paramString);
    
    public abstract boolean ct(String paramString, long paramLong);
    
    public abstract WritableByteChannel dH(String paramString, boolean paramBoolean);
    
    public abstract OutputStream dI(String paramString, boolean paramBoolean);
    
    public abstract Iterable<f> dJ(String paramString, boolean paramBoolean);
    
    public abstract boolean dK(String paramString, boolean paramBoolean);
    
    public abstract String dL(String paramString, boolean paramBoolean);
    
    public abstract boolean ho(String paramString);
    
    public abstract FileSystem ieX();
    
    public abstract int ieY();
    
    public abstract ParcelFileDescriptor oh(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */