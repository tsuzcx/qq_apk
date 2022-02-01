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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.le;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.eso;
import com.tencent.mm.protocal.protobuf.esp;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TopStoryBaseVideoUI
  extends MMSecDataActivity
  implements c, b
{
  protected ImageButton FUI;
  public esv MWu;
  protected long MZA = -1L;
  private i.a MZB = new i.a()
  {
    public final void onOrientationChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.ajH(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  private l MZC;
  public o MZD;
  private m MZE;
  public r MZF;
  protected n MZG;
  private boolean MZH;
  protected com.tencent.mm.plugin.topstory.ui.widget.d MZI;
  private boolean MZJ;
  protected com.tencent.mm.plugin.topstory.ui.widget.b MZK;
  private androidx.recyclerview.widget.u MZL;
  private androidx.recyclerview.widget.u MZM;
  public boolean MZN;
  private j MZO;
  private com.tencent.mm.an.i MZP = new com.tencent.mm.an.i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousq;
      paramAnonymousq = (eso)d.b.b(localj.rr.lBR);
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        Log.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        w.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(c.g.top_story_like_failed), 0).show();
        if (localj.MWs != null)
        {
          paramAnonymousString = localj.MWs;
          if (localj.MWs.Uvi) {
            break label174;
          }
        }
        label174:
        for (bool = true;; bool = false)
        {
          paramAnonymousString.Uvi = bool;
          Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.MWs.Uvi);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.gqH().b(localj.MWs);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.gri();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.grj().getControlBar()).m(localj.MWs);
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
        localJSONObject.put("docId", paramAnonymousq.TPZ);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousq.jUk != 4) {
          break label517;
        }
        bool = true;
        label224:
        localJSONObject.put("isLike", bool);
      }
      catch (JSONException paramAnonymousString)
      {
        label234:
        break label234;
      }
      if (localj.MWs != null)
      {
        paramAnonymousString = localj.MWs;
        if (paramAnonymousq.jUk != 4) {
          break label523;
        }
      }
      label517:
      label523:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.Uvi = bool;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.MWs.Uvi), Integer.valueOf(localj.MWs.Uvm) });
        if (paramAnonymousq.jUk != 4) {
          break label529;
        }
        h localh = TopStoryBaseVideoUI.this.gqH().b(localj.MWs);
        paramAnonymousq = null;
        paramAnonymousString = paramAnonymousq;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).MWv != null)
        {
          paramAnonymousString = paramAnonymousq;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).MWv != null)
          {
            paramAnonymousString = paramAnonymousq;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).MWv.Crh != null)
            {
              paramAnonymousString = paramAnonymousq;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).MWv.Crh.equals(localj.MWs.Crh)) {
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
          TopStoryBaseVideoUI.this.a(localj.MWs, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
            localh.grj().getControlBar().show();
          }
        }
        paramAnonymousString = new le();
        paramAnonymousString.fIS.fIT = localJSONObject.toString();
        paramAnonymousString.fIS.fIU = "";
        EventCenter.instance.publish(paramAnonymousString);
        break;
        bool = false;
        break label224;
      }
      label529:
      if (localj.gqa().Uuo) {
        com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(c.g.top_story_unlike_succ), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.MWs, null, false);
        break;
        w.makeText(TopStoryBaseVideoUI.this.getContext(), c.g.top_story_unlike_succ_2, 0).show();
      }
    }
  };
  protected View MZj;
  protected ImageView MZk;
  protected View MZl;
  protected ImageView MZm;
  protected i MZn;
  protected RecyclerView MZo;
  protected e MZp;
  protected d MZq;
  public RecyclerView MZr;
  protected LinearLayoutManager MZs;
  protected e MZt;
  public d MZu;
  private com.tencent.mm.plugin.topstory.ui.b.a MZv;
  private com.tencent.mm.plugin.topstory.ui.a.a MZw;
  public boolean MZx = true;
  protected int MZy = 0;
  protected long MZz = -1L;
  protected RecyclerView.l iZi = new RecyclerView.l()
  {
    public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(203576);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousRecyclerView);
      localb.sg(paramAnonymousInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      if (!TopStoryBaseVideoUI.this.MZx)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(203576);
        return;
      }
      switch (paramAnonymousInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(203576);
        return;
        if (TopStoryBaseVideoUI.this.MZN) {
          TopStoryBaseVideoUI.this.MZu.b(TopStoryBaseVideoUI.this);
        } else {
          TopStoryBaseVideoUI.this.MZq.b(TopStoryBaseVideoUI.this);
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(203579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousRecyclerView);
      localb.sg(paramAnonymousInt1);
      localb.sg(paramAnonymousInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      if ((!TopStoryBaseVideoUI.this.MZx) || (paramAnonymousInt2 == 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(203579);
        return;
      }
      TopStoryBaseVideoUI.this.gro();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(203579);
    }
  };
  private Point lbY;
  protected TextView mNb;
  private boolean poG = false;
  protected LinearLayoutManager set;
  private int videoHeight;
  protected View wWQ;
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  private void grk()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.qW(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void grt()
  {
    if (this.MWu.iYs) {
      this.MZk.setBackgroundResource(c.f.top_story_volume_off);
    }
    for (;;)
    {
      if (this.MZF.NaM) {
        this.MZF.setMute(this.MWu.iYs);
      }
      return;
      this.MZk.setBackgroundResource(c.f.top_story_volume_on);
    }
  }
  
  private void gru()
  {
    com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
  }
  
  public final void Ai(boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.MZx = paramBoolean;
  }
  
  public final void Aj(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.MWu.iYs = true;
    }
    for (;;)
    {
      grt();
      return;
      this.MWu.iYs = false;
      if (getSystemVolume() == 0) {
        gru();
      }
    }
  }
  
  public final void a(esy paramesy)
  {
    if (!this.MZN)
    {
      this.mNb.setText(c.g.recommend_video_title);
      this.MZm.setVisibility(8);
    }
    if (this.MZv != null) {
      this.MZv.a(this.MWu, paramesy);
    }
    if (this.MZw != null) {
      this.MZw.a(this.MWu, paramesy);
    }
  }
  
  public final void a(esy paramesy, View paramView)
  {
    if (paramesy != null)
    {
      if (!NetStatusUtil.isConnected(this)) {
        Toast.makeText(getContext(), getString(c.g.top_story_like_failed), 0).show();
      }
    }
    else {
      return;
    }
    if (this.MZO != null) {
      com.tencent.mm.kernel.h.aGY().a(this.MZO);
    }
    String str1 = paramesy.BHW;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramesy.Uvi)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.MWu.scene;
      String str3 = this.MWu.jQi;
      if (!gqI()) {
        break label238;
      }
      j = 318;
      this.MZO = new j(paramesy, str1, i, str2, k, str3, j, paramesy.Crh, paramesy.zGJ);
      com.tencent.mm.kernel.h.aGY().a(this.MZO, 0);
      if (paramesy.Uvi) {
        break label246;
      }
      bool = true;
      label163:
      paramesy.Uvi = bool;
      if (!paramesy.Uvi) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramesy.Uvm += 1;; paramesy.Uvm -= 1)
    {
      ((TextView)paramView.findViewById(c.d.wow_icon_text)).setText(com.tencent.mm.plugin.topstory.ui.d.ajw(paramesy.Uvm));
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramesy.Uvi);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(esy paramesy, View paramView, boolean paramBoolean);
  
  public final void aD(final View paramView, final int paramInt)
  {
    if (this.MZF.ehu())
    {
      this.MZF.dmi();
      this.MZH = true;
    }
    esy localesy = this.MZG.ajJ(paramInt);
    this.MZI = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localesy, new d.a()
    {
      public final void e(esy paramAnonymousesy)
      {
        AppMethodBeat.i(126089);
        if (paramAnonymousesy.Uvj != null) {
          TopStoryBaseVideoUI.this.aE(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.MZI.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(esy paramAnonymousesy)
      {
        AppMethodBeat.i(126090);
        p localp = p.NaI;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.gqA(), paramAnonymousesy);
        TopStoryBaseVideoUI.this.MZI.dismiss();
        com.tencent.mm.plugin.report.f.Iyx.a(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(esy paramAnonymousesy)
      {
        AppMethodBeat.i(164124);
        Object localObject = com.tencent.mm.util.i.YyX;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.Yyq, 0) == 1)
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bz(paramAnonymousesy.Crh, paramAnonymousesy.UuV);
          localObject = TopStoryBaseVideoUI.this.gqz() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousesy.title + ".mp4";
          if (com.tencent.mm.vfs.u.agG("/sdcard/video/")) {
            com.tencent.mm.vfs.u.bBD("/sdcard/video/");
          }
          com.tencent.mm.vfs.u.on((String)localObject, str);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousesy.title, 0).show();
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
          TopStoryBaseVideoUI.this.MZF.fLJ();
          if (TopStoryBaseVideoUI.this.MZN) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.MZF.NaL.getControlBar()).bVi();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.MZN) {
      this.MZI.a(paramView, true, 0 - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.MZF.NaL.getControlBar()).cEO();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.f.Iyx.a(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.MZI.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void aE(View paramView, final int paramInt)
  {
    this.MZJ = true;
    final esy localesy = this.MZG.ajJ(paramInt);
    this.MZK = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localesy, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.MZF.fLJ();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.MZN) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.MZF.NaL.getControlBar()).bVi();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
      
      public final void v(Set<aoz> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        w.makeText(TopStoryBaseVideoUI.this.getContext(), c.g.top_story_feedback_unlike_toast, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.gqA(), localesy, paramAnonymousSet, TopStoryBaseVideoUI.this.MZG.grz());
        TopStoryBaseVideoUI.this.MZF.stopPlay();
        TopStoryBaseVideoUI.this.MZG.ajI(paramInt);
        if (TopStoryBaseVideoUI.this.MZG.grz() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.MZN)
        {
          TopStoryBaseVideoUI.this.MZt.cN(paramInt + TopStoryBaseVideoUI.this.MZt.gqR());
          TopStoryBaseVideoUI.this.MZp.alc.notifyChanged();
          TopStoryBaseVideoUI.this.MZr.a(0, 3, null);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.MZp.cN(paramInt + TopStoryBaseVideoUI.this.MZp.gqR());
        TopStoryBaseVideoUI.this.MZt.alc.notifyChanged();
        AppMethodBeat.o(126092);
      }
    });
    if (this.MZN) {
      this.MZK.a(paramView, true, 0 - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.MZF.NaL.getControlBar()).cEO();
      return;
    }
    catch (Exception paramView) {}
    this.MZK.a(paramView, false, 0, 0 - com.tencent.mm.ci.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final boolean aeg()
  {
    return this.MWu.iYs;
  }
  
  public final void ajB(int paramInt)
  {
    this.MWu.UuM = paramInt;
  }
  
  public final void ajC(int paramInt)
  {
    this.MWu.UuP = paramInt;
  }
  
  protected void ajH(int paramInt) {}
  
  protected void ata()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.MWu = new esv();
    try
    {
      this.MWu.parseFrom(arrayOfByte);
      this.MZG = new n();
      this.MZG.MYE = this;
      this.MZE = new m();
      this.MZE.d(this);
      this.MZD = new o();
      this.MZD.d(this);
      this.MZF = new r();
      this.MZF.d(this);
      this.MZC = new l();
      this.MZq = grm();
      this.MZu = grn();
      this.MZw = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.MZw.I(8, this.MWu.wmL);
      this.MZw.aoy(getResources().getString(c.g.top_story_float_ball_title));
      this.MZv = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.MZv.I(8, this.MWu.wmL);
      this.MZv.aMT(getResources().getString(c.g.top_story_float_ball_title));
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
  
  public void bfc(String paramString) {}
  
  public final void bfd(String paramString)
  {
    this.MWu.UuO = paramString;
  }
  
  public final boolean cne()
  {
    return this.MZN;
  }
  
  public final Point dpI()
  {
    if (this.lbY == null) {
      this.lbY = ar.au(this);
    }
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.lbY.x), Integer.valueOf(this.lbY.y) });
    return this.lbY;
  }
  
  public final MMActivity eOa()
  {
    return this;
  }
  
  public final RecyclerView.LayoutManager getLayoutManager()
  {
    if (this.MZN) {
      return this.MZs;
    }
    return this.set;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.MZN) {
      return this.MZr;
    }
    return this.MZo;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (gqI()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = dpI().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(dpI().x, dpI().y);
  }
  
  public final esv gqA()
  {
    return this.MWu;
  }
  
  public final m gqB()
  {
    return this.MZE;
  }
  
  public final r gqC()
  {
    return this.MZF;
  }
  
  public final androidx.recyclerview.widget.u gqD()
  {
    if (this.MZN) {
      return this.MZM;
    }
    return this.MZL;
  }
  
  public final int gqE()
  {
    return this.MWu.UuM;
  }
  
  public final boolean gqF()
  {
    return this.MWu.scene != 36;
  }
  
  public final boolean gqG()
  {
    return this.MWu.scene != 326;
  }
  
  public final e gqH()
  {
    if (this.MZN) {
      return this.MZt;
    }
    return this.MZp;
  }
  
  public final boolean gqI()
  {
    return this.MWu.UuH == 100203L;
  }
  
  public final void gqJ()
  {
    grk();
  }
  
  public int gqK()
  {
    return com.tencent.mm.plugin.topstory.ui.a.MWy;
  }
  
  public final n gqL()
  {
    return this.MZG;
  }
  
  public final String gqM()
  {
    if (this.MWu.UuO == null) {
      return "";
    }
    return this.MWu.UuO;
  }
  
  public final int gqN()
  {
    return this.MWu.UuP;
  }
  
  public final void gqO()
  {
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.gqS();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.gqT();
        paramAnonymouse.aH(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.MZp);
        a(TopStoryBaseVideoUI.this.MZt);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public void gqu() {}
  
  public void gqv() {}
  
  public final l gqx()
  {
    return this.MZC;
  }
  
  public final o gqy()
  {
    return this.MZD;
  }
  
  public final String gqz()
  {
    return com.tencent.mm.plugin.topstory.a.h.beT(this.MWu.wmL);
  }
  
  protected void grl() {}
  
  protected abstract d grm();
  
  protected abstract d grn();
  
  protected void gro()
  {
    int j = 0;
    int i;
    if (this.MZN)
    {
      this.MZu.a(this);
      this.MZy = ((LinearLayoutManager)getLayoutManager()).kL();
      i = getLayoutManager().getItemCount();
      if ((this.MZz <= 0L) || (Util.ticksToNow(this.MZz) >= 50L))
      {
        this.MZz = Util.currentTicks();
        if (this.MZG.Nar == 1) {
          break label145;
        }
        if ((this.MZy < i - 1) || (this.MZG.MTh) || (Util.ticksToNow(this.MZA) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!grq()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          grp();
        }
        return;
        this.MZq.a(this);
        break;
        label145:
        if ((i - this.MZy > 3) || (this.MZG.MTh) || (Util.ticksToNow(this.MZA) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void grp()
  {
    this.MZA = Util.currentTicks();
  }
  
  protected final boolean grq()
  {
    return (this.MWu.scene != 36) && (!this.MWu.UuQ);
  }
  
  protected abstract e grr();
  
  protected abstract e grs();
  
  public final com.tencent.mm.plugin.topstory.ui.b.a grv()
  {
    return this.MZv;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.a.a grw()
  {
    return this.MZw;
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    grk();
    this.wWQ = findViewById(c.d.title_container);
    this.mNb = ((TextView)findViewById(c.d.title_tv));
    this.MZm = ((ImageView)findViewById(c.d.source_iv));
    this.MZj = findViewById(c.d.mute_click_area);
    this.MZk = ((ImageView)findViewById(c.d.mute_iv));
    this.MZl = findViewById(c.d.more_click_area);
    this.FUI = ((ImageButton)findViewById(c.d.back_btn));
    this.FUI.getDrawable().setColorFilter(getResources().getColor(c.a.White), PorterDuff.Mode.SRC_ATOP);
    this.FUI.setOnClickListener(new TopStoryBaseVideoUI.1(this));
    this.MZj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.MWu.iYs) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.Aj(bool);
          paramAnonymousView.gqv();
          paramAnonymousView.gqu();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.MZj.setVisibility(8);
    this.MZo = ((RecyclerView)findViewById(c.d.video_recycle_view));
    this.MZo.a(this.iZi);
    this.MZo.setItemAnimator(new a((byte)0));
    this.set = new LinearLayoutManager();
    this.MZo.setLayoutManager(this.set);
    this.MZL = androidx.recyclerview.widget.u.e(this.set);
    this.MZp = grr();
    this.MZo.setAdapter(this.MZp);
    this.MZr = ((RecyclerView)findViewById(c.d.fs_video_recycle_view));
    this.MZr.a(this.iZi);
    this.MZr.setItemAnimator(new a((byte)0));
    this.MZs = new LinearLayoutManager();
    this.MZr.setLayoutManager(this.MZs);
    this.MZM = androidx.recyclerview.widget.u.e(this.MZs);
    this.MZt = grs();
    this.MZr.setAdapter(this.MZt);
    this.MZr.setVisibility(8);
    if ((!this.poG) && (!gqI()))
    {
      this.MZn = new i(getApplicationContext());
      this.MZn.enable();
      this.MZn.MZW = this.MZB;
      this.poG = true;
    }
    if (this.MWu.iYs) {
      Aj(this.MWu.iYs);
    }
    this.MZC.Nai = this;
    this.MZl.setOnClickListener(new TopStoryBaseVideoUI.6(this));
  }
  
  public void ky(int paramInt1, int paramInt2)
  {
    this.MZF.kB(paramInt1, paramInt2);
  }
  
  public void onBackPressed()
  {
    grl();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ata();
    initContentView();
    com.tencent.mm.kernel.h.aGY().a(2802, this.MZP);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.i.a(this.MWu, getActivityBrowseTimeMs(), this.MZG.ajJ(this.MWu.UuM));
    if (this.poG)
    {
      this.MZn.disable();
      this.MZn.MZW = null;
      this.MZn = null;
    }
    if (this.MZO != null) {
      com.tencent.mm.kernel.h.aGY().a(this.MZO);
    }
    com.tencent.mm.kernel.h.aGY().b(2802, this.MZP);
    this.MZG.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.MWu);
    this.MZF.onUIDestroy();
    this.MZC.onUIDestroy();
    this.MZD.onUIDestroy();
    this.MZE.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.rE(16);
    if (this.MZw != null) {
      this.MZw.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      esv localesv = this.MWu;
      if (getSystemVolume() <= 1)
      {
        localesv.iYs = bool;
        grt();
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
        this.MWu.iYs = false;
        grt();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.MZF.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.rE(15);
      if (this.MZv != null) {
        this.MZv.aOj();
      }
      if (this.MZw != null) {
        this.MZw.aOj();
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
    grk();
    grt();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.MZF.onUIResume();
    this.MZC.IYy = l.fWI();
    com.tencent.mm.plugin.websearch.api.a.a.rE(14);
    if (this.MZv != null) {
      this.MZv.bNV();
    }
    if (this.MZw != null) {
      this.MZw.bNV();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void t(final List<esy> paramList, final boolean paramBoolean)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.MZN)
        {
          TopStoryBaseVideoUI.this.MZt.u(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.MZp.alc.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.MZp.u(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.MZt.alc.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  final class a
    extends androidx.recyclerview.widget.g
  {
    private a() {}
    
    public final void G(RecyclerView.v paramv)
    {
      AppMethodBeat.i(205375);
      super.G(paramv);
      TopStoryBaseVideoUI.this.gro();
      TopStoryBaseVideoUI.this.MZq.b(TopStoryBaseVideoUI.this);
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.md()) });
      AppMethodBeat.o(205375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */