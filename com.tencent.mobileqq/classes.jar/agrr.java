import android.view.View;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;

public class agrr
  implements bfpc
{
  public agrr(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    agsb localagsb = this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsb;
    int i = this.a.jdField_a_of_type_Agru.getItemViewType(paramInt);
    if (this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsh != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.a.jdField_a_of_type_Agsc.c)
      {
        this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsh.a(paramAdapterView, paramView, paramInt, paramLong);
        return;
      }
      paramAdapterView = this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsh.a(paramAdapterView, paramView, paramInt, paramLong);
      this.a.jdField_a_of_type_Agse.c(paramAdapterView);
      bbbj.a(this.a, true, true);
      return;
    case 1: 
      this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsh.b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.a.jdField_a_of_type_Agse.jdField_a_of_type_Agsh.c(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrr
 * JD-Core Version:    0.7.0.1
 */