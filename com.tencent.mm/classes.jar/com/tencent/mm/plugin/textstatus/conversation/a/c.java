package com.tencent.mm.plugin.textstatus.conversation.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.conversation.h.d;
import com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusConversationFragment;
import com.tencent.mm.plugin.textstatus.ui.l;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationLongClickListener;", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "fragment", "Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;", "callBack", "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "invoke", "view", "position", "conv", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, u.i, q<View, Integer, com.tencent.mm.plugin.textstatus.conversation.d.a, ah>
{
  public static final c.a Tis;
  private kotlin.g.a.a<ah> AFP;
  private final TextStatusConversationFragment Tip;
  private com.tencent.mm.plugin.textstatus.conversation.d.a Tit;
  
  static
  {
    AppMethodBeat.i(290884);
    Tis = new c.a((byte)0);
    AppMethodBeat.o(290884);
  }
  
  private c(TextStatusConversationFragment paramTextStatusConversationFragment)
  {
    AppMethodBeat.i(290877);
    this.Tip = paramTextStatusConversationFragment;
    this.AFP = null;
    AppMethodBeat.o(290877);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(290889);
    s.u(paramContextMenu, "menu");
    s.u(paramView, "v");
    s.u(paramContextMenuInfo, "menuInfo");
    paramView = this.Tit;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.field_sessionId)
    {
      if (!s.p(paramView, "textstatussayhisessionholder")) {
        paramContextMenu.add(0, 2, 0, a.h.main_delete);
      }
      AppMethodBeat.o(290889);
      return;
    }
  }
  
  public final void onDismiss()
  {
    this.Tit = null;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(290902);
    s.u(paramMenuItem, "menuItem");
    com.tencent.mm.plugin.textstatus.conversation.d.a locala = this.Tit;
    if ((locala != null) && (paramMenuItem.getItemId() == 2))
    {
      paramMenuItem = paramMenuItem.getMenuInfo();
      if (paramMenuItem == null)
      {
        paramMenuItem = new NullPointerException("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(290902);
        throw paramMenuItem;
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      boolean bool = com.tencent.mm.plugin.textstatus.b.f.hGL().deleteNotify(locala.systemRowid, false);
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGM();
        Object localObject2 = locala.field_sessionId;
        s.s(localObject2, "focused.field_sessionId");
        s.u(localObject2, "sessionId");
        g localg = ((d)localObject1).bdP((String)localObject2);
        ((d)localObject1).FMn.remove(localObject2);
        ((d)localObject1).FMm.remove(localg.field_talker + '_' + localg.field_senderUserName);
        SystemClock.uptimeMillis();
        ((d)localObject1).delete((IAutoDBItem)localg, false, new String[] { "sessionId" });
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGL().doNotify(locala.field_sessionId, 6, locala);
        localObject1 = this.AFP;
        if (localObject1 != null) {
          ((kotlin.g.a.a)localObject1).invoke();
        }
        localObject1 = this.Tip.getActivity();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          com.tencent.mm.plugin.textstatus.b.f.hGU();
          localObject2 = k.aeZF;
          ((l)k.nq((Context)localObject1).q(l.class)).aoz(1);
          localObject1 = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          localObject1 = locala.field_sessionId;
          s.s(localObject1, "focused.field_sessionId");
          f.a.hp((String)localObject1, 55);
        }
      }
      br.a(locala.field_sessionId, (br.a)new c.b(bool, paramMenuItem));
    }
    AppMethodBeat.o(290902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.c
 * JD-Core Version:    0.7.0.1
 */