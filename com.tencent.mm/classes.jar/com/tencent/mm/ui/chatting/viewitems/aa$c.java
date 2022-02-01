package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class aa$c
  extends c
  implements t.n, NeatTextView.b
{
  private static final int PKJ = 2131308867;
  private static final int PKK = 2131298495;
  private static final int PKL = 2131298494;
  private int PHj = -1;
  private aa.f PLc;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private CharSequence PkM;
  private int hcg = -1;
  
  private void cM(ca paramca)
  {
    AppMethodBeat.i(233756);
    if (paramca.gDy())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().Hl(paramca.field_msgId);
      Pair localPair = com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      if (localPair != null)
      {
        if (localb == null) {
          break label137;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        bp.Ad(paramca.field_msgId);
        this.PhN.BN(true);
        AppMethodBeat.o(233756);
        return;
        label137:
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(233756);
  }
  
  private aa.f gUf()
  {
    AppMethodBeat.i(37025);
    if (this.PLc == null) {
      this.PLc = new aa.f(this.PhN);
    }
    aa.f localf = this.PLc;
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
      localObject = new an(paramLayoutInflater, 2131493595);
      ((View)localObject).setTag(new aa.a().gW((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (aa.a)parama;
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    paramString.PKD.setTag(PKK, Long.valueOf(paramca.field_msgId));
    paramString.PKD.setTag(PKL, Boolean.TRUE);
    Object localObject1 = paramca.field_content;
    if (localObject1 != null)
    {
      parama = k.b.aD((String)localObject1, paramca.field_reserved);
      if (parama == null)
      {
        parama = ((String)localObject1).substring(((String)localObject1).indexOf("<refermsg>"), ((String)localObject1).indexOf("</refermsg>"));
        parama = parama.substring(parama.indexOf("<displayname>") + 13, parama.indexOf("</displayname>"));
        parama = k.b.aD(((String)localObject1).replace(parama, Util.escapeStringForXml(parama)), paramca.field_reserved);
      }
    }
    label1552:
    for (;;)
    {
      boolean bool;
      int i;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = t.Ao(parama1.gRM());
        localObject1 = l.a(paramString.PKD.getContext(), parama.title, (int)paramString.PKD.getTextSize(), 1, false, localObject1, l.Krf);
        paramString.PKD.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.PKD.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.Pwc.getContext(), paramString.tln.getTextSize(), paramca, parama.izy);
        paramString.tln.setText(l.c(paramString.PKD.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.tln.setTag(parama.izy);
        bool = ((k)parama1.bh(k.class)).isInEditMode();
        parama = v.bew().Pp(parama1.getTalkerUserName());
        bg.aVF();
        i = ((Integer)com.tencent.mm.model.c.azQ().get(12311, Integer.valueOf(-2))).intValue();
        if (((parama == null) || (parama.jgE == -2)) && ((parama != null) || (i == -2))) {
          break label1434;
        }
        if (!bool) {
          break label1396;
        }
        paramString.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100244));
        paramString.PLb.setBackgroundResource(2131234044);
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label1515;
        }
        paramString.tln.setVisibility(0);
        paramString.clickArea.setVisibility(0);
        paramString.clickArea.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37018);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            try
            {
              long l = ((Long)paramString.PKD.getTag(aa.c.bUp())).longValue();
              Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
              localObject = (MsgQuoteItem)paramString.tln.getTag();
              aa.e.a(parama1, aa.c.this, paramAnonymousView, l, (MsgQuoteItem)localObject, aa.c.this.qoo);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37018);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
              }
            }
          }
        });
        paramString.tln.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37019);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString.clickArea.getLayoutParams();
            localLayoutParams.height = paramString.PLb.getHeight();
            localLayoutParams.width = paramString.PLb.getWidth();
            paramString.clickArea.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(37019);
          }
        });
        label484:
        if (!gTW()) {
          break label1552;
        }
      }
      label980:
      label1620:
      for (;;)
      {
        bool = false;
        parama = paramString;
        label496:
        b(parama, bool);
        parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
        parama.PQG = false;
        localObject1 = paramString.PKD.getContext();
        paramString.PKD.setTag(PKJ, Boolean.TRUE);
        if (paramString.wnj == null)
        {
          paramString.wnj = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.PKD);
          paramString.wnj.QwU = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180017);
              parama1.setFocused(true);
              c.a(paramString.wnj, parama1, aa.c.a(aa.c.this), aa.c.b(aa.c.this), 49);
              aa.c.a(aa.c.this, -1);
              aa.c.b(aa.c.this, -1);
              AppMethodBeat.o(180017);
            }
          };
          paramString.wnj.QSv = true;
          paramString.wnj.QSt = new o.e()
          {
            public final void a(com.tencent.mm.ui.base.m paramAnonymousm, View paramAnonymousView)
            {
              AppMethodBeat.i(233753);
              paramAnonymousm.clear();
              paramAnonymousm.a(0, 0, this.val$context.getResources().getString(2131755772), 2131690525);
              paramAnonymousm.a(0, 1, this.val$context.getResources().getString(2131763038), 2131690480);
              paramAnonymousm.a(0, 2, this.val$context.getResources().getString(2131763036), 2131690674);
              paramAnonymousm.a(0, 3, this.val$context.getResources().getString(2131759168), 2131690551);
              if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
              {
                paramAnonymousm.a(0, 4, this.val$context.getResources().getString(2131757451), 2131690670);
                if (!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                  break label298;
                }
                paramAnonymousm = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(aa.c.c(aa.c.this).toString());
                if (!Util.isNullOrNil(paramAnonymousm)) {
                  aa.c.this.a(paramString.wnj, parama1, paramAnonymousm);
                }
              }
              for (;;)
              {
                if (Util.isNullOrNil(paramAnonymousm)) {
                  paramString.wnj.QSA = null;
                }
                paramAnonymousView = "65_" + cl.aWA();
                aa.c localc = aa.c.this;
                com.tencent.mm.ui.chatting.e.a locala = parama1;
                ca localca = paramca;
                if (!Util.isNullOrNil(paramAnonymousm)) {}
                for (boolean bool = true;; bool = false)
                {
                  localc.a(locala, localca, 1, bool, aa.c.c(aa.c.this).toString(), true, paramAnonymousView);
                  AppMethodBeat.o(233753);
                  return;
                }
                label298:
                paramAnonymousm = "";
              }
            }
          };
          paramString.wnj.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180019);
              aa.c.a(aa.c.this, paramAnonymousInt);
              aa.c.b(aa.c.this, paramAnonymousMenuItem.getItemId());
              switch (paramAnonymousMenuItem.getItemId())
              {
              default: 
              case 0: 
              case 1: 
              case 2: 
              case 3: 
                do
                {
                  do
                  {
                    do
                    {
                      AppMethodBeat.o(180019);
                      return;
                      ClipboardHelper.setText(MMApplicationContext.getContext(), aa.c.c(aa.c.this), aa.c.c(aa.c.this));
                      if (paramString.PKE != null)
                      {
                        paramString.PKE.hbA();
                        paramString.PKE.QXW = true;
                        paramString.PKE.QXX = true;
                        paramString.PKE.hbz();
                      }
                      Toast.makeText(this.val$context, 2131755773, 0).show();
                      AppMethodBeat.o(180019);
                      return;
                    } while (paramString.PKE == null);
                    if (paramString.PKE.QXQ != null) {
                      paramString.PKE.QXQ.gTY();
                    }
                    paramString.PKE.QXW = true;
                    paramString.PKE.hbz();
                    paramString.PKE.lE(0, paramString.PKD.hiT().length());
                    paramString.PKE.hcQ();
                    paramString.PKE.hcT();
                  } while (paramString.PKE.QXQ == null);
                  paramString.PKE.QXQ.gTZ();
                  AppMethodBeat.o(180019);
                  return;
                  localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                  ((Intent)localObject1).putExtra("Retr_Msg_content", aa.c.c(aa.c.this));
                  ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                  paramAnonymousMenuItem = this.val$context;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(180019);
                  return;
                  paramAnonymousMenuItem = new cz();
                  com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, aa.c.c(aa.c.this).toString(), 1);
                  paramAnonymousMenuItem.dFZ.fragment = aa.c.d(aa.c.this).Pwc;
                  paramAnonymousMenuItem.dFZ.dGf = 43;
                  if (paramAnonymousMenuItem.dFZ.dGb != null)
                  {
                    localObject1 = paramAnonymousMenuItem.dFZ.dGb.Lya;
                    if (localObject1 != null)
                    {
                      localObject2 = (bq)paramString.PKD.getTag();
                      if (localObject2 != null)
                      {
                        ((anh)localObject1).bhf(((bq)localObject2).dTX.field_talker);
                        ((anh)localObject1).bhg(z.aTY());
                        EventCenter.instance.publish(paramAnonymousMenuItem);
                      }
                    }
                  }
                } while (paramString.PKE == null);
                paramString.PKE.hbA();
                paramString.PKE.QXW = true;
                paramString.PKE.QXX = true;
                paramString.PKE.hbz();
                AppMethodBeat.o(180019);
                return;
              }
              Object localObject1 = "65_" + cl.aWA();
              Object localObject2 = aa.c.c(aa.c.this).toString();
              if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {}
              for (paramAnonymousMenuItem = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject2);; paramAnonymousMenuItem = "")
              {
                aa.c localc = aa.c.this;
                com.tencent.mm.ui.chatting.e.a locala = parama1;
                ca localca = paramca;
                if (!Util.isNullOrNil(paramAnonymousMenuItem)) {}
                for (boolean bool = true;; bool = false)
                {
                  localc.a(locala, localca, 2, bool, (String)localObject2, true, (String)localObject1);
                  paramAnonymousMenuItem = new ag();
                  paramAnonymousMenuItem.context = this.val$context;
                  paramAnonymousMenuItem.scene = 65;
                  paramAnonymousMenuItem.query = ((String)localObject2);
                  paramAnonymousMenuItem.sessionId = ((String)localObject1);
                  paramAnonymousMenuItem.IEk = true;
                  ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(paramAnonymousMenuItem);
                  break;
                }
              }
            }
          };
        }
        localObject1 = c(parama1);
        Object localObject2 = a(c(parama1));
        if (paramString.PKE != null) {
          paramString.PKE.destroy();
        }
        Object localObject3 = new int[2];
        i = 0;
        if (paramString.PKD != null)
        {
          paramString.PKD.getLocationInWindow((int[])localObject3);
          int j = localObject3[0];
          i = j;
          if (j == 0)
          {
            localObject3 = new Rect();
            paramString.PKD.getGlobalVisibleRect((Rect)localObject3);
            i = ((Rect)localObject3).left;
          }
        }
        for (;;)
        {
          localObject2 = new a.a(paramString.PKD, paramString.wnj, (a.f)localObject2, gUf(), paramString.PKF);
          ((a.a)localObject2).QPi = 2131100167;
          ((a.a)localObject2).QYg = 18;
          ((a.a)localObject2).QPj = 2131100165;
          if (i != 0) {
            ((a.a)localObject2).QYh = (at.aH(paramString.PKD.getContext(), 2131165289) + i);
          }
          paramString.PKE = ((a.a)localObject2).hcW();
          paramString.PKG = new aa.d(paramString.PKE);
          paramString.PKE.QXO = new x()
          {
            public final void as(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180020);
              aa.c.a(aa.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180020);
            }
          };
          paramString.PGP = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180021);
              paramString.PKE.hbA();
              paramString.PKE.QXW = true;
              paramString.PKE.QXX = true;
              paramString.PKE.hbz();
              AppMethodBeat.o(180021);
            }
          };
          ((c.c)localObject1).PGP = paramString.PGP;
          paramString.PKE.QYc = paramString.PKG;
          paramString.PKD.setOnDoubleClickListener(this);
          paramString.PKD.setTag(parama);
          paramString.PKD.setTextListener(new MMNeat7extView.a()
          {
            public final void at(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180022);
              if (((Boolean)paramString.PKD.getTag(aa.c.byU())).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)paramString.PKD.getTag(aa.c.bUp())).longValue());
              }
              AppMethodBeat.o(180022);
            }
          });
          localObject1 = ChattingItemTranslate.c.PPm;
          if (com.tencent.mm.app.plugin.c.Xn()) {
            if ((paramca.gDz()) && (paramca.gDI()))
            {
              parama = paramca.field_transContent;
              localObject1 = ((au)parama1.bh(au.class)).cj(paramca);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.c.PPm))
            {
              if ((paramString.PKI == null) && (paramString.PKH != null))
              {
                paramString.PKI = ((ChattingItemTranslate)paramString.PKH.inflate());
                paramString.PKI.init();
              }
              localObject3 = paramString.PKD.getContext();
              i = (int)paramString.PKD.getTextSize();
              if (paramca != null)
              {
                localObject2 = ad.JX(paramca.field_msgSvrId);
                ad.b localb = ad.aVe().G((String)localObject2, true);
                localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
                localb.l("preUsername", a(this.PhN, paramca));
                localb.l("preChatName", b(this.PhN, paramca));
                localObject2 = l.a((Context)localObject3, parama, i, 1, null, (String)localObject2);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
                paramString.PKI.a((CharSequence)localObject2, (ChattingItemTranslate.c)localObject1);
                localObject2 = paramString.PKI;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1576;
                }
                localObject1 = parama1.Pwc.getMMResources().getString(2131766752);
                label1257:
                ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                  parama.PQG = false;
                  parama.qcr = 2;
                  paramString.PKI.setTag(parama);
                  paramString.PKI.setOnClickListener(gUf());
                  paramString.PKI.setOnDoubleClickListener(this);
                  paramString.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                  paramString.PKI.setOnLongClickListener(c(parama1));
                  paramString.PKI.setVisibility(0);
                }
              }
            }
            for (;;)
            {
              a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
              AppMethodBeat.o(37027);
              return;
              label1396:
              paramString.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100903));
              paramString.PLb.setBackgroundResource(2131234043);
              break;
              if (bool)
              {
                paramString.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099660));
                paramString.PLb.setBackgroundResource(2131234042);
                break;
              }
              paramString.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100244));
              paramString.PLb.setBackgroundResource(2131234041);
              break;
              label1515:
              if (Util.isNullOrNil((CharSequence)((Pair)localObject1).second)) {
                paramString.tln.setVisibility(8);
              }
              paramString.clickArea.setVisibility(8);
              break label484;
              if (paramca.field_status >= 2) {
                break label1620;
              }
              bool = true;
              parama = paramString;
              break label496;
              localObject2 = null;
              break label1181;
              localObject1 = paramca.field_transBrandWording;
              break label1257;
              if (paramString.PKI != null) {
                paramString.PKI.setVisibility(8);
              }
            }
            parama = null;
            break label980;
            parama = null;
          }
        }
      }
      label1181:
      label1576:
      continue;
      label1434:
      parama = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
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
      paramMenuItem = k.b.HD(bp.b(parama.gRL(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
      com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      cM(paramca);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
        return false;
        ((au)parama.bh(au.class)).b(paramMenuItem, paramca);
      }
    case 142: 
      localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      paramMenuItem = paramca.field_transContent;
      if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
      {
        i = bp.Kp(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramca.gDg())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = paramca.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
      AppMethodBeat.o(37030);
      return true;
      localObject = new cz();
      paramMenuItem = paramca.field_transContent;
      if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
      {
        i = bp.Kp(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.h.b((cz)localObject, paramMenuItem, 1);
        ((cz)localObject).dFZ.fragment = parama.Pwc;
        ((cz)localObject).dFZ.dGf = 43;
        if (((cz)localObject).dFZ.dGb != null)
        {
          paramMenuItem = ((cz)localObject).dFZ.dGb.Lya;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bhf(paramca.field_talker);
          paramMenuItem.bhg(z.aTY());
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(37030);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233754);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((paramca.fqK != null) && (paramca.fqK.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.qcr != 1) {
        break label398;
      }
      paramm.a(j, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
      paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      if (paramca.field_status == 5) {
        paramm.a(j, 103, paramView.getContext().getString(2131757500), 2131690658);
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(j, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
        paramm.a(j, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if ((i == 0) && (!paramca.gAt()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
        paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
        paramm.a(j, 124, paramView.getContext().getString(2131757455), 2131690699);
      }
      if (!this.PhN.gRN()) {
        paramm.a(j, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      }
    }
    label398:
    while (locala.qcr != 2)
    {
      AppMethodBeat.o(233754);
      return true;
      i = 0;
      break;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
    paramm.a(j, 141, paramView.getContext().getString(2131757430), 2131690525);
    paramm.a(j, 142, paramView.getContext().getString(2131764628), 2131690674);
    if (com.tencent.mm.br.c.aZU("favorite")) {
      paramm.a(j, 143, paramView.getContext().getString(2131763947), 2131690551);
    }
    if (com.tencent.mm.app.plugin.c.Xn())
    {
      if ((paramca.gDz()) && (paramca.gDI())) {
        paramm.a(j, 124, paramView.getContext().getString(2131757453), 2131690549);
      }
      if (paramca.gDL()) {
        paramm.a(j, 125, paramView.getContext().getString(2131757445), 2131690658);
      }
    }
    AppMethodBeat.o(233754);
    return false;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233755);
    cM(paramca);
    AppMethodBeat.o(233755);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gS(View paramView)
  {
    AppMethodBeat.i(37032);
    Object localObject2 = ((MMNeat7extView)paramView).hiT();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof bq))
    {
      localObject2 = (bq)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bq)localObject2).dTX.field_msgId);
      }
    }
    if (this.PhN != null) {
      ((Intent)localObject1).putExtra("is_group_chat", this.PhN.gRM());
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kc(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.c
 * JD-Core Version:    0.7.0.1
 */