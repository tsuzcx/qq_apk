import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;

public final class abdg
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public abdg(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler paramIAnalyzeTextIntentByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    abdt localabdt = new abdt(null);
    localabdt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localabdt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localabdt.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler;
    ThreadManager.post(new abdh(this, localabdt, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdg
 * JD-Core Version:    0.7.0.1
 */