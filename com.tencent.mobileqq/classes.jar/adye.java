import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.image.URLImageView;

class adye
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  URLImageView b;
  
  public adye(adyd paramadyd, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368053));
    this.b = ((URLImageView)paramView.findViewById(2131368068));
    this.b.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369767);
  }
  
  private Drawable a()
  {
    Resources localResources = this.itemView.getResources();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aepi.a(5.0F, localResources));
    localGradientDrawable.setStroke(aepi.a(1.5F, localResources), localResources.getColor(2131167005));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adye
 * JD-Core Version:    0.7.0.1
 */