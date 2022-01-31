package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.a.b.k.c;
import com.tencent.mm.plugin.sns.a.b.k.d;
import com.tencent.mm.plugin.sns.a.b.k.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, b.b
{
  private float atq;
  private float atr;
  private boolean bRB;
  private bcs cIc;
  private int cKC;
  public l contextMenuHelper;
  private int cpt;
  private String ctV;
  private int duration;
  private String eNO;
  private boolean fon;
  private com.tencent.mm.model.d idF;
  private GestureDetector idY;
  private String imagePath;
  private boolean isAnimated;
  n.d jWw;
  com.tencent.mm.ui.tools.e kip;
  Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  com.tencent.mm.pluginsdk.ui.tools.e kvG;
  private ImageView mBi;
  private VelocityTracker mVelocityTracker;
  private int mwo;
  private TextView mzS;
  private boolean mzV;
  private int qTq;
  private int qUB;
  private int qUC;
  public int qUJ;
  private TextView qUj;
  private boolean qUk;
  ViewGroup qUt;
  private com.tencent.mm.plugin.sns.storage.n rMD;
  private h rNy;
  private float rOd;
  private int rOe;
  private int rOf;
  private boolean rTX;
  private boolean rUb;
  private boolean rUc;
  private boolean rUd;
  private String rVM;
  private TextView rVN;
  private MMPinProgressBtn rVO;
  private com.tencent.mm.plugin.sns.storage.a rVP;
  private String rVQ;
  private RelativeLayout rVR;
  View.OnCreateContextMenuListener rVS;
  private boolean raZ;
  private String thumbPath;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(39269);
    this.rNy = new h("SnsSightPlayerUI");
    this.eNO = "";
    this.imagePath = "";
    this.ctV = "";
    this.rVM = "";
    this.raZ = false;
    this.kvG = null;
    this.qUj = null;
    this.rVN = null;
    this.rVO = null;
    this.cpt = 0;
    this.duration = 0;
    this.cKC = 0;
    this.qTq = 0;
    this.mwo = 0;
    this.qUk = false;
    this.rTX = false;
    this.qUB = 0;
    this.qUC = 0;
    this.bRB = false;
    this.mzV = false;
    this.rMD = null;
    this.rVP = null;
    this.cIc = null;
    this.thumbPath = "";
    this.rVQ = "";
    this.mzS = null;
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.rOd = 1.0F;
    this.rOe = 0;
    this.rOf = 0;
    this.fon = false;
    this.rVS = new SnsSightPlayerUI.5(this);
    this.jWw = new SnsSightPlayerUI.6(this);
    this.qUJ = 0;
    AppMethodBeat.o(39269);
  }
  
  private void EW(int paramInt)
  {
    AppMethodBeat.i(39284);
    if (!this.raZ)
    {
      AppMethodBeat.o(39284);
      return;
    }
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (this.kvG.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.kvG.getDuration();
      }
      this.rNy.Dx(this.duration);
      this.rNy.qZJ.raN = bo.yB();
      locala = this.rNy.qZJ;
      if (paramInt != 2) {
        break label154;
      }
    }
    label154:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.raM = paramInt;
      this.rNy.qZJ.raL = 2;
      ab.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.rNy.qZJ.raM);
      AppMethodBeat.o(39284);
      return;
    }
  }
  
  private void ai(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(39283);
    if ((this.qUC == 0) || (this.qUB == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.qUC = ((DisplayMetrics)localObject).heightPixels;
      this.qUB = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.qUt.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rVN.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.qUB;
      localLayoutParams1.height = ((int)(this.qUB * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.qUt.getId());
      findViewById(2131823916).setVisibility(0);
    }
    for (;;)
    {
      ab.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.kvG).setLayoutParams(localLayoutParams1);
      if ((this.kvG instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.kvG).ft(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.qUj.setLayoutParams(localLayoutParams);
      this.qUt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.kvG).requestLayout();
      if (!paramBoolean) {
        EW(paramInt);
      }
      AppMethodBeat.o(39283);
      return;
      localLayoutParams1.height = this.qUB;
      localLayoutParams1.width = ((int)(this.qUB * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.qUt.getId());
      findViewById(2131823916).setVisibility(8);
    }
  }
  
  private void crn()
  {
    AppMethodBeat.i(39273);
    ab.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.kvG.pause();
    this.kvG.onDetach();
    this.idF.cJ(false);
    AppMethodBeat.o(39273);
  }
  
  private void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(39272);
    this.kvG.start();
    this.duration = this.kvG.getDuration();
    ab.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.idF.a(this);
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (paramBoolean)
    {
      locala = this.rNy.qZJ;
      if (getResources().getConfiguration().orientation != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.raM = i;
      this.rNy.qZJ.raN = bo.yB();
      this.rNy.qZJ.raL = 2;
      AppMethodBeat.o(39272);
      return;
    }
  }
  
  public final void ZU(String paramString) {}
  
  public final void bdV()
  {
    AppMethodBeat.i(39278);
    int k = this.qUt.getWidth();
    int j = this.qUt.getHeight();
    int i = j;
    if (this.kuI != 0)
    {
      i = j;
      if (this.kuJ != 0) {
        i = (int)(k / this.kuI * this.kuJ);
      }
    }
    this.kip.hO(k, i);
    this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
    if (this.rOd != 1.0D)
    {
      int m = af.fx(getContext());
      this.kip.AuR = (1.0F / this.rOd);
      if ((this.rOe != 0) || (this.rOf != 0))
      {
        j = (int)(this.qUt.getWidth() / 2 * (1.0F - this.rOd));
        k = this.rOe;
        i = (int)((m + this.qUt.getHeight()) / 2 - i / 2 * this.rOd + this.rOf);
        this.kip.hQ(j + k, i);
      }
    }
    this.kip.a(this.qUt, this.mBi, new SnsSightPlayerUI.4(this), null);
    AppMethodBeat.o(39278);
  }
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39281);
    ab.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.raZ) && (!bo.isNullOrNil(paramString)) && (this.cIc != null) && (paramString.equals(this.cIc.Id)) && (com.tencent.mm.vfs.e.cN(this.eNO)))
    {
      this.rNy.qZB = 1;
      this.kvG.setVideoPath(this.eNO);
      kT(true);
      if (this.rVO != null) {
        this.rVO.setVisibility(8);
      }
    }
    AppMethodBeat.o(39281);
  }
  
  public final void cnV() {}
  
  public void finish()
  {
    AppMethodBeat.i(39271);
    if (!this.fon)
    {
      super.finish();
      this.fon = true;
    }
    AppMethodBeat.o(39271);
  }
  
  public int getForceOrientation()
  {
    return 7;
  }
  
  public int getLayoutId()
  {
    return 2130970862;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39280);
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bo.P(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        cii localcii;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label806;
          }
          str2 = (String)localIterator.next();
          if (this.cpt == 0)
          {
            localObject1 = ag.cpf().abv(this.ctV);
            if (localObject1 != null)
            {
              if (!t.lA(str2)) {
                break;
              }
              localObject2 = new rp();
              ((rp)localObject2).cHV.czw = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
              ((rp)localObject2).cHV.crk = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csH();
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.rMD.csh();
          if (!this.raZ) {
            break label681;
          }
          localObject3 = this.rMD.csb();
          localcii = new cii();
          localcii.wUJ = this.cIc.sdf;
          localcii.fiO = this.cIc.xrZ;
          if (((TimeLineObject)localObject2).xTS.wNZ != 15) {
            break label628;
          }
          localcii.fiU = this.rVP.cFe;
          localcii.fiV = ((TimeLineObject)localObject2).Id;
          if (!bo.isNullOrNil(this.cIc.xsd)) {
            break label657;
          }
          localObject1 = ((TimeLineObject)localObject2).xTP;
          localcii.fiQ = ((String)localObject1);
          if (!bo.isNullOrNil(this.cIc.xsc)) {
            break label669;
          }
          localObject1 = this.cIc.xrS;
          localcii.fiT = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).rpX == 0))
          {
            localcii.fiS = ((com.tencent.mm.plugin.sns.storage.b)localObject3).rpZ;
            localcii.fiR = ((com.tencent.mm.plugin.sns.storage.b)localObject3).rpY;
          }
          if (localObject3 != null) {
            localcii.fiS = ((com.tencent.mm.plugin.sns.storage.b)localObject3).rpk;
          }
          i = i.ZO(this.eNO);
          ab.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.eNO, this.imagePath, this.cIc.xrZ, Integer.valueOf(this.cIc.sdf), localcii.fiT, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this, str2, this.eNO, this.imagePath, 43, i, localcii, ((TimeLineObject)localObject2).rHA);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
        } while (!this.raZ);
        label265:
        label294:
        label460:
        i.a(new SnsAdClick(this.cpt, 5, this.rMD.field_snsId, 12, 0));
        boolean bool = t.lA(str2);
        Object localObject2 = k.d.rax;
        if (bool)
        {
          localObject1 = k.c.rau;
          label542:
          localObject3 = k.e.raE;
          if (!bool) {
            break label768;
          }
        }
        label768:
        for (int i = com.tencent.mm.model.n.nv(str2);; i = 0)
        {
          k.a((k.d)localObject2, (k.c)localObject1, (k.e)localObject3, i, this.rMD, this.cpt);
          break;
          localObject2 = new rq();
          ((rq)localObject2).cHW.czw = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
          ((rq)localObject2).cHW.crk = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csH();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          break label152;
          label628:
          localcii.fiU = ((TimeLineObject)localObject2).xTX.fiU;
          localcii.fiV = ((TimeLineObject)localObject2).xTX.fiV;
          break label245;
          label657:
          localObject1 = this.cIc.xsd;
          break label265;
          label669:
          localObject1 = this.cIc.xsc;
          break label294;
          label681:
          i = i.ZO(this.eNO);
          ab.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.eNO, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this, str2, this.eNO, this.imagePath, 43, i, ((TimeLineObject)localObject2).rHA);
          break label460;
          localObject1 = k.c.rat;
          break label542;
        }
      }
      if (this.raZ) {
        i.a(new SnsAdClick(this.cpt, 5, this.rMD.field_snsId, 13, 0));
      }
    }
    label806:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(39280);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39279);
    bdV();
    AppMethodBeat.o(39279);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39282);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.qUJ);
    if (this.qUJ == paramConfiguration.orientation)
    {
      AppMethodBeat.o(39282);
      return;
    }
    int i = paramConfiguration.orientation;
    ai(paramConfiguration.orientation, false);
    this.qUJ = paramConfiguration.orientation;
    AppMethodBeat.o(39282);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39270);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.cpt = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    ag.cpa().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131689763));
    }
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.kuF = paramBundle;
      this.idF = new com.tencent.mm.model.d();
      this.eNO = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.ctV = getIntent().getStringExtra("intent_localid");
      this.raZ = getIntent().getBooleanExtra("intent_isad", false);
      this.rMD = ag.cpf().abv(this.ctV);
      if (!this.raZ) {
        break label338;
      }
      if (this.rMD != null) {
        break label235;
      }
    }
    label235:
    Object localObject1;
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label338;
      }
      finish();
      AppMethodBeat.o(39270);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      this.cIc = ((bcs)this.rMD.csh().xTS.wOa.get(0));
      paramBundle = ao.gl(ag.getAccSnsPath(), this.cIc.Id);
      localObject1 = i.k(this.cIc);
      this.rVQ = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + i.e(this.cIc));
    }
    label338:
    if (com.tencent.mm.r.a.BY() != null) {
      com.tencent.mm.r.a.BY().Ic();
    }
    if (this.rMD != null) {
      if (this.cpt == 2)
      {
        paramBundle = this.rMD.cse();
        this.rVP = paramBundle;
        this.rNy.qZD = bo.yB();
        this.rVR = ((RelativeLayout)findViewById(2131821354));
        this.rVR.setOnTouchListener(new SnsSightPlayerUI.1(this));
        ab.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.Mk() + " initView: fullpath:" + this.eNO + ", imagepath:" + this.imagePath);
        this.kip = new com.tencent.mm.ui.tools.e(getContext());
        this.mBi = ((ImageView)findViewById(2131822135));
        this.mBi.setLayerType(2, null);
        this.qUj = ((TextView)findViewById(2131823916));
        this.rVO = ((MMPinProgressBtn)findViewById(2131827771));
        this.qUt = ((ViewGroup)findViewById(2131824108));
        this.kvG = q.ga(getContext());
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.mzS = ((TextView)findViewById(2131827797));
        this.qUt.addView((View)this.kvG, 0, paramBundle);
        this.rVN = ((TextView)findViewById(2131828081));
        this.rVN.setText("");
        if (!this.raZ) {
          this.rVN.setVisibility(8);
        }
        if (!this.raZ) {
          break label1286;
        }
        if (this.cIc != null) {
          break label963;
        }
        this.mzS.setVisibility(8);
        label660:
        com.tencent.mm.pluginsdk.ui.tools.p.a(this.mzS, (VideoSightView)this.kvG);
        label674:
        this.kvG.setVideoCallback(new SnsSightPlayerUI.9(this));
        findViewById(2131824108).setOnClickListener(new SnsSightPlayerUI.10(this));
        ((View)this.kvG).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(39264);
            SnsSightPlayerUI.this.bdV();
            AppMethodBeat.o(39264);
          }
        });
        this.idY = new GestureDetector(getContext(), new SnsSightPlayerUI.12(this));
        ((View)this.kvG).setOnTouchListener(new SnsSightPlayerUI.13(this));
        if (!com.tencent.mm.vfs.e.cN(this.eNO)) {
          break label1298;
        }
        if (this.eNO != null)
        {
          this.kvG.stop();
          this.kvG.setVideoPath(this.eNO);
        }
        this.rVO.setVisibility(8);
      }
    }
    for (this.rNy.qZB = 1;; this.rNy.qZB = 0)
    {
      ab.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new ua();
      paramBundle.cKz.type = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new l(getContext());
      }
      this.contextMenuHelper.a((View)this.kvG, this.rVS, this.jWw);
      ((View)this.kvG).post(new SnsSightPlayerUI.14(this));
      AppMethodBeat.o(39270);
      return;
      paramBundle = this.rMD.csd();
      break;
      paramBundle = null;
      break;
      label963:
      if (bo.isNullOrNil(this.cIc.xrZ))
      {
        ab.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.rMD.csh();
        Object localObject2 = this.rMD.csb();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).rpY;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).rpZ;
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject2)))
        {
          this.mzS.setVisibility(0);
          this.mzS.setText((CharSequence)localObject1);
          this.mzS.setOnClickListener(new SnsSightPlayerUI.7(this, paramBundle, (String)localObject2));
          break label660;
        }
        this.mzS.setVisibility(8);
        break label660;
      }
      localObject1 = getResources().getString(2131303756);
      paramBundle = (Bundle)localObject1;
      if (this.cIc.sdf / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131303758, new Object[] { Integer.valueOf(this.cIc.sdf / 60) });
      }
      localObject1 = paramBundle;
      if (this.cIc.sdf % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131303759, new Object[] { Integer.valueOf(this.cIc.sdf % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131303757);
      this.mzS.setText(paramBundle);
      this.mzS.setVisibility(0);
      this.mzS.setOnClickListener(new SnsSightPlayerUI.8(this));
      break label660;
      label1286:
      this.mzS.setVisibility(8);
      break label674;
      label1298:
      ag.cpa().a(this.cIc, 6, null, az.yNU);
      this.rVO.setVisibility(0);
      this.rVO.dOF();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39274);
    super.onDestroy();
    int i;
    label53:
    int j;
    label155:
    com.tencent.mm.bv.b localb1;
    label184:
    com.tencent.mm.bv.b localb2;
    if (this.raZ)
    {
      if (this.rMD != null) {
        break label487;
      }
      localObject = "";
      if (this.rMD != null)
      {
        String str = this.rNy.cnF();
        if (this.rMD != null) {
          break label499;
        }
        i = 0;
        long l2 = this.rNy.qZC - this.rNy.fQy;
        long l1 = l2;
        if (l2 < 0L)
        {
          ab.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.rNy.qZC), Long.valueOf(this.rNy.fQy) });
          l1 = this.rNy.qZC;
        }
        int k = (int)l1;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.ai.p localp = com.tencent.mm.kernel.g.RK().eHt;
        if (this.cpt != 0) {
          break label510;
        }
        j = 1;
        int m = this.rNy.qZC;
        if (this.cpt != 2) {
          break label515;
        }
        localb1 = this.rMD.csQ().csl();
        if (this.cpt != 2) {
          break label530;
        }
        localb2 = this.rMD.csQ().csm();
        label204:
        localp.a(new com.tencent.mm.plugin.sns.a.b.d((String)localObject, j, 2, m, null, null, 2, str, -1, i, k, k, 0, localb1, localb2), 0);
      }
    }
    ab.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.raZ) && (this.rMD != null) && (this.rMD.Ex(32))) {
      k.a(k.b.ram, k.a.rah, this.rMD, this.cpt);
    }
    ag.cpa().b(this);
    Object localObject = com.tencent.mm.modelsns.b.w(getIntent());
    boolean bool;
    if (localObject != null)
    {
      if (!this.raZ) {
        break label551;
      }
      if (bo.isNullOrNil(this.cIc.xrZ)) {
        break label545;
      }
      bool = true;
      label333:
      ((com.tencent.mm.modelsns.b)localObject).de(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.b)localObject).update();
      ((com.tencent.mm.modelsns.b)localObject).ake();
      if (com.tencent.mm.r.a.BY() != null) {
        com.tencent.mm.r.a.BY().Ib();
      }
      if (this.kvG != null)
      {
        this.kvG.setVideoCallback(null);
        this.kvG.stop();
        this.kvG.onDetach();
      }
      if (!this.qUk)
      {
        localObject = new ua();
        ((ua)localObject).cKz.type = 0;
        ((ua)localObject).cKz.cKA = this.qTq;
        ((ua)localObject).cKz.cKB = this.mwo;
        ((ua)localObject).cKz.cKC = this.cKC;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      this.idF.cJ(false);
      AppMethodBeat.o(39274);
      return;
      label487:
      localObject = this.rVP.hpq;
      break;
      label499:
      i = this.rMD.csR();
      break label53;
      label510:
      j = 2;
      break label155;
      label515:
      localb1 = this.rMD.csQ().csj();
      break label184;
      label530:
      localb2 = this.rMD.csQ().csk();
      break label204;
      label545:
      bool = false;
      break label333;
      label551:
      ((com.tencent.mm.modelsns.b)localObject).de(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39277);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ab.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    EW(i);
    if (!this.rTX)
    {
      crn();
      ab.v("check", "onclick");
      new ak().post(new SnsSightPlayerUI.2(this));
    }
    for (;;)
    {
      if (this.rNy != null) {
        this.rNy.fQx = bo.yB();
      }
      AppMethodBeat.o(39277);
      return;
      crn();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39276);
    super.onResume();
    if (!this.bRB)
    {
      ab.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        ai(getResources().getConfiguration().orientation, true);
      }
      this.bRB = true;
    }
    if ((this.qUC == 0) || (this.qUB == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.qUC = localDisplayMetrics.heightPixels;
      this.qUB = localDisplayMetrics.widthPixels;
    }
    if ((this.rTX) && (com.tencent.mm.vfs.e.cN(this.eNO)))
    {
      kT(false);
      this.rTX = false;
    }
    if (this.rNy != null) {
      this.rNy.onResume();
    }
    AppMethodBeat.o(39276);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(39275);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
        this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
        this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
        this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
        this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
        if (localBundle == null) {
          this.qUt.getViewTreeObserver().addOnPreDrawListener(new SnsSightPlayerUI.3(this));
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(39275);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI
 * JD-Core Version:    0.7.0.1
 */