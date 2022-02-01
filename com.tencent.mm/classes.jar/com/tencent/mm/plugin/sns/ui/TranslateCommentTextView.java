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
  public SnsTranslateResultView yKP;
  public MaskTextView yYV;
  
  public TranslateCommentTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(99778);
    init();
    AppMethodBeat.o(99778);
  }
  
  public TranslateCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99779);
    init();
    AppMethodBeat.o(99779);
  }
  
  private void init()
  {
    AppMethodBeat.i(99780);
    LayoutInflater.from(getContext()).inflate(2131495754, this);
    this.yYV = ((MaskTextView)findViewById(2131298538));
    this.yKP = ((SnsTranslateResultView)findViewById(2131305091));
    this.yKP.setVisibility(8);
    AppMethodBeat.o(99780);
  }
  
  public TextView getOriginCommentTextView()
  {
    return this.yYV;
  }
  
  public SnsTranslateResultView getTranslateResultView()
  {
    return this.yKP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TranslateCommentTextView
 * JD-Core Version:    0.7.0.1
 */