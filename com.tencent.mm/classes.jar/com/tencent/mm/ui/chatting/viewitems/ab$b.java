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
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ab$b
  extends c
  implements NeatTextView.b
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQy = R.h.fYD;
  private static final int aeQz = R.h.fza;
  private int aeMA = -1;
  private ab.f aeQU;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private ab.f jxu()
  {
    AppMethodBeat.i(37012);
    if (this.aeQU == null) {
      this.aeQU = new ab.f(this.aeiK);
    }
    ab.f localf = this.aeQU;
    AppMethodBeat.o(37012);
    return localf;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37013);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfR);
      ((View)localObject).setTag(new ab.a().lE((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
    final ab.a locala = (ab.a)parama;
    locala.aeQs.setTag(aeQz, Long.valueOf(paramcc.field_msgId));
    locala.aeQs.setTag(aeQA, Boolean.TRUE);
    paramString = paramcc.field_content;
    parama = paramString;
    int i;
    if (parama1.juG())
    {
      i = paramcc.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramcc.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    label2049:
    for (parama = com.tencent.mm.message.k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      boolean bool;
      Object localObject1;
      Object localObject2;
      int j;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.aezO.getContext(), locala.Aoo.getTextSize(), paramcc, parama.nTU);
        locala.Aoo.setText(p.b(locala.aeQs.getContext(), (CharSequence)paramString.second));
        locala.Aoo.setTag(parama.nTU);
        bool = ((m)parama1.cm(m.class)).jqo();
        localObject1 = u.bLI().OM(parama1.getTalkerUserName());
        bh.bCz();
        i = ((Integer)com.tencent.mm.model.c.ban().d(12311, Integer.valueOf(-2))).intValue();
        if (((localObject1 != null) && (((com.tencent.mm.modelpackage.a)localObject1).oQj != -2)) || ((localObject1 == null) && (i != -2))) {
          if (bool)
          {
            locala.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.desc_text));
            locala.aeQT.setBackgroundResource(R.g.foB);
            localObject1 = ab.e.a(ab.e.a(parama1, paramcc.field_msgId, parama.nTU, "handleQuoteMsgFillingFrom"), parama.nTU);
            i = com.tencent.mm.plugin.msgquote.model.a.bh((cc)localObject1);
            if (i == -1) {
              break label1899;
            }
            locala.Yft.setVisibility(0);
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            ((g)com.tencent.mm.ui.component.k.nq(parama1.aezO.getContext()).q(g.class)).setValue("quote_img", parama1.aezO.getContext().getResources().getString(R.l.chatting_img_item_desc));
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            ((com.tencent.mm.ui.a.d)com.tencent.mm.ui.component.k.nq(parama1.aezO.getContext()).q(com.tencent.mm.ui.a.d.class)).setValue("quote_img", parama1.aezO.getContext().getResources().getString(R.l.chatting_img_item_desc));
            j = (int)(bd.fromDPToPix(parama1.aezO.getContext(), 240) / com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
            locala.Aoo.setMaxWidth(j);
            localObject2 = (RelativeLayout.LayoutParams)locala.Aoo.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).removeRule(15);
            ((RelativeLayout.LayoutParams)localObject2).addRule(10);
            ((RelativeLayout.LayoutParams)localObject2).topMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_A);
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
            locala.Aoo.setGravity(48);
            locala.Aoo.setIncludeFontPadding(false);
            locala.Aoo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            locala.Yfv.setVisibility(0);
            if (i != 2) {
              break label1886;
            }
            locala.Yfu.setVisibility(0);
            label616:
            locala.Yft.setImageBitmap(null);
            if (!com.tencent.mm.plugin.msgquote.model.a.a(parama1.aezO.getContext(), locala.Yft, locala.Yfu, (cc)localObject1, true)) {
              locala.Yft.setImageResource(R.k.icons_filled_pic_error1);
            }
            label662:
            if (!((Boolean)paramString.first).booleanValue()) {
              break label2049;
            }
            locala.Aoo.setVisibility(0);
            locala.clickArea.setVisibility(0);
            locala.clickArea.setOnLongClickListener(new ab.b.1(this, locala, parama1, paramcc));
            locala.clickArea.setOnClickListener(new ab.b.2(this, locala, parama1));
            locala.Aoo.post(new ab.b.3(this, locala));
            label753:
            locala.aeNs.setVisibility(8);
            locala.aeQs.setClickable(true);
            paramString = x.aq(parama1.juG(), com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
            parama = p.a(locala.aeQs.getContext(), parama.title, (int)locala.aeQs.getTextSize(), 1, paramString, p.YoF);
            locala.aeQs.a(parama, TextView.BufferType.SPANNABLE);
            parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
            paramString = locala.aeQs.getContext();
            locala.aeQs.setTag(aeQy, Boolean.TRUE);
            if (locala.GAa == null)
            {
              locala.GAa = new com.tencent.mm.ui.widget.b.a(paramString, locala.aeQs);
              locala.GAa.afLp = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(255327);
                  parama1.aE(true);
                  c.a(locala.GAa, parama1, ab.b.a(ab.b.this), ab.b.b(ab.b.this), 49);
                  ab.b.a(ab.b.this, -1);
                  ab.b.b(ab.b.this, -1);
                  AppMethodBeat.o(255327);
                }
              };
              locala.GAa.agjw = true;
              locala.GAa.agju = new u.f()
              {
                public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
                {
                  boolean bool = false;
                  AppMethodBeat.i(255323);
                  paramAnonymouss.clear();
                  paramAnonymouss.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                  paramAnonymousView = locala.aeQs.jPy();
                  paramAnonymousContextMenuInfo = (bz)locala.aeQs.getTag();
                  if (paramAnonymousContextMenuInfo != null) {}
                  for (int i = bt.Y(paramAnonymousContextMenuInfo.hTm);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymouss.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                    }
                    paramAnonymouss.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                    paramAnonymouss.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                    paramAnonymouss.a(0, 4, paramString.getResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
                    paramAnonymouss = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(ab.b.c(ab.b.this).toString());
                    if (!Util.isNullOrNil(paramAnonymouss)) {
                      ab.b.this.a(locala.GAa, parama1, paramAnonymouss);
                    }
                    if (Util.isNullOrNil(paramAnonymouss)) {
                      locala.GAa.agjF = null;
                    }
                    paramAnonymousView = "65_" + cn.bDw();
                    paramAnonymousContextMenuInfo = ab.b.this;
                    com.tencent.mm.ui.chatting.d.a locala = parama1;
                    cc localcc = paramcc;
                    if (!Util.isNullOrNil(paramAnonymouss)) {
                      bool = true;
                    }
                    paramAnonymousContextMenuInfo.a(locala, localcc, 1, bool, ab.b.c(ab.b.this).toString(), true, paramAnonymousView, 3);
                    AppMethodBeat.o(255323);
                    return;
                  }
                }
              };
              locala.GAa.GAC = new u.i()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(255331);
                  ab.b.a(ab.b.this, paramAnonymousInt);
                  ab.b.b(ab.b.this, paramAnonymousMenuItem.getItemId());
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
                          do
                          {
                            AppMethodBeat.o(255331);
                            return;
                            ClipboardHelper.setText(MMApplicationContext.getContext(), ab.b.c(ab.b.this), ab.b.c(ab.b.this));
                            if (locala.aeQt != null)
                            {
                              locala.aeQt.cRQ();
                              locala.aeQt.agoW = true;
                              locala.aeQt.agoX = true;
                              locala.aeQt.cRT();
                            }
                            Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                            AppMethodBeat.o(255331);
                            return;
                          } while (locala.aeQt == null);
                          if (locala.aeQt.agoQ != null) {
                            locala.aeQt.agoQ.jxm();
                          }
                          locala.aeQt.agoW = true;
                          locala.aeQt.cRT();
                          locala.aeQt.gc(0, locala.aeQs.jPy().length());
                          locala.aeQt.jJo();
                          locala.aeQt.jJr();
                        } while (locala.aeQt.agoQ == null);
                        locala.aeQt.agoQ.jxn();
                        AppMethodBeat.o(255331);
                        return;
                        paramAnonymousMenuItem = (bz)locala.aeQs.getTag();
                      } while (paramAnonymousMenuItem == null);
                      paramAnonymousMenuItem = bt.X(paramAnonymousMenuItem.hTm);
                      if (Util.isNullOrNil(paramAnonymousMenuItem))
                      {
                        localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                        ((Intent)localObject1).putExtra("Retr_Msg_content", ab.b.c(ab.b.this));
                        ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                        paramAnonymousMenuItem = paramString;
                        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$6", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$6", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(255331);
                        return;
                      }
                      com.tencent.mm.ui.base.k.a(paramString, R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new ab.b.6.1(this, paramAnonymousMenuItem), new ab.b.6.2(this));
                      AppMethodBeat.o(255331);
                      return;
                      paramAnonymousMenuItem = new dn();
                      l.b(paramAnonymousMenuItem, ab.b.c(ab.b.this).toString(), 1);
                      paramAnonymousMenuItem.hDr.fragment = ab.b.d(ab.b.this).aezO;
                      paramAnonymousMenuItem.hDr.hDy = 43;
                      if (paramAnonymousMenuItem.hDr.hDt != null)
                      {
                        localObject1 = paramAnonymousMenuItem.hDr.hDt.ZBt;
                        if (localObject1 != null)
                        {
                          localObject2 = (bz)locala.aeQs.getTag();
                          if (localObject2 != null)
                          {
                            ((asb)localObject1).bto(((bz)localObject2).hTm.field_talker);
                            ((asb)localObject1).btp(z.bAM());
                            paramAnonymousMenuItem.publish();
                          }
                        }
                      }
                    } while (locala.aeQt == null);
                    locala.aeQt.cRQ();
                    locala.aeQt.agoW = true;
                    locala.aeQt.agoX = true;
                    locala.aeQt.cRT();
                    AppMethodBeat.o(255331);
                    return;
                  }
                  paramAnonymousMenuItem = "65_" + cn.bDw();
                  Object localObject1 = ab.b.c(ab.b.this).toString();
                  Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
                  ab.b localb = ab.b.this;
                  com.tencent.mm.ui.chatting.d.a locala = parama1;
                  cc localcc = paramcc;
                  if (!Util.isNullOrNil((String)localObject2)) {}
                  for (boolean bool = true;; bool = false)
                  {
                    localb.a(locala, localcc, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                    localObject2 = new ah();
                    ((ah)localObject2).context = paramString;
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
            if ((bt.F(paramcc)) || (bt.Q(paramcc))) {
              break label2086;
            }
            j = bt.Y(paramcc);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.mu(locala.aeQs).length())) {
              break label2194;
            }
            j = 0;
          }
        }
      }
      label1291:
      label2194:
      for (;;)
      {
        paramString = c(parama1);
        localObject1 = a(paramString);
        if (locala.aeQt != null) {
          locala.aeQt.destroy();
        }
        localObject2 = new int[2];
        i = 0;
        if (locala.aeQs != null)
        {
          locala.aeQs.getLocationInWindow((int[])localObject2);
          int k = localObject2[0];
          i = k;
          if (k == 0)
          {
            localObject2 = new Rect();
            locala.aeQs.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new a.a(locala.aeQs, locala.GAa, (a.f)localObject1, jxu(), locala.aeQu);
          ((a.a)localObject1).aggi = R.e.selected_blue;
          ((a.a)localObject1).agpg = 18;
          ((a.a)localObject1).aggj = R.e.cursor_handle_color;
          if (i != 0) {
            ((a.a)localObject1).agph = (bd.bs(locala.aeQs.getContext(), R.f.Edge_2A) + i);
          }
          locala.aeQt = ((a.a)localObject1).jJu();
          locala.aeQv = new ab.d(locala.aeQt);
          locala.aeQt.agoO = new ab.b.7(this);
          locala.aeMh = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(255299);
              locala.aeQt.cRQ();
              locala.aeQt.agoW = true;
              locala.aeQt.agoX = true;
              locala.aeQt.cRT();
              AppMethodBeat.o(255299);
            }
          };
          paramString.aeMh = locala.aeMh;
          locala.aeQt.agoU = j;
          locala.aeQt.agpc = locala.aeQv;
          locala.aeQs.setOnDoubleClickListener(this);
          locala.aeQs.setTag(parama);
          locala.aeQs.setTextListener(new MMNeat7extView.a()
          {
            public final void aW(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(255282);
              if (((Boolean)locala.aeQs.getTag(ab.b.bPa())).booleanValue())
              {
                com.tencent.mm.ui.chatting.j.a.a.jwS();
                com.tencent.mm.ui.chatting.j.a.a.jwT().a(paramAnonymousCharSequence, ((Long)locala.aeQs.getTag(ab.b.aeQz)).longValue());
              }
              AppMethodBeat.o(255282);
            }
          });
          locala.aeQs.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.c.aeWe;
          if (com.tencent.mm.app.plugin.d.aDO()) {
            if ((paramcc.jbT()) && (paramcc.jca()))
            {
              parama = paramcc.field_transContent;
              label1371:
              paramString = ((bc)parama1.cm(bc.class)).cZ(paramcc);
            }
          }
          for (;;)
          {
            label1572:
            label2086:
            if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.aeWe))
            {
              if ((locala.aeQx == null) && (locala.aeQw != null))
              {
                locala.aeQx = ((ChattingItemTranslate)locala.aeQw.inflate());
                locala.aeQx.init();
              }
              localObject2 = locala.aeQs.getContext();
              i = (int)locala.aeQs.getTextSize();
              if (paramcc != null)
              {
                localObject1 = ad.Jo(paramcc.field_msgSvrId);
                ad.b localb = ad.bCb().M((String)localObject1, true);
                localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
                localb.q("preUsername", a(this.aeiK, paramcc));
                localb.q("preChatName", b(this.aeiK, paramcc));
                localObject1 = p.a((Context)localObject2, parama, i, null, (String)localObject1);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.aeQx.a((CharSequence)localObject1, paramString);
                localObject1 = locala.aeQx;
                if (!Util.isNullOrNil(paramcc.field_transBrandWording)) {
                  break label2147;
                }
              }
              label1886:
              label2147:
              for (paramString = parama1.aezO.getMMResources().getString(R.l.gXo);; paramString = paramcc.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
                  parama.aeXR = false;
                  parama.viewType = 2;
                  locala.aeQx.setTag(parama);
                  locala.aeQx.setOnClickListener(jxu());
                  locala.aeQx.setOnDoubleClickListener(this);
                  locala.aeQx.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
                  locala.aeQx.setOnLongClickListener(c(parama1));
                  locala.aeQx.setVisibility(0);
                }
                AppMethodBeat.o(37014);
                return;
                locala.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.normal_text));
                locala.aeQT.setBackgroundResource(R.g.foA);
                break;
                if (bool)
                {
                  locala.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.BW_0_Alpha_0_2));
                  locala.aeQT.setBackgroundResource(R.g.foz);
                  break;
                }
                locala.Aoo.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.desc_text));
                locala.aeQT.setBackgroundResource(R.g.foy);
                break;
                locala.Yfu.setVisibility(8);
                break label616;
                label1899:
                i = (int)(bd.fromDPToPix(parama1.aezO.getContext(), 259) / com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
                locala.Aoo.setMaxWidth(i);
                localObject1 = (RelativeLayout.LayoutParams)locala.Aoo.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject1).rightMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_A);
                ((RelativeLayout.LayoutParams)localObject1).topMargin = bd.bs(parama1.aezO.getContext(), R.f.Edge_0_25A);
                ((RelativeLayout.LayoutParams)localObject1).removeRule(10);
                ((RelativeLayout.LayoutParams)localObject1).addRule(15);
                locala.Aoo.setGravity(19);
                locala.Aoo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                locala.Yfv.setVisibility(8);
                locala.Yft.setVisibility(8);
                locala.Yfu.setVisibility(8);
                break label662;
                if (Util.isNullOrNil((CharSequence)paramString.second)) {
                  locala.Aoo.setVisibility(8);
                }
                locala.clickArea.setVisibility(8);
                break label753;
                locala.aeQs.setTag(aeQy, Boolean.FALSE);
                locala.aeQs.setOnTouchListener(locala.aeQu);
                locala.aeQs.setOnLongClickListener(c(parama1));
                locala.aeQs.setOnClickListener(jxu());
                break label1291;
                localObject1 = null;
                break label1572;
              }
            }
            if (locala.aeQx != null) {
              locala.aeQx.setVisibility(8);
            }
            AppMethodBeat.o(37014);
            return;
            parama = null;
            break label1371;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37016);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37016);
      return false;
    case 102: 
      paramMenuItem = com.tencent.mm.message.k.b.Hf(br.a(parama.juF(), paramcc.field_content, paramcc.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((bc)parama.cm(bc.class)).b(paramMenuItem, paramcc);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = paramcc.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(37016);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
          AppMethodBeat.o(37016);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255306);
    paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
    int i = paramContextMenuInfo.position;
    if (paramContextMenuInfo.viewType == 1)
    {
      if (!bt.Q(paramcc))
      {
        params.a(i, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType())) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((com.tencent.mm.app.plugin.d.aDO()) && ((!paramcc.jbT()) || (!paramcc.jca()))) {
        params.a(i, 124, paramView.getContext().getString(R.l.gyI), R.k.icons_filled_translate);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      if (bt.F(paramcc))
      {
        params.clear();
        if (!this.aeiK.juH()) {
          params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
        }
      }
    }
    while (paramContextMenuInfo.viewType != 2)
    {
      AppMethodBeat.o(255306);
      return true;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
    params.a(i, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
    params.a(i, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(i, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (com.tencent.mm.app.plugin.d.aDO())
    {
      if ((paramcc.jbT()) && (paramcc.jca())) {
        params.a(i, 124, paramView.getContext().getString(R.l.gyG), R.k.icons_filled_eyes_off);
      }
      if (paramcc.jcd()) {
        params.a(i, 125, paramView.getContext().getString(R.l.gyz), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(255306);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(37017);
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bz)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).jPy();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bz)localObject2).hTm.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      if (this.aeiK != null) {
        ((Intent)localObject1).putExtra("is_group_chat", this.aeiK.juG());
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ne(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b
 * JD-Core Version:    0.7.0.1
 */