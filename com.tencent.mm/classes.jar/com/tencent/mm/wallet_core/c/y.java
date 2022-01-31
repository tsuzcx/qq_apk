package com.tencent.mm.wallet_core.c;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y
{
  private static y wAX;
  public String TAG = "MicroMsg.WalletDigCertManager";
  private int wAR = 0;
  public String wAS = "";
  public String wAT = "";
  public String wAU = "";
  public String wAV = "";
  public Vector<x> wAW = new Vector();
  
  public static void afe(String paramString)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.utB, paramString);
  }
  
  public static String cMG()
  {
    g.DQ();
    return (String)g.DP().Dz().get(ac.a.utB, "");
  }
  
  public static y cMH()
  {
    if (wAX == null) {
      wAX = new y();
    }
    return wAX;
  }
  
  public final void aC(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("cert_info");
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.wAW = new Vector();
      int i = ((JSONObject)localObject).optInt("show_crt_info");
      this.wAR = ((JSONObject)localObject).optInt("is_crt_install");
      this.wAV = ((JSONObject)localObject).optString("crt_item_logo_url");
      this.wAS = ((JSONObject)localObject).optString("crt_entry_desc");
      this.wAT = ((JSONObject)localObject).optString("crt_entry_title");
      this.wAU = ((JSONObject)localObject).optString("crt_status_name");
      g.DQ();
      g.DP().Dz().c(ac.a.utC, Integer.valueOf(i));
      paramJSONObject = cMG();
      localObject = ((JSONObject)localObject).optJSONArray("crt_list");
      if (localObject != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          try
          {
            x localx = new x(((JSONArray)localObject).getJSONObject(i));
            if (localx.wAQ == 0) {
              break label257;
            }
            if (bk.bl(paramJSONObject)) {
              com.tencent.mm.sdk.platformtools.y.i(this.TAG, "drop crt list no exist local drop: %s", new Object[] { localx.tNl });
            } else if (localx.tNl.equals(paramJSONObject)) {
              this.wAW.add(localx);
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.y.i(this.TAG, "WalletDigCertManager error %s", new Object[] { localException.getMessage() });
          }
          com.tencent.mm.sdk.platformtools.y.i(this.TAG, "drop crt list %s drop: %s", new Object[] { paramJSONObject, localException.tNl });
          break label267;
          label257:
          this.wAW.add(localException);
          label267:
          i += 1;
        }
      }
    }
  }
  
  public final void aff(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      if (paramString.equals(cMG()))
      {
        this.wAR = 0;
        afe("");
        com.tencent.mm.sdk.platformtools.y.i(this.TAG, "clean token %s  stack %s ", new Object[] { paramString, bk.csb().toString() });
        a.cMr();
        a.clearCert(paramString);
      }
      paramString = this.wAW.iterator();
    } while (!paramString.hasNext());
    paramString = (x)paramString.next();
    this.wAW.remove(paramString);
  }
  
  public final boolean cMI()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bk.bl(cMG()))
    {
      bool1 = bool2;
      if (this.wAR > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */