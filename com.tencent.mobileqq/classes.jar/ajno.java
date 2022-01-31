import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ajno
  implements AdapterView.OnItemClickListener
{
  ajno(ajnn paramajnn, String paramString) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Ajnn.a.obtainMessage();
    paramAdapterView.what = ((int)paramLong);
    paramAdapterView.obj = this.jdField_a_of_type_JavaLangString;
    paramAdapterView.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajno
 * JD-Core Version:    0.7.0.1
 */