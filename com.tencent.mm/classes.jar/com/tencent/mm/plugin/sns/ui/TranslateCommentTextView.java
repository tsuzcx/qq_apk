package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;

public class TranslateCommentTextView
  extends LinearLayout
{
  public MaskTextView RGj;
  public SnsTranslateResultView Rqk;
  
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
    LayoutInflater.from(getContext()).inflate(b.g.timeline_comment_translate_item_layout, this);
    this.RGj = ((MaskTextView)findViewById(b.f.comment_textview));
    this.Rqk = ((SnsTranslateResultView)findViewById(b.f.sns_translate_result_view));
    this.Rqk.setVisibility(8);
    AppMethodBeat.o(99780);
  }
  
  public TextView getOriginCommentTextView()
  {
    return this.RGj;
  }
  
  public SnsTranslateResultView getTranslateResultView()
  {
    return this.Rqk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TranslateCommentTextView
 * JD-Core Version:    0.7.0.1
 */