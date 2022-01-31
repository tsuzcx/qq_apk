package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.qf;
import com.tencent.mm.h.a.qg;
import com.tencent.mm.h.a.si;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.a.b.j.d;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, b.b
{
  private float aqX = 0.0F;
  private float aqY = 0.0F;
  private String bMB = "";
  private awd bZK = null;
  private int cbW = 0;
  public com.tencent.mm.ui.tools.j contextMenuHelper;
  private boolean dBn = false;
  private boolean dYj = false;
  private int duration = 0;
  private String erh = "";
  private VelocityTracker fB;
  private com.tencent.mm.model.d gEB;
  private GestureDetector gEU;
  private int hkH = 0;
  n.d ifj = new SnsSightPlayerUI.6(this);
  private String imagePath = "";
  com.tencent.mm.ui.tools.e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  Bundle ity;
  private boolean itz = false;
  f iuC = null;
  private TextView kfj = null;
  private boolean kfm = false;
  private ImageView kgw;
  private com.tencent.mm.plugin.sns.storage.n oUH = null;
  private float oVI = 1.0F;
  private int oVJ = 0;
  private int oVK = 0;
  private TextView ofU = null;
  private boolean ofV = false;
  private int ofb = 0;
  ViewGroup oge;
  private int ogm = 0;
  private int ogn = 0;
  public int ogu = 0;
  private boolean omL = false;
  private boolean pbk = false;
  private boolean pbn = false;
  private boolean pbo = false;
  private boolean pbp = false;
  private h pdc = new h("SnsSightPlayerUI");
  private String pdd = "";
  private TextView pde = null;
  private MMPinProgressBtn pdf = null;
  private com.tencent.mm.plugin.sns.storage.a pdg = null;
  private String pdh = "";
  private RelativeLayout pdi;
  View.OnCreateContextMenuListener pdj = new SnsSightPlayerUI.5(this);
  private int source = 0;
  private String thumbPath = "";
  
  private void aa(int paramInt, boolean paramBoolean)
  {
    if ((this.ogn == 0) || (this.ogm == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.ogn = ((DisplayMetrics)localObject).heightPixels;
      this.ogm = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.oge.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.pde.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.ogm;
      localLayoutParams1.height = ((int)(this.ogm * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.oge.getId());
      findViewById(i.f.tips_tv).setVisibility(0);
    }
    for (;;)
    {
      y.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.iuC).setLayoutParams(localLayoutParams1);
      if ((this.iuC instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.iuC).dL(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.ofU.setLayoutParams(localLayoutParams);
      this.oge.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.iuC).requestLayout();
      if (!paramBoolean) {
        yO(paramInt);
      }
      return;
      localLayoutParams1.height = this.ogm;
      localLayoutParams1.width = ((int)(this.ogm * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.oge.getId());
      findViewById(i.f.tips_tv).setVisibility(8);
    }
  }
  
  private void bFy()
  {
    y.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.iuC.pause();
    this.iuC.onDetach();
    this.gEB.bH(false);
  }
  
  private void iP(boolean paramBoolean)
  {
    this.iuC.start();
    this.duration = this.iuC.getDuration();
    y.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.gEB.a(this);
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (paramBoolean)
    {
      locala = this.pdc.olx;
      if (getResources().getConfiguration().orientation != 2) {
        break label116;
      }
    }
    label116:
    for (int i = 2;; i = 1)
    {
      locala.omy = i;
      this.pdc.olx.omz = bk.UZ();
      this.pdc.olx.omx = 2;
      return;
    }
  }
  
  private void yO(int paramInt)
  {
    if (!this.omL) {}
    while (!this.iuC.isPlaying()) {
      return;
    }
    if (this.duration == 0) {
      this.duration = this.iuC.getDuration();
    }
    this.pdc.xx(this.duration);
    this.pdc.olx.omz = bk.UZ();
    com.tencent.mm.plugin.sns.a.b.a.a locala = this.pdc.olx;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.omy = paramInt;
      this.pdc.olx.omx = 2;
      y.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.pdc.olx.omy);
      return;
    }
  }
  
  public final void Ni(String paramString) {}
  
  public final void aBR()
  {
    int k = this.oge.getWidth();
    int j = this.oge.getHeight();
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
      int m = ak.gv(this.mController.uMN);
      this.itA.wcx = (1.0F / this.oVI);
      if ((this.oVJ != 0) || (this.oVK != 0))
      {
        j = (int)(this.oge.getWidth() / 2 * (1.0F - this.oVI));
        k = this.oVJ;
        i = (int)((m + this.oge.getHeight()) / 2 - i / 2 * this.oVI + this.oVK);
        this.itA.fI(j + k, i);
      }
    }
    this.itA.a(this.oge, this.kgw, new SnsSightPlayerUI.4(this), null);
  }
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.SnsSightPlayerUI", "onSightFinish " + paramString);
    if ((this.omL) && (!bk.bl(paramString)) && (this.bZK != null) && (paramString.equals(this.bZK.lsK)) && (com.tencent.mm.vfs.e.bK(this.erh)))
    {
      this.pdc.olp = 1;
      this.iuC.setVideoPath(this.erh);
      iP(true);
      if (this.pdf != null) {
        this.pdf.setVisibility(8);
      }
    }
  }
  
  public void finish()
  {
    if (!this.dYj)
    {
      super.finish();
      this.dYj = true;
    }
  }
  
  protected final int getForceOrientation()
  {
    return 7;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_sight_player_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    label146:
    label664:
    if (4097 == paramInt1)
    {
      label288:
      label676:
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bk.G(((String)localObject1).split(",")).iterator();
        String str2;
        Object localObject3;
        bwa localbwa;
        label239:
        do
        {
          if (!localIterator.hasNext()) {
            break label802;
          }
          str2 = (String)localIterator.next();
          if (this.source == 0)
          {
            localObject1 = af.bDF().OB(this.bMB);
            if (localObject1 != null)
            {
              if (!com.tencent.mm.model.s.fn(str2)) {
                break;
              }
              localObject2 = new qf();
              ((qf)localObject2).bZD.bRV = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
              ((qf)localObject2).bZD.bJQ = ((com.tencent.mm.plugin.sns.storage.n)localObject1).bGE();
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.oUH.bGe();
          if (!this.omL) {
            break label676;
          }
          localObject3 = this.oUH.bFZ();
          localbwa = new bwa();
          localbwa.sWK = this.bZK.pkD;
          localbwa.dSP = this.bZK.trW;
          if (((bxk)localObject2).tNr.sPI != 15) {
            break label623;
          }
          localbwa.dSV = this.pdg.ovV;
          localbwa.dSW = ((bxk)localObject2).lsK;
          if (!bk.bl(this.bZK.tsa)) {
            break label652;
          }
          localObject1 = ((bxk)localObject2).tNo;
          localbwa.dSR = ((String)localObject1);
          if (!bk.bl(this.bZK.trZ)) {
            break label664;
          }
          localObject1 = this.bZK.trP;
          localbwa.dSU = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).oAN == 0))
          {
            localbwa.dST = ((com.tencent.mm.plugin.sns.storage.b)localObject3).oAP;
            localbwa.dSS = ((com.tencent.mm.plugin.sns.storage.b)localObject3).oAO;
          }
          if (localObject3 != null) {
            localbwa.dST = ((com.tencent.mm.plugin.sns.storage.b)localObject3).oAa;
          }
          i = i.Nh(this.erh);
          y.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.erh, this.imagePath, this.bZK.trW, Integer.valueOf(this.bZK.pkD), localbwa.dSU, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.bhI().a(this, str2, this.erh, this.imagePath, 43, i, localbwa, ((bxk)localObject2).oPO);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.bhI().dO(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.j.has_send));
        } while (!this.omL);
        label455:
        i.a(new SnsAdClick(this.source, 5, this.oUH.field_snsId, 12, 0));
        boolean bool = com.tencent.mm.model.s.fn(str2);
        Object localObject2 = j.d.omj;
        if (bool)
        {
          localObject1 = j.c.omg;
          localObject3 = j.e.omq;
          if (!bool) {
            break label764;
          }
        }
        label623:
        label764:
        for (int i = m.gM(str2);; i = 0)
        {
          com.tencent.mm.plugin.sns.a.b.j.a((j.d)localObject2, (j.c)localObject1, (j.e)localObject3, i, this.oUH, this.source);
          break;
          localObject2 = new qg();
          ((qg)localObject2).bZE.bRV = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
          ((qg)localObject2).bZE.bJQ = ((com.tencent.mm.plugin.sns.storage.n)localObject1).bGE();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          break label146;
          localbwa.dSV = ((bxk)localObject2).tNw.dSV;
          localbwa.dSW = ((bxk)localObject2).tNw.dSW;
          break label239;
          localObject1 = this.bZK.tsa;
          break label259;
          localObject1 = this.bZK.trZ;
          break label288;
          i = i.Nh(this.erh);
          y.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.erh, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.bhI().a(this, str2, this.erh, this.imagePath, 43, i, ((bxk)localObject2).oPO);
          break label455;
          localObject1 = j.c.omf;
          break label537;
        }
      }
      label537:
      if (this.omL) {
        i.a(new SnsAdClick(this.source, 5, this.oUH.field_snsId, 13, 0));
      }
    }
    label259:
    label652:
    label802:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    aBR();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.ogu);
    if (this.ogu == paramConfiguration.orientation) {
      return;
    }
    int i = paramConfiguration.orientation;
    aa(paramConfiguration.orientation, false);
    this.ogu = paramConfiguration.orientation;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    this.source = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    af.bDA().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(i.c.black));
    }
    if (com.tencent.mm.compatible.util.d.gF(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.ity = paramBundle;
      this.gEB = new com.tencent.mm.model.d();
      this.erh = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.bMB = getIntent().getStringExtra("intent_localid");
      this.omL = getIntent().getBooleanExtra("intent_isad", false);
      this.oUH = af.bDF().OB(this.bMB);
      if (!this.omL) {
        break label342;
      }
      if (this.oUH != null) {
        break label239;
      }
    }
    label239:
    Object localObject1;
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label342;
      }
      finish();
      return;
      getWindow().setFlags(1024, 1024);
      break;
      this.bZK = ((awd)this.oUH.bGe().tNr.sPJ.get(0));
      paramBundle = an.eJ(af.getAccSnsPath(), this.bZK.lsK);
      localObject1 = i.k(this.bZK);
      this.pdh = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + i.e(this.bZK));
    }
    label342:
    if (com.tencent.mm.r.a.tu() != null) {
      com.tencent.mm.r.a.tu().vT();
    }
    if (this.oUH != null) {
      if (this.source == 2)
      {
        paramBundle = this.oUH.bGc();
        this.pdg = paramBundle;
        this.pdc.olr = bk.UZ();
        this.pdi = ((RelativeLayout)findViewById(i.f.content_root));
        this.pdi.setOnTouchListener(new SnsSightPlayerUI.1(this));
        y.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.zH() + " initView: fullpath:" + this.erh + ", imagepath:" + this.imagePath);
        this.itA = new com.tencent.mm.ui.tools.e(this.mController.uMN);
        this.kgw = ((ImageView)findViewById(i.f.gallery_bg));
        this.kgw.setLayerType(2, null);
        this.ofU = ((TextView)findViewById(i.f.tips_tv));
        this.pdf = ((MMPinProgressBtn)findViewById(i.f.sight_downloading_pb));
        this.oge = ((ViewGroup)findViewById(i.f.video_container));
        this.iuC = com.tencent.mm.pluginsdk.ui.tools.o.fb(this.mController.uMN);
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.kfj = ((TextView)findViewById(i.f.show_ad_sight));
        this.oge.addView((View)this.iuC, 0, paramBundle);
        this.pde = ((TextView)findViewById(i.f.time_counter_tv));
        this.pde.setText("");
        if (!this.omL) {
          this.pde.setVisibility(8);
        }
        if (!this.omL) {
          break label1299;
        }
        if (this.bZK != null) {
          break label975;
        }
        this.kfj.setVisibility(8);
        label671:
        com.tencent.mm.pluginsdk.ui.tools.n.a(this.kfj, (VideoSightView)this.iuC);
        label685:
        this.iuC.setVideoCallback(new SnsSightPlayerUI.9(this));
        findViewById(i.f.video_container).setOnClickListener(new SnsSightPlayerUI.10(this));
        ((View)this.iuC).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            SnsSightPlayerUI.this.aBR();
          }
        });
        this.gEU = new GestureDetector(this.mController.uMN, new SnsSightPlayerUI.12(this));
        ((View)this.iuC).setOnTouchListener(new SnsSightPlayerUI.13(this));
        if (!com.tencent.mm.vfs.e.bK(this.erh)) {
          break label1311;
        }
        if (this.erh != null)
        {
          this.iuC.stop();
          this.iuC.setVideoPath(this.erh);
        }
        this.pdf.setVisibility(8);
      }
    }
    for (this.pdc.olp = 1;; this.pdc.olp = 0)
    {
      y.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new si();
      paramBundle.cbT.type = 1;
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.j(this.mController.uMN);
      }
      this.contextMenuHelper.a((View)this.iuC, this.pdj, this.ifj);
      ((View)this.iuC).post(new SnsSightPlayerUI.14(this));
      return;
      paramBundle = this.oUH.bGb();
      break;
      paramBundle = null;
      break;
      label975:
      if (bk.bl(this.bZK.trW))
      {
        y.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.oUH.bGe();
        Object localObject2 = this.oUH.bFZ();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).oAO;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).oAP;
        if ((!bk.bl((String)localObject1)) && (!bk.bl((String)localObject2)))
        {
          this.kfj.setVisibility(0);
          this.kfj.setText((CharSequence)localObject1);
          this.kfj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              Object localObject;
              String str;
              if (j.b.olY.value != 0)
              {
                localObject = j.a.olS;
                str = paramBundle.lsK;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label176;
                }
              }
              label176:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).ovV)
              {
                com.tencent.mm.plugin.sns.a.b.j.a((j.a)localObject, str, paramAnonymousView, 1, j.b.olY.value, paramBundle.hPY, null, paramBundle.lsK, 0L, 0, 0);
                paramAnonymousView = new Intent();
                localObject = new Bundle();
                ((Bundle)localObject).putString("key_snsad_statextstr", paramBundle.oPO);
                paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
                paramAnonymousView.putExtra("rawUrl", this.kft);
                paramAnonymousView.putExtra("useJs", true);
                i.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new ah(Looper.getMainLooper()).post(new SnsSightPlayerUI.7.1(this, paramAnonymousView));
                return;
              }
            }
          });
          break label671;
        }
        this.kfj.setVisibility(8);
        break label671;
      }
      localObject1 = getResources().getString(i.j.sns_ad_sight_full);
      paramBundle = (Bundle)localObject1;
      if (this.bZK.pkD / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(i.j.sns_ad_sight_full_m, new Object[] { Integer.valueOf(this.bZK.pkD / 60) });
      }
      localObject1 = paramBundle;
      if (this.bZK.pkD % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(i.j.sns_ad_sight_full_s, new Object[] { Integer.valueOf(this.bZK.pkD % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(i.j.sns_ad_sight_full_end);
      this.kfj.setText(paramBundle);
      this.kfj.setVisibility(0);
      this.kfj.setOnClickListener(new SnsSightPlayerUI.8(this));
      break label671;
      label1299:
      this.kfj.setVisibility(8);
      break label685;
      label1311:
      af.bDA().a(this.bZK, 6, null, az.uBK);
      this.pdf.setVisibility(0);
      this.pdf.cJO();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i;
    label47:
    int j;
    label150:
    com.tencent.mm.bv.b localb1;
    label179:
    com.tencent.mm.bv.b localb2;
    if (this.omL)
    {
      if (this.oUH != null) {
        break label477;
      }
      localObject = "";
      if (this.oUH != null)
      {
        String str = this.pdc.bCf();
        if (this.oUH != null) {
          break label489;
        }
        i = 0;
        long l2 = this.pdc.olq - this.pdc.eAG;
        long l1 = l2;
        if (l2 < 0L)
        {
          y.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.pdc.olq), Long.valueOf(this.pdc.eAG) });
          l1 = this.pdc.olq;
        }
        int k = (int)l1;
        com.tencent.mm.kernel.g.DQ();
        p localp = com.tencent.mm.kernel.g.DO().dJT;
        if (this.source != 0) {
          break label500;
        }
        j = 1;
        int m = this.pdc.olq;
        if (this.source != 2) {
          break label505;
        }
        localb1 = this.oUH.bGN().bGi();
        if (this.source != 2) {
          break label520;
        }
        localb2 = this.oUH.bGN().bGj();
        label199:
        localp.a(new com.tencent.mm.plugin.sns.a.b.d((String)localObject, j, 2, m, null, null, 2, str, -1, i, k, k, 0, localb1, localb2), 0);
      }
    }
    y.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.omL) && (this.oUH != null) && (this.oUH.yr(32))) {
      com.tencent.mm.plugin.sns.a.b.j.a(j.b.olY, j.a.olT, this.oUH, this.source);
    }
    af.bDA().b(this);
    Object localObject = com.tencent.mm.modelsns.b.i(getIntent());
    boolean bool;
    if (localObject != null)
    {
      if (!this.omL) {
        break label541;
      }
      if (bk.bl(this.bZK.trW)) {
        break label535;
      }
      bool = true;
      label329:
      ((com.tencent.mm.modelsns.b)localObject).cb(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.b)localObject).update();
      ((com.tencent.mm.modelsns.b)localObject).QX();
      if (com.tencent.mm.r.a.tu() != null) {
        com.tencent.mm.r.a.tu().vS();
      }
      if (this.iuC != null)
      {
        this.iuC.setVideoCallback(null);
        this.iuC.stop();
        this.iuC.onDetach();
      }
      if (!this.ofV)
      {
        localObject = new si();
        ((si)localObject).cbT.type = 0;
        ((si)localObject).cbT.cbU = this.ofb;
        ((si)localObject).cbT.cbV = this.hkH;
        ((si)localObject).cbT.cbW = this.cbW;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      this.gEB.bH(false);
      return;
      label477:
      localObject = this.pdg.fVM;
      break;
      label489:
      i = this.oUH.bGO();
      break label47;
      label500:
      j = 2;
      break label150;
      label505:
      localb1 = this.oUH.bGN().bGg();
      break label179;
      label520:
      localb2 = this.oUH.bGN().bGh();
      break label199;
      label535:
      bool = false;
      break label329;
      label541:
      ((com.tencent.mm.modelsns.b)localObject).cb(false);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    y.i("MicroMsg.SnsSightPlayerUI", "onpause  " + i);
    yO(i);
    if (!this.pbk)
    {
      bFy();
      y.v("check", "onclick");
      new ah().post(new SnsSightPlayerUI.2(this));
    }
    for (;;)
    {
      if (this.pdc != null) {
        this.pdc.eAF = bk.UZ();
      }
      return;
      bFy();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.dBn)
    {
      int i = getResources().getConfiguration().orientation;
      y.i("MicroMsg.SnsSightPlayerUI", "initOrientation " + i);
      if (getResources().getConfiguration().orientation == 2) {
        aa(getResources().getConfiguration().orientation, true);
      }
      this.dBn = true;
    }
    if ((this.ogn == 0) || (this.ogm == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.ogn = localDisplayMetrics.heightPixels;
      this.ogm = localDisplayMetrics.widthPixels;
    }
    if ((this.pbk) && (com.tencent.mm.vfs.e.bK(this.erh)))
    {
      iP(false);
      this.pbk = false;
    }
    if (this.pdc != null) {
      this.pdc.onResume();
    }
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
          this.oge.getViewTreeObserver().addOnPreDrawListener(new SnsSightPlayerUI.3(this));
        }
      }
    }
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI
 * JD-Core Version:    0.7.0.1
 */