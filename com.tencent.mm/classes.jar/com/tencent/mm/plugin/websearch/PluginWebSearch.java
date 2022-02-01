package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.lx.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginWebSearch
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.websearch.api.c
{
  static final int[] ICU;
  private static HashMap<Integer, h.b> dgj;
  private q GiO;
  private a ICS;
  private b ICT;
  private final IListener checkLanguageChangeIListener;
  private com.tencent.mm.plugin.teenmode.a.c kIM;
  private IListener kiA;
  private IListener plI;
  
  static
  {
    AppMethodBeat.i(116525);
    dgj = new HashMap();
    String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    dgj.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.dgl;
      }
    });
    ICU = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new PluginWebSearch.2(this);
    this.kiA = new IListener()
    {
      private static boolean a(bp paramAnonymousbp)
      {
        AppMethodBeat.i(116512);
        int k;
        if (paramAnonymousbp != null)
        {
          int i;
          int m;
          if ((paramAnonymousbp.dEN.dEO == 27) && (paramAnonymousbp.dEN.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 0, 1L, false);
            m = at.aXk(paramAnonymousbp.dEN.filePath);
            if (m != 1) {
              break label404;
            }
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 1, 1L, false);
          }
          at localat;
          for (;;)
          {
            localat = ai.afr(i);
            if (m < localat.bbw()) {
              break label508;
            }
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localat.aXj(paramAnonymousbp.dEN.filePath);
              if (localat.fYz()) {
                break;
              }
              Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbp.dEN.dEO == 27) && (paramAnonymousbp.dEN.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 62) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 40) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 64) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 66) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 5;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 79) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 6;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 85) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 7;
              break;
            }
            if ((paramAnonymousbp.dEN.dEO == 84) && (paramAnonymousbp.dEN.subType == 1))
            {
              i = 8;
              break;
            }
            AppMethodBeat.o(116512);
            return false;
            label404:
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localat.fYz()) {
            break label483;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 6, 1L, false);
          Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            ai.fXZ();
          }
          ar.afC(i);
        }
        for (;;)
        {
          AppMethodBeat.o(116512);
          return false;
          label483:
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 5, 1L, false);
          Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label508:
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.plI = new IListener()
    {
      private static boolean a(lx paramAnonymouslx)
      {
        int i = 1;
        AppMethodBeat.i(116514);
        if ((paramAnonymouslx.dRu.dEO == 27) && (paramAnonymouslx.dRu.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          ai.afr(i).aXj(paramAnonymouslx.dRu.filePath);
          if (i == 0) {
            ai.fXZ();
          }
          AppMethodBeat.o(116514);
          return false;
          if ((paramAnonymouslx.dRu.dEO != 27) || (paramAnonymouslx.dRu.subType != 2)) {
            if ((paramAnonymouslx.dRu.dEO == 62) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymouslx.dRu.dEO == 40) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymouslx.dRu.dEO == 64) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 4;
            }
            else if ((paramAnonymouslx.dRu.dEO == 66) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 5;
            }
            else if ((paramAnonymouslx.dRu.dEO == 79) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 6;
            }
            else if ((paramAnonymouslx.dRu.dEO == 85) && (paramAnonymouslx.dRu.subType == 1))
            {
              i = 7;
            }
            else
            {
              if ((paramAnonymouslx.dRu.dEO != 84) || (paramAnonymouslx.dRu.subType != 1)) {
                break;
              }
              i = 8;
            }
          }
        }
        AppMethodBeat.o(116514);
        return false;
      }
    };
    this.GiO = new PluginWebSearch.6(this);
    this.kIM = new com.tencent.mm.plugin.teenmode.a.c()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(201753);
        ak.bq(20, true);
        AppMethodBeat.o(201753);
      }
    };
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int j = 0;
    int k;
    at localat;
    int m;
    int n;
    int i;
    if (j < 9)
    {
      k = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }[j];
      localat = ai.afr(k);
      m = localat.bbx();
      localat.fYq();
      n = localat.bbw();
      if (n == 1)
      {
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localat.fYA();
      }
      if (!localat.fYz())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localat.fYA();
            if (!localat.fYz())
            {
              i += 1;
              continue;
              com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
              if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("search", "openResetTemplate")), 0) == 1) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label230;
                }
                Log.i("MicroMsg.WebSearch.PluginWebSearch", "expt reset template");
                i = 1;
                break;
              }
              label230:
              if (n >= m) {
                break label317;
              }
              Log.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localat.fYz())
      {
        Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1181L, k * 30 + 7, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label317:
      i = 0;
    }
  }
  
  private int getSearchImageRequestType(ca paramca, int paramInt)
  {
    AppMethodBeat.i(201767);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(201767);
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      if (paramca != null)
      {
        if (ab.Eq(paramca.field_talker))
        {
          AppMethodBeat.o(201767);
          return 4;
        }
        AppMethodBeat.o(201767);
        return 3;
      }
      break;
    case 9: 
      AppMethodBeat.o(201767);
      return 9;
    case 7: 
    case 8: 
      AppMethodBeat.o(201767);
      return 7;
    case 5: 
    case 10: 
      AppMethodBeat.o(201767);
      return 5;
    case 6: 
      AppMethodBeat.o(201767);
      return 6;
    }
    AppMethodBeat.o(201767);
    return 0;
  }
  
  private void manualCheckRes()
  {
    AppMethodBeat.i(168802);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MicroMsg.WebSearch.PluginWebSearch");
    long l1 = localMultiProcessMMKV.decodeLong("last_check_res_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (l3 < 86400000L)
    {
      Log.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      AppMethodBeat.o(168802);
      return;
    }
    localMultiProcessMMKV.encode("last_check_res_time", l2);
    Log.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116511);
        int[] arrayOfInt = PluginWebSearch.ICU;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.j.a.a.b.gnC();
          com.tencent.mm.pluginsdk.j.a.a.b.ahP(k);
          i += 1;
        }
        AppMethodBeat.o(116511);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  private static List<String> optListFromJSONStr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201765);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(201765);
      return null;
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optJSONArray(paramString2);
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramString2 = new LinkedList();
        int i = 0;
        while (i < paramString1.length())
        {
          String str = paramString1.optString(i);
          if (!TextUtils.isEmpty(str)) {
            paramString2.add(str);
          }
          i += 1;
        }
        AppMethodBeat.o(201765);
        return paramString2;
      }
    }
    catch (Throwable paramString1)
    {
      Log.e("MicroMsg.WebSearch.PluginWebSearch", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(201765);
    }
    return null;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return dgj;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.ICS = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.ICS));
    com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      this.ICT = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.ICT));
    }
    AppMethodBeat.o(116520);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(201754);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(201754);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getExposedWord(String paramString)
  {
    AppMethodBeat.i(201762);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shz, null);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(201762);
      return "";
    }
    try
    {
      localObject = new JSONObject((String)localObject).optJSONObject("exposedWords");
      if (localObject == null)
      {
        AppMethodBeat.o(201762);
        return "";
      }
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject(paramString);
      if (localJSONObject == null)
      {
        AppMethodBeat.o(201762);
        return "";
      }
      String str2 = LocaleUtil.getApplicationLanguage();
      String str1 = localJSONObject.optString(str2);
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (!TextUtils.equals(str2, "en")) {
          localObject = localJSONObject.optString("en");
        }
      }
      AppMethodBeat.o(201762);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", localThrowable, "getExposedWord:%s", new Object[] { paramString });
      AppMethodBeat.o(201762);
    }
    return "";
  }
  
  public List<String> getNeedReuseBrands()
  {
    AppMethodBeat.i(201763);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shy, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseBrands");
    AppMethodBeat.o(201763);
    return localList;
  }
  
  public List<String> getNeedReuseItems()
  {
    AppMethodBeat.i(201764);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shy, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseItems");
    AppMethodBeat.o(201764);
    return localList;
  }
  
  public int getSosLimitLength()
  {
    AppMethodBeat.i(201761);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shx, 100);
    AppMethodBeat.o(201761);
    return i;
  }
  
  public void installed()
  {
    AppMethodBeat.i(116519);
    super.installed();
    AppMethodBeat.o(116519);
  }
  
  public boolean isOpenFingerSearch()
  {
    AppMethodBeat.i(201755);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      AppMethodBeat.o(201755);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shn, 0) == 1)
    {
      AppMethodBeat.o(201755);
      return true;
    }
    AppMethodBeat.o(201755);
    return false;
  }
  
  public boolean isOpenHotWordSearch()
  {
    AppMethodBeat.i(201756);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      AppMethodBeat.o(201756);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sho, 0) == 1)
    {
      AppMethodBeat.o(201756);
      return true;
    }
    AppMethodBeat.o(201756);
    return false;
  }
  
  public boolean isOpenImageSearch()
  {
    AppMethodBeat.i(201757);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      localc = com.tencent.mm.util.c.QYz;
      if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("websearch", "openImageSearch")), 0) == 1)
      {
        AppMethodBeat.o(201757);
        return true;
      }
      AppMethodBeat.o(201757);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shq, 0) == 1)
    {
      AppMethodBeat.o(201757);
      return true;
    }
    AppMethodBeat.o(201757);
    return false;
  }
  
  public boolean isOpenInlineC2CTag()
  {
    AppMethodBeat.i(201758);
    Object localObject = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      AppMethodBeat.o(201758);
      return true;
    }
    localObject = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.shu;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (((com.tencent.mm.plugin.expt.b.b)localObject).a(locala, com.tencent.mm.util.c.hdi()) == 1)
    {
      AppMethodBeat.o(201758);
      return true;
    }
    AppMethodBeat.o(201758);
    return false;
  }
  
  public boolean isOpenInlineSnsTag()
  {
    AppMethodBeat.i(201759);
    Object localObject = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      AppMethodBeat.o(201759);
      return true;
    }
    localObject = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.shv;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (((com.tencent.mm.plugin.expt.b.b)localObject).a(locala, com.tencent.mm.util.c.hdj()) == 1)
    {
      AppMethodBeat.o(201759);
      return true;
    }
    AppMethodBeat.o(201759);
    return false;
  }
  
  public boolean isUseSysEditText()
  {
    AppMethodBeat.i(201760);
    boolean bool = a.a.gKe().gKc();
    if (bool) {
      com.tencent.mm.ui.widget.cedit.api.b.aow(10);
    }
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.shw;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if ((localb.a(locala, Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("search", "isUseSysEditText")), 0)) == 1) || (bool) || (ao.gJX()))
    {
      AppMethodBeat.o(201760);
      return true;
    }
    AppMethodBeat.o(201760);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116521);
    this.kiA.alive();
    this.plI.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    b.init();
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.GiO);
    com.tencent.f.h.RTc.b(new a(paramc.hrc), "WebSearchThread");
    ai.LW(5000L);
    ai.LX(5000L);
    ar.afC(-1);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.kIM);
    this.kiA.dead();
    this.plI.dead();
    this.checkLanguageChangeIListener.dead();
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.GiO);
    com.tencent.mm.plugin.websearch.api.am.IEW = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  public void startImageSearch(o paramo)
  {
    AppMethodBeat.i(201766);
    Object localObject = new Intent();
    int i = getSearchImageRequestType(paramo.dTX, paramo.dGf);
    ((Intent)localObject).putExtra("key_source", paramo.dGf);
    ((Intent)localObject).putExtra("key_scan_goods_request_type", i);
    long l;
    switch (paramo.dGf)
    {
    default: 
      l = com.tencent.mm.plugin.fts.a.d.Ni(67);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
      ((Intent)localObject).putExtra("key_source", paramo.dGf);
      ((Intent)localObject).putExtra("key_msg_id", paramo.dTX.field_msgId);
      ((Intent)localObject).putExtra("key_session_id", l);
      Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s", new Object[] { Long.valueOf(paramo.dTX.field_msgId), Integer.valueOf(paramo.dGf), Long.valueOf(l) });
    }
    for (;;)
    {
      paramo = paramo.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramo, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramo, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(201766);
      return;
      l = com.tencent.mm.plugin.fts.a.d.Ni(81);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
      ((Intent)localObject).putExtra("key_sns_id", paramo.dRS);
      ((Intent)localObject).putExtra("key_sns_username", paramo.IDs);
      ((Intent)localObject).putExtra("key_sns_image_path", paramo.dHq);
      ((Intent)localObject).putExtra("key_session_id", l);
      if (paramo.DIq != null) {}
      try
      {
        ((Intent)localObject).putExtra("key_sns_media", paramo.DIq.toByteArray());
        label369:
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.dRS, paramo.IDs, paramo.dHq, Integer.valueOf(paramo.dGf), Long.valueOf(l) });
      }
      catch (Exception localException)
      {
        break label369;
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean ICW;
    
    a(boolean paramBoolean)
    {
      this.ICW = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.ICW);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */