import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.18;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.5;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afur
  implements Handler.Callback
{
  private final long jdField_a_of_type_Long = 60000L;
  private afvi jdField_a_of_type_Afvi;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected bbgg a;
  protected bcpq a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SDKEmotionSettingManager.5(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this);
  public boolean a;
  protected bbgg b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SDKEmotionSettingManager.6(this);
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private Runnable jdField_c_of_type_JavaLangRunnable = new SDKEmotionSettingManager.7(this);
  private String jdField_c_of_type_JavaLangString;
  private List<Uri> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  private String f;
  
  public afur(Activity paramActivity)
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
    while ((this.jdField_a_of_type_Afvi == null) || (!this.jdField_a_of_type_Afvi.isShowing())) {
      return;
    }
    int i = (int)(paramInt * paramFloat);
    int j = (int)(paramFloat * 100.0D);
    String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691341), new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "updateCurrentDisplay displayStr=" + str + " disPlayProgress=" + j + ", currentCount = " + i);
    }
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.18(this, str, j));
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
      str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691344), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      a(null, str, bool, paramString);
      axqw.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.jdField_c_of_type_JavaLangString, paramInt1 + paramInt2 + "", paramInt1 + "", paramInt2 + "");
      if (paramInt2 <= 0) {
        break;
      }
      axqw.b(null, "dc00898", "", "", "0X8009DCC", "0X8009DCC", 0, 0, "" + paramInt2, "", "", "");
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691346), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2), Integer.valueOf(paramInt2) });
        bool = false;
      }
      else if ((paramInt1 == 0) && (paramInt2 > 0))
      {
        str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691339), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt2) });
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
      localObject = ((Resources)localObject).getString(2131691345);
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
      axqw.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.jdField_c_of_type_JavaLangString, "1", paramString + "", str + "");
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        str = ((Resources)localObject).getString(2131691337);
        localObject = null;
        bool = false;
        break;
      }
      if (paramInt == 1)
      {
        str = ((Resources)localObject).getString(2131691342);
        localObject = null;
        bool = false;
        break;
      }
      str = ((Resources)localObject).getString(2131691340);
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
    ThreadManager.getUIHandler().postDelayed(new SDKEmotionSettingManager.20(this, paramInt, j, str, paramList, k), 200L);
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
    for (String str = ajyc.a(2131713597);; str = ajyc.a(2131713597) + this.jdField_a_of_type_JavaLangString)
    {
      bbgg localbbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      localbbgg.setTitle(paramString1);
      localbbgg.setMessage(paramString2);
      localbbgg.setPositiveButton("留在QQ", new afvd(this, paramBoolean, paramString3)).setNegativeButton(str, new afvc(this, paramBoolean, paramString3)).show();
      return;
    }
  }
  
  private void a(List<Uri> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion uriList = " + paramList);
    }
    ((anss)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).b();
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    new afus(this, paramList).execute(new Void[0]);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "handleStopUpload totalSize =" + paramInt + ", mCurrentUploadedList = " + this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    j();
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
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.19(this, paramInt, k, paramInt - k));
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
    ((anss)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).a(paramArrayList, new afva(this, i));
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
  
  private void h()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719410) + this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_b_of_type_JavaLangString, 64);
        if (localObject1 == null) {
          break label319;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label319;
        }
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
        localObject1 = bbdm.a(((MessageDigest)localObject3).digest());
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject1 = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
          ((bbgg)localObject1).setMessage(ajyc.a(2131713602));
          ((bbgg)localObject1).setNegativeButton(2131690596, new afvb(this));
          ((bbgg)localObject1).setCancelable(false);
          ((bbgg)localObject1).show();
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          QLog.e("SDKEmotionSettingManager", 1, "show invalid param dialog, exception=", localException2);
          return;
        }
        localException1 = localException1;
        QLog.e("SDKEmotionSettingManager", 1, "check, get signature exception=", localException1);
        localObject2 = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "checkApiPermission api, mShareAppId=" + this.jdField_c_of_type_JavaLangString + ", mPkgName=" + this.jdField_b_of_type_JavaLangString + ",signature=" + (String)localObject1 + ",mSdkVerdion=" + this.e);
      }
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break;
      }
      QLog.e("SDKEmotionSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.jdField_c_of_type_JavaLangString, ", pkgName=", this.jdField_b_of_type_JavaLangString, ", signature=", localObject1 });
      QLog.e("SDKEmotionSettingManager", 1, "check, pkgName null");
      label319:
      localObject2 = null;
    }
    aabu.a();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("sdkVersion", this.e);
    ((Bundle)localObject3).putString("pkgName", this.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject3).putString("signature", localException2);
    a(2131719510);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    aabu.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_c_of_type_JavaLangString, (Bundle)localObject3).a("sdk_face_collection", null, new afve(this, str));
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " checkJumpAction mShareAppId = " + this.jdField_c_of_type_JavaLangString + "， mShareOpenId =" + this.jdField_d_of_type_JavaLangString);
    }
    if (!bbev.d(BaseApplicationImpl.getContext()))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), false, "-10");
      k();
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      c();
      a(this.jdField_c_of_type_JavaUtilList);
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OpenID localOpenID = localQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString);
    if (localOpenID == null)
    {
      a(2131719510);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
      try
      {
        long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        localQQAppInterface.a().a(l, this.jdField_d_of_type_JavaLangString, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), new afvf(this));
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    if (!this.jdField_d_of_type_JavaLangString.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("SDKEmotionSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
      }
      d();
      return;
    }
    c();
    a(this.jdField_c_of_type_JavaUtilList);
  }
  
  private void j()
  {
    ((anss)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).e();
  }
  
  private void k()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    f();
    this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
  }
  
  private void l()
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
          if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion mComingStrUriList parse error !");
          }
        }
      } else {
        QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion JSONArray currentUris = " + localArrayList);
      }
    }
    paramList = new ArrayList();
    aqvt localaqvt = new aqvt(this.jdField_a_of_type_AndroidAppActivity, false, null);
    int i = 0;
    while (i < localArrayList.size())
    {
      String str = localaqvt.a((Uri)localArrayList.get(i), false);
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
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcpq.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_Bcpq.show();
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
    if (this.jdField_a_of_type_Bbgg != null) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    this.jdField_b_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_Bbgg.setMessage(paramString1);
    paramString1 = new afvg(this);
    this.jdField_b_of_type_Bbgg.setNegativeButton(paramString2, paramString1);
    this.jdField_b_of_type_Bbgg.setOnKeyListener(new afvh(this));
    this.jdField_b_of_type_Bbgg.show();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDKEmotionSettingManager", 2, "showPreviewDialog list =" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDKEmotionSettingManager", 2, "showPreviewDialog list null error");
      }
      return;
    }
    int i = paramArrayList.size();
    this.jdField_a_of_type_Afvi = new afvi(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Afvi.a("收藏为QQ表情");
    this.jdField_a_of_type_Afvi.a(2131690596, new afuu(this));
    this.jdField_a_of_type_Afvi.c(2131691329, new afuv(this, paramArrayList, i));
    this.jdField_a_of_type_Afvi.b(2131691330, new afuw(this, i));
    this.jdField_a_of_type_Afvi.a(paramArrayList, new afux(this, i, paramArrayList));
    if (i > 1)
    {
      paramArrayList = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691338), new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_Afvi.b(paramArrayList);
    }
    this.jdField_a_of_type_Afvi.setOnDismissListener(new afuy(this));
    this.jdField_a_of_type_Afvi.setOnKeyListener(new afuz(this, i));
    this.jdField_a_of_type_Afvi.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Afvi.show();
    AbstractGifImage.resumeAll();
  }
  
  public void b()
  {
    Intent localIntent = new Intent();
    PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
    if (localPendingIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "onBackEvent using PendingIntent");
      }
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
    if ((this.jdField_a_of_type_Afvi != null) && (this.jdField_a_of_type_Afvi.isShowing()))
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
      l();
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
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_Bbgg != null)
    {
      if (!this.jdField_b_of_type_Bbgg.isShowing()) {
        this.jdField_b_of_type_Bbgg.show();
      }
      return;
    }
    this.jdField_b_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_Bbgg.setMessage(ajyc.a(2131713598));
    this.jdField_b_of_type_Bbgg.setTitle(2131692234);
    afut localafut = new afut(this);
    this.jdField_b_of_type_Bbgg.setNegativeButton(2131690596, localafut);
    this.jdField_b_of_type_Bbgg.setPositiveButton(2131719420, localafut);
    this.jdField_b_of_type_Bbgg.show();
  }
  
  public void e()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (this.jdField_a_of_type_Afvi != null) {
      this.jdField_a_of_type_Afvi.dismiss();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected void f()
  {
    l();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afur
 * JD-Core Version:    0.7.0.1
 */