package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.az.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class e
  extends a
{
  public int status = 0;
  public String username = null;
  public String vIs = null;
  
  public e(Map<String, String> paramMap)
  {
    super(paramMap);
  }
  
  public e(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
  }
  
  public static int apy(String paramString)
  {
    AppMethodBeat.i(26912);
    g.agS();
    Object localObject1 = (String)g.agR().agA().get(ah.a.GEx, "");
    ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", new Object[] { paramString });
    if (bs.isNullOrNil((String)localObject1))
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
        boolean bool = bs.lr(paramString, localObject1[i]);
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
              ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
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
      ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26912);
    }
    return 1;
  }
  
  public static boolean apz(String paramString)
  {
    AppMethodBeat.i(26913);
    g.agS();
    Object localObject1 = (String)g.agR().agA().get(ah.a.GEy, "");
    ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", new Object[] { paramString });
    if (bs.isNullOrNil((String)localObject1))
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
        boolean bool = bs.lr(paramString, localObject1[i]);
        if (bool) {
          try
          {
            j = Integer.valueOf(localObject2[i]).intValue();
            if (!bs.jl(j, 2))
            {
              bool = bs.jl(j, 3);
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
              ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { localNumberFormatException.getMessage() });
              j = 0;
            }
            bool = bs.jl(j, 1);
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
      ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26913);
    }
    return false;
  }
  
  private static void ek(String paramString, int paramInt)
  {
    AppMethodBeat.i(26911);
    g.agS();
    Object localObject1 = (String)g.agR().agA().get(ah.a.GEy, "");
    ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        String str1;
        Object localObject2;
        if (!bs.isNullOrNil((String)localObject1))
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
              if (bs.lr(paramString, localObject2[i]))
              {
                arrayOfString[i] = String.valueOf(paramInt);
                i = 1;
                localObject2 = new i();
                if (i == 0)
                {
                  str1 = str1 + "," + paramString;
                  localObject1 = (String)localObject1 + "," + paramInt;
                  ((i)localObject2).i("usernames", str1);
                  ((i)localObject2).i("states", localObject1);
                  ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", new Object[] { paramString, Integer.valueOf(paramInt), ((i)localObject2).toString() });
                  g.agS();
                  g.agR().agA().set(ah.a.GEy, ((i)localObject2).toString());
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
        ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(26911);
        return;
      }
    }
  }
  
  public final boolean axn()
  {
    AppMethodBeat.i(26910);
    if (this.values == null)
    {
      ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
      AppMethodBeat.o(26910);
      return false;
    }
    ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    String str2;
    int j;
    Object localObject1;
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username")) {
        this.username = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.vIs = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.status = bs.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status"), 0);
      }
      ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", new Object[] { this.username, this.vIs, Integer.valueOf(this.status) });
      str2 = this.vIs;
      j = this.status;
      g.agS();
      localObject1 = (String)g.agR().agA().get(ah.a.GEx, "");
      ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", new Object[] { str2, Integer.valueOf(j) });
    }
    for (;;)
    {
      try
      {
        if (bs.isNullOrNil((String)localObject1)) {
          continue;
        }
        localObject1 = new i((String)localObject1);
        str1 = ((i)localObject1).optString("svrids");
        localObject1 = ((i)localObject1).optString("states");
        localObject2 = str1.split(",");
        arrayOfString = ((String)localObject1).split(",");
        if ((localObject2 == null) || (arrayOfString == null)) {
          break label692;
        }
        i = 0;
        if (i >= localObject2.length) {
          break label692;
        }
        if (!bs.lr(str2, localObject2[i])) {
          continue;
        }
        arrayOfString[i] = String.valueOf(j);
        i = 1;
        localObject2 = new i();
        if (i != 0) {
          continue;
        }
        str1 = str1 + "," + str2;
        localObject1 = (String)localObject1 + "," + j;
        ((i)localObject2).i("svrids", str1);
        ((i)localObject2).i("states", localObject1);
        ac.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", new Object[] { str2, Integer.valueOf(j), ((i)localObject2).toString() });
        g.agS();
        g.agR().agA().set(ah.a.GEx, ((i)localObject2).toString());
      }
      catch (Exception localException)
      {
        String str1;
        Object localObject2;
        String[] arrayOfString;
        int k;
        String str3;
        ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      ek(this.username, this.status);
      AppMethodBeat.o(26910);
      return true;
      i += 1;
      continue;
      localObject1 = "";
      k = arrayOfString.length;
      int i = 0;
      if (i < k)
      {
        str3 = arrayOfString[i];
        localObject1 = (String)localObject1 + str3 + ",";
        i += 1;
      }
      else
      {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        continue;
        localObject2 = new i();
        localObject1 = String.valueOf(j);
        str1 = str2;
        continue;
        ac.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
        AppMethodBeat.o(26910);
        return false;
        label692:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.e
 * JD-Core Version:    0.7.0.1
 */