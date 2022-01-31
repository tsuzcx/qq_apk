package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;

public final class a
{
  private static void QJ(String paramString)
  {
    AppMethodBeat.i(48167);
    ab.e("MicroMsg.IabResolver", "In-app billing error: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(48167);
  }
  
  public static int a(Intent paramIntent, a.a parama)
  {
    AppMethodBeat.i(48166);
    localb = new b();
    int i = ax(paramIntent);
    ab.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(i));
    if (i != 0)
    {
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.bu(i, ""), null);
      AppMethodBeat.o(48166);
      return i;
    }
    if ((!paramIntent.hasExtra("INAPP_PURCHASE_ITEM_LIST")) || (!paramIntent.hasExtra("INAPP_PURCHASE_DATA_LIST")) || (!paramIntent.hasExtra("INAPP_DATA_SIGNATURE_LIST")))
    {
      QJ("Bundle returned from getPurchases() doesn't contain required fields.");
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.bu(5, ""), null);
      AppMethodBeat.o(48166);
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
        ab.d("MicroMsg.IabResolver", "Sku is owned: ".concat(String.valueOf((String)localArrayList1.get(i))));
        localObject = new c("inapp", str, (String)localObject);
        if (TextUtils.isEmpty(((c)localObject).mToken))
        {
          ab.w("MicroMsg.IabResolver", "In-app billing warning: ".concat(String.valueOf("BUG: empty/null token!")));
          ab.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str)));
        }
        localb.uzT.put(((c)localObject).liu, localObject);
        i += 1;
      }
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.bu(0, ""), localb);
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
        parama.a(com.tencent.mm.plugin.wallet_index.c.b.bu(5, ""), localb);
      }
    }
    AppMethodBeat.o(48166);
    return 0;
  }
  
  public static b a(Intent paramIntent, d paramd)
  {
    AppMethodBeat.i(48165);
    if (paramIntent == null)
    {
      QJ("Null data in IAB activity result.");
      paramIntent = com.tencent.mm.plugin.wallet_index.c.b.bu(5, "");
      if (paramd != null) {
        paramd.a(paramIntent, null);
      }
      AppMethodBeat.o(48165);
      return null;
    }
    int i = paramIntent.getIntExtra("RESPONSE_CODE", 0);
    String str1 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str2 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if (i == 0)
    {
      ab.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
      ab.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str1)));
      ab.d("MicroMsg.IabResolver", "Data signature: ".concat(String.valueOf(str2)));
      ab.d("MicroMsg.IabResolver", "Extras: " + paramIntent.getExtras());
      if ((str1 == null) || (str2 == null))
      {
        QJ("BUG: either purchaseData or dataSignature is null.");
        paramIntent = com.tencent.mm.plugin.wallet_index.c.b.bu(5, "");
        if (paramd != null) {
          paramd.a(paramIntent, null);
        }
        AppMethodBeat.o(48165);
        return null;
      }
      try
      {
        paramIntent = new c("inapp", str1, str2);
        str1 = paramIntent.liu;
        ab.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
        if (paramd != null) {
          paramd.a(com.tencent.mm.plugin.wallet_index.c.b.bu(0, ""), paramIntent);
        }
        paramIntent = new b(str1, paramIntent);
        AppMethodBeat.o(48165);
        return paramIntent;
      }
      catch (JSONException paramIntent)
      {
        QJ("Failed to parse purchase data.");
        ab.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
        paramIntent = com.tencent.mm.plugin.wallet_index.c.b.bu(5, "");
        if (paramd != null) {
          paramd.a(paramIntent, null);
        }
        AppMethodBeat.o(48165);
        return null;
      }
    }
    QJ("Purchase failed. Response: ".concat(String.valueOf(i)));
    paramIntent = com.tencent.mm.plugin.wallet_index.c.b.bu(i, "");
    if (paramd != null) {
      paramd.a(paramIntent, null);
    }
    AppMethodBeat.o(48165);
    return null;
  }
  
  public static int ax(Intent paramIntent)
  {
    AppMethodBeat.i(48168);
    if (paramIntent == null)
    {
      QJ("Intent with no response code, assuming OK (known issue)");
      AppMethodBeat.o(48168);
      return 1;
    }
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      QJ("Intent with no response code, assuming OK (known issue)");
      AppMethodBeat.o(48168);
      return 0;
    }
    int i;
    if ((paramIntent instanceof Integer))
    {
      i = ((Integer)paramIntent).intValue();
      AppMethodBeat.o(48168);
      return i;
    }
    if ((paramIntent instanceof Long))
    {
      i = (int)((Long)paramIntent).longValue();
      AppMethodBeat.o(48168);
      return i;
    }
    QJ("Unexpected type for intent response code.");
    QJ(paramIntent.getClass().getName());
    paramIntent = new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
    AppMethodBeat.o(48168);
    throw paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.a
 * JD-Core Version:    0.7.0.1
 */