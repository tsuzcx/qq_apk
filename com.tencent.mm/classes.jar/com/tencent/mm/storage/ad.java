package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ad
  extends com.tencent.mm.n.a
  implements Cloneable
{
  public CharSequence umR;
  public String uzT = null;
  
  public ad() {}
  
  public ad(String paramString)
  {
    super(paramString);
  }
  
  public static boolean Fn(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean aaR(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@t.qq.com");
    }
    return false;
  }
  
  public static boolean aaS(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@qr");
    }
    return false;
  }
  
  public static boolean aaT(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@qqim");
    }
    return false;
  }
  
  public static boolean aaU(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@openim");
    }
    return false;
  }
  
  public static boolean aaV(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@im.chatroom");
    }
    return false;
  }
  
  public static boolean aaW(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@fb");
    }
    return false;
  }
  
  public static boolean aaX(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
    }
    for (;;)
    {
      return false;
      if (aaU(paramString)) {
        return true;
      }
      Object localObject = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AB().H("HideWechatID", "idprefix");
      if (localObject != null)
      {
        localObject = ((String)localObject).split(";");
        int i = 0;
        while (i < localObject.length)
        {
          if ((localObject[i] != null) && (paramString.startsWith(localObject[i]))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean aaY(String paramString)
  {
    if (bk.bl(paramString)) {
      return true;
    }
    String[] arrayOfString = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label56;
      }
      String str = arrayOfString[i];
      if ((!bk.bl(str)) && (paramString.startsWith(str))) {
        break;
      }
      i += 1;
    }
    label56:
    return false;
  }
  
  public static String aaZ(String paramString)
  {
    if (hd(paramString))
    {
      String[] arrayOfString = paramString.split(":");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        return paramString;
      }
      return arrayOfString[0];
    }
    if ((paramString != null) && (paramString.contains("@"))) {
      return "";
    }
    return paramString + "@bottle";
  }
  
  public static boolean ctZ()
  {
    return false;
  }
  
  public static int cub()
  {
    return 16;
  }
  
  public static int cuc()
  {
    return 8;
  }
  
  public static boolean gr(String paramString)
  {
    if (paramString != null) {
      return paramString.endsWith("@app");
    }
    return false;
  }
  
  public static boolean hd(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (!paramString.contains("@bottle:"))
      {
        bool1 = bool2;
        if (!paramString.endsWith("@bottle")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String n(Cursor paramCursor)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("username"));
  }
  
  public final boolean cua()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean cud()
  {
    return (int)bk.UX() - this.cCH > 86400L;
  }
  
  public final String cue()
  {
    Object localObject = this.cCG;
    if (bk.bl((String)localObject)) {
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 2)) {
      return "";
    }
    return bk.pm(localObject[1]);
  }
  
  public final void cuf()
  {
    Object localObject = this.cCG;
    if (bk.bl((String)localObject)) {}
    do
    {
      return;
      localObject = ((String)localObject).split("_");
    } while (localObject.length <= 0);
    if (localObject.length > 2)
    {
      if (RegionCodeDecoder.acl(localObject[0]))
      {
        RegionCodeDecoder.cvV();
        super.dA(RegionCodeDecoder.gp(localObject[0], localObject[1]));
      }
      for (;;)
      {
        RegionCodeDecoder.cvV();
        super.dB(RegionCodeDecoder.ap(localObject[0], localObject[1], localObject[2]));
        return;
        RegionCodeDecoder.cvV();
        super.dA(RegionCodeDecoder.acm(localObject[0]));
      }
    }
    if (localObject.length == 2)
    {
      RegionCodeDecoder.cvV();
      super.dA(RegionCodeDecoder.acm(localObject[0]));
      RegionCodeDecoder.cvV();
      super.dB(RegionCodeDecoder.gp(localObject[0], localObject[1]));
      return;
    }
    RegionCodeDecoder.cvV();
    super.dA(RegionCodeDecoder.acm(localObject[0]));
    super.dB("");
  }
  
  public final ad cug()
  {
    try
    {
      ad localad = (ad)super.clone();
      return localad;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
      y.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
    }
    return null;
  }
  
  @Deprecated
  public final void dA(String paramString)
  {
    super.dA(paramString);
  }
  
  @Deprecated
  public final void dB(String paramString)
  {
    super.dB(paramString);
  }
  
  public final void dF(String paramString)
  {
    super.dF(paramString);
    cuf();
  }
  
  public final String getCity()
  {
    return super.getCity();
  }
  
  public final String getCityCode()
  {
    Object localObject = this.cCG;
    if (bk.bl((String)localObject)) {
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 3)) {
      return "";
    }
    return bk.pm(localObject[2]);
  }
  
  public final String getCountryCode()
  {
    Object localObject = this.cCG;
    if (bk.bl((String)localObject)) {
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length <= 0)) {
      return "";
    }
    return bk.pm(localObject[0]);
  }
  
  public final String getProvince()
  {
    return super.getProvince();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */