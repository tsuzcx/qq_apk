package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;

final class h$1
  implements View.OnClickListener
{
  h$1(h paramh) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    c.Dz().o(65833, Integer.valueOf(0));
    ((Context)this.vUH.sdy.get()).startActivity(new Intent((Context)this.vUH.sdy.get(), FacebookFriendUI.class));
    this.vUH.view.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.h.1
 * JD-Core Version:    0.7.0.1
 */