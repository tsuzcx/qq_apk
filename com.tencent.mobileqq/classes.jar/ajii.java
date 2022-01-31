import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class ajii
  implements aivc
{
  ajii(ajig paramajig, DisplayMetrics paramDisplayMetrics, ajik paramajik) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajig.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Ajig.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Ajig.b != null) && (this.jdField_a_of_type_Ajig.a != null) && (ajig.a(this.jdField_a_of_type_Ajig) != null))
    {
      this.jdField_a_of_type_Ajig.b.onExecDispose();
      this.jdField_a_of_type_Ajig.a.onExecDispose();
      Message localMessage = ajig.a(this.jdField_a_of_type_Ajig).obtainMessage(19, this.jdField_a_of_type_Ajik.c, this.jdField_a_of_type_Ajik.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Ajik.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Ajik.jdField_b_of_type_Float);
      }
      ajig.a(this.jdField_a_of_type_Ajig).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajii
 * JD-Core Version:    0.7.0.1
 */