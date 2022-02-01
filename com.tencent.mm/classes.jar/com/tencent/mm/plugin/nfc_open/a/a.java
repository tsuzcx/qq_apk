package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.k.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends IListener<k>
{
  public a()
  {
    AppMethodBeat.i(161395);
    this.__eventId = k.class.getName().hashCode();
    AppMethodBeat.o(161395);
  }
  
  private static boolean a(k paramk)
  {
    AppMethodBeat.i(26684);
    if (!(paramk instanceof k))
    {
      AppMethodBeat.o(26684);
      return false;
    }
    if (paramk.dCc == null)
    {
      AppMethodBeat.o(26684);
      return false;
    }
    int i = paramk.dCc.actionCode;
    Object localObject3 = paramk.dCc.context;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = MMApplicationContext.getContext();
    }
    localObject3 = new Bundle();
    switch (i)
    {
    }
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      paramk.dCd.dCh = ((Bundle)localObject3);
      AppMethodBeat.o(26684);
      return false;
      ((Bundle)localObject3).putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.exw().AEf));
      continue;
      ((Bundle)localObject3).putString("info", com.tencent.mm.plugin.nfc.b.a.a.exw().getInfo());
      continue;
      ((Bundle)localObject3).putInt("status", com.tencent.mm.plugin.nfc.b.a.a.exw().gI((Context)localObject1));
      continue;
      i = com.tencent.mm.plugin.nfc.b.a.a.exw().gJ((Context)localObject1);
      Log.i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", new Object[] { Integer.valueOf(i) });
      ((Bundle)localObject3).putInt("status", i);
      continue;
      localObject1 = paramk.dCc.dCe;
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
      }
      else
      {
        try
        {
          localObject1 = new com.tencent.mm.plugin.nfc.a.a((String)localObject1);
          ((Bundle)localObject3).putString("result", com.tencent.mm.plugin.nfc.b.a.a.exw().a((com.tencent.mm.plugin.nfc.a.a)localObject1).toString());
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          Log.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException1, "", new Object[0]);
          ((Bundle)localObject3).putString("result", null);
        }
        continue;
        try
        {
          String str = paramk.dCc.dCe;
          bool1 = paramk.dCc.dCf;
          bool2 = paramk.dCc.dCg;
          if (!Util.isNullOrNil(str)) {
            break;
          }
          Log.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          Log.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException2, "", new Object[0]);
          ((Bundle)localObject3).putString("result", null);
        }
      }
    }
    Object localObject4 = localException2.split("\\|");
    Object localObject2 = new ArrayList();
    int j = localObject4.length;
    i = 0;
    for (;;)
    {
      Object localObject5;
      if (i < j)
      {
        localObject5 = localObject4[i];
        if (Util.isNullOrNil((String)localObject5))
        {
          Log.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
        }
        else
        {
          localObject5 = ((String)localObject5).split(":");
          if ((localObject5 == null) || (localObject5.length < 2))
          {
            Log.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
          }
          else
          {
            int k = Util.getInt(localObject5[0], 0);
            ((List)localObject2).add(new com.tencent.mm.plugin.nfc.b.a(k, String.valueOf(k), new com.tencent.mm.plugin.nfc.a.a(localObject5[1])));
          }
        }
      }
      else
      {
        com.tencent.mm.plugin.nfc.b.a.a.exw().b((List)localObject2, bool1, bool2);
        localObject4 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.nfc.b.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.nfc.b.a)localObject5).AEd == null) {
            break;
          }
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).id);
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).AEd.toString());
          ((StringBuilder)localObject4).append("|");
        }
        ((Bundle)localObject3).putString("result", ((StringBuilder)localObject4).toString());
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.a
 * JD-Core Version:    0.7.0.1
 */