package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.viewitems.bz;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class v$f
  implements MMTextView.b
{
  private int EHM;
  private long NtR;
  private boolean OXq;
  private boolean SJs;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private MMTextView aeiM;
  private TextView aeiN;
  private final int aeiO;
  private int aeiP;
  private int aeiQ;
  private MMHandler handler;
  private ScrollView pLK;
  private View.OnTouchListener pYP;
  private v qjH;
  
  public v$f(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34596);
    this.aeiK = null;
    this.qjH = null;
    this.aeiM = null;
    this.aeiN = null;
    this.pLK = null;
    this.NtR = 0L;
    this.aeiO = 3;
    this.aeiP = 0;
    this.EHM = 0;
    this.aeiQ = 0;
    this.OXq = false;
    this.SJs = false;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (v.f.a(v.f.this) != paramAnonymousMessage.getScrollY())
        {
          v.f.a(v.f.this, true);
          v.f.b(v.f.this).sendMessageDelayed(v.f.b(v.f.this).obtainMessage(0, paramAnonymousMessage), 5L);
          v.f.a(v.f.this, paramAnonymousMessage.getScrollY());
          AppMethodBeat.o(34595);
          return;
        }
        v.f.a(v.f.this, false);
        AppMethodBeat.o(34595);
      }
    };
    this.pYP = null;
    this.aeiK = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean lj(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bz))
    {
      localObject = (bz)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bz)localObject).hTm != null) && (this.aeiK != null)) {
        if (!(paramView instanceof TextView)) {
          break label210;
        }
      }
    }
    label210:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.aeiK.aezO.getContext();
      localObject = ((bz)localObject).hTm;
      boolean bool = this.aeiK.juG();
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((fi)localObject).field_msgId);
      localIntent.putExtra("is_group_chat", bool);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramView.aYi(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.ne(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.f
 * JD-Core Version:    0.7.0.1
 */