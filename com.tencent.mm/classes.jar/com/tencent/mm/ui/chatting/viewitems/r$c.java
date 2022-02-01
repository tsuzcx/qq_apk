package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class r$c
  extends c
  implements t.n, NeatTextView.b
{
  private static final int Kyw = 2131305626;
  private static final int Kyx = 2131298134;
  private static final int Kyy = 2131298133;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private CharSequence JZt;
  private int KuT = -1;
  private r.e Kyz;
  private int gqW = -1;
  
  private void bv(bv parambv)
  {
    AppMethodBeat.i(187767);
    if (parambv.fvQ())
    {
      Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parambv.field_talker, parambv.fmz, true);
      if ((localObject != null) && (bu.az(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, parambv.field_msgId)))
      {
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      if (localObject != null) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().U(parambv.field_msgId, ((Long)((Pair)localObject).second).longValue());
      }
      bl.rW(parambv.field_msgId);
      this.JWz.xY(true);
    }
    AppMethodBeat.o(187767);
  }
  
  private r.e fLI()
  {
    AppMethodBeat.i(36956);
    if (this.Kyz == null) {
      this.Kyz = new r.e(this.JWz);
    }
    r.e locale = this.Kyz;
    AppMethodBeat.o(36956);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36957);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493484);
      ((View)localObject).setTag(new r.a().gB((View)localObject));
    }
    AppMethodBeat.o(36957);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36961);
    bv(parambv);
    AppMethodBeat.o(36961);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, final String paramString)
  {
    AppMethodBeat.i(36958);
    paramString = (r.a)parama;
    this.JWz = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
    paramString.Kyq.setTag(Kyx, Long.valueOf(parambv.field_msgId));
    paramString.Kyq.setTag(Kyy, Boolean.TRUE);
    parama = parambv.field_content;
    if (parama != null) {}
    label1291:
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      Object localObject1;
      Object localObject2;
      if ((parama != null) && (parama.type == 53))
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.Kyq.getContext(), parama.title, (int)paramString.Kyq.getTextSize(), 4);
        r.a(paramString.Kyq.getContext(), parama1, parama.title, (CharSequence)localObject1, paramString.Kyq, parambv, 4);
        paramString.Kyq.setClickable(true);
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(parama.appId, true, false);
        if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
          break label1268;
        }
        localObject1 = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fD((String)localObject1))) {
          break label1278;
        }
        paramString.rLB.setText(parama1.Kkd.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.Kkd.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1) }));
        paramString.rLB.setVisibility(0);
        a(parama1, paramString.rLB, parama.appId);
        a(parama1, paramString.rLB, parama.appId);
        label306:
        if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv))
        {
          paramString.rLB.setText(parama1.Kkd.getMMResources().getString(2131760106));
          paramString.rLB.setVisibility(0);
          paramString.rLB.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(36950);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambv.field_msgId) });
              s.a(parama1, parambv.field_msgId, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(36950);
            }
          });
        }
        if (!fLB()) {
          break label1291;
        }
      }
      label1052:
      label1315:
      label1359:
      for (;;)
      {
        boolean bool = false;
        parama = paramString;
        label375:
        b(parama, bool);
        parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
        parama.KDT = false;
        localObject1 = paramString.Kyq.getContext();
        paramString.Kyq.setTag(Kyw, Boolean.TRUE);
        if (paramString.JZs == null)
        {
          paramString.JZs = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.Kyq);
          paramString.JZs.LhV = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180003);
              parama1.setFocused(true);
              c.a(paramString.JZs, parama1, r.c.a(r.c.this), r.c.b(r.c.this), 49);
              r.c.a(r.c.this, -1);
              r.c.b(r.c.this, -1);
              AppMethodBeat.o(180003);
            }
          };
          paramString.JZs.LwJ = true;
          paramString.JZs.LwH = new n.c()
          {
            public final void a(l paramAnonymousl, View paramAnonymousView)
            {
              AppMethodBeat.i(187765);
              paramAnonymousl.clear();
              paramAnonymousl.a(0, 0, this.val$context.getResources().getString(2131755701), 2131690381);
              paramAnonymousl.a(0, 1, this.val$context.getResources().getString(2131761224), 2131691572);
              paramAnonymousl.a(0, 2, this.val$context.getResources().getString(2131761223), 2131690478);
              paramAnonymousl.a(0, 3, this.val$context.getResources().getString(2131758845), 2131690400);
              AppMethodBeat.o(187765);
            }
          };
          paramString.JZs.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180005);
              r.c.b(r.c.this, paramAnonymousMenuItem.getItemId());
              r.c.a(r.c.this, paramAnonymousInt);
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180005);
                return;
                ((android.content.ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(r.c.c(r.c.this), r.c.c(r.c.this)));
                if (paramString.Kyr != null)
                {
                  paramString.Kyr.fRO();
                  paramString.Kyr.LCs = true;
                  paramString.Kyr.LCt = true;
                  paramString.Kyr.fRN();
                }
                Toast.makeText(this.val$context, 2131755702, 0).show();
                AppMethodBeat.o(180005);
                return;
                if (paramString.Kyr != null)
                {
                  if (paramString.Kyr.LCd != null) {
                    paramString.Kyr.LCd.fLD();
                  }
                  paramString.Kyr.LCs = true;
                  paramString.Kyr.fRN();
                  paramString.Kyr.kw(0, paramString.Kyq.fXo().length());
                  paramString.Kyr.fRQ();
                  paramString.Kyr.fRT();
                  if (paramString.Kyr.LCd != null)
                  {
                    paramString.Kyr.LCd.fLE();
                    AppMethodBeat.o(180005);
                    return;
                    Object localObject = new Intent(this.val$context, MsgRetransmitUI.class);
                    ((Intent)localObject).putExtra("Retr_Msg_content", r.c.c(r.c.this));
                    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = this.val$context;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180005);
                    return;
                    paramAnonymousMenuItem = new cw();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, r.c.c(r.c.this).toString(), 1);
                    paramAnonymousMenuItem.doL.fragment = r.c.d(r.c.this).Kkd;
                    paramAnonymousMenuItem.doL.doR = 43;
                    if (paramAnonymousMenuItem.doL.doN != null)
                    {
                      localObject = paramAnonymousMenuItem.doL.doN.GCe;
                      if (localObject != null)
                      {
                        bk localbk = (bk)paramString.Kyq.getTag();
                        if (localbk != null)
                        {
                          ((akt)localObject).aQC(localbk.dCi.field_talker);
                          ((akt)localObject).aQD(com.tencent.mm.model.v.aAC());
                          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                        }
                      }
                    }
                    if (paramString.Kyr != null)
                    {
                      paramString.Kyr.fRO();
                      paramString.Kyr.LCs = true;
                      paramString.Kyr.LCt = true;
                      paramString.Kyr.fRN();
                    }
                  }
                }
              }
            }
          };
        }
        localObject1 = c(parama1);
        localObject2 = a(c(parama1));
        if (paramString.Kyr != null) {
          paramString.Kyr.destroy();
        }
        Object localObject3 = new int[2];
        int i = 0;
        if (paramString.Kyq != null)
        {
          paramString.Kyq.getLocationOnScreen((int[])localObject3);
          int j = localObject3[0];
          i = j;
          if (j == 0)
          {
            localObject3 = new Rect();
            paramString.Kyq.getGlobalVisibleRect((Rect)localObject3);
            i = ((Rect)localObject3).left;
          }
        }
        for (;;)
        {
          localObject2 = new a.a(paramString.Kyq, paramString.JZs, (a.f)localObject2, fLI(), paramString.Kys);
          ((a.a)localObject2).LCj = 2131100135;
          ((a.a)localObject2).LCD = 18;
          ((a.a)localObject2).LCk = 2131100133;
          if (i != 0) {
            ((a.a)localObject2).LCE = (aq.ay(paramString.Kyq.getContext(), 2131165284) + i);
          }
          paramString.Kyr = ((a.a)localObject2).fRW();
          paramString.Kyt = new r.d(paramString.Kyr);
          paramString.Kyr.LCb = new com.tencent.mm.ui.base.v()
          {
            public final void am(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180006);
              r.c.a(r.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180006);
            }
          };
          paramString.Kur = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180007);
              paramString.Kyr.fRO();
              paramString.Kyr.LCs = true;
              paramString.Kyr.LCt = true;
              paramString.Kyr.fRN();
              AppMethodBeat.o(180007);
            }
          };
          ((c.c)localObject1).Kur = paramString.Kur;
          paramString.Kyr.LCz = paramString.Kyt;
          paramString.Kyq.setOnDoubleClickListener(this);
          paramString.Kyq.setTag(parama);
          paramString.Kyq.setTextListener(new MMNeat7extView.a()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180008);
              if (((Boolean)paramString.Kyq.getTag(r.c.bdC())).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.fLp();
                com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)paramString.Kyq.getTag(r.c.bdD())).longValue());
              }
              AppMethodBeat.o(180008);
            }
          });
          localObject1 = ChattingItemTranslate.b.KCw;
          if (com.tencent.mm.app.plugin.c.Nb()) {
            if ((parambv.fvS()) && (parambv.fwc()))
            {
              parama = parambv.field_transContent;
              label851:
              localObject1 = ((ar)parama1.bh(ar.class)).bT(parambv);
            }
          }
          for (;;)
          {
            if ((!bu.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.b.KCw))
            {
              if ((paramString.Kyv == null) && (paramString.Kyu != null))
              {
                paramString.Kyv = ((ChattingItemTranslate)paramString.Kyu.inflate());
                paramString.Kyv.init();
              }
              localObject3 = paramString.Kyq.getContext();
              i = (int)paramString.Kyq.getTextSize();
              if (parambv != null)
              {
                localObject2 = z.Br(parambv.field_msgSvrId);
                z.b localb = z.aBG().F((String)localObject2, true);
                localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
                localb.k("preUsername", b(this.JWz, parambv));
                localb.k("preChatName", c(this.JWz, parambv));
                localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject3, parama, i, 1, null, (String)localObject2);
                ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject2 });
                paramString.Kyv.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
                localObject2 = paramString.Kyv;
                if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
                  break label1315;
                }
                localObject1 = parama1.Kkd.getMMResources().getString(2131764409);
                label1129:
                ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                if (!bu.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
                  parama.KDT = false;
                  parama.oOD = 2;
                  paramString.Kyv.setTag(parama);
                  paramString.Kyv.setOnClickListener(fLI());
                  paramString.Kyv.setOnDoubleClickListener(this);
                  paramString.Kyv.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
                  paramString.Kyv.setOnLongClickListener(c(parama1));
                  paramString.Kyv.setVisibility(0);
                }
              }
            }
            for (;;)
            {
              a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
              AppMethodBeat.o(36958);
              return;
              label1268:
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
              break;
              label1278:
              paramString.rLB.setVisibility(8);
              break label306;
              if (parambv.field_status >= 2) {
                break label1359;
              }
              bool = true;
              parama = paramString;
              break label375;
              localObject2 = null;
              break label1052;
              localObject1 = parambv.field_transBrandWording;
              break label1129;
              if (paramString.Kyv != null) {
                paramString.Kyv.setVisibility(8);
              }
            }
            parama = null;
            break label851;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36960);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36960);
      return false;
    case 151: 
      s.a(parama, parambv.field_msgId, 2);
      AppMethodBeat.o(36960);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parama = k.b.zb(bl.b(parama.fJB(), parambv.field_content, parambv.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yRN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambv.field_msgSvrId, bu.aSt(parama));
      AppMethodBeat.o(36960);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36960);
      return false;
    case 103: 
      bv(parambv);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(36960);
        return false;
        ((ar)parama.bh(ar.class)).b(paramMenuItem, parambv);
      }
    case 142: 
      localObject = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambv.field_transContent;
      if ((parama.fJC()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()))
      {
        i = bl.BJ(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambv.fvz())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = (android.text.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parambv = parambv.field_transContent;
      if (!bu.isNullOrNil(parambv)) {
        paramMenuItem.setText(parambv);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(36960);
      return true;
      localObject = new cw();
      paramMenuItem = parambv.field_transContent;
      if ((parama.fJC()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()))
      {
        i = bl.BJ(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cw)localObject, paramMenuItem, 1);
        ((cw)localObject).doL.fragment = parama.Kkd;
        ((cw)localObject).doL.doR = 43;
        if (((cw)localObject).doL.doN != null)
        {
          paramMenuItem = ((cw)localObject).doL.doN.GCe;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.aQC(parambv.field_talker);
          paramMenuItem.aQD(com.tencent.mm.model.v.aAC());
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(36960);
          return true;
        }
        ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187766);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((parambv.eNd != null) && (parambv.eNd.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.oOD != 1) {
        break label443;
      }
      ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv)) {
        paraml.a(j, 151, this.JWz.Kkd.getMMResources().getString(2131760101), 2131691573);
      }
      paraml.a(j, 102, this.JWz.Kkd.getMMResources().getString(2131757218), 2131690381);
      paraml.a(j, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      if (parambv.field_status == 5) {
        paraml.a(j, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(j, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType())) {
        paraml.a(j, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((i == 0) && (!parambv.fta()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
        paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if ((com.tencent.mm.app.plugin.c.Nb()) && ((!parambv.fvS()) || (!parambv.fwc()))) {
        paraml.a(j, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if (!this.JWz.fJD()) {
        paraml.a(j, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
    }
    label443:
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187766);
      return true;
      i = 0;
      break;
    }
    ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
    paraml.a(j, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(j, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.br.d.aJN("favorite")) {
      paraml.a(j, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Nb())
    {
      if ((parambv.fvS()) && (parambv.fwc())) {
        paraml.a(j, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambv.fwf()) {
        paraml.a(j, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(187766);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fLz()
  {
    return true;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(36962);
    if (r.gA(paramView))
    {
      ae.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36962);
      return true;
    }
    Object localObject2 = ((MMNeat7extView)paramView).fXo();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof bk))
    {
      localObject2 = (bk)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dCi.field_msgId);
      }
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kk(paramView.getContext());
    AppMethodBeat.o(36962);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */