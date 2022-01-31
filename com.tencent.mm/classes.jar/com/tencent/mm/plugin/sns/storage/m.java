package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.sdk.e.i<l>
  implements com.tencent.mm.plugin.sns.b.e
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(l.buS, "snsExtInfo3") };
  public com.tencent.mm.sdk.e.e dXw;
  private boolean oLp = false;
  private g oLq = null;
  
  public m(com.tencent.mm.sdk.e.e parame, g paramg)
  {
    super(parame, l.buS, "snsExtInfo3", null);
    this.dXw = parame;
    this.oLq = paramg;
    y.i("MicroMsg.SnsExtStorage", "createExtStorage " + parame + "  " + Thread.currentThread().getId());
  }
  
  private l a(String paramString, l paraml)
  {
    int j;
    int k;
    if (paraml == null)
    {
      j = 0;
      k = 0;
      i = j;
      label13:
      if ((k != 0) || (i != 0)) {
        break label221;
      }
      paraml = this.dXw.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
      if (!paraml.moveToFirst()) {
        break label223;
      }
    }
    label221:
    label223:
    for (int i = paraml.getInt(0);; i = 0)
    {
      paraml.close();
      if (i == 0)
      {
        y.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
        return null;
        if ((paraml.field_iFlag & 0x1) > 0) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ((paraml.field_local_flag & 0x4) <= 0) {
            break;
          }
          k = 1;
          break label13;
        }
      }
      paraml = "select * from snsExtInfo2 where userName=\"" + bk.pl(paramString) + "\"";
      y.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paraml });
      paraml = this.dXw.a(paraml, null, 2);
      l locall = new l();
      if (paraml.moveToFirst())
      {
        locall.d(paraml);
        paraml.close();
        y.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
        return locall;
      }
      paraml.close();
      return null;
    }
  }
  
  public final but MN(String paramString)
  {
    paramString = OF(paramString);
    if (paramString == null) {
      return new but();
    }
    return paramString.bGu();
  }
  
  public final void OC(String paramString)
  {
    l locall = OF(paramString);
    locall.field_userName = paramString;
    super.a(locall, new String[] { this.ujO.ujM });
  }
  
  public final zq OD(String paramString)
  {
    Object localObject = new zq();
    new l();
    paramString = OF(paramString);
    try
    {
      if (!bk.bE(paramString.field_faultS))
      {
        paramString = (zq)new zq().aH(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new zq();
        }
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void OE(String paramString)
  {
    new l();
    l locall = OF(paramString);
    locall.field_userName = paramString;
    locall.field_local_flag &= 0xFFFFFFFE;
    c(locall);
  }
  
  public final l OF(String paramString)
  {
    l locall2 = new l();
    l locall1 = locall2;
    if (this.oLq != null)
    {
      locall1 = locall2;
      if (this.oLp)
      {
        locall1 = this.oLq.NC(paramString);
        if (locall1 != null) {
          return locall1;
        }
        locall1 = new l();
      }
    }
    locall1.field_userName = paramString;
    super.b(locall1, new String[] { this.ujO.ujM });
    return locall1;
  }
  
  public final boolean a(l paraml)
  {
    if ((this.oLp) && (this.oLq != null))
    {
      boolean bool = this.oLq.a(paraml);
      if (this.oLq != null) {
        this.oLq.bDV();
      }
      return bool;
    }
    return super.a(paraml);
  }
  
  public final boolean a(String paramString, but parambut)
  {
    paramString = OF(paramString);
    String str = com.tencent.mm.plugin.sns.data.i.fN(parambut.ffu);
    if ((!bk.bl(parambut.fft)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.bGs();
      y.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = parambut.fft;
    paramString.field_iFlag = parambut.ffs;
    paramString.field_snsBgId = parambut.ffu;
    paramString.field_local_flag |= 0x4;
    if (parambut != null) {}
    try
    {
      paramString.field_snsuser = parambut.toByteArray();
      label123:
      a(paramString);
      return true;
    }
    catch (Exception parambut)
    {
      break label123;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString = OF(paramString);
    int i = paramString.field_iFlag;
    if (paramBoolean1)
    {
      i |= 0x200;
      if (!paramBoolean2) {
        break label74;
      }
      i |= 0x400;
      label36:
      if (!paramBoolean3) {
        break label85;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramString.field_iFlag = i;
      c(paramString);
      return true;
      i &= 0xFFFFFDFF;
      break;
      label74:
      i &= 0xFFFFFBFF;
      break label36;
      label85:
      i &= 0xFFFFF7FF;
    }
  }
  
  public final boolean aY(String paramString, boolean paramBoolean)
  {
    paramString = OF(paramString);
    int i = paramString.field_iFlag;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.field_iFlag = i;
      c(paramString);
      return true;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final but aZ(String paramString, boolean paramBoolean)
  {
    paramString = OF(paramString).bGu();
    if (paramString == null)
    {
      y.e("MicroMsg.SnsExtStorage", "userinfo is null");
      return null;
    }
    int i = paramString.tLp;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.tLp = i;
      return paramString;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final but b(String paramString, but parambut)
  {
    l locall = OF(paramString);
    if (locall == null)
    {
      paramString = a(paramString, locall);
      if (paramString != null)
      {
        if (parambut.ffs != -1) {
          break label44;
        }
        i = paramString.field_iFlag;
        parambut.ffs = i;
      }
    }
    label44:
    String str;
    label85:
    int j;
    label96:
    do
    {
      return parambut;
      i = parambut.ffs;
      break;
      if (!bk.bl(parambut.fft)) {
        break label130;
      }
      str = locall.field_bgUrl;
      parambut.fft = str;
      if (parambut.ffs != -1) {
        break label139;
      }
      i = 1;
      if (i == 0) {
        break label144;
      }
      j = locall.field_iFlag;
      parambut.ffs = j;
      paramString = a(paramString, locall);
    } while (paramString == null);
    if (i != 0) {}
    for (int i = paramString.field_iFlag;; i = parambut.ffs)
    {
      parambut.ffs = i;
      return parambut;
      label130:
      str = parambut.fft;
      break;
      label139:
      i = 0;
      break label85;
      label144:
      j = parambut.ffs;
      break label96;
    }
  }
  
  public final but b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString = OF(paramString).bGu();
    if (paramString == null)
    {
      y.e("MicroMsg.SnsExtStorage", "userinfo is null");
      return null;
    }
    int i = paramString.tLp;
    if (paramBoolean1)
    {
      i |= 0x200;
      if (!paramBoolean2) {
        break label85;
      }
      i |= 0x400;
      label53:
      if (!paramBoolean3) {
        break label96;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramString.tLp = i;
      return paramString;
      i &= 0xFFFFFDFF;
      break;
      label85:
      i &= 0xFFFFFBFF;
      break label53;
      label96:
      i &= 0xFFFFF7FF;
    }
  }
  
  public final boolean b(l paraml)
  {
    return super.a(paraml);
  }
  
  public final void bCk()
  {
    y.d("MicroMsg.SnsExtStorage", "attachCache");
    this.oLp = true;
  }
  
  public final void bCl()
  {
    this.oLp = false;
    this.oLq.bDW();
    y.d("MicroMsg.SnsExtStorage", "detchCache");
  }
  
  public final boolean c(l paraml)
  {
    if ((paraml == null) || (paraml.field_userName == null) || (paraml.field_userName.equals(""))) {
      return false;
    }
    return super.a(paraml);
  }
  
  public final boolean eX(String paramString1, String paramString2)
  {
    paramString1 = OF(paramString1);
    paramString1.field_newerIds = paramString2;
    return super.a(paramString1);
  }
  
  public final int h(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = OF(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.a(paramString1);
    return 0;
  }
  
  public final int l(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = OF(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.a(paramString1);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.m
 * JD-Core Version:    0.7.0.1
 */