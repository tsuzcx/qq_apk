import android.os.Bundle;
import android.os.ResultReceiver;

class aksw
  implements anjl
{
  aksw(akss paramakss, Bundle paramBundle, int paramInt, ResultReceiver paramResultReceiver, anjh paramanjh) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("updateResult", this.jdField_a_of_type_Int);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("isUpdateSuccess", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_Anjh.d(this);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("isUpdateSuccess", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksw
 * JD-Core Version:    0.7.0.1
 */