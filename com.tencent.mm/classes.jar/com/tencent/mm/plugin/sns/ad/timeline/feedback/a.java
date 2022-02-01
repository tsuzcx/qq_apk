package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b.b
{
  SnsInfo DqO;
  com.tencent.mm.plugin.sns.data.c DxX;
  String DxY = "zh_CN";
  
  private List<b.d> eXM()
  {
    AppMethodBeat.i(202162);
    ArrayList localArrayList = new ArrayList();
    Object localObject = getAdInfo();
    if ((localObject != null) && (((ADInfo)localObject).adUnlikeInfo != null))
    {
      localObject = ((ADInfo)localObject).adUnlikeInfo.fcH();
      if (com.tencent.mm.plugin.sns.ad.i.c.o((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (ADInfo.c.a)localIterator.next();
          int i = ((ADInfo.c.a)localObject).DWd;
          if ("zh_CN".equals(this.DxY)) {
            localObject = ((ADInfo.c.a)localObject).DWa;
          }
          for (;;)
          {
            localArrayList.add(new b.d(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.DxY)) || ("zh_TW".equals(this.DxY))) {
              localObject = ((ADInfo.c.a)localObject).DWb;
            } else {
              localObject = ((ADInfo.c.a)localObject).DWc;
            }
          }
        }
      }
    }
    AppMethodBeat.o(202162);
    return localArrayList;
  }
  
  private String eXN()
  {
    AppMethodBeat.i(202163);
    Object localObject = getAdXml();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.DxY))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_cn;
        AppMethodBeat.o(202163);
        return localObject;
      }
      if (("zh_TW".equals(this.DxY)) || ("zh_HK".equals(this.DxY)))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_tw;
        AppMethodBeat.o(202163);
        return localObject;
      }
      localObject = ((ADXml)localObject).expandInsideTitle_en;
      AppMethodBeat.o(202163);
      return localObject;
    }
    Log.w("FeedbackDisplayDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(202163);
    return "";
  }
  
  public final s XL(int paramInt)
  {
    AppMethodBeat.i(202160);
    Object localObject = this.DqO;
    com.tencent.mm.plugin.sns.data.c localc = this.DxX;
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(202160);
      return null;
    }
    ADInfo.c.a locala = new ADInfo.c.a();
    if (paramInt == 0) {
      locala.DWd = ADInfo.c.a.DVZ;
    }
    locala.DDs = localc.DDs;
    if (paramInt == 0) {}
    for (locala.DWe = 0L;; locala.DWe = System.currentTimeMillis())
    {
      localObject = new s(((SnsInfo)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(202160);
      return localObject;
    }
  }
  
  public final Map<String, Object> aNQ(String paramString)
  {
    AppMethodBeat.i(202161);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label140;
      }
      Object localObject1 = this.DxX;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.data.c)localObject1).DDr == null) || (((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.EQZ == null)) {
        break label111;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.EQZ;
      if (((ADInfo)localObject1).adUnlikeInfo == null) {
        break label101;
      }
      i = ((ADInfo)localObject1).adUnlikeInfo.DVT;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label93:
        Log.w("FeedbackDisplayDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, eXM());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, eXN());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label334;
      }
      ADInfo localADInfo = getAdInfo();
      Object localObject3 = "";
      localObject2 = localObject3;
      if (localADInfo == null) {
        break label252;
      }
      localObject2 = localObject3;
      if (localADInfo.adUnlikeInfo == null) {
        break label252;
      }
      if (!"zh_CN".equals(this.DxY)) {
        break label284;
      }
      localObject2 = localADInfo.adUnlikeInfo.DVW;
      for (;;)
      {
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = eXN();
        }
        localArrayMap.put(paramString, localObject3);
        break;
        if (("zh_HK".equals(this.DxY)) || ("zh_TW".equals(this.DxY))) {
          localObject2 = localADInfo.adUnlikeInfo.DVX;
        } else {
          localObject2 = localADInfo.adUnlikeInfo.DVY;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label376;
      }
    }
    AppMethodBeat.o(202161);
    return localArrayMap;
    label101:
    Log.e("FeedbackDisplayDataSupplier", "the adUnlikeInfo is null in data tag!");
    break label409;
    label111:
    Log.e("FeedbackDisplayDataSupplier", "the data tag is null!");
    break label409;
    label140:
    label252:
    Object localObject2 = getAdInfo();
    label284:
    label334:
    if (localObject2 != null) {}
    for (boolean bool = ((ADInfo)localObject2).forbidClick;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label93;
      label376:
      if ((!"unlike_tag".equals(paramString)) || (this.DxX == null)) {
        break label93;
      }
      localArrayMap.put(paramString, this.DxX);
      break label93;
      label409:
      i = 7;
      break;
    }
  }
  
  public final boolean eXJ()
  {
    AppMethodBeat.i(202157);
    try
    {
      ADXml localADXml = getAdXml();
      if (localADXml != null)
      {
        if (localADXml.newFeedbackPanel > 0)
        {
          AppMethodBeat.o(202157);
          return true;
        }
        AppMethodBeat.o(202157);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202157);
    }
    return false;
  }
  
  public final boolean eXK()
  {
    AppMethodBeat.i(202158);
    try
    {
      ADInfo localADInfo = getAdInfo();
      if ((localADInfo != null) && (localADInfo.adUnlikeInfo != null))
      {
        boolean bool = com.tencent.mm.plugin.sns.ad.i.c.o(localADInfo.adUnlikeInfo.fcH());
        AppMethodBeat.o(202158);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202158);
    }
    return false;
  }
  
  public final Intent eXL()
  {
    AppMethodBeat.i(202159);
    for (;;)
    {
      try
      {
        localObject1 = getAdXml();
        if ((localObject1 != null) && (((ADXml)localObject1).adFeedbackInfo != null))
        {
          localObject1 = ((ADXml)localObject1).adFeedbackInfo;
          if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(((ADXml.e)localObject1).list))
          {
            Log.e("FeedbackDisplayDataSupplier", "there is no feedback item!");
            localObject1 = "";
            localSnsInfo = this.DqO;
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if ((bool) || (localSnsInfo == null)) {
              continue;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        SnsInfo localSnsInfo;
        Object localObject2;
        String str3;
        String str4;
        AppMethodBeat.o(202159);
        return null;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
        str3 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
        str4 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
        g.aAf();
        localObject2 = i.n((String)localObject1, new String[] { localObject2, str3, str4, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.ayV() }) });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        String str1;
        continue;
        String str2 = "";
        continue;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("useJs", true);
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + r.Jb(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localSnsInfo.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + r.Jb(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localSnsInfo.field_userName);
      AppMethodBeat.o(202159);
      return localObject2;
      localObject1 = ((ADXml.e)localObject1).list.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (ADXml.f)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((ADXml.f)localObject2).url)))
      {
        localObject2 = ((ADXml.f)localObject2).url;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          Log.e("FeedbackDisplayDataSupplier", "there is feedback item, but no url!!!");
          localObject1 = localObject2;
          continue;
          Log.e("FeedbackDisplayDataSupplier", "there is no feedback info!!!");
          str1 = "";
        }
      }
    }
  }
  
  final ADInfo getAdInfo()
  {
    ADInfo localADInfo = null;
    AppMethodBeat.i(202164);
    com.tencent.mm.plugin.sns.data.c localc = this.DxX;
    Object localObject = this.DqO;
    if (localc == null)
    {
      AppMethodBeat.o(202164);
      return null;
    }
    if (localObject != null) {
      localADInfo = ((SnsInfo)localObject).getAdInfo();
    }
    localObject = localADInfo;
    if (localADInfo == null)
    {
      localObject = localADInfo;
      if (localc.DDr != null) {
        localObject = localc.DDr.EQZ;
      }
    }
    AppMethodBeat.o(202164);
    return localObject;
  }
  
  final ADXml getAdXml()
  {
    AppMethodBeat.i(202165);
    com.tencent.mm.plugin.sns.data.c localc = this.DxX;
    SnsInfo localSnsInfo = this.DqO;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (localc.DDr != null) {
        localObject1 = localc.DDr.EQY;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localSnsInfo != null) {
        localObject2 = localSnsInfo.getAdXml();
      }
    }
    AppMethodBeat.o(202165);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */