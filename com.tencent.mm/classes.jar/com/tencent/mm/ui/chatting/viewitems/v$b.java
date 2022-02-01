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
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.HashMap;
import java.util.Map;

public final class v$b
  extends c
  implements NeatTextView.b
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
    AppMethodBeat.i(37012);
    if (this.KyP == null) {
      this.KyP = new v.f(this.JWz);
    }
    v.f localf = this.KyP;
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
      ((View)localObject).setTag(new v.a().gG((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.JWz = parama1;
    ((m)parama1.bh(m.class)).bJ(parambv);
    final v.a locala = (v.a)parama;
    locala.Kyq.setTag(Kyx, Long.valueOf(parambv.field_msgId));
    locala.Kyq.setTag(Kyy, Boolean.TRUE);
    paramString = parambv.field_content;
    parama = paramString;
    int i;
    if (parama1.fJC())
    {
      i = parambv.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambv.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      boolean bool;
      Object localObject1;
      label399:
      Object localObject2;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.Kkd.getContext(), locala.rLB.getTextSize(), parambv, parama.hFq);
        locala.rLB.setText(com.tencent.mm.pluginsdk.ui.span.k.c(locala.Kyq.getContext(), (CharSequence)paramString.second));
        locala.rLB.setTag(parama.hFq);
        bool = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        localObject1 = t.aKt().GD(parama1.getTalkerUserName());
        bc.aCg();
        i = ((Integer)com.tencent.mm.model.c.ajA().get(12311, Integer.valueOf(-2))).intValue();
        if (((localObject1 != null) && (((com.tencent.mm.bb.a)localObject1).ilF != -2)) || ((localObject1 == null) && (i != -2))) {
          if (bool)
          {
            locala.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100211));
            locala.KyO.setBackgroundResource(2131233363);
            if (!((Boolean)paramString.first).booleanValue()) {
              break label1507;
            }
            locala.rLB.setVisibility(0);
            locala.olI.setVisibility(0);
            locala.olI.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37003);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                try
                {
                  long l = ((Long)locala.Kyq.getTag(v.b.Kyx)).longValue();
                  ae.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
                  localObject = (MsgQuoteItem)locala.rLB.getTag();
                  v.e.a(parama1, v.b.this, paramAnonymousView, l, (MsgQuoteItem)localObject, v.b.this.oZq);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37003);
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  for (;;)
                  {
                    ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
                  }
                }
              }
            });
            locala.rLB.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37004);
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.olI.getLayoutParams();
                localLayoutParams.height = locala.KyO.getHeight();
                localLayoutParams.width = locala.KyO.getWidth();
                locala.olI.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(37004);
              }
            });
            locala.KvI.setVisibility(8);
            locala.Kyq.setClickable(true);
            parama = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Kyq.getContext(), parama.title, (int)locala.Kyq.getTextSize(), 1);
            locala.Kyq.a(parama, TextView.BufferType.SPANNABLE);
            parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
            paramString = locala.Kyq.getContext();
            locala.Kyq.setTag(Kyw, Boolean.TRUE);
            if (locala.JZs == null)
            {
              locala.JZs = new com.tencent.mm.ui.widget.b.a(paramString, locala.Kyq);
              locala.JZs.LhV = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(180009);
                  parama1.setFocused(true);
                  c.a(locala.JZs, parama1, v.b.a(v.b.this), v.b.b(v.b.this), 49);
                  v.b.a(v.b.this, -1);
                  v.b.b(v.b.this, -1);
                  AppMethodBeat.o(180009);
                }
              };
              locala.JZs.LwJ = true;
              locala.JZs.LwH = new n.c()
              {
                public final void a(l paramAnonymousl, View paramAnonymousView)
                {
                  AppMethodBeat.i(187776);
                  paramAnonymousl.clear();
                  paramAnonymousl.a(0, 0, paramString.getResources().getString(2131755701), 2131690381);
                  paramAnonymousView = locala.Kyq.fXo();
                  bk localbk = (bk)locala.Kyq.getTag();
                  if (localbk != null) {}
                  for (int i = bn.F(localbk.dCi);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymousl.a(0, 1, paramString.getResources().getString(2131761224), 2131691572);
                    }
                    paramAnonymousl.a(0, 2, paramString.getResources().getString(2131761223), 2131690478);
                    paramAnonymousl.a(0, 3, paramString.getResources().getString(2131758845), 2131690400);
                    boolean bool;
                    if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                    {
                      paramAnonymousl.a(0, 4, paramString.getResources().getString(2131762922), 2131690474);
                      bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(v.b.c(v.b.this).toString());
                      if ((!bool) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
                        break label307;
                      }
                      v.b.this.a(locala.JZs, parama1);
                    }
                    for (;;)
                    {
                      paramAnonymousl = "65_" + ch.aDc();
                      v.b.this.a(parama1, parambv, 1, bool, v.b.c(v.b.this).toString(), true, paramAnonymousl);
                      AppMethodBeat.o(187776);
                      return;
                      label307:
                      locala.JZs.LwO = null;
                    }
                  }
                }
              };
              locala.JZs.LfT = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
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
                    ((android.content.ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(v.b.c(v.b.this), v.b.c(v.b.this)));
                    if (locala.Kyr != null)
                    {
                      locala.Kyr.fRO();
                      locala.Kyr.LCs = true;
                      locala.Kyr.LCt = true;
                      locala.Kyr.fRN();
                    }
                    Toast.makeText(paramString, 2131755702, 0).show();
                    AppMethodBeat.o(180013);
                    return;
                    if (locala.Kyr != null)
                    {
                      if (locala.Kyr.LCd != null) {
                        locala.Kyr.LCd.fLD();
                      }
                      locala.Kyr.LCs = true;
                      locala.Kyr.fRN();
                      locala.Kyr.kw(0, locala.Kyq.fXo().length());
                      locala.Kyr.fRQ();
                      locala.Kyr.fRT();
                      if (locala.Kyr.LCd != null)
                      {
                        locala.Kyr.LCd.fLE();
                        AppMethodBeat.o(180013);
                        return;
                        paramAnonymousMenuItem = (bk)locala.Kyq.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = bn.E(paramAnonymousMenuItem.dCi);
                          Object localObject1;
                          if (bu.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject1).putExtra("Retr_Msg_content", v.b.c(v.b.this));
                            ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180013);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new v.b.5.1(this, paramAnonymousMenuItem), new v.b.5.2(this));
                          AppMethodBeat.o(180013);
                          return;
                          paramAnonymousMenuItem = new cw();
                          com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, v.b.c(v.b.this).toString(), 1);
                          paramAnonymousMenuItem.doL.fragment = v.b.d(v.b.this).Kkd;
                          paramAnonymousMenuItem.doL.doR = 43;
                          Object localObject2;
                          if (paramAnonymousMenuItem.doL.doN != null)
                          {
                            localObject1 = paramAnonymousMenuItem.doL.doN.GCe;
                            if (localObject1 != null)
                            {
                              localObject2 = (bk)locala.Kyq.getTag();
                              if (localObject2 != null)
                              {
                                ((akt)localObject1).aQC(((bk)localObject2).dCi.field_talker);
                                ((akt)localObject1).aQD(com.tencent.mm.model.v.aAC());
                                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                              }
                            }
                          }
                          if (locala.Kyr != null)
                          {
                            locala.Kyr.fRO();
                            locala.Kyr.LCs = true;
                            locala.Kyr.LCt = true;
                            locala.Kyr.fRN();
                            AppMethodBeat.o(180013);
                            return;
                            paramAnonymousMenuItem = "65_" + ch.aDc();
                            localObject1 = v.b.c(v.b.this).toString();
                            boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                            v.b.this.a(parama1, parambv, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
                            localObject2 = new HashMap();
                            ((HashMap)localObject2).put("parentSearchID", "");
                            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(paramString, 65, (String)localObject1, paramAnonymousMenuItem, (Map)localObject2);
                          }
                        }
                      }
                    }
                  }
                }
              };
            }
            if (bn.z(parambv)) {
              break label1544;
            }
            i = bn.F(parambv);
            int j;
            if (i > 0)
            {
              j = i;
              if (i < com.tencent.mm.ui.widget.textview.b.hm(locala.Kyq).length()) {}
            }
            else
            {
              j = 0;
            }
            paramString = c(parama1);
            localObject1 = a(paramString);
            if (locala.Kyr != null) {
              locala.Kyr.destroy();
            }
            localObject2 = new int[2];
            i = 0;
            if (locala.Kyq != null)
            {
              locala.Kyq.getLocationOnScreen((int[])localObject2);
              int k = localObject2[0];
              i = k;
              if (k == 0)
              {
                localObject2 = new Rect();
                locala.Kyq.getGlobalVisibleRect((Rect)localObject2);
                i = ((Rect)localObject2).left;
              }
            }
            localObject1 = new a.a(locala.Kyq, locala.JZs, (a.f)localObject1, fLK(), locala.Kys);
            ((a.a)localObject1).LCj = 2131100846;
            ((a.a)localObject1).LCD = 18;
            ((a.a)localObject1).LCk = 2131100195;
            if (i != 0) {
              ((a.a)localObject1).LCE = (i + aq.ay(locala.Kyq.getContext(), 2131165289));
            }
            locala.Kyr = ((a.a)localObject1).fRW();
            locala.Kyt = new v.d(locala.Kyr);
            locala.Kyr.LCb = new com.tencent.mm.ui.base.v()
            {
              public final void am(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180014);
                v.b.a(v.b.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180014);
              }
            };
            locala.Kur = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180015);
                locala.Kyr.fRO();
                locala.Kyr.LCs = true;
                locala.Kyr.LCt = true;
                locala.Kyr.fRN();
                AppMethodBeat.o(180015);
              }
            };
            paramString.Kur = locala.Kur;
            locala.Kyr.LCo = j;
            locala.Kyr.LCz = locala.Kyt;
            label911:
            locala.Kyq.setOnDoubleClickListener(this);
            locala.Kyq.setTag(parama);
            locala.Kyq.setTextListener(new MMNeat7extView.a()
            {
              public final void an(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180016);
                if (((Boolean)locala.Kyq.getTag(v.b.Kyy)).booleanValue())
                {
                  com.tencent.mm.ui.chatting.m.a.a.fLp();
                  com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)locala.Kyq.getTag(v.b.Kyx)).longValue());
                }
                AppMethodBeat.o(180016);
              }
            });
            locala.Kyq.setMaxLines(2147483647);
            paramString = ChattingItemTranslate.b.KCw;
            if (!com.tencent.mm.app.plugin.c.Nb()) {
              break label1644;
            }
            if ((!parambv.fvS()) || (!parambv.fwc())) {
              break label1639;
            }
            parama = parambv.field_transContent;
            label991:
            paramString = ((ar)parama1.bh(ar.class)).bT(parambv);
          }
        }
      }
      for (;;)
      {
        if ((!bu.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.KCw))
        {
          if ((locala.Kyv == null) && (locala.Kyu != null))
          {
            locala.Kyv = ((ChattingItemTranslate)locala.Kyu.inflate());
            locala.Kyv.init();
          }
          localObject2 = locala.Kyq.getContext();
          i = (int)locala.Kyq.getTextSize();
          if (parambv != null)
          {
            localObject1 = z.Br(parambv.field_msgSvrId);
            z.b localb = z.aBG().F((String)localObject1, true);
            localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
            localb.k("preUsername", b(this.JWz, parambv));
            localb.k("preChatName", c(this.JWz, parambv));
            label1192:
            localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, parama, i, 1, null, (String)localObject1);
            ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject1 });
            locala.Kyv.a((CharSequence)localObject1, paramString);
            localObject1 = locala.Kyv;
            if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
              break label1605;
            }
          }
          label1544:
          label1605:
          for (paramString = parama1.Kkd.getMMResources().getString(2131764409);; paramString = parambv.field_transBrandWording)
          {
            ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
            if (!bu.isNullOrNil(parama))
            {
              parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
              parama.KDT = false;
              parama.oOD = 2;
              locala.Kyv.setTag(parama);
              locala.Kyv.setOnClickListener(fLK());
              locala.Kyv.setOnDoubleClickListener(this);
              locala.Kyv.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
              locala.Kyv.setOnLongClickListener(c(parama1));
              locala.Kyv.setVisibility(0);
            }
            AppMethodBeat.o(37014);
            return;
            locala.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100710));
            locala.KyO.setBackgroundResource(2131233362);
            break;
            if (bool)
            {
              locala.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099658));
              locala.KyO.setBackgroundResource(2131233361);
              break;
            }
            locala.rLB.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100211));
            locala.KyO.setBackgroundResource(2131233360);
            break;
            label1507:
            if (bu.ah((CharSequence)paramString.second)) {
              locala.rLB.setVisibility(8);
            }
            locala.olI.setVisibility(8);
            break label399;
            locala.Kyq.setTag(Kyw, Boolean.FALSE);
            locala.Kyq.setOnTouchListener(locala.Kys);
            locala.Kyq.setOnLongClickListener(c(parama1));
            locala.Kyq.setOnClickListener(fLK());
            break label911;
            localObject1 = null;
            break label1192;
          }
        }
        if (locala.Kyv != null) {
          locala.Kyv.setVisibility(8);
        }
        AppMethodBeat.o(37014);
        return;
        label1639:
        parama = null;
        break label991;
        label1644:
        parama = null;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
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
      paramMenuItem = (android.content.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parama = k.b.zb(bl.b(parama.fJB(), parambv.field_content, parambv.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yRN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambv.field_msgSvrId, bu.aSt(parama));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((ar)parama.bh(ar.class)).b(paramMenuItem, parambv);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)ak.getContext().getSystemService("clipboard");
      parambv = parambv.field_transContent;
      if (!bu.isNullOrNil(parambv)) {
        paramMenuItem.setText(parambv);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(37016);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
          AppMethodBeat.o(37016);
          return true;
        }
        ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187777);
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oOD == 1)
    {
      paraml.a(i, 102, this.JWz.Kkd.getMMResources().getString(2131757218), 2131690381);
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(i, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType())) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((com.tencent.mm.app.plugin.c.Nb()) && ((!parambv.fvS()) || (!parambv.fwc()))) {
        paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      if (bn.z(parambv))
      {
        paraml.clear();
        if (!this.JWz.fJD()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
      }
    }
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187777);
      return true;
    }
    ae.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
    paraml.a(i, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(i, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.br.d.aJN("favorite")) {
      paraml.a(i, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Nb())
    {
      if ((parambv.fvS()) && (parambv.fwc())) {
        paraml.a(i, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambv.fwf()) {
        paraml.a(i, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(187777);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(37017);
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bk)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).fXo();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dCi.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kk(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.b
 * JD-Core Version:    0.7.0.1
 */