package com.tencent.mm.plugin.topstory.ui.video;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.autogen.a.mk;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.ass;
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

public abstract class TopStoryBaseVideoUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.topstory.a.c, b
{
  protected View AtJ;
  protected ImageButton LPI;
  public foe TIY;
  protected View TLS;
  protected ImageView TLT;
  protected View TLU;
  protected ImageView TLV;
  protected i TLW;
  protected RecyclerView TLX;
  protected e TLY;
  protected d TLZ;
  public RecyclerView TMa;
  protected LinearLayoutManager TMb;
  protected e TMc;
  public d TMd;
  private com.tencent.mm.plugin.topstory.ui.b.a TMe;
  private com.tencent.mm.plugin.topstory.ui.a.a TMf;
  public boolean TMg = true;
  protected int TMh = 0;
  protected long TMi = -1L;
  protected long TMj = -1L;
  private i.a TMk = new i.a()
  {
    public final void onOrientationChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(126088);
      TopStoryBaseVideoUI.this.apa(paramAnonymousInt);
      AppMethodBeat.o(126088);
    }
  };
  private l TMl;
  public o TMm;
  private m TMn;
  public r TMo;
  protected n TMp;
  private boolean TMq;
  protected com.tencent.mm.plugin.topstory.ui.widget.d TMr;
  private boolean TMs;
  protected com.tencent.mm.plugin.topstory.ui.widget.b TMt;
  private androidx.recyclerview.widget.s TMu;
  private androidx.recyclerview.widget.s TMv;
  public boolean TMw;
  private j TMx;
  private com.tencent.mm.am.h TMy = new com.tencent.mm.am.h()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
    {
      AppMethodBeat.i(126079);
      final j localj = (j)paramAnonymousp;
      paramAnonymousp = (fnx)c.b.b(localj.rr.otB);
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
      {
        Log.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        aa.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(c.g.top_story_like_failed), 0).show();
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
          Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.TIW.abOJ);
          TopStoryBaseVideoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126078);
              h localh = TopStoryBaseVideoUI.this.hNG().b(localj.TIW);
              if (localh != null)
              {
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  localh.hOh();
                  AppMethodBeat.o(126078);
                  return;
                }
                if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                  ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.hOi().getControlBar()).m(localj.TIW);
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
        localJSONObject.put("docId", paramAnonymousp.abgw);
        localJSONObject.put("opType", "LIKE");
        if (paramAnonymousp.muC != 4) {
          break label514;
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
          break label520;
        }
      }
      label514:
      label520:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousString.abOJ = bool;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.TIW.abOJ), Integer.valueOf(localj.TIW.abON) });
        if (paramAnonymousp.muC != 4) {
          break label526;
        }
        h localh = TopStoryBaseVideoUI.this.hNG().b(localj.TIW);
        paramAnonymousp = null;
        paramAnonymousString = paramAnonymousp;
        if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).TIZ != null)
        {
          paramAnonymousString = paramAnonymousp;
          if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).TIZ != null)
          {
            paramAnonymousString = paramAnonymousp;
            if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).TIZ.Ido != null)
            {
              paramAnonymousString = paramAnonymousp;
              if (TopStoryBaseVideoUI.g(TopStoryBaseVideoUI.this).TIZ.Ido.equals(localj.TIW.Ido)) {
                if (!(localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
                {
                  paramAnonymousString = paramAnonymousp;
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
          TopStoryBaseVideoUI.this.a(localj.TIW, paramAnonymousString, true);
          if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
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
      label526:
      if (localj.hMW().abNR) {
        k.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(c.g.top_story_unlike_succ), "", true);
      }
      for (;;)
      {
        TopStoryBaseVideoUI.this.a(localj.TIW, null, false);
        break;
        aa.makeText(TopStoryBaseVideoUI.this.getContext(), c.g.top_story_unlike_succ_2, 0).show();
      }
    }
  };
  protected RecyclerView.l lBe = new TopStoryBaseVideoUI.9(this);
  private Point nGU;
  protected TextView pJJ;
  private boolean str = false;
  private int videoHeight;
  protected LinearLayoutManager vqi;
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  private void hOj()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.rc(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void hOs()
  {
    if (this.TIY.lAj) {
      this.TLT.setBackgroundResource(c.f.top_story_volume_off);
    }
    for (;;)
    {
      if (this.TMo.TNv) {
        this.TMo.setMute(this.TIY.lAj);
      }
      return;
      this.TLT.setBackgroundResource(c.f.top_story_volume_on);
    }
  }
  
  private void hOt()
  {
    com.tencent.mm.compatible.b.a.a((AudioManager)getContext().getSystemService("audio"), 3, 1, 0);
  }
  
  public final void FE(boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.TMg = paramBoolean;
  }
  
  public final void FF(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.TIY.lAj = true;
    }
    for (;;)
    {
      hOs();
      return;
      this.TIY.lAj = false;
      if (getSystemVolume() == 0) {
        hOt();
      }
    }
  }
  
  public void H(final List<foh> paramList, final boolean paramBoolean)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126077);
        if (TopStoryBaseVideoUI.this.TMw)
        {
          TopStoryBaseVideoUI.this.TMc.I(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.TLY.bZE.notifyChanged();
          AppMethodBeat.o(126077);
          return;
        }
        TopStoryBaseVideoUI.this.TLY.I(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.TMc.bZE.notifyChanged();
        AppMethodBeat.o(126077);
      }
    });
  }
  
  public final void a(foh paramfoh)
  {
    if (!this.TMw)
    {
      this.pJJ.setText(c.g.recommend_video_title);
      this.TLV.setVisibility(8);
    }
    if (this.TMe != null) {
      this.TMe.a(this.TIY, paramfoh);
    }
    if (this.TMf != null) {
      this.TMf.a(this.TIY, paramfoh);
    }
  }
  
  public final void a(foh paramfoh, View paramView)
  {
    if (paramfoh != null)
    {
      if (!NetStatusUtil.isConnected(this)) {
        Toast.makeText(getContext(), getString(c.g.top_story_like_failed), 0).show();
      }
    }
    else {
      return;
    }
    if (this.TMx != null) {
      com.tencent.mm.kernel.h.aZW().a(this.TMx);
    }
    String str1 = paramfoh.HsD;
    int i;
    int j;
    label110:
    boolean bool;
    if (paramfoh.abOJ)
    {
      i = 5;
      String str2 = System.currentTimeMillis();
      int k = this.TIY.scene;
      String str3 = this.TIY.mpa;
      if (!hNH()) {
        break label238;
      }
      j = 318;
      this.TMx = new j(paramfoh, str1, i, str2, k, str3, j, paramfoh.Ido, paramfoh.ELy);
      com.tencent.mm.kernel.h.aZW().a(this.TMx, 0);
      if (paramfoh.abOJ) {
        break label246;
      }
      bool = true;
      label163:
      paramfoh.abOJ = bool;
      if (!paramfoh.abOJ) {
        break label252;
      }
    }
    label238:
    label246:
    label252:
    for (paramfoh.abON += 1;; paramfoh.abON -= 1)
    {
      ((TextView)paramView.findViewById(c.d.wow_icon_text)).setText(com.tencent.mm.plugin.topstory.ui.d.aoN(paramfoh.abON));
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramfoh.abOJ);
      return;
      i = 4;
      break;
      j = 317;
      break label110;
      bool = false;
      break label163;
    }
  }
  
  public abstract void a(foh paramfoh, View paramView, boolean paramBoolean);
  
  public final boolean aGe()
  {
    return this.TIY.lAj;
  }
  
  protected void aNi()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.TIY = new foe();
    try
    {
      this.TIY.parseFrom(arrayOfByte);
      this.TMp = new n();
      this.TMp.TLn = this;
      this.TMn = new m();
      this.TMn.d(this);
      this.TMm = new o();
      this.TMm.d(this);
      this.TMo = new r();
      this.TMo.d(this);
      this.TMl = new l();
      this.TLZ = hOl();
      this.TMd = hOm();
      this.TMf = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.TMf.J(8, this.TIY.zIO);
      this.TMf.ahU(getResources().getString(c.g.top_story_float_ball_title));
      this.TMe = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
      this.TMe.J(8, this.TIY.zIO);
      this.TMe.updateTitle(getResources().getString(c.g.top_story_float_ball_title));
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
  
  public final void aZ(final View paramView, final int paramInt)
  {
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
        AppMethodBeat.i(126089);
        if (paramAnonymousfoh.abOK != null) {
          TopStoryBaseVideoUI.this.ba(paramView, paramInt);
        }
        TopStoryBaseVideoUI.this.TMr.dismiss();
        AppMethodBeat.o(126089);
      }
      
      public final void f(foh paramAnonymousfoh)
      {
        AppMethodBeat.i(126090);
        p localp = p.TNr;
        p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.hNz(), paramAnonymousfoh);
        TopStoryBaseVideoUI.this.TMr.dismiss();
        com.tencent.mm.plugin.report.f.Ozc.b(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(2) });
        AppMethodBeat.o(126090);
      }
      
      public final void g(foh paramAnonymousfoh)
      {
        AppMethodBeat.i(164124);
        Object localObject = com.tencent.mm.util.i.agtt;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agrS, 0) == 1)
        {
          localObject = com.tencent.mm.plugin.topstory.ui.d.bL(paramAnonymousfoh.Ido, paramAnonymousfoh.abOw);
          localObject = TopStoryBaseVideoUI.this.hNy() + (String)localObject + ".mp4";
          String str = "/sdcard/video/" + paramAnonymousfoh.title + ".mp4";
          if (y.ZC("/sdcard/video/")) {
            y.bDX("/sdcard/video/");
          }
          y.O((String)localObject, str, false);
          Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + paramAnonymousfoh.title, 0).show();
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
          TopStoryBaseVideoUI.this.TMo.bcl();
          if (TopStoryBaseVideoUI.this.TMw) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.TMo.TNu.getControlBar()).cvy();
              AppMethodBeat.o(126091);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126091);
      }
    });
    if (this.TMw) {
      this.TMr.a(paramView, true, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.TMo.TNu.getControlBar()).hON();
      for (;;)
      {
        label109:
        com.tencent.mm.plugin.report.f.Ozc.b(17080, new Object[] { Integer.valueOf(65), Integer.valueOf(1) });
        return;
        this.TMr.a(paramView, false, 0, 0);
      }
    }
    catch (Exception paramView)
    {
      break label109;
    }
  }
  
  public final void aoU(int paramInt)
  {
    this.TIY.abOo = paramInt;
  }
  
  public final void aoV(int paramInt)
  {
    this.TIY.abOr = paramInt;
  }
  
  protected void apa(int paramInt) {}
  
  public final void ba(View paramView, final int paramInt)
  {
    this.TMs = true;
    final foh localfoh = this.TMp.apc(paramInt);
    this.TMt = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localfoh, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void D(Set<ass> paramAnonymousSet)
      {
        AppMethodBeat.i(126092);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
        aa.makeText(TopStoryBaseVideoUI.this.getContext(), c.g.top_story_feedback_unlike_toast, 0).show();
        com.tencent.mm.plugin.topstory.a.h.a(TopStoryBaseVideoUI.this.hNz(), localfoh, paramAnonymousSet, TopStoryBaseVideoUI.this.TMp.hOz());
        TopStoryBaseVideoUI.this.TMo.stopPlay();
        TopStoryBaseVideoUI.this.TMp.apb(paramInt);
        if (TopStoryBaseVideoUI.this.TMp.hOz() == 0)
        {
          TopStoryBaseVideoUI.this.finish();
          AppMethodBeat.o(126092);
          return;
        }
        if (TopStoryBaseVideoUI.this.TMw)
        {
          TopStoryBaseVideoUI.this.TMc.fX(paramInt + TopStoryBaseVideoUI.this.TMc.hNP());
          TopStoryBaseVideoUI.this.TLY.bZE.notifyChanged();
          TopStoryBaseVideoUI.this.TMa.br(0, 3);
          AppMethodBeat.o(126092);
          return;
        }
        TopStoryBaseVideoUI.this.TLY.fX(paramInt + TopStoryBaseVideoUI.this.TLY.hNP());
        TopStoryBaseVideoUI.this.TMc.bZE.notifyChanged();
        AppMethodBeat.o(126092);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126093);
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
        if (TopStoryBaseVideoUI.e(TopStoryBaseVideoUI.this))
        {
          TopStoryBaseVideoUI.this.TMo.bcl();
          TopStoryBaseVideoUI.f(TopStoryBaseVideoUI.this);
          if (TopStoryBaseVideoUI.this.TMw) {
            try
            {
              ((com.tencent.mm.plugin.topstory.ui.video.fs.f)TopStoryBaseVideoUI.this.TMo.TNu.getControlBar()).cvy();
              AppMethodBeat.o(126093);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(126093);
      }
    });
    if (this.TMw) {
      this.TMt.a(paramView, true, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.TMo.TNu.getControlBar()).hON();
      return;
    }
    catch (Exception paramView) {}
    this.TMt.a(paramView, false, 0, 0 - com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final void beA(String paramString)
  {
    this.TIY.abOq = paramString;
  }
  
  public void bez(String paramString) {}
  
  public final boolean cOX()
  {
    return this.TMw;
  }
  
  public final Point dXX()
  {
    if (this.nGU == null) {
      this.nGU = aw.bf(this);
    }
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.nGU.x), Integer.valueOf(this.nGU.y) });
    return this.nGU;
  }
  
  public final MMActivity fWt()
  {
    return this;
  }
  
  public void finish()
  {
    if (this.TMf != null) {
      this.TMf.finish();
    }
    super.finish();
  }
  
  public final RecyclerView.LayoutManager getLayoutManager()
  {
    if (this.TMw) {
      return this.TMb;
    }
    return this.vqi;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.TMw) {
      return this.TMa;
    }
    return this.TLX;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (hNH()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = dXX().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(dXX().x, dXX().y);
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
    if (this.TMw) {
      return this.TMv;
    }
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
    if (this.TMw) {
      return this.TMc;
    }
    return this.TLY;
  }
  
  public final boolean hNH()
  {
    return this.TIY.abOj == 100203L;
  }
  
  public final void hNI()
  {
    hOj();
  }
  
  public int hNJ()
  {
    return com.tencent.mm.plugin.topstory.ui.a.TJc;
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
    runOnUiThread(new Runnable()
    {
      private static void a(e paramAnonymouse)
      {
        AppMethodBeat.i(126081);
        int i = paramAnonymouse.hNQ();
        int j = paramAnonymouse.getItemCount();
        paramAnonymouse.hNR();
        paramAnonymouse.bB(j - i, i);
        AppMethodBeat.o(126081);
      }
      
      public final void run()
      {
        AppMethodBeat.i(126080);
        a(TopStoryBaseVideoUI.this.TLY);
        a(TopStoryBaseVideoUI.this.TMc);
        AppMethodBeat.o(126080);
      }
    });
  }
  
  public void hNt() {}
  
  public void hNu() {}
  
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
    return com.tencent.mm.plugin.topstory.a.g.beq(this.TIY.zIO);
  }
  
  public final foe hNz()
  {
    return this.TIY;
  }
  
  protected void hOk() {}
  
  protected abstract d hOl();
  
  protected abstract d hOm();
  
  protected void hOn()
  {
    int j = 0;
    int i;
    if (this.TMw)
    {
      this.TMd.a(this);
      this.TMh = ((LinearLayoutManager)getLayoutManager()).Jw();
      i = getLayoutManager().getItemCount();
      if ((this.TMi <= 0L) || (Util.ticksToNow(this.TMi) >= 50L))
      {
        this.TMi = Util.currentTicks();
        if (this.TMp.TNa == 1) {
          break label145;
        }
        if ((this.TMh < i - 1) || (this.TMp.TFx) || (Util.ticksToNow(this.TMj) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!hOp()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          hOo();
        }
        return;
        this.TLZ.a(this);
        break;
        label145:
        if ((i - this.TMh > 3) || (this.TMp.TFx) || (Util.ticksToNow(this.TMj) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void hOo()
  {
    this.TMj = Util.currentTicks();
  }
  
  protected final boolean hOp()
  {
    return (this.TIY.scene != 36) && (!this.TIY.abOs);
  }
  
  protected abstract e hOq();
  
  protected abstract e hOr();
  
  public final com.tencent.mm.plugin.topstory.ui.b.a hOu()
  {
    return this.TMe;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.a.a hOv()
  {
    return this.TMf;
  }
  
  protected void initContentView()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    hOj();
    this.AtJ = findViewById(c.d.title_container);
    this.pJJ = ((TextView)findViewById(c.d.title_tv));
    this.TLV = ((ImageView)findViewById(c.d.source_iv));
    this.TLS = findViewById(c.d.mute_click_area);
    this.TLT = ((ImageView)findViewById(c.d.mute_iv));
    this.TLU = findViewById(c.d.more_click_area);
    this.LPI = ((ImageButton)findViewById(c.d.back_btn));
    this.LPI.getDrawable().setColorFilter(getResources().getColor(c.a.White), PorterDuff.Mode.SRC_ATOP);
    this.LPI.setOnClickListener(new TopStoryBaseVideoUI.1(this));
    this.TLS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = TopStoryBaseVideoUI.this;
        if (!paramAnonymousView.TIY.lAj) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.FF(bool);
          paramAnonymousView.hNu();
          paramAnonymousView.hNt();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126082);
          return;
        }
      }
    });
    this.TLS.setVisibility(8);
    this.TLX = ((RecyclerView)findViewById(c.d.video_recycle_view));
    this.TLX.a(this.lBe);
    this.TLX.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.vqi = new LinearLayoutManager();
    this.TLX.setLayoutManager(this.vqi);
    this.TMu = androidx.recyclerview.widget.s.e(this.vqi);
    this.TLY = hOq();
    this.TLX.setAdapter(this.TLY);
    this.TMa = ((RecyclerView)findViewById(c.d.fs_video_recycle_view));
    this.TMa.a(this.lBe);
    this.TMa.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.TMb = new LinearLayoutManager();
    this.TMa.setLayoutManager(this.TMb);
    this.TMv = androidx.recyclerview.widget.s.e(this.TMb);
    this.TMc = hOr();
    this.TMa.setAdapter(this.TMc);
    this.TMa.setVisibility(8);
    if ((!this.str) && (!hNH()))
    {
      this.TLW = new i(getApplicationContext());
      this.TLW.enable();
      this.TLW.TMF = this.TMk;
      this.str = true;
    }
    if (this.TIY.lAj) {
      FF(this.TIY.lAj);
    }
    this.TMl.TMR = this;
    this.TLU.setOnClickListener(new TopStoryBaseVideoUI.6(this));
  }
  
  public void mm(int paramInt1, int paramInt2)
  {
    this.TMo.mp(paramInt1, paramInt2);
  }
  
  public void onBackPressed()
  {
    hOk();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aNi();
    initContentView();
    com.tencent.mm.kernel.h.aZW().a(2802, this.TMy);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.h.a(this.TIY, getActivityBrowseTimeMs(), this.TMp.apc(this.TIY.abOo));
    if (this.str)
    {
      this.TLW.disable();
      this.TLW.TMF = null;
      this.TLW = null;
    }
    if (this.TMx != null) {
      com.tencent.mm.kernel.h.aZW().a(this.TMx);
    }
    com.tencent.mm.kernel.h.aZW().b(2802, this.TMy);
    this.TMp.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.TIY);
    this.TMo.onUIDestroy();
    this.TMl.onUIDestroy();
    this.TMm.onUIDestroy();
    this.TMn.onUIDestroy();
    com.tencent.mm.plugin.websearch.api.a.a.rG(16);
    if (this.TMf != null) {
      this.TMf.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      foe localfoe = this.TIY;
      if (getSystemVolume() <= 1)
      {
        localfoe.lAj = bool;
        hOs();
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
        this.TIY.lAj = false;
        hOs();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.TMo.onUIPause();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.rG(15);
      if (this.TMe != null) {
        this.TMe.bhW();
      }
      if (this.TMf != null) {
        this.TMf.bhW();
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
    hOj();
    hOs();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.TMo.onUIResume();
    this.TMl.PhY = l.hoZ();
    com.tencent.mm.plugin.websearch.api.a.a.rG(14);
    if (this.TMe != null) {
      this.TMe.coi();
    }
    if (this.TMf != null) {
      this.TMf.coi();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */