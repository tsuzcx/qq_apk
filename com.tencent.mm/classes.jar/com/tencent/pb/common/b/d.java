package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  protected final String TAG2 = getClass().getSimpleName();
  public boolean ahcK = false;
  b ahcL = null;
  private byte[] ahcM = null;
  public Object ahcN = null;
  private int ahcO = 0;
  int bDJ;
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int mNetType = 2;
  private final long ouG = 60000L;
  private Runnable ouK = new Runnable()
  {
    public final void run()
    {
      d.this.vxW = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.jQW() });
      com.tencent.pb.common.c.e.ad(20006, 3, "-1104");
      if (d.this.ahcL != null) {
        d.this.ahcL.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  boolean vxW = false;
  
  public final int a(b paramb)
  {
    if (this.ahcM == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.bDJ });
      return -1;
    }
    this.ahcL = paramb;
    paramb = new i(this);
    int i = f.jRa().a(null, paramb, this.bDJ, jQW(), this.ahcM, this.ahcO);
    if (i >= 0) {
      this.mHandler.postDelayed(this.ouK, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", jQW(), Integer.valueOf(i) });
    return i;
  }
  
  protected final void a(d paramd)
  {
    this.ahcM = paramd.ahcM;
    this.bDJ = paramd.bDJ;
    this.ahcO = paramd.ahcO;
    this.mNetType = 1;
  }
  
  public final void aGP(int paramInt)
  {
    this.mNetType = paramInt;
  }
  
  public final void aGQ(int paramInt)
  {
    this.ahcO = paramInt;
  }
  
  public final void c(int paramInt, com.google.d.a.e parame)
  {
    this.bDJ = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.d.a.e.b(parame);
      this.ahcM = parame;
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
  
  protected abstract Object dp(byte[] paramArrayOfByte);
  
  public abstract int getType();
  
  protected abstract String jQW();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.ouK);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", jQW(), Integer.valueOf(paramInt), Boolean.valueOf(this.vxW) });
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
      if (this.vxW)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.bDJ });
        return;
        if (paramInt == 6801) {
          i = 10;
        } else {
          i = 4;
        }
      }
      else
      {
        if (this.ahcK) {}
        this.mErrorCode = paramInt;
        this.ahcN = dp(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.vxW) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.bDJ });
            }
            while (d.this.ahcL == null) {
              return;
            }
            d.this.ahcL.a(i, paramInt, "", d.this);
          }
        });
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.pb.common.b.d
 * JD-Core Version:    0.7.0.1
 */