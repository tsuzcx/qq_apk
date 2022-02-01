package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.i;
import com.tencent.mm.by.c.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  private static com.tencent.mm.ui.base.s WzE = null;
  private static a WzY;
  
  public static void a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(34480);
    Activity localActivity = parama.WQv.getContext();
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(R.l.app_tip);
      WzE = h.a(localActivity, localActivity.getString(R.l.eSl), false, null);
      com.tencent.mm.ui.chatting.d.n.WIm.add(new b(parama, localActivity, paramString, paramLong, WzY));
    }
    ((l)parama.bC(l.class)).hOR();
    AppMethodBeat.o(34480);
  }
  
  public static void a(final a parama, List<ca> paramList, boolean paramBoolean, final com.tencent.mm.ui.chatting.d.n paramn, final as paramas)
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
    WzY = (a)localObject;
    ((a)localObject).WzW = new LinkedList(paramList);
    WzY.Wwx = paramBoolean;
    WzY.from = paramas.field_username;
    WzY.WAf = true;
    final Activity localActivity = parama.WQv.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34476);
      return;
    }
    m localm = new m(localActivity);
    localm.ODW = new q.b()
    {
      public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34461);
        a.b.C(paramAnonymousImageView, paramAnonymousMenuItem.getTitle());
        AppMethodBeat.o(34461);
      }
    };
    localm.ODX = new n.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.q.u(localActivity, "com.tencent.wework")) {}
    for (localObject = k.hME();; localObject = k.hMD())
    {
      localm.ODT = new n.3((List)localObject);
      localm.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34467);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (k.kb(this.WzQ))
            {
              h.a(localActivity, localActivity.getString(R.l.eAr), "", localActivity.getString(R.l.emp), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.kc(this.WzQ))
            {
              h.a(localActivity, localActivity.getString(R.l.eAs), "", localActivity.getString(R.l.emp), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(34467);
              return;
            }
            if (k.ka(this.WzQ))
            {
              h.a(localActivity, localActivity.getString(R.l.eAt), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
            }
            if ((o.a(parama, this.WzQ, paramas)) && (paramn != null)) {
              paramn.hOR();
            }
            AppMethodBeat.o(34467);
            return;
          }
          if (k.kb(this.WzQ))
          {
            h.a(localActivity, localActivity.getString(R.l.eAr), "", localActivity.getString(R.l.emp), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          if (k.kc(this.WzQ))
          {
            h.a(localActivity, localActivity.getString(R.l.eAs), "", localActivity.getString(R.l.emp), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(34467);
            return;
          }
          Object localObject = this.WzQ;
          if (localObject == null)
          {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label390;
            break label390;
          }
          label333:
          ca localca;
          label390:
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!k.ka(this.WzQ))) {
                break;
              }
              h.a(localActivity, localActivity.getString(R.l.eAt), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(34467);
              return;
              localIterator = ((List)localObject).iterator();
            } while (!localIterator.hasNext());
            localca = (ca)localIterator.next();
          } while (localca.field_isSend == 1);
          if (localca.hwG()) {
            if (localca.field_msgId <= 0L) {
              break label902;
            }
          }
          label900:
          label902:
          for (localObject = com.tencent.mm.ay.q.bmh().D(localca.field_talker, localca.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.ay.g)localObject).localId <= 0L)) && (localca.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.ay.q.bmh().C(localca.field_talker, localca.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.ay.g)localObject).offset >= ((com.tencent.mm.ay.g)localObject).lAW) && (((com.tencent.mm.ay.g)localObject).lAW != 0))) {
                break label900;
              }
              paramAnonymousInt = 1;
              break label333;
              if (localca.dlR())
              {
                localObject = com.tencent.mm.modelvideo.s.bqB().XN(localca.field_imgPath);
                if ((localObject == null) || (((w)localObject).status == 199) || (((w)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label333;
              }
              if (localca.dlT())
              {
                localObject = y.Yk(localca.field_imgPath);
                if ((localObject == null) || (((w)localObject).status == 199) || (((w)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label333;
              }
              if (!localca.hzC()) {
                break;
              }
              if (!k.bB(localca))
              {
                paramAnonymousInt = 1;
                break label333;
              }
              paramAnonymousInt = 0;
              break label333;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (com.tencent.mm.ao.g.UA((String)localObject))
              {
                if (this.WzQ.size() <= 1)
                {
                  n.hMJ().WAf = true;
                  n.a((String)localObject, parama, this.WzQ);
                  AppMethodBeat.o(34467);
                  return;
                }
                paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
                paramAnonymousMenuItem.ODT = new q.f()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                  {
                    AppMethodBeat.i(34464);
                    paramAnonymous2o.mn(0, R.l.eMh);
                    paramAnonymous2o.mn(1, R.l.eMi);
                    AppMethodBeat.o(34464);
                  }
                };
                paramAnonymousMenuItem.ODU = new q.g()
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
                      n.hMJ().WAf = true;
                      n.a(this.iXL, n.4.this.WAa, n.4.this.WzQ);
                      AppMethodBeat.o(34465);
                      return;
                      n.hMJ().WAf = false;
                      n.a(this.iXL, n.4.this.WAa, n.4.this.WzQ);
                    }
                  }
                };
                paramAnonymousMenuItem.eik();
                AppMethodBeat.o(34467);
                return;
              }
              if (k.jY(this.WzQ))
              {
                localObject = localActivity.getString(R.l.eHZ);
                h.a(localActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(34466);
                    paramAnonymous2DialogInterface = n.4.this.WzQ;
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
                      if (n.4.this.WAc != null) {
                        n.4.this.WAc.hOR();
                      }
                      AppMethodBeat.o(34466);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label33;
                      }
                      ca localca = (ca)paramAnonymous2DialogInterface.next();
                      if (k.bF(localca)) {
                        break label33;
                      }
                      if ((localca.hwF()) || (k.bA(localca)) || (localca.hzy()) || (k.bC(localca)) || (k.bD(localca)) || (localca.getType() == -1879048186) || (k.bL(localca)) || (k.bE(localca)) || (k.bK(localca)) || (k.bQ(localca)) || (k.bG(localca))) {
                        break;
                      }
                    }
                    label189:
                    paramAnonymous2DialogInterface = n.4.this.val$context;
                    n.4.this.val$context.getString(R.l.app_tip);
                    n.e(h.a(paramAnonymous2DialogInterface, n.4.this.val$context.getString(R.l.eSl), false, null));
                    com.tencent.mm.ui.chatting.d.n.WIm.add(new n.b(n.4.this.WAa, n.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, n.hMJ()));
                    if (n.4.this.WAc != null) {
                      n.4.this.WAc.hOR();
                    }
                    AppMethodBeat.o(34466);
                  }
                }, null);
                AppMethodBeat.o(34467);
                return;
              }
              localObject = localActivity;
              localActivity.getString(R.l.app_tip);
              n.e(h.a((Context)localObject, localActivity.getString(R.l.eSl), false, null));
              com.tencent.mm.ui.chatting.d.n.WIm.add(new n.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, n.hMJ()));
              if (paramn != null) {
                paramn.hOR();
              }
              AppMethodBeat.o(34467);
              return;
            }
            break label390;
          }
        }
      };
      localm.hYu();
      AppMethodBeat.o(34476);
      return;
    }
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(34478);
    Object localObject = com.tencent.mm.ao.g.gu(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).YZ())
    {
      localObject = new Intent(parama.WQv.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", WzY.WAf);
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
            n.a(this.WAa, str, l);
          }
          AppMethodBeat.o(34469);
        }
      });
      AppMethodBeat.o(34478);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).YX())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.by.c.a(parama.WQv, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(34478);
  }
  
  public static void a(String paramString, final a parama, List<ca> paramList)
  {
    AppMethodBeat.i(34477);
    Activity localActivity = parama.WQv.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    Object localObject = com.tencent.mm.ao.g.gu(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(34477);
      return;
    }
    boolean bool1 = ((com.tencent.mm.api.c)localObject).YZ();
    boolean bool2;
    int i;
    if (WzY.WAf)
    {
      bool2 = k.jY(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          WzY.WzW = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label268;
          }
          paramList = localActivity.getString(R.l.eCt);
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
            n.a(this.VTL, parama);
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
            if ((!localca.hwH()) && (!localca.hwF()) && (!localca.hwG()) && (!localca.erm()) && (!k.bJ(localca)))
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
        paramList = localActivity.getString(R.l.eCu);
        continue;
      }
      a(paramString, parama);
      AppMethodBeat.o(34477);
      return;
      label268:
      paramList = null;
    }
  }
  
  public static sc cT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(34479);
    sc localsc = new sc();
    localsc.fRw.type = 6;
    localsc.fRw.fRB = WzY.WzW;
    localsc.fRw.toUser = paramString;
    localsc.fRw.from = WzY.from;
    localsc.fRw.context = paramContext;
    EventCenter.instance.publish(localsc);
    WzY.fQJ = localsc.fRx.fQJ;
    WzY.WzX = localsc.fRx.fRD;
    AppMethodBeat.o(34479);
    return localsc;
  }
  
  static final class a
  {
    boolean WAf;
    boolean Wwx;
    List<ca> WzW;
    com.tencent.mm.protocal.b.a.d WzX;
    dd fQJ;
    String from;
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private n.a WAg;
    private Context context;
    private a fgR;
    private String lEm;
    private long syu;
    private boolean wIf;
    
    public b(a parama, Context paramContext, String paramString, long paramLong, n.a parama1)
    {
      AppMethodBeat.i(34470);
      this.fgR = parama;
      this.context = paramContext;
      this.lEm = paramString;
      this.syu = paramLong;
      this.WAg = parama1;
      this.wIf = com.tencent.mm.ao.g.KI(paramString);
      AppMethodBeat.o(34470);
    }
    
    private void a(Context paramContext, ca paramca, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(34472);
      if (paramca.hwH())
      {
        k.a(paramContext, paramString, paramca, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramca.hwG())
      {
        k.b(paramContext, paramString, paramca);
        AppMethodBeat.o(34472);
        return;
      }
      if ((paramca.dlR()) && (!this.wIf))
      {
        k.c(paramContext, paramString, paramca);
        AppMethodBeat.o(34472);
        return;
      }
      if (paramca.erm())
      {
        k.c(paramContext, paramString, paramca, paramBoolean);
        AppMethodBeat.o(34472);
        return;
      }
      if (((paramca.hzB()) || (paramca.hzC())) && (!this.wIf))
      {
        if (!k.bA(paramca))
        {
          k.a(paramContext, paramString, paramca);
          AppMethodBeat.o(34472);
        }
      }
      else if (paramca.erk())
      {
        if ((this.wIf) && (!k.bJ(paramca)))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.bK(paramca))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (paramca.getType() == 318767153)
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (k.bQ(paramca))
        {
          AppMethodBeat.o(34472);
          return;
        }
        if (!k.bC(paramca)) {
          k.b(paramContext, paramString, paramca, paramBoolean);
        }
      }
      AppMethodBeat.o(34472);
    }
    
    private void hML()
    {
      AppMethodBeat.i(34473);
      Iterator localIterator = this.WAg.WzW.iterator();
      while (localIterator.hasNext())
      {
        ca localca = (ca)localIterator.next();
        a(this.context, localca, this.WAg.Wwx, this.lEm);
      }
      AppMethodBeat.o(34473);
    }
    
    private void hMM()
    {
      AppMethodBeat.i(34474);
      n.cT(this.context, this.lEm);
      sc localsc = new sc();
      localsc.fRw.type = 5;
      localsc.fRw.fRB = this.WAg.WzW;
      localsc.fRw.toUser = this.lEm;
      localsc.fRw.from = this.WAg.from;
      localsc.fRw.context = this.context;
      localsc.fRw.fQJ = this.WAg.fQJ;
      localsc.fRw.fRD = this.WAg.WzX;
      EventCenter.instance.publish(localsc);
      AppMethodBeat.o(34474);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34471);
      if (this.wIf)
      {
        com.tencent.mm.ao.a.c localc = af.bjx().bF(this.syu);
        synchronized (com.tencent.mm.ao.a.e.lGg)
        {
          String str = com.tencent.mm.ao.a.e.apc();
          com.tencent.mm.ao.a.e.d(localc);
          if (this.WAg.WAf)
          {
            hML();
            com.tencent.mm.ao.a.e.Vh(str);
            AppMethodBeat.o(34471);
            return true;
          }
          hMM();
        }
      }
      if (this.WAg.WAf) {
        hML();
      }
      for (;;)
      {
        AppMethodBeat.o(34471);
        return true;
        hMM();
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34475);
      if (n.hMK() != null) {
        n.hMK().dismiss();
      }
      b.a(this.context, this.fgR.findViewById(R.h.mm_content_fl), this.context.getString(R.l.finish_sent), null);
      AppMethodBeat.o(34475);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */