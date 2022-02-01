package com.tencent.mm.ui.chatting.l;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow;", "", "()V", "Companion", "app_release"})
public final class a
{
  public static final a PEV;
  private static final String TAG = "MicroMsg.Chatting.ChatTagSearchSpanClickReportFlow";
  
  static
  {
    AppMethodBeat.i(231348);
    PEV = new a((byte)0);
    TAG = "MicroMsg.Chatting.ChatTagSearchSpanClickReportFlow";
    AppMethodBeat.o(231348);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindDataToWidget", "", "widget", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "userName", "app_release"})
  public static final class a
  {
    public static void a(View paramView, ca paramca, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(231347);
      p.h(paramca, "msg");
      Log.i(a.access$getTAG$cp(), "bindDataToWidget widget:".concat(String.valueOf(paramView)));
      if (paramView != null)
      {
        egl localegl = new egl();
        localegl.KMf = paramca.ajM();
        if (paramBoolean) {}
        for (int i = 2;; i = 1)
        {
          localegl.Ngu = i;
          if (paramBoolean) {
            paramString = paramca.ajO();
          }
          localegl.Ngv = paramString;
          localegl.KMc = paramca.getCreateTime();
          localegl.Ngw = 0;
          paramca = SecDataUIC.CWq;
          SecDataUIC.a.a(paramView, (com.tencent.mm.bw.a)localegl);
          AppMethodBeat.o(231347);
          return;
        }
      }
      AppMethodBeat.o(231347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a
 * JD-Core Version:    0.7.0.1
 */