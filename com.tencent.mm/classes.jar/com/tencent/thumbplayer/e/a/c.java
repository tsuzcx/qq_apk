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
  int ZCI;
  private long ZCO;
  private long ZCP;
  private boolean ZCQ;
  private volatile long ZCR;
  private long ZCS;
  b ZCT;
  String ZCU;
  private volatile long mCurrentOffset;
  private RandomAccessFile mRandomAccessFile;
  
  public c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.ZCO = paramLong1;
    this.mCurrentOffset = paramLong1;
    this.ZCR = paramLong1;
    this.ZCP = paramLong2;
    this.ZCQ = paramBoolean;
  }
  
  private boolean a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(220709);
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
    AppMethodBeat.o(220709);
    return bool1;
    try
    {
      this.mRandomAccessFile.close();
      label203:
      AppMethodBeat.o(220709);
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
  
  public final int WV(long paramLong)
  {
    int i = -1;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(220700);
        l = this.ZCR;
        if (paramLong >= l)
        {
          AppMethodBeat.o(220700);
          return i;
        }
        if (paramLong < this.ZCO)
        {
          g.e(TAG, "Offset less than mRequestedOffset");
          AppMethodBeat.o(220700);
          continue;
        }
        i = (int)Math.min(1048576L, l - paramLong);
      }
      finally {}
      g.i(TAG, "getDataReadyLength, readyLength:" + i + ", realOffset:" + l + ", requestOffset:" + paramLong + ", requestNum:" + this.ZCI);
      AppMethodBeat.o(220700);
    }
  }
  
  public final long getCurrentOffset()
  {
    return this.mCurrentOffset;
  }
  
  public final int getRequestNum()
  {
    return this.ZCI;
  }
  
  public final long getRequestedLength()
  {
    return this.ZCP;
  }
  
  public final long getRequestedOffset()
  {
    return this.ZCO;
  }
  
  public final void notifyDataReady(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(220704);
        if (paramLong1 + paramLong2 > this.ZCO + this.ZCP)
        {
          g.e(TAG, "data exceed the max request offset");
          AppMethodBeat.o(220704);
          return;
        }
        if (paramLong1 < this.ZCO) {
          g.w(TAG, "the notify data offset is less than request offset");
        }
        if (paramLong1 + paramLong2 < this.mCurrentOffset)
        {
          g.e(TAG, "data not reach current offset");
          AppMethodBeat.o(220704);
          continue;
        }
        this.mCurrentOffset = (paramLong1 + paramLong2);
      }
      finally {}
      this.ZCR = this.mCurrentOffset;
      g.i(TAG, "notifyDataReady, mRealOffset: " + this.ZCR + ", readyOffset:" + paramLong1 + ", readyLength:" + paramLong2 + ", requestNum:" + this.ZCI);
      AppMethodBeat.o(220704);
    }
  }
  
  public final void respondWithData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220707);
    if (this.ZCS > this.ZCP)
    {
      g.i(TAG, "respond full data");
      AppMethodBeat.o(220707);
      return;
    }
    int i = paramArrayOfByte.length;
    a locala = new a((byte)0);
    locala.ZCV = this.mCurrentOffset;
    locala.data = paramArrayOfByte;
    if (this.ZCT != null)
    {
      paramArrayOfByte = this.ZCT.obtainMessage();
      paramArrayOfByte.what = 256;
      paramArrayOfByte.arg1 = i;
      paramArrayOfByte.arg2 = 0;
      paramArrayOfByte.obj = locala;
      this.ZCT.sendMessage(paramArrayOfByte);
    }
    g.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + i);
    this.mCurrentOffset += i;
    long l = this.ZCS;
    this.ZCS = (i + l);
    AppMethodBeat.o(220707);
  }
  
  static final class a
  {
    long ZCV;
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
      AppMethodBeat.i(220685);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(220685);
        return;
        Object localObject = (c.a)paramMessage.obj;
        long l = ((c.a)localObject).ZCV;
        localObject = ((c.a)localObject).data;
        int i = paramMessage.arg1;
        if (!c.a(c.this, l, (byte[])localObject, c.a(c.this)))
        {
          g.e(c.TAG, "write data failed");
          AppMethodBeat.o(220685);
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