package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.m.f;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements g, av
{
  private boolean BAY;
  private boolean BBg;
  private View BBh;
  private View BBi;
  private WeImageView BBj;
  private WeImageView BBk;
  private ImageView BBl;
  private int BBm;
  private int BBn;
  private int BBo;
  private Animator BBp;
  private int BBq;
  private GridLayout BBr;
  private boolean nph;
  private com.tencent.mm.sdk.b.c wHU;
  private ProgressDialog wfA;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.wfA = null;
    this.BAY = false;
    this.wHU = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(30223);
  }
  
  private void erZ()
  {
    AppMethodBeat.i(30229);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.BBr.getChildCount()) });
    if (this.BBr.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.BBr.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.BBr.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.BBr.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.BBr.getChildCount() - 1)
          {
            localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
          }
          else
          {
            localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
            localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
          }
        }
      }
    }
    AppMethodBeat.o(30229);
  }
  
  private boolean esa()
  {
    AppMethodBeat.i(30233);
    if (!az.afw())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = u.aqM();
    if (this.BBg) {
      i |= 0x2000;
    }
    for (;;)
    {
      f.lk(i);
      az.arV();
      com.tencent.mm.model.c.afk().set(40, Integer.valueOf(i));
      this.BAY = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.BBh != null)
    {
      if (paramBoolean)
      {
        this.BBh.setBackgroundResource(2131231759);
        ((TextView)findViewById(2131306936)).setText(2131766173);
        AppMethodBeat.o(30231);
        return;
      }
      this.BBh.setBackgroundResource(2131231758);
      ((TextView)findViewById(2131306936)).setText(2131766155);
    }
    AppMethodBeat.o(30231);
  }
  
  private void tK(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.BBi != null)
    {
      if (paramBoolean)
      {
        this.BBi.setBackgroundResource(2131231758);
        this.BBk.setIconColor(getResources().getColor(2131099732));
        AppMethodBeat.o(30232);
        return;
      }
      this.BBi.setBackgroundResource(2131231759);
      this.BBk.setIconColor(getResources().getColor(2131099673));
    }
    AppMethodBeat.o(30232);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.hrK))
    {
      ((TextView)findViewById(2131305199)).setText(com.tencent.mm.modelsimple.n.hrK);
      if (com.tencent.mm.modelsimple.n.aAC() == 1)
      {
        if (!this.BBg)
        {
          this.BBl.setImageResource(2131689983);
          this.BBl.setPadding(this.BBn - this.BBm, this.BBo, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (com.tencent.mm.modelsimple.n.aAC() == 2)
        {
          if (this.BBg) {
            ((TextView)findViewById(2131303536)).setText(2131766172);
          }
          while (this.nph)
          {
            ((TextView)findViewById(2131305199)).setText(getString(2131766156, new Object[] { "Mac" }));
            this.BBl.setImageResource(2131689977);
            this.BBl.setPadding(0, this.BBo, 0, 0);
            if ((!f.Yi()) || (this.BBg)) {
              break label588;
            }
            ((TextView)findViewById(2131303536)).setText(2131766152);
            this.BBl.setImageResource(2131689979);
            this.BBl.setPadding(this.BBn - this.BBm, this.BBo, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!f.Yi()) {
              ((TextView)findViewById(2131303536)).setText("");
            }
          }
          ((TextView)findViewById(2131305199)).setText(getString(2131766159, new Object[] { "Mac" }));
          this.BBl.setImageResource(2131689976);
          this.BBl.setPadding(0, this.BBo, 0, 0);
          if ((!f.Yi()) || (this.BBg)) {
            break label588;
          }
          ((TextView)findViewById(2131303536)).setText(2131766152);
          this.BBl.setImageResource(2131689978);
          this.BBl.setPadding(this.BBn - this.BBm, this.BBo, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aAC() == 3)
        {
          this.BBl.setImageResource(2131689975);
          this.BBl.setPadding(0, this.BBo, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aAC() == 6)
        {
          this.BBl.setImageResource(2131689964);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.BBl.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.cd.a.ao(this, 2131167018);
          localLayoutParams.height = com.tencent.mm.cd.a.ao(this, 2131167018);
          localLayoutParams.topMargin = this.BBo;
          this.BBl.setLayoutParams(localLayoutParams);
          this.BBl.setAlpha(0.3F);
          ((TextView)findViewById(2131303536)).setText("");
          if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.hrJ))
          {
            ((TextView)findViewById(2131299070)).setText(com.tencent.mm.modelsimple.n.hrJ);
            findViewById(2131299070).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
      }
      this.BBl.setImageResource(2131689981);
      this.BBl.setPadding(0, this.BBo, 0, 0);
    }
    label588:
    AppMethodBeat.o(30230);
  }
  
  public final void arM()
  {
    AppMethodBeat.i(30235);
    az.arV();
    if (!com.tencent.mm.model.c.aeG())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((com.tencent.mm.modelsimple.n.aAE()) && (!this.nph))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.nph = true;
      tJ(this.nph);
      updateStatus();
    }
    AppMethodBeat.o(30235);
  }
  
  public void finish()
  {
    AppMethodBeat.i(30224);
    super.finish();
    overridePendingTransition(2130771986, 2130772106);
    AppMethodBeat.o(30224);
  }
  
  public int getLayoutId()
  {
    return 2131496093;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30228);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(30213);
        WebWXLogoutUI.this.finish();
        AppMethodBeat.o(30213);
        return true;
      }
    }, 2131689488);
    if ((!bt.isNullOrNil(com.tencent.mm.modelsimple.n.hrS)) && (com.tencent.mm.modelsimple.n.aAC() == 6)) {
      addIconOptionMenu(10001, 2131690581, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30214);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", com.tencent.mm.modelsimple.n.hrS + "&lang=" + ac.eFu());
          paramAnonymousMenuItem.putExtra("showShare", false);
          paramAnonymousMenuItem.putExtra("neverGetA8Key", false);
          d.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(30214);
          return false;
        }
      });
    }
    hideActionbarLine();
    this.BBr = ((GridLayout)findViewById(2131306932));
    this.BBl = ((ImageView)findViewById(2131305201));
    Object localObject;
    label279:
    label338:
    Drawable localDrawable;
    label443:
    int i;
    int j;
    if (!f.Yi())
    {
      this.BBr.removeView(findViewById(2131298361));
      this.BBg = false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + com.tencent.mm.modelsimple.n.aAG());
      if (com.tencent.mm.modelsimple.n.aAG()) {
        break label628;
      }
      findViewById(2131301547).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, 2130837509);
      ((Animator)localObject).setTarget(findViewById(2131306937));
      this.BBp = AnimatorInflater.loadAnimator(this, 2130837510);
      this.BBp.setTarget(findViewById(2131306937));
      this.BBp.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.nph = com.tencent.mm.modelsimple.n.aAE();
      this.BBh = findViewById(2131306935);
      this.BBj = ((WeImageView)findViewById(2131300893));
      tJ(this.nph);
      this.BBh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30217);
          if (WebWXLogoutUI.c(WebWXLogoutUI.this))
          {
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231758);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099732));
          }
          for (;;)
          {
            WebWXLogoutUI.f(WebWXLogoutUI.this);
            WebWXLogoutUI.this.findViewById(2131306937).setVisibility(0);
            this.BBt.start();
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231759);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099673));
          }
        }
      });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + com.tencent.mm.modelsimple.n.aAH());
      if (com.tencent.mm.modelsimple.n.aAH()) {
        break label645;
      }
      findViewById(2131306931).setVisibility(0);
      findViewById(2131306930).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30218);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", "filehelper");
          paramAnonymousView.putExtra("key_show_bottom_app_panel", true);
          com.tencent.mm.plugin.webwx.a.hYt.d(paramAnonymousView, WebWXLogoutUI.this);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
          WebWXLogoutUI.this.finish();
          AppMethodBeat.o(30218);
        }
      });
      erZ();
      localObject = (Button)findViewById(2131306942);
      if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.hrQ)) {
        ((Button)localObject).setText(com.tencent.mm.modelsimple.n.hrQ);
      }
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30219);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "logout webwx");
          WebWXLogoutUI.g(WebWXLogoutUI.this);
          AppMethodBeat.o(30219);
        }
      });
      if (com.tencent.mm.modelsimple.n.aAC() != 1) {
        break label662;
      }
      localObject = getResources().getDrawable(2131689981);
      localDrawable = getResources().getDrawable(2131689983);
      if ((localObject != null) && (localDrawable != null))
      {
        this.BBm = ((Drawable)localObject).getIntrinsicWidth();
        this.BBn = localDrawable.getIntrinsicWidth();
      }
      i = ap.dL(getContext());
      j = ap.jA(getContext());
      localObject = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label724;
      }
      getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
    }
    for (;;)
    {
      int k = ((Point)localObject).y;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.BBo = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      this.BBi = findViewById(2131306929);
      this.BBk = ((WeImageView)findViewById(2131300897));
      if (u.mY(u.aqM())) {}
      for (this.BBg = true;; this.BBg = false)
      {
        tK(this.BBg);
        this.BBi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30215);
            paramAnonymousView = WebWXLogoutUI.this;
            if (!WebWXLogoutUI.a(WebWXLogoutUI.this)) {}
            for (boolean bool = true;; bool = false)
            {
              WebWXLogoutUI.a(paramAnonymousView, bool);
              WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.a(WebWXLogoutUI.this));
              WebWXLogoutUI.b(WebWXLogoutUI.this);
              AppMethodBeat.o(30215);
              return;
            }
          }
        });
        break;
      }
      label628:
      this.BBr.removeView(findViewById(2131301547));
      break label279;
      label645:
      this.BBr.removeView(findViewById(2131306931));
      break label338;
      label662:
      if (com.tencent.mm.modelsimple.n.aAC() != 2) {
        break label443;
      }
      localObject = getResources().getDrawable(2131689976);
      localDrawable = getResources().getDrawable(2131689978);
      if ((localObject == null) || (localDrawable == null)) {
        break label443;
      }
      this.BBm = ((Drawable)localObject).getIntrinsicWidth();
      this.BBn = localDrawable.getIntrinsicWidth();
      break label443;
      label724:
      getWindowManager().getDefaultDisplay().getSize((Point)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30225);
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.BBq = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2130772108, 2130771986);
    az.aeS().a(281, this);
    az.aeS().a(792, this);
    az.arV();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHU);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(2130771986, 2130772106);
    az.aeS().b(281, this);
    az.aeS().b(792, this);
    az.arV();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.wHU);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
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
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(30234);
    if (this.wfA != null)
    {
      this.wfA.dismiss();
      this.wfA = null;
    }
    if (paramn.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, 2131766170, 1).show();
      }
      finish();
      AppMethodBeat.o(30234);
      return;
    }
    boolean bool;
    if (paramn.getType() == 792)
    {
      int i = ((b)paramn).diR;
      if (this.BBp != null) {
        this.BBp.start();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (i == 1)
        {
          Toast.makeText(this, 2131766157, 0).show();
          AppMethodBeat.o(30234);
          return;
        }
        Toast.makeText(this, 2131766174, 0).show();
        AppMethodBeat.o(30234);
        return;
      }
      if (i != 1) {
        break label211;
      }
      bool = true;
      this.nph = bool;
      com.tencent.mm.modelsimple.n.ev(this.nph);
      updateStatus();
      if (!this.nph) {
        break label217;
      }
    }
    label211:
    label217:
    for (paramString = "lock";; paramString = "unlock")
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
      AppMethodBeat.o(30234);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */