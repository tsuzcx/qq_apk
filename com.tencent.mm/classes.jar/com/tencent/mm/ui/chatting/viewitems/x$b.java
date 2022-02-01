package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.app.plugin.d;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
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
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class x$b
  extends c
  implements NeatTextView.b
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQy = R.h.fYD;
  private static final int aeQz = R.h.fza;
  private int aeMA = -1;
  private x.e aeQB;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private x.e jxs()
  {
    AppMethodBeat.i(36944);
    if (this.aeQB == null) {
      this.aeQB = new x.e(this.aeiK);
    }
    x.e locale = this.aeQB;
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
      localObject = new ap(paramLayoutInflater, R.i.gfN);
      ((View)localObject).setTag(new x.a().lz((View)localObject));
    }
    AppMethodBeat.o(36945);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, final String paramString)
  {
    AppMethodBeat.i(36946);
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    final x.a locala = (x.a)parama;
    locala.aeQs.setTag(aeQz, Long.valueOf(paramcc.field_msgId));
    locala.aeQs.setTag(aeQA, Boolean.TRUE);
    Object localObject1 = paramcc.field_content;
    parama = (c.a)localObject1;
    int i;
    if (parama1.juG())
    {
      i = paramcc.field_content.indexOf(':');
      parama = (c.a)localObject1;
      if (i != -1) {
        parama = paramcc.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    label289:
    label1452:
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      Object localObject2;
      int j;
      if ((parama != null) && (parama.type == 53))
      {
        localObject2 = h.s(parama.appId, true, false);
        if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0))
        {
          localObject1 = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.iA((String)localObject1))) {
            break label1452;
          }
          locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gzI, new Object[] { h.a(parama1.aezO.getContext(), (g)localObject2, (String)localObject1) }));
          locala.Aoo.setVisibility(0);
          a(parama1, locala.Aoo, parama.appId);
          a(parama1, locala.Aoo, parama.appId);
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc))
          {
            locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gJj));
            locala.Aoo.setVisibility(0);
            locala.Aoo.setOnClickListener(new x.b.1(this, paramcc, parama1));
          }
          if ((parama.kLg == null) || (parama.kLg.length() <= 0)) {
            break label1465;
          }
          b(parama1, locala.aeNs, bz.bBE(parama.kLg));
          locala.aeNs.setVisibility(0);
          localObject1 = com.tencent.mm.ui.chatting.i.a.aeJh;
          com.tencent.mm.ui.chatting.i.a.a.a(locala.aeQs, paramcc, parama1.juG(), paramString);
          paramString = bj.dG(paramcc);
          com.tencent.mm.pluginsdk.ui.span.x.b.YpJ.d(paramString, com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
          paramString = p.a(locala.aeQs.getContext(), parama.title, (int)locala.aeQs.getTextSize(), 1, paramString, p.YoF);
          x.a(locala.aeQs.getContext(), parama1, parama.title, paramString, locala.aeQs, paramcc, 1);
          locala.aeQs.setClickable(true);
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
                AppMethodBeat.i(179995);
                parama1.aE(true);
                c.a(locala.GAa, parama1, x.b.a(x.b.this), x.b.b(x.b.this), 49);
                x.b.a(x.b.this, -1);
                x.b.b(x.b.this, -1);
                AppMethodBeat.o(179995);
              }
            };
            locala.GAa.agjw = true;
            locala.GAa.agju = new u.f()
            {
              public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
              {
                AppMethodBeat.i(255227);
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
                  AppMethodBeat.o(255227);
                  return;
                }
              }
            };
            locala.GAa.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(179999);
                x.b.a(x.b.this, paramAnonymousInt);
                x.b.b(x.b.this, paramAnonymousMenuItem.getItemId());
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(179999);
                  return;
                  ClipboardHelper.setText(MMApplicationContext.getContext(), x.b.c(x.b.this), x.b.c(x.b.this));
                  if (locala.aeQt != null)
                  {
                    locala.aeQt.cRQ();
                    locala.aeQt.agoW = true;
                    locala.aeQt.agoX = true;
                    locala.aeQt.cRT();
                  }
                  Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                  AppMethodBeat.o(179999);
                  return;
                  if (locala.aeQt != null)
                  {
                    if (locala.aeQt.agoQ != null) {
                      locala.aeQt.agoQ.jxm();
                    }
                    locala.aeQt.agoW = true;
                    locala.aeQt.cRT();
                    locala.aeQt.gc(0, locala.aeQs.jPy().length());
                    locala.aeQt.jJo();
                    locala.aeQt.jJr();
                    if (locala.aeQt.agoQ != null)
                    {
                      locala.aeQt.agoQ.jxn();
                      AppMethodBeat.o(179999);
                      return;
                      paramAnonymousMenuItem = (bz)locala.aeQs.getTag();
                      if (paramAnonymousMenuItem != null)
                      {
                        paramAnonymousMenuItem = bt.X(paramAnonymousMenuItem.hTm);
                        Object localObject;
                        if (Util.isNullOrNil(paramAnonymousMenuItem))
                        {
                          localObject = new Intent(paramString, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", x.b.c(x.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymousMenuItem = paramString;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(179999);
                          return;
                        }
                        k.a(paramString, R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new x.b.4.1(this, paramAnonymousMenuItem), new x.b.4.2(this));
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = new dn();
                        l.b(paramAnonymousMenuItem, x.b.c(x.b.this).toString(), 1);
                        paramAnonymousMenuItem.hDr.fragment = x.b.d(x.b.this).aezO;
                        paramAnonymousMenuItem.hDr.hDy = 43;
                        if (paramAnonymousMenuItem.hDr.hDt != null)
                        {
                          localObject = paramAnonymousMenuItem.hDr.hDt.ZBt;
                          if (localObject != null)
                          {
                            bz localbz = (bz)locala.aeQs.getTag();
                            if (localbz != null)
                            {
                              ((asb)localObject).bto(localbz.hTm.field_talker);
                              ((asb)localObject).btp(z.bAM());
                              paramAnonymousMenuItem.publish();
                            }
                          }
                        }
                        if (locala.aeQt != null)
                        {
                          locala.aeQt.cRQ();
                          locala.aeQt.agoW = true;
                          locala.aeQt.agoX = true;
                          locala.aeQt.cRT();
                        }
                      }
                    }
                  }
                }
              }
            };
          }
          if (bt.F(paramcc)) {
            break label1478;
          }
          j = bt.Y(paramcc);
          if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.mu(locala.aeQs).length())) {
            break label1586;
          }
          j = 0;
        }
      }
      label945:
      label1586:
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
          localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.aeQs, locala.GAa, (a.f)localObject1, jxs(), locala.aeQu);
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggi = R.e.selected_blue;
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agpg = 18;
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggj = R.e.cursor_handle_color;
          if (i != 0) {
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agph = (bd.bs(locala.aeQs.getContext(), R.f.Edge_2A) + i);
          }
          locala.aeQt = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).jJu();
          locala.aeQv = new x.d(locala.aeQt);
          locala.aeQt.agoO = new com.tencent.mm.ui.base.ad()
          {
            public final void aV(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180000);
              x.b.a(x.b.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180000);
            }
          };
          locala.aeMh = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180001);
              locala.aeQt.cRQ();
              locala.aeQt.agoW = true;
              locala.aeQt.agoX = true;
              locala.aeQt.cRT();
              AppMethodBeat.o(180001);
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
              AppMethodBeat.i(180002);
              if (((Boolean)locala.aeQs.getTag(x.b.aeQA)).booleanValue())
              {
                com.tencent.mm.ui.chatting.j.a.a.jwS();
                com.tencent.mm.ui.chatting.j.a.a.jwT().a(paramAnonymousCharSequence, ((Long)locala.aeQs.getTag(x.b.aeQz)).longValue());
              }
              AppMethodBeat.o(180002);
            }
          });
          locala.aeQs.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.c.aeWe;
          if (d.aDO()) {
            if ((paramcc.jbT()) && (paramcc.jca()))
            {
              parama = paramcc.field_transContent;
              paramString = ((bc)parama1.cm(bc.class)).cZ(paramcc);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.aeWe))
            {
              if ((locala.aeQx == null) && (locala.aeQw != null))
              {
                locala.aeQx = ((ChattingItemTranslate)locala.aeQw.inflate());
                locala.aeQx.init();
              }
              localObject2 = com.tencent.mm.pluginsdk.ui.span.x.b.YpJ.awY(com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
              Context localContext = locala.aeQs.getContext();
              i = (int)locala.aeQs.getTextSize();
              if (paramcc != null)
              {
                localObject1 = com.tencent.mm.model.ad.Jo(paramcc.field_msgSvrId);
                ad.b localb = com.tencent.mm.model.ad.bCb().M((String)localObject1, true);
                localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
                localb.q("preUsername", a(this.aeiK, paramcc));
                localb.q("preChatName", b(this.aeiK, paramcc));
                label1242:
                localObject1 = p.a(localContext, parama, i, localObject2, (String)localObject1, p.YoF);
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.aeQx.a((CharSequence)localObject1, paramString);
                localObject1 = locala.aeQx;
                if (!Util.isNullOrNil(paramcc.field_transBrandWording)) {
                  break label1539;
                }
              }
              for (paramString = parama1.aezO.getMMResources().getString(R.l.gXo);; paramString = paramcc.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
                  parama.aeXR = false;
                  parama.viewType = 2;
                  locala.aeQx.setTag(parama);
                  locala.aeQx.setOnClickListener(jxs());
                  locala.aeQx.setOnDoubleClickListener(this);
                  locala.aeQx.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
                  locala.aeQx.setOnLongClickListener(c(parama1));
                  locala.aeQx.setVisibility(0);
                }
                AppMethodBeat.o(36946);
                return;
                localObject1 = ((g)localObject2).field_appName;
                break;
                locala.Aoo.setVisibility(8);
                break label289;
                label1465:
                locala.aeNs.setVisibility(8);
                break label389;
                label1478:
                locala.aeQs.setTag(aeQy, Boolean.FALSE);
                locala.aeQs.setOnTouchListener(locala.aeQu);
                locala.aeQs.setOnLongClickListener(c(parama1));
                locala.aeQs.setOnClickListener(jxs());
                break label945;
                localObject1 = null;
                break label1242;
              }
            }
            if (locala.aeQx != null) {
              locala.aeQx.setVisibility(8);
            }
            AppMethodBeat.o(36946);
            return;
            parama = null;
            break label1025;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
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
      u.a(parama, paramcc.field_msgId, 2);
      AppMethodBeat.o(36948);
      return false;
    case 102: 
      paramMenuItem = k.b.Hf(br.a(parama.juF(), paramcc.field_content, paramcc.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(36948);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36948);
      return false;
    case 124: 
    case 125: 
      ((bc)parama.cm(bc.class)).b(paramMenuItem, paramcc);
      AppMethodBeat.o(36948);
      return false;
    case 141: 
      paramMenuItem = paramcc.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(36948);
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
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
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
          AppMethodBeat.o(36948);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255172);
    if (paramcc.jUr != null) {
      paramcc.jUr.contains("announcement@all");
    }
    paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
    int i = paramContextMenuInfo.position;
    if (paramContextMenuInfo.viewType == 1)
    {
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
        params.a(i, 151, this.aeiK.aezO.getMMResources().getString(R.l.gJi), R.k.icons_filled_continued_form);
      }
      if (!bt.Q(paramcc))
      {
        params.a(i, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (h.bj(this.aeiK.aezO.getContext(), paramcc.getType())) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((d.aDO()) && ((!paramcc.jbT()) || (!paramcc.jca()))) {
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
      AppMethodBeat.o(255172);
      return true;
    }
    Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
    params.a(i, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
    params.a(i, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(i, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (d.aDO())
    {
      if ((paramcc.jbT()) && (paramcc.jca())) {
        params.a(i, 124, paramView.getContext().getString(R.l.gyG), R.k.icons_filled_eyes_off);
      }
      if (paramcc.jcd()) {
        params.a(i, 125, paramView.getContext().getString(R.l.gyz), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(255172);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(36949);
    if (x.ly(paramView))
    {
      Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36949);
      return true;
    }
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
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ne(paramView.getContext());
    }
    AppMethodBeat.o(36949);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */