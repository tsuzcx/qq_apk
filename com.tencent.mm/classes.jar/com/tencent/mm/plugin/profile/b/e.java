package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.az.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class e
  extends a
{
  public String BcW = null;
  public int status = 0;
  public String username = null;
  
  public e(Map<String, String> paramMap)
  {
    super(paramMap);
  }
  
  public e(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  public static int aKl(String paramString)
  {
    AppMethodBeat.i(26912);
    g.aAi();
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.NTn, "");
    Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", new Object[] { paramString });
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(26912);
      return 1;
    }
    try
    {
      Object localObject2 = new i((String)localObject1);
      localObject1 = ((i)localObject2).optString("svrids");
      localObject2 = ((i)localObject2).optString("states");
      localObject1 = ((String)localObject1).split(",");
      localObject2 = ((String)localObject2).split(",");
      if ((localObject1 == null) || (localObject2 == null))
      {
        AppMethodBeat.o(26912);
        return 1;
      }
      int i = 0;
      while (i < localObject1.length)
      {
        boolean bool = Util.isEqual(paramString, localObject1[i]);
        if (bool) {
          try
          {
            i = Integer.valueOf(localObject2[i]).intValue();
            AppMethodBeat.o(26912);
            return i;
          }
          catch (NumberFormatException paramString)
          {
            for (;;)
            {
              Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
              i = 0;
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(26912);
      return 1;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26912);
    }
    return 1;
  }
  
  public static boolean aKm(String paramString)
  {
    AppMethodBeat.i(26913);
    g.aAi();
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.NTo, "");
    Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", new Object[] { paramString });
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(26913);
      return false;
    }
    try
    {
      Object localObject2 = new i((String)localObject1);
      localObject1 = ((i)localObject2).optString("usernames");
      localObject2 = ((i)localObject2).optString("states");
      localObject1 = ((String)localObject1).split(",");
      localObject2 = ((String)localObject2).split(",");
      if ((localObject1 == null) || (localObject2 == null))
      {
        AppMethodBeat.o(26913);
        return false;
      }
      int i = 0;
      while (i < localObject1.length)
      {
        boolean bool = Util.isEqual(paramString, localObject1[i]);
        if (bool) {
          try
          {
            j = Integer.valueOf(localObject2[i]).intValue();
            if (!Util.isEqual(j, 2))
            {
              bool = Util.isEqual(j, 3);
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(26913);
              return true;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int j;
            for (;;)
            {
              Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { localNumberFormatException.getMessage() });
              j = 0;
            }
            bool = Util.isEqual(j, 1);
            if (bool)
            {
              AppMethodBeat.o(26913);
              return false;
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(26913);
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26913);
    }
    return false;
  }
  
  private static void fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(231828);
    g.aAi();
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.NTn, "");
    Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        String str1;
        Object localObject2;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = new i((String)localObject1);
          str1 = ((i)localObject1).optString("svrids");
          localObject1 = ((i)localObject1).optString("states");
          localObject2 = str1.split(",");
          String[] arrayOfString = ((String)localObject1).split(",");
          if ((localObject2 != null) && (arrayOfString != null))
          {
            i = 0;
            if (i < localObject2.length)
            {
              if (Util.isEqual(paramString, localObject2[i]))
              {
                arrayOfString[i] = String.valueOf(paramInt);
                i = 1;
                localObject2 = new i();
                if (i == 0)
                {
                  str1 = str1 + "," + paramString;
                  localObject1 = (String)localObject1 + "," + paramInt;
                  ((i)localObject2).h("svrids", str1);
                  ((i)localObject2).h("states", localObject1);
                  Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", new Object[] { paramString, Integer.valueOf(paramInt), ((i)localObject2).toString() });
                  g.aAi();
                  g.aAh().azQ().set(ar.a.NTn, ((i)localObject2).toString());
                  AppMethodBeat.o(231828);
                }
              }
              else
              {
                i += 1;
                continue;
              }
              localObject1 = "";
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                localObject1 = (String)localObject1 + str2 + ",";
                i += 1;
                continue;
              }
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
              continue;
            }
          }
        }
        else
        {
          localObject2 = new i();
          localObject1 = String.valueOf(paramInt);
          str1 = paramString;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(231828);
        return;
      }
    }
  }
  
  private static void fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(26911);
    g.aAi();
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.NTo, "");
    Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        String str1;
        Object localObject2;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = new i((String)localObject1);
          str1 = ((i)localObject1).optString("usernames");
          localObject1 = ((i)localObject1).optString("states");
          localObject2 = str1.split(",");
          String[] arrayOfString = ((String)localObject1).split(",");
          if ((localObject2 != null) && (arrayOfString != null))
          {
            i = 0;
            if (i < localObject2.length)
            {
              if (Util.isEqual(paramString, localObject2[i]))
              {
                arrayOfString[i] = String.valueOf(paramInt);
                i = 1;
                localObject2 = new i();
                if (i == 0)
                {
                  str1 = str1 + "," + paramString;
                  localObject1 = (String)localObject1 + "," + paramInt;
                  ((i)localObject2).h("usernames", str1);
                  ((i)localObject2).h("states", localObject1);
                  Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", new Object[] { paramString, Integer.valueOf(paramInt), ((i)localObject2).toString() });
                  g.aAi();
                  g.aAh().azQ().set(ar.a.NTo, ((i)localObject2).toString());
                  AppMethodBeat.o(26911);
                }
              }
              else
              {
                i += 1;
                continue;
              }
              localObject1 = "";
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                localObject1 = (String)localObject1 + str2 + ",";
                i += 1;
                continue;
              }
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
              continue;
            }
          }
        }
        else
        {
          localObject2 = new i();
          localObject1 = String.valueOf(paramInt);
          str1 = paramString;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(26911);
        return;
      }
    }
  }
  
  public final boolean aTA()
  {
    AppMethodBeat.i(26910);
    if (this.values == null)
    {
      Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
      AppMethodBeat.o(26910);
      return false;
    }
    Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!Util.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username")) {
        this.username = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.BcW = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.status = Util.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status"), 0);
      }
      Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", new Object[] { this.username, this.BcW, Integer.valueOf(this.status) });
      fb(this.BcW, this.status);
      fc(this.username, this.status);
      AppMethodBeat.o(26910);
      return true;
    }
    Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(26910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.e
 * JD-Core Version:    0.7.0.1
 */