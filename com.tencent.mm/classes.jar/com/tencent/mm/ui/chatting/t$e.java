package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class t$e
  implements MMTextView.b
{
  private View.OnTouchListener fkQ = null;
  private o fvf = null;
  private ScrollView gqx = null;
  ah handler = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = (View)paramAnonymousMessage.obj;
      if (t.e.this.rkO != paramAnonymousMessage.getScrollY())
      {
        t.e.this.pyH = true;
        t.e.this.handler.sendMessageDelayed(t.e.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
        t.e.this.rkO = paramAnonymousMessage.getScrollY();
        return;
      }
      t.e.this.pyH = false;
    }
  };
  private long nni = 0L;
  boolean pyH = false;
  private boolean pyI = false;
  int rkO = 0;
  private a vko = null;
  private MMTextView vkq = null;
  private TextView vkr = null;
  private final int vks = 3;
  private int vkt = 0;
  private int vku = 0;
  
  public t$e(a parama)
  {
    this.vko = parama;
  }
  
  public final boolean dI(View paramView)
  {
    if ((paramView.getTag() instanceof aw))
    {
      Object localObject2 = (aw)paramView.getTag();
      if ((((paramView instanceof TextView)) || ((paramView instanceof MMNeatTextView))) && (((aw)localObject2).bWO != null) && (this.vko != null))
      {
        Object localObject1 = "";
        if ((paramView instanceof TextView)) {
          localObject1 = ((TextView)paramView).getText();
        }
        for (;;)
        {
          paramView = this.vko.vtz.getContext();
          localObject2 = ((aw)localObject2).bWO;
          Intent localIntent = new Intent(paramView, TextPreviewUI.class);
          localIntent.putExtra("key_chat_text", (CharSequence)localObject1);
          localIntent.putExtra("Chat_Msg_Id", ((cs)localObject2).field_msgId);
          paramView.startActivity(localIntent);
          b.gJ(paramView);
          return true;
          if ((paramView instanceof MMNeatTextView)) {
            localObject1 = ((MMNeatTextView)paramView).mText;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.e
 * JD-Core Version:    0.7.0.1
 */