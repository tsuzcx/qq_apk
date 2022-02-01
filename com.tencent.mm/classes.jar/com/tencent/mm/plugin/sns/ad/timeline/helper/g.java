package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.a;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements LivingDescBarLayout.b
{
  private LivingDescBarLayout Qav;
  public com.tencent.mm.plugin.sns.ad.adxml.k Qaw;
  
  public g(LivingDescBarLayout paramLivingDescBarLayout)
  {
    this.Qav = paramLivingDescBarLayout;
  }
  
  private void a(final String paramString, final LivingDescBarLayout paramLivingDescBarLayout)
  {
    AppMethodBeat.i(311176);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("SnsAdRollHelper", "setImageBitmapAsync, path is null");
      AppMethodBeat.o(311176);
      return;
    }
    if (paramLivingDescBarLayout == null)
    {
      Log.e("SnsAdRollHelper", "setImageBitmapAsync, bar is null");
      AppMethodBeat.o(311176);
      return;
    }
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(311102);
        try
        {
          final Bitmap localBitmap = BitmapUtil.decodeFile(paramString, null);
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(311064);
                try
                {
                  BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap);
                  g.2.this.Qaz.setIconImage(localBitmapDrawable);
                  AppMethodBeat.o(311064);
                  return;
                }
                finally
                {
                  Log.e("SnsAdRollHelper", "setImageBitmapAsync set bitmap drawable, exp = " + localObject.toString());
                  AppMethodBeat.o(311064);
                }
              }
            });
          }
          AppMethodBeat.o(311102);
          return;
        }
        finally
        {
          Log.e("SnsAdRollHelper", "setImageBitmapAsync decode bitmap drawable, exp = " + localObject.toString());
          AppMethodBeat.o(311102);
        }
      }
    });
    AppMethodBeat.o(311176);
  }
  
  private List<String> hbT()
  {
    AppMethodBeat.i(311164);
    com.tencent.mm.plugin.sns.ad.adxml.k localk = this.Qaw;
    ArrayList localArrayList = new ArrayList();
    if (localk != null) {
      localArrayList.addAll(localk.PMW);
    }
    AppMethodBeat.o(311164);
    return localArrayList;
  }
  
  public final String ajB(int paramInt)
  {
    AppMethodBeat.i(311225);
    Object localObject = hbT();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (String)((List)localObject).get(paramInt);
      AppMethodBeat.o(311225);
      return localObject;
    }
    AppMethodBeat.o(311225);
    return "";
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(311213);
    List localList = hbT();
    if (d.isEmpty(localList))
    {
      AppMethodBeat.o(311213);
      return 0;
    }
    int i = localList.size();
    AppMethodBeat.o(311213);
    return i;
  }
  
  public final void hbR()
  {
    AppMethodBeat.i(311192);
    LivingDescBarLayout localLivingDescBarLayout = this.Qav;
    if (localLivingDescBarLayout == null)
    {
      Log.e("SnsAdRollHelper", "setRollingBarAdapter, rollingBar is null");
      AppMethodBeat.o(311192);
      return;
    }
    if (!localLivingDescBarLayout.hcX())
    {
      Log.i("SnsAdRollHelper", "setRollingBarAdapter, rollingBar adapter is not empty");
      localLivingDescBarLayout.hcY();
      AppMethodBeat.o(311192);
      return;
    }
    if (getCount() == 0)
    {
      Log.i("SnsAdRollHelper", "setRollingBarAdapter, adRollInfoTextList size is 0");
      AppMethodBeat.o(311192);
      return;
    }
    localLivingDescBarLayout.setSlideAdapter(this);
    AppMethodBeat.o(311192);
  }
  
  public final void hbS()
  {
    AppMethodBeat.i(311204);
    LivingDescBarLayout localLivingDescBarLayout = this.Qav;
    if (localLivingDescBarLayout == null)
    {
      Log.e("SnsAdRollHelper", "setRollingBarStatus, rollingBar is null");
      AppMethodBeat.o(311204);
      return;
    }
    if (getCount() == 0)
    {
      Log.i("SnsAdRollHelper", "setRollingBarStatus, adRollInfoTextList size is 0");
      localLivingDescBarLayout.setVisibility(4);
      localLivingDescBarLayout.hcZ();
      AppMethodBeat.o(311204);
      return;
    }
    localLivingDescBarLayout.setVisibility(0);
    AppMethodBeat.o(311204);
  }
  
  public final void hbU()
  {
    AppMethodBeat.i(311239);
    Object localObject = this.Qaw;
    if (localObject == null)
    {
      Log.e("SnsAdRollHelper", "checkLoadImage, adRollInfo is null");
      AppMethodBeat.o(311239);
      return;
    }
    LivingDescBarLayout localLivingDescBarLayout = this.Qav;
    if (localLivingDescBarLayout == null)
    {
      Log.e("SnsAdRollHelper", "checkLoadImage, rollingBar is null");
      AppMethodBeat.o(311239);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.ad.adxml.k)localObject).iconUrl;
    if (Util.isNullOrNil((String)localObject))
    {
      localLivingDescBarLayout.hcW();
      Log.i("SnsAdRollHelper", "checkLoadImage, iconUrl is null");
      AppMethodBeat.o(311239);
      return;
    }
    if ((!((String)localObject).equals((String)localLivingDescBarLayout.getTag(b.f.sns_ad_card_img_url))) && (!Util.isNullOrNil((String)localObject)))
    {
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId_mm", (String)localObject);
      if ((!Util.isNullOrNil(str)) && (y.ZC(str)))
      {
        a(str, localLivingDescBarLayout);
        AppMethodBeat.o(311239);
        return;
      }
      localLivingDescBarLayout.setTag(b.f.sns_ad_card_img_url, localObject);
      Log.d("SnsAdRollHelper", "loadImage, hash = " + localLivingDescBarLayout.hashCode() + ", url = " + (String)localObject);
      a.a((String)localObject, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(311115);
          for (;;)
          {
            try
            {
              LivingDescBarLayout localLivingDescBarLayout = (LivingDescBarLayout)this.Qax.get();
              if (localLivingDescBarLayout == null)
              {
                Log.w("SnsAdRollHelper", "realBar released");
                AppMethodBeat.o(311115);
                return;
              }
              str = (String)localLivingDescBarLayout.getTag(b.f.sns_ad_card_img_url);
              if (Util.isNullOrNil(str))
              {
                str = "";
                if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                  break;
                }
                g.a(g.this, paramAnonymousString, localLivingDescBarLayout);
                AppMethodBeat.o(311115);
                return;
              }
            }
            finally
            {
              Log.e("SnsAdRollHelper", "onDownloaded, exp = " + paramAnonymousString.toString());
              AppMethodBeat.o(311115);
              return;
            }
            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId_mm", str);
          }
          Log.d("SnsAdRollHelper", "onDownloaded, url changed");
          AppMethodBeat.o(311115);
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(311108);
          LivingDescBarLayout localLivingDescBarLayout = (LivingDescBarLayout)this.Qax.get();
          if (localLivingDescBarLayout == null)
          {
            Log.w("SnsAdRollHelper", "realBar released");
            AppMethodBeat.o(311108);
            return;
          }
          localLivingDescBarLayout.setTag(b.f.sns_ad_card_img_url, "");
          localLivingDescBarLayout.hcW();
          Log.e("SnsAdRollHelper", "onDownloadError, hash = " + localLivingDescBarLayout.hashCode() + ", url = " + this.PUd);
          AppMethodBeat.o(311108);
        }
      });
    }
    AppMethodBeat.o(311239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.g
 * JD-Core Version:    0.7.0.1
 */