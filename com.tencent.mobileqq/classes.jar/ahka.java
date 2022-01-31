import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import java.lang.ref.WeakReference;

abstract class ahka
  extends ProtoUtils.TroopProtocolObserver
{
  protected Object a;
  private WeakReference a;
  
  ahka(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramObject);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_JavaLangObject == null) {
      return;
    }
    b(paramInt, paramArrayOfByte, paramBundle);
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  abstract void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahka
 * JD-Core Version:    0.7.0.1
 */