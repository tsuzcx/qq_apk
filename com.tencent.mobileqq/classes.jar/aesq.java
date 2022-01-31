import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class aesq
  extends asim
{
  aesq(aesk paramaesk) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<ahpo> paramArrayList)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Int = paramInt;
      this.a.jdField_a_of_type_JavaUtilList = ahqz.a(paramArrayList, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ahqz.a(this.a.jdField_a_of_type_JavaLangString, paramInt);
      ahqz.a(this.a.jdField_a_of_type_JavaLangString, paramArrayList);
      paramArrayList = aesk.a(this.a).obtainMessage();
      paramArrayList.what = 9;
      paramArrayList.obj = null;
      aesk.a(this.a).removeMessages(9);
      aesk.a(this.a).sendMessage(paramArrayList);
      return;
    }
    paramArrayList = aesk.a(this.a).obtainMessage();
    paramArrayList.what = 10;
    paramArrayList.obj = null;
    aesk.a(this.a).sendMessage(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) || (!paramBoolean))
    {
      QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    if ((this.a.jdField_a_of_type_Aumy != null) && (this.a.jdField_a_of_type_Aumy.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Aumy != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mViewDelegate == null:" + aesk.b(this.a));
      }
    } while (aesk.b(this.a));
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mode: " + this.a.jdField_a_of_type_Aumy.a());
      }
    }
    if (paramBoolean)
    {
      paramString = aesk.a(this.a).obtainMessage();
      paramString.what = 0;
      paramString.obj = paramIntimateInfo;
      aesk.a(this.a).removeMessages(0);
      aesk.a(this.a).sendMessage(paramString);
      return;
    }
    paramString = aesk.a(this.a).obtainMessage();
    paramString.what = 1;
    paramString.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693728);
    aesk.a(this.a).sendMessage(paramString);
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
    Message localMessage = aesk.a(this.a).obtainMessage();
    if (!paramBoolean1)
    {
      localMessage.what = 5;
      aesk.a(this.a).sendMessage(localMessage);
      return;
    }
    if (paramBoolean2)
    {
      this.a.d();
      return;
    }
    localMessage.what = 6;
    localMessage.obj = paramString;
    aesk.a(this.a).sendMessage(localMessage);
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_Aumy != null) && (this.a.jdField_a_of_type_Aumy.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Aumy != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null : " + aesk.b(this.a));
      }
    } while (aesk.b(this.a));
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
      paramObject = aesk.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      aesk.a(this.a).removeMessages(0);
      aesk.a(this.a).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.a.jdField_a_of_type_Aumy.a());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = aesk.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693728);
    aesk.a(this.a).sendMessage(paramHashMap);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onHandleGetLoverIntimateInfo isSuccess = " + paramBoolean + " data = " + paramArrayOfObject);
    }
    if (paramBoolean)
    {
      Message localMessage = aesk.a(this.a).obtainMessage();
      localMessage.what = 7;
      localMessage.obj = paramArrayOfObject;
      aesk.a(this.a).removeMessages(7);
      aesk.a(this.a).sendMessage(localMessage);
      return;
    }
    paramArrayOfObject = aesk.a(this.a).obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    aesk.a(this.a).sendMessage(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesq
 * JD-Core Version:    0.7.0.1
 */