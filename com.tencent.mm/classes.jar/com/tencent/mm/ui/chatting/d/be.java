package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gf.a;
import com.tencent.mm.g.a.gf.b;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.storage.cu;
import com.tencent.mm.storage.cv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=at.class)
public class be
  extends a
  implements at
{
  private static HashMap<Long, String> PuI;
  private static HashMap<Long, ChattingItemTranslate.c> PuJ;
  private static LinkedHashMap<Long, Pair<ca, Integer>> PuK;
  private static HashMap<Long, Boolean> PuL;
  private static ArrayList<Long> PuM;
  private static HashMap<Long, a> PuN;
  private IListener<qo> PuO;
  private boolean PuP;
  private boolean PuQ;
  private List<Long> PuR;
  boolean PuS;
  long PuT;
  long PuU;
  boolean PuV;
  private int PuW;
  private boolean ooc;
  
  static
  {
    AppMethodBeat.i(35726);
    PuI = new HashMap();
    PuJ = new HashMap();
    PuK = new LinkedHashMap();
    PuL = new HashMap();
    PuM = new ArrayList();
    PuN = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public be()
  {
    AppMethodBeat.i(35689);
    this.PuO = new IListener() {};
    this.PuP = false;
    this.ooc = false;
    this.PuQ = false;
    this.PuR = new ArrayList();
    this.PuS = false;
    this.PuU = 0L;
    this.PuV = false;
    this.PuW = -1;
    AppMethodBeat.o(35689);
  }
  
  private void NA(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      PuI.remove(Long.valueOf(paramLong));
      PuJ.remove(Long.valueOf(paramLong));
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
  private ca ND(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 75	com/tencent/mm/ui/chatting/d/be:PuK	Ljava/util/LinkedHashMap;
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
    //   0	57	0	this	be
    //   0	57	1	paramLong	long
    //   20	24	3	localObject1	Object
    //   52	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   27	32	52	finally
    //   36	49	52	finally
  }
  
  private void NE(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (PuK.containsKey(Long.valueOf(paramLong))) {
        PuK.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  private void NI(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      PuL.put(Long.valueOf(paramLong), Boolean.FALSE);
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
      PuK.put(Long.valueOf(paramLong), new Pair(paramca, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      paramca = finally;
      throw paramca;
    }
  }
  
  private void amH(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.ooc) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.e.a locala = this.dom;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locala, locala1.axQ(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.scrollToPosition(((Integer)locala1.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void amI(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.PuP) && (this.PuR.size() > 0))
    {
      String str = ((Long)this.PuR.get(0)).toString();
      int i = 1;
      while (i < this.PuR.size())
      {
        str = str + ":" + this.PuR.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      int k = this.PuR.size();
      i = j;
      if (this.ooc) {
        i = 0;
      }
      localh.a(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.PuP = false;
      this.PuR.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private void bmR(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.dom != null) && (this.dom.Pwc.getContext() != null))
    {
      paramString = Toast.makeText(this.dom.Pwc.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private static void c(int paramInt, ca paramca)
  {
    AppMethodBeat.i(35706);
    if (paramca == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    gj localgj = new gj();
    localgj.dKg.dKi = 0;
    localgj.dKg.dKj = 0;
    localgj.dKg.dKk = 0;
    localgj.dKg.dKh = 0;
    localgj.dKg.fileName = paramca.field_imgPath;
    localgj.dKg.result = paramInt;
    EventCenter.instance.publish(localgj);
    AppMethodBeat.o(35706);
  }
  
  /* Error */
  private void g(final ca paramca, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 374
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 202	com/tencent/mm/ui/chatting/d/be:dom	Lcom/tencent/mm/ui/chatting/e/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 378	com/tencent/mm/ui/chatting/e/a:gRP	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 12	com/tencent/mm/ui/chatting/d/be$3
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 381	com/tencent/mm/ui/chatting/d/be$3:<init>	(Lcom/tencent/mm/ui/chatting/d/be;ILcom/tencent/mm/storage/ca;)V
    //   34: invokevirtual 387	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: ldc_w 374
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
    //   0	57	0	this	be
    //   0	57	1	paramca	ca
    //   0	57	2	paramInt	int
    //   18	31	3	localMMHandler	com.tencent.mm.sdk.platformtools.MMHandler
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private void gRr()
  {
    try
    {
      AppMethodBeat.i(35699);
      PuK.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int gRu()
  {
    AppMethodBeat.i(35713);
    int i;
    if (ab.IT(this.dom.getTalkerUserName()))
    {
      boolean bool = ((d)this.dom.bh(d.class)).gOQ();
      if (((d)this.dom.bh(d.class)).gOP()) {
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
      if (g.Nf(this.dom.getTalkerUserName()))
      {
        i = 3;
      }
      else if (g.Ng(this.dom.getTalkerUserName()))
      {
        i = 0;
      }
      else if (g.Nb(this.dom.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.dom.gRL()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.dom != null)
    {
      localObject = this.dom.Pwc.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = MMApplicationContext.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.dom != null) {
      this.dom.cmy();
    }
    AppMethodBeat.o(35708);
  }
  
  public final ChattingItemTranslate.c NB(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.c localc2 = (ChattingItemTranslate.c)PuJ.get(Long.valueOf(paramLong));
      ChattingItemTranslate.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = ChattingItemTranslate.c.PPm;
      }
      AppMethodBeat.o(35693);
      return localc1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean NC(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 451
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/d/be:PuK	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 144	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 451
    //   26: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 451
    //   38: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	be
    //   0	51	1	paramLong	long
    //   22	13	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   23	29	44	finally
    //   35	41	44	finally
  }
  
  public final boolean NF(long paramLong)
  {
    AppMethodBeat.i(233199);
    boolean bool = PuM.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(233199);
    return bool;
  }
  
  public final void NG(long paramLong)
  {
    AppMethodBeat.i(233200);
    PuM.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(233200);
  }
  
  /* Error */
  public final boolean NH(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 462
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 77	com/tencent/mm/ui/chatting/d/be:PuL	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 442	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 149	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 465	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 462
    //   37: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 462
    //   49: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	be
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
  
  public final String S(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)PuI.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (Util.isNullOrNil(str2))
      {
        paramString = o.bic().bkZ(paramString);
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
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.c paramc)
  {
    try
    {
      AppMethodBeat.i(35690);
      PuI.put(Long.valueOf(paramLong), paramString);
      PuJ.put(Long.valueOf(paramLong), paramc);
      if (paramc == ChattingItemTranslate.c.PPp) {
        PuL.put(Long.valueOf(paramLong), Boolean.TRUE);
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
    if (NH(paramca.field_msgId))
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(paramca.field_msgId), Boolean.valueOf(this.PuS) });
      paramca.gDT();
      NI(paramca.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((NC(paramca.field_msgId)) && (paramBoolean))
    {
      if (NB(paramca.field_msgId) == ChattingItemTranslate.c.PPn)
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        NE(paramca.field_msgId);
        NA(paramca.field_msgId);
        c(5, paramca);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        amI(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.PuS)
        {
          localObject = new gf();
          ((gf)localObject).dJV.dJY = 3;
          EventCenter.instance.publish((IEvent)localObject);
          NE(paramca.field_msgId);
          NA(paramca.field_msgId);
          paramca.gDT();
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
          this.PuS = false;
          g(paramca, -1);
        }
      }
    }
    Log.d("MicroMsg.TransformComponent", "voice to text, pos:%s", new Object[] { Integer.valueOf(paramInt1) });
    Object localObject = o.bic().bkZ(paramca.field_imgPath);
    if ((localObject != null) && (!Util.isNullOrNil(((cu)localObject).field_content)))
    {
      Log.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_imgPath });
      paramca.gDU();
      a(paramca.field_msgId, ((cu)localObject).field_content, ChattingItemTranslate.c.PPp);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      this.PuP = false;
      amH(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = bg.azz().aYS();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      com.tencent.mm.ui.base.h.n(getContext(), 2131757536, 2131755998);
      c(2, paramca);
      this.PuP = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.PuS)
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(paramca.field_msgId, paramca, paramInt1);
      a(paramca.field_msgId, "", ChattingItemTranslate.c.PPn);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.ooc = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new gf();
      ((gf)localObject).dJV.dJY = 1;
      EventCenter.instance.publish((IEvent)localObject);
      ((aw)this.dom.bh(aw.class)).NM(paramca.field_msgId);
      localObject = new gf();
      ((gf)localObject).dJV.dJX = String.valueOf(paramca.field_msgId);
      ((gf)localObject).dJV.fileName = paramca.field_imgPath;
      ((gf)localObject).dJV.from = 1;
      ((gf)localObject).dJV.dJY = 0;
      ((gf)localObject).dJV.scene = gRu();
      ((gf)localObject).dJV.dJZ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35687);
          if (!be.this.NC(Long.valueOf(this.Jvc.dJV.dJX).longValue()))
          {
            AppMethodBeat.o(35687);
            return;
          }
          if (this.Jvc.dJW.brW)
          {
            if (Util.isNullOrNil(this.Jvc.dJW.content))
            {
              if (this.Jvc.dJW.state == 2)
              {
                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.Jvc.dJV.dJX });
                be.a(be.this, be.a(be.this).getString(2131757535));
              }
              be.a(be.this, Long.valueOf(this.Jvc.dJV.dJX).longValue());
              be.b(be.this, Long.valueOf(this.Jvc.dJV.dJX).longValue());
              be.this.PuS = false;
              be.b(be.this);
            }
            while (34 == paramca.getType())
            {
              be.PuN.put(Long.valueOf(paramca.field_msgId), new be.a(paramca, paramInt1));
              AppMethodBeat.o(35687);
              return;
              Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.Jvc.dJV.dJX });
              ca localca = be.c(be.this, Long.valueOf(this.Jvc.dJV.dJX).longValue());
              if (localca != null)
              {
                be.this.a(Long.valueOf(this.Jvc.dJV.dJX).longValue(), this.Jvc.dJW.content, ChattingItemTranslate.c.PPp);
                localca.gDU();
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(localca.field_msgId, localca);
                be.b(be.this, Long.valueOf(this.Jvc.dJV.dJX).longValue());
                be.b(be.this);
                be.a(be.this, paramInt1);
              }
              be.this.PuS = false;
            }
            be.a(be.this, paramca, paramInt1);
            AppMethodBeat.o(35687);
            return;
          }
          if (!Util.isNullOrNil(this.Jvc.dJW.content))
          {
            be.this.a(Long.valueOf(this.Jvc.dJV.dJX).longValue(), this.Jvc.dJW.content, ChattingItemTranslate.c.PPo);
            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.Jvc.dJV.dJX });
          }
          be.b(be.this);
          be.a(be.this, paramInt1);
          AppMethodBeat.o(35687);
        }
      };
      if (34 == paramca.getType()) {
        PuM.add(Long.valueOf(paramca.field_msgId));
      }
      a(Long.valueOf(((gf)localObject).dJV.dJX).longValue(), "", ChattingItemTranslate.c.PPo);
      a(paramca.field_msgId, paramca, paramInt1);
      this.PuS = true;
      this.PuT = paramca.field_msgId;
      notifyDataSetChanged();
      amH(paramInt1);
      if (EventCenter.instance.publish((IEvent)localObject))
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        bmR(getContext().getString(2131757535));
        NA(Long.valueOf(((gf)localObject).dJV.dJX).longValue());
        NE(Long.valueOf(((gf)localObject).dJV.dJX).longValue());
        this.PuS = false;
        g(paramca, paramInt1);
      }
    }
  }
  
  public final void amG(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.PuQ = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.PuS) {
      a(ND(this.PuT), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35714);
    Log.i("MicroMsg.TransformComponent", "[onChattingPause]");
    amG(3);
    AppMethodBeat.o(35714);
  }
  
  public final boolean ch(ca paramca)
  {
    AppMethodBeat.i(233198);
    if (paramca == null)
    {
      AppMethodBeat.o(233198);
      return false;
    }
    if (!Util.isNullOrNil(S(paramca.field_msgId, paramca.field_imgPath)))
    {
      AppMethodBeat.o(233198);
      return true;
    }
    AppMethodBeat.o(233198);
    return false;
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(233201);
    super.gIl();
    this.PuO.alive();
    AppMethodBeat.o(233201);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(233202);
    super.gIn();
    this.PuO.dead();
    AppMethodBeat.o(233202);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(35715);
    Log.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    gRr();
    PuJ.clear();
    PuK.clear();
    PuL.clear();
    if (this.PuS)
    {
      gf localgf = new gf();
      localgf.dJV.dJY = 3;
      EventCenter.instance.publish(localgf);
      this.PuS = false;
    }
    Log.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233197);
        long l = System.currentTimeMillis();
        synchronized (be.this)
        {
          be.fTk().clear();
          be.gRv().clear();
          Log.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(233197);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  /* Error */
  public final Pair<ca, Integer> gRq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 713
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/d/be:PuK	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 717	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 723 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 728 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 732 1 0
    //   35: checkcast 734	java/util/Map$Entry
    //   38: invokeinterface 737 1 0
    //   43: checkcast 132	android/util/Pair
    //   46: astore_1
    //   47: ldc_w 713
    //   50: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 713
    //   62: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	be
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean gRs()
  {
    AppMethodBeat.i(35700);
    bg.aVF();
    if (!((Boolean)com.tencent.mm.model.c.azQ().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void gRt()
  {
    AppMethodBeat.i(35701);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.PuW) {
      this.ooc = false;
    }
    this.PuW = paramInt1;
    AppMethodBeat.o(35716);
  }
  
  static final class a
  {
    ca dTX;
    int pos;
    
    public a(ca paramca, int paramInt)
    {
      this.dTX = paramca;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.be
 * JD-Core Version:    0.7.0.1
 */