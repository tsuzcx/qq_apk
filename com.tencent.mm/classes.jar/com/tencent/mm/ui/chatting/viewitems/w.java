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
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends c
{
  private a GMk;
  
  private SpannableString a(final com.tencent.mm.ui.chatting.d.a parama, byl parambyl, int paramInt, MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(191644);
    int i = 0;
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = new StringBuilder();
    int j = 0;
    if (j < paramInt)
    {
      Object localObject3 = (bym)parambyl.tdC.get(j);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgPat", "show template:%s, createTime:%d, readStatus:%d", new Object[] { ((bym)localObject3).gLo, Long.valueOf(((bym)localObject3).createTime), Integer.valueOf(((bym)localObject3).DVm) });
      ArrayList localArrayList3 = new ArrayList();
      localObject3 = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).c(((bym)localObject3).gLo, parama.getTalkerUserName(), localArrayList3, localArrayList1);
      if (bt.isNullOrNil((String)localObject3)) {
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
      parambyl = new SpannableString(((StringBuilder)localObject2).toString());
      localObject2 = t.azZ().yR(parama.getTalkerUserName());
      az.arV();
      paramInt = ((Integer)com.tencent.mm.model.c.afk().get(12311, Integer.valueOf(-2))).intValue();
      if (((localObject2 != null) && (((com.tencent.mm.bc.a)localObject2).hoW != -2)) || ((localObject2 == null) && (paramInt != -2)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgPat", "bg span start %d, end %d", new Object[] { ((Pair)localObject2).first, ((Pair)localObject2).second });
          parambyl.setSpan(new com.tencent.mm.ui.base.c(paramMMNeat7extView, parama.GzJ.getMMResources().getColor(2131101190), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue()), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue(), 17);
        }
        paramMMNeat7extView.setTextColor(parama.GzJ.getContext().getResources().getColor(2131100151));
        parambyl = com.tencent.mm.pluginsdk.ui.span.k.d(parama.GzJ.getContext(), parambyl, paramMMNeat7extView.getTextSize());
      }
      while ((localArrayList2.size() == localArrayList1.size()) && (!localArrayList1.isEmpty()))
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < localArrayList2.size())
          {
            localObject1 = (Pair)localArrayList2.get(paramInt);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgPat", "click span start %d, end %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
            localObject2 = new com.tencent.mm.plugin.messenger.a.a()
            {
              public final void onClickImp(View paramAnonymousView)
              {
                AppMethodBeat.i(191640);
                if ((getTag() != null) && ((getTag() instanceof String)))
                {
                  paramAnonymousView = (String)getTag();
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgPat", "click %s", new Object[] { paramAnonymousView });
                  paramAnonymousView = new Intent().putExtra("Contact_User", paramAnonymousView);
                  paramAnonymousView.putExtra("Contact_ChatRoomId", parama.getTalkerUserName());
                  paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 21);
                  paramAnonymousView.putExtra("Contact_Scene", 14);
                  d.b(parama.GzJ.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
                AppMethodBeat.o(191640);
              }
            };
            ((o)localObject2).setTag(localArrayList1.get(paramInt));
            parambyl.setSpan(localObject2, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue(), 17);
            paramInt += 1;
            continue;
            parambyl = com.tencent.mm.pluginsdk.ui.span.k.b(parama.GzJ.getContext(), parambyl, paramMMNeat7extView.getTextSize());
            paramMMNeat7extView.setTextColor(ao.aD(parama.GzJ.getContext(), 2130968586));
            break;
          }
        }
        paramMMNeat7extView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(paramMMNeat7extView, new n(parama.GzJ.getContext())));
      }
      AppMethodBeat.o(191644);
      return parambyl;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(191642);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131496146);
      ((View)localObject).setTag(new a().fZ((View)localObject));
    }
    AppMethodBeat.o(191642);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, final String paramString)
  {
    AppMethodBeat.i(191643);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parambl.field_msgId) });
    this.GMk = ((a)parama);
    String str = parambl.field_content;
    parama = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).afN(str);
    int i = parama.tdC.size();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { str, parama.fkp, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramString);
      if ((i < 5) || (paramString.field_msgId == parambl.field_msgId)) {
        break label386;
      }
    }
    label386:
    for (int k = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).rl(parambl.field_msgId);; k = 0)
    {
      paramString = (com.tencent.mm.ui.chatting.c.ad)parama1.be(com.tencent.mm.ui.chatting.c.ad.class);
      boolean bool;
      label246:
      int j;
      if ((paramString != null) && (paramString.wB(parambl.field_msgId)))
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
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
        parama = a(parama1, parama, paramInt, this.GMk.GMo);
        this.GMk.GMo.a(parama, TextView.BufferType.SPANNABLE);
        this.GMk.GMp.setTag(Long.valueOf(parambl.field_msgId));
        if (j == 0) {
          break label367;
        }
        this.GMk.GMp.setVisibility(0);
        this.GMk.GMp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191639);
            Object localObject;
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.wC(((du)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.messenger.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.c.class)).afN(((du)localObject).field_content);
              localObject = w.a(w.this, parama1, paramAnonymousView, paramAnonymousView.tdC.size(), w.a(w.this).GMo);
              w.a(w.this).GMo.a((CharSequence)localObject, TextView.BufferType.SPANNABLE);
              localObject = new bn();
              ((bn)localObject).dPN = ((bn)localObject).t("ChatUsername", parama1.getTalkerUserName(), true);
              ((bn)localObject).dKt = ((bn)localObject).t("Username", parama1.GzI, true);
              ((bn)localObject).dPO = paramAnonymousView.tdC.size();
              if (!com.tencent.mm.model.w.sm(parama1.getTalkerUserName())) {
                break label226;
              }
            }
            label226:
            for (((bn)localObject).dJu = 2;; ((bn)localObject).dJu = 1)
            {
              ((bn)localObject).aBj();
              AppMethodBeat.o(191639);
              return;
            }
          }
        });
        AppMethodBeat.o(191643);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label246;
      }
      label367:
      this.GMk.GMp.setVisibility(8);
      AppMethodBeat.o(191643);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == 889192497;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public View GMn;
    public MMNeat7extView GMo;
    public TextView GMp;
    
    public final a fZ(View paramView)
    {
      AppMethodBeat.i(191641);
      super.fK(paramView);
      this.GMn = paramView.findViewById(2131307219);
      this.GMo = ((MMNeat7extView)paramView.findViewById(2131307245));
      this.GMp = ((TextView)paramView.findViewById(2131307193));
      AppMethodBeat.o(191641);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */