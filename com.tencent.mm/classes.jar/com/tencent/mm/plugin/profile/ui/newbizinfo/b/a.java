package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a
{
  public static final a.a Bke;
  private final LinkedList<o<b, dey>> Bka;
  private final Calendar Bkb;
  private final int Bkc;
  private final int Bkd;
  private final LinkedList<o<b, ou>> gCs;
  
  static
  {
    AppMethodBeat.i(169910);
    Bke = new a.a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.gCs = new LinkedList();
    this.Bka = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    p.g(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.Bkb = localCalendar;
    this.Bkc = this.Bkb.get(6);
    this.Bkd = this.Bkb.get(1);
    AppMethodBeat.o(39633);
  }
  
  private final b UV(int paramInt)
  {
    AppMethodBeat.i(169907);
    b localb = (b)((o)this.Bka.get(paramInt)).first;
    AppMethodBeat.o(169907);
    return localb;
  }
  
  private final dey UW(int paramInt)
  {
    AppMethodBeat.i(169909);
    dey localdey = (dey)((o)this.Bka.get(paramInt)).second;
    AppMethodBeat.o(169909);
    return localdey;
  }
  
  public final String UT(int paramInt)
  {
    AppMethodBeat.i(230660);
    Object localObject1 = MMApplicationContext.getContext();
    UU(paramInt);
    Object localObject2 = getItem(paramInt);
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
      AppMethodBeat.o(230660);
      throw ((Throwable)localObject1);
    }
    long l = ((ou)localObject2).KVq.LmE * 1000L;
    localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTime(new Date(l));
    p.g(localObject2, "Calendar.getInstance().apply { time = Date(date) }");
    DateFormat.format((CharSequence)((Context)localObject1).getString(2131760843), l);
    localObject1 = f.y((Context)localObject1, l).toString();
    AppMethodBeat.o(230660);
    return localObject1;
  }
  
  public final b UU(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.Bka.size())
    {
      localb = UV(paramInt);
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((o)this.gCs.get(paramInt - this.Bka.size())).first;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final void a(dey paramdey)
  {
    AppMethodBeat.i(230658);
    if ((paramdey != null) && (c.clv()))
    {
      LinkedList localLinkedList = paramdey.MJY;
      p.g(localLinkedList, "notifyInfo.notify_list");
      if (((Collection)localLinkedList).isEmpty()) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        this.Bka.clear();
        this.Bka.add(new o(b.Bkm, paramdey));
      }
      AppMethodBeat.o(230658);
      return;
    }
  }
  
  public final void b(ov paramov)
  {
    AppMethodBeat.i(230657);
    p.h(paramov, "msgList");
    this.gCs.clear();
    p.g(Calendar.getInstance(), "Calendar.getInstance()");
    new Date();
    Object localObject = paramov.KVw;
    p.g(localObject, "msgList.Msg");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ou localou = (ou)((Iterator)localObject).next();
      this.gCs.add(new o(b.Bkj, localou));
      this.gCs.add(new o(b.Bkk, localou));
    }
    paramov = paramov.KVx;
    if (paramov != null)
    {
      if (paramov.KWa == 0) {
        this.gCs.add(new o(b.Bkl, new ou()));
      }
      AppMethodBeat.o(230657);
      return;
    }
    AppMethodBeat.o(230657);
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.Bka.size())
    {
      localObject = UW(paramInt);
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((o)this.gCs.get(paramInt - this.Bka.size())).second;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(230659);
    int i = this.gCs.size();
    int j = this.Bka.size();
    AppMethodBeat.o(230659);
    return i + j;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      b localb1 = new b("SectionToday", 0);
      Bkf = localb1;
      b localb2 = new b("SectionYesterday", 1);
      Bkg = localb2;
      b localb3 = new b("SectionThisWeek", 2);
      Bkh = localb3;
      b localb4 = new b("SectionThisYear", 3);
      Bki = localb4;
      b localb5 = new b("SectionFullDate", 4);
      Bkj = localb5;
      b localb6 = new b("Message", 5);
      Bkk = localb6;
      b localb7 = new b("Loading", 6);
      Bkl = localb7;
      b localb8 = new b("VideoChannel", 7);
      Bkm = localb8;
      Bkn = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */