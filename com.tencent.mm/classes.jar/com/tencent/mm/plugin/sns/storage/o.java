package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends j<n>
  implements f
{
  public static final String[] SQL_CREATE;
  public e db;
  private boolean yvx;
  private g yvy;
  
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
    this.yvx = false;
    this.yvy = null;
    this.db = parame;
    this.yvy = paramg;
    ac.i("MicroMsg.SnsExtStorage", "createExtStorage " + parame + "  " + Thread.currentThread().getId());
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
        ac.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
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
      paramn = "select * from snsExtInfo2 where userName=\"" + bs.aLh(paramString) + "\"";
      ac.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paramn });
      paramn = this.db.a(paramn, null, 2);
      n localn = new n();
      if (paramn.moveToFirst())
      {
        localn.convertFrom(paramn);
        paramn.close();
        ac.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
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
    if ((this.yvx) && (this.yvy != null))
    {
      bool = this.yvy.a(paramn);
      if (this.yvy != null) {
        this.yvy.dIl();
      }
      AppMethodBeat.o(97476);
      return bool;
    }
    boolean bool = super.replace(paramn);
    AppMethodBeat.o(97476);
    return bool;
  }
  
  public final boolean a(String paramString, dbt paramdbt)
  {
    AppMethodBeat.i(97485);
    if (paramdbt == null)
    {
      AppMethodBeat.o(97485);
      return false;
    }
    paramString = auY(paramString);
    String str = q.wW(paramdbt.iKg);
    if ((!bs.isNullOrNil(paramdbt.iKf)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.dMi();
      ac.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = paramdbt.iKf;
    paramString.field_iFlag = paramdbt.iKe;
    paramString.field_snsBgId = paramdbt.iKg;
    paramString.field_local_flag |= 0x4;
    if ((paramdbt.FLb & 0x1000) == 0)
    {
      if ((paramdbt.FLb & 0x200) <= 0) {
        break label185;
      }
      paramdbt.FLb |= 0x1000;
      paramdbt.FLc = 4320;
    }
    for (;;)
    {
      paramString.a(paramdbt);
      a(paramString);
      AppMethodBeat.o(97485);
      return true;
      label185:
      if ((paramdbt.FLb & 0x400) > 0)
      {
        paramdbt.FLb |= 0x1000;
        paramdbt.FLc = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97491);
    paramString = auY(paramString);
    int k = paramString.field_iFlag;
    if (paramString.dMl() != null) {}
    for (int i = paramString.dMl().FLb;; i = 0)
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
          dbt localdbt = paramString.dMl();
          if (localdbt != null)
          {
            localdbt.FLb = j;
            localdbt.FLc = i;
            paramString.a(localdbt);
          }
          c(paramString);
          AppMethodBeat.o(97491);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final dbt asG(String paramString)
  {
    AppMethodBeat.i(97488);
    paramString = auY(paramString);
    if (paramString == null)
    {
      paramString = new dbt();
      AppMethodBeat.o(97488);
      return paramString;
    }
    paramString = paramString.dMl();
    AppMethodBeat.o(97488);
    return paramString;
  }
  
  public final void auV(String paramString)
  {
    AppMethodBeat.i(97477);
    n localn = auY(paramString);
    localn.field_userName = paramString;
    super.delete(localn, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97477);
  }
  
  public final aqa auW(String paramString)
  {
    AppMethodBeat.i(97481);
    Object localObject = new aqa();
    new n();
    paramString = auY(paramString);
    try
    {
      if (!bs.cv(paramString.field_faultS))
      {
        paramString = (aqa)new aqa().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new aqa();
        }
        AppMethodBeat.o(97481);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void auX(String paramString)
  {
    AppMethodBeat.i(97482);
    new n();
    n localn = auY(paramString);
    localn.field_userName = paramString;
    localn.field_local_flag &= 0xFFFFFFFE;
    c(localn);
    AppMethodBeat.o(97482);
  }
  
  public final n auY(String paramString)
  {
    AppMethodBeat.i(97483);
    n localn2 = new n();
    n localn1 = localn2;
    if (this.yvy != null)
    {
      localn1 = localn2;
      if (this.yvx)
      {
        localn1 = this.yvy.atR(paramString);
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
  
  public final List<dbx> auZ(String paramString)
  {
    AppMethodBeat.i(97493);
    paramString = auY(paramString).dMj().FLa;
    AppMethodBeat.o(97493);
    return paramString;
  }
  
  public final dbt b(String paramString, dbt paramdbt)
  {
    AppMethodBeat.i(97486);
    n localn = auY(paramString);
    if (localn == null)
    {
      paramString = a(paramString, localn);
      if (paramString != null) {
        if (paramdbt.iKe != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramdbt.iKe)
      {
        paramdbt.iKe = i;
        AppMethodBeat.o(97486);
        return paramdbt;
      }
    }
    String str;
    label97:
    int j;
    if (bs.isNullOrNil(paramdbt.iKf))
    {
      str = localn.field_bgUrl;
      paramdbt.iKf = str;
      if (paramdbt.iKe != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = localn.field_iFlag;
      label108:
      paramdbt.iKe = j;
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
    for (int i = paramString.field_iFlag;; i = paramdbt.iKe)
    {
      paramdbt.iKe = i;
      AppMethodBeat.o(97486);
      return paramdbt;
      str = paramdbt.iKf;
      break;
      i = 0;
      break label97;
      j = paramdbt.iKe;
      break label108;
    }
  }
  
  public final dbt b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97492);
    paramString = auY(paramString).dMl();
    if (paramString == null)
    {
      ac.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97492);
      return null;
    }
    int j = paramString.FLb;
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
        paramString.FLb = j;
        paramString.FLc = i;
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
  
  public final boolean bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97489);
    paramString = auY(paramString);
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
  
  public final dbt bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97490);
    paramString = auY(paramString).dMl();
    if (paramString == null)
    {
      ac.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97490);
      return null;
    }
    int i = paramString.FLb;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.FLb = i;
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
  
  public final void dGm()
  {
    AppMethodBeat.i(97472);
    ac.d("MicroMsg.SnsExtStorage", "attachCache");
    this.yvx = true;
    AppMethodBeat.o(97472);
  }
  
  public final void dGn()
  {
    AppMethodBeat.i(97473);
    this.yvx = false;
    this.yvy.dIm();
    ac.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(97473);
  }
  
  public final int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97479);
    paramString1 = auY(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(97479);
    return 0;
  }
  
  public final boolean jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97480);
    paramString1 = auY(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(97480);
    return bool;
  }
  
  public final int n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97478);
    paramString1 = auY(paramString1);
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
    paramString1 = auY(paramString1);
    paramString1.field_albumMd5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(162060);
    return 0;
  }
  
  public final void v(String paramString, List<dbx> paramList)
  {
    AppMethodBeat.i(97494);
    if (paramList == null)
    {
      ac.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
      AppMethodBeat.o(97494);
      return;
    }
    ac.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    paramString = auY(paramString);
    dbs localdbs = paramString.dMj();
    localdbs.FLa.clear();
    localdbs.FLa.addAll(paramList);
    paramString.a(localdbs);
    c(paramString);
    AppMethodBeat.o(97494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.o
 * JD-Core Version:    0.7.0.1
 */