package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
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
  private static ad YVR;
  public String TAG;
  private int YVL;
  public String YVM;
  public String YVN;
  public String YVO;
  public String YVP;
  public Vector<ac> YVQ;
  
  public ad()
  {
    AppMethodBeat.i(72814);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.YVL = 0;
    this.YVM = "";
    this.YVN = "";
    this.YVO = "";
    this.YVP = "";
    this.YVQ = new Vector();
    AppMethodBeat.o(72814);
  }
  
  public static void bCk(String paramString)
  {
    AppMethodBeat.i(72812);
    h.aHH();
    h.aHG().aHp().set(ar.a.VmI, paramString);
    AppMethodBeat.o(72812);
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(72813);
    h.aHH();
    String str = (String)h.aHG().aHp().get(ar.a.VmI, "");
    AppMethodBeat.o(72813);
    return str;
  }
  
  public static ad iiX()
  {
    AppMethodBeat.i(72815);
    if (YVR == null) {
      YVR = new ad();
    }
    ad localad = YVR;
    AppMethodBeat.o(72815);
    return localad;
  }
  
  public final void bCl(String paramString)
  {
    AppMethodBeat.i(72818);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72818);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.YVL = 0;
      bCk("");
      Log.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, Util.getStack().toString() });
      b.iiL();
      b.clearCert(paramString);
    }
    Iterator localIterator = this.YVQ.iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (Util.isEqual(paramString, localac.Uto))
      {
        this.YVQ.remove(localac);
        AppMethodBeat.o(72818);
        return;
      }
    }
    AppMethodBeat.o(72818);
  }
  
  public final void cv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72817);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(72817);
      return;
    }
    this.YVQ = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.YVL = ((JSONObject)localObject).optInt("is_crt_install");
    this.YVP = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.YVM = ((JSONObject)localObject).optString("crt_entry_desc");
    this.YVN = ((JSONObject)localObject).optString("crt_entry_title");
    this.YVO = ((JSONObject)localObject).optString("crt_status_name");
    h.aHH();
    h.aHG().aHp().set(ar.a.VmJ, Integer.valueOf(i));
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
          if (localac.YVK == 0) {
            break label267;
          }
          if (Util.isNullOrNil(paramJSONObject)) {
            Log.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localac.Uto });
          } else if (localac.Uto.equals(paramJSONObject)) {
            this.YVQ.add(localac);
          }
        }
        catch (Exception localException)
        {
          Log.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        Log.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.Uto });
        break label286;
        label267:
        this.YVQ.add(localException);
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
  
  public final boolean iiY()
  {
    AppMethodBeat.i(72816);
    if (!Util.isNullOrNil(getCrtNo()))
    {
      if (this.YVL > 0)
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