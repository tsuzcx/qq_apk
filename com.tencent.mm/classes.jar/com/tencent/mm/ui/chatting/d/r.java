package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.util.d;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(hRc=o.class)
public class r
  extends a
  implements o
{
  private int WHP;
  private String WJa;
  private Map<Long, Long> WJb;
  private Map<Long, Set<Long>> WJc;
  private List<Long> WJd;
  private List<ca> WJe = null;
  
  private boolean b(ca paramca1, ca paramca2)
  {
    AppMethodBeat.i(290193);
    if ((this.WJe == null) || (this.WJe.isEmpty()))
    {
      AppMethodBeat.o(290193);
      return false;
    }
    long l1 = ((ca)this.WJe.get(this.WJe.size() - 1)).field_msgId;
    long l2 = paramca1.field_msgId;
    long l3 = paramca2.field_msgId;
    paramca1 = paramca1.field_content;
    paramca2 = paramca2.field_content;
    if ((Util.isNullOrNil(paramca1)) || (Util.isNullOrNil(paramca2)))
    {
      AppMethodBeat.o(290193);
      return false;
    }
    paramca1 = com.tencent.mm.aj.b.b.Pa(paramca1);
    paramca2 = com.tencent.mm.aj.b.b.Pa(paramca2);
    if ((Util.nullAsNil(paramca1.fUd).equals(paramca2.fUd)) && (Util.nullAsNil(paramca1.title).equals(paramca2.title)) && (l2 >= l1) && (l3 > l2))
    {
      AppMethodBeat.o(290193);
      return true;
    }
    AppMethodBeat.o(290193);
    return false;
  }
  
  private void hPc()
  {
    AppMethodBeat.i(290196);
    if ((this.WJb != null) && (this.WJc != null) && (this.WJd != null))
    {
      AppMethodBeat.o(290196);
      return;
    }
    long l3 = System.currentTimeMillis();
    for (;;)
    {
      HashMap localHashMap;
      long l1;
      int k;
      ca localca;
      try
      {
        if ((this.WJb != null) && (this.WJc != null) && (this.WJd != null)) {
          return;
        }
        this.WJb = new HashMap();
        this.WJc = new HashMap();
        this.WJd = new ArrayList();
        Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(this.fgR.getTalkerUserName());
        if ((localObject1 != null) && (((bb)localObject1).field_unReadCount > 0))
        {
          i = Math.min(((bb)localObject1).field_unReadCount, 100);
          if (i > 0) {
            this.WJe = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().eZ(this.fgR.getTalkerUserName(), i);
          }
        }
        if ((this.WJe == null) || (this.WJe.isEmpty())) {
          return;
        }
        Log.i("MicroMsg.ChattingServiceNotifyComponent", "unread msg count: %d", new Object[] { Integer.valueOf(this.WJe.size()) });
        localHashMap = new HashMap();
        localObject4 = null;
        l1 = 0L;
        k = 0;
        localObject1 = null;
        i = 0;
        if (i >= Math.min(this.WJe.size(), 200)) {
          break label825;
        }
        localca = (ca)this.WJe.get(i);
        localObject5 = null;
        if (i + 1 < this.WJe.size()) {
          localObject5 = (ca)this.WJe.get(i + 1);
        }
        if (localObject5 == null) {
          break label646;
        }
        if (b((ca)localObject5, localca))
        {
          if (k != 0) {
            break label956;
          }
          l1 = localca.field_msgId;
          localObject1 = new HashSet();
          k = 1;
          localHashMap.put(Long.valueOf(l1), Long.valueOf(((et)localObject5).field_msgId));
          ((Set)localObject1).add(Long.valueOf(((et)localObject5).field_msgId));
          ((Set)localObject1).add(Long.valueOf(l1));
          if (((Set)localObject1).size() < 10) {
            break label975;
          }
          if (localObject1 != null) {
            this.WJc.put(Long.valueOf(((et)localObject5).field_msgId), localObject1);
          }
          j = 0;
          k = i + 1;
          localObject1 = null;
          localObject4 = localObject5;
          i = j;
          j = k;
          if (!this.WJd.contains(Long.valueOf(localca.field_msgId))) {
            this.WJd.add(Long.valueOf(localca.field_msgId));
          }
          if (this.WJd.contains(Long.valueOf(((et)localObject5).field_msgId))) {
            break label959;
          }
          this.WJd.add(Long.valueOf(((et)localObject5).field_msgId));
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
          break label623;
        }
      }
      finally
      {
        AppMethodBeat.o(290196);
      }
      this.WJc.put(Long.valueOf(localca.field_msgId), localObject2);
      label623:
      Object localObject3 = null;
      Object localObject4 = localca;
      for (;;)
      {
        j = 0;
        l2 = l1;
        m = i;
        localObject5 = localObject4;
        break;
        label646:
        if (localObject4 == null) {
          break label940;
        }
        if ((b(localca, localObject4)) && (k != 0))
        {
          localHashMap.put(Long.valueOf(l1), Long.valueOf(localca.field_msgId));
          if (localObject3 == null) {}
          for (Object localObject6 = new HashSet();; localObject6 = localObject3)
          {
            this.WJc.put(Long.valueOf(localca.field_msgId), localObject6);
            ((Set)localObject6).add(Long.valueOf(localca.field_msgId));
            ((Set)localObject6).add(Long.valueOf(l1));
            j = k;
            l2 = l1;
            m = i;
            localObject3 = localObject6;
            localObject5 = localObject4;
            if (this.WJd.contains(Long.valueOf(localca.field_msgId))) {
              break;
            }
            this.WJd.add(Long.valueOf(localca.field_msgId));
            j = k;
            l2 = l1;
            m = i;
            localObject3 = localObject6;
            localObject5 = localObject4;
            break;
            label825:
            this.WJb.putAll(localHashMap);
            localHashMap.clear();
            Log.i("MicroMsg.ChattingServiceNotifyComponent", "initMessageGroupInfo cost: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
            Log.i("MicroMsg.ChattingServiceNotifyComponent", "end to head msg id size: %d, group by info size: %d, msg in group total size: %d", new Object[] { Integer.valueOf(this.WJb.size()), Integer.valueOf(this.WJc.size()), Integer.valueOf(this.WJd.size()) });
            AppMethodBeat.o(290196);
            return;
          }
        }
      }
      label940:
      int j = k;
      long l2 = l1;
      int m = i;
      Object localObject5 = localObject4;
      continue;
      label956:
      continue;
      label959:
      m = j;
      j = i;
      l2 = l1;
      localObject5 = localObject4;
      continue;
      label975:
      localObject4 = localca;
      j = i;
      int i = k;
    }
  }
  
  public final long VF(long paramLong)
  {
    AppMethodBeat.i(290184);
    if (!hPa())
    {
      AppMethodBeat.o(290184);
      return -1L;
    }
    hPc();
    Long localLong = (Long)this.WJb.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(290184);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(290184);
    return paramLong;
  }
  
  public final Set<Long> VG(long paramLong)
  {
    AppMethodBeat.i(290185);
    if (!hPa())
    {
      AppMethodBeat.o(290185);
      return null;
    }
    hPc();
    Set localSet = (Set)this.WJc.get(Long.valueOf(paramLong));
    AppMethodBeat.o(290185);
    return localSet;
  }
  
  public final List<ca> VH(long paramLong)
  {
    AppMethodBeat.i(290186);
    ArrayList localArrayList = new ArrayList();
    if (!hPa())
    {
      AppMethodBeat.o(290186);
      return localArrayList;
    }
    Set localSet;
    if (!hPa()) {
      localSet = null;
    }
    while (localSet == null)
    {
      AppMethodBeat.o(290186);
      return localArrayList;
      paramLong = VF(paramLong);
      if (paramLong <= 0L) {
        localSet = null;
      } else {
        localSet = VG(paramLong);
      }
    }
    Iterator localIterator = this.WJe.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      if (localSet.contains(Long.valueOf(localca.field_msgId))) {
        localArrayList.add(localca);
      }
    }
    AppMethodBeat.o(290186);
    return localArrayList;
  }
  
  public final boolean VI(long paramLong)
  {
    AppMethodBeat.i(290188);
    if (!hPa())
    {
      AppMethodBeat.o(290188);
      return false;
    }
    hPc();
    boolean bool = this.WJd.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(290188);
    return bool;
  }
  
  public final boolean a(ca paramca1, ca paramca2)
  {
    AppMethodBeat.i(290183);
    if (!hPa())
    {
      AppMethodBeat.o(290183);
      return false;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "checkIfNeedGroupMsg");
    hPc();
    boolean bool = b(paramca1, paramca2);
    AppMethodBeat.o(290183);
    return bool;
  }
  
  public final void ay(long paramLong, int paramInt)
  {
    AppMethodBeat.i(290189);
    if (!hPa())
    {
      AppMethodBeat.o(290189);
      return;
    }
    if ((this.WJb == null) || (this.WJd == null) || (this.WJc == null))
    {
      AppMethodBeat.o(290189);
      return;
    }
    Object localObject = (Long)this.WJb.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      if (paramLong < ((Long)localObject).longValue())
      {
        Log.e("MicroMsg.ChattingServiceNotifyComponent", "head msg id is large than end msg id!");
        AppMethodBeat.o(290189);
        return;
      }
      for (long l = ((Long)localObject).longValue(); l <= paramLong; l += 1L) {
        this.WJd.remove(Long.valueOf(l));
      }
    }
    localObject = (Set)this.WJc.remove(localObject);
    int i = 0;
    if (localObject != null) {
      i = paramInt - ((Set)localObject).size() + 1;
    }
    localObject = (k)this.fgR.bC(k.class);
    if (localObject != null) {
      ((k)localObject).avv(i);
    }
    AppMethodBeat.o(290189);
  }
  
  public final void c(int paramInt, ca paramca)
  {
    int k = 2;
    AppMethodBeat.i(290190);
    if (!hPa())
    {
      AppMethodBeat.o(290190);
      return;
    }
    long l = VF(paramca.field_msgId);
    if (this.WJc.get(Long.valueOf(l)) == null) {}
    for (int j = 0; l < 0L; j = ((Set)this.WJc.get(Long.valueOf(l))).size())
    {
      AppMethodBeat.o(290190);
      return;
    }
    paramca = com.tencent.mm.aj.b.b.Pa(paramca.field_content);
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    String str1;
    String str2;
    switch (paramca.lqG)
    {
    default: 
      i = 0;
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      str1 = paramca.fUd;
      str2 = paramca.lnb;
      if ((paramca.opType != 1) || (TextUtils.isEmpty(paramca.lpP))) {
        break;
      }
    }
    for (;;)
    {
      localh.a(22906, new Object[] { Integer.valueOf(paramInt), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(290190);
      return;
      i = 2;
      break;
      i = 3;
      break;
      k = 1;
    }
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(290175);
    super.hGU();
    this.WJa = this.fgR.WQv.getStringExtra("key_notify_message_real_username");
    if ((!hOZ()) && (!hPa()))
    {
      AppMethodBeat.o(290175);
      return;
    }
    this.WHP = 0;
    AppMethodBeat.o(290175);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(290192);
    super.hGV();
    if (!hPa())
    {
      AppMethodBeat.o(290192);
      return;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "onChattingEnterAnimStart");
    hPc();
    AppMethodBeat.o(290192);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(290176);
    super.hHa();
    if (!hPa())
    {
      AppMethodBeat.o(290176);
      return;
    }
    Log.i("MicroMsg.ChattingServiceNotifyComponent", "onChattingExitAnimEnd");
    int j = ((k)this.fgR.bC(k.class)).getCount();
    int i = j - this.WHP;
    while (i < j)
    {
      ca localca = ((k)this.fgR.bC(k.class)).avt(i);
      if ((localca != null) && (this.WJb != null) && (this.WJb.containsKey(Long.valueOf(localca.field_msgId)))) {
        c(1, localca);
      }
      i += 1;
    }
    if (this.WJb != null) {
      this.WJb.clear();
    }
    this.WJb = null;
    if (this.WJc != null) {
      this.WJc.clear();
    }
    this.WJc = null;
    if (this.WJd != null) {
      this.WJd.clear();
    }
    this.WJd = null;
    try
    {
      if (this.WJe != null) {
        this.WJe.clear();
      }
      this.WJe = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(290176);
    }
  }
  
  public final boolean hOY()
  {
    AppMethodBeat.i(290179);
    if (!hOZ())
    {
      AppMethodBeat.o(290179);
      return false;
    }
    ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hPP();
    AppMethodBeat.o(290179);
    return true;
  }
  
  public final boolean hOZ()
  {
    AppMethodBeat.i(290180);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(290180);
      return false;
    }
    if ((ab.QQ(this.fgR.getTalkerUserName())) && (!Util.isNullOrNil(this.WJa)))
    {
      AppMethodBeat.o(290180);
      return true;
    }
    AppMethodBeat.o(290180);
    return false;
  }
  
  public final boolean hPa()
  {
    AppMethodBeat.i(290181);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(290181);
      return false;
    }
    boolean bool = ab.QQ(this.fgR.getTalkerUserName());
    AppMethodBeat.o(290181);
    return bool;
  }
  
  public final String hPb()
  {
    return this.WJa;
  }
  
  public final void m(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(290178);
    if (!hOZ())
    {
      AppMethodBeat.o(290178);
      return;
    }
    if (Util.isNullOrNil(this.WJa))
    {
      Log.e("MicroMsg.ChattingServiceNotifyComponent", "username is null");
      AppMethodBeat.o(290178);
      return;
    }
    final boolean bool = as.OS(this.WJa);
    final Activity localActivity = this.fgR.WQv.getContext();
    Object localObject = paramLinearLayout.findViewById(R.h.dyZ);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(R.h.dRr);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(R.h.profile_name);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(R.h.dRB);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275439);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (bool) {
            r.a(r.this, localActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(21825, new Object[] { Integer.valueOf(6), r.a(r.this), Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(275439);
            return;
            r.b(r.this, localActivity);
          }
        }
      });
    }
    if (localImageView != null) {
      a.b.d(localImageView, this.WJa);
    }
    paramLinearLayout = "";
    if (localTextView2 != null)
    {
      if (bool)
      {
        localObject = y.afd(this.WJa);
        if (localObject != null) {
          paramLinearLayout = ((ae)localObject).nickname;
        }
        localTextView2.setText(com.tencent.mm.model.aa.PJ(paramLinearLayout));
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
      AppMethodBeat.o(290178);
      return;
      paramLinearLayout = com.tencent.mm.model.aa.PJ(this.WJa);
      break;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(290191);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (!hOZ())
    {
      AppMethodBeat.o(290191);
      return;
    }
    if ((paramInt1 == 100) && (paramIntent != null))
    {
      Log.i("MicroMsg.ChattingServiceNotifyComponent", "receive data from subscribe msg");
      paramIntent = (SubscribeMsgSettingData)paramIntent.getParcelableExtra("key_biz_data");
      if (paramIntent != null)
      {
        d locald = d.mtA;
        d.a(this.WJa, paramIntent, new am(this.fgR.WQv.getContext(), this.WJa));
      }
    }
    AppMethodBeat.o(290191);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(290177);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!hPa())
    {
      AppMethodBeat.o(290177);
      return;
    }
    this.WHP = Math.max(this.WHP, paramInt3 - paramInt1);
    AppMethodBeat.o(290177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.r
 * JD-Core Version:    0.7.0.1
 */