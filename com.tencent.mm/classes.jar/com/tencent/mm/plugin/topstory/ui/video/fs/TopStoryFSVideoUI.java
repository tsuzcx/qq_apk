package com.tencent.mm.plugin.topstory.ui.video.fs;

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
import com.tencent.mm.am.c.b;
import com.tencent.mm.autogen.a.mk;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
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
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fnx;
import com.tencent.mm.protocal.protobuf.fny;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.y;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TopStoryFSVideoUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long TOH = 0L;
  protected View AtJ;
  protected ImageButton LPI;
  protected foe TIY;
  protected View TLS;
  protected ImageView TLT;
  protected View TLU;
  protected RecyclerView TLX;
  private com.tencent.mm.plugin.topstory.ui.b.a TMe;
  private com.tencent.mm.plugin.topstory.ui.a.a TMf;
  protected int TMh;
  protected long TMi;
  protected long TMj;
  private l TMl;
  private o TMm;
  private m TMn;
  r TMo;
  n TMp;
  private boolean TMq;
  protected com.tencent.mm.plugin.topstory.ui.widget.d TMr;
  private boolean TMs;
  protected com.tencent.mm.plugin.topstory.ui.widget.b TMt;
  private androidx.recyclerview.widget.s TMu;
  private com.tencent.mm.am.h TMy;
  private View TOA;
  private Button TOB;
  View TOC;
  com.tencent.mm.plugin.topstory.ui.widget.c TOD;
  View TOE;
  TopStoryCommentFloatDialog TOF;
  private boolean TOG;
  protected i TOv;
  protected h TOw;
  private ProgressDialog TOx;
  private View TOy;
  private View TOz;
  protected RecyclerView.l lBe;
  private Point nGU;
  private int videoHeight;
  protected LinearLayoutManager vqi;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.lBe = new TopStoryFSVideoUI.3(this);
    this.TMh = 0;
    this.TMi = -1L;
    this.TMj = -1L;
    this.TMy = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousp;
        paramAnonymousp = (fnx)c.b.b(localj.rr.otB);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          aa.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(c.g.top_story_like_failed), 0).show();
          if (localj.TIW != null)
          {
            paramAnonymousString = localj.TIW;
            if (localj.TIW.abOJ) {
              break label174;
            }
          }
          label174:
          for (bool = true;; bool = false)
          {
            paramAnonymousString.abOJ = bool;
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.TIW.abOJ);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.hNG().b(localj.TIW);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.hOi().getControlBar()).m(localj.TIW);
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
          localJSONObject.put("docId", paramAnonymousp.abgw);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousp.muC != 4) {
            break label490;
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
        if (localj.TIW != null)
        {
          paramAnonymousString = localj.TIW;
          if (paramAnonymousp.muC != 4) {
            break label496;
          }
        }
        label490:
        label496:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.abOJ = bool;
          Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.TIW.abOJ), Integer.valueOf(localj.TIW.abON) });
          if (paramAnonymousp.muC != 4) {
            break label502;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.hNG().b(localj.TIW);
          paramAnonymousp = null;
          paramAnonymousString = paramAnonymousp;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).TIZ != null)
          {
            paramAnonymousString = paramAnonymousp;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).TIZ.Ido != null)
            {
              paramAnonymousString = paramAnonymousp;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).TIZ.Ido.equals(localj.TIW.Ido))
              {
                paramAnonymousString = paramAnonymousp;
                if ((localh instanceof g)) {
                  paramAnonymousString = localh.getWowView();
                }
              }
            }
          }
          if (paramAnonymousString != null)
          {
            TopStoryFSVideoUI.this.a(localj.TIW, paramAnonymousString, true);
            if ((localh instanceof g)) {
              localh.hOi().getControlBar().show();
            }
          }
          paramAnonymousString = new mk();
          paramAnonymousString.hOA.hOB = localJSONObject.toString();
          paramAnonymousString.hOA.hOC = "";
          paramAnonymousString.publish();
          break;
          bool = false;
          break label224;
        }
        label502:
        if (localj.hMW().abNR) {
          k.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(c.g.top_story_unlike_succ), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.TIW, null, false);
          break;
          aa.makeText(TopStoryFSVideoUI.this.getContext(), c.g.top_story_unlike_succ_2, 0).show();
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
  
  private void hOQ()
  {
    AppMethodBeat.i(126363);
    this.TOz.setVisibility(0);
    this.TOy.setVisibility(0);
    this.TMp.apd(0);
    AppMethodBeat.o(126363);
  }
  
  private void hOj()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.rc(19)) {
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
  
  private boolean hOp()
  {
    return (this.TIY.scene != 36) && (!this.TIY.abOs);
  }
  
  private void hOs()
  {
    AppMethodBeat.i(126371);
    if (this.TIY.lAj) {
      this.TLT.setBackgroundResource(c.f.top_story_volume_off);
    }
    for (;;)
    {
      if (this.TMo.TNv) {
        this.TMo.setMute(this.TIY.lAj);
      }
      AppMethodBeat.o(126371);
      return;
      this.TLT.setBackgroundResource(c.f.top_story_volume_on);
    }
  }
  
  public final void H(List<foh> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.TOv.I(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.TLX.br(0, 3);
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
  
  public final void a(fcl paramfcl) {}
  
  public final void a(foh paramfoh)
  {
    AppMethodBeat.i(126360);
    if (this.TMe != null) {
      this.TMe.a(this.TIY, paramfoh);
    }
    if (this.TMf != null) {
      this.TMf.a(this.TIY, paramfoh);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(foh paramfoh, int paramInt1, int paramInt2) {}
  
  public final void a(foh paramfoh, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramfoh != null)
    {
      if (!NetStatusUtil.isConnected(this))
      {
        Toast.makeText(getContext(), getString(c.g.top_story_like_failed), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramfoh.HsD;
      if (!paramfoh.abOJ) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.TIY.scene;
      String str2 = this.TIY.mpa;
      if (!hNH()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramfoh, (String)localObject, i, str1, k, str2, j, paramfoh.Ido, paramfoh.ELy);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      if (paramfoh.abOJ) {
        break label243;
      }
      bool = true;
      label154:
      paramfoh.abOJ = bool;
      if (!paramfoh.abOJ) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramfoh.abON += 1;; paramfoh.abON -= 1)
    {
      ((TextView)paramView.findViewById(c.d.wow_icon_text)).setText(com.tencent.mm.plugin.topstory.ui.d.aoN(paramfoh.abON));
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramfoh.abOJ);
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
  
  public final void a(final foh paramfoh, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramfoh.Ido, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.TOC.getVisibility() == 0) && (this.TOD != null) && (this.TOD.vid != null) && (this.TOD.vid.equals(paramfoh.Ido))) {
        this.TOC.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramfoh.HsD;
    String str2 = paramfoh.title;
    String str3 = this.TIY.mpa;
    int j = this.TIY.scene;
    if (hNH()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramfoh.Ido, paramfoh.ELy);
      this.TOC.setVisibility(0);
      this.TOD = new com.tencent.mm.plugin.topstory.ui.widget.c(this.TOE, new com.tencent.mm.plugin.topstory.ui.widget.c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.TOF.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void hOS()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.TOC.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.TMo.bcl();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.TIY.abOj, paramfoh.abOz);
          if (TopStoryFSVideoUI.this.TMo.fjy()) {
            TopStoryFSVideoUI.this.TMo.bck();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramfoh.Ido);
      this.TOC.postDelayed(new TopStoryFSVideoUI.11(this), 2000L);
      this.TOD.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(foh paramfoh, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final boolean aGe()
  {
    return this.TIY.lAj;
  }
  
  public final void aZ(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
    if (this.TMo.fjy())
    {
      this.TMo.bck();
      this.TMq = true;
    }
    foh localfoh = this.TMp.apc(paramInt);
    this.TMr = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localfoh, new d.a()
    {
      public final void e(foh paramAnonymousfoh)
      {
        AppMethodBeat.i(126333);
        if (paramAnonymousfoh.abOK != null) {
          TopStoryFSVideoUI.this.ba(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.TMr.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(foh paramAnonymousfoh)
      {
        AppMethodBeat.i(126334);
        com.tencent.mm.plugin.topstory.ui.video.p localp = com.tencent.mm.plugin.topstory.ui.video.p.TNr;
        com.tencent.mm.plugin.topstory.ui.video.p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.hNz(), paramAnonymousfoh);
        TopStoryFSVideoUI.this.TMr.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(foh paramAnonymousfoh)
      {
        AppMethodBeat.i(164128);
        Object localObject = com.tencent.mm.util.i.agtt;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agrS, 0) == 1)
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bL(paramAnonymousfoh.Ido, paramAnonymousfoh.abOw);
          localObject = TopStoryFSVideoUI.this.hNy() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousfoh.title + ".mp4";
          if (y.ZC("/sdcard/video/")) {
            y.bDX("/sdcard/video/");
          }
          y.O((String)localObject, str, false);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousfoh.title, 0).show();
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
          TopStoryFSVideoUI.this.TMo.bcl();
          try
          {
            ((f)TopStoryFSVideoUI.this.TMo.TNu.getControlBar()).cvy();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.TMr.a(paramView, true, 0, 0);
    try
    {
      ((f)this.TMo.TNu.getControlBar()).hON();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void anI() {}
  
  public final boolean aoT(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.TOC.setVisibility(8);
    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.TOv.getItemCount();
      int j = this.TOv.hNQ();
      int k = this.TOv.hNP();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.TLX;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.TOv.hNP() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
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
  
  public final void aoU(int paramInt)
  {
    this.TIY.abOo = paramInt;
  }
  
  public final void aoV(int paramInt)
  {
    this.TIY.abOr = paramInt;
  }
  
  public final void ba(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.TMs = true;
    final foh localfoh = this.TMp.apc(paramInt);
    this.TMt = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localfoh, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void D(Set<ass> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        aa.makeText(TopStoryFSVideoUI.this.getContext(), c.g.top_story_feedback_unlike_toast, 0).show();
        com.tencent.mm.plugin.topstory.a.h.a(TopStoryFSVideoUI.this.hNz(), localfoh, paramAnonymousSet, TopStoryFSVideoUI.this.TMp.hOz());
        TopStoryFSVideoUI.this.TMo.stopPlay();
        TopStoryFSVideoUI.this.TMp.apb(paramInt);
        if (TopStoryFSVideoUI.this.TMp.hOz() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.TOv.fX(paramInt + TopStoryFSVideoUI.this.TOv.hNP());
        TopStoryFSVideoUI.this.TLX.br(0, 3);
        AppMethodBeat.o(126336);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.TMo.bcl();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.TMo.TNu.getControlBar()).cvy();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
    });
    this.TMt.a(paramView, true, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.TMo.TNu.getControlBar()).hON();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final void beA(String paramString)
  {
    this.TIY.abOq = paramString;
  }
  
  public final void bez(final String paramString)
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
  
  public final boolean cOX()
  {
    return false;
  }
  
  public final Point dXX()
  {
    AppMethodBeat.i(126367);
    if (this.nGU == null) {
      this.nGU = aw.bf(this);
    }
    Point localPoint = this.nGU;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final MMActivity fWt()
  {
    return this;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (hNH())
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
    return this.vqi;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.TLX;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (hNH()) {
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
      i = dXX().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(dXX().x, dXX().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final m hNA()
  {
    return this.TMn;
  }
  
  public final r hNB()
  {
    return this.TMo;
  }
  
  public final androidx.recyclerview.widget.s hNC()
  {
    return this.TMu;
  }
  
  public final int hND()
  {
    return this.TIY.abOo;
  }
  
  public final boolean hNE()
  {
    return this.TIY.scene != 36;
  }
  
  public final boolean hNF()
  {
    return this.TIY.scene != 326;
  }
  
  public final e hNG()
  {
    return this.TOv;
  }
  
  public final boolean hNH()
  {
    return this.TIY.abOj == 100203L;
  }
  
  public final void hNI()
  {
    AppMethodBeat.i(126380);
    hOj();
    AppMethodBeat.o(126380);
  }
  
  public final int hNJ()
  {
    return 0;
  }
  
  public final n hNK()
  {
    return this.TMp;
  }
  
  public final String hNL()
  {
    if (this.TIY.abOq == null) {
      return "";
    }
    return this.TIY.abOq;
  }
  
  public final int hNM()
  {
    return this.TIY.abOr;
  }
  
  public final void hNN()
  {
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.TOv;
        int i = locali.hNQ();
        int j = locali.getItemCount();
        locali.hNR();
        locali.bB(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int hNO()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yQL, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void hNt()
  {
    AppMethodBeat.i(126357);
    this.AtJ.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.TOC.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void hNu()
  {
    AppMethodBeat.i(126358);
    this.AtJ.animate().cancel();
    this.AtJ.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final l hNw()
  {
    return this.TMl;
  }
  
  public final o hNx()
  {
    return this.TMm;
  }
  
  public final String hNy()
  {
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.g.beq(this.TIY.zIO);
    AppMethodBeat.o(126364);
    return str;
  }
  
  public final foe hNz()
  {
    return this.TIY;
  }
  
  public final void hOR()
  {
    AppMethodBeat.i(126370);
    if (this.TIY.lAj)
    {
      this.TIY.lAj = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
      }
    }
    for (;;)
    {
      hOs();
      hNu();
      hNt();
      AppMethodBeat.o(126370);
      return;
      this.TIY.lAj = true;
    }
  }
  
  protected final void hOn()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.TOw.a(this);
    this.TMh = this.vqi.Jw();
    int j = this.vqi.getItemCount();
    if ((this.TMi <= 0L) || (Util.ticksToNow(this.TMi) >= 50L))
    {
      this.TMi = Util.currentTicks();
      if (this.TMp.TNa == 1) {
        break label161;
      }
      if ((this.TMh < j - 1) || (this.TMp.TFx) || (Util.ticksToNow(this.TMj) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!hOp()) {
        i = 0;
      }
      if (i != 0)
      {
        this.TOz.setVisibility(0);
        this.TOy.setVisibility(0);
        this.TMp.apd(this.TMp.hOz());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.TMh > 3) || (this.TMp.TFx) || (Util.ticksToNow(this.TMj) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public final void mm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.TOG)) {
      hOQ();
    }
    this.TMo.mp(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126362);
    com.tencent.mm.plugin.topstory.ui.video.p.TNr.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.TMl.fvi()) || (aj.isFreeSimCard())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.FD(false);
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
    this.TIY = new foe();
    try
    {
      this.TIY.parseFrom(paramBundle);
      this.TMp = new n();
      this.TMp.TLn = this;
      this.TMn = new m();
      this.TMn.d(this);
      this.TMm = new o();
      this.TMm.d(this);
      this.TMo = new r();
      this.TMo.d(this);
      this.TMl = new l();
      this.TOw = new h();
      if (this.TIY.abOk != null) {
        this.TMp.h(this.TIY.abOk);
      }
      this.TMf = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.TMf.J(8, this.TIY.zIO);
      this.TMf.ahU(getResources().getString(c.g.top_story_float_ball_title));
      this.TMe = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.TMe.J(8, this.TIY.zIO);
      this.TMe.updateTitle(getResources().getString(c.g.top_story_float_ball_title));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.TIY.abOm) {
        this.TMl.TMQ = true;
      }
      hOj();
      this.AtJ = findViewById(c.d.title_container);
      this.TLS = findViewById(c.d.mute_click_area);
      this.TLU = findViewById(c.d.more_click_area);
      this.TLT = ((ImageView)findViewById(c.d.mute_iv));
      this.LPI = ((ImageButton)findViewById(c.d.back_btn));
      this.LPI.getDrawable().setColorFilter(getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.White), PorterDuff.Mode.SRC_ATOP);
      this.LPI.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.TLS.setOnClickListener(new TopStoryFSVideoUI.12(this));
      this.TLS.setVisibility(8);
      this.TOA = findViewById(c.d.fs_scroll_tips_layout);
      this.TOB = ((Button)findViewById(c.d.scroll_tips_i_know_btn));
      this.TLX = ((RecyclerView)findViewById(c.d.video_recycle_view));
      this.TLX.a(this.lBe);
      this.vqi = new LinearLayoutManager();
      this.TLX.setLayoutManager(this.vqi);
      this.TMu = androidx.recyclerview.widget.s.e(this.vqi);
      this.TOv = new i(this);
      paramBundle = this.TOv;
      View localView = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.TOz = localView.findViewById(c.d.footer_loading_tv);
      this.TOy = localView.findViewById(c.d.footer_progress_bar);
      paramBundle.kn(localView);
      this.TLX.setAdapter(this.TOv);
      new b().a(this.TLX);
      if (hOp()) {
        if (this.TMl.isConnected())
        {
          hOQ();
          this.TOG = false;
          if ((this.TIY.scene != 21) && (this.TIY.abOl == null)) {
            this.TOx = k.a(this, getString(c.g.loading_tips), true, new TopStoryFSVideoUI.13(this));
          }
          this.TOv.TOL = true;
          this.TOA.setVisibility(8);
          if ((this.TMl.hOx()) && (aj.isFreeSimCard()) && (System.currentTimeMillis() - TOH > 86400000L))
          {
            Toast.makeText(this, c.g.top_story_mobile_wangka_tips, 0).show();
            TOH = System.currentTimeMillis();
          }
          this.TOC = findViewById(c.d.dialog_notfull_frame);
          this.TOE = findViewById(c.d.dialog_notfull_root);
          this.TOC.setVisibility(8);
          this.TOC.setOnTouchListener(new TopStoryFSVideoUI.14(this));
          this.TOF = ((TopStoryCommentFloatDialog)findViewById(c.d.comment_float_dialog));
          this.TOF.setVisibility(8);
          this.TOF.u(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new TopStoryFSVideoUI.15(this));
          if (hNH())
          {
            this.LPI.setImageResource(c.f.top_story_close_icon);
            if (aw.bx(this))
            {
              int i = aw.bw(this);
              paramBundle = (RelativeLayout.LayoutParams)this.AtJ.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cd.a.fromDPToPix(this, 12));
              this.AtJ.setLayoutParams(paramBundle);
            }
          }
          this.TLU.setOnClickListener(new TopStoryFSVideoUI.16(this));
          com.tencent.mm.kernel.h.aZW().a(2802, this.TMy);
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
        this.TOG = true;
        continue;
        this.TOz.setVisibility(4);
        this.TOy.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.h.a(this.TIY, getActivityBrowseTimeMs(), this.TMp.apc(this.TIY.abOo));
    com.tencent.mm.kernel.h.aZW().b(2802, this.TMy);
    this.TMp.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.TIY);
    this.TMo.onUIDestroy();
    this.TMl.onUIDestroy();
    this.TMm.onUIDestroy();
    this.TMn.onUIDestroy();
    this.TOF.lKz.close();
    com.tencent.mm.plugin.websearch.api.a.a.rG(16);
    if (this.TMf != null) {
      this.TMf.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.TOF.getVisibility() == 0))
    {
      this.TOF.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      foe localfoe = this.TIY;
      if (getSystemVolume() <= 1)
      {
        localfoe.lAj = bool;
        hOs();
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
        this.TIY.lAj = false;
        hOs();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.TMo.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.TOF.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.rG(15);
    if (this.TMe != null) {
      this.TMe.bhW();
    }
    if (this.TMf != null) {
      this.TMf.bhW();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    hOj();
    hOs();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.TMo.onUIResume();
    this.TMl.PhY = l.hoZ();
    this.TOF.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.rG(14);
    if (this.TMe != null) {
      this.TMe.coi();
    }
    if (this.TMf != null) {
      this.TMf.coi();
    }
    AppMethodBeat.o(126377);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */