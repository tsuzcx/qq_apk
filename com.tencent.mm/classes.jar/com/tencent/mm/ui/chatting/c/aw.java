package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.fy.a;
import com.tencent.mm.g.a.fy.b;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.ch;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.al;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=al.class)
public class aw
  extends a
  implements al
{
  private static HashMap<Long, String> HYK;
  private static HashMap<Long, ChattingItemTranslate.b> HYL;
  private static LinkedHashMap<Long, Pair<bo, Integer>> HYM;
  private static HashMap<Long, Boolean> HYN;
  private boolean HYO;
  private boolean HYP;
  private List<Long> HYQ;
  boolean HYR;
  long HYS;
  long HYT;
  boolean HYU;
  private int HYV;
  private boolean mxl;
  
  static
  {
    AppMethodBeat.i(35726);
    HYK = new HashMap();
    HYL = new HashMap();
    HYM = new LinkedHashMap();
    HYN = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public aw()
  {
    AppMethodBeat.i(35689);
    this.HYO = false;
    this.mxl = false;
    this.HYP = false;
    this.HYQ = new ArrayList();
    this.HYR = false;
    this.HYT = 0L;
    this.HYU = false;
    this.HYV = -1;
    AppMethodBeat.o(35689);
  }
  
  private void Bi(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      HYK.remove(Long.valueOf(paramLong));
      HYL.remove(Long.valueOf(paramLong));
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
  private bo Bl(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 105
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 62	com/tencent/mm/ui/chatting/c/aw:HYM	Ljava/util/LinkedHashMap;
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
    //   40: checkcast 116	com/tencent/mm/storage/bo
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
    //   0	57	0	this	aw
    //   0	57	1	paramLong	long
    //   20	24	3	localObject1	Object
    //   52	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   27	32	52	finally
    //   36	49	52	finally
  }
  
  private void Bm(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (HYM.containsKey(Long.valueOf(paramLong))) {
        HYM.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void Bo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      HYN.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong, bo parambo, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      HYM.put(Long.valueOf(paramLong), new Pair(parambo, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      parambo = finally;
      throw parambo;
    }
  }
  
  private void aQs(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.cLy != null) && (this.cLy.HZF.getContext() != null))
    {
      paramString = Toast.makeText(this.cLy.HZF.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private void abd(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.mxl) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.d.a locala = this.cLy;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locala, locala1.aeD(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.ca(((Integer)locala1.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void abe(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.HYO) && (this.HYQ.size() > 0))
    {
      String str = ((Long)this.HYQ.get(0)).toString();
      int i = 1;
      while (i < this.HYQ.size())
      {
        str = str + ":" + this.HYQ.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      int k = this.HYQ.size();
      i = j;
      if (this.mxl) {
        i = 0;
      }
      localh.f(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.HYO = false;
      this.HYQ.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private static void c(int paramInt, bo parambo)
  {
    AppMethodBeat.i(35706);
    if (parambo == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gc localgc = new gc();
    localgc.dgu.dgw = 0;
    localgc.dgu.dgx = 0;
    localgc.dgu.dgy = 0;
    localgc.dgu.dgv = 0;
    localgc.dgu.fileName = parambo.field_imgPath;
    localgc.dgu.result = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localgc);
    AppMethodBeat.o(35706);
  }
  
  private void foA()
  {
    try
    {
      AppMethodBeat.i(35699);
      HYM.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int foD()
  {
    AppMethodBeat.i(35713);
    int i;
    if (w.wH(this.cLy.getTalkerUserName()))
    {
      boolean bool = ((d)this.cLy.bf(d.class)).fmp();
      if (((d)this.cLy.bf(d.class)).fmo()) {
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
      if (f.AQ(this.cLy.getTalkerUserName()))
      {
        i = 3;
      }
      else if (f.AR(this.cLy.getTalkerUserName()))
      {
        i = 0;
      }
      else if (f.AM(this.cLy.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.cLy.foP()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void g(final bo parambo, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 179	com/tencent/mm/ui/chatting/c/aw:cLy	Lcom/tencent/mm/ui/chatting/d/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 401	com/tencent/mm/ui/chatting/d/a:foS	()Lcom/tencent/mm/sdk/platformtools/ao;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 10	com/tencent/mm/ui/chatting/c/aw$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 404	com/tencent/mm/ui/chatting/c/aw$2:<init>	(Lcom/tencent/mm/ui/chatting/c/aw;ILcom/tencent/mm/storage/bo;)V
    //   34: invokevirtual 410	com/tencent/mm/sdk/platformtools/ao:post	(Ljava/lang/Runnable;)Z
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
    //   0	57	0	this	aw
    //   0	57	1	parambo	bo
    //   0	57	2	paramInt	int
    //   18	31	3	localao	com.tencent.mm.sdk.platformtools.ao
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.cLy != null)
    {
      localObject = this.cLy.HZF.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = ai.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.cLy != null) {
      this.cLy.bJU();
    }
    AppMethodBeat.o(35708);
  }
  
  public final ChattingItemTranslate.b Bj(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)HYL.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.IpD;
      }
      AppMethodBeat.o(35693);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean Bk(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 431
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/c/aw:HYM	Ljava/util/LinkedHashMap;
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
  public final boolean Bn(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 433
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 64	com/tencent/mm/ui/chatting/c/aw:HYN	Ljava/util/HashMap;
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
  
  public final String I(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)HYK.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bs.isNullOrNil(str2))
      {
        paramString = o.aKq().aOJ(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!bs.isNullOrNil(paramString.field_content)) {
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
      HYK.put(Long.valueOf(paramLong), paramString);
      HYL.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.IpG) {
        HYN.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final bo parambo, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (parambo == null)
    {
      ac.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (Bn(parambo.field_msgId))
    {
      ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambo.field_msgId), Boolean.valueOf(this.HYR) });
      parambo.fcf();
      Bo(parambo.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((Bk(parambo.field_msgId)) && (paramBoolean))
    {
      if (Bj(parambo.field_msgId) == ChattingItemTranslate.b.IpE)
      {
        ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        Bm(parambo.field_msgId);
        Bi(parambo.field_msgId);
        c(5, parambo);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        abe(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.HYR)
        {
          localObject = new fy();
          ((fy)localObject).dgj.dgm = 3;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          Bm(parambo.field_msgId);
          Bi(parambo.field_msgId);
          parambo.fcf();
          az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
          this.HYR = false;
          g(parambo, -1);
        }
      }
    }
    Object localObject = o.aKq().aOJ(parambo.field_imgPath);
    if ((localObject != null) && (!bs.isNullOrNil(((cg)localObject).field_content)))
    {
      ac.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambo.field_msgId), parambo.field_imgPath });
      parambo.fcg();
      a(parambo.field_msgId, ((cg)localObject).field_content, ChattingItemTranslate.b.IpG);
      az.ayM();
      com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      this.HYO = false;
      abd(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = az.agi().aBK();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      com.tencent.mm.ui.base.h.l(getContext(), 2131757322, 2131755906);
      c(2, parambo);
      this.HYO = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.HYR)
    {
      ac.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(parambo.field_msgId, parambo, paramInt1);
      a(parambo.field_msgId, "", ChattingItemTranslate.b.IpE);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.mxl = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new fy();
      ((fy)localObject).dgj.dgm = 1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new fy();
      ((fy)localObject).dgj.dgl = String.valueOf(parambo.field_msgId);
      ((fy)localObject).dgj.fileName = parambo.field_imgPath;
      ((fy)localObject).dgj.from = 1;
      ((fy)localObject).dgj.dgm = 0;
      ((fy)localObject).dgj.scene = foD();
      ((fy)localObject).dgj.dgn = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35686);
          if (!aw.this.Bk(Long.valueOf(this.CJI.dgj.dgl).longValue()))
          {
            AppMethodBeat.o(35686);
            return;
          }
          if (this.CJI.dgk.bhH)
          {
            if (bs.isNullOrNil(this.CJI.dgk.content))
            {
              if (this.CJI.dgk.state == 2)
              {
                ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.CJI.dgj.dgl });
                aw.a(aw.this, aw.a(aw.this).getString(2131757321));
              }
              aw.a(aw.this, Long.valueOf(this.CJI.dgj.dgl).longValue());
              aw.b(aw.this, Long.valueOf(this.CJI.dgj.dgl).longValue());
              aw.this.HYR = false;
              aw.b(aw.this);
            }
            for (;;)
            {
              aw.a(aw.this, parambo, paramInt1);
              AppMethodBeat.o(35686);
              return;
              ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.CJI.dgj.dgl });
              bo localbo = aw.c(aw.this, Long.valueOf(this.CJI.dgj.dgl).longValue());
              if (localbo != null)
              {
                aw.this.a(Long.valueOf(this.CJI.dgj.dgl).longValue(), this.CJI.dgk.content, ChattingItemTranslate.b.IpG);
                localbo.fcg();
                az.ayM();
                com.tencent.mm.model.c.awD().a(localbo.field_msgId, localbo);
                aw.b(aw.this, Long.valueOf(this.CJI.dgj.dgl).longValue());
                aw.b(aw.this);
                aw.a(aw.this, paramInt1);
              }
              aw.this.HYR = false;
            }
          }
          if (!bs.isNullOrNil(this.CJI.dgk.content))
          {
            aw.this.a(Long.valueOf(this.CJI.dgj.dgl).longValue(), this.CJI.dgk.content, ChattingItemTranslate.b.IpF);
            ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.CJI.dgj.dgl });
          }
          aw.b(aw.this);
          aw.a(aw.this, paramInt1);
          AppMethodBeat.o(35686);
        }
      };
      a(Long.valueOf(((fy)localObject).dgj.dgl).longValue(), "", ChattingItemTranslate.b.IpF);
      a(parambo.field_msgId, parambo, paramInt1);
      this.HYR = true;
      this.HYS = parambo.field_msgId;
      notifyDataSetChanged();
      abd(paramInt1);
      if (com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject))
      {
        ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        ac.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        aQs(getContext().getString(2131757321));
        Bi(Long.valueOf(((fy)localObject).dgj.dgl).longValue());
        Bm(Long.valueOf(((fy)localObject).dgj.dgl).longValue());
        this.HYR = false;
        g(parambo, paramInt1);
      }
    }
  }
  
  public final void abc(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.HYP = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.HYR) {
      a(Bl(this.HYS), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35714);
    ac.i("MicroMsg.TransformComponent", "[onChattingPause]");
    abc(3);
    AppMethodBeat.o(35714);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(35715);
    ac.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    foA();
    HYL.clear();
    HYM.clear();
    HYN.clear();
    if (this.HYR)
    {
      fy localfy = new fy();
      localfy.dgj.dgm = 3;
      com.tencent.mm.sdk.b.a.GpY.l(localfy);
      this.HYR = false;
    }
    ac.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35688);
        long l = System.currentTimeMillis();
        synchronized (aw.this)
        {
          aw.dhZ().clear();
          aw.foE().clear();
          ac.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(35688);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  public final boolean foB()
  {
    AppMethodBeat.i(35700);
    az.ayM();
    if (!((Boolean)com.tencent.mm.model.c.agA().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void foC()
  {
    AppMethodBeat.i(35701);
    az.ayM();
    com.tencent.mm.model.c.agA().set(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  /* Error */
  public final Pair<bo, Integer> foz()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 663
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/c/aw:HYM	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 667	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 673 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 678 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 682 1 0
    //   35: checkcast 684	java/util/Map$Entry
    //   38: invokeinterface 687 1 0
    //   43: checkcast 110	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 663
    //   50: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 663
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
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.HYV) {
      this.mxl = false;
    }
    this.HYV = paramInt1;
    AppMethodBeat.o(35716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aw
 * JD-Core Version:    0.7.0.1
 */