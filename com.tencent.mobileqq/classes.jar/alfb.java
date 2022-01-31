import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class alfb
  implements AdapterView.OnItemClickListener
{
  alfb(alfa paramalfa, String paramString) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Alfa.a.obtainMessage();
    paramAdapterView.what = ((int)paramLong);
    paramAdapterView.obj = this.jdField_a_of_type_JavaLangString;
    paramAdapterView.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfb
 * JD-Core Version:    0.7.0.1
 */