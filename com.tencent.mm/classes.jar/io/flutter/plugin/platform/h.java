package io.flutter.plugin.platform;

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
import io.flutter.embedding.engine.c.g.a;
import io.flutter.embedding.engine.c.g.b;
import io.flutter.embedding.engine.c.g.c;
import io.flutter.embedding.engine.c.g.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import io.flutter.plugin.b.b;
import io.flutter.plugin.b.b.a;
import io.flutter.plugin.b.b.a.a;
import io.flutter.view.c;
import io.flutter.view.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
  implements g
{
  public b MBa;
  c MDA;
  public final f MGE;
  View MGF;
  io.flutter.embedding.engine.c.g MGG;
  final HashMap<Integer, i> MGH;
  final HashMap<Context, View> MGI;
  private final g.d MGJ;
  final a accessibilityEventsDelegate;
  Context context;
  
  public h()
  {
    AppMethodBeat.i(9923);
    this.MGJ = new g.d()
    {
      private static void gfo()
      {
        AppMethodBeat.i(9904);
        if (Build.VERSION.SDK_INT < 20)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: 20");
          AppMethodBeat.o(9904);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(9904);
      }
      
      @TargetApi(17)
      public final long a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(9898);
        gfo();
        if (!h.qK(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.MGH.containsKey(Integer.valueOf(paramAnonymousa.viewId)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        Object localObject1 = h.this.MGE;
        Object localObject2 = paramAnonymousa.MEN;
        d locald = (d)((f)localObject1).MGD.get(localObject2);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.MEN);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        localObject1 = null;
        if (paramAnonymousa.MEQ != null) {
          localObject1 = locald.MGC.J(paramAnonymousa.MEQ);
        }
        int i = h.a(h.this, paramAnonymousa.MEO);
        int j = h.a(h.this, paramAnonymousa.MEP);
        h.a(h.this, i, j);
        localObject2 = h.this.MDA.geU();
        Context localContext = h.this.context;
        a locala = h.this.accessibilityEventsDelegate;
        int k = paramAnonymousa.viewId;
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(9886);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = h.this.MGG;
              int i = paramAnonymousa.viewId;
              if (paramAnonymous2View.vCn != null) {
                paramAnonymous2View.vCn.a("viewFocused", Integer.valueOf(i), null);
              }
            }
            AppMethodBeat.o(9886);
          }
        };
        ((c.a)localObject2).surfaceTexture().setDefaultBufferSize(i, j);
        Surface localSurface = new Surface(((c.a)localObject2).surfaceTexture());
        VirtualDisplay localVirtualDisplay = ((DisplayManager)localContext.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, localContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
        if (localVirtualDisplay == null) {}
        for (localObject1 = null; localObject1 == null; localObject1 = new i(localContext, locala, localVirtualDisplay, locald, localSurface, (c.a)localObject2, local1, k, localObject1))
        {
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.MEN + " with id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.MGF != null) {
          ((i)localObject1).gfp();
        }
        h.this.MGH.put(Integer.valueOf(paramAnonymousa.viewId), localObject1);
        localObject1 = ((i)localObject1).getView();
        ((View)localObject1).setLayoutDirection(paramAnonymousa.direction);
        h.this.MGI.put(((View)localObject1).getContext(), localObject1);
        long l = ((c.a)localObject2).geX();
        AppMethodBeat.o(9898);
        return l;
      }
      
      public final void a(g.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        gfo();
        final i locali = (i)h.this.MGH.get(Integer.valueOf(paramAnonymousb.viewId));
        if (locali == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.viewId);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = h.a(h.this, paramAnonymousb.MER);
        int j = h.a(h.this, paramAnonymousb.MES);
        h.a(h.this, i, j);
        paramAnonymousb = h.this;
        if (paramAnonymousb.MBa != null)
        {
          paramAnonymousb = paramAnonymousb.MBa;
          if (paramAnonymousb.MGk.MGr == b.a.a.MGu) {
            paramAnonymousb.MGp = true;
          }
          if ((locali.MGX != null) && (locali.MGX.getView() != null)) {
            break label345;
          }
        }
        for (;;)
        {
          paramAnonymousb = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9931);
              h localh = h.this;
              i locali = locali;
              if (localh.MBa != null)
              {
                localh.MBa.MGp = false;
                if ((locali.MGX != null) && (locali.MGX.getView() != null)) {
                  break label67;
                }
              }
              for (;;)
              {
                paramAnonymousRunnable.run();
                AppMethodBeat.o(9931);
                return;
                label67:
                locali.MGX.getView();
              }
            }
          };
          boolean bool = locali.getView().isFocused();
          paramAnonymousRunnable = locali.MGX.detachState();
          locali.MGW.setSurface(null);
          locali.MGW.release();
          locali.tjv.surfaceTexture().setDefaultBufferSize(i, j);
          locali.MGW = ((DisplayManager)locali.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, locali.densityDpi, locali.surface, 0);
          View localView = locali.getView();
          localView.addOnAttachStateChangeListener(new i.1(locali, localView, paramAnonymousb));
          paramAnonymousb = new SingleViewPresentation(locali.context, locali.MGW.getDisplay(), locali.accessibilityEventsDelegate, paramAnonymousRunnable, locali.focusChangeListener, bool);
          paramAnonymousb.show();
          locali.MGX.cancel();
          locali.MGX = paramAnonymousb;
          AppMethodBeat.o(9900);
          return;
          label345:
          locali.MGX.getView();
        }
      }
      
      public final void a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        gfo();
        float f = h.this.context.getResources().getDisplayMetrics().density;
        Object localObject2 = (List)paramAnonymousc.MEV;
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
        localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramAnonymousc.jvu]);
        localObject2 = (MotionEvent.PointerCoords[])h.a(paramAnonymousc.MEW, f).toArray(new MotionEvent.PointerCoords[paramAnonymousc.jvu]);
        if (!h.this.MGH.containsKey(Integer.valueOf(paramAnonymousc.viewId)))
        {
          paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: " + paramAnonymousc.viewId);
          AppMethodBeat.o(9901);
          throw paramAnonymousc;
        }
        ((i)h.this.MGH.get(Integer.valueOf(paramAnonymousc.viewId))).getView().dispatchTouchEvent(MotionEvent.obtain(paramAnonymousc.MET.longValue(), paramAnonymousc.MEU.longValue(), paramAnonymousc.action, paramAnonymousc.jvu, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramAnonymousc.MEa, paramAnonymousc.MEX, paramAnonymousc.MEY, paramAnonymousc.MEZ, paramAnonymousc.MDV, paramAnonymousc.edgeFlags, paramAnonymousc.dnh, paramAnonymousc.flags));
        AppMethodBeat.o(9901);
      }
      
      public final void aja(int paramAnonymousInt)
      {
        AppMethodBeat.i(9899);
        gfo();
        Object localObject = (i)h.this.MGH.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(9899);
          throw ((Throwable)localObject);
        }
        if (h.this.MBa != null)
        {
          b localb = h.this.MBa;
          if ((localb.MGk.MGr == b.a.a.MGu) && (localb.MGk.id == paramAnonymousInt))
          {
            localb.MGk = new b.a(b.a.a.MGs, 0);
            localb.ht(localb.mView);
            localb.MGi.restartInput(localb.mView);
            localb.MGm = false;
          }
        }
        h.this.MGI.remove(((i)localObject).getView().getContext());
        ((i)localObject).dispose();
        h.this.MGH.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(9899);
      }
      
      public final void ajb(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        ((i)h.this.MGH.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      @TargetApi(17)
      public final void lj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        gfo();
        if (!h.qK(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        Object localObject = ((i)h.this.MGH.get(Integer.valueOf(paramAnonymousInt1))).getView();
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
    this.MGE = new f();
    this.MGH = new HashMap();
    this.accessibilityEventsDelegate = new a();
    this.MGI = new HashMap();
    AppMethodBeat.o(9923);
  }
  
  public final void a(Context paramContext, c paramc, DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(9924);
    if (this.context != null)
    {
      paramContext = new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
      AppMethodBeat.o(9924);
      throw paramContext;
    }
    this.context = paramContext;
    this.MDA = paramc;
    this.MGG = new io.flutter.embedding.engine.c.g(paramDartExecutor);
    this.MGG.MEJ = this.MGJ;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.accessibilityEventsDelegate.MBQ = parama;
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (!this.MGI.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.MGI.get(paramView.getContext());
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
    this.MGG.MEJ = null;
    this.MGG = null;
    this.context = null;
    this.MDA = null;
  }
  
  public final void gfl()
  {
    this.accessibilityEventsDelegate.MBQ = null;
  }
  
  public final void gfm()
  {
    AppMethodBeat.i(213220);
    this.MGF = null;
    Iterator localIterator = this.MGH.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.MGX != null) && (locali.MGX.getView() != null)) {
        locali.MGX.getView();
      }
    }
    AppMethodBeat.o(213220);
  }
  
  public final void gfn()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.MGH.values().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).dispose();
    }
    this.MGH.clear();
    AppMethodBeat.o(9927);
  }
  
  public final void hu(View paramView)
  {
    AppMethodBeat.i(213219);
    this.MGF = paramView;
    paramView = this.MGH.values().iterator();
    while (paramView.hasNext()) {
      ((i)paramView.next()).gfp();
    }
    AppMethodBeat.o(213219);
  }
  
  public final View p(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    paramInteger = (i)this.MGH.get(paramInteger);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.h
 * JD-Core Version:    0.7.0.1
 */