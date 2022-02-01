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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.ui.ad;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private c PCP;
  private TextView PDr;
  private a.a PDu;
  private View PDw;
  private View PDx;
  private View PDy;
  private View PDz;
  private Context context;
  private ImageView rgE;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.lRD = true;
    locala.lRC = true;
    this.PCP = locala.bmL();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.lRD = true;
    paramAttributeSet.lRC = true;
    this.PCP = paramAttributeSet.bmL();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)ad.kS(this.context).inflate(a.e.widget_footer_switch_direction, this);
    this.PDr = ((TextView)localViewGroup.findViewById(a.d.footer_title));
    this.rgE = ((ImageView)localViewGroup.findViewById(a.d.footer_icon));
    this.PDw = localViewGroup.findViewById(a.d.left_arrow);
    this.PDx = localViewGroup.findViewById(a.d.right_arrow);
    this.PDy = localViewGroup.findViewById(a.d.left_arrow_container);
    this.PDz = localViewGroup.findViewById(a.d.right_arrow_container);
    this.PDy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116742);
      }
    });
    this.PDz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116743);
      }
    });
    AppMethodBeat.o(116746);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116749);
    this.PDu = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.PDy.setVisibility(8);
        this.PDz.setVisibility(8);
      }
      if (this.PDu != null)
      {
        if (!this.PDu.hasNext())
        {
          this.PDz.setEnabled(false);
          this.PDx.setEnabled(false);
        }
        while (!this.PDu.hasPrevious())
        {
          this.PDw.setEnabled(false);
          this.PDy.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.PDx.setEnabled(true);
          this.PDz.setEnabled(true);
        }
        this.PDy.setEnabled(true);
        this.PDw.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.rgE.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.rgE.setVisibility(0);
    com.tencent.mm.ay.a.a.bms().a(paramString, this.rgE, this.PCP);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.PDr.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */