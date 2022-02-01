package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.a;
import kotlin.n.i;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/GetURLKey;", "", "()V", "domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getDomainHashMap$webview_sdk_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap$webview_sdk_release", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "urlHashCache", "getUrlHashCache$webview_sdk_release", "setUrlHashCache$webview_sdk_release", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "withProtocol", "getWithProtocol", "clearShortUrl", "rawUrl", "ignoreHashTag", "", "getDomainId", "domain", "fetch", "getKeyURL", "url", "itemshowtype", "", "getShortUrlId", "getURL", "prefetch", "getUrlKeyForTeemMode", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clearUrlParam", "param", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c XsF;
  private static ConcurrentHashMap<String, String> vQr;
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> vQt;
  
  static
  {
    AppMethodBeat.i(295804);
    XsF = new c();
    vQr = new ConcurrentHashMap();
    vQt = new ConcurrentHashMap();
    AppMethodBeat.o(295804);
  }
  
  private static String bmU(String paramString)
  {
    AppMethodBeat.i(295785);
    s.u(paramString, "url");
    Object localObject1 = clearUrlParams(n.rt(paramString, "#"), new String[] { "from", "isappinstalled", "pass_ticket", "exportKey" });
    Object localObject2 = (String)localObject1 + '-' + false;
    String str1;
    StringBuilder localStringBuilder;
    int i;
    String str2;
    for (;;)
    {
      try
      {
        if (vQr.containsKey(localObject2))
        {
          paramString = (String)ak.e((Map)vQr, localObject2);
          return paramString;
        }
        paramString = ah.aiuX;
        paramString = getHost((String)localObject1);
        s.u(paramString, "domain");
        str1 = "_domain_" + paramString.hashCode();
        localStringBuilder = new StringBuilder("");
        i = 0;
        if (i >= 3) {
          break label494;
        }
        str2 = new String[] { "__biz", "mid", "idx" }[i];
        s.u(localObject1, "<this>");
        s.u(str2, "param");
        paramString = kotlin.n.k.a(new kotlin.n.k("(?<=" + str2 + "=).+?(?=&)"), (CharSequence)localObject1);
        if (paramString == null)
        {
          paramString = null;
          if (paramString != null) {
            break label409;
          }
          paramString = bmT((String)localObject1);
          s.u(paramString, "url");
          if (!MMApplicationContext.isMainProcess()) {
            break label363;
          }
          h.baC();
          i = b.getUin();
          localObject2 = MultiProcessMMKV.getMMKV(s.X("mpRelateData_", Integer.valueOf(i)), 2);
          s.s(localObject2, "getMMKV(\"${BizConstants.…sMMKV.MULTI_PROCESS_MODE)");
          localObject2 = ((MultiProcessMMKV)localObject2).decodeString(s.X("short_url_", paramString), "");
          s.s(localObject2, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
          if (Util.isNullOrNil((String)localObject2)) {
            break;
          }
          ((Map)vQr).put(localObject1, localObject2);
          AppMethodBeat.o(295785);
          return localObject2;
        }
      }
      finally
      {
        AppMethodBeat.o(295785);
      }
      paramString = paramString.getValue();
      continue;
      label363:
      i = b.aZP();
    }
    paramString = Integer.toString(s.X("not_matched_", Integer.valueOf(bmW(paramString))).hashCode(), a.aMy(16));
    s.s(paramString, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    AppMethodBeat.o(295785);
    return paramString;
    label409:
    if (str2.equals("idx")) {
      localStringBuilder.append(str2 + '=' + paramString);
    }
    for (;;)
    {
      i += 1;
      break;
      localStringBuilder.append(str2 + '=' + paramString + '|');
    }
    label494:
    paramString = localStringBuilder.toString();
    s.s(paramString, "key.toString()");
    if (!vQt.containsKey(str1)) {
      ((Map)vQt).put(str1, new ConcurrentLinkedDeque());
    }
    localObject1 = vQt.get(str1);
    s.checkNotNull(localObject1);
    ((ConcurrentLinkedDeque)localObject1).add(localObject2);
    ((Map)vQr).put(localObject2, paramString);
    AppMethodBeat.o(295785);
    return paramString;
  }
  
  private static final int bmW(String paramString)
  {
    AppMethodBeat.i(295799);
    try
    {
      i = Uri.parse(paramString).toString().hashCode();
      AppMethodBeat.o(295799);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("hashUrl", (Throwable)localException, "hash url %s", new Object[] { paramString });
        int i = 0;
      }
    }
  }
  
  private static String clearUrlParams(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(295765);
    s.u(paramString, "<this>");
    s.u(paramVarArgs, "param");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    try
    {
      Uri localUri = Uri.parse(paramString);
      localObject1 = localUri.getQueryParameterNames();
      s.s(localObject1, "uri.queryParameterNames");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!kotlin.a.k.contains(paramVarArgs, (String)localObject3))
        {
          ((Collection)localObject1).add(localObject3);
          continue;
          AppMethodBeat.o(295765);
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("String", "clearUrlParams:" + localException.getMessage() + ", " + paramVarArgs + ", " + paramString);
    }
    for (;;)
    {
      return paramString;
      localObject2 = (Iterable)p.n((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((Collection)localObject1).add(localObject3 + '=' + localException.getQueryParameter((String)localObject3));
      }
      localObject1 = p.a((Iterable)localObject1, (CharSequence)"&", null, null, 0, null, null, 62);
      String str = localException.getScheme() + "://" + localException.getHost() + localException.getPath() + '?' + (String)localObject1;
      paramString = str;
    }
  }
  
  private static String getHost(String paramString)
  {
    AppMethodBeat.i(295749);
    s.u(paramString, "<this>");
    for (;;)
    {
      try
      {
        s.u(paramString, "<this>");
        str = paramString;
        if (!n.U(paramString, "http", false))
        {
          if (!n.a((CharSequence)paramString, (CharSequence)"view.inews.qq.com", false)) {
            continue;
          }
          str = s.X("https://", paramString);
        }
        str = Uri.parse(str).getHost();
        paramString = str;
        if (str == null) {
          paramString = "unknow";
        }
      }
      catch (Exception paramString)
      {
        String str;
        paramString = "unknow";
        continue;
      }
      AppMethodBeat.o(295749);
      return paramString;
      str = s.X("http://", paramString);
    }
  }
  
  public final String bmV(String paramString)
  {
    AppMethodBeat.i(295813);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295813);
      return "";
    }
    localObject = (com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
    if ((localObject != null) && (((com.tencent.mm.plugin.brandservice.api.c)localObject).aiy(paramString) == true)) {}
    for (i = 1; (i != 0) && (n.a((CharSequence)paramString, (CharSequence)"__biz", true)) && (n.a((CharSequence)paramString, (CharSequence)"mid", true)) && (n.a((CharSequence)paramString, (CharSequence)"idx", true)); i = 0)
    {
      paramString = bmU(paramString);
      AppMethodBeat.o(295813);
      return paramString;
    }
    paramString = MD5Util.getMD5String(paramString);
    s.s(paramString, "{\n            MD5Util.getMD5String(url)\n        }");
    AppMethodBeat.o(295813);
    return paramString;
  }
  
  public final String ih(String paramString, int paramInt)
  {
    AppMethodBeat.i(295808);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(295808);
      return "";
    }
    if (-1 == paramInt)
    {
      paramString = bmU(String.valueOf(paramString));
      AppMethodBeat.o(295808);
      return paramString;
    }
    paramString = bmU(String.valueOf(paramString)) + "|itemShowType=" + paramInt;
    AppMethodBeat.o(295808);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.c
 * JD-Core Version:    0.7.0.1
 */