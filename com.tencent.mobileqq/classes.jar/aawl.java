import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;

public final class aawl
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public aawl(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler paramIAnalyzeTextIntentByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    aawy localaawy = new aawy(null);
    localaawy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaawy.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localaawy.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler;
    ThreadManager.post(new aawm(this, localaawy, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawl
 * JD-Core Version:    0.7.0.1
 */