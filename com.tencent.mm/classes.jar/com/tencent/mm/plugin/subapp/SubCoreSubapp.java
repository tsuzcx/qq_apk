package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.gx;
import com.tencent.mm.autogen.a.gx.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.subapp.transformtext.VoiceTransformTextClickEventListener;
import com.tencent.mm.plugin.subapp.transformtext.VoiceTransformTextResultEventListener;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.pluginsdk.platformtools.d.a;
import com.tencent.mm.protocal.protobuf.fuf;
import com.tencent.mm.protocal.protobuf.fzj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cy;
import com.tencent.mm.storage.cz;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SubCoreSubapp
  implements be
{
  private static cy SDI;
  private Map<String, be> SDJ;
  private ExtTranslateVoiceEventListener SDK;
  private VoiceTransformTextClickEventListener SDL;
  private VoiceTransformTextResultEventListener SDM;
  private q.a appForegroundListener;
  
  public SubCoreSubapp()
  {
    AppMethodBeat.i(28847);
    this.SDJ = new HashMap();
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
          com.tencent.mm.plugin.subapp.jdbiz.d.hAP();
        }
        AppMethodBeat.o(28832);
      }
    };
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.as.d.class.getName(), new com.tencent.mm.as.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.modelvoiceremind.d();
    com.tencent.mm.model.az.a.okS = (az.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.modelvoiceremind.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    com.tencent.mm.pluginsdk.platformtools.d.XUQ = (d.a)localObject;
    this.SDJ = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final void b(String paramString, be parambe)
  {
    AppMethodBeat.i(28854);
    this.SDJ.put(paramString, parambe);
    AppMethodBeat.o(28854);
  }
  
  public final be bcy(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (be)this.SDJ.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.SDJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.SDJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((be)localEntry.getValue()).getBaseDBFactories() != null) {
        localHashMap.putAll(((be)localEntry.getValue()).getBaseDBFactories());
      }
    }
    AppMethodBeat.o(28848);
    return localHashMap;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28850);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.SDJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.SDK == null) {
      this.SDK = new ExtTranslateVoiceEventListener();
    }
    if (this.SDL == null) {
      this.SDL = new VoiceTransformTextClickEventListener();
    }
    if (this.SDM == null) {
      this.SDM = new VoiceTransformTextResultEventListener();
    }
    this.SDK.alive();
    this.SDM.alive();
    this.SDL.alive();
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.SDJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.SDK != null) {
      this.SDK.dead();
    }
    if (this.SDL != null) {
      this.SDL.dead();
    }
    if (this.SDM != null) {
      this.SDM.dead();
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.SDJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(28851);
  }
  
  public static class ExtTranslateVoiceEventListener
    extends IListener<gx>
    implements h
  {
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.a SDP;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c SDQ;
    private b SDR;
    private r SDS;
    private int SDT;
    private volatile boolean SDU;
    private boolean SDV;
    private MTimerHandler SDW;
    private gx SDX;
    private int SDY;
    private Map<String, String> SDZ;
    private int SEa;
    private boolean SEb;
    private long SEc;
    private long SEd;
    private int hHM;
    private int hHN;
    private String hQQ;
    private boolean mwk;
    private boolean rdA;
    private String toUser;
    
    public ExtTranslateVoiceEventListener()
    {
      super();
      AppMethodBeat.i(28838);
      this.SDU = false;
      this.SDV = false;
      this.SEb = true;
      this.SEc = 0L;
      this.mwk = false;
      this.SDZ = new HashMap();
      this.__eventId = gx.class.getName().hashCode();
      AppMethodBeat.o(28838);
    }
    
    private void a(a parama)
    {
      AppMethodBeat.i(28840);
      switch (SubCoreSubapp.2.SDO[parama.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(28840);
        return;
        Log.i("MicroMsg.SubCoreSubapp", "net check");
        if (this.SDS.hTh > 0L) {
          Log.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.SDS.hTh) });
        }
        for (this.SDP = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.SDS.clientId, this.SDS.osy, this.SDT, this.SDS.hTh, this.SDS.fileName, this.SEa, this.hQQ, this.toUser);; this.SDP = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.SDS.clientId, this.SDS.osy, this.SDS.fileName, this.SEa, this.hQQ, this.toUser))
        {
          bh.aZW().a(this.SDP, 0);
          bh.aZW().a(this.SDP.getType(), this);
          this.SEd = System.currentTimeMillis();
          AppMethodBeat.o(28840);
          return;
          Log.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.SDS.hTh) });
        }
        Log.i("MicroMsg.SubCoreSubapp", "net upload");
        if (this.SDP == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.SDQ = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.SDS.clientId, this.SDP.SJg, this.SDT, this.SDS.fileName, this.SEa, this.hQQ, this.toUser);
        bh.aZW().a(this.SDQ, 0);
        bh.aZW().a(this.SDQ.getType(), this);
        AppMethodBeat.o(28840);
        return;
        Log.i("MicroMsg.SubCoreSubapp", "net upload more");
        if (this.SDQ == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
          AppMethodBeat.o(28840);
          return;
        }
        this.SDQ = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.SDQ);
        bh.aZW().a(this.SDQ, 0);
        bh.aZW().a(this.SDQ.getType(), this);
        AppMethodBeat.o(28840);
        return;
        if (this.SDU)
        {
          Log.i("MicroMsg.SubCoreSubapp", "pulling so pass");
          AppMethodBeat.o(28840);
          return;
        }
        Log.i("MicroMsg.SubCoreSubapp", "net get");
        if (this.SDP == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "request get must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.SDU = true;
        this.SDR = new b(this.SDS.clientId);
        bh.aZW().a(this.SDR, 0);
        bh.aZW().a(this.SDR.getType(), this);
        AppMethodBeat.o(28840);
        return;
        this.SDV = true;
        AppMethodBeat.o(28840);
        return;
        bh.aZW().a(this.SDP);
        bh.aZW().a(this.SDQ);
        bh.aZW().a(this.SDR);
        this.mwk = true;
        a(null, a.SEm);
        AppMethodBeat.o(28840);
        return;
        this.mwk = true;
        a(null, parama);
        AppMethodBeat.o(28840);
        return;
        this.mwk = true;
        a(null, parama);
      }
    }
    
    private void a(String paramString, a parama)
    {
      AppMethodBeat.i(28842);
      Log.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
      if (this.SDW != null) {
        this.SDW.stopTimer();
      }
      bh.aZW().b(546, this);
      bh.aZW().b(547, this);
      bh.aZW().b(548, this);
      if (this.SDX != null)
      {
        if (Util.isNullOrNil(paramString)) {
          break label291;
        }
        this.SDZ.put(this.SDX.hHz.fileName, paramString);
        if (((SubCoreSubapp.hAC() == null) || (Util.isNullOrNil(SubCoreSubapp.hAC().field_content))) && (this.SDX.hHz.from == 1)) {
          o.bPg().b(bcz(paramString));
        }
        this.SDX.hHA.cVt = true;
        this.SDX.hHA.content = paramString;
        if (parama != a.SEm) {
          break label337;
        }
      }
      for (this.SDX.hHA.state = 1;; this.SDX.hHA.state = 2) {
        label291:
        label337:
        do
        {
          Log.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
          if (this.SDX.hHz.hHD != null) {
            this.SDX.hHz.hHD.run();
          }
          b(paramString, parama);
          this.SDP = null;
          this.SDQ = null;
          this.SDR = null;
          this.SDX = null;
          this.rdA = false;
          this.SDV = false;
          this.SDU = false;
          this.SDY = 20;
          SubCoreSubapp.a(null);
          hAD();
          AppMethodBeat.o(28842);
          return;
          if (parama != a.SEk) {
            break;
          }
          Log.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.SDX.hHz.hHB });
          this.SDX.hHA.state = 2;
          break;
        } while ((parama != a.SEo) && (parama != a.SEp));
      }
    }
    
    /* Error */
    private boolean a(gx paramgx)
    {
      // Byte code:
      //   0: sipush 28839
      //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: instanceof 83
      //   10: ifne +19 -> 29
      //   13: ldc 114
      //   15: ldc_w 369
      //   18: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
      //   21: sipush 28839
      //   24: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: iconst_0
      //   28: ireturn
      //   29: aload_1
      //   30: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   33: getfield 375	com/tencent/mm/autogen/a/gx$a:hHC	I
      //   36: iconst_2
      //   37: if_icmpne +35 -> 72
      //   40: aload_0
      //   41: getstatic 242	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEm	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   44: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   47: aload_0
      //   48: getfield 81	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDZ	Ljava/util/Map;
      //   51: invokeinterface 378 1 0
      //   56: ldc 114
      //   58: ldc_w 380
      //   61: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   64: sipush 28839
      //   67: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: iconst_1
      //   71: ireturn
      //   72: aload_1
      //   73: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   76: getfield 375	com/tencent/mm/autogen/a/gx$a:hHC	I
      //   79: iconst_1
      //   80: if_icmpne +26 -> 106
      //   83: aload_0
      //   84: getstatic 242	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEm	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   87: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   90: ldc 114
      //   92: ldc_w 382
      //   95: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: sipush 28839
      //   101: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: iconst_1
      //   105: ireturn
      //   106: aload_1
      //   107: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   110: getfield 375	com/tencent/mm/autogen/a/gx$a:hHC	I
      //   113: iconst_3
      //   114: if_icmpne +26 -> 140
      //   117: aload_0
      //   118: getstatic 385	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEn	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   121: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   124: ldc 114
      //   126: ldc_w 387
      //   129: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   132: sipush 28839
      //   135: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: iconst_1
      //   139: ireturn
      //   140: aload_1
      //   141: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   144: getfield 375	com/tencent/mm/autogen/a/gx$a:hHC	I
      //   147: ifeq +39 -> 186
      //   150: ldc 114
      //   152: ldc_w 389
      //   155: iconst_1
      //   156: anewarray 132	java/lang/Object
      //   159: dup
      //   160: iconst_0
      //   161: aload_0
      //   162: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   165: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   168: getfield 375	com/tencent/mm/autogen/a/gx$a:hHC	I
      //   171: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   174: aastore
      //   175: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   178: sipush 28839
      //   181: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: iconst_0
      //   185: ireturn
      //   186: aload_0
      //   187: getfield 342	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:rdA	Z
      //   190: ifeq +19 -> 209
      //   193: ldc 114
      //   195: ldc_w 396
      //   198: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   201: sipush 28839
      //   204: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: iconst_0
      //   208: ireturn
      //   209: invokestatic 400	com/tencent/mm/modelvoice/o:bPf	()Lcom/tencent/mm/modelvoice/w;
      //   212: ifnonnull +35 -> 247
      //   215: ldc 114
      //   217: new 402	java/lang/StringBuilder
      //   220: dup
      //   221: ldc_w 404
      //   224: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   227: invokestatic 409	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
      //   230: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   233: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   236: invokestatic 419	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   239: sipush 28839
      //   242: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: iconst_0
      //   246: ireturn
      //   247: aload_0
      //   248: aload_1
      //   249: putfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   252: aload_0
      //   253: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   256: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   259: getfield 358	com/tencent/mm/autogen/a/gx$a:hHB	Ljava/lang/String;
      //   262: astore_3
      //   263: aload_0
      //   264: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   267: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   270: getfield 276	com/tencent/mm/autogen/a/gx$a:fileName	Ljava/lang/String;
      //   273: astore 4
      //   275: aload_3
      //   276: invokestatic 269	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   279: ifne +11 -> 290
      //   282: aload 4
      //   284: invokestatic 269	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   287: ifeq +39 -> 326
      //   290: ldc 114
      //   292: ldc_w 421
      //   295: iconst_2
      //   296: anewarray 132	java/lang/Object
      //   299: dup
      //   300: iconst_0
      //   301: aload_3
      //   302: aastore
      //   303: dup
      //   304: iconst_1
      //   305: aload 4
      //   307: aastore
      //   308: invokestatic 423	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   311: aload_0
      //   312: getstatic 361	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEo	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   315: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   318: sipush 28839
      //   321: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   324: iconst_0
      //   325: ireturn
      //   326: aload_0
      //   327: invokespecial 350	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hAD	()V
      //   330: aload_0
      //   331: getfield 81	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDZ	Ljava/util/Map;
      //   334: aload 4
      //   336: invokeinterface 427 2 0
      //   341: checkcast 91	java/lang/String
      //   344: astore 5
      //   346: aload 5
      //   348: invokestatic 269	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   351: ifne +41 -> 392
      //   354: ldc 114
      //   356: ldc_w 429
      //   359: iconst_2
      //   360: anewarray 132	java/lang/Object
      //   363: dup
      //   364: iconst_0
      //   365: aload_3
      //   366: aastore
      //   367: dup
      //   368: iconst_1
      //   369: aload 4
      //   371: aastore
      //   372: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   375: aload_0
      //   376: aload 5
      //   378: getstatic 353	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEk	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   381: invokespecial 245	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   384: sipush 28839
      //   387: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   390: iconst_1
      //   391: ireturn
      //   392: invokestatic 300	com/tencent/mm/modelvoice/o:bPg	()Lcom/tencent/mm/storage/cz;
      //   395: aload 4
      //   397: invokevirtual 432	com/tencent/mm/storage/cz:byR	(Ljava/lang/String;)Lcom/tencent/mm/storage/cy;
      //   400: invokestatic 347	com/tencent/mm/plugin/subapp/SubCoreSubapp:a	(Lcom/tencent/mm/storage/cy;)Lcom/tencent/mm/storage/cy;
      //   403: pop
      //   404: invokestatic 286	com/tencent/mm/plugin/subapp/SubCoreSubapp:hAC	()Lcom/tencent/mm/storage/cy;
      //   407: ifnull +57 -> 464
      //   410: invokestatic 286	com/tencent/mm/plugin/subapp/SubCoreSubapp:hAC	()Lcom/tencent/mm/storage/cy;
      //   413: getfield 291	com/tencent/mm/storage/cy:field_content	Ljava/lang/String;
      //   416: invokestatic 269	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   419: ifne +45 -> 464
      //   422: ldc 114
      //   424: ldc_w 434
      //   427: iconst_2
      //   428: anewarray 132	java/lang/Object
      //   431: dup
      //   432: iconst_0
      //   433: aload_3
      //   434: aastore
      //   435: dup
      //   436: iconst_1
      //   437: aload 4
      //   439: aastore
      //   440: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   443: aload_0
      //   444: invokestatic 286	com/tencent/mm/plugin/subapp/SubCoreSubapp:hAC	()Lcom/tencent/mm/storage/cy;
      //   447: getfield 291	com/tencent/mm/storage/cy:field_content	Ljava/lang/String;
      //   450: getstatic 353	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEk	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   453: invokespecial 245	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   456: sipush 28839
      //   459: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   462: iconst_1
      //   463: ireturn
      //   464: ldc 114
      //   466: ldc_w 436
      //   469: iconst_1
      //   470: anewarray 132	java/lang/Object
      //   473: dup
      //   474: iconst_0
      //   475: aload_1
      //   476: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   479: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   482: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   485: aastore
      //   486: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   489: aload_0
      //   490: invokestatic 400	com/tencent/mm/modelvoice/o:bPf	()Lcom/tencent/mm/modelvoice/w;
      //   493: aload 4
      //   495: invokevirtual 445	com/tencent/mm/modelvoice/w:QT	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
      //   498: putfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   501: aload_0
      //   502: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   505: ifnonnull +142 -> 647
      //   508: ldc 114
      //   510: ldc_w 447
      //   513: iconst_2
      //   514: anewarray 132	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: aload_3
      //   520: aastore
      //   521: dup
      //   522: iconst_1
      //   523: aload 4
      //   525: aastore
      //   526: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   529: aload_0
      //   530: new 125	com/tencent/mm/modelvoice/r
      //   533: dup
      //   534: invokespecial 448	com/tencent/mm/modelvoice/r:<init>	()V
      //   537: putfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   540: aload_0
      //   541: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   544: aload 4
      //   546: putfield 154	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   549: aload_0
      //   550: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   553: invokestatic 188	java/lang/System:currentTimeMillis	()J
      //   556: ldc2_w 449
      //   559: ldiv
      //   560: putfield 453	com/tencent/mm/modelvoice/r:createTime	J
      //   563: aload_0
      //   564: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   567: aload 4
      //   569: putfield 146	com/tencent/mm/modelvoice/r:clientId	Ljava/lang/String;
      //   572: aload_0
      //   573: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   576: invokestatic 188	java/lang/System:currentTimeMillis	()J
      //   579: ldc2_w 449
      //   582: ldiv
      //   583: putfield 456	com/tencent/mm/modelvoice/r:pba	J
      //   586: aload_0
      //   587: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   590: iconst_1
      //   591: putfield 459	com/tencent/mm/modelvoice/r:status	I
      //   594: aload_1
      //   595: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   598: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   601: bipush 8
      //   603: if_icmpne +181 -> 784
      //   606: aload_0
      //   607: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   610: iconst_m1
      //   611: putfield 462	com/tencent/mm/modelvoice/r:pbc	I
      //   614: aload 4
      //   616: invokestatic 468	com/tencent/mm/modelvoice/q:PZ	(Ljava/lang/String;)I
      //   619: istore_2
      //   620: ldc 114
      //   622: ldc_w 470
      //   625: iconst_1
      //   626: anewarray 132	java/lang/Object
      //   629: dup
      //   630: iconst_0
      //   631: iload_2
      //   632: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   635: aastore
      //   636: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   639: aload_0
      //   640: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   643: iload_2
      //   644: putfield 149	com/tencent/mm/modelvoice/r:osy	I
      //   647: aload_0
      //   648: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   651: getfield 462	com/tencent/mm/modelvoice/r:pbc	I
      //   654: ifge +176 -> 830
      //   657: ldc 114
      //   659: ldc_w 472
      //   662: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   665: aload_0
      //   666: aload_0
      //   667: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   670: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   673: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   676: putfield 156	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SEa	I
      //   679: ldc 114
      //   681: ldc_w 474
      //   684: iconst_3
      //   685: anewarray 132	java/lang/Object
      //   688: dup
      //   689: iconst_0
      //   690: aload_0
      //   691: getfield 158	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hQQ	Ljava/lang/String;
      //   694: aastore
      //   695: dup
      //   696: iconst_1
      //   697: aload_0
      //   698: getfield 160	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:toUser	Ljava/lang/String;
      //   701: aastore
      //   702: dup
      //   703: iconst_2
      //   704: aload_0
      //   705: getfield 156	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SEa	I
      //   708: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   711: aastore
      //   712: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   715: aconst_null
      //   716: astore_1
      //   717: aload_0
      //   718: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   721: getfield 154	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   724: invokestatic 480	com/tencent/mm/modelvoice/s:QH	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
      //   727: astore_3
      //   728: aload_3
      //   729: ifnull +324 -> 1053
      //   732: aload_3
      //   733: astore_1
      //   734: aload_3
      //   735: invokeinterface 485 1 0
      //   740: istore_2
      //   741: aload_3
      //   742: astore_1
      //   743: aload_0
      //   744: iload_2
      //   745: putfield 151	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDT	I
      //   748: aload_3
      //   749: ifnull +9 -> 758
      //   752: aload_3
      //   753: invokeinterface 488 1 0
      //   758: aload_0
      //   759: iconst_1
      //   760: putfield 342	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:rdA	Z
      //   763: aload_0
      //   764: bipush 20
      //   766: putfield 344	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDY	I
      //   769: aload_0
      //   770: getstatic 491	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEg	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   773: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   776: sipush 28839
      //   779: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   782: iconst_1
      //   783: ireturn
      //   784: aload_0
      //   785: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   788: aload_3
      //   789: invokestatic 494	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   792: invokevirtual 497	java/lang/Integer:intValue	()I
      //   795: putfield 462	com/tencent/mm/modelvoice/r:pbc	I
      //   798: goto -184 -> 614
      //   801: astore_1
      //   802: ldc 114
      //   804: aload_1
      //   805: ldc_w 499
      //   808: iconst_0
      //   809: anewarray 132	java/lang/Object
      //   812: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   815: aload_0
      //   816: getstatic 361	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a:SEo	Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;
      //   819: invokespecial 249	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:a	(Lcom/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener$a;)V
      //   822: sipush 28839
      //   825: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   828: iconst_1
      //   829: ireturn
      //   830: ldc_w 505
      //   833: invokestatic 511	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   836: checkcast 505	com/tencent/mm/plugin/messenger/foundation/a/n
      //   839: invokeinterface 515 1 0
      //   844: aload_0
      //   845: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   848: getfield 462	com/tencent/mm/modelvoice/r:pbc	I
      //   851: i2l
      //   852: invokeinterface 521 3 0
      //   857: astore_1
      //   858: aload_1
      //   859: getfield 526	com/tencent/mm/autogen/b/fi:field_isSend	I
      //   862: iconst_1
      //   863: if_icmpne +93 -> 956
      //   866: aload_0
      //   867: invokestatic 531	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
      //   870: putfield 158	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hQQ	Ljava/lang/String;
      //   873: aload_0
      //   874: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   877: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   880: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   883: iconst_4
      //   884: if_icmpeq +17 -> 901
      //   887: aload_0
      //   888: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   891: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   894: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   897: iconst_5
      //   898: if_icmpne +47 -> 945
      //   901: ldc_w 533
      //   904: invokestatic 511	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   907: checkcast 533	com/tencent/mm/api/l
      //   910: aload_1
      //   911: getfield 536	com/tencent/mm/autogen/b/fi:field_bizChatId	J
      //   914: invokeinterface 540 3 0
      //   919: astore_1
      //   920: aload_1
      //   921: ifnull +14 -> 935
      //   924: aload_0
      //   925: aload_1
      //   926: getfield 545	com/tencent/mm/an/a/c:field_bizChatServId	Ljava/lang/String;
      //   929: putfield 160	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:toUser	Ljava/lang/String;
      //   932: goto -267 -> 665
      //   935: aload_0
      //   936: ldc_w 547
      //   939: putfield 160	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:toUser	Ljava/lang/String;
      //   942: goto -277 -> 665
      //   945: aload_0
      //   946: aload_1
      //   947: getfield 550	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
      //   950: putfield 160	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:toUser	Ljava/lang/String;
      //   953: goto -288 -> 665
      //   956: aload_1
      //   957: getfield 526	com/tencent/mm/autogen/b/fi:field_isSend	I
      //   960: ifne -295 -> 665
      //   963: aload_0
      //   964: invokestatic 531	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
      //   967: putfield 160	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:toUser	Ljava/lang/String;
      //   970: aload_0
      //   971: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   974: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   977: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   980: iconst_4
      //   981: if_icmpeq +17 -> 998
      //   984: aload_0
      //   985: getfield 263	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDX	Lcom/tencent/mm/autogen/a/gx;
      //   988: getfield 273	com/tencent/mm/autogen/a/gx:hHz	Lcom/tencent/mm/autogen/a/gx$a;
      //   991: getfield 439	com/tencent/mm/autogen/a/gx$a:scene	I
      //   994: iconst_5
      //   995: if_icmpne +47 -> 1042
      //   998: ldc_w 533
      //   1001: invokestatic 511	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   1004: checkcast 533	com/tencent/mm/api/l
      //   1007: aload_1
      //   1008: getfield 536	com/tencent/mm/autogen/b/fi:field_bizChatId	J
      //   1011: invokeinterface 540 3 0
      //   1016: astore_1
      //   1017: aload_1
      //   1018: ifnull +14 -> 1032
      //   1021: aload_0
      //   1022: aload_1
      //   1023: getfield 545	com/tencent/mm/an/a/c:field_bizChatServId	Ljava/lang/String;
      //   1026: putfield 158	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hQQ	Ljava/lang/String;
      //   1029: goto -364 -> 665
      //   1032: aload_0
      //   1033: ldc_w 547
      //   1036: putfield 158	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hQQ	Ljava/lang/String;
      //   1039: goto -374 -> 665
      //   1042: aload_0
      //   1043: aload_1
      //   1044: getfield 550	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
      //   1047: putfield 158	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:hQQ	Ljava/lang/String;
      //   1050: goto -385 -> 665
      //   1053: iconst_m1
      //   1054: istore_2
      //   1055: goto -314 -> 741
      //   1058: astore_3
      //   1059: ldc 114
      //   1061: aload_3
      //   1062: ldc_w 552
      //   1065: iconst_1
      //   1066: anewarray 132	java/lang/Object
      //   1069: dup
      //   1070: iconst_0
      //   1071: aload_0
      //   1072: getfield 123	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDS	Lcom/tencent/mm/modelvoice/r;
      //   1075: getfield 154	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   1078: aastore
      //   1079: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1082: aload_0
      //   1083: iconst_m1
      //   1084: putfield 151	com/tencent/mm/plugin/subapp/SubCoreSubapp$ExtTranslateVoiceEventListener:SDT	I
      //   1087: aload_1
      //   1088: ifnull -330 -> 758
      //   1091: aload_1
      //   1092: invokeinterface 488 1 0
      //   1097: goto -339 -> 758
      //   1100: astore_1
      //   1101: goto -343 -> 758
      //   1104: astore_3
      //   1105: aload_1
      //   1106: ifnull +9 -> 1115
      //   1109: aload_1
      //   1110: invokeinterface 488 1 0
      //   1115: sipush 28839
      //   1118: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1121: aload_3
      //   1122: athrow
      //   1123: astore_1
      //   1124: goto -366 -> 758
      //   1127: astore_1
      //   1128: goto -13 -> 1115
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1131	0	this	ExtTranslateVoiceEventListener
      //   0	1131	1	paramgx	gx
      //   619	436	2	i	int
      //   262	527	3	localObject1	Object
      //   1058	4	3	localThrowable	java.lang.Throwable
      //   1104	18	3	localObject2	Object
      //   273	342	4	str1	String
      //   344	33	5	str2	String
      // Exception table:
      //   from	to	target	type
      //   501	614	801	java/lang/Exception
      //   614	647	801	java/lang/Exception
      //   784	798	801	java/lang/Exception
      //   717	728	1058	finally
      //   734	741	1058	finally
      //   743	748	1058	finally
      //   1091	1097	1100	finally
      //   1059	1087	1104	finally
      //   752	758	1123	finally
      //   1109	1115	1127	finally
    }
    
    private void b(String paramString, a parama)
    {
      AppMethodBeat.i(28843);
      if (!this.mwk)
      {
        AppMethodBeat.o(28843);
        return;
      }
      if (this.SDS == null)
      {
        AppMethodBeat.o(28843);
        return;
      }
      int i;
      int j;
      if (paramString != null)
      {
        i = paramString.length();
        if (parama != a.SEk) {
          break label173;
        }
        if (Util.isNullOrNil(paramString)) {
          break label155;
        }
        j = 1;
      }
      for (;;)
      {
        Log.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.SDS.clientId, Integer.valueOf(i), Integer.valueOf(this.hHM), Integer.valueOf(this.hHN), Integer.valueOf(j) });
        if (j != 0) {
          com.tencent.mm.plugin.subapp.transformtext.a.d(this.SDS.clientId, i, this.hHM, this.hHN, j);
        }
        AppMethodBeat.o(28843);
        return;
        i = 0;
        break;
        label155:
        this.hHM = 0;
        this.hHN = 0;
        i = 0;
        j = 3;
        continue;
        label173:
        this.hHM = 0;
        this.hHN = 0;
        if (parama == a.SEm)
        {
          j = 5;
          i = 0;
        }
        else if (parama == a.SEp)
        {
          i = 0;
          j = 3;
        }
        else if (parama == a.SEo)
        {
          j = 4;
          i = 0;
        }
        else if (parama == a.SEq)
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
    
    private cy bcz(String paramString)
    {
      AppMethodBeat.i(28844);
      Log.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.SDX.hHz.hHB, this.SDX.hHz.fileName });
      cy localcy = new cy();
      localcy.field_msgId = Long.valueOf(this.SDX.hHz.hHB).longValue();
      localcy.byQ(this.SDX.hHz.fileName);
      localcy.field_content = paramString;
      AppMethodBeat.o(28844);
      return localcy;
    }
    
    private void hAD()
    {
      this.SEb = true;
      this.SEc = 0L;
      this.SEd = 0L;
      this.hHM = 0;
      this.hHN = 0;
      this.mwk = false;
    }
    
    private void hAE()
    {
      AppMethodBeat.i(28841);
      if (this.SEb)
      {
        this.SEb = false;
        this.SEc = System.currentTimeMillis();
        this.hHM = ((int)(this.SEc - this.SEd));
      }
      AppMethodBeat.o(28841);
    }
    
    public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, p paramp)
    {
      paramString = null;
      Object localObject = null;
      AppMethodBeat.i(28845);
      Log.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      switch (paramp.getType())
      {
      default: 
        AppMethodBeat.o(28845);
        return;
      case 546: 
        if (this.SDP.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.SJe)
        {
          Log.i("MicroMsg.SubCoreSubapp", "check result: done");
          a(a.SEk);
          hAE();
          this.hHN = 0;
          this.mwk = true;
          paramString = localObject;
          if (this.SDP.hBv()) {
            paramString = this.SDP.SJf.abWK;
          }
          a(paramString, a.SEk);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.SDP.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.SJd)
        {
          if (this.SDP.SJf != null) {
            Util.isNullOrNil(this.SDP.SJf.abWK);
          }
          Log.i("MicroMsg.SubCoreSubapp", "check result: processing");
          a(a.SEj);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.SDP.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.SJc)
        {
          Log.i("MicroMsg.SubCoreSubapp", "check result: not exist");
          a(a.SEh);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.SDP.SJh != null)
        {
          AppMethodBeat.o(28845);
          return;
        }
        break;
      case 547: 
        if (this.SDQ.hBx())
        {
          Log.i("MicroMsg.SubCoreSubapp", "succeed upload");
          a(a.SEj);
          AppMethodBeat.o(28845);
          return;
        }
        Log.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.SDQ.SJg.NkO), Integer.valueOf(this.SDQ.SJg.NkP) });
        a(a.SEi);
        AppMethodBeat.o(28845);
        return;
      case 548: 
        paramInt1 = this.SDR.cqG;
        Log.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
        this.SDU = false;
        hAE();
        if ((!this.SDR.isComplete()) && (this.SDR.hBv()))
        {
          Log.i("MicroMsg.SubCoreSubapp", "refreshResult result");
          paramp = this.SDR.SJf.abWK;
          if (this.SDX != null)
          {
            this.SDX.hHA.cVt = false;
            this.SDX.hHA.content = paramp;
            Log.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramp)) });
            if (this.SDX.hHz.hHD != null) {
              this.SDX.hHz.hHD.run();
            }
          }
        }
        while (this.SDR.isComplete())
        {
          Log.i("MicroMsg.SubCoreSubapp", "succeed get");
          if (this.SDR.hBv()) {
            paramString = this.SDR.SJf.abWK;
          }
          a(a.SEk);
          this.hHN = ((int)(System.currentTimeMillis() - this.SEc));
          this.mwk = true;
          a(paramString, a.SEk);
          AppMethodBeat.o(28845);
          return;
          if (!this.SDR.hBv()) {
            Log.d("MicroMsg.SubCoreSubapp", "result not valid");
          }
        }
        Log.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
        if (!this.SDV)
        {
          paramInt2 = this.SDY - 1;
          this.SDY = paramInt2;
          if (paramInt2 < 0)
          {
            Log.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
            a(a.SEp);
            AppMethodBeat.o(28845);
            return;
          }
          if (this.SDW == null) {
            this.SDW = new MTimerHandler(new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(28834);
                if (SubCoreSubapp.ExtTranslateVoiceEventListener.a(SubCoreSubapp.ExtTranslateVoiceEventListener.this))
                {
                  AppMethodBeat.o(28834);
                  return false;
                }
                Log.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
                SubCoreSubapp.ExtTranslateVoiceEventListener.a(SubCoreSubapp.ExtTranslateVoiceEventListener.this, SubCoreSubapp.ExtTranslateVoiceEventListener.a.SEj);
                AppMethodBeat.o(28834);
                return false;
              }
            }, false);
          }
          this.SDW.startTimer(paramInt1 * 1000);
        }
        AppMethodBeat.o(28845);
        return;
        if (paramInt1 == 2)
        {
          a(a.SEq);
          AppMethodBeat.o(28845);
          return;
        }
        a(a.SEp);
      }
      AppMethodBeat.o(28845);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(28837);
        SEg = new a("CHECK", 0);
        SEh = new a("UPLOAD", 1);
        SEi = new a("UPLOAD_MORE", 2);
        SEj = new a("GET", 3);
        SEk = new a("FINISH", 4);
        SEl = new a("ERROR", 5);
        SEm = new a("CANCEL", 6);
        SEn = new a("CANCEL_BY_USER", 7);
        SEo = new a("LOCAL_ERROR", 8);
        SEp = new a("SERVER_ERROR", 9);
        SEq = new a("NETWORK_OVERTIME", 10);
        SEr = new a[] { SEg, SEh, SEi, SEj, SEk, SEl, SEm, SEn, SEo, SEp, SEq };
        AppMethodBeat.o(28837);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.SubCoreSubapp
 * JD-Core Version:    0.7.0.1
 */