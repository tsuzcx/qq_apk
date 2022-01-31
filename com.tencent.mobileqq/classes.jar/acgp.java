import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class acgp
  implements Runnable
{
  public acgp(RecommendEmotionAdapter paramRecommendEmotionAdapter, acgs paramacgs) {}
  
  public void run()
  {
    boolean bool = ApngHandler.b.get();
    if (!bool) {
      if (!ApngHandler.c())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label449;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect isSoPrepared = false, id:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_Int);
        }
        ??? = (ApngHandler)((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a("qq.android.native.apng_v700");
        if (??? != null) {
          ((ApngHandler)???).a(true);
        }
      }
    }
    label449:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_JavaLangObject)
      {
        File localFile = VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1003L, "emotionRecommendEffect", null, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        if (localFile == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect effectFile = null, id:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_Int);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b == null) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b = new ArrayList();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.size() > 0)
          {
            i = ((acgs)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.get(0)).jdField_a_of_type_Int;
            if (this.jdField_a_of_type_Acgs.jdField_a_of_type_Int >= i) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.add(0, this.jdField_a_of_type_Acgs);
            bool = false;
          }
        }
        else
        {
          if (bool)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect postShow, id:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg.a + ", index:" + this.jdField_a_of_type_Acgs.jdField_a_of_type_Int);
            }
            this.jdField_a_of_type_Acgs.jdField_a_of_type_JavaIoFile = localFile;
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102, this.jdField_a_of_type_Acgs));
          }
          return;
          ApngHandler.d_();
          bool = ApngHandler.b.get();
          continue;
        }
        int i = -1;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRecommendEmotionAdapter.b.add(this.jdField_a_of_type_Acgs);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgp
 * JD-Core Version:    0.7.0.1
 */