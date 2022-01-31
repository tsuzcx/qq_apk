import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aakj
  implements aakm
{
  public aakj(WorldCupMgr paramWorldCupMgr, WeakReference paramWeakReference1, WeakReference paramWeakReference2, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    Object localObject = (aakq)paramArrayList.get(0);
    paramArrayList = (aakn)localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a != null) && (this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a.jdField_a_of_type_Long == ((aakq)localObject).jdField_a_of_type_Long))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("异步加载config返回, bsuc[").append(paramBoolean).append("], mSeq[").append(((aakq)localObject).jdField_a_of_type_Long).append("], refActivity[");
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("], refAnchorView[");
        if (this.b.get() == null) {
          break label300;
        }
      }
      label300:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = localStringBuilder.append(bool1).append("], mNeedPlay[").append(paramArrayList.jdField_a_of_type_Boolean).append("], mSeq[").append(((aakq)localObject).jdField_a_of_type_Long).append("], isEnableFromLocal[").append(WorldCup.b()).append("], config[");
        bool1 = bool2;
        if (paramArrayList.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo != null) {
          bool1 = true;
        }
        QLog.w("WorldCupMgr", 1, bool1 + "]");
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a(paramArrayList.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo);
          this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if ((paramArrayList.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.b.get() != null)) {
            this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (View)this.b.get());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a = null;
        return;
        bool1 = false;
        break;
      }
    }
    QLog.w("WorldCupMgr", 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakj
 * JD-Core Version:    0.7.0.1
 */