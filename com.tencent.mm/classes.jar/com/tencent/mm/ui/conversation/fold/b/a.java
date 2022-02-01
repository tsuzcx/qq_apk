package com.tencent.mm.ui.conversation.fold.b;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.jq;
import com.tencent.mm.autogen.mmdata.rpt.pz;
import com.tencent.mm.autogen.mmdata.rpt.qa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/fold/report/FoldReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOP_SESSION_INFO_REPORT_INTERVAL", "", "mainFrameEnterSessionReport", "", "username", "convs", "", "Lcom/tencent/mm/storage/Conversation;", "foldedCount", "", "position", "listView", "Landroid/widget/AbsListView;", "topSessionFoldReport", "topCount", "action", "topSessionInfoReport", "oneScreenCount", "limitRate", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a afuo;
  
  static
  {
    AppMethodBeat.i(256897);
    afuo = new a();
    TAG = "MicroMsg.FoldReportLog";
    AppMethodBeat.o(256897);
  }
  
  public static void a(String paramString, Collection<? extends bb> paramCollection, int paramInt1, int paramInt2, AbsListView paramAbsListView)
  {
    AppMethodBeat.i(256883);
    label106:
    int i;
    label121:
    int j;
    if ((paramString != null) && (paramCollection != null) && (paramAbsListView != null)) {
      switch (ac.Jj(paramString))
      {
      default: 
        AppMethodBeat.o(256883);
        return;
      case 1: 
      case 2: 
        l = 1L;
        Iterator localIterator = ((Iterable)paramCollection).iterator();
        while (localIterator.hasNext())
        {
          paramAbsListView = localIterator.next();
          if (s.p(((bb)paramAbsListView).field_username, paramString))
          {
            paramAbsListView = (bb)paramAbsListView;
            if (paramAbsListView != null) {
              break label300;
            }
            i = 0;
            if (paramAbsListView != null) {
              break label310;
            }
            j = 0;
            label129:
            paramAbsListView = com.tencent.mm.storage.b.a.admS;
            boolean bool1 = com.tencent.mm.storage.b.a.jdN();
            bh.bCz();
            boolean bool2 = c.bzG().bxV(paramString);
            paramAbsListView = new jq();
            paramAbsListView.iNl = l;
            paramAbsListView.imN = paramAbsListView.F("ChatName", paramString, true);
            if (!bool2) {
              break label320;
            }
            l = 1L;
            label192:
            paramAbsListView.iUv = l;
            int k = paramCollection.size();
            if (!bool1) {
              break label326;
            }
            label212:
            paramAbsListView.ipv = (k + paramInt1);
            if (!bool1) {
              break label331;
            }
            l = 1L;
            label230:
            paramAbsListView.iUw = l;
            if (bool2) {
              break label355;
            }
            paramString = com.tencent.mm.storage.b.a.admS;
            if (!com.tencent.mm.storage.b.a.jdP()) {
              break label355;
            }
          }
        }
      }
    }
    label300:
    label310:
    label320:
    label326:
    label331:
    label355:
    for (long l = paramInt2;; l = paramInt2 + 1)
    {
      paramAbsListView.iUx = l;
      paramAbsListView.iUy = (i + j);
      paramAbsListView.bMH();
      AppMethodBeat.o(256883);
      return;
      l = 2L;
      break;
      paramAbsListView = null;
      break label106;
      i = paramAbsListView.field_unReadCount;
      break label121;
      j = paramAbsListView.field_unReadMuteCount;
      break label129;
      l = 0L;
      break label192;
      paramInt1 = 0;
      break label212;
      paramString = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdO())
      {
        l = 2L;
        break label230;
      }
      l = 0L;
      break label230;
    }
  }
  
  public static void a(Collection<? extends bb> paramCollection, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(256872);
    if (paramLong1 <= 0L)
    {
      AppMethodBeat.o(256872);
      return;
    }
    if (paramCollection != null)
    {
      long l = System.currentTimeMillis();
      if (l - MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getLong("top_session_info_report", 0L) > 86400000L) {
        h.ahAA.bm(new a..ExternalSyntheticLambda0(paramCollection, paramLong1, paramLong2, l));
      }
    }
    AppMethodBeat.o(256872);
  }
  
  private static final void a(Collection paramCollection, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(256893);
    s.u(paramCollection, "$it");
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l11 = 0L;
    paramCollection = ((Iterable)paramCollection).iterator();
    long l4 = 0L;
    long l9;
    long l7;
    long l5;
    if (paramCollection.hasNext())
    {
      bb localbb = (bb)paramCollection.next();
      bh.bCz();
      if (c.bzG().k(localbb))
      {
        long l6 = l1;
        long l8 = l2;
        long l10 = l3;
        switch (ac.Jj(localbb.field_username))
        {
        default: 
          l10 = l3;
          l8 = l2;
          l6 = l1;
        }
        for (;;)
        {
          if (localbb.field_unReadCount <= 0)
          {
            l9 = l6;
            l7 = l8;
            l5 = l10;
            if (localbb.field_unReadMuteCount <= 0) {
              break label370;
            }
          }
          l11 = 1L + l11;
          l1 = l6;
          l2 = l8;
          l3 = l10;
          break;
          l8 = l2 + 1L;
          l6 = l1;
          l10 = l3;
          continue;
          l6 = l1 + 1L;
          l8 = l2;
          l10 = l3;
          continue;
          l10 = l3 + 1L;
          l6 = l1;
          l8 = l2;
        }
      }
      if (localbb.field_unReadCount <= 0)
      {
        l9 = l1;
        l7 = l2;
        l5 = l3;
        if (localbb.field_unReadMuteCount <= 0) {
          break label370;
        }
      }
      l4 += 1L;
      l9 = l1;
      l1 = l4;
    }
    for (;;)
    {
      l4 = l1;
      l1 = l9;
      break;
      paramCollection = new qa();
      paramCollection.jpV = l3;
      paramCollection.jpW = l2;
      paramCollection.jpX = l1;
      paramCollection.jpY = l11;
      paramCollection.jpZ = l4;
      paramCollection.jqa = paramLong1;
      paramCollection.jqb = paramLong2;
      paramCollection.bMH();
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putLong("top_session_info_report", paramLong3);
      AppMethodBeat.o(256893);
      return;
      label370:
      l1 = l4;
      l2 = l7;
      l3 = l5;
    }
  }
  
  public static void bJ(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(256866);
    pz localpz = new pz();
    localpz.jpU = paramLong1;
    localpz.ikE = paramLong2;
    localpz.bMH();
    AppMethodBeat.o(256866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.fold.b.a
 * JD-Core Version:    0.7.0.1
 */