package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.ad;
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
  public boolean MTh;
  public b MYE;
  public int Nar;
  k Nas;
  private int Nat;
  private int Nau;
  public com.tencent.mm.plugin.topstory.a.c.h Nav;
  public com.tencent.mm.an.i jxB;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.jxB = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousq });
        if (paramAnonymousq.equals(n.this.Nas))
        {
          com.tencent.mm.kernel.h.aGY().b(1943, n.this.jxB);
          n.this.Nas = null;
          paramAnonymousq = (k)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousq.gpU().Tkw });
            a.rE(2);
            n.this.MYE.bfc(paramAnonymousString);
            n.this.MTh = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousq.gpU().Tkw);
          if (paramAnonymousq.MWu.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.e.h.ZvG.d(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousq.equals(n.this.Nav))
        {
          com.tencent.mm.kernel.h.aGY().b(1943, n.this.jxB);
          n.this.Nav = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.rE(2);
            AppMethodBeat.o(126123);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.gpU().Tkw });
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.gpU().Tkw).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.MYE.gqI(), (JSONArray)localObject);
                  paramAnonymousString.MWv.Uvf.UuB.addAll((Collection)localObject);
                  Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "netSceneTopStoryRelevantVideo add result list %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
  
  /* Error */
  private static esy a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 51
    //   8: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 59
    //   16: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 61
    //   24: iconst_0
    //   25: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 7
    //   30: aload 9
    //   32: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1310 -> 1345
    //   38: new 73	com/tencent/mm/protocal/protobuf/esy
    //   41: dup
    //   42: invokespecial 74	com/tencent/mm/protocal/protobuf/esy:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 78	com/tencent/mm/protocal/protobuf/esy:Crh	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 82	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 85	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/esy;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 88	com/tencent/mm/protocal/protobuf/esy:videoUrl	Ljava/lang/String;
    //   73: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 93	com/tencent/mm/plugin/websearch/api/a/a:rE	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 96	com/tencent/mm/protocal/protobuf/esy:KFK	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 98
    //   96: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 100	com/tencent/mm/protocal/protobuf/esy:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 102
    //   107: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 105	com/tencent/mm/protocal/protobuf/esy:pqW	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 107
    //   118: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 110	com/tencent/mm/protocal/protobuf/esy:CHR	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 112
    //   129: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 115	com/tencent/mm/protocal/protobuf/esy:PyV	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 117
    //   140: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 120	com/tencent/mm/protocal/protobuf/esy:PyW	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 122
    //   151: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 125	com/tencent/mm/protocal/protobuf/esy:PyX	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 127
    //   162: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 129	com/tencent/mm/protocal/protobuf/esy:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 131
    //   173: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 134	com/tencent/mm/protocal/protobuf/esy:fVx	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 136
    //   184: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 139	com/tencent/mm/protocal/protobuf/esy:vhY	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 141
    //   195: ldc2_w 142
    //   198: invokevirtual 147	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 151	com/tencent/mm/protocal/protobuf/esy:UuV	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 153
    //   209: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 156	com/tencent/mm/protocal/protobuf/esy:UuW	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 158
    //   220: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 161	com/tencent/mm/protocal/protobuf/esy:UuX	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 163
    //   231: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 166	com/tencent/mm/protocal/protobuf/esy:PyY	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 168
    //   242: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 171	com/tencent/mm/protocal/protobuf/esy:PyZ	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 173
    //   253: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 179	com/tencent/mm/protocal/protobuf/esy:UuY	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 181
    //   264: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 184	com/tencent/mm/protocal/protobuf/esy:TIg	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 186
    //   275: aload 8
    //   277: getfield 151	com/tencent/mm/protocal/protobuf/esy:UuV	J
    //   280: invokevirtual 147	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 189	com/tencent/mm/protocal/protobuf/esy:Uve	J
    //   286: aload 8
    //   288: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   291: putfield 196	com/tencent/mm/protocal/protobuf/esy:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 199	com/tencent/mm/protocal/protobuf/esy:fxt	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 202	com/tencent/mm/protocal/protobuf/esy:BHW	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 205	com/tencent/mm/protocal/protobuf/esy:Uva	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 208	com/tencent/mm/protocal/protobuf/esy:fwf	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 211	com/tencent/mm/protocal/protobuf/esy:UuZ	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 213
    //   331: iconst_0
    //   332: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 216	com/tencent/mm/protocal/protobuf/esy:Uvd	I
    //   338: aload 8
    //   340: aload_0
    //   341: ldc 218
    //   343: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 221	com/tencent/mm/protocal/protobuf/esy:fvZ	Ljava/lang/String;
    //   349: aload 8
    //   351: aload_0
    //   352: ldc 223
    //   354: iconst_1
    //   355: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   358: putfield 226	com/tencent/mm/protocal/protobuf/esy:Uvo	I
    //   361: aload_0
    //   362: ldc 228
    //   364: invokevirtual 232	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   367: astore 5
    //   369: aload 5
    //   371: ifnull +42 -> 413
    //   374: aload 8
    //   376: aload 5
    //   378: ldc 234
    //   380: invokevirtual 237	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   383: putfield 240	com/tencent/mm/protocal/protobuf/esy:Uvi	Z
    //   386: aload 8
    //   388: aload 5
    //   390: ldc 242
    //   392: ldc 244
    //   394: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   397: putfield 250	com/tencent/mm/protocal/protobuf/esy:zGJ	Ljava/lang/String;
    //   400: aload 8
    //   402: aload 5
    //   404: ldc 252
    //   406: iconst_0
    //   407: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   410: putfield 255	com/tencent/mm/protocal/protobuf/esy:Uvm	I
    //   413: aload_0
    //   414: ldc_w 257
    //   417: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   420: astore 5
    //   422: aload 5
    //   424: ifnull +16 -> 440
    //   427: aload 8
    //   429: getfield 265	com/tencent/mm/protocal/protobuf/esy:Pye	Ljava/util/LinkedList;
    //   432: aload 5
    //   434: invokevirtual 271	org/json/JSONArray:toString	()Ljava/lang/String;
    //   437: invokestatic 277	com/tencent/mm/plugin/topstory/a/h:s	(Ljava/util/List;Ljava/lang/String;)V
    //   440: aload_0
    //   441: ldc_w 279
    //   444: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   447: astore 5
    //   449: aload 5
    //   451: ifnull +10 -> 461
    //   454: aload 5
    //   456: aload 8
    //   458: invokestatic 282	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   461: aload_0
    //   462: ldc_w 284
    //   465: iconst_0
    //   466: invokevirtual 287	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   469: ifne +15 -> 484
    //   472: aload_0
    //   473: ldc_w 289
    //   476: invokevirtual 232	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   479: aload 8
    //   481: invokestatic 291	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   484: aload_0
    //   485: ldc_w 293
    //   488: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   491: astore 5
    //   493: aload 5
    //   495: ifnull +313 -> 808
    //   498: aload 5
    //   500: iconst_0
    //   501: invokevirtual 296	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   504: astore 5
    //   506: aload 8
    //   508: new 298	com/tencent/mm/protocal/protobuf/esr
    //   511: dup
    //   512: invokespecial 299	com/tencent/mm/protocal/protobuf/esr:<init>	()V
    //   515: putfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   518: aload 8
    //   520: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   523: aload 5
    //   525: ldc_w 305
    //   528: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: putfield 308	com/tencent/mm/protocal/protobuf/esr:Uus	Ljava/lang/String;
    //   534: aload 8
    //   536: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   539: aload 5
    //   541: ldc_w 310
    //   544: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   547: putfield 312	com/tencent/mm/protocal/protobuf/esr:id	Ljava/lang/String;
    //   550: aload 5
    //   552: ldc_w 314
    //   555: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   558: iconst_0
    //   559: invokevirtual 296	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   562: astore 5
    //   564: aload 8
    //   566: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   569: aload 5
    //   571: ldc_w 316
    //   574: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   577: putfield 319	com/tencent/mm/protocal/protobuf/esr:MFF	I
    //   580: aload 8
    //   582: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   585: aload 5
    //   587: ldc_w 321
    //   590: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   593: putfield 323	com/tencent/mm/protocal/protobuf/esr:endTime	I
    //   596: aload 8
    //   598: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   601: aload 5
    //   603: ldc_w 325
    //   606: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   609: putfield 328	com/tencent/mm/protocal/protobuf/esr:Uur	I
    //   612: aload 8
    //   614: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   617: aload 5
    //   619: ldc_w 330
    //   622: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   625: putfield 332	com/tencent/mm/protocal/protobuf/esr:type	I
    //   628: aload 8
    //   630: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   633: aload 5
    //   635: ldc_w 310
    //   638: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   641: putfield 335	com/tencent/mm/protocal/protobuf/esr:oWx	Ljava/lang/String;
    //   644: new 53	org/json/JSONObject
    //   647: dup
    //   648: aload 5
    //   650: ldc_w 337
    //   653: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   656: invokespecial 340	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   659: astore 5
    //   661: aload 8
    //   663: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   666: new 342	com/tencent/mm/protocal/protobuf/esq
    //   669: dup
    //   670: invokespecial 343	com/tencent/mm/protocal/protobuf/esq:<init>	()V
    //   673: putfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   676: aload 8
    //   678: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   681: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   684: aload 5
    //   686: ldc 98
    //   688: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   691: putfield 348	com/tencent/mm/protocal/protobuf/esq:title	Ljava/lang/String;
    //   694: aload 8
    //   696: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   699: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   702: aload 5
    //   704: ldc_w 350
    //   707: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   710: putfield 352	com/tencent/mm/protocal/protobuf/esq:desc	Ljava/lang/String;
    //   713: aload 8
    //   715: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   718: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   721: aload 5
    //   723: ldc_w 354
    //   726: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: putfield 357	com/tencent/mm/protocal/protobuf/esq:fWP	Ljava/lang/String;
    //   732: aload 8
    //   734: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   737: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   740: aload 5
    //   742: ldc_w 359
    //   745: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   748: putfield 362	com/tencent/mm/protocal/protobuf/esq:Uup	Ljava/lang/String;
    //   751: aload 8
    //   753: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   756: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   759: aload 5
    //   761: ldc_w 364
    //   764: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   767: putfield 367	com/tencent/mm/protocal/protobuf/esq:Uuq	Ljava/lang/String;
    //   770: aload 8
    //   772: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   775: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   778: aload 5
    //   780: ldc_w 369
    //   783: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   786: putfield 371	com/tencent/mm/protocal/protobuf/esq:appId	Ljava/lang/String;
    //   789: aload 8
    //   791: getfield 303	com/tencent/mm/protocal/protobuf/esy:Uvn	Lcom/tencent/mm/protocal/protobuf/esr;
    //   794: getfield 347	com/tencent/mm/protocal/protobuf/esr:Uut	Lcom/tencent/mm/protocal/protobuf/esq;
    //   797: aload 5
    //   799: ldc_w 373
    //   802: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   805: putfield 375	com/tencent/mm/protocal/protobuf/esq:avatar	Ljava/lang/String;
    //   808: aload_0
    //   809: ldc_w 377
    //   812: invokevirtual 232	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   815: astore 5
    //   817: aload 5
    //   819: ifnull +101 -> 920
    //   822: aload 8
    //   824: new 379	com/tencent/mm/protocal/protobuf/est
    //   827: dup
    //   828: invokespecial 380	com/tencent/mm/protocal/protobuf/est:<init>	()V
    //   831: putfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   834: aload 8
    //   836: getfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   839: aload 5
    //   841: ldc_w 386
    //   844: iconst_2
    //   845: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   848: putfield 389	com/tencent/mm/protocal/protobuf/est:Rna	I
    //   851: aload 8
    //   853: getfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   856: aload 5
    //   858: ldc_w 391
    //   861: ldc 244
    //   863: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   866: putfield 394	com/tencent/mm/protocal/protobuf/est:Uuy	Ljava/lang/String;
    //   869: aload 8
    //   871: getfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   874: aload 5
    //   876: ldc_w 396
    //   879: iconst_1
    //   880: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   883: putfield 399	com/tencent/mm/protocal/protobuf/est:Uux	I
    //   886: aload 8
    //   888: getfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   891: aload 5
    //   893: ldc_w 401
    //   896: iconst_0
    //   897: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   900: putfield 404	com/tencent/mm/protocal/protobuf/est:Uuz	I
    //   903: aload 8
    //   905: getfield 384	com/tencent/mm/protocal/protobuf/esy:Uvf	Lcom/tencent/mm/protocal/protobuf/est;
    //   908: aload 5
    //   910: ldc_w 406
    //   913: iconst_0
    //   914: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   917: putfield 409	com/tencent/mm/protocal/protobuf/est:UuA	I
    //   920: aload_0
    //   921: ldc_w 411
    //   924: invokevirtual 232	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   927: astore_0
    //   928: aload_0
    //   929: ifnull +350 -> 1279
    //   932: aload 8
    //   934: new 73	com/tencent/mm/protocal/protobuf/esy
    //   937: dup
    //   938: invokespecial 74	com/tencent/mm/protocal/protobuf/esy:<init>	()V
    //   941: putfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   944: aload 8
    //   946: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   949: aload_0
    //   950: ldc 59
    //   952: ldc 244
    //   954: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   957: putfield 202	com/tencent/mm/protocal/protobuf/esy:BHW	Ljava/lang/String;
    //   960: aload 8
    //   962: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   965: aload_0
    //   966: ldc 98
    //   968: ldc 244
    //   970: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   973: putfield 100	com/tencent/mm/protocal/protobuf/esy:title	Ljava/lang/String;
    //   976: aload 8
    //   978: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   981: aload_0
    //   982: ldc 61
    //   984: iconst_0
    //   985: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   988: putfield 96	com/tencent/mm/protocal/protobuf/esy:KFK	I
    //   991: aload 8
    //   993: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   996: aload_0
    //   997: ldc 173
    //   999: iconst_0
    //   1000: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1003: putfield 179	com/tencent/mm/protocal/protobuf/esy:UuY	I
    //   1006: aload 8
    //   1008: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1011: aload_0
    //   1012: ldc 51
    //   1014: ldc 244
    //   1016: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1019: putfield 78	com/tencent/mm/protocal/protobuf/esy:Crh	Ljava/lang/String;
    //   1022: aload_0
    //   1023: ldc_w 279
    //   1026: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1029: astore 5
    //   1031: aload 5
    //   1033: ifnull +13 -> 1046
    //   1036: aload 5
    //   1038: aload 8
    //   1040: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1043: invokestatic 282	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   1046: aload_0
    //   1047: ldc_w 289
    //   1050: invokevirtual 232	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1053: astore 5
    //   1055: aload 5
    //   1057: ifnull +13 -> 1070
    //   1060: aload 5
    //   1062: aload 8
    //   1064: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1067: invokestatic 291	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   1070: aload_0
    //   1071: ldc_w 257
    //   1074: invokevirtual 261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1077: astore 5
    //   1079: aload 5
    //   1081: ifnull +19 -> 1100
    //   1084: aload 8
    //   1086: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1089: getfield 265	com/tencent/mm/protocal/protobuf/esy:Pye	Ljava/util/LinkedList;
    //   1092: aload 5
    //   1094: invokevirtual 271	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1097: invokestatic 277	com/tencent/mm/plugin/topstory/a/h:s	(Ljava/util/List;Ljava/lang/String;)V
    //   1100: aload_0
    //   1101: aload 8
    //   1103: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1106: invokestatic 82	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/esy;)V
    //   1109: iload 6
    //   1111: aload 8
    //   1113: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1116: aload_0
    //   1117: invokestatic 85	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/esy;Lorg/json/JSONObject;)V
    //   1120: aload 8
    //   1122: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1125: aload 8
    //   1127: getfield 129	com/tencent/mm/protocal/protobuf/esy:source	Ljava/lang/String;
    //   1130: putfield 129	com/tencent/mm/protocal/protobuf/esy:source	Ljava/lang/String;
    //   1133: aload 8
    //   1135: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1138: aload 8
    //   1140: getfield 134	com/tencent/mm/protocal/protobuf/esy:fVx	Ljava/lang/String;
    //   1143: putfield 134	com/tencent/mm/protocal/protobuf/esy:fVx	Ljava/lang/String;
    //   1146: aload 8
    //   1148: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1151: aload 8
    //   1153: getfield 184	com/tencent/mm/protocal/protobuf/esy:TIg	Ljava/lang/String;
    //   1156: putfield 184	com/tencent/mm/protocal/protobuf/esy:TIg	Ljava/lang/String;
    //   1159: aload 8
    //   1161: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1164: aload 8
    //   1166: getfield 189	com/tencent/mm/protocal/protobuf/esy:Uve	J
    //   1169: putfield 189	com/tencent/mm/protocal/protobuf/esy:Uve	J
    //   1172: aload 8
    //   1174: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1177: aload 8
    //   1179: getfield 105	com/tencent/mm/protocal/protobuf/esy:pqW	Ljava/lang/String;
    //   1182: putfield 105	com/tencent/mm/protocal/protobuf/esy:pqW	Ljava/lang/String;
    //   1185: aload 8
    //   1187: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1190: aload 8
    //   1192: getfield 110	com/tencent/mm/protocal/protobuf/esy:CHR	Ljava/lang/String;
    //   1195: putfield 110	com/tencent/mm/protocal/protobuf/esy:CHR	Ljava/lang/String;
    //   1198: aload 8
    //   1200: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1203: aload 8
    //   1205: getfield 156	com/tencent/mm/protocal/protobuf/esy:UuW	Ljava/lang/String;
    //   1208: putfield 156	com/tencent/mm/protocal/protobuf/esy:UuW	Ljava/lang/String;
    //   1211: aload 8
    //   1213: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1216: aload 8
    //   1218: getfield 115	com/tencent/mm/protocal/protobuf/esy:PyV	Ljava/lang/String;
    //   1221: putfield 115	com/tencent/mm/protocal/protobuf/esy:PyV	Ljava/lang/String;
    //   1224: aload 8
    //   1226: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1229: aload 8
    //   1231: getfield 120	com/tencent/mm/protocal/protobuf/esy:PyW	Ljava/lang/String;
    //   1234: putfield 120	com/tencent/mm/protocal/protobuf/esy:PyW	Ljava/lang/String;
    //   1237: aload 8
    //   1239: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1242: aload 8
    //   1244: getfield 125	com/tencent/mm/protocal/protobuf/esy:PyX	Ljava/lang/String;
    //   1247: putfield 125	com/tencent/mm/protocal/protobuf/esy:PyX	Ljava/lang/String;
    //   1250: aload 8
    //   1252: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1255: aload 8
    //   1257: getfield 156	com/tencent/mm/protocal/protobuf/esy:UuW	Ljava/lang/String;
    //   1260: putfield 156	com/tencent/mm/protocal/protobuf/esy:UuW	Ljava/lang/String;
    //   1263: aload 8
    //   1265: getfield 415	com/tencent/mm/protocal/protobuf/esy:Uvl	Lcom/tencent/mm/protocal/protobuf/esy;
    //   1268: aload_0
    //   1269: ldc 136
    //   1271: ldc 244
    //   1273: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1276: putfield 139	com/tencent/mm/protocal/protobuf/esy:vhY	Ljava/lang/String;
    //   1279: aload 8
    //   1281: getfield 88	com/tencent/mm/protocal/protobuf/esy:videoUrl	Ljava/lang/String;
    //   1284: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1287: ifne +51 -> 1338
    //   1290: ldc_w 417
    //   1293: ldc_w 419
    //   1296: iconst_3
    //   1297: anewarray 4	java/lang/Object
    //   1300: dup
    //   1301: iconst_0
    //   1302: aload 8
    //   1304: getfield 78	com/tencent/mm/protocal/protobuf/esy:Crh	Ljava/lang/String;
    //   1307: aastore
    //   1308: dup
    //   1309: iconst_1
    //   1310: aload 8
    //   1312: getfield 88	com/tencent/mm/protocal/protobuf/esy:videoUrl	Ljava/lang/String;
    //   1315: aastore
    //   1316: dup
    //   1317: iconst_2
    //   1318: aload 8
    //   1320: getfield 422	com/tencent/mm/protocal/protobuf/esy:Uvb	J
    //   1323: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1326: aastore
    //   1327: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1330: ldc 49
    //   1332: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1335: aload 8
    //   1337: areturn
    //   1338: ldc 49
    //   1340: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1343: aconst_null
    //   1344: areturn
    //   1345: ldc 49
    //   1347: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1350: aconst_null
    //   1351: areturn
    //   1352: astore 5
    //   1354: goto -546 -> 808
    //   1357: astore 5
    //   1359: goto -551 -> 808
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1362	0	paramJSONObject	JSONObject
    //   0	1362	1	paramLong1	long
    //   0	1362	3	paramLong2	long
    //   0	1362	5	paramString	String
    //   0	1362	6	paramBoolean	boolean
    //   28	59	7	i	int
    //   45	1291	8	localesy	esy
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   484	493	1352	java/lang/Exception
    //   498	808	1357	java/lang/Exception
  }
  
  private static List<esy> a(boolean paramBoolean, JSONArray paramJSONArray)
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
          esy localesy = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localesy != null)
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localesy.Crh, localesy.videoUrl, Long.valueOf(localesy.Uvb) });
            localArrayList.add(localesy);
          }
          for (;;)
          {
            j += 1;
            break;
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", new Object[] { localJSONObject.toString() });
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(126134);
    return localArrayList;
  }
  
  private static void a(esy paramesy, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126142);
    Object localObject7 = null;
    InputStream localInputStream1 = null;
    Object localObject8 = null;
    String str = null;
    x localx = null;
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
      j = grA();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      k = avq();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      m = grB();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", new Object[] { paramString1 });
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      if (!URLUtil.isHttpsUrl(paramString1)) {
        break label522;
      }
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1 = com.tencent.mm.network.d.Zr(paramString1);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.btG();
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.xz(3000);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.xA(3000);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      localInputStream1 = paramString1.mvV.getInputStream();
    }
    catch (Throwable paramesy)
    {
      int j;
      int k;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramesy, "getVideoUrlByVideoApi error: %s", new Object[] { paramesy.getMessage() });
        if (localObject4 != null) {
          ((x)localObject4).disconnect();
        }
        if (localObject3 != null) {
          ((aa)localObject3).disconnect();
        }
        if (localInputStream2 == null) {
          break;
        }
        ad.closeQuietly(localInputStream2);
        AppMethodBeat.o(126142);
        return;
        localObject3 = localJSONArray;
        localObject4 = localObject8;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = str;
        localObject5 = localObject7;
        localx = com.tencent.mm.network.d.a(paramString1, null);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localx.gM(true);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localx.xz(3000);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localx.xA(3000);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localInputStream1 = localx.getInputStream();
        paramString1 = (String)localObject6;
      }
      localObject3 = paramString1;
      localObject4 = localx;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localx;
      localObject5 = localInputStream1;
      localObject6 = new JSONObject(localStringBuilder.toString().substring(13));
      localObject3 = paramString1;
      localObject4 = localx;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localx;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject6).optJSONObject("fl");
      if (localObject7 == null) {
        break label931;
      }
      localObject3 = paramString1;
      localObject4 = localx;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localx;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject7).optJSONArray("fi");
      if (localObject7 == null) {
        break label931;
      }
      int i = 0;
      for (;;)
      {
        localObject3 = paramString1;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localx;
        localObject5 = localInputStream1;
        if (i < ((JSONArray)localObject7).length())
        {
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject8 = ((JSONArray)localObject7).getJSONObject(i);
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          if (((JSONObject)localObject8).optInt("sl", 0) == 1)
          {
            localObject3 = paramString1;
            localObject4 = localx;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localx;
            localObject5 = localInputStream1;
            paramesy.Uvb = ((JSONObject)localObject8).optLong("fs");
          }
        }
        else
        {
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONObject("vl");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONArray("vi");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          if (((JSONArray)localObject6).length() <= 0) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject6 = ((JSONArray)localObject6).getJSONObject(0);
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject8 = ((JSONObject)localObject6).optString("fn");
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          str = ((JSONObject)localObject6).optString("fvkey");
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localObject6 = ((JSONObject)localObject6).optJSONObject("ul");
          if (localObject6 == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          localJSONArray = ((JSONObject)localObject6).optJSONArray("ui");
          if (localJSONArray == null) {
            break;
          }
          localObject3 = paramString1;
          localObject4 = localx;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localx;
          localObject5 = localInputStream1;
          if (localJSONArray.length() <= 0) {
            break;
          }
          i = 0;
          for (;;)
          {
            localObject3 = paramString1;
            localObject4 = localx;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localx;
            localObject5 = localInputStream1;
            if (i >= localJSONArray.length()) {
              break;
            }
            localObject3 = paramString1;
            localObject4 = localx;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localx;
            localObject5 = localInputStream1;
            localObject6 = localJSONArray.getJSONObject(i);
            if (localObject6 != null)
            {
              localObject3 = paramString1;
              localObject4 = localx;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localx;
              localObject5 = localInputStream1;
              localObject7 = ((JSONObject)localObject6).optString("url");
              localObject3 = paramString1;
              localObject4 = localx;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localx;
              localObject5 = localInputStream1;
              int n = ((JSONObject)localObject6).optInt("vt", 0);
              localObject3 = paramString1;
              localObject4 = localx;
              localInputStream2 = localInputStream1;
              localObject1 = paramString1;
              localObject2 = localx;
              localObject5 = localInputStream1;
              if (!Util.isNullOrNil((String)localObject7))
              {
                localObject3 = paramString1;
                localObject4 = localx;
                localInputStream2 = localInputStream1;
                localObject1 = paramString1;
                localObject2 = localx;
                localObject5 = localInputStream1;
                if (!Util.isNullOrNil(str))
                {
                  localObject3 = paramString1;
                  localObject4 = localx;
                  localInputStream2 = localInputStream1;
                  localObject1 = paramString1;
                  localObject2 = localx;
                  localObject5 = localInputStream1;
                  if (!Util.isNullOrNil((String)localObject8))
                  {
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    localObject7 = (String)localObject7 + (String)localObject8 + "?vkey=" + str;
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject6 = localObject7;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    if (!Util.isNullOrNil(paramString2))
                    {
                      localObject3 = paramString1;
                      localObject4 = localx;
                      localInputStream2 = localInputStream1;
                      localObject1 = paramString1;
                      localObject2 = localx;
                      localObject5 = localInputStream1;
                      localObject6 = (String)localObject7 + "&platform=" + paramString2;
                    }
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    localObject6 = c((String)localObject6, "&", j, k, m);
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    localObject7 = new eta();
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    ((eta)localObject7).url = ((String)localObject6);
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    ((eta)localObject7).Uvk = n;
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    paramesy.Uvc.add(localObject7);
                  }
                }
              }
            }
            i += 1;
          }
        }
        i += 1;
      }
      if (localx == null) {
        break label1781;
      }
      localx.disconnect();
      if (paramString1 == null) {
        break label1789;
      }
      paramString1.disconnect();
      if (localInputStream1 == null) {
        break label1845;
      }
      ad.closeQuietly(localInputStream1);
      AppMethodBeat.o(126142);
      return;
    }
    finally
    {
      if (localObject2 == null) {
        break label1817;
      }
      ((x)localObject2).disconnect();
      if (localObject1 == null) {
        break label1827;
      }
      ((aa)localObject1).disconnect();
      if (localObject5 == null) {
        break label1837;
      }
      ad.closeQuietly((Closeable)localObject5);
      AppMethodBeat.o(126142);
    }
    localObject3 = paramString1;
    localObject4 = localx;
    localInputStream2 = localInputStream1;
    localObject1 = paramString1;
    localObject2 = localx;
    localObject5 = localInputStream1;
    localObject6 = new BufferedReader(new InputStreamReader(localInputStream1));
    for (;;)
    {
      localObject3 = paramString1;
      localObject4 = localx;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localx;
      localObject5 = localInputStream1;
      localObject7 = ((BufferedReader)localObject6).readLine();
      if (localObject7 == null) {
        break;
      }
      localObject3 = paramString1;
      localObject4 = localx;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localx;
      localObject5 = localInputStream1;
      localStringBuilder.append((String)localObject7);
    }
    label522:
    label931:
    label1781:
    label1789:
    AppMethodBeat.o(126142);
    label1817:
    label1827:
    label1837:
    label1845:
    return;
  }
  
  private static void a(JSONArray paramJSONArray, esy paramesy)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      eij localeij = new eij();
      localeij.id = paramJSONArray.getJSONObject(i).optString("id");
      localeij.wording = paramJSONArray.getJSONObject(i).optString("wording");
      localeij.Ukr = paramJSONArray.getJSONObject(i).optLong("category");
      localeij.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localeij.url = paramJSONArray.getJSONObject(i).optString("url");
      localeij.title = paramJSONArray.getJSONObject(i).optString("title");
      localeij.rsw = paramJSONArray.getJSONObject(i).optString("subTitle");
      localeij.icon = paramJSONArray.getJSONObject(i).optString("icon");
      paramesy.Crg.add(localeij);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, esy paramesy)
  {
    AppMethodBeat.i(126137);
    paramesy.Uvj = new esw();
    paramesy.Uvj.UuR = paramJSONObject.optString("detailWording");
    paramesy.Uvj.UuS = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        aoz localaoz = new aoz();
        localaoz.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localaoz.wording = paramJSONObject.optJSONObject(i).optString("wording", "");
        localaoz.SCd = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        paramesy.Uvj.UuT.add(localaoz);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, esy paramesy, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    paramesy.UuU = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      paramesy.thumbWidth = 360;
    }
    for (paramesy.thumbHeight = 640;; paramesy.thumbHeight = 280)
    {
      if (Util.isNullOrNil(paramesy.UuU)) {
        paramesy.UuU = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramesy.Crh + String.format("_%s_%s/0", new Object[] { Integer.valueOf(paramesy.thumbWidth), Integer.valueOf(paramesy.thumbHeight) }));
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { paramesy.Crh, paramesy.UuU });
      AppMethodBeat.o(126140);
      return;
      paramesy.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, esy paramesy, JSONObject paramJSONObject)
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
            paramesy.Uvb = localJSONObject.optInt("filesize", 0);
            eta localeta = new eta();
            localeta.url = localJSONObject.optString("url");
            localeta.Uvk = 0;
            paramesy.Uvc.add(localeta);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramesy.UuU = paramJSONObject.optString("coverUrl");
          if (paramesy.Uvb > 0L)
          {
            boolean bool = Util.isNullOrNil(paramesy.Uvc);
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
      catch (Exception paramesy)
      {
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramesy.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  public static boolean a(esy paramesy, Context paramContext)
  {
    AppMethodBeat.i(202669);
    if (paramesy != null)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile sJumpType:%s", new Object[] { Integer.valueOf(paramesy.Uvo) });
      Object localObject;
      if (paramesy.Uvo == 1)
      {
        if (!Util.isNullOrNil(paramesy.fVx))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramesy.fVx);
          com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(202669);
          return true;
        }
      }
      else if ((paramesy.Uvo == 2) && (!TextUtils.isEmpty(paramesy.fvZ)))
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramesy.fvZ);
        if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).jxt > 0))
        {
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact exist");
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramesy.fvZ);
          ((Intent)localObject).putExtra("biz_profile_tab_type", 1);
          com.tencent.mm.by.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(202669);
          return true;
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact not exist, getNow");
          boolean[] arrayOfBoolean = new boolean[1];
          arrayOfBoolean[0] = false;
          localObject = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.g.loading), true, new n.3(arrayOfBoolean));
          try
          {
            az.a.ltq.a(paramesy.fvZ, "", new n.4((s)localObject, arrayOfBoolean, paramesy, paramContext));
          }
          catch (Throwable paramesy)
          {
            ((s)localObject).dismiss();
            Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile err:%s", new Object[] { paramesy.getMessage() });
          }
        }
      }
    }
    AppMethodBeat.o(202669);
    return false;
  }
  
  public static int avq()
  {
    AppMethodBeat.i(126144);
    switch (NetStatusUtil.getNetType(MMApplicationContext.getContext()))
    {
    default: 
      if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
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
    if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(126144);
      return 3;
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(126144);
      return 4;
    }
    AppMethodBeat.o(126144);
    return 0;
  }
  
  private static void b(JSONObject paramJSONObject, esy paramesy)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, paramesy)))
    {
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.iy(paramesy.Uvc);
      if (paramJSONObject != null)
      {
        paramesy.videoUrl = paramJSONObject.url;
        paramesy.Uvk = paramJSONObject.Uvk;
      }
    }
    if ((Util.isNullOrNil(paramesy.videoUrl)) && (!Util.isNullOrNil(str2)))
    {
      a(paramesy, str2, str1);
      if (Util.isNullOrNil(paramesy.Uvc))
      {
        a.rE(29);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(paramesy, str2, str1);
      }
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.iy(paramesy.Uvc);
      if (paramJSONObject != null)
      {
        paramesy.videoUrl = paramJSONObject.url;
        paramesy.Uvk = paramJSONObject.Uvk;
      }
    }
    AppMethodBeat.o(126138);
  }
  
  private static String c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(126146);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126146);
      return paramString1;
    }
    paramString1 = paramString1 + paramString2 + "Unicomtype=" + paramInt1 + "&newnettype=" + paramInt2 + "&Netoperator=" + paramInt3;
    Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(126146);
    return paramString1;
  }
  
  private static boolean c(JSONObject paramJSONObject, esy paramesy)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      paramesy.Uvg = localJSONObject.optInt("cdnScene", 0);
      paramesy.Uvh = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((paramesy.Uvg == 1) || (paramesy.Uvh == 2))
    {
      if (!a(paramesy.Uvg, paramesy, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(paramesy.Uvg), paramesy.Crh, paramesy.title, Long.valueOf(paramesy.Uvb) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static int grA()
  {
    AppMethodBeat.i(126143);
    if (ai.isFreeSimCard())
    {
      AppMethodBeat.o(126143);
      return 2;
    }
    AppMethodBeat.o(126143);
    return -1;
  }
  
  private static int grB()
  {
    AppMethodBeat.i(126145);
    int j = NetStatusUtil.getISPCode(MMApplicationContext.getContext());
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
  
  public static boolean i(esy paramesy)
  {
    AppMethodBeat.i(202668);
    if (paramesy != null)
    {
      if ((paramesy.Uvo == 1) && (!TextUtils.isEmpty(paramesy.fVx)))
      {
        AppMethodBeat.o(202668);
        return true;
      }
      if ((paramesy.Uvo == 2) && (!TextUtils.isEmpty(paramesy.fvZ)))
      {
        AppMethodBeat.o(202668);
        return true;
      }
    }
    AppMethodBeat.o(202668);
    return false;
  }
  
  public final void a(esv paramesv, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = eiH();
        if ((Util.isNullOrNil(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((esy)localList.get(i)).Crh);
            i += 1;
            continue;
          }
          paramesv = new e(paramesv, localArrayList);
          com.tencent.mm.kernel.h.aGY().a(paramesv, 0);
          com.tencent.mm.kernel.h.aGY().a(paramesv.getType(), new n.1(this, paramesv));
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
  
  public final void ajI(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < eiH().size()) {
        eiH().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final esy ajJ(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < eiH().size())
      {
        esy localesy = (esy)eiH().get(paramInt);
        return localesy;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean ajK(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.MTh)
    {
      Log.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.MTh = true;
    esv localesv = com.tencent.mm.plugin.topstory.a.h.a(this.MYE.gqA());
    localesv.offset = paramInt;
    Object localObject1;
    if (!Util.isNullOrNil(this.MYE.gqA().UuD))
    {
      localObject1 = new aci();
      ((aci)localObject1).key = "relevant_vid";
      ((aci)localObject1).SnW = this.MYE.gqA().UuD;
      localesv.Pye.add(localObject1);
    }
    if (!Util.isNullOrNil(this.MYE.gqA().UuE))
    {
      localObject1 = new aci();
      ((aci)localObject1).key = "relevant_expand";
      ((aci)localObject1).SnW = this.MYE.gqA().UuE;
      localesv.Pye.add(localObject1);
    }
    if (!Util.isNullOrNil(this.MYE.gqA().UuF))
    {
      localObject1 = new aci();
      ((aci)localObject1).key = "relevant_pre_searchid";
      ((aci)localObject1).SnW = this.MYE.gqA().UuF;
      localesv.Pye.add(localObject1);
    }
    if (!Util.isNullOrNil(this.MYE.gqA().UuG))
    {
      localObject1 = new aci();
      ((aci)localObject1).key = "relevant_shared_openid";
      ((aci)localObject1).SnW = this.MYE.gqA().UuG;
      localesv.Pye.add(localObject1);
    }
    if (this.MYE.gqA().UuJ != null)
    {
      localObject1 = new aci();
      ((aci)localObject1).key = "rec_category";
      ((aci)localObject1).SnV = this.MYE.gqA().UuJ.Ukr;
      localesv.Pye.add(localObject1);
      localObject1 = localesv.Pye.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((aci)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.MYE.gqA().UuJ != null) && (paramInt != 0))
      {
        localObject1 = new aci();
        ((aci)localObject1).key = "show_tag_list";
        ((aci)localObject1).SnW = this.MYE.gqA().UuJ.id;
        localesv.Pye.add(localObject1);
      }
      localObject1 = new aci();
      ((aci)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label653:
      com.tencent.mm.plugin.topstory.a.b.c localc;
      if ((this.MYE.gqA().UuJ != null) && (!Util.isNullOrNil(this.MYE.gqA().UuJ.id)))
      {
        ((aci)localObject1).SnV = 0L;
        localesv.Pye.add(localObject1);
        if (grz() == 1)
        {
          localObject1 = ajJ(0);
          localObject2 = new aci();
          ((aci)localObject2).key = "first_video_tag_list";
          ((aci)localObject2).SnW = com.tencent.mm.plugin.topstory.a.h.iz(((esy)localObject1).Crg).toString();
          localesv.Pye.add(localObject2);
        }
        localObject1 = this.MYE.gqy();
        if (((o)localObject1).NaE.size() <= 0) {
          break label928;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).NaE.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label779;
        }
        localc = (com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next();
        if (!localc.MWt) {
          break label774;
        }
      }
      label774:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.MWs.Crh);
        ((StringBuffer)localObject1).append(";");
        break label653;
        localObject1 = new aci();
        ((aci)localObject1).key = "rec_category";
        ((aci)localObject1).SnV = this.MYE.gqA().UuH;
        localesv.Pye.add(localObject1);
        break;
        ((aci)localObject1).SnV = 1L;
        break label521;
      }
      label779:
      label928:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = new aci();
          ((aci)localObject2).key = "client_exposed_info";
          ((aci)localObject2).SnW = ((String)localObject1);
          localesv.Pye.add(localObject2);
        }
        localObject1 = new aci();
        ((aci)localObject1).key = "is_prefetch";
        ((aci)localObject1).SnV = this.Nar;
        localesv.Pye.add(localObject1);
        if (this.Nas != null)
        {
          com.tencent.mm.kernel.h.aGY().a(this.Nas);
          this.Nas = null;
        }
        this.Nas = new k(localesv);
        com.tencent.mm.kernel.h.aGY().a(this.Nas, 0);
        com.tencent.mm.kernel.h.aGY().a(1943, this.jxB);
        a.rE(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final List<esy> eiH()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.MYE.gqA().UuL;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final int grz()
  {
    AppMethodBeat.i(126127);
    int i = eiH().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void h(esy paramesy)
  {
    AppMethodBeat.i(126128);
    try
    {
      eiH().add(paramesy);
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
    if (this.Nas != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.Nas);
      this.Nas = null;
    }
    if (this.Nav != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.Nav);
      this.Nav = null;
    }
    com.tencent.mm.kernel.h.aGY().b(1943, this.jxB);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private boolean CAd;
    private String wzd;
    
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
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:wzd	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:Nax	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:CAd	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:Nax	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:MTh	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:Nax	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:MTh	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:Nax	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:MTh	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */