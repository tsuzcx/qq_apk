package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.Pair;
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
import com.tencent.mm.bb.t;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.e;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends c
{
  private a KyZ;
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, cja paramcja, MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(187791);
    Object localObject2 = v.aAC();
    boolean bool = ((PluginPatMsg)g.ad(PluginPatMsg.class)).isNickClickable();
    ae.d("MicroMsg.ChattingItemAppMsgPat", "show template:%s, createTime:%d, readStatus:%d", new Object[] { paramcja.hGT, Long.valueOf(paramcja.createTime), Integer.valueOf(paramcja.HvE) });
    f localf = ((PluginPatMsg)g.ad(PluginPatMsg.class)).parseDisplayTemplate(paramcja.hGT, parama.getTalkerUserName());
    Object localObject1 = new SpannableString(localf.result);
    for (;;)
    {
      com.tencent.mm.bb.a locala;
      int j;
      try
      {
        locala = t.aKt().GD(parama.getTalkerUserName());
        bc.aCg();
        j = ((Integer)com.tencent.mm.model.c.ajA().get(12311, Integer.valueOf(-2))).intValue();
        i = parama.Kkd.getMMResources().getColor(2131099734);
        if ((locala == null) || (locala.ilF == -2)) {
          break label528;
        }
        paramMMNeat7extView.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099732));
        paramMMNeat7extView.setBackground(parama.Kkd.getContext().getResources().getDrawable(2131235040));
        i = parama.Kkd.getMMResources().getColor(2131099732);
      }
      catch (Exception paramcja)
      {
        try
        {
          if ((localf.wVt.size() != localf.hUu.size()) || (localf.hUu.isEmpty())) {
            break label513;
          }
          int i = 0;
          if (i >= localf.hUu.size()) {
            break label513;
          }
          localObject1 = (Pair)localf.wVt.get(i);
          ae.d("MicroMsg.ChattingItemAppMsgPat", "click span start %d, end %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
          localObject2 = new com.tencent.mm.plugin.messenger.a.a()
          {
            public final void onClickImp(View paramAnonymousView)
            {
              AppMethodBeat.i(187786);
              if ((getTag() != null) && ((getTag() instanceof String)))
              {
                paramAnonymousView = (String)getTag();
                ae.i("MicroMsg.ChattingItemAppMsgPat", "click %s", new Object[] { paramAnonymousView });
                paramAnonymousView = new Intent().putExtra("Contact_User", paramAnonymousView);
                paramAnonymousView.putExtra("Contact_ChatRoomId", parama.getTalkerUserName());
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 21);
                paramAnonymousView.putExtra("Contact_Scene", 14);
                d.b(parama.Kkd.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(187786);
            }
          };
          ((o)localObject2).setTag(localf.hUu.get(i));
          paramcja.setSpan(localObject2, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue(), 17);
          i += 1;
          continue;
          paramMMNeat7extView.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099735));
          paramMMNeat7extView.setBackground(parama.Kkd.getContext().getResources().getDrawable(2131235039));
        }
        catch (Exception localException)
        {
          parama = paramcja;
          paramcja = localException;
          continue;
        }
        paramcja = paramcja;
        parama = (com.tencent.mm.ui.chatting.e.a)localObject1;
        ae.printErrStackTrace("MicroMsg.ChattingItemAppMsgPat", paramcja, "", new Object[0]);
        paramMMNeat7extView.a(parama, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(187791);
        return;
      }
      if (paramcja.HvD.equals(localObject2)) {
        ((SpannableString)localObject1).setSpan(new BoldForegroundColorSpan(i), 0, ((SpannableString)localObject1).length(), 17);
      }
      paramcja = k.d(parama.Kkd.getContext(), (CharSequence)localObject1, paramMMNeat7extView.getTextSize());
      if (bool) {}
      label513:
      parama = paramcja;
      continue;
      label528:
      if ((locala != null) || (j == -2)) {}
    }
  }
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, bv parambv, ciz paramciz, int paramInt)
  {
    AppMethodBeat.i(187790);
    ae.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", new Object[] { Integer.valueOf(paramciz.vAC.size()), Integer.valueOf(paramInt) });
    this.KyZ.uCG.removeAllViews();
    Activity localActivity = parama.Kkd.getContext();
    int i = 0;
    while (i < paramInt)
    {
      MMNeat7extView localMMNeat7extView = new MMNeat7extView(localActivity);
      localMMNeat7extView.setTextSize(0, localActivity.getResources().getDimensionPixelSize(2131165466));
      localMMNeat7extView.setPadding(localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490));
      localMMNeat7extView.setTextGravity(1);
      localMMNeat7extView.setClickable(true);
      a(parama, (cja)paramciz.vAC.get(i), localMMNeat7extView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      if (parama.fJC())
      {
        localLayoutParams.topMargin = localActivity.getResources().getDimensionPixelSize(2131165490);
        localLayoutParams.bottomMargin = localActivity.getResources().getDimensionPixelSize(2131165490);
      }
      localLayoutParams.gravity = 1;
      this.KyZ.uCG.addView(localMMNeat7extView, localLayoutParams);
      localMMNeat7extView.setTag(new bk(parambv, parama.fJC(), 0, "", '\000'));
      localMMNeat7extView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187782);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (((PluginPatMsg)g.ad(PluginPatMsg.class)).isRevokePatMsgEnable())
          {
            localObject = (bk)paramAnonymousView.getTag();
            if ((localObject != null) && (((bk)localObject).dCi != null))
            {
              int i = ((ViewGroup)paramAnonymousView.getParent()).indexOfChild(paramAnonymousView);
              ae.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", new Object[] { Long.valueOf(((bk)localObject).dCi.field_msgId), Integer.valueOf(i) });
              paramAnonymousView = e.aZx(((bk)localObject).dCi.field_content);
              if (i < paramAnonymousView.vAC.size())
              {
                paramAnonymousView = (cja)paramAnonymousView.vAC.get(i);
                if (v.aAC().equals(paramAnonymousView.dzZ))
                {
                  if (ch.aDb() - paramAnonymousView.createTime <= 120000L) {
                    x.a(x.this, parama, Pair.create(Long.valueOf(((bk)localObject).dCi.field_msgId), Long.valueOf(paramAnonymousView.createTime)));
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(187782);
                    return true;
                    ae.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", new Object[] { Long.valueOf(paramAnonymousView.createTime) });
                  }
                }
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(187782);
          return false;
        }
      });
      i += 1;
    }
    AppMethodBeat.o(187790);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(187788);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496146);
      ((View)localObject).setTag(new a().gI((View)localObject));
    }
    AppMethodBeat.o(187788);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bv parambv, final String paramString)
  {
    AppMethodBeat.i(187789);
    ae.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parambv.field_msgId) });
    this.KyZ = ((a)parama);
    String str = parambv.field_content;
    parama = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).avw(str);
    int i = parama.vAC.size();
    ae.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { str, parama.fHV, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(paramString);
      if ((i < 5) || (paramString.field_msgId == parambv.field_msgId)) {
        break label368;
      }
    }
    label338:
    label343:
    label349:
    label368:
    for (int k = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).yL(parambv.field_msgId);; k = 0)
    {
      paramString = (af)parama1.bh(af.class);
      boolean bool;
      label248:
      int j;
      if ((paramString != null) && (paramString.Es(parambv.field_msgId)))
      {
        bool = true;
        ae.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
        if (bool) {
          break label338;
        }
        paramInt = 1;
        j = paramInt & k;
        if (j == 0) {
          break label343;
        }
      }
      for (paramInt = 3;; paramInt = i)
      {
        a(parama1, parambv, parama, paramInt);
        this.KyZ.Kzc.setTag(Long.valueOf(parambv.field_msgId));
        if (j == 0) {
          break label349;
        }
        this.KyZ.Kzc.setVisibility(0);
        this.KyZ.Kzc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187781);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.Et(((ei)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).avw(((ei)localObject).field_content);
              x.a(x.this, parama1, (bv)localObject, paramAnonymousView, paramAnonymousView.vAC.size());
              localObject = new dw();
              ((dw)localObject).eiL = ((dw)localObject).t("ChatUsername", parama1.getTalkerUserName(), true);
              ((dw)localObject).dYc = ((dw)localObject).t("Username", parama1.Kkc, true);
              ((dw)localObject).eiM = paramAnonymousView.vAC.size();
              if (!com.tencent.mm.model.x.zU(parama1.getTalkerUserName())) {
                break label240;
              }
            }
            label240:
            for (((dw)localObject).dTw = 2;; ((dw)localObject).dTw = 1)
            {
              ((dw)localObject).aLH();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(187781);
              return;
            }
          }
        });
        AppMethodBeat.o(187789);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label248;
      }
      this.KyZ.Kzc.setVisibility(8);
      AppMethodBeat.o(187789);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 889192497) || (paramInt == 922746929);
  }
  
  final boolean fLA()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public TextView Kzc;
    public LinearLayout uCG;
    
    public final a gI(View paramView)
    {
      AppMethodBeat.i(187787);
      super.gs(paramView);
      this.uCG = ((LinearLayout)paramView.findViewById(2131307219));
      this.Kzc = ((TextView)paramView.findViewById(2131307193));
      this.hcH = paramView.findViewById(2131298147);
      AppMethodBeat.o(187787);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x
 * JD-Core Version:    0.7.0.1
 */