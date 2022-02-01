package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class a
  implements b
{
  private static boolean aNO(String paramString)
  {
    AppMethodBeat.i(202105);
    try
    {
      boolean bool = i.kG(paramString, "headCanvasInfo");
      AppMethodBeat.o(202105);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202105);
    }
    return false;
  }
  
  private static boolean ap(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(202106);
    if ((paramIntent == null) || (paramContext == null))
    {
      AppMethodBeat.o(202106);
      return false;
    }
    try
    {
      if ((paramContext instanceof Activity))
      {
        Activity localActivity = (Activity)paramContext;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramIntent.axQ(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)paramContext).overridePendingTransition(2130772169, 2130771986);
      }
      for (;;)
      {
        AppMethodBeat.o(202106);
        return true;
        paramIntent.addFlags(268435456);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(202106);
    }
  }
  
  public final void a(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202104);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.z("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        j.a(paramSnsInfo, 21);
        r.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(202104);
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202103);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(202103);
      return false;
    }
    paramd = paramSnsInfo.getAdXml();
    if (!aNO(paramd.xml))
    {
      AppMethodBeat.o(202103);
      return false;
    }
    String str = paramd.xml.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("headCanvasInfo", "adCanvasInfo");
    if (paramInt == 0) {}
    for (paramInt = 22; (paramView == null) || (paramView.getContext() == null) || (paramSnsInfo == null) || (TextUtils.isEmpty(str)); paramInt = 23)
    {
      paramSnsInfo = null;
      boolean bool = ap(paramView.getContext(), paramSnsInfo);
      AppMethodBeat.o(202103);
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
      paramSnsInfo = localIntent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */