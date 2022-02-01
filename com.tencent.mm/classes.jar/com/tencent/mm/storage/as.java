package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class as
  extends c
  implements Cloneable
{
  public CharSequence NON;
  public String Ooy = null;
  
  public as() {}
  
  public as(String paramString)
  {
    super(paramString);
  }
  
  public static boolean HF(String paramString)
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
  
  public static boolean IG(String paramString)
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
  
  public static boolean akh(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean avl(String paramString)
  {
    AppMethodBeat.i(225982);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@findermsg");
      AppMethodBeat.o(225982);
      return bool;
    }
    AppMethodBeat.o(225982);
    return false;
  }
  
  public static boolean bjm(String paramString)
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
  
  public static boolean bjn(String paramString)
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
  
  public static boolean bjo(String paramString)
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
  
  public static boolean bjp(String paramString)
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
  
  public static boolean bjq(String paramString)
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
  
  public static boolean bjr(String paramString)
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
  
  public static boolean bjs(String paramString)
  {
    AppMethodBeat.i(225983);
    if ((paramString != null) && (paramString.endsWith("@findermsgstranger")))
    {
      AppMethodBeat.o(225983);
      return true;
    }
    AppMethodBeat.o(225983);
    return false;
  }
  
  public static boolean bjt(String paramString)
  {
    AppMethodBeat.i(225984);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@finder");
      AppMethodBeat.o(225984);
      return bool;
    }
    AppMethodBeat.o(225984);
    return false;
  }
  
  public static boolean bju(String paramString)
  {
    AppMethodBeat.i(225985);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifesess");
      AppMethodBeat.o(225985);
      return bool;
    }
    AppMethodBeat.o(225985);
    return false;
  }
  
  public static boolean bjv(String paramString)
  {
    AppMethodBeat.i(225986);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelife");
      AppMethodBeat.o(225986);
      return bool;
    }
    AppMethodBeat.o(225986);
    return false;
  }
  
  public static boolean bjw(String paramString)
  {
    AppMethodBeat.i(225987);
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.endsWith("@findermsg")) || (paramString.endsWith("@gamelifesess")))
      {
        AppMethodBeat.o(225987);
        return true;
      }
      AppMethodBeat.o(225987);
      return false;
    }
    AppMethodBeat.o(225987);
    return false;
  }
  
  public static boolean bjx(String paramString)
  {
    AppMethodBeat.i(43176);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(43176);
      return false;
    }
    if (bjp(paramString))
    {
      AppMethodBeat.o(43176);
      return true;
    }
    Object localObject = ((a)g.af(a.class)).aqK().aj("HideWechatID", "idprefix");
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
  
  public static boolean bjy(String paramString)
  {
    AppMethodBeat.i(43177);
    if (Util.isNullOrNil(paramString))
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
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(43177);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43177);
    return false;
  }
  
  public static String bjz(String paramString)
  {
    AppMethodBeat.i(43178);
    if (IG(paramString))
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
  
  public static int gBO()
  {
    return 16;
  }
  
  public static int gBP()
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
  
  @Deprecated
  public final void BW(String paramString)
  {
    AppMethodBeat.i(43185);
    super.BW(paramString);
    AppMethodBeat.o(43185);
  }
  
  @Deprecated
  public final void BX(String paramString)
  {
    AppMethodBeat.i(43186);
    super.BX(paramString);
    AppMethodBeat.o(43186);
  }
  
  public final void Cb(String paramString)
  {
    AppMethodBeat.i(43181);
    super.Cb(paramString);
    gBS();
    AppMethodBeat.o(43181);
  }
  
  public final void ao(CharSequence paramCharSequence)
  {
    this.NON = paramCharSequence;
  }
  
  public final CharSequence gBL()
  {
    return this.NON;
  }
  
  public final boolean gBM()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean gBN()
  {
    return (this.field_verifyFlag & 0x80) > 0;
  }
  
  public final boolean gBQ()
  {
    AppMethodBeat.i(43179);
    if ((int)Util.nowSecond() - this.fuP > 86400L)
    {
      AppMethodBeat.o(43179);
      return true;
    }
    AppMethodBeat.o(43179);
    return false;
  }
  
  public final String gBR()
  {
    AppMethodBeat.i(43183);
    Object localObject = this.fuO;
    if (Util.isNullOrNil((String)localObject))
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
    localObject = Util.nullAsNil(localObject[1]);
    AppMethodBeat.o(43183);
    return localObject;
  }
  
  public final void gBS()
  {
    AppMethodBeat.i(43189);
    Object localObject = this.fuO;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43189);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.bkO(localObject[0]))
        {
          RegionCodeDecoder.gEm();
          super.BW(RegionCodeDecoder.mW(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.gEm();
          super.BX(RegionCodeDecoder.bs(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(43189);
          return;
          RegionCodeDecoder.gEm();
          super.BW(RegionCodeDecoder.bkP(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.gEm();
        super.BW(RegionCodeDecoder.bkP(localObject[0]));
        RegionCodeDecoder.gEm();
        super.BX(RegionCodeDecoder.mW(localObject[0], localObject[1]));
        AppMethodBeat.o(43189);
        return;
      }
      RegionCodeDecoder.gEm();
      super.BW(RegionCodeDecoder.bkP(localObject[0]));
      super.BX("");
    }
    AppMethodBeat.o(43189);
  }
  
  public final as gBT()
  {
    AppMethodBeat.i(43190);
    try
    {
      as localas = (as)super.clone();
      AppMethodBeat.o(43190);
      return localas;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        Log.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
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
    Object localObject = this.fuO;
    if (Util.isNullOrNil((String)localObject))
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
    localObject = Util.nullAsNil(localObject[2]);
    AppMethodBeat.o(43184);
    return localObject;
  }
  
  public final String getCountryCode()
  {
    AppMethodBeat.i(43182);
    Object localObject = this.fuO;
    if (Util.isNullOrNil((String)localObject))
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
    localObject = Util.nullAsNil(localObject[0]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.as
 * JD-Core Version:    0.7.0.1
 */