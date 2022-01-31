package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class s$f
  implements MMTextView.b
{
  private View.OnTouchListener gCh;
  private o gMK;
  private ScrollView hLr;
  ak handler;
  private long pSw;
  boolean tau;
  private boolean tav;
  int vap;
  private a zzP;
  private MMTextView zzR;
  private TextView zzS;
  private final int zzT;
  private int zzU;
  private int zzV;
  
  public s$f(a parama)
  {
    AppMethodBeat.i(30722);
    this.zzP = null;
    this.gMK = null;
    this.zzR = null;
    this.zzS = null;
    this.hLr = null;
    this.pSw = 0L;
    this.zzT = 3;
    this.zzU = 0;
    this.vap = 0;
    this.zzV = 0;
    this.tau = false;
    this.tav = false;
    this.handler = new s.f.1(this);
    this.gCh = null;
    this.zzP = parama;
    AppMethodBeat.o(30722);
  }
  
  public final boolean eR(View paramView)
  {
    AppMethodBeat.i(30723);
    if ((paramView.getTag() instanceof az))
    {
      Object localObject2 = (az)paramView.getTag();
      if (((paramView instanceof TextView)) && (((az)localObject2).cEE != null) && (this.zzP != null))
      {
        Object localObject1 = "";
        if ((paramView instanceof TextView)) {
          localObject1 = ((TextView)paramView).getText();
        }
        paramView = this.zzP.zJz.getContext();
        localObject2 = ((az)localObject2).cEE;
        Intent localIntent = new Intent(paramView, TextPreviewUI.class);
        localIntent.putExtra("key_chat_text", (CharSequence)localObject1);
        localIntent.putExtra("Chat_Msg_Id", ((dd)localObject2).field_msgId);
        paramView.startActivity(localIntent);
        b.jdMethod_if(paramView);
        AppMethodBeat.o(30723);
        return true;
      }
    }
    AppMethodBeat.o(30723);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.f
 * JD-Core Version:    0.7.0.1
 */