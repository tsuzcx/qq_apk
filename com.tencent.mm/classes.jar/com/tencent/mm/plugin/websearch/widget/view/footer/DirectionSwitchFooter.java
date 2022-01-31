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

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private Context context;
  private c qXu;
  private ImageView qYc;
  private TextView qYd;
  private a.a qYg;
  private View qYi;
  private View qYj;
  private View qYk;
  private View qYl;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    c.a locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    this.qXu = locala.OV();
    this.context = paramContext;
    init();
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
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
    ViewGroup localViewGroup = (ViewGroup)y.gt(this.context).inflate(a.b.widget_footer_switch_direction, this);
    this.qYd = ((TextView)localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.footer_title));
    this.qYc = ((ImageView)localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.footer_icon));
    this.qYi = localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.left_arrow);
    this.qYj = localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.right_arrow);
    this.qYk = localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.left_arrow_container);
    this.qYl = localViewGroup.findViewById(com.tencent.mm.plugin.websearch.a.a.right_arrow_container);
    this.qYk.setOnClickListener(new DirectionSwitchFooter.1(this));
    this.qYl.setOnClickListener(new DirectionSwitchFooter.2(this));
  }
  
  public void setCallback(a.a parama)
  {
    this.qYg = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.qYk.setVisibility(8);
        this.qYl.setVisibility(8);
      }
      if (this.qYg != null)
      {
        if (this.qYg.hasNext()) {
          break label101;
        }
        this.qYl.setEnabled(false);
        this.qYj.setEnabled(false);
      }
    }
    while (!this.qYg.hasPrevious())
    {
      this.qYi.setEnabled(false);
      this.qYk.setEnabled(false);
      return;
      label101:
      this.qYj.setEnabled(true);
      this.qYl.setEnabled(true);
    }
    this.qYk.setEnabled(true);
    this.qYi.setEnabled(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */