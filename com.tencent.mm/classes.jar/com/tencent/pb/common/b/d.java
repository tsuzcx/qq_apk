package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;

public abstract class d
  implements c
{
  public final String TAG2 = getClass().getSimpleName();
  private final long edQ = 60000L;
  Runnable edV = new d.1(this);
  boolean hXh = false;
  private int mErrorCode = -999;
  Handler mHandler = new Handler(Looper.getMainLooper());
  public int wFA = 0;
  public boolean wFu = false;
  b wFv = null;
  public byte[] wFw = null;
  public Object wFx = null;
  public int wFy;
  public int wFz = 2;
  
  public abstract Object bK(byte[] paramArrayOfByte);
  
  public final void c(int paramInt, e parame)
  {
    this.wFy = paramInt;
    Object localObject = null;
    try
    {
      parame = e.b(parame);
      this.wFw = parame;
      return;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        parame = localObject;
      }
    }
  }
  
  public abstract String cNR();
  
  public abstract int getType();
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 2;
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.edV);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", cNR(), Integer.valueOf(paramInt), Boolean.valueOf(this.hXh) });
    if (paramInt != 0)
    {
      com.tencent.pb.common.c.c.x("MicroMsg.Voip", new Object[] { this.TAG2, "getNetworkErrType errcode:" + paramInt });
      if (paramInt == -1) {
        if (h.isNetworkConnected()) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.hXh)
      {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.wFy });
        return;
        if (paramInt == 6801) {
          i = 10;
        } else {
          i = 4;
        }
      }
      else
      {
        this.mErrorCode = paramInt;
        this.wFx = bK(paramArrayOfByte);
        this.mHandler.post(new d.2(this, i, paramInt));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.d
 * JD-Core Version:    0.7.0.1
 */