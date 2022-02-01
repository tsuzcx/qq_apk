package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.adxml.g.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FinderLivingAnimWrapper
  extends FrameLayout
{
  private q JMc;
  private g JMd;
  private volatile boolean JMe;
  private Set<String> JMf;
  private int JMg;
  private int JMh;
  private String JyZ;
  private Context mContext;
  private volatile boolean mIsDestroyed;
  
  public FinderLivingAnimWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(268730);
    this.JMe = false;
    this.JMf = Collections.synchronizedSet(new HashSet());
    this.mIsDestroyed = false;
    init(paramContext);
    AppMethodBeat.o(268730);
  }
  
  public FinderLivingAnimWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(268731);
    this.JMe = false;
    this.JMf = Collections.synchronizedSet(new HashSet());
    this.mIsDestroyed = false;
    init(paramContext);
    AppMethodBeat.o(268731);
  }
  
  public static boolean a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(268742);
    com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "showLivingAnim, isLivingNow=" + paramBoolean + ", showLikeAnimation=" + paramg.Jyv + ", sdk_int=" + Build.VERSION.SDK_INT);
    if ((paramBoolean) && (paramg.Jyv) && (Build.VERSION.SDK_INT >= 24))
    {
      AppMethodBeat.o(268742);
      return true;
    }
    AppMethodBeat.o(268742);
    return false;
  }
  
  private void fMc()
  {
    AppMethodBeat.i(268739);
    com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "doClear");
    try
    {
      if (this.JMc != null) {
        this.JMc.dIa();
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.JMf.clear();
          this.JMe = false;
          AppMethodBeat.o(268739);
          return;
          localThrowable1 = localThrowable1;
          com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "doClear, exp=" + android.util.Log.getStackTraceString(localThrowable1));
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "doClear, exp=" + android.util.Log.getStackTraceString(localThrowable2));
        }
      }
    }
  }
  
  private void hv(final List<g.a> paramList)
  {
    AppMethodBeat.i(268741);
    if (this.JMc == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "prepareIconAsynAndStart, mILiveView==null");
      AppMethodBeat.o(268741);
      return;
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269069);
        try
        {
          if (FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this))
          {
            com.tencent.mm.sdk.platformtools.Log.w("FinderLivingAnimWrapper", "before addBitmap, isDestroyed=true");
            AppMethodBeat.o(269069);
            return;
          }
          long l1 = System.currentTimeMillis();
          ArrayList localArrayList;
          if (!FinderLivingAnimWrapper.b(FinderLivingAnimWrapper.this))
          {
            com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, addDefaultBitmap");
            localArrayList = new ArrayList();
            localArrayList.add(Integer.valueOf(i.e.live_like_icon1));
            localArrayList.add(Integer.valueOf(i.e.live_like_icon2));
            localArrayList.add(Integer.valueOf(i.e.live_like_icon3));
            localArrayList.add(Integer.valueOf(i.e.live_like_icon4));
            localArrayList.add(Integer.valueOf(i.e.live_like_icon5));
            localArrayList.add(Integer.valueOf(i.e.live_like_icon6));
          }
          try
          {
            FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).ak(localArrayList);
            FinderLivingAnimWrapper.d(FinderLivingAnimWrapper.this);
            long l2 = System.currentTimeMillis();
            FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this, paramList);
            long l3 = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, defIcon cost=" + (l2 - l1) + ", configIcon cost=" + (l3 - l2));
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(266914);
                if (FinderLivingAnimWrapper.a(FinderLivingAnimWrapper.this))
                {
                  com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "before startAnim, isDestroyed=true");
                  AppMethodBeat.o(266914);
                  return;
                }
                int i = FinderLivingAnimWrapper.this.getWidth();
                int j = FinderLivingAnimWrapper.this.getHeight();
                if ((FinderLivingAnimWrapper.b(FinderLivingAnimWrapper.this)) && (i > 0) && (j > 0)) {}
                try
                {
                  FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).gL(i - FinderLivingAnimWrapper.e(FinderLivingAnimWrapper.this), j - FinderLivingAnimWrapper.f(FinderLivingAnimWrapper.this));
                  FinderLivingAnimWrapper.c(FinderLivingAnimWrapper.this).start();
                  com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "prepareIconAsynAndStart, startAnim, w=" + i + ", h=" + j);
                  AppMethodBeat.o(266914);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "start exp=" + localThrowable.toString());
                  }
                }
              }
            }, 50L);
            AppMethodBeat.o(269069);
            return;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "addDefaultBitmap, exp=" + localThrowable1.toString());
            }
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "prepareIconAsynAndStart, exp=" + android.util.Log.getStackTraceString(localThrowable2));
          AppMethodBeat.o(269069);
        }
      }
    });
    AppMethodBeat.o(268741);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(268733);
    this.mContext = paramContext;
    this.JMg = a.fromDPToPix(this.mContext, 60);
    this.JMh = a.fromDPToPix(this.mContext, 35);
    AppMethodBeat.o(268733);
  }
  
  public final void a(g paramg, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268740);
    try
    {
      this.JMg = paramInt1;
      this.JMh = paramInt2;
      com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "setAdLiveInfo, snsId=" + paramString + ", hash=" + hashCode());
      this.JMd = paramg;
      if ((!TextUtils.isEmpty(this.JyZ)) && (!this.JyZ.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.Log.w("FinderLivingAnimWrapper", "setAdLiveInfo, snsId changed, old=" + this.JyZ + ", new=" + paramString);
        fMc();
      }
      this.JyZ = paramString;
      this.mIsDestroyed = false;
      if (this.JMc == null)
      {
        this.JMc = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().fV(this.mContext);
        paramString = this.JMc.getView();
        if (paramString == null) {
          break label245;
        }
        addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.JMc != null)
        {
          paramInt2 = (int)(paramg.Jyw * 1000.0F);
          paramInt1 = paramInt2;
          if (paramInt2 <= 0) {
            paramInt1 = 600;
          }
          this.JMc.setInterval(paramInt1);
        }
        hv(paramg.Jyx);
        AppMethodBeat.o(268740);
        return;
        label245:
        com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "mILiveView.getView()==null");
      }
      return;
    }
    catch (Throwable paramg)
    {
      com.tencent.mm.sdk.platformtools.Log.e("FinderLivingAnimWrapper", "setAdLiveInfo, exp=" + android.util.Log.getStackTraceString(paramg));
      AppMethodBeat.o(268740);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(268735);
    super.onDetachedFromWindow();
    com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "onDetachedFromWindow, snsId=" + this.JyZ + ", hash=" + hashCode());
    this.mIsDestroyed = true;
    fMc();
    AppMethodBeat.o(268735);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(268737);
    super.setVisibility(paramInt);
    if ((paramInt != 0) && (this.JMc != null))
    {
      com.tencent.mm.sdk.platformtools.Log.i("FinderLivingAnimWrapper", "setVisibility=" + paramInt + ", stopAndDestroy");
      fMc();
    }
    AppMethodBeat.o(268737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper
 * JD-Core Version:    0.7.0.1
 */