package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.e.g.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class b
  implements g.a
{
  private int mScene;
  private long zaX;
  private String zaY;
  private String zaZ;
  private int zba;
  private int zbb;
  private int zbc;
  private Long zbd;
  private int zbe;
  
  public static g.a a(p paramp, boolean paramBoolean, View paramView, i parami)
  {
    int k = 2;
    AppMethodBeat.i(197639);
    if ((paramp == null) || (paramView == null))
    {
      AppMethodBeat.o(197639);
      return null;
    }
    int i;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        boolean bool = paramp.QM(32);
        if (!bool)
        {
          AppMethodBeat.o(197639);
          return null;
        }
        if ((parami != null) && (parami.dnh != 0))
        {
          i = 1;
          localObject1 = paramp.dRK();
          localObject2 = paramp.dRL();
          if ((paramp != null) && (localObject1 != null) && (localObject2 != null) && (paramView != null)) {
            break;
          }
          AppMethodBeat.o(197639);
          return null;
        }
      }
      catch (Throwable paramp)
      {
        AppMethodBeat.o(197639);
        return null;
      }
      i = 0;
    }
    if (!paramp.QM(32))
    {
      AppMethodBeat.o(197639);
      return null;
    }
    b localb = new b();
    localb.zaX = paramp.field_snsId;
    localb.zaY = h.axM(((a)localObject1).dFy);
    int j;
    if (i != 0)
    {
      j = 2;
      localb.mScene = j;
      localb.zaZ = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zeg;
      if (!paramBoolean) {
        break label360;
      }
      j = k;
      label188:
      localb.zbe = j;
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
        localb.zba = localObject2[1];
      }
      if (paramView != null)
      {
        localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        i = paramView.getWidth();
        j = paramView.getHeight();
        k = localObject1[0];
        localb.zbb = (i / 2 + k);
        localb.zbc = (localObject1[1] + j / 2);
      }
      if ((parami != null) && (paramp.dYl() != null) && (paramp.dYl().HAT != null) && (paramp.dYl().HAT.GaP == 15)) {
        localb.zbd = Long.valueOf(parami.zr(localb.zaX));
      }
      AppMethodBeat.o(197639);
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
  
  public static g.a a(String paramString, View paramView, i parami)
  {
    AppMethodBeat.i(197638);
    try
    {
      paramString = a(ag.dUe().aAa(paramString), true, paramView, parami);
      AppMethodBeat.o(197638);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(197638);
    }
    return null;
  }
  
  private static View ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(197643);
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
        AppMethodBeat.o(197643);
        return localView;
      }
    }
  }
  
  private JSONObject dRP()
  {
    AppMethodBeat.i(197640);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.zaX));
      localJSONObject.put("uxinfo", bt.bI(this.zaY, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bt.bI(this.zaZ, ""));
      label70:
      AppMethodBeat.o(197640);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  private JSONObject dRR()
  {
    AppMethodBeat.i(197641);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adOffSetTop", this.zba);
      localJSONObject.put("clickPosX", this.zbb);
      localJSONObject.put("clickPosY", this.zbc);
      if (this.zbd != null) {
        localJSONObject.put("videoPlayTime", this.zbd.longValue());
      }
      localJSONObject.put("buttonType", this.zbe);
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    AppMethodBeat.o(197641);
    return localJSONObject;
  }
  
  private String dRS()
  {
    AppMethodBeat.i(197642);
    try
    {
      Object localObject = dRP();
      ((JSONObject)localObject).put("extInfo", dRR());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(197642);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197642);
    }
    return "{}";
  }
  
  public final String dRQ()
  {
    return "timeline_ad_feedback_and_sns_button_click";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(197644);
    try
    {
      String str = dRS();
      AppMethodBeat.o(197644);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197644);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b
 * JD-Core Version:    0.7.0.1
 */