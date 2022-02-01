package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements az
{
  private f EPq;
  private a EPr;
  private ay EPs;
  private com.tencent.mm.sdk.b.c EPt;
  private y EPu;
  private cf.a nKe;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.EPq = new f();
    this.nKe = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)bx.M(z.a(paramAnonymousa.gte.FNI), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bu.isNullOrNil(str)) {
          ae.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        sp localsp = new sp();
        localsp.dIj.dIk = str;
        localsp.dIj.type = 1;
        com.tencent.mm.sdk.b.a.IvT.l(localsp);
        paramAnonymousa.gte.FNM = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.EPs = new ay()
    {
      public final void aBX()
      {
        AppMethodBeat.i(30184);
        bc.aCg();
        if (com.tencent.mm.model.c.aiX()) {
          g.eZW();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.EPt = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final sp paramAnonymoussp)
      {
        AppMethodBeat.i(30186);
        if ((paramAnonymoussp != null) && ((paramAnonymoussp instanceof sp)))
        {
          final d locald = new d(paramAnonymoussp.dIj.dIk);
          paramAnonymoussp = new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(30185);
              bc.ajj().b(971, this);
              aik localaik = (aik)locald.hZD.hQE.hQJ;
              ae.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              Object localObject1;
              StringBuilder localStringBuilder;
              Object localObject3;
              Cursor localCursor;
              Object localObject2;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                if (localaik.GxW == null) {
                  break label1051;
                }
                paramAnonymous2String = new Intent();
                paramAnonymous2String.putExtra("intent.key.login.url", paramAnonymoussp.dIj.dIk);
                paramAnonymous2String.putExtra("intent.key.type", 0);
                paramAnonymous2String.putExtra("intent.key.icon.type", localaik.GxW.GxS);
                paramAnonymous2String.putExtra("intent.key.ok.string", localaik.GxW.Gyg);
                paramAnonymous2String.putExtra("intent.key.cancel.string", localaik.GxW.Gyh);
                paramAnonymous2String.putExtra("intent.key.title.string", localaik.GxW.GxT);
                paramAnonymous2String.putExtra("intent.key.content.string", localaik.GxW.Gyl);
                paramAnonymous2String.putExtra("intent.key.login.client.version", localaik.Gya);
                paramAnonymous2String.putExtra("intent.key.function.control", localaik.Gyb);
                paramAnonymous2String.putExtra("intent.key.usage.link", localaik.GxW.Gym);
                localObject1 = localaik.GxW.GxT;
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
                  bc.aCg();
                  localObject2 = localCursor;
                  paramAnonymous2n = localObject3;
                  localCursor = com.tencent.mm.model.c.azL().a(x.hHV, null, com.tencent.mm.o.a.ghD, true);
                  if (localCursor != null)
                  {
                    localObject2 = localCursor;
                    paramAnonymous2n = localCursor;
                    if (localCursor.getCount() < localaik.GxW.Gyi)
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
                      paramAnonymous2Int1 = localaik.GxW.Gyi;
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
                  ae.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
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
                  paramAnonymous2n.setClass(ak.getContext(), ExtDeviceWXLoginUI.class);
                  localObject1 = ak.getContext();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2n);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2n = new Intent(paramAnonymous2n);
                  paramAnonymous2n.setFlags(67108864);
                  if (paramAnonymoussp.dIj.type == 1)
                  {
                    paramAnonymous2n = PendingIntent.getActivity(ak.getContext(), 0, paramAnonymous2n, 134217728);
                    paramAnonymous2String = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(ak.getContext().getString(2131755822)).g(paramAnonymous2String);
                    paramAnonymous2String.Hl = paramAnonymous2n;
                    paramAnonymous2String = paramAnonymous2String.build();
                    paramAnonymous2String.icon = com.tencent.mm.bq.a.dzu();
                    paramAnonymous2String.flags |= 0x10;
                    paramAnonymous2String.sound = RingtoneManager.getDefaultUri(2);
                    bc.getNotification().notify(38, paramAnonymous2String);
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
                  if (localaik.GxX != null)
                  {
                    paramAnonymous2n = new Intent();
                    paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymoussp.dIj.dIk);
                    paramAnonymous2n.putExtra("intent.key.type", -1);
                    paramAnonymous2n.putExtra("intent.key.title.string", localaik.GxX.GxU);
                    paramAnonymous2n.putExtra("intent.key.icon.type", localaik.GxX.GxS);
                    paramAnonymous2n.putExtra("intent.key.ok.string", localaik.GxX.GxV);
                    paramAnonymous2n.putExtra("intent.key.content.string", localaik.GxX.GxT);
                    paramAnonymous2String = localaik.GxX.GxT;
                  }
                }
                else if ((paramAnonymous2Int2 == -2) && (localaik.GxY != null))
                {
                  paramAnonymous2n = new Intent();
                  paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymoussp.dIj.dIk);
                  paramAnonymous2n.putExtra("intent.key.type", -2);
                  paramAnonymous2n.putExtra("intent.key.title.string", localaik.GxY.GxU);
                  paramAnonymous2n.putExtra("intent.key.icon.type", localaik.GxY.GxS);
                  paramAnonymous2n.putExtra("intent.key.ok.string", localaik.GxY.GxV);
                  paramAnonymous2n.putExtra("intent.key.content.string", localaik.GxY.GxT);
                  paramAnonymous2String = localaik.GxY.GxT;
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
          bc.ajj().a(971, paramAnonymoussp);
          bc.ajj().a(locald, 0);
        }
        AppMethodBeat.o(30186);
        return false;
      }
    };
    this.EPu = new y() {};
    AppMethodBeat.o(30189);
  }
  
  public static g eZV()
  {
    AppMethodBeat.i(30190);
    bc.aCa();
    g localg2 = (g)cc.Ca("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bc.aCa().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  static void eZW()
  {
    AppMethodBeat.i(30193);
    bc.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final a eZX()
  {
    AppMethodBeat.i(30194);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.EPr == null) {
      this.EPr = new a();
    }
    a locala = this.EPr;
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
    e.d.a(Integer.valueOf(51), this.EPq);
    bc.getSysCmdMsgExtension().a("pushloginurl", this.nKe, true);
    bc.aCg();
    com.tencent.mm.model.c.a(this.EPs);
    com.tencent.mm.sdk.b.a.IvT.c(this.EPt);
    this.EPr = null;
    ab.a(5, this.EPu);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    e.d.b(Integer.valueOf(51), this.EPq);
    bc.getSysCmdMsgExtension().b("pushloginurl", this.nKe, true);
    bc.aCg();
    com.tencent.mm.model.c.b(this.EPs);
    com.tencent.mm.sdk.b.a.IvT.d(this.EPt);
    eZW();
    if (this.EPr != null)
    {
      a locala = this.EPr;
      o.aNh().a(locala);
      com.tencent.mm.kernel.g.ajj().b(221, locala);
    }
    ab.a(this.EPu);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */