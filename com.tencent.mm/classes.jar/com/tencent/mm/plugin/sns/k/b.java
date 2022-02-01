package com.tencent.mm.plugin.sns.k;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class b
{
  public static void a(p paramp, int paramInt, y paramy)
  {
    AppMethodBeat.i(179126);
    if (paramp == null)
    {
      ad.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(179126);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramy.wTV);
      localJSONObject2.put("weausername", paramy.xjp);
      localJSONObject2.put("clickSubmitBtn", paramy.xjq);
      localJSONObject2.put("subscribeResult", paramy.xjr);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramy = bt.nullAsNil(paramp.dyg());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramy);
        localJSONObject1.put("snsid", paramp.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramp = localJSONObject1.toString();
        j.ix("timeline_subscription_message", paramp);
        ad.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramp)));
        AppMethodBeat.o(179126);
        return;
      }
      return;
    }
    catch (Exception paramp)
    {
      ad.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramp.toString());
      AppMethodBeat.o(179126);
    }
  }
  
  public static SubscribeMsgRequestDialogUiData fs(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(179125);
    SubscribeMsgRequestDialogUiData localSubscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
    localSubscribeMsgRequestDialogUiData.opType = 1;
    localSubscribeMsgRequestDialogUiData.hFQ = 0;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
      if (localSubscribeMsgTmpItem != null)
      {
        localItemUiData.AL(localSubscribeMsgTmpItem.gIj);
        localItemUiData.hFZ = 1;
        localArrayList.add(localItemUiData);
      }
    }
    k.h(localArrayList, "<set-?>");
    localSubscribeMsgRequestDialogUiData.hFR = localArrayList;
    AppMethodBeat.o(179125);
    return localSubscribeMsgRequestDialogUiData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.b
 * JD-Core Version:    0.7.0.1
 */