package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public final class HomeUI
  implements LauncherUI.b, LauncherUI.c, LauncherUI.d
{
  public static Boolean uKb = Boolean.valueOf(false);
  public static Boolean uKc = Boolean.valueOf(false);
  private String bUU = null;
  View contentView;
  private boolean fht = true;
  LayoutInflater fhz;
  private long kKP = 0L;
  ActionBar mActionBar;
  com.tencent.mm.sdk.b.c nQu = new HomeUI.4(this);
  boolean nST = true;
  private int oFs = 0;
  private final long peu = 300L;
  private long pev = SystemClock.elapsedRealtime();
  private View ppQ;
  MMFragmentActivity uJA;
  private final long uJT = 604800000L;
  public boolean uJU = false;
  boolean uJV;
  public boolean uJW = false;
  private String uJX;
  private String uJY;
  private String uJZ;
  af uKa;
  private final long uKd = 432000000L;
  private final long uKe = 604800000L;
  HomeUI.a uKf = HomeUI.a.uKz;
  LauncherUI.a uKg;
  j uKh;
  public z uKi = new z();
  View.OnLayoutChangeListener uKj = new HomeUI.22(this);
  private boolean uKk = x.cqF();
  View uKl;
  ImageView uKm;
  View uKn;
  MenuItem uKo;
  MenuItem uKp;
  MessageQueue.IdleHandler uKq = new HomeUI.6(this);
  Runnable uKr = new HomeUI.7(this);
  private LinkedList<Runnable> uKs = new LinkedList();
  o uKt = new HomeUI.19(this);
  private final HashMap<String, Object> values = new HashMap();
  
  private void mO(final boolean paramBoolean)
  {
    if (this.ppQ != null)
    {
      y.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      return;
    }
    this.ppQ = View.inflate(com.tencent.mm.sdk.platformtools.ae.getContext(), R.i.new_user_tutorial, null);
    Object localObject = (TextView)this.ppQ.findViewById(R.h.new_user_guide_tips);
    if (paramBoolean) {
      ((TextView)localObject).setText(com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.add_friend_here));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.ppQ.setBackgroundResource(R.g.ofm_pop_up_bg);
      if (this.contentView == null) {
        break;
      }
      ((ViewGroup)this.contentView).addView(this.ppQ, (ViewGroup.LayoutParams)localObject);
      localObject = AnimationUtils.loadAnimation(com.tencent.mm.sdk.platformtools.ae.getContext(), R.a.shake_y);
      this.ppQ.startAnimation((Animation)localObject);
      this.ppQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          HomeUI.e(HomeUI.this).fy();
          if (paramBoolean)
          {
            HomeUI.a(HomeUI.this, Boolean.valueOf(true), Boolean.valueOf(true));
            return;
          }
          HomeUI.a(HomeUI.this, Boolean.valueOf(true), Boolean.valueOf(false));
        }
      });
      return;
      ((TextView)localObject).setText(com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.add_chatroom_here));
    }
  }
  
  private void updateTitle()
  {
    Object localObject2 = getString(R.l.app_name);
    Object localObject1 = localObject2;
    if (com.tencent.mm.protocal.d.spd)
    {
      if (this.uKk) {
        localObject1 = (String)localObject2 + getString(R.l.alpha_version_alpha);
      }
    }
    else
    {
      if (this.uKi.czL() <= 0) {
        break label232;
      }
      localObject2 = localObject1;
      if (!this.uKk) {
        localObject2 = (String)localObject1 + " ";
      }
      localObject1 = (String)localObject2 + "(" + this.uKi.czL() + ")";
    }
    label232:
    for (;;)
    {
      localObject2 = (TextView)this.mActionBar.getCustomView().findViewById(16908308);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setTextSize(0, com.tencent.mm.cb.a.ab(com.tencent.mm.sdk.platformtools.ae.getContext(), R.f.ActionBarTextSize) * com.tencent.mm.cb.a.ff(com.tencent.mm.sdk.platformtools.ae.getContext()));
        if (this.nST) {
          ((TextView)localObject2).setTextColor(this.uJA.getResources().getColor(R.e.white_text_color));
        }
      }
      return;
      localObject1 = (String)localObject2 + " " + getString(R.l.alpha_version_alpha);
      break;
    }
  }
  
  public final void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    this.uJA.getWindow().getDecorView().getBottom();
    this.uJA.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
  }
  
  public final void ah(Runnable paramRunnable)
  {
    this.uKs.remove(paramRunnable);
  }
  
  final void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (this.ppQ != null)
    {
      this.ppQ.clearAnimation();
      this.ppQ.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label79;
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().o(340227, Boolean.valueOf(true));
        h.nFQ.a(232L, 0L, 1L, false);
        uKb = Boolean.valueOf(false);
      }
    }
    for (;;)
    {
      this.ppQ = null;
      return;
      label79:
      au.Hx();
      com.tencent.mm.model.c.Dz().o(340230, Boolean.valueOf(true));
      h.nFQ.a(232L, 5L, 1L, false);
      uKc = Boolean.valueOf(false);
    }
  }
  
  final void cxK()
  {
    this.uJA.moveTaskToBack(true);
    if (au.DK()) {
      au.DS().k(new HomeUI.13(this), 500L);
    }
    m localm = m.sZ();
    localm.bwW = false;
    localm.bwX.removeMessages(-1999);
    localm.bwX.removeMessages(-2999);
    localm.bwX.sendEmptyMessageDelayed(-1999, 3000L);
    localm.bwX.sendEmptyMessageDelayed(-2999, 30000L);
  }
  
  final void cyD()
  {
    if (!au.DK()) {
      y.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
    }
    Boolean localBoolean;
    long l1;
    long l2;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      return;
      au.Hx();
      localBoolean = Boolean.valueOf(com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Dz().get(340227, null)));
      if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.k.vLk.booleanValue()))
      {
        uKb = Boolean.valueOf(true);
        mO(true);
      }
      l1 = System.currentTimeMillis();
      au.Hx();
      l2 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Dz().get(340240, null));
      au.Hx();
      bool1 = com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Dz().get(340230, null));
      au.Hx();
      bool2 = com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Dz().get(340228, null));
      au.Hx();
      bool3 = com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Dz().get(340229, null));
    } while ((!localBoolean.booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()) || (!Boolean.valueOf(bool3).booleanValue()) || (Boolean.valueOf(bool1).booleanValue()) || (l1 - l2 < 432000000L));
    uKc = Boolean.valueOf(true);
    mO(false);
  }
  
  final void cyE()
  {
    if ((this.uKa == null) || (!au.DK())) {
      return;
    }
    if (this.uKa.isShowing())
    {
      this.uKa.dismiss();
      return;
    }
    this.uKa.fy();
  }
  
  final void cyF()
  {
    if (!((n)g.t(n.class)).isFTSIndexReady())
    {
      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), R.l.search_index_not_ready_toast, 0).show();
      return;
    }
    int i = this.uKi.jVi;
    if (i == 0) {
      ((com.tencent.mm.ui.conversation.k)this.uKi.czH()).A(500L, 5);
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Bundle localBundle = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localBundle = ActivityOptions.makeSceneTransitionAnimation(this.uJA, new Pair[0]).toBundle();
    }
    com.tencent.mm.plugin.fts.a.d.b(this.uJA, ".ui.FTSMainUI", localIntent, localBundle);
  }
  
  public final void cyG()
  {
    au.DS().crc();
    this.uKi.czM();
    ai.d(this.uKr);
  }
  
  public final boolean cyH()
  {
    return this.uKf == HomeUI.a.uKA;
  }
  
  public final void cyI()
  {
    updateTitle();
  }
  
  public final void cyJ()
  {
    this.uKi.cyJ();
  }
  
  public final String getString(int paramInt)
  {
    return this.uJA.getString(paramInt);
  }
  
  final void initActionBar()
  {
    if (this.uKg.czd())
    {
      y.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      return;
    }
    y.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground False!");
    this.mActionBar.setLogo(new ColorDrawable(this.uJA.getResources().getColor(17170445)));
    this.mActionBar.dZ();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.dY();
    this.mActionBar.ea();
    this.mActionBar.setCustomView(com.tencent.mm.kiss.a.b.ED().a(this.uJA, "R.layout.actionbar_title_launcher", R.i.actionbar_title_launcher));
    Object localObject = (ImageView)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn);
    if ((localObject != null) && (this.nST)) {
      ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    int i;
    if (this.nST)
    {
      i = R.e.dark_actionbar_color;
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uJA.getResources().getColor(i)));
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = this.uJA.getResources().getColor(i);
        this.uJA.getWindow().setStatusBarColor(i);
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = this.uJA.getWindow().getDecorView();
          i = ((View)localObject).getSystemUiVisibility();
          if (!this.nST) {
            break label294;
          }
          i &= 0xFFFFDFFF;
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setSystemUiVisibility(i);
      updateTitle();
      this.mActionBar.getCustomView().findViewById(R.h.actionbar_title_launcher_container).setOnClickListener(new HomeUI.8(this));
      return;
      i = R.e.normal_actionbar_color;
      break;
      label294:
      i |= 0x2000;
    }
  }
  
  final void mP(boolean paramBoolean)
  {
    if ((this.uKa == null) || (this.uKl == null)) {
      return;
    }
    if (!au.DK())
    {
      y.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      return;
    }
    this.uKa.uQp.mW(paramBoolean);
    if (this.uKa.uQp.uQi > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.uKn.setVisibility(0);
      return;
    }
    this.uKn.setVisibility(8);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    if (!this.uKs.contains(paramRunnable)) {
      this.uKs.add(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */