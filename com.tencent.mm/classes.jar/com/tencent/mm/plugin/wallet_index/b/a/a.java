package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;

public final class a
{
  private static void Fl(String paramString)
  {
    y.e("MicroMsg.IabResolver", "In-app billing error: " + paramString);
  }
  
  public static int a(Intent paramIntent, a.a parama)
  {
    localb = new b();
    int i = aa(paramIntent);
    y.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(i));
    if (i != 0)
    {
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.aP(i, ""), null);
      return i;
    }
    if ((!paramIntent.hasExtra("INAPP_PURCHASE_ITEM_LIST")) || (!paramIntent.hasExtra("INAPP_PURCHASE_DATA_LIST")) || (!paramIntent.hasExtra("INAPP_DATA_SIGNATURE_LIST")))
    {
      Fl("Bundle returned from getPurchases() doesn't contain required fields.");
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.aP(5, ""), null);
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
        String str1 = (String)localArrayList2.get(i);
        Object localObject = (String)paramIntent.get(i);
        String str2 = (String)localArrayList1.get(i);
        y.d("MicroMsg.IabResolver", "Sku is owned: " + str2);
        localObject = new c("inapp", str1, (String)localObject);
        if (TextUtils.isEmpty(((c)localObject).fdD))
        {
          y.w("MicroMsg.IabResolver", "In-app billing warning: " + "BUG: empty/null token!");
          y.d("MicroMsg.IabResolver", "Purchase data: " + str1);
        }
        localb.qKX.put(((c)localObject).iZD, localObject);
        i += 1;
      }
      parama.a(com.tencent.mm.plugin.wallet_index.c.b.aP(0, ""), localb);
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
        parama.a(com.tencent.mm.plugin.wallet_index.c.b.aP(5, ""), localb);
      }
    }
    return 0;
  }
  
  public static b a(Intent paramIntent, d paramd)
  {
    if (paramIntent == null)
    {
      Fl("Null data in IAB activity result.");
      paramIntent = com.tencent.mm.plugin.wallet_index.c.b.aP(5, "");
      if (paramd != null) {
        paramd.a(paramIntent, null);
      }
    }
    label259:
    do
    {
      int i;
      do
      {
        String str1;
        String str2;
        do
        {
          return null;
          i = paramIntent.getIntExtra("RESPONSE_CODE", 0);
          str1 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
          str2 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
          if (i != 0) {
            break label259;
          }
          y.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
          y.d("MicroMsg.IabResolver", "Purchase data: " + str1);
          y.d("MicroMsg.IabResolver", "Data signature: " + str2);
          y.d("MicroMsg.IabResolver", "Extras: " + paramIntent.getExtras());
          if ((str1 != null) && (str2 != null)) {
            break;
          }
          Fl("BUG: either purchaseData or dataSignature is null.");
          paramIntent = com.tencent.mm.plugin.wallet_index.c.b.aP(5, "");
        } while (paramd == null);
        paramd.a(paramIntent, null);
        return null;
        try
        {
          paramIntent = new c("inapp", str1, str2);
          str1 = paramIntent.iZD;
          y.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
          if (paramd != null) {
            paramd.a(com.tencent.mm.plugin.wallet_index.c.b.aP(0, ""), paramIntent);
          }
          paramIntent = new b(str1, paramIntent);
          return paramIntent;
        }
        catch (JSONException paramIntent)
        {
          Fl("Failed to parse purchase data.");
          y.printErrStackTrace("MicroMsg.IabResolver", paramIntent, "", new Object[0]);
          paramIntent = com.tencent.mm.plugin.wallet_index.c.b.aP(5, "");
        }
      } while (paramd == null);
      paramd.a(paramIntent, null);
      return null;
      Fl("Purchase failed. Response: " + i);
      paramIntent = com.tencent.mm.plugin.wallet_index.c.b.aP(i, "");
    } while (paramd == null);
    paramd.a(paramIntent, null);
    return null;
  }
  
  public static int aa(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      Fl("Intent with no response code, assuming OK (known issue)");
      return 1;
    }
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      Fl("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    Fl("Unexpected type for intent response code.");
    Fl(paramIntent.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.a
 * JD-Core Version:    0.7.0.1
 */