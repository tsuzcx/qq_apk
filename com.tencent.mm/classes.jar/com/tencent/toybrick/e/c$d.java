package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Message;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c$d
  implements Runnable
{
  private Object object;
  private WeakReference<b> xbJ;
  private WeakReference<f> xbL;
  private c.b xbM;
  
  public c$d(c paramc, f paramf, b paramb, c.b paramb1)
  {
    this.xbL = new WeakReference(paramf);
    this.xbJ = new WeakReference(paramb);
    this.xbM = paramb1;
  }
  
  public final void run()
  {
    Object localObject = (b)this.xbJ.get();
    f localf = (f)this.xbL.get();
    if ((localObject != null) && (localf != null))
    {
      this.object = ((b)localObject).cRb();
      localObject = new Message();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = this;
      c.a(this.xbG).sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.toybrick.e.c.d
 * JD-Core Version:    0.7.0.1
 */