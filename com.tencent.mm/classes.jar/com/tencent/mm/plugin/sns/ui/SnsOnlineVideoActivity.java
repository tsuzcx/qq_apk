package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.h.a.qf;
import com.tencent.mm.h.a.qg;
import com.tencent.mm.h.a.si;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private float aqX = 0.0F;
  private float aqY = 0.0F;
  private String bMB;
  private awd bZK;
  private boolean dnJ;
  private String erh;
  private VelocityTracker fB;
  private GestureDetector gEU;
  private boolean hZa = true;
  n.d ifj = new SnsOnlineVideoActivity.6(this);
  private com.tencent.mm.ui.tools.e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  private Bundle ity;
  private boolean itz = false;
  private boolean kgc = true;
  private RelativeLayout kgv;
  private ImageView kgw;
  private boolean mfb;
  private com.tencent.mm.ui.widget.a.d oOK;
  private boolean oQY = false;
  private boolean oRs;
  private n oUH;
  private float oVI = 1.0F;
  private int oVJ = 0;
  private int oVK = 0;
  private Button oVz;
  private OnlineVideoView pbj;
  private boolean pbk = false;
  private boolean pbl;
  private boolean pbm = false;
  private boolean pbn = false;
  private boolean pbo = false;
  private boolean pbp = false;
  n.c pbq = new SnsOnlineVideoActivity.5(this);
  private int scene = 0;
  private String thumbPath;
  
  private void aBT()
  {
    if (this.oRs)
    {
      y.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      return;
    }
    this.pbj.setOnLongClickListener(new SnsOnlineVideoActivity.13(this));
  }
  
  private void bJg()
  {
    boolean bool = ak.gw(this);
    int i = ak.gv(this);
    if ((this.mfb) && (bool) && (this.oVz != null) && (this.oVz.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.oVz.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.oVz.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public final void aBR()
  {
    if ((this.oVz != null) && (this.oVz.getVisibility() == 0)) {
      this.oVz.setVisibility(8);
    }
    int k = this.kgv.getWidth();
    int j = this.kgv.getHeight();
    int i = j;
    if (this.itD != 0)
    {
      i = j;
      if (this.itE != 0) {
        i = (int)(k / this.itD * this.itE);
      }
    }
    this.itA.fH(k, i);
    this.itA.E(this.itC, this.itB, this.itD, this.itE);
    if (this.oVI != 1.0D)
    {
      this.itA.wcx = (1.0F / this.oVI);
      if ((this.oVJ != 0) || (this.oVK != 0))
      {
        j = (int)(this.kgv.getWidth() / 2 * (1.0F - this.oVI));
        k = this.oVJ;
        i = (int)(this.kgv.getHeight() / 2 + this.oVK - i / 2 * this.oVI);
        this.itA.fI(j + k, i);
      }
    }
    this.itA.a(this.pbj, this.kgw, new SnsOnlineVideoActivity.4(this), null);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      aBR();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getForceOrientation()
  {
    return 2;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_video_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = bk.G(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = com.tencent.mm.plugin.sns.model.af.bDF().OB(this.bMB);
          if (localObject1 != null)
          {
            if (!com.tencent.mm.model.s.fn(str2)) {
              break label344;
            }
            localObject2 = new qf();
            ((qf)localObject2).bZD.bRV = i.j((n)localObject1);
            ((qf)localObject2).bZD.bJQ = ((n)localObject1).bGE();
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label172:
        Object localObject2 = this.oUH.bGe();
        int i = i.Nh(this.erh);
        awd localawd;
        if (bk.bl(this.thumbPath))
        {
          localawd = this.bZK;
          if (localawd == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          y.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.erh, this.thumbPath, this.bZK.trW, Integer.valueOf(this.bZK.pkD), Integer.valueOf(i) });
          g.bhI().a(this, str2, this.erh, this.thumbPath, 43, i, ((bxk)localObject2).oPO);
          if (str1 != null) {
            g.bhI().dO(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.j.has_send));
          break;
          label344:
          localObject2 = new qg();
          ((qg)localObject2).bZE.bRV = i.j((n)localObject1);
          ((qg)localObject2).bZE.bJQ = ((n)localObject1).bGE();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          break label172;
          String str3 = an.eJ(com.tencent.mm.plugin.sns.model.af.getAccSnsPath(), localawd.lsK);
          localObject1 = str3 + i.e(localawd);
          boolean bool = com.tencent.mm.vfs.e.bK((String)localObject1);
          y.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + i.n(localawd);
            y.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
            continue;
            localObject1 = this.thumbPath;
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      y.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      bJg();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramConfiguration.orientation != 2);
        y.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      } while ((this.oVz == null) || (this.oVz.getVisibility() != 0));
      paramConfiguration = (ViewGroup.MarginLayoutParams)this.oVz.getLayoutParams();
    } while (paramConfiguration.bottomMargin == getResources().getDimensionPixelSize(i.d.sns_game_more_button_bottom_margin));
    paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(i.d.sns_game_more_button_bottom_margin);
    this.oVz.setLayoutParams(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    this.ity = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.bMB = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.oRs = getIntent().getBooleanExtra("intent_ispreview", false);
    this.dnJ = getIntent().getBooleanExtra("intent_ismute", false);
    this.oQY = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    y.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.bMB, Integer.valueOf(this.scene), Boolean.valueOf(this.oRs), Boolean.valueOf(this.dnJ), paramBundle });
    if (!this.oRs) {}
    for (;;)
    {
      try
      {
        this.oUH = com.tencent.mm.plugin.sns.model.af.bDF().OB(this.bMB);
        this.bZK = ((awd)this.oUH.bGe().tNr.sPJ.get(0));
        this.erh = (an.eJ(com.tencent.mm.plugin.sns.model.af.getAccSnsPath(), this.bZK.lsK) + i.j(this.bZK));
        y.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.oUH.bGE() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.gF(19)) {
            break label657;
          }
          if (!this.oRs) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.mfb = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          y.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.pbj;
          Object localObject1 = this.erh;
          Object localObject2 = this.thumbPath;
          paramBundle.oRt = ((String)localObject1);
          paramBundle.oRs = true;
          paramBundle.kga.setImageBitmap(BackwardSupportUtil.b.e((String)localObject2, 1.0F));
          y.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.oRs) });
          continue;
          this.mController.hideTitleView();
          this.kgv.setOnTouchListener(new SnsOnlineVideoActivity.7(this));
          continue;
          this.oVz = ((Button)findViewById(i.f.game_more_button));
          localObject1 = paramBundle.bGe();
          if (localObject1 == null) {
            break label906;
          }
          for (paramBundle = ((bxk)localObject1).ouC;; paramBundle = null)
          {
            localObject2 = new ax();
            af.a(this, (ax)localObject2, ((bxk)localObject1).ouC);
            if (!((ax)localObject2).phD) {
              break label911;
            }
            this.oVz.setVisibility(0);
            this.oVz.setText(((ax)localObject2).phE);
            this.oVz.setOnClickListener(new SnsOnlineVideoActivity.12(this, paramBundle, (bxk)localObject1));
            if (getRequestedOrientation() == 0) {
              break;
            }
            bJg();
            break;
          }
          this.oVz.setVisibility(8);
          continue;
        }
        this.kgv = ((RelativeLayout)findViewById(i.f.video_ui_root));
        this.pbj = ((OnlineVideoView)findViewById(i.f.video_view));
        if (this.oRs) {
          break;
        }
        this.pbj.a(this.bZK, this.oUH.bGE(), this.oUH.field_createTime);
        this.pbj.setMute(this.dnJ);
        this.kgw = ((ImageView)findViewById(i.f.gallery_bg));
        this.kgw.setLayerType(2, null);
        if (!this.oRs) {
          break label779;
        }
        setMMTitle(i.j.app_back);
        this.pbj.setOnClickListener(new SnsOnlineVideoActivity.1(this));
        this.gEU = new GestureDetector(this.mController.uMN, new GestureDetector.SimpleOnGestureListener()
        {
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, true);
            super.onLongPress(paramAnonymousMotionEvent);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            paramAnonymousFloat1 = paramAnonymousMotionEvent2.getRawX() - paramAnonymousMotionEvent1.getRawX();
            paramAnonymousFloat2 = paramAnonymousMotionEvent2.getRawY() - paramAnonymousMotionEvent1.getRawY();
            if ((Math.abs(paramAnonymousFloat1) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth()) && (Math.abs(paramAnonymousFloat2) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight()) && (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationX(paramAnonymousFloat1);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(paramAnonymousFloat2);
            }
            return true;
          }
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
              SnsOnlineVideoActivity.this.aBR();
            }
            return super.onSingleTapUp(paramAnonymousMotionEvent);
          }
        });
        this.pbj.setOnTouchListener(new SnsOnlineVideoActivity.9(this));
        this.itA = new com.tencent.mm.ui.tools.e(this.mController.uMN);
        paramBundle = this.oUH;
        if (paramBundle != null) {
          break label804;
        }
        y.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.oRs)
        {
          if (!this.oQY) {
            addIconOptionMenu(0, i.j.app_delete, i.e.mm_title_btn_delete_normal, new SnsOnlineVideoActivity.10(this));
          }
          setBackBtn(new SnsOnlineVideoActivity.11(this));
        }
        aBT();
        paramBundle = new si();
        paramBundle.cbT.type = 1;
        com.tencent.mm.sdk.b.a.udP.m(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        y.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.erh = paramBundle;
      continue;
      label657:
      if (!this.oRs) {
        getWindow().setFlags(1024, 1024);
      }
      this.mfb = false;
    }
  }
  
  protected void onDestroy()
  {
    this.pbj.onDestroy();
    try
    {
      getWindow().clearFlags(128);
      label17:
      super.onDestroy();
      if ((this.oUH != null) && (this.oUH.bGe().tNr.sPJ.size() > 0))
      {
        String str = ((awd)this.oUH.bGe().tNr.sPJ.get(0)).kSC;
        int i = this.oUH.bGe().tNy;
        PInt localPInt = new PInt();
        u.a(aq.D((awd)this.oUH.bGe().tNr.sPJ.get(0)), localPInt, new PInt());
        int j = this.pbj.getPlayVideoDuration();
        h.nFQ.f(15534, new Object[] { str, this.oUH.bGe().lsK, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
      }
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  protected void onPause()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    this.pbj.onPause();
    if (!this.pbk)
    {
      y.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
      if (!this.pbl) {
        break label81;
      }
      new ah().postDelayed(new SnsOnlineVideoActivity.14(this), 500L);
    }
    for (;;)
    {
      super.onPause();
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
      return;
      label81:
      new ah().post(new SnsOnlineVideoActivity.2(this));
    }
  }
  
  protected void onResume()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if (!this.kgc) {
      this.pbj.onResume();
    }
    this.kgc = false;
    if (this.pbk) {
      this.pbk = false;
    }
    super.onResume();
    com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
  }
  
  public void onStart()
  {
    Bundle localBundle = this.ity;
    if (!this.itz)
    {
      this.itz = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.itB = getIntent().getIntExtra("img_gallery_top", 0);
        this.itC = getIntent().getIntExtra("img_gallery_left", 0);
        this.itD = getIntent().getIntExtra("img_gallery_width", 0);
        this.itE = getIntent().getIntExtra("img_gallery_height", 0);
        this.itA.E(this.itC, this.itB, this.itD, this.itE);
        if (localBundle == null) {
          this.pbj.getViewTreeObserver().addOnPreDrawListener(new SnsOnlineVideoActivity.3(this));
        }
      }
    }
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity
 * JD-Core Version:    0.7.0.1
 */