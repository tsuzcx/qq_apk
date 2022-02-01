package com.tencent.mm.plugin.recharge.a;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a
  implements bd
{
  private List<com.tencent.mm.plugin.recharge.model.a> BCU = null;
  
  public static a eHL()
  {
    AppMethodBeat.i(67084);
    a locala = (a)y.at(a.class);
    AppMethodBeat.o(67084);
    return locala;
  }
  
  public static com.tencent.mm.plugin.recharge.model.a eHN()
  {
    AppMethodBeat.i(67088);
    Object localObject = (String)g.aAh().azQ().get(6, null);
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = new com.tencent.mm.plugin.recharge.model.a((String)localObject, MMApplicationContext.getContext().getString(2131768240), 3);
      AppMethodBeat.o(67088);
      return localObject;
    }
    AppMethodBeat.o(67088);
    return null;
  }
  
  public final boolean a(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67085);
    if ((parama != null) && (PhoneNumberUtils.isGlobalPhoneNumber(parama.BCX)))
    {
      List localList = eHM();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        if (parama.BCX.equals(locala.BCX))
        {
          if (Util.isNullOrNil(parama.name)) {
            parama.name = locala.name;
          }
          localList.remove(locala);
        }
      }
      localList.add(0, parama);
      ga(localList);
      AppMethodBeat.o(67085);
      return true;
    }
    AppMethodBeat.o(67085);
    return false;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final List<com.tencent.mm.plugin.recharge.model.a> eHM()
  {
    AppMethodBeat.i(67087);
    if (this.BCU != null)
    {
      localObject = this.BCU;
      AppMethodBeat.o(67087);
      return localObject;
    }
    this.BCU = new LinkedList();
    localObject = (String)g.aAh().azQ().get(270337, null);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.SubCoreRecharge", "empty history");
      localObject = this.BCU;
      AppMethodBeat.o(67087);
      return localObject;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray((String)localObject);
      int i = 0;
      while (i < Math.min(localJSONArray.length(), 100))
      {
        com.tencent.mm.plugin.recharge.model.a locala = com.tencent.mm.plugin.recharge.model.a.bj(localJSONArray.getJSONObject(i));
        if (locala != null) {
          this.BCU.add(locala);
        }
        i += 1;
      }
      String[] arrayOfString;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.SubCoreRecharge", localJSONException, "", new Object[0]);
      localObject = ((String)localObject).split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        i = 0;
        if (i < Math.min(localObject.length, 100))
        {
          arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            this.BCU.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], arrayOfString[1], 2));
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
              this.BCU.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], "", 2));
            }
          }
        }
      }
      Log.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.BCU.size());
      localObject = this.BCU;
      AppMethodBeat.o(67087);
    }
  }
  
  public final void ga(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    AppMethodBeat.i(67086);
    this.BCU = paramList;
    if ((paramList == null) || (paramList.size() == 0)) {
      this.BCU = new LinkedList();
    }
    for (;;)
    {
      paramList = new JSONArray();
      Iterator localIterator = this.BCU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        paramList.put(locala.toJson());
        Log.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[] { locala.name });
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
    Log.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + paramList.toString());
    g.aAh().azQ().set(270337, paramList.toString());
    g.aAh().azQ().gBI();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.a.a
 * JD-Core Version:    0.7.0.1
 */