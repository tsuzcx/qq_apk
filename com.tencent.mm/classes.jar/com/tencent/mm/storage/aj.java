package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.d;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aj
  extends m
  implements bd
{
  public static final String[] cqY = { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) " };
  public static final String[] dXp = { i.a(ad.buS, "rcontact"), i.a(ad.buS, "bottlecontact"), i.a(ae.buS, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
  private static String uAe = "showHead = 32";
  private static String uAf = "type & 64 !=0 ";
  private com.tencent.mm.sdk.e.e dXw;
  private final k<bd.a, ad> eeJ = new aj.1(this);
  private com.tencent.mm.sdk.e.e uAb;
  public final com.tencent.mm.a.f<String, ad> uAc = new com.tencent.mm.a.f(200);
  public final com.tencent.mm.a.f<String, Integer> uAd = new com.tencent.mm.a.f(400);
  
  public aj(h paramh)
  {
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
      paramh.gk("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
    }
    if (j == 0) {
      paramh.gk("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
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
        paramh.gk("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
      }
      localObject = i.a(a.buS, "bottlecontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.gk("bottlecontact", (String)((Iterator)localObject).next());
      }
      localObject = i.a(a.buS, "rcontact", paramh).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramh.gk("rcontact", (String)((Iterator)localObject).next());
      }
      localObject = cqY;
      j = localObject.length;
      i = k;
      while (i < j)
      {
        paramh.gk("rcontact", localObject[i]);
        i += 1;
      }
      this.dXw = paramh;
      this.uAb = paramh;
      return;
    }
  }
  
  private void DG(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.uAc.remove(paramString);
      this.uAd.remove(paramString);
    }
  }
  
  private static String J(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
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
    return str1 + " )";
  }
  
  private static String U(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = "type & " + a.AY() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + a.Bb() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + a.Bc() + "=0 ";
    str2 = str1 + " and type & " + a.AZ() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + ad.cuc() + " =0 ";
    }
    return str1;
  }
  
  private static boolean X(ad paramad)
  {
    boolean bool = false;
    if (paramad == null) {
      return false;
    }
    int i = paramad.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      y.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paramad.field_username);
      return bool;
      bool = true;
    }
  }
  
  private static String a(String paramString1, List<String> paramList1, String paramString2, List<String> paramList2)
  {
    paramString1 = paramString1 + " and OpenIMWordingInfo.language='" + paramString2 + "' ";
    String str = paramString1 + cuy();
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
    y.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[] { paramString1 });
    return paramString1;
  }
  
  private static String abd(String paramString)
  {
    return "select *,rowid from " + abe(paramString) + " ";
  }
  
  private static String abe(String paramString)
  {
    if (ad.hd(paramString)) {
      return "bottlecontact";
    }
    return "rcontact";
  }
  
  private static String cLk()
  {
    String str = "type & " + a.AY() + " !=0 ";
    str = " where (" + str + ") and ";
    str = str + "type & " + a.Bc() + " =0 and ";
    return str + "type & " + a.AZ() + " =0";
  }
  
  private static String cLl()
  {
    return "type & " + a.AZ() + "=0 and username like '%@openim'";
  }
  
  private static String cus()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" order by showHead asc, ");
    localStringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    localStringBuffer.append(" else upper(quanPin) end asc, ");
    localStringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
    localStringBuffer.append(" else upper(quanPin) end asc, ");
    localStringBuffer.append(" upper(quanPin) asc, ");
    localStringBuffer.append(" upper(nickname) asc, ");
    localStringBuffer.append(" upper(username) asc ");
    return localStringBuffer.toString();
  }
  
  private static String cut()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" order by case when verifyFlag & " + ad.cuc() + " != 0 then 0 else 1 end , showHead asc, ");
    localStringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    localStringBuffer.append(" else upper(quanPin) end asc, ");
    localStringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
    localStringBuffer.append(" else upper(quanPin) end asc, ");
    localStringBuffer.append(" upper(quanPin) asc, ");
    localStringBuffer.append(" upper(nickname) asc, ");
    localStringBuffer.append(" upper(username) asc ");
    return localStringBuffer.toString();
  }
  
  private static String cuu()
  {
    String str = "type & " + a.AY() + "!=0";
    str = " where (" + str + ") and ";
    return str + "type & " + a.Bc() + "=0  ";
  }
  
  private static String cuv()
  {
    String str = "type & " + a.AY() + "!=0";
    return "( (" + str + ") and type & " + a.AZ() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom'))";
  }
  
  private static String cuw()
  {
    String str = "type & " + a.AY() + "!=0";
    return "( (" + str + ") and type & " + a.AZ() + "=0 and username like '%@talkroom')";
  }
  
  private static String cuy()
  {
    return cuu() + " and " + cLl();
  }
  
  private static String dG(List<String> paramList)
  {
    Object localObject = U(false, false) + " AND " + uAf;
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
    return str2 + (String)localObject;
  }
  
  private static String dx(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append(" or username = '").append(str).append("'");
    }
    return localStringBuilder.toString();
  }
  
  private static String dy(List<String> paramList)
  {
    String str = dx(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    return paramList;
  }
  
  private static String j(List<String> paramList, boolean paramBoolean)
  {
    String str2 = U(false, paramBoolean) + " AND " + uAf;
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
    return str2 + (String)localObject;
  }
  
  private static String w(String paramString, List<String> paramList)
  {
    if ((paramString == null) || (paramString.equals(""))) {
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
    return paramList + "quanPin like '%" + paramString + "%' )";
  }
  
  public final String Md()
  {
    return cus();
  }
  
  public final void S(ad paramad)
  {
    if ((paramad == null) || (paramad.field_username == null) || (paramad.field_type == 0)) {
      return;
    }
    this.uAc.f(paramad.field_username, paramad);
    this.uAd.f(paramad.field_username, Integer.valueOf(paramad.field_type));
  }
  
  public final boolean T(ad paramad)
  {
    if (abn(paramad.field_username)) {
      if (a(paramad.field_username, paramad) != 0) {}
    }
    while (W(paramad) >= 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean U(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("contact NULL !", bool);
      if (X(paramad)) {
        break;
      }
      return true;
    }
    paramad.fg(paramad.AE());
    this.eeJ.bV(paramad);
    this.eeJ.doNotify();
    y.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
    ContentValues localContentValues = paramad.vf();
    if ((int)paramad.dBe > 0) {
      localContentValues.put("rowid", Integer.valueOf((int)paramad.dBe));
    }
    if (this.dXw.replace(abe(paramad.field_username), a.buS.ujM, localContentValues) > 0L) {}
    for (int i = 1;; i = 0)
    {
      DG(paramad.field_username);
      if (!bk.bl(paramad.field_encryptUsername)) {
        DG(paramad.field_encryptUsername);
      }
      if (i != 0) {
        break;
      }
      return false;
    }
    b(4, this, paramad.field_username);
    return true;
  }
  
  public final boolean V(ad paramad)
  {
    return W(paramad) > 0;
  }
  
  public final int W(ad paramad)
  {
    if (bk.pm(paramad.field_username).length() <= 0)
    {
      y.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      return -1;
    }
    paramad.fg(paramad.AE());
    this.eeJ.bV(paramad);
    this.eeJ.doNotify();
    Object localObject = paramad.vf();
    long l = System.currentTimeMillis();
    int k = (int)this.dXw.insert(abe(paramad.field_username), a.buS.ujM, (ContentValues)localObject);
    int m = (int)bk.co(l);
    boolean bool = b.foreground;
    localObject = com.tencent.mm.plugin.report.f.nEG;
    int i;
    if (bool)
    {
      i = 11;
      if (!bool) {
        break label233;
      }
    }
    label233:
    for (int j = 12;; j = 15)
    {
      ((com.tencent.mm.plugin.report.f)localObject).d(463, i, j, m, false);
      y.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      if (k == -1) {
        break label239;
      }
      paramad.dBe = k;
      S(paramad);
      b(2, this, paramad.field_username);
      return k;
      i = 14;
      break;
    }
    label239:
    y.e("MicroMsg.ContactStorage", "insert failed: username=" + paramad.field_username);
    return -1;
  }
  
  protected final boolean WH()
  {
    boolean bool = true;
    if ((this.dXw == null) || (this.dXw.csp())) {
      if (this.dXw != null) {
        break label52;
      }
    }
    label52:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.dXw.csp()))
    {
      y.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
  
  public final int a(String paramString, ad paramad)
  {
    y.i("MicroMsg.ContactStorage", "begin to update contact : " + paramString);
    int j;
    if (!X(paramad))
    {
      j = 1;
      return j;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (ad.hd(paramString)) {
      str = ad.aaZ(paramString);
    }
    paramad.fg(paramad.AE());
    this.eeJ.bV(paramad);
    this.eeJ.doNotify();
    paramString = paramad.vf();
    if ((int)paramad.dBe > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramad.dBe));
    }
    if (paramString.size() > 0) {}
    for (int i = this.dXw.update(abe(str), paramString, "username=?", new String[] { str });; i = 0)
    {
      y.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      DG(str);
      if (!bk.bl(paramad.field_encryptUsername)) {
        DG(paramad.field_encryptUsername);
      }
      j = i;
      if (i == 0) {
        break;
      }
      b(4, this, str);
      return i;
    }
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + e(paramString1, paramString2, paramList1) + dx(paramList2) + cus();
    y.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + j(paramList1, paramBoolean2) + cut();
      y.v("MicroMsg.ContactStorage", "favourSql " + paramString1);
      paramString2 = this.dXw.a(paramString2, null, 4);
      paramString1 = this.dXw.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.cf.a.f)) && ((paramString1 instanceof com.tencent.mm.cf.a.f))) {
        return new com.tencent.mm.cf.a.e(new com.tencent.mm.cf.a.f[] { (com.tencent.mm.cf.a.f)paramString2, (com.tencent.mm.cf.a.f)paramString1 });
      }
      return d.cwX();
    }
    return this.dXw.a(paramString1, null, 4);
  }
  
  public final Cursor a(List<String> paramList1, String paramString, List<String> paramList2)
  {
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    return this.dXw.a(paramList1, null, 4);
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    paramArrayOfString = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList2) + J(paramArrayOfString) + w(paramString2, paramList1) + cus();
    y.i("MicroMsg.ContactStorage", paramArrayOfString);
    return this.dXw.rawQuery(paramArrayOfString, null);
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    paramString = "select * ,rowid from rcontact " + e(paramString, null, paramList) + J(paramArrayOfString);
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
    y.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + paramList);
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final void a(bd.a parama)
  {
    this.eeJ.a(parama, null);
  }
  
  public final ad abf(String paramString)
  {
    paramString = (ad)this.uAc.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public final boolean abg(String paramString)
  {
    if ((bk.bl(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger")))) {
      return false;
    }
    Object localObject = (Integer)this.uAd.get(paramString);
    if (localObject != null) {
      return a.gR(((Integer)localObject).intValue());
    }
    localObject = abl(paramString);
    if ((localObject == null) || ((!((ao)localObject).field_username.equals(paramString)) && (!paramString.equals(((ao)localObject).field_encryptUsername))))
    {
      this.uAd.f(paramString, Integer.valueOf(0));
      return false;
    }
    this.uAd.f(paramString, Integer.valueOf(((ao)localObject).field_type));
    return a.gR(((ao)localObject).field_type);
  }
  
  public final ad abh(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    ad localad = new ad();
    paramString = "select *,rowid from rcontact where alias=" + h.fA(paramString);
    paramString = this.dXw.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localad.d(paramString);
      S(localad);
    }
    paramString.close();
    localad.cuf();
    return localad;
  }
  
  public final Cursor abi(String paramString)
  {
    return this.dXw.a(paramString, null, 4);
  }
  
  public final ad abj(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (ad.hd(paramString)) {
      localObject = ad.aaZ(paramString);
    }
    paramString = abf((String)localObject);
    if (paramString != null)
    {
      paramString.cuf();
      return paramString;
    }
    paramString = new ad();
    localObject = abd((String)localObject) + " where username=" + h.fA((String)localObject);
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.d((Cursor)localObject);
      S(paramString);
    }
    ((Cursor)localObject).close();
    paramString.cuf();
    return paramString;
  }
  
  public final ad abk(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (ad.hd(paramString)) {
      localObject = ad.aaZ(paramString);
    }
    paramString = abf((String)localObject);
    if (paramString != null) {
      return paramString;
    }
    paramString = new ad();
    localObject = abd((String)localObject) + " where username=" + h.fA((String)localObject) + " or encryptUsername=" + h.fA((String)localObject);
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.d((Cursor)localObject);
      S(paramString);
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  public final ad abl(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (ad.hd(paramString)) {
      localObject = ad.aaZ(paramString);
    }
    paramString = abf((String)localObject);
    if (paramString != null) {
      return paramString;
    }
    paramString = new ad();
    localObject = abd((String)localObject) + " where username=" + h.fA((String)localObject) + " or encryptUsername=" + h.fA((String)localObject);
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.d((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString.cuf();
      S(paramString);
    }
    for (;;)
    {
      return paramString;
      ((Cursor)localObject).close();
    }
  }
  
  public final long abm(String paramString)
  {
    long l2 = -1L;
    paramString = abl(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.dBe > 0L) {
        l1 = (int)paramString.dBe;
      }
    }
    return l1;
  }
  
  public final boolean abn(String paramString)
  {
    ad localad = abl(paramString);
    return (localad != null) && (!bk.bl(localad.field_username)) && (localad.field_username.equals(paramString));
  }
  
  public final boolean abo(String paramString)
  {
    boolean bool2 = false;
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = "select count(*) from " + abe(paramString) + " where type & " + a.AZ() + " !=0 and username=" + h.fA(paramString);
    paramString = this.dXw.a(paramString, null, 2);
    boolean bool1 = bool2;
    if (paramString.moveToFirst())
    {
      bool1 = bool2;
      if (paramString.getInt(0) > 0) {
        bool1 = true;
      }
    }
    paramString.close();
    return bool1;
  }
  
  public final byte[] abp(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      return null;
    }
    ae localae = new ae();
    Cursor localCursor = this.dXw.a("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localae.d(localCursor);
    }
    localCursor.close();
    if (localae.field_cmdbuf == null) {}
    for (int i = -1;; i = localae.field_cmdbuf.length)
    {
      y.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      return localae.field_cmdbuf;
    }
  }
  
  public final int abq(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
      return -1;
    }
    int i = this.dXw.delete("ContactCmdBuf", "username=?", new String[] { paramString });
    y.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    return i;
  }
  
  public final int abr(String paramString)
  {
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (ad.hd(paramString)) {
        str = ad.aaZ(paramString);
      }
      DG(str);
      paramString = new ad(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + bk.UY());
      paramString.dq("fake_" + bk.UY());
      i = this.dXw.update(abe(str), paramString.vf(), "username=?", new String[] { str });
      abq(str);
      y.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[] { str, Integer.valueOf(i), bk.csb() });
      if (i != 0) {
        break;
      }
      return i;
    }
    b(5, this, str);
    return i;
  }
  
  public final String abs(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    String str = " and (" + "conRemark like '%" + paramString + "%' or ";
    str = str + "conRemarkPYFull like '%" + paramString + "%' or ";
    str = str + "conRemarkPYShort like '%" + paramString + "%' or ";
    str = str + "alias like '%" + paramString + "%' or ";
    str = str + "username like '%" + paramString + "%' or ";
    str = str + "nickname like '%" + paramString + "%' or ";
    str = str + "pyInitial like '%" + paramString + "%' or ";
    return str + "quanPin like '%" + paramString + "%' )";
  }
  
  public final int b(String paramString, ad paramad)
  {
    int i = 0;
    if ((bk.bl(paramString)) || (paramad == null) || (bk.bl(paramad.field_username)))
    {
      y.e("MicroMsg.ContactStorage", "update : wrong input!");
      return 0;
    }
    y.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paramad.field_username + " enUsername: " + paramString);
    if (!X(paramad)) {
      return 1;
    }
    if (ad.hd(paramad.field_username)) {
      paramad.setUsername(ad.aaZ(paramad.field_username));
    }
    paramad.fg(paramad.AE());
    this.eeJ.bV(paramad);
    this.eeJ.doNotify();
    y.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramString, paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
    ContentValues localContentValues = paramad.vf();
    ad localad;
    int j;
    if (paramad.dBe <= 0L)
    {
      localad = new ad(paramString);
      localad.setType(0);
      localad.setUsername("fake_" + bk.UY());
      localad.dq("fake_" + bk.UY());
      j = this.dXw.update(abe(paramString), localad.vf(), "username=?", new String[] { paramString });
      y.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + abe(paramString) + " user :" + paramString + ", res:" + j);
      if (localContentValues.size() > 0) {
        i = (int)this.dXw.replace(abe(paramad.field_username), a.buS.ujM, localContentValues);
      }
    }
    for (;;)
    {
      DG(paramad.field_username);
      if (!bk.bl(paramad.field_encryptUsername)) {
        DG(paramad.field_encryptUsername);
      }
      b(3, this, paramString);
      b(3, this, paramad.field_username);
      return i;
      if (paramString.equals(paramad.field_username))
      {
        if (localContentValues.size() > 0)
        {
          i = this.dXw.update(abe(paramad.field_username), localContentValues, "rowid=?", new String[] { paramad.dBe });
          y.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paramad.field_username, Integer.valueOf(i), Long.valueOf(paramad.dBe) });
        }
      }
      else
      {
        localad = new ad(paramString);
        localad.setType(0);
        localad.setUsername("fake_" + bk.UY());
        localad.dq("fake_" + bk.UY());
        j = this.dXw.update(abe(paramString), localad.vf(), "username=?", new String[] { paramString });
        y.d("MicroMsg.ContactStorage", "delete " + abe(paramString) + " user :" + paramString + ", res:" + j);
        if (localContentValues.size() > 0) {
          i = this.dXw.update(abe(paramad.field_username), localContentValues, "rowid=?", new String[] { paramad.dBe });
        }
      }
    }
  }
  
  public final int b(String[] paramArrayOfString1, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.AY()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.Bc()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.AZ()).append(" =0 and ");
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
    paramVarArgs = this.dXw.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      y.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      return i;
      i = 0;
    }
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList)
  {
    paramString1 = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList) + dx(null) + cus();
    y.v("MicroMsg.ContactStorage", paramString1);
    return this.dXw.rawQuery(paramString1, null);
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = "select username from rcontact " + e(paramString1, paramString2, paramList1) + dx(paramList2) + cus();
    y.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + j(paramList1, paramBoolean2) + cut();
      y.v("MicroMsg.ContactStorage", "favourSql " + paramString1);
      paramString2 = this.dXw.a(paramString2, null, 4);
      paramString1 = this.dXw.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.cf.a.f)) && ((paramString1 instanceof com.tencent.mm.cf.a.f))) {
        return new com.tencent.mm.cf.a.e(new com.tencent.mm.cf.a.f[] { (com.tencent.mm.cf.a.f)paramString2, (com.tencent.mm.cf.a.f)paramString1 });
      }
      return d.cwX();
    }
    return this.dXw.rawQuery(paramString1, null);
  }
  
  public final Cursor b(List<String> paramList1, String paramString, List<String> paramList2)
  {
    paramList1 = a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    y.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    return this.dXw.a(paramList1, null, 4);
  }
  
  public final void b(bd.a parama)
  {
    if (this.eeJ != null) {
      this.eeJ.remove(parama);
    }
  }
  
  public final int[] b(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    paramString1 = "select distinct showHead from rcontact " + e(paramString1, paramString2, paramList) + abs(paramString3) + cus();
    long l = System.currentTimeMillis();
    paramString1 = this.dXw.rawQuery(paramString1, null);
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    return paramString2;
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    paramString1 = "select distinct showHead from rcontact " + e(paramString1, paramString2, paramList) + J(paramArrayOfString) + cus();
    long l = System.currentTimeMillis();
    paramString1 = this.dXw.rawQuery(paramString1, null);
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - l));
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
    return paramString2;
  }
  
  public final int c(String[] paramArrayOfString1, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.AY()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.Bc()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.AZ()).append(" =0 and ");
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
    paramVarArgs = this.dXw.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      y.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      return i;
      i = 0;
    }
  }
  
  public final Cursor c(String paramString1, String paramString2, List<String> paramList)
  {
    return b(paramString1, paramString2, paramList);
  }
  
  public final Cursor c(List<String> paramList1, String paramString, List<String> paramList2)
  {
    paramList1 = a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId ", paramList1, paramString, paramList2);
    paramList1 = paramList1 + "group by OpenIMWordingInfo.wording ";
    paramList1 = paramList1 + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
    y.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", new Object[] { paramList1 });
    return this.dXw.a(paramList1, null, 4);
  }
  
  public final void c(String paramString, ad paramad)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (ad.hd(paramString)) {
        str = ad.aaZ(paramString);
      }
      paramad.fg(paramad.AE());
      if (s.e(paramad))
      {
        paramad.fg(43);
        paramad.dl(g.oZ(paramad.Bp()));
        paramad.dm(g.oY(paramad.Bp()));
        paramad.jdMethod_do(g.oY(paramad.Bq()));
        paramad.dp(paramad.Bq());
        return;
      }
      if (s.hK(paramad.field_username))
      {
        y.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
        paramad.fg(31);
      }
      this.eeJ.bV(paramad);
      this.eeJ.doNotify();
      y.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramad.field_username, Integer.valueOf(paramad.field_showHead), Integer.valueOf(paramad.field_verifyFlag) });
      paramString = paramad.vf();
      if ((int)paramad.dBe > 0) {
        paramString.put("rowid", Integer.valueOf((int)paramad.dBe));
      }
    } while (paramString.size() <= 0);
    this.dXw.update(abe(str), paramString, "username=?", new String[] { str });
  }
  
  public final int[] c(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    Object localObject = null;
    long l = System.currentTimeMillis();
    paramString1 = "select count(*) from rcontact " + e(paramString1, paramString2, paramList) + abs(paramString3);
    paramString1 = paramString1 + " group by showHead";
    paramString3 = this.dXw.rawQuery(paramString1, null);
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = paramString3.getCount();
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    return paramString1;
  }
  
  public final int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = null;
    paramString1 = "select count(*) from rcontact " + e(paramString1, paramString2, paramList) + J(paramArrayOfString);
    paramString1 = paramString1 + " group by showHead";
    paramArrayOfString = this.dXw.rawQuery(paramString1, null);
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
    return paramString1;
  }
  
  public final Cursor cuA()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
    ((StringBuilder)localObject).append("type & ").append(a.AY()).append(" !=0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.Bc()).append(" =0 and ");
    ((StringBuilder)localObject).append("type & ").append(a.AZ()).append(" =0 and ");
    ((StringBuilder)localObject).append("verifyFlag & 8 = 0 and ");
    ((StringBuilder)localObject).append("( username not like '%@%')");
    ((StringBuilder)localObject).append(" or username = 'weixin'");
    localObject = ((StringBuilder)localObject).toString();
    Cursor localCursor = this.dXw.a((String)localObject, null, 2);
    y.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[] { localObject });
    return localCursor;
  }
  
  public final List<String> cul()
  {
    Object localObject = " select openImAppid from rcontact" + cuy() + " group by openImAppid ";
    localObject = " select acctTypeId from OpenIMAppIdInfo where appid in (" + (String)localObject + ") group by acctTypeId";
    localObject = this.dXw.a((String)localObject, null, 4);
    LinkedList localLinkedList = new LinkedList();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        String str = ((Cursor)localObject).getString(0);
        if (!bk.bl(str)) {
          localLinkedList.add(str);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public final List<String> cum()
  {
    Object localObject = "select username from rcontact where " + cuv();
    localObject = this.dXw.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        localArrayList.add(((Cursor)localObject).getString(0));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final Cursor cun()
  {
    String str = "select * ,rowid from rcontact  where " + new StringBuilder("type & ").append(a.AZ()).append("=0 and username like '%@chatroom'").toString();
    return this.dXw.rawQuery(str, null);
  }
  
  public final Cursor cuo()
  {
    String str = "select * ,rowid from rcontact " + cuu() + " AND type & 256 !=0 " + cus();
    y.v("MicroMsg.ContactStorage", str);
    return this.dXw.rawQuery(str, null);
  }
  
  public final Cursor cup()
  {
    String str = "select * ,rowid from rcontact  where " + uAf + " and verifyFlag & " + ad.cuc() + " !=0 ";
    y.v("MicroMsg.ContactStorage", "dkbf:" + str);
    return this.dXw.rawQuery(str, null);
  }
  
  public final Cursor cuq()
  {
    String str = "select * ,rowid from rcontact " + cuu() + " AND " + uAf + " AND " + uAe + cut();
    y.v("MicroMsg.ContactStorage", str);
    return this.dXw.rawQuery(str, null);
  }
  
  public final int cur()
  {
    int i = 0;
    Object localObject = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
    y.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    return i;
  }
  
  public final Cursor cuz()
  {
    return this.dXw.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
  }
  
  public final Cursor d(String paramString1, String paramString2, List<String> paramList)
  {
    paramString1 = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList) + cus();
    y.v("MicroMsg.ContactStorage", paramString1);
    return this.dXw.rawQuery(paramString1, null);
  }
  
  public final Cursor dA(List<String> paramList)
  {
    paramList = "select * ,rowid from rcontact where (" + uAf + ") and (" + dy(paramList) + ")" + cut() + " and (username like  '%@openim' )";
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor dB(List<String> paramList)
  {
    paramList = "select * ,rowid from rcontact " + j(paramList, false) + cut();
    y.v("MicroMsg.ContactStorage", "favourSql " + paramList);
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor dC(List<String> paramList)
  {
    paramList = "select * ,rowid from rcontact " + dG(paramList) + cut();
    y.v("MicroMsg.ContactStorage", "favourSql " + paramList);
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final List<String> dD(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      y.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
      return new LinkedList();
    }
    long l = bk.UZ();
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
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(a.AY()), localStringBuilder.toString() });
    y.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[] { localObject });
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    y.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[] { Long.valueOf(bk.cp(l)), paramList, localLinkedList.toString() });
    return localLinkedList;
  }
  
  public final int[] dE(List<String> paramList)
  {
    paramList = "select distinct showHead from rcontact  where (" + dy(paramList) + ") " + cus();
    long l = System.currentTimeMillis();
    paramList = this.dXw.rawQuery(paramList, null);
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramList.getCount() >= 0) {}
    int[] arrayOfInt;
    for (int i = paramList.getCount();; i = 0)
    {
      y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    return arrayOfInt;
  }
  
  public final int[] dF(List<String> paramList)
  {
    int[] arrayOfInt = null;
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + dy(paramList);
    paramList = paramList + " group by showHead";
    Cursor localCursor = this.dXw.a(paramList, null, 2);
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = localCursor.getCount();
    y.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
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
    return paramList;
  }
  
  public final Cursor dt(List<String> paramList)
  {
    int i = 0;
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
      label22:
      if (i >= paramList.size()) {
        break label141;
      }
      if (i == paramList.size() - 1) {
        break label97;
      }
    }
    label97:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label22;
      bool = false;
      break;
    }
    label141:
    paramList = str + cus();
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor du(List<String> paramList)
  {
    int i = 0;
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ";
      label22:
      if (i >= paramList.size()) {
        break label141;
      }
      if (i == paramList.size() - 1) {
        break label97;
      }
    }
    label97:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label22;
      bool = false;
      break;
    }
    label141:
    paramList = str + cus();
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor dv(List<String> paramList)
  {
    int i = 0;
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where ";
      label22:
      if (i >= paramList.size()) {
        break label141;
      }
      if (i == paramList.size() - 1) {
        break label97;
      }
    }
    label97:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label22;
      bool = false;
      break;
    }
    label141:
    paramList = str + cus();
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor dw(List<String> paramList)
  {
    int j = 0;
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where (";
      i = 0;
      label26:
      if (i >= paramList.size()) {
        break label146;
      }
      if (i == paramList.size() - 1) {
        break label102;
      }
    }
    label102:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label26;
      bool = false;
      break;
    }
    label146:
    str = str + ") order by case username ";
    int i = j;
    while (i < paramList.size())
    {
      str = str + " when '" + (String)paramList.get(i) + "' then " + i;
      i += 1;
    }
    paramList = str + " end";
    y.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + paramList);
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final Cursor dz(List<String> paramList)
  {
    paramList = "select * ,rowid from rcontact where (" + uAf + ") and (" + dy(paramList) + ")" + cut();
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final String e(String paramString1, String paramString2, List<String> paramList)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool8 = true;
    boolean bool1 = true;
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + U(true, false);
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
        paramString1 = "" + cuu();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = new StringBuilder().append("");
        paramString2 = "(type & " + a.AY() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom'))";
        paramString2 = " where (" + paramString2 + ") and ";
        paramString1 = new StringBuilder().append(paramString2).append("type & ").append(a.Bc()).append("=0 ").toString();
      }
      else
      {
        if (paramString1.equals("@all.contact.without.chatroom"))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = U(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (;;)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + cuw() + ')' + " or (" + cLl() + ")";
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
            bool1 = false;
          }
        }
        if ((paramString1.equals("@all.contact.without.chatroom.without.openim")) || (paramString1.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = U(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (bool1 = bool2;; bool1 = false)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + cuw() + ')';
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
          }
        }
        if (paramString1.equals("@black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.AZ()).append("!=0").toString();
        }
        else if (paramString1.equals("@werun.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.Ba()).append("!=0").toString();
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
            str1 = U(true, false);
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
            paramString2 = U(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool4;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + cuv() + ')';
              String str2 = " or (" + cuw() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(str2).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.AY() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + a.Bc() + " =0 and ";
            paramString2 = paramString2 + "type & " + a.AZ() + " =0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.cuc() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool5;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + cuv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = cLk();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool6;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + cuv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com.openim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = cLk();
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool7;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + cuv() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(" or (username like '%@openim'))").toString();
              break;
            }
          }
          if (paramString1.equals("@qqim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = U(false, false);
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
            paramString2 = "type & " + a.AY() + " !=0";
            paramString2 = paramString2 + " or type & 2 !=0";
            paramString2 = paramString2 + " or type & 4 !=0";
            paramString2 = paramString2 + " or 1";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@verify.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.AY() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.cub() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@biz.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.AY() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + ad.cuc() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@all.weixin.android"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.AY() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@openim.contact"))
          {
            paramString1 = "" + cuy();
          }
          else
          {
            y.d("MicroMsg.ContactStorage", "unknow role type");
            paramString1 = "" + U(false, false);
          }
        }
      }
    }
    return paramString1 + paramString2;
  }
  
  public final ad hE(long paramLong)
  {
    ad localad = null;
    Object localObject = null;
    if (paramLong <= 0L) {}
    do
    {
      return localObject;
      localObject = "select * ,rowid from rcontact  where rowid=" + paramLong;
      localObject = this.dXw.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localad = new ad();
        localad.d((Cursor)localObject);
        S(localad);
      }
      ((Cursor)localObject).close();
      localObject = localad;
    } while (localad == null);
    localad.cuf();
    return localad;
  }
  
  public final Cursor i(List<String> paramList, boolean paramBoolean)
  {
    String str = "select * ,rowid from rcontact  where " + dy(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + cus();
    }
    y.d("MicroMsg.ContactStorage", "sql " + paramList);
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final int x(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      return -1;
    }
    ae localae = new ae();
    localae.field_cmdbuf = paramArrayOfByte;
    localae.field_username = paramString;
    int j = (int)this.dXw.replace("ContactCmdBuf", "username", localae.vf());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      y.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      return j;
      i = paramArrayOfByte.length;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.aj
 * JD-Core Version:    0.7.0.1
 */