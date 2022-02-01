package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.sdk.b.c<j>
{
  public a()
  {
    AppMethodBeat.i(161395);
    this.__eventId = j.class.getName().hashCode();
    AppMethodBeat.o(161395);
  }
  
  private static boolean a(j paramj)
  {
    AppMethodBeat.i(26684);
    if (!(paramj instanceof j))
    {
      AppMethodBeat.o(26684);
      return false;
    }
    if (paramj.cYw == null)
    {
      AppMethodBeat.o(26684);
      return false;
    }
    int i = paramj.cYw.actionCode;
    Object localObject3 = paramj.cYw.context;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = ai.getContext();
    }
    localObject3 = new Bundle();
    switch (i)
    {
    }
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      paramj.cYx.cYB = ((Bundle)localObject3);
      AppMethodBeat.o(26684);
      return false;
      ((Bundle)localObject3).putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.dkm().vnS));
      continue;
      ((Bundle)localObject3).putString("info", com.tencent.mm.plugin.nfc.b.a.a.dkm().getInfo());
      continue;
      ((Bundle)localObject3).putInt("status", com.tencent.mm.plugin.nfc.b.a.a.dkm().fP((Context)localObject1));
      continue;
      i = com.tencent.mm.plugin.nfc.b.a.a.dkm().fQ((Context)localObject1);
      ac.i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", new Object[] { Integer.valueOf(i) });
      ((Bundle)localObject3).putInt("status", i);
      continue;
      localObject1 = paramj.cYw.cYy;
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
      }
      else
      {
        try
        {
          localObject1 = new com.tencent.mm.plugin.nfc.a.a((String)localObject1);
          ((Bundle)localObject3).putString("result", com.tencent.mm.plugin.nfc.b.a.a.dkm().a((com.tencent.mm.plugin.nfc.a.a)localObject1).toString());
        }
        catch (Exception localException1)
        {
          ac.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          ac.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException1, "", new Object[0]);
          ((Bundle)localObject3).putString("result", null);
        }
        continue;
        try
        {
          String str = paramj.cYw.cYy;
          bool1 = paramj.cYw.cYz;
          bool2 = paramj.cYw.cYA;
          if (!bs.isNullOrNil(str)) {
            break;
          }
          ac.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
        }
        catch (Exception localException2)
        {
          ac.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          ac.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException2, "", new Object[0]);
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
        if (bs.isNullOrNil((String)localObject5))
        {
          ac.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
        }
        else
        {
          localObject5 = ((String)localObject5).split(":");
          if ((localObject5 == null) || (localObject5.length < 2))
          {
            ac.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
          }
          else
          {
            int k = bs.getInt(localObject5[0], 0);
            ((List)localObject2).add(new com.tencent.mm.plugin.nfc.b.a(k, String.valueOf(k), new com.tencent.mm.plugin.nfc.a.a(localObject5[1])));
          }
        }
      }
      else
      {
        com.tencent.mm.plugin.nfc.b.a.a.dkm().b((List)localObject2, bool1, bool2);
        localObject4 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.nfc.b.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.nfc.b.a)localObject5).vnQ == null) {
            break;
          }
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).id);
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).vnQ.toString());
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