package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  public String equ;
  private View iCk;
  public String lix;
  private Context mContext;
  public String mTitle;
  c rvj;
  private int rvk;
  private int rvl;
  private boolean rvm;
  private boolean rvn;
  public i.a rvo;
  
  public i(Context paramContext, h paramh, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(37083);
    this.equ = "";
    this.mTitle = "";
    this.lix = "";
    this.rvk = -1;
    this.rvl = -1;
    this.rvm = false;
    this.rvn = false;
    this.equ = paramString1;
    this.mTitle = paramString2;
    this.lix = paramString3;
    this.mContext = paramContext;
    this.rvm = paramBoolean1;
    this.rvn = paramBoolean2;
    if ((paramh != null) && (paramh.getView() != null))
    {
      this.rvj = new c(paramContext);
      this.rvj.setCanceledOnTouchOutside(true);
      this.iCk = View.inflate(paramContext, 2130970778, null);
      if (this.iCk == null)
      {
        ab.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(37083);
        return;
      }
      paramContext = (LinearLayout)this.iCk.findViewById(2131827848);
      paramString1 = paramh.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.rvk = ((int)paramh.cqV().rsK);
      this.rvl = ((int)paramh.cqV().rsL);
      paramh = new LinearLayout.LayoutParams(-1, -1);
      if ((this.rvk != 2147483647) && (this.rvl != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramh.width = this.rvk;
          paramh.height = this.rvl;
        }
        paramContext.addView(paramString1, paramh);
        ((TextView)this.iCk.findViewById(2131826158)).setText(paramString2);
        paramContext = this.iCk.findViewById(2131827847);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37078);
            i.this.rvj.cancel();
            AppMethodBeat.o(37078);
          }
        });
        paramh = this.iCk.findViewById(2131827849);
        paramh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37079);
            i.this.rvj.cancel();
            AppMethodBeat.o(37079);
          }
        });
        if (!this.rvn) {
          paramh.setVisibility(8);
        }
        if (this.rvm) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.iCk.findViewById(2131823915);
        paramContext.setVisibility(8);
        if (bo.isNullOrNil(paramString3)) {
          break label424;
        }
        paramh = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gB("adId", paramString3);
        if (paramh == null) {
          break;
        }
        paramContext.setImageBitmap(paramh);
        paramContext.setVisibility(0);
        AppMethodBeat.o(37083);
        return;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString3, 0, new i.3(this, paramContext));
    }
    label424:
    AppMethodBeat.o(37083);
  }
  
  public final void crd()
  {
    AppMethodBeat.i(37084);
    if ((this.iCk == null) || (this.rvj == null))
    {
      AppMethodBeat.o(37084);
      return;
    }
    this.rvj.getWindow().setFlags(8, 8);
    this.rvj.getWindow().addFlags(131200);
    if (this.rvo != null)
    {
      this.rvj.setOnDismissListener(new i.4(this));
      this.rvj.setOnCancelListener(new i.5(this));
    }
    this.rvj.setContentView(this.iCk);
    BottomSheetBehavior.i((View)this.iCk.getParent()).t(ae.eU(this.mContext)[1]);
    this.rvj.show();
    AppMethodBeat.o(37084);
  }
  
  public final void cre()
  {
    AppMethodBeat.i(37085);
    if (this.rvj != null) {
      this.rvj.dismiss();
    }
    AppMethodBeat.o(37085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */