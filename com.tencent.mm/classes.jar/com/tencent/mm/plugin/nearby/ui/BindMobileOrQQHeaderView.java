package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class BindMobileOrQQHeaderView
  extends LinearLayout
{
  private TextView GsK;
  private a GsL;
  private View.OnClickListener GsM;
  private WeImageView xQM;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89803);
    this.GsM = new BindMobileOrQQHeaderView.1(this);
    this.GsL = a.GsP;
    bv(paramContext);
    AppMethodBeat.o(89803);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89802);
    this.GsM = new BindMobileOrQQHeaderView.1(this);
    bv(paramContext);
    AppMethodBeat.o(89802);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(89804);
    paramContext = View.inflate(paramContext, b.d.nearby_bindmobile_header_view, this);
    this.GsK = ((TextView)paramContext.findViewById(b.c.nearby_header_text));
    this.xQM = ((WeImageView)paramContext.findViewById(b.c.nearby_bind_icon));
    switch (2.GsO[this.GsL.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.GsM);
      this.xQM.setImageResource(b.f.icons_outlined_cellphone);
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.GsM);
      this.xQM.setImageResource(b.f.icons_outlined_contacts);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89801);
      GsP = new a("Mobile", 0);
      GsQ = new a("UploadContact", 1);
      GsR = new a[] { GsP, GsQ };
      AppMethodBeat.o(89801);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */