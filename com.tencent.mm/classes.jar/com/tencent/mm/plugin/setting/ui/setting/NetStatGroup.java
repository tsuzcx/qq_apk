package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetStatGroup
  extends LinearLayout
{
  LinearLayout qFU;
  final TextView qFV;
  
  public NetStatGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126965);
    View.inflate(paramContext, 2130970350, this);
    this.qFU = ((LinearLayout)findViewById(2131826210));
    this.qFV = ((TextView)findViewById(2131820789));
    this.qFV.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131427758));
    AppMethodBeat.o(126965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatGroup
 * JD-Core Version:    0.7.0.1
 */