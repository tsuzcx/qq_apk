package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.c;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "()V", "THREAD_LOOP_TAG", "", "canScrollHorizontal", "", "getCanScrollHorizontal", "()Ljava/lang/Boolean;", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "()Z", "isFromTaskBar", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "minusScreenType", "", "getMinusScreenType", "()I", "setMinusScreenType", "(I)V", "multiTaskItemPos", "getMultiTaskItemPos", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "runTask", "runnable", "Ljava/lang/Runnable;", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"})
public class a
  implements b
{
  public static final a.a FHi;
  public MultiTaskInfo FHd;
  private aco FHe;
  daq FHf;
  private final String FHg = "MultiTasklLoopTag";
  private int FHh;
  
  static
  {
    AppMethodBeat.i(247634);
    FHi = new a.a((byte)0);
    AppMethodBeat.o(247634);
  }
  
  public static void a(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(247609);
    ((d)com.tencent.mm.kernel.h.ag(d.class)).getMultiTaskInfoList(parama);
    AppMethodBeat.o(247609);
  }
  
  private void faS()
  {
    AppMethodBeat.i(247613);
    if (faQ())
    {
      MultiTaskInfo localMultiTaskInfo = this.FHd;
      if (localMultiTaskInfo != null)
      {
        d locald = (d)com.tencent.mm.kernel.h.ag(d.class);
        String str = localMultiTaskInfo.field_id;
        p.j(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        dar localdar = localMultiTaskInfo.fbc();
        p.j(localdar, "it.showData");
        locald.updateTaskInfoByTitle(str, i, localdar, localMultiTaskInfo.field_data);
        AppMethodBeat.o(247613);
        return;
      }
    }
    AppMethodBeat.o(247613);
  }
  
  public void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(247604);
    this.FHd = new MultiTaskInfo();
    MultiTaskInfo localMultiTaskInfo = this.FHd;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_updateTime = cm.bfE();
    }
    localMultiTaskInfo = this.FHd;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_id = paramString;
    }
    paramString = this.FHd;
    if (paramString != null) {
      paramString.field_type = paramInt;
    }
    this.FHh = paramInt;
    this.FHf = new daq();
    paramString = this.FHf;
    if (paramString != null) {
      paramString.THY = new dak();
    }
    paramString = this.FHf;
    if (paramString != null) {
      paramString.THX = new dam();
    }
    paramString = this.FHf;
    if (paramString != null) {
      paramString.THZ = new dao();
    }
    paramString = this.FHf;
    if (paramString != null) {
      paramString.TIa = new dap();
    }
    paramString = this.FHf;
    if (paramString != null)
    {
      paramString = paramString.TIa;
      if (paramString != null)
      {
        paramString.THV = true;
        AppMethodBeat.o(247604);
        return;
      }
    }
    AppMethodBeat.o(247604);
  }
  
  public boolean Q(int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  public final String Ya(int paramInt)
  {
    AppMethodBeat.i(247627);
    Object localObject2 = this.FHd;
    if (localObject2 != null)
    {
      Object localObject1 = (d)com.tencent.mm.kernel.h.ag(d.class);
      localObject2 = ((MultiTaskInfo)localObject2).field_id;
      p.j(localObject2, "it.field_id");
      localObject1 = ((d)localObject1).getMultiTaskItemPosition((String)localObject2, faL(), paramInt);
      AppMethodBeat.o(247627);
      return localObject1;
    }
    AppMethodBeat.o(247627);
    return "";
  }
  
  public final void a(aco paramaco)
  {
    this.FHe = paramaco;
  }
  
  public final void aMT(String paramString)
  {
    AppMethodBeat.i(247601);
    Object localObject = this.FHd;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).fbc();
      if (localObject != null) {
        ((dar)localObject).title = paramString;
      }
    }
    faS();
    AppMethodBeat.o(247601);
  }
  
  public void aOj()
  {
    AppMethodBeat.i(247608);
    Object localObject = this.FHd;
    if (localObject != null) {}
    for (localObject = ((MultiTaskInfo)localObject).field_id;; localObject = null)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onExitPage, type:", new Object[] { localObject });
      localObject = this.FHf;
      if (localObject != null)
      {
        localObject = ((daq)localObject).THX;
        if ((localObject != null) && (cm.bfE() >= ((dam)localObject).THL)) {
          ((dam)localObject).duration += cm.bfE() - ((dam)localObject).THL;
        }
      }
      if ((faT()) && (faQ())) {
        u((Runnable)new b(this));
      }
      AppMethodBeat.o(247608);
      return;
    }
  }
  
  public final void aQZ(String paramString)
  {
    AppMethodBeat.i(247603);
    Object localObject = this.FHd;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).fbc();
      if (localObject != null) {
        ((dar)localObject).nickname = paramString;
      }
    }
    faS();
    AppMethodBeat.o(247603);
  }
  
  public Bitmap ae(Bitmap paramBitmap)
  {
    return null;
  }
  
  public void af(Bitmap paramBitmap)
  {
    AppMethodBeat.i(247614);
    MultiTaskInfo localMultiTaskInfo = this.FHd;
    if (localMultiTaskInfo != null)
    {
      d locald = (d)com.tencent.mm.kernel.h.ag(d.class);
      String str = localMultiTaskInfo.field_id;
      p.j(str, "it.field_id");
      int i = localMultiTaskInfo.field_type;
      dar localdar = localMultiTaskInfo.fbc();
      p.j(localdar, "it.showData");
      locald.updateTaskInfoByBitmap(str, i, localdar, paramBitmap, localMultiTaskInfo.field_data);
      AppMethodBeat.o(247614);
      return;
    }
    AppMethodBeat.o(247614);
  }
  
  public void ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(247625);
    if (cbK())
    {
      AppMethodBeat.o(247625);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "add or update taskInfo");
    MultiTaskInfo localMultiTaskInfo = faU();
    if (localMultiTaskInfo != null)
    {
      ((c)com.tencent.mm.kernel.h.ag(c.class)).addOrUpdateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.fbc(), paramBitmap, localMultiTaskInfo.field_data);
      AppMethodBeat.o(247625);
      return;
    }
    AppMethodBeat.o(247625);
  }
  
  public final void aox(String paramString)
  {
    AppMethodBeat.i(247602);
    Object localObject = this.FHd;
    if (localObject != null)
    {
      localObject = ((MultiTaskInfo)localObject).fbc();
      if (localObject != null) {
        ((dar)localObject).TIg = paramString;
      }
    }
    faS();
    AppMethodBeat.o(247602);
  }
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(247611);
    Log.i("MicroMsg.AbsMultiTaskHelper", "addCurrentMultiTaskInfoWithBlt, forceUpdate:".concat(String.valueOf(paramBoolean)));
    d locald;
    String str;
    int i;
    dar localdar;
    if (!faQ())
    {
      localObject = this.FHf;
      if (localObject != null)
      {
        localObject = ((daq)localObject).THY;
        if (localObject != null) {
          ((dak)localObject).status = 2L;
        }
      }
      localObject = this.FHd;
      if (localObject != null)
      {
        locald = (d)com.tencent.mm.kernel.h.ag(d.class);
        str = ((MultiTaskInfo)localObject).field_id;
        p.j(str, "it.field_id");
        i = ((MultiTaskInfo)localObject).field_type;
        localdar = ((MultiTaskInfo)localObject).fbc();
        p.j(localdar, "it.showData");
        localObject = this.FHd;
        if (localObject != null) {}
        for (localObject = ((MultiTaskInfo)localObject).field_data;; localObject = null)
        {
          locald.addTaskInfoByBitmap(str, i, localdar, paramBitmap, (byte[])localObject, this.FHf);
          AppMethodBeat.o(247611);
          return;
        }
      }
      AppMethodBeat.o(247611);
      return;
    }
    if (!paramBoolean)
    {
      localObject = this.FHf;
      if (localObject != null)
      {
        localObject = ((daq)localObject).THY;
        if (localObject != null) {
          ((dak)localObject).status = 1L;
        }
      }
      af(paramBitmap);
      AppMethodBeat.o(247611);
      return;
    }
    Object localObject = this.FHf;
    if (localObject != null)
    {
      localObject = ((daq)localObject).THY;
      if (localObject != null) {
        ((dak)localObject).status = 1L;
      }
    }
    localObject = this.FHd;
    if (localObject != null)
    {
      locald = (d)com.tencent.mm.kernel.h.ag(d.class);
      str = ((MultiTaskInfo)localObject).field_id;
      p.j(str, "it.field_id");
      i = ((MultiTaskInfo)localObject).field_type;
      localdar = ((MultiTaskInfo)localObject).fbc();
      p.j(localdar, "it.showData");
      locald.addTaskInfoByBitmap(str, i, localdar, paramBitmap, ((MultiTaskInfo)localObject).field_data, this.FHf);
      AppMethodBeat.o(247611);
      return;
    }
    AppMethodBeat.o(247611);
  }
  
  public void b(aco paramaco) {}
  
  public void bNV()
  {
    AppMethodBeat.i(247607);
    Object localObject = this.FHd;
    if (localObject != null) {}
    for (localObject = ((MultiTaskInfo)localObject).field_id;; localObject = null)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onEnterPage, type:", new Object[] { localObject });
      localObject = this.FHf;
      if (localObject == null) {
        break;
      }
      localObject = ((daq)localObject).THX;
      if (localObject == null) {
        break;
      }
      ((dam)localObject).THL = cm.bfE();
      AppMethodBeat.o(247607);
      return;
    }
    AppMethodBeat.o(247607);
  }
  
  public final void c(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(247628);
    if (cbK())
    {
      AppMethodBeat.o(247628);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "updateCurrentHistoryTaskInfo");
    MultiTaskInfo localMultiTaskInfo = faU();
    if (localMultiTaskInfo != null)
    {
      ((c)com.tencent.mm.kernel.h.ag(c.class)).updateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.fbc(), paramBitmap, localMultiTaskInfo.field_data, paramBoolean);
      AppMethodBeat.o(247628);
      return;
    }
    AppMethodBeat.o(247628);
  }
  
  public boolean cbG()
  {
    return false;
  }
  
  public boolean cbH()
  {
    return false;
  }
  
  public boolean cbI()
  {
    return true;
  }
  
  public boolean cbJ()
  {
    return false;
  }
  
  public boolean cbK()
  {
    return false;
  }
  
  public void cbL() {}
  
  public void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(247630);
    if (cbK())
    {
      AppMethodBeat.o(247630);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "ended, remove historyTaskInfo");
      faW();
      AppMethodBeat.o(247630);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "not ended update historyTaskInfo");
    c(paramBitmap, false);
    AppMethodBeat.o(247630);
  }
  
  public boolean dJN()
  {
    return false;
  }
  
  public void dJO()
  {
    AppMethodBeat.i(247623);
    ag(null);
    AppMethodBeat.o(247623);
  }
  
  public final MultiTaskInfo faE()
  {
    return this.FHd;
  }
  
  public final aco faF()
  {
    return this.FHe;
  }
  
  public final daq faG()
  {
    return this.FHf;
  }
  
  public boolean faH()
  {
    return true;
  }
  
  public boolean faI()
  {
    return false;
  }
  
  public Boolean faJ()
  {
    return Boolean.FALSE;
  }
  
  public String faK()
  {
    return null;
  }
  
  public int faL()
  {
    return -1;
  }
  
  public boolean faM()
  {
    return false;
  }
  
  public void faN() {}
  
  public long faO()
  {
    return 500L;
  }
  
  public Bitmap faP()
  {
    return null;
  }
  
  public final boolean faQ()
  {
    AppMethodBeat.i(247610);
    MultiTaskInfo localMultiTaskInfo = this.FHd;
    if (localMultiTaskInfo != null)
    {
      boolean bool = ((d)com.tencent.mm.kernel.h.ag(d.class)).hasTaskInfo(localMultiTaskInfo);
      AppMethodBeat.o(247610);
      return bool;
    }
    AppMethodBeat.o(247610);
    return false;
  }
  
  public void faR()
  {
    AppMethodBeat.i(247612);
    if (faQ())
    {
      MultiTaskInfo localMultiTaskInfo = this.FHd;
      if (localMultiTaskInfo != null)
      {
        d locald = (d)com.tencent.mm.kernel.h.ag(d.class);
        String str = localMultiTaskInfo.field_id;
        p.j(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        dar localdar = localMultiTaskInfo.fbc();
        p.j(localdar, "it.showData");
        locald.updateTaskInfoByBitmap(str, i, localdar, null, localMultiTaskInfo.field_data);
        AppMethodBeat.o(247612);
        return;
      }
    }
    AppMethodBeat.o(247612);
  }
  
  public boolean faT()
  {
    return false;
  }
  
  public MultiTaskInfo faU()
  {
    return this.FHd;
  }
  
  public boolean faV()
  {
    return true;
  }
  
  public final void faW()
  {
    AppMethodBeat.i(247629);
    if (cbK())
    {
      AppMethodBeat.o(247629);
      return;
    }
    MultiTaskInfo localMultiTaskInfo = faU();
    if (localMultiTaskInfo != null)
    {
      ((c)com.tencent.mm.kernel.h.ag(c.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 2);
      AppMethodBeat.o(247629);
      return;
    }
    AppMethodBeat.o(247629);
  }
  
  public String getPosition()
  {
    return null;
  }
  
  public void iV(boolean paramBoolean) {}
  
  public void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(247615);
    iV(paramBoolean);
    AppMethodBeat.o(247615);
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(247631);
    p.k(paramRunnable, "runnable");
    com.tencent.e.h.ZvG.g(paramRunnable, this.FHg);
    AppMethodBeat.o(247631);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(247596);
      ((d)com.tencent.mm.kernel.h.ag(d.class)).reportMultiTaskInfo(2, this.FHj.FHf);
      AppMethodBeat.o(247596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.a
 * JD-Core Version:    0.7.0.1
 */