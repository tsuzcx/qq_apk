package com.tencent.mm.ui.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import org.json.JSONObject;

public class QbCallBackBroadcast
  extends BroadcastReceiver
{
  private static Runnable LgR;
  
  static
  {
    AppMethodBeat.i(39123);
    LgR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39121);
        if (f.fiS() != null)
        {
          ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, onEnterPage");
          f.fiS().bhj();
          f.fiS().iS(true);
          f.fiS().bLA();
          AppMethodBeat.o(39121);
          return;
        }
        ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, FilesFloatBallHelper is null");
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
      ae.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() intent == null");
      AppMethodBeat.o(39122);
      return;
    }
    g.ajS();
    if (!g.ajP().aiZ())
    {
      ae.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "account not init.");
      AppMethodBeat.o(39122);
      return;
    }
    ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() %s %s", new Object[] { paramIntent, paramIntent.getExtras() });
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
        ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() thirdCtx Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        i += 1;
      }
      i = g.ajR().ajA().getInt(am.a.JaF, 0);
      j = ((b)g.ab(b.class)).a(b.a.qJs, 0);
      if (!bu.jB(j, 1)) {
        break label568;
      }
      ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "qb verify frequency use %s", new Object[] { Integer.valueOf(i) });
      if (j < 50) {
        break label550;
      }
      AppMethodBeat.o(39122);
      return;
      g.ajR().ajA().set(am.a.JaF, Integer.valueOf(i + 1));
      if (!paramIntent.hasExtra("change_file")) {
        break label1153;
      }
    }
    ae.d("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() type:%s filePath:%s fileExt:%s sence:%s", new Object[] { localObject1, localObject2, localObject3, Integer.valueOf(i) });
    localObject3 = localObject1;
    localObject1 = localObject2;
    localObject2 = localObject4;
    localObject4 = (String)g.ajR().ajA().get(am.a.JaD, "");
    k = 0;
    j = k;
    if (!bu.isNullOrNil((String)localObject4))
    {
      localObject5 = ((String)localObject4).split(",");
      m = localObject5.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!bu.lX(localObject5[i], (String)localObject2)) {
          break label470;
        }
        j = 1;
      }
    }
    if (j == 0)
    {
      ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() originVerify:%s verifyKey:%s", new Object[] { localObject4, localObject2 });
      AppMethodBeat.o(39122);
      return;
    }
    label470:
    for (localObject2 = paramIntent.getStringExtra("change_file");; localObject2 = "")
    {
      if (paramIntent.hasExtra("menuId")) {}
      for (i = paramIntent.getIntExtra("menuId", -1);; i = -1)
      {
        if (bu.jB(i, 11)) {}
        while (!com.tencent.mm.ui.chatting.g.a.isFileExist((String)localObject2))
        {
          ae.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath(%s) not exitst", new Object[] { localObject2 });
          AppMethodBeat.o(39122);
          return;
          localObject2 = localObject1;
        }
        if (paramIntent.hasExtra("activity_status")) {}
        for (paramIntent = paramIntent.getStringExtra("activity_status");; paramIntent = "")
        {
          if (bu.lX((String)localObject3, "qb"))
          {
            localObject3 = f.fiS();
            ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "id:%s hasCurrentBall:%s activityStatus:%s  curFilePath:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(((f)localObject3).bLw()), paramIntent, localObject2 });
            switch (i)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(39122);
              return;
              if (bu.lX((String)localObject2, ((f)localObject3).mFilePath))
              {
                if (!((f)localObject3).bLw())
                {
                  ((com.tencent.mm.plugin.ball.service.a)localObject3).o(true, 2);
                  f.E(paramContext, true);
                  AppMethodBeat.o(39122);
                  return;
                }
                ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == true", new Object[] { localObject1 });
                AppMethodBeat.o(39122);
                return;
                if (bu.lX((String)localObject2, ((f)localObject3).mFilePath))
                {
                  if (((f)localObject3).bLw())
                  {
                    ((com.tencent.mm.plugin.ball.service.a)localObject3).o(false, 2);
                    AppMethodBeat.o(39122);
                    return;
                  }
                  ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == false", new Object[] { localObject1 });
                  AppMethodBeat.o(39122);
                  return;
                  if (bu.lX((String)localObject2, ((f)localObject3).mFilePath))
                  {
                    if (bu.lX(paramIntent, "0"))
                    {
                      ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonBackground");
                      ar.ay(LgR);
                      ((f)localObject3).bhk();
                      ((f)localObject3).fiU();
                      ((f)localObject3).iS(false);
                      if (!AppForegroundDelegate.cTA.cBB) {
                        ((f)localObject3).bLB();
                      }
                      paramContext = HandOffFile.O(((com.tencent.mm.plugin.ball.service.a)localObject3).nLK);
                      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).i(paramContext);
                      AppMethodBeat.o(39122);
                      return;
                    }
                    if (bu.lX(paramIntent, "1"))
                    {
                      ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonForeground");
                      ar.f(LgR);
                      paramContext = HandOffFile.O(((com.tencent.mm.plugin.ball.service.a)localObject3).nLK);
                      paramContext.uPo = 1;
                      paramContext.setKey(HandOff.II(1));
                      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).h(paramContext);
                      AppMethodBeat.o(39122);
                      return;
                      if (!bu.lX((String)localObject2, ((f)localObject3).mFilePath))
                      {
                        ((f)localObject3).onDestroy();
                        ((f)localObject3).J((String)localObject2, f.aaw((String)localObject2), ((f)localObject3).pat);
                        ae.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "updateQbFloatBallMenu enterFloatBall:%s", new Object[] { Boolean.valueOf(((f)localObject3).bLw()) });
                        f.E(paramContext, ((f)localObject3).bLw());
                      }
                    }
                  }
                }
              }
            }
          }
          ae.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() unknow source(type:%s)", new Object[] { localObject3 });
          AppMethodBeat.o(39122);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.QbCallBackBroadcast
 * JD-Core Version:    0.7.0.1
 */