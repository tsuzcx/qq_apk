package com.tencent.mm.plugin.recharge.a;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a
  implements at
{
  private List<com.tencent.mm.plugin.recharge.model.a> pUG = null;
  
  public static a cfm()
  {
    AppMethodBeat.i(44176);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(44176);
    return locala;
  }
  
  public static com.tencent.mm.plugin.recharge.model.a cfo()
  {
    AppMethodBeat.i(44180);
    Object localObject = (String)g.RL().Ru().get(6, null);
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = new com.tencent.mm.plugin.recharge.model.a((String)localObject, ah.getContext().getString(2131305571), 3);
      AppMethodBeat.o(44180);
      return localObject;
    }
    AppMethodBeat.o(44180);
    return null;
  }
  
  public final boolean a(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(44177);
    if ((parama != null) && (PhoneNumberUtils.isGlobalPhoneNumber(parama.pUJ)))
    {
      List localList = cfn();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        if (parama.pUJ.equals(locala.pUJ))
        {
          if (bo.isNullOrNil(parama.name)) {
            parama.name = locala.name;
          }
          localList.remove(locala);
        }
      }
      localList.add(0, parama);
      cH(localList);
      AppMethodBeat.o(44177);
      return true;
    }
    AppMethodBeat.o(44177);
    return false;
  }
  
  public final void cH(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    AppMethodBeat.i(44178);
    this.pUG = paramList;
    if ((paramList == null) || (paramList.size() == 0)) {
      this.pUG = new LinkedList();
    }
    for (;;)
    {
      paramList = new JSONArray();
      Iterator localIterator = this.pUG.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.recharge.model.a locala = (com.tencent.mm.plugin.recharge.model.a)localIterator.next();
        paramList.put(locala.toJson());
        ab.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[] { locala.name });
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
    ab.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + paramList.toString());
    g.RL().Ru().set(270337, paramList.toString());
    g.RL().Ru().dww();
    AppMethodBeat.o(44178);
  }
  
  public final List<com.tencent.mm.plugin.recharge.model.a> cfn()
  {
    AppMethodBeat.i(44179);
    if (this.pUG != null)
    {
      localObject = this.pUG;
      AppMethodBeat.o(44179);
      return localObject;
    }
    this.pUG = new LinkedList();
    localObject = (String)g.RL().Ru().get(270337, null);
    if (bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.SubCoreRecharge", "empty history");
      localObject = this.pUG;
      AppMethodBeat.o(44179);
      return localObject;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray((String)localObject);
      int i = 0;
      while (i < Math.min(localJSONArray.length(), 100))
      {
        com.tencent.mm.plugin.recharge.model.a locala = com.tencent.mm.plugin.recharge.model.a.ao(localJSONArray.getJSONObject(i));
        if (locala != null) {
          this.pUG.add(locala);
        }
        i += 1;
      }
      String[] arrayOfString;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.SubCoreRecharge", localJSONException, "", new Object[0]);
      localObject = ((String)localObject).split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        i = 0;
        if (i < Math.min(localObject.length, 100))
        {
          arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            this.pUG.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], arrayOfString[1], 2));
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
              this.pUG.add(new com.tencent.mm.plugin.recharge.model.a(arrayOfString[0], "", 2));
            }
          }
        }
      }
      ab.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.pUG.size());
      localObject = this.pUG;
      AppMethodBeat.o(44179);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.a.a
 * JD-Core Version:    0.7.0.1
 */