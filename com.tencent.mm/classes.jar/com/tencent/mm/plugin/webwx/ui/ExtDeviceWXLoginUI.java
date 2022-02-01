package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ady;
import com.tencent.mm.autogen.a.op;
import com.tencent.mm.autogen.a.op.a;
import com.tencent.mm.autogen.a.oq;
import com.tencent.mm.autogen.a.oq.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.webwx.model.e;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMSecDataActivity
  implements h
{
  private ProgressDialog FPA;
  private boolean JTq;
  private String JTu;
  private String KQa;
  private String XwU;
  private int XwV;
  private int XwW;
  private boolean XwX;
  private Button XwY;
  private TextView XwZ;
  private String Xxa;
  private int Xxb;
  private String Xxc;
  private TextView Xxd;
  private TextView Xxe;
  private TextView Xxf;
  private RelativeLayout Xxg;
  private CheckBox Xxh;
  private RelativeLayout Xxi;
  private CheckBox Xxj;
  private IListener<ady> Xxk;
  private boolean hRu;
  private String hZO;
  private int qvo;
  private int type;
  
  public ExtDeviceWXLoginUI()
  {
    AppMethodBeat.i(265347);
    this.type = 0;
    this.hZO = null;
    this.XwU = null;
    this.JTu = null;
    this.FPA = null;
    this.XwX = false;
    this.JTq = false;
    this.hRu = false;
    this.Xxa = "";
    this.Xxb = 0;
    this.qvo = 0;
    this.KQa = "";
    this.Xxk = new ExtDeviceWXLoginUI.10(this, f.hfK);
    AppMethodBeat.o(265347);
  }
  
  private boolean X(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(265363);
    int k = paramInt1 / com.tencent.mm.cd.a.fromDPToPix(this, paramInt2);
    int m = this.Xxe.getMeasuredWidth();
    int j;
    int i;
    if (this.Xxf.getVisibility() == 0)
    {
      j = (int)this.Xxf.getPaint().measureText(paramString);
      if (m > 0)
      {
        i = j / m + 0;
        paramInt1 = i;
        if (j % m <= 0) {}
      }
    }
    for (paramInt1 = i + 1;; paramInt1 = 0)
    {
      if (this.Xxe.getVisibility() == 0)
      {
        int n = (int)this.Xxe.getPaint().measureText(paramString);
        if (m > 0)
        {
          j = n / m + 0;
          i = j;
          if (n % m <= 0) {}
        }
      }
      for (i = j + 1;; i = 0)
      {
        if (paramInt1 + i > k)
        {
          AppMethodBeat.o(265363);
          return false;
        }
        paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this, paramInt2);
        this.Xxf.setTextSize(0, paramInt1);
        this.Xxe.setTextSize(0, paramInt1);
        AppMethodBeat.o(265363);
        return true;
      }
    }
  }
  
  private boolean bE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(265351);
    Log.i("MicroMsg.ExtDeviceWXLoginUI", "doDeviceWXLogin synchronize:%s, autoLogin:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    final e locale = new e(this.hZO, this.JTu, paramBoolean1, paramBoolean2);
    bh.aZW().a(locale, 0);
    this.FPA = k.a(getContext(), getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(265340);
        bh.aZW().a(locale);
        if (ExtDeviceWXLoginUI.k(ExtDeviceWXLoginUI.this) != null) {
          ExtDeviceWXLoginUI.k(ExtDeviceWXLoginUI.this).cancel();
        }
        AppMethodBeat.o(265340);
      }
    });
    AppMethodBeat.o(265351);
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
    return R.i.giQ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30204);
    setMMTitle(null);
    setBackBtn(new ExtDeviceWXLoginUI.1(this), R.k.actionbar_icon_close_black);
    hideActionbarLine();
    this.hZO = getIntent().getStringExtra("intent.key.login.url");
    this.XwU = getIntent().getStringExtra("intent.key.auto.login.switch.tip.string");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.qvo = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.JTu = getIntent().getStringExtra("intent.key.ok.session.list");
    this.XwV = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.XwW = getIntent().getIntExtra("intent.key.function.control", 0);
    this.KQa = getIntent().getStringExtra("intent.key.usage.link");
    this.Xxa = getIntent().getStringExtra("intent.key.spam.url");
    this.Xxb = getIntent().getIntExtra("intent.key.multi.device.tips.type", 0);
    this.Xxc = getIntent().getStringExtra("intent.key.multi.device.tips.string");
    Log.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s usage:%s iconType:%s multiDeviceTipsType:%s multiDeviceTipsStr:%s, funcCtrl:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1, this.KQa, Integer.valueOf(this.qvo), Integer.valueOf(this.Xxb), Util.secPrint(this.Xxc), Integer.valueOf(this.XwW) });
    setMMTitle("");
    this.Xxd = ((TextView)findViewById(R.h.fYg));
    if (!Util.isNullOrNil((String)localObject2)) {
      this.Xxd.setText((CharSequence)localObject2);
    }
    localObject2 = new op();
    ((op)localObject2).publish();
    int i = ((op)localObject2).hRn.hRo;
    int j = ((op)localObject2).hRn.hRp;
    int k = ((op)localObject2).hRn.hRq;
    boolean bool;
    switch (this.qvo)
    {
    default: 
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOW, Integer.valueOf(0));
      this.Xxf = ((TextView)findViewById(R.h.fOP));
      if ((this.Xxb != 0) && (Util.isNullOrNil(this.Xxc))) {
        this.Xxb = 0;
      }
      this.Xxi = ((RelativeLayout)findViewById(R.h.fYA));
      this.Xxj = ((CheckBox)findViewById(R.h.fYz));
      if (i >= 0)
      {
        if ((this.XwW & 0x1) <= 0) {
          break;
        }
        bool = true;
        label541:
        Log.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qvo) });
        if (((this.qvo == 1) && (this.XwV >= j)) || ((this.qvo == 2) && (this.XwV >= k)))
        {
          this.JTq = true;
          this.Xxi.setVisibility(0);
          if (bool)
          {
            bh.bCz();
            if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acOV, Boolean.TRUE)).booleanValue()) {
              break label1036;
            }
          }
          this.Xxj.setChecked(false);
          label654:
          this.Xxi.setOnClickListener(new ExtDeviceWXLoginUI.2(this));
        }
      }
      this.Xxg = ((RelativeLayout)findViewById(R.h.fsu));
      this.Xxh = ((CheckBox)findViewById(R.h.fss));
      if ((this.XwW & 0x2) > 0)
      {
        this.Xxg.setVisibility(0);
        if ((this.XwW & 0x4) > 0)
        {
          bool = true;
          label726:
          this.Xxh.setChecked(bool);
          this.Xxg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(30197);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              boolean bool;
              if (ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this).isChecked())
              {
                paramAnonymousView = ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this);
                if (!ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this).isChecked())
                {
                  bool = true;
                  paramAnonymousView.setChecked(bool);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30197);
                return;
                bool = false;
                break;
                k.b(ExtDeviceWXLoginUI.this.getContext(), Util.nullAs(ExtDeviceWXLoginUI.c(ExtDeviceWXLoginUI.this), ExtDeviceWXLoginUI.this.getContext().getString(R.l.gYP)), ExtDeviceWXLoginUI.this.getContext().getString(R.l.gYR), ExtDeviceWXLoginUI.this.getContext().getString(R.l.gYQ), ExtDeviceWXLoginUI.this.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(265326);
                    paramAnonymous2DialogInterface = ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this);
                    if (!ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this).isChecked()) {}
                    for (boolean bool = true;; bool = false)
                    {
                      paramAnonymous2DialogInterface.setChecked(bool);
                      AppMethodBeat.o(265326);
                      return;
                    }
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
            }
          });
          label750:
          this.Xxe = ((TextView)findViewById(R.h.fYc));
          this.Xxh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265333);
              if (ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this) != null) {
                ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this, this.val$content);
              }
              AppMethodBeat.o(265333);
            }
          });
          if (!Util.isNullOrNil(this.KQa)) {
            addIconOptionMenu(0, R.k.icons_outlined_help, new ExtDeviceWXLoginUI.5(this));
          }
          localObject1 = (ImageView)findViewById(R.h.status_icon);
          if (this.qvo == 1) {
            break label1163;
          }
          if (this.qvo != 2) {
            break label1065;
          }
          ((ImageView)localObject1).setImageResource(R.k.connect_mac);
          label844:
          this.XwZ = ((TextView)findViewById(R.h.gdo));
          this.XwZ.setText(str2);
          this.XwZ.setOnClickListener(new ExtDeviceWXLoginUI.6(this));
          this.XwY = ((Button)findViewById(R.h.gdn));
          if (Util.isNullOrNil(str1)) {
            break label1230;
          }
          this.XwY.setText(str1);
          if (this.type != 0) {
            break label1174;
          }
          this.XwY.setEnabled(true);
        }
      }
      break;
    }
    for (;;)
    {
      this.XwY.setOnClickListener(new ExtDeviceWXLoginUI.7(this));
      bh.aZW().a(972, this);
      bh.aZW().a(973, this);
      AppMethodBeat.o(30204);
      return;
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOW, Integer.valueOf(3));
      break;
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOW, Integer.valueOf(4));
      break;
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOW, Integer.valueOf(2));
      break;
      bool = false;
      break label541;
      label1036:
      this.Xxj.setChecked(true);
      break label654;
      bool = false;
      break label726;
      this.Xxg.setVisibility(8);
      break label750;
      label1065:
      if (this.qvo == 3)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_ipad);
        break label844;
      }
      if (this.qvo == 5)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_wx_album);
        break label844;
      }
      if (this.qvo == 6)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_car);
        break label844;
      }
      if (this.qvo == 8)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_android_pad);
        break label844;
      }
      if (this.qvo == 10)
      {
        ((ImageView)localObject1).setImageResource(R.k.connect_folder);
        break label844;
      }
      label1163:
      ((ImageView)localObject1).setImageResource(R.k.connect_pc);
      break label844;
      label1174:
      if (this.type == -1)
      {
        this.XwY.setEnabled(false);
        if (this.qvo == 5) {
          this.XwZ.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.XwY.setEnabled(true);
        continue;
        label1230:
        this.XwY.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30202);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(R.e.webwx_bg_color));
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    this.Xxk.alive();
    AppMethodBeat.o(30202);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30207);
    this.Xxk.dead();
    super.onDestroy();
    bh.aZW().b(972, this);
    bh.aZW().b(973, this);
    AppMethodBeat.o(30207);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30205);
    super.onPause();
    cas localcas;
    if ((this.XwX) && (bh.baz()))
    {
      localcas = new cas();
      localcas.aajJ = 27;
      if (!z.aRx()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localcas.NkL = i;
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(23, localcas));
      this.XwX = false;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(30208);
    if (this.FPA != null)
    {
      this.FPA.dismiss();
      this.FPA = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      bh.aZW().b(972, this);
      if (paramp.getType() == 972)
      {
        e locale = (e)paramp;
        if ((locale.JTq) || (this.hRu))
        {
          paramString = (apk)c.c.b(locale.oDw.otC);
          if ((paramString != null) && (paramString.Zwy != null)) {
            break label246;
          }
          paramString = null;
          paramp = new oq();
          paramp.hRr.hRs = paramString;
          paramp.hRr.hRt = this.qvo;
          paramp.hRr.hRu = this.hRu;
          oq.a locala = paramp.hRr;
          paramString = (apk)c.c.b(locale.oDw.otC);
          if ((paramString != null) && (paramString.Zwz != null)) {
            break label257;
          }
          paramString = null;
          label218:
          locala.hRv = paramString;
          paramp.publish();
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(30208);
        return;
        label246:
        paramString = paramString.Zwy.toByteArray();
        break;
        label257:
        paramString = paramString.Zwz;
        break label218;
        paramp.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!Util.isNullOrNil(paramString))
      {
        ((TextView)findViewById(R.h.fYc)).setVisibility(0);
        ((TextView)findViewById(R.h.fYc)).setText(paramString);
      }
      if (this.type != -1) {
        break label394;
      }
      if (this.XwY != null) {
        this.XwY.setEnabled(false);
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
      label394:
      if (this.type == -2)
      {
        if (this.XwY != null)
        {
          this.XwY.setEnabled(true);
          this.XwY.setText(R.l.gYU);
        }
        if (this.XwZ != null) {
          this.XwZ.setVisibility(4);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(265411);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.webwx.ui.a.a.class);
    AppMethodBeat.o(265411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */