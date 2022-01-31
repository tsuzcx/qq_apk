package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ad
  extends com.tencent.mm.n.a
  implements Cloneable
{
  public String yMc = null;
  public CharSequence ywx;
  
  public ad() {}
  
  public ad(String paramString)
  {
    super(paramString);
  }
  
  public static boolean Nt(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean arc(String paramString)
  {
    AppMethodBeat.i(60107);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@t.qq.com");
      AppMethodBeat.o(60107);
      return bool;
    }
    AppMethodBeat.o(60107);
    return false;
  }
  
  public static boolean ard(String paramString)
  {
    AppMethodBeat.i(60108);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qr");
      AppMethodBeat.o(60108);
      return bool;
    }
    AppMethodBeat.o(60108);
    return false;
  }
  
  public static boolean are(String paramString)
  {
    AppMethodBeat.i(60109);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qqim");
      AppMethodBeat.o(60109);
      return bool;
    }
    AppMethodBeat.o(60109);
    return false;
  }
  
  public static boolean arf(String paramString)
  {
    AppMethodBeat.i(60110);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@openim");
      AppMethodBeat.o(60110);
      return bool;
    }
    AppMethodBeat.o(60110);
    return false;
  }
  
  public static boolean arg(String paramString)
  {
    AppMethodBeat.i(60111);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@im.chatroom");
      AppMethodBeat.o(60111);
      return bool;
    }
    AppMethodBeat.o(60111);
    return false;
  }
  
  public static boolean arh(String paramString)
  {
    AppMethodBeat.i(60112);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@fb");
      AppMethodBeat.o(60112);
      return bool;
    }
    AppMethodBeat.o(60112);
    return false;
  }
  
  public static boolean ari(String paramString)
  {
    AppMethodBeat.i(60115);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(60115);
      return false;
    }
    if (arf(paramString))
    {
      AppMethodBeat.o(60115);
      return true;
    }
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nr().R("HideWechatID", "idprefix");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int i = 0;
      while (i < localObject.length)
      {
        if ((localObject[i] != null) && (paramString.startsWith(localObject[i])))
        {
          AppMethodBeat.o(60115);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(60115);
    return false;
  }
  
  public static boolean arj(String paramString)
  {
    AppMethodBeat.i(60116);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(60116);
      return true;
    }
    String[] arrayOfString = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if ((!bo.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(60116);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(60116);
    return false;
  }
  
  public static String ark(String paramString)
  {
    AppMethodBeat.i(60117);
    if (nM(paramString))
    {
      String[] arrayOfString = paramString.split(":");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(60117);
        return paramString;
      }
      paramString = arrayOfString[0];
      AppMethodBeat.o(60117);
      return paramString;
    }
    if ((paramString != null) && (paramString.contains("@")))
    {
      AppMethodBeat.o(60117);
      return "";
    }
    paramString = paramString + "@bottle";
    AppMethodBeat.o(60117);
    return paramString;
  }
  
  public static int dwA()
  {
    return 16;
  }
  
  public static int dwB()
  {
    return 8;
  }
  
  public static boolean nM(String paramString)
  {
    AppMethodBeat.i(60113);
    if (paramString != null)
    {
      if ((paramString.contains("@bottle:")) || (paramString.endsWith("@bottle")))
      {
        AppMethodBeat.o(60113);
        return true;
      }
      AppMethodBeat.o(60113);
      return false;
    }
    AppMethodBeat.o(60113);
    return false;
  }
  
  public static boolean na(String paramString)
  {
    AppMethodBeat.i(60114);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@app");
      AppMethodBeat.o(60114);
      return bool;
    }
    AppMethodBeat.o(60114);
    return false;
  }
  
  public static String o(Cursor paramCursor)
  {
    AppMethodBeat.i(60119);
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("username"));
    AppMethodBeat.o(60119);
    return paramCursor;
  }
  
  public final boolean dwC()
  {
    AppMethodBeat.i(60118);
    if ((int)bo.aox() - this.dqR > 86400L)
    {
      AppMethodBeat.o(60118);
      return true;
    }
    AppMethodBeat.o(60118);
    return false;
  }
  
  public final String dwD()
  {
    AppMethodBeat.i(60122);
    Object localObject = this.dqQ;
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(60122);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 2))
    {
      AppMethodBeat.o(60122);
      return "";
    }
    localObject = bo.nullAsNil(localObject[1]);
    AppMethodBeat.o(60122);
    return localObject;
  }
  
  public final void dwE()
  {
    AppMethodBeat.i(60128);
    Object localObject = this.dqQ;
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(60128);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.asx(localObject[0]))
        {
          RegionCodeDecoder.dyE();
          super.jG(RegionCodeDecoder.iq(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.dyE();
          super.jH(RegionCodeDecoder.aG(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(60128);
          return;
          RegionCodeDecoder.dyE();
          super.jG(RegionCodeDecoder.asy(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.dyE();
        super.jG(RegionCodeDecoder.asy(localObject[0]));
        RegionCodeDecoder.dyE();
        super.jH(RegionCodeDecoder.iq(localObject[0], localObject[1]));
        AppMethodBeat.o(60128);
        return;
      }
      RegionCodeDecoder.dyE();
      super.jG(RegionCodeDecoder.asy(localObject[0]));
      super.jH("");
    }
    AppMethodBeat.o(60128);
  }
  
  public final ad dwF()
  {
    AppMethodBeat.i(60129);
    try
    {
      ad localad = (ad)super.clone();
      AppMethodBeat.o(60129);
      return localad;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        ab.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
        Object localObject = null;
      }
    }
  }
  
  public final boolean dwz()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(60127);
    String str = super.getCity();
    AppMethodBeat.o(60127);
    return str;
  }
  
  public final String getCityCode()
  {
    AppMethodBeat.i(60123);
    Object localObject = this.dqQ;
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(60123);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 3))
    {
      AppMethodBeat.o(60123);
      return "";
    }
    localObject = bo.nullAsNil(localObject[2]);
    AppMethodBeat.o(60123);
    return localObject;
  }
  
  public final String getCountryCode()
  {
    AppMethodBeat.i(60121);
    Object localObject = this.dqQ;
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(60121);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(60121);
      return "";
    }
    localObject = bo.nullAsNil(localObject[0]);
    AppMethodBeat.o(60121);
    return localObject;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(60126);
    String str = super.getProvince();
    AppMethodBeat.o(60126);
    return str;
  }
  
  @Deprecated
  public final void jG(String paramString)
  {
    AppMethodBeat.i(60124);
    super.jG(paramString);
    AppMethodBeat.o(60124);
  }
  
  @Deprecated
  public final void jH(String paramString)
  {
    AppMethodBeat.i(60125);
    super.jH(paramString);
    AppMethodBeat.o(60125);
  }
  
  public final void jL(String paramString)
  {
    AppMethodBeat.i(60120);
    super.jL(paramString);
    dwE();
    AppMethodBeat.o(60120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */