package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.d;
import com.tencent.mm.network.y;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fof;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.ah;
import com.tencent.threadpool.i;
import java.io.BufferedReader;
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
  public boolean TFx;
  public b TLn;
  public int TNa;
  k TNb;
  private int TNc;
  private int TNd;
  public com.tencent.mm.plugin.topstory.a.c.h TNe;
  public com.tencent.mm.am.h maV;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousp });
        if (paramAnonymousp.equals(n.this.TNb))
        {
          com.tencent.mm.kernel.h.aZW().b(1943, n.this.maV);
          n.this.TNb = null;
          paramAnonymousp = (k)paramAnonymousp;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousp.hMQ().aayd });
            a.rG(2);
            n.this.TLn.bez(paramAnonymousString);
            n.this.TFx = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousp.hMQ().aayd);
          if (paramAnonymousp.TIY.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.threadpool.h.ahAA.g(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousp.equals(n.this.TNe))
        {
          com.tencent.mm.kernel.h.aZW().b(1943, n.this.maV);
          n.this.TNe = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousp;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.rG(2);
            AppMethodBeat.o(126123);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.hMQ().aayd });
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.hMQ().aayd).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.TLn.hNH(), (JSONArray)localObject);
                  paramAnonymousString.TIZ.abOG.abOd.addAll((Collection)localObject);
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
  private static foh a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 55
    //   8: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 63
    //   16: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 65
    //   24: iconst_0
    //   25: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 7
    //   30: aload 9
    //   32: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1311 -> 1346
    //   38: new 77	com/tencent/mm/protocal/protobuf/foh
    //   41: dup
    //   42: invokespecial 78	com/tencent/mm/protocal/protobuf/foh:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 82	com/tencent/mm/protocal/protobuf/foh:Ido	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 86	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 89	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/foh;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 92	com/tencent/mm/protocal/protobuf/foh:videoUrl	Ljava/lang/String;
    //   73: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 97	com/tencent/mm/plugin/websearch/api/a/a:rG	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 100	com/tencent/mm/protocal/protobuf/foh:Rfk	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 102
    //   96: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 104	com/tencent/mm/protocal/protobuf/foh:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 106
    //   107: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 109	com/tencent/mm/protocal/protobuf/foh:svG	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 111
    //   118: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 114	com/tencent/mm/protocal/protobuf/foh:ICb	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 116
    //   129: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 119	com/tencent/mm/protocal/protobuf/foh:Wpe	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 121
    //   140: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 124	com/tencent/mm/protocal/protobuf/foh:Wpf	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 126
    //   151: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 129	com/tencent/mm/protocal/protobuf/foh:Wpg	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 131
    //   162: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 133	com/tencent/mm/protocal/protobuf/foh:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 135
    //   173: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 138	com/tencent/mm/protocal/protobuf/foh:ibx	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 140
    //   184: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 143	com/tencent/mm/protocal/protobuf/foh:ytZ	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 145
    //   195: ldc2_w 146
    //   198: invokevirtual 151	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 155	com/tencent/mm/protocal/protobuf/foh:abOw	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 157
    //   209: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 160	com/tencent/mm/protocal/protobuf/foh:abOx	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 162
    //   220: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 165	com/tencent/mm/protocal/protobuf/foh:abOy	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 167
    //   231: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 170	com/tencent/mm/protocal/protobuf/foh:Wph	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 172
    //   242: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 175	com/tencent/mm/protocal/protobuf/foh:Wpi	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 177
    //   253: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 183	com/tencent/mm/protocal/protobuf/foh:abOz	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 185
    //   264: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 188	com/tencent/mm/protocal/protobuf/foh:aaXP	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 190
    //   275: aload 8
    //   277: getfield 155	com/tencent/mm/protocal/protobuf/foh:abOw	J
    //   280: invokevirtual 151	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 193	com/tencent/mm/protocal/protobuf/foh:abOF	J
    //   286: aload 8
    //   288: invokestatic 197	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   291: putfield 200	com/tencent/mm/protocal/protobuf/foh:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 203	com/tencent/mm/protocal/protobuf/foh:hBY	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 206	com/tencent/mm/protocal/protobuf/foh:HsD	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 209	com/tencent/mm/protocal/protobuf/foh:abOB	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 212	com/tencent/mm/protocal/protobuf/foh:beV	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 215	com/tencent/mm/protocal/protobuf/foh:abOA	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 217
    //   331: iconst_0
    //   332: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 220	com/tencent/mm/protocal/protobuf/foh:abOE	I
    //   338: aload 8
    //   340: aload_0
    //   341: ldc 222
    //   343: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 225	com/tencent/mm/protocal/protobuf/foh:hAw	Ljava/lang/String;
    //   349: aload 8
    //   351: aload_0
    //   352: ldc 227
    //   354: iconst_1
    //   355: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   358: putfield 230	com/tencent/mm/protocal/protobuf/foh:abOP	I
    //   361: aload_0
    //   362: ldc 232
    //   364: invokevirtual 236	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   367: astore 5
    //   369: aload 5
    //   371: ifnull +43 -> 414
    //   374: aload 8
    //   376: aload 5
    //   378: ldc 238
    //   380: invokevirtual 241	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   383: putfield 244	com/tencent/mm/protocal/protobuf/foh:abOJ	Z
    //   386: aload 8
    //   388: aload 5
    //   390: ldc 246
    //   392: ldc 248
    //   394: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   397: putfield 254	com/tencent/mm/protocal/protobuf/foh:ELy	Ljava/lang/String;
    //   400: aload 8
    //   402: aload 5
    //   404: ldc_w 256
    //   407: iconst_0
    //   408: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   411: putfield 259	com/tencent/mm/protocal/protobuf/foh:abON	I
    //   414: aload_0
    //   415: ldc_w 261
    //   418: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   421: astore 5
    //   423: aload 5
    //   425: ifnull +16 -> 441
    //   428: aload 8
    //   430: getfield 269	com/tencent/mm/protocal/protobuf/foh:Wol	Ljava/util/LinkedList;
    //   433: aload 5
    //   435: invokevirtual 275	org/json/JSONArray:toString	()Ljava/lang/String;
    //   438: invokestatic 281	com/tencent/mm/plugin/topstory/a/g:H	(Ljava/util/List;Ljava/lang/String;)V
    //   441: aload_0
    //   442: ldc_w 283
    //   445: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   448: astore 5
    //   450: aload 5
    //   452: ifnull +10 -> 462
    //   455: aload 5
    //   457: aload 8
    //   459: invokestatic 286	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   462: aload_0
    //   463: ldc_w 288
    //   466: iconst_0
    //   467: invokevirtual 291	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   470: ifne +15 -> 485
    //   473: aload_0
    //   474: ldc_w 293
    //   477: invokevirtual 236	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   480: aload 8
    //   482: invokestatic 295	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   485: aload_0
    //   486: ldc_w 297
    //   489: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   492: astore 5
    //   494: aload 5
    //   496: ifnull +313 -> 809
    //   499: aload 5
    //   501: iconst_0
    //   502: invokevirtual 300	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   505: astore 5
    //   507: aload 8
    //   509: new 302	com/tencent/mm/protocal/protobuf/foa
    //   512: dup
    //   513: invokespecial 303	com/tencent/mm/protocal/protobuf/foa:<init>	()V
    //   516: putfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   519: aload 8
    //   521: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   524: aload 5
    //   526: ldc_w 309
    //   529: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 312	com/tencent/mm/protocal/protobuf/foa:abNV	Ljava/lang/String;
    //   535: aload 8
    //   537: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   540: aload 5
    //   542: ldc_w 314
    //   545: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   548: putfield 316	com/tencent/mm/protocal/protobuf/foa:id	Ljava/lang/String;
    //   551: aload 5
    //   553: ldc_w 318
    //   556: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   559: iconst_0
    //   560: invokevirtual 300	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   563: astore 5
    //   565: aload 8
    //   567: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   570: aload 5
    //   572: ldc_w 320
    //   575: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   578: putfield 323	com/tencent/mm/protocal/protobuf/foa:TpP	I
    //   581: aload 8
    //   583: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   586: aload 5
    //   588: ldc_w 325
    //   591: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   594: putfield 327	com/tencent/mm/protocal/protobuf/foa:endTime	I
    //   597: aload 8
    //   599: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   602: aload 5
    //   604: ldc_w 329
    //   607: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   610: putfield 332	com/tencent/mm/protocal/protobuf/foa:abNU	I
    //   613: aload 8
    //   615: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   618: aload 5
    //   620: ldc_w 334
    //   623: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   626: putfield 336	com/tencent/mm/protocal/protobuf/foa:type	I
    //   629: aload 8
    //   631: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   634: aload 5
    //   636: ldc_w 314
    //   639: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   642: putfield 339	com/tencent/mm/protocal/protobuf/foa:sbU	Ljava/lang/String;
    //   645: new 57	org/json/JSONObject
    //   648: dup
    //   649: aload 5
    //   651: ldc_w 341
    //   654: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokespecial 344	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   660: astore 5
    //   662: aload 8
    //   664: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   667: new 346	com/tencent/mm/protocal/protobuf/fnz
    //   670: dup
    //   671: invokespecial 347	com/tencent/mm/protocal/protobuf/fnz:<init>	()V
    //   674: putfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   677: aload 8
    //   679: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   682: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   685: aload 5
    //   687: ldc 102
    //   689: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   692: putfield 352	com/tencent/mm/protocal/protobuf/fnz:title	Ljava/lang/String;
    //   695: aload 8
    //   697: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   700: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   703: aload 5
    //   705: ldc_w 354
    //   708: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   711: putfield 356	com/tencent/mm/protocal/protobuf/fnz:desc	Ljava/lang/String;
    //   714: aload 8
    //   716: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   719: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   722: aload 5
    //   724: ldc_w 358
    //   727: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: putfield 361	com/tencent/mm/protocal/protobuf/fnz:icO	Ljava/lang/String;
    //   733: aload 8
    //   735: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   738: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   741: aload 5
    //   743: ldc_w 363
    //   746: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: putfield 366	com/tencent/mm/protocal/protobuf/fnz:abNS	Ljava/lang/String;
    //   752: aload 8
    //   754: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   757: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   760: aload 5
    //   762: ldc_w 368
    //   765: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   768: putfield 371	com/tencent/mm/protocal/protobuf/fnz:abNT	Ljava/lang/String;
    //   771: aload 8
    //   773: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   776: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   779: aload 5
    //   781: ldc_w 373
    //   784: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: putfield 375	com/tencent/mm/protocal/protobuf/fnz:appId	Ljava/lang/String;
    //   790: aload 8
    //   792: getfield 307	com/tencent/mm/protocal/protobuf/foh:abOO	Lcom/tencent/mm/protocal/protobuf/foa;
    //   795: getfield 351	com/tencent/mm/protocal/protobuf/foa:abNW	Lcom/tencent/mm/protocal/protobuf/fnz;
    //   798: aload 5
    //   800: ldc_w 377
    //   803: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   806: putfield 379	com/tencent/mm/protocal/protobuf/fnz:avatar	Ljava/lang/String;
    //   809: aload_0
    //   810: ldc_w 381
    //   813: invokevirtual 236	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   816: astore 5
    //   818: aload 5
    //   820: ifnull +101 -> 921
    //   823: aload 8
    //   825: new 383	com/tencent/mm/protocal/protobuf/foc
    //   828: dup
    //   829: invokespecial 384	com/tencent/mm/protocal/protobuf/foc:<init>	()V
    //   832: putfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   835: aload 8
    //   837: getfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   840: aload 5
    //   842: ldc_w 390
    //   845: iconst_2
    //   846: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   849: putfield 393	com/tencent/mm/protocal/protobuf/foc:Yjq	I
    //   852: aload 8
    //   854: getfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   857: aload 5
    //   859: ldc_w 395
    //   862: ldc 248
    //   864: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   867: putfield 398	com/tencent/mm/protocal/protobuf/foc:abOa	Ljava/lang/String;
    //   870: aload 8
    //   872: getfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   875: aload 5
    //   877: ldc_w 400
    //   880: iconst_1
    //   881: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   884: putfield 403	com/tencent/mm/protocal/protobuf/foc:abNZ	I
    //   887: aload 8
    //   889: getfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   892: aload 5
    //   894: ldc_w 405
    //   897: iconst_0
    //   898: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   901: putfield 408	com/tencent/mm/protocal/protobuf/foc:abOb	I
    //   904: aload 8
    //   906: getfield 388	com/tencent/mm/protocal/protobuf/foh:abOG	Lcom/tencent/mm/protocal/protobuf/foc;
    //   909: aload 5
    //   911: ldc_w 410
    //   914: iconst_0
    //   915: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   918: putfield 413	com/tencent/mm/protocal/protobuf/foc:abOc	I
    //   921: aload_0
    //   922: ldc_w 415
    //   925: invokevirtual 236	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   928: astore_0
    //   929: aload_0
    //   930: ifnull +350 -> 1280
    //   933: aload 8
    //   935: new 77	com/tencent/mm/protocal/protobuf/foh
    //   938: dup
    //   939: invokespecial 78	com/tencent/mm/protocal/protobuf/foh:<init>	()V
    //   942: putfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   945: aload 8
    //   947: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   950: aload_0
    //   951: ldc 63
    //   953: ldc 248
    //   955: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   958: putfield 206	com/tencent/mm/protocal/protobuf/foh:HsD	Ljava/lang/String;
    //   961: aload 8
    //   963: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   966: aload_0
    //   967: ldc 102
    //   969: ldc 248
    //   971: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   974: putfield 104	com/tencent/mm/protocal/protobuf/foh:title	Ljava/lang/String;
    //   977: aload 8
    //   979: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   982: aload_0
    //   983: ldc 65
    //   985: iconst_0
    //   986: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   989: putfield 100	com/tencent/mm/protocal/protobuf/foh:Rfk	I
    //   992: aload 8
    //   994: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   997: aload_0
    //   998: ldc 177
    //   1000: iconst_0
    //   1001: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1004: putfield 183	com/tencent/mm/protocal/protobuf/foh:abOz	I
    //   1007: aload 8
    //   1009: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1012: aload_0
    //   1013: ldc 55
    //   1015: ldc 248
    //   1017: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1020: putfield 82	com/tencent/mm/protocal/protobuf/foh:Ido	Ljava/lang/String;
    //   1023: aload_0
    //   1024: ldc_w 283
    //   1027: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1030: astore 5
    //   1032: aload 5
    //   1034: ifnull +13 -> 1047
    //   1037: aload 5
    //   1039: aload 8
    //   1041: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1044: invokestatic 286	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   1047: aload_0
    //   1048: ldc_w 293
    //   1051: invokevirtual 236	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1054: astore 5
    //   1056: aload 5
    //   1058: ifnull +13 -> 1071
    //   1061: aload 5
    //   1063: aload 8
    //   1065: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1068: invokestatic 295	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   1071: aload_0
    //   1072: ldc_w 261
    //   1075: invokevirtual 265	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1078: astore 5
    //   1080: aload 5
    //   1082: ifnull +19 -> 1101
    //   1085: aload 8
    //   1087: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1090: getfield 269	com/tencent/mm/protocal/protobuf/foh:Wol	Ljava/util/LinkedList;
    //   1093: aload 5
    //   1095: invokevirtual 275	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1098: invokestatic 281	com/tencent/mm/plugin/topstory/a/g:H	(Ljava/util/List;Ljava/lang/String;)V
    //   1101: aload_0
    //   1102: aload 8
    //   1104: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1107: invokestatic 86	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/foh;)V
    //   1110: iload 6
    //   1112: aload 8
    //   1114: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1117: aload_0
    //   1118: invokestatic 89	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/foh;Lorg/json/JSONObject;)V
    //   1121: aload 8
    //   1123: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1126: aload 8
    //   1128: getfield 133	com/tencent/mm/protocal/protobuf/foh:source	Ljava/lang/String;
    //   1131: putfield 133	com/tencent/mm/protocal/protobuf/foh:source	Ljava/lang/String;
    //   1134: aload 8
    //   1136: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1139: aload 8
    //   1141: getfield 138	com/tencent/mm/protocal/protobuf/foh:ibx	Ljava/lang/String;
    //   1144: putfield 138	com/tencent/mm/protocal/protobuf/foh:ibx	Ljava/lang/String;
    //   1147: aload 8
    //   1149: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1152: aload 8
    //   1154: getfield 188	com/tencent/mm/protocal/protobuf/foh:aaXP	Ljava/lang/String;
    //   1157: putfield 188	com/tencent/mm/protocal/protobuf/foh:aaXP	Ljava/lang/String;
    //   1160: aload 8
    //   1162: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1165: aload 8
    //   1167: getfield 193	com/tencent/mm/protocal/protobuf/foh:abOF	J
    //   1170: putfield 193	com/tencent/mm/protocal/protobuf/foh:abOF	J
    //   1173: aload 8
    //   1175: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1178: aload 8
    //   1180: getfield 109	com/tencent/mm/protocal/protobuf/foh:svG	Ljava/lang/String;
    //   1183: putfield 109	com/tencent/mm/protocal/protobuf/foh:svG	Ljava/lang/String;
    //   1186: aload 8
    //   1188: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1191: aload 8
    //   1193: getfield 114	com/tencent/mm/protocal/protobuf/foh:ICb	Ljava/lang/String;
    //   1196: putfield 114	com/tencent/mm/protocal/protobuf/foh:ICb	Ljava/lang/String;
    //   1199: aload 8
    //   1201: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1204: aload 8
    //   1206: getfield 160	com/tencent/mm/protocal/protobuf/foh:abOx	Ljava/lang/String;
    //   1209: putfield 160	com/tencent/mm/protocal/protobuf/foh:abOx	Ljava/lang/String;
    //   1212: aload 8
    //   1214: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1217: aload 8
    //   1219: getfield 119	com/tencent/mm/protocal/protobuf/foh:Wpe	Ljava/lang/String;
    //   1222: putfield 119	com/tencent/mm/protocal/protobuf/foh:Wpe	Ljava/lang/String;
    //   1225: aload 8
    //   1227: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1230: aload 8
    //   1232: getfield 124	com/tencent/mm/protocal/protobuf/foh:Wpf	Ljava/lang/String;
    //   1235: putfield 124	com/tencent/mm/protocal/protobuf/foh:Wpf	Ljava/lang/String;
    //   1238: aload 8
    //   1240: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1243: aload 8
    //   1245: getfield 129	com/tencent/mm/protocal/protobuf/foh:Wpg	Ljava/lang/String;
    //   1248: putfield 129	com/tencent/mm/protocal/protobuf/foh:Wpg	Ljava/lang/String;
    //   1251: aload 8
    //   1253: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1256: aload 8
    //   1258: getfield 160	com/tencent/mm/protocal/protobuf/foh:abOx	Ljava/lang/String;
    //   1261: putfield 160	com/tencent/mm/protocal/protobuf/foh:abOx	Ljava/lang/String;
    //   1264: aload 8
    //   1266: getfield 419	com/tencent/mm/protocal/protobuf/foh:abOM	Lcom/tencent/mm/protocal/protobuf/foh;
    //   1269: aload_0
    //   1270: ldc 140
    //   1272: ldc 248
    //   1274: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1277: putfield 143	com/tencent/mm/protocal/protobuf/foh:ytZ	Ljava/lang/String;
    //   1280: aload 8
    //   1282: getfield 92	com/tencent/mm/protocal/protobuf/foh:videoUrl	Ljava/lang/String;
    //   1285: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1288: ifne +51 -> 1339
    //   1291: ldc_w 421
    //   1294: ldc_w 423
    //   1297: iconst_3
    //   1298: anewarray 4	java/lang/Object
    //   1301: dup
    //   1302: iconst_0
    //   1303: aload 8
    //   1305: getfield 82	com/tencent/mm/protocal/protobuf/foh:Ido	Ljava/lang/String;
    //   1308: aastore
    //   1309: dup
    //   1310: iconst_1
    //   1311: aload 8
    //   1313: getfield 92	com/tencent/mm/protocal/protobuf/foh:videoUrl	Ljava/lang/String;
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: aload 8
    //   1321: getfield 426	com/tencent/mm/protocal/protobuf/foh:abOC	J
    //   1324: invokestatic 432	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1327: aastore
    //   1328: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1331: ldc 53
    //   1333: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1336: aload 8
    //   1338: areturn
    //   1339: ldc 53
    //   1341: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1344: aconst_null
    //   1345: areturn
    //   1346: ldc 53
    //   1348: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1351: aconst_null
    //   1352: areturn
    //   1353: astore 5
    //   1355: goto -546 -> 809
    //   1358: astore 5
    //   1360: goto -551 -> 809
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1363	0	paramJSONObject	JSONObject
    //   0	1363	1	paramLong1	long
    //   0	1363	3	paramLong2	long
    //   0	1363	5	paramString	String
    //   0	1363	6	paramBoolean	boolean
    //   28	59	7	i	int
    //   45	1292	8	localfoh	foh
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   485	494	1353	java/lang/Exception
    //   499	809	1358	java/lang/Exception
  }
  
  private static List<foh> a(boolean paramBoolean, JSONArray paramJSONArray)
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
          foh localfoh = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localfoh != null)
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localfoh.Ido, localfoh.videoUrl, Long.valueOf(localfoh.abOC) });
            localArrayList.add(localfoh);
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
  
  private static void a(foh paramfoh, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126142);
    InputStream localInputStream1 = null;
    Object localObject4 = null;
    y localy = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject6 = new StringBuilder("");
    Object localObject1 = localObject5;
    Object localObject2 = localObject4;
    InputStream localInputStream2 = localInputStream1;
    try
    {
      j = hOA();
      localObject1 = localObject5;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      k = aPK();
      localObject1 = localObject5;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      m = hOB();
      localObject1 = localObject5;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", new Object[] { paramString1 });
      localObject1 = localObject5;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      if (!URLUtil.isHttpsUrl(paramString1)) {
        break label415;
      }
      localObject1 = localObject5;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      localObject3 = d.Ru(paramString1);
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localInputStream2 = localInputStream1;
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "getVideoUrlByVideoApi error: %s", new Object[] { paramString1 });
        if (localObject3 != null) {
          ((ab)localObject3).disconnect();
        }
        AppMethodBeat.o(126142);
        return;
      }
      localObject1 = localObject3;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      ((ab)localObject3).bRk();
      localObject1 = localObject3;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      ((ab)localObject3).xx(3000);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      ((ab)localObject3).xy(3000);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localInputStream2 = localInputStream1;
      localInputStream1 = ((ab)localObject3).ppu.getInputStream();
      paramString1 = (String)localObject3;
    }
    finally
    {
      for (;;)
      {
        try
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramfoh, "getVideoUrlByVideoApi error: %s", new Object[] { paramfoh.getMessage() });
          return;
        }
        finally
        {
          int j;
          int k;
          int m;
          int i;
          if (localObject2 == null) {
            continue;
          }
          ((y)localObject2).disconnect();
          if (localObject1 == null) {
            continue;
          }
          ((ab)localObject1).disconnect();
          if (localInputStream2 == null) {
            continue;
          }
          ah.closeQuietly(localInputStream2);
          AppMethodBeat.o(126142);
        }
        localObject1 = localObject5;
        localObject2 = localObject4;
        localInputStream2 = localInputStream1;
        localy = d.a(paramString1, null);
        if (localy == null)
        {
          localObject1 = localObject5;
          localObject2 = localy;
          localInputStream2 = localInputStream1;
          Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "getVideoUrlByVideoApi error: %s", new Object[] { paramString1 });
          if (localy != null) {
            localy.disconnect();
          }
          AppMethodBeat.o(126142);
          return;
        }
        localObject1 = localObject5;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localy.hB(true);
        localObject1 = localObject5;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localy.xx(3000);
        localObject1 = localObject5;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localy.xy(3000);
        localObject1 = localObject5;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localInputStream1 = localy.getInputStream();
        paramString1 = (String)localObject3;
        continue;
        localObject1 = paramString1;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localObject3 = new JSONObject(((StringBuilder)localObject6).toString().substring(13));
        localObject1 = paramString1;
        localObject2 = localy;
        localInputStream2 = localInputStream1;
        localObject4 = ((JSONObject)localObject3).optJSONObject("fl");
        if (localObject4 != null)
        {
          localObject1 = paramString1;
          localObject2 = localy;
          localInputStream2 = localInputStream1;
          localObject4 = ((JSONObject)localObject4).optJSONArray("fi");
          if (localObject4 != null) {
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = paramString1;
          localObject2 = localy;
          localInputStream2 = localInputStream1;
          if (i < ((JSONArray)localObject4).length())
          {
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject5 = ((JSONArray)localObject4).getJSONObject(i);
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            if (((JSONObject)localObject5).optInt("sl", 0) == 1)
            {
              localObject1 = paramString1;
              localObject2 = localy;
              localInputStream2 = localInputStream1;
              paramfoh.abOC = ((JSONObject)localObject5).optLong("fs");
            }
          }
          else
          {
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject3 = ((JSONObject)localObject3).optJSONObject("vl");
            if (localObject3 == null) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject3 = ((JSONObject)localObject3).optJSONArray("vi");
            if (localObject3 == null) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            if (((JSONArray)localObject3).length() <= 0) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject3 = ((JSONArray)localObject3).getJSONObject(0);
            if (localObject3 == null) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject5 = ((JSONObject)localObject3).optString("fn");
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject6 = ((JSONObject)localObject3).optString("fvkey");
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            localObject3 = ((JSONObject)localObject3).optJSONObject("ul");
            if (localObject3 == null) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("ui");
            if (localJSONArray == null) {
              break label1314;
            }
            localObject1 = paramString1;
            localObject2 = localy;
            localInputStream2 = localInputStream1;
            if (localJSONArray.length() <= 0) {
              break label1314;
            }
            i = 0;
            for (;;)
            {
              localObject1 = paramString1;
              localObject2 = localy;
              localInputStream2 = localInputStream1;
              if (i >= localJSONArray.length()) {
                break;
              }
              localObject1 = paramString1;
              localObject2 = localy;
              localInputStream2 = localInputStream1;
              localObject3 = localJSONArray.getJSONObject(i);
              if (localObject3 != null)
              {
                localObject1 = paramString1;
                localObject2 = localy;
                localInputStream2 = localInputStream1;
                localObject4 = ((JSONObject)localObject3).optString("url");
                localObject1 = paramString1;
                localObject2 = localy;
                localInputStream2 = localInputStream1;
                int n = ((JSONObject)localObject3).optInt("vt", 0);
                localObject1 = paramString1;
                localObject2 = localy;
                localInputStream2 = localInputStream1;
                if (!Util.isNullOrNil((String)localObject4))
                {
                  localObject1 = paramString1;
                  localObject2 = localy;
                  localInputStream2 = localInputStream1;
                  if (!Util.isNullOrNil((String)localObject6))
                  {
                    localObject1 = paramString1;
                    localObject2 = localy;
                    localInputStream2 = localInputStream1;
                    if (!Util.isNullOrNil((String)localObject5))
                    {
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      localObject4 = (String)localObject4 + (String)localObject5 + "?vkey=" + (String)localObject6;
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      localObject3 = localObject4;
                      if (!Util.isNullOrNil(paramString2))
                      {
                        localObject1 = paramString1;
                        localObject2 = localy;
                        localInputStream2 = localInputStream1;
                        localObject3 = (String)localObject4 + "&platform=" + paramString2;
                      }
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      localObject3 = c((String)localObject3, "&", j, k, m);
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      localObject4 = new foj();
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      ((foj)localObject4).url = ((String)localObject3);
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      ((foj)localObject4).abOL = n;
                      localObject1 = paramString1;
                      localObject2 = localy;
                      localInputStream2 = localInputStream1;
                      paramfoh.abOD.add(localObject4);
                    }
                  }
                }
              }
              i += 1;
            }
          }
          i += 1;
          continue;
          if (localy != null) {
            localy.disconnect();
          }
          if (paramString1 != null) {
            paramString1.disconnect();
          }
          if (localInputStream1 != null)
          {
            ah.closeQuietly(localInputStream1);
            AppMethodBeat.o(126142);
            return;
          }
        }
      }
      AppMethodBeat.o(126142);
    }
    localObject1 = paramString1;
    localObject2 = localy;
    localInputStream2 = localInputStream1;
    localObject3 = new BufferedReader(new InputStreamReader(localInputStream1));
    for (;;)
    {
      localObject1 = paramString1;
      localObject2 = localy;
      localInputStream2 = localInputStream1;
      localObject4 = ((BufferedReader)localObject3).readLine();
      if (localObject4 == null) {
        break;
      }
      localObject1 = paramString1;
      localObject2 = localy;
      localInputStream2 = localInputStream1;
      ((StringBuilder)localObject6).append((String)localObject4);
    }
    label415:
    label1314:
    return;
  }
  
  private static void a(JSONArray paramJSONArray, foh paramfoh)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      fcl localfcl = new fcl();
      localfcl.id = paramJSONArray.getJSONObject(i).optString("id");
      localfcl.wording = paramJSONArray.getJSONObject(i).optString("wording");
      localfcl.abCa = paramJSONArray.getJSONObject(i).optLong("category");
      localfcl.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localfcl.url = paramJSONArray.getJSONObject(i).optString("url");
      localfcl.title = paramJSONArray.getJSONObject(i).optString("title");
      localfcl.uCW = paramJSONArray.getJSONObject(i).optString("subTitle");
      localfcl.icon = paramJSONArray.getJSONObject(i).optString("icon");
      paramfoh.Idn.add(localfcl);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, foh paramfoh)
  {
    AppMethodBeat.i(126137);
    paramfoh.abOK = new fof();
    paramfoh.abOK.abOt = paramJSONObject.optString("detailWording");
    paramfoh.abOK.abOu = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        ass localass = new ass();
        localass.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localass.wording = paramJSONObject.optJSONObject(i).optString("wording", "");
        localass.ZCV = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        paramfoh.abOK.abOv.add(localass);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, foh paramfoh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    paramfoh.oeS = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      paramfoh.thumbWidth = 360;
    }
    for (paramfoh.thumbHeight = 640;; paramfoh.thumbHeight = 280)
    {
      if (Util.isNullOrNil(paramfoh.oeS)) {
        paramfoh.oeS = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramfoh.Ido + String.format("_%s_%s/0", new Object[] { Integer.valueOf(paramfoh.thumbWidth), Integer.valueOf(paramfoh.thumbHeight) }));
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { paramfoh.Ido, paramfoh.oeS });
      AppMethodBeat.o(126140);
      return;
      paramfoh.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, foh paramfoh, JSONObject paramJSONObject)
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
            paramfoh.abOC = localJSONObject.optInt("filesize", 0);
            foj localfoj = new foj();
            localfoj.url = localJSONObject.optString("url");
            localfoj.abOL = 0;
            paramfoh.abOD.add(localfoj);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramfoh.oeS = paramJSONObject.optString("coverUrl");
          if (paramfoh.abOC > 0L)
          {
            boolean bool = Util.isNullOrNil(paramfoh.abOD);
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
      catch (Exception paramfoh)
      {
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramfoh.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  /* Error */
  public static boolean a(final foh paramfoh, final Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 828
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +288 -> 295
    //   10: ldc_w 421
    //   13: ldc_w 830
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 230	com/tencent/mm/protocal/protobuf/foh:abOP	I
    //   26: invokestatic 797	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 230	com/tencent/mm/protocal/protobuf/foh:abOP	I
    //   37: iconst_1
    //   38: if_icmpne +52 -> 90
    //   41: aload_0
    //   42: getfield 138	com/tencent/mm/protocal/protobuf/foh:ibx	Ljava/lang/String;
    //   45: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   48: ifne +247 -> 295
    //   51: new 832	android/content/Intent
    //   54: dup
    //   55: invokespecial 833	android/content/Intent:<init>	()V
    //   58: astore_2
    //   59: aload_2
    //   60: ldc_w 835
    //   63: aload_0
    //   64: getfield 138	com/tencent/mm/protocal/protobuf/foh:ibx	Ljava/lang/String;
    //   67: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   70: pop
    //   71: aload_1
    //   72: ldc_w 841
    //   75: ldc_w 843
    //   78: aload_2
    //   79: invokestatic 848	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   82: ldc_w 828
    //   85: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_1
    //   89: ireturn
    //   90: aload_0
    //   91: getfield 230	com/tencent/mm/protocal/protobuf/foh:abOP	I
    //   94: iconst_2
    //   95: if_icmpne +200 -> 295
    //   98: aload_0
    //   99: getfield 225	com/tencent/mm/protocal/protobuf/foh:hAw	Ljava/lang/String;
    //   102: invokestatic 854	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +190 -> 295
    //   108: ldc_w 856
    //   111: invokestatic 862	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   114: checkcast 856	com/tencent/mm/plugin/messenger/foundation/a/n
    //   117: invokeinterface 866 1 0
    //   122: aload_0
    //   123: getfield 225	com/tencent/mm/protocal/protobuf/foh:hAw	Ljava/lang/String;
    //   126: invokeinterface 872 2 0
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +68 -> 201
    //   136: aload_2
    //   137: getfield 877	com/tencent/mm/contact/d:maN	J
    //   140: l2i
    //   141: ifle +60 -> 201
    //   144: ldc_w 421
    //   147: ldc_w 879
    //   150: invokestatic 881	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: new 832	android/content/Intent
    //   156: dup
    //   157: invokespecial 833	android/content/Intent:<init>	()V
    //   160: astore_2
    //   161: aload_2
    //   162: ldc_w 883
    //   165: aload_0
    //   166: getfield 225	com/tencent/mm/protocal/protobuf/foh:hAw	Ljava/lang/String;
    //   169: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   172: pop
    //   173: aload_2
    //   174: ldc_w 885
    //   177: iconst_1
    //   178: invokevirtual 888	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   181: pop
    //   182: aload_1
    //   183: ldc_w 890
    //   186: ldc_w 892
    //   189: aload_2
    //   190: invokestatic 848	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   193: ldc_w 828
    //   196: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_1
    //   200: ireturn
    //   201: ldc_w 421
    //   204: ldc_w 894
    //   207: invokestatic 881	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: iconst_1
    //   211: newarray boolean
    //   213: astore_3
    //   214: aload_3
    //   215: iconst_0
    //   216: iconst_0
    //   217: bastore
    //   218: aload_1
    //   219: aload_1
    //   220: getstatic 897	com/tencent/mm/plugin/topstory/ui/c$g:loading	I
    //   223: invokevirtual 539	android/content/Context:getString	(I)Ljava/lang/String;
    //   226: iconst_1
    //   227: new 10	com/tencent/mm/plugin/topstory/ui/video/n$3
    //   230: dup
    //   231: aload_3
    //   232: invokespecial 900	com/tencent/mm/plugin/topstory/ui/video/n$3:<init>	([Z)V
    //   235: invokestatic 905	com/tencent/mm/ui/base/k:a	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/w;
    //   238: astore_2
    //   239: getstatic 911	com/tencent/mm/model/az$a:okP	Lcom/tencent/mm/model/az$b;
    //   242: aload_0
    //   243: getfield 225	com/tencent/mm/protocal/protobuf/foh:hAw	Ljava/lang/String;
    //   246: ldc 248
    //   248: new 12	com/tencent/mm/plugin/topstory/ui/video/n$4
    //   251: dup
    //   252: aload_2
    //   253: aload_3
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 914	com/tencent/mm/plugin/topstory/ui/video/n$4:<init>	(Lcom/tencent/mm/ui/base/w;[ZLcom/tencent/mm/protocal/protobuf/foh;Landroid/content/Context;)V
    //   259: invokeinterface 919 4 0
    //   264: goto -71 -> 193
    //   267: astore_0
    //   268: aload_2
    //   269: invokevirtual 924	com/tencent/mm/ui/base/w:dismiss	()V
    //   272: ldc_w 421
    //   275: ldc_w 926
    //   278: iconst_1
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload_0
    //   285: invokevirtual 634	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 590	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: goto -99 -> 193
    //   295: ldc_w 828
    //   298: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: iconst_0
    //   302: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramfoh	foh
    //   0	303	1	paramContext	Context
    //   58	211	2	localObject	Object
    //   213	41	3	arrayOfBoolean	boolean[]
    // Exception table:
    //   from	to	target	type
    //   239	264	267	finally
  }
  
  public static int aPK()
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
  
  private static void b(JSONObject paramJSONObject, foh paramfoh)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, paramfoh)))
    {
      paramJSONObject = g.lD(paramfoh.abOD);
      if (paramJSONObject != null)
      {
        paramfoh.videoUrl = paramJSONObject.url;
        paramfoh.abOL = paramJSONObject.abOL;
      }
    }
    if ((Util.isNullOrNil(paramfoh.videoUrl)) && (!Util.isNullOrNil(str2)))
    {
      a(paramfoh, str2, str1);
      if (Util.isNullOrNil(paramfoh.abOD))
      {
        a.rG(29);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(paramfoh, str2, str1);
      }
      paramJSONObject = g.lD(paramfoh.abOD);
      if (paramJSONObject != null)
      {
        paramfoh.videoUrl = paramJSONObject.url;
        paramfoh.abOL = paramJSONObject.abOL;
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
  
  private static boolean c(JSONObject paramJSONObject, foh paramfoh)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      paramfoh.abOH = localJSONObject.optInt("cdnScene", 0);
      paramfoh.abOI = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((paramfoh.abOH == 1) || (paramfoh.abOI == 2))
    {
      if (!a(paramfoh.abOH, paramfoh, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(paramfoh.abOH), paramfoh.Ido, paramfoh.title, Long.valueOf(paramfoh.abOC) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static int hOA()
  {
    AppMethodBeat.i(126143);
    if (aj.isFreeSimCard())
    {
      AppMethodBeat.o(126143);
      return 2;
    }
    AppMethodBeat.o(126143);
    return -1;
  }
  
  private static int hOB()
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
  
  public static boolean i(foh paramfoh)
  {
    AppMethodBeat.i(271828);
    if (paramfoh != null)
    {
      if ((paramfoh.abOP == 1) && (!TextUtils.isEmpty(paramfoh.ibx)))
      {
        AppMethodBeat.o(271828);
        return true;
      }
      if ((paramfoh.abOP == 2) && (!TextUtils.isEmpty(paramfoh.hAw)))
      {
        AppMethodBeat.o(271828);
        return true;
      }
    }
    AppMethodBeat.o(271828);
    return false;
  }
  
  public final void a(foe paramfoe, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = aiJ();
        if ((Util.isNullOrNil(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((foh)localList.get(i)).Ido);
            i += 1;
            continue;
          }
          paramfoe = new e(paramfoe, localArrayList);
          com.tencent.mm.kernel.h.aZW().a(paramfoe, 0);
          com.tencent.mm.kernel.h.aZW().a(paramfoe.getType(), new n.1(this, paramfoe));
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
  
  public final List<foh> aiJ()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.TLn.hNz().abOn;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final void apb(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < aiJ().size()) {
        aiJ().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final foh apc(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < aiJ().size())
      {
        foh localfoh = (foh)aiJ().get(paramInt);
        return localfoh;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean apd(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.TFx)
    {
      Log.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.TFx = true;
    foe localfoe = g.a(this.TLn.hNz());
    localfoe.offset = paramInt;
    Object localObject1;
    if (!Util.isNullOrNil(this.TLn.hNz().abOf))
    {
      localObject1 = new aem();
      ((aem)localObject1).key = "relevant_vid";
      ((aem)localObject1).Zmy = this.TLn.hNz().abOf;
      localfoe.Wol.add(localObject1);
    }
    if (!Util.isNullOrNil(this.TLn.hNz().abOg))
    {
      localObject1 = new aem();
      ((aem)localObject1).key = "relevant_expand";
      ((aem)localObject1).Zmy = this.TLn.hNz().abOg;
      localfoe.Wol.add(localObject1);
    }
    if (!Util.isNullOrNil(this.TLn.hNz().abOh))
    {
      localObject1 = new aem();
      ((aem)localObject1).key = "relevant_pre_searchid";
      ((aem)localObject1).Zmy = this.TLn.hNz().abOh;
      localfoe.Wol.add(localObject1);
    }
    if (!Util.isNullOrNil(this.TLn.hNz().abOi))
    {
      localObject1 = new aem();
      ((aem)localObject1).key = "relevant_shared_openid";
      ((aem)localObject1).Zmy = this.TLn.hNz().abOi;
      localfoe.Wol.add(localObject1);
    }
    if (this.TLn.hNz().abOl != null)
    {
      localObject1 = new aem();
      ((aem)localObject1).key = "rec_category";
      ((aem)localObject1).Zmx = this.TLn.hNz().abOl.abCa;
      localfoe.Wol.add(localObject1);
      localObject1 = localfoe.Wol.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((aem)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.TLn.hNz().abOl != null) && (paramInt != 0))
      {
        localObject1 = new aem();
        ((aem)localObject1).key = "show_tag_list";
        ((aem)localObject1).Zmy = this.TLn.hNz().abOl.id;
        localfoe.Wol.add(localObject1);
      }
      localObject1 = new aem();
      ((aem)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label653:
      com.tencent.mm.plugin.topstory.a.b.c localc;
      if ((this.TLn.hNz().abOl != null) && (!Util.isNullOrNil(this.TLn.hNz().abOl.id)))
      {
        ((aem)localObject1).Zmx = 0L;
        localfoe.Wol.add(localObject1);
        if (hOz() == 1)
        {
          localObject1 = apc(0);
          localObject2 = new aem();
          ((aem)localObject2).key = "first_video_tag_list";
          ((aem)localObject2).Zmy = g.lE(((foh)localObject1).Idn).toString();
          localfoe.Wol.add(localObject2);
        }
        localObject1 = this.TLn.hNx();
        if (((o)localObject1).TNn.size() <= 0) {
          break label928;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).TNn.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label779;
        }
        localc = (com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next();
        if (!localc.TIX) {
          break label774;
        }
      }
      label774:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.TIW.Ido);
        ((StringBuffer)localObject1).append(";");
        break label653;
        localObject1 = new aem();
        ((aem)localObject1).key = "rec_category";
        ((aem)localObject1).Zmx = this.TLn.hNz().abOj;
        localfoe.Wol.add(localObject1);
        break;
        ((aem)localObject1).Zmx = 1L;
        break label521;
      }
      label779:
      label928:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = new aem();
          ((aem)localObject2).key = "client_exposed_info";
          ((aem)localObject2).Zmy = ((String)localObject1);
          localfoe.Wol.add(localObject2);
        }
        localObject1 = new aem();
        ((aem)localObject1).key = "is_prefetch";
        ((aem)localObject1).Zmx = this.TNa;
        localfoe.Wol.add(localObject1);
        if (this.TNb != null)
        {
          com.tencent.mm.kernel.h.aZW().a(this.TNb);
          this.TNb = null;
        }
        this.TNb = new k(localfoe);
        com.tencent.mm.kernel.h.aZW().a(this.TNb, 0);
        com.tencent.mm.kernel.h.aZW().a(1943, this.maV);
        a.rG(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final void h(foh paramfoh)
  {
    AppMethodBeat.i(126128);
    try
    {
      aiJ().add(paramfoh);
      return;
    }
    finally
    {
      AppMethodBeat.o(126128);
    }
  }
  
  public final int hOz()
  {
    AppMethodBeat.i(126127);
    int i = aiJ().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126133);
    if (this.TNb != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.TNb);
      this.TNb = null;
    }
    if (this.TNe != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.TNe);
      this.TNe = null;
    }
    com.tencent.mm.kernel.h.aZW().b(1943, this.maV);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private boolean AXE;
    private String zVk;
    
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
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:zVk	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:TNg	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:AXE	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:TNg	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:TFx	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:TNg	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:TFx	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:TNg	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:TFx	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */