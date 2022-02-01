package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Pair;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.a.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ab$c
  extends c
  implements v.n, NeatTextView.b
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQy = R.h.fYD;
  private static final int aeQz = R.h.fza;
  private int aeMA = -1;
  private ab.f aeQU;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private void dE(cc paramcc)
  {
    AppMethodBeat.i(255292);
    if (paramcc.jbS())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().sv(paramcc.field_msgId);
      Pair localPair = n.bx(paramcc);
      if (localPair != null)
      {
        if (localb == null) {
          break label136;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        br.iu(paramcc.field_msgId);
        this.aeiK.jpK();
        AppMethodBeat.o(255292);
        return;
        label136:
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(255292);
  }
  
  private ab.f jxu()
  {
    AppMethodBeat.i(37025);
    if (this.aeQU == null) {
      this.aeQU = new ab.f(this.aeiK);
    }
    ab.f localf = this.aeQU;
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
      localObject = new ap(paramLayoutInflater, R.i.ggR);
      ((View)localObject).setTag(new ab.a().lE((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (ab.a)parama;
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
    paramString.aeQs.setTag(aeQz, Long.valueOf(paramcc.field_msgId));
    paramString.aeQs.setTag(aeQA, Boolean.TRUE);
    Object localObject1 = paramcc.field_content;
    if (localObject1 != null)
    {
      parama = com.tencent.mm.message.k.b.aP((String)localObject1, paramcc.field_reserved);
      if (parama == null)
      {
        parama = ((String)localObject1).substring(((String)localObject1).indexOf("<refermsg>"), ((String)localObject1).indexOf("</refermsg>"));
        parama = parama.substring(parama.indexOf("<displayname>") + 13, parama.indexOf("</displayname>"));
        parama = com.tencent.mm.message.k.b.aP(((String)localObject1).replace(parama, Util.escapeStringForXml(parama)), paramcc.field_reserved);
      }
    }
    for (;;)
    {
      boolean bool;
      Object localObject2;
      int i;
      int j;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = x.aq(parama1.juG(), com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
        localObject1 = p.a(paramString.aeQs.getContext(), parama.title, (int)paramString.aeQs.getTextSize(), 1, localObject1, p.YoF);
        paramString.aeQs.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.aeQs.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.aezO.getContext(), paramString.Aoo.getTextSize(), paramcc, parama.nTU);
        paramString.Aoo.setText(p.b(paramString.aeQs.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.Aoo.setTag(parama.nTU);
        bool = ((m)parama1.cm(m.class)).jqo();
        localObject2 = u.bLI().OM(parama1.getTalkerUserName());
        bh.bCz();
        i = ((Integer)com.tencent.mm.model.c.ban().d(12311, Integer.valueOf(-2))).intValue();
        if (((localObject2 == null) || (((com.tencent.mm.modelpackage.a)localObject2).oQj == -2)) && ((localObject2 != null) || (i == -2))) {
          break label1770;
        }
        if (!bool) {
          break label1732;
        }
        paramString.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.desc_text));
        paramString.aeQT.setBackgroundResource(R.g.foB);
        parama = ab.e.a(ab.e.a(parama1, paramcc.field_msgId, parama.nTU, "handleQuoteMsgFillingTo"), parama.nTU);
        i = com.tencent.mm.plugin.msgquote.model.a.bh(parama);
        if (i == -1) {
          break label1864;
        }
        paramString.Yft.setVisibility(0);
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        ((g)com.tencent.mm.ui.component.k.nq(parama1.aezO.getContext()).q(g.class)).setValue("quote_img", "");
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.ui.a.d)com.tencent.mm.ui.component.k.nq(parama1.aezO.getContext()).q(com.tencent.mm.ui.a.d.class)).setValue("quote_img", "");
        j = (int)(bd.fromDPToPix(parama1.aezO.getContext(), 240) / com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
        paramString.Aoo.setMaxWidth(j);
        localObject2 = (RelativeLayout.LayoutParams)paramString.Aoo.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(15);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_A);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
        paramString.Aoo.setGravity(48);
        paramString.Aoo.setIncludeFontPadding(false);
        paramString.Aoo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramString.Yfv.setVisibility(0);
        if (i != 2) {
          break label1851;
        }
        paramString.Yfu.setVisibility(0);
        label685:
        paramString.Yft.setImageBitmap(null);
        if (!com.tencent.mm.plugin.msgquote.model.a.a(parama1.aezO.getContext(), paramString.Yft, paramString.Yfu, parama, false)) {
          paramString.Yft.setImageResource(R.k.icons_filled_pic_error1);
        }
        label730:
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label2008;
        }
        paramString.Aoo.setVisibility(0);
        paramString.clickArea.setVisibility(0);
        paramString.clickArea.setOnClickListener(new ab.c.1(this, paramString, parama1));
        paramString.clickArea.setOnLongClickListener(new ab.c.2(this, paramString, parama1, paramcc));
        paramString.Aoo.post(new ab.c.3(this, paramString));
        label821:
        if (!jxj()) {
          break label2065;
        }
      }
      label833:
      label1732:
      label1864:
      label2133:
      for (;;)
      {
        bool = false;
        parama = paramString;
        b(parama, bool);
        parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
        parama.aeXR = false;
        localObject1 = paramString.aeQs.getContext();
        paramString.aeQs.setTag(aeQy, Boolean.TRUE);
        if (paramString.GAa == null)
        {
          paramString.GAa = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.aeQs);
          paramString.GAa.afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(255744);
              parama1.aE(true);
              c.a(paramString.GAa, parama1, ab.c.a(ab.c.this), ab.c.b(ab.c.this), 49);
              ab.c.a(ab.c.this, -1);
              ab.c.b(ab.c.this, -1);
              AppMethodBeat.o(255744);
            }
          };
          paramString.GAa.agjw = true;
          paramString.GAa.agju = new u.f()
          {
            public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              boolean bool = false;
              AppMethodBeat.i(255762);
              paramAnonymouss.clear();
              paramAnonymouss.a(0, 0, this.val$context.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
              paramAnonymouss.a(0, 1, this.val$context.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
              paramAnonymouss.a(0, 2, this.val$context.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
              paramAnonymouss.a(0, 3, this.val$context.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
              paramAnonymouss.a(0, 4, this.val$context.getResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
              paramAnonymouss = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(ab.c.c(ab.c.this).toString());
              if (!Util.isNullOrNil(paramAnonymouss)) {
                ab.c.this.a(paramString.GAa, parama1, paramAnonymouss);
              }
              if (Util.isNullOrNil(paramAnonymouss)) {
                paramString.GAa.agjF = null;
              }
              paramAnonymousView = "65_" + cn.bDw();
              paramAnonymousContextMenuInfo = ab.c.this;
              com.tencent.mm.ui.chatting.d.a locala = parama1;
              cc localcc = paramcc;
              if (!Util.isNullOrNil(paramAnonymouss)) {
                bool = true;
              }
              paramAnonymousContextMenuInfo.a(locala, localcc, 1, bool, ab.c.c(ab.c.this).toString(), true, paramAnonymousView, 3);
              AppMethodBeat.o(255762);
            }
          };
          paramString.GAa.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(255768);
              ab.c.a(ab.c.this, paramAnonymousInt);
              ab.c.b(ab.c.this, paramAnonymousMenuItem.getItemId());
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
                      AppMethodBeat.o(255768);
                      return;
                      ClipboardHelper.setText(MMApplicationContext.getContext(), ab.c.c(ab.c.this), ab.c.c(ab.c.this));
                      if (paramString.aeQt != null)
                      {
                        paramString.aeQt.cRQ();
                        paramString.aeQt.agoW = true;
                        paramString.aeQt.agoX = true;
                        paramString.aeQt.cRT();
                      }
                      Toast.makeText(this.val$context, R.l.app_copy_ok, 0).show();
                      AppMethodBeat.o(255768);
                      return;
                    } while (paramString.aeQt == null);
                    if (paramString.aeQt.agoQ != null) {
                      paramString.aeQt.agoQ.jxm();
                    }
                    paramString.aeQt.agoW = true;
                    paramString.aeQt.cRT();
                    paramString.aeQt.gc(0, paramString.aeQs.jPy().length());
                    paramString.aeQt.jJo();
                    paramString.aeQt.jJr();
                  } while (paramString.aeQt.agoQ == null);
                  paramString.aeQt.agoQ.jxn();
                  AppMethodBeat.o(255768);
                  return;
                  localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                  ((Intent)localObject1).putExtra("Retr_Msg_content", ab.c.c(ab.c.this));
                  ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                  paramAnonymousMenuItem = this.val$context;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$6", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$6", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(255768);
                  return;
                  paramAnonymousMenuItem = new dn();
                  l.b(paramAnonymousMenuItem, ab.c.c(ab.c.this).toString(), 1);
                  paramAnonymousMenuItem.hDr.fragment = ab.c.d(ab.c.this).aezO;
                  paramAnonymousMenuItem.hDr.hDy = 43;
                  if (paramAnonymousMenuItem.hDr.hDt != null)
                  {
                    localObject1 = paramAnonymousMenuItem.hDr.hDt.ZBt;
                    if (localObject1 != null)
                    {
                      localObject2 = (bz)paramString.aeQs.getTag();
                      if (localObject2 != null)
                      {
                        ((asb)localObject1).bto(((bz)localObject2).hTm.field_talker);
                        ((asb)localObject1).btp(z.bAM());
                        paramAnonymousMenuItem.publish();
                      }
                    }
                  }
                } while (paramString.aeQt == null);
                paramString.aeQt.cRQ();
                paramString.aeQt.agoW = true;
                paramString.aeQt.agoX = true;
                paramString.aeQt.cRT();
                AppMethodBeat.o(255768);
                return;
              }
              paramAnonymousMenuItem = "65_" + cn.bDw();
              Object localObject1 = ab.c.c(ab.c.this).toString();
              Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
              ab.c localc = ab.c.this;
              com.tencent.mm.ui.chatting.d.a locala = parama1;
              cc localcc = paramcc;
              if (!Util.isNullOrNil((String)localObject2)) {}
              for (boolean bool = true;; bool = false)
              {
                localc.a(locala, localcc, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                localObject2 = new ah();
                ((ah)localObject2).context = this.val$context;
                ((ah)localObject2).scene = 65;
                ((ah)localObject2).query = ((String)localObject1);
                ((ah)localObject2).sessionId = paramAnonymousMenuItem;
                ((ah)localObject2).WoH = true;
                ((ah)localObject2).WoJ = false;
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((ah)localObject2);
                break;
              }
            }
          };
        }
        localObject1 = c(parama1);
        localObject2 = a(c(parama1));
        if (paramString.aeQt != null) {
          paramString.aeQt.destroy();
        }
        Object localObject3 = new int[2];
        i = 0;
        if (paramString.aeQs != null)
        {
          paramString.aeQs.getLocationInWindow((int[])localObject3);
          j = localObject3[0];
          i = j;
          if (j == 0)
          {
            localObject3 = new Rect();
            paramString.aeQs.getGlobalVisibleRect((Rect)localObject3);
            i = ((Rect)localObject3).left;
          }
        }
        for (;;)
        {
          localObject2 = new a.a(paramString.aeQs, paramString.GAa, (a.f)localObject2, jxu(), paramString.aeQu);
          ((a.a)localObject2).aggi = R.e.chat_to_selected;
          ((a.a)localObject2).agpg = 18;
          ((a.a)localObject2).aggj = R.e.chat_to_cursor_handle_color;
          if (i != 0) {
            ((a.a)localObject2).agph = (bd.bs(paramString.aeQs.getContext(), R.f.Edge_1_5_A) + i);
          }
          paramString.aeQt = ((a.a)localObject2).jJu();
          paramString.aeQv = new ab.d(paramString.aeQt);
          paramString.aeQt.agoO = new ab.c.7(this);
          paramString.aeMh = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(255760);
              paramString.aeQt.cRQ();
              paramString.aeQt.agoW = true;
              paramString.aeQt.agoX = true;
              paramString.aeQt.cRT();
              AppMethodBeat.o(255760);
            }
          };
          ((c.c)localObject1).aeMh = paramString.aeMh;
          paramString.aeQt.agpc = paramString.aeQv;
          paramString.aeQs.setOnDoubleClickListener(this);
          paramString.aeQs.setTag(parama);
          paramString.aeQs.setTextListener(new MMNeat7extView.a()
          {
            public final void aW(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(255720);
              if (((Boolean)paramString.aeQs.getTag(ab.c.dsI())).booleanValue())
              {
                com.tencent.mm.ui.chatting.j.a.a.jwS();
                com.tencent.mm.ui.chatting.j.a.a.jwT().a(paramAnonymousCharSequence, ((Long)paramString.aeQs.getTag(ab.c.ddn())).longValue());
              }
              AppMethodBeat.o(255720);
            }
          });
          localObject1 = ChattingItemTranslate.c.aeWe;
          if (com.tencent.mm.app.plugin.d.aDO()) {
            if ((paramcc.jbT()) && (paramcc.jca()))
            {
              parama = paramcc.field_transContent;
              localObject1 = ((bc)parama1.cm(bc.class)).cZ(paramcc);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.c.aeWe))
            {
              if ((paramString.aeQx == null) && (paramString.aeQw != null))
              {
                paramString.aeQx = ((ChattingItemTranslate)paramString.aeQw.inflate());
                paramString.aeQx.init();
              }
              localObject3 = paramString.aeQs.getContext();
              i = (int)paramString.aeQs.getTextSize();
              if (paramcc != null)
              {
                localObject2 = ad.Jo(paramcc.field_msgSvrId);
                ad.b localb = ad.bCb().M((String)localObject2, true);
                localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
                localb.q("preUsername", a(this.aeiK, paramcc));
                localb.q("preChatName", b(this.aeiK, paramcc));
                label1518:
                localObject2 = p.a((Context)localObject3, parama, i, null, (String)localObject2);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
                paramString.aeQx.a((CharSequence)localObject2, (ChattingItemTranslate.c)localObject1);
                localObject2 = paramString.aeQx;
                if (!Util.isNullOrNil(paramcc.field_transBrandWording)) {
                  break label2089;
                }
                localObject1 = parama1.aezO.getMMResources().getString(R.l.gXo);
                ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
                  parama.aeXR = false;
                  parama.viewType = 2;
                  paramString.aeQx.setTag(parama);
                  paramString.aeQx.setOnClickListener(jxu());
                  paramString.aeQx.setOnDoubleClickListener(this);
                  paramString.aeQx.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
                  paramString.aeQx.setOnLongClickListener(c(parama1));
                  paramString.aeQx.setVisibility(0);
                }
              }
            }
            for (;;)
            {
              a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
              AppMethodBeat.o(37027);
              return;
              paramString.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.normal_text));
              paramString.aeQT.setBackgroundResource(R.g.foA);
              break;
              label1770:
              if (bool)
              {
                paramString.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.BW_0_Alpha_0_2));
                paramString.aeQT.setBackgroundResource(R.g.foz);
                break;
              }
              paramString.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.desc_text));
              paramString.aeQT.setBackgroundResource(R.g.foy);
              break;
              paramString.Yfu.setVisibility(8);
              break label685;
              i = (int)(bd.fromDPToPix(parama1.aezO.getContext(), 259) / com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
              paramString.Aoo.setMaxWidth(i);
              parama = (RelativeLayout.LayoutParams)paramString.Aoo.getLayoutParams();
              parama.rightMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_A);
              parama.topMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_0_25A);
              parama.removeRule(10);
              parama.addRule(15);
              paramString.Aoo.setGravity(19);
              paramString.Aoo.setLayoutParams(parama);
              paramString.Yfv.setVisibility(8);
              paramString.Yft.setVisibility(8);
              paramString.Yfu.setVisibility(8);
              break label730;
              label2008:
              if (Util.isNullOrNil((CharSequence)((Pair)localObject1).second)) {
                paramString.Aoo.setVisibility(8);
              }
              paramString.Yft.setVisibility(8);
              paramString.Yfu.setVisibility(8);
              paramString.clickArea.setVisibility(8);
              break label821;
              if (paramcc.field_status >= 2) {
                break label2133;
              }
              bool = true;
              parama = paramString;
              break label833;
              localObject2 = null;
              break label1518;
              localObject1 = paramcc.field_transBrandWording;
              break label1593;
              if (paramString.aeQx != null) {
                paramString.aeQx.setVisibility(8);
              }
            }
            parama = null;
            break label1317;
            parama = null;
          }
        }
      }
      label1317:
      label1593:
      label1851:
      continue;
      label2065:
      label2089:
      parama = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
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
      paramMenuItem = com.tencent.mm.message.k.b.Hf(br.a(parama.juF(), paramcc.field_content, paramcc.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      dE(paramcc);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
        return false;
        ((bc)parama.cm(bc.class)).b(paramMenuItem, paramcc);
      }
    case 142: 
      localObject = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem = paramcc.field_transContent;
      if ((parama.juG()) && (!((e)parama.cm(e.class)).jqV()))
      {
        i = br.JG(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramcc.jbw())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = paramcc.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(37030);
      return true;
      localObject = new dn();
      paramMenuItem = paramcc.field_transContent;
      if ((parama.juG()) && (!((e)parama.cm(e.class)).jqV()))
      {
        i = br.JG(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        l.b((dn)localObject, paramMenuItem, 1);
        ((dn)localObject).hDr.fragment = parama.aezO;
        ((dn)localObject).hDr.hDy = 43;
        if (((dn)localObject).hDr.hDt != null)
        {
          paramMenuItem = ((dn)localObject).hDr.hDt.ZBt;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bto(paramcc.field_talker);
          paramMenuItem.btp(z.bAM());
          ((dn)localObject).publish();
          AppMethodBeat.o(37030);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255326);
    int i;
    int j;
    if ((paramcc.jUr != null) && (paramcc.jUr.contains("announcement@all")))
    {
      i = 1;
      paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
      j = paramContextMenuInfo.position;
      if (paramContextMenuInfo.viewType != 1) {
        break label414;
      }
      if (!bt.Q(paramcc))
      {
        params.a(j, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
        params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (paramcc.field_status == 5) {
        params.a(j, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(j, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType())) {
        params.a(j, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((i == 0) && (!paramcc.iYe()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
        params.a(j, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if ((com.tencent.mm.app.plugin.d.aDO()) && ((!paramcc.jbT()) || (!paramcc.jca()))) {
        params.a(j, 124, paramView.getContext().getString(R.l.gyI), R.k.icons_filled_translate);
      }
      if (!this.aeiK.juH()) {
        params.a(j, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
    }
    label414:
    while (paramContextMenuInfo.viewType != 2)
    {
      AppMethodBeat.o(255326);
      return true;
      i = 0;
      break;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
    params.a(j, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
    params.a(j, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(j, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (com.tencent.mm.app.plugin.d.aDO())
    {
      if ((paramcc.jbT()) && (paramcc.jca())) {
        params.a(j, 124, paramView.getContext().getString(R.l.gyG), R.k.icons_filled_eyes_off);
      }
      if (paramcc.jcd()) {
        params.a(j, 125, paramView.getContext().getString(R.l.gyz), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(255326);
    return false;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255341);
    dE(paramcc);
    AppMethodBeat.o(255341);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(37032);
    Object localObject2 = ((MMNeat7extView)paramView).jPy();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof bz))
    {
      localObject2 = (bz)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bz)localObject2).hTm.field_msgId);
      }
    }
    if (this.aeiK != null) {
      ((Intent)localObject1).putExtra("is_group_chat", this.aeiK.juG());
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ne(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c
 * JD-Core Version:    0.7.0.1
 */