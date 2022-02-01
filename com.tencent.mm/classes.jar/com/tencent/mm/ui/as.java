package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.c.b;
import com.tencent.mm.live.b.c.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.LinkedList;

public final class as
{
  private static as LCL;
  private static HashSet<a> LCM;
  private b.a Fwx;
  private LinkedList<com.tencent.mm.live.b.c.a> LCF;
  private ar LCt;
  private String qsP;
  
  static
  {
    AppMethodBeat.i(204937);
    LCM = new HashSet();
    AppMethodBeat.o(204937);
  }
  
  private as(String paramString)
  {
    AppMethodBeat.i(204923);
    this.Fwx = new b.a()
    {
      public final void aUu(String paramAnonymousString)
      {
        AppMethodBeat.i(204921);
        if (as.a(as.this).equals(paramAnonymousString))
        {
          as.b(as.this);
          if (as.c(as.this) != null)
          {
            as.c(as.this).gaf();
            AppMethodBeat.o(204921);
            return;
          }
          as.et(paramAnonymousString);
        }
        AppMethodBeat.o(204921);
      }
    };
    this.qsP = paramString;
    gaf();
    getLiveTipsBarStorage().Fwx = this.Fwx;
    AppMethodBeat.o(204923);
  }
  
  public static void Ci(long paramLong)
  {
    AppMethodBeat.i(204932);
    ad.i("MicroMsg.LiveTalkRoomTipsBarManager", "deleteLiveFromTipsBar, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    getLiveTipsBarStorage().Bj(paramLong);
    AppMethodBeat.o(204932);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(204928);
    if (LCM != null) {
      LCM.add(parama);
    }
    AppMethodBeat.o(204928);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(204931);
    ad.i("MicroMsg.LiveTalkRoomTipsBarManager", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { paramString1, Long.valueOf(paramLong1) });
    com.tencent.mm.live.b.c.a locala = new com.tencent.mm.live.b.c.a();
    locala.field_hostRoomId = paramString1;
    locala.field_liveId = paramLong1;
    locala.field_liveName = paramString2;
    locala.field_thumbUrl = paramString3;
    locala.field_anchorUsername = paramString4;
    locala.field_isSender = paramBoolean.booleanValue();
    locala.field_timeStamp = paramLong2;
    getLiveTipsBarStorage().a(locala);
    AppMethodBeat.o(204931);
  }
  
  public static as aWi(String paramString)
  {
    AppMethodBeat.i(204924);
    if ((LCL == null) || (!LCL.qsP.equals(paramString))) {
      LCL = new as(paramString);
    }
    paramString = LCL;
    AppMethodBeat.o(204924);
    return paramString;
  }
  
  public static void aWj(String paramString)
  {
    AppMethodBeat.i(204933);
    ad.i("MicroMsg.LiveTalkRoomTipsBarManager", "deleteHostRoomIdFromTipsBar, hostRoomId:%s", new Object[] { paramString });
    b localb = getLiveTipsBarStorage();
    int i = localb.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    ad.d("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId:%s", new Object[] { paramString });
    if (i < 0)
    {
      ad.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(204933);
      return;
    }
    if (localb.Fwx != null) {
      localb.Fwx.aUu(paramString);
    }
    AppMethodBeat.o(204933);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(204929);
    if (LCM != null) {
      LCM.remove(parama);
    }
    AppMethodBeat.o(204929);
  }
  
  public static void ci(String paramString, long paramLong)
  {
    AppMethodBeat.i(204934);
    ad.i("MicroMsg.LiveTalkRoomTipsBarManager", "setVisitingLive, hostRoom:%s, liveId:%d", new Object[] { paramString, Long.valueOf(paramLong) });
    getLiveTipsBarStorage().ci(paramString, paramLong);
    AppMethodBeat.o(204934);
  }
  
  private void gaf()
  {
    AppMethodBeat.i(204927);
    this.LCF = getLiveTipsBarStorage().aUt(this.qsP);
    AppMethodBeat.o(204927);
  }
  
  private static b getLiveTipsBarStorage()
  {
    AppMethodBeat.i(204930);
    b localb = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    AppMethodBeat.o(204930);
    return localb;
  }
  
  public final void c(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(204925);
    this.LCt = new ar(paramLiveTalkRoomTipsBar, this.qsP, this.LCF);
    AppMethodBeat.o(204925);
  }
  
  public final LinkedList<com.tencent.mm.live.b.c.a> gag()
  {
    AppMethodBeat.i(204926);
    if (this.LCF == null) {
      gaf();
    }
    LinkedList localLinkedList = this.LCF;
    AppMethodBeat.o(204926);
    return localLinkedList;
  }
  
  public static abstract interface a
  {
    public abstract void aWk(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.as
 * JD-Core Version:    0.7.0.1
 */