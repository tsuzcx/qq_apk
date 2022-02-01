package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.f;
import org.json.JSONObject;

public final class c
{
  public static void a(int paramInt1, float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(176418);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("result", paramInt1);
      localJSONObject2.put("score", paramFloat1);
      localJSONObject2.put("targetScore", paramFloat2);
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", paramString1);
      localJSONObject1.put("snsId", paramString2);
      localJSONObject1.put("scene", paramInt2);
      j.ix("16552", localJSONObject1.toString());
      AppMethodBeat.o(176418);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("FullCardAdUtils", "gestureCgiReport exp=" + paramString1.toString());
      AppMethodBeat.o(176418);
    }
  }
  
  public static void a(Context paramContext, View paramView, p paramp, int paramInt)
  {
    AppMethodBeat.i(179353);
    try
    {
      ad.i("FullCardAdUtils", "openGestureLandingPage, source=" + paramInt + ", snsId=" + paramp.field_snsId);
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_left", arrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", arrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramView.getWidth());
      localIntent.putExtra("img_gallery_height", paramView.getHeight());
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramp.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.dxy().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.dyg());
      paramView = paramp.dxs().dvu();
      if (!i.jb(paramp.dxs().dsv, "adFullCardGestureCanvasInfo")) {
        paramView.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
      }
      localIntent.putExtra("sns_landing_pages_xml", paramView);
      localIntent.setClass(paramContext, SnsAdNativeLandingPagesUI.class);
      localIntent.putExtra("sns_landig_pages_from_source", paramInt);
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      localIntent.putExtra("sns_landing_is_native_sight_ad", true);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.adn(), "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(179353);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("FullCardAdUtils", "openGestureLandingPage, exp=" + paramContext.toString());
      AppMethodBeat.o(179353);
    }
  }
  
  public static void a(final b.f paramf, int paramInt, final ImageView paramImageView1, final ImageView paramImageView2)
  {
    AppMethodBeat.i(100072);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100070);
        ad.d("FullCardAdUtils", "curPlayTime:" + this.xRU + ", disppear=" + paramf.wUp + ", appear=" + paramf.wUr);
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramf.wUo))
            {
              c.h(paramf.wUo, paramImageView1);
              if ((this.xRU >= this.xRX) && (this.xRX > 0))
              {
                ImageView localImageView = paramImageView1;
                AlphaAnimation localAlphaAnimation;
                if (localImageView.getVisibility() == 0)
                {
                  ad.d("FullCardAdUtils", "animHideView:" + localImageView.hashCode());
                  localImageView.setVisibility(4);
                  localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                if (TextUtils.isEmpty(paramf.wUq)) {
                  break label414;
                }
                c.h(paramf.wUq, paramImageView2);
                if (this.xRU < this.xRZ) {
                  break;
                }
                localImageView = paramImageView2;
                if (localImageView.getVisibility() != 0)
                {
                  ad.d("FullCardAdUtils", "animShowView:" + localImageView.hashCode());
                  localImageView.setVisibility(0);
                  localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                AppMethodBeat.o(100070);
                return;
              }
              if (paramImageView1.getVisibility() == 0) {
                continue;
              }
              paramImageView1.setVisibility(0);
              ad.d("FullCardAdUtils", "show frontCoverIv, hash=" + paramImageView1.hashCode());
              continue;
            }
            c.i(paramImageView1);
          }
          catch (Exception localException)
          {
            ad.e("FullCardAdUtils", "checkCoverImageState exp=" + localException.toString());
            AppMethodBeat.o(100070);
            return;
          }
        }
        if (paramImageView2.getVisibility() == 0)
        {
          paramImageView2.setVisibility(4);
          ad.d("FullCardAdUtils", "hide endCoverIv, hash=" + paramImageView2.hashCode());
          AppMethodBeat.o(100070);
          return;
          label414:
          c.i(paramImageView2);
        }
        AppMethodBeat.o(100070);
      }
    });
    AppMethodBeat.o(100072);
  }
  
  public static boolean dDp()
  {
    AppMethodBeat.i(179354);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjq, 0);
    ad.i("FullCardAdUtils", "isExptUseNewPlayer, value=".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(179354);
      return true;
    }
    AppMethodBeat.o(179354);
    return false;
  }
  
  public static void h(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(100071);
    if (!paramString.equals((String)paramImageView.getTag(2131304892)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(100071);
  }
  
  static void i(ImageView paramImageView)
  {
    AppMethodBeat.i(160748);
    paramImageView.setVisibility(4);
    paramImageView.setImageDrawable(null);
    paramImageView.setTag(2131304892, "");
    AppMethodBeat.o(160748);
  }
  
  public static void i(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(160749);
    if (TextUtils.isEmpty(paramString))
    {
      i(paramImageView);
      AppMethodBeat.o(160749);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(2131304892))) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(160749);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(176417);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(176417);
      return;
    }
    ad.d("FullCardAdUtils", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131304892, paramString);
    h.a(paramString, new f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(100069);
        try
        {
          String str = (String)this.rmn.getTag(2131304892);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = f.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.rmn.setImageBitmap(paramAnonymousString);
              ad.d("FullCardAdUtils", "onDownloaded succ, hash=" + this.rmn.hashCode());
              AppMethodBeat.o(100069);
              return;
              str = h.iU("adId", str);
            }
            else
            {
              ad.e("FullCardAdUtils", "onDownloaded, bitmap==null");
              AppMethodBeat.o(100069);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          ad.e("FullCardAdUtils", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(100069);
          return;
        }
        ad.d("FullCardAdUtils", "onDownloaded, url changed");
        AppMethodBeat.o(100069);
      }
      
      public final void dsA()
      {
        AppMethodBeat.i(100068);
        this.rmn.setTag(2131304892, "");
        ad.e("FullCardAdUtils", "onDownloadError, hash=" + this.rmn.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(100068);
      }
      
      public final void duP() {}
    });
    AppMethodBeat.o(176417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */