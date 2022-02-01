package mqq.app;

class MobileQQ$6
  implements Runnable
{
  MobileQQ$6(MobileQQ paramMobileQQ) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	mqq/app/MobileQQ$6:this$0	Lmqq/app/MobileQQ;
    //   4: ldc 23
    //   6: iconst_0
    //   7: invokevirtual 29	mqq/app/MobileQQ:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 12	mqq/app/MobileQQ$6:this$0	Lmqq/app/MobileQQ;
    //   17: invokestatic 33	mqq/app/MobileQQ:access$900	(Lmqq/app/MobileQQ;)Ljava/util/Properties;
    //   20: aload_2
    //   21: aconst_null
    //   22: invokevirtual 39	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 44	java/io/OutputStream:flush	()V
    //   31: aload_2
    //   32: ifnull +41 -> 73
    //   35: aload_2
    //   36: invokevirtual 47	java/io/OutputStream:close	()V
    //   39: return
    //   40: astore_3
    //   41: goto +12 -> 53
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_2
    //   47: goto +32 -> 79
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 50	java/lang/Exception:printStackTrace	()V
    //   59: aload_2
    //   60: ifnull +13 -> 73
    //   63: aload_2
    //   64: invokevirtual 47	java/io/OutputStream:close	()V
    //   67: return
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   73: return
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: aload_3
    //   78: astore_1
    //   79: aload_2
    //   80: ifnull +15 -> 95
    //   83: aload_2
    //   84: invokevirtual 47	java/io/OutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	6
    //   12	15	1	localObject1	Object
    //   44	1	1	localObject2	Object
    //   54	1	1	localObject3	Object
    //   68	8	1	localIOException1	java.io.IOException
    //   78	18	1	localObject4	Object
    //   10	74	2	localObject5	Object
    //   90	2	2	localIOException2	java.io.IOException
    //   40	1	3	localException1	java.lang.Exception
    //   50	6	3	localException2	java.lang.Exception
    //   74	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   13	25	40	java/lang/Exception
    //   27	31	40	java/lang/Exception
    //   0	11	44	finally
    //   0	11	50	java/lang/Exception
    //   35	39	68	java/io/IOException
    //   63	67	68	java/io/IOException
    //   13	25	74	finally
    //   27	31	74	finally
    //   55	59	74	finally
    //   83	87	90	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MobileQQ.6
 * JD-Core Version:    0.7.0.1
 */