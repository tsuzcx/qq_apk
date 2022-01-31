package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TranslateCommentTextView
  extends LinearLayout
{
  public SnsTranslateResultView rPT;
  public MaskTextView sdc;
  
  public TranslateCommentTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(39904);
    init();
    AppMethodBeat.o(39904);
  }
  
  public TranslateCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39905);
    init();
    AppMethodBeat.o(39905);
  }
  
  private void init()
  {
    AppMethodBeat.i(39906);
    LayoutInflater.from(getContext()).inflate(2130970995, this);
    this.sdc = ((MaskTextView)findViewById(2131828492));
    this.rPT = ((SnsTranslateResultView)findViewById(2131827943));
    this.rPT.setVisibility(8);
    AppMethodBeat.o(39906);
  }
  
  public TextView getOriginCommentTextView()
  {
    return this.sdc;
  }
  
  public SnsTranslateResultView getTranslateResultView()
  {
    return this.rPT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TranslateCommentTextView
 * JD-Core Version:    0.7.0.1
 */