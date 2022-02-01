package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class k
{
  public static void d(ADXml paramADXml)
  {
    AppMethodBeat.i(311162);
    if (paramADXml == null)
    {
      Log.w("AdUserAvatarHelper", "the ad xml is null");
      AppMethodBeat.o(311162);
      return;
    }
    if ((paramADXml.usePreferedInfo) && (!TextUtils.isEmpty(paramADXml.preferAvatar)) && (hbW()))
    {
      Log.i("AdUserAvatarHelper", "ready to preload preferAvatar: " + paramADXml.preferAvatar);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.c("adId", paramADXml.preferAvatar, new a(null));
    }
    AppMethodBeat.o(311162);
  }
  
  public static boolean hbW()
  {
    AppMethodBeat.i(311155);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIo, 1);
      Log.i("AdUserAvatarHelper", "useCdnDownloadUserAvatar value is ".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(311155);
    }
    return false;
  }
  
  public static void i(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(311169);
    try
    {
      Log.d("AdUserAvatarHelper", "use fillUserAvatarWhenFileExisted: " + paramString + ", imgDisplayType: " + paramInt);
      o.PWQ.h(paramImageView, paramString, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(311169);
    }
  }
  
  public static void j(ImageView paramImageView, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(311178);
    if (paramImageView != null) {}
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: the avatar url is empty or image view is empty");
        AppMethodBeat.o(311178);
        return;
      }
      Log.d("AdUserAvatarHelper", "use fillUserAvatarAsyncWithCdn: url is " + paramString + ", image view is " + paramImageView + ", imgDisplayType: " + paramInt);
      if (!paramString.equalsIgnoreCase((String)l.aX(paramImageView, b.f.sns_prefer_avatar_url))) {
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: the input avatarUrl is not same as the tag url in the ImageView");
      }
    }
    finally
    {
      AppMethodBeat.o(311178);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.c("adId", paramString, new a(paramImageView)
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(311101);
        super.aWn(paramAnonymousString);
        Log.i("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: download is success, it is going to set image view");
        if (this.QaF != null)
        {
          ImageView localImageView = (ImageView)this.QaF.get();
          if (localImageView != null)
          {
            o.PWQ.h(localImageView, paramAnonymousString, paramInt);
            AppMethodBeat.o(311101);
            return;
          }
          Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn, imageViewRef released, url=" + paramString);
        }
        AppMethodBeat.o(311101);
      }
      
      public final void gZN()
      {
        AppMethodBeat.i(311091);
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: download has something error");
        AppMethodBeat.o(311091);
      }
    });
    AppMethodBeat.o(311178);
  }
  
  public static class a
    implements g.a
  {
    WeakReference<ImageView> QaF;
    
    public a(ImageView paramImageView)
    {
      AppMethodBeat.i(311050);
      if (paramImageView != null) {
        this.QaF = new WeakReference(paramImageView);
      }
      AppMethodBeat.o(311050);
    }
    
    public void aWn(String paramString)
    {
      AppMethodBeat.i(311070);
      Log.i("AdUserAvatarHelper", "the downloaded path is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(311070);
    }
    
    public final void gZM() {}
    
    public void gZN() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.k
 * JD-Core Version:    0.7.0.1
 */