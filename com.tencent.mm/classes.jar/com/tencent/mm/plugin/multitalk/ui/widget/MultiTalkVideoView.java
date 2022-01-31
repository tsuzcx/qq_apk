package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.m.a;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Map;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] oWv = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture bbI;
  private int fbH;
  private int fbI;
  private int index;
  private Paint kMA;
  private MultiTalkVideoView.a oWw;
  private int position;
  private String username;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(54228);
    this.oWw = MultiTalkVideoView.a.oWA;
    initView();
    AppMethodBeat.o(54228);
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(54229);
    this.oWw = MultiTalkVideoView.a.oWA;
    initView();
    AppMethodBeat.o(54229);
  }
  
  private void bTT()
  {
    AppMethodBeat.i(54237);
    if ((this.bbI == null) || (this.fbH == 0) || (this.fbI == 0))
    {
      AppMethodBeat.o(54237);
      return;
    }
    Canvas localCanvas = lockCanvas(null);
    if (localCanvas == null)
    {
      ab.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
      AppMethodBeat.o(54237);
      return;
    }
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localCanvas.drawColor(-14737113);
    localCanvas.drawColor(oWv[this.index]);
    try
    {
      unlockCanvasAndPost(localCanvas);
      AppMethodBeat.o(54237);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
      AppMethodBeat.o(54237);
    }
  }
  
  private boolean bTU()
  {
    return this.oWw == MultiTalkVideoView.a.oWy;
  }
  
  private void initView()
  {
    AppMethodBeat.i(54230);
    this.kMA = new Paint();
    this.kMA.setColor(-16777216);
    this.kMA.setFilterBitmap(false);
    this.kMA.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(54230);
  }
  
  public final void UE(String paramString)
  {
    AppMethodBeat.i(54238);
    ab.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    AppMethodBeat.o(54238);
  }
  
  /* Error */
  public final void b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 154
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 157	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:bTV	()Z
    //   11: ifne +11 -> 22
    //   14: ldc 154
    //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 163	com/tencent/mm/plugin/multitalk/model/p:bTG	()Lcom/tencent/mm/plugin/multitalk/model/m;
    //   25: aload_0
    //   26: aload_1
    //   27: iload_2
    //   28: iload_3
    //   29: iload 4
    //   31: invokevirtual 169	com/tencent/mm/plugin/multitalk/model/m:a	(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;[IIII)Z
    //   34: pop
    //   35: ldc 154
    //   37: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MultiTalkVideoView
    //   0	48	1	paramArrayOfInt	int[]
    //   0	48	2	paramInt1	int
    //   0	48	3	paramInt2	int
    //   0	48	4	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  public final void bTP()
  {
    AppMethodBeat.i(54233);
    if (bTU()) {
      p.bTG().a(this, true);
    }
    AppMethodBeat.o(54233);
  }
  
  public final void bTQ()
  {
    AppMethodBeat.i(54234);
    if (bo.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(54234);
      return;
    }
    ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.oWw.name() });
    this.oWw = MultiTalkVideoView.a.oWy;
    bTP();
    AppMethodBeat.o(54234);
  }
  
  public final void bTR()
  {
    AppMethodBeat.i(54235);
    ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.oWw.name() });
    this.oWw = MultiTalkVideoView.a.oWz;
    AppMethodBeat.o(54235);
  }
  
  public final void bTS()
  {
    AppMethodBeat.i(54236);
    ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.oWw.name() });
    this.oWw = MultiTalkVideoView.a.oWA;
    this.username = null;
    bTT();
    AppMethodBeat.o(54236);
  }
  
  public final boolean bTV()
  {
    return this.oWw == MultiTalkVideoView.a.oWz;
  }
  
  public final void d(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(54232);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          ab.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
          AppMethodBeat.o(54232);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if ((this.bbI == null) || (this.fbH == 0) || (this.fbI == 0))
        {
          AppMethodBeat.o(54232);
          continue;
        }
        localCanvas = lockCanvas(null);
      }
      finally {}
      Canvas localCanvas;
      if (localCanvas == null)
      {
        ab.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
        AppMethodBeat.o(54232);
      }
      else
      {
        Matrix localMatrix = new Matrix();
        if (paramInt1 == OpenGlRender.FLAG_Angle270) {
          localMatrix.setRotate(270.0F, i / 2, j / 2);
        }
        for (;;)
        {
          for (;;)
          {
            if (paramInt2 == OpenGlRender.FLAG_Mirror)
            {
              localMatrix.postScale(-1.0F, 1.0F);
              localMatrix.postTranslate(i, 0.0F);
            }
            localMatrix.postScale(localCanvas.getWidth() / j, localCanvas.getHeight() / i);
            localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (!paramBitmap.isRecycled()) {
              localCanvas.drawBitmap(paramBitmap, localMatrix, this.kMA);
            }
            try
            {
              unlockCanvasAndPost(localCanvas);
              AppMethodBeat.o(54232);
            }
            catch (Exception paramBitmap)
            {
              ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
              AppMethodBeat.o(54232);
            }
          }
          if (paramInt1 == OpenGlRender.FLAG_Angle90) {
            localMatrix.setRotate(90.0F, i / 2, j / 2);
          }
        }
      }
    }
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(54240);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bbI = paramSurfaceTexture;
    this.fbH = paramInt1;
    this.fbI = paramInt2;
    dEs();
    d.post(new MultiTalkVideoView.1(this), "onSurfaceTextureAvailable_refreshView");
    AppMethodBeat.o(54240);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(54242);
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.bbI = null;
      this.fbI = 0;
      this.fbH = 0;
      AppMethodBeat.o(54242);
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(54241);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fbH = paramInt1;
    this.fbI = paramInt2;
    d.post(new MultiTalkVideoView.2(this), "onSurfaceTextureSizeChanged_refreshView");
    AppMethodBeat.o(54241);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    AppMethodBeat.i(54243);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    AppMethodBeat.o(54243);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(54239);
    if (bTU())
    {
      p.bTG().a(this, false);
      AppMethodBeat.o(54239);
      return;
    }
    if (bTV())
    {
      m.a locala = (m.a)p.bTG().oUC.get(getUsername());
      if (locala != null) {}
      for (Bitmap localBitmap = locala.oUE;; localBitmap = null)
      {
        if (localBitmap != null) {
          d(localBitmap, locala.angle, locala.oUn);
        }
        AppMethodBeat.o(54239);
        return;
      }
    }
    bTT();
    AppMethodBeat.o(54239);
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView
 * JD-Core Version:    0.7.0.1
 */