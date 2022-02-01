package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;

public class NetStatGroup
  extends LinearLayout
{
  LinearLayout JeK;
  final TextView JeL;
  
  public NetStatGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73893);
    View.inflate(paramContext, b.g.netstat_group, this);
    this.JeK = ((LinearLayout)findViewById(b.f.group));
    this.JeL = ((TextView)findViewById(b.f.date));
    this.JeL.setTextSize(0, paramContext.getResources().getDimensionPixelSize(b.d.HintTextSize));
    AppMethodBeat.o(73893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatGroup
 * JD-Core Version:    0.7.0.1
 */