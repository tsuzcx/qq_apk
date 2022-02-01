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
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bi;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class s$f
  implements MMTextView.b
{
  int BcY;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private MMTextView Goe;
  private TextView Gof;
  private final int Gog;
  private int Goh;
  private int Goi;
  ap handler;
  private o iAs;
  private View.OnTouchListener ipB;
  private ScrollView jPx;
  private long uUr;
  boolean vQQ;
  private boolean yGR;
  
  public s$f(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34596);
    this.Gob = null;
    this.iAs = null;
    this.Goe = null;
    this.Gof = null;
    this.jPx = null;
    this.uUr = 0L;
    this.Gog = 3;
    this.Goh = 0;
    this.BcY = 0;
    this.Goi = 0;
    this.vQQ = false;
    this.yGR = false;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (s.f.this.BcY != paramAnonymousMessage.getScrollY())
        {
          s.f.this.vQQ = true;
          s.f.this.handler.sendMessageDelayed(s.f.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          s.f.this.BcY = paramAnonymousMessage.getScrollY();
          AppMethodBeat.o(34595);
          return;
        }
        s.f.this.vQQ = false;
        AppMethodBeat.o(34595);
      }
    };
    this.ipB = null;
    this.Gob = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean fI(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof bi))
    {
      localObject = (bi)paramView.getTag();
      if (((paramView instanceof TextView)) && (((bi)localObject).drF != null) && (this.Gob != null)) {
        if (!(paramView instanceof TextView)) {
          break label187;
        }
      }
    }
    label187:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.Gob.GzJ.getContext();
      localObject = ((bi)localObject).drF;
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((du)localObject).field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramView.adn(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.jH(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.f
 * JD-Core Version:    0.7.0.1
 */