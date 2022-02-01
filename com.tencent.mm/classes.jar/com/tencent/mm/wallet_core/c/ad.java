package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad
{
  private static ad LyO;
  private int LyI;
  public String LyJ;
  public String LyK;
  public String LyL;
  public String LyM;
  public Vector<ac> LyN;
  public String TAG;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.LyI = 0;
    this.LyJ = "";
    this.LyK = "";
    this.LyL = "";
    this.LyM = "";
    this.LyN = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void aYC(String paramString)
  {
    AppMethodBeat.i(72812);
    g.ajD();
    g.ajC().ajl().set(al.a.Iwj, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static ad fRC()
  {
    AppMethodBeat.i(72815);
    if (LyO == null) {
      LyO = new ad();
    }
    ad localad = LyO;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.Iwj, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public final void aYD(String paramString)
  {
    AppMethodBeat.i(72818);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.LyI = 0;
      aYC("");
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bt.flS().toString() });
      b.fRq();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.LyN.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (bt.lQ(paramString, localac.HAE))
      {
        this.LyN.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void bK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.LyN = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.LyI = ((JSONObject)localObject).optInt("is_crt_install");
    this.LyM = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.LyJ = ((JSONObject)localObject).optString("crt_entry_desc");
    this.LyK = ((JSONObject)localObject).optString("crt_entry_title");
    this.LyL = ((JSONObject)localObject).optString("crt_status_name");
    g.ajD();
    g.ajC().ajl().set(al.a.Iwk, Integer.valueOf(i));
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
          if (localac.LyH == 0) {
            break label267;
          }
          if (bt.isNullOrNil(paramJSONObject)) {
            com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.HAE });
          } else if (localac.HAE.equals(paramJSONObject)) {
            this.LyN.add(localac);
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.HAE });
        break label286;
        label267:
        this.LyN.add(localException);
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
  
  public final boolean fRD()
  {
    AppMethodBeat.i(72816);
    if (!bt.isNullOrNil(getCrtNo()))
    {
      if (this.LyI > 0)
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