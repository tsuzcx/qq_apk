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
import com.tencent.mm.ui.aa;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private c IIu;
  private TextView IJc;
  private a.a IJf;
  private View IJh;
  private View IJi;
  private View IJj;
  private View IJk;
  private Context context;
  private ImageView oeS;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116744);
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    this.IIu = locala.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116744);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116745);
    paramAttributeSet = new c.a();
    paramAttributeSet.jbf = true;
    paramAttributeSet.jbe = true;
    this.IIu = paramAttributeSet.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116745);
  }
  
  private void init()
  {
    AppMethodBeat.i(116746);
    ViewGroup localViewGroup = (ViewGroup)aa.jQ(this.context).inflate(2131497101, this);
    this.IJc = ((TextView)localViewGroup.findViewById(2131301683));
    this.oeS = ((ImageView)localViewGroup.findViewById(2131301668));
    this.IJh = localViewGroup.findViewById(2131303134);
    this.IJi = localViewGroup.findViewById(2131307076);
    this.IJj = localViewGroup.findViewById(2131303135);
    this.IJk = localViewGroup.findViewById(2131307079);
    this.IJj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116742);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).fZm();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116742);
      }
    });
    this.IJk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116743);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).fZl();
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
    this.IJf = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.IJj.setVisibility(8);
        this.IJk.setVisibility(8);
      }
      if (this.IJf != null)
      {
        if (!this.IJf.hasNext())
        {
          this.IJk.setEnabled(false);
          this.IJi.setEnabled(false);
        }
        while (!this.IJf.hasPrevious())
        {
          this.IJh.setEnabled(false);
          this.IJj.setEnabled(false);
          AppMethodBeat.o(116749);
          return;
          this.IJi.setEnabled(true);
          this.IJk.setEnabled(true);
        }
        this.IJj.setEnabled(true);
        this.IJh.setEnabled(true);
      }
    }
    AppMethodBeat.o(116749);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116748);
    if (TextUtils.isEmpty(paramString))
    {
      this.oeS.setVisibility(8);
      AppMethodBeat.o(116748);
      return;
    }
    this.oeS.setVisibility(0);
    com.tencent.mm.av.a.a.bdb().a(paramString, this.oeS, this.IIu);
    AppMethodBeat.o(116748);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116747);
    this.IJc.setText(paramString);
    AppMethodBeat.o(116747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */