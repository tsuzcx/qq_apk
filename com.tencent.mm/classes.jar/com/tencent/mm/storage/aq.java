package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aq
  extends n
  implements bk
{
  public static final String[] SQL_CREATE;
  private bk.b GWY;
  private com.tencent.mm.plugin.messenger.foundation.a.e GWZ;
  private a GXa;
  private l<bk.a, ap> GXb;
  private l<bk.a, ap> GXc;
  private final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117133);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.o.a.info, "rconversation"), j.getCreateSQLs(com.tencent.mm.o.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE INDEX IF NOT EXISTS rconversation_unreadcount_index ON rconversation ( unReadCount )", "DROP INDEX IF EXISTS multi_index ", "DROP INDEX IF EXISTS rconversation_multi_index", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
    AppMethodBeat.o(117133);
  }
  
  public aq(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(117067);
    this.GXa = new a((byte)0);
    this.GXb = new l() {};
    this.GXc = new l() {};
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
  
  private static String D(String paramString, List<String> paramList)
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
          localObject = new StringBuilder().append(paramString).append("\"").append(bs.aLh((String)paramList.get(i))).append("\"");
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
  
  private static String aNF(String paramString)
  {
    AppMethodBeat.i(117068);
    ac.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (ai.ww(paramString))
    {
      AppMethodBeat.o(117068);
      return "rbottleconversation";
    }
    AppMethodBeat.o(117068);
    return "rconversation";
  }
  
  private static long d(ap paramap)
  {
    AppMethodBeat.i(117075);
    if (paramap != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramap, paramap.field_conversationTime);
      AppMethodBeat.o(117075);
      return l;
    }
    long l = bs.eWj();
    AppMethodBeat.o(117075);
    return l & 0xFFFFFFFF;
  }
  
  private static void f(ap paramap)
  {
    AppMethodBeat.i(117092);
    if (paramap == null)
    {
      AppMethodBeat.o(117092);
      return;
    }
    if (paramap.field_unReadCount > 0)
    {
      ac.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramap.field_attrflag & 0x100000) != 0)
      {
        paramap.jR(paramap.field_unReadCount - 1);
        paramap.jV(paramap.field_attrflag & 0xFFEFFFFF);
      }
    }
    AppMethodBeat.o(117092);
  }
  
  public final boolean Gt(String paramString)
  {
    AppMethodBeat.i(210487);
    if (aNI(paramString) != null)
    {
      AppMethodBeat.o(210487);
      return true;
    }
    AppMethodBeat.o(210487);
    return false;
  }
  
  public final bk.b Ls()
  {
    return this.GWY;
  }
  
  public final int a(ap paramap, String paramString)
  {
    AppMethodBeat.i(210488);
    int i = a(paramap, paramString, true);
    AppMethodBeat.o(210488);
    return i;
  }
  
  public final int a(ap paramap, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117091);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117091);
      return 0;
    }
    if (paramBoolean) {
      paramap.ov(d(paramap));
    }
    f(paramap);
    int i = this.db.update(aNF(paramString), paramap.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      b(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(117091);
      return i;
      ac.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { aNF(paramString) });
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117102);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.fLL == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bs.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bs.aLh(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    ac.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
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
    paramString1 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bs.nullAsNil(paramString1);
    paramList = D(" and rconversation.username", paramList);
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
      ac.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramString1)));
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
    if (com.tencent.mm.o.a.fLL == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bs.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bs.aLh(paramString2)).append("' ");
      }
    }
    ac.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117103);
    return paramArrayList;
  }
  
  public final b a(f paramf)
  {
    AppMethodBeat.i(117069);
    paramf = this.GXa.bs(paramf);
    AppMethodBeat.o(117069);
    return paramf;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.e parame)
  {
    this.GWZ = parame;
  }
  
  public final void a(ap paramap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117083);
    if (!bi.yo(paramap.field_username))
    {
      AppMethodBeat.o(117083);
      return;
    }
    if (bs.nullAsNil(paramap.field_username).length() <= 0)
    {
      ac.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(117083);
      return;
    }
    if (paramap.field_msgCount == 0)
    {
      paramap.jQ(bi.yn(paramap.field_username));
      ac.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ac.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramap.field_msgCount), paramap.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(117083);
      return;
      if (paramInt1 > 0)
      {
        paramap.jQ(paramap.field_msgCount - paramInt1);
        if (paramap.field_msgCount < 0)
        {
          ac.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramap.jQ(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramap.jQ(paramap.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(bk.a parama)
  {
    AppMethodBeat.i(117070);
    this.GXc.a(parama, null);
    AppMethodBeat.o(117070);
  }
  
  public final void a(bk.b paramb)
  {
    this.GWY = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117089);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if (aNI(paramString) == null)
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
    paramBoolean = this.db.execSQL("rconversation", "update " + aNF(paramString) + " set attrflag = " + paramInt1 + " where username = \"" + bs.aLh(paramString) + "\"");
    if (paramBoolean) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117089);
    return paramBoolean;
  }
  
  public final void aJ(bo parambo)
  {
    AppMethodBeat.i(117080);
    String str = parambo.field_talker;
    int i = 0;
    ap localap2 = aNI(str);
    if ((localap2 != null) && (localap2.field_conversationTime > parambo.field_createTime) && (localap2.field_conversationTime != 9223372036854775807L))
    {
      ac.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(117080);
      return;
    }
    ap localap1 = localap2;
    if (localap2 == null)
    {
      localap1 = new ap(str);
      i = 1;
    }
    localap1.jT(parambo.field_isSend);
    localap1.jR(localap1.field_unReadCount);
    localap1.aI(parambo);
    localap1.qQ(Integer.toString(parambo.getType()));
    localap1.ov(localap1.field_flag & 0x0 | parambo.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      e(localap1);
      AppMethodBeat.o(117080);
      return;
    }
    a(localap1, str, true);
    AppMethodBeat.o(117080);
  }
  
  public final void aNG(String paramString)
  {
    AppMethodBeat.i(117076);
    ac.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, as.eVp() });
    if (this.db.delete(aNF(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117076);
  }
  
  public final boolean aNH(String paramString)
  {
    AppMethodBeat.i(117078);
    ac.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, as.eVp() });
    boolean bool = this.db.execSQL("rconversation", "delete from " + aNF(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117078);
    return bool;
  }
  
  public final ap aNI(String paramString)
  {
    AppMethodBeat.i(117079);
    Cursor localCursor = this.db.a(aNF(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ac.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(117079);
      return null;
    }
    paramString = new ap();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117079);
    return paramString;
  }
  
  public final void aNJ(String paramString)
  {
    AppMethodBeat.i(117085);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(117085);
  }
  
  public final boolean aNK(String paramString)
  {
    AppMethodBeat.i(117086);
    if ((paramString == null) || (paramString.length() <= 0)) {
      ac.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(117086);
      return false;
      ac.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      Object localObject = aNI(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(117086);
        return true;
      }
      if ((((az)localObject).field_unReadCount == 0) && (((az)localObject).field_unReadMuteCount == 0) && (paramString.equals(((az)localObject).field_username)))
      {
        a(paramString, 1048576, false, ((az)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        ((ContentValues)localObject).put("atCount", Integer.valueOf(0));
        if (this.db.update(aNF(paramString), (ContentValues)localObject, "username= ?", new String[] { bs.aLh(paramString) }) > 0) {
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
      localContentValues.put("attrflag", Integer.valueOf(((az)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.db.update(aNF(paramString), localContentValues, "username= ?", new String[] { bs.aLh(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(117086);
    return true;
  }
  
  public final boolean aNL(String paramString)
  {
    AppMethodBeat.i(117087);
    if (paramString.length() <= 0)
    {
      ac.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(117087);
      return false;
    }
    ac.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    ap localap = aNI(paramString);
    if (localap == null)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localap.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(aNF(paramString), localContentValues, "parentRef= ?", new String[] { bs.aLh(paramString) });
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
  
  public final boolean aNM(String paramString)
  {
    AppMethodBeat.i(117088);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117088);
      return false;
    }
    ap localap = aNI(paramString);
    if ((localap == null) || ((localap.field_unReadCount > 0) && (paramString.equals(localap.field_username))))
    {
      AppMethodBeat.o(117088);
      return true;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + aNF(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localap.field_attrflag | 0x100000) + " where username = \"" + bs.aLh(paramString) + "\"");
    if (bool) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117088);
    return bool;
  }
  
  public final boolean aNN(String paramString)
  {
    AppMethodBeat.i(117094);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(117094);
      return false;
    }
    paramString = aNI(paramString);
    if (paramString == null)
    {
      ac.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
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
    ac.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    long l3 = ce.azH();
    l2 = l1;
    if (l1 > l3)
    {
      ac.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 - l1) });
      l2 = l3;
    }
    l1 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, l2 + 1L);
    boolean bool = this.db.execSQL("rconversation", "update " + aNF(paramString.field_username) + " set flag = " + l1 + " where username = \"" + bs.aLh(paramString.field_username) + "\"");
    ac.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117094);
    return bool;
  }
  
  public final boolean aNO(String paramString)
  {
    AppMethodBeat.i(117095);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(117095);
      return false;
    }
    if (aNI(paramString) == null)
    {
      ap localap = new ap(paramString);
      localap.ou(System.currentTimeMillis());
      e(localap);
      ac.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = aNI(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117095);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L);
    boolean bool = this.db.execSQL("rconversation", "update " + aNF(paramString.field_username) + " set flag = " + l + " where username = \"" + bs.aLh(paramString.field_username) + "\"");
    ac.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117095);
    return bool;
  }
  
  public final boolean aNP(String paramString)
  {
    AppMethodBeat.i(117096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(117096);
      return false;
    }
    boolean bool = g(aNI(paramString));
    AppMethodBeat.o(117096);
    return bool;
  }
  
  public final boolean aNQ(String paramString)
  {
    AppMethodBeat.i(117098);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(117098);
      return false;
    }
    boolean bool = h(aNI(paramString));
    AppMethodBeat.o(117098);
    return bool;
  }
  
  public final Cursor aNR(String paramString)
  {
    AppMethodBeat.i(117106);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bs.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117106);
    return paramString;
  }
  
  public final Cursor aNS(String paramString)
  {
    AppMethodBeat.i(209617);
    ac.i("MicroMsg.ConversationStorage", "getUnreadConversationCursor filter[%s] [%s]", new Object[] { paramString, bs.eWi() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.o.a.fLL).append(" or parentRef = '' ) ").append(bs.nullAsNil(paramString));
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.ConversationStorage", "get unread conversation with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(209617);
    return paramString;
  }
  
  public final Cursor aNT(String paramString)
  {
    AppMethodBeat.i(209618);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rcontact.* FROM rcontact,rconversation");
    localStringBuilder.append(" WHERE unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.o.a.fLL).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bs.nullAsNil(paramString));
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.ConversationStorage", "get total unread contact with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(209618);
    return paramString;
  }
  
  public final int aNU(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117119);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
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
  
  public final String aNV(String paramString)
  {
    AppMethodBeat.i(117120);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    ac.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
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
  
  public final ap aNW(String paramString)
  {
    AppMethodBeat.i(117124);
    Cursor localCursor = ((k)g.ab(k.class)).awG().c(w.hmN, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new ap();
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
  
  public final int aNX(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117126);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bs.isNullOrNil(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    ac.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
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
  
  public final void aNY(String paramString)
  {
    AppMethodBeat.i(117129);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bs.aLh(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    ac.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117129);
  }
  
  public final void aNZ(String paramString)
  {
    AppMethodBeat.i(117130);
    int i = this.db.delete(aNF(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    ac.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117130);
  }
  
  public final int aOa(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(117131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117131);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + com.tencent.mm.storagebase.h.ty(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117131);
    return i;
  }
  
  public final boolean aPv()
  {
    AppMethodBeat.i(117128);
    if ((this.db == null) || (this.db.eWz()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.eWz()))
      {
        ac.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117128);
        return false;
      }
    }
    AppMethodBeat.o(117128);
    return true;
  }
  
  public final boolean afK(String paramString)
  {
    AppMethodBeat.i(117111);
    paramString = this.db.a(aNF(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
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
      ac.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(117074);
      return;
    }
    if (w.wC(paramc.talker))
    {
      AppMethodBeat.o(117074);
      return;
    }
    Object localObject2 = paramc.talker;
    Object localObject1 = aNI((String)localObject2);
    bo localbo = paramh.alk((String)localObject2);
    if (localObject1 == null)
    {
      ac.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject2 });
      paramh = new ap((String)localObject2);
      if (ai.ww((String)localObject2)) {
        paramh.jS(1);
      }
      if ((localbo != null) && (!bs.isNullOrNil(localbo.eul)))
      {
        localObject1 = bi.yr(localbo.eul);
        if ((localObject1 != null) && ((((bi.b)localObject1).hoB & 0x40) != 0L))
        {
          ac.w("MicroMsg.ConversationStorage", "not fas msg no need to create conversation");
          AppMethodBeat.o(117074);
          return;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.GXa.a(localbo, paramh, bool, paramc);
      ac.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc.talker, paramc.uHb, Integer.valueOf(paramc.rnT) });
      long l1;
      long l2;
      if ((localbo != null) && (localbo.field_msgId != 0L))
      {
        if ((paramc.rnT == 1) && (((bo)paramc.gtT.get(0)).field_msgId != localbo.field_msgId)) {
          ac.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localbo.field_msgId), Long.valueOf(((bo)paramc.gtT.get(0)).field_msgId) });
        }
        i = localbo.field_flag;
        l1 = paramh.field_lastSeq;
        l2 = localbo.field_msgSeq;
        ac.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramh.field_UnDeliverCount) });
        if (((!paramc.uHb.equals("insert")) || (paramc.rnT <= 0)) && ((!paramc.uHb.equals("update")) || (paramh.field_unReadCount + paramc.rnT < 0))) {
          break label657;
        }
        paramh.jR(paramh.field_unReadCount + paramc.rnT);
        if (l2 > l1)
        {
          ac.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          paramh.ow(l2);
        }
        if ((localbo.crv()) && (localbo.field_isSend == 1))
        {
          paramh.field_sightTime = localbo.field_createTime;
          paramh.eyQ = true;
        }
      }
      label547:
      Object localObject3;
      if ((paramc.uHb.equals("insert")) && (paramc.gtT.size() > 0) && (w.sQ(paramc.talker)))
      {
        localObject1 = u.axw();
        localObject2 = paramc.gtT.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label860;
          }
          localObject3 = (bo)((Iterator)localObject2).next();
          if (((dy)localObject3).field_isSend != 1) {
            if (!((bo)localObject3).isText())
            {
              if (((bo)localObject3).getType() != 503316529) {
                break label809;
              }
              i = 1;
              label599:
              if (i == 0) {}
            }
            else
            {
              if (!((bo)localObject3).aOj((String)localObject1)) {
                break label814;
              }
              paramh.jW(paramh.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = bv.L(((dy)localObject3).field_content, "sysmsg");
            if (!bo.bN((Map)localObject3)) {
              break label837;
            }
            paramh.jZ(paramh.field_UnReadInvite + 1);
            break label547;
            label657:
            if ((paramc.uHd <= 0) || (l2 >= l1) || (((k)g.ab(k.class)).dcr().aG(paramh.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((k)g.ab(k.class)).dcr().alD(paramh.field_username);
            ac.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            paramh.ow(l2);
            if (l1 <= l3) {
              break;
            }
            ((k)g.ab(k.class)).axd().aC(paramh.field_username, l3);
            break;
            label809:
            i = 0;
            break label599;
            label814:
            if (((bo)localObject3).fch()) {
              paramh.jW(paramh.field_atCount + 4096);
            }
          }
          label837:
          if (bo.bO((Map)localObject3)) {
            paramh.jZ(paramh.field_UnReadInvite + 4096);
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
          if (paramc.uHb != null)
          {
            j = k;
            if (paramc.uHb.equals("delete"))
            {
              if (paramc.uHd > 0) {
                i = paramc.uHd;
              }
              ac.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.uHd) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.uHb != null) && (paramc.uHb.equals("insert"))) {
          if (paramc.uHc > 0)
          {
            i = paramc.uHc;
            ac.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.uHc) });
          }
        }
        for (;;)
        {
          localObject2 = bs.bG((String)localObject1, "");
          if (localbo != null) {}
          for (l1 = localbo.field_msgSeq;; l1 = -1L)
          {
            ac.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), paramh.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            ac.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, paramh.field_username });
            AppMethodBeat.o(117074);
            return;
          }
          this.GXb.dS(paramh);
          this.GXb.doNotify();
          if (localObject1 == null)
          {
            ac.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(117074);
            return;
          }
          if (!((String)localObject1).equals(paramh.field_username))
          {
            ac.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(117074);
            return;
          }
          if ((localbo != null) && (localbo.field_msgId != 0L))
          {
            ac.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localbo.field_msgId);
            paramh.aI(localbo);
            if (this.GWY != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.GWY.a(localbo, (PString)localObject2, (PString)localObject3, localPInt, paramh.lr(2097152));
              ac.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              paramh.qR(((PString)localObject2).value);
              paramh.qS(((PString)localObject3).value);
              paramh.jU(localPInt.value);
              paramh.qQ(Integer.toString(localbo.getType()));
              if (this.GWZ != null) {
                this.GWZ.a(localbo, paramh);
              }
              paramh.ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 1, localbo.field_createTime));
              if (!bool) {
                break label1626;
              }
              localObject1 = ((k)g.ab(k.class)).awB().aNt((String)localObject1);
              if ((localObject1 != null) && (!bs.isNullOrNil(((av)localObject1).field_username)) && (((ai)localObject1).aaN())) {
                paramh.ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 2, 0L));
              }
              a(paramh, j, i);
              if (localbo.field_createTime == 0L) {
                break label1616;
              }
              paramh.ou(localbo.field_createTime);
              label1498:
              e(paramh);
            }
          }
          label1616:
          label1626:
          do
          {
            for (;;)
            {
              this.GXc.dS(paramh);
              this.GXc.doNotify();
              this.GXa.b(localbo, paramh, bool, paramc);
              AppMethodBeat.o(117074);
              return;
              localObject2 = cI(localbo.getType(), paramh.field_content);
              localObject3 = bs.nullAsNil(paramh.field_digest);
              if (bs.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + bs.nullAsNil((String)localObject2))
              {
                paramh.qR(((String)localObject3).concat((String)localObject2));
                break;
              }
              paramh.ou(ce.azH());
              break label1498;
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
              continue;
              ac.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1691;
              }
              paramh.faH();
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
            }
          } while (((k)g.ab(k.class)).dcr().aly((String)localObject1) <= 0);
          label1691:
          if ((localbo != null) && (localbo.field_createTime != 0L)) {
            paramh.ou(localbo.field_createTime);
          }
          for (;;)
          {
            a(paramh, j, i);
            e(paramh);
            break;
            paramh.ou(ce.azH());
          }
          i = 0;
          break;
          i = 0;
        }
      }
      paramh = (com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject1;
    }
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(209615);
    this.GXa.remove(paramf);
    AppMethodBeat.o(209615);
  }
  
  public final void b(bk.a parama)
  {
    AppMethodBeat.i(117071);
    this.GXc.remove(parama);
    AppMethodBeat.o(117071);
  }
  
  public final void bl(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(117107);
    ac.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { as.eVp() });
    if (paramLinkedList.isEmpty())
    {
      ac.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
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
    ac.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(117107);
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(117100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.fLL == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bs.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bs.aLh(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117100);
    return paramString1;
  }
  
  public final void c(bk.a parama)
  {
    AppMethodBeat.i(117072);
    this.GXb.a(parama, null);
    AppMethodBeat.o(117072);
  }
  
  public final void c(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117125);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bs.nullAsNil(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    ac.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
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
  
  public final String cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(117127);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bs.isNullOrNil(paramString)) {
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
      paramString = bv.L(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        ac.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final void d(bk.a parama)
  {
    AppMethodBeat.i(117073);
    this.GXb.remove(parama);
    AppMethodBeat.o(117073);
  }
  
  public final long e(ap paramap)
  {
    AppMethodBeat.i(117082);
    String str = bs.nullAsNil(paramap.field_username);
    if (str.length() <= 0)
    {
      ac.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(117082);
      return -1L;
    }
    paramap.ov(d(paramap));
    f(paramap);
    long l = this.db.insert(aNF(str), null, paramap.convertTo());
    if (l != -1L) {
      b(2, this, paramap.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(117082);
      return l;
      ac.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { aNF(str) });
    }
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
        paramList = paramList + "username != \"" + bs.aLh((String)((List)localObject).get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = paramList + " order by flag desc, conversationTime desc limit " + paramInt2 + " offset " + paramInt1;
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117109);
    return paramList;
  }
  
  public final boolean faI()
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
  
  public final HashMap<String, Long> faJ()
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
    ac.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(117081);
    return localHashMap;
  }
  
  public final void faK()
  {
    AppMethodBeat.i(117084);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(117084);
  }
  
  public final List<String> faL()
  {
    AppMethodBeat.i(117101);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bs.nullAsNil(bs.nullAsNil(w.hmN)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = w.hmW;
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
    ac.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(117101);
    return localArrayList;
  }
  
  public final List<String> faM()
  {
    AppMethodBeat.i(117108);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = D(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    ac.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117108);
    return localArrayList;
  }
  
  public final Cursor faN()
  {
    AppMethodBeat.i(117110);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(117110);
    return localCursor;
  }
  
  public final int faO()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117117);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    ac.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
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
  
  public final String faP()
  {
    AppMethodBeat.i(117118);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    ac.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
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
  
  public final Cursor faQ()
  {
    AppMethodBeat.i(117121);
    ac.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(117121);
    return localCursor;
  }
  
  public final ap faR()
  {
    AppMethodBeat.i(117123);
    Cursor localCursor = ((k)g.ab(k.class)).awG().c(w.hmN, null, "officialaccounts");
    ap localap;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localap = new ap();
        localap.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117123);
      return localap;
      localap = null;
      break;
      localap = null;
    }
  }
  
  public final Cursor faS()
  {
    AppMethodBeat.i(117132);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ( parentRef is ").append(com.tencent.mm.o.a.fLL).append(" or parentRef = '' ) ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(117132);
    return localObject;
  }
  
  public final boolean g(ap paramap)
  {
    AppMethodBeat.i(117097);
    if (paramap == null)
    {
      ac.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(117097);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramap, 3, paramap.field_conversationTime);
    boolean bool = this.db.execSQL("rconversation", "update " + aNF(paramap.field_username) + " set flag = " + l + " where username = \"" + bs.aLh(paramap.field_username) + "\"");
    ac.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramap.field_username);
    }
    AppMethodBeat.o(117097);
    return bool;
  }
  
  public final boolean h(ap paramap)
  {
    AppMethodBeat.i(117099);
    if (paramap == null)
    {
      ac.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(117099);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramap, 4, 0L) != 0L)
    {
      AppMethodBeat.o(117099);
      return true;
    }
    AppMethodBeat.o(117099);
    return false;
  }
  
  public final Cursor lA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117113);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.fLL).append(" or parentRef = '' ) ").append(bs.nullAsNil(paramString2));
    paramString1 = localStringBuilder.toString();
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117113);
    return paramString1;
  }
  
  public final int xC(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117122);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bs.nullAsNil(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117122);
    return i;
  }
  
  static final class a
    extends com.tencent.mm.cn.a<f>
    implements f
  {
    public final void a(final bo parambo, final ap paramap, final boolean paramBoolean, final h.c paramc)
    {
      AppMethodBeat.i(117065);
      a(new a.a() {});
      AppMethodBeat.o(117065);
    }
    
    public final void b(final bo parambo, final ap paramap, final boolean paramBoolean, final h.c paramc)
    {
      AppMethodBeat.i(117066);
      a(new a.a() {});
      AppMethodBeat.o(117066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.aq
 * JD-Core Version:    0.7.0.1
 */