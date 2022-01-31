package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.kd.a;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class ExtDeviceWXLoginUI
  extends MMActivity
  implements f
{
  private String cGE = null;
  private boolean czP = false;
  private int fPp = 0;
  private ProgressDialog nVm = null;
  private int type = 0;
  private boolean vuh = false;
  private String vur = null;
  private int vus;
  private int vut;
  private boolean vuu = false;
  private Button vuv;
  private TextView vuw;
  
  public void finish()
  {
    AppMethodBeat.i(26532);
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(26532);
  }
  
  public int getLayoutId()
  {
    return 2130969318;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26530);
    this.cGE = getIntent().getStringExtra("intent.key.login.url");
    this.type = getIntent().getIntExtra("intent.key.type", 0);
    Object localObject2 = getIntent().getStringExtra("intent.key.title.string");
    this.fPp = getIntent().getIntExtra("intent.key.icon.type", 0);
    String str1 = getIntent().getStringExtra("intent.key.ok.string");
    String str2 = getIntent().getStringExtra("intent.key.cancel.string");
    Object localObject1 = getIntent().getStringExtra("intent.key.content.string");
    this.vur = getIntent().getStringExtra("intent.key.ok.session.list");
    this.vus = getIntent().getIntExtra("intent.key.login.client.version", 0);
    this.vut = getIntent().getIntExtra("intent.key.function.control", 0);
    ab.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", new Object[] { Integer.valueOf(this.type), localObject2, str1, localObject1 });
    setMMTitle("");
    if (!bo.isNullOrNil((String)localObject2)) {
      ((TextView)findViewById(2131823388)).setText((CharSequence)localObject2);
    }
    localObject2 = new kd();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    int i = ((kd)localObject2).czI.czJ;
    int j = ((kd)localObject2).czI.czK;
    int k = ((kd)localObject2).czI.czL;
    switch (this.fPp)
    {
    default: 
      aw.aaz();
      c.Ru().set(ac.a.yEo, Integer.valueOf(0));
      if (!bo.isNullOrNil((String)localObject1))
      {
        ((CheckBox)findViewById(2131823389)).setVisibility(8);
        ((TextView)findViewById(2131823390)).setVisibility(0);
        ((TextView)findViewById(2131823390)).setText((CharSequence)localObject1);
        label337:
        localObject1 = (ImageView)findViewById(2131823387);
        if (this.fPp == 1) {
          break label833;
        }
        if (this.fPp != 2) {
          break label795;
        }
        ((ImageView)localObject1).setImageResource(2131231172);
        label372:
        this.vuw = ((TextView)findViewById(2131823392));
        this.vuw.setText(str2);
        this.vuw.setOnClickListener(new ExtDeviceWXLoginUI.2(this));
        this.vuv = ((Button)findViewById(2131823391));
        if (bo.isNullOrNil(str1)) {
          break label900;
        }
        this.vuv.setText(str1);
        if (this.type != 0) {
          break label844;
        }
        this.vuv.setEnabled(true);
      }
      break;
    }
    label900:
    for (;;)
    {
      this.vuv.setOnClickListener(new ExtDeviceWXLoginUI.3(this));
      getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ExtDeviceWXLoginUI.4(this));
      ((TextView)findViewById(2131823385)).setOnClickListener(new ExtDeviceWXLoginUI.5(this));
      aw.Rc().a(972, this);
      aw.Rc().a(973, this);
      AppMethodBeat.o(26530);
      return;
      aw.aaz();
      c.Ru().set(ac.a.yEo, Integer.valueOf(3));
      break;
      aw.aaz();
      c.Ru().set(ac.a.yEo, Integer.valueOf(4));
      break;
      if (i < 0) {
        break label337;
      }
      if ((this.vut & 0x1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.fPp) });
        if (((this.fPp != 1) || (this.vus < j)) && ((this.fPp != 2) || (this.vus < k))) {
          break;
        }
        this.vuh = true;
        ((TextView)findViewById(2131823390)).setVisibility(8);
        ((CheckBox)findViewById(2131823389)).setVisibility(0);
        ((CheckBox)findViewById(2131823389)).setText(2131305917);
        if (bool)
        {
          aw.aaz();
          if (((Boolean)c.Ru().get(ac.a.yEn, Boolean.TRUE)).booleanValue()) {}
        }
        else
        {
          ((CheckBox)findViewById(2131823389)).setChecked(false);
        }
        ((ImageView)findViewById(2131823386)).setImageResource(2131231166);
        ((ImageView)findViewById(2131823386)).setOnClickListener(new ExtDeviceWXLoginUI.1(this));
        break;
      }
      label795:
      if (this.fPp == 3)
      {
        ((ImageView)localObject1).setImageResource(2131231171);
        break label372;
      }
      if (this.fPp == 5)
      {
        ((ImageView)localObject1).setImageResource(2131231181);
        break label372;
      }
      label833:
      ((ImageView)localObject1).setImageResource(2131231177);
      break label372;
      label844:
      if (this.type == -1)
      {
        this.vuv.setEnabled(false);
        if (this.fPp == 5) {
          this.vuw.setVisibility(8);
        }
      }
      else if (this.type == -2)
      {
        this.vuv.setEnabled(true);
        continue;
        this.vuv.setVisibility(4);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26528);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    initView();
    overridePendingTransition(2131034230, 2131034130);
    AppMethodBeat.o(26528);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26533);
    super.onDestroy();
    aw.Rc().b(972, this);
    aw.Rc().b(973, this);
    AppMethodBeat.o(26533);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26531);
    super.onPause();
    aek localaek;
    if ((this.vuu) && (aw.RG()))
    {
      localaek = new aek();
      localaek.wXn = 27;
      if (!r.kt(r.Zt())) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 2)
    {
      localaek.pKC = i;
      aw.aaz();
      c.Yz().c(new j.a(23, localaek));
      this.vuu = false;
      AppMethodBeat.o(26531);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26529);
    super.onResume();
    AppMethodBeat.o(26529);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26534);
    if (this.nVm != null)
    {
      this.nVm.dismiss();
      this.nVm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      aw.Rc().b(972, this);
      if (paramm.getType() == 972)
      {
        paramString = (e)paramm;
        if ((paramString.vuh) || (this.czP))
        {
          paramString = (aay)paramString.fBd.fsW.fta;
          if ((paramString != null) && (paramString.wRy != null)) {
            break label205;
          }
          paramString = null;
          paramm = new ke();
          paramm.czM.czN = paramString;
          paramm.czM.czO = this.fPp;
          paramm.czM.czP = this.czP;
          com.tencent.mm.sdk.b.a.ymk.l(paramm);
        }
      }
      for (;;)
      {
        this.type = 0;
        finish();
        AppMethodBeat.o(26534);
        return;
        label205:
        paramString = paramString.wRy.toByteArray();
        break;
        paramm.getType();
      }
    }
    if (paramInt2 == -1)
    {
      this.type = -1;
      if (!bo.isNullOrNil(paramString))
      {
        ((CheckBox)findViewById(2131823389)).setVisibility(8);
        ((TextView)findViewById(2131823390)).setVisibility(0);
        ((TextView)findViewById(2131823390)).setText(paramString);
      }
      if (this.type != -1) {
        break label360;
      }
      if (this.vuv != null) {
        this.vuv.setEnabled(false);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(26534);
      return;
      if (paramInt2 != -2) {
        break;
      }
      this.type = -2;
      break;
      label360:
      if (this.type == -2)
      {
        if (this.vuv != null)
        {
          this.vuv.setEnabled(true);
          this.vuv.setText(2131305921);
        }
        if (this.vuw != null) {
          this.vuw.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI
 * JD-Core Version:    0.7.0.1
 */