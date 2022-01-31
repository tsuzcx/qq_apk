package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.h.a.fo.a;
import com.tencent.mm.h.a.fs;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.HashMap;
import java.util.LinkedHashMap;

@com.tencent.mm.ui.chatting.b.a.a(cFA=af.class)
public class am
  extends a
  implements af
{
  private static HashMap<Long, String> vsW = new HashMap();
  private static HashMap<Long, ChattingItemTranslate.b> vsX = new HashMap();
  private static LinkedHashMap<Long, bi> vsY = new LinkedHashMap();
  private static HashMap<Long, Boolean> vsZ = new HashMap();
  boolean vta = false;
  long vtb = 0L;
  boolean vtc = false;
  
  private void adz(String paramString)
  {
    if ((this.byx != null) && (this.byx.vtz.getContext() != null))
    {
      paramString = Toast.makeText(this.byx.vtz.getContext(), paramString, 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
  }
  
  private static void c(int paramInt, bi parambi)
  {
    if (parambi == null) {
      return;
    }
    fs localfs = new fs();
    localfs.bMK.bMM = 0;
    localfs.bMK.bMN = 0;
    localfs.bMK.bMO = 0;
    localfs.bMK.bML = 0;
    localfs.bMK.fileName = parambi.field_imgPath;
    localfs.bMK.result = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localfs);
  }
  
  private void c(long paramLong, bi parambi)
  {
    try
    {
      vsY.put(Long.valueOf(paramLong), parambi);
      return;
    }
    finally
    {
      parambi = finally;
      throw parambi;
    }
  }
  
  private void cFs()
  {
    try
    {
      vsY.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void cFv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/mm/ui/chatting/b/am:byx	Lcom/tencent/mm/ui/chatting/c/a;
    //   6: ifnull +27 -> 33
    //   9: invokestatic 175	com/tencent/mm/ui/chatting/c/a:cFG	()Lcom/tencent/mm/sdk/platformtools/ah;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +16 -> 30
    //   17: aload_1
    //   18: new 177	com/tencent/mm/ui/chatting/b/am$2
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 179	com/tencent/mm/ui/chatting/b/am$2:<init>	(Lcom/tencent/mm/ui/chatting/b/am;)V
    //   26: invokevirtual 185	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -22 -> 13
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	am
    //   12	23	1	localah	com.tencent.mm.sdk.platformtools.ah
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	38	finally
    //   17	30	38	finally
  }
  
  private Context getContext()
  {
    if (this.byx != null) {
      return this.byx.vtz.getContext();
    }
    return ae.getContext();
  }
  
  private void hS(long paramLong)
  {
    try
    {
      vsW.remove(Long.valueOf(paramLong));
      vsX.remove(Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private bi hV(long paramLong)
  {
    try
    {
      bi localbi = (bi)vsY.get(Long.valueOf(paramLong));
      return localbi;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void hW(long paramLong)
  {
    try
    {
      if (vsY.containsKey(Long.valueOf(paramLong))) {
        vsY.remove(Long.valueOf(paramLong));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void hY(long paramLong)
  {
    try
    {
      vsZ.put(Long.valueOf(paramLong), Boolean.valueOf(false));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void notifyDataSetChanged()
  {
    if (this.byx != null) {
      this.byx.axW();
    }
  }
  
  public final String E(long paramLong, String paramString)
  {
    try
    {
      String str2 = (String)vsW.get(Long.valueOf(paramLong));
      String str1 = str2;
      if (bk.bl(str2))
      {
        paramString = m.Th().acw(paramString);
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (!bk.bl(paramString.field_content)) {
            str1 = paramString.field_content;
          }
        }
      }
      return str1;
    }
    finally {}
  }
  
  public final void a(long paramLong, String paramString, ChattingItemTranslate.b paramb)
  {
    try
    {
      vsW.put(Long.valueOf(paramLong), paramString);
      vsX.put(Long.valueOf(paramLong), paramb);
      if (paramb == ChattingItemTranslate.b.vGd) {
        vsZ.put(Long.valueOf(paramLong), Boolean.valueOf(true));
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final bi cFr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 40	com/tencent/mm/ui/chatting/b/am:vsY	Ljava/util/LinkedHashMap;
    //   5: invokevirtual 257	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   8: invokeinterface 263 1 0
    //   13: astore_1
    //   14: aload_1
    //   15: invokeinterface 269 1 0
    //   20: ifeq +25 -> 45
    //   23: aload_1
    //   24: invokeinterface 273 1 0
    //   29: checkcast 275	java/util/Map$Entry
    //   32: invokeinterface 278 1 0
    //   37: checkcast 201	com/tencent/mm/storage/bi
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	am
    //   13	34	1	localObject1	Object
    //   50	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	50	finally
  }
  
  public final boolean cFt()
  {
    au.Hx();
    return !((Boolean)com.tencent.mm.model.c.Dz().get(75, Boolean.valueOf(false))).booleanValue();
  }
  
  public final void cFu()
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(75, Boolean.valueOf(true));
  }
  
  public final void cyR()
  {
    y.i("MicroMsg.TransformComponent", "[onChattingExitAnimStart]");
    y.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
    cFs();
    if (this.vta)
    {
      fo localfo = new fo();
      localfo.bMz.bMC = 3;
      com.tencent.mm.sdk.b.a.udP.m(localfo);
    }
    y.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
    com.tencent.mm.sdk.f.e.post(new am.3(this), "UnsetTransformFlag");
  }
  
  public final void e(bi parambi, boolean paramBoolean)
  {
    int i = 2;
    if (parambi == null)
    {
      y.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
      return;
    }
    if (hX(parambi.field_msgId))
    {
      y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[] { Long.valueOf(parambi.field_msgId), Boolean.valueOf(this.vta) });
      parambi.cvG();
      hY(parambi.field_msgId);
      notifyDataSetChanged();
      return;
    }
    if ((hU(parambi.field_msgId)) && (paramBoolean))
    {
      if (hT(parambi.field_msgId) == ChattingItemTranslate.b.vGb)
      {
        y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
        hW(parambi.field_msgId);
        hS(parambi.field_msgId);
        c(5, parambi);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        if (this.vta)
        {
          localObject = new fo();
          ((fo)localObject).bMz.bMC = 3;
          com.tencent.mm.sdk.b.a.udP.m((b)localObject);
          hW(parambi.field_msgId);
          hS(parambi.field_msgId);
          parambi.cvG();
          au.Hx();
          com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
          cFv();
        }
      }
    }
    Object localObject = m.Th().acw(parambi.field_imgPath);
    if ((localObject != null) && (!bk.bl(((cc)localObject).field_content)))
    {
      y.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[] { Long.valueOf(parambi.field_msgId), parambi.field_imgPath });
      parambi.cvH();
      a(parambi.field_msgId, ((cc)localObject).field_content, ChattingItemTranslate.b.vGd);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      return;
    }
    int j = au.Dk().KG();
    if ((j != 4) && (j != 6))
    {
      h.h(getContext(), R.l.chatting_transform_network_unavailable, R.l.app_tip);
      c(2, parambi);
      return;
    }
    if (this.vta)
    {
      y.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
      c(parambi.field_msgId, parambi);
      a(parambi.field_msgId, "", ChattingItemTranslate.b.vGb);
      notifyDataSetChanged();
      return;
    }
    localObject = new fo();
    ((fo)localObject).bMz.bMC = 1;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    localObject = new fo();
    ((fo)localObject).bMz.bMB = String.valueOf(parambi.field_msgId);
    ((fo)localObject).bMz.fileName = parambi.field_imgPath;
    ((fo)localObject).bMz.from = 1;
    ((fo)localObject).bMz.bMC = 0;
    fo.a locala = ((fo)localObject).bMz;
    if (s.hl(this.byx.getTalkerUserName()))
    {
      paramBoolean = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH();
      if (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()) {
        if (paramBoolean) {
          i = 5;
        }
      }
    }
    for (;;)
    {
      locala.scene = i;
      ((fo)localObject).bMz.bMD = new am.1(this, (fo)localObject);
      a(Long.valueOf(((fo)localObject).bMz.bMB).longValue(), "", ChattingItemTranslate.b.vGc);
      c(parambi.field_msgId, parambi);
      this.vta = true;
      notifyDataSetChanged();
      if (!com.tencent.mm.sdk.b.a.udP.m((b)localObject)) {
        break;
      }
      y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
      return;
      i = 4;
      continue;
      if (f.lb(this.byx.getTalkerUserName()))
      {
        i = 3;
      }
      else if (f.lc(this.byx.getTalkerUserName()))
      {
        i = 0;
      }
      else if (f.kY(this.byx.getTalkerUserName()))
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        if (!this.byx.cFD()) {
          i = 1;
        }
      }
    }
    y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
    adz(getContext().getString(R.l.chatting_transform_fail));
    hS(Long.valueOf(((fo)localObject).bMz.bMB).longValue());
    hW(Long.valueOf(((fo)localObject).bMz.bMB).longValue());
    this.vta = false;
    cFv();
  }
  
  public final ChattingItemTranslate.b hT(long paramLong)
  {
    try
    {
      ChattingItemTranslate.b localb2 = (ChattingItemTranslate.b)vsX.get(Long.valueOf(paramLong));
      ChattingItemTranslate.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = ChattingItemTranslate.b.vGa;
      }
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean hU(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 40	com/tencent/mm/ui/chatting/b/am:vsY	Ljava/util/LinkedHashMap;
    //   5: lload_1
    //   6: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9: invokevirtual 205	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	am
    //   0	35	1	paramLong	long
    //   12	13	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
  
  /* Error */
  public final boolean hX(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	com/tencent/mm/ui/chatting/b/am:vsZ	Ljava/util/HashMap;
    //   5: lload_1
    //   6: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast 209	java/lang/Boolean
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +13 -> 32
    //   22: aload 4
    //   24: invokevirtual 299	java/lang/Boolean:booleanValue	()Z
    //   27: istore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_3
    //   34: goto -6 -> 28
    //   37: astore 4
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	am
    //   0	44	1	paramLong	long
    //   27	7	3	bool	boolean
    //   15	8	4	localBoolean	Boolean
    //   37	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	37	finally
    //   22	28	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.am
 * JD-Core Version:    0.7.0.1
 */