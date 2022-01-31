package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

abstract class g$a<T>
{
  private ah handler;
  final int sms = Math.max(1, 16);
  LinkedList<T> smt = new LinkedList();
  
  public g$a(g paramg, Looper paramLooper)
  {
    this.handler = new g.a.1(this, paramLooper, paramg);
  }
  
  public final void bO(T paramT)
  {
    this.handler.sendMessage(this.handler.obtainMessage(1, paramT));
  }
  
  protected abstract T coj();
  
  public final T cok()
  {
    if (this.smt.isEmpty()) {
      return coj();
    }
    return this.smt.removeFirst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.a
 * JD-Core Version:    0.7.0.1
 */