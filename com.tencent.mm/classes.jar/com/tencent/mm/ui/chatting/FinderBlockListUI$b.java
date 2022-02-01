package com.tencent.mm.ui.chatting;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.ec;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlockListUI$b
  implements ScreenShotUtil.ScreenShotCallback
{
  FinderBlockListUI$b(FinderBlockListUI paramFinderBlockListUI) {}
  
  public final void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(253830);
    LinkedList localLinkedList;
    for (;;)
    {
      String str;
      try
      {
        paramString = k.aeZF;
        paramString = k.d((AppCompatActivity)this.aekZ).q(as.class);
        kotlin.g.b.s.s(paramString, "UICProvider.of(this@Find…rReporterUIC::class.java)");
        m localm = as.a((as)paramString);
        if (!(localm instanceof ae)) {
          break label281;
        }
        localLinkedList = new LinkedList();
        Iterator localIterator = ((Map)((ae)localm).Fsu).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (Map.Entry)localIterator.next();
        aps localaps = new aps();
        localaps.hKN = ((af)paramString.getValue()).feedId;
        paramString = ((af)paramString.getValue()).ANj;
        if (paramString == null)
        {
          paramString = "";
          localaps.finderUsername = paramString;
          paramString = z.FrZ;
          str = z.p(localaps.hKN, ((ae)localm).Auc.AJo);
          paramString = str;
          if (str == null) {
            paramString = "";
          }
          localaps.sessionBuffer = paramString;
          localLinkedList.add(localaps);
          continue;
        }
        str = paramString.getUserName();
      }
      finally
      {
        Log.printErrStackTrace(FinderBlockListUI.a(this.aekZ), paramString, "onScreenShot", new Object[0]);
        AppMethodBeat.o(253830);
        return;
      }
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
    paramString = new ec((List)localLinkedList);
    h.aZW().a((p)paramString, 0);
    AppMethodBeat.o(253830);
    return;
    label281:
    Log.i(FinderBlockListUI.a(this.aekZ), "onScreenShot: not FinderSingleFeedFlowReporter");
    AppMethodBeat.o(253830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.FinderBlockListUI.b
 * JD-Core Version:    0.7.0.1
 */