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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.o.a.a;
import com.tencent.mm.ui.o.a.b;
import com.tencent.mm.ui.o.a.c;

public class SnsUploadConfigView
  extends LinearLayout
  implements com.tencent.mm.ak.i, a.a, a.b
{
  private static String pkgName;
  ImageView EPj;
  ImageView EPk;
  ImageView EPl;
  ImageView EPm;
  private boolean EPn;
  boolean EPo;
  boolean EPp;
  private boolean EPq;
  private boolean EPr;
  private boolean EPs;
  private boolean EPt;
  boolean EPu;
  com.tencent.mm.ui.o.a EPv;
  cjy Etm;
  private Context context;
  private ProgressDialog vIA;
  boolean vUk;
  
  static
  {
    AppMethodBeat.i(203759);
    pkgName = MMApplicationContext.getApplicationId();
    AppMethodBeat.o(203759);
  }
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.vUk = false;
    this.EPn = false;
    this.EPo = false;
    this.EPp = false;
    this.EPq = false;
    this.EPr = false;
    this.EPs = true;
    this.EPt = false;
    this.EPu = false;
    this.Etm = new cjy();
    this.EPv = new com.tencent.mm.ui.o.a();
    this.vIA = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = aa.jQ(paramContext).inflate(2131496517, this, true);
    this.EPj = ((ImageView)paramAttributeSet.findViewById(2131308227));
    this.EPk = ((ImageView)paramAttributeSet.findViewById(2131308229));
    this.EPl = ((ImageView)paramAttributeSet.findViewById(2131308228));
    this.EPm = ((ImageView)paramAttributeSet.findViewById(2131308230));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = ar.m(paramContext, 2131689540, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = ar.m(paramContext, 2131689540, paramContext.getResources().getColor(2131100006));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.EPl.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ar.m(paramContext, 2131689530, Color.parseColor("#3C5998"));
    localDrawable2 = ar.m(paramContext, 2131689530, paramContext.getResources().getColor(2131100006));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.EPj.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ar.m(paramContext, 2131689546, Color.parseColor("#1DA1F2"));
    localDrawable2 = ar.m(paramContext, 2131689546, paramContext.getResources().getColor(2131100006));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.EPk.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ar.m(paramContext, 2131689548, Color.parseColor("#FF0F80"));
    localDrawable2 = ar.m(paramContext, 2131689548, paramContext.getResources().getColor(2131100006));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.EPm.setImageDrawable(paramAttributeSet);
    if ((WeChatBrands.Business.Entries.HomePluginQQMail.banned()) || (!com.tencent.mm.aw.b.bdE())) {
      this.EPl.setVisibility(8);
    }
    if (!WeChatBrands.Business.Entries.Global3rdSrv.banned())
    {
      g.aAi();
      if (g.aAh().azQ().getBoolean(ar.a.NUZ, false)) {}
    }
    else
    {
      this.EPm.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!com.tencent.mm.aw.b.isOverseasUser())) {
      this.EPk.setVisibility(8);
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || (!z.aUC())) {
      this.EPj.setVisibility(8);
    }
    this.EPl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.n(paramContext, 2131766246, 2131755998);
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
    this.EPm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.n(paramContext, 2131766248, 2131755998);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        g.aAi();
        if (g.aAh().azQ().getBoolean(ar.a.NVa, true))
        {
          g.aAi();
          g.aAh().azQ().set(ar.a.NVa, Boolean.FALSE);
          h.a(paramContext, 2131766233, 2131755998, new DialogInterface.OnClickListener()
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
    this.EPj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99526);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.EPk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99527);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  private void Po(int paramInt)
  {
    AppMethodBeat.i(99538);
    h.a(getContext(), paramInt, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    if (this.vIA != null) {
      this.vIA.cancel();
    }
    switch (SnsUploadConfigView.7.yyh[paramc.ordinal()])
    {
    }
    for (;;)
    {
      fjG();
      AppMethodBeat.o(99540);
      return;
      this.EPp = true;
      Po(2131766888);
      continue;
      this.EPp = false;
      continue;
      this.EPp = false;
      Po(2131766887);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.yyh[paramc.ordinal()])
    {
    }
    for (;;)
    {
      fjG();
      AppMethodBeat.o(99541);
      return;
      this.EPp = false;
    }
  }
  
  public final void fjD()
  {
    AppMethodBeat.i(99532);
    this.EPn = false;
    this.EPo = false;
    this.EPp = false;
    this.EPq = false;
    this.EPr = false;
    this.EPl.setImageDrawable(ar.m(this.context, 2131689540, this.context.getResources().getColor(2131100006)));
    this.EPm.setImageDrawable(ar.m(this.context, 2131689548, this.context.getResources().getColor(2131100006)));
    this.EPj.setImageDrawable(ar.m(this.context, 2131689530, this.context.getResources().getColor(2131100006)));
    this.EPk.setImageDrawable(ar.m(this.context, 2131689546, this.context.getResources().getColor(2131100006)));
    AppMethodBeat.o(99532);
  }
  
  final void fjE()
  {
    AppMethodBeat.i(99533);
    if (this.EPq)
    {
      g.aAi();
      int i = Util.nullAsNil((Integer)g.aAh().azQ().get(9, null));
      if (i == 0) {
        h.a(getContext(), 2131765696, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99528);
            com.tencent.mm.plugin.sns.c.a.jRt.g(new Intent(), SnsUploadConfigView.k(SnsUploadConfigView.this));
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
        this.EPq = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.EPl.setImageDrawable(ar.m(this.context, 2131689540, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.EPl.setImageDrawable(ar.m(this.context, 2131689540, this.context.getResources().getColor(2131100006)));
    AppMethodBeat.o(99533);
  }
  
  final void fjF()
  {
    AppMethodBeat.i(99534);
    if (this.EPm == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.EPu)
    {
      g.aAi();
      if (g.aAh().azQ().getBoolean(ar.a.NUZ, false)) {}
    }
    else
    {
      this.EPr = false;
      this.EPm.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.EPm.setVisibility(0);
    if (this.EPr)
    {
      this.EPm.setImageDrawable(ar.m(this.context, 2131689548, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.EPm.setImageDrawable(ar.m(this.context, 2131689548, this.context.getResources().getColor(2131100006)));
    AppMethodBeat.o(99534);
  }
  
  final void fjG()
  {
    AppMethodBeat.i(99536);
    if (this.EPp)
    {
      if (!this.EPv.gYx()) {
        h.a(getContext(), 2131765658, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99530);
            paramAnonymousDialogInterface = SnsUploadConfigView.this;
            Context localContext = SnsUploadConfigView.this.getContext();
            SnsUploadConfigView.this.getContext().getString(2131755998);
            SnsUploadConfigView.a(paramAnonymousDialogInterface, h.a(localContext, SnsUploadConfigView.this.getContext().getString(2131766886), true, new DialogInterface.OnCancelListener()
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
        this.EPp = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.EPk.setImageDrawable(ar.m(this.context, 2131689546, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.EPk.setImageDrawable(ar.m(this.context, 2131689546, this.context.getResources().getColor(2131100006)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.vUk) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.EPn) {
      j = 1;
    }
    int i = j;
    if (this.EPo) {
      i = j | 0x2;
    }
    j = i;
    if (this.EPp) {
      j = i | 0x8;
    }
    i = j;
    if (this.EPq) {
      i = j | 0x4;
    }
    j = i;
    if (this.EPr) {
      j = i | 0x10;
    }
    return j;
  }
  
  public org.b.d.i getTwitterAccessToken()
  {
    return this.EPv.QAH;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    fjF();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.vUk = paramBoolean;
    if (paramBoolean) {
      fjD();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.EPo)
    {
      if (!z.aUF()) {
        h.a(getContext(), 2131765389, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        this.EPo = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.EPt) && (z.aUF()))
      {
        final gs localgs = new gs();
        localgs.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgs.dKM.dFE) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        EventCenter.instance.asyncPublish(localgs, Looper.myLooper());
      }
      this.EPj.setImageDrawable(ar.m(this.context, 2131689530, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.EPj.setImageDrawable(ar.m(this.context, 2131689530, this.context.getResources().getColor(2131100006)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */