package com.tencent.mm.plugin.topstory.ui.video;

import android.webkit.URLUtil;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.v;
import com.tencent.mm.network.y;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  public b Acd;
  public int AdP;
  k AdQ;
  private int AdR;
  private int AdS;
  public com.tencent.mm.plugin.topstory.a.c.h AdT;
  public com.tencent.mm.ak.g hwV;
  public boolean rRR;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousn });
        if (paramAnonymousn.equals(n.this.AdQ))
        {
          com.tencent.mm.kernel.g.agi().b(1943, n.this.hwV);
          n.this.AdQ = null;
          paramAnonymousn = (k)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousn.ecD().FhN });
            a.lA(2);
            n.this.Acd.axQ(paramAnonymousString);
            n.this.rRR = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousn.ecD().FhN);
          if (paramAnonymousn.zZP.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.e.h.JZN.f(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousn.equals(n.this.AdT))
        {
          com.tencent.mm.kernel.g.agi().b(1943, n.this.hwV);
          n.this.AdT = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.lA(2);
            AppMethodBeat.o(126123);
            return;
          }
          ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.ecD().FhN });
          com.tencent.e.h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.ecD().FhN).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.Acd.edq(), (JSONArray)localObject);
                  paramAnonymousString.zZQ.FRZ.FRt.addAll((Collection)localObject);
                  ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "netSceneTopStoryRelevantVideo add result list %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
  
  public static int Yu()
  {
    AppMethodBeat.i(126144);
    switch (ax.getNetType(ai.getContext()))
    {
    default: 
      if (ax.is2G(ai.getContext()))
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
    if (ax.is3G(ai.getContext()))
    {
      AppMethodBeat.o(126144);
      return 3;
    }
    if (ax.is4G(ai.getContext()))
    {
      AppMethodBeat.o(126144);
      return 4;
    }
    AppMethodBeat.o(126144);
    return 0;
  }
  
  /* Error */
  private static dio a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 80
    //   8: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 88
    //   16: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 90
    //   24: iconst_0
    //   25: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 7
    //   30: aload 9
    //   32: invokestatic 100	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1295 -> 1330
    //   38: new 102	com/tencent/mm/protocal/protobuf/dio
    //   41: dup
    //   42: invokespecial 103	com/tencent/mm/protocal/protobuf/dio:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 107	com/tencent/mm/protocal/protobuf/dio:sVF	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 111	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 114	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/dio;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 117	com/tencent/mm/protocal/protobuf/dio:videoUrl	Ljava/lang/String;
    //   73: invokestatic 100	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 122	com/tencent/mm/plugin/websearch/api/a/a:lA	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 125	com/tencent/mm/protocal/protobuf/dio:yBk	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 127
    //   96: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 129	com/tencent/mm/protocal/protobuf/dio:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 131
    //   107: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 134	com/tencent/mm/protocal/protobuf/dio:pBm	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 136
    //   118: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 139	com/tencent/mm/protocal/protobuf/dio:tcG	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 141
    //   129: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 144	com/tencent/mm/protocal/protobuf/dio:BYP	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 146
    //   140: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 149	com/tencent/mm/protocal/protobuf/dio:BYQ	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 151
    //   151: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 154	com/tencent/mm/protocal/protobuf/dio:BYR	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 156
    //   162: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 158	com/tencent/mm/protocal/protobuf/dio:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 160
    //   173: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 163	com/tencent/mm/protocal/protobuf/dio:kRU	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 165
    //   184: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 168	com/tencent/mm/protocal/protobuf/dio:pBl	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 170
    //   195: ldc2_w 171
    //   198: invokevirtual 176	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 180	com/tencent/mm/protocal/protobuf/dio:FRO	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 182
    //   209: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 185	com/tencent/mm/protocal/protobuf/dio:FRP	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 187
    //   220: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 190	com/tencent/mm/protocal/protobuf/dio:FRQ	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 192
    //   231: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 195	com/tencent/mm/protocal/protobuf/dio:BYS	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 197
    //   242: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 200	com/tencent/mm/protocal/protobuf/dio:BYT	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 202
    //   253: invokevirtual 205	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 208	com/tencent/mm/protocal/protobuf/dio:FRR	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 210
    //   264: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 213	com/tencent/mm/protocal/protobuf/dio:FRT	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 215
    //   275: aload 8
    //   277: getfield 180	com/tencent/mm/protocal/protobuf/dio:FRO	J
    //   280: invokevirtual 176	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 218	com/tencent/mm/protocal/protobuf/dio:FRY	J
    //   286: aload 8
    //   288: invokestatic 222	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   291: putfield 225	com/tencent/mm/protocal/protobuf/dio:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 228	com/tencent/mm/protocal/protobuf/dio:daU	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 231	com/tencent/mm/protocal/protobuf/dio:sxK	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 234	com/tencent/mm/protocal/protobuf/dio:FRU	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 237	com/tencent/mm/protocal/protobuf/dio:cZM	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 240	com/tencent/mm/protocal/protobuf/dio:FRS	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 242
    //   331: iconst_0
    //   332: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 245	com/tencent/mm/protocal/protobuf/dio:FRX	I
    //   338: aload_0
    //   339: ldc 247
    //   341: invokevirtual 251	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   344: astore 5
    //   346: aload 5
    //   348: ifnull +45 -> 393
    //   351: aload 8
    //   353: aload 5
    //   355: ldc 253
    //   357: invokevirtual 256	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   360: putfield 259	com/tencent/mm/protocal/protobuf/dio:FSc	Z
    //   363: aload 8
    //   365: aload 5
    //   367: ldc_w 261
    //   370: ldc_w 263
    //   373: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: putfield 269	com/tencent/mm/protocal/protobuf/dio:FSd	Ljava/lang/String;
    //   379: aload 8
    //   381: aload 5
    //   383: ldc_w 271
    //   386: iconst_0
    //   387: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   390: putfield 274	com/tencent/mm/protocal/protobuf/dio:FSh	I
    //   393: aload_0
    //   394: ldc_w 276
    //   397: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   400: astore 5
    //   402: aload 5
    //   404: ifnull +16 -> 420
    //   407: aload 8
    //   409: getfield 284	com/tencent/mm/protocal/protobuf/dio:BYq	Ljava/util/LinkedList;
    //   412: aload 5
    //   414: invokevirtual 290	org/json/JSONArray:toString	()Ljava/lang/String;
    //   417: invokestatic 296	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   420: aload_0
    //   421: ldc_w 298
    //   424: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   427: astore 5
    //   429: aload 5
    //   431: ifnull +10 -> 441
    //   434: aload 5
    //   436: aload 8
    //   438: invokestatic 301	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   441: aload_0
    //   442: ldc_w 303
    //   445: iconst_0
    //   446: invokevirtual 306	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   449: ifne +15 -> 464
    //   452: aload_0
    //   453: ldc_w 308
    //   456: invokevirtual 251	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   459: aload 8
    //   461: invokestatic 310	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   464: aload_0
    //   465: ldc_w 312
    //   468: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   471: astore 5
    //   473: aload 5
    //   475: ifnull +313 -> 788
    //   478: aload 5
    //   480: iconst_0
    //   481: invokevirtual 315	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   484: astore 5
    //   486: aload 8
    //   488: new 317	com/tencent/mm/protocal/protobuf/dih
    //   491: dup
    //   492: invokespecial 318	com/tencent/mm/protocal/protobuf/dih:<init>	()V
    //   495: putfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   498: aload 8
    //   500: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   503: aload 5
    //   505: ldc_w 324
    //   508: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   511: putfield 327	com/tencent/mm/protocal/protobuf/dih:FRk	Ljava/lang/String;
    //   514: aload 8
    //   516: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   519: aload 5
    //   521: ldc_w 329
    //   524: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   527: putfield 331	com/tencent/mm/protocal/protobuf/dih:id	Ljava/lang/String;
    //   530: aload 5
    //   532: ldc_w 333
    //   535: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   538: iconst_0
    //   539: invokevirtual 315	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   542: astore 5
    //   544: aload 8
    //   546: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   549: aload 5
    //   551: ldc_w 335
    //   554: invokevirtual 205	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   557: putfield 338	com/tencent/mm/protocal/protobuf/dih:FRi	I
    //   560: aload 8
    //   562: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   565: aload 5
    //   567: ldc_w 340
    //   570: invokevirtual 205	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   573: putfield 343	com/tencent/mm/protocal/protobuf/dih:hbI	I
    //   576: aload 8
    //   578: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   581: aload 5
    //   583: ldc_w 345
    //   586: invokevirtual 205	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   589: putfield 348	com/tencent/mm/protocal/protobuf/dih:FRj	I
    //   592: aload 8
    //   594: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   597: aload 5
    //   599: ldc_w 350
    //   602: invokevirtual 205	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   605: putfield 352	com/tencent/mm/protocal/protobuf/dih:type	I
    //   608: aload 8
    //   610: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   613: aload 5
    //   615: ldc_w 329
    //   618: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: putfield 355	com/tencent/mm/protocal/protobuf/dih:kut	Ljava/lang/String;
    //   624: new 82	org/json/JSONObject
    //   627: dup
    //   628: aload 5
    //   630: ldc_w 357
    //   633: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   636: invokespecial 360	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   639: astore 5
    //   641: aload 8
    //   643: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   646: new 362	com/tencent/mm/protocal/protobuf/dig
    //   649: dup
    //   650: invokespecial 363	com/tencent/mm/protocal/protobuf/dig:<init>	()V
    //   653: putfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   656: aload 8
    //   658: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   661: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   664: aload 5
    //   666: ldc 127
    //   668: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: putfield 368	com/tencent/mm/protocal/protobuf/dig:title	Ljava/lang/String;
    //   674: aload 8
    //   676: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   679: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   682: aload 5
    //   684: ldc_w 370
    //   687: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   690: putfield 372	com/tencent/mm/protocal/protobuf/dig:desc	Ljava/lang/String;
    //   693: aload 8
    //   695: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   698: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   701: aload 5
    //   703: ldc_w 374
    //   706: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   709: putfield 377	com/tencent/mm/protocal/protobuf/dig:dxv	Ljava/lang/String;
    //   712: aload 8
    //   714: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   717: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   720: aload 5
    //   722: ldc_w 379
    //   725: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: putfield 382	com/tencent/mm/protocal/protobuf/dig:FRg	Ljava/lang/String;
    //   731: aload 8
    //   733: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   736: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   739: aload 5
    //   741: ldc_w 384
    //   744: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: putfield 387	com/tencent/mm/protocal/protobuf/dig:FRh	Ljava/lang/String;
    //   750: aload 8
    //   752: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   755: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   758: aload 5
    //   760: ldc_w 389
    //   763: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: putfield 391	com/tencent/mm/protocal/protobuf/dig:appId	Ljava/lang/String;
    //   769: aload 8
    //   771: getfield 322	com/tencent/mm/protocal/protobuf/dio:FSi	Lcom/tencent/mm/protocal/protobuf/dih;
    //   774: getfield 367	com/tencent/mm/protocal/protobuf/dih:FRl	Lcom/tencent/mm/protocal/protobuf/dig;
    //   777: aload 5
    //   779: ldc_w 393
    //   782: invokevirtual 86	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 396	com/tencent/mm/protocal/protobuf/dig:ruB	Ljava/lang/String;
    //   788: aload_0
    //   789: ldc_w 398
    //   792: invokevirtual 251	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   795: astore 5
    //   797: aload 5
    //   799: ifnull +102 -> 901
    //   802: aload 8
    //   804: new 400	com/tencent/mm/protocal/protobuf/dij
    //   807: dup
    //   808: invokespecial 401	com/tencent/mm/protocal/protobuf/dij:<init>	()V
    //   811: putfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   814: aload 8
    //   816: getfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   819: aload 5
    //   821: ldc_w 407
    //   824: iconst_2
    //   825: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   828: putfield 410	com/tencent/mm/protocal/protobuf/dij:DxL	I
    //   831: aload 8
    //   833: getfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   836: aload 5
    //   838: ldc_w 412
    //   841: ldc_w 263
    //   844: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   847: putfield 415	com/tencent/mm/protocal/protobuf/dij:FRq	Ljava/lang/String;
    //   850: aload 8
    //   852: getfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   855: aload 5
    //   857: ldc_w 417
    //   860: iconst_1
    //   861: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   864: putfield 420	com/tencent/mm/protocal/protobuf/dij:FRp	I
    //   867: aload 8
    //   869: getfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   872: aload 5
    //   874: ldc_w 422
    //   877: iconst_0
    //   878: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   881: putfield 425	com/tencent/mm/protocal/protobuf/dij:FRr	I
    //   884: aload 8
    //   886: getfield 405	com/tencent/mm/protocal/protobuf/dio:FRZ	Lcom/tencent/mm/protocal/protobuf/dij;
    //   889: aload 5
    //   891: ldc_w 427
    //   894: iconst_0
    //   895: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   898: putfield 430	com/tencent/mm/protocal/protobuf/dij:FRs	I
    //   901: aload_0
    //   902: ldc_w 432
    //   905: invokevirtual 251	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   908: astore_0
    //   909: aload_0
    //   910: ifnull +354 -> 1264
    //   913: aload 8
    //   915: new 102	com/tencent/mm/protocal/protobuf/dio
    //   918: dup
    //   919: invokespecial 103	com/tencent/mm/protocal/protobuf/dio:<init>	()V
    //   922: putfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   925: aload 8
    //   927: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   930: aload_0
    //   931: ldc 88
    //   933: ldc_w 263
    //   936: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   939: putfield 231	com/tencent/mm/protocal/protobuf/dio:sxK	Ljava/lang/String;
    //   942: aload 8
    //   944: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   947: aload_0
    //   948: ldc 127
    //   950: ldc_w 263
    //   953: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   956: putfield 129	com/tencent/mm/protocal/protobuf/dio:title	Ljava/lang/String;
    //   959: aload 8
    //   961: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   964: aload_0
    //   965: ldc 90
    //   967: iconst_0
    //   968: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   971: putfield 125	com/tencent/mm/protocal/protobuf/dio:yBk	I
    //   974: aload 8
    //   976: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   979: aload_0
    //   980: ldc 202
    //   982: iconst_0
    //   983: invokevirtual 94	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   986: putfield 208	com/tencent/mm/protocal/protobuf/dio:FRR	I
    //   989: aload 8
    //   991: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   994: aload_0
    //   995: ldc 80
    //   997: ldc_w 263
    //   1000: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1003: putfield 107	com/tencent/mm/protocal/protobuf/dio:sVF	Ljava/lang/String;
    //   1006: aload_0
    //   1007: ldc_w 298
    //   1010: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1013: astore 5
    //   1015: aload 5
    //   1017: ifnull +13 -> 1030
    //   1020: aload 5
    //   1022: aload 8
    //   1024: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1027: invokestatic 301	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   1030: aload_0
    //   1031: ldc_w 308
    //   1034: invokevirtual 251	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1037: astore 5
    //   1039: aload 5
    //   1041: ifnull +13 -> 1054
    //   1044: aload 5
    //   1046: aload 8
    //   1048: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1051: invokestatic 310	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   1054: aload_0
    //   1055: ldc_w 276
    //   1058: invokevirtual 280	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1061: astore 5
    //   1063: aload 5
    //   1065: ifnull +19 -> 1084
    //   1068: aload 8
    //   1070: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1073: getfield 284	com/tencent/mm/protocal/protobuf/dio:BYq	Ljava/util/LinkedList;
    //   1076: aload 5
    //   1078: invokevirtual 290	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1081: invokestatic 296	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   1084: aload_0
    //   1085: aload 8
    //   1087: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1090: invokestatic 111	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dio;)V
    //   1093: iload 6
    //   1095: aload 8
    //   1097: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1100: aload_0
    //   1101: invokestatic 114	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/dio;Lorg/json/JSONObject;)V
    //   1104: aload 8
    //   1106: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1109: aload 8
    //   1111: getfield 158	com/tencent/mm/protocal/protobuf/dio:source	Ljava/lang/String;
    //   1114: putfield 158	com/tencent/mm/protocal/protobuf/dio:source	Ljava/lang/String;
    //   1117: aload 8
    //   1119: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1122: aload 8
    //   1124: getfield 163	com/tencent/mm/protocal/protobuf/dio:kRU	Ljava/lang/String;
    //   1127: putfield 163	com/tencent/mm/protocal/protobuf/dio:kRU	Ljava/lang/String;
    //   1130: aload 8
    //   1132: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1135: aload 8
    //   1137: getfield 213	com/tencent/mm/protocal/protobuf/dio:FRT	Ljava/lang/String;
    //   1140: putfield 213	com/tencent/mm/protocal/protobuf/dio:FRT	Ljava/lang/String;
    //   1143: aload 8
    //   1145: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1148: aload 8
    //   1150: getfield 218	com/tencent/mm/protocal/protobuf/dio:FRY	J
    //   1153: putfield 218	com/tencent/mm/protocal/protobuf/dio:FRY	J
    //   1156: aload 8
    //   1158: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1161: aload 8
    //   1163: getfield 134	com/tencent/mm/protocal/protobuf/dio:pBm	Ljava/lang/String;
    //   1166: putfield 134	com/tencent/mm/protocal/protobuf/dio:pBm	Ljava/lang/String;
    //   1169: aload 8
    //   1171: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1174: aload 8
    //   1176: getfield 139	com/tencent/mm/protocal/protobuf/dio:tcG	Ljava/lang/String;
    //   1179: putfield 139	com/tencent/mm/protocal/protobuf/dio:tcG	Ljava/lang/String;
    //   1182: aload 8
    //   1184: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1187: aload 8
    //   1189: getfield 185	com/tencent/mm/protocal/protobuf/dio:FRP	Ljava/lang/String;
    //   1192: putfield 185	com/tencent/mm/protocal/protobuf/dio:FRP	Ljava/lang/String;
    //   1195: aload 8
    //   1197: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1200: aload 8
    //   1202: getfield 144	com/tencent/mm/protocal/protobuf/dio:BYP	Ljava/lang/String;
    //   1205: putfield 144	com/tencent/mm/protocal/protobuf/dio:BYP	Ljava/lang/String;
    //   1208: aload 8
    //   1210: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1213: aload 8
    //   1215: getfield 149	com/tencent/mm/protocal/protobuf/dio:BYQ	Ljava/lang/String;
    //   1218: putfield 149	com/tencent/mm/protocal/protobuf/dio:BYQ	Ljava/lang/String;
    //   1221: aload 8
    //   1223: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1226: aload 8
    //   1228: getfield 154	com/tencent/mm/protocal/protobuf/dio:BYR	Ljava/lang/String;
    //   1231: putfield 154	com/tencent/mm/protocal/protobuf/dio:BYR	Ljava/lang/String;
    //   1234: aload 8
    //   1236: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1239: aload 8
    //   1241: getfield 185	com/tencent/mm/protocal/protobuf/dio:FRP	Ljava/lang/String;
    //   1244: putfield 185	com/tencent/mm/protocal/protobuf/dio:FRP	Ljava/lang/String;
    //   1247: aload 8
    //   1249: getfield 436	com/tencent/mm/protocal/protobuf/dio:FSg	Lcom/tencent/mm/protocal/protobuf/dio;
    //   1252: aload_0
    //   1253: ldc 165
    //   1255: ldc_w 263
    //   1258: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1261: putfield 168	com/tencent/mm/protocal/protobuf/dio:pBl	Ljava/lang/String;
    //   1264: aload 8
    //   1266: getfield 117	com/tencent/mm/protocal/protobuf/dio:videoUrl	Ljava/lang/String;
    //   1269: invokestatic 100	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   1272: ifne +51 -> 1323
    //   1275: ldc_w 438
    //   1278: ldc_w 440
    //   1281: iconst_3
    //   1282: anewarray 4	java/lang/Object
    //   1285: dup
    //   1286: iconst_0
    //   1287: aload 8
    //   1289: getfield 107	com/tencent/mm/protocal/protobuf/dio:sVF	Ljava/lang/String;
    //   1292: aastore
    //   1293: dup
    //   1294: iconst_1
    //   1295: aload 8
    //   1297: getfield 117	com/tencent/mm/protocal/protobuf/dio:videoUrl	Ljava/lang/String;
    //   1300: aastore
    //   1301: dup
    //   1302: iconst_2
    //   1303: aload 8
    //   1305: getfield 443	com/tencent/mm/protocal/protobuf/dio:FRV	J
    //   1308: invokestatic 449	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1311: aastore
    //   1312: invokestatic 454	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1315: ldc 78
    //   1317: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1320: aload 8
    //   1322: areturn
    //   1323: ldc 78
    //   1325: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1328: aconst_null
    //   1329: areturn
    //   1330: ldc 78
    //   1332: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   45	1276	8	localdio	dio
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   464	473	1337	java/lang/Exception
    //   478	788	1342	java/lang/Exception
  }
  
  private static List<dio> a(boolean paramBoolean, JSONArray paramJSONArray)
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
          dio localdio = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localdio != null)
          {
            ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localdio.sVF, localdio.videoUrl, Long.valueOf(localdio.FRV) });
            localArrayList.add(localdio);
          }
          for (;;)
          {
            j += 1;
            break;
            ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", new Object[] { localJSONObject.toString() });
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(126134);
    return localArrayList;
  }
  
  private static void a(dio paramdio, String paramString1, String paramString2)
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
      j = eef();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      k = Yu();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      m = eeg();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", new Object[] { paramString1 });
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
      paramString1 = com.tencent.mm.network.b.Fe(paramString1);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.aLR();
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
      localInputStream1 = paramString1.imE.getInputStream();
    }
    catch (Throwable paramdio)
    {
      int j;
      int k;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramdio, "getVideoUrlByVideoApi error: %s", new Object[] { paramdio.getMessage() });
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
            paramdio.FRV = ((JSONObject)localObject8).optLong("fs");
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
              if (!bs.isNullOrNil((String)localObject7))
              {
                localObject3 = paramString1;
                localObject4 = localv;
                localInputStream2 = localInputStream1;
                localObject1 = paramString1;
                localObject2 = localv;
                localObject5 = localInputStream1;
                if (!bs.isNullOrNil(str))
                {
                  localObject3 = paramString1;
                  localObject4 = localv;
                  localInputStream2 = localInputStream1;
                  localObject1 = paramString1;
                  localObject2 = localv;
                  localObject5 = localInputStream1;
                  if (!bs.isNullOrNil((String)localObject8))
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
                    if (!bs.isNullOrNil(paramString2))
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
                    localObject7 = new diq();
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((diq)localObject7).url = ((String)localObject6);
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((diq)localObject7).FSf = n;
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    paramdio.FRW.add(localObject7);
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
  
  private static void a(JSONArray paramJSONArray, dio paramdio)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      cyv localcyv = new cyv();
      localcyv.id = paramJSONArray.getJSONObject(i).optString("id");
      localcyv.dlQ = paramJSONArray.getJSONObject(i).optString("wording");
      localcyv.FIb = paramJSONArray.getJSONObject(i).optLong("category");
      localcyv.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localcyv.url = paramJSONArray.getJSONObject(i).optString("url");
      localcyv.title = paramJSONArray.getJSONObject(i).optString("title");
      localcyv.mBH = paramJSONArray.getJSONObject(i).optString("subTitle");
      localcyv.drM = paramJSONArray.getJSONObject(i).optString("icon");
      paramdio.sVE.add(localcyv);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, dio paramdio)
  {
    AppMethodBeat.i(126137);
    paramdio.FSe = new dim();
    paramdio.FSe.FRJ = paramJSONObject.optString("detailWording");
    paramdio.FSe.FRK = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        aij localaij = new aij();
        localaij.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localaij.dlQ = paramJSONObject.optJSONObject(i).optString("wording", "");
        localaij.EDh = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        paramdio.FSe.FRL.add(localaij);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, dio paramdio, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    paramdio.FRN = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      paramdio.thumbWidth = 360;
    }
    for (paramdio.thumbHeight = 640;; paramdio.thumbHeight = 280)
    {
      if (bs.isNullOrNil(paramdio.FRN)) {
        paramdio.FRN = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramdio.sVF + String.format("_%s_%s/0", new Object[] { Integer.valueOf(paramdio.thumbWidth), Integer.valueOf(paramdio.thumbHeight) }));
      }
      ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { paramdio.sVF, paramdio.FRN });
      AppMethodBeat.o(126140);
      return;
      paramdio.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, dio paramdio, JSONObject paramJSONObject)
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
            paramdio.FRV = localJSONObject.optInt("filesize", 0);
            diq localdiq = new diq();
            localdiq.url = localJSONObject.optString("url");
            localdiq.FSf = 0;
            paramdio.FRW.add(localdiq);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramdio.FRN = paramJSONObject.optString("coverUrl");
          if (paramdio.FRV > 0L)
          {
            boolean bool = bs.gY(paramdio.FRW);
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
      catch (Exception paramdio)
      {
        ac.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramdio.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject, dio paramdio)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, paramdio)))
    {
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gn(paramdio.FRW);
      if (paramJSONObject != null)
      {
        paramdio.videoUrl = paramJSONObject.url;
        paramdio.FSf = paramJSONObject.FSf;
      }
    }
    if ((bs.isNullOrNil(paramdio.videoUrl)) && (!bs.isNullOrNil(str2)))
    {
      a(paramdio, str2, str1);
      if (bs.gY(paramdio.FRW))
      {
        a.lA(29);
        ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(paramdio, str2, str1);
      }
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gn(paramdio.FRW);
      if (paramJSONObject != null)
      {
        paramdio.videoUrl = paramJSONObject.url;
        paramdio.FSf = paramJSONObject.FSf;
      }
    }
    AppMethodBeat.o(126138);
  }
  
  private static boolean c(JSONObject paramJSONObject, dio paramdio)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      paramdio.FSa = localJSONObject.optInt("cdnScene", 0);
      paramdio.FSb = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((paramdio.FSa == 1) || (paramdio.FSb == 2))
    {
      if (!a(paramdio.FSa, paramdio, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(paramdio.FSa), paramdio.sVF, paramdio.title, Long.valueOf(paramdio.FRV) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static String d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(126146);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126146);
      return paramString1;
    }
    paramString1 = paramString1 + paramString2 + "Unicomtype=" + paramInt1 + "&newnettype=" + paramInt2 + "&Netoperator=" + paramInt3;
    ac.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(126146);
    return paramString1;
  }
  
  private static int eef()
  {
    AppMethodBeat.i(126143);
    if (com.tencent.mm.plugin.topstory.a.h.ecw())
    {
      AppMethodBeat.o(126143);
      return 2;
    }
    AppMethodBeat.o(126143);
    return -1;
  }
  
  private static int eeg()
  {
    AppMethodBeat.i(126145);
    int j = ax.getISPCode(ai.getContext());
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
  
  public final void Rv(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < eed().size()) {
        eed().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final dio Rw(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < eed().size())
      {
        dio localdio = (dio)eed().get(paramInt);
        return localdio;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean Rx(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.rRR)
    {
      ac.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.rRR = true;
    dil localdil = com.tencent.mm.plugin.topstory.a.h.a(this.Acd.edh());
    localdil.offset = paramInt;
    Object localObject1;
    if (!bs.isNullOrNil(this.Acd.edh().FRv))
    {
      localObject1 = new yh();
      ((yh)localObject1).key = "relevant_vid";
      ((yh)localObject1).ErW = this.Acd.edh().FRv;
      localdil.BYq.add(localObject1);
    }
    if (!bs.isNullOrNil(this.Acd.edh().FRw))
    {
      localObject1 = new yh();
      ((yh)localObject1).key = "relevant_expand";
      ((yh)localObject1).ErW = this.Acd.edh().FRw;
      localdil.BYq.add(localObject1);
    }
    if (!bs.isNullOrNil(this.Acd.edh().FRx))
    {
      localObject1 = new yh();
      ((yh)localObject1).key = "relevant_pre_searchid";
      ((yh)localObject1).ErW = this.Acd.edh().FRx;
      localdil.BYq.add(localObject1);
    }
    if (!bs.isNullOrNil(this.Acd.edh().FRy))
    {
      localObject1 = new yh();
      ((yh)localObject1).key = "relevant_shared_openid";
      ((yh)localObject1).ErW = this.Acd.edh().FRy;
      localdil.BYq.add(localObject1);
    }
    if (this.Acd.edh().FRB != null)
    {
      localObject1 = new yh();
      ((yh)localObject1).key = "rec_category";
      ((yh)localObject1).ErV = this.Acd.edh().FRB.FIb;
      localdil.BYq.add(localObject1);
      localObject1 = localdil.BYq.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((yh)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.Acd.edh().FRB != null) && (paramInt != 0))
      {
        localObject1 = new yh();
        ((yh)localObject1).key = "show_tag_list";
        ((yh)localObject1).ErW = this.Acd.edh().FRB.id;
        localdil.BYq.add(localObject1);
      }
      localObject1 = new yh();
      ((yh)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label654:
      c localc;
      if ((this.Acd.edh().FRB != null) && (!bs.isNullOrNil(this.Acd.edh().FRB.id)))
      {
        ((yh)localObject1).ErV = 0L;
        localdil.BYq.add(localObject1);
        if (eee() == 1)
        {
          localObject1 = Rw(0);
          localObject2 = new yh();
          ((yh)localObject2).key = "first_video_tag_list";
          ((yh)localObject2).ErW = com.tencent.mm.plugin.topstory.a.h.go(((dio)localObject1).sVE).toString();
          localdil.BYq.add(localObject2);
        }
        localObject1 = this.Acd.edf();
        if (((o)localObject1).Aea.size() <= 0) {
          break label929;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).Aea.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label780;
        }
        localc = (c)((Iterator)localObject2).next();
        if (!localc.zZO) {
          break label775;
        }
      }
      label775:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.zZN.sVF);
        ((StringBuffer)localObject1).append(";");
        break label654;
        localObject1 = new yh();
        ((yh)localObject1).key = "rec_category";
        ((yh)localObject1).ErV = this.Acd.edh().FRz;
        localdil.BYq.add(localObject1);
        break;
        ((yh)localObject1).ErV = 1L;
        break label521;
      }
      label780:
      label929:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = new yh();
          ((yh)localObject2).key = "client_exposed_info";
          ((yh)localObject2).ErW = ((String)localObject1);
          localdil.BYq.add(localObject2);
        }
        localObject1 = new yh();
        ((yh)localObject1).key = "is_prefetch";
        ((yh)localObject1).ErV = this.AdP;
        localdil.BYq.add(localObject1);
        if (this.AdQ != null)
        {
          com.tencent.mm.kernel.g.agi().a(this.AdQ);
          this.AdQ = null;
        }
        this.AdQ = new k(localdil);
        com.tencent.mm.kernel.g.agi().a(this.AdQ, 0);
        com.tencent.mm.kernel.g.agi().a(1943, this.hwV);
        a.lA(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final void a(final dil paramdil, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = eed();
        if ((bs.gY(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((dio)localList.get(i)).sVF);
            i += 1;
            continue;
          }
          paramdil = new e(paramdil, localArrayList);
          com.tencent.mm.kernel.g.agi().a(paramdil, 0);
          com.tencent.mm.kernel.g.agi().a(paramdil.getType(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(126121);
              if (((paramAnonymousn instanceof e)) && (paramAnonymousn.equals(paramdil)))
              {
                com.tencent.mm.kernel.g.agi().b(paramdil.getType(), this);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  ac.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(126121);
                  return;
                }
                paramAnonymousString = (cmt)((e)paramAnonymousn).rr.hvs.hvw;
                com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
                {
                  public final String getKey()
                  {
                    return "requestVideoUrlResultParse";
                  }
                  
                  public final void run()
                  {
                    AppMethodBeat.i(126120);
                    ArrayList localArrayList = new ArrayList();
                    ??? = paramAnonymousString.FAc.DSZ.iterator();
                    Object localObject4;
                    Object localObject3;
                    Object localObject5;
                    Object localObject6;
                    while (((Iterator)???).hasNext())
                    {
                      localObject4 = (dqh)((Iterator)???).next();
                      localObject3 = new dio();
                      if (!bs.isNullOrNil(((dqh)localObject4).FXs.nOK))
                      {
                        ((dio)localObject3).sVF = ((dqh)localObject4).FXs.nOK;
                        if ((((dqh)localObject4).FXu != null) && (((dqh)localObject4).FXu.FWX == 1)) {
                          if ((((dqh)localObject4).FXu.FWZ != null) && (!bs.gY(((dqh)localObject4).FXu.FWZ.Elp)))
                          {
                            ((dio)localObject3).FRW.clear();
                            ((dio)localObject3).FSb = ((dqh)localObject4).FXu.FXa;
                            localObject4 = ((dqh)localObject4).FXu.FWZ.Elp.iterator();
                            while (((Iterator)localObject4).hasNext())
                            {
                              localObject5 = (dnx)((Iterator)localObject4).next();
                              localObject6 = new diq();
                              ((diq)localObject6).url = ((dnx)localObject5).FVz.eQU();
                              ((diq)localObject6).FSf = 0;
                              ((dio)localObject3).FRW.add(localObject6);
                              ((dio)localObject3).FRV = ((dnx)localObject5).FVB;
                            }
                            localObject4 = com.tencent.mm.plugin.topstory.a.h.gn(((dio)localObject3).FRW);
                            if (localObject4 != null)
                            {
                              ((dio)localObject3).videoUrl = ((diq)localObject4).url;
                              ((dio)localObject3).FSf = ((diq)localObject4).FSf;
                            }
                          }
                        }
                        for (;;)
                        {
                          localArrayList.add(localObject3);
                          break;
                          if ((((dqh)localObject4).FXu != null) && (((dqh)localObject4).FXu.FWX == 2))
                          {
                            if ((((dqh)localObject4).FXu.FWY != null) && (!bs.gY(((dqh)localObject4).FXu.FWY.Elp)))
                            {
                              ((dio)localObject3).FRW.clear();
                              ((dio)localObject3).FSb = ((dqh)localObject4).FXu.FXa;
                              localObject4 = ((dqh)localObject4).FXu.FWY.Elp.iterator();
                              while (((Iterator)localObject4).hasNext())
                              {
                                localObject5 = (dnx)((Iterator)localObject4).next();
                                localObject6 = new diq();
                                ((diq)localObject6).url = ((dnx)localObject5).FVz.eQU();
                                ((diq)localObject6).FSf = 0;
                                ((dio)localObject3).FRW.add(localObject6);
                                ((dio)localObject3).FRV = ((dnx)localObject5).FVB;
                              }
                              localObject4 = com.tencent.mm.plugin.topstory.a.h.gn(((dio)localObject3).FRW);
                              if (localObject4 != null)
                              {
                                ((dio)localObject3).videoUrl = ((diq)localObject4).url;
                                ((dio)localObject3).FSf = ((diq)localObject4).FSf;
                              }
                            }
                          }
                          else if (!bs.isNullOrNil(((dqh)localObject4).FXv))
                          {
                            ((dio)localObject3).FRW.clear();
                            n.b((dio)localObject3, ((dqh)localObject4).FXv, "");
                            localObject5 = com.tencent.mm.plugin.topstory.a.h.gn(((dio)localObject3).FRW);
                            if (localObject5 != null)
                            {
                              ((dio)localObject3).videoUrl = ((diq)localObject5).url;
                              ((dio)localObject3).FSf = ((diq)localObject5).FSf;
                              if (((dqh)localObject4).FXu != null) {
                                ((dio)localObject3).FSb = ((dqh)localObject4).FXu.FXa;
                              }
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      int i;
                      synchronized (n.this)
                      {
                        localObject3 = n.this.eed();
                        if (bs.gY((List)localObject3))
                        {
                          AppMethodBeat.o(126120);
                          return;
                        }
                        i = 0;
                        if (i >= ((List)localObject3).size()) {
                          break;
                        }
                        localObject4 = (dio)((List)localObject3).get(i);
                        localObject5 = localArrayList.iterator();
                        if (((Iterator)localObject5).hasNext())
                        {
                          localObject6 = (dio)((Iterator)localObject5).next();
                          if (!((dio)localObject4).sVF.equals(((dio)localObject6).sVF)) {
                            continue;
                          }
                          ((dio)localObject4).FRW = ((dio)localObject6).FRW;
                          ((dio)localObject4).FRV = ((dio)localObject6).FRV;
                          ((dio)localObject4).videoUrl = ((dio)localObject6).videoUrl;
                          ((dio)localObject4).FSb = ((dio)localObject6).FSb;
                          ac.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((dio)localObject4).title, ((dio)localObject4).videoUrl });
                        }
                      }
                      i += 1;
                    }
                    AppMethodBeat.o(126120);
                  }
                });
              }
              AppMethodBeat.o(126121);
            }
          });
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
  
  public final List<dio> eed()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.Acd.edh().FRD;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final int eee()
  {
    AppMethodBeat.i(126127);
    int i = eed().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void h(dio paramdio)
  {
    AppMethodBeat.i(126128);
    try
    {
      eed().add(paramdio);
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
    if (this.AdQ != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.AdQ);
      this.AdQ = null;
    }
    if (this.AdT != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.AdT);
      this.AdT = null;
    }
    com.tencent.mm.kernel.g.agi().b(1943, this.hwV);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private String qzX;
    private boolean sWJ;
    
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
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:qzX	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:AdV	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:sWJ	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:AdV	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:rRR	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:AdV	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:rRR	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:AdV	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:rRR	Z
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