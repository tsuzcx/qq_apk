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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.be.w;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ad$b
  extends c
  implements NeatTextView.b
{
  private static final int XgD = R.h.dVZ;
  private static final int XgE = R.h.dyq;
  private static final int XgF = R.h.dyp;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private CharSequence WEv;
  private int XcC = -1;
  private ad.f XgV;
  private int jNq = -1;
  
  private ad.f hTQ()
  {
    AppMethodBeat.i(37012);
    if (this.XgV == null) {
      this.XgV = new ad.f(this.WBq);
    }
    ad.f localf = this.XgV;
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
      localObject = new aq(paramLayoutInflater, R.i.edc);
      ((View)localObject).setTag(new ad.a().ii((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.WBq = parama1;
    ((m)parama1.bC(m.class)).ct(paramca);
    final ad.a locala = (ad.a)parama;
    locala.Xgx.setTag(XgE, Long.valueOf(paramca.field_msgId));
    locala.Xgx.setTag(XgF, Boolean.TRUE);
    paramString = paramca.field_content;
    parama = paramString;
    int i;
    if (parama1.hRi())
    {
      i = paramca.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      boolean bool;
      Object localObject1;
      label399:
      int j;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.WQv.getContext(), locala.wRL.getTextSize(), paramca, parama.loR);
        locala.wRL.setText(l.c(locala.Xgx.getContext(), (CharSequence)paramString.second));
        locala.wRL.setTag(parama.loR);
        bool = ((k)parama1.bC(k.class)).hNH();
        localObject1 = w.bnV().WM(parama1.getTalkerUserName());
        bh.beI();
        i = ((Integer)com.tencent.mm.model.c.aHp().b(12311, Integer.valueOf(-2))).intValue();
        if (((localObject1 != null) && (((com.tencent.mm.be.a)localObject1).lXh != -2)) || ((localObject1 == null) && (i != -2))) {
          if (bool)
          {
            locala.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.desc_text));
            locala.XgU.setBackgroundResource(R.g.dod);
            if (!((Boolean)paramString.first).booleanValue()) {
              break label1532;
            }
            locala.wRL.setVisibility(0);
            locala.clickArea.setVisibility(0);
            locala.clickArea.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37003);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                try
                {
                  long l = ((Long)locala.Xgx.getTag(ad.b.XgE)).longValue();
                  Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
                  localObject = (MsgQuoteItem)locala.wRL.getTag();
                  ad.e.a(parama1, ad.b.this, paramAnonymousView, l, (MsgQuoteItem)localObject, ad.b.this.tMW);
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
            locala.wRL.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37004);
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.clickArea.getLayoutParams();
                localLayoutParams.height = locala.XgU.getHeight();
                localLayoutParams.width = locala.XgU.getWidth();
                locala.clickArea.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(37004);
              }
            });
            locala.Xdu.setVisibility(8);
            locala.Xgx.setClickable(true);
            paramString = t.ap(parama1.hRi(), com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
            parama = l.a(locala.Xgx.getContext(), parama.title, (int)locala.Xgx.getTextSize(), 1, paramString, l.Rsm);
            locala.Xgx.a(parama, TextView.BufferType.SPANNABLE);
            parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
            paramString = locala.Xgx.getContext();
            locala.Xgx.setTag(XgD, Boolean.TRUE);
            if (locala.AYp == null)
            {
              locala.AYp = new com.tencent.mm.ui.widget.b.a(paramString, locala.Xgx);
              locala.AYp.XVa = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(180009);
                  parama1.Y(true);
                  c.a(locala.AYp, parama1, ad.b.a(ad.b.this), ad.b.b(ad.b.this), 49);
                  ad.b.a(ad.b.this, -1);
                  ad.b.b(ad.b.this, -1);
                  AppMethodBeat.o(180009);
                }
              };
              locala.AYp.Yri = true;
              locala.AYp.Yrg = new q.e()
              {
                public final void a(o paramAnonymouso, View paramAnonymousView)
                {
                  boolean bool = false;
                  AppMethodBeat.i(286266);
                  paramAnonymouso.clear();
                  paramAnonymouso.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                  paramAnonymousView = locala.Xgx.ikC();
                  Object localObject = (by)locala.Xgx.getTag();
                  if (localObject != null) {}
                  for (int i = bs.U(((by)localObject).fNz);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymouso.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                    }
                    paramAnonymouso.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                    paramAnonymouso.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                    paramAnonymouso.a(0, 4, paramString.getResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
                    paramAnonymouso = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(ad.b.c(ad.b.this).toString());
                    if (!Util.isNullOrNil(paramAnonymouso)) {
                      ad.b.this.a(locala.AYp, parama1, paramAnonymouso);
                    }
                    if (Util.isNullOrNil(paramAnonymouso)) {
                      locala.AYp.Yrp = null;
                    }
                    paramAnonymousView = "65_" + cm.bfE();
                    localObject = ad.b.this;
                    com.tencent.mm.ui.chatting.e.a locala = parama1;
                    ca localca = paramca;
                    if (!Util.isNullOrNil(paramAnonymouso)) {
                      bool = true;
                    }
                    ((ad.b)localObject).a(locala, localca, 1, bool, ad.b.c(ad.b.this).toString(), true, paramAnonymousView, 3);
                    AppMethodBeat.o(286266);
                    return;
                  }
                }
              };
              locala.AYp.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(180013);
                  ad.b.a(ad.b.this, paramAnonymousInt);
                  ad.b.b(ad.b.this, paramAnonymousMenuItem.getItemId());
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
                            ClipboardHelper.setText(MMApplicationContext.getContext(), ad.b.c(ad.b.this), ad.b.c(ad.b.this));
                            if (locala.Xgy != null)
                            {
                              locala.Xgy.cpn();
                              locala.Xgy.YwE = true;
                              locala.Xgy.YwF = true;
                              locala.Xgy.cpq();
                            }
                            Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                            AppMethodBeat.o(180013);
                            return;
                          } while (locala.Xgy == null);
                          if (locala.Xgy.Ywy != null) {
                            locala.Xgy.Ywy.hTJ();
                          }
                          locala.Xgy.YwE = true;
                          locala.Xgy.cpq();
                          locala.Xgy.fj(0, locala.Xgx.ikC().length());
                          locala.Xgy.ief();
                          locala.Xgy.iei();
                        } while (locala.Xgy.Ywy == null);
                        locala.Xgy.Ywy.hTK();
                        AppMethodBeat.o(180013);
                        return;
                        paramAnonymousMenuItem = (by)locala.Xgx.getTag();
                      } while (paramAnonymousMenuItem == null);
                      paramAnonymousMenuItem = bs.T(paramAnonymousMenuItem.fNz);
                      if (Util.isNullOrNil(paramAnonymousMenuItem))
                      {
                        localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                        ((Intent)localObject1).putExtra("Retr_Msg_content", ad.b.c(ad.b.this));
                        ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                        paramAnonymousMenuItem = paramString;
                        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(180013);
                        return;
                      }
                      com.tencent.mm.ui.base.h.a(paramString, R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(180011);
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                          paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
                          paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
                          com.tencent.mm.by.c.b(ad.b.5.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(180011);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(180012);
                          Object localObject = new Intent(ad.b.5.this.val$context, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", ad.b.c(ad.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymous2DialogInterface = ad.b.5.this.val$context;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(180012);
                        }
                      });
                      AppMethodBeat.o(180013);
                      return;
                      paramAnonymousMenuItem = new dd();
                      j.b(paramAnonymousMenuItem, ad.b.c(ad.b.this).toString(), 1);
                      paramAnonymousMenuItem.fyI.fragment = ad.b.d(ad.b.this).WQv;
                      paramAnonymousMenuItem.fyI.fyP = 43;
                      if (paramAnonymousMenuItem.fyI.fyK != null)
                      {
                        localObject1 = paramAnonymousMenuItem.fyI.fyK.SAB;
                        if (localObject1 != null)
                        {
                          localObject2 = (by)locala.Xgx.getTag();
                          if (localObject2 != null)
                          {
                            ((aoi)localObject1).btx(((by)localObject2).fNz.field_talker);
                            ((aoi)localObject1).bty(z.bcZ());
                            EventCenter.instance.publish(paramAnonymousMenuItem);
                          }
                        }
                      }
                    } while (locala.Xgy == null);
                    locala.Xgy.cpn();
                    locala.Xgy.YwE = true;
                    locala.Xgy.YwF = true;
                    locala.Xgy.cpq();
                    AppMethodBeat.o(180013);
                    return;
                  }
                  paramAnonymousMenuItem = "65_" + cm.bfE();
                  Object localObject1 = ad.b.c(ad.b.this).toString();
                  Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
                  ad.b localb = ad.b.this;
                  com.tencent.mm.ui.chatting.e.a locala = parama1;
                  ca localca = paramca;
                  if (!Util.isNullOrNil((String)localObject2)) {}
                  for (boolean bool = true;; bool = false)
                  {
                    localb.a(locala, localca, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                    localObject2 = new ag();
                    ((ag)localObject2).context = paramString;
                    ((ag)localObject2).scene = 65;
                    ((ag)localObject2).query = ((String)localObject1);
                    ((ag)localObject2).sessionId = paramAnonymousMenuItem;
                    ((ag)localObject2).PyA = true;
                    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject2);
                    break;
                  }
                }
              };
            }
            if ((bs.D(paramca)) || (bs.O(paramca))) {
              break label1569;
            }
            j = bs.U(paramca);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.iX(locala.Xgx).length())) {
              break label1677;
            }
            j = 0;
          }
        }
      }
      label1677:
      for (;;)
      {
        paramString = c(parama1);
        localObject1 = a(paramString);
        if (locala.Xgy != null) {
          locala.Xgy.destroy();
        }
        Object localObject2 = new int[2];
        i = 0;
        if (locala.Xgx != null)
        {
          locala.Xgx.getLocationInWindow((int[])localObject2);
          int k = localObject2[0];
          i = k;
          if (k == 0)
          {
            localObject2 = new Rect();
            locala.Xgx.getGlobalVisibleRect((Rect)localObject2);
            i = ((Rect)localObject2).left;
          }
        }
        for (;;)
        {
          localObject1 = new a.a(locala.Xgx, locala.AYp, (a.f)localObject1, hTQ(), locala.Xgz);
          ((a.a)localObject1).YnW = R.e.selected_blue;
          ((a.a)localObject1).YwO = 18;
          ((a.a)localObject1).YnX = R.e.cursor_handle_color;
          if (i != 0) {
            ((a.a)localObject1).YwP = (aw.aZ(locala.Xgx.getContext(), R.f.Edge_2A) + i);
          }
          locala.Xgy = ((a.a)localObject1).iel();
          locala.XgA = new ad.d(locala.Xgy);
          locala.Xgy.Yww = new ad.b.6(this);
          locala.Xcj = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180015);
              locala.Xgy.cpn();
              locala.Xgy.YwE = true;
              locala.Xgy.YwF = true;
              locala.Xgy.cpq();
              AppMethodBeat.o(180015);
            }
          };
          paramString.Xcj = locala.Xcj;
          locala.Xgy.YwC = j;
          locala.Xgy.YwK = locala.XgA;
          label937:
          locala.Xgx.setOnDoubleClickListener(this);
          locala.Xgx.setTag(parama);
          locala.Xgx.setTextListener(new MMNeat7extView.a()
          {
            public final void aI(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180016);
              if (((Boolean)locala.Xgx.getTag(ad.b.XgF)).booleanValue())
              {
                com.tencent.mm.ui.chatting.n.a.a.hTq();
                com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)locala.Xgx.getTag(ad.b.XgE)).longValue());
              }
              AppMethodBeat.o(180016);
            }
          });
          locala.Xgx.setMaxLines(2147483647);
          paramString = ChattingItemTranslate.c.Xlo;
          if (com.tencent.mm.app.plugin.d.abP()) {
            if ((paramca.hzO()) && (paramca.hzW()))
            {
              parama = paramca.field_transContent;
              label1017:
              paramString = ((av)parama1.bC(av.class)).cC(paramca);
            }
          }
          for (;;)
          {
            if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.Xlo))
            {
              if ((locala.XgC == null) && (locala.XgB != null))
              {
                locala.XgC = ((ChattingItemTranslate)locala.XgB.inflate());
                locala.XgC.init();
              }
              localObject2 = locala.Xgx.getContext();
              i = (int)locala.Xgx.getTextSize();
              if (paramca != null)
              {
                localObject1 = ad.Rp(paramca.field_msgSvrId);
                com.tencent.mm.model.ad.b localb = ad.beh().I((String)localObject1, true);
                localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
                localb.k("preUsername", a(this.WBq, paramca));
                localb.k("preChatName", b(this.WBq, paramca));
                label1218:
                localObject1 = l.a((Context)localObject2, parama, i, null, (String)localObject1);
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject1 });
                locala.XgC.a((CharSequence)localObject1, paramString);
                localObject1 = locala.XgC;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1630;
                }
              }
              label1569:
              label1630:
              for (paramString = parama1.WQv.getMMResources().getString(R.l.eUq);; paramString = paramca.field_transBrandWording)
              {
                ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                if (!Util.isNullOrNil(parama))
                {
                  parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                  parama.XmM = false;
                  parama.viewType = 2;
                  locala.XgC.setTag(parama);
                  locala.XgC.setOnClickListener(hTQ());
                  locala.XgC.setOnDoubleClickListener(this);
                  locala.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                  locala.XgC.setOnLongClickListener(c(parama1));
                  locala.XgC.setVisibility(0);
                }
                AppMethodBeat.o(37014);
                return;
                locala.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.normal_text));
                locala.XgU.setBackgroundResource(R.g.doc);
                break;
                if (bool)
                {
                  locala.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.BW_0_Alpha_0_2));
                  locala.XgU.setBackgroundResource(R.g.dob);
                  break;
                }
                locala.wRL.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.desc_text));
                locala.XgU.setBackgroundResource(R.g.doa);
                break;
                label1532:
                if (Util.isNullOrNil((CharSequence)paramString.second)) {
                  locala.wRL.setVisibility(8);
                }
                locala.clickArea.setVisibility(8);
                break label399;
                locala.Xgx.setTag(XgD, Boolean.FALSE);
                locala.Xgx.setOnTouchListener(locala.Xgz);
                locala.Xgx.setOnLongClickListener(c(parama1));
                locala.Xgx.setOnClickListener(hTQ());
                break label937;
                localObject1 = null;
                break label1218;
              }
            }
            if (locala.XgC != null) {
              locala.XgC.setVisibility(8);
            }
            AppMethodBeat.o(37014);
            return;
            parama = null;
            break label1017;
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
      paramMenuItem = k.b.OQ(bq.b(parama.hRh(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
      com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((av)parama.bC(av.class)).b(paramMenuItem, paramca);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = paramca.field_transContent;
      if (!Util.isNullOrNil(paramMenuItem)) {
        ClipboardHelper.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
      AppMethodBeat.o(37016);
      return true;
    case 142: 
      localObject = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem = paramca.field_transContent;
      if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
      {
        i = bq.RI(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramca.hzt())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      localObject = new dd();
      paramMenuItem = paramca.field_transContent;
      if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
      {
        i = bq.RI(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        j.b((dd)localObject, paramMenuItem, 1);
        ((dd)localObject).fyI.fragment = parama.WQv;
        ((dd)localObject).fyI.fyP = 43;
        if (((dd)localObject).fyI.fyK != null)
        {
          paramMenuItem = ((dd)localObject).fyI.fyK.SAB;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.btx(paramca.field_talker);
          paramMenuItem.bty(z.bcZ());
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(37016);
          return true;
        }
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(224486);
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.viewType == 1)
    {
      if (!bs.O(paramca))
      {
        paramo.a(i, 102, this.WBq.WQv.getMMResources().getString(R.l.evK), R.k.icons_filled_copy);
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(i, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType())) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if ((com.tencent.mm.app.plugin.d.abP()) && ((!paramca.hzO()) || (!paramca.hzW()))) {
        paramo.a(i, 124, paramView.getContext().getString(R.l.ewi), R.k.icons_filled_translate);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      if (bs.D(paramca))
      {
        paramo.clear();
        if (!this.WBq.hRj()) {
          paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
        }
      }
    }
    while (locala.viewType != 2)
    {
      AppMethodBeat.o(224486);
      return true;
    }
    Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
    paramo.a(i, 141, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
    paramo.a(i, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    if (com.tencent.mm.by.c.blP("favorite")) {
      paramo.a(i, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (com.tencent.mm.app.plugin.d.abP())
    {
      if ((paramca.hzO()) && (paramca.hzW())) {
        paramo.a(i, 124, paramView.getContext().getString(R.l.ewg), R.k.icons_filled_eyes_off);
      }
      if (paramca.hzZ()) {
        paramo.a(i, 125, paramView.getContext().getString(R.l.evZ), R.k.icons_filled_refresh);
      }
    }
    AppMethodBeat.o(224486);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  public final boolean ie(View paramView)
  {
    AppMethodBeat.i(37017);
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (by)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).ikC();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((by)localObject2).fNz.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      if (this.WBq != null) {
        ((Intent)localObject1).putExtra("is_group_chat", this.WBq.hRi());
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.la(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.b
 * JD-Core Version:    0.7.0.1
 */