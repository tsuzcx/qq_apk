package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.i;
import com.tencent.mm.br.c.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  private static a PgF;
  private static com.tencent.mm.ui.base.q Pgl = null;
  
  public static void a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.Pwc.getContext();
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131755998);
      Pgl = h.a(localActivity, localActivity.getString(2131765232), false, null);
      com.tencent.mm.ui.chatting.d.m.PnZ.add(new b(parama, localActivity, paramString, paramLong, PgF));
    }
    ((com.tencent.mm.ui.chatting.d.b.l)parama.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPz();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final a parama, List<ca> paramList, boolean paramBoolean, final com.tencent.mm.ui.chatting.d.m paramm, final as paramas)
  {
    AppMethodBeat.i(34476);
    if (parama == null)
    {
      Log.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      AppMethodBeat.o(34476);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      AppMethodBeat.o(34476);
      return;
    }
    Object localObject = new a((byte)0);
    PgF = (a)localObject;
    ((a)localObject).PgD = new LinkedList(paramList);
    PgF.Pdm = paramBoolean;
    PgF.from = paramas.field_username;
    PgF.PgM = true;
    final Activity localActivity = parama.Pwc.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
    locall.HMa = new n.1();
    locall.HMb = new n.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.q.s(localActivity, "com.tencent.wework")) {}
    for (localObject = k.gNv();; localObject = k.gNu())
    {
      locall.HLX = new n.3((List)localObject);
      locall.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (k.jj(this.Pgx))
            {
              h.a(localActivity, localActivity.getString(2131758177), "", localActivity.getString(2131755013), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.jk(this.Pgx))
            {
              h.a(localActivity, localActivity.getString(2131758178), "", localActivity.getString(2131755013), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.ji(this.Pgx))
            {
              h.a(localActivity, localActivity.getString(2131758179), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((o.a(parama, this.Pgx, paramas)) && (paramm != null)) {
              paramm.gPz();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (k.jj(this.Pgx))
          {
            h.a(localActivity, localActivity.getString(2131758177), "", localActivity.getString(2131755013), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (k.jk(this.Pgx))
          {
            h.a(localActivity, localActivity.getString(2131758178), "", localActivity.getString(2131755013), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.Pgx;
          if (localObject == null)
          {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label380;
            break label380;
          }
          label324:
          label380:
          ca localca;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!k.ji(this.Pgx))) {
                break;
              }
              h.a(localActivity, localActivity.getString(2131758179), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
              localIterator = ((List)localObject).iterator();
            } while (!localIterator.hasNext());
            localca = (ca)localIterator.next();
          } while (localca.field_isSend == 1);
          if (localca.gAz()) {
            if (localca.field_msgId <= 0L) {
              break label892;
            }
          }
          label890:
          label892:
          for (localObject = com.tencent.mm.av.q.bcR().H(localca.field_talker, localca.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.av.g)localObject).localId <= 0L)) && (localca.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).iKP) && (((com.tencent.mm.av.g)localObject).iKP != 0))) {
                break label890;
              }
              paramAnonymousInt = 1;
              break label324;
              if (localca.cWJ())
              {
                localObject = com.tencent.mm.modelvideo.o.bhj().Qq(localca.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (localca.cWL())
              {
                localObject = u.QN(localca.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (!localca.gDo()) {
                break;
              }
              if (!k.bi(localca))
              {
                paramAnonymousInt = 1;
                break label324;
              }
              paramAnonymousInt = 0;
              break label324;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (com.tencent.mm.al.g.Ne((String)localObject))
              {
                if (this.Pgx.size() <= 1)
                {
                  n.gNA().PgM = true;
                  n.a((String)localObject, parama, this.Pgx);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.HLX = new o.f()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2m.kV(0, 2131763226);
                    paramAnonymous2m.kV(1, 2131763227);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.HLY = new o.g()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34465);
                    switch (paramAnonymous2MenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(34465);
                      return;
                      n.gNA().PgM = true;
                      n.a(this.gtz, n.4.this.PgH, n.4.this.Pgx);
                      AppMethodBeat.o(34465);
                      return;
                      n.gNA().PgM = false;
                      n.a(this.gtz, n.4.this.PgH, n.4.this.Pgx);
                    }
                  }
                };
                paramAnonymousMenuItem.dGm();
                AppMethodBeat.o(34467);
                return;
              }
              if (k.jg(this.Pgx))
              {
                localObject = localActivity.getString(2131761793);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = n.4.this.Pgx;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      Log.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label33:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label182;
                      }
                      Log.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (n.4.this.PgJ != null) {
                        n.4.this.PgJ.gPz();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      ca localca = (ca)paramAnonymous2DialogInterface.next();
                      if (k.bm(localca)) {
                        break label33;
                      }
                      if ((localca.gAy()) || (k.bh(localca)) || (localca.gDl()) || (k.bj(localca)) || (k.bk(localca)) || (localca.getType() == -1879048186) || (k.br(localca)) || (k.bl(localca)) || (k.bq(localca)) || (k.bw(localca))) {
                        break;
                      }
                    }
                    label182:
                    paramAnonymous2DialogInterface = n.4.this.val$context;
                    n.4.this.val$context.getString(2131755998);
                    n.e(h.a(paramAnonymous2DialogInterface, n.4.this.val$context.getString(2131765232), false, null));
                    com.tencent.mm.ui.chatting.d.m.PnZ.add(new n.b(n.4.this.PgH, n.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, n.gNA()));
                    if (n.4.this.PgJ != null) {
                      n.4.this.PgJ.gPz();
                    }
                    AppMethodBeat.o(34466);
                  }
                }, null);
                AppMethodBeat.o(34467);
                return;
              }
              localObject = localActivity;
              localActivity.getString(2131755998);
              n.e(h.a((Context)localObject, localActivity.getString(2131765232), false, null));
              com.tencent.mm.ui.chatting.d.m.PnZ.add(new n.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, n.gNA()));
              if (paramm != null) {
                paramm.gPz();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label380;
          }
        }
      };
      locall.gXI();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = com.tencent.mm.al.g.fJ(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).UH())
    {
      localObject = new Intent(parama.Pwc.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", PgF.PgM);
      parama.a((Intent)localObject, 225, new c.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(34469);
          if (paramAnonymousIntent == null)
          {
            Log.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
            AppMethodBeat.o(34469);
            return;
          }
          if (paramAnonymousInt1 == 225)
          {
            String str = paramAnonymousIntent.getStringExtra("enterprise_biz_name");
            long l = paramAnonymousIntent.getLongExtra("key_biz_chat_id", -1L);
            n.a(this.PgH, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).UF())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.br.c.a(parama.Pwc, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final a parama, List<ca> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.Pwc.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = com.tencent.mm.al.g.fJ(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).UH();
    boolean bool2;
    int i;
    if (PgF.PgM)
    {
      bool2 = k.jg(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          PgF.PgD = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label268;
          }
          paramList = localActivity.getString(2131758739);
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        h.a(localActivity, paramList, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34468);
            n.a(this.OAy, parama);
            AppMethodBeat.o(34468);
          }
        }, null);
        AppMethodBeat.o(34477);
        return;
        localObject = paramList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ca localca = (ca)((Iterator)localObject).next();
            if ((!localca.isText()) && (!localca.gAy()) && (!localca.gAz()) && (!localca.dOS()) && (!k.bp(localca)))
            {
              i = 1;
              break;
            }
          }
        }
        i = 0;
        break;
        if (!bool2) {
          break label268;
        }
        paramList = localActivity.getString(2131758740);
        continue;
      }
      a(paramString, parama);
      AppMethodBeat.o(34477);
      return;
      label268:
      paramList = null;
    }
  }
  
  public static rc cI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    rc localrc = new rc();
    localrc.dXF.type = 6;
    localrc.dXF.dXK = PgF.PgD;
    localrc.dXF.toUser = paramString;
    localrc.dXF.from = PgF.from;
    localrc.dXF.context = paramContext;
    EventCenter.instance.publish(localrc);
    PgF.dWX = localrc.dXG.dWX;
    PgF.PgE = localrc.dXG.dXM;
    AppMethodBeat.o(34479);
    return localrc;
  }
  
  static final class a
  {
    boolean Pdm;
    List<ca> PgD;
    com.tencent.mm.protocal.b.a.d PgE;
    boolean PgM;
    cz dWX;
    String from;
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private n.a PgN;
    private Context context;
    private a dom;
    private String iNV;
    private long ppv;
    private boolean tca;
    
    public b(a parama, Context paramContext, String paramString, long paramLong, n.a parama1)
    {
      AppMethodBeat.i(34470);
      this.dom = parama;
      this.context = paramContext;
      this.iNV = paramString;
      this.ppv = paramLong;
      this.PgN = parama1;
      this.tca = com.tencent.mm.al.g.DQ(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, ca paramca, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (paramca.isText())
      {
        k.a(paramContext, paramString, paramca, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramca.gAz())
      {
        k.b(paramContext, paramString, paramca);
        AppMethodBeat.o(34472);
        return;
      }
      if ((paramca.cWJ()) && (!this.tca))
      {
        k.c(paramContext, paramString, paramca);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramca.dOS())
      {
        k.c(paramContext, paramString, paramca, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((paramca.gDn()) || (paramca.gDo())) && (!this.tca))
      {
        if (!k.bh(paramca))
        {
          k.a(paramContext, paramString, paramca);
          AppMethodBeat.o(34472);
        }
      }
      else if (paramca.dOQ())
      {
        if ((this.tca) && (!k.bp(paramca)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.bq(paramca))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (paramca.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.bw(paramca))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!k.bj(paramca)) {
          k.b(paramContext, paramString, paramca, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void gNC()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.PgN.PgD.iterator();
      while (localIterator.hasNext())
      {
        ca localca = (ca)localIterator.next();
        a(this.context, localca, this.PgN.Pdm, this.iNV);
      }
      AppMethodBeat.o(34473);
    }
    
    private void gND()
    {
      AppMethodBeat.i(34474);
      n.cI(this.context, this.iNV);
      rc localrc = new rc();
      localrc.dXF.type = 5;
      localrc.dXF.dXK = this.PgN.PgD;
      localrc.dXF.toUser = this.iNV;
      localrc.dXF.from = this.PgN.from;
      localrc.dXF.context = this.context;
      localrc.dXF.dWX = this.PgN.dWX;
      localrc.dXF.dXM = this.PgN.PgE;
      EventCenter.instance.publish(localrc);
      AppMethodBeat.o(34474);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34471);
      if (this.tca)
      {
        com.tencent.mm.al.a.c localc = ag.baj().bs(this.ppv);
        synchronized (com.tencent.mm.al.a.e.iPQ)
        {
          String str = com.tencent.mm.al.a.e.ajw();
          com.tencent.mm.al.a.e.d(localc);
          if (this.PgN.PgM)
          {
            gNC();
            com.tencent.mm.al.a.e.NL(str);
            AppMethodBeat.o(34471);
            return true;
          }
          gND();
        }
      }
      if (this.PgN.PgM) {
        gNC();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        gND();
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34475);
      if (n.gNB() != null) {
        n.gNB().dismiss();
      }
      b.a(this.context, this.dom.findViewById(2131304715), this.context.getString(2131760708), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */