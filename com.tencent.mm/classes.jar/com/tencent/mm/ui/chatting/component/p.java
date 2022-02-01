package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ae.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=al.class)
public class p
  extends a
  implements al
{
  private Set<Long> aeqE;
  private Map<Long, ebd> aeqF;
  private Animation aeqG;
  private Vibrator uAL;
  
  public p()
  {
    AppMethodBeat.i(256216);
    this.aeqE = new HashSet();
    this.aeqF = new HashMap();
    this.aeqG = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.anim_rotate_avatar_right);
    this.uAL = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    AppMethodBeat.o(256216);
  }
  
  private static ebd a(ebd paramebd1, ebd paramebd2)
  {
    AppMethodBeat.i(256223);
    ebd localebd = new ebd();
    int j = Math.min(paramebd2.Ksg.size(), paramebd1.Ksg.size());
    localebd.ltm = paramebd1.ltm;
    int i = 0;
    while (i < j)
    {
      localebd.Ksg.add((ebe)paramebd2.Ksg.get(i));
      ((ebe)localebd.Ksg.get(i)).abgJ = ((ebe)paramebd1.Ksg.get(i)).abgJ;
      i += 1;
    }
    if (paramebd2.Ksg.size() >= paramebd1.Ksg.size())
    {
      i = j;
      while (i < paramebd2.Ksg.size())
      {
        localebd.Ksg.add((ebe)paramebd2.Ksg.get(i));
        i += 1;
      }
    }
    Log.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", new Object[] { Integer.valueOf(paramebd2.Ksg.size()), Integer.valueOf(paramebd1.Ksg.size()) });
    AppMethodBeat.o(256223);
    return localebd;
  }
  
  private static Pair<Integer, Integer> ag(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256230);
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
    AppMethodBeat.o(256230);
    return paramViewGroup;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256246);
    super.a(parama);
    AppMethodBeat.o(256246);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256251);
    super.jqF();
    AppMethodBeat.o(256251);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(256259);
    super.onFinish();
    Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
    this.aeqE.clear();
    ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).clearTemplate();
    if (!this.aeqF.isEmpty())
    {
      Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", new Object[] { this.aeqF.keySet() });
      final HashMap localHashMap = new HashMap(this.aeqF);
      this.aeqF.clear();
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256001);
          Iterator localIterator = localHashMap.keySet().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              long l = ((Long)localIterator.next()).longValue();
              cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
              if ((localcc == null) || (localcc.field_msgId != l)) {
                continue;
              }
              ebd localebd = ((b)com.tencent.mm.kernel.h.ax(b.class)).aRl(localcc.field_content);
              localebd = p.b((ebd)localHashMap.get(Long.valueOf(l)), localebd);
              try
              {
                if (localebd.Ksg.size() > 0) {
                  ((ebe)localebd.Ksg.getLast()).abgL = 1;
                }
                localcc.setContent(((b)com.tencent.mm.kernel.h.ax(b.class)).a(localebd));
                localcc.setType(922746929);
                ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(l, localcc);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", localException, "", new Object[0]);
                }
              }
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(256001);
        }
      }, "updatePatMsgWhenExitChatting");
    }
    AppMethodBeat.o(256259);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256273);
    Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", new Object[] { Integer.valueOf(this.hlc.joT()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2 - 1) });
    long l1 = Util.currentTicks();
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      try
      {
        localHashMap = new HashMap();
        HashSet localHashSet = new HashSet();
        String str = z.bAM();
        paramAbsListView = null;
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          localObject = this.hlc.getChildAt(paramInt1);
          if ((localObject == null) || (((View)localObject).getTag() == null)) {
            break label1157;
          }
          if ((((View)localObject).getTag() instanceof ae.a))
          {
            if (paramAbsListView != null) {
              break label1132;
            }
            paramAbsListView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(this.hlc.getTalkerUserName());
            long l3 = Util.currentTicks();
            localObject = (ae.a)((View)localObject).getTag();
            long l2 = ((Long)((ae.a)localObject).aeRz.getTag()).longValue();
            Pair localPair = ag(((ae.a)localObject).ITf);
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", new Object[] { Long.valueOf(l2), localPair.first, localPair.second });
            cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l2);
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            l3 = Util.currentTicks();
            localObject = (ebd)this.aeqF.get(Long.valueOf(l2));
            if (localObject != null) {
              break label1138;
            }
            localObject = ((b)com.tencent.mm.kernel.h.ax(b.class)).aRl(localcc.field_content);
            if (l2 == paramAbsListView.field_msgId)
            {
              Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", new Object[] { Long.valueOf(l2) });
              localObject = a((ebd)localObject, ((b)com.tencent.mm.kernel.h.ax(b.class)).aRl(paramAbsListView.field_content));
              Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
              l3 = Util.currentTicks();
              if (((Integer)localPair.first).intValue() <= ((Integer)localPair.second).intValue())
              {
                paramInt3 = ((Integer)localPair.first).intValue();
                if (paramInt3 <= ((Integer)localPair.second).intValue())
                {
                  Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", new Object[] { Long.valueOf(localcc.field_msgId), Integer.valueOf(paramInt3) });
                  if ((paramInt3 < 0) || (paramInt3 >= ((ebd)localObject).Ksg.size())) {
                    break label1141;
                  }
                  if ((!str.equals(((ebe)((ebd)localObject).Ksg.get(paramInt3)).hQQ)) && (str.equals(((ebe)((ebd)localObject).Ksg.get(paramInt3)).abgI)) && (((ebe)((ebd)localObject).Ksg.get(paramInt3)).abgJ == 0) && (!localHashMap.containsKey(Integer.valueOf(paramInt1)))) {
                    localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(-1));
                  }
                  ((ebe)((ebd)localObject).Ksg.get(paramInt3)).abgJ = 1;
                  ((ebe)((ebd)localObject).Ksg.get(paramInt3)).abgL = 1;
                  break label1141;
                }
              }
            }
            else
            {
              if (!((b)com.tencent.mm.kernel.h.ax(b.class)).ta(l2)) {
                break label1135;
              }
              Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
              break;
            }
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", new Object[] { Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l3)) });
            this.aeqF.put(Long.valueOf(localcc.field_msgId), localObject);
            break;
          }
          if ((!(((View)localObject).getTag() instanceof c.a)) || (!((c.a)((View)localObject).getTag()).chattingItem.fXn())) {
            break label1157;
          }
          localHashSet.add(Integer.valueOf(paramInt1));
          break label1157;
        }
        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
        paramAbsListView = localHashSet.iterator();
        continue;
        if (!paramAbsListView.hasNext()) {
          break label982;
        }
        paramInt1 = ((Integer)paramAbsListView.next()).intValue();
        localObject = localHashMap.keySet().iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramInt2 = ((Integer)((Iterator)localObject).next()).intValue();
          paramInt3 = ((Integer)localHashMap.get(Integer.valueOf(paramInt2))).intValue();
          if (paramInt3 == -1) {
            localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
          }
        }
        else
        {
          continue;
        }
        if (Math.abs(paramInt2 - paramInt1) >= Math.abs(paramInt2 - paramInt3)) {
          continue;
        }
      }
      catch (Exception paramAbsListView)
      {
        Log.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", paramAbsListView, "", new Object[0]);
        AppMethodBeat.o(256273);
        return;
      }
      localHashMap.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      continue;
      label982:
      paramAbsListView = new HashSet(localHashMap.values());
      Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", new Object[] { paramAbsListView });
      paramAbsListView = paramAbsListView.iterator();
      while (paramAbsListView.hasNext())
      {
        paramInt1 = ((Integer)paramAbsListView.next()).intValue();
        if (paramInt1 >= 0)
        {
          localObject = (c.a)this.hlc.getChildAt(paramInt1).getTag();
          if ((((c.a)localObject).avatarIV.getAnimation() == null) || (((c.a)localObject).avatarIV.getAnimation().hasEnded()))
          {
            ((c.a)localObject).avatarIV.startAnimation(this.aeqG);
            if (!com.tencent.mm.k.h.DR(this.hlc.getTalkerUserName())) {
              this.uAL.vibrate(10L);
            }
          }
        }
      }
      localHashMap.clear();
      AppMethodBeat.o(256273);
      return;
      label1132:
      continue;
      label1135:
      continue;
      label1138:
      continue;
      label1141:
      paramInt3 += 1;
    }
    label1157:
    for (;;)
    {
      paramInt1 += 1;
      break;
    }
  }
  
  public final boolean zL(long paramLong)
  {
    AppMethodBeat.i(256240);
    boolean bool = this.aeqE.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(256240);
    return bool;
  }
  
  public final void zM(long paramLong)
  {
    AppMethodBeat.i(256244);
    this.aeqE.add(Long.valueOf(paramLong));
    AppMethodBeat.o(256244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.p
 * JD-Core Version:    0.7.0.1
 */