package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c
{
  public static volatile c xbF = new c();
  private Handler mMainHandler = new c.1(this, Looper.getMainLooper());
  
  public static void execute(Runnable paramRunnable)
  {
    a.cRa().execute(paramRunnable);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, ImageView paramImageView)
  {
    parama = new c(parama, paramb, new c.2(this, new WeakReference(paramImageView)), parama.xbN.hashCode());
    a.cRa().execute(parama);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, a parama1)
  {
    parama = new c(parama, paramb, parama1, parama.xbN.hashCode());
    a.cRa().execute(parama);
  }
  
  public static abstract interface a<H, T>
  {
    public abstract void t(H paramH, T paramT);
  }
  
  private final class c
    implements Runnable
  {
    private int key;
    private Object object;
    private WeakReference<com.tencent.toybrick.f.a> xbI;
    private WeakReference<b> xbJ;
    private c.a xbK;
    
    public c(com.tencent.toybrick.f.a parama, b paramb, c.a parama1, int paramInt)
    {
      this.xbI = new WeakReference(parama);
      this.xbJ = new WeakReference(paramb);
      this.xbK = parama1;
      this.key = paramInt;
    }
    
    public final void run()
    {
      Object localObject2 = (com.tencent.toybrick.f.a)this.xbI.get();
      Object localObject1 = (b)this.xbJ.get();
      if ((localObject2 != null) && (localObject1 != null))
      {
        localObject2 = ((com.tencent.toybrick.f.a)localObject2).xbN;
        this.object = ((b)localObject1).cRb();
        localObject1 = new Message();
        ((Message)localObject1).what = 2;
        ((Message)localObject1).obj = this;
        c.a(c.this).sendMessage((Message)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.e.c
 * JD-Core Version:    0.7.0.1
 */