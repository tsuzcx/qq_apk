package com.tencent.toybrick.e;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c
{
  public static volatile c IHo;
  private Handler mMainHandler;
  
  static
  {
    AppMethodBeat.i(159981);
    IHo = new c();
    AppMethodBeat.o(159981);
  }
  
  private c()
  {
    AppMethodBeat.i(159977);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(159971);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 2)
        {
          paramAnonymousMessage = (c.c)paramAnonymousMessage.obj;
          com.tencent.toybrick.f.a locala = (com.tencent.toybrick.f.a)c.c.a(paramAnonymousMessage).get();
          if ((locala != null) && (locala.IHw.hashCode() == c.c.b(paramAnonymousMessage)))
          {
            c.c.d(paramAnonymousMessage).O(locala, c.c.c(paramAnonymousMessage));
            AppMethodBeat.o(159971);
            return;
          }
          an.w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
          AppMethodBeat.o(159971);
          return;
        }
        if (paramAnonymousMessage.what == 3)
        {
          paramAnonymousMessage = (c.d)paramAnonymousMessage.obj;
          c.d.c(paramAnonymousMessage).f(c.d.a(paramAnonymousMessage).get(), ((Boolean)c.d.b(paramAnonymousMessage)).booleanValue());
        }
        AppMethodBeat.o(159971);
      }
    };
    AppMethodBeat.o(159977);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(202398);
    a.fpj().execute(paramRunnable);
    AppMethodBeat.o(202398);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, ImageView paramImageView)
  {
    AppMethodBeat.i(159979);
    parama = new c(parama, paramb, new a() {}, parama.IHw.hashCode());
    a.fpj().execute(parama);
    AppMethodBeat.o(159979);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, a parama1)
  {
    AppMethodBeat.i(159978);
    parama = new c(parama, paramb, parama1, parama.IHw.hashCode());
    a.fpj().execute(parama);
    AppMethodBeat.o(159978);
  }
  
  public static abstract interface a<H, T>
  {
    public abstract void O(H paramH, T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract void f(T paramT, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private WeakReference<com.tencent.toybrick.f.a> IHr;
    private WeakReference<b> IHs;
    private c.a IHt;
    private int key;
    private Object object;
    
    public c(com.tencent.toybrick.f.a parama, b paramb, c.a parama1, int paramInt)
    {
      AppMethodBeat.i(159973);
      this.IHr = new WeakReference(parama);
      this.IHs = new WeakReference(paramb);
      this.IHt = parama1;
      this.key = paramInt;
      AppMethodBeat.o(159973);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159974);
      Object localObject = (com.tencent.toybrick.f.a)this.IHr.get();
      b localb = (b)this.IHs.get();
      if ((localObject != null) && (localb != null))
      {
        this.object = localb.fpk();
        localObject = new Message();
        ((Message)localObject).what = 2;
        ((Message)localObject).obj = this;
        c.a(c.this).sendMessage((Message)localObject);
      }
      AppMethodBeat.o(159974);
    }
  }
  
  public final class d
    implements Runnable
  {
    private WeakReference<b> IHs;
    private WeakReference<f> IHu;
    private c.b IHv;
    private Object object;
    
    public d(f paramf, b paramb, c.b paramb1)
    {
      AppMethodBeat.i(159975);
      this.IHu = new WeakReference(paramf);
      this.IHs = new WeakReference(paramb);
      this.IHv = paramb1;
      AppMethodBeat.o(159975);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159976);
      Object localObject = (b)this.IHs.get();
      f localf = (f)this.IHu.get();
      if ((localObject != null) && (localf != null))
      {
        this.object = ((b)localObject).fpk();
        localObject = new Message();
        ((Message)localObject).what = 3;
        ((Message)localObject).obj = this;
        c.a(c.this).sendMessage((Message)localObject);
      }
      AppMethodBeat.o(159976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.e.c
 * JD-Core Version:    0.7.0.1
 */