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
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=ad.class)
public class l
  extends a
  implements ad
{
  private Set<Long> GtC;
  private Map<Long, byl> GtD;
  private Animation GtE;
  private Vibrator mHT;
  
  public l()
  {
    AppMethodBeat.i(191506);
    this.GtC = new HashSet();
    this.GtD = new HashMap();
    this.GtE = AnimationUtils.loadAnimation(aj.getContext(), 2130772172);
    this.mHT = ((Vibrator)aj.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(191506);
  }
  
  private static void a(byl parambyl1, byl parambyl2)
  {
    AppMethodBeat.i(191512);
    if (parambyl2.tdC.size() > parambyl1.tdC.size())
    {
      int i = parambyl1.tdC.size();
      while (i < parambyl2.tdC.size())
      {
        parambyl1.tdC.add(parambyl2.tdC.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(191512);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(191509);
    super.a(parama);
    AppMethodBeat.o(191509);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(191510);
    super.eWx();
    AppMethodBeat.o(191510);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(191511);
    super.onFinish();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.GtC.clear();
    ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).cOy();
    if (!this.GtD.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.GtD.keySet() });
      com.tencent.e.h.Iye.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191505);
          Iterator localIterator = l.a(l.this).keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            bl localbl = ((k)g.ab(k.class)).cOI().rm(l);
            if (localbl.field_msgId == l)
            {
              byl localbyl1 = ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).afN(localbl.field_content);
              byl localbyl2 = (byl)l.a(l.this).get(Long.valueOf(l));
              l.b(localbyl2, localbyl1);
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "update msg %d, before %s", new Object[] { Long.valueOf(localbl.field_msgId), localbl.field_content });
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "update msg %d, after %s", new Object[] { Long.valueOf(localbl.field_msgId), ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).a(localbyl2) });
              localbl.setContent(((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).a(localbyl2));
              ((k)g.ab(k.class)).cOI().a(l, localbl);
            }
          }
          l.a(l.this).clear();
          AppMethodBeat.o(191505);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(191511);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191513);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.cOd.getHeaderViewsCount()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = bt.GC();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject1;
      try
      {
        localHashMap = new HashMap();
        localObject1 = new HashSet();
        String str = u.aqG();
        bl localbl = ((k)g.ab(k.class)).cOI().agq(this.cOd.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label781;
        }
        paramAbsListView = this.cOd.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1090;
        }
        if ((paramAbsListView.getTag() instanceof w.a))
        {
          long l3 = bt.GC();
          paramAbsListView = (w.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.GMp.getTag()).longValue();
          Object localObject2 = new Rect();
          paramAbsListView.GMo.getLocalVisibleRect((Rect)localObject2);
          paramInt3 = paramAbsListView.GMo.getLayout().getLineForVertical(((Rect)localObject2).top);
          int i = paramAbsListView.GMo.getLayout().getLineForVertical(((Rect)localObject2).bottom);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, rect %s, line %d-%d", new Object[] { Long.valueOf(l2), localObject2, Integer.valueOf(paramInt3), Integer.valueOf(i) });
          localObject2 = ((k)g.ab(k.class)).cOI().rm(l2);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aS(l3)) });
          l3 = bt.GC();
          paramAbsListView = (byl)this.GtD.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1078;
          }
          paramAbsListView = ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).afN(((du)localObject2).field_content);
          if (l2 == localbl.field_msgId)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            a(paramAbsListView, ((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).afN(localbl.field_content));
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aS(l3)) });
            l3 = bt.GC();
            if (paramInt3 <= i)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(((du)localObject2).field_msgId), Integer.valueOf(paramInt3) });
              if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.tdC.size())) {
                break label1081;
              }
              if ((!str.equals(((bym)paramAbsListView.tdC.get(paramInt3)).dpv)) && (str.equals(((bym)paramAbsListView.tdC.get(paramInt3)).DVl)) && (((bym)paramAbsListView.tdC.get(paramInt3)).DVm == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
              }
              ((bym)paramAbsListView.tdC.get(paramInt3)).DVm = 1;
              break label1081;
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.messenger.a.c)g.ab(com.tencent.mm.plugin.messenger.a.c.class)).rl(l2)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aS(l3)) });
            break label1090;
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(bt.aS(l3)) });
          this.GtD.put(Long.valueOf(((du)localObject2).field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(191513);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).GIb.faE()))
      {
        ((HashSet)localObject1).add(Integer.valueOf(paramInt1));
        break label1090;
        label781:
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(bt.aS(l1)) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
        paramAbsListView = paramAbsListView.iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          if (paramInt1 >= 0)
          {
            localObject1 = (c.a)this.cOd.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject1).GHW.getAnimation() == null) || (((c.a)localObject1).GHW.getAnimation().hasEnded()))
            {
              ((c.a)localObject1).GHW.startAnimation(this.GtE);
              this.mHT.vibrate(10L);
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(191513);
        return;
        label1078:
        continue;
        label1081:
        paramInt3 += 1;
        continue;
      }
      label1090:
      paramInt1 += 1;
    }
  }
  
  public final boolean wB(long paramLong)
  {
    AppMethodBeat.i(191507);
    boolean bool = this.GtC.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(191507);
    return bool;
  }
  
  public final void wC(long paramLong)
  {
    AppMethodBeat.i(191508);
    this.GtC.add(Long.valueOf(paramLong));
    AppMethodBeat.o(191508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.l
 * JD-Core Version:    0.7.0.1
 */