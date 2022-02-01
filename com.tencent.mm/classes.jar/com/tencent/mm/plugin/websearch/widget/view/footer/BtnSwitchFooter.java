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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.ui.y;

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private TextView AJY;
  private View AJZ;
  private c AJq;
  private View AKa;
  private a.a AKb;
  private Context context;
  private ImageView lKn;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116733);
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    this.AJq = locala.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116733);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116734);
    paramAttributeSet = new c.a();
    paramAttributeSet.hjU = true;
    paramAttributeSet.hjT = true;
    this.AJq = paramAttributeSet.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116734);
  }
  
  private void init()
  {
    AppMethodBeat.i(116735);
    ViewGroup localViewGroup = (ViewGroup)y.js(this.context).inflate(2131496109, this);
    this.AKa = localViewGroup.findViewById(2131300200);
    this.AJZ = localViewGroup.findViewById(2131300210);
    this.AJY = ((TextView)localViewGroup.findViewById(2131300214));
    this.lKn = ((ImageView)localViewGroup.findViewById(2131300201));
    this.AKa.setVisibility(8);
    this.AJZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116732);
        if (BtnSwitchFooter.a(BtnSwitchFooter.this) != null) {
          BtnSwitchFooter.a(BtnSwitchFooter.this).eiP();
        }
        AppMethodBeat.o(116732);
      }
    });
    AppMethodBeat.o(116735);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116740);
    this.AKb = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.AJZ.setVisibility(0);
        AppMethodBeat.o(116740);
        return;
      }
      this.AJZ.setVisibility(8);
    }
    AppMethodBeat.o(116740);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116739);
    if (TextUtils.isEmpty(paramString))
    {
      this.lKn.setVisibility(8);
      AppMethodBeat.o(116739);
      return;
    }
    this.lKn.setVisibility(0);
    com.tencent.mm.aw.a.a.ayO().a(paramString, this.lKn, this.AJq);
    AppMethodBeat.o(116739);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116736);
    this.AJZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116736);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(116737);
    this.AJZ.setVisibility(paramInt);
    AppMethodBeat.o(116737);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116738);
    this.AJY.setText(paramString);
    AppMethodBeat.o(116738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */