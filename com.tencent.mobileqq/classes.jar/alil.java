import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class alil
  extends alhd
{
  protected algy a;
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    this.jdField_a_of_type_Algy = paramalgy;
    paramViewGroup = null;
    paramalgy = paramViewGroup;
    if (paramView != null)
    {
      paramalgy = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramalgy = paramViewGroup;
        if ((paramView.getTag() instanceof alin)) {
          paramalgy = (alin)paramView.getTag();
        }
      }
    }
    if (paramalgy == null)
    {
      paramViewGroup = new alin();
      paramalje = super.a(paramContext, 2131561249, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramalje.findViewById(2131368406));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramalje.findViewById(2131379102));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramalje.findViewById(2131380499));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramalje.findViewById(2131371650));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramalje.findViewById(2131371620));
      paramalgy = paramContext.getResources();
      paramView = paramalgy.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramalgy.getDimensionPixelSize(2131298856);
      int k = paramalgy.getDimensionPixelSize(2131298855);
      if (i <= 0)
      {
        i = 45;
        int j = k;
        if (k <= 0) {
          j = 10;
        }
        m /= (i + j);
        k = m;
        if (m > 6) {
          k = 6;
        }
        paramalgy = new alim(this, paramContext, k, i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramalgy);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        paramalje.setTag(paramViewGroup);
        paramView = paramalje;
        paramalgy = paramViewGroup;
        if (this.jdField_a_of_type_Algc != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Algc.a());
          paramalgy = paramViewGroup;
          paramView = paramalje;
        }
      }
    }
    for (;;)
    {
      paramalgy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130845526);
      if ((paramalgy != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramalgy, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramalgy != null)
        {
          paramalgy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
          paramalgy.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramalgy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
      break;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable arg4)
  {
    int i = 0;
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof alin));
    Object localObject = (alin)localObject;
    RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
    ((alin)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(???);
    ((alin)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131698636);
    int k = paramRecentBaseData.mUnreadNum;
    int j = paramRecentBaseData.mUnreadFlag;
    if (k > 0) {
      if (j == 3)
      {
        j = 2130850435;
        ((alin)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
        i = 3;
      }
    }
    for (;;)
    {
      label105:
      blas.a(((alin)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null)
      {
        ??? = ???.toString();
        label148:
        if (!TextUtils.isEmpty(???)) {
          ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(???, 1);
      }
      for (;;)
      {
        synchronized (localRecentSayHelloBoxItem.lock)
        {
          if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
          {
            ((alin)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
            ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
            ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167106));
            if (!AppSetting.c) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.mContentDesc);
            return;
            j = 2130850431;
            ((alin)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            i = 3;
            break label105;
            ??? = "";
            break label148;
          }
          if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
          {
            ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            ((alin)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
            ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167106));
            if (((alin)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() == null) {
              continue;
            }
            alim.a((alim)((alin)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        ((alin)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
        ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
        ((alin)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167106));
      }
      j = 0;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null) || (paramDrawable == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag();
      if ((paramView instanceof alin))
      {
        paramView = (alin)paramView;
        int j = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getCount();
        int i = 0;
        while (i < j)
        {
          paramRecentBaseData = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
          if ((paramRecentBaseData != null) && ((paramRecentBaseData.getTag(-1) instanceof String)))
          {
            String str = (String)paramRecentBaseData.getTag(-1);
            if (str.equals(paramMessageRecord.senderuin))
            {
              ((CustomImgView)paramRecentBaseData).setImageDrawable(paramDrawable);
              return;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SAYHELL_BOX", 4, "updateMsgHeader,childView uin:" + str);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */