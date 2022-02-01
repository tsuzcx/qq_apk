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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  public dox BJa;
  protected View BLR;
  protected ImageView BLS;
  protected View BLT;
  protected ImageView BLU;
  protected i BLV;
  protected RecyclerView BLW;
  protected e BLX;
  protected d BLY;
  public RecyclerView BLZ;
  protected LinearLayoutManager BMa;
  protected e BMb;
  public d BMc;
  protected com.tencent.mm.plugin.topstory.ui.a.a BMd;
  public boolean BMe = true;
  protected int BMf = 0;
  protected long BMg = -1L;
  protected long BMh = -1L;
  private i.a BMi = new i.a()
  {
    public final void nO(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.TL(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  protected l BMj;
  public o BMk;
  private m BMl;
  public r BMm;
  protected n BMn;
  private boolean BMo;
  protected com.tencent.mm.plugin.topstory.ui.widget.d BMp;
  private boolean BMq;
  protected com.tencent.mm.plugin.topstory.ui.widget.b BMr;
  private aj BMs;
  private aj BMt;
  public boolean BMu;
  private j BMv;
  private com.tencent.mm.ak.f BMw = new com.tencent.mm.ak.f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousn;
      paramAnonymousn = (doq)localj.rr.hQD.hQJ;
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        ae.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        t.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(2131764476), 0).show();
        if (localj.BIY != null)
        {
          paramAnonymousString = localj.BIY;
          if (localj.BIY.HWv) {
            break label173;
          }
        }
        label173:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.HWv = bool;
          ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.BIY.HWv);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.eto().b(localj.BIY);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.etN();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.etO().getControlBar()).l(localj.BIY);
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
        localJSONObject.put("docId", paramAnonymousn.Hvr);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousn.gvx != 4) {
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
      if (localj.BIY != null)
      {
        paramAnonymousString = localj.BIY;
        if (paramAnonymousn.gvx != 4) {
          break label522;
        }
      }
      label516:
      label522:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.HWv = bool;
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.BIY.HWv), Integer.valueOf(localj.BIY.HWA) });
        if (paramAnonymousn.gvx != 4) {
          break label528;
        }
        h localh = TopStoryBaseVideoUI.this.eto().b(localj.BIY);
        paramAnonymousn = null;
        paramAnonymousString = paramAnonymousn;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BJb != null)
        {
          paramAnonymousString = paramAnonymousn;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BJb != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BJb.udb != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).BJb.udb.equals(localj.BIY.udb)) {
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
          TopStoryBaseVideoUI.this.a(localj.BIY, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.etO().getControlBar().show();
          }
        }
        paramAnonymousString = new jy();
        paramAnonymousString.dxW.dxX = localJSONObject.toString();
        paramAnonymousString.dxW.dxY = "";
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
        break;
        bool = false;
        break label223;
      }
      label528:
      if (localj.esG().HVy) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(2131764505), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.BIY, null, false);
        break;
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764506, 0).show();
      }
    }
  };
  protected RecyclerView.m fPN = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(126087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mu(paramAnonymousInt1);
      localb.mu(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      if ((!TopStoryBaseVideoUI.this.BMe) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126087);
        return;
      }
      TopStoryBaseVideoUI.this.etT();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(126087);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mu(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      if (!TopStoryBaseVideoUI.this.BMe)
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
        if (TopStoryBaseVideoUI.this.BMu) {
          TopStoryBaseVideoUI.this.BMc.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.BLY.b(TopStoryBaseVideoUI.this);
        }
      }
    }
  };
  private Point htn;
  protected TextView iYj;
  private boolean lkO = false;
  protected LinearLayoutManager nRC;
  private int videoHeight;
  protected ImageButton wDd;
  protected View yZr;
  
  private void etP()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lB(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void etY()
  {
    if (this.BJa.fOX) {
      this.BLS.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.BMm.BNs) {
        this.BMm.setMute(this.BJa.fOX);
      }
      return;
      this.BLS.setBackgroundResource(2131691328);
    }
  }
  
  private void etZ()
  {
    com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Pd()
  {
    return this.BJa.fOX;
  }
  
  public final void TF(int paramInt)
  {
    this.BJa.HVX = paramInt;
  }
  
  public final void TG(int paramInt)
  {
    this.BJa.HWa = paramInt;
  }
  
  protected void TL(int paramInt) {}
  
  protected void Zm()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.BJa = new dox();
    try
    {
      this.BJa.parseFrom(arrayOfByte);
      this.BMn = new n();
      this.BMn.BLm = this;
      this.BMl = new m();
      this.BMl.d(this);
      this.BMk = new o();
      this.BMk.d(this);
      this.BMm = new r();
      this.BMm.d(this);
      this.BMj = new l();
      this.BLY = etR();
      this.BMc = etS();
      this.BMd = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.BMd.ac(8, this.BJa.rfA);
      this.BMd.WY(getResources().getString(2131764472));
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
  
  public final void a(dpa paramdpa)
  {
    if (!this.BMu)
    {
      this.iYj.setText(2131762232);
      this.BLU.setVisibility(8);
    }
    if (this.BMd != null) {
      this.BMd.a(this.BJa, paramdpa);
    }
  }
  
  public final void a(dpa paramdpa, View paramView)
  {
    if (paramdpa != null)
    {
      if (!az.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
      }
    }
    else {
      return;
    }
    if (this.BMv != null) {
      com.tencent.mm.kernel.g.ajj().a(this.BMv);
    }
    String str1 = paramdpa.tFc;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramdpa.HWv)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.BJa.scene;
      String str3 = this.BJa.kid;
      if (!etp()) {
        break label238;
      }
      j = 318;
      this.BMv = new j(paramdpa, str1, i, str2, k, str3, j, paramdpa.udb, paramdpa.HWw);
      com.tencent.mm.kernel.g.ajj().a(this.BMv, 0);
      if (paramdpa.HWv) {
        break label246;
      }
      bool = true;
      label163:
      paramdpa.HWv = bool;
      if (!paramdpa.HWv) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramdpa.HWA += 1;; paramdpa.HWA -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.TB(paramdpa.HWA));
      ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramdpa.HWv);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(dpa paramdpa, View paramView, boolean paramBoolean);
  
  public void aEo(String paramString) {}
  
  public final void aEp(String paramString)
  {
    this.BJa.HVZ = paramString;
  }
  
  public final void at(final View paramView, final int paramInt)
  {
    if (this.BMm.eul())
    {
      this.BMm.cyX();
      this.BMo = true;
    }
    dpa localdpa = this.BMn.TN(paramInt);
    this.BMp = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localdpa, new d.a()
    {
      public final void e(dpa paramAnonymousdpa)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymousdpa.HWx != null) {
          TopStoryBaseVideoUI.this.au(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.BMp.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(dpa paramAnonymousdpa)
      {
        AppMethodBeat.i(126090);
        p localp = p.BNo;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.etg(), paramAnonymousdpa);
        TopStoryBaseVideoUI.this.BMp.dismiss();
        com.tencent.mm.plugin.report.e.ywz.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(dpa paramAnonymousdpa)
      {
        AppMethodBeat.i(164124);
        Object localObject = com.tencent.mm.util.c.LDf;
        if (com.tencent.mm.util.c.fSf())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bt(paramAnonymousdpa.udb, paramAnonymousdpa.HWh);
          localObject = TopStoryBaseVideoUI.this.etf() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousdpa.title + ".mp4";
          if (com.tencent.mm.vfs.o.fB("/sdcard/video/")) {
            com.tencent.mm.vfs.o.aZI("/sdcard/video/");
          }
          com.tencent.mm.vfs.o.mF((String)localObject, str);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousdpa.title, 0).show();
        }
        AppMethodBeat.o(164124);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126091);
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "more popupWindow dismiss");
        if (TopStoryBaseVideoUI.c(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.d(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
          {
            AppMethodBeat.o(126091);
            return;
          }
          TopStoryBaseVideoUI.this.BMm.edW();
          if (TopStoryBaseVideoUI.this.BMu) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.BMm.BNr.getControlBar()).bnY();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.BMu) {
      this.BMp.a(paramView, true, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.BMm.BNr.getControlBar()).bTU();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.e.ywz.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.BMp.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void au(View paramView, final int paramInt)
  {
    this.BMq = true;
    final dpa localdpa = this.BMn.TN(paramInt);
    this.BMr = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdpa, new b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.BMm.edW();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.BMu) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.BMm.BNr.getControlBar()).bnY();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
      
      public final void p(Set<alj> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.etg(), localdpa, paramAnonymousSet, TopStoryBaseVideoUI.this.BMn.euc());
        TopStoryBaseVideoUI.this.BMm.stopPlay();
        TopStoryBaseVideoUI.this.BMn.TM(paramInt);
        if (TopStoryBaseVideoUI.this.BMn.euc() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.BMu)
        {
          TopStoryBaseVideoUI.this.BMb.cl(paramInt + TopStoryBaseVideoUI.this.BMb.getHeadersCount());
          TopStoryBaseVideoUI.this.BLX.asY.notifyChanged();
          TopStoryBaseVideoUI.this.BLZ.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.BLX.cl(paramInt + TopStoryBaseVideoUI.this.BLX.getHeadersCount());
        TopStoryBaseVideoUI.this.BMb.asY.notifyChanged();
        AppMethodBeat.o(126092);
      }
    });
    if (this.BMu) {
      this.BMr.a(paramView, true, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.BMm.BNr.getControlBar()).bTU();
      return;
    }
    catch (Exception paramView) {}
    this.BMr.a(paramView, false, 0, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final MMActivity dkN()
  {
    return this;
  }
  
  protected void etQ() {}
  
  protected abstract d etR();
  
  protected abstract d etS();
  
  protected void etT()
  {
    int j = 0;
    int i;
    if (this.BMu)
    {
      this.BMc.a(this);
      this.BMf = ((LinearLayoutManager)getLayoutManager()).ko();
      i = getLayoutManager().getItemCount();
      if ((this.BMg <= 0L) || (bu.aO(this.BMg) >= 50L))
      {
        this.BMg = bu.HQ();
        if (this.BMn.BMZ == 1) {
          break label145;
        }
        if ((this.BMf < i - 1) || (this.BMn.BMY) || (bu.aO(this.BMh) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!etV()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          etU();
        }
        return;
        this.BLY.a(this);
        break;
        label145:
        if ((i - this.BMf > 3) || (this.BMn.BMY) || (bu.aO(this.BMh) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void etU()
  {
    this.BMh = bu.HQ();
  }
  
  protected final boolean etV()
  {
    return (this.BJa.scene != 36) && (!this.BJa.HWb);
  }
  
  protected abstract e etW();
  
  protected abstract e etX();
  
  public void eta() {}
  
  public void etb() {}
  
  public final l etd()
  {
    return this.BMj;
  }
  
  public final o ete()
  {
    return this.BMk;
  }
  
  public final String etf()
  {
    return com.tencent.mm.plugin.topstory.a.h.aEf(this.BJa.rfA);
  }
  
  public final dox etg()
  {
    return this.BJa;
  }
  
  public final m eth()
  {
    return this.BMl;
  }
  
  public final r eti()
  {
    return this.BMm;
  }
  
  public final Point etj()
  {
    if (this.htn == null) {
      this.htn = al.ck(this);
    }
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.htn.x), Integer.valueOf(this.htn.y) });
    return this.htn;
  }
  
  public final aj etk()
  {
    if (this.BMu) {
      return this.BMt;
    }
    return this.BMs;
  }
  
  public final int etl()
  {
    return this.BJa.HVX;
  }
  
  public final boolean etm()
  {
    return this.BJa.scene != 36;
  }
  
  public final boolean etn()
  {
    return this.BJa.scene != 326;
  }
  
  public final e eto()
  {
    if (this.BMu) {
      return this.BMb;
    }
    return this.BLX;
  }
  
  public final boolean etp()
  {
    return this.BJa.HVS == 100203L;
  }
  
  public final void etq()
  {
    etP();
  }
  
  public int etr()
  {
    return com.tencent.mm.plugin.topstory.ui.a.BJe;
  }
  
  public final n ets()
  {
    return this.BMn;
  }
  
  public final String ett()
  {
    if (this.BJa.HVZ == null) {
      return "";
    }
    return this.BJa.HVZ;
  }
  
  public final int etu()
  {
    return this.BJa.HWa;
  }
  
  public final void etv()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.getFootersCount();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.ety();
        paramAnonymouse.as(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.BLX);
        a(TopStoryBaseVideoUI.this.BMb);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.BMu) {
      return this.BMa;
    }
    return this.nRC;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.BMu) {
      return this.BLZ;
    }
    return this.BLW;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (etp()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = etj().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(etj().x, etj().y);
  }
  
  public void im(int paramInt1, int paramInt2)
  {
    this.BMm.ip(paramInt1, paramInt2);
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    etP();
    this.yZr = findViewById(2131305918);
    this.iYj = ((TextView)findViewById(2131305948));
    this.BLU = ((ImageView)findViewById(2131305130));
    this.BLR = findViewById(2131302622);
    this.BLS = ((ImageView)findViewById(2131302624));
    this.BLT = findViewById(2131302462);
    this.wDd = ((ImageButton)findViewById(2131297026));
    this.wDd.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
    this.wDd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        TopStoryBaseVideoUI.this.etQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126076);
      }
    });
    this.BLR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.BJa.fOX) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.sS(bool);
          paramAnonymousView.etb();
          paramAnonymousView.eta();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.BLR.setVisibility(8);
    this.BLW = ((RecyclerView)findViewById(2131306389));
    this.BLW.a(this.fPN);
    this.BLW.setItemAnimator(new a((byte)0));
    this.nRC = new LinearLayoutManager();
    this.BLW.setLayoutManager(this.nRC);
    this.BMs = aj.e(this.nRC);
    this.BLX = etW();
    this.BLW.setAdapter(this.BLX);
    this.BLZ = ((RecyclerView)findViewById(2131300314));
    this.BLZ.a(this.fPN);
    this.BLZ.setItemAnimator(new a((byte)0));
    this.BMa = new LinearLayoutManager();
    this.BLZ.setLayoutManager(this.BMa);
    this.BMt = aj.e(this.BMa);
    this.BMb = etX();
    this.BLZ.setAdapter(this.BMb);
    this.BLZ.setVisibility(8);
    if ((!this.lkO) && (!etp()))
    {
      this.BLV = new i(getApplicationContext());
      this.BLV.enable();
      this.BLV.BMD = this.BMi;
      this.lkO = true;
    }
    if (this.BJa.fOX) {
      sS(this.BJa.fOX);
    }
    this.BMj.BMP = this;
    this.BLT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126083);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        TopStoryBaseVideoUI.a(TopStoryBaseVideoUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126083);
      }
    });
  }
  
  public final boolean isFullscreenMode()
  {
    return this.BMu;
  }
  
  public void n(final List<dpa> paramList, final boolean paramBoolean)
  {
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.BMu)
        {
          TopStoryBaseVideoUI.this.BMb.o(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.BLX.asY.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.BLX.o(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.BMb.asY.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public void onBackPressed()
  {
    etQ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Zm();
    initContentView();
    com.tencent.mm.kernel.g.ajj().a(2802, this.BMw);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.BJa, getActivityBrowseTimeMs(), this.BMn.TN(this.BJa.HVX));
    if (this.lkO)
    {
      this.BLV.disable();
      this.BLV.BMD = null;
      this.BLV = null;
    }
    if (this.BMv != null) {
      com.tencent.mm.kernel.g.ajj().a(this.BMv);
    }
    com.tencent.mm.kernel.g.ajj().b(2802, this.BMw);
    this.BMn.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.BJa);
    this.BMm.onUIDestroy();
    this.BMj.onUIDestroy();
    this.BMk.onUIDestroy();
    this.BMl.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.md(16);
    if (this.BMd != null) {
      this.BMd.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dox localdox = this.BJa;
      if (getSystemVolume() <= 1)
      {
        localdox.fOX = bool;
        etY();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.BJa.fOX = false;
        etY();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.BMm.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.md(15);
      if (this.BMd != null) {
        this.BMd.bhk();
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
    etP();
    etY();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.BMm.onUIResume();
    this.BMj.yPh = l.efW();
    com.tencent.mm.plugin.websearch.api.a.a.md(14);
    if (this.BMd != null) {
      this.BMd.bhj();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sR(boolean paramBoolean)
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BMe = paramBoolean;
  }
  
  public final void sS(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.BJa.fOX = true;
    }
    for (;;)
    {
      etY();
      return;
      this.BJa.fOX = false;
      if (getSystemVolume() == 0) {
        etZ();
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
      TopStoryBaseVideoUI.this.etT();
      TopStoryBaseVideoUI.this.BLY.b(TopStoryBaseVideoUI.this);
      ae.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramw.lN()) });
      AppMethodBeat.o(126094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */