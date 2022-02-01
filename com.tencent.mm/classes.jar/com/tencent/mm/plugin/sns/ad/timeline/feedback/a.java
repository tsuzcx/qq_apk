package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.f.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b.b
{
  p zlW;
  com.tencent.mm.plugin.sns.data.b zqW;
  String zqX = "zh_CN";
  
  private List<b.d> dVg()
  {
    AppMethodBeat.i(219084);
    ArrayList localArrayList = new ArrayList();
    Object localObject = dVi();
    if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject).zMo != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zMo.dZs();
      if (c.m((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (a.c.a)localIterator.next();
          int i = ((a.c.a)localObject).zMK;
          if ("zh_CN".equals(this.zqX)) {
            localObject = ((a.c.a)localObject).zMH;
          }
          for (;;)
          {
            localArrayList.add(new b.d(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.zqX)) || ("zh_TW".equals(this.zqX))) {
              localObject = ((a.c.a)localObject).zMI;
            } else {
              localObject = ((a.c.a)localObject).zMJ;
            }
          }
        }
      }
    }
    AppMethodBeat.o(219084);
    return localArrayList;
  }
  
  private String dVh()
  {
    AppMethodBeat.i(219085);
    Object localObject = dVj();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.zqX))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zNi;
        AppMethodBeat.o(219085);
        return localObject;
      }
      if (("zh_TW".equals(this.zqX)) || ("zh_HK".equals(this.zqX)))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zNk;
        AppMethodBeat.o(219085);
        return localObject;
      }
      localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).zNj;
      AppMethodBeat.o(219085);
      return localObject;
    }
    ae.w("FeedbackDisplayDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(219085);
    return "";
  }
  
  public final com.tencent.mm.plugin.sns.model.r Qg(int paramInt)
  {
    AppMethodBeat.i(219082);
    Object localObject = this.zlW;
    com.tencent.mm.plugin.sns.data.b localb = this.zqW;
    if ((localObject == null) || (localb == null))
    {
      AppMethodBeat.o(219082);
      return null;
    }
    a.c.a locala = new a.c.a();
    if (paramInt == 0) {
      locala.zMK = a.c.a.zMG;
    }
    locala.zte = localb.zte;
    if (paramInt == 0) {}
    for (locala.zML = 0L;; locala.zML = System.currentTimeMillis())
    {
      localObject = new com.tencent.mm.plugin.sns.model.r(((p)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(219082);
      return localObject;
    }
  }
  
  public final Map<String, Object> ayW(String paramString)
  {
    AppMethodBeat.i(219083);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label140;
      }
      Object localObject1 = this.zqW;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).ztd == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.AHi == null)) {
        break label111;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.AHi;
      if (((com.tencent.mm.plugin.sns.storage.a)localObject1).zMo == null) {
        break label101;
      }
      i = ((com.tencent.mm.plugin.sns.storage.a)localObject1).zMo.zMA;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label93:
        ae.w("FeedbackDisplayDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, dVg());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, dVh());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label334;
      }
      com.tencent.mm.plugin.sns.storage.a locala = dVi();
      Object localObject3 = "";
      localObject2 = localObject3;
      if (locala == null) {
        break label252;
      }
      localObject2 = localObject3;
      if (locala.zMo == null) {
        break label252;
      }
      if (!"zh_CN".equals(this.zqX)) {
        break label284;
      }
      localObject2 = locala.zMo.zMD;
      for (;;)
      {
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = dVh();
        }
        localArrayMap.put(paramString, localObject3);
        break;
        if (("zh_HK".equals(this.zqX)) || ("zh_TW".equals(this.zqX))) {
          localObject2 = locala.zMo.zME;
        } else {
          localObject2 = locala.zMo.zMF;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label376;
      }
    }
    AppMethodBeat.o(219083);
    return localArrayMap;
    label101:
    ae.e("FeedbackDisplayDataSupplier", "the adUnlikeInfo is null in data tag!");
    break label409;
    label111:
    ae.e("FeedbackDisplayDataSupplier", "the data tag is null!");
    break label409;
    label140:
    label252:
    Object localObject2 = dVi();
    label284:
    label334:
    if (localObject2 != null) {}
    for (boolean bool = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zMs;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label93;
      label376:
      if ((!"unlike_tag".equals(paramString)) || (this.zqW == null)) {
        break label93;
      }
      localArrayMap.put(paramString, this.zqW);
      break label93;
      label409:
      i = 7;
      break;
    }
  }
  
  public final boolean dVd()
  {
    AppMethodBeat.i(219079);
    try
    {
      com.tencent.mm.plugin.sns.storage.b localb = dVj();
      if (localb != null)
      {
        if (localb.zNX > 0)
        {
          AppMethodBeat.o(219079);
          return true;
        }
        AppMethodBeat.o(219079);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219079);
    }
    return false;
  }
  
  public final boolean dVe()
  {
    AppMethodBeat.i(219080);
    try
    {
      com.tencent.mm.plugin.sns.storage.a locala = dVi();
      if ((locala != null) && (locala.zMo != null))
      {
        boolean bool = c.m(locala.zMo.dZs());
        AppMethodBeat.o(219080);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219080);
    }
    return false;
  }
  
  public final Intent dVf()
  {
    AppMethodBeat.i(219081);
    for (;;)
    {
      try
      {
        localObject1 = dVj();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNM != null))
        {
          localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNM;
          if (c.isEmpty(((b.f)localObject1).list))
          {
            ae.e("FeedbackDisplayDataSupplier", "there is no feedback item!");
            localObject1 = "";
            localp = this.zlW;
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
        AppMethodBeat.o(219081);
        return null;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localp.ebP().Id });
        str3 = String.format("aid=%s", new Object[] { localp.ect() });
        str4 = String.format("traceid=%s", new Object[] { localp.ecu() });
        g.ajP();
        localObject2 = i.n((String)localObject1, new String[] { localObject2, str3, str4, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.aiF() }) });
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
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localp.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localp.field_userName);
      AppMethodBeat.o(219081);
      return localObject2;
      localObject1 = ((b.f)localObject1).list.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (b.g)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((b.g)localObject2).url)))
      {
        localObject2 = ((b.g)localObject2).url;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          ae.e("FeedbackDisplayDataSupplier", "there is feedback item, but no url!!!");
          localObject1 = localObject2;
          continue;
          ae.e("FeedbackDisplayDataSupplier", "there is no feedback info!!!");
          str1 = "";
        }
      }
    }
  }
  
  final com.tencent.mm.plugin.sns.storage.a dVi()
  {
    com.tencent.mm.plugin.sns.storage.a locala = null;
    AppMethodBeat.i(219086);
    com.tencent.mm.plugin.sns.data.b localb = this.zqW;
    Object localObject = this.zlW;
    if (localb == null)
    {
      AppMethodBeat.o(219086);
      return null;
    }
    if (localObject != null) {
      locala = ((p)localObject).dVi();
    }
    localObject = locala;
    if (locala == null)
    {
      localObject = locala;
      if (localb.ztd != null) {
        localObject = localb.ztd.AHi;
      }
    }
    AppMethodBeat.o(219086);
    return localObject;
  }
  
  final com.tencent.mm.plugin.sns.storage.b dVj()
  {
    AppMethodBeat.i(219087);
    com.tencent.mm.plugin.sns.data.b localb = this.zqW;
    p localp = this.zlW;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb != null)
    {
      localObject1 = localObject2;
      if (localb.ztd != null) {
        localObject1 = localb.ztd.AHh;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localp != null) {
        localObject2 = localp.dVj();
      }
    }
    AppMethodBeat.o(219087);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */