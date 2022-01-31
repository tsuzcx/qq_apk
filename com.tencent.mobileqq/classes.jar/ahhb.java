import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;

public class ahhb
  implements Runnable
{
  public ahhb(CapturePtvTemplateManager paramCapturePtvTemplateManager, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   6: getfield 29	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9: invokeinterface 35 1 0
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: getfield 15	ahhb:jdField_a_of_type_Boolean	Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: ldc 37
    //   27: astore 4
    //   29: invokestatic 43	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 47	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   35: ldc 49
    //   37: invokevirtual 55	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_1
    //   44: invokestatic 60	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload_1
    //   55: invokevirtual 65	java/io/InputStream:close	()V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   64: aload_2
    //   65: aconst_null
    //   66: invokestatic 68	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:a	(Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;Ljava/lang/String;Lcom/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig;)Ljava/util/List;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +29 -> 100
    //   74: aload_0
    //   75: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   78: getfield 29	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: invokeinterface 71 1 0
    //   86: aload_0
    //   87: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   90: getfield 29	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   93: aload_1
    //   94: invokeinterface 75 2 0
    //   99: pop
    //   100: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +11 -> 114
    //   106: ldc 82
    //   108: iconst_2
    //   109: ldc 84
    //   111: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   118: aload_1
    //   119: iconst_0
    //   120: invokevirtual 91	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:a	(Ljava/util/List;Z)V
    //   123: aload_0
    //   124: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   127: getfield 94	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager$CapturePtvTemplateRefreshListener;
    //   130: ifnull -106 -> 24
    //   133: aload_0
    //   134: getfield 13	ahhb:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   137: getfield 94	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener	Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager$CapturePtvTemplateRefreshListener;
    //   140: invokeinterface 98 1 0
    //   145: return
    //   146: astore_1
    //   147: aload_3
    //   148: astore_2
    //   149: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -92 -> 60
    //   155: aload_1
    //   156: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   159: aload_3
    //   160: astore_2
    //   161: goto -101 -> 60
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: astore_2
    //   169: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +9 -> 181
    //   175: aload_1
    //   176: astore_2
    //   177: aload_3
    //   178: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   181: aload 4
    //   183: astore_2
    //   184: aload_1
    //   185: ifnull -125 -> 60
    //   188: aload_1
    //   189: invokevirtual 65	java/io/InputStream:close	()V
    //   192: aload 4
    //   194: astore_2
    //   195: goto -135 -> 60
    //   198: astore_1
    //   199: aload 4
    //   201: astore_2
    //   202: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq -145 -> 60
    //   208: aload_1
    //   209: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   212: aload 4
    //   214: astore_2
    //   215: goto -155 -> 60
    //   218: astore_1
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 65	java/io/InputStream:close	()V
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -6 -> 227
    //   236: aload_2
    //   237: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   240: goto -13 -> 227
    //   243: astore_1
    //   244: goto -25 -> 219
    //   247: astore_3
    //   248: goto -81 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	ahhb
    //   40	79	1	localObject1	Object
    //   146	10	1	localException1	java.lang.Exception
    //   166	23	1	localObject2	Object
    //   198	11	1	localException2	java.lang.Exception
    //   218	10	1	localObject3	Object
    //   243	1	1	localObject4	Object
    //   1	223	2	localObject5	Object
    //   229	8	2	localException3	java.lang.Exception
    //   47	113	3	str1	java.lang.String
    //   164	14	3	localIOException1	java.io.IOException
    //   247	1	3	localIOException2	java.io.IOException
    //   27	186	4	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   54	58	146	java/lang/Exception
    //   29	41	164	java/io/IOException
    //   188	192	198	java/lang/Exception
    //   29	41	218	finally
    //   223	227	229	java/lang/Exception
    //   43	48	243	finally
    //   169	175	243	finally
    //   177	181	243	finally
    //   43	48	247	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahhb
 * JD-Core Version:    0.7.0.1
 */