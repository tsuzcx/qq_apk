import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class aagx
  extends URLDrawableDownListener.Adapter
{
  aagx(aagw paramaagw, int paramInt, ViewGroup paramViewGroup) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Aagw.a(this.jdField_a_of_type_Int, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_a_of_type_Aagw.b(this.jdField_a_of_type_Int, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_Aagw.a(this.jdField_a_of_type_Int, true);
    paramView = this.jdField_a_of_type_Aagw.a(paramURLDrawable.getURL(), this.jdField_a_of_type_AndroidViewViewGroup);
    if (paramView != null) {
      this.jdField_a_of_type_Aagw.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aagx
 * JD-Core Version:    0.7.0.1
 */