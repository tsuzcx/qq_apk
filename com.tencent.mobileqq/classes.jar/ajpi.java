import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.8;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class ajpi
  implements Handler.Callback
{
  private final long jdField_a_of_type_Long = 60000L;
  private ajqb jdField_a_of_type_Ajqb;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected bisl a;
  protected QQCustomDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SDKEmotionSettingManager.6(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this);
  public boolean a;
  protected QQCustomDialog b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SDKEmotionSettingManager.7(this);
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private Runnable jdField_c_of_type_JavaLangRunnable = new SDKEmotionSettingManager.8(this);
  private String jdField_c_of_type_JavaLangString;
  private List<Uri> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  private String f;
  
  public ajpi(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " onCreateView ");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private String a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (j == 0) {
        localStringBuilder.append("0_");
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 1) {
          localStringBuilder.append("102_");
        } else if (j == 3) {
          localStringBuilder.append("100_");
        } else if (j == 2) {
          localStringBuilder.append("100_");
        } else {
          localStringBuilder.append("101_");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    while ((this.jdField_a_of_type_Ajqb == null) || (!this.jdField_a_of_type_Ajqb.isShowing())) {
      return;
    }
    int i = (int)(paramInt * paramFloat);
    int j = (int)(paramFloat * 100.0D);
    String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691293), new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "updateCurrentDisplay displayStr=" + str + " disPlayProgress=" + j + ", currentCount = " + i);
    }
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.19(this, str, j));
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "showResultDialog successCount =" + paramInt1 + ", failCount =" + paramInt2);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      break label51;
    }
    label51:
    while ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    String str = "";
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691296), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      a(null, str, bool, paramString);
      bdla.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.jdField_c_of_type_JavaLangString, paramInt1 + paramInt2 + "", paramInt1 + "", paramInt2 + "");
      if (paramInt2 <= 0) {
        break;
      }
      bdla.b(null, "dc00898", "", "", "0X8009DCC", "0X8009DCC", 0, 0, "" + paramInt2, "", "", "");
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691298), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2), Integer.valueOf(paramInt2) });
        bool = false;
      }
      else if ((paramInt1 == 0) && (paramInt2 > 0))
      {
        str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691291), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt2) });
        bool = false;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources();
    } while (localObject == null);
    String str = "";
    if (paramInt == 0)
    {
      localObject = ((Resources)localObject).getString(2131691297);
      a((String)localObject, str, bool, paramString);
      if (!bool) {
        break label194;
      }
      paramString = "1";
      label58:
      if (!bool) {
        break label200;
      }
    }
    label194:
    label200:
    for (str = "0";; str = "1")
    {
      bdla.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.jdField_c_of_type_JavaLangString, "1", paramString + "", str + "");
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        str = ((Resources)localObject).getString(2131691289);
        localObject = null;
        bool = false;
        break;
      }
      if (paramInt == 1)
      {
        str = ((Resources)localObject).getString(2131691294);
        localObject = null;
        bool = false;
        break;
      }
      str = ((Resources)localObject).getString(2131691292);
      localObject = null;
      bool = false;
      break;
      paramString = "0";
      break label58;
    }
  }
  
  private void a(int paramInt, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "handleFinishUpload addEmotionsResults =" + paramList + ", totalSize =" + paramInt);
    }
    if ((paramInt == 0) || (paramList == null)) {}
    while (paramInt != paramList.size()) {
      return;
    }
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < paramList.size())
    {
      if (((Integer)paramList.get(i)).intValue() == 0) {
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
      }
    }
    String str = a(paramList);
    ThreadManager.getUIHandler().postDelayed(new SDKEmotionSettingManager.21(this, paramInt, j, str, paramList, k), 200L);
  }
  
  private void a(Activity paramActivity, long paramLong)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkCancelCallback:sdk callback= appid=" + paramLong);
        }
        Object localObject = new Intent();
        ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
        if (paramActivity.getIntent() != null) {
          ((Intent)localObject).setPackage(this.jdField_b_of_type_JavaLangString);
        }
        try
        {
          localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
            return;
          }
        }
        catch (ActivityNotFoundException paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkSuccessCallback:sdk callback= appid=" + paramLong);
        }
        Object localObject = new Intent();
        if (paramBoolean) {
          ((Intent)localObject).putExtra("stay_back_stack", true);
        }
        ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
        if (paramActivity.getIntent() != null) {
          ((Intent)localObject).setPackage(this.jdField_b_of_type_JavaLangString);
        }
        try
        {
          localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
            return;
          }
        }
        catch (ActivityNotFoundException paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkErrorCallback:sdk callback= appid=" + paramLong);
        }
        Intent localIntent = new Intent();
        if (paramBoolean) {
          localIntent.putExtra("stay_back_stack", true);
        }
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion", Integer.valueOf(-1), str })));
        if (paramActivity.getIntent() != null) {
          localIntent.setPackage(this.jdField_b_of_type_JavaLangString);
        }
        try
        {
          paramString = PendingIntent.getActivity(paramActivity, 0, localIntent, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", paramString);
            return;
          }
        }
        catch (Exception paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "showResultDialog is finishing return");
      }
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str = anvx.a(2131713059);; str = anvx.a(2131713059) + this.jdField_a_of_type_JavaLangString)
    {
      QQCustomDialog localQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      localQQCustomDialog.setTitle(paramString1);
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setPositiveButton("留在QQ", new ajpv(this, paramBoolean, paramString3)).setNegativeButton(str, new ajpu(this, paramBoolean, paramString3)).show();
      return;
    }
  }
  
  private void a(List<Uri> paramList)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { " openSetEmotion uriList = ", paramList });
    ((asfl)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).b();
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    new ajpj(this, paramList).execute(new Void[0]);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "handleStopUpload totalSize =" + paramInt + ", mCurrentUploadedList = " + this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    k();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        k = i;
        if (((Integer)this.jdField_a_of_type_JavaUtilList.get(j)).intValue() == 0) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.20(this, paramInt, k, paramInt - k));
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    int i = paramArrayList.size();
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(11);
    localMessage.arg1 = i;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 60000L);
    ((asfl)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).a(paramArrayList, new ajps(this, i));
  }
  
  private void b(List<Integer> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 105	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: getfield 87	ajpi:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   13: ldc_w 528
    //   16: invokevirtual 529	android/app/Activity:getString	(I)Ljava/lang/String;
    //   19: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 370	ajpi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokestatic 376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +276 -> 316
    //   43: aload_0
    //   44: getfield 87	ajpi:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   47: invokevirtual 533	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   50: aload_0
    //   51: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: bipush 64
    //   56: invokevirtual 539	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   59: astore 4
    //   61: aload_2
    //   62: astore_1
    //   63: aload 4
    //   65: ifnull +51 -> 116
    //   68: aload 4
    //   70: getfield 545	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   73: astore 4
    //   75: aload_2
    //   76: astore_1
    //   77: aload 4
    //   79: ifnull +37 -> 116
    //   82: aload_2
    //   83: astore_1
    //   84: aload 4
    //   86: arraylength
    //   87: ifle +29 -> 116
    //   90: ldc_w 547
    //   93: invokestatic 553	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   96: astore_1
    //   97: aload_1
    //   98: aload 4
    //   100: iconst_0
    //   101: aaload
    //   102: invokevirtual 559	android/content/pm/Signature:toByteArray	()[B
    //   105: invokevirtual 563	java/security/MessageDigest:update	([B)V
    //   108: aload_1
    //   109: invokevirtual 566	java/security/MessageDigest:digest	()[B
    //   112: invokestatic 572	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   115: astore_1
    //   116: ldc 79
    //   118: iconst_1
    //   119: bipush 8
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc_w 574
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_0
    //   133: getfield 96	ajpi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_2
    //   139: ldc_w 576
    //   142: aastore
    //   143: dup
    //   144: iconst_3
    //   145: aload_0
    //   146: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   149: aastore
    //   150: dup
    //   151: iconst_4
    //   152: ldc_w 578
    //   155: aastore
    //   156: dup
    //   157: iconst_5
    //   158: aload_1
    //   159: aastore
    //   160: dup
    //   161: bipush 6
    //   163: ldc_w 580
    //   166: aastore
    //   167: dup
    //   168: bipush 7
    //   170: aload_0
    //   171: getfield 582	ajpi:e	Ljava/lang/String;
    //   174: aastore
    //   175: invokestatic 421	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 96	ajpi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   182: invokestatic 376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +20 -> 205
    //   188: aload_0
    //   189: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   192: invokestatic 376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne +10 -> 205
    //   198: aload_1
    //   199: invokestatic 376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +140 -> 342
    //   205: ldc 79
    //   207: iconst_1
    //   208: bipush 6
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc_w 584
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_0
    //   222: getfield 96	ajpi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: ldc_w 586
    //   231: aastore
    //   232: dup
    //   233: iconst_3
    //   234: aload_0
    //   235: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_4
    //   241: ldc_w 588
    //   244: aastore
    //   245: dup
    //   246: iconst_5
    //   247: aload_1
    //   248: aastore
    //   249: invokestatic 590	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: aload_0
    //   253: getfield 87	ajpi:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   256: sipush 230
    //   259: invokestatic 386	bhdj:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   262: astore_1
    //   263: aload_1
    //   264: ldc_w 591
    //   267: invokestatic 381	anvx:a	(I)Ljava/lang/String;
    //   270: invokevirtual 396	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   273: pop
    //   274: aload_1
    //   275: ldc_w 592
    //   278: new 594	ajpt
    //   281: dup
    //   282: aload_0
    //   283: invokespecial 595	ajpt:<init>	(Lajpi;)V
    //   286: invokevirtual 598	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   289: pop
    //   290: aload_1
    //   291: iconst_0
    //   292: invokevirtual 602	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   295: aload_1
    //   296: invokevirtual 416	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   299: return
    //   300: astore_1
    //   301: ldc 79
    //   303: iconst_1
    //   304: ldc_w 604
    //   307: aload_1
    //   308: invokestatic 607	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload_2
    //   312: astore_1
    //   313: goto -197 -> 116
    //   316: ldc 79
    //   318: iconst_1
    //   319: ldc_w 609
    //   322: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_2
    //   326: astore_1
    //   327: goto -211 -> 116
    //   330: astore_1
    //   331: ldc 79
    //   333: iconst_1
    //   334: ldc_w 613
    //   337: aload_1
    //   338: invokestatic 607	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: return
    //   342: invokestatic 617	adai:a	()V
    //   345: new 619	android/os/Bundle
    //   348: dup
    //   349: invokespecial 620	android/os/Bundle:<init>	()V
    //   352: astore_2
    //   353: aload_2
    //   354: ldc_w 622
    //   357: aload_0
    //   358: getfield 582	ajpi:e	Ljava/lang/String;
    //   361: invokevirtual 626	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_2
    //   365: ldc_w 628
    //   368: aload_0
    //   369: getfield 326	ajpi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokevirtual 626	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_2
    //   376: ldc_w 630
    //   379: aload_1
    //   380: invokevirtual 626	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: ldc_w 631
    //   387: invokevirtual 633	ajpi:a	(I)V
    //   390: aload_0
    //   391: getfield 54	ajpi:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   394: aload_0
    //   395: getfield 61	ajpi:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   398: ldc2_w 634
    //   401: invokevirtual 251	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   404: pop
    //   405: aload_0
    //   406: getfield 87	ajpi:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   409: iconst_1
    //   410: aload_0
    //   411: getfield 96	ajpi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   414: aload_2
    //   415: invokestatic 638	adai:a	(Landroid/app/Activity;ILjava/lang/String;Landroid/os/Bundle;)Ladad;
    //   418: ldc_w 640
    //   421: aconst_null
    //   422: new 642	ajpw
    //   425: dup
    //   426: aload_0
    //   427: aload_3
    //   428: invokespecial 645	ajpw:<init>	(Lajpi;Ljava/lang/String;)V
    //   431: invokevirtual 650	adad:a	(Ljava/lang/String;Lorg/json/JSONObject;Ladaa;)V
    //   434: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	ajpi
    //   62	234	1	localObject1	Object
    //   300	8	1	localException1	Exception
    //   312	15	1	localBundle1	android.os.Bundle
    //   330	50	1	localException2	Exception
    //   1	414	2	localBundle2	android.os.Bundle
    //   32	396	3	str	String
    //   59	40	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	61	300	java/lang/Exception
    //   68	75	300	java/lang/Exception
    //   84	116	300	java/lang/Exception
    //   252	299	330	java/lang/Exception
  }
  
  private void i()
  {
    boolean bool = ForwardUtils.hasSDPermission(this.jdField_a_of_type_AndroidAppActivity);
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "setEmotion hasPermission=", Boolean.valueOf(bool) });
    if (!bool)
    {
      PermissionUtils.requestStorePermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, 3, new ajpx(this));
      return;
    }
    a(this.jdField_c_of_type_JavaUtilList);
  }
  
  private void j()
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction mShareAppId = " + this.jdField_c_of_type_JavaLangString + "， mShareOpenId =" + this.jdField_d_of_type_JavaLangString);
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), false, "-10");
      l();
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction find third app not login setEmotion");
      c();
      i();
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OpenID localOpenID = localQQAppInterface.getMsgHandler().a(this.jdField_c_of_type_JavaLangString);
    if (localOpenID == null)
    {
      a(2131718796);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
      try
      {
        long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        localQQAppInterface.getMsgHandler().a(l, this.jdField_d_of_type_JavaLangString, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), new ajpz(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("SDKEmotionSettingManager", 1, "-->parse uin exception:", localException);
        return;
      }
    }
    if (!this.jdField_d_of_type_JavaLangString.equals(localOpenID.openID))
    {
      QLog.i("SDKEmotionSettingManager", 1, "-->preForward--openid doesn't equal current local openid");
      d();
      return;
    }
    c();
    i();
  }
  
  private void k()
  {
    ((asfl)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).e();
  }
  
  private void l()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    f();
    this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
  }
  
  private void m()
  {
    for (;;)
    {
      try
      {
        localPendingIntent = (PendingIntent)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
        if (localPendingIntent != null) {
          if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "-->finish--send callback using PendingIntent");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        PendingIntent localPendingIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SDKEmotionSettingManager", 2, "qbShowShareResultDialog ", localThrowable);
      }
      try
      {
        localPendingIntent.send();
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        QLog.e("SDKEmotionSettingManager", 2, "failed to send PendingIntent", localCanceledException);
        return;
      }
    }
  }
  
  public ArrayList<String> a(List<Uri> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      localArrayList.addAll(paramList);
    }
    while (localArrayList.size() == 0)
    {
      return null;
      if (!TextUtils.isEmpty(this.f)) {
        try
        {
          paramList = this.f.split(";");
          i = 0;
          while (i < paramList.length)
          {
            localArrayList.add(Uri.parse(paramList[i]));
            i += 1;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (Exception paramList)
        {
          QLog.d("SDKEmotionSettingManager", 1, " openSetEmotion mComingStrUriList parse error!", paramList);
        }
      } else {
        QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion JSONArray currentUris = " + localArrayList);
      }
    }
    paramList = new ArrayList();
    avit localavit = new avit(this.jdField_a_of_type_AndroidAppActivity, false, null);
    int i = 0;
    while (i < localArrayList.size())
    {
      String str = localavit.a((Uri)localArrayList.get(i), false);
      if (!TextUtils.isEmpty(str)) {
        paramList.add(str);
      }
      i += 1;
    }
    return paramList;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
    }
    this.jdField_a_of_type_Bisl.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.f = paramIntent.getStringExtra("key_from_sdk_set_emotion_uri_list");
    this.jdField_c_of_type_JavaUtilList = paramIntent.getParcelableArrayListExtra("key_from_sdk_set_emotion_uri");
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_appname");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_share_id");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_open_id");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("pkg_name");
    this.e = paramIntent.getStringExtra("sdk_version");
    g();
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " initParam ");
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
    paramString1 = new ajqa(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString2, paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new ajpk(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    QLog.i("SDKEmotionSettingManager", 1, "showPreviewDialog list =" + paramArrayList);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog list null error");
      return;
    }
    int i = paramArrayList.size();
    this.jdField_a_of_type_Ajqb = new ajqb(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Ajqb.a("收藏为QQ表情");
    this.jdField_a_of_type_Ajqb.a(2131690697, new ajpm(this));
    this.jdField_a_of_type_Ajqb.c(2131691286, new ajpn(this, paramArrayList, i));
    this.jdField_a_of_type_Ajqb.b(2131691287, new ajpo(this, i));
    this.jdField_a_of_type_Ajqb.a(paramArrayList, new ajpp(this, i, paramArrayList));
    if (i > 1)
    {
      paramArrayList = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691290), new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_Ajqb.b(paramArrayList);
    }
    this.jdField_a_of_type_Ajqb.setOnDismissListener(new ajpq(this));
    this.jdField_a_of_type_Ajqb.setOnKeyListener(new ajpr(this, i));
    this.jdField_a_of_type_Ajqb.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Ajqb.show();
    AbstractGifImage.resumeAll();
  }
  
  public void b()
  {
    Intent localIntent = new Intent();
    PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
    if (localPendingIntent != null)
    {
      QLog.d("SDKEmotionSettingManager", 1, "onBackEvent using PendingIntent");
      localIntent.putExtra("activity_finish_run_pendingIntent", localPendingIntent);
    }
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Ajqb != null) && (this.jdField_a_of_type_Ajqb.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, " onNewIntent return error");
      }
      paramIntent = null;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        paramIntent = new StringBuilder();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramIntent.append("104_");
        }
        paramIntent = paramIntent.toString();
      }
      a(this.jdField_a_of_type_AndroidAppActivity, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), false, paramIntent);
      m();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, " onNewIntent start new");
    }
    this.jdField_a_of_type_AndroidAppActivity.setIntent(paramIntent);
    a(paramIntent);
    a();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(anvx.a(2131713060));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692056);
    ajpl localajpl = new ajpl(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, localajpl);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718634, localajpl);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void e()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (this.jdField_a_of_type_Ajqb != null) {
      this.jdField_a_of_type_Ajqb.dismiss();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected void f()
  {
    m();
    Intent localIntent = new Intent();
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    this.jdField_d_of_type_Boolean = true;
    b(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpi
 * JD-Core Version:    0.7.0.1
 */