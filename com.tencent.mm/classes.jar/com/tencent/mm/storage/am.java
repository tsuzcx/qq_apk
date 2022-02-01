package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.c;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class am
  extends b
  implements Cloneable
{
  public String IJW = null;
  public CharSequence InJ;
  
  public am() {}
  
  public am(String paramString)
  {
    super(paramString);
  }
  
  public static boolean aSN(String paramString)
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
  
  public static boolean aSO(String paramString)
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
  
  public static boolean aSP(String paramString)
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
  
  public static boolean aSQ(String paramString)
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
  
  public static boolean aSR(String paramString)
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
  
  public static boolean aSS(String paramString)
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
  
  public static boolean aST(String paramString)
  {
    AppMethodBeat.i(192566);
    if ((paramString != null) && (paramString.endsWith("@findermsgstranger")))
    {
      AppMethodBeat.o(192566);
      return true;
    }
    AppMethodBeat.o(192566);
    return false;
  }
  
  public static boolean aSU(String paramString)
  {
    AppMethodBeat.i(192567);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@finder");
      AppMethodBeat.o(192567);
      return bool;
    }
    AppMethodBeat.o(192567);
    return false;
  }
  
  public static boolean aSV(String paramString)
  {
    AppMethodBeat.i(192568);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifesess");
      AppMethodBeat.o(192568);
      return bool;
    }
    AppMethodBeat.o(192568);
    return false;
  }
  
  public static boolean aSW(String paramString)
  {
    AppMethodBeat.i(192569);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelife");
      AppMethodBeat.o(192569);
      return bool;
    }
    AppMethodBeat.o(192569);
    return false;
  }
  
  public static boolean aSX(String paramString)
  {
    AppMethodBeat.i(43176);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(43176);
      return false;
    }
    if (aSQ(paramString))
    {
      AppMethodBeat.o(43176);
      return true;
    }
    Object localObject = ((a)g.ab(a.class)).acB().ah("HideWechatID", "idprefix");
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
  
  public static boolean aSY(String paramString)
  {
    AppMethodBeat.i(43177);
    if (bt.isNullOrNil(paramString))
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
      if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(43177);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43177);
    return false;
  }
  
  public static String aSZ(String paramString)
  {
    AppMethodBeat.i(43178);
    if (zs(paramString))
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
  
  public static boolean aaR(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean ail(String paramString)
  {
    AppMethodBeat.i(192565);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@findermsg");
      AppMethodBeat.o(192565);
      return bool;
    }
    AppMethodBeat.o(192565);
    return false;
  }
  
  public static int fqi()
  {
    return 16;
  }
  
  public static int fqj()
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
  
  public static boolean yt(String paramString)
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
  
  public static boolean zs(String paramString)
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
  
  public final void ak(CharSequence paramCharSequence)
  {
    this.InJ = paramCharSequence;
  }
  
  public final CharSequence fqf()
  {
    return this.InJ;
  }
  
  public final boolean fqg()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean fqh()
  {
    return (this.field_verifyFlag & 0x80) > 0;
  }
  
  public final boolean fqk()
  {
    AppMethodBeat.i(43179);
    if ((int)bt.aQJ() - this.ePB > 86400L)
    {
      AppMethodBeat.o(43179);
      return true;
    }
    AppMethodBeat.o(43179);
    return false;
  }
  
  public final String fql()
  {
    AppMethodBeat.i(43183);
    Object localObject = this.ePA;
    if (bt.isNullOrNil((String)localObject))
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
    localObject = bt.nullAsNil(localObject[1]);
    AppMethodBeat.o(43183);
    return localObject;
  }
  
  public final void fqm()
  {
    AppMethodBeat.i(43189);
    Object localObject = this.ePA;
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43189);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.aUp(localObject[0]))
        {
          RegionCodeDecoder.fsz();
          super.tl(RegionCodeDecoder.mb(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.fsz();
          super.tm(RegionCodeDecoder.bh(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(43189);
          return;
          RegionCodeDecoder.fsz();
          super.tl(RegionCodeDecoder.aUq(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.fsz();
        super.tl(RegionCodeDecoder.aUq(localObject[0]));
        RegionCodeDecoder.fsz();
        super.tm(RegionCodeDecoder.mb(localObject[0], localObject[1]));
        AppMethodBeat.o(43189);
        return;
      }
      RegionCodeDecoder.fsz();
      super.tl(RegionCodeDecoder.aUq(localObject[0]));
      super.tm("");
    }
    AppMethodBeat.o(43189);
  }
  
  public final am fqn()
  {
    AppMethodBeat.i(43190);
    try
    {
      am localam = (am)super.clone();
      AppMethodBeat.o(43190);
      return localam;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        ad.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
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
    Object localObject = this.ePA;
    if (bt.isNullOrNil((String)localObject))
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
    localObject = bt.nullAsNil(localObject[2]);
    AppMethodBeat.o(43184);
    return localObject;
  }
  
  public final String getCountryCode()
  {
    AppMethodBeat.i(43182);
    Object localObject = this.ePA;
    if (bt.isNullOrNil((String)localObject))
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
    localObject = bt.nullAsNil(localObject[0]);
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
  public final void tl(String paramString)
  {
    AppMethodBeat.i(43185);
    super.tl(paramString);
    AppMethodBeat.o(43185);
  }
  
  @Deprecated
  public final void tm(String paramString)
  {
    AppMethodBeat.i(43186);
    super.tm(paramString);
    AppMethodBeat.o(43186);
  }
  
  public final void tq(String paramString)
  {
    AppMethodBeat.i(43181);
    super.tq(paramString);
    fqm();
    AppMethodBeat.o(43181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */