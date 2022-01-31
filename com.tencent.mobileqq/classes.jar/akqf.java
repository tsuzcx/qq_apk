import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class akqf
  implements Runnable
{
  public akqf(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   4: getfield 24	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   14: getfield 27	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   17: invokevirtual 33	java/lang/Boolean:booleanValue	()Z
    //   20: ifne +13 -> 33
    //   23: aload_0
    //   24: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   27: getfield 24	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   30: invokevirtual 36	java/lang/Object:wait	()V
    //   33: new 38	android/os/Bundle
    //   36: dup
    //   37: invokespecial 39	android/os/Bundle:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: getstatic 44	com/tencent/open/downloadnew/DownloadConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_2
    //   51: getstatic 53	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   58: getfield 54	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_2
    //   65: getstatic 57	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   68: iconst_2
    //   69: invokevirtual 61	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   72: aload_2
    //   73: getstatic 64	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   76: ldc 66
    //   78: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_2
    //   82: getstatic 69	com/tencent/open/downloadnew/DownloadConstants:q	Ljava/lang/String;
    //   85: iconst_0
    //   86: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   89: aload_2
    //   90: getstatic 76	com/tencent/open/downloadnew/DownloadConstants:w	Ljava/lang/String;
    //   93: iconst_0
    //   94: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   97: aload_2
    //   98: getstatic 79	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   101: ldc 81
    //   103: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   110: getfield 84	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   113: aload_2
    //   114: iconst_0
    //   115: aconst_null
    //   116: iconst_0
    //   117: invokestatic 89	com/tencent/open/downloadnew/DownloadApi:a	(Landroid/app/Activity;Landroid/os/Bundle;ILcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   120: aload_1
    //   121: monitorexit
    //   122: return
    //   123: astore_2
    //   124: new 38	android/os/Bundle
    //   127: dup
    //   128: invokespecial 39	android/os/Bundle:<init>	()V
    //   131: astore_2
    //   132: aload_2
    //   133: getstatic 44	com/tencent/open/downloadnew/DownloadConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: ldc 46
    //   138: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_2
    //   142: getstatic 53	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   145: aload_0
    //   146: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   149: getfield 54	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   152: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_2
    //   156: getstatic 57	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   159: iconst_2
    //   160: invokevirtual 61	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   163: aload_2
    //   164: getstatic 64	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   167: ldc 66
    //   169: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_2
    //   173: getstatic 69	com/tencent/open/downloadnew/DownloadConstants:q	Ljava/lang/String;
    //   176: iconst_0
    //   177: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   180: aload_2
    //   181: getstatic 76	com/tencent/open/downloadnew/DownloadConstants:w	Ljava/lang/String;
    //   184: iconst_0
    //   185: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   188: aload_2
    //   189: getstatic 79	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   192: ldc 81
    //   194: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   201: getfield 84	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   204: aload_2
    //   205: iconst_0
    //   206: aconst_null
    //   207: iconst_0
    //   208: invokestatic 89	com/tencent/open/downloadnew/DownloadApi:a	(Landroid/app/Activity;Landroid/os/Bundle;ILcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   211: goto -91 -> 120
    //   214: astore_2
    //   215: aload_1
    //   216: monitorexit
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: new 38	android/os/Bundle
    //   223: dup
    //   224: invokespecial 39	android/os/Bundle:<init>	()V
    //   227: astore_3
    //   228: aload_3
    //   229: getstatic 44	com/tencent/open/downloadnew/DownloadConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: ldc 46
    //   234: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_3
    //   238: getstatic 53	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   245: getfield 54	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   248: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_3
    //   252: getstatic 57	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   255: iconst_2
    //   256: invokevirtual 61	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   259: aload_3
    //   260: getstatic 64	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   263: ldc 66
    //   265: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_3
    //   269: getstatic 69	com/tencent/open/downloadnew/DownloadConstants:q	Ljava/lang/String;
    //   272: iconst_0
    //   273: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   276: aload_3
    //   277: getstatic 76	com/tencent/open/downloadnew/DownloadConstants:w	Ljava/lang/String;
    //   280: iconst_0
    //   281: invokevirtual 73	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   284: aload_3
    //   285: getstatic 79	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   288: ldc 81
    //   290: invokevirtual 50	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 12	akqf:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;
    //   297: getfield 84	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   300: aload_3
    //   301: iconst_0
    //   302: aconst_null
    //   303: iconst_0
    //   304: invokestatic 89	com/tencent/open/downloadnew/DownloadApi:a	(Landroid/app/Activity;Landroid/os/Bundle;ILcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   307: aload_2
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	akqf
    //   7	209	1	localObject1	Object
    //   40	74	2	localBundle1	android.os.Bundle
    //   123	1	2	localInterruptedException	java.lang.InterruptedException
    //   131	74	2	localBundle2	android.os.Bundle
    //   214	4	2	localObject2	Object
    //   219	89	2	localObject3	Object
    //   227	74	3	localBundle3	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   10	33	123	java/lang/InterruptedException
    //   33	120	214	finally
    //   120	122	214	finally
    //   124	211	214	finally
    //   215	217	214	finally
    //   220	309	214	finally
    //   10	33	219	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqf
 * JD-Core Version:    0.7.0.1
 */