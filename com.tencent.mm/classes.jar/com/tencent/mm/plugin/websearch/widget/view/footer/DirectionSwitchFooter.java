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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.z;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private c DWD;
  private TextView DXl;
  private a.a DXo;
  private View DXq;
  private View DXr;
  private View DXs;
  private View DXt;
  private Context context;
  private ImageView mRP;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    this.DWD = locala.aJu();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.igk = true;
    paramAttributeSet.igj = true;
    this.DWD = paramAttributeSet.aJu();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)z.jV(this.context).inflate(2131496110, this);
    this.DXl = ((TextView)localViewGroup.findViewById(2131300214));
    this.mRP = ((ImageView)localViewGroup.findViewById(2131300201));
    this.DXq = localViewGroup.findViewById(2131301380);
    this.DXr = localViewGroup.findViewById(2131304172);
    this.DXs = localViewGroup.findViewById(2131301381);
    this.DXt = localViewGroup.findViewById(2131304173);
    this.DXs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eQN();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116742);
      }
    });
    this.DXt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).eQM();
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
    this.DXo = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.DXs.setVisibility(8);
        this.DXt.setVisibility(8);
      }
      if (this.DXo != null)
      {
        if (!this.DXo.hasNext())
        {
          this.DXt.setEnabled(false);
          this.DXr.setEnabled(false);
        }
        while (!this.DXo.hasPrevious())
        {
          this.DXq.setEnabled(false);
          this.DXs.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.DXr.setEnabled(true);
          this.DXt.setEnabled(true);
        }
        this.DXs.setEnabled(true);
        this.DXq.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.mRP.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.mRP.setVisibility(0);
    com.tencent.mm.av.a.a.aJh().a(paramString, this.mRP, this.DWD);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.DXl.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */