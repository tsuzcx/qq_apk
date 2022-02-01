package com.tencent.mm.recovery.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.a;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  public static LinkedList<dzo> fPU()
  {
    AppMethodBeat.i(242769);
    localLinkedList = new LinkedList();
    long l1 = 0L;
    for (;;)
    {
      try
      {
        long l2 = com.tencent.mm.kernel.b.aZP() & 0xFFFFFFFF;
        l1 = l2;
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "uin is %s", new Object[] { Util.secPrint(String.valueOf(l2)) });
        l1 = l2;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", localException, "tinker patch manager get uin failed.", new Object[0]);
        continue;
        str = "0";
        continue;
        str = "0";
        continue;
        int i = 2;
        continue;
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "final conditions = ".concat(String.valueOf(localLinkedList)));
        continue;
      }
      try
      {
        localLinkedList.add(jE("code-version", BuildInfo.CLIENT_VERSION));
        localLinkedList.add(jE("code-reversion", BuildInfo.REV));
        localLinkedList.add(jE("sdk", String.valueOf(Build.VERSION.SDK_INT)));
        localLinkedList.add(jE("os-name", d.Yxd));
        localLinkedList.add(jE("device-brand", d.Yxa));
        localLinkedList.add(jE("device-name", d.Yxf));
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0)
        {
          Object localObject1 = "1";
          localLinkedList.add(jE("support-64-bit", (String)localObject1));
          if (!q.awm()) {
            continue;
          }
          localObject1 = "1";
          localLinkedList.add(jE("device-is-64-bit-runtime", (String)localObject1));
          localLinkedList.add(jE("uin", String.valueOf(l1)));
          if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            continue;
          }
          i = 3;
          localLinkedList.add(jE("network", String.valueOf(i)));
          localObject1 = (c)h.ax(c.class);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((c)localObject1).dbd();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          a locala = (a)((Iterator)localObject1).next();
          localLinkedList.add(jE(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau)));
          continue;
        }
        try
        {
          Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", localThrowable, "get condition fail, skip", new Object[0]);
          return localLinkedList;
        }
        finally
        {
          String str;
          Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "final conditions = ".concat(String.valueOf(localLinkedList)));
          AppMethodBeat.o(242769);
        }
      }
      finally {}
    }
  }
  
  public static dzo jE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242771);
    dzo localdzo = new dzo();
    localdzo.key = paramString1;
    localdzo.value = paramString2;
    AppMethodBeat.o(242771);
    return localdzo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a.b
 * JD-Core Version:    0.7.0.1
 */