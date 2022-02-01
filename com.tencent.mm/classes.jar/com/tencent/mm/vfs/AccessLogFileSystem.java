package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class AccessLogFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<AccessLogFileSystem> CREATOR;
  protected final FileSystem agvG;
  protected final int cN;
  
  static
  {
    AppMethodBeat.i(238351);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238351);
  }
  
  protected AccessLogFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238347);
    ah.a(paramParcel, AccessLogFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(238347);
      throw paramParcel;
    }
    this.cN = paramParcel.readInt();
    AppMethodBeat.o(238347);
  }
  
  protected final void a(int paramInt, String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(238384);
    if ((this.cN & paramInt) != 0) {
      l(0, new Object[] { "op", Integer.valueOf(paramInt), "path", paramString1, "fromFS", paramFileSystem, "fromPath", paramString2 });
    }
    AppMethodBeat.o(238384);
  }
  
  protected final void el(int paramInt, String paramString)
  {
    AppMethodBeat.i(238371);
    if ((this.cN & paramInt) != 0) {
      l(0, new Object[] { "op", Integer.valueOf(paramInt), "path", paramString });
    }
    AppMethodBeat.o(238371);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238366);
    if (!(paramObject instanceof AccessLogFileSystem))
    {
      AppMethodBeat.o(238366);
      return false;
    }
    paramObject = (AccessLogFileSystem)paramObject;
    if ((this.agvG.equals(paramObject.agvG)) && (this.cN == paramObject.cN))
    {
      AppMethodBeat.o(238366);
      return true;
    }
    AppMethodBeat.o(238366);
    return false;
  }
  
  protected final void eu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(238378);
    if ((this.cN & 0x80) != 0) {
      l(0, new Object[] { "op", Integer.valueOf(128), "path", paramString, "forWrite", Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(238378);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238361);
    int i = AccessLogFileSystem.class.hashCode();
    int j = ah.hash(new Object[] { this.agvG, Integer.valueOf(this.cN) });
    AppMethodBeat.o(238361);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238358);
    String str = "Log [" + this.agvG.toString() + "]";
    AppMethodBeat.o(238358);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238354);
    ah.b(paramParcel, AccessLogFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeInt(this.cN);
    AppMethodBeat.o(238354);
  }
  
  protected class a
    extends ai
  {
    a(FileSystem.b paramb)
    {
      super();
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238488);
      AccessLogFileSystem.this.el(1, paramString);
      paramString = super.Lh(paramString);
      AppMethodBeat.o(238488);
      return paramString;
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(238565);
      AccessLogFileSystem.this.a(256, paramString1, paramb.jKa(), paramString2);
      long l = super.b(paramString1, paramb, paramString2, paramBoolean);
      AppMethodBeat.o(238565);
      return l;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(238563);
      AccessLogFileSystem.this.a(512, paramString1, paramb.jKa(), paramString2);
      boolean bool = super.b(paramString1, paramb, paramString2);
      AppMethodBeat.o(238563);
      return bool;
    }
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238493);
      AccessLogFileSystem.this.el(1, paramString);
      paramString = super.bDS(paramString);
      AppMethodBeat.o(238493);
      return paramString;
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(238509);
      AccessLogFileSystem.this.el(2, paramString);
      paramString = super.bDT(paramString);
      AppMethodBeat.o(238509);
      return paramString;
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(238522);
      AccessLogFileSystem.this.el(4, paramString);
      boolean bool = super.bDU(paramString);
      AppMethodBeat.o(238522);
      return bool;
    }
    
    public final j bDV(String paramString)
    {
      AppMethodBeat.i(238529);
      AccessLogFileSystem.this.el(8, paramString);
      paramString = super.bDV(paramString);
      AppMethodBeat.o(238529);
      return paramString;
    }
    
    public final Iterable<j> bDW(String paramString)
    {
      AppMethodBeat.i(238543);
      AccessLogFileSystem.this.el(32, paramString);
      paramString = super.bDW(paramString);
      AppMethodBeat.o(238543);
      return paramString;
    }
    
    public final boolean bDX(String paramString)
    {
      AppMethodBeat.i(238546);
      AccessLogFileSystem.this.el(64, paramString);
      boolean bool = super.bDX(paramString);
      AppMethodBeat.o(238546);
      return bool;
    }
    
    public final boolean cF(String paramString, long paramLong)
    {
      AppMethodBeat.i(238533);
      boolean bool = super.cF(paramString, paramLong);
      AppMethodBeat.o(238533);
      return bool;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238574);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(238574);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.agwv.equals(paramObject.agwv)) && (AccessLogFileSystem.this.cN == paramObject.agvH.cN))
      {
        AppMethodBeat.o(238574);
        return true;
      }
      AppMethodBeat.o(238574);
      return false;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238505);
      AccessLogFileSystem.this.el(2, paramString);
      paramString = super.et(paramString, paramBoolean);
      AppMethodBeat.o(238505);
      return paramString;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238500);
      AccessLogFileSystem.this.el(2, paramString);
      paramString = super.ev(paramString, paramBoolean);
      AppMethodBeat.o(238500);
      return paramString;
    }
    
    public final boolean ew(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238553);
      AccessLogFileSystem.this.el(16, paramString);
      paramBoolean = super.ew(paramString, paramBoolean);
      AppMethodBeat.o(238553);
      return paramBoolean;
    }
    
    public final String ex(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238559);
      AccessLogFileSystem.this.eu(paramString, paramBoolean);
      paramString = super.ex(paramString, paramBoolean);
      AppMethodBeat.o(238559);
      return paramString;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238570);
      int i = a.class.hashCode();
      int j = ah.hash(new Object[] { this.agwv, Integer.valueOf(AccessLogFileSystem.this.cN) });
      AppMethodBeat.o(238570);
      return i ^ j;
    }
    
    public final boolean iP(String paramString)
    {
      AppMethodBeat.i(238538);
      AccessLogFileSystem.this.el(16, paramString);
      boolean bool = super.iP(paramString);
      AppMethodBeat.o(238538);
      return bool;
    }
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238516);
      if (paramString2.contains("w")) {}
      for (int i = 2;; i = 1)
      {
        AccessLogFileSystem.this.el(i, paramString1);
        paramString1 = super.qf(paramString1, paramString2);
        AppMethodBeat.o(238516);
        return paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.AccessLogFileSystem
 * JD-Core Version:    0.7.0.1
 */