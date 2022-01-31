import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import java.io.File;
import mqq.app.MobileQQ;

public class aeqv
  implements Runnable
{
  public aeqv(EmoticonManager paramEmoticonManager, int paramInt, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend) {}
  
  public void run()
  {
    FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.getApplication().getFilesDir(), "recommemd_emotion_file__" + this.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.c()).getAbsolutePath(), this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.toByteArray(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqv
 * JD-Core Version:    0.7.0.1
 */