package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.aaj;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.gm.a;
import com.tencent.mm.f.a.gm.b;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.f.a.ro;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=au.class)
public class bh
  extends a
  implements au
{
  private static HashMap<Long, String> WPb;
  private static HashMap<Long, ChattingItemTranslate.c> WPc;
  private static LinkedHashMap<Long, Pair<ca, Integer>> WPd;
  private static HashMap<Long, Boolean> WPe;
  private static ArrayList<Long> WPf;
  private static HashMap<Long, a> WPg;
  private boolean MpG;
  private IListener<ro> WPh;
  private boolean WPi;
  private boolean WPj;
  private List<Long> WPk;
  boolean WPl;
  long WPm;
  long WPn;
  boolean WPo;
  private int WPp;
  
  static
  {
    AppMethodBeat.i(35726);
    WPb = new HashMap();
    WPc = new HashMap();
    WPd = new LinkedHashMap();
    WPe = new HashMap();
    WPf = new ArrayList();
    WPg = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public bh()
  {
    AppMethodBeat.i(35689);
    this.WPh = new IListener() {};
    this.WPi = false;
    this.MpG = false;
    this.WPj = false;
    this.WPk = new ArrayList();
    this.WPl = false;
    this.WPn = 0L;
    this.WPo = false;
    this.WPp = -1;
    AppMethodBeat.o(35689);
  }
  
  private void VM(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      WPb.remove(Long.valueOf(paramLong));
      WPc.remove(Long.valueOf(paramLong));
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
  private ca VP(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 75	com/tencent/mm/ui/chatting/d/bh:WPd	Ljava/util/LinkedHashMap;
    //   10: lload_1
    //   11: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokevirtual 130	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 132	android/util/Pair
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +14 -> 36
    //   25: aconst_null
    //   26: astore_3
    //   27: ldc 127
    //   29: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: areturn
    //   36: aload_3
    //   37: getfield 136	android/util/Pair:first	Ljava/lang/Object;
    //   40: checkcast 138	com/tencent/mm/storage/ca
    //   43: astore_3
    //   44: ldc 127
    //   46: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -17 -> 32
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	bh
    //   0	57	1	paramLong	long
    //   20	24	3	localObject1	Object
    //   52	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   27	32	52	finally
    //   36	49	52	finally
  }
  
  private void VQ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (WPd.containsKey(Long.valueOf(paramLong))) {
        WPd.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void VU(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      WPe.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong, ca paramca, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      WPd.put(Long.valueOf(paramLong), new Pair(paramca, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      paramca = finally;
      throw paramca;
    }
  }
  
  private void avI(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.MpG) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.e.a locala = this.fgR;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(locala, locala1.aFh(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.scrollToPosition(((Integer)locala1.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void avJ(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.WPi) && (this.WPk.size() > 0))
    {
      String str = ((Long)this.WPk.get(0)).toString();
      int i = 1;
      while (i < this.WPk.size())
      {
        str = str + ":" + this.WPk.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      int k = this.WPk.size();
      i = j;
      if (this.MpG) {
        i = 0;
      }
      localh.a(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.WPi = false;
      this.WPk.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private void bzs(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.fgR != null) && (this.fgR.WQv.getContext() != null))
    {
      paramString = Toast.makeText(this.fgR.WQv.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private static void d(int paramInt, ca paramca)
  {
    AppMethodBeat.i(35706);
    if (paramca == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gq localgq = new gq();
    localgq.fCV.fCX = 0;
    localgq.fCV.fCY = 0;
    localgq.fCV.fCZ = 0;
    localgq.fCV.fCW = 0;
    localgq.fCV.fileName = paramca.field_imgPath;
    localgq.fCV.result = paramInt;
    EventCenter.instance.publish(localgq);
    AppMethodBeat.o(35706);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.fgR != null)
    {
      localObject = this.fgR.WQv.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = MMApplicationContext.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  private void hQO()
  {
    try
    {
      AppMethodBeat.i(35699);
      WPd.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int hQR()
  {
    AppMethodBeat.i(35713);
    int i;
    if (ab.Qm(this.fgR.getTalkerUserName()))
    {
      boolean bool = ((d)this.fgR.bC(d.class)).hOf();
      if (((d)this.fgR.bC(d.class)).hOe()) {
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
      if (g.UB(this.fgR.getTalkerUserName()))
      {
        i = 3;
      }
      else if (g.UC(this.fgR.getTalkerUserName()))
      {
        i = 0;
      }
      else if (g.Ux(this.fgR.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.fgR.hRh()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void j(final ca paramca, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 422
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 202	com/tencent/mm/ui/chatting/d/bh:fgR	Lcom/tencent/mm/ui/chatting/e/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 426	com/tencent/mm/ui/chatting/e/a:hRl	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 12	com/tencent/mm/ui/chatting/d/bh$3
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 429	com/tencent/mm/ui/chatting/d/bh$3:<init>	(Lcom/tencent/mm/ui/chatting/d/bh;ILcom/tencent/mm/storage/ca;)V
    //   34: invokevirtual 435	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: ldc_w 422
    //   41: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	57	0	this	bh
    //   0	57	1	paramca	ca
    //   0	57	2	paramInt	int
    //   18	31	3	localMMHandler	com.tencent.mm.sdk.platformtools.MMHandler
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.fgR != null) {
      this.fgR.cAe();
    }
    AppMethodBeat.o(35708);
  }
  
  public final ChattingItemTranslate.c VN(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.c localc2 = (ChattingItemTranslate.c)WPc.get(Long.valueOf(paramLong));
      ChattingItemTranslate.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = ChattingItemTranslate.c.Xlo;
      }
      AppMethodBeat.o(35693);
      return localc1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean VO(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 452
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/d/bh:WPd	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 144	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 452
    //   26: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 452
    //   38: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	bh
    //   0	51	1	paramLong	long
    //   22	13	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   23	29	44	finally
    //   35	41	44	finally
  }
  
  public final boolean VR(long paramLong)
  {
    AppMethodBeat.i(269270);
    boolean bool = WPf.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(269270);
    return bool;
  }
  
  public final void VS(long paramLong)
  {
    AppMethodBeat.i(269271);
    WPf.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(269271);
  }
  
  /* Error */
  public final boolean VT(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 463
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 77	com/tencent/mm/ui/chatting/d/bh:WPe	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 443	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 149	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 466	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 463
    //   37: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 463
    //   49: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	bh
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
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.c paramc)
  {
    try
    {
      AppMethodBeat.i(35690);
      WPb.put(Long.valueOf(paramLong), paramString);
      WPc.put(Long.valueOf(paramLong), paramc);
      if (paramc == ChattingItemTranslate.c.Xlr) {
        WPe.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final ca paramca, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (paramca == null)
    {
      Log.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (VT(paramca.field_msgId))
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(paramca.field_msgId), Boolean.valueOf(this.WPl) });
      paramca.hAh();
      VU(paramca.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((VO(paramca.field_msgId)) && (paramBoolean))
    {
      if (VN(paramca.field_msgId) == ChattingItemTranslate.c.Xlp)
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        VQ(paramca.field_msgId);
        VM(paramca.field_msgId);
        d(5, paramca);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        avJ(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.WPl)
        {
          localObject = new gm();
          ((gm)localObject).fCK.fCN = 3;
          EventCenter.instance.publish((IEvent)localObject);
          VQ(paramca.field_msgId);
          VM(paramca.field_msgId);
          paramca.hAh();
          com.tencent.mm.model.bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
          this.WPl = false;
          j(paramca, -1);
        }
      }
    }
    Log.d("MicroMsg.TransformComponent", "voice to text, pos:%s", new Object[] { Integer.valueOf(paramInt1) });
    Object localObject = o.brA().bxz(paramca.field_imgPath);
    if ((localObject != null) && (!Util.isNullOrNil(((cv)localObject).field_content)))
    {
      Log.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_imgPath });
      paramca.hAi();
      a(paramca.field_msgId, ((cv)localObject).field_content, ChattingItemTranslate.c.Xlr);
      com.tencent.mm.model.bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      this.WPi = false;
      avI(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = com.tencent.mm.model.bh.aGY().bih();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      com.tencent.mm.ui.base.h.p(getContext(), R.l.exk, R.l.app_tip);
      d(2, paramca);
      this.WPi = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.WPl)
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(paramca.field_msgId, paramca, paramInt1);
      a(paramca.field_msgId, "", ChattingItemTranslate.c.Xlp);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.MpG = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new gm();
      ((gm)localObject).fCK.fCN = 1;
      EventCenter.instance.publish((IEvent)localObject);
      ((ax)this.fgR.bC(ax.class)).VY(paramca.field_msgId);
      localObject = new gm();
      ((gm)localObject).fCK.fCM = String.valueOf(paramca.field_msgId);
      ((gm)localObject).fCK.fileName = paramca.field_imgPath;
      ((gm)localObject).fCK.from = 1;
      ((gm)localObject).fCK.fCN = 0;
      ((gm)localObject).fCK.scene = hQR();
      ((gm)localObject).fCK.fCO = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35687);
          if (!bh.this.VO(Long.valueOf(this.QsJ.fCK.fCM).longValue()))
          {
            AppMethodBeat.o(35687);
            return;
          }
          if (this.QsJ.fCL.bby)
          {
            if (Util.isNullOrNil(this.QsJ.fCL.content))
            {
              if (this.QsJ.fCL.state == 2)
              {
                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.QsJ.fCK.fCM });
                bh.a(bh.this, bh.a(bh.this).getString(R.l.exj));
              }
              bh.a(bh.this, Long.valueOf(this.QsJ.fCK.fCM).longValue());
              bh.b(bh.this, Long.valueOf(this.QsJ.fCK.fCM).longValue());
              bh.this.WPl = false;
              bh.b(bh.this);
            }
            while (34 == paramca.getType())
            {
              bh.WPg.put(Long.valueOf(paramca.field_msgId), new bh.a(paramca, paramInt1));
              AppMethodBeat.o(35687);
              return;
              Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.QsJ.fCK.fCM });
              ca localca = bh.c(bh.this, Long.valueOf(this.QsJ.fCK.fCM).longValue());
              if (localca != null)
              {
                bh.this.a(Long.valueOf(this.QsJ.fCK.fCM).longValue(), this.QsJ.fCL.content, ChattingItemTranslate.c.Xlr);
                localca.hAi();
                com.tencent.mm.model.bh.beI();
                com.tencent.mm.model.c.bbO().a(localca.field_msgId, localca);
                bh.b(bh.this, Long.valueOf(this.QsJ.fCK.fCM).longValue());
                bh.b(bh.this);
                bh.a(bh.this, paramInt1);
              }
              bh.this.WPl = false;
            }
            bh.a(bh.this, paramca, paramInt1);
            AppMethodBeat.o(35687);
            return;
          }
          if (!Util.isNullOrNil(this.QsJ.fCL.content))
          {
            bh.this.a(Long.valueOf(this.QsJ.fCK.fCM).longValue(), this.QsJ.fCL.content, ChattingItemTranslate.c.Xlq);
            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.QsJ.fCK.fCM });
          }
          bh.b(bh.this);
          bh.a(bh.this, paramInt1);
          AppMethodBeat.o(35687);
        }
      };
      if (34 == paramca.getType()) {
        WPf.add(Long.valueOf(paramca.field_msgId));
      }
      a(Long.valueOf(((gm)localObject).fCK.fCM).longValue(), "", ChattingItemTranslate.c.Xlq);
      a(paramca.field_msgId, paramca, paramInt1);
      this.WPl = true;
      this.WPm = paramca.field_msgId;
      notifyDataSetChanged();
      avI(paramInt1);
      if (EventCenter.instance.publish((IEvent)localObject))
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        bzs(getContext().getString(R.l.exj));
        VM(Long.valueOf(((gm)localObject).fCK.fCM).longValue());
        VQ(Long.valueOf(((gm)localObject).fCK.fCM).longValue());
        this.WPl = false;
        j(paramca, paramInt1);
      }
    }
  }
  
  public final String ae(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)WPb.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (Util.isNullOrNil(str2))
      {
        paramString = o.brA().bxz(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!Util.isNullOrNil(paramString.field_content)) {
            str1 = paramString.field_content;
          }
        }
      }
      AppMethodBeat.o(35692);
      return str1;
    }
    finally {}
  }
  
  public final void avH(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.WPj = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.WPl) {
      a(VP(this.WPm), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final boolean cA(ca paramca)
  {
    AppMethodBeat.i(269269);
    if (paramca == null)
    {
      AppMethodBeat.o(269269);
      return false;
    }
    if (!Util.isNullOrNil(ae(paramca.field_msgId, paramca.field_imgPath)))
    {
      AppMethodBeat.o(269269);
      return true;
    }
    AppMethodBeat.o(269269);
    return false;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(269276);
    super.hGV();
    this.WPh.alive();
    AppMethodBeat.o(269276);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35714);
    Log.i("MicroMsg.TransformComponent", "[onChattingPause]");
    avH(3);
    AppMethodBeat.o(35714);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(269277);
    super.hGZ();
    this.WPh.dead();
    AppMethodBeat.o(269277);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(35715);
    Log.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    hQO();
    WPc.clear();
    WPd.clear();
    WPe.clear();
    if (this.WPl)
    {
      gm localgm = new gm();
      localgm.fCK.fCN = 3;
      EventCenter.instance.publish(localgm);
      this.WPl = false;
    }
    Log.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(274946);
        long l = System.currentTimeMillis();
        synchronized (bh.this)
        {
          bh.gLQ().clear();
          bh.hQS().clear();
          Log.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(274946);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  /* Error */
  public final Pair<ca, Integer> hQN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 722
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/d/bh:WPd	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 726	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 732 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 737 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 741 1 0
    //   35: checkcast 743	java/util/Map$Entry
    //   38: invokeinterface 746 1 0
    //   43: checkcast 132	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 722
    //   50: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 722
    //   62: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bh
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean hQP()
  {
    AppMethodBeat.i(35700);
    com.tencent.mm.model.bh.beI();
    if (!((Boolean)com.tencent.mm.model.c.aHp().b(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void hQQ()
  {
    AppMethodBeat.i(35701);
    com.tencent.mm.model.bh.beI();
    com.tencent.mm.model.c.aHp().i(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.WPp) {
      this.MpG = false;
    }
    this.WPp = paramInt1;
    AppMethodBeat.o(35716);
  }
  
  static final class a
  {
    ca fNz;
    int pos;
    
    public a(ca paramca, int paramInt)
    {
      this.fNz = paramca;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bh
 * JD-Core Version:    0.7.0.1
 */