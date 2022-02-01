package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.festival.a.a.a;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021;", "", "()V", "ChattingItemAppMsgFestival2021From", "ChattingItemAppMsgFestival2021To", "Companion", "app_release"})
public final class n
{
  private static final String TAG = "MicroMsg.ChattingItemAppMsgFestival2021";
  public static final c XfO;
  
  static
  {
    AppMethodBeat.i(272771);
    XfO = new c((byte)0);
    TAG = "MicroMsg.ChattingItemAppMsgFestival2021";
    AppMethodBeat.o(272771);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021From;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"})
  public static final class a
    extends ChatingItemAppMsgFinderLiveFeed.a
  {
    public final void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(280241);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      n.c localc = n.XfO;
      n.c.a(paramActivity, paramca);
      AppMethodBeat.o(280241);
    }
    
    public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(280242);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      p.k(parama, "ui");
      parama = n.XfO;
      n.c.a(paramAppMsgFinderLiveFeedHolder, parambcp);
      AppMethodBeat.o(280242);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1074790449);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(280243);
      p.k(paramView, "v");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      ((com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class)).fp(paramView.getContext());
      AppMethodBeat.o(280243);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021To;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"})
  public static final class b
    extends ChatingItemAppMsgFinderLiveFeed.b
  {
    public final void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(206440);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      n.c localc = n.XfO;
      n.c.a(paramActivity, paramca);
      AppMethodBeat.o(206440);
    }
    
    public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(206441);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      p.k(parama, "ui");
      parama = n.XfO;
      n.c.a(paramAppMsgFinderLiveFeedHolder, parambcp);
      AppMethodBeat.o(206441);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1074790449);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(206442);
      p.k(paramView, "v");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      ((com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class)).fp(paramView.getContext());
      AppMethodBeat.o(206442);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkLiveStatus", "", "scene", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"})
  public static final class c
  {
    public static void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(290086);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      if (!Util.isNullOrNil(paramca.getContent()))
      {
        paramca = k.b.OQ(paramca.getContent());
        if (paramca != null)
        {
          Intent localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Type", 29);
          localIntent.putExtra("Multi_Retr", true);
          localIntent.putExtra("Retr_Msg_content", k.b.a(paramca, null, null));
          localIntent.putExtra("Retr_go_to_chattingUI", false);
          localIntent.putExtra("Retr_show_success_tips", true);
          paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramca.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramca.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      AppMethodBeat.o(290086);
    }
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp)
    {
      AppMethodBeat.i(290087);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      Object localObject = (com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class);
      a locala = a.XfP;
      int j = ((com.tencent.mm.plugin.festival.a.a)localObject).dmu().liveStatus;
      Log.i(n.access$getTAG$cp(), "[checkLiveStatus] festival,desc:" + parambcp.desc + ",share status:" + parambcp.liveStatus);
      localObject = (CharSequence)parambcp.coverUrl;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label190;
        }
        localObject = parambcp.coverUrl;
      }
      for (;;)
      {
        if (j != 2) {
          break label241;
        }
        parambcp.liveStatus = j;
        parambcp = paramAppMsgFinderLiveFeedHolder.getLiveTag();
        if (parambcp != null) {
          parambcp.setVisibility(8);
        }
        parambcp = paramAppMsgFinderLiveFeedHolder.getLiveEndTag();
        if (parambcp != null) {
          parambcp.setVisibility(0);
        }
        ((ak)h.ag(ak.class)).getFinderUtilApi().f(paramAppMsgFinderLiveFeedHolder.getFinderThumb(), (String)localObject);
        AppMethodBeat.o(290087);
        return;
        i = 0;
        break;
        label190:
        localObject = (CharSequence)parambcp.headUrl;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label234;
          }
          localObject = parambcp.headUrl;
          break;
        }
        label234:
        localObject = "";
      }
      label241:
      if (j == 1) {
        parambcp.liveStatus = j;
      }
      AppMethodBeat.o(290087);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$FestivalLiveInfo;", "kotlin.jvm.PlatformType", "onInfoUpdate"})
    static final class a
    {
      public static final a XfP;
      
      static
      {
        AppMethodBeat.i(269639);
        XfP = new a();
        AppMethodBeat.o(269639);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n
 * JD-Core Version:    0.7.0.1
 */