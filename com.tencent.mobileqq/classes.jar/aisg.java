import com.tencent.mobileqq.teamwork.spread.ConfigSetting;

public class aisg
  implements Runnable
{
  public aisg(ConfigSetting paramConfigSetting) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   4: getfield 26	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: new 34	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   21: getfield 26	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 39	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   27: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 45
    //   32: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: iconst_0
    //   39: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   47: aload_3
    //   48: ldc 56
    //   50: iconst_0
    //   51: invokeinterface 62 3 0
    //   56: invokestatic 65	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   59: pop
    //   60: aload_0
    //   61: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   64: aload_3
    //   65: ldc 67
    //   67: ldc 69
    //   69: invokeinterface 73 3 0
    //   74: invokestatic 76	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)[Ljava/lang/String;
    //   77: astore 4
    //   79: aload_0
    //   80: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   83: ldc 69
    //   85: invokestatic 79	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: aload 4
    //   91: arraylength
    //   92: istore_2
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: iload_2
    //   97: if_icmpge +233 -> 330
    //   100: aload 4
    //   102: iload_1
    //   103: aaload
    //   104: astore 5
    //   106: aload_3
    //   107: new 34	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   114: ldc 81
    //   116: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 5
    //   121: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: ldc 69
    //   129: invokeinterface 73 3 0
    //   134: astore 6
    //   136: aload_0
    //   137: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   140: new 34	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   147: aload_0
    //   148: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   151: invokestatic 84	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Ljava/lang/String;
    //   154: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 6
    //   159: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 86
    //   164: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 79	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)Ljava/lang/String;
    //   173: pop
    //   174: new 88	aisl
    //   177: dup
    //   178: aload_0
    //   179: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   182: aconst_null
    //   183: invokespecial 91	aisl:<init>	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Laise;)V
    //   186: astore 7
    //   188: aload 7
    //   190: aload_0
    //   191: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   194: aload 6
    //   196: invokestatic 76	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)[Ljava/lang/String;
    //   199: putfield 95	aisl:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   202: aload 7
    //   204: aload_0
    //   205: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   208: aload_3
    //   209: new 34	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   216: ldc 97
    //   218: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 5
    //   223: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: ldc 69
    //   231: invokeinterface 73 3 0
    //   236: invokestatic 76	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)[Ljava/lang/String;
    //   239: putfield 99	aisl:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   242: aload 7
    //   244: aload_3
    //   245: new 34	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   252: ldc 101
    //   254: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: ldc 69
    //   267: invokeinterface 73 3 0
    //   272: putfield 104	aisl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: aload 7
    //   277: aload_3
    //   278: new 34	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   285: ldc 106
    //   287: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: ldc 69
    //   300: invokeinterface 73 3 0
    //   305: putfield 108	aisl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   308: aload_0
    //   309: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   312: invokestatic 111	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Ljava/util/HashMap;
    //   315: aload 5
    //   317: aload 7
    //   319: invokevirtual 117	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: iload_1
    //   324: iconst_1
    //   325: iadd
    //   326: istore_1
    //   327: goto -232 -> 95
    //   330: aload_0
    //   331: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   334: invokestatic 84	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Ljava/lang/String;
    //   337: invokevirtual 123	java/lang/String:length	()I
    //   340: ifle +34 -> 374
    //   343: aload_0
    //   344: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   347: aload_0
    //   348: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   351: invokestatic 84	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Ljava/lang/String;
    //   354: iconst_0
    //   355: aload_0
    //   356: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   359: invokestatic 84	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Ljava/lang/String;
    //   362: invokevirtual 123	java/lang/String:length	()I
    //   365: iconst_1
    //   366: isub
    //   367: invokevirtual 127	java/lang/String:substring	(II)Ljava/lang/String;
    //   370: invokestatic 79	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)Ljava/lang/String;
    //   373: pop
    //   374: aload_0
    //   375: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   378: aload_3
    //   379: ldc 129
    //   381: iconst_0
    //   382: invokeinterface 62 3 0
    //   387: invokestatic 132	com/tencent/mobileqq/teamwork/spread/ConfigSetting:e	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   390: pop
    //   391: aload_0
    //   392: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   395: aload_3
    //   396: ldc 134
    //   398: iconst_0
    //   399: invokeinterface 62 3 0
    //   404: invokestatic 136	com/tencent/mobileqq/teamwork/spread/ConfigSetting:b	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   407: pop
    //   408: aload_0
    //   409: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   412: aload_3
    //   413: ldc 138
    //   415: iconst_0
    //   416: invokeinterface 62 3 0
    //   421: invokestatic 141	com/tencent/mobileqq/teamwork/spread/ConfigSetting:c	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   424: pop
    //   425: aload_0
    //   426: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   429: aload_3
    //   430: ldc 143
    //   432: iconst_0
    //   433: invokeinterface 62 3 0
    //   438: invokestatic 146	com/tencent/mobileqq/teamwork/spread/ConfigSetting:d	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   441: pop
    //   442: aload_0
    //   443: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   446: aload_3
    //   447: ldc 148
    //   449: fconst_0
    //   450: invokeinterface 152 3 0
    //   455: f2d
    //   456: invokestatic 155	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;D)D
    //   459: pop2
    //   460: aload_0
    //   461: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   464: aload_3
    //   465: ldc 157
    //   467: ldc 69
    //   469: invokeinterface 73 3 0
    //   474: invokestatic 159	com/tencent/mobileqq/teamwork/spread/ConfigSetting:b	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)Ljava/lang/String;
    //   477: pop
    //   478: aload_0
    //   479: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   482: aload_3
    //   483: ldc 161
    //   485: ldc 69
    //   487: invokeinterface 73 3 0
    //   492: invokestatic 163	com/tencent/mobileqq/teamwork/spread/ConfigSetting:c	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Ljava/lang/String;)Ljava/lang/String;
    //   495: pop
    //   496: aload_0
    //   497: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   500: aload_3
    //   501: ldc 165
    //   503: iconst_0
    //   504: invokeinterface 62 3 0
    //   509: invokestatic 168	com/tencent/mobileqq/teamwork/spread/ConfigSetting:f	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;I)I
    //   512: pop
    //   513: aload_3
    //   514: ldc 170
    //   516: ldc 69
    //   518: invokeinterface 73 3 0
    //   523: astore 4
    //   525: aload_0
    //   526: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   529: aload_3
    //   530: ldc 172
    //   532: iconst_0
    //   533: invokeinterface 176 3 0
    //   538: invokestatic 179	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Z)Z
    //   541: pop
    //   542: aload 4
    //   544: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne +24 -> 571
    //   550: new 187	org/json/JSONObject
    //   553: dup
    //   554: aload 4
    //   556: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   559: astore 4
    //   561: aload_0
    //   562: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   565: aload 4
    //   567: aconst_null
    //   568: invokestatic 193	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Lorg/json/JSONObject;Landroid/content/SharedPreferences$Editor;)V
    //   571: aload_0
    //   572: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   575: invokestatic 196	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Z
    //   578: ifeq +103 -> 681
    //   581: aload_3
    //   582: ldc 198
    //   584: ldc 69
    //   586: invokeinterface 73 3 0
    //   591: astore_3
    //   592: aload_3
    //   593: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   596: ifeq +167 -> 763
    //   599: invokestatic 204	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 208	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   605: iconst_2
    //   606: invokevirtual 214	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   609: checkcast 216	mqq/manager/TicketManager
    //   612: astore_3
    //   613: aload_3
    //   614: aload_0
    //   615: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   618: getfield 26	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   621: invokevirtual 39	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   624: ldc 218
    //   626: invokeinterface 221 3 0
    //   631: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: ifeq +69 -> 703
    //   637: aload_0
    //   638: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   641: getfield 26	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   644: invokevirtual 39	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   647: astore 4
    //   649: aload_0
    //   650: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   653: invokestatic 224	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;)Loicq/wlogin_sdk/request/WtTicketPromise;
    //   656: astore 5
    //   658: aload_3
    //   659: aload 4
    //   661: ldc2_w 225
    //   664: iconst_1
    //   665: anewarray 119	java/lang/String
    //   668: dup
    //   669: iconst_0
    //   670: ldc 218
    //   672: aastore
    //   673: aload 5
    //   675: invokeinterface 230 6 0
    //   680: pop
    //   681: return
    //   682: astore 4
    //   684: ldc 232
    //   686: iconst_2
    //   687: aload 4
    //   689: invokevirtual 233	org/json/JSONException:toString	()Ljava/lang/String;
    //   692: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   695: aload 4
    //   697: invokevirtual 241	org/json/JSONException:printStackTrace	()V
    //   700: goto -129 -> 571
    //   703: new 243	aish
    //   706: dup
    //   707: aload_0
    //   708: invokespecial 246	aish:<init>	(Laisg;)V
    //   711: sipush 128
    //   714: aconst_null
    //   715: iconst_0
    //   716: invokestatic 252	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   719: return
    //   720: astore_3
    //   721: ldc 232
    //   723: iconst_2
    //   724: new 34	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   731: ldc 254
    //   733: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_3
    //   737: invokevirtual 255	java/lang/Exception:toString	()Ljava/lang/String;
    //   740: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: aload_3
    //   750: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   753: aload_0
    //   754: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   757: iconst_0
    //   758: invokestatic 179	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Z)Z
    //   761: pop
    //   762: return
    //   763: new 187	org/json/JSONObject
    //   766: dup
    //   767: aload_3
    //   768: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   771: astore_3
    //   772: aload_0
    //   773: getfield 12	aisg:a	Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;
    //   776: aload_3
    //   777: invokestatic 259	com/tencent/mobileqq/teamwork/spread/ConfigSetting:a	(Lcom/tencent/mobileqq/teamwork/spread/ConfigSetting;Lorg/json/JSONObject;)V
    //   780: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	aisg
    //   94	233	1	i	int
    //   92	6	2	j	int
    //   42	617	3	localObject1	Object
    //   720	48	3	localException	java.lang.Exception
    //   771	6	3	localJSONObject	org.json.JSONObject
    //   77	583	4	localObject2	Object
    //   682	14	4	localJSONException	org.json.JSONException
    //   104	570	5	localObject3	Object
    //   134	61	6	str	java.lang.String
    //   186	132	7	localaisl	aisl
    // Exception table:
    //   from	to	target	type
    //   550	571	682	org/json/JSONException
    //   581	681	720	java/lang/Exception
    //   703	719	720	java/lang/Exception
    //   763	780	720	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisg
 * JD-Core Version:    0.7.0.1
 */