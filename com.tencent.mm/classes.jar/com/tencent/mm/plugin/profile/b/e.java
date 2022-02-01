package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.ba.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class e
  extends a
{
  public int status = 0;
  public String username = null;
  public String wPz = null;
  
  public e(Map<String, String> paramMap)
  {
    super(paramMap);
  }
  
  public e(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
  }
  
  public static int auE(String paramString)
  {
    AppMethodBeat.i(26912);
    g.ajD();
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IqQ, "");
    ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", new Object[] { paramString });
    if (bt.isNullOrNil((String)localObject1))
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
        boolean bool = bt.lQ(paramString, localObject1[i]);
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
              ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
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
      ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26912);
    }
    return 1;
  }
  
  public static boolean auF(String paramString)
  {
    AppMethodBeat.i(26913);
    g.ajD();
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IqR, "");
    ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", new Object[] { paramString });
    if (bt.isNullOrNil((String)localObject1))
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
        boolean bool = bt.lQ(paramString, localObject1[i]);
        if (bool) {
          try
          {
            j = Integer.valueOf(localObject2[i]).intValue();
            if (!bt.jx(j, 2))
            {
              bool = bt.jx(j, 3);
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
              ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { localNumberFormatException.getMessage() });
              j = 0;
            }
            bool = bt.jx(j, 1);
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
      ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(26913);
    }
    return false;
  }
  
  private static void eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(26911);
    g.ajD();
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IqR, "");
    ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        String str1;
        Object localObject2;
        if (!bt.isNullOrNil((String)localObject1))
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
              if (bt.lQ(paramString, localObject2[i]))
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
                  ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", new Object[] { paramString, Integer.valueOf(paramInt), ((i)localObject2).toString() });
                  g.ajD();
                  g.ajC().ajl().set(al.a.IqR, ((i)localObject2).toString());
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
        ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(26911);
        return;
      }
    }
  }
  
  public final boolean aAc()
  {
    AppMethodBeat.i(26910);
    if (this.values == null)
    {
      ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
      AppMethodBeat.o(26910);
      return false;
    }
    ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    String str2;
    int j;
    Object localObject1;
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username")) {
        this.username = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.wPz = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
        this.status = bt.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status"), 0);
      }
      ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", new Object[] { this.username, this.wPz, Integer.valueOf(this.status) });
      str2 = this.wPz;
      j = this.status;
      g.ajD();
      localObject1 = (String)g.ajC().ajl().get(al.a.IqQ, "");
      ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", new Object[] { str2, Integer.valueOf(j) });
    }
    for (;;)
    {
      try
      {
        if (bt.isNullOrNil((String)localObject1)) {
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
        if (!bt.lQ(str2, localObject2[i])) {
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
        ((i)localObject2).h("svrids", str1);
        ((i)localObject2).h("states", localObject1);
        ad.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", new Object[] { str2, Integer.valueOf(j), ((i)localObject2).toString() });
        g.ajD();
        g.ajC().ajl().set(al.a.IqQ, ((i)localObject2).toString());
      }
      catch (Exception localException)
      {
        String str1;
        Object localObject2;
        String[] arrayOfString;
        int k;
        String str3;
        ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      eD(this.username, this.status);
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
        ad.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
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