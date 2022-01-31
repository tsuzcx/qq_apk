import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.2;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.3;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class akyc
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, bhuk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bhuf jdField_a_of_type_Bhuf;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public akyc(Context paramContext, AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[ApolloGameShare], errInfo->" + paramContext.getMessage());
    }
  }
  
  private int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "[parseShareParm],jsonStr:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_JavaLangString = paramString.optString("extendInfo");
      this.c = paramString.optString("summary");
      this.jdField_a_of_type_JavaLangString = paramString.optString("localPicPath");
      this.jdField_b_of_type_Int = paramString.optInt("activityId");
      int i = paramString.optInt("reqCode");
      paramString = akwd.a(this.jdField_a_of_type_Int);
      if (paramString != null)
      {
        paramString.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        paramString.c = i;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->" + paramString.getMessage());
    }
    return -3;
  }
  
  private AppInterface a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.startsWith("GameSandBox:")) {
        break label84;
      }
      str = this.jdField_a_of_type_JavaLangString.substring("GameSandBox:".length() + "//".length());
      localStringBuilder.append(aliu.s);
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("/sandbox/");
      localStringBuilder.append(str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label84:
      if (this.jdField_a_of_type_JavaLangString.startsWith("GameRes:"))
      {
        str = this.jdField_a_of_type_JavaLangString.substring("GameRes:".length() + "//".length());
        localStringBuilder.append(aliu.s);
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(str);
      }
    }
  }
  
  private String a(int paramInt)
  {
    return aliu.s + paramInt + "/" + "shareQRCode_default_v2.png";
  }
  
  private void a(int paramInt)
  {
    ThreadManager.post(new CmGameCommonShare.4(this, paramInt), 5, null, true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    akyg localakyg = akwd.a(this.jdField_a_of_type_Int);
    if (localakyg != null) {
      localakyg.a(paramInt1, paramInt2, 0, "");
    }
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      localakyg = akwd.a(this.jdField_a_of_type_Int);
      if (localakyg == null) {
        break label82;
      }
      CmGameStartChecker.StartCheckParam localStartCheckParam = localakyg.a();
      if ((localStartCheckParam == null) || (localStartCheckParam.mGameType != 5)) {
        break label82;
      }
      if (paramLong == 0L) {
        break label76;
      }
      switch ((int)paramLong)
      {
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        akyg localakyg;
        label76:
        label82:
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, localThrowable, new Object[0]);
        continue;
        int i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
      }
    }
    localakyg.e(i);
    return true;
    localakyg.e(1);
    return false;
  }
  
  private String b(int paramInt)
  {
    return aliu.s + paramInt + "/" + "shareQRCode_no_icon_default_v2.png";
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangString;
      File localFile = new File(a());
      if (localFile.isFile())
      {
        localObject = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        localFile = new File(a(this.jdField_a_of_type_Int));
        localObject = localFile;
        if (!localFile.exists()) {
          localObject = new File(b(this.jdField_a_of_type_Int));
        }
      }
      localArrayList.add(((File)localObject).getAbsolutePath());
      localBundle.putStringArrayList("images", localArrayList);
      localBundle.putString("summary", this.c);
      localBundle.putInt("req_type", 7);
      localBundle.putBoolean("key_need_save_draft", false);
      localObject = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
      if (localObject != null)
      {
        bjev.a(a(), (Context)localObject, localBundle, this, 255);
        return;
      }
      a(1, 4);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("apollo_cmGame_CmGameCommonShare", 1, "publishToQzone:", localException);
      a(1, 4);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhuf != null) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {}
    for (Object localObject = b(paramInt);; localObject = a(paramInt))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "checkDefaultQRSharePic gameId:", paramInt + " bitmap:" + paramBitmap });
    }
    ThreadManager.post(new CmGameCommonShare.2(this, paramInt, paramBitmap, (File)localObject), 5, null, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    bhup localbhup = null;
    this.d = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramInt = a(paramString);
    if (paramInt < 0)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->parse err or param err, ret:" + paramInt);
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (paramString = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramString = null)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Bhuf == null) && (paramString != null))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(bhup.a(0));
        localArrayList.add(bhup.a(1));
        localArrayList.add(bhup.a(2));
        localArrayList.add(bhup.a(3));
        if (paramString != null)
        {
          localbhup = new bhup(paramString);
          localbhup.a(localArrayList);
        }
        this.jdField_a_of_type_Bhuf = bhup.a(paramString, localbhup, this, this, this, false);
      }
      if ((this.jdField_a_of_type_Bhuf == null) || (this.jdField_a_of_type_Bhuf.isShowing())) {
        break;
      }
      this.jdField_a_of_type_Bhuf.setOnDismissListener(this);
      this.jdField_a_of_type_Bhuf.a(new akyd(this));
      this.jdField_a_of_type_Bhuf.show();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (new File(aliu.s + paramInt + "/" + "shareQRCode_default_v2.png").exists()) {}
    while (new File(aliu.s + paramInt + "/" + "shareQRCode_no_icon_default_v2.png").exists()) {
      return true;
    }
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(-1, -1);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
        a();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "click type:", Long.valueOf(paramLong) });
        }
        this.jdField_b_of_type_Boolean = true;
      } while (a(paramLong));
      if (paramLong == 1L)
      {
        b();
        return;
      }
      if (paramLong == 0L)
      {
        ThreadManager.post(new CmGameCommonShare.3(this), 5, null, true);
        return;
      }
      if (paramLong == 2L)
      {
        a(0);
        return;
      }
    } while (paramLong != 3L);
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */