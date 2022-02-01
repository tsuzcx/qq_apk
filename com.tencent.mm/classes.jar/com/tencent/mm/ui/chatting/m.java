package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.av.g;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.h;
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
  private static a HMM;
  private static p HMr = null;
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.HZF.getContext();
    if ((!bs.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131755906);
      HMr = h.b(localActivity, localActivity.getString(2131763073), false, null);
      k.HTk.c(new b(parama, localActivity, paramString, paramLong, HMM));
    }
    ((com.tencent.mm.ui.chatting.c.b.j)parama.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmS();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.d.a parama, List<bo> paramList, boolean paramBoolean, final k paramk, final ai paramai)
  {
    AppMethodBeat.i(34476);
    if (parama == null)
    {
      ac.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      AppMethodBeat.o(34476);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      AppMethodBeat.o(34476);
      return;
    }
    Object localObject = new a((byte)0);
    HMM = (a)localObject;
    ((a)localObject).HMK = new LinkedList(paramList);
    HMM.HJB = paramBoolean;
    HMM.dsT = paramai.field_username;
    HMM.HMS = true;
    final Activity localActivity = parama.HZF.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
    locall.ISy = new m.1();
    locall.ISz = new m.2(localActivity);
    if (q.t(localActivity, "com.tencent.wework")) {}
    for (localObject = j.fkW();; localObject = j.fkV())
    {
      locall.ISu = new m.3((List)localObject);
      locall.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (j.hK(this.HMD))
            {
              h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hL(this.HMD))
            {
              h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (j.hJ(this.HMD))
            {
              h.a(localActivity, localActivity.getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((n.a(parama, this.HMD, paramai)) && (paramk != null)) {
              paramk.fmS();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hK(this.HMD))
          {
            h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (j.hL(this.HMD))
          {
            h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.HMD;
          if (localObject == null)
          {
            ac.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label380;
            break label380;
          }
          label324:
          label380:
          bo localbo;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!j.hJ(this.HMD))) {
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
            localbo = (bo)localIterator.next();
          } while (localbo.field_isSend == 1);
          if (localbo.eZm()) {
            if (localbo.field_msgId <= 0L) {
              break label882;
            }
          }
          label880:
          label882:
          for (localObject = com.tencent.mm.av.o.aFx().qg(localbo.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.av.e)localObject).dcd <= 0L)) && (localbo.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.av.e)localObject).offset >= ((com.tencent.mm.av.e)localObject).hux) && (((com.tencent.mm.av.e)localObject).hux != 0))) {
                break label880;
              }
              paramAnonymousInt = 1;
              break label324;
              if (localbo.crt())
              {
                localObject = com.tencent.mm.modelvideo.o.aJy().DT(localbo.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (localbo.crv())
              {
                localObject = u.Ej(localbo.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (!localbo.fbD()) {
                break;
              }
              if (!j.aQ(localbo))
              {
                paramAnonymousInt = 1;
                break label324;
              }
              paramAnonymousInt = 0;
              break label324;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (f.AP((String)localObject))
              {
                if (this.HMD.size() <= 1)
                {
                  m.fla().HMS = true;
                  m.a((String)localObject, parama, this.HMD);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.ISu = new n.c()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2l.jw(0, 2131761385);
                    paramAnonymous2l.jw(1, 2131761386);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.ISv = new n.d()
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
                      m.fla().HMS = true;
                      m.a(this.hyc, m.4.this.HMO, m.4.this.HMD);
                      AppMethodBeat.o(34465);
                      return;
                      m.fla().HMS = false;
                      m.a(this.hyc, m.4.this.HMO, m.4.this.HMD);
                    }
                  }
                };
                paramAnonymousMenuItem.cED();
                AppMethodBeat.o(34467);
                return;
              }
              if (j.hH(this.HMD))
              {
                localObject = localActivity.getString(2131760348);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = m.4.this.HMD;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      ac.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label33:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label182;
                      }
                      ac.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (m.4.this.HMP != null) {
                        m.4.this.HMP.fmS();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      bo localbo = (bo)paramAnonymous2DialogInterface.next();
                      if (j.aU(localbo)) {
                        break label33;
                      }
                      if ((localbo.eZl()) || (j.aP(localbo)) || (localbo.fbB()) || (j.aR(localbo)) || (j.aS(localbo)) || (localbo.getType() == -1879048186) || (j.aZ(localbo)) || (j.aT(localbo)) || (j.aY(localbo)) || (j.be(localbo))) {
                        break;
                      }
                    }
                    label182:
                    paramAnonymous2DialogInterface = m.4.this.val$context;
                    m.4.this.val$context.getString(2131755906);
                    m.c(h.b(paramAnonymous2DialogInterface, m.4.this.val$context.getString(2131763073), false, null));
                    k.HTk.c(new m.b(m.4.this.HMO, m.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, m.fla()));
                    if (m.4.this.HMP != null) {
                      m.4.this.HMP.fmS();
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
              k.HTk.c(new m.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, m.fla()));
              if (paramk != null) {
                paramk.fmS();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label380;
          }
        }
      };
      locall.ftL();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = f.dX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).IP())
    {
      localObject = new Intent(parama.HZF.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", HMM.HMS);
      parama.a((Intent)localObject, 225, new d.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(34469);
          if (paramAnonymousIntent == null)
          {
            ac.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
            AppMethodBeat.o(34469);
            return;
          }
          if (paramAnonymousInt1 == 225)
          {
            String str = paramAnonymousIntent.getStringExtra("enterprise_biz_name");
            long l = paramAnonymousIntent.getLongExtra("key_biz_chat_id", -1L);
            m.a(this.HMO, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).IN())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.br.d.a(parama.HZF, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final com.tencent.mm.ui.chatting.d.a parama, List<bo> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.HZF.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = f.dX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).IP();
    boolean bool2;
    int i;
    if (HMM.HMS)
    {
      bool2 = j.hH(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          ac.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          HMM.HMK = new LinkedList(paramList);
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
            m.a(this.Hit, parama);
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
            bo localbo = (bo)((Iterator)localObject).next();
            if ((!localbo.isText()) && (!localbo.eZl()) && (!localbo.eZm()) && (!localbo.cKP()) && (!j.aX(localbo)))
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
  
  public static pw cj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    pw localpw = new pw();
    localpw.dsN.type = 6;
    localpw.dsN.dsS = HMM.HMK;
    localpw.dsN.toUser = paramString;
    localpw.dsN.dsT = HMM.dsT;
    localpw.dsN.context = paramContext;
    com.tencent.mm.sdk.b.a.GpY.l(localpw);
    HMM.dsm = localpw.dsO.dsm;
    HMM.HML = localpw.dsO.dsV;
    AppMethodBeat.o(34479);
    return localpw;
  }
  
  static final class a
  {
    boolean HJB;
    List<bo> HMK;
    com.tencent.mm.protocal.b.a.d HML;
    boolean HMS;
    String dsT;
    cs dsm;
  }
  
  static final class b
    implements bd.a
  {
    private m.a HMT;
    private com.tencent.mm.ui.chatting.d.a cLy;
    private Context context;
    private String hxt;
    private long nxq;
    private boolean qKh;
    
    public b(com.tencent.mm.ui.chatting.d.a parama, Context paramContext, String paramString, long paramLong, m.a parama1)
    {
      AppMethodBeat.i(34470);
      this.cLy = parama;
      this.context = paramContext;
      this.hxt = paramString;
      this.nxq = paramLong;
      this.HMT = parama1;
      this.qKh = f.so(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, bo parambo, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (parambo.isText())
      {
        j.a(paramContext, paramString, parambo, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambo.eZm())
      {
        j.b(paramContext, paramString, parambo);
        AppMethodBeat.o(34472);
        return;
      }
      if ((parambo.crt()) && (!this.qKh))
      {
        j.c(paramContext, paramString, parambo);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambo.cKP())
      {
        j.c(paramContext, paramString, parambo, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((parambo.fbC()) || (parambo.fbD())) && (!this.qKh))
      {
        if (!j.aP(parambo))
        {
          j.a(paramContext, paramString, parambo);
          AppMethodBeat.o(34472);
        }
      }
      else if (parambo.cKN())
      {
        if ((this.qKh) && (!j.aX(parambo)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.aY(parambo))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (parambo.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (j.be(parambo))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!j.aR(parambo)) {
          j.b(paramContext, paramString, parambo, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void flc()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.HMT.HMK.iterator();
      while (localIterator.hasNext())
      {
        bo localbo = (bo)localIterator.next();
        a(this.context, localbo, this.HMT.HJB, this.hxt);
      }
      AppMethodBeat.o(34473);
    }
    
    private void fld()
    {
      AppMethodBeat.i(34474);
      m.cj(this.context, this.hxt);
      pw localpw = new pw();
      localpw.dsN.type = 5;
      localpw.dsN.dsS = this.HMT.HMK;
      localpw.dsN.toUser = this.hxt;
      localpw.dsN.dsT = this.HMT.dsT;
      localpw.dsN.context = this.context;
      localpw.dsN.dsm = this.HMT.dsm;
      localpw.dsN.dsV = this.HMT.HML;
      com.tencent.mm.sdk.b.a.GpY.l(localpw);
      AppMethodBeat.o(34474);
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(34471);
      if (this.qKh)
      {
        com.tencent.mm.al.a.c localc = af.aCY().bd(this.nxq);
        synchronized (com.tencent.mm.al.a.e.hzq)
        {
          String str = com.tencent.mm.al.a.e.TG();
          com.tencent.mm.al.a.e.d(localc);
          if (this.HMT.HMS)
          {
            flc();
            com.tencent.mm.al.a.e.Bw(str);
            AppMethodBeat.o(34471);
            return true;
          }
          fld();
        }
      }
      if (this.HMT.HMS) {
        flc();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        fld();
      }
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(34475);
      if (m.flb() != null) {
        m.flb().dismiss();
      }
      b.a(this.context, this.cLy.findViewById(2131302320), this.context.getString(2131759420), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */