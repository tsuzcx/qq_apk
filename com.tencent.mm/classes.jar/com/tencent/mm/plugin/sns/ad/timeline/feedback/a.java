package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b.b
{
  p yVM;
  com.tencent.mm.plugin.sns.data.b zav;
  String zaw = "zh_CN";
  
  private List<b.d> dRI()
  {
    AppMethodBeat.i(197618);
    ArrayList localArrayList = new ArrayList();
    Object localObject = dRK();
    if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject).zuT != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zuT.dVR();
      if (com.tencent.mm.plugin.sns.ad.e.b.m((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (a.c.a)localIterator.next();
          int i = ((a.c.a)localObject).zvp;
          if ("zh_CN".equals(this.zaw)) {
            localObject = ((a.c.a)localObject).zvm;
          }
          for (;;)
          {
            localArrayList.add(new b.d(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.zaw)) || ("zh_TW".equals(this.zaw))) {
              localObject = ((a.c.a)localObject).zvn;
            } else {
              localObject = ((a.c.a)localObject).zvo;
            }
          }
        }
      }
    }
    AppMethodBeat.o(197618);
    return localArrayList;
  }
  
  private String dRJ()
  {
    AppMethodBeat.i(197619);
    Object localObject = dRL();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.zaw))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zvN;
        AppMethodBeat.o(197619);
        return localObject;
      }
      if (("zh_TW".equals(this.zaw)) || ("zh_HK".equals(this.zaw)))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zvP;
        AppMethodBeat.o(197619);
        return localObject;
      }
      localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zvO;
      AppMethodBeat.o(197619);
      return localObject;
    }
    ad.w("FeedbackDisplayDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(197619);
    return "";
  }
  
  public final com.tencent.mm.plugin.sns.model.q Pz(int paramInt)
  {
    AppMethodBeat.i(197616);
    Object localObject = this.yVM;
    com.tencent.mm.plugin.sns.data.b localb = this.zav;
    if ((localObject == null) || (localb == null))
    {
      AppMethodBeat.o(197616);
      return null;
    }
    a.c.a locala = new a.c.a();
    if (paramInt == 0) {
      locala.zvp = a.c.a.zvl;
    }
    locala.zcr = localb.zcr;
    if (paramInt == 0) {}
    for (locala.zvq = 0L;; locala.zvq = System.currentTimeMillis())
    {
      localObject = new com.tencent.mm.plugin.sns.model.q(((p)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(197616);
      return localObject;
    }
  }
  
  public final Map<String, Object> axE(String paramString)
  {
    AppMethodBeat.i(197617);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label140;
      }
      Object localObject1 = this.zav;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).zcq == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.ApS == null)) {
        break label111;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.ApS;
      if (((com.tencent.mm.plugin.sns.storage.a)localObject1).zuT == null) {
        break label101;
      }
      i = ((com.tencent.mm.plugin.sns.storage.a)localObject1).zuT.zvf;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label93:
        ad.w("FeedbackDisplayDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, dRI());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, dRJ());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label334;
      }
      com.tencent.mm.plugin.sns.storage.a locala = dRK();
      Object localObject3 = "";
      localObject2 = localObject3;
      if (locala == null) {
        break label252;
      }
      localObject2 = localObject3;
      if (locala.zuT == null) {
        break label252;
      }
      if (!"zh_CN".equals(this.zaw)) {
        break label284;
      }
      localObject2 = locala.zuT.zvi;
      for (;;)
      {
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = dRJ();
        }
        localArrayMap.put(paramString, localObject3);
        break;
        if (("zh_HK".equals(this.zaw)) || ("zh_TW".equals(this.zaw))) {
          localObject2 = locala.zuT.zvj;
        } else {
          localObject2 = locala.zuT.zvk;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label376;
      }
    }
    AppMethodBeat.o(197617);
    return localArrayMap;
    label101:
    ad.e("FeedbackDisplayDataSupplier", "the adUnlikeInfo is null in data tag!");
    break label409;
    label111:
    ad.e("FeedbackDisplayDataSupplier", "the data tag is null!");
    break label409;
    label140:
    label252:
    Object localObject2 = dRK();
    label284:
    label334:
    if (localObject2 != null) {}
    for (boolean bool = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zuX;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label93;
      label376:
      if ((!"unlike_tag".equals(paramString)) || (this.zav == null)) {
        break label93;
      }
      localArrayMap.put(paramString, this.zav);
      break label93;
      label409:
      i = 7;
      break;
    }
  }
  
  public final boolean dRF()
  {
    AppMethodBeat.i(197613);
    try
    {
      com.tencent.mm.plugin.sns.storage.b localb = dRL();
      if (localb != null)
      {
        if (localb.zwB > 0)
        {
          AppMethodBeat.o(197613);
          return true;
        }
        AppMethodBeat.o(197613);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197613);
    }
    return false;
  }
  
  public final boolean dRG()
  {
    AppMethodBeat.i(197614);
    try
    {
      com.tencent.mm.plugin.sns.storage.a locala = dRK();
      if ((locala != null) && (locala.zuT != null))
      {
        boolean bool = com.tencent.mm.plugin.sns.ad.e.b.m(locala.zuT.dVR());
        AppMethodBeat.o(197614);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197614);
    }
    return false;
  }
  
  public final Intent dRH()
  {
    AppMethodBeat.i(197615);
    for (;;)
    {
      try
      {
        localObject1 = dRL();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zwr != null))
        {
          localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).zwr;
          if (com.tencent.mm.plugin.sns.ad.e.b.isEmpty(((b.e)localObject1).list))
          {
            ad.e("FeedbackDisplayDataSupplier", "there is no feedback item!");
            localObject1 = "";
            localp = this.yVM;
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if ((bool) || (localp == null)) {
              continue;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        p localp;
        Object localObject2;
        String str3;
        String str4;
        AppMethodBeat.o(197615);
        return null;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localp.dYl().Id });
        str3 = String.format("aid=%s", new Object[] { localp.dYP() });
        str4 = String.format("traceid=%s", new Object[] { localp.dYQ() });
        g.ajA();
        localObject2 = i.n((String)localObject1, new String[] { localObject2, str3, str4, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.aiq() }) });
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
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localp.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localp.field_userName);
      AppMethodBeat.o(197615);
      return localObject2;
      localObject1 = ((b.e)localObject1).list.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (b.f)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((b.f)localObject2).url)))
      {
        localObject2 = ((b.f)localObject2).url;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          ad.e("FeedbackDisplayDataSupplier", "there is feedback item, but no url!!!");
          localObject1 = localObject2;
          continue;
          ad.e("FeedbackDisplayDataSupplier", "there is no feedback info!!!");
          str1 = "";
        }
      }
    }
  }
  
  final com.tencent.mm.plugin.sns.storage.a dRK()
  {
    com.tencent.mm.plugin.sns.storage.a locala = null;
    AppMethodBeat.i(197620);
    com.tencent.mm.plugin.sns.data.b localb = this.zav;
    Object localObject = this.yVM;
    if (localb == null)
    {
      AppMethodBeat.o(197620);
      return null;
    }
    if (localObject != null) {
      locala = ((p)localObject).dRK();
    }
    localObject = locala;
    if (locala == null)
    {
      localObject = locala;
      if (localb.zcq != null) {
        localObject = localb.zcq.ApS;
      }
    }
    AppMethodBeat.o(197620);
    return localObject;
  }
  
  final com.tencent.mm.plugin.sns.storage.b dRL()
  {
    AppMethodBeat.i(197621);
    com.tencent.mm.plugin.sns.data.b localb = this.zav;
    p localp = this.yVM;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb != null)
    {
      localObject1 = localObject2;
      if (localb.zcq != null) {
        localObject1 = localb.zcq.ApR;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localp != null) {
        localObject2 = localp.dRL();
      }
    }
    AppMethodBeat.o(197621);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */