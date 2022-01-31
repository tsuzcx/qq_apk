import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.EmotionPanelDataCallback;
import java.util.List;
import mqq.os.MqqHandler;

public class acft
  implements Runnable
{
  public acft(EmotionPanelDataBuilder paramEmotionPanelDataBuilder, QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, EmotionPanelDataBuilder.EmotionPanelDataCallback paramEmotionPanelDataCallback) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelDataBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.b, this.c, this.jdField_a_of_type_Boolean);
    ThreadManager.getUIHandler().post(new acfu(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acft
 * JD-Core Version:    0.7.0.1
 */