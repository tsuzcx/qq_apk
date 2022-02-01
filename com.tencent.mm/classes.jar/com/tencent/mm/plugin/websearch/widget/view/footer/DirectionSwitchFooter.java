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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.z;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private c DEF;
  private TextView DFo;
  private a.a DFr;
  private View DFt;
  private View DFu;
  private View DFv;
  private View DFw;
  private Context context;
  private ImageView mMM;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    this.DEF = locala.aJc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.idr = true;
    paramAttributeSet.idq = true;
    this.DEF = paramAttributeSet.aJc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)z.jO(this.context).inflate(2131496110, this);
    this.DFo = ((TextView)localViewGroup.findViewById(2131300214));
    this.mMM = ((ImageView)localViewGroup.findViewById(2131300201));
    this.DFt = localViewGroup.findViewById(2131301380);
    this.DFu = localViewGroup.findViewById(2131304172);
    this.DFv = localViewGroup.findViewById(2131301381);
    this.DFw = localViewGroup.findViewById(2131304173);
    this.DFv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eNc();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116742);
      }
    });
    this.DFw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eNb();
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
    this.DFr = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.DFv.setVisibility(8);
        this.DFw.setVisibility(8);
      }
      if (this.DFr != null)
      {
        if (!this.DFr.hasNext())
        {
          this.DFw.setEnabled(false);
          this.DFu.setEnabled(false);
        }
        while (!this.DFr.hasPrevious())
        {
          this.DFt.setEnabled(false);
          this.DFv.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.DFu.setEnabled(true);
          this.DFw.setEnabled(true);
        }
        this.DFv.setEnabled(true);
        this.DFt.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.mMM.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.mMM.setVisibility(0);
    com.tencent.mm.aw.a.a.aIP().a(paramString, this.mMM, this.DEF);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.DFo.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */