import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

public class alfm
  implements Runnable
{
  public alfm(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 26	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: getfield 15	alfm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 33
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 43	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   27: astore_2
    //   28: new 26	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 15	alfm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 45
    //   44: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 43	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore_1
    //   54: new 26	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 15	alfm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 47
    //   70: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 43	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   79: astore 4
    //   81: aload 4
    //   83: astore_3
    //   84: aload_2
    //   85: ifnull +37 -> 122
    //   88: aload_1
    //   89: ifnull +33 -> 122
    //   92: aload_3
    //   93: ifnull +29 -> 122
    //   96: aload_0
    //   97: getfield 13	alfm:jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager	Lcom/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager;
    //   100: iconst_1
    //   101: putfield 52	com/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager:a	Z
    //   104: invokestatic 58	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   107: new 60	alfn
    //   110: dup
    //   111: aload_0
    //   112: aload_1
    //   113: aload_2
    //   114: aload_3
    //   115: invokespecial 63	alfn:<init>	(Lalfm;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   118: invokevirtual 69	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   121: pop
    //   122: return
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: goto -44 -> 84
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -50 -> 84
    //   137: astore 4
    //   139: goto -55 -> 84
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -63 -> 84
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_1
    //   153: goto -69 -> 84
    //   156: astore 4
    //   158: goto -74 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	alfm
    //   53	60	1	localBitmap1	android.graphics.Bitmap
    //   123	1	1	localException1	java.lang.Exception
    //   125	1	1	localObject1	Object
    //   131	1	1	localException2	java.lang.Exception
    //   133	1	1	localObject2	Object
    //   142	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   144	1	1	localObject3	Object
    //   150	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   152	1	1	localObject4	Object
    //   27	120	2	localBitmap2	android.graphics.Bitmap
    //   1	114	3	localObject5	Object
    //   79	3	4	localBitmap3	android.graphics.Bitmap
    //   137	1	4	localException3	java.lang.Exception
    //   156	1	4	localOutOfMemoryError3	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   2	28	123	java/lang/Exception
    //   28	54	131	java/lang/Exception
    //   54	81	137	java/lang/Exception
    //   2	28	142	java/lang/OutOfMemoryError
    //   28	54	150	java/lang/OutOfMemoryError
    //   54	81	156	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfm
 * JD-Core Version:    0.7.0.1
 */