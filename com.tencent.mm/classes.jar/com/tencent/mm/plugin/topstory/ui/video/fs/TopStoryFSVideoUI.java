package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ctk;
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

public class TopStoryFSVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long yRG = 0L;
  protected RecyclerView.m frd;
  private Point gxV;
  protected LinearLayoutManager mJn;
  protected ImageButton tZh;
  private int videoHeight;
  protected View wjg;
  protected dcy yLX;
  protected View yOR;
  protected ImageView yOS;
  protected View yOT;
  protected RecyclerView yOW;
  private com.tencent.mm.plugin.topstory.ui.a.a yPd;
  protected int yPf;
  protected long yPg;
  protected long yPh;
  private com.tencent.mm.plugin.topstory.ui.video.l yPj;
  private o yPk;
  private m yPl;
  r yPm;
  com.tencent.mm.plugin.topstory.ui.video.n yPn;
  private boolean yPo;
  protected com.tencent.mm.plugin.topstory.ui.widget.d yPp;
  private boolean yPq;
  protected com.tencent.mm.plugin.topstory.ui.widget.b yPr;
  private aj yPs;
  private com.tencent.mm.al.g yPw;
  private Button yRA;
  View yRB;
  com.tencent.mm.plugin.topstory.ui.widget.c yRC;
  View yRD;
  TopStoryCommentFloatDialog yRE;
  private boolean yRF;
  protected i yRu;
  protected h yRv;
  private ProgressDialog yRw;
  private View yRx;
  private View yRy;
  private View yRz;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.frd = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126332);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        if (paramAnonymousInt2 == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(126332);
          return;
        }
        TopStoryFSVideoUI.this.dPv();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126332);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(126331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(126331);
          return;
          TopStoryFSVideoUI.this.yRv.b(TopStoryFSVideoUI.this);
        }
      }
    };
    this.yPf = 0;
    this.yPg = -1L;
    this.yPh = -1L;
    this.yPw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousn;
        paramAnonymousn = (dcr)localj.rr.gUS.gUX;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          t.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131764476), 0).show();
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
            ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.yLU.Evb);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.dOP().b(localj.yLU);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.dPp().getControlBar()).l(localj.yLU);
                }
                AppMethodBeat.o(126340);
              }
            });
            AppMethodBeat.o(126341);
            return;
          }
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("docId", paramAnonymousn.DUZ);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousn.fVE != 4) {
            break label492;
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
            break label498;
          }
        }
        label492:
        label498:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.Evb = bool;
          ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.yLU.Evb), Integer.valueOf(localj.yLU.Evg) });
          if (paramAnonymousn.fVE != 4) {
            break label504;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.dOP().b(localj.yLU);
          paramAnonymousn = null;
          paramAnonymousString = paramAnonymousn;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).yLY != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).yLY.rNP != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).yLY.rNP.equals(localj.yLU.rNP))
              {
                paramAnonymousString = paramAnonymousn;
                if ((localh instanceof g)) {
                  paramAnonymousString = localh.getWowView();
                }
              }
            }
          }
          if (paramAnonymousString != null)
          {
            TopStoryFSVideoUI.this.a(localj.yLU, paramAnonymousString, true);
            if ((localh instanceof g)) {
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
        label504:
        if (localj.dOh().Eue) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131764505), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.yLU, null, false);
          break;
          t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764506, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  @SuppressLint({"ResourceType"})
  private void dPA()
  {
    AppMethodBeat.i(126371);
    if (this.yLX.fqj) {
      this.yOS.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.yPm.yQs) {
        this.yPm.setMute(this.yLX.fqj);
      }
      AppMethodBeat.o(126371);
      return;
      this.yOS.setBackgroundResource(2131691328);
    }
  }
  
  private void dPW()
  {
    AppMethodBeat.i(126363);
    this.yRy.setVisibility(0);
    this.yRx.setVisibility(0);
    this.yPn.Pr(0);
    AppMethodBeat.o(126363);
  }
  
  private void dPq()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lg(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      AppMethodBeat.o(126356);
      return;
      localView.setSystemUiVisibility(4102);
    }
  }
  
  private boolean dPx()
  {
    return (this.yLX.scene != 36) && (!this.yLX.EuH);
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  public final boolean Ny()
  {
    return this.yLX.fqj;
  }
  
  public final boolean Ph(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.yRB.setVisibility(8);
    ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.yRu.getItemCount();
      int j = this.yRu.getFootersCount();
      int k = this.yRu.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.yOW;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.yRu.getHeadersCount() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(126359);
      return true;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(126359);
    }
    return false;
  }
  
  public final void Pi(int paramInt)
  {
    this.yLX.EuD = paramInt;
  }
  
  public final void Pj(int paramInt)
  {
    this.yLX.EuG = paramInt;
  }
  
  public final void a(ctk paramctk) {}
  
  public final void a(ddb paramddb)
  {
    AppMethodBeat.i(126360);
    if (this.yPd != null) {
      this.yPd.a(this.yLX, paramddb);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(ddb paramddb, int paramInt1, int paramInt2) {}
  
  public final void a(ddb paramddb, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramddb != null)
    {
      if (!ay.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramddb.roQ;
      if (!paramddb.Evb) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.yLX.scene;
      String str2 = this.yLX.jko;
      if (!dOQ()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramddb, (String)localObject, i, str1, k, str2, j, paramddb.rNP, paramddb.Evc);
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
      if (paramddb.Evb) {
        break label243;
      }
      bool = true;
      label154:
      paramddb.Evb = bool;
      if (!paramddb.Evb) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramddb.Evg += 1;; paramddb.Evg -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.Pe(paramddb.Evg));
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramddb.Evb);
      AppMethodBeat.o(126381);
      return;
      i = 4;
      break;
      j = 317;
      break label105;
      bool = false;
      break label154;
    }
  }
  
  public final void a(final ddb paramddb, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramddb.rNP, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.yRB.getVisibility() == 0) && (this.yRC != null) && (this.yRC.gGC != null) && (this.yRC.gGC.equals(paramddb.rNP))) {
        this.yRB.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramddb.roQ;
    String str2 = paramddb.title;
    String str3 = this.yLX.jko;
    int j = this.yLX.scene;
    if (dOQ()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramddb.rNP, paramddb.Evc);
      this.yRB.setVisibility(0);
      this.yRC = new com.tencent.mm.plugin.topstory.ui.widget.c(this.yRD, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.yRE.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void dPY()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.yRB.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.yPm.dzF();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.yLX.Euy, paramddb.EuQ);
          if (TopStoryFSVideoUI.this.yPm.dPO()) {
            TopStoryFSVideoUI.this.yPm.ckd();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramddb.rNP);
      this.yRB.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126346);
          if (TopStoryFSVideoUI.this.yRB.getVisibility() == 0) {
            TopStoryFSVideoUI.this.yRB.setVisibility(8);
          }
          AppMethodBeat.o(126346);
        }
      }, 2000L);
      this.yRC.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(ddb paramddb, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void aq(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
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
        AppMethodBeat.i(126333);
        if (paramAnonymousddb.Evd != null) {
          TopStoryFSVideoUI.this.ar(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.yPp.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(ddb paramAnonymousddb)
      {
        AppMethodBeat.i(126334);
        p localp = p.yQo;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.dOH(), paramAnonymousddb);
        TopStoryFSVideoUI.this.yPp.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(ddb paramAnonymousddb)
      {
        AppMethodBeat.i(164128);
        if (com.tencent.mm.util.c.fgW())
        {
          String str1 = com.tencent.mm.plugin.topstory.ui.d.bn(paramAnonymousddb.rNP, paramAnonymousddb.EuN);
          str1 = TopStoryFSVideoUI.this.dOG() + str1 + ".mp4";
          String str2 = "/sdcard/video/" + paramAnonymousddb.title + ".mp4";
          if (com.tencent.mm.vfs.i.eK("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aMF("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.lC(str1, str2);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousddb.title, 0).show();
        }
        AppMethodBeat.o(164128);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126335);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "more popupWindow dismiss");
        if (TopStoryFSVideoUI.e(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.f(TopStoryFSVideoUI.this);
          if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
          {
            AppMethodBeat.o(126335);
            return;
          }
          TopStoryFSVideoUI.this.yPm.dzF();
          try
          {
            ((f)TopStoryFSVideoUI.this.yPm.yQr.getControlBar()).bcH();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.yPp.a(paramView, true, 0, 0);
    try
    {
      ((f)this.yPm.yQr.getControlBar()).bGT();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void ar(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.yPq = true;
    final ddb localddb = this.yPn.Pq(paramInt);
    this.yPr = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localddb, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void h(Set<ahk> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.dOH(), localddb, paramAnonymousSet, TopStoryFSVideoUI.this.yPn.dPF());
        TopStoryFSVideoUI.this.yPm.stopPlay();
        TopStoryFSVideoUI.this.yPn.Pp(paramInt);
        if (TopStoryFSVideoUI.this.yPn.dPF() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.yRu.cm(paramInt + TopStoryFSVideoUI.this.yRu.getHeadersCount());
        TopStoryFSVideoUI.this.yOW.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.yPm.dzF();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.yPm.yQr.getControlBar()).bcH();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
    });
    this.yPr.a(paramView, true, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.yPm.yQr.getControlBar()).bGT();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final void asH(final String paramString)
  {
    AppMethodBeat.i(126375);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126339);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        if (TopStoryFSVideoUI.k(TopStoryFSVideoUI.this) != null)
        {
          TopStoryFSVideoUI.k(TopStoryFSVideoUI.this).dismiss();
          TopStoryFSVideoUI.l(TopStoryFSVideoUI.this);
        }
        TopStoryFSVideoUI.a(TopStoryFSVideoUI.this, paramString);
        AppMethodBeat.o(126339);
      }
    });
    AppMethodBeat.o(126375);
  }
  
  public final void asI(String paramString)
  {
    this.yLX.EuF = paramString;
  }
  
  public final MMActivity cKW()
  {
    return this;
  }
  
  public final void cMY() {}
  
  public final void dOB()
  {
    AppMethodBeat.i(126357);
    this.wjg.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.yRB.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void dOC()
  {
    AppMethodBeat.i(126358);
    this.wjg.animate().cancel();
    this.wjg.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.l dOE()
  {
    return this.yPj;
  }
  
  public final o dOF()
  {
    return this.yPk;
  }
  
  public final String dOG()
  {
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.asy(this.yLX.qwV);
    AppMethodBeat.o(126364);
    return str;
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
    AppMethodBeat.i(126367);
    if (this.gxV == null) {
      this.gxV = ai.cf(this);
    }
    Point localPoint = this.gxV;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final aj dOL()
  {
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
    return this.yRu;
  }
  
  public final boolean dOQ()
  {
    return this.yLX.Euy == 100203L;
  }
  
  public final void dOR()
  {
    AppMethodBeat.i(126380);
    dPq();
    AppMethodBeat.o(126380);
  }
  
  public final int dOS()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.n dOT()
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
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.yRu;
        int i = locali.getFootersCount();
        int j = locali.getItemCount();
        locali.dOZ();
        locali.ar(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int dOX()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.poc, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void dPX()
  {
    AppMethodBeat.i(126370);
    if (this.yLX.fqj)
    {
      this.yLX.fqj = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
      }
    }
    for (;;)
    {
      dPA();
      dOC();
      dOB();
      AppMethodBeat.o(126370);
      return;
      this.yLX.fqj = true;
    }
  }
  
  protected final void dPv()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.yRv.a(this);
    this.yPf = this.mJn.jQ();
    int j = this.mJn.getItemCount();
    if ((this.yPg <= 0L) || (bt.aS(this.yPg) >= 50L))
    {
      this.yPg = bt.GC();
      if (this.yPn.yPZ == 1) {
        break label161;
      }
      if ((this.yPf < j - 1) || (this.yPn.yPY) || (bt.aS(this.yPh) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!dPx()) {
        i = 0;
      }
      if (i != 0)
      {
        this.yRy.setVisibility(0);
        this.yRx.setVisibility(0);
        this.yPn.Pr(this.yPn.dPF());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.yPf > 3) || (this.yPn.yPY) || (bt.aS(this.yPh) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (dOQ())
    {
      AppMethodBeat.o(126361);
      return 1;
    }
    AppMethodBeat.o(126361);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131495782;
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.mJn;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.yOW;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (dOQ()) {
        break label49;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      int i = this.videoHeight;
      AppMethodBeat.o(126365);
      return i;
      label49:
      this.videoHeight = 1280;
      i = dOK().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(dOK().x, dOK().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final void hJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.yRF)) {
      dPW();
    }
    this.yPm.hM(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void l(List<ddb> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.yRu.m(paramList, paramBoolean);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.yOW.a(0, 3, null);
        if (TopStoryFSVideoUI.k(TopStoryFSVideoUI.this) != null)
        {
          TopStoryFSVideoUI.k(TopStoryFSVideoUI.this).dismiss();
          TopStoryFSVideoUI.l(TopStoryFSVideoUI.this);
        }
        AppMethodBeat.o(126338);
      }
    }, 50L);
    AppMethodBeat.o(126374);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126362);
    p.yQo.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.yPj.bVA()) || (com.tencent.mm.plugin.topstory.a.h.dNW())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.rf(false);
      }
    }
    AppMethodBeat.o(126362);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126354);
    if (Build.VERSION.SDK_INT >= 28) {
      customfixStatusbar(true);
    }
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_context");
    this.yLX = new dcy();
    try
    {
      this.yLX.parseFrom(paramBundle);
      this.yPn = new com.tencent.mm.plugin.topstory.ui.video.n();
      this.yPn.yOm = this;
      this.yPl = new m();
      this.yPl.d(this);
      this.yPk = new o();
      this.yPk.d(this);
      this.yPm = new r();
      this.yPm.d(this);
      this.yPj = new com.tencent.mm.plugin.topstory.ui.video.l();
      this.yRv = new h();
      if (this.yLX.Euz != null) {
        this.yPn.h(this.yLX.Euz);
      }
      this.yPd = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.yPd.Z(8, this.yLX.qwV);
      this.yPd.OE(getResources().getString(2131764472));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().setStatusBarColor(getResources().getColor(2131100393));
      }
      if (this.yLX.EuB) {
        this.yPj.yPO = true;
      }
      dPq();
      this.wjg = findViewById(2131305918);
      this.yOR = findViewById(2131302622);
      this.yOT = findViewById(2131302462);
      this.yOS = ((ImageView)findViewById(2131302624));
      this.tZh = ((ImageButton)findViewById(2131297026));
      this.tZh.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
      this.tZh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126329);
          TopStoryFSVideoUI.a(TopStoryFSVideoUI.this);
          AppMethodBeat.o(126329);
        }
      });
      this.yOR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126347);
          TopStoryFSVideoUI.this.dPX();
          AppMethodBeat.o(126347);
        }
      });
      this.yOR.setVisibility(8);
      this.yRz = findViewById(2131300313);
      this.yRA = ((Button)findViewById(2131304375));
      this.yOW = ((RecyclerView)findViewById(2131306389));
      this.yOW.a(this.frd);
      this.mJn = new LinearLayoutManager();
      this.yOW.setLayoutManager(this.mJn);
      this.yPs = aj.e(this.mJn);
      this.yRu = new i(this);
      paramBundle = this.yRu;
      View localView = LayoutInflater.from(this).inflate(2131495794, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.yRy = localView.findViewById(2131300203);
      this.yRx = localView.findViewById(2131300207);
      paramBundle.fc(localView);
      this.yOW.setAdapter(this.yRu);
      new b().j(this.yOW);
      if (dPx()) {
        if (this.yPj.isConnected())
        {
          dPW();
          this.yRF = false;
          if ((this.yLX.scene != 21) && (this.yLX.EuA == null)) {
            this.yRw = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(126348);
                TopStoryFSVideoUI.this.finish();
                AppMethodBeat.o(126348);
              }
            });
          }
          this.yRu.yRK = true;
          this.yRz.setVisibility(8);
          if ((this.yPj.dPC()) && (com.tencent.mm.plugin.topstory.a.h.dNW()) && (System.currentTimeMillis() - yRG > 86400000L))
          {
            Toast.makeText(this, 2131764483, 0).show();
            yRG = System.currentTimeMillis();
          }
          this.yRB = findViewById(2131299128);
          this.yRD = findViewById(2131299129);
          this.yRB.setVisibility(8);
          this.yRB.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(126349);
              if (TopStoryFSVideoUI.this.yRB.getVisibility() == 0)
              {
                float f1 = paramAnonymousMotionEvent.getX();
                float f2 = paramAnonymousMotionEvent.getY();
                if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this.yRD, f1, f2))
                {
                  ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                  AppMethodBeat.o(126349);
                  return false;
                }
                TopStoryFSVideoUI.this.yRB.setVisibility(8);
              }
              AppMethodBeat.o(126349);
              return false;
            }
          });
          this.yRE = ((TopStoryCommentFloatDialog)findViewById(2131298520));
          this.yRE.setVisibility(8);
          this.yRE.m(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (dOQ())
          {
            this.tZh.setImageResource(2131691314);
            if (ai.aF(this))
            {
              int i = ai.aE(this);
              paramBundle = (RelativeLayout.LayoutParams)this.wjg.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cd.a.fromDPToPix(this, 12));
              this.wjg.setLayoutParams(paramBundle);
            }
          }
          this.yOT.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(126351);
              TopStoryFSVideoUI.c(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126351);
            }
          });
          com.tencent.mm.kernel.g.aeS().a(2802, this.yPw);
          AppMethodBeat.o(126354);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        finish();
        continue;
        Toast.makeText(this, 2131762228, 1).show();
        this.yRF = true;
        continue;
        this.yRy.setVisibility(4);
        this.yRx.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.yLX, getActivityBrowseTimeMs(), this.yPn.Pq(this.yLX.EuD));
    com.tencent.mm.kernel.g.aeS().b(2802, this.yPw);
    this.yPn.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.yLX);
    this.yPm.onUIDestroy();
    this.yPj.onUIDestroy();
    this.yPk.onUIDestroy();
    this.yPl.onUIDestroy();
    this.yRE.ftZ.close();
    com.tencent.mm.plugin.websearch.api.a.a.lI(16);
    if (this.yPd != null) {
      this.yPd.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.yRE.getVisibility() == 0))
    {
      this.yRE.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dcy localdcy = this.yLX;
      if (getSystemVolume() <= 1)
      {
        localdcy.fqj = bool;
        dPA();
      }
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(126369);
      return bool;
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.yLX.fqj = false;
        dPA();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.yPm.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.yRE.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.lI(15);
    if (this.yPd != null) {
      this.yPd.aWa();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    dPq();
    dPA();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.yPm.onUIResume();
    this.yPj.vZZ = com.tencent.mm.plugin.topstory.ui.video.l.dBC();
    this.yRE.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.lI(14);
    if (this.yPd != null) {
      this.yPd.aVZ();
    }
    AppMethodBeat.o(126377);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */