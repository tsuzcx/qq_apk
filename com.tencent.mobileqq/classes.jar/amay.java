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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class amay
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new amaz(this);
  private aulp jdField_a_of_type_Aulp;
  protected QQAppInterface a;
  protected List<Object> a;
  
  public amay(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, aulp paramaulp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramFragmentActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFragmentActivity.getResources().getDrawable(2130845327);
    this.jdField_a_of_type_Aulp = paramaulp;
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
    Object localObject2 = (AppletItem)getItem(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    label122:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new amba();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561501, paramViewGroup, false);
      ((amba)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362832));
      ((amba)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362831));
      ((amba)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362833));
      ((amba)localObject1).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131362834));
      paramView.setTag(localObject1);
      ((amba)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839432);
      Object localObject3 = ((amba)localObject1).jdField_a_of_type_ComTencentWidgetSwitch;
      if (((AppletItem)localObject2).b() != 1) {
        break label327;
      }
      bool = true;
      label151:
      ((Switch)localObject3).setChecked(bool);
      ((amba)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      ((amba)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, ((AppletItem)localObject2).toString());
      }
      ((amba)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((AppletItem)localObject2).a());
      ((amba)localObject1).jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((AppletItem)localObject2);
      if (TextUtils.isEmpty(((AppletItem)localObject2).b())) {
        break label333;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = afur.a(((amba)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth(), this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject2 = URLDrawable.getDrawable(((AppletItem)localObject2).b(), (URLDrawable.URLDrawableOptions)localObject3);
      ((amba)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      localObject1 = (amba)paramView.getTag();
      break label122;
      label327:
      bool = false;
      break label151;
      label333:
      ((amba)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amay
 * JD-Core Version:    0.7.0.1
 */