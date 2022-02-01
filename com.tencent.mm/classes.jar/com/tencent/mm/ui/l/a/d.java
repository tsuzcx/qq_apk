package com.tencent.mm.ui.l.a;

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
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class d
  implements a
{
  final e QlN;
  private WeakReference<FrameLayout> QlO;
  public MagicBrushView QlP;
  private int QlQ;
  boolean QlR;
  private final MagicBrushView.c QlS;
  private WeakReference<Context> Uva;
  private boolean mIsRunning;
  
  public d(Context paramContext, e parame)
  {
    AppMethodBeat.i(234369);
    this.mIsRunning = false;
    this.QlQ = -1;
    this.QlR = false;
    this.Uva = null;
    this.QlS = new MagicBrushView.c()
    {
      public final void a(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234367);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceAvailable: %d, %s, %d, %d, %b", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(paramAnonymousBoolean) });
        d.this.lp(paramAnonymousInt1, paramAnonymousInt2);
        d.this.QlR = true;
        if ((d.this.QlN != null) && (d.this.QlN.QlU != null))
        {
          paramAnonymousObject = d.this.QlN.QlU;
          Log.i("MicroMsg.MagicEmojiService", "hy: surface ready, flush pending msgs with size: %d", new Object[] { Integer.valueOf(paramAnonymousObject.QlJ.size()) });
          Iterator localIterator = paramAnonymousObject.QlJ.iterator();
          while (localIterator.hasNext()) {
            paramAnonymousObject.b((c)localIterator.next());
          }
          paramAnonymousObject.QlJ.clear();
        }
        AppMethodBeat.o(234367);
      }
      
      public final void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234368);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceDestroyed: %d, %s, %b", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Boolean.valueOf(paramAnonymousBoolean) });
        d.this.QlR = false;
        AppMethodBeat.o(234368);
      }
      
      public final void c(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234366);
        Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceSizeChanged %d %s %d %d", new Object[] { Integer.valueOf(hashCode()), paramAnonymousObject.toString(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (d.this.QlN != null) {}
        for (paramAnonymousObject = d.this.QlN.QlU;; paramAnonymousObject = null)
        {
          if (paramAnonymousObject != null) {
            paramAnonymousObject.gWH();
          }
          d.this.lp(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(234366);
          return;
        }
      }
    };
    this.Uva = new WeakReference(paramContext);
    this.QlN = parame;
    AppMethodBeat.o(234369);
  }
  
  private void gWB()
  {
    AppMethodBeat.i(234374);
    Log.i("MicroMsg.MagicEmojiPage", "hy: detach magic brush, need destroy mbView: %b", new Object[] { Boolean.TRUE });
    if (this.QlO != null) {}
    for (FrameLayout localFrameLayout = (FrameLayout)this.QlO.get();; localFrameLayout = null)
    {
      if (localFrameLayout != null) {
        localFrameLayout.removeView(this.QlP);
      }
      if (this.QlP != null)
      {
        this.QlP.destroy();
        this.QlP.b(this.QlS);
        this.QlP = null;
      }
      AppMethodBeat.o(234374);
      return;
    }
  }
  
  private void lH()
  {
    AppMethodBeat.i(234371);
    Log.i("MicroMsg.MagicEmojiPage", "hy: page attaching");
    FrameLayout localFrameLayout = (FrameLayout)this.QlO.get();
    if (localFrameLayout == null)
    {
      com.tencent.mm.ui.l.b.a.bnK("holder is released!");
      Log.w("MicroMsg.MagicEmojiPage", "hy: holder is released!");
      AppMethodBeat.o(234371);
      return;
    }
    Object localObject = (Context)this.Uva.get();
    if (localObject == null)
    {
      Log.e("MicroMsg.MagicEmojiPage", "hy: no current attached context!!");
      AppMethodBeat.o(234371);
      return;
    }
    com.tencent.magicbrush.e locale;
    if (this.QlP == null)
    {
      Log.i("MicroMsg.MagicEmojiPage", "hy: creating magic brush view");
      localObject = new MagicBrushView((Context)localObject, MagicBrushView.h.cPd);
      ((MagicBrushView)localObject).setOpaque(false);
      ((MagicBrushView)localObject).setEnableTouchEvent(false);
      locale = this.QlN.QlU.Qmf.getMagicBrush();
      if (this.QlQ >= 0) {
        break label211;
      }
      ((MagicBrushView)localObject).setMagicBrush(locale);
      Log.i("MicroMsg.MagicEmojiPage", "hy: first magicbrush view: %d", new Object[] { Integer.valueOf(this.QlQ) });
      this.QlQ = ((MagicBrushView)localObject).getVirtualElementId();
    }
    for (;;)
    {
      ((MagicBrushView)localObject).a(this.QlS);
      this.QlP = ((MagicBrushView)localObject);
      if ((!this.QlP.isAttachedToWindow()) && (this.QlP.getParent() != localFrameLayout)) {
        break;
      }
      Log.i("MicroMsg.MagicEmojiPage", "hy: already attached");
      AppMethodBeat.o(234371);
      return;
      label211:
      Log.i("MicroMsg.MagicEmojiPage", "hy: already has magicbrush view: %d", new Object[] { Integer.valueOf(this.QlQ) });
      ((MagicBrushView)localObject).a(locale, this.QlQ);
    }
    Log.i("MicroMsg.MagicEmojiPage", "hy: view not attached. need re-attach");
    localObject = this.QlP.getParent();
    if ((localObject instanceof ViewGroup))
    {
      Log.i("MicroMsg.MagicEmojiPage", "hy: need remove first");
      ((ViewGroup)localObject).removeView(this.QlP);
    }
    for (;;)
    {
      this.QlP.setViewType(MagicBrushView.h.cPd);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.QlP, (ViewGroup.LayoutParams)localObject);
      Log.i("MicroMsg.MagicEmojiPage", "hy: attach done");
      AppMethodBeat.o(234371);
      return;
      if (localObject != null) {
        Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: view parent is not null and is not view group!", new Object[0]);
      }
    }
  }
  
  public final void CB(boolean paramBoolean)
  {
    AppMethodBeat.i(234372);
    if (this.mIsRunning != paramBoolean)
    {
      Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: running state change to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mIsRunning = paramBoolean;
      if (this.mIsRunning)
      {
        lH();
        AppMethodBeat.o(234372);
        return;
      }
      gWB();
      AppMethodBeat.o(234372);
      return;
    }
    Log.w("MicroMsg.MagicEmojiPage", "hy: same running state %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(234372);
  }
  
  final void aG(Context paramContext)
  {
    AppMethodBeat.i(234370);
    this.Uva = new WeakReference(paramContext);
    AppMethodBeat.o(234370);
  }
  
  final void e(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(234375);
    if (this.QlO != null) {}
    for (FrameLayout localFrameLayout = (FrameLayout)this.QlO.get();; localFrameLayout = null)
    {
      if (localFrameLayout != paramFrameLayout)
      {
        Log.i("MicroMsg.MagicEmojiPage", "hy: holder changed or create, need re-install");
        if (localFrameLayout != null) {
          gWB();
        }
        this.QlO = new WeakReference(paramFrameLayout);
        lH();
      }
      AppMethodBeat.o(234375);
      return;
    }
  }
  
  final FrameLayout gWC()
  {
    AppMethodBeat.i(234376);
    FrameLayout localFrameLayout = (FrameLayout)this.QlO.get();
    AppMethodBeat.o(234376);
    return localFrameLayout;
  }
  
  public final void gWD()
  {
    AppMethodBeat.i(234378);
    if (!this.QlR)
    {
      Log.w("MicroMsg.MagicEmojiPage", "hy: surface not prepared, but still need playing. use page view size as window width and height");
      Point localPoint = gWE();
      lp(localPoint.x, localPoint.y);
    }
    AppMethodBeat.o(234378);
  }
  
  public final Point gWE()
  {
    AppMethodBeat.i(234379);
    Object localObject = (FrameLayout)this.QlO.get();
    if (localObject == null)
    {
      Log.w("MicroMsg.MagicEmojiPage", "hy: holder released, get page size failed");
      localObject = new Point(0, 0);
      AppMethodBeat.o(234379);
      return localObject;
    }
    if ((this.QlP != null) && (this.QlP.getWidth() > 0) && (this.QlP.getHeight() > 0)) {
      this.QlP.isAttachedToWindow();
    }
    localObject = new Point(((FrameLayout)localObject).getWidth(), ((FrameLayout)localObject).getHeight());
    AppMethodBeat.o(234379);
    return localObject;
  }
  
  final void lp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234377);
    paramInt1 = com.tencent.mm.plugin.appbrand.ac.g.zB(paramInt1);
    paramInt2 = com.tencent.mm.plugin.appbrand.ac.g.zB(paramInt2);
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      Log.e("MicroMsg.MagicEmojiPage", "hy: update width or height is 0!! Will raise up wasm crash, ignore");
      if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
      {
        localObject = new RuntimeException("update width or height is 0!! Will raise up wasm crash, ignore");
        AppMethodBeat.o(234377);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(234377);
      return;
    }
    Log.i("MicroMsg.MagicEmojiPage", "hy: update window size to %d x %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = String.format("if (window !== undefined) { window.innerWidth = %d;window.innerHeight = %d; }", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.QlN != null) {}
    for (Object localObject = this.QlN.QlU; localObject != null; localObject = null)
    {
      if (((g)localObject).getJsRuntime() != null) {
        ((g)localObject).getJsRuntime().evaluateJavascript(str, null);
      }
      AppMethodBeat.o(234377);
      return;
    }
    Log.w("MicroMsg.MagicEmojiPage", "hy: service released!");
    AppMethodBeat.o(234377);
  }
  
  public final void notifyDestroy()
  {
    AppMethodBeat.i(234373);
    Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: page destroyed from stack", new Object[0]);
    gWB();
    AppMethodBeat.o(234373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.d
 * JD-Core Version:    0.7.0.1
 */