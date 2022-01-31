package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.ui.w;

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private Context context;
  private ImageView iWb;
  private c uMJ;
  private TextView uNq;
  private View uNr;
  private a.a uNt;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91578);
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    this.uMJ = locala.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91578);
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91579);
    paramAttributeSet = new c.a();
    paramAttributeSet.eNM = true;
    paramAttributeSet.eNL = true;
    this.uMJ = paramAttributeSet.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91579);
  }
  
  private void init()
  {
    AppMethodBeat.i(91580);
    ViewGroup localViewGroup = (ViewGroup)w.hM(this.context).inflate(2130971328, this);
    this.uNr = localViewGroup.findViewById(2131829599);
    this.uNq = ((TextView)localViewGroup.findViewById(2131829593));
    this.iWb = ((ImageView)localViewGroup.findViewById(2131829592));
    localViewGroup.setOnClickListener(new DownArrowSwitchFooter.1(this));
    AppMethodBeat.o(91580);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(91583);
    this.uNt = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.uNr.setVisibility(0);
        AppMethodBeat.o(91583);
        return;
      }
      this.uNr.setVisibility(8);
    }
    AppMethodBeat.o(91583);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(91582);
    if (TextUtils.isEmpty(paramString))
    {
      this.iWb.setVisibility(8);
      AppMethodBeat.o(91582);
      return;
    }
    this.iWb.setVisibility(0);
    com.tencent.mm.at.a.a.ahM().a(paramString, this.iWb, this.uMJ);
    AppMethodBeat.o(91582);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(91581);
    this.uNq.setText(paramString);
    AppMethodBeat.o(91581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */