package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ju;
import com.tencent.mm.h.a.ju.a;
import com.tencent.mm.h.a.jv;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements f
{
  private boolean bSo = false;
  private String bYD = null;
  private int ezA = 0;
  private ProgressDialog lxZ = null;
  private boolean rDF = false;
  private String rDP = null;
  private int rDQ;
  private int rDR;
  private boolean rDS = false;
  private Button rDT;
  private TextView rDU;
  private int type = 0;
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
  }
  
  protected final int getLayoutId()
  {
    return R.i.device_wx_login;
  }
  
  protected final void initView()
  {
    this.bYD = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.ezA = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.rDP = getIntent().getStringExtra("intent.key.ok.session.list");
    this.rDQ = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.rDR = getIntent().getIntExtra("intent.key.function.control", 0);
    y.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1 });
    setMMTitle("");
    if (!bk.bl((String)localObject2)) {
      ((TextView)findViewById(R.h.status_title)).setText((CharSequence)localObject2);
    }
    localObject2 = new ju();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((ju)localObject2).bSh.bSi;
    int j = ((ju)localObject2).bSh.bSj;
    int k = ((ju)localObject2).bSh.bSk;
    switch (this.ezA)
    {
    default: 
      au.Hx();
      c.Dz().c(ac.a.uul, Integer.valueOf(0));
      if (!bk.bl((String)localObject1))
      {
        ((CheckBox)findViewById(R.h.status_content_checkbox)).setVisibility(8);
        ((TextView)findViewById(R.h.status_content)).setVisibility(0);
        ((TextView)findViewById(R.h.status_content)).setText((CharSequence)localObject1);
        label333:
        localObject1 = (ImageView)findViewById(R.h.status_icon);
        if (this.ezA == 1) {
          break label826;
        }
        if (this.ezA != 2) {
          break label788;
        }
        ((ImageView)localObject1).setImageResource(R.k.connect_mac);
        label369:
        this.rDU = ((TextView)findViewById(R.h.webwx_logoutBt));
        this.rDU.setText(str2);
        this.rDU.setOnClickListener(new ExtDeviceWXLoginUI.2(this));
        this.rDT = ((Button)findViewById(R.h.webwx_loginBt));
        if (bk.bl(str1)) {
          break label893;
        }
        this.rDT.setText(str1);
        if (this.type != 0) {
          break label837;
        }
        this.rDT.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.rDT.setOnClickListener(new ExtDeviceWXLoginUI.3(this));
      this.mController.contentView.post(new Runnable()
      {
        public final void run()
        {
          ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this);
        }
      });
      ((TextView)findViewById(R.h.webwx_login_closeBt)).setOnClickListener(new ExtDeviceWXLoginUI.5(this));
      au.Dk().a(972, this);
      au.Dk().a(973, this);
      return;
      au.Hx();
      c.Dz().c(ac.a.uul, Integer.valueOf(3));
      break;
      au.Hx();
      c.Dz().c(ac.a.uul, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label333;
      }
      if ((this.rDR & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        y.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ezA) });
        if (((this.ezA != 1) || (this.rDQ < j)) && ((this.ezA != 2) || (this.rDQ < k))) {
          break;
        }
        this.rDF = true;
        ((TextView)findViewById(R.h.status_content)).setVisibility(8);
        ((CheckBox)findViewById(R.h.status_content_checkbox)).setVisibility(0);
        ((CheckBox)findViewById(R.h.status_content_checkbox)).setText(R.l.webwx_login_msg_synchronize);
        if (bool)
        {
          au.Hx();
          if (((Boolean)c.Dz().get(ac.a.uuk, Boolean.valueOf(true))).booleanValue()) {}
        }
        else
        {
          ((CheckBox)findViewById(R.h.status_content_checkbox)).setChecked(false);
        }
        ((ImageView)findViewById(R.h.webwx_help_icon)).setImageResource(R.k.connect_icon_help);
        ((ImageView)findViewById(R.h.webwx_help_icon)).setOnClickListener(new ExtDeviceWXLoginUI.1(this));
        break;
      }
      label788:
      if (this.ezA == 3)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_ipad);
        break label369;
      }
      if (this.ezA == 5)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_wx_album);
        break label369;
      }
      label826:
      ((ImageView)localObject1).setImageResource(R.k.connect_pc);
      break label369;
      label837:
      if (this.type == -1)
      {
        this.rDT.setEnabled(false);
        if (this.ezA == 5) {
          this.rDU.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.rDT.setEnabled(true);
        continue;
        label893:
        this.rDT.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(972, this);
    au.Dk().b(973, this);
  }
  
  protected void onPause()
  {
    super.onPause();
    zr localzr;
    if ((this.rDS) && (au.DK()))
    {
      localzr = new zr();
      localzr.sYS = 27;
      if (!q.hH(q.Gp())) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 2)
    {
      localzr.nfn = i;
      au.Hx();
      c.Fv().b(new i.a(23, localzr));
      this.rDS = false;
      return;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.lxZ != null)
    {
      this.lxZ.dismiss();
      this.lxZ = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      au.Dk().b(972, this);
      if (paramm.getType() == 972)
      {
        paramString = (e)paramm;
        if ((paramString.rDF) || (this.bSo))
        {
          paramString = (wt)paramString.esv.ecF.ecN;
          if ((paramString != null) && (paramString.sTB != null)) {
            break label193;
          }
          paramString = null;
          paramm = new jv();
          paramm.bSl.bSm = paramString;
          paramm.bSl.bSn = this.ezA;
          paramm.bSl.bSo = this.bSo;
          com.tencent.mm.sdk.b.a.udP.m(paramm);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        return;
        label193:
        paramString = paramString.sTB.toByteArray();
        break;
        paramm.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!bk.bl(paramString))
      {
        ((CheckBox)findViewById(R.h.status_content_checkbox)).setVisibility(8);
        ((TextView)findViewById(R.h.status_content)).setVisibility(0);
        ((TextView)findViewById(R.h.status_content)).setText(paramString);
      }
      if (this.type != -1) {
        break label342;
      }
      if (this.rDT != null) {
        this.rDT.setEnabled(false);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      return;
      if (paramInt2 != -2) {
        break;
      }
      this.type = -2;
      break;
      label342:
      if (this.type == -2)
      {
        if (this.rDT != null)
        {
          this.rDT.setEnabled(true);
          this.rDT.setText(R.l.webwx_login_retry);
        }
        if (this.rDU != null) {
          this.rDU.setVisibility(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */