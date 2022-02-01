package com.tencent.mm.ui.n.a;

import android.content.Context;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class d
  implements a
{
  final e XJB;
  private WeakReference<FrameLayout> XJC;
  public MagicBrushView XJD;
  private int XJE;
  boolean XJF;
  private final MagicBrushView.c XJG;
  private boolean mIsRunning;
  
  public d(e parame)
  {
    AppMethodBeat.i(286724);
    this.mIsRunning = false;
    this.XJE = -1;
    this.XJF = false;
    this.XJG = new MagicBrushView.c()
    {
      public final void a(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(284360);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceAvailable: %d, %s, %d, %d, %b", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(paramAnonymousBoolean) });
        d.this.mG(paramAnonymousInt1, paramAnonymousInt2);
        d.this.XJF = true;
        if ((d.this.XJB != null) && (d.this.XJB.XJI != null))
        {
          paramAnonymousObject = d.this.XJB.XJI;
          Log.i("MicroMsg.MagicEmojiService", "hy: surface ready, flush pending msgs with size: %d", new Object[] { Integer.valueOf(paramAnonymousObject.XJT.size()) });
          Iterator localIterator = paramAnonymousObject.XJT.iterator();
          while (localIterator.hasNext()) {
            paramAnonymousObject.c((c)localIterator.next());
          }
          paramAnonymousObject.XJT.clear();
        }
        AppMethodBeat.o(284360);
      }
      
      public final void b(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(284358);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceSizeChanged %d %s %d %d", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (d.this.XJB != null) {}
        for (paramAnonymousObject = d.this.XJB.XJI;; paramAnonymousObject = null)
        {
          if (paramAnonymousObject != null) {
            paramAnonymousObject.hXr();
          }
          d.this.mG(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(284358);
          return;
        }
      }
      
      public final void b(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(284361);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceDestroyed: %d, %s, %b", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Boolean.valueOf(paramAnonymousBoolean) });
        d.this.XJF = false;
        AppMethodBeat.o(284361);
      }
    };
    this.XJB = parame;
    AppMethodBeat.o(286724);
  }
  
  private void detach()
  {
    AppMethodBeat.i(286729);
    Log.i("MicroMsg.MagicEmojiPage", "hy: detach magic brush");
    if (this.XJC != null) {}
    for (FrameLayout localFrameLayout = (FrameLayout)this.XJC.get();; localFrameLayout = null)
    {
      if (localFrameLayout != null) {
        localFrameLayout.removeView(this.XJD);
      }
      if (this.XJD != null)
      {
        this.XJD.destroy();
        this.XJD.b(this.XJG);
        this.XJD = null;
      }
      AppMethodBeat.o(286729);
      return;
    }
  }
  
  private void lT()
  {
    AppMethodBeat.i(286726);
    Log.i("MicroMsg.MagicEmojiPage", "hy: page attaching");
    FrameLayout localFrameLayout = (FrameLayout)this.XJC.get();
    if (localFrameLayout == null)
    {
      com.tencent.mm.ui.n.b.a.bAw("holder is released!");
      Log.w("MicroMsg.MagicEmojiPage", "hy: holder is released!");
      AppMethodBeat.o(286726);
      return;
    }
    com.tencent.magicbrush.e locale;
    if (this.XJD == null)
    {
      localObject = MMApplicationContext.getContext();
      Log.i("MicroMsg.MagicEmojiPage", "hy: creating magic brush view");
      localObject = new MagicBrushView((Context)localObject, MagicBrushView.h.cPU);
      ((MagicBrushView)localObject).setOpaque(false);
      ((MagicBrushView)localObject).setEnableTouchEvent(false);
      locale = this.XJB.XJI.XJS.getMagicBrush();
      if (this.XJE >= 0) {
        break label187;
      }
      ((MagicBrushView)localObject).setMagicBrush(locale);
      Log.i("MicroMsg.MagicEmojiPage", "hy: first magicbrush view: %d", new Object[] { Integer.valueOf(this.XJE) });
      this.XJE = ((MagicBrushView)localObject).getVirtualElementId();
    }
    for (;;)
    {
      ((MagicBrushView)localObject).a(this.XJG);
      this.XJD = ((MagicBrushView)localObject);
      if ((!this.XJD.isAttachedToWindow()) && (this.XJD.getParent() != localFrameLayout)) {
        break;
      }
      Log.i("MicroMsg.MagicEmojiPage", "hy: already attached");
      AppMethodBeat.o(286726);
      return;
      label187:
      Log.i("MicroMsg.MagicEmojiPage", "hy: already has magicbrush view: %d", new Object[] { Integer.valueOf(this.XJE) });
      ((MagicBrushView)localObject).a(locale, this.XJE);
    }
    Log.i("MicroMsg.MagicEmojiPage", "hy: view not attached. need re-attach");
    Object localObject = this.XJD.getParent();
    if ((localObject instanceof ViewGroup))
    {
      Log.i("MicroMsg.MagicEmojiPage", "hy: need remove first");
      ((ViewGroup)localObject).removeView(this.XJD);
    }
    for (;;)
    {
      this.XJD.setViewType(MagicBrushView.h.cPU);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.XJD, (ViewGroup.LayoutParams)localObject);
      Log.i("MicroMsg.MagicEmojiPage", "hy: attach done");
      AppMethodBeat.o(286726);
      return;
      if (localObject != null) {
        Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: view parent is not null and is not view group!", new Object[0]);
      }
    }
  }
  
  public final void GW(boolean paramBoolean)
  {
    AppMethodBeat.i(286727);
    if (this.mIsRunning != paramBoolean)
    {
      Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: running state change to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mIsRunning = paramBoolean;
      if (this.mIsRunning)
      {
        lT();
        AppMethodBeat.o(286727);
        return;
      }
      detach();
      AppMethodBeat.o(286727);
      return;
    }
    Log.w("MicroMsg.MagicEmojiPage", "hy: same running state %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(286727);
  }
  
  public final void hXm()
  {
    AppMethodBeat.i(286732);
    if (!this.XJF)
    {
      Log.w("MicroMsg.MagicEmojiPage", "hy: surface not prepared, but still need playing. use page view size as window width and height");
      Point localPoint = hXn();
      mG(localPoint.x, localPoint.y);
    }
    AppMethodBeat.o(286732);
  }
  
  public final Point hXn()
  {
    AppMethodBeat.i(286733);
    Object localObject = (FrameLayout)this.XJC.get();
    if (localObject == null)
    {
      Log.w("MicroMsg.MagicEmojiPage", "hy: holder released, get page size failed");
      localObject = new Point(0, 0);
      AppMethodBeat.o(286733);
      return localObject;
    }
    if ((this.XJD != null) && (this.XJD.getWidth() > 0) && (this.XJD.getHeight() > 0)) {
      this.XJD.isAttachedToWindow();
    }
    localObject = new Point(((FrameLayout)localObject).getWidth(), ((FrameLayout)localObject).getHeight());
    AppMethodBeat.o(286733);
    return localObject;
  }
  
  final void i(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(286730);
    if (this.XJC != null) {}
    for (FrameLayout localFrameLayout = (FrameLayout)this.XJC.get();; localFrameLayout = null)
    {
      if (localFrameLayout != paramFrameLayout)
      {
        Log.i("MicroMsg.MagicEmojiPage", "hy: holder changed or create, need re-install");
        if (localFrameLayout != null) {
          detach();
        }
        this.XJC = new WeakReference(paramFrameLayout);
        lT();
      }
      AppMethodBeat.o(286730);
      return;
    }
  }
  
  final void mG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286731);
    paramInt1 = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramInt1);
    paramInt2 = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramInt2);
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      Log.e("MicroMsg.MagicEmojiPage", "hy: update width or height is 0!! Will raise up wasm crash, ignore");
      if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
      {
        localObject = new RuntimeException("update width or height is 0!! Will raise up wasm crash, ignore");
        AppMethodBeat.o(286731);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(286731);
      return;
    }
    Log.i("MicroMsg.MagicEmojiPage", "hy: update window size to %d x %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = String.format("if (window !== undefined) { window.innerWidth = %d;window.innerHeight = %d; }", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.XJB != null) {}
    for (Object localObject = this.XJB.XJI; localObject != null; localObject = null)
    {
      if (((g)localObject).getJsRuntime() != null) {
        ((g)localObject).getJsRuntime().evaluateJavascript(str, null);
      }
      AppMethodBeat.o(286731);
      return;
    }
    Log.w("MicroMsg.MagicEmojiPage", "hy: service released!");
    AppMethodBeat.o(286731);
  }
  
  public final void notifyDestroy()
  {
    AppMethodBeat.i(286728);
    Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: page destroyed from stack", new Object[0]);
    detach();
    AppMethodBeat.o(286728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.d
 * JD-Core Version:    0.7.0.1
 */