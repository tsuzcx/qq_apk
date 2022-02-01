package com.tencent.mm.ui.j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  public static final b.a KYO;
  private static String TAG;
  private final int KYG;
  private boolean KYH;
  private boolean KYI;
  private boolean KYJ;
  public int KYK;
  d.g.a.a<Boolean> KYL;
  public boolean KYM;
  private final HashSet<a> KYN;
  private float cNQ;
  private float cNR;
  public final Runnable gpk;
  private final int rW;
  
  static
  {
    AppMethodBeat.i(140944);
    KYO = new b.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.KYM = true;
    this.gpk = ((Runnable)new b(this));
    this.KYN = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.KYG = (ViewConfiguration.getLongPressTimeout() + 100);
    p.g(paramContext, "config");
    this.rW = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    p.h(parama, "consumer");
    this.KYN.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void ae(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(140941);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140941);
      return;
      this.cNQ = paramMotionEvent.getX();
      this.cNR = paramMotionEvent.getY();
      this.KYH = false;
      this.KYI = false;
      this.KYJ = false;
      this.KYK = 0;
      ar.o(this.gpk, this.KYG);
      ae.d(TAG, "downX:" + this.cNQ + "  downY:" + this.cNR);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.cNQ;
      float f4 = f2 - this.cNR;
      if (!this.KYI)
      {
        if ((Math.abs(f1 - this.cNQ) > this.rW) || (Math.abs(f2 - this.cNR) > this.rW)) {
          bool = true;
        }
        this.KYI = bool;
      }
      if (this.KYI)
      {
        ar.ay(this.gpk);
        if (this.KYK == 0)
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
        this.KYK = i;
        ae.d(TAG, "scrollType " + this.KYK + " move: " + f3 + ", " + f4);
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
      ar.ay(this.gpk);
      this.KYK = 0;
      this.KYJ = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    p.h(paramMotionEvent, "event");
    ae.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.KYK;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.KYH) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.KYN.iterator();
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
            if ((this.KYI) && ((locala.epL() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.KYI, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.KYJ) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.KYK;
      ae.d(TAG, "scrollType " + this.KYK);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      ae.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.KYP.KYM)
      {
        d.g.a.a locala = this.KYP.KYL;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.KYP);
        }
      }
      AppMethodBeat.o(140939);
      return;
      label64:
      AppMethodBeat.o(140939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.j.b
 * JD-Core Version:    0.7.0.1
 */