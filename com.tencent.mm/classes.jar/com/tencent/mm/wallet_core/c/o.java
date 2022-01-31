package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class o
  extends s
{
  public com.tencent.mm.ah.b dmK;
  public com.tencent.mm.ah.f dmL;
  public i lQQ;
  public int quD = 0;
  public String quE = "";
  public int quF = 0;
  public String quG = "";
  public int quH = 0;
  private String wAA = "";
  public String wAB = "";
  public String wAC = "";
  public boolean wAD = false;
  protected String wAE;
  public boolean wAF = false;
  private Map<String, String> wAG = new HashMap();
  public boolean wAH = false;
  
  public final void D(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (localObject1 != null) {
      ((Map)localObject1).remove("uin");
    }
    if (!com.tencent.mm.pluginsdk.wallet.f.cow()) {
      ((Map)localObject1).put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.f.cox());
    }
    this.wAG = ((Map)localObject1);
    L(true, true);
    paramMap = (String)((Map)localObject1).get("req_key");
    this.dmK.Kv().ecM = e.afr(paramMap);
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      paramMap = ((Map)localObject1).keySet().toArray();
      Arrays.sort(paramMap);
      localStringBuilder = new StringBuilder();
      int i = 0;
      int k;
      for (int j = 0; i < paramMap.length; j = k)
      {
        Object localObject2 = paramMap[i];
        String str = (String)((Map)localObject1).get(localObject2);
        k = j;
        if (!bk.bl(str))
        {
          if (j != 0) {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(localObject2);
          localStringBuilder.append("=");
          b(localStringBuilder, str);
          k = 1;
        }
        i += 1;
      }
      if (!com.tencent.mm.sdk.a.b.cqk()) {
        break label406;
      }
      y.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bUs() + ", req = " + localStringBuilder.toString() + " " + toString() + " " + bk.csb().toString());
      localObject1 = Qm(localStringBuilder.toString());
      if (j == 0) {
        break label458;
      }
    }
    label406:
    label458:
    for (paramMap = "&";; paramMap = "")
    {
      localStringBuilder.append(paramMap);
      localStringBuilder.append("WCPaySign");
      localStringBuilder.append("=");
      localStringBuilder.append((String)localObject1);
      paramMap = localStringBuilder.toString().getBytes();
      paramMap = new bmk().bs(paramMap);
      a(this.dmK, paramMap);
      y.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[] { Integer.valueOf(bUs()), Integer.valueOf(getType()), toString(), this.dmK.uri });
      return;
      y.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bUs() + ", req = " + localStringBuilder.toString() + " " + toString());
      break;
    }
  }
  
  public abstract void L(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract String Qm(String paramString);
  
  public abstract void a(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public abstract void a(com.tencent.mm.ah.b paramb, bmk parambmk);
  
  public final void a(PayInfo paramPayInfo, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    a(paramPayInfo, paramMap1, paramMap2, false);
  }
  
  public final void a(PayInfo paramPayInfo, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    Object localObject = paramMap2;
    if (paramMap2 == null) {
      localObject = new HashMap();
    }
    if (paramPayInfo == null)
    {
      y.e("MicroMsg.NetScenePayBase", "Cmd : " + bUs() + ", payInfo is null");
      ((Map)localObject).put("devicename", Build.MODEL);
      aC((Map)localObject);
      return;
    }
    paramMap1.put("req_key", paramPayInfo.bMX);
    paramMap1.put("partner_id", paramPayInfo.partnerId);
    paramMap1.put("pay_sign", paramPayInfo.ccR);
    if (paramPayInfo.soa >= 0) {
      paramMap1.put("auto_deduct_flag", paramPayInfo.soa);
    }
    if (paramPayInfo.bUV > 0) {
      paramMap1.put("pay_scene", paramPayInfo.bUV);
    }
    if (paramPayInfo.bUW >= 0) {
      paramMap1.put("bindbankscene", paramPayInfo.bUW);
    }
    if (!bk.bl(paramPayInfo.sob)) {
      paramMap1.put("deduct_bank_type", paramPayInfo.sob);
    }
    if (!bk.bl(paramPayInfo.soc)) {
      paramMap1.put("deduct_bind_serial", paramPayInfo.soc);
    }
    if (paramBoolean) {
      paramMap1.put("use_touch", "0");
    }
    for (;;)
    {
      paramMap1.put("fp_identify_num", paramPayInfo.qFY);
      if (!TextUtils.isEmpty(paramPayInfo.bOU)) {
        paramMap1.put("encrypted_pay_info", URLEncoder.encode(paramPayInfo.bOU));
      }
      if (!TextUtils.isEmpty(paramPayInfo.bOV)) {
        paramMap1.put("encrypted_rsa_sign", URLEncoder.encode(paramPayInfo.bOV));
      }
      ((Map)localObject).put("uuid", paramPayInfo.dCX);
      ((Map)localObject).put("appid", paramPayInfo.appId);
      ((Map)localObject).put("appsource", paramPayInfo.qLi);
      ((Map)localObject).put("channel", paramPayInfo.bUR);
      ((Map)localObject).put("devicename", Build.MODEL);
      ((Map)localObject).put("soter_req", paramPayInfo.bUA);
      return;
      paramMap1.put("use_touch", paramPayInfo.qFX);
    }
  }
  
  public void a(c paramc, JSONObject paramJSONObject) {}
  
  public final void aB(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (localObject1 != null) {
      ((Map)localObject1).remove("uin");
    }
    if (this.wAG == null) {
      this.wAG = new HashMap();
    }
    if (this.wAG != null) {
      this.wAG.remove("uin");
    }
    paramMap = ((Map)localObject1).keySet().toArray();
    int i = 0;
    while (i < paramMap.length)
    {
      Object localObject2 = paramMap[i];
      String str = (String)((Map)localObject1).get(localObject2);
      if (this.wAG.containsKey(localObject2)) {
        this.wAG.remove(localObject2);
      }
      this.wAG.put((String)localObject2, str);
      i += 1;
    }
    D(this.wAG);
  }
  
  public final void aC(Map<String, String> paramMap)
  {
    L(false, false);
    if (paramMap != null)
    {
      Object localObject1 = com.tencent.mm.plugin.wallet_core.model.i.bVj();
      if (localObject1 != null)
      {
        y.i("MicroMsg.NetScenePayBase", "location found");
        paramMap.put("province", ((aw)localObject1).cCA);
        if (!paramMap.containsKey("city")) {
          paramMap.put("city", ((aw)localObject1).cCB);
        }
        paramMap.put("location_timestamp", ((aw)localObject1).sum);
        paramMap.put("encrypt_key", ((aw)localObject1).suq);
        paramMap.put("encrypt_userinfo", ((aw)localObject1).sup);
        if (com.tencent.mm.plugin.wallet_core.model.i.bVl()) {
          paramMap.put("encrypt_cellinfo", ((aw)localObject1).sur);
        }
      }
      localObject1 = paramMap.keySet().toArray();
      Arrays.sort((Object[])localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      int k;
      for (int j = 0; i < localObject1.length; j = k)
      {
        Object localObject2 = localObject1[i];
        String str = (String)paramMap.get(localObject2);
        k = j;
        if (!bk.bl(str))
        {
          if (j != 0) {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(localObject2);
          localStringBuilder.append("=");
          localStringBuilder.append(str);
          k = 1;
        }
        i += 1;
      }
      if (com.tencent.mm.sdk.a.b.cqk()) {
        y.d("MicroMsg.NetScenePayBase", "Cmd : " + bUs() + ", wxreq = " + localStringBuilder.toString());
      }
      y.d("MicroMsg.NetScenePayBase", "wxreq: " + localStringBuilder.toString());
      paramMap = localStringBuilder.toString().getBytes();
      paramMap = new bmk().bs(paramMap);
      b(this.dmK, paramMap);
    }
  }
  
  public abstract void b(com.tencent.mm.ah.b paramb, bmk parambmk);
  
  public void b(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
  }
  
  public boolean bUL()
  {
    return false;
  }
  
  public abstract int bUs();
  
  public final int bfM()
  {
    return bUs();
  }
  
  public boolean bqc()
  {
    reset();
    return false;
  }
  
  public boolean bqd()
  {
    return true;
  }
  
  public boolean bwh()
  {
    return false;
  }
  
  public final boolean cMv()
  {
    return this.lQQ != null;
  }
  
  public final boolean cMw()
  {
    if (this.wAA == null) {
      return false;
    }
    return "1".equals(this.wAA.trim());
  }
  
  public final String cMx()
  {
    return this.wAE;
  }
  
  public abstract t e(com.tencent.mm.ah.b paramb);
  
  /* Error */
  public final void e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    // Byte code:
    //   0: iload_1
    //   1: istore 6
    //   3: iload_2
    //   4: istore 5
    //   6: getstatic 461	com/tencent/mm/platformtools/ae:eTH	Z
    //   9: ifeq +25 -> 34
    //   12: iload_1
    //   13: istore 6
    //   15: iload_2
    //   16: istore 5
    //   18: sipush 1686
    //   21: aload_0
    //   22: invokevirtual 174	com/tencent/mm/wallet_core/c/o:bUs	()I
    //   25: if_icmpne +9 -> 34
    //   28: iconst_3
    //   29: istore 6
    //   31: iconst_m1
    //   32: istore 5
    //   34: ldc 165
    //   36: ldc_w 463
    //   39: bipush 8
    //   41: anewarray 186	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: invokevirtual 232	com/tencent/mm/wallet_core/c/o:getType	()I
    //   50: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload 4
    //   58: invokeinterface 466 1 0
    //   63: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload 4
    //   71: invokeinterface 469 1 0
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: aload_0
    //   80: invokevirtual 174	com/tencent/mm/wallet_core/c/o:bUs	()I
    //   83: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: iconst_4
    //   89: iload 6
    //   91: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: dup
    //   96: iconst_5
    //   97: iload 5
    //   99: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: bipush 6
    //   106: aload_3
    //   107: aastore
    //   108: dup
    //   109: bipush 7
    //   111: aload_0
    //   112: invokevirtual 187	java/lang/Object:toString	()Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 239	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: aload 4
    //   122: checkcast 103	com/tencent/mm/ah/b
    //   125: invokevirtual 471	com/tencent/mm/wallet_core/c/o:e	(Lcom/tencent/mm/ah/b;)Lcom/tencent/mm/wallet_core/c/t;
    //   128: astore 8
    //   130: aload 8
    //   132: getfield 476	com/tencent/mm/wallet_core/c/t:tlt	I
    //   135: istore_2
    //   136: aload 8
    //   138: getfield 479	com/tencent/mm/wallet_core/c/t:tlu	Ljava/lang/String;
    //   141: astore 11
    //   143: aload 8
    //   145: getfield 482	com/tencent/mm/wallet_core/c/t:wAI	I
    //   148: istore 7
    //   150: aload 8
    //   152: getfield 485	com/tencent/mm/wallet_core/c/t:jxm	Ljava/lang/String;
    //   155: astore 10
    //   157: invokestatic 491	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   160: getstatic 496	com/tencent/mm/plugin/wxpay/a$i:wallet_data_err	I
    //   163: invokevirtual 502	android/content/Context:getString	(I)Ljava/lang/String;
    //   166: astore 4
    //   168: aconst_null
    //   169: astore 9
    //   171: aload 8
    //   173: getfield 506	com/tencent/mm/wallet_core/c/t:tls	Lcom/tencent/mm/protocal/c/bmk;
    //   176: invokestatic 511	com/tencent/mm/platformtools/aa:b	(Lcom/tencent/mm/protocal/c/bmk;)Ljava/lang/String;
    //   179: astore 8
    //   181: aload 8
    //   183: invokestatic 143	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   186: ifne +606 -> 792
    //   189: new 513	org/json/JSONObject
    //   192: dup
    //   193: aload 8
    //   195: invokespecial 514	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   198: astore 9
    //   200: aload 4
    //   202: astore 8
    //   204: aload_0
    //   205: aload 9
    //   207: ldc_w 516
    //   210: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   213: putfield 452	com/tencent/mm/wallet_core/c/o:wAE	Ljava/lang/String;
    //   216: aload 4
    //   218: astore 8
    //   220: aload 9
    //   222: ldc_w 521
    //   225: invokevirtual 524	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   228: istore_1
    //   229: aload 4
    //   231: astore 8
    //   233: aload 9
    //   235: ldc_w 526
    //   238: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore 4
    //   243: aload 4
    //   245: astore 8
    //   247: aload_0
    //   248: aload 9
    //   250: ldc_w 528
    //   253: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: putfield 36	com/tencent/mm/wallet_core/c/o:wAA	Ljava/lang/String;
    //   259: aload 4
    //   261: astore 8
    //   263: aload_0
    //   264: aload 9
    //   266: ldc_w 530
    //   269: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: putfield 38	com/tencent/mm/wallet_core/c/o:wAB	Ljava/lang/String;
    //   275: aload 4
    //   277: astore 8
    //   279: aload_0
    //   280: aload 9
    //   282: ldc_w 532
    //   285: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: putfield 40	com/tencent/mm/wallet_core/c/o:wAC	Ljava/lang/String;
    //   291: aload 4
    //   293: astore 8
    //   295: aload_0
    //   296: aload 9
    //   298: ldc_w 534
    //   301: invokevirtual 537	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   304: putfield 44	com/tencent/mm/wallet_core/c/o:quD	I
    //   307: aload 4
    //   309: astore 8
    //   311: aload_0
    //   312: aload 9
    //   314: ldc_w 539
    //   317: invokevirtual 519	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   320: putfield 46	com/tencent/mm/wallet_core/c/o:quE	Ljava/lang/String;
    //   323: aload 4
    //   325: astore 8
    //   327: aload_0
    //   328: aload 9
    //   330: ldc_w 541
    //   333: invokevirtual 537	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   336: putfield 48	com/tencent/mm/wallet_core/c/o:quF	I
    //   339: aload 4
    //   341: astore 8
    //   343: aload 9
    //   345: ldc_w 543
    //   348: invokevirtual 547	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   351: astore 12
    //   353: aload 12
    //   355: ifnull +362 -> 717
    //   358: aload 4
    //   360: astore 8
    //   362: aload_0
    //   363: aload 12
    //   365: invokevirtual 548	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: putfield 50	com/tencent/mm/wallet_core/c/o:quG	Ljava/lang/String;
    //   371: aload 4
    //   373: astore 8
    //   375: aload_0
    //   376: aload 9
    //   378: ldc_w 550
    //   381: invokevirtual 537	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   384: putfield 52	com/tencent/mm/wallet_core/c/o:quH	I
    //   387: aload 4
    //   389: astore 8
    //   391: aload 9
    //   393: ldc_w 552
    //   396: iconst_0
    //   397: invokevirtual 555	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   400: ifeq +53 -> 453
    //   403: aload 4
    //   405: astore 8
    //   407: invokestatic 561	com/tencent/mm/wallet_core/c/y:cMH	()Lcom/tencent/mm/wallet_core/c/y;
    //   410: pop
    //   411: aload 4
    //   413: astore 8
    //   415: invokestatic 564	com/tencent/mm/wallet_core/c/y:cMG	()Ljava/lang/String;
    //   418: astore 12
    //   420: aload 4
    //   422: astore 8
    //   424: ldc 165
    //   426: ldc_w 566
    //   429: iconst_1
    //   430: anewarray 186	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload 12
    //   437: aastore
    //   438: invokestatic 239	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload 4
    //   443: astore 8
    //   445: invokestatic 561	com/tencent/mm/wallet_core/c/y:cMH	()Lcom/tencent/mm/wallet_core/c/y;
    //   448: aload 12
    //   450: invokevirtual 569	com/tencent/mm/wallet_core/c/y:aff	(Ljava/lang/String;)V
    //   453: aload 4
    //   455: astore 8
    //   457: aload_0
    //   458: aload 9
    //   460: invokestatic 574	com/tencent/mm/wallet_core/c/i:aB	(Lorg/json/JSONObject;)Lcom/tencent/mm/wallet_core/c/i;
    //   463: putfield 440	com/tencent/mm/wallet_core/c/o:lQQ	Lcom/tencent/mm/wallet_core/c/i;
    //   466: aload 4
    //   468: astore 8
    //   470: aload_0
    //   471: iconst_1
    //   472: putfield 54	com/tencent/mm/wallet_core/c/o:wAF	Z
    //   475: aload 10
    //   477: astore 8
    //   479: ldc 165
    //   481: ldc_w 576
    //   484: bipush 13
    //   486: anewarray 186	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: aload_0
    //   492: invokevirtual 232	com/tencent/mm/wallet_core/c/o:getType	()I
    //   495: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: iconst_1
    //   501: aload_0
    //   502: invokevirtual 174	com/tencent/mm/wallet_core/c/o:bUs	()I
    //   505: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   508: aastore
    //   509: dup
    //   510: iconst_2
    //   511: iload 6
    //   513: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: aastore
    //   517: dup
    //   518: iconst_3
    //   519: iload 5
    //   521: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: iconst_4
    //   527: aload_3
    //   528: aastore
    //   529: dup
    //   530: iconst_5
    //   531: iload_2
    //   532: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: aastore
    //   536: dup
    //   537: bipush 6
    //   539: aload 11
    //   541: aastore
    //   542: dup
    //   543: bipush 7
    //   545: iload 7
    //   547: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: aastore
    //   551: dup
    //   552: bipush 8
    //   554: aload 8
    //   556: aastore
    //   557: dup
    //   558: bipush 9
    //   560: iload_1
    //   561: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aastore
    //   565: dup
    //   566: bipush 10
    //   568: aload 4
    //   570: aastore
    //   571: dup
    //   572: bipush 11
    //   574: aload 9
    //   576: aastore
    //   577: dup
    //   578: bipush 12
    //   580: aload_0
    //   581: invokevirtual 187	java/lang/Object:toString	()Ljava/lang/String;
    //   584: aastore
    //   585: invokestatic 239	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: new 578	com/tencent/mm/wallet_core/c/c
    //   591: dup
    //   592: iload 6
    //   594: iload 5
    //   596: aload_3
    //   597: invokespecial 581	com/tencent/mm/wallet_core/c/c:<init>	(IILjava/lang/String;)V
    //   600: astore 16
    //   602: iload 6
    //   604: ifne +303 -> 907
    //   607: iload 5
    //   609: ifne +298 -> 907
    //   612: iload_2
    //   613: ifeq +198 -> 811
    //   616: ldc 165
    //   618: ldc_w 583
    //   621: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 16
    //   626: sipush 1000
    //   629: iload_2
    //   630: aload 11
    //   632: iconst_1
    //   633: invokevirtual 590	com/tencent/mm/wallet_core/c/c:f	(IILjava/lang/String;I)V
    //   636: iload 6
    //   638: ifne +381 -> 1019
    //   641: ldc 165
    //   643: ldc_w 592
    //   646: invokestatic 256	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: aload 9
    //   651: ifnull +910 -> 1561
    //   654: aload 16
    //   656: getfield 595	com/tencent/mm/wallet_core/c/c:errType	I
    //   659: ifne +11 -> 670
    //   662: aload 16
    //   664: getfield 598	com/tencent/mm/wallet_core/c/c:errCode	I
    //   667: ifeq +10 -> 677
    //   670: aload_0
    //   671: invokevirtual 600	com/tencent/mm/wallet_core/c/o:bwh	()Z
    //   674: ifeq +876 -> 1550
    //   677: aload_0
    //   678: aload 16
    //   680: getfield 598	com/tencent/mm/wallet_core/c/c:errCode	I
    //   683: aload 16
    //   685: getfield 603	com/tencent/mm/wallet_core/c/c:aox	Ljava/lang/String;
    //   688: aload 9
    //   690: invokevirtual 605	com/tencent/mm/wallet_core/c/o:a	(ILjava/lang/String;Lorg/json/JSONObject;)V
    //   693: aload_0
    //   694: aload 16
    //   696: aload 9
    //   698: invokevirtual 607	com/tencent/mm/wallet_core/c/o:a	(Lcom/tencent/mm/wallet_core/c/c;Lorg/json/JSONObject;)V
    //   701: aload_0
    //   702: getfield 42	com/tencent/mm/wallet_core/c/o:wAD	Z
    //   705: ifeq +867 -> 1572
    //   708: ldc 165
    //   710: ldc_w 609
    //   713: invokestatic 425	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: return
    //   717: aload 4
    //   719: astore 8
    //   721: aload_0
    //   722: ldc 34
    //   724: putfield 50	com/tencent/mm/wallet_core/c/o:quG	Ljava/lang/String;
    //   727: goto -356 -> 371
    //   730: astore 10
    //   732: aload 8
    //   734: astore 4
    //   736: aload 9
    //   738: astore 8
    //   740: ldc 165
    //   742: new 136	java/lang/StringBuilder
    //   745: dup
    //   746: ldc_w 611
    //   749: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   752: aload 10
    //   754: invokevirtual 612	java/lang/Exception:toString	()Ljava/lang/String;
    //   757: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: sipush -10089
    //   769: istore_1
    //   770: invokestatic 491	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   773: getstatic 615	com/tencent/mm/plugin/wxpay/a$i:wallet_json_err	I
    //   776: invokevirtual 502	android/content/Context:getString	(I)Ljava/lang/String;
    //   779: astore 10
    //   781: aload 8
    //   783: astore 9
    //   785: aload 10
    //   787: astore 8
    //   789: goto -310 -> 479
    //   792: ldc 165
    //   794: ldc_w 617
    //   797: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: sipush -10088
    //   803: istore_1
    //   804: aload 10
    //   806: astore 8
    //   808: goto -329 -> 479
    //   811: iload 7
    //   813: ifeq +27 -> 840
    //   816: ldc 165
    //   818: ldc_w 619
    //   821: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: aload 16
    //   826: sipush 1000
    //   829: iload 7
    //   831: aload 8
    //   833: iconst_2
    //   834: invokevirtual 590	com/tencent/mm/wallet_core/c/c:f	(IILjava/lang/String;I)V
    //   837: goto -201 -> 636
    //   840: iload_1
    //   841: ifeq +55 -> 896
    //   844: ldc 165
    //   846: ldc_w 621
    //   849: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: iload_1
    //   853: sipush -10089
    //   856: if_icmpeq +25 -> 881
    //   859: iload_1
    //   860: sipush -10088
    //   863: if_icmpeq +18 -> 881
    //   866: aload 16
    //   868: sipush 1000
    //   871: iload_1
    //   872: aload 4
    //   874: iconst_2
    //   875: invokevirtual 590	com/tencent/mm/wallet_core/c/c:f	(IILjava/lang/String;I)V
    //   878: goto -242 -> 636
    //   881: aload 16
    //   883: sipush 1000
    //   886: iconst_2
    //   887: aload 4
    //   889: iconst_2
    //   890: invokevirtual 590	com/tencent/mm/wallet_core/c/c:f	(IILjava/lang/String;I)V
    //   893: goto -257 -> 636
    //   896: ldc 165
    //   898: ldc_w 623
    //   901: invokestatic 241	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: goto -268 -> 636
    //   907: ldc 165
    //   909: ldc_w 625
    //   912: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: aload_3
    //   916: ldc_w 626
    //   919: invokestatic 632	com/tencent/mm/sdk/platformtools/bn:s	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   922: astore_3
    //   923: aload_3
    //   924: ifnull +31 -> 955
    //   927: ldc 165
    //   929: ldc_w 634
    //   932: invokestatic 425	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   935: aload 16
    //   937: aload_3
    //   938: ldc_w 636
    //   941: invokeinterface 97 2 0
    //   946: checkcast 99	java/lang/String
    //   949: putfield 603	com/tencent/mm/wallet_core/c/c:aox	Ljava/lang/String;
    //   952: goto -316 -> 636
    //   955: iload 5
    //   957: iconst_m1
    //   958: if_icmpeq +11 -> 969
    //   961: iload 5
    //   963: sipush -500
    //   966: if_icmpne +28 -> 994
    //   969: ldc 165
    //   971: ldc_w 638
    //   974: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload 16
    //   979: invokestatic 491	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   982: getstatic 641	com/tencent/mm/plugin/wxpay/a$i:wallet_net_err	I
    //   985: invokevirtual 502	android/content/Context:getString	(I)Ljava/lang/String;
    //   988: putfield 603	com/tencent/mm/wallet_core/c/c:aox	Ljava/lang/String;
    //   991: goto -355 -> 636
    //   994: ldc 165
    //   996: ldc_w 643
    //   999: invokestatic 586	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: aload 16
    //   1004: invokestatic 491	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1007: getstatic 496	com/tencent/mm/plugin/wxpay/a$i:wallet_data_err	I
    //   1010: invokevirtual 502	android/content/Context:getString	(I)Ljava/lang/String;
    //   1013: putfield 603	com/tencent/mm/wallet_core/c/c:aox	Ljava/lang/String;
    //   1016: goto -380 -> 636
    //   1019: invokestatic 415	com/tencent/mm/plugin/wallet_core/model/i:bVl	()Z
    //   1022: ifne +37 -> 1059
    //   1025: ldc 165
    //   1027: ldc_w 645
    //   1030: invokestatic 256	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: goto -384 -> 649
    //   1036: astore_3
    //   1037: ldc 165
    //   1039: ldc_w 647
    //   1042: iconst_1
    //   1043: anewarray 186	java/lang/Object
    //   1046: dup
    //   1047: iconst_0
    //   1048: aload_3
    //   1049: invokevirtual 650	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1052: aastore
    //   1053: invokestatic 652	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1056: goto -407 -> 649
    //   1059: invokestatic 379	com/tencent/mm/plugin/wallet_core/model/i:bVj	()Lcom/tencent/mm/protocal/c/aw;
    //   1062: astore_3
    //   1063: aload_3
    //   1064: ifnull -415 -> 649
    //   1067: aload_3
    //   1068: getfield 407	com/tencent/mm/protocal/c/aw:suq	Ljava/lang/String;
    //   1071: invokestatic 143	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1074: ifne -425 -> 649
    //   1077: aload_3
    //   1078: getfield 420	com/tencent/mm/protocal/c/aw:sur	Ljava/lang/String;
    //   1081: invokestatic 143	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1084: ifne -435 -> 649
    //   1087: aload_0
    //   1088: invokevirtual 174	com/tencent/mm/wallet_core/c/o:bUs	()I
    //   1091: istore_1
    //   1092: aload_3
    //   1093: getfield 407	com/tencent/mm/protocal/c/aw:suq	Ljava/lang/String;
    //   1096: astore 17
    //   1098: aload_3
    //   1099: getfield 412	com/tencent/mm/protocal/c/aw:sup	Ljava/lang/String;
    //   1102: astore 18
    //   1104: aload_3
    //   1105: getfield 420	com/tencent/mm/protocal/c/aw:sur	Ljava/lang/String;
    //   1108: astore 19
    //   1110: aload 19
    //   1112: invokestatic 143	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1115: ifne -466 -> 649
    //   1118: aload 19
    //   1120: invokevirtual 655	java/lang/String:length	()I
    //   1123: istore_2
    //   1124: ldc 34
    //   1126: astore_3
    //   1127: ldc 34
    //   1129: astore 15
    //   1131: ldc 34
    //   1133: astore 14
    //   1135: ldc 34
    //   1137: astore 13
    //   1139: ldc 34
    //   1141: astore 12
    //   1143: iload_2
    //   1144: sipush 5000
    //   1147: if_icmple +130 -> 1277
    //   1150: ldc 165
    //   1152: ldc_w 657
    //   1155: invokestatic 256	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1158: aload 15
    //   1160: astore 4
    //   1162: aload 14
    //   1164: astore 8
    //   1166: aload 13
    //   1168: astore 10
    //   1170: aload 12
    //   1172: astore 11
    //   1174: ldc 165
    //   1176: ldc_w 659
    //   1179: invokestatic 256	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1182: new 661	com/tencent/mm/h/b/a/i
    //   1185: dup
    //   1186: invokespecial 662	com/tencent/mm/h/b/a/i:<init>	()V
    //   1189: astore 12
    //   1191: aload 12
    //   1193: iload_1
    //   1194: putfield 665	com/tencent/mm/h/b/a/i:chw	I
    //   1197: aload 12
    //   1199: iload 6
    //   1201: putfield 668	com/tencent/mm/h/b/a/i:chx	I
    //   1204: aload 12
    //   1206: iload 5
    //   1208: putfield 671	com/tencent/mm/h/b/a/i:chy	I
    //   1211: aload 12
    //   1213: aload 17
    //   1215: putfield 674	com/tencent/mm/h/b/a/i:chz	Ljava/lang/String;
    //   1218: aload 12
    //   1220: aload 18
    //   1222: putfield 677	com/tencent/mm/h/b/a/i:chA	Ljava/lang/String;
    //   1225: aload 12
    //   1227: iload_2
    //   1228: invokestatic 679	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1231: putfield 682	com/tencent/mm/h/b/a/i:chB	Ljava/lang/String;
    //   1234: aload 12
    //   1236: aload_3
    //   1237: putfield 685	com/tencent/mm/h/b/a/i:chC	Ljava/lang/String;
    //   1240: aload 12
    //   1242: aload 4
    //   1244: putfield 688	com/tencent/mm/h/b/a/i:chD	Ljava/lang/String;
    //   1247: aload 12
    //   1249: aload 8
    //   1251: putfield 691	com/tencent/mm/h/b/a/i:chE	Ljava/lang/String;
    //   1254: aload 12
    //   1256: aload 10
    //   1258: putfield 694	com/tencent/mm/h/b/a/i:chF	Ljava/lang/String;
    //   1261: aload 12
    //   1263: aload 11
    //   1265: putfield 697	com/tencent/mm/h/b/a/i:chG	Ljava/lang/String;
    //   1268: aload 12
    //   1270: invokevirtual 700	com/tencent/mm/h/b/a/i:QX	()Z
    //   1273: pop
    //   1274: goto -625 -> 649
    //   1277: iload_2
    //   1278: sipush 4000
    //   1281: if_icmple +66 -> 1347
    //   1284: aload 19
    //   1286: iconst_0
    //   1287: sipush 1000
    //   1290: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1293: astore_3
    //   1294: aload 19
    //   1296: sipush 1000
    //   1299: sipush 2000
    //   1302: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1305: astore 4
    //   1307: aload 19
    //   1309: sipush 2000
    //   1312: sipush 3000
    //   1315: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1318: astore 8
    //   1320: aload 19
    //   1322: sipush 3000
    //   1325: sipush 4000
    //   1328: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1331: astore 10
    //   1333: aload 19
    //   1335: sipush 4000
    //   1338: iload_2
    //   1339: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1342: astore 11
    //   1344: goto -170 -> 1174
    //   1347: iload_2
    //   1348: sipush 3000
    //   1351: if_icmple +57 -> 1408
    //   1354: aload 19
    //   1356: iconst_0
    //   1357: sipush 1000
    //   1360: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1363: astore_3
    //   1364: aload 19
    //   1366: sipush 1000
    //   1369: sipush 2000
    //   1372: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1375: astore 4
    //   1377: aload 19
    //   1379: sipush 2000
    //   1382: sipush 3000
    //   1385: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1388: astore 8
    //   1390: aload 19
    //   1392: sipush 3000
    //   1395: iload_2
    //   1396: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1399: astore 10
    //   1401: aload 12
    //   1403: astore 11
    //   1405: goto -231 -> 1174
    //   1408: iload_2
    //   1409: sipush 2000
    //   1412: if_icmple +48 -> 1460
    //   1415: aload 19
    //   1417: iconst_0
    //   1418: sipush 1000
    //   1421: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1424: astore_3
    //   1425: aload 19
    //   1427: sipush 1000
    //   1430: sipush 2000
    //   1433: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1436: astore 4
    //   1438: aload 19
    //   1440: sipush 2000
    //   1443: iload_2
    //   1444: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1447: astore 8
    //   1449: aload 12
    //   1451: astore 11
    //   1453: aload 13
    //   1455: astore 10
    //   1457: goto -283 -> 1174
    //   1460: iload_2
    //   1461: sipush 1000
    //   1464: if_icmple +39 -> 1503
    //   1467: aload 19
    //   1469: iconst_0
    //   1470: sipush 1000
    //   1473: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1476: astore_3
    //   1477: aload 19
    //   1479: sipush 1000
    //   1482: iload_2
    //   1483: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1486: astore 4
    //   1488: aload 12
    //   1490: astore 11
    //   1492: aload 13
    //   1494: astore 10
    //   1496: aload 14
    //   1498: astore 8
    //   1500: goto -326 -> 1174
    //   1503: aload 12
    //   1505: astore 11
    //   1507: aload 13
    //   1509: astore 10
    //   1511: aload 14
    //   1513: astore 8
    //   1515: aload 15
    //   1517: astore 4
    //   1519: iload_2
    //   1520: ifle -346 -> 1174
    //   1523: aload 19
    //   1525: iconst_0
    //   1526: iload_2
    //   1527: invokevirtual 704	java/lang/String:substring	(II)Ljava/lang/String;
    //   1530: astore_3
    //   1531: aload 12
    //   1533: astore 11
    //   1535: aload 13
    //   1537: astore 10
    //   1539: aload 14
    //   1541: astore 8
    //   1543: aload 15
    //   1545: astore 4
    //   1547: goto -373 -> 1174
    //   1550: ldc 165
    //   1552: ldc_w 706
    //   1555: invokestatic 241	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1558: goto -865 -> 693
    //   1561: ldc 165
    //   1563: ldc_w 708
    //   1566: invokestatic 241	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1569: goto -876 -> 693
    //   1572: aload_0
    //   1573: getfield 710	com/tencent/mm/wallet_core/c/o:dmL	Lcom/tencent/mm/ah/f;
    //   1576: aload 16
    //   1578: getfield 595	com/tencent/mm/wallet_core/c/c:errType	I
    //   1581: aload 16
    //   1583: getfield 598	com/tencent/mm/wallet_core/c/c:errCode	I
    //   1586: aload 16
    //   1588: getfield 603	com/tencent/mm/wallet_core/c/c:aox	Ljava/lang/String;
    //   1591: aload_0
    //   1592: invokeinterface 716 5 0
    //   1597: return
    //   1598: astore 10
    //   1600: aconst_null
    //   1601: astore 8
    //   1603: goto -863 -> 740
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1606	0	this	o
    //   0	1606	1	paramInt1	int
    //   0	1606	2	paramInt2	int
    //   0	1606	3	paramString	String
    //   0	1606	4	paramq	com.tencent.mm.network.q
    //   4	1203	5	i	int
    //   1	1199	6	j	int
    //   148	682	7	k	int
    //   128	1474	8	localObject1	Object
    //   169	615	9	localObject2	Object
    //   155	321	10	str1	String
    //   730	23	10	localException1	java.lang.Exception
    //   779	759	10	localObject3	Object
    //   1598	1	10	localException2	java.lang.Exception
    //   141	1393	11	localObject4	Object
    //   351	1181	12	localObject5	Object
    //   1137	399	13	str2	String
    //   1133	407	14	str3	String
    //   1129	415	15	str4	String
    //   600	987	16	localc	c
    //   1096	118	17	str5	String
    //   1102	119	18	str6	String
    //   1108	416	19	str7	String
    // Exception table:
    //   from	to	target	type
    //   204	216	730	java/lang/Exception
    //   220	229	730	java/lang/Exception
    //   233	243	730	java/lang/Exception
    //   247	259	730	java/lang/Exception
    //   263	275	730	java/lang/Exception
    //   279	291	730	java/lang/Exception
    //   295	307	730	java/lang/Exception
    //   311	323	730	java/lang/Exception
    //   327	339	730	java/lang/Exception
    //   343	353	730	java/lang/Exception
    //   362	371	730	java/lang/Exception
    //   375	387	730	java/lang/Exception
    //   391	403	730	java/lang/Exception
    //   407	411	730	java/lang/Exception
    //   415	420	730	java/lang/Exception
    //   424	441	730	java/lang/Exception
    //   445	453	730	java/lang/Exception
    //   457	466	730	java/lang/Exception
    //   470	475	730	java/lang/Exception
    //   721	727	730	java/lang/Exception
    //   641	649	1036	java/lang/Exception
    //   1019	1033	1036	java/lang/Exception
    //   1059	1063	1036	java/lang/Exception
    //   1067	1124	1036	java/lang/Exception
    //   1150	1158	1036	java/lang/Exception
    //   1174	1274	1036	java/lang/Exception
    //   1284	1344	1036	java/lang/Exception
    //   1354	1401	1036	java/lang/Exception
    //   1415	1449	1036	java/lang/Exception
    //   1467	1488	1036	java/lang/Exception
    //   1523	1531	1036	java/lang/Exception
    //   189	200	1598	java/lang/Exception
  }
  
  public String getToken()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */