package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class al
  extends m
  implements be
{
  public static final String[] dXp = { i.a(com.tencent.mm.o.a.buS, "rconversation"), i.a(com.tencent.mm.o.a.buS, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
  private final com.tencent.mm.sdk.e.e dXw;
  private be.b uAi;
  private com.tencent.mm.plugin.messenger.foundation.a.e uAj;
  private al.a uAk = new al.a((byte)0);
  private k<be.a, ak> uAl = new al.1(this);
  private k<be.a, ak> uAm = new k() {};
  
  public al(com.tencent.mm.sdk.e.e parame)
  {
    Assert.assertTrue(parame instanceof h);
    Object localObject = parame.a("PRAGMA table_info( rconversation)", null, 2);
    int i = ((Cursor)localObject).getColumnIndex("name");
    do
    {
      if (!((Cursor)localObject).moveToNext()) {
        break;
      }
    } while ((i < 0) || (!"flag".equalsIgnoreCase(((Cursor)localObject).getString(i))));
    for (i = 1;; i = 0)
    {
      ((Cursor)localObject).close();
      localObject = i.a(com.tencent.mm.o.a.buS, "rconversation", parame);
      ((List)localObject).addAll(i.a(com.tencent.mm.o.a.buS, "rbottleconversation", parame));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.gk("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        parame.gk("rconversation", "update rconversation set flag = conversationTime");
      }
      this.dXw = parame;
      return;
    }
  }
  
  private static String abt(String paramString)
  {
    y.v("MicroMsg.ConversationStorage", "talker :" + paramString);
    if (ad.hd(paramString)) {
      return "rbottleconversation";
    }
    return "rconversation";
  }
  
  private static long c(ak paramak)
  {
    if (paramak != null) {
      return com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, paramak.field_conversationTime);
    }
    return bk.UY() & 0xFFFFFFFF;
  }
  
  private long cuG()
  {
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.dXw.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    y.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    return l1;
  }
  
  private static void e(ak paramak)
  {
    if (paramak == null) {}
    do
    {
      do
      {
        return;
      } while (paramak.field_unReadCount <= 0);
      y.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
    } while ((paramak.field_attrflag & 0x100000) == 0);
    paramak.fy(paramak.field_unReadCount - 1);
    paramak.fC(paramak.field_attrflag & 0xFFEFFFFF);
  }
  
  public final boolean DL(String paramString)
  {
    paramString = this.dXw.a(abt(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      return bool;
    }
  }
  
  public final boolean HH(String paramString)
  {
    y.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.ak.crj() });
    boolean bool = this.dXw.gk("rconversation", "delete from " + abt(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    return bool;
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
      y.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
  
  public final int a(ak paramak, String paramString)
  {
    return a(paramak, paramString, true);
  }
  
  public final int a(ak paramak, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ConversationStorage", "update conversation failed");
      return 0;
    }
    if (paramBoolean) {
      paramak.bb(c(paramak));
    }
    e(paramak);
    int i = this.dXw.update(abt(paramString), paramak.vf(), "username=?", new String[] { paramString });
    if (i != 0)
    {
      b(3, this, paramString);
      return i;
    }
    y.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { abt(paramString) });
    return i;
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.dBg == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bk.pm(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bk.pl(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    y.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramString1 = this.dXw;
    paramList = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0) {
      return paramString1.a(paramList, null, i);
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    str2 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bk.pm(paramString1);
    str1 = "";
    paramString1 = str1;
    if (paramList != null)
    {
      paramString1 = str1;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + " and rconversation.username != '" + str1 + "'") {
          str1 = (String)paramList.next();
        }
      }
    }
    paramList = str2 + paramString1;
    paramString1 = paramList;
    if (paramBoolean) {
      paramString1 = paramList + " and ( verifyFlag & 8 ) = 0";
    }
    paramList = paramString1;
    if (paramString2 != null)
    {
      paramList = paramString1;
      if (paramString2.length() > 0) {
        paramList = paramString1 + new StringBuilder(" and ( rconversation.username like '%").append(paramString2).append("%' or content like '%").append(paramString2).append("%' or rcontact.nickname like '%").append(paramString2).append("%' or rcontact.alias like '%").append(paramString2).append("%' or rcontact.pyInitial like '%").append(paramString2).append("%' or rcontact.quanPin like '%").append(paramString2).append("%' or rcontact.conRemark like '%").append(paramString2).append("%'  ) ").toString();
      }
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {}
    for (paramString1 = paramList + " order by flag desc, conversationTime desc";; paramString1 = paramList + " order by rconversation.username like \"%@chatroom\" asc")
    {
      y.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + paramString1);
      return this.dXw.rawQuery(paramString1, null);
    }
  }
  
  public final Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
    localStringBuilder.append(" from rconversation where (");
    int i = 0;
    if (i < paramArrayList.size())
    {
      if (i != paramArrayList.size() - 1) {
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "' OR ");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "'");
      }
    }
    localStringBuilder.append(") and ");
    if (com.tencent.mm.o.a.dBg == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bk.pm(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramArrayList = paramList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (String)paramArrayList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString1).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bk.pl(paramString2)).append("' ");
      }
    }
    y.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + localStringBuilder.toString());
    return this.dXw.rawQuery(localStringBuilder.toString(), null);
  }
  
  public final com.tencent.mm.vending.b.b a(f paramf)
  {
    return this.uAk.aj(paramf);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.e parame)
  {
    this.uAj = parame;
  }
  
  public final void a(ak paramak, int paramInt1, int paramInt2)
  {
    String str = paramak.field_username;
    if (!((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HQ(str)) {
      return;
    }
    if (bk.pm(paramak.field_username).length() <= 0)
    {
      y.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      return;
    }
    if (paramak.field_msgCount == 0)
    {
      str = paramak.field_username;
      paramak.fx(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HR(str));
      y.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      y.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramak.field_msgCount), paramak.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      if (paramInt1 > 0)
      {
        paramak.fx(paramak.field_msgCount - paramInt1);
        if (paramak.field_msgCount < 0)
        {
          y.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramak.fx(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramak.fx(paramak.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(be.a parama)
  {
    this.uAm.a(parama, null);
  }
  
  public final void a(be.b paramb)
  {
    this.uAi = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = false;
    if (bk.bl(paramString))
    {
      paramBoolean = bool;
      return paramBoolean;
    }
    if (abv(paramString) == null) {
      return true;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2 | paramInt1;; paramInt1 = (paramInt1 ^ 0xFFFFFFFF) & paramInt2)
    {
      paramBoolean = bool;
      if (paramInt1 == paramInt2) {
        break;
      }
      bool = this.dXw.gk("rconversation", "update " + abt(paramString) + " set attrflag = " + paramInt1 + " where username = \"" + bk.pl(paramString) + "\"");
      paramBoolean = bool;
      if (!bool) {
        break;
      }
      b(3, this, paramString);
      return bool;
    }
  }
  
  public final void aA(LinkedList<String> paramLinkedList)
  {
    y.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { com.tencent.mm.sdk.platformtools.ak.crj() });
    if (paramLinkedList.isEmpty())
    {
      y.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = (String)paramLinkedList.poll();
    localStringBuilder.append("delete from rconversation where ");
    localStringBuilder.append("username='").append(str).append('\'');
    while (!paramLinkedList.isEmpty())
    {
      str = (String)paramLinkedList.poll();
      localStringBuilder.append(" or username='").append(str).append('\'');
    }
    y.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.dXw.gk("rconversation", localStringBuilder.toString());
  }
  
  public final boolean abA(String paramString)
  {
    boolean bool1 = false;
    if ((paramString == null) || (paramString.length() <= 0)) {
      y.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = abv(paramString);
      if (paramString == null)
      {
        y.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
        return false;
      }
      bool2 = this.dXw.gk("rconversation", "update " + abt(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, cuG() + 1L) + " where username = \"" + bk.pl(paramString.field_username) + "\"");
      bool1 = bool2;
    } while (!bool2);
    b(3, this, paramString.field_username);
    return bool2;
  }
  
  public final boolean abB(String paramString)
  {
    boolean bool1 = false;
    if ((paramString == null) || (paramString.length() <= 0)) {
      y.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (abv(paramString) == null)
        {
          ak localak = new ak(paramString);
          localak.ba(System.currentTimeMillis());
          d(localak);
          y.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + paramString);
        }
        paramString = abv(paramString);
      } while (paramString == null);
      bool2 = this.dXw.gk("rconversation", "update " + abt(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L) + " where username = \"" + bk.pl(paramString.field_username) + "\"");
      bool1 = bool2;
    } while (!bool2);
    b(3, this, paramString.field_username);
    return bool2;
  }
  
  public final boolean abC(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      return false;
    }
    return f(abv(paramString));
  }
  
  public final boolean abD(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      return false;
    }
    return g(abv(paramString));
  }
  
  public final Cursor abE(String paramString)
  {
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bk.pm(paramString) + " order by flag desc, conversationTime desc";
    return this.dXw.rawQuery(paramString, null);
  }
  
  public final Cursor abF(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT username, unReadCount");
    localStringBuilder.append(" FROM rconversation");
    localStringBuilder.append(" WHERE (username LIKE '%@chatroom' ");
    localStringBuilder.append(" or username LIKE '%@im.chatroom' ) ");
    localStringBuilder.append(bk.pm(paramString));
    localStringBuilder.append(" AND unReadCount > 0");
    paramString = localStringBuilder.toString();
    return this.dXw.rawQuery(paramString, null);
  }
  
  public final Cursor abG(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(rconversation.username)");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bk.pm(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.dBg).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
    paramString = localStringBuilder.toString();
    y.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    return this.dXw.rawQuery(paramString, null);
  }
  
  public final Cursor abH(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rconversation.username");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bk.pm(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.dBg).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    paramString = localStringBuilder.toString();
    y.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    return this.dXw.rawQuery(paramString, null);
  }
  
  public final int abI(String paramString)
  {
    int i = 0;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    y.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.dXw.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    return i;
  }
  
  public final String abJ(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("SELECT rconversation.username");
    ((StringBuilder)localObject2).append(" FROM rconversation");
    ((StringBuilder)localObject2).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject2).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject2).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject2).toString();
    y.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    localObject2 = this.dXw.a(paramString, null, 2);
    paramString = localObject1;
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        paramString = ((Cursor)localObject2).getString(0);
        ((Cursor)localObject2).close();
      }
    }
    else {
      return paramString;
    }
    ((Cursor)localObject2).close();
    return null;
  }
  
  public final ak abK(String paramString)
  {
    Cursor localCursor = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().c(s.dUT, null, paramString);
    if (localCursor != null)
    {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new ak();
        paramString.d(localCursor);
      }
      for (;;)
      {
        localCursor.close();
        return paramString;
        paramString = null;
      }
    }
    return null;
  }
  
  public final int abL(String paramString)
  {
    int i = 0;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bk.bl(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    y.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.dXw.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    return i;
  }
  
  public final void abM(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bk.pl(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    y.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.dXw.gk("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
  }
  
  public final void abN(String paramString)
  {
    int i = this.dXw.delete(abt(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    y.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
  }
  
  public final int abO(String paramString)
  {
    int i = -1;
    if ((paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + h.fA(paramString);
    paramString = this.dXw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final void abu(String paramString)
  {
    y.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.ak.crj() });
    if (this.dXw.delete(abt(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
  }
  
  public final ak abv(String paramString)
  {
    Cursor localCursor = this.dXw.a(abt(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.ConversationStorage", "get null with username:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new ak();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
  
  public final void abw(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.dXw.update("rconversation", localContentValues, "username=?", new String[] { paramString });
  }
  
  public final boolean abx(String paramString)
  {
    boolean bool2 = true;
    if ((paramString == null) || (paramString.length() <= 0)) {
      y.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      boolean bool1 = false;
      Object localObject;
      do
      {
        do
        {
          return bool1;
          y.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
          localObject = abv(paramString);
          bool1 = bool2;
        } while (localObject == null);
        if ((((as)localObject).field_unReadCount != 0) || (((as)localObject).field_unReadMuteCount != 0) || (!paramString.equals(((as)localObject).field_username))) {
          break;
        }
        a(paramString, 1048576, false, ((as)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        bool1 = bool2;
      } while (this.dXw.update(abt(paramString), (ContentValues)localObject, "username= ?", new String[] { bk.pl(paramString) }) <= 0);
      b(3, this, paramString);
      return true;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(((as)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.dXw.update(abt(paramString), localContentValues, "username= ?", new String[] { bk.pl(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    return true;
  }
  
  public final boolean aby(String paramString)
  {
    if (paramString.length() <= 0) {
      y.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
    }
    int i;
    do
    {
      return false;
      y.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
      ak localak = abv(paramString);
      if (localak == null) {
        return true;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(localak.field_attrflag & 0xFFEFFFFF));
      i = this.dXw.update(abt(paramString), localContentValues, "parentRef= ?", new String[] { bk.pl(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    return true;
  }
  
  public final boolean abz(String paramString)
  {
    boolean bool1;
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ConversationStorage", "update conversation failed");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      ak localak = abv(paramString);
      if ((localak == null) || ((localak.field_unReadCount > 0) && (paramString.equals(localak.field_username)))) {
        return true;
      }
      bool2 = this.dXw.gk("rconversation", "update " + abt(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localak.field_attrflag | 0x100000) + " where username = \"" + bk.pl(paramString) + "\"");
      bool1 = bool2;
    } while (!bool2);
    b(3, this, paramString);
    return bool2;
  }
  
  public final void aj(bi parambi)
  {
    String str = parambi.field_talker;
    int i = 0;
    ak localak2 = abv(str);
    if ((localak2 != null) && (localak2.field_conversationTime > parambi.field_createTime) && (localak2.field_conversationTime != 9223372036854775807L))
    {
      y.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      return;
    }
    ak localak1 = localak2;
    if (localak2 == null)
    {
      localak1 = new ak(str);
      i = 1;
    }
    localak1.fA(parambi.field_isSend);
    localak1.fy(localak1.field_unReadCount);
    localak1.ai(parambi);
    localak1.dP(Integer.toString(parambi.getType()));
    localak1.bb(localak1.field_flag & 0x0 | parambi.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      d(localak1);
      return;
    }
    a(localak1, str, true);
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.g paramg, g.c paramc)
  {
    if (paramc == null)
    {
      y.f("MicroMsg.ConversationStorage", "null notifyInfo");
      return;
    }
    Object localObject2 = paramc.talker;
    Object localObject1 = abv((String)localObject2);
    bi localbi = paramg.HA((String)localObject2);
    if (localObject1 == null)
    {
      y.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject2 });
      paramg = new ak((String)localObject2);
      if (ad.hd((String)localObject2)) {
        paramg.fz(1);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.uAk.a(localbi, paramg, bool, paramc);
      y.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc.talker, paramc.mdt, Integer.valueOf(paramc.mdv) });
      long l1;
      long l2;
      if ((localbi != null) && (localbi.field_msgId != 0L))
      {
        if ((paramc.mdv == 1) && (((bi)paramc.mdu.get(0)).field_msgId != localbi.field_msgId)) {
          y.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(((bi)paramc.mdu.get(0)).field_msgId) });
        }
        i = localbi.field_flag;
        l1 = paramg.field_lastSeq;
        l2 = localbi.field_msgSeq;
        y.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramg.field_UnDeliverCount) });
        if (((!paramc.mdt.equals("insert")) || (paramc.mdv <= 0)) && ((!paramc.mdt.equals("update")) || (paramg.field_unReadCount + paramc.mdv < 0))) {
          break label568;
        }
        paramg.fy(paramg.field_unReadCount + paramc.mdv);
        if (l2 > l1)
        {
          y.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          paramg.bc(l2);
        }
        if ((localbi.aRR()) && (localbi.field_isSend == 1))
        {
          paramg.field_sightTime = localbi.field_createTime;
          paramg.cDs = true;
        }
      }
      label458:
      Object localObject3;
      if ((paramc.mdt.equals("insert")) && (paramc.mdu.size() > 0) && (s.fn(paramc.talker)))
      {
        localObject1 = q.Gj();
        localObject2 = paramc.mdu.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label771;
          }
          localObject3 = (bi)((Iterator)localObject2).next();
          if (((cs)localObject3).field_isSend != 1) {
            if (!((bi)localObject3).isText())
            {
              if (((bi)localObject3).getType() != 503316529) {
                break label720;
              }
              i = 1;
              label510:
              if (i == 0) {}
            }
            else
            {
              if (!((bi)localObject3).abY((String)localObject1)) {
                break label725;
              }
              paramg.fD(paramg.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = bn.s(((cs)localObject3).field_content, "sysmsg");
            if (!bi.av((Map)localObject3)) {
              break label748;
            }
            paramg.fG(paramg.field_UnReadInvite + 1);
            break label458;
            label568:
            if ((paramc.mdx <= 0) || (l2 >= l1) || (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().P(paramg.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HW(paramg.field_username);
            y.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            paramg.bc(l2);
            if (l1 <= l3) {
              break;
            }
            ((j)com.tencent.mm.kernel.g.r(j.class)).Gb().L(paramg.field_username, l3);
            break;
            label720:
            i = 0;
            break label510;
            label725:
            if (((bi)localObject3).cvJ()) {
              paramg.fD(paramg.field_atCount + 4096);
            }
          }
          label748:
          if (bi.aw((Map)localObject3)) {
            paramg.fG(paramg.field_UnReadInvite + 4096);
          }
        }
      }
      label771:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.mdt != null)
          {
            j = k;
            if (paramc.mdt.equals("delete"))
            {
              if (paramc.mdx > 0) {
                i = paramc.mdx;
              }
              y.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.mdx) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.mdt != null) && (paramc.mdt.equals("insert"))) {
          if (paramc.mdw > 0)
          {
            i = paramc.mdw;
            y.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.mdw) });
          }
        }
        for (;;)
        {
          localObject2 = bk.aM((String)localObject1, "");
          if (localbi != null) {}
          for (l1 = localbi.field_msgSeq;; l1 = -1L)
          {
            y.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), paramg.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            y.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, paramg.field_username });
            return;
          }
          this.uAl.bV(paramg);
          this.uAl.doNotify();
          if (localObject1 == null)
          {
            y.e("MicroMsg.ConversationStorage", "talker == null");
            return;
          }
          if (!((String)localObject1).equals(paramg.field_username))
          {
            y.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            return;
          }
          if ((localbi != null) && (localbi.field_msgId != 0L))
          {
            y.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localbi.field_msgId);
            paramg.ai(localbi);
            if (this.uAi != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.uAi.a(localbi, (PString)localObject2, (PString)localObject3, localPInt, paramg.gV(2097152));
              y.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              paramg.dQ(((PString)localObject2).value);
              paramg.dR(((PString)localObject3).value);
              paramg.fB(localPInt.value);
              paramg.dP(Integer.toString(localbi.getType()));
              if (this.uAj != null) {
                this.uAj.a(localbi, paramg);
              }
              paramg.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramg, 1, localbi.field_createTime));
              if (!bool) {
                break label1519;
              }
              localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl((String)localObject1);
              if ((localObject1 != null) && (!bk.bl(((ao)localObject1).field_username)) && (((ad)localObject1).Bl())) {
                paramg.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramg, 2, 0L));
              }
              a(paramg, j, i);
              if ((!localbi.aRR()) && (!com.tencent.mm.sdk.a.b.cqm())) {
                break label1509;
              }
              paramg.ba(localbi.field_createTime);
              label1396:
              d(paramg);
            }
          }
          label1509:
          label1519:
          do
          {
            for (;;)
            {
              this.uAm.bV(paramg);
              this.uAm.doNotify();
              this.uAk.b(localbi, paramg, bool, paramc);
              return;
              localObject2 = bd(localbi.getType(), paramg.field_content);
              localObject3 = bk.pm(paramg.field_digest);
              if (bk.bl((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + bk.pm((String)localObject2))
              {
                paramg.dQ(((String)localObject3).concat((String)localObject2));
                break;
              }
              paramg.ba(bk.UY());
              break label1396;
              a(paramg, j, i);
              a(paramg, (String)localObject1, true);
              continue;
              y.i("MicroMsg.ConversationStorage", "update null conversation with talker " + (String)localObject1);
              if (bool) {
                break label1591;
              }
              paramg.cuB();
              a(paramg, j, i);
              a(paramg, (String)localObject1, true);
            }
          } while (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HP((String)localObject1) <= 0);
          label1591:
          if ((localbi.aRR()) || (com.tencent.mm.sdk.a.b.cqm())) {
            paramg.ba(localbi.field_createTime);
          }
          for (;;)
          {
            a(paramg, j, i);
            d(paramg);
            break;
            paramg.ba(bk.UY());
          }
          i = 0;
          break;
          i = 0;
        }
      }
      paramg = (com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject1;
    }
  }
  
  public final void b(be.a parama)
  {
    this.uAm.remove(parama);
  }
  
  public final String bd(int paramInt, String paramString)
  {
    if (!bk.bl(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return null;
      paramString = bn.s(paramString, "msg");
    } while (paramString == null);
    paramString = (String)paramString.get(".msg.appmsg.title");
    y.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramString });
    return paramString;
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.dBg == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bk.pm(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bk.pl(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    return this.dXw.rawQuery(localStringBuilder.toString(), null);
  }
  
  public final void c(be.a parama)
  {
    this.uAl.a(parama, null);
  }
  
  public final boolean cuC()
  {
    boolean bool1 = this.dXw.gk("rconversation", "delete from rconversation");
    boolean bool2 = this.dXw.gk("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        b(5, this, "");
      }
      return bool1;
    }
  }
  
  public final boolean cuD()
  {
    y.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", new Object[] { com.tencent.mm.sdk.platformtools.ak.crj() });
    boolean bool = this.dXw.gk("rconversation", "delete from rbottleconversation");
    if (bool) {
      b(5, this, "");
    }
    return bool;
  }
  
  public final HashMap<String, Long> cuE()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.dXw.a("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return localHashMap;
    }
    int i;
    if (localCursor == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label155;
      }
      localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      localCursor.moveToNext();
      break;
      if ((localCursor.isClosed()) || (localCursor.isBeforeFirst()) || (localCursor.isAfterLast())) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label155:
    localCursor.close();
    y.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    return localHashMap;
  }
  
  public final void cuF()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.dXw.update("rconversation", localContentValues, null, null);
  }
  
  public final List<String> cuH()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bk.pm(bk.pm(s.dUT)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(" and rconversation.username != '").append(str).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(" order by sightTime desc, flag desc, conversationTime desc");
    localObject = this.dXw.a(((StringBuilder)localObject).toString(), null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localArrayList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
    }
    y.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    return localArrayList;
  }
  
  public final List<String> cuI()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = "select username from rconversation";
    int i = 0;
    if (i < localArrayList2.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
      if (i > 0) {}
      for (localObject = " and ";; localObject = " where ")
      {
        localObject = (String)localObject + "username != \"" + bk.pl((String)localArrayList2.get(i)) + "\"";
        i += 1;
        break;
      }
    }
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    localObject = this.dXw.rawQuery((String)localObject, null);
    i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList1.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    return localArrayList1;
  }
  
  public final Cursor cuJ()
  {
    return this.dXw.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
  }
  
  public final int cuK()
  {
    int i = 0;
    int j = 0;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    y.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    return i;
  }
  
  public final String cuL()
  {
    String str = null;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    y.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst())
      {
        str = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
      }
    }
    else {
      return str;
    }
    ((Cursor)localObject).close();
    return null;
  }
  
  public final Cursor cuM()
  {
    y.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    return this.dXw.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
  }
  
  public final ak cuN()
  {
    Cursor localCursor = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().c(s.dUT, null, "officialaccounts");
    if (localCursor != null)
    {
      ak localak;
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localak = new ak();
        localak.d(localCursor);
      }
      for (;;)
      {
        localCursor.close();
        return localak;
        localak = null;
      }
    }
    return null;
  }
  
  public final long d(ak paramak)
  {
    String str = bk.pm(paramak.field_username);
    if (str.length() <= 0)
    {
      y.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      return -1L;
    }
    paramak.bb(c(paramak));
    e(paramak);
    long l = this.dXw.insert(abt(str), null, paramak.vf());
    if (l != -1L) {
      b(2, this, paramak.field_username);
    }
    for (;;)
    {
      return l;
      y.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { abt(str) });
    }
  }
  
  public final void d(be.a parama)
  {
    this.uAl.remove(parama);
  }
  
  public final void d(String[] paramArrayOfString, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bk.pm(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    y.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.dXw.gk("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        b(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
  }
  
  public final boolean f(ak paramak)
  {
    boolean bool1;
    if (paramak == null)
    {
      y.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.dXw.gk("rconversation", "update " + abt(paramak.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, 3, paramak.field_conversationTime) + " where username = \"" + bk.pl(paramak.field_username) + "\"");
      bool1 = bool2;
    } while (!bool2);
    b(3, this, paramak.field_username);
    return bool2;
  }
  
  public final boolean g(ak paramak)
  {
    if (paramak == null) {
      y.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
    }
    while (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, 4, 0L) == 0L) {
      return false;
    }
    return true;
  }
  
  public final Cursor go(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.dBg).append(" or parentRef = '' ) ").append(bk.pm(paramString2));
    paramString1 = localStringBuilder.toString();
    return this.dXw.rawQuery(paramString1, null);
  }
  
  public final int ie(String paramString)
  {
    int i = 0;
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bk.pm(paramString);
    paramString = this.dXw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final Cursor l(List<String> paramList, int paramInt)
  {
    String str = "select username from rconversation";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (str = " and ";; str = " where ")
      {
        str = str + "username != \"" + bk.pl((String)paramList.get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = str + " order by flag desc, conversationTime desc limit 50 offset " + paramInt;
    return this.dXw.rawQuery(paramList, null);
  }
  
  public final be.b tt()
  {
    return this.uAi;
  }
  
  public final Cursor x(String paramString, List<String> paramList)
  {
    y.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[] { paramString, bk.csb() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
    localStringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(com.tencent.mm.o.a.dBg).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(bk.pm(paramString)).append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts'");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localStringBuilder.append(" AND rconversation.username != '").append(paramList).append("'");
      }
    }
    paramString = localStringBuilder.toString();
    y.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[] { paramString });
    return this.dXw.rawQuery(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.al
 * JD-Core Version:    0.7.0.1
 */