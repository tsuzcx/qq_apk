package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.plugin.sns.ad.j.h;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.e;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class d
  extends r
{
  w PPD;
  private final e PPR;
  
  public d(Context paramContext, e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(310715);
    this.PPR = parame;
    try
    {
      if ((this.QPl != null) && (this.PPR != null))
      {
        this.QPl.mx("finderUsername", this.PPR.finderUsername);
        this.QPl.mx("finderLiveNoticeId", this.PPR.PLN);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310715);
    }
  }
  
  private static long aWw(String paramString)
  {
    AppMethodBeat.i(310723);
    if (paramString != null) {
      try
      {
        long l = Long.parseLong(paramString);
        AppMethodBeat.o(310723);
        return l;
      }
      finally
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "string to long has something wrong!!");
      }
    }
    AppMethodBeat.o(310723);
    return 0L;
  }
  
  protected final void aju(int paramInt)
  {
    AppMethodBeat.i(310755);
    Button localButton = this.QPn;
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = this.QPm;
    if ((localButton == null) || (localRoundedCornerFrameLayout == null))
    {
      AppMethodBeat.o(310755);
      return;
    }
    if (paramInt == 513)
    {
      localButton.setText(this.context.getText(b.j.sns_ad_finder_living_notice_subscribed));
      localButton.setEnabled(false);
      localButton.setAlpha(0.6F);
      localRoundedCornerFrameLayout.setAlpha(0.6F);
      AppMethodBeat.o(310755);
      return;
    }
    if (this.PPR != null) {
      localButton.setText(this.PPR.title);
    }
    localButton.setEnabled(true);
    localButton.setAlpha(1.0F);
    localRoundedCornerFrameLayout.setAlpha(1.0F);
    AppMethodBeat.o(310755);
  }
  
  public final void hac()
  {
    AppMethodBeat.i(310745);
    try
    {
      Log.d("SnsAd.FinderLivingNoticeComp", "doBtnClick:: is called!");
      ai localai = hjn();
      e locale = this.PPR;
      if ((localai == null) || (locale == null))
      {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data is null, it can't do anything!!!!!");
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).PXU = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).PXT = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).hbq();
      if (locala != null)
      {
        Bundle localBundle = new Bundle();
        String str = t.uA(aWw(localai.getSnsId()));
        Object localObject3 = localai.hiC();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = localai.uxInfo;
        }
        localBundle.putString("sns_id", Util.nullAsNil(str));
        localBundle.putString("uxInfo", Util.nullAsNil((String)localObject1));
        localBundle.putString("adExtInfo", Util.nullAsNil(localai.adExtInfo));
        localBundle.putString("finderUsername", Util.nullAsNil(locale.finderUsername));
        localBundle.putString("finderLiveNoticeId", Util.nullAsNil(locale.PLN));
        locala.aX(localBundle);
        localObject3 = this.PPD;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.a.a.aU(this.context, b.j.loading);
          this.PPD = ((w)localObject1);
        }
        if ((localObject1 != null) && (!((w)localObject1).isShowing())) {
          ((w)localObject1).show();
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310745);
    }
  }
  
  public final void had()
  {
    int i = 257;
    AppMethodBeat.i(310736);
    try
    {
      super.had();
      Object localObject1 = hjn();
      Object localObject3 = this.PPR;
      if ((localObject1 == null) || (localObject3 == null)) {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data or info is null, it can't do anything!!!!!");
      }
      for (;;)
      {
        aju(i);
        Log.d("SnsAd.FinderLivingNoticeComp", "fillItem:: acquireLivingNoticeStatus is ".concat(String.valueOf(i)));
        return;
        String str = t.uA(aWw(((ai)localObject1).getSnsId()));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("sns_id", str);
        ((Bundle)localObject1).putString("finderUsername", Util.nullAsNil(((e)localObject3).finderUsername));
        ((Bundle)localObject1).putString("finderLiveNoticeId", Util.nullAsNil(((e)localObject3).PLN));
        localObject3 = new com.tencent.mm.plugin.sns.ad.remote.a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject3).PXU = new a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject3).PXT = new b(this, true);
        localObject3 = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject3).hbq();
        if (localObject3 != null) {
          i = h.getInt(((com.tencent.mm.plugin.sns.ad.remote.ipc.a)localObject3).aX((Bundle)localObject1), "status", 257);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310736);
    }
  }
  
  public static final class a
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(310667);
      Bundle localBundle = new Bundle();
      final String str1 = h.getString(paramBundle, "sns_id");
      String str2 = h.getString(paramBundle, "finderUsername");
      paramBundle = h.getString(paramBundle, "finderLiveNoticeId");
      if (!TextUtils.isEmpty(str1))
      {
        localBundle.putInt("status", com.tencent.mm.plugin.sns.ad.widget.living.b.gQ(str1, 1));
        com.tencent.mm.plugin.sns.ad.b.b.a(str1, str2, paramBundle, new b.a()
        {
          public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(310779);
            try
            {
              Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + str1 + ", inner snsId is " + paramAnonymousString + "errorCode = " + paramAnonymousInt2);
              if (paramAnonymousInt2 == 0)
              {
                boolean bool = paramAnonymousObject instanceof Integer;
                if (bool) {}
              }
              else
              {
                return;
              }
              com.tencent.mm.plugin.sns.ad.widget.living.b.gR(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString = paramb;
              if (paramAnonymousString == null) {
                return;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putInt("status", ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString.putInt("errorCode", paramAnonymousInt2);
              paramb.aY(paramAnonymousString);
              return;
            }
            finally
            {
              AppMethodBeat.o(310779);
            }
          }
        });
      }
      AppMethodBeat.o(310667);
      return localBundle;
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.sns.ad.remote.a.a
  {
    final Reference<d> PPV;
    final boolean PPW;
    
    b(d paramd)
    {
      this(paramd, false);
    }
    
    b(d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(310676);
      this.PPV = new WeakReference(paramd);
      this.PPW = paramBoolean;
      AppMethodBeat.o(310676);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void aW(Bundle paramBundle)
    {
      AppMethodBeat.i(310691);
      try
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "OnSubscriptionOfFinderLivingOnClient is called");
        int i = h.getInt(paramBundle, "status", 257);
        int j = h.getInt(paramBundle, "errorCode", 0);
        paramBundle = (d)this.PPV.get();
        if (paramBundle != null)
        {
          w localw = paramBundle.PPD;
          if ((localw != null) && (localw.isShowing())) {
            localw.dismiss();
          }
          if (!this.PPW) {
            com.tencent.mm.plugin.sns.ad.b.b.aT(paramBundle.context, j);
          }
          paramBundle.aju(i);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(310691);
      }
    }
  }
  
  public static final class c
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, final Bundle paramBundle)
    {
      AppMethodBeat.i(310668);
      final String str1 = h.getString(paramBundle, "sns_id");
      final String str2 = h.getString(paramBundle, "uxInfo");
      final String str3 = h.getString(paramBundle, "adExtInfo");
      final String str4 = h.getString(paramBundle, "finderUsername");
      paramBundle = h.getString(paramBundle, "finderLiveNoticeId");
      com.tencent.mm.plugin.sns.ad.b.b.b(str1, str4, paramBundle, new b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(310776);
          Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + str1 + ", inner snsId is " + paramAnonymousString);
          if (paramAnonymousInt2 == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.gR(paramAnonymousString, 513);
          }
          for (paramAnonymousInt1 = 513;; paramAnonymousInt1 = 257)
          {
            paramAnonymousObject = str2;
            String str1 = str3;
            String str2 = str4;
            String str3 = paramBundle;
            com.tencent.mm.plugin.sns.ad.b.a locala = new com.tencent.mm.plugin.sns.ad.b.a();
            locala.c(paramAnonymousString, paramAnonymousObject, str1, str2, str3, paramAnonymousInt2, 0);
            j.a(locala);
            if (paramb != null)
            {
              paramAnonymousString = new Bundle();
              paramAnonymousString.putInt("errorCode", paramAnonymousInt2);
              paramAnonymousString.putInt("status", paramAnonymousInt1);
              paramb.aY(paramAnonymousString);
            }
            AppMethodBeat.o(310776);
            return;
          }
        }
      });
      AppMethodBeat.o(310668);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.d
 * JD-Core Version:    0.7.0.1
 */