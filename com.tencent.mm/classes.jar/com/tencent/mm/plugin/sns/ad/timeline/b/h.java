package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.f.o;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class h
{
  public static void c(ADXml paramADXml)
  {
    AppMethodBeat.i(231207);
    if (paramADXml == null)
    {
      Log.w("AdUserAvatarHelper", "the ad xml is null");
      AppMethodBeat.o(231207);
      return;
    }
    if ((paramADXml.usePreferedInfo) && (!TextUtils.isEmpty(paramADXml.preferAvatar)) && (fLz()))
    {
      Log.i("AdUserAvatarHelper", "ready to preload preferAvatar: " + paramADXml.preferAvatar);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.b("adId", paramADXml.preferAvatar, new a(null));
    }
    AppMethodBeat.o(231207);
  }
  
  public static boolean fLz()
  {
    AppMethodBeat.i(231205);
    try
    {
      int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvs, 1);
      Log.i("AdUserAvatarHelper", "useCdnDownloadUserAvatar value is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(231205);
        return true;
      }
      AppMethodBeat.o(231205);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(231205);
    }
    return false;
  }
  
  public static void i(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(231211);
    try
    {
      Log.d("AdUserAvatarHelper", "use fillUserAvatarWhenFileExisted: " + paramString + ", imgDisplayType: " + paramInt);
      o.JFQ.h(paramImageView, paramString, paramInt);
      AppMethodBeat.o(231211);
      return;
    }
    catch (Throwable paramImageView)
    {
      AppMethodBeat.o(231211);
    }
  }
  
  public static void j(ImageView paramImageView, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(231212);
    if (paramImageView != null) {}
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: the avatar url is empty or image view is empty");
        AppMethodBeat.o(231212);
        return;
      }
      Log.d("AdUserAvatarHelper", "use fillUserAvatarAsyncWithCdn: url is " + paramString + ", image view is " + paramImageView + ", imgDisplayType: " + paramInt);
      if (!paramString.equalsIgnoreCase((String)l.aB(paramImageView, i.f.sns_prefer_avatar_url)))
      {
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: the input avatarUrl is not same as the tag url in the ImageView");
        AppMethodBeat.o(231212);
        return;
      }
    }
    catch (Throwable paramImageView)
    {
      AppMethodBeat.o(231212);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.b("adId", paramString, new a(paramImageView)
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(268645);
        super.aYs(paramAnonymousString);
        Log.i("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: download is success, it is going to set image view");
        if (this.JJd != null)
        {
          ImageView localImageView = (ImageView)this.JJd.get();
          if (localImageView != null)
          {
            o.JFQ.h(localImageView, paramAnonymousString, paramInt);
            AppMethodBeat.o(268645);
            return;
          }
          Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn, imageViewRef released, url=" + paramString);
        }
        AppMethodBeat.o(268645);
      }
      
      public final void fJV()
      {
        AppMethodBeat.i(268643);
        Log.w("AdUserAvatarHelper", "fillUserAvatarAsyncWithCdn: download has something error");
        AppMethodBeat.o(268643);
      }
    });
    AppMethodBeat.o(231212);
  }
  
  public static class a
    implements f.a
  {
    WeakReference<ImageView> JJd;
    
    public a(ImageView paramImageView)
    {
      AppMethodBeat.i(268423);
      if (paramImageView != null) {
        this.JJd = new WeakReference(paramImageView);
      }
      AppMethodBeat.o(268423);
    }
    
    public void aYs(String paramString)
    {
      AppMethodBeat.i(268425);
      Log.i("AdUserAvatarHelper", "the downloaded path is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(268425);
    }
    
    public final void fJU() {}
    
    public void fJV() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.h
 * JD-Core Version:    0.7.0.1
 */