package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/IPluginMultiTask;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "addTaskInfo", "", "id", "", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "reportdata", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "addTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "getMultiTaskFloatBallPosition", "Landroid/graphics/Point;", "getMultiTaskInfoList", "callback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getMultiTaskItemPosition", "curPos", "way", "getTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getTaskInfoByType", "", "hasTaskInfo", "", "multiTaskInfo", "isDataEmpty", "isMultiTaskMode", "registerMultiTaskUIC", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "removeTaskInfoAndCoverImg", "reportMultiTaskInfo", "reportType", "multiTaskReportData", "sendMultiTaskEvent", "eventType", "updateTaskInfoByBitmap", "updateTaskInfoByTitle", "Companion", "plugin-multitask_release"})
public abstract interface d
  extends com.tencent.mm.kernel.b.a
{
  public static final d.a FER = d.a.FES;
  
  public abstract void addTaskInfo(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte, daq paramdaq);
  
  public abstract void addTaskInfoByBitmap(String paramString, int paramInt, dar paramdar, Bitmap paramBitmap, byte[] paramArrayOfByte, daq paramdaq);
  
  public abstract Point getMultiTaskFloatBallPosition();
  
  public abstract void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a parama);
  
  public abstract String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2);
  
  public abstract MultiTaskInfo getTaskInfoById(String paramString);
  
  public abstract List<MultiTaskInfo> getTaskInfoByType(int paramInt);
  
  public abstract boolean hasTaskInfo(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract boolean isDataEmpty();
  
  public abstract boolean isMultiTaskMode();
  
  public abstract void registerMultiTaskUIC(int paramInt, Class<? extends c> paramClass);
  
  public abstract void removeTaskInfoAndCoverImg(String paramString);
  
  public abstract void reportMultiTaskInfo(int paramInt, daq paramdaq);
  
  public abstract void sendMultiTaskEvent(int paramInt1, String paramString, int paramInt2);
  
  public abstract void updateTaskInfoByBitmap(String paramString, int paramInt, dar paramdar, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  public abstract void updateTaskInfoByTitle(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte);
  
  @l(iBK={1, 1, 16})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.d
 * JD-Core Version:    0.7.0.1
 */