import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class acwu
  extends aqkl
{
  acwu(acwp paramacwp) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString))) {
      QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
    }
    while (!paramBoolean) {
      return;
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    if ((this.a.jdField_a_of_type_Asrq != null) && (this.a.jdField_a_of_type_Asrq.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Asrq != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mViewDelegate == null:" + acwp.b(this.a));
      }
    } while (acwp.b(this.a));
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mode: " + this.a.jdField_a_of_type_Asrq.a());
      }
    }
    if (paramBoolean)
    {
      paramString = acwp.a(this.a).obtainMessage();
      paramString.what = 0;
      paramString.obj = paramIntimateInfo;
      acwp.a(this.a).removeMessages(0);
      acwp.a(this.a).sendMessage(paramString);
      return;
    }
    paramString = acwp.a(this.a).obtainMessage();
    paramString.what = 1;
    paramString.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693621);
    acwp.a(this.a).sendMessage(paramString);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    if (paramBoolean1)
    {
      Message localMessage = acwp.a(this.a).obtainMessage();
      if (paramBoolean2)
      {
        this.a.d();
        return;
      }
      localMessage.what = 6;
      localMessage.obj = paramString;
      acwp.a(this.a).sendMessage(localMessage);
      return;
    }
    paramString = acwp.a(this.a).obtainMessage();
    paramString.what = 5;
    acwp.a(this.a).sendMessage(paramString);
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_Asrq != null) && (this.a.jdField_a_of_type_Asrq.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Asrq != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null : " + acwp.b(this.a));
      }
    } while (acwp.b(this.a));
    paramObject = null;
    if ((paramBoolean) && (paramHashMap != null))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue();
        l1 = l2;
      }
      catch (NumberFormatException paramObject)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err ");
        }
      }
    }
    for (paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));; paramHashMap = paramObject)
    {
      if (paramHashMap == null) {
        break label272;
      }
      paramObject = acwp.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      acwp.a(this.a).removeMessages(0);
      acwp.a(this.a).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.a.jdField_a_of_type_Asrq.a());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = acwp.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693621);
    acwp.a(this.a).sendMessage(paramHashMap);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onHandleGetLoverIntimateInfo isSuccess = " + paramBoolean + " data = " + paramArrayOfObject);
    }
    if (paramBoolean)
    {
      Message localMessage = acwp.a(this.a).obtainMessage();
      localMessage.what = 7;
      localMessage.obj = paramArrayOfObject;
      acwp.a(this.a).removeMessages(7);
      acwp.a(this.a).sendMessage(localMessage);
      return;
    }
    paramArrayOfObject = acwp.a(this.a).obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    acwp.a(this.a).sendMessage(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwu
 * JD-Core Version:    0.7.0.1
 */