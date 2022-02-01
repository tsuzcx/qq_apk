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
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract boolean a(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract ReadableByteChannel aMA(String paramString);
  
  public abstract ByteChannel aMB(String paramString);
  
  public abstract b aMC(String paramString);
  
  public abstract boolean aMD(String paramString);
  
  public abstract a aME(String paramString);
  
  public abstract boolean aMF(String paramString);
  
  public abstract void bN(Map<String, String> paramMap);
  
  public abstract long c(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract WritableByteChannel cL(String paramString, boolean paramBoolean);
  
  public abstract OutputStream cM(String paramString, boolean paramBoolean);
  
  public abstract Iterable<a> cN(String paramString, boolean paramBoolean);
  
  public abstract boolean cO(String paramString, boolean paramBoolean);
  
  public abstract String cP(String paramString, boolean paramBoolean);
  
  public abstract boolean cf(String paramString, long paramLong);
  
  public abstract int fhA();
  
  public abstract ParcelFileDescriptor lw(String paramString1, String paramString2);
  
  public abstract InputStream openRead(String paramString);
  
  public abstract boolean vv(String paramString);
  
  public static final class a
  {
    public final String EQk;
    public final long HRA;
    public final boolean HRB;
    final FileSystem HRC;
    public final long HRz;
    public final String name;
    public final long size;
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.HRC = paramFileSystem;
      this.EQk = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.HRz = paramLong2;
      this.HRA = paramLong3;
      this.HRB = paramBoolean;
    }
    
    public final boolean delete()
    {
      AppMethodBeat.i(13102);
      if (this.HRB)
      {
        bool = this.HRC.cO(this.EQk, false);
        AppMethodBeat.o(13102);
        return bool;
      }
      boolean bool = this.HRC.vv(this.EQk);
      AppMethodBeat.o(13102);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13103);
      String str = this.EQk + " -> " + this.HRC.toString();
      if (this.HRB)
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
    public long EWO;
    public long EWQ;
    public long EWR;
    public long HRD;
    public long byv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */