package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gb.a;
import com.tencent.mm.g.a.gb.b;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ap.class)
public class ba
  extends a
  implements ap
{
  private static HashMap<Long, String> JNQ;
  private static HashMap<Long, ChattingItemTranslate.b> JNR;
  private static LinkedHashMap<Long, Pair<bu, Integer>> JNS;
  private static HashMap<Long, Boolean> JNT;
  private boolean JNU;
  private boolean JNV;
  private List<Long> JNW;
  boolean JNX;
  long JNY;
  long JNZ;
  boolean JOa;
  private int JOb;
  private boolean mXP;
  
  static
  {
    AppMethodBeat.i(35726);
    JNQ = new HashMap();
    JNR = new HashMap();
    JNS = new LinkedHashMap();
    JNT = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public ba()
  {
    AppMethodBeat.i(35689);
    this.JNU = false;
    this.mXP = false;
    this.JNV = false;
    this.JNW = new ArrayList();
    this.JNX = false;
    this.JNZ = 0L;
    this.JOa = false;
    this.JOb = -1;
    AppMethodBeat.o(35689);
  }
  
  private void DY(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      JNQ.remove(Long.valueOf(paramLong));
      JNR.remove(Long.valueOf(paramLong));
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
  private bu Eb(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 105
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 62	com/tencent/mm/ui/chatting/d/ba:JNS	Ljava/util/LinkedHashMap;
    //   10: lload_1
    //   11: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokevirtual 108	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 110	android/util/Pair
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +14 -> 36
    //   25: aconst_null
    //   26: astore_3
    //   27: ldc 105
    //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: areturn
    //   36: aload_3
    //   37: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   40: checkcast 116	com/tencent/mm/storage/bu
    //   43: astore_3
    //   44: ldc 105
    //   46: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -17 -> 32
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ba
    //   0	57	1	paramLong	long
    //   20	24	3	localObject1	Object
    //   52	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   27	32	52	finally
    //   36	49	52	finally
  }
  
  private void Ec(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (JNS.containsKey(Long.valueOf(paramLong))) {
        JNS.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void Ee(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      JNT.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong, bu parambu, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      JNS.put(Long.valueOf(paramLong), new Pair(parambu, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      parambu = finally;
      throw parambu;
    }
  }
  
  private void aWl(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.cWM != null) && (this.cWM.JOR.getContext() != null))
    {
      paramString = Toast.makeText(this.cWM.JOR.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private void adp(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.mXP) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.e.a locala = this.cWM;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locala, locala1.ahp(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.ca(((Integer)locala1.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void adq(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.JNU) && (this.JNW.size() > 0))
    {
      String str = ((Long)this.JNW.get(0)).toString();
      int i = 1;
      while (i < this.JNW.size())
      {
        str = str + ":" + this.JNW.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      int k = this.JNW.size();
      i = j;
      if (this.mXP) {
        i = 0;
      }
      localg.f(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.JNU = false;
      this.JNW.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private static void c(int paramInt, bu parambu)
  {
    AppMethodBeat.i(35706);
    if (parambu == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gf localgf = new gf();
    localgf.drQ.drS = 0;
    localgf.drQ.drT = 0;
    localgf.drQ.drU = 0;
    localgf.drQ.drR = 0;
    localgf.drQ.fileName = parambu.field_imgPath;
    localgf.drQ.result = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localgf);
    AppMethodBeat.o(35706);
  }
  
  private void fFe()
  {
    try
    {
      AppMethodBeat.i(35699);
      JNS.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int fFh()
  {
    AppMethodBeat.i(35713);
    int i;
    if (w.zE(this.cWM.getTalkerUserName()))
    {
      boolean bool = ((d)this.cWM.bh(d.class)).fCI();
      if (((d)this.cWM.bh(d.class)).fCH()) {
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
      if (com.tencent.mm.am.g.DP(this.cWM.getTalkerUserName()))
      {
        i = 3;
      }
      else if (com.tencent.mm.am.g.DQ(this.cWM.getTalkerUserName()))
      {
        i = 0;
      }
      else if (com.tencent.mm.am.g.DL(this.cWM.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.cWM.fFu()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void g(final bu parambu, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 179	com/tencent/mm/ui/chatting/d/ba:cWM	Lcom/tencent/mm/ui/chatting/e/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 401	com/tencent/mm/ui/chatting/e/a:fFx	()Lcom/tencent/mm/sdk/platformtools/ap;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 10	com/tencent/mm/ui/chatting/d/ba$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 404	com/tencent/mm/ui/chatting/d/ba$2:<init>	(Lcom/tencent/mm/ui/chatting/d/ba;ILcom/tencent/mm/storage/bu;)V
    //   34: invokevirtual 410	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: ldc_w 397
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
    //   0	57	0	this	ba
    //   0	57	1	parambu	bu
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
    if (this.cWM != null)
    {
      localObject = this.cWM.JOR.getContext();
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
    if (this.cWM != null) {
      this.cWM.bOo();
    }
    AppMethodBeat.o(35708);
  }
  
  public final ChattingItemTranslate.b DZ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)JNR.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.Kgd;
      }
      AppMethodBeat.o(35693);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean Ea(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 431
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/d/ba:JNS	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 122	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 431
    //   26: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 431
    //   38: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ba
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
  public final boolean Ed(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 433
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 64	com/tencent/mm/ui/chatting/d/ba:JNT	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 422	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 127	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 436	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 433
    //   37: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 433
    //   49: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ba
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
  
  public final String N(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)JNQ.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bt.isNullOrNil(str2))
      {
        paramString = o.aNz().aUA(paramString);
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
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.b paramb)
  {
    try
    {
      AppMethodBeat.i(35690);
      JNQ.put(Long.valueOf(paramLong), paramString);
      JNR.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.Kgg) {
        JNT.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final bu parambu, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (parambu == null)
    {
      ad.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (Ed(parambu.field_msgId))
    {
      ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambu.field_msgId), Boolean.valueOf(this.JNX) });
      parambu.fsm();
      Ee(parambu.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((Ea(parambu.field_msgId)) && (paramBoolean))
    {
      if (DZ(parambu.field_msgId) == ChattingItemTranslate.b.Kge)
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        Ec(parambu.field_msgId);
        DY(parambu.field_msgId);
        c(5, parambu);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        adq(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.JNX)
        {
          localObject = new gb();
          ((gb)localObject).drF.drI = 3;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          Ec(parambu.field_msgId);
          DY(parambu.field_msgId);
          parambu.fsm();
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
          this.JNX = false;
          g(parambu, -1);
        }
      }
    }
    Object localObject = o.aNz().aUA(parambu.field_imgPath);
    if ((localObject != null) && (!bt.isNullOrNil(((cm)localObject).field_content)))
    {
      ad.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambu.field_msgId), parambu.field_imgPath });
      parambu.fsn();
      a(parambu.field_msgId, ((cm)localObject).field_content, ChattingItemTranslate.b.Kgg);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      this.JNU = false;
      adp(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = com.tencent.mm.model.ba.aiU().aEN();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      h.l(getContext(), 2131757322, 2131755906);
      c(2, parambu);
      this.JNU = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.JNX)
    {
      ad.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(parambu.field_msgId, parambu, paramInt1);
      a(parambu.field_msgId, "", ChattingItemTranslate.b.Kge);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.mXP = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new gb();
      ((gb)localObject).drF.drI = 1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new gb();
      ((gb)localObject).drF.drH = String.valueOf(parambu.field_msgId);
      ((gb)localObject).drF.fileName = parambu.field_imgPath;
      ((gb)localObject).drF.from = 1;
      ((gb)localObject).drF.drI = 0;
      ((gb)localObject).drF.scene = fFh();
      ((gb)localObject).drF.drJ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35686);
          if (!ba.this.Ea(Long.valueOf(this.Env.drF.drH).longValue()))
          {
            AppMethodBeat.o(35686);
            return;
          }
          if (this.Env.drG.bsb)
          {
            if (bt.isNullOrNil(this.Env.drG.content))
            {
              if (this.Env.drG.state == 2)
              {
                ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.Env.drF.drH });
                ba.a(ba.this, ba.a(ba.this).getString(2131757321));
              }
              ba.a(ba.this, Long.valueOf(this.Env.drF.drH).longValue());
              ba.b(ba.this, Long.valueOf(this.Env.drF.drH).longValue());
              ba.this.JNX = false;
              ba.b(ba.this);
            }
            for (;;)
            {
              ba.a(ba.this, parambu, paramInt1);
              AppMethodBeat.o(35686);
              return;
              ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.Env.drF.drH });
              bu localbu = ba.c(ba.this, Long.valueOf(this.Env.drF.drH).longValue());
              if (localbu != null)
              {
                ba.this.a(Long.valueOf(this.Env.drF.drH).longValue(), this.Env.drG.content, ChattingItemTranslate.b.Kgg);
                localbu.fsn();
                com.tencent.mm.model.ba.aBQ();
                com.tencent.mm.model.c.azs().a(localbu.field_msgId, localbu);
                ba.b(ba.this, Long.valueOf(this.Env.drF.drH).longValue());
                ba.b(ba.this);
                ba.a(ba.this, paramInt1);
              }
              ba.this.JNX = false;
            }
          }
          if (!bt.isNullOrNil(this.Env.drG.content))
          {
            ba.this.a(Long.valueOf(this.Env.drF.drH).longValue(), this.Env.drG.content, ChattingItemTranslate.b.Kgf);
            ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.Env.drF.drH });
          }
          ba.b(ba.this);
          ba.a(ba.this, paramInt1);
          AppMethodBeat.o(35686);
        }
      };
      a(Long.valueOf(((gb)localObject).drF.drH).longValue(), "", ChattingItemTranslate.b.Kgf);
      a(parambu.field_msgId, parambu, paramInt1);
      this.JNX = true;
      this.JNY = parambu.field_msgId;
      notifyDataSetChanged();
      adp(paramInt1);
      if (com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject))
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        ad.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        aWl(getContext().getString(2131757321));
        DY(Long.valueOf(((gb)localObject).drF.drH).longValue());
        Ec(Long.valueOf(((gb)localObject).drF.drH).longValue());
        this.JNX = false;
        g(parambu, paramInt1);
      }
    }
  }
  
  public final void ado(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.JNV = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.JNX) {
      a(Eb(this.JNY), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  /* Error */
  public final Pair<bu, Integer> fFd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 623
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/d/ba:JNS	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 627	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 633 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 638 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 642 1 0
    //   35: checkcast 644	java/util/Map$Entry
    //   38: invokeinterface 647 1 0
    //   43: checkcast 110	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 623
    //   50: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 623
    //   62: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ba
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean fFf()
  {
    AppMethodBeat.i(35700);
    com.tencent.mm.model.ba.aBQ();
    if (!((Boolean)com.tencent.mm.model.c.ajl().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void fFg()
  {
    AppMethodBeat.i(35701);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.ajl().set(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35714);
    ad.i("MicroMsg.TransformComponent", "[onChattingPause]");
    ado(3);
    AppMethodBeat.o(35714);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(35715);
    ad.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    fFe();
    JNR.clear();
    JNS.clear();
    JNT.clear();
    if (this.JNX)
    {
      gb localgb = new gb();
      localgb.drF.drI = 3;
      com.tencent.mm.sdk.b.a.IbL.l(localgb);
      this.JNX = false;
    }
    ad.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35688);
        long l = System.currentTimeMillis();
        synchronized (ba.this)
        {
          ba.dsm().clear();
          ba.fFi().clear();
          ad.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(35688);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.JOb) {
      this.mXP = false;
    }
    this.JOb = paramInt1;
    AppMethodBeat.o(35716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ba
 * JD-Core Version:    0.7.0.1
 */