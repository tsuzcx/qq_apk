package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ay
  extends MStorageEx
  implements bv
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private static String VED;
  private static String VEE;
  public final com.tencent.mm.b.f<String, as> VEA;
  public final com.tencent.mm.b.f<String, Integer> VEB;
  private a VEC;
  private ISQLiteDatabase VEz;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117060);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(as.info, "rcontact"), MAutoStorage.getCreateSQLs(as.info, "bottlecontact"), MAutoStorage.getCreateSQLs(at.info, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
    INDEX_CREATE = new String[] { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) ", "CREATE INDEX IF NOT EXISTS contact_usernameflag_index ON rcontact ( usernameFlag ) " };
    VED = "showHead = 32";
    VEE = "type & 64 !=0  AND type >= 64";
    AppMethodBeat.o(117060);
  }
  
  public ay(h paramh)
  {
    AppMethodBeat.i(116970);
    this.VEA = new c(200);
    this.VEB = new c(400);
    this.VEC = new a((byte)0);
    Object localObject = paramh.rawQuery("PRAGMA table_info( contact_ext )", null, 2);
    int n = ((Cursor)localObject).getColumnIndex("name");
    int j = 0;
    int i = 0;
    while ((((Cursor)localObject).moveToNext()) && ((i == 0) || (j == 0))) {
      if (n >= 0)
      {
        String str = ((Cursor)localObject).getString(n);
        if ("weiboNickname".equalsIgnoreCase(str)) {
          j = 1;
        } else if ("weiboFlag".equalsIgnoreCase(str)) {
          i = 1;
        }
      }
    }
    ((Cursor)localObject).close();
    if (i == 0) {
      paramh.execSQL("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
    }
    if (j == 0) {
      paramh.execSQL("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
    }
    localObject = paramh.rawQuery("PRAGMA table_info( rcontact )", null, 2);
    i = ((Cursor)localObject).getColumnIndex("name");
    do
    {
      if (!((Cursor)localObject).moveToNext()) {
        break;
      }
    } while ((i < 0) || (!"verifyFlag".equalsIgnoreCase(((Cursor)localObject).getString(i))));
    for (i = m;; i = 0)
    {
      ((Cursor)localObject).close();
      if (i == 0) {
        paramh.execSQL("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
      }
      localObject = MAutoStorage.getUpdateSQLs(com.tencent.mm.contact.d.info, "bottlecontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.execSQL("bottlecontact", (String)((Iterator)localObject).next());
      }
      localObject = MAutoStorage.getUpdateSQLs(com.tencent.mm.contact.d.info, "rcontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.execSQL("rcontact", (String)((Iterator)localObject).next());
      }
      localObject = INDEX_CREATE;
      j = localObject.length;
      i = k;
      while (i < j)
      {
        paramh.execSQL("rcontact", localObject[i]);
        i += 1;
      }
      this.db = paramh;
      this.VEz = paramh;
      AppMethodBeat.o(116970);
      return;
    }
  }
  
  private static String A(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117047);
    String str2 = bk(false, paramBoolean) + " AND " + VEE;
    String str1 = "";
    Object localObject = str1;
    if (paramList != null)
    {
      localObject = str1;
      if (paramList.size() > 0)
      {
        localObject = paramList.iterator();
        for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + " AND username != '" + str1 + "'") {
          str1 = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    paramList = str2 + (String)localObject;
    AppMethodBeat.o(117047);
    return paramList;
  }
  
  private static String K(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117034);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(117034);
      return "";
    }
    String str = " and (";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() != 0)
      {
        localObject = paramList.iterator();
        for (paramList = " and ("; ((Iterator)localObject).hasNext(); paramList = paramList + "username = '" + str + "' or ") {
          str = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    paramList = (String)localObject + "conRemark like '%" + paramString + "%' or ";
    paramList = paramList + "conRemarkPYFull like '%" + paramString + "%' or ";
    paramList = paramList + "conRemarkPYShort like '%" + paramString + "%' or ";
    paramList = paramList + "alias like '%" + paramString + "%' or ";
    paramList = paramList + "username like '%" + paramString + "%' or ";
    paramList = paramList + "nickname like '%" + paramString + "%' or ";
    paramList = paramList + "pyInitial like '%" + paramString + "%' or ";
    paramString = paramList + "quanPin like '%" + paramString + "%' )";
    AppMethodBeat.o(117034);
    return paramString;
  }
  
  private static String Z(String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(117035);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(117035);
      return "";
    }
    if (paramArrayOfString.length >= 950)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      {
        AppMethodBeat.o(117035);
        return "";
      }
      localObject = new StringBuilder("");
      if (i < paramArrayOfString.length)
      {
        if (i == paramArrayOfString.length - 1) {
          ((StringBuilder)localObject).append(" '" + paramArrayOfString[i].trim() + "' ");
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(" '" + paramArrayOfString[i].trim() + "' ,");
        }
      }
      paramArrayOfString = String.valueOf(" and " + "username in (" + ((StringBuilder)localObject).toString() + ") ");
      AppMethodBeat.o(117035);
      return paramArrayOfString;
    }
    Object localObject = " and (";
    i = 0;
    if (i < paramArrayOfString.length)
    {
      if (i <= 0) {
        break label298;
      }
      localObject = (String)localObject + " or ";
    }
    label298:
    for (;;)
    {
      localObject = (String)localObject + "username = '" + paramArrayOfString[i] + "' ";
      i += 1;
      break;
      paramArrayOfString = (String)localObject + " )";
      AppMethodBeat.o(117035);
      return paramArrayOfString;
    }
  }
  
  private static String a(String paramString1, List<String> paramList1, String paramString2, List<String> paramList2)
  {
    AppMethodBeat.i(116981);
    paramString1 = paramString1 + " and OpenIMWordingInfo.language='" + paramString2 + "' ";
    String str = paramString1 + hyy();
    paramString2 = "";
    paramString1 = paramString2;
    if (paramList2 != null)
    {
      paramString1 = paramString2;
      if (paramList2.size() > 0)
      {
        paramString2 = paramList2.iterator();
        paramString1 = "";
        if (paramString2.hasNext())
        {
          paramList2 = (String)paramString2.next();
          if (paramString1.equals("")) {}
          for (paramString1 = paramString1 + " and (";; paramString1 = paramString1 + " or ")
          {
            paramString1 = paramString1 + "openImAppid == '" + paramList2 + "'";
            break;
          }
        }
        paramString1 = paramString1 + " )";
      }
    }
    paramList2 = str + paramString1;
    paramString2 = "";
    paramString1 = paramString2;
    if (paramList1 != null)
    {
      paramString1 = paramString2;
      if (paramList1.size() > 0)
      {
        paramList1 = paramList1.iterator();
        for (paramString1 = ""; paramList1.hasNext(); paramString1 = paramString1 + " and username != '" + paramString2 + "'") {
          paramString2 = (String)paramList1.next();
        }
      }
    }
    paramString1 = paramList2 + paramString1;
    Log.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[] { paramString1 });
    AppMethodBeat.o(116981);
    return paramString1;
  }
  
  private static boolean ax(as paramas)
  {
    boolean bool = false;
    AppMethodBeat.i(117054);
    if (paramas == null)
    {
      AppMethodBeat.o(117054);
      return false;
    }
    int i = paramas.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paramas.field_username);
      AppMethodBeat.o(117054);
      return bool;
      bool = true;
    }
  }
  
  private static String bk(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(117040);
    String str2 = "type & " + com.tencent.mm.contact.d.axN() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + com.tencent.mm.contact.d.axX() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + com.tencent.mm.contact.d.axY() + "=0 ";
    str2 = str1 + " and type & " + com.tencent.mm.contact.d.axO() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + as.hya() + " =0 ";
    }
    AppMethodBeat.o(117040);
    return str1;
  }
  
  private static String bwa(String paramString)
  {
    AppMethodBeat.i(116968);
    if (as.PY(paramString))
    {
      paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "bottlecontact";
      AppMethodBeat.o(116968);
      return paramString;
    }
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "rcontact";
    AppMethodBeat.o(116968);
    return paramString;
  }
  
  private static String bwb(String paramString)
  {
    AppMethodBeat.i(116969);
    if (as.PY(paramString))
    {
      AppMethodBeat.o(116969);
      return "bottlecontact";
    }
    AppMethodBeat.o(116969);
    return "rcontact";
  }
  
  private as bwt(String paramString)
  {
    AppMethodBeat.i(117058);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    if (as.PY(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    as localas = new as();
    paramString = "select  *,rowid  from rcontact where username=" + h.Mi(paramString) + " or encryptUsername=" + h.Mi(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localas.convertFrom(paramString);
      paramString.close();
      localas.hyd();
      d(localas, false);
    }
    for (;;)
    {
      AppMethodBeat.o(117058);
      return localas;
      paramString.close();
    }
  }
  
  private as bwu(String paramString)
  {
    AppMethodBeat.i(188703);
    as localas = new as();
    paramString = bwa(paramString) + " where username=" + h.Mi(paramString) + " or encryptUsername=" + h.Mi(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localas.convertFrom(paramString);
      paramString.close();
      localas.hyd();
      d(localas, false);
    }
    for (;;)
    {
      AppMethodBeat.o(188703);
      return localas;
      paramString.close();
    }
  }
  
  private static String hyr()
  {
    AppMethodBeat.i(117037);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(117037);
    return localObject;
  }
  
  private static String hys()
  {
    AppMethodBeat.i(117039);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by case when verifyFlag & " + as.hya() + " != 0 then 0 else 1 end , showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(117039);
    return localObject;
  }
  
  private static String hyt()
  {
    AppMethodBeat.i(117041);
    String str = "type & " + com.tencent.mm.contact.d.axN() + " !=0 ";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.d.axY() + " =0 and ";
    str = str + "type & " + com.tencent.mm.contact.d.axO() + " =0";
    AppMethodBeat.o(117041);
    return str;
  }
  
  private static String hyu()
  {
    AppMethodBeat.i(117042);
    String str = "type & " + com.tencent.mm.contact.d.axN() + "!=0";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.d.axY() + "=0  ";
    AppMethodBeat.o(117042);
    return str;
  }
  
  private static String hyv()
  {
    AppMethodBeat.i(117043);
    String str = "type & " + com.tencent.mm.contact.d.axN() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.d.axO() + "=0" + ab.c("username", new String[] { "@chatroom", "@im.chatroom" }, new String[0]) + ")";
    AppMethodBeat.o(117043);
    return str;
  }
  
  private static String hyw()
  {
    AppMethodBeat.i(117044);
    String str = "type & " + com.tencent.mm.contact.d.axN() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.d.axO() + "=0" + ab.a("username", "@talkroom", new String[0]) + ")";
    AppMethodBeat.o(117044);
    return str;
  }
  
  private static String hyx()
  {
    AppMethodBeat.i(117045);
    String str = "type & " + com.tencent.mm.contact.d.axO() + "=0" + ab.a("username", "@openim", new String[0]);
    AppMethodBeat.o(117045);
    return str;
  }
  
  private static String hyy()
  {
    AppMethodBeat.i(117046);
    String str = hyu() + " and " + hyx();
    AppMethodBeat.o(117046);
    return str;
  }
  
  private static String jF(List<String> paramList)
  {
    AppMethodBeat.i(117013);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(117013);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append(" or username = '").append(str).append("'");
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(117013);
    return paramList;
  }
  
  private static String jG(List<String> paramList)
  {
    AppMethodBeat.i(117015);
    String str = jF(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    AppMethodBeat.o(117015);
    return paramList;
  }
  
  private static String jP(List<String> paramList)
  {
    AppMethodBeat.i(117048);
    Object localObject = bk(false, false) + " AND " + VEE;
    String str2 = (String)localObject + ab.a("username", "@openim", true, new String[0]);
    String str1 = "";
    localObject = str1;
    if (paramList != null)
    {
      localObject = str1;
      if (paramList.size() > 0)
      {
        localObject = paramList.iterator();
        for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + " AND username != '" + str1 + "'") {
          str1 = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    paramList = str2 + (String)localObject;
    AppMethodBeat.o(117048);
    return paramList;
  }
  
  public final int G(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    AppMethodBeat.i(116999);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(116999);
      return -1;
    }
    at localat = new at();
    localat.field_cmdbuf = paramArrayOfByte;
    localat.field_username = paramString;
    int j = (int)this.db.replace("ContactCmdBuf", "username", localat.convertTo());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      Log.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(116999);
      return j;
      i = paramArrayOfByte.length;
    }
  }
  
  public final as RG(String paramString)
  {
    AppMethodBeat.i(292434);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(292434);
      return null;
    }
    String str = paramString;
    if (as.PY(paramString)) {
      str = as.bvW(paramString);
    }
    paramString = bwc(str);
    if (paramString != null)
    {
      Log.d("MicroMsg.ContactStorage", "[get]getFromCache:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
      AppMethodBeat.o(292434);
      return paramString;
    }
    paramString = this.VEC.RG(str);
    if (paramString != null)
    {
      Log.i("MicroMsg.ContactStorage", "[get]extensions:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
      d(paramString, false);
      AppMethodBeat.o(292434);
      return paramString;
    }
    paramString = bwu(str);
    Log.i("MicroMsg.ContactStorage", "[get]getRaw:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
    AppMethodBeat.o(292434);
    return paramString;
  }
  
  public final as UT(long paramLong)
  {
    as localas = null;
    AppMethodBeat.i(116992);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(116992);
      return null;
    }
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where rowid=".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localas = new as();
      localas.convertFrom((Cursor)localObject);
      d(localas, false);
    }
    ((Cursor)localObject).close();
    if (localas != null) {
      localas.hyd();
    }
    AppMethodBeat.o(116992);
    return localas;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116979);
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + g(paramString1, paramString2, paramList1) + jF(paramList2) + hyr();
    Log.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + A(paramList1, paramBoolean2) + hys();
      Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.rawQuery(paramString2, null, 4);
      paramString1 = this.db.rawQuery(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116979);
        return paramString1;
      }
      paramString1 = com.tencent.mm.storagebase.d.hBM();
      AppMethodBeat.o(116979);
      return paramString1;
    }
    paramString1 = this.db.rawQuery(paramString1, null, 4);
    AppMethodBeat.o(116979);
    return paramString1;
  }
  
  public final Cursor a(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(116982);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    paramList1 = this.db.rawQuery(paramList1, null, 4);
    AppMethodBeat.o(116982);
    return paramList1;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(117033);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = com.tencent.mm.storagebase.d.hBM();
      AppMethodBeat.o(117033);
      return paramArrayOfString;
    }
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + g(paramString1, paramString2, paramList2) + Z(paramArrayOfString) + K(paramString2, paramList1) + hyr();
    Log.i("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(117033);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117032);
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + g(paramString, null, paramList) + Z(paramArrayOfString);
    paramList = paramString;
    if (paramArrayOfString != null)
    {
      paramList = paramString;
      if (paramArrayOfString.length > 0)
      {
        paramString = paramString + " order by 1=1 ";
        int j = paramArrayOfString.length;
        int i = 0;
        for (;;)
        {
          paramList = paramString;
          if (i >= j) {
            break;
          }
          paramList = paramArrayOfString[i];
          paramString = paramString + ",username='" + paramList + "' desc";
          i += 1;
        }
      }
    }
    Log.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(paramList)));
    paramArrayOfString = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117032);
    return paramArrayOfString;
  }
  
  public final void a(bv.a parama)
  {
    AppMethodBeat.i(188541);
    this.VEC.QWB.put(parama, new Object());
    AppMethodBeat.o(188541);
  }
  
  public final void aHy(String paramString)
  {
    AppMethodBeat.i(116975);
    if (!Util.isNullOrNil(paramString))
    {
      this.VEA.remove(paramString);
      this.VEB.remove(paramString);
      Log.d("MicroMsg.ContactStorage", "removeFromCache(%s) username：%s", new Object[] { this.VEA, paramString });
    }
    AppMethodBeat.o(116975);
  }
  
  public final void as(as paramas)
  {
    AppMethodBeat.i(116974);
    d(paramas, false);
    AppMethodBeat.o(116974);
  }
  
  public final boolean at(as paramas)
  {
    AppMethodBeat.i(116977);
    if (bwl(paramas.field_username))
    {
      if (c(paramas.field_username, paramas) == 0)
      {
        AppMethodBeat.o(116977);
        return true;
      }
      AppMethodBeat.o(116977);
      return false;
    }
    if (aw(paramas) >= 0)
    {
      AppMethodBeat.o(116977);
      return true;
    }
    AppMethodBeat.o(116977);
    return false;
  }
  
  public final boolean au(as paramas)
  {
    AppMethodBeat.i(116996);
    if (paramas != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue("contact NULL !", bool1);
      if (ax(paramas)) {
        break;
      }
      AppMethodBeat.o(116996);
      return true;
    }
    paramas.pq(paramas.axh());
    this.VEC.a(this, paramas);
    if (this.VEC.b(paramas, false) > 0)
    {
      bool1 = true;
      Log.i("MicroMsg.ContactStorage", "[replace] ret:%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Boolean.valueOf(bool1), paramas.field_username, Integer.valueOf(paramas.field_showHead), Integer.valueOf(paramas.field_verifyFlag) });
      bool2 = bool1;
      if (!bool1)
      {
        ContentValues localContentValues = paramas.convertTo();
        if ((int)paramas.jxt > 0) {
          localContentValues.put("rowid", Integer.valueOf((int)paramas.jxt));
        }
        if (this.db.replace(bwb(paramas.field_username), com.tencent.mm.contact.d.info.primaryKey, localContentValues) <= 0L) {
          break label227;
        }
      }
    }
    label227:
    for (boolean bool2 = true;; bool2 = false)
    {
      aHy(paramas.field_username);
      if (!Util.isNullOrNil(paramas.field_encryptUsername)) {
        aHy(paramas.field_encryptUsername);
      }
      if (bool2) {
        break label232;
      }
      AppMethodBeat.o(116996);
      return false;
      bool1 = false;
      break;
    }
    label232:
    doNotify(4, this, paramas.field_username, paramas);
    AppMethodBeat.o(116996);
    return true;
  }
  
  public final boolean av(as paramas)
  {
    AppMethodBeat.i(116997);
    if (aw(paramas) > 0)
    {
      AppMethodBeat.o(116997);
      return true;
    }
    AppMethodBeat.o(116997);
    return false;
  }
  
  public final int aw(as paramas)
  {
    AppMethodBeat.i(116998);
    if (Util.nullAsNil(paramas.field_username).length() <= 0)
    {
      Log.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      AppMethodBeat.o(116998);
      return -1;
    }
    paramas.pq(paramas.axh());
    this.VEC.a(this, paramas);
    int j = this.VEC.b(paramas, false);
    Log.i("MicroMsg.ContactStorage", "extensions replace=%s %s", new Object[] { Integer.valueOf(j), paramas.field_username });
    int i = j;
    if (j < 0)
    {
      Object localObject = paramas.convertTo();
      long l = System.currentTimeMillis();
      int k = (int)this.db.insert(bwb(paramas.field_username), com.tencent.mm.contact.d.info.primaryKey, (ContentValues)localObject);
      int m = (int)Util.milliSecondsToNow(l);
      boolean bool = CrashReportFactory.foreground;
      localObject = com.tencent.mm.plugin.report.f.Iyx;
      if (bool)
      {
        i = 11;
        if (!bool) {
          break label291;
        }
      }
      label291:
      for (j = 12;; j = 15)
      {
        ((com.tencent.mm.plugin.report.f)localObject).c(463, i, j, m, false);
        Log.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paramas.field_username, Integer.valueOf(paramas.field_showHead), Integer.valueOf(paramas.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        if (k == -1) {
          break label297;
        }
        paramas.jxt = k;
        d(paramas, false);
        doNotify(2, this, paramas.field_username, paramas);
        AppMethodBeat.o(116998);
        return k;
        i = 14;
        break;
      }
      label297:
      Log.e("MicroMsg.ContactStorage", "insert failed: username=%s", new Object[] { paramas.field_username });
      i = k;
    }
    AppMethodBeat.o(116998);
    return i;
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116988);
    paramString1 = "select username from rcontact " + g(paramString1, paramString2, paramList1) + jF(paramList2) + hyr();
    Log.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + A(paramList1, paramBoolean2) + hys();
      Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.rawQuery(paramString2, null, 4);
      paramString1 = this.db.rawQuery(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116988);
        return paramString1;
      }
      paramString1 = com.tencent.mm.storagebase.d.hBM();
      AppMethodBeat.o(116988);
      return paramString1;
    }
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(116988);
    return paramString1;
  }
  
  public final Cursor b(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(116983);
    paramList1 = a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    Log.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.rawQuery(paramList1, null, 4);
    AppMethodBeat.o(116983);
    return paramList1;
  }
  
  public final void b(bv.a parama)
  {
    AppMethodBeat.i(116972);
    this.VEC.QWB.remove(parama);
    AppMethodBeat.o(116972);
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(117026);
    paramString1 = "select distinct showHead from rcontact " + g(paramString1, paramString2, paramList) + Z(paramArrayOfString) + hyr();
    long l = System.currentTimeMillis();
    paramString1 = this.db.rawQuery(paramString1, null);
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - l));
      paramString2 = new int[i];
      if (paramString1.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramString1.moveToPosition(j);
        paramString2[j] = paramString1.getInt(0);
        j += 1;
      }
    }
    paramString1.close();
    AppMethodBeat.o(117026);
    return paramString2;
  }
  
  public final int[] b(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(188627);
    paramArrayOfString = "select distinct showHead from rcontact " + g(paramString1, paramString2, paramList) + Z(paramArrayOfString) + bwq(paramString3) + hyr();
    long l = System.currentTimeMillis();
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramArrayOfString.getCount() >= 0) {}
    for (int i = paramArrayOfString.getCount();; i = 0)
    {
      Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
      paramString1 = new int[i];
      if (paramArrayOfString.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramArrayOfString.moveToPosition(j);
        paramString1[j] = paramArrayOfString.getInt(0);
        j += 1;
      }
    }
    paramArrayOfString.close();
    AppMethodBeat.o(188627);
    return paramString1;
  }
  
  public final String biT()
  {
    AppMethodBeat.i(292896);
    String str = hyr();
    AppMethodBeat.o(292896);
    return str;
  }
  
  public final as bwc(String paramString)
  {
    AppMethodBeat.i(116973);
    paramString = (as)this.VEA.aX(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(116973);
      return paramString;
    }
    AppMethodBeat.o(116973);
    return null;
  }
  
  public final boolean bwd(String paramString)
  {
    AppMethodBeat.i(116976);
    if ((Util.isNullOrNil(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger"))))
    {
      AppMethodBeat.o(116976);
      return false;
    }
    Object localObject = (Integer)this.VEB.get(paramString);
    if (localObject != null)
    {
      bool = com.tencent.mm.contact.d.rk(((Integer)localObject).intValue());
      AppMethodBeat.o(116976);
      return bool;
    }
    localObject = RG(paramString);
    if ((localObject == null) || ((!((ax)localObject).field_username.equals(paramString)) && (!paramString.equals(((ax)localObject).field_encryptUsername))))
    {
      this.VEB.q(paramString, Integer.valueOf(0));
      AppMethodBeat.o(116976);
      return false;
    }
    this.VEB.q(paramString, Integer.valueOf(((ax)localObject).field_type));
    boolean bool = com.tencent.mm.contact.d.rk(((ax)localObject).field_type);
    AppMethodBeat.o(116976);
    return bool;
  }
  
  public final as bwe(String paramString)
  {
    AppMethodBeat.i(116978);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116978);
      return null;
    }
    as localas = this.VEC.RG(paramString);
    if (localas != null)
    {
      d(localas, false);
      AppMethodBeat.o(116978);
      return localas;
    }
    localas = new as();
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where alias=" + h.Mi(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localas.convertFrom(paramString);
      d(localas, false);
    }
    paramString.close();
    localas.hyd();
    AppMethodBeat.o(116978);
    return localas;
  }
  
  public final Cursor bwf(String paramString)
  {
    AppMethodBeat.i(116985);
    paramString = this.db.rawQuery(paramString, null, 4);
    AppMethodBeat.o(116985);
    return paramString;
  }
  
  public final as bwg(String paramString)
  {
    AppMethodBeat.i(116989);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116989);
      return null;
    }
    Object localObject = paramString;
    if (as.PY(paramString)) {
      localObject = as.bvW(paramString);
    }
    paramString = bwc((String)localObject);
    if (paramString != null)
    {
      paramString.hyd();
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = this.VEC.RG((String)localObject);
    if (paramString != null)
    {
      d(paramString, false);
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = new as();
    localObject = bwa((String)localObject) + " where username=" + h.Mi((String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      d(paramString, false);
    }
    ((Cursor)localObject).close();
    paramString.hyd();
    AppMethodBeat.o(116989);
    return paramString;
  }
  
  public final as bwh(String paramString)
  {
    AppMethodBeat.i(116990);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116990);
      return null;
    }
    Object localObject = paramString;
    if (as.PY(paramString)) {
      localObject = as.bvW(paramString);
    }
    paramString = bwc((String)localObject);
    if (paramString != null)
    {
      AppMethodBeat.o(116990);
      return paramString;
    }
    paramString = new as();
    localObject = bwa((String)localObject) + " where username=" + h.Mi((String)localObject) + " or encryptUsername=" + h.Mi((String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      d(paramString, false);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116990);
    return paramString;
  }
  
  public final as bwj(String paramString)
  {
    AppMethodBeat.i(188573);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188573);
      return null;
    }
    Object localObject = paramString;
    if (as.PY(paramString)) {
      localObject = as.bvW(paramString);
    }
    paramString = new as();
    localObject = bwa((String)localObject) + " where username=" + h.Mi((String)localObject) + " or encryptUsername=" + h.Mi((String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      paramString.hyd();
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(188573);
    return paramString;
  }
  
  public final long bwk(String paramString)
  {
    AppMethodBeat.i(116993);
    long l2 = -1L;
    paramString = RG(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.jxt > 0L) {
        l1 = (int)paramString.jxt;
      }
    }
    AppMethodBeat.o(116993);
    return l1;
  }
  
  public final boolean bwl(String paramString)
  {
    AppMethodBeat.i(116994);
    as localas = RG(paramString);
    if ((localas != null) && (!Util.isNullOrNil(localas.field_username)) && (localas.field_username.equals(paramString)))
    {
      AppMethodBeat.o(116994);
      return true;
    }
    AppMethodBeat.o(116994);
    return false;
  }
  
  public final boolean bwm(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(116995);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116995);
      return false;
    }
    paramString = "select count(*) from " + bwb(paramString) + " where type & " + com.tencent.mm.contact.d.axO() + " !=0 and username=" + h.Mi(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    boolean bool1 = bool2;
    if (paramString.moveToFirst())
    {
      bool1 = bool2;
      if (paramString.getInt(0) > 0) {
        bool1 = true;
      }
    }
    paramString.close();
    AppMethodBeat.o(116995);
    return bool1;
  }
  
  public final byte[] bwn(String paramString)
  {
    AppMethodBeat.i(117000);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(117000);
      return null;
    }
    at localat = new at();
    Cursor localCursor = this.db.query("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localat.convertFrom(localCursor);
    }
    localCursor.close();
    if (localat.field_cmdbuf == null) {}
    for (int i = -1;; i = localat.field_cmdbuf.length)
    {
      Log.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      paramString = localat.field_cmdbuf;
      AppMethodBeat.o(117000);
      return paramString;
    }
  }
  
  public final int bwo(String paramString)
  {
    AppMethodBeat.i(117001);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
      AppMethodBeat.o(117001);
      return -1;
    }
    int i = this.db.delete("ContactCmdBuf", "username=?", new String[] { String.valueOf(paramString) });
    Log.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(117001);
    return i;
  }
  
  public final int bwp(String paramString)
  {
    AppMethodBeat.i(117002);
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (as.PY(paramString)) {
        str = as.bvW(paramString);
      }
      aHy(str);
      paramString = new as(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + Util.nowMilliSecond());
      paramString.Iy("fake_" + Util.nowMilliSecond());
      paramString.setSource(0);
      i = this.db.update(bwb(str), paramString.convertTo(), "username=?", new String[] { String.valueOf(str) });
      bwo(str);
      Log.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[] { str, Integer.valueOf(i), Util.getStack() });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(117002);
      return i;
    }
    doNotify(5, this, str, paramString);
    AppMethodBeat.o(117002);
    return i;
  }
  
  public final String bwq(String paramString)
  {
    AppMethodBeat.i(117036);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(117036);
      return "";
    }
    String str = " and (" + "conRemark like '%" + paramString + "%' or ";
    str = str + "conRemarkPYFull like '%" + paramString + "%' or ";
    str = str + "conRemarkPYShort like '%" + paramString + "%' or ";
    str = str + "alias like '%" + paramString + "%' or ";
    str = str + "username like '%" + paramString + "%' or ";
    str = str + "nickname like '%" + paramString + "%' or ";
    str = str + "pyInitial like '%" + paramString + "%' or ";
    paramString = str + "quanPin like '%" + paramString + "%' )";
    AppMethodBeat.o(117036);
    return paramString;
  }
  
  public final int bwr(String paramString)
  {
    AppMethodBeat.i(188681);
    long l = System.currentTimeMillis();
    paramString = "select count(username) from rcontact" + g(paramString, null, null) + bwq(null);
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    int i;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      i = localCursor.getInt(0);
      localCursor.close();
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactStorage", "getCountByFilterType, sql:%s, count:%d, time:%d", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(188681);
      return i;
      i = 0;
    }
  }
  
  public final String bws(String paramString)
  {
    AppMethodBeat.i(117057);
    as localas = bwt(paramString);
    if (localas != null)
    {
      Log.i("MicroMsg.ContactStorage", "getSendMsgTicket %s %s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(Util.nullAs(localas.field_ticket, "").length()) });
      paramString = localas.field_ticket;
      AppMethodBeat.o(117057);
      return paramString;
    }
    Log.e("MicroMsg.ContactStorage", "getSendMsgTicket ca == null");
    AppMethodBeat.o(117057);
    return "";
  }
  
  public final int c(String paramString, as paramas)
  {
    AppMethodBeat.i(117003);
    Log.i("MicroMsg.ContactStorage", "begin to update contact :%s, usernameFlag=%d", new Object[] { paramString, Long.valueOf(paramas.field_usernameFlag) });
    if (!ax(paramas))
    {
      AppMethodBeat.o(117003);
      return 1;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (as.PY(paramString)) {
      str = as.bvW(paramString);
    }
    paramas.pq(paramas.axh());
    paramas.Fa(ar.bvF(paramas.field_username));
    this.VEC.a(this, paramas);
    int j = this.VEC.b(paramas, true);
    int i = j;
    if (j < 0)
    {
      paramString = paramas.convertTo();
      if ((int)paramas.jxt > 0) {
        paramString.put("rowid", Integer.valueOf((int)paramas.jxt));
      }
      i = j;
      if (paramString.size() > 0) {
        i = this.db.update(bwb(str), paramString, "username=?", new String[] { String.valueOf(str) });
      }
    }
    Log.i("MicroMsg.ContactStorage", "[update] ret=%s username=%s, showHead=%d, verifyFlag=%d, usernameFlag=%d, take[%d]ms", new Object[] { Integer.valueOf(i), paramas.field_username, Integer.valueOf(paramas.field_showHead), Integer.valueOf(paramas.field_verifyFlag), Long.valueOf(paramas.field_usernameFlag), Long.valueOf(System.currentTimeMillis() - l) });
    aHy(str);
    if (!Util.isNullOrNil(paramas.field_encryptUsername)) {
      aHy(paramas.field_encryptUsername);
    }
    if (i != 0) {
      doNotify(4, this, paramas.field_username, paramas);
    }
    AppMethodBeat.o(117003);
    return i;
  }
  
  public final int c(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(117050);
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axN()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axY()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axO()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8 = 0 ");
    localStringBuilder.append(ab.a("username", "@micromsg.qq.com", new String[0]));
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      int j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        String str = paramArrayOfString1[i];
        if (!"weixin".equals(str)) {
          localStringBuilder.append(" and rcontact.username != '").append(str).append("'");
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < 4)
    {
      paramArrayOfString1 = paramVarArgs[i];
      if (!"weixin".equals(paramArrayOfString1)) {
        localStringBuilder.append(" and rcontact.username != '").append(paramArrayOfString1).append("'");
      }
      i += 1;
    }
    localStringBuilder.append(" or username = 'weixin'");
    paramArrayOfString1 = localStringBuilder.toString();
    paramVarArgs = this.db.rawQuery(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d, time:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(117050);
      return i;
      i = 0;
    }
  }
  
  public final Cursor c(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(116984);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    Log.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.rawQuery(paramList1, null, 4);
    AppMethodBeat.o(116984);
    return paramList1;
  }
  
  public final int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(117031);
    paramString1 = "select count(*) from rcontact " + g(paramString1, paramString2, paramList) + Z(paramArrayOfString);
    paramString1 = paramString1 + " group by showHead";
    paramArrayOfString = this.db.rawQuery(paramString1, null);
    paramString1 = localObject;
    if (paramArrayOfString.getCount() > 0)
    {
      int j = paramArrayOfString.getCount();
      paramString2 = new int[j];
      int i = 0;
      for (;;)
      {
        paramString1 = paramString2;
        if (i >= j) {
          break;
        }
        paramArrayOfString.moveToPosition(i);
        paramString2[i] = paramArrayOfString.getInt(0);
        i += 1;
      }
    }
    paramArrayOfString.close();
    AppMethodBeat.o(117031);
    return paramString1;
  }
  
  public final int[] c(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(188629);
    long l = System.currentTimeMillis();
    paramArrayOfString = "select count(*) from rcontact " + g(paramString1, paramString2, paramList) + Z(paramArrayOfString) + bwq(paramString3);
    paramArrayOfString = paramArrayOfString + " group by showHead";
    paramString2 = this.db.rawQuery(paramArrayOfString, null);
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = paramString2.getCount();
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
    paramArrayOfString = null;
    if (j > 0)
    {
      paramString1 = new int[j];
      int i = 0;
      for (;;)
      {
        paramArrayOfString = paramString1;
        if (i >= j) {
          break;
        }
        paramString2.moveToPosition(i);
        paramString1[i] = paramString2.getInt(0);
        i += 1;
      }
    }
    paramString2.close();
    AppMethodBeat.o(188629);
    return paramArrayOfString;
  }
  
  public final int cl(String paramString, long paramLong)
  {
    AppMethodBeat.i(169111);
    Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { Util.nullAs(paramString, ""), Long.valueOf(paramLong) });
    as localas = bwg(paramString);
    if (localas != null)
    {
      if (Util.isEqual(localas.hDC, paramLong))
      {
        AppMethodBeat.o(169111);
        return 0;
      }
      localas.Ez(paramLong);
      int i = c(paramString, localas);
      AppMethodBeat.o(169111);
      return i;
    }
    AppMethodBeat.o(169111);
    return 0;
  }
  
  public final int d(String paramString, as paramas)
  {
    AppMethodBeat.i(117004);
    if ((Util.isNullOrNil(paramString)) || (paramas == null) || (Util.isNullOrNil(paramas.field_username)))
    {
      Log.e("MicroMsg.ContactStorage", "update : wrong input!");
      AppMethodBeat.o(117004);
      return 0;
    }
    Log.i("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paramas.field_username + " enUsername: " + paramString);
    if (!ax(paramas))
    {
      AppMethodBeat.o(117004);
      return 1;
    }
    if (as.PY(paramas.field_username)) {
      paramas.setUsername(as.bvW(paramas.field_username));
    }
    paramas.pq(paramas.axh());
    paramas.Fa(ar.bvF(paramas.field_username));
    this.VEC.a(this, paramas);
    boolean bool;
    ContentValues localContentValues;
    as localas;
    int i;
    if (this.VEC.b(paramas, true) > 0)
    {
      bool = true;
      Log.i("MicroMsg.ContactStorage", "[update] ret=%s oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d type:%s", new Object[] { Boolean.valueOf(bool), paramString, paramas.field_username, Integer.valueOf(paramas.field_showHead), Integer.valueOf(paramas.field_verifyFlag), Integer.valueOf(paramas.field_type) });
      localContentValues = paramas.convertTo();
      if ((bool) || (paramas.jxt > 0L)) {
        break label509;
      }
      localas = new as(paramString);
      localas.setType(0);
      localas.setUsername("fake_" + Util.nowMilliSecond());
      localas.Iy("fake_" + Util.nowMilliSecond());
      i = this.db.update(bwb(paramString), localas.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
      Log.i("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + bwb(paramString) + " user :" + paramString + ", res:" + i);
      if (localContentValues.size() <= 0) {
        break label819;
      }
      i = (int)this.db.replace(bwb(paramas.field_username), com.tencent.mm.contact.d.info.primaryKey, localContentValues);
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactStorage", "updateEncryptUser values:%s, result1:%s", new Object[] { Integer.valueOf(localContentValues.size()), Integer.valueOf(i) });
      aHy(paramas.field_username);
      if (!Util.isNullOrNil(paramas.field_encryptUsername)) {
        aHy(paramas.field_encryptUsername);
      }
      doNotify(3, this, paramString, paramas);
      doNotify(3, this, paramas.field_username, paramas);
      AppMethodBeat.o(117004);
      return i;
      bool = false;
      break;
      label509:
      if (!bool) {
        if (paramString.equals(paramas.field_username))
        {
          if (localContentValues.size() > 0)
          {
            i = this.db.update(bwb(paramas.field_username), localContentValues, "rowid=?", new String[] { paramas.jxt });
            Log.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paramas.field_username, Integer.valueOf(i), Long.valueOf(paramas.jxt) });
          }
        }
        else
        {
          localas = new as(paramString);
          localas.setType(0);
          localas.setUsername("fake_" + Util.nowMilliSecond());
          localas.Iy("fake_" + Util.nowMilliSecond());
          i = this.db.update(bwb(paramString), localas.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
          Log.i("MicroMsg.ContactStorage", "delete " + bwb(paramString) + " user :" + paramString + ", res:" + i);
          if (localContentValues.size() > 0)
          {
            i = this.db.update(bwb(paramas.field_username), localContentValues, "rowid=?", new String[] { paramas.jxt });
            continue;
          }
        }
      }
      label819:
      i = 0;
    }
  }
  
  public final int d(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(117051);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axN()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axY()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.axO()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8 = 0");
    localStringBuilder.append(ab.c("username", new String[] { "@chatroom", "@im.chatroom" }, new String[0]));
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      int j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        String str = paramArrayOfString1[i];
        localStringBuilder.append(" and rcontact.username != '").append(str).append("'");
        i += 1;
      }
    }
    int i = 0;
    while (i < 4)
    {
      paramArrayOfString1 = paramVarArgs[i];
      localStringBuilder.append(" and rcontact.username != '").append(paramArrayOfString1).append("'");
      i += 1;
    }
    paramArrayOfString1 = localStringBuilder.toString();
    paramVarArgs = this.db.rawQuery(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      Log.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      AppMethodBeat.o(117051);
      return i;
      i = 0;
    }
  }
  
  public final Cursor d(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117014);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + g(paramString1, paramString2, paramList) + jF(null) + hyr();
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117014);
    return paramString1;
  }
  
  public final Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(188652);
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + g(paramString2, paramString3, paramList) + Z(paramArrayOfString) + bwq(paramString1) + hyr();
    Log.v("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(188652);
    return paramArrayOfString;
  }
  
  public final void d(as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(188551);
    if ((paramas == null) || (paramas.field_username == null) || ((paramas.field_type == 0) && (!paramBoolean)))
    {
      AppMethodBeat.o(188551);
      return;
    }
    this.VEA.q(paramas.field_username, paramas);
    this.VEB.q(paramas.field_username, Integer.valueOf(paramas.field_type));
    Log.d("MicroMsg.ContactStorage", "updateToCache(%s) username：%s %s", new Object[] { this.VEA, paramas.field_username, Util.getStack() });
    AppMethodBeat.o(188551);
  }
  
  public final Cursor e(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117022);
    paramString1 = d(paramString1, paramString2, paramList);
    AppMethodBeat.o(117022);
    return paramString1;
  }
  
  public final void e(String paramString, as paramas)
  {
    AppMethodBeat.i(117005);
    if (paramString == null)
    {
      AppMethodBeat.o(117005);
      return;
    }
    String str = paramString;
    if (as.PY(paramString)) {
      str = as.bvW(paramString);
    }
    paramas.pq(paramas.axh());
    paramas.Fa(ar.bvF(paramas.field_username));
    if (ab.p(paramas))
    {
      paramas.pq(43);
      paramas.It(com.tencent.mm.platformtools.f.ZK(paramas.ayr()));
      paramas.Iu(com.tencent.mm.platformtools.f.ZJ(paramas.ayr()));
      paramas.Iw(com.tencent.mm.platformtools.f.ZJ(paramas.ays()));
      paramas.Ix(paramas.ays());
      AppMethodBeat.o(117005);
      return;
    }
    if (ab.QL(paramas.field_username))
    {
      Log.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
      paramas.pq(31);
    }
    this.VEC.a(this, paramas);
    int i = this.VEC.b(paramas, true);
    Log.i("MicroMsg.ContactStorage", "ret=%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Integer.valueOf(i), paramas.field_username, Integer.valueOf(paramas.field_showHead), Integer.valueOf(paramas.field_verifyFlag) });
    if (i > 0)
    {
      AppMethodBeat.o(117005);
      return;
    }
    paramString = paramas.convertTo();
    if ((int)paramas.jxt > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramas.jxt));
    }
    if (paramString.size() > 0) {
      this.db.update(bwb(str), paramString, "username=?", new String[] { String.valueOf(str) });
    }
    AppMethodBeat.o(117005);
  }
  
  public final Cursor f(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117023);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + g(paramString1, paramString2, paramList) + hyr();
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117023);
    return paramString1;
  }
  
  public final String g(String paramString1, String paramString2, List<String> paramList)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(117049);
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + bk(true, false);
    }
    for (;;)
    {
      String str1 = "";
      paramString2 = str1;
      if (paramList == null) {
        break;
      }
      paramString2 = str1;
      if (paramList.size() <= 0) {
        break;
      }
      paramList = paramList.iterator();
      for (paramString2 = ""; paramList.hasNext(); paramString2 = paramString2 + " and username != '" + str1 + "'") {
        str1 = (String)paramList.next();
      }
      if (paramString1.equals("@all.contact.android"))
      {
        paramString1 = "" + hyu();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = new StringBuilder().append("");
        paramString2 = "(type & " + com.tencent.mm.contact.d.axN() + "!=0" + ab.c("username", new String[] { "@chatroom", "@im.chatroom" }, new String[0]) + ")";
        paramString2 = " where (" + paramString2 + ") and ";
        paramString1 = new StringBuilder().append(paramString2).append("type & ").append(com.tencent.mm.contact.d.axY()).append("=0 ").toString();
      }
      else
      {
        if (paramString1.equals("@all.contact.without.chatroom"))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = bk(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (bool1 = true;; bool1 = false)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + hyw() + ')' + " or (" + hyx() + ")";
            paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1 })).toString();
            break;
          }
        }
        if ((paramString1.equals("@all.contact.without.chatroom.without.openim")) || (paramString1.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = bk(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (bool1 = true;; bool1 = false)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + hyw() + ')';
            paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1 })).toString();
            break;
          }
        }
        if (paramString1.equals("@black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.d.axO()).append("!=0 and type >= ").append(com.tencent.mm.contact.d.axO()).toString();
        }
        else if (paramString1.equals("@werun.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.d.axP()).append("!=0").toString();
        }
        else if (paramString1.equals("@tophistory.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.d.axQ()).append("!=0").toString();
        }
        else if (paramString1.equals("@tophistory.unlike.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.d.axR()).append("!=0").toString();
        }
        else if (paramString1.equals("@social.black.android"))
        {
          paramString1 = "" + new StringBuilder().append(hyu()).append(" and type & ").append(com.tencent.mm.contact.d.axS()).append("!=0").toString();
        }
        else if (paramString1.equals("@sns.black.android"))
        {
          paramString1 = "" + new StringBuilder().append(hyu()).append(" and type & ").append(com.tencent.mm.contact.d.axT()).append("!=0").toString();
        }
        else if (paramString1.equals("@sns.unlike.android"))
        {
          paramString1 = "" + new StringBuilder().append(hyu()).append(" and type & ").append(com.tencent.mm.contact.d.axU()).append("!=0").toString();
        }
        else if (paramString1.equals("@finder.block.his.liked.android"))
        {
          paramString1 = "" + new StringBuilder().append(hyu()).append(" and type & ").append(com.tencent.mm.contact.d.axV()).append("!=0").toString();
        }
        else if (paramString1.equals("@finder.block.my.liked.android"))
        {
          paramString1 = "" + new StringBuilder().append(hyu()).append(" and type & ").append(com.tencent.mm.contact.d.axW()).append("!=0").toString();
        }
        else if (paramString1.equals("@t.qq.com"))
        {
          paramString1 = "" + new StringBuilder(" where username like '%").append("@t.qq.com").append("'").toString();
        }
        else
        {
          if (paramString1.equals("@domain.android"))
          {
            paramString1 = new StringBuilder().append("");
            str1 = bk(true, false);
            if ((str1 != null) && (str1.length() > 0)) {}
            for (;;)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(str1).append(" and domainList like '%").append(paramString2).append("%'").toString();
              break;
              bool1 = false;
            }
          }
          if (paramString1.equals("@micromsg.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = bk(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = true;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + hyv() + ')';
              String str2 = " or (" + hyw() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1, str2 })).toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.d.axN() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + com.tencent.mm.contact.d.axY() + " =0 and ";
            paramString2 = paramString2 + "type & " + com.tencent.mm.contact.d.axO() + " =0 and ";
            paramString2 = paramString2 + "verifyFlag & " + as.hya() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = true;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + hyv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1 })).toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = hyt();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = true;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + hyv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1 })).toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com.openim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = hyt();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = true;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + hyv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@micromsg.qq.com", new String[] { str1, " or ((username like '%@openim'))" })).toString();
              break;
            }
          }
          if (paramString1.equals("@qqim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = bk(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(paramString2).append(ab.a("username", "@qqim", new String[0])).toString();
              break;
            }
          }
          if (paramString1.equals("@all.chatroom"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.d.axN() + " !=0";
            paramString2 = paramString2 + " or type & 2 !=0";
            paramString2 = paramString2 + " or type & 4 !=0";
            paramString2 = paramString2 + " or 1";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@verify.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.d.axN() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + as.hxZ() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@biz.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.d.axN() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + as.hya() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@all.weixin.android"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.d.axN() + " != 0 or  (username not like '%@qqim' and username not like '%@qr" + "' and username not like '%@bottle' and username not like '%@fb" + "' and username not like '%@google' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@openim.contact"))
          {
            paramString1 = "" + hyy();
          }
          else
          {
            Log.d("MicroMsg.ContactStorage", "unknow role type");
            paramString1 = "" + bk(false, false);
          }
        }
      }
    }
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(117049);
    return paramString1;
  }
  
  public final Cursor hyA()
  {
    AppMethodBeat.i(117052);
    Cursor localCursor = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where rowid = -1", null);
    AppMethodBeat.o(117052);
    return localCursor;
  }
  
  public final Cursor hyB()
  {
    AppMethodBeat.i(117055);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axN()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axY()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axO()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0");
    ((StringBuilder)localObject).append(ab.a("username", "@micromsg.qq.com", new String[0]));
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    Log.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[] { localObject });
    AppMethodBeat.o(117055);
    return localCursor;
  }
  
  public final Cursor hyC()
  {
    AppMethodBeat.i(117056);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axN()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axY()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axO()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0");
    ((StringBuilder)localObject).append(ab.a("username", "@micromsg.qq.com", new String[0]));
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    Log.d("MicroMsg.ContactStorage", "get friend cursor, sql is %s", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null, 2);
    AppMethodBeat.o(117056);
    return localObject;
  }
  
  public final Cursor hyD()
  {
    AppMethodBeat.i(188705);
    Log.v("MicroMsg.ContactStorage", "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ");
    Cursor localCursor = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ", null);
    AppMethodBeat.o(188705);
    return localCursor;
  }
  
  public final List<String> hyk()
  {
    AppMethodBeat.i(116980);
    Object localObject1 = " select openImAppid from rcontact" + hyy() + " group by openImAppid ";
    localObject1 = this.db.rawQuery((String)localObject1, null, 4);
    Object localObject2 = new ArrayList();
    String str;
    while (((Cursor)localObject1).moveToNext())
    {
      str = ((Cursor)localObject1).getString(0);
      if (!Util.isNullOrNil(str)) {
        ((List)localObject2).add("'" + str + "'");
      }
    }
    ((Cursor)localObject1).close();
    localObject1 = new LinkedList();
    if (((List)localObject2).size() > 0)
    {
      localObject2 = " select acctTypeId from OpenIMAppIdInfo where appid in (" + Util.listToString((List)localObject2, ",") + ") group by acctTypeId";
      localObject2 = this.db.rawQuery((String)localObject2, null, 4);
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          str = ((Cursor)localObject2).getString(0);
          if (!Util.isNullOrNil(str)) {
            ((List)localObject1).add(str);
          }
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    AppMethodBeat.o(116980);
    return localObject1;
  }
  
  public final List<String> hyl()
  {
    AppMethodBeat.i(117008);
    Object localObject = "select username from rcontact where " + hyv();
    localObject = this.db.rawQuery((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      AppMethodBeat.o(117008);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        localArrayList.add(((Cursor)localObject).getString(0));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117008);
    return localArrayList;
  }
  
  public final Cursor hym()
  {
    AppMethodBeat.i(117009);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + new StringBuilder("type & ").append(com.tencent.mm.contact.d.axO()).append("=0").append(ab.a("username", "@chatroom", new String[0])).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117009);
    return localObject;
  }
  
  public final Cursor hyn()
  {
    AppMethodBeat.i(186129);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + hyu() + " AND type & 256 !=0  AND type >= 256";
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(186129);
    return localObject;
  }
  
  public final Cursor hyo()
  {
    AppMethodBeat.i(117011);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + VEE + " and verifyFlag & " + as.hya() + " !=0 ";
    Log.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117011);
    return localObject;
  }
  
  public final Cursor hyp()
  {
    AppMethodBeat.i(117012);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + hyu() + " AND " + VEE + " AND " + VED + hys();
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117012);
    return localObject;
  }
  
  public final int hyq()
  {
    int i = 0;
    AppMethodBeat.i(117024);
    Object localObject = "select count(rowid) from rcontact " + g("@biz.contact", null, null);
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117024);
    return i;
  }
  
  public final int hyz()
  {
    AppMethodBeat.i(188684);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select count(1) from");
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append("select verifyFlag from rcontact where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axN()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axY()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.axO()).append(" =0  )");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    int i;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      i = localCursor.getInt(0);
      localCursor.close();
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactStorage", "getNormalContactAndHelperCount, sql:%s, result:%d, time:%d", new Object[] { localObject, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(188684);
      return i;
      i = 0;
    }
  }
  
  public final Cursor jB(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(116986);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
      label28:
      if (i >= paramList.size()) {
        break label146;
      }
      if (i == paramList.size() - 1) {
        break label103;
      }
    }
    label103:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label28;
      bool = false;
      break;
    }
    label146:
    paramList = str + hyr();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(116986);
    return paramList;
  }
  
  public final Cursor jC(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(116987);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      localStringBuilder = new StringBuilder("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact ");
      localStringBuilder.append(" where username IN (");
      label44:
      if (i >= paramList.size()) {
        break label136;
      }
      if (i != paramList.size() - 1) {
        break label105;
      }
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("'");
    }
    for (;;)
    {
      i += 1;
      break label44;
      bool = false;
      break;
      label105:
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("',");
    }
    label136:
    localStringBuilder.append(" )").append(hyr());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(116987);
    return paramList;
  }
  
  public final Cursor jD(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(117006);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      localStringBuilder = new StringBuilder("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ");
      localStringBuilder.append(" where username IN (");
      label44:
      if (i >= paramList.size()) {
        break label136;
      }
      if (i != paramList.size() - 1) {
        break label105;
      }
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("'");
    }
    for (;;)
    {
      i += 1;
      break label44;
      bool = false;
      break;
      label105:
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("',");
    }
    label136:
    localStringBuilder.append(" )").append(hyr());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117006);
    return paramList;
  }
  
  public final Cursor jE(List<String> paramList)
  {
    int j = 0;
    AppMethodBeat.i(117007);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where (";
      i = 0;
      label32:
      if (i >= paramList.size()) {
        break label151;
      }
      if (i == paramList.size() - 1) {
        break label108;
      }
    }
    label108:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label32;
      bool = false;
      break;
    }
    label151:
    str = str + ") order by case username ";
    int i = j;
    while (i < paramList.size())
    {
      str = str + " when '" + (String)paramList.get(i) + "' then " + i;
      i += 1;
    }
    paramList = str + " end";
    Log.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117007);
    return paramList;
  }
  
  public final Cursor jH(List<String> paramList)
  {
    AppMethodBeat.i(117017);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + hyu() + " and ( " + jG(paramList) + " ) ";
    str = str + " order by case username ";
    int i = 0;
    while (i < paramList.size())
    {
      str = str + " when '" + (String)paramList.get(i) + "' then " + i;
      i += 1;
    }
    paramList = str + " end ";
    paramList = paramList + " limit 6";
    Log.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117017);
    return paramList;
  }
  
  public final Cursor jI(List<String> paramList)
  {
    AppMethodBeat.i(117018);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + VEE + ") and (" + jG(paramList) + ")" + hys();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117018);
    return paramList;
  }
  
  public final Cursor jJ(List<String> paramList)
  {
    AppMethodBeat.i(117019);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + VEE + ") and (" + jG(paramList) + ")" + hys() + " and (username like  '%@openim' )";
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117019);
    return paramList;
  }
  
  public final Cursor jK(List<String> paramList)
  {
    AppMethodBeat.i(117020);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + A(paramList, false) + hys();
    Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    Log.i("MicroMsg.ContactStorage", "getFavCursor favourSql = %s", new Object[] { paramList });
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117020);
    return paramList;
  }
  
  public final Cursor jL(List<String> paramList)
  {
    AppMethodBeat.i(117021);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + jP(paramList) + hys();
    Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    Log.i("MicroMsg.ContactStorage", "getFavCursorWithoutOpenIM favourSql = %s", new Object[] { paramList });
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117021);
    return paramList;
  }
  
  public final List<String> jM(List<String> paramList)
  {
    AppMethodBeat.i(117025);
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
      paramList = new LinkedList();
      AppMethodBeat.o(117025);
      return paramList;
    }
    long l = Util.currentTicks();
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("username='").append((String)paramList.get(0)).append("'");
    int i = 1;
    while (i < paramList.size())
    {
      ((StringBuilder)localObject).append(" or username='").append((String)paramList.get(i)).append("'");
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showHead asc, ");
    localStringBuilder.append("pyInitial asc, ");
    localStringBuilder.append("quanPin asc, ");
    localStringBuilder.append("nickname asc, ");
    localStringBuilder.append("username asc ");
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(com.tencent.mm.contact.d.axN()), localStringBuilder.toString() });
    Log.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    Log.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramList, localLinkedList.toString() });
    AppMethodBeat.o(117025);
    return localLinkedList;
  }
  
  public final int[] jN(List<String> paramList)
  {
    AppMethodBeat.i(117028);
    paramList = "select distinct showHead from rcontact  where (" + jG(paramList) + ") " + hyr();
    long l = System.currentTimeMillis();
    paramList = this.db.rawQuery(paramList, null);
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramList.getCount() >= 0) {}
    int[] arrayOfInt;
    for (int i = paramList.getCount();; i = 0)
    {
      Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
      arrayOfInt = new int[i];
      if (paramList.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramList.moveToPosition(j);
        arrayOfInt[j] = paramList.getInt(0);
        j += 1;
      }
    }
    paramList.close();
    AppMethodBeat.o(117028);
    return arrayOfInt;
  }
  
  public final int[] jO(List<String> paramList)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(117030);
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + jG(paramList);
    paramList = paramList + " group by showHead";
    Cursor localCursor = this.db.rawQuery(paramList, null, 2);
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = localCursor.getCount();
    Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
    paramList = arrayOfInt;
    if (j > 0)
    {
      arrayOfInt = new int[j];
      int i = 0;
      for (;;)
      {
        paramList = arrayOfInt;
        if (i >= j) {
          break;
        }
        localCursor.moveToPosition(i);
        arrayOfInt[i] = localCursor.getInt(0);
        i += 1;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117030);
    return paramList;
  }
  
  public final Cursor nI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(185151);
    paramString1 = "select username from rcontact " + g(paramString1, paramString2, null);
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(185151);
    return paramString1;
  }
  
  public final int nJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117059);
    Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { Util.nullAs(paramString1, ""), Integer.valueOf(Util.nullAs(paramString2, "").length()) });
    as localas = bwt(paramString1);
    if (localas != null)
    {
      if (Util.isEqual(localas.field_ticket, paramString2))
      {
        AppMethodBeat.o(117059);
        return 0;
      }
      localas.ID(paramString2);
      int i = c(paramString1, localas);
      AppMethodBeat.o(117059);
      return i;
    }
    AppMethodBeat.o(117059);
    return 0;
  }
  
  public final boolean shouldProcessEvent()
  {
    AppMethodBeat.i(117053);
    if ((this.db == null) || (this.db.isClose()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.isClose()))
      {
        Log.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117053);
        return false;
      }
    }
    AppMethodBeat.o(117053);
    return true;
  }
  
  public final Cursor z(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117016);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + jG(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + hyr();
    }
    Log.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117016);
    return paramList;
  }
  
  static final class a
    implements bv.a
  {
    ConcurrentHashMap<bv.a, Object> QWB;
    
    private a()
    {
      AppMethodBeat.i(188172);
      this.QWB = new ConcurrentHashMap();
      AppMethodBeat.o(188172);
    }
    
    public final as RG(String paramString)
    {
      AppMethodBeat.i(188178);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext())
      {
        bv.a locala = (bv.a)localIterator.next();
        as localas = locala.RG(paramString);
        if (localas != null)
        {
          Log.i("MicroMsg.ContactStorage", "[get] contact=%s listener=%s", new Object[] { localas.field_username, locala });
          AppMethodBeat.o(188178);
          return localas;
        }
      }
      AppMethodBeat.o(188178);
      return null;
    }
    
    public final void a(bv parambv, as paramas)
    {
      AppMethodBeat.i(188174);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext()) {
        ((bv.a)localIterator.next()).a(parambv, paramas);
      }
      AppMethodBeat.o(188174);
    }
    
    public final int b(as paramas, boolean paramBoolean)
    {
      AppMethodBeat.i(188181);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext())
      {
        bv.a locala = (bv.a)localIterator.next();
        int i = locala.b(paramas, paramBoolean);
        if (i > 0)
        {
          Log.i("MicroMsg.ContactStorage", "[replace] ret=%s listener=%s", new Object[] { Integer.valueOf(i), locala });
          AppMethodBeat.o(188181);
          return i;
        }
      }
      AppMethodBeat.o(188181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ay
 * JD-Core Version:    0.7.0.1
 */