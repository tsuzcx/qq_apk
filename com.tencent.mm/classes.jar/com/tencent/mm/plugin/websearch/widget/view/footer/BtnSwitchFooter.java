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

public class BtnSwitchFooter
  extends LinearLayout
  implements a
{
  private c DEF;
  private TextView DFo;
  private View DFp;
  private View DFq;
  private a.a DFr;
  private Context context;
  private ImageView mMM;
  
  public BtnSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116733);
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    this.DEF = locala.aJc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116733);
  }
  
  public BtnSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116734);
    paramAttributeSet = new c.a();
    paramAttributeSet.idr = true;
    paramAttributeSet.idq = true;
    this.DEF = paramAttributeSet.aJc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116734);
  }
  
  private void init()
  {
    AppMethodBeat.i(116735);
    ViewGroup localViewGroup = (ViewGroup)z.jO(this.context).inflate(2131496109, this);
    this.DFq = localViewGroup.findViewById(2131300200);
    this.DFp = localViewGroup.findViewById(2131300210);
    this.DFo = ((TextView)localViewGroup.findViewById(2131300214));
    this.mMM = ((ImageView)localViewGroup.findViewById(2131300201));
    this.DFq.setVisibility(8);
    this.DFp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116732);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (BtnSwitchFooter.a(BtnSwitchFooter.this) != null) {
          BtnSwitchFooter.a(BtnSwitchFooter.this).eNa();
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
    this.DFr = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.DFp.setVisibility(0);
        AppMethodBeat.o(116740);
        return;
      }
      this.DFp.setVisibility(8);
    }
    AppMethodBeat.o(116740);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116739);
    if (TextUtils.isEmpty(paramString))
    {
      this.mMM.setVisibility(8);
      AppMethodBeat.o(116739);
      return;
    }
    this.mMM.setVisibility(0);
    com.tencent.mm.aw.a.a.aIP().a(paramString, this.mMM, this.DEF);
    AppMethodBeat.o(116739);
  }
  
  public void setSwitchClickLsn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116736);
    this.DFp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116736);
  }
  
  public void setSwitchVisible(int paramInt)
  {
    AppMethodBeat.i(116737);
    this.DFp.setVisibility(paramInt);
    AppMethodBeat.o(116737);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116738);
    this.DFo.setText(paramString);
    AppMethodBeat.o(116738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter
 * JD-Core Version:    0.7.0.1
 */