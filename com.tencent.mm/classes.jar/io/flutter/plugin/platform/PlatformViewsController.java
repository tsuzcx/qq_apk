package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.Surface;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.b;
import io.flutter.embedding.android.h.a;
import io.flutter.embedding.engine.b.i.a;
import io.flutter.embedding.engine.b.i.b;
import io.flutter.embedding.engine.b.i.c;
import io.flutter.embedding.engine.b.i.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import io.flutter.plugin.editing.d.a;
import io.flutter.plugin.editing.d.a.a;
import io.flutter.view.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PlatformViewsController
  implements g
{
  public io.flutter.plugin.editing.d aaoo;
  private final io.flutter.embedding.android.h aaot;
  public b aapp;
  private io.flutter.view.c aarP;
  public final f aavW;
  public View aavX;
  private io.flutter.embedding.engine.b.i aavY;
  final HashMap<Integer, h> aavZ;
  private final HashMap<Context, View> aawa;
  public final SparseArray<c> aawb;
  public final SparseArray<io.flutter.embedding.engine.mutatorsstack.a> aawc;
  public final SparseArray<FlutterImageView> aawd;
  public int aawe;
  public boolean aawf;
  public HashSet<Integer> aawg;
  public HashSet<Integer> aawh;
  private final i.d aawi;
  private final a accessibilityEventsDelegate;
  public Context context;
  
  public PlatformViewsController()
  {
    AppMethodBeat.i(9923);
    this.aawe = 0;
    this.aawf = false;
    this.aawi = new i.d()
    {
      private static void aDx(int paramAnonymousInt)
      {
        AppMethodBeat.i(254890);
        if (Build.VERSION.SDK_INT < paramAnonymousInt)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + paramAnonymousInt);
          AppMethodBeat.o(254890);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(254890);
      }
      
      public final void a(i.a paramAnonymousa)
      {
        AppMethodBeat.i(254879);
        aDx(19);
        if (!PlatformViewsController.xH(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(254879);
          throw paramAnonymousa;
        }
        Object localObject = PlatformViewsController.a(PlatformViewsController.this).bGv(paramAnonymousa.aatl);
        if (localObject == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.aatl);
          AppMethodBeat.o(254879);
          throw paramAnonymousa;
        }
        if (paramAnonymousa.aato != null) {
          ((d)localObject).aavU.F(paramAnonymousa.aato);
        }
        PlatformViewsController.b(PlatformViewsController.this);
        localObject = ((d)localObject).iBt();
        PlatformViewsController.c(PlatformViewsController.this).put(paramAnonymousa.viewId, localObject);
        AppMethodBeat.o(254879);
      }
      
      public final void a(i.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        aDx(20);
        final h localh = (h)PlatformViewsController.this.aavZ.get(Integer.valueOf(paramAnonymousb.viewId));
        if (localh == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.viewId);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousb.aatp);
        int j = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousb.aatq);
        PlatformViewsController.a(PlatformViewsController.this, i, j);
        PlatformViewsController.a(PlatformViewsController.this, localh);
        paramAnonymousb = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9931);
            PlatformViewsController.b(PlatformViewsController.this, localh);
            paramAnonymousRunnable.run();
            AppMethodBeat.o(9931);
          }
        };
        boolean bool = localh.getView().isFocused();
        paramAnonymousRunnable = localh.aawx.detachState();
        localh.aaww.setSurface(null);
        localh.aaww.release();
        localh.jSi.surfaceTexture().setDefaultBufferSize(i, j);
        localh.aaww = ((DisplayManager)localh.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, localh.aawv, localh.surface, 0);
        View localView = localh.getView();
        localView.addOnAttachStateChangeListener(new h.1(localh, localView, paramAnonymousb));
        paramAnonymousb = new SingleViewPresentation(localh.context, localh.aaww.getDisplay(), localh.accessibilityEventsDelegate, paramAnonymousRunnable, localh.focusChangeListener, bool);
        paramAnonymousb.show();
        localh.aawx.cancel();
        localh.aawx = paramAnonymousb;
        AppMethodBeat.o(9900);
      }
      
      public final void a(i.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        int i = paramAnonymousc.viewId;
        float f = PlatformViewsController.b(PlatformViewsController.this).getResources().getDisplayMetrics().density;
        aDx(20);
        MotionEvent localMotionEvent;
        if (PlatformViewsController.this.aavZ.containsKey(Integer.valueOf(i)))
        {
          localMotionEvent = PlatformViewsController.this.a(f, paramAnonymousc, true);
          paramAnonymousc = (h)PlatformViewsController.this.aavZ.get(Integer.valueOf(paramAnonymousc.viewId));
          if (paramAnonymousc.aawx != null) {
            paramAnonymousc.aawx.dispatchTouchEvent(localMotionEvent);
          }
          AppMethodBeat.o(9901);
          return;
        }
        if (PlatformViewsController.c(PlatformViewsController.this).get(i) != null)
        {
          localMotionEvent = PlatformViewsController.this.a(f, paramAnonymousc, false);
          paramAnonymousc = ((c)PlatformViewsController.c(PlatformViewsController.this).get(paramAnonymousc.viewId)).getView();
          if (paramAnonymousc != null) {
            paramAnonymousc.dispatchTouchEvent(localMotionEvent);
          }
          AppMethodBeat.o(9901);
          return;
        }
        paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(9901);
        throw paramAnonymousc;
      }
      
      public final void aDo(int paramAnonymousInt)
      {
        AppMethodBeat.i(254881);
        c localc = (c)PlatformViewsController.c(PlatformViewsController.this).get(paramAnonymousInt);
        io.flutter.embedding.engine.mutatorsstack.a locala = (io.flutter.embedding.engine.mutatorsstack.a)PlatformViewsController.d(PlatformViewsController.this).get(paramAnonymousInt);
        if (localc != null)
        {
          if (locala != null) {
            locala.removeView(localc.getView());
          }
          PlatformViewsController.c(PlatformViewsController.this).remove(paramAnonymousInt);
        }
        if (locala != null)
        {
          ((ViewGroup)locala.getParent()).removeView(locala);
          PlatformViewsController.d(PlatformViewsController.this).remove(paramAnonymousInt);
        }
        AppMethodBeat.o(254881);
      }
      
      public final void aDp(int paramAnonymousInt)
      {
        AppMethodBeat.i(254885);
        aDx(20);
        Object localObject = (h)PlatformViewsController.this.aavZ.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(254885);
          throw ((Throwable)localObject);
        }
        if (PlatformViewsController.j(PlatformViewsController.this) != null)
        {
          io.flutter.plugin.editing.d locald = PlatformViewsController.j(PlatformViewsController.this);
          if ((locald.aavr.aavF == d.a.a.aavI) && (locald.aavr.id == paramAnonymousInt))
          {
            locald.aavr = new d.a(d.a.a.aavG, 0);
            locald.jl(locald.mView);
            locald.aavc.restartInput(locald.mView);
            locald.aavu = false;
          }
        }
        PlatformViewsController.i(PlatformViewsController.this).remove(((h)localObject).getView().getContext());
        ((h)localObject).dispose();
        PlatformViewsController.this.aavZ.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(254885);
      }
      
      public final void aDq(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        aDx(20);
        ((h)PlatformViewsController.this.aavZ.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      @TargetApi(17)
      public final long b(final i.a paramAnonymousa)
      {
        AppMethodBeat.i(254883);
        aDx(20);
        if (!PlatformViewsController.xH(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(254883);
          throw paramAnonymousa;
        }
        if (PlatformViewsController.this.aavZ.containsKey(Integer.valueOf(paramAnonymousa.viewId)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(254883);
          throw paramAnonymousa;
        }
        d locald = PlatformViewsController.a(PlatformViewsController.this).bGv(paramAnonymousa.aatl);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.aatl);
          AppMethodBeat.o(254883);
          throw paramAnonymousa;
        }
        Object localObject = null;
        if (paramAnonymousa.aato != null) {
          localObject = locald.aavU.F(paramAnonymousa.aato);
        }
        int i = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousa.aatm);
        int j = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousa.aatn);
        PlatformViewsController.a(PlatformViewsController.this, i, j);
        c.a locala = PlatformViewsController.e(PlatformViewsController.this).iBa();
        Context localContext = PlatformViewsController.b(PlatformViewsController.this);
        a locala1 = PlatformViewsController.f(PlatformViewsController.this);
        int k = paramAnonymousa.viewId;
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(9886);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = PlatformViewsController.g(PlatformViewsController.this);
              int i = paramAnonymousa.viewId;
              if (paramAnonymous2View.aKT != null) {
                paramAnonymous2View.aKT.a("viewFocused", Integer.valueOf(i), null);
              }
            }
            AppMethodBeat.o(9886);
          }
        };
        locala.surfaceTexture().setDefaultBufferSize(i, j);
        Surface localSurface = new Surface(locala.surfaceTexture());
        VirtualDisplay localVirtualDisplay = ((DisplayManager)localContext.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, localContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
        if (localVirtualDisplay == null) {}
        for (localObject = null; localObject == null; localObject = new h(localContext, locala1, localVirtualDisplay, locald, localSurface, locala, local1, k, localObject))
        {
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.aatl + " with id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(254883);
          throw paramAnonymousa;
        }
        if (PlatformViewsController.h(PlatformViewsController.this) != null)
        {
          PlatformViewsController.h(PlatformViewsController.this);
          ((h)localObject).iBy();
        }
        PlatformViewsController.this.aavZ.put(Integer.valueOf(paramAnonymousa.viewId), localObject);
        localObject = ((h)localObject).getView();
        ((View)localObject).setLayoutDirection(paramAnonymousa.direction);
        PlatformViewsController.i(PlatformViewsController.this).put(((View)localObject).getContext(), localObject);
        long l = locala.dux();
        AppMethodBeat.o(254883);
        return l;
      }
      
      @TargetApi(17)
      public final void om(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        if (!PlatformViewsController.xH(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        aDx(20);
        Object localObject = ((h)PlatformViewsController.this.aavZ.get(Integer.valueOf(paramAnonymousInt1))).getView();
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
    this.aavW = new f();
    this.aavZ = new HashMap();
    this.accessibilityEventsDelegate = new a();
    this.aawa = new HashMap();
    this.aawd = new SparseArray();
    this.aawg = new HashSet();
    this.aawh = new HashSet();
    this.aawb = new SparseArray();
    this.aawc = new SparseArray();
    this.aaot = io.flutter.embedding.android.h.iAH();
    AppMethodBeat.o(9923);
  }
  
  private static List<MotionEvent.PointerCoords> b(Object paramObject, float paramFloat)
  {
    AppMethodBeat.i(253870);
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      List localList = (List)((Iterator)localObject).next();
      MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
      localPointerCoords.orientation = ((float)((Double)localList.get(0)).doubleValue());
      localPointerCoords.pressure = ((float)((Double)localList.get(1)).doubleValue());
      localPointerCoords.size = ((float)((Double)localList.get(2)).doubleValue());
      localPointerCoords.toolMajor = ((float)((Double)localList.get(3)).doubleValue() * paramFloat);
      localPointerCoords.toolMinor = ((float)((Double)localList.get(4)).doubleValue() * paramFloat);
      localPointerCoords.touchMajor = ((float)((Double)localList.get(5)).doubleValue() * paramFloat);
      localPointerCoords.touchMinor = ((float)((Double)localList.get(6)).doubleValue() * paramFloat);
      localPointerCoords.x = ((float)((Double)localList.get(7)).doubleValue() * paramFloat);
      localPointerCoords.y = ((float)((Double)localList.get(8)).doubleValue() * paramFloat);
      paramObject.add(localPointerCoords);
    }
    AppMethodBeat.o(253870);
    return paramObject;
  }
  
  public final boolean A(Integer paramInteger)
  {
    AppMethodBeat.i(253867);
    boolean bool = this.aavZ.containsKey(paramInteger);
    AppMethodBeat.o(253867);
    return bool;
  }
  
  public final void Jf(boolean paramBoolean)
  {
    AppMethodBeat.i(253878);
    int i = 0;
    int j;
    Object localObject;
    if (i < this.aawd.size())
    {
      j = this.aawd.keyAt(i);
      localObject = (FlutterImageView)this.aawd.valueAt(i);
      if (this.aawg.contains(Integer.valueOf(j)))
      {
        FlutterView localFlutterView = (FlutterView)this.aavX;
        if (localFlutterView.BCx != null) {
          ((FlutterImageView)localObject).a(localFlutterView.BCx.aaos);
        }
        paramBoolean &= ((FlutterImageView)localObject).iAA();
      }
      for (;;)
      {
        i += 1;
        break;
        if (!this.aawf) {
          ((FlutterImageView)localObject).iAz();
        }
        ((FlutterImageView)localObject).setVisibility(8);
      }
    }
    i = 0;
    if (i < this.aawc.size())
    {
      j = this.aawc.keyAt(i);
      localObject = (View)this.aawc.get(j);
      if ((paramBoolean) && (this.aawh.contains(Integer.valueOf(j)))) {
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(253878);
  }
  
  public final MotionEvent a(float paramFloat, i.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(253855);
    Object localObject1 = h.a.Xq(paramc.aatB);
    Object localObject2 = this.aaot;
    while ((!((io.flutter.embedding.android.h)localObject2).aapJ.isEmpty()) && (((Long)((io.flutter.embedding.android.h)localObject2).aapJ.peek()).longValue() < h.a.a((h.a)localObject1))) {
      ((io.flutter.embedding.android.h)localObject2).aapI.remove(((Long)((io.flutter.embedding.android.h)localObject2).aapJ.poll()).longValue());
    }
    if ((!((io.flutter.embedding.android.h)localObject2).aapJ.isEmpty()) && (((Long)((io.flutter.embedding.android.h)localObject2).aapJ.peek()).longValue() == h.a.a((h.a)localObject1))) {
      ((io.flutter.embedding.android.h)localObject2).aapJ.poll();
    }
    MotionEvent localMotionEvent = (MotionEvent)((io.flutter.embedding.android.h)localObject2).aapI.get(h.a.a((h.a)localObject1));
    ((io.flutter.embedding.android.h)localObject2).aapI.remove(h.a.a((h.a)localObject1));
    localObject2 = (List)paramc.aatt;
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      List localList = (List)((Iterator)localObject2).next();
      MotionEvent.PointerProperties localPointerProperties = new MotionEvent.PointerProperties();
      localPointerProperties.id = ((Integer)localList.get(0)).intValue();
      localPointerProperties.toolType = ((Integer)localList.get(1)).intValue();
      ((List)localObject1).add(localPointerProperties);
    }
    localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramc.nrY]);
    localObject2 = (MotionEvent.PointerCoords[])b(paramc.aatu, paramFloat).toArray(new MotionEvent.PointerCoords[paramc.nrY]);
    if ((!paramBoolean) && (localMotionEvent != null))
    {
      paramc = MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime(), localMotionEvent.getAction(), paramc.nrY, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, localMotionEvent.getMetaState(), localMotionEvent.getButtonState(), localMotionEvent.getXPrecision(), localMotionEvent.getYPrecision(), localMotionEvent.getDeviceId(), localMotionEvent.getEdgeFlags(), localMotionEvent.getSource(), localMotionEvent.getFlags());
      AppMethodBeat.o(253855);
      return paramc;
    }
    paramc = MotionEvent.obtain(paramc.aatr.longValue(), paramc.aats.longValue(), paramc.action, paramc.nrY, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramc.aatv, paramc.aatw, paramc.aatx, paramc.aaty, paramc.aatz, paramc.aatA, paramc.source, paramc.flags);
    AppMethodBeat.o(253855);
    return paramc;
  }
  
  public final void a(Context paramContext, io.flutter.view.c paramc, DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(9924);
    if (this.context != null)
    {
      paramContext = new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
      AppMethodBeat.o(9924);
      throw paramContext;
    }
    this.context = paramContext;
    this.aarP = paramc;
    this.aavY = new io.flutter.embedding.engine.b.i(paramDartExecutor);
    this.aavY.aatg = this.aawi;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.accessibilityEventsDelegate.aapq = parama;
  }
  
  public final void c(io.flutter.embedding.engine.renderer.a parama)
  {
    AppMethodBeat.i(253876);
    this.aapp = new b(parama, true);
    AppMethodBeat.o(253876);
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (paramView == null)
    {
      AppMethodBeat.o(9925);
      return false;
    }
    if (!this.aawa.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.aawa.get(paramView.getContext());
    if (localView == paramView)
    {
      AppMethodBeat.o(9925);
      return true;
    }
    boolean bool = localView.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9925);
    return bool;
  }
  
  public final void destroyOverlaySurfaces()
  {
    AppMethodBeat.i(253880);
    int i = 0;
    while (i < this.aawd.size())
    {
      this.aawd.keyAt(i);
      FlutterImageView localFlutterImageView = (FlutterImageView)this.aawd.valueAt(i);
      localFlutterImageView.iAz();
      ((FlutterView)this.aavX).removeView(localFlutterImageView);
      i += 1;
    }
    this.aawd.clear();
    AppMethodBeat.o(253880);
  }
  
  public final void detach()
  {
    if (this.aavY != null) {
      this.aavY.aatg = null;
    }
    this.aavY = null;
    this.context = null;
    this.aarP = null;
  }
  
  public final void iBu()
  {
    this.accessibilityEventsDelegate.aapq = null;
  }
  
  public final void iBv()
  {
    AppMethodBeat.i(253862);
    this.aavX = null;
    Iterator localIterator = this.aavZ.values().iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((localh.aawx != null) && (localh.aawx.getView() != null)) {
        localh.aawx.getView();
      }
    }
    AppMethodBeat.o(253862);
  }
  
  public final void iBw()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.aavZ.values().iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).dispose();
    }
    this.aavZ.clear();
    while (this.aawb.size() > 0) {
      this.aawi.aDo(this.aawb.keyAt(0));
    }
    AppMethodBeat.o(9927);
  }
  
  public final void iBx()
  {
    AppMethodBeat.i(253873);
    if (!this.aawf)
    {
      ((FlutterView)this.aavX).iAD();
      this.aawf = true;
    }
    AppMethodBeat.o(253873);
  }
  
  public final void jm(View paramView)
  {
    AppMethodBeat.i(253860);
    this.aavX = paramView;
    paramView = this.aavZ.values().iterator();
    while (paramView.hasNext()) {
      ((h)paramView.next()).iBy();
    }
    AppMethodBeat.o(253860);
  }
  
  public void onAttachedToJNI() {}
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(253865);
    iBw();
    AppMethodBeat.o(253865);
  }
  
  public final View z(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    if (this.aawb.get(paramInteger.intValue()) != null)
    {
      paramInteger = ((c)this.aawb.get(paramInteger.intValue())).getView();
      AppMethodBeat.o(9926);
      return paramInteger;
    }
    paramInteger = (h)this.aavZ.get(paramInteger);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController
 * JD-Core Version:    0.7.0.1
 */