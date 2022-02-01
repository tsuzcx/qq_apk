package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MobileRemittanceUI$12
  implements View.OnClickListener
{
  MobileRemittanceUI$12(MobileRemittanceUI paramMobileRemittanceUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(67773);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahq());
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
    this.xXk.showCircleStWcKb();
    this.xXk.xXc = this.xXk.xXd;
    paramView = new e(this.xXk.getContext(), 1, false);
    localObject1 = this.xXk.getLayoutInflater().inflate(2131494925, null);
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131302372);
    ((View)localObject1).findViewById(2131302367).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67769);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click cancel!");
        paramView.bpT();
        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67769);
      }
    });
    ((View)localObject1).findViewById(2131302369).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67770);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = (adu)MobileRemittanceUI.c(MobileRemittanceUI.12.this.xXk).get(MobileRemittanceUI.12.this.xXk.xXc);
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click confirm! (code:%s option:%s)", new Object[] { Integer.valueOf(paramAnonymousView.code), paramAnonymousView.xVg });
        MobileRemittanceUI.12.this.xXk.xXd = MobileRemittanceUI.12.this.xXk.xXc;
        MobileRemittanceUI.12.this.xXk.xWt = paramAnonymousView.code;
        MobileRemittanceUI.d(MobileRemittanceUI.12.this.xXk).setText(paramAnonymousView.xVg);
        paramView.bpT();
        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67770);
      }
    });
    final ArrayList localArrayList = new ArrayList();
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67771);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((View)((Iterator)localObject).next()).findViewById(2131302368).setVisibility(8);
        }
        paramAnonymousView = (ImageView)paramAnonymousView.getTag();
        MobileRemittanceUI.12.this.xXk.xXc = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView.setVisibility(0);
        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67771);
      }
    };
    int i = 0;
    if (i < MobileRemittanceUI.c(this.xXk).size())
    {
      Object localObject2 = (adu)MobileRemittanceUI.c(this.xXk).get(i);
      View localView = this.xXk.getLayoutInflater().inflate(2131494926, null);
      ((TextView)localView.findViewById(2131302370)).setText(((adu)localObject2).xVg);
      localObject2 = (ImageView)localView.findViewById(2131302368);
      ((ImageView)localObject2).getDrawable().setColorFilter(this.xXk.getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      if (this.xXk.xXd == i) {
        ((ImageView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        ((ImageView)localObject2).setTag(Integer.valueOf(i));
        localView.setTag(localObject2);
        localView.setOnClickListener(local3);
        localLinearLayout.addView(localView);
        localArrayList.add(localView);
        i += 1;
        break;
        ((ImageView)localObject2).setVisibility(8);
      }
    }
    paramView.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(67772);
        paramAnonymousl.clear();
        paramView.setFooterView(null);
        paramView.setFooterView(this.xXp);
        AppMethodBeat.o(67772);
      }
    };
    paramView.fMc();
    paramView.cMW();
    MobileRemittanceUI.Oe(7);
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.12
 * JD-Core Version:    0.7.0.1
 */