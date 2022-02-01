package com.tencent.mm.plugin.profile.ui.tab.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileOptReporter;", "", "()V", "OPT_CLICK", "", "OPT_EXPOSE", "PROFILE_TAB_OPTION", "PROFILE_TOPIC_OPTION", "TAB_MSG", "TAB_NONE", "TAB_SERVICE", "TAB_VIDEO", "TOPIC_EXPAND_CLICK", "TOPIC_LABEL_CLICK", "reportTabClick", "", "contact", "Lcom/tencent/mm/storage/Contact;", "tabType", "addContactScene", "reportTabExposed", "reportTopicClick", "topic", "Lcom/tencent/mm/protocal/protobuf/BizTopic;", "reportTopicExpand", "app_release"})
public final class b
{
  public static final b Hhf;
  
  static
  {
    AppMethodBeat.i(277646);
    Hhf = new b();
    AppMethodBeat.o(277646);
  }
  
  public static void a(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277639);
    if ((paramas != null) && (paramas.axZ() == true) && (paramas.ayq() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (paramas != null)
      {
        String str = paramas.getUsername();
        paramas = str;
        if (str != null) {}
      }
      else
      {
        paramas = "";
      }
      h.IzE.a(21647, new Object[] { paramas, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(277639);
      return;
    }
  }
  
  public static void a(as paramas, qb paramqb)
  {
    AppMethodBeat.i(277642);
    p.k(paramqb, "topic");
    if (paramas != null)
    {
      String str = paramas.getUsername();
      paramas = str;
      if (str != null) {}
    }
    else
    {
      paramas = "";
    }
    h.IzE.a(21648, new Object[] { paramas, Integer.valueOf(1), paramqb.RYs, Long.valueOf(paramqb.RYv) });
    AppMethodBeat.o(277642);
  }
  
  public static void aj(as paramas)
  {
    AppMethodBeat.i(277644);
    if (paramas != null)
    {
      String str = paramas.getUsername();
      paramas = str;
      if (str != null) {}
    }
    else
    {
      paramas = "";
    }
    h.IzE.a(21648, new Object[] { paramas, Integer.valueOf(2) });
    AppMethodBeat.o(277644);
  }
  
  public static void b(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277640);
    if ((paramas != null) && (paramas.axZ() == true) && (paramas.ayq() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (paramas != null)
      {
        String str = paramas.getUsername();
        paramas = str;
        if (str != null) {}
      }
      else
      {
        paramas = "";
      }
      h.IzE.a(21647, new Object[] { paramas, Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(277640);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.b
 * JD-Core Version:    0.7.0.1
 */