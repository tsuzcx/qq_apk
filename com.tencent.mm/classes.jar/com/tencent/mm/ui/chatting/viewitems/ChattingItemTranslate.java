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
import com.tencent.mm.autogen.a.td;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.lang.ref.WeakReference;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder Yal;
  private CharacterStyle Yao;
  private int Yar;
  private long aeCI;
  private MMNeat7extView aeVN;
  private LinearLayout aeVO;
  private ProgressBar aeVP;
  private TextView aeVQ;
  private int aeVR;
  private WeakReference<com.tencent.mm.ui.chatting.d.a> aeVS;
  private NeatTextView.b aeVT;
  private CharacterStyle aeVU;
  private boolean aeVV;
  private GestureDetector aeVW;
  private boolean animating;
  private MTimerHandler eln;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.aeVR = 0;
    this.animating = false;
    this.eln = null;
    this.aeVS = null;
    this.aeCI = 0L;
    this.Yal = new SpannableStringBuilder();
    this.Yar = 3;
    this.Yao = new ForegroundColorSpan(-5066062);
    this.aeVU = new ForegroundColorSpan(getContext().getResources().getColor(R.e.BW_0_Alpha_0_3));
    this.aeVW = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(254949);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254949);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(254940);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        if (ChattingItemTranslate.e(ChattingItemTranslate.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(254940);
          return false;
        }
        boolean bool = ChattingItemTranslate.e(ChattingItemTranslate.this).lA(ChattingItemTranslate.c(ChattingItemTranslate.this));
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254940);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(254947);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(254947);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(254943);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254943);
        return bool;
      }
    });
    AppMethodBeat.o(37428);
  }
  
  private void Mu(boolean paramBoolean)
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
      this.aeVN.setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 10), com.tencent.mm.cd.a.fromDPToPix(localContext, 8), com.tencent.mm.cd.a.fromDPToPix(localContext, 10), com.tencent.mm.cd.a.fromDPToPix(localContext, 4));
      this.aeVO.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.aeVN.setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 10), com.tencent.mm.cd.a.fromDPToPix(localContext, 8), com.tencent.mm.cd.a.fromDPToPix(localContext, 10), com.tencent.mm.cd.a.fromDPToPix(localContext, 8));
    this.aeVO.setVisibility(8);
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
    if (paramCharSequence.length() < this.Yar) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.Yar)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.Yao, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void a(final CharSequence paramCharSequence, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(255655);
    if (paramInt <= this.aeVR) {
      this.aeVR = (paramInt - 2);
    }
    int i = this.aeVN.hashCode();
    if (paramCharSequence != null) {}
    for (String str = Util.secPrint(paramCharSequence.toString());; str = "null")
    {
      Log.i("MicroMsg.ChattingItemTranslate", "doVoiceTextAnimation(%s) %s %s %s %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), str, Integer.valueOf(paramInt), Integer.valueOf(this.aeVR) });
      this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(254939);
          ChattingItemTranslate.a(ChattingItemTranslate.this).clear();
          int j = ChattingItemTranslate.b(ChattingItemTranslate.this) + 2;
          int i = j;
          if (j > paramInt) {
            i = paramInt;
          }
          Log.d("MicroMsg.ChattingItemTranslate", "(%s)currentContentLength:%s newCurrentContentLength:%s endNum:%s animating:%s", new Object[] { Integer.valueOf(ChattingItemTranslate.c(ChattingItemTranslate.this).hashCode()), Integer.valueOf(ChattingItemTranslate.b(ChattingItemTranslate.this)), Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(ChattingItemTranslate.d(ChattingItemTranslate.this)) });
          ChattingItemTranslate.a(ChattingItemTranslate.this, i);
          ChattingItemTranslate.c(ChattingItemTranslate.this).aZ(ChattingItemTranslate.a(ChattingItemTranslate.this, ChattingItemTranslate.a(ChattingItemTranslate.this), paramCharSequence, ChattingItemTranslate.b(ChattingItemTranslate.this)));
          if (paramInt == ChattingItemTranslate.b(ChattingItemTranslate.this))
          {
            if (!ChattingItemTranslate.d(ChattingItemTranslate.this))
            {
              td localtd = new td();
              localtd.hWK.msgId = paramLong;
              localtd.publish();
            }
            AppMethodBeat.o(254939);
            return false;
          }
          AppMethodBeat.o(254939);
          return true;
        }
      }, true);
      this.eln.startTimer(0L, 200L);
      AppMethodBeat.o(255655);
      return;
    }
  }
  
  private void jxB()
  {
    AppMethodBeat.i(255660);
    if (this.eln != null) {
      this.eln.stopTimer();
    }
    AppMethodBeat.o(255660);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.c paramc)
  {
    AppMethodBeat.i(37430);
    a(paramCharSequence, paramc, false, ChattingItemTranslate.b.aeWb, 0L, null);
    AppMethodBeat.o(37430);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.c paramc, boolean paramBoolean, ChattingItemTranslate.b paramb, long paramLong, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(255699);
    if (!Util.isNullOrNil(paramCharSequence))
    {
      if (parama != null) {
        this.aeVS = new WeakReference(parama);
      }
      this.aeVN.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 80));
      this.aeVN.setMaxWidth((int)(c.nm(MMApplicationContext.getContext()) / com.tencent.mm.ce.c.iRs()) - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5));
      this.aeVN.setVisibility(0);
      this.aeVP.setVisibility(8);
      if (paramb == ChattingItemTranslate.b.aeWc)
      {
        Mu(false);
        Log.d("MicroMsg.ChattingItemTranslate", "setContent(%s) msgId:%s currentMsgId:%s content:%s status:%s canAnimation:%s currentContentLength:%s", new Object[] { Integer.valueOf(this.aeVN.hashCode()), Long.valueOf(paramLong), Long.valueOf(this.aeCI), Util.secPrint(paramCharSequence.toString()), paramc, Boolean.valueOf(paramBoolean), Integer.valueOf(this.aeVR) });
        if (this.aeCI != paramLong)
        {
          this.aeVN.aZ("");
          this.aeVR = 0;
          jxB();
          this.eln = null;
          this.animating = false;
        }
        this.aeCI = paramLong;
        if (paramBoolean)
        {
          this.aeVN.aZ("");
          this.aeVR = 0;
          jxB();
          this.eln = null;
          this.animating = true;
        }
        if ((paramc == ChattingItemTranslate.c.aeWh) && (paramBoolean))
        {
          jxB();
          a(paramCharSequence, paramCharSequence.length(), paramLong);
          this.animating = false;
        }
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(255699);
      return;
      if ((paramc == ChattingItemTranslate.c.aeWg) || (paramBoolean))
      {
        jxB();
        if (paramCharSequence.length() > 3) {
          a(paramCharSequence, paramCharSequence.length() - 3, paramLong);
        } else {
          this.aeVN.aZ(paramCharSequence);
        }
      }
      else if ((paramc == ChattingItemTranslate.c.aeWh) && (this.eln != null))
      {
        if (this.aeVR != paramCharSequence.length())
        {
          if (this.animating)
          {
            jxB();
            a(paramCharSequence, paramCharSequence.length(), paramLong);
            this.animating = false;
          }
        }
        else {
          this.aeVN.aZ(paramCharSequence);
        }
      }
      else
      {
        this.aeVN.aZ(paramCharSequence);
        continue;
        if (paramc == ChattingItemTranslate.c.aeWg)
        {
          this.Yal.clear();
          this.aeVN.aZ(a(this.Yal, paramCharSequence));
        }
        for (;;)
        {
          if (paramc != ChattingItemTranslate.c.aeWh) {
            break label493;
          }
          Mu(true);
          break;
          this.aeVN.aZ(paramCharSequence);
        }
        label493:
        Mu(false);
        continue;
        if (paramc != ChattingItemTranslate.c.aeWe)
        {
          this.aeVP.setVisibility(0);
          this.aeVN.setVisibility(8);
          Mu(false);
        }
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.aeVN;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.aeVN = ((MMNeat7extView)findViewById(R.h.fAG));
    this.aeVP = ((ProgressBar)findViewById(R.h.fAH));
    this.aeVO = ((LinearLayout)findViewById(R.h.fAF));
    this.aeVQ = ((TextView)findViewById(R.h.fAE));
    this.aeVN.setOnTouchListener(new l(this.aeVN, new s(this.aeVN.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.aeVV)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.aeVV = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.aeVT != null) && (this.aeVW != null))
    {
      localGestureDetector = this.aeVW;
      locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    this.aeVQ.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.aeVT = paramb;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(255715);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.aeVP.setVisibility(8);
    }
    AppMethodBeat.o(255715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */