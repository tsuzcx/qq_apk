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
import com.tencent.mm.model.u;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
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

@com.tencent.mm.ui.chatting.d.a.a(fFo=af.class)
public class n
  extends a
  implements af
{
  private Set<Long> JHS;
  private Map<Long, cif> JHT;
  private Animation JHU;
  private Vibrator nKv;
  
  public n()
  {
    AppMethodBeat.i(194005);
    this.JHS = new HashSet();
    this.JHT = new HashMap();
    this.JHU = AnimationUtils.loadAnimation(aj.getContext(), 2130772182);
    this.nKv = ((Vibrator)aj.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(194005);
  }
  
  private static Pair<Integer, Integer> E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(194012);
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
    AppMethodBeat.o(194012);
    return paramViewGroup;
  }
  
  private static cif a(cif paramcif1, cif paramcif2)
  {
    AppMethodBeat.i(194011);
    cif localcif = new cif();
    int j = Math.min(paramcif2.vox.size(), paramcif1.vox.size());
    localcif.fFR = paramcif1.fFR;
    int i = 0;
    while (i < j)
    {
      localcif.vox.add(paramcif2.vox.get(i));
      ((cig)localcif.vox.get(i)).Hce = ((cig)paramcif1.vox.get(i)).Hce;
      i += 1;
    }
    if (paramcif2.vox.size() >= paramcif1.vox.size())
    {
      i = j;
      while (i < paramcif2.vox.size())
      {
        localcif.vox.add(paramcif2.vox.get(i));
        i += 1;
      }
    }
    ad.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", new Object[] { Integer.valueOf(paramcif2.vox.size()), Integer.valueOf(paramcif1.vox.size()) });
    AppMethodBeat.o(194011);
    return localcif;
  }
  
  public final boolean DT(long paramLong)
  {
    AppMethodBeat.i(194006);
    boolean bool = this.JHS.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(194006);
    return bool;
  }
  
  public final void DU(long paramLong)
  {
    AppMethodBeat.i(194007);
    this.JHS.add(Long.valueOf(paramLong));
    AppMethodBeat.o(194007);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(194008);
    super.a(parama);
    AppMethodBeat.o(194008);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(194009);
    super.fCC();
    AppMethodBeat.o(194009);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(194010);
    super.onFinish();
    ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.JHS.clear();
    ((PluginPatMsg)g.ad(PluginPatMsg.class)).clearTemplate();
    if (!this.JHT.isEmpty())
    {
      ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.JHT.keySet() });
      final HashMap localHashMap = new HashMap(this.JHT);
      this.JHT.clear();
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194004);
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            bu localbu = ((l)g.ab(l.class)).dlK().xY(l);
            if (localbu.field_msgId == l)
            {
              cif localcif = ((b)g.ab(b.class)).auh(localbu.field_content);
              localcif = n.b((cif)localHashMap.get(Long.valueOf(l)), localcif);
              localbu.setContent(((b)g.ab(b.class)).a(localcif));
              localbu.setType(922746929);
              ((l)g.ab(l.class)).dlK().a(l, localbu);
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(194004);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(194010);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194013);
    ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.cWM.getHeaderViewsCount()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = bt.HI();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      try
      {
        localHashMap = new HashMap();
        localObject = new HashSet();
        String str = u.aAm();
        bu localbu1 = ((l)g.ab(l.class)).dlK().apX(this.cWM.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label784;
        }
        paramAbsListView = this.cWM.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1110;
        }
        if ((paramAbsListView.getTag() instanceof x.a))
        {
          long l3 = bt.HI();
          paramAbsListView = (x.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.KcK.getTag()).longValue();
          Pair localPair = E(paramAbsListView.urn);
          ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", new Object[] { Long.valueOf(l2), localPair.first, localPair.second });
          bu localbu2 = ((l)g.ab(l.class)).dlK().xY(l2);
          ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aO(l3)) });
          l3 = bt.HI();
          paramAbsListView = (cif)this.JHT.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1098;
          }
          paramAbsListView = ((b)g.ab(b.class)).auh(localbu2.field_content);
          if (l2 == localbu1.field_msgId)
          {
            ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            paramAbsListView = a(paramAbsListView, ((b)g.ab(b.class)).auh(localbu1.field_content));
            ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aO(l3)) });
            l3 = bt.HI();
            if (((Integer)localPair.first).intValue() <= ((Integer)localPair.second).intValue())
            {
              paramInt3 = ((Integer)localPair.first).intValue();
              if (paramInt3 <= ((Integer)localPair.second).intValue())
              {
                ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(localbu2.field_msgId), Integer.valueOf(paramInt3) });
                if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.vox.size())) {
                  break label1101;
                }
                if ((!str.equals(((cig)paramAbsListView.vox.get(paramInt3)).dyU)) && (str.equals(((cig)paramAbsListView.vox.get(paramInt3)).Hcd)) && (((cig)paramAbsListView.vox.get(paramInt3)).Hce == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                  localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
                }
                ((cig)paramAbsListView.vox.get(paramInt3)).Hce = 1;
                break label1101;
              }
            }
          }
          else
          {
            if (!((b)g.ab(b.class)).yr(l2)) {
              break label1095;
            }
            ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aO(l3)) });
            break label1110;
          }
          ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aO(l3)) });
          this.JHT.put(Long.valueOf(localbu2.field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        ad.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(194013);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).JYv.fHh()))
      {
        ((HashSet)localObject).add(Integer.valueOf(paramInt1));
        break label1110;
        label784:
        ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(bt.aO(l1)) });
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
        ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
        paramAbsListView = paramAbsListView.iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          if (paramInt1 >= 0)
          {
            localObject = (c.a)this.cWM.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject).JYo.getAnimation() == null) || (((c.a)localObject).JYo.getAnimation().hasEnded()))
            {
              ((c.a)localObject).JYo.startAnimation(this.JHU);
              if (!f.vG(this.cWM.getTalkerUserName())) {
                this.nKv.vibrate(10L);
              }
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(194013);
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