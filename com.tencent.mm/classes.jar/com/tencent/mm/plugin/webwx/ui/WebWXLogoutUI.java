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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.b;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.yf;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements i, bd
{
  private int Cxu;
  private IListener JYs;
  private ProgressDialog JfW;
  private ImageView KDh;
  private int Nme;
  private boolean QEe;
  private boolean QEo;
  private View QEp;
  private View QEq;
  private WeImageView QEr;
  private WeImageView QEs;
  private int QEt;
  private Animator QEu;
  private int QEv;
  private GridLayout QEw;
  private boolean sWP;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.JfW = null;
    this.QEe = false;
    this.JYs = new IListener() {};
    AppMethodBeat.o(30223);
  }
  
  private void DA(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.QEp != null)
    {
      if (paramBoolean)
      {
        this.QEp.setBackgroundResource(R.g.circle_btn_brand_bg);
        ((TextView)findViewById(R.h.eaE)).setText(R.l.eVO);
        AppMethodBeat.o(30231);
        return;
      }
      this.QEp.setBackgroundResource(R.g.circle_btn_bg);
      ((TextView)findViewById(R.h.eaE)).setText(R.l.eaD);
    }
    AppMethodBeat.o(30231);
  }
  
  private void DB(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.QEq != null)
    {
      if (paramBoolean)
      {
        this.QEq.setBackgroundResource(R.g.circle_btn_bg);
        this.QEs.setIconColor(getResources().getColor(R.e.FG_0));
        AppMethodBeat.o(30232);
        return;
      }
      this.QEq.setBackgroundResource(R.g.circle_btn_brand_bg);
      this.QEs.setIconColor(getResources().getColor(R.e.BW_100_Alpha_0_8));
    }
    AppMethodBeat.o(30232);
  }
  
  private void hcQ()
  {
    AppMethodBeat.i(30229);
    Log.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.QEw.getChildCount()) });
    if (this.QEw.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.QEw.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.QEw.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.QEw.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.QEw.getChildCount() - 1)
          {
            localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this, 30);
          }
          else
          {
            localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this, 30);
            localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(this, 30);
          }
        }
      }
    }
    AppMethodBeat.o(30229);
  }
  
  private boolean hcR()
  {
    AppMethodBeat.i(30233);
    if (!bh.aHB())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = z.bdf();
    if (this.QEo) {
      i |= 0x2000;
    }
    for (;;)
    {
      g.rb(i);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(40, Integer.valueOf(i));
      this.QEe = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!Util.isNullOrNil(o.lZz))
    {
      ((TextView)findViewById(R.h.status_desc)).setText(o.lZz);
      if (o.bor() == 1)
      {
        if (!this.QEo)
        {
          this.KDh.setImageResource(R.k.connect_pc_mute);
          this.KDh.setPadding(this.QEt - this.Nme, this.Cxu, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (o.bor() == 2)
        {
          if (this.QEo) {
            ((TextView)findViewById(R.h.dRE)).setText(R.l.eVN);
          }
          while (this.sWP)
          {
            ((TextView)findViewById(R.h.status_desc)).setText(getString(R.l.eVG, new Object[] { "Mac" }));
            this.KDh.setImageResource(R.k.connect_mac_lock);
            this.KDh.setPadding(0, this.Cxu, 0, 0);
            if ((!g.awg()) || (this.QEo)) {
              break label724;
            }
            ((TextView)findViewById(R.h.dRE)).setText(R.l.eVF);
            this.KDh.setImageResource(R.k.connect_mac_mute_lock);
            this.KDh.setPadding(this.QEt - this.Nme, this.Cxu, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!g.awg()) {
              ((TextView)findViewById(R.h.dRE)).setText("");
            }
          }
          ((TextView)findViewById(R.h.status_desc)).setText(getString(R.l.eVI, new Object[] { "Mac" }));
          this.KDh.setImageResource(R.k.connect_mac);
          this.KDh.setPadding(0, this.Cxu, 0, 0);
          if ((!g.awg()) || (this.QEo)) {
            break label724;
          }
          ((TextView)findViewById(R.h.dRE)).setText(R.l.eVF);
          this.KDh.setImageResource(R.k.connect_mac_mute);
          this.KDh.setPadding(this.QEt - this.Nme, this.Cxu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bor() == 3)
        {
          this.KDh.setImageResource(R.k.connect_ipad);
          this.KDh.setPadding(0, this.Cxu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bor() == 7)
        {
          this.KDh.setImageResource(R.k.connect_kidwatch_big);
          this.KDh.setPadding(0, this.Cxu, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bor() == 6)
        {
          this.KDh.setImageResource(R.k.connect_car);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KDh.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.ci.a.aY(this, R.f.dlW);
          localLayoutParams.height = com.tencent.mm.ci.a.aY(this, R.f.dlW);
          localLayoutParams.topMargin = this.Cxu;
          this.KDh.setLayoutParams(localLayoutParams);
          this.KDh.setAlpha(0.3F);
          ((TextView)findViewById(R.h.dRE)).setText("");
          if (!Util.isNullOrNil(o.lZy))
          {
            ((TextView)findViewById(R.h.dEk)).setText(o.lZy);
            findViewById(R.h.dEk).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bor() == 8)
        {
          if (this.QEo)
          {
            this.KDh.setImageResource(R.k.connect_android_pad);
            this.KDh.setPadding(0, this.Cxu, 0, 0);
          }
          for (;;)
          {
            ((TextView)findViewById(R.h.dRE)).setText("");
            AppMethodBeat.o(30230);
            return;
            this.KDh.setImageResource(R.k.connect_android_pad_mute);
            this.KDh.setPadding(this.QEt - this.Nme, this.Cxu, 0, 0);
          }
        }
      }
      this.KDh.setImageResource(R.k.connect_pc);
      this.KDh.setPadding(0, this.Cxu, 0, 0);
    }
    label724:
    AppMethodBeat.o(30230);
  }
  
  public final void bez()
  {
    AppMethodBeat.i(30235);
    bh.beI();
    if (!com.tencent.mm.model.c.aGK())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((o.bot()) && (!this.sWP))
    {
      Log.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.sWP = true;
      DA(this.sWP);
      updateStatus();
    }
    AppMethodBeat.o(30235);
  }
  
  public void finish()
  {
    AppMethodBeat.i(30224);
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(30224);
  }
  
  public int getLayoutId()
  {
    return R.i.eme;
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
    }, R.k.actionbar_icon_close_black);
    if ((!Util.isNullOrNil(o.lZH)) && (o.bor() == 6)) {
      addIconOptionMenu(10001, R.k.icons_outlined_help, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30214);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", o.lZH + "&lang=" + LocaleUtil.getApplicationLanguage());
          paramAnonymousMenuItem.putExtra("showShare", false);
          paramAnonymousMenuItem.putExtra("neverGetA8Key", false);
          com.tencent.mm.by.c.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(30214);
          return false;
        }
      });
    }
    hideActionbarLine();
    this.QEw = ((GridLayout)findViewById(R.h.eaA));
    this.KDh = ((ImageView)findViewById(R.h.status_icon));
    int i;
    label117:
    Object localObject;
    label305:
    label364:
    Drawable localDrawable;
    label469:
    int j;
    if (7 == o.bor())
    {
      i = 1;
      if ((i == 0) || (!o.boy())) {
        break label586;
      }
      i = 1;
      if ((g.awg()) && (i == 0)) {
        break label591;
      }
      this.QEw.removeView(findViewById(R.h.dAu));
      this.QEo = false;
      Log.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + o.bow());
      if (o.bow()) {
        break label661;
      }
      findViewById(R.h.dLD).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, R.b.fade_in_property_anim);
      ((Animator)localObject).setTarget(findViewById(R.h.eaF));
      this.QEu = AnimatorInflater.loadAnimator(this, R.b.fade_out_property_anim);
      this.QEu.setTarget(findViewById(R.h.eaF));
      this.QEu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.sWP = o.bot();
      this.QEp = findViewById(R.h.eaD);
      this.QEr = ((WeImageView)findViewById(R.h.dIz));
      DA(this.sWP);
      this.QEp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30217);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (WebWXLogoutUI.c(WebWXLogoutUI.this))
          {
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(R.g.circle_btn_bg);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(R.e.FG_0));
          }
          for (;;)
          {
            WebWXLogoutUI.f(WebWXLogoutUI.this);
            WebWXLogoutUI.this.findViewById(R.h.eaF).setVisibility(0);
            this.QEy.start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(R.g.circle_btn_brand_bg);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(R.e.BW_100_Alpha_0_8));
          }
        }
      });
      Log.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + o.box());
      if (o.box()) {
        break label678;
      }
      findViewById(R.h.eaz).setVisibility(0);
      findViewById(R.h.eay).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30218);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", "filehelper");
          paramAnonymousView.putExtra("key_show_bottom_app_panel", true);
          com.tencent.mm.plugin.webwx.a.mIG.d(paramAnonymousView, WebWXLogoutUI.this);
          Log.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
          WebWXLogoutUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30218);
        }
      });
      hcQ();
      localObject = (Button)findViewById(R.h.eaK);
      if (!Util.isNullOrNil(o.lZF)) {
        ((Button)localObject).setText(o.lZF);
      }
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30219);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.WebWXLogoutUI", "logout webwx");
          WebWXLogoutUI.g(WebWXLogoutUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30219);
        }
      });
      if (o.bor() != 1) {
        break label695;
      }
      localObject = getResources().getDrawable(R.k.connect_pc);
      localDrawable = getResources().getDrawable(R.k.connect_pc_mute);
      if ((localObject != null) && (localDrawable != null))
      {
        this.Nme = ((Drawable)localObject).getIntrinsicWidth();
        this.QEt = localDrawable.getIntrinsicWidth();
      }
      i = ax.ew(getContext());
      j = ax.at(getContext());
      localObject = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label757;
      }
      getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
    }
    for (;;)
    {
      int k = ((Point)localObject).y;
      Log.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.Cxu = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      i = 0;
      break;
      label586:
      i = 0;
      break label117;
      label591:
      this.QEq = findViewById(R.h.eax);
      this.QEs = ((WeImageView)findViewById(R.h.dIB));
      if (z.awX()) {}
      for (this.QEo = true;; this.QEo = false)
      {
        DB(this.QEo);
        this.QEq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30215);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      label661:
      this.QEw.removeView(findViewById(R.h.dLD));
      break label305;
      label678:
      this.QEw.removeView(findViewById(R.h.eaz));
      break label364;
      label695:
      if (o.bor() != 2) {
        break label469;
      }
      localObject = getResources().getDrawable(R.k.connect_mac);
      localDrawable = getResources().getDrawable(R.k.connect_mac_mute);
      if ((localObject == null) || (localDrawable == null)) {
        break label469;
      }
      this.Nme = ((Drawable)localObject).getIntrinsicWidth();
      this.QEt = localDrawable.getIntrinsicWidth();
      break label469;
      label757:
      getWindowManager().getDefaultDisplay().getSize((Point)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30225);
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.QEv = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    bh.aGY().a(281, this);
    bh.aGY().a(792, this);
    bh.beI();
    com.tencent.mm.model.c.a(this);
    EventCenter.instance.addListener(this.JYs);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    bh.aGY().b(281, this);
    bh.aGY().b(792, this);
    bh.beI();
    com.tencent.mm.model.c.b(this);
    EventCenter.instance.removeListener(this.JYs);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
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
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30234);
    if (this.JfW != null)
    {
      this.JfW.dismiss();
      this.JfW = null;
    }
    if (paramq.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, R.l.eVM, 1).show();
      }
      finish();
      AppMethodBeat.o(30234);
      return;
    }
    boolean bool;
    if (paramq.getType() == 792)
    {
      int i = ((com.tencent.mm.plugin.webwx.a.b)paramq).fCN;
      if (this.QEu != null) {
        this.QEu.start();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (i == 1)
        {
          Toast.makeText(this, R.l.eVH, 0).show();
          AppMethodBeat.o(30234);
          return;
        }
        Toast.makeText(this, R.l.eVP, 0).show();
        AppMethodBeat.o(30234);
        return;
      }
      if (i != 1) {
        break label211;
      }
      bool = true;
      this.sWP = bool;
      o.gw(this.sWP);
      updateStatus();
      if (!this.sWP) {
        break label217;
      }
    }
    label211:
    label217:
    for (paramString = "lock";; paramString = "unlock")
    {
      Log.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */