package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

abstract class f$a<T>
{
  private ak handler;
  final int weU = Math.max(1, 16);
  LinkedList<T> weV = new LinkedList();
  
  public f$a(f paramf, Looper paramLooper)
  {
    this.handler = new f.a.1(this, paramLooper, paramf);
  }
  
  public final void cr(T paramT)
  {
    this.handler.sendMessage(this.handler.obtainMessage(1, paramT));
  }
  
  protected abstract T dpy();
  
  public final T dpz()
  {
    if (this.weV.isEmpty()) {
      return dpy();
    }
    return this.weV.removeFirst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.a
 * JD-Core Version:    0.7.0.1
 */