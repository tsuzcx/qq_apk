package com.tencent.mm.ui.chatting.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.protocal.protobuf.flr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow;", "", "()V", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a aeJh;
  
  static
  {
    AppMethodBeat.i(253976);
    aeJh = new a((byte)0);
    TAG = "MicroMsg.Chatting.ChatTagSearchSpanClickReportFlow";
    AppMethodBeat.o(253976);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindDataToWidget", "", "widget", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "userName", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(View paramView, cc paramcc, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(253991);
      s.u(paramcc, "msg");
      Log.i(a.access$getTAG$cp(), s.X("bindDataToWidget widget:", paramView));
      flr localflr;
      if (paramView != null)
      {
        localflr = new flr();
        localflr.YKq = paramcc.field_msgSvrId;
        if (!paramBoolean) {
          break label108;
        }
      }
      label108:
      for (int i = 2;; i = 1)
      {
        localflr.abMf = i;
        if (paramBoolean) {
          paramString = paramcc.field_talker;
        }
        localflr.abMg = paramString;
        localflr.YKn = paramcc.getCreateTime();
        localflr.abMh = 0;
        paramcc = com.tencent.mm.plugin.secdata.ui.a.PlI;
        com.tencent.mm.plugin.secdata.ui.a.a.a(paramView, (com.tencent.mm.bx.a)localflr);
        AppMethodBeat.o(253991);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */