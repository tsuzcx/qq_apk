import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.NetworkUtil;

public class aios
  implements Runnable
{
  public aios(BuddyTransfileProcessor paramBuddyTransfileProcessor, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    FileMsg localFileMsg;
    if ((StreamDataManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c) != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.e))
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      BuddyTransfileProcessor localBuddyTransfileProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor;
      long l = System.nanoTime();
      localBuddyTransfileProcessor.k = l;
      localFileMsg.g = l;
      this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.e = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_Short, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.q, this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.r, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      localFileMsg.e += StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aios
 * JD-Core Version:    0.7.0.1
 */