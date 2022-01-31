import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class akck
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new akcl(this);
  private asaw jdField_a_of_type_Asaw;
  protected QQAppInterface a;
  protected List<Object> a;
  
  public akck(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, asaw paramasaw)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramFragmentActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFragmentActivity.getResources().getDrawable(2130844855);
    this.jdField_a_of_type_Asaw = paramasaw;
  }
  
  public void a(List<AppletItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppletItem localAppletItem = (AppletItem)getItem(paramInt);
    if (localAppletItem == null) {
      return paramView;
    }
    Object localObject;
    if (paramView == null)
    {
      paramView = new akcm();
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561252, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131362722));
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject).findViewById(2131362721));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362723));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131362724));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839253);
      localObject = paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch;
      if (localAppletItem.b() != 1) {
        break label301;
      }
    }
    label301:
    for (boolean bool = true;; bool = false)
    {
      ((Switch)localObject).setChecked(bool);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, localAppletItem.toString());
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localAppletItem.a());
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = localAppletItem;
      if (TextUtils.isEmpty(localAppletItem.b())) {
        break label307;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth(), this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject = URLDrawable.getDrawable(localAppletItem.b(), (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramViewGroup = (akcm)paramView.getTag();
      break;
    }
    label307:
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akck
 * JD-Core Version:    0.7.0.1
 */