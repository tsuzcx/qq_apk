import com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class acor
  implements Runnable
{
  public acor(RecommendEmotionAdapter paramRecommendEmotionAdapter, acov paramacov) {}
  
  public void run()
  {
    boolean bool2 = VasApngUtil.b.get();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (VasApngUtil.b()) {
        break label391;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect isSoPrepared = false, id:" + this.jdField_a_of_type_Acov.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acov.jdField_a_of_type_Int);
        }
        VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "RecommendEmoticonAdapter");
        bool1 = bool2;
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_JavaLangObject)
    {
      File localFile = VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1003L, "emotionRecommendEffect", null, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      if (localFile == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect effectFile = null, id:" + this.jdField_a_of_type_Acov.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acov.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b == null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b = new ArrayList();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.size() <= 0) {
          break label405;
        }
      }
      label391:
      label405:
      for (int i = ((acov)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.get(0)).jdField_a_of_type_Int;; i = -1)
      {
        if (this.jdField_a_of_type_Acov.jdField_a_of_type_Int >= i) {
          break label410;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.add(0, this.jdField_a_of_type_Acov);
        bool1 = false;
        if (bool1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect postShow, id:" + this.jdField_a_of_type_Acov.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acov.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Acov.jdField_a_of_type_JavaIoFile = localFile;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102, this.jdField_a_of_type_Acov));
        }
        return;
        VasApngUtil.a();
        bool1 = VasApngUtil.b.get();
        break;
      }
      label410:
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.add(this.jdField_a_of_type_Acov);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acor
 * JD-Core Version:    0.7.0.1
 */