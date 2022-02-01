package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bt;
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
  int JCO = 0;
  e JHR;
  String JHS = "zh_CN";
  SnsInfo Jws;
  
  private Intent fLn()
  {
    AppMethodBeat.i(248735);
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
      SnsInfo localSnsInfo = this.Jws;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (localSnsInfo == null)) {
        break;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
        String str2 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
        String str3 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
        h.aHE();
        localObject2 = i.m((String)localObject1, new String[] { localObject2, str2, str3, String.format("uin=%s", new Object[] { b.aGq() }) });
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
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + t.Qu(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localSnsInfo.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + t.Qu(localSnsInfo.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localSnsInfo.field_userName);
      AppMethodBeat.o(248735);
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
    AppMethodBeat.o(248735);
    return null;
  }
  
  private List<c> fLp()
  {
    AppMethodBeat.i(248753);
    ArrayList localArrayList = new ArrayList();
    Object localObject = getAdInfo();
    if ((localObject != null) && (((ADInfo)localObject).adUnlikeInfo != null))
    {
      localObject = ((ADInfo)localObject).adUnlikeInfo.fQA();
      if (d.n((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (ADInfo.c.a)localIterator.next();
          int i = ((ADInfo.c.a)localObject).Kjn;
          if ("zh_CN".equals(this.JHS)) {
            localObject = ((ADInfo.c.a)localObject).Kjk;
          }
          for (;;)
          {
            localArrayList.add(new c(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.JHS)) || ("zh_TW".equals(this.JHS))) {
              localObject = ((ADInfo.c.a)localObject).Kjl;
            } else {
              localObject = ((ADInfo.c.a)localObject).Kjm;
            }
          }
        }
      }
    }
    AppMethodBeat.o(248753);
    return localArrayList;
  }
  
  private String fLq()
  {
    AppMethodBeat.i(248757);
    Object localObject = getAdXml();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.JHS))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_cn;
        AppMethodBeat.o(248757);
        return localObject;
      }
      if (("zh_TW".equals(this.JHS)) || ("zh_HK".equals(this.JHS)))
      {
        localObject = ((ADXml)localObject).expandInsideTitle_tw;
        AppMethodBeat.o(248757);
        return localObject;
      }
      localObject = ((ADXml)localObject).expandInsideTitle_en;
      AppMethodBeat.o(248757);
      return localObject;
    }
    Log.w("FeedbackDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(248757);
    return "";
  }
  
  public final Map<String, Object> aYG(String paramString)
  {
    AppMethodBeat.i(248749);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label146;
      }
      Object localObject1 = this.JHR;
      if ((localObject1 == null) || (((e)localObject1).JPW == null) || (((e)localObject1).JPW.LeY == null)) {
        break label115;
      }
      localObject1 = ((e)localObject1).JPW.LeY;
      if (((ADInfo)localObject1).adUnlikeInfo == null) {
        break label104;
      }
      i = ((ADInfo)localObject1).adUnlikeInfo.Kjd;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label95:
        Log.w("FeedbackDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, fLp());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, fLq());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label343;
      }
      ADInfo localADInfo = getAdInfo();
      Object localObject3 = "";
      localObject2 = localObject3;
      if (localADInfo == null) {
        break label261;
      }
      localObject2 = localObject3;
      if (localADInfo.adUnlikeInfo == null) {
        break label261;
      }
      if (!"zh_CN".equals(this.JHS)) {
        break label293;
      }
      localObject2 = localADInfo.adUnlikeInfo.Kjg;
      for (;;)
      {
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = fLq();
        }
        localArrayMap.put(paramString, localObject3);
        break;
        if (("zh_HK".equals(this.JHS)) || ("zh_TW".equals(this.JHS))) {
          localObject2 = localADInfo.adUnlikeInfo.Kjh;
        } else {
          localObject2 = localADInfo.adUnlikeInfo.Kji;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label386;
      }
    }
    AppMethodBeat.o(248749);
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
    Object localObject2 = getAdInfo();
    label261:
    if (localObject2 != null) {}
    for (boolean bool = ((ADInfo)localObject2).forbidClick;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label95;
      label386:
      if ("unlike_tag".equals(paramString))
      {
        if (this.JHR == null) {
          break label95;
        }
        localArrayMap.put(paramString, this.JHR);
        break label95;
      }
      if (!"complaint_content".equals(paramString)) {
        break label95;
      }
      localObject2 = getAdXml();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((ADXml)localObject2).feedbackWording))) {}
      for (localObject2 = ((ADXml)localObject2).feedbackWording;; localObject2 = "")
      {
        localArrayMap.put(paramString, localObject2);
        break;
      }
      label479:
      i = 7;
      break;
    }
  }
  
  public final s aeQ(int paramInt)
  {
    AppMethodBeat.i(248744);
    Object localObject = this.Jws;
    e locale = this.JHR;
    if ((localObject == null) || (locale == null))
    {
      AppMethodBeat.o(248744);
      return null;
    }
    ADInfo.c.a locala = new ADInfo.c.a();
    locala.Kjo = 1;
    if (paramInt == 0)
    {
      locala.Kjp.add(Integer.valueOf(ADInfo.c.a.Kjj));
      locala.JPX = locale.JPX;
      if (paramInt != 0) {
        break label125;
      }
    }
    label125:
    for (locala.Kjq = 0L;; locala.Kjq = System.currentTimeMillis())
    {
      localObject = new s(((SnsInfo)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(248744);
      return localObject;
      locala.Kjp.add(Integer.valueOf(0));
      break;
    }
  }
  
  public final boolean fLl()
  {
    AppMethodBeat.i(248730);
    try
    {
      ADXml localADXml = getAdXml();
      if (localADXml != null)
      {
        if (localADXml.newFeedbackPanel > 0)
        {
          AppMethodBeat.o(248730);
          return true;
        }
        AppMethodBeat.o(248730);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(248730);
    }
    return false;
  }
  
  public final boolean fLm()
  {
    AppMethodBeat.i(248733);
    try
    {
      ADInfo localADInfo = getAdInfo();
      if ((localADInfo != null) && (localADInfo.adUnlikeInfo != null))
      {
        boolean bool = d.n(localADInfo.adUnlikeInfo.fQA());
        AppMethodBeat.o(248733);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(248733);
    }
    return false;
  }
  
  public final Intent fLo()
  {
    AppMethodBeat.i(248740);
    for (;;)
    {
      try
      {
        ADXml localADXml = getAdXml();
        Object localObject1 = getAdInfo();
        Object localObject3 = this.Jws;
        if ((localADXml == null) || (TextUtils.isEmpty(localADXml.feedbackWeAppUsername)) || (TextUtils.isEmpty(localADXml.feedbackWeAppPath)) || (localObject3 == null)) {
          break label356;
        }
        String str1 = t.w((SnsInfo)localObject3);
        String str2 = Util.nullAsNil(((SnsInfo)localObject3).getAid());
        String str3 = Util.nullAsNil(((SnsInfo)localObject3).getTraceid());
        h.aHE();
        String str4 = Util.nullAsNil(b.aGq());
        localObject3 = new Intent();
        String str5 = localADXml.feedbackWeAppPath;
        if (localObject1 != null)
        {
          localObject1 = ((ADInfo)localObject1).uxInfo;
          ((Intent)localObject3).putExtra("appUserName", localADXml.feedbackWeAppUsername);
          i.n(str5, new String[] { "snsid=".concat(String.valueOf(str1)), "aid=".concat(String.valueOf(str2)), "traceid=".concat(String.valueOf(str3)), "uin=".concat(String.valueOf(str4)) });
          ((Intent)localObject3).putExtra("appPagePath", str5);
          ((Intent)localObject3).putExtra("aId", str2);
          ((Intent)localObject3).putExtra("sceneNote", str1 + ":" + (String)localObject1 + ":" + aj.fOo() + ":" + System.currentTimeMillis());
          ((Intent)localObject3).putExtra("uxInfo", (String)localObject1);
          if (this.JCO != 0) {
            break label349;
          }
          i = 1045;
          ((Intent)localObject3).putExtra("scene", i);
          localObject1 = localObject3;
          if (localObject1 != null)
          {
            ((Intent)localObject1).putExtra("complaint_weapp", true);
            AppMethodBeat.o(248740);
            return localObject1;
          }
        }
        else
        {
          localObject1 = "";
          continue;
        }
        localObject1 = fLn();
        AppMethodBeat.o(248740);
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(248740);
        return null;
      }
      label349:
      int i = 1046;
      continue;
      label356:
      Object localObject2 = null;
    }
  }
  
  final ADInfo getAdInfo()
  {
    ADInfo localADInfo = null;
    AppMethodBeat.i(248759);
    e locale = this.JHR;
    SnsInfo localSnsInfo = this.Jws;
    if (locale == null)
    {
      AppMethodBeat.o(248759);
      return null;
    }
    if (locale.JPW != null) {
      localADInfo = locale.JPW.LeY;
    }
    if (localSnsInfo != null) {
      localADInfo = localSnsInfo.getAdInfo(this.JCO);
    }
    AppMethodBeat.o(248759);
    return localADInfo;
  }
  
  final ADXml getAdXml()
  {
    AppMethodBeat.i(248762);
    e locale = this.JHR;
    SnsInfo localSnsInfo = this.Jws;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (locale != null)
    {
      localObject1 = localObject2;
      if (locale.JPW != null) {
        localObject1 = locale.JPW.LeX;
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
    AppMethodBeat.o(248762);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */