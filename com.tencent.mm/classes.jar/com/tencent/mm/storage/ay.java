package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class ay
  extends i<ax>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.e
{
  public static final String[] dXp = { i.a(ax.buS, "fmessage_msginfo") };
  private static final String[] uno = { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
  public com.tencent.mm.sdk.e.e dXw;
  
  public ay(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, ax.buS, "fmessage_msginfo", uno);
    this.dXw = parame;
  }
  
  public final boolean Hr(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + bk.pl(paramString) + "'";
    return this.dXw.gk("fmessage_msginfo", paramString);
  }
  
  public final ax[] abS(String paramString)
  {
    y.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + bk.pl(paramString) + "' order by createTime DESC limit 3";
    paramString = this.dXw.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ax localax = new ax();
      localax.d(paramString);
      localArrayList.add(localax);
    }
    paramString.close();
    return (ax[])localArrayList.toArray(new ax[localArrayList.size()]);
  }
  
  public final ax abT(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + bk.pl(paramString) + "' order by createTime DESC limit 1";
    paramString = this.dXw.a(paramString, null, 2);
    ax localax = new ax();
    if (paramString.moveToFirst()) {
      localax.d(paramString);
    }
    paramString.close();
    return localax;
  }
  
  public final ax abU(String paramString)
  {
    paramString = dv(paramString, 1);
    if ((paramString != null) && (paramString.length > 0)) {
      return paramString[0];
    }
    return null;
  }
  
  public final boolean b(ax paramax)
  {
    if (paramax == null) {
      y.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
    }
    while (!super.b(paramax)) {
      return false;
    }
    aam(paramax.ujK);
    return true;
  }
  
  public final List<ax> bhT()
  {
    y.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.dXw.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      ax localax = new ax();
      localax.d(localCursor);
      localArrayList.add(localax);
    }
    localCursor.close();
    y.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public final ax[] dv(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + bk.pl(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.dXw.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ax localax = new ax();
      localax.d(paramString);
      localArrayList.add(localax);
    }
    paramString.close();
    return (ax[])localArrayList.toArray(new ax[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ay
 * JD-Core Version:    0.7.0.1
 */