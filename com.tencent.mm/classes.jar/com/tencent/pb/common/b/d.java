package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  public boolean RCE = false;
  b RCF = null;
  protected byte[] RCG = null;
  public Object RCH = null;
  protected int RCI;
  protected int RCJ = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private final long iMN = 60000L;
  private Runnable iMR = new Runnable()
  {
    public final void run()
    {
      d.this.pjO = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.hiV() });
      com.tencent.pb.common.c.e.U(20006, 3, "-1104");
      if (d.this.RCF != null) {
        d.this.RCF.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  boolean pjO = false;
  
  public final int a(b paramb)
  {
    if (this.RCG == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.RCI });
      return -1;
    }
    this.RCF = paramb;
    paramb = new i(this);
    int i = f.hiZ().a(null, paramb, this.RCI, hiV(), this.RCG, this.RCJ);
    if (i >= 0) {
      this.mHandler.postDelayed(this.iMR, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", hiV(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, com.google.a.a.e parame)
  {
    this.RCI = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.a.a.e.b(parame);
      this.RCG = parame;
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
  
  protected abstract Object cO(byte[] paramArrayOfByte);
  
  public abstract int getType();
  
  protected abstract String hiV();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.iMR);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", hiV(), Integer.valueOf(paramInt), Boolean.valueOf(this.pjO) });
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
      if (this.pjO)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.RCI });
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
        this.RCH = cO(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.pjO) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.RCI });
            }
            while (d.this.RCF == null) {
              return;
            }
            d.this.RCF.a(i, paramInt, "", d.this);
          }
        });
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.d
 * JD-Core Version:    0.7.0.1
 */