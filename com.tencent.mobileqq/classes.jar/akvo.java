import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.util.ArrayList;
import java.util.List;

public class akvo
  extends BaseAdapter
{
  public Context a;
  private List<ApolloGameData> a;
  private List<String> b = new ArrayList();
  
  public akvo(akvn paramakvn, Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramakvn != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramakvn.b;
      this.b = paramakvn.c;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      paramViewGroup = new akvp(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558823, null);
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131368784));
      paramViewGroup.b = ((CornerImageView)paramView.findViewById(2131368785));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378797));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368786));
      float f = mww.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(f);
      paramViewGroup.b.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      paramView.setTag(paramViewGroup);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 103.0F));
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 58.0F));
      localObject1 = (ApolloGameData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject2 = URLDrawable.getDrawable(((ApolloGameData)localObject1).listCoverUrl, (URLDrawable.URLDrawableOptions)localObject2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(Integer.valueOf(((ApolloGameData)localObject1).gameId));
      if (!((ApolloGameData)localObject1).isGameApp) {
        break label333;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838384);
    }
    for (;;)
    {
      localObject1 = (String)this.b.get(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      return paramView;
      paramViewGroup = (akvp)paramView.getTag();
      break;
      label333:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvo
 * JD-Core Version:    0.7.0.1
 */