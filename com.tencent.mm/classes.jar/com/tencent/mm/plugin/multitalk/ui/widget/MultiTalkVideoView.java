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
import com.tencent.mm.plugin.multitalk.a.m;
import com.tencent.mm.plugin.multitalk.a.m.a;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Map;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] mwE = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture aTk;
  private int fvV;
  private int fvW;
  private int index;
  private Paint mwF;
  private MultiTalkVideoView.a mwG = MultiTalkVideoView.a.mwK;
  private int position;
  private String username;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void blT()
  {
    if ((this.aTk == null) || (this.fvV == 0) || (this.fvW == 0)) {
      return;
    }
    Canvas localCanvas = lockCanvas(null);
    if (localCanvas == null)
    {
      y.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
      return;
    }
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localCanvas.drawColor(-14737113);
    localCanvas.drawColor(mwE[this.index]);
    try
    {
      unlockCanvasAndPost(localCanvas);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
    }
  }
  
  private boolean blU()
  {
    return this.mwG == MultiTalkVideoView.a.mwI;
  }
  
  private void initView()
  {
    this.mwF = new Paint();
    this.mwF.setColor(-16777216);
    this.mwF.setFilterBitmap(false);
    this.mwF.setTextSize(40.0F);
    setSurfaceTextureListener(this);
  }
  
  public final void IO(String paramString)
  {
    y.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
  }
  
  public final void aqU()
  {
    if (blU()) {
      p.blG().a(this, false);
    }
    for (;;)
    {
      return;
      if (!blV()) {
        break;
      }
      m.a locala = (m.a)p.blG().muN.get(getUsername());
      if (locala != null) {}
      for (Bitmap localBitmap = locala.muQ; localBitmap != null; localBitmap = null)
      {
        c(localBitmap, locala.angle, locala.muy);
        return;
      }
    }
    blT();
  }
  
  /* Error */
  public final void b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 157	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:blV	()Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: invokestatic 148	com/tencent/mm/plugin/multitalk/a/p:blG	()Lcom/tencent/mm/plugin/multitalk/a/m;
    //   19: aload_0
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: invokevirtual 194	com/tencent/mm/plugin/multitalk/a/m:a	(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;[IIII)Z
    //   28: pop
    //   29: goto -16 -> 13
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	MultiTalkVideoView
    //   0	37	1	paramArrayOfInt	int[]
    //   0	37	2	paramInt1	int
    //   0	37	3	paramInt2	int
    //   0	37	4	paramInt3	int
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	32	finally
    //   16	29	32	finally
  }
  
  public final void blP()
  {
    if (blU()) {
      p.blG().a(this, true);
    }
  }
  
  public final void blQ()
  {
    if (bk.bl(getUsername())) {
      return;
    }
    y.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.mwG.name() });
    this.mwG = MultiTalkVideoView.a.mwI;
    blP();
  }
  
  public final void blR()
  {
    y.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.mwG.name() });
    this.mwG = MultiTalkVideoView.a.mwJ;
  }
  
  public final void blS()
  {
    y.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.mwG.name() });
    this.mwG = MultiTalkVideoView.a.mwK;
    this.username = null;
    blT();
  }
  
  public final boolean blV()
  {
    return this.mwG == MultiTalkVideoView.a.mwJ;
  }
  
  public final void c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap != null) {}
    int i;
    int j;
    Canvas localCanvas;
    try
    {
      if (paramBitmap.isRecycled()) {
        y.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
      }
      for (;;)
      {
        return;
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if ((this.aTk != null) && (this.fvV != 0) && (this.fvW != 0))
        {
          localCanvas = lockCanvas(null);
          if (localCanvas != null) {
            break;
          }
          y.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
        }
      }
      localMatrix = new Matrix();
    }
    finally {}
    Matrix localMatrix;
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
          localCanvas.drawBitmap(paramBitmap, localMatrix, this.mwF);
        }
        try
        {
          unlockCanvasAndPost(localCanvas);
        }
        catch (Exception paramBitmap)
        {
          y.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
        }
      }
      break;
      if (paramInt1 == OpenGlRender.FLAG_Angle90) {
        localMatrix.setRotate(90.0F, i / 2, j / 2);
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
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.aTk = paramSurfaceTexture;
    this.fvV = paramInt1;
    this.fvW = paramInt2;
    cBe();
    e.post(new MultiTalkVideoView.1(this), "onSurfaceTextureAvailable_refreshView");
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.aTk = null;
      this.fvW = 0;
      this.fvV = 0;
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fvV = paramInt1;
    this.fvW = paramInt2;
    e.post(new MultiTalkVideoView.2(this), "onSurfaceTextureSizeChanged_refreshView");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
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