package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static void a(String paramString, ar.a parama)
  {
    AppMethodBeat.i(187342);
    com.tencent.mm.kernel.h.aHH();
    Object localObject1 = bzY(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(parama, null)));
    label98:
    Object localObject2;
    if (!Util.isNullOrNil((List)localObject1))
    {
      if (((List)localObject1).size() < 5) {
        if (w((List)localObject1, paramString))
        {
          ((List)localObject1).remove(v((List)localObject1, paramString));
          ((List)localObject1).add(0, new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC())));
        }
      }
      for (;;)
      {
        paramString = new JSONArray();
        int i = 0;
        if (i < ((List)localObject1).size())
        {
          com.tencent.mm.ui.contact.a.n localn = (com.tencent.mm.ui.contact.a.n)((List)localObject1).get(i);
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("name", localn.name);
            ((JSONObject)localObject2).put("time", localn.Xyp);
            paramString.put(localObject2);
            i += 1;
            break label98;
            ((List)localObject1).add(0, new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC())));
            continue;
            if (((List)localObject1).size() == 5) {
              if (w((List)localObject1, paramString))
              {
                ((List)localObject1).remove(v((List)localObject1, paramString));
                ((List)localObject1).add(0, new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC())));
              }
              else
              {
                ((List)localObject1).add(0, new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC())));
                ((List)localObject1).remove(((List)localObject1).size() - 1);
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.e("ContactSelectLogic", "addRecentForwardStorage: " + localJSONException2.getMessage());
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("ContactSelectLogic", "recent name list: %s", new Object[] { paramString });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(parama, paramString.toString());
      AppMethodBeat.o(187342);
      return;
      localObject2 = new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC()));
      paramString = new JSONArray();
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("name", ((com.tencent.mm.ui.contact.a.n)localObject2).name);
        ((JSONObject)localObject1).put("time", ((com.tencent.mm.ui.contact.a.n)localObject2).Xyp);
        paramString.put(localObject1);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          Log.e("ContactSelectLogic", "addRecentForwardStorage: " + localJSONException1.getMessage());
        }
      }
    }
  }
  
  private static void b(String paramString, ar.a parama)
  {
    AppMethodBeat.i(293073);
    com.tencent.mm.kernel.h.aHH();
    Object localObject1 = bzY(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(parama, null)));
    Object localObject2;
    if (!Util.isNullOrNil((List)localObject1))
    {
      if (w((List)localObject1, paramString)) {
        ((List)localObject1).remove(v((List)localObject1, paramString));
      }
      paramString = new JSONArray();
      int i = 0;
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          com.tencent.mm.ui.contact.a.n localn = (com.tencent.mm.ui.contact.a.n)((List)localObject1).get(i);
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("name", localn.name);
            ((JSONObject)localObject2).put("time", localn.Xyp);
            paramString.put(localObject2);
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.e("ContactSelectLogic", "deleteRecentForwardStorage: " + localJSONException2.getMessage());
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("ContactSelectLogic", "recent name list: %s", new Object[] { paramString });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(parama, paramString.toString());
      AppMethodBeat.o(293073);
      return;
      localObject2 = new com.tencent.mm.ui.contact.a.n(paramString, Long.valueOf(cm.bfC()));
      paramString = new JSONArray();
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("name", ((com.tencent.mm.ui.contact.a.n)localObject2).name);
        ((JSONObject)localObject1).put("time", ((com.tencent.mm.ui.contact.a.n)localObject2).Xyp);
        paramString.put(localObject1);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          Log.e("ContactSelectLogic", "deleteRecentForwardStorage: " + localJSONException1.getMessage());
        }
      }
    }
  }
  
  private static final boolean bcd(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = ab.lsO;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(102839);
        return false;
      }
      i += 1;
    }
    if (ab.Lj(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (ab.Qm(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static void bzX(String paramString)
  {
    AppMethodBeat.i(187357);
    if (iWB() == 1)
    {
      if (ab.Lj(paramString))
      {
        a(paramString, ar.a.VqS);
        AppMethodBeat.o(187357);
        return;
      }
      a(paramString, ar.a.VqR);
    }
    AppMethodBeat.o(187357);
  }
  
  private static List<com.tencent.mm.ui.contact.a.n> bzY(String paramString)
  {
    AppMethodBeat.i(187362);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(187362);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        localLinkedList.add(new com.tencent.mm.ui.contact.a.n(localJSONObject.optString("name"), Long.valueOf(localJSONObject.optLong("time"))));
        i += 1;
      }
      AppMethodBeat.o(187362);
      return localLinkedList;
    }
    catch (Throwable paramString)
    {
      Log.e("ContactSelectLogic", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(187362);
    }
    return null;
  }
  
  public static List<String> hUC()
  {
    AppMethodBeat.i(187355);
    if (iWB() == 1)
    {
      List localList = k(ar.a.VqS);
      AppMethodBeat.o(187355);
      return localList;
    }
    AppMethodBeat.o(187355);
    return null;
  }
  
  public static List<String> hUD()
  {
    AppMethodBeat.i(187356);
    if (iWB() == 1)
    {
      List localList = k(ar.a.VqR);
      AppMethodBeat.o(187356);
      return localList;
    }
    AppMethodBeat.o(187356);
    return null;
  }
  
  public static List<String> hUE()
  {
    int j = 0;
    AppMethodBeat.i(187359);
    if (iWB() == 1)
    {
      com.tencent.mm.kernel.h.aHH();
      Object localObject3 = bzY(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqR, null)));
      com.tencent.mm.kernel.h.aHH();
      Object localObject1 = bzY(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqS, null)));
      PriorityQueue localPriorityQueue = new PriorityQueue(5, new h.1());
      Object localObject2 = new LinkedList();
      Object localObject4;
      Object localObject5;
      if (!Util.isNullOrNil((List)localObject3))
      {
        i = 0;
        if (i < ((List)localObject3).size())
        {
          localObject4 = ((com.tencent.mm.ui.contact.a.n)((List)localObject3).get(i)).name;
          localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg((String)localObject4);
          az localaz = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwx((String)localObject4);
          if ((localObject5 != null) && (!((as)localObject5).ayc()) && (localaz != null) && (!"hidden_conv_parent".equalsIgnoreCase(localaz.field_parentRef))) {
            ((List)localObject2).add(((List)localObject3).get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            b((String)localObject4, ar.a.VqR);
          }
        }
      }
      if (!Util.isNullOrNil((List)localObject1))
      {
        i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject3 = ((com.tencent.mm.ui.contact.a.n)((List)localObject1).get(i)).name;
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg((String)localObject3);
          localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwx((String)localObject3);
          if ((localObject4 != null) && (!((as)localObject4).ayc()) && (localObject5 != null) && (!"hidden_conv_parent".equalsIgnoreCase(((bb)localObject5).field_parentRef))) {
            ((List)localObject2).add(((List)localObject1).get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            b((String)localObject3, ar.a.VqS);
          }
        }
      }
      if (!Util.isNullOrNil((List)localObject2))
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.ui.contact.a.n)((Iterator)localObject1).next();
          long l = ((com.tencent.mm.ui.contact.a.n)localObject2).Xyp.longValue();
          l = (cm.bfC() - l) / 86400000L;
          if ((l == 0L) || ((l < ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vGg, 365)) && (l > 0L))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label523;
            }
            if (localPriorityQueue.size() >= 5) {
              break label525;
            }
            localPriorityQueue.offer(localObject2);
            break;
          }
          label523:
          continue;
          label525:
          if (((com.tencent.mm.ui.contact.a.n)localPriorityQueue.peek()).Xyp.longValue() < ((com.tencent.mm.ui.contact.a.n)localObject2).Xyp.longValue())
          {
            localPriorityQueue.poll();
            localPriorityQueue.offer(localObject2);
          }
        }
      }
      localObject1 = new LinkedList();
      int i = j;
      while ((i < 5) && (!localPriorityQueue.isEmpty()))
      {
        ((LinkedList)localObject1).addFirst(((com.tencent.mm.ui.contact.a.n)localPriorityQueue.poll()).name);
        i += 1;
      }
      Log.i("ContactSelectLogic", "getTop5RecentForwardName: nameList:" + ((LinkedList)localObject1).toString());
      AppMethodBeat.o(187359);
      return localObject1;
    }
    AppMethodBeat.o(187359);
    return null;
  }
  
  public static int iWB()
  {
    AppMethodBeat.i(293075);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.KHR, 1);
    AppMethodBeat.o(293075);
    return i;
  }
  
  private static List<String> k(ar.a parama)
  {
    AppMethodBeat.i(187338);
    com.tencent.mm.kernel.h.aHH();
    Object localObject = bzY(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(parama, null)));
    parama = new LinkedList();
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.add(((com.tencent.mm.ui.contact.a.n)((Iterator)localObject).next()).name);
      }
    }
    AppMethodBeat.o(187338);
    return parama;
  }
  
  public static final Cursor kB(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = lO(paramList);
    if (paramList.size() == 0)
    {
      com.tencent.mm.kernel.h.aHH();
      paramList = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().hyA();
      AppMethodBeat.o(102837);
      return paramList;
    }
    com.tencent.mm.kernel.h.aHH();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().jD(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> lO(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().a(1, paramList, a.jxD, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        az localaz = new az();
        localaz.convertFrom(paramList);
        int j = i;
        if (bcd(localaz.field_username))
        {
          localArrayList.add(localaz.field_username);
          j = i + 1;
          if (j >= 4) {
            break;
          }
        }
        i = j;
      } while (paramList.moveToNext());
    }
    paramList.close();
    AppMethodBeat.o(102838);
    return localArrayList;
  }
  
  private static int v(List<com.tencent.mm.ui.contact.a.n> paramList, String paramString)
  {
    AppMethodBeat.i(187345);
    if ((Util.isNullOrNil(paramList)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(187345);
      return -1;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (((com.tencent.mm.ui.contact.a.n)paramList.get(i)).name.equals(paramString))
      {
        AppMethodBeat.o(187345);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(187345);
    return -1;
  }
  
  private static boolean w(List<com.tencent.mm.ui.contact.a.n> paramList, String paramString)
  {
    AppMethodBeat.i(187353);
    if ((Util.isNullOrNil(paramList)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(187353);
      return false;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (((com.tencent.mm.ui.contact.a.n)paramList.get(i)).name.equals(paramString))
      {
        AppMethodBeat.o(187353);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(187353);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.h
 * JD-Core Version:    0.7.0.1
 */