package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder FmH;
  private CharacterStyle FmK;
  private int FmN;
  private MMNeat7extView KCn;
  private LinearLayout KCo;
  private ProgressBar KCp;
  private TextView KCq;
  private NeatTextView.b KCr;
  private boolean KCs;
  private GestureDetector KCt;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.FmH = new SpannableStringBuilder();
    this.FmN = 3;
    this.FmK = new ForegroundColorSpan(-5066062);
    this.KCt = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187896);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(187896);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37424);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(37424);
          return false;
        }
        boolean bool = ChattingItemTranslate.a(ChattingItemTranslate.this).gC(ChattingItemTranslate.b(ChattingItemTranslate.this));
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37424);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187895);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(187895);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187894);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(187894);
        return bool;
      }
    });
    AppMethodBeat.o(37428);
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
    if (paramCharSequence.length() < this.FmN) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.FmN)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.FmK, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void yv(boolean paramBoolean)
  {
    AppMethodBeat.i(37432);
    Context localContext = ak.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(37432);
      return;
    }
    if (paramBoolean)
    {
      this.KCn.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8), com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 4));
      this.KCo.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.KCn.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8), com.tencent.mm.cb.a.fromDPToPix(localContext, 10), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    this.KCo.setVisibility(8);
    AppMethodBeat.o(37432);
  }
  
  public final void a(CharSequence paramCharSequence, b paramb)
  {
    AppMethodBeat.i(37430);
    if (!bu.ah(paramCharSequence))
    {
      this.KCn.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 80));
      this.KCn.setMaxWidth((int)(c.kt(ak.getContext()) / com.tencent.mm.cc.a.flw()) - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 5));
      this.KCn.setVisibility(0);
      if (paramb == b.KCy)
      {
        this.FmH.clear();
        this.KCn.aq(a(this.FmH, paramCharSequence));
        this.KCp.setVisibility(8);
        if (paramb != b.KCz) {
          break label135;
        }
        yv(true);
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(37430);
      return;
      this.KCn.aq(paramCharSequence);
      break;
      label135:
      yv(false);
      continue;
      if (paramb != b.KCw)
      {
        this.KCp.setVisibility(0);
        this.KCn.setVisibility(8);
        yv(false);
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.KCn;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.KCn = ((MMNeat7extView)findViewById(2131298203));
    this.KCp = ((ProgressBar)findViewById(2131298204));
    this.KCo = ((LinearLayout)findViewById(2131298201));
    this.KCq = ((TextView)findViewById(2131298200));
    this.KCn.setOnTouchListener(new g(this.KCn, new n(this.KCn.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.KCs)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.KCs = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.KCr != null) && (this.KCt != null))
    {
      localGestureDetector = this.KCt;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    this.KCq.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.KCr = paramb;
  }
  
  public static final class a
    extends bk
  {
    public CharSequence KCv;
    public int oOD = 1;
    
    public a(bv parambv, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt, null, '\000');
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(37427);
      KCw = new b("NoTransform", 0);
      KCx = new b("PreTransform", 1);
      KCy = new b("Transforming", 2);
      KCz = new b("Transformed", 3);
      KCA = new b[] { KCw, KCx, KCy, KCz };
      AppMethodBeat.o(37427);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */