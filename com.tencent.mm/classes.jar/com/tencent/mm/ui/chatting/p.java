package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c.a;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.component.api.n;
import com.tencent.mm.ui.chatting.component.o;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
{
  private static w aegZ = null;
  private static a aehu;
  
  public static void a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.aezO.getContext();
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(R.l.app_tip);
      aegZ = k.a(localActivity, localActivity.getString(R.l.gUV), false, null);
      o.aeqs.add(new b(parama, localActivity, paramString, paramLong, aehu));
    }
    ((n)parama.cm(n.class)).jrH();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final a parama, List<cc> paramList, boolean paramBoolean, final o paramo, final au paramau)
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
    aehu = (a)localObject;
    ((a)localObject).aehr = new LinkedList(paramList);
    aehu.aedO = paramBoolean;
    aehu.from = paramau.field_username;
    aehu.aehB = true;
    final Activity localActivity = parama.aezO.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    l locall = new l(localActivity);
    locall.Vti = new p.1();
    locall.Vtj = new p.2(localActivity);
    if (u.y(localActivity, "com.tencent.wework")) {}
    for (localObject = m.jpf();; localObject = m.jpe())
    {
      locall.Vtg = new p.3((List)localObject);
      locall.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (m.nq(p.this))
            {
              k.a(localActivity, localActivity.getString(R.l.gDk), "", localActivity.getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (m.ns(p.this))
            {
              k.a(localActivity, localActivity.getString(R.l.gDl), "", localActivity.getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (m.np(p.this))
            {
              k.a(localActivity, localActivity.getString(R.l.gDm), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((q.a(parama, p.this, paramau)) && (paramo != null)) {
              paramo.jrH();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (m.nq(p.this))
          {
            k.a(localActivity, localActivity.getString(R.l.gDk), "", localActivity.getString(R.l.gps), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (m.ns(p.this))
          {
            k.a(localActivity, localActivity.getString(R.l.gDl), "", localActivity.getString(R.l.gps), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = p.this;
          if (localObject == null)
          {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label390;
            break label390;
          }
          label333:
          cc localcc;
          label390:
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!m.np(p.this))) {
                break;
              }
              k.a(localActivity, localActivity.getString(R.l.gDm), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
              localIterator = ((List)localObject).iterator();
            } while (!localIterator.hasNext());
            localcc = (cc)localIterator.next();
          } while (localcc.field_isSend == 1);
          if (localcc.iYk()) {
            if (localcc.field_msgId <= 0L) {
              break label902;
            }
          }
          label900:
          label902:
          for (localObject = r.bKa().H(localcc.field_talker, localcc.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((h)localObject).localId <= 0L)) && (localcc.field_msgSvrId > 0L)) {
              localObject = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((h)localObject).offset >= ((h)localObject).osy) && (((h)localObject).osy != 0))) {
                break label900;
              }
              paramAnonymousInt = 1;
              break label333;
              if (localcc.dSH())
              {
                localObject = v.bOh().PR(localcc.field_imgPath);
                if ((localObject == null) || (((z)localObject).status == 199) || (((z)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label333;
              }
              if (localcc.dSJ())
              {
                localObject = ab.Qo(localcc.field_imgPath);
                if ((localObject == null) || (((z)localObject).status == 199) || (((z)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label333;
              }
              if (!localcc.jbH()) {
                break;
              }
              if (!m.bN(localcc))
              {
                paramAnonymousInt = 1;
                break label333;
              }
              paramAnonymousInt = 0;
              break label333;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (g.Mz((String)localObject))
              {
                if (p.this.size() <= 1)
                {
                  p.jpl().aehB = true;
                  p.a((String)localObject, parama, p.this);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new f(localActivity, 1, false);
                paramAnonymousMenuItem.Vtg = new u.g()
                {
                  public final void onCreateMMMenu(s paramAnonymous2s)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2s.oh(0, R.l.gOf);
                    paramAnonymous2s.oh(1, R.l.gOg);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.GAC = new u.i()
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
                      p.jpl().aehB = true;
                      p.a(this.lzH, p.4.this.aehw, p.this);
                      AppMethodBeat.o(34465);
                      return;
                      p.jpl().aehB = false;
                      p.a(this.lzH, p.4.this.aehw, p.this);
                    }
                  }
                };
                paramAnonymousMenuItem.dDn();
                AppMethodBeat.o(34467);
                return;
              }
              if (m.nn(p.this))
              {
                localObject = localActivity.getString(R.l.gJG);
                k.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = p.this;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      Log.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label33:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label189;
                      }
                      Log.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (p.4.this.aehy != null) {
                        p.4.this.aehy.jrH();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      cc localcc = (cc)paramAnonymous2DialogInterface.next();
                      if (m.bR(localcc)) {
                        break label33;
                      }
                      if ((localcc.iYj()) || (m.bM(localcc)) || (localcc.jbB()) || (m.bO(localcc)) || (m.bP(localcc)) || (localcc.getType() == -1879048186) || (m.bY(localcc)) || (m.bQ(localcc)) || (m.bX(localcc)) || (m.ce(localcc)) || (m.bT(localcc))) {
                        break;
                      }
                    }
                    label189:
                    paramAnonymous2DialogInterface = p.4.this.val$context;
                    p.4.this.val$context.getString(R.l.app_tip);
                    p.g(k.a(paramAnonymous2DialogInterface, p.4.this.val$context.getString(R.l.gUV), false, null));
                    o.aeqs.add(new p.b(p.4.this.aehw, p.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, p.jpl()));
                    if (p.4.this.aehy != null) {
                      p.4.this.aehy.jrH();
                    }
                    AppMethodBeat.o(34466);
                  }
                }, null);
                AppMethodBeat.o(34467);
                return;
              }
              localObject = localActivity;
              localActivity.getString(R.l.app_tip);
              p.g(k.a((Context)localObject, localActivity.getString(R.l.gUV), false, null));
              o.aeqs.add(new p.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, p.jpl()));
              if (paramo != null) {
                paramo.jrH();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label390;
          }
        }
      };
      locall.jDd();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = g.hU(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).aAR())
    {
      localObject = new Intent(parama.aezO.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", aehu.aehB);
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
            p.a(p.this, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).aAP())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.br.c.a(parama.aezO, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final a parama, List<cc> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.aezO.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = g.hU(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).aAR();
    boolean bool2;
    int i;
    if (aehu.aehB)
    {
      bool2 = m.nn(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          aehu.aehr = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label268;
          }
          paramList = localActivity.getString(R.l.enterprise_invalid_chat_msg_warning);
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        k.a(localActivity, paramList, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34468);
            p.a(p.this, parama);
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
            cc localcc = (cc)((Iterator)localObject).next();
            if ((!localcc.iYl()) && (!localcc.iYj()) && (!localcc.iYk()) && (!localcc.fxT()) && (!m.bW(localcc)))
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
        paramList = localActivity.getString(R.l.enterprise_invalid_msg_warning);
        continue;
      }
      a(paramString, parama);
      AppMethodBeat.o(34477);
      return;
      label268:
      paramList = null;
    }
  }
  
  public static tr dd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    tr localtr = new tr();
    localtr.hXt.type = 6;
    localtr.hXt.hXy = aehu.aehr;
    localtr.hXt.toUser = paramString;
    localtr.hXt.from = aehu.from;
    localtr.hXt.context = paramContext;
    localtr.publish();
    aehu.hWG = localtr.hXu.hWG;
    aehu.aeht = localtr.hXu.hXA;
    AppMethodBeat.o(34479);
    return localtr;
  }
  
  static final class a
  {
    boolean aedO;
    boolean aehB;
    List<cc> aehr;
    com.tencent.mm.protocal.b.a.d aeht;
    String from;
    dn hWG;
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private boolean Aet;
    private p.a aehC;
    private Context context;
    private a hlc;
    private String ovT;
    private long vEb;
    
    public b(a parama, Context paramContext, String paramString, long paramLong, p.a parama1)
    {
      AppMethodBeat.i(34470);
      this.hlc = parama;
      this.context = paramContext;
      this.ovT = paramString;
      this.vEb = paramLong;
      this.aehC = parama1;
      this.Aet = g.Dn(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, cc paramcc, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (paramcc.iYl())
      {
        m.a(paramContext, paramString, paramcc, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramcc.iYk())
      {
        m.b(paramContext, paramString, paramcc);
        AppMethodBeat.o(34472);
        return;
      }
      if ((paramcc.dSH()) && (!this.Aet))
      {
        m.c(paramContext, paramString, paramcc);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramcc.fxT())
      {
        m.c(paramContext, paramString, paramcc, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((paramcc.jbG()) || (paramcc.jbH())) && (!this.Aet))
      {
        if (!m.bM(paramcc))
        {
          m.a(paramContext, paramString, paramcc);
          AppMethodBeat.o(34472);
        }
      }
      else if (paramcc.fxR())
      {
        if ((this.Aet) && (!m.bW(paramcc)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (m.bX(paramcc))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (paramcc.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (m.ce(paramcc))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!m.bO(paramcc)) {
          m.b(paramContext, paramString, paramcc, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void jpn()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.aehC.aehr.iterator();
      while (localIterator.hasNext())
      {
        cc localcc = (cc)localIterator.next();
        a(this.context, localcc, this.aehC.aedO, this.ovT);
      }
      AppMethodBeat.o(34473);
    }
    
    private void jpo()
    {
      AppMethodBeat.i(34474);
      p.dd(this.context, this.ovT);
      tr localtr = new tr();
      localtr.hXt.type = 5;
      localtr.hXt.hXy = this.aehC.aehr;
      localtr.hXt.toUser = this.ovT;
      localtr.hXt.from = this.aehC.from;
      localtr.hXt.context = this.context;
      localtr.hXt.hWG = this.aehC.hWG;
      localtr.hXt.hXA = this.aehC.aeht;
      localtr.publish();
      AppMethodBeat.o(34474);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34471);
      if (this.Aet)
      {
        com.tencent.mm.an.a.c localc = af.bHh().dW(this.vEb);
        if (localc == null)
        {
          k.cZ(this.context, this.context.getString(R.l.gzD));
          if (p.jpm() != null) {
            p.jpm().dismiss();
          }
          AppMethodBeat.o(34471);
          return true;
        }
        for (;;)
        {
          synchronized (e.oxN)
          {
            String str = e.bCQ();
            e.d(localc);
            if (this.aehC.aehB)
            {
              jpn();
              e.Ng(str);
            }
          }
          jpo();
        }
      }
      if (this.aehC.aehB) {
        jpn();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        jpo();
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34475);
      if (p.jpm() != null) {
        p.jpm().dismiss();
      }
      b.a(this.context, this.hlc.findViewById(R.h.mm_content_fl), this.context.getString(R.l.finish_sent), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */