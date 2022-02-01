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
  public b MYf;
  c NaF;
  public final f NdJ;
  View NdK;
  io.flutter.embedding.engine.c.g NdL;
  final HashMap<Integer, i> NdM;
  final HashMap<Context, View> NdN;
  private final g.d NdO;
  final a accessibilityEventsDelegate;
  Context context;
  
  public h()
  {
    AppMethodBeat.i(9923);
    this.NdO = new g.d()
    {
      private static void gjQ()
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
        gjQ();
        if (!h.qN(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.NdM.containsKey(Integer.valueOf(paramAnonymousa.viewId)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        Object localObject1 = h.this.NdJ;
        Object localObject2 = paramAnonymousa.NbT;
        d locald = (d)((f)localObject1).NdI.get(localObject2);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.NbT);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        localObject1 = null;
        if (paramAnonymousa.NbW != null) {
          localObject1 = locald.NdH.J(paramAnonymousa.NbW);
        }
        int i = h.a(h.this, paramAnonymousa.NbU);
        int j = h.a(h.this, paramAnonymousa.NbV);
        h.a(h.this, i, j);
        localObject2 = h.this.NaF.gjw();
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
              paramAnonymous2View = h.this.NdL;
              int i = paramAnonymousa.viewId;
              if (paramAnonymous2View.vOr != null) {
                paramAnonymous2View.vOr.a("viewFocused", Integer.valueOf(i), null);
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
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.NbT + " with id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(9898);
          throw paramAnonymousa;
        }
        if (h.this.NdK != null) {
          ((i)localObject1).gjR();
        }
        h.this.NdM.put(Integer.valueOf(paramAnonymousa.viewId), localObject1);
        localObject1 = ((i)localObject1).getView();
        ((View)localObject1).setLayoutDirection(paramAnonymousa.direction);
        h.this.NdN.put(((View)localObject1).getContext(), localObject1);
        long l = ((c.a)localObject2).gjz();
        AppMethodBeat.o(9898);
        return l;
      }
      
      public final void a(g.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        gjQ();
        final i locali = (i)h.this.NdM.get(Integer.valueOf(paramAnonymousb.viewId));
        if (locali == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.viewId);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = h.a(h.this, paramAnonymousb.NbX);
        int j = h.a(h.this, paramAnonymousb.NbY);
        h.a(h.this, i, j);
        paramAnonymousb = h.this;
        if (paramAnonymousb.MYf != null)
        {
          paramAnonymousb = paramAnonymousb.MYf;
          if (paramAnonymousb.Ndp.Ndw == b.a.a.Ndz) {
            paramAnonymousb.Ndu = true;
          }
          if ((locali.Neb != null) && (locali.Neb.getView() != null)) {
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
              if (localh.MYf != null)
              {
                localh.MYf.Ndu = false;
                if ((locali.Neb != null) && (locali.Neb.getView() != null)) {
                  break label67;
                }
              }
              for (;;)
              {
                paramAnonymousRunnable.run();
                AppMethodBeat.o(9931);
                return;
                label67:
                locali.Neb.getView();
              }
            }
          };
          boolean bool = locali.getView().isFocused();
          paramAnonymousRunnable = locali.Neb.detachState();
          locali.Nea.setSurface(null);
          locali.Nea.release();
          locali.tun.surfaceTexture().setDefaultBufferSize(i, j);
          locali.Nea = ((DisplayManager)locali.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, locali.densityDpi, locali.surface, 0);
          View localView = locali.getView();
          localView.addOnAttachStateChangeListener(new i.1(locali, localView, paramAnonymousb));
          paramAnonymousb = new SingleViewPresentation(locali.context, locali.Nea.getDisplay(), locali.accessibilityEventsDelegate, paramAnonymousRunnable, locali.focusChangeListener, bool);
          paramAnonymousb.show();
          locali.Neb.cancel();
          locali.Neb = paramAnonymousb;
          AppMethodBeat.o(9900);
          return;
          label345:
          locali.Neb.getView();
        }
      }
      
      public final void a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        gjQ();
        float f = h.this.context.getResources().getDisplayMetrics().density;
        Object localObject2 = (List)paramAnonymousc.Ncb;
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
        localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramAnonymousc.jyp]);
        localObject2 = (MotionEvent.PointerCoords[])h.a(paramAnonymousc.Ncc, f).toArray(new MotionEvent.PointerCoords[paramAnonymousc.jyp]);
        if (!h.this.NdM.containsKey(Integer.valueOf(paramAnonymousc.viewId)))
        {
          paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: " + paramAnonymousc.viewId);
          AppMethodBeat.o(9901);
          throw paramAnonymousc;
        }
        ((i)h.this.NdM.get(Integer.valueOf(paramAnonymousc.viewId))).getView().dispatchTouchEvent(MotionEvent.obtain(paramAnonymousc.NbZ.longValue(), paramAnonymousc.Nca.longValue(), paramAnonymousc.action, paramAnonymousc.jyp, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramAnonymousc.Nbg, paramAnonymousc.Ncd, paramAnonymousc.Nce, paramAnonymousc.Ncf, paramAnonymousc.Nbb, paramAnonymousc.edgeFlags, paramAnonymousc.doj, paramAnonymousc.flags));
        AppMethodBeat.o(9901);
      }
      
      public final void ajK(int paramAnonymousInt)
      {
        AppMethodBeat.i(9899);
        gjQ();
        Object localObject = (i)h.this.NdM.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(9899);
          throw ((Throwable)localObject);
        }
        if (h.this.MYf != null)
        {
          b localb = h.this.MYf;
          if ((localb.Ndp.Ndw == b.a.a.Ndz) && (localb.Ndp.id == paramAnonymousInt))
          {
            localb.Ndp = new b.a(b.a.a.Ndx, 0);
            localb.hy(localb.mView);
            localb.Ndn.restartInput(localb.mView);
            localb.Ndr = false;
          }
        }
        h.this.NdN.remove(((i)localObject).getView().getContext());
        ((i)localObject).dispose();
        h.this.NdM.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(9899);
      }
      
      public final void ajL(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        ((i)h.this.NdM.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      @TargetApi(17)
      public final void lq(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        gjQ();
        if (!h.qN(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        Object localObject = ((i)h.this.NdM.get(Integer.valueOf(paramAnonymousInt1))).getView();
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
    this.NdJ = new f();
    this.NdM = new HashMap();
    this.accessibilityEventsDelegate = new a();
    this.NdN = new HashMap();
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
    this.NaF = paramc;
    this.NdL = new io.flutter.embedding.engine.c.g(paramDartExecutor);
    this.NdL.NbP = this.NdO;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.accessibilityEventsDelegate.MYV = parama;
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (!this.NdN.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.NdN.get(paramView.getContext());
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
    this.NdL.NbP = null;
    this.NdL = null;
    this.context = null;
    this.NaF = null;
  }
  
  public final void gjN()
  {
    this.accessibilityEventsDelegate.MYV = null;
  }
  
  public final void gjO()
  {
    AppMethodBeat.i(197802);
    this.NdK = null;
    Iterator localIterator = this.NdM.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.Neb != null) && (locali.Neb.getView() != null)) {
        locali.Neb.getView();
      }
    }
    AppMethodBeat.o(197802);
  }
  
  public final void gjP()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.NdM.values().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).dispose();
    }
    this.NdM.clear();
    AppMethodBeat.o(9927);
  }
  
  public final void hz(View paramView)
  {
    AppMethodBeat.i(197801);
    this.NdK = paramView;
    paramView = this.NdM.values().iterator();
    while (paramView.hasNext()) {
      ((i)paramView.next()).gjR();
    }
    AppMethodBeat.o(197801);
  }
  
  public final View q(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    paramInteger = (i)this.NdM.get(paramInteger);
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
 * Qualified Name:     io.flutter.plugin.platform.h
 * JD-Core Version:    0.7.0.1
 */