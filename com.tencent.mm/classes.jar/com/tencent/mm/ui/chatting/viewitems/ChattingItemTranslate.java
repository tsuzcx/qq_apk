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
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder vSn;
  private CharacterStyle vSq;
  private int vSt;
  private MMNeat7extView zXm;
  private LinearLayout zXn;
  private ProgressBar zXo;
  private TextView zXp;
  private NeatTextView.b zXq;
  private boolean zXr;
  private GestureDetector zXs;
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33327);
    this.vSn = new SpannableStringBuilder();
    this.vSt = 3;
    this.vSq = new ForegroundColorSpan(-5066062);
    this.zXs = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(33323);
        if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null)
        {
          AppMethodBeat.o(33323);
          return false;
        }
        boolean bool = ChattingItemTranslate.a(ChattingItemTranslate.this).fp(ChattingItemTranslate.b(ChattingItemTranslate.this));
        AppMethodBeat.o(33323);
        return bool;
      }
    });
    AppMethodBeat.o(33327);
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33332);
    if ((paramSpannableStringBuilder == null) || (paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      AppMethodBeat.o(33332);
      return paramSpannableStringBuilder;
    }
    int j;
    if (paramCharSequence.length() < this.vSt) {
      j = paramCharSequence.length();
    }
    for (int i = 0;; i = j - this.vSt)
    {
      paramSpannableStringBuilder.append(paramCharSequence).setSpan(this.vSq, i, j, 33);
      AppMethodBeat.o(33332);
      return paramSpannableStringBuilder;
      j = paramCharSequence.length();
    }
  }
  
  private void rd(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    Context localContext = ah.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(33331);
      return;
    }
    if (paramBoolean)
    {
      this.zXm.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 4));
      this.zXn.setVisibility(0);
      AppMethodBeat.o(33331);
      return;
    }
    this.zXm.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8));
    this.zXn.setVisibility(8);
    AppMethodBeat.o(33331);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(33329);
    if (!bo.aa(paramCharSequence))
    {
      this.zXm.setMinWidth(a.fromDPToPix(ah.getContext(), 80));
      this.zXm.setMaxWidth(a.fromDPToPix(ah.getContext(), 259));
      this.zXm.setVisibility(0);
      if (paramb == ChattingItemTranslate.b.zXw)
      {
        this.vSn.clear();
        this.zXm.af(a(this.vSn, paramCharSequence));
        this.zXo.setVisibility(8);
        if (paramb != ChattingItemTranslate.b.zXx) {
          break label124;
        }
        rd(true);
      }
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(33329);
      return;
      this.zXm.af(paramCharSequence);
      break;
      label124:
      rd(false);
      continue;
      if (paramb != ChattingItemTranslate.b.zXu)
      {
        this.zXo.setVisibility(0);
        this.zXm.setVisibility(8);
        rd(false);
      }
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(33328);
    this.zXm = ((MMNeat7extView)findViewById(2131822745));
    this.zXo = ((ProgressBar)findViewById(2131822744));
    this.zXn = ((LinearLayout)findViewById(2131822746));
    this.zXp = ((TextView)findViewById(2131822748));
    this.zXm.setOnTouchListener(new f(this.zXm, new m(this.zXm.getContext())));
    AppMethodBeat.o(33328);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33333);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.zXr)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      AppMethodBeat.o(33333);
      return true;
    }
    if (j == 0) {
      this.zXr = false;
    }
    if ((this.zXq != null) && (this.zXs != null)) {}
    for (boolean bool1 = this.zXs.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(33333);
      return bool2;
    }
  }
  
  public void setBrandWording(String paramString)
  {
    AppMethodBeat.i(33330);
    this.zXp.setText(paramString);
    AppMethodBeat.o(33330);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.zXq = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */