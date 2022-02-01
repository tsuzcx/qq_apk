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

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private c IIu;
  private TextView IJc;
  private View IJd;
  private View IJe;
  private a.a IJf;
  private Context context;
  private ImageView oeS;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116733);
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    this.IIu = locala.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116733);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116734);
    paramAttributeSet = new c.a();
    paramAttributeSet.jbf = true;
    paramAttributeSet.jbe = true;
    this.IIu = paramAttributeSet.bdv();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116734);
  }
  
  private void init()
  {
    AppMethodBeat.i(116735);
    ViewGroup localViewGroup = (ViewGroup)aa.jQ(this.context).inflate(2131497100, this);
    this.IJe = localViewGroup.findViewById(2131301666);
    this.IJd = localViewGroup.findViewById(2131301679);
    this.IJc = ((TextView)localViewGroup.findViewById(2131301683));
    this.oeS = ((ImageView)localViewGroup.findViewById(2131301668));
    this.IJe.setVisibility(8);
    this.IJd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116732);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (BtnSwitchFooter.a(BtnSwitchFooter.this) != null) {
          BtnSwitchFooter.a(BtnSwitchFooter.this).fZk();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116732);
      }
    });
    AppMethodBeat.o(116735);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116740);
    this.IJf = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.IJd.setVisibility(0);
        AppMethodBeat.o(116740);
        return;
      }
      this.IJd.setVisibility(8);
    }
    AppMethodBeat.o(116740);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116739);
    if (TextUtils.isEmpty(paramString))
    {
      this.oeS.setVisibility(8);
      AppMethodBeat.o(116739);
      return;
    }
    this.oeS.setVisibility(0);
    com.tencent.mm.av.a.a.bdb().a(paramString, this.oeS, this.IIu);
    AppMethodBeat.o(116739);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116736);
    this.IJd.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116736);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(116737);
    this.IJd.setVisibility(paramInt);
    AppMethodBeat.o(116737);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116738);
    this.IJc.setText(paramString);
    AppMethodBeat.o(116738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */