package com.tencent.mm.pluginsdk.model.app;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lh;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

class SubCorePluginBase$7
  extends IListener<lh>
{
  SubCorePluginBase$7(as paramas, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(244916);
    this.__eventId = lh.class.getName().hashCode();
    AppMethodBeat.o(244916);
  }
  
  private static boolean a(lh paramlh)
  {
    AppMethodBeat.i(244920);
    for (;;)
    {
      try
      {
        f localf = i.aRC();
        if (localf != null) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        int i = 0;
        continue;
      }
      paramlh.hNb.hDS = i;
      AppMethodBeat.o(244920);
      return false;
      i = Util.getInt(i.aRC().getValue("AndroidUseUnicodeEmoji"), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.SubCorePluginBase.7
 * JD-Core Version:    0.7.0.1
 */