package com.tencent.toybrick.e;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c
{
  public static volatile c MGx;
  private Handler mMainHandler;
  
  static
  {
    AppMethodBeat.i(159981);
    MGx = new c();
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
          if ((locala != null) && (locala.MGF.hashCode() == c.c.b(paramAnonymousMessage)))
          {
            c.c.d(paramAnonymousMessage).Q(locala, c.c.c(paramAnonymousMessage));
            AppMethodBeat.o(159971);
            return;
          }
          ap.w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
          AppMethodBeat.o(159971);
          return;
        }
        if (paramAnonymousMessage.what == 3)
        {
          paramAnonymousMessage = (c.d)paramAnonymousMessage.obj;
          c.d.c(paramAnonymousMessage).h(c.d.a(paramAnonymousMessage).get(), ((Boolean)c.d.b(paramAnonymousMessage)).booleanValue());
        }
        AppMethodBeat.o(159971);
      }
    };
    AppMethodBeat.o(159977);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(224523);
    a.gdh().execute(paramRunnable);
    AppMethodBeat.o(224523);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, ImageView paramImageView)
  {
    AppMethodBeat.i(159979);
    parama = new c(parama, paramb, new a() {}, parama.MGF.hashCode());
    a.gdh().execute(parama);
    AppMethodBeat.o(159979);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, a parama1)
  {
    AppMethodBeat.i(159978);
    parama = new c(parama, paramb, parama1, parama.MGF.hashCode());
    a.gdh().execute(parama);
    AppMethodBeat.o(159978);
  }
  
  public static abstract interface a<H, T>
  {
    public abstract void Q(H paramH, T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract void h(T paramT, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private WeakReference<com.tencent.toybrick.f.a> MGA;
    private WeakReference<b> MGB;
    private c.a MGC;
    private int key;
    private Object object;
    
    public c(com.tencent.toybrick.f.a parama, b paramb, c.a parama1, int paramInt)
    {
      AppMethodBeat.i(159973);
      this.MGA = new WeakReference(parama);
      this.MGB = new WeakReference(paramb);
      this.MGC = parama1;
      this.key = paramInt;
      AppMethodBeat.o(159973);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159974);
      Object localObject = (com.tencent.toybrick.f.a)this.MGA.get();
      b localb = (b)this.MGB.get();
      if ((localObject != null) && (localb != null))
      {
        this.object = localb.gdi();
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
    private WeakReference<b> MGB;
    private WeakReference<f> MGD;
    private c.b MGE;
    private Object object;
    
    public d(f paramf, b paramb, c.b paramb1)
    {
      AppMethodBeat.i(159975);
      this.MGD = new WeakReference(paramf);
      this.MGB = new WeakReference(paramb);
      this.MGE = paramb1;
      AppMethodBeat.o(159975);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159976);
      Object localObject = (b)this.MGB.get();
      f localf = (f)this.MGD.get();
      if ((localObject != null) && (localf != null))
      {
        this.object = ((b)localObject).gdi();
        localObject = new Message();
        ((Message)localObject).what = 3;
        ((Message)localObject).obj = this;
        c.a(c.this).sendMessage((Message)localObject);
      }
      AppMethodBeat.o(159976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.e.c
 * JD-Core Version:    0.7.0.1
 */