package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad
{
  private static ad Iei;
  private int Iec;
  public String Ied;
  public String Iee;
  public String Ief;
  public String Ieg;
  public Vector<ac> Ieh;
  public String TAG;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.Iec = 0;
    this.Ied = "";
    this.Iee = "";
    this.Ief = "";
    this.Ieg = "";
    this.Ieh = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void aNa(String paramString)
  {
    AppMethodBeat.i(72812);
    g.afC();
    g.afB().afk().set(ae.a.Fmc, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static ad fkc()
  {
    AppMethodBeat.i(72815);
    if (Iei == null) {
      Iei = new ad();
    }
    ad localad = Iei;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.Fmc, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public final void aNb(String paramString)
  {
    AppMethodBeat.i(72818);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.Iec = 0;
      aNa("");
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bt.eGN().toString() });
      b.fjR();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.Ieh.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (bt.kU(paramString, localac.EsX))
      {
        this.Ieh.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void bA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.Ieh = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.Iec = ((JSONObject)localObject).optInt("is_crt_install");
    this.Ieg = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.Ied = ((JSONObject)localObject).optString("crt_entry_desc");
    this.Iee = ((JSONObject)localObject).optString("crt_entry_title");
    this.Ief = ((JSONObject)localObject).optString("crt_status_name");
    g.afC();
    g.afB().afk().set(ae.a.Fmd, Integer.valueOf(i));
    paramJSONObject = getCrtNo();
    localObject = ((JSONObject)localObject).optJSONArray("crt_list");
    if (localObject != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        try
        {
          ac localac = new ac(((JSONArray)localObject).getJSONObject(i));
          if (localac.Ieb == 0) {
            break label267;
          }
          if (bt.isNullOrNil(paramJSONObject)) {
            com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.EsX });
          } else if (localac.EsX.equals(paramJSONObject)) {
            this.Ieh.add(localac);
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.EsX });
        break label286;
        label267:
        this.Ieh.add(localException);
      }
      else
      {
        AppMethodBeat.o(72817);
        return;
      }
      label286:
      i += 1;
    }
  }
  
  public final boolean fkd()
  {
    AppMethodBeat.i(72816);
    if (!bt.isNullOrNil(getCrtNo()))
    {
      if (this.Iec > 0)
      {
        AppMethodBeat.o(72816);
        return true;
      }
      AppMethodBeat.o(72816);
      return false;
    }
    AppMethodBeat.o(72816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */