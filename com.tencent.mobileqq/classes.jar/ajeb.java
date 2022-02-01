import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class ajeb
  extends WebViewPlugin
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ajeb()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private void a()
  {
    QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
    bdll.a(null, "dc00898", "", "", "0X800B338", "0X800B338", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.mRuntime.a(), RegisterByNicknameAndPwdActivity.class);
    localIntent.putExtra("key_reg_from_phone_protect_h5", true);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK success, jump to LoginActivity, enableLoginWithMask: " + paramBoolean + "uinMask: " + paramString1);
    bdll.a(null, "dc00898", "", "", "0X800B337", "0X800B337", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.mRuntime.a(), LoginActivity.class);
    if (paramBoolean)
    {
      localIntent.putExtra("is_need_login_with_mask", true);
      localIntent.putExtra("uinMask", paramString1);
      localIntent.putExtra("uinEncrpyt", paramString2);
    }
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private boolean a()
  {
    return (this.mRuntime == null) || (this.mRuntime.a() == null);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    return (paramArrayOfString == null) || (paramArrayOfString.length == 0);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695758);
    localActionSheetItem.icon = 2130839095;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695741);
    localActionSheetItem.icon = 2130839089;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = anzj.a(2131704729);
    localActionSheetItem.icon = 2130839087;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695730);
    localActionSheetItem.icon = 2130839087;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    QQToast.a(this.mRuntime.a(), anzj.a(2131704727), 1).a();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.c)) {
      a(this.c);
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc 25
    //   8: iconst_2
    //   9: new 100	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   16: ldc 219
    //   18: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 221
    //   27: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 4
    //   32: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 223
    //   37: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_3
    //   41: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 225
    //   46: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 19
    //   62: aload_3
    //   63: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +5 -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc 238
    //   73: aload 4
    //   75: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   78: ifeq +123 -> 201
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmpeq +5 -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_1
    //   100: new 244	org/json/JSONObject
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 246	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 248
    //   112: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: aload_1
    //   118: ldc 253
    //   120: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: putfield 255	ajeb:b	Ljava/lang/String;
    //   126: getstatic 260	android/os/Build$VERSION:SDK_INT	I
    //   129: bipush 23
    //   131: if_icmplt +62 -> 193
    //   134: aload_0
    //   135: getfield 50	ajeb:mRuntime	Lbioy;
    //   138: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   141: ldc_w 262
    //   144: invokevirtual 266	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   147: ifeq +38 -> 185
    //   150: aload_0
    //   151: aload_2
    //   152: putfield 206	ajeb:c	Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 50	ajeb:mRuntime	Lbioy;
    //   159: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   162: checkcast 268	mqq/app/AppActivity
    //   165: aload_0
    //   166: iconst_1
    //   167: iconst_1
    //   168: anewarray 233	java/lang/String
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 262
    //   176: aastore
    //   177: invokevirtual 272	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_1
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 208	ajeb:a	(Ljava/lang/String;)V
    //   190: goto -10 -> 180
    //   193: aload_0
    //   194: aload_2
    //   195: invokespecial 208	ajeb:a	(Ljava/lang/String;)V
    //   198: goto -18 -> 180
    //   201: ldc_w 274
    //   204: aload 4
    //   206: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   209: ifeq +189 -> 398
    //   212: aload 5
    //   214: ifnull +10 -> 224
    //   217: aload 5
    //   219: arraylength
    //   220: iconst_1
    //   221: if_icmpeq +5 -> 226
    //   224: iconst_0
    //   225: ireturn
    //   226: aload 5
    //   228: iconst_0
    //   229: aaload
    //   230: astore_1
    //   231: aload_0
    //   232: new 244	org/json/JSONObject
    //   235: dup
    //   236: aload_1
    //   237: invokespecial 246	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: ldc 253
    //   242: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 276	ajeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 50	ajeb:mRuntime	Lbioy;
    //   252: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   255: astore_1
    //   256: aload_0
    //   257: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   260: ifnonnull +15 -> 275
    //   263: aload_0
    //   264: new 280	com/tencent/mobileqq/utils/ShareActionSheetBuilder
    //   267: dup
    //   268: aload_1
    //   269: invokespecial 283	com/tencent/mobileqq/utils/ShareActionSheetBuilder:<init>	(Landroid/content/Context;)V
    //   272: putfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   275: aload_0
    //   276: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   279: ldc_w 284
    //   282: invokestatic 171	anzj:a	(I)Ljava/lang/String;
    //   285: invokevirtual 288	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetTitle	(Ljava/lang/CharSequence;)V
    //   288: aload_0
    //   289: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   292: aload_0
    //   293: invokespecial 290	ajeb:a	()[Ljava/util/List;
    //   296: invokevirtual 294	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetItems	([Ljava/util/List;)V
    //   299: aload_0
    //   300: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   303: aload_0
    //   304: invokevirtual 298	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   307: aload_0
    //   308: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   311: aload_0
    //   312: invokevirtual 302	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   315: aload_1
    //   316: invokevirtual 305	android/app/Activity:isFinishing	()Z
    //   319: ifne +77 -> 396
    //   322: aload_0
    //   323: getfield 278	ajeb:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   326: invokevirtual 308	com/tencent/mobileqq/utils/ShareActionSheetBuilder:show	()V
    //   329: aconst_null
    //   330: ldc 35
    //   332: ldc 37
    //   334: ldc 37
    //   336: ldc_w 310
    //   339: ldc_w 310
    //   342: iconst_0
    //   343: iconst_0
    //   344: ldc 37
    //   346: ldc 37
    //   348: ldc 37
    //   350: ldc 37
    //   352: invokestatic 312	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   355: iconst_1
    //   356: ireturn
    //   357: astore_1
    //   358: iconst_0
    //   359: ireturn
    //   360: astore_1
    //   361: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq -9 -> 355
    //   367: ldc 25
    //   369: iconst_2
    //   370: new 100	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 314
    //   380: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_1
    //   384: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: goto -38 -> 355
    //   396: iconst_0
    //   397: ireturn
    //   398: ldc_w 316
    //   401: aload 4
    //   403: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   406: ifeq +121 -> 527
    //   409: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +12 -> 424
    //   415: ldc 25
    //   417: iconst_2
    //   418: ldc_w 318
    //   421: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: aload_0
    //   425: getfield 50	ajeb:mRuntime	Lbioy;
    //   428: ifnull +87 -> 515
    //   431: aload_0
    //   432: getfield 50	ajeb:mRuntime	Lbioy;
    //   435: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   438: ifnull +77 -> 515
    //   441: new 46	android/content/Intent
    //   444: dup
    //   445: invokespecial 319	android/content/Intent:<init>	()V
    //   448: astore_1
    //   449: aload_1
    //   450: ldc_w 321
    //   453: invokevirtual 325	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   456: pop
    //   457: aload_1
    //   458: invokestatic 331	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   461: invokevirtual 336	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   464: invokevirtual 339	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   467: pop
    //   468: aload_0
    //   469: getfield 50	ajeb:mRuntime	Lbioy;
    //   472: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   475: aload_1
    //   476: invokevirtual 342	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   479: goto -299 -> 180
    //   482: astore_1
    //   483: ldc 25
    //   485: iconst_1
    //   486: new 100	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 344
    //   496: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   503: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: goto -332 -> 180
    //   515: ldc 25
    //   517: iconst_1
    //   518: ldc_w 352
    //   521: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: goto -344 -> 180
    //   527: ldc_w 354
    //   530: aload 4
    //   532: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   535: ifeq +134 -> 669
    //   538: ldc 25
    //   540: iconst_1
    //   541: ldc_w 356
    //   544: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: aload 5
    //   550: invokespecial 358	ajeb:a	([Ljava/lang/String;)Z
    //   553: ifeq +14 -> 567
    //   556: ldc 25
    //   558: iconst_1
    //   559: ldc_w 360
    //   562: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: iconst_0
    //   566: ireturn
    //   567: aload_0
    //   568: invokespecial 362	ajeb:a	()Z
    //   571: ifeq +14 -> 585
    //   574: ldc 25
    //   576: iconst_1
    //   577: ldc_w 364
    //   580: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: iconst_0
    //   584: ireturn
    //   585: new 244	org/json/JSONObject
    //   588: dup
    //   589: aload 5
    //   591: iconst_0
    //   592: aaload
    //   593: invokespecial 246	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   596: astore_1
    //   597: aload_1
    //   598: ldc 124
    //   600: invokevirtual 367	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   603: astore_2
    //   604: aload_1
    //   605: ldc 126
    //   607: invokevirtual 367	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   610: astore_3
    //   611: aload_1
    //   612: ldc_w 369
    //   615: invokevirtual 372	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   618: istore 6
    //   620: aload_2
    //   621: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   624: ifne +10 -> 634
    //   627: aload_3
    //   628: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifeq +27 -> 658
    //   634: ldc 25
    //   636: iconst_1
    //   637: ldc_w 374
    //   640: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: iconst_0
    //   644: ireturn
    //   645: astore_1
    //   646: ldc 25
    //   648: iconst_1
    //   649: ldc_w 376
    //   652: aload_1
    //   653: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   656: iconst_0
    //   657: ireturn
    //   658: aload_0
    //   659: aload_2
    //   660: aload_3
    //   661: iload 6
    //   663: invokespecial 381	ajeb:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   666: goto -486 -> 180
    //   669: ldc_w 383
    //   672: aload 4
    //   674: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   677: ifeq +37 -> 714
    //   680: ldc 25
    //   682: iconst_1
    //   683: ldc_w 385
    //   686: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: invokespecial 362	ajeb:a	()Z
    //   693: ifeq +14 -> 707
    //   696: ldc 25
    //   698: iconst_1
    //   699: ldc_w 387
    //   702: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iconst_0
    //   706: ireturn
    //   707: aload_0
    //   708: invokespecial 389	ajeb:a	()V
    //   711: goto -531 -> 180
    //   714: ldc_w 391
    //   717: aload 4
    //   719: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifeq -542 -> 180
    //   725: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq +12 -> 740
    //   731: ldc 25
    //   733: iconst_2
    //   734: ldc_w 393
    //   737: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: aload_0
    //   741: getfield 50	ajeb:mRuntime	Lbioy;
    //   744: ifnull +54 -> 798
    //   747: aload_0
    //   748: getfield 50	ajeb:mRuntime	Lbioy;
    //   751: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   754: ifnull +44 -> 798
    //   757: new 46	android/content/Intent
    //   760: dup
    //   761: invokespecial 319	android/content/Intent:<init>	()V
    //   764: astore_1
    //   765: aload_1
    //   766: ldc_w 395
    //   769: invokevirtual 325	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   772: pop
    //   773: aload_1
    //   774: invokestatic 331	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   777: invokevirtual 336	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   780: invokevirtual 339	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   783: pop
    //   784: aload_0
    //   785: getfield 50	ajeb:mRuntime	Lbioy;
    //   788: invokevirtual 55	bioy:a	()Landroid/app/Activity;
    //   791: aload_1
    //   792: invokevirtual 342	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   795: goto -615 -> 180
    //   798: ldc 25
    //   800: iconst_1
    //   801: ldc_w 352
    //   804: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: goto -627 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	810	0	this	ajeb
    //   0	810	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	810	2	paramString1	String
    //   0	810	3	paramString2	String
    //   0	810	4	paramString3	String
    //   0	810	5	paramVarArgs	String[]
    //   618	44	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   100	126	182	org/json/JSONException
    //   231	248	357	org/json/JSONException
    //   322	355	360	java/lang/Exception
    //   409	424	482	java/lang/Exception
    //   424	479	482	java/lang/Exception
    //   515	524	482	java/lang/Exception
    //   585	597	645	java/lang/Exception
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramInt) });
    String str = "";
    if (paramInt == 0) {
      str = "0X80096FA";
    }
    for (;;)
    {
      if (!"".equals(str)) {
        bdll.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        str = "0X80096FB";
      } else if (paramInt == 2) {
        str = "0X80096FC";
      } else if (paramInt == 3) {
        str = "0X80096FD";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeb
 * JD-Core Version:    0.7.0.1
 */