package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import com.tencent.mm.ui.chatting.viewitems.w.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ad.class)
public class l
  extends a
  implements ad
{
  private Set<Long> HTv;
  private Map<Long, cdh> HTw;
  private Animation HTx;
  private Vibrator njY;
  
  public l()
  {
    AppMethodBeat.i(196461);
    this.HTv = new HashSet();
    this.HTw = new HashMap();
    this.HTx = AnimationUtils.loadAnimation(ai.getContext(), 2130772172);
    this.njY = ((Vibrator)ai.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(196461);
  }
  
  private static void a(cdh paramcdh1, cdh paramcdh2)
  {
    AppMethodBeat.i(196467);
    if (paramcdh2.ulR.size() > paramcdh1.ulR.size())
    {
      int i = paramcdh1.ulR.size();
      while (i < paramcdh2.ulR.size())
      {
        paramcdh1.ulR.add(paramcdh2.ulR.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(196467);
  }
  
  public final boolean Be(long paramLong)
  {
    AppMethodBeat.i(196462);
    boolean bool = this.HTv.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(196462);
    return bool;
  }
  
  public final void Bf(long paramLong)
  {
    AppMethodBeat.i(196463);
    this.HTv.add(Long.valueOf(paramLong));
    AppMethodBeat.o(196463);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(196464);
    super.a(parama);
    AppMethodBeat.o(196464);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(196465);
    super.fmj();
    AppMethodBeat.o(196465);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(196466);
    super.onFinish();
    ac.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.HTv.clear();
    ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).dch();
    if (!this.HTw.isEmpty())
    {
      ac.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.HTw.keySet() });
      final HashMap localHashMap = new HashMap(this.HTw);
      this.HTw.clear();
      com.tencent.e.h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196460);
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            bo localbo = ((k)g.ab(k.class)).dcr().vP(l);
            if (localbo.field_msgId == l)
            {
              cdh localcdh1 = ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).akH(localbo.field_content);
              cdh localcdh2 = (cdh)localHashMap.get(Long.valueOf(l));
              l.b(localcdh2, localcdh1);
              ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "update msg %d, before %s", new Object[] { Long.valueOf(localbo.field_msgId), localbo.field_content });
              ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "update msg %d, after %s", new Object[] { Long.valueOf(localbo.field_msgId), ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).a(localcdh2) });
              localbo.setContent(((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).a(localcdh2));
              ((k)g.ab(k.class)).dcr().a(l, localbo);
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(196460);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(196466);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196468);
    ac.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.cLy.getHeaderViewsCount()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = bs.Gn();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject1;
      try
      {
        localHashMap = new HashMap();
        localObject1 = new HashSet();
        String str = u.axw();
        bo localbo = ((k)g.ab(k.class)).dcr().alk(this.cLy.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label781;
        }
        paramAbsListView = this.cLy.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1103;
        }
        if ((paramAbsListView.getTag() instanceof w.a))
        {
          long l3 = bs.Gn();
          paramAbsListView = (w.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.Imm.getTag()).longValue();
          Object localObject2 = new Rect();
          paramAbsListView.Iml.getLocalVisibleRect((Rect)localObject2);
          paramInt3 = paramAbsListView.Iml.getLayout().getLineForVertical(((Rect)localObject2).top);
          int i = paramAbsListView.Iml.getLayout().getLineForVertical(((Rect)localObject2).bottom);
          ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, rect %s, line %d-%d", new Object[] { Long.valueOf(l2), localObject2, Integer.valueOf(paramInt3), Integer.valueOf(i) });
          localObject2 = ((k)g.ab(k.class)).dcr().vP(l2);
          ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bs.aO(l3)) });
          l3 = bs.Gn();
          paramAbsListView = (cdh)this.HTw.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1091;
          }
          paramAbsListView = ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).akH(((dy)localObject2).field_content);
          if (l2 == localbo.field_msgId)
          {
            ac.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            a(paramAbsListView, ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).akH(localbo.field_content));
            ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bs.aO(l3)) });
            l3 = bs.Gn();
            if (paramInt3 <= i)
            {
              ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(((dy)localObject2).field_msgId), Integer.valueOf(paramInt3) });
              if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.ulR.size())) {
                break label1094;
              }
              if ((!str.equals(((cdi)paramAbsListView.ulR.get(paramInt3)).dng)) && (str.equals(((cdi)paramAbsListView.ulR.get(paramInt3)).FrZ)) && (((cdi)paramAbsListView.ulR.get(paramInt3)).Fsa == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
              }
              ((cdi)paramAbsListView.ulR.get(paramInt3)).Fsa = 1;
              break label1094;
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).vO(l2)) {
              continue;
            }
            ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bs.aO(l3)) });
            break label1103;
          }
          ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bs.aO(l3)) });
          this.HTw.put(Long.valueOf(((dy)localObject2).field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        ac.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(196468);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).IhY.fqu()))
      {
        ((HashSet)localObject1).add(Integer.valueOf(paramInt1));
        break label1103;
        label781:
        ac.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(bs.aO(l1)) });
        paramAbsListView = ((HashSet)localObject1).iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramInt2 = ((Integer)((Iterator)localObject1).next()).intValue();
            paramInt3 = ((Integer)localHashMap.get(Integer.valueOf(paramInt2))).intValue();
            if (paramInt3 == -1) {
              localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
            } else if (Math.abs(paramInt2 - paramInt1) < Math.abs(paramInt2 - paramInt3)) {
              localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
            }
          }
        }
        paramAbsListView = new HashSet(localHashMap.values());
        ac.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
        paramAbsListView = paramAbsListView.iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          if (paramInt1 >= 0)
          {
            localObject1 = (c.a)this.cLy.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject1).IhT.getAnimation() == null) || (((c.a)localObject1).IhT.getAnimation().hasEnded()))
            {
              ((c.a)localObject1).IhT.startAnimation(this.HTx);
              if (!f.sR(this.cLy.getTalkerUserName())) {
                this.njY.vibrate(10L);
              }
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(196468);
        return;
        label1091:
        continue;
        label1094:
        paramInt3 += 1;
        continue;
      }
      label1103:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.l
 * JD-Core Version:    0.7.0.1
 */