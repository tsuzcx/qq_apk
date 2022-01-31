import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.1;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Timer;
import tencent.im.nearfield_friend.nearfield_friend.GPS;

public class ahjr
{
  private int jdField_a_of_type_Int = 60000;
  private ahjp jdField_a_of_type_Ahjp;
  private ahjq jdField_a_of_type_Ahjq = new ahju(this);
  private ahjy jdField_a_of_type_Ahjy;
  private altm jdField_a_of_type_Altm = new ahjv(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private nearfield_friend.GPS jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  private int b = 1200000;
  
  public ahjr(Face2FaceAddContactFragment paramFace2FaceAddContactFragment)
  {
    this.jdField_a_of_type_Ahjy = paramFace2FaceAddContactFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFace2FaceAddContactFragment.getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahjq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Ahjp = ((ahjp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(169));
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + System.currentTimeMillis() + "_" + (int)Math.floor(Math.random() * 100000.0D) % 100000;
    }
    return "";
  }
  
  private nearfield_friend.GPS a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      nearfield_friend.GPS localGPS = new nearfield_friend.GPS();
      localGPS.lat.set((int)(paramSosoLbsInfo.a.a * 1000000.0D));
      localGPS.lng.set((int)(paramSosoLbsInfo.a.b * 1000000.0D));
      localGPS.type.set(1);
      localStringBuffer.append("generateGPSInfo GPS: ").append(paramSosoLbsInfo.a.a * 1000000.0D).append(",").append(paramSosoLbsInfo.a.b * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS = localGPS;
      if (QLog.isColorLevel()) {
        QLog.i("Face2FaceAddContactPresenter", 2, localStringBuffer.toString());
      }
    }
    return this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  }
  
  private void a(FragmentActivity paramFragmentActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        paramFragmentActivity.requestPermissions(new ahjs(this, paramBoolean, paramString1, paramString2), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    while (!paramBoolean)
    {
      do
      {
        return;
      } while (!paramBoolean);
      a(paramString1, paramString2);
      return;
    }
    a(paramString1, paramString2);
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = a();
    nearfield_friend.GPS localGPS = a(paramSosoLbsInfo);
    paramSosoLbsInfo = null;
    if (!TextUtils.isEmpty(paramString2)) {
      paramSosoLbsInfo = paramString2.getBytes();
    }
    this.jdField_a_of_type_Ahjp.a(this.jdField_a_of_type_JavaLangString, paramString1, localGPS, paramSosoLbsInfo);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new Face2FaceAddContactPresenter.3(this, paramString1, paramString2), 8, null, false);
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new Face2FaceAddContactPresenter.1(this), 300000L);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      b();
    }
    d();
    this.jdField_a_of_type_Ahjy = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahjq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    }
  }
  
  public void a(FragmentActivity paramFragmentActivity)
  {
    a(paramFragmentActivity, false, "", "");
  }
  
  public void a(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    a(paramFragmentActivity, true, paramString1, paramString2);
  }
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendFace2FaceAddContactHeartBeatReq mSessionId:" + this.jdField_a_of_type_JavaLangString + " faceFriends:" + paramList);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Ahjp.a(this.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendExitFace2FaceAddContactReq mSessionId:" + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Ahjp.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjr
 * JD-Core Version:    0.7.0.1
 */