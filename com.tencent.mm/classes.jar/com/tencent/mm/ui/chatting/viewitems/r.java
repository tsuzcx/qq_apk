package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
{
  public static void a(Context paramContext, final com.tencent.mm.ui.chatting.e.a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final bu parambu, int paramInt)
  {
    AppMethodBeat.i(194373);
    Object localObject1 = paramCharSequence;
    if (((com.tencent.mm.ui.chatting.d.b.v)parama.bh(com.tencent.mm.ui.chatting.d.b.v.class)).bO(parambu))
    {
      localObject1 = parambu.field_solitaireFoldInfo;
      Object localObject2 = new StringBuilder();
      if (((bvn)localObject1).GPG != null)
      {
        localObject3 = ((bvn)localObject1).GPG.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bvo)((Iterator)localObject3).next();
          ((StringBuilder)localObject2).append(bt.bI(bt.bI(((bvo)localObject4).GPK, ""), "")).append(paramString.substring(((bvo)localObject4).start, ((bvo)localObject4).end));
        }
      }
      if (!bt.isNullOrNil(((StringBuilder)localObject2).toString())) {
        ((StringBuilder)localObject2).append("\n");
      }
      if ((!bt.isNullOrNil(((StringBuilder)localObject2).toString())) && (((bvn)localObject1).uBz == 1)) {
        ((StringBuilder)localObject2).append("\n");
      }
      localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a(paramContext, (CharSequence)localObject2, (int)paramMMNeat7extView.getTextSize(), paramInt);
      Object localObject4 = paramContext.getString(2131763114);
      Object localObject3 = new SpannableString((CharSequence)localObject4);
      ((SpannableString)localObject3).setSpan(new o(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194367);
          ad.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((com.tencent.mm.ui.chatting.d.b.v)parama.bh(com.tencent.mm.ui.chatting.d.b.v.class)).bO(parambu))
          {
            ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(194367);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(2131307173, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((com.tencent.mm.ui.chatting.d.b.v)parama.bh(com.tencent.mm.ui.chatting.d.b.v.class)).DV(((Long)paramMMNeat7extView.getTag(2131298134)).longValue());
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramAnonymousView = parama.getTalkerUserName();
          bvn localbvn = this.KbX;
          fl localfl = new fl();
          localfl.dRB = localfl.t("ChatName", paramAnonymousView, true);
          localfl.ekQ = localbvn.dAY;
          localfl.ekU = localfl.t("Identifier", localbvn.key, true);
          localfl.elf = localbvn.GPH.size();
          localfl.elg = localbvn.GPJ;
          localfl.aLk();
          AppMethodBeat.o(194367);
        }
      }, 0, ((String)localObject4).length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((bvn)localObject1).GPH != null)
      {
        paramCharSequence = ((bvn)localObject1).GPH.iterator();
        while (paramCharSequence.hasNext())
        {
          parambu = (bvo)paramCharSequence.next();
          parama.append(bt.bI(parambu.GPK, "")).append(paramString.substring(parambu.start, parambu.end)).append("\n");
        }
      }
      if (((bvn)localObject1).GPI != null)
      {
        parama.append("\n");
        parama.append(bt.bI(((bvn)localObject1).GPI.GPK, "")).append(paramString.substring(((bvn)localObject1).GPI.start, ((bvn)localObject1).GPI.end));
      }
      paramContext = com.tencent.mm.pluginsdk.ui.span.k.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject2, localObject3 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(194373);
  }
  
  public static boolean gv(View paramView)
  {
    AppMethodBeat.i(194374);
    if (paramView == null)
    {
      AppMethodBeat.o(194374);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(2131307173)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(194374);
        return true;
      }
    }
    catch (Exception paramView)
    {
      ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(194374);
    }
    return false;
  }
  
  static final class a
    extends c.a
  {
    com.tencent.mm.ui.widget.b.a JEB;
    a.f JXY;
    protected ImageView JYs;
    protected TextView JZp;
    protected MMNeat7extView KbY;
    com.tencent.mm.ui.widget.textview.a KbZ;
    com.tencent.mm.pluginsdk.ui.span.g Kca;
    a.e Kcb;
    ViewStub Kcc;
    ChattingItemTranslate Kcd;
    View ize;
    protected TextView rDq;
    
    public final a gw(View paramView)
    {
      AppMethodBeat.i(36935);
      super.gn(paramView);
      this.KbY = ((MMNeat7extView)paramView.findViewById(2131298073));
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.rDq = ((TextView)paramView.findViewById(2131298044));
      this.JZp = ((TextView)paramView.findViewById(2131298023));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.ize = paramView.findViewById(2131298071);
      this.Kcc = ((ViewStub)paramView.findViewById(2131306075));
      this.Kca = new com.tencent.mm.pluginsdk.ui.span.g(this.KbY, new n(this.KbY.getContext()));
      AppMethodBeat.o(36935);
      return this;
    }
  }
  
  public static final class b
    extends c
    implements NeatTextView.b
  {
    private static final int Kce = 2131305626;
    private static final int Kcf = 2131298134;
    private static final int Kcg = 2131298133;
    private com.tencent.mm.ui.chatting.e.a JBI;
    private CharSequence JEC;
    private int JYA = -1;
    private r.e Kch;
    private int goB = -1;
    
    private r.e fHq()
    {
      AppMethodBeat.i(36944);
      if (this.Kch == null) {
        this.Kch = new r.e(this.JBI);
      }
      r.e locale = this.Kch;
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
        localObject = new ah(paramLayoutInflater, 2131493440);
        ((View)localObject).setTag(new r.a().gw((View)localObject));
      }
      AppMethodBeat.o(36945);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, final String paramString)
    {
      AppMethodBeat.i(36946);
      this.JBI = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
      final r.a locala = (r.a)parama;
      locala.KbY.setTag(Kcf, Long.valueOf(parambu.field_msgId));
      locala.KbY.setTag(Kcg, Boolean.TRUE);
      paramString = parambu.field_content;
      parama = paramString;
      int i;
      if (parama1.fFv())
      {
        i = parambu.field_content.indexOf(':');
        parama = paramString;
        if (i != -1) {
          parama = parambu.field_content.substring(i + 1);
        }
      }
      if (parama != null) {}
      label288:
      label1470:
      for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
      {
        Object localObject1;
        int j;
        if ((parama != null) && (parama.type == 53))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(parama.appId, true, false);
          if ((localObject1 == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName.trim().length() <= 0))
          {
            paramString = parama.appName;
            if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fx(paramString))) {
              break label1383;
            }
            locala.rDq.setText(parama1.JOR.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.JOR.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramString) }));
            locala.rDq.setVisibility(0);
            a(parama1, locala.rDq, parama.appId);
            a(parama1, locala.rDq, parama.appId);
            if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu))
            {
              locala.rDq.setText(parama1.JOR.getMMResources().getString(2131760106));
              locala.rDq.setVisibility(0);
              locala.rDq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(36936);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambu.field_msgId) });
                  com.tencent.mm.ui.chatting.r.a(parama1, parambu.field_msgId, 1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(36936);
                }
              });
            }
            if ((parama.fkq == null) || (parama.fkq.length() <= 0)) {
              break label1396;
            }
            b(parama1, locala.JZp, bk.aWI(parama.fkq));
            locala.JZp.setVisibility(0);
            paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.KbY.getContext(), parama.title, (int)locala.KbY.getTextSize(), 1);
            r.a(locala.KbY.getContext(), parama1, parama.title, paramString, locala.KbY, parambu, 1);
            locala.KbY.setClickable(true);
            parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
            paramString = locala.KbY.getContext();
            locala.KbY.setTag(Kce, Boolean.TRUE);
            if (locala.JEB == null)
            {
              locala.JEB = new com.tencent.mm.ui.widget.b.a(paramString, locala.KbY);
              locala.JEB.KLB = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(179995);
                  parama1.setFocused(true);
                  c.a(locala.JEB, parama1, r.b.a(r.b.this), r.b.b(r.b.this), 49);
                  r.b.a(r.b.this, -1);
                  r.b.b(r.b.this, -1);
                  AppMethodBeat.o(179995);
                }
              };
              locala.JEB.Lal = true;
              locala.JEB.Laj = new n.c()
              {
                public final void a(l paramAnonymousl, View paramAnonymousView)
                {
                  AppMethodBeat.i(194368);
                  paramAnonymousl.clear();
                  paramAnonymousl.a(0, 0, paramString.getResources().getString(2131755701), 2131690381);
                  paramAnonymousView = locala.KbY.fSO();
                  bk localbk = (bk)locala.KbY.getTag();
                  if (localbk != null) {}
                  for (int i = bl.F(localbk.dBd);; i = 0)
                  {
                    if ((i <= 0) || (i >= paramAnonymousView.length())) {
                      paramAnonymousl.a(0, 1, paramString.getResources().getString(2131761224), 2131691572);
                    }
                    paramAnonymousl.a(0, 2, paramString.getResources().getString(2131761223), 2131690478);
                    paramAnonymousl.a(0, 3, paramString.getResources().getString(2131758845), 2131690400);
                    AppMethodBeat.o(194368);
                    return;
                  }
                }
              };
              locala.JEB.KJz = new n.e()
              {
                public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(179999);
                  r.b.a(r.b.this, paramAnonymousInt);
                  r.b.b(r.b.this, paramAnonymousMenuItem.getItemId());
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(179999);
                    return;
                    ((android.content.ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(r.b.c(r.b.this), r.b.c(r.b.this)));
                    if (locala.KbZ != null)
                    {
                      locala.KbZ.fNt();
                      locala.KbZ.LfQ = true;
                      locala.KbZ.LfR = true;
                      locala.KbZ.fNs();
                    }
                    Toast.makeText(paramString, 2131755702, 0).show();
                    AppMethodBeat.o(179999);
                    return;
                    if (locala.KbZ != null)
                    {
                      if (locala.KbZ.LfB != null) {
                        locala.KbZ.LfB.fHl();
                      }
                      locala.KbZ.LfQ = true;
                      locala.KbZ.fNs();
                      locala.KbZ.kp(0, locala.KbY.fSO().length());
                      locala.KbZ.fNv();
                      locala.KbZ.fNy();
                      if (locala.KbZ.LfB != null)
                      {
                        locala.KbZ.LfB.fHm();
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = (bk)locala.KbY.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = bl.E(paramAnonymousMenuItem.dBd);
                          Object localObject;
                          if (bt.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject).putExtra("Retr_Msg_content", r.b.c(r.b.this));
                            ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(179999);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179997);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
                              com.tencent.mm.bs.d.b(r.b.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              AppMethodBeat.o(179997);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(179998);
                              Object localObject = new Intent(r.b.4.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", r.b.c(r.b.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = r.b.4.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(179998);
                            }
                          });
                          AppMethodBeat.o(179999);
                          return;
                          paramAnonymousMenuItem = new cv();
                          com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, r.b.c(r.b.this).toString(), 1);
                          paramAnonymousMenuItem.dnG.fragment = r.b.d(r.b.this).JOR;
                          paramAnonymousMenuItem.dnG.dnM = 43;
                          if (paramAnonymousMenuItem.dnG.dnI != null)
                          {
                            localObject = paramAnonymousMenuItem.dnG.dnI.Gjv;
                            if (localObject != null)
                            {
                              bk localbk = (bk)locala.KbY.getTag();
                              if (localbk != null)
                              {
                                ((akj)localObject).aPf(localbk.dBd.field_talker);
                                ((akj)localObject).aPg(u.aAm());
                                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                              }
                            }
                          }
                          if (locala.KbZ != null)
                          {
                            locala.KbZ.fNt();
                            locala.KbZ.LfQ = true;
                            locala.KbZ.LfR = true;
                            locala.KbZ.fNs();
                          }
                        }
                      }
                    }
                  }
                }
              };
            }
            if (bl.z(parambu)) {
              break label1409;
            }
            j = bl.F(parambu);
            if ((j > 0) && (j < com.tencent.mm.ui.widget.textview.b.hh(locala.KbY).length())) {
              break label1517;
            }
            j = 0;
          }
        }
        label975:
        label1383:
        label1517:
        for (;;)
        {
          paramString = c(parama1);
          localObject1 = a(paramString);
          if (locala.KbZ != null) {
            locala.KbZ.destroy();
          }
          Object localObject2 = new int[2];
          i = 0;
          if (locala.KbY != null)
          {
            locala.KbY.getLocationOnScreen((int[])localObject2);
            int k = localObject2[0];
            i = k;
            if (k == 0)
            {
              localObject2 = new Rect();
              locala.KbY.getGlobalVisibleRect((Rect)localObject2);
              i = ((Rect)localObject2).left;
            }
          }
          for (;;)
          {
            localObject1 = new a.a(locala.KbY, locala.JEB, (a.f)localObject1, fHq(), locala.Kca);
            ((a.a)localObject1).LfH = 2131100846;
            ((a.a)localObject1).Lgb = 18;
            ((a.a)localObject1).LfI = 2131100195;
            if (i != 0) {
              ((a.a)localObject1).Lgc = (com.tencent.mm.ui.aq.ay(locala.KbY.getContext(), 2131165289) + i);
            }
            locala.KbZ = ((a.a)localObject1).fNB();
            locala.Kcb = new r.d(locala.KbZ);
            locala.KbZ.Lfz = new com.tencent.mm.ui.base.v()
            {
              public final void an(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180000);
                r.b.a(r.b.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180000);
              }
            };
            locala.JXY = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180001);
                locala.KbZ.fNt();
                locala.KbZ.LfQ = true;
                locala.KbZ.LfR = true;
                locala.KbZ.fNs();
                AppMethodBeat.o(180001);
              }
            };
            paramString.JXY = locala.JXY;
            locala.KbZ.LfM = j;
            locala.KbZ.LfX = locala.Kcb;
            label895:
            locala.KbY.setOnDoubleClickListener(this);
            locala.KbY.setTag(parama);
            locala.KbY.setTextListener(new MMNeat7extView.a()
            {
              public final void ao(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180002);
                if (((Boolean)locala.KbY.getTag(r.b.Kcg)).booleanValue())
                {
                  com.tencent.mm.ui.chatting.m.a.a.fGX();
                  com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)locala.KbY.getTag(r.b.Kcf)).longValue());
                }
                AppMethodBeat.o(180002);
              }
            });
            locala.KbY.setMaxLines(2147483647);
            paramString = ChattingItemTranslate.b.Kgd;
            if (com.tencent.mm.app.plugin.c.Ng()) {
              if ((parambu.frS()) && (parambu.fsb()))
              {
                parama = parambu.field_transContent;
                paramString = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
              }
            }
            for (;;)
            {
              if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.Kgd))
              {
                if ((locala.Kcd == null) && (locala.Kcc != null))
                {
                  locala.Kcd = ((ChattingItemTranslate)locala.Kcc.inflate());
                  locala.Kcd.init();
                }
                localObject2 = locala.KbY.getContext();
                i = (int)locala.KbY.getTextSize();
                if (parambu != null)
                {
                  localObject1 = y.AH(parambu.field_msgSvrId);
                  y.b localb = y.aBq().F((String)localObject1, true);
                  localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
                  localb.k("preUsername", b(this.JBI, parambu));
                  localb.k("preChatName", c(this.JBI, parambu));
                  localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, parama, i, 1, null, (String)localObject1);
                  ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject1 });
                  locala.Kcd.a((CharSequence)localObject1, paramString);
                  localObject1 = locala.Kcd;
                  if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
                    break label1470;
                  }
                }
                for (paramString = parama1.JOR.getMMResources().getString(2131764409);; paramString = parambu.field_transBrandWording)
                {
                  ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
                  if (!bt.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
                    parama.Khy = false;
                    parama.oIb = 2;
                    locala.Kcd.setTag(parama);
                    locala.Kcd.setOnClickListener(fHq());
                    locala.Kcd.setOnDoubleClickListener(this);
                    locala.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                    locala.Kcd.setOnLongClickListener(c(parama1));
                    locala.Kcd.setVisibility(0);
                  }
                  AppMethodBeat.o(36946);
                  return;
                  paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
                  break;
                  locala.rDq.setVisibility(8);
                  break label288;
                  label1396:
                  locala.JZp.setVisibility(8);
                  break label388;
                  locala.KbY.setTag(Kce, Boolean.FALSE);
                  locala.KbY.setOnTouchListener(locala.Kca);
                  locala.KbY.setOnLongClickListener(c(parama1));
                  locala.KbY.setOnClickListener(fHq());
                  break label895;
                  localObject1 = null;
                  break label1176;
                }
              }
              if (locala.Kcd != null) {
                locala.Kcd.setVisibility(8);
              }
              AppMethodBeat.o(36946);
              return;
              parama = null;
              break label975;
              parama = null;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
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
        com.tencent.mm.ui.chatting.r.a(parama, parambu.field_msgId, 2);
        AppMethodBeat.o(36948);
        return false;
      case 102: 
        paramMenuItem = (android.content.ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = k.b.yr(bj.b(parama.fFu(), parambu.field_content, parambu.field_isSend)).title;
        paramMenuItem.setText(parama);
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yBN;
        com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(parama));
        AppMethodBeat.o(36948);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return false;
      case 124: 
      case 125: 
        ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, parambu);
        AppMethodBeat.o(36948);
        return false;
      case 141: 
        paramMenuItem = (android.text.ClipboardManager)aj.getContext().getSystemService("clipboard");
        parambu = parambu.field_transContent;
        if (!bt.isNullOrNil(parambu)) {
          paramMenuItem.setText(parambu);
        }
        com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
        AppMethodBeat.o(36948);
        return true;
      case 142: 
        localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        paramMenuItem = parambu.field_transContent;
        if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        break;
      }
      for (;;)
      {
        if (parambu.frz())
        {
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36948);
          return true;
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
        }
        localObject = new cv();
        paramMenuItem = parambu.field_transContent;
        if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.model.g.b((cv)localObject, paramMenuItem, 1);
          ((cv)localObject).dnG.fragment = parama.JOR;
          ((cv)localObject).dnG.dnM = 43;
          if (((cv)localObject).dnG.dnI != null)
          {
            paramMenuItem = ((cv)localObject).dnG.dnI.Gjv;
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem.aPf(parambu.field_talker);
            paramMenuItem.aPg(u.aAm());
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            AppMethodBeat.o(36948);
            return true;
          }
          ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194369);
      if (parambu.eLs != null) {
        parambu.eLs.contains("announcement@all");
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.oIb == 1)
      {
        ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu)) {
          paraml.a(i, 151, this.JBI.JOR.getMMResources().getString(2131760101), 2131691573);
        }
        paraml.a(i, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
        paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(i, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
          paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
          paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
        }
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
        }
        if (bl.z(parambu))
        {
          paraml.clear();
          if (!this.JBI.fFw()) {
            paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
          }
        }
      }
      while (locala.oIb != 2)
      {
        AppMethodBeat.o(194369);
        return true;
      }
      ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
      paraml.a(i, 141, paramView.getContext().getString(2131757218), 2131690381);
      paraml.a(i, 142, paramView.getContext().getString(2131762559), 2131690478);
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(i, 143, paramView.getContext().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.app.plugin.c.Ng())
      {
        if ((parambu.frS()) && (parambu.fsb())) {
          paraml.a(i, 124, paramView.getContext().getString(2131757240), 2131690398);
        }
        if (parambu.fse()) {
          paraml.a(i, 125, paramView.getContext().getString(2131757233), 2131690467);
        }
      }
      AppMethodBeat.o(194369);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 805306417);
    }
    
    public final boolean fHh()
    {
      return false;
    }
    
    public final boolean gx(View paramView)
    {
      AppMethodBeat.i(36949);
      if (r.gv(paramView))
      {
        ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36949);
        return true;
      }
      Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject1).addFlags(67108864);
      Object localObject2 = (bk)paramView.getTag();
      if (localObject2 != null)
      {
        CharSequence localCharSequence = ((MMNeat7extView)paramView).fSO();
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dBd.field_msgId);
        ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
        localObject2 = paramView.getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kd(paramView.getContext());
      }
      AppMethodBeat.o(36949);
      return true;
    }
  }
  
  public static final class c
    extends c
    implements s.n, NeatTextView.b
  {
    private static final int Kce = 2131305626;
    private static final int Kcf = 2131298134;
    private static final int Kcg = 2131298133;
    private com.tencent.mm.ui.chatting.e.a JBI;
    private CharSequence JEC;
    private int JYA = -1;
    private r.e Kch;
    private int goB = -1;
    
    private void bw(bu parambu)
    {
      AppMethodBeat.i(194372);
      if (parambu.frQ())
      {
        Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parambu.field_talker, parambu.fkC, true);
        if ((localObject != null) && (bt.aA(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, parambu.field_msgId)))
        {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
        if (localObject != null) {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().V(parambu.field_msgId, ((Long)((Pair)localObject).second).longValue());
        }
        bj.rJ(parambu.field_msgId);
        this.JBI.xR(true);
      }
      AppMethodBeat.o(194372);
    }
    
    private r.e fHq()
    {
      AppMethodBeat.i(36956);
      if (this.Kch == null) {
        this.Kch = new r.e(this.JBI);
      }
      r.e locale = this.Kch;
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
        localObject = new ah(paramLayoutInflater, 2131493484);
        ((View)localObject).setTag(new r.a().gw((View)localObject));
      }
      AppMethodBeat.o(36957);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36961);
      bw(parambu);
      AppMethodBeat.o(36961);
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, final String paramString)
    {
      AppMethodBeat.i(36958);
      paramString = (r.a)parama;
      this.JBI = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
      paramString.KbY.setTag(Kcf, Long.valueOf(parambu.field_msgId));
      paramString.KbY.setTag(Kcg, Boolean.TRUE);
      parama = parambu.field_content;
      if (parama != null) {}
      label1291:
      for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
      {
        Object localObject1;
        Object localObject2;
        if ((parama != null) && (parama.type == 53))
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.KbY.getContext(), parama.title, (int)paramString.KbY.getTextSize(), 4);
          r.a(paramString.KbY.getContext(), parama1, parama.title, (CharSequence)localObject1, paramString.KbY, parambu, 4);
          paramString.KbY.setClickable(true);
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(parama.appId, true, false);
          if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
            break label1268;
          }
          localObject1 = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fx((String)localObject1))) {
            break label1278;
          }
          paramString.rDq.setText(parama1.JOR.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.JOR.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1) }));
          paramString.rDq.setVisibility(0);
          a(parama1, paramString.rDq, parama.appId);
          a(parama1, paramString.rDq, parama.appId);
          label306:
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu))
          {
            paramString.rDq.setText(parama1.JOR.getMMResources().getString(2131760106));
            paramString.rDq.setVisibility(0);
            paramString.rDq.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36950);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambu.field_msgId) });
                com.tencent.mm.ui.chatting.r.a(parama1, parambu.field_msgId, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36950);
              }
            });
          }
          if (!fHj()) {
            break label1291;
          }
        }
        label1052:
        label1315:
        label1359:
        for (;;)
        {
          boolean bool = false;
          parama = paramString;
          label375:
          b(parama, bool);
          parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
          parama.Khy = false;
          localObject1 = paramString.KbY.getContext();
          paramString.KbY.setTag(Kce, Boolean.TRUE);
          if (paramString.JEB == null)
          {
            paramString.JEB = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.KbY);
            paramString.JEB.KLB = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180003);
                parama1.setFocused(true);
                c.a(paramString.JEB, parama1, r.c.a(r.c.this), r.c.b(r.c.this), 49);
                r.c.a(r.c.this, -1);
                r.c.b(r.c.this, -1);
                AppMethodBeat.o(180003);
              }
            };
            paramString.JEB.Lal = true;
            paramString.JEB.Laj = new n.c()
            {
              public final void a(l paramAnonymousl, View paramAnonymousView)
              {
                AppMethodBeat.i(194370);
                paramAnonymousl.clear();
                paramAnonymousl.a(0, 0, this.val$context.getResources().getString(2131755701), 2131690381);
                paramAnonymousl.a(0, 1, this.val$context.getResources().getString(2131761224), 2131691572);
                paramAnonymousl.a(0, 2, this.val$context.getResources().getString(2131761223), 2131690478);
                paramAnonymousl.a(0, 3, this.val$context.getResources().getString(2131758845), 2131690400);
                AppMethodBeat.o(194370);
              }
            };
            paramString.JEB.KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(180005);
                r.c.b(r.c.this, paramAnonymousMenuItem.getItemId());
                r.c.a(r.c.this, paramAnonymousInt);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(180005);
                  return;
                  ((android.content.ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(r.c.c(r.c.this), r.c.c(r.c.this)));
                  if (paramString.KbZ != null)
                  {
                    paramString.KbZ.fNt();
                    paramString.KbZ.LfQ = true;
                    paramString.KbZ.LfR = true;
                    paramString.KbZ.fNs();
                  }
                  Toast.makeText(this.val$context, 2131755702, 0).show();
                  AppMethodBeat.o(180005);
                  return;
                  if (paramString.KbZ != null)
                  {
                    if (paramString.KbZ.LfB != null) {
                      paramString.KbZ.LfB.fHl();
                    }
                    paramString.KbZ.LfQ = true;
                    paramString.KbZ.fNs();
                    paramString.KbZ.kp(0, paramString.KbY.fSO().length());
                    paramString.KbZ.fNv();
                    paramString.KbZ.fNy();
                    if (paramString.KbZ.LfB != null)
                    {
                      paramString.KbZ.LfB.fHm();
                      AppMethodBeat.o(180005);
                      return;
                      Object localObject = new Intent(this.val$context, MsgRetransmitUI.class);
                      ((Intent)localObject).putExtra("Retr_Msg_content", r.c.c(r.c.this));
                      ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                      paramAnonymousMenuItem = this.val$context;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(180005);
                      return;
                      paramAnonymousMenuItem = new cv();
                      com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, r.c.c(r.c.this).toString(), 1);
                      paramAnonymousMenuItem.dnG.fragment = r.c.d(r.c.this).JOR;
                      paramAnonymousMenuItem.dnG.dnM = 43;
                      if (paramAnonymousMenuItem.dnG.dnI != null)
                      {
                        localObject = paramAnonymousMenuItem.dnG.dnI.Gjv;
                        if (localObject != null)
                        {
                          bk localbk = (bk)paramString.KbY.getTag();
                          if (localbk != null)
                          {
                            ((akj)localObject).aPf(localbk.dBd.field_talker);
                            ((akj)localObject).aPg(u.aAm());
                            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                          }
                        }
                      }
                      if (paramString.KbZ != null)
                      {
                        paramString.KbZ.fNt();
                        paramString.KbZ.LfQ = true;
                        paramString.KbZ.LfR = true;
                        paramString.KbZ.fNs();
                      }
                    }
                  }
                }
              }
            };
          }
          localObject1 = c(parama1);
          localObject2 = a(c(parama1));
          if (paramString.KbZ != null) {
            paramString.KbZ.destroy();
          }
          Object localObject3 = new int[2];
          int i = 0;
          if (paramString.KbY != null)
          {
            paramString.KbY.getLocationOnScreen((int[])localObject3);
            int j = localObject3[0];
            i = j;
            if (j == 0)
            {
              localObject3 = new Rect();
              paramString.KbY.getGlobalVisibleRect((Rect)localObject3);
              i = ((Rect)localObject3).left;
            }
          }
          for (;;)
          {
            localObject2 = new a.a(paramString.KbY, paramString.JEB, (a.f)localObject2, fHq(), paramString.Kca);
            ((a.a)localObject2).LfH = 2131100135;
            ((a.a)localObject2).Lgb = 18;
            ((a.a)localObject2).LfI = 2131100133;
            if (i != 0) {
              ((a.a)localObject2).Lgc = (com.tencent.mm.ui.aq.ay(paramString.KbY.getContext(), 2131165284) + i);
            }
            paramString.KbZ = ((a.a)localObject2).fNB();
            paramString.Kcb = new r.d(paramString.KbZ);
            paramString.KbZ.Lfz = new com.tencent.mm.ui.base.v()
            {
              public final void an(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180006);
                r.c.a(r.c.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180006);
              }
            };
            paramString.JXY = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180007);
                paramString.KbZ.fNt();
                paramString.KbZ.LfQ = true;
                paramString.KbZ.LfR = true;
                paramString.KbZ.fNs();
                AppMethodBeat.o(180007);
              }
            };
            ((c.c)localObject1).JXY = paramString.JXY;
            paramString.KbZ.LfX = paramString.Kcb;
            paramString.KbY.setOnDoubleClickListener(this);
            paramString.KbY.setTag(parama);
            paramString.KbY.setTextListener(new MMNeat7extView.a()
            {
              public final void ao(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180008);
                if (((Boolean)paramString.KbY.getTag(r.c.bcX())).booleanValue())
                {
                  com.tencent.mm.ui.chatting.m.a.a.fGX();
                  com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)paramString.KbY.getTag(r.c.bcY())).longValue());
                }
                AppMethodBeat.o(180008);
              }
            });
            localObject1 = ChattingItemTranslate.b.Kgd;
            if (com.tencent.mm.app.plugin.c.Ng()) {
              if ((parambu.frS()) && (parambu.fsb()))
              {
                parama = parambu.field_transContent;
                label851:
                localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
              }
            }
            for (;;)
            {
              if ((!bt.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.b.Kgd))
              {
                if ((paramString.Kcd == null) && (paramString.Kcc != null))
                {
                  paramString.Kcd = ((ChattingItemTranslate)paramString.Kcc.inflate());
                  paramString.Kcd.init();
                }
                localObject3 = paramString.KbY.getContext();
                i = (int)paramString.KbY.getTextSize();
                if (parambu != null)
                {
                  localObject2 = y.AH(parambu.field_msgSvrId);
                  y.b localb = y.aBq().F((String)localObject2, true);
                  localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
                  localb.k("preUsername", b(this.JBI, parambu));
                  localb.k("preChatName", c(this.JBI, parambu));
                  localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject3, parama, i, 1, null, (String)localObject2);
                  ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject2 });
                  paramString.Kcd.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
                  localObject2 = paramString.Kcd;
                  if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
                    break label1315;
                  }
                  localObject1 = parama1.JOR.getMMResources().getString(2131764409);
                  label1129:
                  ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
                  if (!bt.isNullOrNil(parama))
                  {
                    parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
                    parama.Khy = false;
                    parama.oIb = 2;
                    paramString.Kcd.setTag(parama);
                    paramString.Kcd.setOnClickListener(fHq());
                    paramString.Kcd.setOnDoubleClickListener(this);
                    paramString.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                    paramString.Kcd.setOnLongClickListener(c(parama1));
                    paramString.Kcd.setVisibility(0);
                  }
                }
              }
              for (;;)
              {
                a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
                AppMethodBeat.o(36958);
                return;
                label1268:
                localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
                break;
                label1278:
                paramString.rDq.setVisibility(8);
                break label306;
                if (parambu.field_status >= 2) {
                  break label1359;
                }
                bool = true;
                parama = paramString;
                break label375;
                localObject2 = null;
                break label1052;
                localObject1 = parambu.field_transBrandWording;
                break label1129;
                if (paramString.Kcd != null) {
                  paramString.Kcd.setVisibility(8);
                }
              }
              parama = null;
              break label851;
              parama = null;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
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
        com.tencent.mm.ui.chatting.r.a(parama, parambu.field_msgId, 2);
        AppMethodBeat.o(36960);
        return false;
      case 102: 
        paramMenuItem = (android.content.ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = k.b.yr(bj.b(parama.fFu(), parambu.field_content, parambu.field_isSend)).title;
        paramMenuItem.setText(parama);
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yBN;
        com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(parama));
        AppMethodBeat.o(36960);
        return false;
      case 111: 
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return false;
      case 103: 
        bw(parambu);
      case 124: 
      case 125: 
        for (;;)
        {
          AppMethodBeat.o(36960);
          return false;
          ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, parambu);
        }
      case 142: 
        localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        paramMenuItem = parambu.field_transContent;
        if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        break;
      }
      for (;;)
      {
        if (parambu.frz())
        {
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36960);
          return true;
          ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
        }
        paramMenuItem = (android.text.ClipboardManager)aj.getContext().getSystemService("clipboard");
        parambu = parambu.field_transContent;
        if (!bt.isNullOrNil(parambu)) {
          paramMenuItem.setText(parambu);
        }
        com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
        AppMethodBeat.o(36960);
        return true;
        localObject = new cv();
        paramMenuItem = parambu.field_transContent;
        if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.model.g.b((cv)localObject, paramMenuItem, 1);
          ((cv)localObject).dnG.fragment = parama.JOR;
          ((cv)localObject).dnG.dnM = 43;
          if (((cv)localObject).dnG.dnI != null)
          {
            paramMenuItem = ((cv)localObject).dnG.dnI.Gjv;
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem.aPf(parambu.field_talker);
            paramMenuItem.aPg(u.aAm());
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            AppMethodBeat.o(36960);
            return true;
          }
          ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
          break;
        }
      }
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194371);
      int i;
      ChattingItemTranslate.a locala;
      int j;
      if ((parambu.eLs != null) && (parambu.eLs.contains("announcement@all")))
      {
        i = 1;
        locala = (ChattingItemTranslate.a)paramView.getTag();
        j = locala.position;
        if (locala.oIb != 1) {
          break label443;
        }
        ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
        if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu)) {
          paraml.a(j, 151, this.JBI.JOR.getMMResources().getString(2131760101), 2131691573);
        }
        paraml.a(j, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
        paraml.a(j, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        if (parambu.field_status == 5) {
          paraml.a(j, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(j, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
          paraml.a(j, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((i == 0) && (!parambu.fpd()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
          paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
          paraml.a(j, 124, paramView.getContext().getString(2131757242), 2131690491);
        }
        if (!this.JBI.fFw()) {
          paraml.a(j, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
        }
      }
      label443:
      while (locala.oIb != 2)
      {
        AppMethodBeat.o(194371);
        return true;
        i = 0;
        break;
      }
      ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
      paraml.a(j, 141, paramView.getContext().getString(2131757218), 2131690381);
      paraml.a(j, 142, paramView.getContext().getString(2131762559), 2131690478);
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(j, 143, paramView.getContext().getString(2131761941), 2131690400);
      }
      if (com.tencent.mm.app.plugin.c.Ng())
      {
        if ((parambu.frS()) && (parambu.fsb())) {
          paraml.a(j, 124, paramView.getContext().getString(2131757240), 2131690398);
        }
        if (parambu.fse()) {
          paraml.a(j, 125, paramView.getContext().getString(2131757233), 2131690467);
        }
      }
      AppMethodBeat.o(194371);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 805306417);
    }
    
    public final boolean fHh()
    {
      return true;
    }
    
    public final boolean gx(View paramView)
    {
      AppMethodBeat.i(36962);
      if (r.gv(paramView))
      {
        ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(36962);
        return true;
      }
      Object localObject2 = ((MMNeat7extView)paramView).fSO();
      Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
      if ((paramView.getTag() instanceof bk))
      {
        localObject2 = (bk)paramView.getTag();
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bk)localObject2).dBd.field_msgId);
        }
      }
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kd(paramView.getContext());
      AppMethodBeat.o(36962);
      return true;
    }
  }
  
  static final class d
    implements a.e
  {
    private com.tencent.mm.ui.widget.textview.a JEA;
    
    d(com.tencent.mm.ui.widget.textview.a parama)
    {
      this.JEA = parama;
    }
    
    public final void fHr()
    {
      AppMethodBeat.i(36963);
      ad.d("OnTouchOutside", "touchOutside");
      this.JEA.fNt();
      this.JEA.LfR = true;
      this.JEA.fNw();
      this.JEA.LfQ = true;
      this.JEA.fNx();
      this.JEA.fNz();
      AppMethodBeat.o(36963);
    }
  }
  
  static final class e
    extends s.e
  {
    public e(com.tencent.mm.ui.chatting.e.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36964);
      parama = (bk)paramView.getTag();
      if (parambu.frz())
      {
        if (this.JBI != null)
        {
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.bs.d.b(this.JBI.JOR.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(36964);
        return;
      }
      if ((parambu.isText()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.fGX();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dBd);
      }
      AppMethodBeat.o(36964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r
 * JD-Core Version:    0.7.0.1
 */