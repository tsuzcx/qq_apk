package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.e.d;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements ax
{
  private f EwU;
  private a EwV;
  private aw EwW;
  private com.tencent.mm.sdk.b.c EwX;
  private x EwY;
  private cd.a nEJ;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.EwU = new f();
    this.nEJ = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)bw.M(z.a(paramAnonymousa.gqE.Fvk), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bt.isNullOrNil(str)) {
          ad.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        so localso = new so();
        localso.dHd.dHe = str;
        localso.dHd.type = 1;
        com.tencent.mm.sdk.b.a.IbL.l(localso);
        paramAnonymousa.gqE.Fvo = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.EwW = new aw()
    {
      public final void aBH()
      {
        AppMethodBeat.i(30184);
        ba.aBQ();
        if (com.tencent.mm.model.c.aiI()) {
          g.eWk();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.EwX = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final so paramAnonymousso)
      {
        AppMethodBeat.i(30186);
        if ((paramAnonymousso != null) && ((paramAnonymousso instanceof so)))
        {
          final d locald = new d(paramAnonymousso.dHd.dHe);
          paramAnonymousso = new com.tencent.mm.al.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(30185);
              ba.aiU().b(971, this);
              aia localaia = (aia)locald.hWL.hNL.hNQ;
              ad.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              Object localObject1;
              StringBuilder localStringBuilder;
              Object localObject3;
              Cursor localCursor;
              Object localObject2;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                if (localaia.Gfo == null) {
                  break label1051;
                }
                paramAnonymous2String = new Intent();
                paramAnonymous2String.putExtra("intent.key.login.url", paramAnonymousso.dHd.dHe);
                paramAnonymous2String.putExtra("intent.key.type", 0);
                paramAnonymous2String.putExtra("intent.key.icon.type", localaia.Gfo.Gfk);
                paramAnonymous2String.putExtra("intent.key.ok.string", localaia.Gfo.Gfy);
                paramAnonymous2String.putExtra("intent.key.cancel.string", localaia.Gfo.Gfz);
                paramAnonymous2String.putExtra("intent.key.title.string", localaia.Gfo.Gfl);
                paramAnonymous2String.putExtra("intent.key.content.string", localaia.Gfo.GfD);
                paramAnonymous2String.putExtra("intent.key.login.client.version", localaia.Gfs);
                paramAnonymous2String.putExtra("intent.key.function.control", localaia.Gft);
                paramAnonymous2String.putExtra("intent.key.usage.link", localaia.Gfo.GfE);
                localObject1 = localaia.Gfo.Gfl;
                localStringBuilder = new StringBuilder();
                localObject3 = null;
                localCursor = null;
                localObject2 = localCursor;
                paramAnonymous2n = localObject3;
              }
              for (;;)
              {
                try
                {
                  ba.aBQ();
                  localObject2 = localCursor;
                  paramAnonymous2n = localObject3;
                  localCursor = com.tencent.mm.model.c.azv().a(w.hFd, null, com.tencent.mm.p.a.gfl, true);
                  if (localCursor != null)
                  {
                    localObject2 = localCursor;
                    paramAnonymous2n = localCursor;
                    if (localCursor.getCount() < localaia.Gfo.GfA)
                    {
                      localObject2 = localCursor;
                      paramAnonymous2n = localCursor;
                      paramAnonymous2Int1 = localCursor.getCount();
                      localObject2 = localCursor;
                      paramAnonymous2n = localCursor;
                      int i = localCursor.getColumnIndex("username");
                      paramAnonymous2Int2 = 0;
                      if (paramAnonymous2Int2 < paramAnonymous2Int1)
                      {
                        localObject2 = localCursor;
                        paramAnonymous2n = localCursor;
                        if (!localCursor.moveToPosition(paramAnonymous2Int2)) {
                          break label1059;
                        }
                        localObject2 = localCursor;
                        paramAnonymous2n = localCursor;
                        localStringBuilder.append(localCursor.getString(i));
                        if (paramAnonymous2Int2 >= paramAnonymous2Int1 - 1) {
                          break label1059;
                        }
                        localObject2 = localCursor;
                        paramAnonymous2n = localCursor;
                        localStringBuilder.append(",");
                        break label1059;
                      }
                    }
                    else
                    {
                      localObject2 = localCursor;
                      paramAnonymous2n = localCursor;
                      paramAnonymous2Int1 = localaia.Gfo.GfA;
                      continue;
                    }
                  }
                  localObject2 = localCursor;
                  paramAnonymous2n = localCursor;
                  paramAnonymous2String.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
                  if (localCursor == null) {
                    break label790;
                  }
                  localCursor.close();
                  paramAnonymous2n = paramAnonymous2String;
                  paramAnonymous2String = (String)localObject1;
                }
                catch (Exception localException)
                {
                  paramAnonymous2n = (n)localObject2;
                  ad.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
                  if (localObject2 == null) {
                    break label790;
                  }
                  ((Cursor)localObject2).close();
                  paramAnonymous2n = paramAnonymous2String;
                  paramAnonymous2String = (String)localObject1;
                  continue;
                }
                finally
                {
                  if (paramAnonymous2n == null) {
                    continue;
                  }
                  paramAnonymous2n.close();
                  AppMethodBeat.o(30185);
                }
                if (paramAnonymous2n != null)
                {
                  paramAnonymous2n.setFlags(268435456);
                  paramAnonymous2n.setClass(aj.getContext(), ExtDeviceWXLoginUI.class);
                  localObject1 = aj.getContext();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2n);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2n = new Intent(paramAnonymous2n);
                  paramAnonymous2n.setFlags(67108864);
                  if (paramAnonymousso.dHd.type == 1)
                  {
                    paramAnonymous2n = PendingIntent.getActivity(aj.getContext(), 0, paramAnonymous2n, 134217728);
                    paramAnonymous2String = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(aj.getContext().getString(2131755822)).g(paramAnonymous2String);
                    paramAnonymous2String.Hl = paramAnonymous2n;
                    paramAnonymous2String = paramAnonymous2String.build();
                    paramAnonymous2String.icon = com.tencent.mm.br.a.dwe();
                    paramAnonymous2String.flags |= 0x10;
                    paramAnonymous2String.sound = RingtoneManager.getDefaultUri(2);
                    ba.getNotification().notify(38, paramAnonymous2String);
                  }
                }
                AppMethodBeat.o(30185);
                return;
                label790:
                paramAnonymous2n = paramAnonymous2String;
                paramAnonymous2String = (String)localObject1;
                continue;
                if (paramAnonymous2Int2 == -1)
                {
                  if (localaia.Gfp != null)
                  {
                    paramAnonymous2n = new Intent();
                    paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymousso.dHd.dHe);
                    paramAnonymous2n.putExtra("intent.key.type", -1);
                    paramAnonymous2n.putExtra("intent.key.title.string", localaia.Gfp.Gfm);
                    paramAnonymous2n.putExtra("intent.key.icon.type", localaia.Gfp.Gfk);
                    paramAnonymous2n.putExtra("intent.key.ok.string", localaia.Gfp.Gfn);
                    paramAnonymous2n.putExtra("intent.key.content.string", localaia.Gfp.Gfl);
                    paramAnonymous2String = localaia.Gfp.Gfl;
                  }
                }
                else if ((paramAnonymous2Int2 == -2) && (localaia.Gfq != null))
                {
                  paramAnonymous2n = new Intent();
                  paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymousso.dHd.dHe);
                  paramAnonymous2n.putExtra("intent.key.type", -2);
                  paramAnonymous2n.putExtra("intent.key.title.string", localaia.Gfq.Gfm);
                  paramAnonymous2n.putExtra("intent.key.icon.type", localaia.Gfq.Gfk);
                  paramAnonymous2n.putExtra("intent.key.ok.string", localaia.Gfq.Gfn);
                  paramAnonymous2n.putExtra("intent.key.content.string", localaia.Gfq.Gfl);
                  paramAnonymous2String = localaia.Gfq.Gfl;
                  continue;
                }
                label1051:
                paramAnonymous2String = null;
                paramAnonymous2n = null;
                continue;
                label1059:
                paramAnonymous2Int2 += 1;
              }
            }
          };
          ba.aiU().a(971, paramAnonymousso);
          ba.aiU().a(locald, 0);
        }
        AppMethodBeat.o(30186);
        return false;
      }
    };
    this.EwY = new x() {};
    AppMethodBeat.o(30189);
  }
  
  public static g eWj()
  {
    AppMethodBeat.i(30190);
    ba.aBK();
    g localg2 = (g)ca.By("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      ba.aBK().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  static void eWk()
  {
    AppMethodBeat.i(30193);
    ba.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final a eWl()
  {
    AppMethodBeat.i(30194);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.EwV == null) {
      this.EwV = new a();
    }
    a locala = this.EwV;
    AppMethodBeat.o(30194);
    return locala;
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(30192);
    e.d.a(Integer.valueOf(51), this.EwU);
    ba.getSysCmdMsgExtension().a("pushloginurl", this.nEJ, true);
    ba.aBQ();
    com.tencent.mm.model.c.a(this.EwW);
    com.tencent.mm.sdk.b.a.IbL.c(this.EwX);
    this.EwV = null;
    aa.a(5, this.EwY);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    e.d.b(Integer.valueOf(51), this.EwU);
    ba.getSysCmdMsgExtension().b("pushloginurl", this.nEJ, true);
    ba.aBQ();
    com.tencent.mm.model.c.b(this.EwW);
    com.tencent.mm.sdk.b.a.IbL.d(this.EwX);
    eWk();
    if (this.EwV != null)
    {
      a locala = this.EwV;
      o.aMJ().a(locala);
      com.tencent.mm.kernel.g.aiU().b(221, locala);
    }
    aa.a(this.EwY);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */