package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements com.tencent.mm.ai.f, as
{
  private boolean kke;
  private ProgressDialog qHd;
  private com.tencent.mm.sdk.b.c rhr;
  private boolean vuA;
  private ImageButton vuB;
  private ImageButton vuC;
  private ImageView vuD;
  private int vuE;
  private int vuF;
  private int vuG;
  private Animator vuH;
  private int vuI;
  private boolean vuu;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(26549);
    this.qHd = null;
    this.vuu = false;
    this.rhr = new WebWXLogoutUI.9(this);
    AppMethodBeat.o(26549);
  }
  
  private void aMi()
  {
    AppMethodBeat.i(26555);
    if (!bo.isNullOrNil(n.fPf))
    {
      ((TextView)findViewById(2131829556)).setText(n.fPf);
      if (n.ajy() == 1)
      {
        if (!this.vuA)
        {
          this.vuD.setImageResource(2131231179);
          this.vuD.setPadding(this.vuF - this.vuE, this.vuG, 0, 0);
          AppMethodBeat.o(26555);
        }
      }
      else
      {
        if (n.ajy() == 2)
        {
          if (this.vuA) {
            ((TextView)findViewById(2131829557)).setText(2131305928);
          }
          while (this.kke)
          {
            ((TextView)findViewById(2131829556)).setText(getString(2131305912, new Object[] { "Mac" }));
            this.vuD.setImageResource(2131231173);
            this.vuD.setPadding(0, this.vuG, 0, 0);
            if ((!com.tencent.mm.m.f.Mx()) || (this.vuA)) {
              break label430;
            }
            ((TextView)findViewById(2131829557)).setText(2131305908);
            this.vuD.setImageResource(2131231175);
            this.vuD.setPadding(this.vuF - this.vuE, this.vuG, 0, 0);
            AppMethodBeat.o(26555);
            return;
            if (!com.tencent.mm.m.f.Mx()) {
              ((TextView)findViewById(2131829557)).setText("");
            }
          }
          ((TextView)findViewById(2131829556)).setText(getString(2131305915, new Object[] { "Mac" }));
          this.vuD.setImageResource(2131231172);
          this.vuD.setPadding(0, this.vuG, 0, 0);
          if ((!com.tencent.mm.m.f.Mx()) || (this.vuA)) {
            break label430;
          }
          ((TextView)findViewById(2131829557)).setText(2131305908);
          this.vuD.setImageResource(2131231174);
          this.vuD.setPadding(this.vuF - this.vuE, this.vuG, 0, 0);
          AppMethodBeat.o(26555);
          return;
        }
        if (n.ajy() == 3)
        {
          this.vuD.setImageResource(2131231171);
          this.vuD.setPadding(0, this.vuG, 0, 0);
          AppMethodBeat.o(26555);
          return;
        }
      }
      this.vuD.setImageResource(2131231177);
      this.vuD.setPadding(0, this.vuG, 0, 0);
    }
    label430:
    AppMethodBeat.o(26555);
  }
  
  private boolean dhk()
  {
    AppMethodBeat.i(26558);
    if (!aw.RG())
    {
      AppMethodBeat.o(26558);
      return false;
    }
    int i = r.Zt();
    if (this.vuA) {
      i |= 0x2000;
    }
    for (;;)
    {
      com.tencent.mm.m.f.iW(i);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(40, Integer.valueOf(i));
      this.vuu = true;
      aMi();
      AppMethodBeat.o(26558);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(26556);
    if (this.vuB != null)
    {
      if (paramBoolean)
      {
        this.vuB.setImageResource(2130840924);
        ((TextView)findViewById(2131829564)).setText(2131305929);
        AppMethodBeat.o(26556);
        return;
      }
      this.vuB.setImageResource(2130840922);
      ((TextView)findViewById(2131829564)).setText(2131305911);
    }
    AppMethodBeat.o(26556);
  }
  
  private void oK(boolean paramBoolean)
  {
    AppMethodBeat.i(26557);
    if (this.vuC != null)
    {
      if (paramBoolean)
      {
        this.vuC.setImageResource(2130840920);
        AppMethodBeat.o(26557);
        return;
      }
      this.vuC.setImageResource(2130840923);
    }
    AppMethodBeat.o(26557);
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(26560);
    aw.aaz();
    if (!com.tencent.mm.model.c.Yw())
    {
      finish();
      AppMethodBeat.o(26560);
      return;
    }
    if ((n.ajA()) && (!this.kke))
    {
      ab.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.kke = true;
      oJ(this.kke);
      aMi();
    }
    AppMethodBeat.o(26560);
  }
  
  public void finish()
  {
    AppMethodBeat.i(26550);
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(26550);
  }
  
  public int getLayoutId()
  {
    return 2130971310;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26554);
    setMMTitle("");
    setBackBtn(new WebWXLogoutUI.1(this), 2131230735);
    hideActionbarLine();
    Object localObject;
    label202:
    label255:
    Drawable localDrawable;
    if (!com.tencent.mm.m.f.Mx())
    {
      findViewById(2131829558).setVisibility(8);
      this.vuA = false;
      this.vuD = ((ImageView)findViewById(2131823387));
      ab.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + n.ajC());
      if (n.ajC()) {
        break label421;
      }
      localObject = AnimatorInflater.loadAnimator(this, 2131099650);
      ((Animator)localObject).setTarget(findViewById(2131829563));
      this.vuH = AnimatorInflater.loadAnimator(this, 2131099651);
      this.vuH.setTarget(findViewById(2131829563));
      this.vuH.addListener(new WebWXLogoutUI.3(this));
      this.kke = n.ajA();
      this.vuB = ((ImageButton)findViewById(2131829562));
      oJ(this.kke);
      this.vuB.setOnClickListener(new WebWXLogoutUI.4(this, (Animator)localObject));
      localObject = (ImageButton)findViewById(2131829565);
      ab.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + n.ajD());
      if (n.ajD()) {
        break label436;
      }
      ((ImageButton)localObject).setOnClickListener(new WebWXLogoutUI.5(this));
      localObject = (Button)findViewById(2131829566);
      ((Button)localObject).setText(n.fPn);
      ((Button)localObject).setOnClickListener(new WebWXLogoutUI.6(this));
      if (n.ajy() != 1) {
        break label445;
      }
      localObject = getResources().getDrawable(2131231177);
      localDrawable = getResources().getDrawable(2131231179);
      if ((localObject != null) && (localDrawable != null))
      {
        this.vuE = ((Drawable)localObject).getIntrinsicWidth();
        this.vuF = localDrawable.getIntrinsicWidth();
      }
    }
    for (;;)
    {
      this.vuD.post(new WebWXLogoutUI.7(this));
      AppMethodBeat.o(26554);
      return;
      this.vuC = ((ImageButton)findViewById(2131829559));
      if (r.kt(r.Zt())) {}
      for (this.vuA = true;; this.vuA = false)
      {
        oK(this.vuA);
        this.vuC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26539);
            paramAnonymousView = WebWXLogoutUI.this;
            if (!WebWXLogoutUI.a(WebWXLogoutUI.this)) {}
            for (boolean bool = true;; bool = false)
            {
              WebWXLogoutUI.a(paramAnonymousView, bool);
              WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.a(WebWXLogoutUI.this));
              WebWXLogoutUI.b(WebWXLogoutUI.this);
              AppMethodBeat.o(26539);
              return;
            }
          }
        });
        break;
      }
      label421:
      findViewById(2131829561).setVisibility(8);
      break label202;
      label436:
      ((ImageButton)localObject).setVisibility(8);
      break label255;
      label445:
      if (n.ajy() == 2)
      {
        localObject = getResources().getDrawable(2131231172);
        localDrawable = getResources().getDrawable(2131231174);
        if ((localObject != null) && (localDrawable != null))
        {
          this.vuE = ((Drawable)localObject).getIntrinsicWidth();
          this.vuF = localDrawable.getIntrinsicWidth();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26551);
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.vuI = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2131034230, 2131034130);
    aw.Rc().a(281, this);
    aw.Rc().a(792, this);
    aw.aaz();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhr);
    AppMethodBeat.o(26551);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26553);
    super.onDestroy();
    overridePendingTransition(2131034130, 2131034228);
    aw.Rc().b(281, this);
    aw.Rc().b(792, this);
    aw.aaz();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.rhr);
    AppMethodBeat.o(26553);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26552);
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
      com.tencent.mm.model.c.Yz().c(new j.a(23, localaek));
      this.vuu = false;
      AppMethodBeat.o(26552);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26559);
    if (this.qHd != null)
    {
      this.qHd.dismiss();
      this.qHd = null;
    }
    if (paramm.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, 2131305926, 1).show();
      }
      finish();
      AppMethodBeat.o(26559);
      return;
    }
    boolean bool;
    if (paramm.getType() == 792)
    {
      int i = ((b)paramm).ctW;
      if (this.vuH != null) {
        this.vuH.start();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (i == 1)
        {
          Toast.makeText(this, 2131305913, 0).show();
          AppMethodBeat.o(26559);
          return;
        }
        Toast.makeText(this, 2131305930, 0).show();
        AppMethodBeat.o(26559);
        return;
      }
      if (i != 1) {
        break label211;
      }
      bool = true;
      this.kke = bool;
      n.dd(this.kke);
      aMi();
      if (!this.kke) {
        break label217;
      }
    }
    label211:
    label217:
    for (paramString = "lock";; paramString = "unlock")
    {
      ab.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
      AppMethodBeat.o(26559);
      return;
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */