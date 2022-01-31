import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import java.util.ArrayList;

public class abny
  extends BaseAdapter
{
  public abny(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public String a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130970257, null);
      paramViewGroup = new abnz();
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131369869));
      paramView.setTag(paramViewGroup);
      localObject = a(paramInt);
      if ((this.a.jdField_a_of_type_Int != 0) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.getResources().getDrawable(this.a.jdField_a_of_type_Int);
      }
      if (localObject == null) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            continue;
          }
          localObject = URLDrawable.getDrawable((String)localObject, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramViewGroup.a.setImageDrawable((Drawable)localObject);
        }
        catch (Exception paramViewGroup)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          paramViewGroup.printStackTrace();
          continue;
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return paramView;
        }
        if ((this.a.c != 1) || (this.a.jdField_a_of_type_Boolean)) {
          continue;
        }
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        paramViewGroup = (abnz)paramView.getTag();
        break;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      }
    }
    try
    {
      if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        localObject = URLDrawable.getDrawable("http://aaa", this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramViewGroup.a.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        paramViewGroup.a.setImageDrawable(null);
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abny
 * JD-Core Version:    0.7.0.1
 */