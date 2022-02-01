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
import com.tencent.mm.bc.t;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
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
  private a KcH;
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, cig paramcig, MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(194396);
    Object localObject2 = u.aAm();
    boolean bool = ((PluginPatMsg)g.ad(PluginPatMsg.class)).isNickClickable();
    ad.d("MicroMsg.ChattingItemAppMsgPat", "show template:%s, createTime:%d, readStatus:%d", new Object[] { paramcig.hEb, Long.valueOf(paramcig.createTime), Integer.valueOf(paramcig.Hce) });
    f localf = ((PluginPatMsg)g.ad(PluginPatMsg.class)).parseDisplayTemplate(paramcig.hEb, parama.getTalkerUserName());
    Object localObject1 = new SpannableString(localf.result);
    for (;;)
    {
      com.tencent.mm.bc.a locala;
      int j;
      try
      {
        locala = t.aKa().Gb(parama.getTalkerUserName());
        ba.aBQ();
        j = ((Integer)com.tencent.mm.model.c.ajl().get(12311, Integer.valueOf(-2))).intValue();
        i = parama.JOR.getMMResources().getColor(2131099734);
        if ((locala == null) || (locala.iiM == -2)) {
          break label528;
        }
        paramMMNeat7extView.setTextColor(parama.JOR.getContext().getResources().getColor(2131099732));
        paramMMNeat7extView.setBackground(parama.JOR.getContext().getResources().getDrawable(2131235040));
        i = parama.JOR.getMMResources().getColor(2131099732);
      }
      catch (Exception paramcig)
      {
        try
        {
          if ((localf.wFI.size() != localf.hRC.size()) || (localf.hRC.isEmpty())) {
            break label513;
          }
          int i = 0;
          if (i >= localf.hRC.size()) {
            break label513;
          }
          localObject1 = (Pair)localf.wFI.get(i);
          ad.d("MicroMsg.ChattingItemAppMsgPat", "click span start %d, end %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
          localObject2 = new com.tencent.mm.plugin.messenger.a.a()
          {
            public final void onClickImp(View paramAnonymousView)
            {
              AppMethodBeat.i(194391);
              if ((getTag() != null) && ((getTag() instanceof String)))
              {
                paramAnonymousView = (String)getTag();
                ad.i("MicroMsg.ChattingItemAppMsgPat", "click %s", new Object[] { paramAnonymousView });
                paramAnonymousView = new Intent().putExtra("Contact_User", paramAnonymousView);
                paramAnonymousView.putExtra("Contact_ChatRoomId", parama.getTalkerUserName());
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 21);
                paramAnonymousView.putExtra("Contact_Scene", 14);
                d.b(parama.JOR.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(194391);
            }
          };
          ((o)localObject2).setTag(localf.hRC.get(i));
          paramcig.setSpan(localObject2, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue(), 17);
          i += 1;
          continue;
          paramMMNeat7extView.setTextColor(parama.JOR.getContext().getResources().getColor(2131099735));
          paramMMNeat7extView.setBackground(parama.JOR.getContext().getResources().getDrawable(2131235039));
        }
        catch (Exception localException)
        {
          parama = paramcig;
          paramcig = localException;
          continue;
        }
        paramcig = paramcig;
        parama = (com.tencent.mm.ui.chatting.e.a)localObject1;
        ad.printErrStackTrace("MicroMsg.ChattingItemAppMsgPat", paramcig, "", new Object[0]);
        paramMMNeat7extView.a(parama, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(194396);
        return;
      }
      if (paramcig.Hcd.equals(localObject2)) {
        ((SpannableString)localObject1).setSpan(new BoldForegroundColorSpan(i), 0, ((SpannableString)localObject1).length(), 17);
      }
      paramcig = k.d(parama.JOR.getContext(), (CharSequence)localObject1, paramMMNeat7extView.getTextSize());
      if (bool) {}
      label513:
      parama = paramcig;
      continue;
      label528:
      if ((locala != null) || (j == -2)) {}
    }
  }
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, bu parambu, cif paramcif, int paramInt)
  {
    AppMethodBeat.i(194395);
    ad.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", new Object[] { Integer.valueOf(paramcif.vox.size()), Integer.valueOf(paramInt) });
    this.KcH.urn.removeAllViews();
    Activity localActivity = parama.JOR.getContext();
    int i = 0;
    while (i < paramInt)
    {
      MMNeat7extView localMMNeat7extView = new MMNeat7extView(localActivity);
      localMMNeat7extView.setTextSize(0, localActivity.getResources().getDimensionPixelSize(2131165466));
      localMMNeat7extView.setPadding(localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490), localActivity.getResources().getDimensionPixelSize(2131165490));
      localMMNeat7extView.setTextGravity(1);
      localMMNeat7extView.setClickable(true);
      a(parama, (cig)paramcif.vox.get(i), localMMNeat7extView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      if (parama.fFv())
      {
        localLayoutParams.topMargin = localActivity.getResources().getDimensionPixelSize(2131165490);
        localLayoutParams.bottomMargin = localActivity.getResources().getDimensionPixelSize(2131165490);
      }
      localLayoutParams.gravity = 1;
      this.KcH.urn.addView(localMMNeat7extView, localLayoutParams);
      localMMNeat7extView.setTag(new bk(parambu, parama.fFv(), 0, "", '\000'));
      localMMNeat7extView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194387);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (((PluginPatMsg)g.ad(PluginPatMsg.class)).isRevokePatMsgEnable())
          {
            localObject = (bk)paramAnonymousView.getTag();
            if ((localObject != null) && (((bk)localObject).dBd != null))
            {
              int i = ((ViewGroup)paramAnonymousView.getParent()).indexOfChild(paramAnonymousView);
              ad.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", new Object[] { Long.valueOf(((bk)localObject).dBd.field_msgId), Integer.valueOf(i) });
              paramAnonymousView = e.aXV(((bk)localObject).dBd.field_content);
              if (i < paramAnonymousView.vox.size())
              {
                paramAnonymousView = (cig)paramAnonymousView.vox.get(i);
                if (u.aAm().equals(paramAnonymousView.dyU))
                {
                  if (cf.aCL() - paramAnonymousView.createTime <= 120000L) {
                    x.a(x.this, parama, Pair.create(Long.valueOf(((bk)localObject).dBd.field_msgId), Long.valueOf(paramAnonymousView.createTime)));
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(194387);
                    return true;
                    ad.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", new Object[] { Long.valueOf(paramAnonymousView.createTime) });
                  }
                }
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(194387);
          return false;
        }
      });
      i += 1;
    }
    AppMethodBeat.o(194395);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(194393);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496146);
      ((View)localObject).setTag(new a().gD((View)localObject));
    }
    AppMethodBeat.o(194393);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu, final String paramString)
  {
    AppMethodBeat.i(194394);
    ad.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parambu.field_msgId) });
    this.KcH = ((a)parama);
    String str = parambu.field_content;
    parama = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).auh(str);
    int i = parama.vox.size();
    ad.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { str, parama.fFR, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX(paramString);
      if ((i < 5) || (paramString.field_msgId == parambu.field_msgId)) {
        break label368;
      }
    }
    label338:
    label343:
    label349:
    label368:
    for (int k = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).yr(parambu.field_msgId);; k = 0)
    {
      paramString = (af)parama1.bh(af.class);
      boolean bool;
      label248:
      int j;
      if ((paramString != null) && (paramString.DT(parambu.field_msgId)))
      {
        bool = true;
        ad.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
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
        a(parama1, parambu, parama, paramInt);
        this.KcH.KcK.setTag(Long.valueOf(parambu.field_msgId));
        if (j == 0) {
          break label349;
        }
        this.KcH.KcK.setVisibility(0);
        this.KcH.KcK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194386);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.DU(((ei)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).auh(((ei)localObject).field_content);
              x.a(x.this, parama1, (bu)localObject, paramAnonymousView, paramAnonymousView.vox.size());
              localObject = new du();
              ((du)localObject).ehb = ((du)localObject).t("ChatUsername", parama1.getTalkerUserName(), true);
              ((du)localObject).dWK = ((du)localObject).t("Username", parama1.JOQ, true);
              ((du)localObject).ehc = paramAnonymousView.vox.size();
              if (!w.zk(parama1.getTalkerUserName())) {
                break label240;
              }
            }
            label240:
            for (((du)localObject).dSg = 2;; ((du)localObject).dSg = 1)
            {
              ((du)localObject).aLk();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194386);
              return;
            }
          }
        });
        AppMethodBeat.o(194394);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label248;
      }
      this.KcH.KcK.setVisibility(8);
      AppMethodBeat.o(194394);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 889192497) || (paramInt == 922746929);
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final boolean fHi()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public TextView KcK;
    public LinearLayout urn;
    
    public final a gD(View paramView)
    {
      AppMethodBeat.i(194392);
      super.gn(paramView);
      this.urn = ((LinearLayout)paramView.findViewById(2131307219));
      this.KcK = ((TextView)paramView.findViewById(2131307193));
      this.gZU = paramView.findViewById(2131298147);
      AppMethodBeat.o(194392);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x
 * JD-Core Version:    0.7.0.1
 */