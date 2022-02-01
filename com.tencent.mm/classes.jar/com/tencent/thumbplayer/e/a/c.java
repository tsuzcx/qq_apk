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
  int ahHL;
  private long ahHR;
  private long ahHS;
  private boolean ahHT;
  private volatile long ahHU;
  private long ahHV;
  b ahHW;
  String ahHX;
  private volatile long mCurrentOffset;
  private RandomAccessFile mRandomAccessFile;
  
  public c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.ahHR = paramLong1;
    this.mCurrentOffset = paramLong1;
    this.ahHU = paramLong1;
    this.ahHS = paramLong2;
    this.ahHT = paramBoolean;
  }
  
  private boolean a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(227012);
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
    AppMethodBeat.o(227012);
    return bool1;
    try
    {
      this.mRandomAccessFile.close();
      label203:
      AppMethodBeat.o(227012);
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
  
  public final int Bi(long paramLong)
  {
    int i = -1;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(227067);
        l = this.ahHU;
        if (paramLong >= l)
        {
          AppMethodBeat.o(227067);
          return i;
        }
        if (paramLong < this.ahHR)
        {
          g.e(TAG, "Offset less than mRequestedOffset");
          AppMethodBeat.o(227067);
          continue;
        }
        i = (int)Math.min(1048576L, l - paramLong);
      }
      finally {}
      g.i(TAG, "getDataReadyLength, readyLength:" + i + ", realOffset:" + l + ", requestOffset:" + paramLong + ", requestNum:" + this.ahHL);
      AppMethodBeat.o(227067);
    }
  }
  
  public final long getCurrentOffset()
  {
    return this.mCurrentOffset;
  }
  
  public final int getRequestNum()
  {
    return this.ahHL;
  }
  
  public final long getRequestedLength()
  {
    return this.ahHS;
  }
  
  public final long getRequestedOffset()
  {
    return this.ahHR;
  }
  
  public final void notifyDataReady(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(227078);
        if (paramLong1 + paramLong2 > this.ahHR + this.ahHS)
        {
          g.e(TAG, "data exceed the max request offset");
          AppMethodBeat.o(227078);
          return;
        }
        if (paramLong1 < this.ahHR) {
          g.w(TAG, "the notify data offset is less than request offset");
        }
        if (paramLong1 + paramLong2 < this.mCurrentOffset)
        {
          g.e(TAG, "data not reach current offset");
          AppMethodBeat.o(227078);
          continue;
        }
        this.mCurrentOffset = (paramLong1 + paramLong2);
      }
      finally {}
      this.ahHU = this.mCurrentOffset;
      g.i(TAG, "notifyDataReady, mRealOffset: " + this.ahHU + ", readyOffset:" + paramLong1 + ", readyLength:" + paramLong2 + ", requestNum:" + this.ahHL);
      AppMethodBeat.o(227078);
    }
  }
  
  public final void respondWithData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227089);
    if (this.ahHV > this.ahHS)
    {
      g.i(TAG, "respond full data");
      AppMethodBeat.o(227089);
      return;
    }
    int i = paramArrayOfByte.length;
    a locala = new a((byte)0);
    locala.ahHY = this.mCurrentOffset;
    locala.data = paramArrayOfByte;
    if (this.ahHW != null)
    {
      paramArrayOfByte = this.ahHW.obtainMessage();
      paramArrayOfByte.what = 256;
      paramArrayOfByte.arg1 = i;
      paramArrayOfByte.arg2 = 0;
      paramArrayOfByte.obj = locala;
      this.ahHW.sendMessage(paramArrayOfByte);
    }
    g.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + i);
    this.mCurrentOffset += i;
    long l = this.ahHV;
    this.ahHV = (i + l);
    AppMethodBeat.o(227089);
  }
  
  static final class a
  {
    long ahHY;
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
      AppMethodBeat.i(227022);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(227022);
        return;
        Object localObject = (c.a)paramMessage.obj;
        long l = ((c.a)localObject).ahHY;
        localObject = ((c.a)localObject).data;
        int i = paramMessage.arg1;
        if (!c.a(c.this, l, (byte[])localObject, c.a(c.this)))
        {
          g.e(c.TAG, "write data failed");
          AppMethodBeat.o(227022);
          return;
        }
        c.a(c.this, i + l);
        g.i(c.TAG, "write data from " + l + " , with dataLength" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.c
 * JD-Core Version:    0.7.0.1
 */