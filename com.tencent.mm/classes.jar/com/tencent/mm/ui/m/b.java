package com.tencent.mm.ui.m;

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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b
{
  public static final b.a QnH;
  private static String TAG;
  private boolean CIx;
  private final int QnA;
  private boolean QnB;
  private boolean QnC;
  public int QnD;
  kotlin.g.a.a<Boolean> QnE;
  public boolean QnF;
  private final HashSet<a> QnG;
  private float deo;
  private float dep;
  public final Runnable had;
  private final int rZ;
  
  static
  {
    AppMethodBeat.i(140944);
    QnH = new b.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.QnF = true;
    this.had = ((Runnable)new b(this));
    this.QnG = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.QnA = (ViewConfiguration.getLongPressTimeout() + 100);
    p.g(paramContext, "config");
    this.rZ = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    p.h(parama, "consumer");
    this.QnG.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void al(MotionEvent paramMotionEvent)
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
      this.deo = paramMotionEvent.getX();
      this.dep = paramMotionEvent.getY();
      this.QnB = false;
      this.CIx = false;
      this.QnC = false;
      this.QnD = 0;
      MMHandlerThread.postToMainThreadDelayed(this.had, this.QnA);
      Log.d(TAG, "downX:" + this.deo + "  downY:" + this.dep);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.deo;
      float f4 = f2 - this.dep;
      if (!this.CIx)
      {
        if ((Math.abs(f1 - this.deo) > this.rZ) || (Math.abs(f2 - this.dep) > this.rZ)) {
          bool = true;
        }
        this.CIx = bool;
      }
      if (this.CIx)
      {
        MMHandlerThread.removeRunnable(this.had);
        if (this.QnD == 0)
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
        this.QnD = i;
        Log.d(TAG, "scrollType " + this.QnD + " move: " + f3 + ", " + f4);
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
      MMHandlerThread.removeRunnable(this.had);
      this.QnD = 0;
      this.QnC = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(140942);
    p.h(paramMotionEvent, "event");
    Log.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.QnD;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.QnB) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.QnG.iterator();
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
            if ((this.CIx) && ((locala.fsk() & i) == 0)) {
              break label273;
            }
            bool1 = locala.a(paramMotionEvent, this.CIx, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.QnC) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.QnD;
      Log.d(TAG, "scrollType " + this.QnD);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(140939);
      Log.d(b.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
      if (this.QnI.QnF)
      {
        kotlin.g.a.a locala = this.QnI.QnE;
        if (locala == null) {
          break label64;
        }
        if (((Boolean)locala.invoke()).booleanValue() == true) {
          b.a(this.QnI);
        }
      }
      AppMethodBeat.o(140939);
      return;
      label64:
      AppMethodBeat.o(140939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.m.b
 * JD-Core Version:    0.7.0.1
 */