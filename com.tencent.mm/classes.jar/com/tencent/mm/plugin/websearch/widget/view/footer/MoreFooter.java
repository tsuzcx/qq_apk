package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.ui.ad;

public class MoreFooter
  extends LinearLayout
{
  private Context context;
  private TextView jMg;
  private View jac;
  
  public MoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116759);
    this.context = paramContext;
    paramContext = (ViewGroup)ad.kS(this.context).inflate(a.e.widget_footer_more, this);
    this.jMg = ((TextView)paramContext.findViewById(a.d.tip_tv));
    this.jac = paramContext.findViewById(a.d.root);
    AppMethodBeat.o(116759);
  }
  
  public void setOnClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116761);
    this.jac.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116761);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116760);
    this.jMg.setText(paramString);
    AppMethodBeat.o(116760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter
 * JD-Core Version:    0.7.0.1
 */