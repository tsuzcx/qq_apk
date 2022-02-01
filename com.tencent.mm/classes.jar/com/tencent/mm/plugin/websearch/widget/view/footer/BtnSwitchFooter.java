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

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private c CbH;
  private TextView Ccp;
  private View Ccq;
  private View Ccr;
  private a.a Ccs;
  private Context context;
  private ImageView mmk;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116733);
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    this.CbH = locala.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116733);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116734);
    paramAttributeSet = new c.a();
    paramAttributeSet.hKx = true;
    paramAttributeSet.hKw = true;
    this.CbH = paramAttributeSet.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116734);
  }
  
  private void init()
  {
    AppMethodBeat.i(116735);
    ViewGroup localViewGroup = (ViewGroup)z.jD(this.context).inflate(2131496109, this);
    this.Ccr = localViewGroup.findViewById(2131300200);
    this.Ccq = localViewGroup.findViewById(2131300210);
    this.Ccp = ((TextView)localViewGroup.findViewById(2131300214));
    this.mmk = ((ImageView)localViewGroup.findViewById(2131300201));
    this.Ccr.setVisibility(8);
    this.Ccq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116732);
        if (BtnSwitchFooter.a(BtnSwitchFooter.this) != null) {
          BtnSwitchFooter.a(BtnSwitchFooter.this).eyj();
        }
        AppMethodBeat.o(116732);
      }
    });
    AppMethodBeat.o(116735);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116740);
    this.Ccs = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.Ccq.setVisibility(0);
        AppMethodBeat.o(116740);
        return;
      }
      this.Ccq.setVisibility(8);
    }
    AppMethodBeat.o(116740);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116739);
    if (TextUtils.isEmpty(paramString))
    {
      this.mmk.setVisibility(8);
      AppMethodBeat.o(116739);
      return;
    }
    this.mmk.setVisibility(0);
    com.tencent.mm.av.a.a.aFG().a(paramString, this.mmk, this.CbH);
    AppMethodBeat.o(116739);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116736);
    this.Ccq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116736);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(116737);
    this.Ccq.setVisibility(paramInt);
    AppMethodBeat.o(116737);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116738);
    this.Ccp.setText(paramString);
    AppMethodBeat.o(116738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */