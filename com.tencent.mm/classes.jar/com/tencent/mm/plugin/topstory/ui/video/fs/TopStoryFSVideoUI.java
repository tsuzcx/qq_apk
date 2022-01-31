package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.aj;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.g.a.in;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.t;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TopStoryFSVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long tkY = 0L;
  protected RecyclerView.m egc;
  protected ImageButton pbT;
  protected View qKl;
  private Point rhc;
  protected LinearLayoutManager ruI;
  protected ckw tfp;
  protected int tiE;
  protected long tiF;
  protected long tiG;
  private l tiI;
  private o tiJ;
  private com.tencent.mm.plugin.topstory.ui.video.m tiK;
  r tiL;
  n tiM;
  private boolean tiN;
  protected com.tencent.mm.plugin.topstory.ui.widget.b tiO;
  private aj tiP;
  private com.tencent.mm.ai.f tiS;
  protected View tis;
  protected ImageView tit;
  protected RecyclerView tiw;
  protected i tkM;
  protected h tkN;
  private ProgressDialog tkO;
  private View tkP;
  private View tkQ;
  private View tkR;
  private Button tkS;
  View tkT;
  com.tencent.mm.plugin.topstory.ui.widget.c tkU;
  View tkV;
  TopStoryCommentFloatDialog tkW;
  private boolean tkX;
  private int videoHeight;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(1970);
    this.egc = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(1969);
        if (paramAnonymousInt2 == 0)
        {
          AppMethodBeat.o(1969);
          return;
        }
        TopStoryFSVideoUI.this.cJS();
        AppMethodBeat.o(1969);
      }
      
      public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(1968);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(1968);
          return;
          TopStoryFSVideoUI.this.tkN.b(TopStoryFSVideoUI.this);
        }
      }
    };
    this.tiE = 0;
    this.tiF = -1L;
    this.tiG = -1L;
    this.tiS = new com.tencent.mm.ai.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
      {
        AppMethodBeat.i(1957);
        paramAnonymousm = (com.tencent.mm.plugin.topstory.a.c.i)paramAnonymousm;
        Object localObject = (cks)paramAnonymousm.rr.fsV.fta;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ab.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          t.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131304339), 0).show();
          if (paramAnonymousm.tfm != null)
          {
            paramAnonymousString = paramAnonymousm.tfm;
            if (paramAnonymousm.tfm.xVp) {
              break label175;
            }
          }
          label175:
          for (bool = true;; bool = false)
          {
            paramAnonymousString.xVp = bool;
            ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + paramAnonymousm.tfm.xVp);
            TopStoryFSVideoUI.this.runOnUiThread(new TopStoryFSVideoUI.5.1(this, paramAnonymousm));
            AppMethodBeat.o(1957);
            return;
          }
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("docId", ((cks)localObject).xHJ);
          localJSONObject.put("opType", "LIKE");
          if (((cks)localObject).nrS != 4) {
            break label468;
          }
          bool = true;
          label225:
          localJSONObject.put("isLike", bool);
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            continue;
            paramAnonymousString = null;
          }
        }
        if (paramAnonymousm.tfm != null)
        {
          paramAnonymousString = paramAnonymousm.tfm;
          if (((cks)localObject).nrS != 4) {
            break label474;
          }
        }
        label468:
        label474:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.xVp = bool;
          ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb:" + paramAnonymousm.tfm.xVp);
          if (((cks)localObject).nrS != 4) {
            break label480;
          }
          localObject = TopStoryFSVideoUI.this.cJm().b(paramAnonymousm.tfm);
          if ((TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).tjR == null) || (TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).tjR.xVa == null) || (!TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).tjR.xVa.equals(paramAnonymousm.tfm.xVa)) || (!(localObject instanceof g))) {
            break label551;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.topstory.ui.video.h)localObject).getWowView();
          if (paramAnonymousString != null)
          {
            TopStoryFSVideoUI.this.a(paramAnonymousm.tfm, paramAnonymousString, true);
            if ((localObject instanceof g)) {
              ((com.tencent.mm.plugin.topstory.ui.video.h)localObject).cJM().getControlBar().show();
            }
          }
          paramAnonymousString = new in();
          paramAnonymousString.cxU.cxV = localJSONObject.toString();
          paramAnonymousString.cxU.cxW = "";
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousString);
          break;
          bool = false;
          break label225;
        }
        label480:
        if (paramAnonymousm.cIG().xUG) {
          com.tencent.mm.ui.base.h.b(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131304365), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(paramAnonymousm.tfm, null, false);
          break;
          t.makeText(TopStoryFSVideoUI.this.getContext(), 2131304366, 0).show();
        }
      }
    };
    AppMethodBeat.o(1970);
  }
  
  private void cJN()
  {
    AppMethodBeat.i(1973);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.fw(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      AppMethodBeat.o(1973);
      return;
      localView.setSystemUiVisibility(4102);
    }
  }
  
  private boolean cJU()
  {
    return (this.tfp.scene != 36) && (!this.tfp.xUX);
  }
  
  @SuppressLint({"ResourceType"})
  private void cJX()
  {
    AppMethodBeat.i(1987);
    if (this.tfp.efg) {
      this.tit.setBackgroundResource(2131232123);
    }
    for (;;)
    {
      if (this.tiL.tjS) {
        this.tiL.setMute(this.tfp.efg);
      }
      AppMethodBeat.o(1987);
      return;
      this.tit.setBackgroundResource(2131232124);
    }
  }
  
  private void cKq()
  {
    AppMethodBeat.i(1979);
    this.tkQ.setVisibility(0);
    this.tkP.setVisibility(0);
    this.tiM.GJ(0);
    AppMethodBeat.o(1979);
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(1984);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(1984);
    return i;
  }
  
  public final boolean DP()
  {
    return this.tfp.efg;
  }
  
  public final void GA(int paramInt)
  {
    this.tfp.xUT = paramInt;
  }
  
  public final void GB(int paramInt)
  {
    this.tfp.xUW = paramInt;
  }
  
  public final boolean Gz(int paramInt)
  {
    AppMethodBeat.i(1976);
    this.tkT.setVisibility(8);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.tkM.getItemCount();
      int j = this.tkM.getFootersCount();
      int k = this.tkM.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(1976);
        return false;
      }
      this.tiw.smoothScrollToPosition(this.tkM.getHeadersCount() + paramInt);
      AppMethodBeat.o(1976);
      return true;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(1976);
    }
    return false;
  }
  
  public final void a(ccp paramccp) {}
  
  public final void a(ckx paramckx)
  {
    AppMethodBeat.i(1996);
    int i;
    int j;
    if (paramckx != null)
    {
      if (!at.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131304339), 0).show();
        AppMethodBeat.o(1996);
        return;
      }
      Object localObject = paramckx.uKI;
      if (!paramckx.xVp) {
        break label191;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.tfp.scene;
      String str2 = this.tfp.hng;
      if (!cJn()) {
        break label196;
      }
      j = 318;
      label104:
      localObject = new com.tencent.mm.plugin.topstory.a.c.i(paramckx, (String)localObject, i, str1, k, str2, j, paramckx.xVa, paramckx.xVq);
      com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      if (paramckx.xVp) {
        break label203;
      }
    }
    label191:
    label196:
    label203:
    for (boolean bool = true;; bool = false)
    {
      paramckx.xVp = bool;
      ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramckx.xVp);
      AppMethodBeat.o(1996);
      return;
      i = 4;
      break;
      j = 317;
      break label104;
    }
  }
  
  public final void a(ckx paramckx, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(1999);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramckx.xVa, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.tkT.getVisibility() == 0) && (this.tkU != null) && (this.tkU.fgl != null) && (this.tkU.fgl.equals(paramckx.xVa))) {
        this.tkT.setVisibility(8);
      }
      AppMethodBeat.o(1999);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramckx.uKI;
    String str2 = paramckx.title;
    String str3 = this.tfp.hng;
    int j = this.tfp.scene;
    if (cJn()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramckx.xVa, paramckx.xVq);
      this.tkT.setVisibility(0);
      this.tkU = new com.tencent.mm.plugin.topstory.ui.widget.c(this.tkV, new TopStoryFSVideoUI.7(this, paramckx), (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramckx.xVa);
      this.tkT.postDelayed(new TopStoryFSVideoUI.8(this), 2000L);
      this.tkU.a(paramView, true, com.tencent.mm.plugin.topstory.ui.widget.d.dip2px(this, 10.0F));
      AppMethodBeat.o(1999);
      return;
    }
  }
  
  public final void aen(String paramString)
  {
    AppMethodBeat.i(1990);
    al.d(new TopStoryFSVideoUI.4(this, paramString));
    AppMethodBeat.o(1990);
  }
  
  public final void aeo(String paramString)
  {
    this.tfp.xUV = paramString;
  }
  
  public final void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(1988);
    if (this.tiL.cKj())
    {
      this.tiL.crn();
      this.tiN = true;
    }
    ckx localckx = this.tiM.GI(paramInt);
    this.tiO = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localckx.xVk, new TopStoryFSVideoUI.2(this, localckx, paramInt));
    this.tiO.a(paramView, true, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.tiL.tjQ.getControlBar()).baj();
      AppMethodBeat.o(1988);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(1988);
    }
  }
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public final void cIZ()
  {
    AppMethodBeat.i(1974);
    this.qKl.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.tkT.setVisibility(8);
    AppMethodBeat.o(1974);
  }
  
  protected final void cJS()
  {
    int i = 1;
    AppMethodBeat.i(1972);
    this.tkN.a(this);
    this.tiE = this.ruI.iv();
    int j = this.ruI.getItemCount();
    if ((this.tiF <= 0L) || (bo.av(this.tiF) >= 50L))
    {
      this.tiF = bo.yB();
      if (this.tiM.tjv == 1) {
        break label161;
      }
      if ((this.tiE < j - 1) || (this.tiM.tju) || (bo.av(this.tiG) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!cJU()) {
        i = 0;
      }
      if (i != 0)
      {
        this.tkQ.setVisibility(0);
        this.tkP.setVisibility(0);
        this.tiM.GJ(this.tiM.cKc());
      }
      AppMethodBeat.o(1972);
      return;
      label161:
      if ((j - this.tiE > 3) || (this.tiM.tju) || (bo.av(this.tiG) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public final void cJa()
  {
    AppMethodBeat.i(1975);
    this.qKl.animate().cancel();
    this.qKl.setAlpha(1.0F);
    AppMethodBeat.o(1975);
  }
  
  public final l cJc()
  {
    return this.tiI;
  }
  
  public final o cJd()
  {
    return this.tiJ;
  }
  
  public final String cJe()
  {
    AppMethodBeat.i(1980);
    String str = com.tencent.mm.plugin.topstory.a.g.aef(this.tfp.xUt);
    AppMethodBeat.o(1980);
    return str;
  }
  
  public final ckw cJf()
  {
    return this.tfp;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.m cJg()
  {
    return this.tiK;
  }
  
  public final r cJh()
  {
    return this.tiL;
  }
  
  public final Point cJi()
  {
    AppMethodBeat.i(1983);
    if (this.rhc == null) {
      this.rhc = af.hQ(this);
    }
    Point localPoint = this.rhc;
    AppMethodBeat.o(1983);
    return localPoint;
  }
  
  public final aj cJj()
  {
    return this.tiP;
  }
  
  public final int cJk()
  {
    return this.tfp.xUT;
  }
  
  public final boolean cJl()
  {
    return this.tfp.scene != 36;
  }
  
  public final e cJm()
  {
    return this.tkM;
  }
  
  public final boolean cJn()
  {
    return this.tfp.xUO == 100203L;
  }
  
  public final void cJo()
  {
    AppMethodBeat.i(1995);
    cJN();
    AppMethodBeat.o(1995);
  }
  
  public final int cJp()
  {
    return 0;
  }
  
  public final void cJq() {}
  
  public final void cJr() {}
  
  public final n cJs()
  {
    return this.tiM;
  }
  
  public final String cJt()
  {
    if (this.tfp.xUV == null) {
      return "";
    }
    return this.tfp.xUV;
  }
  
  public final int cJu()
  {
    return this.tfp.xUW;
  }
  
  public final void cJv()
  {
    AppMethodBeat.i(1997);
    runOnUiThread(new TopStoryFSVideoUI.6(this));
    AppMethodBeat.o(1997);
  }
  
  public final int cJw()
  {
    AppMethodBeat.i(1998);
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUT, 0);
    AppMethodBeat.o(1998);
    return i;
  }
  
  public final void cKr()
  {
    AppMethodBeat.i(1986);
    if (this.tfp.efg)
    {
      this.tfp.efg = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
      }
    }
    for (;;)
    {
      cJX();
      cJa();
      cIZ();
      AppMethodBeat.o(1986);
      return;
      this.tfp.efg = true;
    }
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1994);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.tkX)) {
      cKq();
    }
    this.tiL.gi(paramInt1, paramInt2);
    AppMethodBeat.o(1994);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(1977);
    if (cJn())
    {
      AppMethodBeat.o(1977);
      return 1;
    }
    AppMethodBeat.o(1977);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2130971018;
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.ruI;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.tiw;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(1981);
    if (this.videoHeight == 0)
    {
      if (cJn()) {
        break label49;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      int i = this.videoHeight;
      AppMethodBeat.o(1981);
      return i;
      label49:
      this.videoHeight = 1280;
      i = cJi().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(1982);
    int i = Math.min(cJi().x, cJi().y);
    AppMethodBeat.o(1982);
    return i;
  }
  
  public final boolean gh(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void k(List<ckx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(1989);
    this.tkM.l(paramList, paramBoolean);
    al.p(new TopStoryFSVideoUI.3(this), 50L);
    AppMethodBeat.o(1989);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(1978);
    com.tencent.mm.plugin.topstory.ui.video.p.tjM.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.tiI.blP()) || (com.tencent.mm.plugin.topstory.a.g.cIz())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.mA(false);
      }
    }
    AppMethodBeat.o(1978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1971);
    if (Build.VERSION.SDK_INT >= 28) {
      customfixStatusbar(true);
    }
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_context");
    this.tfp = new ckw();
    try
    {
      this.tfp.parseFrom(paramBundle);
      this.tiM = new n();
      this.tiM.thM = this;
      this.tiK = new com.tencent.mm.plugin.topstory.ui.video.m();
      this.tiK.d(this);
      this.tiJ = new o();
      this.tiJ.d(this);
      this.tiL = new r();
      this.tiL.d(this);
      this.tiI = new l();
      this.tkN = new h();
      if (this.tfp.xUP != null) {
        this.tiM.e(this.tfp.xUP);
      }
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().setStatusBarColor(getResources().getColor(2131690076));
      }
      if (this.tfp.xUR) {
        this.tiI.tjk = true;
      }
      cJN();
      this.qKl = findViewById(2131828204);
      this.tis = findViewById(2131828562);
      this.tit = ((ImageView)findViewById(2131828563));
      this.pbT = ((ImageButton)findViewById(2131826460));
      this.pbT.getDrawable().setColorFilter(getResources().getColor(2131690709), PorterDuff.Mode.SRC_ATOP);
      this.pbT.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.tis.setOnClickListener(new TopStoryFSVideoUI.9(this));
      this.tis.setVisibility(8);
      this.tkR = findViewById(2131828560);
      this.tkS = ((Button)findViewById(2131828561));
      this.tiw = ((RecyclerView)findViewById(2131828559));
      this.tiw.a(this.egc);
      this.ruI = new LinearLayoutManager();
      this.tiw.setLayoutManager(this.ruI);
      this.tiP = aj.e(this.ruI);
      this.tkM = new i(this);
      paramBundle = this.tkM;
      View localView = LayoutInflater.from(this).inflate(2130971030, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.tkQ = localView.findViewById(2131828604);
      this.tkP = localView.findViewById(2131824364);
      paramBundle.eo(localView);
      this.tiw.setAdapter(this.tkM);
      this.pbT.setOnClickListener(new TopStoryFSVideoUI.10(this));
      new b().i(this.tiw);
      if (cJU()) {
        if (this.tiI.isConnected())
        {
          cKq();
          this.tkX = false;
          if ((this.tfp.scene != 21) && (this.tfp.xUQ == null)) {
            this.tkO = com.tencent.mm.ui.base.h.b(this, getString(2131301086), true, new TopStoryFSVideoUI.11(this));
          }
          this.tkM.tlc = true;
          this.tkR.setVisibility(8);
          if ((this.tiI.cJZ()) && (com.tencent.mm.plugin.topstory.a.g.cIz()) && (System.currentTimeMillis() - tkY > 86400000L))
          {
            Toast.makeText(this, 2131304344, 0).show();
            tkY = System.currentTimeMillis();
          }
          this.tkT = findViewById(2131828564);
          this.tkV = findViewById(2131828565);
          this.tkT.setVisibility(8);
          this.tkT.setOnTouchListener(new TopStoryFSVideoUI.12(this));
          this.tkW = ((TopStoryCommentFloatDialog)findViewById(2131828566));
          this.tkW.setVisibility(8);
          this.tkW.k(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new TopStoryFSVideoUI.13(this));
          if (cJn())
          {
            this.pbT.setImageResource(2131232111);
            if (af.hW(this))
            {
              int i = af.hV(this);
              paramBundle = (RelativeLayout.LayoutParams)this.qKl.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cb.a.fromDPToPix(this, 12));
              this.qKl.setLayoutParams(paramBundle);
            }
          }
          com.tencent.mm.kernel.g.Rc().a(2802, this.tiS);
          AppMethodBeat.o(1971);
          return;
        }
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        finish();
        continue;
        Toast.makeText(this, 2131302345, 1).show();
        this.tkX = true;
        continue;
        this.tkQ.setVisibility(4);
        this.tkP.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1991);
    com.tencent.mm.plugin.topstory.a.h.a(this.tfp, getActivityBrowseTimeMs(), this.tiM.GI(this.tfp.xUT));
    com.tencent.mm.kernel.g.Rc().b(2802, this.tiS);
    this.tiM.aEM();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.tfp);
    this.tiL.aEM();
    this.tiI.aEM();
    this.tiJ.aEM();
    this.tiK.aEM();
    this.tkW.ehl.close();
    com.tencent.mm.plugin.websearch.api.a.a.kS(16);
    super.onDestroy();
    AppMethodBeat.o(1991);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(1985);
    if ((paramInt == 4) && (this.tkW.getVisibility() == 0))
    {
      this.tkW.hide();
      AppMethodBeat.o(1985);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      ckw localckw = this.tfp;
      if (getSystemVolume() <= 1)
      {
        localckw.efg = bool;
        cJX();
      }
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(1985);
      return bool;
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.tfp.efg = false;
        cJX();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(1993);
    super.onPause();
    this.tiL.alo();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.tkW.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.kS(15);
    AppMethodBeat.o(1993);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(1992);
    super.onResume();
    cJN();
    cJX();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.tiL.alp();
    this.tiI.qCf = l.cvE();
    this.tkW.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.kS(14);
    AppMethodBeat.o(1992);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */