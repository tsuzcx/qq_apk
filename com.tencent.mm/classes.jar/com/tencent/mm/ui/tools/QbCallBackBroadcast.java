package com.tencent.mm.ui.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public class QbCallBackBroadcast
  extends BroadcastReceiver
{
  private static Runnable Uvb;
  
  static
  {
    AppMethodBeat.i(39123);
    Uvb = new QbCallBackBroadcast.1();
    AppMethodBeat.o(39123);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(39122);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() intent == null");
      AppMethodBeat.o(39122);
      return;
    }
    g.aAi();
    if (!g.aAf().azp())
    {
      Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "account not init.");
      AppMethodBeat.o(39122);
      return;
    }
    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() %s %s", new Object[] { paramIntent, paramIntent.getExtras() });
    String str1 = "";
    Object localObject4 = "";
    String str2 = "";
    Object localObject3 = "";
    int j = 0;
    Object localObject1 = localObject3;
    paramContext = (Context)localObject4;
    Object localObject2 = str1;
    Object localObject5;
    int i;
    if (paramIntent.hasExtra("thirdCtx"))
    {
      localObject5 = paramIntent.getStringExtra("thirdCtx");
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
    }
    try
    {
      localObject5 = new JSONObject((String)localObject5);
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
      str1 = ((JSONObject)localObject5).getString("type");
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
      localObject4 = ((JSONObject)localObject5).getString("filePath");
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
      str2 = ((JSONObject)localObject5).getString("fileExt");
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
      j = ((JSONObject)localObject5).getInt("sence");
      i = j;
      localObject2 = str2;
      localObject1 = localObject4;
      paramContext = str1;
      localObject5 = ((JSONObject)localObject5).getString("verify");
      localObject3 = localObject5;
      paramContext = str1;
      localObject1 = localObject4;
      localObject2 = str2;
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() thirdCtx Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        i += 1;
      }
      i = g.aAh().azQ().getInt(ar.a.Ojl, 0);
      j = ((b)g.af(b.class)).a(b.a.seU, 0);
      if (!Util.isEqual(j, 1)) {
        break label557;
      }
      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "qb verify frequency use %s", new Object[] { Integer.valueOf(i) });
      if (j < 50) {
        break label539;
      }
      AppMethodBeat.o(39122);
      return;
      g.aAh().azQ().set(ar.a.Ojl, Integer.valueOf(i + 1));
      if (!paramIntent.hasExtra("change_file")) {
        break label1340;
      }
    }
    Log.d("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() type:%s filePath:%s fileExt:%s sence:%s", new Object[] { paramContext, localObject1, localObject2, Integer.valueOf(i) });
    localObject2 = paramContext;
    paramContext = (Context)localObject1;
    localObject1 = localObject3;
    localObject3 = (String)g.aAh().azQ().get(ar.a.Ojj, "");
    k = 0;
    j = k;
    if (!Util.isNullOrNil((String)localObject3))
    {
      localObject4 = ((String)localObject3).split(",");
      m = localObject4.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!Util.isEqual(localObject4[i], (String)localObject1)) {
          break label459;
        }
        j = 1;
      }
    }
    if (j == 0)
    {
      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() originVerify:%s verifyKey:%s", new Object[] { localObject3, localObject1 });
      AppMethodBeat.o(39122);
      return;
    }
    label459:
    for (localObject1 = paramIntent.getStringExtra("change_file");; localObject1 = "")
    {
      if (paramIntent.hasExtra("menuId")) {}
      for (i = paramIntent.getIntExtra("menuId", -1);; i = -1)
      {
        if (Util.isEqual(i, 11)) {}
        while (!com.tencent.mm.ui.chatting.g.a.isFileExist((String)localObject1))
        {
          Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath(%s) not exitst", new Object[] { localObject1 });
          AppMethodBeat.o(39122);
          return;
          localObject1 = paramContext;
        }
        if (paramIntent.hasExtra("activity_status")) {}
        for (localObject3 = paramIntent.getStringExtra("activity_status");; localObject3 = "")
        {
          if (paramIntent.hasExtra("readProgress")) {}
          for (paramIntent = paramIntent.getStringExtra("readProgress");; paramIntent = "")
          {
            if (Util.isEqual((String)localObject2, "qb"))
            {
              localObject2 = aa.heb();
              h localh = h.gsv();
              Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "id:%s hasCurrentBall:%s activityStatus:%s  curFilePath:%s readState:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(localh.eqW()), localObject3, localObject1, paramIntent });
              switch (i)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(39122);
                return;
                if (Util.isEqual((String)localObject1, localh.mFilePath))
                {
                  if (!localh.eqW())
                  {
                    localh.ic(true);
                    AppMethodBeat.o(39122);
                    return;
                  }
                  Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == true", new Object[] { paramContext });
                  AppMethodBeat.o(39122);
                  return;
                  if (Util.isEqual((String)localObject1, localh.mFilePath))
                  {
                    localh.ic(true);
                    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall:%b", new Object[] { paramContext, Boolean.valueOf(localh.eqW()) });
                    AppMethodBeat.o(39122);
                    return;
                    paramContext = HandOffFile.fromMultiTask(localh.Abp);
                    if (paramContext != null)
                    {
                      paramContext.setHandOffType(1);
                      paramContext.setKey(HandOff.generateKey(1, 1));
                      ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(paramContext);
                      AppMethodBeat.o(39122);
                      return;
                      if (Util.isEqual((String)localObject1, localh.mFilePath))
                      {
                        if (Util.isEqual((String)localObject3, "0"))
                        {
                          Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonBackground");
                          MMHandlerThread.removeRunnable(Uvb);
                          ((aa)localObject2).aGj();
                          localh.aGj();
                          g.aAh().azQ().set(ar.a.Oot, "");
                          ((aa)localObject2).hRt();
                          ((aa)localObject2).Dw(false);
                          if (!AppForegroundDelegate.djR.cPB) {
                            ((aa)localObject2).cjk();
                          }
                          paramContext = HandOffFile.fromMultiTask(localh.Abp);
                          if (paramContext != null) {
                            ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).i(paramContext);
                          }
                          AppMethodBeat.o(39122);
                          return;
                        }
                        if (Util.isEqual((String)localObject3, "1"))
                        {
                          Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonForeground");
                          MMHandlerThread.postToMainThread(Uvb);
                          paramContext = HandOffFile.fromMultiTask(localh.Abp);
                          if (paramContext != null)
                          {
                            paramContext.setHandOffType(1);
                            paramContext.setKey(HandOff.generateKey(1, 1));
                            ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).h(paramContext);
                          }
                          AppMethodBeat.o(39122);
                          return;
                          if (!Util.isEqual((String)localObject1, localh.mFilePath))
                          {
                            localh.I((String)localObject1, h.akC((String)localObject1), localh.qpr);
                            ((aa)localObject2).onDestroy();
                            ((aa)localObject2).I((String)localObject1, h.akC((String)localObject1), ((aa)localObject2).qpr);
                            AppMethodBeat.o(39122);
                            return;
                            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "readState:%s", new Object[] { paramIntent });
                            if (!TextUtils.isEmpty(paramIntent))
                            {
                              if (paramIntent.equals("0"))
                              {
                                localh.dkj();
                                Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setStart");
                              }
                              if (paramIntent.equals("1"))
                              {
                                localh.CB = true;
                                Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setEnded mEnded:%b", new Object[] { Boolean.TRUE });
                                localh.erc();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() unknow source(type:%s)", new Object[] { localObject2 });
            AppMethodBeat.o(39122);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.QbCallBackBroadcast
 * JD-Core Version:    0.7.0.1
 */