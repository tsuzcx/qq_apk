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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
{
  android.support.design.widget.a Edb;
  private int Edc;
  private int Edd;
  private boolean Ede;
  private boolean Edf;
  public a Edg;
  public String gIx;
  private View jBN;
  private Context mContext;
  public String mTitle;
  public String rcG;
  
  public n(final Context paramContext, m paramm, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.gIx = "";
    this.mTitle = "";
    this.rcG = "";
    this.Edc = -1;
    this.Edd = -1;
    this.Ede = false;
    this.Edf = false;
    this.gIx = paramString1;
    this.mTitle = paramString2;
    this.rcG = paramString3;
    this.mContext = paramContext;
    this.Ede = paramBoolean1;
    this.Edf = paramBoolean2;
    if ((paramm != null) && (paramm.getView() != null))
    {
      this.Edb = new android.support.design.widget.a(paramContext);
      this.Edb.setCanceledOnTouchOutside(true);
      this.jBN = View.inflate(paramContext, 2131496379, null);
      if (this.jBN == null)
      {
        Log.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.jBN.findViewById(2131298982);
      paramString1 = paramm.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.Edc = ((int)paramm.fdk().DZk);
      this.Edd = ((int)paramm.fdk().DZl);
      paramm = new LinearLayout.LayoutParams(-1, -1);
      if ((this.Edc != 2147483647) && (this.Edd != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramm.width = this.Edc;
          paramm.height = this.Edd;
        }
        paramContext.addView(paramString1, paramm);
        ((TextView)this.jBN.findViewById(2131297701)).setText(paramString2);
        paramContext = this.jBN.findViewById(2131298774);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            n.this.Edb.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96478);
          }
        });
        paramm = this.jBN.findViewById(2131297694);
        paramm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            n.this.Edb.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96479);
          }
        });
        if (!this.Edf) {
          paramm.setVisibility(8);
        }
        if (this.Ede) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.jBN.findViewById(2131309180);
        paramContext.setVisibility(8);
        if (Util.isNullOrNil(paramString3)) {
          break label424;
        }
        paramm = h.kD("adId", paramString3);
        if (paramm == null) {
          break;
        }
        paramContext.setImageBitmap(paramm);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      h.a(paramString3, 0, new f.a()
      {
        public final void aNH(String paramAnonymousString)
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
        
        public final void eWN() {}
        
        public final void eWO() {}
      });
    }
    label424:
    AppMethodBeat.o(96483);
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(96485);
    if (this.Edb != null) {
      this.Edb.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(96484);
    if ((this.jBN == null) || (this.Edb == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.Edb.getWindow().setFlags(8, 8);
    this.Edb.getWindow().addFlags(131200);
    if (this.Edg != null)
    {
      this.Edb.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          n.this.Edg.fdt();
          AppMethodBeat.o(96481);
        }
      });
      this.Edb.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          n.this.Edg.fdu();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.Edb.setContentView(this.jBN);
    BottomSheetBehavior.l((View)this.jBN.getParent()).J(ap.ha(this.mContext)[1]);
    this.Edb.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void fdt();
    
    public abstract void fdu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */