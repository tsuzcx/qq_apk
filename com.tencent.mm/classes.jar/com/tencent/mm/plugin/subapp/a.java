package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.gm.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.protocal.protobuf.fcx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements be
{
  private static cv Mcs;
  private Map<String, be> Mct;
  private a Mcu;
  private com.tencent.mm.plugin.subapp.e.a Mcv;
  private com.tencent.mm.plugin.subapp.e.c Mcw;
  private o.a appForegroundListener;
  
  public a()
  {
    AppMethodBeat.i(28847);
    this.Mct = new HashMap();
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (com.tencent.mm.pluginsdk.j.d.QYQ != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
          com.tencent.mm.plugin.subapp.jdbiz.d.ghw();
        }
        AppMethodBeat.o(28832);
      }
    };
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.aw.d.class.getName(), new com.tencent.mm.aw.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.d.d();
    com.tencent.mm.model.az.a.ltu = (az.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    com.tencent.mm.pluginsdk.j.d.QYQ = (d.a)localObject;
    this.Mct = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final void b(String paramString, be parambe)
  {
    AppMethodBeat.i(28854);
    this.Mct.put(paramString, parambe);
    AppMethodBeat.o(28854);
  }
  
  public final be bdM(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (be)this.Mct.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.Mct.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.Mct.entrySet().iterator();
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
    Iterator localIterator = this.Mct.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.Mcu == null) {
      this.Mcu = new a();
    }
    if (this.Mcv == null) {
      this.Mcv = new com.tencent.mm.plugin.subapp.e.a();
    }
    if (this.Mcw == null) {
      this.Mcw = new com.tencent.mm.plugin.subapp.e.c();
    }
    EventCenter.instance.addListener(this.Mcu);
    EventCenter.instance.addListener(this.Mcw);
    EventCenter.instance.addListener(this.Mcv);
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.Mct.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.Mcu != null) {
      EventCenter.instance.removeListener(this.Mcu);
    }
    if (this.Mcv != null) {
      EventCenter.instance.removeListener(this.Mcv);
    }
    if (this.Mcw != null) {
      EventCenter.instance.removeListener(this.Mcw);
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.Mct.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((be)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(28851);
  }
  
  public static final class a
    extends IListener<gm>
    implements i
  {
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c McA;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.b McB;
    private r McC;
    private int McD;
    private volatile boolean McE;
    private boolean McF;
    private MTimerHandler McG;
    private gm McH;
    private int McI;
    private Map<String, String> McJ;
    private int McK;
    private boolean McL;
    private long McM;
    private long McN;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.a Mcz;
    private int fCX;
    private int fCY;
    private String fLi;
    private boolean jWq;
    private boolean ocK;
    private String toUser;
    
    public a()
    {
      AppMethodBeat.i(28838);
      this.McE = false;
      this.McF = false;
      this.McL = true;
      this.McM = 0L;
      this.jWq = false;
      this.McJ = new HashMap();
      this.__eventId = gm.class.getName().hashCode();
      AppMethodBeat.o(28838);
    }
    
    private void a(a parama)
    {
      AppMethodBeat.i(28840);
      switch (a.2.Mcy[parama.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(28840);
        return;
        Log.i("MicroMsg.SubCoreSubapp", "net check");
        if (this.McC.fNu > 0L) {
          Log.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.McC.fNu) });
        }
        for (this.Mcz = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.McC.clientId, this.McC.lAW, this.McD, this.McC.fNu, this.McC.fileName, this.McK, this.fLi, this.toUser);; this.Mcz = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.McC.clientId, this.McC.lAW, this.McC.fileName, this.McK, this.fLi, this.toUser))
        {
          bh.aGY().a(this.Mcz, 0);
          bh.aGY().a(this.Mcz.getType(), this);
          this.McN = System.currentTimeMillis();
          AppMethodBeat.o(28840);
          return;
          Log.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.McC.fNu) });
        }
        Log.i("MicroMsg.SubCoreSubapp", "net upload");
        if (this.Mcz == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.McA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.McC.clientId, this.Mcz.MhJ, this.McD, this.McC.fileName, this.McK, this.fLi, this.toUser);
        bh.aGY().a(this.McA, 0);
        bh.aGY().a(this.McA.getType(), this);
        AppMethodBeat.o(28840);
        return;
        Log.i("MicroMsg.SubCoreSubapp", "net upload more");
        if (this.McA == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
          AppMethodBeat.o(28840);
          return;
        }
        this.McA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.McA);
        bh.aGY().a(this.McA, 0);
        bh.aGY().a(this.McA.getType(), this);
        AppMethodBeat.o(28840);
        return;
        if (this.McE)
        {
          Log.i("MicroMsg.SubCoreSubapp", "pulling so pass");
          AppMethodBeat.o(28840);
          return;
        }
        Log.i("MicroMsg.SubCoreSubapp", "net get");
        if (this.Mcz == null)
        {
          Log.w("MicroMsg.SubCoreSubapp", "request get must after check!");
          AppMethodBeat.o(28840);
          return;
        }
        this.McE = true;
        this.McB = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.McC.clientId);
        bh.aGY().a(this.McB, 0);
        bh.aGY().a(this.McB.getType(), this);
        AppMethodBeat.o(28840);
        return;
        this.McF = true;
        AppMethodBeat.o(28840);
        return;
        bh.aGY().a(this.Mcz);
        bh.aGY().a(this.McA);
        bh.aGY().a(this.McB);
        this.jWq = true;
        a(null, a.McW);
        AppMethodBeat.o(28840);
        return;
        this.jWq = true;
        a(null, parama);
        AppMethodBeat.o(28840);
        return;
        this.jWq = true;
        a(null, parama);
      }
    }
    
    private void a(String paramString, a parama)
    {
      AppMethodBeat.i(28842);
      Log.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
      if (this.McG != null) {
        this.McG.stopTimer();
      }
      bh.aGY().b(546, this);
      bh.aGY().b(547, this);
      bh.aGY().b(548, this);
      if (this.McH != null)
      {
        if (Util.isNullOrNil(paramString)) {
          break label291;
        }
        this.McJ.put(this.McH.fCK.fileName, paramString);
        if (((a.ghj() == null) || (Util.isNullOrNil(a.ghj().field_content))) && (this.McH.fCK.from == 1)) {
          o.brA().b(bdN(paramString));
        }
        this.McH.fCL.bby = true;
        this.McH.fCL.content = paramString;
        if (parama != a.McW) {
          break label337;
        }
      }
      for (this.McH.fCL.state = 1;; this.McH.fCL.state = 2) {
        label291:
        label337:
        do
        {
          Log.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
          if (this.McH.fCK.fCO != null) {
            this.McH.fCK.fCO.run();
          }
          b(paramString, parama);
          this.Mcz = null;
          this.McA = null;
          this.McB = null;
          this.McH = null;
          this.ocK = false;
          this.McF = false;
          this.McE = false;
          this.McI = 20;
          a.a(null);
          ghk();
          AppMethodBeat.o(28842);
          return;
          if (parama != a.McU) {
            break;
          }
          Log.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.McH.fCK.fCM });
          this.McH.fCL.state = 2;
          break;
        } while ((parama != a.McY) && (parama != a.McZ));
      }
    }
    
    /* Error */
    private boolean a(gm paramgm)
    {
      // Byte code:
      //   0: sipush 28839
      //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: instanceof 74
      //   10: ifne +19 -> 29
      //   13: ldc 105
      //   15: ldc_w 362
      //   18: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
      //   21: sipush 28839
      //   24: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: iconst_0
      //   28: ireturn
      //   29: aload_1
      //   30: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   33: getfield 368	com/tencent/mm/f/a/gm$a:fCN	I
      //   36: iconst_2
      //   37: if_icmpne +35 -> 72
      //   40: aload_0
      //   41: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:McW	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   44: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   47: aload_0
      //   48: getfield 72	com/tencent/mm/plugin/subapp/a$a:McJ	Ljava/util/Map;
      //   51: invokeinterface 371 1 0
      //   56: ldc 105
      //   58: ldc_w 373
      //   61: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   64: sipush 28839
      //   67: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: iconst_1
      //   71: ireturn
      //   72: aload_1
      //   73: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   76: getfield 368	com/tencent/mm/f/a/gm$a:fCN	I
      //   79: iconst_1
      //   80: if_icmpne +26 -> 106
      //   83: aload_0
      //   84: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:McW	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   87: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   90: ldc 105
      //   92: ldc_w 375
      //   95: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: sipush 28839
      //   101: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: iconst_1
      //   105: ireturn
      //   106: aload_1
      //   107: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   110: getfield 368	com/tencent/mm/f/a/gm$a:fCN	I
      //   113: iconst_3
      //   114: if_icmpne +26 -> 140
      //   117: aload_0
      //   118: getstatic 378	com/tencent/mm/plugin/subapp/a$a$a:McX	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   121: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   124: ldc 105
      //   126: ldc_w 380
      //   129: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   132: sipush 28839
      //   135: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: iconst_1
      //   139: ireturn
      //   140: aload_1
      //   141: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   144: getfield 368	com/tencent/mm/f/a/gm$a:fCN	I
      //   147: ifeq +39 -> 186
      //   150: ldc 105
      //   152: ldc_w 382
      //   155: iconst_1
      //   156: anewarray 123	java/lang/Object
      //   159: dup
      //   160: iconst_0
      //   161: aload_0
      //   162: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   165: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   168: getfield 368	com/tencent/mm/f/a/gm$a:fCN	I
      //   171: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   174: aastore
      //   175: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   178: sipush 28839
      //   181: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: iconst_0
      //   185: ireturn
      //   186: aload_0
      //   187: getfield 333	com/tencent/mm/plugin/subapp/a$a:ocK	Z
      //   190: ifeq +19 -> 209
      //   193: ldc 105
      //   195: ldc_w 389
      //   198: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   201: sipush 28839
      //   204: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: iconst_0
      //   208: ireturn
      //   209: invokestatic 393	com/tencent/mm/modelvoice/o:brz	()Lcom/tencent/mm/modelvoice/w;
      //   212: ifnonnull +35 -> 247
      //   215: ldc 105
      //   217: new 395	java/lang/StringBuilder
      //   220: dup
      //   221: ldc_w 397
      //   224: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   227: invokestatic 402	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
      //   230: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   233: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   236: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   239: sipush 28839
      //   242: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: iconst_0
      //   246: ireturn
      //   247: aload_0
      //   248: aload_1
      //   249: putfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   252: aload_0
      //   253: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   256: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   259: getfield 349	com/tencent/mm/f/a/gm$a:fCM	Ljava/lang/String;
      //   262: astore_3
      //   263: aload_0
      //   264: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   267: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   270: getfield 267	com/tencent/mm/f/a/gm$a:fileName	Ljava/lang/String;
      //   273: astore 4
      //   275: aload_3
      //   276: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   279: ifne +11 -> 290
      //   282: aload 4
      //   284: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   287: ifeq +39 -> 326
      //   290: ldc 105
      //   292: ldc_w 414
      //   295: iconst_2
      //   296: anewarray 123	java/lang/Object
      //   299: dup
      //   300: iconst_0
      //   301: aload_3
      //   302: aastore
      //   303: dup
      //   304: iconst_1
      //   305: aload 4
      //   307: aastore
      //   308: invokestatic 416	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   311: aload_0
      //   312: getstatic 352	com/tencent/mm/plugin/subapp/a$a$a:McY	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   315: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   318: sipush 28839
      //   321: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   324: iconst_0
      //   325: ireturn
      //   326: aload_0
      //   327: invokespecial 341	com/tencent/mm/plugin/subapp/a$a:ghk	()V
      //   330: aload_0
      //   331: getfield 72	com/tencent/mm/plugin/subapp/a$a:McJ	Ljava/util/Map;
      //   334: aload 4
      //   336: invokeinterface 420 2 0
      //   341: checkcast 82	java/lang/String
      //   344: astore 5
      //   346: aload 5
      //   348: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   351: ifne +41 -> 392
      //   354: ldc 105
      //   356: ldc_w 422
      //   359: iconst_2
      //   360: anewarray 123	java/lang/Object
      //   363: dup
      //   364: iconst_0
      //   365: aload_3
      //   366: aastore
      //   367: dup
      //   368: iconst_1
      //   369: aload 4
      //   371: aastore
      //   372: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   375: aload_0
      //   376: aload 5
      //   378: getstatic 344	com/tencent/mm/plugin/subapp/a$a$a:McU	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   381: invokespecial 236	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   384: sipush 28839
      //   387: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   390: iconst_1
      //   391: ireturn
      //   392: invokestatic 291	com/tencent/mm/modelvoice/o:brA	()Lcom/tencent/mm/storage/cw;
      //   395: aload 4
      //   397: invokevirtual 425	com/tencent/mm/storage/cw:bxz	(Ljava/lang/String;)Lcom/tencent/mm/storage/cv;
      //   400: invokestatic 338	com/tencent/mm/plugin/subapp/a:a	(Lcom/tencent/mm/storage/cv;)Lcom/tencent/mm/storage/cv;
      //   403: pop
      //   404: invokestatic 277	com/tencent/mm/plugin/subapp/a:ghj	()Lcom/tencent/mm/storage/cv;
      //   407: ifnull +57 -> 464
      //   410: invokestatic 277	com/tencent/mm/plugin/subapp/a:ghj	()Lcom/tencent/mm/storage/cv;
      //   413: getfield 282	com/tencent/mm/storage/cv:field_content	Ljava/lang/String;
      //   416: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   419: ifne +45 -> 464
      //   422: ldc 105
      //   424: ldc_w 427
      //   427: iconst_2
      //   428: anewarray 123	java/lang/Object
      //   431: dup
      //   432: iconst_0
      //   433: aload_3
      //   434: aastore
      //   435: dup
      //   436: iconst_1
      //   437: aload 4
      //   439: aastore
      //   440: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   443: aload_0
      //   444: invokestatic 277	com/tencent/mm/plugin/subapp/a:ghj	()Lcom/tencent/mm/storage/cv;
      //   447: getfield 282	com/tencent/mm/storage/cv:field_content	Ljava/lang/String;
      //   450: getstatic 344	com/tencent/mm/plugin/subapp/a$a$a:McU	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   453: invokespecial 236	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   456: sipush 28839
      //   459: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   462: iconst_1
      //   463: ireturn
      //   464: ldc 105
      //   466: ldc_w 429
      //   469: iconst_1
      //   470: anewarray 123	java/lang/Object
      //   473: dup
      //   474: iconst_0
      //   475: aload_1
      //   476: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   479: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   482: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   485: aastore
      //   486: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   489: aload_0
      //   490: invokestatic 393	com/tencent/mm/modelvoice/o:brz	()Lcom/tencent/mm/modelvoice/w;
      //   493: aload 4
      //   495: invokevirtual 438	com/tencent/mm/modelvoice/w:YO	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
      //   498: putfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   501: aload_0
      //   502: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   505: ifnonnull +142 -> 647
      //   508: ldc 105
      //   510: ldc_w 440
      //   513: iconst_2
      //   514: anewarray 123	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: aload_3
      //   520: aastore
      //   521: dup
      //   522: iconst_1
      //   523: aload 4
      //   525: aastore
      //   526: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   529: aload_0
      //   530: new 116	com/tencent/mm/modelvoice/r
      //   533: dup
      //   534: invokespecial 441	com/tencent/mm/modelvoice/r:<init>	()V
      //   537: putfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   540: aload_0
      //   541: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   544: aload 4
      //   546: putfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   549: aload_0
      //   550: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   553: invokestatic 179	java/lang/System:currentTimeMillis	()J
      //   556: ldc2_w 442
      //   559: ldiv
      //   560: putfield 446	com/tencent/mm/modelvoice/r:createTime	J
      //   563: aload_0
      //   564: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   567: aload 4
      //   569: putfield 137	com/tencent/mm/modelvoice/r:clientId	Ljava/lang/String;
      //   572: aload_0
      //   573: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   576: invokestatic 179	java/lang/System:currentTimeMillis	()J
      //   579: ldc2_w 442
      //   582: ldiv
      //   583: putfield 449	com/tencent/mm/modelvoice/r:mhP	J
      //   586: aload_0
      //   587: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   590: iconst_1
      //   591: putfield 452	com/tencent/mm/modelvoice/r:status	I
      //   594: aload_1
      //   595: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   598: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   601: bipush 8
      //   603: if_icmpne +196 -> 799
      //   606: aload_0
      //   607: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   610: iconst_m1
      //   611: putfield 455	com/tencent/mm/modelvoice/r:mhR	I
      //   614: aload 4
      //   616: invokestatic 461	com/tencent/mm/modelvoice/q:XV	(Ljava/lang/String;)I
      //   619: istore_2
      //   620: ldc 105
      //   622: ldc_w 463
      //   625: iconst_1
      //   626: anewarray 123	java/lang/Object
      //   629: dup
      //   630: iconst_0
      //   631: iload_2
      //   632: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   635: aastore
      //   636: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   639: aload_0
      //   640: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   643: iload_2
      //   644: putfield 140	com/tencent/mm/modelvoice/r:lAW	I
      //   647: aload_0
      //   648: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   651: getfield 455	com/tencent/mm/modelvoice/r:mhR	I
      //   654: ifge +191 -> 845
      //   657: ldc 105
      //   659: ldc_w 465
      //   662: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   665: aload_0
      //   666: aload_0
      //   667: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   670: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   673: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   676: putfield 147	com/tencent/mm/plugin/subapp/a$a:McK	I
      //   679: ldc 105
      //   681: ldc_w 467
      //   684: iconst_3
      //   685: anewarray 123	java/lang/Object
      //   688: dup
      //   689: iconst_0
      //   690: aload_0
      //   691: getfield 149	com/tencent/mm/plugin/subapp/a$a:fLi	Ljava/lang/String;
      //   694: aastore
      //   695: dup
      //   696: iconst_1
      //   697: aload_0
      //   698: getfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   701: aastore
      //   702: dup
      //   703: iconst_2
      //   704: aload_0
      //   705: getfield 147	com/tencent/mm/plugin/subapp/a$a:McK	I
      //   708: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   711: aastore
      //   712: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   715: aconst_null
      //   716: astore_3
      //   717: aconst_null
      //   718: astore_1
      //   719: aload_0
      //   720: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   723: getfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   726: invokestatic 473	com/tencent/mm/modelvoice/s:YC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
      //   729: astore 4
      //   731: aload 4
      //   733: ifnull +335 -> 1068
      //   736: aload 4
      //   738: astore_1
      //   739: aload 4
      //   741: astore_3
      //   742: aload 4
      //   744: invokeinterface 478 1 0
      //   749: istore_2
      //   750: aload 4
      //   752: astore_1
      //   753: aload 4
      //   755: astore_3
      //   756: aload_0
      //   757: iload_2
      //   758: putfield 142	com/tencent/mm/plugin/subapp/a$a:McD	I
      //   761: aload 4
      //   763: ifnull +10 -> 773
      //   766: aload 4
      //   768: invokeinterface 481 1 0
      //   773: aload_0
      //   774: iconst_1
      //   775: putfield 333	com/tencent/mm/plugin/subapp/a$a:ocK	Z
      //   778: aload_0
      //   779: bipush 20
      //   781: putfield 335	com/tencent/mm/plugin/subapp/a$a:McI	I
      //   784: aload_0
      //   785: getstatic 484	com/tencent/mm/plugin/subapp/a$a$a:McQ	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   788: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   791: sipush 28839
      //   794: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   797: iconst_1
      //   798: ireturn
      //   799: aload_0
      //   800: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   803: aload_3
      //   804: invokestatic 487	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   807: invokevirtual 490	java/lang/Integer:intValue	()I
      //   810: putfield 455	com/tencent/mm/modelvoice/r:mhR	I
      //   813: goto -199 -> 614
      //   816: astore_1
      //   817: ldc 105
      //   819: aload_1
      //   820: ldc_w 492
      //   823: iconst_0
      //   824: anewarray 123	java/lang/Object
      //   827: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   830: aload_0
      //   831: getstatic 352	com/tencent/mm/plugin/subapp/a$a$a:McY	Lcom/tencent/mm/plugin/subapp/a$a$a;
      //   834: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
      //   837: sipush 28839
      //   840: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   843: iconst_1
      //   844: ireturn
      //   845: ldc_w 498
      //   848: invokestatic 504	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   851: checkcast 498	com/tencent/mm/plugin/messenger/foundation/a/n
      //   854: invokeinterface 508 1 0
      //   859: aload_0
      //   860: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   863: getfield 455	com/tencent/mm/modelvoice/r:mhR	I
      //   866: i2l
      //   867: invokeinterface 514 3 0
      //   872: astore_1
      //   873: aload_1
      //   874: getfield 519	com/tencent/mm/f/c/et:field_isSend	I
      //   877: iconst_1
      //   878: if_icmpne +93 -> 971
      //   881: aload_0
      //   882: invokestatic 524	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
      //   885: putfield 149	com/tencent/mm/plugin/subapp/a$a:fLi	Ljava/lang/String;
      //   888: aload_0
      //   889: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   892: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   895: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   898: iconst_4
      //   899: if_icmpeq +17 -> 916
      //   902: aload_0
      //   903: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   906: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   909: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   912: iconst_5
      //   913: if_icmpne +47 -> 960
      //   916: ldc_w 526
      //   919: invokestatic 504	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   922: checkcast 526	com/tencent/mm/api/k
      //   925: aload_1
      //   926: getfield 529	com/tencent/mm/f/c/et:field_bizChatId	J
      //   929: invokeinterface 533 3 0
      //   934: astore_1
      //   935: aload_1
      //   936: ifnull +14 -> 950
      //   939: aload_0
      //   940: aload_1
      //   941: getfield 538	com/tencent/mm/ao/a/c:field_bizChatServId	Ljava/lang/String;
      //   944: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   947: goto -282 -> 665
      //   950: aload_0
      //   951: ldc_w 540
      //   954: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   957: goto -292 -> 665
      //   960: aload_0
      //   961: aload_1
      //   962: getfield 543	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
      //   965: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   968: goto -303 -> 665
      //   971: aload_1
      //   972: getfield 519	com/tencent/mm/f/c/et:field_isSend	I
      //   975: ifne -310 -> 665
      //   978: aload_0
      //   979: invokestatic 524	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
      //   982: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
      //   985: aload_0
      //   986: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   989: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   992: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   995: iconst_4
      //   996: if_icmpeq +17 -> 1013
      //   999: aload_0
      //   1000: getfield 254	com/tencent/mm/plugin/subapp/a$a:McH	Lcom/tencent/mm/f/a/gm;
      //   1003: getfield 264	com/tencent/mm/f/a/gm:fCK	Lcom/tencent/mm/f/a/gm$a;
      //   1006: getfield 432	com/tencent/mm/f/a/gm$a:scene	I
      //   1009: iconst_5
      //   1010: if_icmpne +47 -> 1057
      //   1013: ldc_w 526
      //   1016: invokestatic 504	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   1019: checkcast 526	com/tencent/mm/api/k
      //   1022: aload_1
      //   1023: getfield 529	com/tencent/mm/f/c/et:field_bizChatId	J
      //   1026: invokeinterface 533 3 0
      //   1031: astore_1
      //   1032: aload_1
      //   1033: ifnull +14 -> 1047
      //   1036: aload_0
      //   1037: aload_1
      //   1038: getfield 538	com/tencent/mm/ao/a/c:field_bizChatServId	Ljava/lang/String;
      //   1041: putfield 149	com/tencent/mm/plugin/subapp/a$a:fLi	Ljava/lang/String;
      //   1044: goto -379 -> 665
      //   1047: aload_0
      //   1048: ldc_w 540
      //   1051: putfield 149	com/tencent/mm/plugin/subapp/a$a:fLi	Ljava/lang/String;
      //   1054: goto -389 -> 665
      //   1057: aload_0
      //   1058: aload_1
      //   1059: getfield 543	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
      //   1062: putfield 149	com/tencent/mm/plugin/subapp/a$a:fLi	Ljava/lang/String;
      //   1065: goto -400 -> 665
      //   1068: iconst_m1
      //   1069: istore_2
      //   1070: goto -320 -> 750
      //   1073: astore 4
      //   1075: aload_1
      //   1076: astore_3
      //   1077: ldc 105
      //   1079: aload 4
      //   1081: ldc_w 545
      //   1084: iconst_1
      //   1085: anewarray 123	java/lang/Object
      //   1088: dup
      //   1089: iconst_0
      //   1090: aload_0
      //   1091: getfield 114	com/tencent/mm/plugin/subapp/a$a:McC	Lcom/tencent/mm/modelvoice/r;
      //   1094: getfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
      //   1097: aastore
      //   1098: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1101: aload_1
      //   1102: astore_3
      //   1103: aload_0
      //   1104: iconst_m1
      //   1105: putfield 142	com/tencent/mm/plugin/subapp/a$a:McD	I
      //   1108: aload_1
      //   1109: ifnull -336 -> 773
      //   1112: aload_1
      //   1113: invokeinterface 481 1 0
      //   1118: goto -345 -> 773
      //   1121: astore_1
      //   1122: goto -349 -> 773
      //   1125: astore_1
      //   1126: aload_3
      //   1127: ifnull +9 -> 1136
      //   1130: aload_3
      //   1131: invokeinterface 481 1 0
      //   1136: sipush 28839
      //   1139: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1142: aload_1
      //   1143: athrow
      //   1144: astore_1
      //   1145: goto -372 -> 773
      //   1148: astore_3
      //   1149: goto -13 -> 1136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1152	0	this	a
      //   0	1152	1	paramgm	gm
      //   619	451	2	i	int
      //   262	869	3	localObject1	Object
      //   1148	1	3	localThrowable1	java.lang.Throwable
      //   273	494	4	localObject2	Object
      //   1073	7	4	localThrowable2	java.lang.Throwable
      //   344	33	5	str	String
      // Exception table:
      //   from	to	target	type
      //   501	614	816	java/lang/Exception
      //   614	647	816	java/lang/Exception
      //   799	813	816	java/lang/Exception
      //   719	731	1073	java/lang/Throwable
      //   742	750	1073	java/lang/Throwable
      //   756	761	1073	java/lang/Throwable
      //   1112	1118	1121	java/lang/Throwable
      //   719	731	1125	finally
      //   742	750	1125	finally
      //   756	761	1125	finally
      //   1077	1101	1125	finally
      //   1103	1108	1125	finally
      //   766	773	1144	java/lang/Throwable
      //   1130	1136	1148	java/lang/Throwable
    }
    
    private void b(String paramString, a parama)
    {
      AppMethodBeat.i(28843);
      if (!this.jWq)
      {
        AppMethodBeat.o(28843);
        return;
      }
      if (this.McC == null)
      {
        AppMethodBeat.o(28843);
        return;
      }
      int i;
      int j;
      if (paramString != null)
      {
        i = paramString.length();
        if (parama != a.McU) {
          break label173;
        }
        if (Util.isNullOrNil(paramString)) {
          break label155;
        }
        j = 1;
      }
      for (;;)
      {
        Log.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.McC.clientId, Integer.valueOf(i), Integer.valueOf(this.fCX), Integer.valueOf(this.fCY), Integer.valueOf(j) });
        if (j != 0) {
          com.tencent.mm.plugin.subapp.e.b.d(this.McC.clientId, i, this.fCX, this.fCY, j);
        }
        AppMethodBeat.o(28843);
        return;
        i = 0;
        break;
        label155:
        this.fCX = 0;
        this.fCY = 0;
        i = 0;
        j = 3;
        continue;
        label173:
        this.fCX = 0;
        this.fCY = 0;
        if (parama == a.McW)
        {
          j = 5;
          i = 0;
        }
        else if (parama == a.McZ)
        {
          i = 0;
          j = 3;
        }
        else if (parama == a.McY)
        {
          j = 4;
          i = 0;
        }
        else if (parama == a.Mda)
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
    
    private cv bdN(String paramString)
    {
      AppMethodBeat.i(28844);
      Log.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.McH.fCK.fCM, this.McH.fCK.fileName });
      cv localcv = new cv();
      localcv.field_msgId = Long.valueOf(this.McH.fCK.fCM).longValue();
      localcv.bxy(this.McH.fCK.fileName);
      localcv.field_content = paramString;
      AppMethodBeat.o(28844);
      return localcv;
    }
    
    private void ghk()
    {
      this.McL = true;
      this.McM = 0L;
      this.McN = 0L;
      this.fCX = 0;
      this.fCY = 0;
      this.jWq = false;
    }
    
    private void ghl()
    {
      AppMethodBeat.i(28841);
      if (this.McL)
      {
        this.McL = false;
        this.McM = System.currentTimeMillis();
        this.fCX = ((int)(this.McM - this.McN));
      }
      AppMethodBeat.o(28841);
    }
    
    public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, q paramq)
    {
      paramString = null;
      Object localObject = null;
      AppMethodBeat.i(28845);
      Log.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      switch (paramq.getType())
      {
      default: 
        AppMethodBeat.o(28845);
        return;
      case 546: 
        if (this.Mcz.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.MhH)
        {
          Log.i("MicroMsg.SubCoreSubapp", "check result: done");
          a(a.McU);
          ghl();
          this.fCY = 0;
          this.jWq = true;
          paramString = localObject;
          if (this.Mcz.ghU()) {
            paramString = this.Mcz.MhI.UCA;
          }
          a(paramString, a.McU);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Mcz.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.MhG)
        {
          if (this.Mcz.MhI != null) {
            Util.isNullOrNil(this.Mcz.MhI.UCA);
          }
          Log.i("MicroMsg.SubCoreSubapp", "check result: processing");
          a(a.McT);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Mcz.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.MhF)
        {
          Log.i("MicroMsg.SubCoreSubapp", "check result: not exist");
          a(a.McR);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.Mcz.MhK != null)
        {
          AppMethodBeat.o(28845);
          return;
        }
        break;
      case 547: 
        if (this.McA.ghW())
        {
          Log.i("MicroMsg.SubCoreSubapp", "succeed upload");
          a(a.McT);
          AppMethodBeat.o(28845);
          return;
        }
        Log.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.McA.MhJ.Hna), Integer.valueOf(this.McA.MhJ.Hnb) });
        a(a.McS);
        AppMethodBeat.o(28845);
        return;
      case 548: 
        paramInt1 = this.McB.MhM;
        Log.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
        this.McE = false;
        ghl();
        if ((!this.McB.isComplete()) && (this.McB.ghU()))
        {
          Log.i("MicroMsg.SubCoreSubapp", "refreshResult result");
          paramq = this.McB.MhI.UCA;
          if (this.McH != null)
          {
            this.McH.fCL.bby = false;
            this.McH.fCL.content = paramq;
            Log.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramq)) });
            if (this.McH.fCK.fCO != null) {
              this.McH.fCK.fCO.run();
            }
          }
        }
        while (this.McB.isComplete())
        {
          Log.i("MicroMsg.SubCoreSubapp", "succeed get");
          if (this.McB.ghU()) {
            paramString = this.McB.MhI.UCA;
          }
          a(a.McU);
          this.fCY = ((int)(System.currentTimeMillis() - this.McM));
          this.jWq = true;
          a(paramString, a.McU);
          AppMethodBeat.o(28845);
          return;
          if (!this.McB.ghU()) {
            Log.d("MicroMsg.SubCoreSubapp", "result not valid");
          }
        }
        Log.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
        if (!this.McF)
        {
          paramInt2 = this.McI - 1;
          this.McI = paramInt2;
          if (paramInt2 < 0)
          {
            Log.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
            a(a.McZ);
            AppMethodBeat.o(28845);
            return;
          }
          if (this.McG == null) {
            this.McG = new MTimerHandler(new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(28834);
                if (a.a.a(a.a.this))
                {
                  AppMethodBeat.o(28834);
                  return false;
                }
                Log.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
                a.a.a(a.a.this, a.a.a.McT);
                AppMethodBeat.o(28834);
                return false;
              }
            }, false);
          }
          this.McG.startTimer(paramInt1 * 1000);
        }
        AppMethodBeat.o(28845);
        return;
        if (paramInt1 == 2)
        {
          a(a.Mda);
          AppMethodBeat.o(28845);
          return;
        }
        a(a.McZ);
      }
      AppMethodBeat.o(28845);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(28837);
        McQ = new a("CHECK", 0);
        McR = new a("UPLOAD", 1);
        McS = new a("UPLOAD_MORE", 2);
        McT = new a("GET", 3);
        McU = new a("FINISH", 4);
        McV = new a("ERROR", 5);
        McW = new a("CANCEL", 6);
        McX = new a("CANCEL_BY_USER", 7);
        McY = new a("LOCAL_ERROR", 8);
        McZ = new a("SERVER_ERROR", 9);
        Mda = new a("NETWORK_OVERTIME", 10);
        Mdb = new a[] { McQ, McR, McS, McT, McU, McV, McW, McX, McY, McZ, Mda };
        AppMethodBeat.o(28837);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */