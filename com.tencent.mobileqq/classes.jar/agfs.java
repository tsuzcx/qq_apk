import android.view.View;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;

public class agfs
  implements behi
{
  public agfs(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aggf localaggf = this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    int i = this.a.jdField_a_of_type_Agfv.getItemViewType(paramInt);
    if (this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggk != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.a.jdField_a_of_type_Aggg.e)
      {
        this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggk.a(paramAdapterView, paramView, paramInt, paramLong);
        return;
      }
      paramAdapterView = this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggk.a(paramAdapterView, paramView, paramInt, paramLong);
      this.a.jdField_a_of_type_Aggh.c(paramAdapterView);
      baaf.a(this.a, true, true);
      return;
    case 1: 
      this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggk.b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.a.jdField_a_of_type_Aggh.jdField_a_of_type_Aggk.c(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfs
 * JD-Core Version:    0.7.0.1
 */