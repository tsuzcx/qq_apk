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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@com.tencent.mm.ui.base.a(3)
public class WebWXLogoutUI
  extends MMActivity
  implements i, bc
{
  private IListener DLr;
  private ProgressDialog Dav;
  private ImageView EpU;
  private int GyC;
  private View JFA;
  private WeImageView JFB;
  private WeImageView JFC;
  private int JFD;
  private Animator JFE;
  private int JFF;
  private GridLayout JFG;
  private boolean JFq;
  private boolean JFy;
  private View JFz;
  private int Jmd;
  private boolean pPO;
  
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    this.Dav = null;
    this.JFq = false;
    this.DLr = new WebWXLogoutUI.9(this);
    AppMethodBeat.o(30223);
  }
  
  private void gje()
  {
    AppMethodBeat.i(30229);
    Log.i("MicroMsg.WebWXLogoutUI", "grid child count %d", new Object[] { Integer.valueOf(this.JFG.getChildCount()) });
    if (this.JFG.getChildCount() > 1)
    {
      int i = 0;
      if (i < this.JFG.getChildCount())
      {
        GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.JFG.getChildAt(i).getLayoutParams();
        if (i == 0) {
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
        }
        for (;;)
        {
          this.JFG.getChildAt(i).setLayoutParams(localLayoutParams);
          i += 1;
          break;
          if (i == this.JFG.getChildCount() - 1)
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
  
  private boolean gjf()
  {
    AppMethodBeat.i(30233);
    if (!bg.aAc())
    {
      AppMethodBeat.o(30233);
      return false;
    }
    int i = z.aUe();
    if (this.JFy) {
      i |= 0x2000;
    }
    for (;;)
    {
      g.oI(i);
      bg.aVF();
      c.azQ().set(40, Integer.valueOf(i));
      this.JFq = true;
      updateStatus();
      AppMethodBeat.o(30233);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(30230);
    if (!Util.isNullOrNil(o.jjD))
    {
      ((TextView)findViewById(2131308396)).setText(o.jjD);
      if (o.bfc() == 1)
      {
        if (!this.JFy)
        {
          this.EpU.setImageResource(2131690012);
          this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
          AppMethodBeat.o(30230);
        }
      }
      else
      {
        if (o.bfc() == 2)
        {
          if (this.JFy) {
            ((TextView)findViewById(2131306305)).setText(2131768645);
          }
          while (this.pPO)
          {
            ((TextView)findViewById(2131308396)).setText(getString(2131768629, new Object[] { "Mac" }));
            this.EpU.setImageResource(2131690006);
            this.EpU.setPadding(0, this.Jmd, 0, 0);
            if ((!g.apN()) || (this.JFy)) {
              break label724;
            }
            ((TextView)findViewById(2131306305)).setText(2131768625);
            this.EpU.setImageResource(2131690008);
            this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
            AppMethodBeat.o(30230);
            return;
            if (!g.apN()) {
              ((TextView)findViewById(2131306305)).setText("");
            }
          }
          ((TextView)findViewById(2131308396)).setText(getString(2131768632, new Object[] { "Mac" }));
          this.EpU.setImageResource(2131690005);
          this.EpU.setPadding(0, this.Jmd, 0, 0);
          if ((!g.apN()) || (this.JFy)) {
            break label724;
          }
          ((TextView)findViewById(2131306305)).setText(2131768625);
          this.EpU.setImageResource(2131690007);
          this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bfc() == 3)
        {
          this.EpU.setImageResource(2131690002);
          this.EpU.setPadding(0, this.Jmd, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bfc() == 7)
        {
          this.EpU.setImageResource(2131690004);
          this.EpU.setPadding(0, this.Jmd, 0, 0);
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bfc() == 6)
        {
          this.EpU.setImageResource(2131689991);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.EpU.getLayoutParams();
          localLayoutParams.width = com.tencent.mm.cb.a.aG(this, 2131167158);
          localLayoutParams.height = com.tencent.mm.cb.a.aG(this, 2131167158);
          localLayoutParams.topMargin = this.Jmd;
          this.EpU.setLayoutParams(localLayoutParams);
          this.EpU.setAlpha(0.3F);
          ((TextView)findViewById(2131306305)).setText("");
          if (!Util.isNullOrNil(o.jjC))
          {
            ((TextView)findViewById(2131299576)).setText(o.jjC);
            findViewById(2131299576).setVisibility(0);
          }
          AppMethodBeat.o(30230);
          return;
        }
        if (o.bfc() == 8)
        {
          if (this.JFy)
          {
            this.EpU.setImageResource(2131689989);
            this.EpU.setPadding(0, this.Jmd, 0, 0);
          }
          for (;;)
          {
            ((TextView)findViewById(2131306305)).setText("");
            AppMethodBeat.o(30230);
            return;
            this.EpU.setImageResource(2131689990);
            this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
          }
        }
      }
      this.EpU.setImageResource(2131690010);
      this.EpU.setPadding(0, this.Jmd, 0, 0);
    }
    label724:
    AppMethodBeat.o(30230);
  }
  
  private void zB(boolean paramBoolean)
  {
    AppMethodBeat.i(30231);
    if (this.JFz != null)
    {
      if (paramBoolean)
      {
        this.JFz.setBackgroundResource(2131231836);
        ((TextView)findViewById(2131310411)).setText(2131768646);
        AppMethodBeat.o(30231);
        return;
      }
      this.JFz.setBackgroundResource(2131231835);
      ((TextView)findViewById(2131310411)).setText(2131768628);
    }
    AppMethodBeat.o(30231);
  }
  
  private void zC(boolean paramBoolean)
  {
    AppMethodBeat.i(30232);
    if (this.JFA != null)
    {
      if (paramBoolean)
      {
        this.JFA.setBackgroundResource(2131231835);
        this.JFC.setIconColor(getResources().getColor(2131099746));
        AppMethodBeat.o(30232);
        return;
      }
      this.JFA.setBackgroundResource(2131231836);
      this.JFC.setIconColor(getResources().getColor(2131099679));
    }
    AppMethodBeat.o(30232);
  }
  
  public final void aVw()
  {
    AppMethodBeat.i(30235);
    bg.aVF();
    if (!c.azn())
    {
      finish();
      AppMethodBeat.o(30235);
      return;
    }
    if ((o.bfe()) && (!this.pPO))
    {
      Log.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
      this.pPO = true;
      zB(this.pPO);
      updateStatus();
    }
    AppMethodBeat.o(30235);
  }
  
  public void finish()
  {
    AppMethodBeat.i(30224);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(30224);
  }
  
  public int getLayoutId()
  {
    return 2131497081;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30228);
    setMMTitle("");
    setBackBtn(new WebWXLogoutUI.1(this), 2131689490);
    if ((!Util.isNullOrNil(o.jjL)) && (o.bfc() == 6)) {
      addIconOptionMenu(10001, 2131690814, new WebWXLogoutUI.2(this));
    }
    hideActionbarLine();
    this.JFG = ((GridLayout)findViewById(2131310407));
    this.EpU = ((ImageView)findViewById(2131308398));
    int i;
    label117:
    Object localObject;
    label305:
    label364:
    Drawable localDrawable;
    label469:
    int j;
    if (7 == o.bfc())
    {
      i = 1;
      if ((i == 0) || (!o.bfi())) {
        break label586;
      }
      i = 1;
      if ((g.apN()) && (i == 0)) {
        break label591;
      }
      this.JFG.removeView(findViewById(2131298766));
      this.JFy = false;
      Log.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + o.bfg());
      if (o.bfg()) {
        break label661;
      }
      findViewById(2131303760).setVisibility(0);
      localObject = AnimatorInflater.loadAnimator(this, 2130837509);
      ((Animator)localObject).setTarget(findViewById(2131310412));
      this.JFE = AnimatorInflater.loadAnimator(this, 2130837510);
      this.JFE.setTarget(findViewById(2131310412));
      this.JFE.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(30216);
          super.onAnimationEnd(paramAnonymousAnimator);
          WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.c(WebWXLogoutUI.this));
          AppMethodBeat.o(30216);
        }
      });
      this.pPO = o.bfe();
      this.JFz = findViewById(2131310410);
      this.JFB = ((WeImageView)findViewById(2131302499));
      zB(this.pPO);
      this.JFz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30217);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (WebWXLogoutUI.c(WebWXLogoutUI.this))
          {
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231835);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099746));
          }
          for (;;)
          {
            WebWXLogoutUI.f(WebWXLogoutUI.this);
            WebWXLogoutUI.this.findViewById(2131310412).setVisibility(0);
            this.JFI.start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30217);
            return;
            WebWXLogoutUI.d(WebWXLogoutUI.this).setBackgroundResource(2131231836);
            WebWXLogoutUI.e(WebWXLogoutUI.this).setIconColor(WebWXLogoutUI.this.getResources().getColor(2131099679));
          }
        }
      });
      Log.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + o.bfh());
      if (o.bfh()) {
        break label678;
      }
      findViewById(2131310406).setVisibility(0);
      findViewById(2131310405).setOnClickListener(new WebWXLogoutUI.6(this));
      gje();
      localObject = (Button)findViewById(2131310417);
      if (!Util.isNullOrNil(o.jjJ)) {
        ((Button)localObject).setText(o.jjJ);
      }
      ((Button)localObject).setOnClickListener(new WebWXLogoutUI.7(this));
      if (o.bfc() != 1) {
        break label695;
      }
      localObject = getResources().getDrawable(2131690010);
      localDrawable = getResources().getDrawable(2131690012);
      if ((localObject != null) && (localDrawable != null))
      {
        this.GyC = ((Drawable)localObject).getIntrinsicWidth();
        this.JFD = localDrawable.getIntrinsicWidth();
      }
      i = au.eu(getContext());
      j = au.ay(getContext());
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
      this.Jmd = ((int)(k / 4.0D) - j - i);
      updateStatus();
      AppMethodBeat.o(30228);
      return;
      i = 0;
      break;
      label586:
      i = 0;
      break label117;
      label591:
      this.JFA = findViewById(2131310404);
      this.JFC = ((WeImageView)findViewById(2131302504));
      if (z.aqE()) {}
      for (this.JFy = true;; this.JFy = false)
      {
        zC(this.JFy);
        this.JFA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30215);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      this.JFG.removeView(findViewById(2131303760));
      break label305;
      label678:
      this.JFG.removeView(findViewById(2131310406));
      break label364;
      label695:
      if (o.bfc() != 2) {
        break label469;
      }
      localObject = getResources().getDrawable(2131690005);
      localDrawable = getResources().getDrawable(2131690007);
      if ((localObject == null) || (localDrawable == null)) {
        break label469;
      }
      this.GyC = ((Drawable)localObject).getIntrinsicWidth();
      this.JFD = localDrawable.getIntrinsicWidth();
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
      this.JFF = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(2130772132, 2130771986);
    bg.azz().a(281, this);
    bg.azz().a(792, this);
    bg.aVF();
    c.a(this);
    EventCenter.instance.addListener(this.DLr);
    AppMethodBeat.o(30225);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30227);
    super.onDestroy();
    overridePendingTransition(2130771986, 2130772130);
    bg.azz().b(281, this);
    bg.azz().b(792, this);
    bg.aVF();
    c.b(this);
    EventCenter.instance.removeListener(this.DLr);
    AppMethodBeat.o(30227);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30226);
    super.onPause();
    bfx localbfx;
    if ((this.JFq) && (bg.aAc()))
    {
      localbfx = new bfx();
      localbfx.LPB = 27;
      if (!z.aqE()) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 2)
    {
      localbfx.BsD = i;
      bg.aVF();
      c.aSM().d(new k.a(23, localbfx));
      this.JFq = false;
      AppMethodBeat.o(30226);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30234);
    if (this.Dav != null)
    {
      this.Dav.dismiss();
      this.Dav = null;
    }
    if (paramq.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, 2131768643, 1).show();
      }
      finish();
      AppMethodBeat.o(30234);
      return;
    }
    boolean bool;
    if (paramq.getType() == 792)
    {
      int i = ((com.tencent.mm.plugin.webwx.a.b)paramq).dJY;
      if (this.JFE != null) {
        this.JFE.start();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (i == 1)
        {
          Toast.makeText(this, 2131768630, 0).show();
          AppMethodBeat.o(30234);
          return;
        }
        Toast.makeText(this, 2131768647, 0).show();
        AppMethodBeat.o(30234);
        return;
      }
      if (i != 1) {
        break label211;
      }
      bool = true;
      this.pPO = bool;
      o.fK(this.pPO);
      updateStatus();
      if (!this.pPO) {
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