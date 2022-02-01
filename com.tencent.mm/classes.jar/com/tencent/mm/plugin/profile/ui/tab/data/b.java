package com.tencent.mm.plugin.profile.ui.tab.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileOptReporter;", "", "()V", "OPT_CLICK", "", "OPT_EXPOSE", "PROFILE_TAB_OPTION", "PROFILE_TOPIC_OPTION", "TAB_MSG", "TAB_NONE", "TAB_SERVICE", "TAB_VIDEO", "TOPIC_EXPAND_CLICK", "TOPIC_LABEL_CLICK", "reportTabClick", "", "contact", "Lcom/tencent/mm/storage/Contact;", "tabType", "addContactScene", "reportTabExposed", "reportTopicClick", "topic", "Lcom/tencent/mm/protocal/protobuf/BizTopic;", "reportTopicExpand", "app_release"})
public final class b
{
  public static final b BmM;
  
  static
  {
    AppMethodBeat.i(230720);
    BmM = new b();
    AppMethodBeat.o(230720);
  }
  
  public static void a(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230716);
    if ((paramas != null) && (paramas.arv() == true) && (paramas.arH() > 0)) {}
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
      h.CyF.a(21647, new Object[] { paramas, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(230716);
      return;
    }
  }
  
  public static void a(as paramas, qf paramqf)
  {
    AppMethodBeat.i(230718);
    p.h(paramqf, "topic");
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
    h.CyF.a(21648, new Object[] { paramas, Integer.valueOf(1), paramqf.KXd, Long.valueOf(paramqf.KXg) });
    AppMethodBeat.o(230718);
  }
  
  public static void ac(as paramas)
  {
    AppMethodBeat.i(230719);
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
    h.CyF.a(21648, new Object[] { paramas, Integer.valueOf(2) });
    AppMethodBeat.o(230719);
  }
  
  public static void b(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230717);
    if ((paramas != null) && (paramas.arv() == true) && (paramas.arH() > 0)) {}
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
      h.CyF.a(21647, new Object[] { paramas, Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(230717);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.b
 * JD-Core Version:    0.7.0.1
 */