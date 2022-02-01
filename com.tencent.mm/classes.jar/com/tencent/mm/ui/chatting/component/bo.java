package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acg;
import com.tencent.mm.autogen.a.gx;
import com.tencent.mm.autogen.a.gx.a;
import com.tencent.mm.autogen.a.gx.b;
import com.tencent.mm.autogen.a.hb;
import com.tencent.mm.autogen.a.td;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cy;
import com.tencent.mm.storage.cz;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bb;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=bb.class)
public class bo
  extends a
  implements bb
{
  private static HashMap<Long, String> aexG;
  private static HashMap<Long, ChattingItemTranslate.c> aexH;
  private static LinkedHashMap<Long, Pair<cc, Integer>> aexI;
  private static HashMap<Long, Boolean> aexJ;
  private static ArrayList<Long> aexK;
  private static HashMap<Long, a> aexL;
  private boolean STa;
  private IListener<td> aexM;
  private boolean aexN;
  private boolean aexO;
  private List<Long> aexP;
  boolean aexQ;
  long aexR;
  long aexS;
  boolean aexT;
  private int aexU;
  
  static
  {
    AppMethodBeat.i(35726);
    aexG = new HashMap();
    aexH = new HashMap();
    aexI = new LinkedHashMap();
    aexJ = new HashMap();
    aexK = new ArrayList();
    aexL = new HashMap();
    AppMethodBeat.o(35726);
  }
  
  public bo()
  {
    AppMethodBeat.i(35689);
    this.aexM = new TransformComponent.1(this, f.hfK);
    this.aexN = false;
    this.STa = false;
    this.aexO = false;
    this.aexP = new ArrayList();
    this.aexQ = false;
    this.aexS = 0L;
    this.aexT = false;
    this.aexU = -1;
    AppMethodBeat.o(35689);
  }
  
  private void Ac(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35712);
      aexJ.put(Long.valueOf(paramLong), Boolean.FALSE);
      AppMethodBeat.o(35712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong, cc paramcc, int paramInt)
  {
    try
    {
      AppMethodBeat.i(35694);
      aexI.put(Long.valueOf(paramLong), new Pair(paramcc, Integer.valueOf(paramInt)));
      AppMethodBeat.o(35694);
      return;
    }
    finally
    {
      paramcc = finally;
      throw paramcc;
    }
  }
  
  private void aAX(int paramInt)
  {
    AppMethodBeat.i(35704);
    if ((this.STa) && (paramInt != -1))
    {
      com.tencent.mm.ui.chatting.d.a locala = this.hlc;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(locala, locala1.aYi(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      locala.scrollToPosition(((Integer)locala1.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(locala, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(35704);
  }
  
  private void aCm(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(35705);
    if ((this.aexN) && (this.aexP.size() > 0))
    {
      String str = ((Long)this.aexP.get(0)).toString();
      int i = 1;
      while (i < this.aexP.size())
      {
        str = str + ":" + this.aexP.get(i);
        i += 1;
      }
      h localh = h.OAn;
      int k = this.aexP.size();
      i = j;
      if (this.STa) {
        i = 0;
      }
      localh.b(16128, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), str });
      this.aexN = false;
      this.aexP.clear();
    }
    AppMethodBeat.o(35705);
  }
  
  private void bAV(String paramString)
  {
    AppMethodBeat.i(35710);
    if ((this.hlc != null) && (this.hlc.aezO.getContext() != null))
    {
      paramString = Toast.makeText(this.hlc.aezO.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    AppMethodBeat.o(35710);
  }
  
  private static void e(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(35706);
    if (paramcc == null)
    {
      AppMethodBeat.o(35706);
      return;
    }
    hb localhb = new hb();
    localhb.hHK.hHM = 0;
    localhb.hHK.hHN = 0;
    localhb.hHK.hHO = 0;
    localhb.hHK.hHL = 0;
    localhb.hHK.fileName = paramcc.field_imgPath;
    localhb.hHK.result = paramInt;
    localhb.publish();
    AppMethodBeat.o(35706);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(35709);
    if (this.hlc != null)
    {
      localObject = this.hlc.aezO.getContext();
      AppMethodBeat.o(35709);
      return localObject;
    }
    Object localObject = MMApplicationContext.getContext();
    AppMethodBeat.o(35709);
    return localObject;
  }
  
  /* Error */
  private void j(final cc paramcc, final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 360
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 182	com/tencent/mm/ui/chatting/component/bo:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   12: ifnull +35 -> 47
    //   15: invokestatic 364	com/tencent/mm/ui/chatting/d/a:juI	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +18 -> 38
    //   23: aload_3
    //   24: new 12	com/tencent/mm/ui/chatting/component/bo$2
    //   27: dup
    //   28: aload_0
    //   29: iload_2
    //   30: aload_1
    //   31: invokespecial 367	com/tencent/mm/ui/chatting/component/bo$2:<init>	(Lcom/tencent/mm/ui/chatting/component/bo;ILcom/tencent/mm/storage/cc;)V
    //   34: invokevirtual 373	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   37: pop
    //   38: ldc_w 360
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
    //   0	57	0	this	bo
    //   0	57	1	paramcc	cc
    //   0	57	2	paramInt	int
    //   18	31	3	localMMHandler	com.tencent.mm.sdk.platformtools.MMHandler
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   23	38	52	finally
    //   38	44	52	finally
  }
  
  private void jtR()
  {
    try
    {
      AppMethodBeat.i(35699);
      aexI.clear();
      AppMethodBeat.o(35699);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int jtU()
  {
    AppMethodBeat.i(35713);
    int i;
    if (ab.IS(this.hlc.getTalkerUserName()))
    {
      boolean bool = ((e)this.hlc.cm(e.class)).jqW();
      if (((e)this.hlc.cm(e.class)).jqV()) {
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
      if (g.MA(this.hlc.getTalkerUserName()))
      {
        i = 3;
      }
      else if (g.MB(this.hlc.getTalkerUserName()))
      {
        i = 0;
      }
      else if (g.Mw(this.hlc.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (this.hlc.juF()) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(35708);
    if (this.hlc != null) {
      this.hlc.dcZ();
    }
    AppMethodBeat.o(35708);
  }
  
  private void zU(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35691);
      aexG.remove(Long.valueOf(paramLong));
      aexH.remove(Long.valueOf(paramLong));
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
  private cc zX(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 425
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/component/bo:aexI	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 427	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 146	android/util/Pair
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +15 -> 38
    //   26: aconst_null
    //   27: astore_3
    //   28: ldc_w 425
    //   31: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: aload_3
    //   39: getfield 431	android/util/Pair:first	Ljava/lang/Object;
    //   42: checkcast 433	com/tencent/mm/storage/cc
    //   45: astore_3
    //   46: ldc_w 425
    //   49: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -18 -> 34
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	bo
    //   0	60	1	paramLong	long
    //   21	25	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	55	finally
    //   28	34	55	finally
    //   38	52	55	finally
  }
  
  private void zY(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35698);
      if (aexI.containsKey(Long.valueOf(paramLong))) {
        aexI.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(35698);
      return;
    }
    finally {}
  }
  
  public final void Aa(long paramLong)
  {
    AppMethodBeat.i(256539);
    aexK.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(256539);
  }
  
  /* Error */
  public final boolean Ab(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 446
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 77	com/tencent/mm/ui/chatting/component/bo:aexJ	Ljava/util/HashMap;
    //   11: lload_1
    //   12: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 447	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 128	java/lang/Boolean
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: invokevirtual 450	java/lang/Boolean:booleanValue	()Z
    //   33: istore_3
    //   34: ldc_w 446
    //   37: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: ldc_w 446
    //   49: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	bo
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
      aexG.put(Long.valueOf(paramLong), paramString);
      aexH.put(Long.valueOf(paramLong), paramc);
      if (paramc == ChattingItemTranslate.c.aeWh) {
        aexJ.put(Long.valueOf(paramLong), Boolean.TRUE);
      }
      AppMethodBeat.o(35690);
      return;
    }
    finally {}
  }
  
  public final void a(final cc paramcc, boolean paramBoolean, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35703);
    if (paramcc == null)
    {
      Log.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      AppMethodBeat.o(35703);
      return;
    }
    if (Ab(paramcc.field_msgId))
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(paramcc.field_msgId), Boolean.valueOf(this.aexQ) });
      paramcc.jcn();
      Ac(paramcc.field_msgId);
      notifyDataSetChanged();
      AppMethodBeat.o(35703);
      return;
    }
    if ((zW(paramcc.field_msgId)) && (paramBoolean))
    {
      if (zV(paramcc.field_msgId) == ChattingItemTranslate.c.aeWf)
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        zY(paramcc.field_msgId);
        zU(paramcc.field_msgId);
        e(5, paramcc);
      }
      for (;;)
      {
        notifyDataSetChanged();
        if (!paramBoolean) {
          break;
        }
        aCm(paramInt2);
        AppMethodBeat.o(35703);
        return;
        if (this.aexQ)
        {
          localObject = new gx();
          ((gx)localObject).hHz.hHC = 3;
          ((gx)localObject).publish();
          zY(paramcc.field_msgId);
          zU(paramcc.field_msgId);
          paramcc.jcn();
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
          this.aexQ = false;
          j(paramcc, -1);
        }
      }
    }
    Log.d("MicroMsg.TransformComponent", "voice to text, pos:%s", new Object[] { Integer.valueOf(paramInt1) });
    Object localObject = o.bPg().byR(paramcc.field_imgPath);
    if ((localObject != null) && (!Util.isNullOrNil(((cy)localObject).field_content)))
    {
      Log.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(paramcc.field_msgId), paramcc.field_imgPath });
      paramcc.jco();
      a(paramcc.field_msgId, ((cy)localObject).field_content, ChattingItemTranslate.c.aeWh);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      this.aexN = false;
      aAX(paramInt1);
      AppMethodBeat.o(35703);
      return;
    }
    paramInt2 = bh.aZW().bFQ();
    if ((paramInt2 != 4) && (paramInt2 != 6))
    {
      k.s(getContext(), R.l.gzO, R.l.app_tip);
      e(2, paramcc);
      this.aexN = false;
      AppMethodBeat.o(35703);
      return;
    }
    if (this.aexQ)
    {
      Log.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      a(paramcc.field_msgId, paramcc, paramInt1);
      a(paramcc.field_msgId, "", ChattingItemTranslate.c.aeWf);
      notifyDataSetChanged();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.STa = true;
      }
      AppMethodBeat.o(35703);
      return;
      localObject = new gx();
      ((gx)localObject).hHz.hHC = 1;
      ((gx)localObject).publish();
      ((bf)this.hlc.cm(bf.class)).Ag(paramcc.field_msgId);
      localObject = new gx();
      ((gx)localObject).hHz.hHB = String.valueOf(paramcc.field_msgId);
      ((gx)localObject).hHz.fileName = paramcc.field_imgPath;
      ((gx)localObject).hHz.from = 1;
      ((gx)localObject).hHz.hHC = 0;
      ((gx)localObject).hHz.scene = jtU();
      ((gx)localObject).hHz.hHD = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35687);
          if (!bo.this.zW(Long.valueOf(this.XkY.hHz.hHB).longValue()))
          {
            AppMethodBeat.o(35687);
            return;
          }
          if (this.XkY.hHA.cVt)
          {
            if (Util.isNullOrNil(this.XkY.hHA.content))
            {
              if (this.XkY.hHA.state == 2)
              {
                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.XkY.hHz.hHB });
                bo.a(bo.this, bo.a(bo.this).getString(R.l.gzN));
              }
              bo.a(bo.this, Long.valueOf(this.XkY.hHz.hHB).longValue());
              bo.b(bo.this, Long.valueOf(this.XkY.hHz.hHB).longValue());
              bo.this.aexQ = false;
              bo.b(bo.this);
            }
            while (34 == paramcc.getType())
            {
              bo.aexL.put(Long.valueOf(paramcc.field_msgId), new bo.a(paramcc, paramInt1));
              AppMethodBeat.o(35687);
              return;
              Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.XkY.hHz.hHB });
              cc localcc = bo.c(bo.this, Long.valueOf(this.XkY.hHz.hHB).longValue());
              if (localcc != null)
              {
                bo.this.a(Long.valueOf(this.XkY.hHz.hHB).longValue(), this.XkY.hHA.content, ChattingItemTranslate.c.aeWh);
                localcc.jco();
                bh.bCz();
                com.tencent.mm.model.c.bzD().a(localcc.field_msgId, localcc);
                bo.b(bo.this, Long.valueOf(this.XkY.hHz.hHB).longValue());
                bo.b(bo.this);
                bo.a(bo.this, paramInt1);
              }
              bo.this.aexQ = false;
            }
            bo.a(bo.this, paramcc, paramInt1);
            AppMethodBeat.o(35687);
            return;
          }
          if (!Util.isNullOrNil(this.XkY.hHA.content))
          {
            bo.this.a(Long.valueOf(this.XkY.hHz.hHB).longValue(), this.XkY.hHA.content, ChattingItemTranslate.c.aeWg);
            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.XkY.hHz.hHB });
          }
          bo.b(bo.this);
          bo.a(bo.this, paramInt1);
          AppMethodBeat.o(35687);
        }
      };
      if (34 == paramcc.getType()) {
        aexK.add(Long.valueOf(paramcc.field_msgId));
      }
      a(Long.valueOf(((gx)localObject).hHz.hHB).longValue(), "", ChattingItemTranslate.c.aeWg);
      a(paramcc.field_msgId, paramcc, paramInt1);
      this.aexQ = true;
      this.aexR = paramcc.field_msgId;
      notifyDataSetChanged();
      aAX(paramInt1);
      if (((gx)localObject).publish())
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      }
      else
      {
        Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
        bAV(getContext().getString(R.l.gzN));
        zU(Long.valueOf(((gx)localObject).hHz.hHB).longValue());
        zY(Long.valueOf(((gx)localObject).hHz.hHB).longValue());
        this.aexQ = false;
        j(paramcc, paramInt1);
      }
    }
  }
  
  public final void aCl(int paramInt)
  {
    AppMethodBeat.i(35702);
    if (paramInt == 2)
    {
      this.aexO = true;
      AppMethodBeat.o(35702);
      return;
    }
    if (this.aexQ) {
      a(zX(this.aexR), true, -1, paramInt);
    }
    AppMethodBeat.o(35702);
  }
  
  public final String ar(long paramLong, String paramString)
  {
    try
    {
      AppMethodBeat.i(35692);
      String str2 = (String)aexG.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (Util.isNullOrNil(str2))
      {
        paramString = o.bPg().byR(paramString);
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
  
  public final boolean cX(cc paramcc)
  {
    AppMethodBeat.i(256531);
    if (paramcc == null)
    {
      AppMethodBeat.o(256531);
      return false;
    }
    if (!Util.isNullOrNil(ar(paramcc.field_msgId, paramcc.field_imgPath)))
    {
      AppMethodBeat.o(256531);
      return true;
    }
    AppMethodBeat.o(256531);
    return false;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256558);
    super.jjg();
    this.aexM.alive();
    AppMethodBeat.o(256558);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35714);
    Log.i("MicroMsg.TransformComponent", "[onChattingPause]");
    aCl(3);
    AppMethodBeat.o(35714);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(256565);
    super.jjk();
    this.aexM.dead();
    AppMethodBeat.o(256565);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(35715);
    Log.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    jtR();
    aexH.clear();
    aexI.clear();
    aexJ.clear();
    if (this.aexQ)
    {
      gx localgx = new gx();
      localgx.hHz.hHC = 3;
      localgx.publish();
      this.aexQ = false;
    }
    Log.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256045);
        long l = System.currentTimeMillis();
        synchronized (bo.this)
        {
          bo.ilg().clear();
          bo.jtV().clear();
          Log.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(256045);
          return;
        }
      }
    }, "UnsetTransformFlag");
    AppMethodBeat.o(35715);
  }
  
  /* Error */
  public final Pair<cc, Integer> jtQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 713
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/component/bo:aexI	Ljava/util/LinkedHashMap;
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
    //   43: checkcast 146	android/util/Pair
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
    //   0	73	0	this	bo
    //   19	40	1	localObject1	Object
    //   68	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
    //   59	65	68	finally
  }
  
  public final boolean jtS()
  {
    AppMethodBeat.i(35700);
    bh.bCz();
    if (!((Boolean)com.tencent.mm.model.c.ban().d(75, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(35700);
      return true;
    }
    AppMethodBeat.o(35700);
    return false;
  }
  
  public final void jtT()
  {
    AppMethodBeat.i(35701);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(75, Boolean.TRUE);
    AppMethodBeat.o(35701);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35716);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.aexU) {
      this.STa = false;
    }
    this.aexU = paramInt1;
    AppMethodBeat.o(35716);
  }
  
  public final ChattingItemTranslate.c zV(long paramLong)
  {
    try
    {
      AppMethodBeat.i(35693);
      ChattingItemTranslate.c localc2 = (ChattingItemTranslate.c)aexH.get(Long.valueOf(paramLong));
      ChattingItemTranslate.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = ChattingItemTranslate.c.aeWe;
      }
      AppMethodBeat.o(35693);
      return localc1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean zW(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 766
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 75	com/tencent/mm/ui/chatting/component/bo:aexI	Ljava/util/LinkedHashMap;
    //   11: lload_1
    //   12: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 438	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +15 -> 33
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc_w 766
    //   26: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc_w 766
    //   38: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	bo
    //   0	51	1	paramLong	long
    //   22	13	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   23	29	44	finally
    //   35	41	44	finally
  }
  
  public final boolean zZ(long paramLong)
  {
    AppMethodBeat.i(256534);
    boolean bool = aexK.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(256534);
    return bool;
  }
  
  static final class a
  {
    cc hTm;
    int pos;
    
    public a(cc paramcc, int paramInt)
    {
      this.hTm = paramcc;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bo
 * JD-Core Version:    0.7.0.1
 */