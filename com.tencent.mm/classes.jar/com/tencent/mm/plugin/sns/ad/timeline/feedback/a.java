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
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b.b
{
  p xHc;
  com.tencent.mm.plugin.sns.data.b xLg;
  String xLh = "zh_CN";
  
  private List<b.d> dFO()
  {
    AppMethodBeat.i(199972);
    ArrayList localArrayList = new ArrayList();
    Object localObject = dFQ();
    if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject).yeS != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).yeS.dJD();
      if (com.tencent.mm.plugin.sns.ad.e.b.m((Collection)localObject))
      {
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (a.c.a)localIterator.next();
          int i = ((a.c.a)localObject).yfn;
          if ("zh_CN".equals(this.xLh)) {
            localObject = ((a.c.a)localObject).yfk;
          }
          for (;;)
          {
            localArrayList.add(new b.d(i, (String)localObject));
            break;
            if (("zh_HK".equals(this.xLh)) || ("zh_TW".equals(this.xLh))) {
              localObject = ((a.c.a)localObject).yfl;
            } else {
              localObject = ((a.c.a)localObject).yfm;
            }
          }
        }
      }
    }
    AppMethodBeat.o(199972);
    return localArrayList;
  }
  
  private String dFP()
  {
    AppMethodBeat.i(199973);
    Object localObject = dFR();
    if (localObject != null)
    {
      if ("zh_CN".equals(this.xLh))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).yfL;
        AppMethodBeat.o(199973);
        return localObject;
      }
      if (("zh_TW".equals(this.xLh)) || ("zh_HK".equals(this.xLh)))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).yfN;
        AppMethodBeat.o(199973);
        return localObject;
      }
      localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).yfM;
      AppMethodBeat.o(199973);
      return localObject;
    }
    ac.w("FeedbackDisplayDataSupplier", "the ad xml is null in data");
    AppMethodBeat.o(199973);
    return "";
  }
  
  public final com.tencent.mm.plugin.sns.model.q NW(int paramInt)
  {
    AppMethodBeat.i(199970);
    Object localObject = this.xHc;
    com.tencent.mm.plugin.sns.data.b localb = this.xLg;
    if ((localObject == null) || (localb == null))
    {
      AppMethodBeat.o(199970);
      return null;
    }
    a.c.a locala = new a.c.a();
    if (paramInt == 0) {
      locala.yfn = a.c.a.yfj;
    }
    locala.xMz = localb.xMz;
    if (paramInt == 0) {}
    for (locala.yfo = 0L;; locala.yfo = System.currentTimeMillis())
    {
      localObject = new com.tencent.mm.plugin.sns.model.q(((p)localObject).field_snsId, 8, locala);
      AppMethodBeat.o(199970);
      return localObject;
    }
  }
  
  public final Map<String, Object> asF(String paramString)
  {
    AppMethodBeat.i(199971);
    ArrayMap localArrayMap = new ArrayMap();
    int i;
    try
    {
      if (!"ad_delay_interval_day".equals(paramString)) {
        break label140;
      }
      Object localObject1 = this.xLg;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).xMy == null) || (((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.yYh == null)) {
        break label111;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.yYh;
      if (((com.tencent.mm.plugin.sns.storage.a)localObject1).yeS == null) {
        break label101;
      }
      i = ((com.tencent.mm.plugin.sns.storage.a)localObject1).yeS.yfd;
      localArrayMap.put(paramString, Integer.valueOf(i));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label93:
        ac.w("FeedbackDisplayDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(paramString)));
        continue;
        if ("reason_list".equals(paramString))
        {
          localArrayMap.put(paramString, dFO());
        }
        else
        {
          if (!"expand_title".equals(paramString)) {
            break;
          }
          localArrayMap.put(paramString, dFP());
        }
      }
      if (!"special_prompt".equals(paramString)) {
        break label334;
      }
      com.tencent.mm.plugin.sns.storage.a locala = dFQ();
      Object localObject3 = "";
      localObject2 = localObject3;
      if (locala == null) {
        break label252;
      }
      localObject2 = localObject3;
      if (locala.yeS == null) {
        break label252;
      }
      if (!"zh_CN".equals(this.xLh)) {
        break label284;
      }
      localObject2 = locala.yeS.yfg;
      for (;;)
      {
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = dFP();
        }
        localArrayMap.put(paramString, localObject3);
        break;
        if (("zh_HK".equals(this.xLh)) || ("zh_TW".equals(this.xLh))) {
          localObject2 = locala.yeS.yfh;
        } else {
          localObject2 = locala.yeS.yfi;
        }
      }
      if (!"is_special".equals(paramString)) {
        break label376;
      }
    }
    AppMethodBeat.o(199971);
    return localArrayMap;
    label101:
    ac.e("FeedbackDisplayDataSupplier", "the adUnlikeInfo is null in data tag!");
    break label409;
    label111:
    ac.e("FeedbackDisplayDataSupplier", "the data tag is null!");
    break label409;
    label140:
    label252:
    Object localObject2 = dFQ();
    label284:
    label334:
    if (localObject2 != null) {}
    for (boolean bool = ((com.tencent.mm.plugin.sns.storage.a)localObject2).yeW;; bool = false)
    {
      localArrayMap.put(paramString, Boolean.valueOf(bool));
      break label93;
      label376:
      if ((!"unlike_tag".equals(paramString)) || (this.xLg == null)) {
        break label93;
      }
      localArrayMap.put(paramString, this.xLg);
      break label93;
      label409:
      i = 7;
      break;
    }
  }
  
  public final Intent dFN()
  {
    AppMethodBeat.i(199969);
    for (;;)
    {
      try
      {
        localObject1 = dFR();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).ygp != null))
        {
          localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).ygp;
          if (com.tencent.mm.plugin.sns.ad.e.b.isEmpty(((b.e)localObject1).list))
          {
            ac.e("FeedbackDisplayDataSupplier", "there is no feedback item!");
            localObject1 = "";
            localp = this.xHc;
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
        AppMethodBeat.o(199969);
        return null;
      }
      try
      {
        localObject2 = String.format("snsid=%s", new Object[] { localp.dLV().Id });
        str3 = String.format("aid=%s", new Object[] { localp.dMz() });
        str4 = String.format("traceid=%s", new Object[] { localp.dMA() });
        g.agP();
        localObject2 = i.n((String)localObject1, new String[] { localObject2, str3, str4, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.afE() }) });
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
      ((Intent)localObject2).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
      ((Intent)localObject2).putExtra("pre_username", localp.field_userName);
      ((Intent)localObject2).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
      ((Intent)localObject2).putExtra("preUsername", localp.field_userName);
      AppMethodBeat.o(199969);
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
          ac.e("FeedbackDisplayDataSupplier", "there is feedback item, but no url!!!");
          localObject1 = localObject2;
          continue;
          ac.e("FeedbackDisplayDataSupplier", "there is no feedback info!!!");
          str1 = "";
        }
      }
    }
  }
  
  final com.tencent.mm.plugin.sns.storage.a dFQ()
  {
    com.tencent.mm.plugin.sns.storage.a locala = null;
    AppMethodBeat.i(199974);
    com.tencent.mm.plugin.sns.data.b localb = this.xLg;
    Object localObject = this.xHc;
    if (localb == null)
    {
      AppMethodBeat.o(199974);
      return null;
    }
    if (localObject != null) {
      locala = ((p)localObject).dFQ();
    }
    localObject = locala;
    if (locala == null)
    {
      localObject = locala;
      if (localb.xMy != null) {
        localObject = localb.xMy.yYh;
      }
    }
    AppMethodBeat.o(199974);
    return localObject;
  }
  
  final com.tencent.mm.plugin.sns.storage.b dFR()
  {
    AppMethodBeat.i(199975);
    com.tencent.mm.plugin.sns.data.b localb = this.xLg;
    p localp = this.xHc;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb != null)
    {
      localObject1 = localObject2;
      if (localb.xMy != null) {
        localObject1 = localb.xMy.yYg;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localp != null) {
        localObject2 = localp.dFR();
      }
    }
    AppMethodBeat.o(199975);
    return localObject2;
  }
  
  public final boolean eBz()
  {
    AppMethodBeat.i(210247);
    try
    {
      com.tencent.mm.plugin.sns.storage.b localb = dFR();
      if (localb != null)
      {
        if (localb.DeA > 0)
        {
          AppMethodBeat.o(210247);
          return true;
        }
        AppMethodBeat.o(210247);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(210247);
    }
    return false;
  }
  
  public final boolean eEw()
  {
    AppMethodBeat.i(210248);
    try
    {
      com.tencent.mm.plugin.sns.storage.a locala = dFQ();
      if ((locala != null) && (locala.yeS != null))
      {
        boolean bool = com.tencent.mm.plugin.sns.ad.e.b.m(locala.yeS.dJD());
        AppMethodBeat.o(210248);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(210248);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a
 * JD-Core Version:    0.7.0.1
 */