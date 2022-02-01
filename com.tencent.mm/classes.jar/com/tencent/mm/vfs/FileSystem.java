package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public abstract boolean CA(String paramString);
  
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract boolean a(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract ReadableByteChannel aYb(String paramString);
  
  public abstract ByteChannel aYc(String paramString);
  
  public abstract b aYd(String paramString);
  
  public abstract boolean aYe(String paramString);
  
  public abstract a aYf(String paramString);
  
  public abstract boolean aYg(String paramString);
  
  public abstract void bY(Map<String, String> paramMap);
  
  public abstract long c(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract WritableByteChannel cW(String paramString, boolean paramBoolean);
  
  public abstract OutputStream cX(String paramString, boolean paramBoolean);
  
  public abstract Iterable<a> cY(String paramString, boolean paramBoolean);
  
  public abstract boolean cZ(String paramString, boolean paramBoolean);
  
  public abstract boolean cn(String paramString, long paramLong);
  
  public abstract String da(String paramString, boolean paramBoolean);
  
  public abstract int fOp();
  
  public abstract ParcelFileDescriptor mt(String paramString1, String paramString2);
  
  public abstract InputStream openRead(String paramString);
  
  public static final class a
  {
    public final String HZk;
    public final long LjJ;
    public final long LjK;
    public final boolean LjL;
    final FileSystem LjM;
    public final String name;
    public final long size;
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.LjM = paramFileSystem;
      this.HZk = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.LjJ = paramLong2;
      this.LjK = paramLong3;
      this.LjL = paramBoolean;
    }
    
    public final boolean delete()
    {
      AppMethodBeat.i(13102);
      if (this.LjL)
      {
        bool = this.LjM.cZ(this.HZk, false);
        AppMethodBeat.o(13102);
        return bool;
      }
      boolean bool = this.LjM.CA(this.HZk);
      AppMethodBeat.o(13102);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13103);
      String str = this.HZk + " -> " + this.LjM.toString();
      if (this.LjL)
      {
        str = "[DIR] ".concat(String.valueOf(str));
        AppMethodBeat.o(13103);
        return str;
      }
      AppMethodBeat.o(13103);
      return str;
    }
  }
  
  public static final class b
  {
    public long IfV;
    public long IfX;
    public long IfY;
    public long LjN;
    public long bGr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */