package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.j.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class a
  implements b
{
  private static boolean aH(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(311345);
    if ((paramIntent == null) || (paramContext == null))
    {
      AppMethodBeat.o(311345);
      return false;
    }
    try
    {
      if ((paramContext instanceof Activity))
      {
        Activity localActivity = (Activity)paramContext;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramIntent.aYi(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)paramContext).overridePendingTransition(b.a.slide_right_in, b.a.anim_not_change);
      }
      for (;;)
      {
        return true;
        paramIntent.addFlags(268435456);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(311345);
    }
  }
  
  private static boolean aWI(String paramString)
  {
    AppMethodBeat.i(311331);
    try
    {
      boolean bool = l.mL(paramString, "headCanvasInfo");
      return bool;
    }
    finally
    {
      AppMethodBeat.o(311331);
    }
    return false;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(311357);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(311357);
      return false;
    }
    paramd = paramSnsInfo.getAdXml();
    if (!aWI(paramd.xml))
    {
      AppMethodBeat.o(311357);
      return false;
    }
    String str = paramd.xml.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("headCanvasInfo", "adCanvasInfo");
    if (paramInt == 0) {}
    for (paramInt = 22; (paramView == null) || (paramView.getContext() == null) || (paramSnsInfo == null) || (TextUtils.isEmpty(str)); paramInt = 23)
    {
      paramSnsInfo = null;
      boolean bool = aH(paramView.getContext(), paramSnsInfo);
      AppMethodBeat.o(311357);
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
    AppMethodBeat.i(311363);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.K("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        k.a(paramSnsInfo, 21);
        t.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(311363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */