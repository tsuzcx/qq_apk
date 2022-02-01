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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.z;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ag.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ai.class)
public class o
  extends a
  implements ai
{
  private Animation WIA;
  private Set<Long> WIy;
  private Map<Long, dit> WIz;
  private Vibrator rqC;
  
  public o()
  {
    AppMethodBeat.i(288413);
    this.WIy = new HashSet();
    this.WIz = new HashMap();
    this.WIA = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.anim_rotate_avatar_right);
    this.rqC = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(288413);
  }
  
  private static Pair<Integer, Integer> W(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(288423);
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
    AppMethodBeat.o(288423);
    return paramViewGroup;
  }
  
  private static dit a(dit paramdit1, dit paramdit2)
  {
    AppMethodBeat.i(288422);
    dit localdit = new dit();
    int j = Math.min(paramdit2.Ezu.size(), paramdit1.Ezu.size());
    localdit.iRq = paramdit1.iRq;
    int i = 0;
    while (i < j)
    {
      localdit.Ezu.add(paramdit2.Ezu.get(i));
      ((diu)localdit.Ezu.get(i)).TQl = ((diu)paramdit1.Ezu.get(i)).TQl;
      i += 1;
    }
    if (paramdit2.Ezu.size() >= paramdit1.Ezu.size())
    {
      i = j;
      while (i < paramdit2.Ezu.size())
      {
        localdit.Ezu.add(paramdit2.Ezu.get(i));
        i += 1;
      }
    }
    Log.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", new Object[] { Integer.valueOf(paramdit2.Ezu.size()), Integer.valueOf(paramdit1.Ezu.size()) });
    AppMethodBeat.o(288422);
    return localdit;
  }
  
  public final boolean VD(long paramLong)
  {
    AppMethodBeat.i(288414);
    boolean bool = this.WIy.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(288414);
    return bool;
  }
  
  public final void VE(long paramLong)
  {
    AppMethodBeat.i(288416);
    this.WIy.add(Long.valueOf(paramLong));
    AppMethodBeat.o(288416);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(288418);
    super.a(parama);
    AppMethodBeat.o(288418);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(288420);
    super.hNZ();
    AppMethodBeat.o(288420);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(288421);
    super.onFinish();
    Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.WIy.clear();
    ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).clearTemplate();
    if (!this.WIz.isEmpty())
    {
      Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.WIz.keySet() });
      final HashMap localHashMap = new HashMap(this.WIz);
      this.WIz.clear();
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271266);
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            long l = ((Long)localIterator.next()).longValue();
            ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
            if (localca.field_msgId == l)
            {
              dit localdit = ((b)com.tencent.mm.kernel.h.ae(b.class)).aUf(localca.field_content);
              localdit = o.b((dit)localHashMap.get(Long.valueOf(l)), localdit);
              localca.setContent(((b)com.tencent.mm.kernel.h.ae(b.class)).a(localdit));
              localca.setType(922746929);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(l, localca);
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(271266);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(288421);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(288425);
    Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.fgR.hMq()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = Util.currentTicks();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      try
      {
        localHashMap = new HashMap();
        localObject = new HashSet();
        String str = z.bcZ();
        ca localca1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(this.fgR.getTalkerUserName());
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label784;
        }
        paramAbsListView = this.fgR.getChildAt(paramInt1);
        if ((paramAbsListView == null) || (paramAbsListView.getTag() == null)) {
          break label1110;
        }
        if ((paramAbsListView.getTag() instanceof ag.a))
        {
          long l3 = Util.currentTicks();
          paramAbsListView = (ag.a)paramAbsListView.getTag();
          long l2 = ((Long)paramAbsListView.Xhv.getTag()).longValue();
          Pair localPair = W(paramAbsListView.CYP);
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", new Object[] { Long.valueOf(l2), localPair.first, localPair.second });
          ca localca2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l2);
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
          l3 = Util.currentTicks();
          paramAbsListView = (dit)this.WIz.get(Long.valueOf(l2));
          if (paramAbsListView != null) {
            break label1098;
          }
          paramAbsListView = ((b)com.tencent.mm.kernel.h.ae(b.class)).aUf(localca2.field_content);
          if (l2 == localca1.field_msgId)
          {
            Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
            paramAbsListView = a(paramAbsListView, ((b)com.tencent.mm.kernel.h.ae(b.class)).aUf(localca1.field_content));
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            l3 = Util.currentTicks();
            if (((Integer)localPair.first).intValue() <= ((Integer)localPair.second).intValue())
            {
              paramInt3 = ((Integer)localPair.first).intValue();
              if (paramInt3 <= ((Integer)localPair.second).intValue())
              {
                Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(localca2.field_msgId), Integer.valueOf(paramInt3) });
                if ((paramInt3 < 0) || (paramInt3 >= paramAbsListView.Ezu.size())) {
                  break label1101;
                }
                if ((!str.equals(((diu)paramAbsListView.Ezu.get(paramInt3)).fLi)) && (str.equals(((diu)paramAbsListView.Ezu.get(paramInt3)).TQk)) && (((diu)paramAbsListView.Ezu.get(paramInt3)).TQl == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                  localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
                }
                ((diu)paramAbsListView.Ezu.get(paramInt3)).TQl = 1;
                break label1101;
              }
            }
          }
          else
          {
            if (!((b)com.tencent.mm.kernel.h.ae(b.class)).OX(l2)) {
              break label1095;
            }
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            break label1110;
          }
          Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
          this.WIz.put(Long.valueOf(localca2.field_msgId), paramAbsListView);
        }
      }
      catch (Exception paramAbsListView)
      {
        Log.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(288425);
        return;
      }
      if (((paramAbsListView.getTag() instanceof c.a)) && (((c.a)paramAbsListView.getTag()).chattingItem.hTD()))
      {
        ((HashSet)localObject).add(Integer.valueOf(paramInt1));
        break label1110;
        label784:
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
            localObject = (c.a)this.fgR.getChildAt(paramInt1).getTag();
            if ((((c.a)localObject).avatarIV.getAnimation() == null) || (((c.a)localObject).avatarIV.getAnimation().hasEnded()))
            {
              ((c.a)localObject).avatarIV.startAnimation(this.WIA);
              if (!g.Lk(this.fgR.getTalkerUserName())) {
                this.rqC.vibrate(10L);
              }
            }
          }
        }
        localHashMap.clear();
        AppMethodBeat.o(288425);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o
 * JD-Core Version:    0.7.0.1
 */