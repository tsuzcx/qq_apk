package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.m.a;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Map;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] tTp = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private av cbR;
  private TextPaint ga;
  private int index;
  public int mId;
  private int mVideoHeight;
  private int mVideoWidth;
  private Paint nSL;
  private int nSM;
  private boolean nSN;
  private boolean nSO;
  private int position;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private MultiTalkVideoView.b tTq;
  a tTr;
  private String text;
  private String username;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(114762);
    this.tTq = MultiTalkVideoView.b.tTz;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.nSN = bool;
      this.ga = null;
      this.text = "";
      this.nSO = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.nSM = 0;
      this.mId = -1;
      this.tTr = new a();
      initView();
      AppMethodBeat.o(114762);
      return;
    }
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(114763);
    this.tTq = MultiTalkVideoView.b.tTz;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.nSN = bool;
      this.ga = null;
      this.text = "";
      this.nSO = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.nSM = 0;
      this.mId = -1;
      this.tTr = new a();
      initView();
      AppMethodBeat.o(114763);
      return;
    }
  }
  
  private void aKf()
  {
    AppMethodBeat.i(178947);
    if (this.nSO)
    {
      AppMethodBeat.o(178947);
      return;
    }
    this.nSO = true;
    this.cbR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(178945);
        com.tencent.e.h.Iye.aN(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(178944);
            MultiTalkVideoView.a(MultiTalkVideoView.this);
            AppMethodBeat.o(178944);
          }
        });
        AppMethodBeat.o(178945);
        return true;
      }
    }, true);
    this.cbR.av(1000L, 1000L);
    AppMethodBeat.o(178947);
  }
  
  private void cTf()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114771);
        if ((this.surfaceTexture == null) || (this.surfaceWidth == 0) || (this.surfaceHeight == 0))
        {
          AppMethodBeat.o(114771);
          return;
        }
        Canvas localCanvas1 = lockCanvas(null);
        if (localCanvas1 == null)
        {
          ad.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
          AppMethodBeat.o(114771);
          continue;
        }
        localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
      }
      finally {}
      if (this.nSN) {
        localCanvas2.drawColor(-65536);
      }
      this.text = "drawing none";
      try
      {
        unlockCanvasAndPost(localCanvas2);
        AppMethodBeat.o(114771);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
        AppMethodBeat.o(114771);
      }
    }
  }
  
  private boolean cTg()
  {
    return this.tTq == MultiTalkVideoView.b.tTx;
  }
  
  private void initView()
  {
    AppMethodBeat.i(114764);
    this.nSL = new Paint();
    this.nSL.setColor(-16777216);
    this.nSL.setFilterBitmap(false);
    this.nSL.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (this.nSN)
    {
      this.nSM = 0;
      this.ga = new TextPaint();
      this.ga.setColor(-65536);
      this.ga.setTextSize(25.0F);
      this.ga.setAntiAlias(true);
      this.nSO = false;
      this.text = "debug...";
      aKf();
    }
    AppMethodBeat.o(114764);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(178948);
    if ((parama != null) && (parama.tTu != null) && (!parama.tTu.isRecycled()))
    {
      e(parama.tTu, parama.tTv, parama.tTw);
      AppMethodBeat.o(178948);
      return;
    }
    cTf();
    AppMethodBeat.o(178948);
  }
  
  /* Error */
  public final void b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 278
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 281	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:cTh	()Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 278
    //   18: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: invokestatic 287	com/tencent/mm/plugin/multitalk/model/p:cSP	()Lcom/tencent/mm/plugin/multitalk/model/m;
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: iload_3
    //   31: iload 4
    //   33: invokevirtual 292	com/tencent/mm/plugin/multitalk/model/m:a	(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;[IIII)Z
    //   36: pop
    //   37: ldc_w 278
    //   40: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -22 -> 21
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	MultiTalkVideoView
    //   0	51	1	paramArrayOfInt	int[]
    //   0	51	2	paramInt1	int
    //   0	51	3	paramInt2	int
    //   0	51	4	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   2	21	46	finally
    //   24	43	46	finally
  }
  
  public final void cTb()
  {
    AppMethodBeat.i(114767);
    if (cTg()) {
      p.cSP().a(this, true);
    }
    AppMethodBeat.o(114767);
  }
  
  public final void cTc()
  {
    AppMethodBeat.i(114768);
    if (bt.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(114768);
      return;
    }
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.tTq.name() });
    this.tTq = MultiTalkVideoView.b.tTx;
    cTb();
    AppMethodBeat.o(114768);
  }
  
  public final void cTd()
  {
    AppMethodBeat.i(114769);
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.tTq.name() });
    this.tTq = MultiTalkVideoView.b.tTy;
    a(this.tTr);
    AppMethodBeat.o(114769);
  }
  
  public final void cTe()
  {
    AppMethodBeat.i(114770);
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.tTq.name() });
    this.tTq = MultiTalkVideoView.b.tTz;
    this.username = null;
    this.mId = -1;
    cTf();
    AppMethodBeat.o(114770);
  }
  
  public final boolean cTh()
  {
    return this.tTq == MultiTalkVideoView.b.tTy;
  }
  
  public final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(178946);
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    this.mId = paramInt;
    AppMethodBeat.o(178946);
  }
  
  public final void e(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(114766);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          ad.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
          e.cRT();
          AppMethodBeat.o(114766);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if ((this.surfaceTexture == null) || (this.surfaceWidth == 0) || (this.surfaceHeight == 0))
        {
          AppMethodBeat.o(114766);
          continue;
        }
        this.mVideoWidth = i;
      }
      finally {}
      this.mVideoHeight = j;
      Canvas localCanvas = lockCanvas(null);
      if (localCanvas == null)
      {
        ad.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
        AppMethodBeat.o(114766);
      }
      else
      {
        Matrix localMatrix = new Matrix();
        if (paramInt1 == OpenGlRender.FLAG_Angle270)
        {
          localMatrix.setRotate(270.0F, i / 2, j / 2);
          label172:
          if (paramInt2 == OpenGlRender.FLAG_Mirror)
          {
            localMatrix.postScale(-1.0F, 1.0F);
            localMatrix.postTranslate(i, 0.0F);
          }
          localMatrix.postScale(localCanvas.getWidth() / j, localCanvas.getHeight() / i);
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          boolean bool = paramBitmap.isRecycled();
          if (bool) {}
        }
        try
        {
          localCanvas.drawBitmap(paramBitmap, localMatrix, this.nSL);
          this.tTr.tTu = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
          this.tTr.tTv = paramInt1;
          this.tTr.tTw = paramInt2;
          if (this.nSN) {
            this.nSM += 1;
          }
        }
        catch (Exception paramBitmap)
        {
          try
          {
            new StaticLayout(this.text, this.ga, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw(localCanvas);
            try
            {
              unlockCanvasAndPost(localCanvas);
              AppMethodBeat.o(114766);
            }
            catch (Exception paramBitmap)
            {
              e.cRT();
              ad.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
              AppMethodBeat.o(114766);
            }
            if (paramInt1 != OpenGlRender.FLAG_Angle90) {
              break label172;
            }
            localMatrix.setRotate(90.0F, i / 2, j / 2);
            break label172;
            paramBitmap = paramBitmap;
            ad.e("MicroMsg.MT.MultiTalkVideoView", "draw bitmap error");
          }
          catch (Exception paramBitmap)
          {
            for (;;)
            {
              ad.i("MicroMsg.MT.MultiTalkVideoView", "draw debug error");
            }
          }
        }
      }
    }
  }
  
  public a getCurrentSnapShot()
  {
    return this.tTr;
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
    AppMethodBeat.i(114774);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceTexture = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    eTg();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114757);
        MultiTalkVideoView.this.refreshView();
        AppMethodBeat.o(114757);
      }
    });
    AppMethodBeat.o(114774);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(114776);
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      if (this.cbR != null)
      {
        this.cbR.stopTimer();
        this.cbR = null;
      }
      AppMethodBeat.o(114776);
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(114775);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114758);
        MultiTalkVideoView.this.refreshView();
        AppMethodBeat.o(114758);
      }
    });
    AppMethodBeat.o(114775);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    AppMethodBeat.i(114777);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ad.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    AppMethodBeat.o(114777);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(114773);
    if (cTg())
    {
      p.cSP().a(this, false);
      AppMethodBeat.o(114773);
      return;
    }
    if (cTh())
    {
      m.a locala = (m.a)p.cSP().tPX.get(getUsername());
      if (locala != null) {}
      for (Bitmap localBitmap = locala.tPZ;; localBitmap = null)
      {
        if (localBitmap != null) {
          e(localBitmap, locala.angle, locala.mirror);
        }
        AppMethodBeat.o(114773);
        return;
      }
    }
    cTf();
    AppMethodBeat.o(114773);
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  final class a
  {
    Bitmap tTu;
    int tTv;
    int tTw;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView
 * JD-Core Version:    0.7.0.1
 */