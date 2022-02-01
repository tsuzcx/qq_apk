package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.ad.f.g.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class b
  implements g.a
{
  private int mScene;
  private String zrA;
  private int zrB;
  private int zrC;
  private int zrD;
  private Long zrE;
  private int zrF;
  private long zry;
  private String zrz;
  
  public static g.a a(p paramp, boolean paramBoolean, View paramView, j paramj)
  {
    int k = 2;
    AppMethodBeat.i(219105);
    if ((paramp == null) || (paramView == null))
    {
      AppMethodBeat.o(219105);
      return null;
    }
    int i;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        boolean bool = paramp.Rt(32);
        if (!bool)
        {
          AppMethodBeat.o(219105);
          return null;
        }
        if ((paramj != null) && (paramj.doj != 0))
        {
          i = 1;
          localObject1 = paramp.dVi();
          localObject2 = paramp.dVj();
          if ((paramp != null) && (localObject1 != null) && (localObject2 != null) && (paramView != null)) {
            break;
          }
          AppMethodBeat.o(219105);
          return null;
        }
      }
      catch (Throwable paramp)
      {
        AppMethodBeat.o(219105);
        return null;
      }
      i = 0;
    }
    if (!paramp.Rt(32))
    {
      AppMethodBeat.o(219105);
      return null;
    }
    b localb = new b();
    localb.zry = paramp.field_snsId;
    localb.zrz = i.azd(((a)localObject1).dGD);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.zrA = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zsJ;
      if (!paramBoolean) {
        break label360;
      }
      j = k;
      label188:
      localb.zrF = j;
      if (i == 0) {
        break label366;
      }
      localObject1 = ar(paramView, 2131296556);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        localb.zrB = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.zrC = (i / 2 + k);
        localb.zrD = (localObject1[1] + j / 2);
      }
      if ((paramj != null) && (paramp.ebP() != null) && (paramp.ebP().HUG != null) && (paramp.ebP().HUG.Gtw == 15)) {
        localb.zrE = Long.valueOf(paramj.zQ(localb.zry));
      }
      AppMethodBeat.o(219105);
      return localb;
      j = 1;
      break;
      label360:
      j = 1;
      break label188;
      label366:
      localObject1 = ar(paramView, 2131304989);
      paramBoolean = localObject1 instanceof AdFrameLayout;
      if (!paramBoolean) {
        localObject1 = paramView;
      }
    }
  }
  
  public static g.a a(String paramString, View paramView, j paramj)
  {
    AppMethodBeat.i(219104);
    try
    {
      paramString = a(ah.dXE().aBr(paramString), true, paramView, paramj);
      AppMethodBeat.o(219104);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(219104);
    }
    return null;
  }
  
  private static View ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(219109);
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
        AppMethodBeat.o(219109);
        return localView;
      }
    }
  }
  
  private JSONObject dVn()
  {
    AppMethodBeat.i(219106);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.zry));
      localJSONObject.put("uxinfo", bu.bI(this.zrz, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bu.bI(this.zrA, ""));
      label70:
      AppMethodBeat.o(219106);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  private JSONObject dVp()
  {
    AppMethodBeat.i(219107);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.zrB);
      localJSONObject.put("clickPosX", this.zrC);
      localJSONObject.put("clickPosY", this.zrD);
      if (this.zrE != null) {
        localJSONObject.put("videoPlayTime", this.zrE.longValue());
      }
      localJSONObject.put("buttonType", this.zrF);
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(219107);
    return localJSONObject;
  }
  
  private String dVq()
  {
    AppMethodBeat.i(219108);
    try
    {
      Object localObject = dVn();
      ((JSONObject)localObject).put("extInfo", dVp());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(219108);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219108);
    }
    return "{}";
  }
  
  public final String dVo()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(219110);
    try
    {
      String str = dVq();
      AppMethodBeat.o(219110);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219110);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */