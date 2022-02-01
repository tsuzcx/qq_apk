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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.m.f;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements g, av
{
  private int Ank;
  private boolean CTf;
  private boolean CTn;
  private View CTo;
  private View CTp;
  private WeImageView CTq;
  private WeImageView CTr;
  private ImageView CTs;
  private int CTt;
  private int CTu;
  private Animator CTv;
  private int CTw;
  private GridLayout CTx;
  private boolean nSh;
  private com.tencent.mm.sdk.b.c xUp;
  private ProgressDialog xqQ;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.xqQ = null;
    this.CTf = false;
    this.xUp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(30223);
  }
  
  private void eHt()
  {
    AppMethodBeat.i(30229);
    ac.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.CTx.getChildCount()) });
    if (this.CTx.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.CTx.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.CTx.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.CTx.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.CTx.getChildCount() - 1)
          {
            localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
          }
          else
          {
            localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
            localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
          }
        }
      }
    }
    AppMethodBeat.o(30229);
  }
  
  private boolean eHu()
  {
    AppMethodBeat.i(30233);
    if (!az.agM())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = u.axC();
    if (this.CTn) {
      i |= 0x2000;
    }
    for (;;)
    {
      f.le(i);
      az.ayM();
      com.tencent.mm.model.c.agA().set(40, Integer.valueOf(i));
      this.CTf = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.CTo != null)
    {
      if (paramBoolean)
      {
        this.CTo.setBackgroundResource(2131231759);
        ((TextView)findViewById(2131306936)).setText(2131766173);
        AppMethodBeat.o(30231);
        return;
      }
      this.CTo.setBackgroundResource(2131231758);
      ((TextView)findViewById(2131306936)).setText(2131766155);
    }
    AppMethodBeat.o(30231);
  }
  
  private void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.CTp != null)
    {
      if (paramBoolean)
      {
        this.CTp.setBackgroundResource(2131231758);
        this.CTr.setIconColor(getResources().getColor(2131099732));
        AppMethodBeat.o(30232);
        return;
      }
      this.CTp.setBackgroundResource(2131231759);
      this.CTr.setIconColor(getResources().getColor(2131099673));
    }
    AppMethodBeat.o(30232);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!bs.isNullOrNil(com.tencent.mm.modelsimple.n.hSm))
    {
      ((TextView)findViewById(2131305199)).setText(com.tencent.mm.modelsimple.n.hSm);
      if (com.tencent.mm.modelsimple.n.aHs() == 1)
      {
        if (!this.CTn)
        {
          this.CTs.setImageResource(2131689983);
          this.CTs.setPadding(this.CTt - this.Ank, this.CTu, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (com.tencent.mm.modelsimple.n.aHs() == 2)
        {
          if (this.CTn) {
            ((TextView)findViewById(2131303536)).setText(2131766172);
          }
          while (this.nSh)
          {
            ((TextView)findViewById(2131305199)).setText(getString(2131766156, new Object[] { "Mac" }));
            this.CTs.setImageResource(2131689977);
            this.CTs.setPadding(0, this.CTu, 0, 0);
            if ((!f.Zf()) || (this.CTn)) {
              break label588;
            }
            ((TextView)findViewById(2131303536)).setText(2131766152);
            this.CTs.setImageResource(2131689979);
            this.CTs.setPadding(this.CTt - this.Ank, this.CTu, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!f.Zf()) {
              ((TextView)findViewById(2131303536)).setText("");
            }
          }
          ((TextView)findViewById(2131305199)).setText(getString(2131766159, new Object[] { "Mac" }));
          this.CTs.setImageResource(2131689976);
          this.CTs.setPadding(0, this.CTu, 0, 0);
          if ((!f.Zf()) || (this.CTn)) {
            break label588;
          }
          ((TextView)findViewById(2131303536)).setText(2131766152);
          this.CTs.setImageResource(2131689978);
          this.CTs.setPadding(this.CTt - this.Ank, this.CTu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aHs() == 3)
        {
          this.CTs.setImageResource(2131689975);
          this.CTs.setPadding(0, this.CTu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aHs() == 6)
        {
          this.CTs.setImageResource(2131689964);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.CTs.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.cc.a.au(this, 2131167018);
          localLayoutParams.height = com.tencent.mm.cc.a.au(this, 2131167018);
          localLayoutParams.topMargin = this.CTu;
          this.CTs.setLayoutParams(localLayoutParams);
          this.CTs.setAlpha(0.3F);
          ((TextView)findViewById(2131303536)).setText("");
          if (!bs.isNullOrNil(com.tencent.mm.modelsimple.n.hSl))
          {
            ((TextView)findViewById(2131299070)).setText(com.tencent.mm.modelsimple.n.hSl);
            findViewById(2131299070).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
      }
      this.CTs.setImageResource(2131689981);
      this.CTs.setPadding(0, this.CTu, 0, 0);
    }
    label588:
    AppMethodBeat.o(30230);
  }
  
  public final void ayD()
  {
    AppMethodBeat.i(30235);
    az.ayM();
    if (!com.tencent.mm.model.c.afW())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((com.tencent.mm.modelsimple.n.aHu()) && (!this.nSh))
    {
      ac.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.nSh = true;
      uL(this.nSh);
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
    if ((!bs.isNullOrNil(com.tencent.mm.modelsimple.n.hSu)) && (com.tencent.mm.modelsimple.n.aHs() == 6)) {
      addIconOptionMenu(10001, 2131690581, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30214);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", com.tencent.mm.modelsimple.n.hSu + "&lang=" + ab.eUO());
          paramAnonymousMenuItem.putExtra("showShare", false);
          paramAnonymousMenuItem.putExtra("neverGetA8Key", false);
          d.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(30214);
          return false;
        }
      });
    }
    hideActionbarLine();
    this.CTx = ((GridLayout)findViewById(2131306932));
    this.CTs = ((ImageView)findViewById(2131305201));
    Object localObject;
    label279:
    label338:
    Drawable localDrawable;
    label443:
    int i;
    int j;
    if (!f.Zf())
    {
      this.CTx.removeView(findViewById(2131298361));
      this.CTn = false;
      ac.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + com.tencent.mm.modelsimple.n.aHw());
      if (com.tencent.mm.modelsimple.n.aHw()) {
        break label628;
      }
      findViewById(2131301547).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, 2130837509);
      ((Animator)localObject).setTarget(findViewById(2131306937));
      this.CTv = AnimatorInflater.loadAnimator(this, 2130837510);
      this.CTv.setTarget(findViewById(2131306937));
      this.CTv.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.nSh = com.tencent.mm.modelsimple.n.aHu();
      this.CTo = findViewById(2131306935);
      this.CTq = ((WeImageView)findViewById(2131300893));
      uL(this.nSh);
      this.CTo.setOnClickListener(new View.OnClickListener()
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
            this.CTz.start();
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231759);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099673));
          }
        }
      });
      ac.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + com.tencent.mm.modelsimple.n.aHx());
      if (com.tencent.mm.modelsimple.n.aHx()) {
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
          com.tencent.mm.plugin.webwx.a.iyx.d(paramAnonymousView, WebWXLogoutUI.this);
          ac.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
          WebWXLogoutUI.this.finish();
          AppMethodBeat.o(30218);
        }
      });
      eHt();
      localObject = (Button)findViewById(2131306942);
      if (!bs.isNullOrNil(com.tencent.mm.modelsimple.n.hSs)) {
        ((Button)localObject).setText(com.tencent.mm.modelsimple.n.hSs);
      }
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30219);
          ac.d("MicroMsg.WebWXLogoutUI", "logout webwx");
          WebWXLogoutUI.g(WebWXLogoutUI.this);
          AppMethodBeat.o(30219);
        }
      });
      if (com.tencent.mm.modelsimple.n.aHs() != 1) {
        break label662;
      }
      localObject = getResources().getDrawable(2131689981);
      localDrawable = getResources().getDrawable(2131689983);
      if ((localObject != null) && (localDrawable != null))
      {
        this.Ank = ((Drawable)localObject).getIntrinsicWidth();
        this.CTt = localDrawable.getIntrinsicWidth();
      }
      i = ap.dT(getContext());
      j = ap.jL(getContext());
      localObject = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label724;
      }
      getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
    }
    for (;;)
    {
      int k = ((Point)localObject).y;
      ac.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.CTu = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      this.CTp = findViewById(2131306929);
      this.CTr = ((WeImageView)findViewById(2131300897));
      if (u.nM(u.axC())) {}
      for (this.CTn = true;; this.CTn = false)
      {
        uM(this.CTn);
        this.CTp.setOnClickListener(new View.OnClickListener()
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
      this.CTx.removeView(findViewById(2131301547));
      break label279;
      label645:
      this.CTx.removeView(findViewById(2131306931));
      break label338;
      label662:
      if (com.tencent.mm.modelsimple.n.aHs() != 2) {
        break label443;
      }
      localObject = getResources().getDrawable(2131689976);
      localDrawable = getResources().getDrawable(2131689978);
      if ((localObject == null) || (localDrawable == null)) {
        break label443;
      }
      this.Ank = ((Drawable)localObject).getIntrinsicWidth();
      this.CTt = localDrawable.getIntrinsicWidth();
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
      this.CTw = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2130772108, 2130771986);
    az.agi().a(281, this);
    az.agi().a(792, this);
    az.ayM();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUp);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(2130771986, 2130772106);
    az.agi().b(281, this);
    az.agi().b(792, this);
    az.ayM();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.xUp);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
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
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(30234);
    if (this.xqQ != null)
    {
      this.xqQ.dismiss();
      this.xqQ = null;
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
      int i = ((b)paramn).dgm;
      if (this.CTv != null) {
        this.CTv.start();
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
      this.nSh = bool;
      com.tencent.mm.modelsimple.n.eP(this.nSh);
      updateStatus();
      if (!this.nSh) {
        break label217;
      }
    }
    label211:
    label217:
    for (paramString = "lock";; paramString = "unlock")
    {
      ac.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */