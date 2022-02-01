package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  public boolean IjR = false;
  b IjS = null;
  protected byte[] IjT = null;
  public Object IjU = null;
  protected int IjV;
  protected int IjW = 0;
  protected final String TAG2 = getClass().getSimpleName();
  private final long gVY = 60000L;
  private Runnable gWc = new Runnable()
  {
    public final void run()
    {
      d.this.mQd = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.flk() });
      com.tencent.pb.common.c.e.R(20006, 3, "-1104");
      if (d.this.IjS != null) {
        d.this.IjS.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mNetType = 2;
  boolean mQd = false;
  
  public final int a(b paramb)
  {
    if (this.IjT == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.IjV });
      return -1;
    }
    this.IjS = paramb;
    paramb = new i(this);
    int i = f.flo().a(null, paramb, this.IjV, flk(), this.IjT, this.IjW);
    if (i >= 0) {
      this.mHandler.postDelayed(this.gWc, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", flk(), Integer.valueOf(i) });
    return i;
  }
  
  public final void c(int paramInt, com.google.b.a.e parame)
  {
    this.IjV = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.b.a.e.b(parame);
      this.IjT = parame;
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
  
  protected abstract Object cC(byte[] paramArrayOfByte);
  
  protected abstract String flk();
  
  public abstract int getType();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.gWc);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", flk(), Integer.valueOf(paramInt), Boolean.valueOf(this.mQd) });
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
      if (this.mQd)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.IjV });
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
        this.IjU = cC(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.mQd) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.IjV });
            }
            while (d.this.IjS == null) {
              return;
            }
            d.this.IjS.a(i, paramInt, "", d.this);
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