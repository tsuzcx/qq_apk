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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.hk;
import com.tencent.mm.autogen.a.hk.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.q.a.a;
import com.tencent.mm.ui.q.a.b;
import com.tencent.mm.ui.q.a.c;
import org.b.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements com.tencent.mm.am.h, a.a, a.b
{
  private static String pkgName;
  private ProgressDialog FPA;
  boolean Gdb;
  ImageView RDn;
  ImageView RDo;
  ImageView RDp;
  ImageView RDq;
  private boolean RDr;
  boolean RDs;
  boolean RDt;
  private boolean RDu;
  private boolean RDv;
  private boolean RDw;
  private boolean RDx;
  boolean RDy;
  com.tencent.mm.ui.q.a RDz;
  djv Rgk;
  private Context context;
  
  static
  {
    AppMethodBeat.i(308386);
    pkgName = MMApplicationContext.getApplicationId();
    AppMethodBeat.o(308386);
  }
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.Gdb = false;
    this.RDr = false;
    this.RDs = false;
    this.RDt = false;
    this.RDu = false;
    this.RDv = false;
    this.RDw = true;
    this.RDx = false;
    this.RDy = false;
    this.Rgk = new djv();
    this.RDz = new com.tencent.mm.ui.q.a();
    this.FPA = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = af.mU(paramContext).inflate(b.g.sns_upload_config_view, this, true);
    this.RDn = ((ImageView)paramAttributeSet.findViewById(b.f.sns_sync_facebook_iv));
    this.RDo = ((ImageView)paramAttributeSet.findViewById(b.f.sns_sync_twitter_iv));
    this.RDp = ((ImageView)paramAttributeSet.findViewById(b.f.sns_sync_qzone_iv));
    this.RDq = ((ImageView)paramAttributeSet.findViewById(b.f.sns_sync_weishi_iv));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = bb.m(paramContext, b.i.album_qzone_icon_normal, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = bb.m(paramContext, b.i.album_qzone_icon_normal, paramContext.getResources().getColor(b.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.RDp.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = bb.m(paramContext, b.i.album_facebook_icon_normal, Color.parseColor("#3C5998"));
    localDrawable2 = bb.m(paramContext, b.i.album_facebook_icon_normal, paramContext.getResources().getColor(b.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.RDn.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = bb.m(paramContext, b.i.album_twitter_icon_normal, Color.parseColor("#1DA1F2"));
    localDrawable2 = bb.m(paramContext, b.i.album_twitter_icon_normal, paramContext.getResources().getColor(b.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.RDo.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = bb.m(paramContext, b.i.album_wesee_icon_normal, Color.parseColor("#FF0F80"));
    localDrawable2 = bb.m(paramContext, b.i.album_wesee_icon_normal, paramContext.getResources().getColor(b.c.arrow_color));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.RDq.setImageDrawable(paramAttributeSet);
    if ((WeChatBrands.Business.Entries.HomePluginQQMail.banned()) || (!com.tencent.mm.au.b.bKK())) {
      this.RDp.setVisibility(8);
    }
    if (!WeChatBrands.Business.Entries.Global3rdSrv.banned())
    {
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acKs, false)) {}
    }
    else
    {
      this.RDq.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!com.tencent.mm.au.b.isOverseasUser())) {
      this.RDo.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!z.bBw())) {
      this.RDn.setVisibility(8);
    }
    this.RDp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          k.s(paramContext, b.j.sns_tag_privacy_qzone_conflict_tip, b.j.app_tip);
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
    this.RDq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          k.s(paramContext, b.j.sns_tag_privacy_weishi_conflict_tip, b.j.app_tip);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acKt, true))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acKt, Boolean.FALSE);
          k.a(paramContext, b.j.sns_tag_first_show_weishi_tip, b.j.app_tip, new DialogInterface.OnClickListener()
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
    this.RDn.setOnClickListener(new SnsUploadConfigView.9(this));
    this.RDo.setOnClickListener(new SnsUploadConfigView.10(this));
    AppMethodBeat.o(99531);
  }
  
  private void Zs(int paramInt)
  {
    AppMethodBeat.i(99538);
    k.a(getContext(), paramInt, b.j.app_tip, new SnsUploadConfigView.5(this), new SnsUploadConfigView.6(this));
    AppMethodBeat.o(99538);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(99540);
    if (this.FPA != null) {
      this.FPA.cancel();
    }
    switch (SnsUploadConfigView.7.JPt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      hqo();
      AppMethodBeat.o(99540);
      return;
      this.RDt = true;
      Zs(b.j.twitterlogin_success);
      continue;
      this.RDt = false;
      continue;
      this.RDt = false;
      Zs(b.j.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.JPt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      hqo();
      AppMethodBeat.o(99541);
      return;
      this.RDt = false;
    }
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.Gdb) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.RDr) {
      j = 1;
    }
    int i = j;
    if (this.RDs) {
      i = j | 0x2;
    }
    j = i;
    if (this.RDt) {
      j = i | 0x8;
    }
    i = j;
    if (this.RDu) {
      i = j | 0x4;
    }
    j = i;
    if (this.RDv) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.RDz.afPW;
  }
  
  public final void hql()
  {
    AppMethodBeat.i(99532);
    this.RDr = false;
    this.RDs = false;
    this.RDt = false;
    this.RDu = false;
    this.RDv = false;
    this.RDp.setImageDrawable(bb.m(this.context, b.i.album_qzone_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    this.RDq.setImageDrawable(bb.m(this.context, b.i.album_wesee_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    this.RDn.setImageDrawable(bb.m(this.context, b.i.album_facebook_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    this.RDo.setImageDrawable(bb.m(this.context, b.i.album_twitter_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    AppMethodBeat.o(99532);
  }
  
  final void hqm()
  {
    AppMethodBeat.i(99533);
    if (this.RDu)
    {
      com.tencent.mm.kernel.h.baF();
      int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null));
      if (i == 0) {
        k.a(getContext(), b.j.settings_weibo_notice, b.j.app_tip, new DialogInterface.OnClickListener()new SnsUploadConfigView.12
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99528);
            com.tencent.mm.plugin.sns.d.a.pFn.g(new Intent(), SnsUploadConfigView.k(SnsUploadConfigView.this));
            AppMethodBeat.o(99528);
          }
        }, new SnsUploadConfigView.12(this));
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label97;
        }
        this.RDu = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.RDp.setImageDrawable(bb.m(this.context, b.i.album_qzone_icon_normal, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.RDp.setImageDrawable(bb.m(this.context, b.i.album_qzone_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    AppMethodBeat.o(99533);
  }
  
  final void hqn()
  {
    AppMethodBeat.i(99534);
    if (this.RDq == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.RDy)
    {
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acKs, false)) {}
    }
    else
    {
      this.RDv = false;
      this.RDq.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.RDq.setVisibility(0);
    if (this.RDv)
    {
      this.RDq.setImageDrawable(bb.m(this.context, b.i.album_wesee_icon_normal, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.RDq.setImageDrawable(bb.m(this.context, b.i.album_wesee_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    AppMethodBeat.o(99534);
  }
  
  final void hqo()
  {
    AppMethodBeat.i(99536);
    if (this.RDt)
    {
      if (!this.RDz.jEf()) {
        k.a(getContext(), b.j.settings_twitter_notice, b.j.app_tip, new DialogInterface.OnClickListener()new SnsUploadConfigView.2
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99530);
            paramAnonymousDialogInterface = SnsUploadConfigView.this;
            Context localContext = SnsUploadConfigView.this.getContext();
            SnsUploadConfigView.this.getContext().getString(b.j.app_tip);
            SnsUploadConfigView.a(paramAnonymousDialogInterface, k.a(localContext, SnsUploadConfigView.this.getContext().getString(b.j.twitter_loading), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
            }));
            SnsUploadConfigView.l(SnsUploadConfigView.this).a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
            AppMethodBeat.o(99530);
          }
        }, new SnsUploadConfigView.2(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.RDt = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.RDo.setImageDrawable(bb.m(this.context, b.i.album_twitter_icon_normal, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.RDo.setImageDrawable(bb.m(this.context, b.i.album_twitter_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    AppMethodBeat.o(99536);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    hqn();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.Gdb = paramBoolean;
    if (paramBoolean) {
      hql();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.RDs)
    {
      if (!z.bBz()) {
        k.a(getContext(), b.j.settings_facebook_notice, b.j.app_tip, new SnsUploadConfigView.13(this), new SnsUploadConfigView.14(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.RDs = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.RDx) && (z.bBz()))
      {
        final hk localhk = new hk();
        localhk.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localhk.hIr.hCQ) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        localhk.asyncPublish(Looper.myLooper());
      }
      this.RDn.setImageDrawable(bb.m(this.context, b.i.album_facebook_icon_normal, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.RDn.setImageDrawable(bb.m(this.context, b.i.album_facebook_icon_normal, this.context.getResources().getColor(b.c.arrow_color)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */