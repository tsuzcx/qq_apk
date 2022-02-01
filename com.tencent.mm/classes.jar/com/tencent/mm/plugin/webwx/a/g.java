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
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.f.d;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.rt.a;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements aw
{
  private f BAM;
  private a BAN;
  private av BAO;
  private com.tencent.mm.sdk.b.c BAP;
  private v BAQ;
  private cc.a mCl;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.BAM = new f();
    this.mCl = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)bw.K(z.a(paramAnonymousa.fTo.Cxz), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bt.isNullOrNil(str)) {
          ad.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        rt localrt = new rt();
        localrt.dxp.dxq = str;
        localrt.dxp.type = 1;
        com.tencent.mm.sdk.b.a.ESL.l(localrt);
        paramAnonymousa.fTo.CxD = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.BAO = new av()
    {
      public final void arM()
      {
        AppMethodBeat.i(30184);
        az.arV();
        if (com.tencent.mm.model.c.aeG()) {
          g.erX();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.BAP = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final rt paramAnonymousrt)
      {
        AppMethodBeat.i(30186);
        if ((paramAnonymousrt != null) && ((paramAnonymousrt instanceof rt)))
        {
          final d locald = new d(paramAnonymousrt.dxp.dxq);
          paramAnonymousrt = new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(30185);
              az.aeS().b(971, this);
              aen localaen = (aen)locald.hdD.gUT.gUX;
              ad.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              Object localObject1;
              StringBuilder localStringBuilder;
              Object localObject3;
              Cursor localCursor;
              Object localObject2;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                if (localaen.DeC == null) {
                  break label1051;
                }
                paramAnonymous2String = new Intent();
                paramAnonymous2String.putExtra("intent.key.login.url", paramAnonymousrt.dxp.dxq);
                paramAnonymous2String.putExtra("intent.key.type", 0);
                paramAnonymous2String.putExtra("intent.key.icon.type", localaen.DeC.Dey);
                paramAnonymous2String.putExtra("intent.key.ok.string", localaen.DeC.DeM);
                paramAnonymous2String.putExtra("intent.key.cancel.string", localaen.DeC.DeN);
                paramAnonymous2String.putExtra("intent.key.title.string", localaen.DeC.Dez);
                paramAnonymous2String.putExtra("intent.key.content.string", localaen.DeC.DeR);
                paramAnonymous2String.putExtra("intent.key.login.client.version", localaen.DeG);
                paramAnonymous2String.putExtra("intent.key.function.control", localaen.DeH);
                paramAnonymous2String.putExtra("intent.key.usage.link", localaen.DeC.DeS);
                localObject1 = localaen.DeC.Dez;
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
                  az.arV();
                  localObject2 = localCursor;
                  paramAnonymous2n = localObject3;
                  localCursor = com.tencent.mm.model.c.apR().a(w.gMn, null, com.tencent.mm.o.a.fIf, true);
                  if (localCursor != null)
                  {
                    localObject2 = localCursor;
                    paramAnonymous2n = localCursor;
                    if (localCursor.getCount() < localaen.DeC.DeO)
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
                      paramAnonymous2Int1 = localaen.DeC.DeO;
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
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymous2n);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2n = new Intent(paramAnonymous2n);
                  paramAnonymous2n.setFlags(67108864);
                  if (paramAnonymousrt.dxp.type == 1)
                  {
                    paramAnonymous2n = PendingIntent.getActivity(aj.getContext(), 0, paramAnonymous2n, 134217728);
                    paramAnonymous2String = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(null).g(System.currentTimeMillis()).f(aj.getContext().getString(2131755822)).g(paramAnonymous2String);
                    paramAnonymous2String.Ew = paramAnonymous2n;
                    paramAnonymous2String = paramAnonymous2String.build();
                    paramAnonymous2String.icon = com.tencent.mm.br.a.cYf();
                    paramAnonymous2String.flags |= 0x10;
                    paramAnonymous2String.sound = RingtoneManager.getDefaultUri(2);
                    az.getNotification().notify(38, paramAnonymous2String);
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
                  if (localaen.DeD != null)
                  {
                    paramAnonymous2n = new Intent();
                    paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymousrt.dxp.dxq);
                    paramAnonymous2n.putExtra("intent.key.type", -1);
                    paramAnonymous2n.putExtra("intent.key.title.string", localaen.DeD.DeA);
                    paramAnonymous2n.putExtra("intent.key.icon.type", localaen.DeD.Dey);
                    paramAnonymous2n.putExtra("intent.key.ok.string", localaen.DeD.DeB);
                    paramAnonymous2n.putExtra("intent.key.content.string", localaen.DeD.Dez);
                    paramAnonymous2String = localaen.DeD.Dez;
                  }
                }
                else if ((paramAnonymous2Int2 == -2) && (localaen.DeE != null))
                {
                  paramAnonymous2n = new Intent();
                  paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymousrt.dxp.dxq);
                  paramAnonymous2n.putExtra("intent.key.type", -2);
                  paramAnonymous2n.putExtra("intent.key.title.string", localaen.DeE.DeA);
                  paramAnonymous2n.putExtra("intent.key.icon.type", localaen.DeE.Dey);
                  paramAnonymous2n.putExtra("intent.key.ok.string", localaen.DeE.DeB);
                  paramAnonymous2n.putExtra("intent.key.content.string", localaen.DeE.Dez);
                  paramAnonymous2String = localaen.DeE.Dez;
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
          az.aeS().a(971, paramAnonymousrt);
          az.aeS().a(locald, 0);
        }
        AppMethodBeat.o(30186);
        return false;
      }
    };
    this.BAQ = new v() {};
    AppMethodBeat.o(30189);
  }
  
  public static g erW()
  {
    AppMethodBeat.i(30190);
    az.arP();
    g localg2 = (g)bz.ut("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      az.arP().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  static void erX()
  {
    AppMethodBeat.i(30193);
    az.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final a erY()
  {
    AppMethodBeat.i(30194);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.BAN == null) {
      this.BAN = new a();
    }
    a locala = this.BAN;
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
    f.d.a(Integer.valueOf(51), this.BAM);
    az.getSysCmdMsgExtension().a("pushloginurl", this.mCl, true);
    az.arV();
    com.tencent.mm.model.c.a(this.BAO);
    com.tencent.mm.sdk.b.a.ESL.c(this.BAP);
    this.BAN = null;
    y.a(5, this.BAQ);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    f.d.b(Integer.valueOf(51), this.BAM);
    az.getSysCmdMsgExtension().b("pushloginurl", this.mCl, true);
    az.arV();
    com.tencent.mm.model.c.b(this.BAO);
    com.tencent.mm.sdk.b.a.ESL.d(this.BAP);
    erX();
    if (this.BAN != null)
    {
      a locala = this.BAN;
      o.aCI().a(locala);
      com.tencent.mm.kernel.g.aeS().b(221, locala);
    }
    y.a(this.BAQ);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */