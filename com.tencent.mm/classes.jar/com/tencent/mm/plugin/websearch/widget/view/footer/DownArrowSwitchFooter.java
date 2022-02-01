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

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private TextView WtW;
  private View WtX;
  private a.a WtZ;
  private c Wtu;
  private Context context;
  private ImageView uoE;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116752);
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKo = true;
    this.Wtu = locala.bKx();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116752);
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116753);
    paramAttributeSet = new c.a();
    paramAttributeSet.oKp = true;
    paramAttributeSet.oKo = true;
    this.Wtu = paramAttributeSet.bKx();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116753);
  }
  
  private void init()
  {
    AppMethodBeat.i(116754);
    ViewGroup localViewGroup = (ViewGroup)af.mU(this.context).inflate(a.f.widget_footer_switch_downarrow, this);
    this.WtX = localViewGroup.findViewById(a.e.down_arrow);
    this.WtW = ((TextView)localViewGroup.findViewById(a.e.footer_title));
    this.uoE = ((ImageView)localViewGroup.findViewById(a.e.footer_icon));
    localViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116751);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/footer/DownArrowSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (DownArrowSwitchFooter.a(DownArrowSwitchFooter.this) != null) {
          DownArrowSwitchFooter.a(DownArrowSwitchFooter.this).irl();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DownArrowSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116751);
      }
    });
    AppMethodBeat.o(116754);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116757);
    this.WtZ = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.WtX.setVisibility(0);
        AppMethodBeat.o(116757);
        return;
      }
      this.WtX.setVisibility(8);
    }
    AppMethodBeat.o(116757);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116756);
    if (TextUtils.isEmpty(paramString))
    {
      this.uoE.setVisibility(8);
      AppMethodBeat.o(116756);
      return;
    }
    this.uoE.setVisibility(0);
    com.tencent.mm.modelimage.loader.a.bKl().a(paramString, this.uoE, this.Wtu);
    AppMethodBeat.o(116756);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116755);
    this.WtW.setText(paramString);
    AppMethodBeat.o(116755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */