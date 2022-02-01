package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.aw.g;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.c.k;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static p GmB = null;
  private static a GmW;
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.GzJ.getContext();
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131755906);
      GmB = h.b(localActivity, localActivity.getString(2131763073), false, null);
      k.Gtr.c(new b(parama, localActivity, paramString, paramLong, GmW));
    }
    ((com.tencent.mm.ui.chatting.c.b.j)parama.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXg();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.d.a parama, List<bl> paramList, boolean paramBoolean, final k paramk, final com.tencent.mm.storage.af paramaf)
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
    GmW = (a)localObject;
    ((a)localObject).GmU = new LinkedList(paramList);
    GmW.GjM = paramBoolean;
    GmW.dvh = paramaf.field_username;
    GmW.Gnc = true;
    final Activity localActivity = parama.GzJ.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
    locall.Hsb = new n.a()
    {
      public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34461);
        a.b.w(paramAnonymousImageView, paramAnonymousMenuItem.getTitle());
        AppMethodBeat.o(34461);
      }
    };
    locall.Hsc = new m.2(localActivity);
    if (q.t(localActivity, "com.tencent.wework")) {}
    for (localObject = j.eVk();; localObject = j.eVj())
    {
      locall.HrX = new m.3((List)localObject);
      locall.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (j.hx(this.GmN))
            {
              h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hy(this.GmN))
            {
              h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hw(this.GmN))
            {
              h.a(localActivity, localActivity.getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((n.a(parama, this.GmN, paramaf)) && (paramk != null)) {
              paramk.eXg();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hx(this.GmN))
          {
            h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hy(this.GmN))
          {
            h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.GmN;
          if (localObject == null)
          {
            ad.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label380;
            break label380;
          }
          label324:
          label380:
          bl localbl;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!j.hw(this.GmN))) {
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
            localbl = (bl)localIterator.next();
          } while (localbl.field_isSend == 1);
          if (localbl.eJO()) {
            if (localbl.field_msgId <= 0L) {
              break label882;
            }
          }
          label880:
          label882:
          for (localObject = com.tencent.mm.aw.o.ayF().ms(localbl.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.aw.e)localObject).deI <= 0L)) && (localbl.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.aw.o.ayF().mr(localbl.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.aw.e)localObject).offset >= ((com.tencent.mm.aw.e)localObject).gTY) && (((com.tencent.mm.aw.e)localObject).gTY != 0))) {
                break label880;
              }
              paramAnonymousInt = 1;
              break label324;
              if (localbl.cjM())
              {
                localObject = com.tencent.mm.modelvideo.o.aCI().zO(localbl.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (localbl.cjO())
              {
                localObject = u.Ae(localbl.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (!localbl.eLZ()) {
                break;
              }
              if (!j.aO(localbl))
              {
                paramAnonymousInt = 1;
                break label324;
              }
              paramAnonymousInt = 0;
              break label324;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (f.wJ((String)localObject))
              {
                if (this.GmN.size() <= 1)
                {
                  m.eVo().Gnc = true;
                  m.a((String)localObject, parama, this.GmN);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.HrX = new n.c()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2l.jj(0, 2131761385);
                    paramAnonymous2l.jj(1, 2131761386);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.HrY = new n.d()
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
                      m.eVo().Gnc = true;
                      m.a(this.gXD, m.4.this.GmY, m.4.this.GmN);
                      AppMethodBeat.o(34465);
                      return;
                      m.eVo().Gnc = false;
                      m.a(this.gXD, m.4.this.GmY, m.4.this.GmN);
                    }
                  }
                };
                paramAnonymousMenuItem.csG();
                AppMethodBeat.o(34467);
                return;
              }
              if (j.hu(this.GmN))
              {
                localObject = localActivity.getString(2131760348);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = m.4.this.GmN;
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
                      if (m.4.this.GmZ != null) {
                        m.4.this.GmZ.eXg();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      bl localbl = (bl)paramAnonymous2DialogInterface.next();
                      if (j.aS(localbl)) {
                        break label33;
                      }
                      if ((localbl.eJN()) || (j.aN(localbl)) || (localbl.eLX()) || (j.aP(localbl)) || (j.aQ(localbl)) || (localbl.getType() == -1879048186) || (j.aX(localbl)) || (j.aR(localbl)) || (j.aW(localbl)) || (j.bc(localbl))) {
                        break;
                      }
                    }
                    label182:
                    paramAnonymous2DialogInterface = m.4.this.val$context;
                    m.4.this.val$context.getString(2131755906);
                    m.c(h.b(paramAnonymous2DialogInterface, m.4.this.val$context.getString(2131763073), false, null));
                    k.Gtr.c(new m.b(m.4.this.GmY, m.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, m.eVo()));
                    if (m.4.this.GmZ != null) {
                      m.4.this.GmZ.eXg();
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
              k.Gtr.c(new m.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, m.eVo()));
              if (paramk != null) {
                paramk.eXg();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label380;
          }
        }
      };
      locall.fdQ();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = f.ei(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Jg())
    {
      localObject = new Intent(parama.GzJ.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", GmW.Gnc);
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
            m.a(this.GmY, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Je())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.bs.d.a(parama.GzJ, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final com.tencent.mm.ui.chatting.d.a parama, List<bl> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.GzJ.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = f.ei(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).Jg();
    boolean bool2;
    int i;
    if (GmW.Gnc)
    {
      bool2 = j.hu(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          GmW.GmU = new LinkedList(paramList);
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
            m.a(this.FJl, parama);
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
            bl localbl = (bl)((Iterator)localObject).next();
            if ((!localbl.isText()) && (!localbl.eJN()) && (!localbl.eJO()) && (!localbl.cxD()) && (!j.aV(localbl)))
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
  
  public static pn cj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    pn localpn = new pn();
    localpn.dvb.type = 6;
    localpn.dvb.dvg = GmW.GmU;
    localpn.dvb.toUser = paramString;
    localpn.dvb.dvh = GmW.dvh;
    localpn.dvb.context = paramContext;
    com.tencent.mm.sdk.b.a.ESL.l(localpn);
    GmW.duB = localpn.dvc.duB;
    GmW.GmV = localpn.dvc.dvj;
    AppMethodBeat.o(34479);
    return localpn;
  }
  
  static final class a
  {
    boolean GjM;
    List<bl> GmU;
    com.tencent.mm.protocal.b.a.d GmV;
    boolean Gnc;
    cs duB;
    String dvh;
  }
  
  static final class b
    implements be.a
  {
    private m.a Gnd;
    private com.tencent.mm.ui.chatting.d.a cOd;
    private Context context;
    private String gWU;
    private long mUQ;
    private boolean qbB;
    
    public b(com.tencent.mm.ui.chatting.d.a parama, Context paramContext, String paramString, long paramLong, m.a parama1)
    {
      AppMethodBeat.i(34470);
      this.cOd = parama;
      this.context = paramContext;
      this.gWU = paramString;
      this.mUQ = paramLong;
      this.Gnd = parama1;
      this.qbB = f.pc(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, bl parambl, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (parambl.isText())
      {
        j.a(paramContext, paramString, parambl, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambl.eJO())
      {
        j.b(paramContext, paramString, parambl);
        AppMethodBeat.o(34472);
        return;
      }
      if ((parambl.cjM()) && (!this.qbB))
      {
        j.c(paramContext, paramString, parambl);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambl.cxD())
      {
        j.c(paramContext, paramString, parambl, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((parambl.eLY()) || (parambl.eLZ())) && (!this.qbB))
      {
        if (!j.aN(parambl))
        {
          j.a(paramContext, paramString, parambl);
          AppMethodBeat.o(34472);
        }
      }
      else if (parambl.cxB())
      {
        if ((this.qbB) && (!j.aV(parambl)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.aW(parambl))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (parambl.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.bc(parambl))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!j.aP(parambl)) {
          j.b(paramContext, paramString, parambl, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void eVq()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.Gnd.GmU.iterator();
      while (localIterator.hasNext())
      {
        bl localbl = (bl)localIterator.next();
        a(this.context, localbl, this.Gnd.GjM, this.gWU);
      }
      AppMethodBeat.o(34473);
    }
    
    private void eVr()
    {
      AppMethodBeat.i(34474);
      m.cj(this.context, this.gWU);
      pn localpn = new pn();
      localpn.dvb.type = 5;
      localpn.dvb.dvg = this.Gnd.GmU;
      localpn.dvb.toUser = this.gWU;
      localpn.dvb.dvh = this.Gnd.dvh;
      localpn.dvb.context = this.context;
      localpn.dvb.duB = this.Gnd.duB;
      localpn.dvb.dvj = this.Gnd.GmV;
      com.tencent.mm.sdk.b.a.ESL.l(localpn);
      AppMethodBeat.o(34474);
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(34471);
      if (this.qbB)
      {
        com.tencent.mm.am.a.c localc = com.tencent.mm.am.af.awg().bg(this.mUQ);
        synchronized (com.tencent.mm.am.a.e.gYR)
        {
          String str = com.tencent.mm.am.a.e.SM();
          com.tencent.mm.am.a.e.d(localc);
          if (this.Gnd.Gnc)
          {
            eVq();
            com.tencent.mm.am.a.e.xq(str);
            AppMethodBeat.o(34471);
            return true;
          }
          eVr();
        }
      }
      if (this.Gnd.Gnc) {
        eVq();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        eVr();
      }
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(34475);
      if (m.eVp() != null) {
        m.eVp().dismiss();
      }
      b.a(this.context, this.cOd.findViewById(2131302320), this.context.getString(2131759420), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */