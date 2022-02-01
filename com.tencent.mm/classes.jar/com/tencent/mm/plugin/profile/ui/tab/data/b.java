package com.tencent.mm.plugin.profile.ui.tab.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileOptReporter;", "", "()V", "OPT_CLICK", "", "OPT_EXPOSE", "PROFILE_TAB_OPTION", "PROFILE_TOPIC_OPTION", "TAB_MSG", "TAB_NONE", "TAB_SERVICE", "TAB_VIDEO", "TOPIC_EXPAND_CLICK", "TOPIC_LABEL_CLICK", "reportTabClick", "", "contact", "Lcom/tencent/mm/storage/Contact;", "tabType", "addContactScene", "enterTime", "", "searchClickId", "", "reportTabExposed", "reportTopicClick", "topic", "Lcom/tencent/mm/protocal/protobuf/BizTopic;", "reportTopicExpand", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Ner;
  
  static
  {
    AppMethodBeat.i(305951);
    Ner = new b();
    AppMethodBeat.o(305951);
  }
  
  public static void a(au paramau, int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(305922);
    int i;
    if ((paramau != null) && (d.rs(paramau.field_type) == true))
    {
      i = 1;
      if ((i == 0) || ((int)paramau.maN <= 0)) {
        break label128;
      }
      i = 1;
      label39:
      if (paramau != null) {
        break label134;
      }
      paramau = "";
    }
    for (;;)
    {
      h.OAn.b(21647, new Object[] { paramau, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(305922);
      return;
      i = 0;
      break;
      label128:
      i = 0;
      break label39;
      label134:
      String str = paramau.field_username;
      paramau = str;
      if (str == null) {
        paramau = "";
      }
    }
  }
  
  public static void a(au paramau, rl paramrl)
  {
    AppMethodBeat.i(305935);
    s.u(paramrl, "topic");
    if (paramau == null) {
      paramau = "";
    }
    for (;;)
    {
      h.OAn.b(21648, new Object[] { paramau, Integer.valueOf(1), paramrl.YWs, Long.valueOf(paramrl.YWv) });
      AppMethodBeat.o(305935);
      return;
      String str = paramau.field_username;
      paramau = str;
      if (str == null) {
        paramau = "";
      }
    }
  }
  
  public static void ap(au paramau)
  {
    AppMethodBeat.i(305943);
    if (paramau == null) {
      paramau = "";
    }
    for (;;)
    {
      h.OAn.b(21648, new Object[] { paramau, Integer.valueOf(2) });
      AppMethodBeat.o(305943);
      return;
      String str = paramau.field_username;
      paramau = str;
      if (str == null) {
        paramau = "";
      }
    }
  }
  
  public static void b(au paramau, int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(305928);
    int i;
    if ((paramau != null) && (d.rs(paramau.field_type) == true))
    {
      i = 1;
      if ((i == 0) || ((int)paramau.maN <= 0)) {
        break label128;
      }
      i = 1;
      label39:
      if (paramau != null) {
        break label134;
      }
      paramau = "";
    }
    for (;;)
    {
      h.OAn.b(21647, new Object[] { paramau, Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(305928);
      return;
      i = 0;
      break;
      label128:
      i = 0;
      break label39;
      label134:
      String str = paramau.field_username;
      paramau = str;
      if (str == null) {
        paramau = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.b
 * JD-Core Version:    0.7.0.1
 */