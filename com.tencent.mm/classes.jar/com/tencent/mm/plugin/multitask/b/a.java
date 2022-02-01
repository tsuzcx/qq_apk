package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.c;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "()V", "THREAD_LOOP_TAG", "", "canScrollHorizontal", "", "getCanScrollHorizontal", "()Ljava/lang/Boolean;", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "()Z", "isFromTaskBar", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "minusScreenType", "", "getMinusScreenType", "()I", "setMinusScreenType", "(I)V", "multiTaskItemPos", "getMultiTaskItemPos", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "runTask", "runnable", "Ljava/lang/Runnable;", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements b
{
  public static final a.a LCD;
  public MultiTaskInfo LCE;
  private aet LCF;
  dry LCG;
  private final String LCH = "MultiTasklLoopTag";
  private int LCI;
  
  static
  {
    AppMethodBeat.i(303849);
    LCD = new a.a((byte)0);
    AppMethodBeat.o(303849);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(303844);
    s.u(parama, "this$0");
    ((d)com.tencent.mm.kernel.h.az(d.class)).reportMultiTaskInfo(2, parama.LCG);
    AppMethodBeat.o(303844);
  }
  
  public static void a(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(303830);
    ((d)com.tencent.mm.kernel.h.az(d.class)).getMultiTaskInfoList(parama);
    AppMethodBeat.o(303830);
  }
  
  private void gjX()
  {
    AppMethodBeat.i(303838);
    if (gjV())
    {
      MultiTaskInfo localMultiTaskInfo = this.LCE;
      if (localMultiTaskInfo != null)
      {
        d locald = (d)com.tencent.mm.kernel.h.az(d.class);
        String str = localMultiTaskInfo.field_id;
        s.s(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        drz localdrz = localMultiTaskInfo.gkh();
        s.s(localdrz, "it.showData");
        locald.updateTaskInfoByTitle(str, i, localdrz, localMultiTaskInfo.field_data);
      }
    }
    AppMethodBeat.o(303838);
  }
  
  public static boolean gjY()
  {
    return true;
  }
  
  public void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(303896);
    this.LCE = new MultiTaskInfo();
    MultiTaskInfo localMultiTaskInfo = this.LCE;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_updateTime = cn.bDw();
    }
    localMultiTaskInfo = this.LCE;
    if (localMultiTaskInfo != null) {
      localMultiTaskInfo.field_id = paramString;
    }
    paramString = this.LCE;
    if (paramString != null) {
      paramString.field_type = paramInt;
    }
    this.LCI = paramInt;
    this.LCG = new dry();
    paramString = this.LCG;
    if (paramString != null) {
      paramString.aaXH = new drs();
    }
    paramString = this.LCG;
    if (paramString != null) {
      paramString.aaXG = new dru();
    }
    paramString = this.LCG;
    if (paramString != null) {
      paramString.aaXI = new drw();
    }
    paramString = this.LCG;
    if (paramString != null) {
      paramString.aaXJ = new drx();
    }
    paramString = this.LCG;
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.aaXJ)
    {
      if (paramString != null) {
        paramString.aaXE = true;
      }
      AppMethodBeat.o(303896);
      return;
    }
  }
  
  public final void a(aet paramaet)
  {
    this.LCF = paramaet;
  }
  
  public final void aNR(String paramString)
  {
    AppMethodBeat.i(303891);
    Object localObject = this.LCE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MultiTaskInfo)localObject).gkh())
    {
      if (localObject != null) {
        ((drz)localObject).nickname = paramString;
      }
      gjX();
      AppMethodBeat.o(303891);
      return;
    }
  }
  
  public final String acn(int paramInt)
  {
    AppMethodBeat.i(304078);
    Object localObject2 = this.LCE;
    if (localObject2 != null)
    {
      Object localObject1 = (d)com.tencent.mm.kernel.h.az(d.class);
      localObject2 = ((MultiTaskInfo)localObject2).field_id;
      s.s(localObject2, "it.field_id");
      localObject1 = ((d)localObject1).getMultiTaskItemPosition((String)localObject2, gjQ(), paramInt);
      AppMethodBeat.o(304078);
      return localObject1;
    }
    AppMethodBeat.o(304078);
    return "";
  }
  
  public boolean af(int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  public final void ahT(String paramString)
  {
    AppMethodBeat.i(303888);
    Object localObject = this.LCE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MultiTaskInfo)localObject).gkh())
    {
      if (localObject != null) {
        ((drz)localObject).aaXP = paramString;
      }
      gjX();
      AppMethodBeat.o(303888);
      return;
    }
  }
  
  public Bitmap aq(Bitmap paramBitmap)
  {
    return null;
  }
  
  public void ar(Bitmap paramBitmap)
  {
    AppMethodBeat.i(304022);
    MultiTaskInfo localMultiTaskInfo = this.LCE;
    if (localMultiTaskInfo != null)
    {
      d locald = (d)com.tencent.mm.kernel.h.az(d.class);
      String str = localMultiTaskInfo.field_id;
      s.s(str, "it.field_id");
      int i = localMultiTaskInfo.field_type;
      drz localdrz = localMultiTaskInfo.gkh();
      s.s(localdrz, "it.showData");
      locald.updateTaskInfoByBitmap(str, i, localdrz, paramBitmap, localMultiTaskInfo.field_data);
    }
    AppMethodBeat.o(304022);
  }
  
  public void as(Bitmap paramBitmap)
  {
    AppMethodBeat.i(304074);
    if (cCd())
    {
      AppMethodBeat.o(304074);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "add or update taskInfo");
    MultiTaskInfo localMultiTaskInfo = gka();
    if (localMultiTaskInfo != null) {
      ((c)com.tencent.mm.kernel.h.az(c.class)).addOrUpdateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.gkh(), paramBitmap, localMultiTaskInfo.field_data);
    }
    AppMethodBeat.o(304074);
  }
  
  public void b(aet paramaet) {}
  
  public void bhW()
  {
    AppMethodBeat.i(303977);
    Object localObject = this.LCE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MultiTaskInfo)localObject).field_id)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onExitPage, type:", new Object[] { localObject });
      localObject = this.LCG;
      if (localObject != null)
      {
        localObject = ((dry)localObject).aaXG;
        if ((localObject != null) && (cn.bDw() >= ((dru)localObject).aaXu)) {
          ((dru)localObject).duration += cn.bDw() - ((dru)localObject).aaXu;
        }
      }
      if ((gjZ()) && (gjV())) {
        y(new a..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(303977);
      return;
    }
  }
  
  public final void c(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(304010);
    Log.i("MicroMsg.AbsMultiTaskHelper", s.X("addCurrentMultiTaskInfoWithBlt, forceUpdate:", Boolean.valueOf(paramBoolean)));
    Object localObject4;
    int i;
    if (!gjV())
    {
      localObject1 = this.LCG;
      drz localdrz;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((drs)localObject1).status = 2L;
        }
        localObject1 = this.LCE;
        if (localObject1 == null) {
          break label332;
        }
        localObject3 = (d)com.tencent.mm.kernel.h.az(d.class);
        localObject4 = ((MultiTaskInfo)localObject1).field_id;
        s.s(localObject4, "it.field_id");
        i = ((MultiTaskInfo)localObject1).field_type;
        localdrz = ((MultiTaskInfo)localObject1).gkh();
        s.s(localdrz, "it.showData");
        localObject1 = this.LCE;
        if (localObject1 != null) {
          break label171;
        }
      }
      label171:
      for (localObject1 = localObject2;; localObject1 = ((MultiTaskInfo)localObject1).field_data)
      {
        ((d)localObject3).addTaskInfoByBitmap((String)localObject4, i, localdrz, paramBitmap, (byte[])localObject1, this.LCG);
        AppMethodBeat.o(304010);
        return;
        localObject1 = ((dry)localObject1).aaXH;
        break;
      }
    }
    else
    {
      if (!paramBoolean)
      {
        localObject2 = this.LCG;
        if (localObject2 == null) {}
        for (;;)
        {
          if (localObject1 != null) {
            ((drs)localObject1).status = 1L;
          }
          ar(paramBitmap);
          AppMethodBeat.o(304010);
          return;
          localObject1 = ((dry)localObject2).aaXH;
        }
      }
      localObject1 = this.LCG;
      if (localObject1 != null) {
        break label339;
      }
    }
    label332:
    label339:
    for (localObject1 = localObject3;; localObject1 = ((dry)localObject1).aaXH)
    {
      if (localObject1 != null) {
        ((drs)localObject1).status = 1L;
      }
      localObject1 = this.LCE;
      if (localObject1 != null)
      {
        localObject2 = (d)com.tencent.mm.kernel.h.az(d.class);
        localObject3 = ((MultiTaskInfo)localObject1).field_id;
        s.s(localObject3, "it.field_id");
        i = ((MultiTaskInfo)localObject1).field_type;
        localObject4 = ((MultiTaskInfo)localObject1).gkh();
        s.s(localObject4, "it.showData");
        ((d)localObject2).addTaskInfoByBitmap((String)localObject3, i, (drz)localObject4, paramBitmap, ((MultiTaskInfo)localObject1).field_data, this.LCG);
      }
      AppMethodBeat.o(304010);
      return;
    }
  }
  
  public boolean cBZ()
  {
    return false;
  }
  
  public boolean cCa()
  {
    return false;
  }
  
  public boolean cCb()
  {
    return true;
  }
  
  public boolean cCc()
  {
    return false;
  }
  
  public boolean cCd()
  {
    return false;
  }
  
  public void cCe() {}
  
  public void coi()
  {
    AppMethodBeat.i(303967);
    Object localObject = this.LCE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MultiTaskInfo)localObject).field_id)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "onEnterPage, type:", new Object[] { localObject });
      localObject = this.LCG;
      if (localObject != null)
      {
        localObject = ((dry)localObject).aaXG;
        if (localObject != null) {
          ((dru)localObject).aaXu = cn.bDw();
        }
      }
      AppMethodBeat.o(303967);
      return;
    }
  }
  
  public final void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(304084);
    if (cCd())
    {
      AppMethodBeat.o(304084);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "updateCurrentHistoryTaskInfo");
    MultiTaskInfo localMultiTaskInfo = gka();
    if (localMultiTaskInfo != null) {
      ((c)com.tencent.mm.kernel.h.az(c.class)).updateTaskInfoByBitmap(localMultiTaskInfo.field_id, localMultiTaskInfo.field_type, localMultiTaskInfo.gkh(), paramBitmap, localMultiTaskInfo.field_data, paramBoolean);
    }
    AppMethodBeat.o(304084);
  }
  
  public void e(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(304098);
    if (cCd())
    {
      AppMethodBeat.o(304098);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.AbsMultiTaskHelper", "ended, remove historyTaskInfo");
      gkb();
      AppMethodBeat.o(304098);
      return;
    }
    Log.i("MicroMsg.AbsMultiTaskHelper", "not ended update historyTaskInfo");
    d(paramBitmap, false);
    AppMethodBeat.o(304098);
  }
  
  public boolean eCI()
  {
    return false;
  }
  
  public void eCK()
  {
    AppMethodBeat.i(304065);
    as(null);
    AppMethodBeat.o(304065);
  }
  
  public boolean evu()
  {
    return true;
  }
  
  public String getPosition()
  {
    return null;
  }
  
  public final MultiTaskInfo gjJ()
  {
    return this.LCE;
  }
  
  public final aet gjK()
  {
    return this.LCF;
  }
  
  public final dry gjL()
  {
    return this.LCG;
  }
  
  public boolean gjM()
  {
    return true;
  }
  
  public boolean gjN()
  {
    return false;
  }
  
  public Boolean gjO()
  {
    return Boolean.FALSE;
  }
  
  public String gjP()
  {
    return null;
  }
  
  public int gjQ()
  {
    return -1;
  }
  
  public boolean gjR()
  {
    return false;
  }
  
  public void gjS() {}
  
  public long gjT()
  {
    return 500L;
  }
  
  public Bitmap gjU()
  {
    return null;
  }
  
  public final boolean gjV()
  {
    AppMethodBeat.i(303999);
    MultiTaskInfo localMultiTaskInfo = this.LCE;
    if (localMultiTaskInfo != null)
    {
      boolean bool = ((d)com.tencent.mm.kernel.h.az(d.class)).hasTaskInfo(localMultiTaskInfo);
      AppMethodBeat.o(303999);
      return bool;
    }
    AppMethodBeat.o(303999);
    return false;
  }
  
  public void gjW()
  {
    AppMethodBeat.i(304018);
    if (gjV())
    {
      MultiTaskInfo localMultiTaskInfo = this.LCE;
      if (localMultiTaskInfo != null)
      {
        d locald = (d)com.tencent.mm.kernel.h.az(d.class);
        String str = localMultiTaskInfo.field_id;
        s.s(str, "it.field_id");
        int i = localMultiTaskInfo.field_type;
        drz localdrz = localMultiTaskInfo.gkh();
        s.s(localdrz, "it.showData");
        locald.updateTaskInfoByBitmap(str, i, localdrz, null, localMultiTaskInfo.field_data);
      }
    }
    AppMethodBeat.o(304018);
  }
  
  public boolean gjZ()
  {
    return false;
  }
  
  public MultiTaskInfo gka()
  {
    return this.LCE;
  }
  
  public final void gkb()
  {
    AppMethodBeat.i(304091);
    if (cCd())
    {
      AppMethodBeat.o(304091);
      return;
    }
    MultiTaskInfo localMultiTaskInfo = gka();
    if (localMultiTaskInfo != null) {
      ((c)com.tencent.mm.kernel.h.az(c.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 2);
    }
    AppMethodBeat.o(304091);
  }
  
  public void kd(boolean paramBoolean) {}
  
  public void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(304028);
    kd(paramBoolean);
    AppMethodBeat.o(304028);
  }
  
  public final void updateTitle(String paramString)
  {
    AppMethodBeat.i(303883);
    Object localObject = this.LCE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MultiTaskInfo)localObject).gkh())
    {
      if (localObject != null) {
        ((drz)localObject).title = paramString;
      }
      gjX();
      AppMethodBeat.o(303883);
      return;
    }
  }
  
  public final void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(304108);
    s.u(paramRunnable, "runnable");
    com.tencent.threadpool.h.ahAA.j(paramRunnable, this.LCH);
    AppMethodBeat.o(304108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.a
 * JD-Core Version:    0.7.0.1
 */