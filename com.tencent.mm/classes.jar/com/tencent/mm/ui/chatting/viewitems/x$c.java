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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
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
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class x$c
  extends c
  implements v.n, NeatTextView.b
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQy = R.h.fYD;
  private static final int aeQz = R.h.fza;
  private int aeMA = -1;
  private x.e aeQB;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private void cs(cc paramcc)
  {
    AppMethodBeat.i(255127);
    if (paramcc.jbR())
    {
      Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(paramcc.field_talker, paramcc.kLs, true);
      if ((localObject != null) && (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, paramcc.field_msgId)))
      {
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
        ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
      }
      localObject = n.bx(paramcc);
      if (localObject != null) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().aJ(paramcc.field_msgId, ((Long)((Pair)localObject).second).longValue());
      }
      br.iu(paramcc.field_msgId);
      this.aeiK.jpK();
    }
    AppMethodBeat.o(255127);
  }
  
  private x.e jxs()
  {
    AppMethodBeat.i(36956);
    if (this.aeQB == null) {
      this.aeQB = new x.e(this.aeiK);
    }
    x.e locale = this.aeQB;
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
      localObject = new ap(paramLayoutInflater, R.i.ggN);
      ((View)localObject).setTag(new x.a().lz((View)localObject));
    }
    AppMethodBeat.o(36957);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, final String paramString)
  {
    AppMethodBeat.i(36958);
    final x.a locala = (x.a)parama;
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    locala.aeQs.setTag(aeQz, Long.valueOf(paramcc.field_msgId));
    locala.aeQs.setTag(aeQA, Boolean.TRUE);
    parama = paramcc.field_content;
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      Object localObject1 = com.tencent.mm.ui.chatting.i.a.aeJh;
      com.tencent.mm.ui.chatting.i.a.a.a(locala.aeQs, paramcc, parama1.juG(), paramString);
      paramString = bj.dG(paramcc);
      x.b.YpJ.d(paramString, com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
      if ((parama != null) && (parama.type == 53))
      {
        paramString = p.a(locala.aeQs.getContext(), parama.title, (int)locala.aeQs.getTextSize(), 4, paramString, p.YoF);
        x.a(locala.aeQs.getContext(), parama1, parama.title, paramString, locala.aeQs, paramcc, 4);
        locala.aeQs.setClickable(true);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.s(parama.appId, true, false);
        if ((localObject1 != null) && (((g)localObject1).field_appName != null) && (((g)localObject1).field_appName.trim().length() > 0)) {
          break label1336;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
          break label1346;
        }
        locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gzI, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.aezO.getContext(), (g)localObject1, paramString) }));
        locala.Aoo.setVisibility(0);
        a(parama1, locala.Aoo, parama.appId);
        a(parama1, locala.Aoo, parama.appId);
        label355:
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc))
        {
          locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gJj));
          locala.Aoo.setVisibility(0);
          locala.Aoo.setOnClickListener(new x.c.1(this, paramcc, parama1));
        }
        if (!jxj()) {
          break label1359;
        }
      }
      label900:
      label1427:
      for (;;)
      {
        boolean bool = false;
        parama = locala;
        label424:
        b(parama, bool);
        parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
        parama.aeXR = false;
        paramString = locala.aeQs.getContext();
        locala.aeQs.setTag(aeQy, Boolean.TRUE);
        if (locala.GAa == null)
        {
          locala.GAa = new com.tencent.mm.ui.widget.b.a(paramString, locala.aeQs);
          locala.GAa.afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180003);
              parama1.aE(true);
              c.a(locala.GAa, parama1, x.c.a(x.c.this), x.c.b(x.c.this), 49);
              x.c.a(x.c.this, -1);
              x.c.b(x.c.this, -1);
              AppMethodBeat.o(180003);
            }
          };
          locala.GAa.agjw = true;
          locala.GAa.agju = new u.f()
          {
            public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(255697);
              paramAnonymouss.clear();
              paramAnonymouss.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
              paramAnonymouss.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
              paramAnonymouss.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
              paramAnonymouss.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
              AppMethodBeat.o(255697);
            }
          };
          locala.GAa.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180005);
              x.c.b(x.c.this, paramAnonymousMenuItem.getItemId());
              x.c.a(x.c.this, paramAnonymousInt);
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180005);
                return;
                ClipboardHelper.setText(MMApplicationContext.getContext(), x.c.c(x.c.this), x.c.c(x.c.this));
                if (locala.aeQt != null)
                {
                  locala.aeQt.cRQ();
                  locala.aeQt.agoW = true;
                  locala.aeQt.agoX = true;
                  locala.aeQt.cRT();
                }
                Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                AppMethodBeat.o(180005);
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
                    AppMethodBeat.o(180005);
                    return;
                    Object localObject = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject).putExtra("Retr_Msg_content", x.c.c(x.c.this));
                    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180005);
                    return;
                    paramAnonymousMenuItem = new dn();
                    l.b(paramAnonymousMenuItem, x.c.c(x.c.this).toString(), 1);
                    paramAnonymousMenuItem.hDr.fragment = x.c.d(x.c.this).aezO;
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
          };
        }
        paramString = c(parama1);
        localObject1 = a(c(parama1));
        if (locala.aeQt != null) {
          locala.aeQt.destroy();
        }
        Object localObject2 = new int[2];
        int i = 0;
        if (locala.aeQs != null)
        {
          locala.aeQs.getLocationInWindow((int[])localObject2);
          int j = localObject2[0];
          i = j;
          if (j == 0)
          {
            localObject2 = new Rect();
            locala.aeQs.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.aeQs, locala.GAa, (a.f)localObject1, jxs(), locala.aeQu);
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggi = R.e.chat_to_selected;
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agpg = 18;
          ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggj = R.e.chat_to_cursor_handle_color;
          if (i != 0) {
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agph = (bd.bs(locala.aeQs.getContext(), R.f.Edge_1_5_A) + i);
          }
          locala.aeQt = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).jJu();
          locala.aeQv = new x.d(locala.aeQt);
          locala.aeQt.agoO = new com.tencent.mm.ui.base.ad()
          {
            public final void aV(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180006);
              x.c.a(x.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180006);
            }
          };
          locala.aeMh = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180007);
              locala.aeQt.cRQ();
              locala.aeQt.agoW = true;
              locala.aeQt.agoX = true;
              locala.aeQt.cRT();
              AppMethodBeat.o(180007);
            }
          };
          paramString.aeMh = locala.aeMh;
          locala.aeQt.agpc = locala.aeQv;
          locala.aeQs.setOnDoubleClickListener(this);
          locala.aeQs.setTag(parama);
          locala.aeQs.setTextListener(new MMNeat7extView.a()
          {
            public final void aW(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180008);
              if (((Boolean)locala.aeQs.getTag(x.c.alu())).booleanValue())
              {
                com.tencent.mm.ui.chatting.j.a.a.jwS();
                com.tencent.mm.ui.chatting.j.a.a.jwT().a(paramAnonymousCharSequence, ((Long)locala.aeQs.getTag(x.c.cjJ())).longValue());
              }
              AppMethodBeat.o(180008);
            }
          });
          paramString = ChattingItemTranslate.c.aeWe;
          if (com.tencent.mm.app.plugin.d.aDO()) {
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
              localObject2 = x.b.YpJ.awY(com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
              Context localContext = locala.aeQs.getContext();
              i = (int)locala.aeQs.getTextSize();
              if (paramcc != null)
              {
                localObject1 = com.tencent.mm.model.ad.Jo(paramcc.field_msgSvrId);
                ad.b localb = com.tencent.mm.model.ad.bCb().M((String)localObject1, true);
                localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
                localb.q("preUsername", a(this.aeiK, paramcc));
                localb.q("preChatName", b(this.aeiK, paramcc));
                label1117:
                localObject1 = p.a(localContext, parama, i, localObject2, (String)localObject1, p.YoF);
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject1 });
                locala.aeQx.a((CharSequence)localObject1, paramString);
                localObject1 = locala.aeQx;
                if (!Util.isNullOrNil(paramcc.field_transBrandWording)) {
                  break label1383;
                }
                paramString = parama1.aezO.getMMResources().getString(R.l.gXo);
                label1197:
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
              }
            }
            for (;;)
            {
              a(paramInt, locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
              AppMethodBeat.o(36958);
              return;
              label1336:
              paramString = ((g)localObject1).field_appName;
              break;
              label1346:
              locala.Aoo.setVisibility(8);
              break label355;
              label1359:
              if (paramcc.field_status >= 2) {
                break label1427;
              }
              bool = true;
              parama = locala;
              break label424;
              localObject1 = null;
              break label1117;
              label1383:
              paramString = paramcc.field_transBrandWording;
              break label1197;
              if (locala.aeQx != null) {
                locala.aeQx.setVisibility(8);
              }
            }
            parama = null;
            break label900;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
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
      u.a(parama, paramcc.field_msgId, 2);
      AppMethodBeat.o(36960);
      return false;
    case 102: 
      paramMenuItem = k.b.Hf(br.a(parama.juF(), paramcc.field_content, paramcc.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(36960);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36960);
      return false;
    case 103: 
      cs(paramcc);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(36960);
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
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = paramcc.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(36960);
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
          AppMethodBeat.o(36960);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255164);
    int i;
    int j;
    if ((paramcc.jUr != null) && (paramcc.jUr.contains("announcement@all")))
    {
      i = 1;
      paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
      j = paramContextMenuInfo.position;
      if (paramContextMenuInfo.viewType != 1) {
        break label460;
      }
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
        params.a(j, 151, this.aeiK.aezO.getMMResources().getString(R.l.gJi), R.k.icons_filled_continued_form);
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
    label460:
    while (paramContextMenuInfo.viewType != 2)
    {
      AppMethodBeat.o(255164);
      return true;
      i = 0;
      break;
    }
    Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
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
    AppMethodBeat.o(255164);
    return false;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255178);
    cs(paramcc);
    AppMethodBeat.o(255178);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(36962);
    if (x.ly(paramView))
    {
      Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36962);
      return true;
    }
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
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ne(paramView.getContext());
    AppMethodBeat.o(36962);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.c
 * JD-Core Version:    0.7.0.1
 */