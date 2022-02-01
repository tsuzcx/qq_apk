package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.p;
import d.l;

@com.tencent.mm.ui.chatting.c.a.a(foJ=p.class)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "isVoipFloatBallShowing", "", "needDelay", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
public final class s
  extends a
  implements ChatFooter.f, p
{
  public static final s.a HUq;
  private ChatFooter HUn;
  private int HUo = -1;
  private int HUp = -1;
  private com.tencent.mm.ui.chatting.d.a HmD;
  private c nfP;
  
  static
  {
    AppMethodBeat.i(180128);
    HUq = new s.a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.HmD = parama;
    this.nfP = ((c)g.ab(c.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bw(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.HUn = paramChatFooter;
    paramChatFooter = this.HUn;
    if (paramChatFooter != null)
    {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
      AppMethodBeat.o(180126);
      return;
    }
    AppMethodBeat.o(180126);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(180124);
    super.fgj();
    Object localObject = this.nfP;
    if (localObject != null) {
      ((c)localObject).iL(true);
    }
    localObject = this.nfP;
    if (localObject != null) {
      ((c)localObject).bFV();
    }
    localObject = this.HmD;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).foN();
      if (localObject != null)
      {
        localObject = ((MMFragment)localObject).getArguments();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("chat_from_scene", 0);
          localObject = this.HmD;
          if (localObject == null) {
            break label323;
          }
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).foN();
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
      localObject = this.nfP;
      if ((localObject != null) && (((c)localObject).bFN() == true)) {
        ac.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i != 1) || (!bool)) {
        break label334;
      }
      localObject = this.nfP;
      if (localObject == null) {
        break label328;
      }
      if (((c)localObject).bFN()) {
        break label334;
      }
      localObject = this.nfP;
      if (localObject != null) {
        ((c)localObject).iI(true);
      }
      localObject = this.nfP;
      if (localObject != null) {
        ((c)localObject).rf(System.currentTimeMillis());
      }
      localObject = this.HmD;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).foN();
        if (localObject != null)
        {
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject != null) {
            ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
          }
        }
      }
      long l = System.currentTimeMillis();
      localObject = this.nfP;
      if (localObject == null) {
        break label334;
      }
      ((c)localObject).a(l, (c.a)new s.b(i, bool, l));
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
  
  public final void fgk()
  {
    AppMethodBeat.i(180125);
    super.fgk();
    c localc = this.nfP;
    if (localc != null) {
      localc.iL(false);
    }
    localc = this.nfP;
    if (localc != null)
    {
      localc.bFU();
      AppMethodBeat.o(180125);
      return;
    }
    AppMethodBeat.o(180125);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(180123);
    super.fmj();
    ChatFooter localChatFooter = this.HUn;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.HUn = null;
    AppMethodBeat.o(180123);
  }
  
  public final void jc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(180127);
    ac.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.HUo), Integer.valueOf(this.HUp) });
    Object localObject = this.HUn;
    int i;
    boolean bool1;
    label75:
    boolean bool2;
    label116:
    int j;
    label124:
    long l;
    if (localObject != null)
    {
      i = ((ChatFooter)localObject).getBarGroupHeight();
      if (paramInt1 != 1) {
        break label256;
      }
      bool1 = true;
      if ((paramInt1 != 0) || (this.HUo == 0) || (this.HUo == -1)) {
        break label268;
      }
      localObject = this.nfP;
      if (localObject == null) {
        break label262;
      }
      bool2 = ((c)localObject).xm(9);
      if (!bool2) {
        break label268;
      }
      j = 1;
      if ((j == 0) || (paramInt1 != 0)) {
        break label306;
      }
      if (this.HUo != 1) {
        break label274;
      }
      l = 200L;
    }
    for (;;)
    {
      ac.i("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch delay: %d", new Object[] { Long.valueOf(l) });
      localObject = this.nfP;
      if (localObject != null) {
        ((c)localObject).a(paramInt2, i, bool1, l);
      }
      this.HUo = paramInt1;
      this.HUp = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = this.cLy;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).getContext();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getResources();
          if (localObject != null)
          {
            i = ((Resources)localObject).getDimensionPixelSize(2131165299);
            break;
          }
        }
      }
      i = 0;
      break;
      label256:
      bool1 = false;
      break label75;
      label262:
      bool2 = false;
      break label116;
      label268:
      j = 0;
      break label124;
      label274:
      if (this.HUo == 3) {
        l = 300L;
      } else if (this.HUo == 2) {
        l = 350L;
      } else {
        label306:
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s
 * JD-Core Version:    0.7.0.1
 */