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
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder BWR;
  private CharacterStyle BWU;
  private int BWX;
  private MMNeat7extView GPs;
  private LinearLayout GPt;
  private ProgressBar GPu;
  private TextView GPv;
  private NeatTextView.b GPw;
  private boolean GPx;
  private GestureDetector GPy;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.BWR = new SpannableStringBuilder();
    this.BWX = 3;
    this.BWU = new ForegroundColorSpan(-5066062);
    this.GPy = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37424);
        if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null)
        {
          AppMethodBeat.o(37424);
          return false;
        }
        boolean bool = ChattingItemTranslate.a(ChattingItemTranslate.this).fT(ChattingItemTranslate.b(ChattingItemTranslate.this));
        AppMethodBeat.o(37424);
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
    if (paramCharSequence.length() < this.BWX) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.BWX)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.BWU, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void wq(boolean paramBoolean)
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
      this.GPs.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 4));
      this.GPt.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.GPs.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8));
    this.GPt.setVisibility(8);
    AppMethodBeat.o(37432);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(37430);
    if (!bt.ai(paramCharSequence))
    {
      this.GPs.setMinWidth(a.fromDPToPix(aj.getContext(), 80));
      this.GPs.setMaxWidth(a.fromDPToPix(aj.getContext(), 259));
      this.GPs.setVisibility(0);
      if (paramb == ChattingItemTranslate.b.GPD)
      {
        this.BWR.clear();
        this.GPs.aq(a(this.BWR, paramCharSequence));
        this.GPu.setVisibility(8);
        if (paramb != ChattingItemTranslate.b.GPE) {
          break label124;
        }
        wq(true);
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(37430);
      return;
      this.GPs.aq(paramCharSequence);
      break;
      label124:
      wq(false);
      continue;
      if (paramb != ChattingItemTranslate.b.GPB)
      {
        this.GPu.setVisibility(0);
        this.GPs.setVisibility(8);
        wq(false);
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.GPs;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.GPs = ((MMNeat7extView)findViewById(2131298203));
    this.GPu = ((ProgressBar)findViewById(2131298204));
    this.GPt = ((LinearLayout)findViewById(2131298201));
    this.GPv = ((TextView)findViewById(2131298200));
    this.GPs.setOnTouchListener(new g(this.GPs, new n(this.GPs.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.GPx)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.GPx = false;
    }
    if ((this.GPw != null) && (this.GPy != null)) {}
    for (boolean bool1 = this.GPy.onTouchEvent(paramMotionEvent);; bool1 = false)
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
    this.GPv.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.GPw = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */