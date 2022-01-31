package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cjv;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> qSO;
  private boolean yB;
  
  public i()
  {
    this.yB = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.qSO = paramArrayList;
    this.yB = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    y.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.qSO });
    cjv localcjv = new cjv();
    if (this.qSO != null) {
      localcjv.tXz.addAll(this.qSO);
    }
    localcjv.tXA = this.yB;
    try
    {
      a.bYL();
      r.b(20004, localcjv.toByteArray(), false);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */