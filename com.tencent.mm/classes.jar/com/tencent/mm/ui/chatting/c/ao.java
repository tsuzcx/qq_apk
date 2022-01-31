package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fr.a;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ag.class)
public class ao
  extends a
  implements ag
{
  private static HashMap<Long, String> zIK;
  private static HashMap<Long, ChattingItemTranslate.b> zIL;
  private static LinkedHashMap<Long, Pair<bi, Integer>> zIM;
  private static HashMap<Long, Boolean> zIN;
  private boolean jfe;
  private boolean zIO;
  private boolean zIP;
  private List<Long> zIQ;
  boolean zIR;
  long zIS;
  long zIT;
  boolean zIU;
  private int zIV;
  
  static
  {
    AppMethodBeat.i(31823);
    zIK = new HashMap();
    zIL = new HashMap();
    zIM = new LinkedHashMap();
    zIN = new HashMap();
    AppMethodBeat.o(31823);
  }
  
  public ao()
  {
    AppMethodBeat.i(31786);
    this.zIO = false;
    this.jfe = false;
    this.zIP = false;
    this.zIQ = new ArrayList();
    this.zIR = false;
    this.zIT = 0L;
    this.zIU = false;
    this.zIV = -1;
    AppMethodBeat.o(31786);
  }
  
  private void PL(int paramInt)
  {
    AppMethodBeat.i(31801);
    if ((this.jfe) && (paramInt != -1)) {
      this.caz.bJ(paramInt);
    }
    AppMethodBeat.o(31801);
  }
  
  private void PM(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(31802);
    if ((this.zIO) && (this.zIQ.size() > 0))
    {
      String str = ((Long)this.zIQ.get(0)).toString();
      int i = 1;
      while (i < this.zIQ.size())
      {
        str = str + ":" + this.zIQ.get(i);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
      int k = this.zIQ.size();
      i = j;
      if (this.jfe) {
        i = 0;
      }
      localh.e(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.zIO = false;
      this.zIQ.clear();
    }
    AppMethodBeat.o(31802);
  }
  
  private void a(long paramLong, bi parambi, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31791);
      zIM.put(Long.valueOf(paramLong), new Pair(parambi, Integer.valueOf(paramInt)));
      AppMethodBeat.o(31791);
      return;
    }
    finally
    {
      parambi = finally;
      throw parambi;
    }
  }
  
  private void aub(String paramString)
  {
    AppMethodBeat.i(31807);
    if ((this.caz != null) && (this.caz.zJz.getContext() != null))
    {
      paramString = Toast.makeText(this.caz.zJz.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(31807);
  }
  
  private static void c(int paramInt, bi parambi)
  {
    AppMethodBeat.i(31803);
    if (parambi == null)
    {
      AppMethodBeat.o(31803);
      return;
    }
    fv localfv = new fv();
    localfv.cue.cug = 0;
    localfv.cue.cuh = 0;
    localfv.cue.cui = 0;
    localfv.cue.cuf = 0;
    localfv.cue.fileName = parambi.field_imgPath;
    localfv.cue.result = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localfv);
    AppMethodBeat.o(31803);
  }
  
  private void dJq()
  {
    try
    {
      AppMethodBeat.i(31796);
      zIM.clear();
      AppMethodBeat.o(31796);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int dJt()
  {
    AppMethodBeat.i(31810);
    int i;
    if (t.nU(this.caz.getTalkerUserName()))
    {
      boolean bool = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw();
      if (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()) {
        if (bool) {
          i = 5;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31810);
      return i;
      i = 4;
      continue;
      if (f.rW(this.caz.getTalkerUserName()))
      {
        i = 3;
      }
      else if (f.rX(this.caz.getTalkerUserName()))
      {
        i = 0;
      }
      else if (f.rT(this.caz.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.caz.dJF()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  private void g(bi parambi, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 31804
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 86	com/tencent/mm/ui/chatting/c/ao:caz	Lcom/tencent/mm/ui/chatting/d/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 312	com/tencent/mm/ui/chatting/d/a:dJI	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 314	com/tencent/mm/ui/chatting/c/ao$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 317	com/tencent/mm/ui/chatting/c/ao$2:<init>	(Lcom/tencent/mm/ui/chatting/c/ao;ILcom/tencent/mm/storage/bi;)V
    //   34: invokevirtual 323	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: sipush 31804
    //   41: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	57	0	this	ao
    //   0	57	1	parambi	bi
    //   0	57	2	paramInt	int
    //   18	31	3	localak	com.tencent.mm.sdk.platformtools.ak
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(31806);
    if (this.caz != null)
    {
      localObject = this.caz.zJz.getContext();
      AppMethodBeat.o(31806);
      return localObject;
    }
    Object localObject = ah.getContext();
    AppMethodBeat.o(31806);
    return localObject;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(31805);
    if (this.caz != null) {
      this.caz.aWN();
    }
    AppMethodBeat.o(31805);
  }
  
  private void oE(long paramLong)
  {
    try
    {
      AppMethodBeat.i(31788);
      zIK.remove(Long.valueOf(paramLong));
      zIL.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(31788);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private bi oH(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 31793
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 55	com/tencent/mm/ui/chatting/c/ao:zIM	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 335	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 154	android/util/Pair
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +15 -> 38
    //   26: aconst_null
    //   27: astore_3
    //   28: sipush 31793
    //   31: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: aload_3
    //   39: getfield 339	android/util/Pair:first	Ljava/lang/Object;
    //   42: checkcast 341	com/tencent/mm/storage/bi
    //   45: astore_3
    //   46: sipush 31793
    //   49: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -18 -> 34
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ao
    //   0	60	1	paramLong	long
    //   21	25	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	55	finally
    //   28	34	55	finally
    //   38	52	55	finally
  }
  
  private void oI(long paramLong)
  {
    try
    {
      AppMethodBeat.i(31795);
      if (zIM.containsKey(Long.valueOf(paramLong))) {
        zIM.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(31795);
      return;
    }
    finally {}
  }
  
  private void oK(long paramLong)
  {
    try
    {
      AppMethodBeat.i(31809);
      zIN.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(31809);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String D(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(31789);
      String str2 = (String)zIK.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bo.isNullOrNil(str2))
      {
        paramString = o.amt().asI(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!bo.isNullOrNil(paramString.field_content)) {
            str1 = paramString.field_content;
          }
        }
      }
      AppMethodBeat.o(31789);
      return str1;
    }
    finally {}
  }
  
  public final void PK(int paramInt)
  {
    AppMethodBeat.i(31799);
    if (paramInt == 2)
    {
      this.zIP = true;
      AppMethodBeat.o(31799);
      return;
    }
    if (this.zIR) {
      a(oH(this.zIS), true, -1, paramInt);
    }
    AppMethodBeat.o(31799);
  }
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.b paramb)
  {
    try
    {
      AppMethodBeat.i(31787);
      zIK.put(Long.valueOf(paramLong), paramString);
      zIL.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.zXx) {
        zIN.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(31787);
      return;
    }
    finally {}
  }
  
  public final void a(bi parambi, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31800);
    if (parambi == null)
    {
      ab.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(31800);
      return;
    }
    if (oJ(parambi.field_msgId))
    {
      ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambi.field_msgId), Boolean.valueOf(this.zIR) });
      parambi.dyo();
      oK(parambi.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(31800);
      return;
    }
    if ((oG(parambi.field_msgId)) && (paramBoolean))
    {
      if (oF(parambi.field_msgId) == ChattingItemTranslate.b.zXv)
      {
        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        oI(parambi.field_msgId);
        oE(parambi.field_msgId);
        c(5, parambi);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        PM(paramInt2);
        AppMethodBeat.o(31800);
        return;
        if (this.zIR)
        {
          localObject = new fr();
          ((fr)localObject).ctT.ctW = 3;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
          oI(parambi.field_msgId);
          oE(parambi.field_msgId);
          parambi.dyo();
          aw.aaz();
          c.YC().a(parambi.field_msgId, parambi);
          this.zIR = false;
          g(parambi, -1);
        }
      }
    }
    Object localObject = o.amt().asI(parambi.field_imgPath);
    if ((localObject != null) && (!bo.isNullOrNil(((cc)localObject).field_content)))
    {
      ab.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambi.field_msgId), parambi.field_imgPath });
      parambi.dyp();
      a(parambi.field_msgId, ((cc)localObject).field_content, ChattingItemTranslate.b.zXx);
      aw.aaz();
      c.YC().a(parambi.field_msgId, parambi);
      this.zIO = false;
      PL(paramInt1);
      AppMethodBeat.o(31800);
      return;
    }
    paramInt2 = aw.Rc().adt();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      com.tencent.mm.ui.base.h.h(getContext(), 2131298331, 2131297087);
      c(2, parambi);
      this.zIO = false;
      AppMethodBeat.o(31800);
      return;
    }
    if (this.zIR)
    {
      ab.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(parambi.field_msgId, parambi, paramInt1);
      a(parambi.field_msgId, "", ChattingItemTranslate.b.zXv);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jfe = true;
      }
      AppMethodBeat.o(31800);
      return;
      localObject = new fr();
      ((fr)localObject).ctT.ctW = 1;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      localObject = new fr();
      ((fr)localObject).ctT.ctV = String.valueOf(parambi.field_msgId);
      ((fr)localObject).ctT.fileName = parambi.field_imgPath;
      ((fr)localObject).ctT.from = 1;
      ((fr)localObject).ctT.ctW = 0;
      ((fr)localObject).ctT.scene = dJt();
      ((fr)localObject).ctT.ctX = new ao.1(this, (fr)localObject, paramInt1, parambi);
      a(Long.valueOf(((fr)localObject).ctT.ctV).longValue(), "", ChattingItemTranslate.b.zXw);
      a(parambi.field_msgId, parambi, paramInt1);
      this.zIR = true;
      this.zIS = parambi.field_msgId;
      notifyDataSetChanged();
      PL(paramInt1);
      if (com.tencent.mm.sdk.b.a.ymk.l((b)localObject))
      {
        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        aub(getContext().getString(2131298330));
        oE(Long.valueOf(((fr)localObject).ctT.ctV).longValue());
        oI(Long.valueOf(((fr)localObject).ctT.ctV).longValue());
        this.zIR = false;
        g(parambi, paramInt1);
      }
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31811);
    ab.i("MicroMsg.TransformComponent", "[onChattingPause]");
    PK(3);
    AppMethodBeat.o(31811);
  }
  
  public final void dCe()
  {
    AppMethodBeat.i(31812);
    ab.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    dJq();
    zIL.clear();
    zIM.clear();
    zIN.clear();
    if (this.zIR)
    {
      fr localfr = new fr();
      localfr.ctT.ctW = 3;
      com.tencent.mm.sdk.b.a.ymk.l(localfr);
      this.zIR = false;
    }
    ab.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.g.d.post(new ao.3(this), "UnsetTransformFlag");
    AppMethodBeat.o(31812);
  }
  
  /* Error */
  public final Pair<bi, Integer> dJp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 31794
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 55	com/tencent/mm/ui/chatting/c/ao:zIM	Ljava/util/LinkedHashMap;
    //   11: invokevirtual 576	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 582 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 587 1 0
    //   26: ifeq +31 -> 57
    //   29: aload_1
    //   30: invokeinterface 591 1 0
    //   35: checkcast 593	java/util/Map$Entry
    //   38: invokeinterface 596 1 0
    //   43: checkcast 154	android/util/Pair
    //   46: astore_1
    //   47: sipush 31794
    //   50: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: sipush 31794
    //   62: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ao
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean dJr()
  {
    AppMethodBeat.i(31797);
    aw.aaz();
    if (!((Boolean)c.Ru().get(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(31797);
      return true;
    }
    AppMethodBeat.o(31797);
    return false;
  }
  
  public final void dJs()
  {
    AppMethodBeat.i(31798);
    aw.aaz();
    c.Ru().set(75, Boolean.TRUE);
    AppMethodBeat.o(31798);
  }
  
  public final ChattingItemTranslate.b oF(long paramLong)
  {
    try
    {
      AppMethodBeat.i(31790);
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)zIL.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.zXu;
      }
      AppMethodBeat.o(31790);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean oG(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 31792
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 55	com/tencent/mm/ui/chatting/c/ao:zIM	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 345	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: sipush 31792
    //   26: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: sipush 31792
    //   38: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ao
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
  public final boolean oJ(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 31808
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 57	com/tencent/mm/ui/chatting/c/ao:zIN	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 357	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 349	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 611	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: sipush 31808
    //   37: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: sipush 31808
    //   49: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ao
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
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(31813);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.zIV) {
      this.jfe = false;
    }
    this.zIV = paramInt1;
    AppMethodBeat.o(31813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao
 * JD-Core Version:    0.7.0.1
 */