package com.tencent.mm.plugin.recharge.a;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a
  implements ar
{
  private List<com.tencent.mm.plugin.recharge.model.a> nps = null;
  
  public static a bva()
  {
    return (a)p.B(a.class);
  }
  
  public static com.tencent.mm.plugin.recharge.model.a bvc()
  {
    String str = (String)g.DP().Dz().get(6, null);
    if (!bk.bl(str)) {
      return new com.tencent.mm.plugin.recharge.model.a(str, ae.getContext().getString(a.i.wallet_recharge_me), 3);
    }
    return null;
  }
  
  public final boolean a(com.tencent.mm.plugin.recharge.model.a parama)
  {
    if ((parama != null) && (PhoneNumberUtils.isGlobalPhoneNumber(parama.npv)))
    {
      List localList = bvb();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        if (parama.npv.equals(locala.npv))
        {
          if (bk.bl(parama.name)) {
            parama.name = locala.name;
          }
          localList.remove(locala);
        }
      }
      localList.add(0, parama);
      ce(localList);
      return true;
    }
    return false;
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final List<com.tencent.mm.plugin.recharge.model.a> bvb()
  {
    if (this.nps != null) {
      return this.nps;
    }
    this.nps = new LinkedList();
    Object localObject = (String)g.DP().Dz().get(270337, null);
    if (bk.bl((String)localObject))
    {
      y.i("MicroMsg.SubCoreRecharge", "empty history");
      return this.nps;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray((String)localObject);
      int i = 0;
      while (i < Math.min(localJSONArray.length(), 100))
      {
        com.tencent.mm.plugin.recharge.model.a locala = com.tencent.mm.plugin.recharge.model.a.ag(localJSONArray.getJSONObject(i));
        if (locala != null) {
          this.nps.add(locala);
        }
        i += 1;
      }
      String[] arrayOfString;
      return this.nps;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.SubCoreRecharge", localJSONException, "", new Object[0]);
      localObject = ((String)localObject).split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        i = 0;
        if (i < Math.min(localObject.length, 100))
        {
          arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            this.nps.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], arrayOfString[1], 2));
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
              this.nps.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], "", 2));
            }
          }
        }
      }
      y.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.nps.size());
    }
  }
  
  public final void ce(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    this.nps = paramList;
    if ((paramList == null) || (paramList.size() == 0)) {
      this.nps = new LinkedList();
    }
    for (;;)
    {
      paramList = new JSONArray();
      Iterator localIterator = this.nps.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        paramList.put(locala.toJson());
        y.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[] { locala.name });
      }
      if (paramList.size() > 10)
      {
        int i = paramList.size() - 1;
        while (i >= 10)
        {
          paramList.remove(i);
          i -= 1;
        }
      }
    }
    y.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + paramList.toString());
    g.DP().Dz().o(270337, paramList.toString());
    g.DP().Dz().mC(true);
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.a.a
 * JD-Core Version:    0.7.0.1
 */