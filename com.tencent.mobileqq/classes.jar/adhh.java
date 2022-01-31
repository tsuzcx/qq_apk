import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlCallBack;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import java.util.List;

public class adhh
  implements RichProtoProc.RichProtoCallback
{
  public adhh(HotVideoData paramHotVideoData, HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack) {}
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null) {
      if (paramRichProtoResp.a.size() > 0)
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.a.get(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.a(paramRichProtoReq);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlCallBack.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult);
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.jdField_a_of_type_JavaLangString = "Unknown error！";
      continue;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.jdField_a_of_type_JavaLangString = "Unknown error！";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */