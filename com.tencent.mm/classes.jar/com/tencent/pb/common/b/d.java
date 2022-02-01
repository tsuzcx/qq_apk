package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  public boolean LFl = false;
  b LFm = null;
  protected byte[] LFn = null;
  public Object LFo = null;
  protected int LFp;
  protected int LFq = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private final long hOM = 60000L;
  private Runnable hOQ = new Runnable()
  {
    public final void run()
    {
      d.this.nTk = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.fSQ() });
      com.tencent.pb.common.c.e.S(20006, 3, "-1104");
      if (d.this.LFm != null) {
        d.this.LFm.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  boolean nTk = false;
  
  public final int a(b paramb)
  {
    if (this.LFn == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.LFp });
      return -1;
    }
    this.LFm = paramb;
    paramb = new i(this);
    int i = f.fSU().a(null, paramb, this.LFp, fSQ(), this.LFn, this.LFq);
    if (i >= 0) {
      this.mHandler.postDelayed(this.hOQ, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", fSQ(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, com.google.b.a.e parame)
  {
    this.LFp = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.b.a.e.b(parame);
      this.LFn = parame;
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
  
  protected abstract Object cI(byte[] paramArrayOfByte);
  
  protected abstract String fSQ();
  
  public abstract int getType();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.hOQ);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", fSQ(), Integer.valueOf(paramInt), Boolean.valueOf(this.nTk) });
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
      if (this.nTk)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.LFp });
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
        this.LFo = cI(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.nTk) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.LFp });
            }
            while (d.this.LFm == null) {
              return;
            }
            d.this.LFm.a(i, paramInt, "", d.this);
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