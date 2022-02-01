package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.HashMap;
import java.util.Map;

public class ax$a
  extends c
  implements NeatTextView.b
{
  private static final int Kyw = 2131305626;
  private static final int Kyx = 2131298134;
  private static final int Kyy = 2131298133;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private CharSequence JZt;
  private ax.e KCi;
  private int KuT = -1;
  private int gqW = -1;
  
  private String cw(bv parambv)
  {
    AppMethodBeat.i(37397);
    if (parambv != null)
    {
      String str = z.Br(parambv.field_msgSvrId);
      z.b localb = z.aBG().F(str, true);
      localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
      localb.k("preUsername", b(this.JWz, parambv));
      localb.k("preChatName", c(this.JWz, parambv));
      AppMethodBeat.o(37397);
      return str;
    }
    AppMethodBeat.o(37397);
    return null;
  }
  
  private ax.e fLL()
  {
    AppMethodBeat.i(37393);
    if (this.KCi == null) {
      this.KCi = new ax.e(this.JWz);
    }
    ax.e locale = this.KCi;
    AppMethodBeat.o(37393);
    return locale;
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37394);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493430);
      ((View)localObject).setTag(new ax.f().E((View)localObject, true));
    }
    AppMethodBeat.o(37394);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
  {
    AppMethodBeat.i(37396);
    this.JWz = parama1;
    final ax.f localf = (ax.f)parama;
    Object localObject2 = parambv.field_content;
    paramString = parama1.getTalkerUserName();
    localf.KCm.setTag(Kyx, Long.valueOf(parambv.field_msgId));
    localf.KCm.setTag(Kyy, Boolean.TRUE);
    parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
    localf.KCm.setTag(parama);
    Object localObject1 = ChattingItemTranslate.b.KCw;
    if (com.tencent.mm.app.plugin.c.Nb()) {
      if ((parambv.fvS()) && (parambv.fwc()))
      {
        parama = parambv.field_transContent;
        localObject1 = ((ar)parama1.bh(ar.class)).bT(parambv);
      }
    }
    for (;;)
    {
      int i;
      Object localObject3;
      if ((parama1.fJC()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()))
      {
        i = bl.BJ((String)localObject2);
        if (i != -1)
        {
          localObject3 = ((String)localObject2).substring(0, i).trim();
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            paramString = (String)localObject3;
            localObject2 = ((String)localObject2).substring(i + 1).trim();
            if (!bu.isNullOrNil(parama))
            {
              localObject3 = parama.substring(i + 1).trim();
              parama = paramString;
              paramString = (String)localObject3;
            }
          }
        }
      }
      for (;;)
      {
        a(localf, parama1, parambv, parama);
        a(localf, parama1, parama, parambv);
        Bundle localBundle;
        int j;
        if ((parambv.eNd != null) && (parambv.fwp()))
        {
          i = 1;
          localBundle = new Bundle();
          localBundle.putLong("msgSvrId", parambv.field_msgSvrId);
          j = 1;
          if (i != 0) {
            break label1139;
          }
          if (!an.aUq(parama)) {
            break label1092;
          }
          parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), (CharSequence)localObject2, (int)localf.KCm.getTextSize(), localBundle, cw(parambv));
          label352:
          localObject2 = (aj)parama1.bh(aj.class);
          if (!((aj)localObject2).Ew(parambv.field_msgId)) {
            break label1705;
          }
          localObject2 = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, ((aj)localObject2).fIK(), e.a.tFp, b.b.tIS));
          localf.KCm.a(((com.tencent.mm.plugin.fts.a.a.f)localObject2).tFv, TextView.BufferType.SPANNABLE);
        }
        label1284:
        label1696:
        label1705:
        for (i = 0;; i = 1)
        {
          localObject2 = (o[])parama.getSpans(0, parama.length(), o.class);
          int k = localObject2.length;
          j = 0;
          label445:
          if (j < k) {
            if (localObject2[j].getType() == 44) {
              com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(7), "" });
            }
          }
          for (;;)
          {
            label492:
            if (i != 0) {
              ax.a(localf.KCm.getContext(), parama1, parambv.field_content, parama, localf.KCm, parambv, 1);
            }
            if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv))
            {
              localf.rLB.setText(parama1.Kkd.getMMResources().getString(2131760106));
              localf.rLB.setVisibility(0);
              localf.rLB.setOnClickListener(new ax.a.1(this, localf, parama1));
            }
            for (;;)
            {
              ax.a(parambv, localf, parama1);
              localObject2 = localf.KCm.getContext();
              localf.KCm.setTag(Kyw, Boolean.TRUE);
              if (localf.JZs == null)
              {
                localf.JZs = new com.tencent.mm.ui.widget.b.a((Context)localObject2, localf.KCm);
                localf.JZs.LhV = new PopupWindow.OnDismissListener()
                {
                  public final void onDismiss()
                  {
                    AppMethodBeat.i(180024);
                    parama1.setFocused(true);
                    c.a(localf.JZs, parama1, ax.a.a(ax.a.this), ax.a.b(ax.a.this), 1);
                    ax.a.a(ax.a.this, -1);
                    ax.a.b(ax.a.this, -1);
                    AppMethodBeat.o(180024);
                  }
                };
                localf.JZs.LwJ = true;
                localf.JZs.LwM = false;
                localf.JZs.LwH = new ax.a.3(this, (Context)localObject2, localf, parama1, parambv);
                localf.JZs.LfT = new n.e()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(180028);
                    ax.a.b(ax.a.this, paramAnonymousMenuItem.getItemId());
                    ax.a.a(ax.a.this, paramAnonymousInt);
                    switch (paramAnonymousMenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(180028);
                      return;
                      ((android.content.ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(ax.a.c(ax.a.this), ax.a.c(ax.a.this)));
                      if (localf.Kyr != null)
                      {
                        localf.Kyr.fRO();
                        localf.Kyr.LCs = true;
                        localf.Kyr.LCt = true;
                        localf.Kyr.fRN();
                      }
                      Toast.makeText(this.val$context, 2131755702, 0).show();
                      Object localObject1;
                      Object localObject2;
                      try
                      {
                        paramAnonymousMenuItem = (bk)localf.KCm.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          localObject1 = ((ar)parama1.bh(ar.class)).f(paramAnonymousMenuItem.dCi, false);
                          localObject2 = new es();
                          ((es)localObject2).ejX = paramAnonymousMenuItem.dCi.field_msgSvrId;
                          ((es)localObject2).ejZ = ((String)localObject1).length();
                          ((es)localObject2).ejY = ax.a.c(ax.a.this).length();
                          ((es)localObject2).eka = bn.F(paramAnonymousMenuItem.dCi);
                          ((es)localObject2).aLH();
                          ax.c(paramAnonymousMenuItem.dCi, 3, ax.a.c(ax.a.this).length());
                        }
                        AppMethodBeat.o(180028);
                        return;
                      }
                      catch (Exception paramAnonymousMenuItem)
                      {
                        ae.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                        AppMethodBeat.o(180028);
                        return;
                      }
                      if (localf.Kyr != null)
                      {
                        if (localf.Kyr.LCd != null) {
                          localf.Kyr.LCd.fLD();
                        }
                        localf.Kyr.LCs = true;
                        localf.Kyr.fRN();
                        localf.Kyr.kw(0, localf.KCm.fXo().length());
                        localf.Kyr.fRQ();
                        localf.Kyr.fRT();
                        if (localf.Kyr.LCd != null)
                        {
                          localf.Kyr.LCd.fLE();
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = (bk)localf.KCm.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            ax.c(paramAnonymousMenuItem.dCi, 4, 0);
                            paramAnonymousMenuItem = bn.E(paramAnonymousMenuItem.dCi);
                            if (bu.isNullOrNil(paramAnonymousMenuItem))
                            {
                              localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject1).putExtra("Retr_Msg_content", ax.a.c(ax.a.this));
                              ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                              paramAnonymousMenuItem = this.val$context;
                              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(180028);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                            com.tencent.mm.ui.base.h.a(this.val$context, 2131762971, 2131762972, 2131755928, 2131757288, true, new ax.a.4.1(this, paramAnonymousMenuItem), new ax.a.4.2(this, paramAnonymousMenuItem));
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = new cw();
                            com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, ax.a.c(ax.a.this).toString(), 1);
                            paramAnonymousMenuItem.doL.fragment = ax.a.d(ax.a.this).Kkd;
                            paramAnonymousMenuItem.doL.doR = 43;
                            if (paramAnonymousMenuItem.doL.doN != null)
                            {
                              localObject1 = paramAnonymousMenuItem.doL.doN.GCe;
                              if (localObject1 != null)
                              {
                                localObject2 = (bk)localf.KCm.getTag();
                                if (localObject2 != null)
                                {
                                  ax.c(((bk)localObject2).dCi, 5, 0);
                                  ((akt)localObject1).aQC(((bk)localObject2).dCi.field_talker);
                                  ((akt)localObject1).aQD(com.tencent.mm.model.v.aAC());
                                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                                }
                              }
                            }
                            if (localf.Kyr != null)
                            {
                              localf.Kyr.fRO();
                              localf.Kyr.LCs = true;
                              localf.Kyr.LCt = true;
                              localf.Kyr.fRN();
                              AppMethodBeat.o(180028);
                              return;
                              paramAnonymousMenuItem = "65_" + ch.aDc();
                              localObject1 = ax.a.c(ax.a.this).toString();
                              boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                              ax.a.this.a(parama1, parambv, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
                              localObject2 = new HashMap();
                              ((HashMap)localObject2).put("parentSearchID", "");
                              ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.val$context, 65, (String)localObject1, paramAnonymousMenuItem, (Map)localObject2);
                            }
                          }
                        }
                      }
                    }
                  }
                };
              }
              ax.a(parama1, bn.G(parambv), parama, localf.KCm);
              if ((!bn.z(parambv)) && (!bn.A(parambv))) {
                break label1354;
              }
              localf.KCm.setTag(Kyw, Boolean.FALSE);
              localf.KCm.setOnTouchListener(localf.Kys);
              localf.KCm.setOnLongClickListener(c(parama1));
              localf.KCm.setOnClickListener(fLL());
              localf.KCm.setOnDoubleClickListener(this);
              localf.KCm.setTextListener(new MMNeat7extView.a()
              {
                public final void an(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180031);
                  if (((Boolean)localf.KCm.getTag(ax.a.dvC())).booleanValue())
                  {
                    com.tencent.mm.ui.chatting.m.a.a.fLp();
                    com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)localf.KCm.getTag(ax.a.aNR())).longValue());
                  }
                  AppMethodBeat.o(180031);
                }
              });
              if ((bu.isNullOrNil(paramString)) && (localObject1 == ChattingItemTranslate.b.KCw)) {
                break label1666;
              }
              if (localf.Kyv == null)
              {
                localf.Kyv = ((ChattingItemTranslate)localf.Kyu.inflate());
                localf.Kyv.init();
              }
              parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), paramString, (int)localf.KCm.getTextSize(), 1, null, cw(parambv));
              localf.Kyv.a(parama, (ChattingItemTranslate.b)localObject1);
              localObject1 = localf.Kyv;
              if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
                break label1657;
              }
              parama = parama1.Kkd.getMMResources().getString(2131764409);
              label954:
              ((ChattingItemTranslate)localObject1).setBrandWording(parama);
              if (!bu.isNullOrNil(paramString))
              {
                parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
                parama.KDT = false;
                parama.oOD = 2;
                localf.Kyv.setTag(parama);
                localf.Kyv.getContentView().setTag(parama);
                localf.Kyv.setOnClickListener(fLL());
                localf.Kyv.setOnDoubleClickListener(this);
                localf.Kyv.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
                localf.Kyv.setOnLongClickListener(c(parama1));
                localf.Kyv.setVisibility(0);
              }
              AppMethodBeat.o(37396);
              return;
              i = 0;
              break;
              label1092:
              parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), (CharSequence)localObject2, (int)localf.KCm.getTextSize(), 1, localBundle, cw(parambv));
              break label352;
              j += 1;
              break label445;
              break label492;
              label1139:
              if (i == 0) {
                break label1696;
              }
              if (parambv.eNd.contains("notify@all")) {}
              for (localObject3 = "";; localObject3 = localf.KCm.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
              {
                localBundle.putInt("geta8key_scene", 31);
                if (!an.aUq(parama)) {
                  break label1284;
                }
                parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), localObject3 + localObject2, (int)localf.KCm.getTextSize(), localBundle, cw(parambv));
                i = j;
                break;
              }
              parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), localObject3 + localObject2, (int)localf.KCm.getTextSize(), 1, localBundle, cw(parambv));
              i = j;
              break label492;
              localf.rLB.setVisibility(8);
            }
            label1354:
            j = bn.F(parambv);
            if ((j <= 0) || (j >= com.tencent.mm.ui.widget.textview.b.hm(localf.KCm).length())) {
              j = 0;
            }
            for (;;)
            {
              parama = c(parama1);
              localObject2 = a(parama);
              if (localf.Kyr != null) {
                localf.Kyr.destroy();
              }
              localObject3 = new int[2];
              i = 0;
              if (localf.KCm != null)
              {
                localf.KCm.getLocationOnScreen((int[])localObject3);
                k = localObject3[0];
                i = k;
                if (k == 0)
                {
                  localObject3 = new Rect();
                  localf.KCm.getGlobalVisibleRect((Rect)localObject3);
                  i = ((Rect)localObject3).left;
                }
              }
              for (;;)
              {
                localObject2 = new a.a(localf.KCm, localf.JZs, (a.f)localObject2, fLL(), localf.Kys);
                ((a.a)localObject2).LCj = 2131100846;
                ((a.a)localObject2).LCD = 18;
                ((a.a)localObject2).LCk = 2131100195;
                if (i != 0) {
                  ((a.a)localObject2).LCE = (aq.ay(localf.KCm.getContext(), 2131165289) + i);
                }
                localf.Kyr = ((a.a)localObject2).fRW();
                localf.Kyt = new ax.d(localf.Kyr);
                localf.Kyr.LCb = new com.tencent.mm.ui.base.v()
                {
                  public final void am(CharSequence paramAnonymousCharSequence)
                  {
                    AppMethodBeat.i(180029);
                    ax.a.a(ax.a.this, paramAnonymousCharSequence);
                    AppMethodBeat.o(180029);
                  }
                };
                localf.Kur = new a.f()
                {
                  public final void dismiss()
                  {
                    AppMethodBeat.i(180030);
                    localf.Kyr.fRO();
                    localf.Kyr.LCs = true;
                    localf.Kyr.LCt = true;
                    localf.Kyr.fRN();
                    AppMethodBeat.o(180030);
                  }
                };
                parama.Kur = localf.Kur;
                localf.Kyr.LCo = j;
                localf.Kyr.LCz = localf.Kyt;
                break;
                label1657:
                parama = parambv.field_transBrandWording;
                break label954;
                if (localf.Kyv != null) {
                  localf.Kyv.setVisibility(8);
                }
                AppMethodBeat.o(37396);
                return;
              }
            }
            parama = null;
            i = j;
          }
        }
        label1666:
        localObject3 = parama;
        parama = paramString;
        paramString = (String)localObject3;
        continue;
        break;
        localObject3 = parama;
        parama = paramString;
        paramString = (String)localObject3;
      }
      parama = null;
      break;
      parama = null;
    }
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    AppMethodBeat.i(37399);
    if (parambk == null)
    {
      AppMethodBeat.o(37399);
      return false;
    }
    bv localbv = parambk.dCi;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37399);
      return false;
    case 141: 
      parambk = localbv.field_transContent;
      paramMenuItem = parambk;
      if (parama.fJC())
      {
        paramMenuItem = parambk;
        if (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ())
        {
          i = bl.BJ(parambk);
          paramMenuItem = parambk;
          if (i != -1) {
            paramMenuItem = parambk.substring(i + 1).trim();
          }
        }
      }
      parambk = (android.text.ClipboardManager)ak.getContext().getSystemService("clipboard");
      if (!bu.isNullOrNil(paramMenuItem)) {
        parambk.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(37399);
      return true;
    case 142: 
      parambk = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem = localbv.field_transContent;
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
      if (localbv.fvz())
      {
        parambk.putExtra("Retr_Msg_content", paramMenuItem);
        parambk.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(parambk);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37399);
        return true;
        parambk.putExtra("Retr_Msg_content", paramMenuItem);
        parambk.putExtra("Retr_Msg_Type", 4);
      }
      Object localObject2 = new cw();
      Object localObject1 = localbv.field_transContent;
      if ((parama.fJC()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()))
      {
        i = bl.BJ((String)localObject1);
        if (i != -1) {
          localObject1 = ((String)localObject1).substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cw)localObject2, (String)localObject1, 1);
        ((cw)localObject2).doL.fragment = parama.Kkd;
        ((cw)localObject2).doL.doR = 43;
        if (((cw)localObject2).doL.doN != null)
        {
          localObject1 = ((cw)localObject2).doL.doN.GCe;
          if (localObject1 != null)
          {
            ((akt)localObject1).aQC(localbv.field_talker);
            ((akt)localObject1).aQD(com.tencent.mm.model.v.aAC());
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          localObject2 = (android.content.ClipboardManager)ak.getContext().getSystemService("clipboard");
          localObject1 = ((ar)parama.bh(ar.class)).f(((ChattingItemTranslate.a)parambk).dCi, false);
          paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
          if (localObject1 != null) {
            break label853;
          }
          i = 0;
          label657:
          ae.d("MicroMsg.ChattingItemTextFrom", i);
        }
        for (;;)
        {
          try
          {
            if ((bn.G(localbv) < 2) || (bu.ah(((ChattingItemTranslate.a)parambk).KCv))) {
              break label1200;
            }
            paramMenuItem = ((ChattingItemTranslate.a)parambk).KCv;
          }
          catch (Exception paramMenuItem)
          {
            for (;;)
            {
              try
              {
                ((android.content.ClipboardManager)localObject2).setText(paramMenuItem);
                ax.c(localbv, 3, paramMenuItem.length());
                com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
                parama = com.tencent.mm.plugin.secinforeport.a.a.yRN;
                com.tencent.mm.plugin.secinforeport.a.a.o(1, localbv.field_msgSvrId, bu.aSt(paramMenuItem.toString()));
              }
              catch (Exception parambk)
              {
                label853:
                continue;
              }
              try
              {
                parama = new es();
                parama.ejX = localbv.field_msgSvrId;
                parama.ejZ = paramMenuItem.length();
                parama.ejY = this.JZt.length();
                parama.eka = bn.F(localbv);
                parama.aLH();
                AppMethodBeat.o(37399);
                return true;
                ae.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                break;
                i = ((CharSequence)localObject1).length();
                break label657;
                paramMenuItem = paramMenuItem;
                paramMenuItem = (MenuItem)localObject1;
                ae.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
              }
              catch (Exception paramMenuItem)
              {
                ae.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
              }
            }
          }
          ax.c(localbv, 4, 0);
          paramMenuItem = bn.E(localbv);
          if (bu.isNullOrNil(paramMenuItem))
          {
            paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
            parambk = ((ar)parama.bh(ar.class)).f(localbv, false);
            if (localbv.fvz())
            {
              paramMenuItem.putExtra("Retr_Msg_content", parambk);
              paramMenuItem.putExtra("Retr_Msg_Type", 6);
            }
            for (;;)
            {
              paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramMenuItem.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              paramMenuItem.putExtra("Retr_Msg_content", parambk);
              paramMenuItem.putExtra("Retr_Msg_Type", 4);
            }
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new ax.a.8(this, paramMenuItem, parama), new ax.a.9(this, parama, localbv, paramMenuItem));
          break;
          ((ar)parama.bh(ar.class)).b(paramMenuItem, localbv);
          break;
          s.a(parama, localbv.field_msgId, 2);
          AppMethodBeat.o(37399);
          return false;
          label1200:
          paramMenuItem = (MenuItem)localObject1;
        }
      }
    }
  }
  
  public boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187888);
    if ((!parambv.isText()) && (!parambv.fvz()))
    {
      AppMethodBeat.o(187888);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oOD == 1)
    {
      if (parambv.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv)) {
          paraml.a(i, 151, this.JWz.Kkd.getMMResources().getString(2131760101), 2131691573);
        }
        if (!bn.A(parambv)) {
          paraml.a(i, 102, paramView.getContext().getString(2131757218), 2131690381);
        }
      }
      if (!bn.A(parambv)) {
        paraml.a(i, 108, paramView.getContext().getString(2131762559), 2131690478);
      }
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType())) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((parambv.isText()) && (com.tencent.mm.al.g.aFP())) {
        this.JWz.fJD();
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
      if ((com.tencent.mm.app.plugin.c.Nb()) && ((!parambv.fvS()) || (!parambv.fwc()))) {
        paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if ((bn.z(parambv)) || (bn.G(parambv) == 4))
      {
        paraml.clear();
        if (!this.JWz.fJD()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
      }
    }
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187888);
      return true;
    }
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
    AppMethodBeat.o(187888);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37400);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.m.a.a.fLp();
      com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parambv);
    }
    AppMethodBeat.o(37400);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37395);
    boolean bool = parama.fJC();
    AppMethodBeat.o(37395);
    return bool;
  }
  
  public boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  protected boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(37401);
    if (r.gA(paramView))
    {
      ae.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37401);
      return true;
    }
    Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject2).addFlags(67108864);
    ChattingItemTranslate.a locala;
    if ((paramView.getTag() instanceof ChattingItemTranslate.a))
    {
      locala = (ChattingItemTranslate.a)paramView.getTag();
      ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dCi.field_msgId);
      if (((com.tencent.mm.ui.chatting.d.b.v)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.v.class)).bN(locala.dCi))
      {
        localObject1 = ((MMNeat7extView)paramView).fXo().toString();
        ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kk(paramView.getContext());
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(locala.dCi.field_talker);
      }
    }
    else
    {
      AppMethodBeat.o(37401);
      return true;
    }
    Object localObject1 = (ar)this.JWz.bh(ar.class);
    bv localbv = locala.dCi;
    if (locala.oOD == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((ar)localObject1).f(localbv, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.a
 * JD-Core Version:    0.7.0.1
 */