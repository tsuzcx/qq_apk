package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.d.f;

final class SelfQRCodeUI$11
  implements Runnable
{
  SelfQRCodeUI$11(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 32
    //   7: invokestatic 38	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   10: checkcast 32	com/tencent/mm/sensitive/d
    //   13: getstatic 44	com/tencent/mm/sensitive/d$c:actw	Lcom/tencent/mm/sensitive/d$c;
    //   16: getstatic 50	com/tencent/mm/sensitive/d$a:acto	Lcom/tencent/mm/sensitive/d$a;
    //   19: new 10	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11$1
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 53	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11$1:<init>	(Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11;)V
    //   27: invokeinterface 57 4 0
    //   32: ifeq +16 -> 48
    //   35: ldc 59
    //   37: ldc 61
    //   39: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: ldc 24
    //   44: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   52: invokestatic 73	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:e	(Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;)Ljava/lang/String;
    //   55: invokestatic 79	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
    //   58: ifne +16 -> 74
    //   61: aload_0
    //   62: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   65: invokestatic 73	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:e	(Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;)Ljava/lang/String;
    //   68: invokestatic 84	com/tencent/mm/an/g:MB	(Ljava/lang/String;)Z
    //   71: ifeq +188 -> 259
    //   74: getstatic 90	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   77: ldc2_w 91
    //   80: ldc2_w 93
    //   83: lconst_1
    //   84: iconst_1
    //   85: invokevirtual 98	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   88: aload_0
    //   89: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   92: getstatic 104	com/tencent/mm/plugin/setting/b$f:qrcode_container	I
    //   95: invokevirtual 108	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:findViewById	(I)Landroid/view/View;
    //   98: invokestatic 114	com/tencent/mm/sdk/platformtools/BitmapUtil:getBitmapFromView	(Landroid/view/View;)Landroid/graphics/Bitmap;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +248 -> 351
    //   106: new 116	java/io/ByteArrayOutputStream
    //   109: dup
    //   110: invokespecial 117	java/io/ByteArrayOutputStream:<init>	()V
    //   113: astore_2
    //   114: aload_1
    //   115: getstatic 123	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   118: bipush 90
    //   120: aload_2
    //   121: invokevirtual 129	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   124: pop
    //   125: aload_2
    //   126: invokevirtual 133	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   129: astore_1
    //   130: aload_1
    //   131: astore_2
    //   132: aload_1
    //   133: ifnonnull +11 -> 144
    //   136: aload_0
    //   137: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   140: invokestatic 137	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:f	(Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;)[B
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +188 -> 333
    //   148: aload_2
    //   149: arraylength
    //   150: ifle +183 -> 333
    //   153: new 139	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   160: invokestatic 146	com/tencent/mm/pluginsdk/ui/tools/t:getSysCameraDirPath	()Ljava/lang/String;
    //   163: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 152
    //   168: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   174: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: ldc 163
    //   179: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore 4
    //   187: aload 4
    //   189: iconst_0
    //   190: invokestatic 172	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   193: astore_3
    //   194: aload_3
    //   195: astore_1
    //   196: aload_3
    //   197: aload_2
    //   198: invokevirtual 178	java/io/OutputStream:write	([B)V
    //   201: aload_3
    //   202: astore_1
    //   203: aload_0
    //   204: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   207: aload_0
    //   208: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   211: getstatic 183	com/tencent/mm/plugin/setting/b$i:cropimage_saved	I
    //   214: iconst_1
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: invokestatic 186	com/tencent/mm/pluginsdk/ui/tools/t:getToastSysCameraPath	()Ljava/lang/String;
    //   223: aastore
    //   224: invokevirtual 190	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   227: iconst_1
    //   228: invokestatic 196	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   231: invokevirtual 199	android/widget/Toast:show	()V
    //   234: aload_3
    //   235: astore_1
    //   236: aload 4
    //   238: aload_0
    //   239: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   242: invokestatic 203	com/tencent/mm/pluginsdk/ui/tools/t:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 206	java/io/OutputStream:close	()V
    //   253: ldc 24
    //   255: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: return
    //   259: aload_0
    //   260: getfield 16	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$11:PpF	Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;
    //   263: invokestatic 137	com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI:f	(Lcom/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI;)[B
    //   266: astore_2
    //   267: goto -123 -> 144
    //   270: astore_1
    //   271: ldc 24
    //   273: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: return
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_3
    //   280: aload_3
    //   281: astore_1
    //   282: ldc 59
    //   284: aload_2
    //   285: ldc 208
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 206	java/io/OutputStream:close	()V
    //   302: ldc 24
    //   304: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: return
    //   308: astore_1
    //   309: ldc 24
    //   311: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 206	java/io/OutputStream:close	()V
    //   326: ldc 24
    //   328: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_2
    //   332: athrow
    //   333: ldc 24
    //   335: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: return
    //   339: astore_1
    //   340: goto -14 -> 326
    //   343: astore_2
    //   344: goto -26 -> 318
    //   347: astore_2
    //   348: goto -68 -> 280
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -223 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	11
    //   101	135	1	localObject1	Object
    //   270	1	1	localException1	java.lang.Exception
    //   281	1	1	localObject2	Object
    //   308	1	1	localException2	java.lang.Exception
    //   317	6	1	localObject3	Object
    //   339	1	1	localException3	java.lang.Exception
    //   352	1	1	localObject4	Object
    //   113	154	2	localObject5	Object
    //   277	8	2	localException4	java.lang.Exception
    //   315	17	2	localObject6	Object
    //   343	1	2	localObject7	Object
    //   347	1	2	localException5	java.lang.Exception
    //   193	106	3	localOutputStream	java.io.OutputStream
    //   185	52	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   249	253	270	java/lang/Exception
    //   187	194	277	java/lang/Exception
    //   298	302	308	java/lang/Exception
    //   187	194	315	finally
    //   322	326	339	java/lang/Exception
    //   196	201	343	finally
    //   203	234	343	finally
    //   236	245	343	finally
    //   282	294	343	finally
    //   196	201	347	java/lang/Exception
    //   203	234	347	java/lang/Exception
    //   236	245	347	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.11
 * JD-Core Version:    0.7.0.1
 */