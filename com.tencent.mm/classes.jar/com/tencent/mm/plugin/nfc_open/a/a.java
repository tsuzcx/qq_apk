package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.sdk.b.c<j>
{
  public a()
  {
    AppMethodBeat.i(23057);
    this.__eventId = j.class.getName().hashCode();
    AppMethodBeat.o(23057);
  }
  
  private static boolean a(j paramj)
  {
    AppMethodBeat.i(23058);
    if (!(paramj instanceof j))
    {
      AppMethodBeat.o(23058);
      return false;
    }
    if (paramj.cmo == null)
    {
      AppMethodBeat.o(23058);
      return false;
    }
    int i = paramj.cmo.actionCode;
    Object localObject3 = paramj.cmo.context;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = ah.getContext();
    }
    localObject3 = new Bundle();
    switch (i)
    {
    }
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      paramj.cmp.cmt = ((Bundle)localObject3);
      AppMethodBeat.o(23058);
      return false;
      ((Bundle)localObject3).putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.bWY().pgp));
      continue;
      ((Bundle)localObject3).putString("info", com.tencent.mm.plugin.nfc.b.a.a.bWY().getInfo());
      continue;
      ((Bundle)localObject3).putInt("status", com.tencent.mm.plugin.nfc.b.a.a.bWY().eI((Context)localObject1));
      continue;
      i = com.tencent.mm.plugin.nfc.b.a.a.bWY().eJ((Context)localObject1);
      ab.i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", new Object[] { Integer.valueOf(i) });
      ((Bundle)localObject3).putInt("status", i);
      continue;
      localObject1 = paramj.cmo.cmq;
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
      }
      else
      {
        try
        {
          localObject1 = new com.tencent.mm.plugin.nfc.a.a((String)localObject1);
          ((Bundle)localObject3).putString("result", com.tencent.mm.plugin.nfc.b.a.a.bWY().a((com.tencent.mm.plugin.nfc.a.a)localObject1).toString());
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException1, "", new Object[0]);
          ((Bundle)localObject3).putString("result", null);
        }
        continue;
        try
        {
          String str = paramj.cmo.cmq;
          bool1 = paramj.cmo.cmr;
          bool2 = paramj.cmo.cms;
          if (!bo.isNullOrNil(str)) {
            break;
          }
          ab.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException2, "", new Object[0]);
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
        if (bo.isNullOrNil((String)localObject5))
        {
          ab.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
        }
        else
        {
          localObject5 = ((String)localObject5).split(":");
          if ((localObject5 == null) || (localObject5.length < 2))
          {
            ab.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
          }
          else
          {
            int k = bo.getInt(localObject5[0], 0);
            ((List)localObject2).add(new com.tencent.mm.plugin.nfc.b.a(k, String.valueOf(k), new com.tencent.mm.plugin.nfc.a.a(localObject5[1])));
          }
        }
      }
      else
      {
        com.tencent.mm.plugin.nfc.b.a.a.bWY().a((List)localObject2, bool1, bool2);
        localObject4 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.nfc.b.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.nfc.b.a)localObject5).pgn == null) {
            break;
          }
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).id);
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.nfc.b.a)localObject5).pgn.toString());
          ((StringBuilder)localObject4).append("|");
        }
        ((Bundle)localObject3).putString("result", ((StringBuilder)localObject4).toString());
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.a
 * JD-Core Version:    0.7.0.1
 */