import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleCounter.GroupInfo;
import qqcircle.QQCircleCounter.GroupInfoRsp;

class afom
  implements VSDispatchObserver.onVSRspCallBack<QQCircleCounter.GroupInfoRsp>
{
  afom(afok paramafok, List paramList1, String paramString, TroopChatPie paramTroopChatPie, List paramList2) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleCounter.GroupInfoRsp paramGroupInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramGroupInfoRsp != null)
      {
        if (paramGroupInfoRsp.groupinfo.size() == this.jdField_a_of_type_JavaUtilList.size())
        {
          int i = 0;
          if (i < paramGroupInfoRsp.groupinfo.size())
          {
            if (((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).isOpen.get()) {
              afok.a(this.jdField_a_of_type_Afok).put(((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).groupid.get(), Integer.valueOf(1));
            }
            for (;;)
            {
              i += 1;
              break;
              afok.a(this.jdField_a_of_type_Afok).remove(((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).groupid.get());
            }
          }
        }
        else
        {
          QZLog.d("AIOTroopQcircleRedDotManager", 2, "size of troop greyinfo rsp not equals to size of req");
        }
        this.jdField_a_of_type_Afok.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.b);
        afok.a(this.jdField_a_of_type_Afok, afok.a(this.jdField_a_of_type_Afok).keySet());
        afok.c(this.jdField_a_of_type_Afok, System.currentTimeMillis());
        afok.d(this.jdField_a_of_type_Afok, paramGroupInfoRsp.nextTime.get() * 1000);
        LocalMultiProcConfig.putLong("qcircle_troop_redpoint_grey_last_timestamp", afok.c(this.jdField_a_of_type_Afok));
        LocalMultiProcConfig.putLong("qcircle_troop_redpoint_grey_time_threshold", afok.d(this.jdField_a_of_type_Afok));
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "new greyTimeLimits from backend: " + afok.d(this.jdField_a_of_type_Afok));
      }
      return;
    }
    this.jdField_a_of_type_Afok.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afom
 * JD-Core Version:    0.7.0.1
 */