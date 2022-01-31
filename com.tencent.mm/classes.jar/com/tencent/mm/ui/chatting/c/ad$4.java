package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import java.util.LinkedList;

final class ad$4
  implements n.d
{
  ad$4(ad paramad, LinkedList paramLinkedList, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31617);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31617);
      return;
      ((f)this.zHi.caz.ay(f.class)).aO(this.zHk);
      AppMethodBeat.o(31617);
      return;
      paramMenuItem = b.aoI(this.zHi.caz.txj.field_username).O(this.zHl, this.zHi.caz.txj.field_username);
      Activity localActivity = this.zHi.caz.zJz.getContext();
      this.zHi.caz.zJz.getMMResources().getString(2131297087);
      paramMenuItem.a(localActivity, this.zHi.caz.zJz.getMMResources().getString(2131302693), true, new ad.4.1(this, paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ad.4
 * JD-Core Version:    0.7.0.1
 */