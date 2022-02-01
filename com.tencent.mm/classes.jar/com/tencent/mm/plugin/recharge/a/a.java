package com.tencent.mm.plugin.recharge.a;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a
  implements az
{
  private List<com.tencent.mm.plugin.recharge.model.a> xCV = null;
  
  public static a dGX()
  {
    AppMethodBeat.i(67084);
    a locala = (a)u.ap(a.class);
    AppMethodBeat.o(67084);
    return locala;
  }
  
  public static com.tencent.mm.plugin.recharge.model.a dGZ()
  {
    AppMethodBeat.i(67088);
    Object localObject = (String)g.ajR().ajA().get(6, null);
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = new com.tencent.mm.plugin.recharge.model.a((String)localObject, ak.getContext().getString(2131765787), 3);
      AppMethodBeat.o(67088);
      return localObject;
    }
    AppMethodBeat.o(67088);
    return null;
  }
  
  public final boolean a(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67085);
    if ((parama != null) && (PhoneNumberUtils.isGlobalPhoneNumber(parama.xCY)))
    {
      List localList = dGY();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        if (parama.xCY.equals(locala.xCY))
        {
          if (bu.isNullOrNil(parama.name)) {
            parama.name = locala.name;
          }
          localList.remove(locala);
        }
      }
      localList.add(0, parama);
      fe(localList);
      AppMethodBeat.o(67085);
      return true;
    }
    AppMethodBeat.o(67085);
    return false;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final List<com.tencent.mm.plugin.recharge.model.a> dGY()
  {
    AppMethodBeat.i(67087);
    if (this.xCV != null)
    {
      localObject = this.xCV;
      AppMethodBeat.o(67087);
      return localObject;
    }
    this.xCV = new LinkedList();
    localObject = (String)g.ajR().ajA().get(270337, null);
    if (bu.isNullOrNil((String)localObject))
    {
      ae.i("MicroMsg.SubCoreRecharge", "empty history");
      localObject = this.xCV;
      AppMethodBeat.o(67087);
      return localObject;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray((String)localObject);
      int i = 0;
      while (i < Math.min(localJSONArray.length(), 100))
      {
        com.tencent.mm.plugin.recharge.model.a locala = com.tencent.mm.plugin.recharge.model.a.aN(localJSONArray.getJSONObject(i));
        if (locala != null) {
          this.xCV.add(locala);
        }
        i += 1;
      }
      String[] arrayOfString;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.SubCoreRecharge", localJSONException, "", new Object[0]);
      localObject = ((String)localObject).split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        i = 0;
        if (i < Math.min(localObject.length, 100))
        {
          arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            this.xCV.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], arrayOfString[1], 2));
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
              this.xCV.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], "", 2));
            }
          }
        }
      }
      ae.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.xCV.size());
      localObject = this.xCV;
      AppMethodBeat.o(67087);
    }
  }
  
  public final void fe(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    AppMethodBeat.i(67086);
    this.xCV = paramList;
    if ((paramList == null) || (paramList.size() == 0)) {
      this.xCV = new LinkedList();
    }
    for (;;)
    {
      paramList = new JSONArray();
      Iterator localIterator = this.xCV.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        paramList.put(locala.toJson());
        ae.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[] { locala.name });
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
    ae.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + paramList.toString());
    g.ajR().ajA().set(270337, paramList.toString());
    g.ajR().ajA().fuc();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.a.a
 * JD-Core Version:    0.7.0.1
 */