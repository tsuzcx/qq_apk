import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class alej
  implements akrd
{
  alej(aleh paramaleh, DisplayMetrics paramDisplayMetrics, alel paramalel) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aleh.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Aleh.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Aleh.b != null) && (this.jdField_a_of_type_Aleh.a != null) && (aleh.a(this.jdField_a_of_type_Aleh) != null))
    {
      this.jdField_a_of_type_Aleh.b.onExecDispose();
      this.jdField_a_of_type_Aleh.a.onExecDispose();
      Message localMessage = aleh.a(this.jdField_a_of_type_Aleh).obtainMessage(19, this.jdField_a_of_type_Alel.c, this.jdField_a_of_type_Alel.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Alel.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Alel.jdField_b_of_type_Float);
      }
      aleh.a(this.jdField_a_of_type_Aleh).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alej
 * JD-Core Version:    0.7.0.1
 */