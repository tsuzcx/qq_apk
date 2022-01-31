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
  private ImageView iQd;
  private TextView pcA;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(55409);
    aA(paramContext);
    AppMethodBeat.o(55409);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55408);
    aA(paramContext);
    AppMethodBeat.o(55408);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(55410);
    paramContext = View.inflate(paramContext, 2130970342, this);
    this.pcA = ((TextView)paramContext.findViewById(2131826487));
    this.pcA.setSingleLine(false);
    this.iQd = ((ImageView)paramContext.findViewById(2131826486));
    this.pcA.setText(2131298381);
    this.iQd.setImageResource(2131231857);
    AppMethodBeat.o(55410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */