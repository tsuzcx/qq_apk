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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class d
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
      k.jm("16552", localJSONObject1.toString());
      AppMethodBeat.o(176418);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("FullCardAdUtils", "gestureCgiReport exp=" + paramString1.toString());
      AppMethodBeat.o(176418);
    }
  }
  
  public static void a(Context paramContext, View paramView, p paramp, int paramInt)
  {
    AppMethodBeat.i(179353);
    try
    {
      ae.i("FullCardAdUtils", "openGestureLandingPage, source=" + paramInt + ", snsId=" + paramp.field_snsId);
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_left", arrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", arrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramView.getWidth());
      localIntent.putExtra("img_gallery_height", paramView.getHeight());
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramp.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.ebP().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.ecx());
      paramView = paramp.dVj().dZK();
      if (!i.jS(paramp.dVj().dCX, "adFullCardGestureCanvasInfo")) {
        paramView.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
      }
      localIntent.putExtra("sns_landing_pages_xml", paramView);
      localIntent.setClass(paramContext, SnsAdNativeLandingPagesUI.class);
      localIntent.putExtra("sns_landig_pages_from_source", paramInt);
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      localIntent.putExtra("sns_landing_is_native_sight_ad", true);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.ahE(), "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(179353);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("FullCardAdUtils", "openGestureLandingPage, exp=" + paramContext.toString());
      AppMethodBeat.o(179353);
    }
  }
  
  public static void a(final b.h paramh, int paramInt, final ImageView paramImageView1, final ImageView paramImageView2)
  {
    AppMethodBeat.i(100072);
    if (paramh == null)
    {
      AppMethodBeat.o(100072);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220088);
        ae.d("FullCardAdUtils", "curPlayTime:" + this.AOd + ", disppear=" + paramh.zOJ + ", appear=" + paramh.zOL);
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramh.zOI))
            {
              com.tencent.mm.plugin.sns.ad.f.b.i(paramh.zOI, paramImageView1);
              if ((this.AOd >= this.AOg) && (this.AOg > 0))
              {
                ImageView localImageView = paramImageView1;
                AlphaAnimation localAlphaAnimation;
                if (localImageView.getVisibility() == 0)
                {
                  ae.d("FullCardAdUtils", "animHideView:" + localImageView.hashCode());
                  localImageView.setVisibility(4);
                  localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                if (TextUtils.isEmpty(paramh.zOK)) {
                  break label414;
                }
                com.tencent.mm.plugin.sns.ad.f.b.i(paramh.zOK, paramImageView2);
                if (this.AOd < this.AOi) {
                  break;
                }
                localImageView = paramImageView2;
                if (localImageView.getVisibility() != 0)
                {
                  ae.d("FullCardAdUtils", "animShowView:" + localImageView.hashCode());
                  localImageView.setVisibility(0);
                  localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                AppMethodBeat.o(220088);
                return;
              }
              if (paramImageView1.getVisibility() == 0) {
                continue;
              }
              paramImageView1.setVisibility(0);
              ae.d("FullCardAdUtils", "show frontCoverIv, hash=" + paramImageView1.hashCode());
              continue;
            }
            d.j(paramImageView1);
          }
          catch (Exception localException)
          {
            ae.e("FullCardAdUtils", "checkCoverImageState exp=" + localException.toString());
            AppMethodBeat.o(220088);
            return;
          }
        }
        if (paramImageView2.getVisibility() == 0)
        {
          paramImageView2.setVisibility(4);
          ae.d("FullCardAdUtils", "hide endCoverIv, hash=" + paramImageView2.hashCode());
          AppMethodBeat.o(220088);
          return;
          label414:
          d.j(paramImageView2);
        }
        AppMethodBeat.o(220088);
      }
    });
    AppMethodBeat.o(100072);
  }
  
  public static boolean ehO()
  {
    AppMethodBeat.i(179354);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxg, 0);
    ae.i("FullCardAdUtils", "isExptUseNewPlayer, value=".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(179354);
      return true;
    }
    AppMethodBeat.o(179354);
    return false;
  }
  
  static void j(ImageView paramImageView)
  {
    AppMethodBeat.i(160748);
    paramImageView.setVisibility(4);
    paramImageView.setImageDrawable(null);
    paramImageView.setTag(2131304892, "");
    AppMethodBeat.o(160748);
  }
  
  public static void k(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(160749);
    if (TextUtils.isEmpty(paramString))
    {
      j(paramImageView);
      AppMethodBeat.o(160749);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(2131304892))) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(160749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */