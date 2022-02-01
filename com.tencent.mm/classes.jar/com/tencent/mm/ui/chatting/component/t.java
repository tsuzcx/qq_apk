package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.q;
import com.tencent.mm.ui.conversation.ServiceNotifyConversationUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=q.class)
public class t
  extends a
  implements q
{
  private int aepV;
  String aerg;
  private Map<Long, Long> aerh;
  private Map<Long, Set<Long>> aeri;
  private List<Long> aerj;
  private List<cc> aerk;
  final com.tencent.mm.ui.ad aerl;
  
  public t()
  {
    AppMethodBeat.i(256138);
    this.aerk = null;
    this.aerl = new com.tencent.mm.ui.ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256049);
        if (paramAnonymousMenuItem.getItemId() == 4)
        {
          paramAnonymousMenuItem = new Intent();
          int i;
          if (t.this.jrP())
          {
            i = 7;
            paramAnonymousMenuItem.putExtra("detail_username", t.this.aerg);
            paramAnonymousMenuItem.putExtra("Search_Scene", 3);
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.a.d.d(t.this.hlc.aezO.getContext(), ".ui.FTSServiceNotifyUI", paramAnonymousMenuItem);
            com.tencent.mm.plugin.report.service.h.OAn.b(23903, new Object[] { Integer.valueOf(i), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
            AppMethodBeat.o(256049);
            return;
            paramAnonymousMenuItem.putExtra("Search_Scene", 1);
            i = 1;
          }
        }
        if (paramAnonymousMenuItem.getItemId() == 5)
        {
          if (t.this.jrP())
          {
            String str = t.this.aerg;
            if (au.Hh(str))
            {
              paramAnonymousMenuItem = com.tencent.mm.msgsubscription.api.b.piw;
              localObject = com.tencent.mm.msgsubscription.api.b.QW("name_wxa");
              paramAnonymousMenuItem = com.tencent.mm.plugin.appbrand.config.ad.XE(str);
              if (paramAnonymousMenuItem != null)
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.nickname;
                if (localObject == null) {
                  break label327;
                }
                ((com.tencent.mm.msgsubscription.b.a)localObject).a(t.this.hlc.aezO.getContext(), 4, str, paramAnonymousMenuItem);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(21825, new Object[] { Integer.valueOf(7), str, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              AppMethodBeat.o(256049);
              return;
              Log.e("MicroMsg.ChattingServiceNotifyComponent", "attrs is null");
              paramAnonymousMenuItem = null;
              break;
              paramAnonymousMenuItem = com.tencent.mm.msgsubscription.api.b.piw;
              localObject = com.tencent.mm.msgsubscription.api.b.QW("name_biz");
              paramAnonymousMenuItem = aa.getDisplayName(str);
              break;
              label327:
              Log.e("MicroMsg.ChattingServiceNotifyComponent", "service is null");
            }
          }
          paramAnonymousMenuItem = t.this.hlc.aezO.getContext();
          Object localObject = new Intent(t.this.hlc.aezO.getContext(), ServiceNotifyConversationUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.OAn.b(21825, new Object[] { Integer.valueOf(1), null, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(256049);
      }
    };
    AppMethodBeat.o(256138);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(256141);
    if (this.hlc.aezO.findMenuInfo(paramInt1) == null)
    {
      this.hlc.aezO.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
      AppMethodBeat.o(256141);
      return;
    }
    this.hlc.aezO.updateOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
    AppMethodBeat.o(256141);
  }
  
  private boolean b(cc paramcc1, cc paramcc2)
  {
    AppMethodBeat.i(256147);
    if ((this.aerk == null) || (this.aerk.isEmpty()))
    {
      AppMethodBeat.o(256147);
      return false;
    }
    long l1 = ((cc)this.aerk.get(this.aerk.size() - 1)).field_msgId;
    long l2 = paramcc1.field_msgId;
    long l3 = paramcc2.field_msgId;
    paramcc1 = paramcc1.field_content;
    paramcc2 = paramcc2.field_content;
    if ((Util.isNullOrNil(paramcc1)) || (Util.isNullOrNil(paramcc2)))
    {
      AppMethodBeat.o(256147);
      return false;
    }
    paramcc1 = com.tencent.mm.message.c.b.Ht(paramcc1);
    paramcc2 = com.tencent.mm.message.c.b.Ht(paramcc2);
    if ((Util.nullAsNil(paramcc1.iaa).equals(paramcc2.iaa)) && (Util.nullAsNil(paramcc1.title).equals(paramcc2.title)) && (l2 >= l1) && (l3 > l2))
    {
      AppMethodBeat.o(256147);
      return true;
    }
    AppMethodBeat.o(256147);
    return false;
  }
  
  private void jrS()
  {
    AppMethodBeat.i(256165);
    if ((this.aerh != null) && (this.aeri != null) && (this.aerj != null))
    {
      AppMethodBeat.o(256165);
      return;
    }
    long l3 = System.currentTimeMillis();
    for (;;)
    {
      HashMap localHashMap;
      long l1;
      int k;
      cc localcc;
      try
      {
        if ((this.aerh != null) && (this.aeri != null) && (this.aerj != null)) {
          return;
        }
        this.aerh = new HashMap();
        this.aeri = new HashMap();
        this.aerj = new ArrayList();
        Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(this.hlc.getTalkerUserName());
        if ((localObject1 != null) && (((bd)localObject1).field_unReadCount > 0))
        {
          i = Math.min(((bd)localObject1).field_unReadCount, 100);
          if (i > 0) {
            this.aerk = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().fS(this.hlc.getTalkerUserName(), i);
          }
        }
        if ((this.aerk == null) || (this.aerk.isEmpty())) {
          return;
        }
        Log.i("MicroMsg.ChattingServiceNotifyComponent", "unread msg count: %d", new Object[] { Integer.valueOf(this.aerk.size()) });
        localHashMap = new HashMap();
        localObject4 = null;
        l1 = 0L;
        k = 0;
        localObject1 = null;
        i = 0;
        if (i >= Math.min(this.aerk.size(), 200)) {
          break label826;
        }
        localcc = (cc)this.aerk.get(i);
        localObject5 = null;
        if (i + 1 < this.aerk.size()) {
          localObject5 = (cc)this.aerk.get(i + 1);
        }
        if (localObject5 == null) {
          break label647;
        }
        if (b((cc)localObject5, localcc))
        {
          if (k != 0) {
            break label957;
          }
          l1 = localcc.field_msgId;
          localObject1 = new HashSet();
          k = 1;
          localHashMap.put(Long.valueOf(l1), Long.valueOf(((fi)localObject5).field_msgId));
          ((Set)localObject1).add(Long.valueOf(((fi)localObject5).field_msgId));
          ((Set)localObject1).add(Long.valueOf(l1));
          if (((Set)localObject1).size() < 10) {
            break label976;
          }
          if (localObject1 != null) {
            this.aeri.put(Long.valueOf(((fi)localObject5).field_msgId), localObject1);
          }
          j = 0;
          k = i + 1;
          localObject1 = null;
          localObject4 = localObject5;
          i = j;
          j = k;
          if (!this.aerj.contains(Long.valueOf(localcc.field_msgId))) {
            this.aerj.add(Long.valueOf(localcc.field_msgId));
          }
          if (this.aerj.contains(Long.valueOf(((fi)localObject5).field_msgId))) {
            break label960;
          }
          this.aerj.add(Long.valueOf(((fi)localObject5).field_msgId));
          localObject5 = localObject4;
          m = j;
          l2 = l1;
          j = i;
          i = m + 1;
          k = j;
          l1 = l2;
          localObject4 = localObject5;
          continue;
        }
        if (localObject2 == null) {
          break label624;
        }
      }
      finally
      {
        AppMethodBeat.o(256165);
      }
      this.aeri.put(Long.valueOf(localcc.field_msgId), localObject2);
      label624:
      Object localObject3 = null;
      Object localObject4 = localcc;
      for (;;)
      {
        j = 0;
        l2 = l1;
        m = i;
        localObject5 = localObject4;
        break;
        label647:
        if (localObject4 == null) {
          break label941;
        }
        if ((b(localcc, localObject4)) && (k != 0))
        {
          localHashMap.put(Long.valueOf(l1), Long.valueOf(localcc.field_msgId));
          if (localObject3 == null) {}
          for (Object localObject6 = new HashSet();; localObject6 = localObject3)
          {
            this.aeri.put(Long.valueOf(localcc.field_msgId), localObject6);
            ((Set)localObject6).add(Long.valueOf(localcc.field_msgId));
            ((Set)localObject6).add(Long.valueOf(l1));
            j = k;
            l2 = l1;
            m = i;
            localObject3 = localObject6;
            localObject5 = localObject4;
            if (this.aerj.contains(Long.valueOf(localcc.field_msgId))) {
              break;
            }
            this.aerj.add(Long.valueOf(localcc.field_msgId));
            j = k;
            l2 = l1;
            m = i;
            localObject3 = localObject6;
            localObject5 = localObject4;
            break;
            label826:
            this.aerh.putAll(localHashMap);
            localHashMap.clear();
            Log.i("MicroMsg.ChattingServiceNotifyComponent", "initMessageGroupInfo cost: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
            Log.i("MicroMsg.ChattingServiceNotifyComponent", "end to head msg id size: %d, group by info size: %d, msg in group total size: %d", new Object[] { Integer.valueOf(this.aerh.size()), Integer.valueOf(this.aeri.size()), Integer.valueOf(this.aerj.size()) });
            AppMethodBeat.o(256165);
            return;
          }
        }
      }
      label941:
      int j = k;
      long l2 = l1;
      int m = i;
      Object localObject5 = localObject4;
      continue;
      label957:
      continue;
      label960:
      m = j;
      j = i;
      l2 = l1;
      localObject5 = localObject4;
      continue;
      label976:
      localObject4 = localcc;
      j = i;
      int i = k;
    }
  }
  
  public final boolean a(cc paramcc1, cc paramcc2)
  {
    AppMethodBeat.i(256233);
    if (!jrQ())
    {
      AppMethodBeat.o(256233);
      return false;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "checkIfNeedGroupMsg");
    jrS();
    boolean bool = b(paramcc1, paramcc2);
    AppMethodBeat.o(256233);
    return bool;
  }
  
  public final void aQ(long paramLong, int paramInt)
  {
    AppMethodBeat.i(256257);
    if (!jrQ())
    {
      AppMethodBeat.o(256257);
      return;
    }
    if ((this.aerh == null) || (this.aerj == null) || (this.aeri == null))
    {
      AppMethodBeat.o(256257);
      return;
    }
    Object localObject = (Long)this.aerh.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      if (paramLong < ((Long)localObject).longValue())
      {
        Log.e("MicroMsg.ChattingServiceNotifyComponent", "head msg id is large than end msg id!");
        AppMethodBeat.o(256257);
        return;
      }
      for (long l = ((Long)localObject).longValue(); l <= paramLong; l += 1L) {
        this.aerj.remove(Long.valueOf(l));
      }
    }
    localObject = (Set)this.aeri.remove(localObject);
    int i = 0;
    if (localObject != null) {
      i = paramInt - ((Set)localObject).size() + 1;
    }
    localObject = (m)this.hlc.cm(m.class);
    if (localObject != null) {
      ((m)localObject).aBX(i);
    }
    AppMethodBeat.o(256257);
  }
  
  public final void d(int paramInt, cc paramcc)
  {
    int k = 2;
    AppMethodBeat.i(256264);
    if (!jrQ())
    {
      AppMethodBeat.o(256264);
      return;
    }
    long l = zN(paramcc.field_msgId);
    if (this.aeri.get(Long.valueOf(l)) == null) {}
    for (int j = 0; l < 0L; j = ((Set)this.aeri.get(Long.valueOf(l))).size())
    {
      AppMethodBeat.o(256264);
      return;
    }
    paramcc = com.tencent.mm.message.c.b.Ht(paramcc.field_content);
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    String str1;
    String str2;
    switch (paramcc.nVN)
    {
    default: 
      i = 0;
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      str1 = paramcc.iaa;
      str2 = paramcc.nSg;
      if ((paramcc.opType != 1) || (TextUtils.isEmpty(paramcc.nUR))) {
        break;
      }
    }
    for (;;)
    {
      localh.b(22906, new Object[] { Integer.valueOf(paramInt), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(256264);
      return;
      i = 2;
      break;
      i = 3;
      break;
      k = 1;
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(256188);
    super.jjf();
    this.aerg = this.hlc.aezO.getStringExtra("key_notify_message_real_username");
    if ((!jrP()) && (!jrQ()))
    {
      AppMethodBeat.o(256188);
      return;
    }
    this.aepV = 0;
    AppMethodBeat.o(256188);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256272);
    super.jjg();
    if (!jrQ())
    {
      AppMethodBeat.o(256272);
      return;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "onChattingEnterAnimStart");
    jrS();
    AppMethodBeat.o(256272);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256199);
    if (!jrQ())
    {
      AppMethodBeat.o(256199);
      return;
    }
    com.tencent.threadpool.h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256043);
        if ((t.this.hlc != null) && (t.this.hlc.aezO != null) && (t.this.hlc.aezO.getBodyView() != null)) {
          Util.hideVKB(t.this.hlc.aezO.getBodyView());
        }
        AppMethodBeat.o(256043);
      }
    }, 128L);
    AppMethodBeat.o(256199);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256194);
    super.jjl();
    if (!jrQ())
    {
      AppMethodBeat.o(256194);
      return;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "onChattingExitAnimEnd");
    this.hlc.aezO.removeOptionMenu(4);
    this.hlc.aezO.removeOptionMenu(5);
    int j = ((m)this.hlc.cm(m.class)).getCount();
    int i = j - this.aepV;
    while (i < j)
    {
      cc localcc = ((m)this.hlc.cm(m.class)).aBV(i);
      if ((localcc != null) && (this.aerh != null) && (this.aerh.containsKey(Long.valueOf(localcc.field_msgId)))) {
        d(1, localcc);
      }
      i += 1;
    }
    if (this.aerh != null) {
      this.aerh.clear();
    }
    this.aerh = null;
    if (this.aeri != null) {
      this.aeri.clear();
    }
    this.aeri = null;
    if (this.aerj != null) {
      this.aerj.clear();
    }
    this.aerj = null;
    try
    {
      if (this.aerk != null) {
        this.aerk.clear();
      }
      this.aerk = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(256194);
    }
  }
  
  public final boolean jrO()
  {
    AppMethodBeat.i(256219);
    if (!jrP())
    {
      AppMethodBeat.o(256219);
      return false;
    }
    ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).jsM();
    AppMethodBeat.o(256219);
    return true;
  }
  
  public final boolean jrP()
  {
    AppMethodBeat.i(256224);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(256224);
      return false;
    }
    if ((au.bwu(this.hlc.getTalkerUserName())) && (!Util.isNullOrNil(this.aerg)))
    {
      AppMethodBeat.o(256224);
      return true;
    }
    AppMethodBeat.o(256224);
    return false;
  }
  
  public final boolean jrQ()
  {
    AppMethodBeat.i(256227);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(256227);
      return false;
    }
    boolean bool = au.bwu(this.hlc.getTalkerUserName());
    AppMethodBeat.o(256227);
    return bool;
  }
  
  public final boolean jrR()
  {
    int i = 1;
    AppMethodBeat.i(256275);
    if (!jrQ())
    {
      AppMethodBeat.o(256275);
      return false;
    }
    this.hlc.aezO.removeOptionMenu(0);
    if (jrP())
    {
      a(4, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, this.aerl);
      if ((jrP()) && (au.Hh(this.aerg))) {
        if (i != 0) {
          a(5, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(256275);
      return false;
      i = 0;
      break;
      bh.bCz();
      if (c.getNotifyMessageRecordStorage().bww())
      {
        this.hlc.showOptionMenu(false);
        AppMethodBeat.o(256275);
        return true;
      }
      a(4, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, this.aerl);
      a(5, R.l.actionbar_title_more, R.k.actionbar_menu_list_icon, this.aerl);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256269);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (!jrP())
    {
      AppMethodBeat.o(256269);
      return;
    }
    if ((paramInt1 == 100) && (paramIntent != null))
    {
      Log.i("MicroMsg.ChattingServiceNotifyComponent", "receive data from subscribe msg");
      paramIntent = (SubscribeMsgSettingData)paramIntent.getParcelableExtra("key_biz_data");
      if (paramIntent != null)
      {
        com.tencent.mm.msgsubscription.util.d locald = com.tencent.mm.msgsubscription.util.d.pmU;
        com.tencent.mm.msgsubscription.util.d.a(this.aerg, paramIntent, new aq(this.hlc.aezO.getContext(), this.aerg));
      }
    }
    AppMethodBeat.o(256269);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256204);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!jrQ())
    {
      AppMethodBeat.o(256204);
      return;
    }
    this.aepV = Math.max(this.aepV, paramInt3 - paramInt1);
    AppMethodBeat.o(256204);
  }
  
  public final void p(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(256214);
    if (!jrP())
    {
      AppMethodBeat.o(256214);
      return;
    }
    if (Util.isNullOrNil(this.aerg))
    {
      Log.e("MicroMsg.ChattingServiceNotifyComponent", "username is null");
      AppMethodBeat.o(256214);
      return;
    }
    final boolean bool = au.Hh(this.aerg);
    final Activity localActivity = this.hlc.aezO.getContext();
    Object localObject = paramLinearLayout.findViewById(R.h.fzK);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(R.h.fTt);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(R.h.profile_name);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(R.h.fTD);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(256040);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (bool) {
            t.a(t.this, localActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(21825, new Object[] { Integer.valueOf(6), t.a(t.this), Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256040);
            return;
            t.b(t.this, localActivity);
          }
        }
      });
    }
    if (localImageView != null) {
      a.b.h(localImageView, this.aerg);
    }
    paramLinearLayout = "";
    if (localTextView2 != null)
    {
      if (bool)
      {
        localObject = com.tencent.mm.plugin.appbrand.config.ad.XE(this.aerg);
        if (localObject != null) {
          paramLinearLayout = ((al)localObject).nickname;
        }
        localTextView2.setText(aa.getDisplayName(paramLinearLayout));
      }
    }
    else if (localTextView1 != null) {
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (paramLinearLayout = localActivity.getString(R.l.appbrand_app_name);; paramLinearLayout = localActivity.getString(R.l.fts_header_biz))
    {
      localTextView1.setText(paramLinearLayout);
      AppMethodBeat.o(256214);
      return;
      paramLinearLayout = aa.getDisplayName(this.aerg);
      break;
    }
  }
  
  public final long zN(long paramLong)
  {
    AppMethodBeat.i(256239);
    if (!jrQ())
    {
      AppMethodBeat.o(256239);
      return -1L;
    }
    jrS();
    Long localLong = (Long)this.aerh.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(256239);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(256239);
    return paramLong;
  }
  
  public final Set<Long> zO(long paramLong)
  {
    AppMethodBeat.i(256243);
    if (!jrQ())
    {
      AppMethodBeat.o(256243);
      return null;
    }
    jrS();
    Set localSet = (Set)this.aeri.get(Long.valueOf(paramLong));
    AppMethodBeat.o(256243);
    return localSet;
  }
  
  public final List<cc> zP(long paramLong)
  {
    AppMethodBeat.i(256247);
    ArrayList localArrayList = new ArrayList();
    if (!jrQ())
    {
      AppMethodBeat.o(256247);
      return localArrayList;
    }
    Set localSet;
    if (!jrQ()) {
      localSet = null;
    }
    while (localSet == null)
    {
      AppMethodBeat.o(256247);
      return localArrayList;
      paramLong = zN(paramLong);
      if (paramLong <= 0L) {
        localSet = null;
      } else {
        localSet = zO(paramLong);
      }
    }
    Iterator localIterator = this.aerk.iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (localSet.contains(Long.valueOf(localcc.field_msgId))) {
        localArrayList.add(localcc);
      }
    }
    AppMethodBeat.o(256247);
    return localArrayList;
  }
  
  public final boolean zQ(long paramLong)
  {
    AppMethodBeat.i(256252);
    if (!jrQ())
    {
      AppMethodBeat.o(256252);
      return false;
    }
    jrS();
    boolean bool = this.aerj.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(256252);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.t
 * JD-Core Version:    0.7.0.1
 */