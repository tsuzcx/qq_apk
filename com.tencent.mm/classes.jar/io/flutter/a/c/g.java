package io.flutter.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.Surface;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.k;
import io.flutter.a.b.b;
import io.flutter.a.b.b.a;
import io.flutter.a.b.b.a.a;
import io.flutter.embedding.engine.c.g.a;
import io.flutter.embedding.engine.c.g.b;
import io.flutter.embedding.engine.c.g.c;
import io.flutter.embedding.engine.c.g.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g
  implements f
{
  public b IXb;
  final e Jca;
  io.flutter.view.f Jcb;
  io.flutter.embedding.engine.c.g Jcc;
  final a Jcd;
  final HashMap<Integer, i> Jce;
  final HashMap<Context, View> Jcf;
  private final g.d Jcg;
  Context context;
  
  public g()
  {
    AppMethodBeat.i(9923);
    this.Jcg = new g.d()
    {
      private static void fvi()
      {
        AppMethodBeat.i(9904);
        if (Build.VERSION.SDK_INT < 20)
        {
          new StringBuilder("Trying to use platform views with API ").append(Build.VERSION.SDK_INT).append(", required API level is: 20");
          IllegalStateException localIllegalStateException = new IllegalStateException("An attempt was made to use platform views on a version of Android that platform views does not support.");
          AppMethodBeat.o(9904);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(9904);
      }
      
      @TargetApi(17)
      public final long a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(9898);
        fvi();
        if (!g.pv(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.dpo + ")");
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (g.this.Jce.containsKey(Integer.valueOf(paramAnonymousa.dpo)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.dpo);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        Object localObject1 = g.this.Jca;
        Object localObject2 = paramAnonymousa.Jan;
        d locald = (d)((e)localObject1).JbZ.get(localObject2);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.Jan);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        localObject1 = null;
        if (paramAnonymousa.Jaq != null) {
          localObject1 = locald.JbY.I(paramAnonymousa.Jaq);
        }
        int i = g.a(g.this, paramAnonymousa.Jao);
        int j = g.a(g.this, paramAnonymousa.Jap);
        g.a(g.this, i, j);
        localObject2 = g.this.Jcb.fuS();
        Context localContext = g.this.context;
        a locala = g.this.Jcd;
        int k = paramAnonymousa.dpo;
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(9886);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = g.this.Jcc;
              int i = paramAnonymousa.dpo;
              if (paramAnonymous2View.sNT != null) {
                paramAnonymous2View.sNT.a("viewFocused", Integer.valueOf(i), null);
              }
            }
            AppMethodBeat.o(9886);
          }
        };
        ((f.a)localObject2).surfaceTexture().setDefaultBufferSize(i, j);
        Surface localSurface = new Surface(((f.a)localObject2).surfaceTexture());
        VirtualDisplay localVirtualDisplay = ((DisplayManager)localContext.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, localContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
        if (localVirtualDisplay == null) {}
        for (localObject1 = null; localObject1 == null; localObject1 = new i(localContext, locala, localVirtualDisplay, locald, localSurface, (f.a)localObject2, local1, k, localObject1))
        {
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.Jan + " with id: " + paramAnonymousa.dpo);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        g.this.Jce.put(Integer.valueOf(paramAnonymousa.dpo), localObject1);
        localObject1 = ((i)localObject1).getView();
        ((View)localObject1).setLayoutDirection(paramAnonymousa.direction);
        g.this.Jcf.put(((View)localObject1).getContext(), localObject1);
        long l = ((f.a)localObject2).fuU();
        AppMethodBeat.o(9898);
        return l;
      }
      
      public final void a(g.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        fvi();
        final i locali = (i)g.this.Jce.get(Integer.valueOf(paramAnonymousb.dpo));
        if (locali == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.dpo);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = g.a(g.this, paramAnonymousb.Jar);
        int j = g.a(g.this, paramAnonymousb.Jas);
        g.a(g.this, i, j);
        paramAnonymousb = g.this;
        if (paramAnonymousb.IXb != null)
        {
          paramAnonymousb = paramAnonymousb.IXb;
          if (paramAnonymousb.JbH.JbN == b.a.a.JbQ) {
            paramAnonymousb.JbL = true;
          }
        }
        paramAnonymousb = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9931);
            g localg = g.this;
            if (localg.IXb != null) {
              localg.IXb.JbL = false;
            }
            paramAnonymousRunnable.run();
            AppMethodBeat.o(9931);
          }
        };
        boolean bool = locali.getView().isFocused();
        paramAnonymousRunnable = locali.JcA.fvj();
        locali.Jcz.setSurface(null);
        locali.Jcz.release();
        locali.rdW.surfaceTexture().setDefaultBufferSize(i, j);
        locali.Jcz = ((DisplayManager)locali.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, locali.densityDpi, locali.surface, 0);
        View localView = locali.getView();
        localView.addOnAttachStateChangeListener(new i.1(locali, localView, paramAnonymousb));
        locali.JcA = new h(locali.context, locali.Jcz.getDisplay(), locali.Jcd, paramAnonymousRunnable, locali.Jcn, bool);
        locali.JcA.show();
        AppMethodBeat.o(9900);
      }
      
      public final void a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        fvi();
        float f = g.this.context.getResources().getDisplayMetrics().density;
        Object localObject2 = (List)paramAnonymousc.Jav;
        Object localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          List localList = (List)((Iterator)localObject2).next();
          MotionEvent.PointerProperties localPointerProperties = new MotionEvent.PointerProperties();
          localPointerProperties.id = ((Integer)localList.get(0)).intValue();
          localPointerProperties.toolType = ((Integer)localList.get(1)).intValue();
          ((List)localObject1).add(localPointerProperties);
        }
        localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramAnonymousc.iCk]);
        localObject2 = (MotionEvent.PointerCoords[])g.a(paramAnonymousc.Jaw, f).toArray(new MotionEvent.PointerCoords[paramAnonymousc.iCk]);
        if (!g.this.Jce.containsKey(Integer.valueOf(paramAnonymousc.dpo)))
        {
          paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: " + paramAnonymousc.dpo);
          AppMethodBeat.o(9901);
          throw paramAnonymousc;
        }
        ((i)g.this.Jce.get(Integer.valueOf(paramAnonymousc.dpo))).getView().dispatchTouchEvent(MotionEvent.obtain(paramAnonymousc.Jat.longValue(), paramAnonymousc.Jau.longValue(), paramAnonymousc.action, paramAnonymousc.iCk, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramAnonymousc.IZA, paramAnonymousc.Jax, paramAnonymousc.Jay, paramAnonymousc.Jaz, paramAnonymousc.IZv, paramAnonymousc.edgeFlags, paramAnonymousc.dep, paramAnonymousc.flags));
        AppMethodBeat.o(9901);
      }
      
      public final void adE(int paramAnonymousInt)
      {
        AppMethodBeat.i(9899);
        fvi();
        Object localObject = (i)g.this.Jce.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(9899);
          throw ((Throwable)localObject);
        }
        if (g.this.IXb != null)
        {
          b localb = g.this.IXb;
          if ((localb.JbH.JbN == b.a.a.JbQ) && (localb.JbH.id == paramAnonymousInt))
          {
            localb.JbH = new b.a(b.a.a.JbO, 0);
            localb.gK(localb.mView);
            localb.JbG.restartInput(localb.mView);
            localb.JbJ = false;
          }
        }
        g.this.Jcf.remove(((i)localObject).getView().getContext());
        ((i)localObject).dispose();
        g.this.Jce.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(9899);
      }
      
      public final void adF(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        ((i)g.this.Jce.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      @TargetApi(17)
      public final void kE(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        fvi();
        if (!g.pv(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        Object localObject = ((i)g.this.Jce.get(Integer.valueOf(paramAnonymousInt1))).getView();
        if (localObject == null)
        {
          localObject = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        ((View)localObject).setLayoutDirection(paramAnonymousInt2);
        AppMethodBeat.o(9902);
      }
    };
    this.Jca = new e();
    this.Jce = new HashMap();
    this.Jcd = new a();
    this.Jcf = new HashMap();
    AppMethodBeat.o(9923);
  }
  
  public final void a(Context paramContext, io.flutter.view.f paramf, DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(9924);
    if (this.context != null)
    {
      paramContext = new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
      AppMethodBeat.o(9924);
      throw paramContext;
    }
    this.context = paramContext;
    this.Jcb = paramf;
    this.Jcc = new io.flutter.embedding.engine.c.g(paramDartExecutor);
    this.Jcc.Jaj = this.Jcg;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.Jcd.IXS = parama;
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (!this.Jcf.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.Jcf.get(paramView.getContext());
    if (localView == paramView)
    {
      AppMethodBeat.o(9925);
      return true;
    }
    boolean bool = localView.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9925);
    return bool;
  }
  
  public final void detach()
  {
    this.Jcc.Jaj = null;
    this.Jcc = null;
    this.context = null;
    this.Jcb = null;
  }
  
  public final void fvg()
  {
    this.Jcd.IXS = null;
  }
  
  public final void fvh()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.Jce.values().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).dispose();
    }
    this.Jce.clear();
    AppMethodBeat.o(9927);
  }
  
  public final View n(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    paramInteger = (i)this.Jce.get(paramInteger);
    if (paramInteger == null)
    {
      AppMethodBeat.o(9926);
      return null;
    }
    paramInteger = paramInteger.getView();
    AppMethodBeat.o(9926);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.c.g
 * JD-Core Version:    0.7.0.1
 */