package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;

public abstract class d
  implements c
{
  public boolean BcV = false;
  b BcW = null;
  protected byte[] BcX = null;
  public Object BcY = null;
  protected int BcZ;
  protected int Bda = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private final long ftT = 60000L;
  private Runnable ftX = new d.1(this);
  boolean jRa = false;
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  
  public final int a(b paramb)
  {
    if (this.BcX == null)
    {
      com.tencent.pb.common.c.c.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.BcZ });
      return -1;
    }
    this.BcW = paramb;
    paramb = new i(this);
    int i = f.dTH().a(null, paramb, this.BcZ, dTD(), this.BcX, this.Bda);
    if (i >= 0) {
      this.mHandler.postDelayed(this.ftX, 60000L);
    }
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", dTD(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, e parame)
  {
    this.BcZ = paramInt;
    Object localObject = null;
    try
    {
      parame = e.b(parame);
      this.BcX = parame;
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
  
  protected abstract Object ck(byte[] paramArrayOfByte);
  
  protected abstract String dTD();
  
  public abstract int getType();
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 2;
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.ftX);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", dTD(), Integer.valueOf(paramInt), Boolean.valueOf(this.jRa) });
    if (paramInt != 0)
    {
      com.tencent.pb.common.c.c.w("MicroMsg.Voip", new Object[] { this.TAG2, "getNetworkErrType errcode:".concat(String.valueOf(paramInt)) });
      if (paramInt == -1) {
        if (h.isNetworkConnected()) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jRa)
      {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.BcZ });
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
        this.BcY = ck(paramArrayOfByte);
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