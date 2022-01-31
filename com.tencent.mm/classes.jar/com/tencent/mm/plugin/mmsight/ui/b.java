package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a.a;
import com.tencent.mm.api.s.b;
import com.tencent.mm.api.s.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.b;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;

public final class b
{
  private static int eez;
  private static final Object oOK;
  private MMActivity cmc;
  private String cqq;
  private com.tencent.mm.ui.base.p efs;
  private VideoTransPara oHk;
  private VideoPlayerTextureView oKC;
  private VideoSeekBarEditorView oKD;
  private boolean oOA = false;
  private int oOB = -1;
  public int oOC = -1;
  public int oOD = -1;
  private ap oOE;
  private ViewGroup oOF;
  private s oOG;
  private c oOH;
  private com.tencent.mm.plugin.mmsight.api.a oOI;
  private com.tencent.mm.media.g.d oOJ;
  public b.a oOL;
  private boolean oOM = false;
  public boolean oON = false;
  private boolean oOO = false;
  private boolean oOP = false;
  public String oOQ = null;
  public int oOR = -1;
  private a.b oOS;
  public boolean oOT = false;
  public boolean oOU = true;
  private RecyclerThumbSeekBar oOz;
  public int scene;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(55175);
    oOK = new Object();
    AppMethodBeat.o(55175);
  }
  
  private void bRT()
  {
    AppMethodBeat.i(55163);
    this.oOG = s.bWe.Ab();
    Object localObject = this.oOG;
    s.a.a locala = new s.a.a();
    locala.bWg = false;
    locala.bWj = true;
    locala.bWf = s.c.bWl;
    locala.bWk = new Rect(this.oKC.getLeft(), this.oKC.getTop(), this.oKC.getRight(), this.oKC.getBottom());
    ((s)localObject).a(locala.Ax());
    this.oOH = this.oOG.aV(this.oOF.getContext());
    this.oOH.setActionBarCallback(new b.1(this));
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    if (am.hO(this.cmc)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.bQE().y - Math.max(am.fx(this.cmc), am.hP(this.cmc)));
    }
    this.oOF.addView(this.oOH, (ViewGroup.LayoutParams)localObject);
    this.oOH.setSelectedFeatureListener(new b.6(this));
    this.oKD.setCancelButtonClickListener(new b.7(this));
    this.oKD.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55153);
        if (!b.o(b.this))
        {
          b.r(b.this);
          AppMethodBeat.o(55153);
          return;
        }
        b.p(b.this);
        if ((b.s(b.this) >= 0) && (b.c(b.this) > 0)) {
          b.t(b.this);
        }
        AppMethodBeat.o(55153);
      }
    });
    if (this.oOO)
    {
      this.oKD.setVisibility(0);
      this.oKD.bringToFront();
      this.oKD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55154);
          b.u(b.this).setFooterVisible(false);
          b.u(b.this).setActionBarVisible(false);
          b.u(b.this).setActivated(false);
          b.i(b.this);
          AppMethodBeat.o(55154);
        }
      });
    }
    AppMethodBeat.o(55163);
  }
  
  private void bRU()
  {
    AppMethodBeat.i(55164);
    this.oKC.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.oKD.animate().alpha(0.0F).setDuration(100L).setListener(new b.3(this));
    this.oOH.setFooterVisible(true);
    this.oOH.setAutoShowFooterAndBar(true);
    this.oOH.setActionBarVisible(true);
    this.oOH.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.oOP = false;
    AppMethodBeat.o(55164);
  }
  
  private void bRV()
  {
    AppMethodBeat.i(55165);
    al.d(new b.5(this));
    AppMethodBeat.o(55165);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(55162);
    this.oHk = paramVideoTransPara;
    if (this.oHk != null) {
      if (this.oHk.duration > 0) {}
    }
    for (this.oHk.duration = 10000;; this.oHk.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.oKD = paramVideoSeekBarEditorView;
      this.oKC = paramVideoPlayerTextureView;
      this.oOF = paramViewGroup;
      this.cmc = paramMMActivity;
      this.oOO = paramBoolean;
      this.oOS = new a.b(paramInt);
      this.oOz = paramVideoSeekBarEditorView.oQL;
      this.oOz.setVideoTransPara(this.oHk);
      bRT();
      AppMethodBeat.o(55162);
      return;
      ab.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.oHk = new VideoTransPara();
    }
  }
  
  public final String bRW()
  {
    AppMethodBeat.i(140588);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(140588);
    return str;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(55168);
    if (!this.oOU)
    {
      AppMethodBeat.o(55168);
      return false;
    }
    if (this.oOP)
    {
      bRU();
      AppMethodBeat.o(55168);
      return true;
    }
    if (this.oOG != null)
    {
      boolean bool = this.oOG.zY();
      AppMethodBeat.o(55168);
      return bool;
    }
    AppMethodBeat.o(55168);
    return false;
  }
  
  public final void p(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(55167);
    try
    {
      this.oOS.eUJ = paramBoolean;
      if (this.oOG == null)
      {
        ab.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(55167);
        return;
      }
      com.tencent.mm.api.p localp = this.oOG.zZ();
      this.oOS.oKq = localp.An();
      this.oOS.oKr = localp.Am();
      this.oOS.oKt = localp.Ap();
      this.oOS.ect = localp.Aq();
      this.oOS.oKu = localp.As();
      this.oOS.textColor = localp.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.oOS, paramString);
      AppMethodBeat.o(55167);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(55167);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(55166);
    try
    {
      if (this.oOE != null)
      {
        this.oOE.stopTimer();
        this.oOE = null;
      }
      if (this.oOz != null) {
        this.oOz.release();
      }
      if (this.oOG != null) {
        this.oOG.onDestroy();
      }
      if (this.oOF != null) {
        this.oOF.removeView(this.oOH);
      }
      if (this.oKD != null) {
        this.oKD.bSm();
      }
      this.oOA = false;
      j.oJp.XJ();
      AppMethodBeat.o(55166);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(55166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */