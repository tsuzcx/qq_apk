package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.ad.adxml.i.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FinderLivingAnimWrapper
  extends FrameLayout
{
  private String PNx;
  private an QgG;
  private com.tencent.mm.plugin.sns.ad.adxml.i QgH;
  private volatile boolean QgI;
  private Set<String> QgJ;
  private int QgK;
  private int QgL;
  private Context mContext;
  private volatile boolean mIsDestroyed;
  
  public FinderLivingAnimWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310387);
    this.QgI = false;
    this.QgJ = Collections.synchronizedSet(new HashSet());
    this.mIsDestroyed = false;
    init(paramContext);
    AppMethodBeat.o(310387);
  }
  
  public FinderLivingAnimWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(310400);
    this.QgI = false;
    this.QgJ = Collections.synchronizedSet(new HashSet());
    this.mIsDestroyed = false;
    init(paramContext);
    AppMethodBeat.o(310400);
  }
  
  public static boolean a(com.tencent.mm.plugin.sns.ad.adxml.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(310464);
    com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "showLivingAnim, isLivingNow=" + paramBoolean + ", showLikeAnimation=" + parami.PMP + ", sdk_int=" + Build.VERSION.SDK_INT);
    if ((paramBoolean) && (parami.PMP) && (Build.VERSION.SDK_INT >= 24))
    {
      AppMethodBeat.o(310464);
      return true;
    }
    AppMethodBeat.o(310464);
    return false;
  }
  
  /* Error */
  private void hcV()
  {
    // Byte code:
    //   0: ldc 213
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 127
    //   7: ldc 215
    //   9: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 163	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:QgG	Lcom/tencent/mm/plugin/findersdk/a/an;
    //   16: ifnull +12 -> 28
    //   19: aload_0
    //   20: getfield 163	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:QgG	Lcom/tencent/mm/plugin/findersdk/a/an;
    //   23: invokeinterface 218 1 0
    //   28: aload_0
    //   29: getfield 53	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:QgJ	Ljava/util/Set;
    //   32: invokeinterface 221 1 0
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 40	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:QgI	Z
    //   42: ldc 213
    //   44: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: ldc 127
    //   51: new 129	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 223
    //   57: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokestatic 229	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   64: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: goto -45 -> 28
    //   76: astore_1
    //   77: ldc 127
    //   79: new 129	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 223
    //   85: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokestatic 229	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -64 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	FinderLivingAnimWrapper
    //   48	13	1	localThrowable1	Throwable
    //   76	13	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	28	48	finally
    //   28	37	76	finally
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(310418);
    this.mContext = paramContext;
    this.QgK = a.fromDPToPix(this.mContext, 60);
    this.QgL = a.fromDPToPix(this.mContext, 35);
    AppMethodBeat.o(310418);
  }
  
  private void kw(final List<i.a> paramList)
  {
    AppMethodBeat.i(310448);
    if (this.QgG == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "prepareIconAsynAndStart, mILiveView==null");
      AppMethodBeat.o(310448);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310409);
        try
        {
          if (FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this))
          {
            com.tencent.mm.sdk.platformtools.Log.w("FinderLivingAnimWrapper", "before addBitmap, isDestroyed=true");
            AppMethodBeat.o(310409);
            return;
          }
          long l1 = System.currentTimeMillis();
          ArrayList localArrayList;
          if (!FinderLivingAnimWrapper.b(FinderLivingAnimWrapper.this))
          {
            com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, addDefaultBitmap");
            localArrayList = new ArrayList();
            localArrayList.add(Integer.valueOf(b.e.live_like_icon1));
            localArrayList.add(Integer.valueOf(b.e.live_like_icon2));
            localArrayList.add(Integer.valueOf(b.e.live_like_icon3));
            localArrayList.add(Integer.valueOf(b.e.live_like_icon4));
            localArrayList.add(Integer.valueOf(b.e.live_like_icon5));
            localArrayList.add(Integer.valueOf(b.e.live_like_icon6));
          }
          try
          {
            FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).ao(localArrayList);
            FinderLivingAnimWrapper.d(FinderLivingAnimWrapper.this);
            long l2 = System.currentTimeMillis();
            FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this, paramList);
            long l3 = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, defIcon cost=" + (l2 - l1) + ", configIcon cost=" + (l3 - l2));
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(310369);
                if (FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this))
                {
                  com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "before startAnim, isDestroyed=true");
                  AppMethodBeat.o(310369);
                  return;
                }
                int i = FinderLivingAnimWrapper.this.getWidth();
                int j = FinderLivingAnimWrapper.this.getHeight();
                if ((FinderLivingAnimWrapper.b(FinderLivingAnimWrapper.this)) && (i > 0) && (j > 0)) {}
                try
                {
                  FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).hQ(i - FinderLivingAnimWrapper.e(FinderLivingAnimWrapper.this), j - FinderLivingAnimWrapper.f(FinderLivingAnimWrapper.this));
                  FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).start();
                  com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, startAnim, w=" + i + ", h=" + j);
                  AppMethodBeat.o(310369);
                  return;
                }
                finally
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "start exp=" + localObject.toString());
                  }
                }
              }
            }, 50L);
            AppMethodBeat.o(310409);
            return;
          }
          finally
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "addDefaultBitmap, exp=" + localObject.toString());
            }
          }
          return;
        }
        finally
        {
          com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "prepareIconAsynAndStart, exp=" + android.util.Log.getStackTraceString(localThrowable));
          AppMethodBeat.o(310409);
        }
      }
    });
    AppMethodBeat.o(310448);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.adxml.i parami, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310606);
    try
    {
      this.QgK = paramInt1;
      this.QgL = paramInt2;
      com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "setAdLiveInfo, snsId=" + paramString + ", hash=" + hashCode());
      this.QgH = parami;
      if ((!TextUtils.isEmpty(this.PNx)) && (!this.PNx.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.Log.w("FinderLivingAnimWrapper", "setAdLiveInfo, snsId changed, old=" + this.PNx + ", new=" + paramString);
        hcV();
      }
      this.PNx = paramString;
      this.mIsDestroyed = false;
      if (this.QgG == null)
      {
        this.QgG = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().en(this.mContext);
        paramString = this.QgG.getView();
        if (paramString == null) {
          break label245;
        }
        addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.QgG != null)
        {
          paramInt2 = (int)(parami.PMQ * 1000.0F);
          paramInt1 = paramInt2;
          if (paramInt2 <= 0) {
            paramInt1 = 600;
          }
          this.QgG.setInterval(paramInt1);
        }
        kw(parami.PMR);
        AppMethodBeat.o(310606);
        return;
        label245:
        com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "mILiveView.getView()==null");
      }
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "setAdLiveInfo, exp=" + android.util.Log.getStackTraceString(parami));
      AppMethodBeat.o(310606);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310577);
    super.onDetachedFromWindow();
    com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "onDetachedFromWindow, snsId=" + this.PNx + ", hash=" + hashCode());
    this.mIsDestroyed = true;
    hcV();
    AppMethodBeat.o(310577);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(310583);
    super.setVisibility(paramInt);
    if ((paramInt != 0) && (this.QgG != null))
    {
      com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "setVisibility=" + paramInt + ", stopAndDestroy");
      hcV();
    }
    AppMethodBeat.o(310583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper
 * JD-Core Version:    0.7.0.1
 */