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

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private c DWD;
  private TextView DXl;
  private View DXm;
  private View DXn;
  private a.a DXo;
  private Context context;
  private ImageView mRP;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116733);
    c.a locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    this.DWD = locala.aJu();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116733);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116734);
    paramAttributeSet = new c.a();
    paramAttributeSet.igk = true;
    paramAttributeSet.igj = true;
    this.DWD = paramAttributeSet.aJu();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116734);
  }
  
  private void init()
  {
    AppMethodBeat.i(116735);
    ViewGroup localViewGroup = (ViewGroup)z.jV(this.context).inflate(2131496109, this);
    this.DXn = localViewGroup.findViewById(2131300200);
    this.DXm = localViewGroup.findViewById(2131300210);
    this.DXl = ((TextView)localViewGroup.findViewById(2131300214));
    this.mRP = ((ImageView)localViewGroup.findViewById(2131300201));
    this.DXn.setVisibility(8);
    this.DXm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116732);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (BtnSwitchFooter.a(BtnSwitchFooter.this) != null) {
          BtnSwitchFooter.a(BtnSwitchFooter.this).eQL();
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
    this.DXo = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.DXm.setVisibility(0);
        AppMethodBeat.o(116740);
        return;
      }
      this.DXm.setVisibility(8);
    }
    AppMethodBeat.o(116740);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116739);
    if (TextUtils.isEmpty(paramString))
    {
      this.mRP.setVisibility(8);
      AppMethodBeat.o(116739);
      return;
    }
    this.mRP.setVisibility(0);
    com.tencent.mm.av.a.a.aJh().a(paramString, this.mRP, this.DWD);
    AppMethodBeat.o(116739);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116736);
    this.DXm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116736);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(116737);
    this.DXm.setVisibility(paramInt);
    AppMethodBeat.o(116737);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116738);
    this.DXl.setText(paramString);
    AppMethodBeat.o(116738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */