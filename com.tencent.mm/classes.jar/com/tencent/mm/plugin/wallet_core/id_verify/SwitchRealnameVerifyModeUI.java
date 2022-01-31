package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private int fgD = 0;
  private q man = new q();
  private boolean qqA = false;
  private int qrA = 500;
  private long qrB = 0L;
  private View qrC;
  private View qrD;
  private View qrE;
  private TextView qrF;
  private TextView qrG;
  private TextView qrH;
  private TextView qrI;
  private TextView qrJ;
  private TextView qrK;
  private TextView qrL;
  private String qrM;
  private String qrN;
  private String qrO;
  private boolean qrP;
  private boolean qrQ = false;
  
  private static JSONObject bUN()
  {
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.uso, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bk.bl((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          y.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            y.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            return null;
          }
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          y.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          y.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          return null;
        }
      }
    }
    y.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    return null;
  }
  
  private boolean kA(boolean paramBoolean)
  {
    JSONObject localJSONObject = bUN();
    if ((paramBoolean) && (localJSONObject == null)) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      String str;
      if (localJSONObject != null)
      {
        str = bk.aM(localJSONObject.optString("cache_header_titles", getString(a.i.switch_realname_default_tip)), getString(a.i.switch_realname_default_tip));
        if (!this.qrQ) {
          break label397;
        }
        ((TextView)findViewById(a.f.switch_real_name_tv)).setText(a.i.wallet_real_name_verify_title_from_pwd_desc);
        if (!localJSONObject.optBoolean("isShowBindCardVerify", false)) {
          break label414;
        }
        this.qrK.setText(localJSONObject.optString("bindCardVerifyTitle"));
        this.qrL.setText(localJSONObject.optString("bindCardVerifySubtitle"));
        this.qrE.setVisibility(0);
        label115:
        if (!localJSONObject.optBoolean("isShowBindCard", false)) {
          break label426;
        }
        this.qrF.setText(localJSONObject.optString("bindcardTitle", getString(a.i.switch_realname_verify_mode_bindcard)));
        this.qrG.setText(localJSONObject.optString("bindcardSubTitle", getString(a.i.switch_realname_verify_mode_bindcard_tip)));
        this.qrC.setVisibility(0);
        label173:
        if (!localJSONObject.optBoolean("isShowBindId", false)) {
          break label438;
        }
        this.qrH.setText(localJSONObject.optString("bindIdTitle", getString(a.i.switch_realname_verify_mode_id_verify)));
        this.qrI.setText(localJSONObject.optString("bindIdSubTitle", getString(a.i.switch_realname_verify_mode_id_verify_tip)));
        this.qrD.setVisibility(0);
        label234:
        this.qrN = localJSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.qrO = localJSONObject.optString("bindCardVerifyAlertViewContent", "");
        this.qrP = localJSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        str = localJSONObject.optString("extral_wording", "");
        if (bk.bl(str)) {
          break label450;
        }
        this.qrJ.setText(str);
        this.qrJ.setVisibility(0);
      }
      for (;;)
      {
        this.qrN = localJSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.qrO = localJSONObject.optString("bindCardVerifyAlertViewContent");
        this.qrP = localJSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = localJSONObject.optBoolean("question_answer_switch", false);
        this.qrM = localJSONObject.optString("question_answer_url", "");
        if ((paramBoolean) && (!bk.bl(this.qrM))) {
          addIconOptionMenu(0, a.e.wallet_qanda_icon, new SwitchRealnameVerifyModeUI.7(this));
        }
        paramBoolean = true;
        return paramBoolean;
        label397:
        ((TextView)findViewById(a.f.switch_real_name_tv)).setText(str);
        break;
        label414:
        this.qrE.setVisibility(8);
        break label115;
        label426:
        this.qrC.setVisibility(8);
        break label173;
        label438:
        this.qrD.setVisibility(8);
        break label234;
        label450:
        this.qrJ.setVisibility(8);
      }
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
    {
      bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
          ki(580);
          ((com.tencent.mm.plugin.wallet_core.c.a)paramm).getToken();
          paramString = cNj();
          if (paramString != null)
          {
            paramString = paramString.kke;
            paramString.putInt("real_name_verify_mode", 1);
            com.tencent.mm.wallet_core.a.j(this, paramString);
          }
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!(paramm instanceof b));
    ki(1666);
    kA(true);
    paramString = (b)paramm;
    this.qqA = paramString.qqA;
    if (paramString.lQQ == null) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      bool1 = bool2;
      if (paramInt1 == 0) {
        break;
      }
      bool1 = bool2;
      if (!paramString.lQQ.a(this, new SwitchRealnameVerifyModeUI.3(this))) {
        break;
      }
      return true;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_realname_verify_mode_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_real_name_verify_title);
    this.qrC = findViewById(a.f.switch_to_bindcard);
    this.qrD = findViewById(a.f.switch_to_verify_id);
    this.qrE = findViewById(a.f.switch_to_verifycard);
    this.qrD.setOnClickListener(this);
    this.qrC.setOnClickListener(this);
    this.qrE.setOnClickListener(this);
    this.qrF = ((TextView)findViewById(a.f.bind_card_title));
    this.qrG = ((TextView)findViewById(a.f.bind_card_sub_title));
    this.qrH = ((TextView)findViewById(a.f.bind_id_title));
    this.qrI = ((TextView)findViewById(a.f.bind_id_sub_title));
    this.qrJ = ((TextView)findViewById(a.f.extral_wording));
    this.qrK = ((TextView)findViewById(a.f.verify_card_title));
    this.qrL = ((TextView)findViewById(a.f.verify_card_sub_title));
    if (this.qrQ) {
      ((TextView)findViewById(a.f.switch_real_name_tv)).setText(a.i.wallet_real_name_verify_title_from_pwd_desc);
    }
    kA(false);
    b localb = new b();
    kh(1666);
    a(localb, true, true);
    setBackBtn(new SwitchRealnameVerifyModeUI.2(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        this.man.bgR();
      }
    }
    else {
      return;
    }
    this.man.cancel();
  }
  
  public void onClick(final View paramView)
  {
    if (System.currentTimeMillis() - this.qrB <= this.qrA)
    {
      y.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      return;
    }
    this.qrB = System.currentTimeMillis();
    this.man.a(new q.a()
    {
      public final void bgR()
      {
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
      }
      
      public final void bgS()
      {
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
      }
      
      public final void cancel()
      {
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).bHj = false;
      }
    }, this.qqA);
  }
  
  public void onClickImp(View paramView)
  {
    int i = paramView.getId();
    paramView = cNj();
    Bundle localBundle;
    if (paramView != null)
    {
      localBundle = paramView.kke;
      if (i != a.f.switch_to_bindcard) {
        break label213;
      }
      com.tencent.mm.wallet_core.ui.e.a(15, bk.UX(), this.fgD);
      if (localBundle.getInt("realname_scene") != 1) {
        break label199;
      }
      if (getIntent() == null)
      {
        paramView = "";
        if (bk.bl("")) {
          paramView = getString(a.i.wallet_unknown_err);
        }
        h.a(this, paramView, null, false, new SwitchRealnameVerifyModeUI.6(this));
      }
    }
    else
    {
      return;
    }
    kh(580);
    a(new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
    return;
    label199:
    localBundle.putInt("real_name_verify_mode", 1);
    for (;;)
    {
      com.tencent.mm.wallet_core.a.j(this, localBundle);
      return;
      label213:
      if (i == a.f.switch_to_verify_id)
      {
        com.tencent.mm.wallet_core.ui.e.a(17, bk.UX(), this.fgD);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == a.f.switch_to_verifycard)
      {
        com.tencent.mm.wallet_core.ui.e.a(16, bk.UX(), this.fgD);
        if ((this.qrP) && (!bk.bl(this.qrO)))
        {
          h.a(this, this.qrO, "", this.qrN, false, new SwitchRealnameVerifyModeUI.5(this, paramView));
          return;
        }
        localBundle.putInt("real_name_verify_mode", 3);
        localBundle.putString("verify_card_flag", "1");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qrQ = this.BX.getBoolean("key_from_set_pwd", false);
    initView();
    cNj();
    this.fgD = this.BX.getInt("entry_scene", this.fgD);
    com.tencent.mm.wallet_core.ui.e.a(13, bk.UX(), this.fgD);
    if (this.qrQ) {
      setMMTitle(a.i.wallet_real_name_verify_title_from_pwd);
    }
    this.man.qHp = new SwitchRealnameVerifyModeUI.1(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      c localc = cNj();
      if (localc != null)
      {
        com.tencent.mm.wallet_core.ui.e.a(14, bk.UX(), this.fgD);
        localc.b(this, 0);
        return true;
      }
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.man.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.man.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI
 * JD-Core Version:    0.7.0.1
 */