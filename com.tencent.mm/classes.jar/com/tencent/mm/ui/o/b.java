package com.tencent.mm.ui.o;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static String TAG;
  public static final b.a afBH;
  public int Irw;
  private boolean OUP;
  private final int afBI;
  private boolean afBJ;
  private boolean afBK;
  private kotlin.g.a.a<Boolean> afBL;
  public boolean afBM;
  private final HashSet<a> afBN;
  private final int doK;
  private float fif;
  private float fig;
  public final Runnable mkq;
  
  static
  {
    AppMethodBeat.i(140944);
    afBH = new b.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(140944);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(140943);
    this.afBM = true;
    this.mkq = new b..ExternalSyntheticLambda0(this);
    this.afBN = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.afBI = (ViewConfiguration.getLongPressTimeout() + 100);
    this.doK = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(140943);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(249802);
    s.u(paramb, "this$0");
    Log.d(TAG, "MSG_STORY_LONG_PRESS_CHECK");
    if (paramb.afBM)
    {
      kotlin.g.a.a locala = paramb.afBL;
      if ((locala == null) || (((Boolean)locala.invoke()).booleanValue() != true)) {
        break label68;
      }
    }
    label68:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramb.afBJ = true;
      }
      AppMethodBeat.o(249802);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140940);
    s.u(parama, "consumer");
    this.afBN.add(parama);
    AppMethodBeat.o(140940);
  }
  
  public final void aw(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(140941);
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140941);
      return;
      this.fif = paramMotionEvent.getX();
      this.fig = paramMotionEvent.getY();
      this.afBJ = false;
      this.OUP = false;
      this.afBK = false;
      this.Irw = 0;
      MMHandlerThread.postToMainThreadDelayed(this.mkq, this.afBI);
      Log.d(TAG, "downX:" + this.fif + "  downY:" + this.fig);
      AppMethodBeat.o(140941);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.fif;
      float f4 = f2 - this.fig;
      if (!this.OUP)
      {
        if ((Math.abs(f1 - this.fif) > this.doK) || (Math.abs(f2 - this.fig) > this.doK)) {
          bool = true;
        }
        this.OUP = bool;
      }
      if (this.OUP)
      {
        MMHandlerThread.removeRunnable(this.mkq);
        if (this.Irw == 0)
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
        this.Irw = i;
        Log.d(TAG, "scrollType " + this.Irw + " move: " + f3 + ", " + f4);
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
      MMHandlerThread.removeRunnable(this.mkq);
      this.Irw = 0;
      this.afBK = true;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140942);
    s.u(paramMotionEvent, "event");
    Log.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.Irw;
    int j;
    boolean bool1;
    label108:
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.afBJ)
      {
        bool1 = true;
        if ((!bool1) && (j != 0))
        {
          Iterator localIterator = this.afBN.iterator();
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
            if ((!this.OUP) || ((locala.hAc() & i) != 0)) {
              bool1 = locala.a(paramMotionEvent, this.OUP, i) | bool1;
            }
          }
        }
      }
      break;
    case 2: 
      if (!this.afBK) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.Irw;
      Log.d(TAG, s.X("scrollType ", Integer.valueOf(this.Irw)));
      j = i;
      i = k;
      break;
      i = 15;
      j = 1;
      break;
      bool2 = bool1;
      AppMethodBeat.o(140942);
      return bool2;
      bool1 = false;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.o.b
 * JD-Core Version:    0.7.0.1
 */