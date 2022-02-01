package com.tencent.mm.ui.chatting.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow;", "", "()V", "Companion", "app_release"})
public final class a
{
  private static final String TAG = "MicroMsg.Chatting.ChatTagSearchSpanClickReportFlow";
  public static final a WZH;
  
  static
  {
    AppMethodBeat.i(288006);
    WZH = new a((byte)0);
    TAG = "MicroMsg.Chatting.ChatTagSearchSpanClickReportFlow";
    AppMethodBeat.o(288006);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindDataToWidget", "", "widget", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "userName", "app_release"})
  public static final class a
  {
    public static void a(View paramView, ca paramca, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(267005);
      p.k(paramca, "msg");
      Log.i(a.access$getTAG$cp(), "bindDataToWidget widget:".concat(String.valueOf(paramView)));
      if (paramView != null)
      {
        eqn localeqn = new eqn();
        localeqn.RNc = paramca.apH();
        if (paramBoolean) {}
        for (int i = 2;; i = 1)
        {
          localeqn.UsY = i;
          if (paramBoolean) {
            paramString = paramca.apJ();
          }
          localeqn.UsZ = paramString;
          localeqn.RMZ = paramca.getCreateTime();
          localeqn.Uta = 0;
          paramca = com.tencent.mm.plugin.secdata.ui.a.JbV;
          com.tencent.mm.plugin.secdata.ui.a.a.a(paramView, (com.tencent.mm.cd.a)localeqn);
          AppMethodBeat.o(267005);
          return;
        }
      }
      AppMethodBeat.o(267005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a
 * JD-Core Version:    0.7.0.1
 */