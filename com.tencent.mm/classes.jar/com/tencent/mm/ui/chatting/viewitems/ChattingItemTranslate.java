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
import com.tencent.mm.g.a.qo;
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
  private boolean DMe;
  private CharacterStyle KdC;
  private int KdF;
  private SpannableStringBuilder Kdz;
  private MMNeat7extView POV;
  private LinearLayout POW;
  private ProgressBar POX;
  private TextView POY;
  private int POZ;
  private WeakReference<com.tencent.mm.ui.chatting.e.a> PPa;
  private NeatTextView.b PPb;
  private CharacterStyle PPc;
  private boolean PPd;
  private GestureDetector PPe;
  private long PyG;
  private MTimerHandler cve;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.POZ = 0;
    this.DMe = false;
    this.cve = null;
    this.PPa = null;
    this.PyG = 0L;
    this.Kdz = new SpannableStringBuilder();
    this.KdF = 3;
    this.KdC = new ForegroundColorSpan(-5066062);
    this.PPc = new ForegroundColorSpan(getContext().getResources().getColor(2131099662));
    this.PPe = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(233935);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(233935);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(233932);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (ChattingItemTranslate.e(ChattingItemTranslate.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(233932);
          return false;
        }
        boolean bool = ChattingItemTranslate.e(ChattingItemTranslate.this).gS(ChattingItemTranslate.c(ChattingItemTranslate.this));
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(233932);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(233934);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(233934);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(233933);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(233933);
        return bool;
      }
    });
    AppMethodBeat.o(37428);
  }
  
  private void Ck(boolean paramBoolean)
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
      this.POV.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8), com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 4));
      this.POW.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.POV.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8), com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    this.POW.setVisibility(8);
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
    if (paramCharSequence.length() < this.KdF) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.KdF)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.KdC, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void a(final CharSequence paramCharSequence, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(233939);
    if (paramInt <= this.POZ) {
      this.POZ = (paramInt - 2);
    }
    int i = this.POV.hashCode();
    if (paramCharSequence != null) {}
    for (String str = Util.secPrint(paramCharSequence.toString());; str = "null")
    {
      Log.i("MicroMsg.ChattingItemTranslate", "doVoiceTextAnimation(%s) %s %s %s %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), str, Integer.valueOf(paramInt), Integer.valueOf(this.POZ) });
      this.cve = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(233931);
          ChattingItemTranslate.a(ChattingItemTranslate.this).clear();
          int j = ChattingItemTranslate.b(ChattingItemTranslate.this) + 2;
          int i = j;
          if (j > paramInt) {
            i = paramInt;
          }
          Log.d("MicroMsg.ChattingItemTranslate", "(%s)currentContentLength:%s newCurrentContentLength:%s endNum:%s animating:%s", new Object[] { Integer.valueOf(ChattingItemTranslate.c(ChattingItemTranslate.this).hashCode()), Integer.valueOf(ChattingItemTranslate.b(ChattingItemTranslate.this)), Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(ChattingItemTranslate.d(ChattingItemTranslate.this)) });
          ChattingItemTranslate.a(ChattingItemTranslate.this, i);
          ChattingItemTranslate.c(ChattingItemTranslate.this).aw(ChattingItemTranslate.a(ChattingItemTranslate.this, ChattingItemTranslate.a(ChattingItemTranslate.this), paramCharSequence, ChattingItemTranslate.b(ChattingItemTranslate.this)));
          if (paramInt == ChattingItemTranslate.b(ChattingItemTranslate.this))
          {
            if (!ChattingItemTranslate.d(ChattingItemTranslate.this))
            {
              qo localqo = new qo();
              localqo.dXb.msgId = paramLong;
              EventCenter.instance.publish(localqo);
            }
            AppMethodBeat.o(233931);
            return false;
          }
          AppMethodBeat.o(233931);
          return true;
        }
      }, true);
      this.cve.startTimer(0L, 200L);
      AppMethodBeat.o(233939);
      return;
    }
  }
  
  private void gUi()
  {
    AppMethodBeat.i(233940);
    if (this.cve != null) {
      this.cve.stopTimer();
    }
    AppMethodBeat.o(233940);
  }
  
  public final void a(CharSequence paramCharSequence, c paramc)
  {
    AppMethodBeat.i(37430);
    a(paramCharSequence, paramc, false, ChattingItemTranslate.b.PPj, 0L, null);
    AppMethodBeat.o(37430);
  }
  
  public final void a(CharSequence paramCharSequence, c paramc, boolean paramBoolean, ChattingItemTranslate.b paramb, long paramLong, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(233941);
    if (!Util.isNullOrNil(paramCharSequence))
    {
      if (parama != null) {
        this.PPa = new WeakReference(parama);
      }
      this.POV.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80));
      this.POV.setMaxWidth((int)(c.kk(MMApplicationContext.getContext()) / com.tencent.mm.cc.a.gvi()) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
      this.POV.setVisibility(0);
      this.POX.setVisibility(8);
      if (paramb == ChattingItemTranslate.b.PPk)
      {
        Ck(false);
        Log.d("MicroMsg.ChattingItemTranslate", "setContent(%s) msgId:%s currentMsgId:%s content:%s status:%s canAnimation:%s currentContentLength:%s", new Object[] { Integer.valueOf(this.POV.hashCode()), Long.valueOf(paramLong), Long.valueOf(this.PyG), Util.secPrint(paramCharSequence.toString()), paramc, Boolean.valueOf(paramBoolean), Integer.valueOf(this.POZ) });
        if (this.PyG != paramLong)
        {
          this.POV.aw("");
          this.POZ = 0;
          gUi();
          this.cve = null;
          this.DMe = false;
        }
        this.PyG = paramLong;
        if (paramBoolean)
        {
          this.POV.aw("");
          this.POZ = 0;
          gUi();
          this.cve = null;
          this.DMe = true;
        }
        if ((paramc == c.PPp) && (paramBoolean))
        {
          gUi();
          a(paramCharSequence, paramCharSequence.length(), paramLong);
          this.DMe = false;
        }
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(233941);
      return;
      if ((paramc == c.PPo) || (paramBoolean))
      {
        gUi();
        if (paramCharSequence.length() > 3) {
          a(paramCharSequence, paramCharSequence.length() - 3, paramLong);
        } else {
          this.POV.aw(paramCharSequence);
        }
      }
      else if ((paramc == c.PPp) && (this.cve != null))
      {
        if (this.POZ != paramCharSequence.length())
        {
          if (this.DMe)
          {
            gUi();
            a(paramCharSequence, paramCharSequence.length(), paramLong);
            this.DMe = false;
          }
        }
        else {
          this.POV.aw(paramCharSequence);
        }
      }
      else
      {
        this.POV.aw(paramCharSequence);
        continue;
        if (paramc == c.PPo)
        {
          this.Kdz.clear();
          this.POV.aw(a(this.Kdz, paramCharSequence));
        }
        for (;;)
        {
          if (paramc != c.PPp) {
            break label493;
          }
          Ck(true);
          break;
          this.POV.aw(paramCharSequence);
        }
        label493:
        Ck(false);
        continue;
        if (paramc != c.PPm)
        {
          this.POX.setVisibility(0);
          this.POV.setVisibility(8);
          Ck(false);
        }
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.POV;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.POV = ((MMNeat7extView)findViewById(2131298585));
    this.POX = ((ProgressBar)findViewById(2131298586));
    this.POW = ((LinearLayout)findViewById(2131298583));
    this.POY = ((TextView)findViewById(2131298582));
    this.POV.setOnTouchListener(new h(this.POV, new o(this.POV.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.PPd)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.PPd = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.PPb != null) && (this.PPe != null))
    {
      localGestureDetector = this.PPe;
      locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    this.POY.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.PPb = paramb;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(233942);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.POX.setVisibility(8);
    }
    AppMethodBeat.o(233942);
  }
  
  public static final class a
    extends bq
  {
    public CharSequence PPi;
    public int qcr = 1;
    
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
      PPm = new c("NoTransform", 0);
      PPn = new c("PreTransform", 1);
      PPo = new c("Transforming", 2);
      PPp = new c("Transformed", 3);
      PPq = new c[] { PPm, PPn, PPo, PPp };
      AppMethodBeat.o(37427);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */