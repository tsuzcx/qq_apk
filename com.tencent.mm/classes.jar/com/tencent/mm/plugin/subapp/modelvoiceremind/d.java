package com.tencent.mm.plugin.subapp.modelvoiceremind;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.d;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.subapp.SubCoreSubapp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class d
  implements az.f, be
{
  private static d SFc;
  private static HashMap<Integer, h.b> qkO;
  private k SFb;
  private j SFd;
  private List<Long> SFe;
  private IListener SFf;
  private IListener SFg;
  private IListener SFh;
  private q.a appForegroundListener;
  private final Set<az.d> listeners;
  private String mCJ;
  private o.a qkP;
  
  static
  {
    AppMethodBeat.i(28959);
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
    localHashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    AppMethodBeat.o(28959);
  }
  
  public d()
  {
    AppMethodBeat.i(28946);
    this.SFe = new ArrayList();
    this.listeners = new HashSet();
    this.SFf = new SubCoreVoiceRemind.3(this, f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(28943);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(28943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28942);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28941);
                if (az.a.okS != null) {
                  az.a.okS.bCm();
                }
                AppMethodBeat.o(28941);
              }
            });
          }
        }
        AppMethodBeat.o(28942);
      }
    };
    this.SFg = new SubCoreVoiceRemind.5(this, f.hfK);
    this.SFh = new SubCoreVoiceRemind.6(this, f.hfK);
    AppMethodBeat.o(28946);
  }
  
  public static d hAY()
  {
    AppMethodBeat.i(28953);
    bh.bCt();
    SubCoreSubapp localSubCoreSubapp = (SubCoreSubapp)ci.Ka("plugin.subapp");
    if (localSubCoreSubapp == null) {}
    for (d locald = null;; locald = (d)localSubCoreSubapp.bcy(d.class.getName()))
    {
      SFc = locald;
      Log.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", new Object[] { localSubCoreSubapp, SFc, Util.getStack() });
      if (SFc == null)
      {
        locald = new d();
        SFc = locald;
        az.a.okS = locald;
        localSubCoreSubapp.b(d.class.getName(), SFc);
      }
      locald = SFc;
      AppMethodBeat.o(28953);
      return locald;
    }
  }
  
  public static k hAZ()
  {
    AppMethodBeat.i(28954);
    h.baC().aZJ();
    if (hAY().SFb == null)
    {
      localObject1 = hAY();
      hAY();
      if (hAY().qkP == null)
      {
        Object localObject2 = new StringBuilder();
        bh.bCz();
        localObject2 = c.baj() + "CommonOneMicroMsg.db";
        hAY().qkP = o.a(d.class.hashCode(), (String)localObject2, qkO, false);
      }
      ((d)localObject1).SFb = new k(hAY().qkP);
    }
    Object localObject1 = hAY().SFb;
    AppMethodBeat.o(28954);
    return localObject1;
  }
  
  public static j hBa()
  {
    AppMethodBeat.i(28958);
    h.baC().aZJ();
    if (hAY().SFd == null) {
      hAY().SFd = new j();
    }
    j localj = hAY().SFd;
    AppMethodBeat.o(28958);
    return localj;
  }
  
  public final void JC(String paramString)
  {
    AppMethodBeat.i(28950);
    bh.bCz();
    c.bzG().bxO(paramString);
    this.SFe.clear();
    bh.bCz();
    Cursor localCursor = c.bzD().aLR(paramString);
    localCursor.moveToFirst();
    Log.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
    while (!localCursor.isAfterLast())
    {
      cc localcc = new cc();
      localcc.convertFrom(localCursor);
      long l = localcc.field_msgId;
      Log.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + l + " status = " + localcc.field_status);
      localCursor.moveToNext();
      this.SFe.add(Long.valueOf(l));
    }
    localCursor.close();
    bh.bCz();
    c.bzD().aLP(paramString);
    AppMethodBeat.o(28950);
  }
  
  public final void a(az.d paramd)
  {
    AppMethodBeat.i(28947);
    Log.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
    if (paramd != null) {
      this.listeners.add(paramd);
    }
    AppMethodBeat.o(28947);
  }
  
  public final void b(az.d paramd)
  {
    AppMethodBeat.i(28948);
    Log.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
    if (paramd != null) {
      this.listeners.remove(paramd);
    }
    AppMethodBeat.o(28948);
  }
  
  public final void bCm()
  {
    AppMethodBeat.i(28951);
    hBa().run();
    AppMethodBeat.o(28951);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final boolean it(long paramLong)
  {
    AppMethodBeat.i(28952);
    boolean bool = this.SFe.contains(Long.valueOf(paramLong));
    Log.d("MicroMsg.SubCoreVoiceRemind", "silent " + bool + "  mid " + paramLong);
    AppMethodBeat.o(28952);
    return bool;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28955);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
    localStringBuilder.append(c.baj()).append("CommonOneMicroMsg.db");
    hAZ();
    this.SFf.alive();
    this.SFg.alive();
    this.SFh.alive();
    this.appForegroundListener.alive();
    Log.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(28955);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28957);
    if (this.SFd != null) {
      this.SFd.hxJ = 0;
    }
    this.appForegroundListener.dead();
    if (SFc != null)
    {
      Log.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
      d locald = SFc;
      if (locald.qkP != null)
      {
        locald.qkP.yb(locald.hashCode());
        locald.qkP = null;
      }
      locald.mCJ = "";
    }
    this.SFf.dead();
    this.SFg.dead();
    this.SFh.dead();
    AppMethodBeat.o(28957);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28956);
    bh.bCz();
    Object localObject = c.getAccPath();
    if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(this.mCJ)) || (!((String)localObject).equals(this.mCJ)))
    {
      Log.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : ".concat(String.valueOf(localObject)));
      this.mCJ = ((String)localObject);
      localObject = new u((String)localObject);
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
      bh.bCz();
      localObject = new u(c.bzW());
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
    }
    AppMethodBeat.o(28956);
  }
  
  /* Error */
  public final void s(String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: sipush 28949
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 432	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: astore 11
    //   11: aload 11
    //   13: ifnonnull +18 -> 31
    //   16: ldc 140
    //   18: ldc_w 434
    //   21: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 28949
    //   27: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: invokestatic 439	com/tencent/mm/k/h:aQN	()Z
    //   34: istore 8
    //   36: invokestatic 442	com/tencent/mm/k/h:aQL	()Z
    //   39: istore 9
    //   41: ldc 140
    //   43: new 194	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 444
    //   50: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload 8
    //   55: invokevirtual 354	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: ldc_w 446
    //   61: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 9
    //   66: invokevirtual 354	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: invokestatic 450	com/tencent/mm/model/bh:getNotification	()Lcom/tencent/mm/model/ay;
    //   78: invokeinterface 455 1 0
    //   83: invokestatic 460	com/tencent/mm/storage/au:bwn	(Ljava/lang/String;)Z
    //   86: ifeq +47 -> 133
    //   89: iload 8
    //   91: ifeq +9 -> 100
    //   94: aload 11
    //   96: iconst_1
    //   97: invokestatic 464	com/tencent/mm/sdk/platformtools/Util:shake	(Landroid/content/Context;Z)V
    //   100: aload_0
    //   101: getfield 96	com/tencent/mm/plugin/subapp/modelvoiceremind/d:listeners	Ljava/util/Set;
    //   104: ifnull +15 -> 119
    //   107: aload_0
    //   108: getfield 96	com/tencent/mm/plugin/subapp/modelvoiceremind/d:listeners	Ljava/util/Set;
    //   111: invokeinterface 467 1 0
    //   116: ifne +350 -> 466
    //   119: aload 11
    //   121: aload_1
    //   122: aload_2
    //   123: invokestatic 473	com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog:T	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   126: sipush 28949
    //   129: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: iload 8
    //   135: ifeq +9 -> 144
    //   138: aload 11
    //   140: iconst_1
    //   141: invokestatic 464	com/tencent/mm/sdk/platformtools/Util:shake	(Landroid/content/Context;Z)V
    //   144: iload 9
    //   146: ifeq -46 -> 100
    //   149: invokestatic 477	com/tencent/mm/k/h:aQP	()Landroid/util/Pair;
    //   152: astore 10
    //   154: aload 10
    //   156: getfield 483	android/util/Pair:second	Ljava/lang/Object;
    //   159: checkcast 66	java/lang/String
    //   162: astore 12
    //   164: aload 10
    //   166: getfield 486	android/util/Pair:first	Ljava/lang/Object;
    //   169: checkcast 488	java/lang/Boolean
    //   172: invokevirtual 491	java/lang/Boolean:booleanValue	()Z
    //   175: istore 8
    //   177: aload 12
    //   179: getstatic 496	com/tencent/mm/ui/f$o:lZE	Ljava/lang/String;
    //   182: if_acmpne +216 -> 398
    //   185: iconst_2
    //   186: invokestatic 502	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
    //   189: astore 10
    //   191: new 504	com/tencent/mm/compatible/b/k
    //   194: dup
    //   195: invokespecial 505	com/tencent/mm/compatible/b/k:<init>	()V
    //   198: astore 12
    //   200: aload 12
    //   202: aload 11
    //   204: aload 10
    //   206: invokevirtual 511	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   209: aload 12
    //   211: new 16	com/tencent/mm/plugin/subapp/modelvoiceremind/d$1
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 512	com/tencent/mm/plugin/subapp/modelvoiceremind/d$1:<init>	(Lcom/tencent/mm/plugin/subapp/modelvoiceremind/d;)V
    //   219: invokevirtual 516	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   222: iconst_5
    //   223: invokestatic 522	com/tencent/mm/plugin/audio/c/a:getStreamVolume	(I)I
    //   226: ifeq -126 -> 100
    //   229: invokestatic 525	com/tencent/mm/plugin/audio/c/a:cTQ	()Z
    //   232: ifeq +203 -> 435
    //   235: bipush 8
    //   237: invokestatic 522	com/tencent/mm/plugin/audio/c/a:getStreamVolume	(I)I
    //   240: istore 7
    //   242: bipush 8
    //   244: invokestatic 528	com/tencent/mm/plugin/audio/c/a:getStreamMaxVolume	(I)I
    //   247: istore 5
    //   249: iconst_5
    //   250: invokestatic 522	com/tencent/mm/plugin/audio/c/a:getStreamVolume	(I)I
    //   253: istore 6
    //   255: iload 6
    //   257: iload 5
    //   259: if_icmple +252 -> 511
    //   262: bipush 8
    //   264: iload 5
    //   266: invokestatic 532	com/tencent/mm/plugin/audio/c/a:gi	(II)V
    //   269: aload 12
    //   271: bipush 8
    //   273: invokevirtual 535	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   276: aload 12
    //   278: iconst_1
    //   279: invokevirtual 538	android/media/MediaPlayer:setLooping	(Z)V
    //   282: aload 12
    //   284: invokevirtual 541	android/media/MediaPlayer:prepare	()V
    //   287: aload 12
    //   289: iconst_0
    //   290: invokevirtual 538	android/media/MediaPlayer:setLooping	(Z)V
    //   293: aload 12
    //   295: invokevirtual 544	android/media/MediaPlayer:start	()V
    //   298: bipush 8
    //   300: iload 7
    //   302: invokestatic 532	com/tencent/mm/plugin/audio/c/a:gi	(II)V
    //   305: ldc 140
    //   307: ldc_w 546
    //   310: iconst_2
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: iload 7
    //   318: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: iload 5
    //   326: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: goto -233 -> 100
    //   336: astore 10
    //   338: ldc 140
    //   340: aload 10
    //   342: ldc_w 388
    //   345: iconst_0
    //   346: anewarray 4	java/lang/Object
    //   349: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: aload 12
    //   354: invokevirtual 553	android/media/MediaPlayer:release	()V
    //   357: goto -257 -> 100
    //   360: astore 10
    //   362: ldc 140
    //   364: aload 10
    //   366: ldc_w 555
    //   369: iconst_0
    //   370: anewarray 4	java/lang/Object
    //   373: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: goto -276 -> 100
    //   379: astore 10
    //   381: ldc 140
    //   383: aload 10
    //   385: ldc_w 388
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: goto -295 -> 100
    //   398: iload 8
    //   400: ifeq +25 -> 425
    //   403: aload 11
    //   405: new 557	java/io/File
    //   408: dup
    //   409: aload 12
    //   411: invokespecial 558	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: invokestatic 562	com/tencent/mm/vfs/u:V	(Ljava/io/File;)Lcom/tencent/mm/vfs/u;
    //   417: invokestatic 568	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFile	(Landroid/content/Context;Lcom/tencent/mm/vfs/u;)Landroid/net/Uri;
    //   420: astore 10
    //   422: goto -231 -> 191
    //   425: aload 12
    //   427: invokestatic 574	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   430: astore 10
    //   432: goto -241 -> 191
    //   435: aload 12
    //   437: iconst_5
    //   438: invokevirtual 535	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   441: aload 12
    //   443: iconst_1
    //   444: invokevirtual 538	android/media/MediaPlayer:setLooping	(Z)V
    //   447: aload 12
    //   449: invokevirtual 541	android/media/MediaPlayer:prepare	()V
    //   452: aload 12
    //   454: iconst_0
    //   455: invokevirtual 538	android/media/MediaPlayer:setLooping	(Z)V
    //   458: aload 12
    //   460: invokevirtual 544	android/media/MediaPlayer:start	()V
    //   463: goto -363 -> 100
    //   466: aload_0
    //   467: getfield 96	com/tencent/mm/plugin/subapp/modelvoiceremind/d:listeners	Ljava/util/Set;
    //   470: invokeinterface 578 1 0
    //   475: astore_1
    //   476: aload_1
    //   477: invokeinterface 583 1 0
    //   482: ifeq +22 -> 504
    //   485: aload_1
    //   486: invokeinterface 587 1 0
    //   491: checkcast 589	com/tencent/mm/model/az$d
    //   494: aload_2
    //   495: lload_3
    //   496: invokeinterface 593 4 0
    //   501: goto -25 -> 476
    //   504: sipush 28949
    //   507: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: return
    //   511: iload 6
    //   513: istore 5
    //   515: goto -253 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	d
    //   0	518	1	paramString1	String
    //   0	518	2	paramString2	String
    //   0	518	3	paramLong	long
    //   247	267	5	i	int
    //   253	259	6	j	int
    //   240	77	7	k	int
    //   34	365	8	bool1	boolean
    //   39	106	9	bool2	boolean
    //   152	53	10	localObject1	Object
    //   336	5	10	localException1	Exception
    //   360	5	10	localThrowable	java.lang.Throwable
    //   379	5	10	localException2	Exception
    //   420	11	10	localUri	android.net.Uri
    //   9	395	11	localContext	android.content.Context
    //   162	297	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   200	255	336	java/lang/Exception
    //   262	333	336	java/lang/Exception
    //   435	463	336	java/lang/Exception
    //   352	357	360	finally
    //   31	89	379	java/lang/Exception
    //   94	100	379	java/lang/Exception
    //   138	144	379	java/lang/Exception
    //   149	191	379	java/lang/Exception
    //   191	200	379	java/lang/Exception
    //   338	352	379	java/lang/Exception
    //   362	376	379	java/lang/Exception
    //   403	422	379	java/lang/Exception
    //   425	432	379	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.d
 * JD-Core Version:    0.7.0.1
 */