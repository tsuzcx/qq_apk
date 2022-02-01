package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.ui.z;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private c CbH;
  private TextView Ccp;
  private a.a Ccs;
  private View Ccu;
  private View Ccv;
  private View Ccw;
  private View Ccx;
  private Context context;
  private ImageView mmk;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    this.CbH = locala.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.hKx = true;
    paramAttributeSet.hKw = true;
    this.CbH = paramAttributeSet.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)z.jD(this.context).inflate(2131496110, this);
    this.Ccp = ((TextView)localViewGroup.findViewById(2131300214));
    this.mmk = ((ImageView)localViewGroup.findViewById(2131300201));
    this.Ccu = localViewGroup.findViewById(2131301380);
    this.Ccv = localViewGroup.findViewById(2131304172);
    this.Ccw = localViewGroup.findViewById(2131301381);
    this.Ccx = localViewGroup.findViewById(2131304173);
    this.Ccw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eyl();
        }
        AppMethodBeat.o(116742);
      }
    });
    this.Ccx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eyk();
        }
        AppMethodBeat.o(116743);
      }
    });
    AppMethodBeat.o(116746);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116749);
    this.Ccs = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.Ccw.setVisibility(8);
        this.Ccx.setVisibility(8);
      }
      if (this.Ccs != null)
      {
        if (!this.Ccs.hasNext())
        {
          this.Ccx.setEnabled(false);
          this.Ccv.setEnabled(false);
        }
        while (!this.Ccs.hasPrevious())
        {
          this.Ccu.setEnabled(false);
          this.Ccw.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.Ccv.setEnabled(true);
          this.Ccx.setEnabled(true);
        }
        this.Ccw.setEnabled(true);
        this.Ccu.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.mmk.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.mmk.setVisibility(0);
    com.tencent.mm.av.a.a.aFG().a(paramString, this.mmk, this.CbH);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.Ccp.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */