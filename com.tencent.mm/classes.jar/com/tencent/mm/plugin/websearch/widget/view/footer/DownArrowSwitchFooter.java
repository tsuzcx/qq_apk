package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.ui.y;

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private Context context;
  private c qXu;
  private ImageView qYc;
  private TextView qYd;
  private View qYe;
  private a.a qYg;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    c.a locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    this.qXu = locala.OV();
    this.context = paramContext;
    init();
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = new c.a();
    paramAttributeSet.erf = true;
    paramAttributeSet.ere = true;
    this.qXu = paramAttributeSet.OV();
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    ViewGroup localViewGroup = (ViewGroup)y.gt(this.context).inflate(a.b.widget_footer_switch_downarrow, this);
    this.qYe = localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.down_arrow);
    this.qYd = ((TextView)localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.footer_title));
    this.qYc = ((ImageView)localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.footer_icon));
    localViewGroup.setOnClickListener(new DownArrowSwitchFooter.1(this));
  }
  
  public void setCallback(a.a parama)
  {
    this.qYg = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1) {
        this.qYe.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.qYe.setVisibility(8);
  }
  
  public void setIcon(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.qYc.setVisibility(8);
      return;
    }
    this.qYc.setVisibility(0);
    com.tencent.mm.as.a.a.OT().a(paramString, this.qYc, this.qXu);
  }
  
  public void setTitle(String paramString)
  {
    this.qYd.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */