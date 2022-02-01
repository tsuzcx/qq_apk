package com.tencent.thumbplayer.e.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class c
  implements ITPAssetResourceLoadingDataRequest
{
  private static String TAG = "TPAssetResourceLoadingDataRequest";
  int RZY;
  private long Sae;
  private long Saf;
  private boolean Sag;
  private volatile long Sah;
  private long Sai;
  b Saj;
  String Sak;
  private volatile long mCurrentOffset;
  private RandomAccessFile mRandomAccessFile;
  
  public c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.Sae = paramLong1;
    this.mCurrentOffset = paramLong1;
    this.Sah = paramLong1;
    this.Saf = paramLong2;
    this.Sag = paramBoolean;
  }
  
  private boolean a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(189264);
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        this.mRandomAccessFile = new RandomAccessFile(paramString, "rw");
        this.mRandomAccessFile.seek(paramLong);
        this.mRandomAccessFile.write(paramArrayOfByte);
        bool2 = true;
        bool1 = bool2;
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        g.e(TAG, "file not found");
        bool1 = bool2;
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          bool1 = bool2;
        }
        catch (IOException paramArrayOfByte)
        {
          g.e(TAG, "fail to close mRandomAccessFile");
          bool1 = bool2;
        }
        continue;
      }
      catch (IOException paramArrayOfByte)
      {
        g.e(TAG, "fail to write data");
        boolean bool1 = bool2;
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          bool1 = bool2;
        }
        catch (IOException paramArrayOfByte)
        {
          g.e(TAG, "fail to close mRandomAccessFile");
          bool1 = bool2;
        }
        continue;
      }
      finally
      {
        if (this.mRandomAccessFile == null) {
          break label203;
        }
      }
      try
      {
        this.mRandomAccessFile.close();
        bool1 = bool2;
      }
      catch (IOException paramArrayOfByte)
      {
        g.e(TAG, "fail to close mRandomAccessFile");
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(189264);
    return bool1;
    try
    {
      this.mRandomAccessFile.close();
      label203:
      AppMethodBeat.o(189264);
      throw paramArrayOfByte;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        g.e(TAG, "fail to close mRandomAccessFile");
      }
    }
  }
  
  public final int OF(long paramLong)
  {
    int i = -1;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(189261);
        l = this.Sah;
        if (paramLong >= l)
        {
          AppMethodBeat.o(189261);
          return i;
        }
        if (paramLong < this.Sae)
        {
          g.e(TAG, "Offset less than mRequestedOffset");
          AppMethodBeat.o(189261);
          continue;
        }
        i = (int)Math.min(1048576L, l - paramLong);
      }
      finally {}
      g.i(TAG, "getDataReadyLength, readyLength:" + i + ", realOffset:" + l + ", requestOffset:" + paramLong + ", requestNum:" + this.RZY);
      AppMethodBeat.o(189261);
    }
  }
  
  public final long getCurrentOffset()
  {
    return this.mCurrentOffset;
  }
  
  public final int getRequestNum()
  {
    return this.RZY;
  }
  
  public final long getRequestedLength()
  {
    return this.Saf;
  }
  
  public final long getRequestedOffset()
  {
    return this.Sae;
  }
  
  public final void notifyDataReady(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(189262);
        if (paramLong1 + paramLong2 > this.Sae + this.Saf)
        {
          g.e(TAG, "data exceed the max request offset");
          AppMethodBeat.o(189262);
          return;
        }
        if (paramLong1 < this.Sae) {
          g.w(TAG, "the notify data offset is less than request offset");
        }
        if (paramLong1 + paramLong2 < this.mCurrentOffset)
        {
          g.e(TAG, "data not reach current offset");
          AppMethodBeat.o(189262);
          continue;
        }
        this.mCurrentOffset = (paramLong1 + paramLong2);
      }
      finally {}
      this.Sah = this.mCurrentOffset;
      g.i(TAG, "notifyDataReady, mRealOffset: " + this.Sah + ", readyOffset:" + paramLong1 + ", readyLength:" + paramLong2 + ", requestNum:" + this.RZY);
      AppMethodBeat.o(189262);
    }
  }
  
  public final void respondWithData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189263);
    if (this.Sai > this.Saf)
    {
      g.i(TAG, "respond full data");
      AppMethodBeat.o(189263);
      return;
    }
    int i = paramArrayOfByte.length;
    a locala = new a((byte)0);
    locala.Sal = this.mCurrentOffset;
    locala.data = paramArrayOfByte;
    if (this.Saj != null)
    {
      paramArrayOfByte = this.Saj.obtainMessage();
      paramArrayOfByte.what = 256;
      paramArrayOfByte.arg1 = i;
      paramArrayOfByte.arg2 = 0;
      paramArrayOfByte.obj = locala;
      this.Saj.sendMessage(paramArrayOfByte);
    }
    g.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + i);
    this.mCurrentOffset += i;
    long l = this.Sai;
    this.Sai = (i + l);
    AppMethodBeat.o(189263);
  }
  
  static final class a
  {
    long Sal;
    byte[] data;
  }
  
  final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(189260);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189260);
        return;
        Object localObject = (c.a)paramMessage.obj;
        long l = ((c.a)localObject).Sal;
        localObject = ((c.a)localObject).data;
        int i = paramMessage.arg1;
        if (!c.a(c.this, l, (byte[])localObject, c.a(c.this)))
        {
          g.e(c.TAG, "write data failed");
          AppMethodBeat.o(189260);
          return;
        }
        c.a(c.this, i + l);
        g.i(c.TAG, "write data from " + l + " , with dataLength" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.c
 * JD-Core Version:    0.7.0.1
 */