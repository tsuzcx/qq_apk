import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class alhw
  extends apas
{
  alhw(alhu paramalhu, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow success");
    }
    alhu.a(this.jdField_a_of_type_Alhu, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    ((bgiy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    alhu.b(this.jdField_a_of_type_Alhu, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    alhu.a(this.jdField_a_of_type_Alhu, 2131694983);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    alhu.a(this.jdField_a_of_type_Alhu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhw
 * JD-Core Version:    0.7.0.1
 */