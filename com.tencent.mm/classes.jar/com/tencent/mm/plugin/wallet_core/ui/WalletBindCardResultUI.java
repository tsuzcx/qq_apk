package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.is;
import com.tencent.mm.h.a.is.a;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.n.a;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private com.tencent.mm.sdk.b.c mNd = new WalletBindCardResultUI.1(this);
  private String mQr = null;
  private String nDd;
  private PayInfo nDu;
  private TextView nEk;
  private BindCardOrder qAI;
  private boolean qAJ = false;
  private String qAK;
  private String qAL;
  private n.b qAM;
  private WalletOrderInfoNewUI.b qAN;
  private HashMap<String, WalletOrderInfoNewUI.a> qAO = new HashMap();
  private String qAP;
  private BindCardOrder qAQ = null;
  private String qAR = "-1";
  private Button qAS;
  private ImageView qAT;
  private ViewGroup qAU;
  private CdnImageView qAV;
  private TextView qAW;
  private TextView qAX;
  private View qAY;
  private Button qAZ;
  private ViewGroup qBa;
  private boolean qBb = false;
  private boolean qBc = false;
  private boolean qBd = false;
  private com.tencent.mm.wallet_core.c qBe;
  private int qwv;
  
  private void QK(String paramString)
  {
    bWx();
    e.l(this, paramString, false);
  }
  
  private void bWu()
  {
    this.qBa.setVisibility(0);
  }
  
  private void bWv()
  {
    this.nEk.setText(this.qAI.qul);
  }
  
  private void bWw()
  {
    int i = 1;
    this.qAU.setVisibility(4);
    this.qBc = false;
    this.qBb = false;
    if (this.qAI != null) {
      if (this.qAI.qur != null)
      {
        y.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.qAQ });
        if ((this.qAI == null) || ((!this.qAI.bUW()) && (!this.qAI.bUX())) || (this.qAI.qur.qqG <= 0L) || (bk.bl(this.qAI.qus.qwp))) {
          break label842;
        }
        this.qAQ = this.qAI;
        this.qAY.setVisibility(8);
        this.qAV.setRoundCorner(true);
        this.qAZ.setEnabled(true);
        this.qAZ.setBackgroundResource(a.e.btn_solid_green);
        this.qAX.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.qAO.get(this.qAQ.qur.qqG);
        if (localObject == null) {
          break label629;
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).bVO)) {
          this.qAV.setUrl(((WalletOrderInfoNewUI.a)localObject).bVO);
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).bQZ)) {
          this.qAW.setText(((WalletOrderInfoNewUI.a)localObject).bQZ);
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qEu))
        {
          this.qAZ.setText(((WalletOrderInfoNewUI.a)localObject).qEu);
          this.qAZ.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.qAX.getLayoutParams();
        if ((localObject == null) || (bk.bl(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label683;
        }
        this.qAX.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.qAX.setLayoutParams(localLayoutParams);
        this.qAZ.setVisibility(0);
        this.qAZ.setOnClickListener(new WalletBindCardResultUI.3(this));
        if (this.qAQ.qur.qwk != 1L) {
          this.qAU.setOnClickListener(new WalletBindCardResultUI.4(this));
        }
        localObject = this.qAR;
        switch (((String)localObject).hashCode())
        {
        default: 
          i = -1;
          switch (i)
          {
          default: 
            localObject = this.qAW.getText();
            if ((!bk.L((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.qAW.setText(((CharSequence)localObject).subSequence(0, 9));
              this.qAW.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.qAU.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
            this.qAU.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.qAU.setVisibility(0);
          }
          break;
        }
      }
    }
    label561:
    label629:
    while ((this.qAI.qut == null) || (bk.bl(this.qAI.qut.qhq))) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        if (this.qAW.getVisibility() == 0) {
          this.qAW.post(new Runnable()
          {
            public final void run()
            {
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!bk.L(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                y.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                y.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
            }
          });
        }
        if (this.qAU.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.qAT.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 91);
          this.qAT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.qAV.setUrl(this.qAI.qus.mTc);
        this.qAW.setText(this.qAI.qus.name);
        this.qAZ.setText(this.qAI.qus.qwp);
        continue;
        if (!bk.bl(this.qAI.qus.title))
        {
          this.qAX.setText(this.qAI.qus.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.qAX.setVisibility(8);
          localLayoutParams.addRule(15, -1);
          continue;
          if (((String)localObject).equals("0"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("-1"))
            {
              continue;
              if (((String)localObject).equals("3"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("4"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("2"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("1"))
                    {
                      i = 5;
                      continue;
                      this.qAZ.setEnabled(false);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label683:
    label842:
    Object localObject = this.qAI;
    if ((((BindCardOrder)localObject).jumpType == BindCardOrder.quh) && (((BindCardOrder)localObject).qut != null))
    {
      i = 1;
      label892:
      if (i == 0) {
        break label1352;
      }
      this.qAK = this.qAI.qut.qhq;
      this.qAL = this.qAI.qut.qhr;
      this.qwv = this.qAI.qut.qwv;
      this.qAM = this.qAI.qut;
      this.qAV.setUrl(this.qAI.qut.qws);
      this.qAW.setText(this.qAI.qut.qwt);
      this.qAX.setText(getString(a.i.wallet_app_brand_entrance));
      this.qAX.setVisibility(0);
      this.qAV.setRoundCorner(true);
      this.qAZ.setEnabled(true);
      this.qAZ.setBackgroundResource(a.e.btn_solid_green);
      localObject = (RelativeLayout.LayoutParams)this.qAX.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      this.qAX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.qAI.qur.qqG <= 0L) {
        break label1354;
      }
      if (!bk.bl(this.qAI.qut.qwu))
      {
        this.qAZ.setVisibility(0);
        this.qAZ.setText(this.qAI.qut.qwu);
        this.qAY.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.qAO.get(this.qAI.qur.qqG);
      if (localObject != null)
      {
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qws)) {
          this.qAV.setUrl(((WalletOrderInfoNewUI.a)localObject).qws);
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qwt)) {
          this.qAW.setText(((WalletOrderInfoNewUI.a)localObject).qwt);
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qwu))
        {
          this.qAZ.setText(((WalletOrderInfoNewUI.a)localObject).qwu);
          this.qAZ.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qhq)) {
          this.qAK = ((WalletOrderInfoNewUI.a)localObject).qhq;
        }
        if (!bk.bl(((WalletOrderInfoNewUI.a)localObject).qhr)) {
          this.qAL = ((WalletOrderInfoNewUI.a)localObject).qhr;
        }
      }
    }
    for (;;)
    {
      localObject = new WalletBindCardResultUI.5(this);
      this.qAU.setOnClickListener((View.OnClickListener)localObject);
      this.qAZ.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.qAW.getText();
      if ((bk.L((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.qAW.setText(((CharSequence)localObject).subSequence(0, 9));
      this.qAW.append("...");
      break;
      i = 0;
      break label892;
      label1352:
      break label561;
      label1354:
      this.qAZ.setVisibility(8);
      this.qAY.setVisibility(8);
    }
  }
  
  private void bWx()
  {
    int i = 0;
    if (!this.qAJ)
    {
      is localis = new is();
      localis.bQT.bQU = 4;
      is.a locala = localis.bQT;
      if (this.BX.getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.aYY = i;
      com.tencent.mm.sdk.b.a.udP.m(localis);
      this.qAJ = true;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof x)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (x)paramm;
        paramm = new WalletOrderInfoNewUI.a(paramString.gff);
        if (this.qAN == null) {
          break label66;
        }
        this.qAO.put(paramString.qrd, paramm);
        bWw();
        bWu();
      }
    }
    label66:
    while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.m)) {
      for (;;)
      {
        return false;
        if (this.qBb)
        {
          this.qAO.put(paramString.qrd, paramm);
          bWw();
          bWu();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.m)paramm;
      paramm = paramString.qqN;
      if ((this.qAQ != null) && (this.qAQ.qur.qqG == paramString.qqP.qur.qqG))
      {
        y.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.qAQ });
        this.qAR = paramm;
        bWw();
        bWu();
        if ((!bk.bl(paramString.dmU)) && (!"3".equals(paramm))) {
          this.qAZ.setText(paramString.dmU);
        }
      }
      if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bk.bl(paramString.qqO))) {
        com.tencent.mm.ui.base.h.b(this, paramString.qqO, "", true);
      }
      while (!"0".equals(paramm)) {
        return true;
      }
      if (!bk.bl(paramString.qqO)) {}
      for (paramString = paramString.qqO;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    return true;
  }
  
  public final void done()
  {
    Bundle localBundle = new Bundle();
    if (this.qBe != null)
    {
      this.qBe.a(this, 0, localBundle);
      return;
    }
    finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_bind_card_result_ui;
  }
  
  public final void hD(int paramInt)
  {
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    if (this.qAI.qur == null) {}
    for (String str = "";; str = bk.aM(this.qAI.qur.qqG, ""))
    {
      localh.f(14877, new Object[] { str, this.qAI.quo, Integer.valueOf(paramInt), this.qAI.mOb });
      return;
    }
  }
  
  protected final void initView()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.qAT = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.nEk = ((TextView)findViewById(a.f.pay_succ_wording));
    this.qAS = ((Button)findViewById(a.f.pay_finish_button));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    if ((this.qAI != null) && (!bk.bl(this.qAI.quk))) {
      this.qAS.setText(this.qAI.quk);
    }
    for (;;)
    {
      this.qAS.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.qBa = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
      this.qAU = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
      this.qAV = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
      this.qAV.setUseSdcardCache(true);
      this.qAW = ((TextView)findViewById(a.f.tinyapp_desc_tv));
      this.qAX = ((TextView)findViewById(a.f.tinyapp_name_tv));
      this.qAZ = ((Button)findViewById(a.f.tinyapp_button));
      this.qAY = findViewById(a.f.tinyapp_info_touch_mask);
      this.qBa.setVisibility(4);
      bWv();
      bWw();
      bWu();
      if ((!bk.bl(this.qAI.qum)) && (!bk.bl(this.qAI.qun))) {
        ((TextView)findViewById(a.f.pay_succ_wording_tip)).setText(getString(a.i.wallet_bind_card_info_tip, new Object[] { this.qAI.qum, this.qAI.qun }));
      }
      return;
      this.qAS.setText(str);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      y.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      a(new x(this.qAN.qrd, this.qAN.qEw, this.qAN.qEx, this.qAN.qEy, this.qAN.qxP, this.qAN.qEz, this.qAI.mOb, this.qAI.quo, this.qAI.qup, this.qAI.qup), true, true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (d.gF(21))
    {
      if (!d.gF(23)) {
        break label164;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      vN(4);
      com.tencent.mm.wallet_core.a.aj(this);
      this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
      this.BX.getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)this.BX.getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.qAI = paramBundle;
      vN(0);
      initView();
      this.qBe = cNj();
      bWv();
      hD(1);
      kh(1979);
      com.tencent.mm.sdk.b.a.udP.c(this.mNd);
      this.qBd = true;
      return;
      label164:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
  
  @Deprecated
  protected Dialog onCreateDialog(int paramInt)
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new h.c()
    {
      public final void gl(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        }
        Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletBindCardResultUI.i(WalletBindCardResultUI.this)));
        localIntent.addFlags(268435456);
        WalletBindCardResultUI.this.startActivity(localIntent);
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.mNd);
    ki(1979);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      done();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.qBd), this.qAQ, Boolean.valueOf(this.qBb), Boolean.valueOf(this.qBc), this.qAM });
    if (this.qBd) {
      this.qBd = false;
    }
    do
    {
      return;
      if ((this.qAQ != null) && (this.qBc))
      {
        a(new x(this.qAQ.qur.qqG, this.qAQ.qur.qwl, this.qAQ.qur.qwm, this.qAQ.qur.qwn, this.qAQ.qur.qwk, this.qAQ.qur.qwo, this.qAI.mOb, this.qAI.quo, this.qAI.qup, this.qAI.qup), true, true);
        return;
      }
    } while ((!this.qBb) || (this.qAM == null));
    a(new x(this.qAI.qur.qqG, this.qAI.qur.qwl, this.qAI.qur.qwm, this.qAI.qur.qwn, this.qAI.qur.qwo, this.qAI.qur.qwk, this.qAI.mOb, this.qAI.quo, this.qAI.qup, this.qAI.qup), true, true);
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */