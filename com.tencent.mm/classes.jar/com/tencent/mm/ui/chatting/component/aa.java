package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.w;
import kotlin.Metadata;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=w.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "needDelay", "", "needShowFloatBall", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends a
  implements ChatFooter.f, w
{
  public static final aa.a aerY;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  private ChatFooter aerZ;
  private int aesa = -1;
  private int aesb = -1;
  private b vjX;
  
  static
  {
    AppMethodBeat.i(180128);
    aerY = new aa.a((byte)0);
    AppMethodBeat.o(180128);
  }
  
  private static final void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(255839);
    Log.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.ball.c.a locala = (com.tencent.mm.plugin.ball.c.a)h.ax(com.tencent.mm.plugin.ball.c.a.class);
    if (locala != null) {
      locala.x(paramLong, paramInt2);
    }
    AppMethodBeat.o(255839);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180122);
    super.a(parama);
    this.adCQ = parama;
    this.vjX = ((b)h.ax(b.class));
    AppMethodBeat.o(180122);
  }
  
  public final void bL(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(180126);
    this.aerZ = paramChatFooter;
    paramChatFooter = this.aerZ;
    if (paramChatFooter != null) {
      paramChatFooter.setOnFooterPanelSwitchListener((ChatFooter.f)this);
    }
    AppMethodBeat.o(180126);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(180124);
    super.jji();
    Object localObject = this.vjX;
    if (localObject != null) {
      ((b)localObject).mp(true);
    }
    localObject = this.vjX;
    if (localObject != null) {
      ((b)localObject).cXT();
    }
    localObject = this.adCQ;
    int i;
    boolean bool;
    if (localObject == null)
    {
      i = 0;
      localObject = this.adCQ;
      if (localObject != null) {
        break label314;
      }
      bool = false;
      label72:
      localObject = this.vjX;
      if ((localObject == null) || (((b)localObject).cXI() != true)) {
        break label360;
      }
      j = 1;
      label96:
      if (j != 0) {
        Log.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
      }
      if ((i == 1) && (bool))
      {
        localObject = this.vjX;
        if ((localObject == null) || (((b)localObject).cXI())) {
          break label365;
        }
      }
    }
    label314:
    label360:
    label365:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localObject = this.vjX;
        if (localObject != null) {
          ((b)localObject).mm(true);
        }
        localObject = this.vjX;
        if (localObject != null) {
          ((b)localObject).kc(System.currentTimeMillis());
        }
        localObject = this.adCQ;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO;
          if (localObject != null)
          {
            localObject = ((MMFragment)localObject).getArguments();
            if (localObject != null) {
              ((Bundle)localObject).putBoolean("key_can_show_message_float_ball", false);
            }
          }
        }
        long l = System.currentTimeMillis();
        localObject = this.vjX;
        if (localObject != null) {
          ((b)localObject).a(l, new aa..ExternalSyntheticLambda0(i, bool, l));
        }
      }
      AppMethodBeat.o(180124);
      return;
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      localObject = ((MMFragment)localObject).getArguments();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((Bundle)localObject).getInt("chat_from_scene", 0);
      break;
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO;
      if (localObject == null)
      {
        bool = false;
        break label72;
      }
      localObject = ((MMFragment)localObject).getArguments();
      if (localObject == null)
      {
        bool = false;
        break label72;
      }
      bool = ((Bundle)localObject).getBoolean("key_can_show_message_float_ball", false);
      break label72;
      j = 0;
      break label96;
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(180125);
    super.jjj();
    b localb = this.vjX;
    if (localb != null) {
      localb.mp(false);
    }
    localb = this.vjX;
    if (localb != null) {
      localb.cXS();
    }
    AppMethodBeat.o(180125);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(180123);
    super.jqF();
    ChatFooter localChatFooter = this.aerZ;
    if (localChatFooter != null) {
      localChatFooter.setOnFooterPanelSwitchListener(null);
    }
    this.aerZ = null;
    AppMethodBeat.o(180123);
  }
  
  public final void nM(int paramInt1, int paramInt2)
  {
    int k = 0;
    AppMethodBeat.i(180127);
    Log.d("MicroMsg.FloatBallComponent", "alvinluo onFooterPanelSwitch panelType: %d, panelHeight: %d, last: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aesa), Integer.valueOf(this.aesb) });
    Object localObject = this.aerZ;
    int i;
    label85:
    boolean bool1;
    label93:
    boolean bool2;
    label138:
    long l;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label274;
      }
      localObject = this.hlc;
      if (localObject != null) {
        break label225;
      }
      i = 0;
      if (paramInt1 != 1) {
        break label283;
      }
      bool1 = true;
      int j = k;
      if (paramInt1 == 0)
      {
        j = k;
        if (this.aesa != 0)
        {
          j = k;
          if (this.aesa != -1)
          {
            localObject = this.vjX;
            if (localObject != null) {
              break label289;
            }
            bool2 = false;
            j = k;
            if (bool2) {
              j = 1;
            }
          }
        }
      }
      if ((j == 0) || (paramInt1 != 0)) {
        break label333;
      }
      if (this.aesa != 1) {
        break label301;
      }
      l = 200L;
    }
    for (;;)
    {
      localObject = this.vjX;
      if (localObject != null) {
        ((b)localObject).a(paramInt2, i, bool1, l);
      }
      this.aesa = paramInt1;
      this.aesb = paramInt2;
      AppMethodBeat.o(180127);
      return;
      localObject = Integer.valueOf(((ChatFooter)localObject).getBarGroupHeight());
      break;
      label225:
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO.getContext();
      if (localObject == null)
      {
        i = 0;
        break label85;
      }
      localObject = ((Activity)localObject).getResources();
      if (localObject == null)
      {
        i = 0;
        break label85;
      }
      i = ((Resources)localObject).getDimensionPixelSize(R.f.Edge_7A);
      break label85;
      label274:
      i = ((Integer)localObject).intValue();
      break label85;
      label283:
      bool1 = false;
      break label93;
      label289:
      bool2 = ((b)localObject).cXH();
      break label138;
      label301:
      if (this.aesa == 3) {
        l = 300L;
      } else if (this.aesa == 2) {
        l = 350L;
      } else {
        label333:
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.aa
 * JD-Core Version:    0.7.0.1
 */