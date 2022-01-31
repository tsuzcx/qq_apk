import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitReq;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitRsp;

class akjz
  implements BusinessObserver
{
  akjz(akjy paramakjy, JSONObject paramJSONObject, List paramList, TracePathData paramTracePathData, SharedPreferences paramSharedPreferences, QQSportsOrbit.OrbitReq paramOrbitReq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    akjy.a(this.jdField_a_of_type_Akjy, paramBoolean, paramInt);
    int i;
    if (paramBoolean)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new QQSportsOrbit.OrbitRsp();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramInt = paramBundle.lastNum.get();
          if ((paramInt == -1) || (paramBundle.retCode.get() != 0))
          {
            this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", -10);
            if (this.jdField_a_of_type_Akjy.a.a == null) {
              break label802;
            }
            paramBundle = Message.obtain();
            paramBundle.what = 1;
            paramBundle.obj = this.jdField_a_of_type_OrgJsonJSONObject;
            this.jdField_a_of_type_Akjy.a.a.sendMessage(paramBundle);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("PathTraceManager", 1, "[run] json fail" + localException.getMessage());
            paramInt = -1;
          }
        }
        if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 1);
          if (this.jdField_a_of_type_Akjy.a.a != null)
          {
            paramBundle = Message.obtain();
            paramBundle.what = 1;
            paramBundle.obj = this.jdField_a_of_type_OrgJsonJSONObject;
            this.jdField_a_of_type_Akjy.a.a.sendMessage(paramBundle);
          }
          this.jdField_a_of_type_Akjy.a.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime));
          QLog.d("PathTraceManager", 1, "upload success");
          PathTraceManager.a(this.jdField_a_of_type_Akjy.a, null);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().clear().commit();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("PathTraceManager", 1, "[run] json fail" + paramBundle.getMessage());
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          i = paramInt;
        }
      }
    }
    for (;;)
    {
      if (i < paramInt + 3000)
      {
        paramBundle = new QQSportsOrbit.OrbitPoint();
        paramBundle.latitude.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).latitude);
        paramBundle.longitude.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).longitude);
        paramBundle.timef.set((int)((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).time);
        paramBundle.speedf.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).speed);
        paramBundle.accuracy.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).accuracy);
        paramBundle.step.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).steps);
        paramBundle.altitude.set((float)((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).altitude);
        this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.tracePath.add(paramBundle);
        if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {}
      }
      else
      {
        if (paramInt + 3000 >= this.jdField_a_of_type_JavaUtilList.size()) {
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.isOver.set(1);
        }
        for (;;)
        {
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.num.set(paramInt + 1);
          paramBundle = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), WebSSOAgentServlet.class);
          paramBundle.putExtra("extra_cmd", akjy.a(this.jdField_a_of_type_Akjy));
          paramBundle.putExtra("extra_data", PathTraceManager.a(this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.toByteArray()));
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.tracePath.clear();
          paramBundle.putExtra("extra_timeout", 15000);
          paramBundle.setObserver(this);
          BaseApplicationImpl.sApplication.getRuntime().startServlet(paramBundle);
          return;
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.isOver.set(0);
        }
        QLog.e("PathTraceManager", 1, "upload fail");
        try
        {
          paramBundle = new JSONObject();
          paramBundle.put("retCode", -10);
          if (this.jdField_a_of_type_Akjy.a.a != null)
          {
            Message localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.obj = paramBundle;
            this.jdField_a_of_type_Akjy.a.a.sendMessage(localMessage);
            return;
          }
        }
        catch (Exception paramBundle)
        {
          QLog.d("PathTraceManager", 1, "uploadfail:" + paramBundle.toString());
        }
        label802:
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjz
 * JD-Core Version:    0.7.0.1
 */