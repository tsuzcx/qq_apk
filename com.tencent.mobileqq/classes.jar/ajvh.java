import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import mqq.observer.BusinessObserver;

public class ajvh
  implements BusinessObserver
{
  public ajvh(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +224 -> 225
    //   4: aload_3
    //   5: ldc 22
    //   7: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 6
    //   12: aload_3
    //   13: ldc 30
    //   15: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 7
    //   20: ldc 32
    //   22: iconst_1
    //   23: new 34	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   30: ldc 37
    //   32: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 7
    //   37: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_3
    //   47: ldc 53
    //   49: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: ifnull +201 -> 253
    //   55: new 55	org/json/JSONObject
    //   58: dup
    //   59: invokespecial 56	org/json/JSONObject:<init>	()V
    //   62: astore 5
    //   64: aload 5
    //   66: ldc 58
    //   68: iconst_0
    //   69: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload 5
    //   75: ldc 64
    //   77: iconst_0
    //   78: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 7
    //   84: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +113 -> 200
    //   90: invokestatic 75	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   93: invokestatic 81	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   96: astore 8
    //   98: new 55	org/json/JSONObject
    //   101: dup
    //   102: aload 7
    //   104: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 9
    //   109: aload 9
    //   111: new 34	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   118: aload 8
    //   120: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 86
    //   125: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 90	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   134: istore_1
    //   135: aload 9
    //   137: new 34	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   144: aload 8
    //   146: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 92
    //   151: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 90	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   160: istore 4
    //   162: aload 5
    //   164: ldc 64
    //   166: aload 9
    //   168: new 34	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   175: aload 8
    //   177: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 94
    //   182: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 90	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   191: iload_1
    //   192: iload 4
    //   194: isub
    //   195: iadd
    //   196: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload_0
    //   201: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   204: aload_3
    //   205: ldc 53
    //   207: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: iconst_1
    //   211: anewarray 77	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: aload 5
    //   218: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   221: aastore
    //   222: invokevirtual 101	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   225: return
    //   226: astore 8
    //   228: aload_0
    //   229: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   232: aload_3
    //   233: ldc 53
    //   235: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: iconst_1
    //   239: anewarray 77	java/lang/String
    //   242: dup
    //   243: iconst_0
    //   244: aload 5
    //   246: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   249: aastore
    //   250: invokevirtual 101	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   253: aload 6
    //   255: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifeq +11 -> 269
    //   261: aload 7
    //   263: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne -41 -> 225
    //   269: aload_0
    //   270: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   273: getfield 104	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   276: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   279: ifeq +12 -> 291
    //   282: aload_0
    //   283: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   286: aload 7
    //   288: putfield 114	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:g	Ljava/lang/String;
    //   291: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   294: getstatic 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_Long	J
    //   297: lsub
    //   298: ldc2_w 123
    //   301: lcmp
    //   302: iflt -77 -> 225
    //   305: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   308: putstatic 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_Long	J
    //   311: aload_0
    //   312: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   315: aload 6
    //   317: aload 7
    //   319: invokestatic 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:a	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   322: return
    //   323: astore 6
    //   325: aload_0
    //   326: getfield 12	ajvh:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   329: aload_3
    //   330: ldc 53
    //   332: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: iconst_1
    //   336: anewarray 77	java/lang/String
    //   339: dup
    //   340: iconst_0
    //   341: aload 5
    //   343: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   346: aastore
    //   347: invokevirtual 101	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   350: aload 6
    //   352: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	ajvh
    //   0	353	1	paramInt	int
    //   0	353	2	paramBoolean	boolean
    //   0	353	3	paramBundle	android.os.Bundle
    //   160	35	4	i	int
    //   62	280	5	localJSONObject1	org.json.JSONObject
    //   10	306	6	str1	java.lang.String
    //   323	28	6	localObject	Object
    //   18	300	7	str2	java.lang.String
    //   96	80	8	str3	java.lang.String
    //   226	1	8	localJSONException	org.json.JSONException
    //   107	60	9	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   64	200	226	org/json/JSONException
    //   64	200	323	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajvh
 * JD-Core Version:    0.7.0.1
 */