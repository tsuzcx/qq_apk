package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewStub;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class q$b
  extends c
  implements NeatTextView.b
{
  private static final int GLH = 2131305626;
  private static final int GLI = 2131298134;
  private static final int GLJ = 2131298133;
  private q.e GLK;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private CharSequence GqU;
  
  private q.e faN()
  {
    AppMethodBeat.i(36944);
    if (this.GLK == null) {
      this.GLK = new q.e(this.Gob);
    }
    q.e locale = this.GLK;
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
      localObject = new af(paramLayoutInflater, 2131493440);
      ((View)localObject).setTag(new q.a().fS((View)localObject));
    }
    AppMethodBeat.o(36945);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, final String paramString)
  {
    AppMethodBeat.i(36946);
    this.Gob = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class)).bC(parambl);
    final q.a locala = (q.a)parama;
    locala.GLB.setTag(GLI, Long.valueOf(parambl.field_msgId));
    locala.GLB.setTag(GLJ, Boolean.TRUE);
    paramString = parambl.field_content;
    parama = paramString;
    int i;
    if (parama1.eZb())
    {
      i = parambl.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambl.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      Object localObject;
      if ((parama != null) && (parama.type == 53))
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.j(parama.appId, true, false);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eM(paramString))) {
            break label1285;
          }
          locala.qkL.setText(parama1.GzJ.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.GzJ.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString) }));
          locala.qkL.setVisibility(0);
          a(parama1, locala.qkL, parama.appId);
          a(parama1, locala.qkL, parama.appId);
          label288:
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl))
          {
            locala.qkL.setText(parama1.GzJ.getMMResources().getString(2131760106));
            locala.qkL.setVisibility(0);
            locala.qkL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36936);
                ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambl.field_msgId) });
                r.a(parama1, parambl.field_msgId, 1);
                AppMethodBeat.o(36936);
              }
            });
          }
          if ((parama.eOT == null) || (parama.eOT.length() <= 0)) {
            break label1298;
          }
          b(parama1, locala.GIU, bi.aLk(parama.eOT));
          locala.GIU.setVisibility(0);
          label387:
          paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.GLB.getContext(), parama.title, (int)locala.GLB.getTextSize(), 1);
          q.a(locala.GLB.getContext(), parama1, parama.title, paramString, locala.GLB, parambl, 1);
          locala.GLB.setClickable(true);
          parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
          paramString = locala.GLB.getContext();
          locala.GLB.setTag(GLH, Boolean.TRUE);
          if (locala.GqT == null)
          {
            locala.GqT = new com.tencent.mm.ui.widget.b.a(paramString, locala.GLB);
            locala.GqT.Hua = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(179995);
                parama1.setFocused(true);
                AppMethodBeat.o(179995);
              }
            };
            locala.GqT.HIv = true;
            locala.GqT.HIu = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
              {
                AppMethodBeat.i(179996);
                paramAnonymousContextMenu.clear();
                paramAnonymousContextMenu.add(0, 0, 0, paramString.getResources().getString(2131755701));
                paramAnonymousView = locala.GLB.fli();
                paramAnonymousContextMenuInfo = (bi)locala.GLB.getTag();
                if (paramAnonymousContextMenuInfo != null) {}
                for (int i = bk.D(paramAnonymousContextMenuInfo.drF);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymousContextMenu.add(0, 1, 0, paramString.getResources().getString(2131761224));
                  }
                  paramAnonymousContextMenu.add(0, 2, 0, paramString.getResources().getString(2131761223));
                  paramAnonymousContextMenu.add(0, 3, 0, paramString.getResources().getString(2131758845));
                  AppMethodBeat.o(179996);
                  return;
                }
              }
            };
            locala.GqT.HrY = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(179999);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(179999);
                  return;
                  ((android.content.ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(q.b.a(q.b.this), q.b.a(q.b.this)));
                  if (locala.GLC != null)
                  {
                    locala.GLC.fgF();
                    locala.GLC.HNX = true;
                    locala.GLC.HNY = true;
                    locala.GLC.fgE();
                  }
                  Toast.makeText(paramString, 2131755702, 0).show();
                  AppMethodBeat.o(179999);
                  return;
                  if (locala.GLC != null)
                  {
                    if (locala.GLC.HNI != null) {
                      locala.GLC.HNI.faI();
                    }
                    locala.GLC.HNX = true;
                    locala.GLC.fgE();
                    locala.GLC.jQ(0, locala.GLB.fli().length());
                    locala.GLC.fgH();
                    locala.GLC.fgK();
                    if (locala.GLC.HNI != null)
                    {
                      locala.GLC.HNI.faJ();
                      AppMethodBeat.o(179999);
                      return;
                      paramAnonymousMenuItem = (bi)locala.GLB.getTag();
                      if (paramAnonymousMenuItem != null)
                      {
                        paramAnonymousMenuItem = bk.C(paramAnonymousMenuItem.drF);
                        Object localObject;
                        if (bt.isNullOrNil(paramAnonymousMenuItem))
                        {
                          localObject = new Intent(paramString, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", q.b.a(q.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymousMenuItem = paramString;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(179999);
                          return;
                        }
                        com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new q.b.4.1(this, paramAnonymousMenuItem), new q.b.4.2(this));
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = new cs();
                        com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, q.b.a(q.b.this).toString(), 1);
                        paramAnonymousMenuItem.deQ.fragment = q.b.b(q.b.this).GzJ;
                        paramAnonymousMenuItem.deQ.deW = 43;
                        if (paramAnonymousMenuItem.deQ.deS != null)
                        {
                          localObject = paramAnonymousMenuItem.deQ.deS.DiD;
                          if (localObject != null)
                          {
                            bi localbi = (bi)locala.GLB.getTag();
                            if (localbi != null)
                            {
                              ((agu)localObject).aEl(localbi.drF.field_talker);
                              ((agu)localObject).aEm(u.aqG());
                              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                            }
                          }
                        }
                        if (locala.GLC != null)
                        {
                          locala.GLC.fgF();
                          locala.GLC.HNX = true;
                          locala.GLC.HNY = true;
                          locala.GLC.fgE();
                        }
                      }
                    }
                  }
                }
              }
            };
          }
          if (bk.x(parambl)) {
            break label1311;
          }
          i = bk.D(parambl);
          if ((i > 0) && (i < com.tencent.mm.ui.widget.textview.b.gA(locala.GLB).length())) {
            break label1416;
          }
          i = 0;
        }
      }
      label1285:
      label1416:
      for (;;)
      {
        paramString = c(parama1);
        localObject = a(paramString);
        if (locala.GLC != null) {
          locala.GLC.destroy();
        }
        localObject = new a.a(locala.GLB, locala.GqT, (a.f)localObject, faN(), locala.GLD);
        ((a.a)localObject).HNO = 2131100846;
        ((a.a)localObject).HOi = 18;
        ((a.a)localObject).HNP = 2131100195;
        locala.GLC = ((a.a)localObject).fgN();
        locala.GLE = new q.d(locala.GLC);
        locala.GLC.HNG = new v()
        {
          public final void am(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180000);
            q.b.a(q.b.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180000);
          }
        };
        locala.GHI = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180001);
            locala.GLC.fgF();
            locala.GLC.HNX = true;
            locala.GLC.HNY = true;
            locala.GLC.fgE();
            AppMethodBeat.o(180001);
          }
        };
        paramString.GHI = locala.GHI;
        locala.GLC.HNT = i;
        locala.GLC.HOe = locala.GLE;
        label797:
        locala.GLB.setOnDoubleClickListener(this);
        locala.GLB.setTag(parama);
        locala.GLB.setTextListener(new MMNeat7extView.a()
        {
          public final void an(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180002);
            if (((Boolean)locala.GLB.getTag(q.b.GLJ)).booleanValue())
            {
              com.tencent.mm.ui.chatting.l.a.a.fat();
              com.tencent.mm.ui.chatting.l.a.a.fau().a(paramAnonymousCharSequence, ((Long)locala.GLB.getTag(q.b.GLI)).longValue());
            }
            AppMethodBeat.o(180002);
          }
        });
        locala.GLB.setMaxLines(2147483647);
        paramString = ChattingItemTranslate.b.GPB;
        if (com.tencent.mm.app.plugin.c.LA()) {
          if ((parambl.eMj()) && (parambl.eMt()))
          {
            parama = parambl.field_transContent;
            label877:
            paramString = ((am)parama1.be(am.class)).bK(parambl);
          }
        }
        for (;;)
        {
          if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.GPB))
          {
            if ((locala.GLG == null) && (locala.GLF != null))
            {
              locala.GLG = ((ChattingItemTranslate)locala.GLF.inflate());
              locala.GLG.init();
            }
            Context localContext = locala.GLB.getContext();
            i = (int)locala.GLB.getTextSize();
            if (parambl != null)
            {
              localObject = y.tD(parambl.field_msgSvrId);
              y.b localb = y.arz().E((String)localObject, true);
              localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
              localb.m("preUsername", b(this.Gob, parambl));
              localb.m("preChatName", c(this.Gob, parambl));
              label1078:
              localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
              ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject });
              locala.GLG.a((CharSequence)localObject, paramString);
              localObject = locala.GLG;
              if (!bt.isNullOrNil(parambl.field_transBrandWording)) {
                break label1372;
              }
            }
            label1298:
            label1311:
            label1372:
            for (paramString = parama1.GzJ.getMMResources().getString(2131764409);; paramString = parambl.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject).setBrandWording(paramString);
              if (!bt.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
                parama.GQU = false;
                parama.nBH = 2;
                locala.GLG.setTag(parama);
                locala.GLG.setOnClickListener(faN());
                locala.GLG.setOnDoubleClickListener(this);
                locala.GLG.setOnTouchListener(((i)parama1.be(i.class)).eWp());
                locala.GLG.setOnLongClickListener(c(parama1));
                locala.GLG.setVisibility(0);
              }
              AppMethodBeat.o(36946);
              return;
              paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
              break;
              locala.qkL.setVisibility(8);
              break label288;
              locala.GIU.setVisibility(8);
              break label387;
              locala.GLB.setTag(GLH, Boolean.FALSE);
              locala.GLB.setOnTouchListener(locala.GLD);
              locala.GLB.setOnLongClickListener(c(parama1));
              locala.GLB.setOnClickListener(faN());
              break label797;
              localObject = null;
              break label1078;
            }
          }
          if (locala.GLG != null) {
            locala.GLG.setVisibility(8);
          }
          AppMethodBeat.o(36946);
          return;
          parama = null;
          break label877;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36947);
    if (parambl.esh != null) {
      parambl.esh.contains("announcement@all");
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.nBH == 1)
    {
      ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl)) {
        paramContextMenu.add(i, 151, 0, this.Gob.GzJ.getMMResources().getString(2131760101));
      }
      paramContextMenu.add(i, 102, 0, this.Gob.GzJ.getMMResources().getString(2131757218));
      paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      if (com.tencent.mm.bs.d.axB("favorite")) {
        paramContextMenu.add(i, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((com.tencent.mm.app.plugin.c.LA()) && ((!parambl.eMj()) || (!parambl.eMt()))) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757242));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      }
      if (bk.x(parambl))
      {
        paramContextMenu.clear();
        if (!this.Gob.eZc()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.nBH != 2)
    {
      AppMethodBeat.o(36947);
      return true;
    }
    ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
    paramContextMenu.add(i, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(i, 142, 0, paramView.getContext().getString(2131762559));
    if (com.tencent.mm.bs.d.axB("favorite")) {
      paramContextMenu.add(i, 143, 0, paramView.getContext().getString(2131761941));
    }
    if (com.tencent.mm.app.plugin.c.LA())
    {
      if ((parambl.eMj()) && (parambl.eMt())) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757240));
      }
      if (parambl.eMw()) {
        paramContextMenu.add(i, 125, 0, paramView.getContext().getString(2131757233));
      }
    }
    AppMethodBeat.o(36947);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
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
      r.a(parama, parambl.field_msgId, 2);
      AppMethodBeat.o(36948);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)aj.getContext().getSystemService("clipboard");
      parama = k.b.rx(com.tencent.mm.model.bi.b(parama.eZa(), parambl.field_content, parambl.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.wcB;
      com.tencent.mm.plugin.secinforeport.a.a.m(1, parambl.field_msgSvrId, bt.aFZ(parama));
      AppMethodBeat.o(36948);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36948);
      return false;
    case 124: 
    case 125: 
      ((am)parama.be(am.class)).b(paramMenuItem, parambl);
      AppMethodBeat.o(36948);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)aj.getContext().getSystemService("clipboard");
      parambl = parambl.field_transContent;
      if (!bt.isNullOrNil(parambl)) {
        paramMenuItem.setText(parambl);
      }
      com.tencent.mm.ui.base.h.cf(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131755702));
      AppMethodBeat.o(36948);
      return true;
    case 142: 
      localObject = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambl.field_transContent;
      if ((parama.eZb()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
      {
        i = com.tencent.mm.model.bi.uc(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambl.eLS())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      localObject = new cs();
      paramMenuItem = parambl.field_transContent;
      if ((parama.eZb()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
      {
        i = com.tencent.mm.model.bi.uc(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cs)localObject, paramMenuItem, 1);
        ((cs)localObject).deQ.fragment = parama.GzJ;
        ((cs)localObject).deQ.deW = 43;
        if (((cs)localObject).deQ.deS != null)
        {
          paramMenuItem = ((cs)localObject).deQ.deS.DiD;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.aEl(parambl.field_talker);
          paramMenuItem.aEm(u.aqG());
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(36948);
          return true;
        }
        ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean fT(View paramView)
  {
    AppMethodBeat.i(36949);
    if (q.fR(paramView))
    {
      ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36949);
      return true;
    }
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bi)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).fli();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bi)localObject2).drF.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jH(paramView.getContext());
    }
    AppMethodBeat.o(36949);
    return true;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b
 * JD-Core Version:    0.7.0.1
 */