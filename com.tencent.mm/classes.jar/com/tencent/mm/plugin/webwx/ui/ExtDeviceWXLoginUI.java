package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.acb;
import com.tencent.mm.f.a.ni;
import com.tencent.mm.f.a.ni.a;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements i
{
  private ProgressDialog Apv;
  private boolean Ecm;
  private String Ecp;
  private int QEc;
  private int QEd;
  private boolean QEe;
  private Button QEf;
  private TextView QEg;
  private ImageView QEh;
  private String QEi;
  private String QEj;
  private IListener<acb> QEk;
  private boolean fLM;
  private String fTQ;
  private int lZJ;
  private int type;
  
  public ExtDeviceWXLoginUI()
  {
    AppMethodBeat.i(291912);
    this.type = 0;
    this.fTQ = null;
    this.Ecp = null;
    this.Apv = null;
    this.QEe = false;
    this.Ecm = false;
    this.fLM = false;
    this.QEi = "";
    this.lZJ = 0;
    this.QEj = "";
    this.QEk = new IListener() {};
    AppMethodBeat.o(291912);
  }
  
  private boolean Dz(boolean paramBoolean)
  {
    AppMethodBeat.i(291914);
    final e locale = new e(this.fTQ, this.Ecp, paramBoolean);
    bh.aGY().a(locale, 0);
    this.Apv = h.a(getContext(), getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(30200);
        bh.aGY().a(locale);
        if (ExtDeviceWXLoginUI.i(ExtDeviceWXLoginUI.this) != null) {
          ExtDeviceWXLoginUI.i(ExtDeviceWXLoginUI.this).cancel();
        }
        AppMethodBeat.o(30200);
      }
    });
    AppMethodBeat.o(291914);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(30206);
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(30206);
  }
  
  public int getLayoutId()
  {
    return R.i.efR;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30204);
    this.fTQ = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.lZJ = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.Ecp = getIntent().getStringExtra("intent.key.ok.session.list");
    this.QEc = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.QEd = getIntent().getIntExtra("intent.key.function.control", 0);
    this.QEj = getIntent().getStringExtra("intent.key.usage.link");
    this.QEi = getIntent().getStringExtra("intent.key.spam.url");
    Log.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s iconType:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.QEj, Integer.valueOf(this.lZJ) });
    setMMTitle("");
    this.QEh = ((ImageView)findViewById(R.h.eaB));
    if (!Util.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(R.h.dVJ)).setText((CharSequence)localObject2);
    }
    localObject2 = new ni();
    EventCenter.instance.publish((IEvent)localObject2);
    int i = ((ni)localObject2).fLF.fLG;
    int j = ((ni)localObject2).fLF.fLH;
    int k = ((ni)localObject2).fLF.fLI;
    switch (this.lZJ)
    {
    default: 
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnB, Integer.valueOf(0));
      if (!Util.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(R.h.dVF)).setVisibility(8);
        ((TextView)findViewById(R.h.dVE)).setVisibility(0);
        ((TextView)findViewById(R.h.dVE)).setText((CharSequence)localObject1);
        label421:
        if (!Util.isNullOrNil(this.QEj))
        {
          this.QEh.setVisibility(0);
          this.QEh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30195);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              paramAnonymousView = new Intent();
              if (ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this)) {
                paramAnonymousView.putExtra("title", ExtDeviceWXLoginUI.this.getString(R.l.eVJ));
              }
              paramAnonymousView.putExtra("rawUrl", ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this) + "&lang=" + LocaleUtil.getApplicationLanguage());
              paramAnonymousView.putExtra("showShare", false);
              paramAnonymousView.putExtra("neverGetA8Key", false);
              com.tencent.mm.by.c.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(30195);
            }
          });
        }
        localObject1 = (ImageView)findViewById(R.h.status_icon);
        if (this.lZJ == 1) {
          break label1024;
        }
        if (this.lZJ != 2) {
          break label897;
        }
        ((ImageView)localObject1).setImageResource(R.k.connect_mac);
        label490:
        this.QEg = ((TextView)findViewById(R.h.eaJ));
        this.QEg.setText(str2);
        this.QEg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30196);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30196);
          }
        });
        this.QEf = ((Button)findViewById(R.h.eaG));
        if (Util.isNullOrNil(str1)) {
          break label1091;
        }
        this.QEf.setText(str1);
        if (this.type != 0) {
          break label1035;
        }
        this.QEf.setEnabled(true);
      }
      break;
    }
    for (;;)
    {
      this.QEf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30197);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.ExtDeviceWXLoginUI", "spam url %s", new Object[] { ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) });
          if ((ExtDeviceWXLoginUI.e(ExtDeviceWXLoginUI.this) == 0) && (!Util.isNullOrNil(ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this)))) {
            ExtDeviceWXLoginUI.ci(ExtDeviceWXLoginUI.this, ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30197);
            return;
            ExtDeviceWXLoginUI.f(ExtDeviceWXLoginUI.this);
          }
        }
      });
      getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(30198);
          ExtDeviceWXLoginUI.g(ExtDeviceWXLoginUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ExtDeviceWXLoginUI.h(ExtDeviceWXLoginUI.this);
          AppMethodBeat.o(30198);
        }
      });
      ((ImageView)findViewById(R.h.eaI)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30199);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ExtDeviceWXLoginUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30199);
        }
      });
      bh.aGY().a(972, this);
      bh.aGY().a(973, this);
      AppMethodBeat.o(30204);
      return;
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnB, Integer.valueOf(3));
      break;
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnB, Integer.valueOf(4));
      break;
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnB, Integer.valueOf(2));
      break;
      if (i < 0) {
        break label421;
      }
      if ((this.QEd & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.lZJ) });
        if (((this.lZJ != 1) || (this.QEc < j)) && ((this.lZJ != 2) || (this.QEc < k))) {
          break;
        }
        this.Ecm = true;
        ((TextView)findViewById(R.h.dVE)).setVisibility(8);
        ((CheckBox)findViewById(R.h.dVF)).setVisibility(0);
        ((CheckBox)findViewById(R.h.dVF)).setText(R.l.eVJ);
        if (bool)
        {
          bh.beI();
          if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnA, Boolean.TRUE)).booleanValue()) {
            break;
          }
        }
        ((CheckBox)findViewById(R.h.dVF)).setChecked(false);
        break;
      }
      label897:
      if (this.lZJ == 3)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_ipad);
        break label490;
      }
      if (this.lZJ == 5)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_wx_album);
        break label490;
      }
      if (this.lZJ == 6)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_car);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.ci.a.aY(this, R.f.dlW);
        ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.ci.a.aY(this, R.f.dlW);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject1).setAlpha(0.3F);
        break label490;
      }
      if (this.lZJ == 8)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_android_pad);
        break label490;
      }
      label1024:
      ((ImageView)localObject1).setImageResource(R.k.connect_pc);
      break label490;
      label1035:
      if (this.type == -1)
      {
        this.QEf.setEnabled(false);
        if (this.lZJ == 5) {
          this.QEg.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.QEf.setEnabled(true);
        continue;
        label1091:
        this.QEf.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30202);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    setActionbarColor(getResources().getColor(R.e.BG_2));
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    this.QEk.alive();
    AppMethodBeat.o(30202);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30207);
    this.QEk.dead();
    super.onDestroy();
    bh.aGY().b(972, this);
    bh.aGY().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    bmy localbmy;
    if ((this.QEe) && (bh.aHB()))
    {
      localbmy = new bmy();
      localbmy.SXP = 27;
      if (!z.awX()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localbmy.HmX = i;
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(23, localbmy));
      this.QEe = false;
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
    if (this.Apv != null)
    {
      this.Apv.dismiss();
      this.Apv = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      bh.aGY().b(972, this);
      if (paramq.getType() == 972)
      {
        paramString = (e)paramq;
        if ((paramString.Ecm) || (this.fLM))
        {
          paramString = (alz)d.c.b(paramString.lKU.lBS);
          if ((paramString != null) && (paramString.Swl != null)) {
            break label206;
          }
          paramString = null;
          paramq = new nj();
          paramq.fLJ.fLK = paramString;
          paramq.fLJ.fLL = this.lZJ;
          paramq.fLJ.fLM = this.fLM;
          EventCenter.instance.publish(paramq);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label206:
        paramString = paramString.Swl.toByteArray();
        break;
        paramq.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!Util.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(R.h.dVF)).setVisibility(8);
        ((TextView)findViewById(R.h.dVE)).setVisibility(0);
        ((TextView)findViewById(R.h.dVE)).setText(paramString);
      }
      if (this.type != -1) {
        break label362;
      }
      if (this.QEf != null) {
        this.QEf.setEnabled(false);
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
      label362:
      if (this.type == -2)
      {
        if (this.QEf != null)
        {
          this.QEf.setEnabled(true);
          this.QEf.setText(R.l.eVK);
        }
        if (this.QEg != null) {
          this.QEg.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */