package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
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
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.aj;
import android.support.v7.widget.v;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TopStoryBaseVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, b
{
  protected RecyclerView.m frd = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(126087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramAnonymousRecyclerView);
      localb.lT(paramAnonymousInt1);
      localb.lT(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      if ((!TopStoryBaseVideoUI.this.yPe) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126087);
        return;
      }
      TopStoryBaseVideoUI.this.dPv();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(126087);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramAnonymousRecyclerView);
      localb.lT(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      if (!TopStoryBaseVideoUI.this.yPe)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(126086);
        return;
      }
      switch (paramAnonymousInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(126086);
        return;
        if (TopStoryBaseVideoUI.this.yPu) {
          TopStoryBaseVideoUI.this.yPc.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.yOY.b(TopStoryBaseVideoUI.this);
        }
      }
    }
  };
  private Point gxV;
  protected TextView ica;
  private boolean kjm = false;
  protected LinearLayoutManager mJn;
  protected ImageButton tZh;
  private int videoHeight;
  protected View wjg;
  public dcy yLX;
  protected View yOR;
  protected ImageView yOS;
  protected View yOT;
  protected ImageView yOU;
  protected i yOV;
  protected RecyclerView yOW;
  protected e yOX;
  protected d yOY;
  public RecyclerView yOZ;
  protected LinearLayoutManager yPa;
  protected e yPb;
  public d yPc;
  protected com.tencent.mm.plugin.topstory.ui.a.a yPd;
  public boolean yPe = true;
  protected int yPf = 0;
  protected long yPg = -1L;
  protected long yPh = -1L;
  private i.a yPi = new i.a()
  {
    public final void wy(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.Po(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  protected l yPj;
  public o yPk;
  private m yPl;
  public r yPm;
  protected n yPn;
  private boolean yPo;
  protected com.tencent.mm.plugin.topstory.ui.widget.d yPp;
  private boolean yPq;
  protected com.tencent.mm.plugin.topstory.ui.widget.b yPr;
  private aj yPs;
  private aj yPt;
  public boolean yPu;
  private j yPv;
  private com.tencent.mm.al.g yPw = new com.tencent.mm.al.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousn;
      paramAnonymousn = (dcr)localj.rr.gUS.gUX;
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        ad.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        t.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(2131764476), 0).show();
        if (localj.yLU != null)
        {
          paramAnonymousString = localj.yLU;
          if (localj.yLU.Evb) {
            break label173;
          }
        }
        label173:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.Evb = bool;
          ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.yLU.Evb);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.dOP().b(localj.yLU);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.dPo();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.dPp().getControlBar()).l(localj.yLU);
                }
              }
              AppMethodBeat.o(126078);
            }
          });
          AppMethodBeat.o(126079);
          return;
        }
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("docId", paramAnonymousn.DUZ);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousn.fVE != 4) {
          break label516;
        }
        bool = true;
        label223:
        localJSONObject.put("isLike", bool);
      }
      catch (JSONException paramAnonymousString)
      {
        label233:
        break label233;
      }
      if (localj.yLU != null)
      {
        paramAnonymousString = localj.yLU;
        if (paramAnonymousn.fVE != 4) {
          break label522;
        }
      }
      label516:
      label522:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.Evb = bool;
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.yLU.Evb), Integer.valueOf(localj.yLU.Evg) });
        if (paramAnonymousn.fVE != 4) {
          break label528;
        }
        h localh = TopStoryBaseVideoUI.this.dOP().b(localj.yLU);
        paramAnonymousn = null;
        paramAnonymousString = paramAnonymousn;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).yLY != null)
        {
          paramAnonymousString = paramAnonymousn;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).yLY != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).yLY.rNP != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).yLY.rNP.equals(localj.yLU.rNP)) {
                if (!(localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  paramAnonymousString = paramAnonymousn;
                  if (!(localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {}
                }
                else
                {
                  paramAnonymousString = localh.getWowView();
                }
              }
            }
          }
        }
        if (paramAnonymousString != null)
        {
          TopStoryBaseVideoUI.this.a(localj.yLU, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.dPp().getControlBar().show();
          }
        }
        paramAnonymousString = new ji();
        paramAnonymousString.dnw.dnx = localJSONObject.toString();
        paramAnonymousString.dnw.dny = "";
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
        break;
        bool = false;
        break label223;
      }
      label528:
      if (localj.dOh().Eue) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(2131764505), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.yLU, null, false);
        break;
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764506, 0).show();
      }
    }
  };
  
  private void dPA()
  {
    if (this.yLX.fqj) {
      this.yOS.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.yPm.yQs) {
        this.yPm.setMute(this.yLX.fqj);
      }
      return;
      this.yOS.setBackgroundResource(2131691328);
    }
  }
  
  private void dPB()
  {
    com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
  }
  
  private void dPq()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lg(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Ny()
  {
    return this.yLX.fqj;
  }
  
  public final void Pi(int paramInt)
  {
    this.yLX.EuD = paramInt;
  }
  
  public final void Pj(int paramInt)
  {
    this.yLX.EuG = paramInt;
  }
  
  protected void Po(int paramInt) {}
  
  protected void VL()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.yLX = new dcy();
    try
    {
      this.yLX.parseFrom(arrayOfByte);
      this.yPn = new n();
      this.yPn.yOm = this;
      this.yPl = new m();
      this.yPl.d(this);
      this.yPk = new o();
      this.yPk.d(this);
      this.yPm = new r();
      this.yPm.d(this);
      this.yPj = new l();
      this.yOY = dPt();
      this.yPc = dPu();
      this.yPd = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.yPd.Z(8, this.yLX.qwV);
      this.yPd.OE(getResources().getString(2131764472));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        finish();
      }
    }
  }
  
  public final void a(ddb paramddb)
  {
    if (!this.yPu)
    {
      this.ica.setText(2131762232);
      this.yOU.setVisibility(8);
    }
    if (this.yPd != null) {
      this.yPd.a(this.yLX, paramddb);
    }
  }
  
  public final void a(ddb paramddb, View paramView)
  {
    if (paramddb != null)
    {
      if (!ay.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
      }
    }
    else {
      return;
    }
    if (this.yPv != null) {
      com.tencent.mm.kernel.g.aeS().a(this.yPv);
    }
    String str1 = paramddb.roQ;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramddb.Evb)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.yLX.scene;
      String str3 = this.yLX.jko;
      if (!dOQ()) {
        break label238;
      }
      j = 318;
      this.yPv = new j(paramddb, str1, i, str2, k, str3, j, paramddb.rNP, paramddb.Evc);
      com.tencent.mm.kernel.g.aeS().a(this.yPv, 0);
      if (paramddb.Evb) {
        break label246;
      }
      bool = true;
      label163:
      paramddb.Evb = bool;
      if (!paramddb.Evb) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramddb.Evg += 1;; paramddb.Evg -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.Pe(paramddb.Evg));
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramddb.Evb);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(ddb paramddb, View paramView, boolean paramBoolean);
  
  public final void aq(final View paramView, final int paramInt)
  {
    if (this.yPm.dPO())
    {
      this.yPm.ckd();
      this.yPo = true;
    }
    ddb localddb = this.yPn.Pq(paramInt);
    this.yPp = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localddb, new d.a()
    {
      public final void e(ddb paramAnonymousddb)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymousddb.Evd != null) {
          TopStoryBaseVideoUI.this.ar(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.yPp.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(ddb paramAnonymousddb)
      {
        AppMethodBeat.i(126090);
        p localp = p.yQo;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.dOH(), paramAnonymousddb);
        TopStoryBaseVideoUI.this.yPp.dismiss();
        com.tencent.mm.plugin.report.e.vIY.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(ddb paramAnonymousddb)
      {
        AppMethodBeat.i(164124);
        if (com.tencent.mm.util.c.fgW())
        {
          String str1 = com.tencent.mm.plugin.topstory.ui.d.bn(paramAnonymousddb.rNP, paramAnonymousddb.EuN);
          str1 = TopStoryBaseVideoUI.this.dOG() + str1 + ".mp4";
          String str2 = "/sdcard/video/" + paramAnonymousddb.title + ".mp4";
          if (com.tencent.mm.vfs.i.eK("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aMF("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.lC(str1, str2);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousddb.title, 0).show();
        }
        AppMethodBeat.o(164124);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126091);
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "more popupWindow dismiss");
        if (TopStoryBaseVideoUI.c(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.d(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
          {
            AppMethodBeat.o(126091);
            return;
          }
          TopStoryBaseVideoUI.this.yPm.dzF();
          if (TopStoryBaseVideoUI.this.yPu) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.yPm.yQr.getControlBar()).bcH();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.yPu) {
      this.yPp.a(paramView, true, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.yPm.yQr.getControlBar()).bGT();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.e.vIY.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.yPp.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void ar(View paramView, final int paramInt)
  {
    this.yPq = true;
    final ddb localddb = this.yPn.Pq(paramInt);
    this.yPr = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localddb, new b.a()
    {
      public final void h(Set<ahk> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.dOH(), localddb, paramAnonymousSet, TopStoryBaseVideoUI.this.yPn.dPF());
        TopStoryBaseVideoUI.this.yPm.stopPlay();
        TopStoryBaseVideoUI.this.yPn.Pp(paramInt);
        if (TopStoryBaseVideoUI.this.yPn.dPF() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.yPu)
        {
          TopStoryBaseVideoUI.this.yPb.cm(paramInt + TopStoryBaseVideoUI.this.yPb.getHeadersCount());
          TopStoryBaseVideoUI.this.yOX.aql.notifyChanged();
          TopStoryBaseVideoUI.this.yOZ.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.yOX.cm(paramInt + TopStoryBaseVideoUI.this.yOX.getHeadersCount());
        TopStoryBaseVideoUI.this.yPb.aql.notifyChanged();
        AppMethodBeat.o(126092);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.yPm.dzF();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.yPu) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.yPm.yQr.getControlBar()).bcH();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
    });
    if (this.yPu) {
      this.yPr.a(paramView, true, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.yPm.yQr.getControlBar()).bGT();
      return;
    }
    catch (Exception paramView) {}
    this.yPr.a(paramView, false, 0, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public void asH(String paramString) {}
  
  public final void asI(String paramString)
  {
    this.yLX.EuF = paramString;
  }
  
  public final MMActivity cKW()
  {
    return this;
  }
  
  public void dOB() {}
  
  public void dOC() {}
  
  public final l dOE()
  {
    return this.yPj;
  }
  
  public final o dOF()
  {
    return this.yPk;
  }
  
  public final String dOG()
  {
    return com.tencent.mm.plugin.topstory.a.h.asy(this.yLX.qwV);
  }
  
  public final dcy dOH()
  {
    return this.yLX;
  }
  
  public final m dOI()
  {
    return this.yPl;
  }
  
  public final r dOJ()
  {
    return this.yPm;
  }
  
  public final Point dOK()
  {
    if (this.gxV == null) {
      this.gxV = ai.cf(this);
    }
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.gxV.x), Integer.valueOf(this.gxV.y) });
    return this.gxV;
  }
  
  public final aj dOL()
  {
    if (this.yPu) {
      return this.yPt;
    }
    return this.yPs;
  }
  
  public final int dOM()
  {
    return this.yLX.EuD;
  }
  
  public final boolean dON()
  {
    return this.yLX.scene != 36;
  }
  
  public final boolean dOO()
  {
    return this.yLX.scene != 326;
  }
  
  public final e dOP()
  {
    if (this.yPu) {
      return this.yPb;
    }
    return this.yOX;
  }
  
  public final boolean dOQ()
  {
    return this.yLX.Euy == 100203L;
  }
  
  public final void dOR()
  {
    dPq();
  }
  
  public int dOS()
  {
    return com.tencent.mm.plugin.topstory.ui.a.yMb;
  }
  
  public final n dOT()
  {
    return this.yPn;
  }
  
  public final String dOU()
  {
    if (this.yLX.EuF == null) {
      return "";
    }
    return this.yLX.EuF;
  }
  
  public final int dOV()
  {
    return this.yLX.EuG;
  }
  
  public final void dOW()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.getFootersCount();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.dOZ();
        paramAnonymouse.ar(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.yOX);
        a(TopStoryBaseVideoUI.this.yPb);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  protected void dPr() {}
  
  protected abstract d dPt();
  
  protected abstract d dPu();
  
  protected void dPv()
  {
    int j = 0;
    int i;
    if (this.yPu)
    {
      this.yPc.a(this);
      this.yPf = ((LinearLayoutManager)getLayoutManager()).jQ();
      i = getLayoutManager().getItemCount();
      if ((this.yPg <= 0L) || (bt.aS(this.yPg) >= 50L))
      {
        this.yPg = bt.GC();
        if (this.yPn.yPZ == 1) {
          break label145;
        }
        if ((this.yPf < i - 1) || (this.yPn.yPY) || (bt.aS(this.yPh) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!dPx()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          dPw();
        }
        return;
        this.yOY.a(this);
        break;
        label145:
        if ((i - this.yPf > 3) || (this.yPn.yPY) || (bt.aS(this.yPh) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void dPw()
  {
    this.yPh = bt.GC();
  }
  
  protected final boolean dPx()
  {
    return (this.yLX.scene != 36) && (!this.yLX.EuH);
  }
  
  protected abstract e dPy();
  
  protected abstract e dPz();
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.yPu) {
      return this.yPa;
    }
    return this.mJn;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.yPu) {
      return this.yOZ;
    }
    return this.yOW;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (dOQ()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = dOK().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(dOK().x, dOK().y);
  }
  
  public void hJ(int paramInt1, int paramInt2)
  {
    this.yPm.hM(paramInt1, paramInt2);
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100393));
    }
    dPq();
    this.wjg = findViewById(2131305918);
    this.ica = ((TextView)findViewById(2131305948));
    this.yOU = ((ImageView)findViewById(2131305130));
    this.yOR = findViewById(2131302622);
    this.yOS = ((ImageView)findViewById(2131302624));
    this.yOT = findViewById(2131302462);
    this.tZh = ((ImageButton)findViewById(2131297026));
    this.tZh.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
    this.tZh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126076);
        TopStoryBaseVideoUI.this.dPr();
        AppMethodBeat.o(126076);
      }
    });
    this.yOR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.yLX.fqj) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.rh(bool);
          paramAnonymousView.dOC();
          paramAnonymousView.dOB();
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.yOR.setVisibility(8);
    this.yOW = ((RecyclerView)findViewById(2131306389));
    this.yOW.a(this.frd);
    this.yOW.setItemAnimator(new a((byte)0));
    this.mJn = new LinearLayoutManager();
    this.yOW.setLayoutManager(this.mJn);
    this.yPs = aj.e(this.mJn);
    this.yOX = dPy();
    this.yOW.setAdapter(this.yOX);
    this.yOZ = ((RecyclerView)findViewById(2131300314));
    this.yOZ.a(this.frd);
    this.yOZ.setItemAnimator(new a((byte)0));
    this.yPa = new LinearLayoutManager();
    this.yOZ.setLayoutManager(this.yPa);
    this.yPt = aj.e(this.yPa);
    this.yPb = dPz();
    this.yOZ.setAdapter(this.yPb);
    this.yOZ.setVisibility(8);
    if ((!this.kjm) && (!dOQ()))
    {
      this.yOV = new i(getApplicationContext());
      this.yOV.enable();
      this.yOV.yPD = this.yPi;
      this.kjm = true;
    }
    if (this.yLX.fqj) {
      rh(this.yLX.fqj);
    }
    this.yPj.yPP = this;
    this.yOT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126083);
        TopStoryBaseVideoUI.a(TopStoryBaseVideoUI.this);
        AppMethodBeat.o(126083);
      }
    });
  }
  
  public final boolean isFullscreenMode()
  {
    return this.yPu;
  }
  
  public void l(final List<ddb> paramList, final boolean paramBoolean)
  {
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.yPu)
        {
          TopStoryBaseVideoUI.this.yPb.m(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.yOX.aql.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.yOX.m(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.yPb.aql.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public void onBackPressed()
  {
    dPr();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    VL();
    initContentView();
    com.tencent.mm.kernel.g.aeS().a(2802, this.yPw);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.yLX, getActivityBrowseTimeMs(), this.yPn.Pq(this.yLX.EuD));
    if (this.kjm)
    {
      this.yOV.disable();
      this.yOV.yPD = null;
      this.yOV = null;
    }
    if (this.yPv != null) {
      com.tencent.mm.kernel.g.aeS().a(this.yPv);
    }
    com.tencent.mm.kernel.g.aeS().b(2802, this.yPw);
    this.yPn.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.yLX);
    this.yPm.onUIDestroy();
    this.yPj.onUIDestroy();
    this.yPk.onUIDestroy();
    this.yPl.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.lI(16);
    if (this.yPd != null) {
      this.yPd.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dcy localdcy = this.yLX;
      if (getSystemVolume() <= 1)
      {
        localdcy.fqj = bool;
        dPA();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.yLX.fqj = false;
        dPA();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.yPm.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.lI(15);
      if (this.yPd != null) {
        this.yPd.aWa();
      }
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    dPq();
    dPA();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.yPm.onUIResume();
    this.yPj.vZZ = l.dBC();
    com.tencent.mm.plugin.websearch.api.a.a.lI(14);
    if (this.yPd != null) {
      this.yPd.aVZ();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(boolean paramBoolean)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.yPe = paramBoolean;
  }
  
  public final void rh(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.yLX.fqj = true;
    }
    for (;;)
    {
      dPA();
      return;
      this.yLX.fqj = false;
      if (getSystemVolume() == 0) {
        dPB();
      }
    }
  }
  
  final class a
    extends v
  {
    private a() {}
    
    public final void B(RecyclerView.v paramv)
    {
      AppMethodBeat.i(126094);
      super.B(paramv);
      TopStoryBaseVideoUI.this.dPv();
      TopStoryBaseVideoUI.this.yOY.b(TopStoryBaseVideoUI.this);
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.ln()) });
      AppMethodBeat.o(126094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */