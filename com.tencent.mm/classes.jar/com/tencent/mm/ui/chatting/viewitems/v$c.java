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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bb.f;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class v$c
  extends c
  implements s.n, NeatTextView.b
{
  private static final int Kce = 2131305626;
  private static final int Kcf = 2131298134;
  private static final int Kcg = 2131298133;
  private com.tencent.mm.ui.chatting.e.a JBI;
  private CharSequence JEC;
  private int JYA = -1;
  private v.f Kcx;
  private int goB = -1;
  
  private v.f fHs()
  {
    AppMethodBeat.i(37025);
    if (this.Kcx == null) {
      this.Kcx = new v.f(this.JBI);
    }
    v.f localf = this.Kcx;
    AppMethodBeat.o(37025);
    return localf;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37026);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493488);
      ((View)localObject).setTag(new v.a().gB((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37031);
    if (parambu.frR())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().yi(parambu.field_msgId);
      Pair localPair = com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
      if (localPair != null)
      {
        if (localb == null) {
          break label138;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        ad.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        bj.rJ(parambu.field_msgId);
        parama.xR(true);
        AppMethodBeat.o(37031);
        return;
        label138:
        ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(37031);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (v.a)parama;
    this.JBI = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
    paramString.KbY.setTag(Kcf, Long.valueOf(parambu.field_msgId));
    paramString.KbY.setTag(Kcg, Boolean.TRUE);
    parama = parambu.field_content;
    if (parama != null) {}
    label400:
    label412:
    label1089:
    label1484:
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      Object localObject1;
      boolean bool;
      int i;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.KbY.getContext(), parama.title, (int)paramString.KbY.getTextSize(), 1);
        paramString.KbY.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.KbY.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.JOR.getContext(), paramString.rDq.getTextSize(), parambu, parama.hCy);
        paramString.rDq.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.KbY.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.rDq.setTag(parama.hCy);
        bool = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        parama = t.aKa().Gb(parama1.getTalkerUserName());
        ba.aBQ();
        i = ((Integer)com.tencent.mm.model.c.ajl().get(12311, Integer.valueOf(-2))).intValue();
        if (((parama == null) || (parama.iiM == -2)) && ((parama != null) || (i == -2))) {
          break label1342;
        }
        if (!bool) {
          break label1304;
        }
        paramString.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100211));
        paramString.Kcw.setBackgroundResource(2131233363);
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label1423;
        }
        paramString.rDq.setVisibility(0);
        paramString.ofK.setVisibility(0);
        paramString.ofK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37018);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            try
            {
              long l = ((Long)paramString.KbY.getTag(v.c.ccM())).longValue();
              ad.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
              localObject = (MsgQuoteItem)paramString.rDq.getTag();
              v.e.a(parama1, v.c.this, paramAnonymousView, l, (MsgQuoteItem)localObject, v.c.this.oSO);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37018);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
              }
            }
          }
        });
        paramString.rDq.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37019);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString.ofK.getLayoutParams();
            localLayoutParams.height = paramString.Kcw.getHeight();
            localLayoutParams.width = paramString.Kcw.getWidth();
            paramString.ofK.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(37019);
          }
        });
        if (!fHj()) {
          break label1460;
        }
      }
      label888:
      label1528:
      for (;;)
      {
        bool = false;
        parama = paramString;
        b(parama, bool);
        parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
        parama.Khy = false;
        localObject1 = paramString.KbY.getContext();
        paramString.KbY.setTag(Kce, Boolean.TRUE);
        if (paramString.JEB == null)
        {
          paramString.JEB = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.KbY);
          paramString.JEB.KLB = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180017);
              parama1.setFocused(true);
              c.a(paramString.JEB, parama1, v.c.a(v.c.this), v.c.b(v.c.this), 49);
              v.c.a(v.c.this, -1);
              v.c.b(v.c.this, -1);
              AppMethodBeat.o(180017);
            }
          };
          paramString.JEB.Lal = true;
          paramString.JEB.Laj = new n.c()
          {
            public final void a(l paramAnonymousl, View paramAnonymousView)
            {
              AppMethodBeat.i(194383);
              paramAnonymousl.clear();
              paramAnonymousl.a(0, 0, this.val$context.getResources().getString(2131755701), 2131690381);
              paramAnonymousl.a(0, 1, this.val$context.getResources().getString(2131761224), 2131691572);
              paramAnonymousl.a(0, 2, this.val$context.getResources().getString(2131761223), 2131690478);
              paramAnonymousl.a(0, 3, this.val$context.getResources().getString(2131758845), 2131690400);
              AppMethodBeat.o(194383);
            }
          };
          paramString.JEB.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180019);
              v.c.a(v.c.this, paramAnonymousInt);
              v.c.b(v.c.this, paramAnonymousMenuItem.getItemId());
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180019);
                return;
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(v.c.c(v.c.this), v.c.c(v.c.this)));
                if (paramString.KbZ != null)
                {
                  paramString.KbZ.fNt();
                  paramString.KbZ.LfQ = true;
                  paramString.KbZ.LfR = true;
                  paramString.KbZ.fNs();
                }
                Toast.makeText(this.val$context, 2131755702, 0).show();
                AppMethodBeat.o(180019);
                return;
                if (paramString.KbZ != null)
                {
                  if (paramString.KbZ.LfB != null) {
                    paramString.KbZ.LfB.fHl();
                  }
                  paramString.KbZ.LfQ = true;
                  paramString.KbZ.fNs();
                  paramString.KbZ.kp(0, paramString.KbY.fSO().length());
                  paramString.KbZ.fNv();
                  paramString.KbZ.fNy();
                  if (paramString.KbZ.LfB != null)
                  {
                    paramString.KbZ.LfB.fHm();
                    AppMethodBeat.o(180019);
                    return;
                    Object localObject = new Intent(this.val$context, MsgRetransmitUI.class);
                    ((Intent)localObject).putExtra("Retr_Msg_content", v.c.c(v.c.this));
                    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = this.val$context;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180019);
                    return;
                    paramAnonymousMenuItem = new cv();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, v.c.c(v.c.this).toString(), 1);
                    paramAnonymousMenuItem.dnG.fragment = v.c.d(v.c.this).JOR;
                    paramAnonymousMenuItem.dnG.dnM = 43;
                    if (paramAnonymousMenuItem.dnG.dnI != null)
                    {
                      localObject = paramAnonymousMenuItem.dnG.dnI.Gjv;
                      if (localObject != null)
                      {
                        bk localbk = (bk)paramString.KbY.getTag();
                        if (localbk != null)
                        {
                          ((akj)localObject).aPf(localbk.dBd.field_talker);
                          ((akj)localObject).aPg(u.aAm());
                          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                        }
                      }
                    }
                    if (paramString.KbZ != null)
                    {
                      paramString.KbZ.fNt();
                      paramString.KbZ.LfQ = true;
                      paramString.KbZ.LfR = true;
                      paramString.KbZ.fNs();
                    }
                  }
                }
              }
            }
          };
        }
        localObject1 = c(parama1);
        Object localObject2 = a(c(parama1));
        if (paramString.KbZ != null) {
          paramString.KbZ.destroy();
        }
        Object localObject3 = new int[2];
        i = 0;
        if (paramString.KbY != null)
        {
          paramString.KbY.getLocationOnScreen((int[])localObject3);
          int j = localObject3[0];
          i = j;
          if (j == 0)
          {
            localObject3 = new Rect();
            paramString.KbY.getGlobalVisibleRect((Rect)localObject3);
            i = ((Rect)localObject3).left;
          }
        }
        for (;;)
        {
          localObject2 = new a.a(paramString.KbY, paramString.JEB, (a.f)localObject2, fHs(), paramString.Kca);
          ((a.a)localObject2).LfH = 2131100135;
          ((a.a)localObject2).Lgb = 18;
          ((a.a)localObject2).LfI = 2131100133;
          if (i != 0) {
            ((a.a)localObject2).Lgc = (com.tencent.mm.ui.aq.ay(paramString.KbY.getContext(), 2131165284) + i);
          }
          paramString.KbZ = ((a.a)localObject2).fNB();
          paramString.Kcb = new v.d(paramString.KbZ);
          paramString.KbZ.Lfz = new v()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180020);
              v.c.a(v.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180020);
            }
          };
          paramString.JXY = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180021);
              paramString.KbZ.fNt();
              paramString.KbZ.LfQ = true;
              paramString.KbZ.LfR = true;
              paramString.KbZ.fNs();
              AppMethodBeat.o(180021);
            }
          };
          ((c.c)localObject1).JXY = paramString.JXY;
          paramString.KbZ.LfX = paramString.Kcb;
          paramString.KbY.setOnDoubleClickListener(this);
          paramString.KbY.setTag(parama);
          paramString.KbY.setTextListener(new MMNeat7extView.a()
          {
            public final void ao(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180022);
              if (((Boolean)paramString.KbY.getTag(v.c.bcY())).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.fGX();
                com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)paramString.KbY.getTag(v.c.ccM())).longValue());
              }
              AppMethodBeat.o(180022);
            }
          });
          localObject1 = ChattingItemTranslate.b.Kgd;
          if (com.tencent.mm.app.plugin.c.Ng()) {
            if ((parambu.frS()) && (parambu.fsb()))
            {
              parama = parambu.field_transContent;
              localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
            }
          }
          for (;;)
          {
            if ((!bt.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.b.Kgd))
            {
              if ((paramString.Kcd == null) && (paramString.Kcc != null))
              {
                paramString.Kcd = ((ChattingItemTranslate)paramString.Kcc.inflate());
                paramString.Kcd.init();
              }
              localObject3 = paramString.KbY.getContext();
              i = (int)paramString.KbY.getTextSize();
              if (parambu != null)
              {
                localObject2 = y.AH(parambu.field_msgSvrId);
                y.b localb = y.aBq().F((String)localObject2, true);
                localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
                localb.k("preUsername", b(this.JBI, parambu));
                localb.k("preChatName", c(this.JBI, parambu));
                localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject3, parama, i, 1, null, (String)localObject2);
                ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
                paramString.Kcd.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
                localObject2 = paramString.Kcd;
                if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
                  break label1484;
                }
                localObject1 = parama1.JOR.getMMResources().getString(2131764409);
                ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                if (!bt.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
                  parama.Khy = false;
                  parama.oIb = 2;
                  paramString.Kcd.setTag(parama);
                  paramString.Kcd.setOnClickListener(fHs());
                  paramString.Kcd.setOnDoubleClickListener(this);
                  paramString.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                  paramString.Kcd.setOnLongClickListener(c(parama1));
                  paramString.Kcd.setVisibility(0);
                }
              }
            }
            for (;;)
            {
              a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
              AppMethodBeat.o(37027);
              return;
              paramString.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100710));
              paramString.Kcw.setBackgroundResource(2131233362);
              break;
              if (bool)
              {
                paramString.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099658));
                paramString.Kcw.setBackgroundResource(2131233361);
                break;
              }
              paramString.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100211));
              paramString.Kcw.setBackgroundResource(2131233360);
              break;
              if (bt.ai((CharSequence)((Pair)localObject1).second)) {
                paramString.rDq.setVisibility(8);
              }
              paramString.ofK.setVisibility(8);
              break label400;
              if (parambu.field_status >= 2) {
                break label1528;
              }
              bool = true;
              parama = paramString;
              break label412;
              localObject2 = null;
              break label1089;
              localObject1 = parambu.field_transBrandWording;
              break label1165;
              if (paramString.Kcd != null) {
                paramString.Kcd.setVisibility(8);
              }
            }
            parama = null;
            break label888;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37030);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37030);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
      parama = k.b.yr(bj.b(parama.fFu(), parambu.field_content, parambu.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yBN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(parama));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      if (!this.JBI.getTalkerUserName().equals("medianote"))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new f(parambu.field_talker, parambu.field_msgSvrId));
      }
      com.tencent.mm.ui.chatting.aj.bw(parambu);
      this.JBI.xR(true);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
        return false;
        ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, parambu);
      }
    case 142: 
      localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambu.field_transContent;
      if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
      {
        i = bj.Bh(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambu.frz())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
      parambu = parambu.field_transContent;
      if (!bt.isNullOrNil(parambu)) {
        paramMenuItem.setText(parambu);
      }
      com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
      AppMethodBeat.o(37030);
      return true;
      localObject = new cv();
      paramMenuItem = parambu.field_transContent;
      if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
      {
        i = bj.Bh(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cv)localObject, paramMenuItem, 1);
        ((cv)localObject).dnG.fragment = parama.JOR;
        ((cv)localObject).dnG.dnM = 43;
        if (((cv)localObject).dnG.dnI != null)
        {
          paramMenuItem = ((cv)localObject).dnG.dnI.Gjv;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.aPf(parambu.field_talker);
          paramMenuItem.aPg(u.aAm());
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(37030);
          return true;
        }
        ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194384);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((parambu.eLs != null) && (parambu.eLs.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.oIb != 1) {
        break label398;
      }
      paraml.a(j, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
      paraml.a(j, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      if (parambu.field_status == 5) {
        paraml.a(j, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(j, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
        paraml.a(j, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((i == 0) && (!parambu.fpd()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
        paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
        paraml.a(j, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if (!this.JBI.fFw()) {
        paraml.a(j, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      }
    }
    label398:
    while (locala.oIb != 2)
    {
      AppMethodBeat.o(194384);
      return true;
      i = 0;
      break;
    }
    ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
    paraml.a(j, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(j, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.bs.d.aIu("favorite")) {
      paraml.a(j, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Ng())
    {
      if ((parambu.frS()) && (parambu.fsb())) {
        paraml.a(j, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambu.fse()) {
        paraml.a(j, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(194384);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fHh()
  {
    return true;
  }
  
  public final boolean gx(View paramView)
  {
    AppMethodBeat.i(37032);
    Object localObject2 = ((MMNeat7extView)paramView).fSO();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof bk))
    {
      localObject2 = (bk)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dBd.field_msgId);
      }
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kd(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.c
 * JD-Core Version:    0.7.0.1
 */