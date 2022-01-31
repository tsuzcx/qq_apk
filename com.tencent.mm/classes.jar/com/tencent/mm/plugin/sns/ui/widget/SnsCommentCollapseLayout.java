package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class SnsCommentCollapseLayout
  extends RelativeLayout
{
  private SnsComment2LinePreloadTextView smY;
  private SnsCommentPreloadTextView smZ;
  private TextView sna;
  private CharSequence snb;
  private int snc;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(40481);
    this.smY = null;
    this.smZ = null;
    this.sna = null;
    this.snb = null;
    this.snc = 0;
    init();
    AppMethodBeat.o(40481);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40482);
    this.smY = null;
    this.smZ = null;
    this.sna = null;
    this.snb = null;
    this.snc = 0;
    init();
    AppMethodBeat.o(40482);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40483);
    this.smY = null;
    this.smZ = null;
    this.sna = null;
    this.snb = null;
    this.snc = 0;
    init();
    AppMethodBeat.o(40483);
  }
  
  private void init()
  {
    AppMethodBeat.i(40484);
    LayoutInflater.from(getContext()).inflate(2130970815, this, true);
    this.smY = ((SnsComment2LinePreloadTextView)findViewById(2131827928));
    this.smZ = ((SnsCommentPreloadTextView)findViewById(2131827929));
    this.sna = ((TextView)findViewById(2131827930));
    this.snc = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new SnsCommentCollapseLayout.1(this));
    AppMethodBeat.o(40484);
  }
  
  public final void k(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(40491);
    post(new SnsCommentCollapseLayout.2(this, paramCharSequence, paramInt));
    AppMethodBeat.o(40491);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(40490);
    this.smY.setGravity(paramInt);
    this.smZ.setGravity(paramInt);
    AppMethodBeat.o(40490);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(40485);
    this.sna.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(40485);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(40486);
    this.smY.setOnTouchListener(paramOnTouchListener);
    this.smZ.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(40486);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(40489);
    this.smY.setTextColor(paramInt);
    this.smZ.setTextColor(paramInt);
    AppMethodBeat.o(40489);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(40487);
    this.smY.setTextSize(paramFloat);
    this.smZ.setTextSize(paramFloat);
    AppMethodBeat.o(40487);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(40488);
    this.smY.setTextSize$255e752(paramFloat);
    this.smZ.setTextSize$255e752(paramFloat);
    this.sna.setTextSize(1, paramFloat);
    AppMethodBeat.o(40488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */