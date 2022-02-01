package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static Map<String, Integer> Jzo;
  
  static
  {
    AppMethodBeat.i(264569);
    Jzo = new HashMap();
    AppMethodBeat.o(264569);
  }
  
  /* Error */
  private static boolean aYq(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 35
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +15 -> 27
    //   15: ldc 35
    //   17: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: istore_1
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: getstatic 27	com/tencent/mm/plugin/sns/ad/d/g:Jzo	Ljava/util/Map;
    //   30: aload_0
    //   31: invokeinterface 47 2 0
    //   36: ifeq +42 -> 78
    //   39: getstatic 27	com/tencent/mm/plugin/sns/ad/d/g:Jzo	Ljava/util/Map;
    //   42: aload_0
    //   43: invokeinterface 51 2 0
    //   48: checkcast 53	java/lang/Integer
    //   51: invokevirtual 57	java/lang/Integer:intValue	()I
    //   54: iconst_1
    //   55: if_icmpne +13 -> 68
    //   58: ldc 35
    //   60: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -43 -> 22
    //   68: ldc 35
    //   70: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -53 -> 22
    //   78: ldc 35
    //   80: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: istore_1
    //   85: goto -63 -> 22
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   21	64	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	20	88	finally
    //   27	63	88	finally
    //   68	73	88	finally
    //   78	83	88	finally
  }
  
  public static void f(String paramString, View paramView)
  {
    AppMethodBeat.i(264568);
    paramView.setTag(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("AdWeAppHelper", "refreshWeAppAuthIcon, weAppUserName==null");
      AppMethodBeat.o(264568);
      return;
    }
    if (aYq(paramString)) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      ((q)h.ae(q.class)).a(paramString, new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          final boolean bool = false;
          AppMethodBeat.i(264587);
          if (paramAnonymousWxaAttributes == null)
          {
            Log.e("AdWeAppHelper", "onGetWeAppInfo, info==null");
            AppMethodBeat.o(264587);
            return;
          }
          try
          {
            i = paramAnonymousWxaAttributes.bLG().obf.nYp;
            if (TextUtils.isEmpty(paramAnonymousWxaAttributes.field_username)) {}
          }
          catch (Exception localException)
          {
            for (;;)
            {
              try
              {
                g.Jzo.put(paramAnonymousWxaAttributes.field_username, Integer.valueOf(i));
                Object localObject = this.Jzp.getTag();
                if (!(localObject instanceof String)) {
                  break label259;
                }
                localObject = (String)localObject;
                if (!((String)localObject).equals(paramAnonymousWxaAttributes.field_username)) {
                  continue;
                }
                Log.i("AdWeAppHelper", "onGetWeAppInfo, weAppName=" + (String)localObject + ", flag=" + i);
                if (i == 1) {
                  bool = true;
                }
                return;
              }
              finally
              {
                int i;
                AppMethodBeat.o(264587);
              }
              localException = localException;
              Log.e("AdWeAppHelper", "onGetWeAppInfo, exp=" + localException.toString());
              i = 0;
            }
          }
          for (paramAnonymousWxaAttributes = "";; paramAnonymousWxaAttributes = paramAnonymousWxaAttributes.field_username)
          {
            Log.w("AdWeAppHelper", paramAnonymousWxaAttributes);
            AppMethodBeat.o(264587);
            return;
          }
          label259:
          StringBuilder localStringBuilder = new StringBuilder("onGetWeAppInfo, View reuse, view.name=null, info.name=");
          if (paramAnonymousWxaAttributes == null) {}
          for (paramAnonymousWxaAttributes = "";; paramAnonymousWxaAttributes = paramAnonymousWxaAttributes.field_username)
          {
            Log.w("AdWeAppHelper", paramAnonymousWxaAttributes);
            AppMethodBeat.o(264587);
            return;
          }
        }
      });
      AppMethodBeat.o(264568);
      return;
      if (paramView.getVisibility() == 0) {
        paramView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.g
 * JD-Core Version:    0.7.0.1
 */