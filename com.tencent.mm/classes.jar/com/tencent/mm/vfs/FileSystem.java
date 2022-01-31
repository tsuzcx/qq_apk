package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public abstract boolean A(String paramString, long paramLong);
  
  public abstract OutputStream M(String paramString, boolean paramBoolean);
  
  public abstract List<a> N(String paramString, boolean paramBoolean);
  
  public abstract boolean O(String paramString, boolean paramBoolean);
  
  public abstract String P(String paramString, boolean paramBoolean);
  
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract boolean aV(String paramString1, String paramString2);
  
  public abstract int ajj();
  
  public abstract boolean exists(String paramString);
  
  public abstract InputStream openRead(String paramString);
  
  public abstract void q(Map<String, String> paramMap);
  
  public abstract boolean qD(String paramString);
  
  public abstract b uk(String paramString);
  
  public abstract a ul(String paramString);
  
  public abstract boolean um(String paramString);
  
  public static final class a
  {
    public final String APr;
    public final long APs;
    public final long APt;
    public final boolean APu;
    private final FileSystem APv;
    public final String name;
    public final long size;
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.APv = paramFileSystem;
      this.APr = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.APs = paramLong2;
      this.APt = paramLong3;
      this.APu = paramBoolean;
    }
    
    public final InputStream dQA()
    {
      AppMethodBeat.i(54504);
      InputStream localInputStream = this.APv.openRead(this.APr);
      AppMethodBeat.o(54504);
      return localInputStream;
    }
    
    public final boolean delete()
    {
      AppMethodBeat.i(54505);
      if (this.APu)
      {
        bool = this.APv.O(this.APr, false);
        AppMethodBeat.o(54505);
        return bool;
      }
      boolean bool = this.APv.qD(this.APr);
      AppMethodBeat.o(54505);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(54506);
      String str = this.APr + " -> " + this.APv.toString();
      if (this.APu)
      {
        str = "[DIR] ".concat(String.valueOf(str));
        AppMethodBeat.o(54506);
        return str;
      }
      AppMethodBeat.o(54506);
      return str;
    }
  }
  
  public static final class b
  {
    public long APw;
    public long bau;
    public long yqe;
    public long yqg;
    public long yqh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */