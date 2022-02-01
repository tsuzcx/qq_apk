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
    while ((paramb instanceof c)) {
      paramb = ((c)paramb).ho(paramString, paramInt);
    }
    return paramb;
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
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return false;
  }
  
  public ReadableByteChannel boI(String paramString)
  {
    return Channels.newChannel(openRead(paramString));
  }
  
  public ByteChannel boJ(String paramString)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public long c(String paramString1, FileSystem.b paramb, String paramString2)
  {
    FileSystem.b localb = a(this, paramString1, 2);
    paramb = a(paramb, paramString2, 1);
    if ((localb == null) || (paramb == null)) {
      throw new IOException("Cannot resolve delegate filesystem.");
    }
    if ((localb instanceof a)) {
      return ((a)localb).d(paramString1, paramb, paramString2);
    }
    return localb.c(paramString1, paramb, paramString2);
  }
  
  protected long d(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return aa.a(paramb, paramString2, this, paramString1);
  }
  
  public WritableByteChannel dv(String paramString, boolean paramBoolean)
  {
    return Channels.newChannel(dw(paramString, paramBoolean));
  }
  
  public ParcelFileDescriptor nr(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a
 * JD-Core Version:    0.7.0.1
 */