package com.tencent.mm.storage.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.ck;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static boolean admX = false;
  
  private static void a(at.a parama, Queue<ck> paramQueue)
  {
    AppMethodBeat.i(248728);
    if (parama == null)
    {
      AppMethodBeat.o(248728);
      return;
    }
    h.baF();
    Object localObject1 = (String)h.baE().ban().get(parama, null);
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(248728);
      return;
    }
    List localList = bzs((String)localObject1);
    if (Util.isNullOrNil(localList))
    {
      AppMethodBeat.o(248728);
      return;
    }
    int k = 0;
    if (k < localList.size())
    {
      localObject1 = (a)localList.get(k);
      Object localObject2 = new ck();
      ((ck)localObject2).userName = ((a)localObject1).name;
      ((ck)localObject2).adlo = ((a)localObject1).admT.longValue();
      ((ck)localObject2).adlp = b.bzr(((ck)localObject2).userName);
      paramQueue.offer(localObject2);
      localObject1 = ((a)localObject1).name;
      h.baF();
      localObject2 = bzs(Util.nullAsNil((String)h.baE().ban().get(parama, null)));
      label254:
      Object localObject3;
      if (!Util.isNullOrNil((List)localObject2))
      {
        int i;
        if ((Util.isNullOrNil((List)localObject2)) || (Util.isNullOrNil((String)localObject1))) {
          i = 0;
        }
        for (;;)
        {
          a locala;
          if (i != 0)
          {
            if ((Util.isNullOrNil((List)localObject2)) || (Util.isNullOrNil((String)localObject1)))
            {
              i = -1;
              ((List)localObject2).remove(i);
            }
          }
          else
          {
            localObject1 = new JSONArray();
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break label459;
            }
            locala = (a)((List)localObject2).get(i);
            localObject3 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject3).put("name", locala.name);
            ((JSONObject)localObject3).put("time", locala.admT);
            ((JSONArray)localObject1).put(localObject3);
            i += 1;
            break label254;
            i = 0;
            for (;;)
            {
              if (i >= ((List)localObject2).size()) {
                break label375;
              }
              if (((a)((List)localObject2).get(i)).name.equals(localObject1))
              {
                i = 1;
                break;
              }
              i += 1;
            }
            label375:
            i = 0;
            continue;
            int j = 0;
            for (;;)
            {
              if (j >= ((List)localObject2).size()) {
                break label424;
              }
              i = j;
              if (((a)((List)localObject2).get(j)).name.equals(localObject1)) {
                break;
              }
              j += 1;
            }
            label424:
            i = -1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.e("RecentForwardStorage", "deleteRecentForwardStorage: " + localJSONException2.getMessage());
            }
          }
        }
      }
      for (;;)
      {
        label459:
        Log.i("RecentForwardStorage", "recent name list: %s", new Object[] { localObject1 });
        h.baF();
        h.baE().ban().set(parama, ((JSONArray)localObject1).toString());
        k += 1;
        break;
        localObject3 = new a((String)localObject1, Long.valueOf(cn.bDu()));
        localObject1 = new JSONArray();
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("name", ((a)localObject3).name);
          ((JSONObject)localObject2).put("time", ((a)localObject3).admT);
          ((JSONArray)localObject1).put(localObject2);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            Log.e("RecentForwardStorage", "deleteRecentForwardStorage: " + localJSONException1.getMessage());
          }
        }
      }
    }
    AppMethodBeat.o(248728);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(248717);
    if (!admX)
    {
      PriorityQueue localPriorityQueue = new PriorityQueue(10, new Comparator() {});
      LinkedList localLinkedList = new LinkedList();
      a(at.a.acSt, localPriorityQueue);
      a(at.a.acSu, localPriorityQueue);
      while (localPriorityQueue.peek() != null) {
        localLinkedList.add((ck)localPriorityQueue.poll());
      }
      paramb.ni(localLinkedList);
      admX = true;
      Log.i("RecentForwardStorage", "dataTransfer: infoList.size:" + localLinkedList.size());
    }
    AppMethodBeat.o(248717);
  }
  
  private static List<a> bzs(String paramString)
  {
    AppMethodBeat.i(248734);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(248734);
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
        localLinkedList.add(new a(localJSONObject.optString("name"), Long.valueOf(localJSONObject.optLong("time"))));
        i += 1;
      }
      AppMethodBeat.o(248734);
      return localLinkedList;
    }
    finally
    {
      Log.e("RecentForwardStorage", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(248734);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.c.c
 * JD-Core Version:    0.7.0.1
 */