package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.bq;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.na;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.component.api.aa;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class bj$b
  extends c
  implements v.n, NeatTextView.b
{
  private static final int aeQy = R.h.fYD;
  private int aeMA = -1;
  private bj.e aeVG;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private void cs(cc paramcc)
  {
    AppMethodBeat.i(37411);
    if (!this.aeiK.getTalkerUserName().equals("medianote"))
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
    }
    an.cs(paramcc);
    this.aeiK.jpK();
    AppMethodBeat.o(37411);
  }
  
  private String dH(cc paramcc)
  {
    AppMethodBeat.i(37412);
    if (paramcc != null)
    {
      String str = ad.Jo(paramcc.field_msgSvrId);
      ad.b localb = ad.bCb().M(str, true);
      localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
      localb.q("preUsername", a(this.aeiK, paramcc));
      localb.q("preChatName", b(this.aeiK, paramcc));
      AppMethodBeat.o(37412);
      return str;
    }
    AppMethodBeat.o(37412);
    return null;
  }
  
  private bj.e jxz()
  {
    AppMethodBeat.i(37408);
    if (this.aeVG == null) {
      this.aeVG = new bj.e(this.aeiK);
    }
    bj.e locale = this.aeVG;
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
      localObject = new ap(paramLayoutInflater, R.i.ggw);
      ((View)localObject).setTag(new bj.f().P((View)localObject, false));
    }
    AppMethodBeat.o(37409);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(37410);
    this.aeiK = parama1;
    final bj.f localf = (bj.f)parama;
    localf.aeVM.setTag(bj.access$000(), Long.valueOf(paramcc.field_msgId));
    localf.aeVM.setTag(bj.access$100(), Boolean.TRUE);
    localf.aeVM.setMaxLines(2147483647);
    parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
    parama.aeXR = false;
    localf.aeVM.setTag(parama);
    Object localObject2;
    label231:
    Object localObject1;
    boolean bool1;
    if (jxj())
    {
      b(localf, false);
      if ((paramcc.field_status == 1) || (paramcc.field_status == 5))
      {
        if (localf.aeNG != null) {
          localf.aeNG.setVisibility(8);
        }
        localf.aeVM.setBackgroundResource(R.g.fnx);
        paramcc.adku = true;
        localObject2 = paramcc.field_content;
        if (Util.isNullOrNil((String)localObject2)) {
          Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
        }
        if ((paramcc.jUr == null) || ((!paramcc.jcr()) && (!paramcc.jcs()))) {
          break label1364;
        }
        i = 1;
        parama = com.tencent.mm.ui.chatting.i.a.aeJh;
        com.tencent.mm.ui.chatting.i.a.a.a(localf.aeVM, paramcc, parama1.juG(), paramString);
        parama = com.tencent.mm.pluginsdk.ui.span.x.aq(parama1.juG(), com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
        localObject1 = bj.dG(paramcc);
        ((Bundle)localObject1).putAll(parama);
        if (bt.U(paramcc)) {
          break label1370;
        }
        bool1 = true;
        label291:
        if (i != 0) {
          break label1385;
        }
        paramString = p.a(localf.aeVM.getContext(), (CharSequence)localObject2, (int)localf.aeVM.getTextSize(), 4, localObject1, dH(paramcc), 0, p.YoF, bool1);
        parama = (com.tencent.mm.ui.chatting.component.api.au)parama1.cm(com.tencent.mm.ui.chatting.component.api.au.class);
        if (!parama.zT(paramcc.field_msgId)) {
          break label1876;
        }
        parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.g.a(paramString, parama.jtt(), g.a.HsR, b.b.HwN));
        localf.aeVM.a(parama.HsX, TextView.BufferType.SPANNABLE);
      }
    }
    label940:
    label1082:
    label1866:
    label1871:
    label1876:
    for (int i = 0;; i = 1)
    {
      localObject2 = (t[])paramString.getSpans(0, paramString.length(), t.class);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        parama = new bq();
        parama.hBG.msgId = paramcc.field_msgId;
        parama.hBG.type = 1;
        parama.hBG.hBF = false;
        parama.publish();
      }
      int m = localObject2.length;
      int j = 0;
      label478:
      int k = i;
      parama = paramString;
      if (j < m)
      {
        if (localObject2[j].getType() == 44)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(6), "" });
          parama = paramString;
          k = i;
        }
      }
      else
      {
        if (k != 0) {
          bj.a(localf.aeVM.getContext(), parama1, paramcc.field_content, parama, localf.aeVM, paramcc, 4);
        }
        if (!com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
          break label1511;
        }
        localf.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gJj));
        localf.Aoo.setVisibility(0);
        localf.Aoo.setOnClickListener(new bj.b.1(this, localf, parama1));
        label627:
        bj.a(paramcc, localf, parama1);
        paramString = localf.aeVM.getContext();
        localf.aeVM.setTag(aeQy, Boolean.TRUE);
        if (localf.GAa == null)
        {
          localf.GAa = new com.tencent.mm.ui.widget.b.a(paramString, localf.aeVM);
          localf.GAa.afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180033);
              parama1.aE(true);
              c.a(localf.GAa, parama1, bj.b.a(bj.b.this), bj.b.b(bj.b.this), 1);
              bj.b.a(bj.b.this, -1);
              bj.b.b(bj.b.this, -1);
              AppMethodBeat.o(180033);
            }
          };
          final boolean bool2 = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
          localf.GAa.agjw = true;
          localf.GAa.agjB = false;
          localf.GAa.agju = new u.f()
          {
            public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              boolean bool = false;
              AppMethodBeat.i(255605);
              paramAnonymouss.clear();
              paramAnonymouss.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
              paramAnonymousView = localf.aeVM.jPy();
              paramAnonymousContextMenuInfo = (bz)localf.aeVM.getTag();
              if (paramAnonymousContextMenuInfo != null) {}
              for (int i = bt.Y(paramAnonymousContextMenuInfo.hTm);; i = 0)
              {
                if ((i <= 0) || (i >= paramAnonymousView.length())) {
                  paramAnonymouss.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                }
                paramAnonymouss.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                paramAnonymouss.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                if (!bool2) {
                  paramAnonymouss.a(0, 4, paramString.getResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
                }
                paramAnonymouss = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bj.b.c(bj.b.this).toString());
                if (!Util.isNullOrNil(paramAnonymouss)) {
                  bj.b.this.a(localf.GAa, parama1, paramAnonymouss);
                }
                if (Util.isNullOrNil(paramAnonymouss)) {
                  localf.GAa.agjF = null;
                }
                paramAnonymousView = "65_" + cn.bDw();
                paramAnonymousContextMenuInfo = bj.b.this;
                com.tencent.mm.ui.chatting.d.a locala = parama1;
                cc localcc = paramcc;
                if (!Util.isNullOrNil(paramAnonymouss)) {
                  bool = true;
                }
                paramAnonymousContextMenuInfo.a(locala, localcc, 1, bool, bj.b.c(bj.b.this).toString(), true, paramAnonymousView, 3);
                AppMethodBeat.o(255605);
                return;
              }
            }
          };
          localf.GAa.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180035);
              bj.b.a(bj.b.this, paramAnonymousInt);
              bj.b.b(bj.b.this, paramAnonymousMenuItem.getItemId());
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
                      AppMethodBeat.o(180035);
                      return;
                      ClipboardHelper.setText(MMApplicationContext.getContext(), bj.b.c(bj.b.this), bj.b.c(bj.b.this));
                      if (localf.aeQt != null)
                      {
                        localf.aeQt.cRQ();
                        localf.aeQt.agoW = true;
                        localf.aeQt.agoX = true;
                        localf.aeQt.cRT();
                      }
                      Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                      try
                      {
                        paramAnonymousMenuItem = (bz)localf.aeVM.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          localObject1 = ((bc)parama1.cm(bc.class)).h(paramAnonymousMenuItem.hTm, false);
                          localObject2 = new na();
                          ((na)localObject2).jcW = paramAnonymousMenuItem.hTm.field_msgSvrId;
                          ((na)localObject2).jcY = ((String)localObject1).length();
                          ((na)localObject2).jcX = bj.b.c(bj.b.this).length();
                          ((na)localObject2).jcZ = bt.Y(paramAnonymousMenuItem.hTm);
                          ((na)localObject2).bMH();
                          bj.c(paramAnonymousMenuItem.hTm, 3, bj.b.c(bj.b.this).length());
                        }
                        AppMethodBeat.o(180035);
                        return;
                      }
                      catch (Exception paramAnonymousMenuItem)
                      {
                        Log.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                        AppMethodBeat.o(180035);
                        return;
                      }
                    } while (localf.aeQt == null);
                    if (localf.aeQt.agoQ != null) {
                      localf.aeQt.agoQ.jxm();
                    }
                    localf.aeQt.agoW = true;
                    localf.aeQt.cRT();
                    localf.aeQt.gc(0, localf.aeVM.jPy().length());
                    localf.aeQt.jJo();
                    localf.aeQt.jJr();
                  } while (localf.aeQt.agoQ == null);
                  localf.aeQt.agoQ.jxn();
                  AppMethodBeat.o(180035);
                  return;
                  bj.c(paramcc, 4, 0);
                  localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                  ((Intent)localObject1).putExtra("Retr_Msg_Id", paramcc.field_msgId);
                  ((Intent)localObject1).putExtra("Retr_Msg_content", bj.b.c(bj.b.this));
                  ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                  paramAnonymousMenuItem = paramString;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(180035);
                  return;
                  bj.c(paramcc, 5, 0);
                  paramAnonymousMenuItem = new dn();
                  l.b(paramAnonymousMenuItem, bj.b.c(bj.b.this).toString(), 1);
                  paramAnonymousMenuItem.hDr.fragment = bj.b.d(bj.b.this).aezO;
                  paramAnonymousMenuItem.hDr.hDy = 43;
                  if (paramAnonymousMenuItem.hDr.hDt != null)
                  {
                    localObject1 = paramAnonymousMenuItem.hDr.hDt.ZBt;
                    if (localObject1 != null)
                    {
                      localObject2 = (bz)localf.aeVM.getTag();
                      if (localObject2 != null)
                      {
                        ((asb)localObject1).bto(z.bAM());
                        ((asb)localObject1).btp(((bz)localObject2).hTm.field_talker);
                        paramAnonymousMenuItem.publish();
                      }
                    }
                  }
                } while (localf.aeQt == null);
                localf.aeQt.cRQ();
                localf.aeQt.agoW = true;
                localf.aeQt.agoX = true;
                localf.aeQt.cRT();
                AppMethodBeat.o(180035);
                return;
              }
              paramAnonymousMenuItem = "65_" + cn.bDw();
              Object localObject1 = bj.b.c(bj.b.this).toString();
              Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
              bj.b localb = bj.b.this;
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
                ((ah)localObject2).WoM = true;
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((ah)localObject2);
                break;
              }
            }
          };
        }
        bj.a(parama1, bt.Z(paramcc), parama, localf.aeVM, bool1);
        if ((!bt.F(paramcc)) && (!bt.N(paramcc)) && (!bt.Q(paramcc))) {
          break label1524;
        }
        localf.aeVM.setTag(aeQy, Boolean.FALSE);
        localf.aeVM.setOnTouchListener(localf.aeQu);
        localf.aeVM.setOnLongClickListener(c(parama1));
        localf.aeVM.setOnClickListener(jxz());
        label880:
        localf.aeVM.setOnDoubleClickListener(this);
        localf.aeVM.setTextListener(new bj.b.7(this, localf));
        paramString = ChattingItemTranslate.c.aeWe;
        if (!com.tencent.mm.app.plugin.d.aDO()) {
          break label1871;
        }
        if ((!paramcc.jbT()) || (!paramcc.jca())) {
          break label1866;
        }
        parama = paramcc.field_transContent;
        paramString = ((bc)parama1.cm(bc.class)).cZ(paramcc);
      }
      for (;;)
      {
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.aeWe))
        {
          if (localf.aeQx == null)
          {
            localf.aeQx = ((ChattingItemTranslate)localf.aeQw.inflate());
            localf.aeQx.init();
          }
          localObject1 = p.a(localf.aeVM.getContext(), parama, (int)localf.aeVM.getTextSize(), localObject1, dH(paramcc));
          localf.aeQx.a((CharSequence)localObject1, paramString);
          localObject1 = localf.aeQx;
          if (Util.isNullOrNil(paramcc.field_transBrandWording))
          {
            paramString = parama1.aezO.getMMResources().getString(R.l.gXo);
            ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
            if (!Util.isNullOrNil(parama))
            {
              parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
              parama.viewType = 2;
              localf.aeQx.setTag(parama);
              localf.aeQx.getContentView().setTag(parama);
              localf.aeQx.setOnClickListener(jxz());
              localf.aeQx.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
              localf.aeQx.setOnDoubleClickListener(this);
              localf.aeQx.setOnLongClickListener(c(parama1));
              localf.aeQx.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          a(paramInt, localf, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(37410);
          return;
          localf.aeVM.setBackgroundResource(R.g.chatto_bg);
          if (localf.aeNG == null) {
            break;
          }
          if (b((m)parama1.cm(m.class), paramcc.field_msgId))
          {
            if (paramcc.adku)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localf.aeVM.startAnimation(parama);
              paramcc.adku = false;
            }
            localf.aeNG.setVisibility(0);
            break;
          }
          localf.aeNG.setVisibility(8);
          break;
          if (paramcc.field_status < 2) {}
          for (bool1 = true;; bool1 = false)
          {
            b(localf, bool1);
            break;
          }
          label1364:
          i = 0;
          break label231;
          label1370:
          bool1 = false;
          break label291;
          j += 1;
          break label478;
          label1385:
          if (paramcc.jUr.contains("notify@all")) {}
          for (parama = "";; parama = localf.aeVM.getContext().getString(R.l.gTT) + "\n")
          {
            ((Bundle)localObject1).putInt("geta8key_scene", 31);
            parama = p.a(localf.aeVM.getContext(), parama + localObject2, (int)localf.aeVM.getTextSize(), 4, localObject1, dH(paramcc), 0, p.YoF, bool1);
            k = 1;
            break;
          }
          label1511:
          localf.Aoo.setVisibility(8);
          break label627;
          label1524:
          i = bt.Y(paramcc);
          if (i > 0)
          {
            j = i;
            if (i < com.tencent.mm.ui.widget.textview.b.mu(localf.aeVM).length()) {}
          }
          else
          {
            j = 0;
          }
          if (localf.aeQt != null) {
            localf.aeQt.destroy();
          }
          parama = c(parama1);
          paramString = a(c(parama1));
          localObject2 = new int[2];
          i = 0;
          if (localf.aeVM != null)
          {
            localf.aeVM.getLocationInWindow((int[])localObject2);
            k = localObject2[0];
            i = k;
            if (k == 0)
            {
              localObject2 = new Rect();
              localf.aeVM.getGlobalVisibleRect((Rect)localObject2);
              i = ((Rect)localObject2).left;
            }
          }
          paramString = new com.tencent.mm.ui.widget.textview.a.a(localf.aeVM, localf.GAa, paramString, jxz(), localf.aeQu);
          paramString.aggi = R.e.chat_to_selected;
          paramString.agpg = 18;
          paramString.aggj = R.e.chat_to_cursor_handle_color;
          if (i != 0) {
            paramString.agph = (i + bd.bs(localf.aeVM.getContext(), R.f.Edge_1_5_A));
          }
          localf.aeQt = paramString.jJu();
          localf.aeQv = new bj.d(localf.aeQt);
          localf.aeQt.agoO = new bj.b.5(this);
          localf.aeMh = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180037);
              localf.aeQt.cRQ();
              localf.aeQt.agoW = true;
              localf.aeQt.agoX = true;
              localf.aeQt.cRT();
              AppMethodBeat.o(180037);
            }
          };
          localf.aeQt.agoU = j;
          parama.aeMh = localf.aeMh;
          localf.aeQt.agpc = localf.aeQv;
          break label880;
          paramString = paramcc.field_transBrandWording;
          break label1082;
          if (localf.aeQx != null) {
            localf.aeQx.setVisibility(8);
          }
        }
        parama = null;
        break label940;
        parama = null;
      }
    }
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  /* Error */
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bz parambz)
  {
    // Byte code:
    //   0: ldc_w 883
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 883
    //   13: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_3
    //   19: getfield 889	com/tencent/mm/pluginsdk/ui/chat/c:hTm	Lcom/tencent/mm/storage/cc;
    //   22: astore 6
    //   24: aload_1
    //   25: invokeinterface 894 1 0
    //   30: lookupswitch	default:+82->112, 102:+402->432, 103:+900->930, 108:+710->740, 124:+909->939, 125:+909->939, 141:+90->120, 142:+139->169, 143:+304->334, 151:+931->961
    //   113: iconst_0
    //   114: drem
    //   115: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload 6
    //   122: getfield 653	com/tencent/mm/autogen/b/fi:field_transContent	Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 304	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   130: ifne +7 -> 137
    //   133: aload_1
    //   134: invokestatic 897	com/tencent/mm/sdk/platformtools/ClipboardHelper:setText	(Ljava/lang/CharSequence;)V
    //   137: aload_2
    //   138: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   141: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   144: aload_2
    //   145: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   148: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   151: getstatic 903	com/tencent/mm/R$l:app_copy_ok	I
    //   154: invokevirtual 906	android/app/Activity:getString	(I)Ljava/lang/String;
    //   157: invokestatic 911	com/tencent/mm/ui/base/k:cZ	(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;
    //   160: pop
    //   161: ldc_w 883
    //   164: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_1
    //   168: ireturn
    //   169: new 913	android/content/Intent
    //   172: dup
    //   173: aload_2
    //   174: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   177: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   180: ldc_w 915
    //   183: invokespecial 918	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   186: astore_1
    //   187: aload_1
    //   188: ldc_w 920
    //   191: aload 6
    //   193: getfield 224	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   196: invokevirtual 924	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   199: pop
    //   200: aload 6
    //   202: getfield 653	com/tencent/mm/autogen/b/fi:field_transContent	Ljava/lang/String;
    //   205: astore_3
    //   206: aload 6
    //   208: invokevirtual 927	com/tencent/mm/storage/cc:jbw	()Z
    //   211: ifeq +102 -> 313
    //   214: aload_1
    //   215: ldc_w 929
    //   218: aload_3
    //   219: invokevirtual 932	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   222: pop
    //   223: aload_1
    //   224: ldc_w 934
    //   227: bipush 6
    //   229: invokevirtual 937	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   232: pop
    //   233: new 939	com/tencent/mm/hellhoundlib/b/a
    //   236: dup
    //   237: invokespecial 940	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   240: aload_1
    //   241: invokevirtual 944	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   244: astore_1
    //   245: aload_2
    //   246: aload_1
    //   247: invokevirtual 948	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   250: ldc_w 950
    //   253: ldc_w 952
    //   256: ldc_w 954
    //   259: ldc_w 956
    //   262: ldc_w 958
    //   265: ldc_w 960
    //   268: invokestatic 965	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_2
    //   272: aload_1
    //   273: iconst_0
    //   274: invokevirtual 969	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   277: checkcast 913	android/content/Intent
    //   280: invokevirtual 971	com/tencent/mm/ui/chatting/d/a:startActivity	(Landroid/content/Intent;)V
    //   283: aload_2
    //   284: ldc_w 950
    //   287: ldc_w 952
    //   290: ldc_w 954
    //   293: ldc_w 956
    //   296: ldc_w 958
    //   299: ldc_w 960
    //   302: invokestatic 974	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   305: ldc_w 883
    //   308: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: iconst_1
    //   312: ireturn
    //   313: aload_1
    //   314: ldc_w 929
    //   317: aload_3
    //   318: invokevirtual 932	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   321: pop
    //   322: aload_1
    //   323: ldc_w 934
    //   326: iconst_4
    //   327: invokevirtual 937	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   330: pop
    //   331: goto -98 -> 233
    //   334: new 976	com/tencent/mm/autogen/a/dn
    //   337: dup
    //   338: invokespecial 977	com/tencent/mm/autogen/a/dn:<init>	()V
    //   341: astore 5
    //   343: aload 5
    //   345: aload 6
    //   347: getfield 653	com/tencent/mm/autogen/b/fi:field_transContent	Ljava/lang/String;
    //   350: iconst_1
    //   351: invokestatic 982	com/tencent/mm/pluginsdk/model/l:b	(Lcom/tencent/mm/autogen/a/dn;Ljava/lang/String;I)Z
    //   354: pop
    //   355: aload 5
    //   357: getfield 986	com/tencent/mm/autogen/a/dn:hDr	Lcom/tencent/mm/autogen/a/dn$a;
    //   360: aload_2
    //   361: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   364: putfield 992	com/tencent/mm/autogen/a/dn$a:fragment	Landroidx/fragment/app/Fragment;
    //   367: aload 5
    //   369: getfield 986	com/tencent/mm/autogen/a/dn:hDr	Lcom/tencent/mm/autogen/a/dn$a;
    //   372: bipush 43
    //   374: putfield 995	com/tencent/mm/autogen/a/dn$a:hDy	I
    //   377: aload 5
    //   379: getfield 986	com/tencent/mm/autogen/a/dn:hDr	Lcom/tencent/mm/autogen/a/dn$a;
    //   382: getfield 999	com/tencent/mm/autogen/a/dn$a:hDt	Lcom/tencent/mm/protocal/protobuf/arv;
    //   385: ifnull +291 -> 676
    //   388: aload 5
    //   390: getfield 986	com/tencent/mm/autogen/a/dn:hDr	Lcom/tencent/mm/autogen/a/dn$a;
    //   393: getfield 999	com/tencent/mm/autogen/a/dn$a:hDt	Lcom/tencent/mm/protocal/protobuf/arv;
    //   396: getfield 1005	com/tencent/mm/protocal/protobuf/arv:ZBt	Lcom/tencent/mm/protocal/protobuf/asb;
    //   399: astore 7
    //   401: aload 7
    //   403: ifnull +29 -> 432
    //   406: aload 7
    //   408: aload 6
    //   410: getfield 99	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   413: invokevirtual 1011	com/tencent/mm/protocal/protobuf/asb:bto	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/asb;
    //   416: pop
    //   417: aload 7
    //   419: invokestatic 1016	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   422: invokevirtual 1019	com/tencent/mm/protocal/protobuf/asb:btp	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/asb;
    //   425: pop
    //   426: aload 5
    //   428: invokevirtual 1020	com/tencent/mm/autogen/a/dn:publish	()Z
    //   431: pop
    //   432: aload_2
    //   433: ldc_w 655
    //   436: invokevirtual 389	com/tencent/mm/ui/chatting/d/a:cm	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/component/aj;
    //   439: checkcast 655	com/tencent/mm/ui/chatting/component/api/bc
    //   442: aload_3
    //   443: checkcast 250	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a
    //   446: getfield 1021	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a:hTm	Lcom/tencent/mm/storage/cc;
    //   449: iconst_0
    //   450: invokeinterface 1025 3 0
    //   455: astore 5
    //   457: new 128	java/lang/StringBuilder
    //   460: dup
    //   461: ldc_w 1027
    //   464: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: aload_1
    //   468: invokeinterface 1030 1 0
    //   473: invokevirtual 1033	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   476: ldc_w 1035
    //   479: invokevirtual 764	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: astore_1
    //   483: aload 5
    //   485: ifnonnull +203 -> 688
    //   488: iconst_0
    //   489: istore 4
    //   491: ldc_w 306
    //   494: aload_1
    //   495: iload 4
    //   497: invokevirtual 1033	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 1038	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload 6
    //   508: invokestatic 587	com/tencent/mm/model/bt:Z	(Lcom/tencent/mm/storage/cc;)I
    //   511: iconst_2
    //   512: if_icmplt +471 -> 983
    //   515: aload_3
    //   516: checkcast 250	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a
    //   519: getfield 1041	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a:aeWa	Ljava/lang/CharSequence;
    //   522: invokestatic 1043	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/CharSequence;)Z
    //   525: ifne +458 -> 983
    //   528: aload_3
    //   529: checkcast 250	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a
    //   532: getfield 1041	com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$a:aeWa	Ljava/lang/CharSequence;
    //   535: astore_1
    //   536: aload_1
    //   537: invokestatic 897	com/tencent/mm/sdk/platformtools/ClipboardHelper:setText	(Ljava/lang/CharSequence;)V
    //   540: getstatic 1049	com/tencent/mm/plugin/secinforeport/a/a:PlY	Lcom/tencent/mm/plugin/secinforeport/a/a;
    //   543: astore 5
    //   545: iconst_1
    //   546: new 128	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   553: aload 6
    //   555: getfield 103	com/tencent/mm/autogen/b/fi:field_msgSvrId	J
    //   558: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: aload_1
    //   565: invokeinterface 1050 1 0
    //   570: invokestatic 1053	com/tencent/mm/sdk/platformtools/Util:getUTF8ByteLength	(Ljava/lang/String;)I
    //   573: invokestatic 1057	com/tencent/mm/plugin/secinforeport/a/a:x	(ILjava/lang/String;I)V
    //   576: aload_3
    //   577: getfield 1058	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
    //   580: iconst_3
    //   581: aload_1
    //   582: invokeinterface 778 1 0
    //   587: invokestatic 1061	com/tencent/mm/ui/chatting/viewitems/bj:c	(Lcom/tencent/mm/storage/cc;II)V
    //   590: new 1063	com/tencent/mm/autogen/mmdata/rpt/na
    //   593: dup
    //   594: invokespecial 1064	com/tencent/mm/autogen/mmdata/rpt/na:<init>	()V
    //   597: astore_3
    //   598: aload_3
    //   599: aload 6
    //   601: getfield 103	com/tencent/mm/autogen/b/fi:field_msgSvrId	J
    //   604: putfield 1067	com/tencent/mm/autogen/mmdata/rpt/na:jcW	J
    //   607: aload_3
    //   608: aload_1
    //   609: invokeinterface 778 1 0
    //   614: putfield 1070	com/tencent/mm/autogen/mmdata/rpt/na:jcY	I
    //   617: aload_3
    //   618: aload_0
    //   619: getfield 52	com/tencent/mm/ui/chatting/viewitems/bj$b:aelV	Ljava/lang/CharSequence;
    //   622: invokeinterface 778 1 0
    //   627: putfield 1073	com/tencent/mm/autogen/mmdata/rpt/na:jcX	I
    //   630: aload_3
    //   631: aload 6
    //   633: invokestatic 769	com/tencent/mm/model/bt:Y	(Lcom/tencent/mm/storage/cc;)I
    //   636: putfield 1076	com/tencent/mm/autogen/mmdata/rpt/na:jcZ	I
    //   639: aload_3
    //   640: invokevirtual 1079	com/tencent/mm/autogen/mmdata/rpt/na:bMH	()Z
    //   643: pop
    //   644: aload_2
    //   645: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   648: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   651: aload_2
    //   652: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   655: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   658: getstatic 903	com/tencent/mm/R$l:app_copy_ok	I
    //   661: invokevirtual 906	android/app/Activity:getString	(I)Ljava/lang/String;
    //   664: invokestatic 911	com/tencent/mm/ui/base/k:cZ	(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;
    //   667: pop
    //   668: ldc_w 883
    //   671: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: iconst_1
    //   675: ireturn
    //   676: ldc_w 306
    //   679: ldc_w 1081
    //   682: invokestatic 1083	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: goto -253 -> 432
    //   688: aload 5
    //   690: invokeinterface 778 1 0
    //   695: istore 4
    //   697: goto -206 -> 491
    //   700: astore_1
    //   701: aload 5
    //   703: astore_1
    //   704: ldc_w 306
    //   707: ldc_w 1085
    //   710: invokestatic 1083	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: goto -123 -> 590
    //   716: astore_1
    //   717: ldc_w 306
    //   720: ldc_w 1087
    //   723: iconst_1
    //   724: anewarray 310	java/lang/Object
    //   727: dup
    //   728: iconst_0
    //   729: aload_1
    //   730: invokevirtual 1090	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   733: aastore
    //   734: invokestatic 316	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   737: goto -93 -> 644
    //   740: aload 6
    //   742: iconst_4
    //   743: iconst_0
    //   744: invokestatic 1061	com/tencent/mm/ui/chatting/viewitems/bj:c	(Lcom/tencent/mm/storage/cc;II)V
    //   747: new 913	android/content/Intent
    //   750: dup
    //   751: aload_2
    //   752: getfield 501	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   755: invokevirtual 900	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   758: ldc_w 915
    //   761: invokespecial 918	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   764: astore_1
    //   765: aload_2
    //   766: ldc_w 655
    //   769: invokevirtual 389	com/tencent/mm/ui/chatting/d/a:cm	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/component/aj;
    //   772: checkcast 655	com/tencent/mm/ui/chatting/component/api/bc
    //   775: aload 6
    //   777: iconst_0
    //   778: invokeinterface 1025 3 0
    //   783: astore_3
    //   784: aload 6
    //   786: invokevirtual 927	com/tencent/mm/storage/cc:jbw	()Z
    //   789: ifeq +107 -> 896
    //   792: aload_1
    //   793: ldc_w 929
    //   796: aload_3
    //   797: invokevirtual 932	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   800: pop
    //   801: aload_1
    //   802: ldc_w 934
    //   805: bipush 6
    //   807: invokevirtual 937	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   810: pop
    //   811: aload_1
    //   812: ldc_w 1092
    //   815: bipush 17
    //   817: invokevirtual 937	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   820: pop
    //   821: new 939	com/tencent/mm/hellhoundlib/b/a
    //   824: dup
    //   825: invokespecial 940	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   828: aload_1
    //   829: invokevirtual 944	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   832: astore_1
    //   833: aload_2
    //   834: aload_1
    //   835: invokevirtual 948	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   838: ldc_w 950
    //   841: ldc_w 952
    //   844: ldc_w 954
    //   847: ldc_w 956
    //   850: ldc_w 958
    //   853: ldc_w 960
    //   856: invokestatic 965	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   859: aload_2
    //   860: aload_1
    //   861: iconst_0
    //   862: invokevirtual 969	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   865: checkcast 913	android/content/Intent
    //   868: invokevirtual 971	com/tencent/mm/ui/chatting/d/a:startActivity	(Landroid/content/Intent;)V
    //   871: aload_2
    //   872: ldc_w 950
    //   875: ldc_w 952
    //   878: ldc_w 954
    //   881: ldc_w 956
    //   884: ldc_w 958
    //   887: ldc_w 960
    //   890: invokestatic 974	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   893: goto -781 -> 112
    //   896: aload_1
    //   897: ldc_w 929
    //   900: aload_3
    //   901: invokevirtual 932	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   904: pop
    //   905: aload_1
    //   906: ldc_w 934
    //   909: iconst_4
    //   910: invokevirtual 937	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   913: pop
    //   914: aload_1
    //   915: ldc_w 920
    //   918: aload 6
    //   920: getfield 224	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   923: invokevirtual 924	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   926: pop
    //   927: goto -116 -> 811
    //   930: aload_0
    //   931: aload 6
    //   933: invokespecial 1093	com/tencent/mm/ui/chatting/viewitems/bj$b:cs	(Lcom/tencent/mm/storage/cc;)V
    //   936: goto -824 -> 112
    //   939: aload_2
    //   940: ldc_w 655
    //   943: invokevirtual 389	com/tencent/mm/ui/chatting/d/a:cm	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/component/aj;
    //   946: checkcast 655	com/tencent/mm/ui/chatting/component/api/bc
    //   949: aload_1
    //   950: aload 6
    //   952: invokeinterface 1096 3 0
    //   957: pop
    //   958: goto -846 -> 112
    //   961: aload_2
    //   962: aload 6
    //   964: getfield 224	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   967: iconst_2
    //   968: invokestatic 1101	com/tencent/mm/ui/chatting/u:a	(Lcom/tencent/mm/ui/chatting/d/a;JI)V
    //   971: ldc_w 883
    //   974: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   977: iconst_0
    //   978: ireturn
    //   979: astore_3
    //   980: goto -276 -> 704
    //   983: aload 5
    //   985: astore_1
    //   986: goto -450 -> 536
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	989	0	this	b
    //   0	989	1	paramMenuItem	MenuItem
    //   0	989	2	parama	com.tencent.mm.ui.chatting.d.a
    //   0	989	3	parambz	bz
    //   489	207	4	i	int
    //   341	643	5	localObject	Object
    //   22	941	6	localcc	cc
    //   399	19	7	localasb	asb
    // Exception table:
    //   from	to	target	type
    //   506	536	700	java/lang/Exception
    //   590	644	716	java/lang/Exception
    //   536	590	979	java/lang/Exception
  }
  
  public boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254979);
    if ((paramcc.jUr != null) && (paramcc.jUr.contains("announcement@all"))) {}
    for (int i = 1; (!paramcc.iYl()) && (!paramcc.jbw()); i = 0)
    {
      AppMethodBeat.o(254979);
      return true;
    }
    paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
    int j = paramContextMenuInfo.position;
    if (paramContextMenuInfo.viewType == 1)
    {
      if (paramcc.iYl())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
          params.a(j, 151, this.aeiK.aezO.getMMResources().getString(R.l.gJi), R.k.icons_filled_continued_form);
        }
        if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
          params.a(j, 102, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
        }
      }
      if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
        params.a(j, 108, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (paramcc.field_status == 5) {
        params.a(j, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(j, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType())) {
        params.a(j, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((i == 0) && (!paramcc.iYe()) && (paramcc.iYl()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!com.tencent.mm.storage.au.Hh(this.aeiK.getTalkerUserName()))) {
        params.a(j, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if ((com.tencent.mm.app.plugin.d.aDO()) && ((!paramcc.jbT()) || (!paramcc.jca()))) {
        params.a(j, 124, paramView.getContext().getString(R.l.gyI), R.k.icons_filled_translate);
      }
      if ((paramcc.iYl()) && (com.tencent.mm.an.g.bGH())) {
        this.aeiK.juH();
      }
      if (!this.aeiK.juH()) {
        params.a(j, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      if ((bt.F(paramcc)) || (bt.Z(paramcc) == 4))
      {
        params.clear();
        if (!this.aeiK.juH()) {
          params.a(j, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
        }
      }
    }
    while (paramContextMenuInfo.viewType != 2)
    {
      AppMethodBeat.o(254979);
      return true;
    }
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
    AppMethodBeat.o(254979);
    return false;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(254997);
    paramcc.unsetOmittedFailResend();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    if ((paramcc.iYl()) && (paramcc.field_isSend == 1)) {
      cs(paramcc);
    }
    AppMethodBeat.o(254997);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(37416);
    if (x.ly(paramView))
    {
      Log.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37416);
      return true;
    }
    Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject2).addFlags(67108864);
    ChattingItemTranslate.a locala;
    if ((paramView.getTag() instanceof ChattingItemTranslate.a))
    {
      locala = (ChattingItemTranslate.a)paramView.getTag();
      ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.hTm.field_msgId);
      if (((aa)this.aeiK.cm(aa.class)).cT(locala.hTm))
      {
        localObject1 = ((MMNeat7extView)paramView).jPy().toString();
        ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
        ((Intent)localObject2).putExtra("is_group_chat", this.aeiK.juG());
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(locala.hTm.field_talker);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.ne(paramView.getContext());
      }
    }
    else
    {
      AppMethodBeat.o(37416);
      return true;
    }
    Object localObject1 = (bc)this.aeiK.cm(bc.class);
    cc localcc = locala.hTm;
    if (locala.viewType == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((bc)localObject1).h(localcc, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.b
 * JD-Core Version:    0.7.0.1
 */