package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ag.d;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.fz;
import com.tencent.mm.h.a.qj;
import com.tencent.mm.h.a.qj.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements j.a
{
  public c ono = new a.2(this);
  private volatile HashMap<String, HashSet<String>> qYJ = new HashMap();
  volatile HashMap<String, HashSet<String>> qYK = new HashMap();
  volatile HashMap<String, HashSet<String>> qYL = new HashMap();
  private volatile HashMap<String, Integer> qYM = new HashMap();
  volatile HashMap<String, Integer> qYN = new HashMap();
  volatile HashMap<String, Integer> qYO = new HashMap();
  public c<fz> qYP = new a.1(this);
  
  public a()
  {
    this.ono.cqo();
    this.qYP.cqo();
    o.Kh().c(this);
  }
  
  public final boolean X(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = aa.s(paramMap, "data");
    int j = bk.e(paramMap.get("webview_instance_id"), -1);
    for (;;)
    {
      JSONArray localJSONArray2;
      int i;
      String str1;
      String str2;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject1);
        localJSONArray2 = new JSONArray();
        localObject1 = null;
        i = 0;
        if (i >= localJSONArray1.length()) {
          break label426;
        }
        paramMap = localJSONArray1.getJSONObject(i);
        str1 = paramMap.optString("id");
        str2 = paramMap.optString("userName");
        int k = paramMap.optInt("type");
        localObject2 = paramMap.optString("imageUrl");
        str3 = paramMap.optString("bigImageUrl");
        paramMap = (Map<String, Object>)localObject2;
        switch (k)
        {
        case 1: 
          o.JQ();
          paramMap = d.A(str2, false);
          if (!e.bK(paramMap)) {
            break;
          }
          y.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
          paramMap = "weixin://fts/avatar?path=" + paramMap;
        case 4: 
        case 64: 
          localObject1 = paramMap;
          if (paramMap == null) {
            break label453;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("id", str1);
          ((JSONObject)localObject1).put("src", paramMap);
          localJSONArray2.put(localObject1);
          localObject1 = null;
        }
      }
      catch (JSONException paramMap)
      {
        String str3;
        y.printErrStackTrace("MicroMsg.FTS.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(j).aZ(-1, "");
        return false;
      }
      paramMap = new com.tencent.mm.ag.h();
      paramMap.username = str2;
      paramMap.ebT = str3;
      paramMap.ebS = ((String)localObject2);
      paramMap.bcw = -1;
      paramMap.cCq = 3;
      paramMap.bK(true);
      o.Kh().a(paramMap);
      continue;
      y.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.qYM.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.qYJ.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.qYJ.put(str2, paramMap);
      a.b.cmd().ch(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label426:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(j).aZ(0, localJSONArray2.toString());
        continue;
        continue;
        label453:
        i += 1;
      }
    }
  }
  
  public final boolean Y(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = aa.s(paramMap, "data");
    int j = bk.e(paramMap.get("webview_instance_id"), -1);
    try
    {
      JSONArray localJSONArray1 = new JSONArray((String)localObject1);
      JSONArray localJSONArray2 = new JSONArray();
      paramMap = null;
      int i = 0;
      for (;;)
      {
        if (i < localJSONArray1.length())
        {
          localObject1 = localJSONArray1.getJSONObject(i);
          String str = ((JSONObject)localObject1).getString("id");
          Object localObject2 = ((JSONObject)localObject1).getString("objectXmlDesc");
          int k = ((JSONObject)localObject1).getInt("index");
          localObject1 = ((m)com.tencent.mm.kernel.g.r(m.class)).nn((String)localObject2);
          if (((bxk)localObject1).tNr.sPJ.size() > k)
          {
            localObject2 = (awd)((bxk)localObject1).tNr.sPJ.get(k);
            localObject1 = new qj();
            ((qj)localObject1).bZJ.bHz = 3;
            ((qj)localObject1).bZJ.bUi = ((awd)localObject2).lsK;
            com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
            y.i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((qj)localObject1).bZJ.path });
            if (e.bK(((qj)localObject1).bZJ.path)) {
              localObject1 = "weixin://fts/sns?path=" + ((qj)localObject1).bZJ.path;
            }
            for (;;)
            {
              paramMap = (Map<String, Object>)localObject1;
              if (localObject1 == null) {
                break;
              }
              paramMap = new JSONObject();
              paramMap.put("id", str);
              paramMap.put("src", localObject1);
              localJSONArray2.put(paramMap);
              paramMap = null;
              break;
              synchronized (this.qYK)
              {
                if (this.qYK.containsKey(((awd)localObject2).lsK))
                {
                  localObject1 = (HashSet)this.qYK.get(((awd)localObject2).lsK);
                  ((HashSet)localObject1).add(str);
                  this.qYK.put(((awd)localObject2).lsK, localObject1);
                  this.qYN.put(((awd)localObject2).lsK, Integer.valueOf(j));
                  localObject1 = new qj();
                  ((qj)localObject1).bZJ.bHz = 1;
                  ((qj)localObject1).bZJ.bZK = ((awd)localObject2);
                  com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
                  localObject1 = paramMap;
                }
                else
                {
                  localObject1 = new HashSet();
                }
              }
            }
          }
        }
        else
        {
          if (localJSONArray2.length() <= 0) {
            break;
          }
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(j).aZ(0, localJSONArray2.toString());
          break;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramMap) {}
  }
  
  /* Error */
  public final boolean Z(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 75
    //   2: ldc_w 356
    //   5: invokestatic 83	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc_w 358
    //   12: iconst_0
    //   13: invokestatic 361	com/tencent/mm/plugin/websearch/api/aa:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   16: istore_2
    //   17: aload_1
    //   18: ldc 85
    //   20: invokestatic 91	com/tencent/mm/plugin/websearch/api/aa:s	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: ldc 93
    //   28: invokeinterface 99 2 0
    //   33: iconst_m1
    //   34: invokestatic 105	com/tencent/mm/sdk/platformtools/bk:e	(Ljava/lang/Object;I)I
    //   37: istore_3
    //   38: invokestatic 367	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   41: invokestatic 373	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   44: istore 5
    //   46: iload_2
    //   47: tableswitch	default:+17 -> 64, 1:+115->162
    //   65: nop
    //   66: dmul
    //   67: dup
    //   68: aload 6
    //   70: invokespecial 110	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: new 107	org/json/JSONArray
    //   77: dup
    //   78: invokespecial 111	org/json/JSONArray:<init>	()V
    //   81: astore 6
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: aload_1
    //   87: invokevirtual 115	org/json/JSONArray:length	()I
    //   90: if_icmpge +683 -> 773
    //   93: aload_1
    //   94: iload_2
    //   95: invokevirtual 119	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   98: astore 9
    //   100: new 123	org/json/JSONObject
    //   103: dup
    //   104: invokespecial 174	org/json/JSONObject:<init>	()V
    //   107: astore 7
    //   109: aload 9
    //   111: ldc 121
    //   113: invokevirtual 268	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 8
    //   118: aload 9
    //   120: ldc 137
    //   122: invokevirtual 268	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 9
    //   127: aload 7
    //   129: ldc 121
    //   131: aload 8
    //   133: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 7
    //   139: ldc 180
    //   141: aload 9
    //   143: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 6
    //   149: aload 7
    //   151: invokevirtual 183	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   154: pop
    //   155: iload_2
    //   156: iconst_1
    //   157: iadd
    //   158: istore_2
    //   159: goto -74 -> 85
    //   162: new 107	org/json/JSONArray
    //   165: dup
    //   166: aload 6
    //   168: invokespecial 110	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: new 107	org/json/JSONArray
    //   176: dup
    //   177: invokespecial 111	org/json/JSONArray:<init>	()V
    //   180: astore 8
    //   182: iconst_0
    //   183: istore_2
    //   184: aconst_null
    //   185: astore_1
    //   186: iload_2
    //   187: aload 7
    //   189: invokevirtual 115	org/json/JSONArray:length	()I
    //   192: if_icmpge +558 -> 750
    //   195: aload 7
    //   197: iload_2
    //   198: invokevirtual 119	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   201: astore 6
    //   203: aload 6
    //   205: ldc_w 375
    //   208: invokevirtual 135	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   211: istore 4
    //   213: aload 6
    //   215: ldc 121
    //   217: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 9
    //   222: iload 4
    //   224: iconst_2
    //   225: if_icmpne +405 -> 630
    //   228: new 377	com/tencent/mm/h/a/fz
    //   231: dup
    //   232: invokespecial 378	com/tencent/mm/h/a/fz:<init>	()V
    //   235: astore 10
    //   237: aload 10
    //   239: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   242: iconst_3
    //   243: putfield 385	com/tencent/mm/h/a/fz$a:bHz	I
    //   246: aload 10
    //   248: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   251: aload 6
    //   253: ldc_w 387
    //   256: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: putfield 390	com/tencent/mm/h/a/fz$a:bIW	Ljava/lang/String;
    //   262: aload 10
    //   264: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   267: aload 6
    //   269: ldc_w 392
    //   272: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: putfield 395	com/tencent/mm/h/a/fz$a:bNm	Ljava/lang/String;
    //   278: aload 10
    //   280: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   283: aload 6
    //   285: ldc_w 397
    //   288: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: putfield 400	com/tencent/mm/h/a/fz$a:aeskey	Ljava/lang/String;
    //   294: aload 10
    //   296: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   299: aload 6
    //   301: ldc_w 402
    //   304: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: putfield 405	com/tencent/mm/h/a/fz$a:bNn	Ljava/lang/String;
    //   310: aload 10
    //   312: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   315: aload 6
    //   317: ldc_w 407
    //   320: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: putfield 410	com/tencent/mm/h/a/fz$a:bJd	Ljava/lang/String;
    //   326: aload 10
    //   328: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   331: aload 6
    //   333: ldc_w 412
    //   336: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   339: putfield 415	com/tencent/mm/h/a/fz$a:name	Ljava/lang/String;
    //   342: aload 10
    //   344: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   347: aload 6
    //   349: ldc 137
    //   351: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: putfield 418	com/tencent/mm/h/a/fz$a:thumbUrl	Ljava/lang/String;
    //   357: getstatic 333	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   360: aload 10
    //   362: invokevirtual 337	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   365: pop
    //   366: aload 10
    //   368: getfield 422	com/tencent/mm/h/a/fz:bNl	Lcom/tencent/mm/h/a/fz$b;
    //   371: getfield 425	com/tencent/mm/h/a/fz$b:path	Ljava/lang/String;
    //   374: invokestatic 155	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   377: ifeq +98 -> 475
    //   380: new 162	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 427
    //   387: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload 10
    //   392: getfield 422	com/tencent/mm/h/a/fz:bNl	Lcom/tencent/mm/h/a/fz$b;
    //   395: getfield 425	com/tencent/mm/h/a/fz$b:path	Ljava/lang/String;
    //   398: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: astore 6
    //   406: ldc 75
    //   408: ldc_w 429
    //   411: iconst_1
    //   412: anewarray 4	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: aload 10
    //   419: getfield 422	com/tencent/mm/h/a/fz:bNl	Lcom/tencent/mm/h/a/fz$b;
    //   422: getfield 425	com/tencent/mm/h/a/fz$b:path	Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 160	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload 6
    //   431: astore_1
    //   432: aload 6
    //   434: ifnull +357 -> 791
    //   437: new 123	org/json/JSONObject
    //   440: dup
    //   441: invokespecial 174	org/json/JSONObject:<init>	()V
    //   444: astore_1
    //   445: aload_1
    //   446: ldc 121
    //   448: aload 9
    //   450: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload_1
    //   455: ldc 180
    //   457: aload 6
    //   459: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 8
    //   465: aload_1
    //   466: invokevirtual 183	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   469: pop
    //   470: aconst_null
    //   471: astore_1
    //   472: goto +319 -> 791
    //   475: iload 5
    //   477: ifeq +141 -> 618
    //   480: aload_0
    //   481: getfield 48	com/tencent/mm/plugin/webview/fts/a:qYL	Ljava/util/HashMap;
    //   484: astore 11
    //   486: aload 11
    //   488: monitorenter
    //   489: aload_0
    //   490: getfield 48	com/tencent/mm/plugin/webview/fts/a:qYL	Ljava/util/HashMap;
    //   493: aload 10
    //   495: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   498: getfield 390	com/tencent/mm/h/a/fz$a:bIW	Ljava/lang/String;
    //   501: invokevirtual 347	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   504: ifeq +96 -> 600
    //   507: aload_0
    //   508: getfield 48	com/tencent/mm/plugin/webview/fts/a:qYL	Ljava/util/HashMap;
    //   511: aload 10
    //   513: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   516: getfield 390	com/tencent/mm/h/a/fz$a:bIW	Ljava/lang/String;
    //   519: invokevirtual 240	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   522: checkcast 242	java/util/HashSet
    //   525: astore 6
    //   527: aload 6
    //   529: aload 9
    //   531: invokevirtual 247	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   534: pop
    //   535: aload_0
    //   536: getfield 48	com/tencent/mm/plugin/webview/fts/a:qYL	Ljava/util/HashMap;
    //   539: aload 10
    //   541: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   544: getfield 390	com/tencent/mm/h/a/fz$a:bIW	Ljava/lang/String;
    //   547: aload 6
    //   549: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   552: pop
    //   553: aload_0
    //   554: getfield 50	com/tencent/mm/plugin/webview/fts/a:qYO	Ljava/util/HashMap;
    //   557: aload 10
    //   559: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   562: getfield 390	com/tencent/mm/h/a/fz$a:bIW	Ljava/lang/String;
    //   565: iload_3
    //   566: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   572: pop
    //   573: aload 11
    //   575: monitorexit
    //   576: aload 10
    //   578: getfield 382	com/tencent/mm/h/a/fz:bNk	Lcom/tencent/mm/h/a/fz$a;
    //   581: iconst_1
    //   582: putfield 385	com/tencent/mm/h/a/fz$a:bHz	I
    //   585: getstatic 333	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   588: aload 10
    //   590: invokevirtual 337	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   593: pop
    //   594: aload_1
    //   595: astore 6
    //   597: goto -168 -> 429
    //   600: new 242	java/util/HashSet
    //   603: dup
    //   604: invokespecial 243	java/util/HashSet:<init>	()V
    //   607: astore 6
    //   609: goto -82 -> 527
    //   612: astore_1
    //   613: aload 11
    //   615: monitorexit
    //   616: aload_1
    //   617: athrow
    //   618: aload 6
    //   620: ldc 137
    //   622: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   625: astore 6
    //   627: goto -198 -> 429
    //   630: iload 4
    //   632: iconst_4
    //   633: if_icmpne +72 -> 705
    //   636: new 123	org/json/JSONObject
    //   639: dup
    //   640: invokespecial 174	org/json/JSONObject:<init>	()V
    //   643: astore 10
    //   645: aload 10
    //   647: ldc 121
    //   649: aload 9
    //   651: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: iload 5
    //   657: ifeq +30 -> 687
    //   660: aload 10
    //   662: ldc 180
    //   664: aload 6
    //   666: ldc_w 431
    //   669: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   672: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   675: pop
    //   676: aload 8
    //   678: aload 10
    //   680: invokevirtual 183	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   683: pop
    //   684: goto +107 -> 791
    //   687: aload 10
    //   689: ldc 180
    //   691: aload 6
    //   693: ldc 137
    //   695: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   698: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   701: pop
    //   702: goto -26 -> 676
    //   705: new 123	org/json/JSONObject
    //   708: dup
    //   709: invokespecial 174	org/json/JSONObject:<init>	()V
    //   712: astore 10
    //   714: aload 10
    //   716: ldc 121
    //   718: aload 9
    //   720: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload 10
    //   726: ldc 180
    //   728: aload 6
    //   730: ldc 137
    //   732: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload 8
    //   741: aload 10
    //   743: invokevirtual 183	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   746: pop
    //   747: goto +44 -> 791
    //   750: aload 8
    //   752: invokevirtual 115	org/json/JSONArray:length	()I
    //   755: ifle +44 -> 799
    //   758: iload_3
    //   759: invokestatic 222	com/tencent/mm/plugin/webview/ui/tools/jsapi/h:Db	(I)Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/g;
    //   762: iconst_0
    //   763: aload 8
    //   765: invokevirtual 260	org/json/JSONArray:toString	()Ljava/lang/String;
    //   768: invokevirtual 228	com/tencent/mm/plugin/webview/ui/tools/jsapi/g:aZ	(ILjava/lang/String;)V
    //   771: iconst_0
    //   772: ireturn
    //   773: iload_3
    //   774: invokestatic 222	com/tencent/mm/plugin/webview/ui/tools/jsapi/h:Db	(I)Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/g;
    //   777: iconst_0
    //   778: aload 6
    //   780: invokevirtual 260	org/json/JSONArray:toString	()Ljava/lang/String;
    //   783: invokevirtual 228	com/tencent/mm/plugin/webview/ui/tools/jsapi/g:aZ	(ILjava/lang/String;)V
    //   786: iconst_0
    //   787: ireturn
    //   788: astore_1
    //   789: iconst_0
    //   790: ireturn
    //   791: iload_2
    //   792: iconst_1
    //   793: iadd
    //   794: istore_2
    //   795: goto -609 -> 186
    //   798: astore_1
    //   799: iconst_0
    //   800: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	this	a
    //   0	801	1	paramMap	Map<String, Object>
    //   16	779	2	i	int
    //   37	737	3	j	int
    //   211	423	4	k	int
    //   44	612	5	bool	boolean
    //   23	756	6	localObject1	Object
    //   107	89	7	localObject2	Object
    //   116	648	8	localObject3	Object
    //   98	621	9	localObject4	Object
    //   235	507	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   489	527	612	finally
    //   527	576	612	finally
    //   600	609	612	finally
    //   613	616	612	finally
    //   64	83	788	org/json/JSONException
    //   85	155	788	org/json/JSONException
    //   773	786	788	org/json/JSONException
    //   162	182	798	java/lang/Exception
    //   186	222	798	java/lang/Exception
    //   228	429	798	java/lang/Exception
    //   437	470	798	java/lang/Exception
    //   480	489	798	java/lang/Exception
    //   576	594	798	java/lang/Exception
    //   616	618	798	java/lang/Exception
    //   618	627	798	java/lang/Exception
    //   636	655	798	java/lang/Exception
    //   660	676	798	java/lang/Exception
    //   676	684	798	java/lang/Exception
    //   687	702	798	java/lang/Exception
    //   705	747	798	java/lang/Exception
    //   750	771	798	java/lang/Exception
  }
  
  public final void a(String paramString, l paraml)
  {
    if ((paraml == null) || (paraml.obj == null)) {
      return;
    }
    for (;;)
    {
      int i;
      String str1;
      Object localObject2;
      String str2;
      synchronized (this.qYJ)
      {
        y.i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paraml.toString() });
        paramString = paraml.obj.toString();
        if ((this.qYJ.containsKey(paramString)) && (this.qYM.containsKey(paramString)))
        {
          y.i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.qYM.get(paramString)).intValue();
          Object localObject1 = (HashSet)this.qYJ.get(paramString);
          paraml = new JSONArray();
          localObject1 = ((HashSet)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            o.JQ();
            localObject2 = d.A(paramString, false);
            str2 = "weixin://fts/avatar?path=" + (String)localObject2;
            localObject2 = new JSONObject();
          }
        }
      }
      try
      {
        ((JSONObject)localObject2).put("id", str1);
        ((JSONObject)localObject2).put("src", str2);
        label214:
        paraml.put(localObject2);
        continue;
        paramString = finally;
        throw paramString;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(i).aZ(0, paraml.toString());
        this.qYJ.remove(paramString);
        this.qYM.remove(paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label214;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */