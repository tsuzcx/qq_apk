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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.le;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.eij;
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

public class TopStoryFSVideoUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long NbY = 0L;
  protected ImageButton FUI;
  protected esv MWu;
  protected long MZA;
  private l MZC;
  private o MZD;
  private m MZE;
  r MZF;
  n MZG;
  private boolean MZH;
  protected com.tencent.mm.plugin.topstory.ui.widget.d MZI;
  private boolean MZJ;
  protected com.tencent.mm.plugin.topstory.ui.widget.b MZK;
  private androidx.recyclerview.widget.u MZL;
  private com.tencent.mm.an.i MZP;
  protected View MZj;
  protected ImageView MZk;
  protected View MZl;
  protected RecyclerView MZo;
  private com.tencent.mm.plugin.topstory.ui.b.a MZv;
  private com.tencent.mm.plugin.topstory.ui.a.a MZw;
  protected int MZy;
  protected long MZz;
  protected i NbM;
  protected h NbN;
  private ProgressDialog NbO;
  private View NbP;
  private View NbQ;
  private View NbR;
  private Button NbS;
  View NbT;
  com.tencent.mm.plugin.topstory.ui.widget.c NbU;
  View NbV;
  TopStoryCommentFloatDialog NbW;
  private boolean NbX;
  protected RecyclerView.l iZi;
  private Point lbY;
  protected LinearLayoutManager set;
  private int videoHeight;
  protected View wWQ;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.iZi = new TopStoryFSVideoUI.3(this);
    this.MZy = 0;
    this.MZz = -1L;
    this.MZA = -1L;
    this.MZP = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousq;
        paramAnonymousq = (eso)d.b.b(localj.rr.lBR);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          w.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(c.g.top_story_like_failed), 0).show();
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
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.MWs.Uvi);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.gqH().b(localj.MWs);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.grj().getControlBar()).m(localj.MWs);
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
          localJSONObject.put("docId", paramAnonymousq.TPZ);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousq.jUk != 4) {
            break label493;
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
            break label499;
          }
        }
        label493:
        label499:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.Uvi = bool;
          Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.MWs.Uvi), Integer.valueOf(localj.MWs.Uvm) });
          if (paramAnonymousq.jUk != 4) {
            break label505;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.gqH().b(localj.MWs);
          paramAnonymousq = null;
          paramAnonymousString = paramAnonymousq;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).MWv != null)
          {
            paramAnonymousString = paramAnonymousq;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).MWv.Crh != null)
            {
              paramAnonymousString = paramAnonymousq;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).MWv.Crh.equals(localj.MWs.Crh))
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
            TopStoryFSVideoUI.this.a(localj.MWs, paramAnonymousString, true);
            if ((localh instanceof g)) {
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
        label505:
        if (localj.gqa().Uuo) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(c.g.top_story_unlike_succ), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.MWs, null, false);
          break;
          w.makeText(TopStoryFSVideoUI.this.getContext(), c.g.top_story_unlike_succ_2, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  private void grP()
  {
    AppMethodBeat.i(126363);
    this.NbQ.setVisibility(0);
    this.NbP.setVisibility(0);
    this.MZG.ajK(0);
    AppMethodBeat.o(126363);
  }
  
  private void grk()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.qW(19)) {
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
  
  private boolean grq()
  {
    return (this.MWu.scene != 36) && (!this.MWu.UuQ);
  }
  
  @SuppressLint({"ResourceType"})
  private void grt()
  {
    AppMethodBeat.i(126371);
    if (this.MWu.iYs) {
      this.MZk.setBackgroundResource(c.f.top_story_volume_off);
    }
    for (;;)
    {
      if (this.MZF.NaM) {
        this.MZF.setMute(this.MWu.iYs);
      }
      AppMethodBeat.o(126371);
      return;
      this.MZk.setBackgroundResource(c.f.top_story_volume_on);
    }
  }
  
  public final void Np() {}
  
  public final void a(eij parameij) {}
  
  public final void a(esy paramesy)
  {
    AppMethodBeat.i(126360);
    if (this.MZv != null) {
      this.MZv.a(this.MWu, paramesy);
    }
    if (this.MZw != null) {
      this.MZw.a(this.MWu, paramesy);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(esy paramesy, int paramInt1, int paramInt2) {}
  
  public final void a(esy paramesy, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramesy != null)
    {
      if (!NetStatusUtil.isConnected(this))
      {
        Toast.makeText(getContext(), getString(c.g.top_story_like_failed), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramesy.BHW;
      if (!paramesy.Uvi) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.MWu.scene;
      String str2 = this.MWu.jQi;
      if (!gqI()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramesy, (String)localObject, i, str1, k, str2, j, paramesy.Crh, paramesy.zGJ);
      com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
      if (paramesy.Uvi) {
        break label243;
      }
      bool = true;
      label154:
      paramesy.Uvi = bool;
      if (!paramesy.Uvi) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramesy.Uvm += 1;; paramesy.Uvm -= 1)
    {
      ((TextView)paramView.findViewById(c.d.wow_icon_text)).setText(com.tencent.mm.plugin.topstory.ui.d.ajw(paramesy.Uvm));
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramesy.Uvi);
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
  
  public final void a(final esy paramesy, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramesy.Crh, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.NbT.getVisibility() == 0) && (this.NbU != null) && (this.NbU.vid != null) && (this.NbU.vid.equals(paramesy.Crh))) {
        this.NbT.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramesy.BHW;
    String str2 = paramesy.title;
    String str3 = this.MWu.jQi;
    int j = this.MWu.scene;
    if (gqI()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramesy.Crh, paramesy.zGJ);
      this.NbT.setVisibility(0);
      this.NbU = new com.tencent.mm.plugin.topstory.ui.widget.c(this.NbV, new com.tencent.mm.plugin.topstory.ui.widget.c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.NbW.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void grR()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.NbT.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.MZF.fLJ();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.MWu.UuH, paramesy.UuY);
          if (TopStoryFSVideoUI.this.MZF.ehu()) {
            TopStoryFSVideoUI.this.MZF.dmi();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramesy.Crh);
      this.NbT.postDelayed(new TopStoryFSVideoUI.11(this), 2000L);
      this.NbU.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(esy paramesy, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void aD(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
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
        AppMethodBeat.i(126333);
        if (paramAnonymousesy.Uvj != null) {
          TopStoryFSVideoUI.this.aE(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.MZI.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(esy paramAnonymousesy)
      {
        AppMethodBeat.i(126334);
        p localp = p.NaI;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.gqA(), paramAnonymousesy);
        TopStoryFSVideoUI.this.MZI.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(esy paramAnonymousesy)
      {
        AppMethodBeat.i(164128);
        Object localObject = com.tencent.mm.util.i.YyX;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.Yyq, 0) == 1)
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bz(paramAnonymousesy.Crh, paramAnonymousesy.UuV);
          localObject = TopStoryFSVideoUI.this.gqz() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousesy.title + ".mp4";
          if (com.tencent.mm.vfs.u.agG("/sdcard/video/")) {
            com.tencent.mm.vfs.u.bBD("/sdcard/video/");
          }
          com.tencent.mm.vfs.u.on((String)localObject, str);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousesy.title, 0).show();
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
          TopStoryFSVideoUI.this.MZF.fLJ();
          try
          {
            ((f)TopStoryFSVideoUI.this.MZF.NaL.getControlBar()).bVi();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.MZI.a(paramView, true, 0, 0);
    try
    {
      ((f)this.MZF.NaL.getControlBar()).cEO();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void aE(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.MZJ = true;
    final esy localesy = this.MZG.ajJ(paramInt);
    this.MZK = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localesy, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.MZF.fLJ();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.MZF.NaL.getControlBar()).bVi();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
      
      public final void v(Set<aoz> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        w.makeText(TopStoryFSVideoUI.this.getContext(), c.g.top_story_feedback_unlike_toast, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.gqA(), localesy, paramAnonymousSet, TopStoryFSVideoUI.this.MZG.grz());
        TopStoryFSVideoUI.this.MZF.stopPlay();
        TopStoryFSVideoUI.this.MZG.ajI(paramInt);
        if (TopStoryFSVideoUI.this.MZG.grz() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.NbM.cN(paramInt + TopStoryFSVideoUI.this.NbM.gqR());
        TopStoryFSVideoUI.this.MZo.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
    });
    this.MZK.a(paramView, true, 0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.MZF.NaL.getControlBar()).cEO();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final boolean aeg()
  {
    return this.MWu.iYs;
  }
  
  public final boolean ajA(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.NbT.setVisibility(8);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.NbM.getItemCount();
      int j = this.NbM.gqS();
      int k = this.NbM.gqR();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.MZo;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.NbM.gqR() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
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
  
  public final void ajB(int paramInt)
  {
    this.MWu.UuM = paramInt;
  }
  
  public final void ajC(int paramInt)
  {
    this.MWu.UuP = paramInt;
  }
  
  public final void bfc(final String paramString)
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
  
  public final void bfd(String paramString)
  {
    this.MWu.UuO = paramString;
  }
  
  public final boolean cne()
  {
    return false;
  }
  
  public final Point dpI()
  {
    AppMethodBeat.i(126367);
    if (this.lbY == null) {
      this.lbY = ar.au(this);
    }
    Point localPoint = this.lbY;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final MMActivity eOa()
  {
    return this;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (gqI())
    {
      AppMethodBeat.o(126361);
      return 1;
    }
    AppMethodBeat.o(126361);
    return 0;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_fs_video_ui;
  }
  
  public final RecyclerView.LayoutManager getLayoutManager()
  {
    return this.set;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.MZo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (gqI()) {
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
      i = dpI().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(dpI().x, dpI().y);
    AppMethodBeat.o(126366);
    return i;
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
    return this.NbM;
  }
  
  public final boolean gqI()
  {
    return this.MWu.UuH == 100203L;
  }
  
  public final void gqJ()
  {
    AppMethodBeat.i(126380);
    grk();
    AppMethodBeat.o(126380);
  }
  
  public final int gqK()
  {
    return 0;
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
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.NbM;
        int i = locali.gqS();
        int j = locali.getItemCount();
        locali.gqT();
        locali.aH(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int gqP()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vCr, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void gqu()
  {
    AppMethodBeat.i(126357);
    this.wWQ.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.NbT.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void gqv()
  {
    AppMethodBeat.i(126358);
    this.wWQ.animate().cancel();
    this.wWQ.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
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
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.beT(this.MWu.wmL);
    AppMethodBeat.o(126364);
    return str;
  }
  
  public final void grQ()
  {
    AppMethodBeat.i(126370);
    if (this.MWu.iYs)
    {
      this.MWu.iYs = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
      }
    }
    for (;;)
    {
      grt();
      gqv();
      gqu();
      AppMethodBeat.o(126370);
      return;
      this.MWu.iYs = true;
    }
  }
  
  protected final void gro()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.NbN.a(this);
    this.MZy = this.set.kL();
    int j = this.set.getItemCount();
    if ((this.MZz <= 0L) || (Util.ticksToNow(this.MZz) >= 50L))
    {
      this.MZz = Util.currentTicks();
      if (this.MZG.Nar == 1) {
        break label161;
      }
      if ((this.MZy < j - 1) || (this.MZG.MTh) || (Util.ticksToNow(this.MZA) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!grq()) {
        i = 0;
      }
      if (i != 0)
      {
        this.NbQ.setVisibility(0);
        this.NbP.setVisibility(0);
        this.MZG.ajK(this.MZG.grz());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.MZy > 3) || (this.MZG.MTh) || (Util.ticksToNow(this.MZA) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public final void ky(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.NbX)) {
      grP();
    }
    this.MZF.kB(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126362);
    p.NaI.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.MZC.eqb()) || (ai.isFreeSimCard())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.Ah(false);
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
    this.MWu = new esv();
    try
    {
      this.MWu.parseFrom(paramBundle);
      this.MZG = new n();
      this.MZG.MYE = this;
      this.MZE = new m();
      this.MZE.d(this);
      this.MZD = new o();
      this.MZD.d(this);
      this.MZF = new r();
      this.MZF.d(this);
      this.MZC = new l();
      this.NbN = new h();
      if (this.MWu.UuI != null) {
        this.MZG.h(this.MWu.UuI);
      }
      this.MZw = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.MZw.I(8, this.MWu.wmL);
      this.MZw.aoy(getResources().getString(c.g.top_story_float_ball_title));
      this.MZv = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.MZv.I(8, this.MWu.wmL);
      this.MZv.aMT(getResources().getString(c.g.top_story_float_ball_title));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.MWu.UuK) {
        this.MZC.Nah = true;
      }
      grk();
      this.wWQ = findViewById(c.d.title_container);
      this.MZj = findViewById(c.d.mute_click_area);
      this.MZl = findViewById(c.d.more_click_area);
      this.MZk = ((ImageView)findViewById(c.d.mute_iv));
      this.FUI = ((ImageButton)findViewById(c.d.back_btn));
      this.FUI.getDrawable().setColorFilter(getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.White), PorterDuff.Mode.SRC_ATOP);
      this.FUI.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.MZj.setOnClickListener(new TopStoryFSVideoUI.12(this));
      this.MZj.setVisibility(8);
      this.NbR = findViewById(c.d.fs_scroll_tips_layout);
      this.NbS = ((Button)findViewById(c.d.scroll_tips_i_know_btn));
      this.MZo = ((RecyclerView)findViewById(c.d.video_recycle_view));
      this.MZo.a(this.iZi);
      this.set = new LinearLayoutManager();
      this.MZo.setLayoutManager(this.set);
      this.MZL = androidx.recyclerview.widget.u.e(this.set);
      this.NbM = new i(this);
      paramBundle = this.NbM;
      View localView = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.NbQ = localView.findViewById(c.d.footer_loading_tv);
      this.NbP = localView.findViewById(c.d.footer_progress_bar);
      paramBundle.hc(localView);
      this.MZo.setAdapter(this.NbM);
      new b().a(this.MZo);
      if (grq()) {
        if (this.MZC.isConnected())
        {
          grP();
          this.NbX = false;
          if ((this.MWu.scene != 21) && (this.MWu.UuJ == null)) {
            this.NbO = com.tencent.mm.ui.base.h.a(this, getString(c.g.loading_tips), true, new TopStoryFSVideoUI.13(this));
          }
          this.NbM.Ncc = true;
          this.NbR.setVisibility(8);
          if ((this.MZC.grx()) && (ai.isFreeSimCard()) && (System.currentTimeMillis() - NbY > 86400000L))
          {
            Toast.makeText(this, c.g.top_story_mobile_wangka_tips, 0).show();
            NbY = System.currentTimeMillis();
          }
          this.NbT = findViewById(c.d.dialog_notfull_frame);
          this.NbV = findViewById(c.d.dialog_notfull_root);
          this.NbT.setVisibility(8);
          this.NbT.setOnTouchListener(new TopStoryFSVideoUI.14(this));
          this.NbW = ((TopStoryCommentFloatDialog)findViewById(c.d.comment_float_dialog));
          this.NbW.setVisibility(8);
          this.NbW.p(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (gqI())
          {
            this.FUI.setImageResource(c.f.top_story_close_icon);
            if (ar.aN(this))
            {
              int i = ar.aM(this);
              paramBundle = (RelativeLayout.LayoutParams)this.wWQ.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.ci.a.fromDPToPix(this, 12));
              this.wWQ.setLayoutParams(paramBundle);
            }
          }
          this.MZl.setOnClickListener(new TopStoryFSVideoUI.16(this));
          com.tencent.mm.kernel.h.aGY().a(2802, this.MZP);
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
        Toast.makeText(this, c.g.recommend_video_init_not_network_failed_hint, 1).show();
        this.NbX = true;
        continue;
        this.NbQ.setVisibility(4);
        this.NbP.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.MWu, getActivityBrowseTimeMs(), this.MZG.ajJ(this.MWu.UuM));
    com.tencent.mm.kernel.h.aGY().b(2802, this.MZP);
    this.MZG.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.MWu);
    this.MZF.onUIDestroy();
    this.MZC.onUIDestroy();
    this.MZD.onUIDestroy();
    this.MZE.onUIDestroy();
    this.NbW.jij.close();
    com.tencent.mm.plugin.websearch.api.a.a.rE(16);
    if (this.MZw != null) {
      this.MZw.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.NbW.getVisibility() == 0))
    {
      this.NbW.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      esv localesv = this.MWu;
      if (getSystemVolume() <= 1)
      {
        localesv.iYs = bool;
        grt();
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
        this.MWu.iYs = false;
        grt();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.MZF.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.NbW.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.rE(15);
    if (this.MZv != null) {
      this.MZv.aOj();
    }
    if (this.MZw != null) {
      this.MZw.aOj();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    grk();
    grt();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.MZF.onUIResume();
    this.MZC.IYy = l.fWI();
    this.NbW.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.rE(14);
    if (this.MZv != null) {
      this.MZv.bNV();
    }
    if (this.MZw != null) {
      this.MZw.bNV();
    }
    AppMethodBeat.o(126377);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(List<esy> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.NbM.u(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.MZo.a(0, 3, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */