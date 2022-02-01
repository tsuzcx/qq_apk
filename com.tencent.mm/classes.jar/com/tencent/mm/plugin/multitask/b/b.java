package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dry;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "", "canScrollHorizontal", "", "getCanScrollHorizontal", "()Ljava/lang/Boolean;", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "()Z", "isFromTaskBar", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public static final b.a LCJ = b.a.LCK;
  
  public abstract String acn(int paramInt);
  
  public abstract Bitmap aq(Bitmap paramBitmap);
  
  public abstract void ar(Bitmap paramBitmap);
  
  public abstract boolean cCa();
  
  public abstract void cCe();
  
  public abstract String getPosition();
  
  public abstract MultiTaskInfo gjJ();
  
  public abstract dry gjL();
  
  public abstract boolean gjN();
  
  public abstract Boolean gjO();
  
  public abstract String gjP();
  
  public abstract boolean gjR();
  
  public abstract void gjS();
  
  public abstract Bitmap gjU();
  
  public abstract boolean gjV();
  
  public abstract boolean gjZ();
  
  public abstract void ke(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.b
 * JD-Core Version:    0.7.0.1
 */