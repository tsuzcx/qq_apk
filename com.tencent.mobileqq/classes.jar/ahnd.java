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
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ahnd
  extends ahnw
{
  protected int a;
  private List<String> a;
  
  public ahnd()
  {
    this.jdField_a_of_type_Int = 2131562321;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ahne)))
    {
      paramahpo = (ahne)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramahpo;
      localObject1 = paramContext.getResources();
      paramahpo = ((Resources)localObject1).getColorStateList(2131166931);
      localObject1 = ((Resources)localObject1).getColorStateList(2131166932);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label522;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.d) {
        paramViewGroup.setContentDescription(null);
      }
      if ((paramObject instanceof RecentItemAppletsFolderData))
      {
        paramahpo = (RecentItemAppletsFolderData)paramObject;
        if (paramahnr != null) {
          a(paramViewGroup, paramahpo, paramContext, paramahnr.a(paramahpo.mUser.uin, paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredWidth(), paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredHeight(), paramahpo.iconUrl, paramahpo.iconUrlSimple));
        }
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramView = new ahne();
      paramViewGroup = a(paramContext, this.jdField_a_of_type_Int, paramView);
      paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131367679));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131377350));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131378655));
      paramView.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365042));
      Object localObject2 = paramContext.getResources();
      float f = bbdh.a();
      paramahpo = ((Resources)localObject2).getColorStateList(2131166931);
      localObject1 = ((Resources)localObject2).getColorStateList(2131166861);
      localObject2 = ((Resources)localObject2).getColorStateList(2131166932);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpo, 2);
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramView.b.setTextColor(paramahpo);
        paramView.b.setExtendTextPadding((int)(f * 2.0F), 1);
        paramView.b.setExtendTextSize(14.0F, 1);
        paramViewGroup.setTag(paramView);
        if (this.jdField_a_of_type_Ahmv != null) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahmv.a());
        }
        break;
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpo, 0);
      }
      label522:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpo, 0);
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
    if ((paramView.getTag() instanceof ahne)) {}
    for (ahne localahne = (ahne)paramView.getTag();; localahne = null) {
      for (;;)
      {
        if (localahne == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        localahne.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
        a(localahne.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
        localahne.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
        localahne.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
        try
        {
          localahne.b.setText(paramRecentBaseData.mLastMsg);
          j = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (j > 0) {
            if (i == 0)
            {
              localahne.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              j = 0;
              i = 0;
              bfqs.a(localahne.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
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
              localahne.g.setBackgroundResource(2130839133);
              if (!AppSetting.d) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              paramDrawable = paramDrawable;
              paramDrawable.printStackTrace();
              localahne.b.setText(paramRecentBaseData.mLastMsg + " ");
              continue;
              if (i == 2)
              {
                i = 1;
                localahne.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                j = 0;
                continue;
              }
              i = 3;
              localahne.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              localahne.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166974));
              k = 2130849301;
              continue;
              label340:
              localahne.g.setBackgroundResource(2130839132);
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
 * Qualified Name:     ahnd
 * JD-Core Version:    0.7.0.1
 */