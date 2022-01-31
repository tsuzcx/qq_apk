import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppViewByIntentCallback;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.ark.ArkRecommendLogic.SemanticAnalysisResult;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import java.util.ArrayList;

public class aard
  implements ArkLocalAppMgr.IGetAppViewByIntentCallback
{
  public aard(ArkRecommendLogic paramArkRecommendLogic, ArrayList paramArrayList, ArkAiInfo paramArkAiInfo, RecommendCommonMessage paramRecommendCommonMessage, QQAppInterface paramQQAppInterface, String paramString, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, ArkRecommendLogic.SemanticAnalysisResult paramSemanticAnalysisResult) {}
  
  /* Error */
  public void a(String paramString1, String arg2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +401 -> 405
    //   7: aload_2
    //   8: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +394 -> 405
    //   14: aload_3
    //   15: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +387 -> 405
    //   21: aload 4
    //   23: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +379 -> 405
    //   29: aload 5
    //   31: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +371 -> 405
    //   37: ldc 48
    //   39: astore 7
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 21	aard:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   47: invokestatic 54	com/tencent/wordsegment/ContextAnalyze:descParser	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/String;
    //   50: astore_2
    //   51: new 56	com/tencent/mobileqq/ark/ArkAiInfo
    //   54: dup
    //   55: invokespecial 57	com/tencent/mobileqq/ark/ArkAiInfo:<init>	()V
    //   58: astore 7
    //   60: aload 7
    //   62: aload_0
    //   63: getfield 23	aard:jdField_a_of_type_ComTencentMobileqqArkArkAiInfo	Lcom/tencent/mobileqq/ark/ArkAiInfo;
    //   66: getfield 60	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: putfield 60	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   72: aload 7
    //   74: aload_0
    //   75: getfield 23	aard:jdField_a_of_type_ComTencentMobileqqArkArkAiInfo	Lcom/tencent/mobileqq/ark/ArkAiInfo;
    //   78: getfield 63	com/tencent/mobileqq/ark/ArkAiInfo:h	Ljava/lang/String;
    //   81: putfield 63	com/tencent/mobileqq/ark/ArkAiInfo:h	Ljava/lang/String;
    //   84: aload 7
    //   86: aload_0
    //   87: getfield 23	aard:jdField_a_of_type_ComTencentMobileqqArkArkAiInfo	Lcom/tencent/mobileqq/ark/ArkAiInfo;
    //   90: getfield 66	com/tencent/mobileqq/ark/ArkAiInfo:f	Ljava/lang/String;
    //   93: putfield 66	com/tencent/mobileqq/ark/ArkAiInfo:f	Ljava/lang/String;
    //   96: aload 7
    //   98: aload_1
    //   99: putfield 67	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload 7
    //   104: aload 4
    //   106: putfield 70	com/tencent/mobileqq/ark/ArkAiInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload 7
    //   111: aload_3
    //   112: putfield 73	com/tencent/mobileqq/ark/ArkAiInfo:d	Ljava/lang/String;
    //   115: aload 7
    //   117: aload 5
    //   119: putfield 76	com/tencent/mobileqq/ark/ArkAiInfo:e	Ljava/lang/String;
    //   122: aload 7
    //   124: ldc 78
    //   126: putfield 81	com/tencent/mobileqq/ark/ArkAiInfo:c	Ljava/lang/String;
    //   129: aload 7
    //   131: aload_2
    //   132: putfield 84	com/tencent/mobileqq/ark/ArkAiInfo:g	Ljava/lang/String;
    //   135: aload 7
    //   137: aload_0
    //   138: getfield 23	aard:jdField_a_of_type_ComTencentMobileqqArkArkAiInfo	Lcom/tencent/mobileqq/ark/ArkAiInfo;
    //   141: getfield 87	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_Int	I
    //   144: putfield 87	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_Int	I
    //   147: aload 7
    //   149: aload_0
    //   150: getfield 23	aard:jdField_a_of_type_ComTencentMobileqqArkArkAiInfo	Lcom/tencent/mobileqq/ark/ArkAiInfo;
    //   153: getfield 89	com/tencent/mobileqq/ark/ArkAiInfo:jdField_b_of_type_Int	I
    //   156: putfield 89	com/tencent/mobileqq/ark/ArkAiInfo:jdField_b_of_type_Int	I
    //   159: aload_0
    //   160: getfield 25	aard:jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage	Lcom/tencent/mobileqq/data/RecommendCommonMessage;
    //   163: ifnull +167 -> 330
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_0
    //   169: getfield 19	aard:jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic	Lcom/tencent/mobileqq/ark/ArkRecommendLogic;
    //   172: invokestatic 94	com/tencent/mobileqq/ark/ArkRecommendLogic:a	(Lcom/tencent/mobileqq/ark/ArkRecommendLogic;)Ljava/util/LinkedHashMap;
    //   175: astore_2
    //   176: aload_2
    //   177: monitorenter
    //   178: aload_0
    //   179: getfield 19	aard:jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic	Lcom/tencent/mobileqq/ark/ArkRecommendLogic;
    //   182: invokestatic 94	com/tencent/mobileqq/ark/ArkRecommendLogic:a	(Lcom/tencent/mobileqq/ark/ArkRecommendLogic;)Ljava/util/LinkedHashMap;
    //   185: aload_0
    //   186: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   189: invokevirtual 100	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 102	java/util/List
    //   195: astore 4
    //   197: aload_0
    //   198: getfield 31	aard:jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo	Lcom/tencent/mobileqq/data/RecommendCommonMessage$ArkContextInfo;
    //   201: getfield 107	com/tencent/mobileqq/data/RecommendCommonMessage$ArkContextInfo:semantic	Ljava/util/LinkedHashMap;
    //   204: astore_3
    //   205: aload 4
    //   207: ifnonnull +217 -> 424
    //   210: new 109	java/util/ArrayList
    //   213: dup
    //   214: invokespecial 110	java/util/ArrayList:<init>	()V
    //   217: astore 4
    //   219: aload 4
    //   221: aload_3
    //   222: invokeinterface 114 2 0
    //   227: pop
    //   228: aload_0
    //   229: getfield 19	aard:jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic	Lcom/tencent/mobileqq/ark/ArkRecommendLogic;
    //   232: invokestatic 94	com/tencent/mobileqq/ark/ArkRecommendLogic:a	(Lcom/tencent/mobileqq/ark/ArkRecommendLogic;)Ljava/util/LinkedHashMap;
    //   235: aload_0
    //   236: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   239: aload 4
    //   241: invokevirtual 118	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: aload_0
    //   246: getfield 33	aard:jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$SemanticAnalysisResult	Lcom/tencent/mobileqq/ark/ArkRecommendLogic$SemanticAnalysisResult;
    //   249: aload_0
    //   250: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   253: aload_3
    //   254: aload_1
    //   255: invokeinterface 123 4 0
    //   260: ldc 125
    //   262: ldc 127
    //   264: iconst_1
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload_0
    //   271: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   274: aastore
    //   275: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokestatic 138	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_2
    //   282: monitorexit
    //   283: return
    //   284: astore 8
    //   286: aload 7
    //   288: astore_2
    //   289: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -241 -> 51
    //   295: ldc 146
    //   297: iconst_2
    //   298: new 148	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   305: ldc 151
    //   307: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 8
    //   312: invokevirtual 159	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore_2
    //   327: goto -276 -> 51
    //   330: iconst_0
    //   331: ifne +196 -> 527
    //   334: new 109	java/util/ArrayList
    //   337: dup
    //   338: invokespecial 110	java/util/ArrayList:<init>	()V
    //   341: astore_2
    //   342: aload_2
    //   343: aload 7
    //   345: invokevirtual 166	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   348: pop
    //   349: aload_0
    //   350: getfield 27	aard:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: aload 7
    //   355: getfield 67	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   358: aload 7
    //   360: getfield 63	com/tencent/mobileqq/ark/ArkAiInfo:h	Ljava/lang/String;
    //   363: aload 7
    //   365: getfield 87	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_Int	I
    //   368: invokestatic 172	com/tencent/mobileqq/ark/ArkAppDataReport:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   371: aload_2
    //   372: astore_1
    //   373: iconst_4
    //   374: aload 7
    //   376: getfield 87	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_Int	I
    //   379: if_icmpne -211 -> 168
    //   382: aload_0
    //   383: getfield 27	aard:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   386: aload 7
    //   388: getfield 67	com/tencent/mobileqq/ark/ArkAiInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   391: aload 7
    //   393: getfield 63	com/tencent/mobileqq/ark/ArkAiInfo:h	Ljava/lang/String;
    //   396: iconst_1
    //   397: invokestatic 172	com/tencent/mobileqq/ark/ArkAppDataReport:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   400: aload_2
    //   401: astore_1
    //   402: goto -234 -> 168
    //   405: ldc 146
    //   407: ldc 174
    //   409: iconst_0
    //   410: anewarray 4	java/lang/Object
    //   413: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   416: invokestatic 138	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aconst_null
    //   420: astore_1
    //   421: goto -253 -> 168
    //   424: aload 4
    //   426: invokeinterface 178 1 0
    //   431: astore 5
    //   433: aload 5
    //   435: invokeinterface 183 1 0
    //   440: ifeq +81 -> 521
    //   443: aload 5
    //   445: invokeinterface 187 1 0
    //   450: checkcast 189	java/util/HashMap
    //   453: aload_3
    //   454: invokevirtual 192	java/util/HashMap:equals	(Ljava/lang/Object;)Z
    //   457: ifeq -24 -> 433
    //   460: iconst_1
    //   461: istore 6
    //   463: iload 6
    //   465: ifne -184 -> 281
    //   468: aload 4
    //   470: aload_3
    //   471: invokeinterface 114 2 0
    //   476: pop
    //   477: aload_0
    //   478: getfield 33	aard:jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$SemanticAnalysisResult	Lcom/tencent/mobileqq/ark/ArkRecommendLogic$SemanticAnalysisResult;
    //   481: aload_0
    //   482: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   485: aload_3
    //   486: aload_1
    //   487: invokeinterface 123 4 0
    //   492: ldc 125
    //   494: ldc 194
    //   496: iconst_1
    //   497: anewarray 4	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: aload_0
    //   503: getfield 29	aard:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: aastore
    //   507: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   510: invokestatic 138	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: goto -232 -> 281
    //   516: astore_1
    //   517: aload_2
    //   518: monitorexit
    //   519: aload_1
    //   520: athrow
    //   521: iconst_0
    //   522: istore 6
    //   524: goto -61 -> 463
    //   527: aconst_null
    //   528: astore_2
    //   529: goto -187 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	aard
    //   0	532	1	paramString1	String
    //   0	532	3	paramString3	String
    //   0	532	4	paramString4	String
    //   0	532	5	paramString5	String
    //   461	62	6	i	int
    //   39	353	7	localObject	Object
    //   284	27	8	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   41	51	284	java/lang/UnsatisfiedLinkError
    //   178	205	516	finally
    //   210	281	516	finally
    //   281	283	516	finally
    //   424	433	516	finally
    //   433	460	516	finally
    //   468	513	516	finally
    //   517	519	516	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aard
 * JD-Core Version:    0.7.0.1
 */