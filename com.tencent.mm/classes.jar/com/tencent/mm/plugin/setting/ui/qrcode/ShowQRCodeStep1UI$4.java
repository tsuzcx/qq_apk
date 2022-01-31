package com.tencent.mm.plugin.setting.ui.qrcode;

import com.tencent.mm.ui.base.h.c;

final class ShowQRCodeStep1UI$4
  implements h.c
{
  ShowQRCodeStep1UI$4(ShowQRCodeStep1UI paramShowQRCodeStep1UI) {}
  
  /* Error */
  public final void iA(int paramInt)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_1
    //   6: tableswitch	default:+22 -> 28, 0:+28->34, 1:+41->47
    //   29: fload 184
    //   31: nop
    //   32: lload_1
    //   33: return
    //   34: aload_0
    //   35: getfield 14	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$4:qFF	Lcom/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI;
    //   38: invokevirtual 34	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:cjS	()V
    //   41: ldc 23
    //   43: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: return
    //   47: aload_0
    //   48: getfield 14	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$4:qFF	Lcom/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI;
    //   51: astore 4
    //   53: aload 4
    //   55: getfield 38	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:qFE	[B
    //   58: astore 5
    //   60: aload 5
    //   62: ifnull -34 -> 28
    //   65: aload 5
    //   67: arraylength
    //   68: ifle -40 -> 28
    //   71: new 40	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 47	com/tencent/mm/pluginsdk/ui/tools/n:aok	()Ljava/lang/String;
    //   81: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 53
    //   86: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: ldc 64
    //   97: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 6
    //   105: new 69	java/io/FileOutputStream
    //   108: dup
    //   109: aload 6
    //   111: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: aload_3
    //   118: aload 5
    //   120: invokevirtual 76	java/io/FileOutputStream:write	([B)V
    //   123: aload_3
    //   124: astore_2
    //   125: aload 4
    //   127: aload 4
    //   129: ldc 77
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload 6
    //   139: aastore
    //   140: invokevirtual 81	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   143: iconst_1
    //   144: invokestatic 87	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   147: invokevirtual 90	android/widget/Toast:show	()V
    //   150: aload_3
    //   151: astore_2
    //   152: aload 6
    //   154: aload 4
    //   156: invokestatic 94	com/tencent/mm/pluginsdk/ui/tools/n:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   159: aload_3
    //   160: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   163: ldc 23
    //   165: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: return
    //   169: astore_2
    //   170: ldc 23
    //   172: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: astore_2
    //   182: ldc 99
    //   184: aload 4
    //   186: ldc 101
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 107	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   203: ldc 23
    //   205: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: astore_2
    //   210: ldc 23
    //   212: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   227: ldc 23
    //   229: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_3
    //   233: athrow
    //   234: astore_2
    //   235: goto -8 -> 227
    //   238: astore_3
    //   239: goto -20 -> 219
    //   242: astore 4
    //   244: goto -64 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	4
    //   0	247	1	paramInt	int
    //   116	36	2	localFileOutputStream1	java.io.FileOutputStream
    //   169	1	2	localException1	java.lang.Exception
    //   181	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   209	1	2	localException2	java.lang.Exception
    //   218	6	2	localObject1	Object
    //   234	1	2	localException3	java.lang.Exception
    //   114	86	3	localFileOutputStream3	java.io.FileOutputStream
    //   216	17	3	localObject2	Object
    //   238	1	3	localObject3	Object
    //   51	104	4	localShowQRCodeStep1UI	ShowQRCodeStep1UI
    //   176	9	4	localException4	java.lang.Exception
    //   242	1	4	localException5	java.lang.Exception
    //   58	61	5	arrayOfByte	byte[]
    //   103	50	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   159	163	169	java/lang/Exception
    //   105	115	176	java/lang/Exception
    //   199	203	209	java/lang/Exception
    //   105	115	216	finally
    //   223	227	234	java/lang/Exception
    //   117	123	238	finally
    //   125	150	238	finally
    //   152	159	238	finally
    //   182	195	238	finally
    //   117	123	242	java/lang/Exception
    //   125	150	242	java/lang/Exception
    //   152	159	242	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.4
 * JD-Core Version:    0.7.0.1
 */