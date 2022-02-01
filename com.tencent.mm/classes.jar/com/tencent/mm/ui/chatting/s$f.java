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
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bj;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class s$f
  implements MMTextView.b
{
  int Cvk;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private MMTextView HNV;
  private TextView HNW;
  private final int HNX;
  private int HNY;
  private int HNZ;
  ao handler;
  private View.OnTouchListener iPI;
  private o jat;
  private ScrollView kqh;
  private long wdg;
  boolean xby;
  private boolean zUf;
  
  public s$f(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34596);
    this.HNS = null;
    this.jat = null;
    this.HNV = null;
    this.HNW = null;
    this.kqh = null;
    this.wdg = 0L;
    this.HNX = 3;
    this.HNY = 0;
    this.Cvk = 0;
    this.HNZ = 0;
    this.xby = false;
    this.zUf = false;
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (s.f.this.Cvk != paramAnonymousMessage.getScrollY())
        {
          s.f.this.xby = true;
          s.f.this.handler.sendMessageDelayed(s.f.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          s.f.this.Cvk = paramAnonymousMessage.getScrollY();
          AppMethodBeat.o(34595);
          return;
        }
        s.f.this.xby = false;
        AppMethodBeat.o(34595);
      }
    };
    this.iPI = null;
    this.HNS = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean fV(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bj))
    {
      localObject = (bj)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bj)localObject).dpq != null) && (this.HNS != null)) {
        if (!(paramView instanceof TextView)) {
          break label187;
        }
      }
    }
    label187:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.HNS.HZF.getContext();
      localObject = ((bj)localObject).dpq;
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((dy)localObject).field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramView.aeD(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.jS(localActivity);
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