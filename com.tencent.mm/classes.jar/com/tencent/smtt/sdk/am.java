package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import java.util.Map;

class am
{
  public boolean a = false;
  public boolean b = false;
  private Map<String, String> c = null;
  
  public void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.c.put(paramString + str, String.valueOf(System.currentTimeMillis()));
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
    //   2: aload_1
    //   3: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 20	com/tencent/smtt/sdk/am:c	Ljava/util/Map;
    //   20: aload_1
    //   21: lload_2
    //   22: invokestatic 58	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: invokeinterface 64 3 0
    //   30: pop
    //   31: goto -18 -> 13
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	am
    //   0	39	1	paramString	String
    //   0	39	2	paramLong	long
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	34	finally
    //   16	31	34	finally
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Object localObject = bv.a();
        if (((bv)localObject).b())
        {
          if ((!this.b) || (!this.a))
          {
            long l = System.currentTimeMillis();
            if (l % 10L != 0L) {
              return bool;
            }
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
          paramString = ((bv)localObject).c().b();
          localObject = Integer.TYPE;
          Map localMap = this.c;
          paramString.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { localObject, Map.class }, new Object[] { Integer.valueOf(paramInt), localMap });
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.am
 * JD-Core Version:    0.7.0.1
 */