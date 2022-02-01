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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.a;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements g
{
  private boolean CSS = false;
  private String CTc = null;
  private int CTd;
  private int CTe;
  private boolean CTf = false;
  private Button CTg;
  private TextView CTh;
  private ImageView CTi;
  private String CTj = "";
  private boolean dnJ = false;
  private String dvd = null;
  private int hSw = 0;
  private ProgressDialog rGq = null;
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
    this.dvd = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.hSw = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.CTc = getIntent().getStringExtra("intent.key.ok.session.list");
    this.CTd = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.CTe = getIntent().getIntExtra("intent.key.function.control", 0);
    this.CTj = getIntent().getStringExtra("intent.key.usage.link");
    ac.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.CTj });
    setMMTitle("");
    this.CTi = ((ImageView)findViewById(2131306933));
    if (!bs.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131305207)).setText((CharSequence)localObject2);
    }
    localObject2 = new lr();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((lr)localObject2).dnC.dnD;
    int j = ((lr)localObject2).dnC.dnE;
    int k = ((lr)localObject2).dnC.dnF;
    switch (this.hSw)
    {
    default: 
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKJ, Integer.valueOf(0));
      if (!bs.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText((CharSequence)localObject1);
        label377:
        if (!bs.isNullOrNil(this.CTj))
        {
          this.CTi.setVisibility(0);
          this.CTi.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(2131766161));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + ab.eUO());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              d.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(2131305201);
        if (this.hSw == 1) {
          break label938;
        }
        if (this.hSw != 2) {
          break label831;
        }
        ((ImageView)localObject1).setImageResource(2131689976);
        label445:
        this.CTh = ((TextView)findViewById(2131306941));
        this.CTh.setText(str2);
        this.CTh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            AppMethodBeat.o(30196);
          }
        });
        this.CTg = ((Button)findViewById(2131306938));
        if (bs.isNullOrNil(str1)) {
          break label1005;
        }
        this.CTg.setText(str1);
        if (this.type != 0) {
          break label949;
        }
        this.CTg.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.CTg.setOnClickListener(new View.OnClickListener()
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
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GKI, Boolean.TRUE);
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
                az.ayM();
                if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKI, Boolean.TRUE)).booleanValue()) {
                  ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, true);
                }
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GKI, Boolean.FALSE);
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
      az.agi().a(972, this);
      az.agi().a(973, this);
      AppMethodBeat.o(30204);
      return;
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKJ, Integer.valueOf(3));
      break;
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKJ, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label377;
      }
      if ((this.CTe & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.hSw) });
        if (((this.hSw != 1) || (this.CTd < j)) && ((this.hSw != 2) || (this.CTd < k))) {
          break;
        }
        this.CSS = true;
        ((TextView)findViewById(2131305197)).setVisibility(8);
        ((CheckBox)findViewById(2131305198)).setVisibility(0);
        ((CheckBox)findViewById(2131305198)).setText(2131766161);
        if (bool)
        {
          az.ayM();
          if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKI, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(2131305198)).setChecked(false);
        break;
      }
      label831:
      if (this.hSw == 3)
      {
        ((ImageView)localObject1).setImageResource(2131689975);
        break label445;
      }
      if (this.hSw == 5)
      {
        ((ImageView)localObject1).setImageResource(2131689985);
        break label445;
      }
      if (this.hSw == 6)
      {
        ((ImageView)localObject1).setImageResource(2131689964);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cc.a.au(this, 2131167018);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cc.a.au(this, 2131167018);
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
        this.CTg.setEnabled(false);
        if (this.hSw == 5) {
          this.CTh.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.CTg.setEnabled(true);
        continue;
        label1005:
        this.CTg.setVisibility(4);
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
    az.agi().b(972, this);
    az.agi().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    aqc localaqc;
    if ((this.CTf) && (az.agM()))
    {
      localaqc = new aqc();
      localaqc.EIY = 27;
      if (!u.nM(u.axC())) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 2)
    {
      localaqc.vVH = i;
      az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(23, localaqc));
      this.CTf = false;
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
    if (this.rGq != null)
    {
      this.rGq.dismiss();
      this.rGq = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      az.agi().b(972, this);
      if (paramn.getType() == 972)
      {
        paramString = (e)paramn;
        if ((paramString.CSS) || (this.dnJ))
        {
          paramString = (afo)paramString.hEg.hvs.hvw;
          if ((paramString != null) && (paramString.ExR != null)) {
            break label205;
          }
          paramString = null;
          paramn = new ls();
          paramn.dnG.dnH = paramString;
          paramn.dnG.dnI = this.hSw;
          paramn.dnG.dnJ = this.dnJ;
          com.tencent.mm.sdk.b.a.GpY.l(paramn);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label205:
        paramString = paramString.ExR.toByteArray();
        break;
        paramn.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!bs.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText(paramString);
      }
      if (this.type != -1) {
        break label360;
      }
      if (this.CTg != null) {
        this.CTg.setEnabled(false);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        if (this.CTg != null)
        {
          this.CTg.setEnabled(true);
          this.CTg.setText(2131766165);
        }
        if (this.CTh != null) {
          this.CTh.setVisibility(4);
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