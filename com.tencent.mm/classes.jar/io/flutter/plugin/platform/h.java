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
  public b KKm;
  c KMD;
  public final f KPF;
  View KPG;
  io.flutter.embedding.engine.c.g KPH;
  final HashMap<Integer, i> KPI;
  final HashMap<Context, View> KPJ;
  private final g.d KPK;
  final a accessibilityEventsDelegate;
  Context context;
  
  public h()
  {
    AppMethodBeat.i(9923);
    this.KPK = new g.d()
    {
      private static void fNP()
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
        fNP();
        if (!h.qj(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.KPI.containsKey(Integer.valueOf(paramAnonymousa.viewId)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        Object localObject1 = h.this.KPF;
        Object localObject2 = paramAnonymousa.KNQ;
        d locald = (d)((f)localObject1).KPE.get(localObject2);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.KNQ);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        localObject1 = null;
        if (paramAnonymousa.KNT != null) {
          localObject1 = locald.KPD.I(paramAnonymousa.KNT);
        }
        int i = h.a(h.this, paramAnonymousa.KNR);
        int j = h.a(h.this, paramAnonymousa.KNS);
        h.a(h.this, i, j);
        localObject2 = h.this.KMD.fNv();
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
              paramAnonymous2View = h.this.KPH;
              int i = paramAnonymousa.viewId;
              if (paramAnonymous2View.uzK != null) {
                paramAnonymous2View.uzK.a("viewFocused", Integer.valueOf(i), null);
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
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.KNQ + " with id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.KPG != null) {
          ((i)localObject1).fNQ();
        }
        h.this.KPI.put(Integer.valueOf(paramAnonymousa.viewId), localObject1);
        localObject1 = ((i)localObject1).getView();
        ((View)localObject1).setLayoutDirection(paramAnonymousa.direction);
        h.this.KPJ.put(((View)localObject1).getContext(), localObject1);
        long l = ((c.a)localObject2).fNy();
        AppMethodBeat.o(9898);
        return l;
      }
      
      public final void a(g.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        fNP();
        final i locali = (i)h.this.KPI.get(Integer.valueOf(paramAnonymousb.viewId));
        if (locali == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.viewId);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = h.a(h.this, paramAnonymousb.KNU);
        int j = h.a(h.this, paramAnonymousb.KNV);
        h.a(h.this, i, j);
        paramAnonymousb = h.this;
        if (paramAnonymousb.KKm != null)
        {
          paramAnonymousb = paramAnonymousb.KKm;
          if (paramAnonymousb.KPl.KPs == b.a.a.KPv) {
            paramAnonymousb.KPq = true;
          }
          if ((locali.KPY != null) && (locali.KPY.getView() != null)) {
            break label339;
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
              if (localh.KKm != null)
              {
                localh.KKm.KPq = false;
                if ((locali.KPY != null) && (locali.KPY.getView() != null)) {
                  break label67;
                }
              }
              for (;;)
              {
                paramAnonymousRunnable.run();
                AppMethodBeat.o(9931);
                return;
                label67:
                locali.KPY.getView();
              }
            }
          };
          boolean bool = locali.getView().isFocused();
          paramAnonymousRunnable = locali.KPY.detachState();
          locali.KPX.setSurface(null);
          locali.KPX.release();
          locali.smR.surfaceTexture().setDefaultBufferSize(i, j);
          locali.KPX = ((DisplayManager)locali.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, locali.densityDpi, locali.surface, 0);
          View localView = locali.getView();
          localView.addOnAttachStateChangeListener(new i.1(locali, localView, paramAnonymousb));
          locali.KPY = new SingleViewPresentation(locali.context, locali.KPX.getDisplay(), locali.accessibilityEventsDelegate, paramAnonymousRunnable, locali.focusChangeListener, bool);
          locali.KPY.show();
          AppMethodBeat.o(9900);
          return;
          label339:
          locali.KPY.getView();
        }
      }
      
      public final void a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        fNP();
        float f = h.this.context.getResources().getDisplayMetrics().density;
        Object localObject2 = (List)paramAnonymousc.KNY;
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
        localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramAnonymousc.jcl]);
        localObject2 = (MotionEvent.PointerCoords[])h.a(paramAnonymousc.KNZ, f).toArray(new MotionEvent.PointerCoords[paramAnonymousc.jcl]);
        if (!h.this.KPI.containsKey(Integer.valueOf(paramAnonymousc.viewId)))
        {
          paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: " + paramAnonymousc.viewId);
          AppMethodBeat.o(9901);
          throw paramAnonymousc;
        }
        ((i)h.this.KPI.get(Integer.valueOf(paramAnonymousc.viewId))).getView().dispatchTouchEvent(MotionEvent.obtain(paramAnonymousc.KNW.longValue(), paramAnonymousc.KNX.longValue(), paramAnonymousc.action, paramAnonymousc.jcl, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramAnonymousc.KNd, paramAnonymousc.KOa, paramAnonymousc.KOb, paramAnonymousc.KOc, paramAnonymousc.KMY, paramAnonymousc.edgeFlags, paramAnonymousc.dbL, paramAnonymousc.flags));
        AppMethodBeat.o(9901);
      }
      
      public final void agA(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        ((i)h.this.KPI.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      public final void agz(int paramAnonymousInt)
      {
        AppMethodBeat.i(9899);
        fNP();
        Object localObject = (i)h.this.KPI.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(9899);
          throw ((Throwable)localObject);
        }
        if (h.this.KKm != null)
        {
          b localb = h.this.KKm;
          if ((localb.KPl.KPs == b.a.a.KPv) && (localb.KPl.id == paramAnonymousInt))
          {
            localb.KPl = new b.a(b.a.a.KPt, 0);
            localb.hc(localb.mView);
            localb.KPk.restartInput(localb.mView);
            localb.KPn = false;
          }
        }
        h.this.KPJ.remove(((i)localObject).getView().getContext());
        ((i)localObject).dispose();
        h.this.KPI.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(9899);
      }
      
      @TargetApi(17)
      public final void kU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        fNP();
        if (!h.qj(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        Object localObject = ((i)h.this.KPI.get(Integer.valueOf(paramAnonymousInt1))).getView();
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
    this.KPF = new f();
    this.KPI = new HashMap();
    this.accessibilityEventsDelegate = new a();
    this.KPJ = new HashMap();
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
    this.KMD = paramc;
    this.KPH = new io.flutter.embedding.engine.c.g(paramDartExecutor);
    this.KPH.KNM = this.KPK;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.accessibilityEventsDelegate.KKY = parama;
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (!this.KPJ.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.KPJ.get(paramView.getContext());
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
    this.KPH.KNM = null;
    this.KPH = null;
    this.context = null;
    this.KMD = null;
  }
  
  public final void fNM()
  {
    this.accessibilityEventsDelegate.KKY = null;
  }
  
  public final void fNN()
  {
    AppMethodBeat.i(192776);
    this.KPG = null;
    Iterator localIterator = this.KPI.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.KPY != null) && (locali.KPY.getView() != null)) {
        locali.KPY.getView();
      }
    }
    AppMethodBeat.o(192776);
  }
  
  public final void fNO()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.KPI.values().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).dispose();
    }
    this.KPI.clear();
    AppMethodBeat.o(9927);
  }
  
  public final void hd(View paramView)
  {
    AppMethodBeat.i(192775);
    this.KPG = paramView;
    paramView = this.KPI.values().iterator();
    while (paramView.hasNext()) {
      ((i)paramView.next()).fNQ();
    }
    AppMethodBeat.o(192775);
  }
  
  public final View o(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    paramInteger = (i)this.KPI.get(paramInteger);
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