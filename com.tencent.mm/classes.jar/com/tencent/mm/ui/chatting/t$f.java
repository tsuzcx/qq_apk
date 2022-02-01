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
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.viewitems.by;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class t$f
  implements MMTextView.b
{
  private long Hwi;
  private boolean IOO;
  private boolean MhW;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private MMTextView WBs;
  private TextView WBt;
  private final int WBu;
  private int WBv;
  private int WBw;
  private MMHandler handler;
  private ScrollView mPe;
  private View.OnTouchListener nbI;
  private r nmy;
  private int zDE;
  
  public t$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34596);
    this.WBq = null;
    this.nmy = null;
    this.WBs = null;
    this.WBt = null;
    this.mPe = null;
    this.Hwi = 0L;
    this.WBu = 3;
    this.WBv = 0;
    this.zDE = 0;
    this.WBw = 0;
    this.IOO = false;
    this.MhW = false;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34595);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (t.f.a(t.f.this) != paramAnonymousMessage.getScrollY())
        {
          t.f.a(t.f.this, true);
          t.f.b(t.f.this).sendMessageDelayed(t.f.b(t.f.this).obtainMessage(0, paramAnonymousMessage), 5L);
          t.f.a(t.f.this, paramAnonymousMessage.getScrollY());
          AppMethodBeat.o(34595);
          return;
        }
        t.f.a(t.f.this, false);
        AppMethodBeat.o(34595);
      }
    };
    this.nbI = null;
    this.WBq = parama;
    AppMethodBeat.o(34596);
  }
  
  public final boolean hM(View paramView)
  {
    AppMethodBeat.i(34597);
    Object localObject;
    if ((paramView.getTag() instanceof by))
    {
      localObject = (by)paramView.getTag();
      if (((paramView instanceof TextView)) && (((by)localObject).fNz != null) && (this.WBq != null)) {
        if (!(paramView instanceof TextView)) {
          break label210;
        }
      }
    }
    label210:
    for (paramView = ((TextView)paramView).getText();; paramView = "")
    {
      Activity localActivity = this.WBq.WQv.getContext();
      localObject = ((by)localObject).fNz;
      boolean bool = this.WBq.hRi();
      Intent localIntent = new Intent(localActivity, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramView);
      localIntent.putExtra("Chat_Msg_Id", ((et)localObject).field_msgId);
      localIntent.putExtra("is_group_chat", bool);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramView.aFh(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.la(localActivity);
      AppMethodBeat.o(34597);
      return true;
      AppMethodBeat.o(34597);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.f
 * JD-Core Version:    0.7.0.1
 */