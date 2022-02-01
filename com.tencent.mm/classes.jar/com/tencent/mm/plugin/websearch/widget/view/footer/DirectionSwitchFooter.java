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

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private TextView AJY;
  private c AJq;
  private a.a AKb;
  private View AKd;
  private View AKe;
  private View AKf;
  private View AKg;
  private Context context;
  private ImageView lKn;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    this.AJq = locala.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.hjU = true;
    paramAttributeSet.hjT = true;
    this.AJq = paramAttributeSet.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)y.js(this.context).inflate(2131496110, this);
    this.AJY = ((TextView)localViewGroup.findViewById(2131300214));
    this.lKn = ((ImageView)localViewGroup.findViewById(2131300201));
    this.AKd = localViewGroup.findViewById(2131301380);
    this.AKe = localViewGroup.findViewById(2131304172);
    this.AKf = localViewGroup.findViewById(2131301381);
    this.AKg = localViewGroup.findViewById(2131304173);
    this.AKf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eiR();
        }
        AppMethodBeat.o(116742);
      }
    });
    this.AKg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eiQ();
        }
        AppMethodBeat.o(116743);
      }
    });
    AppMethodBeat.o(116746);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116749);
    this.AKb = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.AKf.setVisibility(8);
        this.AKg.setVisibility(8);
      }
      if (this.AKb != null)
      {
        if (!this.AKb.hasNext())
        {
          this.AKg.setEnabled(false);
          this.AKe.setEnabled(false);
        }
        while (!this.AKb.hasPrevious())
        {
          this.AKd.setEnabled(false);
          this.AKf.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.AKe.setEnabled(true);
          this.AKg.setEnabled(true);
        }
        this.AKf.setEnabled(true);
        this.AKd.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.lKn.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.lKn.setVisibility(0);
    com.tencent.mm.aw.a.a.ayO().a(paramString, this.lKn, this.AJq);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.AJY.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */