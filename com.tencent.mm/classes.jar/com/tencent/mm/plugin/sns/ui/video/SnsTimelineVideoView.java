package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.ae;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  SnsTimelineVideoView.a slS;
  public b slT;
  public String slU;
  long slV;
  private View slW;
  public boolean slX;
  public boolean slY;
  private SnsTimelineVideoView.b slZ;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145748);
    this.slS = SnsTimelineVideoView.a.smb;
    this.slV = 0L;
    this.slX = false;
    this.slY = false;
    this.slZ = null;
    init();
    AppMethodBeat.o(145748);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145749);
    this.slS = SnsTimelineVideoView.a.smb;
    this.slV = 0L;
    this.slX = false;
    this.slY = false;
    this.slZ = null;
    init();
    AppMethodBeat.o(145749);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145750);
    this.slS = SnsTimelineVideoView.a.smb;
    this.slV = 0L;
    this.slX = false;
    this.slY = false;
    this.slZ = null;
    init();
    AppMethodBeat.o(145750);
  }
  
  private void cxs()
  {
    AppMethodBeat.i(145759);
    if (this.slW != null)
    {
      this.slW.setAlpha(0.0F);
      ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(145759);
  }
  
  private void cxu()
  {
    AppMethodBeat.i(155778);
    if ((this.slZ != null) && (!bo.isNullOrNil(this.slU)))
    {
      this.slZ.BP(this.slU);
      this.slZ = null;
    }
    AppMethodBeat.o(155778);
  }
  
  private void init()
  {
    AppMethodBeat.i(145751);
    this.slW = findViewById(2131828188);
    AppMethodBeat.o(145751);
  }
  
  public final boolean Ds()
  {
    AppMethodBeat.i(145757);
    if ((this.kvG instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.kvG).Ds();
      AppMethodBeat.o(145757);
      return bool;
    }
    ab.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(145757);
    return false;
  }
  
  public final void ctY()
  {
    AppMethodBeat.i(145758);
    super.ctY();
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.slS = SnsTimelineVideoView.a.smd;
    this.slV = System.currentTimeMillis();
    cxs();
    dh(true);
    AppMethodBeat.o(145758);
  }
  
  public final void cxq()
  {
    AppMethodBeat.i(145755);
    if (this.rJi != null) {
      this.rJi.cun();
    }
    AppMethodBeat.o(145755);
  }
  
  public final void cxr()
  {
    AppMethodBeat.i(145756);
    lI(false);
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(145756);
  }
  
  public final void cxt()
  {
    AppMethodBeat.i(155777);
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    cxu();
    this.slU = "";
    this.slX = true;
    if (this.rJi != null)
    {
      this.rJi.cuf();
      this.rJi.clear();
      this.rJi = null;
    }
    d.ysm.execute(new SnsTimelineVideoView.1(this));
    AppMethodBeat.o(155777);
  }
  
  public final void lI(boolean paramBoolean)
  {
    AppMethodBeat.i(145754);
    super.crn();
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.slS = SnsTimelineVideoView.a.smc;
    if ((paramBoolean) && (this.slW != null))
    {
      this.slW.setAlpha(1.0F);
      ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    ctW();
    AppMethodBeat.o(145754);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(155779);
    cxu();
    this.slU = "";
    super.onDestroy();
    this.slX = false;
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(155779);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(145752);
    super.onDetachedFromWindow();
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE", new Object[] { Integer.valueOf(hashCode()) });
    this.slS = SnsTimelineVideoView.a.smb;
    if (!this.slY)
    {
      cxt();
      AppMethodBeat.o(145752);
      return;
    }
    this.slY = false;
    AppMethodBeat.o(145752);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145753);
    cxs();
    super.onResume();
    AppMethodBeat.o(145753);
  }
  
  public void setUICallback(SnsTimelineVideoView.b paramb)
  {
    AppMethodBeat.i(155780);
    ab.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.slZ = paramb;
    AppMethodBeat.o(155780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */