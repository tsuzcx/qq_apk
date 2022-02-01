package com.tencent.mm.plugin.msgquote.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends MAutoStorage<b>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(88809);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "MsgQuote") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS quotedMsgSvrIdIndex ON MsgQuote ( quotedMsgSvrId )" };
    AppMethodBeat.o(88809);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.info, "MsgQuote", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final b Hj(long paramLong)
  {
    AppMethodBeat.i(88803);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteStorage", "getMsgQuteByMsgId:%s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88803);
      return null;
    }
    Object localObject = this.db.query("MsgQuote", b.info.columns, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88803);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      b localb = new b();
      localb.convertFrom((Cursor)localObject);
      localArrayList.add(localb);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(88803);
      return null;
    }
    localObject = (b)localArrayList.get(0);
    AppMethodBeat.o(88803);
    return localObject;
  }
  
  public final b Hk(long paramLong)
  {
    AppMethodBeat.i(88804);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteStorage", "quotedMsgSvrId:%s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88804);
      return null;
    }
    Object localObject = this.db.query("MsgQuote", b.info.columns, "quotedMsgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88804);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      b localb = new b();
      localb.convertFrom((Cursor)localObject);
      localArrayList.add(localb);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(88804);
      return null;
    }
    localObject = (b)localArrayList.get(0);
    AppMethodBeat.o(88804);
    return localObject;
  }
  
  public final b Hl(long paramLong)
  {
    AppMethodBeat.i(88805);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteStorage", "quotedMsgId:%s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88805);
      return null;
    }
    Object localObject = this.db.query("MsgQuote", b.info.columns, "quotedMsgId=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88805);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      b localb = new b();
      localb.convertFrom((Cursor)localObject);
      localArrayList.add(localb);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(88805);
      return null;
    }
    localObject = (b)localArrayList.get(0);
    AppMethodBeat.o(88805);
    return localObject;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(88806);
    if (paramb == null)
    {
      AppMethodBeat.o(88806);
      return false;
    }
    boolean bool = update(paramb.systemRowid, paramb);
    AppMethodBeat.o(88806);
    return bool;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(88807);
    if (paramb == null)
    {
      AppMethodBeat.o(88807);
      return false;
    }
    paramb.field_status = 0;
    boolean bool = super.insert(paramb);
    AppMethodBeat.o(88807);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.a.a
 * JD-Core Version:    0.7.0.1
 */