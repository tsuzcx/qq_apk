package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab
{
  private static ab AXv;
  private int AXp;
  public String AXq;
  public String AXr;
  public String AXs;
  public String AXt;
  public Vector<aa> AXu;
  public String TAG;
  
  public ab()
  {
    AppMethodBeat.i(49095);
    this.TAG = "MicroMsg.WalletDigCertManager";
    this.AXp = 0;
    this.AXq = "";
    this.AXr = "";
    this.AXs = "";
    this.AXt = "";
    this.AXu = new Vector();
    AppMethodBeat.o(49095);
  }
  
  public static void avX(String paramString)
  {
    AppMethodBeat.i(49093);
    g.RM();
    g.RL().Ru().set(ac.a.yDE, paramString);
    AppMethodBeat.o(49093);
  }
  
  public static ab dSv()
  {
    AppMethodBeat.i(49096);
    if (AXv == null) {
      AXv = new ab();
    }
    ab localab = AXv;
    AppMethodBeat.o(49096);
    return localab;
  }
  
  public static String getCrtNo()
  {
    AppMethodBeat.i(49094);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yDE, "");
    AppMethodBeat.o(49094);
    return str;
  }
  
  public final void aY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49098);
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null)
    {
      AppMethodBeat.o(49098);
      return;
    }
    this.AXu = new Vector();
    int i = ((JSONObject)localObject).optInt("show_crt_info");
    this.AXp = ((JSONObject)localObject).optInt("is_crt_install");
    this.AXt = ((JSONObject)localObject).optString("crt_item_logo_url");
    this.AXq = ((JSONObject)localObject).optString("crt_entry_desc");
    this.AXr = ((JSONObject)localObject).optString("crt_entry_title");
    this.AXs = ((JSONObject)localObject).optString("crt_status_name");
    g.RM();
    g.RL().Ru().set(ac.a.yDF, Integer.valueOf(i));
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
          aa localaa = new aa(((JSONArray)localObject).getJSONObject(i));
          if (localaa.AXo == 0) {
            break label267;
          }
          if (bo.isNullOrNil(paramJSONObject)) {
            com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localaa.xTJ });
          } else if (localaa.xTJ.equals(paramJSONObject)) {
            this.AXu.add(localaa);
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
        }
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.xTJ });
        break label286;
        label267:
        this.AXu.add(localException);
      }
      else
      {
        AppMethodBeat.o(49098);
        return;
      }
      label286:
      i += 1;
    }
  }
  
  public final void avY(String paramString)
  {
    AppMethodBeat.i(49099);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49099);
      return;
    }
    if (paramString.equals(getCrtNo()))
    {
      this.AXp = 0;
      avX("");
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bo.dtY().toString() });
      b.dSi();
      b.clearCert(paramString);
    }
    paramString = this.AXu.iterator();
    if (paramString.hasNext())
    {
      paramString = (aa)paramString.next();
      this.AXu.remove(paramString);
      AppMethodBeat.o(49099);
      return;
    }
    AppMethodBeat.o(49099);
  }
  
  public final boolean dSw()
  {
    AppMethodBeat.i(49097);
    if (!bo.isNullOrNil(getCrtNo()))
    {
      if (this.AXp > 0)
      {
        AppMethodBeat.o(49097);
        return true;
      }
      AppMethodBeat.o(49097);
      return false;
    }
    AppMethodBeat.o(49097);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ab
 * JD-Core Version:    0.7.0.1
 */