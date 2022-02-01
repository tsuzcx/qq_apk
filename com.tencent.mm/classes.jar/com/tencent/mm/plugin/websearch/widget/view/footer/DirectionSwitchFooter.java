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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.ui.af;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private TextView WtW;
  private a.a WtZ;
  private c Wtu;
  private View Wub;
  private View Wuc;
  private View Wud;
  private View Wue;
  private Context context;
  private ImageView uoE;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKo = true;
    this.Wtu = locala.bKx();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.oKp = true;
    paramAttributeSet.oKo = true;
    this.Wtu = paramAttributeSet.bKx();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)af.mU(this.context).inflate(a.f.widget_footer_switch_direction, this);
    this.WtW = ((TextView)localViewGroup.findViewById(a.e.footer_title));
    this.uoE = ((ImageView)localViewGroup.findViewById(a.e.footer_icon));
    this.Wub = localViewGroup.findViewById(a.e.left_arrow);
    this.Wuc = localViewGroup.findViewById(a.e.right_arrow);
    this.Wud = localViewGroup.findViewById(a.e.left_arrow_container);
    this.Wue = localViewGroup.findViewById(a.e.right_arrow_container);
    this.Wud.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116742);
      }
    });
    this.Wue.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.WtZ = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.Wud.setVisibility(8);
        this.Wue.setVisibility(8);
      }
      if (this.WtZ != null)
      {
        if (!this.WtZ.hasNext())
        {
          this.Wue.setEnabled(false);
          this.Wuc.setEnabled(false);
        }
        while (!this.WtZ.hasPrevious())
        {
          this.Wub.setEnabled(false);
          this.Wud.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.Wuc.setEnabled(true);
          this.Wue.setEnabled(true);
        }
        this.Wud.setEnabled(true);
        this.Wub.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.uoE.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.uoE.setVisibility(0);
    com.tencent.mm.modelimage.loader.a.bKl().a(paramString, this.uoE, this.Wtu);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.WtW.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */