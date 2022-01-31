import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

class aggz
  implements View.OnClickListener
{
  aggz(aggx paramaggx, Resources paramResources) {}
  
  public void onClick(View paramView)
  {
    if (!((NewPhotoPreviewActivity)this.jdField_a_of_type_Aggx.jdField_a_of_type_MqqUtilWeakReference.get()).b.isChecked())
    {
      if (baaf.a(this.jdField_a_of_type_Aggx.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggx.jdField_a_of_type_Aggf.jdField_b_of_type_Int, this.jdField_a_of_type_Aggx.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Aggx.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap) > 0)
      {
        bbmy.a((Context)this.jdField_a_of_type_Aggx.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_AndroidContentResResources.getString(2131629431), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_Aggx.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        return;
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_Aggx.jdField_a_of_type_MqqUtilWeakReference.get()).b.setChecked(true);
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_Aggx.jdField_a_of_type_MqqUtilWeakReference.get()).b.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggz
 * JD-Core Version:    0.7.0.1
 */