package com.tencent.mm.plugin.sns.g;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.lang.ref.WeakReference;

public final class b
{
  public volatile boolean QkC;
  public Context mContext;
  w ubo;
  public f vlk;
  
  public b()
  {
    AppMethodBeat.i(179077);
    this.QkC = false;
    this.ubo = null;
    AppMethodBeat.o(179077);
  }
  
  public static final class a
    implements com.tencent.mm.am.h
  {
    private SnsInfo PNI;
    private WeakReference<b> QkL;
    private AdClickActionInfo QkM;
    private c.a QkN;
    private int xOq;
    
    public a(b paramb, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, int paramInt, c.a parama)
    {
      AppMethodBeat.i(307292);
      this.QkL = new WeakReference(paramb);
      this.QkM = paramAdClickActionInfo;
      this.PNI = paramSnsInfo;
      this.xOq = paramInt;
      this.QkN = parama;
      AppMethodBeat.o(307292);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
    {
      AppMethodBeat.i(307300);
      Log.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          if ((paramp instanceof i))
          {
            if ((this.QkL == null) || (this.QkL.get() == null))
            {
              com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
              AppMethodBeat.o(307300);
              return;
            }
            paramString = (b)this.QkL.get();
            paramString.QkC = true;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(307297);
                if (paramString.ubo != null)
                {
                  paramString.ubo.dismiss();
                  paramString.ubo = null;
                }
                if ((paramString.vlk != null) && (paramString.vlk.isShowing()))
                {
                  Log.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                  paramString.vlk.cyW();
                }
                AppMethodBeat.o(307297);
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
                AppMethodBeat.i(307298);
                try
                {
                  if (b.a.a(b.a.this) != null) {
                    b.a.a(b.a.this).a(b.a.b(b.a.this));
                  }
                  if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                    aa.db(paramString, b.a.b(b.a.this).PLv);
                  }
                  AppMethodBeat.o(307298);
                  return;
                }
                finally
                {
                  Log.e("HalfSubscribeController", localObject.toString());
                  AppMethodBeat.o(307298);
                }
              }
            });
            paramString = t.uA(this.PNI.field_snsId);
          }
          try
          {
            com.tencent.mm.kernel.h.baC();
            localObject = com.tencent.mm.kernel.b.aZs();
            if (Util.isNullOrNil(new String[] { paramString, localObject }))
            {
              Log.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
              paramString = new aj(this.QkM.PLp, this.QkM.xVm, 1, 0);
              c.a(this.PNI, this.xOq, paramString);
              com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
              AppMethodBeat.o(307300);
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
          finally
          {
            Log.e("StorageHelper", paramString.toString());
            continue;
          }
          paramString = "";
        }
        finally
        {
          Log.e("HalfSubscribeController", paramString.toString());
          AppMethodBeat.o(307300);
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
            AppMethodBeat.i(307294);
            try
            {
              if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                aa.dc(paramString, b.a.b(b.a.this).PLu);
              }
              AppMethodBeat.o(307294);
              return;
            }
            finally
            {
              Log.e("HalfSubscribeController", localObject.toString());
              AppMethodBeat.o(307294);
            }
          }
        });
        paramString = new aj(this.QkM.PLp, this.QkM.xVm, 1, -3);
        c.a(this.PNI, this.xOq, paramString);
        continue;
        label476:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b
 * JD-Core Version:    0.7.0.1
 */