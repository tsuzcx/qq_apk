import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;

public final class aapk
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public aapk(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler paramIAnalyzeTextIntentByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    aapx localaapx = new aapx(null);
    localaapx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaapx.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localaapx.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler;
    ThreadManager.post(new aapl(this, localaapx, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapk
 * JD-Core Version:    0.7.0.1
 */