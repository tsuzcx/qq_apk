import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class ahlk
  extends amsu
{
  ahlk(ahlf paramahlf) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    ahlf.a(this.a).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.mProgressDialog == null) || (!this.a.mProgressDialog.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label328;
        }
        i = 1;
        break;
        if (awcm.a().jdField_a_of_type_Int != 2) {
          this.a.mProgressDialog.dismiss();
        }
        awcm.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          awcm.a().b.putAll((Map)paramObject);
        }
        if (awcm.a().b.size() == 0) {
          QQToast.a(this.a.app.getApp(), 2131697901, 0).b(this.a.getTitleBarHeight());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d(this.a.tag, 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            ((afrl)ahlf.a(this.a).a(1)).a((Map)paramObject, awcm.a().jdField_a_of_type_JavaUtilArrayList, awcm.a().jdField_a_of_type_Int);
          }
        }
      }
      label328:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */