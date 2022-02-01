package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "()V", "THREAD_LOOP_TAG", "", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "", "()Z", "isFromTaskBar", "()Ljava/lang/Boolean;", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "minusScreenType", "", "getMinusScreenType", "()I", "setMinusScreenType", "(I)V", "multiTaskItemPos", "getMultiTaskItemPos", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentHistoryMultiTaskInfo", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "runTask", "runnable", "Ljava/lang/Runnable;", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"})
public class a
  implements b
{
  public static final a.a Abu;
  public MultiTaskInfo Abp;
  protected ach Abq;
  crt Abr;
  private final String Abs = "MultiTasklLoopTag";
  private int Abt;
  
  static
  {
    AppMethodBeat.i(200578);
    Abu = new a.a((byte)0);
    AppMethodBeat.o(200578);
  }
  
  public static void a(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(200564);
    ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskInfoList(parama);
    AppMethodBeat.o(200564);
  }
  
  private void eqY()
  {
    AppMethodBeat.i(200568);
    if (eqW())
    {
      MultiTaskInfo localMultiTaskInfo = this.Abp;
      if (localMultiTaskInfo != null)
      {
        com.tencent.mm.plugin.multitask.d locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
        String str = localMultiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        cru localcru = localMultiTaskInfo.erh();
        p.g(localcru, "it.showData");
        locald.updateTaskInfoByTitle(str, i, localcru, localMultiTaskInfo.field_data);
        AppMethodBeat.o(200568);
        return;
      }
    }
    AppMethodBeat.o(200568);
  }
  
  public void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(200561);
    this.Abp = new MultiTaskInfo();
    MultiTaskInfo localMultiTaskInfo = this.Abp;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_updateTime = cl.aWA();
    }
    localMultiTaskInfo = this.Abp;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_id = paramString;
    }
    paramString = this.Abp;
    if (paramString != null) {
      paramString.field_type = paramInt;
    }
    this.Abt = paramInt;
    this.Abr = new crt();
    paramString = this.Abr;
    if (paramString != null) {
      paramString.MwO = new crp();
    }
    paramString = this.Abr;
    if (paramString != null) {
      paramString.MwN = new crr();
    }
    paramString = this.Abr;
    if (paramString != null) {
      paramString.MwP = new crs();
    }
    paramString = this.Abr;
    if (paramString != null) {
      paramString.Uub = new ffq();
    }
    paramString = this.Abr;
    if (paramString != null)
    {
      paramString = paramString.Uub;
      if (paramString != null)
      {
        paramString.Uua = true;
        AppMethodBeat.o(200561);
        return;
      }
    }
    AppMethodBeat.o(200561);
  }
  
  public boolean O(int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  public final String RK(int paramInt)
  {
    AppMethodBeat.i(200573);
    Object localObject2 = this.Abp;
    if (localObject2 != null)
    {
      Object localObject1 = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
      localObject2 = ((MultiTaskInfo)localObject2).field_id;
      p.g(localObject2, "it.field_id");
      localObject1 = ((com.tencent.mm.plugin.multitask.d)localObject1).getMultiTaskItemPosition((String)localObject2, eqR(), paramInt);
      AppMethodBeat.o(200573);
      return localObject1;
    }
    AppMethodBeat.o(200573);
    return "";
  }
  
  public void a(ach paramach) {}
  
  public final void aCM(String paramString)
  {
    AppMethodBeat.i(200558);
    Object localObject = this.Abp;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).erh();
      if (localObject != null) {
        ((cru)localObject).title = paramString;
      }
    }
    eqY();
    AppMethodBeat.o(200558);
  }
  
  public final void aGL(String paramString)
  {
    AppMethodBeat.i(200560);
    Object localObject = this.Abp;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).erh();
      if (localObject != null) {
        ((cru)localObject).nickname = paramString;
      }
    }
    eqY();
    AppMethodBeat.o(200560);
  }
  
  public void aGj()
  {
    AppMethodBeat.i(200563);
    Object localObject = this.Abp;
    if (localObject != null) {}
    for (localObject = ((MultiTaskInfo)localObject).field_id;; localObject = null)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onExitPage, type:", new Object[] { localObject });
      localObject = this.Abr;
      if (localObject != null)
      {
        localObject = ((crt)localObject).MwN;
        if ((localObject != null) && (cl.aWA() >= ((crr)localObject).MwI)) {
          ((crr)localObject).duration += cl.aWA() - ((crr)localObject).MwI;
        }
      }
      if ((eqZ()) && (eqW())) {
        v((Runnable)new b(this));
      }
      AppMethodBeat.o(200563);
      return;
    }
  }
  
  public final void agS(String paramString)
  {
    AppMethodBeat.i(200559);
    Object localObject = this.Abp;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).erh();
      if (localObject != null) {
        ((cru)localObject).MwR = paramString;
      }
    }
    eqY();
    AppMethodBeat.o(200559);
  }
  
  public void ah(Bitmap paramBitmap)
  {
    AppMethodBeat.i(200569);
    if (eqW())
    {
      MultiTaskInfo localMultiTaskInfo = this.Abp;
      if (localMultiTaskInfo != null)
      {
        com.tencent.mm.plugin.multitask.d locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
        String str = localMultiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        cru localcru = localMultiTaskInfo.erh();
        p.g(localcru, "it.showData");
        locald.updateTaskInfoByBitmap(str, i, localcru, paramBitmap, localMultiTaskInfo.field_data);
        AppMethodBeat.o(200569);
        return;
      }
    }
    AppMethodBeat.o(200569);
  }
  
  public void ai(Bitmap paramBitmap)
  {
    AppMethodBeat.i(200572);
    if (bPt())
    {
      AppMethodBeat.o(200572);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "add or update taskInfo");
    MultiTaskInfo localMultiTaskInfo = era();
    if (localMultiTaskInfo != null)
    {
      ((com.tencent.mm.plugin.taskbar.d)g.ah(com.tencent.mm.plugin.taskbar.d.class)).addOrUpdateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.erh(), paramBitmap, localMultiTaskInfo.field_data);
      AppMethodBeat.o(200572);
      return;
    }
    AppMethodBeat.o(200572);
  }
  
  public Bitmap aj(Bitmap paramBitmap)
  {
    return null;
  }
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(200566);
    Log.i("MicroMsg.AbsMultiTaskHelper", "addCurrentMultiTaskInfoWithBlt, forceUpdate:".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.multitask.d locald;
    String str;
    int i;
    cru localcru;
    if (!eqW())
    {
      localObject = this.Abr;
      if (localObject != null)
      {
        localObject = ((crt)localObject).MwO;
        if (localObject != null) {
          ((crp)localObject).jii = 2L;
        }
      }
      localObject = this.Abp;
      if (localObject != null)
      {
        locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
        str = ((MultiTaskInfo)localObject).field_id;
        p.g(str, "it.field_id");
        i = ((MultiTaskInfo)localObject).field_type;
        localcru = ((MultiTaskInfo)localObject).erh();
        p.g(localcru, "it.showData");
        localObject = this.Abp;
        if (localObject != null) {}
        for (localObject = ((MultiTaskInfo)localObject).field_data;; localObject = null)
        {
          locald.addTaskInfoByBitmap(str, i, localcru, paramBitmap, (byte[])localObject, this.Abr);
          AppMethodBeat.o(200566);
          return;
        }
      }
      AppMethodBeat.o(200566);
      return;
    }
    if (!paramBoolean)
    {
      localObject = this.Abr;
      if (localObject != null)
      {
        localObject = ((crt)localObject).MwO;
        if (localObject != null) {
          ((crp)localObject).jii = 1L;
        }
      }
      ah(paramBitmap);
      AppMethodBeat.o(200566);
      return;
    }
    Object localObject = this.Abr;
    if (localObject != null)
    {
      localObject = ((crt)localObject).MwO;
      if (localObject != null) {
        ((crp)localObject).jii = 1L;
      }
    }
    localObject = this.Abp;
    if (localObject != null)
    {
      locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
      str = ((MultiTaskInfo)localObject).field_id;
      p.g(str, "it.field_id");
      i = ((MultiTaskInfo)localObject).field_type;
      localcru = ((MultiTaskInfo)localObject).erh();
      p.g(localcru, "it.showData");
      locald.addTaskInfoByBitmap(str, i, localcru, paramBitmap, ((MultiTaskInfo)localObject).field_data, this.Abr);
      AppMethodBeat.o(200566);
      return;
    }
    AppMethodBeat.o(200566);
  }
  
  public void bCA()
  {
    AppMethodBeat.i(200562);
    Object localObject = this.Abp;
    if (localObject != null) {}
    for (localObject = ((MultiTaskInfo)localObject).field_id;; localObject = null)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onEnterPage, type:", new Object[] { localObject });
      localObject = this.Abr;
      if (localObject == null) {
        break;
      }
      localObject = ((crt)localObject).MwN;
      if (localObject == null) {
        break;
      }
      ((crr)localObject).MwI = cl.aWA();
      AppMethodBeat.o(200562);
      return;
    }
    AppMethodBeat.o(200562);
  }
  
  public boolean bPp()
  {
    return false;
  }
  
  public boolean bPq()
  {
    return false;
  }
  
  public boolean bPr()
  {
    return true;
  }
  
  public boolean bPs()
  {
    return false;
  }
  
  public boolean bPt()
  {
    return false;
  }
  
  public void bPu() {}
  
  public final void c(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(200574);
    if (bPt())
    {
      AppMethodBeat.o(200574);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "updateCurrentHistoryTaskInfo");
    MultiTaskInfo localMultiTaskInfo = era();
    if (localMultiTaskInfo != null)
    {
      ((com.tencent.mm.plugin.taskbar.d)g.ah(com.tencent.mm.plugin.taskbar.d.class)).updateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.erh(), paramBitmap, localMultiTaskInfo.field_data, paramBoolean);
      AppMethodBeat.o(200574);
      return;
    }
    AppMethodBeat.o(200574);
  }
  
  public void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(200576);
    if (bPt())
    {
      AppMethodBeat.o(200576);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "ended, remove historyTaskInfo");
      erc();
      AppMethodBeat.o(200576);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "not ended update historyTaskInfo");
    c(paramBitmap, false);
    AppMethodBeat.o(200576);
  }
  
  public boolean dki()
  {
    return false;
  }
  
  public void dkj()
  {
    AppMethodBeat.i(200571);
    ai(null);
    AppMethodBeat.o(200571);
  }
  
  public final MultiTaskInfo eqN()
  {
    return this.Abp;
  }
  
  public boolean eqO()
  {
    return true;
  }
  
  public boolean eqP()
  {
    return false;
  }
  
  public String eqQ()
  {
    return null;
  }
  
  public int eqR()
  {
    return -1;
  }
  
  public boolean eqS()
  {
    return false;
  }
  
  public void eqT() {}
  
  public long eqU()
  {
    return 500L;
  }
  
  public Bitmap eqV()
  {
    return null;
  }
  
  public final boolean eqW()
  {
    AppMethodBeat.i(200565);
    MultiTaskInfo localMultiTaskInfo = this.Abp;
    if (localMultiTaskInfo != null)
    {
      boolean bool = ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).hasTaskInfo(localMultiTaskInfo);
      AppMethodBeat.o(200565);
      return bool;
    }
    AppMethodBeat.o(200565);
    return false;
  }
  
  public void eqX()
  {
    AppMethodBeat.i(200567);
    if (eqW())
    {
      MultiTaskInfo localMultiTaskInfo = this.Abp;
      if (localMultiTaskInfo != null)
      {
        com.tencent.mm.plugin.multitask.d locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
        String str = localMultiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        cru localcru = localMultiTaskInfo.erh();
        p.g(localcru, "it.showData");
        locald.updateTaskInfoByBitmap(str, i, localcru, null, localMultiTaskInfo.field_data);
        AppMethodBeat.o(200567);
        return;
      }
    }
    AppMethodBeat.o(200567);
  }
  
  public boolean eqZ()
  {
    return false;
  }
  
  public MultiTaskInfo era()
  {
    return this.Abp;
  }
  
  public boolean erb()
  {
    return true;
  }
  
  public final void erc()
  {
    AppMethodBeat.i(200575);
    if (bPt())
    {
      AppMethodBeat.o(200575);
      return;
    }
    MultiTaskInfo localMultiTaskInfo = era();
    if (localMultiTaskInfo != null)
    {
      ((com.tencent.mm.plugin.taskbar.d)g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 2);
      AppMethodBeat.o(200575);
      return;
    }
    AppMethodBeat.o(200575);
  }
  
  public final crt gEY()
  {
    return this.Abr;
  }
  
  public String getPosition()
  {
    return null;
  }
  
  public void ib(boolean paramBoolean) {}
  
  public void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(200570);
    ib(paramBoolean);
    AppMethodBeat.o(200570);
  }
  
  public final void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(200577);
    p.h(paramRunnable, "runnable");
    h.RTc.e(paramRunnable, this.Abs);
    AppMethodBeat.o(200577);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(200557);
      ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).reportMultiTaskInfo(2, this.Abv.Abr);
      AppMethodBeat.o(200557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.a
 * JD-Core Version:    0.7.0.1
 */