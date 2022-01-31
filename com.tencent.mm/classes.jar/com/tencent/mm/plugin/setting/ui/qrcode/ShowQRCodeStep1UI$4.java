package com.tencent.mm.plugin.setting.ui.qrcode;

import com.tencent.mm.ui.base.h.c;

final class ShowQRCodeStep1UI$4
  implements h.c
{
  ShowQRCodeStep1UI$4(ShowQRCodeStep1UI paramShowQRCodeStep1UI) {}
  
  /* Error */
  public final void gl(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+23 -> 24, 0:+24->25, 1:+32->33
    //   25: aload_0
    //   26: getfield 14	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$4:nRH	Lcom/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI;
    //   29: invokevirtual 25	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:byI	()V
    //   32: return
    //   33: aload_0
    //   34: getfield 14	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$4:nRH	Lcom/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI;
    //   37: astore 4
    //   39: aload 4
    //   41: getfield 29	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:nRG	[B
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull -24 -> 24
    //   51: aload 5
    //   53: arraylength
    //   54: ifle -30 -> 24
    //   57: new 31	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   64: invokestatic 38	com/tencent/mm/pluginsdk/ui/tools/l:qt	()Ljava/lang/String;
    //   67: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 44
    //   72: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   78: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc 55
    //   83: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 6
    //   91: new 60	java/io/FileOutputStream
    //   94: dup
    //   95: aload 6
    //   97: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   100: astore_3
    //   101: aload_3
    //   102: astore_2
    //   103: aload_3
    //   104: aload 5
    //   106: invokevirtual 67	java/io/FileOutputStream:write	([B)V
    //   109: aload_3
    //   110: astore_2
    //   111: aload 4
    //   113: aload 4
    //   115: getstatic 73	com/tencent/mm/plugin/setting/a$i:cropimage_saved	I
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload 6
    //   126: aastore
    //   127: invokevirtual 77	com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   130: iconst_1
    //   131: invokestatic 83	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   134: invokevirtual 86	android/widget/Toast:show	()V
    //   137: aload_3
    //   138: astore_2
    //   139: aload 6
    //   141: aload 4
    //   143: invokestatic 90	com/tencent/mm/pluginsdk/ui/tools/l:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   146: aload_3
    //   147: invokevirtual 93	java/io/FileOutputStream:close	()V
    //   150: return
    //   151: astore_2
    //   152: return
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_3
    //   157: aload_3
    //   158: astore_2
    //   159: ldc 95
    //   161: aload 4
    //   163: ldc 97
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 103	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: ifnull -149 -> 24
    //   176: aload_3
    //   177: invokevirtual 93	java/io/FileOutputStream:close	()V
    //   180: return
    //   181: astore_2
    //   182: return
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 93	java/io/FileOutputStream:close	()V
    //   194: aload_3
    //   195: athrow
    //   196: astore_2
    //   197: goto -3 -> 194
    //   200: astore_3
    //   201: goto -15 -> 186
    //   204: astore 4
    //   206: goto -49 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	4
    //   0	209	1	paramInt	int
    //   102	37	2	localFileOutputStream1	java.io.FileOutputStream
    //   151	1	2	localException1	java.lang.Exception
    //   158	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   181	1	2	localException2	java.lang.Exception
    //   185	6	2	localObject1	Object
    //   196	1	2	localException3	java.lang.Exception
    //   100	77	3	localFileOutputStream3	java.io.FileOutputStream
    //   183	12	3	localObject2	Object
    //   200	1	3	localObject3	Object
    //   37	105	4	localShowQRCodeStep1UI	ShowQRCodeStep1UI
    //   153	9	4	localException4	java.lang.Exception
    //   204	1	4	localException5	java.lang.Exception
    //   44	61	5	arrayOfByte	byte[]
    //   89	51	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   146	150	151	java/lang/Exception
    //   91	101	153	java/lang/Exception
    //   176	180	181	java/lang/Exception
    //   91	101	183	finally
    //   190	194	196	java/lang/Exception
    //   103	109	200	finally
    //   111	137	200	finally
    //   139	146	200	finally
    //   159	172	200	finally
    //   103	109	204	java/lang/Exception
    //   111	137	204	java/lang/Exception
    //   139	146	204	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.4
 * JD-Core Version:    0.7.0.1
 */