package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CleanLocationHeaderView
  extends LinearLayout
{
  private ImageView fWT;
  private TextView wEa;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89807);
    aN(paramContext);
    AppMethodBeat.o(89807);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89806);
    aN(paramContext);
    AppMethodBeat.o(89806);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(89808);
    paramContext = View.inflate(paramContext, 2131494999, this);
    this.wEa = ((TextView)paramContext.findViewById(2131302701));
    this.wEa.setSingleLine(false);
    this.fWT = ((ImageView)paramContext.findViewById(2131302683));
    this.wEa.setText(2131757391);
    this.fWT.setImageResource(2131691025);
    AppMethodBeat.o(89808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */