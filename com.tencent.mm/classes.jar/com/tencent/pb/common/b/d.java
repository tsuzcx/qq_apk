package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;

public abstract class d
  implements c
{
  protected final String TAG2 = getClass().getSimpleName();
  public boolean Zeg = false;
  b Zeh = null;
  private byte[] Zei = null;
  public Object Zej = null;
  int Zek;
  private int Zel = 0;
  private final long lCV = 60000L;
  private Runnable lCZ = new Runnable()
  {
    public final void run()
    {
      d.this.slX = true;
      com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", d.this.ikF() });
      com.tencent.pb.common.c.e.S(20006, 3, "-1104");
      if (d.this.Zeh != null) {
        d.this.Zeh.a(2, -1, "time exceed, force to callback", d.this);
      }
    }
  };
  private int mErrorCode = -999;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int mNetType = 2;
  boolean slX = false;
  
  public final int a(b paramb)
  {
    if (this.Zei == null)
    {
      com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { this.TAG2, "dosene reqData is null cmd=" + this.Zek });
      return -1;
    }
    this.Zeh = paramb;
    paramb = new i(this);
    int i = f.ikJ().a(null, paramb, this.Zek, ikF(), this.Zei, this.Zel);
    if (i >= 0) {
      this.mHandler.postDelayed(this.lCZ, 60000L);
    }
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", ikF(), Integer.valueOf(i) });
    return i;
  }
  
  protected final void a(d paramd)
  {
    this.Zei = paramd.Zei;
    this.Zek = paramd.Zek;
    this.Zel = paramd.Zel;
    this.mNetType = 1;
  }
  
  public final void aAc(int paramInt)
  {
    this.mNetType = paramInt;
  }
  
  public final void aAd(int paramInt)
  {
    this.Zel = paramInt;
  }
  
  public final void c(int paramInt, com.google.b.a.e parame)
  {
    this.Zek = paramInt;
    Object localObject = null;
    try
    {
      parame = com.google.b.a.e.b(parame);
      this.Zei = parame;
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
  
  protected abstract Object dn(byte[] paramArrayOfByte);
  
  public abstract int getType();
  
  protected abstract String ikF();
  
  public final void onResp(final int paramInt, byte[] paramArrayOfByte)
  {
    final int i = 2;
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "onResp errcode", Integer.valueOf(paramInt) });
    this.mHandler.removeCallbacks(this.lCZ);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV onResp:cmd= ", ikF(), Integer.valueOf(paramInt), Boolean.valueOf(this.slX) });
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
      if (this.slX)
      {
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { "onResp netscene already canceled, cmd:" + this.Zek });
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
        this.Zej = dn(paramArrayOfByte);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (d.this.slX) {
              com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.Zek });
            }
            while (d.this.Zeh == null) {
              return;
            }
            d.this.Zeh.a(i, paramInt, "", d.this);
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