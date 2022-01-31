package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClassifyHeader
  extends LinearLayout
{
  private TextView hsI;
  private Context mContext;
  private ImageView oyP;
  
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38195);
    init(paramContext);
    AppMethodBeat.o(38195);
  }
  
  @TargetApi(11)
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38194);
    init(paramContext);
    AppMethodBeat.o(38194);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38196);
    this.mContext = paramContext;
    paramContext = View.inflate(this.mContext, 2130969156, this);
    this.oyP = ((ImageView)paramContext.findViewById(2131822825));
    this.hsI = ((TextView)paramContext.findViewById(2131822826));
    AppMethodBeat.o(38196);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(38197);
    this.hsI.setText(String.valueOf(paramString));
    AppMethodBeat.o(38197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ClassifyHeader
 * JD-Core Version:    0.7.0.1
 */