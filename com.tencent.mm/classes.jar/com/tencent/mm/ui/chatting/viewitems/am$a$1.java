package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$a$1
  implements View.OnClickListener
{
  am$a$1(am.a parama, am.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33285);
    Intent localIntent = new Intent(paramView.getContext(), TextPreviewUI.class);
    localIntent.addFlags(67108864);
    az localaz = (az)this.zWZ.zXe.getTag();
    if (localaz != null)
    {
      CharSequence localCharSequence = this.zWZ.zXe.dTB();
      localIntent.putExtra("Chat_Msg_Id", localaz.cEE.field_msgId);
      localIntent.putExtra("key_chat_text", localCharSequence);
      paramView.getContext().startActivity(localIntent);
      b.jdMethod_if(paramView.getContext());
    }
    AppMethodBeat.o(33285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.1
 * JD-Core Version:    0.7.0.1
 */