import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.image.URLImageView;

class adtp
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  URLImageView b;
  
  public adtp(adto paramadto, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368042));
    this.b = ((URLImageView)paramView.findViewById(2131368057));
    this.b.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369748);
  }
  
  private Drawable a()
  {
    Resources localResources = this.itemView.getResources();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aekt.a(5.0F, localResources));
    localGradientDrawable.setStroke(aekt.a(1.5F, localResources), localResources.getColor(2131167003));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtp
 * JD-Core Version:    0.7.0.1
 */