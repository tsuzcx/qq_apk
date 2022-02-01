package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.plugin.nearby.b.g;

public class CleanLocationHeaderView
  extends LinearLayout
{
  private TextView MoK;
  private ImageView lPb;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89807);
    ci(paramContext);
    AppMethodBeat.o(89807);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89806);
    ci(paramContext);
    AppMethodBeat.o(89806);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(89808);
    paramContext = View.inflate(paramContext, b.d.Moe, this);
    this.MoK = ((TextView)paramContext.findViewById(b.c.Mod));
    this.MoK.setSingleLine(false);
    this.lPb = ((ImageView)paramContext.findViewById(b.c.Mob));
    this.MoK.setText(b.g.Moj);
    this.lPb.setImageResource(b.f.peoplenearby_icon);
    AppMethodBeat.o(89808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */