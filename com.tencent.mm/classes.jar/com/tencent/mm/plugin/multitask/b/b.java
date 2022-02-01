package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crt;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "", "()Z", "isFromTaskBar", "()Ljava/lang/Boolean;", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentHistoryMultiTaskInfo", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"})
public abstract interface b
{
  public static final b.a Abw = b.a.Abx;
  
  public abstract String RK(int paramInt);
  
  public abstract void ah(Bitmap paramBitmap);
  
  public abstract Bitmap aj(Bitmap paramBitmap);
  
  public abstract boolean bPq();
  
  public abstract void bPu();
  
  public abstract MultiTaskInfo eqN();
  
  public abstract boolean eqP();
  
  public abstract String eqQ();
  
  public abstract boolean eqS();
  
  public abstract void eqT();
  
  public abstract Bitmap eqV();
  
  public abstract boolean eqW();
  
  public abstract boolean eqZ();
  
  public abstract crt gEY();
  
  public abstract String getPosition();
  
  public abstract void ic(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.b
 * JD-Core Version:    0.7.0.1
 */