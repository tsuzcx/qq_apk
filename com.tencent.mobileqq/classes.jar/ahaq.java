import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ahaq
  extends ahbj
{
  protected int a;
  private List<String> a;
  
  public ahaq()
  {
    this.jdField_a_of_type_Int = 2131496721;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ahar)))
    {
      paramahdb = (ahar)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramahdb;
      localObject1 = paramContext.getResources();
      paramahdb = ((Resources)localObject1).getColorStateList(2131101336);
      localObject1 = ((Resources)localObject1).getColorStateList(2131101337);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label530;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(null);
      }
      if ((paramObject instanceof RecentItemAppletsFolderData))
      {
        paramahdb = (RecentItemAppletsFolderData)paramObject;
        if (paramahbe != null) {
          a(paramViewGroup, paramahdb, paramContext, paramahbe.a(paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredWidth(), paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredHeight(), paramahdb.iconUrl, paramahdb.iconUrlSimple));
        }
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramahdb = new ahar();
      localObject1 = a(paramContext, this.jdField_a_of_type_Int, paramahdb);
      paramahdb.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject1).findViewById(2131302061));
      paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131311534));
      paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131312826));
      paramahdb.b = ((SingleLineTextView)((View)localObject1).findViewById(2131299475));
      Object localObject2 = paramContext.getResources();
      float f = babp.a();
      paramView = ((Resources)localObject2).getColorStateList(2131101336);
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131101267);
      localObject2 = ((Resources)localObject2).getColorStateList(2131101337);
      paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramahdb.b.setTextColor(paramView);
        paramahdb.b.setExtendTextPadding((int)(f * 2.0F), 1);
        paramahdb.b.setExtendTextSize(14.0F, 1);
        ((View)localObject1).setTag(paramahdb);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramahdb;
        if (this.jdField_a_of_type_Ahai == null) {
          break;
        }
        paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahai.a());
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramahdb;
        break;
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label530:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahdb, 0);
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      j = i & 0xF0;
      if (j != 32) {
        break label115;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label115:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    int k = 0;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof ahar)) {}
    for (ahar localahar = (ahar)paramView.getTag();; localahar = null) {
      for (;;)
      {
        if (localahar == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        localahar.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
        a(localahar.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
        localahar.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
        localahar.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
        try
        {
          localahar.b.setText(paramRecentBaseData.mLastMsg);
          j = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (j > 0) {
            if (i == 0)
            {
              localahar.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              j = 0;
              i = 0;
              beih.a(localahar.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
              if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {
                break label340;
              }
            }
          }
        }
        catch (Exception paramDrawable)
        {
          for (;;)
          {
            try
            {
              localahar.g.setBackgroundResource(2130839105);
              if (!AppSetting.c) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              paramDrawable = paramDrawable;
              paramDrawable.printStackTrace();
              localahar.b.setText(paramRecentBaseData.mLastMsg + " ");
              continue;
              if (i == 2)
              {
                i = 1;
                localahar.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                j = 0;
                continue;
              }
              i = 3;
              localahar.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              localahar.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101379));
              k = 2130849057;
              continue;
              label340:
              localahar.g.setBackgroundResource(2130839104);
              continue;
            }
            catch (Throwable paramContext)
            {
              continue;
            }
            int j = 0;
            int i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahaq
 * JD-Core Version:    0.7.0.1
 */