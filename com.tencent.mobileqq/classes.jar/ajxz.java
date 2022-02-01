import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ajxz
  extends aogx
{
  public ajxz(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "vip status change in EmoticonGroupStoreFragment.");
    }
    ashd localashd = (ashd)EmoticonGroupStoreFragment.a(this.a).getManager(103);
    if (localashd != null) {
      localashd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxz
 * JD-Core Version:    0.7.0.1
 */