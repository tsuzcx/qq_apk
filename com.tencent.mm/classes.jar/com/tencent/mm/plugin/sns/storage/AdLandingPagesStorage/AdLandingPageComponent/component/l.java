package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

public final class l
{
  public String fDK;
  private View hIZ;
  private Context mContext;
  public String mTitle;
  public String oyz;
  a xag;
  private int xah;
  private int xai;
  private boolean xaj;
  private boolean xak;
  public a xal;
  
  public l(final Context paramContext, k paramk, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.fDK = "";
    this.mTitle = "";
    this.oyz = "";
    this.xah = -1;
    this.xai = -1;
    this.xaj = false;
    this.xak = false;
    this.fDK = paramString1;
    this.mTitle = paramString2;
    this.oyz = paramString3;
    this.mContext = paramContext;
    this.xaj = paramBoolean1;
    this.xak = paramBoolean2;
    if ((paramk != null) && (paramk.getView() != null))
    {
      this.xag = new a(paramContext);
      this.xag.setCanceledOnTouchOutside(true);
      this.hIZ = View.inflate(paramContext, 2131495496, null);
      if (this.hIZ == null)
      {
        ad.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.hIZ.findViewById(2131298549);
      paramString1 = paramk.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.xah = ((int)paramk.dwb().wWG);
      this.xai = ((int)paramk.dwb().wWH);
      paramk = new LinearLayout.LayoutParams(-1, -1);
      if ((this.xah != 2147483647) && (this.xai != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramk.width = this.xah;
          paramk.height = this.xai;
        }
        paramContext.addView(paramString1, paramk);
        ((TextView)this.hIZ.findViewById(2131297466)).setText(paramString2);
        paramContext = this.hIZ.findViewById(2131298368);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            l.this.xag.cancel();
            AppMethodBeat.o(96478);
          }
        });
        paramk = this.hIZ.findViewById(2131297460);
        paramk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            l.this.xag.cancel();
            AppMethodBeat.o(96479);
          }
        });
        if (!this.xak) {
          paramk.setVisibility(8);
        }
        if (this.xaj) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.hIZ.findViewById(2131305894);
        paramContext.setVisibility(8);
        if (bt.isNullOrNil(paramString3)) {
          break label424;
        }
        paramk = h.iY("adId", paramString3);
        if (paramk == null) {
          break;
        }
        paramContext.setImageBitmap(paramk);
        paramContext.setVisibility(0);
        AppMethodBeat.o(96483);
        return;
      }
      h.a(paramString3, 0, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(96480);
          try
          {
            paramAnonymousString = f.decodeFile(paramAnonymousString);
            paramContext.setImageBitmap(paramAnonymousString);
            paramContext.setVisibility(0);
            AppMethodBeat.o(96480);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bt.m(paramAnonymousString));
            AppMethodBeat.o(96480);
          }
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
    }
    label424:
    AppMethodBeat.o(96483);
  }
  
  public final void bfo()
  {
    AppMethodBeat.i(96485);
    if (this.xag != null) {
      this.xag.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void csG()
  {
    AppMethodBeat.i(96484);
    if ((this.hIZ == null) || (this.xag == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.xag.getWindow().setFlags(8, 8);
    this.xag.getWindow().addFlags(131200);
    if (this.xal != null)
    {
      this.xag.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          l.this.xal.dwj();
          AppMethodBeat.o(96481);
        }
      });
      this.xag.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          l.this.xal.dwk();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.xag.setContentView(this.hIZ);
    BottomSheetBehavior.l((View)this.hIZ.getParent()).J(al.fU(this.mContext)[1]);
    this.xag.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void dwj();
    
    public abstract void dwk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */