package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.gz;
import com.tencent.mm.f.a.gz.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.q.a.a;
import com.tencent.mm.ui.q.a.b;
import com.tencent.mm.ui.q.a.c;

public class SnsUploadConfigView
  extends LinearLayout
  implements com.tencent.mm.an.i, a.a, a.b
{
  private static String pkgName;
  boolean ABX;
  private ProgressDialog Apv;
  cst KGJ;
  ImageView Lde;
  ImageView Ldf;
  ImageView Ldg;
  ImageView Ldh;
  private boolean Ldi;
  boolean Ldj;
  boolean Ldk;
  private boolean Ldl;
  private boolean Ldm;
  private boolean Ldn;
  private boolean Ldo;
  boolean Ldp;
  com.tencent.mm.ui.q.a Ldq;
  private Context context;
  
  static
  {
    AppMethodBeat.i(270748);
    pkgName = MMApplicationContext.getApplicationId();
    AppMethodBeat.o(270748);
  }
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.ABX = false;
    this.Ldi = false;
    this.Ldj = false;
    this.Ldk = false;
    this.Ldl = false;
    this.Ldm = false;
    this.Ldn = true;
    this.Ldo = false;
    this.Ldp = false;
    this.KGJ = new cst();
    this.Ldq = new com.tencent.mm.ui.q.a();
    this.Apv = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = ad.kS(paramContext).inflate(i.g.sns_upload_config_view, this, true);
    this.Lde = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_facebook_iv));
    this.Ldf = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_twitter_iv));
    this.Ldg = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_qzone_iv));
    this.Ldh = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_weishi_iv));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = au.o(paramContext, i.i.album_qzone_icon_normal, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = au.o(paramContext, i.i.album_qzone_icon_normal, paramContext.getResources().getColor(i.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Ldg.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = au.o(paramContext, i.i.album_facebook_icon_normal, Color.parseColor("#3C5998"));
    localDrawable2 = au.o(paramContext, i.i.album_facebook_icon_normal, paramContext.getResources().getColor(i.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Lde.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = au.o(paramContext, i.i.album_twitter_icon_normal, Color.parseColor("#1DA1F2"));
    localDrawable2 = au.o(paramContext, i.i.album_twitter_icon_normal, paramContext.getResources().getColor(i.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Ldf.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = au.o(paramContext, i.i.album_wesee_icon_normal, Color.parseColor("#FF0F80"));
    localDrawable2 = au.o(paramContext, i.i.album_wesee_icon_normal, paramContext.getResources().getColor(i.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Ldh.setImageDrawable(paramAttributeSet);
    if ((WeChatBrands.Business.Entries.HomePluginQQMail.banned()) || (!com.tencent.mm.az.b.bmY())) {
      this.Ldg.setVisibility(8);
    }
    if (!WeChatBrands.Business.Entries.Global3rdSrv.banned())
    {
      com.tencent.mm.kernel.h.aHH();
      if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.ViY, false)) {}
    }
    else
    {
      this.Ldh.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!com.tencent.mm.az.b.isOverseasUser())) {
      this.Ldf.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!z.bdE())) {
      this.Lde.setVisibility(8);
    }
    this.Ldg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          com.tencent.mm.ui.base.h.p(paramContext, i.j.sns_tag_privacy_qzone_conflict_tip, i.j.app_tip);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99520);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.a(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.a(paramAnonymousView, bool);
          SnsUploadConfigView.c(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99520);
          return;
        }
      }
    });
    this.Ldh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          com.tencent.mm.ui.base.h.p(paramContext, i.j.sns_tag_privacy_weishi_conflict_tip, i.j.app_tip);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        com.tencent.mm.kernel.h.aHH();
        if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.ViZ, true))
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViZ, Boolean.FALSE);
          com.tencent.mm.ui.base.h.a(paramContext, i.j.sns_tag_first_show_weishi_tip, i.j.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(99524);
              paramAnonymous2DialogInterface = SnsUploadConfigView.this;
              if (SnsUploadConfigView.d(SnsUploadConfigView.this)) {}
              for (boolean bool = false;; bool = true)
              {
                SnsUploadConfigView.b(paramAnonymous2DialogInterface, bool);
                SnsUploadConfigView.e(SnsUploadConfigView.this);
                AppMethodBeat.o(99524);
                return;
              }
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.d(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.b(paramAnonymousView, bool);
          SnsUploadConfigView.e(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
      }
    });
    this.Lde.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99526);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.c(paramAnonymousView, bool);
          if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.h(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99526);
          return;
        }
      }
    });
    this.Ldf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99527);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.d(paramAnonymousView, bool);
          if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.j(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99527);
          return;
        }
      }
    });
    AppMethodBeat.o(99531);
  }
  
  private void Vx(int paramInt)
  {
    AppMethodBeat.i(99538);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(99538);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(99540);
    if (this.Apv != null) {
      this.Apv.cancel();
    }
    switch (SnsUploadConfigView.7.DYl[paramc.ordinal()])
    {
    }
    for (;;)
    {
      fXT();
      AppMethodBeat.o(99540);
      return;
      this.Ldk = true;
      Vx(i.j.twitterlogin_success);
      continue;
      this.Ldk = false;
      continue;
      this.Ldk = false;
      Vx(i.j.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.DYl[paramc.ordinal()])
    {
    }
    for (;;)
    {
      fXT();
      AppMethodBeat.o(99541);
      return;
      this.Ldk = false;
    }
  }
  
  public final void fXQ()
  {
    AppMethodBeat.i(99532);
    this.Ldi = false;
    this.Ldj = false;
    this.Ldk = false;
    this.Ldl = false;
    this.Ldm = false;
    this.Ldg.setImageDrawable(au.o(this.context, i.i.album_qzone_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    this.Ldh.setImageDrawable(au.o(this.context, i.i.album_wesee_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    this.Lde.setImageDrawable(au.o(this.context, i.i.album_facebook_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    this.Ldf.setImageDrawable(au.o(this.context, i.i.album_twitter_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    AppMethodBeat.o(99532);
  }
  
  final void fXR()
  {
    AppMethodBeat.i(99533);
    if (this.Ldl)
    {
      com.tencent.mm.kernel.h.aHH();
      int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null));
      if (i == 0) {
        com.tencent.mm.ui.base.h.a(getContext(), i.j.settings_weibo_notice, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99528);
            com.tencent.mm.plugin.sns.c.a.mIG.g(new Intent(), SnsUploadConfigView.k(SnsUploadConfigView.this));
            AppMethodBeat.o(99528);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label97;
        }
        this.Ldl = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.Ldg.setImageDrawable(au.o(this.context, i.i.album_qzone_icon_normal, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.Ldg.setImageDrawable(au.o(this.context, i.i.album_qzone_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    AppMethodBeat.o(99533);
  }
  
  final void fXS()
  {
    AppMethodBeat.i(99534);
    if (this.Ldh == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.Ldp)
    {
      com.tencent.mm.kernel.h.aHH();
      if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.ViY, false)) {}
    }
    else
    {
      this.Ldm = false;
      this.Ldh.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.Ldh.setVisibility(0);
    if (this.Ldm)
    {
      this.Ldh.setImageDrawable(au.o(this.context, i.i.album_wesee_icon_normal, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.Ldh.setImageDrawable(au.o(this.context, i.i.album_wesee_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    AppMethodBeat.o(99534);
  }
  
  final void fXT()
  {
    AppMethodBeat.i(99536);
    if (this.Ldk)
    {
      if (!this.Ldq.hZk()) {
        com.tencent.mm.ui.base.h.a(getContext(), i.j.settings_twitter_notice, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99530);
            paramAnonymousDialogInterface = SnsUploadConfigView.this;
            Context localContext = SnsUploadConfigView.this.getContext();
            SnsUploadConfigView.this.getContext().getString(i.j.app_tip);
            SnsUploadConfigView.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a(localContext, SnsUploadConfigView.this.getContext().getString(i.j.twitter_loading), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
            }));
            SnsUploadConfigView.l(SnsUploadConfigView.this).a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
            AppMethodBeat.o(99530);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.Ldk = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.Ldf.setImageDrawable(au.o(this.context, i.i.album_twitter_icon_normal, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.Ldf.setImageDrawable(au.o(this.context, i.i.album_twitter_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.ABX) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.Ldi) {
      j = 1;
    }
    int i = j;
    if (this.Ldj) {
      i = j | 0x2;
    }
    j = i;
    if (this.Ldk) {
      j = i | 0x8;
    }
    i = j;
    if (this.Ldl) {
      i = j | 0x4;
    }
    j = i;
    if (this.Ldm) {
      j = i | 0x10;
    }
    return j;
  }
  
  public org.b.d.i getTwitterAccessToken()
  {
    return this.Ldq.XZg;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    fXS();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.ABX = paramBoolean;
    if (paramBoolean) {
      fXQ();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.Ldj)
    {
      if (!z.bdH()) {
        com.tencent.mm.ui.base.h.a(getContext(), i.j.settings_facebook_notice, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99529);
            c.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
            AppMethodBeat.o(99529);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.Ldj = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.Ldo) && (z.bdH()))
      {
        final gz localgz = new gz();
        localgz.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgz.fDB.fyl) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        EventCenter.instance.asyncPublish(localgz, Looper.myLooper());
      }
      this.Lde.setImageDrawable(au.o(this.context, i.i.album_facebook_icon_normal, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.Lde.setImageDrawable(au.o(this.context, i.i.album_facebook_icon_normal, this.context.getResources().getColor(i.c.arrow_color)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */