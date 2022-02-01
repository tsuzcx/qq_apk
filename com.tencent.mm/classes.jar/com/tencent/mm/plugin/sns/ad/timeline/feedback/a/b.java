package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.i.j.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  implements j.a
{
  private long JIs;
  private String JIt;
  private String JIu;
  private int JIv;
  private int JIw;
  private int JIx;
  private Long JIy;
  private int JIz;
  private int mScene;
  
  public static j.a a(SnsInfo paramSnsInfo, boolean paramBoolean, View paramView, l paraml)
  {
    int k = 2;
    AppMethodBeat.i(198129);
    if ((paramSnsInfo == null) || (paramView == null))
    {
      AppMethodBeat.o(198129);
      return null;
    }
    int i;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        boolean bool = paramSnsInfo.isAd();
        if (!bool)
        {
          AppMethodBeat.o(198129);
          return null;
        }
        if ((paraml != null) && (paraml.source != 0))
        {
          i = 1;
          localObject1 = paramSnsInfo.getAdInfo();
          localObject2 = paramSnsInfo.getAdXml();
          if ((paramSnsInfo != null) && (localObject1 != null) && (localObject2 != null) && (paramView != null)) {
            break;
          }
          AppMethodBeat.o(198129);
          return null;
        }
      }
      catch (Throwable paramSnsInfo)
      {
        AppMethodBeat.o(198129);
        return null;
      }
      i = 0;
    }
    if (!paramSnsInfo.isAd())
    {
      AppMethodBeat.o(198129);
      return null;
    }
    b localb = new b();
    localb.JIs = paramSnsInfo.field_snsId;
    localb.JIt = k.aYR(((ADInfo)localObject1).uxInfo);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.JIu = ((ADXml)localObject2).adExtInfo;
      if (!paramBoolean) {
        break label357;
      }
      j = k;
      label184:
      localb.JIz = j;
      if (i == 0) {
        break label363;
      }
      localObject1 = ax(paramView, i.f.album_comment_list);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        localb.JIv = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.JIw = (i / 2 + k);
        localb.JIx = (localObject1[1] + j / 2);
      }
      if ((paraml != null) && (paramSnsInfo.getTimeLine() != null) && (paramSnsInfo.getTimeLine().ContentObj != null) && (paramSnsInfo.getTimeLine().ContentObj.Sqq == 15)) {
        localb.JIy = Long.valueOf(paraml.Qo(localb.JIs));
      }
      AppMethodBeat.o(198129);
      return localb;
      j = 1;
      break;
      label357:
      j = 1;
      break label184;
      label363:
      localObject1 = ax(paramView, i.f.sns_item_root);
      paramBoolean = localObject1 instanceof AdFrameLayout;
      if (!paramBoolean) {
        localObject1 = paramView;
      }
    }
  }
  
  public static j.a a(String paramString, View paramView, l paraml)
  {
    AppMethodBeat.i(198115);
    try
    {
      paramString = a(aj.fOI().bbl(paramString), true, paramView, paraml);
      AppMethodBeat.o(198115);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(198115);
    }
    return null;
  }
  
  private static View ax(View paramView, int paramInt)
  {
    AppMethodBeat.i(198142);
    View localView = paramView;
    if (paramView != null) {}
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      localView = paramView;
      if ((localViewParent instanceof View))
      {
        paramView = (View)localViewParent;
        if (paramView.getId() == paramInt) {
          localView = paramView;
        }
      }
      else
      {
        AppMethodBeat.o(198142);
        return localView;
      }
    }
  }
  
  private String brC()
  {
    AppMethodBeat.i(198139);
    try
    {
      Object localObject = fLu();
      ((JSONObject)localObject).put("extInfo", fLv());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(198139);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(198139);
    }
    return "{}";
  }
  
  private JSONObject fLu()
  {
    AppMethodBeat.i(198133);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.JIs));
      localJSONObject.put("uxinfo", Util.nullAs(this.JIt, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.JIu, ""));
      label70:
      AppMethodBeat.o(198133);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  private JSONObject fLv()
  {
    AppMethodBeat.i(198136);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.JIv);
      localJSONObject.put("clickPosX", this.JIw);
      localJSONObject.put("clickPosY", this.JIx);
      if (this.JIy != null) {
        localJSONObject.put("videoPlayTime", this.JIy.longValue());
      }
      localJSONObject.put("buttonType", this.JIz);
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(198136);
    return localJSONObject;
  }
  
  public final String fJK()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(198143);
    try
    {
      String str = brC();
      AppMethodBeat.o(198143);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(198143);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */