import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.qphone.base.util.QLog;

public class abwk
  implements QueryCallback
{
  public abwk(SogouEmoji paramSogouEmoji, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.f = paramEmoticonPackage.type;
      PicEmoticonInfo localPicEmoticonInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localPicEmoticonInfo.b = bool;
      }
    }
    for (;;)
    {
      SogouEmoji.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.f);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.f = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwk
 * JD-Core Version:    0.7.0.1
 */