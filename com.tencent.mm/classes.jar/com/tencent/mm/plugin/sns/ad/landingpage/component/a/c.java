package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.c.b.a;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class c
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
{
  com.tencent.mm.ui.base.q Dtl;
  private final com.tencent.mm.plugin.sns.ad.landingpage.component.b.c Dts;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.c paramc, ViewGroup paramViewGroup)
  {
    super(paramContext, paramc, paramViewGroup);
    AppMethodBeat.i(201979);
    this.Dts = paramc;
    try
    {
      if ((this.Edn != null) && (this.Dts != null))
      {
        this.Edn.kv("finderUsername", this.Dts.finderUsername);
        this.Edn.kv("finderLiveNoticeId", this.Dts.finderLiveNoticeId);
      }
      AppMethodBeat.o(201979);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(201979);
    }
  }
  
  private static long aNJ(String paramString)
  {
    AppMethodBeat.i(201983);
    if (paramString != null) {
      try
      {
        long l = Long.parseLong(paramString);
        AppMethodBeat.o(201983);
        return l;
      }
      catch (Throwable paramString)
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "string to long has something wrong!!");
      }
    }
    AppMethodBeat.o(201983);
    return 0L;
  }
  
  protected final void XJ(int paramInt)
  {
    AppMethodBeat.i(201982);
    Button localButton = this.Edp;
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = this.Edo;
    if ((localButton == null) || (localRoundedCornerFrameLayout == null))
    {
      AppMethodBeat.o(201982);
      return;
    }
    if (paramInt == 513)
    {
      localButton.setText(this.context.getText(2131765957));
      localButton.setEnabled(false);
      localButton.setAlpha(0.6F);
      localRoundedCornerFrameLayout.setAlpha(0.6F);
      AppMethodBeat.o(201982);
      return;
    }
    if (this.Dts != null) {
      localButton.setText(this.Dts.title);
    }
    localButton.setEnabled(true);
    localButton.setAlpha(1.0F);
    localRoundedCornerFrameLayout.setAlpha(1.0F);
    AppMethodBeat.o(201982);
  }
  
  public final void eWS()
  {
    AppMethodBeat.i(201981);
    try
    {
      Log.d("SnsAd.FinderLivingNoticeComp", "openBtnUrl:: is called!");
      ah localah = fds();
      com.tencent.mm.plugin.sns.ad.landingpage.component.b.c localc = this.Dts;
      if ((localah == null) || (localc == null))
      {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data is null, it can't do anything!!!!!");
        AppMethodBeat.o(201981);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).Dxn = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).Dxm = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).eXy();
      if (locala != null)
      {
        Bundle localBundle = new Bundle();
        String str = r.Jb(aNJ(localah.getSnsId()));
        Object localObject2 = localah.DZW;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localah.uxInfo;
        }
        localBundle.putString("sns_id", Util.nullAsNil(str));
        localBundle.putString("uxInfo", Util.nullAsNil((String)localObject1));
        localBundle.putString("adExtInfo", Util.nullAsNil(localah.adExtInfo));
        localBundle.putString("finderUsername", Util.nullAsNil(localc.finderUsername));
        localBundle.putString("finderLiveNoticeId", Util.nullAsNil(localc.finderLiveNoticeId));
        locala.aA(localBundle);
        localObject2 = this.Dtl;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.a.a.ap(this.context, 2131762443);
          this.Dtl = ((com.tencent.mm.ui.base.q)localObject1);
        }
        if ((localObject1 != null) && (!((com.tencent.mm.ui.base.q)localObject1).isShowing())) {
          ((com.tencent.mm.ui.base.q)localObject1).show();
        }
      }
      AppMethodBeat.o(201981);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201981);
    }
  }
  
  public final void eWT()
  {
    int i = 257;
    AppMethodBeat.i(201980);
    try
    {
      super.eWT();
      Object localObject1 = fds();
      Object localObject2 = this.Dts;
      if ((localObject1 == null) || (localObject2 == null)) {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data or info is null, it can't do anything!!!!!");
      }
      for (;;)
      {
        XJ(i);
        Log.d("SnsAd.FinderLivingNoticeComp", "fillItem:: acquireLivingNoticeStatus is ".concat(String.valueOf(i)));
        AppMethodBeat.o(201980);
        return;
        String str = r.Jb(aNJ(((ah)localObject1).getSnsId()));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("sns_id", str);
        ((Bundle)localObject1).putString("finderUsername", Util.nullAsNil(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)localObject2).finderUsername));
        ((Bundle)localObject1).putString("finderLiveNoticeId", Util.nullAsNil(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)localObject2).finderLiveNoticeId));
        localObject2 = new com.tencent.mm.plugin.sns.ad.remote.a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).Dxn = new a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).Dxm = new b(this, true);
        localObject2 = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).eXy();
        if (localObject2 != null) {
          i = g.getInt(((com.tencent.mm.plugin.sns.ad.remote.ipc.a)localObject2).aA((Bundle)localObject1), "status", 257);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201980);
    }
  }
  
  public static final class a
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(201974);
      Bundle localBundle = new Bundle();
      final String str1 = g.getString(paramBundle, "sns_id");
      String str2 = g.getString(paramBundle, "finderUsername");
      paramBundle = g.getString(paramBundle, "finderLiveNoticeId");
      if (!TextUtils.isEmpty(str1))
      {
        localBundle.putInt("status", com.tencent.mm.plugin.sns.ad.widget.living.b.fu(str1, 1));
        com.tencent.mm.plugin.sns.ad.c.b.a(str1, str2, paramBundle, new b.a()
        {
          public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
          {
            AppMethodBeat.i(201973);
            try
            {
              Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + str1 + ", inner snsId is " + paramAnonymousString + "errorCode = " + paramAnonymousInt);
              if (paramAnonymousInt == 0)
              {
                boolean bool = paramAnonymousObject instanceof Integer;
                if (bool) {}
              }
              else
              {
                AppMethodBeat.o(201973);
                return;
              }
              com.tencent.mm.plugin.sns.ad.widget.living.b.fv(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString = paramb;
              if (paramAnonymousString == null)
              {
                AppMethodBeat.o(201973);
                return;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putInt("status", ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString.putInt("errorCode", paramAnonymousInt);
              paramb.aB(paramAnonymousString);
              AppMethodBeat.o(201973);
              return;
            }
            catch (Throwable paramAnonymousString)
            {
              AppMethodBeat.o(201973);
            }
          }
        });
      }
      AppMethodBeat.o(201974);
      return localBundle;
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.sns.ad.remote.a.a
  {
    final Reference<c> Dtw;
    final boolean Dtx;
    
    b(c paramc)
    {
      this(paramc, false);
    }
    
    b(c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(201975);
      this.Dtw = new WeakReference(paramc);
      this.Dtx = paramBoolean;
      AppMethodBeat.o(201975);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void az(Bundle paramBundle)
    {
      AppMethodBeat.i(201976);
      try
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "OnSubscriptionOfFinderLivingOnClient is called");
        int i = g.getInt(paramBundle, "status", 257);
        int j = g.getInt(paramBundle, "errorCode", 0);
        paramBundle = (c)this.Dtw.get();
        if (paramBundle != null)
        {
          com.tencent.mm.ui.base.q localq = paramBundle.Dtl;
          if ((localq != null) && (localq.isShowing())) {
            localq.dismiss();
          }
          if (!this.Dtx) {
            com.tencent.mm.plugin.sns.ad.c.b.ao(paramBundle.context, j);
          }
          paramBundle.XJ(i);
        }
        AppMethodBeat.o(201976);
        return;
      }
      catch (Throwable paramBundle)
      {
        AppMethodBeat.o(201976);
      }
    }
  }
  
  public static final class c
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, final Bundle paramBundle)
    {
      AppMethodBeat.i(201978);
      final String str1 = g.getString(paramBundle, "sns_id");
      final String str2 = g.getString(paramBundle, "uxInfo");
      final String str3 = g.getString(paramBundle, "adExtInfo");
      final String str4 = g.getString(paramBundle, "finderUsername");
      paramBundle = g.getString(paramBundle, "finderLiveNoticeId");
      com.tencent.mm.plugin.sns.ad.c.b.b(str1, str4, paramBundle, new b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(201977);
          Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + str1 + ", inner snsId is " + paramAnonymousString);
          if (paramAnonymousInt == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fv(paramAnonymousString, 513);
          }
          for (int i = 513;; i = 257)
          {
            paramAnonymousObject = str2;
            String str1 = str3;
            String str2 = str4;
            String str3 = paramBundle;
            com.tencent.mm.plugin.sns.ad.c.a locala = new com.tencent.mm.plugin.sns.ad.c.a();
            locala.c(paramAnonymousString, paramAnonymousObject, str1, str2, str3, paramAnonymousInt, 0);
            i.a(locala);
            if (paramb != null)
            {
              paramAnonymousString = new Bundle();
              paramAnonymousString.putInt("errorCode", paramAnonymousInt);
              paramAnonymousString.putInt("status", i);
              paramb.aB(paramAnonymousString);
            }
            AppMethodBeat.o(201977);
            return;
          }
        }
      });
      AppMethodBeat.o(201978);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.c
 * JD-Core Version:    0.7.0.1
 */