import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class akzu
  implements akmo
{
  akzu(akzs paramakzs, DisplayMetrics paramDisplayMetrics, akzw paramakzw) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Akzs.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Akzs.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Akzs.b != null) && (this.jdField_a_of_type_Akzs.a != null) && (akzs.a(this.jdField_a_of_type_Akzs) != null))
    {
      this.jdField_a_of_type_Akzs.b.onExecDispose();
      this.jdField_a_of_type_Akzs.a.onExecDispose();
      Message localMessage = akzs.a(this.jdField_a_of_type_Akzs).obtainMessage(19, this.jdField_a_of_type_Akzw.c, this.jdField_a_of_type_Akzw.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Akzw.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Akzw.jdField_b_of_type_Float);
      }
      akzs.a(this.jdField_a_of_type_Akzs).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzu
 * JD-Core Version:    0.7.0.1
 */