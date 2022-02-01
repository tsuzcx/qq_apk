package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.b;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.messenger.b.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.progress.MMProgressWheel;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;)V", "autoLoginCb", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "autoLoginRl", "Landroid/widget/RelativeLayout;", "closeNotifyBt", "closeNotifyBtLayout", "getContext", "()Landroid/content/Context;", "deviceOpLayout", "folderIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "footerRl", "headerRl", "helpRl", "hideLayout1", "hideLayout2", "iconLock", "iconNotify", "isLock", "", "isNotifyOpen", "line2", "getListener", "()Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "lockBt", "lockBtLayout", "Landroid/widget/LinearLayout;", "lockBtTv", "Landroid/widget/TextView;", "lockProgressPw", "Lcom/tencent/mm/ui/widget/progress/MMProgressWheel;", "logoutBt", "logoutBtRl", "progressFadeOut", "Landroid/animation/Animator;", "shapeIv", "statusDescTv", "statusIcon", "transferBt", "transferBtLayout", "changeCloseNotifyBt", "", "notify", "changeShowFooter", "show", "fillContent", "onlineInfo", "Lcom/tencent/mm/plugin/messenger/extdevice/NetSceneGetOnlineInfo$LocalOnlineInfo;", "position", "", "isShow", "refreshLockBt", "lock", "syncWebWXNotifyStatus", "updateCenterArea", "updateStatus", "IDeviceListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.v
{
  private TextView XwZ;
  private RelativeLayout XxA;
  private WeImageView XxB;
  private RelativeLayout XxC;
  private RelativeLayout XxD;
  private View XxE;
  private View XxF;
  private RelativeLayout XxG;
  private WeImageView XxH;
  private LinearLayout XxI;
  private RelativeLayout XxJ;
  private WeImageView XxK;
  private TextView XxL;
  private MMProgressWheel XxM;
  private LinearLayout XxN;
  private RelativeLayout XxO;
  private WeImageView XxP;
  private RelativeLayout XxQ;
  private View XxR;
  private View XxS;
  private Animator XxT;
  private boolean XxU;
  private RelativeLayout Xxg;
  private CheckBox Xxh;
  private final a Xxr;
  private RelativeLayout Xxx;
  private WeImageView Xxy;
  private TextView Xxz;
  private final Context context;
  private boolean wbg;
  
  public b(Context paramContext, View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(265371);
    this.context = paramContext;
    this.Xxr = parama;
    this.Xxx = ((RelativeLayout)paramView.findViewById(R.h.fFi));
    this.Xxy = ((WeImageView)paramView.findViewById(R.h.status_icon));
    this.Xxz = ((TextView)paramView.findViewById(R.h.status_desc));
    this.XxA = ((RelativeLayout)paramView.findViewById(R.h.fJJ));
    this.XxB = ((WeImageView)paramView.findViewById(R.h.shape_iv));
    this.XxC = ((RelativeLayout)paramView.findViewById(R.h.fFg));
    this.XxD = ((RelativeLayout)paramView.findViewById(R.h.fFh));
    this.XxE = paramView.findViewById(R.h.fFj);
    this.XxF = paramView.findViewById(R.h.fBq);
    this.XxG = ((RelativeLayout)paramView.findViewById(R.h.fFd));
    this.XxH = ((WeImageView)paramView.findViewById(R.h.fJT));
    this.XxI = ((LinearLayout)paramView.findViewById(R.h.fNk));
    this.XxJ = ((RelativeLayout)paramView.findViewById(R.h.fFk));
    this.XxK = ((WeImageView)paramView.findViewById(R.h.fJR));
    this.XxL = ((TextView)paramView.findViewById(R.h.fFl));
    this.XxM = ((MMProgressWheel)paramView.findViewById(R.h.fFm));
    this.XxN = ((LinearLayout)paramView.findViewById(R.h.fFf));
    this.XxO = ((RelativeLayout)paramView.findViewById(R.h.fFe));
    this.XxP = ((WeImageView)paramView.findViewById(R.h.fJQ));
    this.XxQ = ((RelativeLayout)paramView.findViewById(R.h.fFo));
    this.XwZ = ((TextView)paramView.findViewById(R.h.fFn));
    this.Xxg = ((RelativeLayout)paramView.findViewById(R.h.fsu));
    this.Xxh = ((CheckBox)paramView.findViewById(R.h.fss));
    this.XxR = paramView.findViewById(R.h.fJK);
    this.XxS = paramView.findViewById(R.h.fJL);
    AppMethodBeat.o(265371);
  }
  
  private final void Jh(boolean paramBoolean)
  {
    AppMethodBeat.i(265380);
    if (paramBoolean)
    {
      this.XxJ.setBackgroundResource(R.g.circle_btn_brand_bg);
      this.XxK.setIconColor(this.context.getResources().getColor(R.e.BW_100_Alpha_0_8));
      this.XxL.setText(R.l.gYX);
      AppMethodBeat.o(265380);
      return;
    }
    this.XxJ.setBackgroundResource(R.g.circle_btn_bg);
    this.XxK.setIconColor(this.context.getResources().getColor(R.e.FG_0));
    this.XxL.setText(R.l.gYM);
    AppMethodBeat.o(265380);
  }
  
  private final void Ji(boolean paramBoolean)
  {
    AppMethodBeat.i(265384);
    if (this.XxG != null)
    {
      if (paramBoolean)
      {
        this.XxG.setBackgroundResource(R.g.circle_btn_bg);
        this.XxH.setIconColor(this.context.getResources().getColor(R.e.FG_0));
        AppMethodBeat.o(265384);
        return;
      }
      this.XxG.setBackgroundResource(R.g.circle_btn_brand_bg);
      this.XxH.setIconColor(this.context.getResources().getColor(R.e.BW_100_Alpha_0_8));
    }
    AppMethodBeat.o(265384);
  }
  
  private static final void S(DialogInterface paramDialogInterface, int paramInt) {}
  
  private final void a(a.a parama)
  {
    AppMethodBeat.i(265376);
    if (!Util.isNullOrNil(parama.desc))
    {
      this.Xxz.setText((CharSequence)parama.desc);
      if (parama.qvo != 1)
      {
        if (parama.qvo == 2)
        {
          if (this.wbg)
          {
            this.Xxz.setText((CharSequence)this.context.getString(R.l.gYN, new Object[] { "Mac" }));
            this.Xxy.setImageResource(R.k.icons_outlined_imac_lock);
            AppMethodBeat.o(265376);
            return;
          }
          this.Xxz.setText((CharSequence)this.context.getString(R.l.gYS, new Object[] { "Mac" }));
          this.Xxy.setImageResource(R.k.icons_outlined_imac);
          AppMethodBeat.o(265376);
          return;
        }
        if (parama.qvo == 3)
        {
          this.Xxy.setImageResource(R.k.icons_outlined_pad);
          AppMethodBeat.o(265376);
          return;
        }
        if (parama.qvo == 7)
        {
          this.Xxy.setImageResource(R.k.connect_kidwatch);
          AppMethodBeat.o(265376);
          return;
        }
        if (parama.qvo == 6)
        {
          this.Xxy.setImageResource(R.k.icons_outlined_car);
          AppMethodBeat.o(265376);
          return;
        }
        if (parama.qvo == 8)
        {
          if ((this.XxF.getVisibility() == 8) || (this.XxU))
          {
            this.Xxy.setImageResource(R.k.icons_outlined_android_pad);
            AppMethodBeat.o(265376);
            return;
          }
          this.Xxy.setImageResource(R.k.icons_outlined_android_pad);
          AppMethodBeat.o(265376);
          return;
        }
        if (parama.qvo == 10)
        {
          this.Xxy.setImageResource(R.k.icons_outlined_folder);
          AppMethodBeat.o(265376);
          return;
        }
      }
      this.Xxy.setImageResource(R.k.icons_outlined_display);
    }
    AppMethodBeat.o(265376);
  }
  
  private static final void a(a.a parama, b paramb, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(265408);
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    paramp.setHasCallbackToQueue(true);
    Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", NetSceneExtDeviceControl errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
    if (paramp == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webwx.model.NetSceneExtDeviceControl");
      AppMethodBeat.o(265408);
      throw parama;
    }
    int i = ((com.tencent.mm.plugin.webwx.model.b)paramp).hHC;
    paramString = paramb.XxT;
    if (paramString != null) {
      paramString.start();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        Toast.makeText(paramb.context, R.l.gYO, 0).show();
        AppMethodBeat.o(265408);
        return;
      }
      Toast.makeText(paramb.context, R.l.gYY, 0).show();
      AppMethodBeat.o(265408);
      return;
    }
    if (i == 1)
    {
      paramb.wbg = bool;
      com.tencent.mm.plugin.messenger.b.a.a(parama, paramb.wbg);
      paramb.a(parama);
      paramString = new StringBuilder().append(parama.qvo).append(", ");
      if (!paramb.wbg) {
        break label281;
      }
    }
    label281:
    for (parama = "lock";; parama = "unlock")
    {
      Log.d("MicroMsg.LoginDeviceAdapter", parama + " extDevice success");
      AppMethodBeat.o(265408);
      return;
      bool = false;
      break;
    }
  }
  
  private static final void a(a.a parama, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(265418);
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.plugin.messenger.b.a.a(parama, ak.oTH);
    paramDialogInterface = paramb.Xxh;
    if (!paramb.Xxh.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.setChecked(bool);
      parama.KQh = true;
      AppMethodBeat.o(265418);
      return;
    }
  }
  
  private static final void a(a.a parama, b paramb, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(265397);
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", close message notify");
    paramb.b(parama);
    AppMethodBeat.o(265397);
  }
  
  private static final void a(a.a parama, b paramb, View paramView)
  {
    AppMethodBeat.i(265393);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = new Intent();
    paramView.putExtra("rawUrl", parama.KQa + "&lang=" + LocaleUtil.getApplicationLanguage());
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", false);
    com.tencent.mm.br.c.b(paramb.context, "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265393);
  }
  
  private static final void a(a.a parama, boolean paramBoolean, b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(265404);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.fv(paramBoolean);
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", show/hide card, isShow:" + paramBoolean);
    parama = paramb.Xxr;
    if (parama != null)
    {
      if (paramBoolean) {
        paramInt = -1;
      }
      parama.apL(paramInt);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265404);
  }
  
  private static final void a(b paramb, a.a parama, Animator paramAnimator, View paramView)
  {
    AppMethodBeat.i(265412);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramAnimator);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(parama, "$onlineInfo");
    if (paramb.wbg)
    {
      paramb.XxJ.setBackgroundResource(R.g.circle_btn_bg);
      paramb.XxK.setIconColor(paramb.context.getResources().getColor(R.e.FG_0));
      Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", lockUnlockWebEx isLock:" + paramb.wbg);
      if (!paramb.wbg) {
        break label269;
      }
    }
    label269:
    for (int i = 2;; i = 1)
    {
      new com.tencent.mm.plugin.webwx.model.b(i).doScene(com.tencent.mm.kernel.h.aZW().oun, new b..ExternalSyntheticLambda9(parama, paramb));
      paramb.XxM.setVisibility(0);
      paramAnimator.start();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265412);
      return;
      paramb.XxJ.setBackgroundResource(R.g.circle_btn_brand_bg);
      paramb.XxK.setIconColor(paramb.context.getResources().getColor(R.e.BW_100_Alpha_0_8));
      break;
    }
  }
  
  private static final void a(b paramb, a.a parama, View paramView)
  {
    AppMethodBeat.i(265401);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(parama, "$onlineInfo");
    if (paramb.XxU)
    {
      paramView = new f(paramb.context, 1, true);
      paramView.h((CharSequence)paramb.context.getString(R.l.gMG), 17, com.tencent.mm.cd.a.fromDPToPix(paramb.context, 14));
      paramView.Vtg = new b..ExternalSyntheticLambda10(paramb);
      paramView.GAC = new b..ExternalSyntheticLambda11(parama, paramb);
      paramView.dDn();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265401);
      return;
      Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", open message notify");
      paramb.b(parama);
    }
  }
  
  private static final void a(b paramb, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(265395);
    kotlin.g.b.s.u(paramb, "this$0");
    params.a(0, paramb.context.getResources().getColor(a.c.red_text_color), (CharSequence)paramb.context.getString(R.l.gYL));
    AppMethodBeat.o(265395);
  }
  
  private static final void b(a.a parama, b paramb, View paramView)
  {
    AppMethodBeat.i(265423);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    boolean bool;
    if (parama.KQh)
    {
      com.tencent.mm.plugin.messenger.b.a.a(parama, ak.oTG);
      parama.KQh = false;
      parama = paramb.Xxh;
      if (!paramb.Xxh.isChecked())
      {
        bool = true;
        parama.setChecked(bool);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265423);
      return;
      bool = false;
      break;
      k.b(paramb.context, Util.nullAs(parama.KQb, paramb.context.getString(R.l.gYP)), paramb.context.getString(R.l.gYR), paramb.context.getString(R.l.gYQ), paramb.context.getString(R.l.app_cancel), new b..ExternalSyntheticLambda0(parama, paramb), b..ExternalSyntheticLambda1.INSTANCE);
    }
  }
  
  private static final void b(b paramb, a.a parama, View paramView)
  {
    AppMethodBeat.i(265416);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(parama, "$onlineInfo");
    paramView = new Intent();
    paramView.putExtra("Chat_User", "filehelper");
    paramView.putExtra("key_show_bottom_app_panel", true);
    com.tencent.mm.plugin.webwx.a.pFn.d(paramView, paramb.context);
    Log.d("MicroMsg.LoginDeviceAdapter", parama.qvo + ", clicked file transfer bt, start filehelper");
    paramb = paramb.Xxr;
    if (paramb != null) {
      paramb.dmh();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265416);
  }
  
  private final boolean b(a.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(265388);
    if (!bh.baz())
    {
      AppMethodBeat.o(265388);
      return false;
    }
    if (!this.XxU) {
      bool = true;
    }
    this.XxU = bool;
    Ji(this.XxU);
    int i = z.bAU();
    if (this.XxU) {
      i |= 0x2000;
    }
    for (;;)
    {
      com.tencent.mm.k.h.rj(i);
      bh.bCz();
      com.tencent.mm.model.c.ban().B(40, Integer.valueOf(i));
      a locala = this.Xxr;
      if (locala != null) {
        locala.iDz();
      }
      a(parama);
      parama = this.Xxr;
      if (parama != null) {
        parama.notifyDataSetChanged();
      }
      AppMethodBeat.o(265388);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private static final void c(a.a parama, b paramb, View paramView)
  {
    AppMethodBeat.i(265426);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$onlineInfo");
    kotlin.g.b.s.u(paramb, "this$0");
    Log.d("MicroMsg.LoginDeviceAdapter", parama.qvo + ", logout webwx");
    paramb = paramb.Xxr;
    if (paramb != null)
    {
      int i = parama.abcm;
      int j = parama.YMr;
      parama = parama.KPW;
      kotlin.g.b.s.s(parama, "onlineInfo.exitConfirm");
      paramb.Y(i, j, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265426);
  }
  
  public final void a(a.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(265461);
    kotlin.g.b.s.u(parama, "onlineInfo");
    label83:
    int i;
    label96:
    float f;
    if ((parama.qvo == 6) && (!Util.isNullOrNil(parama.KQa)))
    {
      this.XxA.setVisibility(0);
      this.XxA.setOnClickListener(new b..ExternalSyntheticLambda2(parama, this));
      if ((com.tencent.mm.k.h.aQF()) && (!parama.KQd)) {
        break label596;
      }
      this.XxF.setVisibility(8);
      this.XxU = false;
      Object localObject = this.XxC;
      if (!paramBoolean) {
        break label630;
      }
      i = 0;
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.XxB;
      if (!paramBoolean) {
        break label637;
      }
      f = 270.0F;
      label118:
      ((WeImageView)localObject).setRotation(f);
      this.Xxx.setOnClickListener(new b..ExternalSyntheticLambda5(parama, paramBoolean, this, paramInt));
      Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", need hide lock bt : " + parama.KQc + ", isLock:" + this.wbg + ", isWebWXLocked:" + parama.KQf);
      if (parama.KQc) {
        break label645;
      }
      this.XxI.setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this.context, R.b.fade_in_property_anim);
      ((Animator)localObject).setTarget(this.XxM);
      Animator localAnimator = AnimatorInflater.loadAnimator(this.context, R.b.fade_out_property_anim);
      localAnimator.setTarget(this.XxM);
      localAnimator.addListener((Animator.AnimatorListener)new b(this));
      ah localah = ah.aiuX;
      this.XxT = localAnimator;
      this.wbg = parama.KQf;
      Jh(this.wbg);
      this.XxJ.setOnClickListener(new b..ExternalSyntheticLambda8(this, parama, (Animator)localObject));
      label323:
      Log.i("MicroMsg.LoginDeviceAdapter", parama.qvo + ", need hide file bt:" + parama.KQe);
      if (parama.KQe) {
        break label657;
      }
      this.XxN.setVisibility(0);
      this.XxO.setOnClickListener(new b..ExternalSyntheticLambda6(this, parama));
      label390:
      if ((this.XxF.getVisibility() != 0) || (this.XxI.getVisibility() != 0) || (this.XxN.getVisibility() != 0)) {
        break label669;
      }
      this.XxR.setVisibility(0);
      this.XxS.setVisibility(0);
      label436:
      if (!parama.KQg) {
        break label1047;
      }
      this.Xxg.setVisibility(0);
      this.Xxh.setChecked(parama.KQh);
      this.Xxg.setOnClickListener(new b..ExternalSyntheticLambda4(parama, this));
      label478:
      if ((this.XxF.getVisibility() != 8) || (this.XxI.getVisibility() != 8) || (this.XxN.getVisibility() != 8)) {
        break label1059;
      }
      this.XxD.setVisibility(8);
      this.XxE.setVisibility(8);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(parama.KPZ)) {
        this.XwZ.setText((CharSequence)parama.KPZ);
      }
      this.XxQ.setOnClickListener(new b..ExternalSyntheticLambda3(parama, this));
      a(parama);
      AppMethodBeat.o(265461);
      return;
      this.XxA.setVisibility(8);
      break;
      label596:
      this.XxU = z.aRx();
      Ji(this.XxU);
      this.XxG.setOnClickListener(new b..ExternalSyntheticLambda7(this, parama));
      break label83;
      label630:
      i = 8;
      break label96;
      label637:
      f = 90.0F;
      break label118;
      label645:
      this.XxI.setVisibility(8);
      break label323;
      label657:
      this.XxN.setVisibility(8);
      break label390;
      label669:
      if ((this.XxF.getVisibility() == 8) && (this.XxI.getVisibility() == 8) && (this.XxN.getVisibility() == 8))
      {
        this.XxR.setVisibility(8);
        this.XxS.setVisibility(8);
        break label436;
      }
      if ((this.XxF.getVisibility() == 8) && (this.XxI.getVisibility() == 0) && (this.XxN.getVisibility() == 0))
      {
        this.XxR.setVisibility(8);
        this.XxS.setVisibility(0);
        break label436;
      }
      if ((this.XxF.getVisibility() == 0) && (this.XxI.getVisibility() == 8) && (this.XxN.getVisibility() == 0))
      {
        this.XxR.setVisibility(8);
        this.XxS.setVisibility(0);
        break label436;
      }
      if ((this.XxF.getVisibility() == 0) && (this.XxI.getVisibility() == 0) && (this.XxN.getVisibility() == 8))
      {
        this.XxR.setVisibility(0);
        this.XxS.setVisibility(8);
        break label436;
      }
      if ((this.XxF.getVisibility() == 0) && (this.XxI.getVisibility() == 8) && (this.XxN.getVisibility() == 8))
      {
        this.XxR.setVisibility(8);
        this.XxS.setVisibility(8);
        break label436;
      }
      if ((this.XxF.getVisibility() == 8) && (this.XxI.getVisibility() == 0) && (this.XxN.getVisibility() == 8))
      {
        this.XxR.setVisibility(8);
        this.XxS.setVisibility(8);
        break label436;
      }
      if ((this.XxF.getVisibility() != 8) || (this.XxI.getVisibility() != 8) || (this.XxN.getVisibility() != 0)) {
        break label436;
      }
      this.XxR.setVisibility(8);
      this.XxS.setVisibility(8);
      break label436;
      label1047:
      this.Xxg.setVisibility(8);
      break label478;
      label1059:
      this.XxD.setVisibility(0);
      this.XxE.setVisibility(0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "", "finishUI", "", "logoutDevice", "targetDeviceType", "", "targetClientVersion", "exitConfirm", "", "notifyDataSetChanged", "showPos", "setNeedSync", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Y(int paramInt1, int paramInt2, String paramString);
    
    public abstract void apL(int paramInt);
    
    public abstract void dmh();
    
    public abstract void iDz();
    
    public abstract void notifyDataSetChanged();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$fillContent$4$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(265350);
      kotlin.g.b.s.u(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      b.a(this.XxV, b.a(this.XxV));
      AppMethodBeat.o(265350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.b
 * JD-Core Version:    0.7.0.1
 */