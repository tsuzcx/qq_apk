package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View.OnClickListener;

class TMOpenSDKToMsdkManager$6
  implements View.OnClickListener
{
  TMOpenSDKToMsdkManager$6(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   9: getfield 33	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:mContext	Landroid/content/Context;
    //   12: ifnonnull +9 -> 21
    //   15: ldc 23
    //   17: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 42	android/view/View:getTag	()Ljava/lang/Object;
    //   25: checkcast 44	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/data/ActionButton
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   33: getfield 48	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:mOpenSDK	Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK;
    //   36: aload_0
    //   37: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   40: getfield 52	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:mSupportVersionCode	I
    //   43: invokevirtual 58	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:checkQQDownloaderInstalled	(I)I
    //   46: istore_2
    //   47: iload_2
    //   48: tableswitch	default:+28 -> 76, 0:+34->82, 1:+113->161, 2:+89->137
    //   77: fload 184
    //   79: nop
    //   80: fload_2
    //   81: return
    //   82: aload_0
    //   83: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   86: aload_1
    //   87: getfield 62	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/data/ActionButton:jumpUrl	Ljava/lang/String;
    //   90: invokevirtual 66	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:startToQQDownloaderAuthorized	(Ljava/lang/String;)V
    //   93: ldc 23
    //   95: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc 68
    //   102: aload_1
    //   103: ldc 70
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc 23
    //   114: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: astore_1
    //   119: ldc 68
    //   121: aload_1
    //   122: ldc 70
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc 23
    //   133: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: aload_0
    //   138: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   141: aload_0
    //   142: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   145: getfield 79	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:mDownloadUrl	Ljava/lang/String;
    //   148: aload_1
    //   149: getfield 62	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/data/ActionButton:jumpUrl	Ljava/lang/String;
    //   152: invokevirtual 83	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:startDownloadTask	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: ldc 23
    //   157: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: aload_0
    //   162: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   165: aload_0
    //   166: getfield 14	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6:this$0	Lcom/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager;
    //   169: getfield 79	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:mDownloadUrl	Ljava/lang/String;
    //   172: aload_1
    //   173: getfield 62	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/data/ActionButton:jumpUrl	Ljava/lang/String;
    //   176: invokevirtual 83	com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager:startDownloadTask	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: goto -103 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	6
    //   0	182	1	paramView	android.view.View
    //   46	2	2	i	int
    // Exception table:
    //   from	to	target	type
    //   29	47	99	java/lang/Exception
    //   93	98	99	java/lang/Exception
    //   119	136	99	java/lang/Exception
    //   137	160	99	java/lang/Exception
    //   161	179	99	java/lang/Exception
    //   82	93	118	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.6
 * JD-Core Version:    0.7.0.1
 */