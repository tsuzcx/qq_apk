package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;

public class ClassifyHeader
  extends LinearLayout
{
  private ImageView KKl;
  private TextView descTv;
  private Context mContext;
  
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97830);
    init(paramContext);
    AppMethodBeat.o(97830);
  }
  
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97829);
    init(paramContext);
    AppMethodBeat.o(97829);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97831);
    this.mContext = paramContext;
    paramContext = View.inflate(this.mContext, b.g.classify_header, this);
    this.KKl = ((ImageView)paramContext.findViewById(b.f.left_iv));
    this.descTv = ((TextView)paramContext.findViewById(b.f.header_desc));
    AppMethodBeat.o(97831);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(97832);
    this.descTv.setText(String.valueOf(paramString));
    AppMethodBeat.o(97832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ClassifyHeader
 * JD-Core Version:    0.7.0.1
 */