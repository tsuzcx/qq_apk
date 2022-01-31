import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.EmoticonTabItem;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class acnl
  implements Runnable
{
  public acnl(EmoticonTabAdapter paramEmoticonTabAdapter, EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter.a.getManager(13);
    EmoticonPackage localEmoticonPackage = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter$EmoticonTabItem.a);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localEmoticonManager.a(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnl
 * JD-Core Version:    0.7.0.1
 */