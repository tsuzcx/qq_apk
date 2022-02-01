package com.tencent.mm.ui.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import org.json.JSONObject;

public class QbCallBackBroadcast
  extends BroadcastReceiver
{
  private static Runnable HsW;
  
  static
  {
    AppMethodBeat.i(39123);
    HsW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39121);
        if (f.eAG() != null)
        {
          ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, onEnterPage");
          f.eAG().aVZ();
          f.eAG().ik(true);
          f.eAG().bzw();
          AppMethodBeat.o(39121);
          return;
        }
        ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, FilesFloatBallHelper is null");
        AppMethodBeat.o(39121);
      }
    };
    AppMethodBeat.o(39123);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(39122);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() intent == null");
      AppMethodBeat.o(39122);
      return;
    }
    g.afC();
    if (!g.afz().aeI())
    {
      ad.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "account not init.");
      AppMethodBeat.o(39122);
      return;
    }
    ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() %s %s", new Object[] { paramIntent, paramIntent.getExtras() });
    String str1 = "";
    Object localObject5 = "";
    String str2 = "";
    Object localObject4 = "";
    int j = 0;
    Object localObject2 = localObject4;
    Object localObject1 = localObject5;
    Object localObject3 = str1;
    Object localObject6;
    int i;
    if (paramIntent.hasExtra("thirdCtx"))
    {
      localObject6 = paramIntent.getStringExtra("thirdCtx");
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
    }
    try
    {
      localObject6 = new JSONObject((String)localObject6);
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
      str1 = ((JSONObject)localObject6).getString("type");
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
      localObject5 = ((JSONObject)localObject6).getString("filePath");
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
      str2 = ((JSONObject)localObject6).getString("fileExt");
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
      j = ((JSONObject)localObject6).getInt("sence");
      i = j;
      localObject3 = str2;
      localObject2 = localObject5;
      localObject1 = str1;
      localObject6 = ((JSONObject)localObject6).getString("verify");
      localObject4 = localObject6;
      localObject1 = str1;
      localObject2 = localObject5;
      localObject3 = str2;
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() thirdCtx Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        i += 1;
      }
      i = g.afB().afk().getInt(ae.a.FvG, 0);
      j = ((b)g.ab(b.class)).a(b.a.psM, 0);
      if (!bt.iY(j, 1)) {
        break label568;
      }
      ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "qb verify frequency use %s", new Object[] { Integer.valueOf(i) });
      if (j < 50) {
        break label550;
      }
      AppMethodBeat.o(39122);
      return;
      g.afB().afk().set(ae.a.FvG, Integer.valueOf(i + 1));
      if (!paramIntent.hasExtra("change_file")) {
        break label1151;
      }
    }
    ad.d("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() type:%s filePath:%s fileExt:%s sence:%s", new Object[] { localObject1, localObject2, localObject3, Integer.valueOf(i) });
    localObject3 = localObject1;
    localObject1 = localObject2;
    localObject2 = localObject4;
    localObject4 = (String)g.afB().afk().get(ae.a.FvE, "");
    k = 0;
    j = k;
    if (!bt.isNullOrNil((String)localObject4))
    {
      localObject5 = ((String)localObject4).split(",");
      m = localObject5.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!bt.kU(localObject5[i], (String)localObject2)) {
          break label470;
        }
        j = 1;
      }
    }
    if (j == 0)
    {
      ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() originVerify:%s verifyKey:%s", new Object[] { localObject4, localObject2 });
      AppMethodBeat.o(39122);
      return;
    }
    label470:
    label1151:
    for (localObject2 = paramIntent.getStringExtra("change_file");; localObject2 = "")
    {
      if (paramIntent.hasExtra("menuId")) {}
      for (i = paramIntent.getIntExtra("menuId", -1);; i = -1)
      {
        if (bt.iY(i, 11)) {}
        while (!com.tencent.mm.ui.chatting.f.a.isFileExist((String)localObject2))
        {
          ad.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath(%s) not exitst", new Object[] { localObject2 });
          AppMethodBeat.o(39122);
          return;
          localObject2 = localObject1;
        }
        if (paramIntent.hasExtra("activity_status")) {}
        for (paramIntent = paramIntent.getStringExtra("activity_status");; paramIntent = "")
        {
          if (bt.kU((String)localObject3, "qb"))
          {
            localObject3 = f.eAG();
            ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "id:%s hasCurrentBall:%s activityStatus:%s  curFilePath:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(((f)localObject3).bzs()), paramIntent, localObject2 });
            switch (i)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(39122);
              return;
              if (bt.kU((String)localObject2, ((f)localObject3).mFilePath))
              {
                if (!((f)localObject3).bzs())
                {
                  ((f)localObject3).fE(true);
                  f.B(paramContext, true);
                  AppMethodBeat.o(39122);
                  return;
                }
                ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == true", new Object[] { localObject1 });
                AppMethodBeat.o(39122);
                return;
                if (bt.kU((String)localObject2, ((f)localObject3).mFilePath))
                {
                  if (((f)localObject3).bzs())
                  {
                    ((f)localObject3).fE(false);
                    AppMethodBeat.o(39122);
                    return;
                  }
                  ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == false", new Object[] { localObject1 });
                  AppMethodBeat.o(39122);
                  return;
                  if (bt.kU((String)localObject2, ((f)localObject3).mFilePath))
                  {
                    if (bt.kU(paramIntent, "0"))
                    {
                      ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonBackground");
                      aq.az(HsW);
                      ((f)localObject3).aWa();
                      ((f)localObject3).eAI();
                      ((f)localObject3).ik(false);
                      if (!AppForegroundDelegate.cKE.csU) {
                        ((f)localObject3).bzx();
                      }
                      paramContext = HandOffFile.L(((com.tencent.mm.plugin.ball.service.a)localObject3).mDH);
                      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).h(paramContext);
                      AppMethodBeat.o(39122);
                      return;
                    }
                    if (bt.kU(paramIntent, "1"))
                    {
                      ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonForeground");
                      aq.f(HsW);
                      paramContext = HandOffFile.L(((com.tencent.mm.plugin.ball.service.a)localObject3).mDH);
                      paramContext.stk = 1;
                      paramContext.setKey(HandOff.ES(1));
                      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(paramContext);
                      AppMethodBeat.o(39122);
                      return;
                      if (!bt.kU((String)localObject2, ((f)localObject3).mFilePath))
                      {
                        ((f)localObject3).onDestroy();
                        ((f)localObject3).H((String)localObject2, f.RK((String)localObject2), ((f)localObject3).nNu);
                        ad.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "updateQbFloatBallMenu enterFloatBall:%s", new Object[] { Boolean.valueOf(((f)localObject3).bzs()) });
                        f.B(paramContext, ((f)localObject3).bzs());
                      }
                    }
                  }
                }
              }
            }
          }
          ad.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() unknow source(type:%s)", new Object[] { localObject3 });
          AppMethodBeat.o(39122);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.QbCallBackBroadcast
 * JD-Core Version:    0.7.0.1
 */