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

public class alpc
  extends alnt
{
  protected alno a;
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    this.jdField_a_of_type_Alno = paramalno;
    paramViewGroup = null;
    paramalno = paramViewGroup;
    if (paramView != null)
    {
      paramalno = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramalno = paramViewGroup;
        if ((paramView.getTag() instanceof alpe)) {
          paramalno = (alpe)paramView.getTag();
        }
      }
    }
    if (paramalno == null)
    {
      paramViewGroup = new alpe();
      paramalpv = super.a(paramContext, 2131561313, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramalpv.findViewById(2131368237));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramalpv.findViewById(2131379040));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramalpv.findViewById(2131380440));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramalpv.findViewById(2131371496));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramalpv.findViewById(2131371466));
      paramalno = paramContext.getResources();
      paramView = paramalno.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramalno.getDimensionPixelSize(2131298787);
      int k = paramalno.getDimensionPixelSize(2131298786);
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
        paramalno = new alpd(this, paramContext, k, i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramalno);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        paramalpv.setTag(paramViewGroup);
        paramView = paramalpv;
        paramalno = paramViewGroup;
        if (this.jdField_a_of_type_Alms != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Alms.a());
          paramalno = paramViewGroup;
          paramView = paramalpv;
        }
      }
    }
    for (;;)
    {
      paramalno.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130845562);
      if ((paramalno != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramalno, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramalno != null)
        {
          paramalno.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
          paramalno.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramalno.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
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
    } while (!(localObject instanceof alpe));
    Object localObject = (alpe)localObject;
    RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
    ((alpe)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(???);
    ((alpe)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131698175);
    int k = paramRecentBaseData.mUnreadNum;
    int j = paramRecentBaseData.mUnreadFlag;
    if (k > 0) {
      if (j == 3)
      {
        j = 2130850408;
        ((alpe)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
        i = 3;
      }
    }
    for (;;)
    {
      label105:
      blkk.a(((alpe)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null)
      {
        ??? = ???.toString();
        label148:
        if (!TextUtils.isEmpty(???)) {
          ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(???, 1);
      }
      for (;;)
      {
        synchronized (localRecentSayHelloBoxItem.lock)
        {
          if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
          {
            ((alpe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
            ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
            ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167070));
            if (!AppSetting.c) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.mContentDesc);
            return;
            j = 2130850404;
            ((alpe)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            i = 3;
            break label105;
            ??? = "";
            break label148;
          }
          if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
          {
            ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            ((alpe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
            ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167070));
            if (((alpe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() == null) {
              continue;
            }
            alpd.a((alpd)((alpe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        ((alpe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
        ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
        ((alpe)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167070));
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
      if ((paramView instanceof alpe))
      {
        paramView = (alpe)paramView;
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
 * Qualified Name:     alpc
 * JD-Core Version:    0.7.0.1
 */