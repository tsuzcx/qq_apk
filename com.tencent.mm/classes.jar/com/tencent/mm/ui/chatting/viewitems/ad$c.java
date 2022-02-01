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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.be.w;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ad$c
  extends c
  implements t.n, NeatTextView.b
{
  private static final int XgD = R.h.dVZ;
  private static final int XgE = R.h.dyq;
  private static final int XgF = R.h.dyp;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private CharSequence WEv;
  private int XcC = -1;
  private ad.f XgV;
  private int jNq = -1;
  
  private void df(ca paramca)
  {
    AppMethodBeat.i(280677);
    if (paramca.hzN())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().OA(paramca.field_msgId);
      Pair localPair = com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
      if (localPair != null)
      {
        if (localb == null) {
          break label137;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        bq.Gk(paramca.field_msgId);
        this.WBq.Gi(true);
        AppMethodBeat.o(280677);
        return;
        label137:
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(280677);
  }
  
  private ad.f hTQ()
  {
    AppMethodBeat.i(37025);
    if (this.XgV == null) {
      this.XgV = new ad.f(this.WBq);
    }
    ad.f localf = this.XgV;
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
      localObject = new aq(paramLayoutInflater, R.i.eec);
      ((View)localObject).setTag(new ad.a().ii((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (ad.a)parama;
    this.WBq = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
    paramString.Xgx.setTag(XgE, Long.valueOf(paramca.field_msgId));
    paramString.Xgx.setTag(XgF, Boolean.TRUE);
    Object localObject1 = paramca.field_content;
    if (localObject1 != null)
    {
      parama = k.b.aG((String)localObject1, paramca.field_reserved);
      if (parama == null)
      {
        parama = ((String)localObject1).substring(((String)localObject1).indexOf("<refermsg>"), ((String)localObject1).indexOf("</refermsg>"));
        parama = parama.substring(parama.indexOf("<displayname>") + 13, parama.indexOf("</displayname>"));
        parama = k.b.aG(((String)localObject1).replace(parama, Util.escapeStringForXml(parama)), paramca.field_reserved);
      }
    }
    for (;;)
    {
      boolean bool;
      int i;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = t.ap(parama1.hRi(), com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
        localObject1 = l.a(paramString.Xgx.getContext(), parama.title, (int)paramString.Xgx.getTextSize(), 1, localObject1, l.Rsm);
        paramString.Xgx.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.Xgx.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.WQv.getContext(), paramString.wRL.getTextSize(), paramca, parama.loR);
        paramString.wRL.setText(l.c(paramString.Xgx.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.wRL.setTag(parama.loR);
        bool = ((k)parama1.bC(k.class)).hNH();
        parama = w.bnV().WM(parama1.getTalkerUserName());
        bh.beI();
        i = ((Integer)com.tencent.mm.model.c.aHp().b(12311, Integer.valueOf(-2))).intValue();
        if (((parama == null) || (parama.lXh == -2)) && ((parama != null) || (i == -2))) {
          break label1441;
        }
        if (!bool) {
          break label1403;
        }
        paramString.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.desc_text));
        paramString.XgU.setBackgroundResource(R.g.dod);
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label1522;
        }
        paramString.wRL.setVisibility(0);
        paramString.clickArea.setVisibility(0);
        paramString.clickArea.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37018);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            try
            {
              long l = ((Long)paramString.Xgx.getTag(ad.c.chu())).longValue();
              Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
              localObject = (MsgQuoteItem)paramString.wRL.getTag();
              ad.e.a(parama1, ad.c.this, paramAnonymousView, l, (MsgQuoteItem)localObject, ad.c.this.tMW);
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
        paramString.wRL.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37019);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString.clickArea.getLayoutParams();
            localLayoutParams.height = paramString.XgU.getHeight();
            localLayoutParams.width = paramString.XgU.getWidth();
            paramString.clickArea.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(37019);
          }
        });
        label492:
        if (!hTG()) {
          break label1559;
        }
      }
      label1189:
      label1583:
      label1627:
      for (;;)
      {
        bool = false;
        parama = paramString;
        label504:
        b(parama, bool);
        parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
        parama.XmM = false;
        localObject1 = paramString.Xgx.getContext();
        paramString.Xgx.setTag(XgD, Boolean.TRUE);
        if (paramString.AYp == null)
        {
          paramString.AYp = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.Xgx);
          paramString.AYp.XVa = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180017);
              parama1.Y(true);
              c.a(paramString.AYp, parama1, ad.c.a(ad.c.this), ad.c.b(ad.c.this), 49);
              ad.c.a(ad.c.this, -1);
              ad.c.b(ad.c.this, -1);
              AppMethodBeat.o(180017);
            }
          };
          paramString.AYp.Yri = true;
          paramString.AYp.Yrg = new q.e()
          {
            public final void a(o paramAnonymouso, View paramAnonymousView)
            {
              boolean bool = false;
              AppMethodBeat.i(285232);
              paramAnonymouso.clear();
              paramAnonymouso.a(0, 0, this.val$context.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
              paramAnonymouso.a(0, 1, this.val$context.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
              paramAnonymouso.a(0, 2, this.val$context.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
              paramAnonymouso.a(0, 3, this.val$context.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
              paramAnonymouso.a(0, 4, this.val$context.getResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
              paramAnonymouso = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(ad.c.c(ad.c.this).toString());
              if (!Util.isNullOrNil(paramAnonymouso)) {
                ad.c.this.a(paramString.AYp, parama1, paramAnonymouso);
              }
              if (Util.isNullOrNil(paramAnonymouso)) {
                paramString.AYp.Yrp = null;
              }
              paramAnonymousView = "65_" + cm.bfE();
              ad.c localc = ad.c.this;
              com.tencent.mm.ui.chatting.e.a locala = parama1;
              ca localca = paramca;
              if (!Util.isNullOrNil(paramAnonymouso)) {
                bool = true;
              }
              localc.a(locala, localca, 1, bool, ad.c.c(ad.c.this).toString(), true, paramAnonymousView, 3);
              AppMethodBeat.o(285232);
            }
          };
          paramString.AYp.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180019);
              ad.c.a(ad.c.this, paramAnonymousInt);
              ad.c.b(ad.c.this, paramAnonymousMenuItem.getItemId());
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
                      ClipboardHelper.setText(MMApplicationContext.getContext(), ad.c.c(ad.c.this), ad.c.c(ad.c.this));
                      if (paramString.Xgy != null)
                      {
                        paramString.Xgy.cpn();
                        paramString.Xgy.YwE = true;
                        paramString.Xgy.YwF = true;
                        paramString.Xgy.cpq();
                      }
                      Toast.makeText(this.val$context, R.l.app_copy_ok, 0).show();
                      AppMethodBeat.o(180019);
                      return;
                    } while (paramString.Xgy == null);
                    if (paramString.Xgy.Ywy != null) {
                      paramString.Xgy.Ywy.hTJ();
                    }
                    paramString.Xgy.YwE = true;
                    paramString.Xgy.cpq();
                    paramString.Xgy.fj(0, paramString.Xgx.ikC().length());
                    paramString.Xgy.ief();
                    paramString.Xgy.iei();
                  } while (paramString.Xgy.Ywy == null);
                  paramString.Xgy.Ywy.hTK();
                  AppMethodBeat.o(180019);
                  return;
                  localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                  ((Intent)localObject1).putExtra("Retr_Msg_content", ad.c.c(ad.c.this));
                  ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                  paramAnonymousMenuItem = this.val$context;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(180019);
                  return;
                  paramAnonymousMenuItem = new dd();
                  j.b(paramAnonymousMenuItem, ad.c.c(ad.c.this).toString(), 1);
                  paramAnonymousMenuItem.fyI.fragment = ad.c.d(ad.c.this).WQv;
                  paramAnonymousMenuItem.fyI.fyP = 43;
                  if (paramAnonymousMenuItem.fyI.fyK != null)
                  {
                    localObject1 = paramAnonymousMenuItem.fyI.fyK.SAB;
                    if (localObject1 != null)
                    {
                      localObject2 = (by)paramString.Xgx.getTag();
                      if (localObject2 != null)
                      {
                        ((aoi)localObject1).btx(((by)localObject2).fNz.field_talker);
                        ((aoi)localObject1).bty(z.bcZ());
                        EventCenter.instance.publish(paramAnonymousMenuItem);
                      }
                    }
                  }
                } while (paramString.Xgy == null);
                paramString.Xgy.cpn();
                paramString.Xgy.YwE = true;
                paramString.Xgy.YwF = true;
                paramString.Xgy.cpq();
                AppMethodBeat.o(180019);
                return;
              }
              paramAnonymousMenuItem = "65_" + cm.bfE();
              Object localObject1 = ad.c.c(ad.c.this).toString();
              Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
              ad.c localc = ad.c.this;
              com.tencent.mm.ui.chatting.e.a locala = parama1;
              ca localca = paramca;
              if (!Util.isNullOrNil((String)localObject2)) {}
              for (boolean bool = true;; bool = false)
              {
                localc.a(locala, localca, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                localObject2 = new ag();
                ((ag)localObject2).context = this.val$context;
                ((ag)localObject2).scene = 65;
                ((ag)localObject2).query = ((String)localObject1);
                ((ag)localObject2).sessionId = paramAnonymousMenuItem;
                ((ag)localObject2).PyA = true;
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject2);
                break;
              }
            }
          };
        }
        localObject1 = c(parama1);
        Object localObject2 = a(c(parama1));
        if (paramString.Xgy != null) {
          paramString.Xgy.destroy();
        }
        Object localObject3 = new int[2];
        i = 0;
        if (paramString.Xgx != null)
        {
          paramString.Xgx.getLocationInWindow((int[])localObject3);
          int j = localObject3[0];
          i = j;
          if (j == 0)
          {
            localObject3 = new Rect();
            paramString.Xgx.getGlobalVisibleRect((Rect)localObject3);
            i = ((Rect)localObject3).left;
          }
        }
        for (;;)
        {
          localObject2 = new a.a(paramString.Xgx, paramString.AYp, (a.f)localObject2, hTQ(), paramString.Xgz);
          ((a.a)localObject2).YnW = R.e.chat_to_selected;
          ((a.a)localObject2).YwO = 18;
          ((a.a)localObject2).YnX = R.e.chat_to_cursor_handle_color;
          if (i != 0) {
            ((a.a)localObject2).YwP = (aw.aZ(paramString.Xgx.getContext(), R.f.Edge_1_5_A) + i);
          }
          paramString.Xgy = ((a.a)localObject2).iel();
          paramString.XgA = new ad.d(paramString.Xgy);
          paramString.Xgy.Yww = new ad.c.6(this);
          paramString.Xcj = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180021);
              paramString.Xgy.cpn();
              paramString.Xgy.YwE = true;
              paramString.Xgy.YwF = true;
              paramString.Xgy.cpq();
              AppMethodBeat.o(180021);
            }
          };
          ((c.c)localObject1).Xcj = paramString.Xcj;
          paramString.Xgy.YwK = paramString.XgA;
          paramString.Xgx.setOnDoubleClickListener(this);
          paramString.Xgx.setTag(parama);
          paramString.Xgx.setTextListener(new MMNeat7extView.a()
          {
            public final void aI(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180022);
              if (((Boolean)paramString.Xgx.getTag(ad.c.bKj())).booleanValue())
              {
                com.tencent.mm.ui.chatting.n.a.a.hTq();
                com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)paramString.Xgx.getTag(ad.c.chu())).longValue());
              }
              AppMethodBeat.o(180022);
            }
          });
          localObject1 = ChattingItemTranslate.c.Xlo;
          if (com.tencent.mm.app.plugin.d.abP()) {
            if ((paramca.hzO()) && (paramca.hzW()))
            {
              parama = paramca.field_transContent;
              label988:
              localObject1 = ((av)parama1.bC(av.class)).cC(paramca);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.c.Xlo))
            {
              if ((paramString.XgC == null) && (paramString.XgB != null))
              {
                paramString.XgC = ((ChattingItemTranslate)paramString.XgB.inflate());
                paramString.XgC.init();
              }
              localObject3 = paramString.Xgx.getContext();
              i = (int)paramString.Xgx.getTextSize();
              if (paramca != null)
              {
                localObject2 = ad.Rp(paramca.field_msgSvrId);
                ad.b localb = ad.beh().I((String)localObject2, true);
                localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
                localb.k("preUsername", a(this.WBq, paramca));
                localb.k("preChatName", b(this.WBq, paramca));
                localObject2 = l.a((Context)localObject3, parama, i, null, (String)localObject2);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
                paramString.XgC.a((CharSequence)localObject2, (ChattingItemTranslate.c)localObject1);
                localObject2 = paramString.XgC;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1583;
                }
                localObject1 = parama1.WQv.getMMResources().getString(R.l.eUq);
                label1264:
                ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                  parama.XmM = false;
                  parama.viewType = 2;
                  paramString.XgC.setTag(parama);
                  paramString.XgC.setOnClickListener(hTQ());
                  paramString.XgC.setOnDoubleClickListener(this);
                  paramString.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                  paramString.XgC.setOnLongClickListener(c(parama1));
                  paramString.XgC.setVisibility(0);
                }
              }
            }
            for (;;)
            {
              a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
              AppMethodBeat.o(37027);
              return;
              label1403:
              paramString.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.normal_text));
              paramString.XgU.setBackgroundResource(R.g.doc);
              break;
              if (bool)
              {
                paramString.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.BW_0_Alpha_0_2));
                paramString.XgU.setBackgroundResource(R.g.dob);
                break;
              }
              paramString.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.desc_text));
              paramString.XgU.setBackgroundResource(R.g.doa);
              break;
              label1522:
              if (Util.isNullOrNil((CharSequence)((Pair)localObject1).second)) {
                paramString.wRL.setVisibility(8);
              }
              paramString.clickArea.setVisibility(8);
              break label492;
              if (paramca.field_status >= 2) {
                break label1627;
              }
              bool = true;
              parama = paramString;
              break label504;
              localObject2 = null;
              break label1189;
              localObject1 = paramca.field_transBrandWording;
              break label1264;
              if (paramString.XgC != null) {
                paramString.XgC.setVisibility(8);
              }
            }
            parama = null;
            break label988;
            parama = null;
          }
        }
      }
      label1441:
      continue;
      label1559:
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
      paramMenuItem = k.b.OQ(bq.b(parama.hRh(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
      com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      df(paramca);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
        return false;
        ((av)parama.bC(av.class)).b(paramMenuItem, paramca);
      }
    case 142: 
      localObject = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem = paramca.field_transContent;
      if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
      {
        i = bq.RI(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramca.hzt())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = paramca.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(37030);
      return true;
      localObject = new dd();
      paramMenuItem = paramca.field_transContent;
      if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
      {
        i = bq.RI(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        j.b((dd)localObject, paramMenuItem, 1);
        ((dd)localObject).fyI.fragment = parama.WQv;
        ((dd)localObject).fyI.fyP = 43;
        if (((dd)localObject).fyI.fyK != null)
        {
          paramMenuItem = ((dd)localObject).fyI.fyK.SAB;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.btx(paramca.field_talker);
          paramMenuItem.bty(z.bcZ());
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(37030);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(280670);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((paramca.hxy != null) && (paramca.hxy.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.viewType != 1) {
        break label405;
      }
      if (!bs.O(paramca))
      {
        paramo.a(j, 102, this.WBq.WQv.getMMResources().getString(R.l.evK), R.k.icons_filled_copy);
        paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (paramca.field_status == 5) {
        paramo.a(j, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(j, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType())) {
        paramo.a(j, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if ((i == 0) && (!paramca.hwA()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
        paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      if ((com.tencent.mm.app.plugin.d.abP()) && ((!paramca.hzO()) || (!paramca.hzW()))) {
        paramo.a(j, 124, paramView.getContext().getString(R.l.ewi), R.k.icons_filled_translate);
      }
      if (!this.WBq.hRj()) {
        paramo.a(j, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
    }
    label405:
    while (locala.viewType != 2)
    {
      AppMethodBeat.o(280670);
      return true;
      i = 0;
      break;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
    paramo.a(j, 141, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
    paramo.a(j, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.by.c.blP("favorite")) {
      paramo.a(j, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (com.tencent.mm.app.plugin.d.abP())
    {
      if ((paramca.hzO()) && (paramca.hzW())) {
        paramo.a(j, 124, paramView.getContext().getString(R.l.ewg), R.k.icons_filled_eyes_off);
      }
      if (paramca.hzZ()) {
        paramo.a(j, 125, paramView.getContext().getString(R.l.evZ), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(280670);
    return false;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(280674);
    df(paramca);
    AppMethodBeat.o(280674);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
  
  public final boolean ie(View paramView)
  {
    AppMethodBeat.i(37032);
    Object localObject2 = ((MMNeat7extView)paramView).ikC();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof by))
    {
      localObject2 = (by)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((by)localObject2).fNz.field_msgId);
      }
    }
    if (this.WBq != null) {
      ((Intent)localObject1).putExtra("is_group_chat", this.WBq.hRi());
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.la(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.c
 * JD-Core Version:    0.7.0.1
 */