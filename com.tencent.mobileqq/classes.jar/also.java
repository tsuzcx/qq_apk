import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class also
  extends alko
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private amzy jdField_a_of_type_Amzy;
  
  public also(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Amzy == null)
      {
        this.jdField_a_of_type_Amzy = amzy.a();
        this.jdField_a_of_type_Amzy.a(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  protected Class<? extends alkr> observerClass()
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
      if (this.jdField_a_of_type_Amzy != null)
      {
        this.jdField_a_of_type_Amzy.a(hashCode(), "MiniCodePeakHandler");
        this.jdField_a_of_type_Amzy = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     also
 * JD-Core Version:    0.7.0.1
 */