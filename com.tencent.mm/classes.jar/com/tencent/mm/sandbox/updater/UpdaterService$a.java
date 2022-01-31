package com.tencent.mm.sandbox.updater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
final class UpdaterService$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28986);
    if (UpdaterService.drX() != null)
    {
      paramIntent = UpdaterService.drX();
      boolean bool = at.isWifi(paramContext);
      if (paramIntent.ylS.size() > 0)
      {
        paramContext = paramIntent.ylS.values().iterator();
        while (paramContext.hasNext()) {
          ((a)paramContext.next()).pD(bool);
        }
      }
    }
    AppMethodBeat.o(28986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService.a
 * JD-Core Version:    0.7.0.1
 */