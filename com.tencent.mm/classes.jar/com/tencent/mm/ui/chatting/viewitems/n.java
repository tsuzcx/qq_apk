package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.festival.a.a.a;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021;", "", "()V", "ChattingItemAppMsgFestival2021From", "ChattingItemAppMsgFestival2021To", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private static final String TAG;
  public static final c aePQ;
  
  static
  {
    AppMethodBeat.i(254937);
    aePQ = new c((byte)0);
    TAG = "MicroMsg.ChattingItemAppMsgFestival2021";
    AppMethodBeat.o(254937);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021From;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ChatingItemAppMsgFinderLiveFeed.b
  {
    public final void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255569);
      s.u(paramActivity, "context");
      s.u(paramcc, "msg");
      n.c localc = n.aePQ;
      n.c.a(paramActivity, paramcc);
      AppMethodBeat.o(255569);
    }
    
    public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255575);
      s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      s.u(parambmr, "shareObject");
      s.u(parama, "ui");
      parama = n.aePQ;
      n.c.a(paramAppMsgFinderLiveFeedHolder, parambmr);
      AppMethodBeat.o(255575);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255578);
      s.u(paramView, "v");
      s.u(parama, "ui");
      s.u(paramcc, "msg");
      ((com.tencent.mm.plugin.festival.a.a)h.ax(com.tencent.mm.plugin.festival.a.a.class)).gn(paramView.getContext());
      AppMethodBeat.o(255578);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1074790449);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021To;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ChatingItemAppMsgFinderLiveFeed.c
  {
    public final void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255584);
      s.u(paramActivity, "context");
      s.u(paramcc, "msg");
      n.c localc = n.aePQ;
      n.c.a(paramActivity, paramcc);
      AppMethodBeat.o(255584);
    }
    
    public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255589);
      s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      s.u(parambmr, "shareObject");
      s.u(parama, "ui");
      parama = n.aePQ;
      n.c.a(paramAppMsgFinderLiveFeedHolder, parambmr);
      AppMethodBeat.o(255589);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255591);
      s.u(paramView, "v");
      s.u(parama, "ui");
      s.u(paramcc, "msg");
      ((com.tencent.mm.plugin.festival.a.a)h.ax(com.tencent.mm.plugin.festival.a.a.class)).gn(paramView.getContext());
      AppMethodBeat.o(255591);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1074790449);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkLiveStatus", "", "scene", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255561);
      s.u(paramActivity, "context");
      s.u(paramcc, "msg");
      if (!Util.isNullOrNil(paramcc.field_content))
      {
        k.b localb = k.b.Hf(paramcc.field_content);
        if (localb != null)
        {
          Intent localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
          localIntent.putExtra("Retr_Msg_Type", 29);
          localIntent.putExtra("Multi_Retr", true);
          localIntent.putExtra("Retr_Msg_content", k.b.a(localb, null, null));
          localIntent.putExtra("Retr_go_to_chattingUI", false);
          localIntent.putExtra("Retr_show_success_tips", true);
          paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramcc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramcc.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      AppMethodBeat.o(255561);
    }
    
    private static final void a(a.a parama) {}
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr)
    {
      AppMethodBeat.i(255564);
      s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      s.u(parambmr, "shareObject");
      Object localObject = (com.tencent.mm.plugin.festival.a.a)h.ax(com.tencent.mm.plugin.festival.a.a.class);
      n.c..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = n.c..ExternalSyntheticLambda0.INSTANCE;
      int j = ((com.tencent.mm.plugin.festival.a.a)localObject).dTl().liveStatus;
      Log.i(n.access$getTAG$cp(), "[checkLiveStatus] festival,desc:" + parambmr.desc + ",share status:" + parambmr.liveStatus);
      localObject = (CharSequence)parambmr.coverUrl;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label151;
        }
        localObject = parambmr.coverUrl;
        label116:
        switch (j)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(255564);
        return;
        i = 0;
        break;
        label151:
        localObject = (CharSequence)parambmr.headUrl;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label195;
          }
          localObject = parambmr.headUrl;
          break;
        }
        label195:
        localObject = "";
        break label116;
        parambmr.liveStatus = j;
        parambmr = paramAppMsgFinderLiveFeedHolder.getLiveTag();
        if (parambmr != null) {
          parambmr.setVisibility(8);
        }
        parambmr = paramAppMsgFinderLiveFeedHolder.getLiveEndTag();
        if (parambmr != null) {
          parambmr.setVisibility(0);
        }
        ((cn)h.az(cn.class)).getFinderUtilApi().a(paramAppMsgFinderLiveFeedHolder.getFinderThumb(), (String)localObject);
        AppMethodBeat.o(255564);
        return;
        parambmr.liveStatus = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n
 * JD-Core Version:    0.7.0.1
 */