package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.f.b.j;
import a.l;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.lf;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "list", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "setSize", "(I)V", "getDateString", "", "position", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "ItemType", "app_release"})
public final class a
{
  public final LinkedList<o<a.a, lf>> elu;
  private final Calendar pEb;
  private final int pEc;
  private final int pEd;
  
  public a()
  {
    AppMethodBeat.i(154049);
    this.elu = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    j.p(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.pEb = localCalendar;
    this.pEc = this.pEb.get(6);
    this.pEd = this.pEb.get(1);
    AppMethodBeat.o(154049);
  }
  
  public final a.a BL(int paramInt)
  {
    AppMethodBeat.i(154047);
    a.a locala = (a.a)((o)this.elu.get(paramInt)).first;
    AppMethodBeat.o(154047);
    return locala;
  }
  
  public final lf BM(int paramInt)
  {
    AppMethodBeat.i(154048);
    lf locallf = (lf)((o)this.elu.get(paramInt)).second;
    AppMethodBeat.o(154048);
    return locallf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */