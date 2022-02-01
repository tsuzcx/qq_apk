package com.tencent.mm.plugin.sns.waid;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
{
  private static boolean aD(ArrayList<h> paramArrayList)
  {
    AppMethodBeat.i(100588);
    try
    {
      boolean bool = paramArrayList.isEmpty();
      if (bool)
      {
        AppMethodBeat.o(100588);
        return false;
      }
      localObject1 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = ((h)paramArrayList.next()).toJson();
        if (localObject2 != null) {
          ((JSONArray)localObject1).put(localObject2);
        }
      }
      while (((JSONArray)localObject1).length() <= 0) {}
    }
    catch (Exception paramArrayList)
    {
      ac.e("ad.waid.WaidHelper", "batchInsertWaid exp=" + paramArrayList.toString());
      AppMethodBeat.o(100588);
      return false;
    }
    paramArrayList = ai.getContext().getContentResolver();
    Object localObject2 = new ContentValues();
    Object localObject1 = ((JSONArray)localObject1).toString();
    ac.i("ad.waid.WaidHelper", "batchInsertWaid, data=".concat(String.valueOf(localObject1)));
    ((ContentValues)localObject2).put("waid_array", (String)localObject1);
    if (paramArrayList.insert(WaidProvider.zmx, (ContentValues)localObject2) != null)
    {
      AppMethodBeat.o(100588);
      return true;
    }
    AppMethodBeat.o(100588);
    return false;
  }
  
  public static h awd(String paramString)
  {
    AppMethodBeat.i(100589);
    try
    {
      ac.i("ad.waid.WaidHelper", "getWaid pkg=".concat(String.valueOf(paramString)));
      paramString = ai.getContext().getContentResolver().query(WaidProvider.zmx, null, null, new String[] { paramString }, null);
      if ((paramString != null) && (paramString.getCount() > 0))
      {
        paramString.moveToFirst();
        h localh = new h();
        localh.dtC = paramString.getString(paramString.getColumnIndex("pkg"));
        localh.zmu = paramString.getString(paramString.getColumnIndex("waid"));
        localh.zmw = paramString.getInt(paramString.getColumnIndex("expire"));
        localh.zmv = paramString.getInt(paramString.getColumnIndex("timeStamp"));
        localh.type = paramString.getInt(paramString.getColumnIndex("type"));
        paramString.close();
        AppMethodBeat.o(100589);
        return localh;
      }
    }
    catch (Exception paramString)
    {
      ac.e("ad.waid.WaidHelper", "getWaid exp=" + paramString.toString());
      AppMethodBeat.o(100589);
    }
    return null;
  }
  
  public static void awf(String paramString)
  {
    AppMethodBeat.i(100590);
    for (;;)
    {
      int i;
      int j;
      try
      {
        ac.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, xml=".concat(String.valueOf(paramString)));
        l = System.currentTimeMillis();
        localMap = bv.L(paramString, "ADInfo");
        localContentValues = new ContentValues();
        localArrayList = new ArrayList();
        localObject2 = ".ADInfo.waid" + ".appWaid";
        paramString = (String)localMap.get((String)localObject2 + ".pkg");
        localObject1 = (String)localMap.get((String)localObject2 + ".id");
        i = bs.aLy((String)localMap.get((String)localObject2 + ".expire"));
        localObject2 = (String)localObject2 + ".maxCount";
        if (localMap.containsKey(localObject2))
        {
          j = bs.aLy((String)localMap.get(localObject2));
          if (j > 0) {
            localContentValues.put("maxAppWaidCount", Integer.valueOf(j));
          }
        }
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (i <= 0)) {
          break label724;
        }
        localObject2 = new h();
        ((h)localObject2).dtC = paramString;
        ((h)localObject2).zmu = ((String)localObject1);
        ((h)localObject2).zmw = i;
        ((h)localObject2).type = 1;
        localArrayList.add(localObject2);
        i = 1;
        localObject2 = ".ADInfo.waid" + ".pubWaid";
        k = bs.aLy((String)localMap.get((String)localObject2 + ".expire"));
        paramString = (String)localObject2 + ".maxCount";
        if (!localMap.containsKey(paramString)) {
          break label729;
        }
        j = bs.aLy((String)localMap.get(paramString));
        if (j <= 0) {
          break label729;
        }
        localContentValues.put("maxPubWaidCount", Integer.valueOf(j));
      }
      catch (Throwable paramString)
      {
        long l;
        Map localMap;
        ContentValues localContentValues;
        ArrayList localArrayList;
        Object localObject2;
        Object localObject1;
        int k;
        ac.e("ad.waid.WaidHelper", "parseWaidFromAdInfoXML exp=" + paramString.toString());
        AppMethodBeat.o(100590);
        return;
      }
      localObject1 = (String)localObject2 + ".id";
      paramString = (String)localObject1;
      if (j > 0) {
        paramString = (String)localObject1 + j;
      }
      paramString = (String)localMap.get(paramString);
      if ((!TextUtils.isEmpty(paramString)) && (k > 0))
      {
        localObject1 = new h();
        ((h)localObject1).dtC = "";
        ((h)localObject1).zmu = paramString;
        ((h)localObject1).zmw = k;
        ((h)localObject1).type = 2;
        localArrayList.add(localObject1);
        i += 1;
        j += 1;
      }
      else
      {
        paramString = (String)localObject2 + ".pubWaidSwitch";
        if (localMap.containsKey(paramString)) {
          localContentValues.put("pubWaidSwitch", Integer.valueOf(bs.aLy((String)localMap.get(paramString))));
        }
        if (localContentValues.size() > 0)
        {
          ac.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, insert cfg");
          ai.getContext().getContentResolver().insert(WaidProvider.zmy, localContentValues);
        }
        if (!localArrayList.isEmpty()) {
          aD(localArrayList);
        }
        ac.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, timeCost=" + (System.currentTimeMillis() - l) + ", count=" + i);
        AppMethodBeat.o(100590);
        return;
        label724:
        i = 0;
        continue;
        label729:
        j = 0;
      }
    }
  }
  
  public static int awg(String paramString)
  {
    k = 1;
    n = 0;
    AppMethodBeat.i(100591);
    try
    {
      ac.i("ad.waid.WaidHelper", "parseWaidFromJsApi, data=".concat(String.valueOf(paramString)));
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localContentValues = new ContentValues();
      paramString = new JSONObject(paramString);
      localObject1 = paramString.optJSONObject("appWaid");
      paramString = paramString.optJSONObject("pubWaid");
      if (localObject1 == null) {
        break label572;
      }
      str = ((JSONObject)localObject1).optString("pkg");
      localObject2 = ((JSONObject)localObject1).optString("id");
      i = ((JSONObject)localObject1).optInt("expire");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0)) {
        break label567;
      }
      h localh = new h();
      localh.dtC = str;
      localh.zmu = ((String)localObject2);
      localh.zmw = i;
      localh.type = 1;
      localArrayList.add(localh);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int m;
        try
        {
          long l;
          ArrayList localArrayList;
          ContentValues localContentValues;
          Object localObject1;
          String str;
          Object localObject2;
          if (((JSONObject)localObject1).has("maxCount"))
          {
            i = k;
            m = ((JSONObject)localObject1).optInt("maxCount");
            j = k;
            if (m > 0)
            {
              i = k;
              localContentValues.put("maxAppWaidCount", Integer.valueOf(m));
              j = k;
            }
          }
          m = j;
          if (paramString != null)
          {
            i = j;
            int i1 = paramString.optInt("expire");
            i = j;
            localObject1 = paramString.optJSONArray("ids");
            k = j;
            if (localObject1 != null)
            {
              k = j;
              if (i1 > 0)
              {
                i = j;
                int i2 = ((JSONArray)localObject1).length();
                m = n;
                k = j;
                if (m < i2)
                {
                  i = j;
                  str = ((JSONArray)localObject1).getString(m);
                  i = j;
                  k = j;
                  if (TextUtils.isEmpty(str)) {
                    break label577;
                  }
                  i = j;
                  localObject2 = new h();
                  i = j;
                  ((h)localObject2).dtC = "";
                  i = j;
                  ((h)localObject2).zmu = str;
                  i = j;
                  ((h)localObject2).zmw = i1;
                  i = j;
                  ((h)localObject2).type = 2;
                  i = j;
                  localArrayList.add(localObject2);
                  k = j + 1;
                  break label577;
                }
              }
            }
            m = k;
            i = k;
            if (paramString.has("maxCount"))
            {
              i = k;
              j = paramString.optInt("maxCount");
              m = k;
              if (j > 0)
              {
                i = k;
                localContentValues.put("maxPubWaidCount", Integer.valueOf(j));
                m = k;
              }
            }
          }
          i = m;
          if (!localArrayList.isEmpty())
          {
            i = m;
            aD(localArrayList);
          }
          i = m;
          if (localContentValues.size() > 0)
          {
            i = m;
            ac.i("ad.waid.WaidHelper", "parseWaidFromJsApi, insert cfg");
            i = m;
            ai.getContext().getContentResolver().insert(WaidProvider.zmy, localContentValues);
          }
          i = m;
          ac.i("ad.waid.WaidHelper", "parseWaidFromJsApi, timeCost=" + (System.currentTimeMillis() - l) + ", count=" + m);
          i = m;
          AppMethodBeat.o(100591);
          return i;
        }
        catch (Exception paramString)
        {
          int i;
          continue;
        }
        paramString = paramString;
        i = 0;
        ac.e("ad.waid.WaidHelper", "parseWaidFromJsApi, exp=" + paramString.toString());
        continue;
        k = 0;
        continue;
        int j = 0;
        continue;
        m += 1;
        j = k;
      }
    }
    j = k;
    i = k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.g
 * JD-Core Version:    0.7.0.1
 */