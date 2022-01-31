package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  private ah lqH = new a.1(this, Looper.getMainLooper());
  public boolean lqI = false;
  public boolean lqJ = false;
  public com.tencent.mm.plugin.voip_cs.b.a qeL = new com.tencent.mm.plugin.voip_cs.b.a(this.lqH);
  public a.a qeM = null;
  
  public static int Qh(String paramString)
  {
    paramString = paramString.split("\\.");
    int i = bk.getInt(paramString[0], 0);
    int j = bk.getInt(paramString[1], 0);
    int k = bk.getInt(paramString[2], 0);
    return bk.getInt(paramString[3], 0) + ((i << 24) + (j << 16) + (k << 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.b.a
 * JD-Core Version:    0.7.0.1
 */