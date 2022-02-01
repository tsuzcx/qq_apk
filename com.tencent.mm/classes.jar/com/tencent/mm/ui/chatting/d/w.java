package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.t;
import kotlin.l;

@com.tencent.mm.ui.chatting.d.a.a(gRF=t.class)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "needDelay", "", "needShowFloatBall", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
public final class w
  extends a
  implements ChatFooter.f, t
{
  public static final w.a PpB;
  private com.tencent.mm.ui.chatting.e.a OFl;
  private int PpA = -1;
  private ChatFooter Ppy;
  private int Ppz = -1;
  private b oWG;
  
  static
  {
    AppMethodBeat.i(180128);
    PpB = new w.a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.OFl = parama;
    this.oWG = ((b)g.af(b.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bD(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.Ppy = paramChatFooter;
    paramChatFooter = this.Ppy;
    if (paramChatFooter != null)
    {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
      AppMethodBeat.o(180126);
      return;
    }
    AppMethodBeat.o(180126);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(180124);
    super.cFx();
    Object localObject = this.oWG;
    if (localObject != null) {
      ((b)localObject).jR(true);
    }
    localObject = this.oWG;
    if (localObject != null) {
      ((b)localObject).chX();
    }
    localObject = this.OFl;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).gRJ();
      if (localObject != null)
      {
        localObject = ((MMFragment)localObject).getArguments();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("chat_from_scene", 0);
          localObject = this.OFl;
          if (localObject == null) {
            break label323;
          }
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).gRJ();
          if (localObject == null) {
            break label323;
          }
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject == null) {
            break label323;
          }
        }
      }
    }
    label323:
    for (boolean bool = ((Bundle)localObject).getBoolean("key_can_show_message_float_ball", false);; bool = false)
    {
      localObject = this.oWG;
      if ((localObject != null) && (((b)localObject).chO() == true)) {
        Log.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i != 1) || (!bool)) {
        break label334;
      }
      localObject = this.oWG;
      if (localObject == null) {
        break label328;
      }
      if (((b)localObject).chO()) {
        break label334;
      }
      localObject = this.oWG;
      if (localObject != null) {
        ((b)localObject).jP(true);
      }
      localObject = this.oWG;
      if (localObject != null) {
        ((b)localObject).By(System.currentTimeMillis());
      }
      localObject = this.OFl;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).gRJ();
        if (localObject != null)
        {
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject != null) {
            ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
          }
        }
      }
      long l = System.currentTimeMillis();
      localObject = this.oWG;
      if (localObject == null) {
        break label334;
      }
      ((b)localObject).a(l, (b.a)new w.b(i, bool, l));
      AppMethodBeat.o(180124);
      return;
      i = 0;
      break;
    }
    label328:
    AppMethodBeat.o(180124);
    return;
    label334:
    AppMethodBeat.o(180124);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(180125);
    super.cFy();
    b localb = this.oWG;
    if (localb != null) {
      localb.jR(false);
    }
    localb = this.oWG;
    if (localb != null)
    {
      localb.chW();
      AppMethodBeat.o(180125);
      return;
    }
    AppMethodBeat.o(180125);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(180123);
    super.gOK();
    ChatFooter localChatFooter = this.Ppy;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.Ppy = null;
    AppMethodBeat.o(180123);
  }
  
  public final void kE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(180127);
    Log.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Ppz), Integer.valueOf(this.PpA) });
    Object localObject = this.Ppy;
    int i;
    boolean bool1;
    label75:
    boolean bool2;
    label114:
    int j;
    label122:
    long l;
    if (localObject != null)
    {
      i = ((ChatFooter)localObject).getBarGroupHeight();
      if (paramInt1 != 1) {
        break label254;
      }
      bool1 = true;
      if ((paramInt1 != 0) || (this.Ppz == 0) || (this.Ppz == -1)) {
        break label266;
      }
      localObject = this.oWG;
      if (localObject == null) {
        break label260;
      }
      bool2 = ((b)localObject).chN();
      if (!bool2) {
        break label266;
      }
      j = 1;
      if ((j == 0) || (paramInt1 != 0)) {
        break label304;
      }
      if (this.Ppz != 1) {
        break label272;
      }
      l = 200L;
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch delay: %d", new Object[] { Long.valueOf(l) });
      localObject = this.oWG;
      if (localObject != null) {
        ((b)localObject).a(paramInt2, i, bool1, l);
      }
      this.Ppz = paramInt1;
      this.PpA = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = this.dom;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).getContext();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getResources();
          if (localObject != null)
          {
            i = ((Resources)localObject).getDimensionPixelSize(2131165310);
            break;
          }
        }
      }
      i = 0;
      break;
      label254:
      bool1 = false;
      break label75;
      label260:
      bool2 = false;
      break label114;
      label266:
      j = 0;
      break label122;
      label272:
      if (this.Ppz == 3) {
        l = 300L;
      } else if (this.Ppz == 2) {
        l = 350L;
      } else {
        label304:
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.w
 * JD-Core Version:    0.7.0.1
 */