package com.tencent.mm.plugin.topstory.ui.video;

import android.webkit.URLUtil;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.network.y;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public com.tencent.mm.al.g gWw;
  public b yOm;
  public boolean yPY;
  public int yPZ;
  k yQa;
  private int yQb;
  private int yQc;
  public com.tencent.mm.plugin.topstory.a.c.h yQd;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousn });
        if (paramAnonymousn.equals(n.this.yQa))
        {
          com.tencent.mm.kernel.g.aeS().b(1943, n.this.gWw);
          n.this.yQa = null;
          paramAnonymousn = (k)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousn.dOd().DLy });
            a.lI(2);
            n.this.yOm.asH(paramAnonymousString);
            n.this.yPY = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousn.dOd().DLy);
          if (paramAnonymousn.yLX.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.e.h.Iye.f(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousn.equals(n.this.yQd))
        {
          com.tencent.mm.kernel.g.aeS().b(1943, n.this.gWw);
          n.this.yQd = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.lI(2);
            AppMethodBeat.o(126123);
            return;
          }
          ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.dOd().DLy });
          com.tencent.e.h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.dOd().DLy).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.yOm.dOQ(), (JSONArray)localObject);
                  paramAnonymousString.yLY.EuY.Eus.addAll((Collection)localObject);
                  ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "netSceneTopStoryRelevantVideo add result list %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
                }
                AppMethodBeat.o(126122);
                return;
              }
              catch (Exception localException)
              {
                AppMethodBeat.o(126122);
              }
            }
          }, "TopStory.DecodeRelevantResult");
        }
        AppMethodBeat.o(126123);
      }
    };
    AppMethodBeat.o(126125);
  }
  
  public static int Xx()
  {
    AppMethodBeat.i(126144);
    switch (ay.getNetType(aj.getContext()))
    {
    default: 
      if (ay.is2G(aj.getContext()))
      {
        AppMethodBeat.o(126144);
        return 2;
      }
      break;
    case -1: 
      AppMethodBeat.o(126144);
      return 0;
    case 0: 
      AppMethodBeat.o(126144);
      return 1;
    }
    if (ay.is3G(aj.getContext()))
    {
      AppMethodBeat.o(126144);
      return 3;
    }
    if (ay.is4G(aj.getContext()))
    {
      AppMethodBeat.o(126144);
      return 4;
    }
    AppMethodBeat.o(126144);
    return 0;
  }
  
  /* Error */
  private static ddb a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 76
    //   8: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 84
    //   16: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 86
    //   24: iconst_0
    //   25: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 7
    //   30: aload 9
    //   32: invokestatic 96	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1295 -> 1330
    //   38: new 98	com/tencent/mm/protocal/protobuf/ddb
    //   41: dup
    //   42: invokespecial 99	com/tencent/mm/protocal/protobuf/ddb:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 103	com/tencent/mm/protocal/protobuf/ddb:rNP	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 107	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 110	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/ddb;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 113	com/tencent/mm/protocal/protobuf/ddb:videoUrl	Ljava/lang/String;
    //   73: invokestatic 96	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 118	com/tencent/mm/plugin/websearch/api/a/a:lI	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 121	com/tencent/mm/protocal/protobuf/ddb:xot	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 123
    //   96: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 125	com/tencent/mm/protocal/protobuf/ddb:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 127
    //   107: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 130	com/tencent/mm/protocal/protobuf/ddb:oYb	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 132
    //   118: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 135	com/tencent/mm/protocal/protobuf/ddb:rUO	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 137
    //   129: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 140	com/tencent/mm/protocal/protobuf/ddb:AGx	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 142
    //   140: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 145	com/tencent/mm/protocal/protobuf/ddb:AGy	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 147
    //   151: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 150	com/tencent/mm/protocal/protobuf/ddb:AGz	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 152
    //   162: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 154	com/tencent/mm/protocal/protobuf/ddb:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 156
    //   173: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 159	com/tencent/mm/protocal/protobuf/ddb:kqB	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 161
    //   184: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 164	com/tencent/mm/protocal/protobuf/ddb:oYa	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 166
    //   195: ldc2_w 167
    //   198: invokevirtual 172	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 176	com/tencent/mm/protocal/protobuf/ddb:EuN	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 178
    //   209: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 181	com/tencent/mm/protocal/protobuf/ddb:EuO	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 183
    //   220: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 186	com/tencent/mm/protocal/protobuf/ddb:EuP	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 188
    //   231: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 191	com/tencent/mm/protocal/protobuf/ddb:AGA	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 193
    //   242: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 196	com/tencent/mm/protocal/protobuf/ddb:AGB	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 198
    //   253: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 204	com/tencent/mm/protocal/protobuf/ddb:EuQ	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 206
    //   264: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 209	com/tencent/mm/protocal/protobuf/ddb:EuS	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 211
    //   275: aload 8
    //   277: getfield 176	com/tencent/mm/protocal/protobuf/ddb:EuN	J
    //   280: invokevirtual 172	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 214	com/tencent/mm/protocal/protobuf/ddb:EuX	J
    //   286: aload 8
    //   288: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   291: putfield 221	com/tencent/mm/protocal/protobuf/ddb:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 224	com/tencent/mm/protocal/protobuf/ddb:ddw	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 227	com/tencent/mm/protocal/protobuf/ddb:roQ	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 230	com/tencent/mm/protocal/protobuf/ddb:EuT	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 233	com/tencent/mm/protocal/protobuf/ddb:dcn	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 236	com/tencent/mm/protocal/protobuf/ddb:EuR	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 238
    //   331: iconst_0
    //   332: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 241	com/tencent/mm/protocal/protobuf/ddb:EuW	I
    //   338: aload_0
    //   339: ldc 243
    //   341: invokevirtual 247	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   344: astore 5
    //   346: aload 5
    //   348: ifnull +45 -> 393
    //   351: aload 8
    //   353: aload 5
    //   355: ldc 249
    //   357: invokevirtual 252	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   360: putfield 255	com/tencent/mm/protocal/protobuf/ddb:Evb	Z
    //   363: aload 8
    //   365: aload 5
    //   367: ldc_w 257
    //   370: ldc_w 259
    //   373: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: putfield 265	com/tencent/mm/protocal/protobuf/ddb:Evc	Ljava/lang/String;
    //   379: aload 8
    //   381: aload 5
    //   383: ldc_w 267
    //   386: iconst_0
    //   387: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   390: putfield 270	com/tencent/mm/protocal/protobuf/ddb:Evg	I
    //   393: aload_0
    //   394: ldc_w 272
    //   397: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   400: astore 5
    //   402: aload 5
    //   404: ifnull +16 -> 420
    //   407: aload 8
    //   409: getfield 280	com/tencent/mm/protocal/protobuf/ddb:AFX	Ljava/util/LinkedList;
    //   412: aload 5
    //   414: invokevirtual 286	org/json/JSONArray:toString	()Ljava/lang/String;
    //   417: invokestatic 292	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   420: aload_0
    //   421: ldc_w 294
    //   424: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   427: astore 5
    //   429: aload 5
    //   431: ifnull +10 -> 441
    //   434: aload 5
    //   436: aload 8
    //   438: invokestatic 297	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   441: aload_0
    //   442: ldc_w 299
    //   445: iconst_0
    //   446: invokevirtual 302	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   449: ifne +15 -> 464
    //   452: aload_0
    //   453: ldc_w 304
    //   456: invokevirtual 247	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   459: aload 8
    //   461: invokestatic 306	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   464: aload_0
    //   465: ldc_w 308
    //   468: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   471: astore 5
    //   473: aload 5
    //   475: ifnull +313 -> 788
    //   478: aload 5
    //   480: iconst_0
    //   481: invokevirtual 311	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   484: astore 5
    //   486: aload 8
    //   488: new 313	com/tencent/mm/protocal/protobuf/dcu
    //   491: dup
    //   492: invokespecial 314	com/tencent/mm/protocal/protobuf/dcu:<init>	()V
    //   495: putfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   498: aload 8
    //   500: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   503: aload 5
    //   505: ldc_w 320
    //   508: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   511: putfield 323	com/tencent/mm/protocal/protobuf/dcu:Euj	Ljava/lang/String;
    //   514: aload 8
    //   516: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   519: aload 5
    //   521: ldc_w 325
    //   524: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   527: putfield 327	com/tencent/mm/protocal/protobuf/dcu:id	Ljava/lang/String;
    //   530: aload 5
    //   532: ldc_w 329
    //   535: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   538: iconst_0
    //   539: invokevirtual 311	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   542: astore 5
    //   544: aload 8
    //   546: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   549: aload 5
    //   551: ldc_w 331
    //   554: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   557: putfield 334	com/tencent/mm/protocal/protobuf/dcu:Euh	I
    //   560: aload 8
    //   562: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   565: aload 5
    //   567: ldc_w 336
    //   570: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   573: putfield 339	com/tencent/mm/protocal/protobuf/dcu:gBm	I
    //   576: aload 8
    //   578: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   581: aload 5
    //   583: ldc_w 341
    //   586: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   589: putfield 344	com/tencent/mm/protocal/protobuf/dcu:Eui	I
    //   592: aload 8
    //   594: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   597: aload 5
    //   599: ldc_w 346
    //   602: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   605: putfield 348	com/tencent/mm/protocal/protobuf/dcu:type	I
    //   608: aload 8
    //   610: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   613: aload 5
    //   615: ldc_w 325
    //   618: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: putfield 351	com/tencent/mm/protocal/protobuf/dcu:jTI	Ljava/lang/String;
    //   624: new 78	org/json/JSONObject
    //   627: dup
    //   628: aload 5
    //   630: ldc_w 353
    //   633: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   636: invokespecial 356	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   639: astore 5
    //   641: aload 8
    //   643: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   646: new 358	com/tencent/mm/protocal/protobuf/dct
    //   649: dup
    //   650: invokespecial 359	com/tencent/mm/protocal/protobuf/dct:<init>	()V
    //   653: putfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   656: aload 8
    //   658: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   661: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   664: aload 5
    //   666: ldc 123
    //   668: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: putfield 364	com/tencent/mm/protocal/protobuf/dct:title	Ljava/lang/String;
    //   674: aload 8
    //   676: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   679: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   682: aload 5
    //   684: ldc_w 366
    //   687: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   690: putfield 368	com/tencent/mm/protocal/protobuf/dct:desc	Ljava/lang/String;
    //   693: aload 8
    //   695: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   698: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   701: aload 5
    //   703: ldc_w 370
    //   706: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   709: putfield 373	com/tencent/mm/protocal/protobuf/dct:dzJ	Ljava/lang/String;
    //   712: aload 8
    //   714: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   717: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   720: aload 5
    //   722: ldc_w 375
    //   725: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: putfield 378	com/tencent/mm/protocal/protobuf/dct:Euf	Ljava/lang/String;
    //   731: aload 8
    //   733: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   736: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   739: aload 5
    //   741: ldc_w 380
    //   744: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: putfield 383	com/tencent/mm/protocal/protobuf/dct:Eug	Ljava/lang/String;
    //   750: aload 8
    //   752: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   755: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   758: aload 5
    //   760: ldc_w 385
    //   763: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: putfield 387	com/tencent/mm/protocal/protobuf/dct:appId	Ljava/lang/String;
    //   769: aload 8
    //   771: getfield 318	com/tencent/mm/protocal/protobuf/ddb:Evh	Lcom/tencent/mm/protocal/protobuf/dcu;
    //   774: getfield 363	com/tencent/mm/protocal/protobuf/dcu:Euk	Lcom/tencent/mm/protocal/protobuf/dct;
    //   777: aload 5
    //   779: ldc_w 389
    //   782: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 392	com/tencent/mm/protocal/protobuf/dct:qDs	Ljava/lang/String;
    //   788: aload_0
    //   789: ldc_w 394
    //   792: invokevirtual 247	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   795: astore 5
    //   797: aload 5
    //   799: ifnull +102 -> 901
    //   802: aload 8
    //   804: new 396	com/tencent/mm/protocal/protobuf/dcw
    //   807: dup
    //   808: invokespecial 397	com/tencent/mm/protocal/protobuf/dcw:<init>	()V
    //   811: putfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   814: aload 8
    //   816: getfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   819: aload 5
    //   821: ldc_w 403
    //   824: iconst_2
    //   825: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   828: putfield 406	com/tencent/mm/protocal/protobuf/dcw:Cfu	I
    //   831: aload 8
    //   833: getfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   836: aload 5
    //   838: ldc_w 408
    //   841: ldc_w 259
    //   844: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   847: putfield 411	com/tencent/mm/protocal/protobuf/dcw:Eup	Ljava/lang/String;
    //   850: aload 8
    //   852: getfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   855: aload 5
    //   857: ldc_w 413
    //   860: iconst_1
    //   861: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   864: putfield 416	com/tencent/mm/protocal/protobuf/dcw:Euo	I
    //   867: aload 8
    //   869: getfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   872: aload 5
    //   874: ldc_w 418
    //   877: iconst_0
    //   878: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   881: putfield 421	com/tencent/mm/protocal/protobuf/dcw:Euq	I
    //   884: aload 8
    //   886: getfield 401	com/tencent/mm/protocal/protobuf/ddb:EuY	Lcom/tencent/mm/protocal/protobuf/dcw;
    //   889: aload 5
    //   891: ldc_w 423
    //   894: iconst_0
    //   895: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   898: putfield 426	com/tencent/mm/protocal/protobuf/dcw:Eur	I
    //   901: aload_0
    //   902: ldc_w 428
    //   905: invokevirtual 247	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   908: astore_0
    //   909: aload_0
    //   910: ifnull +354 -> 1264
    //   913: aload 8
    //   915: new 98	com/tencent/mm/protocal/protobuf/ddb
    //   918: dup
    //   919: invokespecial 99	com/tencent/mm/protocal/protobuf/ddb:<init>	()V
    //   922: putfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   925: aload 8
    //   927: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   930: aload_0
    //   931: ldc 84
    //   933: ldc_w 259
    //   936: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   939: putfield 227	com/tencent/mm/protocal/protobuf/ddb:roQ	Ljava/lang/String;
    //   942: aload 8
    //   944: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   947: aload_0
    //   948: ldc 123
    //   950: ldc_w 259
    //   953: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   956: putfield 125	com/tencent/mm/protocal/protobuf/ddb:title	Ljava/lang/String;
    //   959: aload 8
    //   961: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   964: aload_0
    //   965: ldc 86
    //   967: iconst_0
    //   968: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   971: putfield 121	com/tencent/mm/protocal/protobuf/ddb:xot	I
    //   974: aload 8
    //   976: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   979: aload_0
    //   980: ldc 198
    //   982: iconst_0
    //   983: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   986: putfield 204	com/tencent/mm/protocal/protobuf/ddb:EuQ	I
    //   989: aload 8
    //   991: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   994: aload_0
    //   995: ldc 76
    //   997: ldc_w 259
    //   1000: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1003: putfield 103	com/tencent/mm/protocal/protobuf/ddb:rNP	Ljava/lang/String;
    //   1006: aload_0
    //   1007: ldc_w 294
    //   1010: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1013: astore 5
    //   1015: aload 5
    //   1017: ifnull +13 -> 1030
    //   1020: aload 5
    //   1022: aload 8
    //   1024: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1027: invokestatic 297	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   1030: aload_0
    //   1031: ldc_w 304
    //   1034: invokevirtual 247	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1037: astore 5
    //   1039: aload 5
    //   1041: ifnull +13 -> 1054
    //   1044: aload 5
    //   1046: aload 8
    //   1048: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1051: invokestatic 306	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   1054: aload_0
    //   1055: ldc_w 272
    //   1058: invokevirtual 276	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1061: astore 5
    //   1063: aload 5
    //   1065: ifnull +19 -> 1084
    //   1068: aload 8
    //   1070: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1073: getfield 280	com/tencent/mm/protocal/protobuf/ddb:AFX	Ljava/util/LinkedList;
    //   1076: aload 5
    //   1078: invokevirtual 286	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1081: invokestatic 292	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   1084: aload_0
    //   1085: aload 8
    //   1087: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1090: invokestatic 107	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/ddb;)V
    //   1093: iload 6
    //   1095: aload 8
    //   1097: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1100: aload_0
    //   1101: invokestatic 110	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/ddb;Lorg/json/JSONObject;)V
    //   1104: aload 8
    //   1106: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1109: aload 8
    //   1111: getfield 154	com/tencent/mm/protocal/protobuf/ddb:source	Ljava/lang/String;
    //   1114: putfield 154	com/tencent/mm/protocal/protobuf/ddb:source	Ljava/lang/String;
    //   1117: aload 8
    //   1119: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1122: aload 8
    //   1124: getfield 159	com/tencent/mm/protocal/protobuf/ddb:kqB	Ljava/lang/String;
    //   1127: putfield 159	com/tencent/mm/protocal/protobuf/ddb:kqB	Ljava/lang/String;
    //   1130: aload 8
    //   1132: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1135: aload 8
    //   1137: getfield 209	com/tencent/mm/protocal/protobuf/ddb:EuS	Ljava/lang/String;
    //   1140: putfield 209	com/tencent/mm/protocal/protobuf/ddb:EuS	Ljava/lang/String;
    //   1143: aload 8
    //   1145: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1148: aload 8
    //   1150: getfield 214	com/tencent/mm/protocal/protobuf/ddb:EuX	J
    //   1153: putfield 214	com/tencent/mm/protocal/protobuf/ddb:EuX	J
    //   1156: aload 8
    //   1158: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1161: aload 8
    //   1163: getfield 130	com/tencent/mm/protocal/protobuf/ddb:oYb	Ljava/lang/String;
    //   1166: putfield 130	com/tencent/mm/protocal/protobuf/ddb:oYb	Ljava/lang/String;
    //   1169: aload 8
    //   1171: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1174: aload 8
    //   1176: getfield 135	com/tencent/mm/protocal/protobuf/ddb:rUO	Ljava/lang/String;
    //   1179: putfield 135	com/tencent/mm/protocal/protobuf/ddb:rUO	Ljava/lang/String;
    //   1182: aload 8
    //   1184: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1187: aload 8
    //   1189: getfield 181	com/tencent/mm/protocal/protobuf/ddb:EuO	Ljava/lang/String;
    //   1192: putfield 181	com/tencent/mm/protocal/protobuf/ddb:EuO	Ljava/lang/String;
    //   1195: aload 8
    //   1197: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1200: aload 8
    //   1202: getfield 140	com/tencent/mm/protocal/protobuf/ddb:AGx	Ljava/lang/String;
    //   1205: putfield 140	com/tencent/mm/protocal/protobuf/ddb:AGx	Ljava/lang/String;
    //   1208: aload 8
    //   1210: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1213: aload 8
    //   1215: getfield 145	com/tencent/mm/protocal/protobuf/ddb:AGy	Ljava/lang/String;
    //   1218: putfield 145	com/tencent/mm/protocal/protobuf/ddb:AGy	Ljava/lang/String;
    //   1221: aload 8
    //   1223: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1226: aload 8
    //   1228: getfield 150	com/tencent/mm/protocal/protobuf/ddb:AGz	Ljava/lang/String;
    //   1231: putfield 150	com/tencent/mm/protocal/protobuf/ddb:AGz	Ljava/lang/String;
    //   1234: aload 8
    //   1236: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1239: aload 8
    //   1241: getfield 181	com/tencent/mm/protocal/protobuf/ddb:EuO	Ljava/lang/String;
    //   1244: putfield 181	com/tencent/mm/protocal/protobuf/ddb:EuO	Ljava/lang/String;
    //   1247: aload 8
    //   1249: getfield 432	com/tencent/mm/protocal/protobuf/ddb:Evf	Lcom/tencent/mm/protocal/protobuf/ddb;
    //   1252: aload_0
    //   1253: ldc 161
    //   1255: ldc_w 259
    //   1258: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1261: putfield 164	com/tencent/mm/protocal/protobuf/ddb:oYa	Ljava/lang/String;
    //   1264: aload 8
    //   1266: getfield 113	com/tencent/mm/protocal/protobuf/ddb:videoUrl	Ljava/lang/String;
    //   1269: invokestatic 96	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1272: ifne +51 -> 1323
    //   1275: ldc_w 434
    //   1278: ldc_w 436
    //   1281: iconst_3
    //   1282: anewarray 4	java/lang/Object
    //   1285: dup
    //   1286: iconst_0
    //   1287: aload 8
    //   1289: getfield 103	com/tencent/mm/protocal/protobuf/ddb:rNP	Ljava/lang/String;
    //   1292: aastore
    //   1293: dup
    //   1294: iconst_1
    //   1295: aload 8
    //   1297: getfield 113	com/tencent/mm/protocal/protobuf/ddb:videoUrl	Ljava/lang/String;
    //   1300: aastore
    //   1301: dup
    //   1302: iconst_2
    //   1303: aload 8
    //   1305: getfield 439	com/tencent/mm/protocal/protobuf/ddb:EuU	J
    //   1308: invokestatic 445	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1311: aastore
    //   1312: invokestatic 450	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1315: ldc 74
    //   1317: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1320: aload 8
    //   1322: areturn
    //   1323: ldc 74
    //   1325: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1328: aconst_null
    //   1329: areturn
    //   1330: ldc 74
    //   1332: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1335: aconst_null
    //   1336: areturn
    //   1337: astore 5
    //   1339: goto -551 -> 788
    //   1342: astore 5
    //   1344: goto -556 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1347	0	paramJSONObject	JSONObject
    //   0	1347	1	paramLong1	long
    //   0	1347	3	paramLong2	long
    //   0	1347	5	paramString	String
    //   0	1347	6	paramBoolean	boolean
    //   28	59	7	i	int
    //   45	1276	8	localddb	ddb
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   464	473	1337	java/lang/Exception
    //   478	788	1342	java/lang/Exception
  }
  
  private static List<ddb> a(boolean paramBoolean, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(126134);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      long l1 = ((JSONObject)localObject).optLong("resultType");
      long l2 = ((JSONObject)localObject).optLong("type");
      String str = ((JSONObject)localObject).optString("expand");
      localObject = ((JSONObject)localObject).optJSONArray("items");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int j = 0;
        if (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          ddb localddb = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localddb != null)
          {
            ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localddb.rNP, localddb.videoUrl, Long.valueOf(localddb.EuU) });
            localArrayList.add(localddb);
          }
          for (;;)
          {
            j += 1;
            break;
            ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", new Object[] { localJSONObject.toString() });
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(126134);
    return localArrayList;
  }
  
  private static void a(ddb paramddb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126142);
    Object localObject7 = null;
    InputStream localInputStream1 = null;
    Object localObject8 = null;
    String str = null;
    v localv = null;
    JSONArray localJSONArray = null;
    Object localObject9 = null;
    Object localObject6 = null;
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject3 = localJSONArray;
    Object localObject4 = localObject8;
    InputStream localInputStream2 = localInputStream1;
    Object localObject1 = localObject9;
    Object localObject2 = str;
    Object localObject5 = localObject7;
    try
    {
      j = dPG();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      k = Xx();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      m = dPH();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", new Object[] { paramString1 });
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      if (!URLUtil.isHttpsUrl(paramString1)) {
        break label523;
      }
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1 = com.tencent.mm.network.b.AZ(paramString1);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.aFa();
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.setConnectTimeout(3000);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.setReadTimeout(3000);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      localInputStream1 = paramString1.hMh.getInputStream();
    }
    catch (Throwable paramddb)
    {
      int j;
      int k;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramddb, "getVideoUrlByVideoApi error: %s", new Object[] { paramddb.getMessage() });
        if (localObject4 != null) {
          ((v)localObject4).disconnect();
        }
        if (localObject3 != null) {
          ((y)localObject3).disconnect();
        }
        if (localInputStream2 == null) {
          break;
        }
        com.tencent.mm.vfs.q.closeQuietly(localInputStream2);
        AppMethodBeat.o(126142);
        return;
        localObject3 = localJSONArray;
        localObject4 = localObject8;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = str;
        localObject5 = localObject7;
        localv = com.tencent.mm.network.b.a(paramString1, null);
        localObject3 = localJSONArray;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localv;
        localObject5 = localObject7;
        localv.setUseCaches(true);
        localObject3 = localJSONArray;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localv;
        localObject5 = localObject7;
        localv.setConnectTimeout(3000);
        localObject3 = localJSONArray;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localv;
        localObject5 = localObject7;
        localv.setReadTimeout(3000);
        localObject3 = localJSONArray;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localv;
        localObject5 = localObject7;
        localInputStream1 = localv.getInputStream();
        paramString1 = (String)localObject6;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = new JSONObject(localStringBuilder.toString().substring(13));
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject6).optJSONObject("fl");
      if (localObject7 == null) {
        break label932;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject7).optJSONArray("fi");
      if (localObject7 == null) {
        break label932;
      }
      int i = 0;
      for (;;)
      {
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        if (i < ((JSONArray)localObject7).length())
        {
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject8 = ((JSONArray)localObject7).getJSONObject(i);
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          if (((JSONObject)localObject8).optInt("sl", 0) == 1)
          {
            localObject3 = paramString1;
            localObject4 = localv;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localv;
            localObject5 = localInputStream1;
            paramddb.EuU = ((JSONObject)localObject8).optLong("fs");
          }
        }
        else
        {
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONObject("vl");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONArray("vi");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          if (((JSONArray)localObject6).length() <= 0) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject6 = ((JSONArray)localObject6).getJSONObject(0);
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject8 = ((JSONObject)localObject6).optString("fn");
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          str = ((JSONObject)localObject6).optString("fvkey");
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONObject("ul");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localJSONArray = ((JSONObject)localObject6).optJSONArray("ui");
          if (localJSONArray == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          if (localJSONArray.length() <= 0) {
            break;
          }
          i = 0;
          for (;;)
          {
            localObject3 = paramString1;
            localObject4 = localv;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localv;
            localObject5 = localInputStream1;
            if (i >= localJSONArray.length()) {
              break;
            }
            localObject3 = paramString1;
            localObject4 = localv;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localv;
            localObject5 = localInputStream1;
            localObject6 = localJSONArray.getJSONObject(i);
            if (localObject6 != null)
            {
              localObject3 = paramString1;
              localObject4 = localv;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localv;
              localObject5 = localInputStream1;
              localObject7 = ((JSONObject)localObject6).optString("url");
              localObject3 = paramString1;
              localObject4 = localv;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localv;
              localObject5 = localInputStream1;
              int n = ((JSONObject)localObject6).optInt("vt", 0);
              localObject3 = paramString1;
              localObject4 = localv;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localv;
              localObject5 = localInputStream1;
              if (!bt.isNullOrNil((String)localObject7))
              {
                localObject3 = paramString1;
                localObject4 = localv;
                localInputStream2 = localInputStream1;
                localObject1 = paramString1;
                localObject2 = localv;
                localObject5 = localInputStream1;
                if (!bt.isNullOrNil(str))
                {
                  localObject3 = paramString1;
                  localObject4 = localv;
                  localInputStream2 = localInputStream1;
                  localObject1 = paramString1;
                  localObject2 = localv;
                  localObject5 = localInputStream1;
                  if (!bt.isNullOrNil((String)localObject8))
                  {
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    localObject7 = (String)localObject7 + (String)localObject8 + "?vkey=" + str;
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject6 = localObject7;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    if (!bt.isNullOrNil(paramString2))
                    {
                      localObject3 = paramString1;
                      localObject4 = localv;
                      localInputStream2 = localInputStream1;
                      localObject1 = paramString1;
                      localObject2 = localv;
                      localObject5 = localInputStream1;
                      localObject6 = (String)localObject7 + "&platform=" + paramString2;
                    }
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    localObject6 = d((String)localObject6, "&", j, k, m);
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    localObject7 = new ddd();
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((ddd)localObject7).url = ((String)localObject6);
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((ddd)localObject7).Eve = n;
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    paramddb.EuV.add(localObject7);
                  }
                }
              }
            }
            i += 1;
          }
        }
        i += 1;
      }
      if (localv == null) {
        break label1782;
      }
      localv.disconnect();
      if (paramString1 == null) {
        break label1790;
      }
      paramString1.disconnect();
      if (localInputStream1 == null) {
        break label1846;
      }
      com.tencent.mm.vfs.q.closeQuietly(localInputStream1);
      AppMethodBeat.o(126142);
      return;
    }
    finally
    {
      if (localObject2 == null) {
        break label1818;
      }
      ((v)localObject2).disconnect();
      if (localObject1 == null) {
        break label1828;
      }
      ((y)localObject1).disconnect();
      if (localObject5 == null) {
        break label1838;
      }
      com.tencent.mm.vfs.q.closeQuietly((Closeable)localObject5);
      AppMethodBeat.o(126142);
    }
    localObject3 = paramString1;
    localObject4 = localv;
    localInputStream2 = localInputStream1;
    localObject1 = paramString1;
    localObject2 = localv;
    localObject5 = localInputStream1;
    localObject6 = new BufferedReader(new InputStreamReader(localInputStream1));
    for (;;)
    {
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((BufferedReader)localObject6).readLine();
      if (localObject7 == null) {
        break;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localStringBuilder.append((String)localObject7);
    }
    label523:
    label932:
    label1782:
    label1790:
    AppMethodBeat.o(126142);
    label1818:
    label1828:
    label1838:
    label1846:
    return;
  }
  
  private static void a(JSONArray paramJSONArray, ddb paramddb)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      ctk localctk = new ctk();
      localctk.id = paramJSONArray.getJSONObject(i).optString("id");
      localctk.doh = paramJSONArray.getJSONObject(i).optString("wording");
      localctk.Eld = paramJSONArray.getJSONObject(i).optLong("category");
      localctk.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localctk.url = paramJSONArray.getJSONObject(i).optString("url");
      localctk.title = paramJSONArray.getJSONObject(i).optString("title");
      localctk.lZG = paramJSONArray.getJSONObject(i).optString("subTitle");
      localctk.dub = paramJSONArray.getJSONObject(i).optString("icon");
      paramddb.rNO.add(localctk);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, ddb paramddb)
  {
    AppMethodBeat.i(126137);
    paramddb.Evd = new dcz();
    paramddb.Evd.EuI = paramJSONObject.optString("detailWording");
    paramddb.Evd.EuJ = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        ahk localahk = new ahk();
        localahk.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localahk.doh = paramJSONObject.optJSONObject(i).optString("wording", "");
        localahk.Dkb = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        paramddb.Evd.EuK.add(localahk);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, ddb paramddb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    paramddb.EuM = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      paramddb.thumbWidth = 360;
    }
    for (paramddb.thumbHeight = 640;; paramddb.thumbHeight = 280)
    {
      if (bt.isNullOrNil(paramddb.EuM)) {
        paramddb.EuM = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramddb.rNP + String.format("_%s_%s/0", new Object[] { Integer.valueOf(paramddb.thumbWidth), Integer.valueOf(paramddb.thumbHeight) }));
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { paramddb.rNP, paramddb.EuM });
      AppMethodBeat.o(126140);
      return;
      paramddb.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, ddb paramddb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126141);
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("mpInfo");
        if ((paramJSONObject != null) && (paramJSONObject.optJSONArray("urlInfo") != null))
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("urlInfo");
          paramInt = 0;
          if (paramInt < localJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)localJSONArray.get(paramInt);
            if ((!localJSONObject.has("url")) || (!localJSONObject.has("filesize"))) {
              break label243;
            }
            paramddb.EuU = localJSONObject.optInt("filesize", 0);
            ddd localddd = new ddd();
            localddd.url = localJSONObject.optString("url");
            localddd.Eve = 0;
            paramddb.EuV.add(localddd);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramddb.EuM = paramJSONObject.optString("coverUrl");
          if (paramddb.EuU > 0L)
          {
            boolean bool = bt.gL(paramddb.EuV);
            if (!bool) {}
          }
          else
          {
            AppMethodBeat.o(126141);
            return false;
          }
        }
        else
        {
          AppMethodBeat.o(126141);
          return false;
        }
      }
      catch (Exception paramddb)
      {
        ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramddb.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject, ddb paramddb)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, paramddb)))
    {
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gg(paramddb.EuV);
      if (paramJSONObject != null)
      {
        paramddb.videoUrl = paramJSONObject.url;
        paramddb.Eve = paramJSONObject.Eve;
      }
    }
    if ((bt.isNullOrNil(paramddb.videoUrl)) && (!bt.isNullOrNil(str2)))
    {
      a(paramddb, str2, str1);
      if (bt.gL(paramddb.EuV))
      {
        a.lI(29);
        ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(paramddb, str2, str1);
      }
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gg(paramddb.EuV);
      if (paramJSONObject != null)
      {
        paramddb.videoUrl = paramJSONObject.url;
        paramddb.Eve = paramJSONObject.Eve;
      }
    }
    AppMethodBeat.o(126138);
  }
  
  private static boolean c(JSONObject paramJSONObject, ddb paramddb)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      paramddb.EuZ = localJSONObject.optInt("cdnScene", 0);
      paramddb.Eva = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((paramddb.EuZ == 1) || (paramddb.Eva == 2))
    {
      if (!a(paramddb.EuZ, paramddb, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(paramddb.EuZ), paramddb.rNP, paramddb.title, Long.valueOf(paramddb.EuU) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static String d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(126146);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126146);
      return paramString1;
    }
    paramString1 = paramString1 + paramString2 + "Unicomtype=" + paramInt1 + "&newnettype=" + paramInt2 + "&Netoperator=" + paramInt3;
    ad.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(126146);
    return paramString1;
  }
  
  private static int dPG()
  {
    AppMethodBeat.i(126143);
    if (com.tencent.mm.plugin.topstory.a.h.dNW())
    {
      AppMethodBeat.o(126143);
      return 2;
    }
    AppMethodBeat.o(126143);
    return -1;
  }
  
  private static int dPH()
  {
    AppMethodBeat.i(126145);
    int j = ay.getISPCode(aj.getContext());
    if (j == 0)
    {
      AppMethodBeat.o(126145);
      return 0;
    }
    int i = j / 100;
    j %= 100;
    if (i == 460)
    {
      if ((j == 0) || (j == 2) || (j == 7))
      {
        AppMethodBeat.o(126145);
        return 3;
      }
      if ((j == 1) || (j == 6) || (j == 9))
      {
        AppMethodBeat.o(126145);
        return 2;
      }
      if ((j == 3) || (j == 5) || (j == 11))
      {
        AppMethodBeat.o(126145);
        return 1;
      }
    }
    AppMethodBeat.o(126145);
    return 0;
  }
  
  public final void Pp(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < dPE().size()) {
        dPE().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final ddb Pq(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < dPE().size())
      {
        ddb localddb = (ddb)dPE().get(paramInt);
        return localddb;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean Pr(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.yPY)
    {
      ad.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.yPY = true;
    dcy localdcy = com.tencent.mm.plugin.topstory.a.h.a(this.yOm.dOH());
    localdcy.offset = paramInt;
    Object localObject1;
    if (!bt.isNullOrNil(this.yOm.dOH().Euu))
    {
      localObject1 = new xp();
      ((xp)localObject1).key = "relevant_vid";
      ((xp)localObject1).CZj = this.yOm.dOH().Euu;
      localdcy.AFX.add(localObject1);
    }
    if (!bt.isNullOrNil(this.yOm.dOH().Euv))
    {
      localObject1 = new xp();
      ((xp)localObject1).key = "relevant_expand";
      ((xp)localObject1).CZj = this.yOm.dOH().Euv;
      localdcy.AFX.add(localObject1);
    }
    if (!bt.isNullOrNil(this.yOm.dOH().Euw))
    {
      localObject1 = new xp();
      ((xp)localObject1).key = "relevant_pre_searchid";
      ((xp)localObject1).CZj = this.yOm.dOH().Euw;
      localdcy.AFX.add(localObject1);
    }
    if (!bt.isNullOrNil(this.yOm.dOH().Eux))
    {
      localObject1 = new xp();
      ((xp)localObject1).key = "relevant_shared_openid";
      ((xp)localObject1).CZj = this.yOm.dOH().Eux;
      localdcy.AFX.add(localObject1);
    }
    if (this.yOm.dOH().EuA != null)
    {
      localObject1 = new xp();
      ((xp)localObject1).key = "rec_category";
      ((xp)localObject1).CZi = this.yOm.dOH().EuA.Eld;
      localdcy.AFX.add(localObject1);
      localObject1 = localdcy.AFX.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((xp)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.yOm.dOH().EuA != null) && (paramInt != 0))
      {
        localObject1 = new xp();
        ((xp)localObject1).key = "show_tag_list";
        ((xp)localObject1).CZj = this.yOm.dOH().EuA.id;
        localdcy.AFX.add(localObject1);
      }
      localObject1 = new xp();
      ((xp)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label654:
      c localc;
      if ((this.yOm.dOH().EuA != null) && (!bt.isNullOrNil(this.yOm.dOH().EuA.id)))
      {
        ((xp)localObject1).CZi = 0L;
        localdcy.AFX.add(localObject1);
        if (dPF() == 1)
        {
          localObject1 = Pq(0);
          localObject2 = new xp();
          ((xp)localObject2).key = "first_video_tag_list";
          ((xp)localObject2).CZj = com.tencent.mm.plugin.topstory.a.h.gh(((ddb)localObject1).rNO).toString();
          localdcy.AFX.add(localObject2);
        }
        localObject1 = this.yOm.dOF();
        if (((o)localObject1).yQk.size() <= 0) {
          break label929;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).yQk.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label780;
        }
        localc = (c)((Iterator)localObject2).next();
        if (!localc.yLV) {
          break label775;
        }
      }
      label775:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.yLU.rNP);
        ((StringBuffer)localObject1).append(";");
        break label654;
        localObject1 = new xp();
        ((xp)localObject1).key = "rec_category";
        ((xp)localObject1).CZi = this.yOm.dOH().Euy;
        localdcy.AFX.add(localObject1);
        break;
        ((xp)localObject1).CZi = 1L;
        break label521;
      }
      label780:
      label929:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = new xp();
          ((xp)localObject2).key = "client_exposed_info";
          ((xp)localObject2).CZj = ((String)localObject1);
          localdcy.AFX.add(localObject2);
        }
        localObject1 = new xp();
        ((xp)localObject1).key = "is_prefetch";
        ((xp)localObject1).CZi = this.yPZ;
        localdcy.AFX.add(localObject1);
        if (this.yQa != null)
        {
          com.tencent.mm.kernel.g.aeS().a(this.yQa);
          this.yQa = null;
        }
        this.yQa = new k(localdcy);
        com.tencent.mm.kernel.g.aeS().a(this.yQa, 0);
        com.tencent.mm.kernel.g.aeS().a(1943, this.gWw);
        a.lI(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final void a(dcy paramdcy, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = dPE();
        if ((bt.gL(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((ddb)localList.get(i)).rNP);
            i += 1;
            continue;
          }
          paramdcy = new e(paramdcy, localArrayList);
          com.tencent.mm.kernel.g.aeS().a(paramdcy, 0);
          com.tencent.mm.kernel.g.aeS().a(paramdcy.getType(), new n.1(this, paramdcy));
          AppMethodBeat.o(126132);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(126132);
      }
      paramInt = 0;
    }
  }
  
  public final List<ddb> dPE()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.yOm.dOH().EuC;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final int dPF()
  {
    AppMethodBeat.i(126127);
    int i = dPE().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void h(ddb paramddb)
  {
    AppMethodBeat.i(126128);
    try
    {
      dPE().add(paramddb);
      return;
    }
    finally
    {
      AppMethodBeat.o(126128);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126133);
    if (this.yQa != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.yQa);
      this.yQa = null;
    }
    if (this.yQd != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.yQd);
      this.yQd = null;
    }
    com.tencent.mm.kernel.g.aeS().b(1943, this.gWw);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private String pRp;
    private boolean rOT;
    
    private a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 44	org/json/JSONObject
      //   8: dup
      //   9: aload_0
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:pRp	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:yQf	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:rOT	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:yQf	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:yPY	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:yQf	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:yPY	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:yQf	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:yPY	Z
      //   67: ldc 36
      //   69: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   72: aload_1
      //   73: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   16	6	1	localJSONObject	JSONObject
      //   43	1	1	localException	Exception
      //   58	15	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	29	43	java/lang/Exception
      //   5	29	58	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */