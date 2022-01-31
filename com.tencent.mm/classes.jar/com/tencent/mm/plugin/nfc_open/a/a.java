package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.h.a.j;
import com.tencent.mm.h.a.j.a;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.sdk.b.c<j>
{
  public a()
  {
    this.udX = j.class.getName().hashCode();
  }
  
  private static boolean a(j paramj)
  {
    if (!(paramj instanceof j)) {}
    while (paramj.bFd == null) {
      return false;
    }
    int i = paramj.bFd.actionCode;
    Object localObject1 = paramj.bFd.context;
    Bundle localBundle = new Bundle();
    switch (i)
    {
    }
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      paramj.bFe.bFi = localBundle;
      return false;
      localBundle.putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.boy().mGj));
      continue;
      localBundle.putString("info", com.tencent.mm.plugin.nfc.b.a.a.boy().getInfo());
      continue;
      localBundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.boy().dU((Context)localObject1));
      continue;
      localBundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.boy().dV((Context)localObject1));
      continue;
      localObject1 = paramj.bFd.bFf;
      if (bk.bl((String)localObject1))
      {
        y.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
      }
      else
      {
        try
        {
          localObject1 = new com.tencent.mm.plugin.nfc.a.a((String)localObject1);
          localBundle.putString("result", com.tencent.mm.plugin.nfc.b.a.a.boy().a((com.tencent.mm.plugin.nfc.a.a)localObject1).toString());
        }
        catch (Exception localException1)
        {
          y.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          y.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException1, "", new Object[0]);
          localBundle.putString("result", null);
        }
        continue;
        try
        {
          String str = paramj.bFd.bFf;
          bool1 = paramj.bFd.bFg;
          bool2 = paramj.bFd.bFh;
          if (!bk.bl(str)) {
            break;
          }
          y.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
          y.printErrStackTrace("MicroMsg.ApduEngineFuncListener", localException2, "", new Object[0]);
          localBundle.putString("result", null);
        }
      }
    }
    Object localObject3 = localException2.split("\\|");
    Object localObject2 = new ArrayList();
    int j = localObject3.length;
    i = 0;
    for (;;)
    {
      Object localObject4;
      if (i < j)
      {
        localObject4 = localObject3[i];
        if (bk.bl((String)localObject4))
        {
          y.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
        }
        else
        {
          localObject4 = ((String)localObject4).split(":");
          if ((localObject4 == null) || (localObject4.length < 2))
          {
            y.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
          }
          else
          {
            int k = bk.getInt(localObject4[0], 0);
            ((List)localObject2).add(new com.tencent.mm.plugin.nfc.b.a(k, String.valueOf(k), new com.tencent.mm.plugin.nfc.a.a(localObject4[1])));
          }
        }
      }
      else
      {
        com.tencent.mm.plugin.nfc.b.a.a.boy().a((List)localObject2, bool1, bool2);
        localObject3 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.nfc.b.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.nfc.b.a)localObject4).mGh == null) {
            break;
          }
          ((StringBuilder)localObject3).append(((com.tencent.mm.plugin.nfc.b.a)localObject4).id);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(((com.tencent.mm.plugin.nfc.b.a)localObject4).mGh.toString());
          ((StringBuilder)localObject3).append("|");
        }
        localBundle.putString("result", ((StringBuilder)localObject3).toString());
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