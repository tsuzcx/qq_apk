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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.aj;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dyi;
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

public class TopStoryFSVideoUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long Gpm = 0L;
  protected ImageButton AnC;
  protected eit GjJ;
  protected RecyclerView GmC;
  private com.tencent.mm.plugin.topstory.ui.multitask.a GmJ;
  protected int GmL;
  protected long GmM;
  protected long GmN;
  private l GmP;
  private o GmQ;
  private m GmR;
  r GmS;
  n GmT;
  private boolean GmU;
  protected com.tencent.mm.plugin.topstory.ui.widget.d GmV;
  private boolean GmW;
  protected com.tencent.mm.plugin.topstory.ui.widget.b GmX;
  private aj GmY;
  protected View Gmx;
  protected ImageView Gmy;
  protected View Gmz;
  private com.tencent.mm.ak.i Gnc;
  protected i Gpa;
  protected h Gpb;
  private ProgressDialog Gpc;
  private View Gpd;
  private View Gpe;
  private View Gpf;
  private Button Gpg;
  View Gph;
  com.tencent.mm.plugin.topstory.ui.widget.c Gpi;
  View Gpj;
  TopStoryCommentFloatDialog Gpk;
  private boolean Gpl;
  private com.tencent.mm.plugin.topstory.ui.b.a Utu;
  protected RecyclerView.l guX;
  private Point imX;
  protected LinearLayoutManager pcs;
  protected View tql;
  private int videoHeight;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(126331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(126331);
          return;
          TopStoryFSVideoUI.this.Gpb.b(TopStoryFSVideoUI.this);
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126332);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        if (paramAnonymousInt2 == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(126332);
          return;
        }
        TopStoryFSVideoUI.this.fzp();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126332);
      }
    };
    this.GmL = 0;
    this.GmM = -1L;
    this.GmN = -1L;
    this.Gnc = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousq;
        paramAnonymousq = (eim)localj.rr.iLK.iLR;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          u.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131766820), 0).show();
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
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.GjH.NiC);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.fyK().b(localj.GjH);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.fzk().getControlBar()).m(localj.GjH);
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
          localJSONObject.put("docId", paramAnonymousq.MEq);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousq.him != 4) {
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
        if (localj.GjH != null)
        {
          paramAnonymousString = localj.GjH;
          if (paramAnonymousq.him != 4) {
            break label498;
          }
        }
        label492:
        label498:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.NiC = bool;
          Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.GjH.NiC), Integer.valueOf(localj.GjH.NiH) });
          if (paramAnonymousq.him != 4) {
            break label504;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.fyK().b(localj.GjH);
          paramAnonymousq = null;
          paramAnonymousString = paramAnonymousq;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).GjK != null)
          {
            paramAnonymousString = paramAnonymousq;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).GjK.psI != null)
            {
              paramAnonymousString = paramAnonymousq;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).GjK.psI.equals(localj.GjH.psI))
              {
                paramAnonymousString = paramAnonymousq;
                if ((localh instanceof g)) {
                  paramAnonymousString = localh.getWowView();
                }
              }
            }
          }
          if (paramAnonymousString != null)
          {
            TopStoryFSVideoUI.this.a(localj.GjH, paramAnonymousString, true);
            if ((localh instanceof g)) {
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
        label504:
        if (localj.fye().NhI) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131766849), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.GjH, null, false);
          break;
          u.makeText(TopStoryFSVideoUI.this.getContext(), 2131766850, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  private void fzO()
  {
    AppMethodBeat.i(126363);
    this.Gpe.setVisibility(0);
    this.Gpd.setVisibility(0);
    this.GmT.ace(0);
    AppMethodBeat.o(126363);
  }
  
  private void fzl()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.oE(19)) {
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
  
  private boolean fzr()
  {
    return (this.GjJ.scene != 36) && (!this.GjJ.Nik);
  }
  
  @SuppressLint({"ResourceType"})
  private void fzu()
  {
    AppMethodBeat.i(126371);
    if (this.GjJ.guh) {
      this.Gmy.setBackgroundResource(2131691659);
    }
    for (;;)
    {
      if (this.GmS.GnZ) {
        this.GmS.setMute(this.GjJ.guh);
      }
      AppMethodBeat.o(126371);
      return;
      this.Gmy.setBackgroundResource(2131691660);
    }
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  public final void KC() {}
  
  public final boolean Zx()
  {
    return this.GjJ.guh;
  }
  
  public final void a(dyi paramdyi) {}
  
  public final void a(eiw parameiw)
  {
    AppMethodBeat.i(126360);
    if (this.GmJ != null) {
      this.GmJ.a(this.GjJ, parameiw);
    }
    if (this.Utu != null) {
      this.Utu.a(this.GjJ, parameiw);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(eiw parameiw, int paramInt1, int paramInt2) {}
  
  public final void a(eiw parameiw, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (parameiw != null)
    {
      if (!NetStatusUtil.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131766820), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = parameiw.wWb;
      if (!parameiw.NiC) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.GjJ.scene;
      String str2 = this.GjJ.hes;
      if (!fyL()) {
        break label235;
      }
      j = 318;
      localObject = new j(parameiw, (String)localObject, i, str1, k, str2, j, parameiw.psI, parameiw.NiD);
      com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
      if (parameiw.NiC) {
        break label243;
      }
      bool = true;
      label154:
      parameiw.NiC = bool;
      if (!parameiw.NiC) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (parameiw.NiH += 1;; parameiw.NiH -= 1)
    {
      ((TextView)paramView.findViewById(2131310541)).setText(com.tencent.mm.plugin.topstory.ui.c.abR(parameiw.NiH));
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + parameiw.NiC);
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
  
  public final void a(final eiw parameiw, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { parameiw.psI, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.Gph.getVisibility() == 0) && (this.Gpi != null) && (this.Gpi.vid != null) && (this.Gpi.vid.equals(parameiw.psI))) {
        this.Gph.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = parameiw.wWb;
    String str2 = parameiw.title;
    String str3 = this.GjJ.hes;
    int j = this.GjJ.scene;
    if (fyL()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, parameiw.psI, parameiw.NiD);
      this.Gph.setVisibility(0);
      this.Gpi = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Gpj, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.Gpk.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void fzQ()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.Gph.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.GmS.eYd();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.GjJ.Nib, parameiw.Nis);
          if (TopStoryFSVideoUI.this.GmS.dFG()) {
            TopStoryFSVideoUI.this.GmS.cXa();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, parameiw.psI);
      this.Gph.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126346);
          if (TopStoryFSVideoUI.this.Gph.getVisibility() == 0) {
            TopStoryFSVideoUI.this.Gph.setVisibility(8);
          }
          AppMethodBeat.o(126346);
        }
      }, 2000L);
      this.Gpi.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(eiw parameiw, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void aTE(final String paramString)
  {
    AppMethodBeat.i(126375);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final void aTF(String paramString)
  {
    this.GjJ.Nii = paramString;
  }
  
  public final boolean abU(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.Gph.setVisibility(8);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.Gpa.getItemCount();
      int j = this.Gpa.getFootersCount();
      int k = this.Gpa.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.GmC;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.Gpa.getHeadersCount() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(126359);
      return true;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(126359);
    }
    return false;
  }
  
  public final void abV(int paramInt)
  {
    this.GjJ.Nig = paramInt;
  }
  
  public final void abW(int paramInt)
  {
    this.GjJ.Nij = paramInt;
  }
  
  public final void ay(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
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
        AppMethodBeat.i(126333);
        if (paramAnonymouseiw.NiE != null) {
          TopStoryFSVideoUI.this.az(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.GmV.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(eiw paramAnonymouseiw)
      {
        AppMethodBeat.i(126334);
        p localp = p.GnV;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.fyD(), paramAnonymouseiw);
        TopStoryFSVideoUI.this.GmV.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(eiw paramAnonymouseiw)
      {
        AppMethodBeat.i(164128);
        Object localObject = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hde())
        {
          localObject = com.tencent.mm.plugin.topstory.ui.c.bu(paramAnonymouseiw.psI, paramAnonymouseiw.Nip);
          localObject = TopStoryFSVideoUI.this.fyC() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymouseiw.title + ".mp4";
          if (s.YS("/sdcard/video/")) {
            s.boN("/sdcard/video/");
          }
          s.nw((String)localObject, str);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymouseiw.title, 0).show();
        }
        AppMethodBeat.o(164128);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126335);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "more popupWindow dismiss");
        if (TopStoryFSVideoUI.e(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.f(TopStoryFSVideoUI.this);
          if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
          {
            AppMethodBeat.o(126335);
            return;
          }
          TopStoryFSVideoUI.this.GmS.eYd();
          try
          {
            ((f)TopStoryFSVideoUI.this.GmS.GnY.getControlBar()).bJB();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.GmV.a(paramView, true, 0, 0);
    try
    {
      ((f)this.GmS.GnY.getControlBar()).crH();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void az(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.GmW = true;
    final eiw localeiw = this.GmT.acd(paramInt);
    this.GmX = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localeiw, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.GmS.eYd();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.GmS.GnY.getControlBar()).bJB();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
      
      public final void v(Set<any> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        u.makeText(TopStoryFSVideoUI.this.getContext(), 2131766815, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.fyD(), localeiw, paramAnonymousSet, TopStoryFSVideoUI.this.GmT.fzy());
        TopStoryFSVideoUI.this.GmS.stopPlay();
        TopStoryFSVideoUI.this.GmT.acc(paramInt);
        if (TopStoryFSVideoUI.this.GmT.fzy() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.Gpa.ck(paramInt + TopStoryFSVideoUI.this.Gpa.getHeadersCount());
        TopStoryFSVideoUI.this.GmC.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
    });
    this.GmX.a(paramView, true, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.GmS.GnY.getControlBar()).crH();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final Point cZM()
  {
    AppMethodBeat.i(126367);
    if (this.imX == null) {
      this.imX = ao.az(this);
    }
    Point localPoint = this.imX;
    AppMethodBeat.o(126367);
    return localPoint;
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
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.aTv(this.GjJ.sGQ);
    AppMethodBeat.o(126364);
    return str;
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
    return this.Gpa;
  }
  
  public final boolean fyL()
  {
    return this.GjJ.Nib == 100203L;
  }
  
  public final void fyM()
  {
    AppMethodBeat.i(126380);
    fzl();
    AppMethodBeat.o(126380);
  }
  
  public final int fyN()
  {
    return 0;
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
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.Gpa;
        int i = locali.getFootersCount();
        int j = locali.getItemCount();
        locali.fyU();
        locali.at(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int fyS()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rVR, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void fyx()
  {
    AppMethodBeat.i(126357);
    this.tql.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.Gph.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void fyy()
  {
    AppMethodBeat.i(126358);
    this.tql.animate().cancel();
    this.tql.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final void fzP()
  {
    AppMethodBeat.i(126370);
    if (this.GjJ.guh)
    {
      this.GjJ.guh = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
      }
    }
    for (;;)
    {
      fzu();
      fyy();
      fyx();
      AppMethodBeat.o(126370);
      return;
      this.GjJ.guh = true;
    }
  }
  
  protected final void fzp()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.Gpb.a(this);
    this.GmL = this.pcs.ku();
    int j = this.pcs.getItemCount();
    if ((this.GmM <= 0L) || (Util.ticksToNow(this.GmM) >= 50L))
    {
      this.GmM = Util.currentTicks();
      if (this.GmT.GnE == 1) {
        break label161;
      }
      if ((this.GmL < j - 1) || (this.GmT.GhN) || (Util.ticksToNow(this.GmN) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!fzr()) {
        i = 0;
      }
      if (i != 0)
      {
        this.Gpe.setVisibility(0);
        this.Gpd.setVisibility(0);
        this.GmT.ace(this.GmT.fzy());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.GmL > 3) || (this.GmT.GhN) || (Util.ticksToNow(this.GmN) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (fyL())
    {
      AppMethodBeat.o(126361);
      return 1;
    }
    AppMethodBeat.o(126361);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131496740;
  }
  
  public final RecyclerView.LayoutManager getLayoutManager()
  {
    return this.pcs;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.GmC;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (fyL()) {
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
      i = cZM().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(cZM().x, cZM().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void jm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Gpl)) {
      fzO();
    }
    this.GmS.jp(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126362);
    p.GnV.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.GmP.cGF()) || (ai.isFreeSimCard())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.wu(false);
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
    this.GjJ = new eit();
    try
    {
      this.GjJ.parseFrom(paramBundle);
      this.GmT = new n();
      this.GmT.GlS = this;
      this.GmR = new m();
      this.GmR.d(this);
      this.GmQ = new o();
      this.GmQ.d(this);
      this.GmS = new r();
      this.GmS.d(this);
      this.GmP = new l();
      this.Gpb = new h();
      if (this.GjJ.Nic != null) {
        this.GmT.h(this.GjJ.Nic);
      }
      this.Utu = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.Utu.G(8, this.GjJ.sGQ);
      this.Utu.agT(getResources().getString(2131766816));
      this.GmJ = new com.tencent.mm.plugin.topstory.ui.multitask.a(new com.tencent.mm.plugin.topstory.ui.multitask.b(this));
      this.GmJ.G(8, this.GjJ.sGQ);
      this.GmJ.aCM(getResources().getString(2131766816));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.GjJ.Nie) {
        this.GmP.Gnu = true;
      }
      fzl();
      this.tql = findViewById(2131309214);
      this.Gmx = findViewById(2131305119);
      this.Gmz = findViewById(2131304871);
      this.Gmy = ((ImageView)findViewById(2131305122));
      this.AnC = ((ImageButton)findViewById(2131297163));
      this.AnC.getDrawable().setColorFilter(getResources().getColor(2131099844), PorterDuff.Mode.SRC_ATOP);
      this.AnC.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.Gmx.setOnClickListener(new TopStoryFSVideoUI.12(this));
      this.Gmx.setVisibility(8);
      this.Gpf = findViewById(2131301805);
      this.Gpg = ((Button)findViewById(2131307338));
      this.GmC = ((RecyclerView)findViewById(2131309818));
      this.GmC.a(this.guX);
      this.pcs = new LinearLayoutManager();
      this.GmC.setLayoutManager(this.pcs);
      this.GmY = aj.e(this.pcs);
      this.Gpa = new i(this);
      paramBundle = this.Gpa;
      View localView = LayoutInflater.from(this).inflate(2131496752, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.Gpe = localView.findViewById(2131301672);
      this.Gpd = localView.findViewById(2131301676);
      paramBundle.fT(localView);
      this.GmC.setAdapter(this.Gpa);
      new b().f(this.GmC);
      if (fzr()) {
        if (this.GmP.isConnected())
        {
          fzO();
          this.Gpl = false;
          if ((this.GjJ.scene != 21) && (this.GjJ.Nid == null)) {
            this.Gpc = com.tencent.mm.ui.base.h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(126348);
                TopStoryFSVideoUI.this.finish();
                AppMethodBeat.o(126348);
              }
            });
          }
          this.Gpa.Gpq = true;
          this.Gpf.setVisibility(8);
          if ((this.GmP.fzw()) && (ai.isFreeSimCard()) && (System.currentTimeMillis() - Gpm > 86400000L))
          {
            Toast.makeText(this, 2131766827, 0).show();
            Gpm = System.currentTimeMillis();
          }
          this.Gph = findViewById(2131299653);
          this.Gpj = findViewById(2131299654);
          this.Gph.setVisibility(8);
          this.Gph.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(126349);
              if (TopStoryFSVideoUI.this.Gph.getVisibility() == 0)
              {
                float f1 = paramAnonymousMotionEvent.getX();
                float f2 = paramAnonymousMotionEvent.getY();
                if (TopStoryFSVideoUI.h(TopStoryFSVideoUI.this.Gpj, f1, f2))
                {
                  Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                  AppMethodBeat.o(126349);
                  return false;
                }
                TopStoryFSVideoUI.this.Gph.setVisibility(8);
              }
              AppMethodBeat.o(126349);
              return false;
            }
          });
          this.Gpk = ((TopStoryCommentFloatDialog)findViewById(2131298946));
          this.Gpk.setVisibility(8);
          this.Gpk.o(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (fyL())
          {
            this.AnC.setImageResource(2131691646);
            if (ao.aQ(this))
            {
              int i = ao.aP(this);
              paramBundle = (RelativeLayout.LayoutParams)this.tql.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cb.a.fromDPToPix(this, 12));
              this.tql.setLayoutParams(paramBundle);
            }
          }
          this.Gmz.setOnClickListener(new TopStoryFSVideoUI.16(this));
          com.tencent.mm.kernel.g.azz().a(2802, this.Gnc);
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
        Toast.makeText(this, 2131764252, 1).show();
        this.Gpl = true;
        continue;
        this.Gpe.setVisibility(4);
        this.Gpd.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.GjJ, getActivityBrowseTimeMs(), this.GmT.acd(this.GjJ.Nig));
    com.tencent.mm.kernel.g.azz().b(2802, this.Gnc);
    this.GmT.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.GjJ);
    this.GmS.onUIDestroy();
    this.GmP.onUIDestroy();
    this.GmQ.onUIDestroy();
    this.GmR.onUIDestroy();
    this.Gpk.gyh.close();
    com.tencent.mm.plugin.websearch.api.a.a.pl(16);
    if (this.Utu != null) {
      this.Utu.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.Gpk.getVisibility() == 0))
    {
      this.Gpk.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      eit localeit = this.GjJ;
      if (getSystemVolume() <= 1)
      {
        localeit.guh = bool;
        fzu();
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
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.GjJ.guh = false;
        fzu();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.GmS.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.Gpk.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.pl(15);
    if (this.GmJ != null) {
      this.GmJ.aGj();
    }
    if (this.Utu != null) {
      this.Utu.aGj();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    fzl();
    fzu();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.GmS.onUIResume();
    this.GmP.CTg = l.fiw();
    this.Gpk.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.pl(14);
    if (this.GmJ != null) {
      this.GmJ.bCA();
    }
    if (this.Utu != null) {
      this.Utu.bCA();
    }
    AppMethodBeat.o(126377);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(List<eiw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.Gpa.t(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.GmC.a(0, 3, null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */