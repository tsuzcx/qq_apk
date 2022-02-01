package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ae
{
  private static ae agTL;
  public String TAG;
  private int agTF;
  public String agTG;
  public String agTH;
  public String agTI;
  public String agTJ;
  public Vector<ad> agTK;
  
  public ae()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.agTF = 0;
    this.agTG = "";
    this.agTH = "";
    this.agTI = "";
    this.agTJ = "";
    this.agTK = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void bEF(String paramString)
  {
    AppMethodBeat.i(72812);
    h.baF();
    h.baE().ban().set(at.a.acOd, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acOd, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public static ae jOT()
  {
    AppMethodBeat.i(72815);
    if (agTL == null) {
      agTL = new ae();
    }
    ae localae = agTL;
    AppMethodBeat.o(72815);
    return localae;
  }
  
  public final void bEG(String paramString)
  {
    AppMethodBeat.i(72818);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.agTF = 0;
      bEF("");
      Log.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, Util.getStack().toString() });
      b.jOG();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.agTK.iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (Util.isEqual(paramString, localad.abMG))
      {
        this.agTK.remove(localad);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void cQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.agTK = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.agTF = ((JSONObject)localObject).optInt("is_crt_install");
    this.agTJ = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.agTG = ((JSONObject)localObject).optString("crt_entry_desc");
    this.agTH = ((JSONObject)localObject).optString("crt_entry_title");
    this.agTI = ((JSONObject)localObject).optString("crt_status_name");
    h.baF();
    h.baE().ban().set(at.a.acOe, Integer.valueOf(i));
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
          ad localad = new ad(((JSONArray)localObject).getJSONObject(i));
          if (localad.agTE == 0) {
            break label267;
          }
          if (Util.isNullOrNil(paramJSONObject)) {
            Log.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localad.abMG });
          } else if (localad.abMG.equals(paramJSONObject)) {
            this.agTK.add(localad);
          }
        }
        catch (Exception localException)
        {
          Log.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        Log.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.abMG });
        break label286;
        label267:
        this.agTK.add(localException);
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
  
  public final boolean jOU()
  {
    AppMethodBeat.i(72816);
    if (!Util.isNullOrNil(getCrtNo()))
    {
      if (this.agTF > 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */