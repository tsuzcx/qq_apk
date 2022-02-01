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
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.b;
import io.flutter.embedding.engine.c.h.b;
import io.flutter.embedding.engine.c.h.c;
import io.flutter.embedding.engine.c.h.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.i;
import io.flutter.plugin.a.k;
import io.flutter.plugin.b.c.a.a;
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
  public io.flutter.plugin.b.c SMp;
  private final io.flutter.embedding.android.h SMs;
  public b SNr;
  public final f STj;
  public View STk;
  private io.flutter.embedding.engine.c.h STl;
  final HashMap<Integer, h> STm;
  private final HashMap<Context, View> STn;
  public final SparseArray<io.flutter.embedding.engine.c.h.a> STo;
  public final SparseArray<View> STp;
  public final SparseArray<io.flutter.embedding.engine.mutatorsstack.a> STq;
  public final SparseArray<io.flutter.embedding.android.g> STr;
  public int STs;
  public boolean STt;
  public HashSet<Integer> STu;
  public HashSet<Integer> STv;
  private final h.d STw;
  private io.flutter.view.c StA;
  private final a accessibilityEventsDelegate;
  public Context context;
  
  public PlatformViewsController()
  {
    AppMethodBeat.i(9923);
    this.STs = 0;
    this.STt = false;
    this.STw = new h.d()
    {
      private static void atD(int paramAnonymousInt)
      {
        AppMethodBeat.i(214864);
        if (Build.VERSION.SDK_INT < paramAnonymousInt)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + paramAnonymousInt);
          AppMethodBeat.o(214864);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(214864);
      }
      
      public final void a(io.flutter.embedding.engine.c.h.a paramAnonymousa)
      {
        AppMethodBeat.i(214860);
        atD(19);
        PlatformViewsController.a(PlatformViewsController.this).put(paramAnonymousa.viewId, paramAnonymousa);
        AppMethodBeat.o(214860);
      }
      
      public final void a(h.b paramAnonymousb, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(9900);
        atD(20);
        final h localh = (h)PlatformViewsController.this.STm.get(Integer.valueOf(paramAnonymousb.viewId));
        if (localh == null)
        {
          paramAnonymousb = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousb.viewId);
          AppMethodBeat.o(9900);
          throw paramAnonymousb;
        }
        int i = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousb.SQT);
        int j = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousb.SQU);
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
        paramAnonymousRunnable = localh.STK.detachState();
        localh.STJ.setSurface(null);
        localh.STJ.release();
        localh.hgp.surfaceTexture().setDefaultBufferSize(i, j);
        localh.STJ = ((DisplayManager)localh.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, localh.densityDpi, localh.surface, 0);
        View localView = localh.getView();
        localView.addOnAttachStateChangeListener(new h.1(localh, localView, paramAnonymousb));
        paramAnonymousb = new SingleViewPresentation(localh.context, localh.STJ.getDisplay(), localh.accessibilityEventsDelegate, paramAnonymousRunnable, localh.focusChangeListener, bool);
        paramAnonymousb.show();
        localh.STK.cancel();
        localh.STK = paramAnonymousb;
        AppMethodBeat.o(9900);
      }
      
      public final void a(h.c paramAnonymousc)
      {
        AppMethodBeat.i(9901);
        int i = paramAnonymousc.viewId;
        float f = PlatformViewsController.g(PlatformViewsController.this).getResources().getDisplayMetrics().density;
        atD(20);
        MotionEvent localMotionEvent;
        if (PlatformViewsController.this.STm.containsKey(Integer.valueOf(i)))
        {
          localMotionEvent = PlatformViewsController.this.a(f, paramAnonymousc, true);
          paramAnonymousc = (h)PlatformViewsController.this.STm.get(Integer.valueOf(paramAnonymousc.viewId));
          if (paramAnonymousc.STK != null) {
            paramAnonymousc.STK.dispatchTouchEvent(localMotionEvent);
          }
          AppMethodBeat.o(9901);
          return;
        }
        if (PlatformViewsController.b(PlatformViewsController.this).get(i) != null)
        {
          localMotionEvent = PlatformViewsController.this.a(f, paramAnonymousc, false);
          ((View)PlatformViewsController.b(PlatformViewsController.this).get(paramAnonymousc.viewId)).dispatchTouchEvent(localMotionEvent);
          AppMethodBeat.o(9901);
          return;
        }
        paramAnonymousc = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(9901);
        throw paramAnonymousc;
      }
      
      public final void att(int paramAnonymousInt)
      {
        AppMethodBeat.i(214861);
        if (PlatformViewsController.a(PlatformViewsController.this).get(paramAnonymousInt) != null) {
          PlatformViewsController.a(PlatformViewsController.this).remove(paramAnonymousInt);
        }
        View localView = (View)PlatformViewsController.b(PlatformViewsController.this).get(paramAnonymousInt);
        if (localView != null)
        {
          io.flutter.embedding.engine.mutatorsstack.a locala = (io.flutter.embedding.engine.mutatorsstack.a)PlatformViewsController.c(PlatformViewsController.this).get(paramAnonymousInt);
          locala.removeView(localView);
          ((FlutterView)PlatformViewsController.d(PlatformViewsController.this)).removeView(locala);
          PlatformViewsController.b(PlatformViewsController.this).remove(paramAnonymousInt);
          PlatformViewsController.c(PlatformViewsController.this).remove(paramAnonymousInt);
        }
        AppMethodBeat.o(214861);
      }
      
      public final void atu(int paramAnonymousInt)
      {
        AppMethodBeat.i(214863);
        atD(20);
        Object localObject = (h)PlatformViewsController.this.STm.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(214863);
          throw ((Throwable)localObject);
        }
        if (PlatformViewsController.k(PlatformViewsController.this) != null)
        {
          io.flutter.plugin.b.c localc = PlatformViewsController.k(PlatformViewsController.this);
          if ((localc.SSH.SST == c.a.a.SSW) && (localc.SSH.id == paramAnonymousInt))
          {
            localc.SSH = new io.flutter.plugin.b.c.a(c.a.a.SSU, 0);
            localc.hR(localc.mView);
            localc.SSy.restartInput(localc.mView);
            localc.SSK = false;
          }
        }
        PlatformViewsController.j(PlatformViewsController.this).remove(((h)localObject).getView().getContext());
        ((h)localObject).dispose();
        PlatformViewsController.this.STm.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(214863);
      }
      
      public final void atv(int paramAnonymousInt)
      {
        AppMethodBeat.i(9903);
        atD(20);
        ((h)PlatformViewsController.this.STm.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(9903);
      }
      
      @TargetApi(17)
      public final long b(final io.flutter.embedding.engine.c.h.a paramAnonymousa)
      {
        AppMethodBeat.i(214862);
        atD(20);
        if (!PlatformViewsController.atC(paramAnonymousa.direction))
        {
          paramAnonymousa = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousa.direction + "(view id: " + paramAnonymousa.viewId + ")");
          AppMethodBeat.o(214862);
          throw paramAnonymousa;
        }
        if (PlatformViewsController.this.STm.containsKey(Integer.valueOf(paramAnonymousa.viewId)))
        {
          paramAnonymousa = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(214862);
          throw paramAnonymousa;
        }
        d locald = PlatformViewsController.e(PlatformViewsController.this).bts(paramAnonymousa.SQP);
        if (locald == null)
        {
          paramAnonymousa = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousa.SQP);
          AppMethodBeat.o(214862);
          throw paramAnonymousa;
        }
        Object localObject = null;
        if (paramAnonymousa.SQS != null) {
          localObject = locald.STh.J(paramAnonymousa.SQS);
        }
        int i = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousa.SQQ);
        int j = PlatformViewsController.a(PlatformViewsController.this, paramAnonymousa.SQR);
        PlatformViewsController.a(PlatformViewsController.this, i, j);
        io.flutter.view.c.a locala = PlatformViewsController.f(PlatformViewsController.this).hwY();
        Context localContext = PlatformViewsController.g(PlatformViewsController.this);
        a locala1 = PlatformViewsController.h(PlatformViewsController.this);
        int k = paramAnonymousa.viewId;
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(9886);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = PlatformViewsController.i(PlatformViewsController.this);
              int i = paramAnonymousa.viewId;
              if (paramAnonymous2View.bbv != null) {
                paramAnonymous2View.bbv.a("viewFocused", Integer.valueOf(i), null);
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
          paramAnonymousa = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousa.SQP + " with id: " + paramAnonymousa.viewId);
          AppMethodBeat.o(214862);
          throw paramAnonymousa;
        }
        if (PlatformViewsController.d(PlatformViewsController.this) != null)
        {
          PlatformViewsController.d(PlatformViewsController.this);
          ((h)localObject).hxu();
        }
        PlatformViewsController.this.STm.put(Integer.valueOf(paramAnonymousa.viewId), localObject);
        localObject = ((h)localObject).getView();
        ((View)localObject).setLayoutDirection(paramAnonymousa.direction);
        PlatformViewsController.j(PlatformViewsController.this).put(((View)localObject).getContext(), localObject);
        long l = locala.hxb();
        AppMethodBeat.o(214862);
        return l;
      }
      
      @TargetApi(17)
      public final void mT(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(9902);
        if (!PlatformViewsController.atC(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(9902);
          throw ((Throwable)localObject);
        }
        atD(20);
        Object localObject = ((h)PlatformViewsController.this.STm.get(Integer.valueOf(paramAnonymousInt1))).getView();
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
    this.STj = new f();
    this.STm = new HashMap();
    this.accessibilityEventsDelegate = new a();
    this.STn = new HashMap();
    this.STr = new SparseArray();
    this.STu = new HashSet();
    this.STv = new HashSet();
    this.STo = new SparseArray();
    this.STp = new SparseArray();
    this.STq = new SparseArray();
    this.SMs = io.flutter.embedding.android.h.hwD();
    AppMethodBeat.o(9923);
  }
  
  private static List<MotionEvent.PointerCoords> a(Object paramObject, float paramFloat)
  {
    AppMethodBeat.i(214872);
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
    AppMethodBeat.o(214872);
    return paramObject;
  }
  
  public static boolean atB(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  public final void EA(boolean paramBoolean)
  {
    AppMethodBeat.i(214875);
    int i = 0;
    int j;
    Object localObject1;
    Object localObject2;
    if (i < this.STr.size())
    {
      j = this.STr.keyAt(i);
      localObject1 = (io.flutter.embedding.android.g)this.STr.valueAt(i);
      if (this.STu.contains(Integer.valueOf(j)))
      {
        localObject2 = (FlutterView)this.STk;
        if (((FlutterView)localObject2).wJi != null) {
          ((io.flutter.embedding.android.g)localObject1).a(((FlutterView)localObject2).wJi.SMr);
        }
        paramBoolean &= ((io.flutter.embedding.android.g)localObject1).hwv();
      }
      for (;;)
      {
        i += 1;
        break;
        if (!this.STt) {
          ((io.flutter.embedding.android.g)localObject1).hwu();
        }
        ((io.flutter.embedding.android.g)localObject1).setVisibility(8);
      }
    }
    i = 0;
    if (i < this.STp.size())
    {
      j = this.STp.keyAt(i);
      localObject1 = (View)this.STp.get(j);
      localObject2 = (View)this.STq.get(j);
      if ((paramBoolean) && (this.STv.contains(Integer.valueOf(j))))
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject1).setVisibility(8);
        ((View)localObject2).setVisibility(8);
      }
    }
    AppMethodBeat.o(214875);
  }
  
  public final MotionEvent a(float paramFloat, h.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(214868);
    Object localObject1 = io.flutter.embedding.android.h.a.Pa(paramc.SRc);
    Object localObject2 = this.SMs;
    while ((!((io.flutter.embedding.android.h)localObject2).SNL.isEmpty()) && (((Long)((io.flutter.embedding.android.h)localObject2).SNL.peek()).longValue() < io.flutter.embedding.android.h.a.a((io.flutter.embedding.android.h.a)localObject1))) {
      ((io.flutter.embedding.android.h)localObject2).SNK.remove(((Long)((io.flutter.embedding.android.h)localObject2).SNL.poll()).longValue());
    }
    if ((!((io.flutter.embedding.android.h)localObject2).SNL.isEmpty()) && (((Long)((io.flutter.embedding.android.h)localObject2).SNL.peek()).longValue() == io.flutter.embedding.android.h.a.a((io.flutter.embedding.android.h.a)localObject1))) {
      ((io.flutter.embedding.android.h)localObject2).SNL.poll();
    }
    MotionEvent localMotionEvent = (MotionEvent)((io.flutter.embedding.android.h)localObject2).SNK.get(io.flutter.embedding.android.h.a.a((io.flutter.embedding.android.h.a)localObject1));
    ((io.flutter.embedding.android.h)localObject2).SNK.remove(io.flutter.embedding.android.h.a.a((io.flutter.embedding.android.h.a)localObject1));
    localObject2 = (List)paramc.SQX;
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
    localObject1 = (MotionEvent.PointerProperties[])((List)localObject1).toArray(new MotionEvent.PointerProperties[paramc.kyY]);
    localObject2 = (MotionEvent.PointerCoords[])a(paramc.SQY, paramFloat).toArray(new MotionEvent.PointerCoords[paramc.kyY]);
    if ((!paramBoolean) && (localMotionEvent != null))
    {
      paramc = MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime(), localMotionEvent.getAction(), paramc.kyY, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, localMotionEvent.getMetaState(), localMotionEvent.getButtonState(), localMotionEvent.getXPrecision(), localMotionEvent.getYPrecision(), localMotionEvent.getDeviceId(), localMotionEvent.getEdgeFlags(), localMotionEvent.getSource(), localMotionEvent.getFlags());
      AppMethodBeat.o(214868);
      return paramc;
    }
    paramc = MotionEvent.obtain(paramc.SQV.longValue(), paramc.SQW.longValue(), paramc.action, paramc.kyY, (MotionEvent.PointerProperties[])localObject1, (MotionEvent.PointerCoords[])localObject2, paramc.SPZ, paramc.SQZ, paramc.SRa, paramc.SRb, paramc.SPU, paramc.edgeFlags, paramc.source, paramc.flags);
    AppMethodBeat.o(214868);
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
    this.StA = paramc;
    this.STl = new io.flutter.embedding.engine.c.h(paramDartExecutor);
    this.STl.SQK = this.STw;
    AppMethodBeat.o(9924);
  }
  
  public final void a(io.flutter.view.a parama)
  {
    this.accessibilityEventsDelegate.SNs = parama;
  }
  
  public final void b(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(214874);
    this.SNr = new b(parama, true);
    AppMethodBeat.o(214874);
  }
  
  public final boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9925);
    if (!this.STn.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(9925);
      return false;
    }
    View localView = (View)this.STn.get(paramView.getContext());
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
    AppMethodBeat.i(214876);
    int i = 0;
    while (i < this.STr.size())
    {
      this.STr.keyAt(i);
      io.flutter.embedding.android.g localg = (io.flutter.embedding.android.g)this.STr.valueAt(i);
      localg.hwu();
      ((FlutterView)this.STk).removeView(localg);
      i += 1;
    }
    this.STr.clear();
    AppMethodBeat.o(214876);
  }
  
  public final void detach()
  {
    this.STl.SQK = null;
    this.STl = null;
    this.context = null;
    this.StA = null;
  }
  
  public final void hS(View paramView)
  {
    AppMethodBeat.i(214869);
    this.STk = paramView;
    paramView = this.STm.values().iterator();
    while (paramView.hasNext()) {
      ((h)paramView.next()).hxu();
    }
    AppMethodBeat.o(214869);
  }
  
  public final void hxq()
  {
    this.accessibilityEventsDelegate.SNs = null;
  }
  
  public final void hxr()
  {
    AppMethodBeat.i(214870);
    this.STk = null;
    Iterator localIterator = this.STm.values().iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((localh.STK != null) && (localh.STK.getView() != null)) {
        localh.STK.getView();
      }
    }
    AppMethodBeat.o(214870);
  }
  
  public final void hxs()
  {
    AppMethodBeat.i(9927);
    Iterator localIterator = this.STm.values().iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).dispose();
    }
    this.STm.clear();
    AppMethodBeat.o(9927);
  }
  
  public final void hxt()
  {
    AppMethodBeat.i(214873);
    if (!this.STt)
    {
      ((FlutterView)this.STk).hwz();
      this.STt = true;
    }
    AppMethodBeat.o(214873);
  }
  
  public void onAttachedToJNI() {}
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(214871);
    hxs();
    AppMethodBeat.o(214871);
  }
  
  public final View r(Integer paramInteger)
  {
    AppMethodBeat.i(9926);
    if (this.STp.get(paramInteger.intValue()) != null)
    {
      paramInteger = (View)this.STp.get(paramInteger.intValue());
      AppMethodBeat.o(9926);
      return paramInteger;
    }
    paramInteger = (h)this.STm.get(paramInteger);
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