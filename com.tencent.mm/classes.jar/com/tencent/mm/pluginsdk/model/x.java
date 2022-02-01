package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;

public final class x
{
  private static final Map<String, Object> JVH;
  
  static
  {
    AppMethodBeat.i(133686);
    JVH = new HashMap();
    AppMethodBeat.o(133686);
  }
  
  public static void E(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133685);
    JVH.put(paramString, paramObject);
    d.initTbsSettings(JVH);
    AppMethodBeat.o(133685);
  }
  
  public static void gmG()
  {
    AppMethodBeat.i(229795);
    Log.i("MicroMsg.TBSHelper", "checkDisableSensitiveApi uin = %d", new Object[] { Integer.valueOf(a.azs()) });
    AppMethodBeat.o(229795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.x
 * JD-Core Version:    0.7.0.1
 */