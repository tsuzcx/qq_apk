package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.ad;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends c
{
  private a Imh;
  
  private SpannableString a(final com.tencent.mm.ui.chatting.d.a parama, cdh paramcdh, int paramInt, MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(196710);
    int i = 0;
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = new StringBuilder();
    int j = 0;
    if (j < paramInt)
    {
      Object localObject3 = (cdi)paramcdh.ulR.get(j);
      ac.d("MicroMsg.ChattingItemAppMsgPat", "show template:%s, createTime:%d, readStatus:%d", new Object[] { ((cdi)localObject3).hlO, Long.valueOf(((cdi)localObject3).createTime), Integer.valueOf(((cdi)localObject3).Fsa) });
      ArrayList localArrayList3 = new ArrayList();
      localObject3 = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).c(((cdi)localObject3).hlO, parama.getTalkerUserName(), localArrayList3, localArrayList1);
      if (bs.isNullOrNil((String)localObject3)) {
        break label783;
      }
      int k = 0;
      while (k < localArrayList3.size())
      {
        int m = ((StringBuilder)localObject2).length();
        int n = ((Integer)((Pair)localArrayList3.get(k)).first).intValue();
        int i1 = ((StringBuilder)localObject2).length();
        localArrayList2.add(Pair.create(Integer.valueOf(n + m), Integer.valueOf(((Integer)((Pair)localArrayList3.get(k)).second).intValue() + i1)));
        k += 1;
      }
      ((StringBuilder)localObject2).append((String)localObject3);
      if (j < paramInt - 1) {
        ((StringBuilder)localObject2).append("\n");
      }
      ((List)localObject1).add(Pair.create(Integer.valueOf(i), Integer.valueOf(((StringBuilder)localObject2).length())));
      i = ((StringBuilder)localObject2).length();
    }
    label783:
    for (;;)
    {
      j += 1;
      break;
      paramcdh = new SpannableString(((StringBuilder)localObject2).toString());
      localObject2 = t.aGP().CW(parama.getTalkerUserName());
      az.ayM();
      paramInt = ((Integer)com.tencent.mm.model.c.agA().get(12311, Integer.valueOf(-2))).intValue();
      if (((localObject2 != null) && (((com.tencent.mm.bb.a)localObject2).hPy != -2)) || ((localObject2 == null) && (paramInt != -2)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          ac.d("MicroMsg.ChattingItemAppMsgPat", "bg span start %d, end %d", new Object[] { ((Pair)localObject2).first, ((Pair)localObject2).second });
          paramcdh.setSpan(new com.tencent.mm.ui.base.c(paramMMNeat7extView, parama.HZF.getMMResources().getColor(2131101190), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue()), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue(), 17);
        }
        paramMMNeat7extView.setTextColor(parama.HZF.getContext().getResources().getColor(2131100151));
        paramcdh = com.tencent.mm.pluginsdk.ui.span.k.d(parama.HZF.getContext(), paramcdh, paramMMNeat7extView.getTextSize());
      }
      while ((localArrayList2.size() == localArrayList1.size()) && (!localArrayList1.isEmpty()))
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < localArrayList2.size())
          {
            localObject1 = (Pair)localArrayList2.get(paramInt);
            ac.d("MicroMsg.ChattingItemAppMsgPat", "click span start %d, end %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
            localObject2 = new com.tencent.mm.plugin.messenger.a.a()
            {
              public final void onClickImp(View paramAnonymousView)
              {
                AppMethodBeat.i(196706);
                if ((getTag() != null) && ((getTag() instanceof String)))
                {
                  paramAnonymousView = (String)getTag();
                  ac.i("MicroMsg.ChattingItemAppMsgPat", "click %s", new Object[] { paramAnonymousView });
                  paramAnonymousView = new Intent().putExtra("Contact_User", paramAnonymousView);
                  paramAnonymousView.putExtra("Contact_ChatRoomId", parama.getTalkerUserName());
                  paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 21);
                  paramAnonymousView.putExtra("Contact_Scene", 14);
                  d.b(parama.HZF.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
                AppMethodBeat.o(196706);
              }
            };
            ((o)localObject2).setTag(localArrayList1.get(paramInt));
            paramcdh.setSpan(localObject2, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue(), 17);
            paramInt += 1;
            continue;
            paramcdh = com.tencent.mm.pluginsdk.ui.span.k.b(parama.HZF.getContext(), paramcdh, paramMMNeat7extView.getTextSize());
            paramMMNeat7extView.setTextColor(ao.aJ(parama.HZF.getContext(), 2130968586));
            break;
          }
        }
        paramMMNeat7extView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(paramMMNeat7extView, new n(parama.HZF.getContext())));
      }
      AppMethodBeat.o(196710);
      return paramcdh;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(196708);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131496146);
      ((View)localObject).setTag(new a().gm((View)localObject));
    }
    AppMethodBeat.o(196708);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, final String paramString)
  {
    AppMethodBeat.i(196709);
    ac.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parambo.field_msgId) });
    this.Imh = ((a)parama);
    String str = parambo.field_content;
    parama = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).akH(str);
    int i = parama.ulR.size();
    ac.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { str, parama.fnJ, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramString);
      if ((i < 5) || (paramString.field_msgId == parambo.field_msgId)) {
        break label386;
      }
    }
    label386:
    for (int k = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).vO(parambo.field_msgId);; k = 0)
    {
      paramString = (ad)parama1.bf(ad.class);
      boolean bool;
      label246:
      int j;
      if ((paramString != null) && (paramString.Be(parambo.field_msgId)))
      {
        bool = true;
        ac.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
        if (bool) {
          break label356;
        }
        paramInt = 1;
        j = paramInt & k;
        if (j == 0) {
          break label361;
        }
      }
      label356:
      label361:
      for (paramInt = 3;; paramInt = i)
      {
        parama = a(parama1, parama, paramInt, this.Imh.Iml);
        this.Imh.Iml.a(parama, TextView.BufferType.SPANNABLE);
        this.Imh.Imm.setTag(Long.valueOf(parambo.field_msgId));
        if (j == 0) {
          break label367;
        }
        this.Imh.Imm.setVisibility(0);
        this.Imh.Imm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196705);
            Object localObject;
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.Bf(((dy)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).akH(((dy)localObject).field_content);
              localObject = w.a(w.this, parama1, paramAnonymousView, paramAnonymousView.ulR.size(), w.a(w.this).Iml);
              w.a(w.this).Iml.a((CharSequence)localObject, TextView.BufferType.SPANNABLE);
              localObject = new db();
              ((db)localObject).dRE = ((db)localObject).t("ChatUsername", parama1.getTalkerUserName(), true);
              ((db)localObject).dJb = ((db)localObject).t("Username", parama1.HZE, true);
              ((db)localObject).dRF = paramAnonymousView.ulR.size();
              if (!com.tencent.mm.model.w.wp(parama1.getTalkerUserName())) {
                break label226;
              }
            }
            label226:
            for (((db)localObject).dHw = 2;; ((db)localObject).dHw = 1)
            {
              ((db)localObject).aHZ();
              AppMethodBeat.o(196705);
              return;
            }
          }
        });
        AppMethodBeat.o(196709);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label246;
      }
      label367:
      this.Imh.Imm.setVisibility(8);
      AppMethodBeat.o(196709);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == 889192497;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public View Imk;
    public MMNeat7extView Iml;
    public TextView Imm;
    
    public final a gm(View paramView)
    {
      AppMethodBeat.i(196707);
      super.fX(paramView);
      this.Imk = paramView.findViewById(2131307219);
      this.Iml = ((MMNeat7extView)paramView.findViewById(2131307245));
      this.Imm = ((TextView)paramView.findViewById(2131307193));
      this.gGk = paramView.findViewById(2131298147);
      AppMethodBeat.o(196707);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */