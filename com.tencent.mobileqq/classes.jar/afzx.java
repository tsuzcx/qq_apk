import EncounterSvc.RespEncounterInfo;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import com.tencent.mobileqq.util.FaceDecoder;

public class afzx
  implements Runnable
{
  public afzx(ChatPushCarrierHelper paramChatPushCarrierHelper, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    FaceDecoder localFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp > 0) {}
    for (long l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp;; l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.common_face_timestamp)
    {
      localFaceDecoder.a(32, str, 200, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afzx
 * JD-Core Version:    0.7.0.1
 */