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
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class e
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
      k.jY("16552", localJSONObject1.toString());
      AppMethodBeat.o(176418);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("FullCardAdUtils", "gestureCgiReport exp=" + paramString1.toString());
      AppMethodBeat.o(176418);
    }
  }
  
  public static void a(Context paramContext, View paramView, SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(179353);
    try
    {
      Log.i("FullCardAdUtils", "openGestureLandingPage, source=" + paramInt + ", snsId=" + paramSnsInfo.field_snsId);
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_left", arrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", arrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramView.getWidth());
      localIntent.putExtra("img_gallery_height", paramView.getHeight());
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramSnsInfo.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramSnsInfo.getTimeLine().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramSnsInfo.getUxinfo());
      paramView = paramSnsInfo.getAdXml().getGestureCanvasInfo();
      if (!i.kG(paramSnsInfo.getAdXml().xml, "adFullCardGestureCanvasInfo")) {
        paramView.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
      }
      localIntent.putExtra("sns_landing_pages_xml", paramView);
      localIntent.setClass(paramContext, SnsAdNativeLandingPagesUI.class);
      localIntent.putExtra("sns_landig_pages_from_source", paramInt);
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      if (!paramSnsInfo.getAdXml().forbiddenCustomAnimation) {
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      }
      localIntent.putExtra("sns_landing_is_native_sight_ad", true);
      if (paramSnsInfo.isTwistAd()) {
        localIntent.putExtra("sns_landing_page_is_gesture_twist_ad", true);
      }
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.axQ(), "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((!paramSnsInfo.getAdXml().forbiddenCustomAnimation) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(179353);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("FullCardAdUtils", "openGestureLandingPage, exp=" + paramContext.toString());
      AppMethodBeat.o(179353);
    }
  }
  
  public static void a(final ADXml.g paramg, int paramInt, final ImageView paramImageView1, final ImageView paramImageView2)
  {
    AppMethodBeat.i(100072);
    if (paramg == null)
    {
      AppMethodBeat.o(100072);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203920);
        Log.d("FullCardAdUtils", "curPlayTime:" + this.EYy + ", disppear=" + paramg.DWB + ", appear=" + paramg.DWD);
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramg.DWA))
            {
              com.tencent.mm.plugin.sns.ad.i.b.j(paramg.DWA, paramImageView1);
              if ((this.EYy >= this.EYB) && (this.EYB > 0))
              {
                ImageView localImageView = paramImageView1;
                AlphaAnimation localAlphaAnimation;
                if (localImageView.getVisibility() == 0)
                {
                  Log.d("FullCardAdUtils", "animHideView:" + localImageView.hashCode());
                  localImageView.setVisibility(4);
                  localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                if (TextUtils.isEmpty(paramg.DWC)) {
                  break label414;
                }
                com.tencent.mm.plugin.sns.ad.i.b.j(paramg.DWC, paramImageView2);
                if (this.EYy < this.EYD) {
                  break;
                }
                localImageView = paramImageView2;
                if (localImageView.getVisibility() != 0)
                {
                  Log.d("FullCardAdUtils", "animShowView:" + localImageView.hashCode());
                  localImageView.setVisibility(0);
                  localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                AppMethodBeat.o(203920);
                return;
              }
              if (paramImageView1.getVisibility() == 0) {
                continue;
              }
              paramImageView1.setVisibility(0);
              Log.d("FullCardAdUtils", "show frontCoverIv, hash=" + paramImageView1.hashCode());
              continue;
            }
            e.l(paramImageView1);
          }
          catch (Exception localException)
          {
            Log.e("FullCardAdUtils", "checkCoverImageState exp=" + localException.toString());
            AppMethodBeat.o(203920);
            return;
          }
        }
        if (paramImageView2.getVisibility() == 0)
        {
          paramImageView2.setVisibility(4);
          Log.d("FullCardAdUtils", "hide endCoverIv, hash=" + paramImageView2.hashCode());
          AppMethodBeat.o(203920);
          return;
          label414:
          e.l(paramImageView2);
        }
        AppMethodBeat.o(203920);
      }
    });
    AppMethodBeat.o(100072);
  }
  
  public static boolean fkr()
  {
    AppMethodBeat.i(179354);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOT, 0);
    Log.i("FullCardAdUtils", "isExptUseNewPlayer, value=".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(179354);
      return true;
    }
    AppMethodBeat.o(179354);
    return false;
  }
  
  static void l(ImageView paramImageView)
  {
    AppMethodBeat.i(160748);
    paramImageView.setVisibility(4);
    paramImageView.setImageDrawable(null);
    paramImageView.setTag(2131307979, "");
    AppMethodBeat.o(160748);
  }
  
  public static void l(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(160749);
    if (TextUtils.isEmpty(paramString))
    {
      l(paramImageView);
      AppMethodBeat.o(160749);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(2131307979))) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(160749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */