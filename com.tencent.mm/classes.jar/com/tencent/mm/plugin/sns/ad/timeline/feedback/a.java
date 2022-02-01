package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements b.b
{
  SnsInfo PJQ;
  e PYR;
  String PYS = "zh_CN";
  int xOq = 0;
  
  private Intent hbF()
  {
    AppMethodBeat.i(311006);
    Object localObject1 = getAdXml();
    if ((localObject1 != null) && (((ADXml)localObject1).adFeedbackInfo != null))
    {
      localObject1 = ((ADXml)localObject1).adFeedbackInfo;
      if (d.isEmpty(((ADXml.e)localObject1).list))
      {
        Log.e("FeedbackDataSupplier", "there is no feedback item!");
        localObject1 = "";
      }
    }
    for (;;)
    {
      SnsInfo localSnsInfo = this.PJQ;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (localSnsInfo == null)) {
        break;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
        String str2 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
        String str3 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
        h.baC();
        localObject2 = l.n((String)localObject1, new String[] { localObject2, str2, str3, String.format("uin=%s", new Object[] { b.aZs() }) });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          String str1 = "";
        }
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("useJs", true);
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + t.uA(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localSnsInfo.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + t.uA(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localSnsInfo.field_userName);
      AppMethodBeat.o(311006);
      return localObject2;
      localObject1 = ((ADXml.e)localObject1).list.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ADXml.f)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (TextUtils.isEmpty(((ADXml.f)localObject2).url)));
      localObject2 = ((ADXml.f)localObject2).url;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Log.e("FeedbackDataSupplier", "there is feedback item, but no url!!!");
        localObject1 = localObject2;
        continue;
        Log.e("FeedbackDataSupplier", "there is no feedback info!!!");
        localObject1 = "";
      }
    }
    AppMethodBeat.o(311006);
    return null;
  }
  
  private List<c> hbH()
  {
    AppMethodBeat.i(311015);
    ArrayList localArrayList = new ArrayList();
    Object localObject = getAdInfo();
    if ((localObject != null) && (((ADInfo)localObject).adUnlikeInfo != null))
    {
      localObject = ((ADInfo)localObject).adUnlikeInfo.hiy();
      if (d.B((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (ADInfo.c.a)localIterator.next();
          int i = ((ADInfo.c.a)localObject).QHk;
          if ("zh_CN".equals(this.PYS)) {
            localObject = ((ADInfo.c.a)localObject).QHh;
          }
          for (;;)
          {
            localArrayList.add(new c(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.PYS)) || ("zh_TW".equals(this.PYS))) {
              localObject = ((ADInfo.c.a)localObject).QHi;
            } else {
              localObject = ((ADInfo.c.a)localObject).QHj;
            }
          }
        }
      }
    }
    AppMethodBeat.o(311015);
    return localArrayList;
  }
  
  private String hbI()
  {
    AppMethodBeat.i(311027);
    Object localObject = getAdXml();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.PYS))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_cn;
        AppMethodBeat.o(311027);
        return localObject;
      }
      if (("zh_TW".equals(this.PYS)) || ("zh_HK".equals(this.PYS)))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_tw;
        AppMethodBeat.o(311027);
        return localObject;
      }
      localObject = ((ADXml)localObject).expandInsideTitle_en;
      AppMethodBeat.o(311027);
      return localObject;
    }
    Log.w("FeedbackDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(311027);
    return "";
  }
  
  public final Map<String, Object> aWK(String paramString)
  {
    AppMethodBeat.i(311074);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label146;
      }
      Object localObject1 = this.PYR;
      if ((localObject1 == null) || (((e)localObject1).QmD == null) || (((e)localObject1).QmD.RFi == null)) {
        break label115;
      }
      localObject1 = ((e)localObject1).QmD.RFi;
      if (((ADInfo)localObject1).adUnlikeInfo == null) {
        break label104;
      }
      i = ((ADInfo)localObject1).adUnlikeInfo.QHa;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    finally
    {
      for (;;)
      {
        label95:
        Log.w("FeedbackDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, hbH());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, hbI());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label343;
      }
      ADInfo localADInfo = getAdInfo();
      Object localObject4 = "";
      localObject3 = localObject4;
      if (localADInfo == null) {
        break label261;
      }
      localObject3 = localObject4;
      if (localADInfo.adUnlikeInfo == null) {
        break label261;
      }
      if (!"zh_CN".equals(this.PYS)) {
        break label293;
      }
      localObject3 = localADInfo.adUnlikeInfo.QHd;
      for (;;)
      {
        localObject4 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject4 = hbI();
        }
        localArrayMap.put(paramString, localObject4);
        break;
        if (("zh_HK".equals(this.PYS)) || ("zh_TW".equals(this.PYS))) {
          localObject3 = localADInfo.adUnlikeInfo.QHe;
        } else {
          localObject3 = localADInfo.adUnlikeInfo.QHf;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label386;
      }
    }
    AppMethodBeat.o(311074);
    return localArrayMap;
    label104:
    Log.e("FeedbackDataSupplier", "the adUnlikeInfo is null in data tag!");
    break label479;
    label115:
    Log.e("FeedbackDataSupplier", "the data tag is null!");
    break label479;
    label146:
    label293:
    label343:
    Object localObject3 = getAdInfo();
    label261:
    if (localObject3 != null) {}
    for (boolean bool = ((ADInfo)localObject3).forbidClick;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label95;
      label386:
      if ("unlike_tag".equals(paramString))
      {
        if (this.PYR == null) {
          break label95;
        }
        localArrayMap.put(paramString, this.PYR);
        break label95;
      }
      if (!"complaint_content".equals(paramString)) {
        break label95;
      }
      localObject3 = getAdXml();
      if ((localObject3 != null) && (!TextUtils.isEmpty(((ADXml)localObject3).feedbackWording))) {}
      for (localObject3 = ((ADXml)localObject3).feedbackWording;; localObject3 = "")
      {
        localArrayMap.put(paramString, localObject3);
        break;
      }
      label479:
      i = 7;
      break;
    }
  }
  
  public final s ajy(int paramInt)
  {
    AppMethodBeat.i(311061);
    Object localObject = this.PJQ;
    e locale = this.PYR;
    if ((localObject == null) || (locale == null))
    {
      AppMethodBeat.o(311061);
      return null;
    }
    ADInfo.c.a locala = new ADInfo.c.a();
    locala.QHl = 1;
    if (paramInt == 0)
    {
      locala.QHm.add(Integer.valueOf(ADInfo.c.a.QHg));
      locala.QmE = locale.QmE;
      if (paramInt != 0) {
        break label125;
      }
    }
    label125:
    for (locala.QHn = 0L;; locala.QHn = System.currentTimeMillis())
    {
      localObject = new s(((SnsInfo)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(311061);
      return localObject;
      locala.QHm.add(Integer.valueOf(0));
      break;
    }
  }
  
  final ADInfo getAdInfo()
  {
    ADInfo localADInfo = null;
    AppMethodBeat.i(311083);
    e locale = this.PYR;
    SnsInfo localSnsInfo = this.PJQ;
    if (locale == null)
    {
      AppMethodBeat.o(311083);
      return null;
    }
    if (locale.QmD != null) {
      localADInfo = locale.QmD.RFi;
    }
    if (localSnsInfo != null) {
      localADInfo = localSnsInfo.getAdInfo(this.xOq);
    }
    AppMethodBeat.o(311083);
    return localADInfo;
  }
  
  final ADXml getAdXml()
  {
    AppMethodBeat.i(311090);
    e locale = this.PYR;
    SnsInfo localSnsInfo = this.PJQ;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (locale != null)
    {
      localObject1 = localObject2;
      if (locale.QmD != null) {
        localObject1 = locale.QmD.RFh;
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
    AppMethodBeat.o(311090);
    return localObject2;
  }
  
  public final boolean hbD()
  {
    AppMethodBeat.i(311036);
    try
    {
      ADXml localADXml = getAdXml();
      if (localADXml != null) {
        return localADXml.newFeedbackPanel > 0;
      }
    }
    finally
    {
      AppMethodBeat.o(311036);
    }
    return false;
  }
  
  public final boolean hbE()
  {
    AppMethodBeat.i(311042);
    try
    {
      ADInfo localADInfo = getAdInfo();
      if ((localADInfo != null) && (localADInfo.adUnlikeInfo != null))
      {
        boolean bool = d.B(localADInfo.adUnlikeInfo.hiy());
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(311042);
    }
    return false;
  }
  
  public final Intent hbG()
  {
    AppMethodBeat.i(311056);
    for (;;)
    {
      try
      {
        Object localObject4 = getAdXml();
        ADInfo localADInfo = getAdInfo();
        localObject1 = this.PJQ;
        if ((localObject4 == null) || (TextUtils.isEmpty(((ADXml)localObject4).feedbackWeAppUsername)) || (TextUtils.isEmpty(((ADXml)localObject4).feedbackWeAppPath)) || (localObject1 == null)) {
          break label379;
        }
        String str2 = t.x((SnsInfo)localObject1);
        String str3 = Util.nullAsNil(((SnsInfo)localObject1).getAid());
        String str4 = Util.nullAsNil(((SnsInfo)localObject1).getTraceid());
        h.baC();
        String str5 = Util.nullAsNil(b.aZs());
        Intent localIntent = new Intent();
        String str1 = ((ADXml)localObject4).feedbackWeAppPath;
        if (localADInfo != null)
        {
          localObject1 = localADInfo.uxInfo;
          localIntent.putExtra("appUserName", ((ADXml)localObject4).feedbackWeAppUsername);
          l.o(str1, new String[] { "snsid=".concat(String.valueOf(str2)), "aid=".concat(String.valueOf(str3)), "traceid=".concat(String.valueOf(str4)), "uin=".concat(String.valueOf(str5)) });
          localObject4 = str1;
          if (localADInfo != null) {
            localObject4 = m.cW(str1, localADInfo.addClickTimeToWeAppPath);
          }
          localIntent.putExtra("appPagePath", (String)localObject4);
          localIntent.putExtra("aId", str3);
          localIntent.putExtra("sceneNote", str2 + ":" + (String)localObject1 + ":" + al.hgg() + ":" + System.currentTimeMillis());
          localIntent.putExtra("uxInfo", (String)localObject1);
          if (this.xOq != 0) {
            break label372;
          }
          i = 1045;
          localIntent.putExtra("scene", i);
          localObject1 = localIntent;
          if (localObject1 != null)
          {
            ((Intent)localObject1).putExtra("complaint_weapp", true);
            AppMethodBeat.o(311056);
            return localObject1;
          }
        }
        else
        {
          localObject1 = "";
          continue;
        }
        localObject1 = hbF();
      }
      finally
      {
        Object localObject1;
        AppMethodBeat.o(311056);
        return null;
      }
      label372:
      int i = 1046;
      continue;
      label379:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */