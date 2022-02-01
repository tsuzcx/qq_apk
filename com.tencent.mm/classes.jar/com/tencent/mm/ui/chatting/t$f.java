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
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class t$f
  implements MMTextView.b
{
  private long BAN;
  boolean CJo;
  private boolean FNV;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private MMTextView PhP;
  private TextView PhQ;
  private final int PhR;
  private int PhS;
  private int PhT;
  MMHandler handler;
  private View.OnTouchListener kjS;
  private p kuK;
  private ScrollView lTw;
  int wqz;
  
  public t$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34596);
    this.PhN = null;
    this.kuK = null;
    this.PhP = null;
    this.PhQ = null;
    this.lTw = null;
    this.BAN = 0L;
    this.PhR = 3;
    this.PhS = 0;
    this.wqz = 0;
    this.PhT = 0;
    this.CJo = false;
    this.FNV = false;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (t.f.this.wqz != paramAnonymousMessage.getScrollY())
        {
          t.f.this.CJo = true;
          t.f.this.handler.sendMessageDelayed(t.f.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          t.f.this.wqz = paramAnonymousMessage.getScrollY();
          AppMethodBeat.o(34595);
          return;
        }
        t.f.this.CJo = false;
        AppMethodBeat.o(34595);
      }
    };
    this.kjS = null;
    this.PhN = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean gB(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bq))
    {
      localObject = (bq)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bq)localObject).dTX != null) && (this.PhN != null)) {
        if (!(paramView instanceof TextView)) {
          break label210;
        }
      }
    }
    label210:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.PhN.Pwc.getContext();
      localObject = ((bq)localObject).dTX;
      boolean bool = this.PhN.gRM();
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((eo)localObject).field_msgId);
      localIntent.putExtra("is_group_chat", bool);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramView.axQ(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.kc(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.f
 * JD-Core Version:    0.7.0.1
 */