package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class h$4
  extends Handler
{
  h$4(h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(310664);
    this.PRL.PRI = false;
    try
    {
      if (!this.PRL.PRH.isEmpty())
      {
        paramMessage = this.PRL.PRH.entrySet().iterator();
        while (paramMessage.hasNext())
        {
          Object localObject = (Map.Entry)paramMessage.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (ImageView)((Map.Entry)localObject).getValue();
          this.PRL.m(str, (ImageView)localObject);
        }
      }
      AppMethodBeat.o(310664);
    }
    finally
    {
      Log.e("AdLandingSocialCardComponent", "handleMessage, exp=" + paramMessage.toString());
      AppMethodBeat.o(310664);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.h.4
 * JD-Core Version:    0.7.0.1
 */