package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  implements i.a
{
  private String DyA;
  private String DyB;
  private int DyC;
  private int DyD;
  private int DyE;
  private Long DyF;
  private int DyG;
  private long Dyz;
  private int mScene;
  
  public static i.a a(SnsInfo paramSnsInfo, boolean paramBoolean, View paramView, k paramk)
  {
    int k = 2;
    AppMethodBeat.i(202183);
    if ((paramSnsInfo == null) || (paramView == null))
    {
      AppMethodBeat.o(202183);
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
          AppMethodBeat.o(202183);
          return null;
        }
        if ((paramk != null) && (paramk.source != 0))
        {
          i = 1;
          localObject1 = paramSnsInfo.getAdInfo();
          localObject2 = paramSnsInfo.getAdXml();
          if ((paramSnsInfo != null) && (localObject1 != null) && (localObject2 != null) && (paramView != null)) {
            break;
          }
          AppMethodBeat.o(202183);
          return null;
        }
      }
      catch (Throwable paramSnsInfo)
      {
        AppMethodBeat.o(202183);
        return null;
      }
      i = 0;
    }
    if (!paramSnsInfo.isAd())
    {
      AppMethodBeat.o(202183);
      return null;
    }
    b localb = new b();
    localb.Dyz = paramSnsInfo.field_snsId;
    localb.DyA = i.aNZ(((ADInfo)localObject1).uxInfo);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.DyB = ((ADXml)localObject2).adExtInfo;
      if (!paramBoolean) {
        break label356;
      }
      j = k;
      label184:
      localb.DyG = j;
      if (i == 0) {
        break label362;
      }
      localObject1 = at(paramView, 2131296633);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        localb.DyC = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.DyD = (i / 2 + k);
        localb.DyE = (localObject1[1] + j / 2);
      }
      if ((paramk != null) && (paramSnsInfo.getTimeLine() != null) && (paramSnsInfo.getTimeLine().ContentObj != null) && (paramSnsInfo.getTimeLine().ContentObj.LoU == 15)) {
        localb.DyF = Long.valueOf(paramk.IV(localb.Dyz));
      }
      AppMethodBeat.o(202183);
      return localb;
      j = 1;
      break;
      label356:
      j = 1;
      break label184;
      label362:
      localObject1 = at(paramView, 2131308140);
      paramBoolean = localObject1 instanceof AdFrameLayout;
      if (!paramBoolean) {
        localObject1 = paramView;
      }
    }
  }
  
  public static i.a a(String paramString, View paramView, k paramk)
  {
    AppMethodBeat.i(202182);
    try
    {
      paramString = a(aj.faO().aQm(paramString), true, paramView, paramk);
      AppMethodBeat.o(202182);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202182);
    }
    return null;
  }
  
  private static View at(View paramView, int paramInt)
  {
    AppMethodBeat.i(202187);
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
        AppMethodBeat.o(202187);
        return localView;
      }
    }
  }
  
  private String bie()
  {
    AppMethodBeat.i(202186);
    try
    {
      Object localObject = eXR();
      ((JSONObject)localObject).put("extInfo", eXS());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(202186);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202186);
    }
    return "{}";
  }
  
  private JSONObject eXR()
  {
    AppMethodBeat.i(202184);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.Dyz));
      localJSONObject.put("uxinfo", Util.nullAs(this.DyA, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.DyB, ""));
      label70:
      AppMethodBeat.o(202184);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  private JSONObject eXS()
  {
    AppMethodBeat.i(202185);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.DyC);
      localJSONObject.put("clickPosX", this.DyD);
      localJSONObject.put("clickPosY", this.DyE);
      if (this.DyF != null) {
        localJSONObject.put("videoPlayTime", this.DyF.longValue());
      }
      localJSONObject.put("buttonType", this.DyG);
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(202185);
    return localJSONObject;
  }
  
  public final String eWH()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(202188);
    try
    {
      String str = bie();
      AppMethodBeat.o(202188);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202188);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */