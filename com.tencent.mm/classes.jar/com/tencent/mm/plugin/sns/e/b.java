package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.plugin.sns.ui.av.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.lang.ref.WeakReference;

public final class b
{
  public volatile boolean DDe;
  public Context mContext;
  com.tencent.mm.ui.base.q nUi;
  public e oXS;
  
  public b()
  {
    AppMethodBeat.i(179077);
    this.DDe = false;
    this.nUi = null;
    AppMethodBeat.o(179077);
  }
  
  public static View a(Context paramContext, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, SnsInfo paramSnsInfo, bv parambv)
  {
    AppMethodBeat.i(202578);
    View localView = LayoutInflater.from(paramContext).inflate(2131496418, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131310361);
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)localView.findViewById(2131310360);
    TextView localTextView2 = (TextView)localView.findViewById(2131308744);
    if ((paramAdCardActionBtnInfo == null) || (paramSnsInfo == null)) {}
    try
    {
      Log.e("HalfScreenSubscribeUtils", "adCardActionBtnInfo == null || snsInfo == null");
      for (;;)
      {
        paramContext = (TextView)localView.findViewById(2131308737);
        paramSnsInfo = (Button)localView.findViewById(2131308733);
        localTextView1.setText(paramAdCardActionBtnInfo.subscribeNickname);
        localTextView2.setText(paramAdCardActionBtnInfo.subscribeTitle);
        paramContext.setText(paramAdCardActionBtnInfo.subscribeContent);
        paramSnsInfo.setText(paramAdCardActionBtnInfo.subscribeSubmitBtnTitle);
        AppMethodBeat.o(202578);
        return localView;
        if (Util.isNullOrNil(paramAdCardActionBtnInfo.subscribeNickname))
        {
          paramContext = paramSnsInfo.getUserName();
          if (!Util.isNullOrNil(paramContext))
          {
            parambv = parambv.bjK(paramContext);
            if (parambv != null) {
              break;
            }
            if (paramSnsInfo.isAd())
            {
              localADXml = paramSnsInfo.getAdXml();
              if (!localADXml.usePreferedInfo) {
                break label241;
              }
              parambv = localADXml.preferNickName;
              paramAdCardActionBtnInfo.subscribeNickname = parambv;
            }
          }
        }
        if (!Util.isNullOrNil(paramAdCardActionBtnInfo.subscribeHeadImg)) {
          break label272;
        }
        a.b.c(localRoundCornerImageView, paramSnsInfo.getUserName());
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ADXml localADXml;
        Log.e("HalfScreenSubscribeUtils", paramContext.toString());
        continue;
        paramContext = parambv.arJ();
        continue;
        label241:
        parambv = paramContext;
        if (Util.isNullOrNil(paramContext))
        {
          parambv = paramContext;
          if (!Util.isNullOrNil(localADXml.nickname))
          {
            parambv = localADXml.nickname;
            continue;
            label272:
            paramContext = paramAdCardActionBtnInfo.subscribeHeadImg;
            if (!TextUtils.equals((String)localRoundCornerImageView.getTag(2131308065), paramContext))
            {
              localRoundCornerImageView.setImageDrawable(null);
              com.tencent.mm.plugin.sns.a.c.k(paramContext, localRoundCornerImageView);
            }
          }
        }
      }
    }
  }
  
  public static final class a
    implements i
  {
    private WeakReference<b> DDn;
    av.a DDo;
    private SnsInfo DsC;
    private int DxM;
    ADXml.AdCardActionBtnInfo adCardActionBtnInfo;
    
    public a(b paramb, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, SnsInfo paramSnsInfo, int paramInt, av.a parama)
    {
      AppMethodBeat.i(202576);
      this.DDn = new WeakReference(paramb);
      this.adCardActionBtnInfo = paramAdCardActionBtnInfo;
      this.DsC = paramSnsInfo;
      this.DxM = paramInt;
      this.DDo = parama;
      AppMethodBeat.o(202576);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(202577);
      Log.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h))
          {
            if ((this.DDn == null) || (this.DDn.get() == null))
            {
              g.azz().b(paramq.getType(), this);
              AppMethodBeat.o(202577);
              return;
            }
            paramString = (b)this.DDn.get();
            paramString.DDe = true;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(202573);
                if (paramString.nUi != null)
                {
                  paramString.nUi.dismiss();
                  paramString.nUi = null;
                }
                if ((paramString.oXS != null) && (paramString.oXS.isShowing()))
                {
                  Log.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                  paramString.oXS.bMo();
                }
                AppMethodBeat.o(202573);
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
                AppMethodBeat.i(202574);
                try
                {
                  b.a.this.DDo.a(b.a.this.adCardActionBtnInfo);
                  if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                    u.cG(paramString, b.a.this.adCardActionBtnInfo.subscribeSucTip);
                  }
                  AppMethodBeat.o(202574);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("HalfSubscribeController", localThrowable.toString());
                  AppMethodBeat.o(202574);
                }
              }
            });
            paramString = r.Jb(this.DsC.field_snsId);
          }
          try
          {
            g.aAf();
            localObject = com.tencent.mm.kernel.a.ayV();
            if (Util.isNullOrNil(new String[] { paramString, localObject }))
            {
              Log.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
              paramString = new z(this.adCardActionBtnInfo.tempId, this.adCardActionBtnInfo.weappUserName, 1, 0);
              com.tencent.mm.plugin.sns.a.c.a(this.DsC, this.DxM, paramString);
              g.azz().b(paramq.getType(), this);
              AppMethodBeat.o(202577);
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
          AppMethodBeat.o(202577);
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
            AppMethodBeat.i(202575);
            try
            {
              if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                u.cH(paramString, b.a.this.adCardActionBtnInfo.subscribeFailedTip);
              }
              AppMethodBeat.o(202575);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("HalfSubscribeController", localThrowable.toString());
              AppMethodBeat.o(202575);
            }
          }
        });
        paramString = new z(this.adCardActionBtnInfo.tempId, this.adCardActionBtnInfo.weappUserName, 1, -3);
        com.tencent.mm.plugin.sns.a.c.a(this.DsC, this.DxM, paramString);
        continue;
        label476:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.b
 * JD-Core Version:    0.7.0.1
 */