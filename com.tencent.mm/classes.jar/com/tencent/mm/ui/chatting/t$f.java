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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class t$f
  implements MMTextView.b
{
  private boolean BDi;
  int EqT;
  private MMTextView JWB;
  private TextView JWC;
  private final int JWD;
  private int JWE;
  private int JWF;
  private com.tencent.mm.ui.chatting.e.a JWz;
  aq handler;
  private View.OnTouchListener jlJ;
  private o jwx;
  private ScrollView kOy;
  private long xAM;
  boolean yFz;
  
  public t$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34596);
    this.JWz = null;
    this.jwx = null;
    this.JWB = null;
    this.JWC = null;
    this.kOy = null;
    this.xAM = 0L;
    this.JWD = 3;
    this.JWE = 0;
    this.EqT = 0;
    this.JWF = 0;
    this.yFz = false;
    this.BDi = false;
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (t.f.this.EqT != paramAnonymousMessage.getScrollY())
        {
          t.f.this.yFz = true;
          t.f.this.handler.sendMessageDelayed(t.f.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          t.f.this.EqT = paramAnonymousMessage.getScrollY();
          AppMethodBeat.o(34595);
          return;
        }
        t.f.this.yFz = false;
        AppMethodBeat.o(34595);
      }
    };
    this.jlJ = null;
    this.JWz = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean gj(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bk))
    {
      localObject = (bk)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bk)localObject).dCi != null) && (this.JWz != null)) {
        if (!(paramView instanceof TextView)) {
          break label187;
        }
      }
    }
    label187:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.JWz.Kkd.getContext();
      localObject = ((bk)localObject).dCi;
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((ei)localObject).field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramView.ahE(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.kk(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.f
 * JD-Core Version:    0.7.0.1
 */