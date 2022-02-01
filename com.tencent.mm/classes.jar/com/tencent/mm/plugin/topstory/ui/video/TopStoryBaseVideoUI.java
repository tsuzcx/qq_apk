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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.vfs.s;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TopStoryBaseVideoUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.topstory.a.c, b
{
  protected ImageButton AnC;
  public eit GjJ;
  protected ImageView GmA;
  protected i GmB;
  protected RecyclerView GmC;
  protected e GmD;
  protected d GmE;
  public RecyclerView GmF;
  protected LinearLayoutManager GmG;
  protected e GmH;
  public d GmI;
  protected com.tencent.mm.plugin.topstory.ui.multitask.a GmJ;
  public boolean GmK = true;
  protected int GmL = 0;
  protected long GmM = -1L;
  protected long GmN = -1L;
  private i.a GmO = new i.a()
  {
    public final void onOrientationChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.acb(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  protected l GmP;
  public o GmQ;
  private m GmR;
  public r GmS;
  protected n GmT;
  private boolean GmU;
  protected com.tencent.mm.plugin.topstory.ui.widget.d GmV;
  private boolean GmW;
  protected com.tencent.mm.plugin.topstory.ui.widget.b GmX;
  private aj GmY;
  private aj GmZ;
  protected View Gmx;
  protected ImageView Gmy;
  protected View Gmz;
  public boolean Gna;
  private j Gnb;
  private com.tencent.mm.ak.i Gnc = new com.tencent.mm.ak.i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousq;
      paramAnonymousq = (eim)localj.rr.iLK.iLR;
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        Log.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(2131766820), 0).show();
        if (localj.GjH != null)
        {
          paramAnonymousString = localj.GjH;
          if (localj.GjH.NiC) {
            break label173;
          }
        }
        label173:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.NiC = bool;
          Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.GjH.NiC);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.fyK().b(localj.GjH);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.fzj();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.fzk().getControlBar()).m(localj.GjH);
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
        localJSONObject.put("docId", paramAnonymousq.MEq);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousq.him != 4) {
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
      if (localj.GjH != null)
      {
        paramAnonymousString = localj.GjH;
        if (paramAnonymousq.him != 4) {
          break label522;
        }
      }
      label516:
      label522:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.NiC = bool;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.GjH.NiC), Integer.valueOf(localj.GjH.NiH) });
        if (paramAnonymousq.him != 4) {
          break label528;
        }
        h localh = TopStoryBaseVideoUI.this.fyK().b(localj.GjH);
        paramAnonymousq = null;
        paramAnonymousString = paramAnonymousq;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).GjK != null)
        {
          paramAnonymousString = paramAnonymousq;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).GjK != null)
          {
            paramAnonymousString = paramAnonymousq;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).GjK.psI != null)
            {
              paramAnonymousString = paramAnonymousq;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).GjK.psI.equals(localj.GjH.psI)) {
                if (!(localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  paramAnonymousString = paramAnonymousq;
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
          TopStoryBaseVideoUI.this.a(localj.GjH, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.fzk().getControlBar().show();
          }
        }
        paramAnonymousString = new kn();
        paramAnonymousString.dPD.dPE = localJSONObject.toString();
        paramAnonymousString.dPD.dPF = "";
        EventCenter.instance.publish(paramAnonymousString);
        break;
        bool = false;
        break label223;
      }
      label528:
      if (localj.fye().NhI) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(2131766849), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.GjH, null, false);
        break;
        u.makeText(TopStoryBaseVideoUI.this.getContext(), 2131766850, 0).show();
      }
    }
  };
  protected com.tencent.mm.plugin.topstory.ui.b.a Utu;
  protected RecyclerView.l guX = new RecyclerView.l()
  {
    public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAnonymousRecyclerView);
      localb.pH(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      if (!TopStoryBaseVideoUI.this.GmK)
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
        if (TopStoryBaseVideoUI.this.Gna) {
          TopStoryBaseVideoUI.this.GmI.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.GmE.b(TopStoryBaseVideoUI.this);
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(126087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAnonymousRecyclerView);
      localb.pH(paramAnonymousInt1);
      localb.pH(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      if ((!TopStoryBaseVideoUI.this.GmK) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126087);
        return;
      }
      TopStoryBaseVideoUI.this.fzp();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(126087);
    }
  };
  private Point imX;
  protected TextView jVO;
  private boolean mqz = false;
  protected LinearLayoutManager pcs;
  protected View tql;
  private int videoHeight;
  
  private void fzl()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.oE(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void fzu()
  {
    if (this.GjJ.guh) {
      this.Gmy.setBackgroundResource(2131691659);
    }
    for (;;)
    {
      if (this.GmS.GnZ) {
        this.GmS.setMute(this.GjJ.guh);
      }
      return;
      this.Gmy.setBackgroundResource(2131691660);
    }
  }
  
  private void fzv()
  {
    com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Zx()
  {
    return this.GjJ.guh;
  }
  
  public final void a(eiw parameiw)
  {
    if (!this.Gna)
    {
      this.jVO.setText(2131764256);
      this.GmA.setVisibility(8);
    }
    if (this.GmJ != null) {
      this.GmJ.a(this.GjJ, parameiw);
    }
    if (this.Utu != null) {
      this.Utu.a(this.GjJ, parameiw);
    }
  }
  
  public final void a(eiw parameiw, View paramView)
  {
    if (parameiw != null)
    {
      if (!NetStatusUtil.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131766820), 0).show();
      }
    }
    else {
      return;
    }
    if (this.Gnb != null) {
      com.tencent.mm.kernel.g.azz().a(this.Gnb);
    }
    String str1 = parameiw.wWb;
    int i;
    int j;
    label110:
    boolean bool;
    if (parameiw.NiC)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.GjJ.scene;
      String str3 = this.GjJ.hes;
      if (!fyL()) {
        break label238;
      }
      j = 318;
      this.Gnb = new j(parameiw, str1, i, str2, k, str3, j, parameiw.psI, parameiw.NiD);
      com.tencent.mm.kernel.g.azz().a(this.Gnb, 0);
      if (parameiw.NiC) {
        break label246;
      }
      bool = true;
      label163:
      parameiw.NiC = bool;
      if (!parameiw.NiC) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (parameiw.NiH += 1;; parameiw.NiH -= 1)
    {
      ((TextView)paramView.findViewById(2131310541)).setText(com.tencent.mm.plugin.topstory.ui.c.abR(parameiw.NiH));
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + parameiw.NiC);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(eiw parameiw, View paramView, boolean paramBoolean);
  
  public void aTE(String paramString) {}
  
  public final void aTF(String paramString)
  {
    this.GjJ.Nii = paramString;
  }
  
  public final void abV(int paramInt)
  {
    this.GjJ.Nig = paramInt;
  }
  
  public final void abW(int paramInt)
  {
    this.GjJ.Nij = paramInt;
  }
  
  protected void acb(int paramInt) {}
  
  protected void amZ()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.GjJ = new eit();
    try
    {
      this.GjJ.parseFrom(arrayOfByte);
      this.GmT = new n();
      this.GmT.GlS = this;
      this.GmR = new m();
      this.GmR.d(this);
      this.GmQ = new o();
      this.GmQ.d(this);
      this.GmS = new r();
      this.GmS.d(this);
      this.GmP = new l();
      this.GmE = fzn();
      this.GmI = fzo();
      this.Utu = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.Utu.G(8, this.GjJ.sGQ);
      this.Utu.agT(getResources().getString(2131766816));
      this.GmJ = new com.tencent.mm.plugin.topstory.ui.multitask.a(new com.tencent.mm.plugin.topstory.ui.multitask.b(this));
      this.GmJ.G(8, this.GjJ.sGQ);
      this.GmJ.aCM(getResources().getString(2131766816));
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
  
  public final void ay(final View paramView, final int paramInt)
  {
    if (this.GmS.dFG())
    {
      this.GmS.cXa();
      this.GmU = true;
    }
    eiw localeiw = this.GmT.acd(paramInt);
    this.GmV = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localeiw, new d.a()
    {
      public final void e(eiw paramAnonymouseiw)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymouseiw.NiE != null) {
          TopStoryBaseVideoUI.this.az(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.GmV.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(eiw paramAnonymouseiw)
      {
        AppMethodBeat.i(126090);
        p localp = p.GnV;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.fyD(), paramAnonymouseiw);
        TopStoryBaseVideoUI.this.GmV.dismiss();
        com.tencent.mm.plugin.report.e.Cxv.a(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(eiw paramAnonymouseiw)
      {
        AppMethodBeat.i(164124);
        Object localObject = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hde())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.c.bu(paramAnonymouseiw.psI, paramAnonymouseiw.Nip);
          localObject = TopStoryBaseVideoUI.this.fyC() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymouseiw.title + ".mp4";
          if (s.YS("/sdcard/video/")) {
            s.boN("/sdcard/video/");
          }
          s.nw((String)localObject, str);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymouseiw.title, 0).show();
        }
        AppMethodBeat.o(164124);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126091);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "more popupWindow dismiss");
        if (TopStoryBaseVideoUI.c(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.d(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
          {
            AppMethodBeat.o(126091);
            return;
          }
          TopStoryBaseVideoUI.this.GmS.eYd();
          if (TopStoryBaseVideoUI.this.Gna) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.GmS.GnY.getControlBar()).bJB();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.Gna) {
      this.GmV.a(paramView, true, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.GmS.GnY.getControlBar()).crH();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.e.Cxv.a(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.GmV.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void az(View paramView, final int paramInt)
  {
    this.GmW = true;
    final eiw localeiw = this.GmT.acd(paramInt);
    this.GmX = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localeiw, new b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.GmS.eYd();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.Gna) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.GmS.GnY.getControlBar()).bJB();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
      
      public final void v(Set<any> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        u.makeText(TopStoryBaseVideoUI.this.getContext(), 2131766815, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.fyD(), localeiw, paramAnonymousSet, TopStoryBaseVideoUI.this.GmT.fzy());
        TopStoryBaseVideoUI.this.GmS.stopPlay();
        TopStoryBaseVideoUI.this.GmT.acc(paramInt);
        if (TopStoryBaseVideoUI.this.GmT.fzy() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.Gna)
        {
          TopStoryBaseVideoUI.this.GmH.ck(paramInt + TopStoryBaseVideoUI.this.GmH.getHeadersCount());
          TopStoryBaseVideoUI.this.GmD.atj.notifyChanged();
          TopStoryBaseVideoUI.this.GmF.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.GmD.ck(paramInt + TopStoryBaseVideoUI.this.GmD.getHeadersCount());
        TopStoryBaseVideoUI.this.GmH.atj.notifyChanged();
        AppMethodBeat.o(126092);
      }
    });
    if (this.Gna) {
      this.GmX.a(paramView, true, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.GmS.GnY.getControlBar()).crH();
      return;
    }
    catch (Exception paramView) {}
    this.GmX.a(paramView, false, 0, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final Point cZM()
  {
    if (this.imX == null) {
      this.imX = ao.az(this);
    }
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.imX.x), Integer.valueOf(this.imX.y) });
    return this.imX;
  }
  
  public final MMActivity eeF()
  {
    return this;
  }
  
  public final l fyA()
  {
    return this.GmP;
  }
  
  public final o fyB()
  {
    return this.GmQ;
  }
  
  public final String fyC()
  {
    return com.tencent.mm.plugin.topstory.a.h.aTv(this.GjJ.sGQ);
  }
  
  public final eit fyD()
  {
    return this.GjJ;
  }
  
  public final m fyE()
  {
    return this.GmR;
  }
  
  public final r fyF()
  {
    return this.GmS;
  }
  
  public final aj fyG()
  {
    if (this.Gna) {
      return this.GmZ;
    }
    return this.GmY;
  }
  
  public final int fyH()
  {
    return this.GjJ.Nig;
  }
  
  public final boolean fyI()
  {
    return this.GjJ.scene != 36;
  }
  
  public final boolean fyJ()
  {
    return this.GjJ.scene != 326;
  }
  
  public final e fyK()
  {
    if (this.Gna) {
      return this.GmH;
    }
    return this.GmD;
  }
  
  public final boolean fyL()
  {
    return this.GjJ.Nib == 100203L;
  }
  
  public final void fyM()
  {
    fzl();
  }
  
  public int fyN()
  {
    return com.tencent.mm.plugin.topstory.ui.a.GjN;
  }
  
  public final n fyO()
  {
    return this.GmT;
  }
  
  public final String fyP()
  {
    if (this.GjJ.Nii == null) {
      return "";
    }
    return this.GjJ.Nii;
  }
  
  public final int fyQ()
  {
    return this.GjJ.Nij;
  }
  
  public final void fyR()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.getFootersCount();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.fyU();
        paramAnonymouse.at(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.GmD);
        a(TopStoryBaseVideoUI.this.GmH);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public void fyx() {}
  
  public void fyy() {}
  
  protected void fzm() {}
  
  protected abstract d fzn();
  
  protected abstract d fzo();
  
  protected void fzp()
  {
    int j = 0;
    int i;
    if (this.Gna)
    {
      this.GmI.a(this);
      this.GmL = ((LinearLayoutManager)getLayoutManager()).ku();
      i = getLayoutManager().getItemCount();
      if ((this.GmM <= 0L) || (Util.ticksToNow(this.GmM) >= 50L))
      {
        this.GmM = Util.currentTicks();
        if (this.GmT.GnE == 1) {
          break label145;
        }
        if ((this.GmL < i - 1) || (this.GmT.GhN) || (Util.ticksToNow(this.GmN) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!fzr()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          fzq();
        }
        return;
        this.GmE.a(this);
        break;
        label145:
        if ((i - this.GmL > 3) || (this.GmT.GhN) || (Util.ticksToNow(this.GmN) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void fzq()
  {
    this.GmN = Util.currentTicks();
  }
  
  protected final boolean fzr()
  {
    return (this.GjJ.scene != 36) && (!this.GjJ.Nik);
  }
  
  protected abstract e fzs();
  
  protected abstract e fzt();
  
  public final RecyclerView.LayoutManager getLayoutManager()
  {
    if (this.Gna) {
      return this.GmG;
    }
    return this.pcs;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.Gna) {
      return this.GmF;
    }
    return this.GmC;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (fyL()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = cZM().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(cZM().x, cZM().y);
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    fzl();
    this.tql = findViewById(2131309214);
    this.jVO = ((TextView)findViewById(2131309249));
    this.GmA = ((ImageView)findViewById(2131308308));
    this.Gmx = findViewById(2131305119);
    this.Gmy = ((ImageView)findViewById(2131305122));
    this.Gmz = findViewById(2131304871);
    this.AnC = ((ImageButton)findViewById(2131297163));
    this.AnC.getDrawable().setColorFilter(getResources().getColor(2131099844), PorterDuff.Mode.SRC_ATOP);
    this.AnC.setOnClickListener(new TopStoryBaseVideoUI.1(this));
    this.Gmx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.GjJ.guh) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.ww(bool);
          paramAnonymousView.fyy();
          paramAnonymousView.fyx();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.Gmx.setVisibility(8);
    this.GmC = ((RecyclerView)findViewById(2131309818));
    this.GmC.a(this.guX);
    this.GmC.setItemAnimator(new a((byte)0));
    this.pcs = new LinearLayoutManager();
    this.GmC.setLayoutManager(this.pcs);
    this.GmY = aj.e(this.pcs);
    this.GmD = fzs();
    this.GmC.setAdapter(this.GmD);
    this.GmF = ((RecyclerView)findViewById(2131301806));
    this.GmF.a(this.guX);
    this.GmF.setItemAnimator(new a((byte)0));
    this.GmG = new LinearLayoutManager();
    this.GmF.setLayoutManager(this.GmG);
    this.GmZ = aj.e(this.GmG);
    this.GmH = fzt();
    this.GmF.setAdapter(this.GmH);
    this.GmF.setVisibility(8);
    if ((!this.mqz) && (!fyL()))
    {
      this.GmB = new i(getApplicationContext());
      this.GmB.enable();
      this.GmB.Gnj = this.GmO;
      this.mqz = true;
    }
    if (this.GjJ.guh) {
      ww(this.GjJ.guh);
    }
    this.GmP.Gnv = this;
    this.Gmz.setOnClickListener(new TopStoryBaseVideoUI.6(this));
  }
  
  public final boolean isFullscreenMode()
  {
    return this.Gna;
  }
  
  public void jm(int paramInt1, int paramInt2)
  {
    this.GmS.jp(paramInt1, paramInt2);
  }
  
  public void onBackPressed()
  {
    fzm();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    amZ();
    initContentView();
    com.tencent.mm.kernel.g.azz().a(2802, this.Gnc);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.GjJ, getActivityBrowseTimeMs(), this.GmT.acd(this.GjJ.Nig));
    if (this.mqz)
    {
      this.GmB.disable();
      this.GmB.Gnj = null;
      this.GmB = null;
    }
    if (this.Gnb != null) {
      com.tencent.mm.kernel.g.azz().a(this.Gnb);
    }
    com.tencent.mm.kernel.g.azz().b(2802, this.Gnc);
    this.GmT.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.GjJ);
    this.GmS.onUIDestroy();
    this.GmP.onUIDestroy();
    this.GmQ.onUIDestroy();
    this.GmR.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.pl(16);
    if (this.Utu != null) {
      this.Utu.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      eit localeit = this.GjJ;
      if (getSystemVolume() <= 1)
      {
        localeit.guh = bool;
        fzu();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.GjJ.guh = false;
        fzu();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.GmS.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.pl(15);
      if (this.GmJ != null) {
        this.GmJ.aGj();
      }
      if (this.Utu != null) {
        this.Utu.aGj();
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
    fzl();
    fzu();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.GmS.onUIResume();
    this.GmP.CTg = l.fiw();
    com.tencent.mm.plugin.websearch.api.a.a.pl(14);
    if (this.GmJ != null) {
      this.GmJ.bCA();
    }
    if (this.Utu != null) {
      this.Utu.bCA();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void s(final List<eiw> paramList, final boolean paramBoolean)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.Gna)
        {
          TopStoryBaseVideoUI.this.GmH.t(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.GmD.atj.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.GmD.t(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.GmH.atj.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public final void wv(boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GmK = paramBoolean;
  }
  
  public final void ww(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.GjJ.guh = true;
    }
    for (;;)
    {
      fzu();
      return;
      this.GjJ.guh = false;
      if (getSystemVolume() == 0) {
        fzv();
      }
    }
  }
  
  final class a
    extends v
  {
    private a() {}
    
    public final void D(RecyclerView.v paramv)
    {
      AppMethodBeat.i(126094);
      super.D(paramv);
      TopStoryBaseVideoUI.this.fzp();
      TopStoryBaseVideoUI.this.GmE.b(TopStoryBaseVideoUI.this);
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.lR()) });
      AppMethodBeat.o(126094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */