package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.b;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ri;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements com.tencent.mm.ah.f, aq
{
  private boolean ije;
  private ProgressDialog nTd = null;
  private com.tencent.mm.sdk.b.c osA = new com.tencent.mm.sdk.b.c() {};
  private boolean rDS = false;
  private boolean rDY;
  private ImageButton rDZ;
  private ImageButton rEa;
  private ImageView rEb;
  private int rEc;
  private int rEd;
  private int rEe;
  private Animator rEf;
  private int rEg;
  
  private void apa()
  {
    if (!bk.bl(l.ezq))
    {
      ((TextView)findViewById(R.h.status_desc)).setText(l.ezq);
      if (l.Qr() != 1) {
        break label72;
      }
      if (this.rDY) {
        break label395;
      }
      this.rEb.setImageResource(R.k.connect_pc_mute);
      this.rEb.setPadding(this.rEd - this.rEc, this.rEe, 0, 0);
    }
    label72:
    label248:
    do
    {
      return;
      if (l.Qr() != 2) {
        break;
      }
      if (this.rDY) {
        ((TextView)findViewById(R.h.prompt_desc)).setText(R.l.webwx_open_notify_prompt);
      }
      for (;;)
      {
        if (!this.ije) {
          break label248;
        }
        ((TextView)findViewById(R.h.status_desc)).setText(getString(R.l.webwx_lock_desc, new Object[] { "Mac" }));
        this.rEb.setImageResource(R.k.connect_mac_lock);
        this.rEb.setPadding(0, this.rEe, 0, 0);
        if ((!com.tencent.mm.m.f.zQ()) || (this.rDY)) {
          break;
        }
        ((TextView)findViewById(R.h.prompt_desc)).setText(R.l.webwx_close_notify_prompt);
        this.rEb.setImageResource(R.k.connect_mac_mute_lock);
        this.rEb.setPadding(this.rEd - this.rEc, this.rEe, 0, 0);
        return;
        if (!com.tencent.mm.m.f.zQ()) {
          ((TextView)findViewById(R.h.prompt_desc)).setText("");
        }
      }
      ((TextView)findViewById(R.h.status_desc)).setText(getString(R.l.webwx_login_desc, new Object[] { "Mac" }));
      this.rEb.setImageResource(R.k.connect_mac);
      this.rEb.setPadding(0, this.rEe, 0, 0);
    } while ((!com.tencent.mm.m.f.zQ()) || (this.rDY));
    ((TextView)findViewById(R.h.prompt_desc)).setText(R.l.webwx_close_notify_prompt);
    this.rEb.setImageResource(R.k.connect_mac_mute);
    this.rEb.setPadding(this.rEd - this.rEc, this.rEe, 0, 0);
    return;
    if (l.Qr() == 3)
    {
      this.rEb.setImageResource(R.k.connect_ipad);
      this.rEb.setPadding(0, this.rEe, 0, 0);
      return;
    }
    label395:
    this.rEb.setImageResource(R.k.connect_pc);
    this.rEb.setPadding(0, this.rEe, 0, 0);
  }
  
  private void ly(boolean paramBoolean)
  {
    if (this.rDZ != null)
    {
      if (paramBoolean)
      {
        this.rDZ.setImageResource(R.g.webwx_unlock_bt);
        ((TextView)findViewById(R.h.webwx_lockBt_txt)).setText(R.l.webwx_unlock);
      }
    }
    else {
      return;
    }
    this.rDZ.setImageResource(R.g.webwx_lock_bt);
    ((TextView)findViewById(R.h.webwx_lockBt_txt)).setText(R.l.webwx_lock);
  }
  
  private void lz(boolean paramBoolean)
  {
    if (this.rEa != null)
    {
      if (paramBoolean) {
        this.rEa.setImageResource(R.g.webwx_close_notify_bt);
      }
    }
    else {
      return;
    }
    this.rEa.setImageResource(R.g.webwx_open_notify_bt);
  }
  
  public final void Hn()
  {
    au.Hx();
    if (!com.tencent.mm.model.c.Fs()) {
      finish();
    }
    while ((!l.Qt()) || (this.ije)) {
      return;
    }
    y.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
    this.ije = true;
    ly(this.ije);
    apa();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
  }
  
  protected final int getLayoutId()
  {
    return R.i.webwxlogout;
  }
  
  protected final void initView()
  {
    setMMTitle("");
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(an.n(getResources().getColor(R.e.statusbar_fg_color), this.mController.czv()));
    }
    Object localObject;
    label212:
    Drawable localDrawable;
    if (!com.tencent.mm.m.f.zQ())
    {
      findViewById(R.h.closeNotiBt_layout).setVisibility(8);
      this.rDY = false;
      this.rEb = ((ImageView)findViewById(R.h.status_icon));
      y.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + l.Qv());
      if (l.Qv()) {
        break label448;
      }
      localObject = AnimatorInflater.loadAnimator(this, R.b.fade_in_property_anim);
      ((Animator)localObject).setTarget(findViewById(R.h.webwx_lock_progress));
      this.rEf = AnimatorInflater.loadAnimator(this, R.b.fade_out_property_anim);
      this.rEf.setTarget(findViewById(R.h.webwx_lock_progress));
      this.rEf.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
        }
      });
      this.ije = l.Qt();
      this.rDZ = ((ImageButton)findViewById(R.h.webwx_lock));
      ly(this.ije);
      this.rDZ.setOnClickListener(new WebWXLogoutUI.3(this, (Animator)localObject));
      localObject = (ImageButton)findViewById(R.h.webwx_file_transfer);
      y.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + l.Qw());
      if (l.Qw()) {
        break label463;
      }
      ((ImageButton)localObject).setOnClickListener(new WebWXLogoutUI.4(this));
      label265:
      localObject = (Button)findViewById(R.h.webwx_logout_bt);
      ((Button)localObject).setText(l.ezy);
      ((Button)localObject).setOnClickListener(new WebWXLogoutUI.5(this));
      ((TextView)findViewById(R.h.webwx_logout_closeBt)).setOnClickListener(new WebWXLogoutUI.6(this));
      if (l.Qr() != 1) {
        break label472;
      }
      localObject = getResources().getDrawable(R.k.connect_pc);
      localDrawable = getResources().getDrawable(R.k.connect_pc_mute);
      if ((localObject != null) && (localDrawable != null))
      {
        this.rEc = ((Drawable)localObject).getIntrinsicWidth();
        this.rEd = localDrawable.getIntrinsicWidth();
      }
    }
    for (;;)
    {
      this.rEb.post(new WebWXLogoutUI.7(this));
      return;
      this.rEa = ((ImageButton)findViewById(R.h.webwx_close_notify));
      if (q.hH(q.Gp())) {}
      for (this.rDY = true;; this.rDY = false)
      {
        lz(this.rDY);
        this.rEa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = WebWXLogoutUI.this;
            if (!WebWXLogoutUI.a(WebWXLogoutUI.this)) {}
            for (boolean bool = true;; bool = false)
            {
              WebWXLogoutUI.a(paramAnonymousView, bool);
              WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.a(WebWXLogoutUI.this));
              WebWXLogoutUI.b(WebWXLogoutUI.this);
              return;
            }
          }
        });
        break;
      }
      label448:
      findViewById(R.h.lockBt_layout).setVisibility(8);
      break label212;
      label463:
      ((ImageButton)localObject).setVisibility(8);
      break label265;
      label472:
      if (l.Qr() == 2)
      {
        localObject = getResources().getDrawable(R.k.connect_mac);
        localDrawable = getResources().getDrawable(R.k.connect_mac_mute);
        if ((localObject != null) && (localDrawable != null))
        {
          this.rEc = ((Drawable)localObject).getIntrinsicWidth();
          this.rEd = localDrawable.getIntrinsicWidth();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    if (getIntent() != null) {
      this.rEg = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    au.Dk().a(281, this);
    au.Dk().a(792, this);
    au.Hx();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.udP.c(this.osA);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    au.Dk().b(281, this);
    au.Dk().b(792, this);
    au.Hx();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.udP.d(this.osA);
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
      com.tencent.mm.model.c.Fv().b(new i.a(23, localzr));
      this.rDS = false;
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.nTd != null)
    {
      this.nTd.dismiss();
      this.nTd = null;
    }
    if (paramm.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, R.l.webwx_logout_error_txt, 1).show();
      }
      finish();
    }
    while (paramm.getType() != 792) {
      return;
    }
    int i = ((b)paramm).bMC;
    if (this.rEf != null) {
      this.rEf.start();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        Toast.makeText(this, R.l.webwx_lock_error_txt, 0).show();
        return;
      }
      Toast.makeText(this, R.l.webwx_unlock_error_txt, 0).show();
      return;
    }
    boolean bool;
    if (i == 1)
    {
      bool = true;
      this.ije = bool;
      l.ca(this.ije);
      apa();
      if (!this.ije) {
        break label187;
      }
    }
    label187:
    for (paramString = "lock";; paramString = "unlock")
    {
      y.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */