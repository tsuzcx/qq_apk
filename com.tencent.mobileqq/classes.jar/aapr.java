import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;

public final class aapr
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public aapr(String paramString, Object paramObject, ArkMessageServerLogic.IPassiveSearchIntentByServerHandler paramIPassiveSearchIntentByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    aapx localaapx = new aapx(null);
    localaapx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaapx.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localaapx.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler;
    ThreadManager.post(new aaps(this, localaapx, paramString, paramDouble1, paramDouble2), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapr
 * JD-Core Version:    0.7.0.1
 */