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

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private c IIu;
  private TextView IJc;
  private View IJd;
  private a.a IJf;
  private Context context;
  private ImageView oeS;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116752);
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    this.IIu = locala.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116752);
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116753);
    paramAttributeSet = new c.a();
    paramAttributeSet.jbf = true;
    paramAttributeSet.jbe = true;
    this.IIu = paramAttributeSet.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116753);
  }
  
  private void init()
  {
    AppMethodBeat.i(116754);
    ViewGroup localViewGroup = (ViewGroup)aa.jQ(this.context).inflate(2131497102, this);
    this.IJd = localViewGroup.findViewById(2131299739);
    this.IJc = ((TextView)localViewGroup.findViewById(2131301683));
    this.oeS = ((ImageView)localViewGroup.findViewById(2131301668));
    localViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116751);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DownArrowSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (DownArrowSwitchFooter.a(DownArrowSwitchFooter.this) != null) {
          DownArrowSwitchFooter.a(DownArrowSwitchFooter.this).fZk();
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
    this.IJf = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.IJd.setVisibility(0);
        AppMethodBeat.o(116757);
        return;
      }
      this.IJd.setVisibility(8);
    }
    AppMethodBeat.o(116757);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116756);
    if (TextUtils.isEmpty(paramString))
    {
      this.oeS.setVisibility(8);
      AppMethodBeat.o(116756);
      return;
    }
    this.oeS.setVisibility(0);
    com.tencent.mm.av.a.a.bdb().a(paramString, this.oeS, this.IIu);
    AppMethodBeat.o(116756);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116755);
    this.IJc.setText(paramString);
    AppMethodBeat.o(116755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */