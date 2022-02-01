package com.tencent.mm.plugin.taskbar;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drz;
import java.util.List;

public abstract interface c
  extends a
{
  public abstract void addOrUpdateTaskInfoByBitmap(String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  public abstract MultiTaskInfo getTaskInfoById(String paramString);
  
  public abstract List<MultiTaskInfo> getTaskInfoByType(int paramInt);
  
  public abstract void removeTaskInfo(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void updateTaskInfoByBitmap(String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.c
 * JD-Core Version:    0.7.0.1
 */