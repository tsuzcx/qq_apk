package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends j<n>
  implements f
{
  public static final String[] SQL_CREATE;
  private boolean AdR;
  private g AdS;
  public e db;
  
  static
  {
    AppMethodBeat.i(97496);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "snsExtInfo3") };
    AppMethodBeat.o(97496);
  }
  
  public o(e parame, g paramg)
  {
    super(parame, n.info, "snsExtInfo3", null);
    AppMethodBeat.i(97474);
    this.AdR = false;
    this.AdS = null;
    this.db = parame;
    this.AdS = paramg;
    ae.i("MicroMsg.SnsExtStorage", "createExtStorage " + parame + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(97474);
  }
  
  private n a(String paramString, n paramn)
  {
    AppMethodBeat.i(97487);
    int j;
    int k;
    if (paramn == null)
    {
      j = 0;
      k = 0;
      i = j;
      label18:
      if ((k != 0) || (i != 0)) {
        break label236;
      }
      paramn = this.db.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
      if (!paramn.moveToFirst()) {
        break label243;
      }
    }
    label236:
    label243:
    for (int i = paramn.getInt(0);; i = 0)
    {
      paramn.close();
      if (i == 0)
      {
        ae.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
        return null;
        if ((paramn.field_iFlag & 0x1) > 0) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ((paramn.field_local_flag & 0x4) <= 0) {
            break;
          }
          k = 1;
          break label18;
        }
      }
      paramn = "select * from snsExtInfo2 where userName=\"" + bu.aSk(paramString) + "\"";
      ae.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paramn });
      paramn = this.db.a(paramn, null, 2);
      n localn = new n();
      if (paramn.moveToFirst())
      {
        localn.convertFrom(paramn);
        paramn.close();
        ae.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
        return localn;
      }
      paramn.close();
      AppMethodBeat.o(97487);
      return null;
    }
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(97476);
    if ((this.AdR) && (this.AdS != null))
    {
      bool = this.AdS.a(paramn);
      if (this.AdS != null) {
        this.AdS.dXY();
      }
      AppMethodBeat.o(97476);
      return bool;
    }
    boolean bool = super.replace(paramn);
    AppMethodBeat.o(97476);
    return bool;
  }
  
  public final boolean a(String paramString, dia paramdia)
  {
    AppMethodBeat.i(97485);
    if (paramdia == null)
    {
      AppMethodBeat.o(97485);
      return false;
    }
    paramString = aBw(paramString);
    String str = r.zV(paramdia.jgi);
    if ((!bu.isNullOrNil(paramdia.jgh)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.ecc();
      ae.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = paramdia.jgh;
    paramString.field_iFlag = paramdia.jgg;
    paramString.field_snsBgId = paramdia.jgi;
    paramString.field_local_flag |= 0x4;
    if ((paramdia.HPm & 0x1000) == 0)
    {
      if ((paramdia.HPm & 0x200) <= 0) {
        break label185;
      }
      paramdia.HPm |= 0x1000;
      paramdia.HPn = 4320;
    }
    for (;;)
    {
      paramString.a(paramdia);
      a(paramString);
      AppMethodBeat.o(97485);
      return true;
      label185:
      if ((paramdia.HPm & 0x400) > 0)
      {
        paramdia.HPm |= 0x1000;
        paramdia.HPn = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97491);
    paramString = aBw(paramString);
    int k = paramString.field_iFlag;
    if (paramString.ecf() != null) {}
    for (int i = paramString.ecf().HPm;; i = 0)
    {
      int j = -1;
      k |= 0x1000;
      int m = i | 0x1000;
      i = j;
      if (paramBoolean1) {
        i = 4320;
      }
      if (paramBoolean2) {
        i = 72;
      }
      if (paramBoolean4) {
        i = 720;
      }
      for (;;)
      {
        if (paramBoolean3) {
          k |= 0x800;
        }
        for (j = m | 0x800;; j = m & 0xFFFFF7FF)
        {
          paramString.field_iFlag = k;
          dia localdia = paramString.ecf();
          if (localdia != null)
          {
            localdia.HPm = j;
            localdia.HPn = i;
            paramString.a(localdia);
          }
          c(paramString);
          AppMethodBeat.o(97491);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final void aBt(String paramString)
  {
    AppMethodBeat.i(97477);
    n localn = aBw(paramString);
    localn.field_userName = paramString;
    super.delete(localn, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97477);
  }
  
  public final auk aBu(String paramString)
  {
    AppMethodBeat.i(97481);
    Object localObject = new auk();
    new n();
    paramString = aBw(paramString);
    try
    {
      if (!bu.cF(paramString.field_faultS))
      {
        paramString = (auk)new auk().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new auk();
        }
        AppMethodBeat.o(97481);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void aBv(String paramString)
  {
    AppMethodBeat.i(97482);
    new n();
    n localn = aBw(paramString);
    localn.field_userName = paramString;
    localn.field_local_flag &= 0xFFFFFFFE;
    c(localn);
    AppMethodBeat.o(97482);
  }
  
  public final n aBw(String paramString)
  {
    AppMethodBeat.i(97483);
    n localn2 = new n();
    n localn1 = localn2;
    if (this.AdS != null)
    {
      localn1 = localn2;
      if (this.AdR)
      {
        localn1 = this.AdS.aAn(paramString);
        if (localn1 != null)
        {
          AppMethodBeat.o(97483);
          return localn1;
        }
        localn1 = new n();
      }
    }
    localn1.field_userName = paramString;
    super.get(localn1, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97483);
    return localn1;
  }
  
  public final List<die> aBx(String paramString)
  {
    AppMethodBeat.i(97493);
    paramString = aBw(paramString).ecd().HPl;
    AppMethodBeat.o(97493);
    return paramString;
  }
  
  public final dia ayZ(String paramString)
  {
    AppMethodBeat.i(97488);
    paramString = aBw(paramString);
    if (paramString == null)
    {
      paramString = new dia();
      AppMethodBeat.o(97488);
      return paramString;
    }
    paramString = paramString.ecf();
    AppMethodBeat.o(97488);
    return paramString;
  }
  
  public final dia b(String paramString, dia paramdia)
  {
    AppMethodBeat.i(97486);
    n localn = aBw(paramString);
    if (localn == null)
    {
      paramString = a(paramString, localn);
      if (paramString != null) {
        if (paramdia.jgg != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramdia.jgg)
      {
        paramdia.jgg = i;
        AppMethodBeat.o(97486);
        return paramdia;
      }
    }
    String str;
    label97:
    int j;
    if (bu.isNullOrNil(paramdia.jgh))
    {
      str = localn.field_bgUrl;
      paramdia.jgh = str;
      if (paramdia.jgg != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = localn.field_iFlag;
      label108:
      paramdia.jgg = j;
      paramString = a(paramString, localn);
      if (paramString != null) {
        if (i == 0) {
          break label171;
        }
      }
    }
    label157:
    label162:
    label171:
    for (int i = paramString.field_iFlag;; i = paramdia.jgg)
    {
      paramdia.jgg = i;
      AppMethodBeat.o(97486);
      return paramdia;
      str = paramdia.jgh;
      break;
      i = 0;
      break label97;
      j = paramdia.jgg;
      break label108;
    }
  }
  
  public final dia b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97492);
    paramString = aBw(paramString).ecf();
    if (paramString == null)
    {
      ae.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97492);
      return null;
    }
    int j = paramString.HPm;
    int i = -1;
    j |= 0x1000;
    if (paramBoolean1) {
      i = 4320;
    }
    if (paramBoolean2) {
      i = 72;
    }
    if (paramBoolean4) {
      i = 720;
    }
    for (;;)
    {
      if (paramBoolean3) {
        j |= 0x800;
      }
      for (;;)
      {
        paramString.HPm = j;
        paramString.HPn = i;
        AppMethodBeat.o(97492);
        return paramString;
        j &= 0xFFFFF7FF;
      }
    }
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(97475);
    boolean bool = super.replace(paramn);
    AppMethodBeat.o(97475);
    return bool;
  }
  
  public final boolean bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97489);
    paramString = aBw(paramString);
    int i = paramString.field_iFlag;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.field_iFlag = i;
      c(paramString);
      AppMethodBeat.o(97489);
      return true;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final dia bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97490);
    paramString = aBw(paramString).ecf();
    if (paramString == null)
    {
      ae.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97490);
      return null;
    }
    int i = paramString.HPm;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.HPm = i;
      AppMethodBeat.o(97490);
      return paramString;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(97484);
    if ((paramn == null) || (paramn.field_userName == null) || (paramn.field_userName.equals("")))
    {
      AppMethodBeat.o(97484);
      return false;
    }
    boolean bool = super.replace(paramn);
    AppMethodBeat.o(97484);
    return bool;
  }
  
  public final void dVX()
  {
    AppMethodBeat.i(97472);
    ae.d("MicroMsg.SnsExtStorage", "attachCache");
    this.AdR = true;
    AppMethodBeat.o(97472);
  }
  
  public final void dVY()
  {
    AppMethodBeat.i(97473);
    this.AdR = false;
    this.AdS.dXZ();
    ae.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(97473);
  }
  
  public final int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97479);
    paramString1 = aBw(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(97479);
    return 0;
  }
  
  public final int jV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219638);
    paramString1 = aBw(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace(paramString1);
    AppMethodBeat.o(219638);
    return 0;
  }
  
  public final boolean jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97480);
    paramString1 = aBw(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(97480);
    return bool;
  }
  
  public final int o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97478);
    paramString1 = aBw(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(97478);
    return 0;
  }
  
  public final int p(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162060);
    paramString1 = aBw(paramString1);
    paramString1.field_albumMd5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(162060);
    return 0;
  }
  
  public final void y(String paramString, List<die> paramList)
  {
    AppMethodBeat.i(97494);
    Object localObject = paramList;
    if (paramList == null)
    {
      ae.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
      localObject = new ArrayList();
    }
    ae.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramString = aBw(paramString);
    paramList = paramString.ecd();
    paramList.HPl.clear();
    paramList.HPl.addAll((Collection)localObject);
    paramString.a(paramList);
    c(paramString);
    AppMethodBeat.o(97494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.o
 * JD-Core Version:    0.7.0.1
 */