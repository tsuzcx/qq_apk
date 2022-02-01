package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private String Jrv;
  private d Jrw;
  
  private static FileSystem a(FileSystem paramFileSystem, String paramString, int paramInt)
  {
    while ((paramFileSystem instanceof DelegateFileSystem)) {
      paramFileSystem = ((DelegateFileSystem)paramFileSystem).gn(paramString, paramInt);
    }
    return paramFileSystem;
  }
  
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public final void a(String paramString, d paramd)
  {
    try
    {
      this.Jrv = paramString;
      this.Jrw = paramd;
      return;
    }
    finally {}
  }
  
  public boolean a(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = a(this, paramString1, 2);
    paramFileSystem = a(paramFileSystem, paramString2, 1);
    if ((localFileSystem == null) || (paramFileSystem == null)) {
      throw new IOException("Cannot resolve delegate filesystem.");
    }
    if ((localFileSystem instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)localFileSystem).b(paramString1, paramFileSystem, paramString2);
    }
    return localFileSystem.a(paramString1, paramFileSystem, paramString2);
  }
  
  public ReadableByteChannel aSc(String paramString)
  {
    return Channels.newChannel(openRead(paramString));
  }
  
  public ByteChannel aSd(String paramString)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  protected boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return false;
  }
  
  public void bS(Map<String, String> paramMap) {}
  
  public long c(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = a(this, paramString1, 2);
    paramFileSystem = a(paramFileSystem, paramString2, 1);
    if ((localFileSystem == null) || (paramFileSystem == null)) {
      throw new IOException("Cannot resolve delegate filesystem.");
    }
    if ((localFileSystem instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)localFileSystem).d(paramString1, paramFileSystem, paramString2);
    }
    return localFileSystem.c(paramString1, paramFileSystem, paramString2);
  }
  
  public WritableByteChannel cR(String paramString, boolean paramBoolean)
  {
    return Channels.newChannel(cS(paramString, paramBoolean));
  }
  
  protected long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return q.a(paramFileSystem, paramString2, this, paramString1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final void k(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    Object localObject1;
    for (paramVarArgs = null;; paramVarArgs = (Object[])localObject1)
    {
      Object localObject2;
      try
      {
        localObject1 = this.Jrv;
        localObject2 = this.Jrw;
        if (localObject2 != null) {
          ((d)localObject2).a((String)localObject1, this, paramInt, paramVarArgs);
        }
        return;
      }
      finally {}
      localObject1 = new HashMap(paramVarArgs.length / 2);
      int i = 0;
      while (i < paramVarArgs.length - 1)
      {
        int j = i + 1;
        localObject2 = paramVarArgs[i];
        if (j >= paramVarArgs.length) {
          break;
        }
        i = j + 1;
        Object localObject3 = paramVarArgs[j];
        ((Map)localObject1).put(localObject2.toString(), localObject3);
      }
    }
  }
  
  public ParcelFileDescriptor lT(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AbstractFileSystem
 * JD-Core Version:    0.7.0.1
 */