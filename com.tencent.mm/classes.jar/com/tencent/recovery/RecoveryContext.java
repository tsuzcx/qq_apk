package com.tencent.recovery;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class RecoveryContext
{
  private static final String TAG = "Recovery.RecoveryContext";
  public ArrayList<RecoveryStatusItem> exceptionItemList = new ArrayList();
  
  protected final void addExceptionItem(RecoveryStatusItem paramRecoveryStatusItem)
  {
    if (this.exceptionItemList.size() > 15) {
      this.exceptionItemList.remove(0);
    }
    this.exceptionItemList.add(paramRecoveryStatusItem);
  }
  
  protected final void clear()
  {
    RecoveryLog.i("Recovery.RecoveryContext", "clear", new Object[0]);
    this.exceptionItemList.clear();
  }
  
  protected final void readFromSp(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences.contains("KeyHistoryExceptionTypeList"))
    {
      paramSharedPreferences = paramSharedPreferences.getString("KeyHistoryExceptionTypeList", "").split(";");
      if ((paramSharedPreferences != null) && (paramSharedPreferences.length > 0))
      {
        int j = paramSharedPreferences.length;
        int i = 0;
        while (i < j)
        {
          String str = paramSharedPreferences[i];
          RecoveryStatusItem localRecoveryStatusItem = new RecoveryStatusItem();
          if (localRecoveryStatusItem.parseFromString(str)) {
            this.exceptionItemList.add(localRecoveryStatusItem);
          }
          i += 1;
        }
      }
    }
    RecoveryLog.i("Recovery.RecoveryContext", "RecoveryContext readFromSp %s", new Object[] { toString() });
  }
  
  protected final void saveToSp(SharedPreferences.Editor paramEditor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.exceptionItemList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((RecoveryStatusItem)localIterator.next()).toSaveString());
      localStringBuffer.append(";");
    }
    localStringBuffer.trimToSize();
    if (localStringBuffer.length() > 0) {
      paramEditor.putString("KeyHistoryExceptionTypeList", localStringBuffer.toString());
    }
    for (;;)
    {
      RecoveryLog.i("Recovery.RecoveryContext", "RecoveryContext saveToSp %s", new Object[] { toString() });
      return;
      paramEditor.remove("KeyHistoryExceptionTypeList");
    }
  }
  
  public final String toString()
  {
    return this.exceptionItemList.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.RecoveryContext
 * JD-Core Version:    0.7.0.1
 */