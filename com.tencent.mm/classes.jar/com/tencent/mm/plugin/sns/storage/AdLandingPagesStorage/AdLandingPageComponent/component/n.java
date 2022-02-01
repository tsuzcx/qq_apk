package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
{
  com.google.android.material.bottomsheet.a KqE;
  private int KqF;
  private int KqG;
  private boolean KqH;
  private boolean KqI;
  public a KqJ;
  public String jsP;
  private Context mContext;
  public String mTitle;
  private View mrI;
  public String uFL;
  
  public n(final Context paramContext, m paramm, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.jsP = "";
    this.mTitle = "";
    this.uFL = "";
    this.KqF = -1;
    this.KqG = -1;
    this.KqH = false;
    this.KqI = false;
    this.jsP = paramString1;
    this.mTitle = paramString2;
    this.uFL = paramString3;
    this.mContext = paramContext;
    this.KqH = paramBoolean1;
    this.KqI = paramBoolean2;
    if ((paramm != null) && (paramm.getView() != null))
    {
      this.KqE = new com.google.android.material.bottomsheet.a(paramContext);
      this.KqE.setCanceledOnTouchOutside(true);
      this.mrI = View.inflate(paramContext, i.g.sns_ad_native_landing_pages_item_bottom_sheet, null);
      if (this.mrI == null)
      {
        Log.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.mrI.findViewById(i.f.component_container);
      paramString1 = paramm.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.KqF = ((int)paramm.KqB.KmD);
      this.KqG = ((int)paramm.KqB.KmE);
      paramm = new LinearLayout.LayoutParams(-1, -1);
      if ((this.KqF != 2147483647) && (this.KqG != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramm.width = this.KqF;
          paramm.height = this.KqG;
        }
        paramContext.addView(paramString1, paramm);
        ((TextView)this.mrI.findViewById(i.f.bottom_sheet_title)).setText(paramString2);
        paramContext = this.mrI.findViewById(i.f.close_dialog_area);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            n.this.KqE.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96478);
          }
        });
        paramm = this.mrI.findViewById(i.f.bottom_sheet_cancel_area);
        paramm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            n.this.KqE.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96479);
          }
        });
        if (!this.KqI) {
          paramm.setVisibility(8);
        }
        if (this.KqH) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.mrI.findViewById(i.f.tips_icon);
        paramContext.setVisibility(8);
        if (Util.isNullOrNil(paramString3)) {
          break label431;
        }
        paramm = h.kZ("adId", paramString3);
        if (paramm == null) {
          break;
        }
        paramContext.setImageBitmap(paramm);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      h.a("adId", paramString3, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(96480);
          try
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
            paramContext.setImageBitmap(paramAnonymousString);
            paramContext.setVisibility(0);
            AppMethodBeat.o(96480);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("MicroMsg.AdLandingPageBottomSheet", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96480);
          }
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
    }
    label431:
    AppMethodBeat.o(96483);
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(96485);
    if (this.KqE != null) {
      this.KqE.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(96484);
    if ((this.mrI == null) || (this.KqE == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.KqE.getWindow().setFlags(8, 8);
    this.KqE.getWindow().addFlags(131200);
    if (this.KqJ != null)
    {
      this.KqE.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          n.this.KqJ.fRq();
          AppMethodBeat.o(96481);
        }
      });
      this.KqE.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          n.this.KqJ.fRr();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.KqE.setContentView(this.mrI);
    BottomSheetBehavior.cg((View)this.mrI.getParent()).D(ao.ib(this.mContext)[1]);
    this.KqE.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void fRq();
    
    public abstract void fRr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */