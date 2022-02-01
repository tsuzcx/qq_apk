package com.tencent.mm.plugin.topstory.ui.video;

import android.webkit.URLUtil;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.v;
import com.tencent.mm.network.y;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.eek;
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
  public b BtO;
  public boolean BvA;
  public int BvB;
  k BvC;
  private int BvD;
  private int BvE;
  public com.tencent.mm.plugin.topstory.a.c.h BvF;
  public f hPn;
  
  public n()
  {
    AppMethodBeat.i(126125);
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        boolean bool = true;
        AppMethodBeat.i(126123);
        ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousn });
        if (paramAnonymousn.equals(n.this.BvC))
        {
          g.aiU().b(1943, n.this.hPn);
          n.this.BvC = null;
          paramAnonymousn = (k)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramAnonymousn.eoU().GDb });
            a.ma(2);
            n.this.BtO.aCV(paramAnonymousString);
            n.this.BvA = false;
            AppMethodBeat.o(126123);
            return;
          }
          paramAnonymousString = new n.a(n.this, (byte)0);
          n.a.a(paramAnonymousString, paramAnonymousn.eoU().GDb);
          if (paramAnonymousn.BrB.offset == 0) {}
          for (;;)
          {
            n.a.a(paramAnonymousString, bool);
            com.tencent.e.h.LTJ.f(paramAnonymousString, "TopStory.DecodeRecommendResultTask");
            AppMethodBeat.o(126123);
            return;
            bool = false;
          }
        }
        if (paramAnonymousn.equals(n.this.BvF))
        {
          g.aiU().b(1943, n.this.hPn);
          n.this.BvF = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.h)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            a.ma(2);
            AppMethodBeat.o(126123);
            return;
          }
          ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", new Object[] { paramAnonymousString.eoU().GDb });
          com.tencent.e.h.LTJ.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126122);
              try
              {
                Object localObject = new JSONObject(paramAnonymousString.eoU().GDb).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localObject = n.b(n.this.BtO.epI(), (JSONArray)localObject);
                  paramAnonymousString.BrC.HCF.HBZ.addAll((Collection)localObject);
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
  
  /* Error */
  private static dod a(JSONObject paramJSONObject, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
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
    //   32: invokestatic 71	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +1285 -> 1320
    //   38: new 73	com/tencent/mm/protocal/protobuf/dod
    //   41: dup
    //   42: invokespecial 74	com/tencent/mm/protocal/protobuf/dod:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: putfield 78	com/tencent/mm/protocal/protobuf/dod:tSk	Ljava/lang/String;
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 82	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   60: iload 6
    //   62: aload 8
    //   64: aload_0
    //   65: invokestatic 85	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/dod;Lorg/json/JSONObject;)V
    //   68: aload 8
    //   70: getfield 88	com/tencent/mm/protocal/protobuf/dod:videoUrl	Ljava/lang/String;
    //   73: invokestatic 71	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +8 -> 84
    //   79: bipush 11
    //   81: invokestatic 93	com/tencent/mm/plugin/websearch/api/a/a:ma	(I)V
    //   84: aload 8
    //   86: iload 7
    //   88: putfield 96	com/tencent/mm/protocal/protobuf/dod:zSz	I
    //   91: aload 8
    //   93: aload_0
    //   94: ldc 98
    //   96: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 100	com/tencent/mm/protocal/protobuf/dod:title	Ljava/lang/String;
    //   102: aload 8
    //   104: aload_0
    //   105: ldc 102
    //   107: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 105	com/tencent/mm/protocal/protobuf/dod:qeR	Ljava/lang/String;
    //   113: aload 8
    //   115: aload_0
    //   116: ldc 107
    //   118: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 110	com/tencent/mm/protocal/protobuf/dod:uaw	Ljava/lang/String;
    //   124: aload 8
    //   126: aload_0
    //   127: ldc 112
    //   129: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 115	com/tencent/mm/protocal/protobuf/dod:DBL	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: ldc 117
    //   140: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 120	com/tencent/mm/protocal/protobuf/dod:DBM	Ljava/lang/String;
    //   146: aload 8
    //   148: aload_0
    //   149: ldc 122
    //   151: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: putfield 125	com/tencent/mm/protocal/protobuf/dod:DBN	Ljava/lang/String;
    //   157: aload 8
    //   159: aload_0
    //   160: ldc 127
    //   162: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 129	com/tencent/mm/protocal/protobuf/dod:source	Ljava/lang/String;
    //   168: aload 8
    //   170: aload_0
    //   171: ldc 131
    //   173: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 134	com/tencent/mm/protocal/protobuf/dod:lox	Ljava/lang/String;
    //   179: aload 8
    //   181: aload_0
    //   182: ldc 136
    //   184: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: putfield 139	com/tencent/mm/protocal/protobuf/dod:qeQ	Ljava/lang/String;
    //   190: aload 8
    //   192: aload_0
    //   193: ldc 141
    //   195: ldc2_w 142
    //   198: invokevirtual 147	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   201: putfield 151	com/tencent/mm/protocal/protobuf/dod:HCu	J
    //   204: aload 8
    //   206: aload_0
    //   207: ldc 153
    //   209: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 156	com/tencent/mm/protocal/protobuf/dod:HCv	Ljava/lang/String;
    //   215: aload 8
    //   217: aload_0
    //   218: ldc 158
    //   220: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 161	com/tencent/mm/protocal/protobuf/dod:HCw	Ljava/lang/String;
    //   226: aload 8
    //   228: aload_0
    //   229: ldc 163
    //   231: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 166	com/tencent/mm/protocal/protobuf/dod:DBO	Ljava/lang/String;
    //   237: aload 8
    //   239: aload_0
    //   240: ldc 168
    //   242: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 171	com/tencent/mm/protocal/protobuf/dod:DBP	Ljava/lang/String;
    //   248: aload 8
    //   250: aload_0
    //   251: ldc 173
    //   253: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   256: putfield 179	com/tencent/mm/protocal/protobuf/dod:HCx	I
    //   259: aload 8
    //   261: aload_0
    //   262: ldc 181
    //   264: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 184	com/tencent/mm/protocal/protobuf/dod:HCz	Ljava/lang/String;
    //   270: aload 8
    //   272: aload_0
    //   273: ldc 186
    //   275: aload 8
    //   277: getfield 151	com/tencent/mm/protocal/protobuf/dod:HCu	J
    //   280: invokevirtual 147	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   283: putfield 189	com/tencent/mm/protocal/protobuf/dod:HCE	J
    //   286: aload 8
    //   288: invokestatic 193	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   291: putfield 196	com/tencent/mm/protocal/protobuf/dod:timestamp	J
    //   294: aload 8
    //   296: iconst_0
    //   297: putfield 199	com/tencent/mm/protocal/protobuf/dod:dmo	Z
    //   300: aload 8
    //   302: aload 10
    //   304: putfield 202	com/tencent/mm/protocal/protobuf/dod:tul	Ljava/lang/String;
    //   307: aload 8
    //   309: lload_1
    //   310: putfield 205	com/tencent/mm/protocal/protobuf/dod:HCA	J
    //   313: aload 8
    //   315: lload_3
    //   316: putfield 208	com/tencent/mm/protocal/protobuf/dod:dle	J
    //   319: aload 8
    //   321: aload 5
    //   323: putfield 211	com/tencent/mm/protocal/protobuf/dod:HCy	Ljava/lang/String;
    //   326: aload 8
    //   328: aload_0
    //   329: ldc 213
    //   331: iconst_0
    //   332: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   335: putfield 216	com/tencent/mm/protocal/protobuf/dod:HCD	I
    //   338: aload_0
    //   339: ldc 218
    //   341: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   344: astore 5
    //   346: aload 5
    //   348: ifnull +42 -> 390
    //   351: aload 8
    //   353: aload 5
    //   355: ldc 224
    //   357: invokevirtual 227	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   360: putfield 230	com/tencent/mm/protocal/protobuf/dod:HCI	Z
    //   363: aload 8
    //   365: aload 5
    //   367: ldc 232
    //   369: ldc 234
    //   371: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: putfield 240	com/tencent/mm/protocal/protobuf/dod:HCJ	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 5
    //   381: ldc 242
    //   383: iconst_0
    //   384: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   387: putfield 245	com/tencent/mm/protocal/protobuf/dod:HCN	I
    //   390: aload_0
    //   391: ldc 247
    //   393: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   396: astore 5
    //   398: aload 5
    //   400: ifnull +16 -> 416
    //   403: aload 8
    //   405: getfield 255	com/tencent/mm/protocal/protobuf/dod:DBj	Ljava/util/LinkedList;
    //   408: aload 5
    //   410: invokevirtual 261	org/json/JSONArray:toString	()Ljava/lang/String;
    //   413: invokestatic 267	com/tencent/mm/plugin/topstory/a/h:p	(Ljava/util/List;Ljava/lang/String;)V
    //   416: aload_0
    //   417: ldc_w 269
    //   420: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   423: astore 5
    //   425: aload 5
    //   427: ifnull +10 -> 437
    //   430: aload 5
    //   432: aload 8
    //   434: invokestatic 272	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   437: aload_0
    //   438: ldc_w 274
    //   441: iconst_0
    //   442: invokevirtual 277	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   445: ifne +15 -> 460
    //   448: aload_0
    //   449: ldc_w 279
    //   452: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   455: aload 8
    //   457: invokestatic 281	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   460: aload_0
    //   461: ldc_w 283
    //   464: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   467: astore 5
    //   469: aload 5
    //   471: ifnull +313 -> 784
    //   474: aload 5
    //   476: iconst_0
    //   477: invokevirtual 286	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   480: astore 5
    //   482: aload 8
    //   484: new 288	com/tencent/mm/protocal/protobuf/dnw
    //   487: dup
    //   488: invokespecial 289	com/tencent/mm/protocal/protobuf/dnw:<init>	()V
    //   491: putfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   494: aload 8
    //   496: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   499: aload 5
    //   501: ldc_w 295
    //   504: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   507: putfield 298	com/tencent/mm/protocal/protobuf/dnw:HBQ	Ljava/lang/String;
    //   510: aload 8
    //   512: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   515: aload 5
    //   517: ldc_w 300
    //   520: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   523: putfield 302	com/tencent/mm/protocal/protobuf/dnw:id	Ljava/lang/String;
    //   526: aload 5
    //   528: ldc_w 304
    //   531: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   534: iconst_0
    //   535: invokevirtual 286	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   538: astore 5
    //   540: aload 8
    //   542: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   545: aload 5
    //   547: ldc_w 306
    //   550: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   553: putfield 309	com/tencent/mm/protocal/protobuf/dnw:HBO	I
    //   556: aload 8
    //   558: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   561: aload 5
    //   563: ldc_w 311
    //   566: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   569: putfield 314	com/tencent/mm/protocal/protobuf/dnw:htQ	I
    //   572: aload 8
    //   574: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   577: aload 5
    //   579: ldc_w 316
    //   582: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   585: putfield 319	com/tencent/mm/protocal/protobuf/dnw:HBP	I
    //   588: aload 8
    //   590: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   593: aload 5
    //   595: ldc_w 321
    //   598: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   601: putfield 323	com/tencent/mm/protocal/protobuf/dnw:type	I
    //   604: aload 8
    //   606: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   609: aload 5
    //   611: ldc_w 300
    //   614: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   617: putfield 326	com/tencent/mm/protocal/protobuf/dnw:kPR	Ljava/lang/String;
    //   620: new 53	org/json/JSONObject
    //   623: dup
    //   624: aload 5
    //   626: ldc_w 328
    //   629: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokespecial 331	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   635: astore 5
    //   637: aload 8
    //   639: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   642: new 333	com/tencent/mm/protocal/protobuf/dnv
    //   645: dup
    //   646: invokespecial 334	com/tencent/mm/protocal/protobuf/dnv:<init>	()V
    //   649: putfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   652: aload 8
    //   654: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   657: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   660: aload 5
    //   662: ldc 98
    //   664: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   667: putfield 339	com/tencent/mm/protocal/protobuf/dnv:title	Ljava/lang/String;
    //   670: aload 8
    //   672: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   675: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   678: aload 5
    //   680: ldc_w 341
    //   683: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   686: putfield 343	com/tencent/mm/protocal/protobuf/dnv:desc	Ljava/lang/String;
    //   689: aload 8
    //   691: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   694: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   697: aload 5
    //   699: ldc_w 345
    //   702: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: putfield 348	com/tencent/mm/protocal/protobuf/dnv:dJH	Ljava/lang/String;
    //   708: aload 8
    //   710: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   713: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   716: aload 5
    //   718: ldc_w 350
    //   721: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: putfield 353	com/tencent/mm/protocal/protobuf/dnv:HBM	Ljava/lang/String;
    //   727: aload 8
    //   729: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   732: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   735: aload 5
    //   737: ldc_w 355
    //   740: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 358	com/tencent/mm/protocal/protobuf/dnv:HBN	Ljava/lang/String;
    //   746: aload 8
    //   748: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   751: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   754: aload 5
    //   756: ldc_w 360
    //   759: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   762: putfield 362	com/tencent/mm/protocal/protobuf/dnv:appId	Ljava/lang/String;
    //   765: aload 8
    //   767: getfield 293	com/tencent/mm/protocal/protobuf/dod:HCO	Lcom/tencent/mm/protocal/protobuf/dnw;
    //   770: getfield 338	com/tencent/mm/protocal/protobuf/dnw:HBR	Lcom/tencent/mm/protocal/protobuf/dnv;
    //   773: aload 5
    //   775: ldc_w 364
    //   778: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 367	com/tencent/mm/protocal/protobuf/dnv:sjU	Ljava/lang/String;
    //   784: aload_0
    //   785: ldc_w 369
    //   788: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   791: astore 5
    //   793: aload 5
    //   795: ifnull +101 -> 896
    //   798: aload 8
    //   800: new 371	com/tencent/mm/protocal/protobuf/dny
    //   803: dup
    //   804: invokespecial 372	com/tencent/mm/protocal/protobuf/dny:<init>	()V
    //   807: putfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   810: aload 8
    //   812: getfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   815: aload 5
    //   817: ldc_w 378
    //   820: iconst_2
    //   821: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   824: putfield 381	com/tencent/mm/protocal/protobuf/dny:FcU	I
    //   827: aload 8
    //   829: getfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   832: aload 5
    //   834: ldc_w 383
    //   837: ldc 234
    //   839: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   842: putfield 386	com/tencent/mm/protocal/protobuf/dny:HBW	Ljava/lang/String;
    //   845: aload 8
    //   847: getfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   850: aload 5
    //   852: ldc_w 388
    //   855: iconst_1
    //   856: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   859: putfield 391	com/tencent/mm/protocal/protobuf/dny:HBV	I
    //   862: aload 8
    //   864: getfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   867: aload 5
    //   869: ldc_w 393
    //   872: iconst_0
    //   873: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   876: putfield 396	com/tencent/mm/protocal/protobuf/dny:HBX	I
    //   879: aload 8
    //   881: getfield 376	com/tencent/mm/protocal/protobuf/dod:HCF	Lcom/tencent/mm/protocal/protobuf/dny;
    //   884: aload 5
    //   886: ldc_w 398
    //   889: iconst_0
    //   890: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   893: putfield 401	com/tencent/mm/protocal/protobuf/dny:HBY	I
    //   896: aload_0
    //   897: ldc_w 403
    //   900: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   903: astore_0
    //   904: aload_0
    //   905: ifnull +349 -> 1254
    //   908: aload 8
    //   910: new 73	com/tencent/mm/protocal/protobuf/dod
    //   913: dup
    //   914: invokespecial 74	com/tencent/mm/protocal/protobuf/dod:<init>	()V
    //   917: putfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   920: aload 8
    //   922: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   925: aload_0
    //   926: ldc 59
    //   928: ldc 234
    //   930: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   933: putfield 202	com/tencent/mm/protocal/protobuf/dod:tul	Ljava/lang/String;
    //   936: aload 8
    //   938: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   941: aload_0
    //   942: ldc 98
    //   944: ldc 234
    //   946: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   949: putfield 100	com/tencent/mm/protocal/protobuf/dod:title	Ljava/lang/String;
    //   952: aload 8
    //   954: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   957: aload_0
    //   958: ldc 61
    //   960: iconst_0
    //   961: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   964: putfield 96	com/tencent/mm/protocal/protobuf/dod:zSz	I
    //   967: aload 8
    //   969: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   972: aload_0
    //   973: ldc 173
    //   975: iconst_0
    //   976: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   979: putfield 179	com/tencent/mm/protocal/protobuf/dod:HCx	I
    //   982: aload 8
    //   984: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   987: aload_0
    //   988: ldc 51
    //   990: ldc 234
    //   992: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   995: putfield 78	com/tencent/mm/protocal/protobuf/dod:tSk	Ljava/lang/String;
    //   998: aload_0
    //   999: ldc_w 269
    //   1002: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1005: astore 5
    //   1007: aload 5
    //   1009: ifnull +13 -> 1022
    //   1012: aload 5
    //   1014: aload 8
    //   1016: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1019: invokestatic 272	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONArray;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   1022: aload_0
    //   1023: ldc_w 279
    //   1026: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1029: astore 5
    //   1031: aload 5
    //   1033: ifnull +13 -> 1046
    //   1036: aload 5
    //   1038: aload 8
    //   1040: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1043: invokestatic 281	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   1046: aload_0
    //   1047: ldc 247
    //   1049: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1052: astore 5
    //   1054: aload 5
    //   1056: ifnull +19 -> 1075
    //   1059: aload 8
    //   1061: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1064: getfield 255	com/tencent/mm/protocal/protobuf/dod:DBj	Ljava/util/LinkedList;
    //   1067: aload 5
    //   1069: invokevirtual 261	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1072: invokestatic 267	com/tencent/mm/plugin/topstory/a/h:p	(Ljava/util/List;Ljava/lang/String;)V
    //   1075: aload_0
    //   1076: aload 8
    //   1078: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1081: invokestatic 82	com/tencent/mm/plugin/topstory/ui/video/n:b	(Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/dod;)V
    //   1084: iload 6
    //   1086: aload 8
    //   1088: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1091: aload_0
    //   1092: invokestatic 85	com/tencent/mm/plugin/topstory/ui/video/n:a	(ZLcom/tencent/mm/protocal/protobuf/dod;Lorg/json/JSONObject;)V
    //   1095: aload 8
    //   1097: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1100: aload 8
    //   1102: getfield 129	com/tencent/mm/protocal/protobuf/dod:source	Ljava/lang/String;
    //   1105: putfield 129	com/tencent/mm/protocal/protobuf/dod:source	Ljava/lang/String;
    //   1108: aload 8
    //   1110: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1113: aload 8
    //   1115: getfield 134	com/tencent/mm/protocal/protobuf/dod:lox	Ljava/lang/String;
    //   1118: putfield 134	com/tencent/mm/protocal/protobuf/dod:lox	Ljava/lang/String;
    //   1121: aload 8
    //   1123: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1126: aload 8
    //   1128: getfield 184	com/tencent/mm/protocal/protobuf/dod:HCz	Ljava/lang/String;
    //   1131: putfield 184	com/tencent/mm/protocal/protobuf/dod:HCz	Ljava/lang/String;
    //   1134: aload 8
    //   1136: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1139: aload 8
    //   1141: getfield 189	com/tencent/mm/protocal/protobuf/dod:HCE	J
    //   1144: putfield 189	com/tencent/mm/protocal/protobuf/dod:HCE	J
    //   1147: aload 8
    //   1149: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1152: aload 8
    //   1154: getfield 105	com/tencent/mm/protocal/protobuf/dod:qeR	Ljava/lang/String;
    //   1157: putfield 105	com/tencent/mm/protocal/protobuf/dod:qeR	Ljava/lang/String;
    //   1160: aload 8
    //   1162: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1165: aload 8
    //   1167: getfield 110	com/tencent/mm/protocal/protobuf/dod:uaw	Ljava/lang/String;
    //   1170: putfield 110	com/tencent/mm/protocal/protobuf/dod:uaw	Ljava/lang/String;
    //   1173: aload 8
    //   1175: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1178: aload 8
    //   1180: getfield 156	com/tencent/mm/protocal/protobuf/dod:HCv	Ljava/lang/String;
    //   1183: putfield 156	com/tencent/mm/protocal/protobuf/dod:HCv	Ljava/lang/String;
    //   1186: aload 8
    //   1188: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1191: aload 8
    //   1193: getfield 115	com/tencent/mm/protocal/protobuf/dod:DBL	Ljava/lang/String;
    //   1196: putfield 115	com/tencent/mm/protocal/protobuf/dod:DBL	Ljava/lang/String;
    //   1199: aload 8
    //   1201: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1204: aload 8
    //   1206: getfield 120	com/tencent/mm/protocal/protobuf/dod:DBM	Ljava/lang/String;
    //   1209: putfield 120	com/tencent/mm/protocal/protobuf/dod:DBM	Ljava/lang/String;
    //   1212: aload 8
    //   1214: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1217: aload 8
    //   1219: getfield 125	com/tencent/mm/protocal/protobuf/dod:DBN	Ljava/lang/String;
    //   1222: putfield 125	com/tencent/mm/protocal/protobuf/dod:DBN	Ljava/lang/String;
    //   1225: aload 8
    //   1227: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1230: aload 8
    //   1232: getfield 156	com/tencent/mm/protocal/protobuf/dod:HCv	Ljava/lang/String;
    //   1235: putfield 156	com/tencent/mm/protocal/protobuf/dod:HCv	Ljava/lang/String;
    //   1238: aload 8
    //   1240: getfield 407	com/tencent/mm/protocal/protobuf/dod:HCM	Lcom/tencent/mm/protocal/protobuf/dod;
    //   1243: aload_0
    //   1244: ldc 136
    //   1246: ldc 234
    //   1248: invokevirtual 237	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1251: putfield 139	com/tencent/mm/protocal/protobuf/dod:qeQ	Ljava/lang/String;
    //   1254: aload 8
    //   1256: getfield 88	com/tencent/mm/protocal/protobuf/dod:videoUrl	Ljava/lang/String;
    //   1259: invokestatic 71	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1262: ifne +51 -> 1313
    //   1265: ldc_w 409
    //   1268: ldc_w 411
    //   1271: iconst_3
    //   1272: anewarray 4	java/lang/Object
    //   1275: dup
    //   1276: iconst_0
    //   1277: aload 8
    //   1279: getfield 78	com/tencent/mm/protocal/protobuf/dod:tSk	Ljava/lang/String;
    //   1282: aastore
    //   1283: dup
    //   1284: iconst_1
    //   1285: aload 8
    //   1287: getfield 88	com/tencent/mm/protocal/protobuf/dod:videoUrl	Ljava/lang/String;
    //   1290: aastore
    //   1291: dup
    //   1292: iconst_2
    //   1293: aload 8
    //   1295: getfield 414	com/tencent/mm/protocal/protobuf/dod:HCB	J
    //   1298: invokestatic 420	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1301: aastore
    //   1302: invokestatic 425	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1305: ldc 49
    //   1307: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1310: aload 8
    //   1312: areturn
    //   1313: ldc 49
    //   1315: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1318: aconst_null
    //   1319: areturn
    //   1320: ldc 49
    //   1322: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1325: aconst_null
    //   1326: areturn
    //   1327: astore 5
    //   1329: goto -545 -> 784
    //   1332: astore 5
    //   1334: goto -550 -> 784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1337	0	paramJSONObject	JSONObject
    //   0	1337	1	paramLong1	long
    //   0	1337	3	paramLong2	long
    //   0	1337	5	paramString	String
    //   0	1337	6	paramBoolean	boolean
    //   28	59	7	i	int
    //   45	1266	8	localdod	dod
    //   11	39	9	str1	String
    //   19	284	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   460	469	1327	java/lang/Exception
    //   474	784	1332	java/lang/Exception
  }
  
  private static List<dod> a(boolean paramBoolean, JSONArray paramJSONArray)
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
          dod localdod = a(localJSONObject, l1, l2, str, paramBoolean);
          if (localdod != null)
          {
            ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { localdod.tSk, localdod.videoUrl, Long.valueOf(localdod.HCB) });
            localArrayList.add(localdod);
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
  
  private static void a(dod paramdod, String paramString1, String paramString2)
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
      j = eqw();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      k = aaW();
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      m = eqx();
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
        break label522;
      }
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1 = com.tencent.mm.network.b.Is(paramString1);
      localObject3 = paramString1;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = str;
      localObject5 = localObject7;
      paramString1.aOY();
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
      localInputStream1 = paramString1.iFV.getInputStream();
    }
    catch (Throwable paramdod)
    {
      int j;
      int k;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramdod, "getVideoUrlByVideoApi error: %s", new Object[] { paramdod.getMessage() });
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
        break label931;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject7).optJSONArray("fi");
      if (localObject7 == null) {
        break label931;
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
            paramdod.HCB = ((JSONObject)localObject8).optLong("fs");
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
                    localObject6 = e((String)localObject6, "&", j, k, m);
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    localObject7 = new dof();
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((dof)localObject7).url = ((String)localObject6);
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    ((dof)localObject7).HCL = n;
                    localObject3 = paramString1;
                    localObject4 = localv;
                    localInputStream2 = localInputStream1;
                    localObject1 = paramString1;
                    localObject2 = localv;
                    localObject5 = localInputStream1;
                    paramdod.HCC.add(localObject7);
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
        break label1781;
      }
      localv.disconnect();
      if (paramString1 == null) {
        break label1789;
      }
      paramString1.disconnect();
      if (localInputStream1 == null) {
        break label1845;
      }
      com.tencent.mm.vfs.q.closeQuietly(localInputStream1);
      AppMethodBeat.o(126142);
      return;
    }
    finally
    {
      if (localObject2 == null) {
        break label1817;
      }
      ((v)localObject2).disconnect();
      if (localObject1 == null) {
        break label1827;
      }
      ((y)localObject1).disconnect();
      if (localObject5 == null) {
        break label1837;
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
  
  private static void a(JSONArray paramJSONArray, dod paramdod)
  {
    AppMethodBeat.i(126136);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      dei localdei = new dei();
      localdei.id = paramJSONArray.getJSONObject(i).optString("id");
      localdei.dxD = paramJSONArray.getJSONObject(i).optString("wording");
      localdei.HsJ = paramJSONArray.getJSONObject(i).optLong("category");
      localdei.actionType = paramJSONArray.getJSONObject(i).optInt("actionType");
      localdei.url = paramJSONArray.getJSONObject(i).optString("url");
      localdei.title = paramJSONArray.getJSONObject(i).optString("title");
      localdei.nch = paramJSONArray.getJSONObject(i).optString("subTitle");
      localdei.dDH = paramJSONArray.getJSONObject(i).optString("icon");
      paramdod.tSj.add(localdei);
      i += 1;
    }
    AppMethodBeat.o(126136);
  }
  
  private static void a(JSONObject paramJSONObject, dod paramdod)
  {
    AppMethodBeat.i(126137);
    paramdod.HCK = new dob();
    paramdod.HCK.HCp = paramJSONObject.optString("detailWording");
    paramdod.HCK.HCq = paramJSONObject.optString("detailUrl");
    paramJSONObject = paramJSONObject.optJSONArray("feedbackData");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        akz localakz = new akz();
        localakz.id = paramJSONObject.optJSONObject(i).optString("id", "");
        localakz.dxD = paramJSONObject.optJSONObject(i).optString("wording", "");
        localakz.GkR = paramJSONObject.optJSONObject(i).optBoolean("isUseToConfirm", false);
        paramdod.HCK.HCr.add(localakz);
        i += 1;
      }
    }
    AppMethodBeat.o(126137);
  }
  
  private static void a(boolean paramBoolean, dod paramdod, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126140);
    paramdod.HCt = paramJSONObject.optString("thumbUrl");
    if (paramBoolean) {
      paramdod.thumbWidth = 360;
    }
    for (paramdod.thumbHeight = 640;; paramdod.thumbHeight = 280)
    {
      if (bt.isNullOrNil(paramdod.HCt)) {
        paramdod.HCt = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramdod.tSk + String.format("_%s_%s/0", new Object[] { Integer.valueOf(paramdod.thumbWidth), Integer.valueOf(paramdod.thumbHeight) }));
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", new Object[] { paramdod.tSk, paramdod.HCt });
      AppMethodBeat.o(126140);
      return;
      paramdod.thumbWidth = 496;
    }
  }
  
  private static boolean a(int paramInt, dod paramdod, JSONObject paramJSONObject)
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
            paramdod.HCB = localJSONObject.optInt("filesize", 0);
            dof localdof = new dof();
            localdof.url = localJSONObject.optString("url");
            localdof.HCL = 0;
            paramdod.HCC.add(localdof);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramdod.HCt = paramJSONObject.optString("coverUrl");
          if (paramdod.HCB > 0L)
          {
            boolean bool = bt.hj(paramdod.HCC);
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
      catch (Exception paramdod)
      {
        ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramdod.getMessage());
        AppMethodBeat.o(126141);
        return false;
      }
      AppMethodBeat.o(126141);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  public static int aaW()
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
  
  private static void b(JSONObject paramJSONObject, dod paramdod)
  {
    AppMethodBeat.i(126138);
    String str1 = paramJSONObject.optString("videoPlatform");
    String str2 = paramJSONObject.optString("videoApi");
    paramJSONObject = paramJSONObject.optJSONObject("videoInfo");
    if ((paramJSONObject != null) && (c(paramJSONObject, paramdod)))
    {
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gy(paramdod.HCC);
      if (paramJSONObject != null)
      {
        paramdod.videoUrl = paramJSONObject.url;
        paramdod.HCL = paramJSONObject.HCL;
      }
    }
    if ((bt.isNullOrNil(paramdod.videoUrl)) && (!bt.isNullOrNil(str2)))
    {
      a(paramdod, str2, str1);
      if (bt.hj(paramdod.HCC))
      {
        a.ma(29);
        ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
        a(paramdod, str2, str1);
      }
      paramJSONObject = com.tencent.mm.plugin.topstory.a.h.gy(paramdod.HCC);
      if (paramJSONObject != null)
      {
        paramdod.videoUrl = paramJSONObject.url;
        paramdod.HCL = paramJSONObject.HCL;
      }
    }
    AppMethodBeat.o(126138);
  }
  
  private static boolean c(JSONObject paramJSONObject, dod paramdod)
  {
    AppMethodBeat.i(126139);
    JSONObject localJSONObject = null;
    if (paramJSONObject != null) {
      localJSONObject = paramJSONObject.optJSONObject("videoCdnInfo");
    }
    if (localJSONObject != null)
    {
      paramdod.HCG = localJSONObject.optInt("cdnScene", 0);
      paramdod.HCH = localJSONObject.optInt("cdnSourceType", 0);
    }
    if ((paramdod.HCG == 1) || (paramdod.HCH == 2))
    {
      if (!a(paramdod.HCG, paramdod, localJSONObject))
      {
        AppMethodBeat.o(126139);
        return false;
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(paramdod.HCG), paramdod.tSk, paramdod.title, Long.valueOf(paramdod.HCB) });
      AppMethodBeat.o(126139);
      return true;
    }
    AppMethodBeat.o(126139);
    return false;
  }
  
  private static String e(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
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
  
  private static int eqw()
  {
    AppMethodBeat.i(126143);
    if (com.tencent.mm.plugin.topstory.a.h.eoN())
    {
      AppMethodBeat.o(126143);
      return 2;
    }
    AppMethodBeat.o(126143);
    return -1;
  }
  
  private static int eqx()
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
  
  public final void Tf(int paramInt)
  {
    AppMethodBeat.i(126129);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < cNm().size()) {
        cNm().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(126129);
    }
  }
  
  public final dod Tg(int paramInt)
  {
    AppMethodBeat.i(126130);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < cNm().size())
      {
        dod localdod = (dod)cNm().get(paramInt);
        return localdod;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(126130);
    }
  }
  
  public final boolean Th(int paramInt)
  {
    AppMethodBeat.i(126131);
    if (this.BvA)
    {
      ad.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(126131);
      return false;
    }
    ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.BvA = true;
    doa localdoa = com.tencent.mm.plugin.topstory.a.h.a(this.BtO.epz());
    localdoa.offset = paramInt;
    Object localObject1;
    if (!bt.isNullOrNil(this.BtO.epz().HCb))
    {
      localObject1 = new aag();
      ((aag)localObject1).key = "relevant_vid";
      ((aag)localObject1).FZf = this.BtO.epz().HCb;
      localdoa.DBj.add(localObject1);
    }
    if (!bt.isNullOrNil(this.BtO.epz().HCc))
    {
      localObject1 = new aag();
      ((aag)localObject1).key = "relevant_expand";
      ((aag)localObject1).FZf = this.BtO.epz().HCc;
      localdoa.DBj.add(localObject1);
    }
    if (!bt.isNullOrNil(this.BtO.epz().HCd))
    {
      localObject1 = new aag();
      ((aag)localObject1).key = "relevant_pre_searchid";
      ((aag)localObject1).FZf = this.BtO.epz().HCd;
      localdoa.DBj.add(localObject1);
    }
    if (!bt.isNullOrNil(this.BtO.epz().HCe))
    {
      localObject1 = new aag();
      ((aag)localObject1).key = "relevant_shared_openid";
      ((aag)localObject1).FZf = this.BtO.epz().HCe;
      localdoa.DBj.add(localObject1);
    }
    if (this.BtO.epz().HCh != null)
    {
      localObject1 = new aag();
      ((aag)localObject1).key = "rec_category";
      ((aag)localObject1).FZe = this.BtO.epz().HCh.HsJ;
      localdoa.DBj.add(localObject1);
      localObject1 = localdoa.DBj.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((aag)((Iterator)localObject1).next()).key));
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.BtO.epz().HCh != null) && (paramInt != 0))
      {
        localObject1 = new aag();
        ((aag)localObject1).key = "show_tag_list";
        ((aag)localObject1).FZf = this.BtO.epz().HCh.id;
        localdoa.DBj.add(localObject1);
      }
      localObject1 = new aag();
      ((aag)localObject1).key = "fetch_seed_videoinfo";
      label521:
      Object localObject2;
      label653:
      c localc;
      if ((this.BtO.epz().HCh != null) && (!bt.isNullOrNil(this.BtO.epz().HCh.id)))
      {
        ((aag)localObject1).FZe = 0L;
        localdoa.DBj.add(localObject1);
        if (eqv() == 1)
        {
          localObject1 = Tg(0);
          localObject2 = new aag();
          ((aag)localObject2).key = "first_video_tag_list";
          ((aag)localObject2).FZf = com.tencent.mm.plugin.topstory.a.h.gz(((dod)localObject1).tSj).toString();
          localdoa.DBj.add(localObject2);
        }
        localObject1 = this.BtO.epx();
        if (((o)localObject1).BvM.size() <= 0) {
          break label928;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).BvM.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label779;
        }
        localc = (c)((Iterator)localObject2).next();
        if (!localc.BrA) {
          break label774;
        }
      }
      label774:
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localc.Brz.tSk);
        ((StringBuffer)localObject1).append(";");
        break label653;
        localObject1 = new aag();
        ((aag)localObject1).key = "rec_category";
        ((aag)localObject1).FZe = this.BtO.epz().HCf;
        localdoa.DBj.add(localObject1);
        break;
        ((aag)localObject1).FZe = 1L;
        break label521;
      }
      label779:
      label928:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = new aag();
          ((aag)localObject2).key = "client_exposed_info";
          ((aag)localObject2).FZf = ((String)localObject1);
          localdoa.DBj.add(localObject2);
        }
        localObject1 = new aag();
        ((aag)localObject1).key = "is_prefetch";
        ((aag)localObject1).FZe = this.BvB;
        localdoa.DBj.add(localObject1);
        if (this.BvC != null)
        {
          g.aiU().a(this.BvC);
          this.BvC = null;
        }
        this.BvC = new k(localdoa);
        g.aiU().a(this.BvC, 0);
        g.aiU().a(1943, this.hPn);
        a.ma(0);
        AppMethodBeat.o(126131);
        return true;
      }
    }
  }
  
  public final void a(doa paramdoa, int paramInt)
  {
    AppMethodBeat.i(126132);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = cNm();
        if ((bt.hj(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          paramInt -= 1;
          int i = paramInt;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((dod)localList.get(i)).tSk);
            i += 1;
            continue;
          }
          paramdoa = new e(paramdoa, localArrayList);
          g.aiU().a(paramdoa, 0);
          g.aiU().a(paramdoa.getType(), new n.1(this, paramdoa));
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
  
  public final List<dod> cNm()
  {
    AppMethodBeat.i(126126);
    LinkedList localLinkedList = this.BtO.epz().HCj;
    AppMethodBeat.o(126126);
    return localLinkedList;
  }
  
  public final int eqv()
  {
    AppMethodBeat.i(126127);
    int i = cNm().size();
    AppMethodBeat.o(126127);
    return i;
  }
  
  public final void h(dod paramdod)
  {
    AppMethodBeat.i(126128);
    try
    {
      cNm().add(paramdod);
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
    if (this.BvC != null)
    {
      g.aiU().a(this.BvC);
      this.BvC = null;
    }
    if (this.BvF != null)
    {
      g.aiU().a(this.BvF);
      this.BvF = null;
    }
    g.aiU().b(1943, this.hPn);
    AppMethodBeat.o(126133);
  }
  
  final class a
    implements Runnable
  {
    private String rjM;
    private boolean tTr;
    
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
      //   10: getfield 29	com/tencent/mm/plugin/topstory/ui/video/n$a:rjM	Ljava/lang/String;
      //   13: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:BvH	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   21: aload_1
      //   22: aload_0
      //   23: getfield 32	com/tencent/mm/plugin/topstory/ui/video/n$a:tTr	Z
      //   26: invokestatic 50	com/tencent/mm/plugin/topstory/ui/video/n:a	(Lcom/tencent/mm/plugin/topstory/ui/video/n;Lorg/json/JSONObject;Z)V
      //   29: aload_0
      //   30: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:BvH	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   33: iconst_0
      //   34: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:BvA	Z
      //   37: ldc 36
      //   39: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:BvH	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   48: iconst_0
      //   49: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:BvA	Z
      //   52: ldc 36
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 19	com/tencent/mm/plugin/topstory/ui/video/n$a:BvH	Lcom/tencent/mm/plugin/topstory/ui/video/n;
      //   63: iconst_0
      //   64: putfield 53	com/tencent/mm/plugin/topstory/ui/video/n:BvA	Z
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