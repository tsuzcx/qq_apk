package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;

public class NetStatGroup
  extends LinearLayout
{
  LinearLayout nRW;
  final TextView nRX;
  
  public NetStatGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    View.inflate(paramContext, a.g.netstat_group, this);
    this.nRW = ((LinearLayout)findViewById(a.f.group));
    this.nRX = ((TextView)findViewById(a.f.date));
    this.nRX.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.HintTextSize));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatGroup
 * JD-Core Version:    0.7.0.1
 */