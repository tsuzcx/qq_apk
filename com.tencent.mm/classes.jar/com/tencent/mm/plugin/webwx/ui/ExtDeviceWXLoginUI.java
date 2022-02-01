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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.mb.a;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements f
{
  private int EPA;
  private int EPB;
  private boolean EPC = false;
  private Button EPD;
  private TextView EPE;
  private ImageView EPF;
  private String EPG = "";
  private boolean EPp = false;
  private String EPz = null;
  private boolean dAC = false;
  private String dIk = null;
  private int ioG = 0;
  private ProgressDialog sMH = null;
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
    this.dIk = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.ioG = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.EPz = getIntent().getStringExtra("intent.key.ok.session.list");
    this.EPA = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.EPB = getIntent().getIntExtra("intent.key.function.control", 0);
    this.EPG = getIntent().getStringExtra("intent.key.usage.link");
    ae.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.EPG });
    setMMTitle("");
    this.EPF = ((ImageView)findViewById(2131306933));
    if (!bu.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131305207)).setText((CharSequence)localObject2);
    }
    localObject2 = new mb();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((mb)localObject2).dAv.dAw;
    int j = ((mb)localObject2).dAv.dAx;
    int k = ((mb)localObject2).dAv.dAy;
    switch (this.ioG)
    {
    default: 
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRz, Integer.valueOf(0));
      if (!bu.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText((CharSequence)localObject1);
        label377:
        if (!bu.isNullOrNil(this.EPG))
        {
          this.EPF.setVisibility(0);
          this.EPF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(2131766161));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + ad.fom());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              d.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(2131305201);
        if (this.ioG == 1) {
          break label938;
        }
        if (this.ioG != 2) {
          break label831;
        }
        ((ImageView)localObject1).setImageResource(2131689976);
        label445:
        this.EPE = ((TextView)findViewById(2131306941));
        this.EPE.setText(str2);
        this.EPE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30196);
          }
        });
        this.EPD = ((Button)findViewById(2131306938));
        if (bu.isNullOrNil(str1)) {
          break label1005;
        }
        this.EPD.setText(str1);
        if (this.type != 0) {
          break label949;
        }
        this.EPD.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.EPD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30197);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          boolean bool;
          if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) == 0) {
            if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this))
            {
              bool = ((CheckBox)ExtDeviceWXLoginUI.this.findViewById(2131305198)).isChecked();
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, false);
              if (bool)
              {
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(am.a.IRy, Boolean.TRUE);
                paramAnonymousView = ExtDeviceWXLoginUI.this;
                if ((!ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) || (!bool)) {
                  break label199;
                }
                bool = true;
                label121:
                ExtDeviceWXLoginUI.b(paramAnonymousView, bool);
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30197);
            return;
            bc.aCg();
            if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRy, Boolean.TRUE)).booleanValue()) {
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, true);
            }
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IRy, Boolean.FALSE);
            break;
            label199:
            bool = false;
            break label121;
            ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this, false);
            continue;
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
          }
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ExtDeviceWXLoginUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30199);
        }
      });
      bc.ajj().a(972, this);
      bc.ajj().a(973, this);
      AppMethodBeat.o(30204);
      return;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRz, Integer.valueOf(3));
      break;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRz, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label377;
      }
      if ((this.EPB & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ioG) });
        if (((this.ioG != 1) || (this.EPA < j)) && ((this.ioG != 2) || (this.EPA < k))) {
          break;
        }
        this.EPp = true;
        ((TextView)findViewById(2131305197)).setVisibility(8);
        ((CheckBox)findViewById(2131305198)).setVisibility(0);
        ((CheckBox)findViewById(2131305198)).setText(2131766161);
        if (bool)
        {
          bc.aCg();
          if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRy, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(2131305198)).setChecked(false);
        break;
      }
      label831:
      if (this.ioG == 3)
      {
        ((ImageView)localObject1).setImageResource(2131689975);
        break label445;
      }
      if (this.ioG == 5)
      {
        ((ImageView)localObject1).setImageResource(2131689985);
        break label445;
      }
      if (this.ioG == 6)
      {
        ((ImageView)localObject1).setImageResource(2131689964);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cb.a.ax(this, 2131167018);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cb.a.ax(this, 2131167018);
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
        this.EPD.setEnabled(false);
        if (this.ioG == 5) {
          this.EPE.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.EPD.setEnabled(true);
        continue;
        label1005:
        this.EPD.setVisibility(4);
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
    bc.ajj().b(972, this);
    bc.ajj().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    auo localauo;
    if ((this.EPC) && (bc.ajM()))
    {
      localauo = new auo();
      localauo.GLx = 27;
      if (!v.acG()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localauo.xsz = i;
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(23, localauo));
      this.EPC = false;
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
    if (this.sMH != null)
    {
      this.sMH.dismiss();
      this.sMH = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      bc.ajj().b(972, this);
      if (paramn.getType() == 972)
      {
        paramString = (e)paramn;
        if ((paramString.EPp) || (this.dAC))
        {
          paramString = (aim)paramString.hZD.hQE.hQJ;
          if ((paramString != null) && (paramString.Gyf != null)) {
            break label205;
          }
          paramString = null;
          paramn = new mc();
          paramn.dAz.dAA = paramString;
          paramn.dAz.dAB = this.ioG;
          paramn.dAz.dAC = this.dAC;
          com.tencent.mm.sdk.b.a.IvT.l(paramn);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label205:
        paramString = paramString.Gyf.toByteArray();
        break;
        paramn.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!bu.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText(paramString);
      }
      if (this.type != -1) {
        break label360;
      }
      if (this.EPD != null) {
        this.EPD.setEnabled(false);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        if (this.EPD != null)
        {
          this.EPD.setEnabled(true);
          this.EPD.setText(2131766165);
        }
        if (this.EPE != null) {
          this.EPE.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */