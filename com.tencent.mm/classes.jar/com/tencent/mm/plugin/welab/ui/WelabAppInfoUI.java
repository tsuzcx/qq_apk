package com.tencent.mm.plugin.welab.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.welab.a.a;
import com.tencent.mm.plugin.welab.a.b;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WelabAppInfoUI
  extends MMActivity
{
  private String bOL;
  private TextView eXr;
  private TextView hfq;
  private Button kfd;
  private MMSwitchBtn lAy;
  private TextView mXQ;
  private com.tencent.mm.plugin.welab.c.a.a rEA;
  private int rEB;
  private boolean rEC;
  private WelabRoundCornerImageView rED;
  private RecyclerView rEE;
  private View rEF;
  private View rEG;
  private View rEH;
  private View rEI;
  private WelabAppInfoUI.a rEJ;
  private View.OnClickListener rEK = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Object localObject = paramAnonymousView.getTag().toString();
      paramAnonymousView = new Intent();
      paramAnonymousView.putExtra("nowUrl", (String)localObject);
      paramAnonymousView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(WelabAppInfoUI.this).getAdapter()).iJQ.toArray(new String[0]));
      localObject = WelabAppInfoUI.this;
      Intent localIntent = new Intent();
      localIntent.putExtras(paramAnonymousView.getExtras());
      if (paramAnonymousView.getFlags() != 0) {
        localIntent.addFlags(paramAnonymousView.getFlags());
      }
      d.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
    }
  };
  
  private String chn()
  {
    return "switch_" + this.rEA.field_LabsAppId;
  }
  
  private void cho()
  {
    Object localObject2 = this.rEA.Um("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.rEA.Um("field_ImgUrl");
    }
    localObject1 = com.tencent.mm.plugin.welab.g.Ui((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.rEE.setVisibility(8);
      return;
    }
    this.rEE.setVisibility(0);
    this.rEJ.iJQ = ((List)localObject1);
    this.rEJ.agL.notifyChanged();
  }
  
  protected final int getLayoutId()
  {
    return a.c.welab_appinfo;
  }
  
  protected final void initView()
  {
    super.initView();
    if (this.rEA == null)
    {
      y.e("WelabAppInfoUI", "info is null");
      return;
    }
    FP(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(201326592);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(getResources().getColor(a.a.welab_main_color));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(a.a.welab_main_color));
    }
    setBackBtn(new WelabAppInfoUI.1(this));
    this.rED = ((WelabRoundCornerImageView)findViewById(a.b.app_img));
    this.eXr = ((TextView)findViewById(a.b.title));
    this.mXQ = ((TextView)findViewById(a.b.summary));
    this.rEE = ((RecyclerView)findViewById(a.b.img_recyclerview));
    this.rEF = findViewById(a.b.app_switch);
    this.kfd = ((Button)findViewById(a.b.open_btn));
    this.rEG = findViewById(a.b.feedback_btn);
    this.lAy = ((MMSwitchBtn)findViewById(a.b.checkbox));
    this.hfq = ((TextView)findViewById(a.b.switch_desc));
    this.rEH = findViewById(a.b.stopped_warning_tv);
    this.rEI = findViewById(a.b.online_view_container);
    this.rEE.setLayoutManager(new LinearLayoutManager(0));
    this.rEE.setOverScrollMode(2);
    this.rEJ = new WelabAppInfoUI.a(this);
    this.rEE.setAdapter(this.rEJ);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    mS(true);
    czo();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.bOL = paramBundle.getStringExtra("para_appid");
      this.rEA = b.chc().Uf(this.bOL);
      this.rEB = this.rEA.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label98;
      }
    }
    for (;;)
    {
      this.rEC = bool;
      initView();
      e.q(this.bOL, 2, this.rEC);
      return;
      label98:
      bool = false;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Object localObject;
    if (this.rEB != this.rEA.field_Switch)
    {
      b.chc().rEr.c(this.rEA, new String[0]);
      localObject = new ate();
      atd localatd = new atd();
      localatd.toJ = bk.ZR(this.rEA.field_expId);
      localatd.toK = this.rEA.field_LabsAppId;
      if (this.rEA.field_Switch != 2) {
        break label164;
      }
      i = 1;
      localatd.sYX = i;
      ((ate)localObject).dtH.add(localatd);
      localObject = new i.a(207, (com.tencent.mm.bv.a)localObject);
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b((i.b)localObject);
      localObject = this.bOL;
      if (this.rEA.field_Switch != 2) {
        break label169;
      }
    }
    label164:
    label169:
    for (int i = 4;; i = 5)
    {
      e.q((String)localObject, i, this.rEC);
      return;
      i = 2;
      break;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject;
    if ((this.rEA.chm()) && (this.rEA.field_Type == 1))
    {
      this.rEF.setVisibility(0);
      this.hfq.setText(getResources().getString(a.d.welab_open) + this.rEA.Um("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.lAy.setEnabled(true);
      if (this.rEA.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(chn(), true).commit();
        this.lAy.setCheck(true);
        this.lAy.setSwitchListener(new WelabAppInfoUI.2(this));
        label169:
        if (!this.rEA.chm()) {
          break label442;
        }
        this.kfd.setText(getResources().getString(a.d.welab_goto) + this.rEA.Um("field_Title"));
        if (this.rEA.field_Type == 1) {
          break label442;
        }
        this.kfd.setVisibility(0);
        this.kfd.setOnClickListener(new WelabAppInfoUI.3(this));
        label256:
        localObject = this.eXr;
        b.chc();
        ((TextView)localObject).setText(b.a(this.rEA));
        this.mXQ.setText(this.rEA.Um("field_Introduce"));
        if (!this.rEA.chm()) {
          break label454;
        }
        this.rEG.setVisibility(0);
        this.rEG.setOnClickListener(new WelabAppInfoUI.4(this));
        label326:
        if (!this.rEA.chm()) {
          break label466;
        }
        this.rEH.setVisibility(8);
        this.rEI.setVisibility(0);
      }
    }
    for (;;)
    {
      cho();
      this.rED.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.as.a.a.OT();
      b.chc();
      ((com.tencent.mm.as.a.a)localObject).a(b.b(this.rEA), this.rED, b.chc().qXu);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(chn(), false).commit();
      this.lAy.setCheck(false);
      break;
      this.rEF.setVisibility(8);
      break label169;
      label442:
      this.kfd.setVisibility(8);
      break label256;
      label454:
      this.rEG.setVisibility(8);
      break label326;
      label466:
      this.rEH.setVisibility(0);
      this.rEI.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */