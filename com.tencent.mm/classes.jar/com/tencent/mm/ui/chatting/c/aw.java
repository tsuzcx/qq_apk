package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.f;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.a;
import com.tencent.mm.g.a.fx.b;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.al;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=al.class)
public class aw
  extends a
  implements al
{
  private static HashMap<Long, String> GyT;
  private static HashMap<Long, ChattingItemTranslate.b> GyU;
  private static LinkedHashMap<Long, Pair<bl, Integer>> GyV;
  private static HashMap<Long, Boolean> GyW;
  private boolean GyX;
  private boolean GyY;
  private List<Long> GyZ;
  boolean Gza;
  long Gzb;
  long Gzc;
  boolean Gzd;
  private int Gze;
  private boolean lVj;
  
  static
  {
    AppMethodBeat.i(35726);
    GyT = new HashMap();
    GyU = new HashMap();
    GyV = new LinkedHashMap();
    GyW = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public aw()
  {
    AppMethodBeat.i(35689);
    this.GyX = false;
    this.lVj = false;
    this.GyY = false;
    this.GyZ = new ArrayList();
    this.Gza = false;
    this.Gzc = 0L;
    this.Gzd = false;
    this.Gze = -1;
    AppMethodBeat.o(35689);
  }
  
  private void YS(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.lVj) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.d.a locala = this.cOd;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locala, locala1.adn(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.ca(((Integer)locala1.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void YT(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.GyX) && (this.GyZ.size() > 0))
    {
      String str = ((Long)this.GyZ.get(0)).toString();
      int i = 1;
      while (i < this.GyZ.size())
      {
        str = str + ":" + this.GyZ.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      int k = this.GyZ.size();
      i = j;
      if (this.lVj) {
        i = 0;
      }
      localh.f(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.GyX = false;
      this.GyZ.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private void a(long paramLong, bl parambl, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      GyV.put(Long.valueOf(paramLong), new Pair(parambl, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      parambl = finally;
      throw parambl;
    }
  }
  
  private void aKP(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.cOd != null) && (this.cOd.GzJ.getContext() != null))
    {
      paramString = Toast.makeText(this.cOd.GzJ.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private static void c(int paramInt, bl parambl)
  {
    AppMethodBeat.i(35706);
    if (parambl == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gb localgb = new gb();
    localgb.diZ.djb = 0;
    localgb.diZ.djc = 0;
    localgb.diZ.djd = 0;
    localgb.diZ.dja = 0;
    localgb.diZ.fileName = parambl.field_imgPath;
    localgb.diZ.result = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localgb);
    AppMethodBeat.o(35706);
  }
  
  private void eYL()
  {
    try
    {
      AppMethodBeat.i(35699);
      GyV.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int eYO()
  {
    AppMethodBeat.i(35713);
    int i;
    if (w.sE(this.cOd.getTalkerUserName()))
    {
      boolean bool = ((d)this.cOd.be(d.class)).eWD();
      if (((d)this.cOd.be(d.class)).eWC()) {
        if (bool) {
          i = 5;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35713);
      return i;
      i = 4;
      continue;
      if (f.wK(this.cOd.getTalkerUserName()))
      {
        i = 3;
      }
      else if (f.wL(this.cOd.getTalkerUserName()))
      {
        i = 0;
      }
      else if (f.wG(this.cOd.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.cOd.eZa()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void g(final bl parambl, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 368
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/ui/chatting/c/aw:cOd	Lcom/tencent/mm/ui/chatting/d/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 372	com/tencent/mm/ui/chatting/d/a:eZd	()Lcom/tencent/mm/sdk/platformtools/ap;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 10	com/tencent/mm/ui/chatting/c/aw$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 375	com/tencent/mm/ui/chatting/c/aw$2:<init>	(Lcom/tencent/mm/ui/chatting/c/aw;ILcom/tencent/mm/storage/bl;)V
    //   34: invokevirtual 381	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: ldc_w 368
    //   41: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aconst_null
    //   48: astore_3
    //   49: goto -30 -> 19
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	aw
    //   0	57	1	parambl	bl
    //   0	57	2	paramInt	int
    //   18	31	3	localap	com.tencent.mm.sdk.platformtools.ap
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.cOd != null)
    {
      localObject = this.cOd.GzJ.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = aj.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.cOd != null) {
      this.cOd.bCM();
    }
    AppMethodBeat.o(35708);
  }
  
  private void wF(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      GyT.remove(Long.valueOf(paramLong));
      GyU.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(35691);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private bl wI(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 395
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/c/aw:GyV	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 397	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 201	android/util/Pair
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +15 -> 38
    //   26: aconst_null
    //   27: astore_3
    //   28: ldc_w 395
    //   31: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: aload_3
    //   39: getfield 401	android/util/Pair:first	Ljava/lang/Object;
    //   42: checkcast 403	com/tencent/mm/storage/bl
    //   45: astore_3
    //   46: ldc_w 395
    //   49: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -18 -> 34
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	aw
    //   0	60	1	paramLong	long
    //   21	25	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	55	finally
    //   28	34	55	finally
    //   38	52	55	finally
  }
  
  private void wJ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (GyV.containsKey(Long.valueOf(paramLong))) {
        GyV.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void wL(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      GyW.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String K(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)GyT.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bt.isNullOrNil(str2))
      {
        paramString = o.aDz().aJn(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!bt.isNullOrNil(paramString.field_content)) {
            str1 = paramString.field_content;
          }
        }
      }
      AppMethodBeat.o(35692);
      return str1;
    }
    finally {}
  }
  
  public final void YR(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.GyY = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.Gza) {
      a(wI(this.Gzb), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.b paramb)
  {
    try
    {
      AppMethodBeat.i(35690);
      GyT.put(Long.valueOf(paramLong), paramString);
      GyU.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.GPE) {
        GyW.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final bl parambl, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (parambl == null)
    {
      ad.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (wK(parambl.field_msgId))
    {
      ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambl.field_msgId), Boolean.valueOf(this.Gza) });
      parambl.eMA();
      wL(parambl.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((wH(parambl.field_msgId)) && (paramBoolean))
    {
      if (wG(parambl.field_msgId) == ChattingItemTranslate.b.GPC)
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        wJ(parambl.field_msgId);
        wF(parambl.field_msgId);
        c(5, parambl);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        YT(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.Gza)
        {
          localObject = new fx();
          ((fx)localObject).diO.diR = 3;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          wJ(parambl.field_msgId);
          wF(parambl.field_msgId);
          parambl.eMA();
          az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
          this.Gza = false;
          g(parambl, -1);
        }
      }
    }
    Object localObject = o.aDz().aJn(parambl.field_imgPath);
    if ((localObject != null) && (!bt.isNullOrNil(((cd)localObject).field_content)))
    {
      ad.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambl.field_msgId), parambl.field_imgPath });
      parambl.eMB();
      a(parambl.field_msgId, ((cd)localObject).field_content, ChattingItemTranslate.b.GPE);
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      this.GyX = false;
      YS(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = az.aeS().auR();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      com.tencent.mm.ui.base.h.j(getContext(), 2131757322, 2131755906);
      c(2, parambl);
      this.GyX = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.Gza)
    {
      ad.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(parambl.field_msgId, parambl, paramInt1);
      a(parambl.field_msgId, "", ChattingItemTranslate.b.GPC);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.lVj = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new fx();
      ((fx)localObject).diO.diR = 1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new fx();
      ((fx)localObject).diO.diQ = String.valueOf(parambl.field_msgId);
      ((fx)localObject).diO.fileName = parambl.field_imgPath;
      ((fx)localObject).diO.from = 1;
      ((fx)localObject).diO.diR = 0;
      ((fx)localObject).diO.scene = eYO();
      ((fx)localObject).diO.diS = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35686);
          if (!aw.this.wH(Long.valueOf(this.BrA.diO.diQ).longValue()))
          {
            AppMethodBeat.o(35686);
            return;
          }
          if (this.BrA.diP.bhb)
          {
            if (bt.isNullOrNil(this.BrA.diP.content))
            {
              if (this.BrA.diP.state == 2)
              {
                ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.BrA.diO.diQ });
                aw.a(aw.this, aw.a(aw.this).getString(2131757321));
              }
              aw.a(aw.this, Long.valueOf(this.BrA.diO.diQ).longValue());
              aw.b(aw.this, Long.valueOf(this.BrA.diO.diQ).longValue());
              aw.this.Gza = false;
              aw.b(aw.this);
            }
            for (;;)
            {
              aw.a(aw.this, parambl, paramInt1);
              AppMethodBeat.o(35686);
              return;
              ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.BrA.diO.diQ });
              bl localbl = aw.c(aw.this, Long.valueOf(this.BrA.diO.diQ).longValue());
              if (localbl != null)
              {
                aw.this.a(Long.valueOf(this.BrA.diO.diQ).longValue(), this.BrA.diP.content, ChattingItemTranslate.b.GPE);
                localbl.eMB();
                az.arV();
                com.tencent.mm.model.c.apO().a(localbl.field_msgId, localbl);
                aw.b(aw.this, Long.valueOf(this.BrA.diO.diQ).longValue());
                aw.b(aw.this);
                aw.a(aw.this, paramInt1);
              }
              aw.this.Gza = false;
            }
          }
          if (!bt.isNullOrNil(this.BrA.diP.content))
          {
            aw.this.a(Long.valueOf(this.BrA.diO.diQ).longValue(), this.BrA.diP.content, ChattingItemTranslate.b.GPD);
            ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.BrA.diO.diQ });
          }
          aw.b(aw.this);
          aw.a(aw.this, paramInt1);
          AppMethodBeat.o(35686);
        }
      };
      a(Long.valueOf(((fx)localObject).diO.diQ).longValue(), "", ChattingItemTranslate.b.GPD);
      a(parambl.field_msgId, parambl, paramInt1);
      this.Gza = true;
      this.Gzb = parambl.field_msgId;
      notifyDataSetChanged();
      YS(paramInt1);
      if (com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject))
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        aKP(getContext().getString(2131757321));
        wF(Long.valueOf(((fx)localObject).diO.diQ).longValue());
        wJ(Long.valueOf(((fx)localObject).diO.diQ).longValue());
        this.Gza = false;
        g(parambl, paramInt1);
      }
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35714);
    ad.i("MicroMsg.TransformComponent", "[onChattingPause]");
    YR(3);
    AppMethodBeat.o(35714);
  }
  
  public final void eQG()
  {
    AppMethodBeat.i(35715);
    ad.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    eYL();
    GyU.clear();
    GyV.clear();
    GyW.clear();
    if (this.Gza)
    {
      fx localfx = new fx();
      localfx.diO.diR = 3;
      com.tencent.mm.sdk.b.a.ESL.l(localfx);
      this.Gza = false;
    }
    ad.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35688);
        long l = System.currentTimeMillis();
        synchronized (aw.this)
        {
          aw.cUt().clear();
          aw.eYP().clear();
          ad.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(35688);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  /* Error */
  public final Pair<bl, Integer> eYK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 636
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/c/aw:GyV	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 640	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 646 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 651 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 655 1 0
    //   35: checkcast 657	java/util/Map$Entry
    //   38: invokeinterface 660 1 0
    //   43: checkcast 201	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 636
    //   50: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 636
    //   62: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aw
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean eYM()
  {
    AppMethodBeat.i(35700);
    az.arV();
    if (!((Boolean)com.tencent.mm.model.c.afk().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void eYN()
  {
    AppMethodBeat.i(35701);
    az.arV();
    com.tencent.mm.model.c.afk().set(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.Gze) {
      this.lVj = false;
    }
    this.Gze = paramInt1;
    AppMethodBeat.o(35716);
  }
  
  public final ChattingItemTranslate.b wG(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)GyU.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.GPB;
      }
      AppMethodBeat.o(35693);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean wH(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 692
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/c/aw:GyV	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 408	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 692
    //   26: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 692
    //   38: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	aw
    //   0	51	1	paramLong	long
    //   22	13	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   23	29	44	finally
    //   35	41	44	finally
  }
  
  /* Error */
  public final boolean wK(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 693
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 64	com/tencent/mm/ui/chatting/c/aw:GyW	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 421	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 412	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 676	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 693
    //   37: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 693
    //   49: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	aw
    //   0	62	1	paramLong	long
    //   33	13	3	bool	boolean
    //   21	8	4	localBoolean	Boolean
    //   55	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	55	finally
    //   28	40	55	finally
    //   46	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aw
 * JD-Core Version:    0.7.0.1
 */