import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;

public final class abdn
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public abdn(String paramString, Object paramObject, ArkMessageServerLogic.IPassiveSearchIntentByServerHandler paramIPassiveSearchIntentByServerHandler) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    abdt localabdt = new abdt(null);
    localabdt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localabdt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    localabdt.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler = this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler;
    ThreadManager.post(new abdo(this, localabdt, paramString, paramDouble1, paramDouble2), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdn
 * JD-Core Version:    0.7.0.1
 */