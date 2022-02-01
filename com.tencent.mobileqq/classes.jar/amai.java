import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1", "Lcom/tencent/mobileqq/app/soso/LbsManagerService$OnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amai
  extends aoou
{
  amai(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  /* Error */
  public void onLocationFinish(int paramInt, @org.jetbrains.annotations.Nullable com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +228 -> 229
    //   4: aload_2
    //   5: ifnull +224 -> 229
    //   8: aload_2
    //   9: getfield 47	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:a	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   12: ifnull +217 -> 229
    //   15: aload_2
    //   16: getfield 47	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:a	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   19: getfield 52	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:f	Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 54
    //   26: invokestatic 60	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_2
    //   30: checkcast 62	java/lang/CharSequence
    //   33: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +122 -> 158
    //   39: aload_2
    //   40: checkcast 62	java/lang/CharSequence
    //   43: aload_0
    //   44: getfield 32	amai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: checkcast 62	java/lang/CharSequence
    //   50: invokestatic 72	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   53: ifne +105 -> 158
    //   56: new 74	org/json/JSONObject
    //   59: dup
    //   60: invokespecial 77	org/json/JSONObject:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: ldc 79
    //   67: iconst_2
    //   68: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   71: pop
    //   72: new 74	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 77	org/json/JSONObject:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: ldc 85
    //   85: aload_2
    //   86: invokevirtual 88	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_3
    //   91: ldc 90
    //   93: aload 4
    //   95: invokevirtual 88	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_0
    //   100: getfield 30	amai:jdField_a_of_type_Amag	Lamag;
    //   103: invokevirtual 95	amag:a	()Landroid/arch/lifecycle/MutableLiveData;
    //   106: astore 4
    //   108: aload_3
    //   109: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: astore 5
    //   114: aload 5
    //   116: ldc 101
    //   118: invokestatic 60	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   121: aload 4
    //   123: new 103	amaq
    //   126: dup
    //   127: iconst_0
    //   128: ldc 105
    //   130: aload 5
    //   132: aconst_null
    //   133: iconst_0
    //   134: iconst_0
    //   135: bipush 56
    //   137: aconst_null
    //   138: invokespecial 108	amaq:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   141: invokevirtual 114	android/arch/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   144: ldc 116
    //   146: ldc 118
    //   148: aload_3
    //   149: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: ldc 120
    //   154: invokestatic 126	com/tencent/ark/ark:arkNotify	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   157: pop
    //   158: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +49 -> 210
    //   164: ldc 134
    //   166: iconst_2
    //   167: new 136	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   174: ldc 139
    //   176: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload_1
    //   180: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 148
    //   185: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 150
    //   194: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 32	amai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: return
    //   211: astore_2
    //   212: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +14 -> 229
    //   218: ldc 134
    //   220: iconst_2
    //   221: aload_2
    //   222: iconst_0
    //   223: anewarray 157	java/lang/Object
    //   226: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   229: ldc 162
    //   231: astore_2
    //   232: goto -203 -> 29
    //   235: astore_3
    //   236: ldc 134
    //   238: iconst_1
    //   239: ldc 164
    //   241: aload_3
    //   242: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -87 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	amai
    //   0	248	1	paramInt	int
    //   0	248	2	paramSosoLbsInfo	com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo
    //   63	86	3	localJSONObject	org.json.JSONObject
    //   235	7	3	localThrowable	java.lang.Throwable
    //   79	43	4	localObject	java.lang.Object
    //   112	19	5	str	String
    // Exception table:
    //   from	to	target	type
    //   15	29	211	java/lang/Throwable
    //   144	158	235	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amai
 * JD-Core Version:    0.7.0.1
 */