package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad
{
  private static ad JFK;
  private int JFE;
  public String JFF;
  public String JFG;
  public String JFH;
  public String JFI;
  public Vector<ac> JFJ;
  public String TAG;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.JFE = 0;
    this.JFF = "";
    this.JFG = "";
    this.JFH = "";
    this.JFI = "";
    this.JFJ = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void aSD(String paramString)
  {
    AppMethodBeat.i(72812);
    g.agS();
    g.agR().agA().set(ah.a.GJR, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static ad fAs()
  {
    AppMethodBeat.i(72815);
    if (JFK == null) {
      JFK = new ad();
    }
    ad localad = JFK;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GJR, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public final void aSE(String paramString)
  {
    AppMethodBeat.i(72818);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.JFE = 0;
      aSD("");
      com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bs.eWi().toString() });
      b.fAg();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.JFJ.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (bs.lr(paramString, localac.FPZ))
      {
        this.JFJ.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void bB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.JFJ = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.JFE = ((JSONObject)localObject).optInt("is_crt_install");
    this.JFI = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.JFF = ((JSONObject)localObject).optString("crt_entry_desc");
    this.JFG = ((JSONObject)localObject).optString("crt_entry_title");
    this.JFH = ((JSONObject)localObject).optString("crt_status_name");
    g.agS();
    g.agR().agA().set(ah.a.GJS, Integer.valueOf(i));
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
          if (localac.JFD == 0) {
            break label267;
          }
          if (bs.isNullOrNil(paramJSONObject)) {
            com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.FPZ });
          } else if (localac.FPZ.equals(paramJSONObject)) {
            this.JFJ.add(localac);
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.FPZ });
        break label286;
        label267:
        this.JFJ.add(localException);
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
  
  public final boolean fAt()
  {
    AppMethodBeat.i(72816);
    if (!bs.isNullOrNil(getCrtNo()))
    {
      if (this.JFE > 0)
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