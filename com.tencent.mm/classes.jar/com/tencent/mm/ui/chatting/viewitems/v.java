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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.b.a.ja;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
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

public final class v
{
  public static void a(Context paramContext, final com.tencent.mm.ui.chatting.e.a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final ca paramca, int paramInt)
  {
    AppMethodBeat.i(233725);
    Object localObject1 = paramCharSequence;
    if (((com.tencent.mm.ui.chatting.d.b.x)parama.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(paramca))
    {
      localObject1 = paramca.field_solitaireFoldInfo;
      Object localObject3 = new StringBuilder();
      if (((cjv)localObject1).Mpl != null)
      {
        localObject2 = ((cjv)localObject1).Mpl.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (cjw)((Iterator)localObject2).next();
          ((StringBuilder)localObject3).append(Util.nullAs(Util.nullAs(((cjw)localObject4).Mpp, ""), "")).append(paramString.substring(((cjw)localObject4).start, ((cjw)localObject4).end));
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject3).toString())) {
        ((StringBuilder)localObject3).append("\n");
      }
      if ((!Util.isNullOrNil(((StringBuilder)localObject3).toString())) && (((cjv)localObject1).yfC == 1)) {
        ((StringBuilder)localObject3).append("\n");
      }
      Object localObject2 = com.tencent.mm.ui.chatting.l.a.PEV;
      com.tencent.mm.ui.chatting.l.a.a.a(paramMMNeat7extView, paramca, parama.gRM(), parama.gRI());
      parama.gRI();
      localObject2 = bd.cN(paramca);
      t.b.Ksg.br((Bundle)localObject2);
      localObject3 = l.a(paramContext, (CharSequence)localObject3, (int)paramMMNeat7extView.getTextSize(), paramInt, false, localObject2, l.Krf);
      String str = paramContext.getString(2131761480);
      Object localObject4 = new SpannableString(str);
      ((SpannableString)localObject4).setSpan(new p(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233718);
          Log.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((com.tencent.mm.ui.chatting.d.b.x)parama.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(paramca))
          {
            Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(233718);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(2131298553, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((com.tencent.mm.ui.chatting.d.b.x)parama.bh(com.tencent.mm.ui.chatting.d.b.x.class)).Nx(((Long)paramMMNeat7extView.getTag(2131298495)).longValue());
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramAnonymousView = parama.getTalkerUserName();
          cjv localcjv = this.PKC;
          ja localja = new ja();
          localja.emL = localja.x("ChatName", paramAnonymousView, true);
          localja.eQf = localcjv.dTS;
          localja.eQj = localja.x("Identifier", localcjv.key, true);
          localja.eQs = localcjv.Mpm.size();
          localja.eQt = localcjv.Mpo;
          localja.bfK();
          AppMethodBeat.o(233718);
        }
      }, 0, str.length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((cjv)localObject1).Mpm != null)
      {
        paramCharSequence = ((cjv)localObject1).Mpm.iterator();
        while (paramCharSequence.hasNext())
        {
          paramca = (cjw)paramCharSequence.next();
          parama.append(Util.nullAs(paramca.Mpp, "")).append(paramString.substring(paramca.start, paramca.end)).append("\n");
        }
      }
      if (((cjv)localObject1).Mpn != null)
      {
        parama.append("\n");
        parama.append(Util.nullAs(((cjv)localObject1).Mpn.Mpp, "")).append(paramString.substring(((cjv)localObject1).Mpn.start, ((cjv)localObject1).Mpn.end));
      }
      paramContext = l.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt, false, localObject2, l.Krf);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject3, localObject4 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(233725);
  }
  
  public static boolean gQ(View paramView)
  {
    AppMethodBeat.i(233726);
    if (paramView == null)
    {
      AppMethodBeat.o(233726);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(2131298553)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(233726);
        return true;
      }
    }
    catch (Exception paramView)
    {
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(233726);
    }
    return false;
  }
  
  static final class a
    extends c.a
  {
    a.f PGP;
    protected TextView PHZ;
    protected MMNeat7extView PKD;
    com.tencent.mm.ui.widget.textview.a PKE;
    com.tencent.mm.pluginsdk.ui.span.h PKF;
    a.e PKG;
    ViewStub PKH;
    ChattingItemTranslate PKI;
    View jxm;
    protected ImageView stateIV;
    protected TextView tln;
    com.tencent.mm.ui.widget.b.a wnj;
    
    public final a gR(View paramView)
    {
      AppMethodBeat.i(36935);
      super.create(paramView);
      this.PKD = ((MMNeat7extView)paramView.findViewById(2131298416));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.tln = ((TextView)paramView.findViewById(2131298385));
      this.PHZ = ((TextView)paramView.findViewById(2131298364));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.jxm = paramView.findViewById(2131298414);
      this.PKH = ((ViewStub)paramView.findViewById(2131309405));
      this.PKF = new com.tencent.mm.pluginsdk.ui.span.h(this.PKD, new o(this.PKD.getContext()));
      AppMethodBeat.o(36935);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return this.PKD;
    }
  }
  
  public static final class b
    extends c
    implements NeatTextView.b
  {
    private static final int PKJ = 2131308867;
    private static final int PKK = 2131298495;
    private static final int PKL = 2131298494;
    private int PHj = -1;
    private v.e PKM;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private CharSequence PkM;
    private int hcg = -1;
    
    private v.e gUd()
    {
      AppMethodBeat.i(36944);
      if (this.PKM == null) {
        this.PKM = new v.e(this.PhN);
      }
      v.e locale = this.PKM;
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
        localObject = new an(paramLayoutInflater, 2131493540);
        ((View)localObject).setTag(new v.a().gR((View)localObject));
      }
      AppMethodBeat.o(36945);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(36946);
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
      final v.a locala = (v.a)parama;
      locala.PKD.setTag(PKK, Long.valueOf(paramca.field_msgId));
      locala.PKD.setTag(PKL, Boolean.TRUE);
      Object localObject1 = paramca.field_content;
      parama = (c.a)localObject1;
      int i;
      if (parama1.gRM())
      {
        i = paramca.field_content.indexOf(':');
        parama = (c.a)localObject1;
        if (i != -1) {
          parama = paramca.field_content.substring(i + 1);
        }
      }
      if (parama != null) {}
      for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject2;
        label288:
        int j;
        if ((parama != null) && (parama.type == 53))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
          if ((localObject2 == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() <= 0))
          {
            localObject1 = parama.appName;
            if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gp((String)localObject1))) {
              break label1438;
            }
            locala.tln.setText(parama1.Pwc.getMMResources().getString(2131757531, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.Pwc.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1) }));
            locala.tln.setVisibility(0);
            a(parama1, locala.tln, parama.appId);
            a(parama1, locala.tln, parama.appId);
            if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca))
            {
              locala.tln.setText(parama1.Pwc.getMMResources().getString(2131761487));
              locala.tln.setVisibility(0);
              locala.tln.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(36936);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
                  s.a(parama1, paramca.field_msgId, 1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(36936);
                }
              });
            }
            if ((parama.fQR == null) || (parama.fQR.length() <= 0)) {
              break label1451;
            }
            b(parama1, locala.PHZ, bq.bnn(parama.fQR));
            locala.PHZ.setVisibility(0);
            label388:
            localObject1 = com.tencent.mm.ui.chatting.l.a.PEV;
            com.tencent.mm.ui.chatting.l.a.a.a(locala.PKD, paramca, parama1.gRM(), paramString);
            paramString = bd.cN(paramca);
            t.b.Ksg.br(paramString);
            paramString = l.a(locala.PKD.getContext(), parama.title, (int)locala.PKD.getTextSize(), 1, false, paramString, l.Krf);
            v.a(locala.PKD.getContext(), parama1, parama.title, paramString, locala.PKD, paramca, 1);
            locala.PKD.setClickable(true);
            parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
            paramString = locala.PKD.getContext();
            locala.PKD.setTag(PKJ, Boolean.TRUE);
            if (locala.wnj == null)
            {
              locala.wnj = new com.tencent.mm.ui.widget.b.a(paramString, locala.PKD);
              locala.wnj.QwU = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(179995);
                  parama1.setFocused(true);
                  c.a(locala.wnj, parama1, v.b.a(v.b.this), v.b.b(v.b.this), 49);
                  v.b.a(v.b.this, -1);
                  v.b.b(v.b.this, -1);
                  AppMethodBeat.o(179995);
                }
              };
              locala.wnj.QSv = true;
              locala.wnj.QSt = new o.e()
              {
                public final void a(com.tencent.mm.ui.base.m paramAnonymousm, View paramAnonymousView)
                {
                  AppMethodBeat.i(233719);
                  paramAnonymousm.clear();
                  paramAnonymousm.a(0, 0, paramString.getResources().getString(2131755772), 2131690525);
                  paramAnonymousView = locala.PKD.hiT();
                  bq localbq = (bq)locala.PKD.getTag();
                  if (localbq != null) {}
                  for (int i = br.O(localbq.dTX);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymousm.a(0, 1, paramString.getResources().getString(2131763038), 2131690480);
                    }
                    paramAnonymousm.a(0, 2, paramString.getResources().getString(2131763036), 2131690674);
                    paramAnonymousm.a(0, 3, paramString.getResources().getString(2131759168), 2131690551);
                    AppMethodBeat.o(233719);
                    return;
                  }
                }
              };
              locala.wnj.HLY = new o.g()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(179999);
                  v.b.a(v.b.this, paramAnonymousInt);
                  v.b.b(v.b.this, paramAnonymousMenuItem.getItemId());
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(179999);
                    return;
                    ClipboardHelper.setText(MMApplicationContext.getContext(), v.b.c(v.b.this), v.b.c(v.b.this));
                    if (locala.PKE != null)
                    {
                      locala.PKE.hbA();
                      locala.PKE.QXW = true;
                      locala.PKE.QXX = true;
                      locala.PKE.hbz();
                    }
                    Toast.makeText(paramString, 2131755773, 0).show();
                    AppMethodBeat.o(179999);
                    return;
                    if (locala.PKE != null)
                    {
                      if (locala.PKE.QXQ != null) {
                        locala.PKE.QXQ.gTY();
                      }
                      locala.PKE.QXW = true;
                      locala.PKE.hbz();
                      locala.PKE.lE(0, locala.PKD.hiT().length());
                      locala.PKE.hcQ();
                      locala.PKE.hcT();
                      if (locala.PKE.QXQ != null)
                      {
                        locala.PKE.QXQ.gTZ();
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = (bq)locala.PKD.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = br.N(paramAnonymousMenuItem.dTX);
                          Object localObject;
                          if (Util.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject).putExtra("Retr_Msg_content", v.b.c(v.b.this));
                            ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(179999);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179997);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                              com.tencent.mm.br.c.b(v.b.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              AppMethodBeat.o(179997);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179998);
                              Object localObject = new Intent(v.b.4.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", v.b.c(v.b.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = v.b.4.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(179998);
                            }
                          });
                          AppMethodBeat.o(179999);
                          return;
                          paramAnonymousMenuItem = new cz();
                          com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, v.b.c(v.b.this).toString(), 1);
                          paramAnonymousMenuItem.dFZ.fragment = v.b.d(v.b.this).Pwc;
                          paramAnonymousMenuItem.dFZ.dGf = 43;
                          if (paramAnonymousMenuItem.dFZ.dGb != null)
                          {
                            localObject = paramAnonymousMenuItem.dFZ.dGb.Lya;
                            if (localObject != null)
                            {
                              bq localbq = (bq)locala.PKD.getTag();
                              if (localbq != null)
                              {
                                ((anh)localObject).bhf(localbq.dTX.field_talker);
                                ((anh)localObject).bhg(z.aTY());
                                EventCenter.instance.publish(paramAnonymousMenuItem);
                              }
                            }
                          }
                          if (locala.PKE != null)
                          {
                            locala.PKE.hbA();
                            locala.PKE.QXW = true;
                            locala.PKE.QXX = true;
                            locala.PKE.hbz();
                          }
                        }
                      }
                    }
                  }
                }
              };
            }
            if (br.B(paramca)) {
              break label1464;
            }
            j = br.O(paramca);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.hB(locala.PKD).length())) {
              break label1572;
            }
            j = 0;
          }
        }
        label1438:
        label1572:
        for (;;)
        {
          paramString = c(parama1);
          localObject1 = a(paramString);
          if (locala.PKE != null) {
            locala.PKE.destroy();
          }
          localObject2 = new int[2];
          i = 0;
          if (locala.PKD != null)
          {
            locala.PKD.getLocationInWindow((int[])localObject2);
            int k = localObject2[0];
            i = k;
            if (k == 0)
            {
              localObject2 = new Rect();
              locala.PKD.getGlobalVisibleRect((Rect)localObject2);
              i = ((Rect)localObject2).left;
            }
          }
          for (;;)
          {
            localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.PKD, locala.wnj, (a.f)localObject1, gUd(), locala.PKF);
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPi = 2131101045;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYg = 18;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPj = 2131100228;
            if (i != 0) {
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYh = (at.aH(locala.PKD.getContext(), 2131165296) + i);
            }
            locala.PKE = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).hcW();
            locala.PKG = new v.d(locala.PKE);
            locala.PKE.QXO = new com.tencent.mm.ui.base.x()
            {
              public final void as(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180000);
                v.b.a(v.b.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180000);
              }
            };
            locala.PGP = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180001);
                locala.PKE.hbA();
                locala.PKE.QXW = true;
                locala.PKE.QXX = true;
                locala.PKE.hbz();
                AppMethodBeat.o(180001);
              }
            };
            paramString.PGP = locala.PGP;
            locala.PKE.QXU = j;
            locala.PKE.QYc = locala.PKG;
            label937:
            locala.PKD.setOnDoubleClickListener(this);
            locala.PKD.setTag(parama);
            locala.PKD.setTextListener(new MMNeat7extView.a()
            {
              public final void at(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180002);
                if (((Boolean)locala.PKD.getTag(v.b.PKL)).booleanValue())
                {
                  com.tencent.mm.ui.chatting.m.a.a.gTK();
                  com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)locala.PKD.getTag(v.b.PKK)).longValue());
                }
                AppMethodBeat.o(180002);
              }
            });
            locala.PKD.setMaxLines(2147483647);
            paramString = ChattingItemTranslate.c.PPm;
            if (com.tencent.mm.app.plugin.c.Xn()) {
              if ((paramca.gDz()) && (paramca.gDI()))
              {
                parama = paramca.field_transContent;
                label1017:
                paramString = ((au)parama1.bh(au.class)).cj(paramca);
              }
            }
            for (;;)
            {
              if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
              {
                if ((locala.PKI == null) && (locala.PKH != null))
                {
                  locala.PKI = ((ChattingItemTranslate)locala.PKH.inflate());
                  locala.PKI.init();
                }
                localObject2 = t.b.Ksg.grZ();
                Context localContext = locala.PKD.getContext();
                i = (int)locala.PKD.getTextSize();
                if (paramca != null)
                {
                  localObject1 = ad.JX(paramca.field_msgSvrId);
                  ad.b localb = ad.aVe().G((String)localObject1, true);
                  localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
                  localb.l("preUsername", a(this.PhN, paramca));
                  localb.l("preChatName", b(this.PhN, paramca));
                  label1226:
                  localObject1 = l.a(localContext, parama, i, 1, localObject2, (String)localObject1, 0, l.Krf);
                  Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject1 });
                  locala.PKI.a((CharSequence)localObject1, paramString);
                  localObject1 = locala.PKI;
                  if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                    break label1525;
                  }
                }
                label1451:
                label1464:
                label1525:
                for (paramString = parama1.Pwc.getMMResources().getString(2131766752);; paramString = paramca.field_transBrandWording)
                {
                  ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                  if (!Util.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                    parama.PQG = false;
                    parama.qcr = 2;
                    locala.PKI.setTag(parama);
                    locala.PKI.setOnClickListener(gUd());
                    locala.PKI.setOnDoubleClickListener(this);
                    locala.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                    locala.PKI.setOnLongClickListener(c(parama1));
                    locala.PKI.setVisibility(0);
                  }
                  AppMethodBeat.o(36946);
                  return;
                  localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
                  break;
                  locala.tln.setVisibility(8);
                  break label288;
                  locala.PHZ.setVisibility(8);
                  break label388;
                  locala.PKD.setTag(PKJ, Boolean.FALSE);
                  locala.PKD.setOnTouchListener(locala.PKF);
                  locala.PKD.setOnLongClickListener(c(parama1));
                  locala.PKD.setOnClickListener(gUd());
                  break label937;
                  localObject1 = null;
                  break label1226;
                }
              }
              if (locala.PKI != null) {
                locala.PKI.setVisibility(8);
              }
              AppMethodBeat.o(36946);
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
        paramMenuItem = k.b.HD(bp.b(parama.gRL(), paramca.field_content, paramca.field_isSend)).title;
        ClipboardHelper.setText(paramMenuItem);
        parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
        com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
        AppMethodBeat.o(36948);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return false;
      case 124: 
      case 125: 
        ((au)parama.bh(au.class)).b(paramMenuItem, paramca);
        AppMethodBeat.o(36948);
        return false;
      case 141: 
        paramMenuItem = paramca.field_transContent;
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
        AppMethodBeat.o(36948);
        return true;
      case 142: 
        localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        paramMenuItem = paramca.field_transContent;
        if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        break;
      }
      for (;;)
      {
        if (paramca.gDg())
        {
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36948);
          return true;
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
        }
        localObject = new cz();
        paramMenuItem = paramca.field_transContent;
        if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.model.h.b((cz)localObject, paramMenuItem, 1);
          ((cz)localObject).dFZ.fragment = parama.Pwc;
          ((cz)localObject).dFZ.dGf = 43;
          if (((cz)localObject).dFZ.dGb != null)
          {
            paramMenuItem = ((cz)localObject).dFZ.dGb.Lya;
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem.bhf(paramca.field_talker);
            paramMenuItem.bhg(z.aTY());
            EventCenter.instance.publish((IEvent)localObject);
            AppMethodBeat.o(36948);
            return true;
          }
          Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233720);
      if (paramca.fqK != null) {
        paramca.fqK.contains("announcement@all");
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.qcr == 1)
      {
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
          paramm.a(i, 151, this.PhN.Pwc.getMMResources().getString(2131761482), 2131690524);
        }
        paramm.a(i, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
        paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(i, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
          paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
          paramm.a(i, 124, paramView.getContext().getString(2131757455), 2131690699);
        }
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
        }
        if (br.B(paramca))
        {
          paramm.clear();
          if (!this.PhN.gRN()) {
            paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
          }
        }
      }
      while (locala.qcr != 2)
      {
        AppMethodBeat.o(233720);
        return true;
      }
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
      paramm.a(i, 141, paramView.getContext().getString(2131757430), 2131690525);
      paramm.a(i, 142, paramView.getContext().getString(2131764628), 2131690674);
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 143, paramView.getContext().getString(2131763947), 2131690551);
      }
      if (com.tencent.mm.app.plugin.c.Xn())
      {
        if ((paramca.gDz()) && (paramca.gDI())) {
          paramm.a(i, 124, paramView.getContext().getString(2131757453), 2131690549);
        }
        if (paramca.gDL()) {
          paramm.a(i, 125, paramView.getContext().getString(2131757445), 2131690658);
        }
      }
      AppMethodBeat.o(233720);
      return false;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 805306417);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean gS(View paramView)
    {
      AppMethodBeat.i(36949);
      if (v.gQ(paramView))
      {
        Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36949);
        return true;
      }
      Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject1).addFlags(67108864);
      Object localObject2 = (bq)paramView.getTag();
      if (localObject2 != null)
      {
        CharSequence localCharSequence = ((MMNeat7extView)paramView).hiT();
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bq)localObject2).dTX.field_msgId);
        ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
        if (this.PhN != null) {
          ((Intent)localObject1).putExtra("is_group_chat", this.PhN.gRM());
        }
        localObject2 = paramView.getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kc(paramView.getContext());
      }
      AppMethodBeat.o(36949);
      return true;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n, NeatTextView.b
  {
    private static final int PKJ = 2131308867;
    private static final int PKK = 2131298495;
    private static final int PKL = 2131298494;
    private int PHj = -1;
    private v.e PKM;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private CharSequence PkM;
    private int hcg = -1;
    
    private void bK(ca paramca)
    {
      AppMethodBeat.i(233724);
      if (paramca.gDx())
      {
        Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(paramca.field_talker, paramca.fRd, true);
        if ((localObject != null) && (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, paramca.field_msgId)))
        {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
        if (localObject != null) {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().Y(paramca.field_msgId, ((Long)((Pair)localObject).second).longValue());
        }
        bp.Ad(paramca.field_msgId);
        this.PhN.BN(true);
      }
      AppMethodBeat.o(233724);
    }
    
    private v.e gUd()
    {
      AppMethodBeat.i(36956);
      if (this.PKM == null) {
        this.PKM = new v.e(this.PhN);
      }
      v.e locale = this.PKM;
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
        localObject = new an(paramLayoutInflater, 2131493591);
        ((View)localObject).setTag(new v.a().gR((View)localObject));
      }
      AppMethodBeat.o(36957);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(36958);
      final v.a locala = (v.a)parama;
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
      locala.PKD.setTag(PKK, Long.valueOf(paramca.field_msgId));
      locala.PKD.setTag(PKL, Boolean.TRUE);
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject1 = com.tencent.mm.ui.chatting.l.a.PEV;
        com.tencent.mm.ui.chatting.l.a.a.a(locala.PKD, paramca, parama1.gRM(), paramString);
        paramString = bd.cN(paramca);
        t.b.Ksg.br(paramString);
        if ((parama != null) && (parama.type == 53))
        {
          paramString = l.a(locala.PKD.getContext(), parama.title, (int)locala.PKD.getTextSize(), 4, false, paramString, l.Krf);
          v.a(locala.PKD.getContext(), parama1, parama.title, paramString, locala.PKD, paramca, 4);
          locala.PKD.setClickable(true);
          localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
          if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName.trim().length() > 0)) {
            break label1323;
          }
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gp(paramString))) {
            break label1333;
          }
          locala.tln.setText(parama1.Pwc.getMMResources().getString(2131757531, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.Pwc.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramString) }));
          locala.tln.setVisibility(0);
          a(parama1, locala.tln, parama.appId);
          a(parama1, locala.tln, parama.appId);
          label348:
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca))
          {
            locala.tln.setText(parama1.Pwc.getMMResources().getString(2131761487));
            locala.tln.setVisibility(0);
            locala.tln.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36950);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
                s.a(parama1, paramca.field_msgId, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36950);
              }
            });
          }
          if (!gTW()) {
            break label1346;
          }
        }
        label1414:
        for (;;)
        {
          boolean bool = false;
          parama = locala;
          label417:
          b(parama, bool);
          parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
          parama.PQG = false;
          paramString = locala.PKD.getContext();
          locala.PKD.setTag(PKJ, Boolean.TRUE);
          if (locala.wnj == null)
          {
            locala.wnj = new com.tencent.mm.ui.widget.b.a(paramString, locala.PKD);
            locala.wnj.QwU = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180003);
                parama1.setFocused(true);
                c.a(locala.wnj, parama1, v.c.a(v.c.this), v.c.b(v.c.this), 49);
                v.c.a(v.c.this, -1);
                v.c.b(v.c.this, -1);
                AppMethodBeat.o(180003);
              }
            };
            locala.wnj.QSv = true;
            locala.wnj.QSt = new o.e()
            {
              public final void a(com.tencent.mm.ui.base.m paramAnonymousm, View paramAnonymousView)
              {
                AppMethodBeat.i(233721);
                paramAnonymousm.clear();
                paramAnonymousm.a(0, 0, paramString.getResources().getString(2131755772), 2131690525);
                paramAnonymousm.a(0, 1, paramString.getResources().getString(2131763038), 2131690480);
                paramAnonymousm.a(0, 2, paramString.getResources().getString(2131763036), 2131690674);
                paramAnonymousm.a(0, 3, paramString.getResources().getString(2131759168), 2131690551);
                AppMethodBeat.o(233721);
              }
            };
            locala.wnj.HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(180005);
                v.c.b(v.c.this, paramAnonymousMenuItem.getItemId());
                v.c.a(v.c.this, paramAnonymousInt);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(180005);
                  return;
                  ClipboardHelper.setText(MMApplicationContext.getContext(), v.c.c(v.c.this), v.c.c(v.c.this));
                  if (locala.PKE != null)
                  {
                    locala.PKE.hbA();
                    locala.PKE.QXW = true;
                    locala.PKE.QXX = true;
                    locala.PKE.hbz();
                  }
                  Toast.makeText(paramString, 2131755773, 0).show();
                  AppMethodBeat.o(180005);
                  return;
                  if (locala.PKE != null)
                  {
                    if (locala.PKE.QXQ != null) {
                      locala.PKE.QXQ.gTY();
                    }
                    locala.PKE.QXW = true;
                    locala.PKE.hbz();
                    locala.PKE.lE(0, locala.PKD.hiT().length());
                    locala.PKE.hcQ();
                    locala.PKE.hcT();
                    if (locala.PKE.QXQ != null)
                    {
                      locala.PKE.QXQ.gTZ();
                      AppMethodBeat.o(180005);
                      return;
                      Object localObject = new Intent(paramString, MsgRetransmitUI.class);
                      ((Intent)localObject).putExtra("Retr_Msg_content", v.c.c(v.c.this));
                      ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                      paramAnonymousMenuItem = paramString;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(180005);
                      return;
                      paramAnonymousMenuItem = new cz();
                      com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, v.c.c(v.c.this).toString(), 1);
                      paramAnonymousMenuItem.dFZ.fragment = v.c.d(v.c.this).Pwc;
                      paramAnonymousMenuItem.dFZ.dGf = 43;
                      if (paramAnonymousMenuItem.dFZ.dGb != null)
                      {
                        localObject = paramAnonymousMenuItem.dFZ.dGb.Lya;
                        if (localObject != null)
                        {
                          bq localbq = (bq)locala.PKD.getTag();
                          if (localbq != null)
                          {
                            ((anh)localObject).bhf(localbq.dTX.field_talker);
                            ((anh)localObject).bhg(z.aTY());
                            EventCenter.instance.publish(paramAnonymousMenuItem);
                          }
                        }
                      }
                      if (locala.PKE != null)
                      {
                        locala.PKE.hbA();
                        locala.PKE.QXW = true;
                        locala.PKE.QXX = true;
                        locala.PKE.hbz();
                      }
                    }
                  }
                }
              }
            };
          }
          paramString = c(parama1);
          localObject1 = a(c(parama1));
          if (locala.PKE != null) {
            locala.PKE.destroy();
          }
          Object localObject2 = new int[2];
          int i = 0;
          if (locala.PKD != null)
          {
            locala.PKD.getLocationInWindow((int[])localObject2);
            int j = localObject2[0];
            i = j;
            if (j == 0)
            {
              localObject2 = new Rect();
              locala.PKD.getGlobalVisibleRect((Rect)localObject2);
              i = ((Rect)localObject2).left;
            }
          }
          for (;;)
          {
            localObject1 = new com.tencent.mm.ui.widget.textview.a.a(locala.PKD, locala.wnj, (a.f)localObject1, gUd(), locala.PKF);
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPi = 2131100167;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYg = 18;
            ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPj = 2131100165;
            if (i != 0) {
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYh = (at.aH(locala.PKD.getContext(), 2131165289) + i);
            }
            locala.PKE = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).hcW();
            locala.PKG = new v.d(locala.PKE);
            locala.PKE.QXO = new com.tencent.mm.ui.base.x()
            {
              public final void as(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180006);
                v.c.a(v.c.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180006);
              }
            };
            locala.PGP = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180007);
                locala.PKE.hbA();
                locala.PKE.QXW = true;
                locala.PKE.QXX = true;
                locala.PKE.hbz();
                AppMethodBeat.o(180007);
              }
            };
            paramString.PGP = locala.PGP;
            locala.PKE.QYc = locala.PKG;
            locala.PKD.setOnDoubleClickListener(this);
            locala.PKD.setTag(parama);
            locala.PKD.setTextListener(new MMNeat7extView.a()
            {
              public final void at(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180008);
                if (((Boolean)locala.PKD.getTag(v.c.byT())).booleanValue())
                {
                  com.tencent.mm.ui.chatting.m.a.a.gTK();
                  com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)locala.PKD.getTag(v.c.byU())).longValue());
                }
                AppMethodBeat.o(180008);
              }
            });
            paramString = ChattingItemTranslate.c.PPm;
            if (com.tencent.mm.app.plugin.c.Xn()) {
              if ((paramca.gDz()) && (paramca.gDI()))
              {
                parama = paramca.field_transContent;
                label893:
                paramString = ((au)parama1.bh(au.class)).cj(paramca);
              }
            }
            for (;;)
            {
              if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
              {
                if ((locala.PKI == null) && (locala.PKH != null))
                {
                  locala.PKI = ((ChattingItemTranslate)locala.PKH.inflate());
                  locala.PKI.init();
                }
                localObject2 = t.b.Ksg.grZ();
                Context localContext = locala.PKD.getContext();
                i = (int)locala.PKD.getTextSize();
                if (paramca != null)
                {
                  localObject1 = ad.JX(paramca.field_msgSvrId);
                  ad.b localb = ad.aVe().G((String)localObject1, true);
                  localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
                  localb.l("preUsername", a(this.PhN, paramca));
                  localb.l("preChatName", b(this.PhN, paramca));
                  label1102:
                  localObject1 = l.a(localContext, parama, i, 1, localObject2, (String)localObject1, 0, l.Krf);
                  Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject1 });
                  locala.PKI.a((CharSequence)localObject1, paramString);
                  localObject1 = locala.PKI;
                  if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                    break label1370;
                  }
                  paramString = parama1.Pwc.getMMResources().getString(2131766752);
                  label1184:
                  ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                  if (!Util.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                    parama.PQG = false;
                    parama.qcr = 2;
                    locala.PKI.setTag(parama);
                    locala.PKI.setOnClickListener(gUd());
                    locala.PKI.setOnDoubleClickListener(this);
                    locala.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                    locala.PKI.setOnLongClickListener(c(parama1));
                    locala.PKI.setVisibility(0);
                  }
                }
              }
              for (;;)
              {
                a(paramInt, locala, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
                AppMethodBeat.o(36958);
                return;
                label1323:
                paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
                break;
                label1333:
                locala.tln.setVisibility(8);
                break label348;
                label1346:
                if (paramca.field_status >= 2) {
                  break label1414;
                }
                bool = true;
                parama = locala;
                break label417;
                localObject1 = null;
                break label1102;
                label1370:
                paramString = paramca.field_transBrandWording;
                break label1184;
                if (locala.PKI != null) {
                  locala.PKI.setVisibility(8);
                }
              }
              parama = null;
              break label893;
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
        paramMenuItem = k.b.HD(bp.b(parama.gRL(), paramca.field_content, paramca.field_isSend)).title;
        ClipboardHelper.setText(paramMenuItem);
        parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
        com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
        AppMethodBeat.o(36960);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return false;
      case 103: 
        bK(paramca);
      case 124: 
      case 125: 
        for (;;)
        {
          AppMethodBeat.o(36960);
          return false;
          ((au)parama.bh(au.class)).b(paramMenuItem, paramca);
        }
      case 142: 
        localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        paramMenuItem = paramca.field_transContent;
        if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        break;
      }
      for (;;)
      {
        if (paramca.gDg())
        {
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36960);
          return true;
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
        }
        paramMenuItem = paramca.field_transContent;
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
        AppMethodBeat.o(36960);
        return true;
        localObject = new cz();
        paramMenuItem = paramca.field_transContent;
        if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.model.h.b((cz)localObject, paramMenuItem, 1);
          ((cz)localObject).dFZ.fragment = parama.Pwc;
          ((cz)localObject).dFZ.dGf = 43;
          if (((cz)localObject).dFZ.dGb != null)
          {
            paramMenuItem = ((cz)localObject).dFZ.dGb.Lya;
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem.bhf(paramca.field_talker);
            paramMenuItem.bhg(z.aTY());
            EventCenter.instance.publish((IEvent)localObject);
            AppMethodBeat.o(36960);
            return true;
          }
          Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233722);
      int i;
      ChattingItemTranslate.a locala;
      int j;
      if ((paramca.fqK != null) && (paramca.fqK.contains("announcement@all")))
      {
        i = 1;
        locala = (ChattingItemTranslate.a)paramView.getTag();
        j = locala.position;
        if (locala.qcr != 1) {
          break label443;
        }
        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
          paramm.a(j, 151, this.PhN.Pwc.getMMResources().getString(2131761482), 2131690524);
        }
        paramm.a(j, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        if (paramca.field_status == 5) {
          paramm.a(j, 103, paramView.getContext().getString(2131757500), 2131690658);
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(j, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
          paramm.a(j, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((i == 0) && (!paramca.gAt()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
        if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
          paramm.a(j, 124, paramView.getContext().getString(2131757455), 2131690699);
        }
        if (!this.PhN.gRN()) {
          paramm.a(j, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
        }
      }
      label443:
      while (locala.qcr != 2)
      {
        AppMethodBeat.o(233722);
        return true;
        i = 0;
        break;
      }
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
      paramm.a(j, 141, paramView.getContext().getString(2131757430), 2131690525);
      paramm.a(j, 142, paramView.getContext().getString(2131764628), 2131690674);
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(j, 143, paramView.getContext().getString(2131763947), 2131690551);
      }
      if (com.tencent.mm.app.plugin.c.Xn())
      {
        if ((paramca.gDz()) && (paramca.gDI())) {
          paramm.a(j, 124, paramView.getContext().getString(2131757453), 2131690549);
        }
        if (paramca.gDL()) {
          paramm.a(j, 125, paramView.getContext().getString(2131757445), 2131690658);
        }
      }
      AppMethodBeat.o(233722);
      return false;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233723);
      bK(paramca);
      AppMethodBeat.o(233723);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 805306417);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean gS(View paramView)
    {
      AppMethodBeat.i(36962);
      if (v.gQ(paramView))
      {
        Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36962);
        return true;
      }
      Object localObject2 = ((MMNeat7extView)paramView).hiT();
      Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
      if ((paramView.getTag() instanceof bq))
      {
        localObject2 = (bq)paramView.getTag();
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bq)localObject2).dTX.field_msgId);
        }
      }
      if (this.PhN != null) {
        ((Intent)localObject1).putExtra("is_group_chat", this.PhN.gRM());
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kc(paramView.getContext());
      AppMethodBeat.o(36962);
      return true;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  static final class d
    implements a.e
  {
    private com.tencent.mm.ui.widget.textview.a PkL;
    
    d(com.tencent.mm.ui.widget.textview.a parama)
    {
      this.PkL = parama;
    }
    
    public final void gUe()
    {
      AppMethodBeat.i(36963);
      Log.d("OnTouchOutside", "touchOutside");
      this.PkL.hbA();
      this.PkL.QXX = true;
      this.PkL.hcR();
      this.PkL.QXW = true;
      this.PkL.hcS();
      this.PkL.hcU();
      AppMethodBeat.o(36963);
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
      parama = (bq)paramView.getTag();
      if (paramca.gDg())
      {
        if (this.PhN != null)
        {
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(36964);
        return;
      }
      if ((paramca.isText()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.gTK();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dTX);
      }
      AppMethodBeat.o(36964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */