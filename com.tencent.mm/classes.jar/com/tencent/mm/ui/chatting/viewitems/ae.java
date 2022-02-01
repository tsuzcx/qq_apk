package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.lo;
import com.tencent.mm.autogen.mmdata.rpt.mc;
import com.tencent.mm.autogen.mmdata.rpt.mt;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b.a;
import com.tencent.mm.plugin.patmsg.a.f.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.al;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.util.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
  extends c
{
  private ae.a aeRw;
  
  private void a(com.tencent.mm.ui.chatting.d.a parama, ebe paramebe, MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(255174);
    Object localObject1 = z.bAM();
    boolean bool1 = ((PluginPatMsg)h.az(PluginPatMsg.class)).isNickClickable();
    Log.d("MicroMsg.ChattingItemAppMsgPat", "show template:%s, createTime:%d, readStatus:%d", new Object[] { paramebe.nVS, Long.valueOf(paramebe.createTime), Integer.valueOf(paramebe.abgJ) });
    Object localObject4 = ((PluginPatMsg)h.az(PluginPatMsg.class)).parseDisplayTemplate(paramebe, parama.getTalkerUserName());
    Object localObject2 = new SpannableString(((com.tencent.mm.plugin.patmsg.a.f)localObject4).result);
    boolean bool2 = paramebe.abgI.equals(localObject1);
    try
    {
      localObject1 = com.tencent.mm.modelpackage.u.bLI().OM(parama.getTalkerUserName());
      bh.bCz();
      i = ((Integer)com.tencent.mm.model.c.ban().d(12311, Integer.valueOf(-2))).intValue();
      j = parama.aezO.getMMResources().getColor(R.e.FG_1);
      if (localObject1 == null) {
        break label874;
      }
      if (((com.tencent.mm.modelpackage.a)localObject1).oQj != -2) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        int j;
        Object localObject3;
        parama = (com.tencent.mm.ui.chatting.d.a)localObject3;
        continue;
        if ((localException1 != null) || (i == -2)) {}
      }
    }
    paramMMNeat7extView.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.FG_0));
    paramMMNeat7extView.setBackground(parama.aezO.getContext().getResources().getDrawable(R.g.fno));
    j = parama.aezO.getMMResources().getColor(R.e.FG_0);
    i = 1;
    if (bool2) {
      ((SpannableString)localObject2).setSpan(new BoldForegroundColorSpan(j), 0, ((SpannableString)localObject2).length(), 17);
    }
    localObject1 = p.d(parama.aezO.getContext(), (CharSequence)localObject2, paramMMNeat7extView.getTextSize());
    if (bool1) {}
    for (;;)
    {
      try
      {
        if ((((com.tencent.mm.plugin.patmsg.a.f)localObject4).MHq.size() == ((com.tencent.mm.plugin.patmsg.a.f)localObject4).oxE.size()) && (!((com.tencent.mm.plugin.patmsg.a.f)localObject4).oxE.isEmpty()))
        {
          j = 0;
          if (j < ((com.tencent.mm.plugin.patmsg.a.f)localObject4).oxE.size())
          {
            localObject2 = (Pair)((com.tencent.mm.plugin.patmsg.a.f)localObject4).MHq.get(j);
            Log.d("MicroMsg.ChattingItemAppMsgPat", "click span start %d, end %d", new Object[] { ((Pair)localObject2).first, ((Pair)localObject2).second });
            localObject5 = new ae.6(this, parama);
            ((t)localObject5).setTag(((com.tencent.mm.plugin.patmsg.a.f)localObject4).oxE.get(j));
            ((SpannableString)localObject1).setSpan(localObject5, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue(), 17);
            j += 1;
            continue;
            paramMMNeat7extView.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.FG_2));
            paramMMNeat7extView.setBackground(parama.aezO.getContext().getResources().getDrawable(R.g.fnn));
            i = 0;
            break;
          }
        }
        localObject2 = localObject1;
        if (((com.tencent.mm.plugin.patmsg.a.f)localObject4).MHr.size() <= 0) {
          break label653;
        }
        localObject4 = ((com.tencent.mm.plugin.patmsg.a.f)localObject4).MHr.iterator();
        localObject2 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break label653;
        }
        Object localObject5 = (f.a)((Iterator)localObject4).next();
        com.tencent.mm.plugin.textstatus.a.f localf = (com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class);
        String str = ((f.a)localObject5).username;
        if (i == 0) {
          break label843;
        }
        localObject2 = a.b.ThK;
        ((SpannableString)localObject1).setSpan(localf.getTextStatusSpanSync(null, str, (a.b)localObject2, parama.aezO.getContext().getResources().getDimensionPixelSize(R.f.SmallBtnTextSize)), ((f.a)localObject5).start, ((f.a)localObject5).end, 17);
        continue;
        Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgPat", (Throwable)localObject1, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        parama = (com.tencent.mm.ui.chatting.d.a)localObject1;
        localObject1 = localException2;
      }
      localObject3 = parama;
      label653:
      if (!bool2) {
        break label851;
      }
      h.baE().ban().b(at.a.adgr, "");
      if (paramebe.abgK != 1) {
        break label851;
      }
      parama = bb.m(paramMMNeat7extView.getContext(), R.k.icons_filled_pencil, com.tencent.mm.cd.a.w(paramMMNeat7extView.getContext(), R.e.link_color));
      parama.setBounds(0, 0, parama.getIntrinsicWidth() * 2 / 3, parama.getIntrinsicHeight() * 2 / 3);
      parama = new com.tencent.mm.ui.widget.a(parama, 1);
      paramebe = new SpannableStringBuilder((CharSequence)localObject3);
      localObject1 = new SpannableString(paramMMNeat7extView.getContext().getString(R.l.pat_change_suffix_tip_icon));
      ((SpannableString)localObject1).setSpan(parama, 2, 3, 17);
      paramebe.append((CharSequence)localObject1);
      parama = String.format(paramMMNeat7extView.getContext().getString(R.l.pat_change_suffix_tip_wording), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat_bottom_sheet/'>", "</_wc_custom_link_>" });
      paramebe.append(p.b(paramMMNeat7extView.getContext(), parama, (int)paramMMNeat7extView.getTextSize()));
      paramMMNeat7extView.a(paramebe, TextView.BufferType.SPANNABLE);
      AppMethodBeat.o(255174);
      return;
      label843:
      localObject3 = a.b.ThL;
    }
    label851:
    paramMMNeat7extView.a((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(255174);
  }
  
  private void a(final com.tencent.mm.ui.chatting.d.a parama, cc paramcc, ebd paramebd, int paramInt)
  {
    AppMethodBeat.i(255165);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", new Object[] { Integer.valueOf(paramebd.Ksg.size()), Integer.valueOf(paramInt) });
    this.aeRw.ITf.removeAllViews();
    Activity localActivity = parama.aezO.getContext();
    int i = 0;
    while (i < paramInt)
    {
      MMNeat7extView localMMNeat7extView = new MMNeat7extView(localActivity);
      localMMNeat7extView.setTextSize(0, localActivity.getResources().getDimensionPixelSize(R.f.HintTextSize) * com.tencent.mm.cd.a.getScaleSize(localActivity));
      localMMNeat7extView.setPadding(localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding));
      localMMNeat7extView.setTextGravity(1);
      localMMNeat7extView.setClickable(true);
      a(parama, (ebe)paramebd.Ksg.get(i), localMMNeat7extView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      if (parama.juG())
      {
        localLayoutParams.topMargin = localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding);
        localLayoutParams.bottomMargin = localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding);
      }
      localLayoutParams.gravity = 1;
      this.aeRw.ITf.addView(localMMNeat7extView, localLayoutParams);
      localMMNeat7extView.setTag(new bz(paramcc, parama.juG(), 0, "", '\000'));
      localMMNeat7extView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(254927);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (((PluginPatMsg)h.az(PluginPatMsg.class)).isRevokePatMsgEnable())
          {
            localObject = (bz)paramAnonymousView.getTag();
            if ((localObject != null) && (((bz)localObject).hTm != null))
            {
              int i = ((ViewGroup)paramAnonymousView.getParent()).indexOfChild(paramAnonymousView);
              Log.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", new Object[] { Long.valueOf(((bz)localObject).hTm.field_msgId), Integer.valueOf(i) });
              paramAnonymousView = g.bDK(((bz)localObject).hTm.field_content);
              if (i < paramAnonymousView.Ksg.size())
              {
                paramAnonymousView = (ebe)paramAnonymousView.Ksg.get(i);
                if (z.bAM().equals(paramAnonymousView.hQQ))
                {
                  if (cn.bDv() - paramAnonymousView.createTime <= 120000L) {
                    ae.a(ae.this, parama, Pair.create(Long.valueOf(((bz)localObject).hTm.field_msgId), Long.valueOf(paramAnonymousView.createTime)));
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(254927);
                    return true;
                    Log.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", new Object[] { Long.valueOf(paramAnonymousView.createTime) });
                  }
                }
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(254927);
          return false;
        }
      });
      i += 1;
    }
    AppMethodBeat.o(255165);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255190);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfh);
      ((View)localObject).setTag(new ae.a().lG((View)localObject));
    }
    AppMethodBeat.o(255190);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, final String paramString)
  {
    AppMethodBeat.i(255195);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramcc.field_msgId) });
    this.aeRw = ((ae.a)parama);
    String str = paramcc.field_content;
    parama = ((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(str);
    int i = parama.Ksg.size();
    int k = ((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).ta(paramcc.field_msgId);
    ((com.tencent.mm.ui.chatting.component.api.u)parama1.cm(com.tencent.mm.ui.chatting.component.api.u.class)).a(paramcc, i, k);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { Util.secPrint(str), parama.ltm, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((n)h.ax(n.class)).gaZ().aLG(paramString);
      if ((i < 5) || (paramString.field_msgId == paramcc.field_msgId)) {
        break label392;
      }
    }
    for (;;)
    {
      paramString = (al)parama1.cm(al.class);
      boolean bool;
      label272:
      int j;
      if ((paramString != null) && (paramString.zL(paramcc.field_msgId)))
      {
        bool = true;
        Log.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
        if (bool) {
          break label362;
        }
        paramInt = 1;
        j = paramInt & k;
        if (j == 0) {
          break label367;
        }
      }
      label362:
      label367:
      for (paramInt = 3;; paramInt = i)
      {
        a(parama1, paramcc, parama, paramInt);
        this.aeRw.aeRz.setTag(Long.valueOf(paramcc.field_msgId));
        if (j == 0) {
          break label373;
        }
        this.aeRw.aeRz.setVisibility(0);
        this.aeRw.aeRz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(254917);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((n)h.ax(n.class)).gaZ().sl(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.zM(((fi)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(((fi)localObject).field_content);
              ae.a(ae.this, parama1, (cc)localObject, paramAnonymousView, paramAnonymousView.Ksg.size());
              localObject = new lo();
              ((lo)localObject).jae = ((lo)localObject).F("ChatUsername", parama1.getTalkerUserName(), true);
              ((lo)localObject).imU = ((lo)localObject).F("Username", parama1.aemd, true);
              ((lo)localObject).jaf = paramAnonymousView.Ksg.size();
              if (!au.bwG(parama1.getTalkerUserName())) {
                break label240;
              }
            }
            label240:
            for (((lo)localObject).imW = 2;; ((lo)localObject).imW = 1)
            {
              ((lo)localObject).bMH();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(254917);
              return;
            }
          }
        });
        AppMethodBeat.o(255195);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label272;
      }
      label373:
      this.aeRw.aeRz.setVisibility(8);
      AppMethodBeat.o(255195);
      return;
      label392:
      k = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 889192497) || (paramInt == 922746929);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  final boolean jxi()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */