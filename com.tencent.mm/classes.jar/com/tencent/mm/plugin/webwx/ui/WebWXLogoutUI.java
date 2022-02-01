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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements com.tencent.mm.ak.f, ay
{
  private ImageView Ahu;
  private int BWV;
  private boolean EPC;
  private boolean EPK;
  private View EPL;
  private View EPM;
  private WeImageView EPN;
  private WeImageView EPO;
  private int EPP;
  private int EPQ;
  private Animator EPR;
  private int EPS;
  private GridLayout EPT;
  private boolean oCd;
  private ProgressDialog yVG;
  private com.tencent.mm.sdk.b.c zBz;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.yVG = null;
    this.EPC = false;
    this.zBz = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(30223);
  }
  
  private void eZY()
  {
    AppMethodBeat.i(30229);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.EPT.getChildCount()) });
    if (this.EPT.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.EPT.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.EPT.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.EPT.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.EPT.getChildCount() - 1)
          {
            localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
          }
          else
          {
            localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
            localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
          }
        }
      }
    }
    AppMethodBeat.o(30229);
  }
  
  private boolean eZZ()
  {
    AppMethodBeat.i(30233);
    if (!bc.ajM())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = v.aAI();
    if (this.EPK) {
      i |= 0x2000;
    }
    for (;;)
    {
      com.tencent.mm.n.f.lF(i);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(40, Integer.valueOf(i));
      this.EPC = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!bu.isNullOrNil(o.iow))
    {
      ((TextView)findViewById(2131305199)).setText(o.iow);
      if (o.aLa() == 1)
      {
        if (!this.EPK)
        {
          this.Ahu.setImageResource(2131689983);
          this.Ahu.setPadding(this.EPP - this.BWV, this.EPQ, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (o.aLa() == 2)
        {
          if (this.EPK) {
            ((TextView)findViewById(2131303536)).setText(2131766172);
          }
          while (this.oCd)
          {
            ((TextView)findViewById(2131305199)).setText(getString(2131766156, new Object[] { "Mac" }));
            this.Ahu.setImageResource(2131689977);
            this.Ahu.setPadding(0, this.EPQ, 0, 0);
            if ((!com.tencent.mm.n.f.abO()) || (this.EPK)) {
              break label588;
            }
            ((TextView)findViewById(2131303536)).setText(2131766152);
            this.Ahu.setImageResource(2131689979);
            this.Ahu.setPadding(this.EPP - this.BWV, this.EPQ, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!com.tencent.mm.n.f.abO()) {
              ((TextView)findViewById(2131303536)).setText("");
            }
          }
          ((TextView)findViewById(2131305199)).setText(getString(2131766159, new Object[] { "Mac" }));
          this.Ahu.setImageResource(2131689976);
          this.Ahu.setPadding(0, this.EPQ, 0, 0);
          if ((!com.tencent.mm.n.f.abO()) || (this.EPK)) {
            break label588;
          }
          ((TextView)findViewById(2131303536)).setText(2131766152);
          this.Ahu.setImageResource(2131689978);
          this.Ahu.setPadding(this.EPP - this.BWV, this.EPQ, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.aLa() == 3)
        {
          this.Ahu.setImageResource(2131689975);
          this.Ahu.setPadding(0, this.EPQ, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.aLa() == 6)
        {
          this.Ahu.setImageResource(2131689964);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Ahu.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.cb.a.ax(this, 2131167018);
          localLayoutParams.height = com.tencent.mm.cb.a.ax(this, 2131167018);
          localLayoutParams.topMargin = this.EPQ;
          this.Ahu.setLayoutParams(localLayoutParams);
          this.Ahu.setAlpha(0.3F);
          ((TextView)findViewById(2131303536)).setText("");
          if (!bu.isNullOrNil(o.iov))
          {
            ((TextView)findViewById(2131299070)).setText(o.iov);
            findViewById(2131299070).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
      }
      this.Ahu.setImageResource(2131689981);
      this.Ahu.setPadding(0, this.EPQ, 0, 0);
    }
    label588:
    AppMethodBeat.o(30230);
  }
  
  private void vF(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.EPL != null)
    {
      if (paramBoolean)
      {
        this.EPL.setBackgroundResource(2131231759);
        ((TextView)findViewById(2131306936)).setText(2131766173);
        AppMethodBeat.o(30231);
        return;
      }
      this.EPL.setBackgroundResource(2131231758);
      ((TextView)findViewById(2131306936)).setText(2131766155);
    }
    AppMethodBeat.o(30231);
  }
  
  private void vG(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.EPM != null)
    {
      if (paramBoolean)
      {
        this.EPM.setBackgroundResource(2131231758);
        this.EPO.setIconColor(getResources().getColor(2131099732));
        AppMethodBeat.o(30232);
        return;
      }
      this.EPM.setBackgroundResource(2131231759);
      this.EPO.setIconColor(getResources().getColor(2131099673));
    }
    AppMethodBeat.o(30232);
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(30235);
    bc.aCg();
    if (!com.tencent.mm.model.c.aiX())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((o.aLc()) && (!this.oCd))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.oCd = true;
      vF(this.oCd);
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
    if ((!bu.isNullOrNil(o.ioE)) && (o.aLa() == 6)) {
      addIconOptionMenu(10001, 2131690581, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30214);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", o.ioE + "&lang=" + ad.fom());
          paramAnonymousMenuItem.putExtra("showShare", false);
          paramAnonymousMenuItem.putExtra("neverGetA8Key", false);
          d.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(30214);
          return false;
        }
      });
    }
    hideActionbarLine();
    this.EPT = ((GridLayout)findViewById(2131306932));
    this.Ahu = ((ImageView)findViewById(2131305201));
    Object localObject;
    label279:
    label338:
    Drawable localDrawable;
    label443:
    int i;
    int j;
    if (!com.tencent.mm.n.f.abO())
    {
      this.EPT.removeView(findViewById(2131298361));
      this.EPK = false;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + o.aLe());
      if (o.aLe()) {
        break label625;
      }
      findViewById(2131301547).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, 2130837509);
      ((Animator)localObject).setTarget(findViewById(2131306937));
      this.EPR = AnimatorInflater.loadAnimator(this, 2130837510);
      this.EPR.setTarget(findViewById(2131306937));
      this.EPR.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.oCd = o.aLc();
      this.EPL = findViewById(2131306935);
      this.EPN = ((WeImageView)findViewById(2131300893));
      vF(this.oCd);
      this.EPL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30217);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (WebWXLogoutUI.c(WebWXLogoutUI.this))
          {
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231758);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099732));
          }
          for (;;)
          {
            WebWXLogoutUI.f(WebWXLogoutUI.this);
            WebWXLogoutUI.this.findViewById(2131306937).setVisibility(0);
            this.EPV.start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231759);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099673));
          }
        }
      });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + o.aLf());
      if (o.aLf()) {
        break label642;
      }
      findViewById(2131306931).setVisibility(0);
      findViewById(2131306930).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30218);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", "filehelper");
          paramAnonymousView.putExtra("key_show_bottom_app_panel", true);
          com.tencent.mm.plugin.webwx.a.iUz.d(paramAnonymousView, WebWXLogoutUI.this);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
          WebWXLogoutUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30218);
        }
      });
      eZY();
      localObject = (Button)findViewById(2131306942);
      if (!bu.isNullOrNil(o.ioC)) {
        ((Button)localObject).setText(o.ioC);
      }
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30219);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebWXLogoutUI", "logout webwx");
          WebWXLogoutUI.g(WebWXLogoutUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30219);
        }
      });
      if (o.aLa() != 1) {
        break label659;
      }
      localObject = getResources().getDrawable(2131689981);
      localDrawable = getResources().getDrawable(2131689983);
      if ((localObject != null) && (localDrawable != null))
      {
        this.BWV = ((Drawable)localObject).getIntrinsicWidth();
        this.EPP = localDrawable.getIntrinsicWidth();
      }
      i = ar.dX(getContext());
      j = ar.kd(getContext());
      localObject = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label721;
      }
      getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
    }
    for (;;)
    {
      int k = ((Point)localObject).y;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.EPQ = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      this.EPM = findViewById(2131306929);
      this.EPO = ((WeImageView)findViewById(2131300897));
      if (v.acG()) {}
      for (this.EPK = true;; this.EPK = false)
      {
        vG(this.EPK);
        this.EPM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30215);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = WebWXLogoutUI.this;
            if (!WebWXLogoutUI.a(WebWXLogoutUI.this)) {}
            for (boolean bool = true;; bool = false)
            {
              WebWXLogoutUI.a(paramAnonymousView, bool);
              WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.a(WebWXLogoutUI.this));
              WebWXLogoutUI.b(WebWXLogoutUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(30215);
              return;
            }
          }
        });
        break;
      }
      label625:
      this.EPT.removeView(findViewById(2131301547));
      break label279;
      label642:
      this.EPT.removeView(findViewById(2131306931));
      break label338;
      label659:
      if (o.aLa() != 2) {
        break label443;
      }
      localObject = getResources().getDrawable(2131689976);
      localDrawable = getResources().getDrawable(2131689978);
      if ((localObject == null) || (localDrawable == null)) {
        break label443;
      }
      this.BWV = ((Drawable)localObject).getIntrinsicWidth();
      this.EPP = localDrawable.getIntrinsicWidth();
      break label443;
      label721:
      getWindowManager().getDefaultDisplay().getSize((Point)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30225);
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.EPS = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2130772108, 2130771986);
    bc.ajj().a(281, this);
    bc.ajj().a(792, this);
    bc.aCg();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBz);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(2130771986, 2130772106);
    bc.ajj().b(281, this);
    bc.ajj().b(792, this);
    bc.aCg();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.zBz);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
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
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30234);
    if (this.yVG != null)
    {
      this.yVG.dismiss();
      this.yVG = null;
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
      int i = ((com.tencent.mm.plugin.webwx.a.b)paramn).dsO;
      if (this.EPR != null) {
        this.EPR.start();
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
      this.oCd = bool;
      o.eU(this.oCd);
      updateStatus();
      if (!this.oCd) {
        break label217;
      }
    }
    label211:
    label217:
    for (paramString = "lock";; paramString = "unlock")
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
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