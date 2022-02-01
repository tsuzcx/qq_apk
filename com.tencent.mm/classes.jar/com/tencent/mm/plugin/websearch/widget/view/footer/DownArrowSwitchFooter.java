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

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private c CbH;
  private TextView Ccp;
  private View Ccq;
  private a.a Ccs;
  private Context context;
  private ImageView mmk;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116752);
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    this.CbH = locala.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116752);
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116753);
    paramAttributeSet = new c.a();
    paramAttributeSet.hKx = true;
    paramAttributeSet.hKw = true;
    this.CbH = paramAttributeSet.aFT();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116753);
  }
  
  private void init()
  {
    AppMethodBeat.i(116754);
    ViewGroup localViewGroup = (ViewGroup)z.jD(this.context).inflate(2131496111, this);
    this.Ccq = localViewGroup.findViewById(2131299188);
    this.Ccp = ((TextView)localViewGroup.findViewById(2131300214));
    this.mmk = ((ImageView)localViewGroup.findViewById(2131300201));
    localViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116751);
        if (DownArrowSwitchFooter.a(DownArrowSwitchFooter.this) != null) {
          DownArrowSwitchFooter.a(DownArrowSwitchFooter.this).eyj();
        }
        AppMethodBeat.o(116751);
      }
    });
    AppMethodBeat.o(116754);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116757);
    this.Ccs = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.Ccq.setVisibility(0);
        AppMethodBeat.o(116757);
        return;
      }
      this.Ccq.setVisibility(8);
    }
    AppMethodBeat.o(116757);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116756);
    if (TextUtils.isEmpty(paramString))
    {
      this.mmk.setVisibility(8);
      AppMethodBeat.o(116756);
      return;
    }
    this.mmk.setVisibility(0);
    com.tencent.mm.av.a.a.aFG().a(paramString, this.mmk, this.CbH);
    AppMethodBeat.o(116756);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116755);
    this.Ccp.setText(paramString);
    AppMethodBeat.o(116755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */