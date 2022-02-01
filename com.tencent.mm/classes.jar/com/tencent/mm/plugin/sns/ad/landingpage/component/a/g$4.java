package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class g$4
  extends Handler
{
  g$4(g paramg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(293082);
    this.JBA.OdH = false;
    try
    {
      if (!this.JBA.OdG.isEmpty())
      {
        paramMessage = this.JBA.OdG.entrySet().iterator();
        while (paramMessage.hasNext())
        {
          Object localObject = (Map.Entry)paramMessage.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (ImageView)((Map.Entry)localObject).getValue();
          this.JBA.k(str, (ImageView)localObject);
        }
      }
      AppMethodBeat.o(293082);
    }
    catch (Throwable paramMessage)
    {
      Log.e("AdLandingSocialCardComponent", "handleMessage, exp=" + paramMessage.toString());
      AppMethodBeat.o(293082);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.g.4
 * JD-Core Version:    0.7.0.1
 */