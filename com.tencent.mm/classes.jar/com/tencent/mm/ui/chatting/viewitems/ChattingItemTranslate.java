package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.f.a.ro;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.lang.ref.WeakReference;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder Reg;
  private CharacterStyle Rej;
  private int Rem;
  private long WTf;
  private MMNeat7extView XkX;
  private LinearLayout XkY;
  private ProgressBar XkZ;
  private TextView Xla;
  private int Xlb;
  private WeakReference<com.tencent.mm.ui.chatting.e.a> Xlc;
  private NeatTextView.b Xld;
  private CharacterStyle Xle;
  private boolean Xlf;
  private GestureDetector Xlg;
  private boolean animating;
  private MTimerHandler cts;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.Xlb = 0;
    this.animating = false;
    this.cts = null;
    this.Xlc = null;
    this.WTf = 0L;
    this.Reg = new SpannableStringBuilder();
    this.Rem = 3;
    this.Rej = new ForegroundColorSpan(-5066062);
    this.Xle = new ForegroundColorSpan(getContext().getResources().getColor(R.e.BW_0_Alpha_0_3));
    this.Xlg = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(286173);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(286173);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(286169);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        if (ChattingItemTranslate.e(ChattingItemTranslate.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(286169);
          return false;
        }
        boolean bool = ChattingItemTranslate.e(ChattingItemTranslate.this).ie(ChattingItemTranslate.c(ChattingItemTranslate.this));
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(286169);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(286171);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(286171);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(286170);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(286170);
        return bool;
      }
    });
    AppMethodBeat.o(37428);
  }
  
  private void GF(boolean paramBoolean)
  {
    AppMethodBeat.i(37432);
    Context localContext = MMApplicationContext.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(37432);
      return;
    }
    if (paramBoolean)
    {
      this.XkX.setPadding(com.tencent.mm.ci.a.fromDPToPix(localContext, 10), com.tencent.mm.ci.a.fromDPToPix(localContext, 8), com.tencent.mm.ci.a.fromDPToPix(localContext, 10), com.tencent.mm.ci.a.fromDPToPix(localContext, 4));
      this.XkY.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.XkX.setPadding(com.tencent.mm.ci.a.fromDPToPix(localContext, 10), com.tencent.mm.ci.a.fromDPToPix(localContext, 8), com.tencent.mm.ci.a.fromDPToPix(localContext, 10), com.tencent.mm.ci.a.fromDPToPix(localContext, 8));
    this.XkY.setVisibility(8);
    AppMethodBeat.o(37432);
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(37433);
    if ((paramSpannableStringBuilder == null) || (paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
    }
    int j;
    if (paramCharSequence.length() < this.Rem) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.Rem)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.Rej, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void a(final CharSequence paramCharSequence, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(278598);
    if (paramInt <= this.Xlb) {
      this.Xlb = (paramInt - 2);
    }
    int i = this.XkX.hashCode();
    if (paramCharSequence != null) {}
    for (String str = Util.secPrint(paramCharSequence.toString());; str = "null")
    {
      Log.i("MicroMsg.ChattingItemTranslate", "doVoiceTextAnimation(%s) %s %s %s %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), str, Integer.valueOf(paramInt), Integer.valueOf(this.Xlb) });
      this.cts = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(278619);
          ChattingItemTranslate.a(ChattingItemTranslate.this).clear();
          int j = ChattingItemTranslate.b(ChattingItemTranslate.this) + 2;
          int i = j;
          if (j > paramInt) {
            i = paramInt;
          }
          Log.d("MicroMsg.ChattingItemTranslate", "(%s)currentContentLength:%s newCurrentContentLength:%s endNum:%s animating:%s", new Object[] { Integer.valueOf(ChattingItemTranslate.c(ChattingItemTranslate.this).hashCode()), Integer.valueOf(ChattingItemTranslate.b(ChattingItemTranslate.this)), Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(ChattingItemTranslate.d(ChattingItemTranslate.this)) });
          ChattingItemTranslate.a(ChattingItemTranslate.this, i);
          ChattingItemTranslate.c(ChattingItemTranslate.this).aL(ChattingItemTranslate.a(ChattingItemTranslate.this, ChattingItemTranslate.a(ChattingItemTranslate.this), paramCharSequence, ChattingItemTranslate.b(ChattingItemTranslate.this)));
          if (paramInt == ChattingItemTranslate.b(ChattingItemTranslate.this))
          {
            if (!ChattingItemTranslate.d(ChattingItemTranslate.this))
            {
              ro localro = new ro();
              localro.fQN.msgId = paramLong;
              EventCenter.instance.publish(localro);
            }
            AppMethodBeat.o(278619);
            return false;
          }
          AppMethodBeat.o(278619);
          return true;
        }
      }, true);
      this.cts.startTimer(0L, 200L);
      AppMethodBeat.o(278598);
      return;
    }
  }
  
  private void hTW()
  {
    AppMethodBeat.i(278599);
    if (this.cts != null) {
      this.cts.stopTimer();
    }
    AppMethodBeat.o(278599);
  }
  
  public final void a(CharSequence paramCharSequence, c paramc)
  {
    AppMethodBeat.i(37430);
    a(paramCharSequence, paramc, false, ChattingItemTranslate.b.Xll, 0L, null);
    AppMethodBeat.o(37430);
  }
  
  public final void a(CharSequence paramCharSequence, c paramc, boolean paramBoolean, ChattingItemTranslate.b paramb, long paramLong, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(278601);
    if (!Util.isNullOrNil(paramCharSequence))
    {
      if (parama != null) {
        this.Xlc = new WeakReference(parama);
      }
      this.XkX.setMinWidth(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 80));
      this.XkX.setMaxWidth((int)(c.li(MMApplicationContext.getContext()) / com.tencent.mm.cj.a.hrd()) - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 5));
      this.XkX.setVisibility(0);
      this.XkZ.setVisibility(8);
      if (paramb == ChattingItemTranslate.b.Xlm)
      {
        GF(false);
        Log.d("MicroMsg.ChattingItemTranslate", "setContent(%s) msgId:%s currentMsgId:%s content:%s status:%s canAnimation:%s currentContentLength:%s", new Object[] { Integer.valueOf(this.XkX.hashCode()), Long.valueOf(paramLong), Long.valueOf(this.WTf), Util.secPrint(paramCharSequence.toString()), paramc, Boolean.valueOf(paramBoolean), Integer.valueOf(this.Xlb) });
        if (this.WTf != paramLong)
        {
          this.XkX.aL("");
          this.Xlb = 0;
          hTW();
          this.cts = null;
          this.animating = false;
        }
        this.WTf = paramLong;
        if (paramBoolean)
        {
          this.XkX.aL("");
          this.Xlb = 0;
          hTW();
          this.cts = null;
          this.animating = true;
        }
        if ((paramc == c.Xlr) && (paramBoolean))
        {
          hTW();
          a(paramCharSequence, paramCharSequence.length(), paramLong);
          this.animating = false;
        }
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(278601);
      return;
      if ((paramc == c.Xlq) || (paramBoolean))
      {
        hTW();
        if (paramCharSequence.length() > 3) {
          a(paramCharSequence, paramCharSequence.length() - 3, paramLong);
        } else {
          this.XkX.aL(paramCharSequence);
        }
      }
      else if ((paramc == c.Xlr) && (this.cts != null))
      {
        if (this.Xlb != paramCharSequence.length())
        {
          if (this.animating)
          {
            hTW();
            a(paramCharSequence, paramCharSequence.length(), paramLong);
            this.animating = false;
          }
        }
        else {
          this.XkX.aL(paramCharSequence);
        }
      }
      else
      {
        this.XkX.aL(paramCharSequence);
        continue;
        if (paramc == c.Xlq)
        {
          this.Reg.clear();
          this.XkX.aL(a(this.Reg, paramCharSequence));
        }
        for (;;)
        {
          if (paramc != c.Xlr) {
            break label493;
          }
          GF(true);
          break;
          this.XkX.aL(paramCharSequence);
        }
        label493:
        GF(false);
        continue;
        if (paramc != c.Xlo)
        {
          this.XkZ.setVisibility(0);
          this.XkX.setVisibility(8);
          GF(false);
        }
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.XkX;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.XkX = ((MMNeat7extView)findViewById(R.h.dzM));
    this.XkZ = ((ProgressBar)findViewById(R.h.dzN));
    this.XkY = ((LinearLayout)findViewById(R.h.dzL));
    this.Xla = ((TextView)findViewById(R.h.dzK));
    this.XkX.setOnTouchListener(new h(this.XkX, new o(this.XkX.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.Xlf)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.Xlf = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.Xld != null) && (this.Xlg != null))
    {
      localGestureDetector = this.Xlg;
      locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(37434);
      return bool2;
    }
  }
  
  public void setBrandWording(String paramString)
  {
    AppMethodBeat.i(37431);
    this.Xla.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.Xld = paramb;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(278605);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.XkZ.setVisibility(8);
    }
    AppMethodBeat.o(278605);
  }
  
  public static final class a
    extends by
  {
    public CharSequence Xlk;
    public int viewType = 1;
    
    public a(ca paramca, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt, null, '\000');
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(37427);
      Xlo = new c("NoTransform", 0);
      Xlp = new c("PreTransform", 1);
      Xlq = new c("Transforming", 2);
      Xlr = new c("Transformed", 3);
      Xls = new c[] { Xlo, Xlp, Xlq, Xlr };
      AppMethodBeat.o(37427);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */