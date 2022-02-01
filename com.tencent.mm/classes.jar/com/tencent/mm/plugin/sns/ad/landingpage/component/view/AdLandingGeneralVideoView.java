package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sns.ad.d.d;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public class AdLandingGeneralVideoView
  extends MMVideoView
{
  protected int JCb = 0;
  private boolean JCc = false;
  private String mfn;
  
  public AdLandingGeneralVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdLandingGeneralVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingGeneralVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(193622);
    if (!Util.isNullOrNil(this.mfn))
    {
      str = this.mfn;
      AppMethodBeat.o(193622);
      return str;
    }
    String str = b.aSL() + "video/";
    AppMethodBeat.o(193622);
    return str;
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(193628);
    paramBoolean = super.I(paramInt, paramBoolean);
    if ((this.mfw == 3) && (this.JCb == 1)) {
      this.mfA = -1;
    }
    AppMethodBeat.o(193628);
    return paramBoolean;
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(193614);
    if (!(paramh instanceof View))
    {
      Log.w(this.TAG, "%s set video footer view but is not view", new Object[] { bqf() });
      AppMethodBeat.o(193614);
      return;
    }
    egX();
    this.Rby = paramh;
    this.pDS = false;
    AppMethodBeat.o(193614);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(193626);
    switch (this.JCb)
    {
    default: 
      boolean bool = super.a(paramInt, paramPInt1, paramPInt2);
      AppMethodBeat.o(193626);
      return bool;
    }
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1) {
      paramPInt1.value = paramInt;
    }
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
    }
    if ((this.mfx == 3) || (this.mfx == 4)) {
      paramPInt1.value = this.mfD;
    }
    paramPInt2.value = (this.mfz + 1);
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bqf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE), this.mfu });
    AppMethodBeat.o(193626);
    return true;
  }
  
  public final ObjectAnimator b(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193633);
    paramString = ObjectAnimator.ofFloat(this, paramString, new float[] { paramFloat1, paramFloat2 });
    AppMethodBeat.o(193633);
    return paramString;
  }
  
  public final String bqf()
  {
    AppMethodBeat.i(193631);
    String str = this.mfu + " ";
    AppMethodBeat.o(193631);
    return str;
  }
  
  public final void bqi()
  {
    AppMethodBeat.i(193620);
    if (!Util.isNullOrNil(this.url))
    {
      this.mfu = d.cp("AdLandingGeneralVideo_" + this.url.hashCode(), this.JCc);
      this.mfv = (getRootPath() + "AdLandingGeneralVideo_" + this.url.hashCode() + ".mp4");
      u.bBD(u.bBT(this.mfv));
      Log.i(this.TAG, "%s set video path [%s %s]", new Object[] { bqf(), this.mfu, this.mfv });
    }
    AppMethodBeat.o(193620);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(193616);
    Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bqf(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.JCc = d.fJQ();
    this.bjq = paramBoolean;
    this.url = d.co(paramString, this.JCc);
    this.pvi = paramInt;
    bqL(this.url);
    bqi();
    AppMethodBeat.o(193616);
  }
  
  public View getThumbView()
  {
    return this.pDJ;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(193612);
    super.initView();
    this.TAG = "MicroMsg.AdLandingGeneralVideoView";
    AppMethodBeat.o(193612);
  }
  
  public void setRootPath(String paramString)
  {
    this.mfn = paramString;
  }
  
  protected void setVideoPlayerMode(int paramInt)
  {
    this.JCb = paramInt;
  }
  
  public final List<Animator> t(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(193632);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = b("scaleX", paramFloat3, paramFloat4);
    ObjectAnimator localObjectAnimator3 = b("scaleY", paramFloat3, paramFloat4);
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    AppMethodBeat.o(193632);
    return localLinkedList;
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(193630);
    switch (this.JCb)
    {
    default: 
      boolean bool = super.xb(paramInt);
      AppMethodBeat.o(193630);
      return bool;
    }
    if ((this.mfz - this.mfD <= 1) || (this.mfw == 3))
    {
      AppMethodBeat.o(193630);
      return true;
    }
    AppMethodBeat.o(193630);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoView
 * JD-Core Version:    0.7.0.1
 */