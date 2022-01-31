package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.d;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aj
  extends n
  implements bd
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private static String yMn;
  private static String yMo;
  private com.tencent.mm.sdk.e.e db;
  private final l<bd.a, ad> fuL;
  private com.tencent.mm.sdk.e.e yMk;
  public final com.tencent.mm.a.f<String, ad> yMl;
  public final com.tencent.mm.a.f<String, Integer> yMm;
  
  static
  {
    AppMethodBeat.i(1192);
    SQL_CREATE = new String[] { j.getCreateSQLs(ad.info, "rcontact"), j.getCreateSQLs(ad.info, "bottlecontact"), j.getCreateSQLs(ae.info, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
    INDEX_CREATE = new String[] { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) " };
    yMn = "showHead = 32";
    yMo = "type & 64 !=0 ";
    AppMethodBeat.o(1192);
  }
  
  public aj(h paramh)
  {
    AppMethodBeat.i(1106);
    this.yMl = new c(200);
    this.yMm = new c(400);
    this.fuL = new aj.1(this);
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
      localObject = j.getUpdateSQLs(a.info, "bottlecontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.execSQL("bottlecontact", (String)((Iterator)localObject).next());
      }
      localObject = j.getUpdateSQLs(a.info, "rcontact", paramh).iterator();
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
      this.yMk = paramh;
      AppMethodBeat.o(1106);
      return;
    }
  }
  
  private void OP(String paramString)
  {
    AppMethodBeat.i(1111);
    if (!bo.isNullOrNil(paramString))
    {
      this.yMl.remove(paramString);
      this.yMm.remove(paramString);
    }
    AppMethodBeat.o(1111);
  }
  
  private static String S(String[] paramArrayOfString)
  {
    AppMethodBeat.i(1170);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(1170);
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
    AppMethodBeat.o(1170);
    return paramArrayOfString;
  }
  
  private static String a(String paramString1, List<String> paramList1, String paramString2, List<String> paramList2)
  {
    AppMethodBeat.i(1117);
    paramString1 = paramString1 + " and OpenIMWordingInfo.language='" + paramString2 + "' ";
    String str = paramString1 + dwY();
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
    ab.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[] { paramString1 });
    AppMethodBeat.o(1117);
    return paramString1;
  }
  
  private static boolean aa(ad paramad)
  {
    boolean bool = false;
    AppMethodBeat.i(1189);
    if (paramad == null)
    {
      AppMethodBeat.o(1189);
      return false;
    }
    int i = paramad.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      ab.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paramad.field_username);
      AppMethodBeat.o(1189);
      return bool;
      bool = true;
    }
  }
  
  private static String af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(1175);
    String str2 = "type & " + a.NO() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + a.NR() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + a.NS() + "=0 ";
    str2 = str1 + " and type & " + a.NP() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + ad.dwB() + " =0 ";
    }
    AppMethodBeat.o(1175);
    return str1;
  }
  
  private static String aro(String paramString)
  {
    AppMethodBeat.i(1104);
    paramString = "select *,rowid from " + arp(paramString) + " ";
    AppMethodBeat.o(1104);
    return paramString;
  }
  
  private static String arp(String paramString)
  {
    AppMethodBeat.i(1105);
    if (ad.nM(paramString))
    {
      AppMethodBeat.o(1105);
      return "bottlecontact";
    }
    AppMethodBeat.o(1105);
    return "rcontact";
  }
  
  private static String dwR()
  {
    AppMethodBeat.i(1172);
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
    AppMethodBeat.o(1172);
    return localObject;
  }
  
  private static String dwS()
  {
    AppMethodBeat.i(1174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by case when verifyFlag & " + ad.dwB() + " != 0 then 0 else 1 end , showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(1174);
    return localObject;
  }
  
  private static String dwT()
  {
    AppMethodBeat.i(1176);
    String str = "type & " + a.NO() + " !=0 ";
    str = " where (" + str + ") and ";
    str = str + "type & " + a.NS() + " =0 and ";
    str = str + "type & " + a.NP() + " =0";
    AppMethodBeat.o(1176);
    return str;
  }
  
  private static String dwU()
  {
    AppMethodBeat.i(1177);
    String str = "type & " + a.NO() + "!=0";
    str = " where (" + str + ") and ";
    str = str + "type & " + a.NS() + "=0  ";
    AppMethodBeat.o(1177);
    return str;
  }
  
  private static String dwV()
  {
    AppMethodBeat.i(1178);
    String str = "type & " + a.NO() + "!=0";
    str = "( (" + str + ") and type & " + a.NP() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom'))";
    AppMethodBeat.o(1178);
    return str;
  }
  
  private static String dwW()
  {
    AppMethodBeat.i(1179);
    String str = "type & " + a.NO() + "!=0";
    str = "( (" + str + ") and type & " + a.NP() + "=0 and username like '%@talkroom')";
    AppMethodBeat.o(1179);
    return str;
  }
  
  private static String dwX()
  {
    AppMethodBeat.i(1180);
    String str = "type & " + a.NP() + "=0 and username like '%@openim'";
    AppMethodBeat.o(1180);
    return str;
  }
  
  private static String dwY()
  {
    AppMethodBeat.i(1181);
    String str = dwU() + " and " + dwX();
    AppMethodBeat.o(1181);
    return str;
  }
  
  private static String eG(List<String> paramList)
  {
    AppMethodBeat.i(1149);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(1149);
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
    AppMethodBeat.o(1149);
    return paramList;
  }
  
  private static String eH(List<String> paramList)
  {
    AppMethodBeat.i(1151);
    String str = eG(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    AppMethodBeat.o(1151);
    return paramList;
  }
  
  private static String eP(List<String> paramList)
  {
    AppMethodBeat.i(1183);
    Object localObject = af(false, false) + " AND " + yMo;
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
    AppMethodBeat.o(1183);
    return paramList;
  }
  
  private static String n(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(1182);
    String str2 = af(false, paramBoolean) + " AND " + yMo;
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
    AppMethodBeat.o(1182);
    return paramList;
  }
  
  private static String z(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(1169);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(1169);
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
    AppMethodBeat.o(1169);
    return paramString;
  }
  
  public final int F(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    AppMethodBeat.i(1135);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(1135);
      return -1;
    }
    ae localae = new ae();
    localae.field_cmdbuf = paramArrayOfByte;
    localae.field_username = paramString;
    int j = (int)this.db.replace("ContactCmdBuf", "username", localae.convertTo());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      ab.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(1135);
      return j;
      i = paramArrayOfByte.length;
    }
  }
  
  public final void V(ad paramad)
  {
    AppMethodBeat.i(1110);
    if ((paramad == null) || (paramad.field_username == null) || (paramad.field_type == 0))
    {
      AppMethodBeat.o(1110);
      return;
    }
    this.yMl.f(paramad.field_username, paramad);
    this.yMm.f(paramad.field_username, Integer.valueOf(paramad.field_type));
    AppMethodBeat.o(1110);
  }
  
  public final boolean W(ad paramad)
  {
    AppMethodBeat.i(1113);
    if (ary(paramad.field_username))
    {
      if (b(paramad.field_username, paramad) == 0)
      {
        AppMethodBeat.o(1113);
        return true;
      }
      AppMethodBeat.o(1113);
      return false;
    }
    if (Z(paramad) >= 0)
    {
      AppMethodBeat.o(1113);
      return true;
    }
    AppMethodBeat.o(1113);
    return false;
  }
  
  public final boolean X(ad paramad)
  {
    AppMethodBeat.i(1132);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("contact NULL !", bool);
      if (aa(paramad)) {
        break;
      }
      AppMethodBeat.o(1132);
      return true;
    }
    paramad.hs(paramad.Nu());
    this.fuL.cy(paramad);
    this.fuL.doNotify();
    ab.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
    ContentValues localContentValues = paramad.convertTo();
    if ((int)paramad.euF > 0) {
      localContentValues.put("rowid", Integer.valueOf((int)paramad.euF));
    }
    if (this.db.replace(arp(paramad.field_username), a.info.yrL, localContentValues) > 0L) {}
    for (int i = 1;; i = 0)
    {
      OP(paramad.field_username);
      if (!bo.isNullOrNil(paramad.field_encryptUsername)) {
        OP(paramad.field_encryptUsername);
      }
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(1132);
      return false;
    }
    b(4, this, paramad.field_username);
    AppMethodBeat.o(1132);
    return true;
  }
  
  public final boolean Y(ad paramad)
  {
    AppMethodBeat.i(1133);
    if (Z(paramad) > 0)
    {
      AppMethodBeat.o(1133);
      return true;
    }
    AppMethodBeat.o(1133);
    return false;
  }
  
  public final int Z(ad paramad)
  {
    AppMethodBeat.i(1134);
    if (bo.nullAsNil(paramad.field_username).length() <= 0)
    {
      ab.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      AppMethodBeat.o(1134);
      return -1;
    }
    paramad.hs(paramad.Nu());
    this.fuL.cy(paramad);
    this.fuL.doNotify();
    Object localObject = paramad.convertTo();
    long l = System.currentTimeMillis();
    int k = (int)this.db.insert(arp(paramad.field_username), a.info.yrL, (ContentValues)localObject);
    int m = (int)bo.hl(l);
    boolean bool = b.foreground;
    localObject = com.tencent.mm.plugin.report.e.qrI;
    int i;
    if (bool)
    {
      i = 11;
      if (!bool) {
        break label251;
      }
    }
    label251:
    for (int j = 12;; j = 15)
    {
      ((com.tencent.mm.plugin.report.e)localObject).d(463, i, j, m, false);
      ab.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      if (k == -1) {
        break label257;
      }
      paramad.euF = k;
      V(paramad);
      b(2, this, paramad.field_username);
      AppMethodBeat.o(1134);
      return k;
      i = 14;
      break;
    }
    label257:
    ab.e("MicroMsg.ContactStorage", "insert failed: username=" + paramad.field_username);
    AppMethodBeat.o(1134);
    return -1;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(1115);
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + f(paramString1, paramString2, paramList1) + eG(paramList2) + dwR();
    ab.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + n(paramList1, paramBoolean2) + dwS();
      ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.a(paramString2, null, 4);
      paramString1 = this.db.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.cg.a.f)) && ((paramString1 instanceof com.tencent.mm.cg.a.f)))
      {
        paramString1 = new com.tencent.mm.cg.a.e(new com.tencent.mm.cg.a.f[] { (com.tencent.mm.cg.a.f)paramString2, (com.tencent.mm.cg.a.f)paramString1 });
        AppMethodBeat.o(1115);
        return paramString1;
      }
      paramString1 = d.dzJ();
      AppMethodBeat.o(1115);
      return paramString1;
    }
    paramString1 = this.db.a(paramString1, null, 4);
    AppMethodBeat.o(1115);
    return paramString1;
  }
  
  public final Cursor a(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(1118);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(1118);
    return paramList1;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(1168);
    paramArrayOfString = "select * ,rowid from rcontact " + f(paramString1, paramString2, paramList2) + S(paramArrayOfString) + z(paramString2, paramList1) + dwR();
    ab.i("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(1168);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(1167);
    paramString = "select * ,rowid from rcontact " + f(paramString, null, paramList) + S(paramArrayOfString);
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
    ab.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(paramList)));
    paramArrayOfString = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1167);
    return paramArrayOfString;
  }
  
  public final void a(bd.a parama)
  {
    AppMethodBeat.i(1107);
    this.fuL.a(parama, null);
    AppMethodBeat.o(1107);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(156734);
    String str = dwR();
    AppMethodBeat.o(156734);
    return str;
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(1188);
    if ((this.db == null) || (this.db.dun()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.dun()))
      {
        ab.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(1188);
        return false;
      }
    }
    AppMethodBeat.o(1188);
    return true;
  }
  
  public final byte[] arA(String paramString)
  {
    AppMethodBeat.i(1136);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(1136);
      return null;
    }
    ae localae = new ae();
    Cursor localCursor = this.db.a("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localae.convertFrom(localCursor);
    }
    localCursor.close();
    if (localae.field_cmdbuf == null) {}
    for (int i = -1;; i = localae.field_cmdbuf.length)
    {
      ab.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      paramString = localae.field_cmdbuf;
      AppMethodBeat.o(1136);
      return paramString;
    }
  }
  
  public final int arB(String paramString)
  {
    AppMethodBeat.i(1137);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
      AppMethodBeat.o(1137);
      return -1;
    }
    int i = this.db.delete("ContactCmdBuf", "username=?", new String[] { String.valueOf(paramString) });
    ab.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(1137);
    return i;
  }
  
  public final int arC(String paramString)
  {
    AppMethodBeat.i(1138);
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (ad.nM(paramString)) {
        str = ad.ark(paramString);
      }
      OP(str);
      paramString = new ad(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + bo.aoy());
      paramString.jv("fake_" + bo.aoy());
      paramString.setSource(0);
      i = this.db.update(arp(str), paramString.convertTo(), "username=?", new String[] { String.valueOf(str) });
      arB(str);
      ab.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[] { str, Integer.valueOf(i), bo.dtY() });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(1138);
      return i;
    }
    b(5, this, str);
    AppMethodBeat.o(1138);
    return i;
  }
  
  public final String arD(String paramString)
  {
    AppMethodBeat.i(1171);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(1171);
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
    AppMethodBeat.o(1171);
    return paramString;
  }
  
  public final ad arq(String paramString)
  {
    AppMethodBeat.i(1109);
    paramString = (ad)this.yMl.Y(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(1109);
      return paramString;
    }
    AppMethodBeat.o(1109);
    return null;
  }
  
  public final boolean arr(String paramString)
  {
    AppMethodBeat.i(1112);
    if ((bo.isNullOrNil(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger"))))
    {
      AppMethodBeat.o(1112);
      return false;
    }
    Object localObject = (Integer)this.yMm.get(paramString);
    if (localObject != null)
    {
      bool = a.je(((Integer)localObject).intValue());
      AppMethodBeat.o(1112);
      return bool;
    }
    localObject = arw(paramString);
    if ((localObject == null) || ((!((aq)localObject).field_username.equals(paramString)) && (!paramString.equals(((aq)localObject).field_encryptUsername))))
    {
      this.yMm.f(paramString, Integer.valueOf(0));
      AppMethodBeat.o(1112);
      return false;
    }
    this.yMm.f(paramString, Integer.valueOf(((aq)localObject).field_type));
    boolean bool = a.je(((aq)localObject).field_type);
    AppMethodBeat.o(1112);
    return bool;
  }
  
  public final ad ars(String paramString)
  {
    AppMethodBeat.i(1114);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1114);
      return null;
    }
    ad localad = new ad();
    paramString = "select *,rowid from rcontact where alias=" + h.escape(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localad.convertFrom(paramString);
      V(localad);
    }
    paramString.close();
    localad.dwE();
    AppMethodBeat.o(1114);
    return localad;
  }
  
  public final Cursor art(String paramString)
  {
    AppMethodBeat.i(1121);
    paramString = this.db.a(paramString, null, 4);
    AppMethodBeat.o(1121);
    return paramString;
  }
  
  public final ad aru(String paramString)
  {
    AppMethodBeat.i(1125);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1125);
      return null;
    }
    Object localObject = paramString;
    if (ad.nM(paramString)) {
      localObject = ad.ark(paramString);
    }
    paramString = arq((String)localObject);
    if (paramString != null)
    {
      paramString.dwE();
      AppMethodBeat.o(1125);
      return paramString;
    }
    paramString = new ad();
    localObject = aro((String)localObject) + " where username=" + h.escape((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      V(paramString);
    }
    ((Cursor)localObject).close();
    paramString.dwE();
    AppMethodBeat.o(1125);
    return paramString;
  }
  
  public final ad arv(String paramString)
  {
    AppMethodBeat.i(1126);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1126);
      return null;
    }
    Object localObject = paramString;
    if (ad.nM(paramString)) {
      localObject = ad.ark(paramString);
    }
    paramString = arq((String)localObject);
    if (paramString != null)
    {
      AppMethodBeat.o(1126);
      return paramString;
    }
    paramString = new ad();
    localObject = aro((String)localObject) + " where username=" + h.escape((String)localObject) + " or encryptUsername=" + h.escape((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      V(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1126);
    return paramString;
  }
  
  public final ad arw(String paramString)
  {
    AppMethodBeat.i(1127);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1127);
      return null;
    }
    Object localObject = paramString;
    if (ad.nM(paramString)) {
      localObject = ad.ark(paramString);
    }
    paramString = arq((String)localObject);
    if (paramString != null)
    {
      AppMethodBeat.o(1127);
      return paramString;
    }
    paramString = new ad();
    localObject = aro((String)localObject) + " where username=" + h.escape((String)localObject) + " or encryptUsername=" + h.escape((String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString.dwE();
      V(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(1127);
      return paramString;
      ((Cursor)localObject).close();
    }
  }
  
  public final long arx(String paramString)
  {
    AppMethodBeat.i(1129);
    long l2 = -1L;
    paramString = arw(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.euF > 0L) {
        l1 = (int)paramString.euF;
      }
    }
    AppMethodBeat.o(1129);
    return l1;
  }
  
  public final boolean ary(String paramString)
  {
    AppMethodBeat.i(1130);
    ad localad = arw(paramString);
    if ((localad != null) && (!bo.isNullOrNil(localad.field_username)) && (localad.field_username.equals(paramString)))
    {
      AppMethodBeat.o(1130);
      return true;
    }
    AppMethodBeat.o(1130);
    return false;
  }
  
  public final boolean arz(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(1131);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1131);
      return false;
    }
    paramString = "select count(*) from " + arp(paramString) + " where type & " + a.NP() + " !=0 and username=" + h.escape(paramString);
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
    AppMethodBeat.o(1131);
    return bool1;
  }
  
  public final int b(String paramString, ad paramad)
  {
    AppMethodBeat.i(1139);
    ab.i("MicroMsg.ContactStorage", "begin to update contact : ".concat(String.valueOf(paramString)));
    if (!aa(paramad))
    {
      AppMethodBeat.o(1139);
      return 1;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (ad.nM(paramString)) {
      str = ad.ark(paramString);
    }
    paramad.hs(paramad.Nu());
    this.fuL.cy(paramad);
    this.fuL.doNotify();
    paramString = paramad.convertTo();
    if ((int)paramad.euF > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramad.euF));
    }
    if (paramString.size() > 0) {}
    for (int i = this.db.update(arp(str), paramString, "username=?", new String[] { String.valueOf(str) });; i = 0)
    {
      ab.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      OP(str);
      if (!bo.isNullOrNil(paramad.field_encryptUsername)) {
        OP(paramad.field_encryptUsername);
      }
      if (i != 0) {
        b(4, this, str);
      }
      AppMethodBeat.o(1139);
      return i;
    }
  }
  
  public final int b(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(1185);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.NO()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.NS()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.NP()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8 = 0 and ");
    localStringBuilder.append("( username not like '%@%')");
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
      ab.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      AppMethodBeat.o(1185);
      return i;
      i = 0;
    }
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(1124);
    paramString1 = "select username from rcontact " + f(paramString1, paramString2, paramList1) + eG(paramList2) + dwR();
    ab.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + n(paramList1, paramBoolean2) + dwS();
      ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.a(paramString2, null, 4);
      paramString1 = this.db.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.cg.a.f)) && ((paramString1 instanceof com.tencent.mm.cg.a.f)))
      {
        paramString1 = new com.tencent.mm.cg.a.e(new com.tencent.mm.cg.a.f[] { (com.tencent.mm.cg.a.f)paramString2, (com.tencent.mm.cg.a.f)paramString1 });
        AppMethodBeat.o(1124);
        return paramString1;
      }
      paramString1 = d.dzJ();
      AppMethodBeat.o(1124);
      return paramString1;
    }
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(1124);
    return paramString1;
  }
  
  public final Cursor b(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(1119);
    paramList1 = a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    ab.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(1119);
    return paramList1;
  }
  
  public final void b(bd.a parama)
  {
    AppMethodBeat.i(1108);
    if (this.fuL != null) {
      this.fuL.remove(parama);
    }
    AppMethodBeat.o(1108);
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(1161);
    paramString1 = "select distinct showHead from rcontact " + f(paramString1, paramString2, paramList) + S(paramArrayOfString) + dwR();
    long l = System.currentTimeMillis();
    paramString1 = this.db.rawQuery(paramString1, null);
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(1161);
    return paramString2;
  }
  
  public final int c(String paramString, ad paramad)
  {
    int i = 0;
    AppMethodBeat.i(1140);
    if ((bo.isNullOrNil(paramString)) || (paramad == null) || (bo.isNullOrNil(paramad.field_username)))
    {
      ab.e("MicroMsg.ContactStorage", "update : wrong input!");
      AppMethodBeat.o(1140);
      return 0;
    }
    ab.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paramad.field_username + " enUsername: " + paramString);
    if (!aa(paramad))
    {
      AppMethodBeat.o(1140);
      return 1;
    }
    if (ad.nM(paramad.field_username)) {
      paramad.setUsername(ad.ark(paramad.field_username));
    }
    paramad.hs(paramad.Nu());
    this.fuL.cy(paramad);
    this.fuL.doNotify();
    ab.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramString, paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
    ContentValues localContentValues = paramad.convertTo();
    ad localad;
    int j;
    if (paramad.euF <= 0L)
    {
      localad = new ad(paramString);
      localad.setType(0);
      localad.setUsername("fake_" + bo.aoy());
      localad.jv("fake_" + bo.aoy());
      j = this.db.update(arp(paramString), localad.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
      ab.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + arp(paramString) + " user :" + paramString + ", res:" + j);
      if (localContentValues.size() > 0) {
        i = (int)this.db.replace(arp(paramad.field_username), a.info.yrL, localContentValues);
      }
    }
    for (;;)
    {
      OP(paramad.field_username);
      if (!bo.isNullOrNil(paramad.field_encryptUsername)) {
        OP(paramad.field_encryptUsername);
      }
      b(3, this, paramString);
      b(3, this, paramad.field_username);
      AppMethodBeat.o(1140);
      return i;
      if (paramString.equals(paramad.field_username))
      {
        if (localContentValues.size() > 0)
        {
          i = this.db.update(arp(paramad.field_username), localContentValues, "rowid=?", new String[] { paramad.euF });
          ab.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paramad.field_username, Integer.valueOf(i), Long.valueOf(paramad.euF) });
        }
      }
      else
      {
        localad = new ad(paramString);
        localad.setType(0);
        localad.setUsername("fake_" + bo.aoy());
        localad.jv("fake_" + bo.aoy());
        j = this.db.update(arp(paramString), localad.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
        ab.d("MicroMsg.ContactStorage", "delete " + arp(paramString) + " user :" + paramString + ", res:" + j);
        if (localContentValues.size() > 0) {
          i = this.db.update(arp(paramad.field_username), localContentValues, "rowid=?", new String[] { paramad.euF });
        }
      }
    }
  }
  
  public final int c(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(1186);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.NO()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.NS()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.NP()).append(" =0 and ");
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
      ab.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      AppMethodBeat.o(1186);
      return i;
      i = 0;
    }
  }
  
  public final Cursor c(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(1150);
    paramString1 = "select * ,rowid from rcontact " + f(paramString1, paramString2, paramList) + eG(null) + dwR();
    ab.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(1150);
    return paramString1;
  }
  
  public final Cursor c(List<String> paramList1, String paramString, List<String> paramList2)
  {
    AppMethodBeat.i(1120);
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    ab.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    paramList1 = this.db.a(paramList1, null, 4);
    AppMethodBeat.o(1120);
    return paramList1;
  }
  
  public final int[] c(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(1162);
    paramString1 = "select distinct showHead from rcontact " + f(paramString1, paramString2, paramList) + arD(paramString3) + dwR();
    long l = System.currentTimeMillis();
    paramString1 = this.db.rawQuery(paramString1, null);
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(1162);
    return paramString2;
  }
  
  public final int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(1166);
    paramString1 = "select count(*) from rcontact " + f(paramString1, paramString2, paramList) + S(paramArrayOfString);
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
    AppMethodBeat.o(1166);
    return paramString1;
  }
  
  public final Cursor d(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(1157);
    paramString1 = c(paramString1, paramString2, paramList);
    AppMethodBeat.o(1157);
    return paramString1;
  }
  
  public final void d(String paramString, ad paramad)
  {
    AppMethodBeat.i(1141);
    if (paramString == null)
    {
      AppMethodBeat.o(1141);
      return;
    }
    String str = paramString;
    if (ad.nM(paramString)) {
      str = ad.ark(paramString);
    }
    paramad.hs(paramad.Nu());
    if (t.e(paramad))
    {
      paramad.hs(43);
      paramad.jq(g.wr(paramad.Oe()));
      paramad.jr(g.wq(paramad.Oe()));
      paramad.jt(g.wq(paramad.Of()));
      paramad.ju(paramad.Of());
      AppMethodBeat.o(1141);
      return;
    }
    if (t.ot(paramad.field_username))
    {
      ab.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
      paramad.hs(31);
    }
    this.fuL.cy(paramad);
    this.fuL.doNotify();
    ab.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
    paramString = paramad.convertTo();
    if ((int)paramad.euF > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramad.euF));
    }
    if (paramString.size() > 0) {
      this.db.update(arp(str), paramString, "username=?", new String[] { String.valueOf(str) });
    }
    AppMethodBeat.o(1141);
  }
  
  public final int[] d(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(1164);
    long l = System.currentTimeMillis();
    paramString1 = "select count(*) from rcontact " + f(paramString1, paramString2, paramList) + arD(paramString3);
    paramString1 = paramString1 + " group by showHead";
    paramString3 = this.db.rawQuery(paramString1, null);
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = paramString3.getCount();
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
    paramString1 = localObject;
    if (j > 0)
    {
      paramString2 = new int[j];
      int i = 0;
      for (;;)
      {
        paramString1 = paramString2;
        if (i >= j) {
          break;
        }
        paramString3.moveToPosition(i);
        paramString2[i] = paramString3.getInt(0);
        i += 1;
      }
    }
    paramString3.close();
    AppMethodBeat.o(1164);
    return paramString1;
  }
  
  public final List<String> dwK()
  {
    AppMethodBeat.i(1116);
    Object localObject = " select openImAppid from rcontact" + dwY() + " group by openImAppid ";
    localObject = " select acctTypeId from OpenIMAppIdInfo where appid in (" + (String)localObject + ") group by acctTypeId";
    localObject = this.db.a((String)localObject, null, 4);
    LinkedList localLinkedList = new LinkedList();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        String str = ((Cursor)localObject).getString(0);
        if (!bo.isNullOrNil(str)) {
          localLinkedList.add(str);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1116);
    return localLinkedList;
  }
  
  public final List<String> dwL()
  {
    AppMethodBeat.i(1144);
    Object localObject = "select username from rcontact where " + dwV();
    localObject = this.db.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      AppMethodBeat.o(1144);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        localArrayList.add(((Cursor)localObject).getString(0));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1144);
    return localArrayList;
  }
  
  public final Cursor dwM()
  {
    AppMethodBeat.i(1145);
    Object localObject = "select * ,rowid from rcontact  where " + new StringBuilder("type & ").append(a.NP()).append("=0 and username like '%@chatroom'").toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1145);
    return localObject;
  }
  
  public final Cursor dwN()
  {
    AppMethodBeat.i(1146);
    Object localObject = "select * ,rowid from rcontact " + dwU() + " AND type & 256 !=0 " + dwR();
    ab.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1146);
    return localObject;
  }
  
  public final Cursor dwO()
  {
    AppMethodBeat.i(1147);
    Object localObject = "select * ,rowid from rcontact  where " + yMo + " and verifyFlag & " + ad.dwB() + " !=0 ";
    ab.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1147);
    return localObject;
  }
  
  public final Cursor dwP()
  {
    AppMethodBeat.i(1148);
    Object localObject = "select * ,rowid from rcontact " + dwU() + " AND " + yMo + " AND " + yMn + dwS();
    ab.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1148);
    return localObject;
  }
  
  public final int dwQ()
  {
    int i = 0;
    AppMethodBeat.i(1159);
    Object localObject = "select count(rowid) from rcontact " + f("@biz.contact", null, null);
    ab.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1159);
    return i;
  }
  
  public final Cursor dwZ()
  {
    AppMethodBeat.i(1187);
    Cursor localCursor = this.db.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    AppMethodBeat.o(1187);
    return localCursor;
  }
  
  public final Cursor dxa()
  {
    AppMethodBeat.i(1190);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(a.NO()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.NS()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.NP()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0 and ");
    ((StringBuilder)localObject).append("( username not like '%@%')");
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.a((String)localObject, null, 2);
    ab.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[] { localObject });
    AppMethodBeat.o(1190);
    return localCursor;
  }
  
  public final Cursor dxb()
  {
    AppMethodBeat.i(1191);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(a.NO()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.NS()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.NP()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0 and ");
    ((StringBuilder)localObject).append("( username not like '%@%')");
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = this.db.a(((StringBuilder)localObject).toString(), null, 2);
    AppMethodBeat.o(1191);
    return localObject;
  }
  
  public final Cursor e(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(1158);
    paramString1 = "select * ,rowid from rcontact " + f(paramString1, paramString2, paramList) + dwR();
    ab.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(1158);
    return paramString1;
  }
  
  public final Cursor eC(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(1122);
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
    paramList = str + dwR();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1122);
    return paramList;
  }
  
  public final Cursor eD(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(1123);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ";
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
    paramList = str + dwR();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1123);
    return paramList;
  }
  
  public final Cursor eE(List<String> paramList)
  {
    int i = 0;
    AppMethodBeat.i(1142);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where ";
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
    paramList = str + dwR();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1142);
    return paramList;
  }
  
  public final Cursor eF(List<String> paramList)
  {
    int j = 0;
    AppMethodBeat.i(1143);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where (";
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
    ab.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1143);
    return paramList;
  }
  
  public final Cursor eI(List<String> paramList)
  {
    AppMethodBeat.i(1153);
    paramList = "select * ,rowid from rcontact where (" + yMo + ") and (" + eH(paramList) + ")" + dwS();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1153);
    return paramList;
  }
  
  public final Cursor eJ(List<String> paramList)
  {
    AppMethodBeat.i(1154);
    paramList = "select * ,rowid from rcontact where (" + yMo + ") and (" + eH(paramList) + ")" + dwS() + " and (username like  '%@openim' )";
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1154);
    return paramList;
  }
  
  public final Cursor eK(List<String> paramList)
  {
    AppMethodBeat.i(1155);
    paramList = "select * ,rowid from rcontact " + n(paramList, false) + dwS();
    ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1155);
    return paramList;
  }
  
  public final Cursor eL(List<String> paramList)
  {
    AppMethodBeat.i(1156);
    paramList = "select * ,rowid from rcontact " + eP(paramList) + dwS();
    ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1156);
    return paramList;
  }
  
  public final List<String> eM(List<String> paramList)
  {
    AppMethodBeat.i(1160);
    if (paramList.isEmpty())
    {
      ab.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
      paramList = new LinkedList();
      AppMethodBeat.o(1160);
      return paramList;
    }
    long l = bo.yB();
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
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(a.NO()), localStringBuilder.toString() });
    ab.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    ab.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[] { Long.valueOf(bo.av(l)), paramList, localLinkedList.toString() });
    AppMethodBeat.o(1160);
    return localLinkedList;
  }
  
  public final int[] eN(List<String> paramList)
  {
    AppMethodBeat.i(1163);
    paramList = "select distinct showHead from rcontact  where (" + eH(paramList) + ") " + dwR();
    long l = System.currentTimeMillis();
    paramList = this.db.rawQuery(paramList, null);
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramList.getCount() >= 0) {}
    int[] arrayOfInt;
    for (int i = paramList.getCount();; i = 0)
    {
      ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(1163);
    return arrayOfInt;
  }
  
  public final int[] eO(List<String> paramList)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(1165);
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + eH(paramList);
    paramList = paramList + " group by showHead";
    Cursor localCursor = this.db.a(paramList, null, 2);
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = localCursor.getCount();
    ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    AppMethodBeat.o(1165);
    return paramList;
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
    AppMethodBeat.i(1184);
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + af(true, false);
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
        paramString1 = "" + dwU();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = new StringBuilder().append("");
        paramString2 = "(type & " + a.NO() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom'))";
        paramString2 = " where (" + paramString2 + ") and ";
        paramString1 = new StringBuilder().append(paramString2).append("type & ").append(a.NS()).append("=0 ").toString();
      }
      else
      {
        if (paramString1.equals("@all.contact.without.chatroom"))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = af(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (;;)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + dwW() + ')' + " or (" + dwX() + ")";
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
            bool1 = false;
          }
        }
        if ((paramString1.equals("@all.contact.without.chatroom.without.openim")) || (paramString1.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = af(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (bool1 = bool2;; bool1 = false)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + dwW() + ')';
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
          }
        }
        if (paramString1.equals("@black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.NP()).append("!=0").toString();
        }
        else if (paramString1.equals("@werun.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.NQ()).append("!=0").toString();
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
            str1 = af(true, false);
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
            paramString2 = af(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool4;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + dwV() + ')';
              String str2 = " or (" + dwW() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(str2).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.NO() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + a.NS() + " =0 and ";
            paramString2 = paramString2 + "type & " + a.NP() + " =0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.dwB() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool5;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + dwV() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = dwT();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool6;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + dwV() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com.openim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = dwT();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool7;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + dwV() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(" or (username like '%@openim'))").toString();
              break;
            }
          }
          if (paramString1.equals("@qqim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = af(false, false);
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
            paramString2 = "type & " + a.NO() + " !=0";
            paramString2 = paramString2 + " or type & 2 !=0";
            paramString2 = paramString2 + " or type & 4 !=0";
            paramString2 = paramString2 + " or 1";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@verify.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.NO() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.dwA() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@biz.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.NO() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.dwB() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@all.weixin.android"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.NO() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@openim.contact"))
          {
            paramString1 = "" + dwY();
          }
          else
          {
            ab.d("MicroMsg.ContactStorage", "unknow role type");
            paramString1 = "" + af(false, false);
          }
        }
      }
    }
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(1184);
    return paramString1;
  }
  
  public final Cursor m(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(1152);
    String str = "select * ,rowid from rcontact  where " + eH(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + dwR();
    }
    ab.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1152);
    return paramList;
  }
  
  public final ad on(long paramLong)
  {
    ad localad = null;
    AppMethodBeat.i(1128);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(1128);
      return null;
    }
    Object localObject = "select * ,rowid from rcontact  where rowid=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localad = new ad();
      localad.convertFrom((Cursor)localObject);
      V(localad);
    }
    ((Cursor)localObject).close();
    if (localad != null) {
      localad.dwE();
    }
    AppMethodBeat.o(1128);
    return localad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.aj
 * JD-Core Version:    0.7.0.1
 */