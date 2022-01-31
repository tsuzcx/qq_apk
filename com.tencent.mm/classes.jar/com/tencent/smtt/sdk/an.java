package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class an
{
  public boolean a;
  public boolean b;
  private Map<String, String> c;
  
  public an()
  {
    AppMethodBeat.i(64405);
    this.a = false;
    this.b = false;
    this.c = null;
    this.c = new HashMap();
    AppMethodBeat.o(64405);
  }
  
  public JSONObject a()
  {
    AppMethodBeat.i(139267);
    JSONObject localJSONObject = new JSONObject();
    if (this.c != null) {
      try
      {
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        AppMethodBeat.o(139267);
      }
      catch (Exception localException) {}
    }
    return localJSONObject;
  }
  
  public void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139265);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(139265);
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.c.put(paramString + str, String.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(139265);
          continue;
        }
        if (paramByte != 2) {
          continue;
        }
      }
      finally {}
      String str = "_end";
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +11 -> 22
    //   14: ldc 117
    //   16: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 27	com/tencent/smtt/sdk/an:c	Ljava/util/Map;
    //   26: aload_1
    //   27: lload_2
    //   28: invokestatic 110	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   31: invokeinterface 113 3 0
    //   36: pop
    //   37: ldc 117
    //   39: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -23 -> 19
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	an
    //   0	50	1	paramString	String
    //   0	50	2	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   2	19	45	finally
    //   22	42	45	finally
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139268);
        Object localObject = bz.a();
        if (((bz)localObject).b())
        {
          if (((!this.b) || (!this.a)) && (System.currentTimeMillis() % 10L != 0L))
          {
            AppMethodBeat.o(139268);
            return bool;
          }
          this.b = true;
          this.a = true;
          this.c.put("is_first_init_tbs", String.valueOf(this.b));
          this.c.put("is_first_init_x5", String.valueOf(this.a));
          this.c.put("x5_webview_id", Integer.toString(paramInt));
          this.c.put("current_url", paramString);
          if ((QbSdk.n != null) && (QbSdk.n.containsKey("app_scene_id"))) {
            this.c.put("app_scene_id", QbSdk.n.get("app_scene_id"));
          }
          paramString = ((bz)localObject).c().b();
          localObject = Integer.TYPE;
          Map localMap = this.c;
          paramString.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { localObject, Map.class }, new Object[] { Integer.valueOf(paramInt), localMap });
          AppMethodBeat.o(139268);
          continue;
        }
        AppMethodBeat.o(139268);
      }
      finally {}
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.an
 * JD-Core Version:    0.7.0.1
 */