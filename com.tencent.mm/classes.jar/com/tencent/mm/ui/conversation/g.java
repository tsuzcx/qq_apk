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
import com.tencent.mm.R.l;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private Activity activity;
  private ak conversation = null;
  private n.d ifj = new g.1(this);
  private String talker = "";
  private h vPG;
  private ListView vPc;
  private int[] vQS = new int[2];
  
  public g(h paramh, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    this.vPG = paramh;
    this.vPc = paramListView;
    this.activity = paramActivity;
    this.vQS = paramArrayOfInt;
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    paramView = this.vPG;
    y.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { ah.Vb() });
    paramView.vSv = true;
    au.Hx();
    ad localad = c.Fw().abl(this.talker);
    if (localad == null)
    {
      y.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      return;
    }
    String str = localad.Bq();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (ah.bl(localad.field_nickname)) {
        paramView = this.activity.getString(R.l.chatting_roominfo_noname);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(j.b(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      label156:
      if ((i & s.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        au.Hx();
        paramView = c.FB().abv(paramView);
        if (paramView == null) {
          break label425;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.gV(1048576))) {
          break label419;
        }
        i = j;
        label212:
        if (i == 0) {
          break label431;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, R.l.main_conversation_longclick_setUnRead);
      }
      label234:
      if ((this.conversation != null) && (s.a(this.conversation)))
      {
        au.Hx();
        if (!c.FB().abD(this.talker)) {
          break label451;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, R.l.main_conversation_longclick_unplacedtop);
      }
    }
    for (;;)
    {
      if ((localad.cua()) && (com.tencent.mm.n.a.gR(localad.field_type)) && (!s.hV(localad.field_username)) && (!s.hx(localad.field_username)))
      {
        paramView = f.kX(localad.field_username);
        if ((paramView != null) && (paramView.Lv())) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, R.l.main_conversation_longclick_delete_biz_service);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break;
      }
      if (!s.hq(this.talker)) {
        break label497;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.main_delete_tmessage);
      return;
      i = 0;
      break label156;
      label419:
      i = 0;
      break label212;
      label425:
      i = 0;
      break label212;
      label431:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.main_conversation_longclick_markRead);
      break label234;
      label451:
      if (localad.cua()) {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.contact_info_stick_biz);
      } else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.main_conversation_longclick_placedtop);
      }
    }
    label497:
    if (s.hr(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.main_delete_bottleentry);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.main_delete);
  }
  
  public final void onDismiss()
  {
    h localh = this.vPG;
    localh.vSv = false;
    localh.notifyDataSetChanged();
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.vPc.getHeaderViewsCount())
    {
      y.d("MicroMsg.ConversationClickListener", "on long click header view");
      return true;
    }
    this.conversation = ((ak)this.vPG.FC(paramInt - this.vPc.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      y.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.vPc.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new com.tencent.mm.ui.widget.b.a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.ifj, this.vQS[0], this.vQS[1]);
    paramAdapterView.wfc = this;
    if (s.fn(this.talker)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      return true;
      com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */