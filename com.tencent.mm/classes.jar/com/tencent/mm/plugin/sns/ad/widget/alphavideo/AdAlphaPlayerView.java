package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;

public class AdAlphaPlayerView
  extends FrameLayout
  implements f.a
{
  public b QeG;
  public com.tencent.mm.plugin.thumbplayer.e.a QeH;
  public a QeI;
  private AssetFileDescriptor QeJ;
  public boolean QeK;
  public boolean QeL;
  public boolean QeM;
  private androidx.core.f.a<Void> QeN;
  public String eDC;
  public TextureView eDa;
  public boolean qRV = false;
  public boolean sIt = false;
  
  public AdAlphaPlayerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdAlphaPlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private com.tencent.mm.plugin.thumbplayer.e.a getPlayer()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   9: ifnonnull +31 -> 40
    //   12: aload_0
    //   13: aload_0
    //   14: invokespecial 196	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:hcE	()Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   17: putfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   25: invokespecial 199	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:setDataSource	(Lcom/tencent/mm/plugin/thumbplayer/e/a;)V
    //   28: aload_0
    //   29: getfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   32: astore_1
    //   33: ldc 191
    //   35: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_0
    //   41: getfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   44: invokeinterface 202 1 0
    //   49: goto -29 -> 20
    //   52: astore_1
    //   53: ldc 92
    //   55: ldc 204
    //   57: aload_1
    //   58: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 216	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_0
    //   76: aload_0
    //   77: invokespecial 196	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:hcE	()Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   80: putfield 193	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
    //   83: goto -63 -> 20
    //   86: astore_1
    //   87: ldc 92
    //   89: ldc 221
    //   91: aload_1
    //   92: invokestatic 224	com/tencent/mm/plugin/sns/ad/widget/alphavideo/c:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: invokestatic 230	com/tencent/mm/plugin/sns/ad/widget/alphavideo/d:hcO	()Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/d;
    //   98: pop
    //   99: new 10	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView$10
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 233	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView$10:<init>	(Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;)V
    //   107: invokestatic 237	com/tencent/mm/plugin/sns/ad/widget/alphavideo/d:runOnUiThread	(Ljava/lang/Runnable;)V
    //   110: goto -82 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	AdAlphaPlayerView
    //   32	7	1	locala	com.tencent.mm.plugin.thumbplayer.e.a
    //   52	19	1	localObject	Object
    //   86	6	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	49	52	finally
    //   20	28	86	finally
  }
  
  private com.tencent.mm.plugin.thumbplayer.e.a hcE()
  {
    AppMethodBeat.i(310513);
    Object localObject = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
    localObject = d.a.kr(getContext());
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setPlayerOptionalParam(new TPOptionalParam().buildLong(203, 1L));
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, new int[] { 102 }));
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnPlayerStateChangeListener(new ITPPlayerListener.IOnStateChangeListener()
    {
      public final void onStateChange(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(310499);
        c.i("AdAlphaPlayerView", "onStateChange() called with: preState = [" + paramAnonymousInt1 + "], curState = [" + paramAnonymousInt2 + "]");
        if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
          AdAlphaPlayerView.a(AdAlphaPlayerView.this);
        }
        if (paramAnonymousInt2 == 4) {}
        try
        {
          if (AdAlphaPlayerView.b(AdAlphaPlayerView.this)) {
            this.QeO.start();
          }
          AppMethodBeat.o(310499);
          return;
        }
        finally
        {
          Log.e("AdAlphaPlayerView", "try start error", new Object[] { localObject });
          AppMethodBeat.o(310499);
        }
      }
    });
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnErrorListener(new ITPPlayerListener.IOnErrorListener()
    {
      public final void onError(ITPPlayer paramAnonymousITPPlayer, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(310468);
        c.e("AdAlphaPlayerView", "onError() called with: player = [" + paramAnonymousITPPlayer + "], errorType = [" + paramAnonymousInt1 + "], errorCode = [" + paramAnonymousInt2 + "], arg1 = [" + paramAnonymousLong1 + "], arg2 = [" + paramAnonymousLong2 + "]");
        h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310482);
            Log.d("AdAlphaPlayerView", "setAlpha(0) called");
            AdAlphaPlayerView.this.setAlpha(0.0F);
            AppMethodBeat.o(310482);
          }
        });
        if (AdAlphaPlayerView.c(AdAlphaPlayerView.this) != null) {
          AdAlphaPlayerView.c(AdAlphaPlayerView.this).onDestroy();
        }
        try
        {
          if (AdAlphaPlayerView.this.QeH != null)
          {
            AdAlphaPlayerView.this.QeH.stopAsync();
            AdAlphaPlayerView.this.QeH.release();
          }
          AppMethodBeat.o(310468);
          return;
        }
        finally
        {
          Log.d("AdAlphaPlayerView", "onError ", new Object[] { paramAnonymousITPPlayer });
          AppMethodBeat.o(310468);
        }
      }
    });
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnCompletionListener(new ITPPlayerListener.IOnCompletionListener()
    {
      public final void onCompletion(ITPPlayer paramAnonymousITPPlayer)
      {
        AppMethodBeat.i(310471);
        c.i("AdAlphaPlayerView", "onCompletion");
        if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
          AdAlphaPlayerView.a(AdAlphaPlayerView.this).ajV(5);
        }
        AppMethodBeat.o(310471);
      }
    });
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnVideoSizeChangedListener(new ITPPlayerListener.IOnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(ITPPlayer paramAnonymousITPPlayer, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(310476);
        c.d("AdAlphaPlayerView", "onVideoSizeChanged() called with: player = [" + paramAnonymousITPPlayer + "], width = [" + paramAnonymousLong1 + "], height = [" + paramAnonymousLong2 + "]");
        AppMethodBeat.o(310476);
      }
    });
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnInfoListener(new ITPPlayerListener.IOnInfoListener()
    {
      public final void onInfo(ITPPlayer paramAnonymousITPPlayer, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(310484);
        c.i("AdAlphaPlayerView", "onInfo() called with: player = [" + paramAnonymousITPPlayer + "], what = [" + paramAnonymousInt + "], arg1 = [" + paramAnonymousLong1 + "], arg2 = [" + paramAnonymousLong2 + "], extraObject = [" + paramAnonymousObject + "]");
        AppMethodBeat.o(310484);
      }
    });
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOutputMute(true);
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setLoopback(this.QeK);
    AppMethodBeat.o(310513);
    return localObject;
  }
  
  private void setDataSource(com.tencent.mm.plugin.thumbplayer.e.a parama)
  {
    AppMethodBeat.i(310528);
    if (parama == null)
    {
      AppMethodBeat.o(310528);
      return;
    }
    if (!TextUtils.isEmpty(this.eDC))
    {
      parama.setDataSource(this.eDC);
      AppMethodBeat.o(310528);
      return;
    }
    if (this.QeJ == null) {
      c.e("AdAlphaPlayerView", "setDataSource failed: source is null");
    }
    AppMethodBeat.o(310528);
  }
  
  public final void hcF()
  {
    AppMethodBeat.i(310623);
    c.i("AdAlphaPlayerView", "onOpenGLInit");
    AppMethodBeat.o(310623);
  }
  
  public final void hcG()
  {
    AppMethodBeat.i(310629);
    c.e("AdAlphaPlayerView", "onOpenGLInitFailed");
    d.hcO();
    d.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310511);
        if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
          AdAlphaPlayerView.a(AdAlphaPlayerView.this).j(AdAlphaPlayerView.this, "opengl context init failed");
        }
        AppMethodBeat.o(310511);
      }
    });
    AppMethodBeat.o(310629);
  }
  
  public final void hcH()
  {
    AppMethodBeat.i(310639);
    c.i("AdAlphaPlayerView", "onOpenGLComponentsInit");
    final com.tencent.mm.plugin.thumbplayer.e.a locala = getPlayer();
    if (locala == null)
    {
      AppMethodBeat.o(310639);
      return;
    }
    try
    {
      locala.setSurface(new Surface(this.QeG.Qfa));
      locala.setOnPreparedListener(new ITPPlayerListener.IOnPreparedListener()
      {
        public final void onPrepared(ITPPlayer paramAnonymousITPPlayer)
        {
          AppMethodBeat.i(310515);
          c.i("AdAlphaPlayerView", "onGLComponentsInited: videosize(" + locala.getVideoWidth() + ", " + locala.getVideoHeight() + ")");
          AdAlphaPlayerView.e(AdAlphaPlayerView.this);
          if (AdAlphaPlayerView.f(AdAlphaPlayerView.this) != null)
          {
            AdAlphaPlayerView.f(AdAlphaPlayerView.this).accept(null);
            AdAlphaPlayerView.g(AdAlphaPlayerView.this);
          }
          AppMethodBeat.o(310515);
        }
      });
      locala.prepareAsync();
      h.ahAA.bk(new AdAlphaPlayerView..ExternalSyntheticLambda0(this, locala));
      AppMethodBeat.o(310639);
      return;
    }
    finally
    {
      for (;;)
      {
        d.hcO();
        d.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310467);
            if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
              AdAlphaPlayerView.a(AdAlphaPlayerView.this).j(AdAlphaPlayerView.this, "player start error");
            }
            AppMethodBeat.o(310467);
          }
        });
        c.e("AdAlphaPlayerView", "start the video failed!", localThrowable);
      }
    }
  }
  
  public final void hcI()
  {
    AppMethodBeat.i(310641);
    c.e("AdAlphaPlayerView", "onOpenGLComponentsInitFailed");
    d.hcO();
    d.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310450);
        if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
          AdAlphaPlayerView.a(AdAlphaPlayerView.this).j(AdAlphaPlayerView.this, "opengl component init failed");
        }
        AppMethodBeat.o(310450);
      }
    });
    AppMethodBeat.o(310641);
  }
  
  public final void hcJ()
  {
    AppMethodBeat.i(310644);
    c.i("AdAlphaPlayerView", "onOpenGLComponentsRelease");
    AppMethodBeat.o(310644);
  }
  
  public final void hcK()
  {
    AppMethodBeat.i(310647);
    c.i("AdAlphaPlayerView", "onOpenGLRelease");
    AppMethodBeat.o(310647);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310615);
    c.i("AdAlphaPlayerView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    AppMethodBeat.o(310615);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310609);
    c.i("AdAlphaPlayerView", "onSizeChanged w:" + paramInt1 + " h:" + paramInt2);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.QeG != null) {
      this.QeG.setSurfaceSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(310609);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(310597);
    c.i("AdAlphaPlayerView", "resumeAd");
    this.qRV = true;
    if (this.QeI != null) {
      this.QeI.ajV(2);
    }
    try
    {
      if (this.QeH != null) {
        this.QeH.start();
      }
      if (this.QeG != null) {
        this.QeG.onResume();
      }
      AppMethodBeat.o(310597);
      return;
    }
    finally
    {
      c.e("AdAlphaPlayerView", "resume failed", localThrowable);
      AppMethodBeat.o(310597);
    }
  }
  
  public void setOnPrepared(androidx.core.f.a<Void> parama)
  {
    this.QeN = parama;
  }
  
  public void setPrepared(boolean paramBoolean)
  {
    this.sIt = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(310604);
    if (this.QeI != null) {
      this.QeI.ajV(4);
    }
    try
    {
      d.hcO();
      d.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(310456);
          if (AdAlphaPlayerView.a(AdAlphaPlayerView.this) != null) {
            AdAlphaPlayerView.a(AdAlphaPlayerView.this).jn(AdAlphaPlayerView.this);
          }
          AppMethodBeat.o(310456);
        }
      });
      if (this.QeG != null) {
        this.QeG.onDestroy();
      }
      if (this.QeH != null) {
        h.ahAA.bm(new Runnable()
        {
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: ldc 20
            //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 14	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView$5:QeP	Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;
            //   9: astore_1
            //   10: aload_1
            //   11: monitorenter
            //   12: aload_0
            //   13: getfield 14	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView$5:QeP	Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;
            //   16: getfield 30	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
            //   19: invokeinterface 35 1 0
            //   24: aload_0
            //   25: getfield 14	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView$5:QeP	Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;
            //   28: getfield 30	com/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView:QeH	Lcom/tencent/mm/plugin/thumbplayer/e/a;
            //   31: invokeinterface 38 1 0
            //   36: aload_1
            //   37: monitorexit
            //   38: ldc 20
            //   40: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   43: return
            //   44: astore_2
            //   45: ldc 43
            //   47: ldc 45
            //   49: iconst_1
            //   50: anewarray 4	java/lang/Object
            //   53: dup
            //   54: iconst_0
            //   55: aload_2
            //   56: aastore
            //   57: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   60: goto -24 -> 36
            //   63: astore_2
            //   64: aload_1
            //   65: monitorexit
            //   66: ldc 20
            //   68: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   71: aload_2
            //   72: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	73	0	this	5
            //   9	56	1	localAdAlphaPlayerView	AdAlphaPlayerView
            //   44	12	2	localObject1	Object
            //   63	9	2	localObject2	Object
            // Exception table:
            //   from	to	target	type
            //   12	36	44	finally
            //   36	38	63	finally
            //   45	60	63	finally
          }
        });
      }
      AppMethodBeat.o(310604);
      return;
    }
    finally
    {
      c.e("AdAlphaPlayerView", localThrowable);
      AppMethodBeat.o(310604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.AdAlphaPlayerView
 * JD-Core Version:    0.7.0.1
 */