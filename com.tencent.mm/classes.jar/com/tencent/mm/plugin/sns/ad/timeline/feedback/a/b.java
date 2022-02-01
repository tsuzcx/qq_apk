package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.j.j.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  implements j.a
{
  private Long PZA;
  private int PZB;
  private long PZu;
  private String PZv;
  private String PZw;
  private int PZx;
  private int PZy;
  private int PZz;
  private int mScene;
  
  public static j.a a(SnsInfo paramSnsInfo, boolean paramBoolean, View paramView, l paraml)
  {
    int k = 2;
    AppMethodBeat.i(310994);
    if ((paramSnsInfo == null) || (paramView == null))
    {
      AppMethodBeat.o(310994);
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
          AppMethodBeat.o(310994);
          return null;
        }
        if ((paraml != null) && (paraml.source != 0))
        {
          i = 1;
          localObject1 = paramSnsInfo.getAdInfo();
          localObject2 = paramSnsInfo.getAdXml();
          if ((paramSnsInfo != null) && (localObject1 != null) && (localObject2 != null)) {
            if (paramView != null) {
              break;
            }
          }
        }
      }
      finally
      {
        AppMethodBeat.o(310994);
        return null;
      }
      i = 0;
    }
    if (!paramSnsInfo.isAd())
    {
      AppMethodBeat.o(310994);
      return null;
    }
    b localb = new b();
    localb.PZu = paramSnsInfo.field_snsId;
    localb.PZv = k.aXd(((ADInfo)localObject1).uxInfo);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.PZw = ((ADXml)localObject2).adExtInfo;
      if (!paramBoolean) {
        break label357;
      }
      j = k;
      label184:
      localb.PZB = j;
      if (i == 0) {
        break label363;
      }
      localObject1 = aT(paramView, b.f.album_comment_list);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        localb.PZx = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.PZy = (i / 2 + k);
        localb.PZz = (localObject1[1] + j / 2);
      }
      if ((paraml != null) && (paramSnsInfo.getTimeLine() != null) && (paramSnsInfo.getTimeLine().ContentObj != null) && (paramSnsInfo.getTimeLine().ContentObj.Zpq == 15)) {
        localb.PZA = Long.valueOf(paraml.uv(localb.PZu));
      }
      AppMethodBeat.o(310994);
      return localb;
      j = 1;
      break;
      label357:
      j = 1;
      break label184;
      label363:
      localObject1 = aT(paramView, b.f.sns_item_root);
      paramBoolean = localObject1 instanceof AdFrameLayout;
      if (!paramBoolean) {
        localObject1 = paramView;
      }
    }
  }
  
  public static j.a a(String paramString, View paramView, l paraml)
  {
    AppMethodBeat.i(310983);
    try
    {
      paramString = a(al.hgB().aZL(paramString), true, paramView, paraml);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(310983);
    }
    return null;
  }
  
  private static View aT(View paramView, int paramInt)
  {
    AppMethodBeat.i(311028);
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
        AppMethodBeat.o(311028);
        return localView;
      }
    }
  }
  
  private String bPi()
  {
    AppMethodBeat.i(311017);
    try
    {
      Object localObject1 = hbM();
      ((JSONObject)localObject1).put("extInfo", hbN());
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(311017);
    }
    return "{}";
  }
  
  private JSONObject hbM()
  {
    AppMethodBeat.i(311001);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.PZu));
      localJSONObject.put("uxinfo", Util.nullAs(this.PZv, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.PZw, ""));
      label70:
      AppMethodBeat.o(311001);
      return localJSONObject;
    }
    finally
    {
      break label70;
    }
  }
  
  private JSONObject hbN()
  {
    AppMethodBeat.i(311011);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.PZx);
      localJSONObject.put("clickPosX", this.PZy);
      localJSONObject.put("clickPosY", this.PZz);
      if (this.PZA != null) {
        localJSONObject.put("videoPlayTime", this.PZA.longValue());
      }
      localJSONObject.put("buttonType", this.PZB);
    }
    finally
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(311011);
    return localJSONObject;
  }
  
  public final String gZE()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(311040);
    try
    {
      String str = bPi();
      return str;
    }
    finally
    {
      AppMethodBeat.o(311040);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */