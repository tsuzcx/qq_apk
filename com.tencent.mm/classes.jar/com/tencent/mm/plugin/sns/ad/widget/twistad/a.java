package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(310303);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramContext = paramContext.getDrawable(b.e.sns_ad_twist_card_bg);
    paramContext.setBounds(0, 0, paramInt1, paramInt2);
    paramContext.draw(localCanvas);
    paramContext = new Paint();
    localCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt3, paramInt3, paramInt1 - paramInt3, paramInt2 - paramInt3), paramContext);
    try
    {
      paramBitmap.recycle();
      label87:
      AppMethodBeat.o(310303);
      return localBitmap;
    }
    finally
    {
      break label87;
    }
  }
  
  /* Error */
  static boolean i(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 87
    //   14: ldc 89
    //   16: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 79
    //   21: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: ifnull +24 -> 51
    //   30: aload_0
    //   31: invokevirtual 99	android/graphics/Bitmap:isRecycled	()Z
    //   34: ifne +17 -> 51
    //   37: aload_0
    //   38: invokevirtual 103	android/graphics/Bitmap:getHeight	()I
    //   41: ifle +10 -> 51
    //   44: aload_0
    //   45: invokevirtual 106	android/graphics/Bitmap:getWidth	()I
    //   48: ifgt +17 -> 65
    //   51: ldc 87
    //   53: ldc 108
    //   55: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc 79
    //   60: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_0
    //   64: ireturn
    //   65: aconst_null
    //   66: astore 7
    //   68: aload 7
    //   70: astore 6
    //   72: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   75: lstore_2
    //   76: aload 7
    //   78: astore 6
    //   80: ldc 116
    //   82: aload_1
    //   83: invokestatic 122	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 8
    //   88: aload 7
    //   90: astore 6
    //   92: new 124	com/tencent/mm/vfs/u
    //   95: dup
    //   96: aload 8
    //   98: invokespecial 127	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 133	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   104: astore_1
    //   105: aload_1
    //   106: astore 6
    //   108: aload_0
    //   109: getstatic 139	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   112: bipush 100
    //   114: aload_1
    //   115: invokevirtual 143	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   118: pop
    //   119: aload_1
    //   120: astore 6
    //   122: aload_1
    //   123: invokevirtual 148	java/io/OutputStream:flush	()V
    //   126: aload_1
    //   127: astore 6
    //   129: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   132: lstore 4
    //   134: aload_1
    //   135: astore 6
    //   137: ldc 87
    //   139: new 150	java/lang/StringBuilder
    //   142: dup
    //   143: ldc 152
    //   145: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: lload 4
    //   150: lload_2
    //   151: lsub
    //   152: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: ldc 159
    //   157: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 106	android/graphics/Bitmap:getWidth	()I
    //   164: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 167
    //   169: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 103	android/graphics/Bitmap:getHeight	()I
    //   176: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: ldc 169
    //   181: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 8
    //   186: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 178	java/io/OutputStream:close	()V
    //   203: ldc 79
    //   205: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_1
    //   209: ireturn
    //   210: astore_0
    //   211: ldc 87
    //   213: new 150	java/lang/StringBuilder
    //   216: dup
    //   217: ldc 180
    //   219: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 183	java/lang/Throwable:toString	()Ljava/lang/String;
    //   226: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: goto -32 -> 203
    //   238: astore_0
    //   239: ldc 87
    //   241: new 150	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 185
    //   247: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: invokevirtual 183	java/lang/Throwable:toString	()Ljava/lang/String;
    //   254: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: ifnull +8 -> 273
    //   268: aload 6
    //   270: invokevirtual 178	java/io/OutputStream:close	()V
    //   273: ldc 79
    //   275: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: iconst_0
    //   279: ireturn
    //   280: astore_0
    //   281: ldc 87
    //   283: new 150	java/lang/StringBuilder
    //   286: dup
    //   287: ldc 180
    //   289: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload_0
    //   293: invokevirtual 183	java/lang/Throwable:toString	()Ljava/lang/String;
    //   296: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -32 -> 273
    //   308: astore_0
    //   309: aload 6
    //   311: ifnull +8 -> 319
    //   314: aload 6
    //   316: invokevirtual 178	java/io/OutputStream:close	()V
    //   319: ldc 79
    //   321: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_0
    //   325: athrow
    //   326: astore_1
    //   327: ldc 87
    //   329: new 150	java/lang/StringBuilder
    //   332: dup
    //   333: ldc 180
    //   335: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: aload_1
    //   339: invokevirtual 183	java/lang/Throwable:toString	()Ljava/lang/String;
    //   342: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -32 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramBitmap	Bitmap
    //   0	354	1	paramString	String
    //   75	76	2	l1	long
    //   132	17	4	l2	long
    //   70	245	6	localObject1	Object
    //   66	23	7	localObject2	Object
    //   86	99	8	str	String
    // Exception table:
    //   from	to	target	type
    //   199	203	210	finally
    //   72	76	238	finally
    //   80	88	238	finally
    //   92	105	238	finally
    //   108	119	238	finally
    //   122	126	238	finally
    //   129	134	238	finally
    //   137	195	238	finally
    //   268	273	280	finally
    //   239	263	308	finally
    //   314	319	326	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.a
 * JD-Core Version:    0.7.0.1
 */