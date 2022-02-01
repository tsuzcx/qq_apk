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
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
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
import com.tencent.mm.g.a.jx;
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
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.dei;
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

public class TopStoryFSVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long Bxh = 0L;
  protected doa BrB;
  private com.tencent.mm.plugin.topstory.ui.a.a BuF;
  protected int BuH;
  protected long BuI;
  protected long BuJ;
  private com.tencent.mm.plugin.topstory.ui.video.l BuL;
  private o BuM;
  private m BuN;
  r BuO;
  com.tencent.mm.plugin.topstory.ui.video.n BuP;
  private boolean BuQ;
  protected com.tencent.mm.plugin.topstory.ui.widget.d BuR;
  private boolean BuS;
  protected com.tencent.mm.plugin.topstory.ui.widget.b BuT;
  private aj BuU;
  private com.tencent.mm.al.f BuY;
  protected View But;
  protected ImageView Buu;
  protected View Buv;
  protected RecyclerView Buy;
  protected i BwV;
  protected h BwW;
  private ProgressDialog BwX;
  private View BwY;
  private View BwZ;
  private View Bxa;
  private Button Bxb;
  View Bxc;
  com.tencent.mm.plugin.topstory.ui.widget.c Bxd;
  View Bxe;
  TopStoryCommentFloatDialog Bxf;
  private boolean Bxg;
  protected RecyclerView.m fNG;
  private Point hqz;
  protected LinearLayoutManager nLX;
  private int videoHeight;
  protected ImageButton wnu;
  protected View yJh;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.fNG = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126332);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        if (paramAnonymousInt2 == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(126332);
          return;
        }
        TopStoryFSVideoUI.this.eqm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126332);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(126331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(126331);
          return;
          TopStoryFSVideoUI.this.BwW.b(TopStoryFSVideoUI.this);
        }
      }
    };
    this.BuH = 0;
    this.BuI = -1L;
    this.BuJ = -1L;
    this.BuY = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousn;
        paramAnonymousn = (dnt)localj.rr.hNK.hNQ;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          t.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131764476), 0).show();
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
            ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.Brz.HCI);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.epH().b(localj.Brz);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.eqh().getControlBar()).l(localj.Brz);
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
          localJSONObject.put("docId", paramAnonymousn.HbR);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousn.gsV != 4) {
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
        if (localj.Brz != null)
        {
          paramAnonymousString = localj.Brz;
          if (paramAnonymousn.gsV != 4) {
            break label498;
          }
        }
        label492:
        label498:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.HCI = bool;
          ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.Brz.HCI), Integer.valueOf(localj.Brz.HCN) });
          if (paramAnonymousn.gsV != 4) {
            break label504;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.epH().b(localj.Brz);
          paramAnonymousn = null;
          paramAnonymousString = paramAnonymousn;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BrC != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BrC.tSk != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BrC.tSk.equals(localj.Brz.tSk))
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
            TopStoryFSVideoUI.this.a(localj.Brz, paramAnonymousString, true);
            if ((localh instanceof g)) {
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
        label504:
        if (localj.eoZ().HBL) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131764505), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.Brz, null, false);
          break;
          t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764506, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  private void eqM()
  {
    AppMethodBeat.i(126363);
    this.BwZ.setVisibility(0);
    this.BwY.setVisibility(0);
    this.BuP.Th(0);
    AppMethodBeat.o(126363);
  }
  
  private void eqi()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lz(19)) {
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
  
  private boolean eqo()
  {
    return (this.BrB.scene != 36) && (!this.BrB.HCo);
  }
  
  @SuppressLint({"ResourceType"})
  private void eqr()
  {
    AppMethodBeat.i(126371);
    if (this.BrB.fMP) {
      this.Buu.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.BuO.BvU) {
        this.BuO.setMute(this.BrB.fMP);
      }
      AppMethodBeat.o(126371);
      return;
      this.Buu.setBackgroundResource(2131691328);
    }
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  public final boolean Pf()
  {
    return this.BrB.fMP;
  }
  
  public final boolean SX(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.Bxc.setVisibility(8);
    ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.BwV.getItemCount();
      int j = this.BwV.getFootersCount();
      int k = this.BwV.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.Buy;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.BwV.getHeadersCount() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
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
  
  public final void SY(int paramInt)
  {
    this.BrB.HCk = paramInt;
  }
  
  public final void SZ(int paramInt)
  {
    this.BrB.HCn = paramInt;
  }
  
  public final void a(dei paramdei) {}
  
  public final void a(dod paramdod)
  {
    AppMethodBeat.i(126360);
    if (this.BuF != null) {
      this.BuF.a(this.BrB, paramdod);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(dod paramdod, int paramInt1, int paramInt2) {}
  
  public final void a(dod paramdod, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramdod != null)
    {
      if (!ay.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramdod.tul;
      if (!paramdod.HCI) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.BrB.scene;
      String str2 = this.BrB.keN;
      if (!epI()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramdod, (String)localObject, i, str1, k, str2, j, paramdod.tSk, paramdod.HCJ);
      com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
      if (paramdod.HCI) {
        break label243;
      }
      bool = true;
      label154:
      paramdod.HCI = bool;
      if (!paramdod.HCI) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramdod.HCN += 1;; paramdod.HCN -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.SU(paramdod.HCN));
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramdod.HCI);
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
  
  public final void a(final dod paramdod, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdod.tSk, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.Bxc.getVisibility() == 0) && (this.Bxd != null) && (this.Bxd.hzm != null) && (this.Bxd.hzm.equals(paramdod.tSk))) {
        this.Bxc.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramdod.tul;
    String str2 = paramdod.title;
    String str3 = this.BrB.keN;
    int j = this.BrB.scene;
    if (epI()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramdod.tSk, paramdod.HCJ);
      this.Bxc.setVisibility(0);
      this.Bxd = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Bxe, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.Bxf.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void eqO()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.Bxc.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.BuO.eaq();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.BrB.HCf, paramdod.HCx);
          if (TopStoryFSVideoUI.this.BuO.eqE()) {
            TopStoryFSVideoUI.this.BuO.cxw();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramdod.tSk);
      this.Bxc.postDelayed(new TopStoryFSVideoUI.11(this), 2000L);
      this.Bxd.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(dod paramdod, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void aCV(final String paramString)
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
  
  public final void aCW(String paramString)
  {
    this.BrB.HCm = paramString;
  }
  
  public final void at(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
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
        AppMethodBeat.i(126333);
        if (paramAnonymousdod.HCK != null) {
          TopStoryFSVideoUI.this.au(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.BuR.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(dod paramAnonymousdod)
      {
        AppMethodBeat.i(126334);
        p localp = p.BvQ;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.epz(), paramAnonymousdod);
        TopStoryFSVideoUI.this.BuR.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(dod paramAnonymousdod)
      {
        AppMethodBeat.i(164128);
        Object localObject = com.tencent.mm.util.c.LgD;
        if (com.tencent.mm.util.c.fNK())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bs(paramAnonymousdod.tSk, paramAnonymousdod.HCu);
          localObject = TopStoryFSVideoUI.this.epy() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousdod.title + ".mp4";
          if (com.tencent.mm.vfs.i.fv("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aYg("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.mz((String)localObject, str);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousdod.title, 0).show();
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
          TopStoryFSVideoUI.this.BuO.eaq();
          try
          {
            ((f)TopStoryFSVideoUI.this.BuO.BvT.getControlBar()).bno();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.BuR.a(paramView, true, 0, 0);
    try
    {
      ((f)this.BuO.BvT.getControlBar()).bSH();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void au(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.BuS = true;
    final dod localdod = this.BuP.Tg(paramInt);
    this.BuT = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdod, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.BuO.eaq();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.BuO.BvT.getControlBar()).bno();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
      
      public final void p(Set<akz> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.epz(), localdod, paramAnonymousSet, TopStoryFSVideoUI.this.BuP.eqv());
        TopStoryFSVideoUI.this.BuO.stopPlay();
        TopStoryFSVideoUI.this.BuP.Tf(paramInt);
        if (TopStoryFSVideoUI.this.BuP.eqv() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.BwV.cl(paramInt + TopStoryFSVideoUI.this.BwV.getHeadersCount());
        TopStoryFSVideoUI.this.Buy.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
    });
    this.BuT.a(paramView, true, 0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.BuO.BvT.getControlBar()).bSH();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final void dfI() {}
  
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
    AppMethodBeat.i(126367);
    if (this.hqz == null) {
      this.hqz = al.ci(this);
    }
    Point localPoint = this.hqz;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final aj epD()
  {
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
    return this.BwV;
  }
  
  public final boolean epI()
  {
    return this.BrB.HCf == 100203L;
  }
  
  public final void epJ()
  {
    AppMethodBeat.i(126380);
    eqi();
    AppMethodBeat.o(126380);
  }
  
  public final int epK()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.n epL()
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
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.BwV;
        int i = locali.getFootersCount();
        int j = locali.getItemCount();
        locali.epR();
        locali.as(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int epP()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qvZ, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void ept()
  {
    AppMethodBeat.i(126357);
    this.yJh.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.Bxc.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void epu()
  {
    AppMethodBeat.i(126358);
    this.yJh.animate().cancel();
    this.yJh.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.l epw()
  {
    return this.BuL;
  }
  
  public final o epx()
  {
    return this.BuM;
  }
  
  public final String epy()
  {
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.aCM(this.BrB.qXu);
    AppMethodBeat.o(126364);
    return str;
  }
  
  public final doa epz()
  {
    return this.BrB;
  }
  
  public final void eqN()
  {
    AppMethodBeat.i(126370);
    if (this.BrB.fMP)
    {
      this.BrB.fMP = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
      }
    }
    for (;;)
    {
      eqr();
      epu();
      ept();
      AppMethodBeat.o(126370);
      return;
      this.BrB.fMP = true;
    }
  }
  
  protected final void eqm()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.BwW.a(this);
    this.BuH = this.nLX.ko();
    int j = this.nLX.getItemCount();
    if ((this.BuI <= 0L) || (bt.aO(this.BuI) >= 50L))
    {
      this.BuI = bt.HI();
      if (this.BuP.BvB == 1) {
        break label161;
      }
      if ((this.BuH < j - 1) || (this.BuP.BvA) || (bt.aO(this.BuJ) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!eqo()) {
        i = 0;
      }
      if (i != 0)
      {
        this.BwZ.setVisibility(0);
        this.BwY.setVisibility(0);
        this.BuP.Th(this.BuP.eqv());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.BuH > 3) || (this.BuP.BvA) || (bt.aO(this.BuJ) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (epI())
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
    return this.nLX;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.Buy;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (epI()) {
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
      i = epC().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(epC().x, epC().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final void ij(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Bxg)) {
      eqM();
    }
    this.BuO.im(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void n(List<dod> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.BwV.o(paramList, paramBoolean);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.Buy.a(0, 3, null);
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
    p.BvQ.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.BuL.chr()) || (com.tencent.mm.plugin.topstory.a.h.eoN())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.sJ(false);
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
    this.BrB = new doa();
    try
    {
      this.BrB.parseFrom(paramBundle);
      this.BuP = new com.tencent.mm.plugin.topstory.ui.video.n();
      this.BuP.BtO = this;
      this.BuN = new m();
      this.BuN.d(this);
      this.BuM = new o();
      this.BuM.d(this);
      this.BuO = new r();
      this.BuO.d(this);
      this.BuL = new com.tencent.mm.plugin.topstory.ui.video.l();
      this.BwW = new h();
      if (this.BrB.HCg != null) {
        this.BuP.h(this.BrB.HCg);
      }
      this.BuF = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.BuF.ac(8, this.BrB.qXu);
      this.BuF.Wm(getResources().getString(2131764472));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.BrB.HCi) {
        this.BuL.Bvq = true;
      }
      eqi();
      this.yJh = findViewById(2131305918);
      this.But = findViewById(2131302622);
      this.Buv = findViewById(2131302462);
      this.Buu = ((ImageView)findViewById(2131302624));
      this.wnu = ((ImageButton)findViewById(2131297026));
      this.wnu.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
      this.wnu.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.But.setOnClickListener(new TopStoryFSVideoUI.12(this));
      this.But.setVisibility(8);
      this.Bxa = findViewById(2131300313);
      this.Bxb = ((Button)findViewById(2131304375));
      this.Buy = ((RecyclerView)findViewById(2131306389));
      this.Buy.a(this.fNG);
      this.nLX = new LinearLayoutManager();
      this.Buy.setLayoutManager(this.nLX);
      this.BuU = aj.e(this.nLX);
      this.BwV = new i(this);
      paramBundle = this.BwV;
      View localView = LayoutInflater.from(this).inflate(2131495794, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.BwZ = localView.findViewById(2131300203);
      this.BwY = localView.findViewById(2131300207);
      paramBundle.fC(localView);
      this.Buy.setAdapter(this.BwV);
      new b().j(this.Buy);
      if (eqo()) {
        if (this.BuL.isConnected())
        {
          eqM();
          this.Bxg = false;
          if ((this.BrB.scene != 21) && (this.BrB.HCh == null)) {
            this.BwX = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new TopStoryFSVideoUI.13(this));
          }
          this.BwV.Bxl = true;
          this.Bxa.setVisibility(8);
          if ((this.BuL.eqt()) && (com.tencent.mm.plugin.topstory.a.h.eoN()) && (System.currentTimeMillis() - Bxh > 86400000L))
          {
            Toast.makeText(this, 2131764483, 0).show();
            Bxh = System.currentTimeMillis();
          }
          this.Bxc = findViewById(2131299128);
          this.Bxe = findViewById(2131299129);
          this.Bxc.setVisibility(8);
          this.Bxc.setOnTouchListener(new TopStoryFSVideoUI.14(this));
          this.Bxf = ((TopStoryCommentFloatDialog)findViewById(2131298520));
          this.Bxf.setVisibility(8);
          this.Bxf.o(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (epI())
          {
            this.wnu.setImageResource(2131691314);
            if (al.aG(this))
            {
              int i = al.aF(this);
              paramBundle = (RelativeLayout.LayoutParams)this.yJh.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cc.a.fromDPToPix(this, 12));
              this.yJh.setLayoutParams(paramBundle);
            }
          }
          this.Buv.setOnClickListener(new TopStoryFSVideoUI.16(this));
          com.tencent.mm.kernel.g.aiU().a(2802, this.BuY);
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
        this.Bxg = true;
        continue;
        this.BwZ.setVisibility(4);
        this.BwY.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.BrB, getActivityBrowseTimeMs(), this.BuP.Tg(this.BrB.HCk));
    com.tencent.mm.kernel.g.aiU().b(2802, this.BuY);
    this.BuP.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.BrB);
    this.BuO.onUIDestroy();
    this.BuL.onUIDestroy();
    this.BuM.onUIDestroy();
    this.BuN.onUIDestroy();
    this.Bxf.fQT.close();
    com.tencent.mm.plugin.websearch.api.a.a.ma(16);
    if (this.BuF != null) {
      this.BuF.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.Bxf.getVisibility() == 0))
    {
      this.Bxf.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ad.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      doa localdoa = this.BrB;
      if (getSystemVolume() <= 1)
      {
        localdoa.fMP = bool;
        eqr();
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
        this.BrB.fMP = false;
        eqr();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.BuO.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.Bxf.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.ma(15);
    if (this.BuF != null) {
      this.BuF.bgC();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    eqi();
    eqr();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.BuO.onUIResume();
    this.BuL.yzh = com.tencent.mm.plugin.topstory.ui.video.l.ecp();
    this.Bxf.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.ma(14);
    if (this.BuF != null) {
      this.BuF.bgB();
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