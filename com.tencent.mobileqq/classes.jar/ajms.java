import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ajms
  extends ajfb
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private akux jdField_a_of_type_Akux;
  
  public ajms(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Akux == null)
      {
        this.jdField_a_of_type_Akux = akux.a();
        this.jdField_a_of_type_Akux.a(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  protected Class<? extends ajfe> observerClass()
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
      if (this.jdField_a_of_type_Akux != null)
      {
        this.jdField_a_of_type_Akux.a(hashCode(), "MiniCodePeakHandler");
        this.jdField_a_of_type_Akux = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajms
 * JD-Core Version:    0.7.0.1
 */