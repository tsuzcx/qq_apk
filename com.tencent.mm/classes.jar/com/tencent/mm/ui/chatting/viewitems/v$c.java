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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ba.f;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.HashMap;
import java.util.Map;

public final class v$c
  extends c
  implements t.n, NeatTextView.b
{
  private static final int Kyw = 2131305626;
  private static final int Kyx = 2131298134;
  private static final int Kyy = 2131298133;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private CharSequence JZt;
  private int KuT = -1;
  private v.f KyP;
  private int gqW = -1;
  
  private v.f fLK()
  {
    AppMethodBeat.i(37025);
    if (this.KyP == null) {
      this.KyP = new v.f(this.JWz);
    }
    v.f localf = this.KyP;
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
      ((View)localObject).setTag(new v.a().gG((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37031);
    if (parambv.fvR())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().yC(parambv.field_msgId);
      Pair localPair = com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      if (localPair != null)
      {
        if (localb == null) {
          break label138;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        ae.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        bl.rW(parambv.field_msgId);
        parama.xY(true);
        AppMethodBeat.o(37031);
        return;
        label138:
        ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(37031);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (v.a)parama;
    this.JWz = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
    paramString.Kyq.setTag(Kyx, Long.valueOf(parambv.field_msgId));
    paramString.Kyq.setTag(Kyy, Boolean.TRUE);
    parama = parambv.field_content;
    if (parama != null) {}
    label400:
    label412:
    label1312:
    label1350:
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      Object localObject1;
      boolean bool;
      int i;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.Kyq.getContext(), parama.title, (int)paramString.Kyq.getTextSize(), 1);
        paramString.Kyq.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.Kyq.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.Kkd.getContext(), paramString.rLB.getTextSize(), parambv, parama.hFq);
        paramString.rLB.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.Kyq.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.rLB.setTag(parama.hFq);
        bool = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        parama = t.aKt().GD(parama1.getTalkerUserName());
        bc.aCg();
        i = ((Integer)com.tencent.mm.model.c.ajA().get(12311, Integer.valueOf(-2))).intValue();
        if (((parama == null) || (parama.ilF == -2)) && ((parama != null) || (i == -2))) {
          break label1350;
        }
        if (!bool) {
          break label1312;
        }
        paramString.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100211));
        paramString.KyO.setBackgroundResource(2131233363);
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label1431;
        }
        paramString.rLB.setVisibility(0);
        paramString.olI.setVisibility(0);
        paramString.olI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37018);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            try
            {
              long l = ((Long)paramString.Kyq.getTag(v.c.ceb())).longValue();
              ae.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
              localObject = (MsgQuoteItem)paramString.rLB.getTag();
              v.e.a(parama1, v.c.this, paramAnonymousView, l, (MsgQuoteItem)localObject, v.c.this.oZq);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37018);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
              }
            }
          }
        });
        paramString.rLB.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37019);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString.olI.getLayoutParams();
            localLayoutParams.height = paramString.KyO.getHeight();
            localLayoutParams.width = paramString.KyO.getWidth();
            paramString.olI.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(37019);
          }
        });
        if (!fLB()) {
          break label1468;
        }
      }
      label1097:
      label1492:
      label1533:
      for (;;)
      {
        bool = false;
        parama = paramString;
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
              AppMethodBeat.i(180017);
              parama1.setFocused(true);
              c.a(paramString.JZs, parama1, v.c.a(v.c.this), v.c.b(v.c.this), 49);
              v.c.a(v.c.this, -1);
              v.c.b(v.c.this, -1);
              AppMethodBeat.o(180017);
            }
          };
          paramString.JZs.LwJ = true;
          paramString.JZs.LwH = new n.c()
          {
            public final void a(l paramAnonymousl, View paramAnonymousView)
            {
              AppMethodBeat.i(187778);
              paramAnonymousl.clear();
              paramAnonymousl.a(0, 0, this.val$context.getResources().getString(2131755701), 2131690381);
              paramAnonymousl.a(0, 1, this.val$context.getResources().getString(2131761224), 2131691572);
              paramAnonymousl.a(0, 2, this.val$context.getResources().getString(2131761223), 2131690478);
              paramAnonymousl.a(0, 3, this.val$context.getResources().getString(2131758845), 2131690400);
              boolean bool;
              if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
              {
                paramAnonymousl.a(0, 4, this.val$context.getResources().getString(2131762922), 2131690474);
                bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(v.c.c(v.c.this).toString());
                if ((!bool) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
                  break label250;
                }
                v.c.this.a(paramString.JZs, parama1);
              }
              for (;;)
              {
                paramAnonymousl = "65_" + ch.aDc();
                v.c.this.a(parama1, parambv, 1, bool, v.c.c(v.c.this).toString(), true, paramAnonymousl);
                AppMethodBeat.o(187778);
                return;
                label250:
                paramString.JZs.LwO = null;
              }
            }
          };
          paramString.JZs.LfT = new n.e()
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
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(v.c.c(v.c.this), v.c.c(v.c.this)));
                if (paramString.Kyr != null)
                {
                  paramString.Kyr.fRO();
                  paramString.Kyr.LCs = true;
                  paramString.Kyr.LCt = true;
                  paramString.Kyr.fRN();
                }
                Toast.makeText(this.val$context, 2131755702, 0).show();
                AppMethodBeat.o(180019);
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
                    AppMethodBeat.o(180019);
                    return;
                    Object localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", v.c.c(v.c.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = this.val$context;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180019);
                    return;
                    paramAnonymousMenuItem = new cw();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, v.c.c(v.c.this).toString(), 1);
                    paramAnonymousMenuItem.doL.fragment = v.c.d(v.c.this).Kkd;
                    paramAnonymousMenuItem.doL.doR = 43;
                    Object localObject2;
                    if (paramAnonymousMenuItem.doL.doN != null)
                    {
                      localObject1 = paramAnonymousMenuItem.doL.doN.GCe;
                      if (localObject1 != null)
                      {
                        localObject2 = (bk)paramString.Kyq.getTag();
                        if (localObject2 != null)
                        {
                          ((akt)localObject1).aQC(((bk)localObject2).dCi.field_talker);
                          ((akt)localObject1).aQD(com.tencent.mm.model.v.aAC());
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
                      AppMethodBeat.o(180019);
                      return;
                      paramAnonymousMenuItem = "65_" + ch.aDc();
                      localObject1 = v.c.c(v.c.this).toString();
                      boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                      v.c.this.a(parama1, parambv, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
                      localObject2 = new HashMap();
                      ((HashMap)localObject2).put("parentSearchID", "");
                      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.val$context, 65, (String)localObject1, paramAnonymousMenuItem, (Map)localObject2);
                    }
                  }
                }
              }
            }
          };
        }
        localObject1 = c(parama1);
        Object localObject2 = a(c(parama1));
        if (paramString.Kyr != null) {
          paramString.Kyr.destroy();
        }
        Object localObject3 = new int[2];
        i = 0;
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
        localObject2 = new a.a(paramString.Kyq, paramString.JZs, (a.f)localObject2, fLK(), paramString.Kys);
        ((a.a)localObject2).LCj = 2131100135;
        ((a.a)localObject2).LCD = 18;
        ((a.a)localObject2).LCk = 2131100133;
        if (i != 0) {
          ((a.a)localObject2).LCE = (i + aq.ay(paramString.Kyq.getContext(), 2131165284));
        }
        paramString.Kyr = ((a.a)localObject2).fRW();
        paramString.Kyt = new v.d(paramString.Kyr);
        paramString.Kyr.LCb = new com.tencent.mm.ui.base.v()
        {
          public final void am(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180020);
            v.c.a(v.c.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180020);
          }
        };
        paramString.Kur = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180021);
            paramString.Kyr.fRO();
            paramString.Kyr.LCs = true;
            paramString.Kyr.LCt = true;
            paramString.Kyr.fRN();
            AppMethodBeat.o(180021);
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
            AppMethodBeat.i(180022);
            if (((Boolean)paramString.Kyq.getTag(v.c.bdD())).booleanValue())
            {
              com.tencent.mm.ui.chatting.m.a.a.fLp();
              com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)paramString.Kyq.getTag(v.c.ceb())).longValue());
            }
            AppMethodBeat.o(180022);
          }
        });
        localObject1 = ChattingItemTranslate.b.KCw;
        if (com.tencent.mm.app.plugin.c.Nb()) {
          if ((parambv.fvS()) && (parambv.fwc()))
          {
            parama = parambv.field_transContent;
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
              ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
              paramString.Kyv.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
              localObject2 = paramString.Kyv;
              if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
                break label1492;
              }
              localObject1 = parama1.Kkd.getMMResources().getString(2131764409);
              ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
              if (!bu.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
                parama.KDT = false;
                parama.oOD = 2;
                paramString.Kyv.setTag(parama);
                paramString.Kyv.setOnClickListener(fLK());
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
            AppMethodBeat.o(37027);
            return;
            paramString.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100710));
            paramString.KyO.setBackgroundResource(2131233362);
            break;
            if (bool)
            {
              paramString.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099658));
              paramString.KyO.setBackgroundResource(2131233361);
              break;
            }
            paramString.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100211));
            paramString.KyO.setBackgroundResource(2131233360);
            break;
            if (bu.ah((CharSequence)((Pair)localObject1).second)) {
              paramString.rLB.setVisibility(8);
            }
            paramString.olI.setVisibility(8);
            break label400;
            if (parambv.field_status >= 2) {
              break label1533;
            }
            bool = true;
            parama = paramString;
            break label412;
            localObject2 = null;
            break label1097;
            localObject1 = parambv.field_transBrandWording;
            break label1173;
            if (paramString.Kyv != null) {
              paramString.Kyv.setVisibility(8);
            }
          }
          parama = null;
          break label896;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
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
      paramMenuItem = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard");
      parama = k.b.zb(bl.b(parama.fJB(), parambv.field_content, parambv.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yRN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambv.field_msgSvrId, bu.aSt(parama));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      if (!this.JWz.getTalkerUserName().equals("medianote"))
      {
        bc.aCg();
        com.tencent.mm.model.c.azE().d(new f(parambv.field_talker, parambv.field_msgSvrId));
      }
      com.tencent.mm.ui.chatting.ak.bv(parambv);
      this.JWz.xY(true);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard");
      parambv = parambv.field_transContent;
      if (!bu.isNullOrNil(parambv)) {
        paramMenuItem.setText(parambv);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(37030);
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
          AppMethodBeat.o(37030);
          return true;
        }
        ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187779);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((parambv.eNd != null) && (parambv.eNd.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.oOD != 1) {
        break label398;
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
    label398:
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187779);
      return true;
      i = 0;
      break;
    }
    ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
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
    AppMethodBeat.o(187779);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fLz()
  {
    return true;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(37032);
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
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kk(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.c
 * JD-Core Version:    0.7.0.1
 */