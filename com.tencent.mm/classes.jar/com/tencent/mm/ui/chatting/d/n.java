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
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ad.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ah.class)
public class n
  extends a
  implements ah
{
  private Set<Long> Pol;
  private Map<Long, czg> Pom;
  private Animation Pon;
  private Vibrator paT;
  
  public n()
  {
    AppMethodBeat.i(233077);
    this.Pol = new HashSet();
    this.Pom = new HashMap();
    this.Pon = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771991);
    this.paT = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(233077);
  }
  
  private static Pair<Integer, Integer> O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(233084);
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
    AppMethodBeat.o(233084);
    return paramViewGroup;
  }
  
  private static czg a(czg paramczg1, czg paramczg2)
  {
    AppMethodBeat.i(233083);
    czg localczg = new czg();
    int j = Math.min(paramczg2.yVw.size(), paramczg1.yVw.size());
    localczg.gnh = paramczg1.gnh;
    int i = 0;
    while (i < j)
    {
      localczg.yVw.add(paramczg2.yVw.get(i));
      ((czh)localczg.yVw.get(i)).MEB = ((czh)paramczg1.yVw.get(i)).MEB;
      i += 1;
    }
    if (paramczg2.yVw.size() >= paramczg1.yVw.size())
    {
      i = j;
      while (i < paramczg2.yVw.size())
      {
        localczg.yVw.add(paramczg2.yVw.get(i));
        i += 1;
      }
    }
    Log.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", new Object[] { Integer.valueOf(paramczg2.yVw.size()), Integer.valueOf(paramczg1.yVw.size()) });
    AppMethodBeat.o(233083);
    return localczg;
  }
  
  public final boolean Nv(long paramLong)
  {
    AppMethodBeat.i(233078);
    boolean bool = this.Pol.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(233078);
    return bool;
  }
  
  public final void Nw(long paramLong)
  {
    AppMethodBeat.i(233079);
    this.Pol.add(Long.valueOf(paramLong));
    AppMethodBeat.o(233079);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(233080);
    super.a(parama);
    AppMethodBeat.o(233080);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(233081);
    super.gOK();
    AppMethodBeat.o(233081);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(233082);
    super.onFinish();
    Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.Pol.clear();
    ((PluginPatMsg)com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).clearTemplate();
    if (!this.Pom.isEmpty())
    {
      Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.Pom.keySet() });
      final HashMap localHashMap = new HashMap(this.Pom);
      this.Pom.clear();
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233076);
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
            if (localca.field_msgId == l)
            {
              czg localczg = ((b)com.tencent.mm.kernel.g.af(b.class)).aJJ(localca.field_content);
              localczg = n.b((czg)localHashMap.get(Long.valueOf(l)), localczg);
              localca.setContent(((b)com.tencent.mm.kernel.g.af(b.class)).a(localczg));
              localca.setType(922746929);
              ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(l, localca);
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(233076);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(233082);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233085);
    Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.dom.getHeaderViewsCount()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = Util.currentTicks();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      try
      {
        localHashMap = new HashMap();
        localObject = new HashSet();
        String str = z.aTY();
        ca localca1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEx(this.dom.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label782;
        }
        paramAbsListView = this.dom.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1107;
        }
        if ((paramAbsListView.getTag() instanceof ad.a))
        {
          long l3 = Util.currentTicks();
          paramAbsListView = (ad.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.PLB.getTag()).longValue();
          Pair localPair = O(paramAbsListView.xUE);
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", new Object[] { Long.valueOf(l2), localPair.first, localPair.second });
          ca localca2 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l2);
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
          l3 = Util.currentTicks();
          paramAbsListView = (czg)this.Pom.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1095;
          }
          paramAbsListView = ((b)com.tencent.mm.kernel.g.af(b.class)).aJJ(localca2.field_content);
          if (l2 == localca1.field_msgId)
          {
            Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            paramAbsListView = a(paramAbsListView, ((b)com.tencent.mm.kernel.g.af(b.class)).aJJ(localca1.field_content));
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            l3 = Util.currentTicks();
            if (((Integer)localPair.first).intValue() <= ((Integer)localPair.second).intValue())
            {
              paramInt3 = ((Integer)localPair.first).intValue();
              if (paramInt3 <= ((Integer)localPair.second).intValue())
              {
                Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(localca2.field_msgId), Integer.valueOf(paramInt3) });
                if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.yVw.size())) {
                  break label1098;
                }
                if ((!str.equals(((czh)paramAbsListView.yVw.get(paramInt3)).dRL)) && (str.equals(((czh)paramAbsListView.yVw.get(paramInt3)).MEA)) && (((czh)paramAbsListView.yVw.get(paramInt3)).MEB == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                  localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
                }
                ((czh)paramAbsListView.yVw.get(paramInt3)).MEB = 1;
                break label1098;
              }
            }
          }
          else
          {
            if (!((b)com.tencent.mm.kernel.g.af(b.class)).HD(l2)) {
              break label1092;
            }
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            break label1107;
          }
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
          this.Pom.put(Long.valueOf(localca2.field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        Log.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(233085);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).chattingItem.gTT()))
      {
        ((HashSet)localObject).add(Integer.valueOf(paramInt1));
        break label1107;
        label782:
        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
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
        Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
        paramAbsListView = paramAbsListView.iterator();
        while (paramAbsListView.hasNext())
        {
          paramInt1 = ((Integer)paramAbsListView.next()).intValue();
          if (paramInt1 >= 0)
          {
            localObject = (c.a)this.dom.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject).avatarIV.getAnimation() == null) || (((c.a)localObject).avatarIV.getAnimation().hasEnded()))
            {
              ((c.a)localObject).avatarIV.startAnimation(this.Pon);
              if (!com.tencent.mm.n.g.Er(this.dom.getTalkerUserName())) {
                this.paT.vibrate(10L);
              }
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(233085);
        return;
        label1092:
        continue;
        label1095:
        continue;
        label1098:
        paramInt3 += 1;
        continue;
      }
      label1107:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.n
 * JD-Core Version:    0.7.0.1
 */