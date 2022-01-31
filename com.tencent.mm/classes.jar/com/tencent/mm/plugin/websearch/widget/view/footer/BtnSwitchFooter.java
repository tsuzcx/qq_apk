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
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.ui.w;

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private Context context;
  private ImageView iWb;
  private c uMJ;
  private TextView uNq;
  private View uNr;
  private View uNs;
  private a.a uNt;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91561);
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    this.uMJ = locala.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91561);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91562);
    paramAttributeSet = new c.a();
    paramAttributeSet.eNM = true;
    paramAttributeSet.eNL = true;
    this.uMJ = paramAttributeSet.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91562);
  }
  
  private void init()
  {
    AppMethodBeat.i(91563);
    ViewGroup localViewGroup = (ViewGroup)w.hM(this.context).inflate(2130971326, this);
    this.uNs = localViewGroup.findViewById(2131829594);
    this.uNr = localViewGroup.findViewById(2131829595);
    this.uNq = ((TextView)localViewGroup.findViewById(2131829593));
    this.iWb = ((ImageView)localViewGroup.findViewById(2131829592));
    this.uNs.setVisibility(8);
    this.uNr.setOnClickListener(new BtnSwitchFooter.1(this));
    AppMethodBeat.o(91563);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(91568);
    this.uNt = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.uNr.setVisibility(0);
        AppMethodBeat.o(91568);
        return;
      }
      this.uNr.setVisibility(8);
    }
    AppMethodBeat.o(91568);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(91567);
    if (TextUtils.isEmpty(paramString))
    {
      this.iWb.setVisibility(8);
      AppMethodBeat.o(91567);
      return;
    }
    this.iWb.setVisibility(0);
    com.tencent.mm.at.a.a.ahM().a(paramString, this.iWb, this.uMJ);
    AppMethodBeat.o(91567);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(91564);
    this.uNr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(91564);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(91565);
    this.uNr.setVisibility(paramInt);
    AppMethodBeat.o(91565);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(91566);
    this.uNq.setText(paramString);
    AppMethodBeat.o(91566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */