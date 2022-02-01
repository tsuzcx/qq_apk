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
import com.tencent.mm.g.a.jp;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
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
  protected View AcI;
  protected ImageView AcJ;
  protected View AcK;
  protected ImageView AcL;
  protected i AcM;
  protected RecyclerView AcN;
  protected e AcO;
  protected d AcP;
  public RecyclerView AcQ;
  protected LinearLayoutManager AcR;
  protected e AcS;
  public d AcT;
  protected com.tencent.mm.plugin.topstory.ui.a.a AcU;
  public boolean AcV = true;
  protected int AcW = 0;
  protected long AcX = -1L;
  protected long AcY = -1L;
  private i.a AcZ = new i.a()
  {
    public final void nm(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.Ru(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  protected l Ada;
  public o Adb;
  private m Adc;
  public r Add;
  protected n Ade;
  private boolean Adf;
  protected com.tencent.mm.plugin.topstory.ui.widget.d Adg;
  private boolean Adh;
  protected com.tencent.mm.plugin.topstory.ui.widget.b Adi;
  private android.support.v7.widget.aj Adj;
  private android.support.v7.widget.aj Adk;
  public boolean Adl;
  private j Adm;
  private com.tencent.mm.ak.g Adn = new com.tencent.mm.ak.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousn;
      paramAnonymousn = (die)localj.rr.hvr.hvw;
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        ac.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        t.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(2131764476), 0).show();
        if (localj.zZN != null)
        {
          paramAnonymousString = localj.zZN;
          if (localj.zZN.FSc) {
            break label173;
          }
        }
        label173:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.FSc = bool;
          ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.zZN.FSc);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.edp().b(localj.zZN);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.edO();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.edP().getControlBar()).l(localj.zZN);
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
        localJSONObject.put("docId", paramAnonymousn.FrN);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousn.fZz != 4) {
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
      if (localj.zZN != null)
      {
        paramAnonymousString = localj.zZN;
        if (paramAnonymousn.fZz != 4) {
          break label522;
        }
      }
      label516:
      label522:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.FSc = bool;
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.zZN.FSc), Integer.valueOf(localj.zZN.FSh) });
        if (paramAnonymousn.fZz != 4) {
          break label528;
        }
        h localh = TopStoryBaseVideoUI.this.edp().b(localj.zZN);
        paramAnonymousn = null;
        paramAnonymousString = paramAnonymousn;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).zZQ != null)
        {
          paramAnonymousString = paramAnonymousn;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).zZQ != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).zZQ.sVF != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).zZQ.sVF.equals(localj.zZN.sVF)) {
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
          TopStoryBaseVideoUI.this.a(localj.zZN, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.edP().getControlBar().show();
          }
        }
        paramAnonymousString = new jp();
        paramAnonymousString.dle.dlf = localJSONObject.toString();
        paramAnonymousString.dle.dlg = "";
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
        break;
        bool = false;
        break label223;
      }
      label528:
      if (localj.ecI().FRf) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(2131764505), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.zZN, null, false);
        break;
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764506, 0).show();
      }
    }
  };
  protected RecyclerView.m fuK = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(126087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramAnonymousRecyclerView);
      localb.lS(paramAnonymousInt1);
      localb.lS(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      if ((!TopStoryBaseVideoUI.this.AcV) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126087);
        return;
      }
      TopStoryBaseVideoUI.this.edU();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(126087);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramAnonymousRecyclerView);
      localb.lS(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      if (!TopStoryBaseVideoUI.this.AcV)
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
        if (TopStoryBaseVideoUI.this.Adl) {
          TopStoryBaseVideoUI.this.AcT.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.AcP.b(TopStoryBaseVideoUI.this);
        }
      }
    }
  };
  private Point gYt;
  protected TextView iCg;
  private boolean kKD = false;
  protected LinearLayoutManager nlq;
  protected ImageButton vhZ;
  private int videoHeight;
  protected View xuw;
  public dil zZP;
  
  private void edQ()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.la(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void edZ()
  {
    if (this.zZP.ftN) {
      this.AcJ.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.Add.Aei) {
        this.Add.setMute(this.zZP.ftN);
      }
      return;
      this.AcJ.setBackgroundResource(2131691328);
    }
  }
  
  private void eea()
  {
    com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Nw()
  {
    return this.zZP.ftN;
  }
  
  public final void Ro(int paramInt)
  {
    this.zZP.FRE = paramInt;
  }
  
  public final void Rp(int paramInt)
  {
    this.zZP.FRH = paramInt;
  }
  
  protected void Ru(int paramInt) {}
  
  protected void WJ()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.zZP = new dil();
    try
    {
      this.zZP.parseFrom(arrayOfByte);
      this.Ade = new n();
      this.Ade.Acd = this;
      this.Adc = new m();
      this.Adc.d(this);
      this.Adb = new o();
      this.Adb.d(this);
      this.Add = new r();
      this.Add.d(this);
      this.Ada = new l();
      this.AcP = edS();
      this.AcT = edT();
      this.AcU = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.AcU.aa(8, this.zZP.qox);
      this.AcU.SO(getResources().getString(2131764472));
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
  
  public final void a(dio paramdio)
  {
    if (!this.Adl)
    {
      this.iCg.setText(2131762232);
      this.AcL.setVisibility(8);
    }
    if (this.AcU != null) {
      this.AcU.a(this.zZP, paramdio);
    }
  }
  
  public final void a(dio paramdio, View paramView)
  {
    if (paramdio != null)
    {
      if (!ax.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
      }
    }
    else {
      return;
    }
    if (this.Adm != null) {
      com.tencent.mm.kernel.g.agi().a(this.Adm);
    }
    String str1 = paramdio.sxK;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramdio.FSc)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.zZP.scene;
      String str3 = this.zZP.jKB;
      if (!edq()) {
        break label238;
      }
      j = 318;
      this.Adm = new j(paramdio, str1, i, str2, k, str3, j, paramdio.sVF, paramdio.FSd);
      com.tencent.mm.kernel.g.agi().a(this.Adm, 0);
      if (paramdio.FSc) {
        break label246;
      }
      bool = true;
      label163:
      paramdio.FSc = bool;
      if (!paramdio.FSc) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramdio.FSh += 1;; paramdio.FSh -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.Rk(paramdio.FSh));
      ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramdio.FSc);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(dio paramdio, View paramView, boolean paramBoolean);
  
  public final void as(final View paramView, final int paramInt)
  {
    if (this.Add.een())
    {
      this.Add.crK();
      this.Adf = true;
    }
    dio localdio = this.Ade.Rw(paramInt);
    this.Adg = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localdio, new d.a()
    {
      public final void e(dio paramAnonymousdio)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymousdio.FSe != null) {
          TopStoryBaseVideoUI.this.at(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.Adg.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(dio paramAnonymousdio)
      {
        AppMethodBeat.i(126090);
        p localp = p.Aee;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.edh(), paramAnonymousdio);
        TopStoryBaseVideoUI.this.Adg.dismiss();
        com.tencent.mm.plugin.report.e.wTc.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(dio paramAnonymousdio)
      {
        AppMethodBeat.i(164124);
        if (com.tencent.mm.util.c.fwW())
        {
          String str1 = com.tencent.mm.plugin.topstory.ui.d.bp(paramAnonymousdio.sVF, paramAnonymousdio.FRO);
          str1 = TopStoryBaseVideoUI.this.edg() + str1 + ".mp4";
          String str2 = "/sdcard/video/" + paramAnonymousdio.title + ".mp4";
          if (com.tencent.mm.vfs.i.eA("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aSh("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.lZ(str1, str2);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousdio.title, 0).show();
        }
        AppMethodBeat.o(164124);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126091);
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "more popupWindow dismiss");
        if (TopStoryBaseVideoUI.c(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.d(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
          {
            AppMethodBeat.o(126091);
            return;
          }
          TopStoryBaseVideoUI.this.Add.dOc();
          if (TopStoryBaseVideoUI.this.Adl) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.Add.Aeh.getControlBar()).bjC();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.Adl) {
      this.Adg.a(paramView, true, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.Add.Aeh.getControlBar()).bOg();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.e.wTc.f(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.Adg.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void at(View paramView, final int paramInt)
  {
    this.Adh = true;
    final dio localdio = this.Ade.Rw(paramInt);
    this.Adi = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdio, new b.a()
    {
      public final void i(Set<aij> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        t.makeText(TopStoryBaseVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.edh(), localdio, paramAnonymousSet, TopStoryBaseVideoUI.this.Ade.eee());
        TopStoryBaseVideoUI.this.Add.stopPlay();
        TopStoryBaseVideoUI.this.Ade.Rv(paramInt);
        if (TopStoryBaseVideoUI.this.Ade.eee() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.Adl)
        {
          TopStoryBaseVideoUI.this.AcS.cl(paramInt + TopStoryBaseVideoUI.this.AcS.getHeadersCount());
          TopStoryBaseVideoUI.this.AcO.arg.notifyChanged();
          TopStoryBaseVideoUI.this.AcQ.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.AcO.cl(paramInt + TopStoryBaseVideoUI.this.AcO.getHeadersCount());
        TopStoryBaseVideoUI.this.AcS.arg.notifyChanged();
        AppMethodBeat.o(126092);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.Add.dOc();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.Adl) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.Add.Aeh.getControlBar()).bjC();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
    });
    if (this.Adl) {
      this.Adi.a(paramView, true, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.Add.Aeh.getControlBar()).bOg();
      return;
    }
    catch (Exception paramView) {}
    this.Adi.a(paramView, false, 0, 0 - com.tencent.mm.cc.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public void axQ(String paramString) {}
  
  public final void axR(String paramString)
  {
    this.zZP.FRG = paramString;
  }
  
  public final MMActivity cYC()
  {
    return this;
  }
  
  protected void edR() {}
  
  protected abstract d edS();
  
  protected abstract d edT();
  
  protected void edU()
  {
    int j = 0;
    int i;
    if (this.Adl)
    {
      this.AcT.a(this);
      this.AcW = ((LinearLayoutManager)getLayoutManager()).jY();
      i = getLayoutManager().getItemCount();
      if ((this.AcX <= 0L) || (bs.aO(this.AcX) >= 50L))
      {
        this.AcX = bs.Gn();
        if (this.Ade.AdP == 1) {
          break label145;
        }
        if ((this.AcW < i - 1) || (this.Ade.rRR) || (bs.aO(this.AcY) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!edW()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          edV();
        }
        return;
        this.AcP.a(this);
        break;
        label145:
        if ((i - this.AcW > 3) || (this.Ade.rRR) || (bs.aO(this.AcY) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void edV()
  {
    this.AcY = bs.Gn();
  }
  
  protected final boolean edW()
  {
    return (this.zZP.scene != 36) && (!this.zZP.FRI);
  }
  
  protected abstract e edX();
  
  protected abstract e edY();
  
  public void edb() {}
  
  public void edc() {}
  
  public final l ede()
  {
    return this.Ada;
  }
  
  public final o edf()
  {
    return this.Adb;
  }
  
  public final String edg()
  {
    return com.tencent.mm.plugin.topstory.a.h.axH(this.zZP.qox);
  }
  
  public final dil edh()
  {
    return this.zZP;
  }
  
  public final m edi()
  {
    return this.Adc;
  }
  
  public final r edj()
  {
    return this.Add;
  }
  
  public final Point edk()
  {
    if (this.gYt == null) {
      this.gYt = com.tencent.mm.ui.aj.cl(this);
    }
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.gYt.x), Integer.valueOf(this.gYt.y) });
    return this.gYt;
  }
  
  public final android.support.v7.widget.aj edl()
  {
    if (this.Adl) {
      return this.Adk;
    }
    return this.Adj;
  }
  
  public final int edm()
  {
    return this.zZP.FRE;
  }
  
  public final boolean edn()
  {
    return this.zZP.scene != 36;
  }
  
  public final boolean edo()
  {
    return this.zZP.scene != 326;
  }
  
  public final e edp()
  {
    if (this.Adl) {
      return this.AcS;
    }
    return this.AcO;
  }
  
  public final boolean edq()
  {
    return this.zZP.FRz == 100203L;
  }
  
  public final void edr()
  {
    edQ();
  }
  
  public int eds()
  {
    return com.tencent.mm.plugin.topstory.ui.a.zZT;
  }
  
  public final n edt()
  {
    return this.Ade;
  }
  
  public final String edu()
  {
    if (this.zZP.FRG == null) {
      return "";
    }
    return this.zZP.FRG;
  }
  
  public final int edv()
  {
    return this.zZP.FRH;
  }
  
  public final void edw()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.getFootersCount();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.edz();
        paramAnonymouse.ar(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.AcO);
        a(TopStoryBaseVideoUI.this.AcS);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.Adl) {
      return this.AcR;
    }
    return this.nlq;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.Adl) {
      return this.AcQ;
    }
    return this.AcN;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (edq()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = edk().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(edk().x, edk().y);
  }
  
  public void hT(int paramInt1, int paramInt2)
  {
    this.Add.hW(paramInt1, paramInt2);
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    edQ();
    this.xuw = findViewById(2131305918);
    this.iCg = ((TextView)findViewById(2131305948));
    this.AcL = ((ImageView)findViewById(2131305130));
    this.AcI = findViewById(2131302622);
    this.AcJ = ((ImageView)findViewById(2131302624));
    this.AcK = findViewById(2131302462);
    this.vhZ = ((ImageButton)findViewById(2131297026));
    this.vhZ.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
    this.vhZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126076);
        TopStoryBaseVideoUI.this.edR();
        AppMethodBeat.o(126076);
      }
    });
    this.AcI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.zZP.ftN) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.sf(bool);
          paramAnonymousView.edc();
          paramAnonymousView.edb();
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.AcI.setVisibility(8);
    this.AcN = ((RecyclerView)findViewById(2131306389));
    this.AcN.a(this.fuK);
    this.AcN.setItemAnimator(new a((byte)0));
    this.nlq = new LinearLayoutManager();
    this.AcN.setLayoutManager(this.nlq);
    this.Adj = android.support.v7.widget.aj.e(this.nlq);
    this.AcO = edX();
    this.AcN.setAdapter(this.AcO);
    this.AcQ = ((RecyclerView)findViewById(2131300314));
    this.AcQ.a(this.fuK);
    this.AcQ.setItemAnimator(new a((byte)0));
    this.AcR = new LinearLayoutManager();
    this.AcQ.setLayoutManager(this.AcR);
    this.Adk = android.support.v7.widget.aj.e(this.AcR);
    this.AcS = edY();
    this.AcQ.setAdapter(this.AcS);
    this.AcQ.setVisibility(8);
    if ((!this.kKD) && (!edq()))
    {
      this.AcM = new i(getApplicationContext());
      this.AcM.enable();
      this.AcM.Adu = this.AcZ;
      this.kKD = true;
    }
    if (this.zZP.ftN) {
      sf(this.zZP.ftN);
    }
    this.Ada.AdG = this;
    this.AcK.setOnClickListener(new View.OnClickListener()
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
    return this.Adl;
  }
  
  public void m(final List<dio> paramList, final boolean paramBoolean)
  {
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.Adl)
        {
          TopStoryBaseVideoUI.this.AcS.n(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.AcO.arg.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.AcO.n(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.AcS.arg.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public void onBackPressed()
  {
    edR();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WJ();
    initContentView();
    com.tencent.mm.kernel.g.agi().a(2802, this.Adn);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.zZP, getActivityBrowseTimeMs(), this.Ade.Rw(this.zZP.FRE));
    if (this.kKD)
    {
      this.AcM.disable();
      this.AcM.Adu = null;
      this.AcM = null;
    }
    if (this.Adm != null) {
      com.tencent.mm.kernel.g.agi().a(this.Adm);
    }
    com.tencent.mm.kernel.g.agi().b(2802, this.Adn);
    this.Ade.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.zZP);
    this.Add.onUIDestroy();
    this.Ada.onUIDestroy();
    this.Adb.onUIDestroy();
    this.Adc.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.lA(16);
    if (this.AcU != null) {
      this.AcU.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dil localdil = this.zZP;
      if (getSystemVolume() <= 1)
      {
        localdil.ftN = bool;
        edZ();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.zZP.ftN = false;
        edZ();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.Add.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.lA(15);
      if (this.AcU != null) {
        this.AcU.bcY();
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
    edQ();
    edZ();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.Add.onUIResume();
    this.Ada.xlf = l.dPZ();
    com.tencent.mm.plugin.websearch.api.a.a.lA(14);
    if (this.AcU != null) {
      this.AcU.bcX();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void se(boolean paramBoolean)
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.AcV = paramBoolean;
  }
  
  public final void sf(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.zZP.ftN = true;
    }
    for (;;)
    {
      edZ();
      return;
      this.zZP.ftN = false;
      if (getSystemVolume() == 0) {
        eea();
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
      TopStoryBaseVideoUI.this.edU();
      TopStoryBaseVideoUI.this.AcP.b(TopStoryBaseVideoUI.this);
      ac.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramw.lv()) });
      AppMethodBeat.o(126094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */