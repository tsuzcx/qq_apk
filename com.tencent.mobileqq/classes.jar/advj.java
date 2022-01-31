import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class advj
  implements Runnable
{
  public advj(EmoticonManager paramEmoticonManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { this.jdField_a_of_type_JavaLangString, this.b });
    if (localEmoticon != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "hit db, put into cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advj
 * JD-Core Version:    0.7.0.1
 */