package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  public boolean Mcp = false;
  b Mcq = null;
  protected byte[] Mcr = null;
  public Object Mcs = null;
  protected int Mct;
  protected int Mcu = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private final long hRF = 60000L;
  private Runnable hRJ = new Runnable()
  {
    public final void run()
    {
      d.this.nYQ = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.fXq() });
      com.tencent.pb.common.c.e.S(20006, 3, "-1104");
      if (d.this.Mcq != null) {
        d.this.Mcq.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  boolean nYQ = false;
  
  public final int a(b paramb)
  {
    if (this.Mcr == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.Mct });
      return -1;
    }
    this.Mcq = paramb;
    paramb = new i(this);
    int i = f.fXu().a(null, paramb, this.Mct, fXq(), this.Mcr, this.Mcu);
    if (i >= 0) {
      this.mHandler.postDelayed(this.hRJ, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", fXq(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, com.google.b.a.e parame)
  {
    this.Mct = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.b.a.e.b(parame);
      this.Mcr = parame;
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
  
  protected abstract Object cL(byte[] paramArrayOfByte);
  
  protected abstract String fXq();
  
  public abstract int getType();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.hRJ);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", fXq(), Integer.valueOf(paramInt), Boolean.valueOf(this.nYQ) });
    if (paramInt != 0)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "getNetworkErrType errcode:".concat(String.valueOf(paramInt)) });
      if (paramInt == -1) {
        if (h.isNetworkConnected()) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.nYQ)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.Mct });
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
        this.Mcs = cL(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.nYQ) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.Mct });
            }
            while (d.this.Mcq == null) {
              return;
            }
            d.this.Mcq.a(i, paramInt, "", d.this);
          }
        });
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.d
 * JD-Core Version:    0.7.0.1
 */