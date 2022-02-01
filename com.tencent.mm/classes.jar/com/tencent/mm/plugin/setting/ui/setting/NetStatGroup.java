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
  LinearLayout yUk;
  final TextView yUl;
  
  public NetStatGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73893);
    View.inflate(paramContext, 2131495007, this);
    this.yUk = ((LinearLayout)findViewById(2131300621));
    this.yUl = ((TextView)findViewById(2131298928));
    this.yUl.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165466));
    AppMethodBeat.o(73893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatGroup
 * JD-Core Version:    0.7.0.1
 */