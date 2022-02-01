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
  private TextView AzH;
  private ImageView gBZ;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89807);
    bh(paramContext);
    AppMethodBeat.o(89807);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89806);
    bh(paramContext);
    AppMethodBeat.o(89806);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(89808);
    paramContext = View.inflate(paramContext, 2131495812, this);
    this.AzH = ((TextView)paramContext.findViewById(2131305255));
    this.AzH.setSingleLine(false);
    this.gBZ = ((ImageView)paramContext.findViewById(2131305237));
    this.AzH.setText(2131757608);
    this.gBZ.setImageResource(2131691325);
    AppMethodBeat.o(89808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */