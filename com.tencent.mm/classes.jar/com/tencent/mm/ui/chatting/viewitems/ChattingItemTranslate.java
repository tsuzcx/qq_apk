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
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder Dpi;
  private CharacterStyle Dpl;
  private int Dpo;
  private GestureDetector IpA;
  private MMNeat7extView Ipu;
  private LinearLayout Ipv;
  private ProgressBar Ipw;
  private TextView Ipx;
  private NeatTextView.b Ipy;
  private boolean Ipz;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37428);
    this.Dpi = new SpannableStringBuilder();
    this.Dpo = 3;
    this.Dpl = new ForegroundColorSpan(-5066062);
    this.IpA = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37424);
        if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null)
        {
          AppMethodBeat.o(37424);
          return false;
        }
        boolean bool = ChattingItemTranslate.a(ChattingItemTranslate.this).gg(ChattingItemTranslate.b(ChattingItemTranslate.this));
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
    if (paramCharSequence.length() < this.Dpo) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.Dpo)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.Dpl, i, j, 33);
      AppMethodBeat.o(37433);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void xv(boolean paramBoolean)
  {
    AppMethodBeat.i(37432);
    Context localContext = ai.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(37432);
      return;
    }
    if (paramBoolean)
    {
      this.Ipu.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 4));
      this.Ipv.setVisibility(0);
      AppMethodBeat.o(37432);
      return;
    }
    this.Ipu.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8));
    this.Ipv.setVisibility(8);
    AppMethodBeat.o(37432);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(37430);
    if (!bs.aj(paramCharSequence))
    {
      this.Ipu.setMinWidth(a.fromDPToPix(ai.getContext(), 80));
      this.Ipu.setMaxWidth(a.fromDPToPix(ai.getContext(), 259));
      this.Ipu.setVisibility(0);
      if (paramb == ChattingItemTranslate.b.IpF)
      {
        this.Dpi.clear();
        this.Ipu.ar(a(this.Dpi, paramCharSequence));
        this.Ipw.setVisibility(8);
        if (paramb != ChattingItemTranslate.b.IpG) {
          break label124;
        }
        xv(true);
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(37430);
      return;
      this.Ipu.ar(paramCharSequence);
      break;
      label124:
      xv(false);
      continue;
      if (paramb != ChattingItemTranslate.b.IpD)
      {
        this.Ipw.setVisibility(0);
        this.Ipu.setVisibility(8);
        xv(false);
      }
    }
  }
  
  public MMNeat7extView getContentView()
  {
    return this.Ipu;
  }
  
  public final void init()
  {
    AppMethodBeat.i(37429);
    this.Ipu = ((MMNeat7extView)findViewById(2131298203));
    this.Ipw = ((ProgressBar)findViewById(2131298204));
    this.Ipv = ((LinearLayout)findViewById(2131298201));
    this.Ipx = ((TextView)findViewById(2131298200));
    this.Ipu.setOnTouchListener(new g(this.Ipu, new n(this.Ipu.getContext())));
    AppMethodBeat.o(37429);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37434);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.Ipz)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(37434);
      return true;
    }
    if (j == 0) {
      this.Ipz = false;
    }
    if ((this.Ipy != null) && (this.IpA != null)) {}
    for (boolean bool1 = this.IpA.onTouchEvent(paramMotionEvent);; bool1 = false)
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
    this.Ipx.setText(paramString);
    AppMethodBeat.o(37431);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.Ipy = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */