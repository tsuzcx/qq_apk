import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.campuscircle.CampusCirclePicBrowserActivity;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.DynamicGridView;
import com.tencent.widget.DynamicGridView.BaseDynamicGridAdapter;
import com.tencent.widget.DynamicGridView.OnDragListener;
import com.tencent.widget.DynamicGridView.OnDropListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class abit
  extends DynamicGridView.BaseDynamicGridAdapter
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DynamicGridView.OnDragListener, DynamicGridView.OnDropListener
{
  final int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  final int b;
  
  public abit(CampusCirclePublishActivity paramCampusCirclePublishActivity, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = false;
    paramInt1 = paramContext.getResources().getDimensionPixelSize(2131559411);
    if (paramInt1 < this.jdField_a_of_type_Int)
    {
      this.b = paramInt1;
      return;
    }
    this.b = this.jdField_a_of_type_Int;
  }
  
  public int a()
  {
    int i = getCount();
    if ((i > 0) && ("add_plus".equals((String)getItem(i - 1)))) {
      return i - 1;
    }
    return i;
  }
  
  public void a()
  {
    int i = getCount();
    int j = a();
    if (j >= 9) {
      d("add_plus");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
      return;
      if ((j == i) && (i < 9)) {
        c("add_plus");
      } else if (i > 9) {
        d("add_plus");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onDragStarted pos: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.a("0X80080A0");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onDragPositionsChanged oldPosition: %d newPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public boolean a(int paramInt)
  {
    int i = a();
    return (paramInt >= 0) && (paramInt < i);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView != null) {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView.a();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970256, null);
    }
    label72:
    URLImageView localURLImageView;
    View localView;
    if ((paramViewGroup.getLayoutParams() instanceof AbsListView.LayoutParams))
    {
      paramView = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
      if (getCount() != 1) {
        break label167;
      }
      paramView.width = this.b;
      paramView.height = this.b;
      paramViewGroup.setLayoutParams(paramView);
      localURLImageView = (URLImageView)paramViewGroup.findViewById(2131363610);
      localView = paramViewGroup.findViewById(2131363502);
      localView.setOnClickListener(this);
      localView.setTag(Integer.valueOf(paramInt));
      if (!"add_plus".equals(str)) {
        break label186;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842302);
      localView.setVisibility(4);
    }
    for (;;)
    {
      localURLImageView.setImageDrawable(paramView);
      return paramViewGroup;
      paramView = new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      break;
      label167:
      paramView.width = this.jdField_a_of_type_Int;
      paramView.height = this.jdField_a_of_type_Int;
      break label72;
      label186:
      if (!TextUtils.isEmpty(str))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = this.jdField_a_of_type_Int;
        paramView.mRequestHeight = this.jdField_a_of_type_Int;
        paramView = URLDrawable.getDrawable(new File(str), paramView);
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = 0;; paramInt = 4)
        {
          localView.setVisibility(paramInt);
          break;
        }
      }
      localView.setVisibility(4);
      paramView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof Integer))
    {
      d(getItem(((Integer)paramView.getTag()).intValue()));
      a();
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.a("0X80080A2");
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onItemClick pos: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt < a())
    {
      paramAdapterView = new ArrayList();
      i = 0;
      if (i < a())
      {
        localObject = (String)getItem(i);
        if ("add_plus".equals(localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          localPicInfo = new PicInfo();
          localPicInfo.c = ((String)localObject);
          paramAdapterView.add(localPicInfo);
        }
      }
      paramView = AnimationUtils.a(paramView);
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, CampusCirclePicBrowserActivity.class);
      ((Intent)localObject).putExtra("intent_param_index", paramInt);
      ((Intent)localObject).putExtra("intent_param_pic_infos", paramAdapterView);
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramView);
      ((Intent)localObject).putExtra("is_forbid_action_sheet", true);
      ((Intent)localObject).addFlags(536870912);
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.startActivityForResult((Intent)localObject, 2);
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.a("0X80080A1");
    }
    while (a() >= 9)
    {
      int i;
      Object localObject;
      PicInfo localPicInfo;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.a("0X8008099");
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    int j = a();
    if (paramInt < j)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        int i = 0;
        while ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView != null) && (i < this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView.getChildCount()) && (i < j))
        {
          paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView.getChildAt(i).findViewById(2131363502);
          if (paramAdapterView != null) {
            paramAdapterView.setVisibility(0);
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView != null) {
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity.jdField_a_of_type_ComTencentWidgetDynamicGridView.a(paramInt);
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abit
 * JD-Core Version:    0.7.0.1
 */