package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
  extends j<l>
  implements com.tencent.mm.plugin.sns.b.e
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  private boolean rDa;
  private g rDb;
  
  static
  {
    AppMethodBeat.i(37881);
    SQL_CREATE = new String[] { j.getCreateSQLs(l.info, "snsExtInfo3") };
    AppMethodBeat.o(37881);
  }
  
  public m(com.tencent.mm.sdk.e.e parame, g paramg)
  {
    super(parame, l.info, "snsExtInfo3", null);
    AppMethodBeat.i(37861);
    this.rDa = false;
    this.rDb = null;
    this.db = parame;
    this.rDb = paramg;
    ab.i("MicroMsg.SnsExtStorage", "createExtStorage " + parame + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(37861);
  }
  
  private l a(String paramString, l paraml)
  {
    AppMethodBeat.i(37874);
    int j;
    int k;
    if (paraml == null)
    {
      j = 0;
      k = 0;
      i = j;
      label18:
      if ((k != 0) || (i != 0)) {
        break label236;
      }
      paraml = this.db.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
      if (!paraml.moveToFirst()) {
        break label243;
      }
    }
    label236:
    label243:
    for (int i = paraml.getInt(0);; i = 0)
    {
      paraml.close();
      if (i == 0)
      {
        ab.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
        AppMethodBeat.o(37874);
        return null;
        if ((paraml.field_iFlag & 0x1) > 0) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ((paraml.field_local_flag & 0x4) <= 0) {
            break;
          }
          k = 1;
          break label18;
        }
      }
      paraml = "select * from snsExtInfo2 where userName=\"" + bo.wC(paramString) + "\"";
      ab.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paraml });
      paraml = this.db.a(paraml, null, 2);
      l locall = new l();
      if (paraml.moveToFirst())
      {
        locall.convertFrom(paraml);
        paraml.close();
        ab.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
        AppMethodBeat.o(37874);
        return locall;
      }
      paraml.close();
      AppMethodBeat.o(37874);
      return null;
    }
  }
  
  public final cfj Zu(String paramString)
  {
    AppMethodBeat.i(37875);
    paramString = abz(paramString);
    if (paramString == null)
    {
      paramString = new cfj();
      AppMethodBeat.o(37875);
      return paramString;
    }
    paramString = paramString.csx();
    AppMethodBeat.o(37875);
    return paramString;
  }
  
  public final boolean a(l paraml)
  {
    AppMethodBeat.i(37863);
    if ((this.rDa) && (this.rDb != null))
    {
      bool = this.rDb.a(paraml);
      if (this.rDb != null) {
        this.rDb.cpu();
      }
      AppMethodBeat.o(37863);
      return bool;
    }
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(37863);
    return bool;
  }
  
  public final boolean a(String paramString, cfj paramcfj)
  {
    AppMethodBeat.i(37872);
    if (paramcfj == null)
    {
      AppMethodBeat.o(37872);
      return false;
    }
    paramString = abz(paramString);
    String str = i.lq(paramcfj.gxc);
    if ((!bo.isNullOrNil(paramcfj.gxb)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.csv();
      ab.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = paramcfj.gxb;
    paramString.field_iFlag = paramcfj.gxa;
    paramString.field_snsBgId = paramcfj.gxc;
    paramString.field_local_flag |= 0x4;
    if ((paramcfj.xPN & 0x1000) == 0)
    {
      if ((paramcfj.xPN & 0x200) <= 0) {
        break label185;
      }
      paramcfj.xPN |= 0x1000;
      paramcfj.xPO = 4320;
    }
    for (;;)
    {
      paramString.a(paramcfj);
      a(paramString);
      AppMethodBeat.o(37872);
      return true;
      label185:
      if ((paramcfj.xPN & 0x400) > 0)
      {
        paramcfj.xPN |= 0x1000;
        paramcfj.xPO = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(37878);
    paramString = abz(paramString);
    int k = paramString.field_iFlag;
    if (paramString.csx() != null) {}
    for (int i = paramString.csx().xPN;; i = 0)
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
          cfj localcfj = paramString.csx();
          if (localcfj != null)
          {
            localcfj.xPN = j;
            localcfj.xPO = i;
            paramString.a(localcfj);
          }
          c(paramString);
          AppMethodBeat.o(37878);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final void abw(String paramString)
  {
    AppMethodBeat.i(37864);
    l locall = abz(paramString);
    locall.field_userName = paramString;
    super.delete(locall, new String[] { getPrimaryKey() });
    AppMethodBeat.o(37864);
  }
  
  public final aei abx(String paramString)
  {
    AppMethodBeat.i(37868);
    Object localObject = new aei();
    new l();
    paramString = abz(paramString);
    try
    {
      if (!bo.ce(paramString.field_faultS))
      {
        paramString = (aei)new aei().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new aei();
        }
        AppMethodBeat.o(37868);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void aby(String paramString)
  {
    AppMethodBeat.i(37869);
    new l();
    l locall = abz(paramString);
    locall.field_userName = paramString;
    locall.field_local_flag &= 0xFFFFFFFE;
    c(locall);
    AppMethodBeat.o(37869);
  }
  
  public final l abz(String paramString)
  {
    AppMethodBeat.i(37870);
    l locall2 = new l();
    l locall1 = locall2;
    if (this.rDb != null)
    {
      locall1 = locall2;
      if (this.rDa)
      {
        locall1 = this.rDb.aaw(paramString);
        if (locall1 != null)
        {
          AppMethodBeat.o(37870);
          return locall1;
        }
        locall1 = new l();
      }
    }
    locall1.field_userName = paramString;
    super.get(locall1, new String[] { getPrimaryKey() });
    AppMethodBeat.o(37870);
    return locall1;
  }
  
  public final cfj b(String paramString, cfj paramcfj)
  {
    AppMethodBeat.i(37873);
    l locall = abz(paramString);
    if (locall == null)
    {
      paramString = a(paramString, locall);
      if (paramString != null) {
        if (paramcfj.gxa != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramcfj.gxa)
      {
        paramcfj.gxa = i;
        AppMethodBeat.o(37873);
        return paramcfj;
      }
    }
    String str;
    label97:
    int j;
    if (bo.isNullOrNil(paramcfj.gxb))
    {
      str = locall.field_bgUrl;
      paramcfj.gxb = str;
      if (paramcfj.gxa != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = locall.field_iFlag;
      label108:
      paramcfj.gxa = j;
      paramString = a(paramString, locall);
      if (paramString != null) {
        if (i == 0) {
          break label171;
        }
      }
    }
    label157:
    label162:
    label171:
    for (int i = paramString.field_iFlag;; i = paramcfj.gxa)
    {
      paramcfj.gxa = i;
      AppMethodBeat.o(37873);
      return paramcfj;
      str = paramcfj.gxb;
      break;
      i = 0;
      break label97;
      j = paramcfj.gxa;
      break label108;
    }
  }
  
  public final cfj b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(37879);
    paramString = abz(paramString).csx();
    if (paramString == null)
    {
      ab.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(37879);
      return null;
    }
    int j = paramString.xPN;
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
        paramString.xPN = j;
        paramString.xPO = i;
        AppMethodBeat.o(37879);
        return paramString;
        j &= 0xFFFFF7FF;
      }
    }
  }
  
  public final boolean b(l paraml)
  {
    AppMethodBeat.i(37862);
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(37862);
    return bool;
  }
  
  public final boolean bn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37876);
    paramString = abz(paramString);
    int i = paramString.field_iFlag;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.field_iFlag = i;
      c(paramString);
      AppMethodBeat.o(37876);
      return true;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final cfj bo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37877);
    paramString = abz(paramString).csx();
    if (paramString == null)
    {
      ab.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(37877);
      return null;
    }
    int i = paramString.xPN;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.xPN = i;
      AppMethodBeat.o(37877);
      return paramString;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final boolean c(l paraml)
  {
    AppMethodBeat.i(37871);
    if ((paraml == null) || (paraml.field_userName == null) || (paraml.field_userName.equals("")))
    {
      AppMethodBeat.o(37871);
      return false;
    }
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(37871);
    return bool;
  }
  
  public final void cnK()
  {
    AppMethodBeat.i(37859);
    ab.d("MicroMsg.SnsExtStorage", "attachCache");
    this.rDa = true;
    AppMethodBeat.o(37859);
  }
  
  public final void cnL()
  {
    AppMethodBeat.i(37860);
    this.rDa = false;
    this.rDb.cpv();
    ab.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(37860);
  }
  
  public final boolean gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37867);
    paramString1 = abz(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(37867);
    return bool;
  }
  
  public final int h(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(37866);
    paramString1 = abz(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(37866);
    return 0;
  }
  
  public final int l(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37865);
    paramString1 = abz(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(37865);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.m
 * JD-Core Version:    0.7.0.1
 */