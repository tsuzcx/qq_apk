package com.tencent.mm.plugin.textstatus.conversation.a;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.d;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.u.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingLongClickListener;", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "invoke", "view", "position", "item", "(Landroid/view/View;ILcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;)Ljava/lang/Boolean;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, u.i, q<View, Integer, d, Boolean>
{
  public static final f.a Tiy;
  private a<ah> AFP = null;
  private d Tiz;
  
  static
  {
    AppMethodBeat.i(290888);
    Tiy = new f.a((byte)0);
    AppMethodBeat.o(290888);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(290896);
    s.u(paramContextMenu, "menu");
    s.u(paramView, "v");
    s.u(paramContextMenuInfo, "menuInfo");
    paramContextMenu.add(0, 2, 0, a.h.app_delete);
    AppMethodBeat.o(290896);
  }
  
  public final void onDismiss()
  {
    this.Tiz = null;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(290903);
    s.u(paramMenuItem, "menuItem");
    d locald = this.Tiz;
    if ((locald != null) && (paramMenuItem.getItemId() == 2))
    {
      paramMenuItem = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
      paramMenuItem = locald.field_session_id;
      s.s(paramMenuItem, "focused.field_session_id");
      com.tencent.mm.plugin.textstatus.conversation.d.f.a.hp(paramMenuItem, 107);
      paramMenuItem = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      if (com.tencent.mm.plugin.textstatus.b.f.hGN().delete((IAutoDBItem)locald, new String[0]))
      {
        paramMenuItem = this.AFP;
        if (paramMenuItem != null) {
          paramMenuItem.invoke();
        }
      }
    }
    AppMethodBeat.o(290903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.f
 * JD-Core Version:    0.7.0.1
 */