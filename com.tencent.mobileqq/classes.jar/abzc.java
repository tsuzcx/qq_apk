import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class abzc
  implements Runnable
{
  public abzc(EmoticonFromGroupDBManager paramEmoticonFromGroupDBManager, int paramInt, EmoticonFromGroupEntity paramEmoticonFromGroupEntity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation start single. opType: " + this.jdField_a_of_type_Int);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end single.");
      }
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()))
      {
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
        continue;
        if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.getStatus() != 1000)) {
          QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "remove error, e.md5=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzc
 * JD-Core Version:    0.7.0.1
 */