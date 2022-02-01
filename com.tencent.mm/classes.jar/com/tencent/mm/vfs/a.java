package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class a
  implements FileSystem.b
{
  private static FileSystem.b a(FileSystem.b paramb, String paramString, int paramInt)
  {
    while ((paramb instanceof f)) {
      paramb = ((f)paramb).jk(paramString, paramInt);
    }
    return paramb;
  }
  
  public long a(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    FileSystem.b localb = a(this, paramString1, 2);
    paramb = a(paramb, paramString2, 1);
    if ((localb == null) || (paramb == null)) {
      throw new IOException("Cannot resolve delegate filesystem.");
    }
    if ((localb instanceof a)) {
      return ((a)localb).b(paramString1, paramb, paramString2, paramBoolean);
    }
    return localb.a(paramString1, paramb, paramString2, paramBoolean);
  }
  
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public boolean a(String paramString1, FileSystem.b paramb, String paramString2)
  {
    FileSystem.b localb = a(this, paramString1, 2);
    paramb = a(paramb, paramString2, 1);
    if ((localb == null) || (paramb == null)) {
      throw new IOException("Cannot resolve delegate filesystem.");
    }
    if ((localb instanceof a)) {
      return ((a)localb).b(paramString1, paramb, paramString2);
    }
    return localb.a(paramString1, paramb, paramString2);
  }
  
  protected long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    return ah.a(paramb, paramString2, this, paramString1);
  }
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return false;
  }
  
  public ReadableByteChannel bDS(String paramString)
  {
    return Channels.newChannel(Lh(paramString));
  }
  
  public ByteChannel bDT(String paramString)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public WritableByteChannel et(String paramString, boolean paramBoolean)
  {
    return Channels.newChannel(ev(paramString, paramBoolean));
  }
  
  public ParcelFileDescriptor qf(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public String toString()
  {
    return "State -> " + jKa().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a
 * JD-Core Version:    0.7.0.1
 */