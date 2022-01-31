import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class agyu
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private agyv jdField_a_of_type_Agyv;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public agyu(Context paramContext, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localActionSheetItem = null;
      return localActionSheetItem;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localActionSheetItem != null)
      {
        k = j;
        if (localActionSheetItem.d == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      if ((localActionSheetItem == null) || (localActionSheetItem.d != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131559384));
    }
    if (this.jdField_a_of_type_Agyv == null) {
      this.jdField_a_of_type_Agyv = new agyv(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968797, paramViewGroup, false);
      paramViewGroup = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363788));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363789));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheet", 2, "ShareActionSheet.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_Int);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ShareActionSheet.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_JavaLangString, 6));
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_b_of_type_Boolean)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_Boolean) {
        break label454;
      }
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label397;
      }
      localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label262:
      paramInt = ((Drawable)localObject).getIntrinsicWidth();
      int j = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label416;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label294:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject = this.jdField_a_of_type_Agyv.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_b_of_type_Boolean) {
        break label421;
      }
      Drawable localDrawable = agyv.a(this.jdField_a_of_type_Agyv, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Agyv.a((Drawable)localObject, localDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label444;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return paramView;
      paramInt = 2138535799;
      break;
      label397:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_b_of_type_Int);
      break label262;
      label416:
      paramInt = 0;
      break label294;
      label421:
      localObject = agyv.b(this.jdField_a_of_type_Agyv, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label444:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label454:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837526);
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.jdField_b_of_type_Int);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyu
 * JD-Core Version:    0.7.0.1
 */