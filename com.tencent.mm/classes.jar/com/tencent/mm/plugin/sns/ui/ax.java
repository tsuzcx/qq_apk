package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class ax
  implements View.OnClickListener
{
  private int JCO;
  private l JHg;
  private c.b JHi;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c JJh;
  private SnsInfo Jws;
  public Button KKA;
  private View KKB;
  private ADXml.AdCardActionBtnInfo KKC;
  private int KKD;
  c.a KKE;
  private RoundedCornerFrameLayout KKw;
  private ImageView KKx;
  private TextView KKy;
  private TextView KKz;
  private View mContentView;
  public Context mContext;
  
  public ax(Context paramContext, View paramView, int paramInt, l paraml, c.b paramb)
  {
    AppMethodBeat.i(251226);
    this.KKD = 0;
    this.KKE = new c.a()
    {
      public final void a(AdClickActionInfo paramAnonymousAdClickActionInfo)
      {
        AppMethodBeat.i(268775);
        if ((paramAnonymousAdClickActionInfo == null) || (ax.d(ax.this) == null))
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adCardActionBtnInfo or mActionBtn is null, can not updateActionBtnTitle");
          AppMethodBeat.o(268775);
          return;
        }
        switch (paramAnonymousAdClickActionInfo.Jxx)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(268775);
          return;
          if (!Util.isNullOrNil(paramAnonymousAdClickActionInfo.JxB))
          {
            ax.d(ax.this).setTextColor(-7829368);
            ax.d(ax.this).setText(paramAnonymousAdClickActionInfo.JxB);
            ax.d(ax.this).setEnabled(false);
            AppMethodBeat.o(268775);
            return;
            paramAnonymousAdClickActionInfo = paramAnonymousAdClickActionInfo.JxR;
            if (!Util.isNullOrNil(paramAnonymousAdClickActionInfo))
            {
              ax.d(ax.this).setText(paramAnonymousAdClickActionInfo);
              AppMethodBeat.o(268775);
              return;
              ax.this.W(ax.e(ax.this));
            }
          }
        }
      }
    };
    Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + paraml);
    this.mContext = paramContext;
    this.JCO = paramInt;
    this.JHg = paraml;
    this.JHi = paramb;
    this.mContentView = paramView;
    this.KKB = this.mContentView.findViewById(i.f.media_container);
    this.KKw = ((RoundedCornerFrameLayout)paramView.findViewById(i.f.action_icon_container));
    this.KKx = ((ImageView)paramView.findViewById(i.f.action_icon));
    this.KKy = ((TextView)paramView.findViewById(i.f.action_title_txt));
    this.KKz = ((TextView)paramView.findViewById(i.f.action_desc_txt));
    this.KKA = ((Button)paramView.findViewById(i.f.action_btn));
    this.KKA.setOnClickListener(this);
    this.KKw.setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 4));
    this.JJh = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mContext, this.JCO, this.JHg, this.KKE, new c.b()
    {
      public final void fLc()
      {
        AppMethodBeat.i(259467);
        if (ax.a(ax.this) != null) {
          ax.a(ax.this).fLc();
        }
        AppMethodBeat.o(259467);
      }
      
      public final ViewGroup fLd()
      {
        AppMethodBeat.i(259468);
        ViewGroup localViewGroup = (ViewGroup)ax.b(ax.this);
        AppMethodBeat.o(259468);
        return localViewGroup;
      }
    });
    AppMethodBeat.o(251226);
  }
  
  public final void W(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(98297);
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.Jws = paramSnsInfo;
    this.KKC = paramSnsInfo.getAdXml().adCardActionBtnInfo;
    if (this.KKC != null)
    {
      this.JJh.a(this.KKC.clickActionInfo, this.Jws, 0);
      System.currentTimeMillis();
      SpannableString localSpannableString;
      if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardTitle))
      {
        localSpannableString = com.tencent.mm.cl.h.htZ().a(this.KKy.getContext(), paramSnsInfo.getAdXml().adCardTitle, this.KKy.getTextSize());
        this.KKy.setText(localSpannableString);
        this.KKy.setVisibility(0);
        this.KKy.setTypeface(Typeface.defaultFromStyle(1));
        if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardDesc))
        {
          localSpannableString = com.tencent.mm.cl.h.htZ().a(this.KKz.getContext(), paramSnsInfo.getAdXml().adCardDesc, this.KKz.getTextSize());
          this.KKz.setText(localSpannableString);
          this.KKz.setVisibility(0);
        }
      }
      try
      {
        for (;;)
        {
          this.KKA.setTextColor(this.mContext.getResources().getColor(i.c.blue_text_color));
          this.KKA.setEnabled(true);
          if (this.KKC.clickActionInfo.Jxx != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.KKA.getText().toString())) {
            this.KKA.setText(this.KKC.btnTitle);
          }
          new a(this.KKA, this.KKC.clickActionInfo.JxN, this.KKC.clickActionInfo.JxM, this.KKC.btnTitle).execute(new Void[0]);
          if (TextUtils.isEmpty(this.KKC.iconUrl)) {
            break label692;
          }
          this.KKw.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.i.c.l(this.KKC.iconUrl, this.KKx);
          AppMethodBeat.o(98297);
          return;
          this.KKz.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardDesc))
        {
          localSpannableString = com.tencent.mm.cl.h.htZ().a(this.KKy.getContext(), paramSnsInfo.getAdXml().adCardDesc, this.KKy.getTextSize());
          this.KKy.setText(localSpannableString);
          this.KKy.setVisibility(0);
          this.KKy.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.KKz.setVisibility(8);
          break;
          this.KKy.setVisibility(8);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
          continue;
          if (this.KKC.clickActionInfo.Jxx == 6)
          {
            try
            {
              paramSnsInfo = t.Qu(paramSnsInfo.field_snsId);
              if (Util.isNullOrNil(paramSnsInfo)) {
                continue;
              }
              if (!"1".equals(y.bbL(paramSnsInfo))) {
                break label565;
              }
              this.KKA.setTextColor(-7829368);
              this.KKA.setText(this.KKC.clickActionInfo.JxB);
              this.KKA.setEnabled(false);
            }
            catch (Throwable paramSnsInfo)
            {
              Log.e("MicroMsg.SnsAdCardActionBtnCtrl", paramSnsInfo.toString());
            }
            continue;
            label565:
            this.KKA.setText(this.KKC.btnTitle);
          }
          else if (this.KKC.clickActionInfo.Jxx == 7)
          {
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(268699);
                bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
                if ((localbv != null) && (!Util.isNullOrNil(ax.c(ax.this).clickActionInfo.lFl))) {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(235693);
                      if ((this.jkl != null) && (d.rk(this.jkl.field_type)))
                      {
                        ax.d(ax.this).setText(ax.c(ax.this).clickActionInfo.JxR);
                        AppMethodBeat.o(235693);
                        return;
                      }
                      ax.d(ax.this).setText(ax.c(ax.this).btnTitle);
                      AppMethodBeat.o(235693);
                    }
                  });
                }
                AppMethodBeat.o(268699);
              }
            });
          }
          else if (this.KKC.clickActionInfo.Jxx == 13)
          {
            agZ(this.KKD);
            ((m)com.tencent.mm.kernel.h.ae(m.class)).b(this.KKC.clickActionInfo.finderUsername, new m.a()
            {
              public final void d(final ai paramAnonymousai)
              {
                AppMethodBeat.i(197362);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179161);
                    if (paramAnonymousai != null)
                    {
                      int i = paramAnonymousai.dnu();
                      ax.a(ax.this, i);
                      Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "getFinderContact, followFlg=" + i + ", userName=" + paramAnonymousai.getUsername());
                      ax.this.agZ(i);
                      AppMethodBeat.o(179161);
                      return;
                    }
                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "getFinderContact, iLocalFinderContact==null");
                    AppMethodBeat.o(179161);
                  }
                });
                AppMethodBeat.o(197362);
              }
            });
          }
          else
          {
            this.KKA.setText(this.KKC.btnTitle);
          }
        }
        label692:
        this.KKw.setVisibility(8);
      }
    }
    AppMethodBeat.o(98297);
  }
  
  public final void agZ(int paramInt)
  {
    AppMethodBeat.i(251233);
    if (paramInt == 0)
    {
      this.KKA.setText(this.KKC.btnTitle);
      AppMethodBeat.o(251233);
      return;
    }
    this.KKA.setText(this.KKC.clickActionInfo.Jyh);
    AppMethodBeat.o(251233);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98298);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.JJh.gd(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98298);
  }
  
  public static final class a
    extends AsyncTask<Void, Void, Integer>
  {
    String KKJ;
    Button KqS;
    String abY;
    String appid;
    
    public a(Button paramButton, String paramString1, String paramString2, String paramString3)
    {
      this.abY = paramString1;
      this.appid = paramString2;
      this.KqS = paramButton;
      this.KKJ = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */