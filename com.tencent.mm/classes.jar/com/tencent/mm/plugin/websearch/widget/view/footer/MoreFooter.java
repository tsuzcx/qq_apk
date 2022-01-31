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
import com.tencent.mm.ui.w;

public class MoreFooter
  extends LinearLayout
{
  private Context context;
  private TextView gui;
  private View kgr;
  
  public MoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91584);
    this.context = paramContext;
    paramContext = (ViewGroup)w.hM(this.context).inflate(2130971325, this);
    this.gui = ((TextView)paramContext.findViewById(2131821071));
    this.kgr = paramContext.findViewById(2131821003);
    AppMethodBeat.o(91584);
  }
  
  public void setOnClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(91586);
    this.kgr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(91586);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(91585);
    this.gui.setText(paramString);
    AppMethodBeat.o(91585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter
 * JD-Core Version:    0.7.0.1
 */