package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class an
  extends n
  implements bh
{
  public static final String[] SQL_CREATE;
  private bh.b FxY;
  private com.tencent.mm.plugin.messenger.foundation.a.e FxZ;
  private a Fya;
  private l<bh.a, am> Fyb;
  private l<bh.a, am> Fyc;
  private final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117133);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.o.a.info, "rconversation"), j.getCreateSQLs(com.tencent.mm.o.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
    AppMethodBeat.o(117133);
  }
  
  public an(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(117067);
    this.Fya = new a((byte)0);
    this.Fyb = new l() {};
    this.Fyc = new l() {};
    Assert.assertTrue(parame instanceof com.tencent.mm.storagebase.h);
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
      localObject = j.getUpdateSQLs(com.tencent.mm.o.a.info, "rconversation", parame);
      ((List)localObject).addAll(j.getUpdateSQLs(com.tencent.mm.o.a.info, "rbottleconversation", parame));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.execSQL("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        parame.execSQL("rconversation", "update rconversation set flag = conversationTime");
      }
      this.db = parame;
      AppMethodBeat.o(117067);
      return;
    }
  }
  
  private static String G(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117104);
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0)
      {
        paramString = "" + paramString + " not in (";
        int i = 0;
        if (i < paramList.size())
        {
          localObject = new StringBuilder().append(paramString).append("\"").append(bt.aFQ((String)paramList.get(i))).append("\"");
          if (i == paramList.size() - 1) {}
          for (paramString = "";; paramString = ",")
          {
            paramString = paramString;
            i += 1;
            break;
          }
        }
        localObject = paramString + ") ";
      }
    }
    AppMethodBeat.o(117104);
    return localObject;
  }
  
  private static String aIk(String paramString)
  {
    AppMethodBeat.i(117068);
    ad.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (af.st(paramString))
    {
      AppMethodBeat.o(117068);
      return "rbottleconversation";
    }
    AppMethodBeat.o(117068);
    return "rconversation";
  }
  
  private static long d(am paramam)
  {
    AppMethodBeat.i(117075);
    if (paramam != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramam, paramam.field_conversationTime);
      AppMethodBeat.o(117075);
      return l;
    }
    long l = bt.eGO();
    AppMethodBeat.o(117075);
    return l & 0xFFFFFFFF;
  }
  
  private static void f(am paramam)
  {
    AppMethodBeat.i(117092);
    if (paramam == null)
    {
      AppMethodBeat.o(117092);
      return;
    }
    if (paramam.field_unReadCount > 0)
    {
      ad.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramam.field_attrflag & 0x100000) != 0)
      {
        paramam.jT(paramam.field_unReadCount - 1);
        paramam.jX(paramam.field_attrflag & 0xFFEFFFFF);
      }
    }
    AppMethodBeat.o(117092);
  }
  
  public final Cursor H(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117114);
    ad.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[] { paramString, bt.eGN() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
    localStringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(com.tencent.mm.o.a.fIf).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(bt.nullAsNil(paramString)).append(" AND ( type & 512 ) == 0");
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
    ad.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117114);
    return paramString;
  }
  
  public final Cursor I(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117115);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(rconversation.username)");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bt.nullAsNil(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.fIf).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
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
    ad.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117115);
    return paramString;
  }
  
  public final bh.b Lu()
  {
    return this.FxY;
  }
  
  public final int a(am paramam, String paramString)
  {
    AppMethodBeat.i(204826);
    int i = a(paramam, paramString, true);
    AppMethodBeat.o(204826);
    return i;
  }
  
  public final int a(am paramam, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117091);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117091);
      return 0;
    }
    if (paramBoolean) {
      paramam.kT(d(paramam));
    }
    f(paramam);
    int i = this.db.update(aIk(paramString), paramam.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      b(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(117091);
      return i;
      ad.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { aIk(paramString) });
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117102);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.fIf == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bt.aFQ(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    ad.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramString1 = this.db;
    paramList = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramString1 = paramString1.a(paramList, null, i);
      AppMethodBeat.o(117102);
      return paramString1;
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(117105);
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    paramString1 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bt.nullAsNil(paramString1);
    paramList = G(" and rconversation.username", paramList);
    paramList = paramString1 + paramList;
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
      ad.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramString1)));
      paramString1 = this.db.rawQuery(paramString1, null);
      AppMethodBeat.o(117105);
      return paramString1;
    }
  }
  
  public final Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(117103);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo");
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
    if (com.tencent.mm.o.a.fIf == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bt.aFQ(paramString2)).append("' ");
      }
    }
    ad.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117103);
    return paramArrayList;
  }
  
  public final com.tencent.mm.vending.b.b a(f paramf)
  {
    AppMethodBeat.i(117069);
    paramf = this.Fya.bv(paramf);
    AppMethodBeat.o(117069);
    return paramf;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.e parame)
  {
    this.FxZ = parame;
  }
  
  public final void a(am paramam, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117083);
    if (!bi.ui(paramam.field_username))
    {
      AppMethodBeat.o(117083);
      return;
    }
    if (bt.nullAsNil(paramam.field_username).length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(117083);
      return;
    }
    if (paramam.field_msgCount == 0)
    {
      paramam.jS(bi.uh(paramam.field_username));
      ad.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ad.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramam.field_msgCount), paramam.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(117083);
      return;
      if (paramInt1 > 0)
      {
        paramam.jS(paramam.field_msgCount - paramInt1);
        if (paramam.field_msgCount < 0)
        {
          ad.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramam.jS(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramam.jS(paramam.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(bh.a parama)
  {
    AppMethodBeat.i(117070);
    this.Fyc.a(parama, null);
    AppMethodBeat.o(117070);
  }
  
  public final void a(bh.b paramb)
  {
    this.FxY = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117089);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if (aIn(paramString) == null)
    {
      AppMethodBeat.o(117089);
      return true;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2 | paramInt1; paramInt1 == paramInt2; paramInt1 = (paramInt1 ^ 0xFFFFFFFF) & paramInt2)
    {
      AppMethodBeat.o(117089);
      return false;
    }
    paramBoolean = this.db.execSQL("rconversation", "update " + aIk(paramString) + " set attrflag = " + paramInt1 + " where username = \"" + bt.aFQ(paramString) + "\"");
    if (paramBoolean) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117089);
    return paramBoolean;
  }
  
  public final void aH(bl parambl)
  {
    AppMethodBeat.i(117080);
    String str = parambl.field_talker;
    int i = 0;
    am localam2 = aIn(str);
    if ((localam2 != null) && (localam2.field_conversationTime > parambl.field_createTime) && (localam2.field_conversationTime != 9223372036854775807L))
    {
      ad.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(117080);
      return;
    }
    am localam1 = localam2;
    if (localam2 == null)
    {
      localam1 = new am(str);
      i = 1;
    }
    localam1.jV(parambl.field_isSend);
    localam1.jT(localam1.field_unReadCount);
    localam1.aG(parambl);
    localam1.nK(Integer.toString(parambl.getType()));
    localam1.kT(localam1.field_flag & 0x0 | parambl.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      e(localam1);
      AppMethodBeat.o(117080);
      return;
    }
    a(localam1, str, true);
    AppMethodBeat.o(117080);
  }
  
  public final am aIA(String paramString)
  {
    AppMethodBeat.i(117124);
    Cursor localCursor = ((k)g.ab(k.class)).apR().c(w.gMn, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new am();
        paramString.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117124);
      return paramString;
      paramString = null;
      break;
      paramString = null;
    }
  }
  
  public final int aIB(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117126);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bt.isNullOrNil(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    ad.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(117126);
    return i;
  }
  
  public final void aIC(String paramString)
  {
    AppMethodBeat.i(117129);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bt.aFQ(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    ad.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117129);
  }
  
  public final void aID(String paramString)
  {
    AppMethodBeat.i(117130);
    int i = this.db.delete(aIk(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    ad.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117130);
  }
  
  public final int aIE(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(117131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117131);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + com.tencent.mm.storagebase.h.qj(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117131);
    return i;
  }
  
  public final boolean aIE()
  {
    AppMethodBeat.i(117128);
    if ((this.db == null) || (this.db.eHe()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.eHe()))
      {
        ad.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117128);
        return false;
      }
    }
    AppMethodBeat.o(117128);
    return true;
  }
  
  public final void aIl(String paramString)
  {
    AppMethodBeat.i(117076);
    ad.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, at.eFU() });
    if (this.db.delete(aIk(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117076);
  }
  
  public final boolean aIm(String paramString)
  {
    AppMethodBeat.i(117078);
    ad.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, at.eFU() });
    boolean bool = this.db.execSQL("rconversation", "delete from " + aIk(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117078);
    return bool;
  }
  
  public final am aIn(String paramString)
  {
    AppMethodBeat.i(117079);
    Cursor localCursor = this.db.a(aIk(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ad.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(117079);
      return null;
    }
    paramString = new am();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117079);
    return paramString;
  }
  
  public final void aIo(String paramString)
  {
    AppMethodBeat.i(117085);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(117085);
  }
  
  public final boolean aIp(String paramString)
  {
    AppMethodBeat.i(117086);
    if ((paramString == null) || (paramString.length() <= 0)) {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(117086);
      return false;
      ad.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      Object localObject = aIn(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(117086);
        return true;
      }
      if ((((ay)localObject).field_unReadCount == 0) && (((ay)localObject).field_unReadMuteCount == 0) && (paramString.equals(((ay)localObject).field_username)))
      {
        a(paramString, 1048576, false, ((ay)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        ((ContentValues)localObject).put("atCount", Integer.valueOf(0));
        if (this.db.update(aIk(paramString), (ContentValues)localObject, "username= ?", new String[] { bt.aFQ(paramString) }) > 0) {
          b(3, this, paramString);
        }
        AppMethodBeat.o(117086);
        return true;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(((ay)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.db.update(aIk(paramString), localContentValues, "username= ?", new String[] { bt.aFQ(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(117086);
    return true;
  }
  
  public final boolean aIq(String paramString)
  {
    AppMethodBeat.i(117087);
    if (paramString.length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(117087);
      return false;
    }
    ad.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    am localam = aIn(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localam.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(aIk(paramString), localContentValues, "parentRef= ?", new String[] { bt.aFQ(paramString) });
    if (i > 0) {
      b(3, this, paramString);
    }
    if (i > 0)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    AppMethodBeat.o(117087);
    return false;
  }
  
  public final boolean aIr(String paramString)
  {
    AppMethodBeat.i(117088);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117088);
      return false;
    }
    am localam = aIn(paramString);
    if ((localam == null) || ((localam.field_unReadCount > 0) && (paramString.equals(localam.field_username))))
    {
      AppMethodBeat.o(117088);
      return true;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + aIk(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localam.field_attrflag | 0x100000) + " where username = \"" + bt.aFQ(paramString) + "\"");
    if (bool) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117088);
    return bool;
  }
  
  public final boolean aIs(String paramString)
  {
    AppMethodBeat.i(117094);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(117094);
      return false;
    }
    paramString = aIn(paramString);
    if (paramString == null)
    {
      ad.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
      AppMethodBeat.o(117094);
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.db.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    ad.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    long l3 = ce.asQ();
    l2 = l1;
    if (l1 > l3)
    {
      ad.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 - l1) });
      l2 = l3;
    }
    l1 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, l2 + 1L);
    boolean bool = this.db.execSQL("rconversation", "update " + aIk(paramString.field_username) + " set flag = " + l1 + " where username = \"" + bt.aFQ(paramString.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117094);
    return bool;
  }
  
  public final boolean aIt(String paramString)
  {
    AppMethodBeat.i(117095);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(117095);
      return false;
    }
    if (aIn(paramString) == null)
    {
      am localam = new am(paramString);
      localam.kS(System.currentTimeMillis());
      e(localam);
      ad.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = aIn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117095);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L);
    boolean bool = this.db.execSQL("rconversation", "update " + aIk(paramString.field_username) + " set flag = " + l + " where username = \"" + bt.aFQ(paramString.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117095);
    return bool;
  }
  
  public final boolean aIu(String paramString)
  {
    AppMethodBeat.i(117096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(117096);
      return false;
    }
    boolean bool = g(aIn(paramString));
    AppMethodBeat.o(117096);
    return bool;
  }
  
  public final boolean aIv(String paramString)
  {
    AppMethodBeat.i(117098);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(117098);
      return false;
    }
    boolean bool = h(aIn(paramString));
    AppMethodBeat.o(117098);
    return bool;
  }
  
  public final Cursor aIw(String paramString)
  {
    AppMethodBeat.i(117106);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bt.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117106);
    return paramString;
  }
  
  public final Cursor aIx(String paramString)
  {
    AppMethodBeat.i(117112);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT username, unReadCount");
    localStringBuilder.append(" FROM rconversation");
    localStringBuilder.append(" WHERE (username LIKE '%@chatroom' ");
    localStringBuilder.append(" or username LIKE '%@im.chatroom' ) ");
    localStringBuilder.append(bt.nullAsNil(paramString));
    localStringBuilder.append(" AND unReadCount > 0");
    paramString = localStringBuilder.toString();
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117112);
    return paramString;
  }
  
  public final int aIy(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117119);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    ad.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(117119);
    return i;
  }
  
  public final String aIz(String paramString)
  {
    AppMethodBeat.i(117120);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    ad.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      if (paramString.moveToFirst())
      {
        localObject = paramString.getString(0);
        paramString.close();
        AppMethodBeat.o(117120);
        return localObject;
      }
      paramString.close();
    }
    AppMethodBeat.o(117120);
    return null;
  }
  
  public final boolean aaS(String paramString)
  {
    AppMethodBeat.i(117111);
    paramString = this.db.a(aIk(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      AppMethodBeat.o(117111);
      return bool;
    }
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(117074);
    if (paramc == null)
    {
      ad.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(117074);
      return;
    }
    if (w.sz(paramc.talker))
    {
      AppMethodBeat.o(117074);
      return;
    }
    Object localObject2 = paramc.talker;
    Object localObject1 = aIn((String)localObject2);
    bl localbl = paramh.agq((String)localObject2);
    if (localObject1 == null)
    {
      ad.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject2 });
      paramh = new am((String)localObject2);
      if (af.st((String)localObject2)) {
        paramh.jU(1);
      }
      if ((localbl != null) && (!bt.isNullOrNil(localbl.esh)))
      {
        localObject1 = bi.ul(localbl.esh);
        if ((localObject1 != null) && ((((bi.b)localObject1).gOb & 0x40) != 0L))
        {
          ad.w("MicroMsg.ConversationStorage", "not fas msg no need to create conversation");
          AppMethodBeat.o(117074);
          return;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.Fya.a(localbl, paramh, bool, paramc);
      ad.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc.talker, paramc.tyD, Integer.valueOf(paramc.qzn) });
      long l1;
      long l2;
      if ((localbl != null) && (localbl.field_msgId != 0L))
      {
        if ((paramc.qzn == 1) && (((bl)paramc.tyE.get(0)).field_msgId != localbl.field_msgId)) {
          ad.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localbl.field_msgId), Long.valueOf(((bl)paramc.tyE.get(0)).field_msgId) });
        }
        i = localbl.field_flag;
        l1 = paramh.field_lastSeq;
        l2 = localbl.field_msgSeq;
        ad.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramh.field_UnDeliverCount) });
        if (((!paramc.tyD.equals("insert")) || (paramc.qzn <= 0)) && ((!paramc.tyD.equals("update")) || (paramh.field_unReadCount + paramc.qzn < 0))) {
          break label657;
        }
        paramh.jT(paramh.field_unReadCount + paramc.qzn);
        if (l2 > l1)
        {
          ad.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          paramh.kU(l2);
        }
        if ((localbl.cjO()) && (localbl.field_isSend == 1))
        {
          paramh.field_sightTime = localbl.field_createTime;
          paramh.ewt = true;
        }
      }
      label547:
      Object localObject3;
      if ((paramc.tyD.equals("insert")) && (paramc.tyE.size() > 0) && (w.pF(paramc.talker)))
      {
        localObject1 = u.aqG();
        localObject2 = paramc.tyE.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label860;
          }
          localObject3 = (bl)((Iterator)localObject2).next();
          if (((du)localObject3).field_isSend != 1) {
            if (!((bl)localObject3).isText())
            {
              if (((bl)localObject3).getType() != 503316529) {
                break label809;
              }
              i = 1;
              label599:
              if (i == 0) {}
            }
            else
            {
              if (!((bl)localObject3).aIN((String)localObject1)) {
                break label814;
              }
              paramh.jY(paramh.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = bw.K(((du)localObject3).field_content, "sysmsg");
            if (!bl.bI((Map)localObject3)) {
              break label837;
            }
            paramh.kb(paramh.field_UnReadInvite + 1);
            break label547;
            label657:
            if ((paramc.tyG <= 0) || (l2 >= l1) || (((k)g.ab(k.class)).cOI().aE(paramh.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((k)g.ab(k.class)).cOI().agJ(paramh.field_username);
            ad.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            paramh.kU(l2);
            if (l1 <= l3) {
              break;
            }
            ((k)g.ab(k.class)).aqo().aA(paramh.field_username, l3);
            break;
            label809:
            i = 0;
            break label599;
            label814:
            if (((bl)localObject3).eMC()) {
              paramh.jY(paramh.field_atCount + 4096);
            }
          }
          label837:
          if (bl.bJ((Map)localObject3)) {
            paramh.kb(paramh.field_UnReadInvite + 4096);
          }
        }
      }
      label860:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.tyD != null)
          {
            j = k;
            if (paramc.tyD.equals("delete"))
            {
              if (paramc.tyG > 0) {
                i = paramc.tyG;
              }
              ad.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.tyG) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.tyD != null) && (paramc.tyD.equals("insert"))) {
          if (paramc.tyF > 0)
          {
            i = paramc.tyF;
            ad.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.tyF) });
          }
        }
        for (;;)
        {
          localObject2 = bt.by((String)localObject1, "");
          if (localbl != null) {}
          for (l1 = localbl.field_msgSeq;; l1 = -1L)
          {
            ad.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), paramh.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            ad.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, paramh.field_username });
            AppMethodBeat.o(117074);
            return;
          }
          this.Fyb.dR(paramh);
          this.Fyb.doNotify();
          if (localObject1 == null)
          {
            ad.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(117074);
            return;
          }
          if (!((String)localObject1).equals(paramh.field_username))
          {
            ad.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(117074);
            return;
          }
          if ((localbl != null) && (localbl.field_msgId != 0L))
          {
            ad.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localbl.field_msgId);
            paramh.aG(localbl);
            if (this.FxY != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.FxY.a(localbl, (PString)localObject2, (PString)localObject3, localPInt, paramh.lw(2097152));
              ad.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              paramh.nL(((PString)localObject2).value);
              paramh.nM(((PString)localObject3).value);
              paramh.jW(localPInt.value);
              paramh.nK(Integer.toString(localbl.getType()));
              if (this.FxZ != null) {
                this.FxZ.a(localbl, paramh);
              }
              paramh.kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 1, localbl.field_createTime));
              if (!bool) {
                break label1630;
              }
              localObject1 = ((k)g.ab(k.class)).apM().aHY((String)localObject1);
              if ((localObject1 != null) && (!bt.isNullOrNil(((au)localObject1).field_username)) && (((af)localObject1).ZS())) {
                paramh.kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 2, 0L));
              }
              a(paramh, j, i);
              if ((!localbl.cjO()) && (!com.tencent.mm.sdk.a.b.eES())) {
                break label1620;
              }
              paramh.kS(localbl.field_createTime);
              label1502:
              e(paramh);
            }
          }
          label1620:
          label1630:
          do
          {
            for (;;)
            {
              this.Fyc.dR(paramh);
              this.Fyc.doNotify();
              this.Fya.b(localbl, paramh, bool, paramc);
              AppMethodBeat.o(117074);
              return;
              localObject2 = cF(localbl.getType(), paramh.field_content);
              localObject3 = bt.nullAsNil(paramh.field_digest);
              if (bt.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + bt.nullAsNil((String)localObject2))
              {
                paramh.nL(((String)localObject3).concat((String)localObject2));
                break;
              }
              paramh.kS(bt.eGO());
              break label1502;
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
              continue;
              ad.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1695;
              }
              paramh.eLf();
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
            }
          } while (((k)g.ab(k.class)).cOI().agE((String)localObject1) <= 0);
          label1695:
          if ((localbl.cjO()) || (com.tencent.mm.sdk.a.b.eES())) {
            paramh.kS(localbl.field_createTime);
          }
          for (;;)
          {
            a(paramh, j, i);
            e(paramh);
            break;
            paramh.kS(bt.eGO());
          }
          i = 0;
          break;
          i = 0;
        }
      }
      paramh = (com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject1;
    }
  }
  
  public final void b(bh.a parama)
  {
    AppMethodBeat.i(117071);
    this.Fyc.remove(parama);
    AppMethodBeat.o(117071);
  }
  
  public final void be(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(117107);
    ad.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { at.eFU() });
    if (paramLinkedList.isEmpty())
    {
      ad.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
      AppMethodBeat.o(117107);
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
    ad.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(117107);
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(117100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.fIf == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bt.aFQ(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117100);
    return paramString1;
  }
  
  public final void c(bh.a parama)
  {
    AppMethodBeat.i(117072);
    this.Fyb.a(parama, null);
    AppMethodBeat.o(117072);
  }
  
  public final void c(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117125);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bt.nullAsNil(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    ad.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.db.execSQL("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        b(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
    AppMethodBeat.o(117125);
  }
  
  public final String cF(int paramInt, String paramString)
  {
    AppMethodBeat.i(117127);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil(paramString)) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117127);
      return localObject1;
      paramString = bw.K(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        ad.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final Cursor d(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(193557);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.fIf == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
      if (paramList.size() <= 0) {
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
        localStringBuilder.append("parentRef = '").append(bt.aFQ(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" and conversationTime != 0");
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(193557);
    return paramString1;
  }
  
  public final void d(bh.a parama)
  {
    AppMethodBeat.i(117073);
    this.Fyb.remove(parama);
    AppMethodBeat.o(117073);
  }
  
  public final long e(am paramam)
  {
    AppMethodBeat.i(117082);
    String str = bt.nullAsNil(paramam.field_username);
    if (str.length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(117082);
      return -1L;
    }
    paramam.kT(d(paramam));
    f(paramam);
    long l = this.db.insert(aIk(str), null, paramam.convertTo());
    if (l != -1L) {
      b(2, this, paramam.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(117082);
      return l;
      ad.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { aIk(str) });
    }
  }
  
  public final boolean eLg()
  {
    AppMethodBeat.i(117077);
    boolean bool1 = this.db.execSQL("rconversation", "delete from rconversation");
    boolean bool2 = this.db.execSQL("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        b(5, this, "");
      }
      AppMethodBeat.o(117077);
      return bool1;
    }
  }
  
  public final HashMap<String, Long> eLh()
  {
    AppMethodBeat.i(117081);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.db.a("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117081);
      return localHashMap;
    }
    int i;
    if (localCursor == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label167;
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
    label167:
    localCursor.close();
    ad.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(117081);
    return localHashMap;
  }
  
  public final void eLi()
  {
    AppMethodBeat.i(117084);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(117084);
  }
  
  public final List<String> eLj()
  {
    AppMethodBeat.i(117101);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bt.nullAsNil(bt.nullAsNil(w.gMn)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = w.gMw;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(" and rconversation.username != '").append(str).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(" order by sightTime desc, flag desc, conversationTime desc");
    localObject = this.db.a(((StringBuilder)localObject).toString(), null, 2);
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
    ad.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(117101);
    return localArrayList;
  }
  
  public final List<String> eLk()
  {
    AppMethodBeat.i(117108);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = G(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    ad.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117108);
    return localArrayList;
  }
  
  public final Cursor eLl()
  {
    AppMethodBeat.i(117110);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(117110);
    return localCursor;
  }
  
  public final int eLm()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117117);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    ad.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(117117);
    return i;
  }
  
  public final String eLn()
  {
    AppMethodBeat.i(117118);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    ad.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst())
      {
        String str = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
        AppMethodBeat.o(117118);
        return str;
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(117118);
    return null;
  }
  
  public final Cursor eLo()
  {
    AppMethodBeat.i(117121);
    ad.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(117121);
    return localCursor;
  }
  
  public final am eLp()
  {
    AppMethodBeat.i(117123);
    Cursor localCursor = ((k)g.ab(k.class)).apR().c(w.gMn, null, "officialaccounts");
    am localam;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localam = new am();
        localam.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117123);
      return localam;
      localam = null;
      break;
      localam = null;
    }
  }
  
  public final Cursor eLq()
  {
    AppMethodBeat.i(117132);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ( parentRef is ").append(com.tencent.mm.o.a.fIf).append(" or parentRef = '' ) ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(117132);
    return localObject;
  }
  
  public final Cursor f(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117109);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = "select username from rconversation";
    int i = 0;
    if (i < ((List)localObject).size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramList);
      if (i > 0) {}
      for (paramList = " and ";; paramList = " where ")
      {
        paramList = paramList + "username != \"" + bt.aFQ((String)((List)localObject).get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = paramList + " order by flag desc, conversationTime desc limit " + paramInt2 + " offset " + paramInt1;
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117109);
    return paramList;
  }
  
  public final Cursor fL(String paramString, int paramInt)
  {
    AppMethodBeat.i(117116);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rconversation.username");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bt.nullAsNil(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.fIf).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    if (paramInt > 0) {
      localStringBuilder.append(" LIMIT ").append(String.valueOf(paramInt));
    }
    paramString = localStringBuilder.toString();
    ad.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117116);
    return paramString;
  }
  
  public final boolean g(am paramam)
  {
    AppMethodBeat.i(117097);
    if (paramam == null)
    {
      ad.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(117097);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramam, 3, paramam.field_conversationTime);
    boolean bool = this.db.execSQL("rconversation", "update " + aIk(paramam.field_username) + " set flag = " + l + " where username = \"" + bt.aFQ(paramam.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramam.field_username);
    }
    AppMethodBeat.o(117097);
    return bool;
  }
  
  public final boolean h(am paramam)
  {
    AppMethodBeat.i(117099);
    if (paramam == null)
    {
      ad.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(117099);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramam, 4, 0L) != 0L)
    {
      AppMethodBeat.o(117099);
      return true;
    }
    AppMethodBeat.o(117099);
    return false;
  }
  
  public final Cursor ld(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117113);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.fIf).append(" or parentRef = '' ) ").append(bt.nullAsNil(paramString2));
    paramString1 = localStringBuilder.toString();
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117113);
    return paramString1;
  }
  
  public final int tz(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117122);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bt.nullAsNil(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117122);
    return i;
  }
  
  static final class a
    extends com.tencent.mm.co.a<f>
    implements f
  {
    public final void a(final bl parambl, final am paramam, final boolean paramBoolean, final h.c paramc)
    {
      AppMethodBeat.i(117065);
      a(new a.a() {});
      AppMethodBeat.o(117065);
    }
    
    public final void b(final bl parambl, final am paramam, final boolean paramBoolean, final h.c paramc)
    {
      AppMethodBeat.i(117066);
      a(new a.a() {});
      AppMethodBeat.o(117066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.an
 * JD-Core Version:    0.7.0.1
 */