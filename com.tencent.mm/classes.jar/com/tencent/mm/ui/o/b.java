package com.tencent.mm.ui.o;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  private static String TAG;
  public static final a XLG;
  private boolean INK;
  private boolean XLA;
  private boolean XLB;
  public int XLC;
  kotlin.g.a.a<Boolean> XLD;
  public boolean XLE;
  private final HashSet<a> XLF;
  private final int XLz;
  private final int bvH;
  private float dit;
  private float diu;
  public final Runnable jLe;
  
  static
  {
    AppMethodBeat.i(140944);
    XLG = new a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.XLE = true;
    this.jLe = ((Runnable)new b(this));
    this.XLF = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.XLz = (ViewConfiguration.getLongPressTimeout() + 100);
    p.j(paramContext, "config");
    this.bvH = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    p.k(parama, "consumer");
    this.XLF.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void at(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(140941);
    p.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140941);
      return;
      this.dit = paramMotionEvent.getX();
      this.diu = paramMotionEvent.getY();
      this.XLA = false;
      this.INK = false;
      this.XLB = false;
      this.XLC = 0;
      MMHandlerThread.postToMainThreadDelayed(this.jLe, this.XLz);
      Log.d(TAG, "downX:" + this.dit + "  downY:" + this.diu);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.dit;
      float f4 = f2 - this.diu;
      if (!this.INK)
      {
        if ((Math.abs(f1 - this.dit) > this.bvH) || (Math.abs(f2 - this.diu) > this.bvH)) {
          bool = true;
        }
        this.INK = bool;
      }
      if (this.INK)
      {
        MMHandlerThread.removeRunnable(this.jLe);
        if (this.XLC == 0)
        {
          if (Math.abs(f4) <= Math.abs(f3)) {
            break label332;
          }
          if (f4 >= 0.0F) {
            break label326;
          }
        }
      }
      for (;;)
      {
        this.XLC = i;
        Log.d(TAG, "scrollType " + this.XLC + " move: " + f3 + ", " + f4);
        AppMethodBeat.o(140941);
        return;
        label326:
        i = 2;
        continue;
        label332:
        if (f3 < 0.0F) {
          i = 4;
        } else {
          i = 8;
        }
      }
      MMHandlerThread.removeRunnable(this.jLe);
      this.XLC = 0;
      this.XLB = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    p.k(paramMotionEvent, "event");
    Log.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.XLC;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.XLA) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.XLF.iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            a locala = (a)localIterator.next();
            bool2 = bool1;
            if (bool1) {
              break;
            }
            if ((this.INK) && ((locala.ggJ() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.INK, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.XLB) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.XLC;
      Log.d(TAG, "scrollType " + this.XLC);
      j = i;
      i = k;
      break;
      i = 15;
      j = 1;
      break;
      AppMethodBeat.o(140942);
      return bool2;
      label273:
      break label206;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper$Companion;", "", "()V", "ScrollAll", "", "ScrollDown", "ScrollLeft", "ScrollNone", "ScrollRight", "ScrollUp", "TAG", "", "scrollHorizontal", "", "type", "scrollVertical", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      Log.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.XLH.XLE)
      {
        kotlin.g.a.a locala = this.XLH.XLD;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.XLH);
        }
      }
      AppMethodBeat.o(140939);
      return;
      label64:
      AppMethodBeat.o(140939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.o.b
 * JD-Core Version:    0.7.0.1
 */