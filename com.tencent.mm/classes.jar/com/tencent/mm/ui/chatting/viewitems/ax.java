package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
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
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
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
import com.tencent.mm.ui.widget.MMNeat7extView.b;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import java.util.HashMap;
import java.util.Map;

public final class ax
{
  private static final int Kcf = 2131298134;
  private static final int Kcg = 2131298133;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.e.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, bu parambu, int paramInt)
  {
    AppMethodBeat.i(194496);
    r.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, parambu, paramInt);
    AppMethodBeat.o(194496);
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
      paramf.Kao.setBackgroundResource(2131231647);
      paramf.Kap.setTextColor(parama.JOR.getContext().getResources().getColor(2131099673));
      paramf.Kap.setText(2131760124);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.Kao.setBackgroundResource(2131231648);
    paramf.Kap.setTextColor(parama.JOR.getContext().getResources().getColor(2131099699));
    paramf.Kap.setText(2131760126);
    AppMethodBeat.o(180039);
  }
  
  public static class a
    extends c
    implements NeatTextView.b
  {
    private static final int Kce = 2131305626;
    private static final int Kcf = 2131298134;
    private static final int Kcg = 2131298133;
    private com.tencent.mm.ui.chatting.e.a JBI;
    private CharSequence JEC;
    private int JYA = -1;
    private ax.e KfP;
    private int goB = -1;
    
    private String cx(bu parambu)
    {
      AppMethodBeat.i(37397);
      if (parambu != null)
      {
        String str = y.AH(parambu.field_msgSvrId);
        y.b localb = y.aBq().F(str, true);
        localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
        localb.k("preUsername", b(this.JBI, parambu));
        localb.k("preChatName", c(this.JBI, parambu));
        AppMethodBeat.o(37397);
        return str;
      }
      AppMethodBeat.o(37397);
      return null;
    }
    
    private ax.e fHt()
    {
      AppMethodBeat.i(37393);
      if (this.KfP == null) {
        this.KfP = new ax.e(this.JBI);
      }
      ax.e locale = this.KfP;
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
        ((View)localObject).setTag(new ax.f().z((View)localObject, true));
      }
      AppMethodBeat.o(37394);
      return localObject;
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
    {
      AppMethodBeat.i(37396);
      this.JBI = parama1;
      final ax.f localf = (ax.f)parama;
      Object localObject2 = parambu.field_content;
      paramString = parama1.getTalkerUserName();
      localf.KfT.setTag(Kcf, Long.valueOf(parambu.field_msgId));
      localf.KfT.setTag(Kcg, Boolean.TRUE);
      parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
      localf.KfT.setTag(parama);
      Object localObject1 = ChattingItemTranslate.b.Kgd;
      if (com.tencent.mm.app.plugin.c.Ng()) {
        if ((parambu.frS()) && (parambu.fsb()))
        {
          parama = parambu.field_transContent;
          localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
        }
      }
      for (;;)
      {
        int i;
        Object localObject3;
        if ((parama1.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh((String)localObject2);
          if (i != -1)
          {
            localObject3 = ((String)localObject2).substring(0, i).trim();
            if ((localObject3 != null) && (((String)localObject3).length() > 0))
            {
              paramString = (String)localObject3;
              localObject2 = ((String)localObject2).substring(i + 1).trim();
              if (!bt.isNullOrNil(parama))
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
          a(localf, parama1, parambu, parama);
          a(localf, parama1, parama, parambu);
          Bundle localBundle;
          int j;
          if ((parambu.eLs != null) && (parambu.fso()))
          {
            i = 1;
            localBundle = new Bundle();
            localBundle.putLong("msgSvrId", parambu.field_msgSvrId);
            j = 1;
            if (i != 0) {
              break label1140;
            }
            if (!am.aSQ(parama)) {
              break label1093;
            }
            parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), (CharSequence)localObject2, (int)localf.KfT.getTextSize(), localBundle, cx(parambu));
            label353:
            localObject2 = (com.tencent.mm.ui.chatting.d.b.ai)parama1.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
            if (!((com.tencent.mm.ui.chatting.d.b.ai)localObject2).DX(parambu.field_msgId)) {
              break label1706;
            }
            localObject2 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, ((com.tencent.mm.ui.chatting.d.b.ai)localObject2).fEG(), e.a.tuy, b.b.tyb));
            localf.KfT.a(((com.tencent.mm.plugin.fts.a.a.f)localObject2).tuE, TextView.BufferType.SPANNABLE);
          }
          label1285:
          label1697:
          label1706:
          for (i = 0;; i = 1)
          {
            localObject2 = (o[])parama.getSpans(0, parama.length(), o.class);
            int k = localObject2.length;
            j = 0;
            label446:
            if (j < k) {
              if (localObject2[j].getType() == 44) {
                com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(7), "" });
              }
            }
            for (;;)
            {
              label493:
              if (i != 0) {
                ax.a(localf.KfT.getContext(), parama1, parambu.field_content, parama, localf.KfT, parambu, 1);
              }
              if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu))
              {
                localf.rDq.setText(parama1.JOR.getMMResources().getString(2131760106));
                localf.rDq.setVisibility(0);
                localf.rDq.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37383);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    ad.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { localf.KfT.getTag(ax.a.aNt()) });
                    com.tencent.mm.ui.chatting.r.a(parama1, ((Long)localf.KfT.getTag(ax.a.aNt())).longValue(), 1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37383);
                  }
                });
              }
              for (;;)
              {
                ax.a(parambu, localf, parama1);
                localObject2 = localf.KfT.getContext();
                localf.KfT.setTag(Kce, Boolean.TRUE);
                if (localf.JEB == null)
                {
                  localf.JEB = new com.tencent.mm.ui.widget.b.a((Context)localObject2, localf.KfT);
                  localf.JEB.KLB = new PopupWindow.OnDismissListener()
                  {
                    public final void onDismiss()
                    {
                      AppMethodBeat.i(180024);
                      parama1.setFocused(true);
                      c.a(localf.JEB, parama1, ax.a.a(ax.a.this), ax.a.b(ax.a.this), 1);
                      ax.a.a(ax.a.this, -1);
                      ax.a.b(ax.a.this, -1);
                      AppMethodBeat.o(180024);
                    }
                  };
                  localf.JEB.Lal = true;
                  localf.JEB.Lao = false;
                  localf.JEB.Laj = new n.c()
                  {
                    public final void a(l paramAnonymousl, View paramAnonymousView)
                    {
                      AppMethodBeat.i(194492);
                      paramAnonymousl.clear();
                      paramAnonymousl.a(0, 0, this.val$context.getResources().getString(2131755701), 2131690381);
                      paramAnonymousView = localf.KfT.fSO();
                      bk localbk = (bk)localf.KfT.getTag();
                      if (localbk != null) {}
                      for (int i = bl.F(localbk.dBd);; i = 0)
                      {
                        if ((i <= 0) || (i >= paramAnonymousView.length())) {
                          paramAnonymousl.a(0, 1, this.val$context.getResources().getString(2131761224), 2131691572);
                        }
                        paramAnonymousl.a(0, 2, this.val$context.getResources().getString(2131761223), 2131690478);
                        paramAnonymousl.a(0, 3, this.val$context.getResources().getString(2131758845), 2131690400);
                        boolean bool;
                        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                        {
                          paramAnonymousl.a(0, 4, this.val$context.getResources().getString(2131762922), 2131690474);
                          bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(ax.a.c(ax.a.this).toString());
                          if ((!bool) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
                            break label307;
                          }
                          ax.a.this.a(localf.JEB, parama1);
                        }
                        for (;;)
                        {
                          paramAnonymousl = "65_" + cf.aCM();
                          ax.a.this.a(parama1, parambu, 1, bool, ax.a.c(ax.a.this).toString(), true, paramAnonymousl);
                          AppMethodBeat.o(194492);
                          return;
                          label307:
                          localf.JEB.Laq = null;
                        }
                      }
                    }
                  };
                  localf.JEB.KJz = new n.e()
                  {
                    public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
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
                        ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(ax.a.c(ax.a.this), ax.a.c(ax.a.this)));
                        if (localf.KbZ != null)
                        {
                          localf.KbZ.fNt();
                          localf.KbZ.LfQ = true;
                          localf.KbZ.LfR = true;
                          localf.KbZ.fNs();
                        }
                        Toast.makeText(this.val$context, 2131755702, 0).show();
                        Object localObject1;
                        Object localObject2;
                        try
                        {
                          paramAnonymousMenuItem = (bk)localf.KfT.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(paramAnonymousMenuItem.dBd, false);
                            localObject2 = new eq();
                            ((eq)localObject2).ein = paramAnonymousMenuItem.dBd.field_msgSvrId;
                            ((eq)localObject2).eip = ((String)localObject1).length();
                            ((eq)localObject2).eio = ax.a.c(ax.a.this).length();
                            ((eq)localObject2).eiq = bl.F(paramAnonymousMenuItem.dBd);
                            ((eq)localObject2).aLk();
                            ax.c(paramAnonymousMenuItem.dBd, 3, ax.a.c(ax.a.this).length());
                          }
                          AppMethodBeat.o(180028);
                          return;
                        }
                        catch (Exception paramAnonymousMenuItem)
                        {
                          ad.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                          AppMethodBeat.o(180028);
                          return;
                        }
                        if (localf.KbZ != null)
                        {
                          if (localf.KbZ.LfB != null) {
                            localf.KbZ.LfB.fHl();
                          }
                          localf.KbZ.LfQ = true;
                          localf.KbZ.fNs();
                          localf.KbZ.kp(0, localf.KfT.fSO().length());
                          localf.KbZ.fNv();
                          localf.KbZ.fNy();
                          if (localf.KbZ.LfB != null)
                          {
                            localf.KbZ.LfB.fHm();
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = (bk)localf.KfT.getTag();
                            if (paramAnonymousMenuItem != null)
                            {
                              ax.c(paramAnonymousMenuItem.dBd, 4, 0);
                              paramAnonymousMenuItem = bl.E(paramAnonymousMenuItem.dBd);
                              if (bt.isNullOrNil(paramAnonymousMenuItem))
                              {
                                localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                                ((Intent)localObject1).putExtra("Retr_Msg_content", ax.a.c(ax.a.this));
                                ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                                paramAnonymousMenuItem = this.val$context;
                                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
                                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(180028);
                                return;
                              }
                              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                              com.tencent.mm.ui.base.h.a(this.val$context, 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                              {
                                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                                {
                                  AppMethodBeat.i(180026);
                                  paramAnonymous2DialogInterface = new Intent();
                                  paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                                  paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
                                  paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
                                  com.tencent.mm.bs.d.b(ax.a.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                                  com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramAnonymousMenuItem });
                                  AppMethodBeat.o(180026);
                                }
                              }, new DialogInterface.OnClickListener()
                              {
                                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                                {
                                  AppMethodBeat.i(180027);
                                  Object localObject = new Intent(ax.a.4.this.val$context, MsgRetransmitUI.class);
                                  ((Intent)localObject).putExtra("Retr_Msg_content", ax.a.c(ax.a.this));
                                  ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                                  paramAnonymous2DialogInterface = ax.a.4.this.val$context;
                                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                  com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramAnonymousMenuItem });
                                  AppMethodBeat.o(180027);
                                }
                              });
                              AppMethodBeat.o(180028);
                              return;
                              paramAnonymousMenuItem = new cv();
                              com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, ax.a.c(ax.a.this).toString(), 1);
                              paramAnonymousMenuItem.dnG.fragment = ax.a.d(ax.a.this).JOR;
                              paramAnonymousMenuItem.dnG.dnM = 43;
                              if (paramAnonymousMenuItem.dnG.dnI != null)
                              {
                                localObject1 = paramAnonymousMenuItem.dnG.dnI.Gjv;
                                if (localObject1 != null)
                                {
                                  localObject2 = (bk)localf.KfT.getTag();
                                  if (localObject2 != null)
                                  {
                                    ax.c(((bk)localObject2).dBd, 5, 0);
                                    ((akj)localObject1).aPf(((bk)localObject2).dBd.field_talker);
                                    ((akj)localObject1).aPg(u.aAm());
                                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                                  }
                                }
                              }
                              if (localf.KbZ != null)
                              {
                                localf.KbZ.fNt();
                                localf.KbZ.LfQ = true;
                                localf.KbZ.LfR = true;
                                localf.KbZ.fNs();
                                AppMethodBeat.o(180028);
                                return;
                                paramAnonymousMenuItem = "65_" + cf.aCM();
                                localObject1 = ax.a.c(ax.a.this).toString();
                                boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                                ax.a.this.a(parama1, parambu, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
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
                ax.a(parama1, bl.G(parambu), parama, localf.KfT);
                if ((!bl.z(parambu)) && (!bl.A(parambu))) {
                  break label1355;
                }
                localf.KfT.setTag(Kce, Boolean.FALSE);
                localf.KfT.setOnTouchListener(localf.Kca);
                localf.KfT.setOnLongClickListener(c(parama1));
                localf.KfT.setOnClickListener(fHt());
                localf.KfT.setOnDoubleClickListener(this);
                localf.KfT.setTextListener(new MMNeat7extView.a()
                {
                  public final void ao(CharSequence paramAnonymousCharSequence)
                  {
                    AppMethodBeat.i(180031);
                    if (((Boolean)localf.KfT.getTag(ax.a.dsn())).booleanValue())
                    {
                      com.tencent.mm.ui.chatting.m.a.a.fGX();
                      com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)localf.KfT.getTag(ax.a.aNt())).longValue());
                    }
                    AppMethodBeat.o(180031);
                  }
                });
                if ((bt.isNullOrNil(paramString)) && (localObject1 == ChattingItemTranslate.b.Kgd)) {
                  break label1667;
                }
                if (localf.Kcd == null)
                {
                  localf.Kcd = ((ChattingItemTranslate)localf.Kcc.inflate());
                  localf.Kcd.init();
                }
                parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), paramString, (int)localf.KfT.getTextSize(), 1, null, cx(parambu));
                localf.Kcd.a(parama, (ChattingItemTranslate.b)localObject1);
                localObject1 = localf.Kcd;
                if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
                  break label1658;
                }
                parama = parama1.JOR.getMMResources().getString(2131764409);
                label955:
                ((ChattingItemTranslate)localObject1).setBrandWording(parama);
                if (!bt.isNullOrNil(paramString))
                {
                  parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
                  parama.Khy = false;
                  parama.oIb = 2;
                  localf.Kcd.setTag(parama);
                  localf.Kcd.getContentView().setTag(parama);
                  localf.Kcd.setOnClickListener(fHt());
                  localf.Kcd.setOnDoubleClickListener(this);
                  localf.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                  localf.Kcd.setOnLongClickListener(c(parama1));
                  localf.Kcd.setVisibility(0);
                }
                AppMethodBeat.o(37396);
                return;
                i = 0;
                break;
                label1093:
                parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), (CharSequence)localObject2, (int)localf.KfT.getTextSize(), 1, localBundle, cx(parambu));
                break label353;
                j += 1;
                break label446;
                break label493;
                label1140:
                if (i == 0) {
                  break label1697;
                }
                if (parambu.eLs.contains("notify@all")) {}
                for (localObject3 = "";; localObject3 = localf.KfT.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
                {
                  localBundle.putInt("geta8key_scene", 31);
                  if (!am.aSQ(parama)) {
                    break label1285;
                  }
                  parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), localObject3 + localObject2, (int)localf.KfT.getTextSize(), localBundle, cx(parambu));
                  i = j;
                  break;
                }
                parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), localObject3 + localObject2, (int)localf.KfT.getTextSize(), 1, localBundle, cx(parambu));
                i = j;
                break label493;
                localf.rDq.setVisibility(8);
              }
              label1355:
              j = bl.F(parambu);
              if ((j <= 0) || (j >= com.tencent.mm.ui.widget.textview.b.hh(localf.KfT).length())) {
                j = 0;
              }
              for (;;)
              {
                parama = c(parama1);
                localObject2 = a(parama);
                if (localf.KbZ != null) {
                  localf.KbZ.destroy();
                }
                localObject3 = new int[2];
                i = 0;
                if (localf.KfT != null)
                {
                  localf.KfT.getLocationOnScreen((int[])localObject3);
                  k = localObject3[0];
                  i = k;
                  if (k == 0)
                  {
                    localObject3 = new Rect();
                    localf.KfT.getGlobalVisibleRect((Rect)localObject3);
                    i = ((Rect)localObject3).left;
                  }
                }
                for (;;)
                {
                  localObject2 = new a.a(localf.KfT, localf.JEB, (a.f)localObject2, fHt(), localf.Kca);
                  ((a.a)localObject2).LfH = 2131100846;
                  ((a.a)localObject2).Lgb = 18;
                  ((a.a)localObject2).LfI = 2131100195;
                  if (i != 0) {
                    ((a.a)localObject2).Lgc = (com.tencent.mm.ui.aq.ay(localf.KfT.getContext(), 2131165289) + i);
                  }
                  localf.KbZ = ((a.a)localObject2).fNB();
                  localf.Kcb = new ax.d(localf.KbZ);
                  localf.KbZ.Lfz = new com.tencent.mm.ui.base.v()
                  {
                    public final void an(CharSequence paramAnonymousCharSequence)
                    {
                      AppMethodBeat.i(180029);
                      ax.a.a(ax.a.this, paramAnonymousCharSequence);
                      AppMethodBeat.o(180029);
                    }
                  };
                  localf.JXY = new a.f()
                  {
                    public final void dismiss()
                    {
                      AppMethodBeat.i(180030);
                      localf.KbZ.fNt();
                      localf.KbZ.LfQ = true;
                      localf.KbZ.LfR = true;
                      localf.KbZ.fNs();
                      AppMethodBeat.o(180030);
                    }
                  };
                  parama.JXY = localf.JXY;
                  localf.KbZ.LfM = j;
                  localf.KbZ.LfX = localf.Kcb;
                  break;
                  label1658:
                  parama = parambu.field_transBrandWording;
                  break label955;
                  if (localf.Kcd != null) {
                    localf.Kcd.setVisibility(8);
                  }
                  AppMethodBeat.o(37396);
                  return;
                }
              }
              parama = null;
              i = j;
            }
          }
          label1667:
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
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, bk parambk)
    {
      AppMethodBeat.i(37399);
      if (parambk == null)
      {
        AppMethodBeat.o(37399);
        return false;
      }
      final bu localbu = parambk.dBd;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37399);
        return false;
      case 141: 
        parambk = localbu.field_transContent;
        paramMenuItem = parambk;
        if (parama.fFv())
        {
          paramMenuItem = parambk;
          if (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH())
          {
            i = bj.Bh(parambk);
            paramMenuItem = parambk;
            if (i != -1) {
              paramMenuItem = parambk.substring(i + 1).trim();
            }
          }
        }
        parambk = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
        if (!bt.isNullOrNil(paramMenuItem)) {
          parambk.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
        AppMethodBeat.o(37399);
        return true;
      case 142: 
        parambk = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        paramMenuItem = localbu.field_transContent;
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
        if (localbu.frz())
        {
          parambk.putExtra("Retr_Msg_content", paramMenuItem);
          parambk.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(parambk);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37399);
          return true;
          parambk.putExtra("Retr_Msg_content", paramMenuItem);
          parambk.putExtra("Retr_Msg_Type", 4);
        }
        Object localObject2 = new cv();
        Object localObject1 = localbu.field_transContent;
        if ((parama.fFv()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
        {
          i = bj.Bh((String)localObject1);
          if (i != -1) {
            localObject1 = ((String)localObject1).substring(i + 1).trim();
          }
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.model.g.b((cv)localObject2, (String)localObject1, 1);
          ((cv)localObject2).dnG.fragment = parama.JOR;
          ((cv)localObject2).dnG.dnM = 43;
          if (((cv)localObject2).dnG.dnI != null)
          {
            localObject1 = ((cv)localObject2).dnG.dnI.Gjv;
            if (localObject1 != null)
            {
              ((akj)localObject1).aPf(localbu.field_talker);
              ((akj)localObject1).aPg(u.aAm());
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
            localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(((ChattingItemTranslate.a)parambk).dBd, false);
            paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
            if (localObject1 != null) {
              break label856;
            }
            i = 0;
            label660:
            ad.d("MicroMsg.ChattingItemTextFrom", i);
          }
          for (;;)
          {
            try
            {
              if ((bl.G(localbu) < 2) || (bt.ai(((ChattingItemTranslate.a)parambk).Kgc))) {
                break label1203;
              }
              paramMenuItem = ((ChattingItemTranslate.a)parambk).Kgc;
            }
            catch (Exception paramMenuItem)
            {
              for (;;)
              {
                try
                {
                  ((android.content.ClipboardManager)localObject2).setText(paramMenuItem);
                  ax.c(localbu, 3, paramMenuItem.length());
                  com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
                  parama = com.tencent.mm.plugin.secinforeport.a.a.yBN;
                  com.tencent.mm.plugin.secinforeport.a.a.o(1, localbu.field_msgSvrId, bt.aQW(paramMenuItem.toString()));
                }
                catch (Exception parambk)
                {
                  label856:
                  continue;
                }
                try
                {
                  parama = new eq();
                  parama.ein = localbu.field_msgSvrId;
                  parama.eip = paramMenuItem.length();
                  parama.eio = this.JEC.length();
                  parama.eiq = bl.F(localbu);
                  parama.aLk();
                  AppMethodBeat.o(37399);
                  return true;
                  ad.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                  break;
                  i = ((CharSequence)localObject1).length();
                  break label660;
                  paramMenuItem = paramMenuItem;
                  paramMenuItem = (MenuItem)localObject1;
                  ad.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
                }
                catch (Exception paramMenuItem)
                {
                  ad.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
                }
              }
            }
            ax.c(localbu, 4, 0);
            paramMenuItem = bl.E(localbu);
            if (bt.isNullOrNil(paramMenuItem))
            {
              paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
              parambk = ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(localbu, false);
              if (localbu.frz())
              {
                paramMenuItem.putExtra("Retr_Msg_content", parambk);
                paramMenuItem.putExtra("Retr_Msg_Type", 6);
              }
              for (;;)
              {
                paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
                com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)paramMenuItem.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
                paramMenuItem.putExtra("Retr_Msg_content", parambk);
                paramMenuItem.putExtra("Retr_Msg_Type", 4);
              }
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
            com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(37392);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
                paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
                paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
                com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
                AppMethodBeat.o(37392);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(180032);
                paramAnonymousDialogInterface = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
                Object localObject = ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(localbu, false);
                if (localbu.frz())
                {
                  paramAnonymousDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
                  paramAnonymousDialogInterface.putExtra("Retr_Msg_Type", 6);
                }
                for (;;)
                {
                  localObject = parama.JOR.getContext();
                  paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousDialogInterface);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject).startActivity((Intent)paramAnonymousDialogInterface.mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
                  AppMethodBeat.o(180032);
                  return;
                  paramAnonymousDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
                  paramAnonymousDialogInterface.putExtra("Retr_Msg_Type", 4);
                }
              }
            });
            break;
            ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, localbu);
            break;
            com.tencent.mm.ui.chatting.r.a(parama, localbu.field_msgId, 2);
            AppMethodBeat.o(37399);
            return false;
            label1203:
            paramMenuItem = (MenuItem)localObject1;
          }
        }
      }
    }
    
    public boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194493);
      if ((!parambu.isText()) && (!parambu.frz()))
      {
        AppMethodBeat.o(194493);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.oIb == 1)
      {
        if (parambu.isText())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu)) {
            paraml.a(i, 151, this.JBI.JOR.getMMResources().getString(2131760101), 2131691573);
          }
          if (!bl.A(parambu)) {
            paraml.a(i, 102, paramView.getContext().getString(2131757218), 2131690381);
          }
        }
        if (!bl.A(parambu)) {
          paraml.a(i, 108, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
          paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((parambu.isText()) && (com.tencent.mm.am.g.aFz())) {
          this.JBI.fFw();
        }
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
          paraml.a(i, 124, paramView.getContext().getString(2131757242), 2131690491);
        }
        if ((bl.z(parambu)) || (bl.G(parambu) == 4))
        {
          paraml.clear();
          if (!this.JBI.fFw()) {
            paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
          }
        }
      }
      while (locala.oIb != 2)
      {
        AppMethodBeat.o(194493);
        return true;
      }
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
      AppMethodBeat.o(194493);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37400);
      if ((paramView instanceof MMTextView))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.fGX();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parambu);
      }
      AppMethodBeat.o(37400);
      return true;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37395);
      boolean bool = parama.fFv();
      AppMethodBeat.o(37395);
      return bool;
    }
    
    public boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    protected boolean fHg()
    {
      return false;
    }
    
    public final boolean fHh()
    {
      return false;
    }
    
    public final boolean gx(View paramView)
    {
      AppMethodBeat.i(37401);
      if (r.gv(paramView))
      {
        ad.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(37401);
        return true;
      }
      Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject2).addFlags(67108864);
      ChattingItemTranslate.a locala;
      if ((paramView.getTag() instanceof ChattingItemTranslate.a))
      {
        locala = (ChattingItemTranslate.a)paramView.getTag();
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dBd.field_msgId);
        if (((com.tencent.mm.ui.chatting.d.b.v)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.v.class)).bO(locala.dBd))
        {
          localObject1 = ((MMNeat7extView)paramView).fSO().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kd(paramView.getContext());
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(locala.dBd.field_talker);
        }
      }
      else
      {
        AppMethodBeat.o(37401);
        return true;
      }
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.aq)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      bu localbu = locala.dBd;
      if (locala.oIb == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)localObject1).e(localbu, bool);
        break;
      }
    }
  }
  
  public static class b
    extends c
    implements s.n, NeatTextView.b
  {
    private static final int Kce = 2131305626;
    private com.tencent.mm.ui.chatting.e.a JBI;
    private CharSequence JEC;
    private int JYA = -1;
    private ax.e KfP;
    private int goB = -1;
    
    private void bw(bu parambu)
    {
      AppMethodBeat.i(37411);
      if (!this.JBI.getTalkerUserName().equals("medianote"))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.f(parambu.field_talker, parambu.field_msgSvrId));
      }
      com.tencent.mm.ui.chatting.aj.bw(parambu);
      this.JBI.xR(true);
      AppMethodBeat.o(37411);
    }
    
    private String cx(bu parambu)
    {
      AppMethodBeat.i(37412);
      if (parambu != null)
      {
        String str = y.AH(parambu.field_msgSvrId);
        y.b localb = y.aBq().F(str, true);
        localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
        localb.k("preUsername", b(this.JBI, parambu));
        localb.k("preChatName", c(this.JBI, parambu));
        AppMethodBeat.o(37412);
        return str;
      }
      AppMethodBeat.o(37412);
      return null;
    }
    
    private ax.e fHt()
    {
      AppMethodBeat.i(37408);
      if (this.KfP == null) {
        this.KfP = new ax.e(this.JBI);
      }
      ax.e locale = this.KfP;
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
        ((View)localObject).setTag(new ax.f().z((View)localObject, false));
      }
      AppMethodBeat.o(37409);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37415);
      parambu.frY();
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      if ((parambu.isText()) && (parambu.field_isSend == 1)) {
        bw(parambu);
      }
      AppMethodBeat.o(37415);
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, final String paramString)
    {
      AppMethodBeat.i(37410);
      this.JBI = parama1;
      final ax.f localf = (ax.f)parama;
      localf.KfT.setTag(ax.Kcf, Long.valueOf(parambu.field_msgId));
      localf.KfT.setTag(ax.Kcg, Boolean.TRUE);
      localf.KfT.setMaxLines(2147483647);
      parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
      parama.Khy = false;
      localf.KfT.setTag(parama);
      label224:
      Object localObject;
      if (fHj())
      {
        b(localf, false);
        if ((parambu.field_status == 1) || (parambu.field_status == 5))
        {
          if (localf.JZD != null) {
            localf.JZD.setVisibility(8);
          }
          localf.KfT.setBackgroundResource(2131231726);
          parambu.IMh = true;
          paramString = parambu.field_content;
          if (bt.isNullOrNil(paramString)) {
            ad.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgSvrId) });
          }
          if ((parambu.eLs == null) || (!parambu.fso())) {
            break label1233;
          }
          i = 1;
          localObject = new Bundle();
          ((Bundle)localObject).putLong("msgSvrId", parambu.field_msgSvrId);
          if (i != 0) {
            break label1248;
          }
          paramString = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), paramString, (int)localf.KfT.getTextSize(), 4, localObject, cx(parambu));
          parama = (com.tencent.mm.ui.chatting.d.b.ai)parama1.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
          if (!parama.DX(parambu.field_msgId)) {
            break label1745;
          }
          parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(paramString, parama.fEG(), e.a.tuy, b.b.tyc));
          localf.KfT.a(parama.tuE, TextView.BufferType.SPANNABLE);
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
            com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(6), "" });
            parama = paramString;
            k = i;
          }
        }
        else
        {
          if (k != 0) {
            ax.a(localf.KfT.getContext(), parama1, parambu.field_content, parama, localf.KfT, parambu, 4);
          }
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu)) {
            break label1378;
          }
          localf.rDq.setText(parama1.JOR.getMMResources().getString(2131760106));
          localf.rDq.setVisibility(0);
          localf.rDq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37402);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", new Object[] { localf.KfT.getTag(ax.Kcf) });
              com.tencent.mm.ui.chatting.r.a(parama1, ((Long)localf.KfT.getTag(ax.Kcf)).longValue(), 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37402);
            }
          });
        }
        for (;;)
        {
          ax.a(parambu, localf, parama1);
          paramString = localf.KfT.getContext();
          localf.KfT.setTag(Kce, Boolean.TRUE);
          if (localf.JEB == null)
          {
            localf.JEB = new com.tencent.mm.ui.widget.b.a(paramString, localf.KfT);
            localf.JEB.KLB = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180033);
                parama1.setFocused(true);
                c.a(localf.JEB, parama1, ax.b.a(ax.b.this), ax.b.b(ax.b.this), 1);
                ax.b.a(ax.b.this, -1);
                ax.b.b(ax.b.this, -1);
                AppMethodBeat.o(180033);
              }
            };
            localf.JEB.Lal = true;
            localf.JEB.Lao = false;
            localf.JEB.Laj = new n.c()
            {
              public final void a(l paramAnonymousl, View paramAnonymousView)
              {
                AppMethodBeat.i(194494);
                paramAnonymousl.clear();
                paramAnonymousl.a(0, 0, paramString.getResources().getString(2131755701), 2131690381);
                paramAnonymousView = localf.KfT.fSO();
                bk localbk = (bk)localf.KfT.getTag();
                if (localbk != null) {}
                for (int i = bl.F(localbk.dBd);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymousl.a(0, 1, paramString.getResources().getString(2131761224), 2131691572);
                  }
                  paramAnonymousl.a(0, 2, paramString.getResources().getString(2131761223), 2131690478);
                  paramAnonymousl.a(0, 3, paramString.getResources().getString(2131758845), 2131690400);
                  boolean bool;
                  if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                  {
                    paramAnonymousl.a(0, 4, paramString.getResources().getString(2131762922), 2131690474);
                    bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(ax.b.c(ax.b.this).toString());
                    if ((!bool) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
                      break label307;
                    }
                    ax.b.this.a(localf.JEB, parama1);
                  }
                  for (;;)
                  {
                    paramAnonymousl = "65_" + cf.aCM();
                    ax.b.this.a(parama1, parambu, 1, bool, ax.b.c(ax.b.this).toString(), true, paramAnonymousl);
                    AppMethodBeat.o(194494);
                    return;
                    label307:
                    localf.JEB.Laq = null;
                  }
                }
              }
            };
            localf.JEB.KJz = new n.e()
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
                  ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(ax.b.c(ax.b.this), ax.b.c(ax.b.this)));
                  if (localf.KbZ != null)
                  {
                    localf.KbZ.fNt();
                    localf.KbZ.LfQ = true;
                    localf.KbZ.LfR = true;
                    localf.KbZ.fNs();
                  }
                  Toast.makeText(paramString, 2131755702, 0).show();
                  Object localObject1;
                  Object localObject2;
                  try
                  {
                    paramAnonymousMenuItem = (bk)localf.KfT.getTag();
                    if (paramAnonymousMenuItem != null)
                    {
                      localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(paramAnonymousMenuItem.dBd, false);
                      localObject2 = new eq();
                      ((eq)localObject2).ein = paramAnonymousMenuItem.dBd.field_msgSvrId;
                      ((eq)localObject2).eip = ((String)localObject1).length();
                      ((eq)localObject2).eio = ax.b.c(ax.b.this).length();
                      ((eq)localObject2).eiq = bl.F(paramAnonymousMenuItem.dBd);
                      ((eq)localObject2).aLk();
                      ax.c(paramAnonymousMenuItem.dBd, 3, ax.b.c(ax.b.this).length());
                    }
                    AppMethodBeat.o(180035);
                    return;
                  }
                  catch (Exception paramAnonymousMenuItem)
                  {
                    ad.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                    AppMethodBeat.o(180035);
                    return;
                  }
                  if (localf.KbZ != null)
                  {
                    if (localf.KbZ.LfB != null) {
                      localf.KbZ.LfB.fHl();
                    }
                    localf.KbZ.LfQ = true;
                    localf.KbZ.fNs();
                    localf.KbZ.kp(0, localf.KfT.fSO().length());
                    localf.KbZ.fNv();
                    localf.KbZ.fNy();
                    if (localf.KbZ.LfB != null)
                    {
                      localf.KbZ.LfB.fHm();
                      AppMethodBeat.o(180035);
                      return;
                      ax.c(parambu, 4, 0);
                      localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                      ((Intent)localObject1).putExtra("Retr_Msg_content", ax.b.c(ax.b.this));
                      ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                      paramAnonymousMenuItem = paramString;
                      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(180035);
                      return;
                      ax.c(parambu, 5, 0);
                      paramAnonymousMenuItem = new cv();
                      com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, ax.b.c(ax.b.this).toString(), 1);
                      paramAnonymousMenuItem.dnG.fragment = ax.b.d(ax.b.this).JOR;
                      paramAnonymousMenuItem.dnG.dnM = 43;
                      if (paramAnonymousMenuItem.dnG.dnI != null)
                      {
                        localObject1 = paramAnonymousMenuItem.dnG.dnI.Gjv;
                        if (localObject1 != null)
                        {
                          localObject2 = (bk)localf.KfT.getTag();
                          if (localObject2 != null)
                          {
                            ((akj)localObject1).aPf(u.aAm());
                            ((akj)localObject1).aPg(((bk)localObject2).dBd.field_talker);
                            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                          }
                        }
                      }
                      if (localf.KbZ != null)
                      {
                        localf.KbZ.fNt();
                        localf.KbZ.LfQ = true;
                        localf.KbZ.LfR = true;
                        localf.KbZ.fNs();
                        AppMethodBeat.o(180035);
                        return;
                        paramAnonymousMenuItem = "65_" + cf.aCM();
                        localObject1 = ax.b.c(ax.b.this).toString();
                        boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord((String)localObject1);
                        ax.b.this.a(parama1, parambu, 2, bool, (String)localObject1, true, paramAnonymousMenuItem);
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
          ax.a(parama1, bl.G(parambu), parama, localf.KfT);
          if ((!bl.z(parambu)) && (!bl.A(parambu))) {
            break label1391;
          }
          localf.KfT.setTag(Kce, Boolean.FALSE);
          localf.KfT.setOnTouchListener(localf.Kca);
          localf.KfT.setOnLongClickListener(c(parama1));
          localf.KfT.setOnClickListener(fHt());
          localf.KfT.setOnDoubleClickListener(this);
          localf.KfT.setTextListener(new MMNeat7extView.a()
          {
            public final void ao(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180038);
              if (((Boolean)localf.KfT.getTag(ax.Kcg)).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.fGX();
                com.tencent.mm.ui.chatting.m.a.a.fGY().a(paramAnonymousCharSequence, ((Long)localf.KfT.getTag(ax.Kcf)).longValue());
              }
              AppMethodBeat.o(180038);
            }
          });
          paramString = ChattingItemTranslate.b.Kgd;
          if (!com.tencent.mm.app.plugin.c.Ng()) {
            break label1734;
          }
          if ((!parambu.frS()) || (!parambu.fsb())) {
            break label1729;
          }
          parama = parambu.field_transContent;
          paramString = ((com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bT(parambu);
          if ((bt.isNullOrNil(parama)) && (paramString == ChattingItemTranslate.b.Kgd)) {
            break label1708;
          }
          if (localf.Kcd == null)
          {
            localf.Kcd = ((ChattingItemTranslate)localf.Kcc.inflate());
            localf.Kcd.init();
          }
          localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), parama, (int)localf.KfT.getTextSize(), 1, null, cx(parambu));
          localf.Kcd.a((CharSequence)localObject, paramString);
          localObject = localf.Kcd;
          if (!bt.isNullOrNil(parambu.field_transBrandWording)) {
            break label1698;
          }
          paramString = parama1.JOR.getMMResources().getString(2131764409);
          ((ChattingItemTranslate)localObject).setBrandWording(paramString);
          if (!bt.isNullOrNil(parama))
          {
            parama = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
            parama.oIb = 2;
            localf.Kcd.setTag(parama);
            localf.Kcd.getContentView().setTag(parama);
            localf.Kcd.setOnClickListener(fHt());
            localf.Kcd.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
            localf.Kcd.setOnDoubleClickListener(this);
            localf.Kcd.setOnLongClickListener(c(parama1));
            localf.Kcd.setVisibility(0);
          }
          a(paramInt, localf, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
          AppMethodBeat.o(37410);
          return;
          localf.KfT.setBackgroundResource(2131231725);
          if (localf.JZD == null) {
            break;
          }
          if (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))
          {
            if (parambu.IMh)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localf.KfT.startAnimation(parama);
              parambu.IMh = false;
            }
            localf.JZD.setVisibility(0);
            break;
          }
          localf.JZD.setVisibility(8);
          break;
          if (parambu.field_status < 2) {}
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
          if (parambu.eLs.contains("notify@all")) {}
          for (parama = "";; parama = localf.KfT.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
          {
            ((Bundle)localObject).putInt("geta8key_scene", 31);
            parama = com.tencent.mm.pluginsdk.ui.span.k.a(localf.KfT.getContext(), parama + paramString, (int)localf.KfT.getTextSize(), 4, localObject, cx(parambu));
            k = 1;
            break;
          }
          label1378:
          localf.rDq.setVisibility(8);
        }
        label1391:
        j = bl.F(parambu);
        if ((j <= 0) || (j >= com.tencent.mm.ui.widget.textview.b.hh(localf.KfT).length())) {
          j = 0;
        }
        for (;;)
        {
          if (localf.KbZ != null) {
            localf.KbZ.destroy();
          }
          parama = c(parama1);
          paramString = a(c(parama1));
          localObject = new int[2];
          i = 0;
          if (localf.KfT != null)
          {
            localf.KfT.getLocationOnScreen((int[])localObject);
            k = localObject[0];
            i = k;
            if (k == 0)
            {
              localObject = new Rect();
              localf.KfT.getGlobalVisibleRect((Rect)localObject);
              i = ((Rect)localObject).left;
            }
          }
          for (;;)
          {
            paramString = new a.a(localf.KfT, localf.JEB, paramString, fHt(), localf.Kca);
            paramString.LfH = 2131100135;
            paramString.Lgb = 18;
            paramString.LfI = 2131100133;
            if (i != 0) {
              paramString.Lgc = (com.tencent.mm.ui.aq.ay(localf.KfT.getContext(), 2131165284) + i);
            }
            localf.KbZ = paramString.fNB();
            localf.Kcb = new ax.d(localf.KbZ);
            localf.KbZ.Lfz = new com.tencent.mm.ui.base.v()
            {
              public final void an(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180036);
                ax.b.a(ax.b.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180036);
              }
            };
            localf.JXY = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180037);
                localf.KbZ.fNt();
                localf.KbZ.LfQ = true;
                localf.KbZ.LfR = true;
                localf.KbZ.fNs();
                AppMethodBeat.o(180037);
              }
            };
            localf.KbZ.LfM = j;
            parama.JXY = localf.JXY;
            localf.KbZ.LfX = localf.Kcb;
            break;
            paramString = parambu.field_transBrandWording;
            break label951;
            if (localf.Kcd == null) {
              break label1072;
            }
            localf.Kcd.setVisibility(8);
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
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
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
      bu localbu = parambk.dBd;
      Object localObject1;
      Object localObject2;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37414);
        return false;
      case 141: 
        paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
        parambk = localbu.field_transContent;
        if (!bt.isNullOrNil(parambk)) {
          paramMenuItem.setText(parambk);
        }
        com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
        AppMethodBeat.o(37414);
        return true;
      case 142: 
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        parambk = localbu.field_transContent;
        if (localbu.frz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", parambk);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37414);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", parambk);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
      case 143: 
        localObject1 = new cv();
        com.tencent.mm.pluginsdk.model.g.b((cv)localObject1, localbu.field_transContent, 1);
        ((cv)localObject1).dnG.fragment = parama.JOR;
        ((cv)localObject1).dnG.dnM = 43;
        if (((cv)localObject1).dnG.dnI != null)
        {
          localObject2 = ((cv)localObject1).dnG.dnI.Gjv;
          if (localObject2 != null)
          {
            ((akj)localObject2).aPf(localbu.field_talker);
            ((akj)localObject2).aPg(u.aAm());
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          }
        }
        break;
      case 102: 
        localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
        localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(((ChattingItemTranslate.a)parambk).dBd, false);
        paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
        if (localObject1 == null)
        {
          i = 0;
          label509:
          ad.d("MicroMsg.ChattingItemTextTo", i);
        }
        break;
      }
      for (;;)
      {
        try
        {
          if ((bl.G(localbu) < 2) || (bt.ai(((ChattingItemTranslate.a)parambk).Kgc))) {
            break label980;
          }
          paramMenuItem = ((ChattingItemTranslate.a)parambk).Kgc;
        }
        catch (Exception paramMenuItem)
        {
          for (;;)
          {
            try
            {
              ((android.content.ClipboardManager)localObject2).setText(paramMenuItem);
              localObject1 = com.tencent.mm.plugin.secinforeport.a.a.yBN;
              com.tencent.mm.plugin.secinforeport.a.a.o(1, localbu.field_msgSvrId, bt.aQW(paramMenuItem.toString()));
              ax.c(parambk.dBd, 3, paramMenuItem.length());
            }
            catch (Exception parambk)
            {
              continue;
            }
            try
            {
              parambk = new eq();
              parambk.ein = localbu.field_msgSvrId;
              parambk.eip = paramMenuItem.length();
              parambk.eio = this.JEC.length();
              parambk.eiq = bl.F(localbu);
              parambk.aLk();
              com.tencent.mm.ui.base.h.cl(parama.JOR.getContext(), parama.JOR.getContext().getString(2131755702));
              AppMethodBeat.o(37414);
              return true;
              ad.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
              break;
              i = ((CharSequence)localObject1).length();
              break label509;
              paramMenuItem = paramMenuItem;
              paramMenuItem = (MenuItem)localObject1;
              ad.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
            }
            catch (Exception paramMenuItem)
            {
              ad.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
            }
          }
        }
        ax.c(localbu, 4, 0);
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        parambk = ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).e(localbu, false);
        if (localbu.frz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", parambk);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramMenuItem.putExtra("Retr_Msg_content", parambk);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        bw(localbu);
        break;
        ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).b(paramMenuItem, localbu);
        break;
        com.tencent.mm.ui.chatting.r.a(parama, localbu.field_msgId, 2);
        AppMethodBeat.o(37414);
        return false;
        label980:
        paramMenuItem = (MenuItem)localObject1;
      }
    }
    
    public boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194495);
      if ((parambu.eLs != null) && (parambu.eLs.contains("announcement@all"))) {}
      for (int i = 1; (!parambu.isText()) && (!parambu.frz()); i = 0)
      {
        AppMethodBeat.o(194495);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int j = locala.position;
      if (locala.oIb == 1)
      {
        if (parambu.isText())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ao(parambu)) {
            paraml.a(j, 151, this.JBI.JOR.getMMResources().getString(2131760101), 2131691573);
          }
          if (!bl.A(parambu)) {
            paraml.a(j, 102, paramView.getContext().getString(2131757218), 2131690381);
          }
        }
        if (!bl.A(parambu)) {
          paraml.a(j, 108, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (parambu.field_status == 5) {
          paraml.a(j, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(j, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType())) {
          paraml.a(j, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((i == 0) && (!parambu.fpd()) && (parambu.isText()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
          paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if ((com.tencent.mm.app.plugin.c.Ng()) && ((!parambu.frS()) || (!parambu.fsb()))) {
          paraml.a(j, 124, paramView.getContext().getString(2131757242), 2131690491);
        }
        if ((parambu.isText()) && (com.tencent.mm.am.g.aFz())) {
          this.JBI.fFw();
        }
        if (!this.JBI.fFw()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        if ((bl.z(parambu)) || (bl.G(parambu) == 4))
        {
          paraml.clear();
          if (!this.JBI.fFw()) {
            paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
          }
        }
      }
      while (locala.oIb != 2)
      {
        AppMethodBeat.o(194495);
        return true;
      }
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
      AppMethodBeat.o(194495);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    public boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    public final boolean fHh()
    {
      return true;
    }
    
    public final boolean gx(View paramView)
    {
      AppMethodBeat.i(37416);
      if (r.gv(paramView))
      {
        ad.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
        AppMethodBeat.o(37416);
        return true;
      }
      Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
      ((Intent)localObject2).addFlags(67108864);
      ChattingItemTranslate.a locala;
      if ((paramView.getTag() instanceof ChattingItemTranslate.a))
      {
        locala = (ChattingItemTranslate.a)paramView.getTag();
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dBd.field_msgId);
        if (((com.tencent.mm.ui.chatting.d.b.v)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.v.class)).bO(locala.dBd))
        {
          localObject1 = ((MMNeat7extView)paramView).fSO().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(locala.dBd.field_talker);
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kd(paramView.getContext());
        }
      }
      else
      {
        AppMethodBeat.o(37416);
        return true;
      }
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.aq)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      bu localbu = locala.dBd;
      if (locala.oIb == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((com.tencent.mm.ui.chatting.d.b.aq)localObject1).e(localbu, bool);
        break;
      }
    }
  }
  
  static final class c
    implements MMNeat7extView.b
  {
    public final void a(Exception paramException, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37417);
      if (!com.tencent.mm.protocal.d.Fnk)
      {
        HashMap localHashMap = new HashMap(2);
        localHashMap.put("Content", paramString1);
        localHashMap.put("Exception", paramException.toString());
        localHashMap.put("Stack", paramException.getStackTrace());
        com.tencent.mm.plugin.report.service.g.yhR.g("NeatTextView", paramString2, localHashMap);
      }
      AppMethodBeat.o(37417);
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
      AppMethodBeat.i(37418);
      ad.d("OnTouchOutside", "touchOutside");
      this.JEA.fNt();
      this.JEA.LfR = true;
      this.JEA.fNw();
      this.JEA.LfQ = true;
      this.JEA.fNx();
      this.JEA.fNz();
      AppMethodBeat.o(37418);
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
      AppMethodBeat.i(37419);
      parama = (bk)paramView.getTag();
      if (parambu.frz())
      {
        if (this.JBI != null)
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10221, "1");
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.bs.d.b(this.JBI.JOR.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(37419);
        return;
      }
      if ((parambu.isText()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.fGX();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dBd);
      }
      AppMethodBeat.o(37419);
    }
  }
  
  static final class f
    extends c.a
  {
    com.tencent.mm.ui.widget.b.a JEB;
    a.f JXY;
    ImageView JZD;
    LinearLayout Kao;
    TextView Kap;
    com.tencent.mm.ui.widget.textview.a KbZ;
    com.tencent.mm.pluginsdk.ui.span.g Kca;
    a.e Kcb;
    ViewStub Kcc;
    ChattingItemTranslate Kcd;
    MMNeat7extView KfT;
    View ize;
    protected TextView rDq;
    
    private static boolean fHu()
    {
      AppMethodBeat.i(37421);
      try
      {
        String str = com.tencent.mm.n.g.acA().getValue("CellTextViewEnable");
        int i = bt.getInt(str, 1);
        boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IBW, true);
        ad.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
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
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37420);
      super.gn(paramView);
      this.fTP = ((TextView)paramView.findViewById(2131298178));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.KfT = ((MMNeat7extView)paramView.findViewById(2131298073));
      this.KfT.setMaxWidth((int)(com.tencent.mm.cc.a.ay(this.KfT.getContext(), 2131166038) / com.tencent.mm.cd.a.fhE()));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.ize = paramView.findViewById(2131298071);
      this.Kcc = ((ViewStub)paramView.findViewById(2131306075));
      if (!paramBoolean)
      {
        this.JZD = ((ImageView)paramView.findViewById(2131298176));
        this.JYs = ((ImageView)paramView.findViewById(2131298174));
        this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      }
      this.Kca = new com.tencent.mm.pluginsdk.ui.span.g(this.KfT, new n(this.KfT.getContext()));
      this.KfT.setIsOpen(fHu());
      this.KfT.setTextCrashListener(new ax.c((byte)0));
      this.rDq = ((TextView)paramView.findViewById(2131298044));
      this.Kao = ((LinearLayout)paramView.findViewById(2131298050));
      this.Kap = ((TextView)paramView.findViewById(2131298051));
      AppMethodBeat.o(37420);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */