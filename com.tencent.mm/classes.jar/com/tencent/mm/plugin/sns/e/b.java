package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.lang.ref.WeakReference;

public final class b
{
  public volatile boolean JPt;
  public Context mContext;
  s qVG;
  public e rZT;
  
  public b()
  {
    AppMethodBeat.i(179077);
    this.JPt = false;
    this.qVG = null;
    AppMethodBeat.o(179077);
  }
  
  public static final class a
    implements i
  {
    private int JCO;
    private WeakReference<b> JPC;
    private AdClickActionInfo JPD;
    private c.a JPE;
    private SnsInfo Jzk;
    
    public a(b paramb, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, int paramInt, c.a parama)
    {
      AppMethodBeat.i(201432);
      this.JPC = new WeakReference(paramb);
      this.JPD = paramAdClickActionInfo;
      this.Jzk = paramSnsInfo;
      this.JCO = paramInt;
      this.JPE = parama;
      AppMethodBeat.o(201432);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(201447);
      Log.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h))
          {
            if ((this.JPC == null) || (this.JPC.get() == null))
            {
              com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
              AppMethodBeat.o(201447);
              return;
            }
            paramString = (b)this.JPC.get();
            paramString.JPt = true;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(200407);
                if (paramString.qVG != null)
                {
                  paramString.qVG.dismiss();
                  paramString.qVG = null;
                }
                if ((paramString.rZT != null) && (paramString.rZT.isShowing()))
                {
                  Log.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                  paramString.rZT.bYF();
                }
                AppMethodBeat.o(200407);
              }
            });
            paramString = paramString.mContext;
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label417;
            }
            Log.i("HalfSubscribeController", "subscribe is success");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198855);
                try
                {
                  if (b.a.a(b.a.this) != null) {
                    b.a.a(b.a.this).a(b.a.b(b.a.this));
                  }
                  if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                    w.cR(paramString, b.a.b(b.a.this).JxG);
                  }
                  AppMethodBeat.o(198855);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("HalfSubscribeController", localThrowable.toString());
                  AppMethodBeat.o(198855);
                }
              }
            });
            paramString = com.tencent.mm.plugin.sns.data.t.Qu(this.Jzk.field_snsId);
          }
          try
          {
            com.tencent.mm.kernel.h.aHE();
            localObject = com.tencent.mm.kernel.b.aGq();
            if (Util.isNullOrNil(new String[] { paramString, localObject }))
            {
              Log.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
              paramString = new z(this.JPD.JxA, this.JPD.uMJ, 1, 0);
              c.a(this.Jzk, this.JCO, paramString);
              com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
              AppMethodBeat.o(201447);
              return;
            }
            localStringBuilder = new StringBuilder();
            if (!Util.isNullOrNil(paramString))
            {
              localStringBuilder.append(paramString);
              if (Util.isNullOrNil((String)localObject)) {
                break label476;
              }
              paramString = (String)localObject;
              localStringBuilder.append(paramString);
              if (localStringBuilder.length() > 0) {
                break label342;
              }
              Log.e("StorageHelper", "HalfScreenSubscribe, key is empty");
              continue;
            }
          }
          catch (Throwable paramString)
          {
            Log.e("StorageHelper", paramString.toString());
            continue;
          }
          paramString = "";
        }
        catch (Throwable paramString)
        {
          Log.e("HalfSubscribeController", paramString.toString());
          AppMethodBeat.o(201447);
          return;
        }
        continue;
        label342:
        paramString = localStringBuilder.toString();
        Object localObject = MMApplicationContext.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, "1");
        ((SharedPreferences.Editor)localObject).commit();
        Log.i("StorageHelper", "HalfScreenSubscribe, key = " + paramString + ", isSubscribe=" + "1");
        continue;
        label417:
        Log.e("HalfSubscribeController", "subscribe is failed");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264418);
            try
            {
              if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                w.cS(paramString, b.a.b(b.a.this).JxF);
              }
              AppMethodBeat.o(264418);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("HalfSubscribeController", localThrowable.toString());
              AppMethodBeat.o(264418);
            }
          }
        });
        paramString = new z(this.JPD.JxA, this.JPD.uMJ, 1, -3);
        c.a(this.Jzk, this.JCO, paramString);
        continue;
        label476:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.b
 * JD-Core Version:    0.7.0.1
 */