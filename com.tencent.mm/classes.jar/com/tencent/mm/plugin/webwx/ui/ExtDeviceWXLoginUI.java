package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.mr.a;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements i
{
  private int JFo;
  private int JFp;
  private boolean JFq = false;
  private Button JFr;
  private TextView JFs;
  private ImageView JFt;
  private String JFu = "";
  private boolean dSp = false;
  private String dZW = null;
  private int jjN = 0;
  private int type = 0;
  private ProgressDialog vIA = null;
  private boolean yAX = false;
  private String yBa = null;
  
  public void finish()
  {
    AppMethodBeat.i(30206);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(30206);
  }
  
  public int getLayoutId()
  {
    return 2131493838;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30204);
    this.dZW = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.jjN = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
    this.JFo = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.JFp = getIntent().getIntExtra("intent.key.function.control", 0);
    this.JFu = getIntent().getStringExtra("intent.key.usage.link");
    Log.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s iconType:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.JFu, Integer.valueOf(this.jjN) });
    setMMTitle("");
    this.JFt = ((ImageView)findViewById(2131310408));
    if (!Util.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131308404)).setText((CharSequence)localObject2);
    }
    localObject2 = new mr();
    EventCenter.instance.publish((IEvent)localObject2);
    int i = ((mr)localObject2).dSi.dSj;
    int j = ((mr)localObject2).dSi.dSk;
    int k = ((mr)localObject2).dSi.dSl;
    switch (this.jjN)
    {
    default: 
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZB, Integer.valueOf(0));
      if (!Util.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131308395)).setVisibility(8);
        ((TextView)findViewById(2131308394)).setVisibility(0);
        ((TextView)findViewById(2131308394)).setText((CharSequence)localObject1);
        label401:
        if (!Util.isNullOrNil(this.JFu))
        {
          this.JFt.setVisibility(0);
          this.JFt.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(2131768634));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + LocaleUtil.getApplicationLanguage());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              com.tencent.mm.br.c.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(2131308398);
        if (this.jjN == 1) {
          break label1002;
        }
        if (this.jjN != 2) {
          break label875;
        }
        ((ImageView)localObject1).setImageResource(2131690005);
        label469:
        this.JFs = ((TextView)findViewById(2131310416));
        this.JFs.setText(str2);
        this.JFs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30196);
          }
        });
        this.JFr = ((Button)findViewById(2131310413));
        if (Util.isNullOrNil(str1)) {
          break label1069;
        }
        this.JFr.setText(str1);
        if (this.type != 0) {
          break label1013;
        }
        this.JFr.setEnabled(true);
      }
      break;
    }
    label1069:
    for (;;)
    {
      this.JFr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30197);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          boolean bool;
          if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) == 0) {
            if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this))
            {
              bool = ((CheckBox)ExtDeviceWXLoginUI.this.findViewById(2131308395)).isChecked();
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, false);
              if (bool)
              {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.NZA, Boolean.TRUE);
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
            bg.aVF();
            if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZA, Boolean.TRUE)).booleanValue()) {
              ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, true);
            }
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NZA, Boolean.FALSE);
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
              com.tencent.mm.br.c.b(ExtDeviceWXLoginUI.this, "scanner", ".ui.BaseScanUI", paramAnonymousView);
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
      ((ImageView)findViewById(2131310415)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30199);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ExtDeviceWXLoginUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30199);
        }
      });
      bg.azz().a(972, this);
      bg.azz().a(973, this);
      AppMethodBeat.o(30204);
      return;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZB, Integer.valueOf(3));
      break;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZB, Integer.valueOf(4));
      break;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZB, Integer.valueOf(2));
      break;
      if (i < 0) {
        break label401;
      }
      if ((this.JFp & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jjN) });
        if (((this.jjN != 1) || (this.JFo < j)) && ((this.jjN != 2) || (this.JFo < k))) {
          break;
        }
        this.yAX = true;
        ((TextView)findViewById(2131308394)).setVisibility(8);
        ((CheckBox)findViewById(2131308395)).setVisibility(0);
        ((CheckBox)findViewById(2131308395)).setText(2131768634);
        if (bool)
        {
          bg.aVF();
          if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZA, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(2131308395)).setChecked(false);
        break;
      }
      label875:
      if (this.jjN == 3)
      {
        ((ImageView)localObject1).setImageResource(2131690002);
        break label469;
      }
      if (this.jjN == 5)
      {
        ((ImageView)localObject1).setImageResource(2131690014);
        break label469;
      }
      if (this.jjN == 6)
      {
        ((ImageView)localObject1).setImageResource(2131689991);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cb.a.aG(this, 2131167158);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cb.a.aG(this, 2131167158);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject1).setAlpha(0.3F);
        break label469;
      }
      if (this.jjN == 8)
      {
        ((ImageView)localObject1).setImageResource(2131689989);
        break label469;
      }
      label1002:
      ((ImageView)localObject1).setImageResource(2131690010);
      break label469;
      label1013:
      if (this.type == -1)
      {
        this.JFr.setEnabled(false);
        if (this.jjN == 5) {
          this.JFs.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.JFr.setEnabled(true);
        continue;
        this.JFr.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30202);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    setActionbarColor(getResources().getColor(2131099650));
    initView();
    overridePendingTransition(2130772132, 2130771986);
    AppMethodBeat.o(30202);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30207);
    super.onDestroy();
    bg.azz().b(972, this);
    bg.azz().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    bfx localbfx;
    if ((this.JFq) && (bg.aAc()))
    {
      localbfx = new bfx();
      localbfx.LPB = 27;
      if (!z.aqE()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localbfx.BsD = i;
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(23, localbfx));
      this.JFq = false;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30208);
    if (this.vIA != null)
    {
      this.vIA.dismiss();
      this.vIA = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      bg.azz().b(972, this);
      if (paramq.getType() == 972)
      {
        paramString = (e)paramq;
        if ((paramString.yAX) || (this.dSp))
        {
          paramString = (aky)paramString.iUB.iLL.iLR;
          if ((paramString != null) && (paramString.LtO != null)) {
            break label205;
          }
          paramString = null;
          paramq = new ms();
          paramq.dSm.dSn = paramString;
          paramq.dSm.dSo = this.jjN;
          paramq.dSm.dSp = this.dSp;
          EventCenter.instance.publish(paramq);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label205:
        paramString = paramString.LtO.toByteArray();
        break;
        paramq.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!Util.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(2131308395)).setVisibility(8);
        ((TextView)findViewById(2131308394)).setVisibility(0);
        ((TextView)findViewById(2131308394)).setText(paramString);
      }
      if (this.type != -1) {
        break label360;
      }
      if (this.JFr != null) {
        this.JFr.setEnabled(false);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        if (this.JFr != null)
        {
          this.JFr.setEnabled(true);
          this.JFr.setText(2131768638);
        }
        if (this.JFs != null) {
          this.JFs.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */