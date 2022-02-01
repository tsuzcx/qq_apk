import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class aihj
  extends anmu
{
  aihj(aihe paramaihe) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    aihe.a(this.a).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", bgnt.a(BaseApplication.getContext()) + "");
      bctj.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label328;
        }
        i = 1;
        break;
        if (awwm.a().jdField_a_of_type_Int != 2) {
          this.a.c.dismiss();
        }
        awwm.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          awwm.a().b.putAll((Map)paramObject);
        }
        if (awwm.a().b.size() == 0) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697671, 0).b(this.a.a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            ((agmj)aihe.a(this.a).a(1)).a((Map)paramObject, awwm.a().jdField_a_of_type_JavaUtilArrayList, awwm.a().jdField_a_of_type_Int);
          }
        }
      }
      label328:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihj
 * JD-Core Version:    0.7.0.1
 */