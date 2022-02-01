package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.px;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a Nco;
  public final LinkedList<r<b, ehk>> Ncp;
  private final Calendar Ncq;
  private final int Ncr;
  private final int Ncs;
  public final LinkedList<r<b, px>> lPK;
  
  static
  {
    AppMethodBeat.i(169910);
    Nco = new a.a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.lPK = new LinkedList();
    this.Ncp = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    ah localah = ah.aiuX;
    s.s(localCalendar, "getInstance().apply { time = Date() }");
    this.Ncq = localCalendar;
    this.Ncr = this.Ncq.get(6);
    this.Ncs = this.Ncq.get(1);
    AppMethodBeat.o(39633);
  }
  
  public final b afT(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.Ncp.size())
    {
      localb = (b)((r)this.Ncp.get(paramInt)).bsC;
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((r)this.lPK.get(paramInt - this.Ncp.size())).bsC;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.Ncp.size())
    {
      localObject = (ehk)((r)this.Ncp.get(paramInt)).bsD;
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((r)this.lPK.get(paramInt - this.Ncp.size())).bsD;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      Nct = new b("SectionToday", 0);
      Ncu = new b("SectionYesterday", 1);
      Ncv = new b("SectionThisWeek", 2);
      Ncw = new b("SectionThisYear", 3);
      Ncx = new b("SectionFullDate", 4);
      Ncy = new b("Message", 5);
      Ncz = new b("Loading", 6);
      NcA = new b("VideoChannel", 7);
      NcB = new b[] { Nct, Ncu, Ncv, Ncw, Ncx, Ncy, Ncz, NcA };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */