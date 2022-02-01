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
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
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
import java.util.Iterator;
import java.util.LinkedList;

public final class y
{
  public static void a(Context paramContext, final com.tencent.mm.ui.chatting.e.a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final ca paramca, int paramInt)
  {
    AppMethodBeat.i(273812);
    Object localObject1 = paramCharSequence;
    if (((x)parama.bC(x.class)).cx(paramca))
    {
      localObject1 = paramca.field_solitaireFoldInfo;
      Object localObject3 = new StringBuilder();
      if (((csq)localObject1).TAq != null)
      {
        localObject2 = ((csq)localObject1).TAq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (csr)((Iterator)localObject2).next();
          ((StringBuilder)localObject3).append(Util.nullAs(Util.nullAs(((csr)localObject4).TAu, ""), "")).append(paramString.substring(((csr)localObject4).start, ((csr)localObject4).end));
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject3).toString())) {
        ((StringBuilder)localObject3).append("\n");
      }
      if ((!Util.isNullOrNil(((StringBuilder)localObject3).toString())) && (((csq)localObject1).DpE == 1)) {
        ((StringBuilder)localObject3).append("\n");
      }
      Object localObject2 = com.tencent.mm.ui.chatting.m.a.WZH;
      com.tencent.mm.ui.chatting.m.a.a.a(paramMMNeat7extView, paramca, parama.hRi(), parama.getSelfUserName());
      parama.getSelfUserName();
      localObject2 = bi.dg(paramca);
      t.b.Rtn.e((Bundle)localObject2, com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
      localObject3 = l.a(paramContext, (CharSequence)localObject3, (int)paramMMNeat7extView.getTextSize(), paramInt, localObject2, l.Rsm);
      String str = paramContext.getString(R.l.eGm);
      Object localObject4 = new SpannableString(str);
      ((SpannableString)localObject4).setSpan(new p(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(284860);
          Log.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((x)parama.bC(x.class)).cx(paramca))
          {
            Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(284860);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(R.h.dzm, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((x)parama.bC(x.class)).VJ(((Long)paramMMNeat7extView.getTag(R.h.dyq)).longValue());
          ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          com.tencent.mm.plugin.groupsolitaire.b.d.a(parama.getTalkerUserName(), this.Xgw);
          AppMethodBeat.o(284860);
        }
      }, 0, str.length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((csq)localObject1).TAr != null)
      {
        paramCharSequence = ((csq)localObject1).TAr.iterator();
        while (paramCharSequence.hasNext())
        {
          paramca = (csr)paramCharSequence.next();
          parama.append(Util.nullAs(paramca.TAu, "")).append(paramString.substring(paramca.start, paramca.end)).append("\n");
        }
      }
      if (((csq)localObject1).TAs != null)
      {
        parama.append("\n");
        parama.append(Util.nullAs(((csq)localObject1).TAs.TAu, "")).append(paramString.substring(((csq)localObject1).TAs.start, ((csq)localObject1).TAs.end));
      }
      paramContext = l.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt, localObject2, l.Rsm);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject3, localObject4 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(273812);
  }
  
  public static boolean ic(View paramView)
  {
    AppMethodBeat.i(273813);
    if (paramView == null)
    {
      AppMethodBeat.o(273813);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(R.h.dzm)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(273813);
        return true;
      }
    }
    catch (Exception paramView)
    {
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(273813);
    }
    return false;
  }
  
  static final class a
    extends c.a
  {
    com.tencent.mm.ui.widget.b.a AYp;
    a.f Xcj;
    protected TextView Xdu;
    a.e XgA;
    ViewStub XgB;
    ChattingItemTranslate XgC;
    protected MMNeat7extView Xgx;
    com.tencent.mm.ui.widget.textview.a Xgy;
    com.tencent.mm.pluginsdk.ui.span.h Xgz;
    View fyN;
    protected ImageView stateIV;
    protected TextView wRL;
    
    public final View getMainContainerView()
    {
      return this.Xgx;
    }
    
    public final a id(View paramView)
    {
      AppMethodBeat.i(36935);
      super.create(paramView);
      this.Xgx = ((MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
      this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.fyN = paramView.findViewById(R.h.dxc);
      this.XgB = ((ViewStub)paramView.findViewById(R.h.dXZ));
      this.Xgz = new com.tencent.mm.pluginsdk.ui.span.h(this.Xgx, new com.tencent.mm.pluginsdk.ui.span.o(this.Xgx.getContext()));
      AppMethodBeat.o(36935);
      return this;
    }
  }
  
  public static final class b
    extends c
    implements NeatTextView.b
  {
    private static final int XgD = R.h.dVZ;
    private static final int XgE = R.h.dyq;
    private static final int XgF = R.h.dyp;
    private com.tencent.mm.ui.chatting.e.a WBq;
    private CharSequence WEv;
    private int XcC = -1;
    private y.e XgG;
    private int jNq = -1;
    
    private y.e hTO()
    {
      AppMethodBeat.i(36944);
      if (this.XgG == null) {
        this.XgG = new y.e(this.WBq);
      }
      y.e locale = this.XgG;
      AppMethodBeat.o(36944);
      return locale;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36945);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecY);
        ((View)localObject).setTag(new y.a().id((View)localObject));
      }
      AppMethodBeat.o(36945);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(36946);
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      final y.a locala = (y.a)parama;
      locala.Xgx.setTag(XgE, Long.valueOf(paramca.field_msgId));
      locala.Xgx.setTag(XgF, Boolean.TRUE);
      Object localObject1 = paramca.field_content;
      parama = (c.a)localObject1;
      int i;
      if (parama1.hRi())
      {
        i = paramca.field_content.indexOf(':');
        parama = (c.a)localObject1;
        if (i != -1) {
          parama = paramca.field_content.substring(i + 1);
        }
      }
      if (parama != null) {}
      label289:
      label1452:
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject2;
        int j;
        if ((parama != null) && (parama.type == 53))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
          if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0))
          {
            localObject1 = parama.appName;
            if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gZ((String)localObject1))) {
              break label1452;
            }
            locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.exe, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.WQv.getContext(), (g)localObject2, (String)localObject1) }));
            locala.wRL.setVisibility(0);
            a(parama1, locala.wRL, parama.appId);
            a(parama1, locala.wRL, parama.appId);
            if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca))
            {
              locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.eGo));
              locala.wRL.setVisibility(0);
              locala.wRL.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(36936);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
                  s.a(parama1, paramca.field_msgId, 1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(36936);
                }
              });
            }
            if ((parama.ilh == null) || (parama.ilh.length() <= 0)) {
              break label1465;
            }
            b(parama1, locala.Xdu, by.bzO(parama.ilh));
            locala.Xdu.setVisibility(0);
            localObject1 = com.tencent.mm.ui.chatting.m.a.WZH;
            com.tencent.mm.ui.chatting.m.a.a.a(locala.Xgx, paramca, parama1.hRi(), paramString);
            paramString = bi.dg(paramca);
            t.b.Rtn.e(paramString, com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
            paramString = l.a(locala.Xgx.getContext(), parama.title, (int)locala.Xgx.getTextSize(), 1, paramString, l.Rsm);
            y.a(locala.Xgx.getContext(), parama1, parama.title, paramString, locala.Xgx, paramca, 1);
            locala.Xgx.setClickable(true);
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
                  AppMethodBeat.i(179995);
                  parama1.Y(true);
                  c.a(locala.AYp, parama1, y.b.a(y.b.this), y.b.b(y.b.this), 49);
                  y.b.a(y.b.this, -1);
                  y.b.b(y.b.this, -1);
                  AppMethodBeat.o(179995);
                }
              };
              locala.AYp.Yri = true;
              locala.AYp.Yrg = new q.e()
              {
                public final void a(com.tencent.mm.ui.base.o paramAnonymouso, View paramAnonymousView)
                {
                  AppMethodBeat.i(287657);
                  paramAnonymouso.clear();
                  paramAnonymouso.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                  paramAnonymousView = locala.Xgx.ikC();
                  by localby = (by)locala.Xgx.getTag();
                  if (localby != null) {}
                  for (int i = bs.U(localby.fNz);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymouso.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                    }
                    paramAnonymouso.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                    paramAnonymouso.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                    AppMethodBeat.o(287657);
                    return;
                  }
                }
              };
              locala.AYp.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(179999);
                  y.b.a(y.b.this, paramAnonymousInt);
                  y.b.b(y.b.this, paramAnonymousMenuItem.getItemId());
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(179999);
                    return;
                    ClipboardHelper.setText(MMApplicationContext.getContext(), y.b.c(y.b.this), y.b.c(y.b.this));
                    if (locala.Xgy != null)
                    {
                      locala.Xgy.cpn();
                      locala.Xgy.YwE = true;
                      locala.Xgy.YwF = true;
                      locala.Xgy.cpq();
                    }
                    Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                    AppMethodBeat.o(179999);
                    return;
                    if (locala.Xgy != null)
                    {
                      if (locala.Xgy.Ywy != null) {
                        locala.Xgy.Ywy.hTJ();
                      }
                      locala.Xgy.YwE = true;
                      locala.Xgy.cpq();
                      locala.Xgy.fj(0, locala.Xgx.ikC().length());
                      locala.Xgy.ief();
                      locala.Xgy.iei();
                      if (locala.Xgy.Ywy != null)
                      {
                        locala.Xgy.Ywy.hTK();
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = (by)locala.Xgx.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = bs.T(paramAnonymousMenuItem.fNz);
                          Object localObject;
                          if (Util.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject).putExtra("Retr_Msg_content", y.b.c(y.b.this));
                            ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(179999);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179997);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
                              com.tencent.mm.by.c.b(y.b.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              AppMethodBeat.o(179997);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179998);
                              Object localObject = new Intent(y.b.4.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", y.b.c(y.b.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = y.b.4.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(179998);
                            }
                          });
                          AppMethodBeat.o(179999);
                          return;
                          paramAnonymousMenuItem = new dd();
                          j.b(paramAnonymousMenuItem, y.b.c(y.b.this).toString(), 1);
                          paramAnonymousMenuItem.fyI.fragment = y.b.d(y.b.this).WQv;
                          paramAnonymousMenuItem.fyI.fyP = 43;
                          if (paramAnonymousMenuItem.fyI.fyK != null)
                          {
                            localObject = paramAnonymousMenuItem.fyI.fyK.SAB;
                            if (localObject != null)
                            {
                              by localby = (by)locala.Xgx.getTag();
                              if (localby != null)
                              {
                                ((aoi)localObject).btx(localby.fNz.field_talker);
                                ((aoi)localObject).bty(z.bcZ());
                                EventCenter.instance.publish(paramAnonymousMenuItem);
                              }
                            }
                          }
                          if (locala.Xgy != null)
                          {
                            locala.Xgy.cpn();
                            locala.Xgy.YwE = true;
                            locala.Xgy.YwF = true;
                            locala.Xgy.cpq();
                          }
                        }
                      }
                    }
                  }
                }
              };
            }
            if (bs.D(paramca)) {
              break label1478;
            }
            j = bs.U(paramca);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.iX(locala.Xgx).length())) {
              break label1586;
            }
            j = 0;
          }
        }
        label945:
        label1586:
        for (;;)
        {
          paramString = c(parama1);
          localObject1 = a(paramString);
          if (locala.Xgy != null) {
            locala.Xgy.destroy();
          }
          localObject2 = new int[2];
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
            localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.Xgx, locala.AYp, (a.f)localObject1, hTO(), locala.Xgz);
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnW = R.e.selected_blue;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwO = 18;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnX = R.e.cursor_handle_color;
            if (i != 0) {
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwP = (aw.aZ(locala.Xgx.getContext(), R.f.Edge_2A) + i);
            }
            locala.Xgy = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).iel();
            locala.XgA = new y.d(locala.Xgy);
            locala.Xgy.Yww = new y.b.5(this);
            locala.Xcj = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180001);
                locala.Xgy.cpn();
                locala.Xgy.YwE = true;
                locala.Xgy.YwF = true;
                locala.Xgy.cpq();
                AppMethodBeat.o(180001);
              }
            };
            paramString.Xcj = locala.Xcj;
            locala.Xgy.YwC = j;
            locala.Xgy.YwK = locala.XgA;
            locala.Xgx.setOnDoubleClickListener(this);
            locala.Xgx.setTag(parama);
            locala.Xgx.setTextListener(new MMNeat7extView.a()
            {
              public final void aI(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180002);
                if (((Boolean)locala.Xgx.getTag(y.b.XgF)).booleanValue())
                {
                  com.tencent.mm.ui.chatting.n.a.a.hTq();
                  com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)locala.Xgx.getTag(y.b.XgE)).longValue());
                }
                AppMethodBeat.o(180002);
              }
            });
            locala.Xgx.setMaxLines(2147483647);
            paramString = ChattingItemTranslate.c.Xlo;
            if (com.tencent.mm.app.plugin.d.abP()) {
              if ((paramca.hzO()) && (paramca.hzW()))
              {
                parama = paramca.field_transContent;
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
                localObject2 = t.b.Rtn.aqS(com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
                Context localContext = locala.Xgx.getContext();
                i = (int)locala.Xgx.getTextSize();
                if (paramca != null)
                {
                  localObject1 = ad.Rp(paramca.field_msgSvrId);
                  ad.b localb = ad.beh().I((String)localObject1, true);
                  localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
                  localb.k("preUsername", a(this.WBq, paramca));
                  localb.k("preChatName", b(this.WBq, paramca));
                  label1242:
                  localObject1 = l.a(localContext, parama, i, localObject2, (String)localObject1, l.Rsm);
                  Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject1 });
                  locala.XgC.a((CharSequence)localObject1, paramString);
                  localObject1 = locala.XgC;
                  if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                    break label1539;
                  }
                }
                for (paramString = parama1.WQv.getMMResources().getString(R.l.eUq);; paramString = paramca.field_transBrandWording)
                {
                  ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                  if (!Util.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                    parama.XmM = false;
                    parama.viewType = 2;
                    locala.XgC.setTag(parama);
                    locala.XgC.setOnClickListener(hTO());
                    locala.XgC.setOnDoubleClickListener(this);
                    locala.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                    locala.XgC.setOnLongClickListener(c(parama1));
                    locala.XgC.setVisibility(0);
                  }
                  AppMethodBeat.o(36946);
                  return;
                  localObject1 = ((g)localObject2).field_appName;
                  break;
                  locala.wRL.setVisibility(8);
                  break label289;
                  label1465:
                  locala.Xdu.setVisibility(8);
                  break label389;
                  label1478:
                  locala.Xgx.setTag(XgD, Boolean.FALSE);
                  locala.Xgx.setOnTouchListener(locala.Xgz);
                  locala.Xgx.setOnLongClickListener(c(parama1));
                  locala.Xgx.setOnClickListener(hTO());
                  break label945;
                  localObject1 = null;
                  break label1242;
                }
              }
              if (locala.XgC != null) {
                locala.XgC.setVisibility(8);
              }
              AppMethodBeat.o(36946);
              return;
              parama = null;
              break label1025;
              parama = null;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36948);
      Object localObject;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36948);
        return false;
      case 151: 
        s.a(parama, paramca.field_msgId, 2);
        AppMethodBeat.o(36948);
        return false;
      case 102: 
        paramMenuItem = k.b.OQ(bq.b(parama.hRh(), paramca.field_content, paramca.field_isSend)).title;
        ClipboardHelper.setText(paramMenuItem);
        parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
        com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
        AppMethodBeat.o(36948);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return false;
      case 124: 
      case 125: 
        ((av)parama.bC(av.class)).b(paramMenuItem, paramca);
        AppMethodBeat.o(36948);
        return false;
      case 141: 
        paramMenuItem = paramca.field_transContent;
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
        AppMethodBeat.o(36948);
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
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36948);
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
            AppMethodBeat.o(36948);
            return true;
          }
          Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(274703);
      if (paramca.hxy != null) {
        paramca.hxy.contains("announcement@all");
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.viewType == 1)
      {
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
          paramo.a(i, 151, this.WBq.WQv.getMMResources().getString(R.l.eGn), R.k.icons_filled_continued_form);
        }
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
        AppMethodBeat.o(274703);
        return true;
      }
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
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
      AppMethodBeat.o(274703);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 805306417);
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
      AppMethodBeat.i(36949);
      if (y.ic(paramView))
      {
        Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36949);
        return true;
      }
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
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.la(paramView.getContext());
      }
      AppMethodBeat.o(36949);
      return true;
    }
  }
  
  public static final class c
    extends c
    implements t.n, NeatTextView.b
  {
    private static final int XgD = R.h.dVZ;
    private static final int XgE = R.h.dyq;
    private static final int XgF = R.h.dyp;
    private com.tencent.mm.ui.chatting.e.a WBq;
    private CharSequence WEv;
    private int XcC = -1;
    private y.e XgG;
    private int jNq = -1;
    
    private void ce(ca paramca)
    {
      AppMethodBeat.i(283815);
      if (paramca.hzM())
      {
        Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(paramca.field_talker, paramca.ilt, true);
        if ((localObject != null) && (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, paramca.field_msgId)))
        {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
          ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
        if (localObject != null) {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().af(paramca.field_msgId, ((Long)((Pair)localObject).second).longValue());
        }
        bq.Gk(paramca.field_msgId);
        this.WBq.Gi(true);
      }
      AppMethodBeat.o(283815);
    }
    
    private y.e hTO()
    {
      AppMethodBeat.i(36956);
      if (this.XgG == null) {
        this.XgG = new y.e(this.WBq);
      }
      y.e locale = this.XgG;
      AppMethodBeat.o(36956);
      return locale;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36957);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edY);
        ((View)localObject).setTag(new y.a().id((View)localObject));
      }
      AppMethodBeat.o(36957);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(36958);
      final y.a locala = (y.a)parama;
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      locala.Xgx.setTag(XgE, Long.valueOf(paramca.field_msgId));
      locala.Xgx.setTag(XgF, Boolean.TRUE);
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject1 = com.tencent.mm.ui.chatting.m.a.WZH;
        com.tencent.mm.ui.chatting.m.a.a.a(locala.Xgx, paramca, parama1.hRi(), paramString);
        paramString = bi.dg(paramca);
        t.b.Rtn.e(paramString, com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
        if ((parama != null) && (parama.type == 53))
        {
          paramString = l.a(locala.Xgx.getContext(), parama.title, (int)locala.Xgx.getTextSize(), 4, paramString, l.Rsm);
          y.a(locala.Xgx.getContext(), parama1, parama.title, paramString, locala.Xgx, paramca, 4);
          locala.Xgx.setClickable(true);
          localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
          if ((localObject1 != null) && (((g)localObject1).field_appName != null) && (((g)localObject1).field_appName.trim().length() > 0)) {
            break label1336;
          }
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gZ(paramString))) {
            break label1346;
          }
          locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.exe, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.WQv.getContext(), (g)localObject1, paramString) }));
          locala.wRL.setVisibility(0);
          a(parama1, locala.wRL, parama.appId);
          a(parama1, locala.wRL, parama.appId);
          label355:
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca))
          {
            locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.eGo));
            locala.wRL.setVisibility(0);
            locala.wRL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36950);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
                s.a(parama1, paramca.field_msgId, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36950);
              }
            });
          }
          if (!hTG()) {
            break label1359;
          }
        }
        label900:
        label1427:
        for (;;)
        {
          boolean bool = false;
          parama = locala;
          label424:
          b(parama, bool);
          parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
          parama.XmM = false;
          paramString = locala.Xgx.getContext();
          locala.Xgx.setTag(XgD, Boolean.TRUE);
          if (locala.AYp == null)
          {
            locala.AYp = new com.tencent.mm.ui.widget.b.a(paramString, locala.Xgx);
            locala.AYp.XVa = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180003);
                parama1.Y(true);
                c.a(locala.AYp, parama1, y.c.a(y.c.this), y.c.b(y.c.this), 49);
                y.c.a(y.c.this, -1);
                y.c.b(y.c.this, -1);
                AppMethodBeat.o(180003);
              }
            };
            locala.AYp.Yri = true;
            locala.AYp.Yrg = new q.e()
            {
              public final void a(com.tencent.mm.ui.base.o paramAnonymouso, View paramAnonymousView)
              {
                AppMethodBeat.i(272637);
                paramAnonymouso.clear();
                paramAnonymouso.a(0, 0, paramString.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
                paramAnonymouso.a(0, 1, paramString.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
                paramAnonymouso.a(0, 2, paramString.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
                paramAnonymouso.a(0, 3, paramString.getResources().getString(R.l.favorite), R.k.icons_filled_favorites);
                AppMethodBeat.o(272637);
              }
            };
            locala.AYp.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(180005);
                y.c.b(y.c.this, paramAnonymousMenuItem.getItemId());
                y.c.a(y.c.this, paramAnonymousInt);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(180005);
                  return;
                  ClipboardHelper.setText(MMApplicationContext.getContext(), y.c.c(y.c.this), y.c.c(y.c.this));
                  if (locala.Xgy != null)
                  {
                    locala.Xgy.cpn();
                    locala.Xgy.YwE = true;
                    locala.Xgy.YwF = true;
                    locala.Xgy.cpq();
                  }
                  Toast.makeText(paramString, R.l.app_copy_ok, 0).show();
                  AppMethodBeat.o(180005);
                  return;
                  if (locala.Xgy != null)
                  {
                    if (locala.Xgy.Ywy != null) {
                      locala.Xgy.Ywy.hTJ();
                    }
                    locala.Xgy.YwE = true;
                    locala.Xgy.cpq();
                    locala.Xgy.fj(0, locala.Xgx.ikC().length());
                    locala.Xgy.ief();
                    locala.Xgy.iei();
                    if (locala.Xgy.Ywy != null)
                    {
                      locala.Xgy.Ywy.hTK();
                      AppMethodBeat.o(180005);
                      return;
                      Object localObject = new Intent(paramString, MsgRetransmitUI.class);
                      ((Intent)localObject).putExtra("Retr_Msg_content", y.c.c(y.c.this));
                      ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                      paramAnonymousMenuItem = paramString;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                      com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                      com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(180005);
                      return;
                      paramAnonymousMenuItem = new dd();
                      j.b(paramAnonymousMenuItem, y.c.c(y.c.this).toString(), 1);
                      paramAnonymousMenuItem.fyI.fragment = y.c.d(y.c.this).WQv;
                      paramAnonymousMenuItem.fyI.fyP = 43;
                      if (paramAnonymousMenuItem.fyI.fyK != null)
                      {
                        localObject = paramAnonymousMenuItem.fyI.fyK.SAB;
                        if (localObject != null)
                        {
                          by localby = (by)locala.Xgx.getTag();
                          if (localby != null)
                          {
                            ((aoi)localObject).btx(localby.fNz.field_talker);
                            ((aoi)localObject).bty(z.bcZ());
                            EventCenter.instance.publish(paramAnonymousMenuItem);
                          }
                        }
                      }
                      if (locala.Xgy != null)
                      {
                        locala.Xgy.cpn();
                        locala.Xgy.YwE = true;
                        locala.Xgy.YwF = true;
                        locala.Xgy.cpq();
                      }
                    }
                  }
                }
              }
            };
          }
          paramString = c(parama1);
          localObject1 = a(c(parama1));
          if (locala.Xgy != null) {
            locala.Xgy.destroy();
          }
          Object localObject2 = new int[2];
          int i = 0;
          if (locala.Xgx != null)
          {
            locala.Xgx.getLocationInWindow((int[])localObject2);
            int j = localObject2[0];
            i = j;
            if (j == 0)
            {
              localObject2 = new Rect();
              locala.Xgx.getGlobalVisibleRect((Rect)localObject2);
              i = ((Rect)localObject2).left;
            }
          }
          for (;;)
          {
            localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.Xgx, locala.AYp, (a.f)localObject1, hTO(), locala.Xgz);
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnW = R.e.chat_to_selected;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwO = 18;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YnX = R.e.chat_to_cursor_handle_color;
            if (i != 0) {
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).YwP = (aw.aZ(locala.Xgx.getContext(), R.f.Edge_1_5_A) + i);
            }
            locala.Xgy = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).iel();
            locala.XgA = new y.d(locala.Xgy);
            locala.Xgy.Yww = new y.c.5(this);
            locala.Xcj = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180007);
                locala.Xgy.cpn();
                locala.Xgy.YwE = true;
                locala.Xgy.YwF = true;
                locala.Xgy.cpq();
                AppMethodBeat.o(180007);
              }
            };
            paramString.Xcj = locala.Xcj;
            locala.Xgy.YwK = locala.XgA;
            locala.Xgx.setOnDoubleClickListener(this);
            locala.Xgx.setTag(parama);
            locala.Xgx.setTextListener(new MMNeat7extView.a()
            {
              public final void aI(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180008);
                if (((Boolean)locala.Xgx.getTag(y.c.bKi())).booleanValue())
                {
                  com.tencent.mm.ui.chatting.n.a.a.hTq();
                  com.tencent.mm.ui.chatting.n.a.a.hTr().a(paramAnonymousCharSequence, ((Long)locala.Xgx.getTag(y.c.bKj())).longValue());
                }
                AppMethodBeat.o(180008);
              }
            });
            paramString = ChattingItemTranslate.c.Xlo;
            if (com.tencent.mm.app.plugin.d.abP()) {
              if ((paramca.hzO()) && (paramca.hzW()))
              {
                parama = paramca.field_transContent;
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
                localObject2 = t.b.Rtn.aqS(com.tencent.mm.modelappbrand.a.SF(paramca.field_talker));
                Context localContext = locala.Xgx.getContext();
                i = (int)locala.Xgx.getTextSize();
                if (paramca != null)
                {
                  localObject1 = ad.Rp(paramca.field_msgSvrId);
                  ad.b localb = ad.beh().I((String)localObject1, true);
                  localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
                  localb.k("preUsername", a(this.WBq, paramca));
                  localb.k("preChatName", b(this.WBq, paramca));
                  label1117:
                  localObject1 = l.a(localContext, parama, i, localObject2, (String)localObject1, l.Rsm);
                  Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject1 });
                  locala.XgC.a((CharSequence)localObject1, paramString);
                  localObject1 = locala.XgC;
                  if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                    break label1383;
                  }
                  paramString = parama1.WQv.getMMResources().getString(R.l.eUq);
                  label1197:
                  ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                  if (!Util.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
                    parama.XmM = false;
                    parama.viewType = 2;
                    locala.XgC.setTag(parama);
                    locala.XgC.setOnClickListener(hTO());
                    locala.XgC.setOnDoubleClickListener(this);
                    locala.XgC.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
                    locala.XgC.setOnLongClickListener(c(parama1));
                    locala.XgC.setVisibility(0);
                  }
                }
              }
              for (;;)
              {
                a(paramInt, locala, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
                AppMethodBeat.o(36958);
                return;
                label1336:
                paramString = ((g)localObject1).field_appName;
                break;
                label1346:
                locala.wRL.setVisibility(8);
                break label355;
                label1359:
                if (paramca.field_status >= 2) {
                  break label1427;
                }
                bool = true;
                parama = locala;
                break label424;
                localObject1 = null;
                break label1117;
                label1383:
                paramString = paramca.field_transBrandWording;
                break label1197;
                if (locala.XgC != null) {
                  locala.XgC.setVisibility(8);
                }
              }
              parama = null;
              break label900;
              parama = null;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36960);
      Object localObject;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36960);
        return false;
      case 151: 
        s.a(parama, paramca.field_msgId, 2);
        AppMethodBeat.o(36960);
        return false;
      case 102: 
        paramMenuItem = k.b.OQ(bq.b(parama.hRh(), paramca.field_content, paramca.field_isSend)).title;
        ClipboardHelper.setText(paramMenuItem);
        parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
        com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
        AppMethodBeat.o(36960);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return false;
      case 103: 
        ce(paramca);
      case 124: 
      case 125: 
        for (;;)
        {
          AppMethodBeat.o(36960);
          return false;
          ((av)parama.bC(av.class)).b(paramMenuItem, paramca);
        }
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
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36960);
          return true;
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
        }
        paramMenuItem = paramca.field_transContent;
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cO(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.app_copy_ok));
        AppMethodBeat.o(36960);
        return true;
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
            AppMethodBeat.o(36960);
            return true;
          }
          Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(283811);
      int i;
      ChattingItemTranslate.a locala;
      int j;
      if ((paramca.hxy != null) && (paramca.hxy.contains("announcement@all")))
      {
        i = 1;
        locala = (ChattingItemTranslate.a)paramView.getTag();
        j = locala.position;
        if (locala.viewType != 1) {
          break label450;
        }
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aI(paramca)) {
          paramo.a(j, 151, this.WBq.WQv.getMMResources().getString(R.l.eGn), R.k.icons_filled_continued_form);
        }
        if (!bs.O(paramca))
        {
          paramo.a(j, 102, this.WBq.WQv.getMMResources().getString(R.l.evK), R.k.icons_filled_copy);
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (paramca.field_status == 5) {
          paramo.a(j, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramo.a(j, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType())) {
          paramo.a(j, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if ((i == 0) && (!paramca.hwA()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
          paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if ((com.tencent.mm.app.plugin.d.abP()) && ((!paramca.hzO()) || (!paramca.hzW()))) {
          paramo.a(j, 124, paramView.getContext().getString(R.l.ewi), R.k.icons_filled_translate);
        }
        if (!this.WBq.hRj()) {
          paramo.a(j, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
        }
      }
      label450:
      while (locala.viewType != 2)
      {
        AppMethodBeat.o(283811);
        return true;
        i = 0;
        break;
      }
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
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
      AppMethodBeat.o(283811);
      return false;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(283814);
      ce(paramca);
      AppMethodBeat.o(283814);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 805306417);
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
      AppMethodBeat.i(36962);
      if (y.ic(paramView))
      {
        Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36962);
        return true;
      }
      Object localObject2 = ((MMNeat7extView)paramView).ikC();
      Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
      if ((paramView.getTag() instanceof by))
      {
        localObject2 = (by)paramView.getTag();
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("Chat_Msg_Id", ((by)localObject2).fNz.field_msgId);
        }
      }
      if (this.WBq != null) {
        ((Intent)localObject1).putExtra("is_group_chat", this.WBq.hRi());
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.la(paramView.getContext());
      AppMethodBeat.o(36962);
      return true;
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
      AppMethodBeat.i(36964);
      parama = (by)paramView.getTag();
      if (paramca.hzt())
      {
        if (this.WBq != null)
        {
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(36964);
        return;
      }
      if ((paramca.hwH()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.n.a.a.hTq();
        com.tencent.mm.ui.chatting.n.a.a.a(paramView.getText(), parama.fNz);
      }
      AppMethodBeat.o(36964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y
 * JD-Core Version:    0.7.0.1
 */