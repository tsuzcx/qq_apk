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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class s$f
  implements MMTextView.b
{
  private boolean BlJ;
  int DYR;
  private com.tencent.mm.ui.chatting.e.a JBI;
  private MMTextView JBK;
  private TextView JBL;
  private final int JBM;
  private int JBN;
  private int JBO;
  ap handler;
  private View.OnTouchListener jiQ;
  private o jtC;
  private ScrollView kLj;
  private long xkP;
  boolean ypA;
  
  public s$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34596);
    this.JBI = null;
    this.jtC = null;
    this.JBK = null;
    this.JBL = null;
    this.kLj = null;
    this.xkP = 0L;
    this.JBM = 3;
    this.JBN = 0;
    this.DYR = 0;
    this.JBO = 0;
    this.ypA = false;
    this.BlJ = false;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (s.f.this.DYR != paramAnonymousMessage.getScrollY())
        {
          s.f.this.ypA = true;
          s.f.this.handler.sendMessageDelayed(s.f.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          s.f.this.DYR = paramAnonymousMessage.getScrollY();
          AppMethodBeat.o(34595);
          return;
        }
        s.f.this.ypA = false;
        AppMethodBeat.o(34595);
      }
    };
    this.jiQ = null;
    this.JBI = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean gk(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bk))
    {
      localObject = (bk)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bk)localObject).dBd != null) && (this.JBI != null)) {
        if (!(paramView instanceof TextView)) {
          break label187;
        }
      }
    }
    label187:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.JBI.JOR.getContext();
      localObject = ((bk)localObject).dBd;
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((ei)localObject).field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramView.ahp(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.kd(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.f
 * JD-Core Version:    0.7.0.1
 */