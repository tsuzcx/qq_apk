package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WelabAppInfoUI
  extends MMActivity
{
  private String cwc;
  private MMSwitchBtn iDy;
  private TextView iQE;
  private Button mzM;
  private TextView pAD;
  private TextView titleTv;
  private com.tencent.mm.plugin.welab.d.a.a vvj;
  private int vvk;
  private boolean vvl;
  private WelabRoundCornerImageView vvm;
  private RecyclerView vvn;
  private View vvo;
  private View vvp;
  private View vvq;
  private View vvr;
  private a vvs;
  private View.OnClickListener vvt;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(80607);
    this.vvt = new WelabAppInfoUI.5(this);
    AppMethodBeat.o(80607);
  }
  
  private void dhA()
  {
    AppMethodBeat.i(80614);
    Object localObject2 = this.vvj.ajA("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.vvj.ajA("field_ImgUrl");
    }
    localObject1 = f.ajv((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.vvn.setVisibility(8);
      AppMethodBeat.o(80614);
      return;
    }
    this.vvn.setVisibility(0);
    this.vvs.kQw = ((List)localObject1);
    this.vvs.ajb.notifyChanged();
    AppMethodBeat.o(80614);
  }
  
  private String dhz()
  {
    AppMethodBeat.i(80613);
    String str = "switch_" + this.vvj.field_LabsAppId;
    AppMethodBeat.o(80613);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130971314;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80609);
    super.initView();
    if (this.vvj == null)
    {
      ab.e("WelabAppInfoUI", "info is null");
      AppMethodBeat.o(80609);
      return;
    }
    setMMTitleVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(201326592);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(getResources().getColor(2131690708));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131690708));
    }
    setBackBtn(new WelabAppInfoUI.1(this));
    this.vvm = ((WelabRoundCornerImageView)findViewById(2131829567));
    this.titleTv = ((TextView)findViewById(2131820680));
    this.pAD = ((TextView)findViewById(2131821890));
    this.vvn = ((RecyclerView)findViewById(2131829571));
    this.vvo = findViewById(2131829572);
    this.mzM = ((Button)findViewById(2131824114));
    this.vvp = findViewById(2131829574);
    this.iDy = ((MMSwitchBtn)findViewById(2131820950));
    this.iQE = ((TextView)findViewById(2131829573));
    this.vvq = findViewById(2131829569);
    this.vvr = findViewById(2131829570);
    this.vvn.setLayoutManager(new LinearLayoutManager(0));
    this.vvn.setOverScrollMode(2);
    this.vvs = new a();
    this.vvn.setAdapter(this.vvs);
    AppMethodBeat.o(80609);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(80608);
    super.onCreate(paramBundle);
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.cwc = paramBundle.getStringExtra("para_appid");
      this.vvj = com.tencent.mm.plugin.welab.a.dhl().ajs(this.cwc);
      this.vvk = this.vvj.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.vvl = bool;
      initView();
      d.t(this.cwc, 2, this.vvl);
      AppMethodBeat.o(80608);
      return;
      label110:
      bool = false;
    }
  }
  
  public void onPause()
  {
    int i = 0;
    AppMethodBeat.i(80611);
    super.onPause();
    Object localObject;
    if (this.vvk != this.vvj.field_Switch)
    {
      ab.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.dhl().vuT.update(this.vvj, new String[0])), Integer.valueOf(this.vvk), Integer.valueOf(this.vvj.field_Switch) });
      this.vvk = this.vvj.field_Switch;
      localObject = new azh();
      azg localazg = new azg();
      if (!this.vvj.dhx()) {
        break label268;
      }
      localazg.xoD = i;
      localazg.xoE = this.vvj.field_LabsAppId;
      if (this.vvj.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localazg.wzE = i;
      ((azh)localObject).elu.add(localazg);
      localObject = new j.a(207, (com.tencent.mm.bv.a)localObject);
      ((j)g.E(j.class)).Yz().c((j.b)localObject);
      localObject = this.cwc;
      if (this.vvj.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      d.t((String)localObject, i, this.vvl);
      if (this.vvj.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.vvj);
        com.tencent.mm.plugin.welab.a.dhl();
        com.tencent.mm.plugin.welab.a.ej((List)localObject);
      }
      AppMethodBeat.o(80611);
      return;
      i = bo.apV(this.vvj.field_expId);
      break;
      i = 2;
      break label150;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80612);
    super.onResume();
    Object localObject;
    if ((this.vvj.dhv()) && (this.vvj.field_Type == 1))
    {
      this.vvo.setVisibility(0);
      this.iQE.setText(getResources().getString(2131305954) + this.vvj.ajA("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.iDy.setEnabled(true);
      if (this.vvj.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(dhz(), true).commit();
        this.iDy.setCheck(true);
        this.iDy.setSwitchListener(new WelabAppInfoUI.2(this));
        label175:
        if (!this.vvj.dhv()) {
          break label454;
        }
        this.mzM.setText(getResources().getString(2131305952) + this.vvj.ajA("field_Title"));
        if (this.vvj.field_Type == 1) {
          break label454;
        }
        this.mzM.setVisibility(0);
        this.mzM.setOnClickListener(new WelabAppInfoUI.3(this));
        label262:
        localObject = this.titleTv;
        com.tencent.mm.plugin.welab.a.dhl();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.vvj));
        this.pAD.setText(this.vvj.ajA("field_Introduce"));
        if (!this.vvj.dhv()) {
          break label466;
        }
        this.vvp.setVisibility(0);
        this.vvp.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.vvj.dhv()) {
          break label478;
        }
        this.vvq.setVisibility(8);
        this.vvr.setVisibility(0);
      }
    }
    for (;;)
    {
      dhA();
      this.vvm.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.at.a.a.ahM();
      com.tencent.mm.plugin.welab.a.dhl();
      ((com.tencent.mm.at.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.vvj), this.vvm, com.tencent.mm.plugin.welab.a.dhl().uMJ);
      AppMethodBeat.o(80612);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(dhz(), false).commit();
      this.iDy.setCheck(false);
      break;
      this.vvo.setVisibility(8);
      break label175;
      label454:
      this.mzM.setVisibility(8);
      break label262;
      label466:
      this.vvp.setVisibility(8);
      break label332;
      label478:
      this.vvq.setVisibility(0);
      this.vvr.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<WelabAppInfoUI.b>
  {
    public List<String> kQw;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(80604);
      int i = this.kQw.size();
      AppMethodBeat.o(80604);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */