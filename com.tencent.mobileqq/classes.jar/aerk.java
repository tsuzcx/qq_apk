import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.NearbyProcess;
import com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface.Stub;
import com.tencent.qphone.base.util.QLog;

public class aerk
  extends NearbyProcessInterface.Stub
{
  public aerk(NearbyProcess paramNearbyProcess) {}
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return this.a.b(paramMessage);
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    if (paramBasicTypeDataParcel == null) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
      }
      arrayOfObject = this.a.b(paramBasicTypeDataParcel.jdField_a_of_type_Int, paramBasicTypeDataParcel.jdField_a_of_type_ArrayOfJavaLangObject);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.jdField_a_of_type_Int, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aerk
 * JD-Core Version:    0.7.0.1
 */