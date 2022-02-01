package com.tencent.mm.ui.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

public class QbCallBackBroadcast
  extends BroadcastReceiver
{
  private static Runnable afKf;
  
  static
  {
    AppMethodBeat.i(39123);
    afKf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39121);
        if (com.tencent.mm.pluginsdk.ui.tools.f.iOq() != null)
        {
          Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, onEnterPage");
          com.tencent.mm.pluginsdk.ui.tools.f.iOq().coi();
          com.tencent.mm.pluginsdk.ui.tools.f.iOq().mo(true);
          com.tencent.mm.pluginsdk.ui.tools.f.iOq().mj(true);
          AppMethodBeat.o(39121);
          return;
        }
        Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, FilesFloatBallHelper is null");
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
      Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() intent == null");
      AppMethodBeat.o(39122);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "account not init.");
      AppMethodBeat.o(39122);
      return;
    }
    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() %s %s", new Object[] { paramIntent, paramIntent.getExtras() });
    String str2 = "";
    Object localObject5 = "";
    Object localObject4 = "";
    String str1 = "";
    int j = 0;
    Object localObject1 = str1;
    Object localObject2 = localObject4;
    paramContext = (Context)localObject5;
    Object localObject3 = str2;
    int i;
    if (paramIntent.hasExtra("thirdCtx"))
    {
      localObject3 = paramIntent.getStringExtra("thirdCtx");
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = str2;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject3);
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = str2;
      localObject3 = localJSONObject.getString("type");
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = (Context)localObject3;
      localObject5 = localJSONObject.getString("filePath");
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = (Context)localObject3;
      localObject4 = localJSONObject.getString("fileExt");
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = (Context)localObject3;
      j = localJSONObject.getInt("sence");
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject5;
      paramContext = (Context)localObject3;
      str2 = localJSONObject.getString("verify");
      str1 = str2;
      paramContext = (Context)localObject3;
      localObject1 = localObject5;
      localObject2 = localObject4;
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
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZo, 0);
      j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zhg, 0);
      if (!Util.isEqual(j, 1)) {
        break label561;
      }
      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "qb verify frequency use %s", new Object[] { Integer.valueOf(i) });
      if (j < 50) {
        break label543;
      }
      AppMethodBeat.o(39122);
      return;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZo, Integer.valueOf(i + 1));
      if (!paramIntent.hasExtra("change_file")) {
        break label1599;
      }
    }
    Log.d("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() type:%s filePath:%s fileExt:%s sence:%s", new Object[] { paramContext, localObject1, localObject2, Integer.valueOf(i) });
    localObject3 = paramContext;
    paramContext = (Context)localObject1;
    localObject1 = str1;
    str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZm, "");
    k = 0;
    j = k;
    if (!Util.isNullOrNil(str1))
    {
      localObject4 = str1.split(",");
      m = localObject4.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!Util.isEqual(localObject4[i], (String)localObject1)) {
          break label463;
        }
        j = 1;
      }
    }
    if (j == 0)
    {
      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() originVerify:%s verifyKey:%s", new Object[] { str1, localObject1 });
      AppMethodBeat.o(39122);
      return;
    }
    label463:
    for (localObject1 = paramIntent.getStringExtra("change_file");; localObject1 = "")
    {
      if (paramIntent.hasExtra("menuId")) {}
      for (i = paramIntent.getIntExtra("menuId", -1);; i = -1)
      {
        if (Util.isEqual(i, 11)) {}
        while (!com.tencent.mm.ui.chatting.floatball.a.isFileExist((String)localObject1))
        {
          Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath(%s) not exitst", new Object[] { localObject1 });
          AppMethodBeat.o(39122);
          return;
          localObject1 = paramContext;
        }
        if (paramIntent.hasExtra("activity_status")) {}
        for (str1 = paramIntent.getStringExtra("activity_status");; str1 = "")
        {
          if (paramIntent.hasExtra("readProgress")) {}
          for (localObject4 = paramIntent.getStringExtra("readProgress");; localObject4 = "")
          {
            if (paramIntent.hasExtra("exposeMenuId")) {}
            for (paramIntent = paramIntent.getStringExtra("exposeMenuId");; paramIntent = "0")
            {
              com.tencent.mm.pluginsdk.ui.tools.f localf;
              if (Util.isEqual(localException, "qb"))
              {
                localf = com.tencent.mm.pluginsdk.ui.tools.f.iOq();
                localObject5 = g.iOt();
                Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "id:%s hasCurrentBall:%s activityStatus:%s  curFilePath:%s readState:%s, menuIdStr:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(((g)localObject5).gjV()), str1, localObject1, localObject4, paramIntent });
                switch (i)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(39122);
                  return;
                  if (Util.isEqual((String)localObject1, ((g)localObject5).mFilePath))
                  {
                    if (!((g)localObject5).gjV())
                    {
                      ((g)localObject5).ke(true);
                      AppMethodBeat.o(39122);
                      return;
                    }
                    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == true", new Object[] { paramContext });
                    AppMethodBeat.o(39122);
                    return;
                    if (Util.isEqual((String)localObject1, ((g)localObject5).mFilePath))
                    {
                      ((g)localObject5).ke(true);
                      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall:%b", new Object[] { paramContext, Boolean.valueOf(((g)localObject5).gjV()) });
                      AppMethodBeat.o(39122);
                      return;
                      paramContext = HandOffFile.fromMultiTask(((com.tencent.mm.plugin.multitask.b.a)localObject5).LCE);
                      if (paramContext != null)
                      {
                        paramContext.setHandOffType(1);
                        paramContext.setKey(HandOff.generateKey(1, 1));
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(paramContext);
                        AppMethodBeat.o(39122);
                        return;
                        if (Util.isEqual((String)localObject1, ((g)localObject5).mFilePath))
                        {
                          if (Util.isEqual(str1, "0"))
                          {
                            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonBackground");
                            MMHandlerThread.removeRunnable(afKf);
                            localf.bhW();
                            ((g)localObject5).bhW();
                            com.tencent.mm.kernel.h.baE().ban().set(at.a.adgS, "");
                            localf.iOr();
                            localf.mo(false);
                            if (!AppForegroundDelegate.heY.eLx) {
                              localf.mi(true);
                            }
                            paramContext = HandOffFile.fromMultiTask(((com.tencent.mm.plugin.multitask.b.a)localObject5).LCE);
                            if (paramContext != null) {
                              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).i(paramContext);
                            }
                            AppMethodBeat.o(39122);
                            return;
                          }
                          if (Util.isEqual(str1, "1"))
                          {
                            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonForeground");
                            MMHandlerThread.postToMainThread(afKf);
                            paramContext = HandOffFile.fromMultiTask(((com.tencent.mm.plugin.multitask.b.a)localObject5).LCE);
                            if (paramContext != null)
                            {
                              paramContext.setHandOffType(1);
                              paramContext.setKey(HandOff.generateKey(1, 1));
                              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).h(paramContext);
                            }
                            AppMethodBeat.o(39122);
                            return;
                            if (!Util.isEqual((String)localObject1, ((g)localObject5).mFilePath))
                            {
                              ((g)localObject5).T((String)localObject1, g.alV((String)localObject1), ((g)localObject5).wRr);
                              localf.onDestroy();
                              localf.T((String)localObject1, g.alV((String)localObject1), localf.wRr);
                              AppMethodBeat.o(39122);
                              return;
                              Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "readState:%s", new Object[] { localObject4 });
                              if (!TextUtils.isEmpty((CharSequence)localObject4))
                              {
                                if (((String)localObject4).equals("0"))
                                {
                                  ((g)localObject5).eCK();
                                  Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setStart");
                                }
                                if (((String)localObject4).equals("1"))
                                {
                                  ((g)localObject5).bCD = true;
                                  Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setEnded mEnded:%b", new Object[] { Boolean.TRUE });
                                  ((g)localObject5).gkb();
                                  AppMethodBeat.o(39122);
                                  return;
                                  try
                                  {
                                    i = Integer.parseInt(paramIntent);
                                    if (-1 != i) {
                                      break label1465;
                                    }
                                    paramContext = MaterialModel.fh((String)localObject1, localObject2);
                                    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "reportBottomSheetShown, materialModel: ".concat(String.valueOf(paramContext)));
                                    paramIntent = (j)com.tencent.mm.kernel.h.ax(j.class);
                                    if (paramIntent != null) {
                                      break;
                                    }
                                    Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "reportBottomSheetShown, openMaterialService is null");
                                    AppMethodBeat.o(39122);
                                    return;
                                  }
                                  catch (Exception paramContext)
                                  {
                                    Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive, fail since ".concat(String.valueOf(paramContext)));
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
                localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ;
                if (!paramIntent.a((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1, paramContext, paramIntent.a((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1, paramIntent.b(paramContext)))) {
                  Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "reportBottomSheetShown, saveOpenMaterialReporter fail");
                }
                AppMethodBeat.o(39122);
                return;
                if (5 == i)
                {
                  paramContext = MaterialModel.fh((String)localObject1, localObject2);
                  Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "reportOpenMaterialEntranceExposure, materialModel: ".concat(String.valueOf(paramContext)));
                  paramIntent = (j)com.tencent.mm.kernel.h.ax(j.class);
                  if (paramIntent == null)
                  {
                    Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "reportOpenMaterialEntranceExposure, openMaterialService is null");
                    AppMethodBeat.o(39122);
                    return;
                  }
                  paramIntent.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ, paramContext, paramIntent.b(paramContext), false).cDs();
                }
                AppMethodBeat.o(39122);
                return;
              }
              Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() unknow source(type:%s)", new Object[] { localf });
              AppMethodBeat.o(39122);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.QbCallBackBroadcast
 * JD-Core Version:    0.7.0.1
 */