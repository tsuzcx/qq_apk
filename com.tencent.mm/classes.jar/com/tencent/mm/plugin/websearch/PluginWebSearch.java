package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bs;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.f.a.mo.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.cvt;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginWebSearch
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.websearch.api.c
{
  static final int[] Pxk;
  private static HashMap<Integer, h.b> djv;
  private t MVC;
  private b Pxi;
  private c Pxj;
  private final IListener checkLanguageChangeIListener;
  private IListener mZZ;
  private com.tencent.mm.plugin.teenmode.a.c nCC;
  private IListener soa;
  
  static
  {
    AppMethodBeat.i(116525);
    djv = new HashMap();
    String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    djv.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.djx;
      }
    });
    Pxk = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new IListener() {};
    this.mZZ = new IListener()
    {
      private static boolean a(bu paramAnonymousbu)
      {
        AppMethodBeat.i(116512);
        int k;
        if (paramAnonymousbu != null)
        {
          int i;
          int m;
          if ((paramAnonymousbu.fxB.fxC == 27) && (paramAnonymousbu.fxB.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 0, 1L, false);
            m = at.biV(paramAnonymousbu.fxB.filePath);
            if (m != 1) {
              break label404;
            }
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 1, 1L, false);
          }
          at localat;
          for (;;)
          {
            localat = ai.anf(i);
            if (m < localat.bkM()) {
              break label508;
            }
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localat.biU(paramAnonymousbu.fxB.filePath);
              if (localat.gRk()) {
                break;
              }
              Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbu.fxB.fxC == 27) && (paramAnonymousbu.fxB.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 62) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 40) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 64) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 66) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 5;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 79) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 6;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 85) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 7;
              break;
            }
            if ((paramAnonymousbu.fxB.fxC == 84) && (paramAnonymousbu.fxB.subType == 1))
            {
              i = 8;
              break;
            }
            AppMethodBeat.o(116512);
            return false;
            label404:
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localat.gRk()) {
            break label483;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 6, 1L, false);
          Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            ai.gQK();
          }
          com.tencent.mm.plugin.websearch.api.ar.anq(i);
        }
        for (;;)
        {
          AppMethodBeat.o(116512);
          return false;
          label483:
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 5, 1L, false);
          Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label508:
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.soa = new IListener()
    {
      private static boolean a(mo paramAnonymousmo)
      {
        int i = 1;
        AppMethodBeat.i(116514);
        if ((paramAnonymousmo.fKK.fxC == 27) && (paramAnonymousmo.fKK.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          ai.anf(i).biU(paramAnonymousmo.fKK.filePath);
          if (i == 0) {
            ai.gQK();
          }
          AppMethodBeat.o(116514);
          return false;
          if ((paramAnonymousmo.fKK.fxC != 27) || (paramAnonymousmo.fKK.subType != 2)) {
            if ((paramAnonymousmo.fKK.fxC == 62) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymousmo.fKK.fxC == 40) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymousmo.fKK.fxC == 64) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 4;
            }
            else if ((paramAnonymousmo.fKK.fxC == 66) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 5;
            }
            else if ((paramAnonymousmo.fKK.fxC == 79) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 6;
            }
            else if ((paramAnonymousmo.fKK.fxC == 85) && (paramAnonymousmo.fKK.subType == 1))
            {
              i = 7;
            }
            else
            {
              if ((paramAnonymousmo.fKK.fxC != 84) || (paramAnonymousmo.fKK.subType != 1)) {
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
    this.MVC = new PluginWebSearch.6(this);
    this.nCC = new com.tencent.mm.plugin.teenmode.a.c()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(256365);
        ak.bB(20, true);
        AppMethodBeat.o(256365);
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
    int i;
    int m;
    if (j < 9)
    {
      k = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }[j];
      localat = ai.anf(k);
      i = localat.bkN();
      localat.gRb();
      m = localat.bkM();
      if (m == 1)
      {
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localat.gRl();
      }
      if (!localat.gRk())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localat.gRl();
            if (!localat.gRk())
            {
              i += 1;
              continue;
              if (m >= i) {
                break label268;
              }
              Log.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localat.gRk())
      {
        Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1181L, k * 30 + 7, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label268:
      i = 0;
    }
  }
  
  private int getSearchImageRequestType(ca paramca, int paramInt)
  {
    AppMethodBeat.i(256191);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(256191);
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      if (paramca != null)
      {
        if (ab.Lj(paramca.field_talker))
        {
          AppMethodBeat.o(256191);
          return 4;
        }
        AppMethodBeat.o(256191);
        return 3;
      }
      break;
    case 9: 
      AppMethodBeat.o(256191);
      return 9;
    case 7: 
    case 8: 
      AppMethodBeat.o(256191);
      return 7;
    case 5: 
    case 10: 
      AppMethodBeat.o(256191);
      return 5;
    case 6: 
      AppMethodBeat.o(256191);
      return 6;
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
      AppMethodBeat.o(256191);
      return 11;
    }
    AppMethodBeat.o(256191);
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
        int[] arrayOfInt = PluginWebSearch.Pxk;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.k.a.a.b.hii();
          com.tencent.mm.pluginsdk.k.a.a.b.apP(k);
          i += 1;
        }
        AppMethodBeat.o(116511);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  private static List<String> optListFromJSONStr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256185);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(256185);
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
        AppMethodBeat.o(256185);
        return paramString2;
      }
    }
    catch (Throwable paramString1)
    {
      Log.e("MicroMsg.WebSearch.PluginWebSearch", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(256185);
    }
    return null;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return djv;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.Pxi = new b();
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.Pxi));
    com.tencent.mm.kernel.h.a(j.class, new com.tencent.mm.kernel.c.e(new d()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.h.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      this.Pxj = new c();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.Pxj));
    }
    AppMethodBeat.o(116520);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(256158);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(256158);
  }
  
  public void execute(g paramg) {}
  
  public String getExposedWord(String paramString)
  {
    AppMethodBeat.i(256179);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRv, null);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(256179);
      return "";
    }
    try
    {
      localObject = new JSONObject((String)localObject).optJSONObject("exposedWords");
      if (localObject == null)
      {
        AppMethodBeat.o(256179);
        return "";
      }
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject(paramString);
      if (localJSONObject == null)
      {
        AppMethodBeat.o(256179);
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
      AppMethodBeat.o(256179);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", localThrowable, "getExposedWord:%s", new Object[] { paramString });
      AppMethodBeat.o(256179);
    }
    return "";
  }
  
  public List<String> getNeedReuseBrands()
  {
    AppMethodBeat.i(256181);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRu, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseBrands");
    AppMethodBeat.o(256181);
    return localList;
  }
  
  public List<String> getNeedReuseItems()
  {
    AppMethodBeat.i(256182);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRu, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseItems");
    AppMethodBeat.o(256182);
    return localList;
  }
  
  public int getSosLimitLength()
  {
    AppMethodBeat.i(256176);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRt, 100);
    AppMethodBeat.o(256176);
    return i;
  }
  
  public void installed()
  {
    AppMethodBeat.i(116519);
    super.installed();
    AppMethodBeat.o(116519);
  }
  
  public boolean isOpenImageSearch()
  {
    AppMethodBeat.i(256166);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRm, 0) == 1)
    {
      AppMethodBeat.o(256166);
      return true;
    }
    AppMethodBeat.o(256166);
    return false;
  }
  
  public boolean isOpenInlineC2CTag()
  {
    AppMethodBeat.i(256168);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRq, 0) == 1)
    {
      AppMethodBeat.o(256168);
      return true;
    }
    AppMethodBeat.o(256168);
    return false;
  }
  
  public boolean isOpenInlineSnsTag()
  {
    AppMethodBeat.i(256170);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRr, 0) == 1)
    {
      AppMethodBeat.o(256170);
      return true;
    }
    AppMethodBeat.o(256170);
    return false;
  }
  
  public boolean isUseSysEditText()
  {
    AppMethodBeat.i(256173);
    boolean bool = a.a.hJg().hJd();
    if (bool) {
      com.tencent.mm.ui.widget.cedit.api.b.axG(10);
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRs, com.tencent.mm.util.b.a.YxJ, 1) == 1) || (bool) || (com.tencent.mm.ui.ar.hIY()))
    {
      AppMethodBeat.o(256173);
      return true;
    }
    AppMethodBeat.o(256173);
    return false;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(116521);
    this.mZZ.alive();
    this.soa.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    c.init();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.MVC);
    com.tencent.e.h.ZvG.d(new a(paramc.kcX), "WebSearchThread");
    ai.Tu(5000L);
    ai.Tv(5000L);
    com.tencent.mm.plugin.websearch.api.ar.anq(-1);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.nCC);
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.nCC);
    this.mZZ.dead();
    this.soa.dead();
    this.checkLanguageChangeIListener.dead();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.MVC);
    com.tencent.mm.plugin.websearch.api.am.Pzo = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  public void startImageSearch(o paramo)
  {
    AppMethodBeat.i(256189);
    Object localObject = new Intent();
    int i = getSearchImageRequestType(paramo.fNz, paramo.fyP);
    ((Intent)localObject).putExtra("key_source", paramo.fyP);
    ((Intent)localObject).putExtra("key_scan_goods_request_type", i);
    long l;
    switch (paramo.fyP)
    {
    default: 
      l = com.tencent.mm.plugin.fts.a.d.Sw(67);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
      ((Intent)localObject).putExtra("key_source", paramo.fyP);
      ((Intent)localObject).putExtra("key_msg_id", paramo.fNz.field_msgId);
      ((Intent)localObject).putExtra("key_session_id", l);
      Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s", new Object[] { Long.valueOf(paramo.fNz.field_msgId), Integer.valueOf(paramo.fyP), Long.valueOf(l) });
    }
    for (;;)
    {
      paramo = paramo.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramo, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramo, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(256189);
      return;
      l = com.tencent.mm.plugin.fts.a.d.Sw(81);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
      ((Intent)localObject).putExtra("key_sns_id", paramo.fLp);
      ((Intent)localObject).putExtra("key_sns_username", paramo.PxI);
      ((Intent)localObject).putExtra("key_sns_image_path", paramo.fAh);
      ((Intent)localObject).putExtra("key_session_id", l);
      if (paramo.JVq != null) {}
      try
      {
        ((Intent)localObject).putExtra("key_sns_media", paramo.JVq.toByteArray());
        label397:
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.fLp, paramo.PxI, paramo.fAh, Integer.valueOf(paramo.fyP), Long.valueOf(l) });
        continue;
        ((Intent)localObject).putExtra("key_upload_image_use_cdn_opt", false);
        if (paramo.sessionId != 0L)
        {
          l = paramo.sessionId;
          label474:
          ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
          ((Intent)localObject).putExtra("key_sns_image_path", paramo.fAh);
          ((Intent)localObject).putExtra("key_session_id", l);
          ((Intent)localObject).putExtra("key_source", paramo.fyP);
          if ((paramo.fyP != 15) && (paramo.fyP != 16)) {
            break label624;
          }
          ((Intent)localObject).putExtra("key_scene", paramo.scene);
        }
        for (;;)
        {
          ((Intent)localObject).addFlags(268435456);
          Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.fLp, paramo.PxI, paramo.fAh, Integer.valueOf(paramo.fyP), Long.valueOf(l) });
          break;
          l = com.tencent.mm.plugin.fts.a.d.Sw(17);
          break label474;
          label624:
          ((Intent)localObject).putExtra("key_scene", 83);
        }
        ((Intent)localObject).putExtra("key_upload_image_use_cdn_opt", false);
        if (paramo.sessionId != 0L) {}
        for (l = paramo.sessionId;; l = com.tencent.mm.plugin.fts.a.d.Sw(17))
        {
          ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
          ((Intent)localObject).putExtra("key_sns_image_path", paramo.fAh);
          ((Intent)localObject).putExtra("key_session_id", l);
          ((Intent)localObject).putExtra("key_source", paramo.fyP);
          ((Intent)localObject).putExtra("key_scene", paramo.scene);
          ((Intent)localObject).addFlags(268435456);
          Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.fLp, paramo.PxI, paramo.fAh, Integer.valueOf(paramo.fyP), Long.valueOf(l) });
          break;
        }
      }
      catch (Exception localException)
      {
        break label397;
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean Pxm;
    
    a(boolean paramBoolean)
    {
      this.Pxm = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.Pxm);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */