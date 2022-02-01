package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.r;
import d.l;

@com.tencent.mm.ui.chatting.d.a.a(fFo=r.class)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "isVoipFloatBallShowing", "", "needDelay", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
public final class u
  extends a
  implements ChatFooter.f, r
{
  public static final u.a JIO;
  private ChatFooter JIL;
  private int JIM = -1;
  private int JIN = -1;
  private com.tencent.mm.ui.chatting.e.a Jaj;
  private c nGl;
  
  static
  {
    AppMethodBeat.i(180128);
    JIO = new u.a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.Jaj = parama;
    this.nGl = ((c)g.ab(c.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bA(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.JIL = paramChatFooter;
    paramChatFooter = this.JIL;
    if (paramChatFooter != null)
    {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
      AppMethodBeat.o(180126);
      return;
    }
    AppMethodBeat.o(180126);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(180123);
    super.fCC();
    ChatFooter localChatFooter = this.JIL;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.JIL = null;
    AppMethodBeat.o(180123);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(180124);
    super.fwv();
    Object localObject = this.nGl;
    if (localObject != null) {
      ((c)localObject).iU(true);
    }
    localObject = this.nGl;
    if (localObject != null) {
      ((c)localObject).bKf();
    }
    localObject = this.Jaj;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).fFs();
      if (localObject != null)
      {
        localObject = ((MMFragment)localObject).getArguments();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("chat_from_scene", 0);
          localObject = this.Jaj;
          if (localObject == null) {
            break label323;
          }
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).fFs();
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
    for (final boolean bool = ((Bundle)localObject).getBoolean("key_can_show_message_float_ball", false);; bool = false)
    {
      localObject = this.nGl;
      if ((localObject != null) && (((c)localObject).bJX() == true)) {
        ad.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i != 1) || (!bool)) {
        break label334;
      }
      localObject = this.nGl;
      if (localObject == null) {
        break label328;
      }
      if (((c)localObject).bJX()) {
        break label334;
      }
      localObject = this.nGl;
      if (localObject != null) {
        ((c)localObject).iR(true);
      }
      localObject = this.nGl;
      if (localObject != null) {
        ((c)localObject).te(System.currentTimeMillis());
      }
      localObject = this.Jaj;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).fFs();
        if (localObject != null)
        {
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject != null) {
            ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
          }
        }
      }
      final long l = System.currentTimeMillis();
      localObject = this.nGl;
      if (localObject == null) {
        break label334;
      }
      ((c)localObject).a(l, (c.a)new b(i, bool, l));
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
  
  public final void fww()
  {
    AppMethodBeat.i(180125);
    super.fww();
    c localc = this.nGl;
    if (localc != null) {
      localc.iU(false);
    }
    localc = this.nGl;
    if (localc != null)
    {
      localc.bKe();
      AppMethodBeat.o(180125);
      return;
    }
    AppMethodBeat.o(180125);
  }
  
  public final void jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(180127);
    ad.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.JIM), Integer.valueOf(this.JIN) });
    Object localObject = this.JIL;
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
      if ((paramInt1 != 0) || (this.JIM == 0) || (this.JIM == -1)) {
        break label268;
      }
      localObject = this.nGl;
      if (localObject == null) {
        break label262;
      }
      bool2 = ((c)localObject).xS(9);
      if (!bool2) {
        break label268;
      }
      j = 1;
      if ((j == 0) || (paramInt1 != 0)) {
        break label306;
      }
      if (this.JIM != 1) {
        break label274;
      }
      l = 200L;
    }
    for (;;)
    {
      ad.i("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch delay: %d", new Object[] { Long.valueOf(l) });
      localObject = this.nGl;
      if (localObject != null) {
        ((c)localObject).a(paramInt2, i, bool1, l);
      }
      this.JIM = paramInt1;
      this.JIN = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = this.cWM;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).getContext();
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
      if (this.JIM == 3) {
        l = 300L;
      } else if (this.JIM == 2) {
        l = 350L;
      } else {
        label306:
        l = 0L;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "onAddResult"})
  static final class b
    implements c.a
  {
    b(int paramInt, boolean paramBoolean, long paramLong) {}
    
    public final void xV(int paramInt)
    {
      AppMethodBeat.i(194863);
      ad.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(this.nWA), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      b localb = (b)g.ab(b.class);
      if (localb != null) {
        localb.n(l, paramInt);
      }
      AppMethodBeat.o(194863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.u
 * JD-Core Version:    0.7.0.1
 */