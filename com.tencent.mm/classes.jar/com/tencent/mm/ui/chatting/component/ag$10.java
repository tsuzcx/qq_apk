package com.tencent.mm.ui.chatting.component;

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

final class ag$10
  implements View.OnClickListener
{
  ag$10(ag paramag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179867);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
    localObject = new Intent(this.aetG.hlc.aezO.getContext(), GroupToolsManagereUI.class);
    ((Intent)localObject).putExtra("key_chatroomname", this.aetG.hlc.getTalkerUserName());
    ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", ag.e(this.aetG));
    paramView = this.aetG.hlc.aezO.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ag.f(this.aetG).alive();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ag.10
 * JD-Core Version:    0.7.0.1
 */