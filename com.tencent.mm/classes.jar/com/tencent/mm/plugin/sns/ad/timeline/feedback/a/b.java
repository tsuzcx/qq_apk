package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.e.d.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class b
  implements d.a
{
  private int mScene;
  private long xLI;
  private String xLJ;
  private String xLK;
  private int xLL;
  private int xLM;
  private int xLN;
  private Long xLO;
  private int xLP;
  
  public static d.a a(p paramp, boolean paramBoolean, View paramView, i parami)
  {
    int k = 2;
    AppMethodBeat.i(199993);
    if ((paramp == null) || (paramView == null))
    {
      AppMethodBeat.o(199993);
      return null;
    }
    int i;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        boolean bool = paramp.Pe(32);
        if (!bool)
        {
          AppMethodBeat.o(199993);
          return null;
        }
        if ((parami != null) && (parami.dbL != 0))
        {
          i = 1;
          localObject1 = paramp.dFQ();
          localObject2 = paramp.dFR();
          if ((paramp != null) && (localObject1 != null) && (localObject2 != null) && (paramView != null)) {
            break;
          }
          AppMethodBeat.o(199993);
          return null;
        }
      }
      catch (Throwable paramp)
      {
        AppMethodBeat.o(199993);
        return null;
      }
      i = 0;
    }
    if (!paramp.Pe(32))
    {
      AppMethodBeat.o(199993);
      return null;
    }
    b localb = new b();
    localb.xLI = paramp.field_snsId;
    localb.xLJ = h.asK(((a)localObject1).dtx);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.xLK = ((com.tencent.mm.plugin.sns.storage.b)localObject2).xOm;
      if (!paramBoolean) {
        break label360;
      }
      j = k;
      label188:
      localb.xLP = j;
      if (i == 0) {
        break label366;
      }
      localObject1 = aq(paramView, 2131296556);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        localb.xLL = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.xLM = (i / 2 + k);
        localb.xLN = (localObject1[1] + j / 2);
      }
      if ((parami != null) && (paramp.dLV() != null) && (paramp.dLV().FQo != null) && (paramp.dLV().FQo.Ety == 15)) {
        localb.xLO = Long.valueOf(parami.wR(localb.xLI));
      }
      AppMethodBeat.o(199993);
      return localb;
      j = 1;
      break;
      label360:
      j = 1;
      break label188;
      label366:
      localObject1 = aq(paramView, 2131304989);
      paramBoolean = localObject1 instanceof AdFrameLayout;
      if (!paramBoolean) {
        localObject1 = paramView;
      }
    }
  }
  
  public static d.a a(String paramString, View paramView, i parami)
  {
    AppMethodBeat.i(199992);
    try
    {
      paramString = a(af.dHR().auT(paramString), true, paramView, parami);
      AppMethodBeat.o(199992);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(199992);
    }
    return null;
  }
  
  private static View aq(View paramView, int paramInt)
  {
    AppMethodBeat.i(199997);
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
        AppMethodBeat.o(199997);
        return localView;
      }
    }
  }
  
  private JSONObject dFV()
  {
    AppMethodBeat.i(199994);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.xLI));
      localJSONObject.put("uxinfo", bs.bG(this.xLJ, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bs.bG(this.xLK, ""));
      label70:
      AppMethodBeat.o(199994);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  private JSONObject dFX()
  {
    AppMethodBeat.i(199995);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.xLL);
      localJSONObject.put("clickPosX", this.xLM);
      localJSONObject.put("clickPosY", this.xLN);
      if (this.xLO != null) {
        localJSONObject.put("videoPlayTime", this.xLO.longValue());
      }
      localJSONObject.put("buttonType", this.xLP);
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(199995);
    return localJSONObject;
  }
  
  private String dFY()
  {
    AppMethodBeat.i(199996);
    try
    {
      Object localObject = dFV();
      ((JSONObject)localObject).put("extInfo", dFX());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(199996);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(199996);
    }
    return "{}";
  }
  
  public final String dFW()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(199998);
    try
    {
      String str = dFY();
      AppMethodBeat.o(199998);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(199998);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */