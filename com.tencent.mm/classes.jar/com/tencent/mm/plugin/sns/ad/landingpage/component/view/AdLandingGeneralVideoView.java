package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;

public class AdLandingGeneralVideoView
  extends MMVideoView
{
  protected int PSx = 0;
  private boolean PSy = false;
  private String oYg;
  
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
  
  private ObjectAnimator d(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(310665);
    paramString = ObjectAnimator.ofFloat(this, paramString, new float[] { paramFloat1, paramFloat2 });
    AppMethodBeat.o(310665);
    return paramString;
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(310660);
    if (!Util.isNullOrNil(this.oYg))
    {
      str = this.oYg;
      AppMethodBeat.o(310660);
      return str;
    }
    String str = b.bmz() + "video/";
    AppMethodBeat.o(310660);
    return str;
  }
  
  public final boolean X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310705);
    Log.i(this.XXD, "seekTo, time = " + paramInt + ", afterSeekPlay = " + paramBoolean);
    paramBoolean = super.X(paramInt, paramBoolean);
    if ((this.oYs == 3) && (this.PSx == 1)) {
      this.oYw = -1;
    }
    AppMethodBeat.o(310705);
    return paramBoolean;
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(310674);
    if (!(paramh instanceof View))
    {
      Log.w(this.TAG, "%s set video footer view but is not view", new Object[] { bNL() });
      AppMethodBeat.o(310674);
      return;
    }
    eLM();
    this.XXF = paramh;
    this.sJe = false;
    AppMethodBeat.o(310674);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(310699);
    switch (this.PSx)
    {
    default: 
      boolean bool = super.a(paramInt, paramPInt1, paramPInt2);
      AppMethodBeat.o(310699);
      return bool;
    }
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1) {
      paramPInt1.value = paramInt;
    }
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
    }
    if ((this.oYt == 3) || (this.oYt == 4)) {
      paramPInt1.value = this.oYz;
    }
    paramPInt2.value = (this.oYv + 1);
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bNL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA), this.oYq });
    AppMethodBeat.o(310699);
    return true;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(310685);
    Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bNL(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.PSy = e.gZH();
    this.ddk = paramBoolean;
    this.url = e.cO(paramString, this.PSy);
    this.sAo = paramInt;
    bqA(this.url);
    bNO();
    AppMethodBeat.o(310685);
  }
  
  public final String bNL()
  {
    AppMethodBeat.i(310733);
    String str = this.oYq + " ";
    AppMethodBeat.o(310733);
    return str;
  }
  
  public final void bNO()
  {
    AppMethodBeat.i(310689);
    if (!Util.isNullOrNil(this.url))
    {
      this.oYq = e.cP("AdLandingGeneralVideo_" + this.url.hashCode(), this.PSy);
      this.oYr = (getRootPath() + "AdLandingGeneralVideo_" + this.url.hashCode() + ".mp4");
      y.bDX(y.bEo(this.oYr));
      Log.i(this.TAG, "%s set video path [%s %s]", new Object[] { bNL(), this.oYq, this.oYr });
      Log.i(this.XXD, "setVideoPath, cdnMediaId = " + this.oYq + ", url = " + this.url);
    }
    AppMethodBeat.o(310689);
  }
  
  public ImageView getThumbView()
  {
    return this.sIV;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(310670);
    super.initView();
    this.TAG = "MicroMsg.AdLandingGeneralVideoView";
    this.XXD = "VideoView.AdLandingGeneralVideoView";
    if ((this.wCd instanceof VideoPlayerTextureView)) {
      ((VideoPlayerTextureView)this.wCd).setNeedOperateSurfaceTexture(true);
    }
    AppMethodBeat.o(310670);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(310749);
    try
    {
      super.onUIDestroy();
      if ((this.wCd instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.wCd).releaseSurfaceTexture();
      }
      AppMethodBeat.o(310749);
      return;
    }
    finally
    {
      Log.e(this.TAG, localObject.toString());
      AppMethodBeat.o(310749);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.oYg = paramString;
  }
  
  protected void setVideoPlayerMode(int paramInt)
  {
    this.PSx = paramInt;
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(310711);
    switch (this.PSx)
    {
    default: 
      boolean bool = super.xb(paramInt);
      AppMethodBeat.o(310711);
      return bool;
    }
    if ((this.oYv - this.oYz <= 1) || (this.oYs == 3))
    {
      AppMethodBeat.o(310711);
      return true;
    }
    AppMethodBeat.o(310711);
    return false;
  }
  
  public final List<Animator> y(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(310742);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = d("scaleX", paramFloat3, paramFloat4);
    ObjectAnimator localObjectAnimator3 = d("scaleY", paramFloat3, paramFloat4);
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    AppMethodBeat.o(310742);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoView
 * JD-Core Version:    0.7.0.1
 */