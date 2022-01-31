import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aczi
  extends apqw
{
  aczi(acze paramacze) {}
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_Arvm != null) && (this.a.jdField_a_of_type_Arvm.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Arvm != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null :" + acze.a(this.a));
      }
    } while (acze.a(this.a));
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
      paramObject = acze.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      acze.a(this.a).removeMessages(0);
      acze.a(this.a).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.a.jdField_a_of_type_Arvm.a());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = acze.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131627980);
    acze.a(this.a).sendMessage(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczi
 * JD-Core Version:    0.7.0.1
 */