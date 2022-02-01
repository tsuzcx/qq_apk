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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

public final class l
{
  public String fHr;
  private View ijA;
  private Context mContext;
  public String mTitle;
  public String pbZ;
  a ymV;
  private int ymW;
  private int ymX;
  private boolean ymY;
  private boolean ymZ;
  public a yna;
  
  public l(final Context paramContext, k paramk, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96483);
    this.fHr = "";
    this.mTitle = "";
    this.pbZ = "";
    this.ymW = -1;
    this.ymX = -1;
    this.ymY = false;
    this.ymZ = false;
    this.fHr = paramString1;
    this.mTitle = paramString2;
    this.pbZ = paramString3;
    this.mContext = paramContext;
    this.ymY = paramBoolean1;
    this.ymZ = paramBoolean2;
    if ((paramk != null) && (paramk.getView() != null))
    {
      this.ymV = new a(paramContext);
      this.ymV.setCanceledOnTouchOutside(true);
      this.ijA = View.inflate(paramContext, 2131495496, null);
      if (this.ijA == null)
      {
        ac.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
        AppMethodBeat.o(96483);
        return;
      }
      paramContext = (LinearLayout)this.ijA.findViewById(2131298549);
      paramString1 = paramk.getView();
      if (paramString1.getParent() != null) {
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
      }
      this.ymW = ((int)paramk.dKA().yju);
      this.ymX = ((int)paramk.dKA().yjv);
      paramk = new LinearLayout.LayoutParams(-1, -1);
      if ((this.ymW != 2147483647) && (this.ymX != 2147483647)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramk.width = this.ymW;
          paramk.height = this.ymX;
        }
        paramContext.addView(paramString1, paramk);
        ((TextView)this.ijA.findViewById(2131297466)).setText(paramString2);
        paramContext = this.ijA.findViewById(2131298368);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96478);
            l.this.ymV.cancel();
            AppMethodBeat.o(96478);
          }
        });
        paramk = this.ijA.findViewById(2131297460);
        paramk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96479);
            l.this.ymV.cancel();
            AppMethodBeat.o(96479);
          }
        });
        if (!this.ymZ) {
          paramk.setVisibility(8);
        }
        if (this.ymY) {
          paramContext.setVisibility(8);
        }
        paramContext = (ImageView)this.ijA.findViewById(2131305894);
        paramContext.setVisibility(8);
        if (bs.isNullOrNil(paramString3)) {
          break label424;
        }
        paramk = h.jw("adId", paramString3);
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
        public final void asD(String paramAnonymousString)
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
            ac.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bs.m(paramAnonymousString));
            AppMethodBeat.o(96480);
          }
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
    }
    label424:
    AppMethodBeat.o(96483);
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(96485);
    if (this.ymV != null) {
      this.ymV.dismiss();
    }
    AppMethodBeat.o(96485);
  }
  
  public final void cED()
  {
    AppMethodBeat.i(96484);
    if ((this.ijA == null) || (this.ymV == null))
    {
      AppMethodBeat.o(96484);
      return;
    }
    this.ymV.getWindow().setFlags(8, 8);
    this.ymV.getWindow().addFlags(131200);
    if (this.yna != null)
    {
      this.ymV.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96481);
          l.this.yna.dKI();
          AppMethodBeat.o(96481);
        }
      });
      this.ymV.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(96482);
          l.this.yna.dKJ();
          AppMethodBeat.o(96482);
        }
      });
    }
    this.ymV.setContentView(this.ijA);
    BottomSheetBehavior.l((View)this.ijA.getParent()).J(al.gg(this.mContext)[1]);
    this.ymV.show();
    AppMethodBeat.o(96484);
  }
  
  public static abstract interface a
  {
    public abstract void dKI();
    
    public abstract void dKJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */