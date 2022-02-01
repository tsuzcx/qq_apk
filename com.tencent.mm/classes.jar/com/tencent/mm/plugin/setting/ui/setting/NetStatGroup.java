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
  LinearLayout CZd;
  final TextView CZe;
  
  public NetStatGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73893);
    View.inflate(paramContext, 2131495837, this);
    this.CZd = ((LinearLayout)findViewById(2131302176));
    this.CZe = ((TextView)findViewById(2131299412));
    this.CZe.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165482));
    AppMethodBeat.o(73893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatGroup
 * JD-Core Version:    0.7.0.1
 */