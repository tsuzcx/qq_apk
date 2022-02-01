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
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.g.a.jx;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TopStoryBaseVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, b
{
  public doa BrB;
  protected d BuA;
  public RecyclerView BuB;
  protected LinearLayoutManager BuC;
  protected e BuD;
  public d BuE;
  protected com.tencent.mm.plugin.topstory.ui.a.a BuF;
  public boolean BuG = true;
  protected int BuH = 0;
  protected long BuI = -1L;
  protected long BuJ = -1L;
  private i.a BuK = new i.a()
  {
    public final void nL(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.Te(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  protected l BuL;
  public o BuM;
  private m BuN;
  public r BuO;
  protected n BuP;
  private boolean BuQ;
  protected com.tencent.mm.plugin.topstory.ui.widget.d BuR;
  private boolean BuS;
  protected com.tencent.mm.plugin.topstory.ui.widget.b BuT;
  private aj BuU;
  private aj BuV;
  public boolean BuW;
  private j BuX;
  private com.tencent.mm.al.f BuY = new com.tencent.mm.al.f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousn;
      paramAnonymousn = (dnt)localj.rr.hNK.hNQ;
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        ad.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        t.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(2131764476), 0).show();
        if (localj.Brz != null)
        {
          paramAnonymousString = localj.Brz;
          if (localj.Brz.HCI) {
            break label173;
          }
        }
        label173:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.HCI = bool;
          ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.Brz.HCI);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.epH().b(localj.Brz);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.eqg();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.eqh().getControlBar()).l(localj.Brz);
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
        localJSONObject.put("docId", paramAnonymousn.HbR);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousn.gsV != 4) {
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
      if (localj.Brz != null)
      {
        paramAnonymousString = localj.Brz;
        if (paramAnonymousn.gsV != 4) {
          break label522;
        }
      }
      label516:
      label522:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.HCI = bool;
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.Brz.HCI), Integer.valueOf(localj.Brz.HCN) });
        if (paramAnonymousn.gsV != 4) {
          break label528;
        }
        h localh = TopStoryBaseVideoUI.this.epH().b(localj.Brz);
        paramAnonymousn = null;
        paramAnonymousString = paramAnonymousn;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BrC != null)
        {
          paramAnonymousString = paramAnonymousn;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BrC != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BrC.tSk != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BrC.tSk.equals(localj.Brz.tSk)) {
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
          TopStoryBaseVideoUI.this.a(localj.Brz, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.eqh().getControlBar().show();
          }
        }
        paramAnonymousString = new jx();
        paramAnonymousString.dwR.dwS = localJSONObject.toString();
        paramAnonymousString.dwR.dwT = "";
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
        break;
        bool = false;
        break label223;
      }
      label528:
      if (localj.eoZ().HBL) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(2131764505), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.Brz, null, false);
        break;
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764506, 0).show();
      }
    }
  };
  protected View But;
  protected ImageView Buu;
  protected View Buv;
  protected ImageView Buw;
  protected i Bux;
  protected RecyclerView Buy;
  protected e Buz;
  protected RecyclerView.m fNG = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(126087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mr(paramAnonymousInt1);
      localb.mr(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      if ((!TopStoryBaseVideoUI.this.BuG) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126087);
        return;
      }
      TopStoryBaseVideoUI.this.eqm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(126087);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mr(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      if (!TopStoryBaseVideoUI.this.BuG)
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
        if (TopStoryBaseVideoUI.this.BuW) {
          TopStoryBaseVideoUI.this.BuE.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.BuA.b(TopStoryBaseVideoUI.this);
        }
      }
    }
  };
  private Point hqz;
  protected TextView iVq;
  private boolean lhc = false;
  protected LinearLayoutManager nLX;
  private int videoHeight;
  protected ImageButton wnu;
  protected View yJh;
  
  private void eqi()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lz(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void eqr()
  {
    if (this.BrB.fMP) {
      this.Buu.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.BuO.BvU) {
        this.BuO.setMute(this.BrB.fMP);
      }
      return;
      this.Buu.setBackgroundResource(2131691328);
    }
  }
  
  private void eqs()
  {
    com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Pf()
  {
    return this.BrB.fMP;
  }
  
  public final void SY(int paramInt)
  {
    this.BrB.HCk = paramInt;
  }
  
  public final void SZ(int paramInt)
  {
    this.BrB.HCn = paramInt;
  }
  
  protected void Te(int paramInt) {}
  
  protected void Zd()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.BrB = new doa();
    try
    {
      this.BrB.parseFrom(arrayOfByte);
      this.BuP = new n();
      this.BuP.BtO = this;
      this.BuN = new m();
      this.BuN.d(this);
      this.BuM = new o();
      this.BuM.d(this);
      this.BuO = new r();
      this.BuO.d(this);
      this.BuL = new l();
      this.BuA = eqk();
      this.BuE = eql();
      this.BuF = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.BuF.ac(8, this.BrB.qXu);
      this.BuF.Wm(getResources().getString(2131764472));
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
  
  public final void a(dod paramdod)
  {
    if (!this.BuW)
    {
      this.iVq.setText(2131762232);
      this.Buw.setVisibility(8);
    }
    if (this.BuF != null) {
      this.BuF.a(this.BrB, paramdod);
    }
  }
  
  public final void a(dod paramdod, View paramView)
  {
    if (paramdod != null)
    {
      if (!ay.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
      }
    }
    else {
      return;
    }
    if (this.BuX != null) {
      com.tencent.mm.kernel.g.aiU().a(this.BuX);
    }
    String str1 = paramdod.tul;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramdod.HCI)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.BrB.scene;
      String str3 = this.BrB.keN;
      if (!epI()) {
        break label238;
      }
      j = 318;
      this.BuX = new j(paramdod, str1, i, str2, k, str3, j, paramdod.tSk, paramdod.HCJ);
      com.tencent.mm.kernel.g.aiU().a(this.BuX, 0);
      if (paramdod.HCI) {
        break label246;
      }
      bool = true;
      label163:
      paramdod.HCI = bool;
      if (!paramdod.HCI) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramdod.HCN += 1;; paramdod.HCN -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.SU(paramdod.HCN));
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramdod.HCI);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(dod paramdod, View paramView, boolean paramBoolean);
  
  public void aCV(String paramString) {}
  
  public final void aCW(String paramString)
  {
    this.BrB.HCm = paramString;
  }
  
  public final void at(final View paramView, final int paramInt)
  {
    if (this.BuO.eqE())
    {
      this.BuO.cxw();
      this.BuQ = true;
    }
    dod localdod = this.BuP.Tg(paramInt);
    this.BuR = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localdod, new d.a()
    {
      public final void e(dod paramAnonymousdod)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymousdod.HCK != null) {
          TopStoryBaseVideoUI.this.au(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.BuR.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(dod paramAnonymousdod)
      {
        AppMethodBeat.i(126090);
        p localp = p.BvQ;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.epz(), paramAnonymousdod);
        TopStoryBaseVideoUI.this.BuR.dismiss();
        com.tencent.mm.plugin.report.e.ygI.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(dod paramAnonymousdod)
      {
        AppMethodBeat.i(164124);
        Object localObject = com.tencent.mm.util.c.LgD;
        if (com.tencent.mm.util.c.fNK())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bs(paramAnonymousdod.tSk, paramAnonymousdod.HCu);
          localObject = TopStoryBaseVideoUI.this.epy() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousdod.title + ".mp4";
          if (com.tencent.mm.vfs.i.fv("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aYg("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.mz((String)localObject, str);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousdod.title, 0).show();
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
          TopStoryBaseVideoUI.this.BuO.eaq();
          if (TopStoryBaseVideoUI.this.BuW) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.BuO.BvT.getControlBar()).bno();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.BuW) {
      this.BuR.a(paramView, true, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.BuO.BvT.getControlBar()).bSH();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.e.ygI.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.BuR.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void au(View paramView, final int paramInt)
  {
    this.BuS = true;
    final dod localdod = this.BuP.Tg(paramInt);
    this.BuT = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdod, new b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.BuO.eaq();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.BuW) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.BuO.BvT.getControlBar()).bno();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
      
      public final void p(Set<akz> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.epz(), localdod, paramAnonymousSet, TopStoryBaseVideoUI.this.BuP.eqv());
        TopStoryBaseVideoUI.this.BuO.stopPlay();
        TopStoryBaseVideoUI.this.BuP.Tf(paramInt);
        if (TopStoryBaseVideoUI.this.BuP.eqv() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.BuW)
        {
          TopStoryBaseVideoUI.this.BuD.cl(paramInt + TopStoryBaseVideoUI.this.BuD.getHeadersCount());
          TopStoryBaseVideoUI.this.Buz.asY.notifyChanged();
          TopStoryBaseVideoUI.this.BuB.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.Buz.cl(paramInt + TopStoryBaseVideoUI.this.Buz.getHeadersCount());
        TopStoryBaseVideoUI.this.BuD.asY.notifyChanged();
        AppMethodBeat.o(126092);
      }
    });
    if (this.BuW) {
      this.BuT.a(paramView, true, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.BuO.BvT.getControlBar()).bSH();
      return;
    }
    catch (Exception paramView) {}
    this.BuT.a(paramView, false, 0, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final MMActivity dhO()
  {
    return this;
  }
  
  public final m epA()
  {
    return this.BuN;
  }
  
  public final r epB()
  {
    return this.BuO;
  }
  
  public final Point epC()
  {
    if (this.hqz == null) {
      this.hqz = al.ci(this);
    }
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.hqz.x), Integer.valueOf(this.hqz.y) });
    return this.hqz;
  }
  
  public final aj epD()
  {
    if (this.BuW) {
      return this.BuV;
    }
    return this.BuU;
  }
  
  public final int epE()
  {
    return this.BrB.HCk;
  }
  
  public final boolean epF()
  {
    return this.BrB.scene != 36;
  }
  
  public final boolean epG()
  {
    return this.BrB.scene != 326;
  }
  
  public final e epH()
  {
    if (this.BuW) {
      return this.BuD;
    }
    return this.Buz;
  }
  
  public final boolean epI()
  {
    return this.BrB.HCf == 100203L;
  }
  
  public final void epJ()
  {
    eqi();
  }
  
  public int epK()
  {
    return com.tencent.mm.plugin.topstory.ui.a.BrF;
  }
  
  public final n epL()
  {
    return this.BuP;
  }
  
  public final String epM()
  {
    if (this.BrB.HCm == null) {
      return "";
    }
    return this.BrB.HCm;
  }
  
  public final int epN()
  {
    return this.BrB.HCn;
  }
  
  public final void epO()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.getFootersCount();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.epR();
        paramAnonymouse.as(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.Buz);
        a(TopStoryBaseVideoUI.this.BuD);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public void ept() {}
  
  public void epu() {}
  
  public final l epw()
  {
    return this.BuL;
  }
  
  public final o epx()
  {
    return this.BuM;
  }
  
  public final String epy()
  {
    return com.tencent.mm.plugin.topstory.a.h.aCM(this.BrB.qXu);
  }
  
  public final doa epz()
  {
    return this.BrB;
  }
  
  protected void eqj() {}
  
  protected abstract d eqk();
  
  protected abstract d eql();
  
  protected void eqm()
  {
    int j = 0;
    int i;
    if (this.BuW)
    {
      this.BuE.a(this);
      this.BuH = ((LinearLayoutManager)getLayoutManager()).ko();
      i = getLayoutManager().getItemCount();
      if ((this.BuI <= 0L) || (bt.aO(this.BuI) >= 50L))
      {
        this.BuI = bt.HI();
        if (this.BuP.BvB == 1) {
          break label145;
        }
        if ((this.BuH < i - 1) || (this.BuP.BvA) || (bt.aO(this.BuJ) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!eqo()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          eqn();
        }
        return;
        this.BuA.a(this);
        break;
        label145:
        if ((i - this.BuH > 3) || (this.BuP.BvA) || (bt.aO(this.BuJ) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void eqn()
  {
    this.BuJ = bt.HI();
  }
  
  protected final boolean eqo()
  {
    return (this.BrB.scene != 36) && (!this.BrB.HCo);
  }
  
  protected abstract e eqp();
  
  protected abstract e eqq();
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.BuW) {
      return this.BuC;
    }
    return this.nLX;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.BuW) {
      return this.BuB;
    }
    return this.Buy;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (epI()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = epC().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(epC().x, epC().y);
  }
  
  public void ij(int paramInt1, int paramInt2)
  {
    this.BuO.im(paramInt1, paramInt2);
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    eqi();
    this.yJh = findViewById(2131305918);
    this.iVq = ((TextView)findViewById(2131305948));
    this.Buw = ((ImageView)findViewById(2131305130));
    this.But = findViewById(2131302622);
    this.Buu = ((ImageView)findViewById(2131302624));
    this.Buv = findViewById(2131302462);
    this.wnu = ((ImageButton)findViewById(2131297026));
    this.wnu.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
    this.wnu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        TopStoryBaseVideoUI.this.eqj();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126076);
      }
    });
    this.But.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.BrB.fMP) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.sL(bool);
          paramAnonymousView.epu();
          paramAnonymousView.ept();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.But.setVisibility(8);
    this.Buy = ((RecyclerView)findViewById(2131306389));
    this.Buy.a(this.fNG);
    this.Buy.setItemAnimator(new a((byte)0));
    this.nLX = new LinearLayoutManager();
    this.Buy.setLayoutManager(this.nLX);
    this.BuU = aj.e(this.nLX);
    this.Buz = eqp();
    this.Buy.setAdapter(this.Buz);
    this.BuB = ((RecyclerView)findViewById(2131300314));
    this.BuB.a(this.fNG);
    this.BuB.setItemAnimator(new a((byte)0));
    this.BuC = new LinearLayoutManager();
    this.BuB.setLayoutManager(this.BuC);
    this.BuV = aj.e(this.BuC);
    this.BuD = eqq();
    this.BuB.setAdapter(this.BuD);
    this.BuB.setVisibility(8);
    if ((!this.lhc) && (!epI()))
    {
      this.Bux = new i(getApplicationContext());
      this.Bux.enable();
      this.Bux.Bvf = this.BuK;
      this.lhc = true;
    }
    if (this.BrB.fMP) {
      sL(this.BrB.fMP);
    }
    this.BuL.Bvr = this;
    this.Buv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126083);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        TopStoryBaseVideoUI.a(TopStoryBaseVideoUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126083);
      }
    });
  }
  
  public final boolean isFullscreenMode()
  {
    return this.BuW;
  }
  
  public void n(final List<dod> paramList, final boolean paramBoolean)
  {
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.BuW)
        {
          TopStoryBaseVideoUI.this.BuD.o(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.Buz.asY.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.Buz.o(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.BuD.asY.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public void onBackPressed()
  {
    eqj();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Zd();
    initContentView();
    com.tencent.mm.kernel.g.aiU().a(2802, this.BuY);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.BrB, getActivityBrowseTimeMs(), this.BuP.Tg(this.BrB.HCk));
    if (this.lhc)
    {
      this.Bux.disable();
      this.Bux.Bvf = null;
      this.Bux = null;
    }
    if (this.BuX != null) {
      com.tencent.mm.kernel.g.aiU().a(this.BuX);
    }
    com.tencent.mm.kernel.g.aiU().b(2802, this.BuY);
    this.BuP.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.BrB);
    this.BuO.onUIDestroy();
    this.BuL.onUIDestroy();
    this.BuM.onUIDestroy();
    this.BuN.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.ma(16);
    if (this.BuF != null) {
      this.BuF.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      doa localdoa = this.BrB;
      if (getSystemVolume() <= 1)
      {
        localdoa.fMP = bool;
        eqr();
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
        this.BrB.fMP = false;
        eqr();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.BuO.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.ma(15);
      if (this.BuF != null) {
        this.BuF.bgC();
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
    eqi();
    eqr();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.BuO.onUIResume();
    this.BuL.yzh = l.ecp();
    com.tencent.mm.plugin.websearch.api.a.a.ma(14);
    if (this.BuF != null) {
      this.BuF.bgB();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sK(boolean paramBoolean)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BuG = paramBoolean;
  }
  
  public final void sL(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.BrB.fMP = true;
    }
    for (;;)
    {
      eqr();
      return;
      this.BrB.fMP = false;
      if (getSystemVolume() == 0) {
        eqs();
      }
    }
  }
  
  final class a
    extends v
  {
    private a() {}
    
    public final void B(RecyclerView.w paramw)
    {
      AppMethodBeat.i(126094);
      super.B(paramw);
      TopStoryBaseVideoUI.this.eqm();
      TopStoryBaseVideoUI.this.BuA.b(TopStoryBaseVideoUI.this);
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramw.lN()) });
      AppMethodBeat.o(126094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */