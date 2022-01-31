package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class am$a
  extends c
  implements NeatTextView.b
{
  private static final int zWV = 2131820672;
  private static final int zWW = 2131820584;
  private static final int zWX = 2131820583;
  private CharSequence zCy;
  private am.e zWY;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private String bL(bi parambi)
  {
    AppMethodBeat.i(33299);
    if (parambi != null)
    {
      String str = v.oQ(parambi.field_msgSvrId);
      v.b localb = v.aae().z(str, true);
      localb.i("prePublishId", "msg_" + parambi.field_msgSvrId);
      localb.i("preUsername", b(this.zzP, parambi));
      localb.i("preChatName", c(this.zzP, parambi));
      AppMethodBeat.o(33299);
      return str;
    }
    AppMethodBeat.o(33299);
    return null;
  }
  
  private am.e dLt()
  {
    AppMethodBeat.i(33295);
    if (this.zWY == null) {
      this.zWY = new am.e(this.zzP);
    }
    am.e locale = this.zWY;
    AppMethodBeat.o(33295);
    return locale;
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33296);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969063);
      ((View)localObject).setTag(new am.f().A((View)localObject, true));
    }
    AppMethodBeat.o(33296);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33298);
    this.zzP = parama1;
    final am.f localf = (am.f)parama;
    Object localObject2 = parambi.field_content;
    paramString = parama1.getTalkerUserName();
    localf.zXe.setTag(zWW, Long.valueOf(parambi.field_msgId));
    localf.zXe.setTag(zWX, Boolean.TRUE);
    Object localObject1 = ChattingItemTranslate.b.zXu;
    if (com.tencent.mm.app.plugin.c.Cc()) {
      if ((parambi.dya()) && (parambi.dyh()))
      {
        parama = parambi.field_transContent;
        localObject1 = ((com.tencent.mm.ui.chatting.c.b.ah)parama1.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(parambi);
      }
    }
    for (;;)
    {
      int i;
      Object localObject3;
      if ((parama1.dJG()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama1.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()))
      {
        i = bf.pt((String)localObject2);
        if (i != -1)
        {
          localObject3 = ((String)localObject2).substring(0, i).trim();
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            paramString = (String)localObject3;
            localObject2 = ((String)localObject2).substring(i + 1).trim();
            if (!bo.isNullOrNil(parama)) {
              parama = parama.substring(i + 1).trim();
            }
          }
        }
      }
      for (;;)
      {
        a(localf, parama1, parambi, paramString);
        a(localf, parama1, paramString, parambi);
        if ((parambi.dns != null) && (parambi.dyq()))
        {
          i = 1;
          if (i != 0) {
            break label1234;
          }
          paramString = j.a(localf.zXe.getContext(), (CharSequence)localObject2, (int)localf.zXe.getTextSize(), 1, null, bL(parambi));
          localObject2 = (z)parama1.ay(z.class);
          if (!((z)localObject2).oD(parambi.field_msgId)) {
            break label1209;
          }
          localObject2 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(paramString, ((z)localObject2).dIV(), d.a.mSi, b.b.mVR));
          localf.zXe.a(((com.tencent.mm.plugin.fts.a.a.e)localObject2).mSp, TextView.BufferType.SPANNABLE);
          label357:
          paramString = (n[])paramString.getSpans(0, paramString.length(), n.class);
          int j = paramString.length;
          i = 0;
          label384:
          if (i < j)
          {
            if (paramString[i].getType() != 44) {
              break label1225;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(7), "" });
          }
          label431:
          paramString = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
          localf.zXg.setOnClickListener(new am.a.1(this, localf));
          localObject2 = localf.zXe.getContext();
          localf.zXe.setTag(zWV, Boolean.TRUE);
          if (localf.zCx == null)
          {
            localf.zCx = new com.tencent.mm.ui.widget.c.a((Context)localObject2, localf.zXe);
            localf.zCx.AIH = true;
            localf.zCx.AIG = new am.a.2(this, (Context)localObject2, localf);
            localf.zCx.sap = new am.a.3(this, localf, (Context)localObject2);
          }
          if (bh.o(parambi)) {
            break label1376;
          }
          i = bh.t(parambi);
          if ((i > 0) && (i < com.tencent.mm.ui.widget.textview.b.fz(localf.zXe).length())) {
            break label1465;
          }
          i = 0;
        }
        label781:
        label1465:
        for (;;)
        {
          localObject2 = c(parama1);
          localObject3 = a((c.c)localObject2);
          if (localf.zXj != null) {
            localf.zXj.destroy();
          }
          localObject3 = new a.a(localf.zXe, localf.zCx, (a.f)localObject3, dLt(), localf.zXk);
          ((a.a)localObject3).ANa = 2131690431;
          ((a.a)localObject3).ANu = 18;
          ((a.a)localObject3).ANb = 2131689914;
          localf.zXj = ((a.a)localObject3).dPX();
          localf.zXl = new am.d(localf.zXj);
          localf.zXj.AMS = new am.a.4(this);
          localf.zRm = new am.a.5(this, localf);
          ((c.c)localObject2).zRm = localf.zRm;
          localf.zXj.ANf = i;
          localf.zXj.ANq = localf.zXl;
          localf.zXe.setOnDoubleClickListener(this);
          localf.zXe.setTag(paramString);
          localf.zXe.setTag(zWW, Long.valueOf(parambi.field_msgId));
          localf.zXe.setTextListener(new MMNeat7extView.a()
          {
            public final void ae(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(33292);
              if (((Boolean)localf.zXe.getTag(am.a.bjJ())).booleanValue())
              {
                com.tencent.mm.ui.chatting.k.a.a.dLf();
                com.tencent.mm.ui.chatting.k.a.a.dLg().a(paramAnonymousCharSequence, ((Long)localf.zXe.getTag(am.a.cQS())).longValue());
              }
              AppMethodBeat.o(33292);
            }
          });
          localf.zXg.setVisibility(8);
          localf.zXf.setVisibility(8);
          localf.zXe.setMaxLines(2147483647);
          i = com.tencent.mm.m.g.Nq().getInt("InvalidateTextFoldLineNum", 5);
          if (bh.q(parambi))
          {
            paramString = localf.zXe.Sa(localf.zXe.getContext().getResources().getDimensionPixelSize(2131428227));
            if ((paramString != null) && (paramString.dTo() > i))
            {
              localf.zXe.setMaxLines(i);
              localf.zXg.setVisibility(0);
              localf.zXf.setVisibility(0);
            }
          }
          if ((!bo.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.b.zXu))
          {
            if (localf.zXi == null)
            {
              localf.zXi = ((ChattingItemTranslate)localf.zXh.inflate());
              localf.zXi.init();
            }
            paramString = j.a(localf.zXe.getContext(), parama, (int)localf.zXe.getTextSize(), 1, null, bL(parambi));
            localf.zXi.a(paramString, (ChattingItemTranslate.b)localObject1);
            localObject1 = localf.zXi;
            if (bo.isNullOrNil(parambi.field_transBrandWording)) {}
            for (paramString = parama1.zJz.getMMResources().getString(2131304283);; paramString = parambi.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
              if (!bo.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
                parama.zYK = false;
                parama.kwo = 2;
                localf.zXi.setTag(parama);
                localf.zXi.setOnClickListener(dLt());
                localf.zXi.setOnDoubleClickListener(this);
                localf.zXi.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
                localf.zXi.setOnLongClickListener(c(parama1));
                localf.zXi.setVisibility(0);
              }
              AppMethodBeat.o(33298);
              return;
              i = 0;
              break;
              label1209:
              localf.zXe.a(paramString, TextView.BufferType.SPANNABLE);
              break label357;
              label1225:
              i += 1;
              break label384;
              label1234:
              if (i == 0) {
                break label431;
              }
              if (parambi.dns.contains("notify@all")) {}
              for (paramString = "";; paramString = localf.zXe.getContext().getString(2131302746, new Object[] { "@" }) + "\n")
              {
                paramString = j.a(localf.zXe.getContext(), paramString + localObject2, (int)localf.zXe.getTextSize(), 1, Integer.valueOf(31), bL(parambi));
                localf.zXe.a(paramString, TextView.BufferType.SPANNABLE);
                break;
              }
              label1376:
              localf.zXe.setTag(zWV, Boolean.FALSE);
              localf.zXe.setOnTouchListener(localf.zXk);
              localf.zXe.setOnLongClickListener(c(parama1));
              localf.zXe.setOnClickListener(dLt());
              break label781;
            }
          }
          if (localf.zXi != null) {
            localf.zXi.setVisibility(8);
          }
          AppMethodBeat.o(33298);
          return;
        }
        continue;
        break;
      }
      parama = null;
      break;
      parama = null;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33300);
    if ((!parambi.isText()) && (!parambi.dxM()))
    {
      AppMethodBeat.o(33300);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.kwo == 1)
    {
      if (parambi.isText()) {
        paramContextMenu.add(i, 102, 0, paramView.getContext().getString(2131298229));
      }
      paramContextMenu.add(i, 108, 0, paramView.getContext().getString(2131302650));
      if (com.tencent.mm.bq.d.ahR("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
      }
      if (com.tencent.mm.pluginsdk.model.app.g.ag(this.zzP.zJz.getContext(), parambi.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
      }
      if ((parambi.isText()) && (com.tencent.mm.aj.f.aeO())) {
        this.zzP.dJH();
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
      }
      if (com.tencent.mm.app.plugin.c.Cc())
      {
        if ((parambi.dya()) && (parambi.dyh())) {
          paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131298249));
        }
      }
      else if (bh.o(parambi))
      {
        paramContextMenu.clear();
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
        }
      }
    }
    while (locala.kwo != 2) {
      for (;;)
      {
        AppMethodBeat.o(33300);
        return true;
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131298251));
      }
    }
    paramContextMenu.add(i, 141, 0, paramView.getContext().getString(2131298229));
    paramContextMenu.add(i, 142, 0, paramView.getContext().getString(2131302650));
    if (com.tencent.mm.bq.d.ahR("favorite")) {
      paramContextMenu.add(i, 143, 0, paramView.getContext().getString(2131302102));
    }
    if ((com.tencent.mm.app.plugin.c.Cd()) && (parambi.dyk())) {
      paramContextMenu.add(i, 125, 0, paramView.getContext().getString(2131298243));
    }
    AppMethodBeat.o(33300);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33301);
    int i;
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33301);
      return false;
    case 141: 
      parambi = parambi.field_transContent;
      paramMenuItem = parambi;
      if (parama.dJG())
      {
        paramMenuItem = parambi;
        if (!((com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv())
        {
          i = bf.pt(parambi);
          paramMenuItem = parambi;
          if (i != -1) {
            paramMenuItem = parambi.substring(i + 1).trim();
          }
        }
      }
      parambi = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
      if (!bo.isNullOrNil(paramMenuItem)) {
        parambi.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.bO(parama.zJz.getContext(), parama.zJz.getContext().getString(2131296896));
      AppMethodBeat.o(33301);
      return true;
    case 142: 
      localObject1 = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambi.field_transContent;
      if ((parama.dJG()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()))
      {
        i = bf.pt(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambi.dxM())
      {
        ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity((Intent)localObject1);
        AppMethodBeat.o(33301);
        return true;
        ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
      }
      Object localObject2 = new cm();
      localObject1 = parambi.field_transContent;
      if ((parama.dJG()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()))
      {
        i = bf.pt((String)localObject1);
        if (i != -1) {
          localObject1 = ((String)localObject1).substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.e.b((cm)localObject2, (String)localObject1, 1);
        ((cm)localObject2).cpR.fragment = parama.zJz;
        ((cm)localObject2).cpR.cpY = 43;
        if (((cm)localObject2).cpR.cpT != null)
        {
          localObject1 = ((cm)localObject2).cpR.cpT.wVa;
          if (localObject1 != null)
          {
            ((acw)localObject1).aon(parambi.field_talker);
            ((acw)localObject1).aoo(r.Zn());
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        for (;;)
        {
          localObject1 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
          localObject2 = parambi.field_content;
          paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
          if (localObject2 == null)
          {
            i = 0;
            ab.d("MicroMsg.ChattingItemTextFrom", i);
            paramMenuItem = ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bn(parambi);
          }
          try
          {
            ((android.content.ClipboardManager)localObject1).setText(paramMenuItem);
            com.tencent.mm.ui.base.h.bO(parama.zJz.getContext(), parama.zJz.getContext().getString(2131296896));
            parama = com.tencent.mm.plugin.secinforeport.a.a.qEl;
            com.tencent.mm.plugin.secinforeport.a.a.i(1, parambi.field_msgSvrId, bo.apL(paramMenuItem));
            AppMethodBeat.o(33301);
            return true;
            ab.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
            continue;
            i = ((String)localObject2).length();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
            }
          }
        }
        paramMenuItem = bh.s(parambi);
        if (bo.isNullOrNil(paramMenuItem))
        {
          paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
          String str = ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bn(parambi);
          if (parambi.dxM())
          {
            paramMenuItem.putExtra("Retr_Msg_content", str);
            paramMenuItem.putExtra("Retr_Msg_Type", 6);
          }
          for (;;)
          {
            parama.startActivity(paramMenuItem);
            break;
            paramMenuItem.putExtra("Retr_Msg_content", str);
            paramMenuItem.putExtra("Retr_Msg_Type", 4);
          }
        }
        com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), 2131303029, 2131303030, 2131297104, 2131298297, true, new am.a.7(this, paramMenuItem, parama), new am.a.8(this, parama, parambi, paramMenuItem));
        break;
        ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).b(paramMenuItem, parambi);
        break;
      }
    }
  }
  
  public boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33302);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.k.a.a.dLf();
      com.tencent.mm.ui.chatting.k.a.a.a(paramView.getText(), parambi);
    }
    AppMethodBeat.o(33302);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(33297);
    boolean bool = parama.dJG();
    AppMethodBeat.o(33297);
    return bool;
  }
  
  protected boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
  
  public final boolean fp(View paramView)
  {
    AppMethodBeat.i(33303);
    Intent localIntent = new Intent(paramView.getContext(), TextPreviewUI.class);
    localIntent.addFlags(67108864);
    az localaz = (az)paramView.getTag();
    if (localaz != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).dTB();
      localIntent.putExtra("Chat_Msg_Id", localaz.cEE.field_msgId);
      localIntent.putExtra("key_chat_text", localCharSequence);
      paramView.getContext().startActivity(localIntent);
      com.tencent.mm.ui.base.b.jdMethod_if(paramView.getContext());
    }
    AppMethodBeat.o(33303);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a
 * JD-Core Version:    0.7.0.1
 */