package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
  public static final Parcelable.Creator<RawFileSystem> CREATOR = new Parcelable.Creator() {};
  private volatile boolean wvs;
  
  private RawFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    j.a(paramParcel, getClass());
  }
  
  public RawFileSystem(String paramString)
  {
    super(paramString);
  }
  
  public RawFileSystem(String paramString, byte paramByte)
  {
    super(paramString);
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    if (this.mReadOnly) {
      throw new IOException("Cannot open files for writing on read-only file systems");
    }
    String str = L(paramString, true);
    if (str == null) {
      throw new IOException("Invalid path: " + paramString);
    }
    return new FileOutputStream(str, paramBoolean);
  }
  
  public final int Qd()
  {
    int j = super.Qd() | 0x2;
    int i = j;
    if (this.wvs) {
      i = j | 0x4;
    }
    return i;
  }
  
  public final void m(Map<String, String> paramMap)
  {
    super.m(paramMap);
    String str = cLh();
    paramMap = (String)paramMap.get("data");
    if ((str == null) || (paramMap == null) || (!str.startsWith(paramMap))) {}
    for (boolean bool = true;; bool = false)
    {
      this.wvs = bool;
      return;
    }
  }
  
  public final InputStream openRead(String paramString)
  {
    String str = L(paramString, false);
    if (str == null) {
      throw new IOException("Invalid path: " + paramString);
    }
    return new a(str);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RawFS [").append(cLh());
    if (this.mReadOnly) {
      localStringBuilder.append(", read-only");
    }
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(1);
  }
  
  private static final class a
    extends FileInputStream
  {
    private long asE = 0L;
    
    a(String paramString)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      try
      {
        this.asE = getChannel().position();
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final void reset()
    {
      getChannel().position(this.asE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RawFileSystem
 * JD-Core Version:    0.7.0.1
 */