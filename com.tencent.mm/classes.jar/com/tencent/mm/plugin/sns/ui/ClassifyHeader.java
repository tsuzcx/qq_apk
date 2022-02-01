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
  private TextView gUs;
  private Context mContext;
  private ImageView vEq;
  
  public ClassifyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97830);
    init(paramContext);
    AppMethodBeat.o(97830);
  }
  
  @TargetApi(11)
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
    paramContext = View.inflate(this.mContext, 2131493538, this);
    this.vEq = ((ImageView)paramContext.findViewById(2131301385));
    this.gUs = ((TextView)paramContext.findViewById(2131300715));
    AppMethodBeat.o(97831);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(97832);
    this.gUs.setText(String.valueOf(paramString));
    AppMethodBeat.o(97832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ClassifyHeader
 * JD-Core Version:    0.7.0.1
 */