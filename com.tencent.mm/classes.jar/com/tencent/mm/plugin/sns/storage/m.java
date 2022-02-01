package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends MAutoStorage<l>
  implements f
{
  public static final String[] SQL_CREATE;
  private boolean Emo;
  private e Emp;
  public h iFy;
  
  static
  {
    AppMethodBeat.i(97496);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.info, "snsExtInfo3") };
    AppMethodBeat.o(97496);
  }
  
  public m(h paramh, e parame)
  {
    super(paramh, l.info, "snsExtInfo3", null);
    AppMethodBeat.i(203187);
    this.Emo = false;
    this.Emp = null;
    this.iFy = paramh;
    this.Emp = parame;
    Log.i("MicroMsg.SnsExtStorage", "createExtStorage " + paramh + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(203187);
  }
  
  private l a(String paramString, l paraml)
  {
    AppMethodBeat.i(97487);
    int j;
    int k;
    if (paraml == null)
    {
      j = 0;
      k = 0;
      i = j;
      label18:
      if ((k != 0) || (i != 0)) {
        break label232;
      }
      paraml = this.iFy.rawQuery("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
      if (!paraml.moveToFirst()) {
        break label239;
      }
    }
    label232:
    label239:
    for (int i = paraml.getInt(0);; i = 0)
    {
      paraml.close();
      if (i == 0)
      {
        Log.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
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
      paraml = "select * from snsExtInfo2 where userName=\"" + Util.escapeSqlValue(paramString) + "\"";
      Log.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paraml });
      paraml = this.iFy.rawQuery(paraml, null, 2);
      l locall = new l();
      if (paraml.moveToFirst())
      {
        locall.convertFrom(paraml);
        paraml.close();
        Log.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
        return locall;
      }
      paraml.close();
      AppMethodBeat.o(97487);
      return null;
    }
  }
  
  public final void D(String paramString, List<ebo> paramList)
  {
    AppMethodBeat.i(97494);
    Object localObject = paramList;
    if (paramList == null)
    {
      Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
      localObject = new ArrayList();
    }
    Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramString = aQr(paramString);
    paramList = paramString.feJ();
    paramList.Nbb.clear();
    paramList.Nbb.addAll((Collection)localObject);
    paramString.a(paramList);
    c(paramString);
    AppMethodBeat.o(97494);
  }
  
  public final boolean a(l paraml)
  {
    AppMethodBeat.i(97476);
    if ((this.Emo) && (this.Emp != null))
    {
      bool = this.Emp.a(paraml);
      if (this.Emp != null) {
        this.Emp.fbm();
      }
      AppMethodBeat.o(97476);
      return bool;
    }
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(97476);
    return bool;
  }
  
  public final boolean a(String paramString, ebj paramebj)
  {
    AppMethodBeat.i(97485);
    if (paramebj == null)
    {
      AppMethodBeat.o(97485);
      return false;
    }
    paramString = aQr(paramString);
    String str = r.Jb(paramebj.kel);
    if ((!Util.isNullOrNil(paramebj.kek)) && ((paramString.field_bgUrl == null) || (!paramString.field_bgId.equals(str))))
    {
      paramString.field_older_bgId = paramString.field_bgId;
      paramString.field_local_flag |= 0x1;
      paramString.feI();
      Log.d("MicroMsg.SnsExtStorage", "bg change");
    }
    paramString.field_bgId = str;
    paramString.field_bgUrl = paramebj.kek;
    paramString.field_iFlag = paramebj.kej;
    paramString.field_snsBgId = paramebj.kel;
    paramString.field_local_flag |= 0x4;
    if ((paramebj.Nbc & 0x1000) == 0)
    {
      if ((paramebj.Nbc & 0x200) <= 0) {
        break label186;
      }
      paramebj.Nbc |= 0x1000;
      paramebj.Nbd = 4320;
    }
    for (;;)
    {
      paramString.a(paramebj);
      a(paramString);
      AppMethodBeat.o(97485);
      return true;
      label186:
      if ((paramebj.Nbc & 0x400) > 0)
      {
        paramebj.Nbc |= 0x1000;
        paramebj.Nbd = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97491);
    paramString = aQr(paramString);
    int k = paramString.field_iFlag;
    if (paramString.feL() != null) {}
    for (int i = paramString.feL().Nbc;; i = 0)
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
          ebj localebj = paramString.feL();
          if (localebj != null)
          {
            localebj.Nbc = j;
            localebj.Nbd = i;
            paramString.a(localebj);
          }
          c(paramString);
          AppMethodBeat.o(97491);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final ebj aNV(String paramString)
  {
    AppMethodBeat.i(97488);
    paramString = aQr(paramString);
    if (paramString == null)
    {
      paramString = new ebj();
      AppMethodBeat.o(97488);
      return paramString;
    }
    paramString = paramString.feL();
    AppMethodBeat.o(97488);
    return paramString;
  }
  
  public final void aQo(String paramString)
  {
    AppMethodBeat.i(97477);
    l locall = aQr(paramString);
    locall.field_userName = paramString;
    super.delete(locall, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97477);
  }
  
  public final bft aQp(String paramString)
  {
    AppMethodBeat.i(97481);
    Object localObject = new bft();
    new l();
    paramString = aQr(paramString);
    try
    {
      if (!Util.isNullOrNil(paramString.field_faultS))
      {
        paramString = (bft)new bft().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new bft();
        }
        AppMethodBeat.o(97481);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        paramString = (String)localObject;
      }
    }
  }
  
  public final void aQq(String paramString)
  {
    AppMethodBeat.i(97482);
    new l();
    l locall = aQr(paramString);
    locall.field_userName = paramString;
    locall.field_local_flag &= 0xFFFFFFFE;
    c(locall);
    AppMethodBeat.o(97482);
  }
  
  public final l aQr(String paramString)
  {
    AppMethodBeat.i(97483);
    l locall2 = new l();
    l locall1 = locall2;
    if (this.Emp != null)
    {
      locall1 = locall2;
      if (this.Emo)
      {
        locall1 = this.Emp.aPj(paramString);
        if (locall1 != null)
        {
          AppMethodBeat.o(97483);
          return locall1;
        }
        locall1 = new l();
      }
    }
    locall1.field_userName = paramString;
    super.get(locall1, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97483);
    return locall1;
  }
  
  public final List<ebo> aQs(String paramString)
  {
    AppMethodBeat.i(97493);
    paramString = aQr(paramString).feJ().Nbb;
    AppMethodBeat.o(97493);
    return paramString;
  }
  
  public final ebj b(String paramString, ebj paramebj)
  {
    AppMethodBeat.i(97486);
    l locall = aQr(paramString);
    if (locall == null)
    {
      paramString = a(paramString, locall);
      if (paramString != null) {
        if (paramebj.kej != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramebj.kej)
      {
        paramebj.kej = i;
        AppMethodBeat.o(97486);
        return paramebj;
      }
    }
    String str;
    label97:
    int j;
    if (Util.isNullOrNil(paramebj.kek))
    {
      str = locall.field_bgUrl;
      paramebj.kek = str;
      if (paramebj.kej != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = locall.field_iFlag;
      label108:
      paramebj.kej = j;
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
    for (int i = paramString.field_iFlag;; i = paramebj.kej)
    {
      paramebj.kej = i;
      AppMethodBeat.o(97486);
      return paramebj;
      str = paramebj.kek;
      break;
      i = 0;
      break label97;
      j = paramebj.kej;
      break label108;
    }
  }
  
  public final ebj b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97492);
    paramString = aQr(paramString).feL();
    if (paramString == null)
    {
      Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97492);
      return null;
    }
    int j = paramString.Nbc;
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
        paramString.Nbc = j;
        paramString.Nbd = i;
        AppMethodBeat.o(97492);
        return paramString;
        j &= 0xFFFFF7FF;
      }
    }
  }
  
  public final boolean b(l paraml)
  {
    AppMethodBeat.i(97475);
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(97475);
    return bool;
  }
  
  public final boolean c(l paraml)
  {
    AppMethodBeat.i(97484);
    if ((paraml == null) || (paraml.field_userName == null) || (paraml.field_userName.equals("")))
    {
      AppMethodBeat.o(97484);
      return false;
    }
    boolean bool = super.replace(paraml);
    AppMethodBeat.o(97484);
    return bool;
  }
  
  public final boolean cf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97489);
    paramString = aQr(paramString);
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
  
  public final ebj cg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97490);
    paramString = aQr(paramString).feL();
    if (paramString == null)
    {
      Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97490);
      return null;
    }
    int i = paramString.Nbc;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.Nbc = i;
      AppMethodBeat.o(97490);
      return paramString;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final void eZi()
  {
    AppMethodBeat.i(97472);
    Log.d("MicroMsg.SnsExtStorage", "attachCache");
    this.Emo = true;
    AppMethodBeat.o(97472);
  }
  
  public final void eZj()
  {
    AppMethodBeat.i(97473);
    this.Emo = false;
    this.Emp.fbn();
    Log.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(97473);
  }
  
  public final int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97479);
    paramString1 = aQr(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(97479);
    return 0;
  }
  
  public final int kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203188);
    paramString1 = aQr(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace(paramString1);
    AppMethodBeat.o(203188);
    return 0;
  }
  
  public final boolean kK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97480);
    paramString1 = aQr(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(97480);
    return bool;
  }
  
  public final int o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97478);
    paramString1 = aQr(paramString1);
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
    paramString1 = aQr(paramString1);
    paramString1.field_albumMd5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(162060);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.m
 * JD-Core Version:    0.7.0.1
 */