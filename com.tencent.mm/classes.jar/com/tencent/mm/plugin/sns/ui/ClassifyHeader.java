package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class ClassifyHeader
  extends LinearLayout
{
  private TextView gaI;
  private ImageView lZh;
  private Context mContext;
  
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = View.inflate(this.mContext, i.g.classify_header, this);
    this.lZh = ((ImageView)paramContext.findViewById(i.f.left_iv));
    this.gaI = ((TextView)paramContext.findViewById(i.f.header_desc));
  }
  
  public void setDesc(String paramString)
  {
    this.gaI.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ClassifyHeader
 * JD-Core Version:    0.7.0.1
 */