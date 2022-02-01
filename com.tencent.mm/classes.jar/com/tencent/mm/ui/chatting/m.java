package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.i;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static a JAC;
  private static p JAh = null;
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.JOR.getContext();
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131755906);
      JAh = h.b(localActivity, localActivity.getString(2131763073), false, null);
      com.tencent.mm.ui.chatting.d.m.JHH.c(new b(parama, localActivity, paramString, paramLong, JAC));
    }
    ((com.tencent.mm.ui.chatting.d.b.l)parama.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDq();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.e.a parama, List<bu> paramList, boolean paramBoolean, final com.tencent.mm.ui.chatting.d.m paramm, final am paramam)
  {
    AppMethodBeat.i(34476);
    if (parama == null)
    {
      ad.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      AppMethodBeat.o(34476);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      AppMethodBeat.o(34476);
      return;
    }
    Object localObject = new a((byte)0);
    JAC = (a)localObject;
    ((a)localObject).JAA = new LinkedList(paramList);
    JAC.Jxs = paramBoolean;
    JAC.dET = paramam.field_username;
    JAC.JAI = true;
    final Activity localActivity = parama.JOR.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
    locall.KJC = new m.1();
    locall.KJD = new m.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.q.s(localActivity, "com.tencent.wework")) {}
    for (localObject = j.fBl();; localObject = j.fBk())
    {
      locall.KJy = new m.3((List)localObject);
      locall.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (j.hW(this.JAt))
            {
              h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hX(this.JAt))
            {
              h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hV(this.JAt))
            {
              h.a(localActivity, localActivity.getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((n.a(parama, this.JAt, paramam)) && (paramm != null)) {
              paramm.fDq();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hW(this.JAt))
          {
            h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hX(this.JAt))
          {
            h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.JAt;
          if (localObject == null)
          {
            ad.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label380;
            break label380;
          }
          label324:
          label380:
          bu localbu;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!j.hV(this.JAt))) {
                break;
              }
              h.a(localActivity, localActivity.getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
              localIterator = ((List)localObject).iterator();
            } while (!localIterator.hasNext());
            localbu = (bu)localIterator.next();
          } while (localbu.field_isSend == 1);
          if (localbu.fpi()) {
            if (localbu.field_msgId <= 0L) {
              break label892;
            }
          }
          label890:
          label892:
          for (localObject = com.tencent.mm.aw.q.aIF().G(localbu.field_talker, localbu.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.aw.g)localObject).dnz <= 0L)) && (localbu.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.aw.q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.aw.g)localObject).offset >= ((com.tencent.mm.aw.g)localObject).hMP) && (((com.tencent.mm.aw.g)localObject).hMP != 0))) {
                break label890;
              }
              paramAnonymousInt = 1;
              break label324;
              if (localbu.cxf())
              {
                localObject = o.aMJ().Hb(localbu.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (localbu.cxh())
              {
                localObject = u.Hy(localbu.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (!localbu.frH()) {
                break;
              }
              if (!j.aT(localbu))
              {
                paramAnonymousInt = 1;
                break label324;
              }
              paramAnonymousInt = 0;
              break label324;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (com.tencent.mm.am.g.DO((String)localObject))
              {
                if (this.JAt.size() <= 1)
                {
                  m.fBq().JAI = true;
                  m.a((String)localObject, parama, this.JAt);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.KJy = new n.d()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2l.jI(0, 2131761385);
                    paramAnonymous2l.jI(1, 2131761386);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.KJz = new n.e()
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
                      m.fBq().JAI = true;
                      m.a(this.fNT, m.4.this.JAE, m.4.this.JAt);
                      AppMethodBeat.o(34465);
                      return;
                      m.fBq().JAI = false;
                      m.a(this.fNT, m.4.this.JAE, m.4.this.JAt);
                    }
                  }
                };
                paramAnonymousMenuItem.cMW();
                AppMethodBeat.o(34467);
                return;
              }
              if (j.hT(this.JAt))
              {
                localObject = localActivity.getString(2131760348);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = m.4.this.JAt;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      ad.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label33:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label182;
                      }
                      ad.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (m.4.this.JAF != null) {
                        m.4.this.JAF.fDq();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      bu localbu = (bu)paramAnonymous2DialogInterface.next();
                      if (j.aX(localbu)) {
                        break label33;
                      }
                      if ((localbu.fph()) || (j.aS(localbu)) || (localbu.frE()) || (j.aU(localbu)) || (j.aV(localbu)) || (localbu.getType() == -1879048186) || (j.bc(localbu)) || (j.aW(localbu)) || (j.bb(localbu)) || (j.bh(localbu))) {
                        break;
                      }
                    }
                    label182:
                    paramAnonymous2DialogInterface = m.4.this.val$context;
                    m.4.this.val$context.getString(2131755906);
                    m.c(h.b(paramAnonymous2DialogInterface, m.4.this.val$context.getString(2131763073), false, null));
                    com.tencent.mm.ui.chatting.d.m.JHH.c(new m.b(m.4.this.JAE, m.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, m.fBq()));
                    if (m.4.this.JAF != null) {
                      m.4.this.JAF.fDq();
                    }
                    AppMethodBeat.o(34466);
                  }
                }, null);
                AppMethodBeat.o(34467);
                return;
              }
              localObject = localActivity;
              localActivity.getString(2131755906);
              m.c(h.b((Context)localObject, localActivity.getString(2131763073), false, null));
              com.tencent.mm.ui.chatting.d.m.JHH.c(new m.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, m.fBq()));
              if (paramm != null) {
                paramm.fDq();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label380;
          }
        }
      };
      locall.fKy();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = com.tencent.mm.am.g.eS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Kp())
    {
      localObject = new Intent(parama.JOR.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", JAC.JAI);
      parama.a((Intent)localObject, 225, new d.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(34469);
          if (paramAnonymousIntent == null)
          {
            ad.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
            AppMethodBeat.o(34469);
            return;
          }
          if (paramAnonymousInt1 == 225)
          {
            String str = paramAnonymousIntent.getStringExtra("enterprise_biz_name");
            long l = paramAnonymousIntent.getLongExtra("key_biz_chat_id", -1L);
            m.a(this.JAE, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Kn())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.bs.d.a(parama.JOR, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final com.tencent.mm.ui.chatting.e.a parama, List<bu> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.JOR.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = com.tencent.mm.am.g.eS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).Kp();
    boolean bool2;
    int i;
    if (JAC.JAI)
    {
      bool2 = j.hT(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          JAC.JAA = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label268;
          }
          paramList = localActivity.getString(2131758441);
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
            m.a(this.IVK, parama);
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
            bu localbu = (bu)((Iterator)localObject).next();
            if ((!localbu.isText()) && (!localbu.fph()) && (!localbu.fpi()) && (!localbu.cTe()) && (!j.ba(localbu)))
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
        paramList = localActivity.getString(2131758442);
        continue;
      }
      a(paramString, parama);
      AppMethodBeat.o(34477);
      return;
      label268:
      paramList = null;
    }
  }
  
  public static qh co(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    qh localqh = new qh();
    localqh.dEN.type = 6;
    localqh.dEN.dES = JAC.JAA;
    localqh.dEN.toUser = paramString;
    localqh.dEN.dET = JAC.dET;
    localqh.dEN.context = paramContext;
    com.tencent.mm.sdk.b.a.IbL.l(localqh);
    JAC.dEg = localqh.dEO.dEg;
    JAC.JAB = localqh.dEO.dEV;
    AppMethodBeat.o(34479);
    return localqh;
  }
  
  static final class a
  {
    List<bu> JAA;
    com.tencent.mm.protocal.b.a.d JAB;
    boolean JAI;
    boolean Jxs;
    String dET;
    cv dEg;
  }
  
  static final class b
    implements be.a
  {
    private m.a JAJ;
    private com.tencent.mm.ui.chatting.e.a cWM;
    private Context context;
    private String hPO;
    private long nYO;
    private boolean ruj;
    
    public b(com.tencent.mm.ui.chatting.e.a parama, Context paramContext, String paramString, long paramLong, m.a parama1)
    {
      AppMethodBeat.i(34470);
      this.cWM = parama;
      this.context = paramContext;
      this.hPO = paramString;
      this.nYO = paramLong;
      this.JAJ = parama1;
      this.ruj = com.tencent.mm.am.g.vd(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, bu parambu, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (parambu.isText())
      {
        j.a(paramContext, paramString, parambu, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambu.fpi())
      {
        j.b(paramContext, paramString, parambu);
        AppMethodBeat.o(34472);
        return;
      }
      if ((parambu.cxf()) && (!this.ruj))
      {
        j.c(paramContext, paramString, parambu);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambu.cTe())
      {
        j.c(paramContext, paramString, parambu, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((parambu.frG()) || (parambu.frH())) && (!this.ruj))
      {
        if (!j.aS(parambu))
        {
          j.a(paramContext, paramString, parambu);
          AppMethodBeat.o(34472);
        }
      }
      else if (parambu.cTc())
      {
        if ((this.ruj) && (!j.ba(parambu)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.bb(parambu))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (parambu.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.bh(parambu))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!j.aU(parambu)) {
          j.b(paramContext, paramString, parambu, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void fBs()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.JAJ.JAA.iterator();
      while (localIterator.hasNext())
      {
        bu localbu = (bu)localIterator.next();
        a(this.context, localbu, this.JAJ.Jxs, this.hPO);
      }
      AppMethodBeat.o(34473);
    }
    
    private void fBt()
    {
      AppMethodBeat.i(34474);
      m.co(this.context, this.hPO);
      qh localqh = new qh();
      localqh.dEN.type = 5;
      localqh.dEN.dES = this.JAJ.JAA;
      localqh.dEN.toUser = this.hPO;
      localqh.dEN.dET = this.JAJ.dET;
      localqh.dEN.context = this.context;
      localqh.dEN.dEg = this.JAJ.dEg;
      localqh.dEN.dEV = this.JAJ.JAB;
      com.tencent.mm.sdk.b.a.IbL.l(localqh);
      AppMethodBeat.o(34474);
    }
    
    public final boolean aEm()
    {
      AppMethodBeat.i(34471);
      if (this.ruj)
      {
        com.tencent.mm.am.a.c localc = ag.aGb().bd(this.nYO);
        synchronized (com.tencent.mm.am.a.e.hRL)
        {
          String str = com.tencent.mm.am.a.e.VW();
          com.tencent.mm.am.a.e.d(localc);
          if (this.JAJ.JAI)
          {
            fBs();
            com.tencent.mm.am.a.e.Ev(str);
            AppMethodBeat.o(34471);
            return true;
          }
          fBt();
        }
      }
      if (this.JAJ.JAI) {
        fBs();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        fBt();
      }
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(34475);
      if (m.fBr() != null) {
        m.fBr().dismiss();
      }
      b.a(this.context, this.cWM.findViewById(2131302320), this.context.getString(2131759420), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */