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
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.d.m;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  private static p JUY = null;
  private static a JVt;
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.Kkd.getContext();
    if ((!bu.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131755906);
      JUY = h.b(localActivity, localActivity.getString(2131763073), false, null);
      m.KcB.c(new b(parama, localActivity, paramString, paramLong, JVt));
    }
    ((com.tencent.mm.ui.chatting.d.b.l)parama.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHt();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.e.a parama, List<bv> paramList, boolean paramBoolean, final m paramm, final an paraman)
  {
    AppMethodBeat.i(34476);
    if (parama == null)
    {
      ae.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      AppMethodBeat.o(34476);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      AppMethodBeat.o(34476);
      return;
    }
    Object localObject = new a((byte)0);
    JVt = (a)localObject;
    ((a)localObject).JVr = new LinkedList(paramList);
    JVt.JSi = paramBoolean;
    JVt.dFY = paraman.field_username;
    JVt.JVz = true;
    final Activity localActivity = parama.Kkd.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
    locall.LfW = new n.1();
    locall.LfX = new n.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.q.s(localActivity, "com.tencent.wework")) {}
    for (localObject = k.fFn();; localObject = k.fFm())
    {
      locall.LfS = new n.3((List)localObject);
      locall.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (k.ig(this.JVk))
            {
              h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.ih(this.JVk))
            {
              h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.jdMethod_if(this.JVk))
            {
              h.a(localActivity, localActivity.getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((o.a(parama, this.JVk, paraman)) && (paramm != null)) {
              paramm.fHt();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (k.ig(this.JVk))
          {
            h.a(localActivity, localActivity.getString(2131757937), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (k.ih(this.JVk))
          {
            h.a(localActivity, localActivity.getString(2131757938), "", localActivity.getString(2131755012), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.JVk;
          if (localObject == null)
          {
            ae.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label380;
            break label380;
          }
          label324:
          label380:
          bv localbv;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!k.jdMethod_if(this.JVk))) {
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
            localbv = (bv)localIterator.next();
          } while (localbv.field_isSend == 1);
          if (localbv.ftg()) {
            if (localbv.field_msgId <= 0L) {
              break label892;
            }
          }
          label890:
          label892:
          for (localObject = com.tencent.mm.av.q.aIX().G(localbv.field_talker, localbv.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.av.g)localObject).doE <= 0L)) && (localbv.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.av.q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).hPI) && (((com.tencent.mm.av.g)localObject).hPI != 0))) {
                break label890;
              }
              paramAnonymousInt = 1;
              break label324;
              if (localbv.cyG())
              {
                localObject = com.tencent.mm.modelvideo.o.aNh().HD(localbv.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (localbv.cyI())
              {
                localObject = u.Ia(localbv.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label324;
              }
              if (!localbv.fvH()) {
                break;
              }
              if (!k.aS(localbv))
              {
                paramAnonymousInt = 1;
                break label324;
              }
              paramAnonymousInt = 0;
              break label324;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (com.tencent.mm.al.g.Eq((String)localObject))
              {
                if (this.JVk.size() <= 1)
                {
                  n.fFs().JVz = true;
                  n.a((String)localObject, parama, this.JVk);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.LfS = new n.d()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2l.jM(0, 2131761385);
                    paramAnonymous2l.jM(1, 2131761386);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.LfT = new n.e()
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
                      n.fFs().JVz = true;
                      n.a(this.fOp, n.4.this.JVv, n.4.this.JVk);
                      AppMethodBeat.o(34465);
                      return;
                      n.fFs().JVz = false;
                      n.a(this.fOp, n.4.this.JVv, n.4.this.JVk);
                    }
                  }
                };
                paramAnonymousMenuItem.cPF();
                AppMethodBeat.o(34467);
                return;
              }
              if (k.id(this.JVk))
              {
                localObject = localActivity.getString(2131760348);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = n.4.this.JVk;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      ae.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label33:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label182;
                      }
                      ae.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (n.4.this.JVw != null) {
                        n.4.this.JVw.fHt();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      bv localbv = (bv)paramAnonymous2DialogInterface.next();
                      if (k.aW(localbv)) {
                        break label33;
                      }
                      if ((localbv.ftf()) || (k.aR(localbv)) || (localbv.fvE()) || (k.aT(localbv)) || (k.aU(localbv)) || (localbv.getType() == -1879048186) || (k.bb(localbv)) || (k.aV(localbv)) || (k.ba(localbv)) || (k.bg(localbv))) {
                        break;
                      }
                    }
                    label182:
                    paramAnonymous2DialogInterface = n.4.this.val$context;
                    n.4.this.val$context.getString(2131755906);
                    n.e(h.b(paramAnonymous2DialogInterface, n.4.this.val$context.getString(2131763073), false, null));
                    m.KcB.c(new n.b(n.4.this.JVv, n.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, n.fFs()));
                    if (n.4.this.JVw != null) {
                      n.4.this.JVw.fHt();
                    }
                    AppMethodBeat.o(34466);
                  }
                }, null);
                AppMethodBeat.o(34467);
                return;
              }
              localObject = localActivity;
              localActivity.getString(2131755906);
              n.e(h.b((Context)localObject, localActivity.getString(2131763073), false, null));
              m.KcB.c(new n.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, n.fFs()));
              if (paramm != null) {
                paramm.fHt();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label380;
          }
        }
      };
      locall.fOP();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = com.tencent.mm.al.g.eX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Kx())
    {
      localObject = new Intent(parama.Kkd.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", JVt.JVz);
      parama.a((Intent)localObject, 225, new d.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(34469);
          if (paramAnonymousIntent == null)
          {
            ae.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
            AppMethodBeat.o(34469);
            return;
          }
          if (paramAnonymousInt1 == 225)
          {
            String str = paramAnonymousIntent.getStringExtra("enterprise_biz_name");
            long l = paramAnonymousIntent.getLongExtra("key_biz_chat_id", -1L);
            n.a(this.JVv, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Kv())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.br.d.a(parama.Kkd, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final com.tencent.mm.ui.chatting.e.a parama, List<bv> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.Kkd.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = com.tencent.mm.al.g.eX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).Kx();
    boolean bool2;
    int i;
    if (JVt.JVz)
    {
      bool2 = k.id(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          ae.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          JVt.JVr = new LinkedList(paramList);
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
            n.a(this.Jqs, parama);
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
            bv localbv = (bv)((Iterator)localObject).next();
            if ((!localbv.isText()) && (!localbv.ftf()) && (!localbv.ftg()) && (!localbv.cVJ()) && (!k.aZ(localbv)))
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
  
  public static qi cp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    qi localqi = new qi();
    localqi.dFS.type = 6;
    localqi.dFS.dFX = JVt.JVr;
    localqi.dFS.toUser = paramString;
    localqi.dFS.dFY = JVt.dFY;
    localqi.dFS.context = paramContext;
    com.tencent.mm.sdk.b.a.IvT.l(localqi);
    JVt.dFl = localqi.dFT.dFl;
    JVt.JVs = localqi.dFT.dGa;
    AppMethodBeat.o(34479);
    return localqi;
  }
  
  static final class a
  {
    boolean JSi;
    List<bv> JVr;
    com.tencent.mm.protocal.b.a.d JVs;
    boolean JVz;
    String dFY;
    cw dFl;
  }
  
  static final class b
    implements bf.a
  {
    private n.a JVA;
    private com.tencent.mm.ui.chatting.e.a cXJ;
    private Context context;
    private String hSG;
    private long oex;
    private boolean rCv;
    
    public b(com.tencent.mm.ui.chatting.e.a parama, Context paramContext, String paramString, long paramLong, n.a parama1)
    {
      AppMethodBeat.i(34470);
      this.cXJ = parama;
      this.context = paramContext;
      this.hSG = paramString;
      this.oex = paramLong;
      this.JVA = parama1;
      this.rCv = com.tencent.mm.al.g.vz(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, bv parambv, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (parambv.isText())
      {
        k.a(paramContext, paramString, parambv, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambv.ftg())
      {
        k.b(paramContext, paramString, parambv);
        AppMethodBeat.o(34472);
        return;
      }
      if ((parambv.cyG()) && (!this.rCv))
      {
        k.c(paramContext, paramString, parambv);
        AppMethodBeat.o(34472);
        return;
      }
      if (parambv.cVJ())
      {
        k.c(paramContext, paramString, parambv, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((parambv.fvG()) || (parambv.fvH())) && (!this.rCv))
      {
        if (!k.aR(parambv))
        {
          k.a(paramContext, paramString, parambv);
          AppMethodBeat.o(34472);
        }
      }
      else if (parambv.cVH())
      {
        if ((this.rCv) && (!k.aZ(parambv)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.ba(parambv))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (parambv.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.bg(parambv))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!k.aT(parambv)) {
          k.b(paramContext, paramString, parambv, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void fFu()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.JVA.JVr.iterator();
      while (localIterator.hasNext())
      {
        bv localbv = (bv)localIterator.next();
        a(this.context, localbv, this.JVA.JSi, this.hSG);
      }
      AppMethodBeat.o(34473);
    }
    
    private void fFv()
    {
      AppMethodBeat.i(34474);
      n.cp(this.context, this.hSG);
      qi localqi = new qi();
      localqi.dFS.type = 5;
      localqi.dFS.dFX = this.JVA.JVr;
      localqi.dFS.toUser = this.hSG;
      localqi.dFS.dFY = this.JVA.dFY;
      localqi.dFS.context = this.context;
      localqi.dFS.dFl = this.JVA.dFl;
      localqi.dFS.dGa = this.JVA.JVs;
      com.tencent.mm.sdk.b.a.IvT.l(localqi);
      AppMethodBeat.o(34474);
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(34471);
      if (this.rCv)
      {
        com.tencent.mm.al.a.c localc = ag.aGr().bd(this.oex);
        synchronized (com.tencent.mm.al.a.e.hUD)
        {
          String str = com.tencent.mm.al.a.e.We();
          com.tencent.mm.al.a.e.d(localc);
          if (this.JVA.JVz)
          {
            fFu();
            com.tencent.mm.al.a.e.EX(str);
            AppMethodBeat.o(34471);
            return true;
          }
          fFv();
        }
      }
      if (this.JVA.JVz) {
        fFu();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        fFv();
      }
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(34475);
      if (n.fFt() != null) {
        n.fFt().dismiss();
      }
      b.a(this.context, this.cXJ.findViewById(2131302320), this.context.getString(2131759420), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */