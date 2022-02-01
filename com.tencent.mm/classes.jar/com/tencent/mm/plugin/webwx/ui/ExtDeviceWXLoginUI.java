package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.a;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements g
{
  private boolean BAL = false;
  private String BAV = null;
  private int BAW;
  private int BAX;
  private boolean BAY = false;
  private Button BAZ;
  private TextView BBa;
  private ImageView BBb;
  private String BBc = "";
  private boolean dpY = false;
  private String dxq = null;
  private int hrU = 0;
  private ProgressDialog qLE = null;
  private int type = 0;
  
  public void finish()
  {
    AppMethodBeat.i(30206);
    super.finish();
    overridePendingTransition(2130771986, 2130772106);
    AppMethodBeat.o(30206);
  }
  
  public int getLayoutId()
  {
    return 2131493706;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30204);
    this.dxq = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.hrU = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.BAV = getIntent().getStringExtra("intent.key.ok.session.list");
    this.BAW = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.BAX = getIntent().getIntExtra("intent.key.function.control", 0);
    this.BBc = getIntent().getStringExtra("intent.key.usage.link");
    ad.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.BBc });
    setMMTitle("");
    this.BBb = ((ImageView)findViewById(2131306933));
    if (!bt.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131305207)).setText((CharSequence)localObject2);
    }
    localObject2 = new li();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((li)localObject2).dpR.dpS;
    int j = ((li)localObject2).dpR.dpT;
    int k = ((li)localObject2).dpR.dpU;
    switch (this.hrU)
    {
    default: 
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmU, Integer.valueOf(0));
      if (!bt.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText((CharSequence)localObject1);
        label377:
        if (!bt.isNullOrNil(this.BBc))
        {
          this.BBb.setVisibility(0);
          this.BBb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(2131766161));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + ac.eFu());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              d.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(2131305201);
        if (this.hrU == 1) {
          break label938;
        }
        if (this.hrU != 2) {
          break label831;
        }
        ((ImageView)localObject1).setImageResource(2131689976);
        label445:
        this.BBa = ((TextView)findViewById(2131306941));
        this.BBa.setText(str2);
        this.BBa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            AppMethodBeat.o(30196);
          }
        });
        this.BAZ = ((Button)findViewById(2131306938));
        if (bt.isNullOrNil(str1)) {
          break label1005;
        }
        this.BAZ.setText(str1);
        if (this.type != 0) {
          break label949;
        }
        this.BAZ.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.BAZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30197);
          if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) == 0)
          {
            if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this))
            {
              boolean bool = ((CheckBox)ExtDeviceWXLoginUI.this.findViewById(2131305198)).isChecked();
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, false);
              if (bool)
              {
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.FmT, Boolean.TRUE);
                paramAnonymousView = ExtDeviceWXLoginUI.this;
                if ((!ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) || (!bool)) {
                  break label158;
                }
              }
              label158:
              for (bool = true;; bool = false)
              {
                ExtDeviceWXLoginUI.b(paramAnonymousView, bool);
                AppMethodBeat.o(30197);
                return;
                az.arV();
                if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FmT, Boolean.TRUE)).booleanValue()) {
                  ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, true);
                }
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.FmT, Boolean.FALSE);
                break;
              }
            }
            ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this, false);
            AppMethodBeat.o(30197);
            return;
          }
          if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) == -2)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("BaseScanUI_select_scan_mode", 1);
            paramAnonymousView.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            paramAnonymousView.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            paramAnonymousView.putExtra("from_album", false);
            paramAnonymousView.putExtra("show_intro", false);
            paramAnonymousView.setFlags(65536);
            d.b(ExtDeviceWXLoginUI.this, "scanner", ".ui.BaseScanUI", paramAnonymousView);
            ExtDeviceWXLoginUI.this.finish();
          }
          AppMethodBeat.o(30197);
        }
      });
      getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(30198);
          ExtDeviceWXLoginUI.e(ExtDeviceWXLoginUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ExtDeviceWXLoginUI.f(ExtDeviceWXLoginUI.this);
          AppMethodBeat.o(30198);
        }
      });
      ((TextView)findViewById(2131306940)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30199);
          ExtDeviceWXLoginUI.this.finish();
          AppMethodBeat.o(30199);
        }
      });
      az.aeS().a(972, this);
      az.aeS().a(973, this);
      AppMethodBeat.o(30204);
      return;
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmU, Integer.valueOf(3));
      break;
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmU, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label377;
      }
      if ((this.BAX & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.hrU) });
        if (((this.hrU != 1) || (this.BAW < j)) && ((this.hrU != 2) || (this.BAW < k))) {
          break;
        }
        this.BAL = true;
        ((TextView)findViewById(2131305197)).setVisibility(8);
        ((CheckBox)findViewById(2131305198)).setVisibility(0);
        ((CheckBox)findViewById(2131305198)).setText(2131766161);
        if (bool)
        {
          az.arV();
          if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FmT, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(2131305198)).setChecked(false);
        break;
      }
      label831:
      if (this.hrU == 3)
      {
        ((ImageView)localObject1).setImageResource(2131689975);
        break label445;
      }
      if (this.hrU == 5)
      {
        ((ImageView)localObject1).setImageResource(2131689985);
        break label445;
      }
      if (this.hrU == 6)
      {
        ((ImageView)localObject1).setImageResource(2131689964);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cd.a.ao(this, 2131167018);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cd.a.ao(this, 2131167018);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject1).setAlpha(0.3F);
        break label445;
      }
      label938:
      ((ImageView)localObject1).setImageResource(2131689981);
      break label445;
      label949:
      if (this.type == -1)
      {
        this.BAZ.setEnabled(false);
        if (this.hrU == 5) {
          this.BBa.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.BAZ.setEnabled(true);
        continue;
        label1005:
        this.BAZ.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30202);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    initView();
    overridePendingTransition(2130772108, 2130771986);
    AppMethodBeat.o(30202);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30207);
    super.onDestroy();
    az.aeS().b(972, this);
    az.aeS().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    amy localamy;
    if ((this.BAY) && (az.afw()))
    {
      localamy = new amy();
      localamy.DnY = 27;
      if (!u.mY(u.aqM())) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 2)
    {
      localamy.uMR = i;
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(23, localamy));
      this.BAY = false;
      AppMethodBeat.o(30205);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30203);
    super.onResume();
    AppMethodBeat.o(30203);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30208);
    if (this.qLE != null)
    {
      this.qLE.dismiss();
      this.qLE = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      az.aeS().b(972, this);
      if (paramn.getType() == 972)
      {
        paramString = (e)paramn;
        if ((paramString.BAL) || (this.dpY))
        {
          paramString = (aep)paramString.hdD.gUT.gUX;
          if ((paramString != null) && (paramString.DeL != null)) {
            break label205;
          }
          paramString = null;
          paramn = new lj();
          paramn.dpV.dpW = paramString;
          paramn.dpV.dpX = this.hrU;
          paramn.dpV.dpY = this.dpY;
          com.tencent.mm.sdk.b.a.ESL.l(paramn);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label205:
        paramString = paramString.DeL.toByteArray();
        break;
        paramn.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!bt.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText(paramString);
      }
      if (this.type != -1) {
        break label360;
      }
      if (this.BAZ != null) {
        this.BAZ.setEnabled(false);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(30208);
      return;
      if (paramInt2 != -2) {
        break;
      }
      this.type = -2;
      break;
      label360:
      if (this.type == -2)
      {
        if (this.BAZ != null)
        {
          this.BAZ.setEnabled(true);
          this.BAZ.setText(2131766165);
        }
        if (this.BBa != null) {
          this.BBa.setVisibility(4);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */