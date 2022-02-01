package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.f;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends j<n>
  implements f
{
  public static final String[] SQL_CREATE;
  public e db;
  private boolean xiG;
  private g xiH;
  
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
    this.xiG = false;
    this.xiH = null;
    this.db = parame;
    this.xiH = paramg;
    ad.i("MicroMsg.SnsExtStorage", "createExtStorage " + parame + "  " + Thread.currentThread().getId());
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
        ad.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
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
      paramn = "select * from snsExtInfo2 where userName=\"" + bt.aFQ(paramString) + "\"";
      ad.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paramn });
      paramn = this.db.a(paramn, null, 2);
      n localn = new n();
      if (paramn.moveToFirst())
      {
        localn.convertFrom(paramn);
        paramn.close();
        ad.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
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
    if ((this.xiG) && (this.xiH != null))
    {
      bool = this.xiH.a(paramn);
      if (this.xiH != null) {
        this.xiH.dtN();
      }
      AppMethodBeat.o(97476);
      return bool;
    }
    boolean bool = super.replace(paramn);
    AppMethodBeat.o(97476);
    return bool;
  }
  
  public final boolean a(String paramString, cwh paramcwh)
  {
    AppMethodBeat.i(97485);
    if (paramcwh == null)
    {
      AppMethodBeat.o(97485);
      return false;
    }
    paramString = apP(paramString);
    String str = q.st(paramcwh.ijZ);
    if ((!bt.isNullOrNil(paramcwh.ijY)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.dxL();
      ad.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = paramcwh.ijY;
    paramString.field_iFlag = paramcwh.ijX;
    paramString.field_snsBgId = paramcwh.ijZ;
    paramString.field_local_flag |= 0x4;
    if ((paramcwh.Eoc & 0x1000) == 0)
    {
      if ((paramcwh.Eoc & 0x200) <= 0) {
        break label185;
      }
      paramcwh.Eoc |= 0x1000;
      paramcwh.Eod = 4320;
    }
    for (;;)
    {
      paramString.a(paramcwh);
      a(paramString);
      AppMethodBeat.o(97485);
      return true;
      label185:
      if ((paramcwh.Eoc & 0x400) > 0)
      {
        paramcwh.Eoc |= 0x1000;
        paramcwh.Eod = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97491);
    paramString = apP(paramString);
    int k = paramString.field_iFlag;
    if (paramString.dxO() != null) {}
    for (int i = paramString.dxO().Eoc;; i = 0)
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
          cwh localcwh = paramString.dxO();
          if (localcwh != null)
          {
            localcwh.Eoc = j;
            localcwh.Eod = i;
            paramString.a(localcwh);
          }
          c(paramString);
          AppMethodBeat.o(97491);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final cwh anu(String paramString)
  {
    AppMethodBeat.i(97488);
    paramString = apP(paramString);
    if (paramString == null)
    {
      paramString = new cwh();
      AppMethodBeat.o(97488);
      return paramString;
    }
    paramString = paramString.dxO();
    AppMethodBeat.o(97488);
    return paramString;
  }
  
  public final void apM(String paramString)
  {
    AppMethodBeat.i(97477);
    n localn = apP(paramString);
    localn.field_userName = paramString;
    super.delete(localn, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97477);
  }
  
  public final amw apN(String paramString)
  {
    AppMethodBeat.i(97481);
    Object localObject = new amw();
    new n();
    paramString = apP(paramString);
    try
    {
      if (!bt.cw(paramString.field_faultS))
      {
        paramString = (amw)new amw().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new amw();
        }
        AppMethodBeat.o(97481);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void apO(String paramString)
  {
    AppMethodBeat.i(97482);
    new n();
    n localn = apP(paramString);
    localn.field_userName = paramString;
    localn.field_local_flag &= 0xFFFFFFFE;
    c(localn);
    AppMethodBeat.o(97482);
  }
  
  public final n apP(String paramString)
  {
    AppMethodBeat.i(97483);
    n localn2 = new n();
    n localn1 = localn2;
    if (this.xiH != null)
    {
      localn1 = localn2;
      if (this.xiG)
      {
        localn1 = this.xiH.aoF(paramString);
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
  
  public final List<cwl> apQ(String paramString)
  {
    AppMethodBeat.i(97493);
    paramString = apP(paramString).dxM().Eob;
    AppMethodBeat.o(97493);
    return paramString;
  }
  
  public final cwh b(String paramString, cwh paramcwh)
  {
    AppMethodBeat.i(97486);
    n localn = apP(paramString);
    if (localn == null)
    {
      paramString = a(paramString, localn);
      if (paramString != null) {
        if (paramcwh.ijX != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramcwh.ijX)
      {
        paramcwh.ijX = i;
        AppMethodBeat.o(97486);
        return paramcwh;
      }
    }
    String str;
    label97:
    int j;
    if (bt.isNullOrNil(paramcwh.ijY))
    {
      str = localn.field_bgUrl;
      paramcwh.ijY = str;
      if (paramcwh.ijX != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = localn.field_iFlag;
      label108:
      paramcwh.ijX = j;
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
    for (int i = paramString.field_iFlag;; i = paramcwh.ijX)
    {
      paramcwh.ijX = i;
      AppMethodBeat.o(97486);
      return paramcwh;
      str = paramcwh.ijY;
      break;
      i = 0;
      break label97;
      j = paramcwh.ijX;
      break label108;
    }
  }
  
  public final cwh b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97492);
    paramString = apP(paramString).dxO();
    if (paramString == null)
    {
      ad.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97492);
      return null;
    }
    int j = paramString.Eoc;
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
        paramString.Eoc = j;
        paramString.Eod = i;
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
  
  public final boolean bv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97489);
    paramString = apP(paramString);
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
  
  public final cwh bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97490);
    paramString = apP(paramString).dxO();
    if (paramString == null)
    {
      ad.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97490);
      return null;
    }
    int i = paramString.Eoc;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.Eoc = i;
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
  
  public final void drN()
  {
    AppMethodBeat.i(97472);
    ad.d("MicroMsg.SnsExtStorage", "attachCache");
    this.xiG = true;
    AppMethodBeat.o(97472);
  }
  
  public final void drO()
  {
    AppMethodBeat.i(97473);
    this.xiG = false;
    this.xiH.dtO();
    ad.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(97473);
  }
  
  public final int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97479);
    paramString1 = apP(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(97479);
    return 0;
  }
  
  public final boolean je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97480);
    paramString1 = apP(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(97480);
    return bool;
  }
  
  public final int n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97478);
    paramString1 = apP(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(97478);
    return 0;
  }
  
  public final int o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162060);
    paramString1 = apP(paramString1);
    paramString1.field_albumMd5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(162060);
    return 0;
  }
  
  public final void x(String paramString, List<cwl> paramList)
  {
    AppMethodBeat.i(97494);
    if (paramList == null)
    {
      ad.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
      AppMethodBeat.o(97494);
      return;
    }
    ad.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    paramString = apP(paramString);
    cwg localcwg = paramString.dxM();
    localcwg.Eob.clear();
    localcwg.Eob.addAll(paramList);
    paramString.a(localcwg);
    c(paramString);
    AppMethodBeat.o(97494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.o
 * JD-Core Version:    0.7.0.1
 */