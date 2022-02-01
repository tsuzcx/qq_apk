package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cb;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.autogen.a.nv;
import com.tencent.mm.autogen.a.nv.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.util.b.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginWebSearch
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.websearch.api.c
{
  static final int[] Wnq;
  private static HashMap<Integer, h.b> fjr;
  private t TIf;
  private b Wno;
  private c Wnp;
  private final IListener checkLanguageChangeIListener;
  private IListener pWI;
  private com.tencent.mm.plugin.teenmode.a.g qCv;
  private IListener vzY;
  
  static
  {
    AppMethodBeat.i(116525);
    fjr = new HashMap();
    String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    fjr.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return PluginWebSearch.this;
      }
    });
    Wnq = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new IListener(com.tencent.mm.app.f.hfK) {};
    this.pWI = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static boolean a(cd paramAnonymouscd)
      {
        AppMethodBeat.i(116512);
        long l;
        if (paramAnonymouscd != null)
        {
          int i;
          com.tencent.mm.plugin.websearch.api.au localau;
          int k;
          if ((paramAnonymouscd.hCg.hCh == 27) && (paramAnonymouscd.hCg.subType == 1))
          {
            i = 0;
            localau = aj.asW(i);
            l = localau.Wqf;
            PluginWebSearch.access$100(l, 0L, 1L, false);
            k = com.tencent.mm.plugin.websearch.api.au.biD(paramAnonymouscd.hCg.filePath);
            if (k != 1) {
              break label442;
            }
            PluginWebSearch.access$100(l, 1L, 1L, false);
          }
          label442:
          for (;;)
          {
            label79:
            if (k >= localau.bIG())
            {
              PluginWebSearch.access$100(l, 4L, 1L, false);
              int j = 0;
              for (;;)
              {
                if (j < 3)
                {
                  localau.biC(paramAnonymouscd.hCg.filePath);
                  if (!localau.iqu())
                  {
                    Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
                    j += 1;
                    continue;
                    if ((paramAnonymouscd.hCg.hCh == 27) && (paramAnonymouscd.hCg.subType == 2))
                    {
                      i = 1;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 62) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 2;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 40) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 3;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 64) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 4;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 66) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 5;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 79) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 6;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 85) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 7;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 84) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 8;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 95) && (paramAnonymouscd.hCg.subType == 1))
                    {
                      i = 9;
                      break;
                    }
                    if ((paramAnonymouscd.hCg.hCh == 79) && (paramAnonymouscd.hCg.subType == 2))
                    {
                      i = 10;
                      break;
                    }
                    AppMethodBeat.o(116512);
                    return false;
                    PluginWebSearch.access$100(l, 2L, 1L, false);
                    break label79;
                  }
                }
              }
              if (localau.iqu())
              {
                PluginWebSearch.access$100(l, 6L, 1L, false);
                Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(k) });
                if (i == 0) {
                  aj.ipV();
                }
                as.atg(i);
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(116512);
          return false;
          PluginWebSearch.access$100(l, 5L, 1L, false);
          Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          PluginWebSearch.access$100(l, 3L, 1L, false);
        }
      }
    };
    this.vzY = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static boolean a(nv paramAnonymousnv)
      {
        int i = 1;
        AppMethodBeat.i(116514);
        if ((paramAnonymousnv.hQr.hCh == 27) && (paramAnonymousnv.hQr.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          aj.asW(i).biC(paramAnonymousnv.hQr.filePath);
          if (i == 0) {
            aj.ipV();
          }
          AppMethodBeat.o(116514);
          return false;
          if ((paramAnonymousnv.hQr.hCh != 27) || (paramAnonymousnv.hQr.subType != 2)) {
            if ((paramAnonymousnv.hQr.hCh == 62) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymousnv.hQr.hCh == 40) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymousnv.hQr.hCh == 64) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 4;
            }
            else if ((paramAnonymousnv.hQr.hCh == 66) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 5;
            }
            else if ((paramAnonymousnv.hQr.hCh == 79) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 6;
            }
            else if ((paramAnonymousnv.hQr.hCh == 85) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 7;
            }
            else if ((paramAnonymousnv.hQr.hCh == 84) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 8;
            }
            else if ((paramAnonymousnv.hQr.hCh == 95) && (paramAnonymousnv.hQr.subType == 1))
            {
              i = 9;
            }
            else
            {
              if ((paramAnonymousnv.hQr.hCh != 79) || (paramAnonymousnv.hQr.subType != 2)) {
                break;
              }
              i = 10;
            }
          }
        }
        AppMethodBeat.o(116514);
        return false;
      }
    };
    this.TIf = new PluginWebSearch.6(this);
    this.qCv = new com.tencent.mm.plugin.teenmode.a.g()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(315031);
        al.cj(20, true);
        AppMethodBeat.o(315031);
      }
    };
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int j = 0;
    com.tencent.mm.plugin.websearch.api.au localau;
    int i;
    int k;
    if (j < 11)
    {
      localau = aj.asW(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }[j]);
      i = localau.bIH();
      localau.iqn();
      k = localau.bIG();
      if (k == 1)
      {
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localau.iqv();
      }
      if (!localau.iqu())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localau.iqv();
            if (!localau.iqu())
            {
              i += 1;
              continue;
              if (k >= i) {
                break label269;
              }
              Log.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localau.iqu())
      {
        Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        reportIdKey(localau.Wqf, 7L, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label269:
      i = 0;
    }
  }
  
  private int getSearchImageRequestType(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(315014);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(315014);
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      if (paramcc != null)
      {
        if (com.tencent.mm.storage.au.bwE(paramcc.field_talker))
        {
          AppMethodBeat.o(315014);
          return 4;
        }
        AppMethodBeat.o(315014);
        return 3;
      }
      break;
    case 9: 
      AppMethodBeat.o(315014);
      return 9;
    case 7: 
    case 8: 
      AppMethodBeat.o(315014);
      return 7;
    case 5: 
    case 10: 
      AppMethodBeat.o(315014);
      return 5;
    case 6: 
      AppMethodBeat.o(315014);
      return 6;
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
      AppMethodBeat.o(315014);
      return 11;
    }
    AppMethodBeat.o(315014);
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
        int[] arrayOfInt = PluginWebSearch.Wnq;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(k);
          i += 1;
        }
        AppMethodBeat.o(116511);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  private static List<String> optListFromJSONStr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(315011);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(315011);
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
        AppMethodBeat.o(315011);
        return paramString2;
      }
    }
    finally
    {
      Log.e("MicroMsg.WebSearch.PluginWebSearch", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(315011);
    }
    return null;
  }
  
  private static void reportIdKey(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(315004);
    if (paramLong1 > 0L) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    }
    AppMethodBeat.o(315004);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return fjr;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.Wno = new b();
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.Wno));
    com.tencent.mm.kernel.h.a(j.class, new com.tencent.mm.kernel.c.e(new d()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.h.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      this.Wnp = new c();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.Wnp));
    }
    AppMethodBeat.o(116520);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(315050);
    dependsOn(com.tencent.mm.plugin.teenmode.a.c.class);
    AppMethodBeat.o(315050);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getExposedWord(String paramString)
  {
    AppMethodBeat.i(315086);
    try
    {
      Object localObject = new JSONObject(" { \"exposedWords\": { \"express\": { \"zh_CN\": \"查快递\", \"zh_HK\": \"查快遞\", \"zh_TW\": \"查快遞\", \"en\": \"express\" } } }").optJSONObject("exposedWords");
      if (localObject == null)
      {
        AppMethodBeat.o(315086);
        return "";
      }
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject(paramString);
      if (localJSONObject == null)
      {
        AppMethodBeat.o(315086);
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
      AppMethodBeat.o(315086);
      return localObject;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", localThrowable, "getExposedWord:%s", new Object[] { paramString });
      AppMethodBeat.o(315086);
    }
    return "";
  }
  
  public List<String> getNeedReuseBrands()
  {
    AppMethodBeat.i(315088);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkc, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseBrands");
    AppMethodBeat.o(315088);
    return localList;
  }
  
  public List<String> getNeedReuseItems()
  {
    AppMethodBeat.i(315093);
    List localList = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkc, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseItems");
    AppMethodBeat.o(315093);
    return localList;
  }
  
  public int getSosLimitLength()
  {
    AppMethodBeat.i(315084);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkb, 100);
    AppMethodBeat.o(315084);
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
    AppMethodBeat.i(315064);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjV, 0) == 1)
    {
      AppMethodBeat.o(315064);
      return true;
    }
    AppMethodBeat.o(315064);
    return false;
  }
  
  public boolean isOpenInlineC2CTag()
  {
    return true;
  }
  
  public boolean isOpenInlineSnsTag()
  {
    return true;
  }
  
  public boolean isUseSysEditText()
  {
    AppMethodBeat.i(315083);
    boolean bool = a.a.jlv().jls();
    if (bool) {
      com.tencent.mm.ui.widget.cedit.api.b.aEp(10);
    }
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zka, b.a.agqt, 1) == 1) || (bool) || (aw.jln()))
    {
      AppMethodBeat.o(315083);
      return true;
    }
    AppMethodBeat.o(315083);
    return false;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(116521);
    this.pWI.alive();
    this.vzY.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    c.init();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.TIf);
    com.tencent.threadpool.h.ahAA.g(new a(paramc.mDg), "WebSearchThread");
    as.atg(-1);
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(this.qCv);
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b(this.qCv);
    this.pWI.dead();
    this.vzY.dead();
    this.checkLanguageChangeIListener.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.TIf);
    com.tencent.mm.plugin.websearch.api.an.Wpx = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  public void startImageSearch(o paramo)
  {
    AppMethodBeat.i(315102);
    Object localObject = new Intent();
    int i = getSearchImageRequestType(paramo.hTm, paramo.hDy);
    ((Intent)localObject).putExtra("key_source", paramo.hDy);
    ((Intent)localObject).putExtra("key_scan_goods_request_type", i);
    long l;
    switch (paramo.hDy)
    {
    case 16: 
    default: 
      l = com.tencent.mm.plugin.fts.a.d.Wd(67);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
      ((Intent)localObject).putExtra("key_source", paramo.hDy);
      ((Intent)localObject).putExtra("key_msg_id", paramo.hTm.field_msgId);
      ((Intent)localObject).putExtra("key_session_id", l);
      Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s", new Object[] { Long.valueOf(paramo.hTm.field_msgId), Integer.valueOf(paramo.hDy), Long.valueOf(l) });
    }
    for (;;)
    {
      paramo = paramo.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramo, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramo, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(315102);
      return;
      l = com.tencent.mm.plugin.fts.a.d.Wd(81);
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
      ((Intent)localObject).putExtra("key_sns_id", paramo.hQX);
      ((Intent)localObject).putExtra("key_sns_username", paramo.WnO);
      ((Intent)localObject).putExtra("key_sns_image_path", paramo.hET);
      ((Intent)localObject).putExtra("key_session_id", l);
      if (paramo.Qsr != null) {}
      try
      {
        ((Intent)localObject).putExtra("key_sns_media", paramo.Qsr.toByteArray());
        label413:
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.hQX, paramo.WnO, paramo.hET, Integer.valueOf(paramo.hDy), Long.valueOf(l) });
        continue;
        ((Intent)localObject).putExtra("key_upload_image_use_cdn_opt", false);
        if (paramo.sessionId != 0L)
        {
          l = paramo.sessionId;
          label490:
          ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
          ((Intent)localObject).putExtra("key_sns_image_path", paramo.hET);
          ((Intent)localObject).putExtra("key_session_id", l);
          ((Intent)localObject).putExtra("key_source", paramo.hDy);
          if ((paramo.hDy != 15) && (paramo.hDy != 16) && (paramo.hDy != 18) && (paramo.hDy != 19) && (paramo.hDy != 20) && (paramo.hDy != 21)) {
            break label676;
          }
          ((Intent)localObject).putExtra("key_scene", paramo.scene);
        }
        for (;;)
        {
          ((Intent)localObject).addFlags(268435456);
          Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.hQX, paramo.WnO, paramo.hET, Integer.valueOf(paramo.hDy), Long.valueOf(l) });
          break;
          l = com.tencent.mm.plugin.fts.a.d.Wd(17);
          break label490;
          label676:
          ((Intent)localObject).putExtra("key_scene", 83);
        }
        ((Intent)localObject).putExtra("key_upload_image_use_cdn_opt", false);
        if (paramo.sessionId != 0L) {}
        for (l = paramo.sessionId;; l = com.tencent.mm.plugin.fts.a.d.Wd(17))
        {
          ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
          ((Intent)localObject).putExtra("key_sns_image_path", paramo.hET);
          ((Intent)localObject).putExtra("key_session_id", l);
          ((Intent)localObject).putExtra("key_source", paramo.hDy);
          ((Intent)localObject).putExtra("key_scene", paramo.scene);
          ((Intent)localObject).addFlags(268435456);
          Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", new Object[] { paramo.hQX, paramo.WnO, paramo.hET, Integer.valueOf(paramo.hDy), Long.valueOf(l) });
          break;
        }
      }
      catch (Exception localException)
      {
        break label413;
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean Wns;
    
    a(boolean paramBoolean)
    {
      this.Wns = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$200(PluginWebSearch.this, this.Wns);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */