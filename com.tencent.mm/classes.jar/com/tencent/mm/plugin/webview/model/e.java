package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.b;
import com.tencent.mm.sdk.platformtools.ax.c;

public final class e
  implements ax.c<Integer, Long>
{
  public static final String[] dXp = { i.a(fCU, "JsLogBlockList") };
  private static final c.a fCU = ;
  public final h dXo;
  public final ax<Integer, Long> rfk;
  private long rfl;
  
  public e(h paramh)
  {
    this.dXo = paramh;
    this.rfk = new ax(this, au.DS().mnU.getLooper(), 100, 20, 300000L, 1000L);
  }
  
  public final boolean Rw()
  {
    if (this.dXo.inTransaction()) {}
    do
    {
      return false;
      this.rfl = this.dXo.eV(Thread.currentThread().getId());
    } while (this.rfl <= 0L);
    return true;
  }
  
  public final void Rx()
  {
    if (this.rfl > 0L) {
      this.dXo.hI(this.rfl);
    }
  }
  
  public final void a(ax<Integer, Long> paramax, ax.b<Integer, Long> paramb)
  {
    switch (paramb.uhL)
    {
    default: 
      return;
    case 2: 
      this.dXo.delete("JsLogBlockList", "logId=" + paramb.smD, null);
      return;
    }
    paramax = new ContentValues(2);
    paramax.put("logId", (Integer)paramb.smD);
    paramax.put("liftTime", (Long)paramb.values);
    this.dXo.replace("JsLogBlockList", "logId", paramax);
  }
  
  public final void cbF()
  {
    this.rfk.mx(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.e
 * JD-Core Version:    0.7.0.1
 */