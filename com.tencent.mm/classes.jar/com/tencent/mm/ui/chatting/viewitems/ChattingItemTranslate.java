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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder EUm;
  private CharacterStyle EUp;
  private int EUs;
  private MMNeat7extView KfU;
  private LinearLayout KfV;
  private ProgressBar KfW;
  private TextView KfX;
  private NeatTextView.b KfY;
  private boolean KfZ;
  private GestureDetector Kga;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.EUm = new SpannableStringBuilder();
    this.EUs = 3;
    this.EUp = new ForegroundColorSpan(-5066062);
    this.Kga = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194501);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(194501);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37424);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(37424);
          return false;
        }
        boolean bool = ChattingItemTranslate.a(ChattingItemTranslate.this).gx(ChattingItemTranslate.b(ChattingItemTranslate.this));
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37424);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194500);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(194500);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194499);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(194499);
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
    if (paramCharSequence.length() < this.EUs) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.EUs)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.EUp, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void yi(boolean paramBoolean)
  {
    AppMethodBeat.i(37432);
    Context localContext = aj.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(37432);
      return;
    }
    if (paramBoolean)
    {
      this.KfU.setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 10), com.tencent.mm.cc.a.fromDPToPix(localContext, 8), com.tencent.mm.cc.a.fromDPToPix(localContext, 10), com.tencent.mm.cc.a.fromDPToPix(localContext, 4));
      this.KfV.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.KfU.setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 10), com.tencent.mm.cc.a.fromDPToPix(localContext, 8), com.tencent.mm.cc.a.fromDPToPix(localContext, 10), com.tencent.mm.cc.a.fromDPToPix(localContext, 8));
    this.KfV.setVisibility(8);
    AppMethodBeat.o(37432);
  }
  
  public final void a(CharSequence paramCharSequence, b paramb)
  {
    AppMethodBeat.i(37430);
    if (!bt.ai(paramCharSequence))
    {
      this.KfU.setMinWidth(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 80));
      this.KfU.setMaxWidth((int)(c.km(aj.getContext()) / com.tencent.mm.cd.a.fhE()) - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 5));
      this.KfU.setVisibility(0);
      if (paramb == b.Kgf)
      {
        this.EUm.clear();
        this.KfU.ar(a(this.EUm, paramCharSequence));
        this.KfW.setVisibility(8);
        if (paramb != b.Kgg) {
          break label135;
        }
        yi(true);
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(37430);
      return;
      this.KfU.ar(paramCharSequence);
      break;
      label135:
      yi(false);
      continue;
      if (paramb != b.Kgd)
      {
        this.KfW.setVisibility(0);
        this.KfU.setVisibility(8);
        yi(false);
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.KfU;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.KfU = ((MMNeat7extView)findViewById(2131298203));
    this.KfW = ((ProgressBar)findViewById(2131298204));
    this.KfV = ((LinearLayout)findViewById(2131298201));
    this.KfX = ((TextView)findViewById(2131298200));
    this.KfU.setOnTouchListener(new g(this.KfU, new n(this.KfU.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.KfZ)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.KfZ = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.KfY != null) && (this.Kga != null))
    {
      localGestureDetector = this.Kga;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    this.KfX.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.KfY = paramb;
  }
  
  public static final class a
    extends bk
  {
    public CharSequence Kgc;
    public int oIb = 1;
    
    public a(bu parambu, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt, null, '\000');
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(37427);
      Kgd = new b("NoTransform", 0);
      Kge = new b("PreTransform", 1);
      Kgf = new b("Transforming", 2);
      Kgg = new b("Transformed", 3);
      Kgh = new b[] { Kgd, Kge, Kgf, Kgg };
      AppMethodBeat.o(37427);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */