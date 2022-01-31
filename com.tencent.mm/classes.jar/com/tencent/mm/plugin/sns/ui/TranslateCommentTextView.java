package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView
  extends LinearLayout
{
  public SnsTranslateResultView oXv;
  public MaskTextView pkz;
  
  public TranslateCommentTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TranslateCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(i.g.timeline_comment_translate_item_layout, this);
    this.pkz = ((MaskTextView)findViewById(i.f.comment_textview));
    this.oXv = ((SnsTranslateResultView)findViewById(i.f.sns_translate_result_view));
    this.oXv.setVisibility(8);
  }
  
  public TextView getOriginCommentTextView()
  {
    return this.pkz;
  }
  
  public SnsTranslateResultView getTranslateResultView()
  {
    return this.oXv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TranslateCommentTextView
 * JD-Core Version:    0.7.0.1
 */