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
import com.tencent.mm.R.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class ChattingItemTranslate
  extends RelativeLayout
{
  private SpannableStringBuilder sbg = new SpannableStringBuilder();
  private CharacterStyle sbj = new ForegroundColorSpan(-5066062);
  private int sbm = 3;
  private MMNeatTextView vFS;
  private LinearLayout vFT;
  private ProgressBar vFU;
  private TextView vFV;
  private NeatTextView.b vFW;
  private boolean vFX;
  private GestureDetector vFY = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
    {
      if (ChattingItemTranslate.a(ChattingItemTranslate.this) == null) {
        return false;
      }
      return ChattingItemTranslate.a(ChattingItemTranslate.this).eb(ChattingItemTranslate.b(ChattingItemTranslate.this));
    }
  });
  
  public ChattingItemTranslate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void nu(boolean paramBoolean)
  {
    Context localContext = ae.getContext();
    if (localContext == null) {
      return;
    }
    if (paramBoolean)
    {
      this.vFS.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 4));
      this.vFT.setVisibility(0);
      return;
    }
    this.vFS.setPadding(a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8), a.fromDPToPix(localContext, 10), a.fromDPToPix(localContext, 8));
    this.vFT.setVisibility(8);
  }
  
  public final void a(CharSequence paramCharSequence, ChattingItemTranslate.b paramb)
  {
    SpannableStringBuilder localSpannableStringBuilder;
    if (!bk.L(paramCharSequence))
    {
      this.vFS.setMinWidth(a.fromDPToPix(ae.getContext(), 80));
      this.vFS.setMaxWidth(a.fromDPToPix(ae.getContext(), 259));
      this.vFS.setVisibility(0);
      if (paramb == ChattingItemTranslate.b.vGc)
      {
        this.sbg.clear();
        MMNeatTextView localMMNeatTextView = this.vFS;
        localSpannableStringBuilder = this.sbg;
        if ((localSpannableStringBuilder == null) || (paramCharSequence == null) || (paramCharSequence.length() == 0))
        {
          localMMNeatTextView.R(localSpannableStringBuilder);
          label97:
          this.vFU.setVisibility(8);
          if (paramb != ChattingItemTranslate.b.vGd) {
            break label197;
          }
          nu(true);
        }
      }
    }
    for (;;)
    {
      setVisibility(0);
      return;
      int i;
      if (paramCharSequence.length() < this.sbm) {
        i = paramCharSequence.length();
      }
      for (int j = 0;; j = i - this.sbm)
      {
        localSpannableStringBuilder.append(paramCharSequence).setSpan(this.sbj, j, i, 33);
        break;
        i = paramCharSequence.length();
      }
      this.vFS.R(paramCharSequence);
      break label97;
      label197:
      nu(false);
      continue;
      if (paramb != ChattingItemTranslate.b.vGa)
      {
        this.vFU.setVisibility(0);
        this.vFS.setVisibility(8);
        nu(false);
      }
    }
  }
  
  public final void init()
  {
    this.vFS = ((MMNeatTextView)findViewById(R.h.chatting_voice_play_transform_text));
    this.vFU = ((ProgressBar)findViewById(R.h.chatting_voice_play_transform_textload));
    this.vFT = ((LinearLayout)findViewById(R.h.chatting_voice_play_transform_finish_icon_layout));
    this.vFV = ((TextView)findViewById(R.h.chatting_voice_play_transform_finish_icon));
    this.vFS.setOnTouchListener(new f(this.vFS, new m(this.vFS.getContext())));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.vFX)) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
      return bool2;
    }
    if (j == 0) {
      this.vFX = false;
    }
    if ((this.vFW != null) && (this.vFY != null)) {}
    for (boolean bool1 = this.vFY.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void setBrandWording(String paramString)
  {
    this.vFV.setText(paramString);
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.vFW = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate
 * JD-Core Version:    0.7.0.1
 */