package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class a
  implements b
{
  private static boolean aYE(String paramString)
  {
    AppMethodBeat.i(270330);
    try
    {
      boolean bool = i.lc(paramString, "headCanvasInfo");
      AppMethodBeat.o(270330);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(270330);
    }
    return false;
  }
  
  private static boolean ay(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(270332);
    if ((paramIntent == null) || (paramContext == null))
    {
      AppMethodBeat.o(270332);
      return false;
    }
    try
    {
      if ((paramContext instanceof Activity))
      {
        Activity localActivity = (Activity)paramContext;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramIntent.aFh(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)paramContext).overridePendingTransition(i.a.slide_right_in, i.a.anim_not_change);
      }
      for (;;)
      {
        AppMethodBeat.o(270332);
        return true;
        paramIntent.addFlags(268435456);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(270332);
    }
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(270328);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(270328);
      return false;
    }
    paramd = paramSnsInfo.getAdXml();
    if (!aYE(paramd.xml))
    {
      AppMethodBeat.o(270328);
      return false;
    }
    String str = paramd.xml.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("headCanvasInfo", "adCanvasInfo");
    if (paramInt == 0) {}
    for (paramInt = 22; (paramView == null) || (paramView.getContext() == null) || (paramSnsInfo == null) || (TextUtils.isEmpty(str)); paramInt = 23)
    {
      paramSnsInfo = null;
      boolean bool = ay(paramView.getContext(), paramSnsInfo);
      AppMethodBeat.o(270328);
      return bool;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landing_pages_share_sns_id", paramSnsInfo.getSnsId());
    if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine() != null)) {}
    for (paramd = paramSnsInfo.getTimeLine().Id;; paramd = "")
    {
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramd);
      localIntent.putExtra("sns_landing_pages_ux_info", paramSnsInfo.getUxinfo());
      localIntent.putExtra("sns_landing_pages_xml", str);
      localIntent.setClass(paramView.getContext(), SnsAdNativeLandingPagesUI.class);
      localIntent.putExtra("sns_landig_pages_from_source", paramInt);
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      localIntent.putExtra("sns_landing_is_native_sight_ad", true);
      localIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
      paramSnsInfo = localIntent;
      break;
    }
  }
  
  public final void b(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(270329);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.y("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        k.a(paramSnsInfo, 21);
        t.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(270329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */