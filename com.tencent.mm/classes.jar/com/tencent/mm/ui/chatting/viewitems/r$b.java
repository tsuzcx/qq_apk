package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
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
import com.tencent.mm.model.bn;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class r$b
  extends c
  implements NeatTextView.b
{
  private static final int Kyw = 2131305626;
  private static final int Kyx = 2131298134;
  private static final int Kyy = 2131298133;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private CharSequence JZt;
  private int KuT = -1;
  private r.e Kyz;
  private int gqW = -1;
  
  private r.e fLI()
  {
    AppMethodBeat.i(36944);
    if (this.Kyz == null) {
      this.Kyz = new r.e(this.JWz);
    }
    r.e locale = this.Kyz;
    AppMethodBeat.o(36944);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36945);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493440);
      ((View)localObject).setTag(new r.a().gB((View)localObject));
    }
    AppMethodBeat.o(36945);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, final String paramString)
  {
    AppMethodBeat.i(36946);
    this.JWz = parama1;
    ((m)parama1.bh(m.class)).bJ(parambv);
    final r.a locala = (r.a)parama;
    locala.Kyq.setTag(Kyx, Long.valueOf(parambv.field_msgId));
    locala.Kyq.setTag(Kyy, Boolean.TRUE);
    paramString = parambv.field_content;
    parama = paramString;
    int i;
    if (parama1.fJC())
    {
      i = parambv.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambv.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    label288:
    label1470:
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      Object localObject1;
      int j;
      if ((parama != null) && (parama.type == 53))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(parama.appId, true, false);
        if ((localObject1 == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fD(paramString))) {
            break label1383;
          }
          locala.rLB.setText(parama1.Kkd.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.Kkd.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramString) }));
          locala.rLB.setVisibility(0);
          a(parama1, locala.rLB, parama.appId);
          a(parama1, locala.rLB, parama.appId);
          if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv))
          {
            locala.rLB.setText(parama1.Kkd.getMMResources().getString(2131760106));
            locala.rLB.setVisibility(0);
            locala.rLB.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36936);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambv.field_msgId) });
                s.a(parama1, parambv.field_msgId, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36936);
              }
            });
          }
          if ((parama.fmn == null) || (parama.fmn.length() <= 0)) {
            break label1396;
          }
          b(parama1, locala.KvI, bk.aYj(parama.fmn));
          locala.KvI.setVisibility(0);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Kyq.getContext(), parama.title, (int)locala.Kyq.getTextSize(), 1);
          r.a(locala.Kyq.getContext(), parama1, parama.title, paramString, locala.Kyq, parambv, 1);
          locala.Kyq.setClickable(true);
          parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
          paramString = locala.Kyq.getContext();
          locala.Kyq.setTag(Kyw, Boolean.TRUE);
          if (locala.JZs == null)
          {
            locala.JZs = new com.tencent.mm.ui.widget.b.a(paramString, locala.Kyq);
            locala.JZs.LhV = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(179995);
                parama1.setFocused(true);
                c.a(locala.JZs, parama1, r.b.a(r.b.this), r.b.b(r.b.this), 49);
                r.b.a(r.b.this, -1);
                r.b.b(r.b.this, -1);
                AppMethodBeat.o(179995);
              }
            };
            locala.JZs.LwJ = true;
            locala.JZs.LwH = new n.c()
            {
              public final void a(l paramAnonymousl, View paramAnonymousView)
              {
                AppMethodBeat.i(187763);
                paramAnonymousl.clear();
                paramAnonymousl.a(0, 0, paramString.getResources().getString(2131755701), 2131690381);
                paramAnonymousView = locala.Kyq.fXo();
                bk localbk = (bk)locala.Kyq.getTag();
                if (localbk != null) {}
                for (int i = bn.F(localbk.dCi);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymousl.a(0, 1, paramString.getResources().getString(2131761224), 2131691572);
                  }
                  paramAnonymousl.a(0, 2, paramString.getResources().getString(2131761223), 2131690478);
                  paramAnonymousl.a(0, 3, paramString.getResources().getString(2131758845), 2131690400);
                  AppMethodBeat.o(187763);
                  return;
                }
              }
            };
            locala.JZs.LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(179999);
                r.b.a(r.b.this, paramAnonymousInt);
                r.b.b(r.b.this, paramAnonymousMenuItem.getItemId());
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(179999);
                  return;
                  ((android.content.ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(r.b.c(r.b.this), r.b.c(r.b.this)));
                  if (locala.Kyr != null)
                  {
                    locala.Kyr.fRO();
                    locala.Kyr.LCs = true;
                    locala.Kyr.LCt = true;
                    locala.Kyr.fRN();
                  }
                  Toast.makeText(paramString, 2131755702, 0).show();
                  AppMethodBeat.o(179999);
                  return;
                  if (locala.Kyr != null)
                  {
                    if (locala.Kyr.LCd != null) {
                      locala.Kyr.LCd.fLD();
                    }
                    locala.Kyr.LCs = true;
                    locala.Kyr.fRN();
                    locala.Kyr.kw(0, locala.Kyq.fXo().length());
                    locala.Kyr.fRQ();
                    locala.Kyr.fRT();
                    if (locala.Kyr.LCd != null)
                    {
                      locala.Kyr.LCd.fLE();
                      AppMethodBeat.o(179999);
                      return;
                      paramAnonymousMenuItem = (bk)locala.Kyq.getTag();
                      if (paramAnonymousMenuItem != null)
                      {
                        paramAnonymousMenuItem = bn.E(paramAnonymousMenuItem.dCi);
                        Object localObject;
                        if (bu.isNullOrNil(paramAnonymousMenuItem))
                        {
                          localObject = new Intent(paramString, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", r.b.c(r.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymousMenuItem = paramString;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(179999);
                          return;
                        }
                        com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new r.b.4.1(this, paramAnonymousMenuItem), new r.b.4.2(this));
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = new cw();
                        com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, r.b.c(r.b.this).toString(), 1);
                        paramAnonymousMenuItem.doL.fragment = r.b.d(r.b.this).Kkd;
                        paramAnonymousMenuItem.doL.doR = 43;
                        if (paramAnonymousMenuItem.doL.doN != null)
                        {
                          localObject = paramAnonymousMenuItem.doL.doN.GCe;
                          if (localObject != null)
                          {
                            bk localbk = (bk)locala.Kyq.getTag();
                            if (localbk != null)
                            {
                              ((akt)localObject).aQC(localbk.dCi.field_talker);
                              ((akt)localObject).aQD(com.tencent.mm.model.v.aAC());
                              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                            }
                          }
                        }
                        if (locala.Kyr != null)
                        {
                          locala.Kyr.fRO();
                          locala.Kyr.LCs = true;
                          locala.Kyr.LCt = true;
                          locala.Kyr.fRN();
                        }
                      }
                    }
                  }
                }
              }
            };
          }
          if (bn.z(parambv)) {
            break label1409;
          }
          j = bn.F(parambv);
          if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.hm(locala.Kyq).length())) {
            break label1517;
          }
          j = 0;
        }
      }
      label975:
      label1383:
      label1517:
      for (;;)
      {
        paramString = c(parama1);
        localObject1 = a(paramString);
        if (locala.Kyr != null) {
          locala.Kyr.destroy();
        }
        Object localObject2 = new int[2];
        i = 0;
        if (locala.Kyq != null)
        {
          locala.Kyq.getLocationOnScreen((int[])localObject2);
          int k = localObject2[0];
          i = k;
          if (k == 0)
          {
            localObject2 = new Rect();
            locala.Kyq.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new a.a(locala.Kyq, locala.JZs, (a.f)localObject1, fLI(), locala.Kys);
          ((a.a)localObject1).LCj = 2131100846;
          ((a.a)localObject1).LCD = 18;
          ((a.a)localObject1).LCk = 2131100195;
          if (i != 0) {
            ((a.a)localObject1).LCE = (aq.ay(locala.Kyq.getContext(), 2131165289) + i);
          }
          locala.Kyr = ((a.a)localObject1).fRW();
          locala.Kyt = new r.d(locala.Kyr);
          locala.Kyr.LCb = new com.tencent.mm.ui.base.v()
          {
            public final void am(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180000);
              r.b.a(r.b.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180000);
            }
          };
          locala.Kur = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180001);
              locala.Kyr.fRO();
              locala.Kyr.LCs = true;
              locala.Kyr.LCt = true;
              locala.Kyr.fRN();
              AppMethodBeat.o(180001);
            }
          };
          paramString.Kur = locala.Kur;
          locala.Kyr.LCo = j;
          locala.Kyr.LCz = locala.Kyt;
          label895:
          locala.Kyq.setOnDoubleClickListener(this);
          locala.Kyq.setTag(parama);
          locala.Kyq.setTextListener(new MMNeat7extView.a()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180002);
              if (((Boolean)locala.Kyq.getTag(r.b.Kyy)).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.fLp();
                com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)locala.Kyq.getTag(r.b.Kyx)).longValue());
              }
              AppMethodBeat.o(180002);
            }
          });
          locala.Kyq.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.b.KCw;
          if (com.tencent.mm.app.plugin.c.Nb()) {
            if ((parambv.fvS()) && (parambv.fwc()))
            {
              parama = parambv.field_transContent;
              paramString = ((ar)parama1.bh(ar.class)).bT(parambv);
            }
          }
          for (;;)
          {
            if ((!bu.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.KCw))
            {
              if ((locala.Kyv == null) && (locala.Kyu != null))
              {
                locala.Kyv = ((ChattingItemTranslate)locala.Kyu.inflate());
                locala.Kyv.init();
              }
              localObject2 = locala.Kyq.getContext();
              i = (int)locala.Kyq.getTextSize();
              if (parambv != null)
              {
                localObject1 = z.Br(parambv.field_msgSvrId);
                z.b localb = z.aBG().F((String)localObject1, true);
                localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
                localb.k("preUsername", b(this.JWz, parambv));
                localb.k("preChatName", c(this.JWz, parambv));
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, parama, i, 1, null, (String)localObject1);
                ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.Kyv.a((CharSequence)localObject1, paramString);
                localObject1 = locala.Kyv;
                if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
                  break label1470;
                }
              }
              for (paramString = parama1.Kkd.getMMResources().getString(2131764409);; paramString = parambv.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!bu.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
                  parama.KDT = false;
                  parama.oOD = 2;
                  locala.Kyv.setTag(parama);
                  locala.Kyv.setOnClickListener(fLI());
                  locala.Kyv.setOnDoubleClickListener(this);
                  locala.Kyv.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
                  locala.Kyv.setOnLongClickListener(c(parama1));
                  locala.Kyv.setVisibility(0);
                }
                AppMethodBeat.o(36946);
                return;
                paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
                break;
                locala.rLB.setVisibility(8);
                break label288;
                label1396:
                locala.KvI.setVisibility(8);
                break label388;
                locala.Kyq.setTag(Kyw, Boolean.FALSE);
                locala.Kyq.setOnTouchListener(locala.Kys);
                locala.Kyq.setOnLongClickListener(c(parama1));
                locala.Kyq.setOnClickListener(fLI());
                break label895;
                localObject1 = null;
                break label1176;
              }
            }
            if (locala.Kyv != null) {
              locala.Kyv.setVisibility(8);
            }
            AppMethodBeat.o(36946);
            return;
            parama = null;
            break label975;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36948);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36948);
      return false;
    case 151: 
      s.a(parama, parambv.field_msgId, 2);
      AppMethodBeat.o(36948);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parama = k.b.zb(bl.b(parama.fJB(), parambv.field_content, parambv.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yRN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambv.field_msgSvrId, bu.aSt(parama));
      AppMethodBeat.o(36948);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36948);
      return false;
    case 124: 
    case 125: 
      ((ar)parama.bh(ar.class)).b(paramMenuItem, parambv);
      AppMethodBeat.o(36948);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parambv = parambv.field_transContent;
      if (!bu.isNullOrNil(parambv)) {
        paramMenuItem.setText(parambv);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(36948);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
          AppMethodBeat.o(36948);
          return true;
        }
        ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187764);
    if (parambv.eNd != null) {
      parambv.eNd.contains("announcement@all");
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oOD == 1)
    {
      ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv)) {
        paraml.a(i, 151, this.JWz.Kkd.getMMResources().getString(2131760101), 2131691573);
      }
      paraml.a(i, 102, this.JWz.Kkd.getMMResources().getString(2131757218), 2131690381);
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(i, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType())) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((com.tencent.mm.app.plugin.c.Nb()) && ((!parambv.fvS()) || (!parambv.fwc()))) {
        paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      if (bn.z(parambv))
      {
        paraml.clear();
        if (!this.JWz.fJD()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
      }
    }
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187764);
      return true;
    }
    ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
    paraml.a(i, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(i, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.br.d.aJN("favorite")) {
      paraml.a(i, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Nb())
    {
      if ((parambv.fvS()) && (parambv.fwc())) {
        paraml.a(i, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambv.fwf()) {
        paraml.a(i, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(187764);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(36949);
    if (r.gA(paramView))
    {
      ae.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36949);
      return true;
    }
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bk)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).fXo();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dCi.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kk(paramView.getContext());
    }
    AppMethodBeat.o(36949);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.b
 * JD-Core Version:    0.7.0.1
 */