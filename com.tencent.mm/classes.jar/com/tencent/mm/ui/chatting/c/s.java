package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.ui.chatting.c.b.p;
import d.l;

@com.tencent.mm.ui.chatting.c.a.a(eYT=p.class)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "isVoipFloatBallShowing", "", "needDelay", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
public final class s
  extends a
  implements ChatFooter.f, p
{
  public static final a Guy;
  private com.tencent.mm.ui.chatting.d.a Guu;
  private ChatFooter Guv;
  private int Guw = -1;
  private int Gux = -1;
  private c mDJ;
  
  static
  {
    AppMethodBeat.i(180128);
    Guy = new a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.Guu = parama;
    this.mDJ = ((c)g.ab(c.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bw(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.Guv = paramChatFooter;
    paramChatFooter = this.Guv;
    if (paramChatFooter != null)
    {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
      AppMethodBeat.o(180126);
      return;
    }
    AppMethodBeat.o(180126);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(180124);
    super.eQD();
    Object localObject = this.mDJ;
    if (localObject != null) {
      ((c)localObject).il(true);
    }
    localObject = this.mDJ;
    if (localObject != null) {
      ((c)localObject).byZ();
    }
    localObject = this.Guu;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).eYY();
      if (localObject != null)
      {
        localObject = ((MMFragment)localObject).getArguments();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("chat_from_scene", 0);
          localObject = this.Guu;
          if (localObject == null) {
            break label323;
          }
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).eYY();
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
      localObject = this.mDJ;
      if ((localObject != null) && (((c)localObject).byR() == true)) {
        ad.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i != 1) || (!bool)) {
        break label334;
      }
      localObject = this.mDJ;
      if (localObject == null) {
        break label328;
      }
      if (((c)localObject).byR()) {
        break label334;
      }
      localObject = this.mDJ;
      if (localObject != null) {
        ((c)localObject).ii(true);
      }
      localObject = this.mDJ;
      if (localObject != null) {
        ((c)localObject).nt(System.currentTimeMillis());
      }
      localObject = this.Guu;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).eYY();
        if (localObject != null)
        {
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject != null) {
            ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
          }
        }
      }
      final long l = System.currentTimeMillis();
      localObject = this.mDJ;
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
  
  public final void eQE()
  {
    AppMethodBeat.i(180125);
    super.eQE();
    c localc = this.mDJ;
    if (localc != null) {
      localc.il(false);
    }
    localc = this.mDJ;
    if (localc != null)
    {
      localc.byY();
      AppMethodBeat.o(180125);
      return;
    }
    AppMethodBeat.o(180125);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(180123);
    super.eWx();
    ChatFooter localChatFooter = this.Guv;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.Guv = null;
    AppMethodBeat.o(180123);
  }
  
  public final void iP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(180127);
    ad.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Guw), Integer.valueOf(this.Gux) });
    Object localObject = this.Guv;
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
      if ((paramInt1 != 0) || (this.Guw == 0) || (this.Guw == -1)) {
        break label268;
      }
      localObject = this.mDJ;
      if (localObject == null) {
        break label262;
      }
      bool2 = ((c)localObject).wu(9);
      if (!bool2) {
        break label268;
      }
      j = 1;
      if ((j == 0) || (paramInt1 != 0)) {
        break label306;
      }
      if (this.Guw != 1) {
        break label274;
      }
      l = 200L;
    }
    for (;;)
    {
      ad.i("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch delay: %d", new Object[] { Long.valueOf(l) });
      localObject = this.mDJ;
      if (localObject != null) {
        ((c)localObject).a(paramInt2, i, bool1, l);
      }
      this.Guw = paramInt1;
      this.Gux = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = this.cOd;
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
      if (this.Guw == 3) {
        l = 300L;
      } else if (this.Guw == 2) {
        l = 350L;
      } else {
        label306:
        l = 0L;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "", "onAddResult"})
  static final class b
    implements c.a
  {
    b(int paramInt, boolean paramBoolean, long paramLong) {}
    
    public final void wx(int paramInt)
    {
      AppMethodBeat.i(191885);
      ad.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(this.Guz), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      b localb = (b)g.ab(b.class);
      if (localb != null) {
        localb.m(l, paramInt);
      }
      AppMethodBeat.o(191885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s
 * JD-Core Version:    0.7.0.1
 */