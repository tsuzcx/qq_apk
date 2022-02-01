package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
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
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.b;
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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.component.api.aa;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class bj$a
  extends c
  implements NeatTextView.b
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQy = R.h.fYD;
  private static final int aeQz = R.h.fza;
  private int aeMA = -1;
  private bj.e aeVG;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private CharSequence aelV;
  private int mmp = -1;
  
  private String dH(cc paramcc)
  {
    AppMethodBeat.i(37397);
    if (paramcc != null)
    {
      String str = ad.Jo(paramcc.field_msgSvrId);
      ad.b localb = ad.bCb().M(str, true);
      localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
      localb.q("preUsername", a(this.aeiK, paramcc));
      localb.q("preChatName", b(this.aeiK, paramcc));
      AppMethodBeat.o(37397);
      return str;
    }
    AppMethodBeat.o(37397);
    return null;
  }
  
  private bj.e jxz()
  {
    AppMethodBeat.i(37393);
    if (this.aeVG == null) {
      this.aeVG = new bj.e(this.aeiK);
    }
    bj.e locale = this.aeVG;
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
      localObject = new ap(paramLayoutInflater, R.i.gfv);
      ((View)localObject).setTag(new bj.f().P((View)localObject, true));
    }
    AppMethodBeat.o(37394);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
  {
    AppMethodBeat.i(37396);
    this.aeiK = parama1;
    final bj.f localf = (bj.f)parama;
    Object localObject2 = paramcc.field_content;
    paramString = parama1.getTalkerUserName();
    localf.aeVM.setTag(aeQz, Long.valueOf(paramcc.field_msgId));
    localf.aeVM.setTag(aeQA, Boolean.TRUE);
    parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
    localf.aeVM.setTag(parama);
    ChattingItemTranslate.c localc = ChattingItemTranslate.c.aeWe;
    if (com.tencent.mm.app.plugin.d.aDO()) {
      if ((paramcc.jbT()) && (paramcc.jca()))
      {
        parama = paramcc.field_transContent;
        localc = ((bc)parama1.cm(bc.class)).cZ(paramcc);
      }
    }
    for (;;)
    {
      int i;
      Object localObject1;
      if ((parama1.juG()) && (!((e)parama1.cm(e.class)).jqV()))
      {
        i = br.JG((String)localObject2);
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i).trim();
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject2 = ((String)localObject2).substring(i + 1).trim();
            if (!Util.isNullOrNil(parama)) {
              paramString = parama.substring(i + 1).trim();
            }
          }
        }
      }
      for (;;)
      {
        a(localf, parama1, paramcc, (String)localObject1);
        a(localf, parama1, (String)localObject1, paramcc);
        int j;
        Bundle localBundle;
        int k;
        boolean bool1;
        if ((paramcc.jUr != null) && ((paramcc.jcr()) || (paramcc.jcs())))
        {
          j = 1;
          parama = com.tencent.mm.ui.chatting.i.a.aeJh;
          com.tencent.mm.ui.chatting.i.a.a.a(localf.aeVM, paramcc, parama1.juG(), (String)localObject1);
          parama = com.tencent.mm.pluginsdk.ui.span.x.aq(parama1.juG(), com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
          localBundle = bj.dG(paramcc);
          localBundle.putAll(parama);
          parama = null;
          k = 1;
          if (bt.U(paramcc)) {
            break label1223;
          }
          bool1 = true;
          label349:
          if (j != 0) {
            break label1282;
          }
          if (!com.tencent.mm.storage.au.bwO((String)localObject1)) {
            break label1229;
          }
          parama = p.a(localf.aeVM.getContext(), (CharSequence)localObject2, (int)localf.aeVM.getTextSize(), localBundle, dH(paramcc), p.YoF, bool1);
          label398:
          localObject1 = (com.tencent.mm.ui.chatting.component.api.au)parama1.cm(com.tencent.mm.ui.chatting.component.api.au.class);
          if (!((com.tencent.mm.ui.chatting.component.api.au)localObject1).zT(paramcc.field_msgId)) {
            break label1839;
          }
          localObject1 = f.a(com.tencent.mm.plugin.fts.a.a.g.a(parama, ((com.tencent.mm.ui.chatting.component.api.au)localObject1).jtt(), g.a.HsR, b.b.HwM));
          localf.aeVM.a(((com.tencent.mm.plugin.fts.a.a.h)localObject1).HsX, TextView.BufferType.SPANNABLE);
        }
        label548:
        label683:
        label1839:
        for (i = 0;; i = 1)
        {
          localObject1 = (t[])parama.getSpans(0, parama.length(), t.class);
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            localObject2 = new bq();
            ((bq)localObject2).hBG.msgId = paramcc.field_msgId;
            ((bq)localObject2).hBG.type = 1;
            ((bq)localObject2).hBG.hBF = true;
            ((bq)localObject2).publish();
          }
          k = localObject1.length;
          j = 0;
          if (j < k) {
            if (localObject1[j].getType() == 44)
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(7), "" });
              label595:
              if (i != 0) {
                bj.a(localf.aeVM.getContext(), parama1, paramcc.field_content, parama, localf.aeVM, paramcc, 1);
              }
              if (!com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
                break label1486;
              }
              localf.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gJj));
              localf.Aoo.setVisibility(0);
              localf.Aoo.setOnClickListener(new bj.a.1(this, localf, parama1));
              bj.a(paramcc, localf, parama1);
              localObject1 = localf.aeVM.getContext();
              localf.aeVM.setTag(aeQy, Boolean.TRUE);
              if (localf.GAa == null)
              {
                localf.GAa = new com.tencent.mm.ui.widget.b.a((Context)localObject1, localf.aeVM);
                localf.GAa.afLp = new PopupWindow.OnDismissListener()
                {
                  public final void onDismiss()
                  {
                    AppMethodBeat.i(180024);
                    parama1.aE(true);
                    c.a(localf.GAa, parama1, bj.a.a(bj.a.this), bj.a.b(bj.a.this), 1);
                    bj.a.a(bj.a.this, -1);
                    bj.a.b(bj.a.this, -1);
                    AppMethodBeat.o(180024);
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
                    AppMethodBeat.i(255158);
                    paramAnonymouss.clear();
                    paramAnonymouss.a(0, 0, this.val$context.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                    paramAnonymousView = localf.aeVM.jPy();
                    paramAnonymousContextMenuInfo = (bz)localf.aeVM.getTag();
                    if (paramAnonymousContextMenuInfo != null) {}
                    for (int i = bt.Y(paramAnonymousContextMenuInfo.hTm);; i = 0)
                    {
                      if ((i <= 0) || (i >= paramAnonymousView.length())) {
                        paramAnonymouss.a(0, 1, this.val$context.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                      }
                      paramAnonymouss.a(0, 2, this.val$context.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                      paramAnonymouss.a(0, 3, this.val$context.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                      if (!bool2) {
                        paramAnonymouss.a(0, 4, this.val$context.getResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
                      }
                      paramAnonymouss = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bj.a.c(bj.a.this).toString());
                      if (!Util.isNullOrNil(paramAnonymouss)) {
                        bj.a.this.a(localf.GAa, parama1, paramAnonymouss);
                      }
                      if (Util.isNullOrNil(paramAnonymouss)) {
                        localf.GAa.agjF = null;
                      }
                      paramAnonymousView = "65_" + cn.bDw();
                      paramAnonymousContextMenuInfo = bj.a.this;
                      com.tencent.mm.ui.chatting.d.a locala = parama1;
                      cc localcc = paramcc;
                      if (!Util.isNullOrNil(paramAnonymouss)) {
                        bool = true;
                      }
                      paramAnonymousContextMenuInfo.a(locala, localcc, 1, bool, bj.a.c(bj.a.this).toString(), true, paramAnonymousView, 3);
                      AppMethodBeat.o(255158);
                      return;
                    }
                  }
                };
                localf.GAa.GAC = new u.i()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(180028);
                    bj.a.b(bj.a.this, paramAnonymousMenuItem.getItemId());
                    bj.a.a(bj.a.this, paramAnonymousInt);
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
                              AppMethodBeat.o(180028);
                              return;
                              ClipboardHelper.setText(MMApplicationContext.getContext(), bj.a.c(bj.a.this), bj.a.c(bj.a.this));
                              if (localf.aeQt != null)
                              {
                                localf.aeQt.cRQ();
                                localf.aeQt.agoW = true;
                                localf.aeQt.agoX = true;
                                localf.aeQt.cRT();
                              }
                              Toast.makeText(this.val$context, R.l.app_copy_ok, 0).show();
                              try
                              {
                                paramAnonymousMenuItem = (bz)localf.aeVM.getTag();
                                if (paramAnonymousMenuItem != null)
                                {
                                  localObject1 = ((bc)parama1.cm(bc.class)).h(paramAnonymousMenuItem.hTm, false);
                                  localObject2 = new na();
                                  ((na)localObject2).jcW = paramAnonymousMenuItem.hTm.field_msgSvrId;
                                  ((na)localObject2).jcY = ((String)localObject1).length();
                                  ((na)localObject2).jcX = bj.a.c(bj.a.this).length();
                                  ((na)localObject2).jcZ = bt.Y(paramAnonymousMenuItem.hTm);
                                  ((na)localObject2).bMH();
                                  bj.c(paramAnonymousMenuItem.hTm, 3, bj.a.c(bj.a.this).length());
                                }
                                AppMethodBeat.o(180028);
                                return;
                              }
                              catch (Exception paramAnonymousMenuItem)
                              {
                                Log.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                                AppMethodBeat.o(180028);
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
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = (bz)localf.aeVM.getTag();
                        } while (paramAnonymousMenuItem == null);
                        bj.c(paramAnonymousMenuItem.hTm, 4, 0);
                        localObject1 = bt.X(paramAnonymousMenuItem.hTm);
                        if (Util.isNullOrNil((String)localObject1))
                        {
                          localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                          ((Intent)localObject1).putExtra("Retr_Msg_Id", paramAnonymousMenuItem.hTm.field_msgId);
                          ((Intent)localObject1).putExtra("Retr_Msg_content", bj.a.c(bj.a.this));
                          ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                          paramAnonymousMenuItem = this.val$context;
                          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(180028);
                          return;
                        }
                        com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(4), localObject1 });
                        k.a(this.val$context, R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new bj.a.4.1(this, (String)localObject1), new bj.a.4.2(this, paramAnonymousMenuItem, (String)localObject1));
                        AppMethodBeat.o(180028);
                        return;
                        paramAnonymousMenuItem = new dn();
                        l.b(paramAnonymousMenuItem, bj.a.c(bj.a.this).toString(), 1);
                        paramAnonymousMenuItem.hDr.fragment = bj.a.d(bj.a.this).aezO;
                        paramAnonymousMenuItem.hDr.hDy = 43;
                        if (paramAnonymousMenuItem.hDr.hDt != null)
                        {
                          localObject1 = paramAnonymousMenuItem.hDr.hDt.ZBt;
                          if (localObject1 != null)
                          {
                            localObject2 = (bz)localf.aeVM.getTag();
                            if (localObject2 != null)
                            {
                              bj.c(((bz)localObject2).hTm, 5, 0);
                              ((asb)localObject1).bto(((bz)localObject2).hTm.field_talker);
                              ((asb)localObject1).btp(z.bAM());
                              paramAnonymousMenuItem.publish();
                            }
                          }
                        }
                      } while (localf.aeQt == null);
                      localf.aeQt.cRQ();
                      localf.aeQt.agoW = true;
                      localf.aeQt.agoX = true;
                      localf.aeQt.cRT();
                      AppMethodBeat.o(180028);
                      return;
                    }
                    paramAnonymousMenuItem = "65_" + cn.bDw();
                    Object localObject1 = bj.a.c(bj.a.this).toString();
                    Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
                    bj.a locala = bj.a.this;
                    com.tencent.mm.ui.chatting.d.a locala1 = parama1;
                    cc localcc = paramcc;
                    if (!Util.isNullOrNil((String)localObject2)) {}
                    for (boolean bool = true;; bool = false)
                    {
                      locala.a(locala1, localcc, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                      localObject2 = new ah();
                      ((ah)localObject2).context = this.val$context;
                      ((ah)localObject2).scene = 65;
                      ((ah)localObject2).query = ((String)localObject1);
                      ((ah)localObject2).sessionId = paramAnonymousMenuItem;
                      ((ah)localObject2).WoH = true;
                      ((ah)localObject2).WoJ = false;
                      ((ah)localObject2).WoM = false;
                      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((ah)localObject2);
                      break;
                    }
                  }
                };
              }
              bj.a(parama1, bt.Z(paramcc), parama, localf.aeVM, bool1);
              if ((!bt.F(paramcc)) && (!bt.N(paramcc)) && (!bt.Q(paramcc))) {
                break label1499;
              }
              localf.aeVM.setTag(aeQy, Boolean.FALSE);
              localf.aeVM.setOnTouchListener(localf.aeQu);
              localf.aeVM.setOnLongClickListener(c(parama1));
              localf.aeVM.setOnClickListener(jxz());
              localf.aeVM.setOnDoubleClickListener(this);
              localf.aeVM.setTextListener(new MMNeat7extView.a()
              {
                public final void aW(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180031);
                  if (((Boolean)localf.aeVM.getTag(bj.a.dsI())).booleanValue())
                  {
                    com.tencent.mm.ui.chatting.j.a.a.jwS();
                    com.tencent.mm.ui.chatting.j.a.a.jwT().a(paramAnonymousCharSequence, ((Long)localf.aeVM.getTag(bj.a.ddn())).longValue());
                  }
                  AppMethodBeat.o(180031);
                }
              });
              if ((Util.isNullOrNil(paramString)) && (localc == ChattingItemTranslate.c.aeWe)) {
                break label1815;
              }
              if (localf.aeQx == null)
              {
                localf.aeQx = ((ChattingItemTranslate)localf.aeQw.inflate());
                localf.aeQx.init();
              }
              parama = p.a(localf.aeVM.getContext(), paramString, (int)localf.aeVM.getTextSize(), localBundle, dH(paramcc));
              localf.aeQx.a(parama, localc);
              localObject1 = localf.aeQx;
              if (!Util.isNullOrNil(paramcc.field_transBrandWording)) {
                break label1806;
              }
            }
          }
          for (parama = parama1.aezO.getMMResources().getString(R.l.gXo);; parama = paramcc.field_transBrandWording)
          {
            ((ChattingItemTranslate)localObject1).setBrandWording(parama);
            if (!Util.isNullOrNil(paramString))
            {
              parama = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
              parama.aeXR = false;
              parama.viewType = 2;
              localf.aeQx.setTag(parama);
              localf.aeQx.getContentView().setTag(parama);
              localf.aeQx.setOnClickListener(jxz());
              localf.aeQx.setOnDoubleClickListener(this);
              localf.aeQx.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
              localf.aeQx.setOnLongClickListener(c(parama1));
              localf.aeQx.setVisibility(0);
            }
            AppMethodBeat.o(37396);
            return;
            j = 0;
            break;
            label1223:
            bool1 = false;
            break label349;
            label1229:
            parama = p.a(localf.aeVM.getContext(), (CharSequence)localObject2, (int)localf.aeVM.getTextSize(), 1, localBundle, dH(paramcc), 0, p.YoF, bool1);
            break label398;
            j += 1;
            break label548;
            break label595;
            i = k;
            if (j == 0) {
              break label595;
            }
            if (paramcc.jUr.contains("notify@all")) {}
            for (parama = "";; parama = localf.aeVM.getContext().getString(R.l.gTT) + "\n")
            {
              localBundle.putInt("geta8key_scene", 31);
              if (!com.tencent.mm.storage.au.bwO((String)localObject1)) {
                break label1424;
              }
              parama = p.a(localf.aeVM.getContext(), parama + localObject2, (int)localf.aeVM.getTextSize(), localBundle, dH(paramcc), p.YoF, bool1);
              i = k;
              break;
            }
            parama = p.a(localf.aeVM.getContext(), parama + localObject2, (int)localf.aeVM.getTextSize(), 1, localBundle, dH(paramcc), 0, p.YoF, bool1);
            i = k;
            break label595;
            label1486:
            localf.Aoo.setVisibility(8);
            break label683;
            label1499:
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
            parama = c(parama1);
            localObject1 = a(parama);
            if (localf.aeQt != null) {
              localf.aeQt.destroy();
            }
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
            localObject1 = new com.tencent.mm.ui.widget.textview.a.a(localf.aeVM, localf.GAa, (a.f)localObject1, jxz(), localf.aeQu);
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggi = R.e.selected_blue;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agpg = 18;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).aggj = R.e.cursor_handle_color;
            if (i != 0) {
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).agph = (i + bd.bs(localf.aeVM.getContext(), R.f.Edge_2A));
            }
            localf.aeQt = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).jJu();
            localf.aeQv = new bj.d(localf.aeQt);
            localf.aeQt.agoO = new bj.a.5(this);
            localf.aeMh = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180030);
                localf.aeQt.cRQ();
                localf.aeQt.agoW = true;
                localf.aeQt.agoX = true;
                localf.aeQt.cRT();
                AppMethodBeat.o(180030);
              }
            };
            parama.aeMh = localf.aeMh;
            localf.aeQt.agoU = j;
            localf.aeQt.agpc = localf.aeQv;
            break label936;
          }
          if (localf.aeQx != null) {
            localf.aeQx.setVisibility(8);
          }
          AppMethodBeat.o(37396);
          return;
        }
        label936:
        paramString = parama;
        label1282:
        label1424:
        label1815:
        continue;
        label1806:
        localObject1 = paramString;
        break;
        localObject1 = paramString;
        paramString = parama;
      }
      parama = null;
      break;
      parama = null;
    }
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bz parambz)
  {
    AppMethodBeat.i(37399);
    if (parambz == null)
    {
      AppMethodBeat.o(37399);
      return false;
    }
    cc localcc = parambz.hTm;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37399);
      return false;
    case 141: 
      paramMenuItem = localcc.field_transContent;
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
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(37399);
      return true;
      parambz = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem = localcc.field_transContent;
      if ((parama.juG()) && (!((e)parama.cm(e.class)).jqV()))
      {
        i = br.JG(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        if (localcc.jbw())
        {
          parambz.putExtra("Retr_Msg_content", paramMenuItem);
          parambz.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(parambz);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37399);
          return true;
          parambz.putExtra("Retr_Msg_content", paramMenuItem);
          parambz.putExtra("Retr_Msg_Type", 4);
        }
        dn localdn = new dn();
        Object localObject = localcc.field_transContent;
        if ((parama.juG()) && (!((e)parama.cm(e.class)).jqV()))
        {
          i = br.JG((String)localObject);
          if (i != -1) {
            localObject = ((String)localObject).substring(i + 1).trim();
          }
        }
        for (;;)
        {
          l.b(localdn, (String)localObject, 1);
          localdn.hDr.fragment = parama.aezO;
          localdn.hDr.hDy = 43;
          if (localdn.hDr.hDt != null)
          {
            localObject = localdn.hDr.hDt.ZBt;
            if (localObject != null)
            {
              ((asb)localObject).bto(localcc.field_talker);
              ((asb)localObject).btp(z.bAM());
              localdn.publish();
            }
            localObject = ((bc)parama.cm(bc.class)).h(((ChattingItemTranslate.a)parambz).hTm, false);
            paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
            if (localObject != null) {
              break label817;
            }
            i = 0;
            label623:
            Log.d("MicroMsg.ChattingItemTextFrom", i);
          }
          for (;;)
          {
            try
            {
              if ((bt.Z(localcc) < 2) || (Util.isNullOrNil(((ChattingItemTranslate.a)parambz).aeWa))) {
                break label1177;
              }
              paramMenuItem = ((ChattingItemTranslate.a)parambz).aeWa;
            }
            catch (Exception paramMenuItem)
            {
              for (;;)
              {
                try
                {
                  ClipboardHelper.setText(paramMenuItem);
                  bj.c(localcc, 3, paramMenuItem.length());
                  k.cZ(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.app_copy_ok));
                  parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
                  com.tencent.mm.plugin.secinforeport.a.a.x(1, localcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem.toString()));
                }
                catch (Exception parambz)
                {
                  label817:
                  continue;
                }
                try
                {
                  parama = new na();
                  parama.jcW = localcc.field_msgSvrId;
                  parama.jcY = paramMenuItem.length();
                  parama.jcX = this.aelV.length();
                  parama.jcZ = bt.Y(localcc);
                  parama.bMH();
                  AppMethodBeat.o(37399);
                  return true;
                  Log.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                  break;
                  i = ((CharSequence)localObject).length();
                  break label623;
                  paramMenuItem = paramMenuItem;
                  paramMenuItem = (MenuItem)localObject;
                  Log.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
                }
                catch (Exception paramMenuItem)
                {
                  Log.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
                }
              }
            }
            bj.c(localcc, 4, 0);
            paramMenuItem = bt.X(localcc);
            if (Util.isNullOrNil(paramMenuItem))
            {
              paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
              paramMenuItem.putExtra("Retr_Msg_Id", localcc.field_msgId);
              parambz = ((bc)parama.cm(bc.class)).h(localcc, false);
              if (localcc.jbw())
              {
                paramMenuItem.putExtra("Retr_Msg_content", parambz);
                paramMenuItem.putExtra("Retr_Msg_Type", 6);
              }
              for (;;)
              {
                paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
                com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)paramMenuItem.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
                paramMenuItem.putExtra("Retr_Msg_content", parambz);
                paramMenuItem.putExtra("Retr_Msg_Type", 4);
              }
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
            k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new bj.a.8(this, paramMenuItem, parama), new bj.a.9(this, parama, localcc, paramMenuItem));
            break;
            ((bc)parama.cm(bc.class)).b(paramMenuItem, localcc);
            break;
            u.a(parama, localcc.field_msgId, 2);
            AppMethodBeat.o(37399);
            return false;
            label1177:
            paramMenuItem = (MenuItem)localObject;
          }
        }
      }
    }
  }
  
  public boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254980);
    if ((!paramcc.iYl()) && (!paramcc.jbw()))
    {
      AppMethodBeat.o(254980);
      return true;
    }
    paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
    int i = paramContextMenuInfo.position;
    if (paramContextMenuInfo.viewType == 1)
    {
      if (paramcc.iYl())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aW(paramcc)) {
          params.a(i, 151, this.aeiK.aezO.getMMResources().getString(R.l.gJi), R.k.icons_filled_continued_form);
        }
        if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
          params.a(i, 102, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
        }
      }
      if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
        params.a(i, 108, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType())) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((paramcc.iYl()) && (com.tencent.mm.an.g.bGH())) {
        this.aeiK.juH();
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      if ((com.tencent.mm.app.plugin.d.aDO()) && ((!paramcc.jbT()) || (!paramcc.jca()))) {
        params.a(i, 124, paramView.getContext().getString(R.l.gyI), R.k.icons_filled_translate);
      }
      if ((bt.F(paramcc)) || (bt.Z(paramcc) == 4))
      {
        params.clear();
        if (!this.aeiK.juH()) {
          params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
        }
      }
    }
    while (paramContextMenuInfo.viewType != 2)
    {
      AppMethodBeat.o(254980);
      return true;
    }
    params.a(i, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
    params.a(i, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(i, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (com.tencent.mm.app.plugin.d.aDO())
    {
      if ((paramcc.jbT()) && (paramcc.jca())) {
        params.a(i, 124, paramView.getContext().getString(R.l.gyG), R.k.icons_filled_eyes_off);
      }
      if (paramcc.jcd()) {
        params.a(i, 125, paramView.getContext().getString(R.l.gyz), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(254980);
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37395);
    boolean bool = parama.juG();
    AppMethodBeat.o(37395);
    return bool;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37400);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.j.a.a.jwS();
      com.tencent.mm.ui.chatting.j.a.a.a(paramView.getText(), paramcc);
    }
    AppMethodBeat.o(37400);
    return true;
  }
  
  public boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected boolean jxh()
  {
    return false;
  }
  
  public final boolean lA(View paramView)
  {
    AppMethodBeat.i(37401);
    if (x.ly(paramView))
    {
      Log.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37401);
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
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.ne(paramView.getContext());
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(locala.hTm.field_talker);
      }
    }
    else
    {
      AppMethodBeat.o(37401);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.a
 * JD-Core Version:    0.7.0.1
 */