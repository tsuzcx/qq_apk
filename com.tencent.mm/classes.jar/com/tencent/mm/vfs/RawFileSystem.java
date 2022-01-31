package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Map;

public class RawFileSystem
  extends FileBasedFileSystem
{
  public static final Parcelable.Creator<RawFileSystem> CREATOR;
  private volatile boolean AQs;
  
  static
  {
    AppMethodBeat.i(54589);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(54589);
  }
  
  private RawFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(54582);
    j.a(paramParcel, getClass());
    AppMethodBeat.o(54582);
  }
  
  public RawFileSystem(String paramString)
  {
    super(paramString);
  }
  
  public RawFileSystem(String paramString, byte paramByte)
  {
    super(paramString);
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54585);
    if (this.mReadOnly)
    {
      paramString = new IOException("Cannot open files for writing on read-only file systems");
      AppMethodBeat.o(54585);
      throw paramString;
    }
    String str = P(paramString, true);
    if (str == null)
    {
      paramString = new IOException("Invalid path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(54585);
      throw paramString;
    }
    paramString = new FileOutputStream(str, paramBoolean);
    AppMethodBeat.o(54585);
    return paramString;
  }
  
  public final int ajj()
  {
    AppMethodBeat.i(54583);
    int j = super.ajj() | 0x2;
    int i = j;
    if (this.AQs) {
      i = j | 0x4;
    }
    AppMethodBeat.o(54583);
    return i;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54584);
    String str = P(paramString, false);
    if (str == null)
    {
      paramString = new IOException("Invalid path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(54584);
      throw paramString;
    }
    paramString = new a(str);
    AppMethodBeat.o(54584);
    return paramString;
  }
  
  public final void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(54586);
    super.q(paramMap);
    String str = dQz();
    paramMap = (String)paramMap.get("data");
    if ((str == null) || (paramMap == null) || (!str.startsWith(paramMap))) {}
    for (boolean bool = true;; bool = false)
    {
      this.AQs = bool;
      AppMethodBeat.o(54586);
      return;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(54587);
    Object localObject = new StringBuilder("RawFS [").append(dQz());
    if (this.mReadOnly) {
      ((StringBuilder)localObject).append(", read-only");
    }
    localObject = ']';
    AppMethodBeat.o(54587);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54588);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(1);
    AppMethodBeat.o(54588);
  }
  
  static final class a
    extends FileInputStream
  {
    private long auV = 0L;
    
    a(String paramString)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      AppMethodBeat.i(54580);
      try
      {
        this.auV = getChannel().position();
        AppMethodBeat.o(54580);
        return;
      }
      catch (IOException localIOException)
      {
        RuntimeException localRuntimeException = new RuntimeException(localIOException);
        AppMethodBeat.o(54580);
        throw localRuntimeException;
      }
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(54581);
      getChannel().position(this.auV);
      AppMethodBeat.o(54581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RawFileSystem
 * JD-Core Version:    0.7.0.1
 */