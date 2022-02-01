package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class as
  extends com.tencent.mm.contact.d
  implements Cloneable
{
  public static long VEq = 86400L;
  public String VEr = null;
  public CharSequence Vcw;
  
  public as() {}
  
  public as(String paramString)
  {
    super(paramString);
  }
  
  public static boolean OS(String paramString)
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
  
  public static boolean PY(String paramString)
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
  
  public static boolean aEF(String paramString)
  {
    AppMethodBeat.i(240831);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@findermsg");
      AppMethodBeat.o(240831);
      return bool;
    }
    AppMethodBeat.o(240831);
    return false;
  }
  
  public static boolean asD(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean bvH(String paramString)
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
  
  public static boolean bvI(String paramString)
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
  
  public static boolean bvJ(String paramString)
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
  
  public static boolean bvK(String paramString)
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
  
  public static boolean bvL(String paramString)
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
  
  public static boolean bvM(String paramString)
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
  
  public static boolean bvN(String paramString)
  {
    AppMethodBeat.i(240832);
    if ((paramString != null) && (paramString.endsWith("@findermsgstranger")))
    {
      AppMethodBeat.o(240832);
      return true;
    }
    AppMethodBeat.o(240832);
    return false;
  }
  
  public static boolean bvO(String paramString)
  {
    AppMethodBeat.i(240833);
    if ((paramString != null) && (paramString.endsWith("@findermsgalias")))
    {
      AppMethodBeat.o(240833);
      return true;
    }
    AppMethodBeat.o(240833);
    return false;
  }
  
  public static boolean bvP(String paramString)
  {
    AppMethodBeat.i(240834);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@finder");
      AppMethodBeat.o(240834);
      return bool;
    }
    AppMethodBeat.o(240834);
    return false;
  }
  
  public static boolean bvQ(String paramString)
  {
    AppMethodBeat.i(240835);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifesess");
      AppMethodBeat.o(240835);
      return bool;
    }
    AppMethodBeat.o(240835);
    return false;
  }
  
  public static boolean bvR(String paramString)
  {
    AppMethodBeat.i(240836);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelife");
      AppMethodBeat.o(240836);
      return bool;
    }
    AppMethodBeat.o(240836);
    return false;
  }
  
  public static boolean bvS(String paramString)
  {
    AppMethodBeat.i(240837);
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.endsWith("@findermsg")) || (paramString.endsWith("@gamelifesess")))
      {
        AppMethodBeat.o(240837);
        return true;
      }
      AppMethodBeat.o(240837);
      return false;
    }
    AppMethodBeat.o(240837);
    return false;
  }
  
  public static boolean bvT(String paramString)
  {
    AppMethodBeat.i(240838);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@stranger");
      AppMethodBeat.o(240838);
      return bool;
    }
    AppMethodBeat.o(240838);
    return false;
  }
  
  public static boolean bvU(String paramString)
  {
    AppMethodBeat.i(43176);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(43176);
      return false;
    }
    if (bvK(paramString))
    {
      AppMethodBeat.o(43176);
      return true;
    }
    Object localObject = ((a)h.ae(a.class)).axd().ao("HideWechatID", "idprefix");
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
  
  public static boolean bvV(String paramString)
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
  
  public static String bvW(String paramString)
  {
    AppMethodBeat.i(43178);
    if (PY(paramString))
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
  
  public static int hxZ()
  {
    return 16;
  }
  
  public static int hya()
  {
    return 8;
  }
  
  public static String s(Cursor paramCursor)
  {
    AppMethodBeat.i(43180);
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("username"));
    AppMethodBeat.o(43180);
    return paramCursor;
  }
  
  @Deprecated
  public final void IK(String paramString)
  {
    AppMethodBeat.i(43185);
    super.IK(paramString);
    AppMethodBeat.o(43185);
  }
  
  @Deprecated
  public final void IL(String paramString)
  {
    AppMethodBeat.i(43186);
    super.IL(paramString);
    AppMethodBeat.o(43186);
  }
  
  public final void IP(String paramString)
  {
    AppMethodBeat.i(43181);
    super.IP(paramString);
    hyd();
    AppMethodBeat.o(43181);
  }
  
  public final void aC(CharSequence paramCharSequence)
  {
    this.Vcw = paramCharSequence;
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
    Object localObject = this.hDn;
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
    Object localObject = this.hDn;
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
  
  public final CharSequence hxW()
  {
    return this.Vcw;
  }
  
  public final boolean hxX()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean hxY()
  {
    return (this.field_verifyFlag & 0x80) > 0;
  }
  
  public final boolean hyb()
  {
    AppMethodBeat.i(43179);
    if ((int)Util.nowSecond() - this.hDo > VEq)
    {
      AppMethodBeat.o(43179);
      return true;
    }
    AppMethodBeat.o(43179);
    return false;
  }
  
  public final String hyc()
  {
    AppMethodBeat.i(43183);
    Object localObject = this.hDn;
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
  
  public final void hyd()
  {
    AppMethodBeat.i(43189);
    Object localObject = this.hDn;
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
        if (RegionCodeDecoder.bxn(localObject[0]))
        {
          RegionCodeDecoder.hAC();
          super.IK(RegionCodeDecoder.nO(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.hAC();
          super.IL(RegionCodeDecoder.bn(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(43189);
          return;
          RegionCodeDecoder.hAC();
          super.IK(RegionCodeDecoder.bxp(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.hAC();
        super.IK(RegionCodeDecoder.bxp(localObject[0]));
        RegionCodeDecoder.hAC();
        super.IL(RegionCodeDecoder.nO(localObject[0], localObject[1]));
        AppMethodBeat.o(43189);
        return;
      }
      RegionCodeDecoder.hAC();
      super.IK(RegionCodeDecoder.bxp(localObject[0]));
      super.IL("");
    }
    AppMethodBeat.o(43189);
  }
  
  public final CharSequence hye()
  {
    return this.Vcw;
  }
  
  public final as hyf()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.as
 * JD-Core Version:    0.7.0.1
 */