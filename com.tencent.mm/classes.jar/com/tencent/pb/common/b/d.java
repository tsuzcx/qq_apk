package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  public boolean JLC = false;
  b JLD = null;
  protected byte[] JLE = null;
  public Object JLF = null;
  protected int JLG;
  protected int JLH = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private Runnable hwB = new Runnable()
  {
    public final void run()
    {
      d.this.nso = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.fBB() });
      com.tencent.pb.common.c.e.Q(20006, 3, "-1104");
      if (d.this.JLD != null) {
        d.this.JLD.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private final long hwx = 60000L;
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  boolean nso = false;
  
  public final int a(b paramb)
  {
    if (this.JLE == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.JLG });
      return -1;
    }
    this.JLD = paramb;
    paramb = new i(this);
    int i = f.fBF().a(null, paramb, this.JLG, fBB(), this.JLE, this.JLH);
    if (i >= 0) {
      this.mHandler.postDelayed(this.hwB, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", fBB(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, com.google.b.a.e parame)
  {
    this.JLG = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.b.a.e.b(parame);
      this.JLE = parame;
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
  
  protected abstract Object cB(byte[] paramArrayOfByte);
  
  protected abstract String fBB();
  
  public abstract int getType();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.hwB);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", fBB(), Integer.valueOf(paramInt), Boolean.valueOf(this.nso) });
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
      if (this.nso)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.JLG });
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
        this.JLF = cB(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.nso) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.JLG });
            }
            while (d.this.JLD == null) {
              return;
            }
            d.this.JLD.a(i, paramInt, "", d.this);
          }
        });
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.d
 * JD-Core Version:    0.7.0.1
 */