package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
{
  a QOZ;
  private int QPa;
  private int QPb;
  private boolean QPc;
  private boolean QPd;
  public a QPe;
  public String lWh;
  private Context mContext;
  public String mTitle;
  private View plc;
  public String xOn;
  
  public o(final Context paramContext, n paramn, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.lWh = "";
    this.mTitle = "";
    this.xOn = "";
    this.QPa = -1;
    this.QPb = -1;
    this.QPc = false;
    this.QPd = false;
    this.lWh = paramString1;
    this.mTitle = paramString2;
    this.xOn = paramString3;
    this.mContext = paramContext;
    this.QPc = paramBoolean1;
    this.QPd = paramBoolean2;
    if ((paramn != null) && (paramn.getView() != null))
    {
      this.QOZ = new a(paramContext);
      this.QOZ.setCanceledOnTouchOutside(true);
      this.plc = View.inflate(paramContext, b.g.sns_ad_native_landing_pages_item_bottom_sheet, null);
      if (this.plc == null)
      {
        Log.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.plc.findViewById(b.f.component_container);
      paramString1 = paramn.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.QPa = ((int)paramn.QOV.QKI);
      this.QPb = ((int)paramn.QOV.QKJ);
      paramn = new LinearLayout.LayoutParams(-1, -1);
      if ((this.QPa != 2147483647) && (this.QPb != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramn.width = this.QPa;
          paramn.height = this.QPb;
        }
        paramContext.addView(paramString1, paramn);
        ((TextView)this.plc.findViewById(b.f.bottom_sheet_title)).setText(paramString2);
        paramContext = this.plc.findViewById(b.f.close_dialog_area);
        paramContext.setOnClickListener(new o.1(this));
        paramn = this.plc.findViewById(b.f.bottom_sheet_cancel_area);
        paramn.setOnClickListener(new o.2(this));
        if (!this.QPd) {
          paramn.setVisibility(8);
        }
        if (this.QPc) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.plc.findViewById(b.f.tips_icon);
        paramContext.setVisibility(8);
        if (Util.isNullOrNil(paramString3)) {
          break label431;
        }
        paramn = k.mH("adId", paramString3);
        if (paramn == null) {
          break;
        }
        paramContext.setImageBitmap(paramn);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      k.b("adId", paramString3, new g.a()
      {
        public final void aWn(String paramAnonymousString)
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
        
        public final void gZM() {}
        
        public final void gZN() {}
      });
    }
    label431:
    AppMethodBeat.o(96483);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(96485);
    if (this.QOZ != null) {
      this.QOZ.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(96484);
    if ((this.plc == null) || (this.QOZ == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.QOZ.getWindow().setFlags(8, 8);
    this.QOZ.getWindow().addFlags(131200);
    if (this.QPe != null)
    {
      this.QOZ.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          o.this.QPe.hjo();
          AppMethodBeat.o(96481);
        }
      });
      this.QOZ.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          o.this.QPe.hjp();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.QOZ.setContentView(this.plc);
    BottomSheetBehavior.cC((View)this.plc.getParent()).setPeekHeight(ar.jR(this.mContext)[1]);
    this.QOZ.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void hjo();
    
    public abstract void hjp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */