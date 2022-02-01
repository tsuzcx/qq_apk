package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends MAutoStorage<u>
  implements com.tencent.mm.plugin.sns.c.h
{
  public static final String[] SQL_CREATE;
  private boolean QYP;
  private j QYQ;
  public com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(97496);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(u.info, "snsExtInfo3") };
    AppMethodBeat.o(97496);
  }
  
  public v(com.tencent.mm.storagebase.h paramh, j paramj)
  {
    super(paramh, u.info, "snsExtInfo3", null);
    AppMethodBeat.i(306606);
    this.QYP = false;
    this.QYQ = null;
    Cursor localCursor = paramh.rawQuery("PRAGMA table_info( " + "snsExtInfo3" + " )", null, 2);
    int n = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int m = 0;
    int k = 0;
    String str;
    while (localCursor.moveToNext()) {
      if (n >= 0)
      {
        str = localCursor.getString(n);
        if ("imBGaeskey".equalsIgnoreCase(str)) {
          k = 1;
        }
        if ("imBGauthkey".equalsIgnoreCase(str)) {
          m = 1;
        }
        if (!"imBGmd5sum".equalsIgnoreCase(str)) {
          break label370;
        }
        i = 1;
      }
    }
    label370:
    for (;;)
    {
      if ("imBGfileid".equalsIgnoreCase(str)) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = paramh.beginTransaction(Thread.currentThread().getId());
      if (k == 0) {
        paramh.execSQL("snsExtInfo3", "Alter table " + "snsExtInfo3" + " add imBGaeskey STRING");
      }
      if (m == 0) {
        paramh.execSQL("snsExtInfo3", "Alter table " + "snsExtInfo3" + " add imBGauthkey STRING");
      }
      if (i == 0) {
        paramh.execSQL("snsExtInfo3", "Alter table " + "snsExtInfo3" + " add imBGmd5sum STRING");
      }
      if (j == 0) {
        paramh.execSQL("snsExtInfo3", "Alter table " + "snsExtInfo3" + " add imBGfileid STRING");
      }
      paramh.endTransaction(l);
      this.omV = paramh;
      this.QYQ = paramj;
      Log.i("MicroMsg.SnsExtStorage", "createExtStorage " + paramh + "  " + Thread.currentThread().getId());
      AppMethodBeat.o(306606);
      return;
    }
  }
  
  private u a(String paramString, u paramu)
  {
    AppMethodBeat.i(97487);
    int j;
    int k;
    if (paramu == null)
    {
      j = 0;
      k = 0;
      i = j;
      label18:
      if ((k != 0) || (i != 0)) {
        break label232;
      }
      paramu = this.omV.rawQuery("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
      if (!paramu.moveToFirst()) {
        break label239;
      }
    }
    label232:
    label239:
    for (int i = paramu.getInt(0);; i = 0)
    {
      paramu.close();
      if (i == 0)
      {
        Log.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
        return null;
        if ((paramu.field_iFlag & 0x1) > 0) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ((paramu.field_local_flag & 0x4) <= 0) {
            break;
          }
          k = 1;
          break label18;
        }
      }
      paramu = "select * from snsExtInfo2 where userName=\"" + Util.escapeSqlValue(paramString) + "\"";
      Log.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[] { paramu });
      paramu = this.omV.rawQuery(paramu, null, 2);
      u localu = new u();
      if (paramu.moveToFirst())
      {
        localu.convertFrom(paramu);
        paramu.close();
        Log.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[] { paramString });
        AppMethodBeat.o(97487);
        return localu;
      }
      paramu.close();
      AppMethodBeat.o(97487);
      return null;
    }
  }
  
  public static void a(u paramu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(306617);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("MicroMsg.SnsExtStorage", "clear cached background image as it has been banned: username=%s", new Object[] { paramString2 });
      paramString1 = al.getAccSnsPath();
      String str1 = paramString2 + "bg_";
      String str2 = paramString2 + "tbg_";
      y.deleteFile(as.mg(paramString1, paramString2) + str2);
      y.deleteFile(as.mg(paramString1, paramString2) + str1);
      paramu.field_older_bgId = null;
      paramu.field_bgId = null;
    }
    AppMethodBeat.o(306617);
  }
  
  public final void J(String paramString, List<fgh> paramList)
  {
    AppMethodBeat.i(97494);
    Object localObject = paramList;
    if (paramList == null)
    {
      Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
      localObject = new ArrayList();
    }
    Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramString = aZW(paramString);
    paramList = paramString.hkP();
    paramList.abFE.clear();
    paramList.abFE.addAll((Collection)localObject);
    paramString.a(paramList);
    c(paramString);
    AppMethodBeat.o(97494);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(97476);
    if ((this.QYP) && (this.QYQ != null))
    {
      bool = this.QYQ.a(paramu);
      if (this.QYQ != null) {
        this.QYQ.hgZ();
      }
      AppMethodBeat.o(97476);
      return bool;
    }
    boolean bool = super.replace(paramu);
    AppMethodBeat.o(97476);
    return bool;
  }
  
  public final boolean a(String paramString, ffs paramffs)
  {
    AppMethodBeat.i(97485);
    if (paramffs == null)
    {
      AppMethodBeat.o(97485);
      return false;
    }
    u localu = aZW(paramString);
    String str = t.uA(paramffs.pSs);
    if ((!Util.isNullOrNil(paramffs.pSr)) && ((localu.field_bgUrl == null) || (!localu.field_bgId.equals(str))))
    {
      localu.field_older_bgId = localu.field_bgId;
      localu.field_local_flag |= 0x1;
      localu.hkO();
      Log.d("MicroMsg.SnsExtStorage", "bg change");
    }
    localu.field_bgId = str;
    localu.field_bgUrl = paramffs.pSr;
    a(localu, paramffs.pSr, paramString);
    localu.field_iFlag = paramffs.pSq;
    localu.field_snsBgId = paramffs.pSs;
    localu.field_local_flag |= 0x4;
    if ((paramffs.abFF & 0x1000) == 0)
    {
      if ((paramffs.abFF & 0x200) <= 0) {
        break label201;
      }
      paramffs.abFF |= 0x1000;
      paramffs.abFG = 4320;
    }
    for (;;)
    {
      localu.a(paramffs);
      a(localu);
      AppMethodBeat.o(97485);
      return true;
      label201:
      if ((paramffs.abFF & 0x400) > 0)
      {
        paramffs.abFF |= 0x1000;
        paramffs.abFG = 72;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97491);
    paramString = aZW(paramString);
    int k = paramString.field_iFlag;
    if (paramString.hkR() != null) {}
    for (int i = paramString.hkR().abFF;; i = 0)
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
          ffs localffs = paramString.hkR();
          if (localffs != null)
          {
            localffs.abFF = j;
            localffs.abFG = i;
            paramString.a(localffs);
          }
          c(paramString);
          AppMethodBeat.o(97491);
          return true;
          k &= 0xFFFFF7FF;
        }
      }
    }
  }
  
  public final ffs aWV(String paramString)
  {
    AppMethodBeat.i(97488);
    paramString = aZW(paramString);
    if (paramString == null)
    {
      paramString = new ffs();
      AppMethodBeat.o(97488);
      return paramString;
    }
    paramString = paramString.hkR();
    AppMethodBeat.o(97488);
    return paramString;
  }
  
  public final void aZQ(String paramString)
  {
    AppMethodBeat.i(306640);
    paramString = aZW(paramString);
    paramString.field_md5 = "";
    c(paramString);
    AppMethodBeat.o(306640);
  }
  
  public final void aZR(String paramString)
  {
    AppMethodBeat.i(97477);
    u localu = aZW(paramString);
    localu.field_userName = paramString;
    super.delete(localu, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97477);
  }
  
  public final String aZS(String paramString)
  {
    AppMethodBeat.i(306658);
    paramString = aZW(paramString).field_md5;
    AppMethodBeat.o(306658);
    return paramString;
  }
  
  public final String aZT(String paramString)
  {
    AppMethodBeat.i(306661);
    paramString = aZW(paramString).field_albumMd5;
    AppMethodBeat.o(306661);
    return paramString;
  }
  
  public final can aZU(String paramString)
  {
    AppMethodBeat.i(97481);
    Object localObject = new can();
    paramString = aZW(paramString);
    try
    {
      if (!Util.isNullOrNil(paramString.field_faultS))
      {
        paramString = (can)new can().parseFrom(paramString.field_faultS);
        localObject = paramString;
        if (paramString == null) {
          localObject = new can();
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
  
  public final void aZV(String paramString)
  {
    AppMethodBeat.i(97482);
    u localu = aZW(paramString);
    localu.field_userName = paramString;
    localu.field_local_flag &= 0xFFFFFFFE;
    c(localu);
    AppMethodBeat.o(97482);
  }
  
  public final u aZW(String paramString)
  {
    AppMethodBeat.i(97483);
    u localu2 = new u();
    u localu1 = localu2;
    if (this.QYQ != null)
    {
      localu1 = localu2;
      if (this.QYP)
      {
        localu1 = this.QYQ.aYu(paramString);
        if (localu1 != null)
        {
          AppMethodBeat.o(97483);
          return localu1;
        }
        localu1 = new u();
      }
    }
    localu1.field_userName = paramString;
    super.get(localu1, new String[] { getPrimaryKey() });
    AppMethodBeat.o(97483);
    return localu1;
  }
  
  public final boolean aZX(String paramString)
  {
    AppMethodBeat.i(306696);
    paramString = aZW(paramString);
    if ((paramString.field_snsBgId != 0L) || ((!Util.isNullOrNil(paramString.field_bgId)) && (!paramString.field_bgId.equals("0"))))
    {
      AppMethodBeat.o(306696);
      return true;
    }
    AppMethodBeat.o(306696);
    return false;
  }
  
  public final List<fgh> aZY(String paramString)
  {
    AppMethodBeat.i(97493);
    paramString = aZW(paramString).hkP().abFE;
    AppMethodBeat.o(97493);
    return paramString;
  }
  
  public final ffs b(String paramString, ffs paramffs)
  {
    AppMethodBeat.i(97486);
    u localu = aZW(paramString);
    if (localu == null)
    {
      paramString = a(paramString, localu);
      if (paramString != null) {
        if (paramffs.pSq != -1) {
          break label56;
        }
      }
      label56:
      for (i = paramString.field_iFlag;; i = paramffs.pSq)
      {
        paramffs.pSq = i;
        AppMethodBeat.o(97486);
        return paramffs;
      }
    }
    String str;
    label97:
    int j;
    if (Util.isNullOrNil(paramffs.pSr))
    {
      str = localu.field_bgUrl;
      paramffs.pSr = str;
      if (paramffs.pSq != -1) {
        break label157;
      }
      i = 1;
      if (i == 0) {
        break label162;
      }
      j = localu.field_iFlag;
      label108:
      paramffs.pSq = j;
      paramString = a(paramString, localu);
      if (paramString != null) {
        if (i == 0) {
          break label171;
        }
      }
    }
    label157:
    label162:
    label171:
    for (int i = paramString.field_iFlag;; i = paramffs.pSq)
    {
      paramffs.pSq = i;
      AppMethodBeat.o(97486);
      return paramffs;
      str = paramffs.pSr;
      break;
      i = 0;
      break label97;
      j = paramffs.pSq;
      break label108;
    }
  }
  
  public final ffs b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(97492);
    paramString = aZW(paramString).hkR();
    if (paramString == null)
    {
      Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97492);
      return null;
    }
    int j = paramString.abFF;
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
        paramString.abFF = j;
        paramString.abFG = i;
        AppMethodBeat.o(97492);
        return paramString;
        j &= 0xFFFFF7FF;
      }
    }
  }
  
  public final boolean b(u paramu)
  {
    AppMethodBeat.i(97475);
    boolean bool = super.replace(paramu);
    AppMethodBeat.o(97475);
    return bool;
  }
  
  public final boolean c(u paramu)
  {
    AppMethodBeat.i(97484);
    if ((paramu == null) || (paramu.field_userName == null) || (paramu.field_userName.equals("")))
    {
      AppMethodBeat.o(97484);
      return false;
    }
    boolean bool = super.replace(paramu);
    AppMethodBeat.o(97484);
    return bool;
  }
  
  public final boolean cR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97489);
    paramString = aZW(paramString);
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
  
  public final ffs cS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97490);
    paramString = aZW(paramString).hkR();
    if (paramString == null)
    {
      Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
      AppMethodBeat.o(97490);
      return null;
    }
    int i = paramString.abFF;
    if (paramBoolean) {
      i |= 0x1;
    }
    for (;;)
    {
      paramString.abFF = i;
      AppMethodBeat.o(97490);
      return paramString;
      i &= 0xFFFFFFFE;
    }
  }
  
  public final int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97479);
    paramString1 = aZW(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_adsession = paramArrayOfByte;
    super.replace(paramString1);
    AppMethodBeat.o(97479);
    return 0;
  }
  
  public final void hee()
  {
    AppMethodBeat.i(97472);
    Log.d("MicroMsg.SnsExtStorage", "attachCache");
    this.QYP = true;
    AppMethodBeat.o(97472);
  }
  
  public final void hef()
  {
    AppMethodBeat.i(97473);
    this.QYP = false;
    this.QYQ.hha();
    Log.d("MicroMsg.SnsExtStorage", "detchCache");
    AppMethodBeat.o(97473);
  }
  
  public final void hkT()
  {
    AppMethodBeat.i(306635);
    u localu = aZW("@__weixintimtline");
    localu.field_md5 = "";
    localu.field_albumMd5 = "";
    a(localu);
    AppMethodBeat.o(306635);
  }
  
  public final void hkU()
  {
    AppMethodBeat.i(306644);
    u localu = aZW(z.bAM());
    localu.field_albumMd5 = "";
    c(localu);
    AppMethodBeat.o(306644);
  }
  
  public final int mO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306648);
    paramString1 = aZW(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace(paramString1);
    AppMethodBeat.o(306648);
    return 0;
  }
  
  public final boolean mP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97480);
    paramString1 = aZW(paramString1);
    paramString1.field_newerIds = paramString2;
    boolean bool = super.replace(paramString1);
    AppMethodBeat.o(97480);
    return bool;
  }
  
  public final int s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97478);
    paramString1 = aZW(paramString1);
    paramString1.field_md5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(97478);
    return 0;
  }
  
  public final int t(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162060);
    paramString1 = aZW(paramString1);
    paramString1.field_albumMd5 = paramString2;
    paramString1.field_lastFirstPageRequestErrType = paramInt1;
    paramString1.field_lastFirstPageRequestErrCode = paramInt2;
    super.replace(paramString1);
    AppMethodBeat.o(162060);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */