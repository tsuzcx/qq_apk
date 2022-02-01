package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.eqn;
import com.tencent.mm.protocal.protobuf.eqz;
import com.tencent.mm.protocal.protobuf.era;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
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
  public boolean GhN;
  public b GlS;
  public int GnE;
  k GnF;
  private int GnG;
  private int GnH;
  public com.tencent.mm.plugin.topstory.a.c.h GnI;
  public com.tencent.mm.ak.i gNh;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.gNh = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousq });
        if (paramAnonymousq.equals(n.this.GnF))
        {
          g.azz().b(1943, n.this.gNh);
          n.this.GnF = null;
          paramAnonymousq = (k)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousq.fxZ().MaZ });
            a.pl(2);
            n.this.GlS.aTE(paramAnonymousString);
            n.this.GhN = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousq.fxZ().MaZ);
          if (paramAnonymousq.GjJ.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.f.h.RTc.b(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousq.equals(n.this.GnI))
        {
          g.azz().b(1943, n.this.gNh);
          n.this.GnI = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.pl(2);
            AppMethodBeat.o(126123);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.fxZ().MaZ });
          com.tencent.f.h.RTc.b(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.fxZ().MaZ).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.GlS.fyL(), (JSONArray)localObject);
                  paramAnonymousString.GjK.Niz.NhV.addAll((Collection)localObject);
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
  private static eiw a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 57
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 59
    //   8: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 67
    //   16: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 69
    //   24: iconst_0
    //   25: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 7
    //   30: aload 9
    //   32: invokestatic 79	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1311 -> 1346
    //   38: new 81	com/tencent/mm/protocal/protobuf/eiw
    //   41: dup
    //   42: invokespecial 82	com/tencent/mm/protocal/protobuf/eiw:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 86	com/tencent/mm/protocal/protobuf/eiw:psI	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 90	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 93	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/eiw;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 96	com/tencent/mm/protocal/protobuf/eiw:videoUrl	Ljava/lang/String;
    //   73: invokestatic 79	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 101	com/tencent/mm/plugin/websearch/api/a/a:pl	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 104	com/tencent/mm/protocal/protobuf/eiw:Eso	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 106
    //   96: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 108	com/tencent/mm/protocal/protobuf/eiw:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 110
    //   107: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 113	com/tencent/mm/protocal/protobuf/eiw:msN	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 115
    //   118: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 118	com/tencent/mm/protocal/protobuf/eiw:xDQ	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 120
    //   129: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 123	com/tencent/mm/protocal/protobuf/eiw:IED	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 125
    //   140: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 128	com/tencent/mm/protocal/protobuf/eiw:IEE	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 130
    //   151: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 133	com/tencent/mm/protocal/protobuf/eiw:IEF	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 135
    //   162: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 137	com/tencent/mm/protocal/protobuf/eiw:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 139
    //   173: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 142	com/tencent/mm/protocal/protobuf/eiw:eby	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 144
    //   184: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 147	com/tencent/mm/protocal/protobuf/eiw:rCq	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 149
    //   195: ldc2_w 150
    //   198: invokevirtual 155	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 159	com/tencent/mm/protocal/protobuf/eiw:Nip	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 161
    //   209: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 164	com/tencent/mm/protocal/protobuf/eiw:Niq	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 166
    //   220: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 169	com/tencent/mm/protocal/protobuf/eiw:Nir	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 171
    //   231: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 174	com/tencent/mm/protocal/protobuf/eiw:IEG	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 176
    //   242: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 179	com/tencent/mm/protocal/protobuf/eiw:IEH	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 181
    //   253: invokevirtual 184	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 187	com/tencent/mm/protocal/protobuf/eiw:Nis	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 189
    //   264: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 192	com/tencent/mm/protocal/protobuf/eiw:MwR	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 194
    //   275: aload 8
    //   277: getfield 159	com/tencent/mm/protocal/protobuf/eiw:Nip	J
    //   280: invokevirtual 155	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 197	com/tencent/mm/protocal/protobuf/eiw:Niy	J
    //   286: aload 8
    //   288: invokestatic 201	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   291: putfield 204	com/tencent/mm/protocal/protobuf/eiw:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 207	com/tencent/mm/protocal/protobuf/eiw:dEF	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 210	com/tencent/mm/protocal/protobuf/eiw:wWb	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 213	com/tencent/mm/protocal/protobuf/eiw:Niu	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 216	com/tencent/mm/protocal/protobuf/eiw:dDw	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 219	com/tencent/mm/protocal/protobuf/eiw:Nit	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 221
    //   331: iconst_0
    //   332: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 224	com/tencent/mm/protocal/protobuf/eiw:Nix	I
    //   338: aload 8
    //   340: aload_0
    //   341: ldc 226
    //   343: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 229	com/tencent/mm/protocal/protobuf/eiw:BmI	Ljava/lang/String;
    //   349: aload 8
    //   351: aload_0
    //   352: ldc 231
    //   354: iconst_1
    //   355: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   358: putfield 234	com/tencent/mm/protocal/protobuf/eiw:NiJ	I
    //   361: aload_0
    //   362: ldc 236
    //   364: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   367: astore 5
    //   369: aload 5
    //   371: ifnull +43 -> 414
    //   374: aload 8
    //   376: aload 5
    //   378: ldc 242
    //   380: invokevirtual 245	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   383: putfield 248	com/tencent/mm/protocal/protobuf/eiw:NiC	Z
    //   386: aload 8
    //   388: aload 5
    //   390: ldc 250
    //   392: ldc 252
    //   394: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   397: putfield 258	com/tencent/mm/protocal/protobuf/eiw:NiD	Ljava/lang/String;
    //   400: aload 8
    //   402: aload 5
    //   404: ldc_w 260
    //   407: iconst_0
    //   408: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   411: putfield 263	com/tencent/mm/protocal/protobuf/eiw:NiH	I
    //   414: aload_0
    //   415: ldc_w 265
    //   418: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   421: astore 5
    //   423: aload 5
    //   425: ifnull +16 -> 441
    //   428: aload 8
    //   430: getfield 273	com/tencent/mm/protocal/protobuf/eiw:IDO	Ljava/util/LinkedList;
    //   433: aload 5
    //   435: invokevirtual 279	org/json/JSONArray:toString	()Ljava/lang/String;
    //   438: invokestatic 285	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   441: aload_0
    //   442: ldc_w 287
    //   445: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   448: astore 5
    //   450: aload 5
    //   452: ifnull +10 -> 462
    //   455: aload 5
    //   457: aload 8
    //   459: invokestatic 290	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   462: aload_0
    //   463: ldc_w 292
    //   466: iconst_0
    //   467: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   470: ifne +15 -> 485
    //   473: aload_0
    //   474: ldc_w 297
    //   477: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   480: aload 8
    //   482: invokestatic 299	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   485: aload_0
    //   486: ldc_w 301
    //   489: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   492: astore 5
    //   494: aload 5
    //   496: ifnull +313 -> 809
    //   499: aload 5
    //   501: iconst_0
    //   502: invokevirtual 304	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   505: astore 5
    //   507: aload 8
    //   509: new 306	com/tencent/mm/protocal/protobuf/eip
    //   512: dup
    //   513: invokespecial 307	com/tencent/mm/protocal/protobuf/eip:<init>	()V
    //   516: putfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   519: aload 8
    //   521: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   524: aload 5
    //   526: ldc_w 313
    //   529: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 316	com/tencent/mm/protocal/protobuf/eip:NhM	Ljava/lang/String;
    //   535: aload 8
    //   537: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   540: aload 5
    //   542: ldc_w 318
    //   545: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   548: putfield 320	com/tencent/mm/protocal/protobuf/eip:id	Ljava/lang/String;
    //   551: aload 5
    //   553: ldc_w 322
    //   556: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   559: iconst_0
    //   560: invokevirtual 304	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   563: astore 5
    //   565: aload 8
    //   567: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   570: aload 5
    //   572: ldc_w 324
    //   575: invokevirtual 184	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   578: putfield 327	com/tencent/mm/protocal/protobuf/eip:LHa	I
    //   581: aload 8
    //   583: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   586: aload 5
    //   588: ldc_w 329
    //   591: invokevirtual 184	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   594: putfield 332	com/tencent/mm/protocal/protobuf/eip:iqg	I
    //   597: aload 8
    //   599: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   602: aload 5
    //   604: ldc_w 334
    //   607: invokevirtual 184	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   610: putfield 337	com/tencent/mm/protocal/protobuf/eip:NhL	I
    //   613: aload 8
    //   615: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   618: aload 5
    //   620: ldc_w 339
    //   623: invokevirtual 184	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   626: putfield 341	com/tencent/mm/protocal/protobuf/eip:type	I
    //   629: aload 8
    //   631: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   634: aload 5
    //   636: ldc_w 318
    //   639: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   642: putfield 344	com/tencent/mm/protocal/protobuf/eip:lYE	Ljava/lang/String;
    //   645: new 61	org/json/JSONObject
    //   648: dup
    //   649: aload 5
    //   651: ldc_w 346
    //   654: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokespecial 349	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   660: astore 5
    //   662: aload 8
    //   664: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   667: new 351	com/tencent/mm/protocal/protobuf/eio
    //   670: dup
    //   671: invokespecial 352	com/tencent/mm/protocal/protobuf/eio:<init>	()V
    //   674: putfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   677: aload 8
    //   679: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   682: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   685: aload 5
    //   687: ldc 106
    //   689: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   692: putfield 357	com/tencent/mm/protocal/protobuf/eio:title	Ljava/lang/String;
    //   695: aload 8
    //   697: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   700: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   703: aload 5
    //   705: ldc_w 359
    //   708: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   711: putfield 361	com/tencent/mm/protocal/protobuf/eio:desc	Ljava/lang/String;
    //   714: aload 8
    //   716: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   719: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   722: aload 5
    //   724: ldc_w 363
    //   727: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: putfield 366	com/tencent/mm/protocal/protobuf/eio:ecK	Ljava/lang/String;
    //   733: aload 8
    //   735: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   738: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   741: aload 5
    //   743: ldc_w 368
    //   746: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: putfield 371	com/tencent/mm/protocal/protobuf/eio:NhJ	Ljava/lang/String;
    //   752: aload 8
    //   754: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   757: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   760: aload 5
    //   762: ldc_w 373
    //   765: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   768: putfield 376	com/tencent/mm/protocal/protobuf/eio:NhK	Ljava/lang/String;
    //   771: aload 8
    //   773: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   776: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   779: aload 5
    //   781: ldc_w 378
    //   784: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: putfield 380	com/tencent/mm/protocal/protobuf/eio:appId	Ljava/lang/String;
    //   790: aload 8
    //   792: getfield 311	com/tencent/mm/protocal/protobuf/eiw:NiI	Lcom/tencent/mm/protocal/protobuf/eip;
    //   795: getfield 356	com/tencent/mm/protocal/protobuf/eip:NhN	Lcom/tencent/mm/protocal/protobuf/eio;
    //   798: aload 5
    //   800: ldc_w 382
    //   803: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   806: putfield 385	com/tencent/mm/protocal/protobuf/eio:uNR	Ljava/lang/String;
    //   809: aload_0
    //   810: ldc_w 387
    //   813: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   816: astore 5
    //   818: aload 5
    //   820: ifnull +101 -> 921
    //   823: aload 8
    //   825: new 389	com/tencent/mm/protocal/protobuf/eir
    //   828: dup
    //   829: invokespecial 390	com/tencent/mm/protocal/protobuf/eir:<init>	()V
    //   832: putfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   835: aload 8
    //   837: getfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   840: aload 5
    //   842: ldc_w 396
    //   845: iconst_2
    //   846: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   849: putfield 399	com/tencent/mm/protocal/protobuf/eir:Kmn	I
    //   852: aload 8
    //   854: getfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   857: aload 5
    //   859: ldc_w 401
    //   862: ldc 252
    //   864: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   867: putfield 404	com/tencent/mm/protocal/protobuf/eir:NhS	Ljava/lang/String;
    //   870: aload 8
    //   872: getfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   875: aload 5
    //   877: ldc_w 406
    //   880: iconst_1
    //   881: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   884: putfield 409	com/tencent/mm/protocal/protobuf/eir:NhR	I
    //   887: aload 8
    //   889: getfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   892: aload 5
    //   894: ldc_w 411
    //   897: iconst_0
    //   898: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   901: putfield 414	com/tencent/mm/protocal/protobuf/eir:NhT	I
    //   904: aload 8
    //   906: getfield 394	com/tencent/mm/protocal/protobuf/eiw:Niz	Lcom/tencent/mm/protocal/protobuf/eir;
    //   909: aload 5
    //   911: ldc_w 416
    //   914: iconst_0
    //   915: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   918: putfield 419	com/tencent/mm/protocal/protobuf/eir:NhU	I
    //   921: aload_0
    //   922: ldc_w 421
    //   925: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   928: astore_0
    //   929: aload_0
    //   930: ifnull +350 -> 1280
    //   933: aload 8
    //   935: new 81	com/tencent/mm/protocal/protobuf/eiw
    //   938: dup
    //   939: invokespecial 82	com/tencent/mm/protocal/protobuf/eiw:<init>	()V
    //   942: putfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   945: aload 8
    //   947: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   950: aload_0
    //   951: ldc 67
    //   953: ldc 252
    //   955: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   958: putfield 210	com/tencent/mm/protocal/protobuf/eiw:wWb	Ljava/lang/String;
    //   961: aload 8
    //   963: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   966: aload_0
    //   967: ldc 106
    //   969: ldc 252
    //   971: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   974: putfield 108	com/tencent/mm/protocal/protobuf/eiw:title	Ljava/lang/String;
    //   977: aload 8
    //   979: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   982: aload_0
    //   983: ldc 69
    //   985: iconst_0
    //   986: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   989: putfield 104	com/tencent/mm/protocal/protobuf/eiw:Eso	I
    //   992: aload 8
    //   994: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   997: aload_0
    //   998: ldc 181
    //   1000: iconst_0
    //   1001: invokevirtual 73	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1004: putfield 187	com/tencent/mm/protocal/protobuf/eiw:Nis	I
    //   1007: aload 8
    //   1009: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1012: aload_0
    //   1013: ldc 59
    //   1015: ldc 252
    //   1017: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1020: putfield 86	com/tencent/mm/protocal/protobuf/eiw:psI	Ljava/lang/String;
    //   1023: aload_0
    //   1024: ldc_w 287
    //   1027: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1030: astore 5
    //   1032: aload 5
    //   1034: ifnull +13 -> 1047
    //   1037: aload 5
    //   1039: aload 8
    //   1041: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1044: invokestatic 290	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   1047: aload_0
    //   1048: ldc_w 297
    //   1051: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1054: astore 5
    //   1056: aload 5
    //   1058: ifnull +13 -> 1071
    //   1061: aload 5
    //   1063: aload 8
    //   1065: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1068: invokestatic 299	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   1071: aload_0
    //   1072: ldc_w 265
    //   1075: invokevirtual 269	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1078: astore 5
    //   1080: aload 5
    //   1082: ifnull +19 -> 1101
    //   1085: aload 8
    //   1087: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1090: getfield 273	com/tencent/mm/protocal/protobuf/eiw:IDO	Ljava/util/LinkedList;
    //   1093: aload 5
    //   1095: invokevirtual 279	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1098: invokestatic 285	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/List;Ljava/lang/String;)V
    //   1101: aload_0
    //   1102: aload 8
    //   1104: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1107: invokestatic 90	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/eiw;)V
    //   1110: iload 6
    //   1112: aload 8
    //   1114: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1117: aload_0
    //   1118: invokestatic 93	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/eiw;Lorg/json/JSONObject;)V
    //   1121: aload 8
    //   1123: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1126: aload 8
    //   1128: getfield 137	com/tencent/mm/protocal/protobuf/eiw:source	Ljava/lang/String;
    //   1131: putfield 137	com/tencent/mm/protocal/protobuf/eiw:source	Ljava/lang/String;
    //   1134: aload 8
    //   1136: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1139: aload 8
    //   1141: getfield 142	com/tencent/mm/protocal/protobuf/eiw:eby	Ljava/lang/String;
    //   1144: putfield 142	com/tencent/mm/protocal/protobuf/eiw:eby	Ljava/lang/String;
    //   1147: aload 8
    //   1149: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1152: aload 8
    //   1154: getfield 192	com/tencent/mm/protocal/protobuf/eiw:MwR	Ljava/lang/String;
    //   1157: putfield 192	com/tencent/mm/protocal/protobuf/eiw:MwR	Ljava/lang/String;
    //   1160: aload 8
    //   1162: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1165: aload 8
    //   1167: getfield 197	com/tencent/mm/protocal/protobuf/eiw:Niy	J
    //   1170: putfield 197	com/tencent/mm/protocal/protobuf/eiw:Niy	J
    //   1173: aload 8
    //   1175: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1178: aload 8
    //   1180: getfield 113	com/tencent/mm/protocal/protobuf/eiw:msN	Ljava/lang/String;
    //   1183: putfield 113	com/tencent/mm/protocal/protobuf/eiw:msN	Ljava/lang/String;
    //   1186: aload 8
    //   1188: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1191: aload 8
    //   1193: getfield 118	com/tencent/mm/protocal/protobuf/eiw:xDQ	Ljava/lang/String;
    //   1196: putfield 118	com/tencent/mm/protocal/protobuf/eiw:xDQ	Ljava/lang/String;
    //   1199: aload 8
    //   1201: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1204: aload 8
    //   1206: getfield 164	com/tencent/mm/protocal/protobuf/eiw:Niq	Ljava/lang/String;
    //   1209: putfield 164	com/tencent/mm/protocal/protobuf/eiw:Niq	Ljava/lang/String;
    //   1212: aload 8
    //   1214: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1217: aload 8
    //   1219: getfield 123	com/tencent/mm/protocal/protobuf/eiw:IED	Ljava/lang/String;
    //   1222: putfield 123	com/tencent/mm/protocal/protobuf/eiw:IED	Ljava/lang/String;
    //   1225: aload 8
    //   1227: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1230: aload 8
    //   1232: getfield 128	com/tencent/mm/protocal/protobuf/eiw:IEE	Ljava/lang/String;
    //   1235: putfield 128	com/tencent/mm/protocal/protobuf/eiw:IEE	Ljava/lang/String;
    //   1238: aload 8
    //   1240: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1243: aload 8
    //   1245: getfield 133	com/tencent/mm/protocal/protobuf/eiw:IEF	Ljava/lang/String;
    //   1248: putfield 133	com/tencent/mm/protocal/protobuf/eiw:IEF	Ljava/lang/String;
    //   1251: aload 8
    //   1253: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1256: aload 8
    //   1258: getfield 164	com/tencent/mm/protocal/protobuf/eiw:Niq	Ljava/lang/String;
    //   1261: putfield 164	com/tencent/mm/protocal/protobuf/eiw:Niq	Ljava/lang/String;
    //   1264: aload 8
    //   1266: getfield 425	com/tencent/mm/protocal/protobuf/eiw:NiG	Lcom/tencent/mm/protocal/protobuf/eiw;
    //   1269: aload_0
    //   1270: ldc 144
    //   1272: ldc 252
    //   1274: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1277: putfield 147	com/tencent/mm/protocal/protobuf/eiw:rCq	Ljava/lang/String;
    //   1280: aload 8
    //   1282: getfield 96	com/tencent/mm/protocal/protobuf/eiw:videoUrl	Ljava/lang/String;
    //   1285: invokestatic 79	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1288: ifne +51 -> 1339
    //   1291: ldc_w 427
    //   1294: ldc_w 429
    //   1297: iconst_3
    //   1298: anewarray 4	java/lang/Object
    //   1301: dup
    //   1302: iconst_0
    //   1303: aload 8
    //   1305: getfield 86	com/tencent/mm/protocal/protobuf/eiw:psI	Ljava/lang/String;
    //   1308: aastore
    //   1309: dup
    //   1310: iconst_1
    //   1311: aload 8
    //   1313: getfield 96	com/tencent/mm/protocal/protobuf/eiw:videoUrl	Ljava/lang/String;
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: aload 8
    //   1321: getfield 432	com/tencent/mm/protocal/protobuf/eiw:Niv	J
    //   1324: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1327: aastore
    //   1328: invokestatic 443	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1331: ldc 57
    //   1333: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1336: aload 8
    //   1338: areturn
    //   1339: ldc 57
    //   1341: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1344: aconst_null
    //   1345: areturn
    //   1346: ldc 57
    //   1348: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   45	1292	8	localeiw	eiw
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   485	494	1353	java/lang/Exception
    //   499	809	1358	java/lang/Exception
  }
  
  private static List<eiw> a(boolean paramBoolean, JSONArray paramJSONArray)
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
          eiw localeiw = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localeiw != null)
          {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localeiw.psI, localeiw.videoUrl, Long.valueOf(localeiw.Niv) });
            localArrayList.add(localeiw);
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
  
  private static void a(eiw parameiw, String paramString1, String paramString2)
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
      j = fzz();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      k = ape();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      m = fzA();
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
      paramString1 = com.tencent.mm.network.d.RR(paramString1);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.bjX();
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
      localInputStream1 = paramString1.jFs.getInputStream();
    }
    catch (Throwable parameiw)
    {
      int j;
      int k;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", parameiw, "getVideoUrlByVideoApi error: %s", new Object[] { parameiw.getMessage() });
        if (localObject4 != null) {
          ((x)localObject4).disconnect();
        }
        if (localObject3 != null) {
          ((com.tencent.mm.network.aa)localObject3).disconnect();
        }
        if (localInputStream2 == null) {
          break;
        }
        com.tencent.mm.vfs.aa.closeQuietly(localInputStream2);
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
        localx.setUseCaches(true);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localx.setConnectTimeout(3000);
        localObject3 = localJSONArray;
        localObject4 = localx;
        localInputStream2 = localInputStream1;
        localObject1 = localObject9;
        localObject2 = localx;
        localObject5 = localObject7;
        localx.setReadTimeout(3000);
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
            parameiw.Niv = ((JSONObject)localObject8).optLong("fs");
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
                    localObject7 = new eiy();
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    ((eiy)localObject7).url = ((String)localObject6);
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    ((eiy)localObject7).NiF = n;
                    localObject3 = paramString1;
                    localObject4 = localx;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localx;
                    localObject5 = localInputStream1;
                    parameiw.Niw.add(localObject7);
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
      com.tencent.mm.vfs.aa.closeQuietly(localInputStream1);
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
      ((com.tencent.mm.network.aa)localObject1).disconnect();
      if (localObject5 == null) {
        break label1837;
      }
      com.tencent.mm.vfs.aa.closeQuietly((Closeable)localObject5);
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
  
  private static void a(JSONArray paramJSONArray, eiw parameiw)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      dyi localdyi = new dyi();
      localdyi.id = paramJSONArray.getJSONObject(i).optString("id");
      localdyi.dQx = paramJSONArray.getJSONObject(i).optString("wording");
      localdyi.MXW = paramJSONArray.getJSONObject(i).optLong("category");
      localdyi.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localdyi.url = paramJSONArray.getJSONObject(i).optString("url");
      localdyi.title = paramJSONArray.getJSONObject(i).optString("title");
      localdyi.oqZ = paramJSONArray.getJSONObject(i).optString("subTitle");
      localdyi.icon = paramJSONArray.getJSONObject(i).optString("icon");
      parameiw.xuO.add(localdyi);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, eiw parameiw)
  {
    AppMethodBeat.i(126137);
    parameiw.NiE = new eiu();
    parameiw.NiE.Nil = paramJSONObject.optString("detailWording");
    parameiw.NiE.Nim = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        any localany = new any();
        localany.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localany.dQx = paramJSONObject.optJSONObject(i).optString("wording", "");
        localany.LzD = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        parameiw.NiE.Nin.add(localany);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, eiw parameiw, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    parameiw.Nio = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      parameiw.thumbWidth = 360;
    }
    for (parameiw.thumbHeight = 640;; parameiw.thumbHeight = 280)
    {
      if (Util.isNullOrNil(parameiw.Nio)) {
        parameiw.Nio = ("http://shp.qpic.cn/qqvideo_ori/0/" + parameiw.psI + String.format("_%s_%s/0", new Object[] { Integer.valueOf(parameiw.thumbWidth), Integer.valueOf(parameiw.thumbHeight) }));
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { parameiw.psI, parameiw.Nio });
      AppMethodBeat.o(126140);
      return;
      parameiw.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, eiw parameiw, JSONObject paramJSONObject)
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
            parameiw.Niv = localJSONObject.optInt("filesize", 0);
            eiy localeiy = new eiy();
            localeiy.url = localJSONObject.optString("url");
            localeiy.NiF = 0;
            parameiw.Niw.add(localeiy);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          parameiw.Nio = paramJSONObject.optString("coverUrl");
          if (parameiw.Niv > 0L)
          {
            boolean bool = Util.isNullOrNil(parameiw.Niw);
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
      catch (Exception parameiw)
      {
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + parameiw.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  public static boolean a(final eiw parameiw, final Context paramContext)
  {
    AppMethodBeat.i(236393);
    if (parameiw != null)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile sJumpType:%s", new Object[] { Integer.valueOf(parameiw.NiJ) });
      Object localObject;
      if (parameiw.NiJ == 1)
      {
        if (!Util.isNullOrNil(parameiw.eby))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", parameiw.eby);
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(236393);
          return true;
        }
      }
      else if ((parameiw.NiJ == 2) && (!TextUtils.isEmpty(parameiw.BmI)))
      {
        localObject = ((l)g.af(l.class)).aSN().Kn(parameiw.BmI);
        if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).gMZ > 0))
        {
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact exist");
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", parameiw.BmI);
          ((Intent)localObject).putExtra("biz_profile_tab_type", 1);
          com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(236393);
          return true;
          Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact not exist, getNow");
          final boolean[] arrayOfBoolean = new boolean[1];
          arrayOfBoolean[0] = false;
          localObject = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131762443), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.GnP[0] = true;
            }
          });
          try
          {
            ay.a.iDq.a(parameiw.BmI, "", new ay.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(236391);
                this.GnQ.dismiss();
                Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile getNow:%s, isCancel:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(arrayOfBoolean[0]) });
                if (arrayOfBoolean[0] != 0)
                {
                  AppMethodBeat.o(236391);
                  return;
                }
                if (paramAnonymousBoolean)
                {
                  paramAnonymousString = new Intent();
                  paramAnonymousString.putExtra("Contact_User", parameiw.BmI);
                  paramAnonymousString.putExtra("biz_profile_tab_type", 1);
                  com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousString);
                }
                AppMethodBeat.o(236391);
              }
            });
          }
          catch (Throwable parameiw)
          {
            ((com.tencent.mm.ui.base.q)localObject).dismiss();
            Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile err:%s", new Object[] { parameiw.getMessage() });
          }
        }
      }
    }
    AppMethodBeat.o(236393);
    return false;
  }
  
  public static int ape()
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
  
  private static void b(JSONObject paramJSONObject, eiw parameiw)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, parameiw)))
    {
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.hJ(parameiw.Niw);
      if (paramJSONObject != null)
      {
        parameiw.videoUrl = paramJSONObject.url;
        parameiw.NiF = paramJSONObject.NiF;
      }
    }
    if ((Util.isNullOrNil(parameiw.videoUrl)) && (!Util.isNullOrNil(str2)))
    {
      a(parameiw, str2, str1);
      if (Util.isNullOrNil(parameiw.Niw))
      {
        a.pl(29);
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(parameiw, str2, str1);
      }
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.hJ(parameiw.Niw);
      if (paramJSONObject != null)
      {
        parameiw.videoUrl = paramJSONObject.url;
        parameiw.NiF = paramJSONObject.NiF;
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
  
  private static boolean c(JSONObject paramJSONObject, eiw parameiw)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      parameiw.NiA = localJSONObject.optInt("cdnScene", 0);
      parameiw.NiB = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((parameiw.NiA == 1) || (parameiw.NiB == 2))
    {
      if (!a(parameiw.NiA, parameiw, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(parameiw.NiA), parameiw.psI, parameiw.title, Long.valueOf(parameiw.Niv) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static int fzA()
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
  
  private static int fzz()
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
  
  public static boolean i(eiw parameiw)
  {
    AppMethodBeat.i(236392);
    if (parameiw != null)
    {
      if ((parameiw.NiJ == 1) && (!TextUtils.isEmpty(parameiw.eby)))
      {
        AppMethodBeat.o(236392);
        return true;
      }
      if ((parameiw.NiJ == 2) && (!TextUtils.isEmpty(parameiw.BmI)))
      {
        AppMethodBeat.o(236392);
        return true;
      }
    }
    AppMethodBeat.o(236392);
    return false;
  }
  
  public final List<eiw> GW()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.GlS.fyD().Nif;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final void a(final eit parameit, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = GW();
        if ((Util.isNullOrNil(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((eiw)localList.get(i)).psI);
            i += 1;
            continue;
          }
          parameit = new e(parameit, localArrayList);
          g.azz().a(parameit, 0);
          g.azz().a(parameit.getType(), new com.tencent.mm.ak.i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
            {
              AppMethodBeat.i(126121);
              if (((paramAnonymousq instanceof e)) && (paramAnonymousq.equals(parameit)))
              {
                g.azz().b(parameit.getType(), this);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(126121);
                  return;
                }
                paramAnonymousString = (dky)((e)paramAnonymousq).rr.iLL.iLR;
                com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
                {
                  public final String getKey()
                  {
                    return "requestVideoUrlResultParse";
                  }
                  
                  public final void run()
                  {
                    AppMethodBeat.i(126120);
                    ArrayList localArrayList = new ArrayList();
                    ??? = paramAnonymousString.MOS.KKx.iterator();
                    Object localObject4;
                    Object localObject3;
                    Object localObject5;
                    Object localObject6;
                    while (((Iterator)???).hasNext())
                    {
                      localObject4 = (era)((Iterator)???).next();
                      localObject3 = new eiw();
                      if (!Util.isNullOrNil(((era)localObject4).Nor.pLq))
                      {
                        ((eiw)localObject3).psI = ((era)localObject4).Nor.pLq;
                        if ((((era)localObject4).Not != null) && (((era)localObject4).Not.NnT == 1)) {
                          if ((((era)localObject4).Not.NnV != null) && (!Util.isNullOrNil(((era)localObject4).Not.NnV.Lfy)))
                          {
                            ((eiw)localObject3).Niw.clear();
                            ((eiw)localObject3).NiB = ((era)localObject4).Not.NnW;
                            localObject4 = ((era)localObject4).Not.NnV.Lfy.iterator();
                            while (((Iterator)localObject4).hasNext())
                            {
                              localObject5 = (eoj)((Iterator)localObject4).next();
                              localObject6 = new eiy();
                              ((eiy)localObject6).url = ((eoj)localObject5).Nmh.yO();
                              ((eiy)localObject6).NiF = 0;
                              ((eiw)localObject3).Niw.add(localObject6);
                              ((eiw)localObject3).Niv = ((eoj)localObject5).Nmj;
                            }
                            localObject4 = com.tencent.mm.plugin.topstory.a.h.hJ(((eiw)localObject3).Niw);
                            if (localObject4 != null)
                            {
                              ((eiw)localObject3).videoUrl = ((eiy)localObject4).url;
                              ((eiw)localObject3).NiF = ((eiy)localObject4).NiF;
                            }
                          }
                        }
                        for (;;)
                        {
                          localArrayList.add(localObject3);
                          break;
                          if ((((era)localObject4).Not != null) && (((era)localObject4).Not.NnT == 2))
                          {
                            if ((((era)localObject4).Not.NnU != null) && (!Util.isNullOrNil(((era)localObject4).Not.NnU.Lfy)))
                            {
                              ((eiw)localObject3).Niw.clear();
                              ((eiw)localObject3).NiB = ((era)localObject4).Not.NnW;
                              localObject4 = ((era)localObject4).Not.NnU.Lfy.iterator();
                              while (((Iterator)localObject4).hasNext())
                              {
                                localObject5 = (eoj)((Iterator)localObject4).next();
                                localObject6 = new eiy();
                                ((eiy)localObject6).url = ((eoj)localObject5).Nmh.yO();
                                ((eiy)localObject6).NiF = 0;
                                ((eiw)localObject3).Niw.add(localObject6);
                                ((eiw)localObject3).Niv = ((eoj)localObject5).Nmj;
                              }
                              localObject4 = com.tencent.mm.plugin.topstory.a.h.hJ(((eiw)localObject3).Niw);
                              if (localObject4 != null)
                              {
                                ((eiw)localObject3).videoUrl = ((eiy)localObject4).url;
                                ((eiw)localObject3).NiF = ((eiy)localObject4).NiF;
                              }
                            }
                          }
                          else if (!Util.isNullOrNil(((era)localObject4).Nou))
                          {
                            ((eiw)localObject3).Niw.clear();
                            n.b((eiw)localObject3, ((era)localObject4).Nou, "");
                            localObject5 = com.tencent.mm.plugin.topstory.a.h.hJ(((eiw)localObject3).Niw);
                            if (localObject5 != null)
                            {
                              ((eiw)localObject3).videoUrl = ((eiy)localObject5).url;
                              ((eiw)localObject3).NiF = ((eiy)localObject5).NiF;
                              if (((era)localObject4).Not != null) {
                                ((eiw)localObject3).NiB = ((era)localObject4).Not.NnW;
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
                        localObject3 = n.this.GW();
                        if (Util.isNullOrNil((List)localObject3))
                        {
                          AppMethodBeat.o(126120);
                          return;
                        }
                        i = 0;
                        if (i >= ((List)localObject3).size()) {
                          break;
                        }
                        localObject4 = (eiw)((List)localObject3).get(i);
                        localObject5 = localArrayList.iterator();
                        if (((Iterator)localObject5).hasNext())
                        {
                          localObject6 = (eiw)((Iterator)localObject5).next();
                          if (!((eiw)localObject4).psI.equals(((eiw)localObject6).psI)) {
                            continue;
                          }
                          ((eiw)localObject4).Niw = ((eiw)localObject6).Niw;
                          ((eiw)localObject4).Niv = ((eiw)localObject6).Niv;
                          ((eiw)localObject4).videoUrl = ((eiw)localObject6).videoUrl;
                          ((eiw)localObject4).NiB = ((eiw)localObject6).NiB;
                          Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((eiw)localObject4).title, ((eiw)localObject4).videoUrl });
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
  
  public final void acc(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < GW().size()) {
        GW().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final eiw acd(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < GW().size())
      {
        eiw localeiw = (eiw)GW().get(paramInt);
        return localeiw;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean ace(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.GhN)
    {
      Log.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.GhN = true;
    eit localeit = com.tencent.mm.plugin.topstory.a.h.a(this.GlS.fyD());
    localeit.offset = paramInt;
    Object localObject1;
    if (!Util.isNullOrNil(this.GlS.fyD().NhX))
    {
      localObject1 = new aca();
      ((aca)localObject1).key = "relevant_vid";
      ((aca)localObject1).LmD = this.GlS.fyD().NhX;
      localeit.IDO.add(localObject1);
    }
    if (!Util.isNullOrNil(this.GlS.fyD().NhY))
    {
      localObject1 = new aca();
      ((aca)localObject1).key = "relevant_expand";
      ((aca)localObject1).LmD = this.GlS.fyD().NhY;
      localeit.IDO.add(localObject1);
    }
    if (!Util.isNullOrNil(this.GlS.fyD().NhZ))
    {
      localObject1 = new aca();
      ((aca)localObject1).key = "relevant_pre_searchid";
      ((aca)localObject1).LmD = this.GlS.fyD().NhZ;
      localeit.IDO.add(localObject1);
    }
    if (!Util.isNullOrNil(this.GlS.fyD().Nia))
    {
      localObject1 = new aca();
      ((aca)localObject1).key = "relevant_shared_openid";
      ((aca)localObject1).LmD = this.GlS.fyD().Nia;
      localeit.IDO.add(localObject1);
    }
    if (this.GlS.fyD().Nid != null)
    {
      localObject1 = new aca();
      ((aca)localObject1).key = "rec_category";
      ((aca)localObject1).LmC = this.GlS.fyD().Nid.MXW;
      localeit.IDO.add(localObject1);
      localObject1 = localeit.IDO.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((aca)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.GlS.fyD().Nid != null) && (paramInt != 0))
      {
        localObject1 = new aca();
        ((aca)localObject1).key = "show_tag_list";
        ((aca)localObject1).LmD = this.GlS.fyD().Nid.id;
        localeit.IDO.add(localObject1);
      }
      localObject1 = new aca();
      ((aca)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label653:
      com.tencent.mm.plugin.topstory.a.b.c localc;
      if ((this.GlS.fyD().Nid != null) && (!Util.isNullOrNil(this.GlS.fyD().Nid.id)))
      {
        ((aca)localObject1).LmC = 0L;
        localeit.IDO.add(localObject1);
        if (fzy() == 1)
        {
          localObject1 = acd(0);
          localObject2 = new aca();
          ((aca)localObject2).key = "first_video_tag_list";
          ((aca)localObject2).LmD = com.tencent.mm.plugin.topstory.a.h.hK(((eiw)localObject1).xuO).toString();
          localeit.IDO.add(localObject2);
        }
        localObject1 = this.GlS.fyB();
        if (((o)localObject1).GnR.size() <= 0) {
          break label928;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).GnR.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label779;
        }
        localc = (com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next();
        if (!localc.GjI) {
          break label774;
        }
      }
      label774:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.GjH.psI);
        ((StringBuffer)localObject1).append(";");
        break label653;
        localObject1 = new aca();
        ((aca)localObject1).key = "rec_category";
        ((aca)localObject1).LmC = this.GlS.fyD().Nib;
        localeit.IDO.add(localObject1);
        break;
        ((aca)localObject1).LmC = 1L;
        break label521;
      }
      label779:
      label928:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = new aca();
          ((aca)localObject2).key = "client_exposed_info";
          ((aca)localObject2).LmD = ((String)localObject1);
          localeit.IDO.add(localObject2);
        }
        localObject1 = new aca();
        ((aca)localObject1).key = "is_prefetch";
        ((aca)localObject1).LmC = this.GnE;
        localeit.IDO.add(localObject1);
        if (this.GnF != null)
        {
          g.azz().a(this.GnF);
          this.GnF = null;
        }
        this.GnF = new k(localeit);
        g.azz().a(this.GnF, 0);
        g.azz().a(1943, this.gNh);
        a.pl(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final int fzy()
  {
    AppMethodBeat.i(126127);
    int i = GW().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void h(eiw parameiw)
  {
    AppMethodBeat.i(126128);
    try
    {
      GW().add(parameiw);
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
    if (this.GnF != null)
    {
      g.azz().a(this.GnF);
      this.GnF = null;
    }
    if (this.GnI != null)
    {
      g.azz().a(this.GnI);
      this.GnI = null;
    }
    g.azz().b(1943, this.gNh);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private String sTh;
    private boolean xwi;
    
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
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:sTh	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:GnK	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:xwi	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:GnK	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:GhN	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:GnK	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:GhN	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:GnK	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:GhN	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */