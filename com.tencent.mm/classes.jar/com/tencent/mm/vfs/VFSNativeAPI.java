package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.io.IOException;

final class VFSNativeAPI
{
  static int openFd(String paramString, int paramInt)
  {
    AppMethodBeat.i(13321);
    if ((paramInt & 0xFFFFF9BC) != 0)
    {
      paramString = new IllegalArgumentException("Flags unsupported: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(13321);
      throw paramString;
    }
    switch (paramInt & 0x3)
    {
    default: 
      paramString = new IllegalArgumentException("Invalid access mode: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(13321);
      throw paramString;
    case 0: 
      localObject1 = "r";
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if ((paramInt & 0x200) != 0) {
        localObject2 = (String)localObject1 + "t";
      }
      Object localObject3 = localObject2;
      if ((paramInt & 0x400) != 0) {
        localObject3 = (String)localObject2 + "a";
      }
      localObject2 = null;
      localObject1 = null;
      try
      {
        localObject3 = i.lB(paramString, (String)localObject3);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramInt = ((ParcelFileDescriptor)localObject3).detachFd();
          return paramInt;
          localObject1 = "w";
          continue;
          localObject1 = "rw";
        }
        else
        {
          q.closeQuietly((Closeable)localObject3);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject2 = localObject1;
          Log.e("VFS.VFSNativeAPI", localIOException, "Failed to open file descriptor for file: ".concat(String.valueOf(paramString)));
          q.closeQuietly((Closeable)localObject1);
        }
      }
      finally
      {
        q.closeQuietly((Closeable)localObject2);
        AppMethodBeat.o(13321);
      }
    }
    AppMethodBeat.o(13321);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSNativeAPI
 * JD-Core Version:    0.7.0.1
 */