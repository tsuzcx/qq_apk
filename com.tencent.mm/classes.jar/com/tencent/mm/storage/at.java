package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.d;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class at
  extends n
  implements bq
{
  public static final String[] INDEX_CREATE;
  private static String JeP;
  private static String JeQ;
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e JeL;
  public final com.tencent.mm.b.f<String, an> JeM;
  public final com.tencent.mm.b.f<String, Integer> JeN;
  private a JeO;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117060);
    SQL_CREATE = new String[] { j.getCreateSQLs(an.info, "rcontact"), j.getCreateSQLs(an.info, "bottlecontact"), j.getCreateSQLs(ao.info, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
    INDEX_CREATE = new String[] { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) " };
    JeP = "showHead = 32";
    JeQ = "type & 64 !=0 ";
    AppMethodBeat.o(117060);
  }
  
  public at(h paramh)
  {
    AppMethodBeat.i(116970);
    this.JeM = new com.tencent.mm.memory.a.c(200);
    this.JeN = new com.tencent.mm.memory.a.c(400);
    this.JeO = new a((byte)0);
    Object localObject = paramh.a("PRAGMA table_info( contact_ext )", null, 2);
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
    localObject = paramh.a("PRAGMA table_info( rcontact )", null, 2);
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
      localObject = j.getUpdateSQLs(com.tencent.mm.contact.c.info, "bottlecontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.execSQL("bottlecontact", (String)((Iterator)localObject).next());
      }
      localObject = j.getUpdateSQLs(com.tencent.mm.contact.c.info, "rcontact", paramh).iterator();
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
      this.JeL = paramh;
      AppMethodBeat.o(116970);
      return;
    }
  }
  
  private static String F(String paramString, List<String> paramList)
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
  
  private static String X(String[] paramArrayOfString)
  {
    AppMethodBeat.i(117035);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(117035);
      return "";
    }
    String str1 = " and (";
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str2 = str1;
      if (i > 0) {
        str2 = str1 + " or ";
      }
      str1 = str2 + "username = '" + paramArrayOfString[i] + "' ";
      i += 1;
    }
    paramArrayOfString = str1 + " )";
    AppMethodBeat.o(117035);
    return paramArrayOfString;
  }
  
  private static String a(String paramString1, List<String> paramList1, String paramString2, List<String> paramList2)
  {
    AppMethodBeat.i(116981);
    paramString1 = paramString1 + " and OpenIMWordingInfo.language='" + paramString2 + "' ";
    String str = paramString1 + fuG();
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
    ae.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[] { paramString1 });
    AppMethodBeat.o(116981);
    return paramString1;
  }
  
  private static String aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(117040);
    String str2 = "type & " + com.tencent.mm.contact.c.adm() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + com.tencent.mm.contact.c.adq() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + com.tencent.mm.contact.c.adr() + "=0 ";
    str2 = str1 + " and type & " + com.tencent.mm.contact.c.adn() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + an.fuj() + " =0 ";
    }
    AppMethodBeat.o(117040);
    return str1;
  }
  
  private static String aUE(String paramString)
  {
    AppMethodBeat.i(116968);
    if (an.Ac(paramString))
    {
      paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from " + "bottlecontact";
      AppMethodBeat.o(116968);
      return paramString;
    }
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from " + "rcontact";
    AppMethodBeat.o(116968);
    return paramString;
  }
  
  private static String aUF(String paramString)
  {
    AppMethodBeat.i(116969);
    if (an.Ac(paramString))
    {
      AppMethodBeat.o(116969);
      return "bottlecontact";
    }
    AppMethodBeat.o(116969);
    return "rcontact";
  }
  
  private an aUW(String paramString)
  {
    AppMethodBeat.i(117058);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    if (an.Ac(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    an localan = new an();
    paramString = "select  *,rowid  from rcontact where username=" + h.wX(paramString) + " or encryptUsername=" + h.wX(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localan.convertFrom(paramString);
      paramString.close();
      localan.fum();
      d(localan, false);
    }
    for (;;)
    {
      AppMethodBeat.o(117058);
      return localan;
      paramString.close();
    }
  }
  
  private an aUX(String paramString)
  {
    AppMethodBeat.i(211766);
    an localan = new an();
    paramString = aUE(paramString) + " where username=" + h.wX(paramString) + " or encryptUsername=" + h.wX(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localan.convertFrom(paramString);
      paramString.close();
      localan.fum();
      d(localan, false);
    }
    for (;;)
    {
      AppMethodBeat.o(211766);
      return localan;
      paramString.close();
    }
  }
  
  private static boolean ap(an paraman)
  {
    boolean bool = false;
    AppMethodBeat.i(117054);
    if (paraman == null)
    {
      AppMethodBeat.o(117054);
      return false;
    }
    int i = paraman.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      ae.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paraman.field_username);
      AppMethodBeat.o(117054);
      return bool;
      bool = true;
    }
  }
  
  private static String fuA()
  {
    AppMethodBeat.i(117039);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by case when verifyFlag & " + an.fuj() + " != 0 then 0 else 1 end , showHead asc, ");
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
  
  private static String fuB()
  {
    AppMethodBeat.i(117041);
    String str = "type & " + com.tencent.mm.contact.c.adm() + " !=0 ";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.c.adr() + " =0 and ";
    str = str + "type & " + com.tencent.mm.contact.c.adn() + " =0";
    AppMethodBeat.o(117041);
    return str;
  }
  
  private static String fuC()
  {
    AppMethodBeat.i(117042);
    String str = "type & " + com.tencent.mm.contact.c.adm() + "!=0";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.c.adr() + "=0  ";
    AppMethodBeat.o(117042);
    return str;
  }
  
  private static String fuD()
  {
    AppMethodBeat.i(117043);
    String str = "type & " + com.tencent.mm.contact.c.adm() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.c.adn() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom'))";
    AppMethodBeat.o(117043);
    return str;
  }
  
  private static String fuE()
  {
    AppMethodBeat.i(117044);
    String str = "type & " + com.tencent.mm.contact.c.adm() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.c.adn() + "=0 and username like '%@talkroom')";
    AppMethodBeat.o(117044);
    return str;
  }
  
  private static String fuF()
  {
    AppMethodBeat.i(117045);
    String str = "type & " + com.tencent.mm.contact.c.adn() + "=0 and username like '%@openim'";
    AppMethodBeat.o(117045);
    return str;
  }
  
  private static String fuG()
  {
    AppMethodBeat.i(117046);
    String str = fuC() + " and " + fuF();
    AppMethodBeat.o(117046);
    return str;
  }
  
  private static String fuz()
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
  
  private static String hJ(List<String> paramList)
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
  
  private static String hK(List<String> paramList)
  {
    AppMethodBeat.i(117015);
    String str = hJ(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    AppMethodBeat.o(117015);
    return paramList;
  }
  
  private static String hT(List<String> paramList)
  {
    AppMethodBeat.i(117048);
    Object localObject = aO(false, false) + " AND " + JeQ;
    String str2 = (String)localObject + " and ( username not like '%@openim')";
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
  
  private static String s(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117047);
    String str2 = aO(false, paramBoolean) + " AND " + JeQ;
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
  
  public final int B(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    AppMethodBeat.i(116999);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(116999);
      return -1;
    }
    ao localao = new ao();
    localao.field_cmdbuf = paramArrayOfByte;
    localao.field_username = paramString;
    int j = (int)this.db.replace("ContactCmdBuf", "username", localao.convertTo());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      ae.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(116999);
      return j;
      i = paramArrayOfByte.length;
    }
  }
  
  public final an BH(String paramString)
  {
    AppMethodBeat.i(116991);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116991);
      return null;
    }
    String str = paramString;
    if (an.Ac(paramString)) {
      str = an.aUA(paramString);
    }
    paramString = aUG(str);
    if (paramString != null)
    {
      AppMethodBeat.o(116991);
      return paramString;
    }
    paramString = this.JeO.BH(str);
    if (paramString != null)
    {
      d(paramString, false);
      AppMethodBeat.o(116991);
      return paramString;
    }
    paramString = aUX(str);
    AppMethodBeat.o(116991);
    return paramString;
  }
  
  public final an Ed(long paramLong)
  {
    an localan = null;
    AppMethodBeat.i(116992);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(116992);
      return null;
    }
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where rowid=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localan = new an();
      localan.convertFrom((Cursor)localObject);
      d(localan, false);
    }
    ((Cursor)localObject).close();
    if (localan != null) {
      localan.fum();
    }
    AppMethodBeat.o(116992);
    return localan;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116979);
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + f(paramString1, paramString2, paramList1) + hJ(paramList2) + fuz();
    ae.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + s(paramList1, paramBoolean2) + fuA();
      ae.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.a(paramString2, null, 4);
      paramString1 = this.db.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new com.tencent.mm.storagebase.a.e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116979);
        return paramString1;
      }
      paramString1 = d.fxH();
      AppMethodBeat.o(116979);
      return paramString1;
    }
    paramString1 = this.db.a(paramString1, null, 4);
    AppMethodBeat.o(116979);
    return paramString1;
  }
  
  public final Cursor a(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(116982);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(116982);
    return paramList1;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(117033);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = d.fxH();
      AppMethodBeat.o(117033);
      return paramArrayOfString;
    }
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + f(paramString1, paramString2, paramList2) + X(paramArrayOfString) + F(paramString2, paramList1) + fuz();
    ae.i("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(117033);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117032);
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + f(paramString, null, paramList) + X(paramArrayOfString);
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
    ae.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(paramList)));
    paramArrayOfString = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117032);
    return paramArrayOfString;
  }
  
  public final void a(bq.a parama)
  {
    AppMethodBeat.i(211758);
    this.JeO.Ffv.put(parama, new Object());
    AppMethodBeat.o(211758);
  }
  
  public final String aFL()
  {
    AppMethodBeat.i(224451);
    String str = fuz();
    AppMethodBeat.o(224451);
    return str;
  }
  
  public final boolean aTg()
  {
    AppMethodBeat.i(117053);
    if ((this.db == null) || (this.db.fqe()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.fqe()))
      {
        ae.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117053);
        return false;
      }
    }
    AppMethodBeat.o(117053);
    return true;
  }
  
  public final an aUG(String paramString)
  {
    AppMethodBeat.i(116973);
    paramString = (an)this.JeM.aL(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(116973);
      return paramString;
    }
    AppMethodBeat.o(116973);
    return null;
  }
  
  public final boolean aUH(String paramString)
  {
    AppMethodBeat.i(116976);
    if ((bu.isNullOrNil(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger"))))
    {
      AppMethodBeat.o(116976);
      return false;
    }
    Object localObject = (Integer)this.JeN.get(paramString);
    if (localObject != null)
    {
      bool = com.tencent.mm.contact.c.lO(((Integer)localObject).intValue());
      AppMethodBeat.o(116976);
      return bool;
    }
    localObject = BH(paramString);
    if ((localObject == null) || ((!((aw)localObject).field_username.equals(paramString)) && (!paramString.equals(((aw)localObject).field_encryptUsername))))
    {
      this.JeN.q(paramString, Integer.valueOf(0));
      AppMethodBeat.o(116976);
      return false;
    }
    this.JeN.q(paramString, Integer.valueOf(((aw)localObject).field_type));
    boolean bool = com.tencent.mm.contact.c.lO(((aw)localObject).field_type);
    AppMethodBeat.o(116976);
    return bool;
  }
  
  public final an aUI(String paramString)
  {
    AppMethodBeat.i(116978);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116978);
      return null;
    }
    an localan = this.JeO.BH(paramString);
    if (localan != null)
    {
      d(localan, false);
      AppMethodBeat.o(116978);
      return localan;
    }
    localan = new an();
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact where alias=" + h.wX(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localan.convertFrom(paramString);
      d(localan, false);
    }
    paramString.close();
    localan.fum();
    AppMethodBeat.o(116978);
    return localan;
  }
  
  public final Cursor aUJ(String paramString)
  {
    AppMethodBeat.i(116985);
    paramString = this.db.a(paramString, null, 4);
    AppMethodBeat.o(116985);
    return paramString;
  }
  
  public final an aUK(String paramString)
  {
    AppMethodBeat.i(116989);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116989);
      return null;
    }
    Object localObject = paramString;
    if (an.Ac(paramString)) {
      localObject = an.aUA(paramString);
    }
    paramString = aUG((String)localObject);
    if (paramString != null)
    {
      paramString.fum();
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = this.JeO.BH((String)localObject);
    if (paramString != null)
    {
      d(paramString, false);
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = new an();
    localObject = aUE((String)localObject) + " where username=" + h.wX((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      d(paramString, false);
    }
    ((Cursor)localObject).close();
    paramString.fum();
    AppMethodBeat.o(116989);
    return paramString;
  }
  
  public final an aUL(String paramString)
  {
    AppMethodBeat.i(116990);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116990);
      return null;
    }
    Object localObject = paramString;
    if (an.Ac(paramString)) {
      localObject = an.aUA(paramString);
    }
    paramString = aUG((String)localObject);
    if (paramString != null)
    {
      AppMethodBeat.o(116990);
      return paramString;
    }
    paramString = new an();
    localObject = aUE((String)localObject) + " where username=" + h.wX((String)localObject) + " or encryptUsername=" + h.wX((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      d(paramString, false);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116990);
    return paramString;
  }
  
  public final an aUM(String paramString)
  {
    AppMethodBeat.i(211760);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211760);
      return null;
    }
    Object localObject = paramString;
    if (an.Ac(paramString)) {
      localObject = an.aUA(paramString);
    }
    paramString = new an();
    localObject = aUE((String)localObject) + " where username=" + h.wX((String)localObject) + " or encryptUsername=" + h.wX((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      paramString.fum();
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(211760);
    return paramString;
  }
  
  public final long aUN(String paramString)
  {
    AppMethodBeat.i(116993);
    long l2 = -1L;
    paramString = BH(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.ght > 0L) {
        l1 = (int)paramString.ght;
      }
    }
    AppMethodBeat.o(116993);
    return l1;
  }
  
  public final boolean aUO(String paramString)
  {
    AppMethodBeat.i(116994);
    an localan = BH(paramString);
    if ((localan != null) && (!bu.isNullOrNil(localan.field_username)) && (localan.field_username.equals(paramString)))
    {
      AppMethodBeat.o(116994);
      return true;
    }
    AppMethodBeat.o(116994);
    return false;
  }
  
  public final boolean aUP(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(116995);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116995);
      return false;
    }
    paramString = "select count(*) from " + aUF(paramString) + " where type & " + com.tencent.mm.contact.c.adn() + " !=0 and username=" + h.wX(paramString);
    paramString = this.db.a(paramString, null, 2);
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
  
  public final byte[] aUQ(String paramString)
  {
    AppMethodBeat.i(117000);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(117000);
      return null;
    }
    ao localao = new ao();
    Cursor localCursor = this.db.a("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localao.convertFrom(localCursor);
    }
    localCursor.close();
    if (localao.field_cmdbuf == null) {}
    for (int i = -1;; i = localao.field_cmdbuf.length)
    {
      ae.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      paramString = localao.field_cmdbuf;
      AppMethodBeat.o(117000);
      return paramString;
    }
  }
  
  public final int aUR(String paramString)
  {
    AppMethodBeat.i(117001);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
      AppMethodBeat.o(117001);
      return -1;
    }
    int i = this.db.delete("ContactCmdBuf", "username=?", new String[] { String.valueOf(paramString) });
    ae.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(117001);
    return i;
  }
  
  public final int aUS(String paramString)
  {
    AppMethodBeat.i(117002);
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (an.Ac(paramString)) {
        str = an.aUA(paramString);
      }
      alb(str);
      paramString = new an(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + bu.fpO());
      paramString.tu("fake_" + bu.fpO());
      paramString.setSource(0);
      i = this.db.update(aUF(str), paramString.convertTo(), "username=?", new String[] { String.valueOf(str) });
      aUR(str);
      ae.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[] { str, Integer.valueOf(i), bu.fpN() });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(117002);
      return i;
    }
    b(5, this, str);
    AppMethodBeat.o(117002);
    return i;
  }
  
  public final String aUT(String paramString)
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
  
  public final int aUU(String paramString)
  {
    AppMethodBeat.i(211765);
    long l = System.currentTimeMillis();
    paramString = "select count(username) from rcontact" + f(paramString, null, null) + aUT(null);
    Cursor localCursor = this.db.a(paramString, null, 2);
    int i;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      i = localCursor.getInt(0);
      localCursor.close();
    }
    for (;;)
    {
      ae.i("MicroMsg.ContactStorage", "getCountByFilterType, sql:%s, count:%d, time:%d", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(211765);
      return i;
      i = 0;
    }
  }
  
  public final String aUV(String paramString)
  {
    AppMethodBeat.i(117057);
    an localan = aUW(paramString);
    if (localan != null)
    {
      ae.i("MicroMsg.ContactStorage", "getSendMsgTicket %s %s", new Object[] { bu.bI(paramString, ""), Integer.valueOf(bu.bI(localan.field_ticket, "").length()) });
      paramString = localan.field_ticket;
      AppMethodBeat.o(117057);
      return paramString;
    }
    ae.e("MicroMsg.ContactStorage", "getSendMsgTicket ca == null");
    AppMethodBeat.o(117057);
    return "";
  }
  
  public final void ak(an paraman)
  {
    AppMethodBeat.i(116974);
    d(paraman, false);
    AppMethodBeat.o(116974);
  }
  
  public final boolean al(an paraman)
  {
    AppMethodBeat.i(116977);
    if (aUO(paraman.field_username))
    {
      if (c(paraman.field_username, paraman) == 0)
      {
        AppMethodBeat.o(116977);
        return true;
      }
      AppMethodBeat.o(116977);
      return false;
    }
    if (ao(paraman) >= 0)
    {
      AppMethodBeat.o(116977);
      return true;
    }
    AppMethodBeat.o(116977);
    return false;
  }
  
  public final void alb(String paramString)
  {
    AppMethodBeat.i(116975);
    if (!bu.isNullOrNil(paramString))
    {
      this.JeM.remove(paramString);
      this.JeN.remove(paramString);
    }
    AppMethodBeat.o(116975);
  }
  
  public final boolean am(an paraman)
  {
    AppMethodBeat.i(116996);
    if (paraman != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue("contact NULL !", bool1);
      if (ap(paraman)) {
        break;
      }
      AppMethodBeat.o(116996);
      return true;
    }
    paraman.kb(paraman.acP());
    this.JeO.a(this, paraman);
    if (this.JeO.b(paraman, false) > 0)
    {
      bool1 = true;
      ae.d("MicroMsg.ContactStorage", "[replace] ret:%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Boolean.valueOf(bool1), paraman.field_username, Integer.valueOf(paraman.field_showHead), Integer.valueOf(paraman.field_verifyFlag) });
      bool2 = bool1;
      if (!bool1)
      {
        ContentValues localContentValues = paraman.convertTo();
        if ((int)paraman.ght > 0) {
          localContentValues.put("rowid", Integer.valueOf((int)paraman.ght));
        }
        if (this.db.replace(aUF(paraman.field_username), com.tencent.mm.contact.c.info.IBM, localContentValues) <= 0L) {
          break label227;
        }
      }
    }
    label227:
    for (boolean bool2 = true;; bool2 = false)
    {
      alb(paraman.field_username);
      if (!bu.isNullOrNil(paraman.field_encryptUsername)) {
        alb(paraman.field_encryptUsername);
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
    b(4, this, paraman.field_username);
    AppMethodBeat.o(116996);
    return true;
  }
  
  public final boolean an(an paraman)
  {
    AppMethodBeat.i(116997);
    if (ao(paraman) > 0)
    {
      AppMethodBeat.o(116997);
      return true;
    }
    AppMethodBeat.o(116997);
    return false;
  }
  
  public final int ao(an paraman)
  {
    AppMethodBeat.i(116998);
    if (bu.nullAsNil(paraman.field_username).length() <= 0)
    {
      ae.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      AppMethodBeat.o(116998);
      return -1;
    }
    paraman.kb(paraman.acP());
    this.JeO.a(this, paraman);
    int j = this.JeO.b(paraman, false);
    ae.i("MicroMsg.ContactStorage", "extensions replace=%s %s", new Object[] { Integer.valueOf(j), paraman.field_username });
    int i = j;
    if (j < 0)
    {
      Object localObject = paraman.convertTo();
      long l = System.currentTimeMillis();
      int k = (int)this.db.insert(aUF(paraman.field_username), com.tencent.mm.contact.c.info.IBM, (ContentValues)localObject);
      int m = (int)bu.DD(l);
      boolean bool = b.foreground;
      localObject = com.tencent.mm.plugin.report.e.ywz;
      if (bool)
      {
        i = 11;
        if (!bool) {
          break label290;
        }
      }
      label290:
      for (j = 12;; j = 15)
      {
        ((com.tencent.mm.plugin.report.e)localObject).c(463, i, j, m, false);
        ae.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paraman.field_username, Integer.valueOf(paraman.field_showHead), Integer.valueOf(paraman.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        if (k == -1) {
          break label296;
        }
        paraman.ght = k;
        d(paraman, false);
        b(2, this, paraman.field_username);
        AppMethodBeat.o(116998);
        return k;
        i = 14;
        break;
      }
      label296:
      ae.e("MicroMsg.ContactStorage", "insert failed: username=%s", new Object[] { paraman.field_username });
      i = k;
    }
    AppMethodBeat.o(116998);
    return i;
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116988);
    paramString1 = "select username from rcontact " + f(paramString1, paramString2, paramList1) + hJ(paramList2) + fuz();
    ae.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + s(paramList1, paramBoolean2) + fuA();
      ae.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.a(paramString2, null, 4);
      paramString1 = this.db.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new com.tencent.mm.storagebase.a.e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116988);
        return paramString1;
      }
      paramString1 = d.fxH();
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
    ae.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(116983);
    return paramList1;
  }
  
  public final void b(bq.a parama)
  {
    AppMethodBeat.i(116972);
    this.JeO.Ffv.remove(parama);
    AppMethodBeat.o(116972);
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(117026);
    paramString1 = "select distinct showHead from rcontact " + f(paramString1, paramString2, paramList) + X(paramArrayOfString) + fuz();
    long l = System.currentTimeMillis();
    paramString1 = this.db.rawQuery(paramString1, null);
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - l));
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
    AppMethodBeat.i(211761);
    paramArrayOfString = "select distinct showHead from rcontact " + f(paramString1, paramString2, paramList) + X(paramArrayOfString) + aUT(paramString3) + fuz();
    long l = System.currentTimeMillis();
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramArrayOfString.getCount() >= 0) {}
    for (int i = paramArrayOfString.getCount();; i = 0)
    {
      ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(211761);
    return paramString1;
  }
  
  public final int c(String paramString, an paraman)
  {
    AppMethodBeat.i(117003);
    ae.i("MicroMsg.ContactStorage", "begin to update contact : ".concat(String.valueOf(paramString)));
    if (!ap(paraman))
    {
      AppMethodBeat.o(117003);
      return 1;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (an.Ac(paramString)) {
      str = an.aUA(paramString);
    }
    paraman.kb(paraman.acP());
    this.JeO.a(this, paraman);
    int j = this.JeO.b(paraman, true);
    int i = j;
    if (j < 0)
    {
      paramString = paraman.convertTo();
      if ((int)paraman.ght > 0) {
        paramString.put("rowid", Integer.valueOf((int)paraman.ght));
      }
      i = j;
      if (paramString.size() > 0) {
        i = this.db.update(aUF(str), paramString, "username=?", new String[] { String.valueOf(str) });
      }
    }
    ae.i("MicroMsg.ContactStorage", "[update] ret=%s username=%s, showHead=%d, verifyFlag=%d, take[%d]ms", new Object[] { Integer.valueOf(i), paraman.field_username, Integer.valueOf(paraman.field_showHead), Integer.valueOf(paraman.field_verifyFlag), Long.valueOf(System.currentTimeMillis() - l) });
    alb(str);
    if (!bu.isNullOrNil(paraman.field_encryptUsername)) {
      alb(paraman.field_encryptUsername);
    }
    if (i != 0) {
      b(4, this, paraman.field_username);
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
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adm()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adr()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adn()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8 = 0 ");
    localStringBuilder.append(" and ( username not like '%@%')");
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
    paramVarArgs = this.db.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      ae.i("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d, time:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(117050);
      return i;
      i = 0;
    }
  }
  
  public final Cursor c(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117014);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + f(paramString1, paramString2, paramList) + hJ(null) + fuz();
    ae.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117014);
    return paramString1;
  }
  
  public final Cursor c(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(116984);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    ae.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(116984);
    return paramList1;
  }
  
  public final int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(117031);
    paramString1 = "select count(*) from rcontact " + f(paramString1, paramString2, paramList) + X(paramArrayOfString);
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
    AppMethodBeat.i(211762);
    long l = System.currentTimeMillis();
    paramArrayOfString = "select count(*) from rcontact " + f(paramString1, paramString2, paramList) + X(paramArrayOfString) + aUT(paramString3);
    paramArrayOfString = paramArrayOfString + " group by showHead";
    paramString2 = this.db.rawQuery(paramArrayOfString, null);
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = paramString2.getCount();
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(211762);
    return paramArrayOfString;
  }
  
  public final int cj(String paramString, long paramLong)
  {
    AppMethodBeat.i(169111);
    ae.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { bu.bI(paramString, ""), Long.valueOf(paramLong) });
    an localan = aUK(paramString);
    if (localan != null)
    {
      if (bu.az(localan.eRA, paramLong))
      {
        AppMethodBeat.o(169111);
        return 0;
      }
      localan.qF(paramLong);
      int i = c(paramString, localan);
      AppMethodBeat.o(169111);
      return i;
    }
    AppMethodBeat.o(169111);
    return 0;
  }
  
  public final int d(String paramString, an paraman)
  {
    int j = 0;
    AppMethodBeat.i(117004);
    if ((bu.isNullOrNil(paramString)) || (paraman == null) || (bu.isNullOrNil(paraman.field_username)))
    {
      ae.e("MicroMsg.ContactStorage", "update : wrong input!");
      AppMethodBeat.o(117004);
      return 0;
    }
    ae.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paraman.field_username + " enUsername: " + paramString);
    if (!ap(paraman))
    {
      AppMethodBeat.o(117004);
      return 1;
    }
    if (an.Ac(paraman.field_username)) {
      paraman.setUsername(an.aUA(paraman.field_username));
    }
    paraman.kb(paraman.acP());
    this.JeO.a(this, paraman);
    boolean bool;
    ContentValues localContentValues;
    an localan;
    int i;
    if (this.JeO.b(paraman, true) > 0)
    {
      bool = true;
      ae.d("MicroMsg.ContactStorage", "[update] ret=%s oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[] { Boolean.valueOf(bool), paramString, paraman.field_username, Integer.valueOf(paraman.field_showHead), Integer.valueOf(paraman.field_verifyFlag) });
      localContentValues = paraman.convertTo();
      if ((bool) || (paraman.ght > 0L)) {
        break label460;
      }
      localan = new an(paramString);
      localan.setType(0);
      localan.setUsername("fake_" + bu.fpO());
      localan.tu("fake_" + bu.fpO());
      i = this.db.update(aUF(paramString), localan.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
      ae.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + aUF(paramString) + " user :" + paramString + ", res:" + i);
      i = j;
      if (localContentValues.size() > 0) {
        i = (int)this.db.replace(aUF(paraman.field_username), com.tencent.mm.contact.c.info.IBM, localContentValues);
      }
    }
    for (;;)
    {
      alb(paraman.field_username);
      if (!bu.isNullOrNil(paraman.field_encryptUsername)) {
        alb(paraman.field_encryptUsername);
      }
      b(3, this, paramString);
      b(3, this, paraman.field_username);
      AppMethodBeat.o(117004);
      return i;
      bool = false;
      break;
      label460:
      i = j;
      if (!bool) {
        if (paramString.equals(paraman.field_username))
        {
          i = j;
          if (localContentValues.size() > 0)
          {
            i = this.db.update(aUF(paraman.field_username), localContentValues, "rowid=?", new String[] { paraman.ght });
            ae.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paraman.field_username, Integer.valueOf(i), Long.valueOf(paraman.ght) });
          }
        }
        else
        {
          localan = new an(paramString);
          localan.setType(0);
          localan.setUsername("fake_" + bu.fpO());
          localan.tu("fake_" + bu.fpO());
          i = this.db.update(aUF(paramString), localan.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
          ae.d("MicroMsg.ContactStorage", "delete " + aUF(paramString) + " user :" + paramString + ", res:" + i);
          i = j;
          if (localContentValues.size() > 0) {
            i = this.db.update(aUF(paraman.field_username), localContentValues, "rowid=?", new String[] { paraman.ght });
          }
        }
      }
    }
  }
  
  public final int d(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(117051);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adm()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adr()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.c.adn()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8 = 0 and ");
    localStringBuilder.append("(( username like '%@chatroom') or ");
    localStringBuilder.append("( username like '%@im.chatroom'))");
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
    paramVarArgs = this.db.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      ae.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      AppMethodBeat.o(117051);
      return i;
      i = 0;
    }
  }
  
  public final Cursor d(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117022);
    paramString1 = c(paramString1, paramString2, paramList);
    AppMethodBeat.o(117022);
    return paramString1;
  }
  
  public final Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(211763);
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + f(paramString2, paramString3, paramList) + X(paramArrayOfString) + aUT(paramString1) + fuz();
    ae.v("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(211763);
    return paramArrayOfString;
  }
  
  public final void d(an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(211759);
    if ((paraman == null) || (paraman.field_username == null) || ((paraman.field_type == 0) && (!paramBoolean)))
    {
      AppMethodBeat.o(211759);
      return;
    }
    this.JeM.q(paraman.field_username, paraman);
    this.JeN.q(paraman.field_username, Integer.valueOf(paraman.field_type));
    AppMethodBeat.o(211759);
  }
  
  public final Cursor e(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117023);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + f(paramString1, paramString2, paramList) + fuz();
    ae.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117023);
    return paramString1;
  }
  
  public final void e(String paramString, an paraman)
  {
    AppMethodBeat.i(117005);
    if (paramString == null)
    {
      AppMethodBeat.o(117005);
      return;
    }
    String str = paramString;
    if (an.Ac(paramString)) {
      str = an.aUA(paramString);
    }
    paraman.kb(paraman.acP());
    if (x.p(paraman))
    {
      paraman.kb(43);
      paraman.tp(com.tencent.mm.platformtools.f.Jl(paraman.adF()));
      paraman.tq(com.tencent.mm.platformtools.f.Jk(paraman.adF()));
      paraman.ts(com.tencent.mm.platformtools.f.Jk(paraman.adG()));
      paraman.tt(paraman.adG());
      AppMethodBeat.o(117005);
      return;
    }
    if (x.AN(paraman.field_username))
    {
      ae.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
      paraman.kb(31);
    }
    this.JeO.a(this, paraman);
    int i = this.JeO.b(paraman, true);
    ae.d("MicroMsg.ContactStorage", "ret=%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Integer.valueOf(i), paraman.field_username, Integer.valueOf(paraman.field_showHead), Integer.valueOf(paraman.field_verifyFlag) });
    if (i > 0)
    {
      AppMethodBeat.o(117005);
      return;
    }
    paramString = paraman.convertTo();
    if ((int)paraman.ght > 0) {
      paramString.put("rowid", Integer.valueOf((int)paraman.ght));
    }
    if (paramString.size() > 0) {
      this.db.update(aUF(str), paramString, "username=?", new String[] { String.valueOf(str) });
    }
    AppMethodBeat.o(117005);
  }
  
  public final String f(String paramString1, String paramString2, List<String> paramList)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool8 = true;
    boolean bool1 = true;
    AppMethodBeat.i(117049);
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + aO(true, false);
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
        paramString1 = "" + fuC();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = new StringBuilder().append("");
        paramString2 = "(type & " + com.tencent.mm.contact.c.adm() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom'))";
        paramString2 = " where (" + paramString2 + ") and ";
        paramString1 = new StringBuilder().append(paramString2).append("type & ").append(com.tencent.mm.contact.c.adr()).append("=0 ").toString();
      }
      else
      {
        if (paramString1.equals("@all.contact.without.chatroom"))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = aO(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (;;)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + fuE() + ')' + " or (" + fuF() + ")";
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
            bool1 = false;
          }
        }
        if ((paramString1.equals("@all.contact.without.chatroom.without.openim")) || (paramString1.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = aO(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (bool1 = bool2;; bool1 = false)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + fuE() + ')';
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
          }
        }
        if (paramString1.equals("@black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.c.adn()).append("!=0").toString();
        }
        else if (paramString1.equals("@werun.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(com.tencent.mm.contact.c.ado()).append("!=0").toString();
        }
        else if (paramString1.equals("@social.black.android"))
        {
          paramString1 = "" + new StringBuilder().append(fuC()).append(" and type & ").append(com.tencent.mm.contact.c.adp()).append("!=0").toString();
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
            str1 = aO(true, false);
            if ((str1 != null) && (str1.length() > 0)) {}
            for (bool1 = bool3;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(str1).append(" and domainList like '%").append(paramString2).append("%'").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = aO(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool4;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + fuD() + ')';
              String str2 = " or (" + fuE() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(str2).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.c.adm() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + com.tencent.mm.contact.c.adr() + " =0 and ";
            paramString2 = paramString2 + "type & " + com.tencent.mm.contact.c.adn() + " =0 and ";
            paramString2 = paramString2 + "verifyFlag & " + an.fuj() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool5;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + fuD() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = fuB();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool6;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + fuD() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com.openim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = fuB();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool7;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + fuD() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(" or (username like '%@openim'))").toString();
              break;
            }
          }
          if (paramString1.equals("@qqim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = aO(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool8;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(paramString2).append(" and username like '%").append("@qqim").append("'").toString();
              break;
            }
          }
          if (paramString1.equals("@all.chatroom"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.c.adm() + " !=0";
            paramString2 = paramString2 + " or type & 2 !=0";
            paramString2 = paramString2 + " or type & 4 !=0";
            paramString2 = paramString2 + " or 1";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@verify.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.c.adm() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + an.fui() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@biz.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.c.adm() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + an.fuj() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@all.weixin.android"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + com.tencent.mm.contact.c.adm() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@openim.contact"))
          {
            paramString1 = "" + fuG();
          }
          else
          {
            ae.d("MicroMsg.ContactStorage", "unknow role type");
            paramString1 = "" + aO(false, false);
          }
        }
      }
    }
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(117049);
    return paramString1;
  }
  
  public final Cursor fuH()
  {
    AppMethodBeat.i(117052);
    Cursor localCursor = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where rowid = -1", null);
    AppMethodBeat.o(117052);
    return localCursor;
  }
  
  public final Cursor fuI()
  {
    AppMethodBeat.i(117055);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adm()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adr()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adn()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0 and ");
    ((StringBuilder)localObject).append("( username not like '%@%')");
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.a((String)localObject, null, 2);
    ae.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[] { localObject });
    AppMethodBeat.o(117055);
    return localCursor;
  }
  
  public final Cursor fuJ()
  {
    AppMethodBeat.i(117056);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adm()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adr()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.c.adn()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0 and ");
    ((StringBuilder)localObject).append("( username not like '%@%')");
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = this.db.a(((StringBuilder)localObject).toString(), null, 2);
    AppMethodBeat.o(117056);
    return localObject;
  }
  
  public final List<String> fus()
  {
    AppMethodBeat.i(116980);
    Object localObject1 = " select openImAppid from rcontact" + fuG() + " group by openImAppid ";
    localObject1 = this.db.a((String)localObject1, null, 4);
    Object localObject2 = new ArrayList();
    String str;
    while (((Cursor)localObject1).moveToNext())
    {
      str = ((Cursor)localObject1).getString(0);
      if (!bu.isNullOrNil(str)) {
        ((List)localObject2).add("'" + str + "'");
      }
    }
    ((Cursor)localObject1).close();
    localObject1 = new LinkedList();
    if (((List)localObject2).size() > 0)
    {
      localObject2 = " select acctTypeId from OpenIMAppIdInfo where appid in (" + bu.m((List)localObject2, ",") + ") group by acctTypeId";
      localObject2 = this.db.a((String)localObject2, null, 4);
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          str = ((Cursor)localObject2).getString(0);
          if (!bu.isNullOrNil(str)) {
            ((List)localObject1).add(str);
          }
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    AppMethodBeat.o(116980);
    return localObject1;
  }
  
  public final List<String> fut()
  {
    AppMethodBeat.i(117008);
    Object localObject = "select username from rcontact where " + fuD();
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final Cursor fuu()
  {
    AppMethodBeat.i(117009);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where " + new StringBuilder("type & ").append(com.tencent.mm.contact.c.adn()).append("=0 and username like '%@chatroom'").toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117009);
    return localObject;
  }
  
  public final Cursor fuv()
  {
    AppMethodBeat.i(186129);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + fuC() + " AND type & 256 !=0 ";
    ae.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(186129);
    return localObject;
  }
  
  public final Cursor fuw()
  {
    AppMethodBeat.i(117011);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where " + JeQ + " and verifyFlag & " + an.fuj() + " !=0 ";
    ae.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117011);
    return localObject;
  }
  
  public final Cursor fux()
  {
    AppMethodBeat.i(117012);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + fuC() + " AND " + JeQ + " AND " + JeP + fuA();
    ae.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117012);
    return localObject;
  }
  
  public final int fuy()
  {
    int i = 0;
    AppMethodBeat.i(117024);
    Object localObject = "select count(rowid) from rcontact " + f("@biz.contact", null, null);
    ae.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117024);
    return i;
  }
  
  public final Cursor hF(List<String> paramList)
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
    paramList = str + fuz();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(116986);
    return paramList;
  }
  
  public final Cursor hG(List<String> paramList)
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
    localStringBuilder.append(" )").append(fuz());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(116987);
    return paramList;
  }
  
  public final Cursor hH(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(117006);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      localStringBuilder = new StringBuilder("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact ");
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
    localStringBuilder.append(" )").append(fuz());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117006);
    return paramList;
  }
  
  public final Cursor hI(List<String> paramList)
  {
    int j = 0;
    AppMethodBeat.i(117007);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where (";
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
    ae.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117007);
    return paramList;
  }
  
  public final Cursor hL(List<String> paramList)
  {
    AppMethodBeat.i(117017);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + fuC() + " and ( " + hK(paramList) + " ) ";
    str = str + " order by case username ";
    int i = 0;
    while (i < paramList.size())
    {
      str = str + " when '" + (String)paramList.get(i) + "' then " + i;
      i += 1;
    }
    paramList = str + " end ";
    paramList = paramList + " limit 6";
    ae.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117017);
    return paramList;
  }
  
  public final Cursor hM(List<String> paramList)
  {
    AppMethodBeat.i(117018);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact where (" + JeQ + ") and (" + hK(paramList) + ")" + fuA();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117018);
    return paramList;
  }
  
  public final Cursor hN(List<String> paramList)
  {
    AppMethodBeat.i(117019);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact where (" + JeQ + ") and (" + hK(paramList) + ")" + fuA() + " and (username like  '%@openim' )";
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117019);
    return paramList;
  }
  
  public final Cursor hO(List<String> paramList)
  {
    AppMethodBeat.i(117020);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + s(paramList, false) + fuA();
    ae.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117020);
    return paramList;
  }
  
  public final Cursor hP(List<String> paramList)
  {
    AppMethodBeat.i(117021);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact " + hT(paramList) + fuA();
    ae.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117021);
    return paramList;
  }
  
  public final List<String> hQ(List<String> paramList)
  {
    AppMethodBeat.i(117025);
    if (paramList.isEmpty())
    {
      ae.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
      paramList = new LinkedList();
      AppMethodBeat.o(117025);
      return paramList;
    }
    long l = bu.HQ();
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
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(com.tencent.mm.contact.c.adm()), localStringBuilder.toString() });
    ae.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    ae.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[] { Long.valueOf(bu.aO(l)), paramList, localLinkedList.toString() });
    AppMethodBeat.o(117025);
    return localLinkedList;
  }
  
  public final int[] hR(List<String> paramList)
  {
    AppMethodBeat.i(117028);
    paramList = "select distinct showHead from rcontact  where (" + hK(paramList) + ") " + fuz();
    long l = System.currentTimeMillis();
    paramList = this.db.rawQuery(paramList, null);
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramList.getCount() >= 0) {}
    int[] arrayOfInt;
    for (int i = paramList.getCount();; i = 0)
    {
      ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
  
  public final int[] hS(List<String> paramList)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(117030);
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + hK(paramList);
    paramList = paramList + " group by showHead";
    Cursor localCursor = this.db.a(paramList, null, 2);
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = localCursor.getCount();
    ae.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
  
  public final Cursor md(String paramString1, String paramString2)
  {
    AppMethodBeat.i(185151);
    paramString1 = "select username from rcontact " + f(paramString1, paramString2, null);
    ae.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(185151);
    return paramString1;
  }
  
  public final int me(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117059);
    ae.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { bu.bI(paramString1, ""), Integer.valueOf(bu.bI(paramString2, "").length()) });
    an localan = aUW(paramString1);
    if (localan != null)
    {
      if (bu.lX(localan.field_ticket, paramString2))
      {
        AppMethodBeat.o(117059);
        return 0;
      }
      localan.tz(paramString2);
      int i = c(paramString1, localan);
      AppMethodBeat.o(117059);
      return i;
    }
    AppMethodBeat.o(117059);
    return 0;
  }
  
  public final Cursor r(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117016);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid  from rcontact  where " + hK(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + fuz();
    }
    ae.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117016);
    return paramList;
  }
  
  static final class a
    implements bq.a
  {
    ConcurrentHashMap<bq.a, Object> Ffv;
    
    private a()
    {
      AppMethodBeat.i(211754);
      this.Ffv = new ConcurrentHashMap();
      AppMethodBeat.o(211754);
    }
    
    public final an BH(String paramString)
    {
      AppMethodBeat.i(211756);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext())
      {
        bq.a locala = (bq.a)localIterator.next();
        an localan = locala.BH(paramString);
        if (localan != null)
        {
          ae.i("MicroMsg.ContactStorage", "[get] contact=%s listener=%s", new Object[] { localan.field_username, locala });
          AppMethodBeat.o(211756);
          return localan;
        }
      }
      AppMethodBeat.o(211756);
      return null;
    }
    
    public final void a(bq parambq, an paraman)
    {
      AppMethodBeat.i(211755);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext()) {
        ((bq.a)localIterator.next()).a(parambq, paraman);
      }
      AppMethodBeat.o(211755);
    }
    
    public final int b(an paraman, boolean paramBoolean)
    {
      AppMethodBeat.i(211757);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext())
      {
        bq.a locala = (bq.a)localIterator.next();
        int i = locala.b(paraman, paramBoolean);
        if (i > 0)
        {
          ae.i("MicroMsg.ContactStorage", "[replace] ret=%s listener=%s", new Object[] { Integer.valueOf(i), locala });
          AppMethodBeat.o(211757);
          return i;
        }
      }
      AppMethodBeat.o(211757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */