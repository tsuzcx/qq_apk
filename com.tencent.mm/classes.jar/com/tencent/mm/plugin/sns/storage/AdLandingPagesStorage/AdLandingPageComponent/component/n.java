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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class n
{
  public String gcZ;
  private View iFK;
  private Context mContext;
  public String mTitle;
  public String pMn;
  android.support.design.widget.a zUU;
  private int zUV;
  private int zUW;
  private boolean zUX;
  private boolean zUY;
  public a zUZ;
  
  public n(final Context paramContext, m paramm, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.gcZ = "";
    this.mTitle = "";
    this.pMn = "";
    this.zUV = -1;
    this.zUW = -1;
    this.zUX = false;
    this.zUY = false;
    this.gcZ = paramString1;
    this.mTitle = paramString2;
    this.pMn = paramString3;
    this.mContext = paramContext;
    this.zUX = paramBoolean1;
    this.zUY = paramBoolean2;
    if ((paramm != null) && (paramm.getView() != null))
    {
      this.zUU = new android.support.design.widget.a(paramContext);
      this.zUU.setCanceledOnTouchOutside(true);
      this.iFK = View.inflate(paramContext, 2131495496, null);
      if (this.iFK == null)
      {
        ae.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.iFK.findViewById(2131298549);
      paramString1 = paramm.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.zUV = ((int)paramm.eaw().zRi);
      this.zUW = ((int)paramm.eaw().zRj);
      paramm = new LinearLayout.LayoutParams(-1, -1);
      if ((this.zUV != 2147483647) && (this.zUW != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramm.width = this.zUV;
          paramm.height = this.zUW;
        }
        paramContext.addView(paramString1, paramm);
        ((TextView)this.iFK.findViewById(2131297466)).setText(paramString2);
        paramContext = this.iFK.findViewById(2131298368);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            n.this.zUU.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96478);
          }
        });
        paramm = this.iFK.findViewById(2131297460);
        paramm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            n.this.zUU.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96479);
          }
        });
        if (!this.zUY) {
          paramm.setVisibility(8);
        }
        if (this.zUX) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.iFK.findViewById(2131305894);
        paramContext.setVisibility(8);
        if (bu.isNullOrNil(paramString3)) {
          break label424;
        }
        paramm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jP("adId", paramString3);
        if (paramm == null) {
          break;
        }
        paramContext.setImageBitmap(paramm);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString3, 0, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(96480);
          try
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
            paramContext.setImageBitmap(paramAnonymousString);
            paramContext.setVisibility(0);
            AppMethodBeat.o(96480);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bu.o(paramAnonymousString));
            AppMethodBeat.o(96480);
          }
        }
        
        public final void dVu() {}
        
        public final void dVv() {}
      });
    }
    label424:
    AppMethodBeat.o(96483);
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(96485);
    if (this.zUU != null) {
      this.zUU.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void cPF()
  {
    AppMethodBeat.i(96484);
    if ((this.iFK == null) || (this.zUU == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.zUU.getWindow().setFlags(8, 8);
    this.zUU.getWindow().addFlags(131200);
    if (this.zUZ != null)
    {
      this.zUU.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          n.this.zUZ.eaE();
          AppMethodBeat.o(96481);
        }
      });
      this.zUU.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          n.this.zUZ.eaF();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.zUU.setContentView(this.iFK);
    BottomSheetBehavior.l((View)this.iFK.getParent()).J(an.gp(this.mContext)[1]);
    this.zUU.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void eaE();
    
    public abstract void eaF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */