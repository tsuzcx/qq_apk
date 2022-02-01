package com.tencent.mm.ui.j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  public static final a HkU;
  private static String TAG;
  private final int HkM;
  private boolean HkN;
  private boolean HkO;
  private boolean HkP;
  public int HkQ;
  d.g.a.a<Boolean> HkR;
  public boolean HkS;
  private final HashSet<a> HkT;
  private float cEZ;
  private float cFa;
  public final Runnable fPp;
  private final int pd;
  
  static
  {
    AppMethodBeat.i(140944);
    HkU = new a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.HkS = true;
    this.fPp = ((Runnable)new b(this));
    this.HkT = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.HkM = (ViewConfiguration.getLongPressTimeout() + 100);
    k.g(paramContext, "config");
    this.pd = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    k.h(parama, "consumer");
    this.HkT.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void ae(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(140941);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140941);
      return;
      this.cEZ = paramMotionEvent.getX();
      this.cFa = paramMotionEvent.getY();
      this.HkN = false;
      this.HkO = false;
      this.HkP = false;
      this.HkQ = 0;
      aq.n(this.fPp, this.HkM);
      ad.d(TAG, "downX:" + this.cEZ + "  downY:" + this.cFa);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.cEZ;
      float f4 = f2 - this.cFa;
      if (!this.HkO)
      {
        if ((Math.abs(f1 - this.cEZ) > this.pd) || (Math.abs(f2 - this.cFa) > this.pd)) {
          bool = true;
        }
        this.HkO = bool;
      }
      if (this.HkO)
      {
        aq.az(this.fPp);
        if (this.HkQ == 0)
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
        this.HkQ = i;
        ad.d(TAG, "scrollType " + this.HkQ + " move: " + f3 + ", " + f4);
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
      aq.az(this.fPp);
      this.HkQ = 0;
      this.HkP = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    k.h(paramMotionEvent, "event");
    ad.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.HkQ;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.HkN) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.HkT.iterator();
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
            if ((this.HkO) && ((locala.dLn() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.HkO, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.HkP) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.HkQ;
      ad.d(TAG, "scrollType " + this.HkQ);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper$Companion;", "", "()V", "ScrollAll", "", "ScrollDown", "ScrollLeft", "ScrollNone", "ScrollRight", "ScrollUp", "TAG", "", "scrollHorizontal", "", "type", "scrollVertical", "libmmui_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      ad.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.HkV.HkS)
      {
        d.g.a.a locala = this.HkV.HkR;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.HkV);
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
 * Qualified Name:     com.tencent.mm.ui.j.b
 * JD-Core Version:    0.7.0.1
 */