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
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.sc.a;
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
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements aw
{
  private f CST;
  private a CSU;
  private av CSV;
  private com.tencent.mm.sdk.b.c CSW;
  private v CSX;
  private cc.a nem;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.CST = new f();
    this.nem = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)bv.L(z.a(paramAnonymousa.fXi.DPV), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bs.isNullOrNil(str)) {
          ac.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        sc localsc = new sc();
        localsc.dvc.dvd = str;
        localsc.dvc.type = 1;
        com.tencent.mm.sdk.b.a.GpY.l(localsc);
        paramAnonymousa.fXi.DPZ = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.CSV = new av()
    {
      public final void ayD()
      {
        AppMethodBeat.i(30184);
        az.ayM();
        if (com.tencent.mm.model.c.afW()) {
          g.eHr();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.CSW = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final sc paramAnonymoussc)
      {
        AppMethodBeat.i(30186);
        if ((paramAnonymoussc != null) && ((paramAnonymoussc instanceof sc)))
        {
          final d locald = new d(paramAnonymoussc.dvc.dvd);
          paramAnonymoussc = new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(30185);
              az.agi().b(971, this);
              afm localafm = (afm)locald.hEg.hvs.hvw;
              ac.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              Object localObject1;
              StringBuilder localStringBuilder;
              Object localObject3;
              Cursor localCursor;
              Object localObject2;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                if (localafm.ExI == null) {
                  break label1051;
                }
                paramAnonymous2String = new Intent();
                paramAnonymous2String.putExtra("intent.key.login.url", paramAnonymoussc.dvc.dvd);
                paramAnonymous2String.putExtra("intent.key.type", 0);
                paramAnonymous2String.putExtra("intent.key.icon.type", localafm.ExI.ExE);
                paramAnonymous2String.putExtra("intent.key.ok.string", localafm.ExI.ExS);
                paramAnonymous2String.putExtra("intent.key.cancel.string", localafm.ExI.ExT);
                paramAnonymous2String.putExtra("intent.key.title.string", localafm.ExI.ExF);
                paramAnonymous2String.putExtra("intent.key.content.string", localafm.ExI.ExX);
                paramAnonymous2String.putExtra("intent.key.login.client.version", localafm.ExM);
                paramAnonymous2String.putExtra("intent.key.function.control", localafm.ExN);
                paramAnonymous2String.putExtra("intent.key.usage.link", localafm.ExI.ExY);
                localObject1 = localafm.ExI.ExF;
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
                  az.ayM();
                  localObject2 = localCursor;
                  paramAnonymous2n = localObject3;
                  localCursor = com.tencent.mm.model.c.awG().a(w.hmN, null, com.tencent.mm.o.a.fLL, true);
                  if (localCursor != null)
                  {
                    localObject2 = localCursor;
                    paramAnonymous2n = localCursor;
                    if (localCursor.getCount() < localafm.ExI.ExU)
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
                      paramAnonymous2Int1 = localafm.ExI.ExU;
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
                  ac.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
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
                  paramAnonymous2n.setClass(ai.getContext(), ExtDeviceWXLoginUI.class);
                  localObject1 = ai.getContext();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymous2n);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2n = new Intent(paramAnonymous2n);
                  paramAnonymous2n.setFlags(67108864);
                  if (paramAnonymoussc.dvc.type == 1)
                  {
                    paramAnonymous2n = PendingIntent.getActivity(ai.getContext(), 0, paramAnonymous2n, 134217728);
                    paramAnonymous2String = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(ai.getContext().getString(2131755822)).g(paramAnonymous2String);
                    paramAnonymous2String.Fu = paramAnonymous2n;
                    paramAnonymous2String = paramAnonymous2String.build();
                    paramAnonymous2String.icon = com.tencent.mm.bq.a.dlN();
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
                  if (localafm.ExJ != null)
                  {
                    paramAnonymous2n = new Intent();
                    paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymoussc.dvc.dvd);
                    paramAnonymous2n.putExtra("intent.key.type", -1);
                    paramAnonymous2n.putExtra("intent.key.title.string", localafm.ExJ.ExG);
                    paramAnonymous2n.putExtra("intent.key.icon.type", localafm.ExJ.ExE);
                    paramAnonymous2n.putExtra("intent.key.ok.string", localafm.ExJ.ExH);
                    paramAnonymous2n.putExtra("intent.key.content.string", localafm.ExJ.ExF);
                    paramAnonymous2String = localafm.ExJ.ExF;
                  }
                }
                else if ((paramAnonymous2Int2 == -2) && (localafm.ExK != null))
                {
                  paramAnonymous2n = new Intent();
                  paramAnonymous2n.putExtra("intent.key.login.url", paramAnonymoussc.dvc.dvd);
                  paramAnonymous2n.putExtra("intent.key.type", -2);
                  paramAnonymous2n.putExtra("intent.key.title.string", localafm.ExK.ExG);
                  paramAnonymous2n.putExtra("intent.key.icon.type", localafm.ExK.ExE);
                  paramAnonymous2n.putExtra("intent.key.ok.string", localafm.ExK.ExH);
                  paramAnonymous2n.putExtra("intent.key.content.string", localafm.ExK.ExF);
                  paramAnonymous2String = localafm.ExK.ExF;
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
          az.agi().a(971, paramAnonymoussc);
          az.agi().a(locald, 0);
        }
        AppMethodBeat.o(30186);
        return false;
      }
    };
    this.CSX = new v() {};
    AppMethodBeat.o(30189);
  }
  
  public static g eHq()
  {
    AppMethodBeat.i(30190);
    az.ayG();
    g localg2 = (g)bz.yz("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      az.ayG().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  static void eHr()
  {
    AppMethodBeat.i(30193);
    az.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final a eHs()
  {
    AppMethodBeat.i(30194);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.CSU == null) {
      this.CSU = new a();
    }
    a locala = this.CSU;
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
    f.d.a(Integer.valueOf(51), this.CST);
    az.getSysCmdMsgExtension().a("pushloginurl", this.nem, true);
    az.ayM();
    com.tencent.mm.model.c.a(this.CSV);
    com.tencent.mm.sdk.b.a.GpY.c(this.CSW);
    this.CSU = null;
    y.a(5, this.CSX);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    f.d.b(Integer.valueOf(51), this.CST);
    az.getSysCmdMsgExtension().b("pushloginurl", this.nem, true);
    az.ayM();
    com.tencent.mm.model.c.b(this.CSV);
    com.tencent.mm.sdk.b.a.GpY.d(this.CSW);
    eHr();
    if (this.CSU != null)
    {
      a locala = this.CSU;
      o.aJy().a(locala);
      com.tencent.mm.kernel.g.agi().b(221, locala);
    }
    y.a(this.CSX);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */