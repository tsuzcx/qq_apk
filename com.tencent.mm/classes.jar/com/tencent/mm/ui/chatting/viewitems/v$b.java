package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class v$b
  extends c
  implements NeatTextView.b
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
    AppMethodBeat.i(37012);
    if (this.Kcx == null) {
      this.Kcx = new v.f(this.JBI);
    }
    v.f localf = this.Kcx;
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
      localObject = new ah(paramLayoutInflater, 2131493444);
      ((View)localObject).setTag(new v.a().gB((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.JBI = parama1;
    ((m)parama1.bh(m.class)).bK(parambu);
    final v.a locala = (v.a)parama;
    locala.KbY.setTag(Kcf, Long.valueOf(parambu.field_msgId));
    locala.KbY.setTag(Kcg, Boolean.TRUE);
    paramString = parambu.field_content;
    parama = paramString;
    int i;
    if (parama1.fFv())
    {
      i = parambu.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambu.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    label399:
    label1182:
    label1595:
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      boolean bool;
      Object localObject1;
      int j;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.JOR.getContext(), locala.rDq.getTextSize(), parambu, parama.hCy);
        locala.rDq.setText(com.tencent.mm.pluginsdk.ui.span.k.c(locala.KbY.getContext(), (CharSequence)paramString.second));
        locala.rDq.setTag(parama.hCy);
        bool = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        localObject1 = t.aKa().Gb(parama1.getTalkerUserName());
        ba.aBQ();
        i = ((Integer)com.tencent.mm.model.c.ajl().get(12311, Integer.valueOf(-2))).intValue();
        if (((localObject1 != null) && (((com.tencent.mm.bc.a)localObject1).iiM != -2)) || ((localObject1 == null) && (i != -2))) {
          if (bool)
          {
            locala.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100211));
            locala.Kcw.setBackgroundResource(2131233363);
            if (!((Boolean)paramString.first).booleanValue()) {
              break label1497;
            }
            locala.rDq.setVisibility(0);
            locala.ofK.setVisibility(0);
            locala.ofK.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37003);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                try
                {
                  long l = ((Long)locala.KbY.getTag(v.b.Kcf)).longValue();
                  ad.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
                  localObject = (MsgQuoteItem)locala.rDq.getTag();
                  v.e.a(parama1, v.b.this, paramAnonymousView, l, (MsgQuoteItem)localObject, v.b.this.oSO);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37003);
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  for (;;)
                  {
                    ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
                  }
                }
              }
            });
            locala.rDq.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37004);
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.ofK.getLayoutParams();
                localLayoutParams.height = locala.Kcw.getHeight();
                localLayoutParams.width = locala.Kcw.getWidth();
                locala.ofK.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(37004);
              }
            });
            locala.JZp.setVisibility(8);
            locala.KbY.setClickable(true);
            parama = com.tencent.mm.pluginsdk.ui.span.k.a(locala.KbY.getContext(), parama.title, (int)locala.KbY.getTextSize(), 1);
            locala.KbY.a(parama, TextView.BufferType.SPANNABLE);
            parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
            paramString = locala.KbY.getContext();
            locala.KbY.setTag(Kce, Boolean.TRUE);
            if (locala.JEB == null)
            {
              locala.JEB = new com.tencent.mm.ui.widget.b.a(paramString, locala.KbY);
              locala.JEB.KLB = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(180009);
                  parama1.setFocused(true);
                  c.a(locala.JEB, parama1, v.b.a(v.b.this), v.b.b(v.b.this), 49);
                  v.b.a(v.b.this, -1);
                  v.b.b(v.b.this, -1);
                  AppMethodBeat.o(180009);
                }
              };
              locala.JEB.Lal = true;
              locala.JEB.Laj = new n.c()
              {
                public final void a(l paramAnonymousl, View paramAnonymousView)
                {
                  AppMethodBeat.i(194381);
                  paramAnonymousl.clear();
                  paramAnonymousl.a(0, 0, paramString.getResources().getString(2131755701), 2131690381);
                  paramAnonymousView = locala.KbY.fSO();
                  bk localbk = (bk)locala.KbY.getTag();
                  if (localbk != null) {}
                  for (int i = bl.F(localbk.dBd);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymousl.a(0, 1, paramString.getResources().getString(2131761224), 2131691572);
                    }
                    paramAnonymousl.a(0, 2, paramString.getResources().getString(2131761223), 2131690478);
                    paramAnonymousl.a(0, 3, paramString.getResources().getString(2131758845), 2131690400);
                    AppMethodBeat.o(194381);
                    return;
                  }
                }
              };
              locala.JEB.KJz = new n.e()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(180013);
                  v.b.a(v.b.this, paramAnonymousInt);
                  v.b.b(v.b.this, paramAnonymousMenuItem.getItemId());
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(180013);
                    return;
                    ((android.content.ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(v.b.c(v.b.this), v.b.c(v.b.this)));
                    if (locala.KbZ != null)
                    {
                      locala.KbZ.fNt();
                      locala.KbZ.LfQ = true;
                      locala.KbZ.LfR = true;
                      locala.KbZ.fNs();
                    }
                    Toast.makeText(paramString, 2131755702, 0).show();
                    AppMethodBeat.o(180013);
                    return;
                    if (locala.KbZ != null)
                    {
                      if (locala.KbZ.LfB != null) {
                        locala.KbZ.LfB.fHl();
                      }
                      locala.KbZ.LfQ = true;
                      locala.KbZ.fNs();
                      locala.KbZ.kp(0, locala.KbY.fSO().length());
                      locala.KbZ.fNv();
                      locala.KbZ.fNy();
                      if (locala.KbZ.LfB != null)
                      {
                        locala.KbZ.LfB.fHm();
                        AppMethodBeat.o(180013);
                        return;
                        paramAnonymousMenuItem = (bk)locala.KbY.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = bl.E(paramAnonymousMenuItem.dBd);
                          Object localObject;
                          if (bt.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject).putExtra("Retr_Msg_content", v.b.c(v.b.this));
                            ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180013);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180011);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
                              com.tencent.mm.bs.d.b(v.b.5.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              AppMethodBeat.o(180011);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180012);
                              Object localObject = new Intent(v.b.5.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", v.b.c(v.b.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = v.b.5.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(180012);
                            }
                          });
                          AppMethodBeat.o(180013);
                          return;
                          paramAnonymousMenuItem = new cv();
                          g.b(paramAnonymousMenuItem, v.b.c(v.b.this).toString(), 1);
                          paramAnonymousMenuItem.dnG.fragment = v.b.d(v.b.this).JOR;
                          paramAnonymousMenuItem.dnG.dnM = 43;
                          if (paramAnonymousMenuItem.dnG.dnI != null)
                          {
                            localObject = paramAnonymousMenuItem.dnG.dnI.Gjv;
                            if (localObject != null)
                            {
                              bk localbk = (bk)locala.KbY.getTag();
                              if (localbk != null)
                              {
                                ((akj)localObject).aPf(localbk.dBd.field_talker);
                                ((akj)localObject).aPg(u.aAm());
                                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                              }
                            }
                          }
                          if (locala.KbZ != null)
                          {
                            locala.KbZ.fNt();
                            locala.KbZ.LfQ = true;
                            locala.KbZ.LfR = true;
                            locala.KbZ.fNs();
                          }
                        }
                      }
                    }
                  }
                }
              };
            }
            if (bl.z(parambu)) {
              break label1534;
            }
            j = bl.F(parambu);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.hh(locala.KbY).length())) {
              break label1642;
            }
            j = 0;
          }
        }
      }
      label981:
      label1497:
      label1642:
      for (;;)
      {
        paramString = c(parama1);
        localObject1 = a(paramString);
        if (locala.KbZ != null) {
          locala.KbZ.destroy();
        }
        Object localObject2 = new int[2];
        i = 0;
        if (locala.KbY != null)
        {
          locala.KbY.getLocationOnScreen((int[])localObject2);
          int k = localObject2[0];
          i = k;
          if (k == 0)
          {
            localObject2 = new Rect();
            locala.KbY.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new a.a(locala.KbY, locala.JEB, (a.f)localObject1, fHs(), locala.Kca);
          ((a.a)localObject1).LfH = 2131100846;
          ((a.a)localObject1).Lgb = 18;
          ((a.a)localObject1).LfI = 2131100195;
          if (i != 0) {
            ((a.a)localObject1).Lgc = (com.tencent.mm.ui.aq.ay(locala.KbY.getContext(), 2131165289) + i);
          }
          locala.KbZ = ((a.a)localObject1).fNB();
          locala.Kcb = new v.d(locala.KbZ);
          locala.KbZ.Lfz = new v()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180014);
              v.b.a(v.b.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180014);
            }
          };
          locala.JXY = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180015);
              locala.KbZ.fNt();
              locala.KbZ.LfQ = true;
              locala.KbZ.LfR = true;
              locala.KbZ.fNs();
              AppMethodBeat.o(180015);
            }
          };
          paramString.JXY = locala.JXY;
          locala.KbZ.LfM = j;
          locala.KbZ.LfX = locala.Kcb;
          locala.KbY.setOnDoubleClickListener(this);
          locala.KbY.setTag(parama);
          locala.KbY.setTextListener(new MMNeat7extView.a()
          {
            public final void ao(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180016);
              if (((Boolean)locala.KbY.getTag(v.b.Kcg)).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.fGX();
                com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)locala.KbY.getTag(v.b.Kcf)).longValue());
              }
              AppMethodBeat.o(180016);
            }
          });
          locala.KbY.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.b.Kgd;
          if (com.tencent.mm.app.plugin.c.Ng()) {
            if ((parambu.frS()) && (parambu.fsb()))
            {
              parama = parambu.field_transContent;
              paramString = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
            }
          }
          for (;;)
          {
            if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.Kgd))
            {
              if ((locala.Kcd == null) && (locala.Kcc != null))
              {
                locala.Kcd = ((ChattingItemTranslate)locala.Kcc.inflate());
                locala.Kcd.init();
              }
              localObject2 = locala.KbY.getContext();
              i = (int)locala.KbY.getTextSize();
              if (parambu != null)
              {
                localObject1 = y.AH(parambu.field_msgSvrId);
                y.b localb = y.aBq().F((String)localObject1, true);
                localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
                localb.k("preUsername", b(this.JBI, parambu));
                localb.k("preChatName", c(this.JBI, parambu));
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, parama, i, 1, null, (String)localObject1);
                ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.Kcd.a((CharSequence)localObject1, paramString);
                localObject1 = locala.Kcd;
                if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
                  break label1595;
                }
              }
              for (paramString = parama1.JOR.getMMResources().getString(2131764409);; paramString = parambu.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!bt.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
                  parama.Khy = false;
                  parama.oIb = 2;
                  locala.Kcd.setTag(parama);
                  locala.Kcd.setOnClickListener(fHs());
                  locala.Kcd.setOnDoubleClickListener(this);
                  locala.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                  locala.Kcd.setOnLongClickListener(c(parama1));
                  locala.Kcd.setVisibility(0);
                }
                AppMethodBeat.o(37014);
                return;
                locala.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100710));
                locala.Kcw.setBackgroundResource(2131233362);
                break;
                if (bool)
                {
                  locala.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099658));
                  locala.Kcw.setBackgroundResource(2131233361);
                  break;
                }
                locala.rDq.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100211));
                locala.Kcw.setBackgroundResource(2131233360);
                break;
                if (bt.ai((CharSequence)paramString.second)) {
                  locala.rDq.setVisibility(8);
                }
                locala.ofK.setVisibility(8);
                break label399;
                label1534:
                locala.KbY.setTag(Kce, Boolean.FALSE);
                locala.KbY.setOnTouchListener(locala.Kca);
                locala.KbY.setOnLongClickListener(c(parama1));
                locala.KbY.setOnClickListener(fHs());
                break label901;
                localObject1 = null;
                break label1182;
              }
            }
            if (locala.Kcd != null) {
              locala.Kcd.setVisibility(8);
            }
            AppMethodBeat.o(37014);
            return;
            parama = null;
            break label981;
            parama = null;
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
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
      paramMenuItem = (android.content.ClipboardManager)aj.getContext().getSystemService("clipboard");
      parama = k.b.yr(bj.b(parama.fFu(), parambu.field_content, parambu.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yBN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(parama));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, parambu);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)aj.getContext().getSystemService("clipboard");
      parambu = parambu.field_transContent;
      if (!bt.isNullOrNil(parambu)) {
        paramMenuItem.setText(parambu);
      }
      com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
      AppMethodBeat.o(37016);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
        g.b((cv)localObject, paramMenuItem, 1);
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
          AppMethodBeat.o(37016);
          return true;
        }
        ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194382);
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oIb == 1)
    {
      paraml.a(i, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
      paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(i, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
        paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      }
      if (bl.z(parambu))
      {
        paraml.clear();
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
      }
    }
    while (locala.oIb != 2)
    {
      AppMethodBeat.o(194382);
      return true;
    }
    ad.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
    paraml.a(i, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(i, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.bs.d.aIu("favorite")) {
      paraml.a(i, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Ng())
    {
      if ((parambu.frS()) && (parambu.fsb())) {
        paraml.a(i, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambu.fse()) {
        paraml.a(i, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(194382);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  public final boolean gx(View paramView)
  {
    AppMethodBeat.i(37017);
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bk)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).fSO();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dBd.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kd(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.b
 * JD-Core Version:    0.7.0.1
 */