import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ajoo
  extends aodb
{
  public ajoo(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "vip status change in EmoticonGroupStoreFragment.");
    }
    asfl localasfl = (asfl)EmoticonGroupStoreFragment.a(this.a).getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
    if (localasfl != null) {
      localasfl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoo
 * JD-Core Version:    0.7.0.1
 */