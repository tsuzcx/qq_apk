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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.dfc;
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

public class TopStoryFSVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long BOF = 0L;
  protected dox BJa;
  protected View BLR;
  protected ImageView BLS;
  protected View BLT;
  protected RecyclerView BLW;
  private com.tencent.mm.plugin.topstory.ui.a.a BMd;
  protected int BMf;
  protected long BMg;
  protected long BMh;
  private com.tencent.mm.plugin.topstory.ui.video.l BMj;
  private com.tencent.mm.plugin.topstory.ui.video.o BMk;
  private m BMl;
  r BMm;
  com.tencent.mm.plugin.topstory.ui.video.n BMn;
  private boolean BMo;
  protected com.tencent.mm.plugin.topstory.ui.widget.d BMp;
  private boolean BMq;
  protected com.tencent.mm.plugin.topstory.ui.widget.b BMr;
  private aj BMs;
  private com.tencent.mm.ak.f BMw;
  View BOA;
  com.tencent.mm.plugin.topstory.ui.widget.c BOB;
  View BOC;
  TopStoryCommentFloatDialog BOD;
  private boolean BOE;
  protected i BOt;
  protected h BOu;
  private ProgressDialog BOv;
  private View BOw;
  private View BOx;
  private View BOy;
  private Button BOz;
  protected RecyclerView.m fPN;
  private Point htn;
  protected LinearLayoutManager nRC;
  private int videoHeight;
  protected ImageButton wDd;
  protected View yZr;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.fPN = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126332);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        if (paramAnonymousInt2 == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(126332);
          return;
        }
        TopStoryFSVideoUI.this.etT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126332);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(126331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(126331);
          return;
          TopStoryFSVideoUI.this.BOu.b(TopStoryFSVideoUI.this);
        }
      }
    };
    this.BMf = 0;
    this.BMg = -1L;
    this.BMh = -1L;
    this.BMw = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousn;
        paramAnonymousn = (doq)localj.rr.hQD.hQJ;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          t.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131764476), 0).show();
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
            ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.BIY.HWv);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.eto().b(localj.BIY);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.etO().getControlBar()).l(localj.BIY);
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
          localJSONObject.put("docId", paramAnonymousn.Hvr);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousn.gvx != 4) {
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
        if (localj.BIY != null)
        {
          paramAnonymousString = localj.BIY;
          if (paramAnonymousn.gvx != 4) {
            break label498;
          }
        }
        label492:
        label498:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.HWv = bool;
          ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.BIY.HWv), Integer.valueOf(localj.BIY.HWA) });
          if (paramAnonymousn.gvx != 4) {
            break label504;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.eto().b(localj.BIY);
          paramAnonymousn = null;
          paramAnonymousString = paramAnonymousn;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BJb != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BJb.udb != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).BJb.udb.equals(localj.BIY.udb))
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
            TopStoryFSVideoUI.this.a(localj.BIY, paramAnonymousString, true);
            if ((localh instanceof g)) {
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
        label504:
        if (localj.esG().HVy) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131764505), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.BIY, null, false);
          break;
          t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764506, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  private void etP()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.lB(19)) {
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
  
  private boolean etV()
  {
    return (this.BJa.scene != 36) && (!this.BJa.HWb);
  }
  
  @SuppressLint({"ResourceType"})
  private void etY()
  {
    AppMethodBeat.i(126371);
    if (this.BJa.fOX) {
      this.BLS.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.BMm.BNs) {
        this.BMm.setMute(this.BJa.fOX);
      }
      AppMethodBeat.o(126371);
      return;
      this.BLS.setBackgroundResource(2131691328);
    }
  }
  
  private void eut()
  {
    AppMethodBeat.i(126363);
    this.BOx.setVisibility(0);
    this.BOw.setVisibility(0);
    this.BMn.TO(0);
    AppMethodBeat.o(126363);
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  public final boolean Pd()
  {
    return this.BJa.fOX;
  }
  
  public final boolean TE(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.BOA.setVisibility(8);
    ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.BOt.getItemCount();
      int j = this.BOt.getFootersCount();
      int k = this.BOt.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.BLW;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.BOt.getHeadersCount() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(126359);
      return true;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(126359);
    }
    return false;
  }
  
  public final void TF(int paramInt)
  {
    this.BJa.HVX = paramInt;
  }
  
  public final void TG(int paramInt)
  {
    this.BJa.HWa = paramInt;
  }
  
  public final void a(dfc paramdfc) {}
  
  public final void a(dpa paramdpa)
  {
    AppMethodBeat.i(126360);
    if (this.BMd != null) {
      this.BMd.a(this.BJa, paramdpa);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(dpa paramdpa, int paramInt1, int paramInt2) {}
  
  public final void a(dpa paramdpa, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramdpa != null)
    {
      if (!az.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramdpa.tFc;
      if (!paramdpa.HWv) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.BJa.scene;
      String str2 = this.BJa.kid;
      if (!etp()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramdpa, (String)localObject, i, str1, k, str2, j, paramdpa.udb, paramdpa.HWw);
      com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
      if (paramdpa.HWv) {
        break label243;
      }
      bool = true;
      label154:
      paramdpa.HWv = bool;
      if (!paramdpa.HWv) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramdpa.HWA += 1;; paramdpa.HWA -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.TB(paramdpa.HWA));
      ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramdpa.HWv);
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
  
  public final void a(final dpa paramdpa, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdpa.udb, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.BOA.getVisibility() == 0) && (this.BOB != null) && (this.BOB.hCa != null) && (this.BOB.hCa.equals(paramdpa.udb))) {
        this.BOA.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramdpa.tFc;
    String str2 = paramdpa.title;
    String str3 = this.BJa.kid;
    int j = this.BJa.scene;
    if (etp()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramdpa.udb, paramdpa.HWw);
      this.BOA.setVisibility(0);
      this.BOB = new com.tencent.mm.plugin.topstory.ui.widget.c(this.BOC, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.BOD.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void euv()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.BOA.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.BMm.edW();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.BJa.HVS, paramdpa.HWk);
          if (TopStoryFSVideoUI.this.BMm.eul()) {
            TopStoryFSVideoUI.this.BMm.cyX();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramdpa.udb);
      this.BOA.postDelayed(new TopStoryFSVideoUI.11(this), 2000L);
      this.BOB.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(dpa paramdpa, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void aEo(final String paramString)
  {
    AppMethodBeat.i(126375);
    ar.f(new Runnable()
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
  
  public final void aEp(String paramString)
  {
    this.BJa.HVZ = paramString;
  }
  
  public final void at(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
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
        AppMethodBeat.i(126333);
        if (paramAnonymousdpa.HWx != null) {
          TopStoryFSVideoUI.this.au(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.BMp.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(dpa paramAnonymousdpa)
      {
        AppMethodBeat.i(126334);
        p localp = p.BNo;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.etg(), paramAnonymousdpa);
        TopStoryFSVideoUI.this.BMp.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(dpa paramAnonymousdpa)
      {
        AppMethodBeat.i(164128);
        Object localObject = com.tencent.mm.util.c.LDf;
        if (com.tencent.mm.util.c.fSf())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bt(paramAnonymousdpa.udb, paramAnonymousdpa.HWh);
          localObject = TopStoryFSVideoUI.this.etf() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousdpa.title + ".mp4";
          if (com.tencent.mm.vfs.o.fB("/sdcard/video/")) {
            com.tencent.mm.vfs.o.aZI("/sdcard/video/");
          }
          com.tencent.mm.vfs.o.mF((String)localObject, str);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousdpa.title, 0).show();
        }
        AppMethodBeat.o(164128);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126335);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "more popupWindow dismiss");
        if (TopStoryFSVideoUI.e(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.f(TopStoryFSVideoUI.this);
          if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
          {
            AppMethodBeat.o(126335);
            return;
          }
          TopStoryFSVideoUI.this.BMm.edW();
          try
          {
            ((f)TopStoryFSVideoUI.this.BMm.BNr.getControlBar()).bnY();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.BMp.a(paramView, true, 0, 0);
    try
    {
      ((f)this.BMm.BNr.getControlBar()).bTU();
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
    this.BMq = true;
    final dpa localdpa = this.BMn.TN(paramInt);
    this.BMr = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdpa, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.BMm.edW();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.BMm.BNr.getControlBar()).bnY();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
      
      public final void p(Set<alj> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.etg(), localdpa, paramAnonymousSet, TopStoryFSVideoUI.this.BMn.euc());
        TopStoryFSVideoUI.this.BMm.stopPlay();
        TopStoryFSVideoUI.this.BMn.TM(paramInt);
        if (TopStoryFSVideoUI.this.BMn.euc() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.BOt.cl(paramInt + TopStoryFSVideoUI.this.BOt.getHeadersCount());
        TopStoryFSVideoUI.this.BLW.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
    });
    this.BMr.a(paramView, true, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.BMm.BNr.getControlBar()).bTU();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final void diF() {}
  
  public final MMActivity dkN()
  {
    return this;
  }
  
  protected final void etT()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.BOu.a(this);
    this.BMf = this.nRC.ko();
    int j = this.nRC.getItemCount();
    if ((this.BMg <= 0L) || (bu.aO(this.BMg) >= 50L))
    {
      this.BMg = bu.HQ();
      if (this.BMn.BMZ == 1) {
        break label161;
      }
      if ((this.BMf < j - 1) || (this.BMn.BMY) || (bu.aO(this.BMh) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!etV()) {
        i = 0;
      }
      if (i != 0)
      {
        this.BOx.setVisibility(0);
        this.BOw.setVisibility(0);
        this.BMn.TO(this.BMn.euc());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.BMf > 3) || (this.BMn.BMY) || (bu.aO(this.BMh) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public final void eta()
  {
    AppMethodBeat.i(126357);
    this.yZr.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.BOA.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void etb()
  {
    AppMethodBeat.i(126358);
    this.yZr.animate().cancel();
    this.yZr.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.l etd()
  {
    return this.BMj;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.o ete()
  {
    return this.BMk;
  }
  
  public final String etf()
  {
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.aEf(this.BJa.rfA);
    AppMethodBeat.o(126364);
    return str;
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
    AppMethodBeat.i(126367);
    if (this.htn == null) {
      this.htn = al.ck(this);
    }
    Point localPoint = this.htn;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final aj etk()
  {
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
    return this.BOt;
  }
  
  public final boolean etp()
  {
    return this.BJa.HVS == 100203L;
  }
  
  public final void etq()
  {
    AppMethodBeat.i(126380);
    etP();
    AppMethodBeat.o(126380);
  }
  
  public final int etr()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.n ets()
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
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.BOt;
        int i = locali.getFootersCount();
        int j = locali.getItemCount();
        locali.ety();
        locali.as(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int etw()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCY, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void euu()
  {
    AppMethodBeat.i(126370);
    if (this.BJa.fOX)
    {
      this.BJa.fOX = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
      }
    }
    for (;;)
    {
      etY();
      etb();
      eta();
      AppMethodBeat.o(126370);
      return;
      this.BJa.fOX = true;
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (etp())
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
    return this.nRC;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.BLW;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (etp()) {
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
      i = etj().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(etj().x, etj().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.BOE)) {
      eut();
    }
    this.BMm.ip(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void n(List<dpa> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.BOt.o(paramList, paramBoolean);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.BLW.a(0, 3, null);
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
    p.BNo.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.BMj.ciH()) || (com.tencent.mm.plugin.topstory.a.h.esu())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.sQ(false);
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
    this.BJa = new dox();
    try
    {
      this.BJa.parseFrom(paramBundle);
      this.BMn = new com.tencent.mm.plugin.topstory.ui.video.n();
      this.BMn.BLm = this;
      this.BMl = new m();
      this.BMl.d(this);
      this.BMk = new com.tencent.mm.plugin.topstory.ui.video.o();
      this.BMk.d(this);
      this.BMm = new r();
      this.BMm.d(this);
      this.BMj = new com.tencent.mm.plugin.topstory.ui.video.l();
      this.BOu = new h();
      if (this.BJa.HVT != null) {
        this.BMn.h(this.BJa.HVT);
      }
      this.BMd = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.BMd.ac(8, this.BJa.rfA);
      this.BMd.WY(getResources().getString(2131764472));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.BJa.HVV) {
        this.BMj.BMO = true;
      }
      etP();
      this.yZr = findViewById(2131305918);
      this.BLR = findViewById(2131302622);
      this.BLT = findViewById(2131302462);
      this.BLS = ((ImageView)findViewById(2131302624));
      this.wDd = ((ImageButton)findViewById(2131297026));
      this.wDd.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
      this.wDd.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.BLR.setOnClickListener(new TopStoryFSVideoUI.12(this));
      this.BLR.setVisibility(8);
      this.BOy = findViewById(2131300313);
      this.BOz = ((Button)findViewById(2131304375));
      this.BLW = ((RecyclerView)findViewById(2131306389));
      this.BLW.a(this.fPN);
      this.nRC = new LinearLayoutManager();
      this.BLW.setLayoutManager(this.nRC);
      this.BMs = aj.e(this.nRC);
      this.BOt = new i(this);
      paramBundle = this.BOt;
      View localView = LayoutInflater.from(this).inflate(2131495794, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.BOx = localView.findViewById(2131300203);
      this.BOw = localView.findViewById(2131300207);
      paramBundle.fB(localView);
      this.BLW.setAdapter(this.BOt);
      new b().j(this.BLW);
      if (etV()) {
        if (this.BMj.isConnected())
        {
          eut();
          this.BOE = false;
          if ((this.BJa.scene != 21) && (this.BJa.HVU == null)) {
            this.BOv = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new TopStoryFSVideoUI.13(this));
          }
          this.BOt.BOJ = true;
          this.BOy.setVisibility(8);
          if ((this.BMj.eua()) && (com.tencent.mm.plugin.topstory.a.h.esu()) && (System.currentTimeMillis() - BOF > 86400000L))
          {
            Toast.makeText(this, 2131764483, 0).show();
            BOF = System.currentTimeMillis();
          }
          this.BOA = findViewById(2131299128);
          this.BOC = findViewById(2131299129);
          this.BOA.setVisibility(8);
          this.BOA.setOnTouchListener(new TopStoryFSVideoUI.14(this));
          this.BOD = ((TopStoryCommentFloatDialog)findViewById(2131298520));
          this.BOD.setVisibility(8);
          this.BOD.o(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (etp())
          {
            this.wDd.setImageResource(2131691314);
            if (al.aH(this))
            {
              int i = al.aG(this);
              paramBundle = (RelativeLayout.LayoutParams)this.yZr.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cb.a.fromDPToPix(this, 12));
              this.yZr.setLayoutParams(paramBundle);
            }
          }
          this.BLT.setOnClickListener(new TopStoryFSVideoUI.16(this));
          com.tencent.mm.kernel.g.ajj().a(2802, this.BMw);
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
        this.BOE = true;
        continue;
        this.BOx.setVisibility(4);
        this.BOw.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.BJa, getActivityBrowseTimeMs(), this.BMn.TN(this.BJa.HVX));
    com.tencent.mm.kernel.g.ajj().b(2802, this.BMw);
    this.BMn.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.BJa);
    this.BMm.onUIDestroy();
    this.BMj.onUIDestroy();
    this.BMk.onUIDestroy();
    this.BMl.onUIDestroy();
    this.BOD.fSZ.close();
    com.tencent.mm.plugin.websearch.api.a.a.md(16);
    if (this.BMd != null) {
      this.BMd.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.BOD.getVisibility() == 0))
    {
      this.BOD.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dox localdox = this.BJa;
      if (getSystemVolume() <= 1)
      {
        localdox.fOX = bool;
        etY();
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
        ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.BJa.fOX = false;
        etY();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.BMm.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.BOD.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.md(15);
    if (this.BMd != null) {
      this.BMd.bhk();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    etP();
    etY();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.BMm.onUIResume();
    this.BMj.yPh = com.tencent.mm.plugin.topstory.ui.video.l.efW();
    this.BOD.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.md(14);
    if (this.BMd != null) {
      this.BMd.bhj();
    }
    AppMethodBeat.o(126377);
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