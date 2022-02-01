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
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.b.a.ia;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.am;
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

public final class bd
{
  private static final int PKK = 2131298495;
  private static final int PKL = 2131298494;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.e.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, ca paramca, int paramInt)
  {
    AppMethodBeat.i(233927);
    v.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, paramca, paramInt);
    AppMethodBeat.o(233927);
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
      paramf.PIY.setBackgroundResource(2131231713);
      paramf.PIZ.setTextColor(parama.Pwc.getContext().getResources().getColor(2131099679));
      paramf.PIZ.setText(2131761505);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.PIY.setBackgroundResource(2131231714);
    paramf.PIZ.setTextColor(parama.Pwc.getContext().getResources().getColor(2131099710));
    paramf.PIZ.setText(2131761507);
    AppMethodBeat.o(180039);
  }
  
  public static Bundle cN(ca paramca)
  {
    AppMethodBeat.i(233928);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msgSvrId", paramca.field_msgSvrId);
    AppMethodBeat.o(233928);
    return localBundle;
  }
  
  public static class a
    extends c
    implements NeatTextView.b
  {
    private static final int PKJ = 2131308867;
    private static final int PKK = 2131298495;
    private static final int PKL = 2131298494;
    private int PHj = -1;
    private bd.e POQ;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private CharSequence PkM;
    private int hcg = -1;
    
    private String cO(ca paramca)
    {
      AppMethodBeat.i(37397);
      if (paramca != null)
      {
        String str = ad.JX(paramca.field_msgSvrId);
        ad.b localb = ad.aVe().G(str, true);
        localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
        localb.l("preUsername", a(this.PhN, paramca));
        localb.l("preChatName", b(this.PhN, paramca));
        AppMethodBeat.o(37397);
        return str;
      }
      AppMethodBeat.o(37397);
      return null;
    }
    
    private bd.e gUg()
    {
      AppMethodBeat.i(37393);
      if (this.POQ == null) {
        this.POQ = new bd.e(this.PhN);
      }
      bd.e locale = this.POQ;
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
        localObject = new an(paramLayoutInflater, 2131493525);
        ((View)localObject).setTag(new bd.f().G((View)localObject, true));
      }
      AppMethodBeat.o(37394);
      return localObject;
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37396);
      this.PhN = parama1;
      final bd.f localf = (bd.f)parama;
      Object localObject2 = paramca.field_content;
      paramString = parama1.getTalkerUserName();
      localf.POU.setTag(PKK, Long.valueOf(paramca.field_msgId));
      localf.POU.setTag(PKL, Boolean.TRUE);
      parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
      localf.POU.setTag(parama);
      ChattingItemTranslate.c localc = ChattingItemTranslate.c.PPm;
      if (com.tencent.mm.app.plugin.c.Xn()) {
        if ((paramca.gDz()) && (paramca.gDI()))
        {
          parama = paramca.field_transContent;
          localc = ((au)parama1.bh(au.class)).cj(paramca);
        }
      }
      for (;;)
      {
        int i;
        Object localObject1;
        if ((parama1.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp((String)localObject2);
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
          if ((paramca.fqK != null) && (paramca.gDV()))
          {
            j = 1;
            parama = com.tencent.mm.ui.chatting.l.a.PEV;
            com.tencent.mm.ui.chatting.l.a.a.a(localf.POU, paramca, parama1.gRM(), (String)localObject1);
            parama = t.Ao(parama1.gRM());
            localBundle = bd.cN(paramca);
            localBundle.putAll(parama);
            parama = null;
            k = 1;
            if (j != 0) {
              break label1160;
            }
            if (!as.bjp((String)localObject1)) {
              break label1109;
            }
            parama = l.a(localf.POU.getContext(), (CharSequence)localObject2, (int)localf.POU.getTextSize(), localBundle, cO(paramca), l.Krf);
            label368:
            localObject1 = (am)parama1.bh(am.class);
            if (!((am)localObject1).Nz(paramca.field_msgId)) {
              break label1723;
            }
            localObject1 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, ((am)localObject1).gQU(), e.a.wWo, b.b.wZR));
            localf.POU.a(((com.tencent.mm.plugin.fts.a.a.f)localObject1).wWu, TextView.BufferType.SPANNABLE);
          }
          label821:
          label1723:
          for (i = 0;; i = 1)
          {
            localObject1 = (p[])parama.getSpans(0, parama.length(), p.class);
            k = localObject1.length;
            j = 0;
            label461:
            if (j < k) {
              if (localObject1[j].getType() == 44)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(7), "" });
                label508:
                if (i != 0) {
                  bd.a(localf.POU.getContext(), parama1, paramca.field_content, parama, localf.POU, paramca, 1);
                }
                if (!com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
                  break label1370;
                }
                localf.tln.setText(parama1.Pwc.getMMResources().getString(2131761487));
                localf.tln.setVisibility(0);
                localf.tln.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37383);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    Log.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { localf.POU.getTag(bd.a.bhW()) });
                    s.a(parama1, ((Long)localf.POU.getTag(bd.a.bhW())).longValue(), 1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37383);
                  }
                });
                label596:
                bd.a(paramca, localf, parama1);
                localObject1 = localf.POU.getContext();
                localf.POU.setTag(PKJ, Boolean.TRUE);
                if (localf.wnj == null)
                {
                  localf.wnj = new com.tencent.mm.ui.widget.b.a((Context)localObject1, localf.POU);
                  localf.wnj.QwU = new PopupWindow.OnDismissListener()
                  {
                    public final void onDismiss()
                    {
                      AppMethodBeat.i(180024);
                      parama1.setFocused(true);
                      c.a(localf.wnj, parama1, bd.a.a(bd.a.this), bd.a.b(bd.a.this), 1);
                      bd.a.a(bd.a.this, -1);
                      bd.a.b(bd.a.this, -1);
                      AppMethodBeat.o(180024);
                    }
                  };
                  localf.wnj.QSv = true;
                  localf.wnj.QSy = false;
                  localf.wnj.QSt = new o.e()
                  {
                    public final void a(m paramAnonymousm, View paramAnonymousView)
                    {
                      AppMethodBeat.i(233922);
                      paramAnonymousm.clear();
                      paramAnonymousm.a(0, 0, this.val$context.getResources().getString(2131755772), 2131690525);
                      paramAnonymousView = localf.POU.hiT();
                      Object localObject = (bq)localf.POU.getTag();
                      if (localObject != null) {}
                      for (int i = br.O(((bq)localObject).dTX);; i = 0)
                      {
                        if ((i <= 0) || (i >= paramAnonymousView.length())) {
                          paramAnonymousm.a(0, 1, this.val$context.getResources().getString(2131763038), 2131690480);
                        }
                        paramAnonymousm.a(0, 2, this.val$context.getResources().getString(2131763036), 2131690674);
                        paramAnonymousm.a(0, 3, this.val$context.getResources().getString(2131759168), 2131690551);
                        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                        {
                          paramAnonymousm.a(0, 4, this.val$context.getResources().getString(2131757451), 2131690670);
                          if (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                            break label355;
                          }
                          paramAnonymousm = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bd.a.c(bd.a.this).toString());
                          if (!Util.isNullOrNil(paramAnonymousm)) {
                            bd.a.this.a(localf.wnj, parama1, paramAnonymousm);
                          }
                        }
                        for (;;)
                        {
                          if (Util.isNullOrNil(paramAnonymousm)) {
                            localf.wnj.QSA = null;
                          }
                          paramAnonymousView = "65_" + cl.aWA();
                          localObject = bd.a.this;
                          com.tencent.mm.ui.chatting.e.a locala = parama1;
                          ca localca = paramca;
                          if (!Util.isNullOrNil(paramAnonymousm)) {}
                          for (boolean bool = true;; bool = false)
                          {
                            ((bd.a)localObject).a(locala, localca, 1, bool, bd.a.c(bd.a.this).toString(), true, paramAnonymousView);
                            AppMethodBeat.o(233922);
                            return;
                          }
                          label355:
                          paramAnonymousm = "";
                        }
                      }
                    }
                  };
                  localf.wnj.HLY = new o.g()
                  {
                    public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(180028);
                      bd.a.b(bd.a.this, paramAnonymousMenuItem.getItemId());
                      bd.a.a(bd.a.this, paramAnonymousInt);
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
                                ClipboardHelper.setText(MMApplicationContext.getContext(), bd.a.c(bd.a.this), bd.a.c(bd.a.this));
                                if (localf.PKE != null)
                                {
                                  localf.PKE.hbA();
                                  localf.PKE.QXW = true;
                                  localf.PKE.QXX = true;
                                  localf.PKE.hbz();
                                }
                                Toast.makeText(this.val$context, 2131755773, 0).show();
                                try
                                {
                                  paramAnonymousMenuItem = (bq)localf.POU.getTag();
                                  if (paramAnonymousMenuItem != null)
                                  {
                                    localObject1 = ((au)parama1.bh(au.class)).g(paramAnonymousMenuItem.dTX, false);
                                    localObject2 = new ia();
                                    ((ia)localObject2).eMJ = paramAnonymousMenuItem.dTX.field_msgSvrId;
                                    ((ia)localObject2).eML = ((String)localObject1).length();
                                    ((ia)localObject2).eMK = bd.a.c(bd.a.this).length();
                                    ((ia)localObject2).eMM = br.O(paramAnonymousMenuItem.dTX);
                                    ((ia)localObject2).bfK();
                                    bd.c(paramAnonymousMenuItem.dTX, 3, bd.a.c(bd.a.this).length());
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
                              } while (localf.PKE == null);
                              if (localf.PKE.QXQ != null) {
                                localf.PKE.QXQ.gTY();
                              }
                              localf.PKE.QXW = true;
                              localf.PKE.hbz();
                              localf.PKE.lE(0, localf.POU.hiT().length());
                              localf.PKE.hcQ();
                              localf.PKE.hcT();
                            } while (localf.PKE.QXQ == null);
                            localf.PKE.QXQ.gTZ();
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = (bq)localf.POU.getTag();
                          } while (paramAnonymousMenuItem == null);
                          bd.c(paramAnonymousMenuItem.dTX, 4, 0);
                          paramAnonymousMenuItem = br.N(paramAnonymousMenuItem.dTX);
                          if (Util.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                            ((Intent)localObject1).putExtra("Retr_Msg_content", bd.a.c(bd.a.this));
                            ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = this.val$context;
                            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180028);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                          com.tencent.mm.ui.base.h.a(this.val$context, 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180026);
                              paramAnonymous2DialogInterface = new Intent();
                              paramAnonymous2DialogInterface.putExtra("rawUrl", paramAnonymousMenuItem);
                              paramAnonymous2DialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                              paramAnonymous2DialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                              com.tencent.mm.br.c.b(bd.a.4.this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramAnonymousMenuItem });
                              AppMethodBeat.o(180026);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(180027);
                              Object localObject = new Intent(bd.a.4.this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject).putExtra("Retr_Msg_content", bd.a.c(bd.a.this));
                              ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                              paramAnonymous2DialogInterface = bd.a.4.this.val$context;
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramAnonymousMenuItem });
                              AppMethodBeat.o(180027);
                            }
                          });
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = new cz();
                          com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, bd.a.c(bd.a.this).toString(), 1);
                          paramAnonymousMenuItem.dFZ.fragment = bd.a.d(bd.a.this).Pwc;
                          paramAnonymousMenuItem.dFZ.dGf = 43;
                          if (paramAnonymousMenuItem.dFZ.dGb != null)
                          {
                            localObject1 = paramAnonymousMenuItem.dFZ.dGb.Lya;
                            if (localObject1 != null)
                            {
                              localObject2 = (bq)localf.POU.getTag();
                              if (localObject2 != null)
                              {
                                bd.c(((bq)localObject2).dTX, 5, 0);
                                ((anh)localObject1).bhf(((bq)localObject2).dTX.field_talker);
                                ((anh)localObject1).bhg(z.aTY());
                                EventCenter.instance.publish(paramAnonymousMenuItem);
                              }
                            }
                          }
                        } while (localf.PKE == null);
                        localf.PKE.hbA();
                        localf.PKE.QXW = true;
                        localf.PKE.QXX = true;
                        localf.PKE.hbz();
                        AppMethodBeat.o(180028);
                        return;
                      }
                      Object localObject1 = "65_" + cl.aWA();
                      Object localObject2 = bd.a.c(bd.a.this).toString();
                      if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {}
                      for (paramAnonymousMenuItem = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject2);; paramAnonymousMenuItem = "")
                      {
                        bd.a locala = bd.a.this;
                        com.tencent.mm.ui.chatting.e.a locala1 = parama1;
                        ca localca = paramca;
                        if (!Util.isNullOrNil(paramAnonymousMenuItem)) {}
                        for (boolean bool = true;; bool = false)
                        {
                          locala.a(locala1, localca, 2, bool, (String)localObject2, true, (String)localObject1);
                          paramAnonymousMenuItem = new ag();
                          paramAnonymousMenuItem.context = this.val$context;
                          paramAnonymousMenuItem.scene = 65;
                          paramAnonymousMenuItem.query = ((String)localObject2);
                          paramAnonymousMenuItem.sessionId = ((String)localObject1);
                          paramAnonymousMenuItem.IEk = true;
                          ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(paramAnonymousMenuItem);
                          break;
                        }
                      }
                    }
                  };
                }
                bd.a(parama1, br.P(paramca), parama, localf.POU);
                if ((!br.B(paramca)) && (!br.J(paramca))) {
                  break label1383;
                }
                localf.POU.setTag(PKJ, Boolean.FALSE);
                localf.POU.setOnTouchListener(localf.PKF);
                localf.POU.setOnLongClickListener(c(parama1));
                localf.POU.setOnClickListener(gUg());
                localf.POU.setOnDoubleClickListener(this);
                localf.POU.setTextListener(new MMNeat7extView.a()
                {
                  public final void at(CharSequence paramAnonymousCharSequence)
                  {
                    AppMethodBeat.i(180031);
                    if (((Boolean)localf.POU.getTag(bd.a.etx())).booleanValue())
                    {
                      com.tencent.mm.ui.chatting.m.a.a.gTK();
                      com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)localf.POU.getTag(bd.a.bhW())).longValue());
                    }
                    AppMethodBeat.o(180031);
                  }
                });
                if ((Util.isNullOrNil(paramString)) && (localc == ChattingItemTranslate.c.PPm)) {
                  break label1699;
                }
                if (localf.PKI == null)
                {
                  localf.PKI = ((ChattingItemTranslate)localf.PKH.inflate());
                  localf.PKI.init();
                }
                parama = l.a(localf.POU.getContext(), paramString, (int)localf.POU.getTextSize(), 1, localBundle, cO(paramca));
                localf.PKI.a(parama, localc);
                localObject1 = localf.PKI;
                if (!Util.isNullOrNil(paramca.field_transBrandWording)) {
                  break label1690;
                }
              }
            }
            for (parama = parama1.Pwc.getMMResources().getString(2131766752);; parama = paramca.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject1).setBrandWording(parama);
              if (!Util.isNullOrNil(paramString))
              {
                parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                parama.PQG = false;
                parama.qcr = 2;
                localf.PKI.setTag(parama);
                localf.PKI.getContentView().setTag(parama);
                localf.PKI.setOnClickListener(gUg());
                localf.PKI.setOnDoubleClickListener(this);
                localf.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                localf.PKI.setOnLongClickListener(c(parama1));
                localf.PKI.setVisibility(0);
              }
              AppMethodBeat.o(37396);
              return;
              j = 0;
              break;
              label1109:
              parama = l.a(localf.POU.getContext(), (CharSequence)localObject2, (int)localf.POU.getTextSize(), 1, localBundle, cO(paramca), 0, l.Krf);
              break label368;
              j += 1;
              break label461;
              break label508;
              i = k;
              if (j == 0) {
                break label508;
              }
              if (paramca.fqK.contains("notify@all")) {}
              for (parama = "";; parama = localf.POU.getContext().getString(2131764740, new Object[] { "@" }) + "\n")
              {
                localBundle.putInt("geta8key_scene", 31);
                if (!as.bjp((String)localObject1)) {
                  break label1310;
                }
                parama = l.a(localf.POU.getContext(), parama + localObject2, (int)localf.POU.getTextSize(), localBundle, cO(paramca), l.Krf);
                i = k;
                break;
              }
              parama = l.a(localf.POU.getContext(), parama + localObject2, (int)localf.POU.getTextSize(), 1, localBundle, cO(paramca), 0, l.Krf);
              i = k;
              break label508;
              label1370:
              localf.tln.setVisibility(8);
              break label596;
              label1383:
              i = br.O(paramca);
              if (i > 0)
              {
                j = i;
                if (i < com.tencent.mm.ui.widget.textview.b.hB(localf.POU).length()) {}
              }
              else
              {
                j = 0;
              }
              parama = c(parama1);
              localObject1 = a(parama);
              if (localf.PKE != null) {
                localf.PKE.destroy();
              }
              localObject2 = new int[2];
              i = 0;
              if (localf.POU != null)
              {
                localf.POU.getLocationInWindow((int[])localObject2);
                k = localObject2[0];
                i = k;
                if (k == 0)
                {
                  localObject2 = new Rect();
                  localf.POU.getGlobalVisibleRect((Rect)localObject2);
                  i = ((Rect)localObject2).left;
                }
              }
              localObject1 = new com.tencent.mm.ui.widget.textview.a.a(localf.POU, localf.wnj, (a.f)localObject1, gUg(), localf.PKF);
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPi = 2131101045;
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYg = 18;
              ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QPj = 2131100228;
              if (i != 0) {
                ((com.tencent.mm.ui.widget.textview.a.a)localObject1).QYh = (i + at.aH(localf.POU.getContext(), 2131165296));
              }
              localf.PKE = ((com.tencent.mm.ui.widget.textview.a.a)localObject1).hcW();
              localf.PKG = new bd.d(localf.PKE);
              localf.PKE.QXO = new com.tencent.mm.ui.base.x()
              {
                public final void as(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180029);
                  bd.a.a(bd.a.this, paramAnonymousCharSequence);
                  AppMethodBeat.o(180029);
                }
              };
              localf.PGP = new a.f()
              {
                public final void dismiss()
                {
                  AppMethodBeat.i(180030);
                  localf.PKE.hbA();
                  localf.PKE.QXW = true;
                  localf.PKE.QXX = true;
                  localf.PKE.hbz();
                  AppMethodBeat.o(180030);
                }
              };
              parama.PGP = localf.PGP;
              localf.PKE.QXU = j;
              localf.PKE.QYc = localf.PKG;
              break label821;
            }
            if (localf.PKI != null) {
              localf.PKI.setVisibility(8);
            }
            AppMethodBeat.o(37396);
            return;
          }
          label1160:
          label1310:
          label1699:
          paramString = parama;
          label1690:
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
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, bq parambq)
    {
      AppMethodBeat.i(37399);
      if (parambq == null)
      {
        AppMethodBeat.o(37399);
        return false;
      }
      final ca localca = parambq.dTX;
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37399);
        return false;
      case 141: 
        paramMenuItem = localca.field_transContent;
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
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
        AppMethodBeat.o(37399);
        return true;
        parambq = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        paramMenuItem = localca.field_transContent;
        if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
        {
          i = bp.Kp(paramMenuItem);
          if (i != -1) {
            paramMenuItem = paramMenuItem.substring(i + 1).trim();
          }
        }
        for (;;)
        {
          if (localca.gDg())
          {
            parambq.putExtra("Retr_Msg_content", paramMenuItem);
            parambq.putExtra("Retr_Msg_Type", 6);
          }
          for (;;)
          {
            paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(parambq);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramMenuItem.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37399);
            return true;
            parambq.putExtra("Retr_Msg_content", paramMenuItem);
            parambq.putExtra("Retr_Msg_Type", 4);
          }
          cz localcz = new cz();
          Object localObject = localca.field_transContent;
          if ((parama.gRM()) && (!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
          {
            i = bp.Kp((String)localObject);
            if (i != -1) {
              localObject = ((String)localObject).substring(i + 1).trim();
            }
          }
          for (;;)
          {
            com.tencent.mm.pluginsdk.model.h.b(localcz, (String)localObject, 1);
            localcz.dFZ.fragment = parama.Pwc;
            localcz.dFZ.dGf = 43;
            if (localcz.dFZ.dGb != null)
            {
              localObject = localcz.dFZ.dGb.Lya;
              if (localObject != null)
              {
                ((anh)localObject).bhf(localca.field_talker);
                ((anh)localObject).bhg(z.aTY());
                EventCenter.instance.publish(localcz);
              }
              localObject = ((au)parama.bh(au.class)).g(((ChattingItemTranslate.a)parambq).dTX, false);
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
                if ((br.P(localca) < 2) || (Util.isNullOrNil(((ChattingItemTranslate.a)parambq).PPi))) {
                  break label1164;
                }
                paramMenuItem = ((ChattingItemTranslate.a)parambq).PPi;
              }
              catch (Exception paramMenuItem)
              {
                for (;;)
                {
                  try
                  {
                    ClipboardHelper.setText(paramMenuItem);
                    bd.c(localca, 3, paramMenuItem.length());
                    com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
                    parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, localca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem.toString()));
                  }
                  catch (Exception parambq)
                  {
                    label817:
                    continue;
                  }
                  try
                  {
                    parama = new ia();
                    parama.eMJ = localca.field_msgSvrId;
                    parama.eML = paramMenuItem.length();
                    parama.eMK = this.PkM.length();
                    parama.eMM = br.O(localca);
                    parama.bfK();
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
              bd.c(localca, 4, 0);
              paramMenuItem = br.N(localca);
              if (Util.isNullOrNil(paramMenuItem))
              {
                paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
                parambq = ((au)parama.bh(au.class)).g(localca, false);
                if (localca.gDg())
                {
                  paramMenuItem.putExtra("Retr_Msg_content", parambq);
                  paramMenuItem.putExtra("Retr_Msg_Type", 6);
                }
                for (;;)
                {
                  paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
                  com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  parama.startActivity((Intent)paramMenuItem.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  break;
                  paramMenuItem.putExtra("Retr_Msg_content", parambq);
                  paramMenuItem.putExtra("Retr_Msg_Type", 4);
                }
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
              com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(37392);
                  paramAnonymousDialogInterface = new Intent();
                  paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                  com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                  com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
                  AppMethodBeat.o(37392);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(180032);
                  paramAnonymousDialogInterface = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
                  Object localObject = ((au)parama.bh(au.class)).g(localca, false);
                  if (localca.gDg())
                  {
                    paramAnonymousDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
                    paramAnonymousDialogInterface.putExtra("Retr_Msg_Type", 6);
                  }
                  for (;;)
                  {
                    localObject = parama.Pwc.getContext();
                    paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousDialogInterface);
                    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((Activity)localObject).startActivity((Intent)paramAnonymousDialogInterface.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
                    AppMethodBeat.o(180032);
                    return;
                    paramAnonymousDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
                    paramAnonymousDialogInterface.putExtra("Retr_Msg_Type", 4);
                  }
                }
              });
              break;
              ((au)parama.bh(au.class)).b(paramMenuItem, localca);
              break;
              s.a(parama, localca.field_msgId, 2);
              AppMethodBeat.o(37399);
              return false;
              label1164:
              paramMenuItem = (MenuItem)localObject;
            }
          }
        }
      }
    }
    
    public boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233923);
      if ((!paramca.isText()) && (!paramca.gDg()))
      {
        AppMethodBeat.o(233923);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int i = locala.position;
      if (locala.qcr == 1)
      {
        if (paramca.isText())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
            paramm.a(i, 151, this.PhN.Pwc.getMMResources().getString(2131761482), 2131690524);
          }
          if (!br.J(paramca)) {
            paramm.a(i, 102, paramView.getContext().getString(2131757430), 2131690525);
          }
        }
        if (!br.J(paramca)) {
          paramm.a(i, 108, paramView.getContext().getString(2131764628), 2131690674);
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
          paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((paramca.isText()) && (com.tencent.mm.al.g.aZH())) {
          this.PhN.gRN();
        }
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
        }
        if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
          paramm.a(i, 124, paramView.getContext().getString(2131757455), 2131690699);
        }
        if ((br.B(paramca)) || (br.P(paramca) == 4))
        {
          paramm.clear();
          if (!this.PhN.gRN()) {
            paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
          }
        }
      }
      while (locala.qcr != 2)
      {
        AppMethodBeat.o(233923);
        return true;
      }
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
      AppMethodBeat.o(233923);
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37395);
      boolean bool = parama.gRM();
      AppMethodBeat.o(37395);
      return bool;
    }
    
    public boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37400);
      if ((paramView instanceof MMTextView))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.gTK();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), paramca);
      }
      AppMethodBeat.o(37400);
      return true;
    }
    
    public final boolean gS(View paramView)
    {
      AppMethodBeat.i(37401);
      if (v.gQ(paramView))
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
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dTX.field_msgId);
        if (((com.tencent.mm.ui.chatting.d.b.x)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(locala.dTX))
        {
          localObject1 = ((MMNeat7extView)paramView).hiT().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          ((Intent)localObject2).putExtra("is_group_chat", this.PhN.gRM());
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kc(paramView.getContext());
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(locala.dTX.field_talker);
        }
      }
      else
      {
        AppMethodBeat.o(37401);
        return true;
      }
      Object localObject1 = (au)this.PhN.bh(au.class);
      ca localca = locala.dTX;
      if (locala.qcr == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((au)localObject1).g(localca, bool);
        break;
      }
    }
    
    public final boolean gTT()
    {
      return false;
    }
    
    protected boolean gTU()
    {
      return false;
    }
  }
  
  public static class b
    extends c
    implements t.n, NeatTextView.b
  {
    private static final int PKJ = 2131308867;
    private int PHj = -1;
    private bd.e POQ;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private CharSequence PkM;
    private int hcg = -1;
    
    private void bK(ca paramca)
    {
      AppMethodBeat.i(37411);
      if (!this.PhN.getTalkerUserName().equals("medianote"))
      {
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.bK(paramca);
      this.PhN.BN(true);
      AppMethodBeat.o(37411);
    }
    
    private String cO(ca paramca)
    {
      AppMethodBeat.i(37412);
      if (paramca != null)
      {
        String str = ad.JX(paramca.field_msgSvrId);
        ad.b localb = ad.aVe().G(str, true);
        localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
        localb.l("preUsername", a(this.PhN, paramca));
        localb.l("preChatName", b(this.PhN, paramca));
        AppMethodBeat.o(37412);
        return str;
      }
      AppMethodBeat.o(37412);
      return null;
    }
    
    private bd.e gUg()
    {
      AppMethodBeat.i(37408);
      if (this.POQ == null) {
        this.POQ = new bd.e(this.PhN);
      }
      bd.e locale = this.POQ;
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
        localObject = new an(paramLayoutInflater, 2131493577);
        ((View)localObject).setTag(new bd.f().G((View)localObject, false));
      }
      AppMethodBeat.o(37409);
      return localObject;
    }
    
    public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(37410);
      this.PhN = parama1;
      final bd.f localf = (bd.f)parama;
      localf.POU.setTag(bd.PKK, Long.valueOf(paramca.field_msgId));
      localf.POU.setTag(bd.PKL, Boolean.TRUE);
      localf.POU.setMaxLines(2147483647);
      parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
      parama.PQG = false;
      localf.POU.setTag(parama);
      Object localObject2;
      label223:
      Object localObject1;
      if (gTW())
      {
        b(localf, false);
        if ((paramca.field_status == 1) || (paramca.field_status == 5))
        {
          if (localf.PIn != null) {
            localf.PIn.setVisibility(8);
          }
          localf.POU.setBackgroundResource(2131231797);
          paramca.OqF = true;
          localObject2 = paramca.field_content;
          if (Util.isNullOrNil((String)localObject2)) {
            Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
          }
          if ((paramca.fqK == null) || (!paramca.gDV())) {
            break label1256;
          }
          i = 1;
          parama = com.tencent.mm.ui.chatting.l.a.PEV;
          com.tencent.mm.ui.chatting.l.a.a.a(localf.POU, paramca, parama1.gRM(), paramString);
          parama = t.Ao(parama1.gRM());
          localObject1 = bd.cN(paramca);
          ((Bundle)localObject1).putAll(parama);
          if (i != 0) {
            break label1271;
          }
          paramString = l.a(localf.POU.getContext(), (CharSequence)localObject2, (int)localf.POU.getTextSize(), 4, localObject1, cO(paramca), 0, l.Krf);
          parama = (am)parama1.bh(am.class);
          if (!parama.Nz(paramca.field_msgId)) {
            break label1770;
          }
          parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(paramString, parama.gQU(), e.a.wWo, b.b.wZS));
          localf.POU.a(parama.wWu, TextView.BufferType.SPANNABLE);
        }
      }
      label397:
      label546:
      label831:
      label974:
      label1256:
      label1770:
      for (int i = 0;; i = 1)
      {
        localObject2 = (p[])paramString.getSpans(0, paramString.length(), p.class);
        int m = localObject2.length;
        int j = 0;
        int k = i;
        parama = paramString;
        if (j < m)
        {
          if (localObject2[j].getType() == 44)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(6), "" });
            parama = paramString;
            k = i;
          }
        }
        else
        {
          if (k != 0) {
            bd.a(localf.POU.getContext(), parama1, paramca.field_content, parama, localf.POU, paramca, 4);
          }
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
            break label1405;
          }
          localf.tln.setText(parama1.Pwc.getMMResources().getString(2131761487));
          localf.tln.setVisibility(0);
          localf.tln.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37402);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", new Object[] { localf.POU.getTag(bd.PKK) });
              s.a(parama1, ((Long)localf.POU.getTag(bd.PKK)).longValue(), 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37402);
            }
          });
          bd.a(paramca, localf, parama1);
          paramString = localf.POU.getContext();
          localf.POU.setTag(PKJ, Boolean.TRUE);
          if (localf.wnj == null)
          {
            localf.wnj = new com.tencent.mm.ui.widget.b.a(paramString, localf.POU);
            localf.wnj.QwU = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(180033);
                parama1.setFocused(true);
                c.a(localf.wnj, parama1, bd.b.a(bd.b.this), bd.b.b(bd.b.this), 1);
                bd.b.a(bd.b.this, -1);
                bd.b.b(bd.b.this, -1);
                AppMethodBeat.o(180033);
              }
            };
            localf.wnj.QSv = true;
            localf.wnj.QSy = false;
            localf.wnj.QSt = new o.e()
            {
              public final void a(m paramAnonymousm, View paramAnonymousView)
              {
                AppMethodBeat.i(233924);
                paramAnonymousm.clear();
                paramAnonymousm.a(0, 0, paramString.getResources().getString(2131755772), 2131690525);
                paramAnonymousView = localf.POU.hiT();
                Object localObject = (bq)localf.POU.getTag();
                if (localObject != null) {}
                for (int i = br.O(((bq)localObject).dTX);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymousm.a(0, 1, paramString.getResources().getString(2131763038), 2131690480);
                  }
                  paramAnonymousm.a(0, 2, paramString.getResources().getString(2131763036), 2131690674);
                  paramAnonymousm.a(0, 3, paramString.getResources().getString(2131759168), 2131690551);
                  if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())
                  {
                    paramAnonymousm.a(0, 4, paramString.getResources().getString(2131757451), 2131690670);
                    if (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                      break label355;
                    }
                    paramAnonymousm = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(bd.b.c(bd.b.this).toString());
                    if (!Util.isNullOrNil(paramAnonymousm)) {
                      bd.b.this.a(localf.wnj, parama1, paramAnonymousm);
                    }
                  }
                  for (;;)
                  {
                    if (Util.isNullOrNil(paramAnonymousm)) {
                      localf.wnj.QSA = null;
                    }
                    paramAnonymousView = "65_" + cl.aWA();
                    localObject = bd.b.this;
                    com.tencent.mm.ui.chatting.e.a locala = parama1;
                    ca localca = paramca;
                    if (!Util.isNullOrNil(paramAnonymousm)) {}
                    for (boolean bool = true;; bool = false)
                    {
                      ((bd.b)localObject).a(locala, localca, 1, bool, bd.b.c(bd.b.this).toString(), true, paramAnonymousView);
                      AppMethodBeat.o(233924);
                      return;
                    }
                    label355:
                    paramAnonymousm = "";
                  }
                }
              }
            };
            localf.wnj.HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(180035);
                bd.b.a(bd.b.this, paramAnonymousInt);
                bd.b.b(bd.b.this, paramAnonymousMenuItem.getItemId());
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
                        ClipboardHelper.setText(MMApplicationContext.getContext(), bd.b.c(bd.b.this), bd.b.c(bd.b.this));
                        if (localf.PKE != null)
                        {
                          localf.PKE.hbA();
                          localf.PKE.QXW = true;
                          localf.PKE.QXX = true;
                          localf.PKE.hbz();
                        }
                        Toast.makeText(paramString, 2131755773, 0).show();
                        try
                        {
                          paramAnonymousMenuItem = (bq)localf.POU.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            localObject1 = ((au)parama1.bh(au.class)).g(paramAnonymousMenuItem.dTX, false);
                            localObject2 = new ia();
                            ((ia)localObject2).eMJ = paramAnonymousMenuItem.dTX.field_msgSvrId;
                            ((ia)localObject2).eML = ((String)localObject1).length();
                            ((ia)localObject2).eMK = bd.b.c(bd.b.this).length();
                            ((ia)localObject2).eMM = br.O(paramAnonymousMenuItem.dTX);
                            ((ia)localObject2).bfK();
                            bd.c(paramAnonymousMenuItem.dTX, 3, bd.b.c(bd.b.this).length());
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
                      } while (localf.PKE == null);
                      if (localf.PKE.QXQ != null) {
                        localf.PKE.QXQ.gTY();
                      }
                      localf.PKE.QXW = true;
                      localf.PKE.hbz();
                      localf.PKE.lE(0, localf.POU.hiT().length());
                      localf.PKE.hcQ();
                      localf.PKE.hcT();
                    } while (localf.PKE.QXQ == null);
                    localf.PKE.QXQ.gTZ();
                    AppMethodBeat.o(180035);
                    return;
                    bd.c(paramca, 4, 0);
                    localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", bd.b.c(bd.b.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180035);
                    return;
                    bd.c(paramca, 5, 0);
                    paramAnonymousMenuItem = new cz();
                    com.tencent.mm.pluginsdk.model.h.b(paramAnonymousMenuItem, bd.b.c(bd.b.this).toString(), 1);
                    paramAnonymousMenuItem.dFZ.fragment = bd.b.d(bd.b.this).Pwc;
                    paramAnonymousMenuItem.dFZ.dGf = 43;
                    if (paramAnonymousMenuItem.dFZ.dGb != null)
                    {
                      localObject1 = paramAnonymousMenuItem.dFZ.dGb.Lya;
                      if (localObject1 != null)
                      {
                        localObject2 = (bq)localf.POU.getTag();
                        if (localObject2 != null)
                        {
                          ((anh)localObject1).bhf(z.aTY());
                          ((anh)localObject1).bhg(((bq)localObject2).dTX.field_talker);
                          EventCenter.instance.publish(paramAnonymousMenuItem);
                        }
                      }
                    }
                  } while (localf.PKE == null);
                  localf.PKE.hbA();
                  localf.PKE.QXW = true;
                  localf.PKE.QXX = true;
                  localf.PKE.hbz();
                  AppMethodBeat.o(180035);
                  return;
                }
                Object localObject1 = "65_" + cl.aWA();
                Object localObject2 = bd.b.c(bd.b.this).toString();
                if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {}
                for (paramAnonymousMenuItem = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject2);; paramAnonymousMenuItem = "")
                {
                  bd.b localb = bd.b.this;
                  com.tencent.mm.ui.chatting.e.a locala = parama1;
                  ca localca = paramca;
                  if (!Util.isNullOrNil(paramAnonymousMenuItem)) {}
                  for (boolean bool = true;; bool = false)
                  {
                    localb.a(locala, localca, 2, bool, (String)localObject2, true, (String)localObject1);
                    paramAnonymousMenuItem = new ag();
                    paramAnonymousMenuItem.context = paramString;
                    paramAnonymousMenuItem.scene = 65;
                    paramAnonymousMenuItem.query = ((String)localObject2);
                    paramAnonymousMenuItem.sessionId = ((String)localObject1);
                    paramAnonymousMenuItem.IEk = true;
                    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(paramAnonymousMenuItem);
                    break;
                  }
                }
              }
            };
          }
          bd.a(parama1, br.P(paramca), parama, localf.POU);
          if ((!br.B(paramca)) && (!br.J(paramca))) {
            break label1418;
          }
          localf.POU.setTag(PKJ, Boolean.FALSE);
          localf.POU.setOnTouchListener(localf.PKF);
          localf.POU.setOnLongClickListener(c(parama1));
          localf.POU.setOnClickListener(gUg());
          localf.POU.setOnDoubleClickListener(this);
          localf.POU.setTextListener(new MMNeat7extView.a()
          {
            public final void at(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180038);
              if (((Boolean)localf.POU.getTag(bd.PKL)).booleanValue())
              {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.gTL().a(paramAnonymousCharSequence, ((Long)localf.POU.getTag(bd.PKK)).longValue());
              }
              AppMethodBeat.o(180038);
            }
          });
          paramString = ChattingItemTranslate.c.PPm;
          if (!com.tencent.mm.app.plugin.c.Xn()) {
            break label1765;
          }
          if ((!paramca.gDz()) || (!paramca.gDI())) {
            break label1760;
          }
          parama = paramca.field_transContent;
          paramString = ((au)parama1.bh(au.class)).cj(paramca);
        }
        for (;;)
        {
          if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
          {
            if (localf.PKI == null)
            {
              localf.PKI = ((ChattingItemTranslate)localf.PKH.inflate());
              localf.PKI.init();
            }
            localObject1 = l.a(localf.POU.getContext(), parama, (int)localf.POU.getTextSize(), 1, localObject1, cO(paramca));
            localf.PKI.a((CharSequence)localObject1, paramString);
            localObject1 = localf.PKI;
            if (Util.isNullOrNil(paramca.field_transBrandWording))
            {
              paramString = parama1.Pwc.getMMResources().getString(2131766752);
              ((ChattingItemTranslate)localObject1).setBrandWording(paramString);
              if (!Util.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
                parama.qcr = 2;
                localf.PKI.setTag(parama);
                localf.PKI.getContentView().setTag(parama);
                localf.PKI.setOnClickListener(gUg());
                localf.PKI.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
                localf.PKI.setOnDoubleClickListener(this);
                localf.PKI.setOnLongClickListener(c(parama1));
                localf.PKI.setVisibility(0);
              }
            }
          }
          for (;;)
          {
            a(paramInt, localf, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
            AppMethodBeat.o(37410);
            return;
            localf.POU.setBackgroundResource(2131231796);
            if (localf.PIn == null) {
              break;
            }
            if (b((k)parama1.bh(k.class), paramca.field_msgId))
            {
              if (paramca.OqF)
              {
                parama = new AlphaAnimation(0.5F, 1.0F);
                parama.setDuration(300L);
                localf.POU.startAnimation(parama);
                paramca.OqF = false;
              }
              localf.PIn.setVisibility(0);
              break;
            }
            localf.PIn.setVisibility(8);
            break;
            if (paramca.field_status < 2) {}
            for (boolean bool = true;; bool = false)
            {
              b(localf, bool);
              break;
            }
            i = 0;
            break label223;
            j += 1;
            break label397;
            label1271:
            if (paramca.fqK.contains("notify@all")) {}
            for (parama = "";; parama = localf.POU.getContext().getString(2131764740, new Object[] { "@" }) + "\n")
            {
              ((Bundle)localObject1).putInt("geta8key_scene", 31);
              parama = l.a(localf.POU.getContext(), parama + localObject2, (int)localf.POU.getTextSize(), 4, localObject1, cO(paramca), 0, l.Krf);
              k = 1;
              break;
            }
            label1405:
            localf.tln.setVisibility(8);
            break label546;
            i = br.O(paramca);
            if (i > 0)
            {
              j = i;
              if (i < com.tencent.mm.ui.widget.textview.b.hB(localf.POU).length()) {}
            }
            else
            {
              j = 0;
            }
            if (localf.PKE != null) {
              localf.PKE.destroy();
            }
            parama = c(parama1);
            paramString = a(c(parama1));
            localObject2 = new int[2];
            i = 0;
            if (localf.POU != null)
            {
              localf.POU.getLocationInWindow((int[])localObject2);
              k = localObject2[0];
              i = k;
              if (k == 0)
              {
                localObject2 = new Rect();
                localf.POU.getGlobalVisibleRect((Rect)localObject2);
                i = ((Rect)localObject2).left;
              }
            }
            paramString = new com.tencent.mm.ui.widget.textview.a.a(localf.POU, localf.wnj, paramString, gUg(), localf.PKF);
            paramString.QPi = 2131100167;
            paramString.QYg = 18;
            paramString.QPj = 2131100165;
            if (i != 0) {
              paramString.QYh = (i + at.aH(localf.POU.getContext(), 2131165289));
            }
            localf.PKE = paramString.hcW();
            localf.PKG = new bd.d(localf.PKE);
            localf.PKE.QXO = new com.tencent.mm.ui.base.x()
            {
              public final void as(CharSequence paramAnonymousCharSequence)
              {
                AppMethodBeat.i(180036);
                bd.b.a(bd.b.this, paramAnonymousCharSequence);
                AppMethodBeat.o(180036);
              }
            };
            localf.PGP = new a.f()
            {
              public final void dismiss()
              {
                AppMethodBeat.i(180037);
                localf.PKE.hbA();
                localf.PKE.QXW = true;
                localf.PKE.QXX = true;
                localf.PKE.hbz();
                AppMethodBeat.o(180037);
              }
            };
            localf.PKE.QXU = j;
            parama.PGP = localf.PGP;
            localf.PKE.QYc = localf.PKG;
            break label771;
            paramString = paramca.field_transBrandWording;
            break label974;
            if (localf.PKI != null) {
              localf.PKI.setVisibility(8);
            }
          }
          parama = null;
          break label831;
          parama = null;
        }
      }
    }
    
    @Deprecated
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bq parambq)
    {
      AppMethodBeat.i(37414);
      if (parambq == null)
      {
        AppMethodBeat.o(37414);
        return false;
      }
      ca localca = parambq.dTX;
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
        com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
        AppMethodBeat.o(37414);
        return true;
      case 142: 
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        parambq = localca.field_transContent;
        if (localca.gDg())
        {
          paramMenuItem.putExtra("Retr_Msg_content", parambq);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37414);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", parambq);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
      case 143: 
        localObject = new cz();
        com.tencent.mm.pluginsdk.model.h.b((cz)localObject, localca.field_transContent, 1);
        ((cz)localObject).dFZ.fragment = parama.Pwc;
        ((cz)localObject).dFZ.dGf = 43;
        if (((cz)localObject).dFZ.dGb != null)
        {
          anh localanh = ((cz)localObject).dFZ.dGb.Lya;
          if (localanh != null)
          {
            localanh.bhf(localca.field_talker);
            localanh.bhg(z.aTY());
            EventCenter.instance.publish((IEvent)localObject);
          }
        }
        break;
      case 102: 
        localObject = ((au)parama.bh(au.class)).g(((ChattingItemTranslate.a)parambq).dTX, false);
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
          if ((br.P(localca) < 2) || (Util.isNullOrNil(((ChattingItemTranslate.a)parambq).PPi))) {
            break label950;
          }
          paramMenuItem = ((ChattingItemTranslate.a)parambq).PPi;
        }
        catch (Exception paramMenuItem)
        {
          for (;;)
          {
            try
            {
              ClipboardHelper.setText(paramMenuItem);
              localObject = com.tencent.mm.plugin.secinforeport.a.a.CWD;
              com.tencent.mm.plugin.secinforeport.a.a.q(1, localca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem.toString()));
              bd.c(parambq.dTX, 3, paramMenuItem.length());
            }
            catch (Exception parambq)
            {
              continue;
            }
            try
            {
              parambq = new ia();
              parambq.eMJ = localca.field_msgSvrId;
              parambq.eML = paramMenuItem.length();
              parambq.eMK = this.PkM.length();
              parambq.eMM = br.O(localca);
              parambq.bfK();
              com.tencent.mm.ui.base.h.cD(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131755773));
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
        bd.c(localca, 4, 0);
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        parambq = ((au)parama.bh(au.class)).g(localca, false);
        if (localca.gDg())
        {
          paramMenuItem.putExtra("Retr_Msg_content", parambq);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramMenuItem.putExtra("Retr_Msg_content", parambq);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        bK(localca);
        break;
        ((au)parama.bh(au.class)).b(paramMenuItem, localca);
        break;
        s.a(parama, localca.field_msgId, 2);
        AppMethodBeat.o(37414);
        return false;
        label950:
        paramMenuItem = (MenuItem)localObject;
      }
    }
    
    public boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233925);
      if ((paramca.fqK != null) && (paramca.fqK.contains("announcement@all"))) {}
      for (int i = 1; (!paramca.isText()) && (!paramca.gDg()); i = 0)
      {
        AppMethodBeat.o(233925);
        return true;
      }
      ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
      int j = locala.position;
      if (locala.qcr == 1)
      {
        if (paramca.isText())
        {
          if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(paramca)) {
            paramm.a(j, 151, this.PhN.Pwc.getMMResources().getString(2131761482), 2131690524);
          }
          if (!br.J(paramca)) {
            paramm.a(j, 102, paramView.getContext().getString(2131757430), 2131690525);
          }
        }
        if (!br.J(paramca)) {
          paramm.a(j, 108, paramView.getContext().getString(2131764628), 2131690674);
        }
        if (paramca.field_status == 5) {
          paramm.a(j, 103, paramView.getContext().getString(2131757500), 2131690658);
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(j, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType())) {
          paramm.a(j, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((i == 0) && (!paramca.gAt()) && (paramca.isText()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
        if ((com.tencent.mm.app.plugin.c.Xn()) && ((!paramca.gDz()) || (!paramca.gDI()))) {
          paramm.a(j, 124, paramView.getContext().getString(2131757455), 2131690699);
        }
        if ((paramca.isText()) && (com.tencent.mm.al.g.aZH())) {
          this.PhN.gRN();
        }
        if (!this.PhN.gRN()) {
          paramm.a(j, 100, paramView.getContext().getString(2131757433), 2131690529);
        }
        if ((br.B(paramca)) || (br.P(paramca) == 4))
        {
          paramm.clear();
          if (!this.PhN.gRN()) {
            paramm.a(j, 100, paramView.getContext().getString(2131757433), 2131690529);
          }
        }
      }
      while (locala.qcr != 2)
      {
        AppMethodBeat.o(233925);
        return true;
      }
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
      AppMethodBeat.o(233925);
      return false;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233926);
      paramca.unsetOmittedFailResend();
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      if ((paramca.isText()) && (paramca.field_isSend == 1)) {
        bK(paramca);
      }
      AppMethodBeat.o(233926);
    }
    
    public boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean gS(View paramView)
    {
      AppMethodBeat.i(37416);
      if (v.gQ(paramView))
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
        ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dTX.field_msgId);
        if (((com.tencent.mm.ui.chatting.d.b.x)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(locala.dTX))
        {
          localObject1 = ((MMNeat7extView)paramView).hiT().toString();
          ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
          ((Intent)localObject2).putExtra("is_group_chat", this.PhN.gRM());
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(locala.dTX.field_talker);
          localObject1 = paramView.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kc(paramView.getContext());
        }
      }
      else
      {
        AppMethodBeat.o(37416);
        return true;
      }
      Object localObject1 = (au)this.PhN.bh(au.class);
      ca localca = locala.dTX;
      if (locala.qcr == 2) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((au)localObject1).g(localca, bool);
        break;
      }
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
      AppMethodBeat.i(37418);
      Log.d("OnTouchOutside", "touchOutside");
      this.PkL.hbA();
      this.PkL.QXX = true;
      this.PkL.hcR();
      this.PkL.QXW = true;
      this.PkL.hcS();
      this.PkL.hcU();
      AppMethodBeat.o(37418);
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
      parama = (bq)paramView.getTag();
      if (paramca.gDg())
      {
        if (this.PhN != null)
        {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10221, "1");
          paramView = new Intent();
          paramView.addFlags(67108864);
          com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(37419);
        return;
      }
      if ((paramca.isText()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.m.a.a.gTK();
        com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dTX);
      }
      AppMethodBeat.o(37419);
    }
  }
  
  static final class f
    extends c.a
  {
    a.f PGP;
    LinearLayout PIY;
    TextView PIZ;
    ImageView PIn;
    com.tencent.mm.ui.widget.textview.a PKE;
    com.tencent.mm.pluginsdk.ui.span.h PKF;
    a.e PKG;
    ViewStub PKH;
    ChattingItemTranslate PKI;
    MMNeat7extView POU;
    View jxm;
    protected TextView tln;
    com.tencent.mm.ui.widget.b.a wnj;
    
    private static boolean gUh()
    {
      AppMethodBeat.i(37421);
      try
      {
        String str = com.tencent.mm.n.h.aqJ().getValue("CellTextViewEnable");
        int i = Util.getInt(str, 1);
        boolean bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OeN, true);
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
    
    public final c.a G(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37420);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(2131298558));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.POU = ((MMNeat7extView)paramView.findViewById(2131298416));
      this.POU.setMaxWidth((int)(com.tencent.mm.cb.a.aH(this.POU.getContext(), 2131166078) / com.tencent.mm.cc.a.gvi()));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.jxm = paramView.findViewById(2131298414);
      this.PKH = ((ViewStub)paramView.findViewById(2131309405));
      if (!paramBoolean)
      {
        this.PIn = ((ImageView)paramView.findViewById(2131298556));
        this.stateIV = ((ImageView)paramView.findViewById(2131298554));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      }
      this.PKF = new com.tencent.mm.pluginsdk.ui.span.h(this.POU, new o(this.POU.getContext()));
      this.POU.setIsOpen(gUh());
      this.POU.setTextCrashListener(new bd.c((byte)0));
      this.tln = ((TextView)paramView.findViewById(2131298385));
      this.PIY = ((LinearLayout)paramView.findViewById(2131298391));
      this.PIZ = ((TextView)paramView.findViewById(2131298392));
      AppMethodBeat.o(37420);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return this.POU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd
 * JD-Core Version:    0.7.0.1
 */