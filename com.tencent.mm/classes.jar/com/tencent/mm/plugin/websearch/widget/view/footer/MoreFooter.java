package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.ui.y;

public class MoreFooter
  extends LinearLayout
{
  private Context context;
  private TextView fcy;
  private View khn;
  
  public MoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    paramContext = (ViewGroup)y.gt(this.context).inflate(a.b.widget_footer_more, this);
    this.fcy = ((TextView)paramContext.findViewById(a.a.tip_tv));
    this.khn = paramContext.findViewById(a.a.root);
  }
  
  public void setOnClickLsn(View.OnClickListener paramOnClickListener)
  {
    this.khn.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString)
  {
    this.fcy.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter
 * JD-Core Version:    0.7.0.1
 */