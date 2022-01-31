package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private ListView AgN;
  private h Ahr;
  private Activity activity;
  private ak conversation;
  private n.d jWw;
  private int[] mHH;
  private int position;
  private String talker;
  
  public g(h paramh, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34261);
    this.talker = "";
    this.conversation = null;
    this.mHH = new int[2];
    this.jWw = new g.1(this);
    this.Ahr = paramh;
    this.AgN = paramListView;
    this.activity = paramActivity;
    this.mHH = paramArrayOfInt;
    AppMethodBeat.o(34261);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    AppMethodBeat.i(34264);
    paramView = this.Ahr;
    ab.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { ah.aoA() });
    paramView.Akl = true;
    aw.aaz();
    ad localad = c.YA().arw(this.talker);
    if (localad == null)
    {
      ab.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(34264);
      return;
    }
    String str = localad.Of();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (ah.isNullOrNil(localad.field_nickname)) {
        paramView = this.activity.getString(2131298302);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(j.b(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & t.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        aw.aaz();
        paramView = c.YF().arH(paramView);
        if (paramView == null) {
          break label436;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.ji(1048576))) {
          break label430;
        }
        i = j;
        label221:
        if (i == 0) {
          break label442;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, 2131301405);
      }
      label242:
      if ((this.conversation != null) && (t.a(this.conversation)))
      {
        aw.aaz();
        if (!c.YF().arP(this.talker)) {
          break label462;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131301406);
      }
    }
    for (;;)
    {
      if ((localad.dwz()) && (com.tencent.mm.n.a.je(localad.field_type)) && (!t.oE(localad.field_username)) && (!t.og(localad.field_username)))
      {
        paramView = f.rS(localad.field_username);
        if ((paramView != null) && (paramView.aed())) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131301402);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label556;
      }
      if (!t.nZ(this.talker)) {
        break label508;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131301413);
      AppMethodBeat.o(34264);
      return;
      i = 0;
      break;
      label430:
      i = 0;
      break label221;
      label436:
      i = 0;
      break label221;
      label442:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131301403);
      break label242;
      label462:
      if (localad.dwz()) {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131298813);
      } else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131301404);
      }
    }
    label508:
    if (t.oa(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131301411);
      AppMethodBeat.o(34264);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131301410);
    label556:
    AppMethodBeat.o(34264);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(34263);
    h localh = this.Ahr;
    localh.Akl = false;
    localh.notifyDataSetChanged();
    AppMethodBeat.o(34263);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34262);
    if (paramInt < this.AgN.getHeaderViewsCount())
    {
      ab.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(34262);
      return true;
    }
    this.position = (paramInt - this.AgN.getHeaderViewsCount());
    this.conversation = ((ak)this.Ahr.NM(paramInt - this.AgN.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      ab.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.AgN.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(34262);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new com.tencent.mm.ui.widget.c.a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.jWw, this.mHH[0], this.mHH[1]);
    paramAdapterView.AxS = this;
    if (t.lA(this.talker)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      AppMethodBeat.o(34262);
      return true;
      com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */