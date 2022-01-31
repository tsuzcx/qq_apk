import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.2;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.4;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.6;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alqk
  extends alpc
{
  private alqp jdField_a_of_type_Alqp;
  private bdgf jdField_a_of_type_Bdgf;
  private bdld jdField_a_of_type_Bdld;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  
  alqk(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    QLog.i("ArkApp.downloadyyb.module", 1, "init");
    bdhk.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bdld = new alqm(this);
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: new 51	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 14
    //   10: getstatic 60	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   13: aload 14
    //   15: invokestatic 66	com/tencent/open/appcommon/js/DownloadInterface:parseSourceType	(Landroid/app/Activity;Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 22
    //   20: ldc 68
    //   22: aload 22
    //   24: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +20 -> 47
    //   30: ldc 76
    //   32: ldc 78
    //   34: ldc 80
    //   36: aload 14
    //   38: getstatic 86	bdlb:I	Ljava/lang/String;
    //   41: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 95	bdjr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +32 -> 82
    //   53: ldc 16
    //   55: iconst_1
    //   56: new 101	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   63: ldc 104
    //   65: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 14
    //   70: invokevirtual 112	org/json/JSONObject:toString	()Ljava/lang/String;
    //   73: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 24	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload 14
    //   84: getstatic 116	bdlb:j	Ljava/lang/String;
    //   87: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 23
    //   92: aload 23
    //   94: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +13 -> 110
    //   100: ldc 16
    //   102: iconst_1
    //   103: ldc 124
    //   105: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iconst_m1
    //   109: ireturn
    //   110: aload 14
    //   112: getstatic 130	bdlb:f	Ljava/lang/String;
    //   115: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 24
    //   120: aload 14
    //   122: getstatic 133	bdlb:k	Ljava/lang/String;
    //   125: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   128: istore_3
    //   129: aload 14
    //   131: getstatic 138	bdlb:i	Ljava/lang/String;
    //   134: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 25
    //   139: aload 14
    //   141: getstatic 141	bdlb:l	Ljava/lang/String;
    //   144: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 26
    //   149: aload 14
    //   151: getstatic 144	bdlb:D	Ljava/lang/String;
    //   154: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 15
    //   159: aload 14
    //   161: ldc 146
    //   163: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   166: istore_2
    //   167: aload 14
    //   169: getstatic 86	bdlb:I	Ljava/lang/String;
    //   172: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 16
    //   177: aload 14
    //   179: getstatic 149	bdlb:y	Ljava/lang/String;
    //   182: iconst_1
    //   183: invokevirtual 153	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   186: istore 6
    //   188: aload 14
    //   190: ldc 155
    //   192: iconst_0
    //   193: invokevirtual 153	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   196: istore 7
    //   198: aload 14
    //   200: ldc 157
    //   202: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   205: invokestatic 160	alqk:a	(I)Z
    //   208: istore 8
    //   210: aload 14
    //   212: getstatic 163	bdlb:x	Ljava/lang/String;
    //   215: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   218: istore 9
    //   220: aload 14
    //   222: getstatic 169	bdlb:C	Ljava/lang/String;
    //   225: iconst_0
    //   226: invokevirtual 172	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   229: istore 4
    //   231: aload 14
    //   233: getstatic 175	bdlb:J	Ljava/lang/String;
    //   236: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   239: invokestatic 160	alqk:a	(I)Z
    //   242: istore 10
    //   244: aload 14
    //   246: ldc 177
    //   248: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 27
    //   253: aload 14
    //   255: ldc 179
    //   257: ldc 181
    //   259: invokevirtual 184	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 12
    //   264: aload 14
    //   266: getstatic 187	bdlb:K	Ljava/lang/String;
    //   269: ldc 181
    //   271: invokevirtual 184	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 13
    //   276: getstatic 60	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   279: invokestatic 191	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   282: ifnonnull +436 -> 718
    //   285: ldc 181
    //   287: astore_1
    //   288: aload 14
    //   290: getstatic 194	bdlb:r	Ljava/lang/String;
    //   293: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   296: invokestatic 160	alqk:a	(I)Z
    //   299: istore 5
    //   301: aload 14
    //   303: ldc 196
    //   305: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   308: astore 17
    //   310: new 101	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   317: aload 14
    //   319: ldc 198
    //   321: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   324: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc 181
    //   329: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: astore 18
    //   337: new 101	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   344: aload 14
    //   346: ldc 203
    //   348: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   351: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc 181
    //   356: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 19
    //   364: new 101	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   371: aload 14
    //   373: ldc 205
    //   375: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   378: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: ldc 181
    //   383: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: astore 20
    //   391: new 101	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   398: aload 14
    //   400: ldc 207
    //   402: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   405: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc 181
    //   410: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: astore 21
    //   418: aload_0
    //   419: getfield 209	alqk:jdField_a_of_type_Bdgf	Lbdgf;
    //   422: ifnonnull +306 -> 728
    //   425: aload_0
    //   426: new 211	bdgf
    //   429: dup
    //   430: aload 27
    //   432: aload 25
    //   434: iload_3
    //   435: invokespecial 214	bdgf:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   438: putfield 209	alqk:jdField_a_of_type_Bdgf	Lbdgf;
    //   441: invokestatic 29	bdhk:a	()Lbdhk;
    //   444: aload 23
    //   446: invokevirtual 218	bdhk:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   449: astore 11
    //   451: aload 11
    //   453: ifnonnull +356 -> 809
    //   456: new 220	com/tencent/open/downloadnew/DownloadInfo
    //   459: dup
    //   460: aload 27
    //   462: aload 23
    //   464: invokevirtual 223	java/lang/String:trim	()Ljava/lang/String;
    //   467: aload 24
    //   469: aload 26
    //   471: aload 25
    //   473: aconst_null
    //   474: aload 22
    //   476: iload 6
    //   478: invokespecial 226	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   481: astore 11
    //   483: aload 11
    //   485: iload_3
    //   486: putfield 229	com/tencent/open/downloadnew/DownloadInfo:g	I
    //   489: iload 6
    //   491: ifeq +264 -> 755
    //   494: aload 11
    //   496: iload 8
    //   498: putfield 232	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   501: aload 11
    //   503: iload 9
    //   505: putfield 234	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   508: aload 11
    //   510: iload 4
    //   512: putfield 237	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_Int	I
    //   515: aload 11
    //   517: aload 15
    //   519: putfield 240	com/tencent/open/downloadnew/DownloadInfo:n	Ljava/lang/String;
    //   522: aload 11
    //   524: iload_2
    //   525: putfield 242	com/tencent/open/downloadnew/DownloadInfo:i	I
    //   528: aload 11
    //   530: aload 16
    //   532: putfield 245	com/tencent/open/downloadnew/DownloadInfo:o	Ljava/lang/String;
    //   535: aload 11
    //   537: iload 10
    //   539: putfield 248	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Boolean	Z
    //   542: aload 11
    //   544: iconst_0
    //   545: putfield 250	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Int	I
    //   548: aload 11
    //   550: aload 14
    //   552: getstatic 252	bdlb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   555: invokevirtual 136	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   558: putfield 254	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Int	I
    //   561: aload 11
    //   563: aload 14
    //   565: getstatic 257	bdlb:G	Ljava/lang/String;
    //   568: invokevirtual 261	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   571: putfield 263	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   574: aload 11
    //   576: aload 17
    //   578: putfield 266	com/tencent/open/downloadnew/DownloadInfo:q	Ljava/lang/String;
    //   581: aload 11
    //   583: aload 18
    //   585: putfield 267	com/tencent/open/downloadnew/DownloadInfo:r	Ljava/lang/String;
    //   588: aload 11
    //   590: aload 12
    //   592: putfield 268	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   595: aload 11
    //   597: aload 13
    //   599: putfield 271	com/tencent/open/downloadnew/DownloadInfo:s	Ljava/lang/String;
    //   602: aload 11
    //   604: aload 19
    //   606: putfield 274	com/tencent/open/downloadnew/DownloadInfo:t	Ljava/lang/String;
    //   609: aload 11
    //   611: aload 20
    //   613: putfield 277	com/tencent/open/downloadnew/DownloadInfo:u	Ljava/lang/String;
    //   616: aload 11
    //   618: aload 21
    //   620: putfield 280	com/tencent/open/downloadnew/DownloadInfo:v	Ljava/lang/String;
    //   623: aload 11
    //   625: iload 7
    //   627: putfield 282	com/tencent/open/downloadnew/DownloadInfo:jdField_e_of_type_Boolean	Z
    //   630: aload 11
    //   632: ldc_w 284
    //   635: aload_1
    //   636: invokevirtual 287	com/tencent/open/downloadnew/DownloadInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   639: pop
    //   640: aload 11
    //   642: invokevirtual 289	com/tencent/open/downloadnew/DownloadInfo:a	()V
    //   645: getstatic 60	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   648: astore_1
    //   649: aload_1
    //   650: invokestatic 294	bdid:d	(Landroid/content/Context;)Z
    //   653: istore 6
    //   655: aload_1
    //   656: invokestatic 297	bdid:c	(Landroid/content/Context;)Z
    //   659: istore 7
    //   661: aload 11
    //   663: ifnull +149 -> 812
    //   666: aload 11
    //   668: invokevirtual 300	com/tencent/open/downloadnew/DownloadInfo:a	()I
    //   671: iconst_1
    //   672: if_icmpne +117 -> 789
    //   675: goto +137 -> 812
    //   678: iload 5
    //   680: ifeq +114 -> 794
    //   683: iload 6
    //   685: ifeq +109 -> 794
    //   688: iload 7
    //   690: ifne +104 -> 794
    //   693: iload_2
    //   694: ifeq +100 -> 794
    //   697: iload_3
    //   698: iconst_2
    //   699: if_icmpne +95 -> 794
    //   702: aload_1
    //   703: ifnull +91 -> 794
    //   706: aload_0
    //   707: getstatic 60	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   710: aload 11
    //   712: invokevirtual 303	alqk:a	(Landroid/app/Activity;Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   715: goto +102 -> 817
    //   718: getstatic 60	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   721: invokestatic 191	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   724: astore_1
    //   725: goto -437 -> 288
    //   728: aload_0
    //   729: getfield 209	alqk:jdField_a_of_type_Bdgf	Lbdgf;
    //   732: aload 27
    //   734: aload 25
    //   736: iload_3
    //   737: invokevirtual 306	bdgf:a	(Ljava/lang/String;Ljava/lang/String;I)Z
    //   740: ifeq -299 -> 441
    //   743: ldc 16
    //   745: iconst_1
    //   746: ldc_w 308
    //   749: invokestatic 24	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: bipush 253
    //   754: ireturn
    //   755: aload 11
    //   757: iconst_0
    //   758: putfield 232	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   761: aload 11
    //   763: iconst_1
    //   764: putfield 234	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   767: aload 11
    //   769: iconst_2
    //   770: putfield 310	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   773: goto -265 -> 508
    //   776: astore_1
    //   777: ldc 16
    //   779: iconst_1
    //   780: ldc_w 312
    //   783: aload_1
    //   784: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   787: iconst_m1
    //   788: ireturn
    //   789: iconst_0
    //   790: istore_2
    //   791: goto -113 -> 678
    //   794: aload_0
    //   795: aload 11
    //   797: iload_3
    //   798: invokespecial 318	alqk:a	(Lcom/tencent/open/downloadnew/DownloadInfo;I)V
    //   801: goto +16 -> 817
    //   804: astore 14
    //   806: goto -232 -> 574
    //   809: goto -326 -> 483
    //   812: iconst_1
    //   813: istore_2
    //   814: goto -136 -> 678
    //   817: iconst_1
    //   818: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	alqk
    //   0	819	1	paramString	String
    //   166	648	2	i	int
    //   128	670	3	j	int
    //   229	282	4	k	int
    //   299	380	5	bool1	boolean
    //   186	498	6	bool2	boolean
    //   196	493	7	bool3	boolean
    //   208	289	8	bool4	boolean
    //   218	286	9	bool5	boolean
    //   242	296	10	bool6	boolean
    //   449	347	11	localDownloadInfo	DownloadInfo
    //   262	329	12	str1	String
    //   274	324	13	str2	String
    //   8	556	14	localJSONObject	JSONObject
    //   804	1	14	localNumberFormatException	java.lang.NumberFormatException
    //   157	361	15	str3	String
    //   175	356	16	str4	String
    //   308	269	17	str5	String
    //   335	249	18	str6	String
    //   362	243	19	str7	String
    //   389	223	20	str8	String
    //   416	203	21	str9	String
    //   18	457	22	str10	String
    //   90	373	23	str11	String
    //   118	350	24	str12	String
    //   137	598	25	str13	String
    //   147	323	26	str14	String
    //   251	482	27	str15	String
    // Exception table:
    //   from	to	target	type
    //   0	47	776	java/lang/Exception
    //   47	82	776	java/lang/Exception
    //   82	108	776	java/lang/Exception
    //   110	285	776	java/lang/Exception
    //   288	441	776	java/lang/Exception
    //   441	451	776	java/lang/Exception
    //   456	483	776	java/lang/Exception
    //   483	489	776	java/lang/Exception
    //   494	508	776	java/lang/Exception
    //   508	548	776	java/lang/Exception
    //   548	574	776	java/lang/Exception
    //   574	661	776	java/lang/Exception
    //   666	675	776	java/lang/Exception
    //   706	715	776	java/lang/Exception
    //   718	725	776	java/lang/Exception
    //   728	752	776	java/lang/Exception
    //   755	773	776	java/lang/Exception
    //   794	801	776	java/lang/Exception
    //   548	574	804	java/lang/NumberFormatException
  }
  
  private void a(int paramInt, JSONArray paramJSONArray, long paramLong)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject1;
      Object localObject2;
      try
      {
        int j = paramJSONArray.length();
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject1 = paramJSONArray.getJSONObject(i);
          localObject2 = new DownloadInfo();
          ((DownloadInfo)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("url");
          ((DownloadInfo)localObject2).jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("packageName");
          ((DownloadInfo)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("versionCode");
          ((DownloadInfo)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("appId");
          ((DownloadInfo)localObject2).a();
          localArrayList.add(localObject2);
          i += 1;
          continue;
        }
        QLog.d("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB action is " + paramInt);
        switch (paramInt)
        {
        default: 
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        int i;
        QLog.e("ArkApp.downloadyyb.module", 1, "[innerQuery] e=", paramJSONArray);
        return;
      }
      try
      {
        paramJSONArray = new JSONArray();
        i = localArrayList.size();
        paramInt = 0;
        if (paramInt < i)
        {
          localObject1 = (DownloadInfo)localArrayList.get(paramInt);
          localObject1 = bdhk.a().b(((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString);
          if (localObject1 == null) {
            break label426;
          }
          paramJSONArray.put(a((DownloadInfo)localObject1));
          break label426;
        }
        paramJSONArray = paramJSONArray.toString();
        ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppYYBDownloadModule.4(this, paramLong, paramJSONArray));
        return;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + paramJSONArray);
        return;
      }
      if (localArrayList.size() > 0)
      {
        paramJSONArray = BaseActivity.sTopActivity;
        localObject1 = new JSONArray();
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          localObject2 = (DownloadInfo)localArrayList.get(paramInt);
          boolean bool = bbfr.a(paramJSONArray, ((DownloadInfo)localObject2).jdField_e_of_type_JavaLangString);
          localObject2 = a((DownloadInfo)localObject2);
          ((JSONObject)localObject2).put("isInstall", bool);
          ((JSONArray)localObject1).put(localObject2);
          paramInt += 1;
        }
        paramJSONArray = ((JSONArray)localObject1).toString();
        ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppYYBDownloadModule.5(this, paramLong, paramJSONArray));
        return;
        label426:
        paramInt += 1;
      }
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] is null ");
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "[doDownloadAction] Exception", paramDownloadInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] object " + paramDownloadInfo.toString() + "action =" + paramInt);
      break label159;
      bdhk.a().b(paramDownloadInfo);
      return;
      bdhk.a().b(paramDownloadInfo);
      return;
      bdhk.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      return;
      bdhk.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString, true);
      return;
      if (!paramDownloadInfo.jdField_c_of_type_Boolean)
      {
        QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] not apk");
        return;
      }
      bdjr.a("305", paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
      bdhk.a().a(paramDownloadInfo);
      return;
    }
    label159:
    switch (paramInt)
    {
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppYYBDownloadModule.2(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_Alqp = null;
    bdhk.a().b(this.jdField_a_of_type_Bdld);
    this.jdField_a_of_type_Bdld = null;
  }
  
  public String GetTypeName()
  {
    return "QQYYBDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("getQueryDownloadAction")) {}
    while ((paramString.equals("doDownloadAction")) || (paramString.equals("RegisterDownloadCallBackListener"))) {
      return true;
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!aloy.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.YYB_DOWNLOAD"))
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690231));
      }
    }
    long l;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.downloadyyb.module", 1, String.format("ArkAppYYBDownloadModule.invokeFunc.%s", new Object[] { paramString }));
      }
      if (paramString.equals("getQueryDownloadAction"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          l = a(paramArrayOfVariantWrapper[1].Copy());
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "<getQueryDownloadAction> paramJson=" + paramString);
          }
        }
        try
        {
          paramString = new JSONObject(paramString);
          paramArrayOfVariantWrapper = new JSONArray(paramString.optString("queryParams"));
          a(paramString.optInt("actioncode"), paramArrayOfVariantWrapper, l);
          return true;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            QLog.e("ArkApp.downloadyyb.module", 1, "[queryDownloadAction] e=" + paramString.getMessage());
          }
        }
      }
      if (paramString.equals("doDownloadAction"))
      {
        if (this.jdField_a_of_type_Alqp == null)
        {
          QLog.e("ArkApp.downloadyyb.module", 1, "should DownloadInit first ");
          paramVariantWrapper.SetInt(-2);
          return true;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule = " + paramString);
          }
          paramVariantWrapper.SetInt(a(paramString));
          return true;
        }
        paramVariantWrapper.SetInt(-1);
        return true;
      }
    } while (!paramString.equals("RegisterDownloadCallBackListener"));
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      l = a(paramArrayOfVariantWrapper[0].Copy());
      bdhk.a().a(this.jdField_a_of_type_Bdld);
      this.jdField_a_of_type_Alqp = new alql(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
      paramVariantWrapper.SetBool(true);
      return true;
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  public JSONObject a(DownloadInfo paramDownloadInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramDownloadInfo != null) {
      try
      {
        localJSONObject.put("appid", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localJSONObject.put("state", paramDownloadInfo.a());
        localJSONObject.put("pro", paramDownloadInfo.f);
        localJSONObject.put("packagename", paramDownloadInfo.jdField_e_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramDownloadInfo.l))
        {
          localJSONObject.put("final_file_exits", "false");
          return localJSONObject;
        }
        localJSONObject.put("final_file_exits", new File(paramDownloadInfo.l).exists());
        return localJSONObject;
      }
      catch (JSONException paramDownloadInfo)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "tranDownloadToJSONObject ", paramDownloadInfo);
      }
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt3);
      localJSONObject.put("writecodestate", paramInt4);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppYYBDownloadModule.6(this, paramDownloadInfo, paramActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqk
 * JD-Core Version:    0.7.0.1
 */