package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import java.lang.ref.WeakReference;

final class k$9
  implements View.OnClickListener
{
  k$9(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    d.b((Context)this.vUP.sdy.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.9
 * JD-Core Version:    0.7.0.1
 */