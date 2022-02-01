package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tm.a;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements bd
{
  private f JFe;
  private a JFf;
  private bc JFg;
  private IListener JFh;
  private IListener JFi;
  private y JFj;
  private cj.a oUZ;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.JFe = new f();
    this.oUZ = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)XmlParser.parseXml(z.a(paramAnonymousa.heO.KHn), "sysmsg", null).get(".sysmsg.pushloginurl.url");
        if (Util.isNullOrNil(str)) {
          Log.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        tm localtm = new tm();
        localtm.dZV.dZW = str;
        localtm.dZV.type = 1;
        EventCenter.instance.publish(localtm);
        paramAnonymousa.heO.KHr = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.JFg = new bc()
    {
      public final void aVw()
      {
        AppMethodBeat.i(30184);
        bg.aVF();
        if (c.azn()) {
          g.gjc();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.JFh = new IListener()
    {
      private boolean a(final tm paramAnonymoustm)
      {
        AppMethodBeat.i(30186);
        if ((paramAnonymoustm != null) && ((paramAnonymoustm instanceof tm)))
        {
          final d locald = new d(paramAnonymoustm.dZV.dZW);
          paramAnonymoustm = new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(30185);
              bg.azz().b(971, this);
              akw localakw = (akw)locald.iUB.iLL.iLR;
              Log.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              Object localObject1;
              StringBuilder localStringBuilder;
              Object localObject3;
              Cursor localCursor;
              Object localObject2;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                if (localakw.LtF == null) {
                  break label1051;
                }
                paramAnonymous2String = new Intent();
                paramAnonymous2String.putExtra("intent.key.login.url", paramAnonymoustm.dZV.dZW);
                paramAnonymous2String.putExtra("intent.key.type", 0);
                paramAnonymous2String.putExtra("intent.key.icon.type", localakw.LtF.LtB);
                paramAnonymous2String.putExtra("intent.key.ok.string", localakw.LtF.LtP);
                paramAnonymous2String.putExtra("intent.key.cancel.string", localakw.LtF.LtQ);
                paramAnonymous2String.putExtra("intent.key.title.string", localakw.LtF.LtC);
                paramAnonymous2String.putExtra("intent.key.content.string", localakw.LtF.LtU);
                paramAnonymous2String.putExtra("intent.key.login.client.version", localakw.LtJ);
                paramAnonymous2String.putExtra("intent.key.function.control", localakw.LtK);
                paramAnonymous2String.putExtra("intent.key.usage.link", localakw.LtF.LtV);
                localObject1 = localakw.LtF.LtC;
                localStringBuilder = new StringBuilder();
                localObject3 = null;
                localCursor = null;
                localObject2 = localCursor;
                paramAnonymous2q = localObject3;
              }
              for (;;)
              {
                try
                {
                  bg.aVF();
                  localObject2 = localCursor;
                  paramAnonymous2q = localObject3;
                  localCursor = c.aST().a(com.tencent.mm.model.ab.iCF, null, com.tencent.mm.o.a.gNj, true);
                  if (localCursor != null)
                  {
                    localObject2 = localCursor;
                    paramAnonymous2q = localCursor;
                    if (localCursor.getCount() < localakw.LtF.LtR)
                    {
                      localObject2 = localCursor;
                      paramAnonymous2q = localCursor;
                      paramAnonymous2Int1 = localCursor.getCount();
                      localObject2 = localCursor;
                      paramAnonymous2q = localCursor;
                      int i = localCursor.getColumnIndex("username");
                      paramAnonymous2Int2 = 0;
                      if (paramAnonymous2Int2 < paramAnonymous2Int1)
                      {
                        localObject2 = localCursor;
                        paramAnonymous2q = localCursor;
                        if (!localCursor.moveToPosition(paramAnonymous2Int2)) {
                          break label1059;
                        }
                        localObject2 = localCursor;
                        paramAnonymous2q = localCursor;
                        localStringBuilder.append(localCursor.getString(i));
                        if (paramAnonymous2Int2 >= paramAnonymous2Int1 - 1) {
                          break label1059;
                        }
                        localObject2 = localCursor;
                        paramAnonymous2q = localCursor;
                        localStringBuilder.append(",");
                        break label1059;
                      }
                    }
                    else
                    {
                      localObject2 = localCursor;
                      paramAnonymous2q = localCursor;
                      paramAnonymous2Int1 = localakw.LtF.LtR;
                      continue;
                    }
                  }
                  localObject2 = localCursor;
                  paramAnonymous2q = localCursor;
                  paramAnonymous2String.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
                  if (localCursor == null) {
                    break label790;
                  }
                  localCursor.close();
                  paramAnonymous2q = paramAnonymous2String;
                  paramAnonymous2String = (String)localObject1;
                }
                catch (Exception localException)
                {
                  paramAnonymous2q = (q)localObject2;
                  Log.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
                  if (localObject2 == null) {
                    break label790;
                  }
                  ((Cursor)localObject2).close();
                  paramAnonymous2q = paramAnonymous2String;
                  paramAnonymous2String = (String)localObject1;
                  continue;
                }
                finally
                {
                  if (paramAnonymous2q == null) {
                    continue;
                  }
                  paramAnonymous2q.close();
                  AppMethodBeat.o(30185);
                }
                if (paramAnonymous2q != null)
                {
                  paramAnonymous2q.setFlags(268435456);
                  paramAnonymous2q.setClass(MMApplicationContext.getContext(), ExtDeviceWXLoginUI.class);
                  localObject1 = MMApplicationContext.getContext();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2q);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2q = new Intent(paramAnonymous2q);
                  paramAnonymous2q.setFlags(67108864);
                  if (paramAnonymoustm.dZV.type == 1)
                  {
                    paramAnonymous2q = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramAnonymous2q, 134217728);
                    paramAnonymous2String = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(MMApplicationContext.getContext().getString(2131755908)).g(paramAnonymous2String);
                    paramAnonymous2String.Hv = paramAnonymous2q;
                    paramAnonymous2String = paramAnonymous2String.build();
                    paramAnonymous2String.icon = com.tencent.mm.bq.a.ezb();
                    paramAnonymous2String.flags |= 0x10;
                    paramAnonymous2String.sound = RingtoneManager.getDefaultUri(2);
                    bg.getNotification().notify(38, paramAnonymous2String);
                  }
                }
                AppMethodBeat.o(30185);
                return;
                label790:
                paramAnonymous2q = paramAnonymous2String;
                paramAnonymous2String = (String)localObject1;
                continue;
                if (paramAnonymous2Int2 == -1)
                {
                  if (localakw.LtG != null)
                  {
                    paramAnonymous2q = new Intent();
                    paramAnonymous2q.putExtra("intent.key.login.url", paramAnonymoustm.dZV.dZW);
                    paramAnonymous2q.putExtra("intent.key.type", -1);
                    paramAnonymous2q.putExtra("intent.key.title.string", localakw.LtG.LtD);
                    paramAnonymous2q.putExtra("intent.key.icon.type", localakw.LtG.LtB);
                    paramAnonymous2q.putExtra("intent.key.ok.string", localakw.LtG.LtE);
                    paramAnonymous2q.putExtra("intent.key.content.string", localakw.LtG.LtC);
                    paramAnonymous2String = localakw.LtG.LtC;
                  }
                }
                else if ((paramAnonymous2Int2 == -2) && (localakw.LtH != null))
                {
                  paramAnonymous2q = new Intent();
                  paramAnonymous2q.putExtra("intent.key.login.url", paramAnonymoustm.dZV.dZW);
                  paramAnonymous2q.putExtra("intent.key.type", -2);
                  paramAnonymous2q.putExtra("intent.key.title.string", localakw.LtH.LtD);
                  paramAnonymous2q.putExtra("intent.key.icon.type", localakw.LtH.LtB);
                  paramAnonymous2q.putExtra("intent.key.ok.string", localakw.LtH.LtE);
                  paramAnonymous2q.putExtra("intent.key.content.string", localakw.LtH.LtC);
                  paramAnonymous2String = localakw.LtH.LtC;
                  continue;
                }
                label1051:
                paramAnonymous2String = null;
                paramAnonymous2q = null;
                continue;
                label1059:
                paramAnonymous2Int2 += 1;
              }
            }
          };
          bg.azz().a(971, paramAnonymoustm);
          bg.azz().a(locald, 0);
        }
        AppMethodBeat.o(30186);
        return false;
      }
    };
    this.JFi = new IListener() {};
    this.JFj = new y() {};
    AppMethodBeat.o(30189);
  }
  
  public static g gjb()
  {
    AppMethodBeat.i(30190);
    bg.aVz();
    g localg2 = (g)cg.KG("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bg.aVz().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  static void gjc()
  {
    AppMethodBeat.i(30193);
    bg.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final a gjd()
  {
    AppMethodBeat.i(30194);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.JFf == null) {
      this.JFf = new a();
    }
    a locala = this.JFf;
    AppMethodBeat.o(30194);
    return locala;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(30192);
    h.d.a(Integer.valueOf(51), this.JFe);
    bg.getSysCmdMsgExtension().a("pushloginurl", this.oUZ, true);
    bg.aVF();
    c.a(this.JFg);
    EventCenter.instance.addListener(this.JFh);
    EventCenter.instance.addListener(this.JFi);
    this.JFf = null;
    com.tencent.mm.plugin.messenger.foundation.a.ab.a(5, this.JFj);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    h.d.b(Integer.valueOf(51), this.JFe);
    bg.getSysCmdMsgExtension().b("pushloginurl", this.oUZ, true);
    bg.aVF();
    c.b(this.JFg);
    EventCenter.instance.removeListener(this.JFh);
    EventCenter.instance.removeListener(this.JFi);
    gjc();
    if (this.JFf != null)
    {
      a locala = this.JFf;
      o.bhj().a(locala);
      com.tencent.mm.kernel.g.azz().b(221, locala);
    }
    com.tencent.mm.plugin.messenger.foundation.a.ab.a(this.JFj);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */