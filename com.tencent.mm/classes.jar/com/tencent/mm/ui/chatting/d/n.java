package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import com.tencent.mm.ui.chatting.viewitems.x.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(fJv=af.class)
public class n
  extends a
  implements af
{
  private Set<Long> KcO;
  private Map<Long, ciz> KcP;
  private Animation KcQ;
  private Vibrator nQa;
  
  public n()
  {
    AppMethodBeat.i(187317);
    this.KcO = new HashSet();
    this.KcP = new HashMap();
    this.KcQ = AnimationUtils.loadAnimation(ak.getContext(), 2130772182);
    this.nQa = ((Vibrator)ak.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(187317);
  }
  
  private static Pair<Integer, Integer> E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(187324);
    int j = 2147483647;
    int m = -2147483648;
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      Rect localRect = new Rect();
      localView.getLocalVisibleRect(localRect);
      int i1 = m;
      int n = j;
      if (localRect.height() > 0)
      {
        int k = j;
        if (i < j) {
          k = i;
        }
        i1 = m;
        n = k;
        if (i > m)
        {
          i1 = i;
          n = k;
        }
      }
      i += 1;
      m = i1;
      j = n;
    }
    paramViewGroup = Pair.create(Integer.valueOf(j), Integer.valueOf(m));
    AppMethodBeat.o(187324);
    return paramViewGroup;
  }
  
  private static ciz a(ciz paramciz1, ciz paramciz2)
  {
    AppMethodBeat.i(187323);
    ciz localciz = new ciz();
    int j = Math.min(paramciz2.vAC.size(), paramciz1.vAC.size());
    localciz.fHV = paramciz1.fHV;
    int i = 0;
    while (i < j)
    {
      localciz.vAC.add(paramciz2.vAC.get(i));
      ((cja)localciz.vAC.get(i)).HvE = ((cja)paramciz1.vAC.get(i)).HvE;
      i += 1;
    }
    if (paramciz2.vAC.size() >= paramciz1.vAC.size())
    {
      i = j;
      while (i < paramciz2.vAC.size())
      {
        localciz.vAC.add(paramciz2.vAC.get(i));
        i += 1;
      }
    }
    ae.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", new Object[] { Integer.valueOf(paramciz2.vAC.size()), Integer.valueOf(paramciz1.vAC.size()) });
    AppMethodBeat.o(187323);
    return localciz;
  }
  
  public final boolean Es(long paramLong)
  {
    AppMethodBeat.i(187318);
    boolean bool = this.KcO.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(187318);
    return bool;
  }
  
  public final void Et(long paramLong)
  {
    AppMethodBeat.i(187319);
    this.KcO.add(Long.valueOf(paramLong));
    AppMethodBeat.o(187319);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(187320);
    super.a(parama);
    AppMethodBeat.o(187320);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(187321);
    super.fGE();
    AppMethodBeat.o(187321);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(187322);
    super.onFinish();
    ae.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.KcO.clear();
    ((PluginPatMsg)g.ad(PluginPatMsg.class)).clearTemplate();
    if (!this.KcP.isEmpty())
    {
      ae.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.KcP.keySet() });
      final HashMap localHashMap = new HashMap(this.KcP);
      this.KcP.clear();
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187316);
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            bv localbv = ((l)g.ab(l.class)).doJ().ys(l);
            if (localbv.field_msgId == l)
            {
              ciz localciz = ((b)g.ab(b.class)).avw(localbv.field_content);
              localciz = n.b((ciz)localHashMap.get(Long.valueOf(l)), localciz);
              localbv.setContent(((b)g.ab(b.class)).a(localciz));
              localbv.setType(922746929);
              ((l)g.ab(l.class)).doJ().a(l, localbv);
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(187316);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(187322);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187325);
    ae.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.cXJ.getHeaderViewsCount()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = bu.HQ();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      try
      {
        localHashMap = new HashMap();
        localObject = new HashSet();
        String str = v.aAC();
        bv localbv1 = ((l)g.ab(l.class)).doJ().arc(this.cXJ.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label784;
        }
        paramAbsListView = this.cXJ.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1110;
        }
        if ((paramAbsListView.getTag() instanceof x.a))
        {
          long l3 = bu.HQ();
          paramAbsListView = (x.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.Kzc.getTag()).longValue();
          Pair localPair = E(paramAbsListView.uCG);
          ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", new Object[] { Long.valueOf(l2), localPair.first, localPair.second });
          bv localbv2 = ((l)g.ab(l.class)).doJ().ys(l2);
          ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bu.aO(l3)) });
          l3 = bu.HQ();
          paramAbsListView = (ciz)this.KcP.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1098;
          }
          paramAbsListView = ((b)g.ab(b.class)).avw(localbv2.field_content);
          if (l2 == localbv1.field_msgId)
          {
            ae.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            paramAbsListView = a(paramAbsListView, ((b)g.ab(b.class)).avw(localbv1.field_content));
            ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bu.aO(l3)) });
            l3 = bu.HQ();
            if (((Integer)localPair.first).intValue() <= ((Integer)localPair.second).intValue())
            {
              paramInt3 = ((Integer)localPair.first).intValue();
              if (paramInt3 <= ((Integer)localPair.second).intValue())
              {
                ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(localbv2.field_msgId), Integer.valueOf(paramInt3) });
                if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.vAC.size())) {
                  break label1101;
                }
                if ((!str.equals(((cja)paramAbsListView.vAC.get(paramInt3)).dzZ)) && (str.equals(((cja)paramAbsListView.vAC.get(paramInt3)).HvD)) && (((cja)paramAbsListView.vAC.get(paramInt3)).HvE == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                  localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
                }
                ((cja)paramAbsListView.vAC.get(paramInt3)).HvE = 1;
                break label1101;
              }
            }
          }
          else
          {
            if (!((b)g.ab(b.class)).yL(l2)) {
              break label1095;
            }
            ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bu.aO(l3)) });
            break label1110;
          }
          ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bu.aO(l3)) });
          this.KcP.put(Long.valueOf(localbv2.field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        ae.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(187325);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).KuO.fLz()))
      {
        ((HashSet)localObject).add(Integer.valueOf(paramInt1));
        break label1110;
        label784:
        ae.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(bu.aO(l1)) });
        paramAbsListView = ((HashSet)localObject).iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          localObject = localHashMap.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramInt2 = ((Integer)((Iterator)localObject).next()).intValue();
            paramInt3 = ((Integer)localHashMap.get(Integer.valueOf(paramInt2))).intValue();
            if (paramInt3 == -1) {
              localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
            } else if (Math.abs(paramInt2 - paramInt1) < Math.abs(paramInt2 - paramInt3)) {
              localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
            }
          }
        }
        paramAbsListView = new HashSet(localHashMap.values());
        ae.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
        paramAbsListView = paramAbsListView.iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          if (paramInt1 >= 0)
          {
            localObject = (c.a)this.cXJ.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject).KuH.getAnimation() == null) || (((c.a)localObject).KuH.getAnimation().hasEnded()))
            {
              ((c.a)localObject).KuH.startAnimation(this.KcQ);
              if (!f.wc(this.cXJ.getTalkerUserName())) {
                this.nQa.vibrate(10L);
              }
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(187325);
        return;
        label1095:
        continue;
        label1098:
        continue;
        label1101:
        paramInt3 += 1;
        continue;
      }
      label1110:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.n
 * JD-Core Version:    0.7.0.1
 */