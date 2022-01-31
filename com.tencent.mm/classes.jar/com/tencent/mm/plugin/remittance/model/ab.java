package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.b.c;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.HashSet;

public final class ab
{
  public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock = new Object();
  public HashSet<String> nzE = null;
  public HashMap<String, String> nzF = new HashMap();
  
  /* Error */
  private boolean LO(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/mm/plugin/remittance/model/ab:nzE	Ljava/util/HashSet;
    //   6: aload_1
    //   7: invokevirtual 42	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   10: ifne +16 -> 26
    //   13: aload_0
    //   14: getfield 26	com/tencent/mm/plugin/remittance/model/ab:nzE	Ljava/util/HashSet;
    //   17: aload_1
    //   18: invokevirtual 45	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: getstatic 20	com/tencent/mm/plugin/remittance/model/ab:TAG	Ljava/lang/String;
    //   29: ldc 47
    //   31: invokestatic 53	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -14 -> 22
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ab
    //   0	44	1	paramString	String
    //   21	15	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	39	finally
    //   26	34	39	finally
  }
  
  public final boolean LN(String paramString)
  {
    synchronized (this.lock)
    {
      boolean bool = this.nzE.contains(paramString);
      return bool;
    }
  }
  
  public final boolean T(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      y.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      return false;
    }
    if (!LO(paramString1)) {
      return false;
    }
    bi localbi = new bi();
    localbi.setContent(paramString2);
    localbi.setStatus(2);
    localbi.ec(paramString3);
    localbi.bg(bd.iK(paramString3));
    localbi.fA(1);
    localbi.setType(419430449);
    long l = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
    if (l < 0L)
    {
      y.e(TAG, com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      this.nzE.remove(paramString1);
      return false;
    }
    localbi.setMsgId(l);
    boolean bool1;
    if (localbi.aVK())
    {
      com.tencent.mm.modelstat.b.eBD.a(localbi, h.g(localbi));
      paramString3 = new com.tencent.mm.ae.g();
      paramString3.field_xml = localbi.field_content;
      paramString2 = bk.ZQ(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = g.a.M(paramString2, localbi.field_reserved);
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
      paramString2 = a.bro().gZ(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label366;
      }
      bool1 = a.bro().c(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new c();
        paramString2.field_locaMsgId = localbi.field_msgId;
        paramString2.field_transferId = paramString1.dRH;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.b.bvS();
        com.tencent.mm.plugin.remittance.a.b.bvU().a(paramString2);
      }
      return bool1;
      com.tencent.mm.modelstat.b.eBD.f(localbi);
      break;
      label366:
      boolean bool2 = a.bro().b(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        y.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:" + l);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean ex(String paramString1, String paramString2)
  {
    String str = (String)this.nzF.get(paramString1);
    if (bk.bl(str))
    {
      y.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      return false;
    }
    return T(paramString1, str, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */