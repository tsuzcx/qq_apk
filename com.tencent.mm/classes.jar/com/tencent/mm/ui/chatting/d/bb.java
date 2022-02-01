package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gc.a;
import com.tencent.mm.g.a.gc.b;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=aq.class)
public class bb
  extends a
  implements aq
{
  private static HashMap<Long, String> KiN;
  private static HashMap<Long, ChattingItemTranslate.b> KiO;
  private static LinkedHashMap<Long, Pair<bv, Integer>> KiP;
  private static HashMap<Long, Boolean> KiQ;
  private boolean KiR;
  private boolean KiS;
  private List<Long> KiT;
  boolean KiU;
  long KiV;
  long KiW;
  boolean KiX;
  private int KiY;
  private boolean ncW;
  
  static
  {
    AppMethodBeat.i(35726);
    KiN = new HashMap();
    KiO = new HashMap();
    KiP = new LinkedHashMap();
    KiQ = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public bb()
  {
    AppMethodBeat.i(35689);
    this.KiR = false;
    this.ncW = false;
    this.KiS = false;
    this.KiT = new ArrayList();
    this.KiU = false;
    this.KiW = 0L;
    this.KiX = false;
    this.KiY = -1;
    AppMethodBeat.o(35689);
  }
  
  /* Error */
  private bv EA(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 92
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 62	com/tencent/mm/ui/chatting/d/bb:KiP	Ljava/util/LinkedHashMap;
    //   10: lload_1
    //   11: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokevirtual 102	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 104	android/util/Pair
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +14 -> 36
    //   25: aconst_null
    //   26: astore_3
    //   27: ldc 92
    //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: areturn
    //   36: aload_3
    //   37: getfield 108	android/util/Pair:first	Ljava/lang/Object;
    //   40: checkcast 110	com/tencent/mm/storage/bv
    //   43: astore_3
    //   44: ldc 92
    //   46: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -17 -> 32
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	bb
    //   0	57	1	paramLong	long
    //   20	24	3	localObject1	Object
    //   52	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   27	32	52	finally
    //   36	49	52	finally
  }
  
  private void EB(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (KiP.containsKey(Long.valueOf(paramLong))) {
        KiP.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void ED(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      KiQ.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Ex(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      KiN.remove(Long.valueOf(paramLong));
      KiO.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(35691);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong, bv parambv, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      KiP.put(Long.valueOf(paramLong), new Pair(parambv, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      parambv = finally;
      throw parambv;
    }
  }
  
  private void aXM(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.cXJ != null) && (this.cXJ.Kkd.getContext() != null))
    {
      paramString = Toast.makeText(this.cXJ.Kkd.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private void adW(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.ncW) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.e.a locala = this.cXJ;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locala, locala1.ahE(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.ca(((Integer)locala1.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void adX(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.KiR) && (this.KiT.size() > 0))
    {
      String str = ((Long)this.KiT.get(0)).toString();
      int i = 1;
      while (i < this.KiT.size())
      {
        str = str + ":" + this.KiT.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      int k = this.KiT.size();
      i = j;
      if (this.ncW) {
        i = 0;
      }
      localg.f(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.KiR = false;
      this.KiT.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private static void c(int paramInt, bv parambv)
  {
    AppMethodBeat.i(35706);
    if (parambv == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gg localgg = new gg();
    localgg.dsW.dsY = 0;
    localgg.dsW.dsZ = 0;
    localgg.dsW.dta = 0;
    localgg.dsW.dsX = 0;
    localgg.dsW.fileName = parambv.field_imgPath;
    localgg.dsW.result = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localgg);
    AppMethodBeat.o(35706);
  }
  
  private void fJh()
  {
    try
    {
      AppMethodBeat.i(35699);
      KiP.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int fJk()
  {
    AppMethodBeat.i(35713);
    int i;
    if (x.Ao(this.cXJ.getTalkerUserName()))
    {
      boolean bool = ((d)this.cXJ.bh(d.class)).fGK();
      if (((d)this.cXJ.bh(d.class)).fGJ()) {
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
      if (com.tencent.mm.al.g.Er(this.cXJ.getTalkerUserName()))
      {
        i = 3;
      }
      else if (com.tencent.mm.al.g.Es(this.cXJ.getTalkerUserName()))
      {
        i = 0;
      }
      else if (com.tencent.mm.al.g.En(this.cXJ.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.cXJ.fJB()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void g(final bv parambv, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 179	com/tencent/mm/ui/chatting/d/bb:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 401	com/tencent/mm/ui/chatting/e/a:fJE	()Lcom/tencent/mm/sdk/platformtools/aq;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 10	com/tencent/mm/ui/chatting/d/bb$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 404	com/tencent/mm/ui/chatting/d/bb$2:<init>	(Lcom/tencent/mm/ui/chatting/d/bb;ILcom/tencent/mm/storage/bv;)V
    //   34: invokevirtual 410	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
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
    //   0	57	0	this	bb
    //   0	57	1	parambv	bv
    //   0	57	2	paramInt	int
    //   18	31	3	localaq	com.tencent.mm.sdk.platformtools.aq
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.cXJ != null)
    {
      localObject = this.cXJ.Kkd.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = ak.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.cXJ != null) {
      this.cXJ.bPl();
    }
    AppMethodBeat.o(35708);
  }
  
  /* Error */
  public final boolean EC(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 421
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 64	com/tencent/mm/ui/chatting/d/bb:KiQ	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 422	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 124	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 425	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 421
    //   37: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 421
    //   49: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	bb
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
  
  public final ChattingItemTranslate.b Ey(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)KiO.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.KCw;
      }
      AppMethodBeat.o(35693);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean Ez(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 436
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/d/bb:KiP	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 117	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 436
    //   26: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 436
    //   38: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	bb
    //   0	51	1	paramLong	long
    //   22	13	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   23	29	44	finally
    //   35	41	44	finally
  }
  
  public final String O(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)KiN.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bu.isNullOrNil(str2))
      {
        paramString = o.aNX().aWb(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!bu.isNullOrNil(paramString.field_content)) {
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
      KiN.put(Long.valueOf(paramLong), paramString);
      KiO.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.KCz) {
        KiQ.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final bv parambv, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (parambv == null)
    {
      ae.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (EC(parambv.field_msgId))
    {
      ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambv.field_msgId), Boolean.valueOf(this.KiU) });
      parambv.fwn();
      ED(parambv.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((Ez(parambv.field_msgId)) && (paramBoolean))
    {
      if (Ey(parambv.field_msgId) == ChattingItemTranslate.b.KCx)
      {
        ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        EB(parambv.field_msgId);
        Ex(parambv.field_msgId);
        c(5, parambv);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        adX(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.KiU)
        {
          localObject = new gc();
          ((gc)localObject).dsL.dsO = 3;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          EB(parambv.field_msgId);
          Ex(parambv.field_msgId);
          parambv.fwn();
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
          this.KiU = false;
          g(parambv, -1);
        }
      }
    }
    Object localObject = o.aNX().aWb(parambv.field_imgPath);
    if ((localObject != null) && (!bu.isNullOrNil(((cn)localObject).field_content)))
    {
      ae.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambv.field_msgId), parambv.field_imgPath });
      parambv.fwo();
      a(parambv.field_msgId, ((cn)localObject).field_content, ChattingItemTranslate.b.KCz);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      this.KiR = false;
      adW(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = bc.ajj().aFd();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      h.l(getContext(), 2131757322, 2131755906);
      c(2, parambv);
      this.KiR = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.KiU)
    {
      ae.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(parambv.field_msgId, parambv, paramInt1);
      a(parambv.field_msgId, "", ChattingItemTranslate.b.KCx);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.ncW = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new gc();
      ((gc)localObject).dsL.dsO = 1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      ((at)this.cXJ.bh(at.class)).EH(parambv.field_msgId);
      localObject = new gc();
      ((gc)localObject).dsL.dsN = String.valueOf(parambv.field_msgId);
      ((gc)localObject).dsL.fileName = parambv.field_imgPath;
      ((gc)localObject).dsL.from = 1;
      ((gc)localObject).dsL.dsO = 0;
      ((gc)localObject).dsL.scene = fJk();
      ((gc)localObject).dsL.dsP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35686);
          if (!bb.this.Ez(Long.valueOf(this.EFz.dsL.dsN).longValue()))
          {
            AppMethodBeat.o(35686);
            return;
          }
          if (this.EFz.dsM.bsb)
          {
            if (bu.isNullOrNil(this.EFz.dsM.content))
            {
              if (this.EFz.dsM.state == 2)
              {
                ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.EFz.dsL.dsN });
                bb.a(bb.this, bb.a(bb.this).getString(2131757321));
              }
              bb.a(bb.this, Long.valueOf(this.EFz.dsL.dsN).longValue());
              bb.b(bb.this, Long.valueOf(this.EFz.dsL.dsN).longValue());
              bb.this.KiU = false;
              bb.b(bb.this);
            }
            for (;;)
            {
              bb.a(bb.this, parambv, paramInt1);
              AppMethodBeat.o(35686);
              return;
              ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.EFz.dsL.dsN });
              bv localbv = bb.c(bb.this, Long.valueOf(this.EFz.dsL.dsN).longValue());
              if (localbv != null)
              {
                bb.this.a(Long.valueOf(this.EFz.dsL.dsN).longValue(), this.EFz.dsM.content, ChattingItemTranslate.b.KCz);
                localbv.fwo();
                bc.aCg();
                com.tencent.mm.model.c.azI().a(localbv.field_msgId, localbv);
                bb.b(bb.this, Long.valueOf(this.EFz.dsL.dsN).longValue());
                bb.b(bb.this);
                bb.a(bb.this, paramInt1);
              }
              bb.this.KiU = false;
            }
          }
          if (!bu.isNullOrNil(this.EFz.dsM.content))
          {
            bb.this.a(Long.valueOf(this.EFz.dsL.dsN).longValue(), this.EFz.dsM.content, ChattingItemTranslate.b.KCy);
            ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.EFz.dsL.dsN });
          }
          bb.b(bb.this);
          bb.a(bb.this, paramInt1);
          AppMethodBeat.o(35686);
        }
      };
      a(Long.valueOf(((gc)localObject).dsL.dsN).longValue(), "", ChattingItemTranslate.b.KCy);
      a(parambv.field_msgId, parambv, paramInt1);
      this.KiU = true;
      this.KiV = parambv.field_msgId;
      notifyDataSetChanged();
      adW(paramInt1);
      if (com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject))
      {
        ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        ae.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        aXM(getContext().getString(2131757321));
        Ex(Long.valueOf(((gc)localObject).dsL.dsN).longValue());
        EB(Long.valueOf(((gc)localObject).dsL.dsN).longValue());
        this.KiU = false;
        g(parambv, paramInt1);
      }
    }
  }
  
  public final void adV(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.KiS = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.KiU) {
      a(EA(this.KiV), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final boolean bR(bv parambv)
  {
    AppMethodBeat.i(187414);
    if (parambv == null)
    {
      AppMethodBeat.o(187414);
      return false;
    }
    if (!bu.isNullOrNil(O(parambv.field_msgId, parambv.field_imgPath)))
    {
      AppMethodBeat.o(187414);
      return true;
    }
    AppMethodBeat.o(187414);
    return false;
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35714);
    ae.i("MicroMsg.TransformComponent", "[onChattingPause]");
    adV(3);
    AppMethodBeat.o(35714);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(35715);
    ae.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    fJh();
    KiO.clear();
    KiP.clear();
    KiQ.clear();
    if (this.KiU)
    {
      gc localgc = new gc();
      localgc.dsL.dsO = 3;
      com.tencent.mm.sdk.b.a.IvT.l(localgc);
      this.KiU = false;
    }
    ae.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35688);
        long l = System.currentTimeMillis();
        synchronized (bb.this)
        {
          bb.dvB().clear();
          bb.fJl().clear();
          ae.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(35688);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  /* Error */
  public final Pair<bv, Integer> fJg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 657
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 62	com/tencent/mm/ui/chatting/d/bb:KiP	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 661	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 667 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 672 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 676 1 0
    //   35: checkcast 678	java/util/Map$Entry
    //   38: invokeinterface 681 1 0
    //   43: checkcast 104	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 657
    //   50: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 657
    //   62: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bb
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean fJi()
  {
    AppMethodBeat.i(35700);
    bc.aCg();
    if (!((Boolean)com.tencent.mm.model.c.ajA().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void fJj()
  {
    AppMethodBeat.i(35701);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.KiY) {
      this.ncW = false;
    }
    this.KiY = paramInt1;
    AppMethodBeat.o(35716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bb
 * JD-Core Version:    0.7.0.1
 */