package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ac$11
  implements View.OnClickListener
{
  ac$11(ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179867);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
    localObject = new Intent(this.Prh.dom.Pwc.getContext(), GroupToolsManagereUI.class);
    ((Intent)localObject).putExtra("key_chatroomname", this.Prh.dom.getTalkerUserName());
    ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", ac.e(this.Prh));
    paramView = this.Prh.dom.Pwc.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ac.f(this.Prh).alive();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac.11
 * JD-Core Version:    0.7.0.1
 */