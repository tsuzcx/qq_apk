import android.view.View;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;

public class agrp
  implements bfpt
{
  public agrp(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    agrz localagrz = this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz;
    int i = this.a.jdField_a_of_type_Agrs.getItemViewType(paramInt);
    if (this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agsf != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.a.jdField_a_of_type_Agsa.c)
      {
        this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agsf.a(paramAdapterView, paramView, paramInt, paramLong);
        return;
      }
      paramAdapterView = this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agsf.a(paramAdapterView, paramView, paramInt, paramLong);
      this.a.jdField_a_of_type_Agsc.c(paramAdapterView);
      bbbx.a(this.a, true, true);
      return;
    case 1: 
      this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agsf.b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.a.jdField_a_of_type_Agsc.jdField_a_of_type_Agsf.c(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrp
 * JD-Core Version:    0.7.0.1
 */