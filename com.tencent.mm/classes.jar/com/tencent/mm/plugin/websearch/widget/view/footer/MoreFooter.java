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
import com.tencent.mm.ui.aa;

public class MoreFooter
  extends LinearLayout
{
  private Context context;
  private View gvQ;
  private TextView hbb;
  
  public MoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116759);
    this.context = paramContext;
    paramContext = (ViewGroup)aa.jQ(this.context).inflate(2131497099, this);
    this.hbb = ((TextView)paramContext.findViewById(2131309163));
    this.gvQ = paramContext.findViewById(2131307157);
    AppMethodBeat.o(116759);
  }
  
  public void setOnClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116761);
    this.gvQ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116761);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116760);
    this.hbb.setText(paramString);
    AppMethodBeat.o(116760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter
 * JD-Core Version:    0.7.0.1
 */