import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.image.URLImageView;

class afnt
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  URLImageView b;
  
  public afnt(afnr paramafnr, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368451));
    this.b = ((URLImageView)paramView.findViewById(2131368466));
    this.b.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370299);
  }
  
  private Drawable a()
  {
    Resources localResources = this.itemView.getResources();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(agej.a(5.0F, localResources));
    localGradientDrawable.setStroke(agej.a(1.5F, localResources), localResources.getColor(2131167098));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnt
 * JD-Core Version:    0.7.0.1
 */