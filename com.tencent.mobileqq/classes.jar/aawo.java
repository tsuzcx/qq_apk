import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler;

public final class aawo
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public aawo(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler paramIAnalyzeArkBabyQReplyByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    aawy localaawy = new aawy(null);
    localaawy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaawy.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localaawy.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler;
    ThreadManager.post(new aawp(this, localaawy, paramString, paramDouble1, paramDouble2), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawo
 * JD-Core Version:    0.7.0.1
 */