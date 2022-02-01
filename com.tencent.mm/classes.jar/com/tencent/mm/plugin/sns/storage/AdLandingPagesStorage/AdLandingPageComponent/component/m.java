package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;

public final class m
{
  public String gaR;
  private View iCR;
  private Context mContext;
  public String mTitle;
  public String pFJ;
  android.support.design.widget.a zDP;
  private int zDQ;
  private int zDR;
  private boolean zDS;
  private boolean zDT;
  public a zDU;
  
  public m(final Context paramContext, l paraml, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.gaR = "";
    this.mTitle = "";
    this.pFJ = "";
    this.zDQ = -1;
    this.zDR = -1;
    this.zDS = false;
    this.zDT = false;
    this.gaR = paramString1;
    this.mTitle = paramString2;
    this.pFJ = paramString3;
    this.mContext = paramContext;
    this.zDS = paramBoolean1;
    this.zDT = paramBoolean2;
    if ((paraml != null) && (paraml.getView() != null))
    {
      this.zDP = new android.support.design.widget.a(paramContext);
      this.zDP.setCanceledOnTouchOutside(true);
      this.iCR = View.inflate(paramContext, 2131495496, null);
      if (this.iCR == null)
      {
        ad.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.iCR.findViewById(2131298549);
      paramString1 = paraml.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.zDQ = ((int)paraml.dWS().zAi);
      this.zDR = ((int)paraml.dWS().zAj);
      paraml = new LinearLayout.LayoutParams(-1, -1);
      if ((this.zDQ != 2147483647) && (this.zDR != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paraml.width = this.zDQ;
          paraml.height = this.zDR;
        }
        paramContext.addView(paramString1, paraml);
        ((TextView)this.iCR.findViewById(2131297466)).setText(paramString2);
        paramContext = this.iCR.findViewById(2131298368);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            m.this.zDP.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96478);
          }
        });
        paraml = this.iCR.findViewById(2131297460);
        paraml.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            m.this.zDP.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96479);
          }
        });
        if (!this.zDT) {
          paraml.setVisibility(8);
        }
        if (this.zDS) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.iCR.findViewById(2131305894);
        paramContext.setVisibility(8);
        if (bt.isNullOrNil(paramString3)) {
          break label424;
        }
        paraml = h.jJ("adId", paramString3);
        if (paraml == null) {
          break;
        }
        paramContext.setImageBitmap(paraml);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      h.a(paramString3, 0, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(96480);
          try
          {
            paramAnonymousString = g.decodeFile(paramAnonymousString);
            paramContext.setImageBitmap(paramAnonymousString);
            paramContext.setVisibility(0);
            AppMethodBeat.o(96480);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bt.n(paramAnonymousString));
            AppMethodBeat.o(96480);
          }
        }
        
        public final void dRW() {}
        
        public final void dRX() {}
      });
    }
    label424:
    AppMethodBeat.o(96483);
  }
  
  public final void bpT()
  {
    AppMethodBeat.i(96485);
    if (this.zDP != null) {
      this.zDP.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void cMW()
  {
    AppMethodBeat.i(96484);
    if ((this.iCR == null) || (this.zDP == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.zDP.getWindow().setFlags(8, 8);
    this.zDP.getWindow().addFlags(131200);
    if (this.zDU != null)
    {
      this.zDP.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          m.this.zDU.dXa();
          AppMethodBeat.o(96481);
        }
      });
      this.zDP.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          m.this.zDU.dXb();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.zDP.setContentView(this.iCR);
    BottomSheetBehavior.l((View)this.iCR.getParent()).J(am.gk(this.mContext)[1]);
    this.zDP.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void dXa();
    
    public abstract void dXb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */