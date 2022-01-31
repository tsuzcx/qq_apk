package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;

public final class i
  extends b
{
  int cCu;
  private c uJc;
  View vUI;
  
  public i(Context paramContext)
  {
    super(paramContext);
    this.vUI = View.inflate(paramContext, R.i.invite_friend_view_in_chat, null);
    if (this.vUI == null) {
      return;
    }
    this.cCu = ah.getInt(g.AA().getValue("InviteFriendsControlFlags"), 0);
    this.vUI.setVisibility(8);
    this.vUI.setPadding(0, -com.tencent.mm.cb.a.fromDPToPix(paramContext, R.f.NormalListHeight), 0, 0);
    if ((this.cCu & 0x1) > 0)
    {
      this.vUI.setVisibility(0);
      this.vUI.setPadding(0, 0, 0, 0);
    }
    this.vUI.setOnClickListener(new i.1(this, paramContext));
    this.uJc = new i.2(this);
  }
  
  public final boolean apu()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.uJc);
    return (this.vUI != null) && (this.vUI.getVisibility() == 0);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.vUI;
  }
  
  public final void release()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.uJc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */