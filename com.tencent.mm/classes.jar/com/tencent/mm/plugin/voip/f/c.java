package com.tencent.mm.plugin.voip.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.i.a;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/QuickRingtoneHelper;", "", "()V", "CALLING_NAME", "", "DATE_DIST", "", "FORCE_HIDE_CALLED_APPMSG", "", "FORCE_HIDE_CALLING_APPMSG", "FORCE_SHOW_CALLED_APPMSG", "FORCE_SHOW_CALLING_APPMSG", "MONTH_DIST", "RINGTONE_APPMSG_NAME", "TAG", "mRingtoneCallingInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mmAppMsgKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "mmRingtoneCallingKv", "checkCalledNeedShowRingtoneAppMsg", "", "checkCallingNeedShowRingtoneAppMsg", "username", "checkRingtoneDiff", "json", "ringtoneId", "findFirstKvInfo", "dataSource", "", "findIsLink", "findLastKvInfo", "getAppMsgKvInfo", "isOutCall", "defValues", "", "getRepairedSettingRingtoneAllowShowAppMsg", "getXSettingCalledRingtoneString", "", "()[Ljava/lang/String;", "getXSettingCallingRingtoneString", "getXSettingRingtoneCalledCheckPerMonth", "getXSettingRingtoneCalledCheckPerTimes", "getXSettingRingtoneCallingCheckPerMonth", "getXSettingRingtoneCallingCheckPerTimes", "markCurrentUserAppMsgEnterRingtone", "", "parseCallingInfo", "Lcom/tencent/mm/plugin/voip/util/QuickRingtoneHelper$RingtoneCallingInfo;", "saveRingtoneCallingInfo", "ringtoneInfo", "sendQuickRingtoneAppMsg", "setAppMsgKvInfo", "data", "RingtoneCallingInfo", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c ULf;
  private static MultiProcessMMKV ULg;
  private static MultiProcessMMKV ULh;
  private static HashMap<String, String> ULi;
  
  static
  {
    AppMethodBeat.i(292719);
    ULf = new c();
    com.tencent.mm.kernel.h.baC();
    ULg = MultiProcessMMKV.getMMKV(s.X("mmkv_ringtone_appmsg_info", b.aZs()));
    com.tencent.mm.kernel.h.baC();
    ULh = MultiProcessMMKV.getMMKV(s.X("mmkv_ringtone_calling_info", b.aZs()));
    ULi = new HashMap();
    AppMethodBeat.o(292719);
  }
  
  private static String E(Set<String> paramSet)
  {
    String str = null;
    AppMethodBeat.i(292645);
    if (paramSet == null)
    {
      AppMethodBeat.o(292645);
      return null;
    }
    long l = 0L;
    Iterator localIterator = ((Iterable)paramSet).iterator();
    paramSet = str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      a locala = bfM(str);
      if (l > locala.ULk) {
        break label88;
      }
      l = locala.ULk;
      paramSet = str;
    }
    label88:
    for (;;)
    {
      break;
      AppMethodBeat.o(292645);
      return paramSet;
    }
  }
  
  private static boolean F(Set<String> paramSet)
  {
    AppMethodBeat.i(292651);
    if (paramSet != null)
    {
      paramSet = ((Iterable)paramSet).iterator();
      while (paramSet.hasNext()) {
        if (bfM((String)paramSet.next()).LrJ)
        {
          AppMethodBeat.o(292651);
          return true;
        }
      }
    }
    AppMethodBeat.o(292651);
    return false;
  }
  
  private static String G(Set<String> paramSet)
  {
    AppMethodBeat.i(292660);
    String str = null;
    long l = 9223372036854775807L;
    Iterator localIterator = ((Iterable)paramSet).iterator();
    paramSet = str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      a locala = bfM(str);
      if (l < locala.ULk) {
        break label79;
      }
      l = locala.ULk;
      paramSet = str;
    }
    label79:
    for (;;)
    {
      break;
      AppMethodBeat.o(292660);
      return paramSet;
    }
  }
  
  private static int GJ(boolean paramBoolean)
  {
    AppMethodBeat.i(292568);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    int i = com.tencent.mm.util.i.a(b.a.agsU, 0);
    if (paramBoolean)
    {
      switch (i)
      {
      case 2: 
      default: 
        AppMethodBeat.o(292568);
        return -4;
      case 0: 
        i = iaV();
        AppMethodBeat.o(292568);
        return i;
      }
      AppMethodBeat.o(292568);
      return -2;
    }
    switch (i)
    {
    case 1: 
    default: 
      AppMethodBeat.o(292568);
      return -3;
    case 0: 
      i = iaW();
      AppMethodBeat.o(292568);
      return i;
    }
    AppMethodBeat.o(292568);
    return -1;
  }
  
  private static void a(String paramString, boolean paramBoolean, Set<String> paramSet)
  {
    AppMethodBeat.i(292670);
    if (paramBoolean)
    {
      ULg.putStringSet(s.X(paramString, "called"), paramSet);
      AppMethodBeat.o(292670);
      return;
    }
    ULg.putStringSet(s.X(paramString, "calling"), paramSet);
    AppMethodBeat.o(292670);
  }
  
  public static void aG(boolean paramBoolean, String paramString)
  {
    int k = 0;
    AppMethodBeat.i(292625);
    s.u(paramString, "username");
    if (!paramBoolean) {}
    Object localObject1;
    int i;
    Object localObject2;
    boolean bool;
    label193:
    int j;
    switch (GJ(false))
    {
    case -2: 
    default: 
      localObject1 = z.bAM();
      s.s(localObject1, "getUsernameFromUserInfo()");
      localObject1 = dw((String)localObject1, false);
      if (localObject1 == null)
      {
        localObject1 = z.bAM();
        s.s(localObject1, "getUsernameFromUserInfo()");
        a((String)localObject1, false, ar.mutableSetOf(new String[] { new a("", Util.currentTicks()).iaZ() }));
        i = 1;
        if (i == 0)
        {
          if (!paramBoolean) {
            break label344;
          }
          localObject1 = (String)ULi.get(paramString);
          i = k;
          if (localObject1 != null)
          {
            i = k;
            if (!n.bp((CharSequence)localObject1))
            {
              localObject2 = E(dw(paramString, true));
              if ((localObject2 == null) || (!bfM((String)localObject2).LrJ)) {
                break label698;
              }
              bool = true;
              if ((localObject2 != null) && (s.p(bfM((String)localObject2).ULj, localObject1))) {
                break label704;
              }
              j = 1;
              label216:
              a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks(), bool).iaZ() }));
              i = k;
              if (!F(dw(paramString, true)))
              {
                i = k;
                switch (GJ(true))
                {
                case -3: 
                case -1: 
                default: 
                  i = k;
                  if (!a.gOJ())
                  {
                    if (!a.gOH()) {
                      break label787;
                    }
                    i = k;
                  }
                  break;
                }
              }
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.bm(new c..ExternalSyntheticLambda0(paramBoolean, paramString));
      }
      label344:
      AppMethodBeat.o(292625);
      return;
      i = 0;
      break;
      localObject1 = z.bAM();
      s.s(localObject1, "getUsernameFromUserInfo()");
      a((String)localObject1, false, ar.mutableSetOf(new String[] { new a("", Util.currentTicks()).iaZ() }));
      i = 1;
      break;
      if (!F((Set)localObject1))
      {
        localObject2 = E((Set)localObject1);
        if (localObject2 == null)
        {
          localObject1 = z.bAM();
          s.s(localObject1, "getUsernameFromUserInfo()");
          a((String)localObject1, false, ar.mutableSetOf(new String[] { new a("", Util.currentTicks()).iaZ() }));
          i = 1;
          break;
        }
        localObject2 = bfM((String)localObject2);
        if (!((a)localObject2).LrJ)
        {
          if (((Set)localObject1).size() >= iaW())
          {
            localObject1 = G((Set)localObject1);
            if (localObject1 == null)
            {
              i = 1;
              break;
            }
            if (Util.ticksToNow(bfM((String)localObject1).ULk) / 86400000L > 30L)
            {
              Log.i("MicroMsg.QuickRingtoneHelper", "current user first show ringtone appmsg is a month passed");
              localObject1 = z.bAM();
              s.s(localObject1, "getUsernameFromUserInfo()");
              a((String)localObject1, false, ar.mutableSetOf(new String[] { new a("", Util.currentTicks()).iaZ() }));
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          if (Util.ticksToNow(((a)localObject2).ULk) / 86400000L > ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySm, 7))
          {
            Log.i("MicroMsg.QuickRingtoneHelper", "current user last show ringtone appmsg is one day passed ");
            ((Set)localObject1).add(new a("", Util.currentTicks()).iaZ());
            localObject2 = z.bAM();
            s.s(localObject2, "getUsernameFromUserInfo()");
            a((String)localObject2, false, (Set)localObject1);
            i = 1;
            break;
          }
        }
      }
      i = 0;
      break;
      label698:
      bool = false;
      break label193;
      label704:
      j = 0;
      break label216;
      localObject2 = z.bAM();
      s.s(localObject2, "getUsernameFromUserInfo()");
      a((String)localObject2, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
      a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
      i = 1;
      continue;
      label787:
      Object localObject3 = z.bAM();
      s.s(localObject3, "getUsernameFromUserInfo()");
      localObject3 = dw((String)localObject3, true);
      if (localObject3 == null)
      {
        i = k;
        if (j != 0)
        {
          localObject2 = z.bAM();
          s.s(localObject2, "getUsernameFromUserInfo()");
          a((String)localObject2, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
          a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
          i = 1;
        }
      }
      else
      {
        Object localObject4 = E((Set)localObject3);
        if (localObject4 == null)
        {
          i = k;
          if (j != 0)
          {
            localObject2 = z.bAM();
            s.s(localObject2, "getUsernameFromUserInfo()");
            a((String)localObject2, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
            a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
            i = 1;
          }
        }
        else
        {
          localObject4 = bfM((String)localObject4);
          if (((Set)localObject3).size() >= iaV())
          {
            localObject3 = G((Set)localObject3);
            if (localObject3 == null)
            {
              i = 1;
            }
            else
            {
              localObject3 = bfM((String)localObject3);
              i = k;
              if (Util.ticksToNow(((a)localObject3).ULk) / 86400000L > 30L)
              {
                i = k;
                if (nv((String)localObject2, (String)localObject1))
                {
                  i = k;
                  if (!((a)localObject4).LrJ)
                  {
                    Log.i("MicroMsg.QuickRingtoneHelper", "current user first show ringtone appmsg is a month passed");
                    a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
                    localObject4 = z.bAM();
                    s.s(localObject4, "getUsernameFromUserInfo()");
                    localObject2 = ((a)localObject3).ULj;
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                      localObject1 = "";
                    }
                    a((String)localObject4, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
                    i = 1;
                  }
                }
              }
            }
          }
          else
          {
            i = k;
            if (Util.ticksToNow(((a)localObject4).ULk) / 86400000L > ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySl, 7))
            {
              i = k;
              if (nv((String)localObject2, (String)localObject1))
              {
                i = k;
                if (!((a)localObject4).LrJ)
                {
                  Log.i("MicroMsg.QuickRingtoneHelper", "current user last show ringtone appmsg is one day passed ");
                  ((Set)localObject3).add(new a((String)localObject1, Util.currentTicks(), bool).iaZ());
                  localObject2 = z.bAM();
                  s.s(localObject2, "getUsernameFromUserInfo()");
                  a((String)localObject2, true, (Set)localObject3);
                  a(paramString, true, ar.mutableSetOf(new String[] { new a((String)localObject1, Util.currentTicks()).iaZ() }));
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static final void aH(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(292712);
    s.u(paramString, "$username");
    cc localcc = new cc();
    if (paramBoolean) {}
    for (String[] arrayOfString = iaX(); arrayOfString == null; arrayOfString = iaY())
    {
      AppMethodBeat.o(292712);
      return;
    }
    String str1 = "";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      str1 = str1 + str2 + ' ';
      i += 1;
    }
    localcc.setContent(str1);
    if (paramBoolean)
    {
      i = 85;
      localcc.setType(i);
      localcc.pI(0);
      localcc.BS(paramString);
      localcc.setCreateTime(System.currentTimeMillis());
      Log.i("MicroMsg.QuickRingtoneHelper", "insert ringtone msg %d", new Object[] { Long.valueOf(br.B(localcc)) });
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (i = 1;; i = 2)
    {
      paramString = PluginRingtone.OBl;
      PluginRingtone.a.K(i, 1, str1);
      AppMethodBeat.o(292712);
      return;
      i = 86;
      break;
    }
  }
  
  private static a bfM(String paramString)
  {
    AppMethodBeat.i(292695);
    a locala = new a();
    paramString = new com.tencent.mm.ad.i(paramString);
    locala.ULj = paramString.getString("ringtoneId");
    locala.ULk = paramString.getLong("tick");
    locala.LrJ = paramString.getBoolean("linkToSetting");
    AppMethodBeat.o(292695);
    return locala;
  }
  
  private static Set<String> dw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292635);
    if (paramBoolean)
    {
      paramString = ULg.getStringSet(s.X(paramString, "called"), null);
      AppMethodBeat.o(292635);
      return paramString;
    }
    paramString = ULg.getStringSet(s.X(paramString, "calling"), null);
    AppMethodBeat.o(292635);
    return paramString;
  }
  
  public static final void dx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292679);
    s.u(paramString, "username");
    if (!paramBoolean) {
      paramString = z.bAM();
    }
    s.s(paramString, "name");
    Object localObject2 = dw(paramString, paramBoolean);
    if (localObject2 != null)
    {
      Object localObject1 = E((Set)localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(292679);
        return;
      }
      Set localSet = (Set)new LinkedHashSet();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (!s.p(localObject1, str)) {
          localSet.add(str);
        }
      }
      localObject1 = bfM((String)localObject1);
      ((a)localObject1).LrJ = true;
      localSet.add(((a)localObject1).iaZ());
      a(paramString, paramBoolean, localSet);
    }
    AppMethodBeat.o(292679);
  }
  
  private static int iaV()
  {
    AppMethodBeat.i(292554);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySj, 0);
    AppMethodBeat.o(292554);
    return i;
  }
  
  private static int iaW()
  {
    AppMethodBeat.i(292560);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySk, 0);
    AppMethodBeat.o(292560);
    return i;
  }
  
  public static String[] iaX()
  {
    AppMethodBeat.i(292583);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySo, "");
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int j;
      try
      {
        localObject = new com.tencent.mm.ad.i((String)localObject);
        str2 = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.QuickRingtoneHelper", "getXSettingCallingRingtoneString, langCode:%s", new Object[] { str2 });
        str2 = ((com.tencent.mm.ad.i)localObject).optString(str2);
        s.s(str2, "result");
        localObject = (CharSequence)str2;
        j = 0;
        if (j >= ((CharSequence)localObject).length()) {
          break label307;
        }
        int i = ((CharSequence)localObject).charAt(j);
        if (i != 65509) {
          break label295;
        }
        k = 1;
        if (k == 0) {
          break label300;
        }
        localObject = Character.valueOf(i);
        if (localObject == null)
        {
          AppMethodBeat.o(292583);
          return null;
        }
        ((Character)localObject).charValue();
        localObject = str2.subSequence(n.a((CharSequence)str2, 65509, 0, false, 6) + 1, str2.length());
        str2 = str2.subSequence(0, n.a((CharSequence)str2, 65509, 0, false, 6)).toString();
        localObject = localObject.toString();
        AppMethodBeat.o(292583);
        return new String[] { str2, localObject };
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.QuickRingtoneHelper", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
      String str1 = MMApplicationContext.getContext().getString(b.g.voip_ringtone_quick_tip_calling);
      s.s(str1, "getContext().getString(R…ngtone_quick_tip_calling)");
      String str2 = MMApplicationContext.getContext().getString(b.g.voip_ringtone_link_tip);
      s.s(str2, "getContext().getString(R…g.voip_ringtone_link_tip)");
      AppMethodBeat.o(292583);
      return new String[] { str1, str2 };
      label295:
      int k = 0;
      continue;
      label300:
      j += 1;
      continue;
      label307:
      str1 = null;
    }
  }
  
  public static String[] iaY()
  {
    AppMethodBeat.i(292597);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySn, "");
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int j;
      try
      {
        localObject = new com.tencent.mm.ad.i((String)localObject);
        str2 = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.QuickRingtoneHelper", "getXSettingCallingRingtoneString, langCode:%s", new Object[] { str2 });
        str2 = ((com.tencent.mm.ad.i)localObject).optString(str2);
        s.s(str2, "result");
        localObject = (CharSequence)str2;
        j = 0;
        if (j >= ((CharSequence)localObject).length()) {
          break label307;
        }
        int i = ((CharSequence)localObject).charAt(j);
        if (i != 65509) {
          break label295;
        }
        k = 1;
        if (k == 0) {
          break label300;
        }
        localObject = Character.valueOf(i);
        if (localObject == null)
        {
          AppMethodBeat.o(292597);
          return null;
        }
        ((Character)localObject).charValue();
        localObject = str2.subSequence(n.a((CharSequence)str2, 65509, 0, false, 6) + 1, str2.length());
        str2 = str2.subSequence(0, n.a((CharSequence)str2, 65509, 0, false, 6)).toString();
        localObject = localObject.toString();
        AppMethodBeat.o(292597);
        return new String[] { str2, localObject };
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.QuickRingtoneHelper", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
      String str1 = MMApplicationContext.getContext().getString(b.g.voip_ringtone_quick_tip_called);
      s.s(str1, "getContext().getString(R…ingtone_quick_tip_called)");
      String str2 = MMApplicationContext.getContext().getString(b.g.voip_ringtone_link_tip_update);
      s.s(str2, "getContext().getString(R…ringtone_link_tip_update)");
      AppMethodBeat.o(292597);
      return new String[] { str1, str2 };
      label295:
      int k = 0;
      continue;
      label300:
      j += 1;
      continue;
      label307:
      str1 = null;
    }
  }
  
  public static final void nu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292688);
    s.u(paramString1, "username");
    s.u(paramString2, "ringtoneInfo");
    ((Map)ULi).put(paramString1, paramString2);
    ULh.putString(paramString1, paramString2);
    AppMethodBeat.o(292688);
  }
  
  private static boolean nv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292703);
    if (paramString1 == null)
    {
      AppMethodBeat.o(292703);
      return true;
    }
    a locala = new a();
    paramString1 = new com.tencent.mm.ad.i(paramString1);
    locala.ULj = paramString1.getString("ringtoneId");
    locala.ULk = paramString1.getLong("tick");
    locala.LrJ = paramString1.getBoolean("linkToSetting");
    if (!s.p(locala.ULj, paramString2))
    {
      AppMethodBeat.o(292703);
      return true;
    }
    AppMethodBeat.o(292703);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/QuickRingtoneHelper$RingtoneCallingInfo;", "", "()V", "id", "", "tick", "", "linkToSetting", "", "(Ljava/lang/String;JZ)V", "isLinkToSetting", "()Z", "setLinkToSetting", "(Z)V", "ringtoneId", "getRingtoneId", "()Ljava/lang/String;", "setRingtoneId", "(Ljava/lang/String;)V", "ringtoneTick", "getRingtoneTick", "()J", "setRingtoneTick", "(J)V", "parseJson", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean LrJ;
    String ULj;
    long ULk;
    
    public a() {}
    
    public a(String paramString, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(292752);
      this.ULj = paramString;
      this.ULk = paramLong;
      this.LrJ = paramBoolean;
      AppMethodBeat.o(292752);
    }
    
    public final String iaZ()
    {
      AppMethodBeat.i(292759);
      Object localObject = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject).m("ringtoneId", this.ULj);
      ((com.tencent.mm.ad.i)localObject).t("tick", this.ULk);
      ((com.tencent.mm.ad.i)localObject).A("linkToSetting", this.LrJ);
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      s.s(localObject, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(292759);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.c
 * JD-Core Version:    0.7.0.1
 */