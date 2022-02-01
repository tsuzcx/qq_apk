package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gb.a;
import com.tencent.mm.model.as.f;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.pluginsdk.i.g.a;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements ax
{
  static cm Bgl;
  private Map<String, ax> Bgm;
  private a Bgn;
  private com.tencent.mm.plugin.subapp.e.a Bgo;
  private com.tencent.mm.plugin.subapp.e.c Bgp;
  private n.a appForegroundListener;
  
  public a()
  {
    AppMethodBeat.i(28847);
    this.Bgm = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (g.EPa != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.emI();
          com.tencent.mm.plugin.subapp.jdbiz.d.emP();
        }
        AppMethodBeat.o(28832);
      }
    };
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.au.d.class.getName(), new com.tencent.mm.au.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.d.d();
    com.tencent.mm.model.as.a.hFR = (as.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    g.EPa = (g.a)localObject;
    this.Bgm = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final ax aCu(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (ax)this.Bgm.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void b(String paramString, ax paramax)
  {
    AppMethodBeat.i(28854);
    this.Bgm.put(paramString, paramax);
    AppMethodBeat.o(28854);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.Bgm.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ax)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.Bgm.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ax)localEntry.getValue()).getBaseDBFactories() != null) {
        localHashMap.putAll(((ax)localEntry.getValue()).getBaseDBFactories());
      }
    }
    AppMethodBeat.o(28848);
    return localHashMap;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28850);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.Bgm.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ax)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.Bgn == null) {
      this.Bgn = new a();
    }
    if (this.Bgo == null) {
      this.Bgo = new com.tencent.mm.plugin.subapp.e.a();
    }
    if (this.Bgp == null) {
      this.Bgp = new com.tencent.mm.plugin.subapp.e.c();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.Bgn);
    com.tencent.mm.sdk.b.a.IbL.c(this.Bgp);
    com.tencent.mm.sdk.b.a.IbL.c(this.Bgo);
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.Bgm.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ax)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.Bgn != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Bgn);
    }
    if (this.Bgo != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Bgo);
    }
    if (this.Bgp != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Bgp);
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.Bgm.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ax)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(28851);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<gb>
    implements f
  {
    private gb BgA;
    private int BgB;
    private Map<String, String> BgC;
    private int BgD;
    private boolean BgE;
    private long BgF;
    private long BgG;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.a Bgs;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c Bgt;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.b Bgu;
    private r Bgv;
    private int Bgw;
    private volatile boolean Bgx;
    boolean Bgy;
    private av Bgz;
    private int drS;
    private int drT;
    private String dyU;
    private boolean gvn;
    private boolean kbb;
    private String toUser;
    
    public a()
    {
      AppMethodBeat.i(28838);
      this.Bgx = false;
      this.Bgy = false;
      this.BgE = true;
      this.BgF = 0L;
      this.gvn = false;
      this.BgC = new HashMap();
      this.__eventId = gb.class.getName().hashCode();
      AppMethodBeat.o(28838);
    }
    
    private void a(String paramString, a parama)
    {
      AppMethodBeat.i(28842);
      ad.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
      if (this.Bgz != null) {
        this.Bgz.stopTimer();
      }
      ba.aiU().b(546, this);
      ba.aiU().b(547, this);
      ba.aiU().b(548, this);
      if (this.BgA != null)
      {
        if (bt.isNullOrNil(paramString)) {
          break label289;
        }
        this.BgC.put(this.BgA.drF.fileName, paramString);
        if (((a.Bgl == null) || (bt.isNullOrNil(a.Bgl.field_content))) && (this.BgA.drF.from == 1)) {
          o.aNz().a(aCv(paramString));
        }
        this.BgA.drG.bsb = true;
        this.BgA.drG.content = paramString;
        if (parama != a.BgP) {
          break label334;
        }
      }
      for (this.BgA.drG.state = 1;; this.BgA.drG.state = 2) {
        label289:
        label334:
        do
        {
          ad.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
          if (this.BgA.drF.drJ != null) {
            this.BgA.drF.drJ.run();
          }
          b(paramString, parama);
          this.Bgs = null;
          this.Bgt = null;
          this.Bgu = null;
          this.BgA = null;
          this.kbb = false;
          this.Bgy = false;
          this.Bgx = false;
          this.BgB = 20;
          a.Bgl = null;
          emD();
          AppMethodBeat.o(28842);
          return;
          if (parama != a.BgN) {
            break;
          }
          ad.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.BgA.drF.drH });
          this.BgA.drG.state = 2;
          break;
        } while ((parama != a.BgR) && (parama != a.BgS));
      }
    }
    
    /* Error */
    private boolean a(gb paramgb)
    {
      // Byte code:
      //   0: sipush 28839
      //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: instanceof 74
      //   10: ifne +18 -> 28
      //   13: ldc 96
      //   15: ldc 243
      //   17: invokestatic 247	com/tencent/mm/sdk/platformtools/ad:f	(Ljava/lang/String;Ljava/lang/String;)V
      //   20: sipush 28839
      //   23: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_1
      //   29: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   32: getfield 250	com/tencent/mm/g/a/gb$a:drI	I
      //   35: iconst_2
      //   36: if_icmpne +35 -> 71
      //   39: aload_0
      //   40: getstatic 190	com/tencent/mm/plugin/subapp/a$a$a:BgP	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   43: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   46: aload_0
      //   47: getfield 72	com/tencent/mm/plugin/subapp/a$a:BgC	Ljava/util/Map;
      //   50: invokeinterface 256 1 0
      //   55: ldc 96
      //   57: ldc_w 258
      //   60: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   63: sipush 28839
      //   66: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: iconst_1
      //   70: ireturn
      //   71: aload_1
      //   72: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   75: getfield 250	com/tencent/mm/g/a/gb$a:drI	I
      //   78: iconst_1
      //   79: if_icmpne +26 -> 105
      //   82: aload_0
      //   83: getstatic 190	com/tencent/mm/plugin/subapp/a$a$a:BgP	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   86: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   89: ldc 96
      //   91: ldc_w 262
      //   94: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   97: sipush 28839
      //   100: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   103: iconst_1
      //   104: ireturn
      //   105: aload_1
      //   106: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   109: getfield 250	com/tencent/mm/g/a/gb$a:drI	I
      //   112: iconst_3
      //   113: if_icmpne +26 -> 139
      //   116: aload_0
      //   117: getstatic 265	com/tencent/mm/plugin/subapp/a$a$a:BgQ	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   120: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   123: ldc 96
      //   125: ldc_w 267
      //   128: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   131: sipush 28839
      //   134: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   137: iconst_1
      //   138: ireturn
      //   139: aload_1
      //   140: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   143: getfield 250	com/tencent/mm/g/a/gb$a:drI	I
      //   146: ifeq +39 -> 185
      //   149: ldc 96
      //   151: ldc_w 269
      //   154: iconst_1
      //   155: anewarray 100	java/lang/Object
      //   158: dup
      //   159: iconst_0
      //   160: aload_0
      //   161: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   164: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   167: getfield 250	com/tencent/mm/g/a/gb$a:drI	I
      //   170: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   173: aastore
      //   174: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: sipush 28839
      //   180: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   183: iconst_0
      //   184: ireturn
      //   185: aload_0
      //   186: getfield 217	com/tencent/mm/plugin/subapp/a$a:kbb	Z
      //   189: ifeq +19 -> 208
      //   192: ldc 96
      //   194: ldc_w 277
      //   197: invokestatic 280	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   200: sipush 28839
      //   203: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: iconst_0
      //   207: ireturn
      //   208: invokestatic 284	com/tencent/mm/modelvoice/o:aNy	()Lcom/tencent/mm/modelvoice/w;
      //   211: ifnonnull +35 -> 246
      //   214: ldc 96
      //   216: new 286	java/lang/StringBuilder
      //   219: dup
      //   220: ldc_w 288
      //   223: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   226: invokestatic 295	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
      //   229: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   232: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   235: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   238: sipush 28839
      //   241: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   244: iconst_0
      //   245: ireturn
      //   246: aload_0
      //   247: aload_1
      //   248: putfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   251: aload_0
      //   252: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   255: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   258: getfield 230	com/tencent/mm/g/a/gb$a:drH	Ljava/lang/String;
      //   261: astore_3
      //   262: aload_0
      //   263: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   266: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   269: getfield 141	com/tencent/mm/g/a/gb$a:fileName	Ljava/lang/String;
      //   272: astore 4
      //   274: aload_3
      //   275: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   278: ifne +11 -> 289
      //   281: aload 4
      //   283: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   286: ifeq +39 -> 325
      //   289: ldc 96
      //   291: ldc_w 307
      //   294: iconst_2
      //   295: anewarray 100	java/lang/Object
      //   298: dup
      //   299: iconst_0
      //   300: aload_3
      //   301: aastore
      //   302: dup
      //   303: iconst_1
      //   304: aload 4
      //   306: aastore
      //   307: invokestatic 309	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   310: aload_0
      //   311: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:BgR	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   314: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   317: sipush 28839
      //   320: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   323: iconst_0
      //   324: ireturn
      //   325: aload_0
      //   326: invokespecial 222	com/tencent/mm/plugin/subapp/a$a:emD	()V
      //   329: aload_0
      //   330: getfield 72	com/tencent/mm/plugin/subapp/a$a:BgC	Ljava/util/Map;
      //   333: aload 4
      //   335: invokeinterface 313 2 0
      //   340: checkcast 82	java/lang/String
      //   343: astore 5
      //   345: aload 5
      //   347: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   350: ifne +41 -> 391
      //   353: ldc 96
      //   355: ldc_w 315
      //   358: iconst_2
      //   359: anewarray 100	java/lang/Object
      //   362: dup
      //   363: iconst_0
      //   364: aload_3
      //   365: aastore
      //   366: dup
      //   367: iconst_1
      //   368: aload 4
      //   370: aastore
      //   371: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   374: aload_0
      //   375: aload 5
      //   377: getstatic 225	com/tencent/mm/plugin/subapp/a$a$a:BgN	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   380: invokespecial 317	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   383: sipush 28839
      //   386: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   389: iconst_1
      //   390: ireturn
      //   391: invokestatic 165	com/tencent/mm/modelvoice/o:aNz	()Lcom/tencent/mm/storage/cn;
      //   394: aload 4
      //   396: invokevirtual 320	com/tencent/mm/storage/cn:aUA	(Ljava/lang/String;)Lcom/tencent/mm/storage/cm;
      //   399: astore 5
      //   401: aload 5
      //   403: putstatic 151	com/tencent/mm/plugin/subapp/a:Bgl	Lcom/tencent/mm/storage/cm;
      //   406: aload 5
      //   408: ifnull +57 -> 465
      //   411: getstatic 151	com/tencent/mm/plugin/subapp/a:Bgl	Lcom/tencent/mm/storage/cm;
      //   414: getfield 156	com/tencent/mm/storage/cm:field_content	Ljava/lang/String;
      //   417: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   420: ifne +45 -> 465
      //   423: ldc 96
      //   425: ldc_w 322
      //   428: iconst_2
      //   429: anewarray 100	java/lang/Object
      //   432: dup
      //   433: iconst_0
      //   434: aload_3
      //   435: aastore
      //   436: dup
      //   437: iconst_1
      //   438: aload 4
      //   440: aastore
      //   441: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   444: aload_0
      //   445: getstatic 151	com/tencent/mm/plugin/subapp/a:Bgl	Lcom/tencent/mm/storage/cm;
      //   448: getfield 156	com/tencent/mm/storage/cm:field_content	Ljava/lang/String;
      //   451: getstatic 225	com/tencent/mm/plugin/subapp/a$a$a:BgN	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   454: invokespecial 317	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   457: sipush 28839
      //   460: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   463: iconst_1
      //   464: ireturn
      //   465: ldc 96
      //   467: ldc_w 324
      //   470: iconst_1
      //   471: anewarray 100	java/lang/Object
      //   474: dup
      //   475: iconst_0
      //   476: aload_1
      //   477: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   480: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   483: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   486: aastore
      //   487: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   490: aload_0
      //   491: invokestatic 284	com/tencent/mm/modelvoice/o:aNy	()Lcom/tencent/mm/modelvoice/w;
      //   494: aload 4
      //   496: invokevirtual 333	com/tencent/mm/modelvoice/w:Id	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
      //   499: putfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   502: aload_0
      //   503: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   506: ifnonnull +142 -> 648
      //   509: ldc 96
      //   511: ldc_w 337
      //   514: iconst_2
      //   515: anewarray 100	java/lang/Object
      //   518: dup
      //   519: iconst_0
      //   520: aload_3
      //   521: aastore
      //   522: dup
      //   523: iconst_1
      //   524: aload 4
      //   526: aastore
      //   527: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   530: aload_0
      //   531: new 339	com/tencent/mm/modelvoice/r
      //   534: dup
      //   535: invokespecial 340	com/tencent/mm/modelvoice/r:<init>	()V
      //   538: putfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   541: aload_0
      //   542: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   545: aload 4
      //   547: putfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   550: aload_0
      //   551: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   554: invokestatic 347	java/lang/System:currentTimeMillis	()J
      //   557: ldc2_w 348
      //   560: ldiv
      //   561: putfield 352	com/tencent/mm/modelvoice/r:createTime	J
      //   564: aload_0
      //   565: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   568: aload 4
      //   570: putfield 355	com/tencent/mm/modelvoice/r:clientId	Ljava/lang/String;
      //   573: aload_0
      //   574: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   577: invokestatic 347	java/lang/System:currentTimeMillis	()J
      //   580: ldc2_w 348
      //   583: ldiv
      //   584: putfield 358	com/tencent/mm/modelvoice/r:iud	J
      //   587: aload_0
      //   588: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   591: iconst_1
      //   592: putfield 361	com/tencent/mm/modelvoice/r:status	I
      //   595: aload_1
      //   596: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   599: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   602: bipush 8
      //   604: if_icmpne +196 -> 800
      //   607: aload_0
      //   608: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   611: iconst_m1
      //   612: putfield 364	com/tencent/mm/modelvoice/r:iuf	I
      //   615: aload 4
      //   617: invokestatic 370	com/tencent/mm/modelvoice/q:Hj	(Ljava/lang/String;)I
      //   620: istore_2
      //   621: ldc 96
      //   623: ldc_w 372
      //   626: iconst_1
      //   627: anewarray 100	java/lang/Object
      //   630: dup
      //   631: iconst_0
      //   632: iload_2
      //   633: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   636: aastore
      //   637: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   640: aload_0
      //   641: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   644: iload_2
      //   645: putfield 375	com/tencent/mm/modelvoice/r:hMP	I
      //   648: aload_0
      //   649: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   652: getfield 364	com/tencent/mm/modelvoice/r:iuf	I
      //   655: ifge +191 -> 846
      //   658: ldc 96
      //   660: ldc_w 377
      //   663: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   666: aload_0
      //   667: aload_0
      //   668: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   671: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   674: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   677: putfield 379	com/tencent/mm/plugin/subapp/a$a:BgD	I
      //   680: ldc 96
      //   682: ldc_w 381
      //   685: iconst_3
      //   686: anewarray 100	java/lang/Object
      //   689: dup
      //   690: iconst_0
      //   691: aload_0
      //   692: getfield 383	com/tencent/mm/plugin/subapp/a$a:dyU	Ljava/lang/String;
      //   695: aastore
      //   696: dup
      //   697: iconst_1
      //   698: aload_0
      //   699: getfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   702: aastore
      //   703: dup
      //   704: iconst_2
      //   705: aload_0
      //   706: getfield 379	com/tencent/mm/plugin/subapp/a$a:BgD	I
      //   709: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   712: aastore
      //   713: invokestatic 198	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   716: aconst_null
      //   717: astore_3
      //   718: aconst_null
      //   719: astore_1
      //   720: aload_0
      //   721: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   724: getfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   727: invokestatic 391	com/tencent/mm/modelvoice/s:HR	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
      //   730: astore 4
      //   732: aload 4
      //   734: ifnull +335 -> 1069
      //   737: aload 4
      //   739: astore_1
      //   740: aload 4
      //   742: astore_3
      //   743: aload 4
      //   745: invokeinterface 396 1 0
      //   750: istore_2
      //   751: aload 4
      //   753: astore_1
      //   754: aload 4
      //   756: astore_3
      //   757: aload_0
      //   758: iload_2
      //   759: putfield 398	com/tencent/mm/plugin/subapp/a$a:Bgw	I
      //   762: aload 4
      //   764: ifnull +10 -> 774
      //   767: aload 4
      //   769: invokeinterface 401 1 0
      //   774: aload_0
      //   775: iconst_1
      //   776: putfield 217	com/tencent/mm/plugin/subapp/a$a:kbb	Z
      //   779: aload_0
      //   780: bipush 20
      //   782: putfield 219	com/tencent/mm/plugin/subapp/a$a:BgB	I
      //   785: aload_0
      //   786: getstatic 404	com/tencent/mm/plugin/subapp/a$a$a:BgJ	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   789: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   792: sipush 28839
      //   795: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   798: iconst_1
      //   799: ireturn
      //   800: aload_0
      //   801: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   804: aload_3
      //   805: invokestatic 407	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   808: invokevirtual 410	java/lang/Integer:intValue	()I
      //   811: putfield 364	com/tencent/mm/modelvoice/r:iuf	I
      //   814: goto -199 -> 615
      //   817: astore_1
      //   818: ldc 96
      //   820: aload_1
      //   821: ldc_w 412
      //   824: iconst_0
      //   825: anewarray 100	java/lang/Object
      //   828: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   831: aload_0
      //   832: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:BgR	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   835: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   838: sipush 28839
      //   841: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   844: iconst_1
      //   845: ireturn
      //   846: ldc_w 418
      //   849: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   852: checkcast 418	com/tencent/mm/plugin/messenger/foundation/a/l
      //   855: invokeinterface 428 1 0
      //   860: aload_0
      //   861: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   864: getfield 364	com/tencent/mm/modelvoice/r:iuf	I
      //   867: i2l
      //   868: invokeinterface 434 3 0
      //   873: astore_1
      //   874: aload_1
      //   875: getfield 439	com/tencent/mm/g/c/ei:field_isSend	I
      //   878: iconst_1
      //   879: if_icmpne +93 -> 972
      //   882: aload_0
      //   883: invokestatic 444	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
      //   886: putfield 383	com/tencent/mm/plugin/subapp/a$a:dyU	Ljava/lang/String;
      //   889: aload_0
      //   890: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   893: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   896: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   899: iconst_4
      //   900: if_icmpeq +17 -> 917
      //   903: aload_0
      //   904: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   907: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   910: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   913: iconst_5
      //   914: if_icmpne +47 -> 961
      //   917: ldc_w 446
      //   920: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   923: checkcast 446	com/tencent/mm/api/j
      //   926: aload_1
      //   927: getfield 449	com/tencent/mm/g/c/ei:field_bizChatId	J
      //   930: invokeinterface 453 3 0
      //   935: astore_1
      //   936: aload_1
      //   937: ifnull +14 -> 951
      //   940: aload_0
      //   941: aload_1
      //   942: getfield 458	com/tencent/mm/am/a/c:field_bizChatServId	Ljava/lang/String;
      //   945: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   948: goto -282 -> 666
      //   951: aload_0
      //   952: ldc_w 460
      //   955: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   958: goto -292 -> 666
      //   961: aload_0
      //   962: aload_1
      //   963: getfield 463	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
      //   966: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   969: goto -303 -> 666
      //   972: aload_1
      //   973: getfield 439	com/tencent/mm/g/c/ei:field_isSend	I
      //   976: ifne -310 -> 666
      //   979: aload_0
      //   980: invokestatic 444	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
      //   983: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   986: aload_0
      //   987: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   990: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   993: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   996: iconst_4
      //   997: if_icmpeq +17 -> 1014
      //   1000: aload_0
      //   1001: getfield 126	com/tencent/mm/plugin/subapp/a$a:BgA	Lcom/tencent/mm/g/a/gb;
      //   1004: getfield 136	com/tencent/mm/g/a/gb:drF	Lcom/tencent/mm/g/a/gb$a;
      //   1007: getfield 327	com/tencent/mm/g/a/gb$a:scene	I
      //   1010: iconst_5
      //   1011: if_icmpne +47 -> 1058
      //   1014: ldc_w 446
      //   1017: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   1020: checkcast 446	com/tencent/mm/api/j
      //   1023: aload_1
      //   1024: getfield 449	com/tencent/mm/g/c/ei:field_bizChatId	J
      //   1027: invokeinterface 453 3 0
      //   1032: astore_1
      //   1033: aload_1
      //   1034: ifnull +14 -> 1048
      //   1037: aload_0
      //   1038: aload_1
      //   1039: getfield 458	com/tencent/mm/am/a/c:field_bizChatServId	Ljava/lang/String;
      //   1042: putfield 383	com/tencent/mm/plugin/subapp/a$a:dyU	Ljava/lang/String;
      //   1045: goto -379 -> 666
      //   1048: aload_0
      //   1049: ldc_w 460
      //   1052: putfield 383	com/tencent/mm/plugin/subapp/a$a:dyU	Ljava/lang/String;
      //   1055: goto -389 -> 666
      //   1058: aload_0
      //   1059: aload_1
      //   1060: getfield 463	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
      //   1063: putfield 383	com/tencent/mm/plugin/subapp/a$a:dyU	Ljava/lang/String;
      //   1066: goto -400 -> 666
      //   1069: iconst_m1
      //   1070: istore_2
      //   1071: goto -320 -> 751
      //   1074: astore 4
      //   1076: aload_1
      //   1077: astore_3
      //   1078: ldc 96
      //   1080: aload 4
      //   1082: ldc_w 465
      //   1085: iconst_1
      //   1086: anewarray 100	java/lang/Object
      //   1089: dup
      //   1090: iconst_0
      //   1091: aload_0
      //   1092: getfield 335	com/tencent/mm/plugin/subapp/a$a:Bgv	Lcom/tencent/mm/modelvoice/r;
      //   1095: getfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   1098: aastore
      //   1099: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1102: aload_1
      //   1103: astore_3
      //   1104: aload_0
      //   1105: iconst_m1
      //   1106: putfield 398	com/tencent/mm/plugin/subapp/a$a:Bgw	I
      //   1109: aload_1
      //   1110: ifnull -336 -> 774
      //   1113: aload_1
      //   1114: invokeinterface 401 1 0
      //   1119: goto -345 -> 774
      //   1122: astore_1
      //   1123: goto -349 -> 774
      //   1126: astore_1
      //   1127: aload_3
      //   1128: ifnull +9 -> 1137
      //   1131: aload_3
      //   1132: invokeinterface 401 1 0
      //   1137: sipush 28839
      //   1140: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1143: aload_1
      //   1144: athrow
      //   1145: astore_1
      //   1146: goto -372 -> 774
      //   1149: astore_3
      //   1150: goto -13 -> 1137
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1153	0	this	a
      //   0	1153	1	paramgb	gb
      //   620	451	2	i	int
      //   261	871	3	localObject1	Object
      //   1149	1	3	localThrowable1	java.lang.Throwable
      //   272	496	4	localObject2	Object
      //   1074	7	4	localThrowable2	java.lang.Throwable
      //   343	64	5	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   502	615	817	java/lang/Exception
      //   615	648	817	java/lang/Exception
      //   800	814	817	java/lang/Exception
      //   720	732	1074	java/lang/Throwable
      //   743	751	1074	java/lang/Throwable
      //   757	762	1074	java/lang/Throwable
      //   1113	1119	1122	java/lang/Throwable
      //   720	732	1126	finally
      //   743	751	1126	finally
      //   757	762	1126	finally
      //   1078	1102	1126	finally
      //   1104	1109	1126	finally
      //   767	774	1145	java/lang/Throwable
      //   1131	1137	1149	java/lang/Throwable
    }
    
    private cm aCv(String paramString)
    {
      AppMethodBeat.i(28844);
      ad.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.BgA.drF.drH, this.BgA.drF.fileName });
      cm localcm = new cm();
      localcm.field_msgId = Long.valueOf(this.BgA.drF.drH).longValue();
      localcm.aUz(this.BgA.drF.fileName);
      localcm.field_content = paramString;
      AppMethodBeat.o(28844);
      return localcm;
    }
    
    private void b(String paramString, a parama)
    {
      AppMethodBeat.i(28843);
      if (!this.gvn)
      {
        AppMethodBeat.o(28843);
        return;
      }
      if (this.Bgv == null)
      {
        AppMethodBeat.o(28843);
        return;
      }
      int i;
      int j;
      if (paramString != null)
      {
        i = paramString.length();
        if (parama != a.BgN) {
          break label173;
        }
        if (bt.isNullOrNil(paramString)) {
          break label155;
        }
        j = 1;
      }
      for (;;)
      {
        ad.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.Bgv.clientId, Integer.valueOf(i), Integer.valueOf(this.drS), Integer.valueOf(this.drT), Integer.valueOf(j) });
        if (j != 0) {
          com.tencent.mm.plugin.subapp.e.b.d(this.Bgv.clientId, i, this.drS, this.drT, j);
        }
        AppMethodBeat.o(28843);
        return;
        i = 0;
        break;
        label155:
        this.drS = 0;
        this.drT = 0;
        i = 0;
        j = 3;
        continue;
        label173:
        this.drS = 0;
        this.drT = 0;
        if (parama == a.BgP)
        {
          j = 5;
          i = 0;
        }
        else if (parama == a.BgS)
        {
          i = 0;
          j = 3;
        }
        else if (parama == a.BgR)
        {
          j = 4;
          i = 0;
        }
        else if (parama == a.BgT)
        {
          i = 0;
          j = 2;
        }
        else
        {
          i = 0;
          j = 0;
        }
      }
    }
    
    private void emD()
    {
      this.BgE = true;
      this.BgF = 0L;
      this.BgG = 0L;
      this.drS = 0;
      this.drT = 0;
      this.gvn = false;
    }
    
    private void emE()
    {
      AppMethodBeat.i(28841);
      if (this.BgE)
      {
        this.BgE = false;
        this.BgF = System.currentTimeMillis();
        this.drS = ((int)(this.BgF - this.BgG));
      }
      AppMethodBeat.o(28841);
    }
    
    final void a(a parama)
    {
      AppMethodBeat.i(28840);
      switch (a.2.Bgr[parama.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(28840);
        return;
        ad.i("MicroMsg.SubCoreSubapp", "net check");
        if (this.Bgv.dAY > 0L) {
          ad.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.Bgv.dAY) });
        }
        for (this.Bgs = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.Bgv.clientId, this.Bgv.hMP, this.Bgw, this.Bgv.dAY, this.Bgv.fileName, this.BgD, this.dyU, this.toUser);; this.Bgs = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.Bgv.clientId, this.Bgv.hMP, this.Bgv.fileName, this.BgD, this.dyU, this.toUser))
        {
          ba.aiU().a(this.Bgs, 0);
          ba.aiU().a(this.Bgs.getType(), this);
          this.BgG = System.currentTimeMillis();
          AppMethodBeat.o(28840);
          return;
          ad.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.Bgv.dAY) });
        }
        ad.i("MicroMsg.SubCoreSubapp", "net upload");
        if (this.Bgs == null)
        {
          ad.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.Bgt = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.Bgv.clientId, this.Bgs.Blx, this.Bgw, this.Bgv.fileName, this.BgD, this.dyU, this.toUser);
        ba.aiU().a(this.Bgt, 0);
        ba.aiU().a(this.Bgt.getType(), this);
        AppMethodBeat.o(28840);
        return;
        ad.i("MicroMsg.SubCoreSubapp", "net upload more");
        if (this.Bgt == null)
        {
          ad.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
          AppMethodBeat.o(28840);
          return;
        }
        this.Bgt = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.Bgt);
        ba.aiU().a(this.Bgt, 0);
        ba.aiU().a(this.Bgt.getType(), this);
        AppMethodBeat.o(28840);
        return;
        if (this.Bgx)
        {
          ad.i("MicroMsg.SubCoreSubapp", "pulling so pass");
          AppMethodBeat.o(28840);
          return;
        }
        ad.i("MicroMsg.SubCoreSubapp", "net get");
        if (this.Bgs == null)
        {
          ad.w("MicroMsg.SubCoreSubapp", "request get must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.Bgx = true;
        this.Bgu = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.Bgv.clientId);
        ba.aiU().a(this.Bgu, 0);
        ba.aiU().a(this.Bgu.getType(), this);
        AppMethodBeat.o(28840);
        return;
        this.Bgy = true;
        AppMethodBeat.o(28840);
        return;
        ba.aiU().a(this.Bgs);
        ba.aiU().a(this.Bgt);
        ba.aiU().a(this.Bgu);
        this.gvn = true;
        a(null, a.BgP);
        AppMethodBeat.o(28840);
        return;
        this.gvn = true;
        a(null, parama);
        AppMethodBeat.o(28840);
        return;
        this.gvn = true;
        a(null, parama);
      }
    }
    
    public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
    {
      paramString = null;
      Object localObject = null;
      AppMethodBeat.i(28845);
      ad.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      switch (paramn.getType())
      {
      default: 
        AppMethodBeat.o(28845);
        return;
      case 546: 
        if (this.Bgs.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.Blv)
        {
          ad.i("MicroMsg.SubCoreSubapp", "check result: done");
          a(a.BgN);
          emE();
          this.drT = 0;
          this.gvn = true;
          paramString = localObject;
          if (this.Bgs.eno()) {
            paramString = this.Bgs.Blw.HIY;
          }
          a(paramString, a.BgN);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Bgs.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.Blu)
        {
          if (this.Bgs.Blw != null) {
            bt.isNullOrNil(this.Bgs.Blw.HIY);
          }
          ad.i("MicroMsg.SubCoreSubapp", "check result: processing");
          a(a.BgM);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Bgs.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.Blt)
        {
          ad.i("MicroMsg.SubCoreSubapp", "check result: not exist");
          a(a.BgK);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Bgs.Bly != null)
        {
          AppMethodBeat.o(28845);
          return;
        }
        break;
      case 547: 
        if (this.Bgt.enq())
        {
          ad.i("MicroMsg.SubCoreSubapp", "succeed upload");
          a(a.BgM);
          AppMethodBeat.o(28845);
          return;
        }
        ad.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.Bgt.Blx.xcL), Integer.valueOf(this.Bgt.Blx.xcM) });
        a(a.BgL);
        AppMethodBeat.o(28845);
        return;
      case 548: 
        paramInt1 = this.Bgu.BlA;
        ad.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
        this.Bgx = false;
        emE();
        if ((!this.Bgu.isComplete()) && (this.Bgu.eno()))
        {
          ad.i("MicroMsg.SubCoreSubapp", "refreshResult result");
          paramn = this.Bgu.Blw.HIY;
          if (this.BgA != null)
          {
            this.BgA.drG.bsb = false;
            this.BgA.drG.content = paramn;
            ad.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramn)) });
            if (this.BgA.drF.drJ != null) {
              this.BgA.drF.drJ.run();
            }
          }
        }
        while (this.Bgu.isComplete())
        {
          ad.i("MicroMsg.SubCoreSubapp", "succeed get");
          if (this.Bgu.eno()) {
            paramString = this.Bgu.Blw.HIY;
          }
          a(a.BgN);
          this.drT = ((int)(System.currentTimeMillis() - this.BgF));
          this.gvn = true;
          a(paramString, a.BgN);
          AppMethodBeat.o(28845);
          return;
          if (!this.Bgu.eno()) {
            ad.d("MicroMsg.SubCoreSubapp", "result not valid");
          }
        }
        ad.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
        if (!this.Bgy)
        {
          paramInt2 = this.BgB - 1;
          this.BgB = paramInt2;
          if (paramInt2 < 0)
          {
            ad.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
            a(a.BgS);
            AppMethodBeat.o(28845);
            return;
          }
          if (this.Bgz == null) {
            this.Bgz = new av(new av.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(28834);
                if (a.a.this.Bgy)
                {
                  AppMethodBeat.o(28834);
                  return false;
                }
                ad.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
                a.a.this.a(a.a.a.BgM);
                AppMethodBeat.o(28834);
                return false;
              }
            }, false);
          }
          paramString = this.Bgz;
          long l = paramInt1 * 1000;
          paramString.az(l, l);
        }
        AppMethodBeat.o(28845);
        return;
        if (paramInt1 == 2)
        {
          a(a.BgT);
          AppMethodBeat.o(28845);
          return;
        }
        a(a.BgS);
      }
      AppMethodBeat.o(28845);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(28837);
        BgJ = new a("CHECK", 0);
        BgK = new a("UPLOAD", 1);
        BgL = new a("UPLOAD_MORE", 2);
        BgM = new a("GET", 3);
        BgN = new a("FINISH", 4);
        BgO = new a("ERROR", 5);
        BgP = new a("CANCEL", 6);
        BgQ = new a("CANCEL_BY_USER", 7);
        BgR = new a("LOCAL_ERROR", 8);
        BgS = new a("SERVER_ERROR", 9);
        BgT = new a("NETWORK_OVERTIME", 10);
        BgU = new a[] { BgJ, BgK, BgL, BgM, BgN, BgO, BgP, BgQ, BgR, BgS, BgT };
        AppMethodBeat.o(28837);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */