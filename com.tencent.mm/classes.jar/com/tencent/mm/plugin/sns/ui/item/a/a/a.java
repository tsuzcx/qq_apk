package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements d
{
  protected SnsInfo PJQ;
  protected String PNx;
  protected com.tencent.mm.plugin.sns.ad.g.l PYh;
  protected c PZr;
  protected ADXml.g QbN;
  public a.b RIM;
  protected com.tencent.mm.plugin.sns.ad.timeline.b.b.a RNT;
  public Activity mActivity;
  protected int xOq;
  
  public void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.PJQ = paramSnsInfo;
    if (paramSnsInfo != null) {}
    for (paramSnsInfo = t.uA(paramSnsInfo.field_snsId);; paramSnsInfo = "")
    {
      this.PNx = paramSnsInfo;
      this.QbN = paramg;
      Log.d("BaseFullCardAdBusiness", "onRefresh, snsId=" + this.PNx);
      return;
    }
  }
  
  public void a(Activity paramActivity, com.tencent.mm.plugin.sns.ad.g.l paraml, c paramc, a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    this.mActivity = paramActivity;
    this.PZr = paramc;
    this.PYh = paraml;
    this.RIM = paramb;
    this.xOq = paramb.Qcx.source;
    this.RNT = parama;
    Log.d("BaseFullCardAdBusiness", "onCreate, source=" + this.xOq);
  }
  
  protected final void amt(int paramInt)
  {
    Log.i("BaseFullCardAdBusiness", "doEggClickReport, clickPos=" + paramInt + ", source=" + this.xOq);
    if ((this.PYh == null) || (this.PJQ == null))
    {
      Log.e("BaseFullCardAdBusiness", "doEggClickReport err, param==null");
      return;
    }
    for (;;)
    {
      try
      {
        if (this.xOq == 0)
        {
          i = 1;
          SnsAdClick localSnsAdClick = new SnsAdClick(this.xOq, i, this.PJQ.field_snsId, paramInt, 21);
          m.a(localSnsAdClick, this.PYh, this.PJQ, paramInt);
          t.a(localSnsAdClick);
          return;
        }
      }
      finally
      {
        Log.i("BaseFullCardAdBusiness", "doEggClickReport, clickPos=" + paramInt + ", source=" + this.xOq + ", exp=" + localObject.toString());
        return;
      }
      int i = 2;
    }
  }
  
  public final void be(Bundle paramBundle)
  {
    if (this.PZr != null) {
      this.PZr.a(this.RIM, paramBundle);
    }
  }
  
  public final void hqY()
  {
    Log.d("BaseFullCardAdBusiness", "onVideoStart, snsId=" + this.PNx);
  }
  
  public void hqZ()
  {
    Log.d("BaseFullCardAdBusiness", "onAdRemoved, snsId=" + this.PNx);
  }
  
  protected final void hra()
  {
    int i = 1;
    Log.i("BaseFullCardAdBusiness", "doOpenNativeEggLandingPage, source=" + this.xOq);
    if ((this.mActivity == null) || (this.PJQ == null))
    {
      Log.e("BaseFullCardAdBusiness", "doOpenNativeEggLandingPage err, param==null");
      return;
    }
    for (;;)
    {
      SnsInfo localSnsInfo;
      Object localObject2;
      try
      {
        int j;
        for (;;)
        {
          j = this.xOq;
          if (j == 2)
          {
            i = 16;
            Activity localActivity = this.mActivity;
            Object localObject3 = this.RIM.Cxb;
            localSnsInfo = this.PJQ;
            try
            {
              Log.i("SnsAdUtil", "openGestureLandingPage, source=" + i + ", snsId=" + localSnsInfo.field_snsId);
              int[] arrayOfInt = new int[2];
              ((View)localObject3).getLocationInWindow(arrayOfInt);
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("img_gallery_left", arrayOfInt[0]);
              ((Intent)localObject2).putExtra("img_gallery_top", arrayOfInt[1]);
              ((Intent)localObject2).putExtra("img_gallery_width", ((View)localObject3).getWidth());
              ((Intent)localObject2).putExtra("img_gallery_height", ((View)localObject3).getHeight());
              ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              localObject3 = localSnsInfo.getAdXml().getGestureCanvasInfo();
              if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.mL(localSnsInfo.getAdXml().xml, "adFullCardGestureCanvasInfo")) {
                ((String)localObject3).replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
              }
              ((Intent)localObject2).putExtra("sns_landing_page_is_interactive_canvas", true);
              ((Intent)localObject2).putExtra("sns_landing_pages_xml", (String)localObject3);
              ((Intent)localObject2).setClass(localActivity, SnsAdNativeLandingPagesUI.class);
              ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
              ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
              if (!localSnsInfo.getAdXml().forbiddenCustomAnimation) {
                ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
              }
              ((Intent)localObject2).putExtra("sns_landing_is_native_sight_ad", true);
              ((Intent)localObject2).putExtra("sns_landing_page_start_time", System.currentTimeMillis());
              if (!localSnsInfo.isTwistAd()) {
                break label544;
              }
              ((Intent)localObject2).putExtra("sns_landing_page_is_gesture_twist_ad", true);
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/data/SnsAdUtil", "openEggLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/sns/data/SnsAdUtil", "openEggLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              if ((localSnsInfo.getAdXml().forbiddenCustomAnimation) || (!(localActivity instanceof Activity))) {
                break;
              }
              ((Activity)localActivity).overridePendingTransition(0, 0);
              return;
            }
            catch (Exception localException) {}
          }
        }
        if (j != 1) {
          continue;
        }
      }
      finally
      {
        Log.e("BaseFullCardAdBusiness", "doOpenNativeEggLandingPage exp=" + localObject1.toString());
        return;
      }
      i = 2;
      continue;
      label544:
      if (localSnsInfo.isShakeAd()) {
        ((Intent)localObject2).putExtra("sns_landing_page_is_gesture_shake_ad", true);
      } else if (localSnsInfo.isLongPressGestureAd()) {
        ((Intent)localObject2).putExtra("sns_landing_page_is_longpress_ad", true);
      }
    }
  }
  
  public void onUIDestroy()
  {
    Log.d("BaseFullCardAdBusiness", "onUIDestroy, snsId=" + this.PNx);
  }
  
  public void onVideoPause()
  {
    Log.d("BaseFullCardAdBusiness", "onVideoPause, snsId=" + this.PNx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a
 * JD-Core Version:    0.7.0.1
 */