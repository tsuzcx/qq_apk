import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class ajik
  implements aive
{
  ajik(ajii paramajii, DisplayMetrics paramDisplayMetrics, ajim paramajim) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajii.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Ajii.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Ajii.b != null) && (this.jdField_a_of_type_Ajii.a != null) && (ajii.a(this.jdField_a_of_type_Ajii) != null))
    {
      this.jdField_a_of_type_Ajii.b.onExecDispose();
      this.jdField_a_of_type_Ajii.a.onExecDispose();
      Message localMessage = ajii.a(this.jdField_a_of_type_Ajii).obtainMessage(19, this.jdField_a_of_type_Ajim.c, this.jdField_a_of_type_Ajim.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Ajim.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Ajim.jdField_b_of_type_Float);
      }
      ajii.a(this.jdField_a_of_type_Ajii).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajik
 * JD-Core Version:    0.7.0.1
 */