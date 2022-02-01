package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView
  extends LinearLayout
{
  public SnsTranslateResultView KQw;
  public MaskTextView LfZ;
  
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
    LayoutInflater.from(getContext()).inflate(i.g.timeline_comment_translate_item_layout, this);
    this.LfZ = ((MaskTextView)findViewById(i.f.comment_textview));
    this.KQw = ((SnsTranslateResultView)findViewById(i.f.sns_translate_result_view));
    this.KQw.setVisibility(8);
    AppMethodBeat.o(99780);
  }
  
  public TextView getOriginCommentTextView()
  {
    return this.LfZ;
  }
  
  public SnsTranslateResultView getTranslateResultView()
  {
    return this.KQw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TranslateCommentTextView
 * JD-Core Version:    0.7.0.1
 */