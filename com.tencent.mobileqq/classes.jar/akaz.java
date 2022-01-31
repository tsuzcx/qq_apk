import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class akaz
  extends ajtb
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private alji jdField_a_of_type_Alji;
  
  public akaz(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Alji == null)
      {
        this.jdField_a_of_type_Alji = alji.a();
        this.jdField_a_of_type_Alji.a(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("MiniCodePeakHandler", 2, "onDestroy");
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Alji != null)
      {
        this.jdField_a_of_type_Alji.a(hashCode(), "MiniCodePeakHandler");
        this.jdField_a_of_type_Alji = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akaz
 * JD-Core Version:    0.7.0.1
 */