package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.t;
import kotlin.l;

@com.tencent.mm.ui.chatting.d.a.a(hRc=t.class)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "needDelay", "", "needShowFloatBall", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
public final class x
  extends a
  implements ChatFooter.f, t
{
  public static final x.a WJW;
  private com.tencent.mm.ui.chatting.e.a VYv;
  private ChatFooter WJT;
  private int WJU = -1;
  private int WJV = -1;
  private b rYG;
  
  static
  {
    AppMethodBeat.i(180128);
    WJW = new x.a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.VYv = parama;
    this.rYG = ((b)h.ae(b.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bD(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.WJT = paramChatFooter;
    paramChatFooter = this.WJT;
    if (paramChatFooter != null)
    {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
      AppMethodBeat.o(180126);
      return;
    }
    AppMethodBeat.o(180126);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(180124);
    super.hGX();
    Object localObject = this.rYG;
    if (localObject != null) {
      ((b)localObject).lc(true);
    }
    localObject = this.rYG;
    if (localObject != null) {
      ((b)localObject).cvj();
    }
    localObject = this.VYv;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).hRf();
      if (localObject != null)
      {
        localObject = ((MMFragment)localObject).getArguments();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("chat_from_scene", 0);
          localObject = this.VYv;
          if (localObject == null) {
            break label323;
          }
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).hRf();
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
      localObject = this.rYG;
      if ((localObject != null) && (((b)localObject).cuY() == true)) {
        Log.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i != 1) || (!bool)) {
        break label334;
      }
      localObject = this.rYG;
      if (localObject == null) {
        break label328;
      }
      if (((b)localObject).cuY()) {
        break label334;
      }
      localObject = this.rYG;
      if (localObject != null) {
        ((b)localObject).kZ(true);
      }
      localObject = this.rYG;
      if (localObject != null) {
        ((b)localObject).HL(System.currentTimeMillis());
      }
      localObject = this.VYv;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).hRf();
        if (localObject != null)
        {
          localObject = ((MMFragment)localObject).getArguments();
          if (localObject != null) {
            ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
          }
        }
      }
      final long l = System.currentTimeMillis();
      localObject = this.rYG;
      if (localObject == null) {
        break label334;
      }
      ((b)localObject).a(l, (b.a)new b(i, bool, l));
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
  
  public final void hGY()
  {
    AppMethodBeat.i(180125);
    super.hGY();
    b localb = this.rYG;
    if (localb != null) {
      localb.lc(false);
    }
    localb = this.rYG;
    if (localb != null)
    {
      localb.cvi();
      AppMethodBeat.o(180125);
      return;
    }
    AppMethodBeat.o(180125);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(180123);
    super.hNZ();
    ChatFooter localChatFooter = this.WJT;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.WJT = null;
    AppMethodBeat.o(180123);
  }
  
  public final void lX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(180127);
    Log.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.WJU), Integer.valueOf(this.WJV) });
    Object localObject = this.WJT;
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
        break label255;
      }
      bool1 = true;
      if ((paramInt1 != 0) || (this.WJU == 0) || (this.WJU == -1)) {
        break label267;
      }
      localObject = this.rYG;
      if (localObject == null) {
        break label261;
      }
      bool2 = ((b)localObject).cuX();
      if (!bool2) {
        break label267;
      }
      j = 1;
      if ((j == 0) || (paramInt1 != 0)) {
        break label305;
      }
      if (this.WJU != 1) {
        break label273;
      }
      l = 200L;
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch delay: %d", new Object[] { Long.valueOf(l) });
      localObject = this.rYG;
      if (localObject != null) {
        ((b)localObject).a(paramInt2, i, bool1, l);
      }
      this.WJU = paramInt1;
      this.WJV = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = this.fgR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).getContext();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getResources();
          if (localObject != null)
          {
            i = ((Resources)localObject).getDimensionPixelSize(R.f.Edge_7A);
            break;
          }
        }
      }
      i = 0;
      break;
      label255:
      bool1 = false;
      break label75;
      label261:
      bool2 = false;
      break label114;
      label267:
      j = 0;
      break label122;
      label273:
      if (this.WJU == 3) {
        l = 300L;
      } else if (this.WJU == 2) {
        l = 350L;
      } else {
        label305:
        l = 0L;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "onAddResult"})
  static final class b
    implements b.a
  {
    b(int paramInt, boolean paramBoolean, long paramLong) {}
    
    public final void Ff(int paramInt)
    {
      AppMethodBeat.i(275554);
      Log.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(this.swd), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.ball.c.a locala = (com.tencent.mm.plugin.ball.c.a)h.ae(com.tencent.mm.plugin.ball.c.a.class);
      if (locala != null) {
        locala.o(l, paramInt);
      }
      AppMethodBeat.o(275554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.x
 * JD-Core Version:    0.7.0.1
 */