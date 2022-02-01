package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.Event;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ba
  extends MStorageEx
  implements bx
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private static String adio;
  private static String adip;
  public final com.tencent.mm.b.f<String, Integer> adim;
  private a adin;
  private StorageObserverOwner<au> adiq;
  private ISQLiteDatabase db;
  public final com.tencent.mm.b.f<String, au> prM;
  
  static
  {
    AppMethodBeat.i(117060);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(au.info, "rcontact"), MAutoStorage.getCreateSQLs(au.info, "bottlecontact"), MAutoStorage.getCreateSQLs(av.info, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
    INDEX_CREATE = new String[] { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) ", "CREATE INDEX IF NOT EXISTS contact_usernameflag_index ON rcontact ( usernameFlag ) " };
    adio = "showHead = 32";
    adip = "type & 64 !=0  AND type >= 64";
    AppMethodBeat.o(117060);
  }
  
  public ba(h paramh)
  {
    AppMethodBeat.i(116970);
    this.prM = new c(200);
    this.adim = new c(400);
    this.adin = new a((byte)0);
    this.adiq = new StorageObserverOwner();
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
      AppMethodBeat.o(116970);
      return;
    }
  }
  
  private static String P(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117047);
    String str = bH(false, paramBoolean) + " AND " + adip;
    paramList = nc(paramList);
    paramList = str + paramList;
    AppMethodBeat.o(117047);
    return paramList;
  }
  
  private static String S(String paramString, List<String> paramList)
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
  
  private static String a(String paramString1, List<String> paramList1, String paramString2, List<String> paramList2)
  {
    AppMethodBeat.i(116981);
    paramString1 = paramString1 + " and OpenIMWordingInfo.language='" + paramString2 + "' ";
    String str = paramString1 + jak();
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
    paramString1 = str + paramString1;
    paramList1 = nc(paramList1);
    paramString1 = paramString1 + paramList1;
    Log.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[] { paramString1 });
    AppMethodBeat.o(116981);
    return paramString1;
  }
  
  private static boolean aD(au paramau)
  {
    boolean bool = false;
    AppMethodBeat.i(117054);
    if (paramau == null)
    {
      AppMethodBeat.o(117054);
      return false;
    }
    int i = paramau.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paramau.field_username);
      AppMethodBeat.o(117054);
      return bool;
      bool = true;
    }
  }
  
  private static String aa(String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(117035);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(117035);
      return "";
    }
    if (paramArrayOfString.length >= 500)
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
        break label303;
      }
      localObject = (String)localObject + " or ";
    }
    label303:
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
  
  private static String bH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(117040);
    String str2 = "type & " + com.tencent.mm.contact.d.aSp() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + com.tencent.mm.contact.d.aSz() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + com.tencent.mm.contact.d.aSA() + "=0 ";
    str2 = str1 + " and type & " + com.tencent.mm.contact.d.aSq() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + au.iZH() + " =0 ";
    }
    AppMethodBeat.o(117040);
    return str1;
  }
  
  private static String bxE(String paramString)
  {
    AppMethodBeat.i(248881);
    paramString = " where username like '%" + paramString + "'";
    AppMethodBeat.o(248881);
    return paramString;
  }
  
  private static String bxF(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(248905);
    String str = bH(true, false);
    if ((str != null) && (str.length() > 0)) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      paramString = str + " and domainList like '%" + paramString + "%'";
      AppMethodBeat.o(248905);
      return paramString;
      bool = false;
    }
  }
  
  private au bxI(String paramString)
  {
    AppMethodBeat.i(117058);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    if (au.bwS(paramString))
    {
      AppMethodBeat.o(117058);
      return null;
    }
    au localau = new au();
    paramString = "select  *,rowid  from rcontact where username=" + h.EQ(paramString) + " or encryptUsername=" + h.EQ(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localau.convertFrom(paramString);
      paramString.close();
      localau.iZK();
      d(localau, false);
    }
    for (;;)
    {
      AppMethodBeat.o(117058);
      return localau;
      paramString.close();
    }
  }
  
  private au bxJ(String paramString)
  {
    AppMethodBeat.i(248954);
    au localau = new au();
    paramString = bxo(paramString) + " where username=" + h.EQ(paramString) + " or encryptUsername=" + h.EQ(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localau.convertFrom(paramString);
      paramString.close();
      localau.iZK();
      d(localau, false);
    }
    for (;;)
    {
      AppMethodBeat.o(248954);
      return localau;
      paramString.close();
    }
  }
  
  private static String bxo(String paramString)
  {
    AppMethodBeat.i(116968);
    if (au.bwS(paramString))
    {
      paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "bottlecontact";
      AppMethodBeat.o(116968);
      return paramString;
    }
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "rcontact";
    AppMethodBeat.o(116968);
    return paramString;
  }
  
  private static String bxp(String paramString)
  {
    AppMethodBeat.i(116969);
    if (au.bwS(paramString))
    {
      AppMethodBeat.o(116969);
      return "bottlecontact";
    }
    AppMethodBeat.o(116969);
    return "rcontact";
  }
  
  private static String iZY()
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
  
  private static String iZZ()
  {
    AppMethodBeat.i(117039);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by case when verifyFlag & " + au.iZH() + " != 0 then 0 else 1 end , showHead asc, ");
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
  
  private static String jaA()
  {
    AppMethodBeat.i(248922);
    String str1 = bH(false, false);
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jai() + ')';
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2 });
      AppMethodBeat.o(248922);
      return str1;
    }
  }
  
  private static String jaB()
  {
    AppMethodBeat.i(248927);
    String str1 = jaa();
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jah() + ')';
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2 });
      AppMethodBeat.o(248927);
      return str1;
    }
  }
  
  private static String jaC()
  {
    AppMethodBeat.i(248931);
    String str1 = jaa();
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jah() + ')';
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2, " or ((username like '%@openim'))" });
      AppMethodBeat.o(248931);
      return str1;
    }
  }
  
  private static String jaD()
  {
    AppMethodBeat.i(248935);
    String str1 = "type & " + com.tencent.mm.contact.d.aSp() + " !=0 ";
    str1 = " where (" + str1 + ") and ";
    str1 = str1 + "type & " + com.tencent.mm.contact.d.aSA() + " =0 and ";
    str1 = str1 + "type & " + com.tencent.mm.contact.d.aSq() + " =0 and ";
    str1 = str1 + "verifyFlag & " + au.iZH() + " =0";
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jah() + ')';
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2 });
      AppMethodBeat.o(248935);
      return str1;
    }
  }
  
  private static String jaa()
  {
    AppMethodBeat.i(117041);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + " !=0 ";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.d.aSA() + " =0 and ";
    str = str + "type & " + com.tencent.mm.contact.d.aSq() + " =0";
    AppMethodBeat.o(117041);
    return str;
  }
  
  private static String jab()
  {
    AppMethodBeat.i(248791);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + " != 0 and ";
    str = str + "verifyFlag & " + au.iZG() + " != 0";
    str = " where (" + str + ") ";
    AppMethodBeat.o(248791);
    return str;
  }
  
  private static String jac()
  {
    AppMethodBeat.i(248794);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + " != 0 and ";
    str = str + "verifyFlag & " + au.iZH() + " != 0";
    str = " where (" + str + ") ";
    AppMethodBeat.o(248794);
    return str;
  }
  
  private static String jad()
  {
    AppMethodBeat.i(248797);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + " != 0 or  (username not like '%@qqim' and username not like '%@qr" + "' and username not like '%@bottle' and username not like '%@fb" + "' and username not like '%@google' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')";
    str = " where (" + str + ") ";
    AppMethodBeat.o(248797);
    return str;
  }
  
  private static String jae()
  {
    AppMethodBeat.i(248803);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + " !=0";
    str = str + " or type & 2 !=0";
    str = str + " or type & 4 !=0";
    str = str + " or 1";
    str = " where (" + str + ") ";
    AppMethodBeat.o(248803);
    return str;
  }
  
  private static String jaf()
  {
    AppMethodBeat.i(117042);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + "!=0";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.d.aSA() + "=0  ";
    AppMethodBeat.o(117042);
    return str;
  }
  
  private static String jag()
  {
    AppMethodBeat.i(248811);
    String str = "(type & " + com.tencent.mm.contact.d.aSp() + "!=0" + ab.c("username", new String[] { "@chatroom", "@im.chatroom" }, new String[0]) + ")";
    str = " where (" + str + ") and ";
    str = str + "type & " + com.tencent.mm.contact.d.aSA() + "=0 ";
    AppMethodBeat.o(248811);
    return str;
  }
  
  private static String jah()
  {
    AppMethodBeat.i(117043);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.d.aSq() + "=0" + ab.c("username", new String[] { "@chatroom", "@im.chatroom" }, new String[0]) + ")";
    AppMethodBeat.o(117043);
    return str;
  }
  
  private static String jai()
  {
    AppMethodBeat.i(117044);
    String str = "type & " + com.tencent.mm.contact.d.aSp() + "!=0";
    str = "( (" + str + ") and type & " + com.tencent.mm.contact.d.aSq() + "=0" + ab.a("username", "@talkroom", new String[0]) + ")";
    AppMethodBeat.o(117044);
    return str;
  }
  
  private static String jaj()
  {
    AppMethodBeat.i(117045);
    String str = "type & " + com.tencent.mm.contact.d.aSq() + "=0" + ab.a("username", "@openim", new String[0]);
    AppMethodBeat.o(117045);
    return str;
  }
  
  private static String jak()
  {
    AppMethodBeat.i(117046);
    String str = jaf() + " and " + jaj();
    AppMethodBeat.o(117046);
    return str;
  }
  
  private static String jal()
  {
    AppMethodBeat.i(248829);
    String str = " where type & " + com.tencent.mm.contact.d.aSq() + "!=0 and type >= " + com.tencent.mm.contact.d.aSq();
    AppMethodBeat.o(248829);
    return str;
  }
  
  private static String jam()
  {
    AppMethodBeat.i(248833);
    String str = " where type & " + com.tencent.mm.contact.d.aSr() + "!=0";
    AppMethodBeat.o(248833);
    return str;
  }
  
  private static String jan()
  {
    AppMethodBeat.i(248838);
    String str = " where type & " + com.tencent.mm.contact.d.aSs() + "!=0";
    AppMethodBeat.o(248838);
    return str;
  }
  
  private static String jao()
  {
    AppMethodBeat.i(248842);
    String str = " where type & " + com.tencent.mm.contact.d.aSt() + "!=0";
    AppMethodBeat.o(248842);
    return str;
  }
  
  private static String jap()
  {
    AppMethodBeat.i(248847);
    String str = jaf() + " and type & " + com.tencent.mm.contact.d.aSu() + "!=0";
    AppMethodBeat.o(248847);
    return str;
  }
  
  private static String jaq()
  {
    AppMethodBeat.i(248851);
    String str = jaf() + " and type & " + com.tencent.mm.contact.d.aSv() + "!=0";
    AppMethodBeat.o(248851);
    return str;
  }
  
  private static String jar()
  {
    AppMethodBeat.i(248855);
    String str1 = bH(false, false);
    String str2 = str1 + " and type & " + com.tencent.mm.contact.d.aSv() + "=0 and type & " + com.tencent.mm.contact.d.aSu() + "=0";
    if ((str2 != null) && (str2.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str1 = " or (" + jai() + ')';
      str2 = str2 + " and ( username not like '%@%'" + str1 + ")";
      str1 = str2 + ab.a("username", "@micromsg.qq.com", new String[] { str1 });
      AppMethodBeat.o(248855);
      return str1;
    }
  }
  
  private static String jas()
  {
    AppMethodBeat.i(248858);
    String str = jaf() + " and type & " + com.tencent.mm.contact.d.aSw() + "!=0";
    AppMethodBeat.o(248858);
    return str;
  }
  
  private static String jat()
  {
    AppMethodBeat.i(248864);
    String str = jaf() + " and type & " + com.tencent.mm.contact.d.aSx() + "!=0";
    AppMethodBeat.o(248864);
    return str;
  }
  
  private static String jau()
  {
    AppMethodBeat.i(248873);
    String str = jaf() + " and type & " + com.tencent.mm.contact.d.aSy() + "!=0";
    AppMethodBeat.o(248873);
    return str;
  }
  
  private static String jav()
  {
    AppMethodBeat.i(248887);
    String str = " where type & " + com.tencent.mm.contact.d.aSB() + "!=0 ";
    AppMethodBeat.o(248887);
    return str;
  }
  
  private static String jaw()
  {
    AppMethodBeat.i(248892);
    String str = " where type & " + com.tencent.mm.contact.d.aSC() + "!=0 ";
    AppMethodBeat.o(248892);
    return str;
  }
  
  private static String jax()
  {
    AppMethodBeat.i(248899);
    String str = bH(false, false);
    if ((str != null) && (str.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = str + ab.a("username", "@qqim", new String[0]);
      AppMethodBeat.o(248899);
      return str;
    }
  }
  
  private static String jay()
  {
    AppMethodBeat.i(248910);
    String str1 = bH(false, false);
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jah() + ')';
      String str3 = " or (" + jai() + ')';
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2, str3 });
      AppMethodBeat.o(248910);
      return str1;
    }
  }
  
  private static String jaz()
  {
    AppMethodBeat.i(248914);
    String str1 = bH(false, false);
    if ((str1 != null) && (str1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      String str2 = " or (" + jai() + ')' + " or (" + jaj() + ")";
      str1 = str1 + ab.a("username", "@micromsg.qq.com", new String[] { str2 });
      AppMethodBeat.o(248914);
      return str1;
    }
  }
  
  private static String mS(List<String> paramList)
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
  
  private static String mT(List<String> paramList)
  {
    AppMethodBeat.i(117015);
    String str = mS(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    AppMethodBeat.o(117015);
    return paramList;
  }
  
  private static String nc(List<String> paramList)
  {
    AppMethodBeat.i(248939);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(248939);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (!Util.isNullOrNil((String)paramList.get(i)))
      {
        if (i != paramList.size() - 1) {
          break label125;
        }
        localStringBuilder.append(" '" + ((String)paramList.get(i)).trim() + "' ");
      }
      for (;;)
      {
        i += 1;
        break;
        label125:
        localStringBuilder.append(" '" + ((String)paramList.get(i)).trim() + "' ,");
      }
    }
    paramList = String.valueOf(" and " + "username not in (" + localStringBuilder.toString() + ") ");
    AppMethodBeat.o(248939);
    return paramList;
  }
  
  public final au JE(String paramString)
  {
    AppMethodBeat.i(116991);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116991);
      return null;
    }
    String str = paramString;
    if (au.bwS(paramString)) {
      str = au.bxd(paramString);
    }
    paramString = bxq(str);
    if (paramString != null)
    {
      Log.d("MicroMsg.ContactStorage", "[get]getFromCache:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
      AppMethodBeat.o(116991);
      return paramString;
    }
    paramString = this.adin.JE(str);
    if (paramString != null)
    {
      Log.i("MicroMsg.ContactStorage", "[get]extensions:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
      d(paramString, false);
      AppMethodBeat.o(116991);
      return paramString;
    }
    paramString = bxJ(str);
    if (paramString != null) {
      Log.i("MicroMsg.ContactStorage", "[get]getRaw:%s %s", new Object[] { str, Integer.valueOf(paramString.field_type) });
    }
    for (;;)
    {
      AppMethodBeat.o(116991);
      return paramString;
      Log.i("MicroMsg.ContactStorage", "[get]getRaw ca is null");
    }
  }
  
  public final int K(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    AppMethodBeat.i(116999);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(116999);
      return -1;
    }
    av localav = new av();
    localav.field_cmdbuf = paramArrayOfByte;
    localav.field_username = paramString;
    int j = (int)this.db.replace("ContactCmdBuf", "username", localav.convertTo());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      Log.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(116999);
      return j;
      i = paramArrayOfByte.length;
    }
  }
  
  public final Cursor O(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117016);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + mT(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + iZY();
    }
    Log.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(paramList)));
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117016);
    return paramList;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116979);
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + i(paramString1, paramString2, paramList1) + mS(paramList2) + iZY();
    Log.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + P(paramList1, paramBoolean2) + iZZ();
      Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.rawQuery(paramString2, null, 4);
      paramString1 = this.db.rawQuery(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116979);
        return paramString1;
      }
      paramString1 = com.tencent.mm.storagebase.d.jdS();
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
      paramArrayOfString = com.tencent.mm.storagebase.d.jdS();
      AppMethodBeat.o(117033);
      return paramArrayOfString;
    }
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + i(paramString1, paramString2, paramList2) + aa(paramArrayOfString) + S(paramString2, paramList1) + iZY();
    Log.i("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(117033);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117032);
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + i(paramString, null, paramList) + aa(paramArrayOfString);
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
  
  public final void a(bx.a parama)
  {
    AppMethodBeat.i(248962);
    this.adin.XSy.put(parama, new Object());
    AppMethodBeat.o(248962);
  }
  
  public final boolean aA(au paramau)
  {
    AppMethodBeat.i(116996);
    if (paramau != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue("contact NULL !", bool1);
      if (aD(paramau)) {
        break;
      }
      AppMethodBeat.o(116996);
      return true;
    }
    paramau.pp(paramau.aRH());
    paramau.hs(at.bvQ(paramau.field_username));
    this.adin.a(this, paramau);
    if (this.adin.b(paramau, false) > 0)
    {
      bool1 = true;
      Log.i("MicroMsg.ContactStorage", "[replace] ret:%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Boolean.valueOf(bool1), paramau.field_username, Integer.valueOf(paramau.field_showHead), Integer.valueOf(paramau.field_verifyFlag) });
      bool2 = bool1;
      if (!bool1)
      {
        ContentValues localContentValues = paramau.convertTo();
        if ((int)paramau.maN > 0) {
          localContentValues.put("rowid", Integer.valueOf((int)paramau.maN));
        }
        if (this.db.replace(bxp(paramau.field_username), com.tencent.mm.contact.d.info.primaryKey, localContentValues) <= 0L) {
          break label238;
        }
      }
    }
    label238:
    for (boolean bool2 = true;; bool2 = false)
    {
      aDW(paramau.field_username);
      if (!Util.isNullOrNil(paramau.field_encryptUsername)) {
        aDW(paramau.field_encryptUsername);
      }
      if (bool2) {
        break label243;
      }
      AppMethodBeat.o(116996);
      return false;
      bool1 = false;
      break;
    }
    label243:
    doNotify(4, this, paramau.field_username, paramau);
    AppMethodBeat.o(116996);
    return true;
  }
  
  public final boolean aB(au paramau)
  {
    AppMethodBeat.i(116997);
    if (aC(paramau) > 0)
    {
      AppMethodBeat.o(116997);
      return true;
    }
    AppMethodBeat.o(116997);
    return false;
  }
  
  public final int aC(au paramau)
  {
    AppMethodBeat.i(116998);
    if (Util.nullAsNil(paramau.field_username).length() <= 0)
    {
      Log.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      AppMethodBeat.o(116998);
      return -1;
    }
    paramau.pp(paramau.aRH());
    paramau.hs(at.bvQ(paramau.field_username));
    this.adin.a(this, paramau);
    int j = this.adin.b(paramau, false);
    Log.i("MicroMsg.ContactStorage", "insert extensions replace=%s %s", new Object[] { Integer.valueOf(j), paramau.field_username });
    int i = j;
    if (j < 0)
    {
      Object localObject = paramau.convertTo();
      long l = System.currentTimeMillis();
      int k = (int)this.db.insert(bxp(paramau.field_username), com.tencent.mm.contact.d.info.primaryKey, (ContentValues)localObject);
      int m = (int)Util.milliSecondsToNow(l);
      boolean bool = CrashReportFactory.foreground;
      localObject = com.tencent.mm.plugin.report.f.Ozc;
      if (bool)
      {
        i = 11;
        if (!bool) {
          break label302;
        }
      }
      label302:
      for (j = 12;; j = 15)
      {
        ((com.tencent.mm.plugin.report.f)localObject).c(463, i, j, m, false);
        Log.i("MicroMsg.ContactStorage", "insert: username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paramau.field_username, Integer.valueOf(paramau.field_showHead), Integer.valueOf(paramau.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        if (k == -1) {
          break label308;
        }
        paramau.maN = k;
        d(paramau, false);
        doNotify(2, this, paramau.field_username, paramau);
        AppMethodBeat.o(116998);
        return k;
        i = 14;
        break;
      }
      label308:
      Log.e("MicroMsg.ContactStorage", "insert failed: username=%s", new Object[] { paramau.field_username });
      i = k;
    }
    AppMethodBeat.o(116998);
    return i;
  }
  
  public final void aDW(String paramString)
  {
    AppMethodBeat.i(116975);
    if (!Util.isNullOrNil(paramString))
    {
      this.prM.remove(paramString);
      this.adim.remove(paramString);
      Log.d("MicroMsg.ContactStorage", "removeFromCache(%s) username：%s", new Object[] { this.prM, paramString });
    }
    AppMethodBeat.o(116975);
  }
  
  public final void ay(au paramau)
  {
    AppMethodBeat.i(116974);
    d(paramau, false);
    AppMethodBeat.o(116974);
  }
  
  public final Cursor ayT(int paramInt)
  {
    AppMethodBeat.i(249063);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + jaf() + " AND type & " + paramInt + " !=0  AND type >= " + paramInt;
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(249063);
    return localObject;
  }
  
  public final boolean az(au paramau)
  {
    AppMethodBeat.i(116977);
    if (bxy(paramau.field_username))
    {
      if (d(paramau.field_username, paramau) == 0)
      {
        AppMethodBeat.o(116977);
        return true;
      }
      AppMethodBeat.o(116977);
      return false;
    }
    if (aC(paramau) >= 0)
    {
      AppMethodBeat.o(116977);
      return true;
    }
    AppMethodBeat.o(116977);
    return false;
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116988);
    paramString1 = "select username from rcontact " + i(paramString1, paramString2, paramList1) + mS(paramList2) + iZY();
    Log.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + P(paramList1, paramBoolean2) + iZZ();
      Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramString1)));
      paramString2 = this.db.rawQuery(paramString2, null, 4);
      paramString1 = this.db.rawQuery(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.storagebase.a.f)) && ((paramString1 instanceof com.tencent.mm.storagebase.a.f)))
      {
        paramString1 = new e(new com.tencent.mm.storagebase.a.f[] { (com.tencent.mm.storagebase.a.f)paramString2, (com.tencent.mm.storagebase.a.f)paramString1 });
        AppMethodBeat.o(116988);
        return paramString1;
      }
      paramString1 = com.tencent.mm.storagebase.d.jdS();
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
  
  public final void b(bx.a parama)
  {
    AppMethodBeat.i(116972);
    this.adin.XSy.remove(parama);
    AppMethodBeat.o(116972);
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(117026);
    paramString1 = "select distinct showHead from rcontact " + i(paramString1, paramString2, paramList) + aa(paramArrayOfString) + iZY();
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
    AppMethodBeat.i(249115);
    paramArrayOfString = "select distinct showHead from rcontact " + i(paramString1, paramString2, paramList) + aa(paramArrayOfString) + bxD(paramString3) + iZY();
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
    AppMethodBeat.o(249115);
    return paramString1;
  }
  
  public final String bGD()
  {
    AppMethodBeat.i(369617);
    String str = iZY();
    AppMethodBeat.o(369617);
    return str;
  }
  
  public final byte[] bxA(String paramString)
  {
    AppMethodBeat.i(117000);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      AppMethodBeat.o(117000);
      return null;
    }
    av localav = new av();
    Cursor localCursor = this.db.query("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localav.convertFrom(localCursor);
    }
    localCursor.close();
    if (localav.field_cmdbuf == null) {}
    for (int i = -1;; i = localav.field_cmdbuf.length)
    {
      Log.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      paramString = localav.field_cmdbuf;
      AppMethodBeat.o(117000);
      return paramString;
    }
  }
  
  public final int bxB(String paramString)
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
  
  public final int bxC(String paramString)
  {
    AppMethodBeat.i(117002);
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (au.bwS(paramString)) {
        str = au.bxd(paramString);
      }
      aDW(str);
      paramString = new au(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + Util.nowMilliSecond());
      paramString.Bd("fake_" + Util.nowMilliSecond());
      paramString.setSource(0);
      i = this.db.update(bxp(str), paramString.convertTo(), "username=?", new String[] { String.valueOf(str) });
      bxB(str);
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
  
  public final String bxD(String paramString)
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
  
  public final int bxG(String paramString)
  {
    AppMethodBeat.i(249149);
    long l = System.currentTimeMillis();
    paramString = "select count(username) from rcontact" + i(paramString, null, null) + bxD(null);
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
      AppMethodBeat.o(249149);
      return i;
      i = 0;
    }
  }
  
  public final String bxH(String paramString)
  {
    AppMethodBeat.i(117057);
    au localau = bxI(paramString);
    if (localau != null)
    {
      Log.i("MicroMsg.ContactStorage", "getSendMsgTicket %s %s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(Util.nullAs(localau.field_ticket, "").length()) });
      paramString = localau.field_ticket;
      AppMethodBeat.o(117057);
      return paramString;
    }
    Log.e("MicroMsg.ContactStorage", "getSendMsgTicket ca == null");
    AppMethodBeat.o(117057);
    return "";
  }
  
  public final au bxq(String paramString)
  {
    AppMethodBeat.i(116973);
    paramString = (au)this.prM.ct(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(116973);
      return paramString;
    }
    AppMethodBeat.o(116973);
    return null;
  }
  
  public final boolean bxr(String paramString)
  {
    AppMethodBeat.i(116976);
    if ((Util.isNullOrNil(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger"))))
    {
      AppMethodBeat.o(116976);
      return false;
    }
    Object localObject = (Integer)this.adim.get(paramString);
    if (localObject != null)
    {
      bool = com.tencent.mm.contact.d.rs(((Integer)localObject).intValue());
      AppMethodBeat.o(116976);
      return bool;
    }
    localObject = JE(paramString);
    if ((localObject == null) || ((!((az)localObject).field_username.equals(paramString)) && (!paramString.equals(((az)localObject).field_encryptUsername))))
    {
      this.adim.B(paramString, Integer.valueOf(0));
      AppMethodBeat.o(116976);
      return false;
    }
    this.adim.B(paramString, Integer.valueOf(((az)localObject).field_type));
    boolean bool = com.tencent.mm.contact.d.rs(((az)localObject).field_type);
    AppMethodBeat.o(116976);
    return bool;
  }
  
  public final au bxs(String paramString)
  {
    AppMethodBeat.i(116978);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116978);
      return null;
    }
    au localau = this.adin.JE(paramString);
    if (localau != null)
    {
      d(localau, false);
      AppMethodBeat.o(116978);
      return localau;
    }
    localau = new au();
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where alias=" + h.EQ(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localau.convertFrom(paramString);
      d(localau, false);
    }
    paramString.close();
    localau.iZK();
    AppMethodBeat.o(116978);
    return localau;
  }
  
  public final Cursor bxt(String paramString)
  {
    AppMethodBeat.i(116985);
    paramString = this.db.rawQuery(paramString, null, 4);
    AppMethodBeat.o(116985);
    return paramString;
  }
  
  public final au bxu(String paramString)
  {
    AppMethodBeat.i(116989);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116989);
      return null;
    }
    Object localObject = paramString;
    if (au.bwS(paramString)) {
      localObject = au.bxd(paramString);
    }
    paramString = bxq((String)localObject);
    if (paramString != null)
    {
      paramString.iZK();
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = this.adin.JE((String)localObject);
    if (paramString != null)
    {
      d(paramString, false);
      AppMethodBeat.o(116989);
      return paramString;
    }
    paramString = new au();
    localObject = bxo((String)localObject) + " where username=" + h.EQ((String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      d(paramString, false);
    }
    ((Cursor)localObject).close();
    paramString.iZK();
    AppMethodBeat.o(116989);
    return paramString;
  }
  
  public final au bxv(String paramString)
  {
    AppMethodBeat.i(116990);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116990);
      return null;
    }
    Object localObject = paramString;
    if (au.bwS(paramString)) {
      localObject = au.bxd(paramString);
    }
    paramString = bxq((String)localObject);
    if (paramString != null)
    {
      AppMethodBeat.o(116990);
      return paramString;
    }
    paramString = new au();
    localObject = bxo((String)localObject) + " where username=" + h.EQ((String)localObject) + " or encryptUsername=" + h.EQ((String)localObject);
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
  
  public final au bxw(String paramString)
  {
    AppMethodBeat.i(249015);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(249015);
      return null;
    }
    Object localObject = paramString;
    if (au.bwS(paramString)) {
      localObject = au.bxd(paramString);
    }
    paramString = new au();
    localObject = bxo((String)localObject) + " where username=" + h.EQ((String)localObject) + " or encryptUsername=" + h.EQ((String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.convertFrom((Cursor)localObject);
      paramString.iZK();
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(249015);
    return paramString;
  }
  
  public final long bxx(String paramString)
  {
    AppMethodBeat.i(116993);
    long l2 = -1L;
    paramString = JE(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.maN > 0L) {
        l1 = (int)paramString.maN;
      }
    }
    AppMethodBeat.o(116993);
    return l1;
  }
  
  public final boolean bxy(String paramString)
  {
    AppMethodBeat.i(116994);
    au localau = JE(paramString);
    if ((localau != null) && (!Util.isNullOrNil(localau.field_username)) && (localau.field_username.equals(paramString)))
    {
      AppMethodBeat.o(116994);
      return true;
    }
    AppMethodBeat.o(116994);
    return false;
  }
  
  public final boolean bxz(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(116995);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116995);
      return false;
    }
    paramString = "select count(*) from " + bxp(paramString) + " where type & " + com.tencent.mm.contact.d.aSq() + " !=0 and username=" + h.EQ(paramString);
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
    paramString1 = "select count(*) from rcontact " + i(paramString1, paramString2, paramList) + aa(paramArrayOfString);
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
    AppMethodBeat.i(249122);
    long l = System.currentTimeMillis();
    paramArrayOfString = "select count(*) from rcontact " + i(paramString1, paramString2, paramList) + aa(paramArrayOfString) + bxD(paramString3);
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
    AppMethodBeat.o(249122);
    return paramArrayOfString;
  }
  
  public final int cx(String paramString, long paramLong)
  {
    AppMethodBeat.i(169111);
    Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { Util.nullAs(paramString, ""), Long.valueOf(paramLong) });
    au localau = bxu(paramString);
    if (localau != null)
    {
      if (Util.isEqual(localau.kax, paramLong))
      {
        AppMethodBeat.o(169111);
        return 0;
      }
      localau.gP(paramLong);
      int i = d(paramString, localau);
      AppMethodBeat.o(169111);
      return i;
    }
    AppMethodBeat.o(169111);
    return 0;
  }
  
  public final int d(String paramString, au paramau)
  {
    AppMethodBeat.i(117003);
    Log.i("MicroMsg.ContactStorage", "begin to update contact :%s, usernameFlag=%d", new Object[] { paramString, Long.valueOf(paramau.field_usernameFlag) });
    if (!aD(paramau))
    {
      AppMethodBeat.o(117003);
      return 1;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (au.bwS(paramString)) {
      str = au.bxd(paramString);
    }
    paramau.pp(paramau.aRH());
    paramau.hs(at.bvQ(paramau.field_username));
    this.adin.a(this, paramau);
    int j = this.adin.b(paramau, true);
    int i = j;
    if (j < 0)
    {
      paramString = paramau.convertTo();
      if ((int)paramau.maN > 0) {
        paramString.put("rowid", Integer.valueOf((int)paramau.maN));
      }
      i = j;
      if (paramString.size() > 0) {
        i = this.db.update(bxp(str), paramString, "username=?", new String[] { String.valueOf(str) });
      }
    }
    Log.i("MicroMsg.ContactStorage", "[update] ret=%s username=%s, showHead=%d, verifyFlag=%d, type=%d, usernameFlag=%d, take[%d]ms", new Object[] { Integer.valueOf(i), paramau.field_username, Integer.valueOf(paramau.field_showHead), Integer.valueOf(paramau.field_verifyFlag), Integer.valueOf(paramau.field_type), Long.valueOf(paramau.field_usernameFlag), Long.valueOf(System.currentTimeMillis() - l) });
    aDW(str);
    if (!Util.isNullOrNil(paramau.field_encryptUsername)) {
      aDW(paramau.field_encryptUsername);
    }
    if (i != 0) {
      doNotify(4, this, paramau.field_username, paramau);
    }
    AppMethodBeat.o(117003);
    return i;
  }
  
  public final int d(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(117050);
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSp()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSA()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSq()).append(" =0 and ");
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
  
  public final Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(249136);
    paramArrayOfString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + i(paramString2, paramString3, paramList) + aa(paramArrayOfString) + bxD(paramString1) + iZY();
    Log.v("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.db.rawQuery(paramArrayOfString, null);
    AppMethodBeat.o(249136);
    return paramArrayOfString;
  }
  
  public final void d(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(248977);
    if ((paramau == null) || (paramau.field_username == null) || ((paramau.field_type == 0) && (!paramBoolean)))
    {
      AppMethodBeat.o(248977);
      return;
    }
    this.prM.B(paramau.field_username, paramau);
    this.adim.B(paramau.field_username, Integer.valueOf(paramau.field_type));
    Log.d("MicroMsg.ContactStorage", "updateToCache(%s) username：%s %s", new Object[] { this.prM, paramau.field_username, Util.getStack() });
    AppMethodBeat.o(248977);
  }
  
  public final void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(249197);
    paramMStorageEx = new MStorageEx.Event(this, paramInt, paramMStorageEx, paramObject, null);
    doNotify(paramMStorageEx);
    this.adiq.doNotify(paramMStorageEx);
    AppMethodBeat.o(249197);
  }
  
  public final void doNotify(int paramInt, MStorageEx paramMStorageEx, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(249200);
    paramMStorageEx = new MStorageEx.Event(this, paramInt, paramMStorageEx, paramObject1, paramObject2);
    doNotify(paramMStorageEx);
    this.adiq.doNotify(paramMStorageEx);
    AppMethodBeat.o(249200);
  }
  
  public final int e(String paramString, au paramau)
  {
    AppMethodBeat.i(117004);
    if ((Util.isNullOrNil(paramString)) || (paramau == null) || (Util.isNullOrNil(paramau.field_username)))
    {
      Log.e("MicroMsg.ContactStorage", "update : wrong input!");
      AppMethodBeat.o(117004);
      return 0;
    }
    Log.i("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paramau.field_username + " enUsername: " + paramString);
    if (!aD(paramau))
    {
      AppMethodBeat.o(117004);
      return 1;
    }
    if (au.bwS(paramau.field_username)) {
      paramau.setUsername(au.bxd(paramau.field_username));
    }
    paramau.pp(paramau.aRH());
    paramau.hs(at.bvQ(paramau.field_username));
    this.adin.a(this, paramau);
    boolean bool;
    ContentValues localContentValues;
    au localau;
    int i;
    if (this.adin.b(paramau, true) > 0)
    {
      bool = true;
      Log.i("MicroMsg.ContactStorage", "[update] ret=%s oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d type:%s", new Object[] { Boolean.valueOf(bool), paramString, paramau.field_username, Integer.valueOf(paramau.field_showHead), Integer.valueOf(paramau.field_verifyFlag), Integer.valueOf(paramau.field_type) });
      localContentValues = paramau.convertTo();
      if ((bool) || (paramau.maN > 0L)) {
        break label509;
      }
      localau = new au(paramString);
      localau.setType(0);
      localau.setUsername("fake_" + Util.nowMilliSecond());
      localau.Bd("fake_" + Util.nowMilliSecond());
      i = this.db.update(bxp(paramString), localau.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
      Log.i("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + bxp(paramString) + " user :" + paramString + ", res:" + i);
      if (localContentValues.size() <= 0) {
        break label819;
      }
      i = (int)this.db.replace(bxp(paramau.field_username), com.tencent.mm.contact.d.info.primaryKey, localContentValues);
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactStorage", "updateEncryptUser values:%s, result1:%s", new Object[] { Integer.valueOf(localContentValues.size()), Integer.valueOf(i) });
      aDW(paramau.field_username);
      if (!Util.isNullOrNil(paramau.field_encryptUsername)) {
        aDW(paramau.field_encryptUsername);
      }
      doNotify(3, this, paramString, paramau);
      doNotify(3, this, paramau.field_username, paramau);
      AppMethodBeat.o(117004);
      return i;
      bool = false;
      break;
      label509:
      if (!bool) {
        if (paramString.equals(paramau.field_username))
        {
          if (localContentValues.size() > 0)
          {
            i = this.db.update(bxp(paramau.field_username), localContentValues, "rowid=?", new String[] { paramau.maN });
            Log.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paramau.field_username, Integer.valueOf(i), Long.valueOf(paramau.maN) });
          }
        }
        else
        {
          localau = new au(paramString);
          localau.setType(0);
          localau.setUsername("fake_" + Util.nowMilliSecond());
          localau.Bd("fake_" + Util.nowMilliSecond());
          i = this.db.update(bxp(paramString), localau.convertTo(), "username=?", new String[] { String.valueOf(paramString) });
          Log.i("MicroMsg.ContactStorage", "delete " + bxp(paramString) + " user :" + paramString + ", res:" + i);
          if (localContentValues.size() > 0)
          {
            i = this.db.update(bxp(paramau.field_username), localContentValues, "rowid=?", new String[] { paramau.maN });
            continue;
          }
        }
      }
      label819:
      i = 0;
    }
  }
  
  public final int e(String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(117051);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSp()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSA()).append(" =0 and ");
    localStringBuilder.append("type & ").append(com.tencent.mm.contact.d.aSq()).append(" =0 and ");
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
  
  public final Cursor f(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117014);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + i(paramString1, paramString2, paramList) + mS(null) + iZY();
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117014);
    return paramString1;
  }
  
  public final void f(String paramString, au paramau)
  {
    AppMethodBeat.i(117005);
    if (paramString == null)
    {
      AppMethodBeat.o(117005);
      return;
    }
    String str = paramString;
    if (au.bwS(paramString)) {
      str = au.bxd(paramString);
    }
    paramau.pp(paramau.aRH());
    paramau.hs(at.bvQ(paramau.field_username));
    if (ab.q(paramau))
    {
      paramau.pp(43);
      paramau.AY(com.tencent.mm.platformtools.f.Sa(paramau.aSU()));
      paramau.AZ(com.tencent.mm.platformtools.f.RZ(paramau.aSU()));
      paramau.Bb(com.tencent.mm.platformtools.f.RZ(paramau.aSV()));
      paramau.Bc(paramau.aSV());
      AppMethodBeat.o(117005);
      return;
    }
    if (au.bwp(paramau.field_username))
    {
      Log.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
      paramau.pp(31);
    }
    this.adin.a(this, paramau);
    int i = this.adin.b(paramau, true);
    Log.i("MicroMsg.ContactStorage", "ret=%s username=%s, showHead=%d, verifyFlag=%d", new Object[] { Integer.valueOf(i), paramau.field_username, Integer.valueOf(paramau.field_showHead), Integer.valueOf(paramau.field_verifyFlag) });
    if (i > 0)
    {
      AppMethodBeat.o(117005);
      return;
    }
    paramString = paramau.convertTo();
    if ((int)paramau.maN > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramau.maN));
    }
    if (paramString.size() > 0) {
      this.db.update(bxp(str), paramString, "username=?", new String[] { String.valueOf(str) });
    }
    AppMethodBeat.o(117005);
  }
  
  public final Cursor g(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117022);
    paramString1 = f(paramString1, paramString2, paramList);
    AppMethodBeat.o(117022);
    return paramString1;
  }
  
  public final Cursor h(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117023);
    paramString1 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + i(paramString1, paramString2, paramList) + iZY();
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117023);
    return paramString1;
  }
  
  public final boolean hasObserver()
  {
    AppMethodBeat.i(249183);
    boolean bool = this.adiq.hasObserver();
    AppMethodBeat.o(249183);
    return bool;
  }
  
  public final String i(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(117049);
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + bH(true, false);
    }
    for (;;)
    {
      paramString2 = nc(paramList);
      paramString1 = paramString1 + paramString2;
      AppMethodBeat.o(117049);
      return paramString1;
      if (paramString1.equals("@all.contact.android"))
      {
        paramString1 = "" + jaf();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = "" + jag();
      }
      else if (paramString1.equals("@all.contact.without.chatroom"))
      {
        paramString1 = "" + jaz();
      }
      else if ((paramString1.equals("@all.contact.without.chatroom.without.openim")) || (paramString1.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")))
      {
        paramString1 = "" + jaA();
      }
      else if (paramString1.equals("@black.android"))
      {
        paramString1 = "" + jal();
      }
      else if (paramString1.equals("@werun.black.android"))
      {
        paramString1 = "" + jam();
      }
      else if (paramString1.equals("@tophistory.black.android"))
      {
        paramString1 = "" + jan();
      }
      else if (paramString1.equals("@tophistory.unlike.android"))
      {
        paramString1 = "" + jao();
      }
      else if (paramString1.equals("@social.black.android"))
      {
        paramString1 = "" + jap();
      }
      else if (paramString1.equals("@sns.black.android"))
      {
        paramString1 = "" + jaq();
      }
      else if (paramString1.equals("@sns.unlike.android"))
      {
        paramString1 = "" + jas();
      }
      else if (paramString1.equals("@finder.block.his.liked.android"))
      {
        paramString1 = "" + jat();
      }
      else if (paramString1.equals("@finder.block.my.liked.android"))
      {
        paramString1 = "" + jau();
      }
      else if (paramString1.equals("@t.qq.com"))
      {
        paramString1 = "" + bxE("@t.qq.com");
      }
      else if (paramString1.equals("@domain.android"))
      {
        paramString1 = "" + bxF(paramString2);
      }
      else if (paramString1.equals("@micromsg.qq.com"))
      {
        paramString1 = "" + jay();
      }
      else if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
      {
        paramString1 = "" + jaD();
      }
      else if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
      {
        paramString1 = "" + jaB();
      }
      else if (paramString1.equals("@micromsg.with.all.biz.qq.com.openim"))
      {
        paramString1 = "" + jaC();
      }
      else if (paramString1.equals("@qqim"))
      {
        paramString1 = "" + jax();
      }
      else if (paramString1.equals("@all.chatroom"))
      {
        paramString1 = "" + jae();
      }
      else if (paramString1.equals("@verify.contact"))
      {
        paramString1 = "" + jab();
      }
      else if (paramString1.equals("@biz.contact"))
      {
        paramString1 = "" + jac();
      }
      else if (paramString1.equals("@all.weixin.android"))
      {
        paramString1 = "" + jad();
      }
      else if (paramString1.equals("@openim.contact"))
      {
        paramString1 = "" + jak();
      }
      else if (paramString1.equals("@guardian.teenmode"))
      {
        paramString1 = "" + jav();
      }
      else if (paramString1.equals("@ward.teenmode"))
      {
        paramString1 = "" + jaw();
      }
      else if (paramString1.equals("@all.contact.without.chatroom.openim.openimfavour.snsblack.black.socialblack"))
      {
        paramString1 = "" + jar();
      }
      else
      {
        Log.d("MicroMsg.ContactStorage", "unknow role type");
        paramString1 = "" + bH(false, false);
      }
    }
  }
  
  public final List<String> iZS()
  {
    AppMethodBeat.i(116980);
    Object localObject1 = " select openImAppid from rcontact" + jak() + " group by openImAppid ";
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
  
  public final List<String> iZT()
  {
    AppMethodBeat.i(117008);
    Object localObject = "select username from rcontact where " + jah();
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
  
  public final Cursor iZU()
  {
    AppMethodBeat.i(117009);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + new StringBuilder("type & ").append(com.tencent.mm.contact.d.aSq()).append("=0").append(ab.a("username", "@chatroom", new String[0])).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117009);
    return localObject;
  }
  
  public final Cursor iZV()
  {
    AppMethodBeat.i(117011);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + adip + " and verifyFlag & " + au.iZH() + " !=0 ";
    Log.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117011);
    return localObject;
  }
  
  public final Cursor iZW()
  {
    AppMethodBeat.i(117012);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + jaf() + " AND " + adip + " AND " + adio + iZZ();
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117012);
    return localObject;
  }
  
  public final int iZX()
  {
    int i = 0;
    AppMethodBeat.i(117024);
    Object localObject = "select count(rowid) from rcontact " + i("@biz.contact", null, null);
    Log.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117024);
    return i;
  }
  
  public final int jaE()
  {
    AppMethodBeat.i(249159);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select count(1) from");
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append("select verifyFlag from rcontact where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSp()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSA()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSq()).append(" =0  )");
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
      AppMethodBeat.o(249159);
      return i;
      i = 0;
    }
  }
  
  public final Cursor jaF()
  {
    AppMethodBeat.i(117052);
    Cursor localCursor = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where rowid = -1", null);
    AppMethodBeat.o(117052);
    return localCursor;
  }
  
  public final Cursor jaG()
  {
    AppMethodBeat.i(117055);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSp()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSA()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSq()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0");
    ((StringBuilder)localObject).append(ab.a("username", "@micromsg.qq.com", new String[0]));
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    Log.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[] { localObject });
    AppMethodBeat.o(117055);
    return localCursor;
  }
  
  public final Cursor jaH()
  {
    AppMethodBeat.i(117056);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSp()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSA()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(com.tencent.mm.contact.d.aSq()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0");
    ((StringBuilder)localObject).append(ab.a("username", "@micromsg.qq.com", new String[0]));
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    Log.d("MicroMsg.ContactStorage", "get friend cursor, sql is %s", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null, 2);
    AppMethodBeat.o(117056);
    return localObject;
  }
  
  public final Cursor jaI()
  {
    AppMethodBeat.i(249181);
    Log.v("MicroMsg.ContactStorage", "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ");
    Cursor localCursor = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ", null);
    AppMethodBeat.o(249181);
    return localCursor;
  }
  
  public final Cursor mO(List<String> paramList)
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
        break label147;
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
    label147:
    paramList = str + iZY();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(116986);
    return paramList;
  }
  
  public final Cursor mP(List<String> paramList)
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
        break label137;
      }
      if (i != paramList.size() - 1) {
        break label106;
      }
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("'");
    }
    for (;;)
    {
      i += 1;
      break label44;
      bool = false;
      break;
      label106:
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("',");
    }
    label137:
    localStringBuilder.append(" )").append(iZY());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(116987);
    return paramList;
  }
  
  public final Cursor mQ(List<String> paramList)
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
        break label137;
      }
      if (i != paramList.size() - 1) {
        break label106;
      }
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("'");
    }
    for (;;)
    {
      i += 1;
      break label44;
      bool = false;
      break;
      label106:
      localStringBuilder.append(" '").append((String)paramList.get(i)).append("',");
    }
    label137:
    localStringBuilder.append(" )").append(iZY());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117006);
    return paramList;
  }
  
  public final Cursor mR(List<String> paramList)
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
        break label152;
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
    label152:
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
  
  public final Cursor mU(List<String> paramList)
  {
    AppMethodBeat.i(117017);
    String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + jaf() + " and ( " + mT(paramList) + " ) ";
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
  
  public final Cursor mV(List<String> paramList)
  {
    AppMethodBeat.i(117018);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + adip + ") and (" + mT(paramList) + ")" + iZZ();
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117018);
    return paramList;
  }
  
  public final Cursor mW(List<String> paramList)
  {
    AppMethodBeat.i(117019);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + adip + ") and (" + mT(paramList) + ")" + iZZ() + " and (username like  '%@openim' )";
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117019);
    return paramList;
  }
  
  public final Cursor mX(List<String> paramList)
  {
    AppMethodBeat.i(117020);
    paramList = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + P(paramList, false) + iZZ();
    Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    Log.i("MicroMsg.ContactStorage", "getFavCursor favourSql = %s", new Object[] { paramList });
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117020);
    return paramList;
  }
  
  public final Cursor mY(List<String> paramList)
  {
    AppMethodBeat.i(117021);
    StringBuilder localStringBuilder = new StringBuilder("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ");
    String str = bH(false, false) + " AND " + adip;
    str = str + ab.a("username", "@openim", true, new String[0]);
    paramList = nc(paramList);
    paramList = new StringBuilder().append(str).append(paramList).toString() + iZZ();
    Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(paramList)));
    Log.i("MicroMsg.ContactStorage", "getFavCursorWithoutOpenIM favourSql = %s", new Object[] { paramList });
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117021);
    return paramList;
  }
  
  public final List<String> mZ(List<String> paramList)
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
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(com.tencent.mm.contact.d.aSp()), localStringBuilder.toString() });
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
  
  public final int[] na(List<String> paramList)
  {
    AppMethodBeat.i(117028);
    paramList = "select distinct showHead from rcontact  where (" + mT(paramList) + ") " + iZY();
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
  
  public final int[] nb(List<String> paramList)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(117030);
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + mT(paramList);
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
  
  public final void notify(List<? extends StorageObserverEvent<au>> paramList)
  {
    AppMethodBeat.i(249187);
    this.adiq.notify(paramList);
    AppMethodBeat.o(249187);
  }
  
  public final void notifyAny(Object paramObject)
  {
    AppMethodBeat.i(249191);
    this.adiq.notifyAny(paramObject);
    AppMethodBeat.o(249191);
  }
  
  public final Cursor pH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(185151);
    paramString1 = "select username from rcontact " + i(paramString1, paramString2, null);
    Log.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(185151);
    return paramString1;
  }
  
  public final int pI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117059);
    Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", new Object[] { Util.nullAs(paramString1, ""), Integer.valueOf(Util.nullAs(paramString2, "").length()) });
    au localau = bxI(paramString1);
    if (localau != null)
    {
      if (Util.isEqual(localau.field_ticket, paramString2))
      {
        AppMethodBeat.o(117059);
        return 0;
      }
      localau.Bi(paramString2);
      int i = d(paramString1, localau);
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
  
  public final au zc(long paramLong)
  {
    au localau = null;
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
      localau = new au();
      localau.convertFrom((Cursor)localObject);
      d(localau, false);
    }
    ((Cursor)localObject).close();
    if (localau != null) {
      localau.iZK();
    }
    AppMethodBeat.o(116992);
    return localau;
  }
  
  static final class a
    implements bx.a
  {
    ConcurrentHashMap<bx.a, Object> XSy;
    
    private a()
    {
      AppMethodBeat.i(248475);
      this.XSy = new ConcurrentHashMap();
      AppMethodBeat.o(248475);
    }
    
    public final au JE(String paramString)
    {
      AppMethodBeat.i(248487);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext())
      {
        bx.a locala = (bx.a)localIterator.next();
        au localau = locala.JE(paramString);
        if (localau != null)
        {
          Log.i("MicroMsg.ContactStorage", "[get] contact=%s listener=%s", new Object[] { localau.field_username, locala });
          AppMethodBeat.o(248487);
          return localau;
        }
      }
      AppMethodBeat.o(248487);
      return null;
    }
    
    public final void a(bx parambx, au paramau)
    {
      AppMethodBeat.i(248481);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext()) {
        ((bx.a)localIterator.next()).a(parambx, paramau);
      }
      AppMethodBeat.o(248481);
    }
    
    public final int b(au paramau, boolean paramBoolean)
    {
      AppMethodBeat.i(248490);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext())
      {
        bx.a locala = (bx.a)localIterator.next();
        int i = locala.b(paramau, paramBoolean);
        if (i > 0)
        {
          Log.i("MicroMsg.ContactStorage", "[replace] ret=%s listener=%s", new Object[] { Integer.valueOf(i), locala });
          AppMethodBeat.o(248490);
          return i;
        }
      }
      AppMethodBeat.o(248490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */