package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;

public final class a
{
  public static int a(Intent paramIntent, a parama)
  {
    AppMethodBeat.i(71801);
    localb = new b();
    int i = aW(paramIntent);
    ae.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(i));
    if (i != 0)
    {
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.cr(i, ""), null);
      AppMethodBeat.o(71801);
      return i;
    }
    if ((!paramIntent.hasExtra("INAPP_PURCHASE_ITEM_LIST")) || (!paramIntent.hasExtra("INAPP_PURCHASE_DATA_LIST")) || (!paramIntent.hasExtra("INAPP_DATA_SIGNATURE_LIST")))
    {
      aoc("Bundle returned from getPurchases() doesn't contain required fields.");
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.cr(5, ""), null);
      AppMethodBeat.o(71801);
      return 5;
    }
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
    ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
    paramIntent = paramIntent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
    i = 0;
    try
    {
      while (i < localArrayList2.size())
      {
        String str = (String)localArrayList2.get(i);
        Object localObject = (String)paramIntent.get(i);
        ae.d("MicroMsg.IabResolver", "Sku is owned: ".concat(String.valueOf((String)localArrayList1.get(i))));
        localObject = new c("inapp", str, (String)localObject);
        if (TextUtils.isEmpty(((c)localObject).mToken))
        {
          ae.w("MicroMsg.IabResolver", "In-app billing warning: ".concat(String.valueOf("BUG: empty/null token!")));
          ae.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str)));
        }
        localb.DHn.put(((c)localObject).pMk, localObject);
        i += 1;
      }
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.cr(0, ""), localb);
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
        parama.a(com.tencent.mm.plugin.wallet_index.c.b.cr(5, ""), localb);
      }
    }
    AppMethodBeat.o(71801);
    return 0;
  }
  
  public static b a(Intent paramIntent, d paramd)
  {
    AppMethodBeat.i(71800);
    if (paramIntent == null)
    {
      aoc("Null data in IAB activity result.");
      paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cr(5, "");
      if (paramd != null) {
        paramd.a(paramIntent, null);
      }
      AppMethodBeat.o(71800);
      return null;
    }
    int i = paramIntent.getIntExtra("RESPONSE_CODE", 0);
    String str1 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str2 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if (i == 0)
    {
      ae.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
      ae.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str1)));
      ae.d("MicroMsg.IabResolver", "Data signature: ".concat(String.valueOf(str2)));
      ae.d("MicroMsg.IabResolver", "Extras: " + paramIntent.getExtras());
      if ((str1 == null) || (str2 == null))
      {
        aoc("BUG: either purchaseData or dataSignature is null.");
        paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cr(5, "");
        if (paramd != null) {
          paramd.a(paramIntent, null);
        }
        AppMethodBeat.o(71800);
        return null;
      }
      try
      {
        paramIntent = new c("inapp", str1, str2);
        str1 = paramIntent.pMk;
        ae.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
        if (paramd != null) {
          paramd.a(com.tencent.mm.plugin.wallet_index.c.b.cr(0, ""), paramIntent);
        }
        paramIntent = new b(str1, paramIntent);
        AppMethodBeat.o(71800);
        return paramIntent;
      }
      catch (JSONException paramIntent)
      {
        aoc("Failed to parse purchase data.");
        ae.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
        paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cr(5, "");
        if (paramd != null) {
          paramd.a(paramIntent, null);
        }
        AppMethodBeat.o(71800);
        return null;
      }
    }
    aoc("Purchase failed. Response: ".concat(String.valueOf(i)));
    paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cr(i, "");
    if (paramd != null) {
      paramd.a(paramIntent, null);
    }
    AppMethodBeat.o(71800);
    return null;
  }
  
  public static int aW(Intent paramIntent)
  {
    AppMethodBeat.i(71803);
    if (paramIntent == null)
    {
      aoc("Intent with no response code, assuming OK (known issue)");
      AppMethodBeat.o(71803);
      return 1;
    }
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      aoc("Intent with no response code, assuming OK (known issue)");
      AppMethodBeat.o(71803);
      return 0;
    }
    int i;
    if ((paramIntent instanceof Integer))
    {
      i = ((Integer)paramIntent).intValue();
      AppMethodBeat.o(71803);
      return i;
    }
    if ((paramIntent instanceof Long))
    {
      i = (int)((Long)paramIntent).longValue();
      AppMethodBeat.o(71803);
      return i;
    }
    aoc("Unexpected type for intent response code.");
    aoc(paramIntent.getClass().getName());
    paramIntent = new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
    AppMethodBeat.o(71803);
    throw paramIntent;
  }
  
  private static void aoc(String paramString)
  {
    AppMethodBeat.i(71802);
    ae.e("MicroMsg.IabResolver", "In-app billing error: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(71802);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.wallet_index.c.b paramb, b paramb1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.a
 * JD-Core Version:    0.7.0.1
 */