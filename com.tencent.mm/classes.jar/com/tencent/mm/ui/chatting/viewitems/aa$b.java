package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class aa$b
  extends c
  implements NeatTextView.b
{
  private static final int PKJ = 2131308867;
  private static final int PKK = 2131298495;
  private static final int PKL = 2131298494;
  private int PHj = -1;
  private aa.f PLc;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private CharSequence PkM;
  private int hcg = -1;
  
  private aa.f gUf()
  {
    AppMethodBeat.i(37012);
    if (this.PLc == null) {
      this.PLc = new aa.f(this.PhN);
    }
    aa.f localf = this.PLc;
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
      localObject = new an(paramLayoutInflater, 2131493544);
      ((View)localObject).setTag(new aa.a().gW((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    final aa.a locala = (aa.a)parama;
    locala.PKD.setTag(PKK, Long.valueOf(paramca.field_msgId));
    locala.PKD.setTag(PKL, Boolean.TRUE);
    paramString = paramca.field_content;
    parama = paramString;
    int i;
    if (parama1.gRM())
    {
      i = paramca.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    label399:
    label922:
    label1203:
    label1616:
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      boolean bool;
      Object localObject1;
      int j;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.Pwc.getContext(), locala.tln.getTextSize(), paramca, parama.izy);
        locala.tln.setText(l.c(locala.PKD.getContext(), (CharSequence)paramString.second));
        locala.tln.setTag(parama.izy);
        bool = ((k)parama1.bh(k.class)).isInEditMode();
        localObject1 = v.bew().Pp(parama1.getTalkerUserName());
        bg.aVF();
        i = ((Integer)com.tencent.mm.model.c.azQ().get(12311, Integer.valueOf(-2))).intValue();
        if (((localObject1 != null) && (((com.tencent.mm.bb.a)localObject1).jgE != -2)) || ((localObject1 == null) && (i != -2))) {
          if (bool)
          {
            locala.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100244));
            locala.PLb.setBackgroundResource(2131234044);
            if (!((Boolean)paramString.first).booleanValue()) {
              break label1518;
            }
            locala.tln.setVisibility(0);
            locala.clickArea.setVisibility(0);
            locala.clickArea.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37003);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                try
                {
                  long l = ((Long)locala.PKD.getTag(aa.b.PKK)).longValue();
                  Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
                  localObject = (MsgQuoteItem)locala.tln.getTag();
                  aa.e.a(parama1, aa.b.this, paramAnonymousView, l, (MsgQuoteItem)localObject, aa.b.this.qoo);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37003);
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
                  }
                }
              }
            });
            locala.tln.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37004);
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.clickArea.getLayoutParams();
                localLayoutParams.height = locala.PLb.getHeight();
                localLayoutParams.width = locala.PLb.getWidth();
                locala.clickArea.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(37004);
              }
            });
            locala.PHZ.setVisibility(8);
            locala.PKD.setClickable(true);
            paramString = t.Ao(parama1.gRM());
            parama = l.a(locala.PKD.getContext(), parama.title, (int)locala.PKD.getTextSize(), 1, false, paramString, l.Krf);
            locala.PKD.a(parama, TextView.BufferType.SPANNABLE);
            parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
            paramString = locala.PKD.getContext();
            locala.PKD.setTag(PKJ, Boolean.TRUE);
            if (locala.wnj == null)
            {
              locala.wnj = new com.tencent.mm.ui.widget.b.a(paramString, locala.PKD);
              locala.wnj.QwU = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(180009);
                  parama1.setFocused(true);
                  c.a(locala.wnj, parama1, aa.b.a(aa.b.this), aa.b.b(aa.b.this), 49);
                  aa.b.a(aa.b.this, -1);
                  aa.b.b(aa.b.this, -1);
                  AppMethodBeat.o(180009);
                }
              };
              locala.wnj.QSv = true;
              locala.wnj.QSt = new o.e()
              {
                public final void a(com.tencent.mm.ui.base.m paramAnonymousm, View paramAnonymousView)
                {
                  AppMethodBeat.i(233751);
                  paramAnonymousm.clear();
                  paramAnonymousm.a(0, 0, paramString.getResources().getString(2131755772), 2131690525);
                  paramAnonymousView = locala.PKD.hiT();
                  Object localObject = (bq)locala.PKD.getTag();
                  if (localObject != null) {}
                  for (int i = br.O(((bq)localObject).dTX);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymousm.a(0, 1, paramString.getResources().getString(2131763038), 2131690480);
                    }
                    paramAnonymousm.a(0, 2, paramString.getResources().getString(2131763036), 2131690674);
                    paramAnonymousm.a(0, 3, paramString.getResources().getString(2131759168), 2131690551);
                    if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                    {
                      paramAnonymousm.a(0, 4, paramString.getResources().getString(2131757451), 2131690670);
                      if (!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                        break label355;
                      }
                      paramAnonymousm = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(aa.b.c(aa.b.this).toString());
                      if (!Util.isNullOrNil(paramAnonymousm)) {
                        aa.b.this.a(locala.wnj, parama1, paramAnonymousm);
                      }
                    }
                    for (;;)
                    {
                      if (Util.isNullOrNil(paramAnonymousm)) {
                        locala.wnj.QSA = null;
                      }
                      paramAnonymousView = "65_" + cl.aWA();
                      localObject = aa.b.this;
                      com.tencent.mm.ui.chatting.e.a locala = parama1;
                      ca localca = paramca;
                      if (!Util.isNullOrNil(paramAnonymousm)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        ((aa.b)localObject).a(locala, localca, 1, bool, aa.b.c(aa.b.this).toString(), true, paramAnonymousView);
                        AppMethodBeat.o(233751);
                        return;
                      }
                      label355:
                      paramAnonymousm = "";
                    }
                  }
                }
              };
              locala.wnj.HLY = new o.g()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(180013);
                  aa.b.a(aa.b.this, paramAnonymousInt);
                  aa.b.b(aa.b.this, paramAnonymousMenuItem.getItemId());
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
                            AppMethodBeat.o(180013);
                            return;
                            ClipboardHelper.setText(MMApplicationContext.getContext(), aa.b.c(aa.b.this), aa.b.c(aa.b.this));
                            if (locala.PKE != null)
                            {
                              locala.PKE.hbA();
                              locala.PKE.QXW = true;
                              locala.PKE.QXX = true;
                              locala.PKE.hbz();
                            }
                            Toast.makeText(paramString, 2131755773, 0).show();
                            AppMethodBeat.o(180013);
                            return;
                          } while (locala.PKE == null);
                          if (locala.PKE.QXQ != null) {
                            locala.PKE.QXQ.gTY();
                          }
                          locala.PKE.QXW = true;
                          locala.PKE.hbz();
                          locala.PKE.lE(0, locala.PKD.hiT().length());
                          locala.PKE.hcQ();
                          locala.PKE.hcT();
                        } while (locala.PKE.QXQ == null);
                        locala.PKE.QXQ.gTZ();
                        AppMethodBeat.o(180013);
                        return;
                        paramAnonymousMenuItem = (bq)locala.PKD.getTag();
                      } while (paramAnonymousMenuItem == null);
                      paramAnonymousMenuItem = br.N(paramAnonymousMenuItem.dTX);
                      if (Util.isNullOrNil(paramAnonymousMenuItem))
                      {
                        localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                        ((Intent)localObject1).putExtra("Retr_Msg_content", aa.b.c(aa.b.this));
                        ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                        paramAnonymousMenuItem = paramString;
                        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(180013);
                        return;
                      }
                      com.tencent.mm.ui.base.h.a(paramString, 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(180011);
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                          paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                          paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                          com.tencent.mm.br.c.b(aa.b.5.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(180011);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(180012);
                          Object localObject = new Intent(aa.b.5.this.val$context, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", aa.b.c(aa.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymous2DialogInterface = aa.b.5.this.val$context;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(180012);
                        }
                      });
                      AppMethodBeat.o(180013);
                      return;
                      paramAnonymousMenuItem = new cz();
                      com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, aa.b.c(aa.b.this).toString(), 1);
                      paramAnonymousMenuItem.dFZ.fragment = aa.b.d(aa.b.this).Pwc;
                      paramAnonymousMenuItem.dFZ.dGf = 43;
                      if (paramAnonymousMenuItem.dFZ.dGb != null)
                      {
                        localObject1 = paramAnonymousMenuItem.dFZ.dGb.Lya;
                        if (localObject1 != null)
                        {
                          localObject2 = (bq)locala.PKD.getTag();
                          if (localObject2 != null)
                          {
                            ((anh)localObject1).bhf(((bq)localObject2).dTX.field_talker);
                            ((anh)localObject1).bhg(z.aTY());
                            EventCenter.instance.publish(paramAnonymousMenuItem);
                          }
                        }
                      }
                    } while (locala.PKE == null);
                    locala.PKE.hbA();
                    locala.PKE.QXW = true;
                    locala.PKE.QXX = true;
                    locala.PKE.hbz();
                    AppMethodBeat.o(180013);
                    return;
                  }
                  Object localObject1 = "65_" + cl.aWA();
                  Object localObject2 = aa.b.c(aa.b.this).toString();
                  if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {}
                  for (paramAnonymousMenuItem = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject2);; paramAnonymousMenuItem = "")
                  {
                    aa.b localb = aa.b.this;
                    com.tencent.mm.ui.chatting.e.a locala = parama1;
                    ca localca = paramca;
                    if (!Util.isNullOrNil(paramAnonymousMenuItem)) {}
                    for (boolean bool = true;; bool = false)
                    {
                      localb.a(locala, localca, 2, bool, (String)localObject2, true, (String)localObject1);
                      paramAnonymousMenuItem = new ag();
                      paramAnonymousMenuItem.context = paramString;
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
            if (br.B(paramca)) {
              break label1555;
            }
            j = br.O(paramca);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.hB(locala.PKD).length())) {
              break label1663;
            }
            j = 0;
          }
        }
      }
      label1002:
      label1518:
      label1663:
      for (;;)
      {
        paramString = c(parama1);
        localObject1 = a(paramString);
        if (locala.PKE != null) {
          locala.PKE.destroy();
        }
        Object localObject2 = new int[2];
        i = 0;
        if (locala.PKD != null)
        {
          locala.PKD.getLocationInWindow((int[])localObject2);
          int k = localObject2[0];
          i = k;
          if (k == 0)
          {
            localObject2 = new Rect();
            locala.PKD.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new a.a(locala.PKD, locala.wnj, (a.f)localObject1, gUf(), locala.PKF);
          ((a.a)localObject1).QPi = 2131101045;
          ((a.a)localObject1).QYg = 18;
          ((a.a)localObject1).QPj = 2131100228;
          if (i != 0) {
            ((a.a)localObject1).QYh = (at.aH(locala.PKD.getContext(), 2131165296) + i);
          }
          locala.PKE = ((a.a)localObject1).hcW();
          locala.PKG = new aa.d(locala.PKE);
          locala.PKE.QXO = new x()
          {
            public final void as(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180014);
              aa.b.a(aa.b.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180014);
            }
          };
          locala.PGP = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180015);
              locala.PKE.hbA();
              locala.PKE.QXW = true;
              locala.PKE.QXX = true;
              locala.PKE.hbz();
              AppMethodBeat.o(180015);
            }
          };
          paramString.PGP = locala.PGP;
          locala.PKE.QXU = j;
          locala.PKE.QYc = locala.PKG;
          locala.PKD.setOnDoubleClickListener(this);
          locala.PKD.setTag(parama);
          locala.PKD.setTextListener(new MMNeat7extView.a()
          {
            public final void at(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180016);
              if (((Boolean)locala.PKD.getTag(aa.b.PKL)).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)locala.PKD.getTag(aa.b.PKK)).longValue());
              }
              AppMethodBeat.o(180016);
            }
          });
          locala.PKD.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.c.PPm;
          if (com.tencent.mm.app.plugin.c.Xn()) {
            if ((paramca.gDz()) && (paramca.gDI()))
            {
              parama = paramca.field_transContent;
              paramString = ((au)parama1.bh(au.class)).cj(paramca);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
            {
              if ((locala.PKI == null) && (locala.PKH != null))
              {
                locala.PKI = ((ChattingItemTranslate)locala.PKH.inflate());
                locala.PKI.init();
              }
              localObject2 = locala.PKD.getContext();
              i = (int)locala.PKD.getTextSize();
              if (paramca != null)
              {
                localObject1 = ad.JX(paramca.field_msgSvrId);
                ad.b localb = ad.aVe().G((String)localObject1, true);
                localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
                localb.l("preUsername", a(this.PhN, paramca));
                localb.l("preChatName", b(this.PhN, paramca));
                localObject1 = l.a((Context)localObject2, parama, i, 1, null, (String)localObject1);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.PKI.a((CharSequence)localObject1, paramString);
                localObject1 = locala.PKI;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1616;
                }
              }
              for (paramString = parama1.Pwc.getMMResources().getString(2131766752);; paramString = paramca.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                  parama.PQG = false;
                  parama.qcr = 2;
                  locala.PKI.setTag(parama);
                  locala.PKI.setOnClickListener(gUf());
                  locala.PKI.setOnDoubleClickListener(this);
                  locala.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                  locala.PKI.setOnLongClickListener(c(parama1));
                  locala.PKI.setVisibility(0);
                }
                AppMethodBeat.o(37014);
                return;
                locala.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100903));
                locala.PLb.setBackgroundResource(2131234043);
                break;
                if (bool)
                {
                  locala.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099660));
                  locala.PLb.setBackgroundResource(2131234042);
                  break;
                }
                locala.tln.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100244));
                locala.PLb.setBackgroundResource(2131234041);
                break;
                if (Util.isNullOrNil((CharSequence)paramString.second)) {
                  locala.tln.setVisibility(8);
                }
                locala.clickArea.setVisibility(8);
                break label399;
                locala.PKD.setTag(PKJ, Boolean.FALSE);
                locala.PKD.setOnTouchListener(locala.PKF);
                locala.PKD.setOnLongClickListener(c(parama1));
                locala.PKD.setOnClickListener(gUf());
                break label922;
                localObject1 = null;
                break label1203;
              }
            }
            if (locala.PKI != null) {
              locala.PKI.setVisibility(8);
            }
            AppMethodBeat.o(37014);
            return;
            parama = null;
            break label1002;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
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
      paramMenuItem = k.b.HD(bp.b(parama.gRL(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
      com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((au)parama.bh(au.class)).b(paramMenuItem, paramca);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = paramca.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
      AppMethodBeat.o(37016);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
          AppMethodBeat.o(37016);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233752);
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.qcr == 1)
    {
      paramm.a(i, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
        paramm.a(i, 124, paramView.getContext().getString(2131757455), 2131690699);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      }
      if (br.B(paramca))
      {
        paramm.clear();
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
        }
      }
    }
    while (locala.qcr != 2)
    {
      AppMethodBeat.o(233752);
      return true;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
    paramm.a(i, 141, paramView.getContext().getString(2131757430), 2131690525);
    paramm.a(i, 142, paramView.getContext().getString(2131764628), 2131690674);
    if (com.tencent.mm.br.c.aZU("favorite")) {
      paramm.a(i, 143, paramView.getContext().getString(2131763947), 2131690551);
    }
    if (com.tencent.mm.app.plugin.c.Xn())
    {
      if ((paramca.gDz()) && (paramca.gDI())) {
        paramm.a(i, 124, paramView.getContext().getString(2131757453), 2131690549);
      }
      if (paramca.gDL()) {
        paramm.a(i, 125, paramView.getContext().getString(2131757445), 2131690658);
      }
    }
    AppMethodBeat.o(233752);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gS(View paramView)
  {
    AppMethodBeat.i(37017);
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bq)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).hiT();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bq)localObject2).dTX.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      if (this.PhN != null) {
        ((Intent)localObject1).putExtra("is_group_chat", this.PhN.gRM());
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kc(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.b
 * JD-Core Version:    0.7.0.1
 */