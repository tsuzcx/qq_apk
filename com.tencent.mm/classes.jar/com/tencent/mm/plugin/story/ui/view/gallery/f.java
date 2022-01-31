package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "onNestedPreFling", "velocityX", "velocityY", "onNestedPreScroll", "scrollX", "scrollY", "consumed", "", "onStopNestedScroll", "removeScrollConsumer", "trackTouchEvent", "Companion", "plugin-story_release"})
public final class f
{
  private static String TAG;
  public static final f.a sSp;
  private float bTE;
  private float bTF;
  private final int nwj;
  final Runnable oOd;
  private final int sSh;
  private boolean sSi;
  private boolean sSj;
  private boolean sSk;
  public int sSl;
  a<Boolean> sSm;
  boolean sSn;
  private final HashSet<e> sSo;
  
  static
  {
    AppMethodBeat.i(110737);
    sSp = new f.a((byte)0);
    TAG = "MicroMsg.GalleryScrollHelper";
    AppMethodBeat.o(110737);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(110736);
    this.sSn = true;
    this.oOd = ((Runnable)new f.b(this));
    this.sSo = new HashSet();
    paramContext = ViewConfiguration.get(paramContext);
    this.sSh = (ViewConfiguration.getLongPressTimeout() + 100);
    j.p(paramContext, "config");
    this.nwj = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(110736);
  }
  
  public final void N(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(110734);
    j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110734);
      return;
      this.bTE = paramMotionEvent.getX();
      this.bTF = paramMotionEvent.getY();
      this.sSi = false;
      this.sSj = false;
      this.sSk = false;
      this.sSl = 0;
      al.p(this.oOd, this.sSh);
      ab.d(TAG, "downX:" + this.bTE + "  downY:" + this.bTF);
      AppMethodBeat.o(110734);
      return;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.bTE;
      float f4 = f2 - this.bTF;
      if (!this.sSj)
      {
        if ((Math.abs(f1 - this.bTE) > this.nwj) || (Math.abs(f2 - this.bTF) > this.nwj)) {
          bool = true;
        }
        this.sSj = bool;
      }
      if (this.sSj)
      {
        al.ae(this.oOd);
        if (this.sSl == 0)
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
        this.sSl = i;
        ab.d(TAG, "scrollType " + this.sSl + " move: " + f3 + ", " + f4);
        AppMethodBeat.o(110734);
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
      al.ae(this.oOd);
      this.sSl = 0;
      this.sSk = true;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(110733);
    j.q(parame, "consumer");
    this.sSo.add(parame);
    AppMethodBeat.o(110733);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(110735);
    j.q(paramMotionEvent, "event");
    ab.d(TAG, "dispatchTouchEvent " + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ' ' + paramMotionEvent.getY());
    int i = this.sSl;
    int j;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      j = 1;
      if (this.sSi) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != 0)
        {
          Iterator localIterator = this.sSo.iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            e locale = (e)localIterator.next();
            bool2 = bool1;
            if (bool1) {
              break;
            }
            if ((this.sSj) && ((locale.cFW() & i) == 0)) {
              break label273;
            }
            bool1 = locale.a(paramMotionEvent, this.sSj, i) | bool1;
          }
        }
      }
      break;
    case 2: 
      label206:
      if (!this.sSk) {}
      break;
    }
    for (i = 0;; i = 1)
    {
      int k = this.sSl;
      ab.d(TAG, "scrollType " + this.sSl);
      j = i;
      i = k;
      break;
      i = 15;
      j = 1;
      break;
      AppMethodBeat.o(110735);
      return bool2;
      label273:
      break label206;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */