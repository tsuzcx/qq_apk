package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.a;

public class WcPayRealnameVerifyIdInputUI
  extends WalletBaseUI
{
  private static final int udk;
  private Button gJr;
  private Profession[] mProfessions;
  private WalletFormView qgy;
  private WalletFormView ucX;
  private WalletFormView ucY;
  private WalletFormView udl;
  private WalletFormView udm;
  private WalletFormView udn;
  private WalletFormView udo;
  private WalletFormView udp;
  private WalletFormView udq;
  private com.tencent.mm.ui.widget.picker.b udr;
  private WcPayRealnameVerifyIdInputUI.VM uds;
  private String udt;
  private String[] udu;
  private String[] udv;
  
  static
  {
    AppMethodBeat.i(142455);
    udk = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 88);
    AppMethodBeat.o(142455);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(142444);
    this.udv = new String[100];
    int i = 0;
    while (i < this.udv.length)
    {
      this.udv[i] = ah.getContext().getString(2131305028, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    AppMethodBeat.o(142444);
  }
  
  private void Iw(int paramInt)
  {
    AppMethodBeat.i(142450);
    ab.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "change cre type: %s", new Object[] { Integer.valueOf(paramInt) });
    String[] arrayOfString = getResources().getStringArray(2131755068);
    this.udm.setText("");
    com.tencent.mm.wallet_core.ui.formview.a.b localb = this.udm.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).RY(paramInt);
    }
    this.uds.reset();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142450);
      return;
      this.udl.setText(arrayOfString[0]);
      setEditFocusListener(this.udm, 1, false, false);
      this.udm.setVisibility(0);
      this.udn.setVisibility(8);
      this.udo.setVisibility(8);
      this.udq.setVisibility(8);
      this.udp.setVisibility(8);
      AppMethodBeat.o(142450);
      return;
      this.udl.setText(arrayOfString[3]);
      setEditFocusListener(this.udm, 1, true, false);
      this.udm.setVisibility(0);
      this.udn.setVisibility(8);
      this.udo.setVisibility(8);
      this.udq.setVisibility(8);
      this.udp.setVisibility(0);
      AppMethodBeat.o(142450);
      return;
      this.udl.setText(arrayOfString[1]);
      setEditFocusListener(this.udm, 1, true, false);
      this.udm.setVisibility(0);
      this.udn.setVisibility(0);
      this.udo.setVisibility(0);
      this.udq.setVisibility(8);
      this.udp.setVisibility(8);
      AppMethodBeat.o(142450);
      return;
      this.udl.setText(arrayOfString[2]);
      setEditFocusListener(this.udm, 1, true, false);
      this.udm.setVisibility(0);
      this.udn.setVisibility(0);
      this.udo.setVisibility(0);
      this.udq.setVisibility(0);
      this.udp.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2130971285;
  }
  
  public void initView()
  {
    AppMethodBeat.i(142446);
    this.qgy = ((WalletFormView)findViewById(2131829495));
    this.udl = ((WalletFormView)findViewById(2131829496));
    this.udm = ((WalletFormView)findViewById(2131829497));
    this.udn = ((WalletFormView)findViewById(2131829498));
    this.udo = ((WalletFormView)findViewById(2131829499));
    this.udp = ((WalletFormView)findViewById(2131829501));
    this.udq = ((WalletFormView)findViewById(2131829500));
    this.ucX = ((WalletFormView)findViewById(2131829502));
    this.ucY = ((WalletFormView)findViewById(2131829503));
    this.gJr = ((Button)findViewById(2131829504));
    this.qgy.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.qgy.a(new WcPayRealnameVerifyIdInputUI.1(this));
    this.udl.setOnClickListener(new WcPayRealnameVerifyIdInputUI.12(this));
    this.udl.getInfoIv().setClickable(false);
    Iw(1);
    com.tencent.mm.wallet_core.ui.formview.a.d(this.udm);
    this.udm.a(new WcPayRealnameVerifyIdInputUI.13(this));
    this.udn.setOnClickListener(new WcPayRealnameVerifyIdInputUI.14(this));
    this.udn.getInfoIv().setClickable(false);
    this.udo.setOnClickListener(new WcPayRealnameVerifyIdInputUI.15(this));
    this.udo.getInfoIv().setClickable(false);
    this.udq.setOnClickListener(new WcPayRealnameVerifyIdInputUI.16(this));
    this.udq.getInfoIv().setClickable(false);
    this.udp.setOnClickListener(new WcPayRealnameVerifyIdInputUI.17(this));
    this.udp.getInfoIv().setClickable(false);
    this.ucX.setOnClickListener(new WcPayRealnameVerifyIdInputUI.18(this));
    this.ucX.getInfoIv().setClickable(false);
    this.ucY.setOnClickListener(new WcPayRealnameVerifyIdInputUI.19(this));
    this.ucY.getInfoIv().setClickable(false);
    this.gJr.setOnClickListener(new WcPayRealnameVerifyIdInputUI.2(this));
    this.uds.udH.observe(this, new WcPayRealnameVerifyIdInputUI.3(this));
    this.uds.udF.observe(this, new WcPayRealnameVerifyIdInputUI.4(this));
    this.uds.udO.observe(this, new WcPayRealnameVerifyIdInputUI.5(this));
    this.uds.udP.observe(this, new Observer() {});
    this.uds.udQ.observe(this, new WcPayRealnameVerifyIdInputUI.7(this));
    this.uds.udL.observe(this, new WcPayRealnameVerifyIdInputUI.8(this));
    this.uds.udS.observe(this, new Observer() {});
    this.uds.udM.observe(this, new WcPayRealnameVerifyIdInputUI.10(this));
    this.uds.udN.observe(this, new WcPayRealnameVerifyIdInputUI.11(this));
    AppMethodBeat.o(142446);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(142449);
    String str1;
    Object localObject1;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        Object localObject2 = paramIntent.getStringExtra("CountryName");
        String str2 = paramIntent.getStringExtra("ProviceName");
        String str3 = paramIntent.getStringExtra("CityName");
        str1 = paramIntent.getStringExtra("Country");
        localObject1 = paramIntent.getStringExtra("Contact_Province");
        paramIntent = paramIntent.getStringExtra("Contact_City");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!bo.isNullOrNil((String)localObject2))
        {
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" ");
        }
        if (!bo.isNullOrNil(str2))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(" ");
        }
        if (!bo.isNullOrNil(str3)) {
          localStringBuilder.append(str3);
        }
        localObject2 = this.uds;
        str2 = localStringBuilder.toString();
        ((WcPayRealnameVerifyIdInputUI.VM)localObject2).udI.setValue(str1);
        ((WcPayRealnameVerifyIdInputUI.VM)localObject2).udJ.setValue(localObject1);
        ((WcPayRealnameVerifyIdInputUI.VM)localObject2).udK.setValue(paramIntent);
        ((WcPayRealnameVerifyIdInputUI.VM)localObject2).udL.setValue(str2);
        AppMethodBeat.o(142449);
        return;
      }
      ab.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
      AppMethodBeat.o(142449);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        paramIntent = (Profession)paramIntent.getParcelableExtra("key_select_profession");
        this.uds.udM.setValue(paramIntent);
        AppMethodBeat.o(142449);
        return;
      }
      ab.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
      AppMethodBeat.o(142449);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == 100))
    {
      if (!bo.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        str1 = paramIntent.getStringExtra("iso_code");
        paramIntent = paramIntent.getStringExtra("country_name");
        localObject1 = this.uds;
        ((WcPayRealnameVerifyIdInputUI.VM)localObject1).udR.setValue(str1);
        ((WcPayRealnameVerifyIdInputUI.VM)localObject1).udS.setValue(paramIntent);
      }
      AppMethodBeat.o(142449);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(142449);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142445);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    setMMTitle("");
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.uds = ((WcPayRealnameVerifyIdInputUI.VM)ViewModelProviders.of(this).get(WcPayRealnameVerifyIdInputUI.VM.class));
    initView();
    ab.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
    doSceneForceProgress(new g());
    AppMethodBeat.o(142445);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(142447);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1616);
    AppMethodBeat.o(142447);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(142448);
    if ((paramm instanceof g))
    {
      paramString = (g)paramm;
      this.mProfessions = paramString.ueq;
      this.udu = paramString.udu;
    }
    while ((!(paramm instanceof d)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(142448);
      return false;
    }
    paramString = getProcess();
    Bundle localBundle = getInput();
    String str = ((d)paramm).token;
    ab.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (paramString != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.uds.udI.getValue());
      localBundle.putString("key_province_code", (String)this.uds.udJ.getValue());
      localBundle.putString("key_city_code", (String)this.uds.udK.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.uds.udM.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", ((d)paramm).ueb);
      localBundle.putBoolean("realname_verify_process_need_face", ((d)paramm).uec);
      localBundle.putLong("realname_verify_process_face_scene", ((d)paramm).foo);
      localBundle.putString("realname_verify_process_face_package", ((d)paramm).packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", ((d)paramm).cFw);
      paramm = new RealNameBundle();
      paramm.ueu = ((String)this.uds.udE.getValue());
      paramm.uev = this.udt;
      paramm.uew = ((Integer)this.uds.udF.getValue()).intValue();
      paramm.uex = ((Profession)this.uds.udM.getValue());
      paramm.uey = ((String)this.uds.udI.getValue());
      paramm.uez = ((String)this.uds.udJ.getValue());
      paramm.ueA = ((String)this.uds.udK.getValue());
      paramm.ueB = ((String)this.uds.udL.getValue());
      paramm.ueC = ((Integer)this.uds.udP.getValue()).intValue();
      paramm.ueD = ((String)this.uds.udO.getValue());
      paramm.ueE = ((String)this.uds.udQ.getValue());
      paramm.ueF = ((String)this.uds.udR.getValue());
      paramm.ueG = ((String)this.uds.udS.getValue());
      localBundle.putParcelable("realname_verify_process_bundle", paramm);
      paramString.a(this, 0, localBundle);
    }
    AppMethodBeat.o(142448);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */