package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class an
  extends com.tencent.mm.contact.c
  implements Cloneable
{
  public CharSequence IHU;
  public String JeD = null;
  
  public an() {}
  
  public an(String paramString)
  {
    super(paramString);
  }
  
  public static boolean Ac(String paramString)
  {
    AppMethodBeat.i(43174);
    if (paramString != null)
    {
      if ((paramString.contains("@bottle:")) || (paramString.endsWith("@bottle")))
      {
        AppMethodBeat.o(43174);
        return true;
      }
      AppMethodBeat.o(43174);
      return false;
    }
    AppMethodBeat.o(43174);
    return false;
  }
  
  public static String aUA(String paramString)
  {
    AppMethodBeat.i(43178);
    if (Ac(paramString))
    {
      String[] arrayOfString = paramString.split(":");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(43178);
        return paramString;
      }
      paramString = arrayOfString[0];
      AppMethodBeat.o(43178);
      return paramString;
    }
    if ((paramString != null) && (paramString.contains("@")))
    {
      AppMethodBeat.o(43178);
      return "";
    }
    paramString = paramString + "@bottle";
    AppMethodBeat.o(43178);
    return paramString;
  }
  
  public static boolean aUn(String paramString)
  {
    AppMethodBeat.i(43168);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@t.qq.com");
      AppMethodBeat.o(43168);
      return bool;
    }
    AppMethodBeat.o(43168);
    return false;
  }
  
  public static boolean aUo(String paramString)
  {
    AppMethodBeat.i(43169);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qr");
      AppMethodBeat.o(43169);
      return bool;
    }
    AppMethodBeat.o(43169);
    return false;
  }
  
  public static boolean aUp(String paramString)
  {
    AppMethodBeat.i(43170);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qqim");
      AppMethodBeat.o(43170);
      return bool;
    }
    AppMethodBeat.o(43170);
    return false;
  }
  
  public static boolean aUq(String paramString)
  {
    AppMethodBeat.i(43171);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@openim");
      AppMethodBeat.o(43171);
      return bool;
    }
    AppMethodBeat.o(43171);
    return false;
  }
  
  public static boolean aUr(String paramString)
  {
    AppMethodBeat.i(43172);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@im.chatroom");
      AppMethodBeat.o(43172);
      return bool;
    }
    AppMethodBeat.o(43172);
    return false;
  }
  
  public static boolean aUs(String paramString)
  {
    AppMethodBeat.i(43173);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@fb");
      AppMethodBeat.o(43173);
      return bool;
    }
    AppMethodBeat.o(43173);
    return false;
  }
  
  public static boolean aUt(String paramString)
  {
    AppMethodBeat.i(213441);
    if ((paramString != null) && (paramString.endsWith("@findermsgstranger")))
    {
      AppMethodBeat.o(213441);
      return true;
    }
    AppMethodBeat.o(213441);
    return false;
  }
  
  public static boolean aUu(String paramString)
  {
    AppMethodBeat.i(213442);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@finder");
      AppMethodBeat.o(213442);
      return bool;
    }
    AppMethodBeat.o(213442);
    return false;
  }
  
  public static boolean aUv(String paramString)
  {
    AppMethodBeat.i(213443);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifesess");
      AppMethodBeat.o(213443);
      return bool;
    }
    AppMethodBeat.o(213443);
    return false;
  }
  
  public static boolean aUw(String paramString)
  {
    AppMethodBeat.i(213444);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelife");
      AppMethodBeat.o(213444);
      return bool;
    }
    AppMethodBeat.o(213444);
    return false;
  }
  
  public static boolean aUx(String paramString)
  {
    AppMethodBeat.i(213445);
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.endsWith("@findermsg")) || (paramString.endsWith("@gamelifesess")))
      {
        AppMethodBeat.o(213445);
        return true;
      }
      AppMethodBeat.o(213445);
      return false;
    }
    AppMethodBeat.o(213445);
    return false;
  }
  
  public static boolean aUy(String paramString)
  {
    AppMethodBeat.i(43176);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(43176);
      return false;
    }
    if (aUq(paramString))
    {
      AppMethodBeat.o(43176);
      return true;
    }
    Object localObject = ((a)g.ab(a.class)).acM().ah("HideWechatID", "idprefix");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int i = 0;
      while (i < localObject.length)
      {
        if ((localObject[i] != null) && (paramString.startsWith(localObject[i])))
        {
          AppMethodBeat.o(43176);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(43176);
    return false;
  }
  
  public static boolean aUz(String paramString)
  {
    AppMethodBeat.i(43177);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43177);
      return true;
    }
    String[] arrayOfString = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if ((!bu.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(43177);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43177);
    return false;
  }
  
  public static boolean abz(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean aji(String paramString)
  {
    AppMethodBeat.i(213440);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@findermsg");
      AppMethodBeat.o(213440);
      return bool;
    }
    AppMethodBeat.o(213440);
    return false;
  }
  
  public static int fui()
  {
    return 16;
  }
  
  public static int fuj()
  {
    return 8;
  }
  
  public static String p(Cursor paramCursor)
  {
    AppMethodBeat.i(43180);
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("username"));
    AppMethodBeat.o(43180);
    return paramCursor;
  }
  
  public static boolean zd(String paramString)
  {
    AppMethodBeat.i(43175);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@app");
      AppMethodBeat.o(43175);
      return bool;
    }
    AppMethodBeat.o(43175);
    return false;
  }
  
  public final void aj(CharSequence paramCharSequence)
  {
    this.IHU = paramCharSequence;
  }
  
  public final CharSequence fuf()
  {
    return this.IHU;
  }
  
  public final boolean fug()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean fuh()
  {
    return (this.field_verifyFlag & 0x80) > 0;
  }
  
  public final boolean fuk()
  {
    AppMethodBeat.i(43179);
    if ((int)bu.aRi() - this.eRm > 86400L)
    {
      AppMethodBeat.o(43179);
      return true;
    }
    AppMethodBeat.o(43179);
    return false;
  }
  
  public final String ful()
  {
    AppMethodBeat.i(43183);
    Object localObject = this.eRl;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43183);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 2))
    {
      AppMethodBeat.o(43183);
      return "";
    }
    localObject = bu.nullAsNil(localObject[1]);
    AppMethodBeat.o(43183);
    return localObject;
  }
  
  public final void fum()
  {
    AppMethodBeat.i(43189);
    Object localObject = this.eRl;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43189);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.aVQ(localObject[0]))
        {
          RegionCodeDecoder.fwA();
          super.tG(RegionCodeDecoder.mi(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.fwA();
          super.tH(RegionCodeDecoder.bi(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(43189);
          return;
          RegionCodeDecoder.fwA();
          super.tG(RegionCodeDecoder.aVR(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.fwA();
        super.tG(RegionCodeDecoder.aVR(localObject[0]));
        RegionCodeDecoder.fwA();
        super.tH(RegionCodeDecoder.mi(localObject[0], localObject[1]));
        AppMethodBeat.o(43189);
        return;
      }
      RegionCodeDecoder.fwA();
      super.tG(RegionCodeDecoder.aVR(localObject[0]));
      super.tH("");
    }
    AppMethodBeat.o(43189);
  }
  
  public final an fun()
  {
    AppMethodBeat.i(43190);
    try
    {
      an localan = (an)super.clone();
      AppMethodBeat.o(43190);
      return localan;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        ae.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
        Object localObject = null;
      }
    }
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(43188);
    String str = super.getCity();
    AppMethodBeat.o(43188);
    return str;
  }
  
  public final String getCityCode()
  {
    AppMethodBeat.i(43184);
    Object localObject = this.eRl;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43184);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 3))
    {
      AppMethodBeat.o(43184);
      return "";
    }
    localObject = bu.nullAsNil(localObject[2]);
    AppMethodBeat.o(43184);
    return localObject;
  }
  
  public final String getCountryCode()
  {
    AppMethodBeat.i(43182);
    Object localObject = this.eRl;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43182);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(43182);
      return "";
    }
    localObject = bu.nullAsNil(localObject[0]);
    AppMethodBeat.o(43182);
    return localObject;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(43187);
    String str = super.getProvince();
    AppMethodBeat.o(43187);
    return str;
  }
  
  @Deprecated
  public final void tG(String paramString)
  {
    AppMethodBeat.i(43185);
    super.tG(paramString);
    AppMethodBeat.o(43185);
  }
  
  @Deprecated
  public final void tH(String paramString)
  {
    AppMethodBeat.i(43186);
    super.tH(paramString);
    AppMethodBeat.o(43186);
  }
  
  public final void tL(String paramString)
  {
    AppMethodBeat.i(43181);
    super.tL(paramString);
    fum();
    AppMethodBeat.o(43181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.an
 * JD-Core Version:    0.7.0.1
 */