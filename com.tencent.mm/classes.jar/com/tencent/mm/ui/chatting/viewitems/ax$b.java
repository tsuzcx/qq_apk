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
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
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
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.HashMap;
import java.util.Map;

public class ax$b
  extends c
  implements t.n, NeatTextView.b
{
  private static final int Kyw = 2131305626;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private CharSequence JZt;
  private ax.e KCi;
  private int KuT = -1;
  private int gqW = -1;
  
  private void bv(bv parambv)
  {
    AppMethodBeat.i(37411);
    if (!this.JWz.getTalkerUserName().equals("medianote"))
    {
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.f(parambv.field_talker, parambv.field_msgSvrId));
    }
    com.tencent.mm.ui.chatting.ak.bv(parambv);
    this.JWz.xY(true);
    AppMethodBeat.o(37411);
  }
  
  private String cw(bv parambv)
  {
    AppMethodBeat.i(37412);
    if (parambv != null)
    {
      String str = z.Br(parambv.field_msgSvrId);
      z.b localb = z.aBG().F(str, true);
      localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
      localb.k("preUsername", b(this.JWz, parambv));
      localb.k("preChatName", c(this.JWz, parambv));
      AppMethodBeat.o(37412);
      return str;
    }
    AppMethodBeat.o(37412);
    return null;
  }
  
  private ax.e fLL()
  {
    AppMethodBeat.i(37408);
    if (this.KCi == null) {
      this.KCi = new ax.e(this.JWz);
    }
    ax.e locale = this.KCi;
    AppMethodBeat.o(37408);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37409);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493475);
      ((View)localObject).setTag(new ax.f().E((View)localObject, false));
    }
    AppMethodBeat.o(37409);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37415);
    parambv.fvZ();
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    if ((parambv.isText()) && (parambv.field_isSend == 1)) {
      bv(parambv);
    }
    AppMethodBeat.o(37415);
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, final String paramString)
  {
    AppMethodBeat.i(37410);
    this.JWz = parama1;
    final ax.f localf = (ax.f)parama;
    localf.KCm.setTag(ax.access$000(), Long.valueOf(parambv.field_msgId));
    localf.KCm.setTag(ax.access$100(), Boolean.TRUE);
    localf.KCm.setMaxLines(2147483647);
    parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
    parama.KDT = false;
    localf.KCm.setTag(parama);
    label224:
    Object localObject;
    if (fLB())
    {
      b(localf, false);
      if ((parambv.field_status == 1) || (parambv.field_status == 5))
      {
        if (localf.KvW != null) {
          localf.KvW.setVisibility(8);
        }
        localf.KCm.setBackgroundResource(2131231726);
        parambv.JgO = true;
        paramString = parambv.field_content;
        if (bu.isNullOrNil(paramString)) {
          ae.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
        }
        if ((parambv.eNd == null) || (!parambv.fwp())) {
          break label1233;
        }
        i = 1;
        localObject = new Bundle();
        ((Bundle)localObject).putLong("msgSvrId", parambv.field_msgSvrId);
        if (i != 0) {
          break label1248;
        }
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), paramString, (int)localf.KCm.getTextSize(), 4, localObject, cw(parambv));
        parama = (aj)parama1.bh(aj.class);
        if (!parama.Ew(parambv.field_msgId)) {
          break label1745;
        }
        parama = com.tencent.mm.plugin.fts.a.f.a(e.a(paramString, parama.fIK(), e.a.tFp, b.b.tIT));
        localf.KCm.a(parama.tFv, TextView.BufferType.SPANNABLE);
      }
    }
    label809:
    label828:
    label1729:
    label1734:
    label1745:
    for (int i = 0;; i = 1)
    {
      localObject = (o[])paramString.getSpans(0, paramString.length(), o.class);
      int m = localObject.length;
      int j = 0;
      label375:
      int k = i;
      parama = paramString;
      if (j < m)
      {
        if (localObject[j].getType() == 44)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(6), "" });
          parama = paramString;
          k = i;
        }
      }
      else
      {
        if (k != 0) {
          ax.a(localf.KCm.getContext(), parama1, parambv.field_content, parama, localf.KCm, parambv, 4);
        }
        if (!com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv)) {
          break label1378;
        }
        localf.rLB.setText(parama1.Kkd.getMMResources().getString(2131760106));
        localf.rLB.setVisibility(0);
        localf.rLB.setOnClickListener(new ax.b.1(this, localf, parama1));
      }
      for (;;)
      {
        ax.a(parambv, localf, parama1);
        paramString = localf.KCm.getContext();
        localf.KCm.setTag(Kyw, Boolean.TRUE);
        if (localf.JZs == null)
        {
          localf.JZs = new com.tencent.mm.ui.widget.b.a(paramString, localf.KCm);
          localf.JZs.LhV = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180033);
              parama1.setFocused(true);
              c.a(localf.JZs, parama1, ax.b.a(ax.b.this), ax.b.b(ax.b.this), 1);
              ax.b.a(ax.b.this, -1);
              ax.b.b(ax.b.this, -1);
              AppMethodBeat.o(180033);
            }
          };
          localf.JZs.LwJ = true;
          localf.JZs.LwM = false;
          localf.JZs.LwH = new ax.b.3(this, paramString, localf, parama1, parambv);
          localf.JZs.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180035);
              ax.b.a(ax.b.this, paramAnonymousInt);
              ax.b.b(ax.b.this, paramAnonymousMenuItem.getItemId());
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180035);
                return;
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(ax.b.c(ax.b.this), ax.b.c(ax.b.this)));
                if (localf.Kyr != null)
                {
                  localf.Kyr.fRO();
                  localf.Kyr.LCs = true;
                  localf.Kyr.LCt = true;
                  localf.Kyr.fRN();
                }
                Toast.makeText(paramString, 2131755702, 0).show();
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
                    ((es)localObject2).ejY = ax.b.c(ax.b.this).length();
                    ((es)localObject2).eka = bn.F(paramAnonymousMenuItem.dCi);
                    ((es)localObject2).aLH();
                    ax.c(paramAnonymousMenuItem.dCi, 3, ax.b.c(ax.b.this).length());
                  }
                  AppMethodBeat.o(180035);
                  return;
                }
                catch (Exception paramAnonymousMenuItem)
                {
                  ae.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                  AppMethodBeat.o(180035);
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
                    AppMethodBeat.o(180035);
                    return;
                    ax.c(parambv, 4, 0);
                    localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", ax.b.c(ax.b.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180035);
                    return;
                    ax.c(parambv, 5, 0);
                    paramAnonymousMenuItem = new cw();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, ax.b.c(ax.b.this).toString(), 1);
                    paramAnonymousMenuItem.doL.fragment = ax.b.d(ax.b.this).Kkd;
                    paramAnonymousMenuItem.doL.doR = 43;
                    if (paramAnonymousMenuItem.doL.doN != null)
                    {
                      localObject1 = paramAnonymousMenuItem.doL.doN.GCe;
                      if (localObject1 != null)
                      {
                        localObject2 = (bk)localf.KCm.getTag();
                        if (localObject2 != null)
                        {
                          ((akt)localObject1).aQC(com.tencent.mm.model.v.aAC());
                          ((akt)localObject1).aQD(((bk)localObject2).dCi.field_talker);
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
                      AppMethodBeat.o(180035);
                      return;
                      paramAnonymousMenuItem = "65_" + ch.aDc();
                      localObject1 = ax.b.c(ax.b.this).toString();
                      boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                      ax.b.this.a(parama1, parambv, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
                      localObject2 = new HashMap();
                      ((HashMap)localObject2).put("parentSearchID", "");
                      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(paramString, 65, (String)localObject1, paramAnonymousMenuItem, (Map)localObject2);
                    }
                  }
                }
              }
            }
          };
        }
        ax.a(parama1, bn.G(parambv), parama, localf.KCm);
        if ((!bn.z(parambv)) && (!bn.A(parambv))) {
          break label1391;
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
            AppMethodBeat.i(180038);
            if (((Boolean)localf.KCm.getTag(ax.access$100())).booleanValue())
            {
              com.tencent.mm.ui.chatting.m.a.a.fLp();
              com.tencent.mm.ui.chatting.m.a.a.fLq().a(paramAnonymousCharSequence, ((Long)localf.KCm.getTag(ax.access$000())).longValue());
            }
            AppMethodBeat.o(180038);
          }
        });
        paramString = ChattingItemTranslate.b.KCw;
        if (!com.tencent.mm.app.plugin.c.Nb()) {
          break label1734;
        }
        if ((!parambv.fvS()) || (!parambv.fwc())) {
          break label1729;
        }
        parama = parambv.field_transContent;
        paramString = ((ar)parama1.bh(ar.class)).bT(parambv);
        if ((bu.isNullOrNil(parama)) && (paramString == ChattingItemTranslate.b.KCw)) {
          break label1708;
        }
        if (localf.Kyv == null)
        {
          localf.Kyv = ((ChattingItemTranslate)localf.Kyu.inflate());
          localf.Kyv.init();
        }
        localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), parama, (int)localf.KCm.getTextSize(), 1, null, cw(parambv));
        localf.Kyv.a((CharSequence)localObject, paramString);
        localObject = localf.Kyv;
        if (!bu.isNullOrNil(parambv.field_transBrandWording)) {
          break label1698;
        }
        paramString = parama1.Kkd.getMMResources().getString(2131764409);
        ((ChattingItemTranslate)localObject).setBrandWording(paramString);
        if (!bu.isNullOrNil(parama))
        {
          parama = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
          parama.oOD = 2;
          localf.Kyv.setTag(parama);
          localf.Kyv.getContentView().setTag(parama);
          localf.Kyv.setOnClickListener(fLL());
          localf.Kyv.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          localf.Kyv.setOnDoubleClickListener(this);
          localf.Kyv.setOnLongClickListener(c(parama1));
          localf.Kyv.setVisibility(0);
        }
        a(paramInt, localf, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(37410);
        return;
        localf.KCm.setBackgroundResource(2131231725);
        if (localf.KvW == null) {
          break;
        }
        if (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))
        {
          if (parambv.JgO)
          {
            parama = new AlphaAnimation(0.5F, 1.0F);
            parama.setDuration(300L);
            localf.KCm.startAnimation(parama);
            parambv.JgO = false;
          }
          localf.KvW.setVisibility(0);
          break;
        }
        localf.KvW.setVisibility(8);
        break;
        if (parambv.field_status < 2) {}
        for (boolean bool = true;; bool = false)
        {
          b(localf, bool);
          break;
        }
        label1233:
        i = 0;
        break label224;
        j += 1;
        break label375;
        label1248:
        if (parambv.eNd.contains("notify@all")) {}
        for (parama = "";; parama = localf.KCm.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
        {
          ((Bundle)localObject).putInt("geta8key_scene", 31);
          parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KCm.getContext(), parama + paramString, (int)localf.KCm.getTextSize(), 4, localObject, cw(parambv));
          k = 1;
          break;
        }
        label1378:
        localf.rLB.setVisibility(8);
      }
      label1391:
      j = bn.F(parambv);
      if ((j <= 0) || (j >= com.tencent.mm.ui.widget.textview.b.hm(localf.KCm).length())) {
        j = 0;
      }
      for (;;)
      {
        if (localf.Kyr != null) {
          localf.Kyr.destroy();
        }
        parama = c(parama1);
        paramString = a(c(parama1));
        localObject = new int[2];
        i = 0;
        if (localf.KCm != null)
        {
          localf.KCm.getLocationOnScreen((int[])localObject);
          k = localObject[0];
          i = k;
          if (k == 0)
          {
            localObject = new Rect();
            localf.KCm.getGlobalVisibleRect((Rect)localObject);
            i = ((Rect)localObject).left;
          }
        }
        for (;;)
        {
          paramString = new a.a(localf.KCm, localf.JZs, paramString, fLL(), localf.Kys);
          paramString.LCj = 2131100135;
          paramString.LCD = 18;
          paramString.LCk = 2131100133;
          if (i != 0) {
            paramString.LCE = (aq.ay(localf.KCm.getContext(), 2131165284) + i);
          }
          localf.Kyr = paramString.fRW();
          localf.Kyt = new ax.d(localf.Kyr);
          localf.Kyr.LCb = new com.tencent.mm.ui.base.v()
          {
            public final void am(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180036);
              ax.b.a(ax.b.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180036);
            }
          };
          localf.Kur = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180037);
              localf.Kyr.fRO();
              localf.Kyr.LCs = true;
              localf.Kyr.LCt = true;
              localf.Kyr.fRN();
              AppMethodBeat.o(180037);
            }
          };
          localf.Kyr.LCo = j;
          parama.Kur = localf.Kur;
          localf.Kyr.LCz = localf.Kyt;
          break;
          paramString = parambv.field_transBrandWording;
          break label951;
          if (localf.Kyv == null) {
            break label1072;
          }
          localf.Kyv.setVisibility(8);
          break label1072;
          parama = null;
          break label809;
          parama = null;
          break label828;
        }
      }
    }
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    AppMethodBeat.i(37414);
    if (parambk == null)
    {
      AppMethodBeat.o(37414);
      return false;
    }
    bv localbv = parambk.dCi;
    Object localObject1;
    Object localObject2;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37414);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard");
      parambk = localbv.field_transContent;
      if (!bu.isNullOrNil(parambk)) {
        paramMenuItem.setText(parambk);
      }
      com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
      AppMethodBeat.o(37414);
      return true;
    case 142: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      parambk = localbv.field_transContent;
      if (localbv.fvz())
      {
        paramMenuItem.putExtra("Retr_Msg_content", parambk);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37414);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", parambk);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
    case 143: 
      localObject1 = new cw();
      com.tencent.mm.pluginsdk.model.g.b((cw)localObject1, localbv.field_transContent, 1);
      ((cw)localObject1).doL.fragment = parama.Kkd;
      ((cw)localObject1).doL.doR = 43;
      if (((cw)localObject1).doL.doN != null)
      {
        localObject2 = ((cw)localObject1).doL.doN.GCe;
        if (localObject2 != null)
        {
          ((akt)localObject2).aQC(localbv.field_talker);
          ((akt)localObject2).aQD(com.tencent.mm.model.v.aAC());
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      break;
    case 102: 
      localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard");
      localObject1 = ((ar)parama.bh(ar.class)).f(((ChattingItemTranslate.a)parambk).dCi, false);
      paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
      if (localObject1 == null)
      {
        i = 0;
        label509:
        ae.d("MicroMsg.ChattingItemTextTo", i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        if ((bn.G(localbv) < 2) || (bu.ah(((ChattingItemTranslate.a)parambk).KCv))) {
          break label980;
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
            localObject1 = com.tencent.mm.plugin.secinforeport.a.a.yRN;
            com.tencent.mm.plugin.secinforeport.a.a.o(1, localbv.field_msgSvrId, bu.aSt(paramMenuItem.toString()));
            ax.c(parambk.dCi, 3, paramMenuItem.length());
          }
          catch (Exception parambk)
          {
            continue;
          }
          try
          {
            parambk = new es();
            parambk.ejX = localbv.field_msgSvrId;
            parambk.ejZ = paramMenuItem.length();
            parambk.ejY = this.JZt.length();
            parambk.eka = bn.F(localbv);
            parambk.aLH();
            com.tencent.mm.ui.base.h.cm(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131755702));
            AppMethodBeat.o(37414);
            return true;
            ae.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
            break;
            i = ((CharSequence)localObject1).length();
            break label509;
            paramMenuItem = paramMenuItem;
            paramMenuItem = (MenuItem)localObject1;
            ae.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
          }
          catch (Exception paramMenuItem)
          {
            ae.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
          }
        }
      }
      ax.c(localbv, 4, 0);
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        paramMenuItem.putExtra("Retr_Msg_content", parambk);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      bv(localbv);
      break;
      ((ar)parama.bh(ar.class)).b(paramMenuItem, localbv);
      break;
      s.a(parama, localbv.field_msgId, 2);
      AppMethodBeat.o(37414);
      return false;
      label980:
      paramMenuItem = (MenuItem)localObject1;
    }
  }
  
  public boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187890);
    if ((parambv.eNd != null) && (parambv.eNd.contains("announcement@all"))) {}
    for (int i = 1; (!parambv.isText()) && (!parambv.fvz()); i = 0)
    {
      AppMethodBeat.o(187890);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int j = locala.position;
    if (locala.oOD == 1)
    {
      if (parambv.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.an(parambv)) {
          paraml.a(j, 151, this.JWz.Kkd.getMMResources().getString(2131760101), 2131691573);
        }
        if (!bn.A(parambv)) {
          paraml.a(j, 102, paramView.getContext().getString(2131757218), 2131690381);
        }
      }
      if (!bn.A(parambv)) {
        paraml.a(j, 108, paramView.getContext().getString(2131762559), 2131690478);
      }
      if (parambv.field_status == 5) {
        paraml.a(j, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(j, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType())) {
        paraml.a(j, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((i == 0) && (!parambv.fta()) && (parambv.isText()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
        paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if ((com.tencent.mm.app.plugin.c.Nb()) && ((!parambv.fvS()) || (!parambv.fwc()))) {
        paraml.a(j, 124, paramView.getContext().getString(2131757242), 2131690491);
      }
      if ((parambv.isText()) && (com.tencent.mm.al.g.aFP())) {
        this.JWz.fJD();
      }
      if (!this.JWz.fJD()) {
        paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
      if ((bn.z(parambv)) || (bn.G(parambv) == 4))
      {
        paraml.clear();
        if (!this.JWz.fJD()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
      }
    }
    while (locala.oOD != 2)
    {
      AppMethodBeat.o(187890);
      return true;
    }
    paraml.a(j, 141, paramView.getContext().getString(2131757218), 2131690381);
    paraml.a(j, 142, paramView.getContext().getString(2131762559), 2131690478);
    if (com.tencent.mm.br.d.aJN("favorite")) {
      paraml.a(j, 143, paramView.getContext().getString(2131761941), 2131690400);
    }
    if (com.tencent.mm.app.plugin.c.Nb())
    {
      if ((parambv.fvS()) && (parambv.fwc())) {
        paraml.a(j, 124, paramView.getContext().getString(2131757240), 2131690398);
      }
      if (parambv.fwf()) {
        paraml.a(j, 125, paramView.getContext().getString(2131757233), 2131690467);
      }
    }
    AppMethodBeat.o(187890);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean fLz()
  {
    return true;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(37416);
    if (r.gA(paramView))
    {
      ae.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37416);
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
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(locala.dCi.field_talker);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kk(paramView.getContext());
      }
    }
    else
    {
      AppMethodBeat.o(37416);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.b
 * JD-Core Version:    0.7.0.1
 */