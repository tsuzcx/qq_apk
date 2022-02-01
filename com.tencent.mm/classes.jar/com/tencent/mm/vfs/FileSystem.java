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
  
  public abstract ReadableByteChannel aSc(String paramString);
  
  public abstract ByteChannel aSd(String paramString);
  
  public abstract b aSe(String paramString);
  
  public abstract boolean aSf(String paramString);
  
  public abstract a aSg(String paramString);
  
  public abstract boolean aSh(String paramString);
  
  public abstract void bS(Map<String, String> paramMap);
  
  public abstract long c(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract WritableByteChannel cR(String paramString, boolean paramBoolean);
  
  public abstract OutputStream cS(String paramString, boolean paramBoolean);
  
  public abstract Iterable<a> cT(String paramString, boolean paramBoolean);
  
  public abstract boolean cU(String paramString, boolean paramBoolean);
  
  public abstract String cV(String paramString, boolean paramBoolean);
  
  public abstract boolean ch(String paramString, long paramLong);
  
  public abstract int fxC();
  
  public abstract ParcelFileDescriptor lT(String paramString1, String paramString2);
  
  public abstract InputStream openRead(String paramString);
  
  public abstract boolean zB(String paramString);
  
  public static final class a
  {
    public final String Gnx;
    public final long Jse;
    public final long Jsf;
    public final boolean Jsg;
    final FileSystem Jsh;
    public final String name;
    public final long size;
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.Jsh = paramFileSystem;
      this.Gnx = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.Jse = paramLong2;
      this.Jsf = paramLong3;
      this.Jsg = paramBoolean;
    }
    
    public final boolean delete()
    {
      AppMethodBeat.i(13102);
      if (this.Jsg)
      {
        bool = this.Jsh.cU(this.Gnx, false);
        AppMethodBeat.o(13102);
        return bool;
      }
      boolean bool = this.Jsh.zB(this.Gnx);
      AppMethodBeat.o(13102);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13103);
      String str = this.Gnx + " -> " + this.Jsh.toString();
      if (this.Jsg)
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
    public long Gua;
    public long Guc;
    public long Gud;
    public long Jsi;
    public long bwd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */