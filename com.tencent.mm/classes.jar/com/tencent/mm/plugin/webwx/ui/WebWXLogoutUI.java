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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements com.tencent.mm.al.f, aw
{
  private int BFx;
  private boolean Exg;
  private boolean Exo;
  private View Exp;
  private View Exq;
  private WeImageView Exr;
  private WeImageView Exs;
  private int Ext;
  private int Exu;
  private Animator Exv;
  private int Exw;
  private GridLayout Exx;
  private boolean ovC;
  private ProgressDialog yFx;
  private ImageView zQn;
  private com.tencent.mm.sdk.b.c zkk;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.yFx = null;
    this.Exg = false;
    this.zkk = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(30223);
  }
  
  private void eWm()
  {
    AppMethodBeat.i(30229);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.Exx.getChildCount()) });
    if (this.Exx.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.Exx.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.Exx.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.Exx.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.Exx.getChildCount() - 1)
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
  
  private boolean eWn()
  {
    AppMethodBeat.i(30233);
    if (!ba.ajx())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = u.aAs();
    if (this.Exo) {
      i |= 0x2000;
    }
    for (;;)
    {
      com.tencent.mm.n.f.lD(i);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(40, Integer.valueOf(i));
      this.Exg = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.ilD))
    {
      ((TextView)findViewById(2131305199)).setText(com.tencent.mm.modelsimple.n.ilD);
      if (com.tencent.mm.modelsimple.n.aKD() == 1)
      {
        if (!this.Exo)
        {
          this.zQn.setImageResource(2131689983);
          this.zQn.setPadding(this.Ext - this.BFx, this.Exu, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (com.tencent.mm.modelsimple.n.aKD() == 2)
        {
          if (this.Exo) {
            ((TextView)findViewById(2131303536)).setText(2131766172);
          }
          while (this.ovC)
          {
            ((TextView)findViewById(2131305199)).setText(getString(2131766156, new Object[] { "Mac" }));
            this.zQn.setImageResource(2131689977);
            this.zQn.setPadding(0, this.Exu, 0, 0);
            if ((!com.tencent.mm.n.f.abF()) || (this.Exo)) {
              break label588;
            }
            ((TextView)findViewById(2131303536)).setText(2131766152);
            this.zQn.setImageResource(2131689979);
            this.zQn.setPadding(this.Ext - this.BFx, this.Exu, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!com.tencent.mm.n.f.abF()) {
              ((TextView)findViewById(2131303536)).setText("");
            }
          }
          ((TextView)findViewById(2131305199)).setText(getString(2131766159, new Object[] { "Mac" }));
          this.zQn.setImageResource(2131689976);
          this.zQn.setPadding(0, this.Exu, 0, 0);
          if ((!com.tencent.mm.n.f.abF()) || (this.Exo)) {
            break label588;
          }
          ((TextView)findViewById(2131303536)).setText(2131766152);
          this.zQn.setImageResource(2131689978);
          this.zQn.setPadding(this.Ext - this.BFx, this.Exu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aKD() == 3)
        {
          this.zQn.setImageResource(2131689975);
          this.zQn.setPadding(0, this.Exu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (com.tencent.mm.modelsimple.n.aKD() == 6)
        {
          this.zQn.setImageResource(2131689964);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.zQn.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.cc.a.ax(this, 2131167018);
          localLayoutParams.height = com.tencent.mm.cc.a.ax(this, 2131167018);
          localLayoutParams.topMargin = this.Exu;
          this.zQn.setLayoutParams(localLayoutParams);
          this.zQn.setAlpha(0.3F);
          ((TextView)findViewById(2131303536)).setText("");
          if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.ilC))
          {
            ((TextView)findViewById(2131299070)).setText(com.tencent.mm.modelsimple.n.ilC);
            findViewById(2131299070).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
      }
      this.zQn.setImageResource(2131689981);
      this.zQn.setPadding(0, this.Exu, 0, 0);
    }
    label588:
    AppMethodBeat.o(30230);
  }
  
  private void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.Exp != null)
    {
      if (paramBoolean)
      {
        this.Exp.setBackgroundResource(2131231759);
        ((TextView)findViewById(2131306936)).setText(2131766173);
        AppMethodBeat.o(30231);
        return;
      }
      this.Exp.setBackgroundResource(2131231758);
      ((TextView)findViewById(2131306936)).setText(2131766155);
    }
    AppMethodBeat.o(30231);
  }
  
  private void vx(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.Exq != null)
    {
      if (paramBoolean)
      {
        this.Exq.setBackgroundResource(2131231758);
        this.Exs.setIconColor(getResources().getColor(2131099732));
        AppMethodBeat.o(30232);
        return;
      }
      this.Exq.setBackgroundResource(2131231759);
      this.Exs.setIconColor(getResources().getColor(2131099673));
    }
    AppMethodBeat.o(30232);
  }
  
  public final void aBH()
  {
    AppMethodBeat.i(30235);
    ba.aBQ();
    if (!com.tencent.mm.model.c.aiI())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((com.tencent.mm.modelsimple.n.aKF()) && (!this.ovC))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.ovC = true;
      vw(this.ovC);
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
    if ((!bt.isNullOrNil(com.tencent.mm.modelsimple.n.ilL)) && (com.tencent.mm.modelsimple.n.aKD() == 6)) {
      addIconOptionMenu(10001, 2131690581, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30214);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", com.tencent.mm.modelsimple.n.ilL + "&lang=" + ac.fks());
          paramAnonymousMenuItem.putExtra("showShare", false);
          paramAnonymousMenuItem.putExtra("neverGetA8Key", false);
          d.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(30214);
          return false;
        }
      });
    }
    hideActionbarLine();
    this.Exx = ((GridLayout)findViewById(2131306932));
    this.zQn = ((ImageView)findViewById(2131305201));
    Object localObject;
    label279:
    label338:
    Drawable localDrawable;
    label443:
    int i;
    int j;
    if (!com.tencent.mm.n.f.abF())
    {
      this.Exx.removeView(findViewById(2131298361));
      this.Exo = false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + com.tencent.mm.modelsimple.n.aKH());
      if (com.tencent.mm.modelsimple.n.aKH()) {
        break label625;
      }
      findViewById(2131301547).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, 2130837509);
      ((Animator)localObject).setTarget(findViewById(2131306937));
      this.Exv = AnimatorInflater.loadAnimator(this, 2130837510);
      this.Exv.setTarget(findViewById(2131306937));
      this.Exv.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.ovC = com.tencent.mm.modelsimple.n.aKF();
      this.Exp = findViewById(2131306935);
      this.Exr = ((WeImageView)findViewById(2131300893));
      vw(this.ovC);
      this.Exp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30217);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (WebWXLogoutUI.c(WebWXLogoutUI.this))
          {
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231758);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099732));
          }
          for (;;)
          {
            WebWXLogoutUI.f(WebWXLogoutUI.this);
            WebWXLogoutUI.this.findViewById(2131306937).setVisibility(0);
            this.Exz.start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231759);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099673));
          }
        }
      });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + com.tencent.mm.modelsimple.n.aKI());
      if (com.tencent.mm.modelsimple.n.aKI()) {
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", "filehelper");
          paramAnonymousView.putExtra("key_show_bottom_app_panel", true);
          com.tencent.mm.plugin.webwx.a.iRG.d(paramAnonymousView, WebWXLogoutUI.this);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
          WebWXLogoutUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30218);
        }
      });
      eWm();
      localObject = (Button)findViewById(2131306942);
      if (!bt.isNullOrNil(com.tencent.mm.modelsimple.n.ilJ)) {
        ((Button)localObject).setText(com.tencent.mm.modelsimple.n.ilJ);
      }
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30219);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "logout webwx");
          WebWXLogoutUI.g(WebWXLogoutUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30219);
        }
      });
      if (com.tencent.mm.modelsimple.n.aKD() != 1) {
        break label659;
      }
      localObject = getResources().getDrawable(2131689981);
      localDrawable = getResources().getDrawable(2131689983);
      if ((localObject != null) && (localDrawable != null))
      {
        this.BFx = ((Drawable)localObject).getIntrinsicWidth();
        this.Ext = localDrawable.getIntrinsicWidth();
      }
      i = ar.dT(getContext());
      j = ar.jW(getContext());
      localObject = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label721;
      }
      getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
    }
    for (;;)
    {
      int k = ((Point)localObject).y;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.Exu = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      this.Exq = findViewById(2131306929);
      this.Exs = ((WeImageView)findViewById(2131300897));
      if (u.acv()) {}
      for (this.Exo = true;; this.Exo = false)
      {
        vx(this.Exo);
        this.Exq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30215);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      this.Exx.removeView(findViewById(2131301547));
      break label279;
      label642:
      this.Exx.removeView(findViewById(2131306931));
      break label338;
      label659:
      if (com.tencent.mm.modelsimple.n.aKD() != 2) {
        break label443;
      }
      localObject = getResources().getDrawable(2131689976);
      localDrawable = getResources().getDrawable(2131689978);
      if ((localObject == null) || (localDrawable == null)) {
        break label443;
      }
      this.BFx = ((Drawable)localObject).getIntrinsicWidth();
      this.Ext = localDrawable.getIntrinsicWidth();
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
      this.Exw = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2130772108, 2130771986);
    ba.aiU().a(281, this);
    ba.aiU().a(792, this);
    ba.aBQ();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkk);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(2130771986, 2130772106);
    ba.aiU().b(281, this);
    ba.aiU().b(792, this);
    ba.aBQ();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.zkk);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
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
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(30234);
    if (this.yFx != null)
    {
      this.yFx.dismiss();
      this.yFx = null;
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
      int i = ((com.tencent.mm.plugin.webwx.a.b)paramn).drI;
      if (this.Exv != null) {
        this.Exv.start();
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
      this.ovC = bool;
      com.tencent.mm.modelsimple.n.eR(this.ovC);
      updateStatus();
      if (!this.ovC) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */