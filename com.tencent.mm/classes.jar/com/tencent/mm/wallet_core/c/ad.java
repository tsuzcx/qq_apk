package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad
{
  private static ad LVD;
  public String LVA;
  public String LVB;
  public Vector<ac> LVC;
  private int LVx;
  public String LVy;
  public String LVz;
  public String TAG;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.LVx = 0;
    this.LVy = "";
    this.LVz = "";
    this.LVA = "";
    this.LVB = "";
    this.LVC = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void baf(String paramString)
  {
    AppMethodBeat.i(72812);
    g.ajS();
    g.ajR().ajA().set(am.a.IQH, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static ad fVY()
  {
    AppMethodBeat.i(72815);
    if (LVD == null) {
      LVD = new ad();
    }
    ad localad = LVD;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IQH, "");
    AppMethodBeat.o(72813);
    return str;
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
    this.LVC = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.LVx = ((JSONObject)localObject).optInt("is_crt_install");
    this.LVB = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.LVy = ((JSONObject)localObject).optString("crt_entry_desc");
    this.LVz = ((JSONObject)localObject).optString("crt_entry_title");
    this.LVA = ((JSONObject)localObject).optString("crt_status_name");
    g.ajS();
    g.ajR().ajA().set(am.a.IQI, Integer.valueOf(i));
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
          if (localac.LVw == 0) {
            break label267;
          }
          if (bu.isNullOrNil(paramJSONObject)) {
            ae.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.HUr });
          } else if (localac.HUr.equals(paramJSONObject)) {
            this.LVC.add(localac);
          }
        }
        catch (Exception localException)
        {
          ae.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        ae.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.HUr });
        break label286;
        label267:
        this.LVC.add(localException);
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
  
  public final void bag(String paramString)
  {
    AppMethodBeat.i(72818);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.LVx = 0;
      baf("");
      ae.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bu.fpN().toString() });
      b.fVM();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.LVC.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (bu.lX(paramString, localac.HUr))
      {
        this.LVC.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final boolean fVZ()
  {
    AppMethodBeat.i(72816);
    if (!bu.isNullOrNil(getCrtNo()))
    {
      if (this.LVx > 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */