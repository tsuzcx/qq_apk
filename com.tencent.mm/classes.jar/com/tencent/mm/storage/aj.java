package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.aw;
import com.tencent.mm.h.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class aj
  extends aw
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private a acGO;
  public a acGP;
  private List<String> acGQ;
  private List<String> acGR;
  private Map<String, com.tencent.mm.h.a.a.b> oxD;
  
  static
  {
    AppMethodBeat.i(43163);
    info = aw.aJm();
    AppMethodBeat.o(43163);
  }
  
  public aj()
  {
    AppMethodBeat.i(43135);
    this.acGO = new a();
    this.acGP = this.acGO;
    this.acGQ = new LinkedList();
    this.oxD = new ConcurrentHashMap();
    this.acGR = null;
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.lPK.iterator();
    while (parama.hasNext())
    {
      com.tencent.mm.h.a.a.b localb = (com.tencent.mm.h.a.a.b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.oxD.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static int aZh(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43151);
    try
    {
      i = Util.getInt(paramString, 0);
      AppMethodBeat.o(43151);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          Log.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static a bvL(String paramString)
  {
    AppMethodBeat.i(43152);
    a locala = new a();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43152);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = XmlParser.parseXml(str1, "RoomData", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      AppMethodBeat.o(43152);
      return null;
    }
    i = 0;
    for (;;)
    {
      try
      {
        com.tencent.mm.h.a.a.b localb = new com.tencent.mm.h.a.a.b();
        if (i == 0)
        {
          str2 = ".RoomData.Member.$UserName";
          str1 = ".RoomData.Member.DisplayName";
          paramString = ".RoomData.Member.Flag";
          str2 = Util.nullAs((String)localMap.get(str2), "");
          if (!Util.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.displayName = Util.nullAs((String)localMap.get(str1), "");
            localb.lPN = aZh((String)localMap.get(paramString));
            locala.lPK.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label360;
          }
          str2 = ".RoomData.Member" + i + ".$UserName";
          str1 = ".RoomData.Member" + i + ".DisplayName";
          paramString = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = aZh((String)localMap.get(".RoomData.Type"));
        locala.status = aZh((String)localMap.get(".RoomData.Status"));
        locala.lyL = aZh((String)localMap.get(".RoomData.MaxCount"));
        locala.lPL = Util.nullAs((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        AppMethodBeat.o(43152);
        return locala;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(43152);
        return locala;
      }
      label360:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> bvM(String paramString)
  {
    AppMethodBeat.i(43154);
    LinkedList localLinkedList = new LinkedList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43154);
      return localLinkedList;
    }
    paramString = paramString.split(";");
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    AppMethodBeat.o(43154);
    return localLinkedList;
  }
  
  public static boolean iZk()
  {
    return false;
  }
  
  private static String kz(List<String> paramList)
  {
    AppMethodBeat.i(43153);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(43153);
      return "";
    }
    Object localObject = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)localObject + (String)paramList.get(i);
      localObject = str;
      if (i < paramList.size() - 1) {
        localObject = str + ";";
      }
      i += 1;
    }
    AppMethodBeat.o(43153);
    return localObject;
  }
  
  public final boolean Jf(String paramString)
  {
    AppMethodBeat.i(43162);
    if ((!Util.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(43162);
      return true;
    }
    AppMethodBeat.o(43162);
    return false;
  }
  
  public final aj KD(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final void P(String paramString, List<zh> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.acGP)) {
      iZh();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (zh)paramList.next();
      if (this.oxD.containsKey(((zh)localObject).UserName))
      {
        com.tencent.mm.h.a.a.b localb = (com.tencent.mm.h.a.a.b)this.oxD.get(((zh)localObject).UserName);
        localb.displayName = ((zh)localObject).ZhN;
        localb.lPN = ((zh)localObject).ZhQ;
        localb.lPO = ((zh)localObject).ZhR;
      }
    }
    this.acGP.lPK.clear();
    paramList = this.oxD.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.acGP.lPK.add((com.tencent.mm.h.a.a.b)this.oxD.get(localObject));
    }
    a(paramString, this.acGP, false);
    AppMethodBeat.o(43159);
  }
  
  public final aj a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.lPK.iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.h.a.a.b localb = (com.tencent.mm.h.a.a.b)localIterator.next();
        if ((localb.userName == null) || (!localb.userName.equals(paramString))) {
          break label226;
        }
        localObject = localb;
      }
    }
    label226:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.field_selfDisplayName = localObject.displayName;
        this.field_isShowname = (localObject.lPN & 0x1);
      }
      for (int i = localObject.lPN;; i = 0)
      {
        Log.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.eQp = (i & 0x2 | parama.eQp & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.eQp;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.acGP = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          }
        }
      }
    }
  }
  
  public final void a(djd paramdjd)
  {
    AppMethodBeat.i(248569);
    if (paramdjd == null) {}
    for (this.field_localChatRoomWatchMembers = new djd();; this.field_localChatRoomWatchMembers = paramdjd)
    {
      this.acGR = null;
      AppMethodBeat.o(248569);
      return;
    }
  }
  
  public final boolean aMF()
  {
    AppMethodBeat.i(43161);
    if (Util.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = z.bAM();
    if ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class) == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alP(this.field_chatroomname)) && (bvK(str))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = this.field_roomowner.equals(str);
      if ((i == 0) && (!bool)) {
        break;
      }
      AppMethodBeat.o(43161);
      return true;
    }
    AppMethodBeat.o(43161);
    return false;
  }
  
  public final void ayP(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.acGP)) {
      iZh();
    }
    this.acGP.hSm = paramInt;
    try
    {
      this.field_roomdata = this.acGP.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.acGO.computeSize() == parama.computeSize())
    {
      AppMethodBeat.o(43140);
      return true;
    }
    AppMethodBeat.o(43140);
    return false;
  }
  
  public final List<String> bHw()
  {
    AppMethodBeat.i(43137);
    if ((this.acGQ == null) || (this.acGQ.size() == 0)) {
      this.acGQ = bvM(this.field_memberlist);
    }
    List localList = this.acGQ;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final com.tencent.mm.h.a.a.b bvJ(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.oxD == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.oxD.size() <= 0) {
      iZh();
    }
    paramString = (com.tencent.mm.h.a.a.b)this.oxD.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
  }
  
  public final boolean bvK(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = bvJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.lPN & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(43156);
    try
    {
      this.field_roomdata = parama.toByteArray();
      AppMethodBeat.o(43156);
      return;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(248534);
    super.convertFrom(paramCursor);
    if ((this.field_roomInfoDetailResByte != null) && (this.field_roomInfoDetailResByte.length > 0)) {
      Log.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", new Object[] { this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length) });
    }
    AppMethodBeat.o(248534);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = bvJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = Util.nullAs(paramString.displayName, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
  
  public final a iZg()
  {
    AppMethodBeat.i(43136);
    if (b(this.acGP)) {
      iZh();
    }
    a locala = this.acGP;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void iZh()
  {
    AppMethodBeat.i(43139);
    if (Util.isNullOrNil(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.acGP = ((a)new a().parseFrom(this.field_roomdata));
      a(this.acGP);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.acGP = new a();
      }
    }
  }
  
  public final int iZi()
  {
    AppMethodBeat.i(43142);
    if (b(this.acGP)) {
      iZh();
    }
    int i = this.acGP.hSm;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean iZj()
  {
    AppMethodBeat.i(43144);
    if (b(this.acGP)) {
      iZh();
    }
    if (this.acGP.hSm < this.acGP.lPM)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int iZl()
  {
    AppMethodBeat.i(43146);
    if (b(this.acGP)) {
      iZh();
    }
    int i = this.acGP.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int iZm()
  {
    AppMethodBeat.i(43148);
    if (b(this.acGP)) {
      iZh();
    }
    int i = this.acGP.lyL;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean iZn()
  {
    return this.field_isShowname > 0;
  }
  
  public final a iZo()
  {
    AppMethodBeat.i(43160);
    if (b(this.acGP)) {
      iZh();
    }
    a locala = this.acGP;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final boolean iZp()
  {
    AppMethodBeat.i(248647);
    if (((this.field_chatroomStatus & 0x200000) == 2097152L) && (Util.isNullOrNil(this.field_associateOpenIMRoomName)))
    {
      AppMethodBeat.o(248647);
      return true;
    }
    AppMethodBeat.o(248647);
    return false;
  }
  
  public final boolean iZq()
  {
    return this.field_openIMRoomMigrateStatus == 1;
  }
  
  public final boolean iZr()
  {
    return this.field_openIMRoomMigrateStatus == 2;
  }
  
  public final boolean iZs()
  {
    return (this.field_openIMRoomMigrateStatus == 3) || (this.field_openIMRoomMigrateStatus == 4);
  }
  
  public final aj mI(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = kz(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final aj pG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, bvL(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.acGP)) {
      iZh();
    }
    this.field_chatroomdataflag = (this.acGP.eQp & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.aj
 * JD-Core Version:    0.7.0.1
 */