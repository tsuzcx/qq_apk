package com.tencent.mm.sandbox.updater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
final class UpdaterService$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (UpdaterService.cqg() != null)
    {
      paramIntent = UpdaterService.cqg();
      boolean bool = aq.isWifi(paramContext);
      if (paramIntent.udD.size() > 0)
      {
        paramContext = paramIntent.udD.values().iterator();
        while (paramContext.hasNext()) {
          ((a)paramContext.next()).mo(bool);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService.a
 * JD-Core Version:    0.7.0.1
 */