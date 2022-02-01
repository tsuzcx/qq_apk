package com.tencent.mm.ui.j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  public static final b.a ILn;
  private static String TAG;
  private final int ILf;
  private boolean ILg;
  private boolean ILh;
  private boolean ILi;
  public int ILj;
  d.g.a.a<Boolean> ILk;
  public boolean ILl;
  private final HashSet<a> ILm;
  private float cCh;
  private float cCi;
  public final Runnable fTk;
  private final int qc;
  
  static
  {
    AppMethodBeat.i(140944);
    ILn = new b.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.ILl = true;
    this.fTk = ((Runnable)new b(this));
    this.ILm = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.ILf = (ViewConfiguration.getLongPressTimeout() + 100);
    k.g(paramContext, "config");
    this.qc = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    k.h(parama, "consumer");
    this.ILm.add(parama);
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
      this.cCh = paramMotionEvent.getX();
      this.cCi = paramMotionEvent.getY();
      this.ILg = false;
      this.ILh = false;
      this.ILi = false;
      this.ILj = 0;
      ap.n(this.fTk, this.ILf);
      ac.d(TAG, "downX:" + this.cCh + "  downY:" + this.cCi);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.cCh;
      float f4 = f2 - this.cCi;
      if (!this.ILh)
      {
        if ((Math.abs(f1 - this.cCh) > this.qc) || (Math.abs(f2 - this.cCi) > this.qc)) {
          bool = true;
        }
        this.ILh = bool;
      }
      if (this.ILh)
      {
        ap.aB(this.fTk);
        if (this.ILj == 0)
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
        this.ILj = i;
        ac.d(TAG, "scrollType " + this.ILj + " move: " + f3 + ", " + f4);
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
      ap.aB(this.fTk);
      this.ILj = 0;
      this.ILi = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    k.h(paramMotionEvent, "event");
    ac.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.ILj;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.ILg) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.ILm.iterator();
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
            if ((this.ILh) && ((locala.dZN() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.ILh, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.ILi) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.ILj;
      ac.d(TAG, "scrollType " + this.ILj);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      ac.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.ILo.ILl)
      {
        d.g.a.a locala = this.ILo.ILk;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.ILo);
        }
      }
      AppMethodBeat.o(140939);
      return;
      label64:
      AppMethodBeat.o(140939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.j.b
 * JD-Core Version:    0.7.0.1
 */