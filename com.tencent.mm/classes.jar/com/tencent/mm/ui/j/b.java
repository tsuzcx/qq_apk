package com.tencent.mm.ui.j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  public static final b.a KCu;
  private static String TAG;
  private final int KCm;
  private boolean KCn;
  private boolean KCo;
  private boolean KCp;
  public int KCq;
  d.g.a.a<Boolean> KCr;
  public boolean KCs;
  private final HashSet<a> KCt;
  private float cNg;
  private float cNh;
  public final Runnable gmO;
  private final int rW;
  
  static
  {
    AppMethodBeat.i(140944);
    KCu = new b.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.KCs = true;
    this.gmO = ((Runnable)new b(this));
    this.KCt = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.KCm = (ViewConfiguration.getLongPressTimeout() + 100);
    p.g(paramContext, "config");
    this.rW = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    p.h(parama, "consumer");
    this.KCt.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void ag(MotionEvent paramMotionEvent)
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
      this.cNg = paramMotionEvent.getX();
      this.cNh = paramMotionEvent.getY();
      this.KCn = false;
      this.KCo = false;
      this.KCp = false;
      this.KCq = 0;
      aq.o(this.gmO, this.KCm);
      ad.d(TAG, "downX:" + this.cNg + "  downY:" + this.cNh);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.cNg;
      float f4 = f2 - this.cNh;
      if (!this.KCo)
      {
        if ((Math.abs(f1 - this.cNg) > this.rW) || (Math.abs(f2 - this.cNh) > this.rW)) {
          bool = true;
        }
        this.KCo = bool;
      }
      if (this.KCo)
      {
        aq.aA(this.gmO);
        if (this.KCq == 0)
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
        this.KCq = i;
        ad.d(TAG, "scrollType " + this.KCq + " move: " + f3 + ", " + f4);
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
      aq.aA(this.gmO);
      this.KCq = 0;
      this.KCp = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    p.h(paramMotionEvent, "event");
    ad.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.KCq;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.KCn) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.KCt.iterator();
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
            if ((this.KCo) && ((locala.emc() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.KCo, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.KCp) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.KCq;
      ad.d(TAG, "scrollType " + this.KCq);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      ad.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.KCv.KCs)
      {
        d.g.a.a locala = this.KCv.KCr;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.KCv);
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