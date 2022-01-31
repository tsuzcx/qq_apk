package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.HashSet;

public final class ab
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock;
  public HashSet<String> qkQ;
  public HashMap<String, String> qkR;
  
  public ab()
  {
    AppMethodBeat.i(44794);
    this.qkQ = null;
    this.qkR = new HashMap();
    this.qkQ = new HashSet();
    this.lock = new Object();
    AppMethodBeat.o(44794);
  }
  
  /* Error */
  private boolean Yh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 49
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 33	com/tencent/mm/plugin/remittance/model/ab:qkQ	Ljava/util/HashSet;
    //   11: aload_1
    //   12: invokevirtual 53	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   15: ifne +21 -> 36
    //   18: aload_0
    //   19: getfield 33	com/tencent/mm/plugin/remittance/model/ab:qkQ	Ljava/util/HashSet;
    //   22: aload_1
    //   23: invokevirtual 56	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   26: istore_2
    //   27: ldc 49
    //   29: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: getstatic 20	com/tencent/mm/plugin/remittance/model/ab:TAG	Ljava/lang/String;
    //   39: ldc 58
    //   41: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iconst_0
    //   45: istore_2
    //   46: ldc 49
    //   48: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -19 -> 32
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ab
    //   0	59	1	paramString	String
    //   26	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	32	54	finally
    //   36	44	54	finally
    //   46	51	54	finally
  }
  
  public final boolean Yg(String paramString)
  {
    AppMethodBeat.i(44795);
    synchronized (this.lock)
    {
      boolean bool = this.qkQ.contains(paramString);
      AppMethodBeat.o(44795);
      return bool;
    }
  }
  
  public final boolean ac(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(44798);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      com.tencent.mm.sdk.platformtools.ab.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(44798);
      return false;
    }
    if (!Yh(paramString1))
    {
      AppMethodBeat.o(44798);
      return false;
    }
    bi localbi = new bi();
    localbi.setContent(paramString2);
    localbi.setStatus(2);
    localbi.kj(paramString3);
    localbi.fQ(bf.py(paramString3));
    localbi.hL(1);
    localbi.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
    if (l < 0L)
    {
      com.tencent.mm.sdk.platformtools.ab.e(TAG, com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
      this.qkQ.remove(paramString1);
      AppMethodBeat.o(44798);
      return false;
    }
    localbi.setMsgId(l);
    boolean bool1;
    if (localbi.bCn())
    {
      b.fRu.a(localbi, com.tencent.mm.af.k.k(localbi));
      paramString3 = new com.tencent.mm.af.j();
      paramString3.field_xml = localbi.field_content;
      paramString2 = bo.apU(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = j.b.ab(paramString2, localbi.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          paramString3.field_title = paramString2.title;
          paramString3.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      paramString3.field_type = 2000;
      paramString3.field_msgId = l;
      paramString2 = a.cad().nx(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label391;
      }
      bool1 = a.cad().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localbi.field_msgId;
        paramString2.field_transferId = paramString1.fhG;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.cgH();
        com.tencent.mm.plugin.remittance.a.c.cgJ().a(paramString2);
      }
      AppMethodBeat.o(44798);
      return bool1;
      b.fRu.j(localbi);
      break;
      label391:
      boolean bool2 = a.cad().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        com.tencent.mm.sdk.platformtools.ab.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final void fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142132);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ab.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(142132);
      return;
    }
    this.qkR.put(paramString1, paramString2);
    AppMethodBeat.o(142132);
  }
  
  public final boolean fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44797);
    String str = (String)this.qkR.get(paramString1);
    if (bo.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ab.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(44797);
      return false;
    }
    boolean bool = ac(paramString1, str, paramString2);
    AppMethodBeat.o(44797);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */