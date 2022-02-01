package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

public abstract class AbstractResultService
  extends IntentService
{
  public AbstractResultService()
  {
    super("TinkerResultService");
  }
  
  public static void a(Context paramContext, a parama, String paramString)
  {
    if (paramString == null) {
      throw new TinkerRuntimeException("resultServiceClass is null.");
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, paramString);
      localIntent.putExtra("result_extra", parama);
      paramContext.startService(localIntent);
      return;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.AbstractResultService", "run result service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      ShareTinkerLog.e("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
      return;
    }
    onPatchResult((a)ShareIntentUtil.getSerializableExtra(paramIntent, "result_extra"));
  }
  
  public abstract void onPatchResult(a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.AbstractResultService
 * JD-Core Version:    0.7.0.1
 */