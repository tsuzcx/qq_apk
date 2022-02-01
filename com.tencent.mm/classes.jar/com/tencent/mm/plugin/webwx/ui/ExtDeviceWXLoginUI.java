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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements f
{
  private boolean EwT = false;
  private String Exd = null;
  private int Exe;
  private int Exf;
  private boolean Exg = false;
  private Button Exh;
  private TextView Exi;
  private ImageView Exj;
  private String Exk = "";
  private String dHe = null;
  private boolean dzx = false;
  private int ilN = 0;
  private ProgressDialog sBI = null;
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
    this.dHe = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.ilN = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.Exd = getIntent().getStringExtra("intent.key.ok.session.list");
    this.Exe = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.Exf = getIntent().getIntExtra("intent.key.function.control", 0);
    this.Exk = getIntent().getStringExtra("intent.key.usage.link");
    ad.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.Exk });
    setMMTitle("");
    this.Exj = ((ImageView)findViewById(2131306933));
    if (!bt.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131305207)).setText((CharSequence)localObject2);
    }
    localObject2 = new ma();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((ma)localObject2).dzq.dzr;
    int j = ((ma)localObject2).dzq.dzs;
    int k = ((ma)localObject2).dzq.dzt;
    switch (this.ilN)
    {
    default: 
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixb, Integer.valueOf(0));
      if (!bt.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131305198)).setVisibility(8);
        ((TextView)findViewById(2131305197)).setVisibility(0);
        ((TextView)findViewById(2131305197)).setText((CharSequence)localObject1);
        label377:
        if (!bt.isNullOrNil(this.Exk))
        {
          this.Exj.setVisibility(0);
          this.Exj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(2131766161));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + ac.fks());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              d.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(2131305201);
        if (this.ilN == 1) {
          break label938;
        }
        if (this.ilN != 2) {
          break label831;
        }
        ((ImageView)localObject1).setImageResource(2131689976);
        label445:
        this.Exi = ((TextView)findViewById(2131306941));
        this.Exi.setText(str2);
        this.Exi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30196);
          }
        });
        this.Exh = ((Button)findViewById(2131306938));
        if (bt.isNullOrNil(str1)) {
          break label1005;
        }
        this.Exh.setText(str1);
        if (this.type != 0) {
          break label949;
        }
        this.Exh.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.Exh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30197);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool;
          if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) == 0) {
            if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this))
            {
              bool = ((CheckBox)ExtDeviceWXLoginUI.this.findViewById(2131305198)).isChecked();
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, false);
              if (bool)
              {
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(al.a.Ixa, Boolean.TRUE);
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
            ba.aBQ();
            if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixa, Boolean.TRUE)).booleanValue()) {
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, true);
            }
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.Ixa, Boolean.FALSE);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ExtDeviceWXLoginUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30199);
        }
      });
      ba.aiU().a(972, this);
      ba.aiU().a(973, this);
      AppMethodBeat.o(30204);
      return;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixb, Integer.valueOf(3));
      break;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixb, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label377;
      }
      if ((this.Exf & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ilN) });
        if (((this.ilN != 1) || (this.Exe < j)) && ((this.ilN != 2) || (this.Exe < k))) {
          break;
        }
        this.EwT = true;
        ((TextView)findViewById(2131305197)).setVisibility(8);
        ((CheckBox)findViewById(2131305198)).setVisibility(0);
        ((CheckBox)findViewById(2131305198)).setText(2131766161);
        if (bool)
        {
          ba.aBQ();
          if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixa, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(2131305198)).setChecked(false);
        break;
      }
      label831:
      if (this.ilN == 3)
      {
        ((ImageView)localObject1).setImageResource(2131689975);
        break label445;
      }
      if (this.ilN == 5)
      {
        ((ImageView)localObject1).setImageResource(2131689985);
        break label445;
      }
      if (this.ilN == 6)
      {
        ((ImageView)localObject1).setImageResource(2131689964);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cc.a.ax(this, 2131167018);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cc.a.ax(this, 2131167018);
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
        this.Exh.setEnabled(false);
        if (this.ilN == 5) {
          this.Exi.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.Exh.setEnabled(true);
        continue;
        label1005:
        this.Exh.setVisibility(4);
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
    ba.aiU().b(972, this);
    ba.aiU().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    aty localaty;
    if ((this.Exg) && (ba.ajx()))
    {
      localaty = new aty();
      localaty.GrZ = 27;
      if (!u.acv()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localaty.xcI = i;
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(23, localaty));
      this.Exg = false;
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
    if (this.sBI != null)
    {
      this.sBI.dismiss();
      this.sBI = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      ba.aiU().b(972, this);
      if (paramn.getType() == 972)
      {
        paramString = (e)paramn;
        if ((paramString.EwT) || (this.dzx))
        {
          paramString = (aic)paramString.hWL.hNL.hNQ;
          if ((paramString != null) && (paramString.Gfx != null)) {
            break label205;
          }
          paramString = null;
          paramn = new mb();
          paramn.dzu.dzv = paramString;
          paramn.dzu.dzw = this.ilN;
          paramn.dzu.dzx = this.dzx;
          com.tencent.mm.sdk.b.a.IbL.l(paramn);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label205:
        paramString = paramString.Gfx.toByteArray();
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
      if (this.Exh != null) {
        this.Exh.setEnabled(false);
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
        if (this.Exh != null)
        {
          this.Exh.setEnabled(true);
          this.Exh.setText(2131766165);
        }
        if (this.Exi != null) {
          this.Exi.setVisibility(4);
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