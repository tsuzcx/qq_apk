import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class aiui
  implements aiil
{
  aiui(aiug paramaiug, DisplayMetrics paramDisplayMetrics, aiuk paramaiuk) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aiug.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Aiug.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Aiug.b != null) && (this.jdField_a_of_type_Aiug.a != null) && (aiug.a(this.jdField_a_of_type_Aiug) != null))
    {
      this.jdField_a_of_type_Aiug.b.onExecDispose();
      this.jdField_a_of_type_Aiug.a.onExecDispose();
      Message localMessage = aiug.a(this.jdField_a_of_type_Aiug).obtainMessage(19, this.jdField_a_of_type_Aiuk.c, this.jdField_a_of_type_Aiuk.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Aiuk.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Aiuk.jdField_b_of_type_Float);
      }
      aiug.a(this.jdField_a_of_type_Aiug).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiui
 * JD-Core Version:    0.7.0.1
 */