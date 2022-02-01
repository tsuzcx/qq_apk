package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
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
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.b.a.kh;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.x;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class bi
{
  private static final int XgE = R.h.dyq;
  private static final int XgF = R.h.dyp;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.e.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, ca paramca, int paramInt)
  {
    AppMethodBeat.i(272135);
    y.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, paramca, paramInt);
    AppMethodBeat.o(272135);
  }
  
  public static void a(boolean paramBoolean, f paramf, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(180039);
    if (paramf == null)
    {
      AppMethodBeat.o(180039);
      return;
    }
    if (paramBoolean)
    {
      paramf.Xet.setBackgroundResource(R.g.dmS);
      paramf.Xeu.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.BW_100_Alpha_0_8));
      paramf.Xeu.setText(R.l.eGp);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.Xet.setBackgroundResource(R.g.dmT);
    paramf.Xeu.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.Brand));
    paramf.Xeu.setText(R.l.eGq);
    AppMethodBeat.o(180039);
  }
  
  public static Bundle dg(ca paramca)
  {
    AppMethodBeat.i(272137);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msgSvrId", paramca.field_msgSvrId);
    AppMethodBeat.o(272137);
    return localBundle;
  }
  
  public static class a
    extends c
    implements NeatTextView.b
  {
    private static final int XgD = R.h.dVZ;
    private static final int XgE = R.h.dyq;
    private static final int XgF = R.h.dyp;
    private com.tencent.mm.ui.chatting.e.a WBq;
    private CharSequence WEv;
    private int XcC = -1;
    private bi.e XkS;
    private int jNq = -1;
    
    private String dh(ca paramca)
    {
      AppMethodBeat.i(37397);
      if (paramca != null)
      {
        String str = ad.Rp(paramca.field_msgSvrId);
        ad.b localb = ad.beh().I(str, true);
        localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
        localb.k("preUsername", a(this.WBq, paramca));
        localb.k("preChatName", b(this.WBq, paramca));
        AppMethodBeat.o(37397);
        return str;
      }
      AppMethodBeat.o(37397);
      return null;
    }
    
    private bi.e hTU()
    {
      AppMethodBeat.i(37393);
      if (this.XkS == null) {
        this.XkS = new bi.e(this.WBq);
      }
      bi.e locale = this.XkS;
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
        localObject = new aq(paramLayoutInflater, R.i.ecF);
        ((View)localObject).setTag(new bi.f().J((View)localObject, true));
      }
      AppMethodBeat.o(37394);
      return localObject;
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37396);
      this.WBq = parama1;
      final bi.f localf = (bi.f)parama;
      Object localObject2 = paramca.field_content;
      paramString = parama1.getTalkerUserName();
      localf.XkW.setTag(XgE, Long.valueOf(paramca.field_msgId));
      localf.XkW.setTag(XgF, Boolean.TRUE);
      parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
      localf.XkW.setTag(parama);
      ChattingItemTranslate.c localc = ChattingItemTranslate.c.Xlo;
      if (com.tencent.mm.app.plugin.d.abP()) {
        if ((paramca.hzO()) && (paramca.hzW()))
        {
          parama = paramca.field_transContent;
          localc = ((av)parama1.bC(av.class)).cC(paramca);
        }
      }
      for (;;)
      {
        int i;
        Object localObject1;
        if ((parama1.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
        {
          i = bq.RI((String)localObject2);
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
          a(localf, parama1, paramca, (String)localObject1);
          a(localf, parama1, (String)localObject1, paramca);
          int j;
          Bundle localBundle;
          int k;
          boolean bool;
          if ((paramca.hxy != null) && ((paramca.hAk()) || (paramca.hAl())))
          {
            j = 1;
            parama = com.tencent.mm.ui.chatting.m.a.WZH;
            com.tencent.mm.ui.chatting.m.a.a.a(localf.XkW, paramca, parama1.hRi(), (String)localObject1);
            parama = t.ap(parama1.hRi(), com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
            localBundle = bi.dg(paramca);
            localBundle.putAll(parama);
            parama = null;
            k = 1;
            if (bs.Q(paramca)) {
              break label1148;
            }
            bool = true;
            label349:
            if (j != 0) {
              break label1207;
            }
            if (!as.bvK((String)localObject1)) {
              break label1154;
            }
            parama = l.a(localf.XkW.getContext(), (CharSequence)localObject2, (int)localf.XkW.getTextSize(), localBundle, dh(paramca), l.Rsm, bool);
            label398:
            localObject1 = (an)parama1.bC(an.class);
            if (!((an)localObject1).VL(paramca.field_msgId)) {
              break label1764;
            }
            localObject1 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, ((an)localObject1).hQr(), e.a.BIj, b.b.BLQ));
            localf.XkW.a(((com.tencent.mm.plugin.fts.a.a.f)localObject1).BIp, TextView.BufferType.SPANNABLE);
          }
          label538:
          label861:
          label1764:
          for (i = 0;; i = 1)
          {
            localObject1 = (p[])parama.getSpans(0, parama.length(), p.class);
            k = localObject1.length;
            j = 0;
            label491:
            if (j < k) {
              if (localObject1[j].getType() == 44)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(7), "" });
                if (i != 0) {
                  bi.a(localf.XkW.getContext(), parama1, paramca.field_content, parama, localf.XkW, paramca, 1);
                }
                if (!com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
                  break label1411;
                }
                localf.wRL.setText(parama1.WQv.getMMResources().getString(R.l.eGo));
                localf.wRL.setVisibility(0);
                localf.wRL.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37383);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    Log.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { localf.XkW.getTag(bi.a.fdJ()) });
                    s.a(parama1, ((Long)localf.XkW.getTag(bi.a.fdJ())).longValue(), 1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37383);
                  }
                });
                label626:
                bi.a(paramca, localf, parama1);
                localObject1 = localf.XkW.getContext();
                localf.XkW.setTag(XgD, Boolean.TRUE);
                if (localf.AYp == null)
                {
                  localf.AYp = new com.tencent.mm.ui.widget.b.a((Context)localObject1, localf.XkW);
                  localf.AYp.XVa = new PopupWindow.OnDismissListener()
                  {
                    public final void onDismiss()
                    {
                      AppMethodBeat.i(180024);
                      parama1.Y(true);
                      c.a(localf.AYp, parama1, bi.a.a(bi.a.this), bi.a.b(bi.a.this), 1);
                      bi.a.a(bi.a.this, -1);
                      bi.a.b(bi.a.this, -1);
                      AppMethodBeat.o(180024);
                    }
                  };
                  localf.AYp.Yri = true;
                  localf.AYp.Yrl = false;
                  localf.AYp.Yrg = new q.e()
                  {
                    public final void a(com.tencent.mm.ui.base.o paramAnonymouso, View paramAnonymousView)
                    {
                      boolean bool = false;
                      AppMethodBeat.i(195817);
                      paramAnonymouso.clear();
                      paramAnonymouso.a(0, 0, this.val$context.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                      paramAnonymousView = localf.XkW.ikC();
                      Object localObject = (by)localf.XkW.getTag();
                      if (localObject != null) {}
                      for (int i = bs.U(((by)localObject).fNz);; i = 0)
                      {
                        if ((i <= 0) || (i >= paramAnonymousView.length())) {
                          paramAnonymouso.a(0, 1, this.val$context.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                        }
                        paramAnonymouso.a(0, 2, this.val$context.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                        paramAnonymouso.a(0, 3, this.val$context.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                        paramAnonymouso.a(0, 4, this.val$context.getResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
                        paramAnonymouso = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bi.a.c(bi.a.this).toString());
                        if (!Util.isNullOrNil(paramAnonymouso)) {
                          bi.a.this.a(localf.AYp, parama1, paramAnonymouso);
                        }
                        if (Util.isNullOrNil(paramAnonymouso)) {
                          localf.AYp.Yrp = null;
                        }
                        paramAnonymousView = "65_" + cm.bfE();
                        localObject = bi.a.this;
                        com.tencent.mm.ui.chatting.e.a locala = parama1;
                        ca localca = paramca;
                        if (!Util.isNullOrNil(paramAnonymouso)) {
                          bool = true;
                        }
                        ((bi.a)localObject).a(locala, localca, 1, bool, bi.a.c(bi.a.this).toString(), true, paramAnonymousView, 3);
                        AppMethodBeat.o(195817);
                        return;
                      }
                    }
                  };
                  localf.AYp.ODU = new q.g()
                  {
                    public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(180028);
                      bi.a.b(bi.a.this, paramAnonymousMenuItem.getItemId());
                      bi.a.a(bi.a.this, paramAnonymousInt);
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
                                ClipboardHelper.setText(MMApplicationContext.getContext(), bi.a.c(bi.a.this), bi.a.c(bi.a.this));
                                if (localf.Xgy != null)
                                {
                                  localf.Xgy.cpn();
                                  localf.Xgy.YwE = true;
                                  localf.Xgy.YwF = true;
                                  localf.Xgy.cpq();
                                }
                                Toast.makeText(this.val$context, R.l.app_copy_ok, 0).show();
                                try
                                {
                                  paramAnonymousMenuItem = (by)localf.XkW.getTag();
                                  if (paramAnonymousMenuItem != null)
                                  {
                                    localObject1 = ((av)parama1.bC(av.class)).g(paramAnonymousMenuItem.fNz, false);
                                    localObject2 = new kh();
                                    ((kh)localObject2).gMN = paramAnonymousMenuItem.fNz.field_msgSvrId;
                                    ((kh)localObject2).gMP = ((String)localObject1).length();
                                    ((kh)localObject2).gMO = bi.a.c(bi.a.this).length();
                                    ((kh)localObject2).gMQ = bs.U(paramAnonymousMenuItem.fNz);
                                    ((kh)localObject2).bpa();
                                    bi.c(paramAnonymousMenuItem.fNz, 3, bi.a.c(bi.a.this).length());
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
                              } while (localf.Xgy == null);
                              if (localf.Xgy.Ywy != null) {
                                localf.Xgy.Ywy.hTJ();
                              }
                              localf.Xgy.YwE = true;
                              localf.Xgy.cpq();
                              localf.Xgy.fj(0, localf.XkW.ikC().length());
                              localf.Xgy.ief();
                              localf.Xgy.iei();
                            } while (localf.Xgy.Ywy == null);
                            localf.Xgy.Ywy.hTK();
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = (by)localf.XkW.getTag();
                          } while (paramAnonymousMenuItem == null);
                          bi.c(paramAnonymousMenuItem.fNz, 4, 0);
                          paramAnonymousMenuItem = bs.T(paramAnonymousMenuItem.fNz);
                          if (Util.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                            ((Intent)localObject1).putExtra("Retr_Msg_content", bi.a.c(bi.a.this));
                            ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = this.val$context;
                            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180028);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                          com.tencent.mm.ui.base.h.a(this.val$context, R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180026);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
                              com.tencent.mm.by.c.b(bi.a.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(1), paramAnonymousMenuItem });
                              AppMethodBeat.o(180026);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180027);
                              Object localObject = new Intent(bi.a.4.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", bi.a.c(bi.a.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = bi.a.4.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramAnonymousMenuItem });
                              AppMethodBeat.o(180027);
                            }
                          });
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = new dd();
                          com.tencent.mm.pluginsdk.model.j.b(paramAnonymousMenuItem, bi.a.c(bi.a.this).toString(), 1);
                          paramAnonymousMenuItem.fyI.fragment = bi.a.d(bi.a.this).WQv;
                          paramAnonymousMenuItem.fyI.fyP = 43;
                          if (paramAnonymousMenuItem.fyI.fyK != null)
                          {
                            localObject1 = paramAnonymousMenuItem.fyI.fyK.SAB;
                            if (localObject1 != null)
                            {
                              localObject2 = (by)localf.XkW.getTag();
                              if (localObject2 != null)
                              {
                                bi.c(((by)localObject2).fNz, 5, 0);
                                ((aoi)localObject1).btx(((by)localObject2).fNz.field_talker);
                                ((aoi)localObject1).bty(z.bcZ());
                                EventCenter.instance.publish(paramAnonymousMenuItem);
                              }
                            }
                          }
                        } while (localf.Xgy == null);
                        localf.Xgy.cpn();
                        localf.Xgy.YwE = true;
                        localf.Xgy.YwF = true;
                        localf.Xgy.cpq();
                        AppMethodBeat.o(180028);
                        return;
                      }
                      paramAnonymousMenuItem = "65_" + cm.bfE();
                      Object localObject1 = bi.a.c(bi.a.this).toString();
                      Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
                      bi.a locala = bi.a.this;
                      com.tencent.mm.ui.chatting.e.a locala1 = parama1;
                      ca localca = paramca;
                      if (!Util.isNullOrNil((String)localObject2)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        locala.a(locala1, localca, 2, bool, (String)localObject1, true, paramAnonymousMenuItem, 3);
                        localObject2 = new ag();
                        ((ag)localObject2).context = this.val$context;
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
                bi.a(parama1, bs.V(paramca), parama, localf.XkW, bool);
                if ((!bs.D(paramca)) && (!bs.L(paramca)) && (!bs.O(paramca))) {
                  break label1424;
                }
                localf.XkW.setTag(XgD, Boolean.FALSE);
                localf.XkW.setOnTouchListener(localf.Xgz);
                localf.XkW.setOnLongClickListener(c(parama1));
                localf.XkW.setOnClickListener(hTU());
                localf.XkW.setOnDoubleClickListener(this);
                localf.XkW.setTextListener(new MMNeat7extView.a()
                {
                  public final void aI(CharSequence paramAnonymousCharSequence)
                  {
                    AppMethodBeat.i(180031);
                    if (((Boolean)localf.XkW.getTag(bi.a.fdI())).booleanValue())
                    {
                      com.tencent.mm.ui.chatting.n.a.a.hTq();
                      com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)localf.XkW.getTag(bi.a.fdJ())).longValue());
                    }
                    AppMethodBeat.o(180031);
                  }
                });
                if ((Util.isNullOrNil(paramString)) && (localc == ChattingItemTranslate.c.Xlo)) {
                  break label1740;
                }
                if (localf.XgC == null)
                {
                  localf.XgC = ((ChattingItemTranslate)localf.XgB.inflate());
                  localf.XgC.init();
                }
                parama = l.a(localf.XkW.getContext(), paramString, (int)localf.XkW.getTextSize(), localBundle, dh(paramca));
                localf.XgC.a(parama, localc);
                localObject1 = localf.XgC;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1731;
                }
              }
            }
            for (parama = parama1.WQv.getMMResources().getString(R.l.eUq);; parama = paramca.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject1).setBrandWording(parama);
              if (!Util.isNullOrNil(paramString))
              {
                parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                parama.XmM = false;
                parama.viewType = 2;
                localf.XgC.setTag(parama);
                localf.XgC.getContentView().setTag(parama);
                localf.XgC.setOnClickListener(hTU());
                localf.XgC.setOnDoubleClickListener(this);
                localf.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                localf.XgC.setOnLongClickListener(c(parama1));
                localf.XgC.setVisibility(0);
              }
              AppMethodBeat.o(37396);
              return;
              j = 0;
              break;
              label1148:
              bool = false;
              break label349;
              parama = l.a(localf.XkW.getContext(), (CharSequence)localObject2, (int)localf.XkW.getTextSize(), 1, localBundle, dh(paramca), 0, l.Rsm, bool);
              break label398;
              j += 1;
              break label491;
              break label538;
              i = k;
              if (j == 0) {
                break label538;
              }
              if (paramca.hxy.contains("notify@all")) {}
              for (parama = "";; parama = localf.XkW.getContext().getString(R.l.eRn) + "\n")
              {
                localBundle.putInt("geta8key_scene", 31);
                if (!as.bvK((String)localObject1)) {
                  break label1349;
                }
                parama = l.a(localf.XkW.getContext(), parama + localObject2, (int)localf.XkW.getTextSize(), localBundle, dh(paramca), l.Rsm, bool);
                i = k;
                break;
              }
              parama = l.a(localf.XkW.getContext(), parama + localObject2, (int)localf.XkW.getTextSize(), 1, localBundle, dh(paramca), 0, l.Rsm, bool);
              i = k;
              break label538;
              localf.wRL.setVisibility(8);
              break label626;
              i = bs.U(paramca);
              if (i > 0)
              {
                j = i;
                if (i < com.tencent.mm.ui.widget.textview.b.iX(localf.XkW).length()) {}
              }
              else
              {
                j = 0;
              }
              parama = c(parama1);
              localObject1 = a(parama);
              if (localf.Xgy != null) {
                localf.Xgy.destroy();
              }
              localObject2 = new int[2];
              i = 0;
              if (localf.XkW != null)
              {
                localf.XkW.getLocationInWindow((int[])localObject2);
                k = localObject2[0];
                i = k;
                if (k == 0)
                {
                  localObject2 = new Rect();
                  localf.XkW.getGlobalVisibleRect((Rect)localObject2);
                  i = ((Rect)localObject2).left;
                }
              }
              localObject1 = new com.tencent.mm.ui.widget.textview.a.a(localf.XkW, localf.AYp, (a.f)localObject1, hTU(), localf.Xgz);
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnW = R.e.selected_blue;
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwO = 18;
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnX = R.e.cursor_handle_color;
              if (i != 0) {
                ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwP = (i + aw.aZ(localf.XkW.getContext(), R.f.Edge_2A));
              }
              localf.Xgy = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).iel();
              localf.XgA = new bi.d(localf.Xgy);
              localf.Xgy.Yww = new bi.a.5(this);
              localf.Xcj = new a.f()
              {
                public final void dismiss()
                {
                  AppMethodBeat.i(180030);
                  localf.Xgy.cpn();
                  localf.Xgy.YwE = true;
                  localf.Xgy.YwF = true;
                  localf.Xgy.cpq();
                  AppMethodBeat.o(180030);
                }
              };
              parama.Xcj = localf.Xcj;
              localf.Xgy.YwC = j;
              localf.Xgy.YwK = localf.XgA;
              break label861;
            }
            if (localf.XgC != null) {
              localf.XgC.setVisibility(8);
            }
            AppMethodBeat.o(37396);
            return;
          }
          label1154:
          label1207:
          label1349:
          label1740:
          paramString = parama;
          label1411:
          label1424:
          label1731:
          continue;
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
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, by paramby)
    {
      AppMethodBeat.i(37399);
      if (paramby == null)
      {
        AppMethodBeat.o(37399);
        return false;
      }
      ca localca = paramby.fNz;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37399);
        return false;
      case 141: 
        paramMenuItem = localca.field_transContent;
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
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
        AppMethodBeat.o(37399);
        return true;
        paramby = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        paramMenuItem = localca.field_transContent;
        if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
        {
          i = bq.RI(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          if (localca.hzt())
          {
            paramby.putExtra("Retr_Msg_content", paramMenuItem);
            paramby.putExtra("Retr_Msg_Type", 6);
          }
          for (;;)
          {
            paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramby);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramMenuItem.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37399);
            return true;
            paramby.putExtra("Retr_Msg_content", paramMenuItem);
            paramby.putExtra("Retr_Msg_Type", 4);
          }
          dd localdd = new dd();
          Object localObject = localca.field_transContent;
          if ((parama.hRi()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
          {
            i = bq.RI((String)localObject);
            if (i != -1) {
              localObject = ((String)localObject).substring(i + 1).trim();
            }
          }
          for (;;)
          {
            com.tencent.mm.pluginsdk.model.j.b(localdd, (String)localObject, 1);
            localdd.fyI.fragment = parama.WQv;
            localdd.fyI.fyP = 43;
            if (localdd.fyI.fyK != null)
            {
              localObject = localdd.fyI.fyK.SAB;
              if (localObject != null)
              {
                ((aoi)localObject).btx(localca.field_talker);
                ((aoi)localObject).bty(z.bcZ());
                EventCenter.instance.publish(localdd);
              }
              localObject = ((av)parama.bC(av.class)).g(((ChattingItemTranslate.a)paramby).fNz, false);
              paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
              if (localObject != null) {
                break label820;
              }
              i = 0;
              label626:
              Log.d("MicroMsg.ChattingItemTextFrom", i);
            }
            for (;;)
            {
              try
              {
                if ((bs.V(localca) < 2) || (Util.isNullOrNil(((ChattingItemTranslate.a)paramby).Xlk))) {
                  break label1167;
                }
                paramMenuItem = ((ChattingItemTranslate.a)paramby).Xlk;
              }
              catch (Exception paramMenuItem)
              {
                for (;;)
                {
                  try
                  {
                    ClipboardHelper.setText(paramMenuItem);
                    bi.c(localca, 3, paramMenuItem.length());
                    com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
                    parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
                    com.tencent.mm.plugin.secinforeport.a.a.s(1, localca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem.toString()));
                  }
                  catch (Exception paramby)
                  {
                    label820:
                    continue;
                  }
                  try
                  {
                    parama = new kh();
                    parama.gMN = localca.field_msgSvrId;
                    parama.gMP = paramMenuItem.length();
                    parama.gMO = this.WEv.length();
                    parama.gMQ = bs.U(localca);
                    parama.bpa();
                    AppMethodBeat.o(37399);
                    return true;
                    Log.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                    break;
                    i = ((CharSequence)localObject).length();
                    break label626;
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
              bi.c(localca, 4, 0);
              paramMenuItem = bs.T(localca);
              if (Util.isNullOrNil(paramMenuItem))
              {
                paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
                paramby = ((av)parama.bC(av.class)).g(localca, false);
                if (localca.hzt())
                {
                  paramMenuItem.putExtra("Retr_Msg_content", paramby);
                  paramMenuItem.putExtra("Retr_Msg_Type", 6);
                }
                for (;;)
                {
                  paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
                  com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  parama.startActivity((Intent)paramMenuItem.sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  break;
                  paramMenuItem.putExtra("Retr_Msg_content", paramby);
                  paramMenuItem.putExtra("Retr_Msg_Type", 4);
                }
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
              com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new bi.a.8(this, paramMenuItem, parama), new bi.a.9(this, parama, localca, paramMenuItem));
              break;
              ((av)parama.bC(av.class)).b(paramMenuItem, localca);
              break;
              s.a(parama, localca.field_msgId, 2);
              AppMethodBeat.o(37399);
              return false;
              label1167:
              paramMenuItem = (MenuItem)localObject;
            }
          }
        }
      }
    }
    
    public boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(274182);
      if ((!paramca.hwH()) && (!paramca.hzt()))
      {
        AppMethodBeat.o(274182);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.viewType == 1)
      {
        if (paramca.hwH())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
            paramo.a(i, 151, this.WBq.WQv.getMMResources().getString(R.l.eGn), R.k.icons_filled_continued_form);
          }
          if ((!bs.L(paramca)) && (!bs.O(paramca))) {
            paramo.a(i, 102, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
          }
        }
        if ((!bs.L(paramca)) && (!bs.O(paramca))) {
          paramo.a(i, 108, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType())) {
          paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if ((paramca.hwH()) && (g.biX())) {
          this.WBq.hRj();
        }
        if (!this.WBq.hRj()) {
          paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
        }
        if ((com.tencent.mm.app.plugin.d.abP()) && ((!paramca.hzO()) || (!paramca.hzW()))) {
          paramo.a(i, 124, paramView.getContext().getString(R.l.ewi), R.k.icons_filled_translate);
        }
        if ((bs.D(paramca)) || (bs.V(paramca) == 4))
        {
          paramo.clear();
          if (!this.WBq.hRj()) {
            paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
          }
        }
      }
      while (locala.viewType != 2)
      {
        AppMethodBeat.o(274182);
        return true;
      }
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
      AppMethodBeat.o(274182);
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37395);
      boolean bool = parama.hRi();
      AppMethodBeat.o(37395);
      return bool;
    }
    
    public boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37400);
      if ((paramView instanceof MMTextView))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.n.a.a.hTq();
        com.tencent.mm.ui.chatting.n.a.a.a(paramView.getText(), paramca);
      }
      AppMethodBeat.o(37400);
      return true;
    }
    
    public final boolean hTD()
    {
      return false;
    }
    
    protected boolean hTE()
    {
      return false;
    }
    
    public final boolean ie(View paramView)
    {
      AppMethodBeat.i(37401);
      if (y.ic(paramView))
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
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.fNz.field_msgId);
        if (((x)this.WBq.bC(x.class)).cx(locala.fNz))
        {
          localObject1 = ((MMNeat7extView)paramView).ikC().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          ((Intent)localObject2).putExtra("is_group_chat", this.WBq.hRi());
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.la(paramView.getContext());
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(locala.fNz.field_talker);
        }
      }
      else
      {
        AppMethodBeat.o(37401);
        return true;
      }
      Object localObject1 = (av)this.WBq.bC(av.class);
      ca localca = locala.fNz;
      if (locala.viewType == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((av)localObject1).g(localca, bool);
        break;
      }
    }
  }
  
  public static class b
    extends c
    implements t.n, NeatTextView.b
  {
    private static final int XgD = R.h.dVZ;
    private com.tencent.mm.ui.chatting.e.a WBq;
    private CharSequence WEv;
    private int XcC = -1;
    private bi.e XkS;
    private int jNq = -1;
    
    private void ce(ca paramca)
    {
      AppMethodBeat.i(37411);
      if (!this.WBq.getTalkerUserName().equals("medianote"))
      {
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.ce(paramca);
      this.WBq.Gi(true);
      AppMethodBeat.o(37411);
    }
    
    private String dh(ca paramca)
    {
      AppMethodBeat.i(37412);
      if (paramca != null)
      {
        String str = ad.Rp(paramca.field_msgSvrId);
        ad.b localb = ad.beh().I(str, true);
        localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
        localb.k("preUsername", a(this.WBq, paramca));
        localb.k("preChatName", b(this.WBq, paramca));
        AppMethodBeat.o(37412);
        return str;
      }
      AppMethodBeat.o(37412);
      return null;
    }
    
    private bi.e hTU()
    {
      AppMethodBeat.i(37408);
      if (this.XkS == null) {
        this.XkS = new bi.e(this.WBq);
      }
      bi.e locale = this.XkS;
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
        localObject = new aq(paramLayoutInflater, R.i.edG);
        ((View)localObject).setTag(new bi.f().J((View)localObject, false));
      }
      AppMethodBeat.o(37409);
      return localObject;
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(37410);
      this.WBq = parama1;
      final bi.f localf = (bi.f)parama;
      localf.XkW.setTag(bi.XgE, Long.valueOf(paramca.field_msgId));
      localf.XkW.setTag(bi.XgF, Boolean.TRUE);
      localf.XkW.setMaxLines(2147483647);
      parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
      parama.XmM = false;
      localf.XkW.setTag(parama);
      Object localObject2;
      label231:
      Object localObject1;
      boolean bool;
      if (hTG())
      {
        b(localf, false);
        if ((paramca.field_status == 1) || (paramca.field_status == 5))
        {
          if (localf.XdI != null) {
            localf.XdI.setVisibility(8);
          }
          localf.XkW.setBackgroundResource(R.g.dnl);
          paramca.VGB = true;
          localObject2 = paramca.field_content;
          if (Util.isNullOrNil((String)localObject2)) {
            Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
          }
          if ((paramca.hxy == null) || ((!paramca.hAk()) && (!paramca.hAl()))) {
            break label1294;
          }
          i = 1;
          parama = com.tencent.mm.ui.chatting.m.a.WZH;
          com.tencent.mm.ui.chatting.m.a.a.a(localf.XkW, paramca, parama1.hRi(), paramString);
          parama = t.ap(parama1.hRi(), com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
          localObject1 = bi.dg(paramca);
          ((Bundle)localObject1).putAll(parama);
          if (bs.Q(paramca)) {
            break label1300;
          }
          bool = true;
          label291:
          if (i != 0) {
            break label1315;
          }
          paramString = l.a(localf.XkW.getContext(), (CharSequence)localObject2, (int)localf.XkW.getTextSize(), 4, localObject1, dh(paramca), 0, l.Rsm, bool);
          parama = (an)parama1.bC(an.class);
          if (!parama.VL(paramca.field_msgId)) {
            break label1806;
          }
          parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(paramString, parama.hQr(), e.a.BIj, b.b.BLR));
          localf.XkW.a(parama.BIp, TextView.BufferType.SPANNABLE);
        }
      }
      label1796:
      label1801:
      label1806:
      for (int i = 0;; i = 1)
      {
        localObject2 = (p[])paramString.getSpans(0, paramString.length(), p.class);
        int m = localObject2.length;
        int j = 0;
        label426:
        int k = i;
        parama = paramString;
        if (j < m)
        {
          if (localObject2[j].getType() == 44)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(6), "" });
            parama = paramString;
            k = i;
          }
        }
        else
        {
          if (k != 0) {
            bi.a(localf.XkW.getContext(), parama1, paramca.field_content, parama, localf.XkW, paramca, 4);
          }
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
            break label1441;
          }
          localf.wRL.setText(parama1.WQv.getMMResources().getString(R.l.eGo));
          localf.wRL.setVisibility(0);
          localf.wRL.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37402);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", new Object[] { localf.XkW.getTag(bi.XgE) });
              s.a(parama1, ((Long)localf.XkW.getTag(bi.XgE)).longValue(), 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37402);
            }
          });
          label575:
          bi.a(paramca, localf, parama1);
          paramString = localf.XkW.getContext();
          localf.XkW.setTag(XgD, Boolean.TRUE);
          if (localf.AYp == null)
          {
            localf.AYp = new com.tencent.mm.ui.widget.b.a(paramString, localf.XkW);
            localf.AYp.XVa = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180033);
                parama1.Y(true);
                c.a(localf.AYp, parama1, bi.b.a(bi.b.this), bi.b.b(bi.b.this), 1);
                bi.b.a(bi.b.this, -1);
                bi.b.b(bi.b.this, -1);
                AppMethodBeat.o(180033);
              }
            };
            localf.AYp.Yri = true;
            localf.AYp.Yrl = false;
            localf.AYp.Yrg = new q.e()
            {
              public final void a(com.tencent.mm.ui.base.o paramAnonymouso, View paramAnonymousView)
              {
                boolean bool = false;
                AppMethodBeat.i(276076);
                paramAnonymouso.clear();
                paramAnonymouso.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                paramAnonymousView = localf.XkW.ikC();
                Object localObject = (by)localf.XkW.getTag();
                if (localObject != null) {}
                for (int i = bs.U(((by)localObject).fNz);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymouso.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                  }
                  paramAnonymouso.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                  paramAnonymouso.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                  paramAnonymouso.a(0, 4, paramString.getResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
                  paramAnonymouso = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bi.b.c(bi.b.this).toString());
                  if (!Util.isNullOrNil(paramAnonymouso)) {
                    bi.b.this.a(localf.AYp, parama1, paramAnonymouso);
                  }
                  if (Util.isNullOrNil(paramAnonymouso)) {
                    localf.AYp.Yrp = null;
                  }
                  paramAnonymousView = "65_" + cm.bfE();
                  localObject = bi.b.this;
                  com.tencent.mm.ui.chatting.e.a locala = parama1;
                  ca localca = paramca;
                  if (!Util.isNullOrNil(paramAnonymouso)) {
                    bool = true;
                  }
                  ((bi.b)localObject).a(locala, localca, 1, bool, bi.b.c(bi.b.this).toString(), true, paramAnonymousView, 3);
                  AppMethodBeat.o(276076);
                  return;
                }
              }
            };
            localf.AYp.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(180035);
                bi.b.a(bi.b.this, paramAnonymousInt);
                bi.b.b(bi.b.this, paramAnonymousMenuItem.getItemId());
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
                        ClipboardHelper.setText(MMApplicationContext.getContext(), bi.b.c(bi.b.this), bi.b.c(bi.b.this));
                        if (localf.Xgy != null)
                        {
                          localf.Xgy.cpn();
                          localf.Xgy.YwE = true;
                          localf.Xgy.YwF = true;
                          localf.Xgy.cpq();
                        }
                        Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                        try
                        {
                          paramAnonymousMenuItem = (by)localf.XkW.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            localObject1 = ((av)parama1.bC(av.class)).g(paramAnonymousMenuItem.fNz, false);
                            localObject2 = new kh();
                            ((kh)localObject2).gMN = paramAnonymousMenuItem.fNz.field_msgSvrId;
                            ((kh)localObject2).gMP = ((String)localObject1).length();
                            ((kh)localObject2).gMO = bi.b.c(bi.b.this).length();
                            ((kh)localObject2).gMQ = bs.U(paramAnonymousMenuItem.fNz);
                            ((kh)localObject2).bpa();
                            bi.c(paramAnonymousMenuItem.fNz, 3, bi.b.c(bi.b.this).length());
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
                      } while (localf.Xgy == null);
                      if (localf.Xgy.Ywy != null) {
                        localf.Xgy.Ywy.hTJ();
                      }
                      localf.Xgy.YwE = true;
                      localf.Xgy.cpq();
                      localf.Xgy.fj(0, localf.XkW.ikC().length());
                      localf.Xgy.ief();
                      localf.Xgy.iei();
                    } while (localf.Xgy.Ywy == null);
                    localf.Xgy.Ywy.hTK();
                    AppMethodBeat.o(180035);
                    return;
                    bi.c(paramca, 4, 0);
                    localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", bi.b.c(bi.b.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180035);
                    return;
                    bi.c(paramca, 5, 0);
                    paramAnonymousMenuItem = new dd();
                    com.tencent.mm.pluginsdk.model.j.b(paramAnonymousMenuItem, bi.b.c(bi.b.this).toString(), 1);
                    paramAnonymousMenuItem.fyI.fragment = bi.b.d(bi.b.this).WQv;
                    paramAnonymousMenuItem.fyI.fyP = 43;
                    if (paramAnonymousMenuItem.fyI.fyK != null)
                    {
                      localObject1 = paramAnonymousMenuItem.fyI.fyK.SAB;
                      if (localObject1 != null)
                      {
                        localObject2 = (by)localf.XkW.getTag();
                        if (localObject2 != null)
                        {
                          ((aoi)localObject1).btx(z.bcZ());
                          ((aoi)localObject1).bty(((by)localObject2).fNz.field_talker);
                          EventCenter.instance.publish(paramAnonymousMenuItem);
                        }
                      }
                    }
                  } while (localf.Xgy == null);
                  localf.Xgy.cpn();
                  localf.Xgy.YwE = true;
                  localf.Xgy.YwF = true;
                  localf.Xgy.cpq();
                  AppMethodBeat.o(180035);
                  return;
                }
                paramAnonymousMenuItem = "65_" + cm.bfE();
                Object localObject1 = bi.b.c(bi.b.this).toString();
                Object localObject2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject1);
                bi.b localb = bi.b.this;
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
          bi.a(parama1, bs.V(paramca), parama, localf.XkW, bool);
          if ((!bs.D(paramca)) && (!bs.L(paramca)) && (!bs.O(paramca))) {
            break label1454;
          }
          localf.XkW.setTag(XgD, Boolean.FALSE);
          localf.XkW.setOnTouchListener(localf.Xgz);
          localf.XkW.setOnLongClickListener(c(parama1));
          localf.XkW.setOnClickListener(hTU());
          label810:
          localf.XkW.setOnDoubleClickListener(this);
          localf.XkW.setTextListener(new MMNeat7extView.a()
          {
            public final void aI(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180038);
              if (((Boolean)localf.XkW.getTag(bi.XgF)).booleanValue())
              {
                com.tencent.mm.ui.chatting.n.a.a.hTq();
                com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)localf.XkW.getTag(bi.XgE)).longValue());
              }
              AppMethodBeat.o(180038);
            }
          });
          paramString = ChattingItemTranslate.c.Xlo;
          if (!com.tencent.mm.app.plugin.d.abP()) {
            break label1801;
          }
          if ((!paramca.hzO()) || (!paramca.hzW())) {
            break label1796;
          }
          parama = paramca.field_transContent;
          label870:
          paramString = ((av)parama1.bC(av.class)).cC(paramca);
        }
        for (;;)
        {
          if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.Xlo))
          {
            if (localf.XgC == null)
            {
              localf.XgC = ((ChattingItemTranslate)localf.XgB.inflate());
              localf.XgC.init();
            }
            localObject1 = l.a(localf.XkW.getContext(), parama, (int)localf.XkW.getTextSize(), localObject1, dh(paramca));
            localf.XgC.a((CharSequence)localObject1, paramString);
            localObject1 = localf.XgC;
            if (Util.isNullOrNil(paramca.field_transBrandWording))
            {
              paramString = parama1.WQv.getMMResources().getString(R.l.eUq);
              label1012:
              ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
              if (!Util.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                parama.viewType = 2;
                localf.XgC.setTag(parama);
                localf.XgC.getContentView().setTag(parama);
                localf.XgC.setOnClickListener(hTU());
                localf.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                localf.XgC.setOnDoubleClickListener(this);
                localf.XgC.setOnLongClickListener(c(parama1));
                localf.XgC.setVisibility(0);
              }
            }
          }
          for (;;)
          {
            a(paramInt, localf, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
            AppMethodBeat.o(37410);
            return;
            localf.XkW.setBackgroundResource(R.g.chatto_bg);
            if (localf.XdI == null) {
              break;
            }
            if (b((k)parama1.bC(k.class), paramca.field_msgId))
            {
              if (paramca.VGB)
              {
                parama = new AlphaAnimation(0.5F, 1.0F);
                parama.setDuration(300L);
                localf.XkW.startAnimation(parama);
                paramca.VGB = false;
              }
              localf.XdI.setVisibility(0);
              break;
            }
            localf.XdI.setVisibility(8);
            break;
            if (paramca.field_status < 2) {}
            for (bool = true;; bool = false)
            {
              b(localf, bool);
              break;
            }
            label1294:
            i = 0;
            break label231;
            label1300:
            bool = false;
            break label291;
            j += 1;
            break label426;
            label1315:
            if (paramca.hxy.contains("notify@all")) {}
            for (parama = "";; parama = localf.XkW.getContext().getString(R.l.eRn) + "\n")
            {
              ((Bundle)localObject1).putInt("geta8key_scene", 31);
              parama = l.a(localf.XkW.getContext(), parama + localObject2, (int)localf.XkW.getTextSize(), 4, localObject1, dh(paramca), 0, l.Rsm, bool);
              k = 1;
              break;
            }
            label1441:
            localf.wRL.setVisibility(8);
            break label575;
            label1454:
            i = bs.U(paramca);
            if (i > 0)
            {
              j = i;
              if (i < com.tencent.mm.ui.widget.textview.b.iX(localf.XkW).length()) {}
            }
            else
            {
              j = 0;
            }
            if (localf.Xgy != null) {
              localf.Xgy.destroy();
            }
            parama = c(parama1);
            paramString = a(c(parama1));
            localObject2 = new int[2];
            i = 0;
            if (localf.XkW != null)
            {
              localf.XkW.getLocationInWindow((int[])localObject2);
              k = localObject2[0];
              i = k;
              if (k == 0)
              {
                localObject2 = new Rect();
                localf.XkW.getGlobalVisibleRect((Rect)localObject2);
                i = ((Rect)localObject2).left;
              }
            }
            paramString = new com.tencent.mm.ui.widget.textview.a.a(localf.XkW, localf.AYp, paramString, hTU(), localf.Xgz);
            paramString.YnW = R.e.chat_to_selected;
            paramString.YwO = 18;
            paramString.YnX = R.e.chat_to_cursor_handle_color;
            if (i != 0) {
              paramString.YwP = (i + aw.aZ(localf.XkW.getContext(), R.f.Edge_1_5_A));
            }
            localf.Xgy = paramString.iel();
            localf.XgA = new bi.d(localf.Xgy);
            localf.Xgy.Yww = new bi.b.5(this);
            localf.Xcj = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180037);
                localf.Xgy.cpn();
                localf.Xgy.YwE = true;
                localf.Xgy.YwF = true;
                localf.Xgy.cpq();
                AppMethodBeat.o(180037);
              }
            };
            localf.Xgy.YwC = j;
            parama.Xcj = localf.Xcj;
            localf.Xgy.YwK = localf.XgA;
            break label810;
            paramString = paramca.field_transBrandWording;
            break label1012;
            if (localf.XgC != null) {
              localf.XgC.setVisibility(8);
            }
          }
          parama = null;
          break label870;
          parama = null;
        }
      }
    }
    
    @Deprecated
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, by paramby)
    {
      AppMethodBeat.i(37414);
      if (paramby == null)
      {
        AppMethodBeat.o(37414);
        return false;
      }
      ca localca = paramby.fNz;
      Object localObject;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37414);
        return false;
      case 141: 
        paramMenuItem = localca.field_transContent;
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
        AppMethodBeat.o(37414);
        return true;
      case 142: 
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        paramby = localca.field_transContent;
        if (localca.hzt())
        {
          paramMenuItem.putExtra("Retr_Msg_content", paramby);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37414);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", paramby);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
      case 143: 
        localObject = new dd();
        com.tencent.mm.pluginsdk.model.j.b((dd)localObject, localca.field_transContent, 1);
        ((dd)localObject).fyI.fragment = parama.WQv;
        ((dd)localObject).fyI.fyP = 43;
        if (((dd)localObject).fyI.fyK != null)
        {
          aoi localaoi = ((dd)localObject).fyI.fyK.SAB;
          if (localaoi != null)
          {
            localaoi.btx(localca.field_talker);
            localaoi.bty(z.bcZ());
            EventCenter.instance.publish((IEvent)localObject);
          }
        }
        break;
      case 102: 
        localObject = ((av)parama.bC(av.class)).g(((ChattingItemTranslate.a)paramby).fNz, false);
        paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
        if (localObject == null)
        {
          i = 0;
          label481:
          Log.d("MicroMsg.ChattingItemTextTo", i);
        }
        break;
      }
      for (;;)
      {
        try
        {
          if ((bs.V(localca) < 2) || (Util.isNullOrNil(((ChattingItemTranslate.a)paramby).Xlk))) {
            break label973;
          }
          paramMenuItem = ((ChattingItemTranslate.a)paramby).Xlk;
        }
        catch (Exception paramMenuItem)
        {
          for (;;)
          {
            try
            {
              ClipboardHelper.setText(paramMenuItem);
              localObject = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
              com.tencent.mm.plugin.secinforeport.a.a.s(1, localca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem.toString()));
              bi.c(paramby.fNz, 3, paramMenuItem.length());
            }
            catch (Exception paramby)
            {
              continue;
            }
            try
            {
              paramby = new kh();
              paramby.gMN = localca.field_msgSvrId;
              paramby.gMP = paramMenuItem.length();
              paramby.gMO = this.WEv.length();
              paramby.gMQ = bs.U(localca);
              paramby.bpa();
              com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
              AppMethodBeat.o(37414);
              return true;
              Log.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
              break;
              i = ((CharSequence)localObject).length();
              break label481;
              paramMenuItem = paramMenuItem;
              paramMenuItem = (MenuItem)localObject;
              Log.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
            }
            catch (Exception paramMenuItem)
            {
              Log.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
            }
          }
        }
        bi.c(localca, 4, 0);
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        paramby = ((av)parama.bC(av.class)).g(localca, false);
        if (localca.hzt())
        {
          paramMenuItem.putExtra("Retr_Msg_content", paramby);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem.putExtra("scene_from", 17);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramMenuItem.putExtra("Retr_Msg_content", paramby);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
          paramMenuItem.putExtra("Retr_Msg_Id", localca.field_msgId);
        }
        ce(localca);
        break;
        ((av)parama.bC(av.class)).b(paramMenuItem, localca);
        break;
        s.a(parama, localca.field_msgId, 2);
        AppMethodBeat.o(37414);
        return false;
        label973:
        paramMenuItem = (MenuItem)localObject;
      }
    }
    
    public boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(278557);
      if ((paramca.hxy != null) && (paramca.hxy.contains("announcement@all"))) {}
      for (int i = 1; (!paramca.hwH()) && (!paramca.hzt()); i = 0)
      {
        AppMethodBeat.o(278557);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int j = locala.position;
      if (locala.viewType == 1)
      {
        if (paramca.hwH())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
            paramo.a(j, 151, this.WBq.WQv.getMMResources().getString(R.l.eGn), R.k.icons_filled_continued_form);
          }
          if ((!bs.L(paramca)) && (!bs.O(paramca))) {
            paramo.a(j, 102, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
          }
        }
        if ((!bs.L(paramca)) && (!bs.O(paramca))) {
          paramo.a(j, 108, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (paramca.field_status == 5) {
          paramo.a(j, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramo.a(j, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType())) {
          paramo.a(j, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if ((i == 0) && (!paramca.hwA()) && (paramca.hwH()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
          paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if ((com.tencent.mm.app.plugin.d.abP()) && ((!paramca.hzO()) || (!paramca.hzW()))) {
          paramo.a(j, 124, paramView.getContext().getString(R.l.ewi), R.k.icons_filled_translate);
        }
        if ((paramca.hwH()) && (g.biX())) {
          this.WBq.hRj();
        }
        if (!this.WBq.hRj()) {
          paramo.a(j, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
        }
        if ((bs.D(paramca)) || (bs.V(paramca) == 4))
        {
          paramo.clear();
          if (!this.WBq.hRj()) {
            paramo.a(j, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
          }
        }
      }
      while (locala.viewType != 2)
      {
        AppMethodBeat.o(278557);
        return true;
      }
      paramo.a(j, 141, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
      paramo.a(j, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(j, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      if (com.tencent.mm.app.plugin.d.abP())
      {
        if ((paramca.hzO()) && (paramca.hzW())) {
          paramo.a(j, 124, paramView.getContext().getString(R.l.ewg), R.k.icons_filled_eyes_off);
        }
        if (paramca.hzZ()) {
          paramo.a(j, 125, paramView.getContext().getString(R.l.evZ), R.k.icons_filled_refresh);
        }
      }
      AppMethodBeat.o(278557);
      return false;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(278559);
      paramca.unsetOmittedFailResend();
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      if ((paramca.hwH()) && (paramca.field_isSend == 1)) {
        ce(paramca);
      }
      AppMethodBeat.o(278559);
    }
    
    public boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
    
    public final boolean ie(View paramView)
    {
      AppMethodBeat.i(37416);
      if (y.ic(paramView))
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
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.fNz.field_msgId);
        if (((x)this.WBq.bC(x.class)).cx(locala.fNz))
        {
          localObject1 = ((MMNeat7extView)paramView).ikC().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          ((Intent)localObject2).putExtra("is_group_chat", this.WBq.hRi());
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(locala.fNz.field_talker);
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.la(paramView.getContext());
        }
      }
      else
      {
        AppMethodBeat.o(37416);
        return true;
      }
      Object localObject1 = (av)this.WBq.bC(av.class);
      ca localca = locala.fNz;
      if (locala.viewType == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((av)localObject1).g(localca, bool);
        break;
      }
    }
  }
  
  static final class e
    extends t.e
  {
    public e(com.tencent.mm.ui.chatting.e.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37419);
      parama = (by)paramView.getTag();
      if (paramca.hzt())
      {
        if (this.WBq != null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10221, "1");
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(37419);
        return;
      }
      if ((paramca.hwH()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.n.a.a.hTq();
        com.tencent.mm.ui.chatting.n.a.a.a(paramView.getText(), parama.fNz);
      }
      AppMethodBeat.o(37419);
    }
  }
  
  static final class f
    extends c.a
  {
    com.tencent.mm.ui.widget.b.a AYp;
    a.f Xcj;
    ImageView XdI;
    LinearLayout Xet;
    TextView Xeu;
    a.e XgA;
    ViewStub XgB;
    ChattingItemTranslate XgC;
    com.tencent.mm.ui.widget.textview.a Xgy;
    com.tencent.mm.pluginsdk.ui.span.h Xgz;
    MMNeat7extView XkW;
    View fyN;
    protected TextView wRL;
    
    private static boolean hTV()
    {
      AppMethodBeat.i(37421);
      try
      {
        String str = com.tencent.mm.n.h.axc().getValue("CellTextViewEnable");
        int i = Util.getInt(str, 1);
        boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VsY, true);
        Log.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        if ((1 == i) && (bool))
        {
          AppMethodBeat.o(37421);
          return true;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(37421);
        return false;
      }
      AppMethodBeat.o(37421);
      return false;
    }
    
    public final c.a J(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37420);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.XkW = ((MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv));
      this.XkW.setMaxWidth((int)(com.tencent.mm.ci.a.aZ(this.XkW.getContext(), R.f.chatting_normal_item_width) / com.tencent.mm.cj.a.hrd()));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.fyN = paramView.findViewById(R.h.dxc);
      this.XgB = ((ViewStub)paramView.findViewById(R.h.dXZ));
      if (!paramBoolean)
      {
        this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      }
      this.Xgz = new com.tencent.mm.pluginsdk.ui.span.h(this.XkW, new com.tencent.mm.pluginsdk.ui.span.o(this.XkW.getContext()));
      this.XkW.setIsOpen(hTV());
      this.XkW.setTextCrashListener(new bi.c((byte)0));
      this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
      this.Xet = ((LinearLayout)paramView.findViewById(R.h.dwO));
      this.Xeu = ((TextView)paramView.findViewById(R.h.dwP));
      AppMethodBeat.o(37420);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return this.XkW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi
 * JD-Core Version:    0.7.0.1
 */