package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad
{
  private static ad Rut;
  private int Run;
  public String Ruo;
  public String Rup;
  public String Ruq;
  public String Rur;
  public Vector<ac> Rus;
  public String TAG;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.Run = 0;
    this.Ruo = "";
    this.Rup = "";
    this.Ruq = "";
    this.Rur = "";
    this.Rus = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void bpn(String paramString)
  {
    AppMethodBeat.i(72812);
    g.aAi();
    g.aAh().azQ().set(ar.a.NYI, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NYI, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public static ad hhv()
  {
    AppMethodBeat.i(72815);
    if (Rut == null) {
      Rut = new ad();
    }
    ad localad = Rut;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public final void bpo(String paramString)
  {
    AppMethodBeat.i(72818);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.Run = 0;
      bpn("");
      Log.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, Util.getStack().toString() });
      b.hhj();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.Rus.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (Util.isEqual(paramString, localac.NgK))
      {
        this.Rus.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void ck(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.Rus = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.Run = ((JSONObject)localObject).optInt("is_crt_install");
    this.Rur = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.Ruo = ((JSONObject)localObject).optString("crt_entry_desc");
    this.Rup = ((JSONObject)localObject).optString("crt_entry_title");
    this.Ruq = ((JSONObject)localObject).optString("crt_status_name");
    g.aAi();
    g.aAh().azQ().set(ar.a.NYJ, Integer.valueOf(i));
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
          if (localac.Rum == 0) {
            break label267;
          }
          if (Util.isNullOrNil(paramJSONObject)) {
            Log.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.NgK });
          } else if (localac.NgK.equals(paramJSONObject)) {
            this.Rus.add(localac);
          }
        }
        catch (Exception localException)
        {
          Log.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        Log.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.NgK });
        break label286;
        label267:
        this.Rus.add(localException);
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
  
  public final boolean hhw()
  {
    AppMethodBeat.i(72816);
    if (!Util.isNullOrNil(getCrtNo()))
    {
      if (this.Run > 0)
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