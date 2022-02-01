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
  private TextView GsK;
  private ImageView jmf;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89807);
    bv(paramContext);
    AppMethodBeat.o(89807);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89806);
    bv(paramContext);
    AppMethodBeat.o(89806);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(89808);
    paramContext = View.inflate(paramContext, b.d.nearby_bindmobile_header_view, this);
    this.GsK = ((TextView)paramContext.findViewById(b.c.nearby_header_text));
    this.GsK.setSingleLine(false);
    this.jmf = ((ImageView)paramContext.findViewById(b.c.nearby_bind_icon));
    this.GsK.setText(b.g.clean_loaction_header_title);
    this.jmf.setImageResource(b.f.peoplenearby_icon);
    AppMethodBeat.o(89808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */