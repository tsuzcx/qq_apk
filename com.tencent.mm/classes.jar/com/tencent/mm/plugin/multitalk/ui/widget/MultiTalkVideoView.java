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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.m.a;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Map;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] vbX = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private String bLs;
  private au bYO;
  private TextPaint gZ;
  private int index;
  public int mId;
  private int mVideoHeight;
  private int mVideoWidth;
  private Paint owg;
  private int owh;
  private boolean owi;
  private boolean owj;
  private int position;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private String text;
  private String username;
  private MultiTalkVideoView.b vbY;
  a vbZ;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(114762);
    this.vbY = MultiTalkVideoView.b.vch;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {}
    for (boolean bool = true;; bool = false)
    {
      this.owi = bool;
      this.gZ = null;
      this.text = "";
      this.owj = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.owh = 0;
      this.mId = -1;
      this.vbZ = new a();
      initView();
      AppMethodBeat.o(114762);
      return;
    }
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(114763);
    this.vbY = MultiTalkVideoView.b.vch;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {}
    for (boolean bool = true;; bool = false)
    {
      this.owi = bool;
      this.gZ = null;
      this.text = "";
      this.owj = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.owh = 0;
      this.mId = -1;
      this.vbZ = new a();
      initView();
      AppMethodBeat.o(114763);
      return;
    }
  }
  
  private void aQW()
  {
    AppMethodBeat.i(178947);
    if (this.owj)
    {
      AppMethodBeat.o(178947);
      return;
    }
    this.owj = true;
    this.bYO = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(178945);
        com.tencent.e.h.JZN.aQ(new Runnable()
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
    this.bYO.au(1000L, 1000L);
    AppMethodBeat.o(178947);
  }
  
  private void dgP()
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
          ac.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
          AppMethodBeat.o(114771);
          continue;
        }
        localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
      }
      finally {}
      if (this.owi) {
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
        ac.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
        AppMethodBeat.o(114771);
      }
    }
  }
  
  private boolean dgQ()
  {
    return this.vbY == MultiTalkVideoView.b.vcf;
  }
  
  private void initView()
  {
    AppMethodBeat.i(114764);
    this.owg = new Paint();
    this.owg.setColor(-16777216);
    this.owg.setFilterBitmap(false);
    this.owg.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (this.owi)
    {
      this.owh = 0;
      this.gZ = new TextPaint();
      this.gZ.setColor(-65536);
      this.gZ.setTextSize(25.0F);
      this.gZ.setAntiAlias(true);
      this.owj = false;
      this.text = "debug...";
      aQW();
    }
    AppMethodBeat.o(114764);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(178948);
    if ((parama != null) && (parama.vcc != null) && (!parama.vcc.isRecycled()))
    {
      e(parama.vcc, parama.vcd, parama.vce);
      AppMethodBeat.o(178948);
      return;
    }
    dgP();
    AppMethodBeat.o(178948);
  }
  
  /* Error */
  public final void b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 279
    //   5: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 282	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:dgR	()Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 279
    //   18: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: invokestatic 288	com/tencent/mm/plugin/multitalk/model/p:dgy	()Lcom/tencent/mm/plugin/multitalk/model/m;
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: iload_3
    //   31: iload 4
    //   33: invokevirtual 293	com/tencent/mm/plugin/multitalk/model/m:a	(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;[IIII)Z
    //   36: pop
    //   37: ldc_w 279
    //   40: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(178946);
    ac.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    this.bLs = ((k)g.ab(k.class)).awB().aNt(paramString).aaR();
    this.mId = paramInt;
    AppMethodBeat.o(178946);
  }
  
  public final void dgL()
  {
    AppMethodBeat.i(114767);
    if (dgQ()) {
      p.dgy().a(this, true);
    }
    AppMethodBeat.o(114767);
  }
  
  public final void dgM()
  {
    AppMethodBeat.i(114768);
    if (bs.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(114768);
      return;
    }
    ac.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.vbY.name() });
    this.vbY = MultiTalkVideoView.b.vcf;
    dgL();
    AppMethodBeat.o(114768);
  }
  
  public final void dgN()
  {
    AppMethodBeat.i(114769);
    ac.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.vbY.name() });
    this.vbY = MultiTalkVideoView.b.vcg;
    a(this.vbZ);
    AppMethodBeat.o(114769);
  }
  
  public final void dgO()
  {
    AppMethodBeat.i(114770);
    ac.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.vbY.name() });
    this.vbY = MultiTalkVideoView.b.vch;
    this.username = null;
    this.mId = -1;
    dgP();
    AppMethodBeat.o(114770);
  }
  
  public final boolean dgR()
  {
    return this.vbY == MultiTalkVideoView.b.vcg;
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
          ac.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
          e.dfD();
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
        ac.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
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
          localCanvas.drawBitmap(paramBitmap, localMatrix, this.owg);
          this.vbZ.vcc = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
          this.vbZ.vcd = paramInt1;
          this.vbZ.vce = paramInt2;
          if (this.owi) {
            this.owh += 1;
          }
        }
        catch (Exception paramBitmap)
        {
          try
          {
            new StaticLayout(this.text, this.gZ, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw(localCanvas);
            try
            {
              unlockCanvasAndPost(localCanvas);
              AppMethodBeat.o(114766);
            }
            catch (Exception paramBitmap)
            {
              e.dfD();
              ac.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
              AppMethodBeat.o(114766);
            }
            if (paramInt1 != OpenGlRender.FLAG_Angle90) {
              break label172;
            }
            localMatrix.setRotate(90.0F, i / 2, j / 2);
            break label172;
            paramBitmap = paramBitmap;
            ac.e("MicroMsg.MT.MultiTalkVideoView", "draw bitmap error");
          }
          catch (Exception paramBitmap)
          {
            for (;;)
            {
              ac.i("MicroMsg.MT.MultiTalkVideoView", "draw debug error");
            }
          }
        }
      }
    }
  }
  
  public a getCurrentSnapShot()
  {
    return this.vbZ;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getNickName()
  {
    return this.bLs;
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
    ac.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceTexture = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    fiQ();
    ap.f(new Runnable()
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
      ac.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      if (this.bYO != null)
      {
        this.bYO.stopTimer();
        this.bYO = null;
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
    ac.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    ap.f(new Runnable()
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
    ac.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    AppMethodBeat.o(114777);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(114773);
    if (dgQ())
    {
      p.dgy().a(this, false);
      AppMethodBeat.o(114773);
      return;
    }
    if (dgR())
    {
      m.a locala = (m.a)p.dgy().uYx.get(getUsername());
      if (locala != null) {}
      for (Bitmap localBitmap = locala.uYz;; localBitmap = null)
      {
        if (localBitmap != null) {
          e(localBitmap, locala.angle, locala.mirror);
        }
        AppMethodBeat.o(114773);
        return;
      }
    }
    dgP();
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
    Bitmap vcc;
    int vcd;
    int vce;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView
 * JD-Core Version:    0.7.0.1
 */