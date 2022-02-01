package com.tencent.mm.plugin.recharge.a;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a
  implements aw
{
  private List<com.tencent.mm.plugin.recharge.model.a> uWA = null;
  
  public static a dfC()
  {
    AppMethodBeat.i(67084);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(67084);
    return locala;
  }
  
  public static com.tencent.mm.plugin.recharge.model.a dfE()
  {
    AppMethodBeat.i(67088);
    Object localObject = (String)g.afB().afk().get(6, null);
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = new com.tencent.mm.plugin.recharge.model.a((String)localObject, aj.getContext().getString(2131765787), 3);
      AppMethodBeat.o(67088);
      return localObject;
    }
    AppMethodBeat.o(67088);
    return null;
  }
  
  public final boolean a(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67085);
    if ((parama != null) && (PhoneNumberUtils.isGlobalPhoneNumber(parama.uWD)))
    {
      List localList = dfD();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        if (parama.uWD.equals(locala.uWD))
        {
          if (bt.isNullOrNil(parama.name)) {
            parama.name = locala.name;
          }
          localList.remove(locala);
        }
      }
      localList.add(0, parama);
      eD(localList);
      AppMethodBeat.o(67085);
      return true;
    }
    AppMethodBeat.o(67085);
    return false;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final List<com.tencent.mm.plugin.recharge.model.a> dfD()
  {
    AppMethodBeat.i(67087);
    if (this.uWA != null)
    {
      localObject = this.uWA;
      AppMethodBeat.o(67087);
      return localObject;
    }
    this.uWA = new LinkedList();
    localObject = (String)g.afB().afk().get(270337, null);
    if (bt.isNullOrNil((String)localObject))
    {
      ad.i("MicroMsg.SubCoreRecharge", "empty history");
      localObject = this.uWA;
      AppMethodBeat.o(67087);
      return localObject;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray((String)localObject);
      int i = 0;
      while (i < Math.min(localJSONArray.length(), 100))
      {
        com.tencent.mm.plugin.recharge.model.a locala = com.tencent.mm.plugin.recharge.model.a.aD(localJSONArray.getJSONObject(i));
        if (locala != null) {
          this.uWA.add(locala);
        }
        i += 1;
      }
      String[] arrayOfString;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.SubCoreRecharge", localJSONException, "", new Object[0]);
      localObject = ((String)localObject).split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        i = 0;
        if (i < Math.min(localObject.length, 100))
        {
          arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            this.uWA.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], arrayOfString[1], 2));
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
              this.uWA.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], "", 2));
            }
          }
        }
      }
      ad.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.uWA.size());
      localObject = this.uWA;
      AppMethodBeat.o(67087);
    }
  }
  
  public final void eD(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    AppMethodBeat.i(67086);
    this.uWA = paramList;
    if ((paramList == null) || (paramList.size() == 0)) {
      this.uWA = new LinkedList();
    }
    for (;;)
    {
      paramList = new JSONArray();
      Iterator localIterator = this.uWA.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        paramList.put(locala.toJson());
        ad.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[] { locala.name });
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
    ad.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + paramList.toString());
    g.afB().afk().set(270337, paramList.toString());
    g.afB().afk().eKy();
    AppMethodBeat.o(67086);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.a.a
 * JD-Core Version:    0.7.0.1
 */