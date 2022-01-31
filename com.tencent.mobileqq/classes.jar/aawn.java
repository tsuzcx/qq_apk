import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;

class aawn
  implements BusinessObserver
{
  aawn(aawm paramaawm) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    String str = (String)paramObject;
    paramObject = localObject;
    if (paramBoolean)
    {
      paramObject = localObject;
      if (!TextUtils.isEmpty(str)) {
        paramObject = ArkMessageServerLogic.a(this.a.a.jdField_a_of_type_JavaLangString, str);
      }
    }
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler.a(this.a.a.jdField_a_of_type_JavaLangString, this.a.a.jdField_a_of_type_JavaLangObject, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawn
 * JD-Core Version:    0.7.0.1
 */