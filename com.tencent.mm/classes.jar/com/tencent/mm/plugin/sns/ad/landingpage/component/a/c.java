package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.plugin.sns.ad.i.h;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class c
  extends q
{
  s JAc;
  private final d JAj;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
    AppMethodBeat.i(269173);
    this.JAj = paramd;
    try
    {
      if ((this.KqQ != null) && (this.JAj != null))
      {
        this.KqQ.kQ("finderUsername", this.JAj.finderUsername);
        this.KqQ.kQ("finderLiveNoticeId", this.JAj.JxY);
      }
      AppMethodBeat.o(269173);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(269173);
    }
  }
  
  private static long aYu(String paramString)
  {
    AppMethodBeat.i(269177);
    if (paramString != null) {
      try
      {
        long l = Long.parseLong(paramString);
        AppMethodBeat.o(269177);
        return l;
      }
      catch (Throwable paramString)
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "string to long has something wrong!!");
      }
    }
    AppMethodBeat.o(269177);
    return 0L;
  }
  
  protected final void aeK(int paramInt)
  {
    AppMethodBeat.i(269176);
    Button localButton = this.KqS;
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = this.KqR;
    if ((localButton == null) || (localRoundedCornerFrameLayout == null))
    {
      AppMethodBeat.o(269176);
      return;
    }
    if (paramInt == 513)
    {
      localButton.setText(this.context.getText(i.j.sns_ad_finder_living_notice_subscribed));
      localButton.setEnabled(false);
      localButton.setAlpha(0.6F);
      localRoundedCornerFrameLayout.setAlpha(0.6F);
      AppMethodBeat.o(269176);
      return;
    }
    if (this.JAj != null) {
      localButton.setText(this.JAj.title);
    }
    localButton.setEnabled(true);
    localButton.setAlpha(1.0F);
    localRoundedCornerFrameLayout.setAlpha(1.0F);
    AppMethodBeat.o(269176);
  }
  
  public final void fKd()
  {
    AppMethodBeat.i(269175);
    try
    {
      Log.d("SnsAd.FinderLivingNoticeComp", "doBtnClick:: is called!");
      ai localai = fRp();
      d locald = this.JAj;
      if ((localai == null) || (locald == null))
      {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data is null, it can't do anything!!!!!");
        AppMethodBeat.o(269175);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).JGU = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).JGT = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).fKZ();
      if (locala != null)
      {
        Bundle localBundle = new Bundle();
        String str = t.Qu(aYu(localai.getSnsId()));
        Object localObject2 = localai.fQE();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localai.uxInfo;
        }
        localBundle.putString("sns_id", Util.nullAsNil(str));
        localBundle.putString("uxInfo", Util.nullAsNil((String)localObject1));
        localBundle.putString("adExtInfo", Util.nullAsNil(localai.adExtInfo));
        localBundle.putString("finderUsername", Util.nullAsNil(locald.finderUsername));
        localBundle.putString("finderLiveNoticeId", Util.nullAsNil(locald.JxY));
        locala.aw(localBundle);
        localObject2 = this.JAc;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.a.a.aH(this.context, i.j.loading);
          this.JAc = ((s)localObject1);
        }
        if ((localObject1 != null) && (!((s)localObject1).isShowing())) {
          ((s)localObject1).show();
        }
      }
      AppMethodBeat.o(269175);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269175);
    }
  }
  
  public final void fKe()
  {
    int i = 257;
    AppMethodBeat.i(269174);
    try
    {
      super.fKe();
      Object localObject1 = fRp();
      Object localObject2 = this.JAj;
      if ((localObject1 == null) || (localObject2 == null)) {
        Log.e("SnsAd.FinderLivingNoticeComp", "the page data or info is null, it can't do anything!!!!!");
      }
      for (;;)
      {
        aeK(i);
        Log.d("SnsAd.FinderLivingNoticeComp", "fillItem:: acquireLivingNoticeStatus is ".concat(String.valueOf(i)));
        AppMethodBeat.o(269174);
        return;
        String str = t.Qu(aYu(((ai)localObject1).getSnsId()));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("sns_id", str);
        ((Bundle)localObject1).putString("finderUsername", Util.nullAsNil(((d)localObject2).finderUsername));
        ((Bundle)localObject1).putString("finderLiveNoticeId", Util.nullAsNil(((d)localObject2).JxY));
        localObject2 = new com.tencent.mm.plugin.sns.ad.remote.a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).JGU = new a();
        ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).JGT = new b(this, true);
        localObject2 = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject2).fKZ();
        if (localObject2 != null) {
          i = h.getInt(((com.tencent.mm.plugin.sns.ad.remote.ipc.a)localObject2).aw((Bundle)localObject1), "status", 257);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269174);
    }
  }
  
  public static final class a
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(269020);
      Bundle localBundle = new Bundle();
      final String str1 = h.getString(paramBundle, "sns_id");
      String str2 = h.getString(paramBundle, "finderUsername");
      paramBundle = h.getString(paramBundle, "finderLiveNoticeId");
      if (!TextUtils.isEmpty(str1))
      {
        localBundle.putInt("status", com.tencent.mm.plugin.sns.ad.widget.living.b.fX(str1, 1));
        com.tencent.mm.plugin.sns.ad.b.b.a(str1, str2, paramBundle, new b.a()
        {
          public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(198037);
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
                AppMethodBeat.o(198037);
                return;
              }
              com.tencent.mm.plugin.sns.ad.widget.living.b.fY(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString = paramb;
              if (paramAnonymousString == null)
              {
                AppMethodBeat.o(198037);
                return;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putInt("status", ((Integer)paramAnonymousObject).intValue());
              paramAnonymousString.putInt("errorCode", paramAnonymousInt2);
              paramb.ax(paramAnonymousString);
              AppMethodBeat.o(198037);
              return;
            }
            catch (Throwable paramAnonymousString)
            {
              AppMethodBeat.o(198037);
            }
          }
        });
      }
      AppMethodBeat.o(269020);
      return localBundle;
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.sns.ad.remote.a.a
  {
    final Reference<c> JAn;
    final boolean JAo;
    
    b(c paramc)
    {
      this(paramc, false);
    }
    
    b(c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(199668);
      this.JAn = new WeakReference(paramc);
      this.JAo = paramBoolean;
      AppMethodBeat.o(199668);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void av(Bundle paramBundle)
    {
      AppMethodBeat.i(199672);
      try
      {
        Log.d("SnsAd.FinderLivingNoticeComp", "OnSubscriptionOfFinderLivingOnClient is called");
        int i = h.getInt(paramBundle, "status", 257);
        int j = h.getInt(paramBundle, "errorCode", 0);
        paramBundle = (c)this.JAn.get();
        if (paramBundle != null)
        {
          s locals = paramBundle.JAc;
          if ((locals != null) && (locals.isShowing())) {
            locals.dismiss();
          }
          if (!this.JAo) {
            com.tencent.mm.plugin.sns.ad.b.b.aG(paramBundle.context, j);
          }
          paramBundle.aeK(i);
        }
        AppMethodBeat.o(199672);
        return;
      }
      catch (Throwable paramBundle)
      {
        AppMethodBeat.o(199672);
      }
    }
  }
  
  public static final class c
    implements com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, final Bundle paramBundle)
    {
      AppMethodBeat.i(195589);
      final String str1 = h.getString(paramBundle, "sns_id");
      final String str2 = h.getString(paramBundle, "uxInfo");
      final String str3 = h.getString(paramBundle, "adExtInfo");
      final String str4 = h.getString(paramBundle, "finderUsername");
      paramBundle = h.getString(paramBundle, "finderLiveNoticeId");
      com.tencent.mm.plugin.sns.ad.b.b.b(str1, str4, paramBundle, new b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(249150);
          Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + str1 + ", inner snsId is " + paramAnonymousString);
          if (paramAnonymousInt2 == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fY(paramAnonymousString, 513);
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
              paramb.ax(paramAnonymousString);
            }
            AppMethodBeat.o(249150);
            return;
          }
        }
      });
      AppMethodBeat.o(195589);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.c
 * JD-Core Version:    0.7.0.1
 */