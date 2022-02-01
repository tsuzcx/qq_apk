package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/ChattingPermissionComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "()V", "TAG", "", "count", "", "getCount", "()I", "setCount", "(I)V", "mContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "getMContext", "()Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "setMContext", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "onChattingEnterAnimStart", "", "onChattingExitAnimStart", "onComponentInstall", "context", "onComponentUnInstall", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
  implements aj
{
  private final String TAG = "ChattingPermissionComponent";
  private com.tencent.mm.ui.chatting.d.a aeeK;
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256142);
    super.a(parama);
    this.aeeK = parama;
    AppMethodBeat.o(256142);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256160);
    super.jjg();
    Log.i(this.TAG, "[onChattingEnterAnimStart]");
    Object localObject = this.aeeK;
    if (localObject == null) {}
    for (localObject = null; ab.IS((String)localObject); localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).getTalkerUserName())
    {
      ((d)h.az(d.class)).markEnterBusiness(".ui.chatting.ChattingBizView");
      AppMethodBeat.o(256160);
      return;
    }
    ((d)h.az(d.class)).markEnterBusiness(".ui.chatting.ChattingView");
    AppMethodBeat.o(256160);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(256153);
    super.jjk();
    Log.i(this.TAG, "[onChattingExitAnimStart]");
    Object localObject = this.aeeK;
    if (localObject == null) {}
    for (localObject = null; ab.IS((String)localObject); localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).getTalkerUserName())
    {
      ((d)h.az(d.class)).markExitBusiness(".ui.chatting.ChattingBizView");
      AppMethodBeat.o(256153);
      return;
    }
    ((d)h.az(d.class)).markExitBusiness(".ui.chatting.ChattingView");
    AppMethodBeat.o(256153);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256146);
    super.jqF();
    this.aeeK = null;
    AppMethodBeat.o(256146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.q
 * JD-Core Version:    0.7.0.1
 */